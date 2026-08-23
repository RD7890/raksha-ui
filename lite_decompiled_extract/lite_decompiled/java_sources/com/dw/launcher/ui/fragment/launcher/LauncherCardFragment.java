package com.dw.launcher.ui.fragment.launcher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.dw.launcher.R;
import com.dw.launcher.activity.NoDisturbActivity;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.component.PhoneStatusComponent;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.listener.OnScrollChangeListener;
import com.dw.launcher.data.preference.SharedPreferencesUtils;
import com.dw.launcher.data.repository.IRecentTaskRepository;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.ui.fragment.bottom.BottomFragment;
import com.dw.launcher.ui.fragment.clock.DialFragment;
import com.dw.launcher.ui.fragment.dashboard.CardContainerFragment;
import com.dw.launcher.ui.fragment.dashboard.DashboardContainerActivity;
import com.dw.launcher.ui.fragment.menu.MenuFragment;
import com.dw.launcher.ui.fragment.top.TopRoundFragment;
import com.dw.launcher.ui.view.LauncherDrawer;
import com.dw.launcher.ui.view.OutViewPagerImpl;
import com.dw.launcher.util.AppCardConfig;
import com.dw.launcher.util.SystemUtils;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: LauncherCardFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002fgB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010K\u001a\u00020LH\u0002J\u0006\u0010M\u001a\u00020LJ\b\u0010N\u001a\u00020OH\u0016J\u0006\u0010P\u001a\u00020LJ\b\u0010Q\u001a\u00020LH\u0016J\b\u0010R\u001a\u00020LH\u0016J\u0018\u0010S\u001a\u00020\u00162\u0006\u0010T\u001a\u00020O2\u0006\u0010U\u001a\u00020VH\u0016J\u0010\u0010W\u001a\u00020L2\u0006\u0010X\u001a\u00020OH\u0016J\b\u0010Y\u001a\u00020LH\u0016J\b\u0010Z\u001a\u00020LH\u0016J\u0010\u0010[\u001a\u00020L2\u0006\u0010\\\u001a\u00020OH\u0016J\u001a\u0010]\u001a\u00020L2\u0006\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\b\u0010b\u001a\u00020LH\u0002J\b\u0010c\u001a\u00020LH\u0002J\u0006\u0010d\u001a\u00020LJ\b\u0010e\u001a\u00020LH\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0018\u00010\fR\u00020\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0011\u00105\u001a\u000206¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001e\u00109\u001a\u00020:8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020@8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001e\u0010E\u001a\u00020F8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006h"}, d2 = {"Lcom/dw/launcher/ui/fragment/launcher/LauncherCardFragment;", "Lcom/dw/launcher/base/BaseFragment;", "Lcom/dw/launcher/data/component/NoDisturbComponent$OnNoDisturbComponentListener;", "Lcom/dw/launcher/data/component/NoDisturbComponent$OnStatusMsgChangedListener;", "()V", "drawer_content", "Landroid/widget/FrameLayout;", "getDrawer_content", "()Landroid/widget/FrameLayout;", "setDrawer_content", "(Landroid/widget/FrameLayout;)V", "dubbleKeyChangeReceiver", "Lcom/dw/launcher/ui/fragment/launcher/LauncherCardFragment$DubbleKeyChangeReceiver;", "getDubbleKeyChangeReceiver", "()Lcom/dw/launcher/ui/fragment/launcher/LauncherCardFragment$DubbleKeyChangeReceiver;", "setDubbleKeyChangeReceiver", "(Lcom/dw/launcher/ui/fragment/launcher/LauncherCardFragment$DubbleKeyChangeReceiver;)V", "fragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "isvisible", "", "getIsvisible", "()Z", "setIsvisible", "(Z)V", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setLauncherRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "mHandler", "Landroid/os/Handler;", "mLauncherDrawer", "Lcom/dw/launcher/ui/view/LauncherDrawer;", "getMLauncherDrawer", "()Lcom/dw/launcher/ui/view/LauncherDrawer;", "setMLauncherDrawer", "(Lcom/dw/launcher/ui/view/LauncherDrawer;)V", "noDisturbComponent", "Lcom/dw/launcher/data/component/NoDisturbComponent;", "getNoDisturbComponent", "()Lcom/dw/launcher/data/component/NoDisturbComponent;", "setNoDisturbComponent", "(Lcom/dw/launcher/data/component/NoDisturbComponent;)V", "phoneStatusComponent", "Lcom/dw/launcher/data/component/PhoneStatusComponent;", "getPhoneStatusComponent", "()Lcom/dw/launcher/data/component/PhoneStatusComponent;", "setPhoneStatusComponent", "(Lcom/dw/launcher/data/component/PhoneStatusComponent;)V", "receiver", "Landroid/content/BroadcastReceiver;", "getReceiver", "()Landroid/content/BroadcastReceiver;", "recentTaskRepository", "Lcom/dw/launcher/data/repository/IRecentTaskRepository;", "getRecentTaskRepository", "()Lcom/dw/launcher/data/repository/IRecentTaskRepository;", "setRecentTaskRepository", "(Lcom/dw/launcher/data/repository/IRecentTaskRepository;)V", "sharedPreferencesUtils", "Lcom/dw/launcher/data/preference/SharedPreferencesUtils;", "getSharedPreferencesUtils", "()Lcom/dw/launcher/data/preference/SharedPreferencesUtils;", "setSharedPreferencesUtils", "(Lcom/dw/launcher/data/preference/SharedPreferencesUtils;)V", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "activateLauncher", "", "closeDrawers", "getLayoutId", "", "initViewpager", "onDestroy", "onDestroyView", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onNoDisturbChanged", "status", "onPause", "onResume", "onStatusMsgChanged", "mode", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "registerDoubleKey", "registerObserverReceiver", "showDashboard", "unregisterDoubleKey", "Companion", "DubbleKeyChangeReceiver", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class LauncherCardFragment extends Hilt_LauncherCardFragment implements NoDisturbComponent.OnNoDisturbComponentListener, NoDisturbComponent.OnStatusMsgChangedListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static View mView;
    public static OutViewPagerImpl mViewPager;
    private FrameLayout drawer_content;
    private DubbleKeyChangeReceiver dubbleKeyChangeReceiver;
    private boolean isvisible;

    @Inject
    public LauncherRepository launcherRepository;
    private LauncherDrawer mLauncherDrawer;

    @Inject
    public NoDisturbComponent noDisturbComponent;

    @Inject
    public PhoneStatusComponent phoneStatusComponent;

    @Inject
    public IRecentTaskRepository recentTaskRepository;

    @Inject
    public SharedPreferencesUtils sharedPreferencesUtils;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private final ArrayList<Fragment> fragments = CollectionsKt.arrayListOf(new DialFragment(), new CardContainerFragment());
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.dw.launcher.ui.fragment.launcher.LauncherCardFragment$receiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(intent.getAction(), AppCardConfig.ACTION_ITEM_CURRENT)) {
                if (intent.getIntExtra("position", 0) == 0) {
                    LauncherCardFragment.INSTANCE.getMViewPager().enabled();
                    return;
                } else {
                    LauncherCardFragment.INSTANCE.getMViewPager().disabled();
                    return;
                }
            }
            Intrinsics.areEqual(intent.getAction(), AppCardConfig.ACTION_ITEM_CHANGED_BROADCAST);
        }
    };

    public final LauncherDrawer getMLauncherDrawer() {
        return this.mLauncherDrawer;
    }

    public final void setMLauncherDrawer(LauncherDrawer launcherDrawer) {
        this.mLauncherDrawer = launcherDrawer;
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

    public final IRecentTaskRepository getRecentTaskRepository() {
        IRecentTaskRepository iRecentTaskRepository = this.recentTaskRepository;
        if (iRecentTaskRepository != null) {
            return iRecentTaskRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recentTaskRepository");
        return null;
    }

    public final void setRecentTaskRepository(IRecentTaskRepository iRecentTaskRepository) {
        Intrinsics.checkNotNullParameter(iRecentTaskRepository, "<set-?>");
        this.recentTaskRepository = iRecentTaskRepository;
    }

    public final boolean getIsvisible() {
        return this.isvisible;
    }

    public final void setIsvisible(boolean z) {
        this.isvisible = z;
    }

    public final FrameLayout getDrawer_content() {
        return this.drawer_content;
    }

    public final void setDrawer_content(FrameLayout frameLayout) {
        this.drawer_content = frameLayout;
    }

    public final DubbleKeyChangeReceiver getDubbleKeyChangeReceiver() {
        return this.dubbleKeyChangeReceiver;
    }

    public final void setDubbleKeyChangeReceiver(DubbleKeyChangeReceiver dubbleKeyChangeReceiver) {
        this.dubbleKeyChangeReceiver = dubbleKeyChangeReceiver;
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

    public final PhoneStatusComponent getPhoneStatusComponent() {
        PhoneStatusComponent phoneStatusComponent = this.phoneStatusComponent;
        if (phoneStatusComponent != null) {
            return phoneStatusComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("phoneStatusComponent");
        return null;
    }

    public final void setPhoneStatusComponent(PhoneStatusComponent phoneStatusComponent) {
        Intrinsics.checkNotNullParameter(phoneStatusComponent, "<set-?>");
        this.phoneStatusComponent = phoneStatusComponent;
    }

    public final SharedPreferencesUtils getSharedPreferencesUtils() {
        SharedPreferencesUtils sharedPreferencesUtils = this.sharedPreferencesUtils;
        if (sharedPreferencesUtils != null) {
            return sharedPreferencesUtils;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferencesUtils");
        return null;
    }

    public final void setSharedPreferencesUtils(SharedPreferencesUtils sharedPreferencesUtils) {
        Intrinsics.checkNotNullParameter(sharedPreferencesUtils, "<set-?>");
        this.sharedPreferencesUtils = sharedPreferencesUtils;
    }

    /* JADX INFO: compiled from: LauncherCardFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/dw/launcher/ui/fragment/launcher/LauncherCardFragment$Companion;", "", "()V", "mView", "Landroid/view/View;", "getMView", "()Landroid/view/View;", "setMView", "(Landroid/view/View;)V", "mViewPager", "Lcom/dw/launcher/ui/view/OutViewPagerImpl;", "getMViewPager", "()Lcom/dw/launcher/ui/view/OutViewPagerImpl;", "setMViewPager", "(Lcom/dw/launcher/ui/view/OutViewPagerImpl;)V", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OutViewPagerImpl getMViewPager() {
            OutViewPagerImpl outViewPagerImpl = LauncherCardFragment.mViewPager;
            if (outViewPagerImpl != null) {
                return outViewPagerImpl;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            return null;
        }

        public final void setMViewPager(OutViewPagerImpl outViewPagerImpl) {
            Intrinsics.checkNotNullParameter(outViewPagerImpl, "<set-?>");
            LauncherCardFragment.mViewPager = outViewPagerImpl;
        }

        public final View getMView() {
            View view = LauncherCardFragment.mView;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            return null;
        }

        public final void setMView(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            LauncherCardFragment.mView = view;
        }
    }

    public int getLayoutId() {
        return R.layout.fragment_launcher;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.mLauncherDrawer = (LauncherDrawer) view.findViewById(R.id.launcher_drawer);
        this.drawer_content = (FrameLayout) view.findViewById(R.id.drawer_content);
        INSTANCE.setMView(view);
        initViewpager();
        this.mHandler.postDelayed(new Runnable() { // from class: com.dw.launcher.ui.fragment.launcher.LauncherCardFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                LauncherCardFragment.onViewCreated$lambda$0(this.f$0);
            }
        }, 3000L);
        LauncherDrawer launcherDrawer = this.mLauncherDrawer;
        if (launcherDrawer != null) {
            launcherDrawer.setDrawerListener(new LauncherDrawer.DrawerListener() { // from class: com.dw.launcher.ui.fragment.launcher.LauncherCardFragment.onViewCreated.2
                @Override // com.dw.launcher.ui.view.LauncherDrawer.DrawerListener
                public void onDrawerOpened(View drawerView) {
                    MenuFragment menuFragmentFindFragmentById;
                    Log.i("drawer", "onDrawerOpened drawerView:" + drawerView);
                    OutViewPagerImpl mViewPager2 = LauncherCardFragment.INSTANCE.getMViewPager();
                    if (mViewPager2 != null) {
                        mViewPager2.disabled();
                    }
                    LauncherDrawer mLauncherDrawer = LauncherCardFragment.this.getMLauncherDrawer();
                    if (Intrinsics.areEqual(mLauncherDrawer != null ? mLauncherDrawer.getMTopDrawer() : null, drawerView)) {
                        LauncherDrawer mLauncherDrawer2 = LauncherCardFragment.this.getMLauncherDrawer();
                        if (mLauncherDrawer2 != null) {
                            mLauncherDrawer2.enableBottomDrawer(false);
                        }
                        TopRoundFragment topRoundFragmentFindFragmentById = LauncherCardFragment.this.getChildFragmentManager().findFragmentById(R.id.drawer_top);
                        if (topRoundFragmentFindFragmentById != null) {
                            final LauncherCardFragment launcherCardFragment = LauncherCardFragment.this;
                            if (topRoundFragmentFindFragmentById instanceof TopRoundFragment) {
                                TopRoundFragment topRoundFragment = topRoundFragmentFindFragmentById;
                                topRoundFragment.switchToTop();
                                topRoundFragment.setOnScrollChangeListener(new OnScrollChangeListener() { // from class: com.dw.launcher.ui.fragment.launcher.LauncherCardFragment$onViewCreated$2$onDrawerOpened$1$1
                                    public void onScrollChange(boolean scrollToBottom) {
                                        if (scrollToBottom) {
                                            LauncherDrawer mLauncherDrawer3 = launcherCardFragment.getMLauncherDrawer();
                                            if (mLauncherDrawer3 != null) {
                                                mLauncherDrawer3.enableWithKeepDrawer();
                                                return;
                                            }
                                            return;
                                        }
                                        LauncherDrawer mLauncherDrawer4 = launcherCardFragment.getMLauncherDrawer();
                                        if (mLauncherDrawer4 != null) {
                                            mLauncherDrawer4.disableWithKeepDrawer();
                                        }
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    LauncherDrawer mLauncherDrawer3 = LauncherCardFragment.this.getMLauncherDrawer();
                    if (Intrinsics.areEqual(mLauncherDrawer3 != null ? mLauncherDrawer3.getMBottomDrawer() : null, drawerView)) {
                        LauncherDrawer mLauncherDrawer4 = LauncherCardFragment.this.getMLauncherDrawer();
                        if (mLauncherDrawer4 != null) {
                            mLauncherDrawer4.enableTopDrawer(false);
                        }
                        BottomFragment bottomFragmentFindFragmentById = LauncherCardFragment.this.getChildFragmentManager().findFragmentById(R.id.drawer_bottom);
                        if (bottomFragmentFindFragmentById != null) {
                            final LauncherCardFragment launcherCardFragment2 = LauncherCardFragment.this;
                            if (bottomFragmentFindFragmentById instanceof BottomFragment) {
                                bottomFragmentFindFragmentById.setOnScrollChangeListener(new OnScrollChangeListener() { // from class: com.dw.launcher.ui.fragment.launcher.LauncherCardFragment$onViewCreated$2$onDrawerOpened$2$1
                                    public void onScrollChange(boolean scrollToBottom) {
                                        if (scrollToBottom) {
                                            LauncherDrawer mLauncherDrawer5 = launcherCardFragment2.getMLauncherDrawer();
                                            if (mLauncherDrawer5 != null) {
                                                mLauncherDrawer5.enableWithKeepDrawer();
                                                return;
                                            }
                                            return;
                                        }
                                        LauncherDrawer mLauncherDrawer6 = launcherCardFragment2.getMLauncherDrawer();
                                        if (mLauncherDrawer6 != null) {
                                            mLauncherDrawer6.disableWithKeepDrawer();
                                        }
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    LauncherDrawer mLauncherDrawer5 = LauncherCardFragment.this.getMLauncherDrawer();
                    if (Intrinsics.areEqual(mLauncherDrawer5 != null ? mLauncherDrawer5.getMStartDrawer() : null, drawerView) && (menuFragmentFindFragmentById = LauncherCardFragment.this.getChildFragmentManager().findFragmentById(R.id.drawer_start)) != null && (menuFragmentFindFragmentById instanceof MenuFragment)) {
                        menuFragmentFindFragmentById.onSlideup();
                    }
                }

                @Override // com.dw.launcher.ui.view.LauncherDrawer.DrawerListener
                public void onDrawerClosed(View drawerView) {
                    BottomFragment bottomFragmentFindFragmentById;
                    MenuFragment menuFragmentFindFragmentById;
                    OutViewPagerImpl mViewPager2 = LauncherCardFragment.INSTANCE.getMViewPager();
                    if (mViewPager2 != null) {
                        mViewPager2.enabled();
                    }
                    Timber.INSTANCE.d("onDrawerClosed关闭 drawerView:" + drawerView, new Object[0]);
                    LauncherDrawer mLauncherDrawer = LauncherCardFragment.this.getMLauncherDrawer();
                    if (Intrinsics.areEqual(drawerView, mLauncherDrawer != null ? mLauncherDrawer.getMStartDrawer() : null) && (menuFragmentFindFragmentById = LauncherCardFragment.this.getChildFragmentManager().findFragmentById(R.id.drawer_start)) != null && (menuFragmentFindFragmentById instanceof MenuFragment)) {
                        menuFragmentFindFragmentById.closeEditMode();
                    }
                    LaunchConfig launchConfigLoadConfig = LauncherCardFragment.this.getLauncherRepository().loadConfig();
                    if (launchConfigLoadConfig != null) {
                        LauncherCardFragment launcherCardFragment = LauncherCardFragment.this;
                        if (launchConfigLoadConfig.getSystemBar() == 0) {
                            LauncherDrawer mLauncherDrawer2 = launcherCardFragment.getMLauncherDrawer();
                            if (Intrinsics.areEqual(drawerView, mLauncherDrawer2 != null ? mLauncherDrawer2.getMTopDrawer() : null)) {
                                TopRoundFragment topRoundFragmentFindFragmentById = launcherCardFragment.getChildFragmentManager().findFragmentById(R.id.drawer_top);
                                if (topRoundFragmentFindFragmentById != null && (topRoundFragmentFindFragmentById instanceof TopRoundFragment)) {
                                    topRoundFragmentFindFragmentById.scrollBottom();
                                    LauncherDrawer mLauncherDrawer3 = launcherCardFragment.getMLauncherDrawer();
                                    if (mLauncherDrawer3 != null) {
                                        mLauncherDrawer3.enableWithKeepDrawer();
                                    }
                                }
                            } else {
                                LauncherDrawer mLauncherDrawer4 = launcherCardFragment.getMLauncherDrawer();
                                if (Intrinsics.areEqual(drawerView, mLauncherDrawer4 != null ? mLauncherDrawer4.getMBottomDrawer() : null) && (bottomFragmentFindFragmentById = launcherCardFragment.getChildFragmentManager().findFragmentById(R.id.drawer_bottom)) != null && (bottomFragmentFindFragmentById instanceof BottomFragment)) {
                                    bottomFragmentFindFragmentById.scrollToTop();
                                    LauncherDrawer mLauncherDrawer5 = launcherCardFragment.getMLauncherDrawer();
                                    if (mLauncherDrawer5 != null) {
                                        mLauncherDrawer5.enableWithKeepDrawer();
                                    }
                                }
                            }
                            LauncherDrawer mLauncherDrawer6 = launcherCardFragment.getMLauncherDrawer();
                            if (mLauncherDrawer6 != null) {
                                mLauncherDrawer6.enableBottomDrawer(true);
                            }
                            LauncherDrawer mLauncherDrawer7 = launcherCardFragment.getMLauncherDrawer();
                            if (mLauncherDrawer7 != null) {
                                mLauncherDrawer7.enableTopDrawer(true);
                            }
                        }
                    }
                }
            });
        }
        LaunchConfig launchConfigLoadConfig = getLauncherRepository().loadConfig();
        if (launchConfigLoadConfig != null && launchConfigLoadConfig.getSystemBar() == 1) {
            LauncherDrawer launcherDrawer2 = this.mLauncherDrawer;
            if (launcherDrawer2 != null) {
                launcherDrawer2.enableBottomDrawer(false);
            }
            LauncherDrawer launcherDrawer3 = this.mLauncherDrawer;
            if (launcherDrawer3 != null) {
                launcherDrawer3.enableTopDrawer(false);
            }
        }
        registerObserverReceiver();
        IntentFilter intentFilter = new IntentFilter(AppCardConfig.ACTION_ITEM_CHANGED_BROADCAST);
        intentFilter.addAction(AppCardConfig.ACTION_ITEM_CURRENT);
        requireContext().registerReceiver(this.receiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(LauncherCardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isStateSaved() || !this$0.isAdded()) {
            return;
        }
        this$0.getChildFragmentManager().beginTransaction().replace(R.id.drawer_start, new MenuFragment()).replace(R.id.drawer_top, new TopRoundFragment()).replace(R.id.drawer_bottom, new BottomFragment()).commit();
    }

    public final void initViewpager() {
        Companion companion = INSTANCE;
        Object objFindViewById = companion.getMView().findViewById(R.id.launcher_viewpager);
        Intrinsics.checkNotNullExpressionValue(objFindViewById, "findViewById(...)");
        companion.setMViewPager((OutViewPagerImpl) objFindViewById);
        companion.getMViewPager().setOffscreenPageLimit(10);
        companion.getMViewPager().setAdapter((PagerAdapter) new FragmentStatePagerAdapter(getChildFragmentManager()) { // from class: com.dw.launcher.ui.fragment.launcher.LauncherCardFragment.initViewpager.1
            public int getCount() {
                return LauncherCardFragment.this.fragments.size();
            }

            public Fragment getItem(int position) {
                Object obj = LauncherCardFragment.this.fragments.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }
        });
        companion.getMViewPager().addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.dw.launcher.ui.fragment.launcher.LauncherCardFragment.initViewpager.2
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                if (LauncherCardFragment.this.fragments.get(position) instanceof DialFragment) {
                    LauncherDrawer mLauncherDrawer = LauncherCardFragment.this.getMLauncherDrawer();
                    if (mLauncherDrawer != null) {
                        mLauncherDrawer.enable();
                    }
                    LauncherCardFragment.INSTANCE.getMViewPager().enabled();
                    Log.i("launcher", "处于表盘页了...");
                    return;
                }
                LauncherDrawer mLauncherDrawer2 = LauncherCardFragment.this.getMLauncherDrawer();
                if (mLauncherDrawer2 != null) {
                    mLauncherDrawer2.disable();
                }
                Log.i("launcher", "处于" + position);
            }
        });
    }

    public void onResume() {
        Window window;
        View decorView;
        super.onResume();
        this.isvisible = true;
        registerDoubleKey();
        if (getChildFragmentManager().findFragmentById(R.id.drawer_start) == null) {
            Timber.INSTANCE.i("----LauncherFragment, onResume", new Object[0]);
            this.mHandler.postDelayed(new Runnable() { // from class: com.dw.launcher.ui.fragment.launcher.LauncherCardFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LauncherCardFragment.onResume$lambda$2(this.f$0);
                }
            }, 3000L);
        }
        onNoDisturbChanged(Settings.Global.getInt(requireContext().getContentResolver(), "no_disturb", 0));
        Timber.Companion companion = Timber.INSTANCE;
        StringBuilder sb = new StringBuilder("----drawer_content, ");
        FragmentActivity activity = getActivity();
        companion.i(sb.append((activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) ? null : decorView.findFocus()).toString(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$2(LauncherCardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isStateSaved() || !this$0.isAdded()) {
            return;
        }
        this$0.getChildFragmentManager().beginTransaction().replace(R.id.drawer_start, new MenuFragment()).replace(R.id.drawer_top, new TopRoundFragment()).replace(R.id.drawer_bottom, new BottomFragment()).commit();
    }

    public void onPause() {
        super.onPause();
        this.isvisible = false;
        MenuFragment menuFragmentFindFragmentById = getChildFragmentManager().findFragmentById(R.id.drawer_start);
        MenuFragment menuFragment = menuFragmentFindFragmentById instanceof MenuFragment ? menuFragmentFindFragmentById : null;
        if (menuFragment == null || !menuFragment.getIsEditMode()) {
            closeDrawers();
        }
        unregisterDoubleKey();
    }

    public void onDestroy() {
        super.onDestroy();
        requireContext().unregisterReceiver(this.receiver);
    }

    public final void closeDrawers() {
        OutViewPagerImpl mViewPager2;
        LauncherDrawer launcherDrawer = this.mLauncherDrawer;
        if (launcherDrawer != null) {
            launcherDrawer.closeDrawers();
        }
        LauncherDrawer launcherDrawer2 = this.mLauncherDrawer;
        if (launcherDrawer2 != null) {
            launcherDrawer2.resetDraggers();
        }
        Companion companion = INSTANCE;
        OutViewPagerImpl mViewPager3 = companion.getMViewPager();
        if (mViewPager3 == null || !mViewPager3.getDisabled() || (mViewPager2 = companion.getMViewPager()) == null) {
            return;
        }
        mViewPager2.enabled();
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        LauncherDrawer launcherDrawer;
        Object next;
        Intrinsics.checkNotNullParameter(event, "event");
        Timber.INSTANCE.d("onKeyUp keyCode:" + keyCode + "  isvisible:" + this.isvisible, new Object[0]);
        if (this.isvisible) {
            if (keyCode == getSysKeyEvent().getSingleKeyCode()) {
                LauncherDrawer launcherDrawer2 = this.mLauncherDrawer;
                if (launcherDrawer2 != null && launcherDrawer2.childVisible()) {
                    closeDrawers();
                    return true;
                }
                OutViewPagerImpl mViewPager2 = INSTANCE.getMViewPager();
                if (mViewPager2.getCurrentItem() != 0) {
                    mViewPager2.setCurrentItem(0);
                    List fragments = getChildFragmentManager().getFragments();
                    Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
                    Iterator it = fragments.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!(((Fragment) next) instanceof CardContainerFragment));
                    CardContainerFragment cardContainerFragment = (Fragment) next;
                    if (cardContainerFragment != null) {
                        Intrinsics.checkNotNull(cardContainerFragment, "null cannot be cast to non-null type com.dw.launcher.ui.fragment.dashboard.CardContainerFragment");
                        ViewPager mViewPager3 = cardContainerFragment.getMViewPager();
                        if (mViewPager3 != null) {
                            mViewPager3.setCurrentItem(0);
                        }
                    }
                } else {
                    startActivity(new Intent(requireContext(), (Class<?>) DashboardContainerActivity.class));
                }
            } else if ((keyCode == getSysKeyEvent().getUPKey() || keyCode == getSysKeyEvent().getDownKey()) && (launcherDrawer = this.mLauncherDrawer) != null && launcherDrawer.childVisible()) {
                closeDrawers();
                return true;
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    public final void showDashboard() {
        try {
            startActivity(new Intent(requireContext(), (Class<?>) DashboardContainerActivity.class));
        } catch (Exception unused) {
            initViewpager();
            INSTANCE.getMViewPager().setCurrentItem(1);
        }
    }

    private final void registerDoubleKey() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.divo.intent.action.SWITCH_STYLE");
        this.dubbleKeyChangeReceiver = new DubbleKeyChangeReceiver();
        Context context = getContext();
        if (context != null) {
            context.registerReceiver(this.dubbleKeyChangeReceiver, intentFilter);
        }
    }

    private final void unregisterDoubleKey() {
        Context context;
        try {
            if (this.dubbleKeyChangeReceiver == null || (context = getContext()) == null) {
                return;
            }
            context.unregisterReceiver(this.dubbleKeyChangeReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: LauncherCardFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/dw/launcher/ui/fragment/launcher/LauncherCardFragment$DubbleKeyChangeReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/dw/launcher/ui/fragment/launcher/LauncherCardFragment;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public final class DubbleKeyChangeReceiver extends BroadcastReceiver {
        public DubbleKeyChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            LauncherCardFragment.INSTANCE.getMViewPager().getCurrentItem();
        }
    }

    private final void registerObserverReceiver() {
        getNoDisturbComponent().addListener(this);
        getNoDisturbComponent().addStatusMsgChangedListener(this);
    }

    public void onDestroyView() {
        super.onDestroyView();
        getNoDisturbComponent().removeListener(this);
        getNoDisturbComponent().removeStatusMsgChangedListener(this);
    }

    public void onNoDisturbChanged(int status) {
        if (status == 1 && getPhoneStatusComponent().getPhoneState() == 0 && !SystemUtils.INSTANCE.isUltraSavingMode()) {
            OutViewPagerImpl mViewPager2 = INSTANCE.getMViewPager();
            if (mViewPager2.getCurrentItem() != 0) {
                mViewPager2.setCurrentItem(0);
            }
            if (!this.isvisible) {
                activateLauncher();
            }
            Intent intent = new Intent(getContext(), (Class<?>) NoDisturbActivity.class);
            intent.setFlags(268435456);
            startActivity(intent);
            Timber.INSTANCE.d("进入进课模式", new Object[0]);
        }
    }

    private final void activateLauncher() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(268435456);
        intent.addCategory("android.intent.category.HOME");
        requireContext().startActivity(intent);
    }

    public final BroadcastReceiver getReceiver() {
        return this.receiver;
    }

    public void onStatusMsgChanged(int mode) {
        if (mode == 1) {
            LaunchConfig launchConfigLoadConfig = getLauncherRepository().loadConfig();
            if (launchConfigLoadConfig != null) {
                launchConfigLoadConfig.setSystemBar(1);
            }
            LauncherDrawer launcherDrawer = this.mLauncherDrawer;
            if (launcherDrawer != null) {
                launcherDrawer.enableBottomDrawer(false);
            }
            LauncherDrawer launcherDrawer2 = this.mLauncherDrawer;
            if (launcherDrawer2 != null) {
                launcherDrawer2.enableTopDrawer(false);
                return;
            }
            return;
        }
        SystemUtils systemUtils = SystemUtils.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (systemUtils.useSystemStatusBar(contextRequireContext) == 1) {
            LaunchConfig launchConfigLoadConfig2 = getLauncherRepository().loadConfig();
            if (launchConfigLoadConfig2 != null) {
                launchConfigLoadConfig2.setSystemBar(1);
            }
            LauncherDrawer launcherDrawer3 = this.mLauncherDrawer;
            if (launcherDrawer3 != null) {
                launcherDrawer3.enableBottomDrawer(false);
            }
            LauncherDrawer launcherDrawer4 = this.mLauncherDrawer;
            if (launcherDrawer4 != null) {
                launcherDrawer4.enableTopDrawer(false);
                return;
            }
            return;
        }
        LaunchConfig launchConfigLoadConfig3 = getLauncherRepository().loadConfig();
        if (launchConfigLoadConfig3 != null) {
            launchConfigLoadConfig3.setSystemBar(0);
        }
        LauncherDrawer launcherDrawer5 = this.mLauncherDrawer;
        if (launcherDrawer5 != null) {
            launcherDrawer5.enableBottomDrawer(true);
        }
        LauncherDrawer launcherDrawer6 = this.mLauncherDrawer;
        if (launcherDrawer6 != null) {
            launcherDrawer6.enableTopDrawer(true);
        }
    }
}
