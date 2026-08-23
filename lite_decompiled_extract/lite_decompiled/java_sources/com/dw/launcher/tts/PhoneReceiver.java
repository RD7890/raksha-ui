package com.dw.launcher.tts;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.telephony.TelephonyManager;
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

/* JADX INFO: compiled from: PhoneReceiver.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/dw/launcher/tts/PhoneReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "lastClickTime", BuildConfig.FLAVOR, "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setLauncherRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "onReceive", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class PhoneReceiver extends Hilt_PhoneReceiver {
    private static final long MIN_CLICK_INTERVAL = 1000;
    public static final String PHONE_STATE_ACTION = "android.intent.action.PHONE_STATE";
    private long lastClickTime;

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

    @Override // com.dw.launcher.tts.Hilt_PhoneReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        String str;
        super.onReceive(context, intent);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(intent.getAction(), PHONE_STATE_ACTION)) {
            LaunchConfig launchConfigLoadConfig = getLauncherRepository().loadConfig();
            if ((launchConfigLoadConfig == null || launchConfigLoadConfig.getUse_auto_tts_service() != 0) && (stringExtra = intent.getStringExtra("state")) != null) {
                if (StringsKt.equals(stringExtra, TelephonyManager.EXTRA_STATE_RINGING, true)) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - this.lastClickTime < MIN_CLICK_INTERVAL) {
                        return;
                    }
                    this.lastClickTime = jCurrentTimeMillis;
                    String stringExtra2 = intent.getStringExtra("incoming_number");
                    String str2 = stringExtra2;
                    if (str2 == null || str2.length() == 0) {
                        return;
                    }
                    String strFindContactNameByNumber = ContactUtil.findContactNameByNumber(context, stringExtra2);
                    if (strFindContactNameByNumber == null) {
                        strFindContactNameByNumber = BuildConfig.FLAVOR;
                    }
                    boolean z = Settings.System.getInt(context.getContentResolver(), "voice_incoming", 1) == 1;
                    TtsSpeakManager ttsManager = LauncherApplication.INSTANCE.getTtsManager();
                    if (ttsManager != null) {
                        if (!z) {
                            ttsManager = null;
                        }
                        if (ttsManager != null) {
                            if (!StringsKt.isBlank(strFindContactNameByNumber)) {
                                str = strFindContactNameByNumber + context.getString(R.string.incoming);
                            } else {
                                str = stringExtra2 + context.getString(R.string.incoming);
                            }
                            ttsManager.setTts(str);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (StringsKt.equals(stringExtra, TelephonyManager.EXTRA_STATE_OFFHOOK, true)) {
                    return;
                }
                StringsKt.equals(stringExtra, TelephonyManager.EXTRA_STATE_IDLE, true);
            }
        }
    }
}
