package com.dw.launcher.ui.fragment.launcher;

import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.component.PhoneStatusComponent;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.repository.IRecentTaskRepository;
import com.dw.launcher.data.repository.LauncherRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class LauncherFragment_MembersInjector implements MembersInjector<LauncherFragment> {
    private final Provider<LauncherRepository> launcherRepositoryProvider;
    private final Provider<NoDisturbComponent> noDisturbComponentProvider;
    private final Provider<PhoneStatusComponent> phoneStatusComponentProvider;
    private final Provider<IRecentTaskRepository> recentTaskRepositoryProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public LauncherFragment_MembersInjector(Provider<SysKeyEvent> sysKeyEventProvider, Provider<LauncherRepository> launcherRepositoryProvider, Provider<NoDisturbComponent> noDisturbComponentProvider, Provider<PhoneStatusComponent> phoneStatusComponentProvider, Provider<IRecentTaskRepository> recentTaskRepositoryProvider) {
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.launcherRepositoryProvider = launcherRepositoryProvider;
        this.noDisturbComponentProvider = noDisturbComponentProvider;
        this.phoneStatusComponentProvider = phoneStatusComponentProvider;
        this.recentTaskRepositoryProvider = recentTaskRepositoryProvider;
    }

    public static MembersInjector<LauncherFragment> create(Provider<SysKeyEvent> sysKeyEventProvider, Provider<LauncherRepository> launcherRepositoryProvider, Provider<NoDisturbComponent> noDisturbComponentProvider, Provider<PhoneStatusComponent> phoneStatusComponentProvider, Provider<IRecentTaskRepository> recentTaskRepositoryProvider) {
        return new LauncherFragment_MembersInjector(sysKeyEventProvider, launcherRepositoryProvider, noDisturbComponentProvider, phoneStatusComponentProvider, recentTaskRepositoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LauncherFragment instance) {
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
        injectLauncherRepository(instance, this.launcherRepositoryProvider.get());
        injectNoDisturbComponent(instance, this.noDisturbComponentProvider.get());
        injectPhoneStatusComponent(instance, this.phoneStatusComponentProvider.get());
        injectRecentTaskRepository(instance, this.recentTaskRepositoryProvider.get());
    }

    public static void injectSysKeyEvent(LauncherFragment instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectLauncherRepository(LauncherFragment instance, LauncherRepository launcherRepository) {
        instance.launcherRepository = launcherRepository;
    }

    public static void injectNoDisturbComponent(LauncherFragment instance, NoDisturbComponent noDisturbComponent) {
        instance.noDisturbComponent = noDisturbComponent;
    }

    public static void injectPhoneStatusComponent(LauncherFragment instance, PhoneStatusComponent phoneStatusComponent) {
        instance.phoneStatusComponent = phoneStatusComponent;
    }

    public static void injectRecentTaskRepository(LauncherFragment instance, IRecentTaskRepository recentTaskRepository) {
        instance.recentTaskRepository = recentTaskRepository;
    }
}
