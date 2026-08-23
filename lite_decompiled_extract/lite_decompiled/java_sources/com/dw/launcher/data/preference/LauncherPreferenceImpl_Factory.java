package com.dw.launcher.data.preference;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class LauncherPreferenceImpl_Factory implements Factory<LauncherPreferenceImpl> {
    private final Provider<Context> contextProvider;

    public LauncherPreferenceImpl_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public LauncherPreferenceImpl m214get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static LauncherPreferenceImpl_Factory create(Provider<Context> contextProvider) {
        return new LauncherPreferenceImpl_Factory(contextProvider);
    }

    public static LauncherPreferenceImpl newInstance(Context context) {
        return new LauncherPreferenceImpl(context);
    }
}
