package com.dw.launcher.ui.dashboard.layoutmanager;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.dw.launcher.ui.dashboard.layoutmanager.config.PagerConfig;
import com.dw.launcher.ui.dashboard.layoutmanager.scroller.PagerGridSmoothScroller;
import com.google.android.mms.pdu.CharacterSets;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: PagerGridLayoutManager.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b/\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0003ijkB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ$\u0010 \u001a\u00020!2\n\u0010\"\u001a\u00060#R\u00020\u001d2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0006H\u0002J\b\u0010&\u001a\u00020\u000bH\u0016J\b\u0010'\u001a\u00020\u000bH\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0006H\u0016J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*H\u0016J\u0006\u00100\u001a\u00020\u0006J\u0006\u00101\u001a\u00020\u0006J\b\u00102\u001a\u0004\u0018\u000103J\n\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0006H\u0002J\u0006\u00108\u001a\u00020\u0006J\u0006\u00109\u001a\u00020\u0006J\b\u0010:\u001a\u00020\u0006H\u0002J\u0010\u0010;\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u0006H\u0002J\u0010\u0010<\u001a\u00020=2\u0006\u00107\u001a\u00020\u0006H\u0002J\u000e\u0010>\u001a\u00020=2\u0006\u0010.\u001a\u00020\u0006J\u0006\u0010?\u001a\u00020\u0006J\b\u0010@\u001a\u00020\u0006H\u0002J\b\u0010A\u001a\u00020\u0006H\u0002J\b\u0010B\u001a\u00020!H\u0002J\u0006\u0010C\u001a\u00020\u000bJ\u0006\u0010D\u001a\u00020!J\u0010\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020\u001dH\u0016J\u001c\u0010G\u001a\u00020!2\n\u0010\"\u001a\u00060#R\u00020\u001d2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010H\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0016J,\u0010I\u001a\u00020!2\n\u0010\"\u001a\u00060#R\u00020\u001d2\u0006\u0010)\u001a\u00020*2\u0006\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0006H\u0016J\u0010\u0010L\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0006H\u0016J\u0006\u0010M\u001a\u00020!J$\u0010N\u001a\u00020!2\n\u0010\"\u001a\u00060#R\u00020\u001d2\u0006\u0010)\u001a\u00020*2\u0006\u0010O\u001a\u00020\u000bH\u0003J$\u0010P\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u00062\n\u0010\"\u001a\u00060#R\u00020\u001d2\u0006\u0010)\u001a\u00020*H\u0016J\u000e\u0010R\u001a\u00020!2\u0006\u0010S\u001a\u00020\u0006J\u0010\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020\u0006H\u0016J$\u0010V\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u00062\n\u0010\"\u001a\u00060#R\u00020\u001d2\u0006\u0010)\u001a\u00020*H\u0016J\u000e\u0010X\u001a\u00020!2\u0006\u0010Y\u001a\u00020\u000bJ\u000e\u0010Z\u001a\u00020!2\u0006\u0010[\u001a\u00020\u000bJ\u0012\u0010\\\u001a\u00020\u00062\b\b\u0001\u0010]\u001a\u00020\u0006H\u0007J\u0010\u0010^\u001a\u00020!2\u0006\u0010_\u001a\u00020\u0006H\u0002J\u0018\u0010`\u001a\u00020!2\u0006\u0010S\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u000bH\u0002J\u0010\u0010b\u001a\u00020!2\b\u0010c\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010d\u001a\u00020!J\u0006\u0010e\u001a\u00020!J\u000e\u0010f\u001a\u00020!2\u0006\u0010S\u001a\u00020\u0006J$\u0010g\u001a\u00020!2\b\u0010h\u001a\u0004\u0018\u00010\u001d2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010U\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/PagerGridLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$ScrollVectorProvider;", "context", "Landroid/content/Context;", "mRows", "", "mColumns", "mOrientation", "(Landroid/content/Context;III)V", "mAllowContinuousScroll", "", "mChangeSelectInScrolling", "mHeightUsed", "mItemFrames", "Landroid/util/SparseArray;", "Landroid/graphics/Rect;", "mItemHeight", "mItemWidth", "mLastPageCount", "mLastPageIndex", "mMaxScrollX", "mMaxScrollY", "mOffsetX", "mOffsetY", "mOnePageSize", "mPageListener", "Lcom/dw/launcher/ui/dashboard/layoutmanager/PagerGridLayoutManager$PageListener;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mScrollState", "mWidthUsed", "addOrRemove", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "displayRect", "i", "canScrollHorizontally", "canScrollVertically", "computeHorizontalScrollOffset", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "computeHorizontalScrollRange", "computeScrollVectorForPosition", "Landroid/graphics/PointF;", "targetPosition", "computeVerticalScrollRange", "findNextPageFirstPos", "findPrePageFirstPos", "findSnapView", "Landroid/view/View;", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "getItemFrameByPosition", "pos", "getOffsetX", "getOffsetY", "getPageIndexByOffset", "getPageIndexByPos", "getPageLeftTopByPosition", "", "getSnapOffset", "getTotalPageCount", "getUsableHeight", "getUsableWidth", "initItemFrameByPositions", "isAllowContinuousScroll", "nextPage", "onAttachedToWindow", "view", "onLayoutChildren", "onLayoutCompleted", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onScrollStateChanged", "prePage", "recycleAndFillItems", "isStart", "scrollHorizontallyBy", "dx", "scrollToPage", "pageIndex", "scrollToPosition", "position", "scrollVerticallyBy", "dy", "setAllowContinuousScroll", "allowContinuousScroll", "setChangeSelectInScrolling", "changeSelectInScrolling", "setOrientationType", "orientation", "setPageCount", "pageCount", "setPageIndex", "isScrolling", "setPageListener", "pageListener", "smoothNextPage", "smoothPrePage", "smoothScrollToPage", "smoothScrollToPosition", "recyclerView", "Companion", "OrientationType", "PageListener", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class PagerGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private final Context context;
    private boolean mAllowContinuousScroll;
    private boolean mChangeSelectInScrolling;
    private int mColumns;
    private int mHeightUsed;
    private final SparseArray<Rect> mItemFrames;
    private int mItemHeight;
    private int mItemWidth;
    private int mLastPageCount;
    private int mLastPageIndex;
    private int mMaxScrollX;
    private int mMaxScrollY;
    private int mOffsetX;
    private int mOffsetY;
    private final int mOnePageSize;
    private int mOrientation;
    private PageListener mPageListener;
    private RecyclerView mRecyclerView;
    private int mRows;
    private int mScrollState;
    private int mWidthUsed;

    /* JADX INFO: compiled from: PagerGridLayoutManager.kt */
    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/PagerGridLayoutManager$OrientationType;", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public @interface OrientationType {
    }

    /* JADX INFO: compiled from: PagerGridLayoutManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/PagerGridLayoutManager$PageListener;", "", "onPageSelect", "", "pageIndex", "", "onPageSizeChanged", "pageSize", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public interface PageListener {
        void onPageSelect(int pageIndex);

        void onPageSizeChanged(int pageSize);
    }

    public PagerGridLayoutManager(Context context, int i, int i2, @OrientationType int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mRows = i;
        this.mColumns = i2;
        this.mOrientation = i3;
        this.mOnePageSize = i * i2;
        this.mItemFrames = new SparseArray<>();
        this.mChangeSelectInScrolling = true;
        this.mLastPageCount = -1;
        this.mLastPageIndex = -1;
    }

    public void onAttachedToWindow(RecyclerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAttachedToWindow(view);
        Timber.INSTANCE.i("----onAttachedToWindow", new Object[0]);
        this.mRecyclerView = view;
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.isPreLayout() || !state.didStructureChange()) {
            return;
        }
        if (getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            setPageCount(0);
            setPageIndex(0, false);
            return;
        }
        setPageCount(getTotalPageCount());
        setPageIndex(getPageIndexByOffset(), false);
        int itemCount = getItemCount() / this.mOnePageSize;
        if (getItemCount() % this.mOnePageSize != 0) {
            itemCount++;
        }
        if (canScrollHorizontally()) {
            int usableWidth = (itemCount - 1) * getUsableWidth();
            this.mMaxScrollX = usableWidth;
            this.mMaxScrollY = 0;
            if (this.mOffsetX > usableWidth) {
                this.mOffsetX = usableWidth;
            }
        } else {
            this.mMaxScrollX = 0;
            int usableHeight = (itemCount - 1) * getUsableHeight();
            this.mMaxScrollY = usableHeight;
            if (this.mOffsetY > usableHeight) {
                this.mOffsetY = usableHeight;
            }
        }
        if (this.mItemWidth <= 0) {
            this.mItemWidth = getUsableWidth() / this.mColumns;
        }
        if (this.mItemHeight <= 0) {
            this.mItemHeight = getUsableHeight() / this.mRows;
        }
        this.mWidthUsed = getUsableWidth() - this.mItemWidth;
        this.mHeightUsed = getUsableHeight() - this.mItemHeight;
        initItemFrameByPositions();
        recycleAndFillItems(recycler, state, true);
        PagerConfig.INSTANCE.Loge("Item onLayoutChildren done");
    }

    private final void initItemFrameByPositions() {
        int i = this.mOnePageSize * 2;
        if (i < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            getItemFrameByPosition(i2);
            if (i2 == i) {
                return;
            } else {
                i2++;
            }
        }
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.onLayoutCompleted(state);
        if (state.isPreLayout()) {
            return;
        }
        setPageCount(getTotalPageCount());
        setPageIndex(getPageIndexByOffset(), false);
    }

    private final void recycleAndFillItems(RecyclerView.Recycler recycler, RecyclerView.State state, boolean isStart) {
        if (state.isPreLayout()) {
            return;
        }
        Rect rect = new Rect(this.mOffsetX - this.mItemWidth, this.mOffsetY - this.mItemHeight, getUsableWidth() + this.mOffsetX + this.mItemWidth, getUsableHeight() + this.mOffsetY + this.mItemHeight);
        rect.intersect(0, 0, this.mMaxScrollX + getUsableWidth(), this.mMaxScrollY + getUsableHeight());
        int pageIndexByOffset = getPageIndexByOffset();
        int i = this.mOnePageSize;
        int i2 = (pageIndexByOffset * i) - (i * 2);
        int i3 = i2 >= 0 ? i2 : 0;
        int itemCount = (i * 4) + i3;
        if (itemCount > getItemCount()) {
            itemCount = getItemCount();
        }
        detachAndScrapAttachedViews(recycler);
        if (isStart) {
            while (i3 < itemCount) {
                addOrRemove(recycler, rect, i3);
                i3++;
            }
        } else {
            int i4 = itemCount - 1;
            if (i3 > i4) {
                return;
            }
            while (true) {
                addOrRemove(recycler, rect, i4);
                if (i4 == i3) {
                    return;
                } else {
                    i4--;
                }
            }
        }
    }

    private final void addOrRemove(RecyclerView.Recycler recycler, Rect displayRect, int i) {
        View viewForPosition = recycler.getViewForPosition(i);
        Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
        Rect itemFrameByPosition = getItemFrameByPosition(i);
        if (!Rect.intersects(displayRect, itemFrameByPosition)) {
            removeAndRecycleView(viewForPosition, recycler);
            return;
        }
        addView(viewForPosition);
        measureChildWithMargins(viewForPosition, this.mWidthUsed, this.mHeightUsed);
        RecyclerView.LayoutParams layoutParams = viewForPosition.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams layoutParams2 = layoutParams;
        layoutDecorated(viewForPosition, (itemFrameByPosition.left - this.mOffsetX) + layoutParams2.leftMargin + getPaddingLeft(), (itemFrameByPosition.top - this.mOffsetY) + layoutParams2.topMargin + getPaddingTop(), ((itemFrameByPosition.right - this.mOffsetX) - layoutParams2.rightMargin) + getPaddingLeft(), ((itemFrameByPosition.bottom - this.mOffsetY) - layoutParams2.bottomMargin) + getPaddingTop());
    }

    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        int i = this.mOffsetX;
        int i2 = i + dx;
        int i3 = this.mMaxScrollX;
        if (i2 > i3) {
            dx = i3 - i;
        } else if (i2 < 0) {
            dx = 0 - i;
        }
        this.mOffsetX = i + dx;
        setPageIndex(getPageIndexByOffset(), true);
        offsetChildrenHorizontal(-dx);
        if (dx > 0) {
            recycleAndFillItems(recycler, state, true);
        } else {
            recycleAndFillItems(recycler, state, false);
        }
        return dx;
    }

    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        int i = this.mOffsetY;
        int i2 = i + dy;
        int i3 = this.mMaxScrollY;
        if (i2 > i3) {
            dy = i3 - i;
        } else if (i2 < 0) {
            dy = 0 - i;
        }
        this.mOffsetY = i + dy;
        setPageIndex(getPageIndexByOffset(), true);
        offsetChildrenVertical(-dy);
        if (dy > 0) {
            recycleAndFillItems(recycler, state, true);
        } else {
            recycleAndFillItems(recycler, state, false);
        }
        return dy;
    }

    public void onScrollStateChanged(int state) {
        this.mScrollState = state;
        super.onScrollStateChanged(state);
        if (state == 0) {
            setPageIndex(getPageIndexByOffset(), false);
        }
    }

    private final Rect getItemFrameByPosition(int pos) {
        int usableHeight;
        Rect rect = this.mItemFrames.get(pos);
        if (rect == null) {
            rect = new Rect();
            int i = pos / this.mOnePageSize;
            int usableWidth = 0;
            if (canScrollHorizontally()) {
                usableWidth = getUsableWidth() * i;
                usableHeight = 0;
            } else {
                usableHeight = getUsableHeight() * i;
            }
            int i2 = pos % this.mOnePageSize;
            int i3 = this.mColumns;
            int i4 = i2 / i3;
            int i5 = usableWidth + ((i2 - (i3 * i4)) * this.mItemWidth);
            int i6 = usableHeight + (i4 * this.mItemHeight);
            rect.left = i5;
            rect.top = i6;
            rect.right = i5 + this.mItemWidth;
            rect.bottom = i6 + this.mItemHeight;
            this.mItemFrames.put(pos, rect);
        }
        return rect;
    }

    private final int getUsableWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private final int getUsableHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public final int getTotalPageCount() {
        if (getItemCount() <= 0) {
            return 0;
        }
        int itemCount = getItemCount() / this.mOnePageSize;
        return getItemCount() % this.mOnePageSize != 0 ? itemCount + 1 : itemCount;
    }

    private final int getPageIndexByPos(int pos) {
        return pos / this.mOnePageSize;
    }

    private final int getPageIndexByOffset() {
        int i;
        if (canScrollVertically()) {
            int usableHeight = getUsableHeight();
            int i2 = this.mOffsetY;
            if (i2 <= 0 || usableHeight <= 0) {
                return 0;
            }
            i = i2 / usableHeight;
            if (i2 % usableHeight <= usableHeight / 2) {
                return i;
            }
        } else {
            int usableWidth = getUsableWidth();
            int i3 = this.mOffsetX;
            if (i3 <= 0 || usableWidth <= 0) {
                return 0;
            }
            i = i3 / usableWidth;
            if (i3 % usableWidth <= usableWidth / 2) {
                return i;
            }
        }
        return i + 1;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthMeasureSpec, int heightMeasureSpec) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onMeasure(recycler, state, widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        if (mode != 1073741824 && size > 0) {
            mode = 1073741824;
        }
        if (mode2 != 1073741824 && size2 > 0) {
            mode2 = 1073741824;
        }
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (getChildCount() == 0 || !canScrollHorizontally()) {
            return 0;
        }
        return ((int) Math.ceil((getItemCount() * 1.0f) / this.mOnePageSize)) * getWidth();
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (getChildCount() == 0 || !canScrollVertically()) {
            return 0;
        }
        return ((int) Math.ceil((getItemCount() * 1.0f) / this.mOnePageSize)) * getHeight();
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (getChildCount() == 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        Intrinsics.checkNotNull(childAt);
        return ((getPosition(childAt) / this.mColumns) * childAt.getWidth()) + getDecoratedLeft(childAt);
    }

    public final int findNextPageFirstPos() {
        int totalPageCount = this.mLastPageIndex + 1;
        if (totalPageCount >= getTotalPageCount()) {
            totalPageCount = getTotalPageCount() - 1;
        }
        PagerConfig.INSTANCE.Loge("computeScrollVectorForPosition next = " + totalPageCount);
        return totalPageCount * this.mOnePageSize;
    }

    public final int findPrePageFirstPos() {
        int i = this.mLastPageIndex - 1;
        PagerConfig.INSTANCE.Loge("computeScrollVectorForPosition pre = " + i);
        if (i < 0) {
            i = 0;
        }
        PagerConfig.INSTANCE.Loge("computeScrollVectorForPosition pre = " + i);
        return i * this.mOnePageSize;
    }

    /* JADX INFO: renamed from: getOffsetX, reason: from getter */
    public final int getMOffsetX() {
        return this.mOffsetX;
    }

    /* JADX INFO: renamed from: getOffsetY, reason: from getter */
    public final int getMOffsetY() {
        return this.mOffsetY;
    }

    public PointF computeScrollVectorForPosition(int targetPosition) {
        PointF pointF = new PointF();
        int[] snapOffset = getSnapOffset(targetPosition);
        pointF.x = snapOffset[0];
        pointF.y = snapOffset[1];
        return pointF;
    }

    public final int[] getSnapOffset(int targetPosition) {
        int[] pageLeftTopByPosition = getPageLeftTopByPosition(targetPosition);
        return new int[]{pageLeftTopByPosition[0] - this.mOffsetX, pageLeftTopByPosition[1] - this.mOffsetY};
    }

    private final int[] getPageLeftTopByPosition(int pos) {
        int[] iArr = new int[2];
        int pageIndexByPos = getPageIndexByPos(pos);
        if (canScrollHorizontally()) {
            iArr[0] = pageIndexByPos * getUsableWidth();
            iArr[1] = 0;
        } else {
            iArr[0] = 0;
            iArr[1] = pageIndexByPos * getUsableHeight();
        }
        return iArr;
    }

    public final View findSnapView() {
        if (getFocusedChild() != null) {
            return getFocusedChild();
        }
        if (getChildCount() <= 0) {
            return null;
        }
        int pageIndexByOffset = getPageIndexByOffset() * this.mOnePageSize;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            if (getPosition(childAt) == pageIndexByOffset) {
                return getChildAt(i);
            }
        }
        return getChildAt(0);
    }

    private final void setPageCount(int pageCount) {
        if (pageCount >= 0) {
            PageListener pageListener = this.mPageListener;
            if (pageListener != null && pageCount != this.mLastPageCount) {
                Intrinsics.checkNotNull(pageListener);
                pageListener.onPageSizeChanged(pageCount);
            }
            this.mLastPageCount = pageCount;
        }
    }

    private final void setPageIndex(int pageIndex, boolean isScrolling) {
        PageListener pageListener;
        if (pageIndex == this.mLastPageIndex) {
            return;
        }
        if (getMAllowContinuousScroll() || !isScrolling) {
            this.mLastPageIndex = pageIndex;
        }
        if (!isScrolling || this.mChangeSelectInScrolling) {
            if (pageIndex >= 0 && (pageListener = this.mPageListener) != null) {
                Intrinsics.checkNotNull(pageListener);
                pageListener.onPageSelect(pageIndex);
            }
            PagerConfig.INSTANCE.Loge("setPageIndex = " + pageIndex + ':' + isScrolling + ", done");
        }
    }

    public final void setChangeSelectInScrolling(boolean changeSelectInScrolling) {
        this.mChangeSelectInScrolling = changeSelectInScrolling;
    }

    @OrientationType
    public final int setOrientationType(@OrientationType int orientation) {
        int i = this.mOrientation;
        if (i == orientation || this.mScrollState != 0) {
            return i;
        }
        this.mOrientation = orientation;
        SparseArray<Rect> sparseArray = this.mItemFrames;
        Intrinsics.checkNotNull(sparseArray);
        sparseArray.clear();
        int i2 = this.mOffsetX;
        this.mOffsetX = (this.mOffsetY / getUsableHeight()) * getUsableWidth();
        this.mOffsetY = (i2 / getUsableWidth()) * getUsableHeight();
        int i3 = this.mMaxScrollX;
        this.mMaxScrollX = (this.mMaxScrollY / getUsableHeight()) * getUsableWidth();
        this.mMaxScrollY = (i3 / getUsableWidth()) * getUsableHeight();
        return this.mOrientation;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        smoothScrollToPage(getPageIndexByPos(position));
    }

    public final void smoothPrePage() {
        smoothScrollToPage(getPageIndexByOffset() - 1);
    }

    public final void smoothNextPage() {
        smoothScrollToPage(getPageIndexByOffset() + 1);
    }

    public final void smoothScrollToPage(int pageIndex) {
        if (pageIndex < 0 || pageIndex >= this.mLastPageCount) {
            Timber.INSTANCE.e("pageIndex is outOfIndex, must in [0, " + this.mLastPageCount + ").", new Object[0]);
            return;
        }
        if (this.mRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        }
        int pageIndexByOffset = getPageIndexByOffset();
        if (Math.abs(pageIndex - pageIndexByOffset) > 3) {
            if (pageIndex > pageIndexByOffset) {
                scrollToPage(pageIndex - 3);
            } else if (pageIndex < pageIndexByOffset) {
                scrollToPage(pageIndex + 3);
            }
        }
        Context context = this.context;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        PagerGridSmoothScroller pagerGridSmoothScroller = new PagerGridSmoothScroller(context, recyclerView);
        pagerGridSmoothScroller.setTargetPosition(pageIndex * this.mOnePageSize);
        startSmoothScroll((RecyclerView.SmoothScroller) pagerGridSmoothScroller);
    }

    public void scrollToPosition(int position) {
        scrollToPage(getPageIndexByPos(position));
    }

    public final void prePage() {
        scrollToPage(getPageIndexByOffset() - 1);
    }

    public final void nextPage() {
        scrollToPage(getPageIndexByOffset() + 1);
    }

    public final void scrollToPage(int pageIndex) {
        int usableWidth;
        int usableHeight;
        if (pageIndex < 0 || pageIndex >= this.mLastPageCount) {
            Timber.INSTANCE.e("pageIndex = " + pageIndex + " is out of bounds, mast in [0, " + this.mLastPageCount + ')', new Object[0]);
            return;
        }
        if (this.mRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        }
        if (canScrollVertically()) {
            usableHeight = (getUsableHeight() * pageIndex) - this.mOffsetY;
            usableWidth = 0;
        } else {
            usableWidth = (getUsableWidth() * pageIndex) - this.mOffsetX;
            usableHeight = 0;
        }
        PagerConfig.INSTANCE.Loge("mTargetOffsetXBy = " + usableWidth);
        PagerConfig.INSTANCE.Loge("mTargetOffsetYBy = " + usableHeight);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.scrollBy(usableWidth, usableHeight);
        setPageIndex(pageIndex, false);
    }

    /* JADX INFO: renamed from: isAllowContinuousScroll, reason: from getter */
    public final boolean getMAllowContinuousScroll() {
        return this.mAllowContinuousScroll;
    }

    public final void setAllowContinuousScroll(boolean allowContinuousScroll) {
        this.mAllowContinuousScroll = allowContinuousScroll;
    }

    public final void setPageListener(PageListener pageListener) {
        this.mPageListener = pageListener;
    }
}
