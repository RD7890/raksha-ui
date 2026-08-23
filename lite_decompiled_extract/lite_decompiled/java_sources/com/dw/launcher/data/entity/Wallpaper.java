package com.dw.launcher.data.entity;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Wallpaper.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/dw/launcher/data/entity/Wallpaper;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "path", "type", BuildConfig.FLAVOR, "fromSystemPath", BuildConfig.FLAVOR, "(Ljava/lang/String;Ljava/lang/String;IZ)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPath", "setPath", "getType", "()I", "setType", "(I)V", "uri", "getUri", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Wallpaper {
    private String name;
    private String path;
    private int type;
    private final String uri;

    public Wallpaper(String str, String str2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "path");
        this.name = str;
        this.path = str2;
        this.type = i;
        this.uri = z ? str2 : "file:///android_asset/" + this.path;
    }

    public /* synthetic */ Wallpaper(String str, String str2, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? false : z);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final String getUri() {
        return this.uri;
    }

    public String toString() {
        return "Wallpaper(name='" + this.name + "', uri='" + this.uri + "')";
    }
}
