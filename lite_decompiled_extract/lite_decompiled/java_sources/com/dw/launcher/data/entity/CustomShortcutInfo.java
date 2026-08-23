package com.dw.launcher.data.entity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomShortcutInfo.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\b\u0010\"\u001a\u00020\u0003H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006#"}, d2 = {"Lcom/dw/launcher/data/entity/CustomShortcutInfo;", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "label", "intent", "Landroid/content/Intent;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Landroid/graphics/drawable/Drawable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "getLabel", "setLabel", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class CustomShortcutInfo {
    private Drawable drawable;
    private String id;
    private Intent intent;
    private String label;

    public CustomShortcutInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CustomShortcutInfo copy$default(CustomShortcutInfo customShortcutInfo, String str, String str2, Intent intent, Drawable drawable, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customShortcutInfo.id;
        }
        if ((i & 2) != 0) {
            str2 = customShortcutInfo.label;
        }
        if ((i & 4) != 0) {
            intent = customShortcutInfo.intent;
        }
        if ((i & 8) != 0) {
            drawable = customShortcutInfo.drawable;
        }
        return customShortcutInfo.copy(str, str2, intent, drawable);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Intent getIntent() {
        return this.intent;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Drawable getDrawable() {
        return this.drawable;
    }

    public final CustomShortcutInfo copy(String id, String label, Intent intent, Drawable drawable) {
        return new CustomShortcutInfo(id, label, intent, drawable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomShortcutInfo)) {
            return false;
        }
        CustomShortcutInfo customShortcutInfo = (CustomShortcutInfo) other;
        return Intrinsics.areEqual(this.id, customShortcutInfo.id) && Intrinsics.areEqual(this.label, customShortcutInfo.label) && Intrinsics.areEqual(this.intent, customShortcutInfo.intent) && Intrinsics.areEqual(this.drawable, customShortcutInfo.drawable);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.label;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Intent intent = this.intent;
        int iHashCode3 = (iHashCode2 + (intent == null ? 0 : intent.hashCode())) * 31;
        Drawable drawable = this.drawable;
        return iHashCode3 + (drawable != null ? drawable.hashCode() : 0);
    }

    public CustomShortcutInfo(String str, String str2, Intent intent, Drawable drawable) {
        this.id = str;
        this.label = str2;
        this.intent = intent;
        this.drawable = drawable;
    }

    public /* synthetic */ CustomShortcutInfo(String str, String str2, Intent intent, Drawable drawable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : intent, (i & 8) != 0 ? null : drawable);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(String str) {
        this.label = str;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final void setIntent(Intent intent) {
        this.intent = intent;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public final void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String toString() {
        return "CustomShortcutInfo(id='" + this.id + "', label='" + this.label + "', intent=" + this.intent + ", drawable=" + this.drawable + ')';
    }
}
