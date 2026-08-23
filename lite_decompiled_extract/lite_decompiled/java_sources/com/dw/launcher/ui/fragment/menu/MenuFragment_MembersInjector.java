package com.dw.launcher.ui.fragment.menu;

import com.dw.launcher.data.repository.LauncherRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class MenuFragment_MembersInjector implements MembersInjector<MenuFragment> {
    private final Provider<LauncherRepository> launcherRepositoryProvider;

    public MenuFragment_MembersInjector(Provider<LauncherRepository> launcherRepositoryProvider) {
        this.launcherRepositoryProvider = launcherRepositoryProvider;
    }

    public static MembersInjector<MenuFragment> create(Provider<LauncherRepository> launcherRepositoryProvider) {
        return new MenuFragment_MembersInjector(launcherRepositoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MenuFragment instance) {
        injectLauncherRepository(instance, this.launcherRepositoryProvider.get());
    }

    public static void injectLauncherRepository(MenuFragment instance, LauncherRepository launcherRepository) {
        instance.launcherRepository = launcherRepository;
    }
}
