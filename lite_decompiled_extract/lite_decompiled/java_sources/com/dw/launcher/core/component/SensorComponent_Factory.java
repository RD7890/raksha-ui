package com.dw.launcher.core.component;

import android.content.Context;
import com.dw.launcher.data.repository.LauncherRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class SensorComponent_Factory implements Factory<SensorComponent> {
    private final Provider<Context> contextProvider;
    private final Provider<LauncherRepository> launcherRepositoryProvider;
    private final Provider<SoundEffect> mRingtoneComponentProvider;

    public SensorComponent_Factory(Provider<Context> contextProvider, Provider<LauncherRepository> launcherRepositoryProvider, Provider<SoundEffect> mRingtoneComponentProvider) {
        this.contextProvider = contextProvider;
        this.launcherRepositoryProvider = launcherRepositoryProvider;
        this.mRingtoneComponentProvider = mRingtoneComponentProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SensorComponent m195get() {
        SensorComponent sensorComponentNewInstance = newInstance((Context) this.contextProvider.get(), (LauncherRepository) this.launcherRepositoryProvider.get());
        SensorComponent_MembersInjector.injectMRingtoneComponent(sensorComponentNewInstance, (SoundEffect) this.mRingtoneComponentProvider.get());
        return sensorComponentNewInstance;
    }

    public static SensorComponent_Factory create(Provider<Context> contextProvider, Provider<LauncherRepository> launcherRepositoryProvider, Provider<SoundEffect> mRingtoneComponentProvider) {
        return new SensorComponent_Factory(contextProvider, launcherRepositoryProvider, mRingtoneComponentProvider);
    }

    public static SensorComponent newInstance(Context context, LauncherRepository launcherRepository) {
        return new SensorComponent(context, launcherRepository);
    }
}
