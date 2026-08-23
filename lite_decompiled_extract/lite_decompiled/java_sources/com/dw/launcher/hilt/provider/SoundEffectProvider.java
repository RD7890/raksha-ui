package com.dw.launcher.hilt.provider;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.core.component.RingtoneComponent;
import com.dw.launcher.core.component.SoundEffect;
import com.dw.launcher.core.component.SoundPoolComponent;
import com.dw.launcher.hilt.annotion.RingToneAnnotion;
import com.dw.launcher.hilt.annotion.SoundPoolAnnotion;
import dagger.Binds;
import dagger.Module;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: compiled from: SoundEffectProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/dw/launcher/hilt/provider/SoundEffectProvider;", BuildConfig.FLAVOR, "()V", "provideRingtoneComponent", "Lcom/dw/launcher/core/component/SoundEffect;", "ringtoneComponent", "Lcom/dw/launcher/core/component/RingtoneComponent;", "provideSoundEffect", "soundPoolComponent", "Lcom/dw/launcher/core/component/SoundPoolComponent;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Module
public abstract class SoundEffectProvider {
    @Singleton
    @RingToneAnnotion
    @Binds
    public abstract SoundEffect provideRingtoneComponent(RingtoneComponent ringtoneComponent);

    @Singleton
    @SoundPoolAnnotion
    @Binds
    public abstract SoundEffect provideSoundEffect(SoundPoolComponent soundPoolComponent);
}
