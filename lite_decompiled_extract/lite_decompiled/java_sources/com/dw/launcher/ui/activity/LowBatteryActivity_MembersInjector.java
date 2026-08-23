package com.dw.launcher.ui.activity;

import com.dw.launcher.data.entity.SysKeyEvent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class LowBatteryActivity_MembersInjector implements MembersInjector<LowBatteryActivity> {
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public LowBatteryActivity_MembersInjector(Provider<SysKeyEvent> sysKeyEventProvider) {
        this.sysKeyEventProvider = sysKeyEventProvider;
    }

    public static MembersInjector<LowBatteryActivity> create(Provider<SysKeyEvent> sysKeyEventProvider) {
        return new LowBatteryActivity_MembersInjector(sysKeyEventProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LowBatteryActivity instance) {
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
    }

    public static void injectSysKeyEvent(LowBatteryActivity instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }
}
