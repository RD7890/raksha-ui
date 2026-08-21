package com.raksha.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import android.os.BatteryManager
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ChargeActivity : AppCompatActivity() {

    private lateinit var batteryPercent: TextView
    private lateinit var timeView: TextView
    private var mediaPlayer: MediaPlayer? = null
    
    private val powerReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == Intent.ACTION_POWER_DISCONNECTED) {
                finish() // Close when unplugged
            } else if (intent?.action == Intent.ACTION_BATTERY_CHANGED) {
                val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
                if (level != -1 && scale != -1) {
                    val p = (level * 100) / scale
                    batteryPercent.text = "${p}%"
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charge)
        
        val chargeBg = findViewById<ImageView>(R.id.charge_bg)
        batteryPercent = findViewById(R.id.battery_percent)
        timeView = findViewById(R.id.time)
        
        // Load GIF using Glide
        Glide.with(this)
            .asGif()
            .load(R.drawable.icon_charge_hight)
            .into(chargeBg)
            
        // Update Time
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        timeView.text = sdf.format(Date())
        
        // Play Sound
        try {
            mediaPlayer = MediaPlayer.create(this, R.raw.charge_tips)
            mediaPlayer?.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        
        // Register receiver for battery updates and disconnect event
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(Intent.ACTION_BATTERY_CHANGED)
        }
        registerReceiver(powerReceiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(powerReceiver)
        mediaPlayer?.release()
    }
}
