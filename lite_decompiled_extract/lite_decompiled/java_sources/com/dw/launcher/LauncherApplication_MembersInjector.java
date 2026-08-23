package com.dw.launcher;

import com.dw.launcher.core.component.NotificationComponent;
import com.dw.launcher.core.component.VoiceComponent;
import com.dw.launcher.data.component.BatteryComponent;
import com.dw.launcher.data.component.LocaleComponent;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.component.PackageManagerComponent;
import com.dw.launcher.data.component.PhoneStatusComponent;
import com.dw.launcher.data.component.WallpaperComponent;
import com.dw.launcher.data.component.WifiComponent;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.data.repository.WatchConfigRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class LauncherApplication_MembersInjector implements MembersInjector<LauncherApplication> {
    private final Provider<LocaleComponent> localeComponentProvider;
    private final Provider<LauncherRepository> mAssetsLaunchRepositoryProvider;
    private final Provider<BatteryComponent> mBatteryComponentProvider;
    private final Provider<PackageManagerComponent> mPackageManagerComponentProvider;
    private final Provider<NoDisturbComponent> noDisturbComponentProvider;
    private final Provider<NotificationComponent> notificationComponentProvider;
    private final Provider<PhoneStatusComponent> phoneStatusComponentProvider;
    private final Provider<VoiceComponent> voiceComponentProvider;
    private final Provider<WallpaperComponent> wallpaperComponentProvider;
    private final Provider<WatchConfigRepository> watchLaunchRepositoryProvider;
    private final Provider<WifiComponent> wifiComponentProvider;

    public LauncherApplication_MembersInjector(Provider<BatteryComponent> mBatteryComponentProvider, Provider<PackageManagerComponent> mPackageManagerComponentProvider, Provider<PhoneStatusComponent> phoneStatusComponentProvider, Provider<NotificationComponent> notificationComponentProvider, Provider<WallpaperComponent> wallpaperComponentProvider, Provider<WifiComponent> wifiComponentProvider, Provider<LauncherRepository> mAssetsLaunchRepositoryProvider, Provider<VoiceComponent> voiceComponentProvider, Provider<LocaleComponent> localeComponentProvider, Provider<NoDisturbComponent> noDisturbComponentProvider, Provider<WatchConfigRepository> watchLaunchRepositoryProvider) {
        this.mBatteryComponentProvider = mBatteryComponentProvider;
        this.mPackageManagerComponentProvider = mPackageManagerComponentProvider;
        this.phoneStatusComponentProvider = phoneStatusComponentProvider;
        this.notificationComponentProvider = notificationComponentProvider;
        this.wallpaperComponentProvider = wallpaperComponentProvider;
        this.wifiComponentProvider = wifiComponentProvider;
        this.mAssetsLaunchRepositoryProvider = mAssetsLaunchRepositoryProvider;
        this.voiceComponentProvider = voiceComponentProvider;
        this.localeComponentProvider = localeComponentProvider;
        this.noDisturbComponentProvider = noDisturbComponentProvider;
        this.watchLaunchRepositoryProvider = watchLaunchRepositoryProvider;
    }

    public static MembersInjector<LauncherApplication> create(Provider<BatteryComponent> mBatteryComponentProvider, Provider<PackageManagerComponent> mPackageManagerComponentProvider, Provider<PhoneStatusComponent> phoneStatusComponentProvider, Provider<NotificationComponent> notificationComponentProvider, Provider<WallpaperComponent> wallpaperComponentProvider, Provider<WifiComponent> wifiComponentProvider, Provider<LauncherRepository> mAssetsLaunchRepositoryProvider, Provider<VoiceComponent> voiceComponentProvider, Provider<LocaleComponent> localeComponentProvider, Provider<NoDisturbComponent> noDisturbComponentProvider, Provider<WatchConfigRepository> watchLaunchRepositoryProvider) {
        return new LauncherApplication_MembersInjector(mBatteryComponentProvider, mPackageManagerComponentProvider, phoneStatusComponentProvider, notificationComponentProvider, wallpaperComponentProvider, wifiComponentProvider, mAssetsLaunchRepositoryProvider, voiceComponentProvider, localeComponentProvider, noDisturbComponentProvider, watchLaunchRepositoryProvider);
    }

    public void injectMembers(LauncherApplication instance) {
        injectMBatteryComponent(instance, (BatteryComponent) this.mBatteryComponentProvider.get());
        injectMPackageManagerComponent(instance, (PackageManagerComponent) this.mPackageManagerComponentProvider.get());
        injectPhoneStatusComponent(instance, (PhoneStatusComponent) this.phoneStatusComponentProvider.get());
        injectNotificationComponent(instance, (NotificationComponent) this.notificationComponentProvider.get());
        injectWallpaperComponent(instance, (WallpaperComponent) this.wallpaperComponentProvider.get());
        injectWifiComponent(instance, (WifiComponent) this.wifiComponentProvider.get());
        injectMAssetsLaunchRepository(instance, (LauncherRepository) this.mAssetsLaunchRepositoryProvider.get());
        injectVoiceComponent(instance, (VoiceComponent) this.voiceComponentProvider.get());
        injectLocaleComponent(instance, (LocaleComponent) this.localeComponentProvider.get());
        injectNoDisturbComponent(instance, (NoDisturbComponent) this.noDisturbComponentProvider.get());
        injectWatchLaunchRepository(instance, (WatchConfigRepository) this.watchLaunchRepositoryProvider.get());
    }

    public static void injectMBatteryComponent(LauncherApplication instance, BatteryComponent mBatteryComponent) {
        instance.mBatteryComponent = mBatteryComponent;
    }

    public static void injectMPackageManagerComponent(LauncherApplication instance, PackageManagerComponent mPackageManagerComponent) {
        instance.mPackageManagerComponent = mPackageManagerComponent;
    }

    public static void injectPhoneStatusComponent(LauncherApplication instance, PhoneStatusComponent phoneStatusComponent) {
        instance.phoneStatusComponent = phoneStatusComponent;
    }

    public static void injectNotificationComponent(LauncherApplication instance, NotificationComponent notificationComponent) {
        instance.notificationComponent = notificationComponent;
    }

    public static void injectWallpaperComponent(LauncherApplication instance, WallpaperComponent wallpaperComponent) {
        instance.wallpaperComponent = wallpaperComponent;
    }

    public static void injectWifiComponent(LauncherApplication instance, WifiComponent wifiComponent) {
        instance.wifiComponent = wifiComponent;
    }

    public static void injectMAssetsLaunchRepository(LauncherApplication instance, LauncherRepository mAssetsLaunchRepository) {
        instance.mAssetsLaunchRepository = mAssetsLaunchRepository;
    }

    public static void injectVoiceComponent(LauncherApplication instance, VoiceComponent voiceComponent) {
        instance.voiceComponent = voiceComponent;
    }

    public static void injectLocaleComponent(LauncherApplication instance, LocaleComponent localeComponent) {
        instance.localeComponent = localeComponent;
    }

    public static void injectNoDisturbComponent(LauncherApplication instance, NoDisturbComponent noDisturbComponent) {
        instance.noDisturbComponent = noDisturbComponent;
    }

    public static void injectWatchLaunchRepository(LauncherApplication instance, WatchConfigRepository watchLaunchRepository) {
        instance.watchLaunchRepository = watchLaunchRepository;
    }
}
