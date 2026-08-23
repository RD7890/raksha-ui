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
public final class VerticalGridDashboardNoTitle_MembersInjector implements MembersInjector<VerticalGridDashboardNoTitle> {
    private final Provider<LauncherRepository> launcherRepositoryProvider;
    private final Provider<LauncherPreference> mPreferenceProvider;
    private final Provider<SensorComponent> mSensorComponentProvider;
    private final Provider<NoDisturbComponent> noDisturbComponentProvider;
    private final Provider<SoundEffect> soundEffectProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;
    private final Provider<WallpaperComponent> wallpaperComponentProvider;

    public VerticalGridDashboardNoTitle_MembersInjector(Provider<SensorComponent> mSensorComponentProvider, Provider<SoundEffect> soundEffectProvider, Provider<WallpaperComponent> wallpaperComponentProvider, Provider<LauncherPreference> mPreferenceProvider, Provider<NoDisturbComponent> noDisturbComponentProvider, Provider<LauncherRepository> launcherRepositoryProvider, Provider<SysKeyEvent> sysKeyEventProvider) {
        this.mSensorComponentProvider = mSensorComponentProvider;
        this.soundEffectProvider = soundEffectProvider;
        this.wallpaperComponentProvider = wallpaperComponentProvider;
        this.mPreferenceProvider = mPreferenceProvider;
        this.noDisturbComponentProvider = noDisturbComponentProvider;
        this.launcherRepositoryProvider = launcherRepositoryProvider;
        this.sysKeyEventProvider = sysKeyEventProvider;
    }

    public static MembersInjector<VerticalGridDashboardNoTitle> create(Provider<SensorComponent> mSensorComponentProvider, Provider<SoundEffect> soundEffectProvider, Provider<WallpaperComponent> wallpaperComponentProvider, Provider<LauncherPreference> mPreferenceProvider, Provider<NoDisturbComponent> noDisturbComponentProvider, Provider<LauncherRepository> launcherRepositoryProvider, Provider<SysKeyEvent> sysKeyEventProvider) {
        return new VerticalGridDashboardNoTitle_MembersInjector(mSensorComponentProvider, soundEffectProvider, wallpaperComponentProvider, mPreferenceProvider, noDisturbComponentProvider, launcherRepositoryProvider, sysKeyEventProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(VerticalGridDashboardNoTitle instance) {
        BaseDashboard_MembersInjector.injectMSensorComponent(instance, this.mSensorComponentProvider.get());
        BaseDashboard_MembersInjector.injectSoundEffect(instance, this.soundEffectProvider.get());
        BaseDashboard_MembersInjector.injectWallpaperComponent(instance, this.wallpaperComponentProvider.get());
        BaseDashboard_MembersInjector.injectMPreference(instance, this.mPreferenceProvider.get());
        BaseDashboard_MembersInjector.injectNoDisturbComponent(instance, this.noDisturbComponentProvider.get());
        injectLauncherRepository(instance, this.launcherRepositoryProvider.get());
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
    }

    public static void injectLauncherRepository(VerticalGridDashboardNoTitle instance, LauncherRepository launcherRepository) {
        instance.launcherRepository = launcherRepository;
    }

    public static void injectSysKeyEvent(VerticalGridDashboardNoTitle instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }
}
