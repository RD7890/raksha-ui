package com.dw.launcher.hilt.provider;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.preference.LauncherPreferenceImpl;
import com.dw.launcher.data.repository.AssetsClockRepository;
import com.dw.launcher.data.repository.AssetsLaunchRepository;
import com.dw.launcher.data.repository.ClockRepository;
import com.dw.launcher.data.repository.DashboardRepository;
import com.dw.launcher.data.repository.IDashboardRepository;
import com.dw.launcher.data.repository.IRecentTaskRepository;
import com.dw.launcher.data.repository.IShortcutRepository;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.data.repository.RecentTaskRepository;
import com.dw.launcher.data.repository.ShortcutRepository;
import com.dw.launcher.data.repository.WatchConfigRepository;
import com.dw.launcher.data.repository.WatchLaunchRepositoryImpl;
import dagger.Binds;
import dagger.Module;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: compiled from: RepositoryModule.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H'J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H'J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH'J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u001dH'¨\u0006\u001e"}, d2 = {"Lcom/dw/launcher/hilt/provider/RepositoryModule;", BuildConfig.FLAVOR, "()V", "bindClockRepository", "Lcom/dw/launcher/data/repository/ClockRepository;", "clockRepository", "Lcom/dw/launcher/data/repository/AssetsClockRepository;", "bindDashboardRepository", "Lcom/dw/launcher/data/repository/IDashboardRepository;", "dashboardRepository", "Lcom/dw/launcher/data/repository/DashboardRepository;", "bindLauncherPreference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "preferenceImpl", "Lcom/dw/launcher/data/preference/LauncherPreferenceImpl;", "bindLauncherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "launchRepository", "Lcom/dw/launcher/data/repository/AssetsLaunchRepository;", "bindRecentTaskRepository", "Lcom/dw/launcher/data/repository/IRecentTaskRepository;", "recentTaskRepository", "Lcom/dw/launcher/data/repository/RecentTaskRepository;", "bindShortcutRepository", "Lcom/dw/launcher/data/repository/IShortcutRepository;", "shortcutRepository", "Lcom/dw/launcher/data/repository/ShortcutRepository;", "bindWatchRepository", "Lcom/dw/launcher/data/repository/WatchConfigRepository;", "Lcom/dw/launcher/data/repository/WatchLaunchRepositoryImpl;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Module
public abstract class RepositoryModule {
    @Singleton
    @Binds
    public abstract ClockRepository bindClockRepository(AssetsClockRepository clockRepository);

    @Singleton
    @Binds
    public abstract IDashboardRepository bindDashboardRepository(DashboardRepository dashboardRepository);

    @Singleton
    @Binds
    public abstract LauncherPreference bindLauncherPreference(LauncherPreferenceImpl preferenceImpl);

    @Singleton
    @Binds
    public abstract LauncherRepository bindLauncherRepository(AssetsLaunchRepository launchRepository);

    @Singleton
    @Binds
    public abstract IRecentTaskRepository bindRecentTaskRepository(RecentTaskRepository recentTaskRepository);

    @Singleton
    @Binds
    public abstract IShortcutRepository bindShortcutRepository(ShortcutRepository shortcutRepository);

    @Singleton
    @Binds
    public abstract WatchConfigRepository bindWatchRepository(WatchLaunchRepositoryImpl launchRepository);
}
