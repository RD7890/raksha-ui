package com.dw.launcher.data.preference;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class BreatheSharedPreferencesUtils_Factory implements Factory<BreatheSharedPreferencesUtils> {
    private final Provider<Context> contextProvider;

    public BreatheSharedPreferencesUtils_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public BreatheSharedPreferencesUtils m213get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static BreatheSharedPreferencesUtils_Factory create(Provider<Context> contextProvider) {
        return new BreatheSharedPreferencesUtils_Factory(contextProvider);
    }

    public static BreatheSharedPreferencesUtils newInstance(Context context) {
        return new BreatheSharedPreferencesUtils(context);
    }
}
