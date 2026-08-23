package com.dw.launcher.data.repository;

import android.content.Context;
import android.os.Environment;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.WatchFiltterConfig;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: WatchLaunchRepositoryImpl.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0016J&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/dw/launcher/data/repository/WatchLaunchRepositoryImpl;", "Lcom/dw/launcher/data/repository/WatchConfigRepository;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "config", "Lcom/dw/launcher/data/entity/WatchFiltterConfig;", "watchList", BuildConfig.FLAVOR, "Lcom/dw/launcher/data/entity/WatchFiltterConfig$WatchInfo;", "getWatchList", "()Ljava/util/List;", "setWatchList", "(Ljava/util/List;)V", "getWatchfaces", BuildConfig.FLAVOR, "getWatchfacesByWidthOrHeight", "watchfaceData", "width", BuildConfig.FLAVOR, "height", "loadConfig", "parseDefaultConfig", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WatchLaunchRepositoryImpl implements WatchConfigRepository {
    private WatchFiltterConfig config;
    private final Context context;
    private List<WatchFiltterConfig.WatchInfo> watchList;

    @Inject
    public WatchLaunchRepositoryImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.watchList = new ArrayList();
    }

    public final List<WatchFiltterConfig.WatchInfo> getWatchList() {
        return this.watchList;
    }

    public final void setWatchList(List<WatchFiltterConfig.WatchInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.watchList = list;
    }

    @Override // com.dw.launcher.data.repository.WatchConfigRepository
    public WatchFiltterConfig loadConfig() throws IOException {
        FileInputStream fileInputStreamOpen;
        WatchFiltterConfig watchFiltterConfig = this.config;
        if (watchFiltterConfig != null || watchFiltterConfig != null) {
            return watchFiltterConfig;
        }
        File file = new File(Environment.getRootDirectory().getPath() + "/dw_config/watchConfig.json");
        if (file.exists()) {
            fileInputStreamOpen = new FileInputStream(file);
        } else {
            fileInputStreamOpen = this.context.getAssets().open("watchConfig.json");
        }
        this.config = (WatchFiltterConfig) new GsonBuilder().create().fromJson(new InputStreamReader(fileInputStreamOpen), WatchFiltterConfig.class);
        parseDefaultConfig();
        return this.config;
    }

    private final void parseDefaultConfig() {
        int i = this.context.getResources().getDisplayMetrics().widthPixels;
        int i2 = this.context.getResources().getDisplayMetrics().heightPixels;
        WatchFiltterConfig watchFiltterConfig = this.config;
        Intrinsics.checkNotNull(watchFiltterConfig);
        this.watchList = getWatchfacesByWidthOrHeight(watchFiltterConfig, i, i2);
        Timber.Forest.d("----desiredWidth = " + i + "  height: " + this.context.getResources().getDisplayMetrics().heightPixels, new Object[0]);
    }

    @Override // com.dw.launcher.data.repository.WatchConfigRepository
    public List<WatchFiltterConfig.WatchInfo> getWatchfaces() {
        return this.watchList;
    }

    private final List<WatchFiltterConfig.WatchInfo> getWatchfacesByWidthOrHeight(WatchFiltterConfig watchfaceData, int width, int height) {
        for (WatchFiltterConfig.WatchfaceResolution watchfaceResolution : watchfaceData.getResolutions()) {
            if (watchfaceResolution.getWidth() == width && watchfaceResolution.getHeight() == height) {
                return CollectionsKt.toMutableList(watchfaceResolution.getWatchfaceList());
            }
        }
        ArrayList arrayList = new ArrayList();
        for (WatchFiltterConfig.WatchfaceResolution watchfaceResolution2 : watchfaceData.getResolutions()) {
            if (watchfaceResolution2.getWidth() == width) {
                arrayList.addAll(watchfaceResolution2.getWatchfaceList());
                break;
            }
        }
        int i = Integer.MAX_VALUE;
        List<WatchFiltterConfig.WatchInfo> watchfaceList = null;
        for (WatchFiltterConfig.WatchfaceResolution watchfaceResolution3 : watchfaceData.getResolutions()) {
            int iAbs = Math.abs(watchfaceResolution3.getWidth() - width);
            if (iAbs < i) {
                watchfaceList = watchfaceResolution3.getWatchfaceList();
                i = iAbs;
            }
        }
        if (watchfaceList != null) {
            Timber.Forest.d("----closestSpanWatchfaces size = " + watchfaceList.size(), new Object[0]);
            arrayList.addAll(watchfaceList);
        }
        return arrayList;
    }
}
