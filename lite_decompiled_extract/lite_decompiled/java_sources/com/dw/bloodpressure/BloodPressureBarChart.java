package com.dw.bloodpressure;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.android.internal.telephony.ServiceStateTracker;
import com.android.internal.telephony.imsphone.ImsPhoneCallTrackerEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public class BloodPressureBarChart extends View {
    final int barNumbers;
    List<String> bottomTextList;
    private int currentBarIndex;
    private int end0WidthPostion;
    Handler handler;
    boolean isFinish;
    int last_full_value_index;
    boolean leftFullMaxValue;
    Paint mBackgroundPaint;
    Paint mBottomTextPaint;
    Paint mLinePaint;
    Paint mPathPaint;
    Paint mSlideTextPaint;
    private int maxHeight;
    int max_value;
    List<Integer> minList;
    int min_value;
    final int offset;
    private int one_step_duration;
    private int per_bar_value;
    List<Integer> positionIndexList;
    List<Integer> potLists;
    List<Integer> slideTextList;
    private int start0Height;
    private int start0WidthPosition;
    private int startSlideTextPosition;
    List<Integer> tempBarValue;
    List<Integer> tempList;
    List<Integer> tempMinList;
    List<Integer> tempPosList;
    int viewHeight;
    int viewWidth;

    public BloodPressureBarChart(Context context) {
        super(context);
        this.offset = 10;
        this.barNumbers = 24;
        this.viewWidth = 0;
        this.viewHeight = 0;
        this.max_value = 180;
        this.min_value = 60;
        this.bottomTextList = new ArrayList();
        this.minList = new ArrayList();
        this.potLists = new ArrayList();
        this.positionIndexList = new ArrayList();
        this.slideTextList = new ArrayList(Arrays.asList(60, 90, 120, Integer.valueOf(ImsPhoneCallTrackerEx.CODE_LOCAL_CALL_CS_EMERGENCY_RETRY_REQUIRED), 180));
        this.startSlideTextPosition = 0;
        this.maxHeight = 0;
        this.start0Height = 0;
        this.start0WidthPosition = 0;
        this.end0WidthPostion = 0;
        this.one_step_duration = 20;
        this.per_bar_value = 30;
        this.currentBarIndex = 0;
        this.tempList = new ArrayList();
        this.tempPosList = new ArrayList();
        this.tempMinList = new ArrayList();
        this.tempBarValue = new ArrayList(Collections.nCopies(24, 0));
        this.last_full_value_index = -1;
        this.isFinish = true;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.dw.bloodpressure.BloodPressureBarChart.1
            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                super.dispatchMessage(message);
                if (message.what == 0) {
                    BloodPressureBarChart.this.childBarAnimal();
                }
            }
        };
        this.leftFullMaxValue = false;
        init(null);
    }

    public BloodPressureBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.offset = 10;
        this.barNumbers = 24;
        this.viewWidth = 0;
        this.viewHeight = 0;
        this.max_value = 180;
        this.min_value = 60;
        this.bottomTextList = new ArrayList();
        this.minList = new ArrayList();
        this.potLists = new ArrayList();
        this.positionIndexList = new ArrayList();
        this.slideTextList = new ArrayList(Arrays.asList(60, 90, 120, Integer.valueOf(ImsPhoneCallTrackerEx.CODE_LOCAL_CALL_CS_EMERGENCY_RETRY_REQUIRED), 180));
        this.startSlideTextPosition = 0;
        this.maxHeight = 0;
        this.start0Height = 0;
        this.start0WidthPosition = 0;
        this.end0WidthPostion = 0;
        this.one_step_duration = 20;
        this.per_bar_value = 30;
        this.currentBarIndex = 0;
        this.tempList = new ArrayList();
        this.tempPosList = new ArrayList();
        this.tempMinList = new ArrayList();
        this.tempBarValue = new ArrayList(Collections.nCopies(24, 0));
        this.last_full_value_index = -1;
        this.isFinish = true;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.dw.bloodpressure.BloodPressureBarChart.1
            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                super.dispatchMessage(message);
                if (message.what == 0) {
                    BloodPressureBarChart.this.childBarAnimal();
                }
            }
        };
        this.leftFullMaxValue = false;
        init(attributeSet);
    }

    void init(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.barChar);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.barChar_slide_line_color, -16776961);
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.barChar_slide_text_color, -1);
        int color3 = typedArrayObtainStyledAttributes.getColor(R.styleable.barChar_bottom_text_color, -1);
        int color4 = typedArrayObtainStyledAttributes.getColor(R.styleable.barChar_bar_color, -116897);
        int color5 = typedArrayObtainStyledAttributes.getColor(R.styleable.barChar_bar_background_color, -8180171);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mBottomTextPaint = paint;
        paint.setAntiAlias(true);
        this.mBottomTextPaint.setTextSize(dp2px(getContext(), 18.0f));
        this.mBottomTextPaint.setColor(color3);
        Paint paint2 = new Paint();
        this.mSlideTextPaint = paint2;
        paint2.setAntiAlias(true);
        this.mSlideTextPaint.setTextSize(dp2px(getContext(), 18.0f));
        this.mSlideTextPaint.setColor(color2);
        Paint paint3 = new Paint();
        this.mLinePaint = paint3;
        paint3.setAntiAlias(true);
        this.mLinePaint.setStyle(Paint.Style.FILL);
        this.mLinePaint.setColor(-16776961);
        this.mLinePaint.setStrokeWidth(dp2px(getContext(), 1.0f));
        this.mLinePaint.setColor(color);
        Paint paint4 = new Paint();
        this.mPathPaint = paint4;
        paint4.setAntiAlias(true);
        this.mPathPaint.setStyle(Paint.Style.FILL);
        this.mPathPaint.setColor(color4);
        Paint paint5 = new Paint();
        this.mBackgroundPaint = paint5;
        paint5.setAntiAlias(true);
        this.mBackgroundPaint.setColor(color5);
        this.bottomTextList.add(ServiceStateTracker.DEFAULT_MNC);
        this.bottomTextList.add("06");
        this.bottomTextList.add("12");
        this.bottomTextList.add("18");
        this.bottomTextList.add("24");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect();
        this.mSlideTextPaint.getTextBounds("0", 0, 1, rect);
        this.maxHeight = rect.height() + 10;
        Rect rect2 = new Rect();
        this.mBottomTextPaint.getTextBounds("0", 0, 1, rect2);
        this.start0Height = ((this.viewHeight - 10) - rect2.height()) - dp2px(getContext(), 5.0f);
        this.start0WidthPosition = 10;
        int iMeasureText = (int) ((this.viewWidth - 10) - this.mSlideTextPaint.measureText(((Integer) Collections.max(this.slideTextList)).toString()));
        this.startSlideTextPosition = iMeasureText;
        this.end0WidthPostion = iMeasureText - dp2px(getContext(), 10.0f);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, this.viewWidth, this.viewHeight), dp2px(getContext(), 25.0f), dp2px(getContext(), 25.0f), this.mBackgroundPaint);
        drawSlideLine(canvas);
        drawBottomText(canvas);
        drawBars(canvas);
    }

    private void drawBars(Canvas canvas) {
        int size = this.positionIndexList.size();
        int i = (this.end0WidthPostion - this.start0WidthPosition) / 24;
        Point[] pointArr = new Point[size];
        Point[] pointArr2 = new Point[size];
        int i2 = this.start0Height - this.maxHeight;
        for (int i3 = 0; i3 < size; i3++) {
            float value = getValue(this.potLists.get(i3).intValue());
            float fIntValue = (this.end0WidthPostion - ((23 - this.positionIndexList.get(i3).intValue()) * i)) - (this.mBottomTextPaint.measureText(ServiceStateTracker.DEFAULT_MNC) / 2.0f);
            float f = this.start0Height;
            int i4 = this.min_value;
            float f2 = (value - i4) / (this.max_value - i4);
            float f3 = i2;
            int i5 = (int) fIntValue;
            pointArr[i3] = new Point(i5, (int) (f - (f2 * f3)));
            int value2 = getValue(this.minList.get(i3).intValue());
            float f4 = this.start0Height;
            int i6 = this.min_value;
            pointArr2[i3] = new Point(i5, (int) (f4 - (((value2 - i6) / (this.max_value - i6)) * f3)));
            Log.d("minvalue", value2 + BuildConfig.FLAVOR);
        }
        int iDp2px = dp2px(getContext(), 3.0f);
        for (int i7 = 0; i7 < size; i7++) {
            Point point = pointArr[i7];
            RectF rectF = new RectF(point.x - iDp2px, point.y, point.x + iDp2px, pointArr2[i7].y);
            Path path = new Path();
            path.addRoundRect(rectF, new float[]{30.0f, 30.0f, 30.0f, 30.0f, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
            canvas.drawPath(path, this.mPathPaint);
        }
    }

    private int getValue(int i) {
        int i2 = this.max_value;
        if (i > i2) {
            return i2;
        }
        int i3 = this.min_value;
        return i < i3 ? i3 : i;
    }

    private void drawSlideLine(Canvas canvas) {
        this.max_value = ((Integer) Collections.max(this.slideTextList)).intValue();
        this.min_value = ((Integer) Collections.min(this.slideTextList)).intValue();
        Rect rect = new Rect();
        this.mSlideTextPaint.getTextBounds("0", 0, 1, rect);
        int i = this.start0Height - this.maxHeight;
        for (int i2 = 0; i2 < this.slideTextList.size(); i2++) {
            int iIntValue = this.slideTextList.get(i2).intValue();
            float f = this.start0Height;
            int iIntValue2 = this.slideTextList.get(i2).intValue();
            int i3 = this.min_value;
            int i4 = (int) (f - (((iIntValue2 - i3) / (this.max_value - i3)) * i));
            float f2 = i4;
            canvas.drawLine(this.start0WidthPosition, f2, this.end0WidthPostion, f2, this.mLinePaint);
            if (i2 != 0) {
                canvas.drawText(iIntValue + BuildConfig.FLAVOR, this.startSlideTextPosition, i4 + (rect.height() / 2), this.mSlideTextPaint);
            }
        }
    }

    private void drawBottomText(Canvas canvas) {
        float f = (this.end0WidthPostion - this.start0WidthPosition) / 24;
        Rect rect = new Rect();
        this.mBottomTextPaint.getTextBounds(ServiceStateTracker.DEFAULT_MNC, 0, 2, rect);
        int i = this.viewHeight - 10;
        int[] iArr = {0, 6, 12, 18, 23};
        for (int i2 = 0; i2 < 5; i2++) {
            canvas.drawText(this.bottomTextList.get(i2), (this.end0WidthPostion - ((23 - iArr[i2]) * f)) - rect.width(), i, this.mBottomTextPaint);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && mode2 == 1073741824) {
            setMeasuredDimension(size, size2);
        } else {
            super.onMeasure(i, i2);
        }
        this.viewHeight = getMeasuredHeight();
        this.viewWidth = getMeasuredWidth();
    }

    int dp2px(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public void startAnimate2() {
        this.tempList = new ArrayList();
        this.tempPosList = new ArrayList();
        this.tempMinList = new ArrayList();
        this.tempPosList.addAll(this.positionIndexList);
        this.tempList.addAll(this.potLists);
        this.tempMinList.addAll(this.minList);
        this.positionIndexList = new ArrayList(Collections.nCopies(24, 0));
        this.potLists = new ArrayList(Collections.nCopies(24, Integer.valueOf(this.min_value)));
        this.minList = new ArrayList(Collections.nCopies(24, Integer.valueOf(this.min_value)));
        this.currentBarIndex = 0;
        this.last_full_value_index = 0;
        this.leftFullMaxValue = false;
        this.isFinish = false;
        this.handler.removeMessages(0);
        childBarAnimal();
    }

    void childBarAnimal() {
        if (this.isFinish) {
            this.potLists = this.tempList;
            this.positionIndexList = this.tempPosList;
            this.minList = this.tempMinList;
            invalidate();
            return;
        }
        this.currentBarIndex = Math.max(0, Math.min(this.currentBarIndex, 23));
        if (this.leftFullMaxValue) {
            for (int i = this.last_full_value_index; i >= this.currentBarIndex; i--) {
                List<Integer> list = this.tempBarValue;
                list.set(i, Integer.valueOf(Math.max(list.get(i).intValue() - this.per_bar_value, 0)));
                this.potLists.set(i, this.tempBarValue.get(i));
            }
            int iFindFirstZeroValueIndex = findFirstZeroValueIndex(this.tempBarValue);
            this.last_full_value_index = iFindFirstZeroValueIndex;
            this.currentBarIndex--;
            if (iFindFirstZeroValueIndex == 0) {
                this.isFinish = true;
            }
        } else {
            if (this.last_full_value_index == -1) {
                this.last_full_value_index = 0;
            }
            for (int i2 = this.last_full_value_index; i2 <= this.currentBarIndex; i2++) {
                List<Integer> list2 = this.tempBarValue;
                list2.set(i2, Integer.valueOf(Math.min(list2.get(i2).intValue() + this.per_bar_value, this.max_value)));
                this.potLists.set(i2, this.tempBarValue.get(i2));
            }
            this.last_full_value_index = findLastFullMaxValueIndex(this.tempBarValue);
            List<Integer> list3 = this.positionIndexList;
            int i3 = this.currentBarIndex;
            list3.set(i3, Integer.valueOf(i3));
            this.currentBarIndex++;
            if (this.last_full_value_index == 23) {
                this.leftFullMaxValue = true;
            }
        }
        this.handler.sendEmptyMessageDelayed(0, this.one_step_duration);
        invalidate();
    }

    int findLastFullMaxValueIndex(List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).intValue() == this.max_value) {
                return size;
            }
        }
        return -1;
    }

    int findFirstZeroValueIndex(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).intValue() == this.min_value) {
                return i;
            }
        }
        return 23;
    }

    public void setDailyList(List list, List list2, List list3) {
        if (this.isFinish) {
            this.minList = list2;
            this.potLists = list;
            this.positionIndexList = list3;
            invalidate();
        }
    }
}
