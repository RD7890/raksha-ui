package com.dw.launcher.data.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0010\u0018\u00002\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/dw/launcher/data/component/TimeComponent;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "listener", "Lcom/dw/launcher/data/component/TimeComponent$OnTimeChangedListener;", "(Landroid/content/Context;Lcom/dw/launcher/data/component/TimeComponent$OnTimeChangedListener;)V", "DURATION", BuildConfig.FLAVOR, "mHandler", "Landroid/os/Handler;", "mReceiver", "Landroid/content/BroadcastReceiver;", "mRegistered", BuildConfig.FLAVOR, "mUpdateTimeTask", "com/dw/launcher/data/component/TimeComponent$mUpdateTimeTask$1", "Lcom/dw/launcher/data/component/TimeComponent$mUpdateTimeTask$1;", "register", BuildConfig.FLAVOR, "unregister", "OnTimeChangedListener", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TimeComponent {
    private final long DURATION;
    private final Context context;
    private final OnTimeChangedListener listener;
    private final Handler mHandler;
    private BroadcastReceiver mReceiver;
    private boolean mRegistered;
    private final TimeComponent$mUpdateTimeTask$1 mUpdateTimeTask;

    /* JADX INFO: compiled from: TimeComponent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/dw/launcher/data/component/TimeComponent$OnTimeChangedListener;", BuildConfig.FLAVOR, "onTimeChanged", BuildConfig.FLAVOR, "hour", BuildConfig.FLAVOR, "minute", "seconds", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnTimeChangedListener {
        void onTimeChanged(int hour, int minute, int seconds);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.dw.launcher.data.component.TimeComponent$mUpdateTimeTask$1] */
    public TimeComponent(Context context, OnTimeChangedListener onTimeChangedListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onTimeChangedListener, "listener");
        this.context = context;
        this.listener = onTimeChangedListener;
        this.DURATION = 60000L;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mUpdateTimeTask = new Runnable() { // from class: com.dw.launcher.data.component.TimeComponent$mUpdateTimeTask$1
            @Override // java.lang.Runnable
            public void run() {
                Calendar calendar = Calendar.getInstance();
                this.this$0.listener.onTimeChanged(calendar.get(11), calendar.get(12), calendar.get(13));
                TimeComponent$mUpdateTimeTask$1 timeComponent$mUpdateTimeTask$1 = this;
                this.this$0.mHandler.removeCallbacks(timeComponent$mUpdateTimeTask$1);
                if (this.this$0.mRegistered) {
                    this.this$0.mHandler.postDelayed(timeComponent$mUpdateTimeTask$1, this.this$0.DURATION);
                }
            }
        };
    }

    public final void register() {
        this.mRegistered = true;
        this.mHandler.removeCallbacks(this.mUpdateTimeTask);
        this.mHandler.postDelayed(this.mUpdateTimeTask, 200L);
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
        }
        this.mReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.data.component.TimeComponent.register.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                TimeComponent.this.mHandler.removeCallbacks(TimeComponent.this.mUpdateTimeTask);
                TimeComponent.this.mHandler.post(TimeComponent.this.mUpdateTimeTask);
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        this.context.registerReceiver(this.mReceiver, intentFilter);
    }

    public final void unregister() {
        this.mRegistered = false;
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
            this.mReceiver = null;
        }
    }
}
