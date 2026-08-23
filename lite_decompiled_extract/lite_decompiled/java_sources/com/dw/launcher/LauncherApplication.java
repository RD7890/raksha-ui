package com.dw.launcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.dw.launcher.core.component.NotificationComponent;
import com.dw.launcher.core.component.VoiceComponent;
import com.dw.launcher.core.receiver.MockReceiver;
import com.dw.launcher.data.component.BatteryComponent;
import com.dw.launcher.data.component.LocaleComponent;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.component.PackageManagerComponent;
import com.dw.launcher.data.component.PhoneStatusComponent;
import com.dw.launcher.data.component.WallpaperComponent;
import com.dw.launcher.data.component.WifiComponent;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.data.repository.WatchConfigRepository;
import com.dw.launcher.tts.PhoneReceiver;
import com.dw.launcher.tts.TtsSpeakManager;
import com.dw.launcher.tts.UsbReceiver;
import com.tencent.bugly.crashreport.CrashReport;
import dagger.hilt.android.HiltAndroidApp;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: LauncherApplication.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010TH\u0014J\b\u0010U\u001a\u0004\u0018\u00010VJ\b\u0010W\u001a\u00020RH\u0016J\b\u0010X\u001a\u00020RH\u0016J\b\u0010Y\u001a\u00020RH\u0002J\u0006\u0010Z\u001a\u00020RJ\b\u0010[\u001a\u00020RH\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u00109\u001a\u00020:8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020@8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001e\u0010E\u001a\u00020F8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010K\u001a\u00020L8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006]"}, d2 = {"Lcom/dw/launcher/LauncherApplication;", "Landroid/app/Application;", "()V", "localeComponent", "Lcom/dw/launcher/data/component/LocaleComponent;", "getLocaleComponent", "()Lcom/dw/launcher/data/component/LocaleComponent;", "setLocaleComponent", "(Lcom/dw/launcher/data/component/LocaleComponent;)V", "mAssetsLaunchRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getMAssetsLaunchRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setMAssetsLaunchRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "mBatteryComponent", "Lcom/dw/launcher/data/component/BatteryComponent;", "getMBatteryComponent", "()Lcom/dw/launcher/data/component/BatteryComponent;", "setMBatteryComponent", "(Lcom/dw/launcher/data/component/BatteryComponent;)V", "mPackageManagerComponent", "Lcom/dw/launcher/data/component/PackageManagerComponent;", "getMPackageManagerComponent", "()Lcom/dw/launcher/data/component/PackageManagerComponent;", "setMPackageManagerComponent", "(Lcom/dw/launcher/data/component/PackageManagerComponent;)V", "noDisturbComponent", "Lcom/dw/launcher/data/component/NoDisturbComponent;", "getNoDisturbComponent", "()Lcom/dw/launcher/data/component/NoDisturbComponent;", "setNoDisturbComponent", "(Lcom/dw/launcher/data/component/NoDisturbComponent;)V", "notificationComponent", "Lcom/dw/launcher/core/component/NotificationComponent;", "getNotificationComponent", "()Lcom/dw/launcher/core/component/NotificationComponent;", "setNotificationComponent", "(Lcom/dw/launcher/core/component/NotificationComponent;)V", "phoneReceiver", "Lcom/dw/launcher/tts/PhoneReceiver;", "getPhoneReceiver", "()Lcom/dw/launcher/tts/PhoneReceiver;", "setPhoneReceiver", "(Lcom/dw/launcher/tts/PhoneReceiver;)V", "phoneStatusComponent", "Lcom/dw/launcher/data/component/PhoneStatusComponent;", "getPhoneStatusComponent", "()Lcom/dw/launcher/data/component/PhoneStatusComponent;", "setPhoneStatusComponent", "(Lcom/dw/launcher/data/component/PhoneStatusComponent;)V", "usbReceiver", "Lcom/dw/launcher/tts/UsbReceiver;", "getUsbReceiver", "()Lcom/dw/launcher/tts/UsbReceiver;", "setUsbReceiver", "(Lcom/dw/launcher/tts/UsbReceiver;)V", "voiceComponent", "Lcom/dw/launcher/core/component/VoiceComponent;", "getVoiceComponent", "()Lcom/dw/launcher/core/component/VoiceComponent;", "setVoiceComponent", "(Lcom/dw/launcher/core/component/VoiceComponent;)V", "wallpaperComponent", "Lcom/dw/launcher/data/component/WallpaperComponent;", "getWallpaperComponent", "()Lcom/dw/launcher/data/component/WallpaperComponent;", "setWallpaperComponent", "(Lcom/dw/launcher/data/component/WallpaperComponent;)V", "watchLaunchRepository", "Lcom/dw/launcher/data/repository/WatchConfigRepository;", "getWatchLaunchRepository", "()Lcom/dw/launcher/data/repository/WatchConfigRepository;", "setWatchLaunchRepository", "(Lcom/dw/launcher/data/repository/WatchConfigRepository;)V", "wifiComponent", "Lcom/dw/launcher/data/component/WifiComponent;", "getWifiComponent", "()Lcom/dw/launcher/data/component/WifiComponent;", "setWifiComponent", "(Lcom/dw/launcher/data/component/WifiComponent;)V", "attachBaseContext", cn.carbswang.android.numberpickerview.library.BuildConfig.FLAVOR, "base", "Landroid/content/Context;", "getTtsManager", "Lcom/dw/launcher/tts/TtsSpeakManager;", "onCreate", "onTerminate", "registerPowerAndPhoneReceiver", "registerTts", "updateAppLock", "Companion", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@HiltAndroidApp
public final class LauncherApplication extends Hilt_LauncherApplication {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static LauncherApplication sInstance;
    private static TtsSpeakManager ttsManager;

