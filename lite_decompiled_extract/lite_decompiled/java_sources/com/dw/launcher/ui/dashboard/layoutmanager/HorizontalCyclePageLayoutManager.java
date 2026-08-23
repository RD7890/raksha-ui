package com.dw.launcher.ui.dashboard.layoutmanager;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.dw.launcher.data.listener.PageDecorationLastJudge;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class HorizontalCyclePageLayoutManager extends RecyclerView.LayoutManager implements PageDecorationLastJudge {
    int columns;
    int onePageSize;
    int radius;
    int rows;
    int totalHeight = 0;
    int totalWidth = 0;
    int offsetY = 0;
    int offsetX = 0;
    private SparseArray<Rect> allItemFrames = new SparseArray<>();
    int pageSize = 0;
    final int PerItemDegree = 60;

    public boolean canScrollHorizontally() {
        return true;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return null;
    }

    public HorizontalCyclePageLayoutManager(int rows, int columns, int radius) {
        this.radius = 0;
        this.rows = rows;
        this.columns = columns;
        this.onePageSize = rows * columns;
        this.radius = radius;
    }

    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        int i = this.offsetX;
        int i2 = i + dx;
        int i3 = this.totalWidth;
        if (i2 > i3) {
            dx = i3 - i;
        } else if (i2 < 0) {
            dx = 0 - i;
        }
        this.offsetX = i + dx;
        offsetChildrenHorizontal(-dx);
        recycleAndFillItems(recycler, state);
        return dx;
    }

    private int getUsableWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int getUsableHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        if (state.isPreLayout()) {
            return;
        }
        computePageSize(state);
        this.totalWidth = (this.pageSize - 1) * getWidth();
        detachAndScrapAttachedViews(recycler);
        int itemCount = getItemCount();
        int i = 0;
        while (i < this.pageSize) {
            int i2 = 0;
            while (i2 < this.rows) {
                int i3 = 0;
                while (true) {
                    int i4 = this.columns;
                    if (i3 >= i4) {
                        break;
                    }
                    int i5 = (this.onePageSize * i) + (i4 * i2) + i3;
                    if (i5 == itemCount) {
                        i2 = this.rows;
                        i = this.pageSize;
                        break;
                    }
                    View viewForPosition = recycler.getViewForPosition(i5);
                    addView(viewForPosition);
                    measureChild(viewForPosition, 0, 0);
                    int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                    int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                    if (this.allItemFrames.get(i5) == null) {
                        new Rect();
                    }
                    this.allItemFrames.put(i5, setItemPosition(i3, i, getWidth() / 2, getHeight() / 2, decoratedMeasuredWidth, decoratedMeasuredHeight));
                    i3++;
                }
                i2++;
            }
            removeAndRecycleAllViews(recycler);
            i++;
        }
        recycleAndFillItems(recycler, state);
    }

    private Rect setItemPosition(int columns, int page, int centerX, int centerY, int width, int height) {
        Rect rect = new Rect();
        if (columns == 0) {
            float width2 = ((page * getWidth()) + centerX) - (width / 2);
            int i = height / 2;
            rect.set((int) width2, centerY - i, (int) (width + width2), centerY + i);
            return rect;
        }
        float f = this.radius;
        double radians = (float) Math.toRadians(((((columns - 1) * 60) + 270.0f) + 360.0f) % 360.0f);
        double d = f;
        int iCos = (int) (Math.cos(radians) * d);
        int iSin = (int) (Math.sin(radians) * d);
        float width3 = (((page * getWidth()) + centerX) + iCos) - (width / 2);
        float f2 = (centerY + iSin) - (height / 2);
        rect.set((int) width3, (int) f2, (int) (width + width3), (int) (height + f2));
        return rect;
    }

    private void computePageSize(RecyclerView.State state) {
        this.pageSize = (state.getItemCount() / this.onePageSize) + (state.getItemCount() % this.onePageSize == 0 ? 0 : 1);
    }

    public void onDetachedFromWindow(RecyclerView view, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(view, recycler);
        this.offsetX = 0;
        this.offsetY = 0;
    }

    private void recycleAndFillItems(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            return;
        }
        Rect rect = new Rect(getPaddingLeft() + this.offsetX, getPaddingTop(), ((getWidth() - getPaddingLeft()) - getPaddingRight()) + this.offsetX, (getHeight() - getPaddingTop()) - getPaddingBottom());
        Rect rect2 = new Rect();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            rect2.left = getDecoratedLeft(childAt);
            rect2.top = getDecoratedTop(childAt);
            rect2.right = getDecoratedRight(childAt);
            rect2.bottom = getDecoratedBottom(childAt);
            if (!Rect.intersects(rect, rect2)) {
                removeAndRecycleView(childAt, recycler);
            }
        }
        for (int i2 = 0; i2 < getItemCount(); i2++) {
            if (Rect.intersects(rect, this.allItemFrames.get(i2))) {
                View viewForPosition = recycler.getViewForPosition(i2);
                addView(viewForPosition);
                measureChildWithMargins(viewForPosition, 0, 0);
                Rect rect3 = this.allItemFrames.get(i2);
                layoutDecorated(viewForPosition, rect3.left - this.offsetX, rect3.top, rect3.right - this.offsetX, rect3.bottom);
            }
        }
    }

    public boolean isLastRow(int index) {
        if (index < 0 || index >= getItemCount()) {
            return false;
        }
        int i = this.onePageSize;
        int i2 = (index % i) + 1;
        return i2 > (this.rows - 1) * this.columns && i2 <= i;
    }

    public boolean isLastColumn(int position) {
        return position >= 0 && position < getItemCount() && (position + 1) % this.columns == 0;
    }

    public boolean isPageLast(int position) {
        return (position + 1) % this.onePageSize == 0;
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        computePageSize(state);
        return this.pageSize * getWidth();
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.offsetX;
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return getWidth();
    }
}
