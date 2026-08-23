package com.dw.launcher.data.component;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class BrightComponent_Factory implements Factory<BrightComponent> {
    private final Provider<Context> contextProvider;

    public BrightComponent_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public BrightComponent m206get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static BrightComponent_Factory create(Provider<Context> contextProvider) {
        return new BrightComponent_Factory(contextProvider);
    }

    public static BrightComponent newInstance(Context context) {
        return new BrightComponent(context);
    }
}
