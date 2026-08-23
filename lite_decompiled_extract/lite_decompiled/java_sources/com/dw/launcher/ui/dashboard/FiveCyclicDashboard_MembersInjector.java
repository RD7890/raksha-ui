package com.dw.launcher.ui.dashboard;

import com.dw.launcher.core.component.SensorComponent;
import com.dw.launcher.core.component.SoundEffect;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.component.WallpaperComponent;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class FiveCyclicDashboard_MembersInjector implements MembersInjector<FiveCyclicDashboard> {
    private final Provider<LauncherPreference> mPreferenceProvider;
    private final Provider<SensorComponent> mSensorComponentProvider;
    private final Provider<NoDisturbComponent> noDisturbComponentProvider;
    private final Provider<SoundEffect> soundEffectProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;
    private final Provider<WallpaperComponent> wallpaperComponentProvider;

    public FiveCyclicDashboard_MembersInjector(Provider<SensorComponent> mSensorComponentProvider, Provider<SoundEffect> soundEffectProvider, Provider<WallpaperComponent> wallpaperComponentProvider, Provider<LauncherPreference> mPreferenceProvider, Provider<NoDisturbComponent> noDisturbComponentProvider, Provider<SysKeyEvent> sysKeyEventProvider) {
        this.mSensorComponentProvider = mSensorComponentProvider;
        this.soundEffectProvider = soundEffectProvider;
        this.wallpaperComponentProvider = wallpaperComponentProvider;
        this.mPreferenceProvider = mPreferenceProvider;
        this.noDisturbComponentProvider = noDisturbComponentProvider;
        this.sysKeyEventProvider = sysKeyEventProvider;
    }

    public static MembersInjector<FiveCyclicDashboard> create(Provider<SensorComponent> mSensorComponentProvider, Provider<SoundEffect> soundEffectProvider, Provider<WallpaperComponent> wallpaperComponentProvider, Provider<LauncherPreference> mPreferenceProvider, Provider<NoDisturbComponent> noDisturbComponentProvider, Provider<SysKeyEvent> sysKeyEventProvider) {
        return new FiveCyclicDashboard_MembersInjector(mSensorComponentProvider, soundEffectProvider, wallpaperComponentProvider, mPreferenceProvider, noDisturbComponentProvider, sysKeyEventProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FiveCyclicDashboard instance) {
        BaseDashboard_MembersInjector.injectMSensorComponent(instance, this.mSensorComponentProvider.get());
        BaseDashboard_MembersInjector.injectSoundEffect(instance, this.soundEffectProvider.get());
        BaseDashboard_MembersInjector.injectWallpaperComponent(instance, this.wallpaperComponentProvider.get());
        BaseDashboard_MembersInjector.injectMPreference(instance, this.mPreferenceProvider.get());
        BaseDashboard_MembersInjector.injectNoDisturbComponent(instance, this.noDisturbComponentProvider.get());
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
    }

    public static void injectSysKeyEvent(FiveCyclicDashboard instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }
}
