package com.dw.launcher.core.component;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class PlayCallbackComponent_Factory implements Factory<PlayCallbackComponent> {
    private final Provider<Context> contextProvider;

    public PlayCallbackComponent_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public PlayCallbackComponent m193get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static PlayCallbackComponent_Factory create(Provider<Context> contextProvider) {
        return new PlayCallbackComponent_Factory(contextProvider);
    }

    public static PlayCallbackComponent newInstance(Context context) {
        return new PlayCallbackComponent(context);
    }
}
