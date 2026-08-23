package com.dw.launcher.ui.dashboard;

import com.dw.launcher.core.component.SensorComponent;
import com.dw.launcher.core.component.SoundEffect;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.component.WallpaperComponent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.hilt.annotion.SoundPoolAnnotion;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class BaseDashboard_MembersInjector implements MembersInjector<BaseDashboard> {
    private final Provider<LauncherPreference> mPreferenceProvider;
    private final Provider<SensorComponent> mSensorComponentProvider;
    private final Provider<NoDisturbComponent> noDisturbComponentProvider;
    private final Provider<SoundEffect> soundEffectProvider;
    private final Provider<WallpaperComponent> wallpaperComponentProvider;

    public BaseDashboard_MembersInjector(Provider<SensorComponent> mSensorComponentProvider, Provider<SoundEffect> soundEffectProvider, Provider<WallpaperComponent> wallpaperComponentProvider, Provider<LauncherPreference> mPreferenceProvider, Provider<NoDisturbComponent> noDisturbComponentProvider) {
        this.mSensorComponentProvider = mSensorComponentProvider;
        this.soundEffectProvider = soundEffectProvider;
        this.wallpaperComponentProvider = wallpaperComponentProvider;
        this.mPreferenceProvider = mPreferenceProvider;
        this.noDisturbComponentProvider = noDisturbComponentProvider;
    }

    public static MembersInjector<BaseDashboard> create(Provider<SensorComponent> mSensorComponentProvider, Provider<SoundEffect> soundEffectProvider, Provider<WallpaperComponent> wallpaperComponentProvider, Provider<LauncherPreference> mPreferenceProvider, Provider<NoDisturbComponent> noDisturbComponentProvider) {
        return new BaseDashboard_MembersInjector(mSensorComponentProvider, soundEffectProvider, wallpaperComponentProvider, mPreferenceProvider, noDisturbComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BaseDashboard instance) {
        injectMSensorComponent(instance, this.mSensorComponentProvider.get());
        injectSoundEffect(instance, this.soundEffectProvider.get());
        injectWallpaperComponent(instance, this.wallpaperComponentProvider.get());
        injectMPreference(instance, this.mPreferenceProvider.get());
        injectNoDisturbComponent(instance, this.noDisturbComponentProvider.get());
    }

    public static void injectMSensorComponent(BaseDashboard instance, SensorComponent mSensorComponent) {
        instance.mSensorComponent = mSensorComponent;
    }

    @SoundPoolAnnotion
    public static void injectSoundEffect(BaseDashboard instance, SoundEffect soundEffect) {
        instance.soundEffect = soundEffect;
    }

    public static void injectWallpaperComponent(BaseDashboard instance, WallpaperComponent wallpaperComponent) {
        instance.wallpaperComponent = wallpaperComponent;
    }

    public static void injectMPreference(BaseDashboard instance, LauncherPreference mPreference) {
        instance.mPreference = mPreference;
    }

    public static void injectNoDisturbComponent(BaseDashboard instance, NoDisturbComponent noDisturbComponent) {
        instance.noDisturbComponent = noDisturbComponent;
    }
}
