package com.dw.launcher.data.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.dw.launcher.data.entity.StepCountData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class StepDataDao_Impl implements StepDataDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<StepCountData> __insertionAdapterOfStepCountData;

    public StepDataDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfStepCountData = new EntityInsertionAdapter<StepCountData>(__db) { // from class: com.dw.launcher.data.database.dao.StepDataDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `t_step` (`date`,`step`,`initStep`) VALUES (?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, StepCountData value) {
                if (value.getDate() == null) {
                    stmt.bindNull(1);
                } else {
                    stmt.bindString(1, value.getDate());
                }
                stmt.bindLong(2, value.getStep());
                stmt.bindLong(3, value.getInitStep());
            }
        };
    }

    @Override // com.dw.launcher.data.database.dao.StepDataDao
    public long insert(final StepCountData stepCountData) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfStepCountData.insertAndReturnId(stepCountData);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.dw.launcher.data.database.dao.StepDataDao
    public List<StepCountData> queryByDate(final String date) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from t_step where date = ?", 1);
        if (date == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, date);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initStep");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                StepCountData stepCountData = new StepCountData();
                stepCountData.setDate(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                stepCountData.setStep(cursorQuery.getInt(columnIndexOrThrow2));
                stepCountData.setInitStep(cursorQuery.getInt(columnIndexOrThrow3));
                arrayList.add(stepCountData);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.dw.launcher.data.database.dao.StepDataDao
    public StepCountData queryStepByDate(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from t_step where date = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        StepCountData stepCountData = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initStep");
            if (cursorQuery.moveToFirst()) {
                StepCountData stepCountData2 = new StepCountData();
                if (!cursorQuery.isNull(columnIndexOrThrow)) {
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                stepCountData2.setDate(string);
                stepCountData2.setStep(cursorQuery.getInt(columnIndexOrThrow2));
                stepCountData2.setInitStep(cursorQuery.getInt(columnIndexOrThrow3));
                stepCountData = stepCountData2;
            }
            return stepCountData;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.dw.launcher.data.database.dao.StepDataDao
    public Cursor queryCursorByDate(final String date) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from t_step where date = ?", 1);
        if (date == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, date);
        }
        return this.__db.query(roomSQLiteQueryAcquire);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
