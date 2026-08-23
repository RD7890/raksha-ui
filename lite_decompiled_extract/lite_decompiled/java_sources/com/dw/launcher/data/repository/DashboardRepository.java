package com.dw.launcher.data.repository;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.base.SingleLiveEvent;
import com.dw.launcher.data.entity.Dashboard;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.util.SystemUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

/* JADX INFO: compiled from: DashboardRepository.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0013H\u0016R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\n0\u000ej\b\u0012\u0004\u0012\u00020\n`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/dw/launcher/data/repository/DashboardRepository;", "Lcom/dw/launcher/data/repository/IDashboardRepository;", "context", "Landroid/content/Context;", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "(Landroid/content/Context;Lcom/dw/launcher/data/repository/LauncherRepository;)V", "_dashboard", "Landroidx/lifecycle/MutableLiveData;", BuildConfig.FLAVOR, "Lcom/dw/launcher/data/entity/Dashboard;", "get_dashboard", "()Landroidx/lifecycle/MutableLiveData;", "dashboards", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "getDashboards", "Landroidx/lifecycle/LiveData;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DashboardRepository implements IDashboardRepository {
    private final MutableLiveData<List<Dashboard>> _dashboard;
    private final Context context;
    private final ArrayList<Dashboard> dashboards;
    private final LauncherRepository launcherRepository;

    @Inject
    public DashboardRepository(Context context, LauncherRepository launcherRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(launcherRepository, "launcherRepository");
        this.context = context;
        this.launcherRepository = launcherRepository;
        this.dashboards = new ArrayList<>();
        this._dashboard = new SingleLiveEvent();
    }

    public final LauncherRepository getLauncherRepository() {
        return this.launcherRepository;
    }

    public final MutableLiveData<List<Dashboard>> get_dashboard() {
        return this._dashboard;
    }

    @Override // com.dw.launcher.data.repository.IDashboardRepository
    public LiveData<List<Dashboard>> getDashboards() {
        this.dashboards.clear();
        LaunchConfig launchConfigLoadConfig = this.launcherRepository.loadConfig();
        if (launchConfigLoadConfig != null) {
            Timber.Forest.d("从cfg 文件加载...", new Object[0]);
            boolean zContains$default = StringsKt.contains$default(SystemUtils.INSTANCE.getLanguage(this.context), "zh", false, 2, (Object) null);
            for (LaunchConfig.MenuStyleInfo menuStyleInfo : launchConfigLoadConfig.getMenuStyleInfo()) {
                if (zContains$default) {
                    switch (menuStyleInfo.getId()) {
                        case 0:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_BUBBLE());
                            break;
                        case 1:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_LINEAR());
                            break;
                        case 2:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID());
                            break;
                        case 3:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID_VERTICAL());
                            break;
                        case 4:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID2());
                            break;
                        case 5:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID2_VERTICAL());
                            break;
                        case 6:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_CYCLIC());
                            break;
                        case 7:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_HALF_CYCLIC());
                            break;
                        case 8:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_HONEYCOMB());
                            break;
                        case 9:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_Five_CYCle());
                            break;
                        case 10:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID_3_VERTICAL_NOTEXT_EN());
                            break;
                        case 11:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID_2_NOTEXT_VERTICAL_EN());
                            break;
                    }
                } else {
                    switch (menuStyleInfo.getId()) {
                        case 0:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_BUBBLE());
                            break;
                        case 1:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_LINEAR_EN());
                            break;
                        case 2:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID_EN());
                            break;
                        case 3:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID_VERTICAL_EN());
                            break;
                        case 4:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID2_EN());
                            break;
                        case 5:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID2_VERTICAL_EN());
                            break;
                        case 6:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_CYCLIC_EN());
                            break;
                        case 7:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_HALF_CYCLIC_EN());
                            break;
                        case 8:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_HONEYCOMB());
                            break;
                        case 9:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_Five_CYCle());
                            break;
                        case 10:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID_3_VERTICAL_NOTEXT_EN());
                            break;
                        case 11:
                            this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID_2_NOTEXT_VERTICAL_EN());
                            break;
                    }
                }
            }
        } else {
            Timber.Forest.d("默认加载...", new Object[0]);
            if (StringsKt.contains$default(SystemUtils.INSTANCE.getLanguage(this.context), "zh", false, 2, (Object) null)) {
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_BUBBLE());
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_LINEAR());
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID());
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID_VERTICAL());
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID2());
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID2_VERTICAL());
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_CYCLIC());
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_HALF_CYCLIC());
            } else {
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_BUBBLE());
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_LINEAR_EN());
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID_EN());
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID_VERTICAL_EN());
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID2_EN());
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_GRID2_VERTICAL_EN());
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_CYCLIC_EN());
                this.dashboards.add(Dashboard.INSTANCE.getDASHBOARD_HALF_CYCLIC_EN());
            }
        }
        MutableLiveData<List<Dashboard>> mutableLiveData = this._dashboard;
        if (mutableLiveData != null) {
            mutableLiveData.setValue(this.dashboards);
        }
        return this._dashboard;
    }
}
