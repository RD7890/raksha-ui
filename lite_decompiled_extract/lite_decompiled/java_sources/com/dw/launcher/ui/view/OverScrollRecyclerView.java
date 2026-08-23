package com.dw.launcher.ui.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class OverScrollRecyclerView extends RecyclerView implements View.OnTouchListener {
    private static final float DEFAULT_DECELERATE_FACTOR = -2.0f;
    private static final float DEFAULT_TOUCH_DRAG_MOVE_RATIO_BCK = 1.0f;
    private static final float DEFAULT_TOUCH_DRAG_MOVE_RATIO_FWD = 2.0f;
    private static final int MAX_BOUNCE_BACK_DURATION_MS = 800;
    private static final int MIN_BOUNCE_BACK_DURATION_MS = 200;
    private double flingScale;
    private BounceBackState mBounceBackState;
    private IDecoratorState mCurrentState;
    private IdleState mIdleState;
    private OverScrollingState mOverScrollingState;
    private final RecyclerView mRecyclerView;
    private final OverScrollStartAttributes mStartAttr;
    private float mVelocity;

    protected interface IDecoratorState {
        boolean handleMoveTouchEvent(MotionEvent event);

        void handleTransitionAnim(IDecoratorState fromState);

        boolean handleUpTouchEvent(MotionEvent event);
    }

    public OverScrollRecyclerView(Context context) {
        this(context, null);
    }

    public OverScrollRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OverScrollRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mStartAttr = new OverScrollStartAttributes();
        this.mRecyclerView = this;
        this.flingScale = 0.0d;
        initParams();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        if (action != 1) {
            if (action == 2) {
                return this.mCurrentState.handleMoveTouchEvent(event);
            }
            if (action != 3) {
                return false;
            }
        }
        return this.mCurrentState.handleUpTouchEvent(event);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        detach();
    }

    public void attach() {
        this.mRecyclerView.setOnTouchListener(this);
        this.mRecyclerView.setOverScrollMode(2);
    }

    public void detach() {
        this.mRecyclerView.setOnTouchListener((View.OnTouchListener) null);
        this.mRecyclerView.setOverScrollMode(0);
    }

    private void initParams() {
        this.mBounceBackState = new BounceBackState();
        this.mOverScrollingState = new OverScrollingState();
        IdleState idleState = new IdleState();
        this.mIdleState = idleState;
        this.mCurrentState = idleState;
        attach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void issueStateTransition(IDecoratorState state) {
        IDecoratorState iDecoratorState = this.mCurrentState;
        this.mCurrentState = state;
        state.handleTransitionAnim(iDecoratorState);
    }

    protected static class MotionAttributes {
        float mAbsOffset;
        float mDeltaOffset;
        boolean mDir;

        protected MotionAttributes() {
        }
    }

    protected static class OverScrollStartAttributes {
        float mAbsOffset;
        boolean mDir;
        int mPointerId;

        protected OverScrollStartAttributes() {
        }
    }

    protected static class AnimationAttributes {
        float mAbsOffset;
        float mMaxOffset;
        Property<View, Float> mProperty;

        protected AnimationAttributes() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAnimationAttributes(View view, AnimationAttributes attributes) {
        attributes.mProperty = View.TRANSLATION_Y;
        attributes.mAbsOffset = view.getTranslationY();
        attributes.mMaxOffset = view.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initMotionAttributes(View view, MotionAttributes attributes, MotionEvent event) {
        if (event.getHistorySize() == 0) {
            return false;
        }
        float y = event.getY(0) - event.getHistoricalY(0, 0);
        if (Math.abs(y) < Math.abs(event.getX(0) - event.getHistoricalX(0, 0))) {
            return false;
        }
        attributes.mAbsOffset = view.getTranslationY();
        attributes.mDeltaOffset = y;
        attributes.mDir = attributes.mDeltaOffset > 0.0f;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInAbsoluteStart(View view) {
        return !view.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInAbsoluteEnd(View view) {
        return !view.canScrollVertically(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translateView(View view, float offset) {
        view.setTranslationY(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translateViewAndEvent(View view, float offset, MotionEvent event) {
        view.setTranslationY(offset);
        event.offsetLocation(0.0f, offset - event.getY(0));
    }

    class IdleState implements IDecoratorState {
        private final MotionAttributes mMoveAttr = new MotionAttributes();

        @Override // com.dw.launcher.ui.view.OverScrollRecyclerView.IDecoratorState
        public void handleTransitionAnim(IDecoratorState fromState) {
        }

        @Override // com.dw.launcher.ui.view.OverScrollRecyclerView.IDecoratorState
        public boolean handleUpTouchEvent(MotionEvent event) {
            return false;
        }

        IdleState() {
        }

        @Override // com.dw.launcher.ui.view.OverScrollRecyclerView.IDecoratorState
        public boolean handleMoveTouchEvent(MotionEvent event) {
            OverScrollRecyclerView overScrollRecyclerView = OverScrollRecyclerView.this;
            if (!overScrollRecyclerView.initMotionAttributes(overScrollRecyclerView.mRecyclerView, this.mMoveAttr, event)) {
                return false;
            }
            OverScrollRecyclerView overScrollRecyclerView2 = OverScrollRecyclerView.this;
            if (!overScrollRecyclerView2.isInAbsoluteStart(overScrollRecyclerView2.mRecyclerView) || !this.mMoveAttr.mDir) {
                OverScrollRecyclerView overScrollRecyclerView3 = OverScrollRecyclerView.this;
                if (!overScrollRecyclerView3.isInAbsoluteEnd(overScrollRecyclerView3.mRecyclerView) || this.mMoveAttr.mDir) {
                    return false;
                }
            }
            OverScrollRecyclerView.this.mStartAttr.mPointerId = event.getPointerId(0);
            OverScrollRecyclerView.this.mStartAttr.mAbsOffset = this.mMoveAttr.mAbsOffset;
            OverScrollRecyclerView.this.mStartAttr.mDir = this.mMoveAttr.mDir;
            OverScrollRecyclerView overScrollRecyclerView4 = OverScrollRecyclerView.this;
            overScrollRecyclerView4.issueStateTransition(overScrollRecyclerView4.mOverScrollingState);
            return OverScrollRecyclerView.this.mOverScrollingState.handleMoveTouchEvent(event);
        }
    }

    class OverScrollingState implements IDecoratorState {
        private final MotionAttributes mMoveAttr = new MotionAttributes();
        private final float mTouchDragRatioFwd = OverScrollRecyclerView.DEFAULT_TOUCH_DRAG_MOVE_RATIO_FWD;
        private final float mTouchDragRatioBck = 1.0f;

        @Override // com.dw.launcher.ui.view.OverScrollRecyclerView.IDecoratorState
        public void handleTransitionAnim(IDecoratorState fromState) {
        }

        public OverScrollingState() {
        }

        @Override // com.dw.launcher.ui.view.OverScrollRecyclerView.IDecoratorState
        public boolean handleMoveTouchEvent(MotionEvent event) {
            OverScrollStartAttributes overScrollStartAttributes = OverScrollRecyclerView.this.mStartAttr;
            if (overScrollStartAttributes.mPointerId == event.getPointerId(0)) {
                RecyclerView recyclerView = OverScrollRecyclerView.this.mRecyclerView;
                if (!OverScrollRecyclerView.this.initMotionAttributes(recyclerView, this.mMoveAttr, event)) {
                    return true;
                }
                float f = this.mMoveAttr.mDeltaOffset / (this.mMoveAttr.mDir == overScrollStartAttributes.mDir ? this.mTouchDragRatioFwd : this.mTouchDragRatioBck);
                float f2 = this.mMoveAttr.mAbsOffset + f;
                if ((overScrollStartAttributes.mDir && !this.mMoveAttr.mDir && f2 <= overScrollStartAttributes.mAbsOffset) || (!overScrollStartAttributes.mDir && this.mMoveAttr.mDir && f2 >= overScrollStartAttributes.mAbsOffset)) {
                    OverScrollRecyclerView.this.translateViewAndEvent(recyclerView, overScrollStartAttributes.mAbsOffset, event);
                    OverScrollRecyclerView overScrollRecyclerView = OverScrollRecyclerView.this;
                    overScrollRecyclerView.issueStateTransition(overScrollRecyclerView.mIdleState);
                    return true;
                }
                if (recyclerView.getParent() != null) {
                    recyclerView.getParent().requestDisallowInterceptTouchEvent(true);
                }
                long eventTime = event.getEventTime() - event.getHistoricalEventTime(0);
                if (eventTime > 0) {
                    OverScrollRecyclerView.this.mVelocity = f / eventTime;
                }
                OverScrollRecyclerView.this.translateView(recyclerView, f2);
                return true;
            }
            OverScrollRecyclerView overScrollRecyclerView2 = OverScrollRecyclerView.this;
            overScrollRecyclerView2.issueStateTransition(overScrollRecyclerView2.mBounceBackState);
            return true;
        }

        @Override // com.dw.launcher.ui.view.OverScrollRecyclerView.IDecoratorState
        public boolean handleUpTouchEvent(MotionEvent event) {
            OverScrollRecyclerView overScrollRecyclerView = OverScrollRecyclerView.this;
            overScrollRecyclerView.issueStateTransition(overScrollRecyclerView.mBounceBackState);
            return false;
        }
    }

    class BounceBackState implements IDecoratorState, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        final View view;
        private final Interpolator mBounceBackInterpolator = new DecelerateInterpolator();
        private final float mDecelerateFactor = OverScrollRecyclerView.DEFAULT_DECELERATE_FACTOR;
        private final float mDoubleDecelerateFactor = -4.0f;
        private final AnimationAttributes mAnimAttributes = new AnimationAttributes();

        @Override // com.dw.launcher.ui.view.OverScrollRecyclerView.IDecoratorState
        public boolean handleMoveTouchEvent(MotionEvent event) {
            return true;
        }

        @Override // com.dw.launcher.ui.view.OverScrollRecyclerView.IDecoratorState
        public boolean handleUpTouchEvent(MotionEvent event) {
            return true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
        }

        public BounceBackState() {
            this.view = OverScrollRecyclerView.this.mRecyclerView;
        }

        @Override // com.dw.launcher.ui.view.OverScrollRecyclerView.IDecoratorState
        public void handleTransitionAnim(IDecoratorState fromState) {
            Animator animatorCreateAnimator = createAnimator();
            animatorCreateAnimator.addListener(this);
            animatorCreateAnimator.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            OverScrollRecyclerView overScrollRecyclerView = OverScrollRecyclerView.this;
            overScrollRecyclerView.issueStateTransition(overScrollRecyclerView.mIdleState);
        }

        private Animator createAnimator() {
            OverScrollRecyclerView.this.initAnimationAttributes(this.view, this.mAnimAttributes);
            if (OverScrollRecyclerView.this.mVelocity != 0.0f && ((OverScrollRecyclerView.this.mVelocity >= 0.0f || !OverScrollRecyclerView.this.mStartAttr.mDir) && (OverScrollRecyclerView.this.mVelocity <= 0.0f || OverScrollRecyclerView.this.mStartAttr.mDir))) {
                float f = (0.0f - OverScrollRecyclerView.this.mVelocity) / this.mDecelerateFactor;
                float f2 = f >= 0.0f ? f : 0.0f;
                float f3 = this.mAnimAttributes.mAbsOffset + (((-OverScrollRecyclerView.this.mVelocity) * OverScrollRecyclerView.this.mVelocity) / this.mDoubleDecelerateFactor);
                ObjectAnimator objectAnimatorCreateSlowdownAnimator = createSlowdownAnimator(this.view, (int) f2, f3);
                ObjectAnimator objectAnimatorCreateBounceBackAnimator = createBounceBackAnimator(f3);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(objectAnimatorCreateSlowdownAnimator, objectAnimatorCreateBounceBackAnimator);
                return animatorSet;
            }
            return createBounceBackAnimator(this.mAnimAttributes.mAbsOffset);
        }

        private ObjectAnimator createSlowdownAnimator(View view, int slowdownDuration, float slowdownEndOffset) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, this.mAnimAttributes.mProperty, slowdownEndOffset);
            objectAnimatorOfFloat.setDuration(slowdownDuration);
            objectAnimatorOfFloat.setInterpolator(this.mBounceBackInterpolator);
            objectAnimatorOfFloat.addUpdateListener(this);
            return objectAnimatorOfFloat;
        }

        private ObjectAnimator createBounceBackAnimator(float startOffset) {
            float fAbs = (Math.abs(startOffset) / this.mAnimAttributes.mMaxOffset) * 800.0f;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.view, this.mAnimAttributes.mProperty, OverScrollRecyclerView.this.mStartAttr.mAbsOffset);
            objectAnimatorOfFloat.setDuration(Math.max((int) fAbs, 200));
            objectAnimatorOfFloat.setInterpolator(this.mBounceBackInterpolator);
            objectAnimatorOfFloat.addUpdateListener(this);
            return objectAnimatorOfFloat;
        }
    }

    public boolean fling(int velocityX, int velocityY) {
        return super.fling(velocityX, (int) (((double) velocityY) * this.flingScale));
    }

    public void setFlingScale(double scale) {
        this.flingScale = scale;
    }
}
