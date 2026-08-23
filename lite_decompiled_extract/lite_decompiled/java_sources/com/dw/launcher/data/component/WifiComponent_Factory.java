package com.dw.launcher.data.component;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class WifiComponent_Factory implements Factory<WifiComponent> {
    private final Provider<Context> contextProvider;

    public WifiComponent_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public WifiComponent m212get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static WifiComponent_Factory create(Provider<Context> contextProvider) {
        return new WifiComponent_Factory(contextProvider);
    }

    public static WifiComponent newInstance(Context context) {
        return new WifiComponent(context);
    }
}
