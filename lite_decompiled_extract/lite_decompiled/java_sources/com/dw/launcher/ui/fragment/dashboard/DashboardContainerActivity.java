package com.dw.launcher.ui.fragment.dashboard;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
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
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.dw.launcher.R;
import com.dw.launcher.data.component.NoDisturbComponent;
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
import com.dw.launcher.util.AppLock;
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

/* JADX INFO: compiled from: DashboardContainerActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0014\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001HB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020\u001aH\u0016J\b\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020.H\u0016J\u0012\u00103\u001a\u00020.2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\b\u00106\u001a\u00020.H\u0014J\u0018\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020:H\u0016J\u0012\u0010;\u001a\u00020.2\b\u0010<\u001a\u0004\u0018\u00010=H\u0014J\u0010\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020\u001aH\u0016J\b\u0010@\u001a\u00020.H\u0014J\b\u0010A\u001a\u00020.H\u0014J\u0010\u0010B\u001a\u00020.2\u0006\u0010C\u001a\u000205H\u0014J\b\u0010D\u001a\u00020.H\u0014J\b\u0010E\u001a\u00020.H\u0014J\b\u0010F\u001a\u00020.H\u0002J\b\u0010G\u001a\u00020.H\u0002R\u0014\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006I"}, d2 = {"Lcom/dw/launcher/ui/fragment/dashboard/DashboardContainerActivity;", "Lcom/dw/launcher/base/BaseActivity;", "Lcom/dw/launcher/data/component/NoDisturbComponent$OnNoDisturbComponentListener;", "()V", "dubbleKeyChangeReceiver", "Lcom/dw/launcher/ui/fragment/dashboard/DashboardContainerActivity$DubbleKeyChangeReceiver;", "isDoubleClick", "", "isvisible", "getIsvisible", "()Z", "setIsvisible", "(Z)V", "mAssetsLaunchRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getMAssetsLaunchRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setMAssetsLaunchRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "mContentObserver", "com/dw/launcher/ui/fragment/dashboard/DashboardContainerActivity$mContentObserver$1", "Lcom/dw/launcher/ui/fragment/dashboard/DashboardContainerActivity$mContentObserver$1;", "mFirstLoaded", "mHandler", "Landroid/os/Handler;", "mLastStyle", "", "mPreference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "getMPreference", "()Lcom/dw/launcher/data/preference/LauncherPreference;", "setMPreference", "(Lcom/dw/launcher/data/preference/LauncherPreference;)V", "noDisturbComponent", "Lcom/dw/launcher/data/component/NoDisturbComponent;", "getNoDisturbComponent", "()Lcom/dw/launcher/data/component/NoDisturbComponent;", "setNoDisturbComponent", "(Lcom/dw/launcher/data/component/NoDisturbComponent;)V", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "checkReloadDashboards", "", "getLayoutId", "loadDashboard", "Landroidx/fragment/app/Fragment;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onNewIntent", "intent", "Landroid/content/Intent;", "onNoDisturbChanged", "status", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "registerDoubleKey", "unregisterDoubleKey", "DubbleKeyChangeReceiver", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class DashboardContainerActivity extends Hilt_DashboardContainerActivity implements NoDisturbComponent.OnNoDisturbComponentListener {
    private DubbleKeyChangeReceiver dubbleKeyChangeReceiver;
    private boolean isDoubleClick;
    private boolean isvisible;

    @Inject
    public LauncherRepository mAssetsLaunchRepository;
    private final DashboardContainerActivity$mContentObserver$1 mContentObserver;
    private final Handler mHandler;

    @Inject
    public LauncherPreference mPreference;

    @Inject
    public NoDisturbComponent noDisturbComponent;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private int mLastStyle = -1;
    private boolean mFirstLoaded = true;

    /* JADX WARN: Type inference failed for: r1v1, types: [com.dw.launcher.ui.fragment.dashboard.DashboardContainerActivity$mContentObserver$1] */
    public DashboardContainerActivity() {
        final Handler handler = new Handler(Looper.getMainLooper());
        this.mHandler = handler;
        this.mContentObserver = new ContentObserver(handler) { // from class: com.dw.launcher.ui.fragment.dashboard.DashboardContainerActivity$mContentObserver$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                this.this$0.mFirstLoaded = false;
                if (this.this$0.isDoubleClick) {
                    this.this$0.isDoubleClick = false;
                    this.this$0.checkReloadDashboards();
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

    public final boolean getIsvisible() {
        return this.isvisible;
    }

    public final void setIsvisible(boolean z) {
        this.isvisible = z;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkReloadDashboards() {
        if (getMPreference().getDashboardStyle() != this.mLastStyle) {
            getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_container, loadDashboard(), "DASHBOARD").commit();
            this.mLastStyle = getMPreference().getDashboardStyle();
        }
    }

    @Override // com.dw.launcher.ui.fragment.dashboard.Hilt_DashboardContainerActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.mLastStyle = savedInstanceState.getInt("DASHBOARD");
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_container, loadDashboard(), "DASHBOARD").commitAllowingStateLoss();
        this.mLastStyle = getMPreference().getDashboardStyle();
        Timber.INSTANCE.d("oncreat...", new Object[0]);
        NoDisturbComponent noDisturbComponent = getNoDisturbComponent();
        if (noDisturbComponent != null) {
            noDisturbComponent.addListener(this);
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("lkang", "DashboardContainerActivity onNewIntent");
        checkReloadDashboards();
    }

    protected void onStart() {
        super.onStart();
        ContentResolver contentResolver = getContentResolver();
        if (contentResolver != null) {
            contentResolver.registerContentObserver(ProviderConfig.INSTANCE.getURI_DASHBOARD_STYLE(), false, this.mContentObserver);
        }
        if (this.mFirstLoaded) {
            return;
        }
        checkReloadDashboards();
    }

    protected void onStop() {
        super.onStop();
        ContentResolver contentResolver = getContentResolver();
        if (contentResolver != null) {
            contentResolver.unregisterContentObserver(this.mContentObserver);
        }
    }

    protected void onResume() {
        super.onResume();
        this.isvisible = true;
        registerDoubleKey();
    }

    protected void onPause() {
        super.onPause();
        this.isvisible = false;
        unregisterDoubleKey();
    }

    private final void registerDoubleKey() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.divo.intent.action.SWITCH_STYLE");
        DubbleKeyChangeReceiver dubbleKeyChangeReceiver = new DubbleKeyChangeReceiver();
        this.dubbleKeyChangeReceiver = dubbleKeyChangeReceiver;
        registerReceiver(dubbleKeyChangeReceiver, intentFilter);
    }

    private final void unregisterDoubleKey() {
        try {
            Timber.INSTANCE.d("unregisterDoubleKey", new Object[0]);
            DubbleKeyChangeReceiver dubbleKeyChangeReceiver = this.dubbleKeyChangeReceiver;
            if (dubbleKeyChangeReceiver != null) {
                unregisterReceiver(dubbleKeyChangeReceiver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
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

    public int getLayoutId() {
        return R.layout.fragment_dashboard_container;
    }

    /* JADX INFO: compiled from: DashboardContainerActivity.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/dw/launcher/ui/fragment/dashboard/DashboardContainerActivity$DubbleKeyChangeReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/dw/launcher/ui/fragment/dashboard/DashboardContainerActivity;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public final class DubbleKeyChangeReceiver extends BroadcastReceiver {
        public DubbleKeyChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LaunchConfig launchConfigLoadConfig;
            List menuStyleInfo;
            LaunchConfig launchConfigLoadConfig2;
            LaunchConfig.KeyChangeStyleInfo keyChangeStyleInfo;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            LauncherRepository mAssetsLaunchRepository = DashboardContainerActivity.this.getMAssetsLaunchRepository();
            Unit unit = null;
            if (Boolean.parseBoolean((mAssetsLaunchRepository == null || (launchConfigLoadConfig2 = mAssetsLaunchRepository.loadConfig()) == null || (keyChangeStyleInfo = launchConfigLoadConfig2.getKeyChangeStyleInfo()) == null) ? null : keyChangeStyleInfo.isOpen())) {
                if (!AppLock.isForbidPackage(context, new ComponentName("com.dw.launcher", "com.dw.launcher.ui.activity.PickDashboardActivity"))) {
                    DashboardContainerActivity.this.isDoubleClick = true;
                    LauncherRepository mAssetsLaunchRepository2 = DashboardContainerActivity.this.getMAssetsLaunchRepository();
                    if (mAssetsLaunchRepository2 != null && (launchConfigLoadConfig = mAssetsLaunchRepository2.loadConfig()) != null && (menuStyleInfo = launchConfigLoadConfig.getMenuStyleInfo()) != null) {
                        DashboardContainerActivity dashboardContainerActivity = DashboardContainerActivity.this;
                        List list = menuStyleInfo;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Integer.valueOf(((LaunchConfig.MenuStyleInfo) it.next()).getId()));
                        }
                        ArrayList arrayList2 = arrayList;
                        dashboardContainerActivity.getMPreference().setDashboardStyle(((Number) arrayList2.get((arrayList2.indexOf(Integer.valueOf(dashboardContainerActivity.getMPreference().getDashboardStyle())) + 1) % arrayList2.size())).intValue());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        DashboardContainerActivity.this.getMPreference().setNextDashboard();
                    }
                } else {
                    Toast.makeText(context, context.getString(R.string.app_manager_disabled), 0).show();
                    return;
                }
            }
            Timber.INSTANCE.d("DubbleKeyChangeReceiver action:" + intent.getAction(), new Object[0]);
        }
    }

    @Override // com.dw.launcher.ui.fragment.dashboard.Hilt_DashboardContainerActivity
    protected void onDestroy() {
        super.onDestroy();
        getNoDisturbComponent().removeListener(this);
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.isvisible || getSysKeyEvent().getSingleKeyCode() != keyCode) {
            return false;
        }
        finish();
        return true;
    }

    public void onNoDisturbChanged(int status) {
        if (status == 1) {
            finish();
        }
    }
}
