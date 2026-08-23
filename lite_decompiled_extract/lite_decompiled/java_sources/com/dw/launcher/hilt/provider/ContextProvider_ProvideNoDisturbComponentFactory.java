package com.dw.launcher.hilt.provider;

import android.content.Context;
import com.dw.launcher.data.component.NoDisturbComponent;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvideNoDisturbComponentFactory implements Factory<NoDisturbComponent> {
    private final Provider<Context> contextProvider;
    private final ContextProvider module;

    public ContextProvider_ProvideNoDisturbComponentFactory(ContextProvider module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NoDisturbComponent m231get() {
        return provideNoDisturbComponent(this.module, (Context) this.contextProvider.get());
    }

    public static ContextProvider_ProvideNoDisturbComponentFactory create(ContextProvider module, Provider<Context> contextProvider) {
        return new ContextProvider_ProvideNoDisturbComponentFactory(module, contextProvider);
    }

    public static NoDisturbComponent provideNoDisturbComponent(ContextProvider instance, Context context) {
        return (NoDisturbComponent) Preconditions.checkNotNullFromProvides(instance.provideNoDisturbComponent(context));
    }
}
