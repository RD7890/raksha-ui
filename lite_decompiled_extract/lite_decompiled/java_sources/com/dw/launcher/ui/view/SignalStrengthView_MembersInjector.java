package com.dw.launcher.ui.view;

import com.dw.launcher.data.component.PhoneStatusComponent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class SignalStrengthView_MembersInjector implements MembersInjector<SignalStrengthView> {
    private final Provider<PhoneStatusComponent> phoneStatusComponentProvider;

    public SignalStrengthView_MembersInjector(Provider<PhoneStatusComponent> phoneStatusComponentProvider) {
        this.phoneStatusComponentProvider = phoneStatusComponentProvider;
    }

    public static MembersInjector<SignalStrengthView> create(Provider<PhoneStatusComponent> phoneStatusComponentProvider) {
        return new SignalStrengthView_MembersInjector(phoneStatusComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SignalStrengthView instance) {
        injectPhoneStatusComponent(instance, this.phoneStatusComponentProvider.get());
    }

    public static void injectPhoneStatusComponent(SignalStrengthView instance, PhoneStatusComponent phoneStatusComponent) {
        instance.phoneStatusComponent = phoneStatusComponent;
    }
}
