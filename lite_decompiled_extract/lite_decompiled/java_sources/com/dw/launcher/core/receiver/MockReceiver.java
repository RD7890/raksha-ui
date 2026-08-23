package com.dw.launcher.core.receiver;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MockReceiver.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/dw/launcher/core/receiver/MockReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "mockNotification", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "onReceive", "intent", "Landroid/content/Intent;", "Companion", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MockReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String ACTION_MOCK_NOTIFICATION = "com.dw.launcher.ACTION_MOCK_NOTIFICATION";
    private static final MockReceiver sInstance = new MockReceiver();

    /* JADX INFO: compiled from: MockReceiver.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/dw/launcher/core/receiver/MockReceiver$Companion;", BuildConfig.FLAVOR, "()V", "ACTION_MOCK_NOTIFICATION", BuildConfig.FLAVOR, "sInstance", "Lcom/dw/launcher/core/receiver/MockReceiver;", "register", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "unregister", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void register(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.registerReceiver(MockReceiver.sInstance, new IntentFilter(MockReceiver.ACTION_MOCK_NOTIFICATION));
        }

        public final void unregister(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.unregisterReceiver(MockReceiver.sInstance);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(intent.getAction(), ACTION_MOCK_NOTIFICATION)) {
            mockNotification(context);
        }
    }

    private final void mockNotification(Context context) {
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        notificationManager.createNotificationChannel(new NotificationChannel("MOCK", "MOCK_NOTIFICATION", 3));
        notificationManager.notify(1001, new Notification.Builder(context, "MOCK").setContentText("测试通知").setContentTitle("测试").setSmallIcon(R.mipmap.ic_launcher).build());
    }
}
