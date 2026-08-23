package com.dw.launcher.data.component;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class BatteryComponent_Factory implements Factory<BatteryComponent> {
    private final Provider<Context> contextProvider;

    public BatteryComponent_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public BatteryComponent m204get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static BatteryComponent_Factory create(Provider<Context> contextProvider) {
        return new BatteryComponent_Factory(contextProvider);
    }

    public static BatteryComponent newInstance(Context context) {
        return new BatteryComponent(context);
    }
}
