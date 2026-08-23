package com.dw.launcher.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.dw.launcher.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class PageGridView extends ForbidTopRecyclerView {
    int Target;
    int currentPage;
    long dTime;
    int dX;
    int dY;
    boolean isAuto;
    int lastPage;
    private int mColums;
    private int mOnePageSize;
    private int mPageSize;
    private int mRows;
    private int mWidth;
    private boolean needReorder;
    private OnItemClickListener onItemClickListener;
    private List<OnPageChangeListener> onPageChangeListenerList;
    private boolean pageIndicaotrNeedInit;
    private PageIndicator pageIndicator;
    int scrollX;

    public interface OnItemClickListener {
        void onItemClick(PageGridView pageGridView, int position);
    }

    public interface OnPageChangeListener {
        void onPageChanged(int index);
    }

    public interface PageIndicator {
        void InitIndicatorItems(int itemsNumber);

        void onPageSelected(int pageIndex);

        void onPageUnSelected(int pageIndex);
    }

    public static abstract class PagingAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
        public abstract List getData();

        public abstract Object getEmpty();
    }

    public PageGridView(Context context) {
        this(context, null);
    }

    public PageGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageGridView(Context context, AttributeSet attrs, int defStyle) {
        int i;
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        super(context, attrs, defStyle);
        this.mRows = 0;
        this.mColums = 0;
        this.mPageSize = 0;
        this.mOnePageSize = 0;
        this.mWidth = -1;
        this.needReorder = false;
        this.pageIndicaotrNeedInit = false;
        this.scrollX = 0;
        this.isAuto = false;
        this.Target = 0;
        this.currentPage = 0;
        this.lastPage = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.PageGridView);
        this.mRows = typedArrayObtainStyledAttributes.getInteger(R.styleable.PageGridView_PagingRows, 0);
        this.mColums = typedArrayObtainStyledAttributes.getInteger(R.styleable.PageGridView_PagingColums, 0);
        typedArrayObtainStyledAttributes.getDrawable(R.styleable.PageGridView_PagingDiver);
        int i2 = this.mRows;
        if (i2 < 0 || (i = this.mColums) < 0) {
            throw new RuntimeException("行数或列数不能为负数");
        }
        if (i2 == 0 && i == 0) {
            throw new RuntimeException("行数和列数不能都为0");
        }
        if (i2 > 0) {
            if (i > 0) {
                this.needReorder = true;
                addOnScrollListener(new PagingScrollListener());
            }
            staggeredGridLayoutManager = new StaggeredGridLayoutManager(this.mRows, 1);
        } else {
            staggeredGridLayoutManager = new StaggeredGridLayoutManager(this.mColums, 1);
        }
        typedArrayObtainStyledAttributes.recycle();
        setLayoutManager(staggeredGridLayoutManager);
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        this.mWidth = getWidth();
    }

    public final void setAdapter(RecyclerView.Adapter adapter) {
        if (this.needReorder) {
            if (!(adapter instanceof PagingAdapter)) {
                throw new RuntimeException("must use PagingAdapter");
            }
            PagingAdapter pagingAdapter = (PagingAdapter) adapter;
            List data = pagingAdapter.getData();
            ArrayList arrayList = new ArrayList();
            this.mOnePageSize = this.mRows * this.mColums;
            this.mPageSize = data.size() / this.mOnePageSize;
            if (data.size() % this.mOnePageSize != 0) {
                this.mPageSize++;
            }
            for (int i = 0; i < this.mPageSize; i++) {
                for (int i2 = 0; i2 < this.mColums; i2++) {
                    for (int i3 = 0; i3 < this.mRows; i3++) {
                        int i4 = (this.mColums * i3) + i2 + (this.mOnePageSize * i);
                        if (i4 > data.size() - 1) {
                            arrayList.add(pagingAdapter.getEmpty());
                        } else {
                            arrayList.add(data.get(i4));
                        }
                    }
                }
            }
            data.clear();
            data.addAll(arrayList);
        }
        super.setAdapter(adapter);
        PageIndicator pageIndicator = this.pageIndicator;
        if (pageIndicator != null && this.pageIndicaotrNeedInit) {
            pageIndicator.InitIndicatorItems(this.mPageSize);
            this.pageIndicator.onPageSelected(0);
            this.pageIndicaotrNeedInit = false;
        }
        List<OnPageChangeListener> list = this.onPageChangeListenerList;
        if (list != null) {
            Iterator<OnPageChangeListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onPageChanged(0);
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        int positionByXY;
        if (this.onItemClickListener != null) {
            int action = ev.getAction();
            if (action == 0) {
                this.dX = (int) ev.getRawX();
                this.dY = (int) ev.getRawY();
                this.dTime = System.currentTimeMillis();
            } else if (action == 1) {
                int iAbs = (int) Math.abs(ev.getRawX() - this.dX);
                int iAbs2 = (int) Math.abs(ev.getRawY() - this.dY);
                int iCurrentTimeMillis = (int) (System.currentTimeMillis() - this.dTime);
                if (iAbs <= 10 && iAbs2 <= 10 && iCurrentTimeMillis < 200 && (positionByXY = getPositionByXY((int) ev.getRawX(), (int) ev.getRawY())) != -1) {
                    this.onItemClickListener.onItemClick(this, positionByXY);
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    private int getPositionByXY(int x, int y) {
        Rect rect = new Rect();
        int i = 0;
        while (true) {
            if (i >= getChildCount()) {
                i = -1;
                break;
            }
            getChildAt(i).getGlobalVisibleRect(rect);
            if (rect.contains(x, y)) {
                break;
            }
            i++;
        }
        return this.mRows > 0 ? i + getChildPosition(getLayoutManager().getChildAt(0)) : i;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void setPageIndicator(PageIndicator pageIndicator) {
        this.pageIndicator = pageIndicator;
        this.pageIndicaotrNeedInit = true;
        if (getAdapter() == null || !this.needReorder) {
            return;
        }
        pageIndicator.InitIndicatorItems(this.mPageSize);
        pageIndicator.onPageSelected(this.currentPage);
        this.pageIndicaotrNeedInit = false;
    }

    public void addOnPageChangeListener(OnPageChangeListener listener) {
        if (this.onPageChangeListenerList == null) {
            this.onPageChangeListenerList = new ArrayList();
        }
        this.onPageChangeListenerList.add(listener);
    }

    public void removeOnPageChangeListener(OnPageChangeListener listener) {
        List<OnPageChangeListener> list = this.onPageChangeListenerList;
        if (list != null) {
            list.remove(listener);
        }
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public class PagingScrollListener extends RecyclerView.OnScrollListener {
        public PagingScrollListener() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (newState != 0) {
                if (newState == 2) {
                    PageGridView.this.isAuto = false;
                    PageGridView pageGridView = PageGridView.this;
                    pageGridView.lastPage = pageGridView.currentPage;
                    return;
                }
                return;
            }
            if (PageGridView.this.isAuto) {
                return;
            }
            int width = PageGridView.this.scrollX / PageGridView.this.getWidth();
            if (PageGridView.this.scrollX % PageGridView.this.getWidth() > PageGridView.this.getWidth() / 2) {
                width++;
            }
            PageGridView pageGridView2 = PageGridView.this;
            pageGridView2.Target = pageGridView2.getWidth() * width;
            PageGridView.this.isAuto = true;
            PageGridView.this.currentPage = width;
            if (PageGridView.this.pageIndicator != null) {
                PageGridView.this.pageIndicator.onPageUnSelected(PageGridView.this.lastPage);
                PageGridView.this.pageIndicator.onPageSelected(PageGridView.this.currentPage);
            }
            if (PageGridView.this.onPageChangeListenerList != null) {
                Iterator it = PageGridView.this.onPageChangeListenerList.iterator();
                while (it.hasNext()) {
                    ((OnPageChangeListener) it.next()).onPageChanged(PageGridView.this.currentPage);
                }
            }
            recyclerView.smoothScrollBy(PageGridView.this.Target - PageGridView.this.scrollX, 0);
        }

        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            PageGridView.this.scrollX += dx;
        }
    }

    public static class DividerGridItemDecoration extends RecyclerView.ItemDecoration {
        private static final int[] ATTRS = {android.R.attr.listDivider};
        private Drawable mDivider;

        public DividerGridItemDecoration(Drawable diver) {
            this.mDivider = diver;
        }

        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            drawHorizontal(c, parent);
            drawVertical(c, parent);
        }

        private int getSpanCount(RecyclerView parent) {
            GridLayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                return layoutManager.getSpanCount();
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
            }
            return -1;
        }

        public void drawHorizontal(Canvas c, RecyclerView parent) {
            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = parent.getChildAt(i);
                RecyclerView.LayoutParams layoutParams = childAt.getLayoutParams();
                int left = childAt.getLeft() - layoutParams.leftMargin;
                int right = childAt.getRight() + layoutParams.rightMargin + this.mDivider.getIntrinsicWidth();
                int bottom = childAt.getBottom() + layoutParams.bottomMargin;
                this.mDivider.setBounds(left, bottom, right, this.mDivider.getIntrinsicHeight() + bottom);
                this.mDivider.draw(c);
            }
        }

        public void drawVertical(Canvas c, RecyclerView parent) {
            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = parent.getChildAt(i);
                RecyclerView.LayoutParams layoutParams = childAt.getLayoutParams();
                int top2 = childAt.getTop() - layoutParams.topMargin;
                int bottom = childAt.getBottom() + layoutParams.bottomMargin;
                int right = childAt.getRight() + layoutParams.rightMargin;
                this.mDivider.setBounds(right, top2, this.mDivider.getIntrinsicWidth() + right, bottom);
                this.mDivider.draw(c);
            }
        }

        private boolean isLastColum(RecyclerView parent, int pos, int spanCount, int childCount) {
            StaggeredGridLayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                return (pos + 1) % spanCount == 0;
            }
            if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
                return false;
            }
            if (layoutManager.getOrientation() == 1) {
                return (pos + 1) % spanCount == 0;
            }
            return pos >= childCount - (childCount % spanCount);
        }

        private boolean isLastRaw(RecyclerView parent, int pos, int spanCount, int childCount) {
            StaggeredGridLayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                return pos >= childCount - (childCount % spanCount);
            }
            if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
                return false;
            }
            if (layoutManager.getOrientation() == 1) {
                return pos >= childCount - (childCount % spanCount);
            }
            return (pos + 1) % spanCount == 0;
        }

        public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
            int spanCount = getSpanCount(parent);
            int itemCount = parent.getAdapter().getItemCount();
            if (isLastRaw(parent, itemPosition, spanCount, itemCount)) {
                outRect.set(0, 0, this.mDivider.getIntrinsicWidth(), 0);
            } else if (isLastColum(parent, itemPosition, spanCount, itemCount)) {
                outRect.set(0, 0, 0, this.mDivider.getIntrinsicHeight());
            } else {
                outRect.set(0, 0, this.mDivider.getIntrinsicWidth(), this.mDivider.getIntrinsicHeight());
            }
        }
    }
}
