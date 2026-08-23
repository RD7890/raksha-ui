package com.dw.launcher.ui.activity;

import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.component.WallpaperComponent;
import com.dw.launcher.data.entity.SysKeyEvent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class SetWallpaperActivity_MembersInjector implements MembersInjector<SetWallpaperActivity> {
    private final Provider<NoDisturbComponent> noDisturbComponentProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;
    private final Provider<WallpaperComponent> wallpaperComponentProvider;

    public SetWallpaperActivity_MembersInjector(Provider<SysKeyEvent> sysKeyEventProvider, Provider<WallpaperComponent> wallpaperComponentProvider, Provider<NoDisturbComponent> noDisturbComponentProvider) {
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.wallpaperComponentProvider = wallpaperComponentProvider;
        this.noDisturbComponentProvider = noDisturbComponentProvider;
    }

    public static MembersInjector<SetWallpaperActivity> create(Provider<SysKeyEvent> sysKeyEventProvider, Provider<WallpaperComponent> wallpaperComponentProvider, Provider<NoDisturbComponent> noDisturbComponentProvider) {
        return new SetWallpaperActivity_MembersInjector(sysKeyEventProvider, wallpaperComponentProvider, noDisturbComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SetWallpaperActivity instance) {
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
        injectWallpaperComponent(instance, this.wallpaperComponentProvider.get());
        injectNoDisturbComponent(instance, this.noDisturbComponentProvider.get());
    }

    public static void injectSysKeyEvent(SetWallpaperActivity instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectWallpaperComponent(SetWallpaperActivity instance, WallpaperComponent wallpaperComponent) {
        instance.wallpaperComponent = wallpaperComponent;
    }

    public static void injectNoDisturbComponent(SetWallpaperActivity instance, NoDisturbComponent noDisturbComponent) {
        instance.noDisturbComponent = noDisturbComponent;
    }
}
