package com.dw.launcher.core.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VoiceComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\n\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\u0006J\r\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\r\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/dw/launcher/core/component/VoiceComponent;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mAudioManager", "Landroid/media/AudioManager;", "onVolumnListener", "Lcom/dw/launcher/core/component/VoiceComponent$OnVolumnListener;", "volumeChangeReceiver", "com/dw/launcher/core/component/VoiceComponent$volumeChangeReceiver$1", "Lcom/dw/launcher/core/component/VoiceComponent$volumeChangeReceiver$1;", "getAudioManager", "getCurrVolume", BuildConfig.FLAVOR, "()Ljava/lang/Integer;", "getMaxVolume", "register", BuildConfig.FLAVOR, "setOnVolumnListener", "onVolumnListeners", "setVolume", "volume", "unregister", "OnVolumnListener", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VoiceComponent {
    private final Context context;
    private AudioManager mAudioManager;
    private OnVolumnListener onVolumnListener;
    private VoiceComponent$volumeChangeReceiver$1 volumeChangeReceiver;

    /* JADX INFO: compiled from: VoiceComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/core/component/VoiceComponent$OnVolumnListener;", BuildConfig.FLAVOR, "onVolumnChanged", BuildConfig.FLAVOR, "volume", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnVolumnListener {
        void onVolumnChanged(int volume);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.dw.launcher.core.component.VoiceComponent$volumeChangeReceiver$1] */
    @Inject
    public VoiceComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.mAudioManager = (AudioManager) systemService;
        this.volumeChangeReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.core.component.VoiceComponent$volumeChangeReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (Intrinsics.areEqual(intent.getAction(), "android.media.VOLUME_CHANGED_ACTION")) {
                    int intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1);
                    VoiceComponent.OnVolumnListener onVolumnListener = this.this$0.onVolumnListener;
                    if (onVolumnListener != null) {
                        onVolumnListener.onVolumnChanged(intExtra);
                    }
                }
            }
        };
    }

    public final Integer getCurrVolume() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return Integer.valueOf(audioManager.getStreamVolume(3));
        }
        return null;
    }

    public final Integer getMaxVolume() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return Integer.valueOf(audioManager.getStreamMaxVolume(3));
        }
        return null;
    }

    public final void setVolume(int volume) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, volume, 4);
        }
    }

    public final void setOnVolumnListener(OnVolumnListener onVolumnListeners) {
        Intrinsics.checkNotNullParameter(onVolumnListeners, "onVolumnListeners");
        this.onVolumnListener = onVolumnListeners;
    }

    public final void register() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        this.context.registerReceiver(this.volumeChangeReceiver, intentFilter);
    }

    public final void unregister() {
        VoiceComponent$volumeChangeReceiver$1 voiceComponent$volumeChangeReceiver$1 = this.volumeChangeReceiver;
        if (voiceComponent$volumeChangeReceiver$1 != null) {
            this.context.unregisterReceiver(voiceComponent$volumeChangeReceiver$1);
        }
    }

    /* JADX INFO: renamed from: getAudioManager, reason: from getter */
    public final AudioManager getMAudioManager() {
        return this.mAudioManager;
    }
}
