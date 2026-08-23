package com.dw.launcher.ui.fragment.clock;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.dw.launcher.R;
import com.dw.launcher.core.component.CompassSensorComponent;
import com.dw.launcher.core.component.SensorComponent;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.config.LauncherConfig;
import com.dw.launcher.data.database.dao.ClockConfigDao;
import com.dw.launcher.data.entity.Clock;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.data.entity.DialPreviewInfo;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.entity.WatchFiltterConfig;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.data.repository.WatchConfigRepository;
import com.dw.launcher.ui.activity.BubbleActivity;
import com.dw.launcher.ui.activity.PickClockActivity;
import com.dw.launcher.ui.clock.widget.CommonClock;
import com.dw.launcher.ui.fragment.launcher.LauncherCardFragment;
import com.dw.launcher.ui.fragment.launcher.LauncherFragment;
import com.dw.launcher.ui.view.LauncherDrawer;
import com.dw.launcher.ui.view.LongPressLayout;
import com.dw.launcher.ui.view.PlayerView;
import com.dw.launcher.util.FileUtils;
import com.dw.launcher.util.WatchFactory;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduHeaders;
import com.plattysoft.leonids.ParticleSystem;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import timber.log.Timber;

/* JADX INFO: compiled from: DialFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000ï\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0003\u0015+T\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010a\u001a\u00020bH\u0002J\u001a\u0010c\u001a\u0004\u0018\u00010d2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020hH\u0002J\n\u0010i\u001a\u0004\u0018\u00010jH\u0002J\b\u0010k\u001a\u000208H\u0016J\u0010\u0010l\u001a\u00020b2\u0006\u0010m\u001a\u00020!H\u0002J\b\u0010n\u001a\u00020bH\u0002J\b\u0010o\u001a\u00020!H\u0002J\u0010\u0010p\u001a\u00020b2\u0006\u0010e\u001a\u00020fH\u0016J\u0010\u0010q\u001a\u00020!2\u0006\u0010m\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020bH\u0016J\u0010\u0010t\u001a\u00020b2\u0006\u0010u\u001a\u000208H\u0016J\u0018\u0010v\u001a\u00020!2\u0006\u0010w\u001a\u0002082\u0006\u0010x\u001a\u00020yH\u0016J\u0018\u0010z\u001a\u00020!2\u0006\u0010w\u001a\u0002082\u0006\u0010x\u001a\u00020yH\u0016J\b\u0010{\u001a\u00020bH\u0016J\b\u0010|\u001a\u00020bH\u0016J\u0010\u0010}\u001a\u00020!2\u0006\u0010m\u001a\u00020!H\u0016J\b\u0010~\u001a\u00020bH\u0016J\u001e\u0010\u007f\u001a\u00020b2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J\u0007\u0010\u0084\u0001\u001a\u00020bJ\u0012\u0010\u0085\u0001\u001a\u00020b2\u0007\u0010\u0086\u0001\u001a\u000208H\u0002J\u0007\u0010\u0087\u0001\u001a\u00020bJ\u0015\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020\u0019H\u0002J\u0007\u0010\u008b\u0001\u001a\u00020bR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010:\u001a\u00020;8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001e\u0010@\u001a\u00020A8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u000e\u0010F\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010G\u001a\u00020H8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010M\u001a\u0004\u0018\u00010NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0010\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0004\n\u0002\u0010UR\u001a\u0010V\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001e\u0010[\u001a\u00020\\8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`¨\u0006\u008c\u0001"}, d2 = {"Lcom/dw/launcher/ui/fragment/clock/DialFragment;", "Lcom/dw/launcher/base/BaseFragment;", "Lcom/dw/launcher/core/component/SensorComponent$OnSensorChangedListener;", "Lcom/dw/launcher/core/component/CompassSensorComponent$OnCompassSensorChangedListener;", "Lcom/dw/launcher/data/component/NoDisturbComponent$OnDialBubbleChangedListener;", "()V", "assertLauncherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getAssertLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setAssertLauncherRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "clockConfigDao", "Lcom/dw/launcher/data/database/dao/ClockConfigDao;", "getClockConfigDao", "()Lcom/dw/launcher/data/database/dao/ClockConfigDao;", "setClockConfigDao", "(Lcom/dw/launcher/data/database/dao/ClockConfigDao;)V", "currentJob", "Lkotlinx/coroutines/Job;", "customWatchBroadcaster", "com/dw/launcher/ui/fragment/clock/DialFragment$customWatchBroadcaster$1", "Lcom/dw/launcher/ui/fragment/clock/DialFragment$customWatchBroadcaster$1;", "dialList", "", "Lcom/dw/launcher/data/entity/DialPreviewInfo;", "getDialList", "()Ljava/util/List;", "setDialList", "(Ljava/util/List;)V", "dialView", "Lcom/dw/launcher/ui/view/LongPressLayout;", "isVisbile", "", "lastTurnTimeStamp", "", "launchRepository", "Lcom/dw/launcher/data/repository/WatchConfigRepository;", "getLaunchRepository", "()Lcom/dw/launcher/data/repository/WatchConfigRepository;", "setLaunchRepository", "(Lcom/dw/launcher/data/repository/WatchConfigRepository;)V", "mClockStyleObserver", "com/dw/launcher/ui/fragment/clock/DialFragment$mClockStyleObserver$1", "Lcom/dw/launcher/ui/fragment/clock/DialFragment$mClockStyleObserver$1;", "mCompassSensorComponent", "Lcom/dw/launcher/core/component/CompassSensorComponent;", "getMCompassSensorComponent", "()Lcom/dw/launcher/core/component/CompassSensorComponent;", "setMCompassSensorComponent", "(Lcom/dw/launcher/core/component/CompassSensorComponent;)V", "mHandler", "Landroid/os/Handler;", "mLastClockStyle", "", "mLastDialSource", "", "mPosition", "mPreference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "getMPreference", "()Lcom/dw/launcher/data/preference/LauncherPreference;", "setMPreference", "(Lcom/dw/launcher/data/preference/LauncherPreference;)V", "mSensorComponent", "Lcom/dw/launcher/core/component/SensorComponent;", "getMSensorComponent", "()Lcom/dw/launcher/core/component/SensorComponent;", "setMSensorComponent", "(Lcom/dw/launcher/core/component/SensorComponent;)V", "mSet", "noDisturbComponent", "Lcom/dw/launcher/data/component/NoDisturbComponent;", "getNoDisturbComponent", "()Lcom/dw/launcher/data/component/NoDisturbComponent;", "setNoDisturbComponent", "(Lcom/dw/launcher/data/component/NoDisturbComponent;)V", "ps", "Lcom/plattysoft/leonids/ParticleSystem;", "getPs", "()Lcom/plattysoft/leonids/ParticleSystem;", "setPs", "(Lcom/plattysoft/leonids/ParticleSystem;)V", "receiver", "com/dw/launcher/ui/fragment/clock/DialFragment$receiver$1", "Lcom/dw/launcher/ui/fragment/clock/DialFragment$receiver$1;", "show_dial_bubble", "getShow_dial_bubble", "()Z", "setShow_dial_bubble", "(Z)V", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "checkClockStyle", "", "getBgView", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "config", "Lcom/dw/launcher/data/entity/ClockConfig;", "getLauncherDrawer", "Lcom/dw/launcher/ui/view/LauncherDrawer;", "getLayoutId", "handlePositionChange", "up", "initData", "isLauncherDrawerVisible", "onAttach", "onCompassSensorChanged", "", "onDetach", "onDialBubbleChanged", "mode", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onPause", "onResume", "onSensorChanged", "onSensorStopped", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "register", "setDialView", "position", "setOnBubbleClickListener", "showPreviewImage", "Landroid/widget/ImageView;", "dial", "unregister", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class DialFragment extends Hilt_DialFragment implements SensorComponent.OnSensorChangedListener, CompassSensorComponent.OnCompassSensorChangedListener, NoDisturbComponent.OnDialBubbleChangedListener {

    @Inject
    public LauncherRepository assertLauncherRepository;

    @Inject
    public ClockConfigDao clockConfigDao;
    private Job currentJob;
    private final DialFragment$customWatchBroadcaster$1 customWatchBroadcaster;
    private List<DialPreviewInfo> dialList;
    private LongPressLayout dialView;
    private boolean isVisbile;
    private long lastTurnTimeStamp;

    @Inject
    public WatchConfigRepository launchRepository;
    private final DialFragment$mClockStyleObserver$1 mClockStyleObserver;

    @Inject
    public CompassSensorComponent mCompassSensorComponent;
    private final Handler mHandler;
    private String mLastClockStyle;
    private int mLastDialSource = WatchFactory.INSTANCE.getDIAL_SOURCE_LOCAL();
    private int mPosition;

    @Inject
    public LauncherPreference mPreference;

    @Inject
    public SensorComponent mSensorComponent;
    private boolean mSet;

    @Inject
    public NoDisturbComponent noDisturbComponent;
    private ParticleSystem ps;
    private final DialFragment$receiver$1 receiver;
    private boolean show_dial_bubble;

    @Inject
    public SysKeyEvent sysKeyEvent;

    /* JADX WARN: Type inference failed for: r1v1, types: [com.dw.launcher.ui.fragment.clock.DialFragment$receiver$1] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.dw.launcher.ui.fragment.clock.DialFragment$customWatchBroadcaster$1] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.dw.launcher.ui.fragment.clock.DialFragment$mClockStyleObserver$1] */
    public DialFragment() {
        final Handler handler = new Handler(Looper.getMainLooper());
        this.mHandler = handler;
        this.receiver = new BroadcastReceiver() { // from class: com.dw.launcher.ui.fragment.clock.DialFragment$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                Log.d("wlf", "onReceive: " + intent.getAction() + " id:" + intent.getLongExtra("extra_data", 0L));
                String action = intent.getAction();
                if (action != null) {
                    switch (action.hashCode()) {
                        case -1073793666:
                            if (action.equals("com.timuen.watchface.install")) {
                                long longExtra = intent.getLongExtra("extra_data", 0L);
                                List<DialPreviewInfo> dialList = this.this$0.getDialList();
                                if (dialList != null) {
                                    DialFragment dialFragment = this.this$0;
                                    int i = 0;
                                    for (Object obj : dialList) {
                                        int i2 = i + 1;
                                        if (i < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        DialPreviewInfo dialPreviewInfo = (DialPreviewInfo) obj;
                                        if (dialPreviewInfo.getDialId() == longExtra && dialPreviewInfo.getDialSource() == WatchFactory.INSTANCE.getDIAL_SOURCE_ONLINE()) {
                                            long dialId = dialPreviewInfo.getDialId();
                                            List<DialPreviewInfo> dialList2 = dialFragment.getDialList();
                                            Intrinsics.checkNotNull(dialList2);
                                            if (dialId != dialList2.get(dialFragment.mPosition).getDialId()) {
                                                dialFragment.setDialView(i);
                                            }
                                        }
                                        i = i2;
                                    }
                                }
                                break;
                            }
                            break;
                        case -799518756:
                            if (action.equals("com.timuen.action.watchface.install")) {
                                WatchFactory.INSTANCE.prePareOnlineWatchFace(context, intent.getStringExtra("extra_value"), (int) intent.getLongExtra("extra_data", 0L));
                                break;
                            }
                            break;
                        case -650689944:
                            if (action.equals("com.timuen.action.watchface.update")) {
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new DialFragment$receiver$1$onReceive$3(this.this$0, intent.getLongExtra("extra_data", 0L), null), 3, null);
                                break;
                            }
                            break;
                        case -210434310:
                            action.equals("com.timuen.action.change_watchface");
                            break;
                        case 213034428:
                            if (action.equals("com.internal.watchface.uninstall")) {
                                this.this$0.setDialList(WatchFactory.INSTANCE.getDialList());
                                break;
                            }
                            break;
                        case 1074691531:
                            if (action.equals("com.timuen.action.refresh_watchface")) {
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new DialFragment$receiver$1$onReceive$1(this.this$0, null), 3, null);
                                break;
                            }
                            break;
                    }
                }
            }
        };
        this.customWatchBroadcaster = new BroadcastReceiver() { // from class: com.dw.launcher.ui.fragment.clock.DialFragment$customWatchBroadcaster$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (Intrinsics.areEqual("customwatch_config_changed", intent != null ? intent.getAction() : null)) {
                    String stringExtra = intent != null ? intent.getStringExtra("id") : null;
                    List<DialPreviewInfo> dialList = this.this$0.getDialList();
                    if (dialList != null) {
                        DialFragment dialFragment = this.this$0;
                        int i = 0;
                        for (Object obj : dialList) {
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            DialPreviewInfo dialPreviewInfo = (DialPreviewInfo) obj;
                            if (Intrinsics.areEqual(String.valueOf(dialPreviewInfo.getDialId()), stringExtra) && dialPreviewInfo.getDialSource() == WatchFactory.INSTANCE.getDIAL_SOURCE_LOCAL()) {
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new DialFragment$customWatchBroadcaster$1$onReceive$1$1(dialPreviewInfo, dialFragment, stringExtra, null), 3, null);
                            }
                            i = i2;
                        }
                    }
                }
            }
        };
        this.mClockStyleObserver = new ContentObserver(handler) { // from class: com.dw.launcher.ui.fragment.clock.DialFragment$mClockStyleObserver$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                this.this$0.checkClockStyle();
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

    public final List<DialPreviewInfo> getDialList() {
        return this.dialList;
    }

    public final void setDialList(List<DialPreviewInfo> list) {
        this.dialList = list;
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

    public final WatchConfigRepository getLaunchRepository() {
        WatchConfigRepository watchConfigRepository = this.launchRepository;
        if (watchConfigRepository != null) {
            return watchConfigRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("launchRepository");
        return null;
    }

    public final void setLaunchRepository(WatchConfigRepository watchConfigRepository) {
        Intrinsics.checkNotNullParameter(watchConfigRepository, "<set-?>");
        this.launchRepository = watchConfigRepository;
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

    public final ParticleSystem getPs() {
        return this.ps;
    }

    public final void setPs(ParticleSystem particleSystem) {
        this.ps = particleSystem;
    }

    public final boolean getShow_dial_bubble() {
        return this.show_dial_bubble;
    }

    public final void setShow_dial_bubble(boolean z) {
        this.show_dial_bubble = z;
    }

    public int getLayoutId() {
        return R.layout.fragment_dial_clock;
    }

    @Override // com.dw.launcher.ui.fragment.clock.Hilt_DialFragment
    public void onAttach(Context context) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        register();
        WatchFiltterConfig watchFiltterConfigLoadConfig = getLaunchRepository().loadConfig();
        if (watchFiltterConfigLoadConfig == null || watchFiltterConfigLoadConfig.getResolutions() == null) {
            arrayList = null;
        } else {
            List watchfaces = getLaunchRepository().getWatchfaces();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(watchfaces, 10));
            Iterator it = watchfaces.iterator();
            while (it.hasNext()) {
                arrayList2.add(Integer.valueOf(((WatchFiltterConfig.WatchInfo) it.next()).getId()));
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            WatchFactory.INSTANCE.setFilterDiaList(arrayList);
            WatchFactory.INSTANCE.setClockConfigDaos(getClockConfigDao());
        }
        Timber.INSTANCE.d("onAttach...", new Object[0]);
    }

    public void onDetach() {
        super.onDetach();
        unregister();
    }

    public void onResume() {
        super.onResume();
        Log.i("lkang", "表盘onResume");
        this.isVisbile = true;
        getMSensorComponent().register(this);
        checkClockStyle();
        LongPressLayout longPressLayout = this.dialView;
        if (longPressLayout != null) {
            boolean z = false;
            View childAt = longPressLayout.getChildAt(0);
            if (childAt != null && (childAt instanceof CommonClock)) {
                CommonClock commonClock = (CommonClock) childAt;
                LaunchConfig launchConfigLoadConfig = getAssertLauncherRepository().loadConfig();
                commonClock.supportHeartFunction(launchConfigLoadConfig != null && launchConfigLoadConfig.getSupport_heart() == 1);
                LaunchConfig launchConfigLoadConfig2 = getAssertLauncherRepository().loadConfig();
                if (launchConfigLoadConfig2 != null && launchConfigLoadConfig2.getSupport_compass() == 1) {
                    z = true;
                }
                commonClock.supportCompassFunction(z);
                if (commonClock.needListenCompassPort()) {
                    getMCompassSensorComponent().register(this);
                }
                commonClock.setCurrentForent(true);
                commonClock.updateTimeFormat();
                commonClock.visibleToFront(true);
            }
        }
        Context context = getContext();
        Settings.System.putInt(context != null ? context.getContentResolver() : null, "dw_page_home", 1);
        Context context2 = getContext();
        Settings.System.putInt(context2 != null ? context2.getContentResolver() : null, "launch_page_home", 1);
    }

    public void onPause() {
        View childAt;
        super.onPause();
        Log.i("lkang", "表盘onPause");
        this.isVisbile = false;
        getMSensorComponent().unregister();
        LongPressLayout longPressLayout = this.dialView;
        if (longPressLayout != null && (childAt = longPressLayout.getChildAt(0)) != null && (childAt instanceof CommonClock)) {
            CommonClock commonClock = (CommonClock) childAt;
            if (commonClock.needListenCompassPort()) {
                getMCompassSensorComponent().unregister();
            }
            commonClock.visibleToFront(false);
        }
        Context context = getContext();
        Settings.System.putInt(context != null ? context.getContentResolver() : null, "launch_page_home", 0);
        Context context2 = getContext();
        Settings.System.putInt(context2 != null ? context2.getContentResolver() : null, "dw_page_home", 0);
        ParticleSystem particleSystem = this.ps;
        if (particleSystem != null) {
            particleSystem.cancel();
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        LongPressLayout longPressLayout = (LongPressLayout) activity.findViewById(R.id.dial_view);
        this.dialView = longPressLayout;
        if (longPressLayout != null) {
            longPressLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.fragment.clock.DialFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    return DialFragment.onViewCreated$lambda$4(this.f$0, view2);
                }
            });
        }
        this.mLastClockStyle = getMPreference().getPreferClock();
        this.mLastDialSource = getMPreference().getCurrentDialSource();
        initData();
        LaunchConfig launchConfigLoadConfig = getAssertLauncherRepository().loadConfig();
        if (launchConfigLoadConfig != null && launchConfigLoadConfig.getAllowMoveUpTask() == 1) {
            LongPressLayout longPressLayout2 = this.dialView;
            if (longPressLayout2 != null) {
                longPressLayout2.setNeedRegisterUpEvent(true);
            }
            LongPressLayout longPressLayout3 = this.dialView;
            if (longPressLayout3 != null) {
                longPressLayout3.setOnLongLayoutTouchClickListener(new LongPressLayout.OnLongLayoutTouchClickListener() { // from class: com.dw.launcher.ui.fragment.clock.DialFragment.onViewCreated.2
                    @Override // com.dw.launcher.ui.view.LongPressLayout.OnLongLayoutTouchClickListener
                    public void onTouch(MotionEvent event) {
                        Intrinsics.checkNotNullParameter(event, "event");
                    }

                    @Override // com.dw.launcher.ui.view.LongPressLayout.OnLongLayoutTouchClickListener
                    public void onUpTounch() {
                        try {
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName("com.android.systemui", "com.android.systemui.recents.RecentsActivity"));
                            intent.setFlags(268435456);
                            DialFragment.this.requireContext().startActivity(intent);
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        }
        LaunchConfig launchConfigLoadConfig2 = getAssertLauncherRepository().loadConfig();
        if (launchConfigLoadConfig2 != null && launchConfigLoadConfig2.getAllowSwipeRight() == 1) {
            LongPressLayout longPressLayout4 = this.dialView;
            if (longPressLayout4 != null) {
                longPressLayout4.setNeedRegisterRightEvent(true);
            }
            LongPressLayout longPressLayout5 = this.dialView;
            if (longPressLayout5 != null) {
                longPressLayout5.setOnSwipeRightListener(new LongPressLayout.OnSwipeRightListener() { // from class: com.dw.launcher.ui.fragment.clock.DialFragment.onViewCreated.3
                    @Override // com.dw.launcher.ui.view.LongPressLayout.OnSwipeRightListener
                    public void onSwipeRight(MotionEvent event) {
                        String swipe_right_app_package_className;
                        Intrinsics.checkNotNullParameter(event, "event");
                        LaunchConfig launchConfigLoadConfig3 = DialFragment.this.getAssertLauncherRepository().loadConfig();
                        if (launchConfigLoadConfig3 == null || (swipe_right_app_package_className = launchConfigLoadConfig3.getSwipe_right_app_package_className()) == null) {
                            return;
                        }
                        DialFragment dialFragment = DialFragment.this;
                        ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(swipe_right_app_package_className);
                        if (componentNameUnflattenFromString != null) {
                            Intrinsics.checkNotNull(componentNameUnflattenFromString);
                            try {
                                Intent intent = new Intent();
                                intent.setComponent(componentNameUnflattenFromString);
                                intent.setFlags(268435456);
                                dialFragment.requireContext().startActivity(intent);
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
            }
        }
        getNoDisturbComponent().addDialBubbleChangedListener(this);
        this.show_dial_bubble = Settings.Global.getInt(requireContext().getContentResolver(), BubbleActivity.BUBBLE_KEY, 0) == 1;
        setOnBubbleClickListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$4(DialFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.requireContext(), (Class<?>) PickClockActivity.class));
        return true;
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.fragment.clock.DialFragment$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: DialFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.ui.fragment.clock.DialFragment$initData$1", f = "DialFragment.kt", i = {}, l = {238}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DialFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DialFragment dialFragment;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DialFragment dialFragment2 = DialFragment.this;
                WatchFactory watchFactory = WatchFactory.INSTANCE;
                Context contextRequireContext = DialFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                this.L$0 = dialFragment2;
                this.label = 1;
                Object dialList = watchFactory.getDialList(contextRequireContext, this);
                if (dialList == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dialFragment = dialFragment2;
                obj = dialList;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                dialFragment = (DialFragment) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            dialFragment.setDialList((List) obj);
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            List<DialPreviewInfo> dialList2 = DialFragment.this.getDialList();
            if (dialList2 != null) {
                DialFragment dialFragment3 = DialFragment.this;
                int i2 = 0;
                for (Object obj2 : dialList2) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    DialPreviewInfo dialPreviewInfo = (DialPreviewInfo) obj2;
                    if (Intrinsics.areEqual(String.valueOf(dialPreviewInfo.getDialId()), dialFragment3.getMPreference().getPreferClock()) && dialPreviewInfo.getDialSource() == dialFragment3.getMPreference().getCurrentDialSource()) {
                        dialFragment3.setDialView(i2);
                        booleanRef.element = true;
                    }
                    i2 = i3;
                }
            }
            if (!booleanRef.element) {
                Log.d("DialFragment", "未找到指定表盘...");
            }
            DialFragment.this.getMPreference().setFirstLoadWatch(false);
            return Unit.INSTANCE;
        }
    }

    private final void initData() {
        Timber.INSTANCE.d("initData...", new Object[0]);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(null), 3, null);
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

    public boolean onSensorChanged(boolean up) {
        Window window;
        Timber.INSTANCE.i("----value, mSet: " + this.mSet + "----", new Object[0]);
        if (isLauncherDrawerVisible()) {
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
        if (SystemClock.uptimeMillis() - this.lastTurnTimeStamp >= 400) {
            this.lastTurnTimeStamp = SystemClock.uptimeMillis();
            handlePositionChange(up);
        }
        return false;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.isVisbile) {
            return false;
        }
        if (isLauncherDrawerVisible()) {
            Timber.INSTANCE.i("----value, hasPeekingDrawer : " + this.mSet + "----", new Object[0]);
            this.lastTurnTimeStamp = SystemClock.uptimeMillis();
            return true;
        }
        if (getMPreference().isClockLocked()) {
            return true;
        }
        if ((keyCode == getSysKeyEvent().getUPKey() || keyCode == getSysKeyEvent().getDownKey()) && SystemClock.uptimeMillis() - this.lastTurnTimeStamp >= 400) {
            this.lastTurnTimeStamp = SystemClock.uptimeMillis();
            handlePositionChange(keyCode == getSysKeyEvent().getUPKey());
        }
        return super.onKeyDown(keyCode, event);
    }

    private final boolean isLauncherDrawerVisible() {
        LauncherDrawer launcherDrawer = getLauncherDrawer();
        return launcherDrawer != null && launcherDrawer.childVisible();
    }

    private final void handlePositionChange(boolean up) {
        int i;
        List<DialPreviewInfo> list = this.dialList;
        if (list != null) {
            int size = list.size();
            if (up) {
                i = (this.mPosition + 1) % size;
            } else {
                i = ((this.mPosition - 1) + size) % size;
            }
            this.mPosition = i;
            setDialView(i);
        }
    }

    private final LauncherDrawer getLauncherDrawer() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof LauncherFragment) {
            LauncherFragment parentFragment2 = getParentFragment();
            Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.dw.launcher.ui.fragment.launcher.LauncherFragment");
            return parentFragment2.getMLauncherDrawer();
        }
        if (!(parentFragment instanceof LauncherCardFragment)) {
            return null;
        }
        LauncherCardFragment parentFragment3 = getParentFragment();
        Intrinsics.checkNotNull(parentFragment3, "null cannot be cast to non-null type com.dw.launcher.ui.fragment.launcher.LauncherCardFragment");
        return parentFragment3.getMLauncherDrawer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDialView(int position) {
        String filePath;
        ClockConfig config;
        ClockConfig config2;
        ClockConfig config3;
        List<DialPreviewInfo> list = this.dialList;
        if (list != null) {
            DialPreviewInfo dialPreviewInfo = list.get(position);
            Job job = this.currentJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            try {
                Timber.INSTANCE.d("setDialView: " + dialPreviewInfo.getDialId() + " name: " + dialPreviewInfo.getDialName() + " mLastDialSource: " + this.mLastDialSource + "  dialSource: " + dialPreviewInfo.getDialSource(), new Object[0]);
                if (dialPreviewInfo.getDialSource() != WatchFactory.INSTANCE.getDIAL_SOURCE_ONLINE() && ((filePath = dialPreviewInfo.getFilePath()) == null || !StringsKt.contains$default((CharSequence) filePath, (CharSequence) WatchFactory.INSTANCE.getFileJarSystemPath(), false, 2, (Object) null))) {
                    CommonClock commonClock = new CommonClock(requireContext());
                    Clock clock = dialPreviewInfo.getClock();
                    Intrinsics.checkNotNull(clock);
                    commonClock.setConfig(clock);
                    LongPressLayout longPressLayout = this.dialView;
                    if (longPressLayout != null) {
                        Settings.System.putLong(requireContext().getContentResolver(), WatchFactory.WATCHFACEINDEX, -1L);
                        Intrinsics.checkNotNull(longPressLayout);
                        longPressLayout.removeAllViews();
                        Clock config4 = commonClock.getMClock();
                        if (config4 != null && (config = config4.getConfig()) != null && config.getBg_type() == 5) {
                            FileUtils fileUtils = FileUtils.INSTANCE;
                            Context contextRequireContext = requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                            Clock config5 = commonClock.getMClock();
                            ClockConfig config6 = config5 != null ? config5.getConfig() : null;
                            Intrinsics.checkNotNull(config6);
                            Clock config7 = commonClock.getMClock();
                            InputStream inputStreamLoadInputStreamSource$default = FileUtils.loadInputStreamSource$default(fileUtils, contextRequireContext, config6, String.valueOf((config7 == null || (config3 = config7.getConfig()) == null) ? null : config3.getVideo()), false, 8, null);
                            if (inputStreamLoadInputStreamSource$default != null) {
                                final FrameLayout frameLayout = new FrameLayout(requireContext());
                                Context contextRequireContext2 = requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                                Clock config8 = commonClock.getMClock();
                                ClockConfig config9 = config8 != null ? config8.getConfig() : null;
                                Intrinsics.checkNotNull(config9);
                                final PlayerView playerView = new PlayerView(contextRequireContext2, inputStreamLoadInputStreamSource$default, null, 0, config9, 12, null);
                                playerView.setPreparedListener(new PlayerView.OnPreparedListener() { // from class: com.dw.launcher.ui.fragment.clock.DialFragment$setDialView$1$2$1$1
                                    @Override // com.dw.launcher.ui.view.PlayerView.OnPreparedListener
                                    public void onComplete() {
                                    }

                                    @Override // com.dw.launcher.ui.view.PlayerView.OnPreparedListener
                                    public void onFirstUpdate() {
                                        FrameLayout frameLayout2 = frameLayout;
                                        if (frameLayout2 != null) {
                                            frameLayout2.setVisibility(8);
                                        }
                                    }
                                });
                                LongPressLayout longPressLayout2 = this.dialView;
                                if (longPressLayout2 != null) {
                                    longPressLayout2.addView(playerView, -1, -1);
                                }
                                Context contextRequireContext3 = requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                                Clock config10 = commonClock.getMClock();
                                ClockConfig config11 = config10 != null ? config10.getConfig() : null;
                                Intrinsics.checkNotNull(config11);
                                frameLayout.setBackground(getBgView(contextRequireContext3, config11));
                                LongPressLayout longPressLayout3 = this.dialView;
                                if (longPressLayout3 != null) {
                                    longPressLayout3.addView(frameLayout, -1, -1);
                                }
                                Clock config12 = commonClock.getMClock();
                                if (config12 != null && (config2 = config12.getConfig()) != null && config2.getVideo_type() == 1) {
                                    commonClock.setOnVideoClickListener(new CommonClock.OnVideoClickListener() { // from class: com.dw.launcher.ui.fragment.clock.DialFragment$setDialView$1$2$1$2
                                        @Override // com.dw.launcher.ui.clock.widget.CommonClock.OnVideoClickListener
                                        public void onVideoClick() {
                                            playerView.toggleVideo();
                                        }
                                    });
                                }
                            }
                        }
                        longPressLayout.addView(commonClock, -1, -1);
                    }
                    this.mPosition = position;
                    getMPreference().setPreferClock(String.valueOf(dialPreviewInfo.getDialId()));
                    getMPreference().setCurrentDialSource(WatchFactory.INSTANCE.getDIAL_SOURCE_LOCAL());
                    this.mLastDialSource = WatchFactory.INSTANCE.getDIAL_SOURCE_LOCAL();
                    this.mLastClockStyle = getMPreference().getPreferClock();
                    Timber.INSTANCE.d("setDialView: 结束啦啦啦", new Object[0]);
                    return;
                }
                this.currentJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new DialFragment$setDialView$1$1(this, dialPreviewInfo, position, null), 3, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView showPreviewImage(DialPreviewInfo dial) {
        LongPressLayout longPressLayout = this.dialView;
        if (longPressLayout == null) {
            return null;
        }
        longPressLayout.removeAllViews();
        ImageView imageView = new ImageView(requireContext());
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Bitmap preview = dial.getPreview();
        if (preview != null) {
            imageView.setImageBitmap(preview);
            Unit unit = Unit.INSTANCE;
        }
        longPressLayout.addView(imageView);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkClockStyle() {
        List<DialPreviewInfo> list;
        if ((Intrinsics.areEqual(this.mLastClockStyle, getMPreference().getPreferClock()) && this.mLastDialSource == getMPreference().getCurrentDialSource()) || (list = this.dialList) == null) {
            return;
        }
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DialPreviewInfo dialPreviewInfo = (DialPreviewInfo) obj;
            if (Intrinsics.areEqual(String.valueOf(dialPreviewInfo.getDialId()), getMPreference().getPreferClock()) && dialPreviewInfo.getDialSource() == getMPreference().getCurrentDialSource()) {
                setDialView(i);
            }
            i = i2;
        }
    }

    public final void register() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.timuen.watchface.install");
        intentFilter.addAction("com.timuen.action.change_watchface");
        intentFilter.addAction("com.timuen.action.refresh_watchface");
        intentFilter.addAction("com.timuen.action.watchface.install");
        intentFilter.addAction("com.internal.watchface.uninstall");
        intentFilter.addAction("com.timuen.action.watchface.update");
        requireContext().registerReceiver(this.receiver, intentFilter);
        requireContext().getContentResolver().registerContentObserver(LauncherConfig.INSTANCE.getURI_CLOCK_STYLE(), false, this.mClockStyleObserver);
        requireContext().registerReceiver(this.customWatchBroadcaster, new IntentFilter("customwatch_config_changed"));
    }

    public final void unregister() {
        requireContext().unregisterReceiver(this.receiver);
        requireContext().unregisterReceiver(this.customWatchBroadcaster);
        requireContext().getContentResolver().unregisterContentObserver(this.mClockStyleObserver);
        getNoDisturbComponent().removeDialBubbleChangedListener(this);
    }

    public boolean onCompassSensorChanged(float up) {
        LongPressLayout longPressLayout;
        View childAt;
        LaunchConfig launchConfigLoadConfig = getAssertLauncherRepository().loadConfig();
        if (launchConfigLoadConfig != null && launchConfigLoadConfig.getSupport_compass() == 1 && (longPressLayout = this.dialView) != null && (childAt = longPressLayout.getChildAt(0)) != null && (childAt instanceof CommonClock)) {
            ((CommonClock) childAt).compassRotation(up);
        }
        return true;
    }

    private final Drawable getBgView(Context context, ClockConfig config) {
        Drawable drawableLoadDrawable$default;
        String[] list = new File(config.getPath() + "/res/bg").list();
        if (list == null || (drawableLoadDrawable$default = FileUtils.loadDrawable$default(FileUtils.INSTANCE, context, config, "res/bg/" + list[0], false, 8, null)) == null) {
            return null;
        }
        return drawableLoadDrawable$default;
    }

    public final void setOnBubbleClickListener() {
        if (this.show_dial_bubble) {
            try {
                LongPressLayout longPressLayout = this.dialView;
                if (longPressLayout != null) {
                    longPressLayout.setOnMoveClickListener(new LongPressLayout.OnTouchClickListener() { // from class: com.dw.launcher.ui.fragment.clock.DialFragment.setOnBubbleClickListener.1
                        @Override // com.dw.launcher.ui.view.LongPressLayout.OnTouchClickListener
                        public void onClickDown(MotionEvent event) {
                            Intrinsics.checkNotNullParameter(event, "event");
                            if (DialFragment.this.getShow_dial_bubble()) {
                                ParticleSystem ps = DialFragment.this.getPs();
                                if (ps != null) {
                                    ps.stopEmitting();
                                }
                                DialFragment.this.setPs(new ParticleSystem(DialFragment.this.requireActivity(), 500, R.drawable.star_pink, 800L));
                                ParticleSystem ps2 = DialFragment.this.getPs();
                                if (ps2 != null) {
                                    ps2.updateParticlesRes();
                                    ps2.setScaleRange(0.03f, 0.4f);
                                    ps2.setSpeedModuleAndAngleRange(0.12f, 0.55f, PduHeaders.RESPONSE_STATUS_ERROR_PERMANENT_LACK_OF_PREPAID, 270);
                                    ps2.setFadeOut(200L, new DecelerateInterpolator());
                                    ps2.emit((int) event.getX(), (int) event.getY(), 100);
                                }
                            }
                        }

                        @Override // com.dw.launcher.ui.view.LongPressLayout.OnTouchClickListener
                        public void onClickUp() {
                            ParticleSystem ps = DialFragment.this.getPs();
                            if (ps != null) {
                                ps.stopEmitting();
                            }
                        }

                        @Override // com.dw.launcher.ui.view.LongPressLayout.OnTouchClickListener
                        public void onMove(MotionEvent event) {
                            Intrinsics.checkNotNullParameter(event, "event");
                            ParticleSystem ps = DialFragment.this.getPs();
                            if (ps != null) {
                                ps.updateEmitPoint((int) event.getX(), (int) event.getY());
                            }
                        }
                    });
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        LongPressLayout longPressLayout2 = this.dialView;
        if (longPressLayout2 != null) {
            longPressLayout2.removeMoveClickListener();
        }
        ParticleSystem particleSystem = this.ps;
        if (particleSystem != null) {
            particleSystem.cancel();
        }
    }

    public void onDialBubbleChanged(int mode) {
        this.show_dial_bubble = mode == 1;
        setOnBubbleClickListener();
    }
}
