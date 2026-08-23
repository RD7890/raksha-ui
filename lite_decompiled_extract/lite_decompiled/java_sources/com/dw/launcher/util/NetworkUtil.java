package com.dw.launcher.util;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.mms.pdu.CharacterSets;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class NetworkUtil {
    public static boolean isNetAvailable(final Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    public static boolean isWifi(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    public static boolean isMobile(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    public static boolean hasSimCard(Context context) {
        int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
        return (simState == 0 || simState == 1) ? false : true;
    }

    public static String getNetTypeString(int networkType) {
        String str;
        if (networkType != 20) {
            switch (networkType) {
                case 1:
                case 2:
                case 4:
                case 7:
                case CharacterSets.ISO_8859_8 /* 11 */:
                    str = "2G";
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case CharacterSets.ISO_8859_6 /* 9 */:
                case CharacterSets.ISO_8859_7 /* 10 */:
                case CharacterSets.ISO_8859_9 /* 12 */:
                case 14:
                case 15:
                    str = "3G";
                    break;
                case 13:
                    str = "4G";
                    break;
                default:
                    str = "G";
                    break;
            }
        } else {
            str = "5G";
        }
        Log.i("lkang", "strNetworkType = ".concat(str));
        return str;
    }

    public static String getCurNetType(Context context) {
        return getNetTypeString(((TelephonyManager) context.getSystemService("phone")).getNetworkType());
    }

    public static boolean isCurNetMode2G(Context context) {
        return "2G".equals(getCurNetType(context));
    }

    public static boolean isLteNetwork(Context context) {
        Log.d("trj", "CurNetType:" + getCurNetType(context));
        return "4G".equals(getCurNetType(context));
    }

    public static boolean getMobileDataEnabled(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "mobile_data", 0) == 1;
    }

    public static boolean getAirplaneModeEnabled(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1;
    }

    public static boolean setMobileDataEnabled(Context context, boolean enabled) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                telephonyManager.setDataEnabledForReason(0, enabled);
                context.sendBroadcast(new Intent("com.dw.wifi.change"));
                return true;
            }
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod("getITelephony", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(telephonyManager, new Object[0]);
            objInvoke.getClass().getMethod((enabled ? "enable" : "disable") + "DataConnectivity", new Class[0]).invoke(objInvoke, new Object[0]);
            return true;
        } catch (Exception e) {
            Log.e("lkang", "cannot fake telephony", e);
            return false;
        }
    }
}
