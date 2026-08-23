package com.dw.launcher.tts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.SmsMessage;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.LauncherApplication;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.repository.LauncherRepository;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SmsReceiver.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/dw/launcher/tts/SmsReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setLauncherRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "onReceive", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class SmsReceiver extends Hilt_SmsReceiver {

    @Inject
    public LauncherRepository launcherRepository;

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

    @Override // com.dw.launcher.tts.Hilt_SmsReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        TtsSpeakManager ttsManager;
        String str;
        super.onReceive(context, intent);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(intent.getAction(), "android.provider.Telephony.SMS_RECEIVED")) {
            LaunchConfig launchConfigLoadConfig = getLauncherRepository().loadConfig();
            if (launchConfigLoadConfig == null || launchConfigLoadConfig.getUse_auto_tts_service() != 0) {
                Bundle extras = intent.getExtras();
                Object obj = extras != null ? extras.get("pdus") : null;
                Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                if (objArr == null) {
                    return;
                }
                String str2 = BuildConfig.FLAVOR;
                String displayOriginatingAddress = BuildConfig.FLAVOR;
                for (Object obj2 : objArr) {
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.ByteArray");
                    displayOriginatingAddress = SmsMessage.createFromPdu((byte[]) obj2).getDisplayOriginatingAddress();
                    if (displayOriginatingAddress == null) {
                        displayOriginatingAddress = BuildConfig.FLAVOR;
                    }
                }
                String strFindContactNameByNumber = ContactUtil.findContactNameByNumber(context, displayOriginatingAddress);
                if (strFindContactNameByNumber != null) {
                    str2 = strFindContactNameByNumber;
                }
                if (Settings.System.getInt(context.getContentResolver(), "voice_newmsg", 1) != 1 || (ttsManager = LauncherApplication.INSTANCE.getTtsManager()) == null) {
                    return;
                }
                if (!StringsKt.isBlank(str2)) {
                    str = str2 + context.getString(R.string.new_msg);
                } else {
                    str = displayOriginatingAddress + context.getString(R.string.new_msg);
                }
                ttsManager.setTts(str);
            }
        }
    }
}
