package com.dw.launcher.ui.activity;

import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.repository.IShortcutRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class SetThemeActivity_MembersInjector implements MembersInjector<SetThemeActivity> {
    private final Provider<NoDisturbComponent> noDisturbComponentProvider;
    private final Provider<IShortcutRepository> shortcutRepositoryProvider;
    private final Provider<SysKeyEvent> sysKeyEventProvider;

    public SetThemeActivity_MembersInjector(Provider<SysKeyEvent> sysKeyEventProvider, Provider<IShortcutRepository> shortcutRepositoryProvider, Provider<NoDisturbComponent> noDisturbComponentProvider) {
        this.sysKeyEventProvider = sysKeyEventProvider;
        this.shortcutRepositoryProvider = shortcutRepositoryProvider;
        this.noDisturbComponentProvider = noDisturbComponentProvider;
    }

    public static MembersInjector<SetThemeActivity> create(Provider<SysKeyEvent> sysKeyEventProvider, Provider<IShortcutRepository> shortcutRepositoryProvider, Provider<NoDisturbComponent> noDisturbComponentProvider) {
        return new SetThemeActivity_MembersInjector(sysKeyEventProvider, shortcutRepositoryProvider, noDisturbComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SetThemeActivity instance) {
        injectSysKeyEvent(instance, this.sysKeyEventProvider.get());
        injectShortcutRepository(instance, this.shortcutRepositoryProvider.get());
        injectNoDisturbComponent(instance, this.noDisturbComponentProvider.get());
    }

    public static void injectSysKeyEvent(SetThemeActivity instance, SysKeyEvent sysKeyEvent) {
        instance.sysKeyEvent = sysKeyEvent;
    }

    public static void injectShortcutRepository(SetThemeActivity instance, IShortcutRepository shortcutRepository) {
        instance.shortcutRepository = shortcutRepository;
    }

    public static void injectNoDisturbComponent(SetThemeActivity instance, NoDisturbComponent noDisturbComponent) {
        instance.noDisturbComponent = noDisturbComponent;
    }
}
