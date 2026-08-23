package com.dw.launcher.data.repository;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class WatchLaunchRepositoryImpl_Factory implements Factory<WatchLaunchRepositoryImpl> {
    private final Provider<Context> contextProvider;

    public WatchLaunchRepositoryImpl_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public WatchLaunchRepositoryImpl m221get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static WatchLaunchRepositoryImpl_Factory create(Provider<Context> contextProvider) {
        return new WatchLaunchRepositoryImpl_Factory(contextProvider);
    }

    public static WatchLaunchRepositoryImpl newInstance(Context context) {
        return new WatchLaunchRepositoryImpl(context);
    }
}
