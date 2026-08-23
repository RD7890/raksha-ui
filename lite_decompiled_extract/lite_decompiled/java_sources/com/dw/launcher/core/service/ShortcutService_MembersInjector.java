package com.dw.launcher.core.service;

import com.dw.launcher.ui.shortcut.ShortcutInflater;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ShortcutService_MembersInjector implements MembersInjector<ShortcutService> {
    private final Provider<ShortcutInflater> shortcutInflaterProvider;

    public ShortcutService_MembersInjector(Provider<ShortcutInflater> shortcutInflaterProvider) {
        this.shortcutInflaterProvider = shortcutInflaterProvider;
    }

    public static MembersInjector<ShortcutService> create(Provider<ShortcutInflater> shortcutInflaterProvider) {
        return new ShortcutService_MembersInjector(shortcutInflaterProvider);
    }

    public void injectMembers(ShortcutService instance) {
        injectShortcutInflater(instance, (ShortcutInflater) this.shortcutInflaterProvider.get());
    }

    public static void injectShortcutInflater(ShortcutService instance, ShortcutInflater shortcutInflater) {
        instance.shortcutInflater = shortcutInflater;
    }
}
