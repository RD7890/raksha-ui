package com.dw.launcher.data.repository;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.LaunchConfig;
import kotlin.Metadata;

/* JADX INFO: compiled from: LauncherRepository.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/dw/launcher/data/repository/LauncherRepository;", BuildConfig.FLAVOR, "loadConfig", "Lcom/dw/launcher/data/entity/LaunchConfig;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface LauncherRepository {
    LaunchConfig loadConfig();
}
