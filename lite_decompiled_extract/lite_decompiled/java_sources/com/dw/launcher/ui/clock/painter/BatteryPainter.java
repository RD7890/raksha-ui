package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import com.dw.launcher.data.component.BatteryComponent;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.google.android.material.timepicker.TimeModel;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: BatteryPainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010Q\u001a\u00020$2\u0006\u0010R\u001a\u00020\u00142\u0006\u0010S\u001a\u00020$2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010U\u001a\u00020$H\u0002J \u0010V\u001a\u00020$2\u0006\u0010W\u001a\u00020\u00142\u0006\u0010S\u001a\u00020$2\u0006\u0010T\u001a\u00020\u0014H\u0002J \u0010X\u001a\u00020$2\u0006\u0010W\u001a\u00020\u00142\u0006\u0010S\u001a\u00020$2\u0006\u0010T\u001a\u00020\u0014H\u0002J\u001a\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u0010\u0010_\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0002J\u000e\u0010`\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u000e\u0010\"\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R\u001a\u0010,\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u001a\u0010/\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R\u001a\u00102\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\u001a\u00105\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010&\"\u0004\b7\u0010(R\u001a\u00108\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010&\"\u0004\b:\u0010(R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\f\"\u0004\bC\u0010\u000eR\"\u0010D\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\f\"\u0004\bL\u0010\u000eR\u0014\u0010M\u001a\u00020NX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bO\u0010P¨\u0006a"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/BatteryPainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "mBatteryComponent", "Lcom/dw/launcher/data/component/BatteryComponent;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/data/component/BatteryComponent;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "BatteryArcCenterPosition", "Landroid/graphics/Point;", "getBatteryArcCenterPosition", "()Landroid/graphics/Point;", "setBatteryArcCenterPosition", "(Landroid/graphics/Point;)V", "getContext", "()Landroid/content/Context;", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "mBatteryCellHeight", "", "getMBatteryCellHeight", "()I", "setMBatteryCellHeight", "(I)V", "mBatteryCellWidth", "getMBatteryCellWidth", "setMBatteryCellWidth", "mBatteryEndHeight", "getMBatteryEndHeight", "setMBatteryEndHeight", "mBatteryEndWidth", "getMBatteryEndWidth", "setMBatteryEndWidth", "mChargeIndex", "mCircleR", "", "getMCircleR", "()D", "setMCircleR", "(D)V", "mCircleX", "getMCircleX", "setMCircleX", "mCircleY", "getMCircleY", "setMCircleY", "mExtraAngle", "getMExtraAngle", "setMExtraAngle", "mStartArc", "getMStartArc", "setMStartArc", "mSubArcEnd", "getMSubArcEnd", "setMSubArcEnd", "mSubArcNum", "getMSubArcNum", "setMSubArcNum", "powerDrawable", "Landroid/graphics/drawable/Drawable;", "getPowerDrawable", "()Landroid/graphics/drawable/Drawable;", "setPowerDrawable", "(Landroid/graphics/drawable/Drawable;)V", "powerPosition", "getPowerPosition", "setPowerPosition", "powerProgressDrawable", "", "getPowerProgressDrawable", "()Ljava/util/List;", "setPowerProgressDrawable", "(Ljava/util/List;)V", "powerProgressPosition", "getPowerProgressPosition", "setPowerProgressPosition", "scale", "", "getScale", "()F", "calculateSubArc", "wdith", "radius", "height", "tempLen", "calculateTempLen", "width", "calculateTempLen_180", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawWithArc", "drawWithoutArc", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class BatteryPainter extends ABasePainter {
    private Point BatteryArcCenterPosition;
    private final Context context;
    private final ClockConfigFlatter flatter;
    private int mBatteryCellHeight;
    private int mBatteryCellWidth;
    private final BatteryComponent mBatteryComponent;
    private int mBatteryEndHeight;
    private int mBatteryEndWidth;
    private int mChargeIndex;
    private double mCircleR;
    private int mCircleX;
    private int mCircleY;
    private int mExtraAngle;
    private double mStartArc;
    private double mSubArcEnd;
    private double mSubArcNum;
    private Drawable powerDrawable;
    private Point powerPosition;
    private List<? extends Drawable> powerProgressDrawable;
    private Point powerProgressPosition;
    private final float scale;

    public final Context getContext() {
        return this.context;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public BatteryPainter(Context context, BatteryComponent mBatteryComponent, ClockConfigFlatter flatter) {
        float intrinsicHeight;
        float scaleX;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mBatteryComponent, "mBatteryComponent");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.mBatteryComponent = mBatteryComponent;
        this.flatter = flatter;
        this.scale = 1.0f;
        this.BatteryArcCenterPosition = new Point();
        this.powerProgressPosition = new Point();
        this.powerPosition = new Point();
        setSupportScale(flatter.getConfig().supportScale());
        if (flatter.getConfig().getShow_power() == 1 || flatter.getConfig().getShow_power_num() == 1) {
            this.powerDrawable = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getPower_src(), false, 2, null);
            flatter.setPosition(this.powerPosition, flatter.getConfig().getPower_src_x(), flatter.getConfig().getPower_src_y());
        }
        if (flatter.getConfig().getShow_power_progress() == 1) {
            this.powerProgressDrawable = flatter.splitDrawable(flatter.getConfig().getPower_progress_src(), 11);
            flatter.setPosition(this.powerProgressPosition, flatter.getConfig().getPower_progress_x(), flatter.getConfig().getPower_progress_y());
        }
        if (flatter.getConfig().getOpen_power_arc_show() != 0) {
            Drawable batteryIconDrawable = flatter.getBatteryIconDrawable();
            if (batteryIconDrawable != null) {
                if (getSupportScale()) {
                    intrinsicHeight = batteryIconDrawable.getIntrinsicHeight() * flatter.getAbsoluteScaleY();
                    scaleX = flatter.getScaleY();
                } else {
                    intrinsicHeight = batteryIconDrawable.getIntrinsicHeight();
                    scaleX = flatter.getScaleX();
                }
                this.mBatteryEndHeight = (int) (intrinsicHeight * scaleX);
                boolean supportScale = getSupportScale();
                float intrinsicWidth = batteryIconDrawable.getIntrinsicWidth();
                this.mBatteryEndWidth = (int) ((supportScale ? intrinsicWidth * flatter.getAbsoluteScaleX() : intrinsicWidth) * flatter.getScaleX());
            }
            List<Drawable> batteryNumDrawable = flatter.getBatteryNumDrawable();
            if (batteryNumDrawable != null) {
                this.mBatteryCellWidth = getSupportScale() ? (int) (batteryNumDrawable.get(0).getIntrinsicWidth() * flatter.getAbsoluteScaleX()) : batteryNumDrawable.get(0).getIntrinsicWidth();
                boolean supportScale2 = getSupportScale();
                int intrinsicHeight2 = batteryNumDrawable.get(0).getIntrinsicHeight();
                this.mBatteryCellHeight = supportScale2 ? (int) (intrinsicHeight2 * flatter.getAbsoluteScaleY()) : intrinsicHeight2;
            }
            flatter.setPosition(this.BatteryArcCenterPosition, flatter.getConfig().getPower_arc_center_x(), flatter.getConfig().getPower_arc_center_y());
            int i = flatter.getBatteryNumPosition().x;
            int i2 = flatter.getBatteryNumPosition().y;
            this.mCircleX = this.BatteryArcCenterPosition.x;
            int i3 = this.BatteryArcCenterPosition.y;
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
            if (flatter.getConfig().getPower_arc_type() != 0) {
                this.mExtraAngle = PduHeaders.RECOMMENDED_RETRIEVAL_MODE;
                double d4 = this.mCircleR;
                double dCalculateTempLen_180 = calculateTempLen_180(this.mBatteryCellWidth, d4, this.mBatteryCellHeight);
                double dCalculateTempLen_181 = calculateTempLen_180(this.mBatteryEndWidth, this.mCircleR, this.mBatteryEndHeight);
                double d5 = (((double) this.mBatteryCellHeight) / 2.0d) + d4;
                int i4 = this.mBatteryCellWidth;
                this.mSubArcNum = Math.acos((((d5 * d5) + (dCalculateTempLen_180 * dCalculateTempLen_180)) - ((((double) i4) / 2.0d) * (((double) i4) / 2.0d))) / ((d5 * 2.0d) * dCalculateTempLen_180));
                double d6 = (((double) this.mBatteryEndHeight) / 2.0d) + d4;
                int i5 = this.mBatteryCellWidth;
                double dAcos2 = Math.acos((((d6 * d6) + (dCalculateTempLen_181 * dCalculateTempLen_181)) - ((((double) i5) / 2.0d) * (((double) i5) / 2.0d))) / ((d6 * 2.0d) * dCalculateTempLen_181));
                this.mSubArcNum = -this.mSubArcNum;
                this.mSubArcEnd = -dAcos2;
                return;
            }
            this.mExtraAngle = 0;
            double d7 = this.mCircleR;
            double dCalculateTempLen = calculateTempLen(this.mBatteryCellWidth, d7, this.mBatteryCellHeight);
            double dCalculateTempLen2 = calculateTempLen(this.mBatteryEndWidth, d7, this.mBatteryEndHeight);
            this.mSubArcNum = calculateSubArc(this.mBatteryCellWidth, d7, this.mBatteryCellHeight, dCalculateTempLen);
            this.mSubArcEnd = calculateSubArc(this.mBatteryEndWidth, d7, this.mBatteryEndHeight, dCalculateTempLen2);
        }
    }

    public final float getScale() {
        return this.scale;
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

    public final int getMBatteryCellWidth() {
        return this.mBatteryCellWidth;
    }

    public final void setMBatteryCellWidth(int i) {
        this.mBatteryCellWidth = i;
    }

    public final int getMBatteryCellHeight() {
        return this.mBatteryCellHeight;
    }

    public final void setMBatteryCellHeight(int i) {
        this.mBatteryCellHeight = i;
    }

    public final int getMBatteryEndHeight() {
        return this.mBatteryEndHeight;
    }

    public final void setMBatteryEndHeight(int i) {
        this.mBatteryEndHeight = i;
    }

    public final int getMBatteryEndWidth() {
        return this.mBatteryEndWidth;
    }

    public final void setMBatteryEndWidth(int i) {
        this.mBatteryEndWidth = i;
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

    public final Point getBatteryArcCenterPosition() {
        return this.BatteryArcCenterPosition;
    }

    public final void setBatteryArcCenterPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.BatteryArcCenterPosition = point;
    }

    public final List<Drawable> getPowerProgressDrawable() {
        return this.powerProgressDrawable;
    }

    public final void setPowerProgressDrawable(List<? extends Drawable> list) {
        this.powerProgressDrawable = list;
    }

    public final Point getPowerProgressPosition() {
        return this.powerProgressPosition;
    }

    public final void setPowerProgressPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.powerProgressPosition = point;
    }

    public final Drawable getPowerDrawable() {
        return this.powerDrawable;
    }

    public final void setPowerDrawable(Drawable drawable) {
        this.powerDrawable = drawable;
    }

    public final Point getPowerPosition() {
        return this.powerPosition;
    }

    public final void setPowerPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.powerPosition = point;
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

    public final void drawWithoutArc(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.flatter.getConfig().showBatteryNum()) {
            float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : 1.0f;
            List<Drawable> batteryNumDrawable = this.flatter.getBatteryNumDrawable();
            if (batteryNumDrawable != null) {
                ArrayList<Drawable> arrayList = new ArrayList();
                int scaleX = 0;
                for (int level = this.mBatteryComponent.getLevel(); level >= 0; level /= 10) {
                    int i = level % 10;
                    arrayList.add(0, batteryNumDrawable.get(i));
                    scaleX += (int) (batteryNumDrawable.get(i).getIntrinsicWidth() * absoluteScaleX);
                    if (level < 10) {
                        break;
                    }
                }
                Drawable batteryIconDrawable = this.flatter.getBatteryIconDrawable();
                if (batteryIconDrawable != null) {
                    boolean supportScale = getSupportScale();
                    float intrinsicWidth = batteryIconDrawable.getIntrinsicWidth();
                    if (supportScale) {
                        intrinsicWidth *= this.flatter.getAbsoluteScaleX();
                    }
                    scaleX += (int) (intrinsicWidth * this.flatter.getScaleX());
                }
                int i2 = this.flatter.getBatteryNumPosition().x;
                int i3 = this.flatter.getBatteryNumPosition().y;
                if (this.flatter.getConfig().getPower_show_type() == 1) {
                    i2 -= scaleX;
                } else if (this.flatter.getConfig().getPower_show_type() == 2) {
                    scaleX /= 2;
                    i2 -= scaleX;
                }
                int intrinsicWidth2 = i2;
                for (Drawable drawable : arrayList) {
                    drawDrawable(canvas, drawable, intrinsicWidth2, i3, absoluteScaleX, absoluteScaleX);
                    intrinsicWidth2 += (int) (drawable.getIntrinsicWidth() * absoluteScaleX);
                }
                Drawable batteryIconDrawable2 = this.flatter.getBatteryIconDrawable();
                if (batteryIconDrawable2 != null) {
                    drawDrawable(canvas, batteryIconDrawable2, intrinsicWidth2, i3, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                }
            }
        }
    }

    private final void drawWithArc(Canvas canvas) {
        double d;
        double d2;
        double length;
        if (this.flatter.getConfig().showBatteryNum()) {
            float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scale;
            int level = this.mBatteryComponent.getLevel();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.ENGLISH, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(level)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            int power_show_type = this.flatter.getConfig().getPower_show_type();
            double d3 = 2.0d;
            if (power_show_type != 0) {
                if (power_show_type == 1) {
                    d2 = this.mStartArc;
                    length = ((((double) str.length()) * this.mSubArcNum) + this.mSubArcEnd) * 2.0d;
                } else if (power_show_type != 2) {
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
            List<Drawable> batteryNumDrawable = this.flatter.getBatteryNumDrawable();
            double d5 = 3.141592653589793d;
            if (batteryNumDrawable != null) {
                int length2 = str.length();
                int i = 0;
                while (i < length2) {
                    if (i > 0) {
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
                    double d9 = dCos - (((double) this.mBatteryCellWidth) / 2.0d);
                    Drawable drawable = batteryNumDrawable.get(str.charAt(i) - '0');
                    Intrinsics.checkNotNull(drawable);
                    drawDrawable(canvas, drawable, (int) d9, (int) dSin, absoluteScaleX, absoluteScaleX);
                    canvas.rotate(-((float) (d8 + ((double) this.mExtraAngle))), f, f2);
                    i++;
                    length2 = length2;
                    d4 = d6;
                    d3 = 2.0d;
                    d5 = 3.141592653589793d;
                }
            }
            Drawable batteryIconDrawable = this.flatter.getBatteryIconDrawable();
            if (batteryIconDrawable != null) {
                double d10 = d4 + this.mSubArcNum + this.mSubArcEnd;
                double d11 = 1.5707963267948966d - d10;
                double dCos2 = ((double) this.mCircleX) + (this.mCircleR * Math.cos(d11));
                double dSin2 = ((double) this.mCircleY) - (this.mCircleR * Math.sin(d11));
                double d12 = (d10 * 180.0d) / 3.141592653589793d;
                float f3 = (float) dCos2;
                float f4 = (float) dSin2;
                canvas.rotate((float) (((double) this.mExtraAngle) + d12), f3, f4);
                drawDrawable(canvas, batteryIconDrawable, (int) (dCos2 - (((double) this.mBatteryEndWidth) / 2.0d)), (int) dSin2, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                canvas.rotate(-((float) (d12 + ((double) this.mExtraAngle))), f3, f4);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0137  */
    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        ClockConfig config = this.flatter.getConfig();
        float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX();
        float absoluteScaleY = getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY();
        if (!config.showBattery()) {
            i = 55;
            i2 = 65;
            i3 = 45;
        } else if (config.showCharge() && this.mBatteryComponent.isCharging()) {
            List<Drawable> batteryChargeDrawable = this.flatter.getBatteryChargeDrawable();
            if (batteryChargeDrawable != null) {
                if (this.mChargeIndex >= batteryChargeDrawable.size()) {
                    this.mChargeIndex = 0;
                }
                i3 = 45;
                i = 55;
                i2 = 65;
                drawDrawable(canvas, batteryChargeDrawable.get(this.mChargeIndex), this.flatter.getBatteryPosition().x, this.flatter.getBatteryPosition().y, absoluteScaleX, absoluteScaleY);
                this.mChargeIndex++;
            } else {
                i = 55;
                i2 = 65;
                i3 = 45;
            }
        } else {
            i = 55;
            i2 = 65;
            i3 = 45;
            List<Drawable> batteryDrawable = this.flatter.getBatteryDrawable();
            if (batteryDrawable != null) {
                int level = this.mBatteryComponent.getLevel();
                if (level >= 0 && level < 5) {
                    i5 = 0;
                } else if (level >= 0 && level < 15) {
                    i5 = 1;
                } else if (level >= 0 && level < 25) {
                    i5 = 2;
                } else if (level >= 0 && level < 35) {
                    i5 = 3;
                } else if (level >= 0 && level < 45) {
                    i5 = 4;
                } else if (level >= 0 && level < 55) {
                    i5 = 5;
                } else if (level >= 0 && level < 65) {
                    i5 = 6;
                } else if (level >= 0 && level < 75) {
                    i5 = 7;
                } else if (level < 0 || level >= 85) {
                    i5 = (level < 0 || level >= 95) ? 10 : 9;
                } else {
                    i5 = 8;
                }
                drawDrawable(canvas, batteryDrawable.get(i5), this.flatter.getBatteryPosition().x, this.flatter.getBatteryPosition().y, absoluteScaleX, absoluteScaleY);
                this.mChargeIndex++;
            }
        }
        List<? extends Drawable> list = this.powerProgressDrawable;
        if (list != null) {
            int level2 = this.mBatteryComponent.getLevel();
            if (level2 >= 0 && level2 < 5) {
                i4 = 0;
            } else if (level2 >= 0 && level2 < 15) {
                i4 = 1;
            } else if (level2 >= 0 && level2 < 25) {
                i4 = 2;
            } else if (level2 >= 0 && level2 < 35) {
                i4 = 3;
            } else if (level2 >= 0 && level2 < i3) {
                i4 = 4;
            } else if (level2 >= 0 && level2 < i) {
                i4 = 5;
            } else if (level2 >= 0 && level2 < i2) {
                i4 = 6;
            } else if (level2 >= 0 && level2 < 75) {
                i4 = 7;
            } else if (level2 < 0 || level2 >= 85) {
                i4 = (level2 < 0 || level2 >= 95) ? 10 : 9;
            } else {
                i4 = 8;
            }
            drawDrawable(canvas, list.get(i4), this.powerProgressPosition.x, this.powerProgressPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scale, getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scale);
        }
        Drawable drawable = this.powerDrawable;
        if (drawable != null) {
            drawDrawable(canvas, drawable, this.powerPosition.x, this.powerPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        if (this.flatter.getConfig().getOpen_power_arc_show() == 0) {
            drawWithoutArc(canvas);
        } else {
            drawWithArc(canvas);
        }
    }
}
