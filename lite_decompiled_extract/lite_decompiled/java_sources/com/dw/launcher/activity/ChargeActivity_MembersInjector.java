package com.dw.launcher.activity;

import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.repository.LauncherRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ChargeActivity_MembersInjector implements MembersInjector<ChargeActivity> {
    private final Provider<LauncherRepository> mAssetsLaunchRepositoryProvider;
    private final Provider<NoDisturbComponent> noDisturbComponentProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public ChargeActivity_MembersInjector(Provider<SysKeyEvent> sysKeyEventProvider, Provider<LauncherRepository> mAssetsLaunchRepositoryProvider, Provider<NoDisturbComponent> noDisturbComponentProvider) {
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.mAssetsLaunchRepositoryProvider = mAssetsLaunchRepositoryProvider;
        this.noDisturbComponentProvider = noDisturbComponentProvider;
    }

    public static MembersInjector<ChargeActivity> create(Provider<SysKeyEvent> sysKeyEventProvider, Provider<LauncherRepository> mAssetsLaunchRepositoryProvider, Provider<NoDisturbComponent> noDisturbComponentProvider) {
        return new ChargeActivity_MembersInjector(sysKeyEventProvider, mAssetsLaunchRepositoryProvider, noDisturbComponentProvider);
    }

    public void injectMembers(ChargeActivity instance) {
        injectSysKeyEvent(instance, (SysKeyEvent) this.sysKeyEventProvider.get());
        injectMAssetsLaunchRepository(instance, (LauncherRepository) this.mAssetsLaunchRepositoryProvider.get());
        injectNoDisturbComponent(instance, (NoDisturbComponent) this.noDisturbComponentProvider.get());
    }

    public static void injectSysKeyEvent(ChargeActivity instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectMAssetsLaunchRepository(ChargeActivity instance, LauncherRepository mAssetsLaunchRepository) {
        instance.mAssetsLaunchRepository = mAssetsLaunchRepository;
    }

    public static void injectNoDisturbComponent(ChargeActivity instance, NoDisturbComponent noDisturbComponent) {
        instance.noDisturbComponent = noDisturbComponent;
    }
}
