package com.dw.launcher.core.component;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class VoiceComponent_Factory implements Factory<VoiceComponent> {
    private final Provider<Context> contextProvider;

    public VoiceComponent_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public VoiceComponent m197get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static VoiceComponent_Factory create(Provider<Context> contextProvider) {
        return new VoiceComponent_Factory(contextProvider);
    }

    public static VoiceComponent newInstance(Context context) {
        return new VoiceComponent(context);
    }
}
