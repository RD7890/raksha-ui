package com.dw.launcher.core.component;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.core.notification.NotificationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: NotificationComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0004*\u0001\t\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fJ#\u0010\u0018\u001a\u00020\u00142\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u0012¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0014J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\u0006\u0010 \u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/dw/launcher/core/component/NotificationComponent;", "Ljava/util/Observable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "filterPackage", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "mConn", "com/dw/launcher/core/component/NotificationComponent$mConn$1", "Lcom/dw/launcher/core/component/NotificationComponent$mConn$1;", "notificationService", "Lcom/dw/launcher/core/notification/NotificationService;", "notifications", BuildConfig.FLAVOR, "Landroid/service/notification/StatusBarNotification;", "[Landroid/service/notification/StatusBarNotification;", "rankingMap", "Landroid/service/notification/NotificationListenerService$RankingMap;", "cancel", BuildConfig.FLAVOR, "notification", "clearAll", "clearItem", "dataSetChanged", "activeNotifications", "currentRanking", "([Landroid/service/notification/StatusBarNotification;Landroid/service/notification/NotificationListenerService$RankingMap;)V", "getNotifications", BuildConfig.FLAVOR, "register", "startNotificationService", "unregister", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NotificationComponent extends Observable {
    private final Context context;
    private final Set<String> filterPackage;
    private final NotificationComponent$mConn$1 mConn;
    private NotificationService notificationService;
    private StatusBarNotification[] notifications;
    private NotificationListenerService.RankingMap rankingMap;

    /* JADX WARN: Type inference failed for: r3v4, types: [com.dw.launcher.core.component.NotificationComponent$mConn$1] */
    @Inject
    public NotificationComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.filterPackage = SetsKt.setOf(new String[]{"com.tencent.android.qqdownloader", "com.dw.recents"});
        this.mConn = new ServiceConnection() { // from class: com.dw.launcher.core.component.NotificationComponent$mConn$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(service, NotificationCompat.CATEGORY_SERVICE);
                Timber.Forest.i("----onServiceConnected", new Object[0]);
                this.this$0.notificationService = ((NotificationService.NotificationBinder) service).getThis$0();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                Timber.Forest.i("----onServiceDisconnected", new Object[0]);
                this.this$0.notificationService = null;
            }
        };
    }

    public final void register() {
        startNotificationService();
    }

    public final void unregister() {
        this.context.unbindService(this.mConn);
    }

    private final void startNotificationService() {
        ComponentName componentName = new ComponentName(this.context, (Class<?>) NotificationService.class);
        int componentEnabledSetting = this.context.getPackageManager().getComponentEnabledSetting(componentName);
        if (componentEnabledSetting != 1) {
            Timber.Forest.i("----enable component----", new Object[0]);
            this.context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            componentEnabledSetting = this.context.getPackageManager().getComponentEnabledSetting(componentName);
        }
        Timber.Forest.i("----isEnable: " + componentEnabledSetting, new Object[0]);
        if (componentEnabledSetting == 1) {
            this.context.bindService(new Intent(this.context, (Class<?>) NotificationService.class), this.mConn, 1);
        }
    }

    public final List<StatusBarNotification> getNotifications() {
        StatusBarNotification[] statusBarNotificationArr = this.notifications;
        if (statusBarNotificationArr != null) {
            return ArraysKt.toMutableList(statusBarNotificationArr);
        }
        return null;
    }

    public final void clearAll() {
        Timber.Forest.i("----cancelAll", new Object[0]);
        Object systemService = this.context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancelAll();
        NotificationService notificationService = this.notificationService;
        if (notificationService != null) {
            notificationService.cancelAllNotifications();
        }
    }

    public final void clearItem(StatusBarNotification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        NotificationService notificationService = this.notificationService;
        if (notificationService != null) {
            notificationService.cancelNotification(notification.getKey());
        }
    }

    public final void cancel(StatusBarNotification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        Object systemService = this.context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(notification.getId());
    }

    public final void dataSetChanged(StatusBarNotification[] activeNotifications, NotificationListenerService.RankingMap currentRanking) {
        CharSequence charSequence;
        CharSequence charSequence2;
        Intrinsics.checkNotNullParameter(currentRanking, "currentRanking");
        if (activeNotifications != null) {
            ArrayList arrayList = new ArrayList();
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                if (!this.filterPackage.contains(statusBarNotification.getPackageName()) && (((charSequence = statusBarNotification.getNotification().extras.getCharSequence(NotificationCompat.EXTRA_TITLE)) != null && charSequence.length() != 0) || ((charSequence2 = statusBarNotification.getNotification().extras.getCharSequence(NotificationCompat.EXTRA_TEXT)) != null && charSequence2.length() != 0))) {
                    arrayList.add(statusBarNotification);
                }
            }
            this.notifications = (StatusBarNotification[]) arrayList.toArray(new StatusBarNotification[0]);
            this.rankingMap = currentRanking;
            setChanged();
            notifyObservers();
        }
    }
}
