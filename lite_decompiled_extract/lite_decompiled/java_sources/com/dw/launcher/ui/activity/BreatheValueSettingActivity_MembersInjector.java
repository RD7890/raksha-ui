package com.dw.launcher.ui.activity;

import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.BreatheSharedPreferencesUtils;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class BreatheValueSettingActivity_MembersInjector implements MembersInjector<BreatheValueSettingActivity> {
    private final Provider<BreatheSharedPreferencesUtils> sharedPreferencesProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public BreatheValueSettingActivity_MembersInjector(Provider<SysKeyEvent> sysKeyEventProvider, Provider<BreatheSharedPreferencesUtils> sharedPreferencesProvider) {
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.sharedPreferencesProvider = sharedPreferencesProvider;
    }

    public static MembersInjector<BreatheValueSettingActivity> create(Provider<SysKeyEvent> sysKeyEventProvider, Provider<BreatheSharedPreferencesUtils> sharedPreferencesProvider) {
        return new BreatheValueSettingActivity_MembersInjector(sysKeyEventProvider, sharedPreferencesProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BreatheValueSettingActivity instance) {
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
        injectSharedPreferences(instance, this.sharedPreferencesProvider.get());
    }

    public static void injectSysKeyEvent(BreatheValueSettingActivity instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectSharedPreferences(BreatheValueSettingActivity instance, BreatheSharedPreferencesUtils sharedPreferences) {
        instance.sharedPreferences = sharedPreferences;
    }
}
