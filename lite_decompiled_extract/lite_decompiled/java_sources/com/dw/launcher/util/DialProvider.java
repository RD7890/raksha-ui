package com.dw.launcher.util;

import android.provider.Settings;
import com.android.launcher3.util.StepManager;
import com.dw.launcher.LauncherApplication;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class DialProvider {
    public static int signalValue = -1;

    public static int getSignalValue() {
        return signalValue;
    }

    public static void setSignalValue(int value) {
        signalValue = value;
    }

    public String getWatchImagePath() {
        return "";
    }

    public Integer getStepCount() {
        return Integer.valueOf(StepManager.INSTANCE.getStep(LauncherApplication.Companion.getInstance()));
    }

    public Integer getMeterCount() {
        int step = StepManager.INSTANCE.getStep(LauncherApplication.Companion.getInstance());
        if (step > 0) {
            return Integer.valueOf((int) (Utils.makeKm(step, 140, 63.0f) * 1000.0f));
        }
        return 0;
    }

    public Integer getHeartCount() {
        return Integer.valueOf(Settings.Global.getInt(LauncherApplication.Companion.getInstance().getContentResolver(), "last_heart_value", 0));
    }

    public Integer getKCalorieCount() {
        int step = StepManager.INSTANCE.getStep(LauncherApplication.Companion.getInstance());
        if (step > 0) {
            return Integer.valueOf((int) Utils.makeKcal(Utils.makeKm(step, 140, 63.0f), 33.0f));
        }
        return 0;
    }
}
