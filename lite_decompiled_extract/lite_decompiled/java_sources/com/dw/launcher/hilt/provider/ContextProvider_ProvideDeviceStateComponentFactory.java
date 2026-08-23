package com.dw.launcher.hilt.provider;

import android.content.Context;
import com.dw.launcher.core.component.DeviceStateComponent;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvideDeviceStateComponentFactory implements Factory<DeviceStateComponent> {
    private final Provider<Context> contextProvider;
    private final ContextProvider module;

    public ContextProvider_ProvideDeviceStateComponentFactory(ContextProvider module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DeviceStateComponent m228get() {
        return provideDeviceStateComponent(this.module, (Context) this.contextProvider.get());
    }

    public static ContextProvider_ProvideDeviceStateComponentFactory create(ContextProvider module, Provider<Context> contextProvider) {
        return new ContextProvider_ProvideDeviceStateComponentFactory(module, contextProvider);
    }

    public static DeviceStateComponent provideDeviceStateComponent(ContextProvider instance, Context context) {
        return (DeviceStateComponent) Preconditions.checkNotNullFromProvides(instance.provideDeviceStateComponent(context));
    }
}
