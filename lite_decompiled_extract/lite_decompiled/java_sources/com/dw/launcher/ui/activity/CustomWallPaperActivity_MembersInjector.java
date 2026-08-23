package com.dw.launcher.ui.activity;

import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class CustomWallPaperActivity_MembersInjector implements MembersInjector<CustomWallPaperActivity> {
    private final Provider<LauncherPreference> preferenceProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public CustomWallPaperActivity_MembersInjector(Provider<SysKeyEvent> sysKeyEventProvider, Provider<LauncherPreference> preferenceProvider) {
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.preferenceProvider = preferenceProvider;
    }

    public static MembersInjector<CustomWallPaperActivity> create(Provider<SysKeyEvent> sysKeyEventProvider, Provider<LauncherPreference> preferenceProvider) {
        return new CustomWallPaperActivity_MembersInjector(sysKeyEventProvider, preferenceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(CustomWallPaperActivity instance) {
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
        injectPreference(instance, this.preferenceProvider.get());
    }

    public static void injectSysKeyEvent(CustomWallPaperActivity instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectPreference(CustomWallPaperActivity instance, LauncherPreference preference) {
        instance.preference = preference;
    }
}
