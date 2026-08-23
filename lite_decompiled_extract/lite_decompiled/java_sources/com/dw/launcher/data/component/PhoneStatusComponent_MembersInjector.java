package com.dw.launcher.data.component;

import dagger.MembersInjector;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class PhoneStatusComponent_MembersInjector implements MembersInjector<PhoneStatusComponent> {
    private final Provider<Executor> mExecutorProvider;

    public PhoneStatusComponent_MembersInjector(Provider<Executor> mExecutorProvider) {
        this.mExecutorProvider = mExecutorProvider;
    }

    public static MembersInjector<PhoneStatusComponent> create(Provider<Executor> mExecutorProvider) {
        return new PhoneStatusComponent_MembersInjector(mExecutorProvider);
    }

    public void injectMembers(PhoneStatusComponent instance) {
        injectMExecutor(instance, (Executor) this.mExecutorProvider.get());
    }

    public static void injectMExecutor(PhoneStatusComponent instance, Executor mExecutor) {
        instance.mExecutor = mExecutor;
    }
}
