package com.dw.launcher.data.preference;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: compiled from: LauncherPreference.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0006H&J\u001a\u0010\u0015\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0006H&J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0003H&J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0010H&J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\u001e\u001a\u00020\u0010H&J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0003H&J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\tH&J\b\u0010#\u001a\u00020\u0003H&¨\u0006$"}, d2 = {"Lcom/dw/launcher/data/preference/LauncherPreference;", BuildConfig.FLAVOR, "firstLoadWallpaper", BuildConfig.FLAVOR, "firstLoadWatch", "getAssetsClockVersion", BuildConfig.FLAVOR, "getCurrentDialSource", "getCustomWatchPath", BuildConfig.FLAVOR, "id", "getDashboardStyle", "getPreferClock", "getWallpaper", "isClockLocked", "setAssetsClockVersion", BuildConfig.FLAVOR, "version", "setClockLocked", "lock", "setCurrentDialSource", "setCustomWatchPath", "path", "setDashboardStyle", "style", "setFirstLoadWallpaper", "first", "setFirstLoadWatch", "setNextDashboard", "setPreferClock", "setPreviousDashboard", "setShowSlideTask", "show", "setWallpaper", "wallpaper", "showSlideTask", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface LauncherPreference {
    boolean firstLoadWallpaper();

    boolean firstLoadWatch();

    int getAssetsClockVersion();

    int getCurrentDialSource();

    String getCustomWatchPath(String id);

    int getDashboardStyle();

    String getPreferClock();

    String getWallpaper();

    boolean isClockLocked();

    void setAssetsClockVersion(int version);

    void setClockLocked(boolean lock);

    void setCurrentDialSource(int id);

    void setCustomWatchPath(String id, String path);

    void setDashboardStyle(int style);

    void setFirstLoadWallpaper(boolean first);

    void setFirstLoadWatch(boolean first);

    void setNextDashboard();

    void setPreferClock(String id);

    void setPreviousDashboard();

    void setShowSlideTask(boolean show);

    void setWallpaper(String wallpaper);

    boolean showSlideTask();
}
