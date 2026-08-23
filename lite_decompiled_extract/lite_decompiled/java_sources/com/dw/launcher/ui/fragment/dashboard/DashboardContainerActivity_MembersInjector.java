package com.dw.launcher.ui.fragment.dashboard;

import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.LauncherRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class DashboardContainerActivity_MembersInjector implements MembersInjector<DashboardContainerActivity> {
    private final Provider<LauncherRepository> mAssetsLaunchRepositoryProvider;
    private final Provider<LauncherPreference> mPreferenceProvider;
    private final Provider<NoDisturbComponent> noDisturbComponentProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public DashboardContainerActivity_MembersInjector(Provider<LauncherPreference> mPreferenceProvider, Provider<SysKeyEvent> sysKeyEventProvider, Provider<LauncherRepository> mAssetsLaunchRepositoryProvider, Provider<NoDisturbComponent> noDisturbComponentProvider) {
        this.mPreferenceProvider = mPreferenceProvider;
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.mAssetsLaunchRepositoryProvider = mAssetsLaunchRepositoryProvider;
        this.noDisturbComponentProvider = noDisturbComponentProvider;
    }

    public static MembersInjector<DashboardContainerActivity> create(Provider<LauncherPreference> mPreferenceProvider, Provider<SysKeyEvent> sysKeyEventProvider, Provider<LauncherRepository> mAssetsLaunchRepositoryProvider, Provider<NoDisturbComponent> noDisturbComponentProvider) {
        return new DashboardContainerActivity_MembersInjector(mPreferenceProvider, sysKeyEventProvider, mAssetsLaunchRepositoryProvider, noDisturbComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DashboardContainerActivity instance) {
        injectMPreference(instance, this.mPreferenceProvider.get());
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
        injectMAssetsLaunchRepository(instance, this.mAssetsLaunchRepositoryProvider.get());
        injectNoDisturbComponent(instance, this.noDisturbComponentProvider.get());
    }

    public static void injectMPreference(DashboardContainerActivity instance, LauncherPreference mPreference) {
        instance.mPreference = mPreference;
    }

    public static void injectSysKeyEvent(DashboardContainerActivity instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectMAssetsLaunchRepository(DashboardContainerActivity instance, LauncherRepository mAssetsLaunchRepository) {
        instance.mAssetsLaunchRepository = mAssetsLaunchRepository;
    }

    public static void injectNoDisturbComponent(DashboardContainerActivity instance, NoDisturbComponent noDisturbComponent) {
        instance.noDisturbComponent = noDisturbComponent;
    }
}
