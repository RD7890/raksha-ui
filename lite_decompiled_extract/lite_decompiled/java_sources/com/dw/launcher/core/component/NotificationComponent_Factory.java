package com.dw.launcher.core.component;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class NotificationComponent_Factory implements Factory<NotificationComponent> {
    private final Provider<Context> contextProvider;

    public NotificationComponent_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NotificationComponent m190get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static NotificationComponent_Factory create(Provider<Context> contextProvider) {
        return new NotificationComponent_Factory(contextProvider);
    }

    public static NotificationComponent newInstance(Context context) {
        return new NotificationComponent(context);
    }
}
