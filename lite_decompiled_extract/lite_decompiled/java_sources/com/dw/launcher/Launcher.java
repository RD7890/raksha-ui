package com.dw.launcher;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.android.launcher3.util.StepManager;
import com.dw.launcher.activity.ChargeActivity;
import com.dw.launcher.core.receiver.NetworkChangeReceiver;
import com.dw.launcher.data.component.PhoneStatusComponent;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.manager.ShortcutCustomManager;
import com.dw.launcher.ui.activity.LowBatteryActivity;
import com.dw.launcher.ui.fragment.launcher.LauncherCardFragment;
import com.dw.launcher.ui.fragment.launcher.LauncherFragment;
import com.dw.launcher.util.DwUtils;
import com.dw.launcher.util.SystemUtils;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import pl.droidsonroids.gif.GifImageView;
import timber.log.Timber;

/* JADX INFO: compiled from: Launcher.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 W2\u00020\u0001:\u0001WB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010>\u001a\u00020?2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010@\u001a\u00020?J\u0006\u0010A\u001a\u00020?J\b\u0010B\u001a\u00020CH\u0016J\n\u0010D\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010E\u001a\u00020?J\b\u0010F\u001a\u00020\u0010H\u0002J\b\u0010G\u001a\u00020\u0010H\u0002J\b\u0010H\u001a\u00020\u0010H\u0002J\b\u0010I\u001a\u00020?H\u0016J\u0012\u0010J\u001a\u00020?2\b\u0010K\u001a\u0004\u0018\u00010LH\u0014J\b\u0010M\u001a\u00020?H\u0014J\u0012\u0010N\u001a\u00020?2\b\u0010O\u001a\u0004\u0018\u00010PH\u0014J\b\u0010Q\u001a\u00020?H\u0014J\u0010\u0010R\u001a\u00020?2\u0006\u0010O\u001a\u00020PH\u0002J\u000e\u0010S\u001a\u00020?2\u0006\u0010T\u001a\u00020\u0004J\u0010\u0010U\u001a\u00020?2\u0006\u0010V\u001a\u00020\u0010H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001a\u0010\u001f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001a\u0010\"\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001a\u0010%\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u0002078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/dw/launcher/Launcher;", "Lcom/dw/launcher/base/BaseActivity;", "()V", "EXIT_NODISTURB", cn.carbswang.android.numberpickerview.library.BuildConfig.FLAVOR, "getEXIT_NODISTURB", "()Ljava/lang/String;", "MSG_CHARGING", "getMSG_CHARGING", "MSG_LOW_POWER", "getMSG_LOW_POWER", "MSG_SILENT", "getMSG_SILENT", "SETTING_KEY_CHARGE_MODE", "getSETTING_KEY_CHARGE_MODE", "isCharging", cn.carbswang.android.numberpickerview.library.BuildConfig.FLAVOR, "()Z", "setCharging", "(Z)V", "isEnterLowBattery", "setEnterLowBattery", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setLauncherRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "mIsChargingMode", "getMIsChargingMode", "setMIsChargingMode", "mIsLowPowerMode", "getMIsLowPowerMode", "setMIsLowPowerMode", "mIsSilentMode", "getMIsSilentMode", "setMIsSilentMode", "mLastChargeState", "getMLastChargeState", "setMLastChargeState", "mMainReceiver", "Landroid/content/BroadcastReceiver;", "networkChangeReceiver", "Lcom/dw/launcher/core/receiver/NetworkChangeReceiver;", "getNetworkChangeReceiver", "()Lcom/dw/launcher/core/receiver/NetworkChangeReceiver;", "setNetworkChangeReceiver", "(Lcom/dw/launcher/core/receiver/NetworkChangeReceiver;)V", "phoneStatusComponent", "Lcom/dw/launcher/data/component/PhoneStatusComponent;", "getPhoneStatusComponent", "()Lcom/dw/launcher/data/component/PhoneStatusComponent;", "setPhoneStatusComponent", "(Lcom/dw/launcher/data/component/PhoneStatusComponent;)V", "preferences", "Lcom/dw/launcher/data/preference/LauncherPreference;", "getPreferences", "()Lcom/dw/launcher/data/preference/LauncherPreference;", "setPreferences", "(Lcom/dw/launcher/data/preference/LauncherPreference;)V", "shortcutManager", "Lcom/dw/launcher/manager/ShortcutCustomManager;", "enterChargeMode", cn.carbswang.android.numberpickerview.library.BuildConfig.FLAVOR, "entertLowPowerMode", "exitChargeMode", "getLayoutId", cn.carbswang.android.numberpickerview.library.BuildConfig.FLAVOR, "getTopPackage", "initReceiver", "isAgeTest", "isFactoryTest", "isVChating", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "processIntent", "showShortCutDialog", "pkg", "updateStatusBar", "isHide", "Companion", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class Launcher extends Hilt_Launcher {
    public static final String ACTION_SHOW_DASHBOARD = "com.dw.launcher.ACTION_SHOW_DASHBOARD";
    public static final String ACTION_SHOW_SHORTCUT_DIALOG = "action.show_shortcut.dialog";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean mLoading;
    private boolean isCharging;
    private boolean isEnterLowBattery;

    @Inject
    public LauncherRepository launcherRepository;
    private boolean mIsChargingMode;
    private boolean mIsLowPowerMode;
    private boolean mIsSilentMode;
    private boolean mLastChargeState;
    private NetworkChangeReceiver networkChangeReceiver;

    @Inject
    public PhoneStatusComponent phoneStatusComponent;

    @Inject
    public LauncherPreference preferences;
    private ShortcutCustomManager shortcutManager;
    private final String MSG_CHARGING = "ACTION_SEND_CHARGING";
    private final String MSG_LOW_POWER = "ACTION_SEND_LOWBAT";
    private final String MSG_SILENT = "com.dwiot.openmarketlauncher.SILENT";
    private final String EXIT_NODISTURB = "com.dwiot.exit.nodisturb";
    private final String SETTING_KEY_CHARGE_MODE = ChargeActivity.SETTING_KEY_CHARGE_MODE;
    private final BroadcastReceiver mMainReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.Launcher$mMainReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Integer charge_animal_show;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Log.d("lkang", "mMainReceiver onReceive: " + intent.getAction());
            String action = intent.getAction();
            if (Intrinsics.areEqual(action, this.this$0.getMSG_CHARGING())) {
                this.this$0.setMIsChargingMode(intent.getBooleanExtra("state", false));
                return;
            }
            if (Intrinsics.areEqual(action, this.this$0.getMSG_LOW_POWER())) {
                this.this$0.setMIsLowPowerMode(intent.getBooleanExtra("state", false));
                return;
            }
            if (Intrinsics.areEqual(action, this.this$0.getMSG_SILENT())) {
                this.this$0.setMIsSilentMode(intent.getBooleanExtra("state", false));
                return;
            }
            if (Intrinsics.areEqual(action, this.this$0.getEXIT_NODISTURB())) {
                BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new Launcher$mMainReceiver$1$onReceive$1(this.this$0, null), 3, (Object) null);
                return;
            }
            if (Intrinsics.areEqual(action, "android.intent.action.BATTERY_CHANGED")) {
                LaunchConfig launchConfigLoadConfig = this.this$0.getLauncherRepository().loadConfig();
                if (((launchConfigLoadConfig == null || (charge_animal_show = launchConfigLoadConfig.getCharge_animal_show()) == null) ? 1 : charge_animal_show.intValue()) == 0) {
                    return;
                }
                int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                boolean z = intExtra == 2 || intExtra == 5;
                this.this$0.setCharging(z);
                if (z) {
                    this.this$0.setEnterLowBattery(false);
                }
                Log.d("lkang", "mMainReceiver onReceive: isCharging=" + z + " mIsChargingMode=" + this.this$0.getMIsChargingMode() + " phoneState=" + this.this$0.getPhoneStatusComponent().getPhoneState() + " mLastChargeState:" + this.this$0.getMLastChargeState());
                if (z != this.this$0.getMLastChargeState() && z && this.this$0.getPhoneStatusComponent().getPhoneState() == 0) {
                    this.this$0.enterChargeMode(z);
                }
                this.this$0.setMLastChargeState(z);
                if (this.this$0.getPhoneStatusComponent().getPhoneState() != 0 && z) {
                    this.this$0.setMLastChargeState(false);
                }
                if (Settings.Global.getInt(this.this$0.getContentResolver(), "show_low_battery_page", 0) != 1 || z) {
                    return;
                }
                if ((intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100) < 10) {
                    this.this$0.entertLowPowerMode();
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(action, Launcher.ACTION_SHOW_SHORTCUT_DIALOG)) {
                Launcher launcher = this.this$0;
                String stringExtra = intent.getStringExtra("pkg");
                if (stringExtra == null) {
                    stringExtra = cn.carbswang.android.numberpickerview.library.BuildConfig.FLAVOR;
                }
                launcher.showShortCutDialog(stringExtra);
                return;
            }
            if (Intrinsics.areEqual(action, "android.intent.action.SCREEN_OFF")) {
                this.this$0.setEnterLowBattery(false);
                return;
            }
            if (Intrinsics.areEqual(action, "android.intent.action.SCREEN_ON") && Settings.Global.getInt(this.this$0.getContentResolver(), "show_low_battery_page", 0) == 1 && !this.this$0.getMLastChargeState()) {
                if ((intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100) < 10) {
                    this.this$0.entertLowPowerMode();
                }
            }
        }
    };

    @Override // com.dw.launcher.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    public final boolean getMIsSilentMode() {
        return this.mIsSilentMode;
    }

    public final void setMIsSilentMode(boolean z) {
        this.mIsSilentMode = z;
    }

    public final boolean getMIsLowPowerMode() {
        return this.mIsLowPowerMode;
    }

    public final void setMIsLowPowerMode(boolean z) {
        this.mIsLowPowerMode = z;
    }

    public final boolean getMIsChargingMode() {
        return this.mIsChargingMode;
    }

    public final void setMIsChargingMode(boolean z) {
        this.mIsChargingMode = z;
    }

    public final String getMSG_CHARGING() {
        return this.MSG_CHARGING;
    }

    public final String getMSG_LOW_POWER() {
        return this.MSG_LOW_POWER;
    }

    public final String getMSG_SILENT() {
        return this.MSG_SILENT;
    }

    public final String getEXIT_NODISTURB() {
        return this.EXIT_NODISTURB;
    }

    public final boolean getMLastChargeState() {
        return this.mLastChargeState;
    }

    public final void setMLastChargeState(boolean z) {
        this.mLastChargeState = z;
    }

    public final String getSETTING_KEY_CHARGE_MODE() {
        return this.SETTING_KEY_CHARGE_MODE;
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

    public final LauncherPreference getPreferences() {
        LauncherPreference launcherPreference = this.preferences;
        if (launcherPreference != null) {
            return launcherPreference;
        }
        Intrinsics.throwUninitializedPropertyAccessException("preferences");
        return null;
    }

    public final void setPreferences(LauncherPreference launcherPreference) {
        Intrinsics.checkNotNullParameter(launcherPreference, "<set-?>");
        this.preferences = launcherPreference;
    }

    public final NetworkChangeReceiver getNetworkChangeReceiver() {
        return this.networkChangeReceiver;
    }

    public final void setNetworkChangeReceiver(NetworkChangeReceiver networkChangeReceiver) {
        this.networkChangeReceiver = networkChangeReceiver;
    }

    /* JADX INFO: renamed from: isEnterLowBattery, reason: from getter */
    public final boolean getIsEnterLowBattery() {
        return this.isEnterLowBattery;
    }

    public final void setEnterLowBattery(boolean z) {
        this.isEnterLowBattery = z;
    }

    /* JADX INFO: renamed from: isCharging, reason: from getter */
    public final boolean getIsCharging() {
        return this.isCharging;
    }

    public final void setCharging(boolean z) {
        this.isCharging = z;
    }

    /* JADX INFO: compiled from: Launcher.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/dw/launcher/Launcher$Companion;", cn.carbswang.android.numberpickerview.library.BuildConfig.FLAVOR, "()V", "ACTION_SHOW_DASHBOARD", cn.carbswang.android.numberpickerview.library.BuildConfig.FLAVOR, "ACTION_SHOW_SHORTCUT_DIALOG", "mLoading", cn.carbswang.android.numberpickerview.library.BuildConfig.FLAVOR, "getMLoading", "()Z", "setMLoading", "(Z)V", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getMLoading() {
            return Launcher.mLoading;
        }

        public final void setMLoading(boolean z) {
            Launcher.mLoading = z;
        }
    }

    @Override // com.dw.launcher.base.BaseActivity
    public int getLayoutId() {
        LaunchConfig launchConfigLoadConfig = getLauncherRepository().loadConfig();
        if (launchConfigLoadConfig != null && launchConfigLoadConfig.getLauncherthemeType() == 1) {
            return R.layout.activity_launcher_card;
        }
        return R.layout.activity_launcher;
    }

    @Override // com.dw.launcher.Hilt_Launcher, com.dw.launcher.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Launcher", "首页加载..." + savedInstanceState);
        final GifImageView gifImageViewFindViewById = findViewById(R.id.ivLoading);
        if (StringsKt.contains$default(SystemUtils.INSTANCE.getLanguage(this), "zh", false, 2, (Object) null)) {
            gifImageViewFindViewById.setBackgroundResource(R.drawable.icon_loading_zh);
        } else {
            gifImageViewFindViewById.setBackgroundResource(R.drawable.icon_loading_en);
        }
        mLoading = true;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.dw.launcher.Launcher$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Launcher.onCreate$lambda$1(gifImageViewFindViewById);
            }
        }, getPreferences().firstLoadWatch() ? 13000L : 8000L);
        Intent intent = getIntent();
        if (intent != null) {
            processIntent(intent);
        }
        initReceiver();
        StepManager stepManager = StepManager.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        stepManager.initStepService(applicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(GifImageView gifImageView) {
        gifImageView.setVisibility(8);
        mLoading = false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            processIntent(intent);
        }
    }

    private final void processIntent(Intent intent) {
        LauncherCardFragment launcherCardFragmentFindFragmentById;
        Timber.Forest.d("processIntent " + intent.getAction(), new Object[0]);
        if (!Intrinsics.areEqual(ACTION_SHOW_DASHBOARD, intent.getAction()) || (launcherCardFragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.launcher_fragment_launcher)) == null) {
            return;
        }
        if (launcherCardFragmentFindFragmentById instanceof LauncherCardFragment) {
            launcherCardFragmentFindFragmentById.showDashboard();
        } else if (launcherCardFragmentFindFragmentById instanceof LauncherFragment) {
            ((LauncherFragment) launcherCardFragmentFindFragmentById).showDashboard();
        }
    }

    @Override // com.dw.launcher.Hilt_Launcher, com.dw.launcher.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = this.mMainReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        StepManager stepManager = StepManager.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        stepManager.stopStepService(applicationContext);
        NetworkChangeReceiver networkChangeReceiver = this.networkChangeReceiver;
        if (networkChangeReceiver != null) {
            unregisterReceiver(networkChangeReceiver);
        }
    }

    public final void exitChargeMode() {
        Log.i("lkang", "exitChargeMode");
        updateStatusBar(false);
    }

    private final void updateStatusBar(boolean isHide) {
        DwUtils.updateStatusBar(this, isHide ? 65536 : 0);
    }

    public final void enterChargeMode(boolean isCharging) {
        if (isFinishing() || isFactoryTest() || isAgeTest() || isVChating()) {
            return;
        }
        Timber.Forest.d("进入enterChargeMode", new Object[0]);
        Intent intent = new Intent(this, (Class<?>) ChargeActivity.class);
        intent.addFlags(67108864);
        startActivity(intent);
        Timber.Forest.d("进入enterChargeMode end", new Object[0]);
    }

    private final boolean isFactoryTest() {
        return Intrinsics.areEqual(getTopPackage(), "com.sprd.validationtools");
    }

    private final boolean isAgeTest() {
        return Intrinsics.areEqual(getTopPackage(), "com.sprd.aganisttest");
    }

    private final boolean isVChating() {
        return Intrinsics.areEqual(getTopPackage(), "com.juphoon.cloud.vchat");
    }

    private final String getTopPackage() {
        Object systemService = getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) systemService).getRunningTasks(1);
        if (!runningTasks.isEmpty() && runningTasks.get(0) != null) {
            ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
            Intrinsics.checkNotNull(runningTaskInfo);
            if (runningTaskInfo.topActivity != null) {
                ActivityManager.RunningTaskInfo runningTaskInfo2 = runningTasks.get(0);
                Intrinsics.checkNotNull(runningTaskInfo2);
                ComponentName componentName = runningTaskInfo2.topActivity;
                Intrinsics.checkNotNull(componentName);
                return componentName.getPackageName();
            }
        }
        return null;
    }

    public final void initReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(this.MSG_SILENT);
        intentFilter.addAction(this.EXIT_NODISTURB);
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction(ACTION_SHOW_SHORTCUT_DIALOG);
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        registerReceiver(this.mMainReceiver, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();
        this.networkChangeReceiver = networkChangeReceiver;
        registerReceiver(networkChangeReceiver, intentFilter2);
    }

    public final void showShortCutDialog(String pkg) {
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        ShortcutCustomManager shortcutCustomManager = this.shortcutManager;
        if (shortcutCustomManager != null) {
            if (shortcutCustomManager.isShowShortCutDialog()) {
                return;
            }
            shortcutCustomManager.showShortCut(pkg);
        } else {
            ShortcutCustomManager shortcutCustomManager2 = new ShortcutCustomManager(this);
            this.shortcutManager = shortcutCustomManager2;
            shortcutCustomManager2.showShortCut(pkg);
        }
    }

    public final void entertLowPowerMode() {
        if (this.isEnterLowBattery) {
            return;
        }
        Intent intent = new Intent(getApplicationContext(), (Class<?>) LowBatteryActivity.class);
        intent.addFlags(335544320);
        startActivity(intent);
        this.isEnterLowBattery = true;
    }

    @Override // com.dw.launcher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.isCharging && Settings.Global.getInt(getContentResolver(), ChargeActivity.SETTING_KEY_CHARGE_MODE, 0) == 1) {
            enterChargeMode(true);
        }
    }
}
