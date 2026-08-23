package com.dw.launcher.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.entity.Shortcut;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.ui.dashboard.layoutmanager.decoration.SpaceItemDecoration;
import com.dw.launcher.ui.dashboard.transformation.LinearSelectedTransformation;
import com.dw.launcher.ui.view.CustomRecyclerView;
import com.dw.launcher.util.ResourceUtils;
import com.dw.launcher.util.SettingsProperty;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import java.util.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import timber.log.Timber;

/* JADX INFO: compiled from: LinearDashboard.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010D\u001a\u00020\u000bH\u0016J\u0018\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0016J\u0018\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020NH\u0016J\u0018\u0010O\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005H\u0016J\u0016\u0010R\u001a\u00020F2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020$0TH\u0016J\u001a\u0010U\u001a\u00020F2\u0006\u0010V\u001a\u00020H2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\u0010\u0010Y\u001a\u00020F2\u0006\u0010Z\u001a\u00020\u000bH\u0002J\u0010\u0010[\u001a\u00020F2\u0006\u0010\\\u001a\u00020\u000bH\u0002J\u0010\u0010]\u001a\u00020F2\u0006\u0010Z\u001a\u00020\u000bH\u0002J\u0010\u0010^\u001a\u00020F2\u0006\u0010_\u001a\u00020\u000bH\u0002J\b\u0010`\u001a\u00020FH\u0002J\u001c\u0010a\u001a\u00020F2\b\u0010b\u001a\u0004\u0018\u00010c2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR\u000e\u00103\u001a\u000204X\u0082.¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\u00020<8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000f¨\u0006f"}, d2 = {"Lcom/dw/launcher/ui/dashboard/LinearDashboard;", "Lcom/dw/launcher/ui/dashboard/BaseDashboard;", "Lcom/dw/launcher/ui/dashboard/transformation/LinearSelectedTransformation;", "()V", "boolIsMoved", "", "getBoolIsMoved", "()Z", "setBoolIsMoved", "(Z)V", "clickCount", "", "getClickCount", "()I", "setClickCount", "(I)V", "ivbackground", "Landroid/widget/ImageView;", "getIvbackground", "()Landroid/widget/ImageView;", "setIvbackground", "(Landroid/widget/ImageView;)V", "lastKeyDownStamp", "", "getLastKeyDownStamp", "()J", "setLastKeyDownStamp", "(J)V", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setLauncherRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "mAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Shortcut;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "mHandler", "Landroid/os/Handler;", "mRightLayout", "Landroid/widget/FrameLayout;", "getMRightLayout", "()Landroid/widget/FrameLayout;", "setMRightLayout", "(Landroid/widget/FrameLayout;)V", "mStopPostionTask", "Ljava/lang/Runnable;", "multiple", "getMultiple", "setMultiple", "recyclerView", "Lcom/dw/launcher/ui/view/CustomRecyclerView;", "rlParent", "Landroid/widget/RelativeLayout;", "getRlParent", "()Landroid/widget/RelativeLayout;", "setRlParent", "(Landroid/widget/RelativeLayout;)V", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "totalScollerDistance", "getTotalScollerDistance", "setTotalScollerDistance", "getLayoutId", "onChildScale", "", "child", "Landroid/view/View;", "scale", "", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onSensorChanged", "up", "onShortcutsChanged", "shortcuts", "", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "scrollToBeforeItem", "clickItem", "scrollToItem", "clickItems", "scrollToNextItem", "scrollToPosition", "delta", "smoothScrollToPosition", "update", "o", "Ljava/util/Observable;", "arg", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class LinearDashboard extends Hilt_LinearDashboard implements LinearSelectedTransformation {
    private boolean boolIsMoved;
    private int clickCount;
    private ImageView ivbackground;
    private long lastKeyDownStamp;

    @Inject
    public LauncherRepository launcherRepository;
    private BaseQuickAdapter<Shortcut, BaseViewHolder> mAdapter;
    private FrameLayout mRightLayout;
    private CustomRecyclerView recyclerView;
    private RelativeLayout rlParent;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private int totalScollerDistance;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private int multiple = 1;
    private final Runnable mStopPostionTask = new Runnable() { // from class: com.dw.launcher.ui.dashboard.LinearDashboard$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            LinearDashboard.mStopPostionTask$lambda$7(this.f$0);
        }
    };

    @Override // com.dw.launcher.ui.dashboard.transformation.LinearSelectedTransformation
    public void onChildScale(View child, float scale) {
        Intrinsics.checkNotNullParameter(child, "child");
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

    public final int getTotalScollerDistance() {
        return this.totalScollerDistance;
    }

    public final void setTotalScollerDistance(int i) {
        this.totalScollerDistance = i;
    }

    public final FrameLayout getMRightLayout() {
        return this.mRightLayout;
    }

    public final void setMRightLayout(FrameLayout frameLayout) {
        this.mRightLayout = frameLayout;
    }

    public final RelativeLayout getRlParent() {
        return this.rlParent;
    }

    public final void setRlParent(RelativeLayout relativeLayout) {
        this.rlParent = relativeLayout;
    }

    public final ImageView getIvbackground() {
        return this.ivbackground;
    }

    public final void setIvbackground(ImageView imageView) {
        this.ivbackground = imageView;
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

    public int getLayoutId() {
        return R.layout.dashboard_linear;
    }

    /* JADX WARN: Type inference failed for: r12v1, types: [T, android.view.View] */
    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RecyclerView.LayoutManager layoutManager;
        ImageView imageView;
        LaunchConfig launchConfigLoadConfig;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LauncherRepository launcherRepository = getLauncherRepository();
        if (launcherRepository != null && (launchConfigLoadConfig = launcherRepository.loadConfig()) != null) {
            this.multiple = launchConfigLoadConfig.getEncoder_specialscroll() == 1 ? 3 : 1;
        }
        Object objFindViewById = view.findViewById(R.id.linear_recycler_view);
        Intrinsics.checkNotNullExpressionValue(objFindViewById, "findViewById(...)");
        this.recyclerView = (CustomRecyclerView) objFindViewById;
        this.mRightLayout = (FrameLayout) view.findViewById(R.id.lay_slip);
        this.rlParent = (RelativeLayout) view.findViewById(R.id.rlParent);
        this.ivbackground = (ImageView) view.findViewById(R.id.iv_background);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = view.findViewById(R.id.view_slip_front);
        CustomRecyclerView customRecyclerView = this.recyclerView;
        if (customRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            customRecyclerView = null;
        }
        customRecyclerView.addOnScrollListener(getDefaultSoundEffectListener());
        CustomRecyclerView customRecyclerView2 = this.recyclerView;
        if (customRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            customRecyclerView2 = null;
        }
        customRecyclerView2.setFlingScale(1.3d);
        boolean z = Settings.Global.getInt(requireContext().getContentResolver(), SettingsProperty.LINEAR_SYLTE_KEY, 0) == 0;
        CustomRecyclerView customRecyclerView3 = this.recyclerView;
        if (customRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            customRecyclerView3 = null;
        }
        if (z) {
            layoutManager = (RecyclerView.LayoutManager) new LinearLayoutManager(requireContext());
        } else {
            CustomRecyclerView customRecyclerView4 = this.recyclerView;
            if (customRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                customRecyclerView4 = null;
            }
            Context contextRequireContext = requireContext();
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            customRecyclerView4.addItemDecoration(new SpaceItemDecoration(contextRequireContext, (int) ResourceUtils.dpToPx(contextRequireContext2, 40.0f), 0, 1));
            Context contextRequireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
            layoutManager = (RecyclerView.LayoutManager) new LinearIosLayoutManager(contextRequireContext3);
        }
        customRecyclerView3.setLayoutManager(layoutManager);
        this.mAdapter = new BaseQuickAdapter<Shortcut, BaseViewHolder>(z ? R.layout.dashboard_linear_item_shortcut : R.layout.dashboard_linear_item_ios_shortcut, getShortcuts()) { // from class: com.dw.launcher.ui.dashboard.LinearDashboard.onViewCreated.2
            /* JADX INFO: Access modifiers changed from: protected */
            public void convert(BaseViewHolder holder, Shortcut item) {
                ActivityInfo activityInfo;
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ((TextView) holder.getView(R.id.linear_item_shortcut_label)).setSelected(true);
                ((TextView) holder.getView(R.id.linear_item_shortcut_label)).setFocusable(true);
                ((TextView) holder.getView(R.id.linear_item_shortcut_label)).setFocusableInTouchMode(true);
                ((TextView) holder.getView(R.id.linear_item_shortcut_label)).requestFocusFromTouch();
                holder.setImageDrawable(R.id.linear_item_shortcut_icon, item.getCustomIcon()).setText(R.id.linear_item_shortcut_label, item.getLabel());
                holder.itemView.setTag(item);
                LinearDashboard linearDashboard = LinearDashboard.this;
                StringBuilder sbAppend = new StringBuilder("----convert: item :  ").append((Object) item.getLabel()).append("  packageName : ").append(item.getPackageName()).append("  className：");
                ResolveInfo resolveInfo = item.getResolveInfo();
                linearDashboard.log(sbAppend.append((resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null) ? null : activityInfo.name).toString());
            }
        };
        CustomRecyclerView customRecyclerView5 = this.recyclerView;
        if (customRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            customRecyclerView5 = null;
        }
        Context contextRequireContext4 = requireContext();
        Context contextRequireContext5 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
        int iDpToPx = (int) ResourceUtils.dpToPx(contextRequireContext5, 10.0f);
        Context contextRequireContext6 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext6, "requireContext(...)");
        customRecyclerView5.addItemDecoration(new SpaceItemDecoration(contextRequireContext4, iDpToPx, (int) ResourceUtils.dpToPx(contextRequireContext6, 10.0f), 1));
        CustomRecyclerView customRecyclerView6 = this.recyclerView;
        if (customRecyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            customRecyclerView6 = null;
        }
        customRecyclerView6.setAdapter((RecyclerView.Adapter) this.mAdapter);
        final BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.dw.launcher.ui.dashboard.LinearDashboard$$ExternalSyntheticLambda1
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter2, View view2, int i) {
                    LinearDashboard.onViewCreated$lambda$3$lambda$1(baseQuickAdapter, this, baseQuickAdapter2, view2, i);
                }
            });
            baseQuickAdapter.setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.dw.launcher.ui.dashboard.LinearDashboard$$ExternalSyntheticLambda2
                public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter2, View view2, int i) {
                    return LinearDashboard.onViewCreated$lambda$3$lambda$2(baseQuickAdapter, this, baseQuickAdapter2, view2, i);
                }
            });
        }
        CustomRecyclerView customRecyclerView7 = this.recyclerView;
        if (customRecyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            customRecyclerView7 = null;
        }
        customRecyclerView7.setHasFixedSize(true);
        CustomRecyclerView customRecyclerView8 = this.recyclerView;
        if (customRecyclerView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            customRecyclerView8 = null;
        }
        customRecyclerView8.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.dw.launcher.ui.dashboard.LinearDashboard.onViewCreated.4
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                float fIntValue;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager2 = recyclerView.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager2 instanceof LinearLayoutManager ? layoutManager2 : null;
                int childCount = linearLayoutManager != null ? linearLayoutManager.getChildCount() : 0;
                int itemCount = linearLayoutManager != null ? linearLayoutManager.getItemCount() : 0;
                Integer numValueOf = linearLayoutManager != null ? Integer.valueOf(linearLayoutManager.findFirstVisibleItemPosition()) : null;
                if (itemCount > childCount) {
                    Intrinsics.checkNotNull(numValueOf);
                    fIntValue = numValueOf.intValue() / (itemCount - childCount);
                } else {
                    fIntValue = 1.0f;
                }
                FrameLayout mRightLayout = LinearDashboard.this.getMRightLayout();
                Intrinsics.checkNotNull(mRightLayout);
                objectRef.element.setTranslationY(fIntValue * (mRightLayout.getHeight() - objectRef.element.getHeight()));
                LinearDashboard.this.setBoolIsMoved(true);
                LinearDashboard linearDashboard = LinearDashboard.this;
                linearDashboard.setTotalScollerDistance(linearDashboard.getTotalScollerDistance() - dy);
            }

            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (newState == 0) {
                    LinearDashboard.this.setTotalScollerDistance(0);
                    LinearDashboard.this.mHandler.removeCallbacks(LinearDashboard.this.mStopPostionTask);
                    LinearDashboard.this.mHandler.postDelayed(LinearDashboard.this.mStopPostionTask, 1000L);
                } else {
                    LinearDashboard.this.setBoolIsMoved(true);
                    FrameLayout mRightLayout = LinearDashboard.this.getMRightLayout();
                    if (mRightLayout != null) {
                        mRightLayout.setVisibility(0);
                    }
                    LinearDashboard.this.mHandler.removeCallbacks(LinearDashboard.this.mStopPostionTask);
                }
            }
        });
        LaunchConfig launchConfigLoadConfig2 = getLauncherRepository().loadConfig();
        if (launchConfigLoadConfig2 != null && launchConfigLoadConfig2.getHoneycomb_has_foot_view() == 1) {
            View viewInflate = View.inflate(requireContext(), R.layout.item_list_menu_footer, null);
            BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter2 = this.mAdapter;
            if (baseQuickAdapter2 != null) {
                Intrinsics.checkNotNull(viewInflate);
                BaseQuickAdapter.addFooterView$default(baseQuickAdapter2, viewInflate, 0, 0, 6, (Object) null);
            }
            ((LinearLayout) viewInflate.findViewById(R.id.ll_menu_type)).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.dashboard.LinearDashboard$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LinearDashboard.onViewCreated$lambda$4(this.f$0, view2);
                }
            });
        }
        log("----onViewCreated done");
        Drawable drawableLoadDrawable = loadDrawable(getWallpaperComponent().getWallpaper());
        if (drawableLoadDrawable != null && (imageView = this.ivbackground) != null) {
            imageView.setImageDrawable(drawableLoadDrawable);
        }
        showSlideUpTask(this.rlParent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$1(BaseQuickAdapter adapter, LinearDashboard this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
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
    public static final boolean onViewCreated$lambda$3$lambda$2(BaseQuickAdapter adapter, LinearDashboard this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(LinearDashboard this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("ACTION_DASHBOARD_STYLE_CHANGED");
        intent.putExtra("DASHBOARD_STYLE", 8);
        LocalBroadcastManager.getInstance(this$0.requireContext()).sendBroadcast(intent);
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
        CustomRecyclerView customRecyclerView = null;
        if (keyCode == getSysKeyEvent().getDownKey()) {
            CustomRecyclerView customRecyclerView2 = this.recyclerView;
            if (customRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                customRecyclerView2 = null;
            }
            if (customRecyclerView2.getChildCount() > 0) {
                FragmentActivity activity = getActivity();
                if (activity != null && (window2 = activity.getWindow()) != null) {
                    window2.addFlags(128);
                }
                onSensorStopped();
                int i = this.totalScollerDistance;
                CustomRecyclerView customRecyclerView3 = this.recyclerView;
                if (customRecyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    customRecyclerView3 = null;
                }
                this.totalScollerDistance = i - (customRecyclerView3.getChildAt(0).getHeight() * this.multiple);
                CustomRecyclerView customRecyclerView4 = this.recyclerView;
                if (customRecyclerView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    customRecyclerView = customRecyclerView4;
                }
                customRecyclerView.smoothScrollBy(0, this.totalScollerDistance);
            }
            return true;
        }
        if (keyCode == getSysKeyEvent().getUPKey()) {
            CustomRecyclerView customRecyclerView5 = this.recyclerView;
            if (customRecyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                customRecyclerView5 = null;
            }
            if (customRecyclerView5.getChildCount() > 0) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null && (window = activity2.getWindow()) != null) {
                    window.addFlags(128);
                }
                onSensorStopped();
                int i2 = this.totalScollerDistance;
                CustomRecyclerView customRecyclerView6 = this.recyclerView;
                if (customRecyclerView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    customRecyclerView6 = null;
                }
                this.totalScollerDistance = i2 + (customRecyclerView6.getChildAt(0).getHeight() * this.multiple);
                CustomRecyclerView customRecyclerView7 = this.recyclerView;
                if (customRecyclerView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    customRecyclerView = customRecyclerView7;
                }
                customRecyclerView.smoothScrollBy(0, this.totalScollerDistance);
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
            onSensorStopped();
            return true;
        }
        if (keyCode == getSysKeyEvent().getUPKey()) {
            onSensorStopped();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    private final void scrollToItem(int clickItems) {
        CustomRecyclerView customRecyclerView = this.recyclerView;
        CustomRecyclerView customRecyclerView2 = null;
        if (customRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            customRecyclerView = null;
        }
        if (customRecyclerView.getChildCount() > 0) {
            Timber.INSTANCE.d("--------scrollToItem: " + clickItems, new Object[0]);
            CustomRecyclerView customRecyclerView3 = this.recyclerView;
            if (customRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                customRecyclerView2 = customRecyclerView3;
            }
            customRecyclerView2.smoothScrollToPosition(clickItems);
            this.mHandler.removeCallbacks(this.mStopPostionTask);
            this.clickCount = 0;
        }
    }

    private final void scrollToNextItem(int clickItem) {
        CustomRecyclerView customRecyclerView = this.recyclerView;
        CustomRecyclerView customRecyclerView2 = null;
        if (customRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            customRecyclerView = null;
        }
        if (customRecyclerView.getChildCount() > 0) {
            CustomRecyclerView customRecyclerView3 = this.recyclerView;
            if (customRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                customRecyclerView3 = null;
            }
            View childAt = customRecyclerView3.getChildAt(0);
            CustomRecyclerView customRecyclerView4 = this.recyclerView;
            if (customRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                customRecyclerView2 = customRecyclerView4;
            }
            customRecyclerView2.smoothScrollBy(0, clickItem * childAt.getHeight());
        }
    }

    private final void scrollToBeforeItem(int clickItem) {
        CustomRecyclerView customRecyclerView = this.recyclerView;
        CustomRecyclerView customRecyclerView2 = null;
        if (customRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            customRecyclerView = null;
        }
        if (customRecyclerView.getChildCount() > 0) {
            CustomRecyclerView customRecyclerView3 = this.recyclerView;
            if (customRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                customRecyclerView3 = null;
            }
            View childAt = customRecyclerView3.getChildAt(0);
            CustomRecyclerView customRecyclerView4 = this.recyclerView;
            if (customRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                customRecyclerView2 = customRecyclerView4;
            }
            customRecyclerView2.smoothScrollBy(0, (-childAt.getHeight()) * clickItem);
        }
    }

    private final void scrollToPosition(int delta) {
        CustomRecyclerView customRecyclerView = this.recyclerView;
        CustomRecyclerView customRecyclerView2 = null;
        if (customRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            customRecyclerView = null;
        }
        if (customRecyclerView.getChildCount() > 0) {
            CustomRecyclerView customRecyclerView3 = this.recyclerView;
            if (customRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                customRecyclerView3 = null;
            }
            CustomRecyclerView customRecyclerView4 = this.recyclerView;
            if (customRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                customRecyclerView4 = null;
            }
            int iMax = Math.max(0, customRecyclerView3.getChildAdapterPosition(customRecyclerView4.getChildAt(0)) + delta);
            BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter = this.mAdapter;
            Intrinsics.checkNotNull(baseQuickAdapter);
            int iMin = Math.min(iMax, baseQuickAdapter.getItemCount() - 1);
            CustomRecyclerView customRecyclerView5 = this.recyclerView;
            if (customRecyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                customRecyclerView2 = customRecyclerView5;
            }
            customRecyclerView2.scrollToPosition(iMin);
        }
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public boolean onSensorChanged(boolean up) {
        Window window;
        try {
            cancelScreenFlagTask();
            if (System.currentTimeMillis() - this.lastKeyDownStamp <= 180) {
                this.clickCount++;
            } else {
                this.clickCount = this.multiple;
            }
            this.lastKeyDownStamp = System.currentTimeMillis();
            if (up) {
                scrollToNextItem(this.clickCount);
            } else {
                scrollToBeforeItem(this.clickCount);
            }
            FragmentActivity activity = getActivity();
            if (activity != null && (window = activity.getWindow()) != null) {
                window.addFlags(128);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private final void smoothScrollToPosition() {
        CustomRecyclerView customRecyclerView = this.recyclerView;
        CustomRecyclerView customRecyclerView2 = null;
        if (customRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            customRecyclerView = null;
        }
        View childAt = customRecyclerView.getChildAt(0);
        int bottom = childAt.getBottom();
        int measuredHeight = childAt.getMeasuredHeight();
        if (bottom != measuredHeight) {
            if (bottom >= measuredHeight / 2) {
                CustomRecyclerView customRecyclerView3 = this.recyclerView;
                if (customRecyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    customRecyclerView2 = customRecyclerView3;
                }
                customRecyclerView2.smoothScrollBy(0, -(measuredHeight - bottom));
                return;
            }
            CustomRecyclerView customRecyclerView4 = this.recyclerView;
            if (customRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                customRecyclerView2 = customRecyclerView4;
            }
            customRecyclerView2.smoothScrollBy(0, bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mStopPostionTask$lambda$7(LinearDashboard this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout frameLayout = this$0.mRightLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        Timber.INSTANCE.e("------------滑动最终停止------clickCount=" + this$0.clickCount + "  boolIsmOved =" + this$0.boolIsMoved + " - ", new Object[0]);
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard, java.util.Observer
    public void update(Observable o, Object arg) {
        ImageView imageView;
        Timber.INSTANCE.d("----update", new Object[0]);
        Drawable drawableLoadDrawable = loadDrawable(getWallpaperComponent().getWallpaper());
        if (drawableLoadDrawable == null || (imageView = this.ivbackground) == null) {
            return;
        }
        imageView.setImageDrawable(drawableLoadDrawable);
    }
}
