package com.dw.launcher.ui.dashboard.layoutmanager.scroller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import timber.log.Timber;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class PagingScrollHelper {
    onPageChangeListener mOnPageChangeListener;
    RecyclerView mRecyclerView = null;
    private MyOnScrollListener mOnScrollListener = new MyOnScrollListener();
    private MyOnFlingListener mOnFlingListener = new MyOnFlingListener();
    private int offsetY = 0;
    private int offsetX = 0;
    int startY = 0;
    int startX = 0;
    private ORIENTATION mOrientation = ORIENTATION.HORIZONTAL;
    ValueAnimator mAnimator = null;
    private MyOnTouchListener mOnTouchListener = new MyOnTouchListener();
    private boolean firstTouch = true;

    enum ORIENTATION {
        HORIZONTAL,
        VERTICAL,
        NULL
    }

    public interface onPageChangeListener {
        void onPageChange(int index);
    }

    static /* synthetic */ int access$212(PagingScrollHelper pagingScrollHelper, int i) {
        int i2 = pagingScrollHelper.offsetY + i;
        pagingScrollHelper.offsetY = i2;
        return i2;
    }

    static /* synthetic */ int access$312(PagingScrollHelper pagingScrollHelper, int i) {
        int i2 = pagingScrollHelper.offsetX + i;
        pagingScrollHelper.offsetX = i2;
        return i2;
    }

    public void setUpRecycleView(RecyclerView recycleView) {
        if (recycleView == null) {
            throw new IllegalArgumentException("recycleView must be not null");
        }
        this.mRecyclerView = recycleView;
        recycleView.setOnScrollListener(this.mOnScrollListener);
        updateLayoutManger();
    }

    public void updateLayoutManger() {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager != null) {
            if (layoutManager.canScrollVertically()) {
                this.mOrientation = ORIENTATION.VERTICAL;
            } else if (layoutManager.canScrollHorizontally()) {
                this.mOrientation = ORIENTATION.HORIZONTAL;
            } else {
                this.mOrientation = ORIENTATION.NULL;
            }
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.startX = 0;
            this.startY = 0;
            this.offsetX = 0;
            this.offsetY = 0;
        }
    }

    public int getPageCount() {
        if (this.mRecyclerView == null || this.mOrientation == ORIENTATION.NULL) {
            return 0;
        }
        if (this.mOrientation == ORIENTATION.VERTICAL && this.mRecyclerView.computeVerticalScrollExtent() != 0) {
            return this.mRecyclerView.computeVerticalScrollRange() / this.mRecyclerView.computeVerticalScrollExtent();
        }
        if (this.mRecyclerView.computeHorizontalScrollExtent() != 0) {
            Log.i("zzz", "rang=" + this.mRecyclerView.computeHorizontalScrollRange() + " extent=" + this.mRecyclerView.computeHorizontalScrollExtent());
            return this.mRecyclerView.computeHorizontalScrollRange() / this.mRecyclerView.computeHorizontalScrollExtent();
        }
        return 0;
    }

    public void scrollToPosition(int position) {
        int width;
        if (this.mAnimator == null) {
            this.mOnFlingListener.onFling(0, 0);
        }
        if (this.mAnimator != null) {
            int i = this.mOrientation == ORIENTATION.VERTICAL ? this.offsetY : this.offsetX;
            if (this.mOrientation == ORIENTATION.VERTICAL) {
                width = this.mRecyclerView.getHeight();
            } else {
                width = this.mRecyclerView.getWidth();
            }
            int i2 = width * position;
            if (i != i2) {
                this.mAnimator.setIntValues(i, i2);
                this.mAnimator.start();
            }
        }
    }

    public class MyOnFlingListener extends RecyclerView.OnFlingListener {
        public MyOnFlingListener() {
        }

        public boolean onFling(int velocityX, int velocityY) {
            int i;
            int i2;
            int i3;
            int width;
            int height;
            if (PagingScrollHelper.this.mOrientation == ORIENTATION.NULL) {
                return false;
            }
            int startPageIndex = PagingScrollHelper.this.getStartPageIndex();
            if (PagingScrollHelper.this.mOrientation == ORIENTATION.VERTICAL) {
                i = PagingScrollHelper.this.offsetY;
                if (velocityY < 0) {
                    startPageIndex--;
                } else if (velocityY > 0) {
                    startPageIndex++;
                }
                height = startPageIndex * PagingScrollHelper.this.mRecyclerView.getHeight();
            } else {
                i = PagingScrollHelper.this.offsetX;
                int width2 = PagingScrollHelper.this.offsetX / PagingScrollHelper.this.mRecyclerView.getWidth();
                int width3 = PagingScrollHelper.this.offsetX % PagingScrollHelper.this.mRecyclerView.getWidth();
                if (velocityX < 0) {
                    if (width3 < PagingScrollHelper.this.mRecyclerView.getWidth() / 2) {
                        i2 = PagingScrollHelper.this.offsetX;
                    } else {
                        i3 = PagingScrollHelper.this.offsetX;
                        width = PagingScrollHelper.this.mRecyclerView.getWidth();
                        i2 = i3 + width;
                    }
                } else if (width3 > PagingScrollHelper.this.mRecyclerView.getWidth() / 2) {
                    i3 = PagingScrollHelper.this.offsetX;
                    width = PagingScrollHelper.this.mRecyclerView.getWidth();
                    i2 = i3 + width;
                } else {
                    i2 = PagingScrollHelper.this.offsetX;
                }
                int i4 = i2 - width3;
                Timber.d("currentPage=" + width2 + " currentPageOffsex=" + width3 + " startPoint=" + i + " endPoint=" + i4 + " velocityX=" + velocityX, new Object[0]);
                height = i4;
            }
            if (height < 0) {
                height = 0;
            }
            Timber.d("onFling offsetX=" + PagingScrollHelper.this.offsetX + " startPoint: " + i + " endPoint=" + height + " velocityX=" + velocityX, new Object[0]);
            if (PagingScrollHelper.this.mAnimator == null) {
                PagingScrollHelper pagingScrollHelper = PagingScrollHelper.this;
                new ValueAnimator();
                pagingScrollHelper.mAnimator = ValueAnimator.ofInt(i, height);
                PagingScrollHelper.this.mAnimator.setDuration(100L);
                PagingScrollHelper.this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.dw.launcher.ui.dashboard.layoutmanager.scroller.PagingScrollHelper.MyOnFlingListener.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int iIntValue = ((Integer) animation.getAnimatedValue()).intValue();
                        if (PagingScrollHelper.this.mOrientation == ORIENTATION.VERTICAL) {
                            PagingScrollHelper.this.mRecyclerView.scrollBy(0, iIntValue - PagingScrollHelper.this.offsetY);
                        } else {
                            PagingScrollHelper.this.mRecyclerView.scrollBy(iIntValue - PagingScrollHelper.this.offsetX, 0);
                        }
                    }
                });
                PagingScrollHelper.this.mAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.dw.launcher.ui.dashboard.layoutmanager.scroller.PagingScrollHelper.MyOnFlingListener.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (PagingScrollHelper.this.mOnPageChangeListener != null) {
                            PagingScrollHelper.this.mOnPageChangeListener.onPageChange(PagingScrollHelper.this.getPageIndex());
                        }
                        PagingScrollHelper.this.mRecyclerView.stopScroll();
                        PagingScrollHelper.this.startY = PagingScrollHelper.this.offsetY;
                        PagingScrollHelper.this.startX = PagingScrollHelper.this.offsetX;
                    }
                });
            } else {
                PagingScrollHelper.this.mAnimator.cancel();
                PagingScrollHelper.this.mAnimator.setIntValues(i, height);
            }
            PagingScrollHelper.this.mAnimator.start();
            return true;
        }
    }

    public class MyOnScrollListener extends RecyclerView.OnScrollListener {
        public MyOnScrollListener() {
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0071  */
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (newState != 0 || PagingScrollHelper.this.mOrientation == ORIENTATION.NULL) {
                return;
            }
            int i = -1000;
            int i2 = 0;
            if (PagingScrollHelper.this.mOrientation == ORIENTATION.VERTICAL) {
                if (!(Math.abs(PagingScrollHelper.this.offsetY - PagingScrollHelper.this.startY) > recyclerView.getHeight() / 2)) {
                    i = 0;
                } else if (PagingScrollHelper.this.offsetY - PagingScrollHelper.this.startY >= 0) {
                    i = 1000;
                }
            } else if (Math.abs(PagingScrollHelper.this.offsetX - PagingScrollHelper.this.startX) > recyclerView.getWidth() / 2) {
                i2 = PagingScrollHelper.this.offsetX - PagingScrollHelper.this.startX >= 0 ? 1000 : -1000;
                i = 0;
            } else {
                i = 0;
            }
            PagingScrollHelper.this.mOnFlingListener.onFling(i2, i);
        }

        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            PagingScrollHelper.access$212(PagingScrollHelper.this, dy);
            PagingScrollHelper.access$312(PagingScrollHelper.this, dx);
            Timber.d("offsetX=" + PagingScrollHelper.this.offsetX + " offsetY=" + PagingScrollHelper.this.offsetY, new Object[0]);
        }
    }

    public class MyOnTouchListener implements View.OnTouchListener {
        public MyOnTouchListener() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            if (PagingScrollHelper.this.firstTouch) {
                PagingScrollHelper.this.firstTouch = false;
                PagingScrollHelper pagingScrollHelper = PagingScrollHelper.this;
                pagingScrollHelper.startY = pagingScrollHelper.offsetY;
                PagingScrollHelper pagingScrollHelper2 = PagingScrollHelper.this;
                pagingScrollHelper2.startX = pagingScrollHelper2.offsetX;
            }
            if (event.getAction() == 1 || event.getAction() == 3) {
                PagingScrollHelper.this.firstTouch = true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPageIndex() {
        if (this.mRecyclerView.getHeight() == 0 || this.mRecyclerView.getWidth() == 0) {
            return 0;
        }
        if (this.mOrientation == ORIENTATION.VERTICAL) {
            return this.offsetY / this.mRecyclerView.getHeight();
        }
        return this.offsetX / this.mRecyclerView.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStartPageIndex() {
        if (this.mRecyclerView.getHeight() == 0 || this.mRecyclerView.getWidth() == 0) {
            return 0;
        }
        if (this.mOrientation == ORIENTATION.VERTICAL) {
            return this.startY / this.mRecyclerView.getHeight();
        }
        return this.startX / this.mRecyclerView.getWidth();
    }

    public void setOnPageChangeListener(onPageChangeListener listener) {
        this.mOnPageChangeListener = listener;
    }
}
