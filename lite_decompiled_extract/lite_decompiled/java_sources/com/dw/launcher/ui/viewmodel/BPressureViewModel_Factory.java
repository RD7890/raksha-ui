package com.dw.launcher.ui.viewmodel;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class BPressureViewModel_Factory implements Factory<BPressureViewModel> {
    private final Provider<Application> contextProvider;

    public BPressureViewModel_Factory(Provider<Application> contextProvider) {
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider
    public BPressureViewModel get() {
        return newInstance(this.contextProvider.get());
    }

    public static BPressureViewModel_Factory create(Provider<Application> contextProvider) {
        return new BPressureViewModel_Factory(contextProvider);
    }

    public static BPressureViewModel newInstance(Application context) {
        return new BPressureViewModel(context);
    }
}
