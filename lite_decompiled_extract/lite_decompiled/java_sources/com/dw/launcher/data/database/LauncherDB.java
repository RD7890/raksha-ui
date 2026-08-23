package com.dw.launcher.data.database;

import androidx.room.RoomDatabase;
import com.dw.launcher.data.database.dao.ClockConfigDao;
import com.dw.launcher.data.database.dao.StepDataDao;
import kotlin.Metadata;

/* JADX INFO: compiled from: LauncherDB.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/dw/launcher/data/database/LauncherDB;", "Landroidx/room/RoomDatabase;", "()V", "clockConfigDao", "Lcom/dw/launcher/data/database/dao/ClockConfigDao;", "stepDataDao", "Lcom/dw/launcher/data/database/dao/StepDataDao;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class LauncherDB extends RoomDatabase {
    public abstract ClockConfigDao clockConfigDao();

    public abstract StepDataDao stepDataDao();
}
