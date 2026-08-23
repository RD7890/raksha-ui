package com.dw.launcher.core.notification;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.os.UserHandle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.core.component.NotificationComponent;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: NotificationService.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0002\u0010\u000eJ%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J.\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u001bH\u0016J.\u0010'\u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010&\u001a\u00020\u001bH\u0016J\u001a\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010-\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010.\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010\r2\b\u0010,\u001a\u0004\u0018\u00010\u00122\u0006\u0010/\u001a\u00020\u001bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u00061"}, d2 = {"Lcom/dw/launcher/core/notification/NotificationService;", "Landroid/service/notification/NotificationListenerService;", "()V", "TAG", BuildConfig.FLAVOR, "notificationComponent", "Lcom/dw/launcher/core/component/NotificationComponent;", "getNotificationComponent", "()Lcom/dw/launcher/core/component/NotificationComponent;", "setNotificationComponent", "(Lcom/dw/launcher/core/component/NotificationComponent;)V", "getActiveNotifications", BuildConfig.FLAVOR, "Landroid/service/notification/StatusBarNotification;", "()[Landroid/service/notification/StatusBarNotification;", "keys", "([Ljava/lang/String;)[Landroid/service/notification/StatusBarNotification;", "getCurrentRanking", "Landroid/service/notification/NotificationListenerService$RankingMap;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", BuildConfig.FLAVOR, "onInterruptionFilterChanged", "interruptionFilter", BuildConfig.FLAVOR, "onListenerConnected", "onListenerDisconnected", "onListenerHintsChanged", "hints", "onNotificationChannelGroupModified", "pkg", "user", "Landroid/os/UserHandle;", "group", "Landroid/app/NotificationChannelGroup;", "modificationType", "onNotificationChannelModified", "channel", "Landroid/app/NotificationChannel;", "onNotificationPosted", "sbn", "rankingMap", "onNotificationRankingUpdate", "onNotificationRemoved", "reason", "NotificationBinder", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class NotificationService extends Hilt_NotificationService {
    private final String TAG = "NotificationService";

    @Inject
    public NotificationComponent notificationComponent;

    public final NotificationComponent getNotificationComponent() {
        NotificationComponent notificationComponent = this.notificationComponent;
        if (notificationComponent != null) {
            return notificationComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notificationComponent");
        return null;
    }

    public final void setNotificationComponent(NotificationComponent notificationComponent) {
        Intrinsics.checkNotNullParameter(notificationComponent, "<set-?>");
        this.notificationComponent = notificationComponent;
    }

    @Override // com.dw.launcher.core.notification.Hilt_NotificationService, android.app.Service
    public void onCreate() {
        super.onCreate();
        Timber.Forest.i("----onCreate", new Object[0]);
        try {
            NotificationListenerService.class.getDeclaredMethod("registerAsSystemService", Context.class, ComponentName.class, Integer.TYPE).invoke(this, this, new ComponentName(this, (Class<?>) NotificationService.class), Integer.valueOf(Process.myUid()));
        } catch (Exception e) {
            Timber.Forest.w(e, "-----error register----", new Object[0]);
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerConnected() {
        super.onListenerConnected();
        Timber.Forest.i("----onListenerConnected", new Object[0]);
        getNotificationComponent().dataSetChanged(getActiveNotifications(), getCurrentRanking());
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerDisconnected() {
        super.onListenerDisconnected();
        Timber.Forest.i("----onListenerDisconnected", new Object[0]);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification sbn, NotificationListenerService.RankingMap rankingMap) {
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        super.onNotificationPosted(sbn, rankingMap);
        getNotificationComponent().dataSetChanged(getActiveNotifications(), getCurrentRanking());
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification sbn, NotificationListenerService.RankingMap rankingMap, int reason) {
        super.onNotificationRemoved(sbn, rankingMap, reason);
        Timber.Forest.i("----onNotificationRemoved, reason: " + reason, new Object[0]);
        getNotificationComponent().dataSetChanged(getActiveNotifications(), getCurrentRanking());
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRankingUpdate(NotificationListenerService.RankingMap rankingMap) {
        super.onNotificationRankingUpdate(rankingMap);
        Timber.Forest.i("----onNotificationRankingUpdate", new Object[0]);
        getNotificationComponent().dataSetChanged(getActiveNotifications(), getCurrentRanking());
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerHintsChanged(int hints) {
        super.onListenerHintsChanged(hints);
        Timber.Forest.i("----onListenerHintsChanged", new Object[0]);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationChannelModified(String pkg, UserHandle user, NotificationChannel channel, int modificationType) {
        super.onNotificationChannelModified(pkg, user, channel, modificationType);
        Timber.Forest.i("----onNotificationChannelModified", new Object[0]);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationChannelGroupModified(String pkg, UserHandle user, NotificationChannelGroup group, int modificationType) {
        super.onNotificationChannelGroupModified(pkg, user, group, modificationType);
        Timber.Forest.i("----onNotificationChannelGroupModified", new Object[0]);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onInterruptionFilterChanged(int interruptionFilter) {
        super.onInterruptionFilterChanged(interruptionFilter);
        Timber.Forest.i("----onInterruptionFilterChanged", new Object[0]);
    }

    @Override // android.service.notification.NotificationListenerService
    public StatusBarNotification[] getActiveNotifications() {
        Timber.Forest.i("----getActiveNotifications", new Object[0]);
        StatusBarNotification[] activeNotifications = super.getActiveNotifications();
        Intrinsics.checkNotNullExpressionValue(activeNotifications, "getActiveNotifications(...)");
        return activeNotifications;
    }

    @Override // android.service.notification.NotificationListenerService
    public StatusBarNotification[] getActiveNotifications(String[] keys) {
        Timber.Forest.i("----getActiveNotifications", new Object[0]);
        StatusBarNotification[] activeNotifications = super.getActiveNotifications(keys);
        Intrinsics.checkNotNullExpressionValue(activeNotifications, "getActiveNotifications(...)");
        return activeNotifications;
    }

    @Override // android.service.notification.NotificationListenerService
    public NotificationListenerService.RankingMap getCurrentRanking() {
        Timber.Forest.i("----getCurrentRanking", new Object[0]);
        NotificationListenerService.RankingMap currentRanking = super.getCurrentRanking();
        Intrinsics.checkNotNullExpressionValue(currentRanking, "getCurrentRanking(...)");
        return currentRanking;
    }

    /* JADX INFO: compiled from: NotificationService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/dw/launcher/core/notification/NotificationService$NotificationBinder;", "Landroid/os/Binder;", "(Lcom/dw/launcher/core/notification/NotificationService;)V", "getService", "Lcom/dw/launcher/core/notification/NotificationService;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class NotificationBinder extends Binder {
        public NotificationBinder() {
        }

        /* JADX INFO: renamed from: getService, reason: from getter */
        public final NotificationService getThis$0() {
            return NotificationService.this;
        }
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return new NotificationBinder();
    }
}
