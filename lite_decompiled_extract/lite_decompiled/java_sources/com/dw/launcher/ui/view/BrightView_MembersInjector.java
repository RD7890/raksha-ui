package com.dw.launcher.ui.view;

import com.dw.launcher.data.component.BrightComponent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class BrightView_MembersInjector implements MembersInjector<BrightView> {
    private final Provider<BrightComponent> mBrightComponentProvider;

    public BrightView_MembersInjector(Provider<BrightComponent> mBrightComponentProvider) {
        this.mBrightComponentProvider = mBrightComponentProvider;
    }

    public static MembersInjector<BrightView> create(Provider<BrightComponent> mBrightComponentProvider) {
        return new BrightView_MembersInjector(mBrightComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BrightView instance) {
        injectMBrightComponent(instance, this.mBrightComponentProvider.get());
    }

    public static void injectMBrightComponent(BrightView instance, BrightComponent mBrightComponent) {
        instance.mBrightComponent = mBrightComponent;
    }
}
