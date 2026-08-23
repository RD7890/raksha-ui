package com.dw.launcher.data.database.dao;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.ClockConfig;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ClockConfigDao.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H'J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH'J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H'J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H'J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\b\u001a\u00020\u0005H'J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u0007H'¨\u0006\u0015"}, d2 = {"Lcom/dw/launcher/data/database/dao/ClockConfigDao;", BuildConfig.FLAVOR, "deleteClockConfigById", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "findClickedNextClock", "Lcom/dw/launcher/data/entity/ClockConfig;", "parentId", "next_id", "insert", BuildConfig.FLAVOR, "clockConfig", "queryAllFromAssets", BuildConfig.FLAVOR, "level", "fromAsserts", "queryAssetsById", "queryAssetsByParentId", "updateClickedIdIndexByParentId", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ClockConfigDao {
    int deleteClockConfigById(String id);

    ClockConfig findClickedNextClock(String parentId, int next_id);

    long insert(ClockConfig clockConfig);

    List<ClockConfig> queryAllFromAssets();

    List<ClockConfig> queryAllFromAssets(int level, int fromAsserts);

    ClockConfig queryAssetsById(int id);

    List<ClockConfig> queryAssetsByParentId(String parentId);

    void updateClickedIdIndexByParentId(ClockConfig clockConfig);
}
