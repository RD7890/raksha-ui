package com.dw.launcher.ui.dashboard.layoutmanager;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.dw.launcher.ui.dashboard.util.HoneyCombCalculator;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

/* JADX INFO: compiled from: HoneycombLayoutManager.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 m2\u00020\u0001:\u0002mnB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\bH\u0002J\u000e\u0010K\u001a\u00020I2\u0006\u0010L\u001a\u00020\bJ\b\u0010M\u001a\u00020\u001dH\u0016J\b\u0010N\u001a\u00020\u001dH\u0016J\u0006\u0010O\u001a\u00020PJ\u0014\u0010Q\u001a\u00020I2\n\u0010R\u001a\u00060SR\u00020TH\u0002J\b\u0010U\u001a\u00020\bH\u0002J\n\u0010V\u001a\u0004\u0018\u00010WH\u0002J\b\u0010X\u001a\u00020YH\u0016J\u001c\u0010Z\u001a\u00020Y2\b\u0010[\u001a\u0004\u0018\u00010\u00032\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\u000e\u0010^\u001a\u00020I2\u0006\u0010_\u001a\u00020\bJ\u0012\u0010`\u001a\u00020I2\b\u0010a\u001a\u0004\u0018\u00010TH\u0016J\u0010\u0010b\u001a\u00020I2\u0006\u0010c\u001a\u00020TH\u0016J\u001c\u0010d\u001a\u00020I2\n\u0010R\u001a\u00060SR\u00020T2\u0006\u0010e\u001a\u00020fH\u0016J\u0012\u0010g\u001a\u00020I2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\u0010\u0010h\u001a\u00020I2\u0006\u0010h\u001a\u00020\bH\u0002J$\u0010i\u001a\u00020\u00112\u0006\u0010j\u001a\u00020\u00112\n\u0010R\u001a\u00060SR\u00020T2\u0006\u0010e\u001a\u00020fH\u0016J$\u0010k\u001a\u00020\u00112\u0006\u0010_\u001a\u00020\u00112\n\u0010R\u001a\u00060SR\u00020T2\u0006\u0010e\u001a\u00020fH\u0016J\b\u0010l\u001a\u00020IH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u000e\u00100\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010*\"\u0004\b4\u0010,R\u001a\u00105\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010*\"\u0004\b7\u0010,R\u000e\u00108\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010=\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010*\"\u0004\b?\u0010,R\u000e\u0010@\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010*\"\u0004\bE\u0010,R\u000e\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/HoneycombLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "listener", "Lcom/dw/launcher/ui/dashboard/layoutmanager/HoneycombLayoutManager$OnItemSelectedListener;", "(Landroid/content/Context;Lcom/dw/launcher/ui/dashboard/layoutmanager/HoneycombLayoutManager$OnItemSelectedListener;)V", "DEFAULT_HEX_RADIUS", "", "DEFAULT_SPHERE_RADIUS", "currentTimestamp", "", "getCurrentTimestamp", "()J", "setCurrentTimestamp", "(J)V", "downPointerNumber", "", "getDownPointerNumber", "()I", "setDownPointerNumber", "(I)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "isEdgeClick", "", "isStopAnimate", "()Z", "setStopAnimate", "(Z)V", "mAnimator", "Landroid/animation/ValueAnimator;", "mCalculator", "Lcom/dw/launcher/ui/dashboard/util/HoneyCombCalculator;", "mClickX", "mClickY", "mDeltaX", "getMDeltaX", "()F", "setMDeltaX", "(F)V", "mDeltaY", "getMDeltaY", "setMDeltaY", "mDimens", "mDirtyLayoutParams", "mDownDeltax", "getMDownDeltax", "setMDownDeltax", "mDownDeltay", "getMDownDeltay", "setMDownDeltay", "mEdge", "mFilling", "mFirstLayout", "mHandler", "mHexRadius", "mScale", "getMScale", "setMScale", "mScreenHeight", "mScreenWidth", "mSphereRadius", "mTotalScaleBy", "getMTotalScaleBy", "setMTotalScaleBy", "stopAnimalRunnable", "Ljava/lang/Runnable;", "animateTo", "", "expectScale", "animateToScaleBy", "scaleBy", "canScrollHorizontally", "canScrollVertically", "claulatorToCenterDistance", "", "fill", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "findClosestScale", "findSelectChild", "Landroid/view/View;", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "generateLayoutParams", "c", "attrs", "Landroid/util/AttributeSet;", "moveDiffX", "dy", "onAttachedToWindow", "view", "onItemsChanged", "recyclerView", "onLayoutChildren", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onLayoutCompleted", "scale", "scrollHorizontallyBy", "dx", "scrollVerticallyBy", "stopAnimate", "Companion", "OnItemSelectedListener", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class HoneycombLayoutManager extends RecyclerView.LayoutManager {
    public static final float DEFAULT_SCALE = 1.0f;
    public static final long DURATION = 400;
    public static final float MAX_SCALE = 1.8f;
    public static final float MIN_SCALE = 0.6f;
    public static final float SCALE_STEP = 1.1f;
    public static final String TAG = "BubbleLayoutManager";
    private final float DEFAULT_HEX_RADIUS;
    private final float DEFAULT_SPHERE_RADIUS;
    private long currentTimestamp;
    private int downPointerNumber;
    private Handler handler;
    private boolean isEdgeClick;
    private boolean isStopAnimate;
    private final OnItemSelectedListener listener;
    private ValueAnimator mAnimator;
    private HoneyCombCalculator mCalculator;
    private float mClickX;
    private float mClickY;
    private float mDeltaX;
    private float mDeltaY;
    private final float mDimens;
    private boolean mDirtyLayoutParams;
    private float mDownDeltax;
    private float mDownDeltay;
    private int mEdge;
    private boolean mFilling;
    private boolean mFirstLayout;
    private final Handler mHandler;
    private float mHexRadius;
    private float mScale;
    private int mScreenHeight;
    private int mScreenWidth;
    private float mSphereRadius;
    private float mTotalScaleBy;
    private final Runnable stopAnimalRunnable;

    /* JADX INFO: compiled from: HoneycombLayoutManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/HoneycombLayoutManager$OnItemSelectedListener;", "", "onItemSelected", "", "position", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public interface OnItemSelectedListener {
        void onItemSelected(int position);
    }

    public boolean canScrollHorizontally() {
        return true;
    }

    public boolean canScrollVertically() {
        return true;
    }

    public HoneycombLayoutManager(Context context, OnItemSelectedListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.mHandler = new Handler(Looper.getMainLooper());
        float f = context.getResources().getDisplayMetrics().density;
        this.mDimens = f;
        this.mEdge = (int) (20 * f);
        float f2 = PduHeaders.PREVIOUSLY_SENT_BY * f;
        this.DEFAULT_SPHERE_RADIUS = f2;
        float f3 = f * 80;
        this.DEFAULT_HEX_RADIUS = f3;
        this.mSphereRadius = f2;
        this.mHexRadius = f3;
        this.handler = new Handler(Looper.getMainLooper());
        this.mScale = 1.0f;
        this.mFirstLayout = true;
        this.mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
        this.mScreenHeight = context.getResources().getDisplayMetrics().heightPixels;
        this.stopAnimalRunnable = new Runnable() { // from class: com.dw.launcher.ui.dashboard.layoutmanager.HoneycombLayoutManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                HoneycombLayoutManager.stopAnimalRunnable$lambda$16(this.f$0);
            }
        };
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final void setHandler(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.handler = handler;
    }

    public final float getMScale() {
        return this.mScale;
    }

    public final void setMScale(float f) {
        this.mScale = f;
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
        Log.i("xxx", "onItemsChanged");
        HoneyCombCalculator honeyCombCalculator = this.mCalculator;
        if (honeyCombCalculator != null) {
            honeyCombCalculator.initPosition(getItemCount(), 3);
        }
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        Log.i("xxx", "onLayoutChildren itemCount:" + getItemCount());
        if (getItemCount() <= 0) {
            detachAndScrapAttachedViews(recycler);
            return;
        }
        if (this.mDirtyLayoutParams) {
            removeAndRecycleAllViews(recycler);
            this.mDirtyLayoutParams = false;
        }
        if (this.mCalculator == null) {
            this.mCalculator = new HoneyCombCalculator(getWidth(), getHeight(), this.mSphereRadius, this.mHexRadius, this.mEdge);
        }
        HoneyCombCalculator honeyCombCalculator = this.mCalculator;
        if (honeyCombCalculator != null) {
            if (honeyCombCalculator.size() < getItemCount()) {
                honeyCombCalculator.initPosition(getItemCount(), 3);
            }
            honeyCombCalculator.transform(-this.mDeltaX, -this.mDeltaY);
            fill(recycler);
        }
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        Log.i("xxx", "onLayoutCompleted");
        this.mFirstLayout = false;
        if (this.mScale >= 1.8f) {
            View viewFindSelectChild = findSelectChild();
            if (viewFindSelectChild != null) {
                this.listener.onItemSelected(getPosition(viewFindSelectChild));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.dw.launcher.ui.dashboard.layoutmanager.HoneycombLayoutManager$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    HoneycombLayoutManager.onLayoutCompleted$lambda$2(this.f$0);
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLayoutCompleted$lambda$2(HoneycombLayoutManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mScale == 1.0f) {
            return;
        }
        this$0.mScale = 1.0f;
        float f = this$0.DEFAULT_HEX_RADIUS;
        this$0.mHexRadius = f;
        HoneyCombCalculator honeyCombCalculator = this$0.mCalculator;
        if (honeyCombCalculator != null) {
            honeyCombCalculator.setHexR(f);
        }
        this$0.mDeltaX = 0.0f;
        this$0.mDeltaY = 0.0f;
        this$0.requestLayout();
    }

    private final void fill(RecyclerView.Recycler recycler) {
        this.mFilling = true;
        if (getChildCount() != getItemCount()) {
            Timber.INSTANCE.d("fill childCount =" + getChildCount() + " itemCount: " + getItemCount(), new Object[0]);
            detachAndScrapAttachedViews(recycler);
            int itemCount = getItemCount();
            for (int i = 0; i < itemCount; i++) {
                View viewForPosition = recycler.getViewForPosition(i);
                Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
                addView(viewForPosition);
            }
        }
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int itemCount2 = getItemCount();
        for (int i2 = 0; i2 < itemCount2; i2++) {
            HoneyCombCalculator honeyCombCalculator = this.mCalculator;
            Intrinsics.checkNotNull(honeyCombCalculator);
            HoneyCombCalculator.Position positionAt = honeyCombCalculator.getPositionAt(i2);
            View childAt = getChildAt(i2);
            Intrinsics.checkNotNull(childAt);
            measureChild(childAt, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(childAt);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(childAt);
            int x = ((int) (positionAt.getX() - (decoratedMeasuredWidth / 2))) + width;
            int y = ((int) (positionAt.getY() - (decoratedMeasuredHeight / 2))) + height;
            layoutDecorated(childAt, x, y, x + decoratedMeasuredWidth, y + decoratedMeasuredHeight);
            childAt.setScaleX(positionAt.getScale() * this.mScale);
            childAt.setScaleY(positionAt.getScale() * this.mScale);
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
            int childCount = getChildCount();
            int iCoerceAtLeast = height;
            int iCoerceAtMost = iCoerceAtLeast;
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                Intrinsics.checkNotNull(childAt);
                iCoerceAtMost = RangesKt.coerceAtMost(iCoerceAtMost, childAt.getTop());
                iCoerceAtLeast = RangesKt.coerceAtLeast(iCoerceAtLeast, childAt.getBottom());
            }
            if (iCoerceAtLeast <= 0 || iCoerceAtLeast > height + (this.mHexRadius / 2) ? !(iCoerceAtMost <= 0 || iCoerceAtMost < height - (this.mHexRadius / 2) || dy >= 0) : dy > 0) {
                dy = 0;
            }
            if (getChildCount() > 0) {
                float f = this.mDeltaY + dy;
                this.mDeltaY = f;
                HoneyCombCalculator honeyCombCalculator = this.mCalculator;
                if (honeyCombCalculator != null) {
                    honeyCombCalculator.transform(-this.mDeltaX, -f);
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
            int width = getWidth() / 2;
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
            HoneyCombCalculator honeyCombCalculator = this.mCalculator;
            if (honeyCombCalculator != null) {
                honeyCombCalculator.transform(-f6, -this.mDeltaY);
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

    public final int[] claulatorToCenterDistance() {
        Log.i("xxx", "claulatorToCenterDistance mDeltaX = " + this.mDeltaX);
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

    /* JADX INFO: renamed from: isStopAnimate, reason: from getter */
    public final boolean getIsStopAnimate() {
        return this.isStopAnimate;
    }

    public final void setStopAnimate(boolean z) {
        this.isStopAnimate = z;
    }

    public final float getMTotalScaleBy() {
        return this.mTotalScaleBy;
    }

    public final void setMTotalScaleBy(float f) {
        this.mTotalScaleBy = f;
    }

    public final long getCurrentTimestamp() {
        return this.currentTimestamp;
    }

    public final void setCurrentTimestamp(long j) {
        this.currentTimestamp = j;
    }

    public final void moveDiffX(float dy) {
        this.mDeltaY += dy;
        requestLayout();
    }

    public final void animateToScaleBy(float scaleBy) {
        if (scaleBy == 1.0f) {
            return;
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        final float f = this.mHexRadius / this.DEFAULT_HEX_RADIUS;
        if (f >= 1.98f) {
            stopAnimate();
            return;
        }
        this.mTotalScaleBy += (scaleBy * f) - f;
        this.currentTimestamp = System.currentTimeMillis();
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = f;
        this.handler.removeCallbacks(this.stopAnimalRunnable);
        ValueAnimator duration = ValueAnimator.ofFloat(f, this.mTotalScaleBy + f).setDuration(400L);
        this.mAnimator = duration;
        if (duration != null) {
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.dw.launcher.ui.dashboard.layoutmanager.HoneycombLayoutManager$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    HoneycombLayoutManager.animateToScaleBy$lambda$6(this.f$0, floatRef, valueAnimator2);
                }
            });
        }
        ValueAnimator valueAnimator2 = this.mAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.addListener(new Animator.AnimatorListener(this, this, f) { // from class: com.dw.launcher.ui.dashboard.layoutmanager.HoneycombLayoutManager$animateToScaleBy$$inlined$addListener$1
                final /* synthetic */ float $current$inlined;

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }

                {
                    this.$current$inlined = f;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    if (this.this$0.getIsStopAnimate()) {
                        return;
                    }
                    long jCurrentTimeMillis = 400 - (System.currentTimeMillis() - this.this$0.getCurrentTimestamp());
                    Log.e("BubbleLayoutManager", "onEnd 结束了 isStopAnimate:" + this.this$0.getIsStopAnimate() + " gap:" + jCurrentTimeMillis + ' ');
                    if (jCurrentTimeMillis > 0) {
                        this.this$0.getHandler().postDelayed(this.this$0.stopAnimalRunnable, jCurrentTimeMillis);
                    } else {
                        this.this$0.stopAnimate();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    ValueAnimator valueAnimator3 = this.this$0.mAnimator;
                    Intrinsics.checkNotNull(valueAnimator3);
                    Object animatedValue = valueAnimator3.getAnimatedValue();
                    Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                    this.this$0.scale(((Float) animatedValue).floatValue());
                    Log.e("BubbleLayoutManager", "onCancel 取消了");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    this.this$0.getHandler().removeCallbacks(this.this$0.stopAnimalRunnable);
                    Log.e("BubbleLayoutManager", "onStart 开始 isStopAnimate:" + this.this$0.getIsStopAnimate() + " current:" + this.$current$inlined);
                }
            });
        }
        this.isStopAnimate = false;
        ValueAnimator valueAnimator3 = this.mAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.setInterpolator(new LinearInterpolator());
        }
        ValueAnimator valueAnimator4 = this.mAnimator;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateToScaleBy$lambda$6(HoneycombLayoutManager this$0, Ref.FloatRef lastCurrent, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lastCurrent, "$lastCurrent");
        if (!this$0.isStopAnimate) {
            float f = this$0.mTotalScaleBy;
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            this$0.mTotalScaleBy = f - (((Float) animatedValue).floatValue() - lastCurrent.element);
            Object animatedValue2 = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
            lastCurrent.element = ((Float) animatedValue2).floatValue();
        }
        Object animatedValue3 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
        this$0.scale(((Float) animatedValue3).floatValue());
    }

    private final float findClosestScale() {
        Log.i("xxx", "findClosestScale");
        float f = this.mHexRadius / this.DEFAULT_HEX_RADIUS;
        Log.d("BubbleLayoutManager", "findClosestScale: " + f);
        return (f <= 1.0f && f < 0.8f) ? 0.6f : 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018 A[PHI: r0
      0x0018: PHI (r0v6 float) = (r0v4 float), (r0v5 float) binds: [B:6:0x0016, B:9:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    public final void stopAnimate() {
        this.mTotalScaleBy = 0.0f;
        float f = this.mHexRadius / this.DEFAULT_HEX_RADIUS;
        float fFindClosestScale = findClosestScale();
        if (f == fFindClosestScale) {
            return;
        }
        float f2 = 1.8f;
        if (fFindClosestScale > 1.8f) {
            fFindClosestScale = f2;
        } else {
            f2 = 0.6f;
            if (fFindClosestScale < 0.6f) {
                fFindClosestScale = f2;
            }
        }
        animateTo(fFindClosestScale);
    }

    private final void animateTo(float expectScale) {
        Log.i("xxx", "animateTo");
        Log.i("BubbleLayoutManager", "----animateTo: " + expectScale);
        if (expectScale > 1.8f) {
            expectScale = 1.8f;
        }
        ValueAnimator duration = ValueAnimator.ofFloat(this.mHexRadius / this.DEFAULT_HEX_RADIUS, expectScale).setDuration(400L);
        this.mAnimator = duration;
        if (duration != null) {
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.dw.launcher.ui.dashboard.layoutmanager.HoneycombLayoutManager$$ExternalSyntheticLambda3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HoneycombLayoutManager.animateTo$lambda$11(this.f$0, valueAnimator);
                }
            });
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.addListener(new Animator.AnimatorListener(this) { // from class: com.dw.launcher.ui.dashboard.layoutmanager.HoneycombLayoutManager$animateTo$$inlined$addListener$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    ValueAnimator valueAnimator2 = this.this$0.mAnimator;
                    Intrinsics.checkNotNull(valueAnimator2);
                    Object animatedValue = valueAnimator2.getAnimatedValue();
                    Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                    this.this$0.scale(((Float) animatedValue).floatValue());
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    ValueAnimator valueAnimator2 = this.this$0.mAnimator;
                    Intrinsics.checkNotNull(valueAnimator2);
                    Object animatedValue = valueAnimator2.getAnimatedValue();
                    Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                    this.this$0.scale(((Float) animatedValue).floatValue());
                }
            });
        }
        ValueAnimator valueAnimator2 = this.mAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.setInterpolator(new AccelerateInterpolator());
        }
        ValueAnimator valueAnimator3 = this.mAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
        this.isStopAnimate = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTo$lambda$11(HoneycombLayoutManager this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.scale(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scale(float scale) {
        if (this.mFirstLayout || this.mFilling) {
            return;
        }
        this.mScale = scale;
        float f = this.DEFAULT_HEX_RADIUS * scale;
        this.mHexRadius = f;
        HoneyCombCalculator honeyCombCalculator = this.mCalculator;
        if (honeyCombCalculator != null) {
            honeyCombCalculator.setHexR(f);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopAnimalRunnable$lambda$16(HoneycombLayoutManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isStopAnimate) {
            return;
        }
        this$0.mTotalScaleBy = 0.0f;
        this$0.stopAnimate();
    }

    public final float getMDownDeltax() {
        return this.mDownDeltax;
    }

    public final void setMDownDeltax(float f) {
        this.mDownDeltax = f;
    }

    public final float getMDownDeltay() {
        return this.mDownDeltay;
    }

    public final void setMDownDeltay(float f) {
        this.mDownDeltay = f;
    }

    public final int getDownPointerNumber() {
        return this.downPointerNumber;
    }

    public final void setDownPointerNumber(int i) {
        this.downPointerNumber = i;
    }
}
