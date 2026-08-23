package com.dw.launcher.ui.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.core.component.SensorComponent;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.entity.Dashboard;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.IDashboardRepository;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.ui.fragment.dashboard.DashboardContainerActivity;
import com.dw.launcher.util.AppLock;
import com.dw.launcher.util.ResourceUtils;
import com.google.android.mms.pdu.CharacterSets;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PickDashboardActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020<H\u0016J\u0012\u0010@\u001a\u00020<2\b\u0010A\u001a\u0004\u0018\u00010BH\u0014J\b\u0010C\u001a\u00020<H\u0014J\u0018\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020>2\u0006\u0010G\u001a\u00020HH\u0016J\u0018\u0010I\u001a\u00020E2\u0006\u0010F\u001a\u00020>2\u0006\u0010G\u001a\u00020HH\u0016J\b\u0010J\u001a\u00020<H\u0014J\b\u0010K\u001a\u00020<H\u0014J\u0010\u0010L\u001a\u00020E2\u0006\u0010M\u001a\u00020EH\u0016J\b\u0010N\u001a\u00020<H\u0016J\b\u0010O\u001a\u00020<H\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0002068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006P"}, d2 = {"Lcom/dw/launcher/ui/activity/PickDashboardActivity;", "Lcom/dw/launcher/base/BaseActivity;", "Lcom/dw/launcher/core/component/SensorComponent$OnSensorChangedListener;", "Lcom/dw/launcher/data/component/NoDisturbComponent$OnAppLockChangedListener;", "()V", "lastTurnOnTimestamp", "", "getLastTurnOnTimestamp", "()J", "setLastTurnOnTimestamp", "(J)V", "mClearScreenFlagTask", "Ljava/lang/Runnable;", "mDashboardRepository", "Lcom/dw/launcher/data/repository/IDashboardRepository;", "getMDashboardRepository", "()Lcom/dw/launcher/data/repository/IDashboardRepository;", "setMDashboardRepository", "(Lcom/dw/launcher/data/repository/IDashboardRepository;)V", "mDashboards", "Ljava/util/ArrayList;", "Lcom/dw/launcher/data/entity/Dashboard;", "Lkotlin/collections/ArrayList;", "mHandler", "Landroid/os/Handler;", "mLauncherPreference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "getMLauncherPreference", "()Lcom/dw/launcher/data/preference/LauncherPreference;", "setMLauncherPreference", "(Lcom/dw/launcher/data/preference/LauncherPreference;)V", "mLauncherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getMLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setMLauncherRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "mSensorComponent", "Lcom/dw/launcher/core/component/SensorComponent;", "getMSensorComponent", "()Lcom/dw/launcher/core/component/SensorComponent;", "setMSensorComponent", "(Lcom/dw/launcher/core/component/SensorComponent;)V", "mTvTitle", "Landroid/widget/TextView;", "mViewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "noDisturbComponent", "Lcom/dw/launcher/data/component/NoDisturbComponent;", "getNoDisturbComponent", "()Lcom/dw/launcher/data/component/NoDisturbComponent;", "setNoDisturbComponent", "(Lcom/dw/launcher/data/component/NoDisturbComponent;)V", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "closeScreenFlagTask", "", "getLayoutId", "", "onAppLockChanged", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onPause", "onResume", "onSensorChanged", "up", "onSensorStopped", "onUserLeaveHint", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class PickDashboardActivity extends Hilt_PickDashboardActivity implements SensorComponent.OnSensorChangedListener, NoDisturbComponent.OnAppLockChangedListener {
    private long lastTurnOnTimestamp;

    @Inject
    public IDashboardRepository mDashboardRepository;

    @Inject
    public LauncherPreference mLauncherPreference;

    @Inject
    public LauncherRepository mLauncherRepository;

    @Inject
    public SensorComponent mSensorComponent;
    private TextView mTvTitle;
    private ViewPager2 mViewPager2;

    @Inject
    public NoDisturbComponent noDisturbComponent;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private final ArrayList<Dashboard> mDashboards = new ArrayList<>();
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mClearScreenFlagTask = new Runnable() { // from class: com.dw.launcher.ui.activity.PickDashboardActivity$$ExternalSyntheticLambda2
        @Override // java.lang.Runnable
        public final void run() {
            PickDashboardActivity.mClearScreenFlagTask$lambda$0(this.f$0);
        }
    };

    public final IDashboardRepository getMDashboardRepository() {
        IDashboardRepository iDashboardRepository = this.mDashboardRepository;
        if (iDashboardRepository != null) {
            return iDashboardRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDashboardRepository");
        return null;
    }

    public final void setMDashboardRepository(IDashboardRepository iDashboardRepository) {
        Intrinsics.checkNotNullParameter(iDashboardRepository, "<set-?>");
        this.mDashboardRepository = iDashboardRepository;
    }

    public final LauncherRepository getMLauncherRepository() {
        LauncherRepository launcherRepository = this.mLauncherRepository;
        if (launcherRepository != null) {
            return launcherRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLauncherRepository");
        return null;
    }

    public final void setMLauncherRepository(LauncherRepository launcherRepository) {
        Intrinsics.checkNotNullParameter(launcherRepository, "<set-?>");
        this.mLauncherRepository = launcherRepository;
    }

    public final LauncherPreference getMLauncherPreference() {
        LauncherPreference launcherPreference = this.mLauncherPreference;
        if (launcherPreference != null) {
            return launcherPreference;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLauncherPreference");
        return null;
    }

    public final void setMLauncherPreference(LauncherPreference launcherPreference) {
        Intrinsics.checkNotNullParameter(launcherPreference, "<set-?>");
        this.mLauncherPreference = launcherPreference;
    }

    public final SensorComponent getMSensorComponent() {
        SensorComponent sensorComponent = this.mSensorComponent;
        if (sensorComponent != null) {
            return sensorComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSensorComponent");
        return null;
    }

    public final void setMSensorComponent(SensorComponent sensorComponent) {
        Intrinsics.checkNotNullParameter(sensorComponent, "<set-?>");
        this.mSensorComponent = sensorComponent;
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

    public final NoDisturbComponent getNoDisturbComponent() {
        NoDisturbComponent noDisturbComponent = this.noDisturbComponent;
        if (noDisturbComponent != null) {
            return noDisturbComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("noDisturbComponent");
        return null;
    }

    public final void setNoDisturbComponent(NoDisturbComponent noDisturbComponent) {
        Intrinsics.checkNotNullParameter(noDisturbComponent, "<set-?>");
        this.noDisturbComponent = noDisturbComponent;
    }

    public final long getLastTurnOnTimestamp() {
        return this.lastTurnOnTimestamp;
    }

    public final void setLastTurnOnTimestamp(long j) {
        this.lastTurnOnTimestamp = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mClearScreenFlagTask$lambda$0(PickDashboardActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Window window = this$0.getWindow();
        if (window != null) {
            window.clearFlags(128);
        }
    }

    public int getLayoutId() {
        return R.layout.activity_pick_dashboard;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.dw.launcher.ui.activity.Hilt_PickDashboardActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewPager2 viewPager2FindViewById = findViewById(R.id.pick_dashboard_viewpager);
        Intrinsics.checkNotNullExpressionValue(viewPager2FindViewById, "findViewById(...)");
        this.mViewPager2 = viewPager2FindViewById;
        View viewFindViewById = findViewById(R.id.pick_dashboard_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mTvTitle = (TextView) viewFindViewById;
        this.mDashboards.clear();
        ArrayList<Dashboard> arrayList = this.mDashboards;
        Object value = getMDashboardRepository().getDashboards().getValue();
        Intrinsics.checkNotNull(value);
        arrayList.addAll((Collection) value);
        final int i = R.layout.pick_dashboard_item_dashboard;
        final ArrayList<Dashboard> arrayList2 = this.mDashboards;
        RecyclerView.Adapter adapter = new BaseQuickAdapter<Dashboard, BaseViewHolder>(i, arrayList2) { // from class: com.dw.launcher.ui.activity.PickDashboardActivity$onCreate$adapter$1
            {
                ArrayList<Dashboard> arrayList3 = arrayList2;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void convert(BaseViewHolder holder, Dashboard item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                if (item.getPreview() != 0) {
                    if (Build.VERSION.SDK_INT >= 28) {
                        Glide.with(this.this$0).load(Integer.valueOf(item.getPreview())).centerCrop().into((ImageView) holder.getView(R.id.pick_dashboard_item_preview));
                        return;
                    } else {
                        holder.setImageResource(R.id.pick_dashboard_item_preview, item.getPreview());
                        return;
                    }
                }
                holder.setImageDrawable(R.id.pick_dashboard_item_preview, (Drawable) null);
            }
        };
        ViewPager2 viewPager2 = this.mViewPager2;
        ViewPager2 viewPager3 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager2 = null;
        }
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.dw.launcher.ui.activity.PickDashboardActivity.onCreate.1
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                TextView textView = PickDashboardActivity.this.mTvTitle;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
                    textView = null;
                }
                Object value2 = PickDashboardActivity.this.getMDashboardRepository().getDashboards().getValue();
                Intrinsics.checkNotNull(value2);
                textView.setText(((Dashboard) ((List) value2).get(position)).getLabel());
            }
        });
        ViewPager2 viewPager4 = this.mViewPager2;
        if (viewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager4 = null;
        }
        viewPager4.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.dw.launcher.ui.activity.PickDashboardActivity$$ExternalSyntheticLambda0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                PickDashboardActivity.onCreate$lambda$1(this.f$0, baseQuickAdapter, view, i2);
            }
        });
        int dashboardStyle = getMLauncherPreference().getDashboardStyle();
        int i2 = -1;
        int i3 = 0;
        for (Object obj : adapter.getData()) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((Dashboard) obj).getId() == dashboardStyle) {
                i2 = i3;
            }
            i3 = i4;
        }
        DotsIndicator dotsIndicator = (DotsIndicator) findViewById(R.id.pick_dashboard_dots_indicator);
        ViewPager2 viewPager5 = this.mViewPager2;
        if (viewPager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager5 = null;
        }
        dotsIndicator.attachTo(viewPager5);
        if (i2 != -1) {
            ViewPager2 viewPager6 = this.mViewPager2;
            if (viewPager6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                viewPager6 = null;
            }
            viewPager6.setCurrentItem(i2, false);
        }
        getNoDisturbComponent().addAppLockListener(this);
        ViewPager2 viewPager7 = this.mViewPager2;
        if (viewPager7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager7 = null;
        }
        RecyclerView childAt = viewPager7.getChildAt(0);
        Intrinsics.checkNotNull(childAt);
        RecyclerView recyclerView = childAt;
        int iDpToPx = (int) ResourceUtils.dpToPx((Context) this, 60.0f);
        recyclerView.setPadding(iDpToPx, 0, iDpToPx, 0);
        recyclerView.setClipToPadding(false);
        ViewPager2 viewPager8 = this.mViewPager2;
        if (viewPager8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager8 = null;
        }
        viewPager8.setOffscreenPageLimit(-1);
        ViewPager2.PageTransformer pageTransformer = new ViewPager2.PageTransformer() { // from class: com.dw.launcher.ui.activity.PickDashboardActivity$$ExternalSyntheticLambda1
            public final void transformPage(View view, float f) {
                PickDashboardActivity.onCreate$lambda$3(view, f);
            }
        };
        ViewPager2 viewPager9 = this.mViewPager2;
        if (viewPager9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
        } else {
            viewPager3 = viewPager9;
        }
        viewPager3.setPageTransformer(pageTransformer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onCreate$lambda$1(PickDashboardActivity this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        LaunchConfig launchConfigLoadConfig = this$0.getMLauncherRepository().loadConfig();
        if (launchConfigLoadConfig != null && launchConfigLoadConfig.getLauncherthemeType() == 0) {
            Dashboard dashboard = this$0.mDashboards.get(i);
            Intrinsics.checkNotNullExpressionValue(dashboard, "get(...)");
            Dashboard dashboard2 = dashboard;
            Log.i("lkang", "dashboard.id = " + dashboard2.getId());
            this$0.getMLauncherPreference().setDashboardStyle(dashboard2.getId());
            this$0.finish();
            return;
        }
        Dashboard dashboard3 = this$0.mDashboards.get(i);
        Intrinsics.checkNotNullExpressionValue(dashboard3, "get(...)");
        Dashboard dashboard4 = dashboard3;
        Log.i("lkang", "dashboard.id = " + dashboard4.getId());
        this$0.getMLauncherPreference().setDashboardStyle(dashboard4.getId());
        Intent intent = new Intent((Context) this$0, (Class<?>) DashboardContainerActivity.class);
        intent.setFlags(67108864);
        this$0.startActivity(intent);
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(View page, float f) {
        Intrinsics.checkNotNullParameter(page, "page");
        float f2 = 1;
        float fAbs = ((f2 - Math.abs(f)) * 0.15f) + 0.85f;
        page.setScaleY(fAbs);
        page.setScaleX(fAbs);
        page.setAlpha(((f2 - Math.abs(f)) * 0.5f) + 0.5f);
    }

    protected void onResume() {
        super.onResume();
        getMSensorComponent().register(this);
    }

    protected void onPause() {
        super.onPause();
        getMSensorComponent().unregister();
    }

    public boolean onSensorChanged(boolean up) {
        this.mHandler.removeCallbacks(this.mClearScreenFlagTask);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(128);
        }
        if (System.currentTimeMillis() - this.lastTurnOnTimestamp > 100) {
            ViewPager2 viewPager2 = null;
            if (up) {
                ViewPager2 viewPager3 = this.mViewPager2;
                if (viewPager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                    viewPager3 = null;
                }
                ViewPager2 viewPager4 = this.mViewPager2;
                if (viewPager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                } else {
                    viewPager2 = viewPager4;
                }
                viewPager3.setCurrentItem(viewPager2.getCurrentItem() - 1, true);
            } else {
                ViewPager2 viewPager5 = this.mViewPager2;
                if (viewPager5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                    viewPager5 = null;
                }
                int currentItem = viewPager5.getCurrentItem();
                ViewPager2 viewPager6 = this.mViewPager2;
                if (viewPager6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                    viewPager6 = null;
                }
                if (currentItem >= ((ViewGroup) viewPager6).getChildCount() - 1) {
                    ViewPager2 viewPager7 = this.mViewPager2;
                    if (viewPager7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                        viewPager7 = null;
                    }
                    ViewPager2 viewPager8 = this.mViewPager2;
                    if (viewPager8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                    } else {
                        viewPager2 = viewPager8;
                    }
                    viewPager7.setCurrentItem(viewPager2.getCurrentItem() + 1, true);
                }
            }
            this.lastTurnOnTimestamp = System.currentTimeMillis();
        }
        return true;
    }

    public void onSensorStopped() {
        SensorComponent.OnSensorChangedListener.DefaultImpls.onSensorStopped(this);
        closeScreenFlagTask();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ViewPager2 viewPager2 = null;
        if (keyCode == getSysKeyEvent().getUPKey()) {
            Window window = getWindow();
            if (window != null) {
                window.addFlags(128);
            }
            closeScreenFlagTask();
            ViewPager2 viewPager3 = this.mViewPager2;
            if (viewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                viewPager3 = null;
            }
            int currentItem = viewPager3.getCurrentItem();
            ViewPager2 viewPager4 = this.mViewPager2;
            if (viewPager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                viewPager4 = null;
            }
            if (currentItem >= ((ViewGroup) viewPager4).getChildCount() - 1) {
                ViewPager2 viewPager5 = this.mViewPager2;
                if (viewPager5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                    viewPager5 = null;
                }
                ViewPager2 viewPager6 = this.mViewPager2;
                if (viewPager6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                } else {
                    viewPager2 = viewPager6;
                }
                viewPager5.setCurrentItem(viewPager2.getCurrentItem() + 1, false);
                return true;
            }
        } else if (keyCode == getSysKeyEvent().getDownKey()) {
            Window window2 = getWindow();
            if (window2 != null) {
                window2.addFlags(128);
            }
            closeScreenFlagTask();
            ViewPager2 viewPager7 = this.mViewPager2;
            if (viewPager7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                viewPager7 = null;
            }
            if (viewPager7.getCurrentItem() > 0) {
                ViewPager2 viewPager8 = this.mViewPager2;
                if (viewPager8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                    viewPager8 = null;
                }
                ViewPager2 viewPager9 = this.mViewPager2;
                if (viewPager9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                } else {
                    viewPager2 = viewPager9;
                }
                viewPager8.setCurrentItem(viewPager2.getCurrentItem() - 1, false);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == getSysKeyEvent().getSingleKeyCode()) {
            finish();
            return true;
        }
        if (keyCode == getSysKeyEvent().getUPKey() || keyCode == getSysKeyEvent().getDownKey()) {
            closeScreenFlagTask();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    public void closeScreenFlagTask() {
        this.mHandler.removeCallbacks(this.mClearScreenFlagTask);
        this.mHandler.postDelayed(this.mClearScreenFlagTask, 1000L);
    }

    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        finish();
    }

    @Override // com.dw.launcher.ui.activity.Hilt_PickDashboardActivity
    protected void onDestroy() {
        super.onDestroy();
        getNoDisturbComponent().removeAppLockListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAppLockChanged() {
        if (AppLock.isForbidPackage((Context) this, new ComponentName("com.dw.launcher", "com.dw.launcher.ui.activity.PickDashboardActivity"))) {
            finish();
        }
    }
}
