package com.dw.launcher.ui.fragment.clock;

import com.dw.launcher.core.component.CompassSensorComponent;
import com.dw.launcher.core.component.SensorComponent;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.database.dao.ClockConfigDao;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.data.repository.WatchConfigRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class DialFragment_MembersInjector implements MembersInjector<DialFragment> {
    private final Provider<LauncherRepository> assertLauncherRepositoryProvider;
    private final Provider<ClockConfigDao> clockConfigDaoProvider;
    private final Provider<WatchConfigRepository> launchRepositoryProvider;
    private final Provider<CompassSensorComponent> mCompassSensorComponentProvider;
    private final Provider<LauncherPreference> mPreferenceProvider;
    private final Provider<SensorComponent> mSensorComponentProvider;
    private final Provider<NoDisturbComponent> noDisturbComponentProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public DialFragment_MembersInjector(Provider<LauncherPreference> mPreferenceProvider, Provider<SensorComponent> mSensorComponentProvider, Provider<SysKeyEvent> sysKeyEventProvider, Provider<WatchConfigRepository> launchRepositoryProvider, Provider<LauncherRepository> assertLauncherRepositoryProvider, Provider<CompassSensorComponent> mCompassSensorComponentProvider, Provider<ClockConfigDao> clockConfigDaoProvider, Provider<NoDisturbComponent> noDisturbComponentProvider) {
        this.mPreferenceProvider = mPreferenceProvider;
        this.mSensorComponentProvider = mSensorComponentProvider;
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.launchRepositoryProvider = launchRepositoryProvider;
        this.assertLauncherRepositoryProvider = assertLauncherRepositoryProvider;
        this.mCompassSensorComponentProvider = mCompassSensorComponentProvider;
        this.clockConfigDaoProvider = clockConfigDaoProvider;
        this.noDisturbComponentProvider = noDisturbComponentProvider;
    }

    public static MembersInjector<DialFragment> create(Provider<LauncherPreference> mPreferenceProvider, Provider<SensorComponent> mSensorComponentProvider, Provider<SysKeyEvent> sysKeyEventProvider, Provider<WatchConfigRepository> launchRepositoryProvider, Provider<LauncherRepository> assertLauncherRepositoryProvider, Provider<CompassSensorComponent> mCompassSensorComponentProvider, Provider<ClockConfigDao> clockConfigDaoProvider, Provider<NoDisturbComponent> noDisturbComponentProvider) {
        return new DialFragment_MembersInjector(mPreferenceProvider, mSensorComponentProvider, sysKeyEventProvider, launchRepositoryProvider, assertLauncherRepositoryProvider, mCompassSensorComponentProvider, clockConfigDaoProvider, noDisturbComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DialFragment instance) {
        injectMPreference(instance, this.mPreferenceProvider.get());
        injectMSensorComponent(instance, this.mSensorComponentProvider.get());
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
        injectLaunchRepository(instance, this.launchRepositoryProvider.get());
        injectAssertLauncherRepository(instance, this.assertLauncherRepositoryProvider.get());
        injectMCompassSensorComponent(instance, this.mCompassSensorComponentProvider.get());
        injectClockConfigDao(instance, this.clockConfigDaoProvider.get());
        injectNoDisturbComponent(instance, this.noDisturbComponentProvider.get());
    }

    public static void injectMPreference(DialFragment instance, LauncherPreference mPreference) {
        instance.mPreference = mPreference;
    }

    public static void injectMSensorComponent(DialFragment instance, SensorComponent mSensorComponent) {
        instance.mSensorComponent = mSensorComponent;
    }

    public static void injectSysKeyEvent(DialFragment instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectLaunchRepository(DialFragment instance, WatchConfigRepository launchRepository) {
        instance.launchRepository = launchRepository;
    }

    public static void injectAssertLauncherRepository(DialFragment instance, LauncherRepository assertLauncherRepository) {
        instance.assertLauncherRepository = assertLauncherRepository;
    }

    public static void injectMCompassSensorComponent(DialFragment instance, CompassSensorComponent mCompassSensorComponent) {
        instance.mCompassSensorComponent = mCompassSensorComponent;
    }

    public static void injectClockConfigDao(DialFragment instance, ClockConfigDao clockConfigDao) {
        instance.clockConfigDao = clockConfigDao;
    }

    public static void injectNoDisturbComponent(DialFragment instance, NoDisturbComponent noDisturbComponent) {
        instance.noDisturbComponent = noDisturbComponent;
    }
}
