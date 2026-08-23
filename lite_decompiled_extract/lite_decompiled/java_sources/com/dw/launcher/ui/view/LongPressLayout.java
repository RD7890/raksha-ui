package com.dw.launcher.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LongPressLayout.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 72\u00020\u0001:\u0004789:B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0002J\u0010\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020+H\u0016J(\u0010,\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0002J\u0018\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0002J\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u001dJ\u000e\u00104\u001a\u0002012\u0006\u00103\u001a\u00020\u001fJ\u000e\u00105\u001a\u0002012\u0006\u00106\u001a\u00020!R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/dw/launcher/ui/view/LongPressLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activityStarted", "", "mIsMoved", "mLongPressRunnable", "Ljava/lang/Runnable;", "mLongPressed", "mPointX", "", "mPointY", "mStartX", "mStartY", "needRegisterRightEvent", "getNeedRegisterRightEvent", "()Z", "setNeedRegisterRightEvent", "(Z)V", "needRegisterUpEvent", "getNeedRegisterUpEvent", "setNeedRegisterUpEvent", "onClickListener", "Lcom/dw/launcher/ui/view/LongPressLayout$OnLongLayoutTouchClickListener;", "onMoveClickListener", "Lcom/dw/launcher/ui/view/LongPressLayout$OnTouchClickListener;", "onSwipeRightListener", "Lcom/dw/launcher/ui/view/LongPressLayout$OnSwipeRightListener;", "velocityTracker", "Landroid/view/VelocityTracker;", "detectSwipeRight", "startX", "endX", "startY", "endY", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getSwipeDistance", "isLongMove", "mLastmPointX", "mLastmPointY", "removeMoveClickListener", "", "setOnLongLayoutTouchClickListener", "clickListener", "setOnMoveClickListener", "setOnSwipeRightListener", "listener", "Companion", "OnLongLayoutTouchClickListener", "OnSwipeRightListener", "OnTouchClickListener", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class LongPressLayout extends FrameLayout {
    private static final int MIN_SWIPE_DISTANCE = 20;
    private static final int MIN_SWIPE_RIGHT_DISTANCE = 20;
    private static final float TOUCH_SLOP = 2.0f;
    private boolean activityStarted;
    private boolean mIsMoved;
    private Runnable mLongPressRunnable;
    private boolean mLongPressed;
    private float mPointX;
    private float mPointY;
    private float mStartX;
    private float mStartY;
    private boolean needRegisterRightEvent;
    private boolean needRegisterUpEvent;
    private OnLongLayoutTouchClickListener onClickListener;
    private OnTouchClickListener onMoveClickListener;
    private OnSwipeRightListener onSwipeRightListener;
    private VelocityTracker velocityTracker;

    /* JADX INFO: compiled from: LongPressLayout.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/dw/launcher/ui/view/LongPressLayout$OnLongLayoutTouchClickListener;", "", "onTouch", "", "event", "Landroid/view/MotionEvent;", "onUpTounch", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public interface OnLongLayoutTouchClickListener {
        void onTouch(MotionEvent event);

        void onUpTounch();
    }

    /* JADX INFO: compiled from: LongPressLayout.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/ui/view/LongPressLayout$OnSwipeRightListener;", "", "onSwipeRight", "", "event", "Landroid/view/MotionEvent;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public interface OnSwipeRightListener {
        void onSwipeRight(MotionEvent event);
    }

    /* JADX INFO: compiled from: LongPressLayout.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/dw/launcher/ui/view/LongPressLayout$OnTouchClickListener;", "", "onClickDown", "", "event", "Landroid/view/MotionEvent;", "onClickUp", "onMove", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public interface OnTouchClickListener {
        void onClickDown(MotionEvent event);

        void onClickUp();

        void onMove(MotionEvent event);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LongPressLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LongPressLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ LongPressLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongPressLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLongPressRunnable = new Runnable() { // from class: com.dw.launcher.ui.view.LongPressLayout$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LongPressLayout.mLongPressRunnable$lambda$0(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mLongPressRunnable$lambda$0(LongPressLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mLongPressed = true;
        this$0.performLongClick();
    }

    public final boolean getNeedRegisterUpEvent() {
        return this.needRegisterUpEvent;
    }

    public final void setNeedRegisterUpEvent(boolean z) {
        this.needRegisterUpEvent = z;
    }

    public final boolean getNeedRegisterRightEvent() {
        return this.needRegisterRightEvent;
    }

    public final void setNeedRegisterRightEvent(boolean z) {
        this.needRegisterRightEvent = z;
    }

    private final boolean isLongMove(int mLastmPointX, int mLastmPointY) {
        float f = mLastmPointX - this.mPointX;
        float f2 = mLastmPointY - this.mPointY;
        return Math.sqrt((double) ((f * f) + (f2 * f2))) >= 2.0d;
    }

    private final float getSwipeDistance(float startX, float startY, float endX, float endY) {
        float f = endY - startY;
        if (Math.abs(f) <= Math.abs(endX - startX) || f >= 0.0f) {
            return 0.0f;
        }
        return -f;
    }

    private final boolean detectSwipeRight(float startX, float endX, float startY, float endY) {
        float f = endX - startX;
        return f >= 20.0f && Math.abs(f) > Math.abs(endY - startY);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0096  */
    /* JADX WARN: Code duplicated, block: B:47:0x009a  */
    /* JADX WARN: Code duplicated, block: B:49:0x009e  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00db  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f2 A[RETURN] */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        OnTouchClickListener onTouchClickListener;
        OnLongLayoutTouchClickListener onLongLayoutTouchClickListener;
        boolean z;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        VelocityTracker velocityTracker3;
        OnSwipeRightListener onSwipeRightListener;
        VelocityTracker velocityTracker4;
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            if (this.needRegisterRightEvent) {
                if (this.velocityTracker == null) {
                    this.velocityTracker = VelocityTracker.obtain();
                }
                VelocityTracker velocityTracker5 = this.velocityTracker;
                if (velocityTracker5 != null) {
                    velocityTracker5.addMovement(event);
                }
            }
            OnTouchClickListener onTouchClickListener2 = this.onMoveClickListener;
            if (onTouchClickListener2 != null) {
                onTouchClickListener2.onClickDown(event);
            }
            this.activityStarted = false;
            this.mLongPressed = false;
            this.mPointX = event.getX();
            this.mPointY = event.getY();
            this.mStartX = event.getX();
            this.mStartY = event.getY();
            this.mIsMoved = false;
            postDelayed(this.mLongPressRunnable, ViewConfiguration.getLongPressTimeout());
        } else if (action == 1) {
            if (this.needRegisterRightEvent) {
                velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(event);
                }
                velocityTracker2 = this.velocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.computeCurrentVelocity(20);
                }
                velocityTracker3 = this.velocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                }
                this.velocityTracker = null;
                if (this.needRegisterRightEvent && !this.activityStarted && detectSwipeRight(this.mStartX, event.getX(), this.mStartY, event.getY())) {
                    this.activityStarted = true;
                    onSwipeRightListener = this.onSwipeRightListener;
                    if (onSwipeRightListener != null) {
                        onSwipeRightListener.onSwipeRight(event);
                    }
                }
            }
            onTouchClickListener = this.onMoveClickListener;
            if (onTouchClickListener != null) {
                onTouchClickListener.onClickUp();
            }
            removeCallbacks(this.mLongPressRunnable);
            onLongLayoutTouchClickListener = this.onClickListener;
            if (onLongLayoutTouchClickListener != null && !this.mLongPressed) {
                onLongLayoutTouchClickListener.onTouch(event);
            }
            z = this.mLongPressed;
            if (z) {
                return z;
            }
        } else if (action == 2) {
            OnTouchClickListener onTouchClickListener3 = this.onMoveClickListener;
            if (onTouchClickListener3 != null) {
                onTouchClickListener3.onMove(event);
            }
            if (this.needRegisterRightEvent && (velocityTracker4 = this.velocityTracker) != null) {
                velocityTracker4.addMovement(event);
            }
            if (!this.mIsMoved && isLongMove((int) event.getX(), (int) event.getY())) {
                this.mIsMoved = true;
                removeCallbacks(this.mLongPressRunnable);
            } else if (this.mIsMoved && this.needRegisterUpEvent && getSwipeDistance(this.mStartX, this.mStartY, event.getX(), event.getY()) > 20.0f && !this.activityStarted) {
                this.activityStarted = true;
                OnLongLayoutTouchClickListener onLongLayoutTouchClickListener2 = this.onClickListener;
                if (onLongLayoutTouchClickListener2 != null) {
                    onLongLayoutTouchClickListener2.onUpTounch();
                }
                return false;
            }
            if (this.needRegisterRightEvent && !this.activityStarted && detectSwipeRight(this.mStartX, event.getX(), this.mStartY, event.getY())) {
                this.activityStarted = true;
                OnSwipeRightListener onSwipeRightListener2 = this.onSwipeRightListener;
                if (onSwipeRightListener2 != null) {
                    onSwipeRightListener2.onSwipeRight(event);
                }
            }
        } else if (action == 3) {
            if (this.needRegisterRightEvent) {
                velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(event);
                }
                velocityTracker2 = this.velocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.computeCurrentVelocity(20);
                }
                velocityTracker3 = this.velocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                }
                this.velocityTracker = null;
                if (this.needRegisterRightEvent) {
                    this.activityStarted = true;
                    onSwipeRightListener = this.onSwipeRightListener;
                    if (onSwipeRightListener != null) {
                        onSwipeRightListener.onSwipeRight(event);
                    }
                }
            }
            onTouchClickListener = this.onMoveClickListener;
            if (onTouchClickListener != null) {
                onTouchClickListener.onClickUp();
            }
            removeCallbacks(this.mLongPressRunnable);
            onLongLayoutTouchClickListener = this.onClickListener;
            if (onLongLayoutTouchClickListener != null) {
                onLongLayoutTouchClickListener.onTouch(event);
            }
            z = this.mLongPressed;
            if (z) {
                return z;
            }
        }
        return super.dispatchTouchEvent(event);
    }

    public final void setOnSwipeRightListener(OnSwipeRightListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onSwipeRightListener = listener;
    }

    public final void setOnLongLayoutTouchClickListener(OnLongLayoutTouchClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.onClickListener = clickListener;
    }

    public final void setOnMoveClickListener(OnTouchClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.onMoveClickListener = clickListener;
    }

    public final void removeMoveClickListener() {
        this.onMoveClickListener = null;
    }
}
