package com.dw.launcher.core.receiver;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.component.PhoneStatusComponent;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: SimCardBroadcastReceiver.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/dw/launcher/core/receiver/SimCardBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "phoneStatusComponent", "Lcom/dw/launcher/data/component/PhoneStatusComponent;", "getPhoneStatusComponent", "()Lcom/dw/launcher/data/component/PhoneStatusComponent;", "setPhoneStatusComponent", "(Lcom/dw/launcher/data/component/PhoneStatusComponent;)V", "onReceive", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class SimCardBroadcastReceiver extends Hilt_SimCardBroadcastReceiver {

    @Inject
    public PhoneStatusComponent phoneStatusComponent;

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

    @Override // com.dw.launcher.core.receiver.Hilt_SimCardBroadcastReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action == null || !Intrinsics.areEqual(action, "android.intent.action.SIM_STATE_CHANGED")) {
            return;
        }
        Object systemService = context.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        int simState = ((TelephonyManager) systemService).getSimState();
        if (simState == 1) {
            Timber.Forest.d("sim卡已取消  SIM_STATE_ABSENT... ", new Object[0]);
            PhoneStatusComponent phoneStatusComponent = getPhoneStatusComponent();
            if (phoneStatusComponent != null) {
                phoneStatusComponent.unRegisterImsService();
                return;
            }
            return;
        }
        if (simState != 5) {
            return;
        }
        Timber.Forest.d("sim卡已插入 SIM_STATE_READY...  ", new Object[0]);
        PhoneStatusComponent phoneStatusComponent2 = getPhoneStatusComponent();
        if (phoneStatusComponent2 != null) {
            phoneStatusComponent2.registerImsService();
        }
    }
}
