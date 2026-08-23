package com.dw.launcher.ui.fragment.bottom;

import com.dw.launcher.core.component.NotificationComponent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class BottomFragment_MembersInjector implements MembersInjector<BottomFragment> {
    private final Provider<NotificationComponent> mNotificationComponentProvider;

    public BottomFragment_MembersInjector(Provider<NotificationComponent> mNotificationComponentProvider) {
        this.mNotificationComponentProvider = mNotificationComponentProvider;
    }

    public static MembersInjector<BottomFragment> create(Provider<NotificationComponent> mNotificationComponentProvider) {
        return new BottomFragment_MembersInjector(mNotificationComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BottomFragment instance) {
        injectMNotificationComponent(instance, this.mNotificationComponentProvider.get());
    }

    public static void injectMNotificationComponent(BottomFragment instance, NotificationComponent mNotificationComponent) {
        instance.mNotificationComponent = mNotificationComponent;
    }
}
