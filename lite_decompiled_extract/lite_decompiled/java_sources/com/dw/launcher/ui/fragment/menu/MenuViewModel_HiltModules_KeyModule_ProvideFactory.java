package com.dw.launcher.ui.fragment.menu;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class MenuViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static MenuViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return MenuViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        private static final MenuViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new MenuViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
