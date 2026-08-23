package com.dw.launcher.ui.activity;

import com.dw.launcher.data.entity.SysKeyEvent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class BreatheSettingActivity_MembersInjector implements MembersInjector<BreatheSettingActivity> {
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public BreatheSettingActivity_MembersInjector(Provider<SysKeyEvent> sysKeyEventProvider) {
        this.sysKeyEventProvider = sysKeyEventProvider;
    }

    public static MembersInjector<BreatheSettingActivity> create(Provider<SysKeyEvent> sysKeyEventProvider) {
        return new BreatheSettingActivity_MembersInjector(sysKeyEventProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BreatheSettingActivity instance) {
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
    }

    public static void injectSysKeyEvent(BreatheSettingActivity instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }
}
