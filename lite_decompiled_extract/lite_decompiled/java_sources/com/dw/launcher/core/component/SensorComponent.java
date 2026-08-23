package com.dw.launcher.core.component;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.hilt.annotion.RingToneAnnotion;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: SensorComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002-.B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010)\u001a\u00020*2\u0006\u0010\u0014\u001a\u00020+J\u0006\u0010,\u001a\u00020*R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/dw/launcher/core/component/SensorComponent;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "(Landroid/content/Context;Lcom/dw/launcher/data/repository/LauncherRepository;)V", "SENSOR_REGISTER_INTERVAL", BuildConfig.FLAVOR, "autoPlaySound", BuildConfig.FLAVOR, "getAutoPlaySound", "()Z", "setAutoPlaySound", "(Z)V", "keyEncoderType", BuildConfig.FLAVOR, "lastRegisterTime", "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "listener", "Landroid/hardware/SensorEventListener;", "getListener", "()Landroid/hardware/SensorEventListener;", "setListener", "(Landroid/hardware/SensorEventListener;)V", "mHandler", "Landroid/os/Handler;", "mRingtoneComponent", "Lcom/dw/launcher/core/component/SoundEffect;", "getMRingtoneComponent$annotations", "()V", "getMRingtoneComponent", "()Lcom/dw/launcher/core/component/SoundEffect;", "setMRingtoneComponent", "(Lcom/dw/launcher/core/component/SoundEffect;)V", "mScheduleToStopRingtoneTask", "Ljava/lang/Runnable;", "mScheduleToStopSensor", "sensorManager", "Landroid/hardware/SensorManager;", "register", BuildConfig.FLAVOR, "Lcom/dw/launcher/core/component/SensorComponent$OnSensorChangedListener;", "unregister", "OnSensorChangedListener", "SensorEventListenerImpl", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SensorComponent {
    private final long SENSOR_REGISTER_INTERVAL;
    private boolean autoPlaySound;
    private int keyEncoderType;
    private long lastRegisterTime;
    private final LauncherRepository launcherRepository;
    private SensorEventListener listener;
    private final Handler mHandler;

    @Inject
    public SoundEffect mRingtoneComponent;
    private final Runnable mScheduleToStopRingtoneTask;
    private final Runnable mScheduleToStopSensor;
    private final SensorManager sensorManager;

    /* JADX INFO: compiled from: SensorComponent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/dw/launcher/core/component/SensorComponent$OnSensorChangedListener;", BuildConfig.FLAVOR, "onSensorChanged", BuildConfig.FLAVOR, "up", "onSensorStopped", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnSensorChangedListener {

        /* JADX INFO: compiled from: SensorComponent.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onSensorStopped(OnSensorChangedListener onSensorChangedListener) {
            }
        }

        boolean onSensorChanged(boolean up);

        void onSensorStopped();
    }

    @RingToneAnnotion
    public static /* synthetic */ void getMRingtoneComponent$annotations() {
    }

    @Inject
    public SensorComponent(Context context, LauncherRepository launcherRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(launcherRepository, "launcherRepository");
        this.launcherRepository = launcherRepository;
        this.autoPlaySound = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mScheduleToStopRingtoneTask = new Runnable() { // from class: com.dw.launcher.core.component.SensorComponent$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SensorComponent.mScheduleToStopRingtoneTask$lambda$0(this.f$0);
            }
        };
        this.mScheduleToStopSensor = new Runnable() { // from class: com.dw.launcher.core.component.SensorComponent$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SensorComponent.mScheduleToStopSensor$lambda$2(this.f$0);
            }
        };
        Object systemService = context.getSystemService("sensor");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        this.sensorManager = (SensorManager) systemService;
        this.SENSOR_REGISTER_INTERVAL = 100L;
    }

    public final LauncherRepository getLauncherRepository() {
        return this.launcherRepository;
    }

    public final SoundEffect getMRingtoneComponent() {
        SoundEffect soundEffect = this.mRingtoneComponent;
        if (soundEffect != null) {
            return soundEffect;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRingtoneComponent");
        return null;
    }

    public final void setMRingtoneComponent(SoundEffect soundEffect) {
        Intrinsics.checkNotNullParameter(soundEffect, "<set-?>");
        this.mRingtoneComponent = soundEffect;
    }

    public final boolean getAutoPlaySound() {
        return this.autoPlaySound;
    }

    public final void setAutoPlaySound(boolean z) {
        this.autoPlaySound = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mScheduleToStopRingtoneTask$lambda$0(SensorComponent sensorComponent) {
        Intrinsics.checkNotNullParameter(sensorComponent, "this$0");
        Timber.Forest.v("----stop ringtone", new Object[0]);
        sensorComponent.getMRingtoneComponent().stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mScheduleToStopSensor$lambda$2(SensorComponent sensorComponent) {
        Intrinsics.checkNotNullParameter(sensorComponent, "this$0");
        SensorEventListener sensorEventListener = sensorComponent.listener;
        if (sensorEventListener != null) {
            Intrinsics.checkNotNull(sensorEventListener, "null cannot be cast to non-null type com.dw.launcher.core.component.SensorComponent.SensorEventListenerImpl");
            ((SensorEventListenerImpl) sensorEventListener).getListener().onSensorStopped();
        }
    }

    /* JADX INFO: compiled from: SensorComponent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/dw/launcher/core/component/SensorComponent$SensorEventListenerImpl;", "Landroid/hardware/SensorEventListener;", "listener", "Lcom/dw/launcher/core/component/SensorComponent$OnSensorChangedListener;", "(Lcom/dw/launcher/core/component/SensorComponent;Lcom/dw/launcher/core/component/SensorComponent$OnSensorChangedListener;)V", "getListener", "()Lcom/dw/launcher/core/component/SensorComponent$OnSensorChangedListener;", "onAccuracyChanged", BuildConfig.FLAVOR, "sensor", "Landroid/hardware/Sensor;", "accuracy", BuildConfig.FLAVOR, "onSensorChanged", NotificationCompat.CATEGORY_EVENT, "Landroid/hardware/SensorEvent;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class SensorEventListenerImpl implements SensorEventListener {
        private final OnSensorChangedListener listener;
        final /* synthetic */ SensorComponent this$0;

        public SensorEventListenerImpl(SensorComponent sensorComponent, OnSensorChangedListener onSensorChangedListener) {
            Intrinsics.checkNotNullParameter(onSensorChangedListener, "listener");
            this.this$0 = sensorComponent;
            this.listener = onSensorChangedListener;
        }

        public final OnSensorChangedListener getListener() {
            return this.listener;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent event) {
            float[] fArr;
            Log.i("lkang", "----onSensorChanged---- SENSOR_REGISTER_INTERVAL = " + (System.currentTimeMillis() - this.this$0.lastRegisterTime));
            if (System.currentTimeMillis() - this.this$0.lastRegisterTime <= this.this$0.SENSOR_REGISTER_INTERVAL || event == null || (fArr = event.values) == null) {
                return;
            }
            SensorComponent sensorComponent = this.this$0;
            if (!(!(fArr.length == 0)) || fArr.length <= 1) {
                return;
            }
            if (sensorComponent.getAutoPlaySound()) {
                sensorComponent.mHandler.removeCallbacks(sensorComponent.mScheduleToStopRingtoneTask);
                sensorComponent.mHandler.postDelayed(sensorComponent.mScheduleToStopRingtoneTask, 200L);
            }
            if (sensorComponent.keyEncoderType == 0) {
                this.listener.onSensorChanged(fArr[1] < 0.0f);
            } else if (Math.abs(fArr[1]) > 30.0f) {
                this.listener.onSensorChanged(fArr[1] < 0.0f);
            }
            sensorComponent.mHandler.removeCallbacks(sensorComponent.mScheduleToStopSensor);
            sensorComponent.mHandler.postDelayed(sensorComponent.mScheduleToStopSensor, 1000L);
            if (!sensorComponent.getAutoPlaySound() || sensorComponent.getMRingtoneComponent().isPlaying()) {
                return;
            }
            sensorComponent.getMRingtoneComponent().start();
            sensorComponent.mHandler.removeCallbacks(sensorComponent.mScheduleToStopRingtoneTask);
            sensorComponent.mHandler.postDelayed(sensorComponent.mScheduleToStopRingtoneTask, 200L);
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            Log.i("lkang", "----onAccuracyChanged----");
        }
    }

    public final SensorEventListener getListener() {
        return this.listener;
    }

    public final void setListener(SensorEventListener sensorEventListener) {
        this.listener = sensorEventListener;
    }

    public final void register(OnSensorChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LaunchConfig launchConfigLoadConfig = this.launcherRepository.loadConfig();
        if (launchConfigLoadConfig != null) {
            if (Intrinsics.areEqual(launchConfigLoadConfig.getOpenEncoderSound(), "false")) {
                this.autoPlaySound = false;
            }
            this.keyEncoderType = launchConfigLoadConfig.getKeyEncoderType();
        }
        Sensor defaultSensor = this.sensorManager.getDefaultSensor(65597);
        this.listener = new SensorEventListenerImpl(this, listener);
        this.lastRegisterTime = System.currentTimeMillis();
        Timber.Forest.i("----register, result: " + this.sensorManager.registerListener(this.listener, defaultSensor, 3) + "----", new Object[0]);
    }

    public final void unregister() {
        Timber.Forest.i("----unregister----", new Object[0]);
        SensorEventListener sensorEventListener = this.listener;
        if (sensorEventListener != null) {
            this.sensorManager.unregisterListener(sensorEventListener);
        }
    }
}
