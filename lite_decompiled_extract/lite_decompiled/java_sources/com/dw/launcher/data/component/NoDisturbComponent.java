package com.dw.launcher.data.component;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.Launcher;
import com.dw.launcher.activity.NoDisturbActivity;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: NoDisturbComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014*\u0001\u0012\u0018\u0000 '2\u00020\u0001:\u0006'()*+,B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010J\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u0006\u0010 \u001a\u00020\u0019J\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fJ\u000e\u0010#\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010J\u000e\u0010$\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015J\u000e\u0010%\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010&\u001a\u00020\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\bj\b\u0012\u0004\u0012\u00020\u0010`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00150\bj\b\u0012\u0004\u0012\u00020\u0015`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00170\bj\b\u0012\u0004\u0012\u00020\u0017`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/dw/launcher/data/component/NoDisturbComponent;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mAppLocakListeners", "Ljava/util/ArrayList;", "Lcom/dw/launcher/data/component/NoDisturbComponent$OnAppLockChangedListener;", "Lkotlin/collections/ArrayList;", "mDialBubbleChangedListener", "Lcom/dw/launcher/data/component/NoDisturbComponent$OnDialBubbleChangedListener;", "mHandler", "Landroid/os/Handler;", "mListeners", "Lcom/dw/launcher/data/component/NoDisturbComponent$OnNoDisturbComponentListener;", "mObserver", "com/dw/launcher/data/component/NoDisturbComponent$mObserver$1", "Lcom/dw/launcher/data/component/NoDisturbComponent$mObserver$1;", "mStatusMsgChangedListener", "Lcom/dw/launcher/data/component/NoDisturbComponent$OnStatusMsgChangedListener;", "mWatchModeChangedListener", "Lcom/dw/launcher/data/component/NoDisturbComponent$OnWatchModeChangedListener;", "addAppLockListener", BuildConfig.FLAVOR, "listener", "addDialBubbleChangedListener", "addListener", "addStatusMsgChangedListener", "addWatchModeChangedListener", "killAllApps", "register", "removeAppLockListener", "removeDialBubbleChangedListener", "removeListener", "removeStatusMsgChangedListener", "removeWatchModeChangedListener", "unregister", "Companion", "OnAppLockChangedListener", "OnDialBubbleChangedListener", "OnNoDisturbComponentListener", "OnStatusMsgChangedListener", "OnWatchModeChangedListener", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NoDisturbComponent {
    public static final String DOWN_MENU_MODE = "down_menu_mode";
    public static final String SUPPORT_DIAL_BUBBLE = "support_dial_bubble";
    public static final String WATCH_MODE = "watch_mode";
    private final Context context;
    private final ArrayList<OnAppLockChangedListener> mAppLocakListeners;
    private final ArrayList<OnDialBubbleChangedListener> mDialBubbleChangedListener;
    private final Handler mHandler;
    private final ArrayList<OnNoDisturbComponentListener> mListeners;
    private final NoDisturbComponent$mObserver$1 mObserver;
    private final ArrayList<OnStatusMsgChangedListener> mStatusMsgChangedListener;
    private final ArrayList<OnWatchModeChangedListener> mWatchModeChangedListener;

    /* JADX INFO: compiled from: NoDisturbComponent.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/dw/launcher/data/component/NoDisturbComponent$OnAppLockChangedListener;", BuildConfig.FLAVOR, "onAppLockChanged", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnAppLockChangedListener {
        void onAppLockChanged();
    }

    /* JADX INFO: compiled from: NoDisturbComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/data/component/NoDisturbComponent$OnDialBubbleChangedListener;", BuildConfig.FLAVOR, "onDialBubbleChanged", BuildConfig.FLAVOR, "mode", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnDialBubbleChangedListener {
        void onDialBubbleChanged(int mode);
    }

    /* JADX INFO: compiled from: NoDisturbComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/data/component/NoDisturbComponent$OnNoDisturbComponentListener;", BuildConfig.FLAVOR, "onNoDisturbChanged", BuildConfig.FLAVOR, NotificationCompat.CATEGORY_STATUS, BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnNoDisturbComponentListener {
        void onNoDisturbChanged(int status);
    }

    /* JADX INFO: compiled from: NoDisturbComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/data/component/NoDisturbComponent$OnStatusMsgChangedListener;", BuildConfig.FLAVOR, "onStatusMsgChanged", BuildConfig.FLAVOR, "mode", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnStatusMsgChangedListener {
        void onStatusMsgChanged(int mode);
    }

    /* JADX INFO: compiled from: NoDisturbComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/data/component/NoDisturbComponent$OnWatchModeChangedListener;", BuildConfig.FLAVOR, "onWatchModeChanged", BuildConfig.FLAVOR, "mode", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnWatchModeChangedListener {
        void onWatchModeChanged(int mode);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.dw.launcher.data.component.NoDisturbComponent$mObserver$1] */
    @Inject
    public NoDisturbComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mListeners = new ArrayList<>();
        this.mAppLocakListeners = new ArrayList<>();
        this.mStatusMsgChangedListener = new ArrayList<>();
        this.mWatchModeChangedListener = new ArrayList<>();
        this.mDialBubbleChangedListener = new ArrayList<>();
        final Handler handler = new Handler(Looper.getMainLooper());
        this.mHandler = handler;
        this.mObserver = new ContentObserver(handler) { // from class: com.dw.launcher.data.component.NoDisturbComponent$mObserver$1
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                super.onChange(selfChange);
                Log.i("NoDisturbComponent", "onChange: " + uri + " lastPathSegment: " + (uri != null ? uri.getLastPathSegment() : null));
                if (Uri.parse("content://com.watch.appmanager/applock").equals(uri)) {
                    Iterator it = this.this$0.mAppLocakListeners.iterator();
                    while (it.hasNext()) {
                        ((NoDisturbComponent.OnAppLockChangedListener) it.next()).onAppLockChanged();
                    }
                }
                String lastPathSegment = uri != null ? uri.getLastPathSegment() : null;
                if (lastPathSegment != null) {
                    switch (lastPathSegment.hashCode()) {
                        case -100083949:
                            if (lastPathSegment.equals(NoDisturbComponent.WATCH_MODE)) {
                                int i = Settings.Global.getInt(this.this$0.getContext().getContentResolver(), NoDisturbComponent.WATCH_MODE, 0);
                                Iterator it2 = this.this$0.mWatchModeChangedListener.iterator();
                                while (it2.hasNext()) {
                                    ((NoDisturbComponent.OnWatchModeChangedListener) it2.next()).onWatchModeChanged(i);
                                }
                                break;
                            }
                            break;
                        case 829518209:
                            if (lastPathSegment.equals(NoDisturbActivity.SETTING_KEY_SILENT_MODE) && !Launcher.Companion.getMLoading()) {
                                int i2 = Settings.Global.getInt(this.this$0.getContext().getContentResolver(), NoDisturbActivity.SETTING_KEY_SILENT_MODE, 0);
                                Timber.Forest.d("NoDisturbComponent: " + i2, new Object[0]);
                                if (i2 == 1 && this.this$0.mListeners.size() > 0) {
                                    this.this$0.killAllApps();
                                    Iterator it3 = this.this$0.mListeners.iterator();
                                    while (it3.hasNext()) {
                                        ((NoDisturbComponent.OnNoDisturbComponentListener) it3.next()).onNoDisturbChanged(i2);
                                    }
                                    break;
                                }
                            }
                            break;
                        case 1496745931:
                            if (lastPathSegment.equals(NoDisturbComponent.SUPPORT_DIAL_BUBBLE)) {
                                int i3 = Settings.Global.getInt(this.this$0.getContext().getContentResolver(), NoDisturbComponent.SUPPORT_DIAL_BUBBLE, 0);
                                Iterator it4 = this.this$0.mDialBubbleChangedListener.iterator();
                                while (it4.hasNext()) {
                                    ((NoDisturbComponent.OnDialBubbleChangedListener) it4.next()).onDialBubbleChanged(i3);
                                }
                                break;
                            }
                            break;
                        case 2139659558:
                            if (lastPathSegment.equals(NoDisturbComponent.DOWN_MENU_MODE)) {
                                int i4 = Settings.System.getInt(this.this$0.getContext().getContentResolver(), NoDisturbComponent.DOWN_MENU_MODE, 0);
                                Iterator it5 = this.this$0.mStatusMsgChangedListener.iterator();
                                while (it5.hasNext()) {
                                    ((NoDisturbComponent.OnStatusMsgChangedListener) it5.next()).onStatusMsgChanged(i4);
                                }
                                break;
                            }
                            break;
                    }
                }
            }
        };
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void killAllApps() {
        this.context.sendBroadcast(new Intent("android.intent.action.alarm_kill_apps"));
    }

    public final void register() {
        ContentResolver contentResolver;
        ContentResolver contentResolver2;
        ContentResolver contentResolver3;
        ContentResolver contentResolver4;
        ContentResolver contentResolver5;
        Context context = this.context;
        if (context != null && (contentResolver5 = context.getContentResolver()) != null) {
            contentResolver5.registerContentObserver(Settings.Global.getUriFor(NoDisturbActivity.SETTING_KEY_SILENT_MODE), false, this.mObserver);
        }
        try {
            Context context2 = this.context;
            if (context2 != null && (contentResolver4 = context2.getContentResolver()) != null) {
                contentResolver4.registerContentObserver(Uri.parse("content://com.watch.appmanager/applock"), true, this.mObserver);
            }
        } catch (Exception unused) {
        }
        try {
            Context context3 = this.context;
            if (context3 != null && (contentResolver3 = context3.getContentResolver()) != null) {
                contentResolver3.registerContentObserver(Settings.System.getUriFor(DOWN_MENU_MODE), false, this.mObserver);
            }
        } catch (Exception unused2) {
        }
        try {
            Context context4 = this.context;
            if (context4 != null && (contentResolver2 = context4.getContentResolver()) != null) {
                contentResolver2.registerContentObserver(Settings.Global.getUriFor(WATCH_MODE), false, this.mObserver);
            }
        } catch (Exception unused3) {
        }
        try {
            Context context5 = this.context;
            if (context5 == null || (contentResolver = context5.getContentResolver()) == null) {
                return;
            }
            contentResolver.registerContentObserver(Settings.Global.getUriFor(SUPPORT_DIAL_BUBBLE), false, this.mObserver);
        } catch (Exception unused4) {
        }
    }

    public final void unregister() {
        ContentResolver contentResolver;
        Context context = this.context;
        if (context == null || (contentResolver = context.getContentResolver()) == null) {
            return;
        }
        contentResolver.unregisterContentObserver(this.mObserver);
    }

    public final void addListener(OnNoDisturbComponentListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListeners.add(listener);
    }

    public final void removeListener(OnNoDisturbComponentListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListeners.remove(listener);
    }

    public final void addAppLockListener(OnAppLockChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mAppLocakListeners.add(listener);
    }

    public final void removeAppLockListener(OnAppLockChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mAppLocakListeners.remove(listener);
    }

    public final void addStatusMsgChangedListener(OnStatusMsgChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mStatusMsgChangedListener.add(listener);
    }

    public final void removeStatusMsgChangedListener(OnStatusMsgChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mStatusMsgChangedListener.remove(listener);
    }

    public final void addWatchModeChangedListener(OnWatchModeChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mWatchModeChangedListener.add(listener);
    }

    public final void removeWatchModeChangedListener(OnWatchModeChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mWatchModeChangedListener.remove(listener);
    }

    public final void addDialBubbleChangedListener(OnDialBubbleChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mDialBubbleChangedListener.add(listener);
    }

    public final void removeDialBubbleChangedListener(OnDialBubbleChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mDialBubbleChangedListener.remove(listener);
    }
}
