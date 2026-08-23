package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import com.android.launcher3.util.StepManager;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.dw.launcher.util.Utils;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: KmPainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b,\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010j\u001a\u0002062\u0006\u0010k\u001a\u00020\u00102\u0006\u0010l\u001a\u0002062\u0006\u0010m\u001a\u00020\u00102\u0006\u0010n\u001a\u000206H\u0002J \u0010o\u001a\u0002062\u0006\u0010p\u001a\u00020\u00102\u0006\u0010l\u001a\u0002062\u0006\u0010m\u001a\u00020\u0010H\u0002J \u0010q\u001a\u0002062\u0006\u0010p\u001a\u00020\u00102\u0006\u0010l\u001a\u0002062\u0006\u0010m\u001a\u00020\u0010H\u0002J\u001a\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020u2\b\u0010v\u001a\u0004\u0018\u00010wH\u0016J6\u0010x\u001a\u00020s2\u0006\u0010t\u001a\u00020u2\u0006\u0010y\u001a\u00020\b2\u0006\u0010p\u001a\u00020\u00102\u0006\u0010z\u001a\u0002062\u0006\u0010b\u001a\u00020c2\u0006\u0010f\u001a\u00020cJ\u000e\u0010{\u001a\u00020s2\u0006\u0010t\u001a\u00020uJ\u000e\u0010|\u001a\u00020s2\u0006\u0010t\u001a\u00020uR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\fR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010$\"\u0004\b.\u0010&R\"\u0010/\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001e\"\u0004\b1\u0010 R\u001a\u00102\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0012\"\u0004\b=\u0010\u0014R\u001a\u0010>\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0012\"\u0004\b@\u0010\u0014R\u001a\u0010A\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0012\"\u0004\bC\u0010\u0014R\u001a\u0010D\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0012\"\u0004\bF\u0010\u0014R\u001a\u0010G\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0012\"\u0004\bI\u0010\u0014R\u001a\u0010J\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00108\"\u0004\bL\u0010:R\u001a\u0010M\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00108\"\u0004\bO\u0010:R\u001a\u0010P\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00108\"\u0004\bR\u0010:R\u001a\u0010S\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u00108\"\u0004\bU\u0010:R\u001a\u0010V\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0012\"\u0004\bX\u0010\u0014R\u001a\u0010Y\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0012\"\u0004\b[\u0010\u0014R\u001a\u0010\\\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0012\"\u0004\b^\u0010\u0014R\u001a\u0010_\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0012\"\u0004\ba\u0010\u0014R\u0014\u0010b\u001a\u00020cX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0014\u0010f\u001a\u00020cX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bg\u0010eR\u0014\u0010h\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0012¨\u0006}"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/KmPainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "commaDrawable", "Landroid/graphics/drawable/Drawable;", "getCommaDrawable", "()Landroid/graphics/drawable/Drawable;", "setCommaDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getContext", "()Landroid/content/Context;", "distance", "", "getDistance", "()I", "setDistance", "(I)V", "distanceDrawable", "getDistanceDrawable", "setDistanceDrawable", "distanceEndDrawable", "getDistanceEndDrawable", "setDistanceEndDrawable", "distanceNumDrawable", "", "getDistanceNumDrawable", "()Ljava/util/List;", "setDistanceNumDrawable", "(Ljava/util/List;)V", "distanceNumPosition", "Landroid/graphics/Point;", "getDistanceNumPosition", "()Landroid/graphics/Point;", "setDistanceNumPosition", "(Landroid/graphics/Point;)V", "distancePosition", "getDistancePosition", "setDistancePosition", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "kmArcCenterPosition", "getKmArcCenterPosition", "setKmArcCenterPosition", "kmProgressDrawables", "getKmProgressDrawables", "setKmProgressDrawables", "kmProgressPosition", "getKmProgressPosition", "setKmProgressPosition", "mCircleR", "", "getMCircleR", "()D", "setMCircleR", "(D)V", "mCircleX", "getMCircleX", "setMCircleX", "mCircleY", "getMCircleY", "setMCircleY", "mExtraAngle", "getMExtraAngle", "setMExtraAngle", "mKmCommaHeight", "getMKmCommaHeight", "setMKmCommaHeight", "mKmCommaWidth", "getMKmCommaWidth", "setMKmCommaWidth", "mStartArc", "getMStartArc", "setMStartArc", "mSubArcComma", "getMSubArcComma", "setMSubArcComma", "mSubArcEnd", "getMSubArcEnd", "setMSubArcEnd", "mSubArcNum", "getMSubArcNum", "setMSubArcNum", "mkmCellHeight", "getMkmCellHeight", "setMkmCellHeight", "mkmCellWidth", "getMkmCellWidth", "setMkmCellWidth", "mkmEndHeight", "getMkmEndHeight", "setMkmEndHeight", "mkmEndWidth", "getMkmEndWidth", "setMkmEndWidth", "scaleX", "", "getScaleX", "()F", "scaleY", "getScaleY", "targetDistance", "getTargetDistance", "calculateSubArc", "wdith", "radius", "height", "tempLen", "calculateTempLen", "width", "calculateTempLen_180", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawByAngle", "drawable", "drawArc2", "drawKmHaveArc", "drawKmWithoutArc", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class KmPainter extends ABasePainter {
    private Drawable commaDrawable;
    private final Context context;
    private int distance;
    private Drawable distanceDrawable;
    private Drawable distanceEndDrawable;
    private List<? extends Drawable> distanceNumDrawable;
    private Point distanceNumPosition;
    private Point distancePosition;
    private final ClockConfigFlatter flatter;
    private Point kmArcCenterPosition;
    private List<? extends Drawable> kmProgressDrawables;
    private Point kmProgressPosition;
    private double mCircleR;
    private int mCircleX;
    private int mCircleY;
    private int mExtraAngle;
    private int mKmCommaHeight;
    private int mKmCommaWidth;
    private double mStartArc;
    private double mSubArcComma;
    private double mSubArcEnd;
    private double mSubArcNum;
    private int mkmCellHeight;
    private int mkmCellWidth;
    private int mkmEndHeight;
    private int mkmEndWidth;
    private final float scaleX;
    private final float scaleY;
    private final int targetDistance;

    public KmPainter(Context context, ClockConfigFlatter flatter) {
        float scaleX;
        float scaleX2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.targetDistance = 5000;
        this.distancePosition = new Point();
        this.distanceNumPosition = new Point();
        this.kmProgressPosition = new Point();
        this.kmArcCenterPosition = new Point();
        setSupportScale(flatter.getConfig().supportScale());
        if (flatter.getConfig().getShow_km_progress() == 1) {
            this.kmProgressDrawables = flatter.splitDrawable(flatter.getConfig().getKm_progress_src(), 11);
            flatter.setPosition(this.kmProgressPosition, flatter.getConfig().getKm_progress_x(), flatter.getConfig().getKm_progress_y());
        }
        this.distanceDrawable = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getKm_src(), false, 2, null);
        flatter.setPosition(this.distancePosition, flatter.getConfig().getKm_x(), flatter.getConfig().getKm_y());
        this.distanceNumDrawable = flatter.splitDrawable(flatter.getConfig().getKm_num_src(), 10);
        flatter.setPosition(this.distanceNumPosition, flatter.getConfig().getKm_num_x(), flatter.getConfig().getKm_num_y());
        this.distanceEndDrawable = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getKm_end_src(), false, 2, null);
        this.commaDrawable = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getKm_comma_src(), false, 2, null);
        if (flatter.getConfig().getOpen_km_arc_show() == 1) {
            flatter.setPosition(this.kmArcCenterPosition, flatter.getConfig().getKm_arc_center_x(), flatter.getConfig().getKm_arc_center_y());
            List<? extends Drawable> list = this.distanceNumDrawable;
            if (list != null) {
                this.mkmCellWidth = getSupportScale() ? (int) (list.get(0).getIntrinsicWidth() * flatter.getAbsoluteScaleX()) : list.get(0).getIntrinsicWidth();
                boolean supportScale = getSupportScale();
                int intrinsicHeight = list.get(0).getIntrinsicHeight();
                this.mkmCellHeight = supportScale ? (int) (intrinsicHeight * flatter.getAbsoluteScaleY()) : intrinsicHeight;
            }
            Drawable drawable = this.commaDrawable;
            if (drawable != null) {
                this.mKmCommaWidth = (int) ((getSupportScale() ? drawable.getIntrinsicWidth() * flatter.getAbsoluteScaleX() : drawable.getIntrinsicWidth()) * flatter.getScaleX());
                boolean supportScale2 = getSupportScale();
                float intrinsicHeight2 = drawable.getIntrinsicHeight();
                if (supportScale2) {
                    intrinsicHeight2 *= flatter.getAbsoluteScaleY();
                    scaleX2 = flatter.getScaleY();
                } else {
                    scaleX2 = flatter.getScaleX();
                }
                this.mKmCommaHeight = (int) (intrinsicHeight2 * scaleX2);
            }
            Drawable drawable2 = this.distanceEndDrawable;
            if (drawable2 != null) {
                this.mkmEndWidth = (int) ((getSupportScale() ? drawable2.getIntrinsicWidth() * flatter.getAbsoluteScaleX() : drawable2.getIntrinsicWidth()) * flatter.getScaleX());
                boolean supportScale3 = getSupportScale();
                float intrinsicHeight3 = drawable2.getIntrinsicHeight();
                if (supportScale3) {
                    intrinsicHeight3 *= flatter.getAbsoluteScaleY();
                    scaleX = flatter.getScaleY();
                } else {
                    scaleX = flatter.getScaleX();
                }
                this.mkmEndHeight = (int) (intrinsicHeight3 * scaleX);
            }
            int i = this.distanceNumPosition.x;
            int i2 = this.distanceNumPosition.y;
            this.mCircleX = this.kmArcCenterPosition.x;
            int i3 = this.kmArcCenterPosition.y;
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
            if (flatter.getConfig().getKm_arc_type() != 0) {
                this.mExtraAngle = PduHeaders.RECOMMENDED_RETRIEVAL_MODE;
                double d4 = this.mCircleR;
                double dCalculateTempLen_180 = calculateTempLen_180(this.mKmCommaWidth, d4, this.mKmCommaHeight);
                double dCalculateTempLen_181 = calculateTempLen_180(this.mkmCellWidth, this.mCircleR, this.mkmCellHeight);
                double dCalculateTempLen_182 = calculateTempLen_180(this.mkmEndWidth, this.mCircleR, this.mkmEndHeight);
                int i4 = this.mKmCommaWidth;
                int i5 = this.mKmCommaHeight;
                this.mSubArcComma = Math.acos((((((((double) i5) / 2.0d) + d4) * ((((double) i4) / 2.0d) + d4)) + (dCalculateTempLen_180 * dCalculateTempLen_180)) - (((((double) i4) / 2.0d) / 2.0d) * (((double) i4) / 2.0d))) / ((((((double) i5) / 2.0d) + d4) * 2.0d) * dCalculateTempLen_180));
                double d5 = (((double) this.mkmCellHeight) / 2.0d) + d4;
                int i6 = this.mkmCellWidth;
                this.mSubArcNum = Math.acos((((d5 * d5) + (dCalculateTempLen_181 * dCalculateTempLen_181)) - ((((double) i6) / 2.0d) * (((double) i6) / 2.0d))) / ((d5 * 2.0d) * dCalculateTempLen_181));
                double d6 = (((double) this.mkmEndHeight) / 2.0d) + d4;
                int i7 = this.mkmEndWidth;
                double dAcos2 = Math.acos((((d6 * d6) + (dCalculateTempLen_182 * dCalculateTempLen_182)) - ((((double) i7) / 2.0d) * (((double) i7) / 2.0d))) / ((d6 * 2.0d) * dCalculateTempLen_182));
                this.mSubArcNum = -this.mSubArcNum;
                this.mSubArcComma = -this.mSubArcComma;
                this.mSubArcEnd = -dAcos2;
            } else {
                this.mExtraAngle = 0;
                double d7 = this.mCircleR;
                double dCalculateTempLen = calculateTempLen(this.mkmCellWidth, d7, this.mkmCellHeight);
                double dCalculateTempLen2 = calculateTempLen(this.mKmCommaWidth, d7, this.mKmCommaHeight);
                double dCalculateTempLen3 = calculateTempLen(this.mkmEndWidth, d7, this.mkmEndHeight);
                this.mSubArcNum = calculateSubArc(this.mkmCellWidth, d7, this.mkmCellHeight, dCalculateTempLen);
                this.mSubArcComma = calculateSubArc(this.mKmCommaWidth, d7, this.mKmCommaHeight, dCalculateTempLen2);
                this.mSubArcEnd = calculateSubArc(this.mkmEndWidth, d7, this.mkmEndHeight, dCalculateTempLen3);
            }
        }
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public final int getTargetDistance() {
        return this.targetDistance;
    }

    public final int getDistance() {
        return this.distance;
    }

    public final void setDistance(int i) {
        this.distance = i;
    }

    public final Drawable getDistanceDrawable() {
        return this.distanceDrawable;
    }

    public final void setDistanceDrawable(Drawable drawable) {
        this.distanceDrawable = drawable;
    }

    public final Point getDistancePosition() {
        return this.distancePosition;
    }

    public final void setDistancePosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.distancePosition = point;
    }

    public final List<Drawable> getDistanceNumDrawable() {
        return this.distanceNumDrawable;
    }

    public final void setDistanceNumDrawable(List<? extends Drawable> list) {
        this.distanceNumDrawable = list;
    }

    public final Point getDistanceNumPosition() {
        return this.distanceNumPosition;
    }

    public final void setDistanceNumPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.distanceNumPosition = point;
    }

    public final Drawable getDistanceEndDrawable() {
        return this.distanceEndDrawable;
    }

    public final void setDistanceEndDrawable(Drawable drawable) {
        this.distanceEndDrawable = drawable;
    }

    public final Drawable getCommaDrawable() {
        return this.commaDrawable;
    }

    public final void setCommaDrawable(Drawable drawable) {
        this.commaDrawable = drawable;
    }

    public final List<Drawable> getKmProgressDrawables() {
        return this.kmProgressDrawables;
    }

    public final void setKmProgressDrawables(List<? extends Drawable> list) {
        this.kmProgressDrawables = list;
    }

    public final Point getKmProgressPosition() {
        return this.kmProgressPosition;
    }

    public final void setKmProgressPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.kmProgressPosition = point;
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

    public final int getMkmCellWidth() {
        return this.mkmCellWidth;
    }

    public final void setMkmCellWidth(int i) {
        this.mkmCellWidth = i;
    }

    public final int getMkmCellHeight() {
        return this.mkmCellHeight;
    }

    public final void setMkmCellHeight(int i) {
        this.mkmCellHeight = i;
    }

    public final int getMKmCommaHeight() {
        return this.mKmCommaHeight;
    }

    public final void setMKmCommaHeight(int i) {
        this.mKmCommaHeight = i;
    }

    public final int getMKmCommaWidth() {
        return this.mKmCommaWidth;
    }

    public final void setMKmCommaWidth(int i) {
        this.mKmCommaWidth = i;
    }

    public final int getMkmEndHeight() {
        return this.mkmEndHeight;
    }

    public final void setMkmEndHeight(int i) {
        this.mkmEndHeight = i;
    }

    public final int getMkmEndWidth() {
        return this.mkmEndWidth;
    }

    public final void setMkmEndWidth(int i) {
        this.mkmEndWidth = i;
    }

    public final double getMSubArcComma() {
        return this.mSubArcComma;
    }

    public final void setMSubArcComma(double d) {
        this.mSubArcComma = d;
    }

    public final double getMSubArcNum() {
        return this.mSubArcNum;
    }

    public final void setMSubArcNum(double d) {
        this.mSubArcNum = d;
    }

    public final double getMSubArcEnd() {
        return this.mSubArcEnd;
    }

    public final void setMSubArcEnd(double d) {
        this.mSubArcEnd = d;
    }

    public final Point getKmArcCenterPosition() {
        return this.kmArcCenterPosition;
    }

    public final void setKmArcCenterPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.kmArcCenterPosition = point;
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

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final void drawKmWithoutArc(Canvas canvas) {
        float intrinsicWidth;
        float intrinsicWidth2;
        float intrinsicWidth3;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable drawable = this.distanceDrawable;
        if (drawable != null) {
            drawDrawable(canvas, drawable, this.distancePosition.x, this.distancePosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        int step = StepManager.INSTANCE.getStep(this.context);
        if (step > 0) {
            this.distance = (int) (Utils.makeKm(step, 140, 63.0f) * 1000.0f);
        }
        List<? extends Drawable> list = this.distanceNumDrawable;
        if (list != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.ENGLISH, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(this.distance / 1000.0f)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            if (this.flatter.getConfig().getKm_keep_number_length() > 3 && str.length() < 5) {
                str = "0" + str;
            }
            if (this.distance >= 0) {
                ArrayList<Drawable> arrayList = new ArrayList();
                int length = str.length();
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    char cCharAt = str.charAt(i2);
                    if (cCharAt == '.') {
                        Drawable drawable2 = this.commaDrawable;
                        if (drawable2 != null) {
                            arrayList.add(drawable2);
                        }
                    } else {
                        arrayList.add(list.get(Integer.parseInt(String.valueOf(cCharAt)) % 10));
                    }
                }
                int i3 = this.distanceNumPosition.x;
                int i4 = this.distanceNumPosition.y;
                if (this.flatter.getConfig().getKm_show_type() == 1) {
                    float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX;
                    for (Drawable drawable3 : arrayList) {
                        if (Intrinsics.areEqual(drawable3, this.commaDrawable)) {
                            intrinsicWidth3 = drawable3.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX());
                        } else {
                            intrinsicWidth3 = drawable3.getIntrinsicWidth() * absoluteScaleX;
                        }
                        i3 -= (int) intrinsicWidth3;
                    }
                } else if (this.flatter.getConfig().getKm_show_type() == 2) {
                    float absoluteScaleX2 = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX;
                    for (Drawable drawable4 : arrayList) {
                        if (Intrinsics.areEqual(drawable4, this.commaDrawable)) {
                            intrinsicWidth = drawable4.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX());
                        } else {
                            intrinsicWidth = drawable4.getIntrinsicWidth() * absoluteScaleX2;
                        }
                        i += (int) intrinsicWidth;
                    }
                    i3 -= i / 2;
                }
                float absoluteScaleX3 = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX;
                float absoluteScaleY = getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scaleY;
                float absoluteScaleX4 = getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX();
                float absoluteScaleY2 = getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY();
                int i5 = i3;
                for (Drawable drawable5 : arrayList) {
                    drawDrawable(canvas, drawable5, i5, i4, Intrinsics.areEqual(drawable5, this.commaDrawable) ? absoluteScaleX4 : absoluteScaleX3, Intrinsics.areEqual(drawable5, this.commaDrawable) ? absoluteScaleY2 : absoluteScaleY);
                    if (Intrinsics.areEqual(drawable5, this.commaDrawable)) {
                        intrinsicWidth2 = drawable5.getIntrinsicWidth() * absoluteScaleX4;
                    } else {
                        intrinsicWidth2 = drawable5.getIntrinsicWidth() * absoluteScaleX3;
                    }
                    i5 += (int) intrinsicWidth2;
                }
                Drawable drawable6 = this.distanceEndDrawable;
                if (drawable6 != null) {
                    drawDrawable(canvas, drawable6, i5, i4, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                }
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

    public final void drawKmHaveArc(Canvas canvas) {
        double d;
        Drawable drawable;
        int i;
        float absoluteScaleX;
        double d2;
        double length;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int step = StepManager.INSTANCE.getStep(this.context);
        if (step > 0) {
            this.distance = (int) (Utils.makeKm(step, 140, 63.0f) * 1000.0f);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.ENGLISH, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(this.distance / 1000.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        if (this.flatter.getConfig().getKm_keep_number_length() > 3 && str.length() < 5) {
            str = "0" + str;
        }
        String str2 = str;
        int km_show_type = this.flatter.getConfig().getKm_show_type();
        if (km_show_type != 0) {
            if (km_show_type == 1) {
                d2 = this.mStartArc;
                length = ((((double) str2.length()) * this.mSubArcNum) + this.mSubArcEnd) * 2.0d;
            } else if (km_show_type != 2) {
                d = 0.0d;
            } else {
                d2 = this.mStartArc;
                length = (((double) str2.length()) * this.mSubArcNum) + this.mSubArcEnd;
            }
            d = d2 - length;
        } else {
            d = this.mStartArc;
        }
        double d3 = d + this.mSubArcNum;
        List<? extends Drawable> list = this.distanceNumDrawable;
        if (list != null) {
            int length2 = str2.length();
            double d4 = d3;
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt = str2.charAt(i2);
                if (cCharAt == '.') {
                    drawable = this.commaDrawable;
                } else {
                    drawable = list.get(cCharAt - '0');
                }
                if (cCharAt == '.') {
                    i = this.mKmCommaWidth;
                } else {
                    i = this.mkmCellWidth;
                }
                if (cCharAt == '.') {
                    absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX();
                } else {
                    absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : 1.0f;
                }
                float f = absoluteScaleX;
                Intrinsics.checkNotNull(drawable);
                drawByAngle(canvas, drawable, i, d4, f, f);
                d4 += ((double) 2) * this.mSubArcNum;
            }
            d3 = d4;
        }
        Drawable drawable2 = this.distanceEndDrawable;
        if (drawable2 != null) {
            double d5 = d3 + this.mSubArcNum + this.mSubArcEnd;
            double d6 = 1.5707963267948966d - d5;
            double dCos = ((double) this.mCircleX) + (this.mCircleR * Math.cos(d6));
            double dSin = ((double) this.mCircleY) - (this.mCircleR * Math.sin(d6));
            double d7 = (d5 * 180.0d) / 3.141592653589793d;
            float f2 = (float) dCos;
            float f3 = (float) dSin;
            canvas.rotate((float) (((double) this.mExtraAngle) + d7), f2, f3);
            drawDrawable(canvas, drawable2, (int) (dCos - (((double) this.mkmEndWidth) / 2.0d)), (int) dSin, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
            canvas.rotate(-((float) (d7 + ((double) this.mExtraAngle))), f2, f3);
        }
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        List<? extends Drawable> list = this.kmProgressDrawables;
        if (list != null) {
            int i = (this.distance * 100) / this.targetDistance;
            int i2 = 5;
            if (i >= 0 && i < 5) {
                i2 = 0;
            } else if (i >= 0 && i < 15) {
                i2 = 1;
            } else if (i >= 0 && i < 25) {
                i2 = 2;
            } else if (i >= 0 && i < 35) {
                i2 = 3;
            } else if (i >= 0 && i < 45) {
                i2 = 4;
            } else if (i < 0 || i >= 55) {
                if (i >= 0 && i < 65) {
                    i2 = 6;
                } else if (i >= 0 && i < 75) {
                    i2 = 7;
                } else if (i < 0 || i >= 85) {
                    i2 = (i < 0 || i >= 95) ? 10 : 9;
                } else {
                    i2 = 8;
                }
            }
            drawDrawable(canvas, list.get(i2), this.kmProgressPosition.x, this.kmProgressPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : 1.0f, getSupportScale() ? this.flatter.getAbsoluteScaleY() : 1.0f);
        }
        if (this.flatter.getConfig().getOpen_km_arc_show() == 0) {
            drawKmWithoutArc(canvas);
        } else {
            drawKmHaveArc(canvas);
        }
    }
}
