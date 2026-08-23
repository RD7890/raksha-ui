package com.dw.launcher.ui.fragment.dashboard;

import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.LauncherRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class DashboardContainerFragment_MembersInjector implements MembersInjector<DashboardContainerFragment> {
    private final Provider<LauncherRepository> mAssetsLaunchRepositoryProvider;
    private final Provider<LauncherPreference> mPreferenceProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public DashboardContainerFragment_MembersInjector(Provider<LauncherPreference> mPreferenceProvider, Provider<SysKeyEvent> sysKeyEventProvider, Provider<LauncherRepository> mAssetsLaunchRepositoryProvider) {
        this.mPreferenceProvider = mPreferenceProvider;
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.mAssetsLaunchRepositoryProvider = mAssetsLaunchRepositoryProvider;
    }

    public static MembersInjector<DashboardContainerFragment> create(Provider<LauncherPreference> mPreferenceProvider, Provider<SysKeyEvent> sysKeyEventProvider, Provider<LauncherRepository> mAssetsLaunchRepositoryProvider) {
        return new DashboardContainerFragment_MembersInjector(mPreferenceProvider, sysKeyEventProvider, mAssetsLaunchRepositoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DashboardContainerFragment instance) {
        injectMPreference(instance, this.mPreferenceProvider.get());
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
        injectMAssetsLaunchRepository(instance, this.mAssetsLaunchRepositoryProvider.get());
    }

    public static void injectMPreference(DashboardContainerFragment instance, LauncherPreference mPreference) {
        instance.mPreference = mPreference;
    }

    public static void injectSysKeyEvent(DashboardContainerFragment instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectMAssetsLaunchRepository(DashboardContainerFragment instance, LauncherRepository mAssetsLaunchRepository) {
        instance.mAssetsLaunchRepository = mAssetsLaunchRepository;
    }
}
