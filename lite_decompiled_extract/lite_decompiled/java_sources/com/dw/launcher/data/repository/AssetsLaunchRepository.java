package com.dw.launcher.data.repository;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.core.skin.config.SkinConfig;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.config.DashboardConfig;
import com.dw.launcher.data.config.LauncherConfig;
import com.dw.launcher.data.entity.AppItem;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.preference.SharedPreferencesUtils;
import com.dw.launcher.util.AppCardConfig;
import com.dw.launcher.util.SystemUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: AssetsLaunchRepository.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/dw/launcher/data/repository/AssetsLaunchRepository;", "Lcom/dw/launcher/data/repository/LauncherRepository;", "context", "Landroid/content/Context;", "preference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "sharedPreferencesUtils", "Lcom/dw/launcher/data/preference/SharedPreferencesUtils;", "(Landroid/content/Context;Lcom/dw/launcher/data/preference/LauncherPreference;Lcom/dw/launcher/data/preference/SharedPreferencesUtils;)V", "config", "Lcom/dw/launcher/data/entity/LaunchConfig;", "getPreference", "()Lcom/dw/launcher/data/preference/LauncherPreference;", "getSharedPreferencesUtils", "()Lcom/dw/launcher/data/preference/SharedPreferencesUtils;", "loadConfig", "parseDefaultConfig", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AssetsLaunchRepository implements LauncherRepository {
    private LaunchConfig config;
    private final Context context;
    private final LauncherPreference preference;
    private final SharedPreferencesUtils sharedPreferencesUtils;

    @Inject
    public AssetsLaunchRepository(Context context, LauncherPreference launcherPreference, SharedPreferencesUtils sharedPreferencesUtils) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(launcherPreference, "preference");
        Intrinsics.checkNotNullParameter(sharedPreferencesUtils, "sharedPreferencesUtils");
        this.context = context;
        this.preference = launcherPreference;
        this.sharedPreferencesUtils = sharedPreferencesUtils;
    }

    public final LauncherPreference getPreference() {
        return this.preference;
    }

    public final SharedPreferencesUtils getSharedPreferencesUtils() {
        return this.sharedPreferencesUtils;
    }

    @Override // com.dw.launcher.data.repository.LauncherRepository
    public LaunchConfig loadConfig() {
        LaunchConfig launchConfig = this.config;
        if (launchConfig != null || launchConfig != null) {
            return launchConfig;
        }
        this.config = (LaunchConfig) new GsonBuilder().create().fromJson(new InputStreamReader(new FileInputStream(new File(Environment.getRootDirectory().getPath() + "/dw_config/launcher.cfg"))), LaunchConfig.class);
        parseDefaultConfig();
        return this.config;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void parseDefaultConfig() {
        List<LaunchConfig.ThemeCardInfo> themeCardInfoList;
        File[] fileArrListFiles;
        LaunchConfig launchConfig = this.config;
        if (launchConfig != null) {
            launchConfig.setSupport_heart(SystemUtils.INSTANCE.isSensorAvailable(this.context, 65599) ? 1 : 0);
            launchConfig.setSupport_compass(SystemUtils.INSTANCE.isSensorAvailable(this.context, 2) ? 1 : 0);
            launchConfig.setHidedDialLock(!SystemUtils.INSTANCE.isSensorAvailable(this.context, 65597) ? 1 : 0);
            launchConfig.setSystemBar(SystemUtils.INSTANCE.useSystemStatusBar(this.context));
            if (Settings.System.getInt(this.context.getContentResolver(), NoDisturbComponent.DOWN_MENU_MODE, 0) == 1) {
                launchConfig.setSystemBar(1);
            }
            LaunchConfig launchConfig2 = this.config;
            String default_clock_id = launchConfig2 != null ? launchConfig2.getDefault_clock_id() : null;
            Intrinsics.checkNotNull(default_clock_id);
            if (TextUtils.isDigitsOnly(default_clock_id)) {
                LauncherConfig.INSTANCE.setDEFAULT_CLOCK(default_clock_id);
            }
            DashboardConfig.INSTANCE.setSTYLE_DEFAULT(launchConfig.getDefaultStyle());
            if (this.preference.firstLoadWallpaper() && (fileArrListFiles = new File(SkinConfig.WALLPAPER_DIR).listFiles()) != null) {
                if ((fileArrListFiles.length == 0) ^ true) {
                    File file = fileArrListFiles[0];
                    LauncherPreference launcherPreference = this.preference;
                    String absolutePath = file.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                    launcherPreference.setWallpaper(absolutePath);
                    this.preference.setFirstLoadWallpaper(false);
                    Timber.Forest.d("文件路径：" + file.getAbsolutePath(), new Object[0]);
                }
            }
            Boolean appSelectedItem = this.sharedPreferencesUtils.getAppSelectedItem();
            Intrinsics.checkNotNull(appSelectedItem);
            if (appSelectedItem.booleanValue()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            LaunchConfig launchConfig3 = this.config;
            if (launchConfig3 != null && (themeCardInfoList = launchConfig3.getThemeCardInfoList()) != null) {
                for (LaunchConfig.ThemeCardInfo themeCardInfo : themeCardInfoList) {
                    if (AppCardConfig.INSTANCE.haveLocalApp(this.context, themeCardInfo.getId())) {
                        arrayList.add(new AppItem(themeCardInfo.getId(), true, themeCardInfo.getName()));
                    }
                }
            }
            SharedPreferencesUtils sharedPreferencesUtils = this.sharedPreferencesUtils;
            String json = new Gson().toJson(arrayList);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            sharedPreferencesUtils.setAppItemListConfig(json);
            this.sharedPreferencesUtils.setAppSelectedItem(true);
        }
    }
}
