package com.dw.launcher.data.repository;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class DashboardRepository_Factory implements Factory<DashboardRepository> {
    private final Provider<Context> contextProvider;
    private final Provider<LauncherRepository> launcherRepositoryProvider;

    public DashboardRepository_Factory(Provider<Context> contextProvider, Provider<LauncherRepository> launcherRepositoryProvider) {
        this.contextProvider = contextProvider;
        this.launcherRepositoryProvider = launcherRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DashboardRepository m218get() {
        return newInstance((Context) this.contextProvider.get(), (LauncherRepository) this.launcherRepositoryProvider.get());
    }

    public static DashboardRepository_Factory create(Provider<Context> contextProvider, Provider<LauncherRepository> launcherRepositoryProvider) {
        return new DashboardRepository_Factory(contextProvider, launcherRepositoryProvider);
    }

    public static DashboardRepository newInstance(Context context, LauncherRepository launcherRepository) {
        return new DashboardRepository(context, launcherRepository);
    }
}
