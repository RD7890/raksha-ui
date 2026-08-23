package com.dw.launcher.core.service;

import com.dw.launcher.data.database.dao.StepDataDao;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class StepBySoProviderService_MembersInjector implements MembersInjector<StepBySoProviderService> {
    private final Provider<StepDataDao> stepDataDaoProvider;

    public StepBySoProviderService_MembersInjector(Provider<StepDataDao> stepDataDaoProvider) {
        this.stepDataDaoProvider = stepDataDaoProvider;
    }

    public static MembersInjector<StepBySoProviderService> create(Provider<StepDataDao> stepDataDaoProvider) {
        return new StepBySoProviderService_MembersInjector(stepDataDaoProvider);
    }

    public void injectMembers(StepBySoProviderService instance) {
        injectStepDataDao(instance, (StepDataDao) this.stepDataDaoProvider.get());
    }

    public static void injectStepDataDao(StepBySoProviderService instance, StepDataDao stepDataDao) {
        instance.stepDataDao = stepDataDao;
    }
}
