package com.dw.launcher.hilt.provider;

import android.content.Context;
import com.dw.launcher.data.component.BatteryComponent;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvideBatteryComponentFactory implements Factory<BatteryComponent> {
    private final Provider<Context> contextProvider;
    private final ContextProvider module;

    public ContextProvider_ProvideBatteryComponentFactory(ContextProvider module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public BatteryComponent m224get() {
        return provideBatteryComponent(this.module, (Context) this.contextProvider.get());
    }

    public static ContextProvider_ProvideBatteryComponentFactory create(ContextProvider module, Provider<Context> contextProvider) {
        return new ContextProvider_ProvideBatteryComponentFactory(module, contextProvider);
    }

    public static BatteryComponent provideBatteryComponent(ContextProvider instance, Context context) {
        return (BatteryComponent) Preconditions.checkNotNullFromProvides(instance.provideBatteryComponent(context));
    }
}
