package com.dw.launcher.core.service;

import com.dw.launcher.data.preference.LauncherPreference;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class LauncherWallpaperService_MembersInjector implements MembersInjector<LauncherWallpaperService> {
    private final Provider<LauncherPreference> preferenceProvider;

    public LauncherWallpaperService_MembersInjector(Provider<LauncherPreference> preferenceProvider) {
        this.preferenceProvider = preferenceProvider;
    }

    public static MembersInjector<LauncherWallpaperService> create(Provider<LauncherPreference> preferenceProvider) {
        return new LauncherWallpaperService_MembersInjector(preferenceProvider);
    }

    public void injectMembers(LauncherWallpaperService instance) {
        injectPreference(instance, (LauncherPreference) this.preferenceProvider.get());
    }

    public static void injectPreference(LauncherWallpaperService instance, LauncherPreference preference) {
        instance.preference = preference;
    }
}
