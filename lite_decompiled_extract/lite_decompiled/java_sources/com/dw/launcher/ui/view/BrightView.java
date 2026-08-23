package com.dw.launcher.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import com.dw.launcher.R;
import com.dw.launcher.data.component.BrightComponent;
import com.dw.launcher.util.ResourceUtils;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BrightView.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB#\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB+\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ\b\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000bH\u0016J\b\u0010(\u001a\u00020%H\u0014J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020%H\u0014J\u001a\u0010-\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010\u00012\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000bH\u0002J\u001a\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u000b2\b\b\u0002\u00104\u001a\u00020 H\u0002R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/dw/launcher/ui/view/BrightView;", "Landroid/view/View;", "Landroid/view/View$OnTouchListener;", "Lcom/dw/launcher/data/component/BrightComponent$OnBrightnessChangedListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mBrightComponent", "Lcom/dw/launcher/data/component/BrightComponent;", "getMBrightComponent", "()Lcom/dw/launcher/data/component/BrightComponent;", "setMBrightComponent", "(Lcom/dw/launcher/data/component/BrightComponent;)V", "mClipPath", "Landroid/graphics/Path;", "mLastX", "", "mLastY", "mPaint", "Landroid/graphics/Paint;", "mProgress", "mRectF", "Landroid/graphics/RectF;", "mRequestTouchEvent", "", "mRoundRadius", "mSkipTouchEvent", "mTouchSlot", "onAttachedToWindow", "", "onBrightnessChanged", "brightness", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onFinishInflate", "onTouch", "v", "event", "Landroid/view/MotionEvent;", "setBrightnessInSystem", "updateProgress", "y", "fromSelf", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class BrightView extends Hilt_BrightView implements View.OnTouchListener, BrightComponent.OnBrightnessChangedListener {

    @Inject
    public BrightComponent mBrightComponent;
    private final Path mClipPath;
    private float mLastX;
    private float mLastY;
    private final Paint mPaint;
    private float mProgress;
    private final RectF mRectF;
    private boolean mRequestTouchEvent;
    private final float mRoundRadius;
    private boolean mSkipTouchEvent;
    private int mTouchSlot;

    public final BrightComponent getMBrightComponent() {
        BrightComponent brightComponent = this.mBrightComponent;
        if (brightComponent != null) {
            return brightComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBrightComponent");
        return null;
    }

    public final void setMBrightComponent(BrightComponent brightComponent) {
        Intrinsics.checkNotNullParameter(brightComponent, "<set-?>");
        this.mBrightComponent = brightComponent;
    }

    public BrightView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.mRectF = new RectF();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mRoundRadius = ResourceUtils.dpToPx(context2, 16.0f);
        this.mClipPath = new Path();
        getMBrightComponent().addListener(this);
    }

    public BrightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.mRectF = new RectF();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mRoundRadius = ResourceUtils.dpToPx(context2, 16.0f);
        this.mClipPath = new Path();
        getMBrightComponent().addListener(this);
    }

    public BrightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.mRectF = new RectF();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mRoundRadius = ResourceUtils.dpToPx(context2, 16.0f);
        this.mClipPath = new Path();
        getMBrightComponent().addListener(this);
    }

    public BrightView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPaint = new Paint();
        this.mRectF = new RectF();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mRoundRadius = ResourceUtils.dpToPx(context2, 16.0f);
        this.mClipPath = new Path();
        getMBrightComponent().addListener(this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mTouchSlot = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mProgress = getMBrightComponent().getBrightnessLevel();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getMBrightComponent().register();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMBrightComponent().unregister();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.mPaint.reset();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mClipPath.reset();
        this.mRectF.set(0.0f, 0.0f, getWidth(), getHeight());
        Path path = this.mClipPath;
        RectF rectF = this.mRectF;
        float f = this.mRoundRadius;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        canvas.save();
        canvas.clipPath(this.mClipPath);
        this.mPaint.setColor(getContext().getColor(R.color.bright_background_color));
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.mPaint);
        this.mPaint.setColor(getContext().getColor(R.color.bright_foreground_color));
        canvas.drawRect(0.0f, getHeight(), getWidth(), getHeight() - (getHeight() * this.mProgress), this.mPaint);
        canvas.restore();
    }

    static /* synthetic */ void updateProgress$default(BrightView brightView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        brightView.updateProgress(i, z);
    }

    private final void updateProgress(int y, boolean fromSelf) {
        Window window;
        float height = (getHeight() - y) / getHeight();
        this.mProgress = height;
        float fCoerceAtMost = RangesKt.coerceAtMost(height, 1.0f);
        this.mProgress = fCoerceAtMost;
        this.mProgress = RangesKt.coerceAtLeast(fCoerceAtMost, 0.0f);
        if (fromSelf) {
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            if (context instanceof Activity) {
                window = ((Activity) context).getWindow();
            } else {
                if (!(context instanceof ContextWrapper)) {
                    window = null;
                    break;
                }
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        window = null;
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getBaseContext(...)");
                    if (context instanceof Activity) {
                        window = ((Activity) context).getWindow();
                        break;
                    }
                }
            }
            if (window != null) {
                getMBrightComponent().setBrightnessLevel((int) (this.mProgress * 255), window);
            }
        }
        invalidate();
    }

    private final void setBrightnessInSystem(int brightness) {
        BrightComponent.setBrightnessLevel$default(getMBrightComponent(), brightness, (Window) null, 2, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0072  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction() & 255;
        if (action == 0) {
            this.mLastX = event.getX();
            this.mLastY = event.getY();
            this.mSkipTouchEvent = false;
            this.mRequestTouchEvent = false;
        } else if (action == 1) {
            if (this.mRequestTouchEvent) {
                setBrightnessInSystem((int) (((getHeight() - event.getY()) / getHeight()) * 255));
            }
            this.mSkipTouchEvent = false;
            this.mRequestTouchEvent = false;
            getParent().requestDisallowInterceptTouchEvent(false);
        } else if (action != 2) {
            if (action == 3) {
                if (this.mRequestTouchEvent) {
                    setBrightnessInSystem((int) (((getHeight() - event.getY()) / getHeight()) * 255));
                }
                this.mSkipTouchEvent = false;
                this.mRequestTouchEvent = false;
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else {
            if (this.mSkipTouchEvent) {
                return false;
            }
            float fAbs = Math.abs(event.getY() - this.mLastY);
            float fAbs2 = Math.abs(event.getX() - this.mLastX);
            if (this.mRequestTouchEvent) {
                updateProgress$default(this, (int) event.getY(), false, 2, null);
                return true;
            }
            if (fAbs2 > ViewConfiguration.getTouchSlop() || fAbs > ViewConfiguration.getTouchSlop()) {
                if (fAbs > fAbs2) {
                    this.mRequestTouchEvent = true;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    updateProgress$default(this, (int) event.getY(), false, 2, null);
                } else {
                    this.mSkipTouchEvent = true;
                    return false;
                }
            }
        }
        return true;
    }

    public void onBrightnessChanged(int brightness) {
        this.mProgress = brightness / 255.0f;
        invalidate();
    }
}
