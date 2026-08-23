package com.dw.launcher.manager;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.TodayDataList;
import com.dw.launcher.data.listener.HealthMeausureListener;
import com.dw.launcher.util.ACache;
import com.dw.launcher.util.FileUtils;
import com.dw.launcher.util.ServerUtil;
import com.google.gson.Gson;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public class OxygenManager {
    private static final String CACHE_KEY = "todayDataList";
    private static final long DELAY_TIME = 30000;
    private static final int MESSAGE_ID = 0;
    private static final int MESSAGE_START = 1;
    private static final String TAG = "OxygenManager";
    private static OxygenManager bloodPressureManager;
    private static final OxygenManager instance = new OxygenManager();
    private Context context;
    private HealthMeausureListener healthMeausureListener;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private PowerManager.WakeLock wakeLock;
    private int heartValue = 0;
    private boolean isMeasuring = false;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.dw.launcher.manager.OxygenManager$$ExternalSyntheticLambda0
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f$0.m242lambda$new$0$comdwlaunchermanagerOxygenManager(message);
        }
    });
    private final SensorEventListener mDataListener = new SensorEventListener() { // from class: com.dw.launcher.manager.OxygenManager.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent event) {
            if (event == null || event.values == null || event.values.length <= 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < event.values.length; i++) {
                sb.append("values[" + i + "] = " + event.values[i] + "    ");
            }
            Log.d(OxygenManager.TAG, sb.toString());
            int i2 = (int) event.values[0];
            float f = event.values[2];
            if (i2 == 0) {
                OxygenManager.this.mHandler.removeMessages(0);
                OxygenManager.this.healthMeausureListener.onError(1);
                OxygenManager.this.isMeasuring = false;
                return;
            }
            OxygenManager.this.healthMeausureListener.onError(0);
            if (!OxygenManager.this.isMeasuring) {
                OxygenManager.this.healthMeausureListener.onstart();
                OxygenManager.this.isMeasuring = true;
                OxygenManager.this.mHandler.removeMessages(0);
                OxygenManager.this.mHandler.sendEmptyMessageDelayed(0, OxygenManager.DELAY_TIME);
            }
            if (f > 0.0f) {
                OxygenManager.this.heartValue = (int) f;
                OxygenManager.this.healthMeausureListener.onHealthMeausure(OxygenManager.this.heartValue, 0);
            }
        }
    };

    /* JADX INFO: renamed from: lambda$new$0$com-dw-launcher-manager-OxygenManager, reason: not valid java name */
    /* synthetic */ boolean m242lambda$new$0$comdwlaunchermanagerOxygenManager(Message message) {
        if (message.what == 0) {
            stopMonitoring();
        } else if (message.what == 1) {
            startMonitoring();
        }
        return true;
    }

    private OxygenManager() {
    }

    public static OxygenManager getInstance() {
        if (bloodPressureManager == null) {
            synchronized (OxygenManager.class) {
                if (bloodPressureManager == null) {
                    bloodPressureManager = new OxygenManager();
                }
            }
        }
        return bloodPressureManager;
    }

    public void start(Context context, HealthMeausureListener healthMeausureListener) {
        Log.d(TAG, "manager start");
        this.context = context;
        this.isMeasuring = false;
        this.healthMeausureListener = healthMeausureListener;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(805306394, "oxygen_test");
            this.wakeLock = wakeLockNewWakeLock;
            wakeLockNewWakeLock.acquire();
        }
        if (this.mSensorManager == null) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.mSensorManager = sensorManager;
            this.mSensor = sensorManager.getDefaultSensor(65596);
            Log.d(TAG, "mSensor = " + this.mSensor + " port = 65596");
        }
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 2000L);
    }

    public void start(Context context, boolean wakeup, HealthMeausureListener healthMeausureListener) {
        Log.d(TAG, "manager start");
        this.context = context;
        this.isMeasuring = false;
        this.healthMeausureListener = healthMeausureListener;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null && wakeup) {
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(805306394, "oxygen_test");
            this.wakeLock = wakeLockNewWakeLock;
            wakeLockNewWakeLock.acquire();
        }
        if (this.mSensorManager == null) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.mSensorManager = sensorManager;
            this.mSensor = sensorManager.getDefaultSensor(65596);
            Log.d(TAG, "mSensor = " + this.mSensor + " port = 65596");
        }
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 2000L);
    }

    private void startMonitoring() {
        this.mHandler.sendEmptyMessageDelayed(0, DELAY_TIME);
        this.mSensorManager.registerListener(this.mDataListener, this.mSensor, 3);
        Settings.Global.putInt(this.context.getContentResolver(), "health_measure_status", 1);
    }

    public void stop() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.mDataListener);
        }
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(0);
        Log.d(TAG, "manager stop");
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.wakeLock.release();
        }
        this.isMeasuring = false;
        HealthMeausureListener healthMeausureListener = this.healthMeausureListener;
        if (healthMeausureListener != null) {
            healthMeausureListener.onstop();
        }
        Settings.Global.putInt(this.context.getContentResolver(), "health_measure_status", 0);
    }

    private void stopMonitoring() {
        try {
            PowerManager.WakeLock wakeLock = this.wakeLock;
            if (wakeLock != null && wakeLock.isHeld()) {
                this.wakeLock.release();
            }
            this.mSensorManager.unregisterListener(this.mDataListener);
            Settings.Global.putInt(this.context.getContentResolver(), "health_measure_status", 0);
            TodayDataList fromCache = readFromCache(this.context);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            replaceValueAtIndex(calendar.get(11), this.heartValue, fromCache);
            int i = this.heartValue;
            if (i > 60 && i <= 100) {
                saveToCache(this.context, fromCache);
                Settings.Global.putInt(this.context.getContentResolver(), "last_oxygen_value", this.heartValue);
            }
            ServerUtil.reportOxygenServer(this.context, this.heartValue + BuildConfig.FLAVOR);
            this.healthMeausureListener.onFinish(fromCache);
            this.isMeasuring = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearIfNewDay(Context context) {
        ACache aCache = ACache.get(context);
        String asString = aCache.getAsString("last_clear_date");
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        if (asString == null || !asString.equals(str)) {
            saveToCache(context, new TodayDataList());
            aCache.put("last_clear_date", str);
        }
    }

    public TodayDataList readFromCache(Context context) {
        clearIfNewDay(context);
        FileUtils fileUtils = FileUtils.INSTANCE;
        String asString = ACache.get(new File(FileUtils.getOxygen_Save_Path())).getAsString(CACHE_KEY);
        if (asString == null) {
            return new TodayDataList();
        }
        TodayDataList todayDataList = (TodayDataList) new Gson().fromJson(asString, TodayDataList.class);
        return todayDataList != null ? todayDataList : new TodayDataList();
    }

    private void saveToCache(Context context, TodayDataList todayDataList) {
        FileUtils fileUtils = FileUtils.INSTANCE;
        ACache.get(new File(FileUtils.getOxygen_Save_Path())).put(CACHE_KEY, new Gson().toJson(todayDataList));
    }

    private void replaceValueAtIndex(int index, int sysValue, TodayDataList todayDataList) {
        if (todayDataList.getIndexList().contains(Integer.valueOf(index))) {
            todayDataList.getValueList().set(todayDataList.getIndexList().indexOf(Integer.valueOf(index)), Integer.valueOf(sysValue));
        } else {
            todayDataList.getIndexList().add(Integer.valueOf(index));
            todayDataList.getValueList().add(Integer.valueOf(sysValue));
        }
    }
}
