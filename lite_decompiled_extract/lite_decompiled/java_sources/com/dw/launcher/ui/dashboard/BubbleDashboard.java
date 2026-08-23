package com.dw.launcher.ui.dashboard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.entity.Shortcut;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.ui.dashboard.layoutmanager.BubbleLayoutManager2;
import com.dw.launcher.ui.view.ScaleRecyclerView;
import com.dw.launcher.ui.view.TaskShowLayout;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import java.util.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

/* JADX INFO: compiled from: BubbleDashboard.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u00100\u001a\u0002012\u0006\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020#H\u0002J\b\u00104\u001a\u00020#H\u0016J\b\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u0002062\u0006\u00108\u001a\u00020#H\u0016J\u0018\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020<H\u0016J\u0018\u0010=\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010>\u001a\u000206H\u0016J\b\u0010?\u001a\u000206H\u0016J\u0010\u0010@\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u001aH\u0016J\b\u0010B\u001a\u000206H\u0016J\u0016\u0010C\u001a\u0002062\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00170EH\u0016J\u001a\u0010F\u001a\u0002062\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0010\u0010K\u001a\u0002062\u0006\u0010L\u001a\u00020#H\u0002J\u001c\u0010M\u001a\u0002062\b\u0010N\u001a\u0004\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006R"}, d2 = {"Lcom/dw/launcher/ui/dashboard/BubbleDashboard;", "Lcom/dw/launcher/ui/dashboard/BaseDashboard;", "Lcom/dw/launcher/ui/dashboard/layoutmanager/BubbleLayoutManager2$OnItemSelectedListener;", "()V", "assetsLaunchRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getAssetsLaunchRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setAssetsLaunchRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "flParent", "Landroid/widget/FrameLayout;", "ivbackground", "Landroid/widget/ImageView;", "getIvbackground", "()Landroid/widget/ImageView;", "setIvbackground", "(Landroid/widget/ImageView;)V", "launcherRepository", "getLauncherRepository", "setLauncherRepository", "mAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Shortcut;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "mFixing", "", "mHandler", "Landroid/os/Handler;", "mLastScaleTime", "", "mResetFixTask", "Ljava/lang/Runnable;", "mStopScrollTask", "multiple", "", "getMultiple", "()I", "setMultiple", "(I)V", "recyclerView", "Lcom/dw/launcher/ui/view/ScaleRecyclerView;", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "computeScrollDuration", "", "dx", "dy", "getLayoutId", "onDestroyView", "", "onItemSelected", "position", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onPause", "onResume", "onSensorChanged", "up", "onSensorStopped", "onShortcutsChanged", "shortcuts", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "scrollToPosition", "delta", "update", "o", "Ljava/util/Observable;", "arg", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class BubbleDashboard extends Hilt_BubbleDashboard implements BubbleLayoutManager2.OnItemSelectedListener {

    @Inject
    public LauncherRepository assetsLaunchRepository;
    private FrameLayout flParent;
    private ImageView ivbackground;

    @Inject
    public LauncherRepository launcherRepository;
    private BaseQuickAdapter<Shortcut, BaseViewHolder> mAdapter;
    private boolean mFixing;
    private long mLastScaleTime;
    private ScaleRecyclerView recyclerView;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private int multiple = 1;
    private final Runnable mResetFixTask = new Runnable() { // from class: com.dw.launcher.ui.dashboard.BubbleDashboard$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            BubbleDashboard.mResetFixTask$lambda$0(this.f$0);
        }
    };
    private final Runnable mStopScrollTask = new Runnable() { // from class: com.dw.launcher.ui.dashboard.BubbleDashboard$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            BubbleDashboard.mStopScrollTask$lambda$6(this.f$0);
        }
    };

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

    public final LauncherRepository getAssetsLaunchRepository() {
        LauncherRepository launcherRepository = this.assetsLaunchRepository;
        if (launcherRepository != null) {
            return launcherRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("assetsLaunchRepository");
        return null;
    }

    public final void setAssetsLaunchRepository(LauncherRepository launcherRepository) {
        Intrinsics.checkNotNullParameter(launcherRepository, "<set-?>");
        this.assetsLaunchRepository = launcherRepository;
    }

    public final int getMultiple() {
        return this.multiple;
    }

    public final void setMultiple(int i) {
        this.multiple = i;
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

    public final ImageView getIvbackground() {
        return this.ivbackground;
    }

    public final void setIvbackground(ImageView imageView) {
        this.ivbackground = imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mResetFixTask$lambda$0(BubbleDashboard this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mFixing = false;
    }

    public int getLayoutId() {
        return R.layout.dashboard_bubble;
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LaunchConfig launchConfigLoadConfig;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Log.i("BubbleDashboard", "onViewCreated");
        Object objFindViewById = view.findViewById(R.id.bubble_recycler_view);
        Intrinsics.checkNotNullExpressionValue(objFindViewById, "findViewById(...)");
        this.recyclerView = (ScaleRecyclerView) objFindViewById;
        View viewFindViewById = view.findViewById(R.id.flParent);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.flParent = (FrameLayout) viewFindViewById;
        this.ivbackground = (ImageView) view.findViewById(R.id.iv_background);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final BubbleLayoutManager2 bubbleLayoutManager2 = new BubbleLayoutManager2(contextRequireContext, this);
        ScaleRecyclerView scaleRecyclerView = this.recyclerView;
        FrameLayout frameLayout = null;
        if (scaleRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scaleRecyclerView = null;
        }
        scaleRecyclerView.setLayoutManager(bubbleLayoutManager2);
        this.mAdapter = new AnonymousClass1(R.layout.dashboard_honeycomb2_item_shortcut, getShortcuts());
        ScaleRecyclerView scaleRecyclerView2 = this.recyclerView;
        if (scaleRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scaleRecyclerView2 = null;
        }
        scaleRecyclerView2.setAdapter((RecyclerView.Adapter) this.mAdapter);
        ScaleRecyclerView scaleRecyclerView3 = this.recyclerView;
        if (scaleRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scaleRecyclerView3 = null;
        }
        scaleRecyclerView3.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.dw.launcher.ui.dashboard.BubbleDashboard.onViewCreated.2
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                int i;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (newState != 0) {
                    if (newState != 1) {
                        return;
                    }
                    this.mFixing = false;
                    return;
                }
                if (bubbleLayoutManager2.getMScale() != 0.5f) {
                    if (this.mFixing) {
                        return;
                    }
                    this.mFixing = true;
                    int[] iArrCalculateToCenterDistance = bubbleLayoutManager2.calculateToCenterDistance();
                    this.mHandler.removeCallbacks(this.mResetFixTask);
                    long jComputeScrollDuration = (long) (this.computeScrollDuration(iArrCalculateToCenterDistance[0], iArrCalculateToCenterDistance[1]) + ((double) 50));
                    Timber.INSTANCE.d("outTime=" + jComputeScrollDuration + " point=" + iArrCalculateToCenterDistance[0] + ',' + iArrCalculateToCenterDistance[1], new Object[0]);
                    this.mHandler.postDelayed(this.mResetFixTask, jComputeScrollDuration);
                    int i2 = iArrCalculateToCenterDistance[0];
                    if (-1 > i2 || i2 >= 2 || -1 > (i = iArrCalculateToCenterDistance[1]) || i >= 2) {
                        recyclerView.smoothScrollBy(i2, iArrCalculateToCenterDistance[1]);
                        return;
                    }
                    return;
                }
                recyclerView.smoothScrollBy((int) (-bubbleLayoutManager2.getMDeltaX()), (int) (-bubbleLayoutManager2.getMDeltaY()));
            }
        });
        Drawable drawableLoadDrawable = loadDrawable(getWallpaperComponent().getWallpaper());
        if (drawableLoadDrawable != null && (imageView = this.ivbackground) != null) {
            imageView.setImageDrawable(drawableLoadDrawable);
        }
        ScaleRecyclerView scaleRecyclerView4 = this.recyclerView;
        if (scaleRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scaleRecyclerView4 = null;
        }
        scaleRecyclerView4.addOnItemTouchListener(bubbleLayoutManager2);
        ScaleRecyclerView scaleRecyclerView5 = this.recyclerView;
        if (scaleRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scaleRecyclerView5 = null;
        }
        scaleRecyclerView5.addScaleListener(new ScaleRecyclerView.OnScaleListener() { // from class: com.dw.launcher.ui.dashboard.BubbleDashboard.onViewCreated.4
            @Override // com.dw.launcher.ui.view.ScaleRecyclerView.OnScaleListener
            public void onScale(ScaleGestureDetector scaleGestureDetector) {
                Intrinsics.checkNotNullParameter(scaleGestureDetector, "scaleGestureDetector");
                bubbleLayoutManager2.onScale(scaleGestureDetector);
            }

            @Override // com.dw.launcher.ui.view.ScaleRecyclerView.OnScaleListener
            public void onBeginScale(ScaleGestureDetector scaleGestureDetector) {
                bubbleLayoutManager2.onScaleBegin(scaleGestureDetector);
            }

            @Override // com.dw.launcher.ui.view.ScaleRecyclerView.OnScaleListener
            public void onEndScale(ScaleGestureDetector scaleGestureDetector) {
                bubbleLayoutManager2.onScaleEnd(scaleGestureDetector);
            }
        });
        FrameLayout frameLayout2 = this.flParent;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flParent");
        } else {
            frameLayout = frameLayout2;
        }
        showSlideUpTask(frameLayout);
        LauncherRepository launcherRepository = getLauncherRepository();
        if (launcherRepository == null || (launchConfigLoadConfig = launcherRepository.loadConfig()) == null) {
            return;
        }
        this.multiple = launchConfigLoadConfig.getEncoder_specialscroll() == 1 ? 3 : 1;
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.dashboard.BubbleDashboard$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: BubbleDashboard.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/dw/launcher/ui/dashboard/BubbleDashboard$onViewCreated$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Shortcut;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class AnonymousClass1 extends BaseQuickAdapter<Shortcut, BaseViewHolder> {
        AnonymousClass1(int i, List<Shortcut> list) {
            super(i, list);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void convert(final BaseViewHolder holder, final Shortcut item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            holder.setImageDrawable(R.id.bubble_item_shortcut_icon, item.getCustomIcon());
            ImageView imageView = (ImageView) holder.getView(R.id.bubble_item_shortcut_icon);
            final BubbleDashboard bubbleDashboard = BubbleDashboard.this;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.dashboard.BubbleDashboard$onViewCreated$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BubbleDashboard.AnonymousClass1.convert$lambda$0(holder, bubbleDashboard, item, view);
                }
            });
            ImageView imageView2 = (ImageView) holder.getView(R.id.bubble_item_shortcut_icon);
            final BubbleDashboard bubbleDashboard2 = BubbleDashboard.this;
            imageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.dashboard.BubbleDashboard$onViewCreated$1$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return BubbleDashboard.AnonymousClass1.convert$lambda$1(bubbleDashboard2, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$0(BaseViewHolder holder, BubbleDashboard this$0, Shortcut item, View view) {
            Intrinsics.checkNotNullParameter(holder, "$holder");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            if (holder.itemView.getScaleX() > 0.2f) {
                this$0.onShortcutClicked(item);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convert$lambda$1(BubbleDashboard this$0, Shortcut item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.onShortcutLongClicked(item);
            return true;
        }
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onShortcutsChanged(List<Shortcut> shortcuts) {
        Intrinsics.checkNotNullParameter(shortcuts, "shortcuts");
        Log.i("BubbleDashboard", "onShortcutsChanged");
        BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.setNewInstance(shortcuts);
            ScaleRecyclerView scaleRecyclerView = this.recyclerView;
            ScaleRecyclerView scaleRecyclerView2 = null;
            if (scaleRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                scaleRecyclerView = null;
            }
            scaleRecyclerView.setAdapter(null);
            ScaleRecyclerView scaleRecyclerView3 = this.recyclerView;
            if (scaleRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                scaleRecyclerView2 = scaleRecyclerView3;
            }
            scaleRecyclerView2.setAdapter((RecyclerView.Adapter) this.mAdapter);
        }
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onResume() {
        super.onResume();
        LaunchConfig launchConfigLoadConfig = getAssetsLaunchRepository().loadConfig();
        if (launchConfigLoadConfig == null || launchConfigLoadConfig.getHoneycomb_Dial_Reset() != 1) {
            return;
        }
        ScaleRecyclerView scaleRecyclerView = this.recyclerView;
        if (scaleRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scaleRecyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = scaleRecyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.dw.launcher.ui.dashboard.layoutmanager.BubbleLayoutManager2");
        ((BubbleLayoutManager2) layoutManager).restoreScale();
    }

    private final void scrollToPosition(int delta) {
        Log.i("BubbleDashboard", "scrollToPosition");
    }

    @Override // com.dw.launcher.ui.dashboard.layoutmanager.BubbleLayoutManager2.OnItemSelectedListener
    public void onItemSelected(int position) {
        Log.i("BubbleDashboard", "onItemSelected");
        if (position < 0 || position >= getShortcuts().size()) {
            return;
        }
        Shortcut shortcut = getShortcuts().get(position);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        shortcut.onClicked(contextRequireContext);
        ScaleRecyclerView scaleRecyclerView = this.recyclerView;
        if (scaleRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scaleRecyclerView = null;
        }
        scaleRecyclerView.restore();
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public boolean onSensorChanged(boolean up) {
        float f;
        Window window;
        TaskShowLayout rlTaskShow = getRlTaskShow();
        if (rlTaskShow != null && rlTaskShow.isShow()) {
            return false;
        }
        if (up) {
            int i = this.multiple;
            f = 80.0f;
            if (i == 3) {
                f = 80.0f * i * 1.2f;
            }
        } else {
            f = -80.0f;
        }
        cancelScreenFlagTask();
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.addFlags(128);
        }
        onSensorStopped();
        if (Math.abs(f) < 20.0f) {
            return false;
        }
        this.mLastScaleTime = System.currentTimeMillis();
        float fCoerceIn = RangesKt.coerceIn(1 + ((f / 500) * 1.0f), 0.2f, 2.5f);
        Log.i("BubbleDashboard", "scale = {" + fCoerceIn + '}');
        ScaleRecyclerView scaleRecyclerView = this.recyclerView;
        if (scaleRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scaleRecyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = scaleRecyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.dw.launcher.ui.dashboard.layoutmanager.BubbleLayoutManager2");
        ((BubbleLayoutManager2) layoutManager).animateToScaleBy(fCoerceIn);
        return true;
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onSensorStopped() {
        closeScreenFlagTask();
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        TaskShowLayout rlTaskShow;
        Intrinsics.checkNotNullParameter(event, "event");
        Timber.INSTANCE.d("onKeyDown isVisble:" + getIsVisble() + " keyCode:" + keyCode, new Object[0]);
        if (!getIsVisble() || ((rlTaskShow = getRlTaskShow()) != null && rlTaskShow.isShow())) {
            return false;
        }
        if (keyCode == getSysKeyEvent().getDownKey()) {
            onSensorChanged(false);
            return true;
        }
        if (keyCode == getSysKeyEvent().getUPKey()) {
            onSensorChanged(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        TaskShowLayout rlTaskShow;
        Intrinsics.checkNotNullParameter(event, "event");
        Timber.INSTANCE.d("onKeyUp isVisble:" + getIsVisble(), new Object[0]);
        if (!getIsVisble() || ((rlTaskShow = getRlTaskShow()) != null && rlTaskShow.isShow())) {
            return false;
        }
        this.mHandler.removeCallbacks(this.mStopScrollTask);
        if (keyCode == getSysKeyEvent().getDownKey()) {
            Timber.INSTANCE.v(" onKeyUp KEYCODE_DPAD_DOWN...", new Object[0]);
            this.mHandler.postDelayed(this.mStopScrollTask, 250L);
            return true;
        }
        if (keyCode == getSysKeyEvent().getUPKey()) {
            Timber.INSTANCE.v(" onKeyUp KEYCODE_DPAD_UP...", new Object[0]);
            this.mHandler.postDelayed(this.mStopScrollTask, 250L);
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
    public static final void mStopScrollTask$lambda$6(BubbleDashboard this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.v("----stop ringtone", new Object[0]);
        this$0.onSensorStopped();
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onPause() {
        super.onPause();
        Timber.INSTANCE.v("---- xxxx onPause", new Object[0]);
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onDestroyView() {
        super.onDestroyView();
        Timber.INSTANCE.e("---- xxxx onDestroyView", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double computeScrollDuration(int dx, int dy) {
        int height;
        int iAbs = (int) Math.abs(dx);
        int iAbs2 = (int) Math.abs(dy);
        boolean z = iAbs > iAbs2;
        ScaleRecyclerView scaleRecyclerView = null;
        ScaleRecyclerView scaleRecyclerView2 = this.recyclerView;
        if (z) {
            if (scaleRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                scaleRecyclerView = scaleRecyclerView2;
            }
            height = scaleRecyclerView.getWidth();
        } else {
            if (scaleRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                scaleRecyclerView = scaleRecyclerView2;
            }
            height = scaleRecyclerView.getHeight();
        }
        if (!z) {
            iAbs = iAbs2;
        }
        return Math.min((int) (((iAbs / height) + 1) * 300), 2000.0d);
    }
}
