package com.dw.launcher.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import com.dw.framework.PowerManagerHelper;
import com.google.android.mms.pdu.CharacterSets;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\bJ$\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u001b"}, d2 = {"Lcom/dw/launcher/util/SystemUtils;", "", "()V", "getLanguage", "", "context", "Landroid/content/Context;", "isActivityAvailable", "", "packageName", "className", "isAppInstalled", "isLowPowerMode", "isNetAvailable", "isSensorAvailable", "sensorType", "", "isUltraSavingMode", "isVibrate", "isVolteAvailable", "queryResolveInfoByActivity", "Landroid/content/pm/ResolveInfo;", "setVibrate", "", "vibrate", "shutdown", "useSystemStatusBar", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class SystemUtils {
    public static final SystemUtils INSTANCE = new SystemUtils();

    private SystemUtils() {
    }

    public final void shutdown(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            PowerManager powerManager = (PowerManager) systemService;
            powerManager.getClass().getDeclaredMethod("shutdown", Boolean.TYPE, String.class, Boolean.TYPE).invoke(powerManager, false, "userrequested", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setVibrate(Context context, boolean vibrate) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService;
        if (vibrate) {
            audioManager.setVibrateSetting(1, 1);
        } else {
            audioManager.setVibrateSetting(1, 0);
        }
    }

    public final boolean isVibrate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        return ((AudioManager) systemService).shouldVibrate(1);
    }

    public final boolean isVolteAvailable() {
        try {
            Object objInvoke = Class.forName("com.android.ims.internal.ImsManagerEx").getMethod("isDualLteModem", new Class[0]).invoke(null, new Object[0]);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final String getLanguage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Locale locale = context.getResources().getConfiguration().locale;
        Intrinsics.checkNotNullExpressionValue(locale, "locale");
        String language = locale.getLanguage();
        Intrinsics.checkNotNull(language);
        return language;
    }

    public final boolean isUltraSavingMode() {
        return PowerManagerHelper.isUltraSavingMode();
    }

    public final boolean isAppInstalled(String packageName, Context context) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            context.getPackageManager().getPackageInfo(packageName, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final boolean isSensorAvailable(Context context, int sensorType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("sensor");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        return ((SensorManager) systemService).getDefaultSensor(sensorType) != null;
    }

    public final int useSystemStatusBar(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z = android.os.SystemProperties.getBoolean("persist.sys.dw.hide.statusbar", false);
        boolean z2 = android.os.SystemProperties.getBoolean("persist.sys.statusbar_pulldown", true);
        int i = !z ? 1 : 0;
        return i == 1 ? z2 ? 1 : 0 : i;
    }

    public final boolean isLowPowerMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isPowerSaveMode();
    }

    public final boolean isActivityAvailable(Context context, String packageName, String className) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(className, "className");
        Intent intent = new Intent();
        intent.setClassName(packageName, className);
        return context.getPackageManager().resolveActivity(intent, DwUtils.DISABLE_EXPAND) != null;
    }

    public final boolean isNetAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    public final ResolveInfo queryResolveInfoByActivity(Context context, String packageName, String className) {
        Intrinsics.checkNotNullParameter(context, "context");
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        Intrinsics.checkNotNull(packageName);
        Intrinsics.checkNotNull(className);
        intent.setClassName(packageName, className);
        return packageManager.resolveActivity(intent, DwUtils.DISABLE_EXPAND);
    }
}
