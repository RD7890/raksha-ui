package com.dw.launcher.hilt.provider;

import android.content.Context;
import com.dw.launcher.ui.clock.ClockRegister;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvideClockRegisterFactory implements Factory<ClockRegister> {
    private final Provider<Context> contextProvider;
    private final ContextProvider module;

    public ContextProvider_ProvideClockRegisterFactory(ContextProvider module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ClockRegister m226get() {
        return provideClockRegister(this.module, (Context) this.contextProvider.get());
    }

    public static ContextProvider_ProvideClockRegisterFactory create(ContextProvider module, Provider<Context> contextProvider) {
        return new ContextProvider_ProvideClockRegisterFactory(module, contextProvider);
    }

    public static ClockRegister provideClockRegister(ContextProvider instance, Context context) {
        return (ClockRegister) Preconditions.checkNotNullFromProvides(instance.provideClockRegister(context));
    }
}
