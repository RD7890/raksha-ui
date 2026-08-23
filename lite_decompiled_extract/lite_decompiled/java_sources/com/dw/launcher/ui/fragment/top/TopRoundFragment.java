package com.dw.launcher.ui.fragment.top;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ims.internal.IImsRegisterListener;
import com.android.ims.internal.IImsServiceEx;
import com.android.ims.internal.ImsManagerEx;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dw.launcher.R;
import com.dw.launcher.core.component.VoiceComponent;
import com.dw.launcher.data.component.BluetoothComponent;
import com.dw.launcher.data.component.BrightComponent;
import com.dw.launcher.data.component.WifiComponent;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.listener.OnScrollChangeListener;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.ui.shortcut.AccelerateSwitchShortcut;
import com.dw.launcher.ui.shortcut.BluetoothSwitchShortcut;
import com.dw.launcher.ui.shortcut.FlySwitchShortcut;
import com.dw.launcher.ui.shortcut.GprsSwitchShortcut;
import com.dw.launcher.ui.shortcut.LightModeSwitchShortcut;
import com.dw.launcher.ui.shortcut.MulTaskSwitchShortcut;
import com.dw.launcher.ui.shortcut.PowerSaveSwitchShortcut;
import com.dw.launcher.ui.shortcut.PowerSwitchShortcut;
import com.dw.launcher.ui.shortcut.SenceSwitchShortcut;
import com.dw.launcher.ui.shortcut.SettingsSwitchShortcut;
import com.dw.launcher.ui.shortcut.SwitchShortcut;
import com.dw.launcher.ui.shortcut.VolumnSwitchShortcut;
import com.dw.launcher.ui.shortcut.WifiSwitchShortcut;
import com.dw.launcher.ui.view.SignalClusterLayout;
import com.dw.launcher.util.NetworkUtil;
import com.dw.launcher.util.SettingsProperty;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import timber.log.Timber;

