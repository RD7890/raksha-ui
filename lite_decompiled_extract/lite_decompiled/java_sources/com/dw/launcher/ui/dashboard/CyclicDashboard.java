package com.dw.launcher.ui.dashboard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.Shortcut;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.ui.dashboard.layoutmanager.CyclicLayoutManager;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import java.util.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: CyclicDashboard.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010<\u001a\u00020\u0011J\b\u0010=\u001a\u00020\u0011H\u0016J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0005J\u0010\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020\u0011H\u0016J\u0018\u0010C\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u00112\u0006\u0010E\u001a\u00020FH\u0016J\u0018\u0010G\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u00112\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u000bH\u0016J\u0016\u0010J\u001a\u00020?2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020'0LH\u0016J\u001a\u0010M\u001a\u00020?2\u0006\u0010N\u001a\u00020*2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0010\u0010Q\u001a\u00020?2\u0006\u0010R\u001a\u00020\u0011H\u0002J\u0006\u0010S\u001a\u00020?J\u001c\u0010T\u001a\u00020?2\b\u0010U\u001a\u0004\u0018\u00010V2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\u0012\u0010Y\u001a\u00020?2\b\u0010Z\u001a\u0004\u0018\u00010'H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001c\u0010%\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0013\"\u0004\b;\u0010\u0015¨\u0006["}, d2 = {"Lcom/dw/launcher/ui/dashboard/CyclicDashboard;", "Lcom/dw/launcher/ui/dashboard/BaseDashboard;", "Lcom/dw/launcher/ui/dashboard/layoutmanager/CyclicLayoutManager$OnItemSelectedListener;", "()V", "MOVE_DISTANCE", "", "getMOVE_DISTANCE", "()F", "setMOVE_DISTANCE", "(F)V", "boolIsMoved", "", "getBoolIsMoved", "()Z", "setBoolIsMoved", "(Z)V", "clickCount", "", "getClickCount", "()I", "setClickCount", "(I)V", "ivbackground", "Landroid/widget/ImageView;", "getIvbackground", "()Landroid/widget/ImageView;", "setIvbackground", "(Landroid/widget/ImageView;)V", "lastKeyDownStamp", "", "getLastKeyDownStamp", "()J", "setLastKeyDownStamp", "(J)V", "lastTurnOnTimestamp", "getLastTurnOnTimestamp", "setLastTurnOnTimestamp", "mAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Shortcut;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "mIndicateView", "Landroid/view/View;", "mIvSelectedIcon", "mSelectedShortcut", "mTvSelectedLabel", "Landroid/widget/TextView;", "parent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "totalScollerDistance", "getTotalScollerDistance", "setTotalScollerDistance", "getItemLayoutId", "getLayoutId", "move", "", "value", "onItemSelected", "position", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onSensorChanged", "up", "onShortcutsChanged", "shortcuts", "", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "scrollToPosition", "delta", "stopScroll", "update", "o", "Ljava/util/Observable;", "arg", "", "updateSelected", "shortcut", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class CyclicDashboard extends Hilt_CyclicDashboard implements CyclicLayoutManager.OnItemSelectedListener {
    private float MOVE_DISTANCE = 30.0f;
    private boolean boolIsMoved;
    private int clickCount;
    private ImageView ivbackground;
    private long lastKeyDownStamp;
    private long lastTurnOnTimestamp;
    private BaseQuickAdapter<Shortcut, BaseViewHolder> mAdapter;
    private View mIndicateView;
    private ImageView mIvSelectedIcon;
    private Shortcut mSelectedShortcut;
    private TextView mTvSelectedLabel;
    private ConstraintLayout parent;
    private RecyclerView recyclerView;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private int totalScollerDistance;

    public final long getLastTurnOnTimestamp() {
        return this.lastTurnOnTimestamp;
    }

    public final void setLastTurnOnTimestamp(long j) {
        this.lastTurnOnTimestamp = j;
    }

    public final int getTotalScollerDistance() {
        return this.totalScollerDistance;
    }

    public final void setTotalScollerDistance(int i) {
        this.totalScollerDistance = i;
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

    public final ImageView getIvbackground() {
        return this.ivbackground;
    }

    public final void setIvbackground(ImageView imageView) {
        this.ivbackground = imageView;
    }

    public int getLayoutId() {
        return R.layout.dashboard_cyclic;
    }

    public final int getItemLayoutId() {
        return R.layout.dashboard_cyclic_item_shortcut;
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.cyclic_selected_shortcut_label);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mTvSelectedLabel = (TextView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.cyclic_selected_shortcut);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mIvSelectedIcon = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.cyclic_indicate);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.mIndicateView = viewFindViewById3;
        ConstraintLayout constraintLayoutFindViewById = view.findViewById(R.id.parent);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
        this.parent = constraintLayoutFindViewById;
        this.ivbackground = (ImageView) view.findViewById(R.id.iv_background);
        ImageView imageView2 = this.mIvSelectedIcon;
        ConstraintLayout constraintLayout = null;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvSelectedIcon");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.dashboard.CyclicDashboard$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CyclicDashboard.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        this.MOVE_DISTANCE = getResources().getDimensionPixelOffset(R.dimen.circle_one_menu);
        RecyclerView recyclerViewFindViewById = view.findViewById(R.id.cyclic_recycler_view);
        Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = recyclerViewFindViewById;
        this.recyclerView = recyclerView;
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
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        CyclicDashboard cyclicDashboard = this;
        View view2 = this.mIndicateView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIndicateView");
            view2 = null;
        }
        recyclerView2.setLayoutManager(new CyclicLayoutManager(contextRequireContext, cyclicDashboard, view2));
        this.mAdapter = new BaseQuickAdapter<Shortcut, BaseViewHolder>(getItemLayoutId(), getShortcuts()) { // from class: com.dw.launcher.ui.dashboard.CyclicDashboard.onViewCreated.2
            /* JADX INFO: Access modifiers changed from: protected */
            public void convert(BaseViewHolder holder, Shortcut item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                int i = R.id.cyclic_item_shortcut_icon;
                Context contextRequireContext2 = CyclicDashboard.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                holder.setImageDrawable(i, item.getLauncherIcon(contextRequireContext2));
            }
        };
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setAdapter(this.mAdapter);
        final BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.dw.launcher.ui.dashboard.CyclicDashboard$$ExternalSyntheticLambda1
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter2, View view3, int i) {
                    CyclicDashboard.onViewCreated$lambda$3$lambda$1(baseQuickAdapter, this, baseQuickAdapter2, view3, i);
                }
            });
            baseQuickAdapter.setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.dw.launcher.ui.dashboard.CyclicDashboard$$ExternalSyntheticLambda2
                public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter2, View view3, int i) {
                    return CyclicDashboard.onViewCreated$lambda$3$lambda$2(baseQuickAdapter, this, baseQuickAdapter2, view3, i);
                }
            });
        }
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        recyclerView4.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.dw.launcher.ui.dashboard.CyclicDashboard.onViewCreated.4
            public void onScrolled(RecyclerView recyclerView5, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView5, "recyclerView");
                super.onScrolled(recyclerView5, dx, dy);
                CyclicDashboard cyclicDashboard2 = CyclicDashboard.this;
                cyclicDashboard2.setTotalScollerDistance(cyclicDashboard2.getTotalScollerDistance() - dy);
            }

            public void onScrollStateChanged(RecyclerView recyclerView5, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView5, "recyclerView");
                super.onScrollStateChanged(recyclerView5, newState);
                if (newState == 0) {
                    CyclicDashboard.this.setTotalScollerDistance(0);
                } else {
                    CyclicDashboard.this.setBoolIsMoved(true);
                }
            }
        });
        Drawable drawableLoadDrawable = loadDrawable(getWallpaperComponent().getWallpaper());
        if (drawableLoadDrawable != null && (imageView = this.ivbackground) != null) {
            imageView.setImageDrawable(drawableLoadDrawable);
        }
        ConstraintLayout constraintLayout2 = this.parent;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parent");
        } else {
            constraintLayout = constraintLayout2;
        }
        showSlideUpTask((ViewGroup) constraintLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(CyclicDashboard this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Shortcut shortcut = this$0.mSelectedShortcut;
        if (shortcut != null) {
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            shortcut.onClicked(contextRequireContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$1(BaseQuickAdapter adapter, CyclicDashboard this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        if (i < 0 || i >= adapter.getItemCount()) {
            return;
        }
        this$0.onShortcutClicked(this$0.getShortcuts().get(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$3$lambda$2(BaseQuickAdapter adapter, CyclicDashboard this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        if (i < 0 || i >= adapter.getItemCount()) {
            return true;
        }
        this$0.onShortcutLongClicked(this$0.getShortcuts().get(i));
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

    @Override // com.dw.launcher.ui.dashboard.layoutmanager.CyclicLayoutManager.OnItemSelectedListener
    public void onItemSelected(int position) {
        if (position >= 0 && position < getShortcuts().size()) {
            updateSelected(getShortcuts().get(position));
        } else {
            updateSelected(null);
        }
    }

    public final boolean getBoolIsMoved() {
        return this.boolIsMoved;
    }

    public final void setBoolIsMoved(boolean z) {
        this.boolIsMoved = z;
    }

    private final void updateSelected(Shortcut shortcut) {
        Unit unit;
        this.mSelectedShortcut = shortcut;
        if (shortcut != null) {
            ImageView imageView = this.mIvSelectedIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvSelectedIcon");
                imageView = null;
            }
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            imageView.setImageDrawable(shortcut.getLauncherIcon(contextRequireContext));
            TextView textView = this.mTvSelectedLabel;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvSelectedLabel");
                textView = null;
            }
            textView.setText(shortcut.getName());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            TextView textView2 = this.mTvSelectedLabel;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvSelectedLabel");
                textView2 = null;
            }
            textView2.setText((CharSequence) null);
            ImageView imageView2 = this.mIvSelectedIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvSelectedIcon");
                imageView2 = null;
            }
            imageView2.setImageDrawable(null);
        }
    }

    public final float getMOVE_DISTANCE() {
        return this.MOVE_DISTANCE;
    }

    public final void setMOVE_DISTANCE(float f) {
        this.MOVE_DISTANCE = f;
    }

    public final long getLastKeyDownStamp() {
        return this.lastKeyDownStamp;
    }

    public final void setLastKeyDownStamp(long j) {
        this.lastKeyDownStamp = j;
    }

    public final int getClickCount() {
        return this.clickCount;
    }

    public final void setClickCount(int i) {
        this.clickCount = i;
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
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView2 = null;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.dw.launcher.ui.dashboard.layoutmanager.CyclicLayoutManager");
            ((CyclicLayoutManager) layoutManager).setMTouchDownX(280.0f);
            this.totalScollerDistance -= (int) this.MOVE_DISTANCE;
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.smoothScrollBy(0, this.totalScollerDistance);
            return true;
        }
        if (keyCode == getSysKeyEvent().getUPKey()) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (window = activity2.getWindow()) != null) {
                window.addFlags(128);
            }
            onSensorStopped();
            RecyclerView recyclerView4 = this.recyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView4 = null;
            }
            RecyclerView.LayoutManager layoutManager2 = recyclerView4.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type com.dw.launcher.ui.dashboard.layoutmanager.CyclicLayoutManager");
            ((CyclicLayoutManager) layoutManager2).setMTouchDownX(280.0f);
            this.totalScollerDistance += (int) this.MOVE_DISTANCE;
            RecyclerView recyclerView5 = this.recyclerView;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView5;
            }
            recyclerView.smoothScrollBy(0, this.totalScollerDistance);
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

    private final void scrollToPosition(int delta) {
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        if (recyclerView.getChildCount() > 0) {
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView3 = null;
            }
            RecyclerView recyclerView4 = this.recyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView4 = null;
            }
            int iMax = Math.max(0, recyclerView3.getChildAdapterPosition(recyclerView4.getChildAt(0)) + delta);
            BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter = this.mAdapter;
            Intrinsics.checkNotNull(baseQuickAdapter);
            int iMin = Math.min(iMax, baseQuickAdapter.getItemCount() - 1);
            RecyclerView recyclerView5 = this.recyclerView;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView2 = recyclerView5;
            }
            recyclerView2.scrollToPosition(iMin);
        }
    }

    public final void move(float value) {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.addFlags(128);
        }
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null || !(layoutManager instanceof CyclicLayoutManager)) {
            return;
        }
        int i = (int) value;
        Timber.INSTANCE.i("-----move: " + i, new Object[0]);
        CyclicLayoutManager cyclicLayoutManager = (CyclicLayoutManager) layoutManager;
        cyclicLayoutManager.setMTouchDownX(cyclicLayoutManager.getHeight());
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.smoothScrollBy(0, i);
        this.clickCount = 0;
        this.boolIsMoved = true;
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public boolean onSensorChanged(boolean up) {
        Window window;
        cancelScreenFlagTask();
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.addFlags(128);
        }
        Timber.INSTANCE.i("----onSensorChanged move: " + up + " totalScollerDistance: " + this.totalScollerDistance, new Object[0]);
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.dw.launcher.ui.dashboard.layoutmanager.CyclicLayoutManager");
        ((CyclicLayoutManager) layoutManager).setMTouchDownX(280.0f);
        if (up) {
            this.totalScollerDistance -= (int) this.MOVE_DISTANCE;
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView2 = recyclerView3;
            }
            recyclerView2.smoothScrollBy(0, this.totalScollerDistance);
            return true;
        }
        this.totalScollerDistance += (int) this.MOVE_DISTANCE;
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.smoothScrollBy(0, this.totalScollerDistance);
        return true;
    }

    public final void stopScroll() {
        closeScreenFlagTask();
    }
}
