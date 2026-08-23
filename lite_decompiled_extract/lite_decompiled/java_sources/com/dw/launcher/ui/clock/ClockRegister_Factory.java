package com.dw.launcher.ui.clock;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class ClockRegister_Factory implements Factory<ClockRegister> {
    private final Provider<Context> contextProvider;

    public ClockRegister_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider
    public ClockRegister get() {
        return newInstance(this.contextProvider.get());
    }

    public static ClockRegister_Factory create(Provider<Context> contextProvider) {
        return new ClockRegister_Factory(contextProvider);
    }

    public static ClockRegister newInstance(Context context) {
        return new ClockRegister(context);
    }
}
