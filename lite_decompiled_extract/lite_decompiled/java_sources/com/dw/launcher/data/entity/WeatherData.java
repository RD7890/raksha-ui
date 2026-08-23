package com.dw.launcher.data.entity;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WeatherData.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/dw/launcher/data/entity/WeatherData;", BuildConfig.FLAVOR, "code", BuildConfig.FLAVOR, "min", "max", "current", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getCurrent", "getMax", "getMin", "updateTime", "getUpdateTime", "setUpdateTime", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class WeatherData {
    private final String code;
    private final String current;
    private final String max;
    private final String min;
    private String updateTime;

    public static /* synthetic */ WeatherData copy$default(WeatherData weatherData, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = weatherData.code;
        }
        if ((i & 2) != 0) {
            str2 = weatherData.min;
        }
        if ((i & 4) != 0) {
            str3 = weatherData.max;
        }
        if ((i & 8) != 0) {
            str4 = weatherData.current;
        }
        return weatherData.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMin() {
        return this.min;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMax() {
        return this.max;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCurrent() {
        return this.current;
    }

    public final WeatherData copy(String code, String min, String max, String current) {
        return new WeatherData(code, min, max, current);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WeatherData)) {
            return false;
        }
        WeatherData weatherData = (WeatherData) other;
        return Intrinsics.areEqual(this.code, weatherData.code) && Intrinsics.areEqual(this.min, weatherData.min) && Intrinsics.areEqual(this.max, weatherData.max) && Intrinsics.areEqual(this.current, weatherData.current);
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.min;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.max;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.current;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public WeatherData(String str, String str2, String str3, String str4) {
        this.code = str;
        this.min = str2;
        this.max = str3;
        this.current = str4;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMin() {
        return this.min;
    }

    public final String getMax() {
        return this.max;
    }

    public final String getCurrent() {
        return this.current;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public String toString() {
        return "WeatherData(code=" + this.code + ", min=" + this.min + ", max=" + this.max + ", current=" + this.current + ", updateTime=" + this.updateTime + ')';
    }
}
