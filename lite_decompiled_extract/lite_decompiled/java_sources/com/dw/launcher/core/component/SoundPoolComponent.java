package com.dw.launcher.core.component;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SoundPoolComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\f0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/dw/launcher/core/component/SoundPoolComponent;", "Lcom/dw/launcher/core/component/SoundEffect;", "Landroid/media/SoundPool$OnLoadCompleteListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "audioAttributes", "Landroid/media/AudioAttributes;", "kotlin.jvm.PlatformType", "mSoundId", BuildConfig.FLAVOR, "mSoundPool", "Landroid/media/SoundPool;", "mStreamId", "isPlaying", BuildConfig.FLAVOR, "onLoadComplete", BuildConfig.FLAVOR, "soundPool", "sampleId", NotificationCompat.CATEGORY_STATUS, "setSource", "source", "Landroid/net/Uri;", "start", "stop", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SoundPoolComponent implements SoundEffect, SoundPool.OnLoadCompleteListener {
    private final AudioAttributes audioAttributes;
    private final Context context;
    private int mSoundId;
    private SoundPool mSoundPool;
    private int mStreamId;

    @Override // com.dw.launcher.core.component.SoundEffect
    public boolean isPlaying() {
        return false;
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
    }

    @Override // com.dw.launcher.core.component.SoundEffect
    public void setSource(Uri source) {
        Intrinsics.checkNotNullParameter(source, "source");
    }

    @Inject
    public SoundPoolComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(16).setContentType(2).build();
        this.audioAttributes = audioAttributesBuild;
        this.mStreamId = -1;
        this.mSoundId = -1;
        SoundPool soundPoolBuild = new SoundPool.Builder().setAudioAttributes(audioAttributesBuild).build();
        this.mSoundPool = soundPoolBuild;
        soundPoolBuild.setOnLoadCompleteListener(this);
        this.mSoundId = this.mSoundPool.load(context, R.raw.wheel, 0);
    }

    @Override // com.dw.launcher.core.component.SoundEffect
    public void setLoop(boolean z) {
        SoundEffect.DefaultImpls.setLoop(this, z);
    }

    @Override // com.dw.launcher.core.component.SoundEffect
    public void start() {
        this.mStreamId = this.mSoundPool.play(this.mSoundId, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    @Override // com.dw.launcher.core.component.SoundEffect
    public void stop() {
        this.mSoundPool.stop(this.mStreamId);
    }
}
