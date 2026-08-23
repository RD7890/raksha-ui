package com.dw.launcher.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.dw.launcher.R;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SlideView.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u0011R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/dw/launcher/ui/view/SlideView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mLastX", "", "mLastY", "mListener", "Lcom/dw/launcher/ui/view/SlideView$OnSlideChangeListener;", "mOffsetX", "mPaint", "Landroid/graphics/Paint;", "mSlideDrawable", "Landroid/graphics/drawable/Drawable;", "mSlideTip", "", "mTextBounds", "Landroid/graphics/Rect;", "initAttrs", "", "defStyle", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setListener", "listener", "OnSlideChangeListener", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class SlideView extends View {
    private float mLastX;
    private float mLastY;
    private OnSlideChangeListener mListener;
    private float mOffsetX;
    private final Paint mPaint;
    private Drawable mSlideDrawable;
    private String mSlideTip;
    private final Rect mTextBounds;

    /* JADX INFO: compiled from: SlideView.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/dw/launcher/ui/view/SlideView$OnSlideChangeListener;", "", "onSlideChanged", "", "offset", "", "onSlideSelected", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public interface OnSlideChangeListener {
        void onSlideChanged(float offset);

        boolean onSlideSelected(float offset);
    }

    public SlideView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.mTextBounds = new Rect();
    }

    public SlideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.mTextBounds = new Rect();
        initAttrs(attributeSet, i);
    }

    public SlideView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPaint = new Paint();
        this.mTextBounds = new Rect();
    }

    public final void setListener(OnSlideChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
    }

    private final void initAttrs(AttributeSet attrs, int defStyle) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.SlideView, defStyle, 0);
        try {
            this.mSlideDrawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.SlideView_android_src);
            this.mSlideTip = typedArrayObtainStyledAttributes.getString(R.styleable.SlideView_android_text);
            typedArrayObtainStyledAttributes.recycle();
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(-1);
            this.mPaint.setTextSize(TypedValue.applyDimension(2, 24.0f, getResources().getDisplayMetrics()));
            this.mPaint.setTextAlign(Paint.Align.CENTER);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0056  */
    /* JADX WARN: Code duplicated, block: B:19:0x005a  */
    /* JADX WARN: Code duplicated, block: B:21:0x0063  */
    /* JADX WARN: Code duplicated, block: B:23:0x0068  */
    /* JADX WARN: Code duplicated, block: B:25:0x006b  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        OnSlideChangeListener onSlideChangeListener;
        Unit unit;
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction() & 255;
        float width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        Drawable drawable = this.mSlideDrawable;
        if (drawable != null) {
            width -= drawable.getBounds().width();
        }
        if (action == 0) {
            this.mLastX = event.getX();
        } else if (action == 1) {
            onSlideChangeListener = this.mListener;
            if (onSlideChangeListener != null) {
                if (!onSlideChangeListener.onSlideSelected(this.mOffsetX / width)) {
                    this.mOffsetX = 0.0f;
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.mOffsetX = 0.0f;
            }
            invalidate();
        } else if (action == 2) {
            float x = event.getX() - this.mLastX;
            this.mOffsetX = x;
            float fCoerceAtLeast = RangesKt.coerceAtLeast(x, 0.0f);
            this.mOffsetX = fCoerceAtLeast;
            float fCoerceAtMost = RangesKt.coerceAtMost(fCoerceAtLeast, width);
            this.mOffsetX = fCoerceAtMost;
            OnSlideChangeListener onSlideChangeListener2 = this.mListener;
            if (onSlideChangeListener2 != null) {
                onSlideChangeListener2.onSlideChanged(fCoerceAtMost / width);
            }
            invalidate();
        } else if (action == 3) {
            onSlideChangeListener = this.mListener;
            if (onSlideChangeListener != null) {
                if (!onSlideChangeListener.onSlideSelected(this.mOffsetX / width)) {
                    this.mOffsetX = 0.0f;
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.mOffsetX = 0.0f;
            }
            invalidate();
        }
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        String str = this.mSlideTip;
        if (str != null) {
            this.mPaint.getTextBounds(str, 0, str.length(), this.mTextBounds);
            canvas.drawText(str, width, height + (this.mTextBounds.height() / 2.0f), this.mPaint);
        }
        Drawable drawable = this.mSlideDrawable;
        if (drawable != null) {
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            drawable.setBounds(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + height2, getPaddingTop() + height2);
            canvas.save();
            canvas.translate(this.mOffsetX, 0.0f);
            drawable.draw(canvas);
            canvas.restore();
        }
    }
}
