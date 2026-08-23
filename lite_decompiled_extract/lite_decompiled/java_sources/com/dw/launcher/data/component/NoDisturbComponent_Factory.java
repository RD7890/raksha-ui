package com.dw.launcher.data.component;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class NoDisturbComponent_Factory implements Factory<NoDisturbComponent> {
    private final Provider<Context> contextProvider;

    public NoDisturbComponent_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NoDisturbComponent m208get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static NoDisturbComponent_Factory create(Provider<Context> contextProvider) {
        return new NoDisturbComponent_Factory(contextProvider);
    }

    public static NoDisturbComponent newInstance(Context context) {
        return new NoDisturbComponent(context);
    }
}
