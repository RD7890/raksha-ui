package com.dw.launcher.ui.dashboard.layoutmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
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

/* JADX INFO: compiled from: HalfCyclicLayoutManager.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001IB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J,\u0010\u001f\u001a\u00020 2\n\u0010!\u001a\u00060\"R\u00020#2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0019H\u0002J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\tH\u0002J\b\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0006H\u0002J\b\u0010-\u001a\u00020\tH\u0002J\u0010\u0010.\u001a\u00020 2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020#H\u0016J\u001c\u00102\u001a\u00020 2\u0006\u00101\u001a\u00020#2\n\u0010!\u001a\u00060\"R\u00020#H\u0016J\u0018\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020#2\u0006\u00105\u001a\u000206H\u0016J\u001c\u00107\u001a\u00020 2\n\u0010!\u001a\u00060\"R\u00020#2\u0006\u00108\u001a\u000209H\u0016J\u0012\u0010:\u001a\u00020 2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020\u001dH\u0016J\u0010\u0010=\u001a\u00020 2\u0006\u00108\u001a\u00020\tH\u0016J\u0018\u0010>\u001a\u00020 2\u0006\u00104\u001a\u00020#2\u0006\u00105\u001a\u000206H\u0016J\b\u0010?\u001a\u00020 H\u0002J\u0006\u0010@\u001a\u00020 J\u001c\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\t2\n\u0010!\u001a\u00060\"R\u00020#H\u0002J$\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\t2\n\u0010!\u001a\u00060\"R\u00020#2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020\tH\u0016J$\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\t2\n\u0010!\u001a\u00060\"R\u00020#2\u0006\u00108\u001a\u000209H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0011j\b\u0012\u0004\u0012\u00020\u0006`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/HalfCyclicLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "context", "Landroid/content/Context;", "mIndicator", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "mChildHeight", "", "mChildRadius", "mChildWidth", "mDeltaX", "mDeltaY", "mHandler", "Landroid/os/Handler;", "mNeedRecycleList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mOrientationPeeked", "mPeekTouchSlop", "mPendingToScrollPosition", "mScheduleToFinishScrollTask", "Ljava/lang/Runnable;", "mTouchDownX", "", "mTouchDownY", "calculateIndicatorAngle", "canScrollHorizontally", "", "canScrollVertically", "fill", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "firstPosition", "firstAngle", "deltaAngle", "fixScroll", "fixAngle", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "getAngleForChild", "child", "getSelectedChild", "log", "", "onAttachedToWindow", "view", "onDetachedFromWindow", "onInterceptTouchEvent", "rv", "e", "Landroid/view/MotionEvent;", "onLayoutChildren", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onLayoutCompleted", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "onScrollStateChanged", "onTouchEvent", "removeFinishScrollTask", "scheduleToFinishScroll", "scrollBy", "delta", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "scrollVerticallyBy", "dy", "Companion", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class HalfCyclicLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.OnItemTouchListener {
    private static final int MAX_CHILD_COUNT = 10;
    private static final int ORIENTATION_HORIZONTAL = 0;
    private static final int ORIENTATION_UNDEFINE = -1;
    private static final int ORIENTATION_VERTICAL = 1;
    private static final int SELECTED_ANGLE = 90;
    private static final int START_ANGLE = 288;
    private static final String TAG = "CyclicLayoutManager";
    private final Context context;
    private int mChildHeight;
    private int mChildRadius;
    private int mChildWidth;
    private int mDeltaX;
    private int mDeltaY;
    private final Handler mHandler;
    private final View mIndicator;
    private final ArrayList<View> mNeedRecycleList;
    private int mOrientationPeeked;
    private int mPeekTouchSlop;
    private int mPendingToScrollPosition;
    private final Runnable mScheduleToFinishScrollTask;
    private float mTouchDownX;
    private float mTouchDownY;

    private final void removeFinishScrollTask() {
    }

    public boolean canScrollHorizontally() {
        return true;
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

    public /* synthetic */ HalfCyclicLayoutManager(Context context, View view, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : view);
    }

    public HalfCyclicLayoutManager(Context context, View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mIndicator = view;
        this.mPendingToScrollPosition = -1;
        this.mPeekTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mOrientationPeeked = -1;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mScheduleToFinishScrollTask = new Runnable() { // from class: com.dw.launcher.ui.dashboard.layoutmanager.HalfCyclicLayoutManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HalfCyclicLayoutManager.mScheduleToFinishScrollTask$lambda$0(this.f$0);
            }
        };
        this.mNeedRecycleList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mScheduleToFinishScrollTask$lambda$0(HalfCyclicLayoutManager this$0) {
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
        int i = this.mPendingToScrollPosition;
        if (i == -1) {
            i = 0;
        }
        fill(recycler, i, START_ANGLE, 0.0f);
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
        float f3 = 36;
        int iFloor = (int) Math.floor(((f2 - START_ANGLE) * 1.0f) / f3);
        float f4 = f2 - (iFloor * 36);
        int itemCount = firstPosition - iFloor;
        this.mNeedRecycleList.clear();
        if (iFloor < 0) {
            int iMin = Math.min(-iFloor, 10);
            for (int i = 0; i < iMin; i++) {
                ArrayList<View> arrayList = this.mNeedRecycleList;
                View childAt = getChildAt(i);
                Intrinsics.checkNotNull(childAt);
                arrayList.add(childAt);
            }
        } else if (iFloor > 0) {
            int iMin2 = Math.min(iFloor, 10);
            for (int i2 = 0; i2 < iMin2; i2++) {
                ArrayList<View> arrayList2 = this.mNeedRecycleList;
                View childAt2 = getChildAt(9 - i2);
                Intrinsics.checkNotNull(childAt2);
                arrayList2.add(childAt2);
            }
        }
        Iterator<T> it = this.mNeedRecycleList.iterator();
        while (it.hasNext()) {
            removeAndRecycleView((View) it.next(), recycler);
        }
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        while (itemCount < 0) {
            itemCount += getItemCount();
        }
        int itemCount2 = itemCount % getItemCount();
        log("----firstPosition: " + itemCount2 + ", firstAngle: " + f4 + ", childCount: " + getChildCount());
        if (iFloor < 0) {
            int childCount = itemCount2 + getChildCount();
            int itemCount3 = getItemCount();
            while (true) {
                int i3 = childCount % itemCount3;
                if (getChildCount() >= 10) {
                    break;
                }
                View viewForPosition = recycler.getViewForPosition(i3);
                Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
                log("----addChild: " + i3);
                addView(viewForPosition);
                measureChild(viewForPosition, 0, 0);
                childCount = i3 + 1;
                itemCount3 = getItemCount();
            }
        } else {
            int childCount2 = ((9 - getChildCount()) + itemCount2) % getItemCount();
            while (getChildCount() < 10) {
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
        int i4 = 0;
        float f5 = f4;
        while (i4 < childCount3) {
            View childAt3 = getChildAt(i4);
            Intrinsics.checkNotNull(childAt3);
            if (this.mChildWidth <= 0 || this.mChildHeight <= 0) {
                this.mChildWidth = getDecoratedMeasuredWidth(childAt3);
                int decoratedMeasuredHeight = getDecoratedMeasuredHeight(childAt3);
                this.mChildHeight = decoratedMeasuredHeight;
                this.mChildRadius = RangesKt.coerceAtMost(this.mChildWidth, decoratedMeasuredHeight) / 2;
            }
            int i5 = this.mChildWidth;
            int i6 = this.mChildHeight;
            int i7 = height - this.mChildRadius;
            double radians = Math.toRadians(f5);
            int i8 = childCount3;
            double d = i7;
            int iCos = (((int) (Math.cos(radians) * d)) + width) - (i5 / 2);
            int iSin = (((int) (Math.sin(radians) * d)) + height) - (i6 / 2);
            layoutDecorated(childAt3, iCos, iSin, iCos + i5, iSin + i6);
            log("---------4----------");
            f5 += f3;
            i4++;
            childCount3 = i8;
        }
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        log("----onLayoutCompleted");
        super.onLayoutCompleted(state);
        this.mPendingToScrollPosition = -1;
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
                scrollBy(-dy, recycler);
            } else {
                scrollBy(dy, recycler);
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
            } else {
                scrollBy(-dx, recycler);
            }
        }
        return dx;
    }

    private final int scrollBy(int delta, RecyclerView.Recycler recycler) {
        int angleForChild;
        int position;
        getWidth();
        float height = (delta * 90.0f) / ((getHeight() / 2) - this.mChildRadius);
        log("----scrollBy, delta: " + delta + ", deltaAngle: " + height);
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            Intrinsics.checkNotNull(childAt);
            position = getPosition(childAt);
            angleForChild = getAngleForChild(childAt);
        } else {
            angleForChild = START_ANGLE;
            position = 0;
        }
        fill(recycler, position, angleForChild, height);
        log("scrollBy: ===================================, childCount: " + getChildCount());
        log("=======================================================================================");
        if (getChildCount() > 0) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                StringBuilder sbAppend = new StringBuilder("----after fill position, index: ").append(i).append(", position: ");
                View childAt2 = getChildAt(i);
                Intrinsics.checkNotNull(childAt2);
                log(sbAppend.append(getPosition(childAt2)).toString());
            }
        }
        log("=======================================================================================");
        return delta;
    }

    public final void scheduleToFinishScroll() {
        removeFinishScrollTask();
        this.mHandler.postDelayed(this.mScheduleToFinishScrollTask, 100L);
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
        int height = (getHeight() / 2) - this.mChildRadius;
        int width = getWidth() / 2;
        int height2 = getHeight() / 2;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            measureChild(childAt, 0, 0);
            double radians = Math.toRadians(((double) getAngleForChild(childAt)) + ((double) fixAngle));
            double d = height;
            int iCos = (int) (Math.cos(radians) * d);
            int iSin = (int) (Math.sin(radians) * d);
            int i2 = this.mChildWidth;
            int i3 = (iCos + width) - (i2 / 2);
            int i4 = this.mChildHeight;
            int i5 = (iSin + height2) - (i4 / 2);
            layoutDecorated(childAt, i3, i5, i3 + i2, i5 + i4);
        }
    }

    public void onScrollStateChanged(int state) {
        View childAt;
        int angleForChild;
        log("----onScrollStateChanged: " + state);
        this.mHandler.removeCallbacks(this.mScheduleToFinishScrollTask);
        if (state == 0) {
            this.mTouchDownX = 0.0f;
            this.mTouchDownY = 0.0f;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
            this.mOrientationPeeked = -1;
            int selectedChild = getSelectedChild();
            if (selectedChild < 0 || selectedChild >= getChildCount() || (childAt = getChildAt(selectedChild)) == null || (angleForChild = getAngleForChild(childAt)) == SELECTED_ANGLE) {
                return;
            }
            fixScroll(SELECTED_ANGLE - angleForChild);
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
        return ((getPosition(childAt) % 10) * 36.0f) + getAngleForChild(childAt);
    }

    private final void log(String log) {
        Timber.INSTANCE.i(log, new Object[0]);
    }
}
