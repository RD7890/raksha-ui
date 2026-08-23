package com.dw.launcher.data.repository;

import android.content.Context;
import com.dw.launcher.data.database.dao.ClockConfigDao;
import com.dw.launcher.data.preference.LauncherPreference;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class AssetsClockRepository_Factory implements Factory<AssetsClockRepository> {
    private final Provider<ClockConfigDao> clockConfigDaoProvider;
    private final Provider<Context> contextProvider;
    private final Provider<WatchConfigRepository> launchRepositoryProvider;
    private final Provider<LauncherPreference> preferenceProvider;

    public AssetsClockRepository_Factory(Provider<Context> contextProvider, Provider<LauncherPreference> preferenceProvider, Provider<WatchConfigRepository> launchRepositoryProvider, Provider<ClockConfigDao> clockConfigDaoProvider) {
        this.contextProvider = contextProvider;
        this.preferenceProvider = preferenceProvider;
        this.launchRepositoryProvider = launchRepositoryProvider;
        this.clockConfigDaoProvider = clockConfigDaoProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AssetsClockRepository m216get() {
        return newInstance((Context) this.contextProvider.get(), (LauncherPreference) this.preferenceProvider.get(), (WatchConfigRepository) this.launchRepositoryProvider.get(), (ClockConfigDao) this.clockConfigDaoProvider.get());
    }

    public static AssetsClockRepository_Factory create(Provider<Context> contextProvider, Provider<LauncherPreference> preferenceProvider, Provider<WatchConfigRepository> launchRepositoryProvider, Provider<ClockConfigDao> clockConfigDaoProvider) {
        return new AssetsClockRepository_Factory(contextProvider, preferenceProvider, launchRepositoryProvider, clockConfigDaoProvider);
    }

    public static AssetsClockRepository newInstance(Context context, LauncherPreference preference, WatchConfigRepository launchRepository, ClockConfigDao clockConfigDao) {
        return new AssetsClockRepository(context, preference, launchRepository, clockConfigDao);
    }
}
