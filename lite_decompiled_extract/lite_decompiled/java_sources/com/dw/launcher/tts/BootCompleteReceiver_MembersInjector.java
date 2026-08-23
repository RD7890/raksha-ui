package com.dw.launcher.tts;

import com.dw.launcher.data.repository.LauncherRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class BootCompleteReceiver_MembersInjector implements MembersInjector<BootCompleteReceiver> {
    private final Provider<LauncherRepository> launcherRepositoryProvider;

    public BootCompleteReceiver_MembersInjector(Provider<LauncherRepository> launcherRepositoryProvider) {
        this.launcherRepositoryProvider = launcherRepositoryProvider;
    }

    public static MembersInjector<BootCompleteReceiver> create(Provider<LauncherRepository> launcherRepositoryProvider) {
        return new BootCompleteReceiver_MembersInjector(launcherRepositoryProvider);
    }

    public void injectMembers(BootCompleteReceiver instance) {
        injectLauncherRepository(instance, (LauncherRepository) this.launcherRepositoryProvider.get());
    }

    public static void injectLauncherRepository(BootCompleteReceiver instance, LauncherRepository launcherRepository) {
        instance.launcherRepository = launcherRepository;
    }
}
