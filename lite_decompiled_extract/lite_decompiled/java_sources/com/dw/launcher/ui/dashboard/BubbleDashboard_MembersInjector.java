package com.dw.launcher.ui.dashboard;

import com.dw.launcher.core.component.SensorComponent;
import com.dw.launcher.core.component.SoundEffect;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.component.WallpaperComponent;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.LauncherRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class BubbleDashboard_MembersInjector implements MembersInjector<BubbleDashboard> {
    private final Provider<LauncherRepository> assetsLaunchRepositoryProvider;
    private final Provider<LauncherRepository> launcherRepositoryProvider;
    private final Provider<LauncherPreference> mPreferenceProvider;
    private final Provider<SensorComponent> mSensorComponentProvider;
    private final Provider<NoDisturbComponent> noDisturbComponentProvider;
    private final Provider<SoundEffect> soundEffectProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;
    private final Provider<WallpaperComponent> wallpaperComponentProvider;

    public BubbleDashboard_MembersInjector(Provider<SensorComponent> mSensorComponentProvider, Provider<SoundEffect> soundEffectProvider, Provider<WallpaperComponent> wallpaperComponentProvider, Provider<LauncherPreference> mPreferenceProvider, Provider<NoDisturbComponent> noDisturbComponentProvider, Provider<SysKeyEvent> sysKeyEventProvider, Provider<LauncherRepository> assetsLaunchRepositoryProvider, Provider<LauncherRepository> launcherRepositoryProvider) {
        this.mSensorComponentProvider = mSensorComponentProvider;
        this.soundEffectProvider = soundEffectProvider;
        this.wallpaperComponentProvider = wallpaperComponentProvider;
        this.mPreferenceProvider = mPreferenceProvider;
        this.noDisturbComponentProvider = noDisturbComponentProvider;
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.assetsLaunchRepositoryProvider = assetsLaunchRepositoryProvider;
        this.launcherRepositoryProvider = launcherRepositoryProvider;
    }

    public static MembersInjector<BubbleDashboard> create(Provider<SensorComponent> mSensorComponentProvider, Provider<SoundEffect> soundEffectProvider, Provider<WallpaperComponent> wallpaperComponentProvider, Provider<LauncherPreference> mPreferenceProvider, Provider<NoDisturbComponent> noDisturbComponentProvider, Provider<SysKeyEvent> sysKeyEventProvider, Provider<LauncherRepository> assetsLaunchRepositoryProvider, Provider<LauncherRepository> launcherRepositoryProvider) {
        return new BubbleDashboard_MembersInjector(mSensorComponentProvider, soundEffectProvider, wallpaperComponentProvider, mPreferenceProvider, noDisturbComponentProvider, sysKeyEventProvider, assetsLaunchRepositoryProvider, launcherRepositoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BubbleDashboard instance) {
        BaseDashboard_MembersInjector.injectMSensorComponent(instance, this.mSensorComponentProvider.get());
        BaseDashboard_MembersInjector.injectSoundEffect(instance, this.soundEffectProvider.get());
        BaseDashboard_MembersInjector.injectWallpaperComponent(instance, this.wallpaperComponentProvider.get());
        BaseDashboard_MembersInjector.injectMPreference(instance, this.mPreferenceProvider.get());
        BaseDashboard_MembersInjector.injectNoDisturbComponent(instance, this.noDisturbComponentProvider.get());
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
        injectAssetsLaunchRepository(instance, this.assetsLaunchRepositoryProvider.get());
        injectLauncherRepository(instance, this.launcherRepositoryProvider.get());
    }

    public static void injectSysKeyEvent(BubbleDashboard instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectAssetsLaunchRepository(BubbleDashboard instance, LauncherRepository assetsLaunchRepository) {
        instance.assetsLaunchRepository = assetsLaunchRepository;
    }

    public static void injectLauncherRepository(BubbleDashboard instance, LauncherRepository launcherRepository) {
        instance.launcherRepository = launcherRepository;
    }
}
