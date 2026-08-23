package com.dw.launcher.data.component;

import android.content.Context;
import dagger.internal.Factory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class PhoneStatusComponent_Factory implements Factory<PhoneStatusComponent> {
    private final Provider<Context> contextProvider;
    private final Provider<Executor> mExecutorProvider;

    public PhoneStatusComponent_Factory(Provider<Context> contextProvider, Provider<Executor> mExecutorProvider) {
        this.contextProvider = contextProvider;
        this.mExecutorProvider = mExecutorProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public PhoneStatusComponent m210get() {
        PhoneStatusComponent phoneStatusComponentNewInstance = newInstance((Context) this.contextProvider.get());
        PhoneStatusComponent_MembersInjector.injectMExecutor(phoneStatusComponentNewInstance, (Executor) this.mExecutorProvider.get());
        return phoneStatusComponentNewInstance;
    }

    public static PhoneStatusComponent_Factory create(Provider<Context> contextProvider, Provider<Executor> mExecutorProvider) {
        return new PhoneStatusComponent_Factory(contextProvider, mExecutorProvider);
    }

    public static PhoneStatusComponent newInstance(Context context) {
        return new PhoneStatusComponent(context);
    }
}
