package com.dw.launcher.data.entity;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SysKeyEvent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/dw/launcher/data/entity/SysKeyEvent;", BuildConfig.FLAVOR, "DoubleKeyCode", BuildConfig.FLAVOR, "singleKeyCode", BuildConfig.FLAVOR, "UPKey", "DownKey", "(Ljava/lang/String;III)V", "getDoubleKeyCode", "()Ljava/lang/String;", "getDownKey", "()I", "getUPKey", "getSingleKeyCode", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SysKeyEvent {
    private final String DoubleKeyCode;
    private final int DownKey;
    private final int UPKey;
    private final int singleKeyCode;

    public SysKeyEvent(String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "DoubleKeyCode");
        this.DoubleKeyCode = str;
        this.singleKeyCode = i;
        this.UPKey = i2;
        this.DownKey = i3;
    }

    public /* synthetic */ SysKeyEvent(String str, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i4 & 2) != 0 ? 4 : i, (i4 & 4) != 0 ? 19 : i2, (i4 & 8) != 0 ? 20 : i3);
    }

    public final String getDoubleKeyCode() {
        return this.DoubleKeyCode;
    }

    public final int getSingleKeyCode() {
        return this.singleKeyCode;
    }

    public final int getUPKey() {
        return this.UPKey;
    }

    public final int getDownKey() {
        return this.DownKey;
    }
}
