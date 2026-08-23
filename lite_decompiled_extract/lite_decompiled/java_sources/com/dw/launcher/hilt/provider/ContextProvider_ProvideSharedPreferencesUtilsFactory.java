package com.dw.launcher.hilt.provider;

import android.content.Context;
import com.dw.launcher.data.preference.SharedPreferencesUtils;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvideSharedPreferencesUtilsFactory implements Factory<SharedPreferencesUtils> {
    private final Provider<Context> contextProvider;
    private final ContextProvider module;

    public ContextProvider_ProvideSharedPreferencesUtilsFactory(ContextProvider module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SharedPreferencesUtils m234get() {
        return provideSharedPreferencesUtils(this.module, (Context) this.contextProvider.get());
    }

    public static ContextProvider_ProvideSharedPreferencesUtilsFactory create(ContextProvider module, Provider<Context> contextProvider) {
        return new ContextProvider_ProvideSharedPreferencesUtilsFactory(module, contextProvider);
    }

    public static SharedPreferencesUtils provideSharedPreferencesUtils(ContextProvider instance, Context context) {
        return (SharedPreferencesUtils) Preconditions.checkNotNullFromProvides(instance.provideSharedPreferencesUtils(context));
    }
}
