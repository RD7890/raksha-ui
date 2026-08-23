package com.dw.launcher.hilt.provider;

import android.content.Context;
import com.dw.launcher.data.component.PhoneStatusComponent;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvidePhoneStatusComponentFactory implements Factory<PhoneStatusComponent> {
    private final Provider<Context> contextProvider;
    private final ContextProvider module;

    public ContextProvider_ProvidePhoneStatusComponentFactory(ContextProvider module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public PhoneStatusComponent m233get() {
        return providePhoneStatusComponent(this.module, (Context) this.contextProvider.get());
    }

    public static ContextProvider_ProvidePhoneStatusComponentFactory create(ContextProvider module, Provider<Context> contextProvider) {
        return new ContextProvider_ProvidePhoneStatusComponentFactory(module, contextProvider);
    }

    public static PhoneStatusComponent providePhoneStatusComponent(ContextProvider instance, Context context) {
        return (PhoneStatusComponent) Preconditions.checkNotNullFromProvides(instance.providePhoneStatusComponent(context));
    }
}
