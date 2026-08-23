package com.dw.launcher.data.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatteryComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/dw/launcher/data/component/BatteryComponent;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBatteryLevel", BuildConfig.FLAVOR, "mBatteryReceiver", "com/dw/launcher/data/component/BatteryComponent$mBatteryReceiver$1", "Lcom/dw/launcher/data/component/BatteryComponent$mBatteryReceiver$1;", "mCharging", BuildConfig.FLAVOR, "mListeners", "Ljava/util/ArrayList;", "Lcom/dw/launcher/data/component/BatteryComponent$OnBatteryChangedListener;", "Lkotlin/collections/ArrayList;", "addListener", BuildConfig.FLAVOR, "listener", "getLevel", "isCharging", "register", "removeListener", "unregister", "OnBatteryChangedListener", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BatteryComponent {
    private final Context context;
    private int mBatteryLevel;
    private final BatteryComponent$mBatteryReceiver$1 mBatteryReceiver;
    private boolean mCharging;
    private final ArrayList<OnBatteryChangedListener> mListeners;

    /* JADX INFO: compiled from: BatteryComponent.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/dw/launcher/data/component/BatteryComponent$OnBatteryChangedListener;", BuildConfig.FLAVOR, "onBatteryChanged", BuildConfig.FLAVOR, "batteryLevel", BuildConfig.FLAVOR, "onBatteryChargingStateChanged", "charging", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnBatteryChangedListener {

        /* JADX INFO: compiled from: BatteryComponent.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onBatteryChargingStateChanged(OnBatteryChangedListener onBatteryChangedListener, boolean z) {
            }
        }

        void onBatteryChanged(int batteryLevel);

        void onBatteryChargingStateChanged(boolean charging);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.dw.launcher.data.component.BatteryComponent$mBatteryReceiver$1] */
    @Inject
    public BatteryComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mListeners = new ArrayList<>();
        this.mBatteryReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.data.component.BatteryComponent$mBatteryReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                String action;
                if (intent == null || (action = intent.getAction()) == null) {
                    return;
                }
                BatteryComponent batteryComponent = this.this$0;
                boolean z = batteryComponent.mCharging;
                if (Intrinsics.areEqual(action, "android.intent.action.BATTERY_CHANGED")) {
                    batteryComponent.mBatteryLevel = intent.getIntExtra("level", batteryComponent.mBatteryLevel);
                    batteryComponent.mCharging = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, 1) == 2;
                    if (batteryComponent.mCharging != z) {
                        Iterator it = batteryComponent.mListeners.iterator();
                        while (it.hasNext()) {
                            ((BatteryComponent.OnBatteryChangedListener) it.next()).onBatteryChargingStateChanged(batteryComponent.mCharging);
                        }
                    }
                    Iterator it2 = batteryComponent.mListeners.iterator();
                    while (it2.hasNext()) {
                        ((BatteryComponent.OnBatteryChangedListener) it2.next()).onBatteryChanged(batteryComponent.mBatteryLevel);
                    }
                }
            }
        };
    }

    public final void register() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        this.context.registerReceiver(this.mBatteryReceiver, intentFilter);
    }

    public final void unregister() {
        this.context.unregisterReceiver(this.mBatteryReceiver);
    }

    public final void addListener(OnBatteryChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListeners.add(listener);
    }

    public final void removeListener(OnBatteryChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListeners.remove(listener);
    }

    /* JADX INFO: renamed from: isCharging, reason: from getter */
    public final boolean getMCharging() {
        return this.mCharging;
    }

    /* JADX INFO: renamed from: getLevel, reason: from getter */
    public final int getMBatteryLevel() {
        return this.mBatteryLevel;
    }
}
