package com.dw.launcher.util;

import android.bluetooth.BluetoothAdapter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class BluetoothUtils {
    public static boolean isConnected() {
        try {
            Method declaredMethod = BluetoothAdapter.class.getDeclaredMethod("getConnectionState", null);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(BluetoothAdapter.getDefaultAdapter(), null)).intValue() == 2;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return false;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return false;
        }
    }
}
