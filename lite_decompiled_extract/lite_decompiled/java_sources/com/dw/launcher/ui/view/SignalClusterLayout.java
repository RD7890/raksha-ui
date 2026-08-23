package com.dw.launcher.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.dw.launcher.R;
import com.dw.launcher.data.component.PhoneStatusComponent;
import com.dw.launcher.util.SystemUtils;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SignalClusterLayout.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010\u001f\u001a\u00020\u001cJ\b\u0010 \u001a\u00020\u001cH\u0014J\b\u0010!\u001a\u00020\u001cH\u0014J\b\u0010\"\u001a\u00020\u001cH\u0014J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\nH\u0016J\b\u0010%\u001a\u00020\u001cH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/dw/launcher/ui/view/SignalClusterLayout;", "Landroid/widget/LinearLayout;", "Lcom/dw/launcher/data/component/PhoneStatusComponent$OnPhoneStatusChangedListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isZh", "", "operatorNameMap", "", "", "phoneStatusComponent", "Lcom/dw/launcher/data/component/PhoneStatusComponent;", "getPhoneStatusComponent", "()Lcom/dw/launcher/data/component/PhoneStatusComponent;", "setPhoneStatusComponent", "(Lcom/dw/launcher/data/component/PhoneStatusComponent;)V", "signalClusterLabel", "Lcom/dw/launcher/ui/view/MarqueeTextView;", "getSignalClusterLabel", "label", "hasSim", "", "hideSingalView", "isAirPlane", "noSim", "onAttachedToWindow", "onDetachedFromWindow", "onFinishInflate", "onSignalStrengthChanged", "batteryLevel", "showSignalClusterLabel", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class SignalClusterLayout extends Hilt_SignalClusterLayout implements PhoneStatusComponent.OnPhoneStatusChangedListener {
    private final boolean isZh;
    private final Map<String, String> operatorNameMap;

    @Inject
    public PhoneStatusComponent phoneStatusComponent;
    private MarqueeTextView signalClusterLabel;

    public void onDataActivity(int i) {
        PhoneStatusComponent.OnPhoneStatusChangedListener.DefaultImpls.onDataActivity(this, i);
    }

    public void onSimStateChanged() {
        PhoneStatusComponent.OnPhoneStatusChangedListener.DefaultImpls.onSimStateChanged(this);
    }

    public void onVolteRegisterStateChanged(boolean z) {
        PhoneStatusComponent.OnPhoneStatusChangedListener.DefaultImpls.onVolteRegisterStateChanged(this, z);
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

    public SignalClusterLayout(Context context) {
        super(context);
        this.operatorNameMap = MapsKt.mapOf(TuplesKt.to("China Mobile", "中国移动"), TuplesKt.to("China Unicom", "中国联通"), TuplesKt.to("CHN-UNICOM", "中国联通"), TuplesKt.to("UNICOM", "中国联通"), TuplesKt.to("CMCC", "中国移动"), TuplesKt.to("CUCC", "中国联通"), TuplesKt.to("FarEasTone", "远传电信"), TuplesKt.to("Chunghwa Telecom", "中华电信"), TuplesKt.to("Taiwan Mobile", "台湾大哥大"), TuplesKt.to("T Star", "台湾之星"), TuplesKt.to("China Telecom", "中国电信"), TuplesKt.to("Mi Mobile", "小米移动"));
        SystemUtils systemUtils = SystemUtils.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.isZh = StringsKt.contains$default((CharSequence) systemUtils.getLanguage(context2), (CharSequence) "zh", false, 2, (Object) null);
    }

    public SignalClusterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.operatorNameMap = MapsKt.mapOf(TuplesKt.to("China Mobile", "中国移动"), TuplesKt.to("China Unicom", "中国联通"), TuplesKt.to("CHN-UNICOM", "中国联通"), TuplesKt.to("UNICOM", "中国联通"), TuplesKt.to("CMCC", "中国移动"), TuplesKt.to("CUCC", "中国联通"), TuplesKt.to("FarEasTone", "远传电信"), TuplesKt.to("Chunghwa Telecom", "中华电信"), TuplesKt.to("Taiwan Mobile", "台湾大哥大"), TuplesKt.to("T Star", "台湾之星"), TuplesKt.to("China Telecom", "中国电信"), TuplesKt.to("Mi Mobile", "小米移动"));
        SystemUtils systemUtils = SystemUtils.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.isZh = StringsKt.contains$default((CharSequence) systemUtils.getLanguage(context2), (CharSequence) "zh", false, 2, (Object) null);
    }

    public SignalClusterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.operatorNameMap = MapsKt.mapOf(TuplesKt.to("China Mobile", "中国移动"), TuplesKt.to("China Unicom", "中国联通"), TuplesKt.to("CHN-UNICOM", "中国联通"), TuplesKt.to("UNICOM", "中国联通"), TuplesKt.to("CMCC", "中国移动"), TuplesKt.to("CUCC", "中国联通"), TuplesKt.to("FarEasTone", "远传电信"), TuplesKt.to("Chunghwa Telecom", "中华电信"), TuplesKt.to("Taiwan Mobile", "台湾大哥大"), TuplesKt.to("T Star", "台湾之星"), TuplesKt.to("China Telecom", "中国电信"), TuplesKt.to("Mi Mobile", "小米移动"));
        SystemUtils systemUtils = SystemUtils.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.isZh = StringsKt.contains$default((CharSequence) systemUtils.getLanguage(context2), (CharSequence) "zh", false, 2, (Object) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getPhoneStatusComponent().addListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getPhoneStatusComponent().removeListener(this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.signalClusterLabel = (MarqueeTextView) View.inflate(getContext(), R.layout.layout_signal_cluster, this).findViewById(R.id.signal_cluster_label);
        showSignalClusterLabel();
    }

    public void onSignalStrengthChanged(int batteryLevel) {
        showSignalClusterLabel();
    }

    public final void noSim() {
        Log.i("lkang", "noSim");
        MarqueeTextView marqueeTextView = this.signalClusterLabel;
        if (marqueeTextView == null) {
            return;
        }
        marqueeTextView.setText(getContext().getString(R.string.no_sim));
    }

    public final void hasSim() {
        Log.i("lkang", "hasSim");
        showSignalClusterLabel();
    }

    private final void showSignalClusterLabel() {
        String signalClusterLabel;
        MarqueeTextView marqueeTextView;
        String carrierLabel = getPhoneStatusComponent().getCarrierLabel();
        if (carrierLabel == null || (signalClusterLabel = getSignalClusterLabel(carrierLabel)) == null) {
            return;
        }
        MarqueeTextView marqueeTextView2 = this.signalClusterLabel;
        if (Intrinsics.areEqual(String.valueOf(marqueeTextView2 != null ? marqueeTextView2.getText() : null), signalClusterLabel) || (marqueeTextView = this.signalClusterLabel) == null) {
            return;
        }
        marqueeTextView.setText(signalClusterLabel);
    }

    private final String getSignalClusterLabel(String label) {
        return this.isZh ? getPhoneStatusComponent().getProvidersName() : label;
    }

    public final void hideSingalView(boolean isAirPlane) {
        if (isAirPlane) {
            MarqueeTextView marqueeTextView = this.signalClusterLabel;
            if (marqueeTextView != null) {
                marqueeTextView.setVisibility(8);
            }
        } else {
            MarqueeTextView marqueeTextView2 = this.signalClusterLabel;
            if (marqueeTextView2 != null) {
                marqueeTextView2.setVisibility(0);
            }
        }
        invalidate();
    }
}
