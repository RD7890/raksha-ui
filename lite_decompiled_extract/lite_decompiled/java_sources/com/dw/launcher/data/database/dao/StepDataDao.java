package com.dw.launcher.data.database.dao;

import android.database.Cursor;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.StepCountData;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: StepDataDao.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH'¨\u0006\r"}, d2 = {"Lcom/dw/launcher/data/database/dao/StepDataDao;", BuildConfig.FLAVOR, "insert", BuildConfig.FLAVOR, "stepCountData", "Lcom/dw/launcher/data/entity/StepCountData;", "queryByDate", BuildConfig.FLAVOR, "date", BuildConfig.FLAVOR, "queryCursorByDate", "Landroid/database/Cursor;", "queryStepByDate", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface StepDataDao {
    long insert(StepCountData stepCountData);

    List<StepCountData> queryByDate(String date);

    Cursor queryCursorByDate(String date);

    StepCountData queryStepByDate(String date);
}
