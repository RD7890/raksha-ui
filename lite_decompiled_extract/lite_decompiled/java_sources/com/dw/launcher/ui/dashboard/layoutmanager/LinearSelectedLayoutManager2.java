package com.dw.launcher.ui.dashboard.layoutmanager;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.dw.launcher.ui.dashboard.transformation.LinearSelectedTransformation;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: LinearSelectedLayoutManager2.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0002J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fR\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J(\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J(\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/LinearSelectedLayoutManager2;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "minScale", "", "transformation", "Lcom/dw/launcher/ui/dashboard/transformation/LinearSelectedTransformation;", "(Landroid/content/Context;FLcom/dw/launcher/ui/dashboard/transformation/LinearSelectedTransformation;)V", "findFirstVisiblePosition", "", "getSelectedPosition", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollVerticallyBy", "dy", "smoothScrollToPosition", "recyclerView", "position", "transformChildren", "transformChildren2", "Companion", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class LinearSelectedLayoutManager2 extends LinearLayoutManager {
    public static final boolean DEBUG = true;
    public static final String TAG = "LinearSelectedLayout";
    private final float minScale;
    private final LinearSelectedTransformation transformation;

    public /* synthetic */ LinearSelectedLayoutManager2(Context context, float f, LinearSelectedTransformation linearSelectedTransformation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? 0.6f : f, (i & 4) != 0 ? null : linearSelectedTransformation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinearSelectedLayoutManager2(Context context, float f, LinearSelectedTransformation linearSelectedTransformation) {
        super(context, 1, false);
        Intrinsics.checkNotNullParameter(context, "context");
        this.minScale = f;
        this.transformation = linearSelectedTransformation;
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onLayoutChildren(recycler, state);
        transformChildren2();
    }

    private final void transformChildren() {
        int selectedPosition = getSelectedPosition();
        float f = 1;
        float f2 = (f - this.minScale) / selectedPosition;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            float fAbs = f - (Math.abs(i - selectedPosition) * f2);
            if (i != selectedPosition) {
                childAt.setSelected(false);
                if (childAt.hasFocus()) {
                    childAt.clearFocus();
                }
            } else {
                childAt.setSelected(true);
                childAt.requestFocus();
            }
            LinearSelectedTransformation linearSelectedTransformation = this.transformation;
            if (linearSelectedTransformation != null) {
                linearSelectedTransformation.onChildScale(childAt, fAbs);
            }
        }
    }

    private final void transformChildren2() {
        int selectedPosition = getSelectedPosition();
        float height = getHeight() / 2.0f;
        float f = (1 - this.minScale) / height;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            float fAbs = 1.1f - (Math.abs((getDecoratedBottom(childAt) - (childAt.getHeight() / 2)) - height) * f);
            if (i != selectedPosition) {
                childAt.setSelected(false);
                if (childAt.hasFocus()) {
                    childAt.clearFocus();
                }
            } else {
                childAt.setSelected(true);
                childAt.requestFocus();
            }
            childAt.setScaleX(fAbs);
            childAt.setTranslationX(-(childAt.getHeight() - (childAt.getHeight() * fAbs)));
            Timber.INSTANCE.d(" childScale:" + fAbs + "  translationX:" + childAt.getTranslationX() + "  height:" + childAt.getHeight() + ' ', new Object[0]);
            childAt.setScaleY(fAbs);
        }
    }

    private final int getSelectedPosition() {
        int height = getHeight() / 2;
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Intrinsics.checkNotNull(childAt);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(childAt);
            if ((decoratedMeasuredHeight / 2) + paddingTop >= height) {
                return i2;
            }
            paddingTop += decoratedMeasuredHeight;
            i = i2;
        }
        return i;
    }

    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int iScrollHorizontallyBy = super.scrollHorizontallyBy(dx, recycler, state);
        transformChildren2();
        return iScrollHorizontallyBy;
    }

    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int iScrollVerticallyBy = super.scrollVerticallyBy(dy, recycler, state);
        transformChildren2();
        return iScrollVerticallyBy;
    }

    public final int findFirstVisiblePosition() {
        if (getChildCount() <= 0) {
            return 0;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            Timber.INSTANCE.e("getDecoratedBottom:" + getDecoratedBottom(childAt) + "  position:" + getPosition(childAt) + " height:" + childAt.getHeight() + " & firstVibilePos :" + findFirstVisibleItemPosition(), new Object[0]);
            if (getDecoratedBottom(childAt) > childAt.getHeight() / 3) {
                return getPosition(childAt);
            }
        }
        return 0;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, final int position) {
        final int iFindFirstVisiblePosition = findFirstVisiblePosition();
        int iMax = Math.max(Math.min(iFindFirstVisiblePosition + position, getItemCount() - 1), 0);
        Timber.INSTANCE.d(" first: " + iFindFirstVisiblePosition + ", targetPosition:" + iMax + " position:" + position, new Object[0]);
        Intrinsics.checkNotNull(recyclerView);
        RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.dw.launcher.ui.dashboard.layoutmanager.LinearSelectedLayoutManager2.smoothScrollToPosition.1
            public PointF computeScrollVectorForPosition(int targetPosition) {
                return super.computeScrollVectorForPosition(targetPosition);
            }

            protected void onTargetFound(View targetView, RecyclerView.State state2, RecyclerView.SmoothScroller.Action action) {
                Intrinsics.checkNotNullParameter(targetView, "targetView");
                Intrinsics.checkNotNullParameter(state2, "state");
                Intrinsics.checkNotNullParameter(action, "action");
                int position2 = LinearSelectedLayoutManager2.this.getPosition(targetView);
                int iFindFirstVisiblePosition2 = LinearSelectedLayoutManager2.this.findFirstVisiblePosition();
                if (iFindFirstVisiblePosition2 == position2 && iFindFirstVisiblePosition2 != iFindFirstVisiblePosition) {
                    iFindFirstVisiblePosition2 = position > 0 ? iFindFirstVisiblePosition2 - 1 : iFindFirstVisiblePosition2 + 1;
                }
                View childAt = LinearSelectedLayoutManager2.this.getChildAt(0);
                Intrinsics.checkNotNull(childAt);
                int height = (position2 - iFindFirstVisiblePosition2) * childAt.getHeight();
                int iCalculateTimeForScrolling = calculateTimeForScrolling(Math.abs(height));
                Timber.INSTANCE.e(" dy:" + height + ", time:" + iCalculateTimeForScrolling + " tempfirst:" + iFindFirstVisiblePosition2 + " targetPos: " + position2 + ' ', new Object[0]);
                if (iCalculateTimeForScrolling > 0) {
                    action.update(0, height, iCalculateTimeForScrolling, new DecelerateInterpolator());
                }
            }

            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                float f;
                float f2;
                Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
                if (Math.abs(position) >= 3) {
                    f = displayMetrics.densityDpi;
                    f2 = 200.0f;
                } else {
                    f = displayMetrics.densityDpi;
                    f2 = 400.0f;
                }
                return f2 / f;
            }
        };
        smoothScroller.setTargetPosition(iMax);
        startSmoothScroll(smoothScroller);
    }
}
