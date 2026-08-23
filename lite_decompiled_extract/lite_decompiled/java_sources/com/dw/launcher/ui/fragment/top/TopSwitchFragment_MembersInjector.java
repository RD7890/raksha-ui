package com.dw.launcher.ui.fragment.top;

import com.dw.launcher.ui.shortcut.LockSwitchShortcut;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class TopSwitchFragment_MembersInjector implements MembersInjector<TopSwitchFragment> {
    private final Provider<LockSwitchShortcut> mLockSwitchShortcutProvider;

    public TopSwitchFragment_MembersInjector(Provider<LockSwitchShortcut> mLockSwitchShortcutProvider) {
        this.mLockSwitchShortcutProvider = mLockSwitchShortcutProvider;
    }

    public static MembersInjector<TopSwitchFragment> create(Provider<LockSwitchShortcut> mLockSwitchShortcutProvider) {
        return new TopSwitchFragment_MembersInjector(mLockSwitchShortcutProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(TopSwitchFragment instance) {
        injectMLockSwitchShortcut(instance, this.mLockSwitchShortcutProvider.get());
    }

    public static void injectMLockSwitchShortcut(TopSwitchFragment instance, LockSwitchShortcut mLockSwitchShortcut) {
        instance.mLockSwitchShortcut = mLockSwitchShortcut;
    }
}
