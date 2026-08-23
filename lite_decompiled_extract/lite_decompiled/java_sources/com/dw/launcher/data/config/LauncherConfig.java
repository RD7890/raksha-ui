package com.dw.launcher.data.config;

import android.net.Uri;
import android.provider.Settings;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LauncherConfig.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/dw/launcher/data/config/LauncherConfig;", BuildConfig.FLAVOR, "()V", "CLOCK_KEY", BuildConfig.FLAVOR, "DEFAULT_CLOCK", "getDEFAULT_CLOCK", "()Ljava/lang/String;", "setDEFAULT_CLOCK", "(Ljava/lang/String;)V", "URI_CLOCK_STYLE", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getURI_CLOCK_STYLE", "()Landroid/net/Uri;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LauncherConfig {
    public static final LauncherConfig INSTANCE = new LauncherConfig();
    private static String DEFAULT_CLOCK = "1903";
    public static final String CLOCK_KEY = "launcher_clock_style";
    private static final Uri URI_CLOCK_STYLE = Settings.Global.getUriFor(CLOCK_KEY);

    private LauncherConfig() {
    }

    public final String getDEFAULT_CLOCK() {
        return DEFAULT_CLOCK;
    }

    public final void setDEFAULT_CLOCK(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        DEFAULT_CLOCK = str;
    }

    public final Uri getURI_CLOCK_STYLE() {
        return URI_CLOCK_STYLE;
    }
}
