package com.dw.launcher.data.entity;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: compiled from: HeartData.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/dw/launcher/data/entity/HeartData;", BuildConfig.FLAVOR, "timestamp", BuildConfig.FLAVOR, "type", BuildConfig.FLAVOR, "heart", "(JII)V", "getHeart", "()I", "getTimestamp", "()J", "getType", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HeartData {
    private final int heart;
    private final long timestamp;
    private final int type;

    public HeartData(long j, int i, int i2) {
        this.timestamp = j;
        this.type = i;
        this.heart = i2;
    }

    public final int getHeart() {
        return this.heart;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getType() {
        return this.type;
    }
}
