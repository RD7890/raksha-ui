package com.dw.launcher.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.dw.launcher.R;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class MusicProgressBar extends View {
    private int centerX;
    private int centerY;
    private OnProgressChangeListener changeListener;
    private boolean downOnArc;
    private Drawable mThumb;
    private Drawable mThumbPress;
    private int max;
    private int maxValidateTouchArcRadius;
    private int minValidateTouchArcRadius;
    private int paddingOuterThumb;
    private Paint paint;
    private float pointRadius;
    private float pointWidth;
    private int progress;
    private int radius;
    private int roundColor;
    private int roundProgressColor;
    private float roundWidth;
    private int textColor;
    private float textSize;

    public interface OnProgressChangeListener {
        void onProgressChange(int duration, int progress);

        void onProgressChangeEnd(int duration, int progress);
    }

    public MusicProgressBar(Context context) {
        this(context, null);
    }

    public MusicProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MusicProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.max = 100;
        this.downOnArc = false;
        this.paint = new Paint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.RoundProgressBar);
        this.roundColor = typedArrayObtainStyledAttributes.getColor(R.styleable.RoundProgressBar_roundColor, -65536);
        this.roundProgressColor = typedArrayObtainStyledAttributes.getColor(R.styleable.RoundProgressBar_roundProgressColor, -16711936);
        this.roundWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundProgressBar_roundWidth, 3.0f);
        this.textColor = typedArrayObtainStyledAttributes.getColor(R.styleable.RoundProgressBar_textColor, -16711936);
        this.textSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundProgressBar_textSize, 15.0f);
        this.max = typedArrayObtainStyledAttributes.getInteger(R.styleable.RoundProgressBar_imageMax, 100);
        this.pointRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundProgressBar_pointRadius, 3.0f);
        this.pointWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundProgressBar_pointWidth, 2.0f);
        typedArrayObtainStyledAttributes.recycle();
        Drawable drawable = getResources().getDrawable(R.mipmap.btn_lamp_plate_nor);
        this.mThumb = drawable;
        int intrinsicHeight = drawable.getIntrinsicHeight() / 2;
        int intrinsicWidth = this.mThumb.getIntrinsicWidth() / 2;
        this.mThumb.setBounds(-intrinsicWidth, -intrinsicHeight, intrinsicWidth, intrinsicHeight);
        Drawable drawable2 = getResources().getDrawable(R.mipmap.btn_lamp_plate_down);
        this.mThumbPress = drawable2;
        int intrinsicHeight2 = drawable2.getIntrinsicHeight() / 2;
        int intrinsicWidth2 = this.mThumbPress.getIntrinsicWidth() / 2;
        this.mThumbPress.setBounds(-intrinsicWidth2, -intrinsicHeight2, intrinsicWidth2, intrinsicHeight2);
        this.paddingOuterThumb = intrinsicHeight2;
        this.paint.setAntiAlias(true);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), new int[]{-6199457, -7724954}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setAntiAlias(true);
        canvas.drawCircle(this.centerX, this.centerY, this.radius, this.paint);
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setColor(this.roundProgressColor);
        int i = this.centerX;
        int i2 = this.radius;
        int i3 = this.centerY;
        RectF rectF = new RectF(i - i2, i3 - i2, i + i2, i3 + i2);
        int i4 = (this.progress * 360) / this.max;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setShader(new SweepGradient(270.0f, (this.progress * 360) / this.max, new int[]{Color.parseColor("#FF81AE"), Color.parseColor("#FF2BB7")}, (float[]) null));
        canvas.drawArc(rectF, 270.0f, (this.progress * 360) / this.max, false, this.paint);
        PointF pointFCalcArcEndPointXY = ChartUtil.calcArcEndPointXY(this.centerX, this.centerY, this.radius, (this.progress * 360) / this.max, 270.0f);
        canvas.save();
        canvas.translate(pointFCalcArcEndPointXY.x, pointFCalcArcEndPointXY.y);
        if (this.downOnArc) {
            this.mThumbPress.draw(canvas);
        } else {
            this.mThumb.draw(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.downOnArc) {
                    updateArc(x, y);
                    return true;
                }
            } else {
                this.downOnArc = false;
                invalidate();
                OnProgressChangeListener onProgressChangeListener = this.changeListener;
                if (onProgressChangeListener != null) {
                    onProgressChangeListener.onProgressChangeEnd(this.max, this.progress);
                }
            }
        } else if (isTouchArc(x, y)) {
            this.downOnArc = true;
            updateArc(x, y);
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
        int i = width / 2;
        this.centerX = i;
        int i2 = height / 2;
        this.centerY = i2;
        float fMin = Math.min(i, i2) - (this.roundWidth / 2.0f);
        int i3 = this.paddingOuterThumb;
        int i4 = (int) (fMin - i3);
        this.radius = i4;
        this.minValidateTouchArcRadius = (int) (i4 - (i3 * 1.5f));
        this.maxValidateTouchArcRadius = (int) (i4 + (i3 * 1.5f));
        super.onSizeChanged(width, height, oldw, oldh);
    }

    private void updateArc(int x, int y) {
        double dAtan2 = ((((Math.atan2(y - (getHeight() / 2), x - (getWidth() / 2)) / 3.141592653589793d) + 2.0d) % 2.0d) + 0.5d) % 2.0d;
        int i = this.max;
        int i2 = (int) ((dAtan2 * ((double) i)) / 2.0d);
        this.progress = i2;
        OnProgressChangeListener onProgressChangeListener = this.changeListener;
        if (onProgressChangeListener != null) {
            onProgressChangeListener.onProgressChange(i, i2);
        }
        invalidate();
    }

    private boolean isTouchArc(int x, int y) {
        double touchRadius = getTouchRadius(x, y);
        return touchRadius >= ((double) this.minValidateTouchArcRadius) && touchRadius <= ((double) this.maxValidateTouchArcRadius);
    }

    private double getTouchRadius(int x, int y) {
        return Math.hypot(x - (getWidth() / 2), y - (getHeight() / 2));
    }

    private String getTimeText(int progress) {
        int i = progress / 60;
        int i2 = progress % 60;
        return (i < 10 ? "0" : "") + i + ":" + (i2 >= 10 ? "" : "0") + i2;
    }

    public synchronized int getMax() {
        return this.max;
    }

    public synchronized void setMax(int max) {
        try {
            if (max < 0) {
                throw new IllegalArgumentException("max not less than 0");
            }
            this.max = max;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int getProgress() {
        return this.progress;
    }

    public synchronized void setProgress(int progress) {
        try {
            if (progress < 0) {
                throw new IllegalArgumentException("progress not less than 0");
            }
            int i = this.max;
            if (progress > i) {
                progress = i;
            }
            if (progress <= i) {
                this.progress = progress;
                postInvalidate();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public int getCricleColor() {
        return this.roundColor;
    }

    public void setCricleColor(int cricleColor) {
        this.roundColor = cricleColor;
    }

    public int getCricleProgressColor() {
        return this.roundProgressColor;
    }

    public void setCricleProgressColor(int cricleProgressColor) {
        this.roundProgressColor = cricleProgressColor;
    }

    public float getRoundWidth() {
        return this.roundWidth;
    }

    public void setRoundWidth(float roundWidth) {
        this.roundWidth = roundWidth;
    }

    public static class ChartUtil {
        public static PointF calcArcEndPointXY(float cirX, float cirY, float radius, float cirAngle) {
            double dSin;
            double dSin2;
            float f = (float) ((((double) cirAngle) * 3.141592653589793d) / 180.0d);
            if (cirAngle < 90.0f) {
                double d = f;
                cirX += ((float) Math.cos(d)) * radius;
                dSin2 = Math.sin(d);
            } else {
                if (cirAngle == 90.0f) {
                    cirY += radius;
                } else if (cirAngle > 90.0f && cirAngle < 180.0f) {
                    double d2 = (float) ((((double) (180.0f - cirAngle)) * 3.141592653589793d) / 180.0d);
                    cirX -= ((float) Math.cos(d2)) * radius;
                    dSin2 = Math.sin(d2);
                } else if (cirAngle == 180.0f) {
                    cirX -= radius;
                } else {
                    if (cirAngle > 180.0f && cirAngle < 270.0f) {
                        double d3 = (float) ((((double) (cirAngle - 180.0f)) * 3.141592653589793d) / 180.0d);
                        cirX -= ((float) Math.cos(d3)) * radius;
                        dSin = Math.sin(d3);
                    } else if (cirAngle == 270.0f) {
                        cirY -= radius;
                    } else {
                        double d4 = (float) ((((double) (360.0f - cirAngle)) * 3.141592653589793d) / 180.0d);
                        cirX += ((float) Math.cos(d4)) * radius;
                        dSin = Math.sin(d4);
                    }
                    cirY -= ((float) dSin) * radius;
                }
                return new PointF(cirX, cirY);
            }
            cirY += ((float) dSin2) * radius;
            return new PointF(cirX, cirY);
        }

        public static PointF calcArcEndPointXY(float cirX, float cirY, float radius, float cirAngle, float orginAngle) {
            return calcArcEndPointXY(cirX, cirY, radius, (orginAngle + cirAngle) % 360.0f);
        }
    }

    public void setChangeListener(OnProgressChangeListener changeListener) {
        this.changeListener = changeListener;
    }
}
