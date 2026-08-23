package com.dw.launcher.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OutViewPagerImpl.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u000e\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\u001aJ\u0006\u0010\u001f\u001a\u00020\tJ\u0010\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/dw/launcher/ui/view/OutViewPagerImpl;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "allowLeftMove", "", "getAllowLeftMove", "()Z", "setAllowLeftMove", "(Z)V", "disabled", "leftEdgeEnable", "mDownTime", "", "mDownY", "", "mEdgeSize", "mInterceptorTouchDownX", "mTouchDownX", "mTouchSlop", "", "AllowLefMoveDisable", "", "AllowLefMoveEnable", "disableLeftEdge", "enableLeftEdge", "enabled", "isDisabled", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class OutViewPagerImpl extends ViewPager {
    private boolean allowLeftMove;
    private boolean disabled;
    private boolean leftEdgeEnable;
    private long mDownTime;
    private float mDownY;
    private float mEdgeSize;
    private float mInterceptorTouchDownX;
    private float mTouchDownX;
    private int mTouchSlop;

    public final boolean getAllowLeftMove() {
        return this.allowLeftMove;
    }

    public final void setAllowLeftMove(boolean z) {
        this.allowLeftMove = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutViewPagerImpl(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 6;
        this.mEdgeSize = ViewConfiguration.get(getContext()).getScaledEdgeSlop() * 2.5f;
        this.allowLeftMove = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutViewPagerImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 6;
        this.mEdgeSize = ViewConfiguration.get(getContext()).getScaledEdgeSlop() * 2.5f;
        this.allowLeftMove = true;
    }

    public final void enableLeftEdge() {
        this.leftEdgeEnable = true;
    }

    public final void disableLeftEdge() {
        this.leftEdgeEnable = false;
    }

    public final void enabled() {
        this.disabled = false;
    }

    public final void disabled() {
        this.disabled = true;
    }

    /* JADX INFO: renamed from: isDisabled, reason: from getter */
    public final boolean getDisabled() {
        return this.disabled;
    }

    public final void AllowLefMoveEnable() {
        this.allowLeftMove = true;
    }

    public final void AllowLefMoveDisable() {
        this.allowLeftMove = false;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x004c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0057 A[RETURN] */
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.disabled) {
            return false;
        }
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 0) {
            this.mDownTime = ev.getDownTime();
            this.mDownY = ev.getY();
            this.mInterceptorTouchDownX = ev.getX();
        } else if (actionMasked == 1) {
            this.mInterceptorTouchDownX = 0.0f;
            if (this.mTouchDownX > this.mEdgeSize) {
                return false;
            }
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                this.mInterceptorTouchDownX = 0.0f;
                if (this.mTouchDownX > this.mEdgeSize) {
                    return false;
                }
            }
        } else {
            if (this.leftEdgeEnable) {
                float f = this.mInterceptorTouchDownX;
                return f <= this.mEdgeSize && Math.abs(f - ev.getX()) >= 2.0f;
            }
            if (this.allowLeftMove && this.mInterceptorTouchDownX - ev.getX() > this.mTouchSlop) {
                return true;
            }
        }
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0034  */
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.disabled) {
            return false;
        }
        if (this.leftEdgeEnable) {
            int actionMasked = ev.getActionMasked();
            if (actionMasked == 0) {
                this.mTouchDownX = ev.getX();
            } else if (actionMasked == 1) {
                this.mTouchDownX = 0.0f;
                if (0.0f > this.mEdgeSize && 0.0f < getWidth() - this.mEdgeSize) {
                    return false;
                }
            } else if (actionMasked == 2) {
                float f = this.mTouchDownX;
                if (f > this.mEdgeSize && f < getWidth() - this.mEdgeSize) {
                    return false;
                }
            } else if (actionMasked == 3) {
                this.mTouchDownX = 0.0f;
                if (0.0f > this.mEdgeSize) {
                    return false;
                }
            }
        }
        try {
            return super.onTouchEvent(ev);
        } catch (Exception unused) {
            return false;
        }
    }
}
