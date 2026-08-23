package com.dw.launcher.tts;

import com.dw.launcher.data.repository.LauncherRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class SmsReceiver_MembersInjector implements MembersInjector<SmsReceiver> {
    private final Provider<LauncherRepository> launcherRepositoryProvider;

    public SmsReceiver_MembersInjector(Provider<LauncherRepository> launcherRepositoryProvider) {
        this.launcherRepositoryProvider = launcherRepositoryProvider;
    }

    public static MembersInjector<SmsReceiver> create(Provider<LauncherRepository> launcherRepositoryProvider) {
        return new SmsReceiver_MembersInjector(launcherRepositoryProvider);
    }

    public void injectMembers(SmsReceiver instance) {
        injectLauncherRepository(instance, (LauncherRepository) this.launcherRepositoryProvider.get());
    }

    public static void injectLauncherRepository(SmsReceiver instance, LauncherRepository launcherRepository) {
        instance.launcherRepository = launcherRepository;
    }
}
