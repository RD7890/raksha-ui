package com.dw.launcher.ui.dashboard.layoutmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.dw.launcher.ui.dashboard.util.HoneyCombCalculator2;
import com.dw.launcher.util.SystemProperties;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

/* JADX INFO: compiled from: HoneycombLayoutManager2.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 G2\u00020\u0001:\u0002GHB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010*\u001a\u00020\u000bH\u0016J\b\u0010+\u001a\u00020\u000bH\u0016J\u0006\u0010,\u001a\u00020-J\u0014\u0010.\u001a\u00020/2\n\u00100\u001a\u000601R\u000202H\u0002J\n\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u000206H\u0016J\u001c\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u00010\u00032\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010;\u001a\u00020/2\b\u0010<\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010=\u001a\u00020/2\u0006\u0010>\u001a\u000202H\u0016J\u001c\u0010?\u001a\u00020/2\n\u00100\u001a\u000601R\u0002022\u0006\u0010@\u001a\u00020AH\u0016J\u0012\u0010B\u001a\u00020/2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J$\u0010C\u001a\u00020#2\u0006\u0010D\u001a\u00020#2\n\u00100\u001a\u000601R\u0002022\u0006\u0010@\u001a\u00020AH\u0016J$\u0010E\u001a\u00020#2\u0006\u0010F\u001a\u00020#2\n\u00100\u001a\u000601R\u0002022\u0006\u0010@\u001a\u00020AH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u000e\u0010 \u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/HoneycombLayoutManager2;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "listener", "Lcom/dw/launcher/ui/dashboard/layoutmanager/HoneycombLayoutManager2$OnItemSelectedListener;", "(Landroid/content/Context;Lcom/dw/launcher/ui/dashboard/layoutmanager/HoneycombLayoutManager2$OnItemSelectedListener;)V", "DEFAULT_HEX_RADIUS", "", "DEFAULT_SPHERE_RADIUS", "addFootView", "", "getAddFootView", "()Z", "setAddFootView", "(Z)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "mCalculator", "Lcom/dw/launcher/ui/dashboard/util/HoneyCombCalculator2;", "mDeltaX", "getMDeltaX", "()F", "setMDeltaX", "(F)V", "mDeltaY", "getMDeltaY", "setMDeltaY", "mDimens", "mDirtyLayoutParams", "mEdge", "", "mFilling", "mFirstLayout", "mHandler", "mHexRadius", "mScale", "mSphereRadius", "canScrollHorizontally", "canScrollVertically", "claulateToCenterDistance", "", "fill", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "findSelectChild", "Landroid/view/View;", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "generateLayoutParams", "c", "attrs", "Landroid/util/AttributeSet;", "onAttachedToWindow", "view", "onItemsChanged", "recyclerView", "onLayoutChildren", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onLayoutCompleted", "scrollHorizontallyBy", "dx", "scrollVerticallyBy", "dy", "Companion", "OnItemSelectedListener", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class HoneycombLayoutManager2 extends RecyclerView.LayoutManager {
    public static final float MAX_SCALE = 1.8f;
    private final float DEFAULT_HEX_RADIUS;
    private final float DEFAULT_SPHERE_RADIUS;
    private boolean addFootView;
    private final Context context;
    private Handler handler;
    private final OnItemSelectedListener listener;
    private HoneyCombCalculator2 mCalculator;
    private float mDeltaX;
    private float mDeltaY;
    private final float mDimens;
    private boolean mDirtyLayoutParams;
    private int mEdge;
    private boolean mFilling;
    private boolean mFirstLayout;
    private final Handler mHandler;
    private float mHexRadius;
    private float mScale;
    private float mSphereRadius;

    /* JADX INFO: compiled from: HoneycombLayoutManager2.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/HoneycombLayoutManager2$OnItemSelectedListener;", "", "onItemSelected", "", "position", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public interface OnItemSelectedListener {
        void onItemSelected(int position);
    }

    public boolean canScrollHorizontally() {
        return true;
    }

    public boolean canScrollVertically() {
        return true;
    }

    public HoneycombLayoutManager2(Context context, OnItemSelectedListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.context = context;
        this.listener = listener;
        this.mHandler = new Handler(Looper.getMainLooper());
        float f = context.getResources().getDisplayMetrics().density;
        this.mDimens = f;
        this.mEdge = (int) (20 * f);
        float f2 = PduHeaders.RECOMMENDED_RETRIEVAL_MODE * f;
        this.DEFAULT_SPHERE_RADIUS = f2;
        float f3 = f * 100;
        this.DEFAULT_HEX_RADIUS = f3;
        this.mSphereRadius = f2;
        this.mHexRadius = f3;
        this.handler = new Handler(Looper.getMainLooper());
        this.mScale = 1.0f;
        this.mFirstLayout = true;
        this.mHexRadius = SystemProperties.INSTANCE.getInt("ro.dw.launcher_hex_r", (int) f3);
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final void setHandler(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.handler = handler;
    }

    public final boolean getAddFootView() {
        return this.addFootView;
    }

    public final void setAddFootView(boolean z) {
        this.addFootView = z;
    }

    public void onAttachedToWindow(RecyclerView view) {
        super.onAttachedToWindow(view);
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) this.mHexRadius, 1073741824);
        return new RecyclerView.LayoutParams(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context c, AttributeSet attrs) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) this.mHexRadius, 1073741824);
        return new RecyclerView.LayoutParams(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onItemsChanged(recyclerView);
        Timber.INSTANCE.i("onItemsChanged", new Object[0]);
        HoneyCombCalculator2 honeyCombCalculator2 = this.mCalculator;
        if (honeyCombCalculator2 != null) {
            honeyCombCalculator2.initPosition(getItemCount(), 3);
        }
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        Timber.INSTANCE.i("onLayoutChildren itemCount: " + getItemCount(), new Object[0]);
        if (getItemCount() <= 0) {
            detachAndScrapAttachedViews(recycler);
            return;
        }
        if (this.mDirtyLayoutParams) {
            removeAndRecycleAllViews(recycler);
            this.mDirtyLayoutParams = false;
        }
        if (this.mCalculator == null) {
            this.mCalculator = new HoneyCombCalculator2(getWidth(), getHeight(), this.mSphereRadius, this.mHexRadius, this.mEdge);
        }
        HoneyCombCalculator2 honeyCombCalculator2 = this.mCalculator;
        if (honeyCombCalculator2 != null) {
            if (honeyCombCalculator2.size() < getItemCount()) {
                honeyCombCalculator2.initPosition(getItemCount(), 3);
            }
            Timber.INSTANCE.d("transform, " + (-this.mDeltaX) + ", " + (-this.mDeltaY), new Object[0]);
            honeyCombCalculator2.transform(-this.mDeltaX, -this.mDeltaY);
            fill(recycler);
        }
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        Timber.INSTANCE.i("onLayoutCompleted", new Object[0]);
        this.mFirstLayout = false;
        if (this.mScale >= 1.8f) {
            View viewFindSelectChild = findSelectChild();
            if (viewFindSelectChild != null) {
                this.listener.onItemSelected(getPosition(viewFindSelectChild));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.dw.launcher.ui.dashboard.layoutmanager.HoneycombLayoutManager2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    HoneycombLayoutManager2.onLayoutCompleted$lambda$2(this.f$0);
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLayoutCompleted$lambda$2(HoneycombLayoutManager2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mScale == 1.0f) {
            return;
        }
        this$0.mScale = 1.0f;
        float f = this$0.DEFAULT_HEX_RADIUS;
        this$0.mHexRadius = f;
        HoneyCombCalculator2 honeyCombCalculator2 = this$0.mCalculator;
        if (honeyCombCalculator2 != null) {
            honeyCombCalculator2.setHexR(f);
        }
        this$0.mDeltaX = 0.0f;
        this$0.mDeltaY = 0.0f;
        this$0.requestLayout();
    }

    private final void fill(RecyclerView.Recycler recycler) {
        this.mFilling = true;
        detachAndScrapAttachedViews(recycler);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        float f = this.mHexRadius;
        int itemCount = this.addFootView ? getItemCount() - 1 : getItemCount();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < itemCount) {
            HoneyCombCalculator2 honeyCombCalculator2 = this.mCalculator;
            Intrinsics.checkNotNull(honeyCombCalculator2);
            HoneyCombCalculator2.Position positionAt = honeyCombCalculator2.getPositionAt(i3);
            float f2 = ((-getHeight()) / 2.0f) - f;
            float height2 = (getHeight() / 2.0f) + f;
            float y = positionAt.getY();
            if (f2 <= y && y <= height2) {
                View viewForPosition = recycler.getViewForPosition(i3);
                Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
                addView(viewForPosition);
                measureChild(viewForPosition, i, i);
                int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                float f3 = decoratedMeasuredWidth / 2;
                int x = ((int) (positionAt.getX() - f3)) + width;
                int y2 = ((int) (positionAt.getY() - (decoratedMeasuredHeight / 2))) + height;
                int i4 = y2 + decoratedMeasuredHeight;
                layoutDecorated(viewForPosition, x, y2, x + decoratedMeasuredWidth, i4);
                if (x < 0) {
                    float fCoerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(positionAt.getX() + width, (f3 * positionAt.getScale()) * this.mScale) * 2, 0.0f) / decoratedMeasuredWidth;
                    viewForPosition.setScaleX(fCoerceAtLeast);
                    viewForPosition.setScaleY(fCoerceAtLeast);
                } else if (x + viewForPosition.getWidth() > getWidth()) {
                    float fCoerceAtLeast2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost((getWidth() - positionAt.getX()) - width, (f3 * positionAt.getScale()) * this.mScale) * 2, 0.0f) / decoratedMeasuredWidth;
                    viewForPosition.setScaleX(fCoerceAtLeast2);
                    viewForPosition.setScaleY(fCoerceAtLeast2);
                } else {
                    viewForPosition.setScaleX(positionAt.getScale() * this.mScale);
                    viewForPosition.setScaleY(positionAt.getScale() * this.mScale);
                }
                i2 = i4;
            }
            i3++;
            i = 0;
        }
        if (this.addFootView && getItemCount() > 1) {
            View viewForPosition2 = recycler.getViewForPosition(getItemCount() - 1);
            Intrinsics.checkNotNullExpressionValue(viewForPosition2, "getViewForPosition(...)");
            addView(viewForPosition2);
            measureChildWithMargins(viewForPosition2, 0, 0);
            layoutDecorated(viewForPosition2, 0, i2, getDecoratedMeasuredWidth(viewForPosition2), i2 + getDecoratedMeasuredHeight(viewForPosition2));
        }
        this.mFilling = false;
    }

    public final float getMDeltaX() {
        return this.mDeltaX;
    }

    public final void setMDeltaX(float f) {
        this.mDeltaX = f;
    }

    public final float getMDeltaY() {
        return this.mDeltaY;
    }

    public final void setMDeltaY(float f) {
        this.mDeltaY = f;
    }

    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (getChildCount() > 0) {
            int height = getHeight() / 2;
            int childCount = this.addFootView ? getChildCount() - 1 : getChildCount();
            int iCoerceAtMost = height;
            int iCoerceAtLeast = iCoerceAtMost;
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                Intrinsics.checkNotNull(childAt);
                iCoerceAtMost = RangesKt.coerceAtMost(iCoerceAtMost, childAt.getTop());
                iCoerceAtLeast = RangesKt.coerceAtLeast(iCoerceAtLeast, childAt.getBottom());
            }
            if ((dy > 0 && iCoerceAtLeast > 0 && iCoerceAtLeast < height + (this.mHexRadius / 2)) || (dy < 0 && iCoerceAtMost > this.mHexRadius / 4)) {
                dy = 0;
            }
            if (getChildCount() > 0) {
                float f = this.mDeltaY + dy;
                this.mDeltaY = f;
                HoneyCombCalculator2 honeyCombCalculator2 = this.mCalculator;
                if (honeyCombCalculator2 != null) {
                    honeyCombCalculator2.transform(-this.mDeltaX, -f);
                    fill(recycler);
                }
            }
        }
        return dy;
    }

    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (getChildCount() > 0) {
            float f = this.mDeltaX;
            float f2 = dx;
            float f3 = f + f2;
            float f4 = this.mHexRadius;
            float f5 = 2;
            if (f3 > f4 / f5 || f2 + f < (-f4) / f5) {
                dx = 0;
            }
            float f6 = f + dx;
            this.mDeltaX = f6;
            HoneyCombCalculator2 honeyCombCalculator2 = this.mCalculator;
            if (honeyCombCalculator2 != null) {
                honeyCombCalculator2.transform(-f6, -this.mDeltaY);
                fill(recycler);
            }
        }
        return dx;
    }

    private final View findSelectChild() {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int childCount = getChildCount();
        View view = null;
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Intrinsics.checkNotNull(childAt);
            if (view != null) {
                int left = (childAt.getLeft() + (childAt.getWidth() / 2)) - width;
                int top2 = (childAt.getTop() + (childAt.getHeight() / 2)) - height;
                int i3 = (left * left) + (top2 * top2);
                if (i3 < i) {
                    view = childAt;
                    i = i3;
                }
            } else {
                int left2 = (childAt.getLeft() + (childAt.getWidth() / 2)) - width;
                int top3 = (childAt.getTop() + (childAt.getHeight() / 2)) - height;
                i = (left2 * left2) + (top3 * top3);
                view = childAt;
            }
        }
        return view;
    }

    public final int[] claulateToCenterDistance() {
        Timber.INSTANCE.i("claulatorToCenterDistance mDeltaX = " + this.mDeltaX, new Object[0]);
        int i = -((int) this.mDeltaX);
        int height = getHeight() / 2;
        int childCount = getChildCount();
        int iAbs = 0;
        View view = null;
        int top2 = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Intrinsics.checkNotNull(childAt);
            if (view != null) {
                int top3 = childAt.getTop() + (childAt.getHeight() / 2);
                int iAbs2 = Math.abs(top3 - height);
                if (iAbs2 < iAbs) {
                    iAbs = iAbs2;
                    top2 = top3 - (getHeight() / 2);
                }
            } else {
                view = childAt;
                iAbs = Math.abs((childAt.getTop() + (childAt.getHeight() / 2)) - height);
                top2 = (childAt.getTop() + (childAt.getHeight() / 2)) - (getHeight() / 2);
            }
        }
        return new int[]{i, top2};
    }
}
