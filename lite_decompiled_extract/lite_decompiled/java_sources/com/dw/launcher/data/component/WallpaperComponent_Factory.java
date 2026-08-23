package com.dw.launcher.data.component;

import android.content.Context;
import com.dw.launcher.data.preference.LauncherPreference;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class WallpaperComponent_Factory implements Factory<WallpaperComponent> {
    private final Provider<Context> contextProvider;
    private final Provider<LauncherPreference> preferenceProvider;

    public WallpaperComponent_Factory(Provider<Context> contextProvider, Provider<LauncherPreference> preferenceProvider) {
        this.contextProvider = contextProvider;
        this.preferenceProvider = preferenceProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public WallpaperComponent m211get() {
        return newInstance((Context) this.contextProvider.get(), (LauncherPreference) this.preferenceProvider.get());
    }

    public static WallpaperComponent_Factory create(Provider<Context> contextProvider, Provider<LauncherPreference> preferenceProvider) {
        return new WallpaperComponent_Factory(contextProvider, preferenceProvider);
    }

    public static WallpaperComponent newInstance(Context context, LauncherPreference preference) {
        return new WallpaperComponent(context, preference);
    }
}
