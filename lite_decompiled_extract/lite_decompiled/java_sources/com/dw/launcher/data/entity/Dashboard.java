package com.dw.launcher.data.entity;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Dashboard.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \r2\u00020\u0001:\u0001\rB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\b\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/dw/launcher/data/entity/Dashboard;", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "preview", "label", "(III)V", "getId", "()I", "getLabel", "setLabel", "(I)V", "getPreview", "Companion", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Dashboard {
    private final int id;
    private int label;
    private final int preview;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Dashboard DASHBOARD_LINEAR = new Dashboard(1, R.drawable.dashboard_style_preview_linear, R.string.dashboard_style_name_linear);
    private static final Dashboard DASHBOARD_LINEAR_EN = new Dashboard(1, R.drawable.dashboard_style_preview_linear_en, R.string.dashboard_style_name_linear);
    private static final Dashboard DASHBOARD_GRID = new Dashboard(2, R.drawable.dashboard_style_preview_grid, R.string.dashboard_style_name_grid);
    private static final Dashboard DASHBOARD_GRID_EN = new Dashboard(2, R.drawable.dashboard_style_preview_grid_en, R.string.dashboard_style_name_grid);
    private static final Dashboard DASHBOARD_GRID2 = new Dashboard(4, R.drawable.dashboard_style_preview_grid2, R.string.dashboard_style_name_grid2);
    private static final Dashboard DASHBOARD_GRID2_EN = new Dashboard(4, R.drawable.dashboard_style_preview_grid2_en, R.string.dashboard_style_name_grid2);
    private static final Dashboard DASHBOARD_CYCLIC = new Dashboard(6, R.drawable.dashboard_style_preview_cyclic, R.string.dashboard_style_name_cyclic);
    private static final Dashboard DASHBOARD_CYCLIC_EN = new Dashboard(6, R.drawable.dashboard_style_preview_cyclic_en, R.string.dashboard_style_name_cyclic);
    private static final Dashboard DASHBOARD_HALF_CYCLIC = new Dashboard(7, R.drawable.dashboard_style_preview_half_cyclic, R.string.dashboard_style_name_half_cyclic);
    private static final Dashboard DASHBOARD_HALF_CYCLIC_EN = new Dashboard(7, R.drawable.dashboard_style_preview_half_cyclic_en, R.string.dashboard_style_name_half_cyclic);
    private static final Dashboard DASHBOARD_GRID_VERTICAL = new Dashboard(3, R.drawable.dashboard_style_preview_grid_vertical, R.string.dashboard_style_name_grid_vertical);
    private static final Dashboard DASHBOARD_GRID_VERTICAL_EN = new Dashboard(3, R.drawable.dashboard_style_preview_grid_vertical_en, R.string.dashboard_style_name_grid_vertical);
    private static final Dashboard DASHBOARD_GRID2_VERTICAL = new Dashboard(5, R.drawable.dashboard_style_preview_grid2_vertical, R.string.dashboard_style_name_grid2_vertical);
    private static final Dashboard DASHBOARD_GRID2_VERTICAL_EN = new Dashboard(5, R.drawable.dashboard_style_preview_grid2_vertical_en, R.string.dashboard_style_name_grid2_vertical);
    private static final Dashboard DASHBOARD_BUBBLE = new Dashboard(0, R.drawable.dashboard_style_preview_bubble, R.string.dashboard_style_name_bubble);
    private static final Dashboard DASHBOARD_HONEYCOMB = new Dashboard(8, R.drawable.dashboard_style_preview_honcomb, R.string.dashboard_style_name_honeycomb);
    private static final Dashboard DASHBOARD_Five_CYCle = new Dashboard(9, R.drawable.dashboard_style_preview_grid5, R.string.dashboard_style_name_grid5_vertical);
    private static final Dashboard DASHBOARD_GRID_3_VERTICAL_NOTEXT_EN = new Dashboard(10, R.drawable.dashboard_style_preview_grid_notext_vertical, R.string.dashboard_style_name_grid_vertical);
    private static final Dashboard DASHBOARD_GRID_2_NOTEXT_VERTICAL_EN = new Dashboard(11, R.drawable.dashboard_style_preview_grid2_notext_vertical, R.string.dashboard_style_name_grid2_vertical);

    public Dashboard(int i, int i2, int i3) {
        this.id = i;
        this.preview = i2;
        this.label = i3;
    }

    public /* synthetic */ Dashboard(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public final int getId() {
        return this.id;
    }

    public final int getPreview() {
        return this.preview;
    }

    public final int getLabel() {
        return this.label;
    }

    public final void setLabel(int i) {
        this.label = i;
    }

    /* JADX INFO: compiled from: Dashboard.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b'\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0011\u0010%\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0011\u0010'\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006¨\u0006+"}, d2 = {"Lcom/dw/launcher/data/entity/Dashboard$Companion;", BuildConfig.FLAVOR, "()V", "DASHBOARD_BUBBLE", "Lcom/dw/launcher/data/entity/Dashboard;", "getDASHBOARD_BUBBLE", "()Lcom/dw/launcher/data/entity/Dashboard;", "DASHBOARD_CYCLIC", "getDASHBOARD_CYCLIC", "DASHBOARD_CYCLIC_EN", "getDASHBOARD_CYCLIC_EN", "DASHBOARD_Five_CYCle", "getDASHBOARD_Five_CYCle", "DASHBOARD_GRID", "getDASHBOARD_GRID", "DASHBOARD_GRID2", "getDASHBOARD_GRID2", "DASHBOARD_GRID2_EN", "getDASHBOARD_GRID2_EN", "DASHBOARD_GRID2_VERTICAL", "getDASHBOARD_GRID2_VERTICAL", "DASHBOARD_GRID2_VERTICAL_EN", "getDASHBOARD_GRID2_VERTICAL_EN", "DASHBOARD_GRID_2_NOTEXT_VERTICAL_EN", "getDASHBOARD_GRID_2_NOTEXT_VERTICAL_EN", "DASHBOARD_GRID_3_VERTICAL_NOTEXT_EN", "getDASHBOARD_GRID_3_VERTICAL_NOTEXT_EN", "DASHBOARD_GRID_EN", "getDASHBOARD_GRID_EN", "DASHBOARD_GRID_VERTICAL", "getDASHBOARD_GRID_VERTICAL", "DASHBOARD_GRID_VERTICAL_EN", "getDASHBOARD_GRID_VERTICAL_EN", "DASHBOARD_HALF_CYCLIC", "getDASHBOARD_HALF_CYCLIC", "DASHBOARD_HALF_CYCLIC_EN", "getDASHBOARD_HALF_CYCLIC_EN", "DASHBOARD_HONEYCOMB", "getDASHBOARD_HONEYCOMB", "DASHBOARD_LINEAR", "getDASHBOARD_LINEAR", "DASHBOARD_LINEAR_EN", "getDASHBOARD_LINEAR_EN", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Dashboard getDASHBOARD_LINEAR() {
            return Dashboard.DASHBOARD_LINEAR;
        }

        public final Dashboard getDASHBOARD_LINEAR_EN() {
            return Dashboard.DASHBOARD_LINEAR_EN;
        }

        public final Dashboard getDASHBOARD_GRID() {
            return Dashboard.DASHBOARD_GRID;
        }

        public final Dashboard getDASHBOARD_GRID_EN() {
            return Dashboard.DASHBOARD_GRID_EN;
        }

        public final Dashboard getDASHBOARD_GRID2() {
            return Dashboard.DASHBOARD_GRID2;
        }

        public final Dashboard getDASHBOARD_GRID2_EN() {
            return Dashboard.DASHBOARD_GRID2_EN;
        }

        public final Dashboard getDASHBOARD_CYCLIC() {
            return Dashboard.DASHBOARD_CYCLIC;
        }

        public final Dashboard getDASHBOARD_CYCLIC_EN() {
            return Dashboard.DASHBOARD_CYCLIC_EN;
        }

        public final Dashboard getDASHBOARD_HALF_CYCLIC() {
            return Dashboard.DASHBOARD_HALF_CYCLIC;
        }

        public final Dashboard getDASHBOARD_HALF_CYCLIC_EN() {
            return Dashboard.DASHBOARD_HALF_CYCLIC_EN;
        }

        public final Dashboard getDASHBOARD_GRID_VERTICAL() {
            return Dashboard.DASHBOARD_GRID_VERTICAL;
        }

        public final Dashboard getDASHBOARD_GRID_VERTICAL_EN() {
            return Dashboard.DASHBOARD_GRID_VERTICAL_EN;
        }

        public final Dashboard getDASHBOARD_GRID2_VERTICAL() {
            return Dashboard.DASHBOARD_GRID2_VERTICAL;
        }

        public final Dashboard getDASHBOARD_GRID2_VERTICAL_EN() {
            return Dashboard.DASHBOARD_GRID2_VERTICAL_EN;
        }

        public final Dashboard getDASHBOARD_BUBBLE() {
            return Dashboard.DASHBOARD_BUBBLE;
        }

        public final Dashboard getDASHBOARD_HONEYCOMB() {
            return Dashboard.DASHBOARD_HONEYCOMB;
        }

        public final Dashboard getDASHBOARD_Five_CYCle() {
            return Dashboard.DASHBOARD_Five_CYCle;
        }

        public final Dashboard getDASHBOARD_GRID_3_VERTICAL_NOTEXT_EN() {
            return Dashboard.DASHBOARD_GRID_3_VERTICAL_NOTEXT_EN;
        }

        public final Dashboard getDASHBOARD_GRID_2_NOTEXT_VERTICAL_EN() {
            return Dashboard.DASHBOARD_GRID_2_NOTEXT_VERTICAL_EN;
        }
    }
}
