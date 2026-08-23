package com.dw.launcher.core.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.dw.launcher.manager.WeatherManager;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public class WeatherUpdateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i("weather update", "weather update 接收到广播");
        if ("com.divo.weather.update".equals(intent.getAction())) {
            Log.i("weather update", "weather update 完成");
            WeatherManager.INSTANCE.queryWeatherData(context);
        }
    }
}
