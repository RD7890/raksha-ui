package com.dw.launcher.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.dw.launcher.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class SleepBarView extends View {
    private int MAXVALUE;
    float baseBottomHeight;
    String bottomText;
    int bottomTextColor;
    Rect bottomTextHeihtRect;
    List<String> bottomTextList;
    private Context context;
    float endMaxHeight;
    int lineColor;
    int lineWidth;
    Paint mDashPaint;
    Path mDashPath;
    float mHeight;
    Paint mPaint;
    Paint mPathBgPaint;
    Paint mSlideLinePaint;
    Paint mSmallPaint;
    float mSmallStrokeWidth;
    String mText;
    float mWidth;
    DisplayMetrics outMetrics;
    PathEffect pathEffect;
    float perDotGap;
    float perLineWidth;
    float perPotWidth;
    float perlineHeight;
    List<Integer> positionIndexList;
    List<Integer> potListValue;
    int rectColor;
    int sleepdeepcolor;
    int sleeplightcolor;
    int sleepsobercolor;
    float start0Height;
    float start0WidthPosition;
    float startPotPadding;
    private Rect textRect;
    int touchPos;

    public SleepBarView(Context context) {
        super(context);
        this.lineColor = -1;
        this.rectColor = -7733782;
        this.lineWidth = dipToPx(1.0f);
        this.perPotWidth = 0.0f;
        this.mWidth = 0.0f;
        this.mHeight = 0.0f;
        this.bottomText = "00:00";
        this.MAXVALUE = 12;
        this.startPotPadding = 0.0f;
        this.potListValue = new ArrayList();
        this.positionIndexList = new ArrayList();
        this.bottomTextList = new ArrayList();
        this.mSmallStrokeWidth = dipToPx(1.0f);
        this.mText = "0";
        this.bottomTextColor = -9605779;
        this.baseBottomHeight = 0.0f;
        this.perlineHeight = 0.0f;
        this.perLineWidth = 0.0f;
        this.perDotGap = dipToPx(20.0f);
        this.start0Height = 0.0f;
        this.endMaxHeight = 0.0f;
        this.start0WidthPosition = 0.0f;
        this.touchPos = -1;
        init();
    }

    public SleepBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.lineColor = -1;
        this.rectColor = -7733782;
        this.lineWidth = dipToPx(1.0f);
        this.perPotWidth = 0.0f;
        this.mWidth = 0.0f;
        this.mHeight = 0.0f;
        this.bottomText = "00:00";
        this.MAXVALUE = 12;
        this.startPotPadding = 0.0f;
        this.potListValue = new ArrayList();
        this.positionIndexList = new ArrayList();
        this.bottomTextList = new ArrayList();
        this.mSmallStrokeWidth = dipToPx(1.0f);
        this.mText = "0";
        this.bottomTextColor = -9605779;
        this.baseBottomHeight = 0.0f;
        this.perlineHeight = 0.0f;
        this.perLineWidth = 0.0f;
        this.perDotGap = dipToPx(20.0f);
        this.start0Height = 0.0f;
        this.endMaxHeight = 0.0f;
        this.start0WidthPosition = 0.0f;
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
        paint2.setColor(this.lineColor);
        this.mSlideLinePaint.setStrokeWidth(this.lineWidth);
        this.mSlideLinePaint.setStrokeJoin(Paint.Join.ROUND);
        this.mSlideLinePaint.setAntiAlias(true);
        this.mSlideLinePaint.setTextSize(dipToPx(16.0f));
        Paint paint3 = new Paint();
        this.mPathBgPaint = paint3;
        paint3.setAntiAlias(true);
        this.mPathBgPaint.setColor(-1360393);
        this.mPathBgPaint.setStyle(Paint.Style.FILL);
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        this.sleepsobercolor = getContext().getResources().getColor(R.color.sleepsobercolor);
        this.sleepdeepcolor = getContext().getResources().getColor(R.color.sleepdeepcolor);
        this.sleeplightcolor = getContext().getResources().getColor(R.color.sleeplightcolor);
        this.bottomTextHeihtRect = new Rect();
        Paint paint4 = this.mPaint;
        String str = this.bottomText;
        paint4.getTextBounds(str, 0, str.length(), this.bottomTextHeihtRect);
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        this.outMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(this.outMetrics);
        this.bottomTextList.add(getResources().getString(R.string.mon));
        this.bottomTextList.add(getResources().getString(R.string.tue));
        this.bottomTextList.add(getResources().getString(R.string.wed));
        this.bottomTextList.add(getResources().getString(R.string.thu));
        this.bottomTextList.add(getResources().getString(R.string.fri));
        this.bottomTextList.add(getResources().getString(R.string.sat));
        this.bottomTextList.add(getResources().getString(R.string.sun));
        Paint paint5 = new Paint();
        this.mDashPaint = paint5;
        paint5.setColor(-10592674);
        this.mDashPaint.setAntiAlias(true);
        this.mDashPaint.setStyle(Paint.Style.STROKE);
        this.textRect = new Rect();
        Paint paint6 = this.mPaint;
        String str2 = this.mText;
        paint6.getTextBounds(str2, 0, str2.length(), this.textRect);
        Paint paint7 = new Paint();
        this.mSmallPaint = paint7;
        paint7.setColor(this.lineColor);
        this.mSmallPaint.setAntiAlias(true);
        this.mSmallPaint.setStyle(Paint.Style.STROKE);
        this.mSmallPaint.setTextSize(dipToPx(6.0f));
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{dipToPx(10.0f), dipToPx(3.0f)}, 0.0f);
        this.pathEffect = dashPathEffect;
        this.mDashPaint.setPathEffect(dashPathEffect);
        this.mDashPath = new Path();
        this.mDashPaint.setStrokeWidth(this.mSmallStrokeWidth);
    }

    private int dipToPx(float dip) {
        return (int) ((getContext().getResources().getDisplayMetrics().density * dip) + ((dip >= 0.0f ? 1 : -1) * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(this.lineColor);
        this.mWidth = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float height = getHeight() - getPaddingBottom();
        this.baseBottomHeight = height;
        float fHeight = (height - this.bottomTextHeihtRect.height()) - dipToPx(4.0f);
        this.perlineHeight = fHeight;
        this.perLineWidth = (this.mWidth - (this.perDotGap * 6.0f)) / 7.0f;
        this.start0Height = fHeight - dipToPx(2.0f);
        float paddingTop = getPaddingTop();
        this.endMaxHeight = paddingTop;
        this.mHeight = this.start0Height - paddingTop;
        drawDashLine(canvas);
        drawBottomText(canvas);
        this.mPaint.setColor(this.rectColor);
        this.startPotPadding = getPaddingLeft() + this.textRect.width();
        List<Integer> list = this.potListValue;
        if (list == null || list.size() < 1) {
            return;
        }
        drawRect(canvas);
    }

    void drawDashLine(Canvas canvas) {
        float paddingLeft = getPaddingLeft();
        this.start0WidthPosition = getPaddingLeft() + this.mSlideLinePaint.measureText(this.MAXVALUE + "") + 1.0f;
        int i = this.MAXVALUE;
        int[] iArr = {0, i / 6, (i / 6) * 2, (i / 6) * 3, (i / 6) * 4, (i / 6) * 5, i};
        for (int i2 = 0; i2 < 7; i2++) {
            if (i2 > 0) {
                float f = this.start0Height;
                int i3 = iArr[i2];
                int i4 = iArr[0];
                float f2 = f - (((i3 - i4) / (this.MAXVALUE - i4)) * this.mHeight);
                this.mDashPath.moveTo(this.start0WidthPosition, f2);
                this.mDashPath.lineTo(this.mWidth + paddingLeft, f2);
                String str = iArr[i2] + "";
                if (iArr[i2] < 10) {
                    str = " " + str;
                }
                canvas.drawText(str, paddingLeft, f2 + (this.bottomTextHeihtRect.height() / 2), this.mSlideLinePaint);
            }
        }
        canvas.drawPath(this.mDashPath, this.mDashPaint);
        float f3 = this.start0WidthPosition;
        float f4 = this.start0Height;
        canvas.drawLine(f3, f4, this.mWidth, f4, this.mSlideLinePaint);
        float f5 = this.start0WidthPosition;
        float f6 = this.start0Height;
        int i5 = this.MAXVALUE;
        int i6 = iArr[0];
        canvas.drawLine(f5, f6, f5, f6 - (((i5 - i6) / (i5 - i6)) * this.mHeight), this.mSlideLinePaint);
    }

    private void drawBottomText(Canvas canvas) {
        this.mPaint.setColor(this.bottomTextColor);
        this.mPaint.getTextBounds(this.bottomTextList.get(0), 0, this.bottomTextList.get(0).length(), new Rect());
        float f = (this.mWidth - this.start0WidthPosition) / 7.0f;
        for (int i = 0; i < 7; i++) {
            canvas.drawText(this.bottomTextList.get(i), this.start0WidthPosition + (i * f) + (this.mPaint.measureText(this.bottomTextList.get(i)) / 2.0f), this.baseBottomHeight, this.mPaint);
        }
    }

    private void drawRect(Canvas canvas) {
        float fMeasureText = this.mPaint.measureText(this.bottomTextList.get(0));
        int size = this.potListValue.size();
        this.perPotWidth = (this.mWidth - this.start0WidthPosition) / 7.0f;
        this.mPaint.setColor(this.rectColor);
        for (int i = 0; i < size; i++) {
            int iIntValue = this.potListValue.get(i).intValue();
            int i2 = this.MAXVALUE;
            if (iIntValue > i2) {
                iIntValue = i2;
            }
            float potPostionbyIndex = getPotPostionbyIndex(this.positionIndexList.get(i).intValue()) + this.mPaint.measureText(this.bottomTextList.get(i));
            float paddingTop = getPaddingTop();
            float f = this.mHeight;
            float f2 = (paddingTop + f) - ((iIntValue / this.MAXVALUE) * f);
            int iDipToPx = dipToPx(10.0f);
            float f3 = (((((fMeasureText - 10.0f) / 2.0f) + potPostionbyIndex) + potPostionbyIndex) / 2.0f) - (iDipToPx / 2);
            float f4 = f3 + iDipToPx;
            float f5 = this.start0Height;
            RectF rectF = new RectF(f3, f2, f4, f5);
            Path path = new Path();
            path.addRoundRect(rectF, new float[]{30.0f, 30.0f, 30.0f, 30.0f, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
            this.mPathBgPaint.setShader(new LinearGradient(f3, f2, f4, f5, new int[]{-772097, 16777215}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
            canvas.drawPath(path, this.mPathBgPaint);
        }
    }

    private float getPotPostionbyIndex(int index) {
        return this.start0WidthPosition + (this.perPotWidth * index);
    }

    public void setDailyList(List posIndexList, List df) {
        this.positionIndexList = posIndexList;
        this.potListValue = df;
        int iIntValue = 0;
        int i = -1;
        if (df != null) {
            Iterator it = df.iterator();
            int i2 = -1;
            int i3 = 0;
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                if (num.intValue() > iIntValue) {
                    iIntValue = num.intValue();
                    i2 = i3;
                }
                i3++;
            }
            i = i2;
        }
        if (i >= 0) {
            while (iIntValue % 6 != 0) {
                iIntValue++;
            }
            this.MAXVALUE = iIntValue;
        }
        invalidate();
    }
}
