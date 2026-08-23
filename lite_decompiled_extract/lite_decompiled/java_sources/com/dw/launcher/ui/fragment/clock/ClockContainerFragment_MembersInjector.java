package com.dw.launcher.ui.fragment.clock;

import com.dw.launcher.core.component.CompassSensorComponent;
import com.dw.launcher.core.component.SensorComponent;
import com.dw.launcher.core.component.SoundEffect;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.AssetsClockRepository;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.hilt.annotion.RingToneAnnotion;
import com.dw.launcher.ui.clock.ClockRegister;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class ClockContainerFragment_MembersInjector implements MembersInjector<ClockContainerFragment> {
    private final Provider<LauncherRepository> assertLauncherRepositoryProvider;
    private final Provider<AssetsClockRepository> assetsClockRepositoryProvider;
    private final Provider<ClockRegister> mClockRegisterProvider;
    private final Provider<CompassSensorComponent> mCompassSensorComponentProvider;
    private final Provider<LauncherPreference> mPreferenceProvider;
    private final Provider<SoundEffect> mRingtoneComponentProvider;
    private final Provider<SensorComponent> mSensorComponentProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public ClockContainerFragment_MembersInjector(Provider<ClockRegister> mClockRegisterProvider, Provider<LauncherPreference> mPreferenceProvider, Provider<SensorComponent> mSensorComponentProvider, Provider<CompassSensorComponent> mCompassSensorComponentProvider, Provider<SoundEffect> mRingtoneComponentProvider, Provider<SysKeyEvent> sysKeyEventProvider, Provider<AssetsClockRepository> assetsClockRepositoryProvider, Provider<LauncherRepository> assertLauncherRepositoryProvider) {
        this.mClockRegisterProvider = mClockRegisterProvider;
        this.mPreferenceProvider = mPreferenceProvider;
        this.mSensorComponentProvider = mSensorComponentProvider;
        this.mCompassSensorComponentProvider = mCompassSensorComponentProvider;
        this.mRingtoneComponentProvider = mRingtoneComponentProvider;
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.assetsClockRepositoryProvider = assetsClockRepositoryProvider;
        this.assertLauncherRepositoryProvider = assertLauncherRepositoryProvider;
    }

    public static MembersInjector<ClockContainerFragment> create(Provider<ClockRegister> mClockRegisterProvider, Provider<LauncherPreference> mPreferenceProvider, Provider<SensorComponent> mSensorComponentProvider, Provider<CompassSensorComponent> mCompassSensorComponentProvider, Provider<SoundEffect> mRingtoneComponentProvider, Provider<SysKeyEvent> sysKeyEventProvider, Provider<AssetsClockRepository> assetsClockRepositoryProvider, Provider<LauncherRepository> assertLauncherRepositoryProvider) {
        return new ClockContainerFragment_MembersInjector(mClockRegisterProvider, mPreferenceProvider, mSensorComponentProvider, mCompassSensorComponentProvider, mRingtoneComponentProvider, sysKeyEventProvider, assetsClockRepositoryProvider, assertLauncherRepositoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ClockContainerFragment instance) {
        injectMClockRegister(instance, this.mClockRegisterProvider.get());
        injectMPreference(instance, this.mPreferenceProvider.get());
        injectMSensorComponent(instance, this.mSensorComponentProvider.get());
        injectMCompassSensorComponent(instance, this.mCompassSensorComponentProvider.get());
        injectMRingtoneComponent(instance, this.mRingtoneComponentProvider.get());
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
        injectAssetsClockRepository(instance, this.assetsClockRepositoryProvider.get());
        injectAssertLauncherRepository(instance, this.assertLauncherRepositoryProvider.get());
    }

    public static void injectMClockRegister(ClockContainerFragment instance, ClockRegister mClockRegister) {
        instance.mClockRegister = mClockRegister;
    }

    public static void injectMPreference(ClockContainerFragment instance, LauncherPreference mPreference) {
        instance.mPreference = mPreference;
    }

    public static void injectMSensorComponent(ClockContainerFragment instance, SensorComponent mSensorComponent) {
        instance.mSensorComponent = mSensorComponent;
    }

    public static void injectMCompassSensorComponent(ClockContainerFragment instance, CompassSensorComponent mCompassSensorComponent) {
        instance.mCompassSensorComponent = mCompassSensorComponent;
    }

    @RingToneAnnotion
    public static void injectMRingtoneComponent(ClockContainerFragment instance, SoundEffect mRingtoneComponent) {
        instance.mRingtoneComponent = mRingtoneComponent;
    }

    public static void injectSysKeyEvent(ClockContainerFragment instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectAssetsClockRepository(ClockContainerFragment instance, AssetsClockRepository assetsClockRepository) {
        instance.assetsClockRepository = assetsClockRepository;
    }

    public static void injectAssertLauncherRepository(ClockContainerFragment instance, LauncherRepository assertLauncherRepository) {
        instance.assertLauncherRepository = assertLauncherRepository;
    }
}
