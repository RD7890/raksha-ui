package com.dw.launcher.hilt.provider;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UtilProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/dw/launcher/hilt/provider/UtilProvider;", BuildConfig.FLAVOR, "()V", "provideExecutor", "Ljava/util/concurrent/Executor;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Module
public final class UtilProvider {
    @Provides
    @Singleton
    public final Executor provideExecutor() {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewCachedThreadPool, "newCachedThreadPool(...)");
        return executorServiceNewCachedThreadPool;
    }
}
