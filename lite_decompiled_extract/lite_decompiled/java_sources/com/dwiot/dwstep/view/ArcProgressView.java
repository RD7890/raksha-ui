package com.dwiot.dwstep.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.content.res.ResourcesCompat;
import com.dwiot.dwstep.R;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ArcProgressView.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 l2\u00020\u0001:\u0001lB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u00162\u0006\u0010I\u001a\u00020\u00162\u0006\u0010J\u001a\u00020\u0016H\u0002J \u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\u00162\u0006\u0010I\u001a\u00020\u00162\u0006\u0010J\u001a\u00020\u0016H\u0002J\u0016\u0010M\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0016JZ\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020\u00162\u0006\u0010U\u001a\u00020\u00162\u0006\u0010V\u001a\u00020\f2\u0006\u0010W\u001a\u00020\u00162\u0006\u0010X\u001a\u00020\u000e2\u0006\u0010Y\u001a\u00020Z2\b\b\u0002\u0010[\u001a\u00020\u00162\b\b\u0002\u0010\\\u001a\u00020\u0016J0\u0010]\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010^\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020%2\u0006\u0010T\u001a\u00020\u00162\u0006\u0010U\u001a\u00020\u0016H\u0002J0\u0010`\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010^\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020%2\u0006\u0010T\u001a\u00020\u00162\u0006\u0010U\u001a\u00020\u0016H\u0002J\u000e\u0010a\u001a\u00020Z2\u0006\u0010b\u001a\u00020cJ\u0010\u0010d\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0014J\u0018\u0010e\u001a\u00020P2\u0006\u0010f\u001a\u00020\u000e2\u0006\u0010g\u001a\u00020\u000eH\u0014J\u0018\u0010h\u001a\u00020P2\u0006\u0010i\u001a\u00020\u00012\u0006\u0010j\u001a\u00020\u000eH\u0014J\u0006\u0010k\u001a\u00020PR\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u0016X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010-\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0010R\u001a\u0010/\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\u0014\u00102\u001a\u00020\u0016X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u001a\u00104\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010'\"\u0004\b6\u0010)R\u000e\u00107\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010<\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0010R\u001a\u0010>\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001f\"\u0004\b@\u0010!R\u0014\u0010A\u001a\u00020\u0016X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u001fR\u001a\u0010C\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010'\"\u0004\bE\u0010)R\u000e\u0010F\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Lcom/dwiot/dwstep/view/ArcProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ARC_WIDTH_SCALE", "", "getARC_WIDTH_SCALE", "()D", "animate", "", "animateDuration", "", "getAnimateDuration", "()I", "setAnimateDuration", "(I)V", "animator", "Landroid/animation/ValueAnimator;", "arcWidth", "", "bgCirclePaint", "Landroid/graphics/Paint;", "caloCircleEndColor", "", "caloriesColor", "getCaloriesColor", "calories_current_angle", "getCalories_current_angle", "()F", "setCalories_current_angle", "(F)V", "calories_start_angle", "getCalories_start_angle", "calories_value", "", "getCalories_value", "()Ljava/lang/String;", "setCalories_value", "(Ljava/lang/String;)V", "circleRect", "Landroid/graphics/RectF;", "distanceCircleColorList", "distanceColor", "getDistanceColor", "distance_current_angle", "getDistance_current_angle", "setDistance_current_angle", "distance_start_angle", "getDistance_start_angle", "distance_value", "getDistance_value", "setDistance_value", "mPaint", "mStepTextPainter", "rotateMatrix", "Landroid/graphics/Matrix;", "stepCircleStartColor", "stepColor", "getStepColor", "step_current_angle", "getStep_current_angle", "setStep_current_angle", "step_start_angle", "getStep_start_angle", "step_value", "getStep_value", "setStep_value", "viewSize", "calculateX", "centerX", "radius", "angle", "calculateY", "centerY", "dpToPx", "dp", "drawOval", "", "canvas", "Landroid/graphics/Canvas;", "colorList", "start_angle", "max_angle", "reverse", "destDegree", "bgColor", "bitmap", "Landroid/graphics/Bitmap;", "bitmap_x", "bitmap_y", "drawStepTextOnPath", "color", "value", "drawTextOnPath", "drawableToBitmap", "drawable", "Landroid/graphics/drawable/Drawable;", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onVisibilityChanged", "changedView", "visibility", "startAnimateProgress", "Companion", "Step_release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ArcProgressView extends View {
    private final double ARC_WIDTH_SCALE;
    private final boolean animate;
    private int animateDuration;
    private ValueAnimator animator;
    private float arcWidth;
    private final Paint bgCirclePaint;
    private final int[] caloCircleEndColor;
    private final int caloriesColor;
    private float calories_current_angle;
    private final float calories_start_angle;
    private String calories_value;
    private final RectF circleRect;
    private final int[] distanceCircleColorList;
    private final int distanceColor;
    private float distance_current_angle;
    private final float distance_start_angle;
    private String distance_value;
    private final Paint mPaint;
    private final Paint mStepTextPainter;
    private final Matrix rotateMatrix;
    private final int[] stepCircleStartColor;
    private final int stepColor;
    private float step_current_angle;
    private final float step_start_angle;
    private String step_value;
    private float viewSize;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float step_max_angle = 80.0f;
    private static final float distance_max_angle = 80.0f;
    private static final float calories_max_angle = 80.0f;

    /* JADX INFO: compiled from: ArcProgressView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/dwiot/dwstep/view/ArcProgressView$Companion;", "", "()V", "calories_max_angle", "", "getCalories_max_angle", "()F", "distance_max_angle", "getDistance_max_angle", "step_max_angle", "getStep_max_angle", "Step_release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final float getStep_max_angle() {
            return ArcProgressView.step_max_angle;
        }

        public final float getDistance_max_angle() {
            return ArcProgressView.distance_max_angle;
        }

        public final float getCalories_max_angle() {
            return ArcProgressView.calories_max_angle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArcProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.step_start_angle = -30.0f;
        this.distance_start_angle = 90.0f;
        this.calories_start_angle = 210.0f;
        int color = Color.parseColor("#ffA23E2F");
        this.stepColor = color;
        this.caloriesColor = Color.parseColor("#ff985917");
        this.distanceColor = Color.parseColor("#ff0E7FA1");
        Paint paint = new Paint();
        this.mPaint = paint;
        Paint paint2 = new Paint();
        this.bgCirclePaint = paint2;
        this.ARC_WIDTH_SCALE = 0.2d;
        this.circleRect = new RectF();
        this.rotateMatrix = new Matrix();
        Paint paint3 = new Paint();
        this.mStepTextPainter = paint3;
        this.step_value = "0";
        this.distance_value = "0";
        this.calories_value = "0";
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.stepCircleStartColor = new int[]{-365496, -365496};
        this.caloCircleEndColor = new int[]{-1793255, -1793255};
        this.distanceCircleColorList = new int[]{-16588295, -16588295};
        paint3.setTypeface(ResourcesCompat.getFont(getContext(), R.font.segoe_ui));
        paint3.setStyle(Paint.Style.FILL);
        paint3.setAntiAlias(true);
        paint3.setTextSize(dpToPx(context, 25.0f));
        paint3.setColor(color);
        this.animate = true;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfFloat, "ofFloat(...)");
        this.animator = valueAnimatorOfFloat;
        this.animateDuration = 2500;
    }

    public final float getStep_start_angle() {
        return this.step_start_angle;
    }

    public final float getStep_current_angle() {
        return this.step_current_angle;
    }

    public final void setStep_current_angle(float f) {
        this.step_current_angle = f;
    }

    public final float getDistance_start_angle() {
        return this.distance_start_angle;
    }

    public final float getDistance_current_angle() {
        return this.distance_current_angle;
    }

    public final void setDistance_current_angle(float f) {
        this.distance_current_angle = f;
    }

    public final float getCalories_start_angle() {
        return this.calories_start_angle;
    }

    public final float getCalories_current_angle() {
        return this.calories_current_angle;
    }

    public final void setCalories_current_angle(float f) {
        this.calories_current_angle = f;
    }

    public final int getStepColor() {
        return this.stepColor;
    }

    public final int getCaloriesColor() {
        return this.caloriesColor;
    }

    public final int getDistanceColor() {
        return this.distanceColor;
    }

    public final double getARC_WIDTH_SCALE() {
        return this.ARC_WIDTH_SCALE;
    }

    public final String getStep_value() {
        return this.step_value;
    }

    public final void setStep_value(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.step_value = str;
    }

    public final String getDistance_value() {
        return this.distance_value;
    }

    public final void setDistance_value(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.distance_value = str;
    }

    public final String getCalories_value() {
        return this.calories_value;
    }

    public final void setCalories_value(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.calories_value = str;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode == 1073741824 && mode2 == 1073741824) {
            setMeasuredDimension(size, size2);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
        float fCoerceAtMost = RangesKt.coerceAtMost(getMeasuredWidth(), getMeasuredHeight());
        this.viewSize = fCoerceAtMost;
        float f = (float) (((double) fCoerceAtMost) * this.ARC_WIDTH_SCALE);
        this.arcWidth = f;
        this.mPaint.setStrokeWidth(f);
        this.bgCirclePaint.setStrokeWidth(this.arcWidth);
    }

    private final double calculateX(float centerX, float radius, float angle) {
        return ((double) centerX) + (((double) radius) * Math.cos(Math.toRadians(angle)));
    }

    private final double calculateY(float centerY, float radius, float angle) {
        return ((double) centerY) + (((double) radius) * Math.sin(Math.toRadians(angle)));
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float f = this.viewSize;
        float f2 = 2;
        double dCalculateX = calculateX(f / f2, (f / f2) - (this.arcWidth / f2), this.step_start_angle);
        float f3 = this.viewSize;
        double dCalculateY = calculateY(f3 / f2, (f3 / f2) - (this.arcWidth / f2), this.step_start_angle);
        int[] iArr = this.stepCircleStartColor;
        float f4 = this.step_start_angle;
        float f5 = step_max_angle;
        float fCoerceIn = RangesKt.coerceIn(this.step_current_angle, 1.0f, f5);
        int i = this.stepColor;
        Drawable drawable = getResources().getDrawable(R.mipmap.step_mid_icon);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(...)");
        drawOval(canvas, iArr, f4, f5, true, fCoerceIn, i, drawableToBitmap(drawable), (float) dCalculateX, (float) dCalculateY);
        float f6 = this.viewSize;
        double dCalculateX2 = calculateX(f6 / f2, (f6 / f2) - (this.arcWidth / f2), this.calories_start_angle);
        float f7 = this.viewSize;
        double dCalculateY2 = calculateY(f7 / f2, (f7 / f2) - (this.arcWidth / f2), this.calories_start_angle);
        int[] iArr2 = this.caloCircleEndColor;
        float f8 = this.calories_start_angle;
        float f9 = calories_max_angle;
        float fCoerceIn2 = RangesKt.coerceIn(this.calories_current_angle, 1.0f, f5);
        int i2 = this.caloriesColor;
        Drawable drawable2 = getResources().getDrawable(R.mipmap.calo_mid_icon);
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(...)");
        drawOval(canvas, iArr2, f8, f9, true, fCoerceIn2, i2, drawableToBitmap(drawable2), (float) dCalculateX2, (float) dCalculateY2);
        float f10 = this.viewSize;
        double dCalculateX3 = calculateX(f10 / f2, (f10 / f2) - (this.arcWidth / f2), this.distance_start_angle);
        float f11 = this.viewSize;
        double dCalculateY3 = calculateY(f11 / f2, (f11 / f2) - (this.arcWidth / f2), this.distance_start_angle);
        int[] iArr3 = this.distanceCircleColorList;
        float f12 = this.distance_start_angle;
        float f13 = distance_max_angle;
        float fCoerceIn3 = RangesKt.coerceIn(this.distance_current_angle, 1.0f, f5);
        int i3 = this.distanceColor;
        Drawable drawable3 = getResources().getDrawable(R.mipmap.distance_mid_icon);
        Intrinsics.checkNotNullExpressionValue(drawable3, "getDrawable(...)");
        drawOval(canvas, iArr3, f12, f13, true, fCoerceIn3, i3, drawableToBitmap(drawable3), (float) dCalculateX3, (float) dCalculateY3);
        drawStepTextOnPath(canvas, this.stepColor, this.step_value, this.step_start_angle, -f5);
        drawTextOnPath(canvas, this.caloriesColor, this.calories_value, this.calories_start_angle, -f5);
        drawTextOnPath(canvas, this.distanceColor, this.distance_value, this.distance_start_angle, -f5);
    }

    public final void drawOval(Canvas canvas, int[] colorList, float start_angle, float max_angle, boolean reverse, float destDegree, int bgColor, Bitmap bitmap, float bitmap_x, float bitmap_y) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(colorList, "colorList");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        float f = 2;
        float f2 = this.viewSize / f;
        float f3 = step_max_angle;
        float[] fArr = {0.0f, destDegree / f3};
        if (destDegree > f3) {
            fArr[1] = 1.0f;
        }
        SweepGradient sweepGradient = new SweepGradient(f2, f2, colorList, fArr);
        sweepGradient.setLocalMatrix(this.rotateMatrix);
        this.mPaint.setShader(sweepGradient);
        float f4 = this.arcWidth / f;
        RectF rectF = this.circleRect;
        float f5 = this.viewSize;
        rectF.set(f4, f4, f5 - f4, f5 - f4);
        this.bgCirclePaint.setColor(bgColor);
        float f6 = max_angle;
        if (reverse) {
            f6 = -f6;
        }
        float f7 = f6;
        float f8 = reverse ? -destDegree : destDegree;
        canvas.drawArc(this.circleRect, start_angle, f7, false, this.bgCirclePaint);
        canvas.drawArc(this.circleRect, start_angle, f8, false, this.mPaint);
        canvas.drawBitmap(bitmap, bitmap_x - (bitmap.getWidth() / 2), bitmap_y - (bitmap.getHeight() / 2), this.mPaint);
    }

    private final void drawStepTextOnPath(Canvas canvas, int color, String value, float start_angle, float max_angle) {
        Path path = new Path();
        this.mStepTextPainter.setColor(-1);
        Rect rect = new Rect();
        this.mStepTextPainter.getTextBounds(value, 0, value.length(), rect);
        float f = 2;
        float degrees = (float) Math.toDegrees(rect.width() / (this.viewSize / f));
        float f2 = 20;
        path.addArc(this.circleRect, (start_angle - f2) - degrees, (f2 + degrees) - start_angle);
        canvas.drawTextOnPath(value, path, 0.0f, rect.height() / f, this.mStepTextPainter);
    }

    private final void drawTextOnPath(Canvas canvas, int color, String value, float start_angle, float max_angle) {
        Path path = new Path();
        this.mStepTextPainter.setColor(-1);
        path.addArc(this.circleRect, start_angle - 20, max_angle);
        canvas.drawTextOnPath(value, path, 0.0f, 0.0f, this.mStepTextPainter);
    }

    public final Bitmap drawableToBitmap(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        Intrinsics.checkNotNull(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    public final int getAnimateDuration() {
        return this.animateDuration;
    }

    public final void setAnimateDuration(int i) {
        this.animateDuration = i;
    }

    public final void startAnimateProgress() {
        if (this.animate) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f, this.step_current_angle / step_max_angle);
            Intrinsics.checkNotNullExpressionValue(valueAnimatorOfFloat, "ofFloat(...)");
            this.animator = valueAnimatorOfFloat;
            if (valueAnimatorOfFloat.isRunning()) {
                this.animator.end();
            }
            final float f = this.step_current_angle;
            final float f2 = this.calories_current_angle;
            final float f3 = this.distance_current_angle;
            this.animator.setDuration(this.animateDuration);
            this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
            this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.dwiot.dwstep.view.ArcProgressView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ArcProgressView.startAnimateProgress$lambda$1(this.f$0, valueAnimator);
                }
            });
            this.animator.addListener(new Animator.AnimatorListener() { // from class: com.dwiot.dwstep.view.ArcProgressView.startAnimateProgress.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    ActiveProgressCircle.Companion companion = ActiveProgressCircle.INSTANCE;
                    ArcProgressView arcProgressView = ArcProgressView.this;
                    float f4 = f;
                    float f5 = f2;
                    float f6 = f3;
                    arcProgressView.setStep_current_angle(f4);
                    arcProgressView.setCalories_current_angle(f5);
                    arcProgressView.setDistance_current_angle(f6);
                    arcProgressView.invalidate();
                }
            });
            this.animator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimateProgress$lambda$1(ArcProgressView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        this$0.step_current_angle = step_max_angle * fFloatValue;
        this$0.calories_current_angle = calories_max_angle * fFloatValue;
        this$0.distance_current_angle = fFloatValue * distance_max_angle;
        this$0.invalidate();
    }

    public final float dpToPx(Context context, float dp) {
        Intrinsics.checkNotNullParameter(context, "context");
        return TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
    }
}
