package com.dw.launcher.hilt.provider;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvideContextFactory implements Factory<Context> {
    private final ContextProvider module;

    public ContextProvider_ProvideContextFactory(ContextProvider module) {
        this.module = module;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Context m227get() {
        return provideContext(this.module);
    }

    public static ContextProvider_ProvideContextFactory create(ContextProvider module) {
        return new ContextProvider_ProvideContextFactory(module);
    }

    public static Context provideContext(ContextProvider instance) {
        return (Context) Preconditions.checkNotNullFromProvides(instance.provideContext());
    }
}
