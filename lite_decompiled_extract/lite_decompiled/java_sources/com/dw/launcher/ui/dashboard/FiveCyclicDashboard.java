package com.dw.launcher.ui.dashboard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.Shortcut;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.ui.dashboard.layoutmanager.HorizontalCyclePageLayoutManager;
import com.dw.launcher.ui.dashboard.layoutmanager.scroller.PagingScrollHelper;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import java.util.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: FiveCyclicDashboard.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u00103\u001a\u00020\u0005J\b\u00104\u001a\u00020\u0005H\u0016J\u0018\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u000208H\u0016J\u0018\u00109\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u000208H\u0016J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0005H\u0016J\u0010\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000bH\u0016J\u0016\u0010?\u001a\u00020;2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001b0AH\u0016J\u001a\u0010B\u001a\u00020;2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0010\u0010G\u001a\u00020;2\u0006\u0010H\u001a\u00020\u0005H\u0002J\u001c\u0010I\u001a\u00020;2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\t¨\u0006N"}, d2 = {"Lcom/dw/launcher/ui/dashboard/FiveCyclicDashboard;", "Lcom/dw/launcher/ui/dashboard/BaseDashboard;", "Lcom/dw/launcher/ui/dashboard/layoutmanager/scroller/PagingScrollHelper$onPageChangeListener;", "()V", "MOVE_DISTANCE", "", "getMOVE_DISTANCE", "()I", "setMOVE_DISTANCE", "(I)V", "boolIsMoved", "", "getBoolIsMoved", "()Z", "setBoolIsMoved", "(Z)V", "clickCount", "getClickCount", "setClickCount", "ivbackground", "Landroid/widget/ImageView;", "getIvbackground", "()Landroid/widget/ImageView;", "setIvbackground", "(Landroid/widget/ImageView;)V", "mAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Shortcut;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "page", "getPage", "setPage", "parent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "scrollHelper", "Lcom/dw/launcher/ui/dashboard/layoutmanager/scroller/PagingScrollHelper;", "getScrollHelper", "()Lcom/dw/launcher/ui/dashboard/layoutmanager/scroller/PagingScrollHelper;", "setScrollHelper", "(Lcom/dw/launcher/ui/dashboard/layoutmanager/scroller/PagingScrollHelper;)V", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "totalScollerDistance", "getTotalScollerDistance", "setTotalScollerDistance", "getItemLayoutId", "getLayoutId", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onPageChange", "", "index", "onSensorChanged", "up", "onShortcutsChanged", "shortcuts", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "scrollToPosition", "delta", "update", "o", "Ljava/util/Observable;", "arg", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class FiveCyclicDashboard extends Hilt_FiveCyclicDashboard implements PagingScrollHelper.onPageChangeListener {
    private int MOVE_DISTANCE;
    private boolean boolIsMoved;
    private int clickCount;
    private ImageView ivbackground;
    private BaseQuickAdapter<Shortcut, BaseViewHolder> mAdapter;
    private int page;
    private ConstraintLayout parent;
    private RecyclerView recyclerView;
    private PagingScrollHelper scrollHelper = new PagingScrollHelper();

    @Inject
    public SysKeyEvent sysKeyEvent;
    private int totalScollerDistance;

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

    public final int getTotalScollerDistance() {
        return this.totalScollerDistance;
    }

    public final void setTotalScollerDistance(int i) {
        this.totalScollerDistance = i;
    }

    public final PagingScrollHelper getScrollHelper() {
        return this.scrollHelper;
    }

    public final void setScrollHelper(PagingScrollHelper pagingScrollHelper) {
        Intrinsics.checkNotNullParameter(pagingScrollHelper, "<set-?>");
        this.scrollHelper = pagingScrollHelper;
    }

    public final ImageView getIvbackground() {
        return this.ivbackground;
    }

    public final void setIvbackground(ImageView imageView) {
        this.ivbackground = imageView;
    }

    public int getLayoutId() {
        return R.layout.dashboard_five_cyclic;
    }

    public final int getItemLayoutId() {
        return R.layout.dashboard_five_cyclic_item_shortcut;
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ConstraintLayout constraintLayoutFindViewById = view.findViewById(R.id.parent);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
        this.parent = constraintLayoutFindViewById;
        this.ivbackground = (ImageView) view.findViewById(R.id.iv_background);
        this.MOVE_DISTANCE = requireContext().getResources().getDisplayMetrics().widthPixels;
        Drawable drawableLoadDrawable = loadDrawable(getWallpaperComponent().getWallpaper());
        if (drawableLoadDrawable != null && (imageView = this.ivbackground) != null) {
            imageView.setImageDrawable(drawableLoadDrawable);
        }
        RecyclerView recyclerViewFindViewById = view.findViewById(R.id.cyclic_recycler_view);
        Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = recyclerViewFindViewById;
        this.recyclerView = recyclerView;
        ConstraintLayout constraintLayout = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.addOnScrollListener(getDefaultSoundEffectListener());
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new HorizontalCyclePageLayoutManager(1, 7, getResources().getDimensionPixelOffset(R.dimen.dashboard_five_cyclic_radius)));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setHorizontalScrollBarEnabled(true);
        this.mAdapter = new AnonymousClass2(getItemLayoutId(), getShortcuts());
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        recyclerView4.setAdapter(this.mAdapter);
        PagingScrollHelper pagingScrollHelper = this.scrollHelper;
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView5 = null;
        }
        pagingScrollHelper.setUpRecycleView(recyclerView5);
        this.scrollHelper.setOnPageChangeListener(this);
        this.scrollHelper.updateLayoutManger();
        RecyclerView recyclerView6 = this.recyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView6 = null;
        }
        recyclerView6.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.dw.launcher.ui.dashboard.FiveCyclicDashboard.onViewCreated.3
            public void onScrolled(RecyclerView recyclerView7, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView7, "recyclerView");
                FiveCyclicDashboard fiveCyclicDashboard = FiveCyclicDashboard.this;
                fiveCyclicDashboard.setTotalScollerDistance(fiveCyclicDashboard.getTotalScollerDistance() - dy);
            }

            public void onScrollStateChanged(RecyclerView recyclerView7, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView7, "recyclerView");
                super.onScrollStateChanged(recyclerView7, newState);
                if (newState == 0) {
                    FiveCyclicDashboard.this.setTotalScollerDistance(0);
                } else {
                    FiveCyclicDashboard.this.setBoolIsMoved(true);
                }
            }
        });
        ConstraintLayout constraintLayout2 = this.parent;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parent");
        } else {
            constraintLayout = constraintLayout2;
        }
        showSlideUpTask((ViewGroup) constraintLayout);
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.dashboard.FiveCyclicDashboard$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: FiveCyclicDashboard.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/dw/launcher/ui/dashboard/FiveCyclicDashboard$onViewCreated$2", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Shortcut;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class AnonymousClass2 extends BaseQuickAdapter<Shortcut, BaseViewHolder> {
        AnonymousClass2(int i, List<Shortcut> list) {
            super(i, list);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void convert(BaseViewHolder holder, final Shortcut item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            int i = R.id.cyclic_item_shortcut_icon;
            Context contextRequireContext = FiveCyclicDashboard.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            holder.setImageDrawable(i, item.getLauncherIcon(contextRequireContext));
            ImageView imageView = (ImageView) holder.getView(R.id.cyclic_item_shortcut_icon);
            final FiveCyclicDashboard fiveCyclicDashboard = FiveCyclicDashboard.this;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.dashboard.FiveCyclicDashboard$onViewCreated$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FiveCyclicDashboard.AnonymousClass2.convert$lambda$0(fiveCyclicDashboard, item, view);
                }
            });
            ImageView imageView2 = (ImageView) holder.getView(R.id.cyclic_item_shortcut_icon);
            final FiveCyclicDashboard fiveCyclicDashboard2 = FiveCyclicDashboard.this;
            imageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.dashboard.FiveCyclicDashboard$onViewCreated$2$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return FiveCyclicDashboard.AnonymousClass2.convert$lambda$1(fiveCyclicDashboard2, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$0(FiveCyclicDashboard this$0, Shortcut item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.onShortcutClicked(item);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convert$lambda$1(FiveCyclicDashboard this$0, Shortcut item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.onShortcutLongClicked(item);
            return true;
        }
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onShortcutsChanged(List<Shortcut> shortcuts) {
        Intrinsics.checkNotNullParameter(shortcuts, "shortcuts");
        BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.setNewInstance(shortcuts);
            RecyclerView recyclerView = this.recyclerView;
            RecyclerView recyclerView2 = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            recyclerView.setAdapter((RecyclerView.Adapter) null);
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView2 = recyclerView3;
            }
            recyclerView2.setAdapter(this.mAdapter);
        }
    }

    public final int getMOVE_DISTANCE() {
        return this.MOVE_DISTANCE;
    }

    public final void setMOVE_DISTANCE(int i) {
        this.MOVE_DISTANCE = i;
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
        if (keyCode == 25) {
            scrollToPosition(1);
            return true;
        }
        if (keyCode == 24) {
            scrollToPosition(-1);
            return true;
        }
        RecyclerView recyclerView = null;
        if (keyCode == getSysKeyEvent().getDownKey()) {
            FragmentActivity activity = getActivity();
            if (activity != null && (window2 = activity.getWindow()) != null) {
                window2.addFlags(128);
            }
            onSensorStopped();
            this.totalScollerDistance -= this.MOVE_DISTANCE;
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.smoothScrollBy(this.totalScollerDistance, 0);
            return true;
        }
        if (keyCode == getSysKeyEvent().getUPKey()) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (window = activity2.getWindow()) != null) {
                window.addFlags(128);
            }
            onSensorStopped();
            this.totalScollerDistance += this.MOVE_DISTANCE;
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.smoothScrollBy(this.totalScollerDistance, 0);
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
            onSensorStopped();
            return true;
        }
        if (keyCode == getSysKeyEvent().getUPKey()) {
            onSensorStopped();
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

    private final void scrollToPosition(int delta) {
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        if (recyclerView.getChildCount() > 0) {
            Timber.INSTANCE.d("---scrollToPosition----开始位置 " + delta + "  ", new Object[0]);
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView2 = recyclerView3;
            }
            recyclerView2.smoothScrollToPosition(delta);
            this.clickCount = 0;
            this.boolIsMoved = true;
        }
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public boolean onSensorChanged(boolean up) {
        Window window;
        Window window2;
        try {
            cancelScreenFlagTask();
            RecyclerView recyclerView = null;
            if (!up) {
                FragmentActivity activity = getActivity();
                if (activity != null && (window2 = activity.getWindow()) != null) {
                    window2.addFlags(128);
                }
                this.totalScollerDistance -= this.MOVE_DISTANCE;
                RecyclerView recyclerView2 = this.recyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    recyclerView = recyclerView2;
                }
                recyclerView.smoothScrollBy(this.totalScollerDistance, 0);
                return true;
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (window = activity2.getWindow()) != null) {
                window.addFlags(128);
            }
            this.totalScollerDistance += this.MOVE_DISTANCE;
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.smoothScrollBy(this.totalScollerDistance, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int i) {
        this.page = i;
    }

    @Override // com.dw.launcher.ui.dashboard.layoutmanager.scroller.PagingScrollHelper.onPageChangeListener
    public void onPageChange(int index) {
        this.page = index;
    }
}
