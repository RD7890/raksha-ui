package com.dw.launcher.data.config;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: DashboardConfig.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/dw/launcher/data/config/DashboardConfig;", BuildConfig.FLAVOR, "()V", "FIRST_STYLE", BuildConfig.FLAVOR, "LAST_STYLE", "RANGE_OF_STYLE", "Lkotlin/ranges/IntRange;", "getRANGE_OF_STYLE", "()Lkotlin/ranges/IntRange;", "STYLE_BUBBLE", "STYLE_CYCLIC", "STYLE_DEFAULT", "getSTYLE_DEFAULT", "()I", "setSTYLE_DEFAULT", "(I)V", "STYLE_FIVE_CYCLE", "STYLE_GRID", "STYLE_GRID2", "STYLE_GRID2_VERTICAL", "STYLE_GRID_2_VERTICAL_NO_TEXT", "STYLE_GRID_3_VERTICAL_NO_TEXT", "STYLE_GRID_VERTICAL", "STYLE_HALF_CYCLIC", "STYLE_HONEYCOMB", "STYLE_LINEAR", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DashboardConfig {
    public static final int FIRST_STYLE = 0;
    public static final int LAST_STYLE = 11;
    public static final int STYLE_BUBBLE = 0;
    public static final int STYLE_CYCLIC = 6;
    private static int STYLE_DEFAULT = 0;
    public static final int STYLE_FIVE_CYCLE = 9;
    public static final int STYLE_GRID = 2;
    public static final int STYLE_GRID2 = 4;
    public static final int STYLE_GRID2_VERTICAL = 5;
    public static final int STYLE_GRID_2_VERTICAL_NO_TEXT = 11;
    public static final int STYLE_GRID_3_VERTICAL_NO_TEXT = 10;
    public static final int STYLE_GRID_VERTICAL = 3;
    public static final int STYLE_HALF_CYCLIC = 7;
    public static final int STYLE_HONEYCOMB = 8;
    public static final int STYLE_LINEAR = 1;
    public static final DashboardConfig INSTANCE = new DashboardConfig();
    private static final IntRange RANGE_OF_STYLE = new IntRange(0, 11);

    private DashboardConfig() {
    }

    public final int getSTYLE_DEFAULT() {
        return STYLE_DEFAULT;
    }

    public final void setSTYLE_DEFAULT(int i) {
        STYLE_DEFAULT = i;
    }

    public final IntRange getRANGE_OF_STYLE() {
        return RANGE_OF_STYLE;
    }
}
