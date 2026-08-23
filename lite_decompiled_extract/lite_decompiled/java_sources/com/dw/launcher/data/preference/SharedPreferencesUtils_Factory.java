package com.dw.launcher.data.preference;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class SharedPreferencesUtils_Factory implements Factory<SharedPreferencesUtils> {
    private final Provider<Context> contextProvider;

    public SharedPreferencesUtils_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SharedPreferencesUtils m215get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static SharedPreferencesUtils_Factory create(Provider<Context> contextProvider) {
        return new SharedPreferencesUtils_Factory(contextProvider);
    }

    public static SharedPreferencesUtils newInstance(Context context) {
        return new SharedPreferencesUtils(context);
    }
}
