package com.dw.launcher.data.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.android.ims.internal.IImsRegisterListener;
import com.android.ims.internal.IImsServiceEx;
import com.android.ims.internal.ImsManagerEx;
import com.dw.launcher.R;
import com.dw.launcher.util.DialProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

/* JADX INFO: compiled from: PhoneStatusComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000f*\u0003\u0019\u001f(\u0018\u00002\u00020\u0001:\u0002>?B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020#J\u000e\u00103\u001a\u0002012\u0006\u00102\u001a\u00020&J\b\u00104\u001a\u0004\u0018\u00010\u0006J\u0006\u00105\u001a\u00020\u0006J\u0006\u00106\u001a\u00020\bJ\u0006\u00107\u001a\u00020\bJ\u0006\u00108\u001a\u000201J\u0006\u00109\u001a\u000201J\u000e\u0010:\u001a\u0002012\u0006\u00102\u001a\u00020#J\u000e\u0010;\u001a\u0002012\u0006\u00102\u001a\u00020&J\u0006\u0010<\u001a\u000201J\u0006\u0010=\u001a\u000201R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020&0\"j\b\u0012\u0004\u0012\u00020&`$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011¨\u0006@"}, d2 = {"Lcom/dw/launcher/data/component/PhoneStatusComponent;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "SIM_APPLICATION_STATE_CHANGED", BuildConfig.FLAVOR, "isImsServiceRegister", BuildConfig.FLAVOR, "()Z", "setImsServiceRegister", "(Z)V", "level", BuildConfig.FLAVOR, "getLevel", "()I", "setLevel", "(I)V", "mExecutor", "Ljava/util/concurrent/Executor;", "getMExecutor", "()Ljava/util/concurrent/Executor;", "setMExecutor", "(Ljava/util/concurrent/Executor;)V", "mImsListener", "com/dw/launcher/data/component/PhoneStatusComponent$mImsListener$1", "Lcom/dw/launcher/data/component/PhoneStatusComponent$mImsListener$1;", "mImsService", "Lcom/android/ims/internal/IImsServiceEx;", "kotlin.jvm.PlatformType", "mListener", "com/dw/launcher/data/component/PhoneStatusComponent$mListener$1", "Lcom/dw/launcher/data/component/PhoneStatusComponent$mListener$1;", "mListeners", "Ljava/util/ArrayList;", "Lcom/dw/launcher/data/component/PhoneStatusComponent$OnPhoneStatusChangedListener;", "Lkotlin/collections/ArrayList;", "mPhoneStatusListeners", "Lcom/dw/launcher/data/component/PhoneStatusComponent$OnPhoneStateChangedListener;", "mReceiver", "com/dw/launcher/data/component/PhoneStatusComponent$mReceiver$1", "Lcom/dw/launcher/data/component/PhoneStatusComponent$mReceiver$1;", "mTelephonyManager", "Landroid/telephony/TelephonyManager;", "mVolteEnabled", "phoneState", "getPhoneState", "setPhoneState", "addListener", BuildConfig.FLAVOR, "listener", "addPhoneStateListener", "getCarrierLabel", "getProvidersName", "isShowVolte", "isSimCardReady", "register", "registerImsService", "removeListener", "removePhoneStateListener", "unRegisterImsService", "unregister", "OnPhoneStateChangedListener", "OnPhoneStatusChangedListener", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PhoneStatusComponent {
    private final String SIM_APPLICATION_STATE_CHANGED;
    private final Context context;
    private boolean isImsServiceRegister;
    private int level;

    @Inject
    public Executor mExecutor;
    private final PhoneStatusComponent$mImsListener$1 mImsListener;
    private final IImsServiceEx mImsService;
    private final PhoneStatusComponent$mListener$1 mListener;
    private final ArrayList<OnPhoneStatusChangedListener> mListeners;
    private final ArrayList<OnPhoneStateChangedListener> mPhoneStatusListeners;
    private final PhoneStatusComponent$mReceiver$1 mReceiver;
    private final TelephonyManager mTelephonyManager;
    private boolean mVolteEnabled;
    private int phoneState;

    /* JADX INFO: compiled from: PhoneStatusComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/data/component/PhoneStatusComponent$OnPhoneStateChangedListener;", BuildConfig.FLAVOR, "onPhoneStateChanged", BuildConfig.FLAVOR, NotificationCompat.CATEGORY_STATUS, BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnPhoneStateChangedListener {
        void onPhoneStateChanged(int status);
    }

    /* JADX INFO: compiled from: PhoneStatusComponent.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/dw/launcher/data/component/PhoneStatusComponent$OnPhoneStatusChangedListener;", BuildConfig.FLAVOR, "onDataActivity", BuildConfig.FLAVOR, "direction", BuildConfig.FLAVOR, "onSignalStrengthChanged", "batteryLevel", "onSimStateChanged", "onVolteRegisterStateChanged", "mVolteEnabled", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnPhoneStatusChangedListener {

        /* JADX INFO: compiled from: PhoneStatusComponent.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onDataActivity(OnPhoneStatusChangedListener onPhoneStatusChangedListener, int i) {
            }

            public static void onSimStateChanged(OnPhoneStatusChangedListener onPhoneStatusChangedListener) {
            }

            public static void onVolteRegisterStateChanged(OnPhoneStatusChangedListener onPhoneStatusChangedListener, boolean z) {
            }
        }

        void onDataActivity(int direction);

        void onSignalStrengthChanged(int batteryLevel);

        void onSimStateChanged();

        void onVolteRegisterStateChanged(boolean mVolteEnabled);
    }

    public final boolean isShowVolte() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.dw.launcher.data.component.PhoneStatusComponent$mImsListener$1] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.dw.launcher.data.component.PhoneStatusComponent$mListener$1] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.dw.launcher.data.component.PhoneStatusComponent$mReceiver$1] */
    @Inject
    public PhoneStatusComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Object systemService = context.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        this.mTelephonyManager = (TelephonyManager) systemService;
        this.SIM_APPLICATION_STATE_CHANGED = "android.telephony.action.SIM_APPLICATION_STATE_CHANGED";
        this.mListeners = new ArrayList<>();
        this.mPhoneStatusListeners = new ArrayList<>();
        this.level = -1;
        this.mImsService = ImsManagerEx.getIImsServiceEx();
        this.mListener = new PhoneStateListener() { // from class: com.dw.launcher.data.component.PhoneStatusComponent$mListener$1
            @Override // android.telephony.PhoneStateListener
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                if (signalStrength != null) {
                    int level = signalStrength.getLevel();
                    PhoneStatusComponent phoneStatusComponent = this.this$0;
                    phoneStatusComponent.setLevel(level);
                    Iterator it = phoneStatusComponent.mListeners.iterator();
                    while (it.hasNext()) {
                        ((PhoneStatusComponent.OnPhoneStatusChangedListener) it.next()).onSignalStrengthChanged(phoneStatusComponent.getLevel());
                    }
                    DialProvider.signalValue = phoneStatusComponent.getLevel();
                }
            }

            @Override // android.telephony.PhoneStateListener
            public void onDataActivity(int direction) {
                super.onDataActivity(direction);
                Iterator it = this.this$0.mListeners.iterator();
                while (it.hasNext()) {
                    ((PhoneStatusComponent.OnPhoneStatusChangedListener) it.next()).onDataActivity(direction);
                }
            }

            @Override // android.telephony.PhoneStateListener
            public void onCallStateChanged(int state, String phoneNumber) {
                super.onCallStateChanged(state, phoneNumber);
                Timber.Forest.d("onCallStateChanged: " + state, new Object[0]);
                if (state == 0) {
                    this.this$0.setPhoneState(0);
                    Iterator it = this.this$0.mPhoneStatusListeners.iterator();
                    while (it.hasNext()) {
                        ((PhoneStatusComponent.OnPhoneStateChangedListener) it.next()).onPhoneStateChanged(0);
                    }
                    return;
                }
                if (state == 1) {
                    this.this$0.setPhoneState(1);
                    Iterator it2 = this.this$0.mPhoneStatusListeners.iterator();
                    while (it2.hasNext()) {
                        ((PhoneStatusComponent.OnPhoneStateChangedListener) it2.next()).onPhoneStateChanged(1);
                    }
                    return;
                }
                if (state == 2) {
                    this.this$0.setPhoneState(2);
                    Iterator it3 = this.this$0.mPhoneStatusListeners.iterator();
                    while (it3.hasNext()) {
                        ((PhoneStatusComponent.OnPhoneStateChangedListener) it3.next()).onPhoneStateChanged(2);
                    }
                    return;
                }
                this.this$0.setPhoneState(0);
                Iterator it4 = this.this$0.mPhoneStatusListeners.iterator();
                while (it4.hasNext()) {
                    ((PhoneStatusComponent.OnPhoneStateChangedListener) it4.next()).onPhoneStateChanged(0);
                }
            }
        };
        this.mReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.data.component.PhoneStatusComponent$mReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (Intrinsics.areEqual(intent.getAction(), this.this$0.SIM_APPLICATION_STATE_CHANGED)) {
                    Iterator it = this.this$0.mListeners.iterator();
                    while (it.hasNext()) {
                        ((PhoneStatusComponent.OnPhoneStatusChangedListener) it.next()).onSimStateChanged();
                    }
                }
            }
        };
        this.mImsListener = new IImsRegisterListener.Stub() { // from class: com.dw.launcher.data.component.PhoneStatusComponent$mImsListener$1
            public void imsRegisterStateChange(boolean imsRegisterStateChange) {
                if (this.this$0.mVolteEnabled != imsRegisterStateChange) {
                    this.this$0.mVolteEnabled = imsRegisterStateChange;
                    ArrayList arrayList = this.this$0.mListeners;
                    PhoneStatusComponent phoneStatusComponent = this.this$0;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((PhoneStatusComponent.OnPhoneStatusChangedListener) it.next()).onVolteRegisterStateChanged(phoneStatusComponent.mVolteEnabled);
                    }
                }
            }
        };
    }

    public final int getPhoneState() {
        return this.phoneState;
    }

    public final void setPhoneState(int i) {
        this.phoneState = i;
    }

    public final Executor getMExecutor() {
        Executor executor = this.mExecutor;
        if (executor != null) {
            return executor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mExecutor");
        return null;
    }

    public final void setMExecutor(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "<set-?>");
        this.mExecutor = executor;
    }

    public final int getLevel() {
        return this.level;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final void register() {
        this.mTelephonyManager.listen(this.mListener, TypedValues.CycleType.TYPE_PATH_ROTATE);
        this.context.registerReceiver(this.mReceiver, new IntentFilter(this.SIM_APPLICATION_STATE_CHANGED));
        if (isSimCardReady()) {
            registerImsService();
        }
    }

    /* JADX INFO: renamed from: isImsServiceRegister, reason: from getter */
    public final boolean getIsImsServiceRegister() {
        return this.isImsServiceRegister;
    }

    public final void setImsServiceRegister(boolean z) {
        this.isImsServiceRegister = z;
    }

    public final void registerImsService() {
        if (this.isImsServiceRegister) {
            return;
        }
        if (this.mImsService == null) {
            ImsManagerEx.getIImsServiceEx();
        }
        IImsServiceEx iImsServiceEx = this.mImsService;
        if (iImsServiceEx != null) {
            iImsServiceEx.registerforImsRegisterStateChanged(this.mImsListener);
        }
        this.isImsServiceRegister = true;
    }

    public final void unRegisterImsService() {
        if (this.isImsServiceRegister) {
            IImsServiceEx iImsServiceEx = this.mImsService;
            if (iImsServiceEx != null) {
                iImsServiceEx.unregisterforImsRegisterStateChanged(this.mImsListener);
            }
            this.isImsServiceRegister = false;
        }
    }

    public final void unregister() {
        this.mTelephonyManager.listen(this.mListener, 0);
        this.context.unregisterReceiver(this.mReceiver);
        unRegisterImsService();
    }

    public final boolean isSimCardReady() {
        return this.mTelephonyManager.getSimState() == 5;
    }

    public final void addListener(OnPhoneStatusChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListeners.add(listener);
    }

    public final void removeListener(OnPhoneStatusChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListeners.remove(listener);
    }

    public final void addPhoneStateListener(OnPhoneStateChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPhoneStatusListeners.add(listener);
    }

    public final void removePhoneStateListener(OnPhoneStateChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPhoneStatusListeners.remove(listener);
    }

    public final String getCarrierLabel() {
        if (isSimCardReady()) {
            return this.mTelephonyManager.getNetworkOperatorName();
        }
        return null;
    }

    public final String getProvidersName() {
        String string;
        String subscriberId = this.mTelephonyManager.getSubscriberId();
        if (subscriberId == null) {
            String string2 = this.context.getString(R.string.unknown);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (subscriberId.length() == 16) {
            subscriberId = subscriberId.substring(1, 16);
            Intrinsics.checkNotNullExpressionValue(subscriberId, "substring(...)");
        }
        if (subscriberId != null) {
            if (StringsKt.startsWith$default(subscriberId, "46000", false, 2, (Object) null) || StringsKt.startsWith$default(subscriberId, "46002", false, 2, (Object) null) || StringsKt.startsWith$default(subscriberId, "46004", false, 2, (Object) null) || StringsKt.startsWith$default(subscriberId, "46008", false, 2, (Object) null) || StringsKt.startsWith$default(subscriberId, "46007", false, 2, (Object) null) || StringsKt.startsWith$default(subscriberId, "46020", false, 2, (Object) null) || StringsKt.startsWith$default(subscriberId, "46013", false, 2, (Object) null)) {
                string = this.context.getString(R.string.china_mobile);
            } else if (StringsKt.startsWith$default(subscriberId, "46001", false, 2, (Object) null) || StringsKt.startsWith$default(subscriberId, "46006", false, 2, (Object) null) || StringsKt.startsWith$default(subscriberId, "46009", false, 2, (Object) null) || StringsKt.startsWith$default(subscriberId, "46010", false, 2, (Object) null)) {
                string = this.context.getString(R.string.china_television);
            } else if (StringsKt.startsWith$default(subscriberId, "46003", false, 2, (Object) null) || StringsKt.startsWith$default(subscriberId, "46005", false, 2, (Object) null) || StringsKt.startsWith$default(subscriberId, "46011", false, 2, (Object) null) || StringsKt.startsWith$default(subscriberId, "46012", false, 2, (Object) null)) {
                string = this.context.getString(R.string.china_telecom);
            } else {
                string = StringsKt.startsWith$default(subscriberId, "46015", false, 2, (Object) null) ? this.context.getString(R.string.china_broad_network) : this.context.getString(R.string.unknown);
            }
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string3 = this.context.getString(R.string.unknown);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return string3;
    }
}
