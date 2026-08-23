package com.dw.launcher.tts;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.LauncherApplication;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.repository.LauncherRepository;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UsbReceiver.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/dw/launcher/tts/UsbReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setLauncherRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "onReceive", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class UsbReceiver extends Hilt_UsbReceiver {

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

    @Override // com.dw.launcher.tts.Hilt_UsbReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LaunchConfig launchConfigLoadConfig;
        TtsSpeakManager ttsManager;
        TtsSpeakManager ttsManager2;
        super.onReceive(context, intent);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        boolean z = Settings.System.getInt(context.getContentResolver(), "voice_usb", 1) == 1;
        LaunchConfig launchConfigLoadConfig2 = getLauncherRepository().loadConfig();
        if (launchConfigLoadConfig2 == null || launchConfigLoadConfig2.getUse_auto_tts_service() != 0) {
            if (Intrinsics.areEqual(action, "android.intent.action.ACTION_POWER_CONNECTED")) {
                Log.i("UsbReceiver", "Power connected (charging)");
                if (!z || (ttsManager2 = LauncherApplication.INSTANCE.getTtsManager()) == null) {
                    return;
                }
                ttsManager2.setTts(context.getString(R.string.usb_charger));
                return;
            }
            if (Intrinsics.areEqual(action, "android.intent.action.ACTION_POWER_DISCONNECTED")) {
                Log.i("UsbReceiver", "Power disconnected (not charging)");
                if (!z || (launchConfigLoadConfig = getLauncherRepository().loadConfig()) == null || launchConfigLoadConfig.getUse_auto_tts_service() != 1 || (ttsManager = LauncherApplication.INSTANCE.getTtsManager()) == null) {
                    return;
                }
                ttsManager.setTts(context.getString(R.string.usb_not_charger));
            }
        }
    }
}
