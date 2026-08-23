package com.dw.launcher.core.receiver;

import com.dw.launcher.data.component.PhoneStatusComponent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class SimCardBroadcastReceiver_MembersInjector implements MembersInjector<SimCardBroadcastReceiver> {
    private final Provider<PhoneStatusComponent> phoneStatusComponentProvider;

    public SimCardBroadcastReceiver_MembersInjector(Provider<PhoneStatusComponent> phoneStatusComponentProvider) {
        this.phoneStatusComponentProvider = phoneStatusComponentProvider;
    }

    public static MembersInjector<SimCardBroadcastReceiver> create(Provider<PhoneStatusComponent> phoneStatusComponentProvider) {
        return new SimCardBroadcastReceiver_MembersInjector(phoneStatusComponentProvider);
    }

    public void injectMembers(SimCardBroadcastReceiver instance) {
        injectPhoneStatusComponent(instance, (PhoneStatusComponent) this.phoneStatusComponentProvider.get());
    }

    public static void injectPhoneStatusComponent(SimCardBroadcastReceiver instance, PhoneStatusComponent phoneStatusComponent) {
        instance.phoneStatusComponent = phoneStatusComponent;
    }
}
