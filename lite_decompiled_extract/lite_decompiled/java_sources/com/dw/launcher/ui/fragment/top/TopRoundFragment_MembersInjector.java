package com.dw.launcher.ui.fragment.top;

import com.dw.launcher.core.component.VoiceComponent;
import com.dw.launcher.data.component.BluetoothComponent;
import com.dw.launcher.data.component.BrightComponent;
import com.dw.launcher.data.component.WifiComponent;
import com.dw.launcher.data.repository.LauncherRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class TopRoundFragment_MembersInjector implements MembersInjector<TopRoundFragment> {
    private final Provider<BluetoothComponent> bluetoothComponentProvider;
    private final Provider<LauncherRepository> launcherRepositoryProvider;
    private final Provider<BrightComponent> mBrightComponentProvider;
    private final Provider<VoiceComponent> mVoiceComponentProvider;
    private final Provider<WifiComponent> mWifiComponentProvider;
    private final Provider<WifiComponent> wifiComponentProvider;

    public TopRoundFragment_MembersInjector(Provider<WifiComponent> wifiComponentProvider, Provider<BluetoothComponent> bluetoothComponentProvider, Provider<BrightComponent> mBrightComponentProvider, Provider<WifiComponent> mWifiComponentProvider, Provider<LauncherRepository> launcherRepositoryProvider, Provider<VoiceComponent> mVoiceComponentProvider) {
        this.wifiComponentProvider = wifiComponentProvider;
        this.bluetoothComponentProvider = bluetoothComponentProvider;
        this.mBrightComponentProvider = mBrightComponentProvider;
        this.mWifiComponentProvider = mWifiComponentProvider;
        this.launcherRepositoryProvider = launcherRepositoryProvider;
        this.mVoiceComponentProvider = mVoiceComponentProvider;
    }

    public static MembersInjector<TopRoundFragment> create(Provider<WifiComponent> wifiComponentProvider, Provider<BluetoothComponent> bluetoothComponentProvider, Provider<BrightComponent> mBrightComponentProvider, Provider<WifiComponent> mWifiComponentProvider, Provider<LauncherRepository> launcherRepositoryProvider, Provider<VoiceComponent> mVoiceComponentProvider) {
        return new TopRoundFragment_MembersInjector(wifiComponentProvider, bluetoothComponentProvider, mBrightComponentProvider, mWifiComponentProvider, launcherRepositoryProvider, mVoiceComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(TopRoundFragment instance) {
        injectWifiComponent(instance, this.wifiComponentProvider.get());
        injectBluetoothComponent(instance, this.bluetoothComponentProvider.get());
        injectMBrightComponent(instance, this.mBrightComponentProvider.get());
        injectMWifiComponent(instance, this.mWifiComponentProvider.get());
        injectLauncherRepository(instance, this.launcherRepositoryProvider.get());
        injectMVoiceComponent(instance, this.mVoiceComponentProvider.get());
    }

    public static void injectWifiComponent(TopRoundFragment instance, WifiComponent wifiComponent) {
        instance.wifiComponent = wifiComponent;
    }

    public static void injectBluetoothComponent(TopRoundFragment instance, BluetoothComponent bluetoothComponent) {
        instance.bluetoothComponent = bluetoothComponent;
    }

    public static void injectMBrightComponent(TopRoundFragment instance, BrightComponent mBrightComponent) {
        instance.mBrightComponent = mBrightComponent;
    }

    public static void injectMWifiComponent(TopRoundFragment instance, WifiComponent mWifiComponent) {
        instance.mWifiComponent = mWifiComponent;
    }

    public static void injectLauncherRepository(TopRoundFragment instance, LauncherRepository launcherRepository) {
        instance.launcherRepository = launcherRepository;
    }

    public static void injectMVoiceComponent(TopRoundFragment instance, VoiceComponent mVoiceComponent) {
        instance.mVoiceComponent = mVoiceComponent;
    }
}
