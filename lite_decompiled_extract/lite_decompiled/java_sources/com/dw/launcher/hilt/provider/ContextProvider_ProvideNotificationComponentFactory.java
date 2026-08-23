package com.dw.launcher.hilt.provider;

import android.content.Context;
import com.dw.launcher.core.component.NotificationComponent;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ContextProvider_ProvideNotificationComponentFactory implements Factory<NotificationComponent> {
    private final Provider<Context> contextProvider;
    private final ContextProvider module;

    public ContextProvider_ProvideNotificationComponentFactory(ContextProvider module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NotificationComponent m232get() {
        return provideNotificationComponent(this.module, (Context) this.contextProvider.get());
    }

    public static ContextProvider_ProvideNotificationComponentFactory create(ContextProvider module, Provider<Context> contextProvider) {
        return new ContextProvider_ProvideNotificationComponentFactory(module, contextProvider);
    }

    public static NotificationComponent provideNotificationComponent(ContextProvider instance, Context context) {
        return (NotificationComponent) Preconditions.checkNotNullFromProvides(instance.provideNotificationComponent(context));
    }
}
