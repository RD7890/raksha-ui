package com.dw.launcher.data.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.R;
import com.dw.launcher.data.config.DashboardConfig;
import com.dw.launcher.data.config.LauncherConfig;
import com.dw.launcher.data.config.ProviderConfig;
import com.dw.launcher.util.SystemProperties;
import com.dw.launcher.util.WatchFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: LauncherPreferenceImpl.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001a\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\tH\u0016J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\tH\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u000fH\u0016J\b\u0010)\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/dw/launcher/data/preference/LauncherPreferenceImpl;", "Lcom/dw/launcher/data/preference/LauncherPreference;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sp", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "firstLoadWallpaper", BuildConfig.FLAVOR, "firstLoadWatch", "getAssetsClockVersion", BuildConfig.FLAVOR, "getCurrentDialSource", "getCustomWatchPath", BuildConfig.FLAVOR, "id", "getDashboardStyle", "getPreferClock", "getWallpaper", "isClockLocked", "setAssetsClockVersion", BuildConfig.FLAVOR, "version", "setClockLocked", "lock", "setCurrentDialSource", "setCustomWatchPath", "path", "setDashboardStyle", "style", "setFirstLoadWallpaper", "first", "setFirstLoadWatch", "setNextDashboard", "setPreferClock", "setPreviousDashboard", "setShowSlideTask", "show", "setWallpaper", "wallpaper", "showSlideTask", "Companion", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LauncherPreferenceImpl implements LauncherPreference {
    private static final String ASSETS_CLOCK_VERSION = "ASSETS_CLOCK_VERSION";
    private static final String CLOCK_LOCKED = "CLOCK_LOCKED";
    private static final String CLOCK_PREFER = "CLOCK_PREFER";
    private static final String DASHBOARD_STYLE = "DASHBOARD_STYLE";
    private final Context context;
    private final SharedPreferences sp;

    @Inject
    public LauncherPreferenceImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.sp = context.getSharedPreferences("launcher_preference", 0);
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public int getDashboardStyle() {
        return this.sp.getInt(DASHBOARD_STYLE, DashboardConfig.INSTANCE.getSTYLE_DEFAULT());
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public void setDashboardStyle(int style) {
        Log.i("lkang", "setDashboardStyle");
        this.sp.edit().putInt(DASHBOARD_STYLE, style).apply();
        this.context.getContentResolver().notifyChange(ProviderConfig.INSTANCE.getURI_DASHBOARD_STYLE(), null);
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public void setNextDashboard() {
        int dashboardStyle = getDashboardStyle() + 1;
        IntRange range_of_style = DashboardConfig.INSTANCE.getRANGE_OF_STYLE();
        int first = range_of_style.getFirst();
        if (dashboardStyle > range_of_style.getLast() || first > dashboardStyle) {
            dashboardStyle = 0;
        }
        setDashboardStyle(dashboardStyle);
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public void setPreviousDashboard() {
        int dashboardStyle = getDashboardStyle() - 1;
        IntRange range_of_style = DashboardConfig.INSTANCE.getRANGE_OF_STYLE();
        int first = range_of_style.getFirst();
        if (dashboardStyle > range_of_style.getLast() || first > dashboardStyle) {
            dashboardStyle = 11;
        }
        setDashboardStyle(dashboardStyle);
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public boolean isClockLocked() {
        return this.sp.getBoolean(CLOCK_LOCKED, false);
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public void setClockLocked(boolean lock) {
        this.sp.edit().putBoolean(CLOCK_LOCKED, lock).apply();
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public String getPreferClock() {
        String string = this.sp.getString(CLOCK_PREFER, SystemProperties.INSTANCE.getString("ro.diwo.launcher_clock_default", LauncherConfig.INSTANCE.getDEFAULT_CLOCK()));
        return string != null ? string : LauncherConfig.INSTANCE.getDEFAULT_CLOCK();
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public void setPreferClock(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.sp.edit().putString(CLOCK_PREFER, id).apply();
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public int getAssetsClockVersion() {
        return this.sp.getInt(ASSETS_CLOCK_VERSION, 0);
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public void setAssetsClockVersion(int version) {
        this.sp.edit().putInt(ASSETS_CLOCK_VERSION, version).apply();
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public String getWallpaper() {
        String string = this.sp.getString("wallpaper", this.context.getString(R.string.default_wallpaper));
        Intrinsics.checkNotNull(string);
        return string;
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public void setWallpaper(String wallpaper) {
        Intrinsics.checkNotNullParameter(wallpaper, "wallpaper");
        this.sp.edit().putString("wallpaper", wallpaper).apply();
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public boolean firstLoadWallpaper() {
        return this.sp.getBoolean("first_wallpaper_loading", true);
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public void setFirstLoadWallpaper(boolean first) {
        this.sp.edit().putBoolean("first_wallpaper_loading", first).apply();
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public void setCustomWatchPath(String id, String path) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.sp.edit().putString("custom_watch_id_" + id, path).commit();
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public String getCustomWatchPath(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.sp.getString("custom_watch_id_" + id, null);
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public void setCurrentDialSource(int id) {
        this.sp.edit().putInt("dial_from_source", id).commit();
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public int getCurrentDialSource() {
        return this.sp.getInt("dial_from_source", WatchFactory.INSTANCE.getDIAL_SOURCE_LOCAL());
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public boolean firstLoadWatch() {
        return this.sp.getBoolean("first_dial_loading", true);
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public void setFirstLoadWatch(boolean first) {
        this.sp.edit().putBoolean("first_dial_loading", first).apply();
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public boolean showSlideTask() {
        return this.sp.getBoolean("show_slide_task", true);
    }

    @Override // com.dw.launcher.data.preference.LauncherPreference
    public void setShowSlideTask(boolean show) {
        this.sp.edit().putBoolean("show_slide_task", show).apply();
    }
}
