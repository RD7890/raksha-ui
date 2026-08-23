package com.dw.launcher.ui.view;

import com.dw.launcher.data.component.WifiComponent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class NetworkView_MembersInjector implements MembersInjector<NetworkView> {
    private final Provider<WifiComponent> wifiComponentProvider;

    public NetworkView_MembersInjector(Provider<WifiComponent> wifiComponentProvider) {
        this.wifiComponentProvider = wifiComponentProvider;
    }

    public static MembersInjector<NetworkView> create(Provider<WifiComponent> wifiComponentProvider) {
        return new NetworkView_MembersInjector(wifiComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(NetworkView instance) {
        injectWifiComponent(instance, this.wifiComponentProvider.get());
    }

    public static void injectWifiComponent(NetworkView instance, WifiComponent wifiComponent) {
        instance.wifiComponent = wifiComponent;
    }
}
