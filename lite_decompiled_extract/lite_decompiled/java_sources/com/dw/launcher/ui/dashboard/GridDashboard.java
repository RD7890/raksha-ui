package com.dw.launcher.ui.dashboard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.Shortcut;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.ui.view.NestedScrollableHost;
import com.google.android.mms.pdu.CharacterSets;
import com.shencoder.pagergridlayoutmanager.PagerGridLayoutManager;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import java.util.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: GridDashboard.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u00101\u001a\u00020\u0003H\u0016J\u0018\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u000205H\u0016J\u0018\u00106\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u000205H\u0016J\u0010\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0016J\u0016\u00109\u001a\u00020:2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001c0<H\u0016J\u001a\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0017J\u001c\u0010B\u001a\u00020:2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010¨\u0006G"}, d2 = {"Lcom/dw/launcher/ui/dashboard/GridDashboard;", "Lcom/dw/launcher/ui/dashboard/BaseDashboard;", "mItemCount", "", "mOrientation", "(II)V", "boolIsMoved", "", "getBoolIsMoved", "()Z", "setBoolIsMoved", "(Z)V", "clickCount", "getClickCount", "()I", "setClickCount", "(I)V", "itemWidth", "ivbackground", "Landroid/widget/ImageView;", "lastTurnOnTimestamp", "", "getLastTurnOnTimestamp", "()J", "setLastTurnOnTimestamp", "(J)V", "mAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Shortcut;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "mHandler", "Landroid/os/Handler;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mStopPostionTask", "Ljava/lang/Runnable;", "pagerSnapHelper", "Landroidx/recyclerview/widget/SnapHelper;", "parent", "Lcom/dw/launcher/ui/view/NestedScrollableHost;", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "totalScollerPageDistance", "getTotalScollerPageDistance", "setTotalScollerPageDistance", "getLayoutId", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onSensorChanged", "up", "onShortcutsChanged", "", "shortcuts", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "update", "o", "Ljava/util/Observable;", "arg", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class GridDashboard extends Hilt_GridDashboard {
    private boolean boolIsMoved;
    private int clickCount;
    private int itemWidth;
    private ImageView ivbackground;
    private long lastTurnOnTimestamp;
    private BaseQuickAdapter<Shortcut, BaseViewHolder> mAdapter;
    private Handler mHandler;
    private final int mItemCount;
    private final int mOrientation;
    private RecyclerView mRecyclerView;
    private final Runnable mStopPostionTask;
    private SnapHelper pagerSnapHelper;
    private NestedScrollableHost parent;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private int totalScollerPageDistance;

    /* JADX WARN: Illegal instructions before constructor call */
    public GridDashboard() {
        int i = 0;
        this(i, i, 3, null);
    }

    public /* synthetic */ GridDashboard(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 3 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public GridDashboard(int i, int i2) {
        this.mItemCount = i;
        this.mOrientation = i2;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mStopPostionTask = new Runnable() { // from class: com.dw.launcher.ui.dashboard.GridDashboard$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GridDashboard.mStopPostionTask$lambda$7(this.f$0);
            }
        };
    }

    public final SysKeyEvent getSysKeyEvent() {
        SysKeyEvent sysKeyEvent = this.sysKeyEvent;
        if (sysKeyEvent != null) {
            return sysKeyEvent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sysKeyEvent");
        return null;
    }

    public final void setSysKeyEvent(SysKeyEvent sysKeyEvent) {
        Intrinsics.checkNotNullParameter(sysKeyEvent, "<set-?>");
        this.sysKeyEvent = sysKeyEvent;
    }

    public final long getLastTurnOnTimestamp() {
        return this.lastTurnOnTimestamp;
    }

    public final void setLastTurnOnTimestamp(long j) {
        this.lastTurnOnTimestamp = j;
    }

    public final int getTotalScollerPageDistance() {
        return this.totalScollerPageDistance;
    }

    public final void setTotalScollerPageDistance(int i) {
        this.totalScollerPageDistance = i;
    }

    public int getLayoutId() {
        return R.layout.dashboard_grid;
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerViewFindViewById = view.findViewById(R.id.grid_list);
        this.parent = (NestedScrollableHost) view.findViewById(R.id.parent);
        this.ivbackground = (ImageView) view.findViewById(R.id.iv_background);
        recyclerViewFindViewById.addOnScrollListener(getDefaultSoundEffectListener());
        this.mRecyclerView = recyclerViewFindViewById;
        int i = this.mItemCount;
        PagerGridLayoutManager pagerGridLayoutManager = new PagerGridLayoutManager(i, i, this.mOrientation);
        pagerGridLayoutManager.setHandlingSlidingConflictsEnabled(false);
        recyclerViewFindViewById.setLayoutManager(pagerGridLayoutManager);
        this.itemWidth = getResources().getDisplayMetrics().widthPixels;
        BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter = new BaseQuickAdapter<Shortcut, BaseViewHolder>(this.mItemCount == 2 ? R.layout.dashboard_grid_item_shortcut2 : R.layout.dashboard_grid_item_shortcut, getShortcuts()) { // from class: com.dw.launcher.ui.dashboard.GridDashboard.onViewCreated.1
            /* JADX INFO: Access modifiers changed from: protected */
            public void convert(BaseViewHolder holder, Shortcut item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                int i2 = R.id.dashboard_grid_item_shortcut_icon;
                Context contextRequireContext = GridDashboard.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                holder.setImageDrawable(i2, item.getLauncherIcon(contextRequireContext));
                holder.setText(R.id.dashboard_grid_item_label, item.getName());
            }
        };
        this.mAdapter = baseQuickAdapter;
        baseQuickAdapter.addChildClickViewIds(new int[]{R.id.dashboard_grid_item_shortcut_icon});
        BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter2 = this.mAdapter;
        if (baseQuickAdapter2 != null) {
            baseQuickAdapter2.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.dw.launcher.ui.dashboard.GridDashboard$$ExternalSyntheticLambda1
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter3, View view2, int i2) {
                    GridDashboard.onViewCreated$lambda$1(this.f$0, baseQuickAdapter3, view2, i2);
                }
            });
        }
        BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter3 = this.mAdapter;
        if (baseQuickAdapter3 != null) {
            baseQuickAdapter3.setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.dw.launcher.ui.dashboard.GridDashboard$$ExternalSyntheticLambda2
                public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter4, View view2, int i2) {
                    return GridDashboard.onViewCreated$lambda$3(this.f$0, baseQuickAdapter4, view2, i2);
                }
            });
        }
        recyclerViewFindViewById.setAdapter(this.mAdapter);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.dw.launcher.ui.dashboard.GridDashboard.onViewCreated.4
                public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                    Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                    super.onScrolled(recyclerView2, dx, dy);
                    GridDashboard gridDashboard = GridDashboard.this;
                    gridDashboard.setTotalScollerPageDistance(gridDashboard.getTotalScollerPageDistance() - dx);
                }

                public void onScrollStateChanged(RecyclerView recyclerView2, int newState) {
                    Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                    super.onScrollStateChanged(recyclerView2, newState);
                    if (newState == 0) {
                        GridDashboard.this.setTotalScollerPageDistance(0);
                    }
                }
            });
        }
        Drawable drawableLoadDrawable = loadDrawable(getWallpaperComponent().getWallpaper());
        if (drawableLoadDrawable != null && (imageView = this.ivbackground) != null) {
            imageView.setImageDrawable(drawableLoadDrawable);
        }
        showSlideUpTask(this.parent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(GridDashboard this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        List<Shortcut> shortcuts = this$0.getShortcuts();
        if (i < 0 || i >= shortcuts.size()) {
            return;
        }
        Shortcut shortcut = shortcuts.get(i);
        Context contextRequireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(contextRequireActivity, "requireActivity(...)");
        shortcut.onClicked(contextRequireActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$3(GridDashboard this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        List<Shortcut> shortcuts = this$0.getShortcuts();
        if (i < 0 || i >= shortcuts.size()) {
            return true;
        }
        Shortcut shortcut = shortcuts.get(i);
        Context contextRequireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(contextRequireActivity, "requireActivity(...)");
        shortcut.onLongClicked(contextRequireActivity);
        return true;
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onShortcutsChanged(List<Shortcut> shortcuts) {
        Intrinsics.checkNotNullParameter(shortcuts, "shortcuts");
        BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.setNewInstance(shortcuts);
            baseQuickAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public boolean onSensorChanged(boolean up) {
        Window window;
        try {
            cancelScreenFlagTask();
            FragmentActivity activity = getActivity();
            if (activity != null && (window = activity.getWindow()) != null) {
                window.addFlags(128);
            }
            onSensorStopped();
            if (up) {
                int i = this.totalScollerPageDistance + this.itemWidth;
                this.totalScollerPageDistance = i;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.smoothScrollBy(i, 0);
                }
            } else {
                int i2 = this.totalScollerPageDistance - this.itemWidth;
                this.totalScollerPageDistance = i2;
                RecyclerView recyclerView2 = this.mRecyclerView;
                if (recyclerView2 != null) {
                    recyclerView2.smoothScrollBy(i2, 0);
                }
            }
            this.lastTurnOnTimestamp = System.currentTimeMillis();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final int getClickCount() {
        return this.clickCount;
    }

    public final void setClickCount(int i) {
        this.clickCount = i;
    }

    public final boolean getBoolIsMoved() {
        return this.boolIsMoved;
    }

    public final void setBoolIsMoved(boolean z) {
        this.boolIsMoved = z;
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Window window;
        Window window2;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!getIsVisble()) {
            return false;
        }
        if (keyCode == getSysKeyEvent().getDownKey()) {
            FragmentActivity activity = getActivity();
            if (activity != null && (window2 = activity.getWindow()) != null) {
                window2.addFlags(128);
            }
            int i = this.totalScollerPageDistance - this.itemWidth;
            this.totalScollerPageDistance = i;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.smoothScrollBy(i, 0);
            }
            return true;
        }
        if (keyCode == getSysKeyEvent().getUPKey()) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (window = activity2.getWindow()) != null) {
                window.addFlags(128);
            }
            int i2 = this.totalScollerPageDistance + this.itemWidth;
            this.totalScollerPageDistance = i2;
            RecyclerView recyclerView2 = this.mRecyclerView;
            if (recyclerView2 != null) {
                recyclerView2.smoothScrollBy(i2, 0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!getIsVisble()) {
            return false;
        }
        if (keyCode == getSysKeyEvent().getDownKey()) {
            closeScreenFlagTask();
            return true;
        }
        if (keyCode == getSysKeyEvent().getUPKey()) {
            Timber.INSTANCE.v(" onKeyUp KEYCODE_DPAD_UP...", new Object[0]);
            closeScreenFlagTask();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard, java.util.Observer
    public void update(Observable o, Object arg) {
        ImageView imageView;
        Drawable drawableLoadDrawable = loadDrawable(getWallpaperComponent().getWallpaper());
        if (drawableLoadDrawable == null || (imageView = this.ivbackground) == null) {
            return;
        }
        imageView.setImageDrawable(drawableLoadDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mStopPostionTask$lambda$7(GridDashboard this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.clickCount != 0) {
            this$0.clickCount = 0;
            this$0.boolIsMoved = true;
        } else {
            this$0.boolIsMoved = false;
        }
        Timber.INSTANCE.e("------------滑动最终停止------clickCount=" + this$0.clickCount + "  boolIsmOved =" + this$0.boolIsMoved + " - ", new Object[0]);
    }
}
