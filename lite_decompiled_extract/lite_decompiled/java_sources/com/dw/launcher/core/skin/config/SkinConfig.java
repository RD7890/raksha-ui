package com.dw.launcher.core.skin.config;

import android.content.Context;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.core.skin.PreferencesUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SkinConfig.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0004H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006R\u0014\u0010\u0016\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006R\u0014\u0010\u0018\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006R\u0014\u0010\u001a\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u0010\u0010\u001c\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/dw/launcher/core/skin/config/SkinConfig;", BuildConfig.FLAVOR, "()V", "ATTR_SKIN_ENABLE", BuildConfig.FLAVOR, "getATTR_SKIN_ENABLE", "()Ljava/lang/String;", "DEFAULT_SKIN", "FROM_EXTERNAL", BuildConfig.FLAVOR, "getFROM_EXTERNAL", "()I", "FROM_INTERNAL", "getFROM_INTERNAL", "NAMESPACE", "getNAMESPACE", "PLUGIN_SAVE_PATH", "getPLUGIN_SAVE_PATH", "setPLUGIN_SAVE_PATH", "(Ljava/lang/String;)V", "PREF_CUSTOM_SKIN_PATH", "getPREF_CUSTOM_SKIN_PATH", "SKIN_FOLDER_NAME", "getSKIN_FOLDER_NAME", "SKIN_FROM", "getSKIN_FROM", "SKIN_SUFFIX", "getSKIN_SUFFIX", "THEME_DIR", "WALLPAPER_DIR", "getCustomSkinPath", "context", "Landroid/content/Context;", "isDefaultSkin", BuildConfig.FLAVOR, "saveSkinPath", BuildConfig.FLAVOR, "path", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SkinConfig {
    private static final int FROM_INTERNAL = 0;
    public static final SkinConfig INSTANCE = new SkinConfig();
    private static final String NAMESPACE = "http://schemas.android.com/android/skin";
    private static final String SKIN_SUFFIX = ".theme";
    private static final String SKIN_FOLDER_NAME = "skin";
    private static final String PREF_CUSTOM_SKIN_PATH = "skin_theme";
    public static final String DEFAULT_SKIN = "skin_theme_default";
    private static final String SKIN_FROM = "skin_theme_from";
    private static final int FROM_EXTERNAL = 1;
    private static final String ATTR_SKIN_ENABLE = "enable";
    private static String PLUGIN_SAVE_PATH = "/system/dw_config/theme/1.apk";
    public static final String THEME_DIR = "/system/dw_config/theme";
    public static final String WALLPAPER_DIR = "/system/dw_config/wallpaper";

    private SkinConfig() {
    }

    public final String getNAMESPACE() {
        return NAMESPACE;
    }

    public final String getSKIN_SUFFIX() {
        return SKIN_SUFFIX;
    }

    public final String getSKIN_FOLDER_NAME() {
        return SKIN_FOLDER_NAME;
    }

    public final String getPREF_CUSTOM_SKIN_PATH() {
        return PREF_CUSTOM_SKIN_PATH;
    }

    public final String getSKIN_FROM() {
        return SKIN_FROM;
    }

    public final int getFROM_INTERNAL() {
        return FROM_INTERNAL;
    }

    public final int getFROM_EXTERNAL() {
        return FROM_EXTERNAL;
    }

    public final String getATTR_SKIN_ENABLE() {
        return ATTR_SKIN_ENABLE;
    }

    public final String getPLUGIN_SAVE_PATH() {
        return PLUGIN_SAVE_PATH;
    }

    public final void setPLUGIN_SAVE_PATH(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        PLUGIN_SAVE_PATH = str;
    }

    @JvmStatic
    public static final String getCustomSkinPath(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = PreferencesUtils.getString(context, PREF_CUSTOM_SKIN_PATH, PLUGIN_SAVE_PATH);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @JvmStatic
    public static final void saveSkinPath(Context context, String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        PreferencesUtils.putString(context, PREF_CUSTOM_SKIN_PATH, path);
    }

    @JvmStatic
    public static final boolean isDefaultSkin(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Intrinsics.areEqual(DEFAULT_SKIN, getCustomSkinPath(context));
    }
}
