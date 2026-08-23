package com.dw.launcher.core.component;

import android.content.Context;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceStateComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/dw/launcher/core/component/DeviceStateComponent;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isSoundTipAvailable", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceStateComponent {
    private final Context context;

    public final boolean isSoundTipAvailable() {
        return true;
    }

    public DeviceStateComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }
}
