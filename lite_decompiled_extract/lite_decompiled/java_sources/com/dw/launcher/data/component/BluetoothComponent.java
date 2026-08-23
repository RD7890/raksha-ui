package com.dw.launcher.data.component;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.util.BluetoothUtils;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BluetoothComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u000b\u0018\u00002\u00020\u0001:\u0001\u0015B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/dw/launcher/data/component/BluetoothComponent;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "listener", "Lcom/dw/launcher/data/component/BluetoothComponent$BluetoothComponentCallback;", "mBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "kotlin.jvm.PlatformType", "mReceiver", "com/dw/launcher/data/component/BluetoothComponent$mReceiver$1", "Lcom/dw/launcher/data/component/BluetoothComponent$mReceiver$1;", "isConnected", BuildConfig.FLAVOR, "isEnable", "register", BuildConfig.FLAVOR, "callback", "toggle", "unregister", "BluetoothComponentCallback", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BluetoothComponent {
    private final Context context;
    private BluetoothComponentCallback listener;
    private final BluetoothAdapter mBluetoothAdapter;
    private final BluetoothComponent$mReceiver$1 mReceiver;

    /* JADX INFO: compiled from: BluetoothComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/data/component/BluetoothComponent$BluetoothComponentCallback;", BuildConfig.FLAVOR, "onBluetoothStateChanged", BuildConfig.FLAVOR, "enable", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface BluetoothComponentCallback {
        void onBluetoothStateChanged(boolean enable);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.dw.launcher.data.component.BluetoothComponent$mReceiver$1] */
    @Inject
    public BluetoothComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.data.component.BluetoothComponent$mReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                BluetoothComponent.BluetoothComponentCallback bluetoothComponentCallback;
                Intrinsics.checkNotNullParameter(intent, "intent");
                String action = intent.getAction();
                if (action != null) {
                    BluetoothComponent bluetoothComponent = this.this$0;
                    if (!Intrinsics.areEqual(action, "android.bluetooth.adapter.action.STATE_CHANGED") || (bluetoothComponentCallback = bluetoothComponent.listener) == null) {
                        return;
                    }
                    bluetoothComponentCallback.onBluetoothStateChanged(bluetoothComponent.isEnable());
                }
            }
        };
    }

    public final void register(BluetoothComponentCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.context.registerReceiver(this.mReceiver, intentFilter);
        this.listener = callback;
    }

    public final void unregister() {
        this.context.unregisterReceiver(this.mReceiver);
    }

    public final boolean isEnable() {
        return this.mBluetoothAdapter.isEnabled();
    }

    public final boolean isConnected() {
        return BluetoothUtils.isConnected();
    }

    public final void toggle() {
        if (this.mBluetoothAdapter.isEnabled()) {
            this.mBluetoothAdapter.disable();
        } else {
            this.mBluetoothAdapter.enable();
        }
    }
}
