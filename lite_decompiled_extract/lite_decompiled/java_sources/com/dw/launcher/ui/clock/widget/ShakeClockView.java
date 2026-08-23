package com.dw.launcher.ui.clock.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.dw.launcher.R;
import com.dw.launcher.data.component.DateComponent;
import com.google.android.mms.pdu.CharacterSets;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShakeClockView.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB+\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0014J \u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0016\u001a(\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018 \u0019*\u0014\u0012\u000e\b\u0001\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018\u0018\u00010\u00170\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006%"}, d2 = {"Lcom/dw/launcher/ui/clock/widget/ShakeClockView;", "Landroid/view/View;", "Lcom/dw/launcher/data/component/DateComponent$OnTimeChangedListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mDateComponent", "Lcom/dw/launcher/data/component/DateComponent;", "mHourLineDrawable", "Landroid/graphics/drawable/Drawable;", "mMinLineDrawable", "mSecLineDrawable", "mTextPaint", "Landroid/text/TextPaint;", "mWeekArray", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "onAttachedToWindow", "", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTimeChanged", "hour", "minute", "seconds", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ShakeClockView extends View implements DateComponent.OnTimeChangedListener {
    private DateComponent mDateComponent;
    private final Drawable mHourLineDrawable;
    private final Drawable mMinLineDrawable;
    private final Drawable mSecLineDrawable;
    private final TextPaint mTextPaint;
    private final String[] mWeekArray;

    public ShakeClockView(Context context) {
        super(context);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mDateComponent = new DateComponent(context2, this);
        Drawable drawable = getContext().getDrawable(R.drawable.clock_shake_pointer_hour);
        Intrinsics.checkNotNull(drawable);
        this.mHourLineDrawable = drawable;
        Drawable drawable2 = getContext().getDrawable(R.drawable.clock_shake_pointer_minute);
        Intrinsics.checkNotNull(drawable2);
        this.mMinLineDrawable = drawable2;
        Drawable drawable3 = getContext().getDrawable(R.drawable.clock_shake_pointer_second);
        Intrinsics.checkNotNull(drawable3);
        this.mSecLineDrawable = drawable3;
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        this.mWeekArray = getContext().getResources().getStringArray(R.array.week);
        textPaint.setColor(-1);
        textPaint.setTextSize(TypedValue.applyDimension(2, 18.0f, getResources().getDisplayMetrics()));
        textPaint.setFakeBoldText(true);
        textPaint.setAntiAlias(true);
    }

    public ShakeClockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mDateComponent = new DateComponent(context2, this);
        Drawable drawable = getContext().getDrawable(R.drawable.clock_shake_pointer_hour);
        Intrinsics.checkNotNull(drawable);
        this.mHourLineDrawable = drawable;
        Drawable drawable2 = getContext().getDrawable(R.drawable.clock_shake_pointer_minute);
        Intrinsics.checkNotNull(drawable2);
        this.mMinLineDrawable = drawable2;
        Drawable drawable3 = getContext().getDrawable(R.drawable.clock_shake_pointer_second);
        Intrinsics.checkNotNull(drawable3);
        this.mSecLineDrawable = drawable3;
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        this.mWeekArray = getContext().getResources().getStringArray(R.array.week);
        textPaint.setColor(-1);
        textPaint.setTextSize(TypedValue.applyDimension(2, 18.0f, getResources().getDisplayMetrics()));
        textPaint.setFakeBoldText(true);
        textPaint.setAntiAlias(true);
    }

    public ShakeClockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mDateComponent = new DateComponent(context2, this);
        Drawable drawable = getContext().getDrawable(R.drawable.clock_shake_pointer_hour);
        Intrinsics.checkNotNull(drawable);
        this.mHourLineDrawable = drawable;
        Drawable drawable2 = getContext().getDrawable(R.drawable.clock_shake_pointer_minute);
        Intrinsics.checkNotNull(drawable2);
        this.mMinLineDrawable = drawable2;
        Drawable drawable3 = getContext().getDrawable(R.drawable.clock_shake_pointer_second);
        Intrinsics.checkNotNull(drawable3);
        this.mSecLineDrawable = drawable3;
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        this.mWeekArray = getContext().getResources().getStringArray(R.array.week);
        textPaint.setColor(-1);
        textPaint.setTextSize(TypedValue.applyDimension(2, 18.0f, getResources().getDisplayMetrics()));
        textPaint.setFakeBoldText(true);
        textPaint.setAntiAlias(true);
    }

    public ShakeClockView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mDateComponent = new DateComponent(context2, this);
        Drawable drawable = getContext().getDrawable(R.drawable.clock_shake_pointer_hour);
        Intrinsics.checkNotNull(drawable);
        this.mHourLineDrawable = drawable;
        Drawable drawable2 = getContext().getDrawable(R.drawable.clock_shake_pointer_minute);
        Intrinsics.checkNotNull(drawable2);
        this.mMinLineDrawable = drawable2;
        Drawable drawable3 = getContext().getDrawable(R.drawable.clock_shake_pointer_second);
        Intrinsics.checkNotNull(drawable3);
        this.mSecLineDrawable = drawable3;
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        this.mWeekArray = getContext().getResources().getStringArray(R.array.week);
        textPaint.setColor(-1);
        textPaint.setTextSize(TypedValue.applyDimension(2, 18.0f, getResources().getDisplayMetrics()));
        textPaint.setFakeBoldText(true);
        textPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mDateComponent.register();
        Drawable background = getBackground();
        if (background == null || !(background instanceof AnimationDrawable)) {
            return;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) background;
        if (animationDrawable.isRunning()) {
            return;
        }
        animationDrawable.start();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mDateComponent.unregister();
        Drawable background = getBackground();
        if (background == null || !(background instanceof AnimationDrawable)) {
            return;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) background;
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
    }

    public void onTimeChanged(int hour, int minute, int seconds) {
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(10);
        int i2 = calendar.get(12);
        int i3 = calendar.get(13);
        int i4 = calendar.get(5);
        int i5 = calendar.get(7);
        float f = i3;
        float f2 = 60;
        float f3 = (f * 360.0f) / f2;
        float f4 = i2;
        float f5 = ((f4 * 360.0f) / f2) + ((6.0f * f) / f2);
        float f6 = ((i * 360.0f) / 12) + ((f4 * 30.0f) / f2) + (f / 120.0f);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        float f7 = getResources().getDisplayMetrics().density;
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        float f8 = width;
        float f9 = f7 * 4;
        float f10 = height;
        float f11 = f10 / 2.0f;
        canvas.drawText(this.mWeekArray[i5 - 1], f8 + f9, f11, this.mTextPaint);
        this.mTextPaint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(String.valueOf(i4), f8 - f9, f11, this.mTextPaint);
        canvas.save();
        canvas.rotate(f6, f8, f10);
        int intrinsicWidth = this.mHourLineDrawable.getIntrinsicWidth() / 2;
        int intrinsicHeight = this.mHourLineDrawable.getIntrinsicHeight() / 2;
        this.mHourLineDrawable.setBounds(width - intrinsicWidth, height - intrinsicHeight, intrinsicWidth + width, intrinsicHeight + height);
        this.mHourLineDrawable.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.rotate(f5, f8, f10);
        int intrinsicWidth2 = this.mMinLineDrawable.getIntrinsicWidth() / 2;
        int intrinsicHeight2 = this.mMinLineDrawable.getIntrinsicHeight() / 2;
        this.mMinLineDrawable.setBounds(width - intrinsicWidth2, height - intrinsicHeight2, intrinsicWidth2 + width, intrinsicHeight2 + height);
        this.mMinLineDrawable.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.rotate(f3, f8, f10);
        int intrinsicWidth3 = this.mSecLineDrawable.getIntrinsicWidth() / 2;
        int intrinsicHeight3 = this.mSecLineDrawable.getIntrinsicHeight() / 2;
        this.mSecLineDrawable.setBounds(width - intrinsicWidth3, height - intrinsicHeight3, width + intrinsicWidth3, height + intrinsicHeight3);
        this.mSecLineDrawable.draw(canvas);
        canvas.restore();
    }
}
