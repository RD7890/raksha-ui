package com.dw.launcher.ui.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.dw.launcher.R;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ActiveProgressCircle.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 F2\u00020\u0001:\u0001FB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J:\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u000209H\u0002J\u000e\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020<J\u001e\u0010=\u001a\u0002012\u0006\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u0012J\u0012\u0010A\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0014J\u0018\u0010B\u001a\u0002012\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\nH\u0014J\u0006\u0010E\u001a\u000201R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001c\"\u0004\b#\u0010\u001eR\u000e\u0010$\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001eR\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/dw/launcher/ui/view/ActiveProgressCircle;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animate", "", "animateDuration", "", "getAnimateDuration", "()I", "setAnimateDuration", "(I)V", "animator", "Landroid/animation/ValueAnimator;", "arcWidth", "", "bgCirclePaint", "Landroid/graphics/Paint;", "circleRect", "Landroid/graphics/RectF;", "circleSpace", "innerCircleColorList", "", "innerDestDegree", "getInnerDestDegree", "()F", "setInnerDestDegree", "(F)V", "mPaint", "midCircleColorList", "midDestDegree", "getMidDestDegree", "setMidDestDegree", "outCircleColorList", "outCircleEndColor", "outCircleStartColor", "outDestDegree", "getOutDestDegree", "setOutDestDegree", "rotateMatrix", "Landroid/graphics/Matrix;", "shadowColorArray", "shadowPaint", "startEndCirclePaint", "viewSize", "drawColorArc", "", "canvas", "Landroid/graphics/Canvas;", "colorList", "offset", "destDegree", "bgColor", "bitmap", "Landroid/graphics/Bitmap;", "drawableToBitmap", "drawable", "Landroid/graphics/drawable/Drawable;", "increaseWithAnim", "outDegree", "midDegree", "innerDegree", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "startAnimateProgress", "Companion", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ActiveProgressCircle extends View {
    public static final double ARC_WIDTH_SCALE = 0.12d;
    public static final double CIRCLE_SPACE_SCALE = 0.01d;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int SHADOW_DEGREE_OFFSET = 5;
    public static final float START_ANGLE = -90.0f;
    public static final String TAG = "ActiveProgressCircle";
    private final boolean animate;
    private int animateDuration;
    private final ValueAnimator animator;
    private float arcWidth;
    private final Paint bgCirclePaint;
    private final RectF circleRect;
    private float circleSpace;
    private final int[] innerCircleColorList;
    private float innerDestDegree;
    private final Paint mPaint;
    private final int[] midCircleColorList;
    private float midDestDegree;
    private final int[] outCircleColorList;
    private final int outCircleEndColor;
    private final int outCircleStartColor;
    private float outDestDegree;
    private final Matrix rotateMatrix;
    private int[] shadowColorArray;
    private final Paint shadowPaint;
    private final Paint startEndCirclePaint;
    private float viewSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActiveProgressCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.animateDuration = 1800;
        this.circleRect = new RectF();
        this.rotateMatrix = new Matrix();
        Paint paint = new Paint();
        this.startEndCirclePaint = paint;
        this.shadowPaint = new Paint();
        Paint paint2 = new Paint();
        this.bgCirclePaint = paint2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ColorfulProgressCircle);
        this.animate = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ColorfulProgressCircle_animate, false);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.ColorfulProgressCircle_outCircleStartColor, -14628353);
        this.outCircleStartColor = color;
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.ColorfulProgressCircle_outCircleEndColor, -14628353);
        this.outCircleEndColor = color2;
        this.outCircleColorList = new int[]{color, color2};
        this.midCircleColorList = new int[]{-14483629, -14483629};
        this.innerCircleColorList = new int[]{-708560, -708560};
        typedArrayObtainStyledAttributes.recycle();
        Paint paint3 = new Paint();
        this.mPaint = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setAntiAlias(true);
        paint3.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.FILL);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.shadowColorArray = new int[]{getResources().getColor(R.color.black), getResources().getColor(R.color.black), getResources().getColor(R.color.black)};
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfFloat, "ofFloat(...)");
        this.animator = valueAnimatorOfFloat;
    }

    /* JADX INFO: compiled from: ActiveProgressCircle.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/dw/launcher/ui/view/ActiveProgressCircle$Companion;", "", "()V", "ARC_WIDTH_SCALE", "", "CIRCLE_SPACE_SCALE", "SHADOW_DEGREE_OFFSET", "", "START_ANGLE", "", "TAG", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final int getAnimateDuration() {
        return this.animateDuration;
    }

    public final void setAnimateDuration(int i) {
        this.animateDuration = i;
    }

    public final float getOutDestDegree() {
        return this.outDestDegree;
    }

    public final void setOutDestDegree(float f) {
        this.outDestDegree = f;
    }

    public final float getMidDestDegree() {
        return this.midDestDegree;
    }

    public final void setMidDestDegree(float f) {
        this.midDestDegree = f;
    }

    public final float getInnerDestDegree() {
        return this.innerDestDegree;
    }

    public final void setInnerDestDegree(float f) {
        this.innerDestDegree = f;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        float fCoerceAtMost = RangesKt.coerceAtMost(getMeasuredWidth(), getMeasuredHeight());
        this.viewSize = fCoerceAtMost;
        float f = (float) (((double) fCoerceAtMost) * 0.12d);
        this.arcWidth = f;
        this.circleSpace = fCoerceAtMost * 0.01f;
        this.mPaint.setStrokeWidth(f);
        this.bgCirclePaint.setStrokeWidth(this.arcWidth);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int[] iArr = this.outCircleColorList;
        float f = 2;
        float f2 = this.arcWidth / f;
        float fCoerceAtMost = RangesKt.coerceAtMost(this.outDestDegree, 270.0f);
        Drawable drawable = getResources().getDrawable(R.mipmap.step_small_icon);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(...)");
        drawColorArc(canvas, iArr, f2, fCoerceAtMost, -14992988, drawableToBitmap(drawable));
        float f3 = this.arcWidth;
        float f4 = f3 + (f3 / 2.0f) + this.circleSpace;
        int[] iArr2 = this.midCircleColorList;
        float fCoerceAtMost2 = RangesKt.coerceAtMost(this.midDestDegree, 270.0f);
        Drawable drawable2 = getResources().getDrawable(R.mipmap.distance_small_icon);
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(...)");
        drawColorArc(canvas, iArr2, f4, fCoerceAtMost2, -14712524, drawableToBitmap(drawable2));
        float f5 = this.arcWidth;
        float f6 = (f * f5) + (f5 / 2.0f);
        float f7 = this.circleSpace;
        float f8 = f6 + f7 + f7;
        int[] iArr3 = this.innerCircleColorList;
        float fCoerceAtMost3 = RangesKt.coerceAtMost(this.innerDestDegree, 270.0f);
        Drawable drawable3 = getResources().getDrawable(R.mipmap.calo_small_icon);
        Intrinsics.checkNotNullExpressionValue(drawable3, "getDrawable(...)");
        drawColorArc(canvas, iArr3, f8, fCoerceAtMost3, -8052704, drawableToBitmap(drawable3));
    }

    private final void drawColorArc(Canvas canvas, int[] colorList, float offset, float destDegree, int bgColor, Bitmap bitmap) {
        float f = this.viewSize / 2;
        float[] fArr = {0.0f, destDegree / 270.0f};
        if (destDegree > 270.0f) {
            fArr[1] = 1.0f;
        }
        SweepGradient sweepGradient = new SweepGradient(f, f, colorList, fArr);
        sweepGradient.setLocalMatrix(this.rotateMatrix);
        this.mPaint.setShader(sweepGradient);
        RectF rectF = this.circleRect;
        float f2 = this.viewSize;
        rectF.set(offset, offset, f2 - offset, f2 - offset);
        this.bgCirclePaint.setColor(bgColor);
        if (canvas != null) {
            canvas.drawArc(this.circleRect, -90.0f, 270.0f, false, this.bgCirclePaint);
        }
        if (canvas != null) {
            canvas.drawArc(this.circleRect, -90.0f, destDegree, false, this.mPaint);
        }
        if (canvas != null) {
            canvas.drawBitmap(bitmap, f - (bitmap.getWidth() / 2), offset - (bitmap.getHeight() / 2), this.mPaint);
        }
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

    public final void startAnimateProgress() {
        if (this.animate) {
            if (this.animator.isRunning()) {
                this.animator.end();
            }
            final float f = this.outDestDegree;
            final float f2 = this.midDestDegree;
            final float f3 = this.innerDestDegree;
            this.animator.setDuration(this.animateDuration);
            this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
            this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.dw.launcher.ui.view.ActiveProgressCircle$$ExternalSyntheticLambda1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ActiveProgressCircle.startAnimateProgress$lambda$1(this.f$0, f, f2, f3, valueAnimator);
                }
            });
            this.animator.addListener(new Animator.AnimatorListener() { // from class: com.dw.launcher.ui.view.ActiveProgressCircle.startAnimateProgress.2
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
                    Companion companion = ActiveProgressCircle.INSTANCE;
                    ActiveProgressCircle activeProgressCircle = ActiveProgressCircle.this;
                    float f4 = f;
                    float f5 = f2;
                    float f6 = f3;
                    activeProgressCircle.setOutDestDegree(f4);
                    activeProgressCircle.setMidDestDegree(f5);
                    activeProgressCircle.setInnerDestDegree(f6);
                    activeProgressCircle.invalidate();
                }
            });
            this.animator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimateProgress$lambda$1(ActiveProgressCircle this$0, float f, float f2, float f3, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        this$0.outDestDegree = f * fFloatValue;
        this$0.midDestDegree = f2 * fFloatValue;
        this$0.innerDestDegree = fFloatValue * f3;
        this$0.invalidate();
    }

    public final void increaseWithAnim(final float outDegree, final float midDegree, final float innerDegree) {
        if (this.animate) {
            if (this.animator.isRunning()) {
                this.animator.end();
            }
            final float f = this.outDestDegree;
            final float f2 = this.midDestDegree;
            final float f3 = this.innerDestDegree;
            this.animator.setDuration(this.animateDuration);
            this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
            this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.dw.launcher.ui.view.ActiveProgressCircle$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ActiveProgressCircle.increaseWithAnim$lambda$3(this.f$0, f, outDegree, f2, midDegree, f3, innerDegree, valueAnimator);
                }
            });
            this.animator.addListener(new Animator.AnimatorListener() { // from class: com.dw.launcher.ui.view.ActiveProgressCircle.increaseWithAnim.2
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
                    Companion companion = ActiveProgressCircle.INSTANCE;
                    ActiveProgressCircle activeProgressCircle = ActiveProgressCircle.this;
                    float f4 = outDegree;
                    float f5 = midDegree;
                    float f6 = innerDegree;
                    activeProgressCircle.setOutDestDegree(activeProgressCircle.getOutDestDegree() + f4);
                    activeProgressCircle.setMidDestDegree(activeProgressCircle.getMidDestDegree() + f5);
                    activeProgressCircle.setInnerDestDegree(activeProgressCircle.getInnerDestDegree() + f6);
                    activeProgressCircle.invalidate();
                }
            });
            this.animator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void increaseWithAnim$lambda$3(ActiveProgressCircle this$0, float f, float f2, float f3, float f4, float f5, float f6, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        this$0.outDestDegree = f + (f2 * fFloatValue);
        this$0.midDestDegree = f3 + (f4 * fFloatValue);
        this$0.innerDestDegree = f5 + (fFloatValue * f6);
        this$0.invalidate();
    }
}
