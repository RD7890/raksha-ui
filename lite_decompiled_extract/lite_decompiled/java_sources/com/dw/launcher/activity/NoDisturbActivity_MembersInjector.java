package com.dw.launcher.activity;

import com.dw.launcher.data.component.BatteryComponent;
import com.dw.launcher.data.entity.SysKeyEvent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class NoDisturbActivity_MembersInjector implements MembersInjector<NoDisturbActivity> {
    private final Provider<BatteryComponent> batteryComponentProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public NoDisturbActivity_MembersInjector(Provider<SysKeyEvent> sysKeyEventProvider, Provider<BatteryComponent> batteryComponentProvider) {
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.batteryComponentProvider = batteryComponentProvider;
    }

    public static MembersInjector<NoDisturbActivity> create(Provider<SysKeyEvent> sysKeyEventProvider, Provider<BatteryComponent> batteryComponentProvider) {
        return new NoDisturbActivity_MembersInjector(sysKeyEventProvider, batteryComponentProvider);
    }

    public void injectMembers(NoDisturbActivity instance) {
        injectSysKeyEvent(instance, (SysKeyEvent) this.sysKeyEventProvider.get());
        injectBatteryComponent(instance, (BatteryComponent) this.batteryComponentProvider.get());
    }

    public static void injectSysKeyEvent(NoDisturbActivity instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectBatteryComponent(NoDisturbActivity instance, BatteryComponent batteryComponent) {
        instance.batteryComponent = batteryComponent;
    }
}
