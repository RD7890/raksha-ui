package com.raksha.ui

import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity

abstract class EdgeBackActivity : AppCompatActivity() {

    private var downX = 0f
    private var downY = 0f
    private var fromLeftEdge = false
    private var tracking = false

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        when (ev.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                val width = resources.displayMetrics.widthPixels
                val edge = width / 6f
                downX = ev.x
                downY = ev.y
                tracking = ev.x < edge || ev.x > width - edge
                fromLeftEdge = ev.x < width / 2f
            }
            MotionEvent.ACTION_UP -> {
                if (tracking) {
                    val dx = ev.x - downX
                    val dy = Math.abs(ev.y - downY)
                    val minSwipe = resources.displayMetrics.widthPixels / 3.5f
                    val swipedInward = if (fromLeftEdge) dx > minSwipe else -dx > minSwipe
                    if (swipedInward && dy < minSwipe) {
                        tracking = false
                        onBackPressed()
                        return true
                    }
                }
                tracking = false
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}
