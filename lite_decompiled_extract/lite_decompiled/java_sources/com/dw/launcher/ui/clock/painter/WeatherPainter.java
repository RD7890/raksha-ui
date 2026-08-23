package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WeatherPainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010W\u001a\u00020\u00182\u0006\u0010X\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020\u00182\u0006\u0010Z\u001a\u00020\u001e2\u0006\u0010[\u001a\u00020\u0018H\u0002J \u0010\\\u001a\u00020\u00182\u0006\u0010]\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020\u00182\u0006\u0010Z\u001a\u00020\u001eH\u0002J \u0010^\u001a\u00020\u00182\u0006\u0010]\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020\u00182\u0006\u0010Z\u001a\u00020\u001eH\u0002J\u001a\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J6\u0010e\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010f\u001a\u00020I2\u0006\u0010]\u001a\u00020\u001e2\u0006\u0010g\u001a\u00020\u00182\u0006\u0010h\u001a\u00020A2\u0006\u0010i\u001a\u00020AJ\u000e\u0010j\u001a\u00020`2\u0006\u0010a\u001a\u00020bJ\u000e\u0010k\u001a\u00020`2\u0006\u0010a\u001a\u00020bJ\u000e\u0010l\u001a\u00020`2\u0006\u0010a\u001a\u00020bJ\u000e\u0010m\u001a\u00020`2\u0006\u0010a\u001a\u00020bJ\u0010\u0010n\u001a\u00020`2\u0006\u0010a\u001a\u00020bH\u0002J\b\u0010o\u001a\u00020`H\u0002J\b\u0010p\u001a\u00020`H\u0002J!\u0010q\u001a\u00020`2\u0012\u0010r\u001a\n\u0012\u0006\b\u0001\u0012\u00020t0s\"\u00020tH\u0016¢\u0006\u0002\u0010uR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010)\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u001a\u0010,\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR\u001a\u0010/\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR\u001a\u00102\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001a\u00105\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010 \"\u0004\b7\u0010\"R\u001a\u00108\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010 \"\u0004\b:\u0010\"R\u001a\u0010;\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010 \"\u0004\b=\u0010\"R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u00020AX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\f\"\u0004\bF\u0010\u000eR\u0016\u0010G\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010M\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0016\u0010R\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006v"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/WeatherPainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "getContext", "()Landroid/content/Context;", "current", "", "getCurrent", "()Ljava/lang/String;", "setCurrent", "(Ljava/lang/String;)V", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "high", "getHigh", "setHigh", "low", "getLow", "setLow", "mCircleR", "", "getMCircleR", "()D", "setMCircleR", "(D)V", "mCircleX", "", "getMCircleX", "()I", "setMCircleX", "(I)V", "mCircleY", "getMCircleY", "setMCircleY", "mExtraAngle", "getMExtraAngle", "setMExtraAngle", "mStartArc", "getMStartArc", "setMStartArc", "mSubArcNum", "getMSubArcNum", "setMSubArcNum", "mSubArcSpltHour", "getMSubArcSpltHour", "setMSubArcSpltHour", "mSubSpltHeight", "getMSubSpltHeight", "setMSubSpltHeight", "mSubSpltWidth", "getMSubSpltWidth", "setMSubSpltWidth", "mtemperatureCellHeight", "getMtemperatureCellHeight", "setMtemperatureCellHeight", "mtemperatureCellWidth", "getMtemperatureCellWidth", "setMtemperatureCellWidth", "nowTempPosition", "Landroid/graphics/Point;", "scale", "", "getScale", "()F", "state", "getState", "setState", "stateNumDrawables", "", "Landroid/graphics/drawable/Drawable;", "stateNumPosition", "temp1Position", "temp2Position", "temperatureArcCenterPosition", "getTemperatureArcCenterPosition", "()Landroid/graphics/Point;", "setTemperatureArcCenterPosition", "(Landroid/graphics/Point;)V", "temperatureNumDrawables", "", "temperatureSignDrawable", "temperatureSpltDrawable", "temperatureSubDrawable", "calculateSubArc", "wdith", "radius", "height", "tempLen", "calculateTempLen", "width", "calculateTempLen_180", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawByAngle", "drawable", "drawArc2", "scaleX", "scaleY", "drawNowTemprate", "drawNowTemprateWithArc", "drawTemperature", "drawWeather", "drawWeatherState", "initializeStateNumDrawables", "initializeTemperatureDrawables", "updateParams", "params", "", "", "([Ljava/lang/Object;)V", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class WeatherPainter extends ABasePainter {
    private final Context context;
    private String current;
    private final ClockConfigFlatter flatter;
    private String high;
    private String low;
    private double mCircleR;
    private int mCircleX;
    private int mCircleY;
    private int mExtraAngle;
    private double mStartArc;
    private double mSubArcNum;
    private double mSubArcSpltHour;
    private int mSubSpltHeight;
    private int mSubSpltWidth;
    private int mtemperatureCellHeight;
    private int mtemperatureCellWidth;
    private Point nowTempPosition;
    private final float scale;
    private String state;
    private List<Drawable> stateNumDrawables;
    private Point stateNumPosition;
    private Point temp1Position;
    private Point temp2Position;
    private Point temperatureArcCenterPosition;
    private List<? extends Drawable> temperatureNumDrawables;
    private Drawable temperatureSignDrawable;
    private Drawable temperatureSpltDrawable;
    private Drawable temperatureSubDrawable;

    public WeatherPainter(Context context, ClockConfigFlatter flatter) {
        float scaleX;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.scale = 1.0f;
        this.stateNumPosition = new Point();
        this.nowTempPosition = new Point();
        this.temp1Position = new Point();
        this.temp2Position = new Point();
        this.state = "4";
        this.low = "0";
        this.high = "0";
        this.current = "0";
        this.temperatureArcCenterPosition = new Point();
        setSupportScale(flatter.getConfig().supportScale());
        flatter.setPosition(this.stateNumPosition, flatter.getConfig().getDiagram_x(), flatter.getConfig().getDiagram_y());
        flatter.setPosition(this.nowTempPosition, flatter.getConfig().getNow_tem_x(), flatter.getConfig().getNow_tem_y());
        flatter.setPosition(this.temp1Position, flatter.getConfig().getTemperature_x(), flatter.getConfig().getTemperature_y());
        flatter.setPosition(this.temp2Position, flatter.getConfig().getTemperature_x_2(), flatter.getConfig().getTemperature_y_2());
        if (Intrinsics.areEqual(flatter.getConfig().getShow_temperature(), "1") || Intrinsics.areEqual(flatter.getConfig().getShow_now_tem(), "1")) {
            initializeTemperatureDrawables();
        }
        if (Intrinsics.areEqual(flatter.getConfig().getShow_diagram(), "1")) {
            initializeStateNumDrawables();
        }
        if (flatter.getConfig().getOpen_now_tem_arc_show() == 1) {
            List<? extends Drawable> list = this.temperatureNumDrawables;
            if (list != null) {
                this.mtemperatureCellWidth = getSupportScale() ? (int) (list.get(0).getIntrinsicWidth() * flatter.getAbsoluteScaleX()) : list.get(0).getIntrinsicWidth();
                boolean supportScale = getSupportScale();
                int intrinsicHeight = list.get(0).getIntrinsicHeight();
                this.mtemperatureCellHeight = supportScale ? (int) (intrinsicHeight * flatter.getAbsoluteScaleY()) : intrinsicHeight;
            }
            Drawable drawable = this.temperatureSubDrawable;
            if (drawable != null) {
                this.mSubSpltWidth = (int) ((getSupportScale() ? drawable.getIntrinsicWidth() * flatter.getAbsoluteScaleX() : drawable.getIntrinsicWidth()) * flatter.getScaleX());
                boolean supportScale2 = getSupportScale();
                float intrinsicHeight2 = drawable.getIntrinsicHeight();
                if (supportScale2) {
                    intrinsicHeight2 *= flatter.getAbsoluteScaleY();
                    scaleX = flatter.getScaleY();
                } else {
                    scaleX = flatter.getScaleX();
                }
                this.mSubSpltHeight = (int) (intrinsicHeight2 * scaleX);
            }
            flatter.setPosition(this.temperatureArcCenterPosition, flatter.getConfig().getNow_tem_arc_center_x(), flatter.getConfig().getNow_tem_arc_center_y());
            int i = this.nowTempPosition.x;
            int i2 = this.nowTempPosition.y;
            this.mCircleX = this.temperatureArcCenterPosition.x;
            int i3 = this.temperatureArcCenterPosition.y;
            this.mCircleY = i3;
            double d = ((double) i) - ((double) this.mCircleX);
            double d2 = ((double) i2) - ((double) i3);
            double dSqrt = Math.sqrt((d * d) + (d2 * d2));
            this.mCircleR = dSqrt;
            double dAcos = Math.acos(d / dSqrt);
            this.mStartArc = dAcos;
            if (i2 > this.mCircleY) {
                this.mStartArc = 6.283185307179586d - dAcos;
            }
            double d3 = 1.5707963267948966d - this.mStartArc;
            this.mStartArc = d3;
            if (d3 < 0.0d) {
                this.mStartArc = d3 + 6.283185307179586d;
            }
            if (flatter.getConfig().getNow_tem_arc_type() != 0) {
                this.mExtraAngle = PduHeaders.RECOMMENDED_RETRIEVAL_MODE;
                double d4 = this.mCircleR;
                double dCalculateTempLen_180 = calculateTempLen_180(this.mtemperatureCellWidth, d4, this.mtemperatureCellHeight);
                double d5 = (((double) this.mtemperatureCellHeight) / 2.0d) + d4;
                double d6 = (d5 * d5) + (dCalculateTempLen_180 * dCalculateTempLen_180);
                double dCalculateTempLen_181 = calculateTempLen_180(this.mSubSpltWidth, this.mCircleR, this.mSubSpltHeight);
                this.mSubArcSpltHour = Math.acos(((Math.pow((((double) this.mSubSpltHeight) / 2.0d) + this.mCircleR, 2.0d) + Math.pow(dCalculateTempLen_181, 2.0d)) - Math.pow(((double) this.mSubSpltWidth) / 2.0d, 2.0d)) / (((this.mCircleR + (((double) this.mSubSpltHeight) / 2.0d)) * 2.0d) * dCalculateTempLen_181));
                int i4 = this.mtemperatureCellWidth;
                double dAcos2 = Math.acos((d6 - ((((double) i4) / 2.0d) * (((double) i4) / 2.0d))) / ((d5 * 2.0d) * dCalculateTempLen_180));
                this.mSubArcSpltHour = -this.mSubArcSpltHour;
                this.mSubArcNum = -dAcos2;
                return;
            }
            this.mExtraAngle = 0;
            double d7 = this.mCircleR;
            double dCalculateTempLen = calculateTempLen(this.mtemperatureCellWidth, d7, this.mtemperatureCellHeight);
            this.mSubArcSpltHour = calculateSubArc(this.mSubSpltWidth, d7, this.mSubSpltHeight, calculateTempLen(this.mSubSpltWidth, d7, this.mSubSpltHeight));
            this.mSubArcNum = calculateSubArc(this.mtemperatureCellWidth, d7, this.mtemperatureCellHeight, dCalculateTempLen);
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public final float getScale() {
        return this.scale;
    }

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        this.state = str;
    }

    public final String getLow() {
        return this.low;
    }

    public final void setLow(String str) {
        this.low = str;
    }

    public final String getHigh() {
        return this.high;
    }

    public final void setHigh(String str) {
        this.high = str;
    }

    public final String getCurrent() {
        return this.current;
    }

    public final void setCurrent(String str) {
        this.current = str;
    }

    public final int getMCircleX() {
        return this.mCircleX;
    }

    public final void setMCircleX(int i) {
        this.mCircleX = i;
    }

    public final int getMCircleY() {
        return this.mCircleY;
    }

    public final void setMCircleY(int i) {
        this.mCircleY = i;
    }

    public final double getMCircleR() {
        return this.mCircleR;
    }

    public final void setMCircleR(double d) {
        this.mCircleR = d;
    }

    public final double getMStartArc() {
        return this.mStartArc;
    }

    public final void setMStartArc(double d) {
        this.mStartArc = d;
    }

    public final int getMExtraAngle() {
        return this.mExtraAngle;
    }

    public final void setMExtraAngle(int i) {
        this.mExtraAngle = i;
    }

    public final int getMtemperatureCellWidth() {
        return this.mtemperatureCellWidth;
    }

    public final void setMtemperatureCellWidth(int i) {
        this.mtemperatureCellWidth = i;
    }

    public final int getMtemperatureCellHeight() {
        return this.mtemperatureCellHeight;
    }

    public final void setMtemperatureCellHeight(int i) {
        this.mtemperatureCellHeight = i;
    }

    public final double getMSubArcNum() {
        return this.mSubArcNum;
    }

    public final void setMSubArcNum(double d) {
        this.mSubArcNum = d;
    }

    public final Point getTemperatureArcCenterPosition() {
        return this.temperatureArcCenterPosition;
    }

    public final void setTemperatureArcCenterPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.temperatureArcCenterPosition = point;
    }

    public final int getMSubSpltHeight() {
        return this.mSubSpltHeight;
    }

    public final void setMSubSpltHeight(int i) {
        this.mSubSpltHeight = i;
    }

    public final int getMSubSpltWidth() {
        return this.mSubSpltWidth;
    }

    public final void setMSubSpltWidth(int i) {
        this.mSubSpltWidth = i;
    }

    public final double getMSubArcSpltHour() {
        return this.mSubArcSpltHour;
    }

    public final void setMSubArcSpltHour(double d) {
        this.mSubArcSpltHour = d;
    }

    private final double calculateTempLen_180(int width, double radius, int height) {
        double d = ((double) width) / 2.0d;
        double d2 = (((double) height) / 2.0d) + radius;
        return Math.sqrt((d * d) + (d2 * d2));
    }

    private final double calculateTempLen(int width, double radius, int height) {
        double d = ((double) width) / 2.0d;
        double d2 = radius - (((double) height) / 2.0d);
        return Math.sqrt((d * d) + (d2 * d2));
    }

    private final double calculateSubArc(int wdith, double radius, int height, double tempLen) {
        double d = radius - (((double) height) / 2.0d);
        double d2 = ((double) wdith) / 2.0d;
        return Math.acos((((d * d) + (tempLen * tempLen)) - (d2 * d2)) / ((d * 2.0d) * tempLen));
    }

    private final void initializeTemperatureDrawables() {
        ClockConfigFlatter clockConfigFlatter = this.flatter;
        this.temperatureSubDrawable = ClockConfigFlatter.loadDrawable$default(clockConfigFlatter, clockConfigFlatter.getConfig().getTemperature_sub_src(), false, 2, null);
        ClockConfigFlatter clockConfigFlatter2 = this.flatter;
        this.temperatureSignDrawable = ClockConfigFlatter.loadDrawable$default(clockConfigFlatter2, clockConfigFlatter2.getConfig().getTemperature_sign_src(), false, 2, null);
        ClockConfigFlatter clockConfigFlatter3 = this.flatter;
        this.temperatureSpltDrawable = ClockConfigFlatter.loadDrawable$default(clockConfigFlatter3, clockConfigFlatter3.getConfig().getTemperature_splt_src(), false, 2, null);
        ClockConfigFlatter clockConfigFlatter4 = this.flatter;
        this.temperatureNumDrawables = clockConfigFlatter4.splitDrawable(clockConfigFlatter4.getConfig().getTemperature_num_src(), 10);
    }

    private final void initializeStateNumDrawables() {
        ArrayList arrayList = new ArrayList();
        this.stateNumDrawables = arrayList;
        Drawable drawableLoadDrawable$default = ClockConfigFlatter.loadDrawable$default(this.flatter, "res/weather/1.png", false, 2, null);
        Intrinsics.checkNotNull(drawableLoadDrawable$default);
        arrayList.add(drawableLoadDrawable$default);
        Drawable drawableLoadDrawable$default2 = ClockConfigFlatter.loadDrawable$default(this.flatter, "res/weather/2.png", false, 2, null);
        Intrinsics.checkNotNull(drawableLoadDrawable$default2);
        arrayList.add(drawableLoadDrawable$default2);
        Drawable drawableLoadDrawable$default3 = ClockConfigFlatter.loadDrawable$default(this.flatter, "res/weather/3.png", false, 2, null);
        Intrinsics.checkNotNull(drawableLoadDrawable$default3);
        arrayList.add(drawableLoadDrawable$default3);
        Drawable drawableLoadDrawable$default4 = ClockConfigFlatter.loadDrawable$default(this.flatter, "res/weather/4.png", false, 2, null);
        Intrinsics.checkNotNull(drawableLoadDrawable$default4);
        arrayList.add(drawableLoadDrawable$default4);
        Drawable drawableLoadDrawable$default5 = ClockConfigFlatter.loadDrawable$default(this.flatter, "res/weather/5.png", false, 2, null);
        Intrinsics.checkNotNull(drawableLoadDrawable$default5);
        arrayList.add(drawableLoadDrawable$default5);
    }

    public final void drawWeather(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (Intrinsics.areEqual(this.flatter.getConfig().getShow_temperature(), "1")) {
            drawTemperature(canvas);
        }
        if (Intrinsics.areEqual(this.flatter.getConfig().getShow_now_tem(), "1")) {
            if (this.flatter.getConfig().getOpen_now_tem_arc_show() == 0) {
                drawNowTemprate(canvas);
            } else {
                drawNowTemprateWithArc(canvas);
            }
        }
        if (Intrinsics.areEqual(this.flatter.getConfig().getShow_diagram(), "1")) {
            drawWeatherState(canvas);
        }
    }

    public final void drawTemperature(Canvas canvas) {
        String str;
        int intrinsicWidth;
        int intrinsicWidth2;
        int intrinsicWidth3;
        int intrinsicWidth4;
        int intrinsicWidth5;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        String str2 = this.high;
        if (str2 == null || str2.length() == 0 || (str = this.low) == null || str.length() == 0) {
            return;
        }
        String str3 = this.high;
        Intrinsics.checkNotNull(str3);
        int i3 = Integer.parseInt(str3);
        String str4 = this.low;
        Intrinsics.checkNotNull(str4);
        int i4 = Integer.parseInt(str4);
        int intrinsicWidth6 = this.temp1Position.x;
        int i5 = this.temp1Position.y;
        List<? extends Drawable> list = this.temperatureNumDrawables;
        if (list != null) {
            int temperature_num_type = this.flatter.getConfig().getTemperature_num_type();
            int temperature_show_type = this.flatter.getConfig().getTemperature_show_type();
            int intrinsicWidth7 = 0;
            if (temperature_num_type == 0) {
                Drawable drawable = this.temperatureSubDrawable;
                if (drawable != null) {
                    intrinsicWidth5 = i4 < 0 ? (int) (drawable.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX())) : 0;
                    int intrinsicWidth8 = i3 < 0 ? (int) (drawable.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX())) : 0;
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                    i = intrinsicWidth8;
                } else {
                    intrinsicWidth5 = 0;
                    i = 0;
                }
                Drawable drawable2 = this.temperatureSignDrawable;
                if (drawable2 != null) {
                    int intrinsicWidth9 = (int) (drawable2.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX()));
                    Unit unit3 = Unit.INSTANCE;
                    Unit unit4 = Unit.INSTANCE;
                    i2 = intrinsicWidth9;
                } else {
                    i2 = 0;
                }
                ArrayList<Drawable> arrayList = new ArrayList();
                for (int iAbs = Math.abs(i4); iAbs >= 0; iAbs /= 10) {
                    arrayList.add(0, list.get(iAbs % 10));
                    if (iAbs < 10) {
                        break;
                    }
                }
                ArrayList<Drawable> arrayList2 = new ArrayList();
                for (int iAbs2 = Math.abs(i3); iAbs2 >= 0; iAbs2 /= 10) {
                    arrayList2.add(0, list.get(iAbs2 % 10));
                    if (iAbs2 < 10) {
                        break;
                    }
                }
                float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scale;
                if (temperature_show_type == 1) {
                    intrinsicWidth6 = (intrinsicWidth6 - intrinsicWidth5) - i2;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        intrinsicWidth6 -= (int) (((Drawable) it.next()).getIntrinsicWidth() * absoluteScaleX);
                    }
                } else if (temperature_show_type == 2) {
                    int i6 = (intrinsicWidth6 - (intrinsicWidth5 / 2)) - (i2 / 2);
                    Iterator it2 = arrayList.iterator();
                    int intrinsicWidth10 = 0;
                    while (it2.hasNext()) {
                        intrinsicWidth10 += (int) (((Drawable) it2.next()).getIntrinsicWidth() * absoluteScaleX);
                    }
                    intrinsicWidth6 = i6 - (intrinsicWidth10 / 2);
                }
                int intrinsicWidth11 = intrinsicWidth6;
                Drawable drawable3 = this.temperatureSubDrawable;
                if (drawable3 != null) {
                    if (i4 < 0) {
                        drawDrawable(canvas, drawable3, intrinsicWidth11, i5, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                        intrinsicWidth11 += (int) (drawable3.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX()));
                    }
                    Unit unit5 = Unit.INSTANCE;
                    Unit unit6 = Unit.INSTANCE;
                } else {
                    arrayList = arrayList;
                }
                for (Drawable drawable4 : arrayList) {
                    drawDrawable(canvas, drawable4, intrinsicWidth11, i5, absoluteScaleX, absoluteScaleX);
                    intrinsicWidth11 += (int) (drawable4.getIntrinsicWidth() * absoluteScaleX);
                }
                Drawable drawable5 = this.temperatureSignDrawable;
                if (drawable5 != null) {
                    drawDrawable(canvas, drawable5, intrinsicWidth11, i5, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                    drawable5.getIntrinsicWidth();
                    if (getSupportScale()) {
                        this.flatter.getAbsoluteScaleX();
                    }
                    this.flatter.getScaleX();
                    Unit unit7 = Unit.INSTANCE;
                    Unit unit8 = Unit.INSTANCE;
                }
                int intrinsicWidth12 = this.temp2Position.x;
                int i7 = this.temp2Position.y;
                if (temperature_show_type == 1) {
                    intrinsicWidth12 = (intrinsicWidth12 - i) - i2;
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        intrinsicWidth12 -= (int) (((Drawable) it3.next()).getIntrinsicWidth() * absoluteScaleX);
                    }
                } else if (temperature_show_type == 2) {
                    int i8 = (intrinsicWidth12 - (i2 / 2)) - (i / 2);
                    Iterator it4 = arrayList2.iterator();
                    while (it4.hasNext()) {
                        intrinsicWidth7 += (int) (((Drawable) it4.next()).getIntrinsicWidth() * absoluteScaleX);
                    }
                    intrinsicWidth12 = i8 - (intrinsicWidth7 / 2);
                }
                int intrinsicWidth13 = intrinsicWidth12;
                Drawable drawable6 = this.temperatureSubDrawable;
                if (drawable6 != null) {
                    if (i3 < 0) {
                        drawDrawable(canvas, drawable6, intrinsicWidth13, i7, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                        intrinsicWidth13 += (int) (drawable6.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX()));
                    }
                    Unit unit9 = Unit.INSTANCE;
                    Unit unit10 = Unit.INSTANCE;
                }
                for (Drawable drawable7 : arrayList2) {
                    drawDrawable(canvas, drawable7, intrinsicWidth13, i7, absoluteScaleX, absoluteScaleX);
                    intrinsicWidth13 += (int) (drawable7.getIntrinsicWidth() * absoluteScaleX);
                }
                Drawable drawable8 = this.temperatureSignDrawable;
                if (drawable8 != null) {
                    drawDrawable(canvas, drawable8, intrinsicWidth13, i7, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                    drawable8.getIntrinsicWidth();
                    if (getSupportScale()) {
                        this.flatter.getAbsoluteScaleX();
                    }
                    this.flatter.getScaleX();
                    Unit unit11 = Unit.INSTANCE;
                    Unit unit12 = Unit.INSTANCE;
                    return;
                }
                return;
            }
            Drawable drawable9 = this.temperatureSubDrawable;
            if (drawable9 != null) {
                intrinsicWidth2 = i4 < 0 ? (int) (drawable9.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX())) : 0;
                intrinsicWidth = i3 < 0 ? (int) (drawable9.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX())) : 0;
                Unit unit13 = Unit.INSTANCE;
                Unit unit14 = Unit.INSTANCE;
            } else {
                intrinsicWidth = 0;
                intrinsicWidth2 = 0;
            }
            Drawable drawable10 = this.temperatureSpltDrawable;
            if (drawable10 != null) {
                intrinsicWidth3 = (int) (drawable10.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX()));
                Unit unit15 = Unit.INSTANCE;
                Unit unit16 = Unit.INSTANCE;
            } else {
                intrinsicWidth3 = 0;
            }
            Drawable drawable11 = this.temperatureSignDrawable;
            if (drawable11 != null) {
                intrinsicWidth4 = (int) (drawable11.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX()));
                Unit unit17 = Unit.INSTANCE;
                Unit unit18 = Unit.INSTANCE;
            } else {
                intrinsicWidth4 = 0;
            }
            ArrayList<Drawable> arrayList3 = new ArrayList();
            for (int iAbs3 = Math.abs(i4); iAbs3 >= 0; iAbs3 /= 10) {
                arrayList3.add(0, list.get(iAbs3 % 10));
                if (iAbs3 < 10) {
                    break;
                }
            }
            ArrayList<Drawable> arrayList4 = new ArrayList();
            for (int iAbs4 = Math.abs(i3); iAbs4 >= 0; iAbs4 /= 10) {
                arrayList4.add(0, list.get(iAbs4 % 10));
                if (iAbs4 < 10) {
                    break;
                }
            }
            float absoluteScaleX2 = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scale;
            if (temperature_show_type == 1) {
                intrinsicWidth6 = (((intrinsicWidth6 - intrinsicWidth2) - intrinsicWidth4) - intrinsicWidth) - intrinsicWidth3;
                Iterator it5 = arrayList3.iterator();
                while (it5.hasNext()) {
                    intrinsicWidth6 -= (int) (((Drawable) it5.next()).getIntrinsicWidth() * absoluteScaleX2);
                }
                Iterator it6 = arrayList4.iterator();
                while (it6.hasNext()) {
                    intrinsicWidth6 -= (int) (((Drawable) it6.next()).getIntrinsicWidth() * absoluteScaleX2);
                }
            } else if (temperature_show_type == 2) {
                int i9 = (((intrinsicWidth6 - (intrinsicWidth2 / 2)) - (intrinsicWidth4 / 2)) - (intrinsicWidth / 2)) - (intrinsicWidth3 / 2);
                Iterator it7 = arrayList3.iterator();
                int intrinsicWidth14 = 0;
                while (it7.hasNext()) {
                    intrinsicWidth14 += (int) (((Drawable) it7.next()).getIntrinsicWidth() * absoluteScaleX2);
                }
                int i10 = i9 - (intrinsicWidth14 / 2);
                Iterator it8 = arrayList4.iterator();
                while (it8.hasNext()) {
                    intrinsicWidth7 += (int) (((Drawable) it8.next()).getIntrinsicWidth() * absoluteScaleX2);
                }
                intrinsicWidth6 = i10 - (intrinsicWidth7 / 2);
            }
            int intrinsicWidth15 = intrinsicWidth6;
            Drawable drawable12 = this.temperatureSubDrawable;
            if (drawable12 != null) {
                if (i4 < 0) {
                    drawDrawable(canvas, drawable12, intrinsicWidth15, i5, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                    intrinsicWidth15 += (int) (drawable12.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX()));
                }
                Unit unit19 = Unit.INSTANCE;
                Unit unit20 = Unit.INSTANCE;
            }
            for (Drawable drawable13 : arrayList3) {
                drawDrawable(canvas, drawable13, intrinsicWidth15, i5, absoluteScaleX2, absoluteScaleX2);
                intrinsicWidth15 += (int) (drawable13.getIntrinsicWidth() * absoluteScaleX2);
            }
            Drawable drawable14 = this.temperatureSpltDrawable;
            if (drawable14 != null) {
                drawDrawable(canvas, drawable14, intrinsicWidth15, i5, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                intrinsicWidth15 += (int) (drawable14.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX()));
                Unit unit21 = Unit.INSTANCE;
                Unit unit22 = Unit.INSTANCE;
            }
            Drawable drawable15 = this.temperatureSubDrawable;
            if (drawable15 != null) {
                if (i3 < 0) {
                    drawDrawable(canvas, drawable15, intrinsicWidth15, i5, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                    intrinsicWidth15 += (int) (drawable15.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX()));
                }
                Unit unit23 = Unit.INSTANCE;
                Unit unit24 = Unit.INSTANCE;
            }
            for (Drawable drawable16 : arrayList4) {
                drawDrawable(canvas, drawable16, intrinsicWidth15, i5, absoluteScaleX2, absoluteScaleX2);
                intrinsicWidth15 += (int) (drawable16.getIntrinsicWidth() * absoluteScaleX2);
            }
            Drawable drawable17 = this.temperatureSignDrawable;
            if (drawable17 != null) {
                drawDrawable(canvas, drawable17, intrinsicWidth15, i5, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                drawable17.getIntrinsicWidth();
                if (getSupportScale()) {
                    this.flatter.getAbsoluteScaleX();
                }
                this.flatter.getScaleX();
                Unit unit25 = Unit.INSTANCE;
                Unit unit26 = Unit.INSTANCE;
            }
        }
    }

    public final void drawByAngle(Canvas canvas, Drawable drawable, int width, double drawArc2, float scaleX, float scaleY) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        double d = 1.5707963267948966d - drawArc2;
        double dCos = ((double) this.mCircleX) + (this.mCircleR * Math.cos(d));
        double dSin = ((double) this.mCircleY) - (this.mCircleR * Math.sin(d));
        double d2 = (180.0d * drawArc2) / 3.141592653589793d;
        float f = (float) dCos;
        float f2 = (float) dSin;
        canvas.rotate((float) (((double) this.mExtraAngle) + d2), f, f2);
        drawDrawable(canvas, drawable, (int) (dCos - (((double) width) / 2.0d)), (int) dSin, scaleX, scaleY);
        canvas.rotate(-((float) (d2 + ((double) this.mExtraAngle))), f, f2);
    }

    public final void drawNowTemprateWithArc(Canvas canvas) {
        List<? extends Drawable> list;
        double d;
        double d2;
        double length;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        String str = this.current;
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = this.current;
        Intrinsics.checkNotNull(str2);
        int i = Integer.parseInt(str2);
        if (i > -255 && (list = this.temperatureNumDrawables) != null) {
            String strValueOf = String.valueOf(i);
            int temperature_show_type = this.flatter.getConfig().getTemperature_show_type();
            double d3 = 2.0d;
            if (temperature_show_type != 0) {
                if (temperature_show_type == 1) {
                    d2 = this.mStartArc;
                    length = ((double) strValueOf.length()) * this.mSubArcNum * 2.0d;
                } else if (temperature_show_type != 2) {
                    d = 0.0d;
                } else {
                    d2 = this.mStartArc;
                    length = ((double) strValueOf.length()) * this.mSubArcNum;
                }
                d = d2 - length;
            } else {
                d = this.mStartArc;
            }
            double d4 = d;
            if (i < 0) {
                Drawable drawable = this.temperatureSubDrawable;
                if (drawable != null) {
                    drawByAngle(canvas, drawable, this.mSubSpltWidth, d4, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                }
                d4 += this.mSubArcSpltHour;
            }
            String strValueOf2 = String.valueOf(Math.abs(i));
            double d5 = d4 + this.mSubArcNum;
            int length2 = strValueOf2.length();
            int i2 = 0;
            double d6 = d5;
            while (i2 < length2) {
                if (i2 > 0) {
                    d6 += this.mSubArcNum * d3;
                }
                double d7 = d6;
                double d8 = 1.5707963267948966d - d7;
                double dCos = ((double) this.mCircleX) + (this.mCircleR * Math.cos(d8));
                double dSin = ((double) this.mCircleY) - (this.mCircleR * Math.sin(d8));
                double d9 = (180.0d * d7) / 3.141592653589793d;
                float f = (float) dCos;
                float f2 = (float) dSin;
                canvas.rotate((float) (((double) this.mExtraAngle) + d9), f, f2);
                double d10 = dCos - (((double) this.mtemperatureCellWidth) / 2.0d);
                float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scale;
                Drawable drawable2 = list.get(strValueOf2.charAt(i2) - '0');
                Intrinsics.checkNotNull(drawable2);
                drawDrawable(canvas, drawable2, (int) d10, (int) dSin, absoluteScaleX, absoluteScaleX);
                canvas.rotate(-((float) (d9 + ((double) this.mExtraAngle))), f, f2);
                i2++;
                d6 = d7;
                d3 = 2.0d;
                length2 = length2;
                strValueOf2 = strValueOf2;
            }
        }
    }

    public final void drawNowTemprate(Canvas canvas) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        String str = this.current;
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = this.current;
        Intrinsics.checkNotNull(str2);
        int i = Integer.parseInt(str2);
        if (i <= -255) {
            return;
        }
        int intrinsicWidth = this.nowTempPosition.x;
        int i2 = this.nowTempPosition.y;
        String now_tem_show_type = this.flatter.getConfig().getNow_tem_show_type();
        List<? extends Drawable> list = this.temperatureNumDrawables;
        if (list != null) {
            int intrinsicWidth2 = 0;
            int intrinsicWidth3 = (i >= 0 || (drawable = this.temperatureSubDrawable) == null) ? 0 : (int) (drawable.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX()));
            Drawable drawable2 = this.temperatureSignDrawable;
            int intrinsicWidth4 = drawable2 != null ? (int) (drawable2.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX())) : 0;
            ArrayList<Drawable> arrayList = new ArrayList();
            for (int iAbs = Math.abs(i); iAbs >= 0; iAbs /= 10) {
                arrayList.add(0, list.get(iAbs % 10));
                if (iAbs < 10) {
                    break;
                }
            }
            float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scale;
            if (!Intrinsics.areEqual(now_tem_show_type, "1")) {
                if (Intrinsics.areEqual(now_tem_show_type, "2")) {
                    int i3 = (intrinsicWidth - (intrinsicWidth3 / 2)) - (intrinsicWidth4 / 2);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        intrinsicWidth2 += (int) (((Drawable) it.next()).getIntrinsicWidth() * absoluteScaleX);
                    }
                    intrinsicWidth = i3 - (intrinsicWidth2 / 2);
                }
            } else {
                intrinsicWidth = (intrinsicWidth - intrinsicWidth3) - intrinsicWidth4;
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    intrinsicWidth -= (int) (((Drawable) it2.next()).getIntrinsicWidth() * absoluteScaleX);
                }
            }
            Drawable drawable3 = this.temperatureSubDrawable;
            if (drawable3 != null && i < 0) {
                drawDrawable(canvas, drawable3, intrinsicWidth, i2, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                intrinsicWidth += (int) (drawable3.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX()));
            }
            for (Drawable drawable4 : arrayList) {
                drawDrawable(canvas, drawable4, intrinsicWidth, i2, absoluteScaleX, absoluteScaleX);
                intrinsicWidth += (int) (drawable4.getIntrinsicWidth() * absoluteScaleX);
            }
            Drawable drawable5 = this.temperatureSignDrawable;
            if (drawable5 != null) {
                drawDrawable(canvas, drawable5, intrinsicWidth, i2, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                drawable5.getIntrinsicWidth();
                if (getSupportScale()) {
                    this.flatter.getAbsoluteScaleX();
                }
                this.flatter.getScaleX();
            }
        }
    }

    private final void drawWeatherState(Canvas canvas) {
        String str = this.state;
        if (str != null) {
            int i = Integer.parseInt(str);
            List<Drawable> list = this.stateNumDrawables;
            if (list == null || i < 0 || i >= list.size()) {
                return;
            }
            drawDrawable(canvas, list.get(i), this.stateNumPosition.x, this.stateNumPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        drawWeather(canvas);
    }

    @Override // com.dw.launcher.ui.clock.painter.ABasePainter, com.dw.launcher.ui.clock.painter.IBasePainter
    public void updateParams(Object... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        super.updateParams(Arrays.copyOf(params, params.length));
        this.state = (String) params[0];
        this.current = (String) params[1];
        this.low = (String) params[2];
        this.high = (String) params[3];
    }
}
