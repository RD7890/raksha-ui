package com.dw.launcher.ui.activity;

import com.dw.launcher.core.component.SensorComponent;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.IDashboardRepository;
import com.dw.launcher.data.repository.LauncherRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class PickDashboardActivity_MembersInjector implements MembersInjector<PickDashboardActivity> {
    private final Provider<IDashboardRepository> mDashboardRepositoryProvider;
    private final Provider<LauncherPreference> mLauncherPreferenceProvider;
    private final Provider<LauncherRepository> mLauncherRepositoryProvider;
    private final Provider<SensorComponent> mSensorComponentProvider;
    private final Provider<NoDisturbComponent> noDisturbComponentProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public PickDashboardActivity_MembersInjector(Provider<IDashboardRepository> mDashboardRepositoryProvider, Provider<LauncherRepository> mLauncherRepositoryProvider, Provider<LauncherPreference> mLauncherPreferenceProvider, Provider<SensorComponent> mSensorComponentProvider, Provider<SysKeyEvent> sysKeyEventProvider, Provider<NoDisturbComponent> noDisturbComponentProvider) {
        this.mDashboardRepositoryProvider = mDashboardRepositoryProvider;
        this.mLauncherRepositoryProvider = mLauncherRepositoryProvider;
        this.mLauncherPreferenceProvider = mLauncherPreferenceProvider;
        this.mSensorComponentProvider = mSensorComponentProvider;
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.noDisturbComponentProvider = noDisturbComponentProvider;
    }

    public static MembersInjector<PickDashboardActivity> create(Provider<IDashboardRepository> mDashboardRepositoryProvider, Provider<LauncherRepository> mLauncherRepositoryProvider, Provider<LauncherPreference> mLauncherPreferenceProvider, Provider<SensorComponent> mSensorComponentProvider, Provider<SysKeyEvent> sysKeyEventProvider, Provider<NoDisturbComponent> noDisturbComponentProvider) {
        return new PickDashboardActivity_MembersInjector(mDashboardRepositoryProvider, mLauncherRepositoryProvider, mLauncherPreferenceProvider, mSensorComponentProvider, sysKeyEventProvider, noDisturbComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PickDashboardActivity instance) {
        injectMDashboardRepository(instance, this.mDashboardRepositoryProvider.get());
        injectMLauncherRepository(instance, this.mLauncherRepositoryProvider.get());
        injectMLauncherPreference(instance, this.mLauncherPreferenceProvider.get());
        injectMSensorComponent(instance, this.mSensorComponentProvider.get());
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
        injectNoDisturbComponent(instance, this.noDisturbComponentProvider.get());
    }

    public static void injectMDashboardRepository(PickDashboardActivity instance, IDashboardRepository mDashboardRepository) {
        instance.mDashboardRepository = mDashboardRepository;
    }

    public static void injectMLauncherRepository(PickDashboardActivity instance, LauncherRepository mLauncherRepository) {
        instance.mLauncherRepository = mLauncherRepository;
    }

    public static void injectMLauncherPreference(PickDashboardActivity instance, LauncherPreference mLauncherPreference) {
        instance.mLauncherPreference = mLauncherPreference;
    }

    public static void injectMSensorComponent(PickDashboardActivity instance, SensorComponent mSensorComponent) {
        instance.mSensorComponent = mSensorComponent;
    }

    public static void injectSysKeyEvent(PickDashboardActivity instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectNoDisturbComponent(PickDashboardActivity instance, NoDisturbComponent noDisturbComponent) {
        instance.noDisturbComponent = noDisturbComponent;
    }
}
