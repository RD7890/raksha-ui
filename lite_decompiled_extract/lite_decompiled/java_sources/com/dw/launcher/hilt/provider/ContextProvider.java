package com.dw.launcher.hilt.provider;

import android.content.Context;
import android.os.SystemProperties;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.LauncherApplication;
import com.dw.launcher.core.component.DeviceStateComponent;
import com.dw.launcher.core.component.NotificationComponent;
import com.dw.launcher.core.component.VoiceComponent;
import com.dw.launcher.data.component.BatteryComponent;
import com.dw.launcher.data.component.LocaleComponent;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.component.PhoneStatusComponent;
import com.dw.launcher.data.component.WallpaperComponent;
import com.dw.launcher.data.database.LauncherDB;
import com.dw.launcher.data.database.dao.ClockConfigDao;
import com.dw.launcher.data.database.dao.StepDataDao;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.preference.SharedPreferencesUtils;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.ui.clock.ClockRegister;
import com.dw.launcher.ui.shortcut.ShortcutInflater;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0011\u001a\u00020\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*H\u0007¨\u0006+"}, d2 = {"Lcom/dw/launcher/hilt/provider/ContextProvider;", BuildConfig.FLAVOR, "()V", "getSystemKey", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "context", "Landroid/content/Context;", "provideApp", "Lcom/dw/launcher/LauncherApplication;", "provideBatteryComponent", "Lcom/dw/launcher/data/component/BatteryComponent;", "provideClockConfigDao", "Lcom/dw/launcher/data/database/dao/ClockConfigDao;", "launcherDB", "Lcom/dw/launcher/data/database/LauncherDB;", "provideClockRegister", "Lcom/dw/launcher/ui/clock/ClockRegister;", "provideContext", "provideDeviceStateComponent", "Lcom/dw/launcher/core/component/DeviceStateComponent;", "provideLauncherDB", "provideLocaleComponent", "Lcom/dw/launcher/data/component/LocaleComponent;", "provideNoDisturbComponent", "Lcom/dw/launcher/data/component/NoDisturbComponent;", "provideNotificationComponent", "Lcom/dw/launcher/core/component/NotificationComponent;", "providePhoneStatusComponent", "Lcom/dw/launcher/data/component/PhoneStatusComponent;", "provideSharedPreferencesUtils", "Lcom/dw/launcher/data/preference/SharedPreferencesUtils;", "provideShortcutInflater", "Lcom/dw/launcher/ui/shortcut/ShortcutInflater;", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "provideStepDao", "Lcom/dw/launcher/data/database/dao/StepDataDao;", "provideVoiceComponent", "Lcom/dw/launcher/core/component/VoiceComponent;", "provideWallpaperComponent", "Lcom/dw/launcher/data/component/WallpaperComponent;", "preference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Module
public final class ContextProvider {
    @Provides
    @Singleton
    public final LauncherApplication provideApp() {
        return LauncherApplication.INSTANCE.getInstance();
    }

    @Provides
    @Singleton
    public final Context provideContext() {
        return LauncherApplication.INSTANCE.getInstance();
    }

    @Provides
    @Singleton
    public final ClockRegister provideClockRegister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ClockRegister(context);
    }

    @Provides
    @Singleton
    public final BatteryComponent provideBatteryComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new BatteryComponent(context);
    }

    @Provides
    @Singleton
    public final PhoneStatusComponent providePhoneStatusComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PhoneStatusComponent(context);
    }

    @Provides
    @Singleton
    public final NotificationComponent provideNotificationComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new NotificationComponent(context);
    }

    @Provides
    @Singleton
    public final LauncherDB provideLauncherDB(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RoomDatabase roomDatabaseBuild = Room.databaseBuilder(context, LauncherDB.class, "launcher.db").fallbackToDestructiveMigration().build();
        Intrinsics.checkNotNullExpressionValue(roomDatabaseBuild, "build(...)");
        return (LauncherDB) roomDatabaseBuild;
    }

    @Provides
    @Singleton
    public final ClockConfigDao provideClockConfigDao(LauncherDB launcherDB) {
        Intrinsics.checkNotNullParameter(launcherDB, "launcherDB");
        return launcherDB.clockConfigDao();
    }

    @Provides
    @Singleton
    public final StepDataDao provideStepDao(LauncherDB launcherDB) {
        Intrinsics.checkNotNullParameter(launcherDB, "launcherDB");
        return launcherDB.stepDataDao();
    }

    @Provides
    @Singleton
    public final DeviceStateComponent provideDeviceStateComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DeviceStateComponent(context);
    }

    @Provides
    @Singleton
    public final SysKeyEvent getSystemKey(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = SystemProperties.get("persist.sys.dw.key");
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        return new SysKeyEvent(str, 0, 0, 0, 14, null);
    }

    @Provides
    @Singleton
    public final VoiceComponent provideVoiceComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new VoiceComponent(context);
    }

    @Provides
    @Singleton
    public final WallpaperComponent provideWallpaperComponent(Context context, LauncherPreference preference) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preference, "preference");
        return new WallpaperComponent(context, preference);
    }

    @Provides
    @Singleton
    public final LocaleComponent provideLocaleComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new LocaleComponent(context);
    }

    @Provides
    @Singleton
    public final NoDisturbComponent provideNoDisturbComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new NoDisturbComponent(context);
    }

    @Provides
    @Singleton
    public final SharedPreferencesUtils provideSharedPreferencesUtils(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SharedPreferencesUtils(context);
    }

    @Provides
    @Singleton
    public final ShortcutInflater provideShortcutInflater(Context context, LauncherRepository launcherRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(launcherRepository, "launcherRepository");
        return new ShortcutInflater(context, launcherRepository);
    }
}
