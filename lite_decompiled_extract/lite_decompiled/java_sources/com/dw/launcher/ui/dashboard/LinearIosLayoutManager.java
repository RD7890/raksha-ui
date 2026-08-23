package com.dw.launcher.ui.dashboard;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LinearIosLayoutManager.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bR\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\bR\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J$\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\bR\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/dw/launcher/ui/dashboard/LinearIosLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scaleChildViews", "", "dy", "scrollVerticallyBy", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class LinearIosLayoutManager extends LinearLayoutManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinearIosLayoutManager(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onLayoutChildren(recycler, state);
        scaleChildViews(0, recycler, state);
    }

    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        return scaleChildViews(dy, recycler, state);
    }

    private final int scaleChildViews(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int childCount;
        int iScrollVerticallyBy = super.scrollVerticallyBy(dy, recycler, state);
        if (getOrientation() != 1 || (childCount = getChildCount()) <= 0) {
            return iScrollVerticallyBy;
        }
        float height = getHeight();
        float f = height / 2.0f;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                float y = childAt.getY() + (childAt.getHeight() / 2.0f);
                float f2 = y - f;
                float fSqrt = ((float) Math.sqrt((height * height) - (f2 * f2))) / height;
                float fAbs = (Math.abs(f - y) / f) * 10.0f;
                childAt.setScaleX(fSqrt);
                childAt.setScaleY(fSqrt);
                childAt.setTranslationX(fAbs);
            }
        }
        return iScrollVerticallyBy;
    }
}
