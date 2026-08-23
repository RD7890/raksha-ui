package com.dw.launcher.ui.activity;

import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class AddMenuShortcutActivity_MembersInjector implements MembersInjector<AddMenuShortcutActivity> {
    private final Provider<LauncherPreference> mPreferenceProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public AddMenuShortcutActivity_MembersInjector(Provider<LauncherPreference> mPreferenceProvider, Provider<SysKeyEvent> sysKeyEventProvider) {
        this.mPreferenceProvider = mPreferenceProvider;
        this.sysKeyEventProvider = sysKeyEventProvider;
    }

    public static MembersInjector<AddMenuShortcutActivity> create(Provider<LauncherPreference> mPreferenceProvider, Provider<SysKeyEvent> sysKeyEventProvider) {
        return new AddMenuShortcutActivity_MembersInjector(mPreferenceProvider, sysKeyEventProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AddMenuShortcutActivity instance) {
        injectMPreference(instance, this.mPreferenceProvider.get());
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
    }

    public static void injectMPreference(AddMenuShortcutActivity instance, LauncherPreference mPreference) {
        instance.mPreference = mPreference;
    }

    public static void injectSysKeyEvent(AddMenuShortcutActivity instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }
}
