package com.dw.launcher;

import com.dw.launcher.data.component.PhoneStatusComponent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.LauncherRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class Launcher_MembersInjector implements MembersInjector<Launcher> {
    private final Provider<LauncherRepository> launcherRepositoryProvider;
    private final Provider<PhoneStatusComponent> phoneStatusComponentProvider;
    private final Provider<LauncherPreference> preferencesProvider;

    public Launcher_MembersInjector(Provider<LauncherRepository> launcherRepositoryProvider, Provider<PhoneStatusComponent> phoneStatusComponentProvider, Provider<LauncherPreference> preferencesProvider) {
        this.launcherRepositoryProvider = launcherRepositoryProvider;
        this.phoneStatusComponentProvider = phoneStatusComponentProvider;
        this.preferencesProvider = preferencesProvider;
    }

    public static MembersInjector<Launcher> create(Provider<LauncherRepository> launcherRepositoryProvider, Provider<PhoneStatusComponent> phoneStatusComponentProvider, Provider<LauncherPreference> preferencesProvider) {
        return new Launcher_MembersInjector(launcherRepositoryProvider, phoneStatusComponentProvider, preferencesProvider);
    }

    public void injectMembers(Launcher instance) {
        injectLauncherRepository(instance, (LauncherRepository) this.launcherRepositoryProvider.get());
        injectPhoneStatusComponent(instance, (PhoneStatusComponent) this.phoneStatusComponentProvider.get());
        injectPreferences(instance, (LauncherPreference) this.preferencesProvider.get());
    }

    public static void injectLauncherRepository(Launcher instance, LauncherRepository launcherRepository) {
        instance.launcherRepository = launcherRepository;
    }

    public static void injectPhoneStatusComponent(Launcher instance, PhoneStatusComponent phoneStatusComponent) {
        instance.phoneStatusComponent = phoneStatusComponent;
    }

    public static void injectPreferences(Launcher instance, LauncherPreference preferences) {
        instance.preferences = preferences;
    }
}
