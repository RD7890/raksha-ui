package com.dw.launcher.hilt.provider;

import android.content.Context;
import com.dw.launcher.data.database.LauncherDB;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvideLauncherDBFactory implements Factory<LauncherDB> {
    private final Provider<Context> contextProvider;
    private final ContextProvider module;

    public ContextProvider_ProvideLauncherDBFactory(ContextProvider module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public LauncherDB m229get() {
        return provideLauncherDB(this.module, (Context) this.contextProvider.get());
    }

    public static ContextProvider_ProvideLauncherDBFactory create(ContextProvider module, Provider<Context> contextProvider) {
        return new ContextProvider_ProvideLauncherDBFactory(module, contextProvider);
    }

    public static LauncherDB provideLauncherDB(ContextProvider instance, Context context) {
        return (LauncherDB) Preconditions.checkNotNullFromProvides(instance.provideLauncherDB(context));
    }
}
