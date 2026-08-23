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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: OxygenPainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020\fH\u0002J \u0010M\u001a\u00020\f2\u0006\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\u000eH\u0002J \u0010N\u001a\u00020\f2\u0006\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\u000eH\u0002J\u001a\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0010\u0010U\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0002J\u000e\u0010V\u001a\u00020P2\u0006\u0010Q\u001a\u00020RR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001a\u0010$\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\u001c\u0010<\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010*\"\u0004\b>\u0010,R\u0014\u0010?\u001a\u00020@X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u000e\u0010C\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010D\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00100\"\u0004\bF\u00102R\u000e\u0010G\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/OxygenPainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "getContext", "()Landroid/content/Context;", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "mCircleR", "", "mCircleX", "", "mCircleY", "mExtraAngle", "mSpo2", "mSpo2CellHeight", "mSpo2CellWidth", "mSpo2EndHeight", "mSpo2EndWidth", "mStartArc", "mSubArcEnd", "mSubArcNum", "openOxygenArcShow", "getOpenOxygenArcShow", "()I", "setOpenOxygenArcShow", "(I)V", "oxygenArcCenterX", "getOxygenArcCenterX", "setOxygenArcCenterX", "oxygenArcCenterY", "getOxygenArcCenterY", "setOxygenArcCenterY", "oxygenArcType", "getOxygenArcType", "setOxygenArcType", "oxygenDrawable", "Landroid/graphics/drawable/Drawable;", "getOxygenDrawable", "()Landroid/graphics/drawable/Drawable;", "setOxygenDrawable", "(Landroid/graphics/drawable/Drawable;)V", "oxygenNumDrawable", "", "getOxygenNumDrawable", "()Ljava/util/List;", "setOxygenNumDrawable", "(Ljava/util/List;)V", "oxygenNumPosition", "Landroid/graphics/Point;", "getOxygenNumPosition", "()Landroid/graphics/Point;", "setOxygenNumPosition", "(Landroid/graphics/Point;)V", "oxygenPosition", "getOxygenPosition", "setOxygenPosition", "oxygenSignDrawable", "getOxygenSignDrawable", "setOxygenSignDrawable", "scale", "", "getScale", "()F", "spo2ArcCenterPosition", "spo2ProgressDrawables", "getSpo2ProgressDrawables", "setSpo2ProgressDrawables", "spo2ProgressPosition", "calculateSubArc", "width", "radius", "height", "tempLen", "calculateTempLen", "calculateTempLen_180", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawOxygenWithArc", "drawWithoutArc", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class OxygenPainter extends ABasePainter {
    private final Context context;
    private final ClockConfigFlatter flatter;
    private double mCircleR;
    private int mCircleX;
    private int mCircleY;
    private int mExtraAngle;
    private int mSpo2;
    private int mSpo2CellHeight;
    private int mSpo2CellWidth;
    private int mSpo2EndHeight;
    private int mSpo2EndWidth;
    private double mStartArc;
    private double mSubArcEnd;
    private double mSubArcNum;
    private int openOxygenArcShow;
    private int oxygenArcCenterX;
    private int oxygenArcCenterY;
    private int oxygenArcType;
    private Drawable oxygenDrawable;
    private List<? extends Drawable> oxygenNumDrawable;
    private Point oxygenNumPosition;
    private Point oxygenPosition;
    private Drawable oxygenSignDrawable;
    private final float scale;
    private Point spo2ArcCenterPosition;
    private List<? extends Drawable> spo2ProgressDrawables;
    private Point spo2ProgressPosition;

    public final Context getContext() {
        return this.context;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public OxygenPainter(Context context, ClockConfigFlatter flatter) {
        float intrinsicHeight;
        float scaleX;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.scale = 1.0f;
        this.oxygenNumPosition = new Point();
        this.oxygenPosition = new Point();
        this.spo2ArcCenterPosition = new Point();
        this.spo2ProgressPosition = new Point();
        setSupportScale(flatter.getConfig().supportScale());
        if (flatter.getConfig().getShow_oxygen_progress() == 1) {
            this.spo2ProgressDrawables = flatter.splitDrawable(flatter.getConfig().getOxygen_progress_src(), 11);
            flatter.setPosition(this.spo2ProgressPosition, flatter.getConfig().getOxygen_progress_x(), flatter.getConfig().getOxygen_progress_y());
        }
        if (flatter.getConfig().getShow_oxygen() == 1) {
            this.oxygenDrawable = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getOxygen_src(), false, 2, null);
            flatter.setPosition(this.oxygenPosition, flatter.getConfig().getOxygen_x(), flatter.getConfig().getOxygen_y());
            this.oxygenNumDrawable = flatter.splitDrawable(flatter.getConfig().getOxygen_num_src(), 10);
            flatter.setPosition(this.oxygenNumPosition, flatter.getConfig().getOxygen_num_x(), flatter.getConfig().getOxygen_num_y());
            this.oxygenSignDrawable = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getOxygen_sign_src(), false, 2, null);
        }
        this.openOxygenArcShow = flatter.getConfig().getOpen_oxygen_arc_show();
        this.oxygenArcType = flatter.getConfig().getOxygen_arc_type();
        this.oxygenArcCenterX = flatter.getConfig().getOxygen_arc_center_x();
        this.oxygenArcCenterY = flatter.getConfig().getOxygen_arc_center_y();
        if (this.openOxygenArcShow != 0) {
            Drawable drawable = this.oxygenSignDrawable;
            if (drawable != null) {
                if (getSupportScale()) {
                    intrinsicHeight = drawable.getIntrinsicHeight() * flatter.getAbsoluteScaleY();
                    scaleX = flatter.getScaleY();
                } else {
                    intrinsicHeight = drawable.getIntrinsicHeight();
                    scaleX = flatter.getScaleX();
                }
                this.mSpo2EndHeight = (int) (intrinsicHeight * scaleX);
                boolean supportScale = getSupportScale();
                float intrinsicWidth = drawable.getIntrinsicWidth();
                this.mSpo2EndWidth = (int) ((supportScale ? intrinsicWidth * flatter.getAbsoluteScaleX() : intrinsicWidth) * flatter.getScaleX());
            }
            List<? extends Drawable> list = this.oxygenNumDrawable;
            if (list != null) {
                this.mSpo2CellWidth = getSupportScale() ? (int) (list.get(0).getIntrinsicWidth() * flatter.getAbsoluteScaleX()) : list.get(0).getIntrinsicWidth();
                boolean supportScale2 = getSupportScale();
                int intrinsicHeight2 = list.get(0).getIntrinsicHeight();
                this.mSpo2CellHeight = supportScale2 ? (int) (intrinsicHeight2 * flatter.getAbsoluteScaleY()) : intrinsicHeight2;
            }
            flatter.setPosition(this.spo2ArcCenterPosition, this.oxygenArcCenterX, this.oxygenArcCenterY);
            int i = this.oxygenNumPosition.x;
            int i2 = this.oxygenNumPosition.y;
            this.mCircleX = this.spo2ArcCenterPosition.x;
            int i3 = this.spo2ArcCenterPosition.y;
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
            if (this.oxygenArcType != 0) {
                this.mExtraAngle = PduHeaders.RECOMMENDED_RETRIEVAL_MODE;
                double d4 = this.mCircleR;
                double dCalculateTempLen_180 = calculateTempLen_180(this.mSpo2CellWidth, d4, this.mSpo2CellHeight);
                double dCalculateTempLen_181 = calculateTempLen_180(this.mSpo2EndWidth, d4, this.mSpo2EndHeight);
                double d5 = (((double) this.mSpo2CellHeight) / 2.0d) + d4;
                int i4 = this.mSpo2CellWidth;
                this.mSubArcNum = Math.acos((((d5 * d5) + (dCalculateTempLen_180 * dCalculateTempLen_180)) - ((((double) i4) / 2.0d) * (((double) i4) / 2.0d))) / ((d5 * 2.0d) * dCalculateTempLen_180));
                double d6 = (((double) this.mSpo2EndHeight) / 2.0d) + d4;
                int i5 = this.mSpo2EndWidth;
                double dAcos2 = Math.acos((((d6 * d6) + (dCalculateTempLen_181 * dCalculateTempLen_181)) - ((((double) i5) / 2.0d) * (((double) i5) / 2.0d))) / ((d6 * 2.0d) * dCalculateTempLen_181));
                this.mSubArcNum = -this.mSubArcNum;
                this.mSubArcEnd = -dAcos2;
                return;
            }
            this.mExtraAngle = 0;
            double d7 = this.mCircleR;
            double dCalculateTempLen = calculateTempLen(this.mSpo2CellWidth, d7, this.mSpo2CellHeight);
            double dCalculateTempLen2 = calculateTempLen(this.mSpo2EndWidth, d7, this.mSpo2EndHeight);
            this.mSubArcNum = calculateSubArc(this.mSpo2CellWidth, d7, this.mSpo2CellHeight, dCalculateTempLen);
            this.mSubArcEnd = calculateSubArc(this.mSpo2EndWidth, d7, this.mSpo2EndHeight, dCalculateTempLen2);
        }
    }

    public final float getScale() {
        return this.scale;
    }

    public final List<Drawable> getOxygenNumDrawable() {
        return this.oxygenNumDrawable;
    }

    public final void setOxygenNumDrawable(List<? extends Drawable> list) {
        this.oxygenNumDrawable = list;
    }

    public final Point getOxygenNumPosition() {
        return this.oxygenNumPosition;
    }

    public final void setOxygenNumPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.oxygenNumPosition = point;
    }

    public final Drawable getOxygenSignDrawable() {
        return this.oxygenSignDrawable;
    }

    public final void setOxygenSignDrawable(Drawable drawable) {
        this.oxygenSignDrawable = drawable;
    }

    public final Point getOxygenPosition() {
        return this.oxygenPosition;
    }

    public final void setOxygenPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.oxygenPosition = point;
    }

    public final Drawable getOxygenDrawable() {
        return this.oxygenDrawable;
    }

    public final void setOxygenDrawable(Drawable drawable) {
        this.oxygenDrawable = drawable;
    }

    public final int getOpenOxygenArcShow() {
        return this.openOxygenArcShow;
    }

    public final void setOpenOxygenArcShow(int i) {
        this.openOxygenArcShow = i;
    }

    public final int getOxygenArcType() {
        return this.oxygenArcType;
    }

    public final void setOxygenArcType(int i) {
        this.oxygenArcType = i;
    }

    public final int getOxygenArcCenterX() {
        return this.oxygenArcCenterX;
    }

    public final void setOxygenArcCenterX(int i) {
        this.oxygenArcCenterX = i;
    }

    public final int getOxygenArcCenterY() {
        return this.oxygenArcCenterY;
    }

    public final void setOxygenArcCenterY(int i) {
        this.oxygenArcCenterY = i;
    }

    public final List<Drawable> getSpo2ProgressDrawables() {
        return this.spo2ProgressDrawables;
    }

    public final void setSpo2ProgressDrawables(List<? extends Drawable> list) {
        this.spo2ProgressDrawables = list;
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

    private final double calculateSubArc(int width, double radius, int height, double tempLen) {
        double d = radius - (((double) height) / 2.0d);
        double d2 = ((double) width) / 2.0d;
        return Math.acos((((d * d) + (tempLen * tempLen)) - (d2 * d2)) / ((d * 2.0d) * tempLen));
    }

    public final void drawWithoutArc(Canvas canvas) {
        List<? extends Drawable> list;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        ClockConfig config = this.flatter.getConfig();
        if (!config.showBatteryNum() || (list = this.oxygenNumDrawable) == null) {
            return;
        }
        ArrayList<Drawable> arrayList = new ArrayList();
        float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scale;
        int scaleX = 0;
        for (int i = Settings.Global.getInt(this.context.getContentResolver(), "last_oxygen_value", 0); i >= 0; i /= 10) {
            int i2 = i % 10;
            arrayList.add(0, list.get(i2));
            scaleX += (int) (list.get(i2).getIntrinsicWidth() * absoluteScaleX);
            if (i < 10) {
                break;
            }
        }
        Drawable drawable = this.oxygenSignDrawable;
        if (drawable != null) {
            boolean supportScale = getSupportScale();
            float intrinsicWidth = drawable.getIntrinsicWidth();
            if (supportScale) {
                intrinsicWidth *= this.flatter.getAbsoluteScaleX();
            }
            scaleX += (int) (intrinsicWidth * this.flatter.getScaleX());
        }
        int intrinsicWidth2 = this.oxygenNumPosition.x;
        int i3 = this.oxygenNumPosition.y;
        if (this.flatter.getConfig().getOxygen_show_type() == 1) {
            intrinsicWidth2 -= scaleX;
        } else if (this.flatter.getConfig().getOxygen_show_type() == 2) {
            scaleX /= 2;
            intrinsicWidth2 -= scaleX;
        }
        for (Drawable drawable2 : arrayList) {
            drawDrawable(canvas, drawable2, intrinsicWidth2, i3, absoluteScaleX, absoluteScaleX);
            intrinsicWidth2 += (int) (drawable2.getIntrinsicWidth() * absoluteScaleX);
        }
        Drawable drawable3 = this.oxygenSignDrawable;
        if (drawable3 != null) {
            drawDrawable(canvas, drawable3, intrinsicWidth2, i3, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
    }

    private final void drawOxygenWithArc(Canvas canvas) {
        double d;
        double d2;
        double length;
        int i = Settings.Global.getInt(this.context.getContentResolver(), "last_oxygen_value", 0);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.ENGLISH, "%03d", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        int oxygen_show_type = this.flatter.getConfig().getOxygen_show_type();
        double d3 = 2.0d;
        if (oxygen_show_type != 0) {
            if (oxygen_show_type == 1) {
                d2 = this.mStartArc;
                length = ((((double) str.length()) * this.mSubArcNum) + this.mSubArcEnd) * 2.0d;
            } else if (oxygen_show_type != 2) {
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
        List<? extends Drawable> list = this.oxygenNumDrawable;
        double d5 = 3.141592653589793d;
        if (list != null) {
            float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : 1.0f;
            float absoluteScaleY = getSupportScale() ? this.flatter.getAbsoluteScaleY() : 1.0f;
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
                double d9 = dCos - (((double) this.mSpo2CellWidth) / 2.0d);
                Drawable drawable = list.get(str.charAt(i2) - '0');
                Intrinsics.checkNotNull(drawable);
                drawDrawable(canvas, drawable, (int) d9, (int) dSin, absoluteScaleX, absoluteScaleY);
                canvas.rotate(-((float) (d8 + ((double) this.mExtraAngle))), f, f2);
                i2++;
                length2 = length2;
                d4 = d6;
                d3 = 2.0d;
                d5 = 3.141592653589793d;
            }
        }
        Drawable drawable2 = this.oxygenSignDrawable;
        if (drawable2 != null) {
            double d10 = d4 + this.mSubArcNum + this.mSubArcEnd;
            double d11 = 1.5707963267948966d - d10;
            double dCos2 = ((double) this.mCircleX) + (this.mCircleR * Math.cos(d11));
            double dSin2 = ((double) this.mCircleY) - (this.mCircleR * Math.sin(d11));
            double d12 = (d10 * 180.0d) / 3.141592653589793d;
            float f3 = (float) dCos2;
            float f4 = (float) dSin2;
            canvas.rotate((float) (((double) this.mExtraAngle) + d12), f3, f4);
            drawDrawable(canvas, drawable2, (int) (dCos2 - (((double) this.mSpo2EndWidth) / 2.0d)), (int) dSin2, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
            canvas.rotate(-((float) (d12 + ((double) this.mExtraAngle))), f3, f4);
        }
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable drawable = this.oxygenDrawable;
        if (drawable != null) {
            drawDrawable(canvas, drawable, this.oxygenPosition.x, this.oxygenPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        List<? extends Drawable> list = this.spo2ProgressDrawables;
        if (list != null) {
            int i = 0;
            int i2 = Settings.Global.getInt(this.context.getContentResolver(), "last_oxygen_value", 0);
            if (i2 < 0 || i2 >= 90) {
                if (i2 >= 0 && i2 < 91) {
                    i = 1;
                } else if (i2 >= 0 && i2 < 92) {
                    i = 2;
                } else if (i2 >= 0 && i2 < 93) {
                    i = 3;
                } else if (i2 >= 0 && i2 < 94) {
                    i = 4;
                } else if (i2 >= 0 && i2 < 95) {
                    i = 5;
                } else if (i2 >= 0 && i2 < 96) {
                    i = 6;
                } else if (i2 >= 0 && i2 < 97) {
                    i = 7;
                } else if (i2 < 0 || i2 >= 98) {
                    i = (i2 < 0 || i2 >= 99) ? 10 : 9;
                } else {
                    i = 8;
                }
            }
            drawDrawable(canvas, list.get(i), this.spo2ProgressPosition.x, this.spo2ProgressPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : 1.0f, getSupportScale() ? this.flatter.getAbsoluteScaleY() : 1.0f);
        }
        if (this.flatter.getConfig().getOpen_oxygen_arc_show() == 0) {
            drawWithoutArc(canvas);
        } else {
            drawOxygenWithArc(canvas);
        }
    }
}
