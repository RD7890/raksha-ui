package com.dw.launcher.data.repository;

import androidx.lifecycle.LiveData;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.Dashboard;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: IDashboardRepository.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/data/repository/IDashboardRepository;", BuildConfig.FLAVOR, "getDashboards", "Landroidx/lifecycle/LiveData;", BuildConfig.FLAVOR, "Lcom/dw/launcher/data/entity/Dashboard;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IDashboardRepository {
    LiveData<List<Dashboard>> getDashboards();
}
