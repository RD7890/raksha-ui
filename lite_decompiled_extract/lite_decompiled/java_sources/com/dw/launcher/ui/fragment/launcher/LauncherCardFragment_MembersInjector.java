package com.dw.launcher.ui.fragment.launcher;

import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.component.PhoneStatusComponent;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.SharedPreferencesUtils;
import com.dw.launcher.data.repository.IRecentTaskRepository;
import com.dw.launcher.data.repository.LauncherRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class LauncherCardFragment_MembersInjector implements MembersInjector<LauncherCardFragment> {
    private final Provider<LauncherRepository> launcherRepositoryProvider;
    private final Provider<NoDisturbComponent> noDisturbComponentProvider;
    private final Provider<PhoneStatusComponent> phoneStatusComponentProvider;
    private final Provider<IRecentTaskRepository> recentTaskRepositoryProvider;
    private final Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public LauncherCardFragment_MembersInjector(Provider<SysKeyEvent> sysKeyEventProvider, Provider<LauncherRepository> launcherRepositoryProvider, Provider<IRecentTaskRepository> recentTaskRepositoryProvider, Provider<NoDisturbComponent> noDisturbComponentProvider, Provider<PhoneStatusComponent> phoneStatusComponentProvider, Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider) {
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.launcherRepositoryProvider = launcherRepositoryProvider;
        this.recentTaskRepositoryProvider = recentTaskRepositoryProvider;
        this.noDisturbComponentProvider = noDisturbComponentProvider;
        this.phoneStatusComponentProvider = phoneStatusComponentProvider;
        this.sharedPreferencesUtilsProvider = sharedPreferencesUtilsProvider;
    }

    public static MembersInjector<LauncherCardFragment> create(Provider<SysKeyEvent> sysKeyEventProvider, Provider<LauncherRepository> launcherRepositoryProvider, Provider<IRecentTaskRepository> recentTaskRepositoryProvider, Provider<NoDisturbComponent> noDisturbComponentProvider, Provider<PhoneStatusComponent> phoneStatusComponentProvider, Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider) {
        return new LauncherCardFragment_MembersInjector(sysKeyEventProvider, launcherRepositoryProvider, recentTaskRepositoryProvider, noDisturbComponentProvider, phoneStatusComponentProvider, sharedPreferencesUtilsProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LauncherCardFragment instance) {
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
        injectLauncherRepository(instance, this.launcherRepositoryProvider.get());
        injectRecentTaskRepository(instance, this.recentTaskRepositoryProvider.get());
        injectNoDisturbComponent(instance, this.noDisturbComponentProvider.get());
        injectPhoneStatusComponent(instance, this.phoneStatusComponentProvider.get());
        injectSharedPreferencesUtils(instance, this.sharedPreferencesUtilsProvider.get());
    }

    public static void injectSysKeyEvent(LauncherCardFragment instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectLauncherRepository(LauncherCardFragment instance, LauncherRepository launcherRepository) {
        instance.launcherRepository = launcherRepository;
    }

    public static void injectRecentTaskRepository(LauncherCardFragment instance, IRecentTaskRepository recentTaskRepository) {
        instance.recentTaskRepository = recentTaskRepository;
    }

    public static void injectNoDisturbComponent(LauncherCardFragment instance, NoDisturbComponent noDisturbComponent) {
        instance.noDisturbComponent = noDisturbComponent;
    }

    public static void injectPhoneStatusComponent(LauncherCardFragment instance, PhoneStatusComponent phoneStatusComponent) {
        instance.phoneStatusComponent = phoneStatusComponent;
    }

    public static void injectSharedPreferencesUtils(LauncherCardFragment instance, SharedPreferencesUtils sharedPreferencesUtils) {
        instance.sharedPreferencesUtils = sharedPreferencesUtils;
    }
}
