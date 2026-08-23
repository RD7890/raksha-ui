package com.dw.launcher.ui.shortcut;

import com.dw.launcher.data.preference.LauncherPreference;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class LockSwitchShortcut_MembersInjector implements MembersInjector<LockSwitchShortcut> {
    private final Provider<LauncherPreference> mPreferenceProvider;

    public LockSwitchShortcut_MembersInjector(Provider<LauncherPreference> mPreferenceProvider) {
        this.mPreferenceProvider = mPreferenceProvider;
    }

    public static MembersInjector<LockSwitchShortcut> create(Provider<LauncherPreference> mPreferenceProvider) {
        return new LockSwitchShortcut_MembersInjector(mPreferenceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LockSwitchShortcut instance) {
        injectMPreference(instance, this.mPreferenceProvider.get());
    }

    public static void injectMPreference(LockSwitchShortcut instance, LauncherPreference mPreference) {
        instance.mPreference = mPreference;
    }
}
