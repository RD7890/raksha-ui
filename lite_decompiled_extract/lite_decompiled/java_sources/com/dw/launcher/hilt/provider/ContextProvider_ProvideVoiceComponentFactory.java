package com.dw.launcher.hilt.provider;

import android.content.Context;
import com.dw.launcher.core.component.VoiceComponent;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvideVoiceComponentFactory implements Factory<VoiceComponent> {
    private final Provider<Context> contextProvider;
    private final ContextProvider module;

    public ContextProvider_ProvideVoiceComponentFactory(ContextProvider module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public VoiceComponent m237get() {
        return provideVoiceComponent(this.module, (Context) this.contextProvider.get());
    }

    public static ContextProvider_ProvideVoiceComponentFactory create(ContextProvider module, Provider<Context> contextProvider) {
        return new ContextProvider_ProvideVoiceComponentFactory(module, contextProvider);
    }

    public static VoiceComponent provideVoiceComponent(ContextProvider instance, Context context) {
        return (VoiceComponent) Preconditions.checkNotNullFromProvides(instance.provideVoiceComponent(context));
    }
}
