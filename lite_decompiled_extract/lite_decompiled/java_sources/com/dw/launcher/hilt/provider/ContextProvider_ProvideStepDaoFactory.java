package com.dw.launcher.hilt.provider;

import com.dw.launcher.data.database.LauncherDB;
import com.dw.launcher.data.database.dao.StepDataDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvideStepDaoFactory implements Factory<StepDataDao> {
    private final Provider<LauncherDB> launcherDBProvider;
    private final ContextProvider module;

    public ContextProvider_ProvideStepDaoFactory(ContextProvider module, Provider<LauncherDB> launcherDBProvider) {
        this.module = module;
        this.launcherDBProvider = launcherDBProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public StepDataDao m236get() {
        return provideStepDao(this.module, (LauncherDB) this.launcherDBProvider.get());
    }

    public static ContextProvider_ProvideStepDaoFactory create(ContextProvider module, Provider<LauncherDB> launcherDBProvider) {
        return new ContextProvider_ProvideStepDaoFactory(module, launcherDBProvider);
    }

    public static StepDataDao provideStepDao(ContextProvider instance, LauncherDB launcherDB) {
        return (StepDataDao) Preconditions.checkNotNullFromProvides(instance.provideStepDao(launcherDB));
    }
}
