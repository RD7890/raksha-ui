package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduHeaders;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: HeartPainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b,\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010T\u001a\u00020\"2\u0006\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\"2\u0006\u0010W\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020\"H\u0002J \u0010Y\u001a\u00020\"2\u0006\u0010Z\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\"2\u0006\u0010W\u001a\u00020\u001cH\u0002J \u0010[\u001a\u00020\"2\u0006\u0010Z\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\"2\u0006\u0010W\u001a\u00020\u001cH\u0002J\u001a\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0010\u0010b\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0002J\u000e\u0010c\u001a\u00020]2\u0006\u0010^\u001a\u00020_R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001a\u0010*\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u001a\u0010-\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R\u001a\u00100\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\u001a\u00103\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\u001a\u00106\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u001a\u00109\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001e\"\u0004\b;\u0010 R\u001a\u0010<\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001e\"\u0004\b>\u0010 R\u001a\u0010?\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001e\"\u0004\bA\u0010 R\u001a\u0010B\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010$\"\u0004\bD\u0010&R\u001a\u0010E\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010$\"\u0004\bG\u0010&R\u001a\u0010H\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010$\"\u0004\bJ\u0010&R\u001a\u0010K\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010$\"\u0004\bM\u0010&R\u0014\u0010N\u001a\u00020OX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0014\u0010R\u001a\u00020OX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bS\u0010Q¨\u0006d"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/HeartPainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "getContext", "()Landroid/content/Context;", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "heartArcCenterPosition", "Landroid/graphics/Point;", "getHeartArcCenterPosition", "()Landroid/graphics/Point;", "setHeartArcCenterPosition", "(Landroid/graphics/Point;)V", "heartProgressDrawables", "", "Landroid/graphics/drawable/Drawable;", "getHeartProgressDrawables", "()Ljava/util/List;", "setHeartProgressDrawables", "(Ljava/util/List;)V", "heartProgressPosition", "getHeartProgressPosition", "setHeartProgressPosition", "mBpm", "", "getMBpm", "()I", "setMBpm", "(I)V", "mCircleR", "", "getMCircleR", "()D", "setMCircleR", "(D)V", "mCircleX", "getMCircleX", "setMCircleX", "mCircleY", "getMCircleY", "setMCircleY", "mExtraAngle", "getMExtraAngle", "setMExtraAngle", "mHeartCellHeight", "getMHeartCellHeight", "setMHeartCellHeight", "mHeartCellWidth", "getMHeartCellWidth", "setMHeartCellWidth", "mHeartEndHeight", "getMHeartEndHeight", "setMHeartEndHeight", "mHeartEndWidth", "getMHeartEndWidth", "setMHeartEndWidth", "mHeartHeight", "getMHeartHeight", "setMHeartHeight", "mHeartWidth", "getMHeartWidth", "setMHeartWidth", "mStartArc", "getMStartArc", "setMStartArc", "mSubArcEnd", "getMSubArcEnd", "setMSubArcEnd", "mSubArcIcon", "getMSubArcIcon", "setMSubArcIcon", "mSubArcNum", "getMSubArcNum", "setMSubArcNum", "scaleX", "", "getScaleX", "()F", "scaleY", "getScaleY", "calculateSubArc", "wdith", "radius", "height", "tempLen", "calculateTempLen", "width", "calculateTempLen_180", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawHeartWithArc", "drawHeartWithoutArc", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class HeartPainter extends ABasePainter {
    private final Context context;
    private final ClockConfigFlatter flatter;
    private Point heartArcCenterPosition;
    private List<? extends Drawable> heartProgressDrawables;
    private Point heartProgressPosition;
    private int mBpm;
    private double mCircleR;
    private int mCircleX;
    private int mCircleY;
    private int mExtraAngle;
    private int mHeartCellHeight;
    private int mHeartCellWidth;
    private int mHeartEndHeight;
    private int mHeartEndWidth;
    private int mHeartHeight;
    private int mHeartWidth;
    private double mStartArc;
    private double mSubArcEnd;
    private double mSubArcIcon;
    private double mSubArcNum;
    private final float scaleX;
    private final float scaleY;

    public HeartPainter(Context context, ClockConfigFlatter flatter) {
        float scaleX;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.heartArcCenterPosition = new Point();
        this.heartProgressPosition = new Point();
        setSupportScale(flatter.getConfig().supportScale());
        if (flatter.getConfig().getShow_heart_progress() == 1) {
            this.heartProgressDrawables = flatter.splitDrawable(flatter.getConfig().getHeart_progress_src(), 5);
            flatter.setPosition(this.heartProgressPosition, flatter.getConfig().getHeart_progress_x(), flatter.getConfig().getHeart_progress_y());
        }
        Drawable bpmDrawable = flatter.getBpmDrawable();
        if (bpmDrawable != null) {
            this.mHeartWidth = (int) ((getSupportScale() ? bpmDrawable.getIntrinsicWidth() * flatter.getAbsoluteScaleX() : bpmDrawable.getIntrinsicWidth()) * flatter.getScaleX());
            boolean supportScale = getSupportScale();
            float intrinsicHeight = bpmDrawable.getIntrinsicHeight();
            if (supportScale) {
                intrinsicHeight *= flatter.getAbsoluteScaleY();
                scaleX = flatter.getScaleY();
            } else {
                scaleX = flatter.getScaleX();
            }
            this.mHeartHeight = (int) (intrinsicHeight * scaleX);
        }
        List<Drawable> bpmNumDrawable = flatter.getBpmNumDrawable();
        if (bpmNumDrawable != null) {
            this.mHeartCellWidth = getSupportScale() ? (int) (bpmNumDrawable.get(0).getIntrinsicWidth() * flatter.getAbsoluteScaleX()) : bpmNumDrawable.get(0).getIntrinsicWidth();
            boolean supportScale2 = getSupportScale();
            int intrinsicHeight2 = bpmNumDrawable.get(0).getIntrinsicHeight();
            this.mHeartCellHeight = supportScale2 ? (int) (intrinsicHeight2 * flatter.getAbsoluteScaleY()) : intrinsicHeight2;
        }
        if (flatter.getConfig().getOpen_heart_arc_show() != 0) {
            flatter.setPosition(this.heartArcCenterPosition, flatter.getConfig().getHeart_arc_center_x(), flatter.getConfig().getHeart_arc_center_y());
            int i = flatter.getBpmNumPosition().x;
            int i2 = flatter.getBpmNumPosition().y;
            this.mCircleX = this.heartArcCenterPosition.x;
            int i3 = this.heartArcCenterPosition.y;
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
            if (flatter.getConfig().getHeart_arc_type() != 0) {
                this.mExtraAngle = PduHeaders.RECOMMENDED_RETRIEVAL_MODE;
                double d4 = this.mCircleR;
                double dCalculateTempLen_180 = calculateTempLen_180(this.mHeartWidth, d4, this.mHeartHeight);
                double dCalculateTempLen_181 = calculateTempLen_180(this.mHeartCellWidth, this.mCircleR, this.mHeartCellHeight);
                double dCalculateTempLen_182 = calculateTempLen_180(this.mHeartEndWidth, this.mCircleR, this.mHeartEndHeight);
                int i4 = this.mHeartWidth;
                int i5 = this.mHeartHeight;
                this.mSubArcIcon = Math.acos((((((((double) i5) / 2.0d) + d4) * ((((double) i4) / 2.0d) + d4)) + (dCalculateTempLen_180 * dCalculateTempLen_180)) - (((((double) i4) / 2.0d) / 2.0d) * (((double) i4) / 2.0d))) / ((((((double) i5) / 2.0d) + d4) * 2.0d) * dCalculateTempLen_180));
                double d5 = (((double) this.mHeartCellHeight) / 2.0d) + d4;
                int i6 = this.mHeartCellWidth;
                this.mSubArcNum = Math.acos((((d5 * d5) + (dCalculateTempLen_181 * dCalculateTempLen_181)) - ((((double) i6) / 2.0d) * (((double) i6) / 2.0d))) / ((d5 * 2.0d) * dCalculateTempLen_181));
                double d6 = (((double) this.mHeartEndHeight) / 2.0d) + d4;
                int i7 = this.mHeartCellWidth;
                double dAcos2 = Math.acos((((d6 * d6) + (dCalculateTempLen_182 * dCalculateTempLen_182)) - ((((double) i7) / 2.0d) * (((double) i7) / 2.0d))) / ((d6 * 2.0d) * dCalculateTempLen_182));
                this.mSubArcIcon = -this.mSubArcIcon;
                this.mSubArcNum = -this.mSubArcNum;
                this.mSubArcEnd = -dAcos2;
                return;
            }
            this.mExtraAngle = 0;
            double d7 = this.mCircleR;
            double dCalculateTempLen = calculateTempLen(this.mHeartWidth, d7, this.mHeartHeight);
            double dCalculateTempLen2 = calculateTempLen(this.mHeartCellWidth, d7, this.mHeartCellHeight);
            double dCalculateTempLen3 = calculateTempLen(this.mHeartEndWidth, d7, this.mHeartEndHeight);
            this.mSubArcIcon = calculateSubArc(this.mHeartWidth, d7, this.mHeartHeight, dCalculateTempLen);
            this.mSubArcNum = calculateSubArc(this.mHeartCellWidth, d7, this.mHeartCellHeight, dCalculateTempLen2);
            this.mSubArcEnd = calculateSubArc(this.mHeartEndWidth, d7, this.mHeartEndHeight, dCalculateTempLen3);
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final int getMBpm() {
        return this.mBpm;
    }

    public final void setMBpm(int i) {
        this.mBpm = i;
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

    public final int getMHeartWidth() {
        return this.mHeartWidth;
    }

    public final void setMHeartWidth(int i) {
        this.mHeartWidth = i;
    }

    public final int getMHeartHeight() {
        return this.mHeartHeight;
    }

    public final void setMHeartHeight(int i) {
        this.mHeartHeight = i;
    }

    public final int getMHeartCellWidth() {
        return this.mHeartCellWidth;
    }

    public final void setMHeartCellWidth(int i) {
        this.mHeartCellWidth = i;
    }

    public final int getMHeartCellHeight() {
        return this.mHeartCellHeight;
    }

    public final void setMHeartCellHeight(int i) {
        this.mHeartCellHeight = i;
    }

    public final int getMHeartEndHeight() {
        return this.mHeartEndHeight;
    }

    public final void setMHeartEndHeight(int i) {
        this.mHeartEndHeight = i;
    }

    public final int getMHeartEndWidth() {
        return this.mHeartEndWidth;
    }

    public final void setMHeartEndWidth(int i) {
        this.mHeartEndWidth = i;
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

    public final Point getHeartArcCenterPosition() {
        return this.heartArcCenterPosition;
    }

    public final void setHeartArcCenterPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.heartArcCenterPosition = point;
    }

    public final Point getHeartProgressPosition() {
        return this.heartProgressPosition;
    }

    public final void setHeartProgressPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.heartProgressPosition = point;
    }

    public final List<Drawable> getHeartProgressDrawables() {
        return this.heartProgressDrawables;
    }

    public final void setHeartProgressDrawables(List<? extends Drawable> list) {
        this.heartProgressDrawables = list;
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

    public final void drawHeartWithoutArc(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        ClockConfig config = this.flatter.getConfig();
        this.mBpm = Settings.Global.getInt(this.context.getContentResolver(), "last_heart_value", 0);
        Drawable bpmDrawable = this.flatter.getBpmDrawable();
        if (bpmDrawable != null) {
            drawDrawable(canvas, bpmDrawable, this.flatter.getBpmPosition().x, this.flatter.getBpmPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        List<Drawable> bpmNumDrawable = this.flatter.getBpmNumDrawable();
        if (bpmNumDrawable != null) {
            int intrinsicWidth = this.flatter.getBpmNumPosition().x;
            int i = this.flatter.getBpmNumPosition().y;
            if (this.flatter.getConfig().getHeart_num_rotate() == 1) {
                canvas.save();
                float heart_num_rotate_degree = this.flatter.getConfig().getHeart_num_rotate_degree();
                float f = intrinsicWidth;
                Drawable drawable = bpmNumDrawable.get(0);
                Integer numValueOf = drawable != null ? Integer.valueOf(drawable.getIntrinsicWidth()) : null;
                Intrinsics.checkNotNull(numValueOf);
                canvas.rotate(heart_num_rotate_degree, f + ((numValueOf.intValue() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() : 1.0f)) / 2), i);
            }
            int i2 = this.mBpm;
            if (i2 >= 0) {
                Drawable[] drawableArr = {bpmNumDrawable.get(i2 / 100), bpmNumDrawable.get((this.mBpm / 10) % 10), bpmNumDrawable.get(this.mBpm % 10)};
                if (config.getHeart_show_type() == 1) {
                    float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX;
                    for (int i3 = 0; i3 < 3; i3++) {
                        intrinsicWidth -= (int) (drawableArr[i3].getIntrinsicWidth() * absoluteScaleX);
                    }
                } else if (config.getHeart_show_type() == 2) {
                    float absoluteScaleX2 = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX;
                    int intrinsicWidth2 = 0;
                    for (int i4 = 0; i4 < 3; i4++) {
                        intrinsicWidth2 += (int) (drawableArr[i4].getIntrinsicWidth() * absoluteScaleX2);
                    }
                    intrinsicWidth -= intrinsicWidth2 / 2;
                }
                float absoluteScaleX3 = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX;
                float absoluteScaleY = getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scaleY;
                int intrinsicWidth3 = intrinsicWidth;
                for (int i5 = 0; i5 < 3; i5++) {
                    Drawable drawable2 = drawableArr[i5];
                    drawDrawable(canvas, drawable2, intrinsicWidth3, i, absoluteScaleX3, absoluteScaleY);
                    intrinsicWidth3 += (int) (drawable2.getIntrinsicWidth() * absoluteScaleX3);
                }
                if (this.flatter.getConfig().getHeart_num_rotate() == 1) {
                    canvas.restore();
                }
                Drawable bpmEndDrawable = this.flatter.getBpmEndDrawable();
                if (bpmEndDrawable != null) {
                    drawDrawable(canvas, bpmEndDrawable, intrinsicWidth3, i, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                }
            }
        }
    }

    private final void drawHeartWithArc(Canvas canvas) {
        double d;
        double d2;
        double length;
        Drawable bpmDrawable = this.flatter.getBpmDrawable();
        if (bpmDrawable != null) {
            drawDrawable(canvas, bpmDrawable, this.flatter.getBpmPosition().x, this.flatter.getBpmPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        int i = Settings.Global.getInt(this.context.getContentResolver(), "last_heart_value", 0);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.ENGLISH, "%03d", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        int heart_show_type = this.flatter.getConfig().getHeart_show_type();
        double d3 = 2.0d;
        if (heart_show_type != 0) {
            if (heart_show_type == 1) {
                d2 = this.mStartArc;
                length = ((((double) str.length()) * this.mSubArcNum) + this.mSubArcEnd) * 2.0d;
            } else if (heart_show_type != 2) {
                d = 0.0d;
            } else {
                d2 = this.mStartArc;
                length = (((double) str.length()) * this.mSubArcNum) + this.mSubArcEnd;
            }
            d = d2 - length;
        } else {
            d = this.mStartArc;
        }
        double d4 = d + this.mSubArcNum;
        List<Drawable> bpmNumDrawable = this.flatter.getBpmNumDrawable();
        double d5 = 3.141592653589793d;
        if (bpmNumDrawable != null) {
            float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX;
            float absoluteScaleX2 = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleY;
            int length2 = str.length();
            int i2 = 0;
            while (i2 < length2) {
                if (i2 > 0) {
                    d4 += this.mSubArcNum * d3;
                }
                double d6 = d4;
                double d7 = 1.5707963267948966d - d6;
                double dCos = ((double) this.mCircleX) + (this.mCircleR * Math.cos(d7));
                double dSin = ((double) this.mCircleY) - (this.mCircleR * Math.sin(d7));
                double d8 = (d6 * 180.0d) / d5;
                float f = (float) dCos;
                float f2 = (float) dSin;
                canvas.rotate((float) (((double) this.mExtraAngle) + d8), f, f2);
                double d9 = dCos - (((double) this.mHeartCellWidth) / 2.0d);
                Drawable drawable = bpmNumDrawable.get(str.charAt(i2) - '0');
                Intrinsics.checkNotNull(drawable);
                drawDrawable(canvas, drawable, (int) d9, (int) dSin, absoluteScaleX, absoluteScaleX2);
                canvas.rotate(-((float) (d8 + ((double) this.mExtraAngle))), f, f2);
                i2++;
                length2 = length2;
                d4 = d6;
                d3 = 2.0d;
                d5 = 3.141592653589793d;
            }
        }
        Drawable bpmEndDrawable = this.flatter.getBpmEndDrawable();
        if (bpmEndDrawable != null) {
            double d10 = d4 + this.mSubArcNum + this.mSubArcEnd;
            double d11 = 1.5707963267948966d - d10;
            double dCos2 = ((double) this.mCircleX) + (this.mCircleR * Math.cos(d11));
            double dSin2 = ((double) this.mCircleY) - (this.mCircleR * Math.sin(d11));
            double d12 = (d10 * 180.0d) / 3.141592653589793d;
            float f3 = (float) dCos2;
            float f4 = (float) dSin2;
            canvas.rotate((float) (((double) this.mExtraAngle) + d12), f3, f4);
            drawDrawable(canvas, bpmEndDrawable, (int) (dCos2 - (((double) this.mHeartEndWidth) / 2.0d)), (int) dSin2, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
            canvas.rotate(-((float) (d12 + ((double) this.mExtraAngle))), f3, f4);
        }
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        List<? extends Drawable> list = this.heartProgressDrawables;
        if (list != null) {
            int i = 0;
            int i2 = Settings.Global.getInt(this.context.getContentResolver(), "last_heart_value", 0);
            if (i2 < 0 || i2 >= 60) {
                if (i2 >= 0 && i2 < 100) {
                    i = 1;
                } else if (i2 < 0 || i2 >= 120) {
                    i = (i2 < 0 || i2 >= 140) ? 4 : 3;
                } else {
                    i = 2;
                }
            }
            drawDrawable(canvas, list.get(i), this.heartProgressPosition.x, this.heartProgressPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : 1.0f, getSupportScale() ? this.flatter.getAbsoluteScaleY() : 1.0f);
        }
        if (this.flatter.getConfig().getOpen_heart_arc_show() == 0) {
            drawHeartWithoutArc(canvas);
        } else {
            drawHeartWithArc(canvas);
        }
    }
}
