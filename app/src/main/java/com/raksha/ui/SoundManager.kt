package com.raksha.ui

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool

class SoundManager(context: Context) {
    private val soundPool: SoundPool
    
    private var soundCharge: Int = 0
    private var soundWheel: Int = 0
    private var soundClick: Int = 0
    private var soundAlarm: Int = 0
    
    init {
        val audioAttr = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
            
        soundPool = SoundPool.Builder()
            .setMaxStreams(5)
            .setAudioAttributes(audioAttr)
            .build()
            
        soundCharge = soundPool.load(context, R.raw.charge_tips, 1)
        soundWheel = soundPool.load(context, R.raw.wheel, 1)
        soundClick = soundPool.load(context, R.raw.click, 1)
        soundAlarm = soundPool.load(context, R.raw.alarm3, 1)
    }
    
    fun playChargeSound() {
        soundPool.play(soundCharge, 1f, 1f, 1, 0, 1f)
    }
    
    fun playWheelSound() {
        soundPool.play(soundWheel, 0.2f, 0.2f, 1, 0, 1f)
    }
    
    fun playDingSound() {
        soundPool.play(soundClick, 1f, 1f, 1, 0, 1f)
    }
}
