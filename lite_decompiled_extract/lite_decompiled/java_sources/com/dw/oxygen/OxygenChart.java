package com.dw.oxygen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class OxygenChart extends View {
    private int MAXVALUE;
    float baseBottomHeight;
    String bottomText;
    Rect bottomTextHeihtRect;
    List<String> bottomTextList;
    float circleRadus;
    private Context context;
    float endMaxHeight;
    int endRate;
    int lineColor;
    int lineSlideColor;
    int lineWidth;
    Paint mDashPaint;
    float mHeight;
    Paint mPaint;
    Paint mPathBgPaint;
    Paint mSlideLinePaint;
    Paint mStokePaint;
    float mWidth;
    DisplayMetrics outMetrics;
    int paddingHeight;
    float perDotGap;
    float perLineWidth;
    Point[] points;
    List<Integer> positionIndexList;
    List<Integer> potLists;
    float start0Height;
    float start0WidthPosition;
    float startPotPadding;
    private int startRate;
    int touchPos;

    public OxygenChart(Context context) {
        super(context);
        this.lineSlideColor = -1;
        this.lineColor = -8947849;
        this.lineWidth = dipToPx(1.5f);
        this.mWidth = 0.0f;
        this.mHeight = 0.0f;
        this.bottomText = "00:00";
        this.startRate = 0;
        this.endRate = 100;
        this.MAXVALUE = 100;
        this.startPotPadding = 0.0f;
        this.potLists = new ArrayList();
        this.positionIndexList = new ArrayList();
        this.bottomTextList = new ArrayList();
        this.baseBottomHeight = 0.0f;
        this.perLineWidth = 0.0f;
        this.perDotGap = dipToPx(5.0f);
        this.start0Height = 0.0f;
        this.endMaxHeight = 0.0f;
        this.start0WidthPosition = 0.0f;
        this.circleRadus = dipToPx(2.0f);
        this.touchPos = -1;
        init();
    }

    public OxygenChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lineSlideColor = -1;
        this.lineColor = -8947849;
        this.lineWidth = dipToPx(1.5f);
        this.mWidth = 0.0f;
        this.mHeight = 0.0f;
        this.bottomText = "00:00";
        this.startRate = 0;
        this.endRate = 100;
        this.MAXVALUE = 100;
        this.startPotPadding = 0.0f;
        this.potLists = new ArrayList();
        this.positionIndexList = new ArrayList();
        this.bottomTextList = new ArrayList();
        this.baseBottomHeight = 0.0f;
        this.perLineWidth = 0.0f;
        this.perDotGap = dipToPx(5.0f);
        this.start0Height = 0.0f;
        this.endMaxHeight = 0.0f;
        this.start0WidthPosition = 0.0f;
        this.circleRadus = dipToPx(2.0f);
        this.touchPos = -1;
        this.context = context;
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(this.lineColor);
        this.mPaint.setStrokeWidth(this.lineWidth);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextSize(dipToPx(16.0f));
        Paint paint2 = new Paint();
        this.mSlideLinePaint = paint2;
        paint2.setColor(this.lineSlideColor);
        this.mSlideLinePaint.setStrokeWidth(0.75f);
        this.mSlideLinePaint.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.mStokePaint = paint3;
        paint3.setColor(-1685150);
        this.mStokePaint.setStrokeWidth(1.5f);
        this.mStokePaint.setStyle(Paint.Style.STROKE);
        this.mStokePaint.setStrokeJoin(Paint.Join.ROUND);
        this.mStokePaint.setAntiAlias(true);
        Paint paint4 = new Paint();
        this.mPathBgPaint = paint4;
        paint4.setAntiAlias(true);
        this.mPathBgPaint.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.mDashPaint = paint5;
        paint5.setColor(-10592674);
        this.mDashPaint.setAntiAlias(true);
        this.mDashPaint.setStyle(Paint.Style.STROKE);
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        this.bottomTextHeihtRect = new Rect();
        Paint paint6 = this.mPaint;
        String str = this.bottomText;
        paint6.getTextBounds(str, 0, str.length(), this.bottomTextHeihtRect);
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        this.outMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(this.outMetrics);
        this.mDashPaint.setPathEffect(new DashPathEffect(new float[]{dipToPx(10.0f), dipToPx(3.0f)}, 0.0f));
        this.bottomTextList.add("00:00");
        this.bottomTextList.add("06:00");
        this.bottomTextList.add("12:00");
        this.bottomTextList.add("18:00");
        this.bottomTextList.add("24:00");
    }

    private int dipToPx(float f) {
        return (int) ((getContext().getResources().getDisplayMetrics().density * f) + ((f >= 0.0f ? 1 : -1) * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mWidth = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float height = getHeight() - getPaddingBottom();
        this.baseBottomHeight = height;
        this.start0Height = (height - this.bottomTextHeihtRect.height()) - dipToPx(6.0f);
        this.paddingHeight = dipToPx(4.0f);
        float paddingTop = getPaddingTop() + this.paddingHeight;
        this.endMaxHeight = paddingTop;
        this.mHeight = this.start0Height - paddingTop;
        this.mPaint.setColor(this.lineColor);
        drawSlideText(canvas);
        this.perLineWidth = (this.mWidth - (this.perDotGap * 23.0f)) / 24.0f;
        drawBottomText(canvas);
        List<Integer> list = this.potLists;
        if (list == null || list.size() < 1) {
            return;
        }
        this.startPotPadding = this.start0WidthPosition;
        calcPointValue();
        drawScrollLine(canvas);
    }

    private void calcPointValue() {
        float fMeasureText = this.start0WidthPosition + this.mPaint.measureText(this.bottomTextList.get(0));
        int size = this.positionIndexList.size();
        this.perLineWidth = (this.mWidth - fMeasureText) / 24.0f;
        this.points = new Point[size];
        for (int i = 0; i < size; i++) {
            float fIntValue = this.potLists.get(i).intValue();
            int i2 = this.MAXVALUE;
            if (fIntValue > i2) {
                fIntValue = i2;
            }
            float potPostionbyIndex = getPotPostionbyIndex(this.positionIndexList.get(i).intValue());
            float f = this.start0Height;
            int i3 = this.startRate;
            this.points[i] = new Point((int) potPostionbyIndex, (int) (f - (((fIntValue - i3) / (this.endRate - i3)) * this.mHeight)));
        }
    }

    private void drawBottomText(Canvas canvas) {
        float f = (this.mWidth - this.start0WidthPosition) / 5.0f;
        for (int i = 0; i < 5; i++) {
            canvas.drawText(this.bottomTextList.get(i), this.start0WidthPosition + (i * f), this.baseBottomHeight, this.mPaint);
        }
    }

    private void drawSlideText(Canvas canvas) {
        float paddingLeft = getPaddingLeft();
        float paddingLeft2 = getPaddingLeft() + this.mSlideLinePaint.measureText("100") + 2.0f;
        this.start0WidthPosition = paddingLeft2;
        this.MAXVALUE = 100;
        int[] iArr = {80, 85, 90, 95, 100};
        this.startRate = iArr[0];
        this.endRate = 100;
        float f = this.start0Height;
        canvas.drawLine(paddingLeft2, f, this.mWidth, f, this.mSlideLinePaint);
        float f2 = this.start0WidthPosition;
        float f3 = this.start0Height;
        int i = this.MAXVALUE;
        int i2 = iArr[0];
        canvas.drawLine(f2, f3, f2, f3 - (((i - i2) / (i - i2)) * this.mHeight), this.mSlideLinePaint);
        Path path = new Path();
        for (int i3 = 0; i3 < 5; i3++) {
            float f4 = this.start0Height;
            int i4 = iArr[i3];
            int i5 = iArr[0];
            float f5 = f4 - (((i4 - i5) / (this.MAXVALUE - i5)) * this.mHeight);
            path.moveTo(this.start0WidthPosition, f5);
            path.lineTo(this.mWidth + paddingLeft, f5);
            canvas.drawText(iArr[i3] + "", paddingLeft, f5 + (this.bottomTextHeihtRect.height() / 2), this.mSlideLinePaint);
        }
        canvas.drawPath(path, this.mDashPaint);
    }

    private void drawScrollLine(Canvas canvas) {
        drawBar(canvas, this.points);
    }

    private void drawBar(Canvas canvas, Point[] pointArr) {
        new Point();
        if (pointArr.length == 1) {
            Point point = pointArr[0];
            drawBars(canvas, point.x, point.y);
        } else {
            for (int i = 0; i < pointArr.length; i++) {
                drawBars(canvas, pointArr[i].x, pointArr[i].y);
            }
        }
    }

    void drawBars(Canvas canvas, float f, float f2) {
        this.mPathBgPaint.setStyle(Paint.Style.FILL);
        this.mPathBgPaint.setShader(new LinearGradient(0.0f, this.endMaxHeight, 0.0f, this.start0Height, new int[]{-1685150, -1685150}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
        float f3 = this.circleRadus;
        RectF rectF = new RectF(f - f3, f2, f + f3, this.start0Height);
        Path path = new Path();
        path.addRoundRect(rectF, new float[]{30.0f, 30.0f, 30.0f, 30.0f, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
        canvas.drawPath(path, this.mPathBgPaint);
    }

    private void drawSelectPath(Canvas canvas, Point[] pointArr) {
        this.mPathBgPaint.setStyle(Paint.Style.FILL);
        new Point();
        new Point();
        Path path = new Path();
        Path path2 = new Path();
        this.mStokePaint.setColor(-1685150);
        this.mPathBgPaint.setShader(new LinearGradient(0.0f, this.endMaxHeight, 0.0f, this.start0Height, new int[]{-857323166, 300304738}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
        if (pointArr.length == 1) {
            Point point = pointArr[0];
            path.moveTo(point.x, point.y);
            this.mStokePaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(point.x, point.y, this.circleRadus, this.mStokePaint);
        }
        this.mStokePaint.setStyle(Paint.Style.STROKE);
        int i = 0;
        while (i < pointArr.length - 1) {
            Point point2 = pointArr[i];
            int i2 = i + 1;
            Point point3 = pointArr[i2];
            if (i == 0) {
                path.moveTo(point2.x, point2.y);
                path2.moveTo(point2.x, point2.y);
            }
            path.lineTo(point3.x, point3.y);
            path2.lineTo(point3.x, point3.y);
            i = i2;
        }
        path.lineTo(pointArr[pointArr.length - 1].x, this.start0Height);
        path.lineTo(pointArr[0].x, this.start0Height);
        path.lineTo(pointArr[0].x, pointArr[0].y);
        canvas.drawPath(path, this.mPathBgPaint);
        canvas.drawPath(path2, this.mStokePaint);
    }

    private float getPotPostionbyIndex(int i) {
        return this.start0WidthPosition + (this.perLineWidth * i) + (this.mPaint.measureText(this.bottomTextList.get(0)) / 2.0f);
    }

    public void setDailyList(List list, List list2) {
        this.potLists = list;
        this.positionIndexList = list2;
        if (list != null && list.size() > 0) {
            this.touchPos = this.potLists.size() - 1;
        }
        invalidate();
    }
}
