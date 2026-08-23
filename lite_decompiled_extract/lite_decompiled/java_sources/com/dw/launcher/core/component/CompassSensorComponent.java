package com.dw.launcher.core.component;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.core.app.NotificationCompat;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.repository.LauncherRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: CompassSensorComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0019R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/dw/launcher/core/component/CompassSensorComponent;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "(Landroid/content/Context;Lcom/dw/launcher/data/repository/LauncherRepository;)V", "isRegister", BuildConfig.FLAVOR, "()Z", "setRegister", "(Z)V", "lastRegisterTime", BuildConfig.FLAVOR, "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "listener", "Landroid/hardware/SensorEventListener;", "getListener", "()Landroid/hardware/SensorEventListener;", "setListener", "(Landroid/hardware/SensorEventListener;)V", "sensorManager", "Landroid/hardware/SensorManager;", "register", BuildConfig.FLAVOR, "Lcom/dw/launcher/core/component/CompassSensorComponent$OnCompassSensorChangedListener;", "unregister", "OnCompassSensorChangedListener", "SensorEventListenerImpl", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CompassSensorComponent {
    private boolean isRegister;
    private long lastRegisterTime;
    private final LauncherRepository launcherRepository;
    private SensorEventListener listener;
    private final SensorManager sensorManager;

    /* JADX INFO: compiled from: CompassSensorComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/core/component/CompassSensorComponent$OnCompassSensorChangedListener;", BuildConfig.FLAVOR, "onCompassSensorChanged", BuildConfig.FLAVOR, "up", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnCompassSensorChangedListener {
        boolean onCompassSensorChanged(float up);
    }

    @Inject
    public CompassSensorComponent(Context context, LauncherRepository launcherRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(launcherRepository, "launcherRepository");
        this.launcherRepository = launcherRepository;
        Object systemService = context.getSystemService("sensor");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        this.sensorManager = (SensorManager) systemService;
    }

    public final LauncherRepository getLauncherRepository() {
        return this.launcherRepository;
    }

    /* JADX INFO: compiled from: CompassSensorComponent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/dw/launcher/core/component/CompassSensorComponent$SensorEventListenerImpl;", "Landroid/hardware/SensorEventListener;", "listener", "Lcom/dw/launcher/core/component/CompassSensorComponent$OnCompassSensorChangedListener;", "(Lcom/dw/launcher/core/component/CompassSensorComponent;Lcom/dw/launcher/core/component/CompassSensorComponent$OnCompassSensorChangedListener;)V", "getListener", "()Lcom/dw/launcher/core/component/CompassSensorComponent$OnCompassSensorChangedListener;", "onAccuracyChanged", BuildConfig.FLAVOR, "sensor", "Landroid/hardware/Sensor;", "accuracy", BuildConfig.FLAVOR, "onSensorChanged", NotificationCompat.CATEGORY_EVENT, "Landroid/hardware/SensorEvent;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class SensorEventListenerImpl implements SensorEventListener {
        private final OnCompassSensorChangedListener listener;
        final /* synthetic */ CompassSensorComponent this$0;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        public SensorEventListenerImpl(CompassSensorComponent compassSensorComponent, OnCompassSensorChangedListener onCompassSensorChangedListener) {
            Intrinsics.checkNotNullParameter(onCompassSensorChangedListener, "listener");
            this.this$0 = compassSensorComponent;
            this.listener = onCompassSensorChangedListener;
        }

        public final OnCompassSensorChangedListener getListener() {
            return this.listener;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent event) {
            float[] fArr;
            if (event == null || (fArr = event.values) == null) {
                return;
            }
            if (!(!(fArr.length == 0)) || fArr.length <= 1) {
                return;
            }
            float f = 360;
            this.listener.onCompassSensorChanged((fArr[0] + f) % f);
        }
    }

    public final SensorEventListener getListener() {
        return this.listener;
    }

    public final void setListener(SensorEventListener sensorEventListener) {
        this.listener = sensorEventListener;
    }

    /* JADX INFO: renamed from: isRegister, reason: from getter */
    public final boolean getIsRegister() {
        return this.isRegister;
    }

    public final void setRegister(boolean z) {
        this.isRegister = z;
    }

    public final void register(OnCompassSensorChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Timber.Forest.d("----register----", new Object[0]);
        LaunchConfig launchConfigLoadConfig = this.launcherRepository.loadConfig();
        if (launchConfigLoadConfig == null || launchConfigLoadConfig.getSupport_compass() != 1 || this.isRegister) {
            return;
        }
        Sensor defaultSensor = this.sensorManager.getDefaultSensor(3);
        SensorEventListenerImpl sensorEventListenerImpl = new SensorEventListenerImpl(this, listener);
        this.listener = sensorEventListenerImpl;
        this.sensorManager.registerListener(sensorEventListenerImpl, defaultSensor, 3);
        this.isRegister = true;
    }

    public final void unregister() {
        Timber.Forest.i("----unregister----", new Object[0]);
        SensorEventListener sensorEventListener = this.listener;
        if (sensorEventListener != null) {
            this.sensorManager.unregisterListener(sensorEventListener);
            this.isRegister = false;
        }
    }
}
