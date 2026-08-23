package com.dw.launcher.hilt.provider;

import android.content.Context;
import com.dw.launcher.data.component.WallpaperComponent;
import com.dw.launcher.data.preference.LauncherPreference;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvideWallpaperComponentFactory implements Factory<WallpaperComponent> {
    private final Provider<Context> contextProvider;
    private final ContextProvider module;
    private final Provider<LauncherPreference> preferenceProvider;

    public ContextProvider_ProvideWallpaperComponentFactory(ContextProvider module, Provider<Context> contextProvider, Provider<LauncherPreference> preferenceProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
        this.preferenceProvider = preferenceProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public WallpaperComponent m238get() {
        return provideWallpaperComponent(this.module, (Context) this.contextProvider.get(), (LauncherPreference) this.preferenceProvider.get());
    }

    public static ContextProvider_ProvideWallpaperComponentFactory create(ContextProvider module, Provider<Context> contextProvider, Provider<LauncherPreference> preferenceProvider) {
        return new ContextProvider_ProvideWallpaperComponentFactory(module, contextProvider, preferenceProvider);
    }

    public static WallpaperComponent provideWallpaperComponent(ContextProvider instance, Context context, LauncherPreference preference) {
        return (WallpaperComponent) Preconditions.checkNotNullFromProvides(instance.provideWallpaperComponent(context, preference));
    }
}
