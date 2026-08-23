package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import com.android.launcher3.util.StepManager;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.dw.launcher.util.Utils;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CaloriesPainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b,\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010V\u001a\u00020\"2\u0006\u0010W\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020\"2\u0006\u0010Y\u001a\u00020\u001c2\u0006\u0010Z\u001a\u00020\"H\u0002J \u0010[\u001a\u00020\"2\u0006\u0010\\\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020\"2\u0006\u0010Y\u001a\u00020\u001cH\u0002J \u0010]\u001a\u00020\"2\u0006\u0010\\\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020\"2\u0006\u0010Y\u001a\u00020\u001cH\u0002J\u001a\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\u000e\u0010d\u001a\u00020_2\u0006\u0010`\u001a\u00020aJ\u000e\u0010e\u001a\u00020_2\u0006\u0010`\u001a\u00020aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001a\u0010*\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u001a\u0010-\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R\u001a\u00100\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&R\u001a\u00103\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&R\u001a\u00106\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010$\"\u0004\b8\u0010&R\u001a\u00109\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010$\"\u0004\b;\u0010&R\u001a\u0010<\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001e\"\u0004\b>\u0010 R\u001a\u0010?\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001e\"\u0004\bA\u0010 R\u001a\u0010B\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010 R\u001a\u0010E\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001e\"\u0004\bG\u0010 R\u001a\u0010H\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001e\"\u0004\bJ\u0010 R\u001a\u0010K\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u001e\"\u0004\bM\u0010 R\u0014\u0010N\u001a\u00020OX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0014\u0010R\u001a\u00020OX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bS\u0010QR\u0014\u0010T\u001a\u00020\u001cX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u001e¨\u0006f"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/CaloriesPainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "getContext", "()Landroid/content/Context;", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "kcalArcCenterPosition", "Landroid/graphics/Point;", "getKcalArcCenterPosition", "()Landroid/graphics/Point;", "setKcalArcCenterPosition", "(Landroid/graphics/Point;)V", "kcalProgressDrawables", "", "Landroid/graphics/drawable/Drawable;", "getKcalProgressDrawables", "()Ljava/util/List;", "setKcalProgressDrawables", "(Ljava/util/List;)V", "kcalProgressPosition", "getKcalProgressPosition", "setKcalProgressPosition", "mCalories", "", "getMCalories", "()I", "setMCalories", "(I)V", "mCircleR", "", "getMCircleR", "()D", "setMCircleR", "(D)V", "mCircleX", "getMCircleX", "setMCircleX", "mCircleY", "getMCircleY", "setMCircleY", "mExtraAngle", "getMExtraAngle", "setMExtraAngle", "mStartArc", "getMStartArc", "setMStartArc", "mSubArcEnd", "getMSubArcEnd", "setMSubArcEnd", "mSubArcIcon", "getMSubArcIcon", "setMSubArcIcon", "mSubArcNum", "getMSubArcNum", "setMSubArcNum", "mkcalCellHeight", "getMkcalCellHeight", "setMkcalCellHeight", "mkcalCellWidth", "getMkcalCellWidth", "setMkcalCellWidth", "mkcalEndHeight", "getMkcalEndHeight", "setMkcalEndHeight", "mkcalEndWidth", "getMkcalEndWidth", "setMkcalEndWidth", "mkcalHeight", "getMkcalHeight", "setMkcalHeight", "mkcalWidth", "getMkcalWidth", "setMkcalWidth", "scaleX", "", "getScaleX", "()F", "scaleY", "getScaleY", "targetKCal", "getTargetKCal", "calculateSubArc", "wdith", "radius", "height", "tempLen", "calculateTempLen", "width", "calculateTempLen_180", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawkcalHaveArc", "drawkcalWithoutArc", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class CaloriesPainter extends ABasePainter {
    private final Context context;
    private final ClockConfigFlatter flatter;
    private Point kcalArcCenterPosition;
    private List<? extends Drawable> kcalProgressDrawables;
    private Point kcalProgressPosition;
    private int mCalories;
    private double mCircleR;
    private int mCircleX;
    private int mCircleY;
    private int mExtraAngle;
    private double mStartArc;
    private double mSubArcEnd;
    private double mSubArcIcon;
    private double mSubArcNum;
    private int mkcalCellHeight;
    private int mkcalCellWidth;
    private int mkcalEndHeight;
    private int mkcalEndWidth;
    private int mkcalHeight;
    private int mkcalWidth;
    private final float scaleX;
    private final float scaleY;
    private final int targetKCal;

    public CaloriesPainter(Context context, ClockConfigFlatter flatter) {
        float scaleX;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.kcalProgressPosition = new Point();
        this.targetKCal = 300;
        this.kcalArcCenterPosition = new Point();
        setSupportScale(flatter.getConfig().supportScale());
        if (flatter.getConfig().getShow_kcal_progress() == 1) {
            this.kcalProgressDrawables = flatter.splitDrawable(flatter.getConfig().getKcal_progress_src(), 11);
            flatter.setPosition(this.kcalProgressPosition, flatter.getConfig().getKcal_progress_x(), flatter.getConfig().getKcal_progress_y());
        }
        Drawable caloriesDrawable = flatter.getCaloriesDrawable();
        if (caloriesDrawable != null) {
            this.mkcalWidth = (int) ((getSupportScale() ? caloriesDrawable.getIntrinsicWidth() * flatter.getAbsoluteScaleX() : caloriesDrawable.getIntrinsicWidth()) * flatter.getScaleX());
            boolean supportScale = getSupportScale();
            float intrinsicHeight = caloriesDrawable.getIntrinsicHeight();
            if (supportScale) {
                intrinsicHeight *= flatter.getAbsoluteScaleY();
                scaleX = flatter.getScaleY();
            } else {
                scaleX = flatter.getScaleX();
            }
            this.mkcalHeight = (int) (intrinsicHeight * scaleX);
        }
        List<Drawable> caloriesNumDrawable = flatter.getCaloriesNumDrawable();
        if (caloriesNumDrawable != null) {
            this.mkcalCellWidth = getSupportScale() ? (int) (caloriesNumDrawable.get(0).getIntrinsicWidth() * flatter.getAbsoluteScaleX()) : caloriesNumDrawable.get(0).getIntrinsicWidth();
            boolean supportScale2 = getSupportScale();
            int intrinsicHeight2 = caloriesNumDrawable.get(0).getIntrinsicHeight();
            this.mkcalCellHeight = supportScale2 ? (int) (intrinsicHeight2 * flatter.getAbsoluteScaleY()) : intrinsicHeight2;
        }
        if (flatter.getConfig().getOpen_kcal_arc_show() != 0) {
            flatter.setPosition(this.kcalArcCenterPosition, flatter.getConfig().getKcal_arc_center_x(), flatter.getConfig().getKcal_arc_center_y());
            int i = flatter.getCaloriesNumPosition().x;
            int i2 = flatter.getCaloriesNumPosition().y;
            this.mCircleX = this.kcalArcCenterPosition.x;
            int i3 = this.kcalArcCenterPosition.y;
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
            if (flatter.getConfig().getKcal_arc_type() != 0) {
                this.mExtraAngle = PduHeaders.RECOMMENDED_RETRIEVAL_MODE;
                double d4 = this.mCircleR;
                double dCalculateTempLen_180 = calculateTempLen_180(this.mkcalWidth, d4, this.mkcalHeight);
                double dCalculateTempLen_181 = calculateTempLen_180(this.mkcalCellWidth, this.mCircleR, this.mkcalCellHeight);
                double dCalculateTempLen_182 = calculateTempLen_180(this.mkcalEndWidth, this.mCircleR, this.mkcalEndHeight);
                int i4 = this.mkcalWidth;
                int i5 = this.mkcalHeight;
                this.mSubArcIcon = Math.acos((((((((double) i5) / 2.0d) + d4) * ((((double) i4) / 2.0d) + d4)) + (dCalculateTempLen_180 * dCalculateTempLen_180)) - (((((double) i4) / 2.0d) / 2.0d) * (((double) i4) / 2.0d))) / ((((((double) i5) / 2.0d) + d4) * 2.0d) * dCalculateTempLen_180));
                double d5 = (((double) this.mkcalCellHeight) / 2.0d) + d4;
                int i6 = this.mkcalCellWidth;
                this.mSubArcNum = Math.acos((((d5 * d5) + (dCalculateTempLen_181 * dCalculateTempLen_181)) - ((((double) i6) / 2.0d) * (((double) i6) / 2.0d))) / ((d5 * 2.0d) * dCalculateTempLen_181));
                double d6 = (((double) this.mkcalEndHeight) / 2.0d) + d4;
                int i7 = this.mkcalCellWidth;
                double dAcos2 = Math.acos((((d6 * d6) + (dCalculateTempLen_182 * dCalculateTempLen_182)) - ((((double) i7) / 2.0d) * (((double) i7) / 2.0d))) / ((d6 * 2.0d) * dCalculateTempLen_182));
                this.mSubArcIcon = -this.mSubArcIcon;
                this.mSubArcNum = -this.mSubArcNum;
                this.mSubArcEnd = -dAcos2;
                return;
            }
            this.mExtraAngle = 0;
            double d7 = this.mCircleR;
            double dCalculateTempLen = calculateTempLen(this.mkcalWidth, d7, this.mkcalHeight);
            double dCalculateTempLen2 = calculateTempLen(this.mkcalCellWidth, d7, this.mkcalCellHeight);
            double dCalculateTempLen3 = calculateTempLen(this.mkcalEndWidth, d7, this.mkcalEndHeight);
            this.mSubArcIcon = calculateSubArc(this.mkcalWidth, d7, this.mkcalHeight, dCalculateTempLen);
            this.mSubArcNum = calculateSubArc(this.mkcalCellWidth, d7, this.mkcalCellHeight, dCalculateTempLen2);
            this.mSubArcEnd = calculateSubArc(this.mkcalEndWidth, d7, this.mkcalEndHeight, dCalculateTempLen3);
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public final int getMCalories() {
        return this.mCalories;
    }

    public final void setMCalories(int i) {
        this.mCalories = i;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final List<Drawable> getKcalProgressDrawables() {
        return this.kcalProgressDrawables;
    }

    public final void setKcalProgressDrawables(List<? extends Drawable> list) {
        this.kcalProgressDrawables = list;
    }

    public final Point getKcalProgressPosition() {
        return this.kcalProgressPosition;
    }

    public final void setKcalProgressPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.kcalProgressPosition = point;
    }

    public final int getTargetKCal() {
        return this.targetKCal;
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

    public final int getMkcalWidth() {
        return this.mkcalWidth;
    }

    public final void setMkcalWidth(int i) {
        this.mkcalWidth = i;
    }

    public final int getMkcalHeight() {
        return this.mkcalHeight;
    }

    public final void setMkcalHeight(int i) {
        this.mkcalHeight = i;
    }

    public final int getMkcalCellWidth() {
        return this.mkcalCellWidth;
    }

    public final void setMkcalCellWidth(int i) {
        this.mkcalCellWidth = i;
    }

    public final int getMkcalCellHeight() {
        return this.mkcalCellHeight;
    }

    public final void setMkcalCellHeight(int i) {
        this.mkcalCellHeight = i;
    }

    public final int getMkcalEndHeight() {
        return this.mkcalEndHeight;
    }

    public final void setMkcalEndHeight(int i) {
        this.mkcalEndHeight = i;
    }

    public final int getMkcalEndWidth() {
        return this.mkcalEndWidth;
    }

    public final void setMkcalEndWidth(int i) {
        this.mkcalEndWidth = i;
    }

    public final double getMSubArcIcon() {
        return this.mSubArcIcon;
    }

    public final void setMSubArcIcon(double d) {
        this.mSubArcIcon = d;
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

    public final Point getKcalArcCenterPosition() {
        return this.kcalArcCenterPosition;
    }

    public final void setKcalArcCenterPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.kcalArcCenterPosition = point;
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

    public final void drawkcalWithoutArc(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        ClockConfig config = this.flatter.getConfig();
        Drawable caloriesDrawable = this.flatter.getCaloriesDrawable();
        if (caloriesDrawable != null) {
            drawDrawable(canvas, caloriesDrawable, this.flatter.getCaloriesPosition().x, this.flatter.getCaloriesPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        int step = StepManager.INSTANCE.getStep(this.context);
        if (step > 0) {
            this.mCalories = (int) Utils.makeKcal(Utils.makeKm(step, 140, 63.0f), 33.0f);
        }
        List<Drawable> caloriesNumDrawable = this.flatter.getCaloriesNumDrawable();
        if (caloriesNumDrawable != null) {
            int intrinsicWidth = this.flatter.getCaloriesNumPosition().x;
            int intrinsicWidth2 = this.flatter.getCaloriesNumPosition().y;
            int intrinsicWidth3 = 0;
            if (this.flatter.getConfig().getKcal_num_rotate() == 1) {
                canvas.save();
                float kcal_num_rotate_degree = this.flatter.getConfig().getKcal_num_rotate_degree();
                float f = intrinsicWidth;
                Drawable drawable = caloriesNumDrawable.get(0);
                Integer numValueOf = drawable != null ? Integer.valueOf(drawable.getIntrinsicWidth()) : null;
                Intrinsics.checkNotNull(numValueOf);
                canvas.rotate(kcal_num_rotate_degree, f + ((numValueOf.intValue() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() : 1.0f)) / 2), intrinsicWidth2);
            }
            if (this.mCalories >= 0) {
                ArrayList<Drawable> arrayList = new ArrayList();
                for (int i = this.mCalories; i >= 0; i /= 10) {
                    arrayList.add(0, caloriesNumDrawable.get(i % 10));
                    if (i < 10) {
                        break;
                    }
                }
                int kcal_keep_number_length = this.flatter.getConfig().getKcal_keep_number_length();
                while (arrayList.size() < kcal_keep_number_length) {
                    arrayList.add(0, caloriesNumDrawable.get(0));
                }
                float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX;
                float absoluteScaleY = getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scaleY;
                if (config.getKcal_show_type() != 1) {
                    if (config.getKcal_show_type() == 2) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            intrinsicWidth3 += (int) (((Drawable) it.next()).getIntrinsicWidth() * absoluteScaleX);
                        }
                        if (this.flatter.getConfig().getKcal_num_type() == 2) {
                            intrinsicWidth2 -= intrinsicWidth3 / 2;
                        } else {
                            intrinsicWidth -= intrinsicWidth3 / 2;
                        }
                    }
                } else {
                    for (Drawable drawable2 : arrayList) {
                        if (this.flatter.getConfig().getKcal_num_type() == 2) {
                            intrinsicWidth2 -= (int) (drawable2.getIntrinsicWidth() * absoluteScaleX);
                        } else {
                            intrinsicWidth -= (int) (drawable2.getIntrinsicWidth() * absoluteScaleX);
                        }
                    }
                }
                int intrinsicWidth4 = intrinsicWidth;
                int intrinsicWidth5 = intrinsicWidth2;
                for (Drawable drawable3 : arrayList) {
                    if (this.flatter.getConfig().getKcal_num_type() == 2) {
                        canvas.rotate(90.0f, intrinsicWidth4, intrinsicWidth5);
                    }
                    drawDrawable(canvas, drawable3, intrinsicWidth4, intrinsicWidth5, absoluteScaleX, absoluteScaleY);
                    if (this.flatter.getConfig().getKcal_num_type() == 2) {
                        canvas.rotate(-90.0f, intrinsicWidth4, intrinsicWidth5);
                        intrinsicWidth5 += (int) (drawable3.getIntrinsicWidth() * absoluteScaleX);
                    } else {
                        intrinsicWidth4 += (int) (drawable3.getIntrinsicWidth() * absoluteScaleX);
                    }
                }
                if (this.flatter.getConfig().getKcal_num_rotate() == 1) {
                    canvas.restore();
                }
                Drawable caloriesEndDrawable = this.flatter.getCaloriesEndDrawable();
                if (caloriesEndDrawable != null) {
                    drawDrawable(canvas, caloriesEndDrawable, intrinsicWidth4, intrinsicWidth5, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                }
            }
        }
    }

    public final void drawkcalHaveArc(Canvas canvas) {
        double d;
        double d2;
        double length;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.flatter.getConfig();
        Drawable caloriesDrawable = this.flatter.getCaloriesDrawable();
        if (caloriesDrawable != null) {
            drawDrawable(canvas, caloriesDrawable, this.flatter.getCaloriesPosition().x, this.flatter.getCaloriesPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        int step = StepManager.INSTANCE.getStep(this.context);
        if (step > 0) {
            this.mCalories = (int) Utils.makeKcal(Utils.makeKm(step, 140, 63.0f), 33.0f);
        }
        String strPadStart = StringsKt.padStart(String.valueOf(this.mCalories), RangesKt.coerceAtLeast(this.flatter.getConfig().getKcal_keep_number_length(), 1), '0');
        int kcal_show_type = this.flatter.getConfig().getKcal_show_type();
        if (kcal_show_type != 0) {
            if (kcal_show_type == 1) {
                d2 = this.mStartArc;
                length = ((((double) strPadStart.length()) * this.mSubArcNum) + this.mSubArcEnd) * 2.0d;
            } else if (kcal_show_type != 2) {
                d = 0.0d;
            } else {
                d2 = this.mStartArc;
                length = (((double) strPadStart.length()) * this.mSubArcNum) + this.mSubArcEnd;
            }
            d = d2 - length;
        } else {
            d = this.mStartArc;
        }
        double d3 = d + this.mSubArcNum;
        List<Drawable> caloriesNumDrawable = this.flatter.getCaloriesNumDrawable();
        double d4 = 3.141592653589793d;
        if (caloriesNumDrawable != null) {
            float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX;
            float absoluteScaleY = getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scaleY;
            int length2 = strPadStart.length();
            int i = 0;
            while (i < length2) {
                if (i > 0) {
                    d3 += this.mSubArcNum * 2.0d;
                }
                double d5 = d3;
                double d6 = 1.5707963267948966d - d5;
                double dCos = ((double) this.mCircleX) + (this.mCircleR * Math.cos(d6));
                String str = strPadStart;
                double dSin = ((double) this.mCircleY) - (this.mCircleR * Math.sin(d6));
                double d7 = (d5 * 180.0d) / d4;
                float f = (float) dCos;
                float f2 = (float) dSin;
                canvas.rotate((float) (((double) this.mExtraAngle) + d7), f, f2);
                double d8 = dCos - (((double) this.mkcalCellWidth) / 2.0d);
                Drawable drawable = caloriesNumDrawable.get(str.charAt(i) - '0');
                Intrinsics.checkNotNull(drawable);
                drawDrawable(canvas, drawable, (int) d8, (int) dSin, absoluteScaleX, absoluteScaleY);
                canvas.rotate(-((float) (d7 + ((double) this.mExtraAngle))), f, f2);
                i++;
                strPadStart = str;
                d3 = d5;
                length2 = length2;
                d4 = 3.141592653589793d;
            }
        }
        Drawable caloriesEndDrawable = this.flatter.getCaloriesEndDrawable();
        if (caloriesEndDrawable != null) {
            double d9 = d3 + this.mSubArcNum + this.mSubArcEnd;
            double d10 = 1.5707963267948966d - d9;
            double dCos2 = ((double) this.mCircleX) + (this.mCircleR * Math.cos(d10));
            double dSin2 = ((double) this.mCircleY) - (this.mCircleR * Math.sin(d10));
            double d11 = (d9 * 180.0d) / 3.141592653589793d;
            float f3 = (float) dCos2;
            float f4 = (float) dSin2;
            canvas.rotate((float) (((double) this.mExtraAngle) + d11), f3, f4);
            drawDrawable(canvas, caloriesEndDrawable, (int) (dCos2 - (((double) this.mkcalEndWidth) / 2.0d)), (int) dSin2, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
            canvas.rotate(-((float) (d11 + ((double) this.mExtraAngle))), f3, f4);
        }
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int open_kcal_arc_show = this.flatter.getConfig().getOpen_kcal_arc_show();
        List<? extends Drawable> list = this.kcalProgressDrawables;
        if (list != null) {
            int i = (this.mCalories * 100) / this.targetKCal;
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
            drawDrawable(canvas, list.get(i2), this.kcalProgressPosition.x, this.kcalProgressPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : 1.0f, getSupportScale() ? this.flatter.getAbsoluteScaleY() : 1.0f);
        }
        if (open_kcal_arc_show == 0) {
            drawkcalWithoutArc(canvas);
        } else {
            drawkcalHaveArc(canvas);
        }
    }
}
