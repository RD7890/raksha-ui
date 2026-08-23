package com.dw.launcher.core.service;

import android.service.wallpaper.WallpaperService;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public abstract class Hilt_LauncherWallpaperService extends WallpaperService implements GeneratedComponentManagerHolder {
    private volatile ServiceComponentManager componentManager;
    private final Object componentManagerLock = new Object();
    private boolean injected = false;

    Hilt_LauncherWallpaperService() {
    }

    @Override // android.service.wallpaper.WallpaperService, android.app.Service
    public void onCreate() {
        inject();
        super.onCreate();
    }

    protected ServiceComponentManager createComponentManager() {
        return new ServiceComponentManager(this);
    }

    /* JADX INFO: renamed from: componentManager, reason: merged with bridge method [inline-methods] */
    public final ServiceComponentManager m199componentManager() {
        if (this.componentManager == null) {
            synchronized (this.componentManagerLock) {
                if (this.componentManager == null) {
                    this.componentManager = createComponentManager();
                }
            }
        }
        return this.componentManager;
    }

    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((LauncherWallpaperService_GeneratedInjector) generatedComponent()).injectLauncherWallpaperService((LauncherWallpaperService) UnsafeCasts.unsafeCast(this));
    }

    public final Object generatedComponent() {
        return m199componentManager().generatedComponent();
    }
}
