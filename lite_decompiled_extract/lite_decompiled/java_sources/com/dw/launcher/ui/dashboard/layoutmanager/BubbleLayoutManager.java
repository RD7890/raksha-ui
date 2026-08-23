package com.dw.launcher.ui.dashboard.layoutmanager;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.dw.launcher.ui.dashboard.util.BubbleCalculator;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

/* JADX INFO: compiled from: BubbleLayoutManager.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u0088\u00012\u00020\u00012\u00020\u0002:\u0006\u0088\u0001\u0089\u0001\u008a\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\tH\u0002J\u000e\u0010U\u001a\u00020S2\u0006\u0010V\u001a\u00020\tJ\b\u0010W\u001a\u00020 H\u0016J\b\u0010X\u001a\u00020 H\u0016J\u0006\u0010Y\u001a\u00020ZJ\u0014\u0010[\u001a\u00020S2\n\u0010\\\u001a\u00060]R\u00020^H\u0002J\b\u0010_\u001a\u00020\tH\u0002J\u0018\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\t2\u0006\u0010a\u001a\u00020\tH\u0002J\n\u0010b\u001a\u0004\u0018\u00010cH\u0002J\b\u0010d\u001a\u00020eH\u0016J\u001c\u0010f\u001a\u00020e2\b\u0010g\u001a\u0004\u0018\u00010\u00042\b\u0010h\u001a\u0004\u0018\u00010iH\u0016J\u0011\u0010j\u001a\u00020\t2\u0006\u0010k\u001a\u00020\tH\u0082\bJ\u0012\u0010l\u001a\u00020S2\b\u0010m\u001a\u0004\u0018\u00010^H\u0016J\u0018\u0010n\u001a\u00020 2\u0006\u0010o\u001a\u00020^2\u0006\u0010p\u001a\u00020qH\u0016J\u0010\u0010r\u001a\u00020S2\u0006\u0010s\u001a\u00020^H\u0016J\u001c\u0010t\u001a\u00020S2\n\u0010\\\u001a\u00060]R\u00020^2\u0006\u0010u\u001a\u00020vH\u0016J\u0012\u0010w\u001a\u00020S2\b\u0010u\u001a\u0004\u0018\u00010vH\u0016J\u0010\u0010x\u001a\u00020S2\u0006\u0010y\u001a\u00020 H\u0016J\u000e\u0010z\u001a\u00020S2\u0006\u0010{\u001a\u00020|J\u0010\u0010}\u001a\u00020S2\b\u0010{\u001a\u0004\u0018\u00010|J\u0010\u0010~\u001a\u00020S2\b\u0010{\u001a\u0004\u0018\u00010|J\u0010\u0010\u007f\u001a\u00020S2\u0006\u0010u\u001a\u00020\u0012H\u0016J\u0019\u0010\u0080\u0001\u001a\u00020S2\u0006\u0010o\u001a\u00020^2\u0006\u0010p\u001a\u00020qH\u0016J\u0007\u0010\u0081\u0001\u001a\u00020SJ\u0012\u0010\u0082\u0001\u001a\u00020S2\u0007\u0010\u0082\u0001\u001a\u00020\tH\u0002J&\u0010\u0083\u0001\u001a\u00020\u00122\u0007\u0010\u0084\u0001\u001a\u00020\u00122\n\u0010\\\u001a\u00060]R\u00020^2\u0006\u0010u\u001a\u00020vH\u0016J&\u0010\u0085\u0001\u001a\u00020\u00122\u0007\u0010\u0086\u0001\u001a\u00020\u00122\n\u0010\\\u001a\u00060]R\u00020^2\u0006\u0010u\u001a\u00020vH\u0016J\u0007\u0010\u0087\u0001\u001a\u00020SR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u000e\u00104\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010.\"\u0004\b8\u00100R\u001a\u00109\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010.\"\u0004\b;\u00100R\u000e\u0010<\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010.\"\u0004\bC\u00100R\u000e\u0010D\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010.\"\u0004\bI\u00100R\u001a\u0010J\u001a\u00020KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008b\u0001"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/BubbleLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "context", "Landroid/content/Context;", "listener", "Lcom/dw/launcher/ui/dashboard/layoutmanager/BubbleLayoutManager$OnItemSelectedListener;", "(Landroid/content/Context;Lcom/dw/launcher/ui/dashboard/layoutmanager/BubbleLayoutManager$OnItemSelectedListener;)V", "DEFAULT_HEX_RADIUS", "", "DEFAULT_SPHERE_RADIUS", "currentTimestamp", "", "getCurrentTimestamp", "()J", "setCurrentTimestamp", "(J)V", "downPointerNumber", "", "getDownPointerNumber", "()I", "setDownPointerNumber", "(I)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "initialSpan", "Ljava/lang/Float;", "isEdgeClick", "", "isScaling", "isStopAnimate", "()Z", "setStopAnimate", "(Z)V", "mAnimator", "Landroid/animation/ValueAnimator;", "mCalculator", "Lcom/dw/launcher/ui/dashboard/util/BubbleCalculator;", "mClickX", "mClickY", "mDeltaX", "getMDeltaX", "()F", "setMDeltaX", "(F)V", "mDeltaY", "getMDeltaY", "setMDeltaY", "mDimens", "mDirtyLayoutParams", "mDownDeltax", "getMDownDeltax", "setMDownDeltax", "mDownDeltay", "getMDownDeltay", "setMDownDeltay", "mEdge", "mFilling", "mFirstLayout", "mHandler", "mHexRadius", "mScale", "getMScale", "setMScale", "mScreenHeight", "mScreenWidth", "mSphereRadius", "mTotalScaleBy", "getMTotalScaleBy", "setMTotalScaleBy", "myGestureListener", "Landroidx/core/view/GestureDetectorCompat;", "getMyGestureListener", "()Landroidx/core/view/GestureDetectorCompat;", "setMyGestureListener", "(Landroidx/core/view/GestureDetectorCompat;)V", "stopAnimalRunnable", "Ljava/lang/Runnable;", "animateTo", "", "expectScale", "animateToScaleBy", "scaleBy", "canScrollHorizontally", "canScrollVertically", "claulatorToCenterDistance", "", "fill", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "findClosestScale", "current", "except", "findSelectChild", "Landroid/view/View;", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "generateLayoutParams", "c", "attrs", "Landroid/util/AttributeSet;", "gestureScan", "gap", "onAttachedToWindow", "view", "onInterceptTouchEvent", "rv", "e", "Landroid/view/MotionEvent;", "onItemsChanged", "recyclerView", "onLayoutChildren", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onLayoutCompleted", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "onScrollStateChanged", "onTouchEvent", "restoreScale", "scale", "scrollHorizontallyBy", "dx", "scrollVerticallyBy", "dy", "stopAnimate", "Companion", "MyGestureListener", "OnItemSelectedListener", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class BubbleLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.OnItemTouchListener {
    public static final float DEFAULT_SCALE = 1.0f;
    public static final long DURATION = 300;
    public static final float MAX_SCALE = 1.8f;
    public static final float MIN_SCALE = 0.6f;
    public static final float PREVIEW_MAX_SCALE = 2.5f;
    public static final float PREVIEW_MIN_SCALE = 0.2f;
    public static final float SCALE_STEP = 1.1f;
    public static final String TAG = "BubbleLayoutManager";
    private final float DEFAULT_HEX_RADIUS;
    private final float DEFAULT_SPHERE_RADIUS;
    private long currentTimestamp;
    private int downPointerNumber;
    private Handler handler;
    private Float initialSpan;
    private boolean isEdgeClick;
    private boolean isScaling;
    private boolean isStopAnimate;
    private final OnItemSelectedListener listener;
    private ValueAnimator mAnimator;
    private BubbleCalculator mCalculator;
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
    private GestureDetectorCompat myGestureListener;
    private final Runnable stopAnimalRunnable;

    /* JADX INFO: compiled from: BubbleLayoutManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/BubbleLayoutManager$OnItemSelectedListener;", "", "onItemSelected", "", "position", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public interface OnItemSelectedListener {
        void onItemSelected(int position);
    }

    public boolean canScrollHorizontally() {
        return true;
    }

    public boolean canScrollVertically() {
        return true;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    public void onScrollStateChanged(int state) {
    }

    public BubbleLayoutManager(Context context, OnItemSelectedListener listener) {
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
        this.myGestureListener = new GestureDetectorCompat(context, new MyGestureListener());
        this.stopAnimalRunnable = new Runnable() { // from class: com.dw.launcher.ui.dashboard.layoutmanager.BubbleLayoutManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BubbleLayoutManager.stopAnimalRunnable$lambda$16(this.f$0);
            }
        };
        this.initialSpan = Float.valueOf(0.0f);
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

    public final GestureDetectorCompat getMyGestureListener() {
        return this.myGestureListener;
    }

    public final void setMyGestureListener(GestureDetectorCompat gestureDetectorCompat) {
        Intrinsics.checkNotNullParameter(gestureDetectorCompat, "<set-?>");
        this.myGestureListener = gestureDetectorCompat;
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
        this.mHexRadius = this.DEFAULT_HEX_RADIUS;
        BubbleCalculator bubbleCalculator = this.mCalculator;
        if (bubbleCalculator != null) {
            bubbleCalculator.initPosition(getItemCount());
        }
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (getItemCount() <= 0) {
            detachAndScrapAttachedViews(recycler);
            return;
        }
        if (this.mDirtyLayoutParams) {
            removeAndRecycleAllViews(recycler);
            this.mDirtyLayoutParams = false;
        }
        if (this.mCalculator == null) {
            this.mCalculator = new BubbleCalculator(getWidth(), getHeight(), this.mSphereRadius, this.mHexRadius, this.mEdge);
        }
        BubbleCalculator bubbleCalculator = this.mCalculator;
        if (bubbleCalculator != null) {
            if (bubbleCalculator.size() < getItemCount()) {
                bubbleCalculator.initPosition(getItemCount());
            }
            bubbleCalculator.transform(-this.mDeltaX, -this.mDeltaY);
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
                this.isScaling = false;
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.dw.launcher.ui.dashboard.layoutmanager.BubbleLayoutManager$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    BubbleLayoutManager.onLayoutCompleted$lambda$2(this.f$0);
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLayoutCompleted$lambda$2(BubbleLayoutManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mScale == 1.0f) {
            return;
        }
        this$0.mScale = 1.0f;
        float f = this$0.DEFAULT_HEX_RADIUS;
        this$0.mHexRadius = f;
        BubbleCalculator bubbleCalculator = this$0.mCalculator;
        if (bubbleCalculator != null) {
            bubbleCalculator.setHexR(f);
        }
        this$0.mDeltaX = 0.0f;
        this$0.mDeltaY = 0.0f;
        this$0.requestLayout();
    }

    private final void fill(RecyclerView.Recycler recycler) {
        this.mFilling = true;
        if (getChildCount() != getItemCount()) {
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
            BubbleCalculator bubbleCalculator = this.mCalculator;
            Intrinsics.checkNotNull(bubbleCalculator);
            BubbleCalculator.Position positionAt = bubbleCalculator.getPositionAt(i2);
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

    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.isScaling) {
            return dx;
        }
        if (getChildCount() > 0) {
            int width = getWidth() / 2;
            int childCount = getChildCount();
            int iCoerceAtLeast = width;
            int iCoerceAtMost = iCoerceAtLeast;
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                Intrinsics.checkNotNull(childAt);
                iCoerceAtMost = RangesKt.coerceAtMost(iCoerceAtMost, childAt.getLeft());
                iCoerceAtLeast = RangesKt.coerceAtLeast(iCoerceAtLeast, childAt.getRight());
            }
            if (iCoerceAtLeast <= 0 || iCoerceAtLeast > width + (this.mHexRadius / 2) ? !(iCoerceAtMost <= 0 || iCoerceAtMost < width - (this.mHexRadius / 2) || dx >= 0) : dx > 0) {
                dx = 0;
            }
            float f = this.mDeltaX + dx;
            this.mDeltaX = f;
            BubbleCalculator bubbleCalculator = this.mCalculator;
            if (bubbleCalculator != null) {
                bubbleCalculator.transform(-f, -this.mDeltaY);
                fill(recycler);
            }
        }
        return dx;
    }

    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.isScaling) {
            return dy;
        }
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
                BubbleCalculator bubbleCalculator = this.mCalculator;
                if (bubbleCalculator != null) {
                    bubbleCalculator.transform(-this.mDeltaX, -f);
                    fill(recycler);
                }
            }
        }
        return dy;
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
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int childCount = getChildCount();
        int height2 = 0;
        int i = 0;
        View view = null;
        int width2 = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Intrinsics.checkNotNull(childAt);
            if (view != null) {
                int left = childAt.getLeft() + (childAt.getWidth() / 2);
                int top2 = childAt.getTop() + (childAt.getHeight() / 2);
                int i3 = left - width;
                int i4 = top2 - height;
                int i5 = (i3 * i3) + (i4 * i4);
                if (i5 < i) {
                    i = i5;
                    width2 = left - (getWidth() / 2);
                    height2 = top2 - (getHeight() / 2);
                }
            } else {
                int left2 = (childAt.getLeft() + (childAt.getWidth() / 2)) - width;
                int top3 = (childAt.getTop() + (childAt.getHeight() / 2)) - height;
                i = (left2 * left2) + (top3 * top3);
                view = childAt;
            }
        }
        return new int[]{width2, height2};
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
        ValueAnimator duration = ValueAnimator.ofFloat(f, this.mTotalScaleBy + f).setDuration(300L);
        this.mAnimator = duration;
        if (duration != null) {
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.dw.launcher.ui.dashboard.layoutmanager.BubbleLayoutManager$$ExternalSyntheticLambda3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    BubbleLayoutManager.animateToScaleBy$lambda$6(this.f$0, floatRef, valueAnimator2);
                }
            });
        }
        ValueAnimator valueAnimator2 = this.mAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.addListener(new Animator.AnimatorListener(this, this, f) { // from class: com.dw.launcher.ui.dashboard.layoutmanager.BubbleLayoutManager$animateToScaleBy$$inlined$addListener$1
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
                    long jCurrentTimeMillis = 300 - (System.currentTimeMillis() - this.this$0.getCurrentTimestamp());
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
    public static final void animateToScaleBy$lambda$6(BubbleLayoutManager this$0, Ref.FloatRef lastCurrent, ValueAnimator valueAnimator) {
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

    /* JADX WARN: Code duplicated, block: B:15:0x003d A[PHI: r4
      0x003d: PHI (r4v1 float) = (r4v0 float), (r4v2 float) binds: [B:14:0x003b, B:8:0x0021] A[DONT_GENERATE, DONT_INLINE]] */
    private final float findClosestScale(float current, float except) {
        float f;
        float f2 = 1.0f;
        if (except > 1.0f) {
            while (f2 < except) {
                f2 *= 1.1f;
            }
            f = f2 / 1.1f;
            if (Math.abs(f2 - except) - Math.abs(f - except) > 0.0f) {
                f2 = f;
            }
        } else {
            while (f2 > except) {
                f2 /= 1.1f;
            }
            f = f2 * 1.1f;
            if (Math.abs(f2 - except) - Math.abs(f - except) > 0.0f) {
                f2 = f;
            }
        }
        if (current > except) {
            return f2 < except ? f2 * 1.1f : f2;
        }
        return f2 > except ? f2 / 1.1f : f2;
    }

    private final float findClosestScale() {
        Log.i("xxx", "findClosestScale");
        float f = this.mHexRadius / this.DEFAULT_HEX_RADIUS;
        Log.d("BubbleLayoutManager", "findClosestScale: " + f);
        return (f <= 1.0f && f < 0.8f) ? 0.6f : 1.0f;
    }

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
        if (expectScale > 1.8f) {
            expectScale = 1.8f;
        }
        ValueAnimator duration = ValueAnimator.ofFloat(this.mHexRadius / this.DEFAULT_HEX_RADIUS, expectScale).setDuration(300L);
        this.mAnimator = duration;
        if (duration != null) {
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.dw.launcher.ui.dashboard.layoutmanager.BubbleLayoutManager$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BubbleLayoutManager.animateTo$lambda$11(this.f$0, valueAnimator);
                }
            });
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.addListener(new Animator.AnimatorListener(this) { // from class: com.dw.launcher.ui.dashboard.layoutmanager.BubbleLayoutManager$animateTo$$inlined$addListener$1
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
                    this.this$0.isScaling = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    ValueAnimator valueAnimator2 = this.this$0.mAnimator;
                    Intrinsics.checkNotNull(valueAnimator2);
                    Object animatedValue = valueAnimator2.getAnimatedValue();
                    Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                    this.this$0.scale(((Float) animatedValue).floatValue());
                    this.this$0.isScaling = false;
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
    public static final void animateTo$lambda$11(BubbleLayoutManager this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.scale(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scale(float scale) {
        Log.i("xxx", "scale");
        if (this.mFirstLayout || this.mFilling) {
            return;
        }
        this.mScale = scale;
        float f = this.DEFAULT_HEX_RADIUS * scale;
        this.mHexRadius = f;
        BubbleCalculator bubbleCalculator = this.mCalculator;
        if (bubbleCalculator != null) {
            bubbleCalculator.setHexR(f);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopAnimalRunnable$lambda$16(BubbleLayoutManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isStopAnimate) {
            return;
        }
        this$0.mTotalScaleBy = 0.0f;
        this$0.stopAnimate();
    }

    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(e, "e");
        return this.myGestureListener.onTouchEvent(e);
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

    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(e, "e");
        int action = e.getAction();
        if (action == 1) {
            if (this.isEdgeClick) {
                stopAnimate();
            }
            this.isEdgeClick = false;
            return;
        }
        if (action != 2) {
            if (action == 3) {
                this.isEdgeClick = false;
                return;
            } else {
                if (action != 6) {
                    return;
                }
                this.isEdgeClick = false;
                return;
            }
        }
        if (this.isEdgeClick) {
            float fCoerceIn = RangesKt.coerceIn((this.mHexRadius / this.DEFAULT_HEX_RADIUS) - ((e.getY() - this.mClickY) / this.mScreenHeight), 0.2f, 2.5f);
            if (fCoerceIn >= 0.6f && fCoerceIn < 1.0f) {
                float f = (1.0f - fCoerceIn) / 0.39999998f;
                float f2 = this.mDownDeltax;
                this.mDeltaX = f2 - (f2 * f);
                float f3 = this.mDownDeltay;
                this.mDeltaY = f3 - (f * f3);
            } else if (fCoerceIn < 0.6f) {
                this.mDeltaX = 0.0f;
                this.mDeltaY = 0.0f;
                this.mDownDeltax = 0.0f;
                this.mDownDeltay = 0.0f;
            }
            scale(fCoerceIn);
            this.mClickY = e.getY();
            Timber.INSTANCE.d("----onTouchEvent initialSpan: " + this.initialSpan + " mDownDeltax: " + this.mDownDeltax + " mDownDeltay: " + this.mDownDeltay + " mDeltaX: " + this.mDeltaX + " mDeltaY: " + this.mDeltaY, new Object[0]);
        }
    }

    public final int getDownPointerNumber() {
        return this.downPointerNumber;
    }

    public final void setDownPointerNumber(int i) {
        this.downPointerNumber = i;
    }

    /* JADX INFO: compiled from: BubbleLayoutManager.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J(\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/BubbleLayoutManager$MyGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "(Lcom/dw/launcher/ui/dashboard/layoutmanager/BubbleLayoutManager;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public final class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        public MyGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            BubbleLayoutManager.this.mClickX = e.getX();
            BubbleLayoutManager.this.mClickY = e.getY();
            BubbleLayoutManager.this.setDownPointerNumber(e.getPointerCount());
            if (BubbleLayoutManager.this.mClickX > BubbleLayoutManager.this.mScreenWidth - 35) {
                BubbleLayoutManager bubbleLayoutManager = BubbleLayoutManager.this;
                bubbleLayoutManager.setMDownDeltax(bubbleLayoutManager.getMDeltaX());
                BubbleLayoutManager bubbleLayoutManager2 = BubbleLayoutManager.this;
                bubbleLayoutManager2.setMDownDeltay(bubbleLayoutManager2.getMDeltaY());
                BubbleLayoutManager.this.isEdgeClick = true;
                Timber.INSTANCE.d("按键到边缘了....mDownDeltax = " + BubbleLayoutManager.this.getMDownDeltax() + " mDownDeltay = " + BubbleLayoutManager.this.getMDownDeltay(), new Object[0]);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Intrinsics.checkNotNullParameter(e1, "e1");
            Intrinsics.checkNotNullParameter(e2, "e2");
            return BubbleLayoutManager.this.isEdgeClick;
        }
    }

    private final float gestureScan(float gap) {
        float fCoerceIn = RangesKt.coerceIn((this.mHexRadius / this.DEFAULT_HEX_RADIUS) - gap, 0.2f, 2.5f);
        if (fCoerceIn >= 0.6f && fCoerceIn < 1.0f) {
            float f = (1.0f - fCoerceIn) / 0.39999998f;
            float f2 = this.mDownDeltax;
            this.mDeltaX = f2 - (f2 * f);
            float f3 = this.mDownDeltay;
            this.mDeltaY = f3 - (f * f3);
        } else if (fCoerceIn < 0.6f) {
            this.mDeltaX = 0.0f;
            this.mDeltaY = 0.0f;
            this.mDownDeltax = 0.0f;
            this.mDownDeltay = 0.0f;
        }
        return fCoerceIn;
    }

    public final void onScale(ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        float currentSpan = detector.getCurrentSpan();
        if (Intrinsics.areEqual(this.initialSpan, 0.0f)) {
            this.initialSpan = Float.valueOf(currentSpan);
        }
        Float f = this.initialSpan;
        Intrinsics.checkNotNull(f);
        float fCoerceIn = RangesKt.coerceIn((this.mHexRadius / this.DEFAULT_HEX_RADIUS) - (((f.floatValue() - currentSpan) / this.mScreenHeight) * 1.4f), 0.2f, 2.5f);
        if (fCoerceIn >= 0.6f && fCoerceIn < 1.0f) {
            float f2 = (1.0f - fCoerceIn) / 0.39999998f;
            float f3 = this.mDownDeltax;
            this.mDeltaX = f3 - (f3 * f2);
            float f4 = this.mDownDeltay;
            this.mDeltaY = f4 - (f2 * f4);
        } else if (fCoerceIn < 0.6f) {
            this.mDeltaX = 0.0f;
            this.mDeltaY = 0.0f;
            this.mDownDeltax = 0.0f;
            this.mDownDeltay = 0.0f;
        }
        scale(fCoerceIn);
        this.initialSpan = Float.valueOf(currentSpan);
        this.isScaling = true;
    }

    public final void onScaleBegin(ScaleGestureDetector detector) {
        this.isScaling = true;
        this.initialSpan = detector != null ? Float.valueOf(detector.getCurrentSpan()) : null;
        this.mDownDeltax = this.mDeltaX;
        this.mDownDeltay = this.mDeltaY;
        Timber.INSTANCE.d("----scaleBegin initialSpan: " + this.initialSpan + " mDownDeltax: " + this.mDownDeltax + " mDownDeltay: " + this.mDownDeltay, new Object[0]);
    }

    public final void onScaleEnd(ScaleGestureDetector detector) {
        this.isScaling = false;
        this.initialSpan = Float.valueOf(0.0f);
        stopAnimate();
    }

    public final void restoreScale() {
        this.mDeltaY = 0.0f;
        this.mDeltaX = 0.0f;
        this.mScale = 1.0f;
        scale(1.0f);
    }
}
