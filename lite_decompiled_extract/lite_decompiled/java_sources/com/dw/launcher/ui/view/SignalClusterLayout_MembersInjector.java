package com.dw.launcher.ui.view;

import com.dw.launcher.data.component.PhoneStatusComponent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class SignalClusterLayout_MembersInjector implements MembersInjector<SignalClusterLayout> {
    private final Provider<PhoneStatusComponent> phoneStatusComponentProvider;

    public SignalClusterLayout_MembersInjector(Provider<PhoneStatusComponent> phoneStatusComponentProvider) {
        this.phoneStatusComponentProvider = phoneStatusComponentProvider;
    }

    public static MembersInjector<SignalClusterLayout> create(Provider<PhoneStatusComponent> phoneStatusComponentProvider) {
        return new SignalClusterLayout_MembersInjector(phoneStatusComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SignalClusterLayout instance) {
        injectPhoneStatusComponent(instance, this.phoneStatusComponentProvider.get());
    }

    public static void injectPhoneStatusComponent(SignalClusterLayout instance, PhoneStatusComponent phoneStatusComponent) {
        instance.phoneStatusComponent = phoneStatusComponent;
    }
}
