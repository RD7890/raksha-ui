package com.dw.launcher.hilt.provider;

import android.content.Context;
import com.dw.launcher.data.entity.SysKeyEvent;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_GetSystemKeyFactory implements Factory<SysKeyEvent> {
    private final Provider<Context> contextProvider;
    private final ContextProvider module;

    public ContextProvider_GetSystemKeyFactory(ContextProvider module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SysKeyEvent m222get() {
        return getSystemKey(this.module, (Context) this.contextProvider.get());
    }

    public static ContextProvider_GetSystemKeyFactory create(ContextProvider module, Provider<Context> contextProvider) {
        return new ContextProvider_GetSystemKeyFactory(module, contextProvider);
    }

    public static SysKeyEvent getSystemKey(ContextProvider instance, Context context) {
        return (SysKeyEvent) Preconditions.checkNotNullFromProvides(instance.getSystemKey(context));
    }
}
