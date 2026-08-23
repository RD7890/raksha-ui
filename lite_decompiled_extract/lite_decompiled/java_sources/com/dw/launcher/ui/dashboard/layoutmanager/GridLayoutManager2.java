package com.dw.launcher.ui.dashboard.layoutmanager;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridLayoutManager2.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/GridLayoutManager2;", "Landroidx/recyclerview/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "orientation", "reverseLayout", "", "pageCount", "(Landroid/content/Context;IIZI)V", "screenHeight", "screenWidth", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class GridLayoutManager2 extends GridLayoutManager {
    private int pageCount;
    private int screenHeight;
    private int screenWidth;

    public /* synthetic */ GridLayoutManager2(Context context, int i, int i2, boolean z, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, i2, z, (i4 & 16) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridLayoutManager2(Context context, int i, int i2, boolean z, int i3) {
        super(context, i, i2, z);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pageCount = i3;
        this.screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        this.screenHeight = context.getResources().getDisplayMetrics().heightPixels;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.pageCount > 0) {
            if (getOrientation() == 0) {
                return new GridLayoutManager.LayoutParams(View.MeasureSpec.makeMeasureSpec(this.screenWidth / this.pageCount, 1073741824), -1);
            }
            return new GridLayoutManager.LayoutParams(-1, View.MeasureSpec.makeMeasureSpec(this.screenHeight / this.pageCount, 1073741824));
        }
        RecyclerView.LayoutParams layoutParamsGenerateDefaultLayoutParams = super.generateDefaultLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParamsGenerateDefaultLayoutParams, "generateDefaultLayoutParams(...)");
        return layoutParamsGenerateDefaultLayoutParams;
    }
}
