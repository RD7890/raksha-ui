package com.dw.launcher.data.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.android.internal.util.AsyncChannel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WifiComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0002\b\r\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0012J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/dw/launcher/data/component/WifiComponent;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "connManager", "Landroid/net/ConnectivityManager;", "handler", "com/dw/launcher/data/component/WifiComponent$handler$1", "Lcom/dw/launcher/data/component/WifiComponent$handler$1;", "mWifiChannel", "Lcom/android/internal/util/AsyncChannel;", "receiver", "com/dw/launcher/data/component/WifiComponent$receiver$1", "Lcom/dw/launcher/data/component/WifiComponent$receiver$1;", "wifiManager", "Landroid/net/wifi/WifiManager;", "calculateSignalLevel", BuildConfig.FLAVOR, "rssi", "numLevels", "isConnected", BuildConfig.FLAVOR, "isEnable", "isWifiApEnabled", "level", "register", BuildConfig.FLAVOR, "toggle", "unregister", "Companion", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WifiComponent {
    private static final int MAX_RSSI = -55;
    private static final int MIN_RSSI = -100;
    private static final int RSSI_LEVEL = 5;
    private final ConnectivityManager connManager;
    private final Context context;
    private final WifiComponent$handler$1 handler;
    private AsyncChannel mWifiChannel;
    private final WifiComponent$receiver$1 receiver;
    private final WifiManager wifiManager;

    private final int calculateSignalLevel(int rssi, int numLevels) {
        if (rssi <= -100) {
            return 0;
        }
        if (rssi >= MAX_RSSI) {
            return numLevels - 1;
        }
        return (int) (((rssi - (-100)) * (numLevels - 1)) / 45.0f);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.dw.launcher.data.component.WifiComponent$handler$1] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.dw.launcher.data.component.WifiComponent$receiver$1] */
    @Inject
    public WifiComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Object systemService = context.getSystemService("wifi");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        this.wifiManager = (WifiManager) systemService;
        Object systemService2 = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connManager = (ConnectivityManager) systemService2;
        this.receiver = new BroadcastReceiver() { // from class: com.dw.launcher.data.component.WifiComponent$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context mContext, Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Log.i("lkang", "wifi onReceive mOnStateChangedListener");
                Intent intent2 = new Intent("com.dw.wifi.change");
                intent2.setPackage(this.this$0.context.getPackageName());
                this.this$0.context.sendBroadcast(intent2);
            }
        };
        final Looper mainLooper = Looper.getMainLooper();
        this.handler = new Handler(mainLooper) { // from class: com.dw.launcher.data.component.WifiComponent$handler$1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
                super.handleMessage(msg);
            }
        };
        this.mWifiChannel = new AsyncChannel();
    }

    public final void register() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.context.registerReceiver(this.receiver, intentFilter);
    }

    public final void unregister() {
        this.context.unregisterReceiver(this.receiver);
    }

    public final int level() {
        WifiInfo connectionInfo = this.wifiManager.getConnectionInfo();
        return calculateSignalLevel(connectionInfo != null ? connectionInfo.getRssi() : 0, 5);
    }

    public final boolean isEnable() {
        return this.wifiManager.isWifiEnabled();
    }

    public final void toggle() {
        Log.i("lkang", "wifiManager.isWifiEnabled = " + this.wifiManager.isWifiEnabled());
        if (isEnable()) {
            this.wifiManager.setWifiEnabled(false);
        } else {
            this.wifiManager.setWifiEnabled(true);
        }
    }

    public final boolean isConnected() {
        NetworkInfo networkInfo = this.connManager.getNetworkInfo(1);
        return networkInfo != null && networkInfo.isConnected();
    }

    public final boolean isWifiApEnabled() {
        return this.wifiManager.isWifiApEnabled();
    }
}
