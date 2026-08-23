package com.dw.launcher.data.entity;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ActivityType.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/dw/launcher/data/entity/ActivityType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "(Ljava/lang/String;II)V", "getValue", "()I", "RUNNING", "JUMP_ROPE", "SIT_UP", "JIANZI", "SQUAT_JUMP", "HIGH_KNEES", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum ActivityType {
    RUNNING(1),
    JUMP_ROPE(2),
    SIT_UP(3),
    JIANZI(4),
    SQUAT_JUMP(5),
    HIGH_KNEES(6);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int value;

    public static EnumEntries<ActivityType> getEntries() {
        return $ENTRIES;
    }

    ActivityType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
