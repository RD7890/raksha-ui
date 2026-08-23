package com.raksha.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecentsActivity : EdgeBackActivity() {

    private lateinit var tvEmpty: TextView
    private lateinit var rvRecents: RecyclerView
    private lateinit var soundManager: SoundManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recents)

        soundManager = SoundManager(this)
        tvEmpty = findViewById(R.id.tvEmpty)
        rvRecents = findViewById(R.id.rvRecents)
        rvRecents.layoutManager = LinearLayoutManager(this)
        loadApps()
    }

    private fun loadApps() {
        lifecycleScope.launch(Dispatchers.Default) {
            val pm = packageManager
            val apps = RecentsStore.history(this@RecentsActivity).mapNotNull { pkg ->
                try {
                    pm.getLaunchIntentForPackage(pkg)?.let {
                        AppInfo(
                            name = pm.getApplicationLabel(pm.getApplicationInfo(pkg, 0)),
                            packageName = pkg,
                            icon = pm.getApplicationIcon(pkg)
                        )
                    }
                } catch (e: Exception) {
                    null
                }
            }

            withContext(Dispatchers.Main) {
                tvEmpty.visibility = if (apps.isEmpty()) View.VISIBLE else View.GONE
                rvRecents.adapter = AppAdapter(
                    apps,
                    onClick = { app -> launchApp(app.packageName) },
                    onLongClick = { app ->
                        RecentsStore.remove(this@RecentsActivity, app.packageName)
                        loadApps()
                    }
                )
            }
        }
    }

    private fun launchApp(packageName: String) {
        soundManager.playDingSound()
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        if (intent != null) {
            RecentsStore.record(this, packageName)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
