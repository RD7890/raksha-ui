package com.dw.launcher.data.component;

import android.content.Context;
import com.dw.launcher.data.repository.IShortcutRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class PackageManagerComponent_Factory implements Factory<PackageManagerComponent> {
    private final Provider<Context> contextProvider;
    private final Provider<IShortcutRepository> repositoryProvider;

    public PackageManagerComponent_Factory(Provider<Context> contextProvider, Provider<IShortcutRepository> repositoryProvider) {
        this.contextProvider = contextProvider;
        this.repositoryProvider = repositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public PackageManagerComponent m209get() {
        return newInstance((Context) this.contextProvider.get(), (IShortcutRepository) this.repositoryProvider.get());
    }

    public static PackageManagerComponent_Factory create(Provider<Context> contextProvider, Provider<IShortcutRepository> repositoryProvider) {
        return new PackageManagerComponent_Factory(contextProvider, repositoryProvider);
    }

    public static PackageManagerComponent newInstance(Context context, IShortcutRepository repository) {
        return new PackageManagerComponent(context, repository);
    }
}
