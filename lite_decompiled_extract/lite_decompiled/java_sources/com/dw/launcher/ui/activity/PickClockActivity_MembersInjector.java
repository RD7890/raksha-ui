package com.dw.launcher.ui.activity;

import com.dw.launcher.core.component.SensorComponent;
import com.dw.launcher.data.database.dao.ClockConfigDao;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.LauncherRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class PickClockActivity_MembersInjector implements MembersInjector<PickClockActivity> {
    private final Provider<LauncherRepository> assertLauncherRepositoryProvider;
    private final Provider<ClockConfigDao> clockConfigDaoProvider;
    private final Provider<LauncherPreference> mPreferenceProvider;
    private final Provider<SensorComponent> mSensorComponentProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public PickClockActivity_MembersInjector(Provider<SysKeyEvent> sysKeyEventProvider, Provider<SensorComponent> mSensorComponentProvider, Provider<LauncherPreference> mPreferenceProvider, Provider<LauncherRepository> assertLauncherRepositoryProvider, Provider<ClockConfigDao> clockConfigDaoProvider) {
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.mSensorComponentProvider = mSensorComponentProvider;
        this.mPreferenceProvider = mPreferenceProvider;
        this.assertLauncherRepositoryProvider = assertLauncherRepositoryProvider;
        this.clockConfigDaoProvider = clockConfigDaoProvider;
    }

    public static MembersInjector<PickClockActivity> create(Provider<SysKeyEvent> sysKeyEventProvider, Provider<SensorComponent> mSensorComponentProvider, Provider<LauncherPreference> mPreferenceProvider, Provider<LauncherRepository> assertLauncherRepositoryProvider, Provider<ClockConfigDao> clockConfigDaoProvider) {
        return new PickClockActivity_MembersInjector(sysKeyEventProvider, mSensorComponentProvider, mPreferenceProvider, assertLauncherRepositoryProvider, clockConfigDaoProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PickClockActivity instance) {
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
        injectMSensorComponent(instance, this.mSensorComponentProvider.get());
        injectMPreference(instance, this.mPreferenceProvider.get());
        injectAssertLauncherRepository(instance, this.assertLauncherRepositoryProvider.get());
        injectClockConfigDao(instance, this.clockConfigDaoProvider.get());
    }

    public static void injectSysKeyEvent(PickClockActivity instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectMSensorComponent(PickClockActivity instance, SensorComponent mSensorComponent) {
        instance.mSensorComponent = mSensorComponent;
    }

    public static void injectMPreference(PickClockActivity instance, LauncherPreference mPreference) {
        instance.mPreference = mPreference;
    }

    public static void injectAssertLauncherRepository(PickClockActivity instance, LauncherRepository assertLauncherRepository) {
        instance.assertLauncherRepository = assertLauncherRepository;
    }

    public static void injectClockConfigDao(PickClockActivity instance, ClockConfigDao clockConfigDao) {
        instance.clockConfigDao = clockConfigDao;
    }
}
