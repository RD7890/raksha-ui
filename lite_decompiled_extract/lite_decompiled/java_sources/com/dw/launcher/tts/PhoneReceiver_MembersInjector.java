package com.dw.launcher.tts;

import com.dw.launcher.data.repository.LauncherRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class PhoneReceiver_MembersInjector implements MembersInjector<PhoneReceiver> {
    private final Provider<LauncherRepository> launcherRepositoryProvider;

    public PhoneReceiver_MembersInjector(Provider<LauncherRepository> launcherRepositoryProvider) {
        this.launcherRepositoryProvider = launcherRepositoryProvider;
    }

    public static MembersInjector<PhoneReceiver> create(Provider<LauncherRepository> launcherRepositoryProvider) {
        return new PhoneReceiver_MembersInjector(launcherRepositoryProvider);
    }

    public void injectMembers(PhoneReceiver instance) {
        injectLauncherRepository(instance, (LauncherRepository) this.launcherRepositoryProvider.get());
    }

    public static void injectLauncherRepository(PhoneReceiver instance, LauncherRepository launcherRepository) {
        instance.launcherRepository = launcherRepository;
    }
}
