package com.dw.launcher.manager;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.WeatherData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WeatherManager.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/dw/launcher/manager/WeatherManager;", BuildConfig.FLAVOR, "()V", "lastUpdateServiceWeatherTime", BuildConfig.FLAVOR, "weatherData", "Lcom/dw/launcher/data/entity/WeatherData;", "getWeatherData", "()Lcom/dw/launcher/data/entity/WeatherData;", "setWeatherData", "(Lcom/dw/launcher/data/entity/WeatherData;)V", "notifyWeatherUpdate", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "queryWeatherData", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WeatherManager {
    public static final WeatherManager INSTANCE = new WeatherManager();
    private static long lastUpdateServiceWeatherTime;
    private static WeatherData weatherData;

    private WeatherManager() {
    }

    public final WeatherData getWeatherData() {
        return weatherData;
    }

    public final void setWeatherData(WeatherData weatherData2) {
        weatherData = weatherData2;
    }

    public final void notifyWeatherUpdate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (System.currentTimeMillis() - lastUpdateServiceWeatherTime > 3600000) {
            try {
                if (weatherData == null) {
                    queryWeatherData(context);
                }
                Intent intent = new Intent("com.divo.weather.update_weahter");
                intent.setPackage("com.diwo.weather");
                context.sendBroadcast(intent, null);
            } catch (Exception unused) {
                Log.i("WeatherManager", "定时通知天气app 更新天气失败");
            }
            lastUpdateServiceWeatherTime = System.currentTimeMillis();
        }
    }

    public final WeatherData queryWeatherData(Context context) {
        List listSplit$default;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        Uri uri = Uri.parse("content://com.diwo.weather.provider/WeatherData");
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        Cursor cursorQuery = context.getContentResolver().query(uri, null, "date = ?", new String[]{str}, null);
        if (cursorQuery != null) {
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst()) {
                    String string = cursor2.getString(cursor2.getColumnIndex("updatetime"));
                    String string2 = cursor2.getString(cursor2.getColumnIndex("current"));
                    String string3 = cursor2.getString(cursor2.getColumnIndex("code"));
                    String string4 = cursor2.getString(cursor2.getColumnIndex("current"));
                    String string5 = cursor2.getString(cursor2.getColumnIndex("temp1"));
                    if (string5 != null) {
                        Intrinsics.checkNotNull(string5);
                        listSplit$default = StringsKt.split$default(string5, new String[]{"~"}, false, 0, 6, (Object) null);
                    } else {
                        listSplit$default = null;
                    }
                    WeatherData weatherData2 = new WeatherData(string3, listSplit$default != null ? (String) listSplit$default.get(0) : null, listSplit$default != null ? (String) listSplit$default.get(1) : null, string2);
                    weatherData2.setUpdateTime(string);
                    cursor2.close();
                    weatherData = weatherData2;
                    Integer.valueOf(Log.d("WeatherService", "查询结果: " + string5 + ", " + string4 + " weatherData: " + weatherData2));
                } else {
                    Unit unit = Unit.INSTANCE;
                }
                CloseableKt.closeFinally(cursor, (Throwable) null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursor, th);
                    throw th2;
                }
            }
        }
        return null;
    }
}
