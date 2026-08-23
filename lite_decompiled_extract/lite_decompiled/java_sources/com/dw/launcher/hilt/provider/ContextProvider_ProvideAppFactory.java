package com.dw.launcher.hilt.provider;

import com.dw.launcher.LauncherApplication;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvideAppFactory implements Factory<LauncherApplication> {
    private final ContextProvider module;

    public ContextProvider_ProvideAppFactory(ContextProvider module) {
        this.module = module;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public LauncherApplication m223get() {
        return provideApp(this.module);
    }

    public static ContextProvider_ProvideAppFactory create(ContextProvider module) {
        return new ContextProvider_ProvideAppFactory(module);
    }

    public static LauncherApplication provideApp(ContextProvider instance) {
        return (LauncherApplication) Preconditions.checkNotNullFromProvides(instance.provideApp());
    }
}
