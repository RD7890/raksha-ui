package com.dw.launcher.data.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import androidx.room.Room;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.database.LauncherDB;
import com.dw.launcher.data.database.dao.StepDataDao;
import com.dw.launcher.data.entity.StepCountData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: StepDataContentProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016JK\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0012\u001a\u00020\u00062\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010!J9\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/dw/launcher/data/provider/StepDataContentProvider;", "Landroid/content/ContentProvider;", "()V", "AUTHORITY", BuildConfig.FLAVOR, "CONTENT_URI", "Landroid/net/Uri;", "PATH_STEP_DATA", "stepDataDao", "Lcom/dw/launcher/data/database/dao/StepDataDao;", "getStepDataDao", "()Lcom/dw/launcher/data/database/dao/StepDataDao;", "setStepDataDao", "(Lcom/dw/launcher/data/database/dao/StepDataDao;)V", "uriMatcher", "Landroid/content/UriMatcher;", "delete", BuildConfig.FLAVOR, "uri", "selection", "selectionArgs", BuildConfig.FLAVOR, "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", BuildConfig.FLAVOR, "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StepDataContentProvider extends ContentProvider {
    private final Uri CONTENT_URI;
    public StepDataDao stepDataDao;
    private final UriMatcher uriMatcher;
    private final String AUTHORITY = "com.dw.launcher.data.provider.StepDataContentProvider";
    private final String PATH_STEP_DATA = "step_data";

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    public StepDataContentProvider() {
        Uri uri = Uri.parse("content://com.dw.launcher.data.provider.StepDataContentProvider/step_data");
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        this.CONTENT_URI = uri;
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.uriMatcher = uriMatcher;
        uriMatcher.addURI("com.dw.launcher.data.provider.StepDataContentProvider", "step_data", 1);
    }

    public final StepDataDao getStepDataDao() {
        StepDataDao stepDataDao = this.stepDataDao;
        if (stepDataDao != null) {
            return stepDataDao;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stepDataDao");
        return null;
    }

    public final void setStepDataDao(StepDataDao stepDataDao) {
        Intrinsics.checkNotNullParameter(stepDataDao, "<set-?>");
        this.stepDataDao = stepDataDao;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        setStepDataDao(((LauncherDB) Room.databaseBuilder(context, LauncherDB.class, "launcher.db").fallbackToDestructiveMigration().build()).stepDataDao());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (this.uriMatcher.match(uri) == 1) {
            String str = selectionArgs != null ? selectionArgs[0] : null;
            Timber.Forest.d("date: " + str + "  selection: " + selection, new Object[0]);
            if (str != null) {
                return getStepDataDao().queryCursorByDate(str);
            }
            return null;
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        ContentResolver contentResolver;
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (this.uriMatcher.match(uri) == 1) {
            if (uri.getLastPathSegment() != null && values != null) {
                Integer asInteger = values.getAsInteger("step");
                Integer asInteger2 = values.getAsInteger("initStep");
                String asString = values.getAsString("date");
                StepCountData stepCountData = new StepCountData();
                Intrinsics.checkNotNull(asInteger);
                stepCountData.setStep(asInteger.intValue());
                stepCountData.setDate(asString);
                Intrinsics.checkNotNull(asInteger2);
                stepCountData.setInitStep(asInteger2.intValue());
                long jInsert = getStepDataDao().insert(stepCountData);
                if (jInsert > 0) {
                    Uri uriWithAppendedId = ContentUris.withAppendedId(this.CONTENT_URI, jInsert);
                    Context context = getContext();
                    if (context != null && (contentResolver = context.getContentResolver()) != null) {
                        contentResolver.notifyChange(uriWithAppendedId, null);
                    }
                    return uriWithAppendedId;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        ContentResolver contentResolver;
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (this.uriMatcher.match(uri) == 1) {
            if (uri.getLastPathSegment() == null || values == null) {
                return 0;
            }
            Integer asInteger = values.getAsInteger("step");
            String asString = values.getAsString("date");
            Integer asInteger2 = values.getAsInteger("initStep");
            StepCountData stepCountData = new StepCountData();
            Intrinsics.checkNotNull(asInteger);
            stepCountData.setStep(asInteger.intValue());
            stepCountData.setDate(asString);
            Intrinsics.checkNotNull(asInteger2);
            stepCountData.setInitStep(asInteger2.intValue());
            long jInsert = getStepDataDao().insert(stepCountData);
            if (jInsert > 0) {
                Uri uri2 = this.CONTENT_URI;
                Intrinsics.checkNotNull(asString);
                Uri uriWithAppendedId = ContentUris.withAppendedId(uri2, Long.parseLong(asString));
                Context context = getContext();
                if (context != null && (contentResolver = context.getContentResolver()) != null) {
                    contentResolver.notifyChange(uriWithAppendedId, null);
                }
            }
            return (int) jInsert;
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }
}
