package com.dw.launcher.ui.view;

import com.dw.launcher.data.component.BluetoothComponent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class BluetoothView_MembersInjector implements MembersInjector<BluetoothView> {
    private final Provider<BluetoothComponent> bluetoothComponentProvider;

    public BluetoothView_MembersInjector(Provider<BluetoothComponent> bluetoothComponentProvider) {
        this.bluetoothComponentProvider = bluetoothComponentProvider;
    }

    public static MembersInjector<BluetoothView> create(Provider<BluetoothComponent> bluetoothComponentProvider) {
        return new BluetoothView_MembersInjector(bluetoothComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BluetoothView instance) {
        injectBluetoothComponent(instance, this.bluetoothComponentProvider.get());
    }

    public static void injectBluetoothComponent(BluetoothView instance, BluetoothComponent bluetoothComponent) {
        instance.bluetoothComponent = bluetoothComponent;
    }
}
