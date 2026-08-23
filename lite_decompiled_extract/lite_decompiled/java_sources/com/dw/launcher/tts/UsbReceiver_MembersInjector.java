package com.dw.launcher.tts;

import com.dw.launcher.data.repository.LauncherRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class UsbReceiver_MembersInjector implements MembersInjector<UsbReceiver> {
    private final Provider<LauncherRepository> launcherRepositoryProvider;

    public UsbReceiver_MembersInjector(Provider<LauncherRepository> launcherRepositoryProvider) {
        this.launcherRepositoryProvider = launcherRepositoryProvider;
    }

    public static MembersInjector<UsbReceiver> create(Provider<LauncherRepository> launcherRepositoryProvider) {
        return new UsbReceiver_MembersInjector(launcherRepositoryProvider);
    }

    public void injectMembers(UsbReceiver instance) {
        injectLauncherRepository(instance, (LauncherRepository) this.launcherRepositoryProvider.get());
    }

    public static void injectLauncherRepository(UsbReceiver instance, LauncherRepository launcherRepository) {
        instance.launcherRepository = launcherRepository;
    }
}
