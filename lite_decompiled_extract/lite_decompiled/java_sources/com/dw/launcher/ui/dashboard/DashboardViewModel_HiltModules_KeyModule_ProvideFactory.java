package com.dw.launcher.ui.dashboard;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class DashboardViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static DashboardViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return DashboardViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        private static final DashboardViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new DashboardViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
