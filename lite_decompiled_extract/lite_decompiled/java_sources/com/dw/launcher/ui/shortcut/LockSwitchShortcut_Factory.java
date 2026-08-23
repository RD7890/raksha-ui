package com.dw.launcher.ui.shortcut;

import com.dw.launcher.data.preference.LauncherPreference;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class LockSwitchShortcut_Factory implements Factory<LockSwitchShortcut> {
    private final Provider<LauncherPreference> mPreferenceProvider;

    public LockSwitchShortcut_Factory(Provider<LauncherPreference> mPreferenceProvider) {
        this.mPreferenceProvider = mPreferenceProvider;
    }

    @Override // javax.inject.Provider
    public LockSwitchShortcut get() {
        LockSwitchShortcut lockSwitchShortcutNewInstance = newInstance();
        LockSwitchShortcut_MembersInjector.injectMPreference(lockSwitchShortcutNewInstance, this.mPreferenceProvider.get());
        return lockSwitchShortcutNewInstance;
    }

    public static LockSwitchShortcut_Factory create(Provider<LauncherPreference> mPreferenceProvider) {
        return new LockSwitchShortcut_Factory(mPreferenceProvider);
    }

    public static LockSwitchShortcut newInstance() {
        return new LockSwitchShortcut();
    }
}
