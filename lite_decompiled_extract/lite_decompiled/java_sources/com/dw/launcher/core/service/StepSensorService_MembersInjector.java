package com.dw.launcher.core.service;

import com.dw.launcher.data.database.dao.StepDataDao;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class StepSensorService_MembersInjector implements MembersInjector<StepSensorService> {
    private final Provider<StepDataDao> stepDataDaoProvider;

    public StepSensorService_MembersInjector(Provider<StepDataDao> stepDataDaoProvider) {
        this.stepDataDaoProvider = stepDataDaoProvider;
    }

    public static MembersInjector<StepSensorService> create(Provider<StepDataDao> stepDataDaoProvider) {
        return new StepSensorService_MembersInjector(stepDataDaoProvider);
    }

    public void injectMembers(StepSensorService instance) {
        injectStepDataDao(instance, (StepDataDao) this.stepDataDaoProvider.get());
    }

    public static void injectStepDataDao(StepSensorService instance, StepDataDao stepDataDao) {
        instance.stepDataDao = stepDataDao;
    }
}
