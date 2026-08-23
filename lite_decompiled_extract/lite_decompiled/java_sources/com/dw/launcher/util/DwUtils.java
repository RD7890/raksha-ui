package com.dw.launcher.util;

import android.content.Context;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class DwUtils {
    public static final int DISABLE_EXPAND = 65536;
    public static final int DISABLE_NONE = 0;

    public static void updateStatusBar(Context context, int type) {
        try {
            try {
                Class.forName("android.app.StatusBarManager").getMethod("disable", Integer.TYPE).invoke(context.getSystemService("statusbar"), Integer.valueOf(type));
            } catch (Exception unused) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
