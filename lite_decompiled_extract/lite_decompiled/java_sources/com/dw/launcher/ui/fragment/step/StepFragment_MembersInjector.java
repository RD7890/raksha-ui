package com.dw.launcher.ui.fragment.step;

import com.dw.launcher.data.database.dao.StepDataDao;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class StepFragment_MembersInjector implements MembersInjector<StepFragment> {
    private final Provider<StepDataDao> stepDataDaoProvider;

    public StepFragment_MembersInjector(Provider<StepDataDao> stepDataDaoProvider) {
        this.stepDataDaoProvider = stepDataDaoProvider;
    }

    public static MembersInjector<StepFragment> create(Provider<StepDataDao> stepDataDaoProvider) {
        return new StepFragment_MembersInjector(stepDataDaoProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(StepFragment instance) {
        injectStepDataDao(instance, this.stepDataDaoProvider.get());
    }

    public static void injectStepDataDao(StepFragment instance, StepDataDao stepDataDao) {
        instance.stepDataDao = stepDataDao;
    }
}
