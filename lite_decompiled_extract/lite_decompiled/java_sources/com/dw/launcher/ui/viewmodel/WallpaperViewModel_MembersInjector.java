package com.dw.launcher.ui.viewmodel;

import com.dw.launcher.data.component.WallpaperComponent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class WallpaperViewModel_MembersInjector implements MembersInjector<WallpaperViewModel> {
    private final Provider<WallpaperComponent> wallpaperComponentProvider;

    public WallpaperViewModel_MembersInjector(Provider<WallpaperComponent> wallpaperComponentProvider) {
        this.wallpaperComponentProvider = wallpaperComponentProvider;
    }

    public static MembersInjector<WallpaperViewModel> create(Provider<WallpaperComponent> wallpaperComponentProvider) {
        return new WallpaperViewModel_MembersInjector(wallpaperComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(WallpaperViewModel instance) {
        injectWallpaperComponent(instance, this.wallpaperComponentProvider.get());
    }

    public static void injectWallpaperComponent(WallpaperViewModel instance, WallpaperComponent wallpaperComponent) {
        instance.wallpaperComponent = wallpaperComponent;
    }
}
