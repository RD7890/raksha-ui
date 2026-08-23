package com.dw.launcher.data.entity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.R;
import com.dw.launcher.data.config.PackageNameConstant;
import com.dw.launcher.util.AppLock;
import com.dw.launcher.util.AuthRequest;
import com.dw.launcher.util.SystemUtils;
import com.dw.launcher.util.VibrationUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

/* JADX INFO: compiled from: Shortcut.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u0004\u0018\u00010\u0015J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&J\u000e\u0010)\u001a\u00020*2\u0006\u0010%\u001a\u00020&J\u000e\u0010+\u001a\u00020*2\u0006\u0010%\u001a\u00020&J\b\u0010,\u001a\u00020\u0003H\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006-"}, d2 = {"Lcom/dw/launcher/data/entity/Shortcut;", BuildConfig.FLAVOR, "packageName", BuildConfig.FLAVOR, "resolveInfo", "Landroid/content/pm/ResolveInfo;", "(Ljava/lang/String;Landroid/content/pm/ResolveInfo;)V", "CLICK_THRESHOLD", BuildConfig.FLAVOR, "getCLICK_THRESHOLD", "()I", "customIcon", "Landroid/graphics/drawable/Drawable;", "getCustomIcon", "()Landroid/graphics/drawable/Drawable;", "setCustomIcon", "(Landroid/graphics/drawable/Drawable;)V", "icon", "getIcon", "setIcon", "label", BuildConfig.FLAVOR, "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "lastClickTime", BuildConfig.FLAVOR, "getLastClickTime", "()J", "setLastClickTime", "(J)V", "getPackageName", "()Ljava/lang/String;", "getResolveInfo", "()Landroid/content/pm/ResolveInfo;", "getLauncherIcon", "context", "Landroid/content/Context;", "getName", "load", "onClicked", BuildConfig.FLAVOR, "onLongClicked", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Shortcut {
    private final int CLICK_THRESHOLD;
    private Drawable customIcon;
    private Drawable icon;
    private CharSequence label;
    private long lastClickTime;
    private final String packageName;
    private final ResolveInfo resolveInfo;

    public Shortcut(String str, ResolveInfo resolveInfo) {
        Intrinsics.checkNotNullParameter(str, "packageName");
        this.packageName = str;
        this.resolveInfo = resolveInfo;
        this.CLICK_THRESHOLD = 500;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final ResolveInfo getResolveInfo() {
        return this.resolveInfo;
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final void setLabel(CharSequence charSequence) {
        this.label = charSequence;
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public final Drawable getCustomIcon() {
        return this.customIcon;
    }

    public final void setCustomIcon(Drawable drawable) {
        this.customIcon = drawable;
    }

    public final CharSequence getName() {
        return this.label;
    }

    public final Drawable getLauncherIcon(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = this.customIcon;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = this.icon;
        if (drawable2 != null) {
            return drawable2;
        }
        Drawable drawable3 = context.getDrawable(R.drawable.shortcut_default_icon);
        Intrinsics.checkNotNull(drawable3);
        return drawable3;
    }

    public final Shortcut load(Context context) {
        ActivityInfo activityInfo;
        ActivityInfo activityInfo2;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            PackageManager packageManager = context.getPackageManager();
            ResolveInfo resolveInfo = this.resolveInfo;
            this.label = resolveInfo != null ? resolveInfo.loadLabel(packageManager) : null;
            ResolveInfo resolveInfo2 = this.resolveInfo;
            this.icon = resolveInfo2 != null ? resolveInfo2.loadIcon(packageManager) : null;
            ResolveInfo resolveInfo3 = this.resolveInfo;
            if (resolveInfo3 != null && (activityInfo2 = resolveInfo3.activityInfo) != null) {
                String str = activityInfo2.packageName;
            }
            ResolveInfo resolveInfo4 = this.resolveInfo;
            String str2 = (resolveInfo4 == null || (activityInfo = resolveInfo4.activityInfo) == null) ? null : activityInfo.name;
            Log.i("loadShortcut", "label:{" + ((Object) this.label) + "}     actName:{" + str2 + '}');
            if (StringsKt.contains$default(SystemUtils.INSTANCE.getLanguage(context), "en", false, 2, (Object) null) && Intrinsics.areEqual(str2, "com.android.messaging.ui.conversationlist.ConversationListActivity")) {
                this.label = "Messages";
            }
            if (Intrinsics.areEqual("com.watch.iotchat.activity.MainActivity", str2) && Intrinsics.areEqual("WeChat", this.label)) {
                this.label = "Chats";
            }
        } catch (Exception unused) {
            this.label = BuildConfig.FLAVOR;
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.shortcut_default_icon);
            Intrinsics.checkNotNull(drawable);
            this.icon = drawable;
        }
        return this;
    }

    public final long getLastClickTime() {
        return this.lastClickTime;
    }

    public final void setLastClickTime(long j) {
        this.lastClickTime = j;
    }

    public final int getCLICK_THRESHOLD() {
        return this.CLICK_THRESHOLD;
    }

    public final void onClicked(Context context) {
        Unit unit;
        Unit unit2;
        List<ResolveInfo> listQueryIntentActivities;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Log.i("lkang", "onClicked");
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis - this.lastClickTime < this.CLICK_THRESHOLD) {
            return;
        }
        this.lastClickTime = jUptimeMillis;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(this.packageName);
        if (Intrinsics.areEqual(PackageNameConstant.PACKAGE_NAME_WECHAT, this.packageName)) {
            String string = Settings.Global.getString(context.getContentResolver(), "ilink_device_id");
            String string2 = Settings.Global.getString(context.getContentResolver(), "ilink_device_signature");
            String str2 = string;
            if (str2 == null || str2.length() == 0 || (str = string2) == null || str.length() == 0) {
                if (!SystemUtils.INSTANCE.isNetAvailable(context)) {
                    Toast.makeText(context, context.getString(R.string.connectNetAuthor), 0).show();
                    return;
                } else {
                    new AuthRequest().showAuthorDialog(context);
                    return;
                }
            }
        }
        ResolveInfo resolveInfo = this.resolveInfo;
        if (resolveInfo != null) {
            intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
            if (!AppLock.isInterceptApplicationStartup(context, intent.getComponent())) {
                unit = Unit.INSTANCE;
            } else {
                Timber.Forest.d("当前线程" + Thread.currentThread().getName(), new Object[0]);
                Toast.makeText(context, context.getString(R.string.app_manager_disabled), 0).show();
                return;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0)) == null) {
                unit2 = null;
            } else {
                Intrinsics.checkNotNull(listQueryIntentActivities);
                if (listQueryIntentActivities.size() <= 0) {
                    return;
                }
                ResolveInfo resolveInfo2 = listQueryIntentActivities.get(0);
                intent.setComponent(new ComponentName(resolveInfo2.activityInfo.packageName, resolveInfo2.activityInfo.name));
                unit2 = Unit.INSTANCE;
            }
            if (unit2 == null) {
                return;
            }
        }
        ComponentName component = intent.getComponent();
        if (!Intrinsics.areEqual(component != null ? component.getPackageName() : null, context.getPackageName())) {
            intent.addFlags(270532608);
        }
        try {
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public final void onLongClicked(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Context contextCreatePackageContext = context.createPackageContext(this.packageName, 0);
            if (Build.VERSION.SDK_INT >= 25) {
                Object systemService = context.getSystemService("launcherapps");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.pm.LauncherApps");
                if (((LauncherApps) systemService).hasShortcutHostPermission()) {
                    ArrayList arrayList = new ArrayList();
                    ShortcutManager shortcutManager = (ShortcutManager) contextCreatePackageContext.getSystemService(ShortcutManager.class);
                    List<ShortcutInfo> dynamicShortcuts = shortcutManager != null ? shortcutManager.getDynamicShortcuts() : null;
                    if (dynamicShortcuts != null) {
                        arrayList.addAll(dynamicShortcuts);
                    }
                    List<ShortcutInfo> manifestShortcuts = shortcutManager != null ? shortcutManager.getManifestShortcuts() : null;
                    if (manifestShortcuts != null) {
                        arrayList.addAll(manifestShortcuts);
                    }
                    List<ShortcutInfo> pinnedShortcuts = shortcutManager != null ? shortcutManager.getPinnedShortcuts() : null;
                    if (pinnedShortcuts != null) {
                        arrayList.addAll(pinnedShortcuts);
                    }
                    if (!arrayList.isEmpty()) {
                        Intent intent = new Intent(com.dw.launcher.Launcher.ACTION_SHOW_SHORTCUT_DIALOG);
                        intent.putExtra("pkg", this.packageName);
                        context.sendBroadcast(intent);
                        VibrationUtil.vibrate$default(VibrationUtil.INSTANCE, context, 20L, 0, 4, (Object) null);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "Shortcut(packageName='" + this.packageName + "', label=" + ((Object) this.label) + ')';
    }
}
