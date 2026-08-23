package com.dw.launcher.data.entity;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompassConfig.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b/\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010;\u001a\u00020\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001a\u0010'\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR\u001a\u0010-\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\"\u00100\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000bR\u001a\u00103\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000f\"\u0004\b5\u0010\u0011R\u001c\u00106\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lcom/dw/launcher/data/entity/CompassConfig;", BuildConfig.FLAVOR, "clock", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "compass_degree_1_Drawable", BuildConfig.FLAVOR, "Landroid/graphics/drawable/Drawable;", "getCompass_degree_1_Drawable", "()Ljava/util/List;", "setCompass_degree_1_Drawable", "(Ljava/util/List;)V", "compass_degree_1_Position", "Landroid/graphics/Point;", "getCompass_degree_1_Position", "()Landroid/graphics/Point;", "setCompass_degree_1_Position", "(Landroid/graphics/Point;)V", "compass_degree_2_Drawable", "getCompass_degree_2_Drawable", "setCompass_degree_2_Drawable", "compass_degree_2_Position", "getCompass_degree_2_Position", "setCompass_degree_2_Position", "compass_degree_3_Drawable", "getCompass_degree_3_Drawable", "setCompass_degree_3_Drawable", "compass_degree_3_Position", "getCompass_degree_3_Position", "setCompass_degree_3_Position", "compass_directionDrawable", "getCompass_directionDrawable", "setCompass_directionDrawable", "compass_directionPosition", "getCompass_directionPosition", "setCompass_directionPosition", "compass_direction_2_Drawable", "getCompass_direction_2_Drawable", "setCompass_direction_2_Drawable", "compass_direction_2_Position", "getCompass_direction_2_Position", "setCompass_direction_2_Position", "compass_direction_3_Drawable", "getCompass_direction_3_Drawable", "setCompass_direction_3_Drawable", "compass_direction_3_Position", "getCompass_direction_3_Position", "setCompass_direction_3_Position", "compass_direction_degree_Drawable", "getCompass_direction_degree_Drawable", "setCompass_direction_degree_Drawable", "compass_direction_degree_Position", "getCompass_direction_degree_Position", "setCompass_direction_degree_Position", "compass_direction_degree_unit_Drawable", "getCompass_direction_degree_unit_Drawable", "()Landroid/graphics/drawable/Drawable;", "setCompass_direction_degree_unit_Drawable", "(Landroid/graphics/drawable/Drawable;)V", "parse", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CompassConfig {
    private final ClockConfigFlatter clock;
    private List<? extends Drawable> compass_degree_1_Drawable;
    private Point compass_degree_1_Position;
    private List<? extends Drawable> compass_degree_2_Drawable;
    private Point compass_degree_2_Position;
    private List<? extends Drawable> compass_degree_3_Drawable;
    private Point compass_degree_3_Position;
    private List<? extends Drawable> compass_directionDrawable;
    private Point compass_directionPosition;
    private List<? extends Drawable> compass_direction_2_Drawable;
    private Point compass_direction_2_Position;
    private List<? extends Drawable> compass_direction_3_Drawable;
    private Point compass_direction_3_Position;
    private List<? extends Drawable> compass_direction_degree_Drawable;
    private Point compass_direction_degree_Position;
    private Drawable compass_direction_degree_unit_Drawable;

    public final CompassConfig parse() {
        return this;
    }

    public CompassConfig(ClockConfigFlatter clockConfigFlatter) {
        Intrinsics.checkNotNullParameter(clockConfigFlatter, "clock");
        this.clock = clockConfigFlatter;
        this.compass_directionPosition = new Point();
        this.compass_direction_2_Position = new Point();
        this.compass_direction_3_Position = new Point();
        this.compass_direction_degree_Position = new Point();
        this.compass_degree_1_Position = new Point();
        this.compass_degree_2_Position = new Point();
        this.compass_degree_3_Position = new Point();
        this.compass_directionDrawable = clockConfigFlatter.splitDrawable(clockConfigFlatter.getConfig().getCompass_direction_src(), 8);
        clockConfigFlatter.setPosition(this.compass_directionPosition, clockConfigFlatter.getConfig().getCompass_direction_x(), clockConfigFlatter.getConfig().getCompass_direction_y());
        this.compass_direction_2_Drawable = clockConfigFlatter.splitDrawable(clockConfigFlatter.getConfig().getCompass_direction_2_src(), 8);
        clockConfigFlatter.setPosition(this.compass_direction_2_Position, clockConfigFlatter.getConfig().getCompass_direction_2_x(), clockConfigFlatter.getConfig().getCompass_direction_2_y());
        this.compass_direction_3_Drawable = clockConfigFlatter.splitDrawable(clockConfigFlatter.getConfig().getCompass_direction_3_src(), 8);
        clockConfigFlatter.setPosition(this.compass_direction_3_Position, clockConfigFlatter.getConfig().getCompass_direction_3_x(), clockConfigFlatter.getConfig().getCompass_direction_3_y());
        this.compass_direction_degree_Drawable = clockConfigFlatter.splitDrawable(clockConfigFlatter.getConfig().getCompass_direction_degree_src(), 10);
        clockConfigFlatter.setPosition(this.compass_direction_degree_Position, clockConfigFlatter.getConfig().getCompass_direction_degree_x(), clockConfigFlatter.getConfig().getCompass_direction_degree_y());
        this.compass_direction_degree_unit_Drawable = ClockConfigFlatter.loadDrawable$default(clockConfigFlatter, clockConfigFlatter.getConfig().getCompass_direction_degree_unit(), false, 2, (Object) null);
        this.compass_degree_1_Drawable = clockConfigFlatter.splitDrawable(clockConfigFlatter.getConfig().getCompass_degree_1_src(), 10);
        clockConfigFlatter.setPosition(this.compass_degree_1_Position, clockConfigFlatter.getConfig().getCompass_degree_1_x(), clockConfigFlatter.getConfig().getCompass_degree_1_y());
        this.compass_degree_2_Drawable = clockConfigFlatter.splitDrawable(clockConfigFlatter.getConfig().getCompass_degree_2_src(), 10);
        clockConfigFlatter.setPosition(this.compass_degree_2_Position, clockConfigFlatter.getConfig().getCompass_degree_2_x(), clockConfigFlatter.getConfig().getCompass_degree_2_y());
        this.compass_degree_3_Drawable = clockConfigFlatter.splitDrawable(clockConfigFlatter.getConfig().getCompass_degree_3_src(), 10);
        clockConfigFlatter.setPosition(this.compass_degree_3_Position, clockConfigFlatter.getConfig().getCompass_degree_3_x(), clockConfigFlatter.getConfig().getCompass_degree_3_y());
    }

    public final List<Drawable> getCompass_directionDrawable() {
        return this.compass_directionDrawable;
    }

    public final void setCompass_directionDrawable(List<? extends Drawable> list) {
        this.compass_directionDrawable = list;
    }

    public final Point getCompass_directionPosition() {
        return this.compass_directionPosition;
    }

    public final void setCompass_directionPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.compass_directionPosition = point;
    }

    public final List<Drawable> getCompass_direction_2_Drawable() {
        return this.compass_direction_2_Drawable;
    }

    public final void setCompass_direction_2_Drawable(List<? extends Drawable> list) {
        this.compass_direction_2_Drawable = list;
    }

    public final Point getCompass_direction_2_Position() {
        return this.compass_direction_2_Position;
    }

    public final void setCompass_direction_2_Position(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.compass_direction_2_Position = point;
    }

    public final List<Drawable> getCompass_direction_3_Drawable() {
        return this.compass_direction_3_Drawable;
    }

    public final void setCompass_direction_3_Drawable(List<? extends Drawable> list) {
        this.compass_direction_3_Drawable = list;
    }

    public final Point getCompass_direction_3_Position() {
        return this.compass_direction_3_Position;
    }

    public final void setCompass_direction_3_Position(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.compass_direction_3_Position = point;
    }

    public final List<Drawable> getCompass_direction_degree_Drawable() {
        return this.compass_direction_degree_Drawable;
    }

    public final void setCompass_direction_degree_Drawable(List<? extends Drawable> list) {
        this.compass_direction_degree_Drawable = list;
    }

    public final Point getCompass_direction_degree_Position() {
        return this.compass_direction_degree_Position;
    }

    public final void setCompass_direction_degree_Position(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.compass_direction_degree_Position = point;
    }

    public final Drawable getCompass_direction_degree_unit_Drawable() {
        return this.compass_direction_degree_unit_Drawable;
    }

    public final void setCompass_direction_degree_unit_Drawable(Drawable drawable) {
        this.compass_direction_degree_unit_Drawable = drawable;
    }

    public final List<Drawable> getCompass_degree_1_Drawable() {
        return this.compass_degree_1_Drawable;
    }

    public final void setCompass_degree_1_Drawable(List<? extends Drawable> list) {
        this.compass_degree_1_Drawable = list;
    }

    public final Point getCompass_degree_1_Position() {
        return this.compass_degree_1_Position;
    }

    public final void setCompass_degree_1_Position(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.compass_degree_1_Position = point;
    }

    public final List<Drawable> getCompass_degree_2_Drawable() {
        return this.compass_degree_2_Drawable;
    }

    public final void setCompass_degree_2_Drawable(List<? extends Drawable> list) {
        this.compass_degree_2_Drawable = list;
    }

    public final Point getCompass_degree_2_Position() {
        return this.compass_degree_2_Position;
    }

    public final void setCompass_degree_2_Position(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.compass_degree_2_Position = point;
    }

    public final List<Drawable> getCompass_degree_3_Drawable() {
        return this.compass_degree_3_Drawable;
    }

    public final void setCompass_degree_3_Drawable(List<? extends Drawable> list) {
        this.compass_degree_3_Drawable = list;
    }

    public final Point getCompass_degree_3_Position() {
        return this.compass_degree_3_Position;
    }

    public final void setCompass_degree_3_Position(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.compass_degree_3_Position = point;
    }
}
