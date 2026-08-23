package com.dw.launcher.ui.viewmodel;

import com.dw.launcher.data.component.WallpaperComponent;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class WallpaperViewModel_Factory implements Factory<WallpaperViewModel> {
    private final Provider<WallpaperComponent> wallpaperComponentProvider;

    public WallpaperViewModel_Factory(Provider<WallpaperComponent> wallpaperComponentProvider) {
        this.wallpaperComponentProvider = wallpaperComponentProvider;
    }

    @Override // javax.inject.Provider
    public WallpaperViewModel get() {
        WallpaperViewModel wallpaperViewModelNewInstance = newInstance();
        WallpaperViewModel_MembersInjector.injectWallpaperComponent(wallpaperViewModelNewInstance, this.wallpaperComponentProvider.get());
        return wallpaperViewModelNewInstance;
    }

    public static WallpaperViewModel_Factory create(Provider<WallpaperComponent> wallpaperComponentProvider) {
        return new WallpaperViewModel_Factory(wallpaperComponentProvider);
    }

    public static WallpaperViewModel newInstance() {
        return new WallpaperViewModel();
    }
}
