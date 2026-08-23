package com.dw.launcher.ui.fragment.clock;

import android.content.Context;
import com.dw.launcher.data.component.LocaleComponent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.ClockRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class ClockViewModel_Factory implements Factory<ClockViewModel> {
    private final Provider<Context> contextProvider;
    private final Provider<LocaleComponent> localeComponentProvider;
    private final Provider<LauncherPreference> preferenceProvider;
    private final Provider<ClockRepository> repositoryProvider;

    public ClockViewModel_Factory(Provider<ClockRepository> repositoryProvider, Provider<LauncherPreference> preferenceProvider, Provider<Context> contextProvider, Provider<LocaleComponent> localeComponentProvider) {
        this.repositoryProvider = repositoryProvider;
        this.preferenceProvider = preferenceProvider;
        this.contextProvider = contextProvider;
        this.localeComponentProvider = localeComponentProvider;
    }

    @Override // javax.inject.Provider
    public ClockViewModel get() {
        return newInstance(this.repositoryProvider.get(), this.preferenceProvider.get(), this.contextProvider.get(), this.localeComponentProvider.get());
    }

    public static ClockViewModel_Factory create(Provider<ClockRepository> repositoryProvider, Provider<LauncherPreference> preferenceProvider, Provider<Context> contextProvider, Provider<LocaleComponent> localeComponentProvider) {
        return new ClockViewModel_Factory(repositoryProvider, preferenceProvider, contextProvider, localeComponentProvider);
    }

    public static ClockViewModel newInstance(ClockRepository repository, LauncherPreference preference, Context context, LocaleComponent localeComponent) {
        return new ClockViewModel(repository, preference, context, localeComponent);
    }
}
