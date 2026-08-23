package com.dw.launcher.data.repository;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.WatchFiltterConfig;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: WatchConfigRepository.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/dw/launcher/data/repository/WatchConfigRepository;", BuildConfig.FLAVOR, "getWatchfaces", BuildConfig.FLAVOR, "Lcom/dw/launcher/data/entity/WatchFiltterConfig$WatchInfo;", "loadConfig", "Lcom/dw/launcher/data/entity/WatchFiltterConfig;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface WatchConfigRepository {
    List<WatchFiltterConfig.WatchInfo> getWatchfaces();

    WatchFiltterConfig loadConfig();
}
