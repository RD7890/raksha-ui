package com.dw.launcher.data.entity;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThemeDescribe.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/dw/launcher/data/entity/ThemeDescribe;", BuildConfig.FLAVOR, "type", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "(ILjava/lang/String;)V", "getName", "()Ljava/lang/String;", "getType", "()I", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ThemeDescribe {
    private final String name;
    private final int type;

    public ThemeDescribe(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.type = i;
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    public String toString() {
        return "ThemeDescribe(type=" + this.type + ", name='" + this.name + "')";
    }
}
