package com.dw.launcher.data.preference;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedPreferencesUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u0004\u0018\u00010\nJ\r\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0012J\b\u0010\u0013\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nJ\u0016\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\fJ\u0016\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0012J\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\nJ\u0016\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\fJ\u000e\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0012J\u000e\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/dw/launcher/data/preference/SharedPreferencesUtils;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "clear", BuildConfig.FLAVOR, "getAppItemListConfig", BuildConfig.FLAVOR, "getAppSelectedItem", BuildConfig.FLAVOR, "()Ljava/lang/Boolean;", "getBoolean", "key", "defaultValue", "getInt", BuildConfig.FLAVOR, "getMenuSlideList", "getSleepEndTime", "getSleepStartTime", "getString", "remove", "saveBoolean", "value", "saveInt", "saveMenuSlideList", "list", "saveString", "setAppItemListConfig", "config", "setAppSelectedItem", "id", "setSleepEndTime", "time", "setSleepStartTime", "Companion", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SharedPreferencesUtils {
    private static final String APP_Have_Set_ITEM = "APP_SELECTED_ITEM";
    private static final String APP_ITEM_LIST_CONFIG = "APP_ITEM_LIST_CONFIG";
    private static final String BREATHE_DURATION = "BREATHE_DURATION";
    private static final String BREATHE_FREQ = "BREATHE_FREQ";
    private static final String BREATHE_STRENGTH = "BREATHE_STRENGTH";
    private static final String MENU_SLIDE_LIST = "MENU_SLIDE_LIST";
    private static final String SLEEP_END_TIME = "SLEEP_END_TIME";
    private static final String SLEEP_START_TIME = "SLEEP_START_TIME";
    private final SharedPreferences sharedPreferences;

    @Inject
    public SharedPreferencesUtils(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_config_sp", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
    }

    public final void saveString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(key, value);
        editorEdit.apply();
    }

    public final String getString(String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String string = this.sharedPreferences.getString(key, defaultValue);
        return string == null ? defaultValue : string;
    }

    public final void saveInt(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putInt(key, value);
        editorEdit.apply();
    }

    public final int getInt(String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPreferences.getInt(key, defaultValue);
    }

    public final void saveBoolean(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(key, value);
        editorEdit.apply();
    }

    public final boolean getBoolean(String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPreferences.getBoolean(key, defaultValue);
    }

    public final void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(key);
        editorEdit.apply();
    }

    public final void clear() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    public final void setSleepEndTime(int time) {
        this.sharedPreferences.edit().putInt(SLEEP_END_TIME, time).apply();
    }

    public final int getSleepEndTime() {
        return this.sharedPreferences.getInt(SLEEP_END_TIME, TypedValues.CycleType.TYPE_EASING);
    }

    public final void setSleepStartTime(int time) {
        this.sharedPreferences.edit().putInt(SLEEP_START_TIME, time).apply();
    }

    public final int getSleepStartTime() {
        return this.sharedPreferences.getInt(SLEEP_START_TIME, 1320);
    }

    public final void setAppSelectedItem(boolean id) {
        this.sharedPreferences.edit().putBoolean(APP_Have_Set_ITEM, id).apply();
    }

    public final Boolean getAppSelectedItem() {
        return Boolean.valueOf(this.sharedPreferences.getBoolean(APP_Have_Set_ITEM, false));
    }

    public final void setAppItemListConfig(String config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.sharedPreferences.edit().putString(APP_ITEM_LIST_CONFIG, config).apply();
    }

    public final String getAppItemListConfig() {
        return this.sharedPreferences.getString(APP_ITEM_LIST_CONFIG, BuildConfig.FLAVOR);
    }

    public final void saveMenuSlideList(String list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.sharedPreferences.edit().putString(MENU_SLIDE_LIST, list).apply();
    }

    public final String getMenuSlideList() {
        return this.sharedPreferences.getString(MENU_SLIDE_LIST, null);
    }
}
