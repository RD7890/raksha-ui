package com.dw.launcher.ui.activity;

import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class ComponentManagerActivity_MembersInjector implements MembersInjector<ComponentManagerActivity> {
    private final Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public ComponentManagerActivity_MembersInjector(Provider<SysKeyEvent> sysKeyEventProvider, Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider) {
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.sharedPreferencesUtilsProvider = sharedPreferencesUtilsProvider;
    }

    public static MembersInjector<ComponentManagerActivity> create(Provider<SysKeyEvent> sysKeyEventProvider, Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider) {
        return new ComponentManagerActivity_MembersInjector(sysKeyEventProvider, sharedPreferencesUtilsProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ComponentManagerActivity instance) {
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
        injectSharedPreferencesUtils(instance, this.sharedPreferencesUtilsProvider.get());
    }

    public static void injectSysKeyEvent(ComponentManagerActivity instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectSharedPreferencesUtils(ComponentManagerActivity instance, SharedPreferencesUtils sharedPreferencesUtils) {
        instance.sharedPreferencesUtils = sharedPreferencesUtils;
    }
}