/* JADX INFO: compiled from: TopRoundFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r*\u0002<a\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020{H\u0002J\b\u0010|\u001a\u00020\u0005H\u0016J\u0010\u0010}\u001a\u00020y2\u0006\u0010z\u001a\u00020{H\u0002J\u0006\u0010~\u001a\u00020yJ\u000e\u0010\u007f\u001a\u00020y2\u0006\u0010z\u001a\u00020{J\u0007\u0010\u0080\u0001\u001a\u00020yJ\u0012\u0010\u0081\u0001\u001a\u00020y2\u0007\u0010\u0082\u0001\u001a\u000208H\u0016J\t\u0010\u0083\u0001\u001a\u00020yH\u0016J\t\u0010\u0084\u0001\u001a\u00020yH\u0016J\t\u0010\u0085\u0001\u001a\u00020yH\u0016J\u001d\u0010\u0086\u0001\u001a\u00020y2\u0006\u0010z\u001a\u00020{2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016J\t\u0010\u0089\u0001\u001a\u00020yH\u0002J\t\u0010\u008a\u0001\u001a\u00020yH\u0002J\u0012\u0010\u008b\u0001\u001a\u00020y2\u0007\u0010\u008c\u0001\u001a\u000208H\u0002J\u0007\u0010\u008d\u0001\u001a\u00020yJ\u0007\u0010\u008e\u0001\u001a\u00020yJ\u0011\u0010\u008f\u0001\u001a\u00020y2\u0006\u0010z\u001a\u00020{H\u0002J\u000f\u0010\u0090\u0001\u001a\u00020y2\u0006\u0010^\u001a\u00020_J\u0007\u0010\u0091\u0001\u001a\u00020yJ\t\u0010\u0092\u0001\u001a\u00020yH\u0002J\u0007\u0010\u0093\u0001\u001a\u00020yJ\u000f\u0010\u0094\u0001\u001a\u00020y2\u0006\u0010z\u001a\u00020{R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000208X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010=R\u000e\u0010>\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u0012\u0012\u0004\u0012\u00020B0Aj\b\u0012\u0004\u0012\u00020B`CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020EX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020KX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020KX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020KX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020OX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020KX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010R\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001e\u0010X\u001a\u00020Y8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u00020aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010bR\u001a\u0010c\u001a\u00020dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001c\u0010i\u001a\u0004\u0018\u00010jX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001e\u0010o\u001a\u00020Y8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010[\"\u0004\bq\u0010]R\u001c\u0010r\u001a\u0004\u0018\u00010sX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010w¨\u0006\u0095\u0001"}, d2 = {"Lcom/dw/launcher/ui/fragment/top/TopRoundFragment;", "Lcom/dw/launcher/base/BaseFragment;", "Lcom/dw/launcher/data/component/BluetoothComponent$BluetoothComponentCallback;", "()V", "IMS_FEATURE_TYPE_DEFAULT", "", "getIMS_FEATURE_TYPE_DEFAULT", "()I", "bluetoothComponent", "Lcom/dw/launcher/data/component/BluetoothComponent;", "getBluetoothComponent", "()Lcom/dw/launcher/data/component/BluetoothComponent;", "setBluetoothComponent", "(Lcom/dw/launcher/data/component/BluetoothComponent;)V", "bluetoothSwitchShortcut", "Lcom/dw/launcher/ui/shortcut/BluetoothSwitchShortcut;", "getBluetoothSwitchShortcut", "()Lcom/dw/launcher/ui/shortcut/BluetoothSwitchShortcut;", "setBluetoothSwitchShortcut", "(Lcom/dw/launcher/ui/shortcut/BluetoothSwitchShortcut;)V", "flySwitchShortcut", "Lcom/dw/launcher/ui/shortcut/FlySwitchShortcut;", "getFlySwitchShortcut", "()Lcom/dw/launcher/ui/shortcut/FlySwitchShortcut;", "setFlySwitchShortcut", "(Lcom/dw/launcher/ui/shortcut/FlySwitchShortcut;)V", "gprsSwitchShortcut", "Lcom/dw/launcher/ui/shortcut/GprsSwitchShortcut;", "getGprsSwitchShortcut", "()Lcom/dw/launcher/ui/shortcut/GprsSwitchShortcut;", "setGprsSwitchShortcut", "(Lcom/dw/launcher/ui/shortcut/GprsSwitchShortcut;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setLauncherRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "mBrightComponent", "Lcom/dw/launcher/data/component/BrightComponent;", "getMBrightComponent", "()Lcom/dw/launcher/data/component/BrightComponent;", "setMBrightComponent", "(Lcom/dw/launcher/data/component/BrightComponent;)V", "mIImsServiceEx", "Lcom/android/ims/internal/IImsServiceEx;", "mImsIntentReceiver", "Landroid/content/BroadcastReceiver;", "mImsType", "mImsUtListenerExBinder", "Lcom/android/ims/internal/IImsRegisterListener$Stub;", "mIsImsListenerRegistered", "", "mIsRegImsChange", "mIsVoLteEnable", "mListener", "com/dw/launcher/ui/fragment/top/TopRoundFragment$mListener$1", "Lcom/dw/launcher/ui/fragment/top/TopRoundFragment$mListener$1;", "mSignalClusterLayout", "Lcom/dw/launcher/ui/view/SignalClusterLayout;", "mSwitches", "Ljava/util/ArrayList;", "Lcom/dw/launcher/ui/shortcut/SwitchShortcut;", "Lkotlin/collections/ArrayList;", "mTelephonyManager", "Landroid/telephony/TelephonyManager;", "getMTelephonyManager", "()Landroid/telephony/TelephonyManager;", "setMTelephonyManager", "(Landroid/telephony/TelephonyManager;)V", "mTopAirPlane", "Landroid/widget/ImageView;", "mTopBluetoothView", "mTopDataView", "mTopNetworkView", "Landroid/widget/TextView;", "mTopVolteView", "mTopWifiView", "mVoiceComponent", "Lcom/dw/launcher/core/component/VoiceComponent;", "getMVoiceComponent", "()Lcom/dw/launcher/core/component/VoiceComponent;", "setMVoiceComponent", "(Lcom/dw/launcher/core/component/VoiceComponent;)V", "mWifiComponent", "Lcom/dw/launcher/data/component/WifiComponent;", "getMWifiComponent", "()Lcom/dw/launcher/data/component/WifiComponent;", "setMWifiComponent", "(Lcom/dw/launcher/data/component/WifiComponent;)V", "onScrollChangeListener", "Lcom/dw/launcher/data/listener/OnScrollChangeListener;", "receiver", "com/dw/launcher/ui/fragment/top/TopRoundFragment$receiver$1", "Lcom/dw/launcher/ui/fragment/top/TopRoundFragment$receiver$1;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "senceSwitchShortcut", "Lcom/dw/launcher/ui/shortcut/SenceSwitchShortcut;", "getSenceSwitchShortcut", "()Lcom/dw/launcher/ui/shortcut/SenceSwitchShortcut;", "setSenceSwitchShortcut", "(Lcom/dw/launcher/ui/shortcut/SenceSwitchShortcut;)V", "wifiComponent", "getWifiComponent", "setWifiComponent", "wifiSwitchShortcut", "Lcom/dw/launcher/ui/shortcut/WifiSwitchShortcut;", "getWifiSwitchShortcut", "()Lcom/dw/launcher/ui/shortcut/WifiSwitchShortcut;", "setWifiSwitchShortcut", "(Lcom/dw/launcher/ui/shortcut/WifiSwitchShortcut;)V", "bluetooth", "", "view", "Landroid/view/View;", "getLayoutId", "gprs", "initConfig", "initFootView", "initReceiver", "onBluetoothStateChanged", "enable", "onDestroyView", "onStart", "onStop", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "onWifiStateChanged", "refresh", "refreshVolteIndicators", "show", "scrollBottom", "scrollerStatusListen", "sence", "setOnScrollChangeListener", "switchToTop", "tryRegisterImsListener", "unregister", "wifi", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class TopRoundFragment extends Hilt_TopRoundFragment implements BluetoothComponent.BluetoothComponentCallback {

    @Inject
    public BluetoothComponent bluetoothComponent;
    private BluetoothSwitchShortcut bluetoothSwitchShortcut;
    private FlySwitchShortcut flySwitchShortcut;
    private GprsSwitchShortcut gprsSwitchShortcut;

    @Inject
    public LauncherRepository launcherRepository;

    @Inject
    public BrightComponent mBrightComponent;
    private IImsServiceEx mIImsServiceEx;
    private int mImsType;
    private boolean mIsImsListenerRegistered;
    private boolean mIsVoLteEnable;
    private SignalClusterLayout mSignalClusterLayout;
    public TelephonyManager mTelephonyManager;
    private ImageView mTopAirPlane;
    private ImageView mTopBluetoothView;
    private ImageView mTopDataView;
    private TextView mTopNetworkView;
    private TextView mTopVolteView;
    private ImageView mTopWifiView;

    @Inject
    public VoiceComponent mVoiceComponent;

    @Inject
    public WifiComponent mWifiComponent;
    private OnScrollChangeListener onScrollChangeListener;
    public RecyclerView recyclerView;
    private SenceSwitchShortcut senceSwitchShortcut;

    @Inject
    public WifiComponent wifiComponent;
    private WifiSwitchShortcut wifiSwitchShortcut;
    private final ArrayList<SwitchShortcut> mSwitches = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final TopRoundFragment$receiver$1 receiver = new BroadcastReceiver() { // from class: com.dw.launcher.ui.fragment.top.TopRoundFragment$receiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context mContext, Intent intent) {
            View mItemView;
            View mItemView2;
            Intrinsics.checkNotNullParameter(intent, "intent");
            try {
                String action = intent.getAction();
                if (Intrinsics.areEqual(action, "com.dw.wifi.change")) {
                    Log.i("lkang", "wifi onReceive onWifiStateChanged");
                    this.this$0.onWifiStateChanged();
                    return;
                }
                if (Intrinsics.areEqual(action, "android.intent.action.AIRPLANE_MODE")) {
                    this.this$0.refresh();
                    Context context = this.this$0.getContext();
                    int i = Settings.Secure.getInt(context != null ? context.getContentResolver() : null, "airplane_gprs", 0);
                    ImageView imageView = this.this$0.mTopDataView;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopDataView");
                        imageView = null;
                    }
                    imageView.setVisibility(i == 1 ? 0 : 8);
                    if (NetworkUtil.getAirplaneModeEnabled(this.this$0.getContext())) {
                        WifiSwitchShortcut wifiSwitchShortcut = this.this$0.getWifiSwitchShortcut();
                        Boolean boolValueOf = (wifiSwitchShortcut == null || (mItemView2 = wifiSwitchShortcut.getMItemView()) == null) ? null : Boolean.valueOf(mItemView2.isSelected());
                        Context context2 = this.this$0.getContext();
                        Settings.Secure.putInt(context2 != null ? context2.getContentResolver() : null, "airplane_wifi", Intrinsics.areEqual((Object) boolValueOf, (Object) true) ? 1 : 0);
                        GprsSwitchShortcut gprsSwitchShortcut = this.this$0.getGprsSwitchShortcut();
                        Boolean boolValueOf2 = (gprsSwitchShortcut == null || (mItemView = gprsSwitchShortcut.getMItemView()) == null) ? null : Boolean.valueOf(mItemView.isSelected());
                        Context context3 = this.this$0.getContext();
                        Settings.Secure.putInt(context3 != null ? context3.getContentResolver() : null, "airplane_gprs", Intrinsics.areEqual((Object) boolValueOf2, (Object) true) ? 1 : 0);
                        return;
                    }
                    Context context4 = this.this$0.getContext();
                    int i2 = Settings.Secure.getInt(context4 != null ? context4.getContentResolver() : null, "airplane_wifi");
                    WifiSwitchShortcut wifiSwitchShortcut2 = this.this$0.getWifiSwitchShortcut();
                    View mItemView3 = wifiSwitchShortcut2 != null ? wifiSwitchShortcut2.getMItemView() : null;
                    if (mItemView3 != null) {
                        mItemView3.setSelected(i2 == 1);
                    }
                    if (i == 1) {
                        GprsSwitchShortcut gprsSwitchShortcut2 = this.this$0.getGprsSwitchShortcut();
                        View mItemView4 = gprsSwitchShortcut2 != null ? gprsSwitchShortcut2.getMItemView() : null;
                        if (mItemView4 != null) {
                            mItemView4.setSelected(true);
                        }
                        NetworkUtil.setMobileDataEnabled(this.this$0.getContext(), true);
                        return;
                    }
                    GprsSwitchShortcut gprsSwitchShortcut3 = this.this$0.getGprsSwitchShortcut();
                    View mItemView5 = gprsSwitchShortcut3 != null ? gprsSwitchShortcut3.getMItemView() : null;
                    if (mItemView5 != null) {
                        mItemView5.setSelected(false);
                    }
                    NetworkUtil.setMobileDataEnabled(this.this$0.getContext(), false);
                }
            } catch (Exception e) {
                Log.e("lkang", e.toString());
            }
        }
    };
    private final TopRoundFragment$mListener$1 mListener = new PhoneStateListener() { // from class: com.dw.launcher.ui.fragment.top.TopRoundFragment$mListener$1
        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int state) {
            super.onDataConnectionStateChanged(state);
            Log.i("lkang", "onDataConnectionStateChanged state:" + state);
        }
    };
    private final BroadcastReceiver mImsIntentReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.ui.fragment.top.TopRoundFragment$mImsIntentReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Log.i("lkang", "mImsIntentReceiver intent.action = " + intent.getAction());
            if ("com.android.ims.IMS_SERVICE_DOWN".equals(intent.getAction())) {
                this.this$0.mIsImsListenerRegistered = false;
            }
            this.this$0.tryRegisterImsListener();
        }
    };
    private final boolean mIsRegImsChange = true;
    private final int IMS_FEATURE_TYPE_DEFAULT = -2;
    private final IImsRegisterListener.Stub mImsUtListenerExBinder = new IImsRegisterListener.Stub() { // from class: com.dw.launcher.ui.fragment.top.TopRoundFragment$mImsUtListenerExBinder$1
        public void imsRegisterStateChange(boolean isRegistered) {
            Log.d("lkang", "imsRegisterStateChange. isRegistered: " + isRegistered);
            if (this.this$0.mIsRegImsChange) {
                if (this.this$0.mIsVoLteEnable != isRegistered) {
                    this.this$0.mIsVoLteEnable = isRegistered;
                }
                TopRoundFragment topRoundFragment = this.this$0;
                topRoundFragment.mImsType = topRoundFragment.getIMS_FEATURE_TYPE_DEFAULT();
                try {
                    this.this$0.mIImsServiceEx = ImsManagerEx.getIImsServiceEx();
                    if (this.this$0.mIImsServiceEx == null) {
                        return;
                    }
                    TopRoundFragment topRoundFragment2 = this.this$0;
                    IImsServiceEx iImsServiceEx = topRoundFragment2.mIImsServiceEx;
                    Intrinsics.checkNotNull(iImsServiceEx);
                    topRoundFragment2.mImsType = iImsServiceEx.getCurrentImsFeature();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                boolean z = this.this$0.mImsType == 0;
                Log.d("lkang", "imsRegistered type: " + this.this$0.mImsType);
                TopRoundFragment topRoundFragment3 = this.this$0;
                topRoundFragment3.refreshVolteIndicators(z && topRoundFragment3.mIsVoLteEnable);
            }
        }
    };

    private final void bluetooth(View view) {
    }

    private final void gprs(View view) {
    }

    private final void sence(View view) {
    }

    public final void wifi(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public final WifiComponent getWifiComponent() {
        WifiComponent wifiComponent = this.wifiComponent;
        if (wifiComponent != null) {
            return wifiComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("wifiComponent");
        return null;
    }

    public final void setWifiComponent(WifiComponent wifiComponent) {
        Intrinsics.checkNotNullParameter(wifiComponent, "<set-?>");
        this.wifiComponent = wifiComponent;
    }

    public final BluetoothComponent getBluetoothComponent() {
        BluetoothComponent bluetoothComponent = this.bluetoothComponent;
        if (bluetoothComponent != null) {
            return bluetoothComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bluetoothComponent");
        return null;
    }

    public final void setBluetoothComponent(BluetoothComponent bluetoothComponent) {
        Intrinsics.checkNotNullParameter(bluetoothComponent, "<set-?>");
        this.bluetoothComponent = bluetoothComponent;
    }

    public final TelephonyManager getMTelephonyManager() {
        TelephonyManager telephonyManager = this.mTelephonyManager;
        if (telephonyManager != null) {
            return telephonyManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTelephonyManager");
        return null;
    }

    public final void setMTelephonyManager(TelephonyManager telephonyManager) {
        Intrinsics.checkNotNullParameter(telephonyManager, "<set-?>");
        this.mTelephonyManager = telephonyManager;
    }

    public final BrightComponent getMBrightComponent() {
        BrightComponent brightComponent = this.mBrightComponent;
        if (brightComponent != null) {
            return brightComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBrightComponent");
        return null;
    }

    public final void setMBrightComponent(BrightComponent brightComponent) {
        Intrinsics.checkNotNullParameter(brightComponent, "<set-?>");
        this.mBrightComponent = brightComponent;
    }

    public final WifiComponent getMWifiComponent() {
        WifiComponent wifiComponent = this.mWifiComponent;
        if (wifiComponent != null) {
            return wifiComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mWifiComponent");
        return null;
    }

    public final void setMWifiComponent(WifiComponent wifiComponent) {
        Intrinsics.checkNotNullParameter(wifiComponent, "<set-?>");
        this.mWifiComponent = wifiComponent;
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

    public final VoiceComponent getMVoiceComponent() {
        VoiceComponent voiceComponent = this.mVoiceComponent;
        if (voiceComponent != null) {
            return voiceComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceComponent");
        return null;
    }

    public final void setMVoiceComponent(VoiceComponent voiceComponent) {
        Intrinsics.checkNotNullParameter(voiceComponent, "<set-?>");
        this.mVoiceComponent = voiceComponent;
    }

    public final WifiSwitchShortcut getWifiSwitchShortcut() {
        return this.wifiSwitchShortcut;
    }

    public final void setWifiSwitchShortcut(WifiSwitchShortcut wifiSwitchShortcut) {
        this.wifiSwitchShortcut = wifiSwitchShortcut;
    }

    public final BluetoothSwitchShortcut getBluetoothSwitchShortcut() {
        return this.bluetoothSwitchShortcut;
    }

    public final void setBluetoothSwitchShortcut(BluetoothSwitchShortcut bluetoothSwitchShortcut) {
        this.bluetoothSwitchShortcut = bluetoothSwitchShortcut;
    }

    public final GprsSwitchShortcut getGprsSwitchShortcut() {
        return this.gprsSwitchShortcut;
    }

    public final void setGprsSwitchShortcut(GprsSwitchShortcut gprsSwitchShortcut) {
        this.gprsSwitchShortcut = gprsSwitchShortcut;
    }

    public final SenceSwitchShortcut getSenceSwitchShortcut() {
        return this.senceSwitchShortcut;
    }

    public final void setSenceSwitchShortcut(SenceSwitchShortcut senceSwitchShortcut) {
        this.senceSwitchShortcut = senceSwitchShortcut;
    }

    public final FlySwitchShortcut getFlySwitchShortcut() {
        return this.flySwitchShortcut;
    }

    public final void setFlySwitchShortcut(FlySwitchShortcut flySwitchShortcut) {
        this.flySwitchShortcut = flySwitchShortcut;
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.recyclerView = recyclerView;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public int getLayoutId() {
        return R.layout.fragment_top_round;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroyView() {
        super.onDestroyView();
        getMTelephonyManager().listen(this.mListener, 0);
        unregister();
        getBluetoothComponent().unregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:128:0x0222  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c0  */
    public final void refresh() {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        Drawable drawable;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        Drawable drawable2;
        Log.i("lkang", "refresh");
        boolean airplaneModeEnabled = NetworkUtil.getAirplaneModeEnabled(getContext());
        boolean zIsConnected = getWifiComponent().isConnected();
        Timber.INSTANCE.d("isAirplaneMode = " + airplaneModeEnabled, new Object[0]);
        WifiSwitchShortcut wifiSwitchShortcut = this.wifiSwitchShortcut;
        if (wifiSwitchShortcut != null) {
            wifiSwitchShortcut.notifyDataChanged(getWifiComponent().isEnable());
        }
        if (airplaneModeEnabled) {
            ImageView imageView7 = this.mTopWifiView;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopWifiView");
                imageView7 = null;
            }
            imageView7.setVisibility(8);
            TextView textView = this.mTopNetworkView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopNetworkView");
                textView = null;
            }
            textView.setVisibility(8);
            ImageView imageView8 = this.mTopDataView;
            if (imageView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopDataView");
                imageView8 = null;
            }
            imageView8.setVisibility(8);
            ImageView imageView9 = this.mTopAirPlane;
            if (imageView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopAirPlane");
                imageView9 = null;
            }
            imageView9.setVisibility(0);
            FlySwitchShortcut flySwitchShortcut = this.flySwitchShortcut;
            if (flySwitchShortcut != null) {
                flySwitchShortcut.notifyDataChanged(true);
            }
            SignalClusterLayout signalClusterLayout = this.mSignalClusterLayout;
            if (signalClusterLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSignalClusterLayout");
                signalClusterLayout = null;
            }
            signalClusterLayout.hideSingalView(true);
            TextView textView2 = this.mTopVolteView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopVolteView");
                textView2 = null;
            }
            textView2.setVisibility(8);
            if (zIsConnected) {
                int iLevel = getWifiComponent().level();
                Context context = getContext();
                if (context != null) {
                    context.getDrawable(R.drawable.icon_wifi_0);
                }
                if (iLevel >= 4) {
                    Context context2 = getContext();
                    if (context2 != null) {
                        drawable2 = context2.getDrawable(R.drawable.icon_wifi_4);
                    } else {
                        drawable2 = null;
                    }
                } else if (iLevel == 3) {
                    Context context3 = getContext();
                    if (context3 != null) {
                        drawable2 = context3.getDrawable(R.drawable.icon_wifi_3);
                    } else {
                        drawable2 = null;
                    }
                } else if (iLevel == 2) {
                    Context context4 = getContext();
                    if (context4 != null) {
                        drawable2 = context4.getDrawable(R.drawable.icon_wifi_2);
                    } else {
                        drawable2 = null;
                    }
                } else if (iLevel == 1) {
                    Context context5 = getContext();
                    if (context5 != null) {
                        drawable2 = context5.getDrawable(R.drawable.icon_wifi_1);
                    } else {
                        drawable2 = null;
                    }
                } else {
                    Context context6 = getContext();
                    if (context6 != null) {
                        drawable2 = context6.getDrawable(R.drawable.icon_wifi_0);
                    } else {
                        drawable2 = null;
                    }
                }
                ImageView imageView10 = this.mTopWifiView;
                if (imageView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopWifiView");
                    imageView10 = null;
                }
                imageView10.setVisibility(0);
                ImageView imageView11 = this.mTopWifiView;
                if (imageView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopWifiView");
                    imageView11 = null;
                }
                imageView11.setImageDrawable(drawable2);
            }
            if (getBluetoothComponent().isEnable()) {
                ImageView imageView12 = this.mTopBluetoothView;
                if (imageView12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopBluetoothView");
                    imageView6 = null;
                } else {
                    imageView6 = imageView12;
                }
                if (imageView6 != null) {
                    imageView6.setVisibility(0);
                }
            } else {
                ImageView imageView13 = this.mTopBluetoothView;
                if (imageView13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopBluetoothView");
                    imageView5 = null;
                } else {
                    imageView5 = imageView13;
                }
                if (imageView5 != null) {
                    imageView5.setVisibility(8);
                }
            }
        } else {
            boolean zHasSimCard = NetworkUtil.hasSimCard(getContext());
            ImageView imageView14 = this.mTopAirPlane;
            if (imageView14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopAirPlane");
                imageView14 = null;
            }
            imageView14.setVisibility(8);
            if (zHasSimCard) {
                TextView textView3 = this.mTopNetworkView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopNetworkView");
                    textView3 = null;
                }
                textView3.setVisibility(0);
                SignalClusterLayout signalClusterLayout2 = this.mSignalClusterLayout;
                if (signalClusterLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSignalClusterLayout");
                    signalClusterLayout2 = null;
                }
                signalClusterLayout2.hasSim();
                SignalClusterLayout signalClusterLayout3 = this.mSignalClusterLayout;
                if (signalClusterLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSignalClusterLayout");
                    signalClusterLayout3 = null;
                }
                signalClusterLayout3.hideSingalView(false);
                String curNetType = NetworkUtil.getCurNetType(getContext());
                TextView textView4 = this.mTopNetworkView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopNetworkView");
                    textView4 = null;
                }
                textView4.setText(curNetType);
                if (Intrinsics.areEqual(SystemProperties.get("persist.sys.dw.fake.5g", "false"), "true") && Intrinsics.areEqual("4G", curNetType)) {
                    TextView textView5 = this.mTopNetworkView;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopNetworkView");
                        textView5 = null;
                    }
                    textView5.setText("5G");
                }
                if (Intrinsics.areEqual(SystemProperties.get(SettingsProperty.SIGNAL_TYPE, "false"), "true")) {
                    TextView textView6 = this.mTopNetworkView;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopNetworkView");
                        textView6 = null;
                    }
                    textView6.setText("");
                }
            } else {
                TextView textView7 = this.mTopNetworkView;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopNetworkView");
                    textView7 = null;
                }
                textView7.setVisibility(8);
                ImageView imageView15 = this.mTopDataView;
                if (imageView15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopDataView");
                    imageView15 = null;
                }
                imageView15.setVisibility(8);
                SignalClusterLayout signalClusterLayout4 = this.mSignalClusterLayout;
                if (signalClusterLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSignalClusterLayout");
                    signalClusterLayout4 = null;
                }
                signalClusterLayout4.noSim();
                SignalClusterLayout signalClusterLayout5 = this.mSignalClusterLayout;
                if (signalClusterLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSignalClusterLayout");
                    signalClusterLayout5 = null;
                }
                signalClusterLayout5.hideSingalView(false);
            }
            if (zIsConnected) {
                int iLevel2 = getWifiComponent().level();
                Context context7 = getContext();
                if (context7 != null) {
                    context7.getDrawable(R.drawable.icon_wifi_0);
                }
                if (iLevel2 >= 4) {
                    Context context8 = getContext();
                    if (context8 != null) {
                        drawable = context8.getDrawable(R.drawable.icon_wifi_4);
                    } else {
                        drawable = null;
                    }
                } else if (iLevel2 == 3) {
                    Context context9 = getContext();
                    if (context9 != null) {
                        drawable = context9.getDrawable(R.drawable.icon_wifi_3);
                    } else {
                        drawable = null;
                    }
                } else if (iLevel2 == 2) {
                    Context context10 = getContext();
                    if (context10 != null) {
                        drawable = context10.getDrawable(R.drawable.icon_wifi_2);
                    } else {
                        drawable = null;
                    }
                } else if (iLevel2 == 1) {
                    Context context11 = getContext();
                    if (context11 != null) {
                        drawable = context11.getDrawable(R.drawable.icon_wifi_1);
                    } else {
                        drawable = null;
                    }
                } else {
                    Context context12 = getContext();
                    if (context12 != null) {
                        drawable = context12.getDrawable(R.drawable.icon_wifi_0);
                    } else {
                        drawable = null;
                    }
                }
                ImageView imageView16 = this.mTopWifiView;
                if (imageView16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopWifiView");
                    imageView16 = null;
                }
                imageView16.setVisibility(0);
                ImageView imageView17 = this.mTopWifiView;
                if (imageView17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopWifiView");
                    imageView17 = null;
                }
                imageView17.setImageDrawable(drawable);
                ImageView imageView18 = this.mTopDataView;
                if (imageView18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopDataView");
                    imageView4 = null;
                } else {
                    imageView4 = imageView18;
                }
                imageView4.setVisibility(8);
            } else {
                ImageView imageView19 = this.mTopWifiView;
                if (imageView19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopWifiView");
                    imageView19 = null;
                }
                imageView19.setVisibility(8);
                if (getMWifiComponent().isWifiApEnabled()) {
                    ImageView imageView20 = this.mTopWifiView;
                    if (imageView20 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopWifiView");
                        imageView20 = null;
                    }
                    imageView20.setVisibility(0);
                    ImageView imageView21 = this.mTopWifiView;
                    if (imageView21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopWifiView");
                        imageView21 = null;
                    }
                    Context context13 = getContext();
                    imageView21.setImageDrawable(context13 != null ? context13.getDrawable(R.drawable.icon_wifi_hot) : null);
                }
                boolean mobileDataEnabled = NetworkUtil.getMobileDataEnabled(getContext());
                if (!zHasSimCard) {
                    TextView textView8 = this.mTopNetworkView;
                    if (textView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopNetworkView");
                        textView8 = null;
                    }
                    textView8.setVisibility(8);
                    ImageView imageView22 = this.mTopDataView;
                    if (imageView22 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopDataView");
                        imageView = null;
                    } else {
                        imageView = imageView22;
                    }
                    imageView.setVisibility(8);
                } else if (mobileDataEnabled) {
                    ImageView imageView23 = this.mTopDataView;
                    if (imageView23 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopDataView");
                        imageView23 = null;
                    }
                    imageView23.setVisibility(0);
                    ImageView imageView24 = this.mTopDataView;
                    if (imageView24 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopDataView");
                        imageView3 = null;
                    } else {
                        imageView3 = imageView24;
                    }
                    imageView3.setImageResource(R.drawable.icon_data);
                } else {
                    ImageView imageView25 = this.mTopDataView;
                    if (imageView25 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopDataView");
                        imageView2 = null;
                    } else {
                        imageView2 = imageView25;
                    }
                    imageView2.setVisibility(8);
                }
            }
        }
        WifiSwitchShortcut wifiSwitchShortcut2 = this.wifiSwitchShortcut;
        if (wifiSwitchShortcut2 != null) {
            wifiSwitchShortcut2.notifyDataChanged(zIsConnected);
        }
        SenceSwitchShortcut senceSwitchShortcut = this.senceSwitchShortcut;
        if (senceSwitchShortcut != null) {
            senceSwitchShortcut.notifyDataChanged(true);
        }
        FlySwitchShortcut flySwitchShortcut2 = this.flySwitchShortcut;
        if (flySwitchShortcut2 != null) {
            flySwitchShortcut2.notifyDataChanged(false);
        }
        RecyclerView.Adapter adapter = getRecyclerView().getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onWifiStateChanged() {
        refresh();
    }

    public final void unregister() {
        Context context;
        Context context2 = getContext();
        if (context2 != null) {
            context2.unregisterReceiver(this.receiver);
        }
        try {
            if (this.mIsImsListenerRegistered) {
                this.mIsImsListenerRegistered = false;
                IImsServiceEx iImsServiceEx = this.mIImsServiceEx;
                if (iImsServiceEx != null) {
                    Intrinsics.checkNotNull(iImsServiceEx);
                    iImsServiceEx.unregisterforImsRegisterStateChanged(this.mImsUtListenerExBinder);
                }
            }
            if (this.mImsIntentReceiver == null || (context = getContext()) == null) {
                return;
            }
            context.unregisterReceiver(this.mImsIntentReceiver);
        } catch (RemoteException e) {
            Log.e("lkang", "RemoteException: " + e);
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.mSwitches.clear();
        LaunchConfig launchConfigLoadConfig = getLauncherRepository().loadConfig();
        if (launchConfigLoadConfig != null) {
            List statusBarFunctionList = launchConfigLoadConfig.getStatusBarFunctionList();
            if (statusBarFunctionList == null || statusBarFunctionList.isEmpty()) {
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                this.wifiSwitchShortcut = new WifiSwitchShortcut(contextRequireContext, getWifiComponent());
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                this.bluetoothSwitchShortcut = new BluetoothSwitchShortcut(contextRequireContext2, getBluetoothComponent());
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                this.gprsSwitchShortcut = new GprsSwitchShortcut(contextRequireContext3);
                Context contextRequireContext4 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                this.senceSwitchShortcut = new SenceSwitchShortcut(contextRequireContext4, getMVoiceComponent());
                Context contextRequireContext5 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
                this.flySwitchShortcut = new FlySwitchShortcut(contextRequireContext5);
                Activity activity = getActivity();
                Intrinsics.checkNotNull(activity);
                LightModeSwitchShortcut lightModeSwitchShortcut = new LightModeSwitchShortcut(activity, getMBrightComponent());
                Context contextRequireContext6 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext6, "requireContext(...)");
                PowerSaveSwitchShortcut powerSaveSwitchShortcut = new PowerSaveSwitchShortcut(contextRequireContext6);
                Activity activity2 = getActivity();
                Intrinsics.checkNotNull(activity2);
                VolumnSwitchShortcut volumnSwitchShortcut = new VolumnSwitchShortcut(activity2, getMVoiceComponent());
                Context contextRequireContext7 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext7, "requireContext(...)");
                SettingsSwitchShortcut settingsSwitchShortcut = new SettingsSwitchShortcut(contextRequireContext7, getLauncherRepository());
                ArrayList<SwitchShortcut> arrayList = this.mSwitches;
                WifiSwitchShortcut wifiSwitchShortcut = this.wifiSwitchShortcut;
                Intrinsics.checkNotNull(wifiSwitchShortcut);
                arrayList.add(wifiSwitchShortcut);
                ArrayList<SwitchShortcut> arrayList2 = this.mSwitches;
                BluetoothSwitchShortcut bluetoothSwitchShortcut = this.bluetoothSwitchShortcut;
                Intrinsics.checkNotNull(bluetoothSwitchShortcut);
                arrayList2.add(bluetoothSwitchShortcut);
                ArrayList<SwitchShortcut> arrayList3 = this.mSwitches;
                GprsSwitchShortcut gprsSwitchShortcut = this.gprsSwitchShortcut;
                Intrinsics.checkNotNull(gprsSwitchShortcut);
                arrayList3.add(gprsSwitchShortcut);
                ArrayList<SwitchShortcut> arrayList4 = this.mSwitches;
                SenceSwitchShortcut senceSwitchShortcut = this.senceSwitchShortcut;
                Intrinsics.checkNotNull(senceSwitchShortcut);
                arrayList4.add(senceSwitchShortcut);
                this.mSwitches.add(lightModeSwitchShortcut);
                this.mSwitches.add(volumnSwitchShortcut);
                ArrayList<SwitchShortcut> arrayList5 = this.mSwitches;
                FlySwitchShortcut flySwitchShortcut = this.flySwitchShortcut;
                Intrinsics.checkNotNull(flySwitchShortcut);
                arrayList5.add(flySwitchShortcut);
                this.mSwitches.add(settingsSwitchShortcut);
                this.mSwitches.add(powerSaveSwitchShortcut);
            } else {
                for (LaunchConfig.StatusBarFunctionList statusBarFunctionList2 : launchConfigLoadConfig.getStatusBarFunctionList()) {
                    if (statusBarFunctionList2.getEnable() == 1) {
                        switch (statusBarFunctionList2.getId()) {
                            case 1:
                                Context contextRequireContext8 = requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext8, "requireContext(...)");
                                WifiSwitchShortcut wifiSwitchShortcut2 = new WifiSwitchShortcut(contextRequireContext8, getWifiComponent());
                                this.wifiSwitchShortcut = wifiSwitchShortcut2;
                                ArrayList<SwitchShortcut> arrayList6 = this.mSwitches;
                                Intrinsics.checkNotNull(wifiSwitchShortcut2);
                                arrayList6.add(wifiSwitchShortcut2);
                                break;
                            case 2:
                                Context contextRequireContext9 = requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext9, "requireContext(...)");
                                BluetoothSwitchShortcut bluetoothSwitchShortcut2 = new BluetoothSwitchShortcut(contextRequireContext9, getBluetoothComponent());
                                this.bluetoothSwitchShortcut = bluetoothSwitchShortcut2;
                                ArrayList<SwitchShortcut> arrayList7 = this.mSwitches;
                                Intrinsics.checkNotNull(bluetoothSwitchShortcut2);
                                arrayList7.add(bluetoothSwitchShortcut2);
                                break;
                            case 3:
                                Context contextRequireContext10 = requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext10, "requireContext(...)");
                                GprsSwitchShortcut gprsSwitchShortcut2 = new GprsSwitchShortcut(contextRequireContext10);
                                this.gprsSwitchShortcut = gprsSwitchShortcut2;
                                ArrayList<SwitchShortcut> arrayList8 = this.mSwitches;
                                Intrinsics.checkNotNull(gprsSwitchShortcut2);
                                arrayList8.add(gprsSwitchShortcut2);
                                break;
                            case 4:
                                Context contextRequireContext11 = requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext11, "requireContext(...)");
                                SenceSwitchShortcut senceSwitchShortcut2 = new SenceSwitchShortcut(contextRequireContext11, getMVoiceComponent());
                                this.senceSwitchShortcut = senceSwitchShortcut2;
                                ArrayList<SwitchShortcut> arrayList9 = this.mSwitches;
                                Intrinsics.checkNotNull(senceSwitchShortcut2);
                                arrayList9.add(senceSwitchShortcut2);
                                break;
                            case 5:
                                Activity activity3 = getActivity();
                                Intrinsics.checkNotNull(activity3);
                                this.mSwitches.add(new LightModeSwitchShortcut(activity3, getMBrightComponent()));
                                break;
                            case 6:
                                Activity activity4 = getActivity();
                                Intrinsics.checkNotNull(activity4);
                                this.mSwitches.add(new VolumnSwitchShortcut(activity4, getMVoiceComponent()));
                                break;
                            case 7:
                                Context contextRequireContext12 = requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext12, "requireContext(...)");
                                FlySwitchShortcut flySwitchShortcut2 = new FlySwitchShortcut(contextRequireContext12);
                                this.flySwitchShortcut = flySwitchShortcut2;
                                ArrayList<SwitchShortcut> arrayList10 = this.mSwitches;
                                Intrinsics.checkNotNull(flySwitchShortcut2);
                                arrayList10.add(flySwitchShortcut2);
                                break;
                            case 8:
                                Context contextRequireContext13 = requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext13, "requireContext(...)");
                                this.mSwitches.add(new SettingsSwitchShortcut(contextRequireContext13, getLauncherRepository()));
                                break;
                            case CharacterSets.ISO_8859_6 /* 9 */:
                                Context contextRequireContext14 = requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext14, "requireContext(...)");
                                this.mSwitches.add(new PowerSaveSwitchShortcut(contextRequireContext14));
                                break;
                            case CharacterSets.ISO_8859_7 /* 10 */:
                                Context contextRequireContext15 = requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext15, "requireContext(...)");
                                this.mSwitches.add(new PowerSwitchShortcut(contextRequireContext15));
                                break;
                            case CharacterSets.ISO_8859_8 /* 11 */:
                                Context contextRequireContext16 = requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext16, "requireContext(...)");
                                this.mSwitches.add(new MulTaskSwitchShortcut(contextRequireContext16));
                                break;
                            case CharacterSets.ISO_8859_9 /* 12 */:
                                Context contextRequireContext17 = requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext17, "requireContext(...)");
                                this.mSwitches.add(new AccelerateSwitchShortcut(contextRequireContext17));
                                break;
                        }
                    }
                }
            }
        }
        View viewFindViewById = view.findViewById(R.id.top_switch_list);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        setRecyclerView((RecyclerView) viewFindViewById);
        getRecyclerView().setLayoutManager(new GridLayoutManager(requireContext(), 3, 1, false));
        BaseQuickAdapter topRoundFragment$onViewCreated$mAdapter$1 = new TopRoundFragment$onViewCreated$mAdapter$1(this, R.layout.switch_item_new_shortcut, this.mSwitches);
        getRecyclerView().setAdapter((RecyclerView.Adapter) topRoundFragment$onViewCreated$mAdapter$1);
        View viewInflate = View.inflate(requireContext(), R.layout.item_bottom_statusbar, null);
        Intrinsics.checkNotNull(viewInflate);
        BaseQuickAdapter.addFooterView$default(topRoundFragment$onViewCreated$mAdapter$1, viewInflate, 0, 0, 6, (Object) null);
        initFootView(viewInflate);
        initConfig();
        initReceiver();
        scrollBottom();
        scrollerStatusListen();
    }

    public final void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        Intrinsics.checkNotNullParameter(onScrollChangeListener, "onScrollChangeListener");
        this.onScrollChangeListener = onScrollChangeListener;
    }

    public final void scrollerStatusListen() {
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        getRecyclerView().addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.dw.launcher.ui.fragment.top.TopRoundFragment.scrollerStatusListen.1
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
            }

            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 0) {
                    intRef2.element = recyclerView.computeVerticalScrollOffset();
                    int i = intRef2.element;
                    int i2 = intRef.element;
                    if (!recyclerView.canScrollVertically(1)) {
                        OnScrollChangeListener onScrollChangeListener = this.onScrollChangeListener;
                        if (onScrollChangeListener != null) {
                            onScrollChangeListener.onScrollChange(true);
                        }
                    } else {
                        OnScrollChangeListener onScrollChangeListener2 = this.onScrollChangeListener;
                        if (onScrollChangeListener2 != null) {
                            onScrollChangeListener2.onScrollChange(false);
                        }
                    }
                    intRef.element = 0;
                } else if (newState == 1) {
                    intRef.element = recyclerView.computeVerticalScrollOffset();
                }
                Timber.INSTANCE.d("状态：" + newState, new Object[0]);
            }
        });
    }

    public final void initConfig() {
        boolean zIsEnable = getWifiComponent().isEnable();
        ImageView imageView = this.mTopWifiView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopWifiView");
            imageView = null;
        }
        if (imageView != null) {
            imageView.setSelected(zIsEnable);
        }
        onWifiStateChanged();
        onBluetoothStateChanged(getBluetoothComponent().isEnable());
        tryRegisterImsListener();
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("phone") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        setMTelephonyManager((TelephonyManager) systemService);
        getMTelephonyManager().listen(this.mListener, 64);
        getBluetoothComponent().register(this);
    }

    public final void initFootView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View viewFindViewById = view.findViewById(R.id.top_wifi);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mTopWifiView = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.top_bluetooth);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mTopBluetoothView = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.top_volte);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.mTopVolteView = (TextView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.top_signal);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.mSignalClusterLayout = (SignalClusterLayout) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.top_network);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.mTopNetworkView = (TextView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.top_data);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.mTopDataView = (ImageView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.top_airplane);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.mTopAirPlane = (ImageView) viewFindViewById7;
        TextView textView = this.mTopNetworkView;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopNetworkView");
            textView = null;
        }
        textView.setVisibility(0);
        ImageView imageView2 = this.mTopWifiView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopWifiView");
            imageView2 = null;
        }
        imageView2.setVisibility(0);
        ImageView imageView3 = this.mTopBluetoothView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopBluetoothView");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        TextView textView2 = this.mTopVolteView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopVolteView");
            textView2 = null;
        }
        textView2.setVisibility(0);
        ImageView imageView4 = this.mTopDataView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopDataView");
        } else {
            imageView = imageView4;
        }
        imageView.setVisibility(0);
        wifi(view);
        bluetooth(view);
        sence(view);
        gprs(view);
    }

    public final void switchToTop() {
        refresh();
        onBluetoothStateChanged(getBluetoothComponent().isEnable());
    }

    public final void scrollBottom() {
        RecyclerView.Adapter adapter = getRecyclerView().getAdapter();
        Integer numValueOf = adapter != null ? Integer.valueOf(adapter.getItemCount()) : null;
        Intrinsics.checkNotNull(numValueOf);
        getRecyclerView().scrollToPosition(numValueOf.intValue() - 1);
    }

    public final void initReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.dw.wifi.change");
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        Context context = getContext();
        if (context != null) {
            context.registerReceiver(this.receiver, intentFilter);
        }
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.android.ims.IMS_SERVICE_UP");
        intentFilter2.addAction("com.android.ims.IMS_SERVICE_DOWN");
        Context context2 = getContext();
        Intrinsics.checkNotNull(context2);
        context2.registerReceiver(this.mImsIntentReceiver, intentFilter2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void tryRegisterImsListener() {
        try {
            if (this.mIsRegImsChange) {
                IImsServiceEx iImsServiceEx = ImsManagerEx.getIImsServiceEx();
                this.mIImsServiceEx = iImsServiceEx;
                if (iImsServiceEx != null) {
                    try {
                        if (!this.mIsImsListenerRegistered) {
                            this.mIsImsListenerRegistered = true;
                            Intrinsics.checkNotNull(iImsServiceEx);
                            iImsServiceEx.registerforImsRegisterStateChanged(this.mImsUtListenerExBinder);
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0074  */
    public void onBluetoothStateChanged(boolean enable) {
        Drawable drawable;
        ImageView imageView = null;
        if (getBluetoothComponent().isEnable()) {
            ImageView imageView2 = this.mTopBluetoothView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopBluetoothView");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            BluetoothSwitchShortcut bluetoothSwitchShortcut = this.bluetoothSwitchShortcut;
            if (bluetoothSwitchShortcut != null) {
                bluetoothSwitchShortcut.notifyDataChanged(getBluetoothComponent().isEnable());
            }
            Timber.INSTANCE.d("onBluetoothStateChanged: " + enable + "  配对状态： " + getBluetoothComponent().isConnected(), new Object[0]);
            if (getBluetoothComponent().isConnected()) {
                Context context = getContext();
                if (context != null) {
                    drawable = context.getDrawable(R.drawable.icon_bluetooth_contected);
                } else {
                    drawable = null;
                }
            } else {
                Context context2 = getContext();
                if (context2 != null) {
                    drawable = context2.getDrawable(R.drawable.icon_bluetooth);
                } else {
                    drawable = null;
                }
            }
            ImageView imageView3 = this.mTopBluetoothView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopBluetoothView");
            } else {
                imageView = imageView3;
            }
            imageView.setImageDrawable(drawable);
            return;
        }
        ImageView imageView4 = this.mTopBluetoothView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopBluetoothView");
        } else {
            imageView = imageView4;
        }
        imageView.setVisibility(8);
        BluetoothSwitchShortcut bluetoothSwitchShortcut2 = this.bluetoothSwitchShortcut;
        if (bluetoothSwitchShortcut2 != null) {
            bluetoothSwitchShortcut2.notifyDataChanged(false);
        }
    }

    public final int getIMS_FEATURE_TYPE_DEFAULT() {
        return this.IMS_FEATURE_TYPE_DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshVolteIndicators(final boolean show) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.dw.launcher.ui.fragment.top.TopRoundFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    TopRoundFragment.refreshVolteIndicators$lambda$4(show, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshVolteIndicators$lambda$4(boolean z, TopRoundFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = null;
        if (z && NetworkUtil.isLteNetwork(this$0.requireContext())) {
            Timber.INSTANCE.d(" threadName: %s", Thread.currentThread().getName());
            TextView textView2 = this$0.mTopVolteView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopVolteView");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this$0.mTopVolteView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopVolteView");
            } else {
                textView = textView3;
            }
            textView.setText("HD");
            return;
        }
        TextView textView4 = this$0.mTopVolteView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopVolteView");
        } else {
            textView = textView4;
        }
        textView.setVisibility(8);
    }
}
