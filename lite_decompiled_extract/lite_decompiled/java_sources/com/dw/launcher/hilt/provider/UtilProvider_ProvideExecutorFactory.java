package com.dw.launcher.hilt.provider;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class UtilProvider_ProvideExecutorFactory implements Factory<Executor> {
    private final UtilProvider module;

    public UtilProvider_ProvideExecutorFactory(UtilProvider module) {
        this.module = module;
    }

    public Executor get() {
        return provideExecutor(this.module);
    }

    public static UtilProvider_ProvideExecutorFactory create(UtilProvider module) {
        return new UtilProvider_ProvideExecutorFactory(module);
    }

    public static Executor provideExecutor(UtilProvider instance) {
        return (Executor) Preconditions.checkNotNullFromProvides(instance.provideExecutor());
    }
}
