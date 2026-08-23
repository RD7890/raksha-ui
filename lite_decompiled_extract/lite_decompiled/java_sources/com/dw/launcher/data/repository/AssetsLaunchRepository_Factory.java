package com.dw.launcher.data.repository;

import android.content.Context;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.preference.SharedPreferencesUtils;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class AssetsLaunchRepository_Factory implements Factory<AssetsLaunchRepository> {
    private final Provider<Context> contextProvider;
    private final Provider<LauncherPreference> preferenceProvider;
    private final Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider;

    public AssetsLaunchRepository_Factory(Provider<Context> contextProvider, Provider<LauncherPreference> preferenceProvider, Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider) {
        this.contextProvider = contextProvider;
        this.preferenceProvider = preferenceProvider;
        this.sharedPreferencesUtilsProvider = sharedPreferencesUtilsProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AssetsLaunchRepository m217get() {
        return newInstance((Context) this.contextProvider.get(), (LauncherPreference) this.preferenceProvider.get(), (SharedPreferencesUtils) this.sharedPreferencesUtilsProvider.get());
    }

    public static AssetsLaunchRepository_Factory create(Provider<Context> contextProvider, Provider<LauncherPreference> preferenceProvider, Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider) {
        return new AssetsLaunchRepository_Factory(contextProvider, preferenceProvider, sharedPreferencesUtilsProvider);
    }

    public static AssetsLaunchRepository newInstance(Context context, LauncherPreference preference, SharedPreferencesUtils sharedPreferencesUtils) {
        return new AssetsLaunchRepository(context, preference, sharedPreferencesUtils);
    }
}
