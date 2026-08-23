package com.dw.launcher.data.component;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.R;
import com.dw.launcher.core.service.LauncherWallpaperService;
import com.dw.launcher.core.skin.config.SkinConfig;
import com.dw.launcher.data.entity.Wallpaper;
import com.dw.launcher.data.preference.LauncherPreference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: WallpaperComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/dw/launcher/data/component/WallpaperComponent;", "Ljava/util/Observable;", "context", "Landroid/content/Context;", "preference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "(Landroid/content/Context;Lcom/dw/launcher/data/preference/LauncherPreference;)V", "getPreference", "()Lcom/dw/launcher/data/preference/LauncherPreference;", "wallpaperManager", "Landroid/app/WallpaperManager;", "kotlin.jvm.PlatformType", "getWallpaper", BuildConfig.FLAVOR, "init", BuildConfig.FLAVOR, "loadWallpapers", BuildConfig.FLAVOR, "Lcom/dw/launcher/data/entity/Wallpaper;", "setWallpaper", BuildConfig.FLAVOR, "wallpaper", "setWallpaperAsKeyguard", "setWallpaperBoth", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WallpaperComponent extends Observable {
    private final Context context;
    private final LauncherPreference preference;
    private final WallpaperManager wallpaperManager;

    public final LauncherPreference getPreference() {
        return this.preference;
    }

    @Inject
    public WallpaperComponent(Context context, LauncherPreference launcherPreference) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(launcherPreference, "preference");
        this.context = context;
        this.preference = launcherPreference;
        this.wallpaperManager = WallpaperManager.getInstance(context);
    }

    public final List<Wallpaper> loadWallpapers() {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        String[] list = new File(SkinConfig.WALLPAPER_DIR).list();
        if (list != null) {
            for (String str : list) {
                arrayList.add(new Wallpaper(BuildConfig.FLAVOR, SkinConfig.WALLPAPER_DIR + '/' + str, 0, true));
            }
        }
        if (arrayList.isEmpty()) {
            String[] stringArray = this.context.getResources().getStringArray(R.array.wallpapers);
            Intrinsics.checkNotNull(stringArray);
            for (String str2 : stringArray) {
                Intrinsics.checkNotNull(str2);
                arrayList.add(new Wallpaper(BuildConfig.FLAVOR, str2, 0, false, 12, null));
            }
        }
        File externalFilesDir = this.context.getExternalFilesDir("customWallPaper");
        Object obj = null;
        File file = (externalFilesDir == null || (fileArrListFiles = externalFilesDir.listFiles()) == null) ? null : (File) ArraysKt.firstOrNull(fileArrListFiles);
        if ((file != null ? file.getAbsolutePath() : null) != null) {
            String absolutePath = file != null ? file.getAbsolutePath() : null;
            Intrinsics.checkNotNull(absolutePath);
            arrayList.add(new Wallpaper(BuildConfig.FLAVOR, absolutePath, 1, true));
        }
        for (Object obj2 : arrayList) {
            if (((Wallpaper) obj2).getType() == 1) {
                obj = obj2;
                break;
            }
        }
        if (((Wallpaper) obj) == null) {
            arrayList.add(new Wallpaper(BuildConfig.FLAVOR, BuildConfig.FLAVOR, 2, false));
        }
        return arrayList;
    }

    public final boolean setWallpaper(Wallpaper wallpaper) {
        Intrinsics.checkNotNullParameter(wallpaper, "wallpaper");
        Timber.Forest.i("----setWallpaper: " + wallpaper, new Object[0]);
        this.preference.setWallpaper(wallpaper.getPath());
        try {
            Timber.Forest.i("----setWallpaper success", new Object[0]);
            setChanged();
            notifyObservers();
            return true;
        } catch (Exception e) {
            Timber.Forest.e(e, "----setWallpaper failure", new Object[0]);
            return false;
        }
    }

    public final boolean setWallpaperBoth(Wallpaper wallpaper) {
        Intrinsics.checkNotNullParameter(wallpaper, "wallpaper");
        return setWallpaper(wallpaper) && setWallpaperAsKeyguard(wallpaper);
    }

    public final boolean setWallpaperAsKeyguard(Wallpaper wallpaper) {
        Intrinsics.checkNotNullParameter(wallpaper, "wallpaper");
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this.context.getApplicationContext());
        if (!new File(wallpaper.getPath()).exists()) {
            return false;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(wallpaper.getPath());
        try {
            wallpaperManager.setBitmap(bitmapDecodeFile, null, true, 2);
            Timber.Forest.d("Lock screen wallpaper set successfully", new Object[0]);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            Timber.Forest.w(e, "Failed to set lock screen wallpaper", new Object[0]);
            return false;
        } finally {
            try {
                bitmapDecodeFile.recycle();
            } catch (Exception unused) {
            }
        }
    }

    public final void init() {
        if (this.wallpaperManager.getWallpaperInfo() == null || !Intrinsics.areEqual(this.wallpaperManager.getWallpaperInfo().getServiceName(), LauncherWallpaperService.class.getName())) {
            for (Wallpaper wallpaper : loadWallpapers()) {
                if (Intrinsics.areEqual(wallpaper.getPath(), this.preference.getWallpaper())) {
                    setWallpaper(wallpaper);
                    Timber.Forest.i("----set init wallpaper", new Object[0]);
                    return;
                }
            }
        }
    }

    public final String getWallpaper() {
        return this.preference.getWallpaper();
    }
}
