package com.dw.launcher.data.config;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.SystemProperties;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: AppFilterConfig.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/dw/launcher/data/config/AppFilterConfig;", BuildConfig.FLAVOR, "()V", "map", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getValue", BuildConfig.FLAVOR, "key", "defaultValue", BuildConfig.FLAVOR, "isFiltered", "packageNameOrClassName", "isHandleFiltered", "isIntentAvailable", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppFilterConfig {
    public static final AppFilterConfig INSTANCE = new AppFilterConfig();
    private static final Set<String> map = SetsKt.setOf(new String[]{"com.dw.launcher.Launcher", "com.watch.weather.activity.CHWeatherActivity", "com.android.dialer.app.DialtactsActivity"});

    private AppFilterConfig() {
    }

    public final boolean isFiltered(String packageNameOrClassName) {
        Intrinsics.checkNotNullParameter(packageNameOrClassName, "packageNameOrClassName");
        if (Intrinsics.areEqual(SystemProperties.get("persist.sys.dw.oldmode", "false"), "true") && isHandleFiltered(packageNameOrClassName)) {
            return true;
        }
        if (!map.contains(packageNameOrClassName)) {
            return false;
        }
        Timber.Forest.d("packageNameOrClassName: " + packageNameOrClassName + "  在map中 被过滤掉了", new Object[0]);
        return true;
    }

    public final boolean isHandleFiltered(String packageNameOrClassName) {
        Intrinsics.checkNotNullParameter(packageNameOrClassName, "packageNameOrClassName");
        Timber.Forest.d("packageNameOrClassName: " + packageNameOrClassName, new Object[0]);
        return Intrinsics.areEqual("com.android.contacts.activities.PeopleActivity", packageNameOrClassName) && Intrinsics.areEqual(SystemProperties.get("persist.sys.dw.server", "false"), "true");
    }

    private final boolean getValue(String key, int defaultValue) {
        return SystemProperties.getInt(key, defaultValue) == 1;
    }

    public final boolean isIntentAvailable(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        return !listQueryIntentActivities.isEmpty();
    }
}
