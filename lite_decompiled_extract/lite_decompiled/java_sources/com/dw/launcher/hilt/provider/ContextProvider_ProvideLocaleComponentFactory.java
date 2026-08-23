package com.dw.launcher.hilt.provider;

import android.content.Context;
import com.dw.launcher.data.component.LocaleComponent;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvideLocaleComponentFactory implements Factory<LocaleComponent> {
    private final Provider<Context> contextProvider;
    private final ContextProvider module;

    public ContextProvider_ProvideLocaleComponentFactory(ContextProvider module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public LocaleComponent m230get() {
        return provideLocaleComponent(this.module, (Context) this.contextProvider.get());
    }

    public static ContextProvider_ProvideLocaleComponentFactory create(ContextProvider module, Provider<Context> contextProvider) {
        return new ContextProvider_ProvideLocaleComponentFactory(module, contextProvider);
    }

    public static LocaleComponent provideLocaleComponent(ContextProvider instance, Context context) {
        return (LocaleComponent) Preconditions.checkNotNullFromProvides(instance.provideLocaleComponent(context));
    }
}
