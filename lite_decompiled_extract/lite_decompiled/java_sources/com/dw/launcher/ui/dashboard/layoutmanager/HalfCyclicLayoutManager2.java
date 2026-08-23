package com.dw.launcher.ui.dashboard.layoutmanager;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.dw.launcher.ui.dashboard.transformation.HalfCyclicTransformation;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

/* JADX INFO: compiled from: HalfCyclicLayoutManager2.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0001iB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010*\u001a\u00020\bH\u0002J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020#H\u0002J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020/H\u0016J\u000e\u00101\u001a\u00020\b2\u0006\u00102\u001a\u000203J&\u00104\u001a\u00020,2\n\u00105\u001a\u000606R\u0002072\u0006\u00108\u001a\u00020#2\b\b\u0002\u00109\u001a\u00020\bH\u0002J\u0006\u0010:\u001a\u00020\bJ\b\u0010;\u001a\u0004\u0018\u00010\u0006J\u000e\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\bJ\b\u0010>\u001a\u00020?H\u0016J\u000e\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u0006J\u0006\u0010B\u001a\u00020\bJ\u0006\u0010C\u001a\u00020\bJ\u0016\u0010D\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\u0006\u0010E\u001a\u00020\bJ\u000e\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bJ\u0018\u0010H\u001a\u00020,2\u0006\u0010A\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\bH\u0002J\u0010\u0010J\u001a\u00020,2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u000207H\u0016J\u001c\u0010N\u001a\u00020,2\u0006\u0010M\u001a\u0002072\n\u00105\u001a\u000606R\u000207H\u0016J\u0018\u0010O\u001a\u00020/2\u0006\u0010P\u001a\u0002072\u0006\u0010Q\u001a\u00020RH\u0016J\u001c\u0010S\u001a\u00020,2\n\u00105\u001a\u000606R\u0002072\u0006\u0010T\u001a\u00020UH\u0016J\u0010\u0010V\u001a\u00020,2\u0006\u0010W\u001a\u00020/H\u0016J\u0010\u0010X\u001a\u00020,2\u0006\u0010T\u001a\u00020\bH\u0016J\u0018\u0010Y\u001a\u00020,2\u0006\u0010P\u001a\u0002072\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010Z\u001a\u00020,H\u0002J\u0006\u0010[\u001a\u00020,J\u001c\u0010\\\u001a\u00020,2\u0006\u0010]\u001a\u00020\b2\n\u00105\u001a\u000606R\u000207H\u0002J$\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\b2\n\u00105\u001a\u000606R\u0002072\u0006\u0010T\u001a\u00020UH\u0016J$\u0010`\u001a\u00020\b2\u0006\u0010a\u001a\u00020\b2\n\u00105\u001a\u000606R\u0002072\u0006\u0010T\u001a\u00020UH\u0016J$\u0010b\u001a\u00020,2\b\u0010c\u001a\u0004\u0018\u0001072\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010G\u001a\u00020\bH\u0016J\u000e\u0010d\u001a\u00020,2\u0006\u00105\u001a\u000207J\u001e\u0010e\u001a\u00020,2\u0006\u00109\u001a\u00020\b2\u0006\u00105\u001a\u0002072\u0006\u0010f\u001a\u00020\bJ\b\u0010g\u001a\u00020,H\u0002J\u000e\u0010h\u001a\u0002032\u0006\u0010]\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u001aj\b\u0012\u0004\u0012\u00020\u0006`\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006j"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/HalfCyclicLayoutManager2;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "context", "Landroid/content/Context;", "mIndicator", "Landroid/view/View;", "radius", "", "transformation", "Lcom/dw/launcher/ui/dashboard/transformation/HalfCyclicTransformation;", "(Landroid/content/Context;Landroid/view/View;ILcom/dw/launcher/ui/dashboard/transformation/HalfCyclicTransformation;)V", "fillStartPosition", "firstChildAngle", "lastSmoothStopTimestamp", "", "getLastSmoothStopTimestamp", "()J", "setLastSmoothStopTimestamp", "(J)V", "mDeltaX", "mDeltaY", "mDirectionY", "mHandler", "Landroid/os/Handler;", "mNeedRecycleList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mOrientationPeeked", "mPeekTouchSlop", "mPendingToScrollPosition", "mScheduleToFinishScrollTask", "Ljava/lang/Runnable;", "mTotalDirectionY", "mTouchDownX", "", "mTouchDownY", "turnDirection", "getTurnDirection", "()I", "setTurnDirection", "(I)V", "calculateEndChildIndex", "calculateFirstChildPlacement", "", "calculateIndicatorAngle", "canScrollHorizontally", "", "canScrollVertically", "degreeToVerticalY", "degree", "", "fill2", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "deltaAngle", "targetPosition", "findFirstVisibleItemPosition", "findSnapView", "findTargetSnapPosition", "velocityY", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "getAngleForChild", "child", "getRadius", "getSnapLeftViewDistance", "getSnapOffset", "offsetPos", "getSnapVerticalOffset", "pos", "layoutChild", "angle", "log", "", "onAttachedToWindow", "view", "onDetachedFromWindow", "onInterceptTouchEvent", "rv", "e", "Landroid/view/MotionEvent;", "onLayoutChildren", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "onScrollStateChanged", "onTouchEvent", "removeFinishScrollTask", "scheduleToFinishScroll", "scrollBy", "delta", "scrollHorizontallyBy", "dx", "scrollVerticallyBy", "dy", "smoothScrollToPosition", "recyclerView", "smoothToStable", "startSmoothScroll2", "mdirectionY", "transformChildren", "verticalYtoDegree", "Companion", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class HalfCyclicLayoutManager2 extends RecyclerView.LayoutManager implements RecyclerView.OnItemTouchListener {
    private static final int END_ANGLE = 108;
    private static final int ORIENTATION_HORIZONTAL = 0;
    private static final int ORIENTATION_UNDEFINE = -1;
    private static final int ORIENTATION_VERTICAL = 1;
    private static final int START_ANGLE = 252;
    private static final String TAG = "HalfCyclicLayoutManager";
    private static final int averageAngle = 36;
    private final Context context;
    private int fillStartPosition;
    private int firstChildAngle;
    private long lastSmoothStopTimestamp;
    private int mDeltaX;
    private int mDeltaY;
    private int mDirectionY;
    private final Handler mHandler;
    private final View mIndicator;
    private final ArrayList<View> mNeedRecycleList;
    private int mOrientationPeeked;
    private int mPeekTouchSlop;
    private int mPendingToScrollPosition;
    private final Runnable mScheduleToFinishScrollTask;
    private int mTotalDirectionY;
    private float mTouchDownX;
    private float mTouchDownY;
    private int radius;
    private HalfCyclicTransformation transformation;
    private int turnDirection;

    public boolean canScrollHorizontally() {
        return false;
    }

    public boolean canScrollVertically() {
        return true;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(e, "e");
    }

    public final void startSmoothScroll2(int targetPosition, RecyclerView recycler, int mdirectionY) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
    }

    public /* synthetic */ HalfCyclicLayoutManager2(Context context, View view, int i, HalfCyclicTransformation halfCyclicTransformation, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : view, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? null : halfCyclicTransformation);
    }

    public HalfCyclicLayoutManager2(Context context, View view, int i, HalfCyclicTransformation halfCyclicTransformation) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mIndicator = view;
        this.radius = i;
        this.transformation = halfCyclicTransformation;
        this.mPendingToScrollPosition = -1;
        this.fillStartPosition = -1;
        this.mOrientationPeeked = -1;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mScheduleToFinishScrollTask = new Runnable() { // from class: com.dw.launcher.ui.dashboard.layoutmanager.HalfCyclicLayoutManager2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HalfCyclicLayoutManager2.mScheduleToFinishScrollTask$lambda$0(this.f$0);
            }
        };
        this.mPeekTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mNeedRecycleList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mScheduleToFinishScrollTask$lambda$0(HalfCyclicLayoutManager2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onScrollStateChanged(0);
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public final int getRadius() {
        int i = this.radius;
        return i > 0 ? i : RangesKt.coerceAtLeast(getWidth(), getHeight()) / 2;
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        detachAndScrapAttachedViews(recycler);
        if (getItemCount() <= 0) {
            return;
        }
        fill2(recycler, 0.0f, 0);
        transformChildren();
    }

    private final void layoutChild(View child, int angle) {
        double radians = Math.toRadians(angle);
        int radius = getRadius();
        int decoratedMeasuredWidth = getDecoratedMeasuredWidth(child);
        int decoratedMeasuredHeight = getDecoratedMeasuredHeight(child);
        double d = radius;
        int i = decoratedMeasuredHeight / 2;
        int iCos = ((int) (Math.cos(radians) * d)) - i;
        int iSin = (((int) (Math.sin(radians) * d)) + (getHeight() / 2)) - i;
        layoutDecorated(child, iCos, iSin, iCos + decoratedMeasuredWidth, iSin + decoratedMeasuredHeight);
    }

    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        scrollBy(-dy, recycler);
        return dy;
    }

    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.mOrientationPeeked == -1) {
            if (Math.abs(this.mDeltaX) > Math.abs(this.mDeltaY) && Math.abs(this.mDeltaX) >= this.mPeekTouchSlop) {
                this.mOrientationPeeked = 0;
            } else {
                this.mDeltaX += dx;
            }
        }
        log("scrollHorizontallyBy: ");
        if (this.mOrientationPeeked == 0) {
            if (this.mTouchDownY >= getHeight() / 2.0f) {
                scrollBy(dx, recycler);
            } else {
                scrollBy(-dx, recycler);
            }
        }
        return dx;
    }

    private final void scrollBy(int delta, RecyclerView.Recycler recycler) {
        this.mDirectionY = delta;
        this.mTotalDirectionY += delta;
        calculateFirstChildPlacement();
        fill2$default(this, recycler, (float) verticalYtoDegree(delta), 0, 4, null);
        transformChildren();
    }

    public final double verticalYtoDegree(int delta) {
        return (delta * 90.0f) / this.radius;
    }

    public final int degreeToVerticalY(double degree) {
        return (int) ((((double) this.radius) * degree) / ((double) 90.0f));
    }

    static /* synthetic */ void fill2$default(HalfCyclicLayoutManager2 halfCyclicLayoutManager2, RecyclerView.Recycler recycler, float f, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        halfCyclicLayoutManager2.fill2(recycler, f, i);
    }

    private final void fill2(RecyclerView.Recycler recycler, float deltaAngle, int targetPosition) {
        int angleForChild;
        int angleForChild2;
        int position;
        int position2;
        int angleForChild3;
        int position3;
        if (getItemCount() == 0) {
            return;
        }
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            Intrinsics.checkNotNull(childAt);
            View childAt2 = getChildAt(getChildCount() - 1);
            Intrinsics.checkNotNull(childAt2);
            position = getPosition(childAt);
            position2 = getPosition(childAt2);
            angleForChild = getAngleForChild(childAt);
            angleForChild2 = getAngleForChild(childAt2);
            this.mNeedRecycleList.clear();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt3 = getChildAt(i);
                Intrinsics.checkNotNull(childAt3);
                int angleForChild4 = getAngleForChild(childAt3);
                int iRoundToInt = MathKt.roundToInt(angleForChild4 + deltaAngle);
                if ((angleForChild4 <= END_ANGLE && -108 <= iRoundToInt && iRoundToInt < 109) || (angleForChild4 >= START_ANGLE && START_ANGLE <= iRoundToInt && iRoundToInt < 469)) {
                    layoutChild(childAt3, iRoundToInt);
                } else {
                    this.mNeedRecycleList.add(childAt3);
                }
            }
            Iterator<T> it = this.mNeedRecycleList.iterator();
            while (it.hasNext()) {
                detachAndScrapView((View) it.next(), recycler);
            }
        } else {
            angleForChild = START_ANGLE;
            angleForChild2 = END_ANGLE;
            position = 0;
            position2 = 0;
        }
        if (deltaAngle > 0.0f) {
            int iRoundToInt2 = MathKt.roundToInt((angleForChild + deltaAngle) - averageAngle);
            int position4 = position - 1;
            if (getChildCount() > 0) {
                View childAt4 = getChildAt(0);
                Intrinsics.checkNotNull(childAt4);
                int angleForChild5 = getAngleForChild(childAt4) - averageAngle;
                position4 = getPosition(childAt4) - 1;
                iRoundToInt2 = angleForChild5;
            } else if (iRoundToInt2 <= 72) {
                while (iRoundToInt2 <= 72) {
                    iRoundToInt2 += averageAngle;
                    position4++;
                }
            } else if (iRoundToInt2 > END_ANGLE) {
                while (iRoundToInt2 > END_ANGLE) {
                    iRoundToInt2 -= 36;
                    position4--;
                }
            }
            while (position4 < 0) {
                position4 += getItemCount();
            }
            int itemCount = position4 % getItemCount();
            while (true) {
                if ((iRoundToInt2 < START_ANGLE && iRoundToInt2 > END_ANGLE && getChildCount() >= 6) || getChildCount() >= getItemCount()) {
                    return;
                }
                View viewForPosition = recycler.getViewForPosition(itemCount);
                Intrinsics.checkNotNull(viewForPosition);
                addView(viewForPosition, 0);
                measureChild(viewForPosition, 0, 0);
                layoutChild(viewForPosition, iRoundToInt2);
                int i2 = iRoundToInt2 - 36;
                int itemCount2 = itemCount - 1;
                while (i2 < 0) {
                    i2 += 360;
                }
                iRoundToInt2 = i2 % 360;
                while (itemCount2 < 0) {
                    itemCount2 += getItemCount();
                }
                itemCount = itemCount2 % getItemCount();
            }
        } else {
            if (deltaAngle == 0.0f && targetPosition >= 0 && targetPosition < getItemCount()) {
                position3 = targetPosition - 3;
                if (this.fillStartPosition == -1) {
                    this.fillStartPosition = 0;
                }
                angleForChild3 = START_ANGLE;
            } else {
                int iRoundToInt3 = MathKt.roundToInt(angleForChild2 + deltaAngle + averageAngle);
                int itemCount3 = position2 + 1;
                if (getChildCount() <= 0) {
                    if (iRoundToInt3 < START_ANGLE) {
                        while (iRoundToInt3 < START_ANGLE) {
                            iRoundToInt3 += averageAngle;
                            itemCount3++;
                        }
                    } else if (iRoundToInt3 >= 288) {
                        while (iRoundToInt3 >= END_ANGLE) {
                            iRoundToInt3 -= 36;
                            itemCount3--;
                        }
                    }
                    while (itemCount3 < 0) {
                        itemCount3 += getItemCount();
                    }
                    angleForChild3 = iRoundToInt3;
                    position3 = itemCount3 % getItemCount();
                } else {
                    View childAt5 = getChildAt(getChildCount() - 1);
                    Intrinsics.checkNotNull(childAt5);
                    angleForChild3 = getAngleForChild(childAt5) + averageAngle;
                    position3 = getPosition(childAt5) + 1;
                }
            }
            while (position3 < 0) {
                position3 += getItemCount();
            }
            int itemCount4 = position3 % getItemCount();
            while (true) {
                if ((angleForChild3 < START_ANGLE && angleForChild3 > END_ANGLE && getChildCount() >= 6) || getChildCount() >= getItemCount()) {
                    return;
                }
                View viewForPosition2 = recycler.getViewForPosition(itemCount4);
                Intrinsics.checkNotNullExpressionValue(viewForPosition2, "getViewForPosition(...)");
                addView(viewForPosition2);
                measureChild(viewForPosition2, 0, 0);
                layoutChild(viewForPosition2, angleForChild3);
                angleForChild3 = (angleForChild3 + averageAngle) % 360;
                itemCount4 = (itemCount4 + 1) % getItemCount();
            }
        }
    }

    public final int getAngleForChild(View child) {
        double dAtan;
        Intrinsics.checkNotNullParameter(child, "child");
        int height = getHeight() / 2;
        int left = child.getLeft();
        int top2 = child.getTop();
        int height2 = left + (child.getHeight() / 2);
        int i = -((top2 + (child.getHeight() / 2)) - height);
        if (height2 == 0) {
            dAtan = i > 0 ? 1.5707963267948966d : 4.71238898038469d;
        } else {
            dAtan = Math.atan(((double) i) / ((double) height2));
        }
        int iRoundToInt = MathKt.roundToInt(Math.toDegrees(dAtan));
        if (height2 < 0) {
            iRoundToInt += PduHeaders.RECOMMENDED_RETRIEVAL_MODE;
        }
        return (360 - iRoundToInt) % 360;
    }

    private final void transformChildren() {
        View view = this.mIndicator;
        if (view != null) {
            view.setRotation((float) verticalYtoDegree(this.mTotalDirectionY));
        }
        HalfCyclicTransformation halfCyclicTransformation = this.transformation;
        if (halfCyclicTransformation != null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                Intrinsics.checkNotNull(childAt);
                halfCyclicTransformation.onChildScale(childAt, getAngleForChild(childAt));
            }
        }
    }

    private final float calculateIndicatorAngle() {
        View childAt;
        int angleForChild;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                childAt = null;
                angleForChild = 0;
                break;
            }
            childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            angleForChild = getAngleForChild(childAt);
            if (1 <= angleForChild && angleForChild < 37) {
                break;
            }
            i++;
        }
        if (childAt == null) {
            return 0.0f;
        }
        int position = getPosition(childAt);
        float f = (((0 - position) % 10) * averageAngle) + angleForChild;
        Timber.INSTANCE.i("----calculateIndicatorAngle:position: " + position + ", angle: " + angleForChild + ", result: " + f, new Object[0]);
        return f;
    }

    public final void scheduleToFinishScroll() {
        removeFinishScrollTask();
        this.mHandler.postDelayed(this.mScheduleToFinishScrollTask, 100L);
    }

    private final void removeFinishScrollTask() {
        this.mHandler.removeCallbacks(this.mScheduleToFinishScrollTask);
    }

    public final long getLastSmoothStopTimestamp() {
        return this.lastSmoothStopTimestamp;
    }

    public final void setLastSmoothStopTimestamp(long j) {
        this.lastSmoothStopTimestamp = j;
    }

    public final void smoothToStable(RecyclerView recycler) {
        int angleForChild;
        int i;
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        if (!isSmoothScrolling() && System.currentTimeMillis() - this.lastSmoothStopTimestamp >= 800) {
            this.lastSmoothStopTimestamp = System.currentTimeMillis();
            Intrinsics.checkNotNull(getChildAt(0));
            int childCount = getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    angleForChild = -1;
                    break;
                }
                View childAt = getChildAt(i2);
                Intrinsics.checkNotNull(childAt);
                angleForChild = getAngleForChild(childAt);
                if (angleForChild > START_ANGLE && angleForChild < 288) {
                    break;
                } else {
                    i2++;
                }
            }
            if (angleForChild == -1 || angleForChild == START_ANGLE) {
                return;
            }
            if (this.mDirectionY < 0) {
                i = 252 - angleForChild;
                log("----onScrollStateChanged 方向小于0 向上滑动 offsetAngle: " + i + "  angle: " + angleForChild);
            } else {
                i = (-angleForChild) + 288;
                log("----onScrollStateChanged 方向小于0 向下滑动  offsetAngle: " + i + " angle: " + angleForChild);
            }
            if (-1 > i || i >= 2) {
                float f = (this.radius * i) / 90.0f;
                Timber.INSTANCE.d("----onScrollStateChanged 移动距离 offsetY: " + f + "  角度： " + i + " mDirectionY: " + this.mDirectionY, new Object[0]);
                recycler.smoothScrollBy(0, -((int) f));
                this.mDirectionY = 0;
            }
        }
    }

    public void onScrollStateChanged(int state) {
        this.mHandler.removeCallbacks(this.mScheduleToFinishScrollTask);
    }

    public void onAttachedToWindow(RecyclerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAttachedToWindow(view);
        view.addOnItemTouchListener(this);
    }

    public void onDetachedFromWindow(RecyclerView view, RecyclerView.Recycler recycler) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        super.onDetachedFromWindow(view, recycler);
        view.removeOnItemTouchListener(this);
    }

    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(e, "e");
        if ((e.getAction() & 255) == 0) {
            this.mTouchDownX = e.getX();
            this.mTouchDownY = e.getY();
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        } else if ((e.getAction() & 255) == 2) {
            if (this.mOrientationPeeked != -1) {
                rv.getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if ((e.getAction() & 255) == 1 || (e.getAction() & 255) == 3) {
            rv.getParent().requestDisallowInterceptTouchEvent(false);
        }
        return false;
    }

    private final void log(String log) {
        Timber.INSTANCE.i(log, new Object[0]);
    }

    public final int getSnapOffset(int targetPosition, int offsetPos) {
        if (getChildCount() <= 0) {
            return 0;
        }
        int i = this.fillStartPosition;
        int i2 = this.firstChildAngle;
        int i3 = targetPosition - i;
        float itemCount = i3 % getItemCount();
        if (Math.abs(itemCount) >= getItemCount() - Math.abs(offsetPos)) {
            if (i > targetPosition) {
                itemCount = i3 + getItemCount();
            } else {
                itemCount = -((i - targetPosition) + getItemCount());
            }
        }
        Timber.INSTANCE.d("----getSnapOffset deltaAngle----开始位置索引firstPostion " + i + " targetPostion: " + targetPosition, new Object[0]);
        float f = itemCount * averageAngle;
        float f2 = 0 + f;
        int iDegreeToVerticalY = degreeToVerticalY(f2);
        Timber.INSTANCE.e("----getSnapOffset deltaAngle: " + f + " y轴偏移值: " + iDegreeToVerticalY + " 偏移角度: 0 angle: " + i2 + "  firstPostion " + i + " targetPosition: " + targetPosition + " 滑动角度:" + f2 + " turnDirection: " + this.turnDirection, new Object[0]);
        return iDegreeToVerticalY;
    }

    public final int getTurnDirection() {
        return this.turnDirection;
    }

    public final void setTurnDirection(int i) {
        this.turnDirection = i;
    }

    public final int getSnapVerticalOffset(int pos) {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        Intrinsics.checkNotNull(childAt);
        return degreeToVerticalY((pos - getPosition(childAt)) * averageAngle);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002d A[PHI: r7
      0x002d: PHI (r7v2 int) = (r7v1 int), (r7v0 int) binds: [B:12:0x002b, B:9:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    public final View findSnapView() {
        int childCount = getChildCount();
        int i = Integer.MAX_VALUE;
        View view = null;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Intrinsics.checkNotNull(childAt);
            int angleForChild = getAngleForChild(childAt);
            if (angleForChild >= 0 && angleForChild <= 180) {
                if (i > Math.abs(angleForChild)) {
                    view = childAt;
                    i = angleForChild;
                }
            } else {
                angleForChild = 360 - angleForChild;
                if (i > Math.abs(angleForChild)) {
                    view = childAt;
                    i = angleForChild;
                }
            }
        }
        if (view == null) {
            return null;
        }
        Timber.Companion companion = Timber.INSTANCE;
        StringBuilder sbAppend = new StringBuilder("----找到最中间的点度数:").append(i).append("  位置 ");
        Intrinsics.checkNotNull(view);
        companion.d(sbAppend.append(getPosition(view)).toString(), new Object[0]);
        return view;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0004 A[PHI: r0
      0x0004: PHI (r0v7 int) = (r0v0 int), (r0v1 int) binds: [B:3:0x0002, B:6:0x0008] A[DONT_GENERATE, DONT_INLINE]] */
    public final int findTargetSnapPosition(int velocityY) {
        double d;
        double d2;
        int i = -1000;
        if (velocityY < -1000) {
            velocityY = i;
        } else {
            i = CharacterSets.UCS2;
            if (velocityY > 1000) {
                velocityY = i;
            }
        }
        int childCount = getChildCount();
        int i2 = Integer.MAX_VALUE;
        int position = -1;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            Intrinsics.checkNotNull(childAt);
            int angleForChild = getAngleForChild(childAt);
            if (angleForChild >= 0 && angleForChild <= 180) {
                if (i2 > Math.abs(angleForChild)) {
                    position = getPosition(childAt);
                    i2 = angleForChild;
                }
            } else {
                angleForChild = 360 - angleForChild;
                if (i2 > Math.abs(angleForChild)) {
                    position = getPosition(childAt);
                    i2 = angleForChild;
                }
            }
        }
        if (position == -1) {
            return -1;
        }
        double dVerticalYtoDegree = verticalYtoDegree(velocityY);
        if (this.mDirectionY > 0) {
            d = position;
            d2 = dVerticalYtoDegree - ((double) i2);
        } else {
            d = position;
            d2 = (dVerticalYtoDegree - ((double) i2)) - ((double) 360);
        }
        int iMin = Math.min(Math.max(0, (int) (d + (d2 / ((double) averageAngle)))), getItemCount() - 1);
        Timber.INSTANCE.e("----findTargetSnapPosition targetPosition:" + iMin + "  centerPosition:" + position + "  gapTartDegree:" + dVerticalYtoDegree + "  centenAngel:" + i2 + " 方向xDirectory:" + this.mDirectionY, new Object[0]);
        return iMin;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002d A[PHI: r7
      0x002d: PHI (r7v10 int) = (r7v9 int), (r7v8 int) binds: [B:12:0x002b, B:9:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    public final int getSnapLeftViewDistance() {
        int i;
        int childCount = getChildCount();
        int i2 = Integer.MAX_VALUE;
        View view = null;
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            Intrinsics.checkNotNull(childAt);
            int angleForChild = getAngleForChild(childAt);
            if (angleForChild < 0 || angleForChild >= 181) {
                angleForChild = 360 - angleForChild;
                if (i2 > Math.abs(angleForChild)) {
                    i3 = i4;
                    view = childAt;
                    i2 = angleForChild;
                }
            } else if (i2 > Math.abs(angleForChild)) {
                i3 = i4;
                view = childAt;
                i2 = angleForChild;
            }
        }
        if (-1 <= i2 && i2 < 2) {
            return 0;
        }
        if (view == null) {
            i = 0;
        } else if (this.mDirectionY > 0) {
            View childAt2 = getChildAt(i3 - 1);
            Intrinsics.checkNotNull(childAt2);
            int angleForChild2 = getAngleForChild(childAt2);
            Timber.INSTANCE.d(" 它的上一个点距离0点角度：" + angleForChild2, new Object[0]);
            i = 360 - angleForChild2;
            if (i >= averageAngle) {
                if (i2 > END_ANGLE) {
                    i = 360 - i2;
                } else {
                    View childAt3 = getChildAt(getChildCount() - 1);
                    Intrinsics.checkNotNull(childAt3);
                    int angleForChild3 = getAngleForChild(childAt3);
                    int i5 = (angleForChild3 <= 90 || angleForChild3 >= 106) ? 0 : 108 - angleForChild3;
                    Timber.INSTANCE.d(" 终点角度：" + angleForChild3 + ' ', new Object[0]);
                    i = i5;
                }
            }
        } else {
            i = i2 > END_ANGLE ? -((-324) - i2) : -i2;
        }
        Timber.Companion companion = Timber.INSTANCE;
        double d = i;
        StringBuilder sbAppend = new StringBuilder("-------------偏移角度：").append(i).append("  靠近0点角度： ").append(i2).append(" 偏移距离：").append(degreeToVerticalY(d)).append(" mDirectory:").append(this.mDirectionY).append(" 半径：").append(this.radius).append("  得到靠近0点位置：");
        Intrinsics.checkNotNull(view);
        companion.d(sbAppend.append(getPosition(view)).toString(), new Object[0]);
        if (-2 <= i && i < 3) {
            return 0;
        }
        if (i != 0) {
            return -degreeToVerticalY(d);
        }
        return -1;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, final int pos) {
        calculateFirstChildPlacement();
        int itemCount = (this.fillStartPosition + pos) % getItemCount();
        while (itemCount < 0) {
            itemCount += getItemCount();
        }
        Timber.INSTANCE.d("----smoothScrollToPosition targetposition:" + itemCount + " fillStartPosition:" + this.fillStartPosition + " pos:" + pos + " itemCount:" + getItemCount() + "  childCount:" + getChildCount(), new Object[0]);
        RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(this.context) { // from class: com.dw.launcher.ui.dashboard.layoutmanager.HalfCyclicLayoutManager2.smoothScrollToPosition.1
            public PointF computeScrollVectorForPosition(int targetPosition) {
                int i = HalfCyclicLayoutManager2.this.fillStartPosition;
                int i2 = targetPosition - i;
                float itemCount2 = i2 % HalfCyclicLayoutManager2.this.getItemCount();
                if (Math.abs(itemCount2) >= HalfCyclicLayoutManager2.this.getItemCount() - Math.abs(pos)) {
                    if (i > targetPosition) {
                        itemCount2 = i2 + HalfCyclicLayoutManager2.this.getItemCount();
                    } else {
                        itemCount2 = -((i - targetPosition) + HalfCyclicLayoutManager2.this.getItemCount());
                    }
                }
                Log.e(HalfCyclicLayoutManager2.TAG, "计算目标高度 fillStartPosition: " + i + ", targetPosition: " + targetPosition + ",  pos: " + pos + " gap: " + itemCount2);
                return new PointF(0.0f, itemCount2);
            }

            protected void onTargetFound(View targetView, RecyclerView.State state2, RecyclerView.SmoothScroller.Action action) {
                Intrinsics.checkNotNullParameter(targetView, "targetView");
                Intrinsics.checkNotNullParameter(state2, "state");
                Intrinsics.checkNotNullParameter(action, "action");
                int snapOffset = HalfCyclicLayoutManager2.this.getSnapOffset(HalfCyclicLayoutManager2.this.getPosition(targetView), pos);
                Timber.INSTANCE.d("onTargetFound dy = " + snapOffset + " pos= " + pos, new Object[0]);
                int iCalculateTimeForScrolling = calculateTimeForScrolling(Math.abs(snapOffset));
                if (iCalculateTimeForScrolling > 0) {
                    action.update(0, snapOffset, iCalculateTimeForScrolling, new DecelerateInterpolator());
                }
            }

            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                float f;
                float f2;
                Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
                Timber.INSTANCE.d("计算时间啦...........", new Object[0]);
                if (Math.abs(pos) >= 7) {
                    f = displayMetrics.densityDpi;
                    f2 = 200.0f;
                } else if (Math.abs(pos) >= 4) {
                    f = displayMetrics.densityDpi;
                    f2 = 400.0f;
                } else {
                    f = displayMetrics.densityDpi;
                    f2 = 600.0f;
                }
                return f2 / f;
            }

            protected int calculateTimeForScrolling(int dx) {
                Timber.INSTANCE.d("计算时间啦2222...........", new Object[0]);
                return super.calculateTimeForScrolling(dx);
            }
        };
        smoothScroller.setTargetPosition(itemCount);
        startSmoothScroll(smoothScroller);
    }

    public final int findFirstVisibleItemPosition() {
        if (getChildCount() == 0) {
            return -1;
        }
        View childAt = getChildAt(0);
        Intrinsics.checkNotNull(childAt);
        return getPosition(childAt);
    }

    private final void calculateFirstChildPlacement() {
        int childCount = getChildCount();
        int position = -1;
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Intrinsics.checkNotNull(childAt);
            int angleForChild = getAngleForChild(childAt);
            if (angleForChild >= 0 && angleForChild <= 180) {
                if (i > Math.abs(angleForChild)) {
                    position = getPosition(childAt);
                    i = angleForChild;
                }
            } else {
                angleForChild = 360 - angleForChild;
                if (i > Math.abs(angleForChild)) {
                    position = getPosition(childAt);
                    i = angleForChild;
                }
            }
        }
        this.fillStartPosition = position;
    }

    private final int calculateEndChildIndex() {
        View childAt;
        int childCount = getChildCount();
        do {
            childCount--;
            if (-1 >= childCount) {
                return 0;
            }
            childAt = getChildAt(childCount);
            Intrinsics.checkNotNull(childAt);
        } while (getDecoratedLeft(childAt) <= (-childAt.getHeight()));
        return childCount;
    }
}
