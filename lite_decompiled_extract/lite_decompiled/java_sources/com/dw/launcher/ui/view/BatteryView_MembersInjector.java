package com.dw.launcher.ui.view;

import com.dw.launcher.core.component.DeviceStateComponent;
import com.dw.launcher.data.component.BatteryComponent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class BatteryView_MembersInjector implements MembersInjector<BatteryView> {
    private final Provider<BatteryComponent> mBatteryComponentProvider;
    private final Provider<DeviceStateComponent> mDeviceStateComponentProvider;

    public BatteryView_MembersInjector(Provider<BatteryComponent> mBatteryComponentProvider, Provider<DeviceStateComponent> mDeviceStateComponentProvider) {
        this.mBatteryComponentProvider = mBatteryComponentProvider;
        this.mDeviceStateComponentProvider = mDeviceStateComponentProvider;
    }

    public static MembersInjector<BatteryView> create(Provider<BatteryComponent> mBatteryComponentProvider, Provider<DeviceStateComponent> mDeviceStateComponentProvider) {
        return new BatteryView_MembersInjector(mBatteryComponentProvider, mDeviceStateComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BatteryView instance) {
        injectMBatteryComponent(instance, this.mBatteryComponentProvider.get());
        injectMDeviceStateComponent(instance, this.mDeviceStateComponentProvider.get());
    }

    public static void injectMBatteryComponent(BatteryView instance, BatteryComponent mBatteryComponent) {
        instance.mBatteryComponent = mBatteryComponent;
    }

    public static void injectMDeviceStateComponent(BatteryView instance, DeviceStateComponent mDeviceStateComponent) {
        instance.mDeviceStateComponent = mDeviceStateComponent;
    }
}
