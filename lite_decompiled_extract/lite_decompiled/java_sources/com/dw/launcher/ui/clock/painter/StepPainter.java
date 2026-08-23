package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import com.android.launcher3.util.StepManager;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: StepPainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010T\u001a\u00020\f2\u0006\u0010U\u001a\u00020\u00122\u0006\u0010V\u001a\u00020\f2\u0006\u0010W\u001a\u00020\u00122\u0006\u0010X\u001a\u00020\fH\u0002J \u0010Y\u001a\u00020\f2\u0006\u0010Z\u001a\u00020\u00122\u0006\u0010V\u001a\u00020\f2\u0006\u0010W\u001a\u00020\u0012H\u0002J \u0010[\u001a\u00020\f2\u0006\u0010Z\u001a\u00020\u00122\u0006\u0010V\u001a\u00020\f2\u0006\u0010W\u001a\u00020\u0012H\u0002J\u001a\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0010\u0010b\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010c\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010d\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001a\u0010 \u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010#\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001a\u0010)\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001a\u0010/\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u0016R\u001a\u00102\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u0016R\u001a\u00105\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u000e\"\u0004\b7\u0010\u0010R\u001a\u00108\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000e\"\u0004\b:\u0010\u0010R\u001a\u0010;\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000e\"\u0004\b=\u0010\u0010R\u0014\u0010>\u001a\u00020?X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010H\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010E\"\u0004\bQ\u0010GR\u0014\u0010R\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0014¨\u0006e"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/StepPainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "getContext", "()Landroid/content/Context;", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "mCircleR", "", "getMCircleR", "()D", "setMCircleR", "(D)V", "mCircleX", "", "getMCircleX", "()I", "setMCircleX", "(I)V", "mCircleY", "getMCircleY", "setMCircleY", "mExtraAngle", "getMExtraAngle", "setMExtraAngle", "mStartArc", "getMStartArc", "setMStartArc", "mStep", "getMStep", "setMStep", "mStepCellHeight", "getMStepCellHeight", "setMStepCellHeight", "mStepCellWidth", "getMStepCellWidth", "setMStepCellWidth", "mStepEndHeight", "getMStepEndHeight", "setMStepEndHeight", "mStepEndWidth", "getMStepEndWidth", "setMStepEndWidth", "mStepHeight", "getMStepHeight", "setMStepHeight", "mStepWidth", "getMStepWidth", "setMStepWidth", "mSubArcEnd", "getMSubArcEnd", "setMSubArcEnd", "mSubArcIcon", "getMSubArcIcon", "setMSubArcIcon", "mSubArcNum", "getMSubArcNum", "setMSubArcNum", "scale", "", "getScale", "()F", "stepArcCenterPosition", "Landroid/graphics/Point;", "getStepArcCenterPosition", "()Landroid/graphics/Point;", "setStepArcCenterPosition", "(Landroid/graphics/Point;)V", "stepProgressDrawables", "", "Landroid/graphics/drawable/Drawable;", "getStepProgressDrawables", "()Ljava/util/List;", "setStepProgressDrawables", "(Ljava/util/List;)V", "stepProgressPosition", "getStepProgressPosition", "setStepProgressPosition", "targetStep", "getTargetStep", "calculateSubArc", "wdith", "radius", "height", "tempLen", "calculateTempLen", "width", "calculateTempLen_180", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawStepFollowNumOne", "drawStepWithArc", "drawStepWithoutArc", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class StepPainter extends ABasePainter {
    private final Context context;
    private final ClockConfigFlatter flatter;
    private double mCircleR;
    private int mCircleX;
    private int mCircleY;
    private int mExtraAngle;
    private double mStartArc;
    private int mStep;
    private int mStepCellHeight;
    private int mStepCellWidth;
    private int mStepEndHeight;
    private int mStepEndWidth;
    private int mStepHeight;
    private int mStepWidth;
    private double mSubArcEnd;
    private double mSubArcIcon;
    private double mSubArcNum;
    private final float scale;
    private Point stepArcCenterPosition;
    private List<? extends Drawable> stepProgressDrawables;
    private Point stepProgressPosition;
    private final int targetStep;

    private final void drawStepFollowNumOne(Canvas canvas) {
    }

    public StepPainter(Context context, ClockConfigFlatter flatter) {
        float scaleX;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.scale = 1.0f;
        this.targetStep = 10000;
        this.stepProgressPosition = new Point();
        this.stepArcCenterPosition = new Point();
        setSupportScale(flatter.getConfig().supportScale());
        if (flatter.getConfig().getShow_step_progress() == 1) {
            this.stepProgressDrawables = flatter.splitDrawable(flatter.getConfig().getStep_progress_src(), 11);
            flatter.setPosition(this.stepProgressPosition, flatter.getConfig().getStep_progress_x(), flatter.getConfig().getStep_progress_y());
        }
        Drawable stepDrawable = flatter.getStepDrawable();
        if (stepDrawable != null) {
            this.mStepWidth = (int) ((getSupportScale() ? stepDrawable.getIntrinsicWidth() * flatter.getAbsoluteScaleX() : stepDrawable.getIntrinsicWidth()) * flatter.getScaleX());
            boolean supportScale = getSupportScale();
            float intrinsicHeight = stepDrawable.getIntrinsicHeight();
            if (supportScale) {
                intrinsicHeight *= flatter.getAbsoluteScaleY();
                scaleX = flatter.getScaleY();
            } else {
                scaleX = flatter.getScaleX();
            }
            this.mStepHeight = (int) (intrinsicHeight * scaleX);
        }
        List<Drawable> stepNumDrawable = flatter.getStepNumDrawable();
        if (stepNumDrawable != null) {
            this.mStepCellWidth = getSupportScale() ? (int) (stepNumDrawable.get(0).getIntrinsicWidth() * flatter.getAbsoluteScaleX()) : stepNumDrawable.get(0).getIntrinsicWidth();
            boolean supportScale2 = getSupportScale();
            int intrinsicHeight2 = stepNumDrawable.get(0).getIntrinsicHeight();
            this.mStepCellHeight = supportScale2 ? (int) (intrinsicHeight2 * flatter.getAbsoluteScaleY()) : intrinsicHeight2;
        }
        if (flatter.getConfig().getOpen_step_arc_show() != 0) {
            flatter.setPosition(this.stepArcCenterPosition, flatter.getConfig().getStep_arc_center_x(), flatter.getConfig().getStep_arc_center_y());
            int i = flatter.getStepNumPosition().x;
            int i2 = flatter.getStepNumPosition().y;
            this.mCircleX = this.stepArcCenterPosition.x;
            int i3 = this.stepArcCenterPosition.y;
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
            if (flatter.getConfig().getStep_arc_type() != 0) {
                this.mExtraAngle = PduHeaders.RECOMMENDED_RETRIEVAL_MODE;
                double d4 = this.mCircleR;
                double dCalculateTempLen_180 = calculateTempLen_180(this.mStepWidth, d4, this.mStepHeight);
                double dCalculateTempLen_181 = calculateTempLen_180(this.mStepCellWidth, this.mCircleR, this.mStepCellHeight);
                double dCalculateTempLen_182 = calculateTempLen_180(this.mStepEndWidth, this.mCircleR, this.mStepEndHeight);
                int i4 = this.mStepWidth;
                int i5 = this.mStepHeight;
                this.mSubArcIcon = Math.acos((((((((double) i5) / 2.0d) + d4) * ((((double) i4) / 2.0d) + d4)) + (dCalculateTempLen_180 * dCalculateTempLen_180)) - (((((double) i4) / 2.0d) / 2.0d) * (((double) i4) / 2.0d))) / ((((((double) i5) / 2.0d) + d4) * 2.0d) * dCalculateTempLen_180));
                double d5 = (((double) this.mStepCellHeight) / 2.0d) + d4;
                int i6 = this.mStepCellWidth;
                this.mSubArcNum = Math.acos((((d5 * d5) + (dCalculateTempLen_181 * dCalculateTempLen_181)) - ((((double) i6) / 2.0d) * (((double) i6) / 2.0d))) / ((d5 * 2.0d) * dCalculateTempLen_181));
                double d6 = (((double) this.mStepEndHeight) / 2.0d) + d4;
                int i7 = this.mStepCellWidth;
                double dAcos2 = Math.acos((((d6 * d6) + (dCalculateTempLen_182 * dCalculateTempLen_182)) - ((((double) i7) / 2.0d) * (((double) i7) / 2.0d))) / ((d6 * 2.0d) * dCalculateTempLen_182));
                this.mSubArcIcon = -this.mSubArcIcon;
                this.mSubArcNum = -this.mSubArcNum;
                this.mSubArcEnd = -dAcos2;
                return;
            }
            this.mExtraAngle = 0;
            double d7 = this.mCircleR;
            double dCalculateTempLen = calculateTempLen(this.mStepWidth, d7, this.mStepHeight);
            double dCalculateTempLen2 = calculateTempLen(this.mStepCellWidth, d7, this.mStepCellHeight);
            double dCalculateTempLen3 = calculateTempLen(this.mStepEndWidth, d7, this.mStepEndHeight);
            this.mSubArcIcon = calculateSubArc(this.mStepWidth, d7, this.mStepHeight, dCalculateTempLen);
            this.mSubArcNum = calculateSubArc(this.mStepCellWidth, d7, this.mStepCellHeight, dCalculateTempLen2);
            this.mSubArcEnd = calculateSubArc(this.mStepEndWidth, d7, this.mStepEndHeight, dCalculateTempLen3);
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public final int getMStep() {
        return this.mStep;
    }

    public final void setMStep(int i) {
        this.mStep = i;
    }

    public final float getScale() {
        return this.scale;
    }

    public final int getTargetStep() {
        return this.targetStep;
    }

    public final List<Drawable> getStepProgressDrawables() {
        return this.stepProgressDrawables;
    }

    public final void setStepProgressDrawables(List<? extends Drawable> list) {
        this.stepProgressDrawables = list;
    }

    public final Point getStepProgressPosition() {
        return this.stepProgressPosition;
    }

    public final void setStepProgressPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.stepProgressPosition = point;
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

    public final int getMStepWidth() {
        return this.mStepWidth;
    }

    public final void setMStepWidth(int i) {
        this.mStepWidth = i;
    }

    public final int getMStepHeight() {
        return this.mStepHeight;
    }

    public final void setMStepHeight(int i) {
        this.mStepHeight = i;
    }

    public final int getMStepCellWidth() {
        return this.mStepCellWidth;
    }

    public final void setMStepCellWidth(int i) {
        this.mStepCellWidth = i;
    }

    public final int getMStepCellHeight() {
        return this.mStepCellHeight;
    }

    public final void setMStepCellHeight(int i) {
        this.mStepCellHeight = i;
    }

    public final int getMStepEndHeight() {
        return this.mStepEndHeight;
    }

    public final void setMStepEndHeight(int i) {
        this.mStepEndHeight = i;
    }

    public final int getMStepEndWidth() {
        return this.mStepEndWidth;
    }

    public final void setMStepEndWidth(int i) {
        this.mStepEndWidth = i;
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

    public final Point getStepArcCenterPosition() {
        return this.stepArcCenterPosition;
    }

    public final void setStepArcCenterPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.stepArcCenterPosition = point;
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

    private final void drawStepWithoutArc(Canvas canvas) {
        ClockConfig config = this.flatter.getConfig();
        Drawable stepDrawable = this.flatter.getStepDrawable();
        if (stepDrawable != null) {
            drawDrawable(canvas, stepDrawable, this.flatter.getStepPosition().x, this.flatter.getStepPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        this.mStep = StepManager.INSTANCE.getStep(this.context);
        List<Drawable> stepNumDrawable = this.flatter.getStepNumDrawable();
        if (stepNumDrawable == null || this.mStep < 0) {
            return;
        }
        int intrinsicWidth = this.flatter.getStepNumPosition().x;
        int i = this.flatter.getStepNumPosition().y;
        float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scale;
        float absoluteScaleY = getSupportScale() ? this.flatter.getAbsoluteScaleY() : absoluteScaleX;
        int intrinsicWidth2 = 0;
        if (this.flatter.getConfig().getStep_num_rotate() == 1) {
            canvas.save();
            float step_num_rotate_degree = this.flatter.getConfig().getStep_num_rotate_degree();
            float f = intrinsicWidth;
            Drawable drawable = stepNumDrawable.get(0);
            Integer numValueOf = drawable != null ? Integer.valueOf(drawable.getIntrinsicWidth()) : null;
            Intrinsics.checkNotNull(numValueOf);
            canvas.rotate(step_num_rotate_degree, f + ((numValueOf.intValue() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() : 1.0f)) / 2), i);
        }
        ArrayList<Drawable> arrayList = new ArrayList();
        for (int i2 = this.mStep; i2 >= 0; i2 /= 10) {
            arrayList.add(0, stepNumDrawable.get(i2 % 10));
            if (i2 < 10) {
                break;
            }
        }
        int step_keep_number_length = this.flatter.getConfig().getStep_keep_number_length();
        while (arrayList.size() < step_keep_number_length) {
            arrayList.add(0, stepNumDrawable.get(0));
        }
        if (config.getStep_show_type() != 1) {
            if (config.getStep_show_type() == 2) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    intrinsicWidth2 += (int) (((Drawable) it.next()).getIntrinsicWidth() * absoluteScaleX);
                }
                intrinsicWidth -= intrinsicWidth2 / 2;
            }
        } else {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                intrinsicWidth -= (int) (((Drawable) it2.next()).getIntrinsicWidth() * absoluteScaleX);
            }
        }
        for (Drawable drawable2 : arrayList) {
            drawDrawable(canvas, drawable2, intrinsicWidth, i, absoluteScaleX, absoluteScaleY);
            intrinsicWidth += (int) (drawable2.getIntrinsicWidth() * absoluteScaleX);
        }
        if (this.flatter.getConfig().getStep_num_rotate() == 1) {
            canvas.restore();
        }
        Drawable stepEndDrawable = this.flatter.getStepEndDrawable();
        if (stepEndDrawable != null) {
            drawDrawable(canvas, stepEndDrawable, intrinsicWidth, i, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
    }

    private final void drawStepWithArc(Canvas canvas) {
        double d;
        double d2;
        double length;
        Drawable stepDrawable = this.flatter.getStepDrawable();
        if (stepDrawable != null) {
            drawDrawable(canvas, stepDrawable, this.flatter.getStepPosition().x, this.flatter.getStepPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(this.flatter.getConfig().getStep_keep_number_length(), 1);
        int step = StepManager.INSTANCE.getStep(this.context);
        this.mStep = step;
        String strPadStart = StringsKt.padStart(String.valueOf(step), iCoerceAtLeast, '0');
        int step_show_type = this.flatter.getConfig().getStep_show_type();
        if (step_show_type != 0) {
            if (step_show_type == 1) {
                d2 = this.mStartArc;
                length = ((((double) strPadStart.length()) * this.mSubArcNum) + this.mSubArcEnd) * 2.0d;
            } else if (step_show_type != 2) {
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
        List<Drawable> stepNumDrawable = this.flatter.getStepNumDrawable();
        double d4 = 3.141592653589793d;
        if (stepNumDrawable != null) {
            float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scale;
            float absoluteScaleY = getSupportScale() ? this.flatter.getAbsoluteScaleY() : absoluteScaleX;
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
                double d8 = dCos - (((double) this.mStepCellWidth) / 2.0d);
                Drawable drawable = stepNumDrawable.get(str.charAt(i) - '0');
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
        Drawable stepEndDrawable = this.flatter.getStepEndDrawable();
        if (stepEndDrawable != null) {
            double d9 = d3 + this.mSubArcNum + this.mSubArcEnd;
            double d10 = 1.5707963267948966d - d9;
            double dCos2 = ((double) this.mCircleX) + (this.mCircleR * Math.cos(d10));
            double dSin2 = ((double) this.mCircleY) - (this.mCircleR * Math.sin(d10));
            double d11 = (d9 * 180.0d) / 3.141592653589793d;
            float f3 = (float) dCos2;
            float f4 = (float) dSin2;
            canvas.rotate((float) (((double) this.mExtraAngle) + d11), f3, f4);
            drawDrawable(canvas, stepEndDrawable, (int) (dCos2 - (((double) this.mStepEndWidth) / 2.0d)), (int) dSin2, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
            canvas.rotate(-((float) (d11 + ((double) this.mExtraAngle))), f3, f4);
        }
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.flatter.getConfig().getStep_follow_num();
        int open_step_arc_show = this.flatter.getConfig().getOpen_step_arc_show();
        List<? extends Drawable> list = this.stepProgressDrawables;
        if (list != null) {
            int i = (this.mStep * 100) / this.targetStep;
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
            drawDrawable(canvas, list.get(i2), this.stepProgressPosition.x, this.stepProgressPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scale, getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scale);
        }
        if (open_step_arc_show == 0) {
            drawStepWithoutArc(canvas);
        } else {
            drawStepWithArc(canvas);
        }
    }
}
