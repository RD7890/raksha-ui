package com.dw.launcher.ui.fragment.dashboard;

import com.dw.launcher.data.preference.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class CardContainerFragment_MembersInjector implements MembersInjector<CardContainerFragment> {
    private final Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider;

    public CardContainerFragment_MembersInjector(Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider) {
        this.sharedPreferencesUtilsProvider = sharedPreferencesUtilsProvider;
    }

    public static MembersInjector<CardContainerFragment> create(Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider) {
        return new CardContainerFragment_MembersInjector(sharedPreferencesUtilsProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(CardContainerFragment instance) {
        injectSharedPreferencesUtils(instance, this.sharedPreferencesUtilsProvider.get());
    }

    public static void injectSharedPreferencesUtils(CardContainerFragment instance, SharedPreferencesUtils sharedPreferencesUtils) {
        instance.sharedPreferencesUtils = sharedPreferencesUtils;
    }
}
