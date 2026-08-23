package com.dw.launcher.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class ServerUtil {
    public static int HEART_TYPE = 1;
    private static final String YM_BLOOD_ACTION = "com.dwiot.healthy.blood.action.result";
    private static final String YM_HEART_ACTION = "com.dwiot.healthy.action.result";
    private static final String YM_Oxygen_ACTION = "com.dwiot.healthy.oxygen.action.result";
    private static final String ZY_Blood_ACTION = "com.dw.zyhealth.ACTION_BLOOD_PRESSURE";
    private static final String ZY_HEART_ACTION = "com.dw.zyhealth.ACTION_HEART_RATE";
    private static final String ZY_OXYGEN_ACTION = "com.dw.zyhealth.ACTION_BLOOD_OXYGEN";
    private static final boolean YM_SERVER = getSystemProperty("persist.sys.dw.server", "false").equals("true");
    private static final boolean ZY_SERVER = getSystemProperty("persist.sys.zy.server", "false").equals("true");

    public static void reportHeartServer(Context context, String heartValue) {
        StringBuilder sbAppend = new StringBuilder("reportServer-->heartValue:").append(heartValue).append(" YM_SERVER: ");
        boolean z = YM_SERVER;
        StringBuilder sbAppend2 = sbAppend.append(z).append(" ZY_SERVER: ");
        boolean z2 = ZY_SERVER;
        Log.d("ServerUtil", sbAppend2.append(z2).toString());
        if (z) {
            Intent intent = new Intent(YM_HEART_ACTION);
            intent.setPackage("com.watch.iotnet");
            intent.putExtra("heart", heartValue);
            context.sendBroadcast(intent);
            return;
        }
        if (z2) {
            Intent intent2 = new Intent(ZY_HEART_ACTION);
            intent2.setPackage("com.dw.dwdatatrans");
            intent2.putExtra("heart_rate", Integer.valueOf(heartValue));
            context.sendBroadcast(intent2);
        }
    }

    public static void reportOxygenServer(Context context, String spo2hValue) {
        Log.d("ServerUtil", "reportServer-->spo2hValue:" + spo2hValue);
        if (YM_SERVER) {
            Intent intent = new Intent(YM_Oxygen_ACTION);
            intent.setPackage("com.watch.iotnet");
            intent.putExtra("oxygen", spo2hValue);
            context.sendBroadcast(intent);
            return;
        }
        if (ZY_SERVER) {
            Intent intent2 = new Intent(ZY_OXYGEN_ACTION);
            intent2.setPackage("com.dw.dwdatatrans");
            intent2.putExtra("oxygen_level", Integer.parseInt(spo2hValue));
            context.sendBroadcast(intent2);
        }
    }

    public static void reportBloodPressureServer(Context context, String sysBloodPress, String diaBloodPress) {
        if (YM_SERVER) {
            Intent intent = new Intent(YM_BLOOD_ACTION);
            intent.setPackage("com.watch.iotnet");
            intent.putExtra("blood_up", sysBloodPress);
            intent.putExtra("blood_down", diaBloodPress);
            context.sendBroadcast(intent);
            return;
        }
        if (ZY_SERVER) {
            Intent intent2 = new Intent(ZY_Blood_ACTION);
            intent2.setPackage("com.dw.dwdatatrans");
            intent2.putExtra("systolic", Integer.valueOf(sysBloodPress));
            intent2.putExtra("diastolic", Integer.valueOf(diaBloodPress));
            context.sendBroadcast(intent2);
        }
    }

    public static String getSystemProperty(String property, String defaultValue) {
        try {
            String str = (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, property);
            return !TextUtils.isEmpty(str) ? str : defaultValue;
        } catch (Exception unused) {
            Log.d("SystemPropertiesHelper", "Unable to read system properties");
        }
    }
}
