package com.dw.launcher.core.notification;

import com.dw.launcher.core.component.NotificationComponent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class NotificationService_MembersInjector implements MembersInjector<NotificationService> {
    private final Provider<NotificationComponent> notificationComponentProvider;

    public NotificationService_MembersInjector(Provider<NotificationComponent> notificationComponentProvider) {
        this.notificationComponentProvider = notificationComponentProvider;
    }

    public static MembersInjector<NotificationService> create(Provider<NotificationComponent> notificationComponentProvider) {
        return new NotificationService_MembersInjector(notificationComponentProvider);
    }

    public void injectMembers(NotificationService instance) {
        injectNotificationComponent(instance, (NotificationComponent) this.notificationComponentProvider.get());
    }

    public static void injectNotificationComponent(NotificationService instance, NotificationComponent notificationComponent) {
        instance.notificationComponent = notificationComponent;
    }
}
