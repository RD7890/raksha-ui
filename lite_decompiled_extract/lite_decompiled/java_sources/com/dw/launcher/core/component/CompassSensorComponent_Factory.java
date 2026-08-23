package com.dw.launcher.core.component;

import android.content.Context;
import com.dw.launcher.data.repository.LauncherRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class CompassSensorComponent_Factory implements Factory<CompassSensorComponent> {
    private final Provider<Context> contextProvider;
    private final Provider<LauncherRepository> launcherRepositoryProvider;

    public CompassSensorComponent_Factory(Provider<Context> contextProvider, Provider<LauncherRepository> launcherRepositoryProvider) {
        this.contextProvider = contextProvider;
        this.launcherRepositoryProvider = launcherRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public CompassSensorComponent m189get() {
        return newInstance((Context) this.contextProvider.get(), (LauncherRepository) this.launcherRepositoryProvider.get());
    }

    public static CompassSensorComponent_Factory create(Provider<Context> contextProvider, Provider<LauncherRepository> launcherRepositoryProvider) {
        return new CompassSensorComponent_Factory(contextProvider, launcherRepositoryProvider);
    }

    public static CompassSensorComponent newInstance(Context context, LauncherRepository launcherRepository) {
        return new CompassSensorComponent(context, launcherRepository);
    }
}
