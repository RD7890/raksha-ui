package com.raksha.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
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

        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {}

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // slideOffset goes from 0.0 (hidden) to 1.0 (expanded)
                // Fade out the home screen so the time is hidden when app drawer opens
                binding.homeScreen.alpha = 1f - slideOffset
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
    }

    private fun loadAppsOptimized() {
        binding.rvApps.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch(Dispatchers.Default) {
            val intent = Intent(Intent.ACTION_MAIN, null)
            intent.addCategory(Intent.CATEGORY_LAUNCHER)

            val apps = packageManager.queryIntentActivities(intent, 0)
            val appList = apps.mapNotNull { info ->
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
                binding.rvApps.adapter = AppAdapter(appList) { app ->
                    launchApp(app.packageName)
                }
            }
        }
    }

    private fun launchApp(packageName: String) {
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        val bottomSheetBehavior = BottomSheetBehavior.from(binding.rvApps)
        if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
        // Do nothing else on back button to stay in launcher
    }
}
