package com.dw.launcher.ui.activity;

import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class SleepClockActivity_MembersInjector implements MembersInjector<SleepClockActivity> {
    private final Provider<SysKeyEvent> keyEventProvider;
    private final Provider<SharedPreferencesUtils> sharedPreferencesProvider;

    public SleepClockActivity_MembersInjector(Provider<SysKeyEvent> keyEventProvider, Provider<SharedPreferencesUtils> sharedPreferencesProvider) {
        this.keyEventProvider = keyEventProvider;
        this.sharedPreferencesProvider = sharedPreferencesProvider;
    }

    public static MembersInjector<SleepClockActivity> create(Provider<SysKeyEvent> keyEventProvider, Provider<SharedPreferencesUtils> sharedPreferencesProvider) {
        return new SleepClockActivity_MembersInjector(keyEventProvider, sharedPreferencesProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SleepClockActivity instance) {
        injectKeyEvent(instance, this.keyEventProvider.get());
        injectSharedPreferences(instance, this.sharedPreferencesProvider.get());
    }

    public static void injectKeyEvent(SleepClockActivity instance, SysKeyEvent keyEvent) {
        instance.keyEvent = keyEvent;
    }

    public static void injectSharedPreferences(SleepClockActivity instance, SharedPreferencesUtils sharedPreferences) {
        instance.sharedPreferences = sharedPreferences;
    }
}
