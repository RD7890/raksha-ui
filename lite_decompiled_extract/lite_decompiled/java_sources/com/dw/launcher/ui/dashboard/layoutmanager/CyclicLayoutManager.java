package com.dw.launcher.ui.dashboard.layoutmanager;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

/* JADX INFO: compiled from: CyclicLayoutManager.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0002\\]B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016J\u000e\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(J\b\u0010)\u001a\u00020*H\u0002J,\u0010+\u001a\u00020*2\n\u0010,\u001a\u00060-R\u00020.2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u001cH\u0002J\b\u00102\u001a\u0004\u0018\u00010\bJ\u000e\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bJ\u0010\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u000bH\u0002J\b\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\bH\u0002J\b\u0010;\u001a\u00020\u000bH\u0002J\u0006\u0010<\u001a\u00020\u000bJ\u0010\u0010=\u001a\u00020*2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020.H\u0016J\u001c\u0010A\u001a\u00020*2\u0006\u0010@\u001a\u00020.2\n\u0010,\u001a\u00060-R\u00020.H\u0016J\u0018\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020.2\u0006\u0010D\u001a\u00020EH\u0016J\u001c\u0010F\u001a\u00020*2\n\u0010,\u001a\u00060-R\u00020.2\u0006\u0010G\u001a\u00020HH\u0016J\u0012\u0010I\u001a\u00020*2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0010\u0010J\u001a\u00020*2\u0006\u0010K\u001a\u00020$H\u0016J\u0010\u0010L\u001a\u00020*2\u0006\u0010G\u001a\u00020\u000bH\u0016J\u0018\u0010M\u001a\u00020*2\u0006\u0010C\u001a\u00020.2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010N\u001a\u00020*H\u0002J\u0006\u0010O\u001a\u00020*J\u001c\u0010P\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u000b2\n\u0010,\u001a\u00060-R\u00020.H\u0002J$\u0010R\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b2\n\u0010,\u001a\u00060-R\u00020.2\u0006\u0010G\u001a\u00020HH\u0016J\u0010\u0010T\u001a\u00020*2\u0006\u0010U\u001a\u00020\u000bH\u0016J$\u0010V\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u000b2\n\u0010,\u001a\u00060-R\u00020.2\u0006\u0010G\u001a\u00020HH\u0016J$\u0010X\u001a\u00020*2\b\u0010Y\u001a\u0004\u0018\u00010.2\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010U\u001a\u00020\u000bH\u0016J\b\u0010Z\u001a\u00020*H\u0002J\u000e\u0010[\u001a\u00020(2\u0006\u0010Q\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0014j\b\u0012\u0004\u0012\u00020\b`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/CyclicLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "context", "Landroid/content/Context;", "listener", "Lcom/dw/launcher/ui/dashboard/layoutmanager/CyclicLayoutManager$OnItemSelectedListener;", "mIndicator", "Landroid/view/View;", "(Landroid/content/Context;Lcom/dw/launcher/ui/dashboard/layoutmanager/CyclicLayoutManager$OnItemSelectedListener;Landroid/view/View;)V", "mChildHeight", "", "mChildRadius", "mChildWidth", "mDeltaX", "mDeltaY", "mDirection", "mHandler", "Landroid/os/Handler;", "mNeedRecycleList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mOrientationPeeked", "mPeekTouchSlop", "mPendingToScrollPosition", "mScheduleToFinishScrollTask", "Ljava/lang/Runnable;", "mTouchDownX", "", "getMTouchDownX", "()F", "setMTouchDownX", "(F)V", "mTouchDownY", "calculateIndicatorAngle", "canScrollHorizontally", "", "canScrollVertically", "degreeToVerticalY", "degree", "", "dispatchOnItemSelected", "", "fill", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "firstPosition", "firstAngle", "deltaAngle", "findSnapView", "findTargetSnapPosition", "velocityY", "fixScroll", "fixAngle", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "getAngleForChild", "child", "getSelectedChild", "getSnapLeftViewDistance", "log", "", "onAttachedToWindow", "view", "onDetachedFromWindow", "onInterceptTouchEvent", "rv", "e", "Landroid/view/MotionEvent;", "onLayoutChildren", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onLayoutCompleted", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "onScrollStateChanged", "onTouchEvent", "removeFinishScrollTask", "scheduleToFinishScroll", "scrollBy", "delta", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "scrollVerticallyBy", "dy", "smoothScrollToPosition", "recyclerView", "transformChildren", "verticalYtoDegree", "Companion", "OnItemSelectedListener", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class CyclicLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.OnItemTouchListener {
    private static final int MAX_CHILD_COUNT = 12;
    private static final int ORIENTATION_HORIZONTAL = 0;
    private static final int ORIENTATION_UNDEFINE = -1;
    private static final int ORIENTATION_VERTICAL = 1;
    private static final int SELECTED_ANGLE = 90;
    private static final int START_ANGLE = 270;
    private static final String TAG = "CyclicLayoutManager";
    private final Context context;
    private final OnItemSelectedListener listener;
    private int mChildHeight;
    private int mChildRadius;
    private int mChildWidth;
    private int mDeltaX;
    private int mDeltaY;
    private int mDirection;
    private final Handler mHandler;
    private final View mIndicator;
    private final ArrayList<View> mNeedRecycleList;
    private int mOrientationPeeked;
    private int mPeekTouchSlop;
    private int mPendingToScrollPosition;
    private final Runnable mScheduleToFinishScrollTask;
    private float mTouchDownX;
    private float mTouchDownY;

    /* JADX INFO: compiled from: CyclicLayoutManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/CyclicLayoutManager$OnItemSelectedListener;", "", "onItemSelected", "", "position", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public interface OnItemSelectedListener {
        void onItemSelected(int position);
    }

    private final void log(String log) {
    }

    private final void removeFinishScrollTask() {
    }

    public boolean canScrollHorizontally() {
        return true;
    }

    public boolean canScrollVertically() {
        return true;
    }

    public final int findTargetSnapPosition(int velocityY) {
        return -1;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(e, "e");
    }

    public /* synthetic */ CyclicLayoutManager(Context context, OnItemSelectedListener onItemSelectedListener, View view, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, onItemSelectedListener, (i & 4) != 0 ? null : view);
    }

    public CyclicLayoutManager(Context context, OnItemSelectedListener listener, View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.context = context;
        this.listener = listener;
        this.mIndicator = view;
        this.mPendingToScrollPosition = -1;
        this.mPeekTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mOrientationPeeked = -1;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mScheduleToFinishScrollTask = new Runnable() { // from class: com.dw.launcher.ui.dashboard.layoutmanager.CyclicLayoutManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CyclicLayoutManager.mScheduleToFinishScrollTask$lambda$0(this.f$0);
            }
        };
        this.mNeedRecycleList = new ArrayList<>();
    }

    public final float getMTouchDownX() {
        return this.mTouchDownX;
    }

    public final void setMTouchDownX(float f) {
        this.mTouchDownX = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mScheduleToFinishScrollTask$lambda$0(CyclicLayoutManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onScrollStateChanged(0);
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
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

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        log("----onLayoutChildren");
        detachAndScrapAttachedViews(recycler);
        if (getItemCount() == 0) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int i = width / 2;
        int i2 = height / 2;
        int iCoerceAtMost = RangesKt.coerceAtMost(width, height) / 2;
        RangesKt.coerceAtMost(getItemCount(), 12);
        int i3 = this.mPendingToScrollPosition;
        if (i3 == -1) {
            i3 = 0;
        }
        fill(recycler, i3, START_ANGLE, 0.0f);
        View view = this.mIndicator;
        if (view != null) {
            int height2 = view.getHeight() > 0 ? view.getHeight() : this.mChildHeight;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                int i4 = ((i2 - iCoerceAtMost) + (this.mChildHeight / 2)) - (height2 / 2);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams.topMargin != i4) {
                    marginLayoutParams.topMargin = i4;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private final void fill(RecyclerView.Recycler recycler, int firstPosition, int firstAngle, float deltaAngle) {
        float f = deltaAngle;
        log("----fill, firstPosition: " + firstPosition + ", firstAngle: " + firstAngle + ", deltaAngle: " + f);
        float f2 = firstAngle;
        while (true) {
            f2 += f;
            if (f2 >= 0.0f) {
                break;
            } else {
                f = 360;
            }
        }
        float f3 = 30;
        int iFloor = (int) Math.floor(((f2 - START_ANGLE) * 1.0f) / f3);
        float f4 = f2 - (iFloor * 30);
        int itemCount = firstPosition - iFloor;
        this.mNeedRecycleList.clear();
        if (iFloor < 0) {
            int iMin = Math.min(-iFloor, 12);
            for (int i = 0; i < iMin; i++) {
                ArrayList<View> arrayList = this.mNeedRecycleList;
                View childAt = getChildAt(i);
                Intrinsics.checkNotNull(childAt);
                arrayList.add(childAt);
            }
        } else if (iFloor > 0) {
            int iMin2 = Math.min(iFloor, 12);
            for (int i2 = 0; i2 < iMin2; i2++) {
                ArrayList<View> arrayList2 = this.mNeedRecycleList;
                View childAt2 = getChildAt(11 - i2);
                Intrinsics.checkNotNull(childAt2);
                arrayList2.add(childAt2);
            }
        }
        Iterator<T> it = this.mNeedRecycleList.iterator();
        while (it.hasNext()) {
            removeAndRecycleView((View) it.next(), recycler);
        }
        int width = getWidth();
        int height = getHeight();
        int i3 = width / 2;
        int i4 = height / 2;
        int iCoerceAtMost = RangesKt.coerceAtMost(width, height) / 2;
        while (itemCount < 0) {
            itemCount += getItemCount();
        }
        int itemCount2 = itemCount % getItemCount();
        log("----firstPosition: " + itemCount2 + ", firstAngle: " + f4 + ", childCount: " + getChildCount());
        if (iFloor < 0) {
            int childCount = itemCount2 + getChildCount();
            int itemCount3 = getItemCount();
            while (true) {
                int i5 = childCount % itemCount3;
                if (getChildCount() >= 12) {
                    break;
                }
                View viewForPosition = recycler.getViewForPosition(i5);
                Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
                log("----addChild: " + i5);
                addView(viewForPosition);
                measureChild(viewForPosition, 0, 0);
                childCount = i5 + 1;
                itemCount3 = getItemCount();
            }
        } else {
            int childCount2 = ((11 - getChildCount()) + itemCount2) % getItemCount();
            while (getChildCount() < 12) {
                View viewForPosition2 = recycler.getViewForPosition(childCount2);
                Intrinsics.checkNotNullExpressionValue(viewForPosition2, "getViewForPosition(...)");
                log("----addChild: " + itemCount2);
                addView(viewForPosition2, 0);
                measureChild(viewForPosition2, 0, 0);
                childCount2--;
                while (childCount2 < 0) {
                    childCount2 += getItemCount();
                }
            }
        }
        int childCount3 = getChildCount();
        int i6 = 0;
        float f5 = f4;
        while (i6 < childCount3) {
            View childAt3 = getChildAt(i6);
            Intrinsics.checkNotNull(childAt3);
            if (this.mChildWidth <= 0 || this.mChildHeight <= 0) {
                this.mChildWidth = getDecoratedMeasuredWidth(childAt3);
                int decoratedMeasuredHeight = getDecoratedMeasuredHeight(childAt3);
                this.mChildHeight = decoratedMeasuredHeight;
                this.mChildRadius = RangesKt.coerceAtMost(this.mChildWidth, decoratedMeasuredHeight) / 2;
            }
            int i7 = this.mChildWidth;
            int i8 = this.mChildHeight;
            int i9 = iCoerceAtMost - this.mChildRadius;
            double radians = Math.toRadians(f5);
            int i10 = iCoerceAtMost;
            double d = i9;
            int iCos = (((int) (Math.cos(radians) * d)) + i3) - (i7 / 2);
            int iSin = (((int) (Math.sin(radians) * d)) + i4) - (i8 / 2);
            layoutDecorated(childAt3, iCos, iSin, iCos + i7, iSin + i8);
            log("---------4----------");
            f5 += f3;
            i6++;
            childCount3 = childCount3;
            iCoerceAtMost = i10;
        }
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        log("----onLayoutCompleted");
        super.onLayoutCompleted(state);
        transformChildren();
        this.mPendingToScrollPosition = -1;
        dispatchOnItemSelected();
    }

    private final void dispatchOnItemSelected() {
        int selectedChild = getSelectedChild();
        if (selectedChild < 0 || selectedChild >= getChildCount()) {
            return;
        }
        View childAt = getChildAt(selectedChild);
        Intrinsics.checkNotNull(childAt);
        this.listener.onItemSelected(getPosition(childAt));
    }

    public void scrollToPosition(int position) {
        this.mPendingToScrollPosition = position;
        requestLayout();
    }

    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.mOrientationPeeked == -1) {
            if (Math.abs(this.mDeltaX) < Math.abs(this.mDeltaY) && Math.abs(this.mDeltaY) >= this.mPeekTouchSlop) {
                this.mOrientationPeeked = 1;
            } else {
                this.mDeltaY += dy;
            }
        }
        int i = this.mOrientationPeeked;
        if (i == 1) {
            if (this.mTouchDownX >= getWidth() / 2.0f) {
                int i2 = -dy;
                scrollBy(i2, recycler);
                Timber.INSTANCE.e("竖值1方向: " + this.mOrientationPeeked + " dy: " + i2 + " mdeltaX: " + this.mDeltaX + "  mdeltaY: " + this.mDeltaY + " mTouchDownX: " + this.mTouchDownX + "  mTouchDownY: " + this.mTouchDownY + " 一半宽 " + (getWidth() / 2.0f), new Object[0]);
            } else {
                scrollBy(dy, recycler);
                Timber.INSTANCE.d("竖值2方向: " + this.mOrientationPeeked + " dy: " + dy + " mdeltaX: " + this.mDeltaX + "  mdeltaY: " + this.mDeltaY + " mTouchDownX: " + this.mTouchDownX + "  mTouchDownY: " + this.mTouchDownY + " 一半宽 " + (getWidth() / 2.0f), new Object[0]);
            }
        } else if (i == -1) {
            float f = this.mTouchDownX;
            if (f == 0.0f || f >= getWidth() / 2.0f) {
                scrollBy(-dy, recycler);
            } else {
                scrollBy(dy, recycler);
            }
        }
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
        if (this.mOrientationPeeked == 0) {
            if (this.mTouchDownY >= getHeight() / 2.0f) {
                scrollBy(dx, recycler);
                Timber.INSTANCE.e("横向1方向: " + this.mOrientationPeeked + " dx: " + dx + " mdeltaX: " + this.mDeltaX + "  mdeltaY: " + this.mDeltaY + "  mTouchDownX: " + this.mTouchDownX + " mTouchDownY: " + this.mTouchDownY + "  一半高：" + (getHeight() / 2.0f), new Object[0]);
            } else {
                int i = -dx;
                scrollBy(i, recycler);
                Timber.INSTANCE.d("横向2方向: " + this.mOrientationPeeked + " dx: " + i + " mdeltaX: " + this.mDeltaX + "  mdeltaY: " + this.mDeltaY + "  mTouchDownX: " + this.mTouchDownX + " mTouchDownY: " + this.mTouchDownY + "  一半高：" + (getHeight() / 2.0f), new Object[0]);
            }
        }
        return dx;
    }

    private final int scrollBy(int delta, RecyclerView.Recycler recycler) {
        int angleForChild;
        this.mDirection = delta;
        float fCoerceAtMost = (delta * 90.0f) / ((RangesKt.coerceAtMost(getWidth(), getHeight()) / 2) - this.mChildRadius);
        int position = 0;
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            Intrinsics.checkNotNull(childAt);
            position = getPosition(childAt);
            angleForChild = getAngleForChild(childAt);
        } else {
            angleForChild = START_ANGLE;
        }
        fill(recycler, position, angleForChild, fCoerceAtMost);
        transformChildren();
        dispatchOnItemSelected();
        return delta;
    }

    public final void scheduleToFinishScroll() {
        this.mHandler.postDelayed(this.mScheduleToFinishScrollTask, 100L);
    }

    private final void transformChildren() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            int angleForChild = getAngleForChild(childAt);
            if (angleForChild > 240 && angleForChild < 300) {
                float fAbs = Math.abs(angleForChild - 270) / 30;
                childAt.setScaleX(fAbs);
                childAt.setScaleY(fAbs);
                log("transformChildren: index: " + i + ", angle: " + angleForChild + " scale: " + fAbs);
            } else {
                childAt.setScaleX(1.0f);
                childAt.setScaleY(1.0f);
            }
        }
        View view = this.mIndicator;
        if (view != null) {
            view.setRotation(calculateIndicatorAngle());
        }
    }

    private final int getAngleForChild(View child) {
        double dAtan;
        int width = getWidth();
        int height = getHeight() / 2;
        int left = child.getLeft();
        int top2 = child.getTop();
        int width2 = (left + (child.getWidth() / 2)) - (width / 2);
        int i = -((top2 + (child.getHeight() / 2)) - height);
        if (width2 == 0) {
            dAtan = i > 0 ? 1.5707963267948966d : 4.71238898038469d;
        } else {
            dAtan = Math.atan(((double) i) / ((double) width2));
        }
        int degrees = (int) Math.toDegrees(dAtan);
        if (width2 < 0) {
            degrees += PduHeaders.RECOMMENDED_RETRIEVAL_MODE;
        }
        return (360 - degrees) % 360;
    }

    private final void fixScroll(int fixAngle) {
        int iCoerceAtMost = (RangesKt.coerceAtMost(getWidth(), getHeight()) / 2) - this.mChildRadius;
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            measureChild(childAt, 0, 0);
            double radians = Math.toRadians(((double) getAngleForChild(childAt)) + ((double) fixAngle));
            double d = iCoerceAtMost;
            int iCos = (int) (Math.cos(radians) * d);
            int iSin = (int) (Math.sin(radians) * d);
            int i2 = this.mChildWidth;
            int i3 = (iCos + width) - (i2 / 2);
            int i4 = this.mChildHeight;
            int i5 = (iSin + height) - (i4 / 2);
            layoutDecorated(childAt, i3, i5, i3 + i2, i5 + i4);
        }
    }

    public void onScrollStateChanged(int state) {
        View childAt;
        int angleForChild;
        this.mHandler.removeCallbacks(this.mScheduleToFinishScrollTask);
        if (state == 0) {
            this.mTouchDownX = 0.0f;
            this.mTouchDownY = 0.0f;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
            this.mOrientationPeeked = -1;
            Timber.INSTANCE.d("----变更方向:: " + state + " mOrientationPeeked: " + this.mOrientationPeeked, new Object[0]);
            int selectedChild = getSelectedChild();
            if (selectedChild >= 0 && selectedChild < getChildCount() && (childAt = getChildAt(selectedChild)) != null && (angleForChild = getAngleForChild(childAt)) != SELECTED_ANGLE) {
                fixScroll(SELECTED_ANGLE - angleForChild);
                transformChildren();
            }
            dispatchOnItemSelected();
        }
    }

    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(e, "e");
        if ((e.getAction() & 255) == 0) {
            this.mTouchDownX = e.getX();
            this.mTouchDownY = e.getY();
            this.mDeltaX = 0;
            this.mDeltaY = 0;
            Timber.INSTANCE.d("onInterceptTouchEvent: mTouchDownX: " + this.mTouchDownX + ", mTouchDownY: " + this.mTouchDownY, new Object[0]);
        } else if ((e.getAction() & 255) == 2) {
            this.mTouchDownX = e.getX();
            this.mTouchDownY = e.getY();
        }
        return false;
    }

    private final int getSelectedChild() {
        int childCount = getChildCount();
        int i = 0;
        int i2 = SELECTED_ANGLE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            Intrinsics.checkNotNull(childAt);
            int angleForChild = getAngleForChild(childAt);
            if (angleForChild == SELECTED_ANGLE) {
                return i3;
            }
            int iAbs = Math.abs(angleForChild - 90);
            if (iAbs <= i2) {
                i = i3;
                i2 = iAbs;
            }
        }
        return i;
    }

    private final float calculateIndicatorAngle() {
        if (getChildCount() < 12) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        Intrinsics.checkNotNull(childAt);
        return ((getPosition(childAt) % 12) * 30.0f) + getAngleForChild(childAt);
    }

    public final double verticalYtoDegree(int delta) {
        return (delta * 90.0f) / ((RangesKt.coerceAtMost(getWidth(), getHeight()) / 2) - this.mChildRadius);
    }

    public final int degreeToVerticalY(double degree) {
        return (int) ((((double) ((RangesKt.coerceAtMost(getWidth(), getHeight()) / 2) - this.mChildRadius)) * degree) / ((double) 90.0f));
    }

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
            if (angleForChild < 0 || angleForChild >= 91) {
                int i5 = 360 - angleForChild;
                if (i2 > Math.abs(i5)) {
                    i3 = i4;
                    view = childAt;
                    i2 = i5;
                }
            } else if (i2 > Math.abs(angleForChild)) {
                i3 = i4;
                view = childAt;
                i2 = angleForChild;
            }
            Timber.Companion companion = Timber.INSTANCE;
            StringBuilder sbAppend = new StringBuilder("----角度:").append(angleForChild).append("  位置 ");
            Intrinsics.checkNotNull(childAt);
            companion.e(sbAppend.append(getPosition(childAt)).append(" minAngle= ").append(i2).append(" left: ").append(childAt.getLeft()).append(" top: ").append(childAt.getTop()).append(' ').toString(), new Object[0]);
        }
        if (-1 <= i2 && i2 < 2) {
            return 0;
        }
        if (view != null) {
            if (this.mDirection > 0) {
                View childAt2 = getChildAt(i3);
                Intrinsics.checkNotNull(childAt2);
                int angleForChild2 = getAngleForChild(childAt2);
                i = angleForChild2 > SELECTED_ANGLE ? 360 - angleForChild2 : 30 - angleForChild2;
            } else {
                i = i2 > SELECTED_ANGLE ? -((-330) - i2) : -i2;
            }
            Timber.Companion companion2 = Timber.INSTANCE;
            StringBuilder sb = new StringBuilder("------------- 得到靠近0点位置：");
            Intrinsics.checkNotNull(view);
            StringBuilder sbAppend2 = sb.append(getPosition(view)).append(" 偏移角度：").append(i).append("  靠近0点角度： ").append(i2).append(" 偏移距离：");
            double d = i;
            companion2.d(sbAppend2.append(degreeToVerticalY(d)).append(" mDirectory:").append(this.mDirection).append("  ").toString(), new Object[0]);
            if (-1 <= i && i < 2) {
                return 0;
            }
            if (i != 0) {
                return -degreeToVerticalY(d);
            }
        }
        return -1;
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

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        Intrinsics.checkNotNull(recyclerView);
        new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.dw.launcher.ui.dashboard.layoutmanager.CyclicLayoutManager.smoothScrollToPosition.1
            public PointF computeScrollVectorForPosition(int targetPosition) {
                return super.computeScrollVectorForPosition(targetPosition);
            }

            protected void onTargetFound(View targetView, RecyclerView.State state2, RecyclerView.SmoothScroller.Action action) {
                Intrinsics.checkNotNullParameter(targetView, "targetView");
                Intrinsics.checkNotNullParameter(state2, "state");
                Intrinsics.checkNotNullParameter(action, "action");
                super.onTargetFound(targetView, state2, action);
            }
        };
    }
}
