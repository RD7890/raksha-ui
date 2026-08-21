package com.rohan.raksha

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rohan.raksha.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val handler = Handler(Looper.getMainLooper())
    private val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    private val dateFormat = SimpleDateFormat("EEEE, d MMM", Locale.getDefault())

    private val updateTimeTask = object : Runnable {
        override fun run() {
            val now = Date()
            binding.tvClock.text = timeFormat.format(now)
            binding.tvDate.text = dateFormat.format(now)
            handler.postDelayed(this, 1000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadApps()
    }

    override fun onResume() {
        super.onResume()
        handler.post(updateTimeTask)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(updateTimeTask)
    }

    private fun loadApps() {
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

        binding.rvApps.layoutManager = LinearLayoutManager(this)
        binding.rvApps.adapter = AppAdapter(appList) { app ->
            launchApp(app.packageName)
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
        // Do nothing on back button to stay in launcher
    }
}
