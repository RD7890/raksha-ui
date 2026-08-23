package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.format.DateFormat;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.google.android.mms.pdu.CharacterSets;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DragonBollTimePainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001a\u0010%\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000fR\u001a\u0010-\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015R\"\u00100\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR\u001a\u00103\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0013\"\u0004\b5\u0010\u0015R\"\u00106\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR\u001a\u00109\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0013\"\u0004\b;\u0010\u0015R\"\u0010<\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\r\"\u0004\b>\u0010\u000fR\u001a\u0010?\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0013\"\u0004\bA\u0010\u0015R\"\u0010B\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\r\"\u0004\bD\u0010\u000fR\u001a\u0010E\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0013\"\u0004\bG\u0010\u0015R\"\u0010H\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR\u001a\u0010K\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0013\"\u0004\bM\u0010\u0015R\"\u0010N\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR\u001a\u0010Q\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0013\"\u0004\bS\u0010\u0015R\"\u0010T\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\r\"\u0004\bV\u0010\u000fR\u001a\u0010W\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0013\"\u0004\bY\u0010\u0015R\u001a\u0010Z\u001a\u00020[X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001a\u0010`\u001a\u00020[X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010]\"\u0004\bb\u0010_¨\u0006i"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/DragonBollTimePainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "getContext", "()Landroid/content/Context;", "currentHourGeDrawable", "", "Landroid/graphics/drawable/Drawable;", "getCurrentHourGeDrawable", "()Ljava/util/List;", "setCurrentHourGeDrawable", "(Ljava/util/List;)V", "currentHourGePosition", "Landroid/graphics/Point;", "getCurrentHourGePosition", "()Landroid/graphics/Point;", "setCurrentHourGePosition", "(Landroid/graphics/Point;)V", "currentHourTenDrawable", "getCurrentHourTenDrawable", "setCurrentHourTenDrawable", "currentHourTenPosition", "getCurrentHourTenPosition", "setCurrentHourTenPosition", "currentMinGeDrawable", "getCurrentMinGeDrawable", "setCurrentMinGeDrawable", "currentMinGePosition", "getCurrentMinGePosition", "setCurrentMinGePosition", "currentMinTenDrawable", "getCurrentMinTenDrawable", "setCurrentMinTenDrawable", "currentMinTenPosition", "getCurrentMinTenPosition", "setCurrentMinTenPosition", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "nextHourGeDrawable", "getNextHourGeDrawable", "setNextHourGeDrawable", "nextHourGePosition", "getNextHourGePosition", "setNextHourGePosition", "nextHourTenDrawable", "getNextHourTenDrawable", "setNextHourTenDrawable", "nextHourTenPosition", "getNextHourTenPosition", "setNextHourTenPosition", "nextMinGeDrawable", "getNextMinGeDrawable", "setNextMinGeDrawable", "nextMinGePosition", "getNextMinGePosition", "setNextMinGePosition", "nextMinTenDrawable", "getNextMinTenDrawable", "setNextMinTenDrawable", "nextMinTenPosition", "getNextMinTenPosition", "setNextMinTenPosition", "prevHourGeDrawable", "getPrevHourGeDrawable", "setPrevHourGeDrawable", "prevHourGePosition", "getPrevHourGePosition", "setPrevHourGePosition", "prevHourTenDrawable", "getPrevHourTenDrawable", "setPrevHourTenDrawable", "prevHourTenPosition", "getPrevHourTenPosition", "setPrevHourTenPosition", "prevMinGeDrawable", "getPrevMinGeDrawable", "setPrevMinGeDrawable", "prevMinGePosition", "getPrevMinGePosition", "setPrevMinGePosition", "prevMinTenDrawable", "getPrevMinTenDrawable", "setPrevMinTenDrawable", "prevMinTenPosition", "getPrevMinTenPosition", "setPrevMinTenPosition", "scaleX", "", "getScaleX", "()F", "setScaleX", "(F)V", "scaleY", "getScaleY", "setScaleY", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class DragonBollTimePainter extends ABasePainter {
    private final Context context;
    private List<? extends Drawable> currentHourGeDrawable;
    private Point currentHourGePosition;
    private List<? extends Drawable> currentHourTenDrawable;
    private Point currentHourTenPosition;
    private List<? extends Drawable> currentMinGeDrawable;
    private Point currentMinGePosition;
    private List<? extends Drawable> currentMinTenDrawable;
    private Point currentMinTenPosition;
    private final ClockConfigFlatter flatter;
    private List<? extends Drawable> nextHourGeDrawable;
    private Point nextHourGePosition;
    private List<? extends Drawable> nextHourTenDrawable;
    private Point nextHourTenPosition;
    private List<? extends Drawable> nextMinGeDrawable;
    private Point nextMinGePosition;
    private List<? extends Drawable> nextMinTenDrawable;
    private Point nextMinTenPosition;
    private List<? extends Drawable> prevHourGeDrawable;
    private Point prevHourGePosition;
    private List<? extends Drawable> prevHourTenDrawable;
    private Point prevHourTenPosition;
    private List<? extends Drawable> prevMinGeDrawable;
    private Point prevMinGePosition;
    private List<? extends Drawable> prevMinTenDrawable;
    private Point prevMinTenPosition;
    private float scaleX;
    private float scaleY;

    public final Context getContext() {
        return this.context;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public DragonBollTimePainter(Context context, ClockConfigFlatter flatter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.prevHourTenPosition = new Point(0, 0);
        this.prevHourGePosition = new Point(0, 0);
        this.currentHourTenPosition = new Point(0, 0);
        this.currentHourGePosition = new Point(0, 0);
        this.nextHourTenPosition = new Point(0, 0);
        this.nextHourGePosition = new Point(0, 0);
        this.prevMinTenPosition = new Point(0, 0);
        this.prevMinGePosition = new Point(0, 0);
        this.currentMinTenPosition = new Point(0, 0);
        this.currentMinGePosition = new Point(0, 0);
        this.nextMinTenPosition = new Point(0, 0);
        this.nextMinGePosition = new Point(0, 0);
        setSupportScale(flatter.getConfig().supportScale());
        String prev_HourTen_Position = flatter.getConfig().getPrev_HourTen_Position();
        if (prev_HourTen_Position != null) {
            List listSplit$default = StringsKt.split$default((CharSequence) prev_HourTen_Position, new String[]{","}, false, 0, 6, (Object) null);
            flatter.setPosition(this.prevHourTenPosition, Integer.parseInt((String) listSplit$default.get(0)), Integer.parseInt((String) listSplit$default.get(1)));
        }
        String prev_HourGe_Position = flatter.getConfig().getPrev_HourGe_Position();
        if (prev_HourGe_Position != null) {
            List listSplit$default2 = StringsKt.split$default((CharSequence) prev_HourGe_Position, new String[]{","}, false, 0, 6, (Object) null);
            flatter.setPosition(this.prevHourGePosition, Integer.parseInt((String) listSplit$default2.get(0)), Integer.parseInt((String) listSplit$default2.get(1)));
        }
        String current_HourTen_Position = flatter.getConfig().getCurrent_HourTen_Position();
        if (current_HourTen_Position != null) {
            List listSplit$default3 = StringsKt.split$default((CharSequence) current_HourTen_Position, new String[]{","}, false, 0, 6, (Object) null);
            flatter.setPosition(this.currentHourTenPosition, Integer.parseInt((String) listSplit$default3.get(0)), Integer.parseInt((String) listSplit$default3.get(1)));
        }
        String current_HourGe_Position = flatter.getConfig().getCurrent_HourGe_Position();
        if (current_HourGe_Position != null) {
            List listSplit$default4 = StringsKt.split$default((CharSequence) current_HourGe_Position, new String[]{","}, false, 0, 6, (Object) null);
            flatter.setPosition(this.currentHourGePosition, Integer.parseInt((String) listSplit$default4.get(0)), Integer.parseInt((String) listSplit$default4.get(1)));
        }
        String next_HourTen_Position = flatter.getConfig().getNext_HourTen_Position();
        if (next_HourTen_Position != null) {
            List listSplit$default5 = StringsKt.split$default((CharSequence) next_HourTen_Position, new String[]{","}, false, 0, 6, (Object) null);
            flatter.setPosition(this.nextHourTenPosition, Integer.parseInt((String) listSplit$default5.get(0)), Integer.parseInt((String) listSplit$default5.get(1)));
        }
        String next_HourGe_Position = flatter.getConfig().getNext_HourGe_Position();
        if (next_HourGe_Position != null) {
            List listSplit$default6 = StringsKt.split$default((CharSequence) next_HourGe_Position, new String[]{","}, false, 0, 6, (Object) null);
            flatter.setPosition(this.nextHourGePosition, Integer.parseInt((String) listSplit$default6.get(0)), Integer.parseInt((String) listSplit$default6.get(1)));
        }
        String prev_MinTen_Position = flatter.getConfig().getPrev_MinTen_Position();
        if (prev_MinTen_Position != null) {
            List listSplit$default7 = StringsKt.split$default((CharSequence) prev_MinTen_Position, new String[]{","}, false, 0, 6, (Object) null);
            flatter.setPosition(this.prevMinTenPosition, Integer.parseInt((String) listSplit$default7.get(0)), Integer.parseInt((String) listSplit$default7.get(1)));
        }
        String prev_MinGe_Position = flatter.getConfig().getPrev_MinGe_Position();
        if (prev_MinGe_Position != null) {
            List listSplit$default8 = StringsKt.split$default((CharSequence) prev_MinGe_Position, new String[]{","}, false, 0, 6, (Object) null);
            flatter.setPosition(this.prevMinGePosition, Integer.parseInt((String) listSplit$default8.get(0)), Integer.parseInt((String) listSplit$default8.get(1)));
        }
        String current_MinTen_Position = flatter.getConfig().getCurrent_MinTen_Position();
        if (current_MinTen_Position != null) {
            List listSplit$default9 = StringsKt.split$default((CharSequence) current_MinTen_Position, new String[]{","}, false, 0, 6, (Object) null);
            flatter.setPosition(this.currentMinTenPosition, Integer.parseInt((String) listSplit$default9.get(0)), Integer.parseInt((String) listSplit$default9.get(1)));
        }
        String current_MinGe_Position = flatter.getConfig().getCurrent_MinGe_Position();
        if (current_MinGe_Position != null) {
            List listSplit$default10 = StringsKt.split$default((CharSequence) current_MinGe_Position, new String[]{","}, false, 0, 6, (Object) null);
            flatter.setPosition(this.currentMinGePosition, Integer.parseInt((String) listSplit$default10.get(0)), Integer.parseInt((String) listSplit$default10.get(1)));
        }
        String next_MinTen_Position = flatter.getConfig().getNext_MinTen_Position();
        if (next_MinTen_Position != null) {
            List listSplit$default11 = StringsKt.split$default((CharSequence) next_MinTen_Position, new String[]{","}, false, 0, 6, (Object) null);
            flatter.setPosition(this.nextMinTenPosition, Integer.parseInt((String) listSplit$default11.get(0)), Integer.parseInt((String) listSplit$default11.get(1)));
        }
        String next_MinGe_Position = flatter.getConfig().getNext_MinGe_Position();
        if (next_MinGe_Position != null) {
            List listSplit$default12 = StringsKt.split$default((CharSequence) next_MinGe_Position, new String[]{","}, false, 0, 6, (Object) null);
            flatter.setPosition(this.nextMinGePosition, Integer.parseInt((String) listSplit$default12.get(0)), Integer.parseInt((String) listSplit$default12.get(1)));
        }
        this.prevHourTenDrawable = flatter.splitDrawable("res/time3D/prevTenHour.png", 10);
        this.prevHourGeDrawable = flatter.splitDrawable("res/time3D/prevGeHour.png", 10);
        this.currentHourTenDrawable = flatter.splitDrawable("res/time3D/currentTenHour.png", 10);
        this.currentHourGeDrawable = flatter.splitDrawable("res/time3D/currentGeHour.png", 10);
        this.nextHourTenDrawable = flatter.splitDrawable("res/time3D/nextTenHour.png", 10);
        this.nextHourGeDrawable = flatter.splitDrawable("res/time3D/nextGeHour.png", 10);
        this.prevMinTenDrawable = flatter.splitDrawable("res/time3D/prevTenMin.png", 10);
        this.prevMinGeDrawable = flatter.splitDrawable("res/time3D/prevGeMin.png", 10);
        this.currentMinTenDrawable = flatter.splitDrawable("res/time3D/currentTenMin.png", 10);
        this.currentMinGeDrawable = flatter.splitDrawable("res/time3D/currentGeMin.png", 10);
        this.nextMinTenDrawable = flatter.splitDrawable("res/time3D/nextTenMin.png", 10);
        this.nextMinGeDrawable = flatter.splitDrawable("res/time3D/nextGeMin.png", 10);
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final void setScaleX(float f) {
        this.scaleX = f;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final void setScaleY(float f) {
        this.scaleY = f;
    }

    public final Point getPrevHourTenPosition() {
        return this.prevHourTenPosition;
    }

    public final void setPrevHourTenPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.prevHourTenPosition = point;
    }

    public final Point getPrevHourGePosition() {
        return this.prevHourGePosition;
    }

    public final void setPrevHourGePosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.prevHourGePosition = point;
    }

    public final Point getCurrentHourTenPosition() {
        return this.currentHourTenPosition;
    }

    public final void setCurrentHourTenPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.currentHourTenPosition = point;
    }

    public final Point getCurrentHourGePosition() {
        return this.currentHourGePosition;
    }

    public final void setCurrentHourGePosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.currentHourGePosition = point;
    }

    public final Point getNextHourTenPosition() {
        return this.nextHourTenPosition;
    }

    public final void setNextHourTenPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.nextHourTenPosition = point;
    }

    public final Point getNextHourGePosition() {
        return this.nextHourGePosition;
    }

    public final void setNextHourGePosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.nextHourGePosition = point;
    }

    public final Point getPrevMinTenPosition() {
        return this.prevMinTenPosition;
    }

    public final void setPrevMinTenPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.prevMinTenPosition = point;
    }

    public final Point getPrevMinGePosition() {
        return this.prevMinGePosition;
    }

    public final void setPrevMinGePosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.prevMinGePosition = point;
    }

    public final Point getCurrentMinTenPosition() {
        return this.currentMinTenPosition;
    }

    public final void setCurrentMinTenPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.currentMinTenPosition = point;
    }

    public final Point getCurrentMinGePosition() {
        return this.currentMinGePosition;
    }

    public final void setCurrentMinGePosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.currentMinGePosition = point;
    }

    public final Point getNextMinTenPosition() {
        return this.nextMinTenPosition;
    }

    public final void setNextMinTenPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.nextMinTenPosition = point;
    }

    public final Point getNextMinGePosition() {
        return this.nextMinGePosition;
    }

    public final void setNextMinGePosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.nextMinGePosition = point;
    }

    public final List<Drawable> getPrevHourTenDrawable() {
        return this.prevHourTenDrawable;
    }

    public final void setPrevHourTenDrawable(List<? extends Drawable> list) {
        this.prevHourTenDrawable = list;
    }

    public final List<Drawable> getPrevHourGeDrawable() {
        return this.prevHourGeDrawable;
    }

    public final void setPrevHourGeDrawable(List<? extends Drawable> list) {
        this.prevHourGeDrawable = list;
    }

    public final List<Drawable> getCurrentHourTenDrawable() {
        return this.currentHourTenDrawable;
    }

    public final void setCurrentHourTenDrawable(List<? extends Drawable> list) {
        this.currentHourTenDrawable = list;
    }

    public final List<Drawable> getCurrentHourGeDrawable() {
        return this.currentHourGeDrawable;
    }

    public final void setCurrentHourGeDrawable(List<? extends Drawable> list) {
        this.currentHourGeDrawable = list;
    }

    public final List<Drawable> getNextHourTenDrawable() {
        return this.nextHourTenDrawable;
    }

    public final void setNextHourTenDrawable(List<? extends Drawable> list) {
        this.nextHourTenDrawable = list;
    }

    public final List<Drawable> getNextHourGeDrawable() {
        return this.nextHourGeDrawable;
    }

    public final void setNextHourGeDrawable(List<? extends Drawable> list) {
        this.nextHourGeDrawable = list;
    }

    public final List<Drawable> getPrevMinTenDrawable() {
        return this.prevMinTenDrawable;
    }

    public final void setPrevMinTenDrawable(List<? extends Drawable> list) {
        this.prevMinTenDrawable = list;
    }

    public final List<Drawable> getPrevMinGeDrawable() {
        return this.prevMinGeDrawable;
    }

    public final void setPrevMinGeDrawable(List<? extends Drawable> list) {
        this.prevMinGeDrawable = list;
    }

    public final List<Drawable> getCurrentMinTenDrawable() {
        return this.currentMinTenDrawable;
    }

    public final void setCurrentMinTenDrawable(List<? extends Drawable> list) {
        this.currentMinTenDrawable = list;
    }

    public final List<Drawable> getCurrentMinGeDrawable() {
        return this.currentMinGeDrawable;
    }

    public final void setCurrentMinGeDrawable(List<? extends Drawable> list) {
        this.currentMinGeDrawable = list;
    }

    public final List<Drawable> getNextMinTenDrawable() {
        return this.nextMinTenDrawable;
    }

    public final void setNextMinTenDrawable(List<? extends Drawable> list) {
        this.nextMinTenDrawable = list;
    }

    public final List<Drawable> getNextMinGeDrawable() {
        return this.nextMinGeDrawable;
    }

    public final void setNextMinGeDrawable(List<? extends Drawable> list) {
        this.nextMinGeDrawable = list;
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Calendar calendar = Calendar.getInstance();
        this.flatter.getConfig();
        int i = calendar.get(11);
        int i2 = calendar.get(12);
        boolean zIs24HourFormat = DateFormat.is24HourFormat(this.context);
        if (!zIs24HourFormat) {
            if (i == 0) {
                i = 12;
            }
            if (i > 12) {
                i -= 12;
            }
        }
        float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX;
        float absoluteScaleY = getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scaleY;
        List<? extends Drawable> list = this.prevHourTenDrawable;
        if (list != null) {
            drawDrawable(canvas, list.get(((i + 23) % 24) / 10), this.prevHourTenPosition.x, this.prevHourTenPosition.y, absoluteScaleX, absoluteScaleY);
        }
        List<? extends Drawable> list2 = this.prevHourGeDrawable;
        if (list2 != null) {
            drawDrawable(canvas, list2.get(((i + 23) % 24) % 10), this.prevHourGePosition.x, this.prevHourGePosition.y, absoluteScaleX, absoluteScaleY);
        }
        List<? extends Drawable> list3 = this.currentHourTenDrawable;
        if (list3 != null) {
            drawDrawable(canvas, list3.get(i / 10), this.currentHourTenPosition.x, this.currentHourTenPosition.y, absoluteScaleX, absoluteScaleY);
        }
        List<? extends Drawable> list4 = this.currentHourGeDrawable;
        if (list4 != null) {
            drawDrawable(canvas, list4.get(i % 10), this.currentHourGePosition.x, this.currentHourGePosition.y, absoluteScaleX, absoluteScaleY);
        }
        List<? extends Drawable> list5 = this.nextHourTenDrawable;
        if (list5 != null) {
            int i3 = i + 1;
            if (!zIs24HourFormat && i3 > 12) {
                i3 = i - 11;
            }
            drawDrawable(canvas, list5.get(((i3 + 24) % 24) / 10), this.nextHourTenPosition.x, this.nextHourTenPosition.y, absoluteScaleX, absoluteScaleY);
        }
        List<? extends Drawable> list6 = this.nextHourGeDrawable;
        if (list6 != null) {
            int i4 = i + 1;
            if (!zIs24HourFormat && i4 > 12) {
                i4 = i - 11;
            }
            drawDrawable(canvas, list6.get(((i4 + 24) % 24) % 10), this.nextHourGePosition.x, this.nextHourGePosition.y, absoluteScaleX, absoluteScaleY);
        }
        List<? extends Drawable> list7 = this.prevMinTenDrawable;
        if (list7 != null) {
            drawDrawable(canvas, list7.get(((i2 + 59) % 60) / 10), this.prevMinTenPosition.x, this.prevMinTenPosition.y, absoluteScaleX, absoluteScaleY);
        }
        List<? extends Drawable> list8 = this.prevMinGeDrawable;
        if (list8 != null) {
            drawDrawable(canvas, list8.get(((i2 + 59) % 60) % 10), this.prevMinGePosition.x, this.prevMinGePosition.y, absoluteScaleX, absoluteScaleY);
        }
        List<? extends Drawable> list9 = this.currentMinTenDrawable;
        if (list9 != null) {
            drawDrawable(canvas, list9.get(i2 / 10), this.currentMinTenPosition.x, this.currentMinTenPosition.y, absoluteScaleX, absoluteScaleY);
        }
        List<? extends Drawable> list10 = this.currentMinGeDrawable;
        if (list10 != null) {
            drawDrawable(canvas, list10.get(i2 % 10), this.currentMinGePosition.x, this.currentMinGePosition.y, absoluteScaleX, absoluteScaleY);
        }
        List<? extends Drawable> list11 = this.nextMinTenDrawable;
        if (list11 != null) {
            drawDrawable(canvas, list11.get(((i2 + 61) % 60) / 10), this.nextMinTenPosition.x, this.nextMinTenPosition.y, absoluteScaleX, absoluteScaleY);
        }
        List<? extends Drawable> list12 = this.nextMinGeDrawable;
        if (list12 != null) {
            drawDrawable(canvas, list12.get(((i2 + 61) % 60) % 10), this.nextMinGePosition.x, this.nextMinGePosition.y, absoluteScaleX, absoluteScaleY);
        }
    }
}
