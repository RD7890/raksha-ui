package com.dw.launcher.ui.fragment.clock;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.dw.launcher.R;
import com.dw.launcher.core.component.CompassSensorComponent;
import com.dw.launcher.core.component.SensorComponent;
import com.dw.launcher.core.component.SoundEffect;
import com.dw.launcher.data.config.AppFilterConfig;
import com.dw.launcher.data.config.LauncherConfig;
import com.dw.launcher.data.entity.Clock;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.listener.AbstractWatchItemClickListener;
import com.dw.launcher.data.listener.OnWatchItemClickListener;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.AssetsClockRepository;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.hilt.annotion.RingToneAnnotion;
import com.dw.launcher.ui.activity.PickClockActivity;
import com.dw.launcher.ui.clock.ClockRegister;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.dw.launcher.ui.clock.widget.CommonClock;
import com.dw.launcher.ui.fragment.launcher.LauncherCardFragment;
import com.dw.launcher.ui.fragment.launcher.LauncherFragment;
import com.dw.launcher.ui.view.LauncherDrawer;
import com.dw.launcher.ui.view.ViewPagerImpl;
import com.dw.launcher.util.ClockSingleton;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import timber.log.Timber;

/* JADX INFO: compiled from: ClockContainerFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u0015'\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010^\u001a\u00020_H\u0002J\b\u0010`\u001a\u000207H\u0016J\u0010\u0010a\u001a\u00020_2\u0006\u0010b\u001a\u00020cH\u0016J\u0010\u0010d\u001a\u00020\u00182\u0006\u0010e\u001a\u00020fH\u0016J\b\u0010g\u001a\u00020_H\u0016J\u0018\u0010h\u001a\u00020\u00182\u0006\u0010i\u001a\u0002072\u0006\u0010j\u001a\u00020kH\u0016J\u0018\u0010l\u001a\u00020\u00182\u0006\u0010i\u001a\u0002072\u0006\u0010j\u001a\u00020kH\u0016J\u0010\u0010m\u001a\u00020_2\u0006\u0010n\u001a\u000207H\u0016J\b\u0010o\u001a\u00020_H\u0016J\b\u0010p\u001a\u00020_H\u0016J\u0010\u0010q\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u0018H\u0016J\b\u0010s\u001a\u00020_H\u0016J\u001a\u0010t\u001a\u00020_2\u0006\u0010u\u001a\u00020v2\b\u0010w\u001a\u0004\u0018\u00010xH\u0016J\u000e\u0010y\u001a\u00020_2\u0006\u0010z\u001a\u00020\u001fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00108\u001a\u0002098\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010>\u001a\u00020?8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b@\u0010\u0005\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001e\u0010E\u001a\u00020F8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010R\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR&\u0010X\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00130YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]¨\u0006{"}, d2 = {"Lcom/dw/launcher/ui/fragment/clock/ClockContainerFragment;", "Lcom/dw/launcher/base/BaseFragment;", "Lcom/dw/launcher/ui/fragment/clock/ClockViewPagerLayoutManager$OnPageChangedListener;", "Lcom/dw/launcher/core/component/SensorComponent$OnSensorChangedListener;", "Lcom/dw/launcher/core/component/CompassSensorComponent$OnCompassSensorChangedListener;", "()V", "assertLauncherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getAssertLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setAssertLauncherRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "assetsClockRepository", "Lcom/dw/launcher/data/repository/AssetsClockRepository;", "getAssetsClockRepository", "()Lcom/dw/launcher/data/repository/AssetsClockRepository;", "setAssetsClockRepository", "(Lcom/dw/launcher/data/repository/AssetsClockRepository;)V", "comcomClock", "Lcom/dw/launcher/ui/clock/widget/CommonClock;", "customWatchBroadcaster", "com/dw/launcher/ui/fragment/clock/ClockContainerFragment$customWatchBroadcaster$1", "Lcom/dw/launcher/ui/fragment/clock/ClockContainerFragment$customWatchBroadcaster$1;", "isVisbile", "", "lastTurnTimeStamp", "", "mAdapter", "Landroidx/viewpager/widget/PagerAdapter;", "mClockList", "", "Lcom/dw/launcher/data/entity/Clock;", "mClockRegister", "Lcom/dw/launcher/ui/clock/ClockRegister;", "getMClockRegister", "()Lcom/dw/launcher/ui/clock/ClockRegister;", "setMClockRegister", "(Lcom/dw/launcher/ui/clock/ClockRegister;)V", "mClockStyleObserver", "com/dw/launcher/ui/fragment/clock/ClockContainerFragment$mClockStyleObserver$1", "Lcom/dw/launcher/ui/fragment/clock/ClockContainerFragment$mClockStyleObserver$1;", "mClockViewModel", "Lcom/dw/launcher/ui/fragment/clock/ClockViewModel;", "mCompassSensorComponent", "Lcom/dw/launcher/core/component/CompassSensorComponent;", "getMCompassSensorComponent", "()Lcom/dw/launcher/core/component/CompassSensorComponent;", "setMCompassSensorComponent", "(Lcom/dw/launcher/core/component/CompassSensorComponent;)V", "mHandler", "Landroid/os/Handler;", "mHasSetTask", "mLastClockStyle", "", "mPosition", "", "mPreference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "getMPreference", "()Lcom/dw/launcher/data/preference/LauncherPreference;", "setMPreference", "(Lcom/dw/launcher/data/preference/LauncherPreference;)V", "mRingtoneComponent", "Lcom/dw/launcher/core/component/SoundEffect;", "getMRingtoneComponent$annotations", "getMRingtoneComponent", "()Lcom/dw/launcher/core/component/SoundEffect;", "setMRingtoneComponent", "(Lcom/dw/launcher/core/component/SoundEffect;)V", "mSensorComponent", "Lcom/dw/launcher/core/component/SensorComponent;", "getMSensorComponent", "()Lcom/dw/launcher/core/component/SensorComponent;", "setMSensorComponent", "(Lcom/dw/launcher/core/component/SensorComponent;)V", "mSet", "mSetTask", "Ljava/lang/Runnable;", "mToast", "Landroid/widget/Toast;", "mViewPager", "Lcom/dw/launcher/ui/view/ViewPagerImpl;", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "viewClockMap", "", "getViewClockMap", "()Ljava/util/Map;", "setViewClockMap", "(Ljava/util/Map;)V", "checkClockStyle", "", "getLayoutId", "onAttach", "context", "Landroid/content/Context;", "onCompassSensorChanged", "rotation", "", "onDetach", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onPageChanged", "page", "onPause", "onResume", "onSensorChanged", "up", "onSensorStopped", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setCustomWatchPath", "clock", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class ClockContainerFragment extends Hilt_ClockContainerFragment implements ClockViewPagerLayoutManager.OnPageChangedListener, SensorComponent.OnSensorChangedListener, CompassSensorComponent.OnCompassSensorChangedListener {

    @Inject
    public LauncherRepository assertLauncherRepository;

    @Inject
    public AssetsClockRepository assetsClockRepository;
    private CommonClock comcomClock;
    private final ClockContainerFragment$customWatchBroadcaster$1 customWatchBroadcaster;
    private boolean isVisbile;
    private long lastTurnTimeStamp;
    private PagerAdapter mAdapter;
    private final List<Clock> mClockList;

    @Inject
    public ClockRegister mClockRegister;
    private final ClockContainerFragment$mClockStyleObserver$1 mClockStyleObserver;
    private ClockViewModel mClockViewModel;

    @Inject
    public CompassSensorComponent mCompassSensorComponent;
    private final Handler mHandler;
    private boolean mHasSetTask;
    private String mLastClockStyle;
    private int mPosition;

    @Inject
    public LauncherPreference mPreference;

    @Inject
    public SoundEffect mRingtoneComponent;

    @Inject
    public SensorComponent mSensorComponent;
    private boolean mSet;
    private final Runnable mSetTask;
    private Toast mToast;
    private ViewPagerImpl mViewPager;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private Map<Integer, CommonClock> viewClockMap;

    @RingToneAnnotion
    public static /* synthetic */ void getMRingtoneComponent$annotations() {
    }

    public final void setCustomWatchPath(Clock clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.dw.launcher.ui.fragment.clock.ClockContainerFragment$customWatchBroadcaster$1] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.dw.launcher.ui.fragment.clock.ClockContainerFragment$mClockStyleObserver$1] */
    public ClockContainerFragment() {
        final Handler handler = new Handler(Looper.getMainLooper());
        this.mHandler = handler;
        this.mClockList = new ArrayList();
        this.viewClockMap = new LinkedHashMap();
        this.mSetTask = new Runnable() { // from class: com.dw.launcher.ui.fragment.clock.ClockContainerFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ClockContainerFragment.mSetTask$lambda$0(this.f$0);
            }
        };
        this.mClockStyleObserver = new ContentObserver(handler) { // from class: com.dw.launcher.ui.fragment.clock.ClockContainerFragment$mClockStyleObserver$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                this.this$0.checkClockStyle();
            }
        };
        this.customWatchBroadcaster = new BroadcastReceiver() { // from class: com.dw.launcher.ui.fragment.clock.ClockContainerFragment$customWatchBroadcaster$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (Intrinsics.areEqual("customwatch_config_changed", intent != null ? intent.getAction() : null)) {
                    String stringExtra = intent != null ? intent.getStringExtra("id") : null;
                    List list = this.this$0.mClockList;
                    if (list != null) {
                        ClockContainerFragment clockContainerFragment = this.this$0;
                        int i = 0;
                        for (Object obj : list) {
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Clock clock = (Clock) obj;
                            if (Intrinsics.areEqual(clock.getConfig().getId(), stringExtra)) {
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ClockContainerFragment$customWatchBroadcaster$1$onReceive$1$1(clock, clockContainerFragment, stringExtra, null), 3, null);
                            }
                            i = i2;
                        }
                    }
                }
            }
        };
    }

    public final ClockRegister getMClockRegister() {
        ClockRegister clockRegister = this.mClockRegister;
        if (clockRegister != null) {
            return clockRegister;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mClockRegister");
        return null;
    }

    public final void setMClockRegister(ClockRegister clockRegister) {
        Intrinsics.checkNotNullParameter(clockRegister, "<set-?>");
        this.mClockRegister = clockRegister;
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

    public final CompassSensorComponent getMCompassSensorComponent() {
        CompassSensorComponent compassSensorComponent = this.mCompassSensorComponent;
        if (compassSensorComponent != null) {
            return compassSensorComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCompassSensorComponent");
        return null;
    }

    public final void setMCompassSensorComponent(CompassSensorComponent compassSensorComponent) {
        Intrinsics.checkNotNullParameter(compassSensorComponent, "<set-?>");
        this.mCompassSensorComponent = compassSensorComponent;
    }

    public final SoundEffect getMRingtoneComponent() {
        SoundEffect soundEffect = this.mRingtoneComponent;
        if (soundEffect != null) {
            return soundEffect;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRingtoneComponent");
        return null;
    }

    public final void setMRingtoneComponent(SoundEffect soundEffect) {
        Intrinsics.checkNotNullParameter(soundEffect, "<set-?>");
        this.mRingtoneComponent = soundEffect;
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

    public final AssetsClockRepository getAssetsClockRepository() {
        AssetsClockRepository assetsClockRepository = this.assetsClockRepository;
        if (assetsClockRepository != null) {
            return assetsClockRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("assetsClockRepository");
        return null;
    }

    public final void setAssetsClockRepository(AssetsClockRepository assetsClockRepository) {
        Intrinsics.checkNotNullParameter(assetsClockRepository, "<set-?>");
        this.assetsClockRepository = assetsClockRepository;
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

    public final Map<Integer, CommonClock> getViewClockMap() {
        return this.viewClockMap;
    }

    public final void setViewClockMap(Map<Integer, CommonClock> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.viewClockMap = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSetTask$lambda$0(ClockContainerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mSet = false;
        this$0.mHasSetTask = false;
        Timber.INSTANCE.i("----set task run----", new Object[0]);
        if (this$0.getMRingtoneComponent().isPlaying()) {
            this$0.getMRingtoneComponent().stop();
        }
    }

    public int getLayoutId() {
        return R.layout.fragment_clock_container;
    }

    @Override // com.dw.launcher.ui.fragment.clock.Hilt_ClockContainerFragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        getMSensorComponent().setAutoPlaySound(false);
        ViewModelStoreOwner viewModelStoreOwnerRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(viewModelStoreOwnerRequireActivity, "requireActivity(...)");
        ClockViewModel clockViewModel = (ClockViewModel) new ViewModelProvider(viewModelStoreOwnerRequireActivity).get(ClockViewModel.class);
        this.mClockViewModel = clockViewModel;
        ClockViewModel clockViewModel2 = null;
        if (clockViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mClockViewModel");
            clockViewModel = null;
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        clockViewModel.getClockList().observe(lifecycleOwner, new ClockContainerFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends Clock>, Unit>() { // from class: com.dw.launcher.ui.fragment.clock.ClockContainerFragment.onAttach.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Clock> list) {
                invoke2((List<Clock>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Clock> list) {
                ClockContainerFragment.this.mClockList.clear();
                List list2 = ClockContainerFragment.this.mClockList;
                Intrinsics.checkNotNull(list);
                list2.addAll(list);
                Timber.INSTANCE.d("----onAttach  observerNum: " + ClockContainerFragment.this.mClockList.size() + " isAdded " + ClockContainerFragment.this.isAdded() + "  isResume " + ClockContainerFragment.this.isResumed(), new Object[0]);
                if (ClockContainerFragment.this.isAdded()) {
                    PagerAdapter pagerAdapter = ClockContainerFragment.this.mAdapter;
                    if (pagerAdapter != null) {
                        pagerAdapter.notifyDataSetChanged();
                    }
                    ClockContainerFragment.this.checkClockStyle();
                }
            }
        }));
        ClockViewModel clockViewModel3 = this.mClockViewModel;
        if (clockViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mClockViewModel");
        } else {
            clockViewModel2 = clockViewModel3;
        }
        clockViewModel2.getClockUpdate().observe(lifecycleOwner, new ClockContainerFragment$sam$androidx_lifecycle_Observer$0(new Function1<Clock, Unit>() { // from class: com.dw.launcher.ui.fragment.clock.ClockContainerFragment.onAttach.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Clock clock) {
                invoke2(clock);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Clock clock) {
                List list = ClockContainerFragment.this.mClockList;
                if (list != null) {
                    ClockContainerFragment clockContainerFragment = ClockContainerFragment.this;
                    int i = 0;
                    for (Object obj : list) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        Clock clock2 = (Clock) obj;
                        if (Intrinsics.areEqual(clock2.getConfig().getId(), clockContainerFragment.getMPreference().getPreferClock())) {
                            List list2 = clockContainerFragment.mClockList;
                            Intrinsics.checkNotNull(clock);
                            list2.set(i, clock);
                            CommonClock commonClock = clockContainerFragment.comcomClock;
                            if (commonClock != null) {
                                commonClock.setForceConfig(clock);
                            }
                            Timber.INSTANCE.d("强制更新表盘...Id: " + clock2.getConfig().getId() + ' ', new Object[0]);
                        }
                        i = i2;
                    }
                }
            }
        }));
        context.getContentResolver().registerContentObserver(LauncherConfig.INSTANCE.getURI_CLOCK_STYLE(), false, this.mClockStyleObserver);
        context.registerReceiver(this.customWatchBroadcaster, new IntentFilter("customwatch_config_changed"));
    }

    public void onDetach() {
        ContentResolver contentResolver;
        super.onDetach();
        if (getMRingtoneComponent().isPlaying()) {
            getMRingtoneComponent().stop();
        }
        Context context = getContext();
        if (context != null && (contentResolver = context.getContentResolver()) != null) {
            contentResolver.unregisterContentObserver(this.mClockStyleObserver);
        }
        Context context2 = getContext();
        if (context2 != null) {
            context2.unregisterReceiver(this.customWatchBroadcaster);
        }
    }

    public void onResume() {
        super.onResume();
        Log.i("lkang", "表盘onResume");
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            pagerAdapter.notifyDataSetChanged();
        }
        checkClockStyle();
        this.isVisbile = true;
        getMSensorComponent().register(this);
        getMCompassSensorComponent().register(this);
        CommonClock commonClock = this.comcomClock;
        if (commonClock != null) {
            commonClock.setCurrentForent(true);
            LaunchConfig launchConfigLoadConfig = getAssertLauncherRepository().loadConfig();
            boolean z = false;
            if (launchConfigLoadConfig != null && launchConfigLoadConfig.getSupport_compass() == 1) {
                z = true;
            }
            commonClock.supportCompassFunction(z);
            commonClock.updateTimeFormat();
            commonClock.visibleToFront(true);
        }
        this.lastTurnTimeStamp = 0L;
    }

    public void onPause() {
        super.onPause();
        Log.i("lkang", "表盘onPause");
        this.isVisbile = false;
        getMSensorComponent().unregister();
        getMCompassSensorComponent().unregister();
        for (CommonClock commonClock : this.viewClockMap.values()) {
            if (!Intrinsics.areEqual(commonClock, this.comcomClock)) {
                commonClock.setCurrentForent(false);
            }
            commonClock.visibleToFront(false);
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final ViewPagerImpl viewPagerImpl = (ViewPagerImpl) view.findViewById(R.id.clock_container_viewpager);
        this.mViewPager = viewPagerImpl;
        PagerAdapter pagerAdapter = new PagerAdapter() { // from class: com.dw.launcher.ui.fragment.clock.ClockContainerFragment.onViewCreated.1
            public int getCount() {
                return ClockContainerFragment.this.mClockList.size();
            }

            public boolean isViewFromObject(View view2, Object object) {
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(object, "object");
                return Intrinsics.areEqual(view2, object);
            }

            public Object instantiateItem(ViewGroup container, final int position) {
                Intrinsics.checkNotNullParameter(container, "container");
                View viewInflate = LayoutInflater.from(ClockContainerFragment.this.requireContext()).inflate(R.layout.clock_container_item, container, false);
                final CommonClock commonClock = (CommonClock) viewInflate.findViewById(R.id.clock_container_common_clock);
                commonClock.setConfig((Clock) ClockContainerFragment.this.mClockList.get(position));
                Integer numValueOf = Integer.valueOf(position);
                Map<Integer, CommonClock> viewClockMap = ClockContainerFragment.this.getViewClockMap();
                Intrinsics.checkNotNull(commonClock);
                viewClockMap.put(numValueOf, commonClock);
                ClockContainerFragment clockContainerFragment = ClockContainerFragment.this;
                clockContainerFragment.comcomClock = clockContainerFragment.getViewClockMap().get(Integer.valueOf(viewPagerImpl.getCurrentItem()));
                Timber.INSTANCE.d(" 当前view地址  position: " + position + " viewClockMap: " + ClockContainerFragment.this.getViewClockMap().size() + " current:" + viewPagerImpl.getCurrentItem() + " comcomClock: " + ClockContainerFragment.this.comcomClock + "  clock: " + commonClock, new Object[0]);
                LaunchConfig launchConfigLoadConfig = ClockContainerFragment.this.getAssertLauncherRepository().loadConfig();
                if (launchConfigLoadConfig != null) {
                    commonClock.supportHeartFunction(launchConfigLoadConfig.getSupport_heart() == 1);
                    commonClock.supportCompassFunction(launchConfigLoadConfig.getSupport_compass() == 1);
                }
                final ClockConfig config = ((Clock) ClockContainerFragment.this.mClockList.get(position)).getConfig();
                final ClockContainerFragment clockContainerFragment2 = ClockContainerFragment.this;
                commonClock.registerClockItemClickListener((OnWatchItemClickListener) new AbstractWatchItemClickListener() { // from class: com.dw.launcher.ui.fragment.clock.ClockContainerFragment$onViewCreated$1$instantiateItem$2$1
                    public void onAlarmClick() {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName("com.android.deskclock", "com.android.deskclock.DeskClock"));
                        intent.setFlags(268435456);
                        AppFilterConfig appFilterConfig = AppFilterConfig.INSTANCE;
                        Context contextRequireContext = clockContainerFragment2.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                        if (appFilterConfig.isIntentAvailable(contextRequireContext, intent)) {
                            clockContainerFragment2.startActivity(intent);
                            return;
                        }
                        intent.setComponent(new ComponentName("com.dw.deskclock", "com.dw.deskclock.activity.AlarmClockExActivity"));
                        AppFilterConfig appFilterConfig2 = AppFilterConfig.INSTANCE;
                        Context contextRequireContext2 = clockContainerFragment2.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        if (appFilterConfig2.isIntentAvailable(contextRequireContext2, intent)) {
                            clockContainerFragment2.startActivity(intent);
                        }
                    }

                    public void onHeartClick() {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName("com.divo.heartrate", "com.divo.heartrate.MainActivity"));
                        intent.setFlags(268435456);
                        AppFilterConfig appFilterConfig = AppFilterConfig.INSTANCE;
                        Context contextRequireContext = clockContainerFragment2.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                        if (appFilterConfig.isIntentAvailable(contextRequireContext, intent)) {
                            clockContainerFragment2.startActivity(intent);
                            return;
                        }
                        Intent intent2 = new Intent();
                        intent2.setComponent(new ComponentName("com.dw.heartrate", "com.dw.heartrate.MainActivity"));
                        intent2.setFlags(268435456);
                        AppFilterConfig appFilterConfig2 = AppFilterConfig.INSTANCE;
                        Context contextRequireContext2 = clockContainerFragment2.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        if (appFilterConfig2.isIntentAvailable(contextRequireContext2, intent2)) {
                            clockContainerFragment2.startActivity(intent2);
                        }
                    }

                    public void onMusicClick() {
                        PackageManager packageManager;
                        Context contextRequireContext = clockContainerFragment2.requireContext();
                        Intent launchIntentForPackage = (contextRequireContext == null || (packageManager = contextRequireContext.getPackageManager()) == null) ? null : packageManager.getLaunchIntentForPackage("com.dw.music");
                        if (launchIntentForPackage != null) {
                            launchIntentForPackage.setFlags(268435456);
                            clockContainerFragment2.startActivity(launchIntentForPackage);
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.MUSIC_PLAYER");
                        intent.setFlags(268435456);
                        AppFilterConfig appFilterConfig = AppFilterConfig.INSTANCE;
                        Context contextRequireContext2 = clockContainerFragment2.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        if (appFilterConfig.isIntentAvailable(contextRequireContext2, intent)) {
                            clockContainerFragment2.startActivity(intent);
                        }
                    }

                    public void onSettingClick() {
                        Boolean boolValueOf;
                        String statusBarSet_packageName;
                        String statusBarSet_className;
                        Intent intent = new Intent();
                        LaunchConfig launchConfigLoadConfig2 = clockContainerFragment2.getAssertLauncherRepository().loadConfig();
                        if (launchConfigLoadConfig2 != null) {
                            ClockContainerFragment clockContainerFragment3 = clockContainerFragment2;
                            boolean z = true;
                            if (launchConfigLoadConfig2.getUserHandleStatusBarSet() != 1 || (statusBarSet_packageName = launchConfigLoadConfig2.getStatusBarSet_packageName()) == null || statusBarSet_packageName.length() <= 0 || (statusBarSet_className = launchConfigLoadConfig2.getStatusBarSet_className()) == null || statusBarSet_className.length() <= 0) {
                                z = false;
                            } else {
                                intent.setClassName(launchConfigLoadConfig2.getStatusBarSet_packageName(), launchConfigLoadConfig2.getStatusBarSet_className());
                                intent.setFlags(268435456);
                                clockContainerFragment3.startActivity(intent);
                            }
                            boolValueOf = Boolean.valueOf(z);
                        } else {
                            boolValueOf = null;
                        }
                        if (Intrinsics.areEqual((Object) boolValueOf, (Object) false)) {
                            intent.setClassName("com.android.settings", "com.android.settings.Settings");
                            intent.setFlags(268435456);
                            clockContainerFragment2.startActivity(intent);
                        }
                    }

                    public void onStepClick() {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName("com.dwiot.iotstepcounter", "com.dwiot.iotstepcounter.activity.StepActivity"));
                        intent.setFlags(268435456);
                        AppFilterConfig appFilterConfig = AppFilterConfig.INSTANCE;
                        Context contextRequireContext = clockContainerFragment2.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                        if (appFilterConfig.isIntentAvailable(contextRequireContext, intent)) {
                            clockContainerFragment2.startActivity(intent);
                            return;
                        }
                        Intent intent2 = new Intent();
                        intent2.setComponent(new ComponentName("com.dwiot.dwstep", "com.dwiot.dwstep.activity.StepActivity"));
                        intent2.setFlags(268435456);
                        AppFilterConfig appFilterConfig2 = AppFilterConfig.INSTANCE;
                        Context contextRequireContext2 = clockContainerFragment2.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        if (appFilterConfig2.isIntentAvailable(contextRequireContext2, intent2)) {
                            clockContainerFragment2.startActivity(intent2);
                        }
                    }
                });
                commonClock.registerOnGestureListener(new CommonClock.OnGestureListener() { // from class: com.dw.launcher.ui.fragment.clock.ClockContainerFragment$onViewCreated$1$instantiateItem$2$2
                    @Override // com.dw.launcher.ui.clock.widget.CommonClock.OnGestureListener
                    public boolean onDown(MotionEvent event) {
                        Intrinsics.checkNotNullParameter(event, "event");
                        Timber.INSTANCE.d("----setOnClickListener onDown:  ", new Object[0]);
                        return false;
                    }

                    @Override // com.dw.launcher.ui.clock.widget.CommonClock.OnGestureListener
                    public boolean onSingleTapUp(MotionEvent event) {
                        List<Drawable> backgrounds;
                        List<Drawable> backgrounds2;
                        Clock mClock;
                        List<Drawable> backgrounds3;
                        Intrinsics.checkNotNullParameter(event, "event");
                        Timber.INSTANCE.d("----onSingleTapUp  :  ", new Object[0]);
                        if (config.supportBtnChange()) {
                            ClockConfigFlatter flatter = ((Clock) clockContainerFragment2.mClockList.get(position)).getFlatter();
                            Integer numValueOf2 = (flatter == null || (backgrounds3 = flatter.getBackgrounds()) == null) ? null : Integer.valueOf(backgrounds3.size());
                            if (numValueOf2 != null && numValueOf2.intValue() == 0) {
                                Clock clock = (Clock) clockContainerFragment2.mClockList.get(position);
                                CommonClock commonClock2 = clockContainerFragment2.comcomClock;
                                clock.setFlatter((commonClock2 == null || (mClock = commonClock2.getMClock()) == null) ? null : mClock.getFlatter());
                                ClockConfigFlatter flatter2 = ((Clock) clockContainerFragment2.mClockList.get(position)).getFlatter();
                                numValueOf2 = (flatter2 == null || (backgrounds2 = flatter2.getBackgrounds()) == null) ? null : Integer.valueOf(backgrounds2.size());
                                if (numValueOf2 != null && numValueOf2.intValue() == 0) {
                                    return true;
                                }
                            }
                            int bgBtnIndex = config.getBgBtnIndex() + 1;
                            Intrinsics.checkNotNull(numValueOf2);
                            int iIntValue = bgBtnIndex % numValueOf2.intValue();
                            config.setBg_btn_index(iIntValue);
                            ((Clock) clockContainerFragment2.mClockList.get(position)).refreshBackgroundIndex(iIntValue);
                            Timber.Companion companion = Timber.INSTANCE;
                            StringBuilder sbAppend = new StringBuilder("----onSingleTapUp bg_btn_index: ").append(iIntValue).append("  名称： ");
                            ClockConfig clockConfig = config;
                            companion.d(sbAppend.append(clockConfig != null ? clockConfig.getName() : null).append(' ').toString(), new Object[0]);
                            clockContainerFragment2.getAssetsClockRepository().saveOrUpdateClock((Clock) clockContainerFragment2.mClockList.get(position));
                            if (config.getBg_type() != 2) {
                                CommonClock commonClock3 = clockContainerFragment2.comcomClock;
                                if (commonClock3 != null) {
                                    CommonClock.clickChangeBg$default(commonClock3, false, null, 3, null);
                                }
                            } else {
                                CommonClock commonClock4 = commonClock;
                                if (commonClock4 != null) {
                                    ClockConfigFlatter flatter3 = ((Clock) clockContainerFragment2.mClockList.get(position)).getFlatter();
                                    commonClock4.setBackground((flatter3 == null || (backgrounds = flatter3.getBackgrounds()) == null) ? null : backgrounds.get(iIntValue));
                                }
                                CommonClock commonClock5 = clockContainerFragment2.comcomClock;
                                if (commonClock5 != null) {
                                    CommonClock commonClock6 = commonClock;
                                    commonClock5.clickChangeBg(true, commonClock6 != null ? commonClock6.getBackground() : null);
                                }
                            }
                            return true;
                        }
                        if (config.supportClickChange()) {
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ClockContainerFragment$onViewCreated$1$instantiateItem$2$2$onSingleTapUp$1(clockContainerFragment2, position, null), 3, null);
                        }
                        return false;
                    }

                    @Override // com.dw.launcher.ui.clock.widget.CommonClock.OnGestureListener
                    public void onLongPress(MotionEvent event) {
                        Intrinsics.checkNotNullParameter(event, "event");
                        Timber.INSTANCE.d("---GestureListener-onLongPress", new Object[0]);
                        ClockSingleton.INSTANCE.setMClockList(clockContainerFragment2.mClockList);
                        clockContainerFragment2.startActivity(new Intent(clockContainerFragment2.requireContext(), (Class<?>) PickClockActivity.class));
                    }

                    @Override // com.dw.launcher.ui.clock.widget.CommonClock.OnGestureListener
                    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                        LaunchConfig launchConfigLoadConfig2 = clockContainerFragment2.getAssertLauncherRepository().loadConfig();
                        if (launchConfigLoadConfig2 != null && launchConfigLoadConfig2.getAllowMoveUpTask() == 1) {
                            Timber.INSTANCE.d("----onScroll distanceX: " + distanceX + "  distanceY: " + distanceY + "  var1: " + (e1 != null ? Float.valueOf(e1.getY()) : null) + "  var2: " + (e2 != null ? Float.valueOf(e2.getY()) : null) + " e1key: " + (e1 != null ? Integer.valueOf(e1.getAction()) : null) + " e2key: " + (e2 != null ? Integer.valueOf(e2.getAction()) : null), new Object[0]);
                            Float fValueOf = e2 != null ? Float.valueOf(e2.getY()) : null;
                            Intrinsics.checkNotNull(fValueOf);
                            float fFloatValue = fValueOf.floatValue();
                            Float fValueOf2 = e1 != null ? Float.valueOf(e1.getY()) : null;
                            Intrinsics.checkNotNull(fValueOf2);
                            float fFloatValue2 = fFloatValue - fValueOf2.floatValue();
                            if (Math.abs(fFloatValue2) > 20 && fFloatValue2 < 0.0f && Math.abs(distanceX) < 10.0f) {
                                try {
                                    Intent intent = new Intent();
                                    intent.setComponent(new ComponentName("com.android.systemui", "com.android.systemui.recents.RecentsActivity"));
                                    intent.setFlags(268435456);
                                    clockContainerFragment2.requireContext().startActivity(intent);
                                    return true;
                                } catch (Exception unused) {
                                }
                            }
                        }
                        return false;
                    }
                });
                container.addView(viewInflate);
                Intrinsics.checkNotNull(viewInflate);
                return viewInflate;
            }

            public void destroyItem(ViewGroup container, int position, Object object) {
                Intrinsics.checkNotNullParameter(container, "container");
                Intrinsics.checkNotNullParameter(object, "object");
                if (object instanceof View) {
                    ClockContainerFragment.this.getViewClockMap().remove(Integer.valueOf(position));
                    container.removeView((View) object);
                    Timber.Companion companion = Timber.INSTANCE;
                    StringBuilder sbAppend = new StringBuilder("----销毁destroyItem position: ").append(position).append("  viewClockMap: ").append(ClockContainerFragment.this.getViewClockMap().size()).append(" container: ").append(container.getChildCount()).append(" adapter:");
                    PagerAdapter pagerAdapter2 = ClockContainerFragment.this.mAdapter;
                    companion.d(sbAppend.append(pagerAdapter2 != null ? Integer.valueOf(pagerAdapter2.getCount()) : null).append("  viewpager: ").append(viewPagerImpl.getChildCount()).toString(), new Object[0]);
                }
            }
        };
        this.mAdapter = pagerAdapter;
        viewPagerImpl.setAdapter(pagerAdapter);
        viewPagerImpl.disabled();
        viewPagerImpl.addOnPageChangeListener(new C00152());
        Timber.INSTANCE.d("onViewCreated", new Object[0]);
        checkClockStyle();
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.fragment.clock.ClockContainerFragment$onViewCreated$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ClockContainerFragment.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/dw/launcher/ui/fragment/clock/ClockContainerFragment$onViewCreated$2", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class C00152 implements ViewPager.OnPageChangeListener {
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        C00152() {
        }

        public void onPageSelected(int position) {
            ClockContainerFragment.this.mPosition = position;
            ClockContainerFragment clockContainerFragment = ClockContainerFragment.this;
            clockContainerFragment.comcomClock = clockContainerFragment.getViewClockMap().get(Integer.valueOf(position));
            Timber.INSTANCE.i("----onPageSelected: " + position + "  comcomClock: " + ClockContainerFragment.this.comcomClock, new Object[0]);
            CommonClock commonClock = ClockContainerFragment.this.comcomClock;
            if (commonClock != null) {
                commonClock.setCurrentForent(true);
            }
            CommonClock commonClock2 = ClockContainerFragment.this.comcomClock;
            if (commonClock2 != null) {
                LaunchConfig launchConfigLoadConfig = ClockContainerFragment.this.getAssertLauncherRepository().loadConfig();
                commonClock2.supportCompassFunction(launchConfigLoadConfig != null && launchConfigLoadConfig.getSupport_compass() == 1);
            }
            CommonClock commonClock3 = ClockContainerFragment.this.comcomClock;
            if (commonClock3 != null) {
                commonClock3.visibleToFront(true);
            }
            Collection<CommonClock> collectionValues = ClockContainerFragment.this.getViewClockMap().values();
            ClockContainerFragment clockContainerFragment2 = ClockContainerFragment.this;
            for (CommonClock commonClock4 : collectionValues) {
                if (!Intrinsics.areEqual(commonClock4, clockContainerFragment2.comcomClock)) {
                    commonClock4.setCurrentForent(false);
                    commonClock4.visibleToFront(false);
                }
            }
            ClockContainerFragment.this.onPageChanged(position);
        }

        public void onPageScrollStateChanged(int state) {
            Timber.INSTANCE.i("----onPageScrollStateChanged, state: " + state, new Object[0]);
            if (state == 0) {
                Handler handler = ClockContainerFragment.this.mHandler;
                final ClockContainerFragment clockContainerFragment = ClockContainerFragment.this;
                handler.postDelayed(new Runnable() { // from class: com.dw.launcher.ui.fragment.clock.ClockContainerFragment$onViewCreated$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ClockContainerFragment.C00152.onPageScrollStateChanged$lambda$1(clockContainerFragment);
                    }
                }, 500L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPageScrollStateChanged$lambda$1(ClockContainerFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.mHasSetTask = false;
            this$0.mSet = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkClockStyle() {
        Object next;
        if (Intrinsics.areEqual(this.mLastClockStyle, getMPreference().getPreferClock())) {
            return;
        }
        Iterator<T> it = this.mClockList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((Clock) next).getConfig().getId(), getMPreference().getPreferClock()));
        Clock clock = (Clock) next;
        if (clock != null) {
            ViewPagerImpl viewPagerImpl = this.mViewPager;
            if (viewPagerImpl != null) {
                viewPagerImpl.setCurrentItem(this.mClockList.indexOf(clock));
            }
            setCustomWatchPath(clock);
        }
    }

    @Override // com.dw.launcher.ui.fragment.clock.ClockViewPagerLayoutManager.OnPageChangedListener
    public void onPageChanged(int page) {
        Clock clock;
        ClockViewModel clockViewModel = this.mClockViewModel;
        if (clockViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mClockViewModel");
            clockViewModel = null;
        }
        List list = (List) clockViewModel.getClockList().getValue();
        if (list == null || (clock = (Clock) list.get(page)) == null) {
            return;
        }
        Timber.INSTANCE.i("----onClockSelected: " + clock.getConfig().getId() + " page : " + page, new Object[0]);
        getMPreference().setPreferClock(clock.getConfig().getId());
    }

    public boolean onSensorChanged(boolean up) {
        LauncherDrawer mLauncherDrawer;
        int size;
        Window window;
        Timber.INSTANCE.i("----value, mSet: " + this.mSet + "----", new Object[0]);
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof LauncherFragment) {
            LauncherFragment parentFragment2 = getParentFragment();
            Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.dw.launcher.ui.fragment.launcher.LauncherFragment");
            mLauncherDrawer = parentFragment2.getMLauncherDrawer();
        } else if (parentFragment instanceof LauncherCardFragment) {
            LauncherCardFragment parentFragment3 = getParentFragment();
            Intrinsics.checkNotNull(parentFragment3, "null cannot be cast to non-null type com.dw.launcher.ui.fragment.launcher.LauncherCardFragment");
            mLauncherDrawer = parentFragment3.getMLauncherDrawer();
        } else {
            mLauncherDrawer = null;
        }
        if (mLauncherDrawer != null && mLauncherDrawer.childVisible()) {
            this.lastTurnTimeStamp = SystemClock.uptimeMillis();
            return true;
        }
        cancelScreenFlagTask();
        if (getMPreference().isClockLocked()) {
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.addFlags(128);
        }
        if (SystemClock.uptimeMillis() - this.lastTurnTimeStamp >= 200) {
            this.lastTurnTimeStamp = SystemClock.uptimeMillis();
            ViewPagerImpl viewPagerImpl = this.mViewPager;
            if (viewPagerImpl != null && viewPagerImpl.getChildCount() > 0) {
                this.mSet = true;
                int currentItem = viewPagerImpl.getCurrentItem();
                if (up) {
                    size = currentItem + 1;
                    if (size >= this.mClockList.size()) {
                        size = 0;
                    }
                } else {
                    size = currentItem - 1;
                    if (size < 0) {
                        size = this.mClockList.size() - 1;
                    }
                }
                if (size >= 0 && size < this.mClockList.size()) {
                    Timber.INSTANCE.i("----smooth scroll to " + size, new Object[0]);
                    viewPagerImpl.setCurrentItem(size, false);
                }
            }
        }
        return false;
    }

    public void onSensorStopped() {
        SensorComponent.OnSensorChangedListener.DefaultImpls.onSensorStopped(this);
        closeScreenFlagTask();
        Timber.INSTANCE.i("----onSensorStopped", new Object[0]);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.isVisbile) {
            return false;
        }
        if (keyCode != getSysKeyEvent().getUPKey() && keyCode != getSysKeyEvent().getDownKey()) {
            return false;
        }
        closeScreenFlagTask();
        return true;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        LauncherDrawer mLauncherDrawer;
        int size;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.isVisbile) {
            return false;
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof LauncherFragment) {
            LauncherFragment parentFragment2 = getParentFragment();
            Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.dw.launcher.ui.fragment.launcher.LauncherFragment");
            mLauncherDrawer = parentFragment2.getMLauncherDrawer();
        } else if (parentFragment instanceof LauncherCardFragment) {
            LauncherCardFragment parentFragment3 = getParentFragment();
            Intrinsics.checkNotNull(parentFragment3, "null cannot be cast to non-null type com.dw.launcher.ui.fragment.launcher.LauncherCardFragment");
            mLauncherDrawer = parentFragment3.getMLauncherDrawer();
        } else {
            mLauncherDrawer = null;
        }
        if (mLauncherDrawer != null && mLauncherDrawer.childVisible()) {
            Timber.INSTANCE.i("----value, hasPeekingDrawer : " + this.mSet + "----", new Object[0]);
            this.lastTurnTimeStamp = SystemClock.uptimeMillis();
            return true;
        }
        if (getMPreference().isClockLocked()) {
            return true;
        }
        if ((keyCode == getSysKeyEvent().getUPKey() || keyCode == getSysKeyEvent().getDownKey()) && SystemClock.uptimeMillis() - this.lastTurnTimeStamp >= 120) {
            this.lastTurnTimeStamp = SystemClock.uptimeMillis();
            ViewPagerImpl viewPagerImpl = this.mViewPager;
            if (viewPagerImpl != null && viewPagerImpl.getChildCount() > 0) {
                this.mSet = true;
                int currentItem = viewPagerImpl.getCurrentItem();
                if (keyCode == getSysKeyEvent().getDownKey()) {
                    size = currentItem + 1;
                    if (size == this.mClockList.size()) {
                        size = 0;
                    }
                } else {
                    size = currentItem - 1;
                    if (size < 0) {
                        size = this.mClockList.size() - 1;
                    }
                }
                if (size >= 0 && size < this.mClockList.size()) {
                    Timber.INSTANCE.i("----smooth scroll to " + size, new Object[0]);
                    viewPagerImpl.setCurrentItem(size, false);
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean onCompassSensorChanged(float rotation) {
        Clock mClock;
        ClockConfig config;
        LaunchConfig launchConfigLoadConfig;
        CommonClock commonClock;
        CommonClock commonClock2 = this.comcomClock;
        if (commonClock2 != null && (mClock = commonClock2.getMClock()) != null && (config = mClock.getConfig()) != null && config.getSupport_compass() == 1 && (launchConfigLoadConfig = getAssertLauncherRepository().loadConfig()) != null && launchConfigLoadConfig.getSupport_compass() == 1 && (commonClock = this.comcomClock) != null) {
            commonClock.compassRotation(rotation);
        }
        return true;
    }
}
