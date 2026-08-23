package com.dw.launcher.data.entity;

import android.graphics.drawable.Drawable;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThemeItem.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/dw/launcher/data/entity/ThemeItem;", BuildConfig.FLAVOR, "type", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "preview", "Landroid/graphics/drawable/Drawable;", "path", "(ILjava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getPath", "getPreview", "()Landroid/graphics/drawable/Drawable;", "getType", "()I", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ThemeItem {
    private final String name;
    private final String path;
    private final Drawable preview;
    private final int type;

    public ThemeItem(int i, String str, Drawable drawable, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(drawable, "preview");
        Intrinsics.checkNotNullParameter(str2, "path");
        this.type = i;
        this.name = str;
        this.preview = drawable;
        this.path = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final Drawable getPreview() {
        return this.preview;
    }

    public final int getType() {
        return this.type;
    }
}
