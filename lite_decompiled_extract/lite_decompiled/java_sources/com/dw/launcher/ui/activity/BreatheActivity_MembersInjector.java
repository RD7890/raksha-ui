package com.dw.launcher.ui.activity;

import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.BreatheSharedPreferencesUtils;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class BreatheActivity_MembersInjector implements MembersInjector<BreatheActivity> {
    private final Provider<BreatheSharedPreferencesUtils> sharedPreferencesProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public BreatheActivity_MembersInjector(Provider<BreatheSharedPreferencesUtils> sharedPreferencesProvider, Provider<SysKeyEvent> sysKeyEventProvider) {
        this.sharedPreferencesProvider = sharedPreferencesProvider;
        this.sysKeyEventProvider = sysKeyEventProvider;
    }

    public static MembersInjector<BreatheActivity> create(Provider<BreatheSharedPreferencesUtils> sharedPreferencesProvider, Provider<SysKeyEvent> sysKeyEventProvider) {
        return new BreatheActivity_MembersInjector(sharedPreferencesProvider, sysKeyEventProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BreatheActivity instance) {
        injectSharedPreferences(instance, this.sharedPreferencesProvider.get());
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
    }

    public static void injectSharedPreferences(BreatheActivity instance, BreatheSharedPreferencesUtils sharedPreferences) {
        instance.sharedPreferences = sharedPreferences;
    }

    public static void injectSysKeyEvent(BreatheActivity instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }
}
