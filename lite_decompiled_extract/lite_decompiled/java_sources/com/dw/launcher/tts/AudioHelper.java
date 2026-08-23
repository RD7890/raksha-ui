package com.dw.launcher.tts;

import android.media.AudioManager;
import android.util.Log;
import com.dw.launcher.LauncherApplication;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public class AudioHelper {
    private static final String TAG = "[lkang-launcher-audio]";

    public static int getMaxMediaVolume() {
        AudioManager audioManager = (AudioManager) LauncherApplication.INSTANCE.getInstance().getSystemService("audio");
        int streamMaxVolume = audioManager.getStreamMaxVolume(4);
        if (audioManager.isBluetoothA2dpOn()) {
            streamMaxVolume = audioManager.getStreamMaxVolume(3);
        }
        Log.i(TAG, "maxMediaVolume > " + streamMaxVolume);
        return streamMaxVolume;
    }

    public static int getMediaVolume() {
        AudioManager audioManager = (AudioManager) LauncherApplication.INSTANCE.getInstance().getSystemService("audio");
        int streamVolume = audioManager.getStreamVolume(4);
        if (audioManager.isBluetoothA2dpOn()) {
            streamVolume = audioManager.getStreamVolume(3);
        }
        Log.i(TAG, "mediaVolume > " + streamVolume);
        return streamVolume;
    }

    public static void setMediaVolume(int volume) {
        AudioManager audioManager = (AudioManager) LauncherApplication.INSTANCE.getInstance().getSystemService("audio");
        if (audioManager != null) {
            Log.i(TAG, "setMediaVolume > " + volume);
            audioManager.setStreamVolume(4, volume, 4);
            if (audioManager.isBluetoothA2dpOn()) {
                audioManager.setStreamVolume(3, volume, 4);
            }
        }
    }
}
