package com.dw.launcher.ui.viewmodel;

import com.dw.launcher.data.repository.IShortcutRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class ThemeViewModel_Factory implements Factory<ThemeViewModel> {
    private final Provider<IShortcutRepository> shortcutRepositoryProvider;

    public ThemeViewModel_Factory(Provider<IShortcutRepository> shortcutRepositoryProvider) {
        this.shortcutRepositoryProvider = shortcutRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public ThemeViewModel get() {
        ThemeViewModel themeViewModelNewInstance = newInstance();
        ThemeViewModel_MembersInjector.injectShortcutRepository(themeViewModelNewInstance, this.shortcutRepositoryProvider.get());
        return themeViewModelNewInstance;
    }

    public static ThemeViewModel_Factory create(Provider<IShortcutRepository> shortcutRepositoryProvider) {
        return new ThemeViewModel_Factory(shortcutRepositoryProvider);
    }

    public static ThemeViewModel newInstance() {
        return new ThemeViewModel();
    }
}
