package com.raksha.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.GestureDetector
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.raksha.ui.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val handler = Handler(Looper.getMainLooper())
    private val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    private val dateFormat = SimpleDateFormat("EEE   MM/dd", Locale.getDefault())

    private val wallpaperFile by lazy { File(filesDir, "custom_wallpaper.jpg") }
    private var allAppsList: List<AppInfo> = emptyList()
    
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>
    private lateinit var controlCenter: LinearLayout
    private lateinit var gestureDetector: GestureDetector
    private var isControlCenterVisible = false

    private val updateTimeTask = object : Runnable {
        override fun run() {
            val now = Date()
            binding.tvClock.text = timeFormat.format(now)
            binding.tvDate.text = dateFormat.format(now).uppercase()
            handler.postDelayed(this, 1000)
        }
    }

    private val pickWallpaperLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK && result.data?.data != null) {
            val uri = result.data!!.data!!
            lifecycleScope.launch(Dispatchers.IO) {
                try {
                    contentResolver.openInputStream(uri)?.use { input ->
                        FileOutputStream(wallpaperFile).use { output ->
                            input.copyTo(output)
                        }
                    }
                    loadWallpaper()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadWallpaper()
        setupBottomSheetAndGestures()
        loadAppsOptimized()
    }

    private fun loadWallpaper() {
        lifecycleScope.launch(Dispatchers.IO) {
            if (wallpaperFile.exists()) {
                val bitmap = BitmapFactory.decodeFile(wallpaperFile.absolutePath)
                withContext(Dispatchers.Main) {
                    binding.ivWallpaper.setImageBitmap(bitmap)
                    binding.tvHint.visibility = View.GONE
                }
            } else {
                withContext(Dispatchers.Main) {
                    binding.tvHint.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        handler.post(updateTimeTask)
        binding.rvApps.requestFocus()
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(updateTimeTask)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupBottomSheetAndGestures() {
        val bottomSheetBehavior = BottomSheetBehavior.from(binding.rvApps)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        bottomSheetBehavior.peekHeight = 0
        bottomSheetBehavior.isHideable = true
        bottomSheetBehavior.skipCollapsed = true

        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    binding.rvApps.requestFocus()
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                binding.homeScreen.alpha = 1f - slideOffset
                // dim overlay grows to 0.3 alpha as drawer opens
                binding.vDimOverlay.alpha = slideOffset * 0.3f
            }
        })

        val gestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
            override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
                if (e1 != null && e1.y - e2.y > 50 && Math.abs(velocityY) > 100) {
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                    return true
                }
                return false
            }

            override fun onScroll(e1: MotionEvent?, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
                if (distanceY > 10) {
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                    return true
                }
                return false
            }

            override fun onLongPress(e: MotionEvent) {
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                pickWallpaperLauncher.launch(intent)
            }
        })

        binding.homeScreen.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
            true
        }

        binding.btnAppDrawer.setOnClickListener {
            binding.rvApps.adapter = AppAdapter(allAppsList) { app ->
                launchApp(app.packageName)
            }
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        binding.btnRecents.setOnClickListener {
            openSystemRecentApps()
        }
        
        // Setup Control Center
        controlCenter = findViewById(R.id.controlCenter)
        setupControlCenter()
        
        // Setup Swipe Down Gesture
        gestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
            override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
                if (e1 != null && e2 != null) {
                    val diffY = e2.y - e1.y
                    if (diffY > 100 && Math.abs(velocityY) > 100) {
                        showControlCenter()
                        return true
                    } else if (diffY < -100 && Math.abs(velocityY) > 100) {
                        hideControlCenter()
                        return true
                    }
                }
                return false
            }
        })
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        gestureDetector.onTouchEvent(ev)
        return super.dispatchTouchEvent(ev)
    }
    
    private fun showControlCenter() {
        if (!isControlCenterVisible) {
            controlCenter.animate().translationY(0f).setDuration(300).start()
            isControlCenterVisible = true
        }
    }
    
    private fun hideControlCenter() {
        if (isControlCenterVisible) {
            controlCenter.animate().translationY(-2000f).setDuration(300).start()
            isControlCenterVisible = false
        }
    }

    private fun setupControlCenter() {
        findViewById<ImageView>(R.id.btnSettings).setOnClickListener {
            startActivity(Intent(android.provider.Settings.ACTION_SETTINGS))
            hideControlCenter()
        }
        findViewById<ImageView>(R.id.btnWifi).setOnClickListener {
            startActivity(Intent(android.provider.Settings.ACTION_WIFI_SETTINGS))
            hideControlCenter()
        }
        findViewById<ImageView>(R.id.btnBluetooth).setOnClickListener {
            startActivity(Intent(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS))
            hideControlCenter()
        }
        findViewById<ImageView>(R.id.btnDnd).setOnClickListener {
            startActivity(Intent(android.provider.Settings.ACTION_SOUND_SETTINGS))
            hideControlCenter()
        }
    }

    private fun loadAppsOptimized() {
        val lm = LinearLayoutManager(this)
        lm.isItemPrefetchEnabled = true
        binding.rvApps.layoutManager = lm
        binding.rvApps.setHasFixedSize(true)
        binding.rvApps.setItemViewCacheSize(30)
        binding.rvApps.isNestedScrollingEnabled = true   // MUST be true for BottomSheet scroll to work correctly
        binding.rvApps.overScrollMode = View.OVER_SCROLL_NEVER

        lifecycleScope.launch(Dispatchers.Default) {
            val intent = Intent(Intent.ACTION_MAIN, null)
            intent.addCategory(Intent.CATEGORY_LAUNCHER)

            val apps = packageManager.queryIntentActivities(intent, 0)
            allAppsList = apps.mapNotNull { info ->
                try {
                    AppInfo(
                        name = info.loadLabel(packageManager),
                        packageName = info.activityInfo.packageName,
                        icon = info.activityInfo.loadIcon(packageManager)
                    )
                } catch (e: Exception) {
                    null
                }
            }.sortedBy { it.name.toString() }

            withContext(Dispatchers.Main) {
                binding.rvApps.adapter = AppAdapter(allAppsList) { app ->
                    launchApp(app.packageName)
                }
            }
        }
    }

    private fun openSystemRecentApps() {
        if (isAccessibilityEnabled()) {
            sendBroadcast(Intent(RakshaAccessibilityService.ACTION_OPEN_RECENTS))
        } else {
            android.widget.Toast.makeText(this, "Please enable Raksha UI in Accessibility to use Recent Apps", android.widget.Toast.LENGTH_LONG).show()
            try {
                val intent = Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun isAccessibilityEnabled(): Boolean {
        val expectedComponentName = android.content.ComponentName(this, RakshaAccessibilityService::class.java).flattenToString()
        val enabledServicesSetting = android.provider.Settings.Secure.getString(contentResolver, android.provider.Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES) ?: return false
        val colonSplitter = android.text.TextUtils.SimpleStringSplitter(':')
        colonSplitter.setString(enabledServicesSetting)
        while (colonSplitter.hasNext()) {
            val componentName = colonSplitter.next()
            if (componentName.equals(expectedComponentName, ignoreCase = true)) {
                return true
            }
        }
        return false
    }

    private fun launchApp(packageName: String) {
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        val behavior = BottomSheetBehavior.from(binding.rvApps)
        return when (keyCode) {
            KeyEvent.KEYCODE_BACK -> {
                // Close drawer if open; otherwise let event through for screen lock
                if (behavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.state = BottomSheetBehavior.STATE_HIDDEN
                    true
                } else {
                    // Don't call super.onBackPressed — just block launcher exit.
                    // The watch firmware handles screen-off at a lower level.
                    true
                }
            }
            KeyEvent.KEYCODE_VOLUME_UP -> {
                if (behavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                } else {
                    binding.rvApps.smoothScrollBy(0, -120)
                }
                true
            }
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                if (behavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                } else {
                    binding.rvApps.smoothScrollBy(0, 120)
                }
                true
            }
            KeyEvent.KEYCODE_ENTER, KeyEvent.KEYCODE_DPAD_CENTER -> {
                if (behavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                    true
                } else {
                    super.onKeyDown(keyCode, event)
                }
            }
            else -> super.onKeyDown(keyCode, event)
        }
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        // Intercept BACK and MENU before the focused view (RecyclerView) can eat it.
        // Many Chinese watches map the long/side button to KEYCODE_BACK or KEYCODE_MENU.
        if (event.action == KeyEvent.ACTION_DOWN) {
            val behavior = BottomSheetBehavior.from(binding.rvApps)
            when (event.keyCode) {
                KeyEvent.KEYCODE_BACK, KeyEvent.KEYCODE_MENU -> {
                    if (behavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                        behavior.state = BottomSheetBehavior.STATE_HIDDEN
                        return true
                    }
                    // Drawer closed: consume BACK to stay in launcher.
                    // MENU: let through so system menu can appear.
                    if (event.keyCode == KeyEvent.KEYCODE_BACK) return true
                }
            }
        }
        return super.dispatchKeyEvent(event)
    }

    override fun dispatchGenericMotionEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_SCROLL) {
            val vScroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL)
            if (vScroll != 0f) {
                val behavior = BottomSheetBehavior.from(binding.rvApps)
                if (behavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                } else {
                    binding.rvApps.scrollBy(0, (-vScroll * 60).toInt())
                }
                return true
            }
        }
        return super.dispatchGenericMotionEvent(event)
    }
}
