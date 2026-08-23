package com.dw.launcher.util;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.dw.launcher.data.config.APPLockConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class AppLock {
    public static final Uri APP_LOCK_URI = Uri.parse("content://com.watch.appmanager/applock");
    public static final String TAG = "AppLock";
    private Properties prop;

    private static int readAppLockDisableList(Context context, String packageName, String className) {
        String str;
        String[] strArr;
        ContentResolver contentResolver = context.getContentResolver();
        int i = 1;
        String[] strArr2 = {"pac", "cls", "value"};
        Log.d(TAG, "readAppLockDisableList:");
        if (className != null && ("com.dw.launcher".equals(packageName) || "com.watch.iotnet".equals(packageName) || "com.watch.iotchat".equals(packageName) || "com.android.dialer".equals(packageName) || "com.android.gallery3d".equals(packageName))) {
            str = "pac=? and cls=?";
            strArr = new String[]{packageName, className};
        } else {
            str = "pac=?";
            strArr = new String[]{packageName};
        }
        try {
            Cursor cursorQuery = contentResolver.query(APP_LOCK_URI, strArr2, str, strArr, null);
            if (cursorQuery != null) {
                Log.d(TAG, "count:" + cursorQuery);
                if (cursorQuery.moveToNext()) {
                    int columnIndex = cursorQuery.getColumnIndex("pac");
                    int columnIndex2 = cursorQuery.getColumnIndex("cls");
                    int columnIndex3 = cursorQuery.getColumnIndex("value");
                    String string = cursorQuery.getString(columnIndex);
                    String string2 = cursorQuery.getString(columnIndex2);
                    int i2 = cursorQuery.getInt(columnIndex3);
                    Log.d(TAG, "packageName:" + string + ",className:" + string2 + ",value" + i2);
                    i = i2;
                }
                cursorQuery.close();
            }
        } catch (Exception unused) {
        }
        return i;
    }

    public static boolean isInterceptApplicationStartup(Context context, ComponentName componentName) {
        if (componentName == null) {
            Log.d(TAG, "componentName is null");
            return false;
        }
        String packageName = componentName.getPackageName();
        String className = componentName.getClassName();
        if (readAppLockDisableList(context, packageName, className) != 0) {
            return false;
        }
        Log.d(TAG, "interceptApp:packageName=" + packageName + ",className=" + className);
        return true;
    }

    public static boolean isForbidPackage(Context context, ComponentName componentName) {
        Cursor cursorQuery = context.getContentResolver().query(APP_LOCK_URI, new String[]{"pac", "cls", "value"}, "pac=? and cls=?", new String[]{componentName.getPackageName(), componentName.getClassName()}, null);
        if (cursorQuery != null) {
            if (cursorQuery.moveToFirst() && cursorQuery.getInt(cursorQuery.getColumnIndex("value")) == 0) {
                return true;
            }
            cursorQuery.close();
        }
        return false;
    }

    public static List<String> getForbidPackageListForUrl(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = context.getContentResolver().query(APP_LOCK_URI, new String[]{"pac", "cls", "value"}, "value=?", new String[]{"0"}, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("cls")));
                }
                cursorQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static boolean isChAppLock(ComponentName componentName) {
        if (componentName == null) {
            return false;
        }
        String str = (String) APPLockConfig.getAPPLockMap().get(componentName);
        Log.d("trj", "isChAppLock-->key:" + str);
        if (TextUtils.isEmpty(str)) {
            str = "AC";
        }
        return InstanceHolder.INSTANCE.isAppLockInternal(str);
    }

    public static List<String> getForbidPackageList(String appLockInfo) {
        String[] strArrSplit;
        Log.i("trj", "getForbidPackageList-->appLockInfo:" + appLockInfo);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(appLockInfo) && (strArrSplit = appLockInfo.split(",")) != null && strArrSplit.length != 0) {
            for (int i = 0; i < strArrSplit.length; i++) {
                if (strArrSplit[i].contains(":")) {
                    String[] strArrSplit2 = strArrSplit[i].split(":");
                    String str = strArrSplit2[0];
                    if (strArrSplit2[1].equals("0") && APPLockConfig.getKeyAPPLockMap().containsKey(str)) {
                        arrayList.add(((ComponentName) APPLockConfig.getKeyAPPLockMap().get(str)).getPackageName());
                    }
                }
            }
        }
        return arrayList;
    }

    public static void updateAppLock(String appLockInfo) {
        InstanceHolder.INSTANCE.updateAppLockInternal(appLockInfo);
    }

    private boolean isAppLockInternal(String key) {
        return Integer.parseInt(this.prop.getProperty(key, "1")) == 0;
    }

    private void updateAppLockInternal(String appLockInfo) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(appLockInfo) || (strArrSplit = appLockInfo.split(",")) == null || strArrSplit.length == 0) {
            return;
        }
        for (int i = 0; i < strArrSplit.length; i++) {
            if (strArrSplit[i].contains(":")) {
                String[] strArrSplit2 = strArrSplit[i].split(":");
                this.prop.setProperty(strArrSplit2[0], strArrSplit2[1]);
            }
        }
    }

    private AppLock() {
        this.prop = new Properties();
    }

    private static class InstanceHolder {
        private static final AppLock INSTANCE = new AppLock();

        private InstanceHolder() {
        }
    }

    private static class AppLockInternal {
        private static volatile AppLockInternal sAppLock;

        private AppLockInternal() {
        }

        private static synchronized AppLockInternal getInstance() {
            if (sAppLock == null) {
                synchronized (AppLockInternal.class) {
                    if (sAppLock == null) {
                        sAppLock = new AppLockInternal();
                    }
                }
            }
            return sAppLock;
        }
    }
}
