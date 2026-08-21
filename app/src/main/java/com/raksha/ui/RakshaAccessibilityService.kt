package com.raksha.ui

import android.accessibilityservice.AccessibilityService
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.view.accessibility.AccessibilityEvent
import android.os.Build

class RakshaAccessibilityService : AccessibilityService() {

    private val recentsReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == ACTION_OPEN_RECENTS) {
                performGlobalAction(GLOBAL_ACTION_RECENTS)
            }
        }
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        val filter = IntentFilter(ACTION_OPEN_RECENTS)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(recentsReceiver, filter, Context.RECEIVER_NOT_EXPORTED)
        } else {
            registerReceiver(recentsReceiver, filter)
        }
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // We don't need to listen to events, just perform global actions
    }

    override fun onInterrupt() {
        // Nothing to do
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            unregisterReceiver(recentsReceiver)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        const val ACTION_OPEN_RECENTS = "com.raksha.ui.OPEN_RECENTS"
    }
}
