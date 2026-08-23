package com.dw.launcher.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.entity.Shortcut;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.ui.dashboard.layoutmanager.HoneycombLayoutManager2;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import java.util.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: HoneycombDashboard.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010,\u001a\u00020\u001cH\u0016J\b\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u001cH\u0016J\u0018\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u000204H\u0016J\b\u00106\u001a\u00020.H\u0016J\b\u00107\u001a\u00020.H\u0016J\u0010\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u0013H\u0016J\b\u0010:\u001a\u00020.H\u0016J\u0016\u0010;\u001a\u00020.2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00100=H\u0016J\u001a\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010C\u001a\u00020.2\u0006\u0010D\u001a\u00020\u001cH\u0002J\u001c\u0010E\u001a\u00020.2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001e\"\u0004\b+\u0010 ¨\u0006J"}, d2 = {"Lcom/dw/launcher/ui/dashboard/HoneycombDashboard;", "Lcom/dw/launcher/ui/dashboard/BaseDashboard;", "Lcom/dw/launcher/ui/dashboard/layoutmanager/HoneycombLayoutManager2$OnItemSelectedListener;", "()V", "flParent", "Landroid/widget/FrameLayout;", "ivbackground", "Landroid/widget/ImageView;", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setLauncherRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "mAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Shortcut;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "mFixing", "", "mHandler", "Landroid/os/Handler;", "mLastScaleTime", "", "mResetFixTask", "Ljava/lang/Runnable;", "mStopScrollTask", "multiple", "", "getMultiple", "()I", "setMultiple", "(I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "totalScollerDistance", "getTotalScollerDistance", "setTotalScollerDistance", "getLayoutId", "onDestroyView", "", "onItemSelected", "position", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onPause", "onResume", "onSensorChanged", "up", "onSensorStopped", "onShortcutsChanged", "shortcuts", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "scrollToPosition", "delta", "update", "o", "Ljava/util/Observable;", "arg", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class HoneycombDashboard extends Hilt_HoneycombDashboard implements HoneycombLayoutManager2.OnItemSelectedListener {
    private FrameLayout flParent;
    private ImageView ivbackground;

    @Inject
    public LauncherRepository launcherRepository;
    private BaseQuickAdapter<Shortcut, BaseViewHolder> mAdapter;
    private boolean mFixing;
    private long mLastScaleTime;
    private RecyclerView recyclerView;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private int totalScollerDistance;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private int multiple = 1;
    private final Runnable mResetFixTask = new Runnable() { // from class: com.dw.launcher.ui.dashboard.HoneycombDashboard$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            HoneycombDashboard.mResetFixTask$lambda$0(this.f$0);
        }
    };
    private final Runnable mStopScrollTask = new Runnable() { // from class: com.dw.launcher.ui.dashboard.HoneycombDashboard$$ExternalSyntheticLambda2
        @Override // java.lang.Runnable
        public final void run() {
            HoneycombDashboard.mStopScrollTask$lambda$7(this.f$0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mResetFixTask$lambda$0(HoneycombDashboard this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mFixing = false;
    }

    public int getLayoutId() {
        return R.layout.dashboard_bubble;
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LaunchConfig launchConfigLoadConfig;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Log.i("BubbleDashboard", "onViewCreated");
        RecyclerView recyclerViewFindViewById = view.findViewById(R.id.bubble_recycler_view);
        Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(...)");
        this.recyclerView = recyclerViewFindViewById;
        View viewFindViewById = view.findViewById(R.id.flParent);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.flParent = (FrameLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.iv_background);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.ivbackground = (ImageView) viewFindViewById2;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final HoneycombLayoutManager2 honeycombLayoutManager2 = new HoneycombLayoutManager2(contextRequireContext, this);
        RecyclerView recyclerView = this.recyclerView;
        FrameLayout frameLayout = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(honeycombLayoutManager2);
        this.mAdapter = new AnonymousClass1(R.layout.dashboard_honeycomb2_item_shortcut, getShortcuts());
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setAdapter(this.mAdapter);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.dw.launcher.ui.dashboard.HoneycombDashboard.onViewCreated.2
            public void onScrolled(RecyclerView recyclerView4, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView4, "recyclerView");
                super.onScrolled(recyclerView4, dx, dy);
                HoneycombDashboard honeycombDashboard = HoneycombDashboard.this;
                honeycombDashboard.setTotalScollerDistance(honeycombDashboard.getTotalScollerDistance() - dy);
            }

            public void onScrollStateChanged(RecyclerView recyclerView4, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView4, "recyclerView");
                if (newState != 0) {
                    if (newState != 1) {
                        return;
                    }
                    HoneycombDashboard.this.mFixing = false;
                    return;
                }
                HoneycombDashboard.this.setTotalScollerDistance(0);
                int[] iArrClaulateToCenterDistance = honeycombLayoutManager2.claulateToCenterDistance();
                Timber.INSTANCE.d("滚动状态： point: " + iArrClaulateToCenterDistance[0] + " , " + iArrClaulateToCenterDistance[1], new Object[0]);
                if (HoneycombDashboard.this.mFixing) {
                    return;
                }
                Timber.INSTANCE.d("onScrollStateChanged: " + iArrClaulateToCenterDistance[0] + ", " + iArrClaulateToCenterDistance[1], new Object[0]);
                HoneycombDashboard.this.mFixing = true;
                HoneycombDashboard.this.mHandler.removeCallbacks(HoneycombDashboard.this.mResetFixTask);
                HoneycombDashboard.this.mHandler.postDelayed(HoneycombDashboard.this.mResetFixTask, 300L);
                recyclerView4.smoothScrollBy(iArrClaulateToCenterDistance[0], iArrClaulateToCenterDistance[1]);
            }
        });
        LaunchConfig launchConfigLoadConfig2 = getLauncherRepository().loadConfig();
        if (launchConfigLoadConfig2 != null) {
            honeycombLayoutManager2.setAddFootView(launchConfigLoadConfig2.getHoneycomb_has_foot_view() == 1);
            if (launchConfigLoadConfig2.getHoneycomb_has_foot_view() == 1) {
                View viewInflate = View.inflate(requireContext(), R.layout.item_list_menu_footer, null);
                ((ImageView) viewInflate.findViewById(R.id.iv_icon)).setImageResource(R.mipmap.ios_menu_type_list);
                ((TextView) viewInflate.findViewById(R.id.tv_label)).setText(R.string.ios_menu_type_list);
                BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter = this.mAdapter;
                if (baseQuickAdapter != null) {
                    Intrinsics.checkNotNull(viewInflate);
                    BaseQuickAdapter.addFooterView$default(baseQuickAdapter, viewInflate, 0, 0, 6, (Object) null);
                }
                ((LinearLayout) viewInflate.findViewById(R.id.ll_menu_type)).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.dashboard.HoneycombDashboard$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        HoneycombDashboard.onViewCreated$lambda$2$lambda$1(this.f$0, view2);
                    }
                });
            }
        }
        Drawable drawableLoadDrawable = loadDrawable(getWallpaperComponent().getWallpaper());
        if (drawableLoadDrawable != null) {
            ImageView imageView = this.ivbackground;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivbackground");
                imageView = null;
            }
            if (imageView != null) {
                imageView.setImageDrawable(drawableLoadDrawable);
            }
        }
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

    /* JADX INFO: renamed from: com.dw.launcher.ui.dashboard.HoneycombDashboard$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: HoneycombDashboard.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/dw/launcher/ui/dashboard/HoneycombDashboard$onViewCreated$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Shortcut;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class AnonymousClass1 extends BaseQuickAdapter<Shortcut, BaseViewHolder> {
        AnonymousClass1(int i, List<Shortcut> list) {
            super(i, list);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void convert(BaseViewHolder holder, final Shortcut item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            holder.setImageDrawable(R.id.bubble_item_shortcut_icon, item.getCustomIcon());
            ImageView imageView = (ImageView) holder.getView(R.id.bubble_item_shortcut_icon);
            final HoneycombDashboard honeycombDashboard = HoneycombDashboard.this;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.dashboard.HoneycombDashboard$onViewCreated$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HoneycombDashboard.AnonymousClass1.convert$lambda$0(honeycombDashboard, item, view);
                }
            });
            ImageView imageView2 = (ImageView) holder.getView(R.id.bubble_item_shortcut_icon);
            final HoneycombDashboard honeycombDashboard2 = HoneycombDashboard.this;
            imageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.dashboard.HoneycombDashboard$onViewCreated$1$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return HoneycombDashboard.AnonymousClass1.convert$lambda$1(honeycombDashboard2, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$0(HoneycombDashboard this$0, Shortcut item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.onShortcutClicked(item);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convert$lambda$1(HoneycombDashboard this$0, Shortcut item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.onShortcutLongClicked(item);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2$lambda$1(HoneycombDashboard this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("触发点击了....", new Object[0]);
        Intent intent = new Intent("ACTION_DASHBOARD_STYLE_CHANGED");
        intent.putExtra("DASHBOARD_STYLE", 1);
        LocalBroadcastManager.getInstance(this$0.requireContext()).sendBroadcast(intent);
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onShortcutsChanged(List<Shortcut> shortcuts) {
        Intrinsics.checkNotNullParameter(shortcuts, "shortcuts");
        Log.i("BubbleDashboard", "onShortcutsChanged");
        BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter != null) {
            Timber.INSTANCE.d(" 重新构建...", new Object[0]);
            baseQuickAdapter.setNewInstance(getShortcuts());
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

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onResume() {
        Window window;
        View decorView;
        super.onResume();
        Timber.Companion companion = Timber.INSTANCE;
        StringBuilder sb = new StringBuilder("----drawer_content, onResume list: ");
        BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter = this.mAdapter;
        View viewFindFocus = null;
        companion.i(sb.append(baseQuickAdapter != null ? Integer.valueOf(baseQuickAdapter.getItemCount()) : null).toString(), new Object[0]);
        Timber.Companion companion2 = Timber.INSTANCE;
        StringBuilder sb2 = new StringBuilder("----drawer_content, ");
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            viewFindFocus = decorView.findFocus();
        }
        companion2.i(sb2.append(viewFindFocus).toString(), new Object[0]);
    }

    private final void scrollToPosition(int delta) {
        Log.i("BubbleDashboard", "scrollToPosition");
    }

    @Override // com.dw.launcher.ui.dashboard.layoutmanager.HoneycombLayoutManager2.OnItemSelectedListener
    public void onItemSelected(int position) {
        Log.i("BubbleDashboard", "onItemSelected");
        if (position < 0 || position >= getShortcuts().size()) {
            return;
        }
        Shortcut shortcut = getShortcuts().get(position);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        shortcut.onClicked(contextRequireContext);
    }

    public final int getTotalScollerDistance() {
        return this.totalScollerDistance;
    }

    public final void setTotalScollerDistance(int i) {
        this.totalScollerDistance = i;
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public boolean onSensorChanged(boolean up) {
        Window window;
        RecyclerView recyclerView = null;
        if (up) {
            int i = this.totalScollerDistance;
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView2 = null;
            }
            View childAt = recyclerView2.getChildAt(0);
            Integer numValueOf = childAt != null ? Integer.valueOf(childAt.getHeight()) : null;
            Intrinsics.checkNotNull(numValueOf);
            this.totalScollerDistance = i + (numValueOf.intValue() * this.multiple);
        } else {
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView3 = null;
            }
            View childAt2 = recyclerView3.getChildAt(0);
            Integer numValueOf2 = childAt2 != null ? Integer.valueOf(childAt2.getHeight()) : null;
            Intrinsics.checkNotNull(numValueOf2);
            this.totalScollerDistance = (-numValueOf2.intValue()) * this.multiple;
        }
        cancelScreenFlagTask();
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.addFlags(128);
        }
        onSensorStopped();
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView4;
        }
        recyclerView.smoothScrollBy(0, this.totalScollerDistance);
        return false;
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onSensorStopped() {
        closeScreenFlagTask();
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Log.i("onKeyDown", "isVisble:" + getIsVisble());
        if (!getIsVisble()) {
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
        Intrinsics.checkNotNullParameter(event, "event");
        Log.i("onKeyUp", "isVisble:" + getIsVisble());
        if (!getIsVisble()) {
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
        Drawable drawableLoadDrawable = loadDrawable(getWallpaperComponent().getWallpaper());
        if (drawableLoadDrawable != null) {
            ImageView imageView = this.ivbackground;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivbackground");
                imageView = null;
            }
            imageView.setImageDrawable(drawableLoadDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mStopScrollTask$lambda$7(HoneycombDashboard this$0) {
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
}
