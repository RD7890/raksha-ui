package com.dw.launcher.data.repository;

import android.content.Context;
import com.dw.launcher.ui.shortcut.ShortcutInflater;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ShortcutRepository_Factory implements Factory<ShortcutRepository> {
    private final Provider<Context> contextProvider;
    private final Provider<ShortcutInflater> inflaterProvider;
    private final Provider<LauncherRepository> launcherRepositoryProvider;

    public ShortcutRepository_Factory(Provider<Context> contextProvider, Provider<ShortcutInflater> inflaterProvider, Provider<LauncherRepository> launcherRepositoryProvider) {
        this.contextProvider = contextProvider;
        this.inflaterProvider = inflaterProvider;
        this.launcherRepositoryProvider = launcherRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ShortcutRepository m220get() {
        return newInstance((Context) this.contextProvider.get(), (ShortcutInflater) this.inflaterProvider.get(), (LauncherRepository) this.launcherRepositoryProvider.get());
    }

    public static ShortcutRepository_Factory create(Provider<Context> contextProvider, Provider<ShortcutInflater> inflaterProvider, Provider<LauncherRepository> launcherRepositoryProvider) {
        return new ShortcutRepository_Factory(contextProvider, inflaterProvider, launcherRepositoryProvider);
    }

    public static ShortcutRepository newInstance(Context context, ShortcutInflater inflater, LauncherRepository launcherRepository) {
        return new ShortcutRepository(context, inflater, launcherRepository);
    }
}
