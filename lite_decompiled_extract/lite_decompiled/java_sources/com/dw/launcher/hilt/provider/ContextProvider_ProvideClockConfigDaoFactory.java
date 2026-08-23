package com.dw.launcher.hilt.provider;

import com.dw.launcher.data.database.LauncherDB;
import com.dw.launcher.data.database.dao.ClockConfigDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvideClockConfigDaoFactory implements Factory<ClockConfigDao> {
    private final Provider<LauncherDB> launcherDBProvider;
    private final ContextProvider module;

    public ContextProvider_ProvideClockConfigDaoFactory(ContextProvider module, Provider<LauncherDB> launcherDBProvider) {
        this.module = module;
        this.launcherDBProvider = launcherDBProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ClockConfigDao m225get() {
        return provideClockConfigDao(this.module, (LauncherDB) this.launcherDBProvider.get());
    }

    public static ContextProvider_ProvideClockConfigDaoFactory create(ContextProvider module, Provider<LauncherDB> launcherDBProvider) {
        return new ContextProvider_ProvideClockConfigDaoFactory(module, launcherDBProvider);
    }

    public static ClockConfigDao provideClockConfigDao(ContextProvider instance, LauncherDB launcherDB) {
        return (ClockConfigDao) Preconditions.checkNotNullFromProvides(instance.provideClockConfigDao(launcherDB));
    }
}