    @Inject
    public LocaleComponent localeComponent;

    @Inject
    public LauncherRepository mAssetsLaunchRepository;

    @Inject
    public BatteryComponent mBatteryComponent;

    @Inject
    public PackageManagerComponent mPackageManagerComponent;

    @Inject
    public NoDisturbComponent noDisturbComponent;

    @Inject
    public NotificationComponent notificationComponent;
    private PhoneReceiver phoneReceiver;

    @Inject
    public PhoneStatusComponent phoneStatusComponent;
    private UsbReceiver usbReceiver;

    @Inject
    public VoiceComponent voiceComponent;

    @Inject
    public WallpaperComponent wallpaperComponent;

    @Inject
    public WatchConfigRepository watchLaunchRepository;

    @Inject
    public WifiComponent wifiComponent;

    private final void updateAppLock() {
    }

    public final BatteryComponent getMBatteryComponent() {
        BatteryComponent batteryComponent = this.mBatteryComponent;
        if (batteryComponent != null) {
            return batteryComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBatteryComponent");
        return null;
    }

    public final void setMBatteryComponent(BatteryComponent batteryComponent) {
        Intrinsics.checkNotNullParameter(batteryComponent, "<set-?>");
        this.mBatteryComponent = batteryComponent;
    }

    public final PackageManagerComponent getMPackageManagerComponent() {
        PackageManagerComponent packageManagerComponent = this.mPackageManagerComponent;
        if (packageManagerComponent != null) {
            return packageManagerComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPackageManagerComponent");
        return null;
    }

    public final void setMPackageManagerComponent(PackageManagerComponent packageManagerComponent) {
        Intrinsics.checkNotNullParameter(packageManagerComponent, "<set-?>");
        this.mPackageManagerComponent = packageManagerComponent;
    }

    public final PhoneStatusComponent getPhoneStatusComponent() {
        PhoneStatusComponent phoneStatusComponent = this.phoneStatusComponent;
        if (phoneStatusComponent != null) {
            return phoneStatusComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("phoneStatusComponent");
        return null;
    }

    public final void setPhoneStatusComponent(PhoneStatusComponent phoneStatusComponent) {
        Intrinsics.checkNotNullParameter(phoneStatusComponent, "<set-?>");
        this.phoneStatusComponent = phoneStatusComponent;
    }

    public final NotificationComponent getNotificationComponent() {
        NotificationComponent notificationComponent = this.notificationComponent;
        if (notificationComponent != null) {
            return notificationComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notificationComponent");
        return null;
    }

    public final void setNotificationComponent(NotificationComponent notificationComponent) {
        Intrinsics.checkNotNullParameter(notificationComponent, "<set-?>");
        this.notificationComponent = notificationComponent;
    }

    public final WallpaperComponent getWallpaperComponent() {
        WallpaperComponent wallpaperComponent = this.wallpaperComponent;
        if (wallpaperComponent != null) {
            return wallpaperComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("wallpaperComponent");
        return null;
    }

    public final void setWallpaperComponent(WallpaperComponent wallpaperComponent) {
        Intrinsics.checkNotNullParameter(wallpaperComponent, "<set-?>");
        this.wallpaperComponent = wallpaperComponent;
    }

    public final WifiComponent getWifiComponent() {
        WifiComponent wifiComponent = this.wifiComponent;
        if (wifiComponent != null) {
            return wifiComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("wifiComponent");
        return null;
    }

    public final void setWifiComponent(WifiComponent wifiComponent) {
        Intrinsics.checkNotNullParameter(wifiComponent, "<set-?>");
        this.wifiComponent = wifiComponent;
    }

    public final LauncherRepository getMAssetsLaunchRepository() {
        LauncherRepository launcherRepository = this.mAssetsLaunchRepository;
        if (launcherRepository != null) {
            return launcherRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsLaunchRepository");
        return null;
    }

    public final void setMAssetsLaunchRepository(LauncherRepository launcherRepository) {
        Intrinsics.checkNotNullParameter(launcherRepository, "<set-?>");
        this.mAssetsLaunchRepository = launcherRepository;
    }

    public final VoiceComponent getVoiceComponent() {
        VoiceComponent voiceComponent = this.voiceComponent;
        if (voiceComponent != null) {
            return voiceComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("voiceComponent");
        return null;
    }

    public final void setVoiceComponent(VoiceComponent voiceComponent) {
        Intrinsics.checkNotNullParameter(voiceComponent, "<set-?>");
        this.voiceComponent = voiceComponent;
    }

    public final LocaleComponent getLocaleComponent() {
        LocaleComponent localeComponent = this.localeComponent;
        if (localeComponent != null) {
            return localeComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localeComponent");
        return null;
    }

    public final void setLocaleComponent(LocaleComponent localeComponent) {
        Intrinsics.checkNotNullParameter(localeComponent, "<set-?>");
        this.localeComponent = localeComponent;
    }

    public final NoDisturbComponent getNoDisturbComponent() {
        NoDisturbComponent noDisturbComponent = this.noDisturbComponent;
        if (noDisturbComponent != null) {
            return noDisturbComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("noDisturbComponent");
        return null;
    }

    public final void setNoDisturbComponent(NoDisturbComponent noDisturbComponent) {
        Intrinsics.checkNotNullParameter(noDisturbComponent, "<set-?>");
        this.noDisturbComponent = noDisturbComponent;
    }

    public final WatchConfigRepository getWatchLaunchRepository() {
        WatchConfigRepository watchConfigRepository = this.watchLaunchRepository;
        if (watchConfigRepository != null) {
            return watchConfigRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("watchLaunchRepository");
        return null;
    }

    public final void setWatchLaunchRepository(WatchConfigRepository watchConfigRepository) {
        Intrinsics.checkNotNullParameter(watchConfigRepository, "<set-?>");
        this.watchLaunchRepository = watchConfigRepository;
    }

    public final UsbReceiver getUsbReceiver() {
        return this.usbReceiver;
    }

    public final void setUsbReceiver(UsbReceiver usbReceiver) {
        this.usbReceiver = usbReceiver;
    }

    public final PhoneReceiver getPhoneReceiver() {
        return this.phoneReceiver;
    }

    public final void setPhoneReceiver(PhoneReceiver phoneReceiver) {
        this.phoneReceiver = phoneReceiver;
    }

    /* JADX INFO: compiled from: LauncherApplication.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/dw/launcher/LauncherApplication$Companion;", cn.carbswang.android.numberpickerview.library.BuildConfig.FLAVOR, "()V", "sInstance", "Lcom/dw/launcher/LauncherApplication;", "ttsManager", "Lcom/dw/launcher/tts/TtsSpeakManager;", "getTtsManager", "()Lcom/dw/launcher/tts/TtsSpeakManager;", "setTtsManager", "(Lcom/dw/launcher/tts/TtsSpeakManager;)V", "getInstance", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TtsSpeakManager getTtsManager() {
            return LauncherApplication.ttsManager;
        }

        public final void setTtsManager(TtsSpeakManager ttsSpeakManager) {
            LauncherApplication.ttsManager = ttsSpeakManager;
        }

        public final LauncherApplication getInstance() {
            LauncherApplication launcherApplication = LauncherApplication.sInstance;
            if (launcherApplication != null) {
                return launcherApplication;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sInstance");
            return null;
        }
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        sInstance = this;
    }

    @Override // com.dw.launcher.Hilt_LauncherApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext());
        Timber.Forest.d("app 初始化...", new Object[0]);
        getMAssetsLaunchRepository().loadConfig();
        getWatchLaunchRepository().loadConfig();
        getMBatteryComponent().register();
        getMPackageManagerComponent().init();
        getMPackageManagerComponent().install();
        getPhoneStatusComponent().register();
        getNotificationComponent().register();
        getWallpaperComponent().init();
        getWifiComponent().register();
        getVoiceComponent().register();
        getLocaleComponent().register();
        getNoDisturbComponent().register();
        MockReceiver.INSTANCE.register(this);
        updateAppLock();
        registerPowerAndPhoneReceiver();
        try {
            startService(new Intent().setComponent(new ComponentName("com.dw.downmenu", "com.dw.downmenu.services.AppNoticeService")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        getMBatteryComponent().unregister();
        getMPackageManagerComponent().uninstall();
        getPhoneStatusComponent().unregister();
        getNotificationComponent().unregister();
        getWifiComponent().unregister();
        getVoiceComponent().unregister();
        getLocaleComponent().unregister();
        getNoDisturbComponent().unregister();
        MockReceiver.INSTANCE.unregister(this);
        UsbReceiver usbReceiver = this.usbReceiver;
        if (usbReceiver != null) {
            unregisterReceiver(usbReceiver);
            this.usbReceiver = null;
        }
        PhoneReceiver phoneReceiver = this.phoneReceiver;
        if (phoneReceiver != null) {
            unregisterReceiver(phoneReceiver);
            this.phoneReceiver = null;
        }
    }

    private final void registerPowerAndPhoneReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        UsbReceiver usbReceiver = new UsbReceiver();
        this.usbReceiver = usbReceiver;
        registerReceiver(usbReceiver, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(PhoneReceiver.PHONE_STATE_ACTION);
        PhoneReceiver phoneReceiver = new PhoneReceiver();
        this.phoneReceiver = phoneReceiver;
        registerReceiver(phoneReceiver, intentFilter2);
    }

    public final TtsSpeakManager getTtsManager() {
        return ttsManager;
    }

    public final void registerTts() {
        ttsManager = TtsSpeakManager.register(this);
    }
}
