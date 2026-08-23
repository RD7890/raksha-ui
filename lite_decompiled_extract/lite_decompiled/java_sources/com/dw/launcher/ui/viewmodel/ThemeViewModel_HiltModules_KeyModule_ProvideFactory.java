package com.dw.launcher.ui.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class ThemeViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static ThemeViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return ThemeViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        private static final ThemeViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new ThemeViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
