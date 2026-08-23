package com.dw.launcher;

import android.app.Application;
import dagger.hilt.android.internal.managers.ApplicationComponentManager;
import dagger.hilt.android.internal.managers.ComponentSupplier;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public abstract class Hilt_LauncherApplication extends Application implements GeneratedComponentManagerHolder {
    private boolean injected = false;
    private final ApplicationComponentManager componentManager = new ApplicationComponentManager(new ComponentSupplier() { // from class: com.dw.launcher.Hilt_LauncherApplication.1
        public Object get() {
            return DaggerLauncherApplication_HiltComponents_SingletonC.builder().applicationContextModule(new ApplicationContextModule(Hilt_LauncherApplication.this)).build();
        }
    });

    /* JADX INFO: renamed from: componentManager, reason: merged with bridge method [inline-methods] */
    public final ApplicationComponentManager m183componentManager() {
        return this.componentManager;
    }

    public final Object generatedComponent() {
        return m183componentManager().generatedComponent();
    }

    @Override // android.app.Application
    public void onCreate() {
        hiltInternalInject();
        super.onCreate();
    }

    protected void hiltInternalInject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((LauncherApplication_GeneratedInjector) generatedComponent()).injectLauncherApplication((LauncherApplication) UnsafeCasts.unsafeCast(this));
    }
}
