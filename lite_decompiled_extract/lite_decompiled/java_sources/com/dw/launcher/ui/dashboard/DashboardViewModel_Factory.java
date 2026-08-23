package com.dw.launcher.ui.dashboard;

import com.dw.launcher.data.repository.IShortcutRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class DashboardViewModel_Factory implements Factory<DashboardViewModel> {
    private final Provider<IShortcutRepository> repositoryProvider;

    public DashboardViewModel_Factory(Provider<IShortcutRepository> repositoryProvider) {
        this.repositoryProvider = repositoryProvider;
    }

    @Override // javax.inject.Provider
    public DashboardViewModel get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static DashboardViewModel_Factory create(Provider<IShortcutRepository> repositoryProvider) {
        return new DashboardViewModel_Factory(repositoryProvider);
    }

    public static DashboardViewModel newInstance(IShortcutRepository repository) {
        return new DashboardViewModel(repository);
    }
}
