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
import com.dw.launcher.BuildConfig;
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
public class HeartRateManager {
    private static final String CACHE_KEY = "todayDataList";
    private static final long DELAY_TIME = 30000;
    private static final int MESSAGE_ID = 0;
    private static final int MESSAGE_START = 1;
    private static HeartRateManager bloodPressureManager;
    private static final HeartRateManager instance = new HeartRateManager();
    private Context context;
    private HealthMeausureListener healthMeausureListener;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private PowerManager.WakeLock wakeLock;
    private int heartValue = 0;
    private boolean isMeasuring = false;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.dw.launcher.manager.HeartRateManager$$ExternalSyntheticLambda0
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f$0.m241lambda$new$0$comdwlaunchermanagerHeartRateManager(message);
        }
    });
    private final SensorEventListener mDataListener = new SensorEventListener() { // from class: com.dw.launcher.manager.HeartRateManager.1
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
            float f = event.values[1];
            if (0.0f == event.values[0]) {
                HeartRateManager.this.healthMeausureListener.onError(1);
                HeartRateManager.this.isMeasuring = false;
                if (HeartRateManager.this.mHandler == null || !HeartRateManager.this.mHandler.hasMessages(0)) {
                    return;
                }
                HeartRateManager.this.mHandler.removeMessages(0);
                return;
            }
            HeartRateManager.this.healthMeausureListener.onError(0);
            if (!HeartRateManager.this.isMeasuring) {
                HeartRateManager.this.healthMeausureListener.onstart();
                HeartRateManager.this.isMeasuring = true;
                HeartRateManager.this.mHandler.removeMessages(0);
                HeartRateManager.this.mHandler.sendEmptyMessageDelayed(0, HeartRateManager.DELAY_TIME);
            }
            if (f <= 0.0f) {
                return;
            }
            HeartRateManager.this.heartValue = (int) f;
            HeartRateManager.this.healthMeausureListener.onHealthMeausure(HeartRateManager.this.heartValue, 0);
        }
    };

    /* JADX INFO: renamed from: lambda$new$0$com-dw-launcher-manager-HeartRateManager, reason: not valid java name */
    /* synthetic */ boolean m241lambda$new$0$comdwlaunchermanagerHeartRateManager(Message message) {
        if (message.what == 0) {
            stopMonitoring();
        } else if (message.what == 1) {
            startMonitoring();
        }
        return true;
    }

    private HeartRateManager() {
    }

    public static HeartRateManager getInstance() {
        if (bloodPressureManager == null) {
            synchronized (HeartRateManager.class) {
                if (bloodPressureManager == null) {
                    bloodPressureManager = new HeartRateManager();
                }
            }
        }
        return bloodPressureManager;
    }

    public void start(Context context, HealthMeausureListener healthMeausureListener) {
        Log.d("BloodPressureManager", "manager start");
        this.context = context;
        this.isMeasuring = false;
        this.healthMeausureListener = healthMeausureListener;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(805306394, BuildConfig.APPLICATION_ID);
            this.wakeLock = wakeLockNewWakeLock;
            wakeLockNewWakeLock.acquire();
        }
        if (this.mSensorManager == null) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.mSensorManager = sensorManager;
            this.mSensor = sensorManager.getDefaultSensor(65599);
            Log.d("BloodPressureManager", "mSensor = " + this.mSensor);
        }
        Log.d("BloodPressureManager", "mSensor = " + this.mSensor);
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 2000L);
    }

    public void start(Context context, boolean wakeup, HealthMeausureListener healthMeausureListener) {
        Log.d("BloodPressureManager", "manager start");
        this.context = context;
        this.isMeasuring = false;
        this.healthMeausureListener = healthMeausureListener;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null && wakeup) {
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(805306394, BuildConfig.APPLICATION_ID);
            this.wakeLock = wakeLockNewWakeLock;
            wakeLockNewWakeLock.acquire();
        }
        if (this.mSensorManager == null) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.mSensorManager = sensorManager;
            this.mSensor = sensorManager.getDefaultSensor(65599);
            Log.d("BloodPressureManager", "mSensor = " + this.mSensor + " port = ");
        }
        Log.d("BloodPressureManager", "mSensor = " + this.mSensor + " port = ");
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 2000L);
    }

    private void startMonitoring() {
        this.mHandler.sendEmptyMessageDelayed(0, DELAY_TIME);
        this.mSensorManager.registerListener(this.mDataListener, this.mSensor, 3);
        Settings.Global.putInt(this.context.getContentResolver(), "health_measure_status", 1);
    }

    public void stop() {
        Log.d("BloodPressureManager", "manager stop");
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.wakeLock.release();
        }
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.mDataListener);
        }
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(0);
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
            if (i > 40 && i < 220) {
                saveToCache(this.context, fromCache);
                Settings.Global.putInt(this.context.getContentResolver(), "last_heart_value", this.heartValue);
            }
            ServerUtil.reportHeartServer(this.context, String.valueOf(this.heartValue));
            this.healthMeausureListener.onFinish(fromCache);
            this.isMeasuring = false;
            Log.d("BloodPressureManager", "manager  heartValue = " + this.heartValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearIfNewDay(Context context) {
        FileUtils fileUtils = FileUtils.INSTANCE;
        ACache aCache = ACache.get(new File(FileUtils.getHeart_Save_Path()));
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
        String asString = ACache.get(new File(FileUtils.getHeart_Save_Path())).getAsString(CACHE_KEY);
        if (asString == null) {
            return new TodayDataList();
        }
        TodayDataList todayDataList = (TodayDataList) new Gson().fromJson(asString, TodayDataList.class);
        return todayDataList != null ? todayDataList : new TodayDataList();
    }

    private void saveToCache(Context context, TodayDataList todayDataList) {
        FileUtils fileUtils = FileUtils.INSTANCE;
        ACache.get(new File(FileUtils.getHeart_Save_Path())).put(CACHE_KEY, new Gson().toJson(todayDataList));
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
