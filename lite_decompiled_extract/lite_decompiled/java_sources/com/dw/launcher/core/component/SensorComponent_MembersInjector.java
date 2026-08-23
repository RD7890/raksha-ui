package com.dw.launcher.core.component;

import com.dw.launcher.hilt.annotion.RingToneAnnotion;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class SensorComponent_MembersInjector implements MembersInjector<SensorComponent> {
    private final Provider<SoundEffect> mRingtoneComponentProvider;

    public SensorComponent_MembersInjector(Provider<SoundEffect> mRingtoneComponentProvider) {
        this.mRingtoneComponentProvider = mRingtoneComponentProvider;
    }

    public static MembersInjector<SensorComponent> create(Provider<SoundEffect> mRingtoneComponentProvider) {
        return new SensorComponent_MembersInjector(mRingtoneComponentProvider);
    }

    public void injectMembers(SensorComponent instance) {
        injectMRingtoneComponent(instance, (SoundEffect) this.mRingtoneComponentProvider.get());
    }

    @RingToneAnnotion
    public static void injectMRingtoneComponent(SensorComponent instance, SoundEffect mRingtoneComponent) {
        instance.mRingtoneComponent = mRingtoneComponent;
    }
}
