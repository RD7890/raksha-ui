package com.dw.launcher.core.component;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: RingtoneComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/dw/launcher/core/component/RingtoneComponent;", "Lcom/dw/launcher/core/component/SoundEffect;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mLooping", BuildConfig.FLAVOR, "mRingtone", "Landroid/media/Ringtone;", "mRingtoneRes", BuildConfig.FLAVOR, "mUri", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "isPlaying", "setLoop", BuildConfig.FLAVOR, "loop", "setSource", "source", "start", "stop", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RingtoneComponent implements SoundEffect {
    private final Context context;
    private boolean mLooping;
    private Ringtone mRingtone;
    private int mRingtoneRes;
    private Uri mUri;

    @Inject
    public RingtoneComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mRingtoneRes = R.raw.wheel;
        this.mUri = Uri.parse("android.resource://" + context.getPackageName() + '/' + this.mRingtoneRes);
        this.mLooping = true;
    }

    @Override // com.dw.launcher.core.component.SoundEffect
    public void start() {
        Timber.Forest.i("----start ringtone", new Object[0]);
        if (this.mRingtone == null) {
            this.mRingtone = RingtoneManager.getRingtone(this.context, this.mUri);
        }
        Ringtone ringtone = this.mRingtone;
        if (ringtone == null || ringtone.isPlaying()) {
            return;
        }
        ringtone.setLooping(this.mLooping);
        ringtone.play();
    }

    @Override // com.dw.launcher.core.component.SoundEffect
    public boolean isPlaying() {
        Ringtone ringtone = this.mRingtone;
        if (ringtone != null) {
            return ringtone.isPlaying();
        }
        return false;
    }

    @Override // com.dw.launcher.core.component.SoundEffect
    public void setSource(Uri source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.mUri = source;
    }

    @Override // com.dw.launcher.core.component.SoundEffect
    public void setLoop(boolean loop) {
        SoundEffect.DefaultImpls.setLoop(this, loop);
        this.mLooping = loop;
        Ringtone ringtone = this.mRingtone;
        if (ringtone != null) {
            ringtone.setLooping(loop);
        }
    }

    @Override // com.dw.launcher.core.component.SoundEffect
    public void stop() {
        Timber.Forest.i("----stop ringtone", new Object[0]);
        Ringtone ringtone = this.mRingtone;
        if (ringtone == null || !ringtone.isPlaying()) {
            return;
        }
        ringtone.stop();
    }
}
