package com.dw.launcher.ui.view;

import com.dw.launcher.core.component.NotificationComponent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class DialNotificationView_MembersInjector implements MembersInjector<DialNotificationView> {
    private final Provider<NotificationComponent> notificationComponentProvider;

    public DialNotificationView_MembersInjector(Provider<NotificationComponent> notificationComponentProvider) {
        this.notificationComponentProvider = notificationComponentProvider;
    }

    public static MembersInjector<DialNotificationView> create(Provider<NotificationComponent> notificationComponentProvider) {
        return new DialNotificationView_MembersInjector(notificationComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DialNotificationView instance) {
        injectNotificationComponent(instance, this.notificationComponentProvider.get());
    }

    public static void injectNotificationComponent(DialNotificationView instance, NotificationComponent notificationComponent) {
        instance.notificationComponent = notificationComponent;
    }
}
