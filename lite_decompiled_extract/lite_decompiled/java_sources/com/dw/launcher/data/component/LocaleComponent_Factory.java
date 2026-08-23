package com.dw.launcher.data.component;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class LocaleComponent_Factory implements Factory<LocaleComponent> {
    private final Provider<Context> contextProvider;

    public LocaleComponent_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public LocaleComponent m207get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static LocaleComponent_Factory create(Provider<Context> contextProvider) {
        return new LocaleComponent_Factory(contextProvider);
    }

    public static LocaleComponent newInstance(Context context) {
        return new LocaleComponent(context);
    }
}
