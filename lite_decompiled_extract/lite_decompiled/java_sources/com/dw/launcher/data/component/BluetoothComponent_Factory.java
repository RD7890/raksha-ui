package com.dw.launcher.data.component;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class BluetoothComponent_Factory implements Factory<BluetoothComponent> {
    private final Provider<Context> contextProvider;

    public BluetoothComponent_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public BluetoothComponent m205get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static BluetoothComponent_Factory create(Provider<Context> contextProvider) {
        return new BluetoothComponent_Factory(contextProvider);
    }

    public static BluetoothComponent newInstance(Context context) {
        return new BluetoothComponent(context);
    }
}
