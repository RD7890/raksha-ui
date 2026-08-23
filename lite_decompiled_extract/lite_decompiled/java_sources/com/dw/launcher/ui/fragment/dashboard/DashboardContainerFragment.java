package com.dw.launcher.ui.fragment.dashboard;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.dw.launcher.R;
import com.dw.launcher.data.config.ProviderConfig;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.ui.dashboard.BubbleDashboard;
import com.dw.launcher.ui.dashboard.CyclicDashboard;
import com.dw.launcher.ui.dashboard.FiveCyclicDashboard;
import com.dw.launcher.ui.dashboard.GridDashboard;
import com.dw.launcher.ui.dashboard.HalfCyclicDashboard;
import com.dw.launcher.ui.dashboard.HoneycombDashboard;
import com.dw.launcher.ui.dashboard.LinearDashboard;
import com.dw.launcher.ui.dashboard.VerticalGridDashboard;
import com.dw.launcher.ui.dashboard.VerticalGridDashboardNoTitle;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: DashboardContainerFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u000e\b\u0007\u0018\u00002\u00020\u0001:\u0001<B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u0014H\u0016J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020&H\u0016J\b\u0010+\u001a\u00020&H\u0016J\u0018\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020&H\u0016J\b\u00101\u001a\u00020&H\u0016J\u0010\u00102\u001a\u00020&2\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020&H\u0016J\u001a\u00106\u001a\u00020&2\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u000104H\u0016J\u0006\u0010:\u001a\u00020&J\u0006\u0010;\u001a\u00020&R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0018\u00010\u0016R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006="}, d2 = {"Lcom/dw/launcher/ui/fragment/dashboard/DashboardContainerFragment;", "Lcom/dw/launcher/base/BaseFragment;", "()V", "config", "Lcom/dw/launcher/data/entity/LaunchConfig;", "isDoubleClick", "", "mAssetsLaunchRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getMAssetsLaunchRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setMAssetsLaunchRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "mContentObserver", "com/dw/launcher/ui/fragment/dashboard/DashboardContainerFragment$mContentObserver$1", "Lcom/dw/launcher/ui/fragment/dashboard/DashboardContainerFragment$mContentObserver$1;", "mFirstLoaded", "mHandler", "Landroid/os/Handler;", "mLastStyle", "", "mMenuStyleChangeReceiver", "Lcom/dw/launcher/ui/fragment/dashboard/DashboardContainerFragment$MenuStyleChangeReceiver;", "mPreference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "getMPreference", "()Lcom/dw/launcher/data/preference/LauncherPreference;", "setMPreference", "(Lcom/dw/launcher/data/preference/LauncherPreference;)V", "styleChangeReceiver", "Landroid/content/BroadcastReceiver;", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "checkReloadDashboards", "", "getLayoutId", "loadDashboard", "Landroidx/fragment/app/Fragment;", "onDestroy", "onDestroyView", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onSaveInstanceState", "outState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "registerDoubleKey", "unregisterDoubleKey", "MenuStyleChangeReceiver", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class DashboardContainerFragment extends Hilt_DashboardContainerFragment {
    private LaunchConfig config;
    private boolean isDoubleClick;

    @Inject
    public LauncherRepository mAssetsLaunchRepository;
    private final DashboardContainerFragment$mContentObserver$1 mContentObserver;
    private final Handler mHandler;
    private MenuStyleChangeReceiver mMenuStyleChangeReceiver;

    @Inject
    public LauncherPreference mPreference;
    private final BroadcastReceiver styleChangeReceiver;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private int mLastStyle = -1;
    private boolean mFirstLoaded = true;

    /* JADX WARN: Type inference failed for: r1v1, types: [com.dw.launcher.ui.fragment.dashboard.DashboardContainerFragment$mContentObserver$1] */
    public DashboardContainerFragment() {
        final Handler handler = new Handler(Looper.getMainLooper());
        this.mHandler = handler;
        this.mContentObserver = new ContentObserver(handler) { // from class: com.dw.launcher.ui.fragment.dashboard.DashboardContainerFragment$mContentObserver$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                Log.i("lkang", "setDashboardStyle onChange");
                this.this$0.mFirstLoaded = false;
                if (this.this$0.isDoubleClick) {
                    this.this$0.isDoubleClick = false;
                    this.this$0.checkReloadDashboards();
                }
            }
        };
        this.styleChangeReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.ui.fragment.dashboard.DashboardContainerFragment$styleChangeReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    DashboardContainerFragment dashboardContainerFragment = this.this$0;
                    if (Intrinsics.areEqual(intent.getAction(), "ACTION_DASHBOARD_STYLE_CHANGED")) {
                        Integer numValueOf = Integer.valueOf(intent.getIntExtra("DASHBOARD_STYLE", 1));
                        Timber.INSTANCE.d("收到广播newStyle ：" + numValueOf + ' ', new Object[0]);
                        dashboardContainerFragment.getMPreference().setDashboardStyle(numValueOf.intValue());
                        dashboardContainerFragment.checkReloadDashboards();
                    }
                }
            }
        };
    }

    public final LauncherPreference getMPreference() {
        LauncherPreference launcherPreference = this.mPreference;
        if (launcherPreference != null) {
            return launcherPreference;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPreference");
        return null;
    }

    public final void setMPreference(LauncherPreference launcherPreference) {
        Intrinsics.checkNotNullParameter(launcherPreference, "<set-?>");
        this.mPreference = launcherPreference;
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

    public final LauncherRepository getMAssetsLaunchRepository() {
        LauncherRepository launcherRepository = this.mAssetsLaunchRepository;
        if (launcherRepository != null) {
            return launcherRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsLaunchRepository");
        return null;
    }

    public final void setMAssetsLaunchRepository(LauncherRepository launcherRepository) {
        Intrinsics.checkNotNullParameter(launcherRepository, "<set-?>");
        this.mAssetsLaunchRepository = launcherRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkReloadDashboards() {
        Log.i("Dashboard", "checkReloadDashboards");
        if (getMPreference().getDashboardStyle() == this.mLastStyle || !isAdded()) {
            return;
        }
        Log.i("Dashboard", "checkReloadDashboards  replace");
        getChildFragmentManager().beginTransaction().replace(R.id.dashboard_container, loadDashboard(), "DASHBOARD").commit();
        this.mLastStyle = getMPreference().getDashboardStyle();
    }

    public int getLayoutId() {
        return R.layout.fragment_dashboard_container;
    }

    public void onStart() {
        super.onStart();
        Log.i("lkang", "DashboardContainerFragment onStart mFirstLoaded = " + this.mFirstLoaded);
        if (this.mFirstLoaded) {
            return;
        }
        checkReloadDashboards();
    }

    public void onResume() {
        super.onResume();
        registerDoubleKey();
    }

    public void onPause() {
        super.onPause();
        unregisterDoubleKey();
    }

    public void onDestroy() {
        ContentResolver contentResolver;
        super.onDestroy();
        Context context = getContext();
        if (context == null || (contentResolver = context.getContentResolver()) == null) {
            return;
        }
        contentResolver.unregisterContentObserver(this.mContentObserver);
    }

    public final void registerDoubleKey() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.divo.intent.action.SWITCH_STYLE");
        this.mMenuStyleChangeReceiver = new MenuStyleChangeReceiver();
        Context context = getContext();
        if (context != null) {
            context.registerReceiver(this.mMenuStyleChangeReceiver, intentFilter);
        }
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.styleChangeReceiver, new IntentFilter("ACTION_DASHBOARD_STYLE_CHANGED"));
    }

    public final void unregisterDoubleKey() {
        Context context;
        try {
            if (this.mMenuStyleChangeReceiver != null && (context = getContext()) != null) {
                context.unregisterReceiver(this.mMenuStyleChangeReceiver);
            }
            LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.styleChangeReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        ContentResolver contentResolver;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Timber.INSTANCE.d("onViewCreated", new Object[0]);
        if (savedInstanceState != null) {
            this.mLastStyle = savedInstanceState.getInt("DASHBOARD");
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.dw.launcher.ui.fragment.dashboard.DashboardContainerFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DashboardContainerFragment.onViewCreated$lambda$1(this.f$0);
            }
        }, 2000L);
        this.config = getMAssetsLaunchRepository().loadConfig();
        Context context = getContext();
        if (context == null || (contentResolver = context.getContentResolver()) == null) {
            return;
        }
        contentResolver.registerContentObserver(ProviderConfig.INSTANCE.getURI_DASHBOARD_STYLE(), false, this.mContentObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(DashboardContainerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAdded()) {
            this$0.mFirstLoaded = false;
            this$0.getChildFragmentManager().beginTransaction().replace(R.id.dashboard_container, this$0.loadDashboard(), "DASHBOARD").commitAllowingStateLoss();
            this$0.mLastStyle = this$0.getMPreference().getDashboardStyle();
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putInt("DASHBOARD", this.mLastStyle);
        super.onSaveInstanceState(outState);
    }

    private final Fragment loadDashboard() {
        switch (getMPreference().getDashboardStyle()) {
            case 0:
                return new BubbleDashboard();
            case 1:
                return new LinearDashboard();
            case 2:
                return new GridDashboard(3, 0, 2, null);
            case 3:
                return new VerticalGridDashboard(3, 1);
            case 4:
                return new GridDashboard(2, 0, 2, null);
            case 5:
                return new VerticalGridDashboard(2, 1);
            case 6:
                return new CyclicDashboard();
            case 7:
                return new HalfCyclicDashboard();
            case 8:
                return new HoneycombDashboard();
            case CharacterSets.ISO_8859_6 /* 9 */:
                return new FiveCyclicDashboard();
            case CharacterSets.ISO_8859_7 /* 10 */:
                return new VerticalGridDashboardNoTitle(3, 1);
            case CharacterSets.ISO_8859_8 /* 11 */:
                return new VerticalGridDashboardNoTitle(2, 1);
            default:
                return new BubbleDashboard();
        }
    }

    /* JADX INFO: compiled from: DashboardContainerFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/dw/launcher/ui/fragment/dashboard/DashboardContainerFragment$MenuStyleChangeReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/dw/launcher/ui/fragment/dashboard/DashboardContainerFragment;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public final class MenuStyleChangeReceiver extends BroadcastReceiver {
        public MenuStyleChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            List menuStyleInfo;
            LaunchConfig.KeyChangeStyleInfo keyChangeStyleInfo;
            LaunchConfig.KeyChangeStyleInfo keyChangeStyleInfo2;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            StringBuilder sb = new StringBuilder("config?.keyChangeStyleInfo?.isOpen = ");
            LaunchConfig launchConfig = DashboardContainerFragment.this.config;
            Unit unit = null;
            Log.i("lkang", sb.append((launchConfig == null || (keyChangeStyleInfo2 = launchConfig.getKeyChangeStyleInfo()) == null) ? null : keyChangeStyleInfo2.isOpen()).toString());
            LaunchConfig launchConfig2 = DashboardContainerFragment.this.config;
            if (Boolean.parseBoolean((launchConfig2 == null || (keyChangeStyleInfo = launchConfig2.getKeyChangeStyleInfo()) == null) ? null : keyChangeStyleInfo.isOpen())) {
                DashboardContainerFragment.this.isDoubleClick = true;
                LaunchConfig launchConfig3 = DashboardContainerFragment.this.config;
                if (launchConfig3 != null && (menuStyleInfo = launchConfig3.getMenuStyleInfo()) != null) {
                    DashboardContainerFragment dashboardContainerFragment = DashboardContainerFragment.this;
                    List list = menuStyleInfo;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Integer.valueOf(((LaunchConfig.MenuStyleInfo) it.next()).getId()));
                    }
                    ArrayList arrayList2 = arrayList;
                    dashboardContainerFragment.getMPreference().setDashboardStyle(((Number) arrayList2.get((arrayList2.indexOf(Integer.valueOf(dashboardContainerFragment.getMPreference().getDashboardStyle())) + 1) % arrayList2.size())).intValue());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    DashboardContainerFragment.this.getMPreference().setNextDashboard();
                }
            }
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Timber.INSTANCE.d("onKeyDown: " + keyCode + ' ', new Object[0]);
        return super.onKeyDown(keyCode, event);
    }

    public void onDestroyView() {
        super.onDestroyView();
        Timber.INSTANCE.e("---- xxxix onDestroyView", new Object[0]);
    }
}
