package com.dw.launcher.core.component;

import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.core.notification.NotificationService;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: PlayCallbackComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n*\u0001\n\u0018\u00002\u00020\u0001:\u0001%B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0006\u0010 \u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u001cJ\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\bJ\u0006\u0010$\u001a\u00020\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/dw/launcher/core/component/PlayCallbackComponent;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mAudioManager", "Landroid/media/AudioManager;", "mCallback", "Lcom/dw/launcher/core/component/PlayCallbackComponent$OnPlayCallbackListener;", "mControllerCallback", "com/dw/launcher/core/component/PlayCallbackComponent$mControllerCallback$1", "Lcom/dw/launcher/core/component/PlayCallbackComponent$mControllerCallback$1;", "mHandler", "Landroid/os/Handler;", "mMediaSessionManager", "Landroid/media/session/MediaSessionManager;", "mNotificationService", "Landroid/content/ComponentName;", "mOnActiveSessionsChangedListener", "Landroid/media/session/MediaSessionManager$OnActiveSessionsChangedListener;", "mPostStateChangedCallback", "Ljava/lang/Runnable;", "getVolume", BuildConfig.FLAVOR, "getVolumeMax", "isPlaying", BuildConfig.FLAVOR, "next", BuildConfig.FLAVOR, "pause", "play", "postStateChanged", "prev", "register", "setCallback", "callback", "unregister", "OnPlayCallbackListener", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlayCallbackComponent {
    private final Context context;
    private final AudioManager mAudioManager;
    private OnPlayCallbackListener mCallback;
    private final PlayCallbackComponent$mControllerCallback$1 mControllerCallback;
    private final Handler mHandler;
    private final MediaSessionManager mMediaSessionManager;
    private final ComponentName mNotificationService;
    private final MediaSessionManager.OnActiveSessionsChangedListener mOnActiveSessionsChangedListener;
    private final Runnable mPostStateChangedCallback;

    /* JADX INFO: compiled from: PlayCallbackComponent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/dw/launcher/core/component/PlayCallbackComponent$OnPlayCallbackListener;", BuildConfig.FLAVOR, "onPlayStatusChanged", BuildConfig.FLAVOR, "onVolumeChanged", "volume", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnPlayCallbackListener {
        void onPlayStatusChanged();

        void onVolumeChanged(float volume);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.dw.launcher.core.component.PlayCallbackComponent$mControllerCallback$1] */
    @Inject
    public PlayCallbackComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.mAudioManager = (AudioManager) systemService;
        Object systemService2 = context.getSystemService("media_session");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.media.session.MediaSessionManager");
        this.mMediaSessionManager = (MediaSessionManager) systemService2;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationService = new ComponentName(context, (Class<?>) NotificationService.class);
        this.mControllerCallback = new MediaController.Callback() { // from class: com.dw.launcher.core.component.PlayCallbackComponent$mControllerCallback$1
            @Override // android.media.session.MediaController.Callback
            public void onAudioInfoChanged(MediaController.PlaybackInfo info) {
                super.onAudioInfoChanged(info);
                Timber.Forest.i("----onAudioInfoChanged, info: " + info, new Object[0]);
            }

            @Override // android.media.session.MediaController.Callback
            public void onPlaybackStateChanged(PlaybackState state) {
                super.onPlaybackStateChanged(state);
                Timber.Forest.i("----onPlaybackStateChanged, state: " + state, new Object[0]);
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionDestroyed() {
                super.onSessionDestroyed();
                Timber.Forest.i("----onSessionDestroyed", new Object[0]);
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionEvent(String event, Bundle extras) {
                Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
                super.onSessionEvent(event, extras);
                Timber.Forest.i("----onSessionEvent", new Object[0]);
            }

            @Override // android.media.session.MediaController.Callback
            public void onMetadataChanged(MediaMetadata metadata) {
                super.onMetadataChanged(metadata);
                Timber.Forest.i("----onMetadataChanged", new Object[0]);
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueChanged(List<MediaSession.QueueItem> queue) {
                super.onQueueChanged(queue);
                Timber.Forest.i("----onQueueChanged", new Object[0]);
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueTitleChanged(CharSequence title) {
                super.onQueueTitleChanged(title);
                Timber.Forest.i("----onQueueTitleChanged", new Object[0]);
            }

            @Override // android.media.session.MediaController.Callback
            public void onExtrasChanged(Bundle extras) {
                super.onExtrasChanged(extras);
                Timber.Forest.i("----onExtrasChanged", new Object[0]);
            }
        };
        this.mOnActiveSessionsChangedListener = new MediaSessionManager.OnActiveSessionsChangedListener() { // from class: com.dw.launcher.core.component.PlayCallbackComponent$$ExternalSyntheticLambda0
            @Override // android.media.session.MediaSessionManager.OnActiveSessionsChangedListener
            public final void onActiveSessionsChanged(List list) {
                PlayCallbackComponent.mOnActiveSessionsChangedListener$lambda$1(this.f$0, list);
            }
        };
        this.mPostStateChangedCallback = new Runnable() { // from class: com.dw.launcher.core.component.PlayCallbackComponent$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PlayCallbackComponent.mPostStateChangedCallback$lambda$9(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnActiveSessionsChangedListener$lambda$1(PlayCallbackComponent playCallbackComponent, List list) {
        Intrinsics.checkNotNullParameter(playCallbackComponent, "this$0");
        Timber.Forest.i("----onActiveSessionChanged: " + list, new Object[0]);
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((MediaController) it.next()).registerCallback(playCallbackComponent.mControllerCallback);
            }
        }
    }

    public final void setCallback(OnPlayCallbackListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCallback = callback;
    }

    public final void register() {
        Timber.Forest.i("----register", new Object[0]);
        this.mMediaSessionManager.addOnActiveSessionsChangedListener(this.mOnActiveSessionsChangedListener, this.mNotificationService);
        List<MediaController> activeSessions = this.mMediaSessionManager.getActiveSessions(this.mNotificationService);
        Intrinsics.checkNotNullExpressionValue(activeSessions, "getActiveSessions(...)");
        for (MediaController mediaController : activeSessions) {
            Timber.Forest.i("----getActiveSessions: " + mediaController + ", registerCallback", new Object[0]);
            mediaController.registerCallback(this.mControllerCallback);
        }
    }

    public final void unregister() {
        Timber.Forest.i("----unregister", new Object[0]);
        this.mCallback = null;
        this.mMediaSessionManager.removeOnActiveSessionsChangedListener(this.mOnActiveSessionsChangedListener);
    }

    public final boolean isPlaying() {
        List<MediaController> activeSessions = this.mMediaSessionManager.getActiveSessions(this.mNotificationService);
        Intrinsics.checkNotNullExpressionValue(activeSessions, "getActiveSessions(...)");
        Iterator<T> it = activeSessions.iterator();
        while (it.hasNext()) {
            PlaybackState playbackState = ((MediaController) it.next()).getPlaybackState();
            if (playbackState != null && playbackState.getState() == 3) {
                return true;
            }
        }
        return false;
    }

    public final void play() {
        List<MediaController> activeSessions = this.mMediaSessionManager.getActiveSessions(this.mNotificationService);
        Intrinsics.checkNotNullExpressionValue(activeSessions, "getActiveSessions(...)");
        Iterator<T> it = activeSessions.iterator();
        while (it.hasNext()) {
            ((MediaController) it.next()).getTransportControls().play();
        }
        postStateChanged();
    }

    public final void pause() {
        List<MediaController> activeSessions = this.mMediaSessionManager.getActiveSessions(this.mNotificationService);
        Intrinsics.checkNotNullExpressionValue(activeSessions, "getActiveSessions(...)");
        Iterator<T> it = activeSessions.iterator();
        while (it.hasNext()) {
            ((MediaController) it.next()).getTransportControls().pause();
        }
        postStateChanged();
    }

    public final void next() {
        List<MediaController> activeSessions = this.mMediaSessionManager.getActiveSessions(this.mNotificationService);
        Intrinsics.checkNotNullExpressionValue(activeSessions, "getActiveSessions(...)");
        Iterator<T> it = activeSessions.iterator();
        while (it.hasNext()) {
            ((MediaController) it.next()).getTransportControls().skipToNext();
        }
        postStateChanged();
    }

    public final void prev() {
        List<MediaController> activeSessions = this.mMediaSessionManager.getActiveSessions(this.mNotificationService);
        Intrinsics.checkNotNullExpressionValue(activeSessions, "getActiveSessions(...)");
        Iterator<T> it = activeSessions.iterator();
        while (it.hasNext()) {
            ((MediaController) it.next()).getTransportControls().skipToPrevious();
        }
        postStateChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPostStateChangedCallback$lambda$9(PlayCallbackComponent playCallbackComponent) {
        Intrinsics.checkNotNullParameter(playCallbackComponent, "this$0");
        OnPlayCallbackListener onPlayCallbackListener = playCallbackComponent.mCallback;
        if (onPlayCallbackListener != null) {
            onPlayCallbackListener.onPlayStatusChanged();
        }
    }

    public final int getVolume() {
        return this.mAudioManager.getStreamVolume(3);
    }

    public final int getVolumeMax() {
        return this.mAudioManager.getStreamMaxVolume(3);
    }

    private final void postStateChanged() {
        this.mHandler.removeCallbacks(this.mPostStateChangedCallback);
        this.mHandler.postDelayed(this.mPostStateChangedCallback, 500L);
    }
}
