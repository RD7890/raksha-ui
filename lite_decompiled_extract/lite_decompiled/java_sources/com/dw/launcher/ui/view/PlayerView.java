package com.dw.launcher.ui.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.SurfaceTexture;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.util.FileUtils;
import com.google.android.mms.pdu.CharacterSets;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerView.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002:\u00010B=\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0014J \u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0016J \u0010(\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0016J\u0010\u0010)\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010*\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u0019J\u0006\u0010-\u001a\u00020 J\u0006\u0010.\u001a\u00020 J\u0010\u0010/\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/dw/launcher/ui/view/PlayerView;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "inputStream", "Ljava/io/InputStream;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "config", "Lcom/dw/launcher/data/entity/ClockConfig;", "(Landroid/content/Context;Ljava/io/InputStream;Landroid/util/AttributeSet;ILcom/dw/launcher/data/entity/ClockConfig;)V", "getConfig", "()Lcom/dw/launcher/data/entity/ClockConfig;", "getInputStream", "()Ljava/io/InputStream;", "isUpdate", "", "mMediaPlayer", "Landroid/media/MediaPlayer;", "screenStateReceiver", "Landroid/content/BroadcastReceiver;", "videoPrepareListenter", "Lcom/dw/launcher/ui/view/PlayerView$OnPreparedListener;", "getVideoPrepareListenter", "()Lcom/dw/launcher/ui/view/PlayerView$OnPreparedListener;", "setVideoPrepareListenter", "(Lcom/dw/launcher/ui/view/PlayerView$OnPreparedListener;)V", "wasPlaying", "initView", "", "onDetachedFromWindow", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "registerScreenStateReceiver", "setPreparedListener", "videoPreparedListenter", "stopPlay", "toggleVideo", "unregisterScreenStateReceiver", "OnPreparedListener", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class PlayerView extends TextureView implements TextureView.SurfaceTextureListener {
    private final ClockConfig config;
    private final InputStream inputStream;
    private boolean isUpdate;
    private MediaPlayer mMediaPlayer;
    private BroadcastReceiver screenStateReceiver;
    private OnPreparedListener videoPrepareListenter;
    private boolean wasPlaying;

    /* JADX INFO: compiled from: PlayerView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/dw/launcher/ui/view/PlayerView$OnPreparedListener;", "", "onComplete", "", "onFirstUpdate", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public interface OnPreparedListener {
        void onComplete();

        void onFirstUpdate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlayerView(Context context) {
        this(context, null, null, 0, null, 30, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlayerView(Context context, InputStream inputStream) {
        this(context, inputStream, null, 0, null, 28, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlayerView(Context context, InputStream inputStream, AttributeSet attributeSet) {
        this(context, inputStream, attributeSet, 0, null, 24, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlayerView(Context context, InputStream inputStream, AttributeSet attributeSet, int i) {
        this(context, inputStream, attributeSet, i, null, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
    }

    public /* synthetic */ PlayerView(Context context, InputStream inputStream, AttributeSet attributeSet, int i, ClockConfig clockConfig, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : inputStream, (i2 & 4) != 0 ? null : attributeSet, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? null : clockConfig);
    }

    public final InputStream getInputStream() {
        return this.inputStream;
    }

    public final ClockConfig getConfig() {
        return this.config;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerView(Context context, InputStream inputStream, AttributeSet attributeSet, int i, ClockConfig clockConfig) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.inputStream = inputStream;
        this.config = clockConfig;
        this.isUpdate = false;
        initView();
    }

    public final OnPreparedListener getVideoPrepareListenter() {
        return this.videoPrepareListenter;
    }

    public final void setVideoPrepareListenter(OnPreparedListener onPreparedListener) {
        this.videoPrepareListenter = onPreparedListener;
    }

    private final void initView() {
        setSurfaceTextureListener(this);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        registerScreenStateReceiver(context);
    }

    public final void setPreparedListener(OnPreparedListener videoPreparedListenter) {
        Intrinsics.checkNotNullParameter(videoPreparedListenter, "videoPreparedListenter");
        this.videoPrepareListenter = videoPreparedListenter;
    }

    public final void stopPlay() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        this.mMediaPlayer = null;
        try {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            unregisterScreenStateReceiver(context);
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopPlay();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        Surface surface = new Surface(surfaceTexture);
        try {
            Log.i("vidoe", " load start mp4 file ...");
            this.mMediaPlayer = new MediaPlayer();
            FileUtils fileUtils = FileUtils.INSTANCE;
            InputStream inputStream = this.inputStream;
            Intrinsics.checkNotNull(inputStream);
            MediaDataSource mediaDataSource = new com.dw.launcher.data.entity.MediaDataSource(fileUtils.inputStreamToByteArray(inputStream));
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer);
            mediaPlayer.setDataSource(mediaDataSource);
            MediaPlayer mediaPlayer2 = this.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer2);
            mediaPlayer2.setSurface(surface);
            MediaPlayer mediaPlayer3 = this.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer3);
            mediaPlayer3.setLooping(true);
            ClockConfig clockConfig = this.config;
            if (clockConfig != null && clockConfig.getVideo_type() == 1) {
                MediaPlayer mediaPlayer4 = this.mMediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer4);
                mediaPlayer4.setLooping(false);
            }
            MediaPlayer mediaPlayer5 = this.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer5);
            mediaPlayer5.prepareAsync();
            MediaPlayer mediaPlayer6 = this.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer6);
            mediaPlayer6.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.dw.launcher.ui.view.PlayerView$$ExternalSyntheticLambda0
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer7) {
                    PlayerView.onSurfaceTextureAvailable$lambda$1(this.f$0, mediaPlayer7);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSurfaceTextureAvailable$lambda$1(PlayerView this$0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MediaPlayer mediaPlayer2 = this$0.mMediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer2);
        if (!mediaPlayer2.isPlaying()) {
            MediaPlayer mediaPlayer3 = this$0.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer3);
            mediaPlayer3.start();
        }
        OnPreparedListener onPreparedListener = this$0.videoPrepareListenter;
        if (onPreparedListener != null) {
            onPreparedListener.onComplete();
        }
        Log.i("vidoe", " load end mp4 file ...");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        stopPlay();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        if (this.isUpdate) {
            return;
        }
        this.isUpdate = true;
        OnPreparedListener onPreparedListener = this.videoPrepareListenter;
        if (onPreparedListener != null) {
            onPreparedListener.onFirstUpdate();
        }
    }

    private final void registerScreenStateReceiver(Context context) {
        this.screenStateReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.ui.view.PlayerView.registerScreenStateReceiver.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                MediaPlayer mediaPlayer;
                String action = intent != null ? intent.getAction() : null;
                if (Intrinsics.areEqual(action, "android.intent.action.SCREEN_OFF")) {
                    MediaPlayer mediaPlayer2 = PlayerView.this.mMediaPlayer;
                    if (mediaPlayer2 != null) {
                        PlayerView playerView = PlayerView.this;
                        if (mediaPlayer2.isPlaying()) {
                            mediaPlayer2.pause();
                        }
                        playerView.wasPlaying = true;
                        return;
                    }
                    return;
                }
                if (!Intrinsics.areEqual(action, "android.intent.action.SCREEN_ON") || (mediaPlayer = PlayerView.this.mMediaPlayer) == null) {
                    return;
                }
                PlayerView playerView2 = PlayerView.this;
                if (playerView2.wasPlaying) {
                    mediaPlayer.start();
                }
                playerView2.wasPlaying = false;
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        context.registerReceiver(this.screenStateReceiver, intentFilter);
    }

    private final void unregisterScreenStateReceiver(Context context) {
        BroadcastReceiver broadcastReceiver = this.screenStateReceiver;
        if (broadcastReceiver != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.screenStateReceiver = null;
        }
    }

    public final void toggleVideo() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        if ((mediaPlayer2 == null || !mediaPlayer2.isPlaying()) && (mediaPlayer = this.mMediaPlayer) != null) {
            mediaPlayer.start();
        }
    }
}
