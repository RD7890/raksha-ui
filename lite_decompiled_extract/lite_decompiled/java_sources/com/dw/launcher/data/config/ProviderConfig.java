package com.dw.launcher.data.config;

import android.net.Uri;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: compiled from: ProviderConfig.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/dw/launcher/data/config/ProviderConfig;", BuildConfig.FLAVOR, "()V", "URI_DASHBOARD_STYLE", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getURI_DASHBOARD_STYLE", "()Landroid/net/Uri;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ProviderConfig {
    public static final ProviderConfig INSTANCE = new ProviderConfig();
    private static final Uri URI_DASHBOARD_STYLE = Uri.parse("content://com.dw.launcher.config/dashboardStyle");

    private ProviderConfig() {
    }

    public final Uri getURI_DASHBOARD_STYLE() {
        return URI_DASHBOARD_STYLE;
    }
}
