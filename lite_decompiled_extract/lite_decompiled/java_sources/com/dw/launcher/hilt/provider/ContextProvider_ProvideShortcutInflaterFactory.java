package com.dw.launcher.hilt.provider;

import android.content.Context;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.ui.shortcut.ShortcutInflater;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvideShortcutInflaterFactory implements Factory<ShortcutInflater> {
    private final Provider<Context> contextProvider;
    private final Provider<LauncherRepository> launcherRepositoryProvider;
    private final ContextProvider module;

    public ContextProvider_ProvideShortcutInflaterFactory(ContextProvider module, Provider<Context> contextProvider, Provider<LauncherRepository> launcherRepositoryProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
        this.launcherRepositoryProvider = launcherRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ShortcutInflater m235get() {
        return provideShortcutInflater(this.module, (Context) this.contextProvider.get(), (LauncherRepository) this.launcherRepositoryProvider.get());
    }

    public static ContextProvider_ProvideShortcutInflaterFactory create(ContextProvider module, Provider<Context> contextProvider, Provider<LauncherRepository> launcherRepositoryProvider) {
        return new ContextProvider_ProvideShortcutInflaterFactory(module, contextProvider, launcherRepositoryProvider);
    }

    public static ShortcutInflater provideShortcutInflater(ContextProvider instance, Context context, LauncherRepository launcherRepository) {
        return (ShortcutInflater) Preconditions.checkNotNullFromProvides(instance.provideShortcutInflater(context, launcherRepository));
    }
}
