package com.dwiot.dwstep.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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
import com.dwiot.dwstep.R;
import com.google.android.mms.pdu.PduHeaders;
import com.makeramen.roundedimageview.RoundedDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class StepWeekChart extends View {
    private int MAXVALUE;
    float baseBottomHeight;
    float bigCircleRadus;
    public int bottomShowItemNum;
    String bottomText;
    Rect bottomTextHeihtRect;
    List<String> bottomTextList;
    private Context context;
    float endMaxHeight;
    int endRate;
    int horizeColor;
    private OnItemClicked itemClicked;
    int lineColor;
    int lineSlideColor;
    int lineWidth;
    private Rect mDataTextBound;
    float mHeight;
    Paint mLinePaint;
    Paint mPaint;
    Paint mPathBgPaint;
    Paint mSelectPaint;
    Paint mSlideLinePaint;
    Paint mStokeCirclePaint;
    Paint mStokePaint;
    String mText;
    Paint mTextTipPaint;
    float mWidth;
    DisplayMetrics outMetrics;
    int paddingHeight;
    float perDotGap;
    float perLineWidth;
    float perPotWidth;
    float perlineHeight;
    Point[] points;
    List<Integer> positionIndexList;
    List<Integer> potLists;
    List<String> potTipsList;
    float start0Height;
    float start0WidthPosition;
    float startPotPadding;
    private int startRate;
    String tipContent;
    int touchPos;
    Bitmap txtTipBitMap;
    Bitmap txtTipDownBitMap;

    public interface OnItemClicked {
        void onItem(int i);
    }

    public void setOnItemClicked(OnItemClicked onItemClicked) {
        this.itemClicked = onItemClicked;
    }

    public StepWeekChart(Context context) {
        super(context);
        this.lineSlideColor = -1710619;
        this.lineColor = -8947849;
        this.lineWidth = dipToPx(1.5f);
        this.horizeColor = Color.rgb(PduHeaders.RESPONSE_STATUS_ERROR_PERMANENT_CONTENT_NOT_ACCEPTED, PduHeaders.RESPONSE_STATUS_ERROR_PERMANENT_CONTENT_NOT_ACCEPTED, PduHeaders.RESPONSE_STATUS_ERROR_PERMANENT_CONTENT_NOT_ACCEPTED);
        this.perPotWidth = 0.0f;
        this.mWidth = 0.0f;
        this.mHeight = 0.0f;
        this.mText = "10000步";
        this.tipContent = "1000";
        this.bottomText = "00:00";
        this.startRate = 0;
        this.endRate = 10000;
        this.MAXVALUE = 10000;
        this.startPotPadding = 0.0f;
        this.potLists = new ArrayList();
        this.positionIndexList = new ArrayList();
        this.potTipsList = new ArrayList();
        this.bottomTextList = new ArrayList();
        this.baseBottomHeight = 0.0f;
        this.perlineHeight = 0.0f;
        this.perLineWidth = 0.0f;
        this.perDotGap = dipToPx(5.0f);
        this.start0Height = 0.0f;
        this.endMaxHeight = 0.0f;
        this.bottomShowItemNum = 7;
        this.start0WidthPosition = 0.0f;
        this.bigCircleRadus = dipToPx(10.0f);
        this.touchPos = -1;
        init();
    }

    public StepWeekChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lineSlideColor = -1710619;
        this.lineColor = -8947849;
        this.lineWidth = dipToPx(1.5f);
        this.horizeColor = Color.rgb(PduHeaders.RESPONSE_STATUS_ERROR_PERMANENT_CONTENT_NOT_ACCEPTED, PduHeaders.RESPONSE_STATUS_ERROR_PERMANENT_CONTENT_NOT_ACCEPTED, PduHeaders.RESPONSE_STATUS_ERROR_PERMANENT_CONTENT_NOT_ACCEPTED);
        this.perPotWidth = 0.0f;
        this.mWidth = 0.0f;
        this.mHeight = 0.0f;
        this.mText = "10000步";
        this.tipContent = "1000";
        this.bottomText = "00:00";
        this.startRate = 0;
        this.endRate = 10000;
        this.MAXVALUE = 10000;
        this.startPotPadding = 0.0f;
        this.potLists = new ArrayList();
        this.positionIndexList = new ArrayList();
        this.potTipsList = new ArrayList();
        this.bottomTextList = new ArrayList();
        this.baseBottomHeight = 0.0f;
        this.perlineHeight = 0.0f;
        this.perLineWidth = 0.0f;
        this.perDotGap = dipToPx(5.0f);
        this.start0Height = 0.0f;
        this.endMaxHeight = 0.0f;
        this.bottomShowItemNum = 7;
        this.start0WidthPosition = 0.0f;
        this.bigCircleRadus = dipToPx(10.0f);
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
        this.mSelectPaint = paint2;
        paint2.setColor(-1351918);
        this.mSelectPaint.setStyle(Paint.Style.FILL);
        this.mSelectPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mSelectPaint.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.mLinePaint = paint3;
        paint3.setColor(this.lineColor);
        this.mLinePaint.setStrokeWidth(this.lineWidth);
        this.mLinePaint.setStrokeJoin(Paint.Join.ROUND);
        this.mLinePaint.setAntiAlias(true);
        Paint paint4 = new Paint();
        this.mSlideLinePaint = paint4;
        paint4.setColor(-13421773);
        this.mSlideLinePaint.setStrokeWidth(dipToPx(1.0f));
        this.mSlideLinePaint.setAntiAlias(true);
        this.mSlideLinePaint.setPathEffect(new DashPathEffect(new float[]{dipToPx(10.0f), dipToPx(3.0f)}, 0.0f));
        this.mSlideLinePaint.setStyle(Paint.Style.STROKE);
        Paint paint5 = new Paint();
        this.mStokePaint = paint5;
        paint5.setColor(-38572);
        this.mStokePaint.setStrokeWidth(dipToPx(1.0f));
        this.mStokePaint.setStyle(Paint.Style.STROKE);
        this.mStokePaint.setStrokeJoin(Paint.Join.ROUND);
        this.mStokePaint.setAntiAlias(true);
        Paint paint6 = new Paint();
        this.mStokeCirclePaint = paint6;
        paint6.setColor(-38572);
        this.mStokeCirclePaint.setStrokeWidth(2.0f);
        this.mStokeCirclePaint.setTextSize(dipToPx(16.0f));
        this.mStokeCirclePaint.setStyle(Paint.Style.STROKE);
        this.mStokeCirclePaint.setStrokeJoin(Paint.Join.ROUND);
        this.mStokeCirclePaint.setAntiAlias(true);
        Paint paint7 = new Paint();
        this.mPathBgPaint = paint7;
        paint7.setAntiAlias(true);
        this.mPathBgPaint.setColor(-14628353);
        this.mPathBgPaint.setStyle(Paint.Style.FILL);
        Paint paint8 = new Paint();
        this.mTextTipPaint = paint8;
        paint8.setColor(-11316397);
        this.mTextTipPaint.setTextSize(dipToPx(12.0f));
        this.mTextTipPaint.setAntiAlias(true);
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        this.bottomTextHeihtRect = new Rect();
        Paint paint9 = this.mPaint;
        String str = this.bottomText;
        paint9.getTextBounds(str, 0, str.length(), this.bottomTextHeihtRect);
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
        this.perlineHeight = (height - this.bottomTextHeihtRect.height()) - dipToPx(6.0f);
        this.paddingHeight = dipToPx(4.0f);
        this.start0Height = this.perlineHeight - dipToPx(5.0f);
        float paddingTop = getPaddingTop() + this.paddingHeight;
        this.endMaxHeight = paddingTop;
        this.mHeight = this.start0Height - paddingTop;
        this.mPaint.setColor(this.lineColor);
        drawSlideText(canvas);
        float f = this.mWidth;
        float f2 = this.perDotGap;
        int i = this.bottomShowItemNum;
        this.perLineWidth = (f - (f2 * (i - 1))) / i;
        drawBottomText(canvas);
        List<Integer> list = this.potLists;
        if (list == null || list.size() < 1) {
            return;
        }
        this.startPotPadding = this.start0WidthPosition;
        this.mLinePaint.setColor(this.lineColor);
        this.mLinePaint.setStyle(Paint.Style.FILL);
        calcPointValue();
        drawScrollLine(canvas);
    }

    private void calcPointValue() {
        float f = this.start0WidthPosition;
        int size = this.positionIndexList.size();
        float fMeasureText = ((this.mWidth - f) - this.mPaint.measureText(this.MAXVALUE + "")) / this.bottomShowItemNum;
        this.perLineWidth = fMeasureText;
        this.perPotWidth = fMeasureText;
        this.points = new Point[size];
        for (int i = 0; i < size; i++) {
            float fIntValue = this.potLists.get(i).intValue();
            int i2 = this.MAXVALUE;
            if (fIntValue > i2) {
                fIntValue = i2;
            }
            this.points[i] = new Point((int) getPotPostionbyIndex(this.positionIndexList.get(i).intValue()), (int) (this.start0Height - ((fIntValue / (this.endRate - this.startRate)) * this.mHeight)));
        }
    }

    private void drawBottomText(Canvas canvas) {
        int i = this.bottomShowItemNum;
        float fMeasureText = ((this.mWidth - this.start0WidthPosition) - this.mPaint.measureText(this.MAXVALUE + "")) / this.bottomShowItemNum;
        for (int i2 = 0; i2 < i; i2++) {
            canvas.drawText(this.bottomTextList.get(i2), this.start0WidthPosition + (i2 * fMeasureText), this.baseBottomHeight, this.mPaint);
        }
    }

    private void drawSlideText(Canvas canvas) {
        float paddingLeft = getPaddingLeft();
        this.mPaint.measureText(this.MAXVALUE + "");
        dipToPx(2.0f);
        int i = this.MAXVALUE;
        int[] iArr = {0, i / 4, i / 2, (i / 4) * 3, i};
        Path path = new Path();
        for (int i2 = 0; i2 < 5; i2++) {
            float f = this.start0Height;
            int i3 = iArr[i2];
            int i4 = iArr[0];
            float f2 = f - (((i3 - i4) / (this.endRate - i4)) * this.mHeight);
            if (i2 > 0) {
                path.moveTo(paddingLeft, f2);
                path.lineTo(this.mWidth + paddingLeft, f2);
            } else {
                canvas.drawLine(paddingLeft, f, this.mWidth + paddingLeft, f, this.mSlideLinePaint);
            }
            canvas.drawText(String.valueOf(iArr[i2]), (this.mWidth + paddingLeft) - this.mPaint.measureText(iArr[i2] + ""), f2 - (this.bottomTextHeihtRect.height() / 2), this.mPaint);
        }
        canvas.drawPath(path, this.mSlideLinePaint);
        this.start0WidthPosition = getPaddingLeft() + dipToPx(5.0f);
    }

    private void drawScrollLine(Canvas canvas) {
        new Point();
        int size = this.potLists.size();
        float fMeasureText = this.mPaint.measureText(this.bottomTextList.get(0));
        for (int i = 0; i < size; i++) {
            Point point = this.points[i];
            float f = (int) (point.x + ((fMeasureText - this.bigCircleRadus) / 2.0f));
            RectF rectF = new RectF(f, point.y, this.bigCircleRadus + f, this.start0Height);
            Path path = new Path();
            path.addRoundRect(rectF, new float[]{36.0f, 36.0f, 36.0f, 36.0f, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
            this.mPathBgPaint.setShader(new LinearGradient(f, point.y, f + this.bigCircleRadus, this.start0Height, new int[]{-14628353, RoundedDrawable.DEFAULT_BORDER_COLOR}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
            canvas.drawPath(path, this.mPathBgPaint);
        }
    }

    private float getPotPostionbyIndex(int i) {
        return this.start0WidthPosition + (this.perPotWidth * i);
    }

    public void setDailyList(List list, List list2) {
        int i;
        this.potLists = list;
        this.positionIndexList = list2;
        if (list != null) {
            Iterator it = list.iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                if (iIntValue < num.intValue()) {
                    iIntValue = num.intValue();
                }
            }
            if (iIntValue >= this.MAXVALUE) {
                int i2 = 5;
                while (true) {
                    i = i2 * 2000;
                    if (iIntValue <= i) {
                        break;
                    } else {
                        i2++;
                    }
                }
                this.MAXVALUE = i;
            }
        }
        this.endRate = this.MAXVALUE;
        List<Integer> list3 = this.potLists;
        if (list3 != null && list3.size() > 0) {
            this.touchPos = this.potLists.size() - 1;
        }
        invalidate();
    }
}
