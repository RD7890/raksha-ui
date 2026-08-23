package com.dw.launcher.ui.viewmodel;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class StepViewModel_Factory implements Factory<StepViewModel> {
    private final Provider<Application> contextProvider;

    public StepViewModel_Factory(Provider<Application> contextProvider) {
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider
    public StepViewModel get() {
        return newInstance(this.contextProvider.get());
    }

    public static StepViewModel_Factory create(Provider<Application> contextProvider) {
        return new StepViewModel_Factory(contextProvider);
    }

    public static StepViewModel newInstance(Application context) {
        return new StepViewModel(context);
    }
}
