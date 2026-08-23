package com.raksha.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView

class DashboardActivity : EdgeBackActivity() {

    private data class Tile(val title: String, val subtitle: String, val intent: Intent?)

    private lateinit var adapter: TileAdapter

    private val batteryReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            if (level != -1 && scale != -1) {
                adapter.batterySubtitle = "${(level * 100) / scale}%"
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val tiles = listOf(
            Tile(getString(R.string.tile_battery), "", null),
            Tile(getString(R.string.tile_wifi), getString(R.string.tile_settings),
                Intent(Settings.ACTION_WIRELESS_SETTINGS)),
            Tile(getString(R.string.tile_bluetooth), getString(R.string.tile_settings),
                Intent(Settings.ACTION_BLUETOOTH_SETTINGS)),
            Tile(getString(R.string.tile_display), getString(R.string.tile_settings),
                Intent(Settings.ACTION_DISPLAY_SETTINGS)),
            Tile(getString(R.string.tile_sound), getString(R.string.tile_settings),
                Intent(Settings.ACTION_SOUND_SETTINGS)),
            Tile(getString(R.string.tile_apps), getString(R.string.tile_settings),
                Intent(Settings.ACTION_APPLICATION_SETTINGS))
        )
        adapter = TileAdapter(tiles)
        findViewById<GridView>(R.id.gridTiles).adapter = adapter
        registerReceiver(batteryReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            unregisterReceiver(batteryReceiver)
        } catch (e: Exception) {
        }
    }

    private inner class TileAdapter(private val tiles: List<Tile>) : BaseAdapter() {

        var batterySubtitle: String = ""

        override fun getCount() = tiles.size
        override fun getItem(position: Int) = tiles[position]
        override fun getItemId(position: Int) = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(this@DashboardActivity)
                .inflate(R.layout.item_tile, parent, false)
            val tile = tiles[position]
            val title = view.findViewById<TextView>(R.id.tvTileTitle)
            val subtitle = view.findViewById<TextView>(R.id.tvTileSubtitle)
            if (tile.intent == null) {
                title.text = tile.title
                subtitle.text = batterySubtitle
            } else {
                title.text = tile.title
                subtitle.text = tile.subtitle
            }
            view.setOnClickListener {
                tile.intent?.let { intent ->
                    @Suppress("DEPRECATION")
                    startActivity(Intent(intent).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
                }
            }
            return view
        }
    }
}
