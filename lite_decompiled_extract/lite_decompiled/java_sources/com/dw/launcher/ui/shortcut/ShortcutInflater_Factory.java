package com.dw.launcher.ui.shortcut;

import android.content.Context;
import com.dw.launcher.data.repository.LauncherRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class ShortcutInflater_Factory implements Factory<ShortcutInflater> {
    private final Provider<Context> contextProvider;
    private final Provider<LauncherRepository> launcherRepositoryProvider;

    public ShortcutInflater_Factory(Provider<Context> contextProvider, Provider<LauncherRepository> launcherRepositoryProvider) {
        this.contextProvider = contextProvider;
        this.launcherRepositoryProvider = launcherRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public ShortcutInflater get() {
        return newInstance(this.contextProvider.get(), this.launcherRepositoryProvider.get());
    }

    public static ShortcutInflater_Factory create(Provider<Context> contextProvider, Provider<LauncherRepository> launcherRepositoryProvider) {
        return new ShortcutInflater_Factory(contextProvider, launcherRepositoryProvider);
    }

    public static ShortcutInflater newInstance(Context context, LauncherRepository launcherRepository) {
        return new ShortcutInflater(context, launcherRepository);
    }
}
