package com.dw.framework;

import android.os.IPowerManagerEx;
import android.os.ServiceManager;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public class PowerManagerHelper {
    public static IPowerManagerEx getIPowerManagerEx() {
        return IPowerManagerEx.Stub.asInterface(ServiceManager.getService("power_ex"));
    }

    public static boolean isUltraSavingMode() {
        try {
            IPowerManagerEx iPowerManagerExAsInterface = IPowerManagerEx.Stub.asInterface(ServiceManager.getService("power_ex"));
            return iPowerManagerExAsInterface != null && 4 == iPowerManagerExAsInterface.getPowerSaveMode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void setPowerSavingMode() {
        try {
            IPowerManagerEx iPowerManagerExAsInterface = IPowerManagerEx.Stub.asInterface(ServiceManager.getService("power_ex"));
            if (iPowerManagerExAsInterface != null) {
                iPowerManagerExAsInterface.setPowerSaveMode(4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
