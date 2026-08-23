package com.dw.launcher.ui.dashboard.layoutmanager.snaphelper;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.dw.launcher.ui.dashboard.layoutmanager.PagerGridLayoutManager;
import com.dw.launcher.ui.dashboard.layoutmanager.config.PagerConfig;
import com.dw.launcher.ui.dashboard.layoutmanager.scroller.PagerGridSmoothScroller;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PagerGridSnapHelper.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\rH\u0014J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH\u0017J\"\u0010\u0013\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0014J\"\u0010\u001b\u001a\u00020\u00182\b\b\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/snaphelper/PagerGridSnapHelper;", "Landroidx/recyclerview/widget/SnapHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "attachToRecyclerView", "", "recyclerView", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "createSnapScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "findSnapView", "findTargetSnapPosition", "", "velocityX", "velocityY", "onFling", "", "setFlingThreshold", "threshold", "snapFromFling", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class PagerGridSnapHelper extends SnapHelper {
    private final Context context;
    private RecyclerView mRecyclerView;

    public PagerGridSnapHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        super.attachToRecyclerView(recyclerView);
        Intrinsics.checkNotNull(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View targetView) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        int position = layoutManager.getPosition(targetView);
        PagerConfig.INSTANCE.Loge("findTargetSnapPosition, pos = " + position);
        return layoutManager instanceof PagerGridLayoutManager ? ((PagerGridLayoutManager) layoutManager).getSnapOffset(position) : new int[2];
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        if (layoutManager instanceof PagerGridLayoutManager) {
            return ((PagerGridLayoutManager) layoutManager).findSnapView();
        }
        return null;
    }

    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        if (layoutManager != null && (layoutManager instanceof PagerGridLayoutManager)) {
            PagerGridLayoutManager pagerGridLayoutManager = (PagerGridLayoutManager) layoutManager;
            if (pagerGridLayoutManager.canScrollHorizontally()) {
                if (velocityX > PagerConfig.INSTANCE.getFlingThreshold()) {
                    return pagerGridLayoutManager.findNextPageFirstPos();
                }
                if (velocityX < (-PagerConfig.INSTANCE.getFlingThreshold())) {
                    return pagerGridLayoutManager.findPrePageFirstPos();
                }
            } else if (pagerGridLayoutManager.canScrollVertically()) {
                if (velocityY > PagerConfig.INSTANCE.getFlingThreshold()) {
                    return pagerGridLayoutManager.findNextPageFirstPos();
                }
                if (velocityY < (-PagerConfig.INSTANCE.getFlingThreshold())) {
                    return pagerGridLayoutManager.findPrePageFirstPos();
                }
            }
        }
        return -1;
    }

    public boolean onFling(int velocityX, int velocityY) {
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return false;
        }
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        if (recyclerView2.getAdapter() == null) {
            return false;
        }
        int flingThreshold = PagerConfig.INSTANCE.getFlingThreshold();
        return (Math.abs(velocityY) > flingThreshold || Math.abs(velocityX) > flingThreshold) && snapFromFling(layoutManager, velocityX, velocityY);
    }

    private final boolean snapFromFling(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        RecyclerView.SmoothScroller smoothScrollerCreateSnapScroller;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (smoothScrollerCreateSnapScroller = createSnapScroller(layoutManager)) == null) {
            return false;
        }
        RecyclerView.SmoothScroller smoothScroller = smoothScrollerCreateSnapScroller;
        int iFindTargetSnapPosition = findTargetSnapPosition(layoutManager, velocityX, velocityY);
        if (iFindTargetSnapPosition == -1) {
            return false;
        }
        smoothScroller.setTargetPosition(iFindTargetSnapPosition);
        layoutManager.startSmoothScroll(smoothScroller);
        return true;
    }

    protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        RecyclerView recyclerView = null;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        Context context = this.context;
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        return new PagerGridSmoothScroller(context, recyclerView);
    }

    public final void setFlingThreshold(int threshold) {
        PagerConfig.INSTANCE.setFlingThreshold(threshold);
    }
}
