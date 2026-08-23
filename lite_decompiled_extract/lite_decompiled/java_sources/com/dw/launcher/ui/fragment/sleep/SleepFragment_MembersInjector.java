package com.dw.launcher.ui.fragment.sleep;

import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class SleepFragment_MembersInjector implements MembersInjector<SleepFragment> {
    private final Provider<SharedPreferencesUtils> sharedPreferencesProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public SleepFragment_MembersInjector(Provider<SysKeyEvent> sysKeyEventProvider, Provider<SharedPreferencesUtils> sharedPreferencesProvider) {
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.sharedPreferencesProvider = sharedPreferencesProvider;
    }

    public static MembersInjector<SleepFragment> create(Provider<SysKeyEvent> sysKeyEventProvider, Provider<SharedPreferencesUtils> sharedPreferencesProvider) {
        return new SleepFragment_MembersInjector(sysKeyEventProvider, sharedPreferencesProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SleepFragment instance) {
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
        injectSharedPreferences(instance, this.sharedPreferencesProvider.get());
    }

    public static void injectSysKeyEvent(SleepFragment instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectSharedPreferences(SleepFragment instance, SharedPreferencesUtils sharedPreferences) {
        instance.sharedPreferences = sharedPreferences;
    }
}
