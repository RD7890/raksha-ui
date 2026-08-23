package com.dw.launcher.ui.dashboard.layoutmanager.config;

import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: PagerConfig.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\bJ\b\u0010\u0011\u001a\u00020\nH\u0002J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/config/PagerConfig;", "", "()V", "TAG", "", "sFlingThreshold", "", "sMillisecondsPreInch", "", "sShowLog", "", "Loge", "", "msg", "Logi", "getFlingThreshold", "getMillisecondsPreInch", "isShowLog", "setFlingThreshold", "flingThreshold", "setMillisecondsPreInch", "millisecondsPreInch", "setShowLog", "showLog", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class PagerConfig {
    private static final String TAG = "PagerGrid";
    private static boolean sShowLog;
    public static final PagerConfig INSTANCE = new PagerConfig();
    private static int sFlingThreshold = CharacterSets.UCS2;
    private static float sMillisecondsPreInch = 150.0f;

    private PagerConfig() {
    }

    private final boolean isShowLog() {
        return sShowLog;
    }

    public final void setShowLog(boolean showLog) {
        sShowLog = showLog;
    }

    public final int getFlingThreshold() {
        return sFlingThreshold;
    }

    public final void setFlingThreshold(int flingThreshold) {
        sFlingThreshold = flingThreshold;
    }

    public final float getMillisecondsPreInch() {
        return sMillisecondsPreInch;
    }

    public final void setMillisecondsPreInch(float millisecondsPreInch) {
        sMillisecondsPreInch = millisecondsPreInch;
    }

    public final void Logi(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isShowLog()) {
            Timber.INSTANCE.tag(TAG).i(msg, new Object[0]);
        }
    }

    public final void Loge(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isShowLog()) {
            Timber.INSTANCE.tag(TAG).e(msg, new Object[0]);
        }
    }
}
