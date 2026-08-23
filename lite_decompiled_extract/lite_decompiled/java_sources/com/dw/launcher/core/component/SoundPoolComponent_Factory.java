package com.dw.launcher.core.component;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class SoundPoolComponent_Factory implements Factory<SoundPoolComponent> {
    private final Provider<Context> contextProvider;

    public SoundPoolComponent_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SoundPoolComponent m196get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static SoundPoolComponent_Factory create(Provider<Context> contextProvider) {
        return new SoundPoolComponent_Factory(contextProvider);
    }

    public static SoundPoolComponent newInstance(Context context) {
        return new SoundPoolComponent(context);
    }
}
