package com.dw.launcher.data.entity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.google.gson.annotations.Expose;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecentTask.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/dw/launcher/data/entity/RecentTask;", BuildConfig.FLAVOR, "packageName", BuildConfig.FLAVOR, "className", "intent", "Landroid/content/Intent;", "icon", "Landroid/graphics/drawable/Drawable;", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Landroid/graphics/drawable/Drawable;)V", "getClassName", "()Ljava/lang/String;", "getPackageName", "loadIcon", "context", "Landroid/content/Context;", "onClicked", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecentTask {

    @Expose
    private final String className;
    private final Drawable icon;
    private final Intent intent;

    @Expose
    private final String packageName;

    public RecentTask(String str, String str2, Intent intent, Drawable drawable) {
        Intrinsics.checkNotNullParameter(str, "packageName");
        Intrinsics.checkNotNullParameter(str2, "className");
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.packageName = str;
        this.className = str2;
        this.intent = intent;
        this.icon = drawable;
    }

    public /* synthetic */ RecentTask(String str, String str2, Intent intent, Drawable drawable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, intent, (i & 8) != 0 ? null : drawable);
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getClassName() {
        return this.className;
    }

    public final Drawable loadIcon(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = this.icon;
        return drawable != null ? drawable : context.getPackageManager().getActivityIcon(this.intent);
    }

    public final void onClicked(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(this.intent);
        if (this.className != null) {
            intent.setComponent(new ComponentName(this.packageName, this.className));
        }
        intent.addFlags(270532608);
        context.startActivity(intent);
    }
}
