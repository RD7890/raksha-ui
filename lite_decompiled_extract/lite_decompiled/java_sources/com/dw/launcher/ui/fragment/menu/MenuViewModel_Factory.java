package com.dw.launcher.ui.fragment.menu;

import com.dw.launcher.data.preference.SharedPreferencesUtils;
import com.dw.launcher.data.repository.IRecentTaskRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class MenuViewModel_Factory implements Factory<MenuViewModel> {
    private final Provider<IRecentTaskRepository> recentTaskRepositoryProvider;
    private final Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider;

    public MenuViewModel_Factory(Provider<IRecentTaskRepository> recentTaskRepositoryProvider, Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider) {
        this.recentTaskRepositoryProvider = recentTaskRepositoryProvider;
        this.sharedPreferencesUtilsProvider = sharedPreferencesUtilsProvider;
    }

    @Override // javax.inject.Provider
    public MenuViewModel get() {
        return newInstance(this.recentTaskRepositoryProvider.get(), this.sharedPreferencesUtilsProvider.get());
    }

    public static MenuViewModel_Factory create(Provider<IRecentTaskRepository> recentTaskRepositoryProvider, Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider) {
        return new MenuViewModel_Factory(recentTaskRepositoryProvider, sharedPreferencesUtilsProvider);
    }

    public static MenuViewModel newInstance(IRecentTaskRepository recentTaskRepository, SharedPreferencesUtils sharedPreferencesUtils) {
        return new MenuViewModel(recentTaskRepository, sharedPreferencesUtils);
    }
}
