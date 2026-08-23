package com.dw.launcher.core.component;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class RingtoneComponent_Factory implements Factory<RingtoneComponent> {
    private final Provider<Context> contextProvider;

    public RingtoneComponent_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public RingtoneComponent m194get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static RingtoneComponent_Factory create(Provider<Context> contextProvider) {
        return new RingtoneComponent_Factory(contextProvider);
    }

    public static RingtoneComponent newInstance(Context context) {
        return new RingtoneComponent(context);
    }
}
