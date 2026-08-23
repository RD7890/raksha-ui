package com.dw.launcher.ui.activity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.core.component.SensorComponent;
import com.dw.launcher.data.config.AppFilterConfig;
import com.dw.launcher.data.config.LauncherConfig;
import com.dw.launcher.data.database.dao.ClockConfigDao;
import com.dw.launcher.data.entity.Clock;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.data.entity.DialPreviewInfo;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.dw.launcher.util.ResourceUtils;
import com.dw.launcher.util.SystemUtils;
import com.dw.launcher.util.WatchFactory;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import timber.log.Timber;

/* JADX INFO: compiled from: PickClockActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000¿\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001)\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010F\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020GH\u0016J\u000e\u0010I\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u0018J\b\u0010K\u001a\u00020LH\u0016J\"\u0010M\u001a\u00020G2\u0006\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020L2\b\u0010P\u001a\u0004\u0018\u00010QH\u0014J\b\u0010R\u001a\u00020GH\u0016J\u0012\u0010S\u001a\u00020G2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u0012\u0010V\u001a\u00020G2\b\u0010W\u001a\u0004\u0018\u00010XH\u0014J\b\u0010Y\u001a\u00020GH\u0014J\u0018\u0010Z\u001a\u00020\u00122\u0006\u0010[\u001a\u00020L2\u0006\u0010\\\u001a\u00020]H\u0016J\u0018\u0010^\u001a\u00020\u00122\u0006\u0010[\u001a\u00020L2\u0006\u0010\\\u001a\u00020]H\u0016J\b\u0010_\u001a\u00020GH\u0014J\b\u0010`\u001a\u00020GH\u0014J\u0010\u0010a\u001a\u00020\u00122\u0006\u0010b\u001a\u00020\u0012H\u0016J\b\u0010c\u001a\u00020GH\u0016J\b\u0010d\u001a\u00020GH\u0014J\u0016\u0010e\u001a\u00020G2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020iJ\u0018\u0010e\u001a\u00020G2\u0006\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010jR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0002068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010=\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0014\"\u0004\b?\u0010\u0016R\u001e\u0010@\u001a\u00020A8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006k"}, d2 = {"Lcom/dw/launcher/ui/activity/PickClockActivity;", "Lcom/dw/launcher/base/BaseActivity;", "Lcom/dw/launcher/core/component/SensorComponent$OnSensorChangedListener;", "Landroid/view/View$OnClickListener;", "()V", "assertLauncherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getAssertLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setAssertLauncherRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "clockConfigDao", "Lcom/dw/launcher/data/database/dao/ClockConfigDao;", "getClockConfigDao", "()Lcom/dw/launcher/data/database/dao/ClockConfigDao;", "setClockConfigDao", "(Lcom/dw/launcher/data/database/dao/ClockConfigDao;)V", "customChanged", "", "getCustomChanged", "()Z", "setCustomChanged", "(Z)V", "fileROOT", "Ljava/io/File;", "isFirst", "setFirst", "isToSetWatch", "setToSetWatch", "lastTurnOnTimestamp", "", "getLastTurnOnTimestamp", "()J", "setLastTurnOnTimestamp", "(J)V", "mClearScreenFlagTask", "Ljava/lang/Runnable;", "mClockList", "", "Lcom/dw/launcher/data/entity/DialPreviewInfo;", "mClockStyleObserver", "com/dw/launcher/ui/activity/PickClockActivity$mClockStyleObserver$1", "Lcom/dw/launcher/ui/activity/PickClockActivity$mClockStyleObserver$1;", "mHandler", "Landroid/os/Handler;", "mLastClockStyle", "", "mPreference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "getMPreference", "()Lcom/dw/launcher/data/preference/LauncherPreference;", "setMPreference", "(Lcom/dw/launcher/data/preference/LauncherPreference;)V", "mSensorComponent", "Lcom/dw/launcher/core/component/SensorComponent;", "getMSensorComponent", "()Lcom/dw/launcher/core/component/SensorComponent;", "setMSensorComponent", "(Lcom/dw/launcher/core/component/SensorComponent;)V", "mViewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "support_delete_internal_dial", "getSupport_delete_internal_dial", "setSupport_delete_internal_dial", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "checkClockStyle", "", "closeScreenFlagTask", "deleteDir", "dir", "getLayoutId", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onPause", "onResume", "onSensorChanged", "up", "onSensorStopped", "onUserLeaveHint", "showDialPreview", "view", "Landroid/widget/ImageView;", "preview", "Landroid/graphics/drawable/BitmapDrawable;", "Landroid/graphics/drawable/Drawable;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class PickClockActivity extends Hilt_PickClockActivity implements SensorComponent.OnSensorChangedListener, View.OnClickListener {

    @Inject
    public LauncherRepository assertLauncherRepository;

    @Inject
    public ClockConfigDao clockConfigDao;
    private boolean customChanged;
    private final File fileROOT;
    private boolean isFirst;
    private boolean isToSetWatch;
    private long lastTurnOnTimestamp;
    private final Runnable mClearScreenFlagTask;
    private final List<DialPreviewInfo> mClockList = new ArrayList();
    private final PickClockActivity$mClockStyleObserver$1 mClockStyleObserver;
    private final Handler mHandler;
    private String mLastClockStyle;

    @Inject
    public LauncherPreference mPreference;

    @Inject
    public SensorComponent mSensorComponent;
    private ViewPager2 mViewPager2;
    private boolean support_delete_internal_dial;

    @Inject
    public SysKeyEvent sysKeyEvent;

    /* JADX WARN: Type inference failed for: r1v3, types: [com.dw.launcher.ui.activity.PickClockActivity$mClockStyleObserver$1] */
    public PickClockActivity() {
        final Handler handler = new Handler(Looper.getMainLooper());
        this.mHandler = handler;
        this.fileROOT = new File(Environment.getRootDirectory().getPath() + "/dw_config/dial");
        this.isFirst = true;
        this.mClockStyleObserver = new ContentObserver(handler) { // from class: com.dw.launcher.ui.activity.PickClockActivity$mClockStyleObserver$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                this.this$0.checkClockStyle();
            }
        };
        this.mClearScreenFlagTask = new Runnable() { // from class: com.dw.launcher.ui.activity.PickClockActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PickClockActivity.mClearScreenFlagTask$lambda$6(this.f$0);
            }
        };
    }

    public int getLayoutId() {
        return R.layout.activity_pick_clock;
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

    public final LauncherRepository getAssertLauncherRepository() {
        LauncherRepository launcherRepository = this.assertLauncherRepository;
        if (launcherRepository != null) {
            return launcherRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("assertLauncherRepository");
        return null;
    }

    public final void setAssertLauncherRepository(LauncherRepository launcherRepository) {
        Intrinsics.checkNotNullParameter(launcherRepository, "<set-?>");
        this.assertLauncherRepository = launcherRepository;
    }

    public final ClockConfigDao getClockConfigDao() {
        ClockConfigDao clockConfigDao = this.clockConfigDao;
        if (clockConfigDao != null) {
            return clockConfigDao;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clockConfigDao");
        return null;
    }

    public final void setClockConfigDao(ClockConfigDao clockConfigDao) {
        Intrinsics.checkNotNullParameter(clockConfigDao, "<set-?>");
        this.clockConfigDao = clockConfigDao;
    }

    public final long getLastTurnOnTimestamp() {
        return this.lastTurnOnTimestamp;
    }

    public final void setLastTurnOnTimestamp(long j) {
        this.lastTurnOnTimestamp = j;
    }

    public final boolean getCustomChanged() {
        return this.customChanged;
    }

    public final void setCustomChanged(boolean z) {
        this.customChanged = z;
    }

    /* JADX INFO: renamed from: isFirst, reason: from getter */
    public final boolean getIsFirst() {
        return this.isFirst;
    }

    public final void setFirst(boolean z) {
        this.isFirst = z;
    }

    public final boolean getSupport_delete_internal_dial() {
        return this.support_delete_internal_dial;
    }

    public final void setSupport_delete_internal_dial(boolean z) {
        this.support_delete_internal_dial = z;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0039  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.dw.launcher.ui.activity.Hilt_PickClockActivity
    protected void onCreate(Bundle savedInstanceState) {
        boolean z;
        LaunchConfig launchConfigLoadConfig;
        super.onCreate(savedInstanceState);
        ViewPager2 viewPager2FindViewById = findViewById(R.id.pick_clock_viewpager);
        Intrinsics.checkNotNullExpressionValue(viewPager2FindViewById, "findViewById(...)");
        this.mViewPager2 = viewPager2FindViewById;
        this.mClockList.clear();
        this.mClockList.addAll(WatchFactory.INSTANCE.getDialList());
        LauncherRepository assertLauncherRepository = getAssertLauncherRepository();
        if (assertLauncherRepository != null && (launchConfigLoadConfig = assertLauncherRepository.loadConfig()) != null) {
            z = launchConfigLoadConfig.getSupport_delete_internal_dial() == 1;
        }
        this.support_delete_internal_dial = z;
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage("com.timuen.divo.weardialmarket");
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setComponent(getComponentName());
            launchIntentForPackage.setFlags(268435456);
            AppFilterConfig appFilterConfig = AppFilterConfig.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            if (appFilterConfig.isIntentAvailable(applicationContext, launchIntentForPackage)) {
                DialPreviewInfo dialPreviewInfo = new DialPreviewInfo();
                dialPreviewInfo.setDialName(getString(R.string.moreDial));
                dialPreviewInfo.setDialSource(WatchFactory.INSTANCE.getDIAL_SOURCE_More());
                this.mClockList.add(dialPreviewInfo);
            }
        } else {
            Intent launchIntentForPackage2 = getPackageManager().getLaunchIntentForPackage("dw.dial.store");
            if (launchIntentForPackage2 != null) {
                launchIntentForPackage2.setComponent(getComponentName());
                launchIntentForPackage2.setFlags(268435456);
                AppFilterConfig appFilterConfig2 = AppFilterConfig.INSTANCE;
                Context applicationContext2 = getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                if (appFilterConfig2.isIntentAvailable(applicationContext2, launchIntentForPackage2)) {
                    DialPreviewInfo dialPreviewInfo2 = new DialPreviewInfo();
                    dialPreviewInfo2.setDialName(getString(R.string.moreDial));
                    dialPreviewInfo2.setDialSource(WatchFactory.INSTANCE.getDIAL_SOURCE_More());
                    this.mClockList.add(dialPreviewInfo2);
                }
            }
        }
        ViewPager2 viewPager2 = this.mViewPager2;
        ViewPager2 viewPager3 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager2 = null;
        }
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        checkClockStyle();
        getContentResolver().registerContentObserver(LauncherConfig.INSTANCE.getURI_CLOCK_STYLE(), false, this.mClockStyleObserver);
        ViewPager2 viewPager4 = this.mViewPager2;
        if (viewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager4 = null;
        }
        viewPager4.setAdapter(new AnonymousClass1(R.layout.pick_clock_item, this.mClockList));
        ViewPager2 viewPager5 = this.mViewPager2;
        if (viewPager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager5 = null;
        }
        RecyclerView childAt = viewPager5.getChildAt(0);
        Intrinsics.checkNotNull(childAt);
        RecyclerView recyclerView = childAt;
        int iDpToPx = (int) ResourceUtils.dpToPx((Context) this, 60.0f);
        recyclerView.setPadding(iDpToPx, 0, iDpToPx, 0);
        recyclerView.setClipToPadding(false);
        ViewPager2 viewPager6 = this.mViewPager2;
        if (viewPager6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager6 = null;
        }
        viewPager6.setOffscreenPageLimit(-1);
        ViewPager2.PageTransformer pageTransformer = new ViewPager2.PageTransformer() { // from class: com.dw.launcher.ui.activity.PickClockActivity$$ExternalSyntheticLambda3
            public final void transformPage(View view, float f) {
                PickClockActivity.onCreate$lambda$0(view, f);
            }
        };
        ViewPager2 viewPager7 = this.mViewPager2;
        if (viewPager7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
        } else {
            viewPager3 = viewPager7;
        }
        viewPager3.setPageTransformer(pageTransformer);
        checkClockStyle();
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.activity.PickClockActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: PickClockActivity.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0015¨\u0006\b"}, d2 = {"com/dw/launcher/ui/activity/PickClockActivity$onCreate$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/DialPreviewInfo;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class AnonymousClass1 extends BaseQuickAdapter<DialPreviewInfo, BaseViewHolder> {
        AnonymousClass1(int i, List<DialPreviewInfo> list) {
            super(i, list);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code duplicated, block: B:38:0x0170  */
        public void convert(BaseViewHolder holder, final DialPreviewInfo item) {
            Object next;
            int i;
            ClockConfigFlatter flatter;
            ClockConfig config;
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            ImageView imageView = (ImageView) holder.getView(R.id.pick_clock_preview);
            ConstraintLayout view = holder.getView(R.id.llBottom);
            ImageView imageView2 = (ImageView) holder.getView(R.id.pick_special_preview);
            ImageView imageView3 = (ImageView) holder.getView(R.id.image_selected);
            ImageView imageView4 = (ImageView) holder.getView(R.id.image_setting);
            ImageView imageView5 = (ImageView) holder.getView(R.id.image_del);
            final ImageView imageView6 = (ImageView) holder.getView(R.id.image_lock);
            TextView textView = (TextView) holder.getView(R.id.pick_clock_name);
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = StringsKt.contains$default((CharSequence) SystemUtils.INSTANCE.getLanguage(getContext()), (CharSequence) "zh", false, 2, (Object) null);
            textView.setText(item.getDialName());
            if (item.getDialSource() == WatchFactory.INSTANCE.getDIAL_SOURCE_More()) {
                imageView2.setVisibility(8);
                view.setVisibility(4);
                imageView.setImageDrawable(PickClockActivity.this.getDrawable(R.mipmap.icon_dial_more));
                final PickClockActivity pickClockActivity = PickClockActivity.this;
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.PickClockActivity$onCreate$1$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        PickClockActivity.AnonymousClass1.convert$lambda$0(pickClockActivity, this, view2);
                    }
                });
                return;
            }
            view.setVisibility(0);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new PickClockActivity$onCreate$1$convert$2(item, imageView2, PickClockActivity.this, imageView, imageView5, this, holder, null), 3, null);
            imageView.setOnClickListener(PickClockActivity.this);
            List list = PickClockActivity.this.mClockList;
            PickClockActivity pickClockActivity2 = PickClockActivity.this;
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                DialPreviewInfo dialPreviewInfo = (DialPreviewInfo) next;
                if (Intrinsics.areEqual(String.valueOf(dialPreviewInfo.getDialId()), pickClockActivity2.getMPreference().getPreferClock()) && dialPreviewInfo.getDialSource() == pickClockActivity2.getMPreference().getCurrentDialSource()) {
                    break;
                }
            }
            DialPreviewInfo dialPreviewInfo2 = (DialPreviewInfo) next;
            if (dialPreviewInfo2 != null) {
                final PickClockActivity pickClockActivity3 = PickClockActivity.this;
                boolean z = item.getDialId() == dialPreviewInfo2.getDialId() && item.getDialSource() == pickClockActivity3.getMPreference().getCurrentDialSource();
                imageView3.setVisibility(z ? 0 : 8);
                if (z) {
                    LaunchConfig launchConfigLoadConfig = pickClockActivity3.getAssertLauncherRepository().loadConfig();
                    Integer numValueOf = launchConfigLoadConfig != null ? Integer.valueOf(launchConfigLoadConfig.getHidedDialLock()) : null;
                    if (numValueOf != null && numValueOf.intValue() == 1) {
                        i = 8;
                    } else {
                        i = 0;
                    }
                } else {
                    i = 8;
                }
                imageView6.setVisibility(i);
                imageView6.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.PickClockActivity$onCreate$1$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        PickClockActivity.AnonymousClass1.convert$lambda$5$lambda$2(pickClockActivity3, imageView6, view2);
                    }
                });
                Clock clock = item.getClock();
                boolean z2 = Intrinsics.areEqual((clock == null || (flatter = clock.getFlatter()) == null || (config = flatter.getConfig()) == null) ? null : config.getBg_is_customize(), "1") && item.getDialSource() == WatchFactory.INSTANCE.getDIAL_SOURCE_LOCAL();
                imageView2.setVisibility(z2 ? 0 : 8);
                imageView4.setVisibility(z2 ? 0 : 8);
                imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.PickClockActivity$onCreate$1$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        PickClockActivity.AnonymousClass1.convert$lambda$5$lambda$4(pickClockActivity3, item, booleanRef, view2);
                    }
                });
                imageView6.setImageResource(pickClockActivity3.getMPreference().isClockLocked() ? R.drawable.ic_lock : R.drawable.ic_unlock);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$0(PickClockActivity this$0, AnonymousClass1 this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intent launchIntentForPackage = this$0.getPackageManager().getLaunchIntentForPackage("com.timuen.divo.weardialmarket");
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                if (AppFilterConfig.INSTANCE.isIntentAvailable(this$1.getContext(), launchIntentForPackage)) {
                    this$1.getContext().startActivity(launchIntentForPackage);
                    this$0.finish();
                    return;
                }
                return;
            }
            Intent launchIntentForPackage2 = this$0.getPackageManager().getLaunchIntentForPackage("dw.dial.store");
            if (launchIntentForPackage2 != null) {
                launchIntentForPackage2.setFlags(268435456);
                if (AppFilterConfig.INSTANCE.isIntentAvailable(this$1.getContext(), launchIntentForPackage2)) {
                    this$1.getContext().startActivity(launchIntentForPackage2);
                    this$0.finish();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$5$lambda$2(PickClockActivity this$0, ImageView lockView, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(lockView, "$lockView");
            boolean zIsClockLocked = this$0.getMPreference().isClockLocked();
            this$0.getMPreference().setClockLocked(!zIsClockLocked);
            lockView.setImageResource(zIsClockLocked ? R.drawable.ic_unlock : R.drawable.ic_lock);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void convert$lambda$5$lambda$4(PickClockActivity this$0, DialPreviewInfo item, Ref.BooleanRef isZh, View view) {
            String str;
            ClockConfigFlatter flatter;
            ClockConfig config;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(isZh, "$isZh");
            Intent intent = new Intent((Context) this$0, (Class<?>) CustomWatchActivity.class);
            intent.putExtra("fileName", String.valueOf(item.getDialId()));
            intent.putExtra("customWatchId", String.valueOf(item.getDialId()));
            Clock clock = item.getClock();
            if (clock == null || (flatter = clock.getFlatter()) == null || (config = flatter.getConfig()) == null || !config.isFromAssets()) {
                str = this$0.fileROOT + '/' + item.getDialId() + '/' + (isZh.element ? "res/bg/bg.png" : "en/res/bg/bg.png");
            } else {
                str = "file:///android_asset/clock/" + item.getDialId() + '/' + (isZh.element ? "res/bg/bg.png" : "en/res/bg/bg.png");
            }
            intent.putExtra("filepath", str);
            this$0.setToSetWatch(true);
            this$0.startActivityForResult(intent, 999);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(View page, float f) {
        Intrinsics.checkNotNullParameter(page, "page");
        float f2 = 1;
        float fAbs = ((f2 - Math.abs(f)) * 0.15f) + 0.85f;
        page.setScaleY(fAbs);
        page.setScaleX(fAbs);
        page.setAlpha(((f2 - Math.abs(f)) * 0.5f) + 0.5f);
    }

    public final void showDialPreview(ImageView view, BitmapDrawable preview) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(preview, "preview");
        if (Build.VERSION.SDK_INT >= 28) {
            Glide.with((FragmentActivity) this).load(preview).centerInside().into(view);
        } else {
            view.setImageDrawable(preview);
        }
    }

    public final void showDialPreview(ImageView view, Drawable preview) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (Build.VERSION.SDK_INT >= 28) {
            Glide.with((FragmentActivity) this).load(preview).centerInside().into(view);
        } else {
            view.setImageDrawable(preview);
        }
    }

    @Override // com.dw.launcher.ui.activity.Hilt_PickClockActivity
    protected void onDestroy() {
        super.onDestroy();
        ContentResolver contentResolver = getContentResolver();
        if (contentResolver != null) {
            contentResolver.unregisterContentObserver(this.mClockStyleObserver);
        }
    }

    protected void onResume() {
        super.onResume();
        getMSensorComponent().register(this);
        ViewPager2 viewPager2 = null;
        if (!this.isFirst) {
            ViewPager2 viewPager3 = this.mViewPager2;
            if (viewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                viewPager3 = null;
            }
            RecyclerView.Adapter adapter = viewPager3.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            ViewPager2 viewPager4 = this.mViewPager2;
            if (viewPager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            } else {
                viewPager2 = viewPager4;
            }
            viewPager2.post(new Runnable() { // from class: com.dw.launcher.ui.activity.PickClockActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    PickClockActivity.onResume$lambda$1(this.f$0);
                }
            });
            Timber.INSTANCE.d("isFirst = " + this.isFirst, new Object[0]);
        } else {
            ViewPager2 viewPager5 = this.mViewPager2;
            if (viewPager5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            } else {
                viewPager2 = viewPager5;
            }
            RecyclerView.Adapter adapter2 = viewPager2.getAdapter();
            if (adapter2 != null) {
                adapter2.notifyDataSetChanged();
            }
        }
        this.isFirst = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$1(PickClockActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager2 viewPager2 = this$0.mViewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager2 = null;
        }
        viewPager2.requestTransform();
    }

    protected void onPause() {
        super.onPause();
        getMSensorComponent().unregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkClockStyle() {
        ViewPager2 viewPager2;
        Object next;
        if (Intrinsics.areEqual(this.mLastClockStyle, getMPreference().getPreferClock())) {
            return;
        }
        Iterator<T> it = this.mClockList.iterator();
        while (true) {
            viewPager2 = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            DialPreviewInfo dialPreviewInfo = (DialPreviewInfo) next;
            if (Intrinsics.areEqual(String.valueOf(dialPreviewInfo.getDialId()), getMPreference().getPreferClock()) && dialPreviewInfo.getDialSource() == getMPreference().getCurrentDialSource()) {
                break;
            }
        }
        DialPreviewInfo dialPreviewInfo2 = (DialPreviewInfo) next;
        if (dialPreviewInfo2 != null) {
            ViewPager2 viewPager3 = this.mViewPager2;
            if (viewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            } else {
                viewPager2 = viewPager3;
            }
            viewPager2.setCurrentItem(this.mClockList.indexOf(dialPreviewInfo2), false);
        }
    }

    public boolean onSensorChanged(boolean up) {
        this.mHandler.removeCallbacks(this.mClearScreenFlagTask);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(128);
        }
        if (System.currentTimeMillis() - this.lastTurnOnTimestamp <= 100) {
            return false;
        }
        ViewPager2 viewPager2 = this.mViewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager2 = null;
        }
        if (viewPager2.getChildCount() <= 0) {
            return false;
        }
        int currentItem = viewPager2.getCurrentItem();
        int i = up ? currentItem + 1 : currentItem - 1;
        if (i >= 0 && i < this.mClockList.size()) {
            viewPager2.setCurrentItem(i % this.mClockList.size(), true);
            this.lastTurnOnTimestamp = System.currentTimeMillis();
        }
        return true;
    }

    public void onSensorStopped() {
        SensorComponent.OnSensorChangedListener.DefaultImpls.onSensorStopped(this);
        closeScreenFlagTask();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        ViewPager2 viewPager2 = this.mViewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager2 = null;
        }
        DialPreviewInfo dialPreviewInfo = this.mClockList.get(viewPager2.getCurrentItem());
        Timber.INSTANCE.i("----onClockSelected: " + dialPreviewInfo.getDialId(), new Object[0]);
        LauncherPreference mPreference = getMPreference();
        String strValueOf = String.valueOf(dialPreviewInfo.getDialId());
        Intrinsics.checkNotNull(strValueOf);
        mPreference.setPreferClock(strValueOf);
        getMPreference().setCurrentDialSource(dialPreviewInfo.getDialSource());
        finish();
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
            int currentItem = viewPager3.getCurrentItem() + 1;
            this.mClockList.size();
            ViewPager2 viewPager4 = this.mViewPager2;
            if (viewPager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            } else {
                viewPager2 = viewPager4;
            }
            viewPager2.setCurrentItem(currentItem, true);
            return true;
        }
        if (keyCode == getSysKeyEvent().getDownKey()) {
            Window window2 = getWindow();
            if (window2 != null) {
                window2.addFlags(128);
            }
            closeScreenFlagTask();
            ViewPager2 viewPager5 = this.mViewPager2;
            if (viewPager5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                viewPager5 = null;
            }
            int currentItem2 = viewPager5.getCurrentItem() - 1;
            ViewPager2 viewPager6 = this.mViewPager2;
            if (viewPager6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            } else {
                viewPager2 = viewPager6;
            }
            viewPager2.setCurrentItem(currentItem2, true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == getSysKeyEvent().getUPKey() || keyCode == getSysKeyEvent().getDownKey()) {
            closeScreenFlagTask();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void closeScreenFlagTask() {
        this.mHandler.removeCallbacks(this.mClearScreenFlagTask);
        this.mHandler.postDelayed(this.mClearScreenFlagTask, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mClearScreenFlagTask$lambda$6(PickClockActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Window window = this$0.getWindow();
        if (window != null) {
            window.clearFlags(128);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == -1) {
            ViewPager2 viewPager2 = null;
            String stringExtra = data != null ? data.getStringExtra("customWatchId") : null;
            ViewPager2 viewPager3 = this.mViewPager2;
            if (viewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                viewPager3 = null;
            }
            RecyclerView.Adapter adapter = viewPager3.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            ViewPager2 viewPager4 = this.mViewPager2;
            if (viewPager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            } else {
                viewPager2 = viewPager4;
            }
            viewPager2.post(new Runnable() { // from class: com.dw.launcher.ui.activity.PickClockActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PickClockActivity.onActivityResult$lambda$7(this.f$0);
                }
            });
            this.customChanged = true;
            Intent intent = new Intent("customwatch_config_changed");
            intent.putExtra("id", stringExtra);
            sendBroadcast(intent);
        }
        this.isToSetWatch = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityResult$lambda$7(PickClockActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager2 viewPager2 = this$0.mViewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager2 = null;
        }
        viewPager2.requestTransform();
    }

    /* JADX INFO: renamed from: isToSetWatch, reason: from getter */
    public final boolean getIsToSetWatch() {
        return this.isToSetWatch;
    }

    public final void setToSetWatch(boolean z) {
        this.isToSetWatch = z;
    }

    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (!this.isToSetWatch) {
            finish();
        }
        Timber.INSTANCE.d("onUserLeaveHint....isToSetWatch:" + this.isToSetWatch, new Object[0]);
    }

    public final boolean deleteDir(File dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        if (dir.isDirectory()) {
            String[] list = dir.list();
            if (list == null) {
                return false;
            }
            for (String str : list) {
                if (!deleteDir(new File(dir, str))) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
