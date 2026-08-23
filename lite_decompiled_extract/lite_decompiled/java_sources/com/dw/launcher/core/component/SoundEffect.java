package com.dw.launcher.core.component;

import android.net.Uri;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: compiled from: SoundEffect.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/dw/launcher/core/component/SoundEffect;", BuildConfig.FLAVOR, "isPlaying", BuildConfig.FLAVOR, "setLoop", BuildConfig.FLAVOR, "loop", "setSource", "source", "Landroid/net/Uri;", "start", "stop", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface SoundEffect {

    /* JADX INFO: compiled from: SoundEffect.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void setLoop(SoundEffect soundEffect, boolean z) {
        }
    }

    boolean isPlaying();

    void setLoop(boolean loop);

    void setSource(Uri source);

    void start();

    void stop();
}
