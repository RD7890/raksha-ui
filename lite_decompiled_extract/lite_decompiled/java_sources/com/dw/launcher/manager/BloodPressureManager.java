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
import androidx.core.app.NotificationCompat;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.TodayBloodPressureList;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BloodPressureManager.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00103\u001a\u0002042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u00105\u001a\u0002062\u0006\u0010\u0007\u001a\u00020\bJ(\u00107\u001a\u0002042\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u000206H\u0002J\u0018\u0010<\u001a\u0002042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010;\u001a\u000206H\u0002J$\u0010=\u001a\u0002042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010>\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010?\u001a\u000204H\u0002J\u0006\u0010@\u001a\u000204J\b\u0010A\u001a\u000204H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010,\u001a\b\u0018\u00010-R\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006C"}, d2 = {"Lcom/dw/launcher/manager/BloodPressureManager;", BuildConfig.FLAVOR, "()V", "DeFault_Port", BuildConfig.FLAVOR, "getDeFault_Port", "()I", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "diaBloodPress", "healthMeausureListener", "Lcom/dw/launcher/data/listener/HealthMeausureListener;", "getHealthMeausureListener", "()Lcom/dw/launcher/data/listener/HealthMeausureListener;", "setHealthMeausureListener", "(Lcom/dw/launcher/data/listener/HealthMeausureListener;)V", "isMeasureing", BuildConfig.FLAVOR, "()Z", "setMeasureing", "(Z)V", "isSupportYunmiServer", "isSupportZyServer", "mHandler", "Landroid/os/Handler;", "mSensor", "Landroid/hardware/Sensor;", "getMSensor", "()Landroid/hardware/Sensor;", "setMSensor", "(Landroid/hardware/Sensor;)V", "mSensorManager", "Landroid/hardware/SensorManager;", "getMSensorManager", "()Landroid/hardware/SensorManager;", "setMSensorManager", "(Landroid/hardware/SensorManager;)V", "mStepCounterListener", "Landroid/hardware/SensorEventListener;", "sysBloodPress", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "getWakeLock", "()Landroid/os/PowerManager$WakeLock;", "setWakeLock", "(Landroid/os/PowerManager$WakeLock;)V", "clearIfNewDay", BuildConfig.FLAVOR, "readFromCache", "Lcom/dw/launcher/data/entity/TodayBloodPressureList;", "replaceValueAtIndex", "index", "sysValue", "diaValue", BloodPressureManager.CACHE_KEY, "saveToCache", "start", "wakeup", "startMonitoring", "stop", "stopMonitoring", "Companion", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BloodPressureManager {
    private static final String CACHE_KEY = "todayDataList";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long DELAY_TIME = 30000;
    private static final int MESSAGE_ID = 0;
    private static final int MESSAGE_START = 1;
    private static BloodPressureManager bloodPressureManager;
    private final int DeFault_Port;
    private Context context;
    private int diaBloodPress;
    private HealthMeausureListener healthMeausureListener;
    private boolean isMeasureing;
    private boolean isSupportYunmiServer;
    private boolean isSupportZyServer;
    private final Handler mHandler;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private final SensorEventListener mStepCounterListener;
    private int sysBloodPress;
    private PowerManager.WakeLock wakeLock;

    public /* synthetic */ BloodPressureManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BloodPressureManager() {
        this.DeFault_Port = 65598;
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.dw.launcher.manager.BloodPressureManager$$ExternalSyntheticLambda0
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return BloodPressureManager.mHandler$lambda$0(this.f$0, message);
            }
        });
        this.mStepCounterListener = new SensorEventListener() { // from class: com.dw.launcher.manager.BloodPressureManager$mStepCounterListener$1
            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                Intrinsics.checkNotNullParameter(sensor, "sensor");
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent event) {
                Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
                if (event.values != null) {
                    float[] fArr = event.values;
                    Intrinsics.checkNotNullExpressionValue(fArr, "values");
                    if (!(fArr.length == 0)) {
                        StringBuilder sb = new StringBuilder();
                        int length = event.values.length;
                        for (int i = 0; i < length; i++) {
                            sb.append("values[" + i + "] = " + event.values[i] + "    ");
                        }
                        Log.i("lkang", String.valueOf(sb));
                        int i2 = (int) event.values[0];
                        int i3 = (int) event.values[3];
                        int i4 = (int) event.values[4];
                        if (i2 == 0) {
                            this.this$0.mHandler.removeMessages(0);
                            HealthMeausureListener healthMeausureListener = this.this$0.getHealthMeausureListener();
                            if (healthMeausureListener != null) {
                                healthMeausureListener.onError(1);
                            }
                            this.this$0.setMeasureing(false);
                            return;
                        }
                        HealthMeausureListener healthMeausureListener2 = this.this$0.getHealthMeausureListener();
                        if (healthMeausureListener2 != null) {
                            healthMeausureListener2.onError(0);
                        }
                        if (!this.this$0.getIsMeasureing()) {
                            HealthMeausureListener healthMeausureListener3 = this.this$0.getHealthMeausureListener();
                            if (healthMeausureListener3 != null) {
                                healthMeausureListener3.onstart();
                            }
                            this.this$0.setMeasureing(true);
                            this.this$0.mHandler.removeMessages(0);
                            this.this$0.mHandler.sendEmptyMessageDelayed(0, 30000L);
                        }
                        if (i3 > 0) {
                            this.this$0.diaBloodPress = i4;
                            this.this$0.sysBloodPress = i3;
                            HealthMeausureListener healthMeausureListener4 = this.this$0.getHealthMeausureListener();
                            if (healthMeausureListener4 != null) {
                                healthMeausureListener4.onHealthMeausure(this.this$0.sysBloodPress, this.this$0.diaBloodPress);
                            }
                        }
                    }
                }
            }
        };
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    public final PowerManager.WakeLock getWakeLock() {
        return this.wakeLock;
    }

    public final void setWakeLock(PowerManager.WakeLock wakeLock) {
        this.wakeLock = wakeLock;
    }

    public final HealthMeausureListener getHealthMeausureListener() {
        return this.healthMeausureListener;
    }

    public final void setHealthMeausureListener(HealthMeausureListener healthMeausureListener) {
        this.healthMeausureListener = healthMeausureListener;
    }

    /* JADX INFO: renamed from: isMeasureing, reason: from getter */
    public final boolean getIsMeasureing() {
        return this.isMeasureing;
    }

    public final void setMeasureing(boolean z) {
        this.isMeasureing = z;
    }

    public final int getDeFault_Port() {
        return this.DeFault_Port;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mHandler$lambda$0(BloodPressureManager bloodPressureManager2, Message message) {
        Intrinsics.checkNotNullParameter(bloodPressureManager2, "this$0");
        if (message.what == 0) {
            bloodPressureManager2.stopMonitoring();
        } else if (message.what == 1) {
            bloodPressureManager2.startMonitoring();
        }
        return true;
    }

    public final SensorManager getMSensorManager() {
        return this.mSensorManager;
    }

    public final void setMSensorManager(SensorManager sensorManager) {
        this.mSensorManager = sensorManager;
    }

    public final Sensor getMSensor() {
        return this.mSensor;
    }

    public final void setMSensor(Sensor sensor) {
        this.mSensor = sensor;
    }

    /* JADX INFO: compiled from: BloodPressureManager.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/dw/launcher/manager/BloodPressureManager$Companion;", BuildConfig.FLAVOR, "()V", "CACHE_KEY", BuildConfig.FLAVOR, "DELAY_TIME", BuildConfig.FLAVOR, "MESSAGE_ID", BuildConfig.FLAVOR, "MESSAGE_START", "bloodPressureManager", "Lcom/dw/launcher/manager/BloodPressureManager;", "instance", "getInstance", "()Lcom/dw/launcher/manager/BloodPressureManager;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BloodPressureManager getInstance() {
            if (BloodPressureManager.bloodPressureManager == null) {
                synchronized (BloodPressureManager.class) {
                    if (BloodPressureManager.bloodPressureManager == null) {
                        Companion companion = BloodPressureManager.INSTANCE;
                        BloodPressureManager.bloodPressureManager = new BloodPressureManager(null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return BloodPressureManager.bloodPressureManager;
        }
    }

    public static /* synthetic */ void start$default(BloodPressureManager bloodPressureManager2, Context context, boolean z, HealthMeausureListener healthMeausureListener, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        bloodPressureManager2.start(context, z, healthMeausureListener);
    }

    public final void start(Context context, boolean wakeup, HealthMeausureListener healthMeausureListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.d("BloodPressureManager", "manager start");
        this.context = context;
        this.isMeasureing = false;
        this.healthMeausureListener = healthMeausureListener;
        Object systemService = context.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager powerManager = (PowerManager) systemService;
        if (wakeup) {
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(805306394, com.dw.launcher.BuildConfig.APPLICATION_ID);
            this.wakeLock = wakeLockNewWakeLock;
            if (wakeLockNewWakeLock != null) {
                wakeLockNewWakeLock.acquire();
            }
        }
        if (this.mSensorManager == null) {
            Object systemService2 = context.getSystemService("sensor");
            Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.hardware.SensorManager");
            SensorManager sensorManager = (SensorManager) systemService2;
            this.mSensorManager = sensorManager;
            this.mSensor = sensorManager != null ? sensorManager.getDefaultSensor(this.DeFault_Port) : null;
        }
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 2000L);
    }

    private final void startMonitoring() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(0, DELAY_TIME);
        }
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.registerListener(this.mStepCounterListener, this.mSensor, 3);
        }
        Context context = this.context;
        Intrinsics.checkNotNull(context);
        Settings.Global.putInt(context.getContentResolver(), "health_measure_status", 1);
    }

    public final void stop() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.mStepCounterListener);
        }
        this.mHandler.removeMessages(1);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(0);
        }
        Log.d("BloodPressureManager", "manager stop");
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock != null && wakeLock.isHeld()) {
            wakeLock.release();
        }
        this.isMeasureing = false;
        HealthMeausureListener healthMeausureListener = this.healthMeausureListener;
        if (healthMeausureListener != null) {
            healthMeausureListener.onstop();
        }
        Context context = this.context;
        Intrinsics.checkNotNull(context);
        Settings.Global.putInt(context.getContentResolver(), "health_measure_status", 0);
    }

    private final void stopMonitoring() {
        try {
            PowerManager.WakeLock wakeLock = this.wakeLock;
            if (wakeLock != null && wakeLock.isHeld()) {
                wakeLock.release();
            }
            SensorManager sensorManager = this.mSensorManager;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.mStepCounterListener);
            }
            Context context = this.context;
            Intrinsics.checkNotNull(context);
            Settings.Global.putInt(context.getContentResolver(), "health_measure_status", 0);
            Context context2 = this.context;
            Intrinsics.checkNotNull(context2);
            TodayBloodPressureList fromCache = readFromCache(context2);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            replaceValueAtIndex(calendar.get(11), this.sysBloodPress, this.diaBloodPress, fromCache);
            Context context3 = this.context;
            Intrinsics.checkNotNull(context3);
            saveToCache(context3, fromCache);
            HealthMeausureListener healthMeausureListener = this.healthMeausureListener;
            if (healthMeausureListener != null) {
                healthMeausureListener.onFinish(fromCache);
            }
            this.isMeasureing = false;
            Context context4 = this.context;
            Intrinsics.checkNotNull(context4);
            Settings.Global.putInt(context4.getContentResolver(), "last_low_pressure", this.diaBloodPress);
            Context context5 = this.context;
            Intrinsics.checkNotNull(context5);
            Settings.Global.putInt(context5.getContentResolver(), "last_high_pressure", this.sysBloodPress);
            ServerUtil.reportBloodPressureServer(this.context, String.valueOf(this.sysBloodPress), String.valueOf(this.diaBloodPress));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void clearIfNewDay(Context context) {
        ACache aCache = ACache.get(context);
        String asString = aCache.getAsString("last_clear_date");
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        if (asString == null || !Intrinsics.areEqual(asString, str)) {
            saveToCache(context, new TodayBloodPressureList());
            aCache.put("last_clear_date", str);
        }
    }

    public final TodayBloodPressureList readFromCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        clearIfNewDay(context);
        String asString = ACache.get(new File(FileUtils.getBloodPress_Save_Path())).getAsString(CACHE_KEY);
        String str = asString;
        if (str == null || str.length() == 0) {
            return new TodayBloodPressureList();
        }
        Object objFromJson = new Gson().fromJson(asString, TodayBloodPressureList.class);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (TodayBloodPressureList) objFromJson;
    }

    private final void saveToCache(Context context, TodayBloodPressureList todayDataList) {
        ACache.get(new File(FileUtils.getBloodPress_Save_Path())).put(CACHE_KEY, new Gson().toJson(todayDataList));
    }

    private final void replaceValueAtIndex(int index, int sysValue, int diaValue, TodayBloodPressureList todayDataList) {
        if (todayDataList.getIndexList().contains(Integer.valueOf(index))) {
            int iIndexOf = todayDataList.getIndexList().indexOf(Integer.valueOf(index));
            todayDataList.diaList.set(iIndexOf, Integer.valueOf(diaValue));
            todayDataList.getValueList().set(iIndexOf, Integer.valueOf(sysValue));
        } else {
            todayDataList.getIndexList().add(Integer.valueOf(index));
            todayDataList.diaList.add(Integer.valueOf(diaValue));
            todayDataList.getValueList().add(Integer.valueOf(sysValue));
        }
    }
}
