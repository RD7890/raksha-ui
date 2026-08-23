package com.dw.launcher.ui.dashboard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.entity.Shortcut;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.ui.dashboard.layoutmanager.HalfCyclicLayoutManager2;
import com.dw.launcher.ui.dashboard.layoutmanager.snaphelper.HalfCyclicSnapHelper;
import com.dw.launcher.ui.dashboard.transformation.HalfCyclicTransformation;
import com.dw.launcher.util.ResourceUtils;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import java.util.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: HalfCyclicDashboard.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u0011J\u0006\u0010B\u001a\u00020\u0011J\b\u0010C\u001a\u00020\u0011H\u0016J\u0018\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020\u0011H\u0016J\u0018\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010J\u001a\u00020KH\u0016J\u0018\u0010L\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010M\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000bH\u0016J\u0016\u0010O\u001a\u00020E2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020(0QH\u0016J\u001a\u0010R\u001a\u00020E2\u0006\u0010S\u001a\u00020-2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u0010\u0010V\u001a\u00020E2\u0006\u0010W\u001a\u00020\u0011H\u0002J\u0006\u0010X\u001a\u00020EJ\u001c\u0010Y\u001a\u00020E2\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0013\"\u0004\b2\u0010\u0015R\u000e\u00103\u001a\u000204X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u001e\u00107\u001a\u0002088\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0013\"\u0004\b?\u0010\u0015¨\u0006^"}, d2 = {"Lcom/dw/launcher/ui/dashboard/HalfCyclicDashboard;", "Lcom/dw/launcher/ui/dashboard/BaseDashboard;", "Lcom/dw/launcher/ui/dashboard/transformation/HalfCyclicTransformation;", "()V", "MOVE_DISTANCE", "", "getMOVE_DISTANCE", "()F", "setMOVE_DISTANCE", "(F)V", "boolIsMoved", "", "getBoolIsMoved", "()Z", "setBoolIsMoved", "(Z)V", "clickCount", "", "getClickCount", "()I", "setClickCount", "(I)V", "halfboard_style_alpha_fixed", "ivbackground", "Landroid/widget/ImageView;", "lastKeyDownStamp", "", "getLastKeyDownStamp", "()J", "setLastKeyDownStamp", "(J)V", "lastKnownScrollPosition", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setLauncherRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "mAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Shortcut;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "mHandler", "Landroid/os/Handler;", "mIndicateView", "Landroid/view/View;", "mStopPostionTask", "Ljava/lang/Runnable;", "multiple", "getMultiple", "setMultiple", "parent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "totalScollerDistance", "getTotalScollerDistance", "setTotalScollerDistance", "alphaValue", "value", "getItemLayoutId", "getLayoutId", "onChildScale", "", "child", "angle", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onSensorChanged", "up", "onShortcutsChanged", "shortcuts", "", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "scrollToPosition", "delta", "stopScroll", "update", "o", "Ljava/util/Observable;", "arg", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class HalfCyclicDashboard extends Hilt_HalfCyclicDashboard implements HalfCyclicTransformation {
    private boolean boolIsMoved;
    private int clickCount;
    private int halfboard_style_alpha_fixed;
    private ImageView ivbackground;
    private long lastKeyDownStamp;
    private int lastKnownScrollPosition;

    @Inject
    public LauncherRepository launcherRepository;
    private BaseQuickAdapter<Shortcut, BaseViewHolder> mAdapter;
    private View mIndicateView;
    private ConstraintLayout parent;
    private RecyclerView recyclerView;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private int totalScollerDistance;
    private int multiple = 1;
    private float MOVE_DISTANCE = 36.0f;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mStopPostionTask = new Runnable() { // from class: com.dw.launcher.ui.dashboard.HalfCyclicDashboard$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            HalfCyclicDashboard.mStopPostionTask$lambda$5(this.f$0);
        }
    };

    public final float alphaValue(int value) {
        if (30 <= value && value < 91) {
            return 1.0f - ((value - 30.0f) / 60);
        }
        if (270 > value || value >= 331) {
            return 1.0f;
        }
        return (value - 270.0f) / 60.0f;
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

    public final LauncherRepository getLauncherRepository() {
        LauncherRepository launcherRepository = this.launcherRepository;
        if (launcherRepository != null) {
            return launcherRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("launcherRepository");
        return null;
    }

    public final void setLauncherRepository(LauncherRepository launcherRepository) {
        Intrinsics.checkNotNullParameter(launcherRepository, "<set-?>");
        this.launcherRepository = launcherRepository;
    }

    public final int getTotalScollerDistance() {
        return this.totalScollerDistance;
    }

    public final void setTotalScollerDistance(int i) {
        this.totalScollerDistance = i;
    }

    public final int getMultiple() {
        return this.multiple;
    }

    public final void setMultiple(int i) {
        this.multiple = i;
    }

    public int getLayoutId() {
        return R.layout.dashboard_half_cyclic;
    }

    public final int getItemLayoutId() {
        return R.layout.dashboard_half_cyclic_item_shortcut;
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.cyclic_indicate);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mIndicateView = viewFindViewById;
        ConstraintLayout constraintLayoutFindViewById = view.findViewById(R.id.parent);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
        this.parent = constraintLayoutFindViewById;
        this.ivbackground = (ImageView) view.findViewById(R.id.iv_background);
        View view2 = this.mIndicateView;
        RecyclerView recyclerView = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIndicateView");
            view2 = null;
        }
        view2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.dw.launcher.ui.dashboard.HalfCyclicDashboard.onViewCreated.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                View view3 = HalfCyclicDashboard.this.mIndicateView;
                View view4 = null;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIndicateView");
                    view3 = null;
                }
                view3.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                View view5 = HalfCyclicDashboard.this.mIndicateView;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIndicateView");
                } else {
                    view4 = view5;
                }
                view4.requestLayout();
            }
        });
        LaunchConfig launchConfigLoadConfig = getLauncherRepository().loadConfig();
        if (launchConfigLoadConfig != null) {
            this.halfboard_style_alpha_fixed = launchConfigLoadConfig.getHalfboard_style_alpha_fixed();
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.MOVE_DISTANCE = ResourceUtils.dpToPx(contextRequireContext, 36.0f);
        Drawable drawableLoadDrawable = loadDrawable(getWallpaperComponent().getWallpaper());
        if (drawableLoadDrawable != null && (imageView = this.ivbackground) != null) {
            imageView.setImageDrawable(drawableLoadDrawable);
        }
        ConstraintLayout constraintLayout = this.parent;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parent");
            constraintLayout = null;
        }
        showSlideUpTask((ViewGroup) constraintLayout);
        RecyclerView recyclerViewFindViewById = view.findViewById(R.id.cyclic_recycler_view);
        Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(...)");
        RecyclerView recyclerView2 = recyclerViewFindViewById;
        this.recyclerView = recyclerView2;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.addOnScrollListener(getDefaultSoundEffectListener());
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        View view3 = this.mIndicateView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIndicateView");
            view3 = null;
        }
        recyclerView3.setLayoutManager(new HalfCyclicLayoutManager2(contextRequireContext2, view3, getResources().getDimensionPixelOffset(R.dimen.dashboard_half_cyclic_radius), this));
        this.mAdapter = new AnonymousClass4(getItemLayoutId(), getShortcuts());
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        recyclerView4.setAdapter(this.mAdapter);
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView5 = null;
        }
        recyclerView5.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.dw.launcher.ui.dashboard.HalfCyclicDashboard.onViewCreated.5
            public void onScrolled(RecyclerView recyclerView6, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView6, "recyclerView");
                HalfCyclicDashboard halfCyclicDashboard = HalfCyclicDashboard.this;
                halfCyclicDashboard.setTotalScollerDistance(halfCyclicDashboard.getTotalScollerDistance() - dy);
            }

            public void onScrollStateChanged(RecyclerView recyclerView6, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView6, "recyclerView");
                super.onScrollStateChanged(recyclerView6, newState);
                Timber.INSTANCE.e("lkang  onScrollStateChanged   newState = " + newState + " totalScollerDistance = " + HalfCyclicDashboard.this.getTotalScollerDistance(), new Object[0]);
                if (newState == 0) {
                    HalfCyclicDashboard.this.setTotalScollerDistance(0);
                } else {
                    HalfCyclicDashboard.this.setBoolIsMoved(true);
                }
            }
        });
        LaunchConfig launchConfigLoadConfig2 = getLauncherRepository().loadConfig();
        if (launchConfigLoadConfig2 != null) {
            if (launchConfigLoadConfig2.getHalfboard_style_scroll_alignment() == 1) {
                HalfCyclicSnapHelper halfCyclicSnapHelper = new HalfCyclicSnapHelper(requireContext());
                RecyclerView recyclerView6 = this.recyclerView;
                if (recyclerView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    recyclerView = recyclerView6;
                }
                halfCyclicSnapHelper.attachToRecyclerView(recyclerView);
            }
            this.multiple = launchConfigLoadConfig2.getEncoder_specialscroll() == 1 ? 5 : 1;
        }
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.dashboard.HalfCyclicDashboard$onViewCreated$4, reason: invalid class name */
    /* JADX INFO: compiled from: HalfCyclicDashboard.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/dw/launcher/ui/dashboard/HalfCyclicDashboard$onViewCreated$4", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Shortcut;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class AnonymousClass4 extends BaseQuickAdapter<Shortcut, BaseViewHolder> {
        AnonymousClass4(int i, List<Shortcut> list) {
            super(i, list);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void convert(BaseViewHolder holder, final Shortcut item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            int i = R.id.cyclic_item_shortcut_icon;
            Context contextRequireContext = HalfCyclicDashboard.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            holder.setImageDrawable(i, item.getLauncherIcon(contextRequireContext));
            holder.setText(R.id.cyclic_item_shortcut_label, item.getName());
            TextView textView = (TextView) holder.getView(R.id.cyclic_item_shortcut_label);
            final HalfCyclicDashboard halfCyclicDashboard = HalfCyclicDashboard.this;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.dashboard.HalfCyclicDashboard$onViewCreated$4$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HalfCyclicDashboard.AnonymousClass4.convert$lambda$0(halfCyclicDashboard, item, view);
                }
            });
            ImageView imageView = (ImageView) holder.getView(R.id.cyclic_item_shortcut_icon);
            final HalfCyclicDashboard halfCyclicDashboard2 = HalfCyclicDashboard.this;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.dashboard.HalfCyclicDashboard$onViewCreated$4$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HalfCyclicDashboard.AnonymousClass4.convert$lambda$1(halfCyclicDashboard2, item, view);
                }
            });
            TextView textView2 = (TextView) holder.getView(R.id.cyclic_item_shortcut_label);
            final HalfCyclicDashboard halfCyclicDashboard3 = HalfCyclicDashboard.this;
            textView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.dashboard.HalfCyclicDashboard$onViewCreated$4$$ExternalSyntheticLambda2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return HalfCyclicDashboard.AnonymousClass4.convert$lambda$2(halfCyclicDashboard3, item, view);
                }
            });
            ImageView imageView2 = (ImageView) holder.getView(R.id.cyclic_item_shortcut_icon);
            final HalfCyclicDashboard halfCyclicDashboard4 = HalfCyclicDashboard.this;
            imageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.dashboard.HalfCyclicDashboard$onViewCreated$4$$ExternalSyntheticLambda3
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return HalfCyclicDashboard.AnonymousClass4.convert$lambda$3(halfCyclicDashboard4, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$0(HalfCyclicDashboard this$0, Shortcut item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.onShortcutClicked(item);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$1(HalfCyclicDashboard this$0, Shortcut item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.onShortcutClicked(item);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convert$lambda$2(HalfCyclicDashboard this$0, Shortcut item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.onShortcutLongClicked(item);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convert$lambda$3(HalfCyclicDashboard this$0, Shortcut item, View view) {
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
            this.totalScollerDistance -= ((int) this.MOVE_DISTANCE) * this.multiple;
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView2;
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
            this.totalScollerDistance += ((int) this.MOVE_DISTANCE) * this.multiple;
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView3;
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
                this.totalScollerDistance -= ((int) this.MOVE_DISTANCE) * this.multiple;
                RecyclerView recyclerView2 = this.recyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    recyclerView = recyclerView2;
                }
                recyclerView.smoothScrollBy(0, this.totalScollerDistance);
                return true;
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (window = activity2.getWindow()) != null) {
                window.addFlags(128);
            }
            this.totalScollerDistance += ((int) this.MOVE_DISTANCE) * this.multiple;
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.smoothScrollBy(0, this.totalScollerDistance);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void stopScroll() {
        Timber.INSTANCE.i("----onSensorChanged move----onSensorStopped:  ", new Object[0]);
        closeScreenFlagTask();
    }

    @Override // com.dw.launcher.ui.dashboard.transformation.HalfCyclicTransformation
    public void onChildScale(View child, int angle) {
        Intrinsics.checkNotNullParameter(child, "child");
        TextView textView = (TextView) child.findViewById(R.id.cyclic_item_shortcut_label);
        float height = (float) (((double) ((child.getHeight() / 2) - (textView.getTextSize() / 2))) * Math.sin(Math.toRadians(angle)));
        if (90 <= angle && angle < 271) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setTranslationY(height);
        if (this.halfboard_style_alpha_fixed == 0) {
            textView.setAlpha(alphaValue(angle));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mStopPostionTask$lambda$5(HalfCyclicDashboard this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.clickCount;
        if (i != 0) {
            this$0.scrollToPosition(i);
            this$0.clickCount = 0;
            this$0.boolIsMoved = true;
        } else {
            this$0.boolIsMoved = false;
        }
        Timber.INSTANCE.e("------------滑动最终停止------clickCount=" + this$0.clickCount + "  boolIsmOved =" + this$0.boolIsMoved + " - ", new Object[0]);
    }
}
