package com.dw.launcher.ui.viewmodel;

import com.dw.launcher.data.repository.IShortcutRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class ThemeViewModel_MembersInjector implements MembersInjector<ThemeViewModel> {
    private final Provider<IShortcutRepository> shortcutRepositoryProvider;

    public ThemeViewModel_MembersInjector(Provider<IShortcutRepository> shortcutRepositoryProvider) {
        this.shortcutRepositoryProvider = shortcutRepositoryProvider;
    }

    public static MembersInjector<ThemeViewModel> create(Provider<IShortcutRepository> shortcutRepositoryProvider) {
        return new ThemeViewModel_MembersInjector(shortcutRepositoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ThemeViewModel instance) {
        injectShortcutRepository(instance, this.shortcutRepositoryProvider.get());
    }

    public static void injectShortcutRepository(ThemeViewModel instance, IShortcutRepository shortcutRepository) {
        instance.shortcutRepository = shortcutRepository;
    }
}
