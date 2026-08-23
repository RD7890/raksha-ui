package com.dw.launcher.ui.activity;

import com.dw.launcher.data.entity.SysKeyEvent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class ShutdownActivity_MembersInjector implements MembersInjector<ShutdownActivity> {
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public ShutdownActivity_MembersInjector(Provider<SysKeyEvent> sysKeyEventProvider) {
        this.sysKeyEventProvider = sysKeyEventProvider;
    }

    public static MembersInjector<ShutdownActivity> create(Provider<SysKeyEvent> sysKeyEventProvider) {
        return new ShutdownActivity_MembersInjector(sysKeyEventProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ShutdownActivity instance) {
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
    }

    public static void injectSysKeyEvent(ShutdownActivity instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }
}
