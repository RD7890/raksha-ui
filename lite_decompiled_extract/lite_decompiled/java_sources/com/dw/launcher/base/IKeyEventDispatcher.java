package com.dw.launcher.base;

import android.view.KeyEvent;
import androidx.core.app.NotificationCompat;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IKeyEventDispatcher.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/dw/launcher/base/IKeyEventDispatcher;", BuildConfig.FLAVOR, "onKeyDown", BuildConfig.FLAVOR, "keyCode", BuildConfig.FLAVOR, NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "onKeyLongPress", "onKeyShortcut", "onKeyUp", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IKeyEventDispatcher {

    /* JADX INFO: compiled from: IKeyEventDispatcher.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean onKeyDown(IKeyEventDispatcher iKeyEventDispatcher, int i, KeyEvent keyEvent) {
            Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
            return false;
        }

        public static boolean onKeyLongPress(IKeyEventDispatcher iKeyEventDispatcher, int i, KeyEvent keyEvent) {
            Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
            return false;
        }

        public static boolean onKeyShortcut(IKeyEventDispatcher iKeyEventDispatcher, int i, KeyEvent keyEvent) {
            Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
            return false;
        }

        public static boolean onKeyUp(IKeyEventDispatcher iKeyEventDispatcher, int i, KeyEvent keyEvent) {
            Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
            return false;
        }
    }

    boolean onKeyDown(int keyCode, KeyEvent event);

    boolean onKeyLongPress(int keyCode, KeyEvent event);

    boolean onKeyShortcut(int keyCode, KeyEvent event);

    boolean onKeyUp(int keyCode, KeyEvent event);
}
