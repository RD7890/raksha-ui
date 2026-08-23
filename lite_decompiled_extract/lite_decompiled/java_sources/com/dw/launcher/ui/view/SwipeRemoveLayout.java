package com.dw.launcher.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SwipeRemoveLayout.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/dw/launcher/ui/view/SwipeRemoveLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mDragCallback", "com/dw/launcher/ui/view/SwipeRemoveLayout$mDragCallback$1", "Lcom/dw/launcher/ui/view/SwipeRemoveLayout$mDragCallback$1;", "mDragHelper", "Landroidx/customview/widget/ViewDragHelper;", "kotlin.jvm.PlatformType", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class SwipeRemoveLayout extends FrameLayout {
    private final SwipeRemoveLayout$mDragCallback$1 mDragCallback;
    private final ViewDragHelper mDragHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.dw.launcher.ui.view.SwipeRemoveLayout$mDragCallback$1] */
    public SwipeRemoveLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        ?? r2 = new ViewDragHelper.Callback() { // from class: com.dw.launcher.ui.view.SwipeRemoveLayout$mDragCallback$1
            private int mInitX;
            private int mLeft;

            public boolean tryCaptureView(View child, int pointerId) {
                Intrinsics.checkNotNullParameter(child, "child");
                return Intrinsics.areEqual(child.getParent(), this.this$0);
            }

            public int getViewHorizontalDragRange(View child) {
                Intrinsics.checkNotNullParameter(child, "child");
                return this.this$0.getWidth();
            }

            public int clampViewPositionHorizontal(View child, int left, int dx) {
                Intrinsics.checkNotNullParameter(child, "child");
                return super.clampViewPositionHorizontal(child, left, dx);
            }
        };
        this.mDragCallback = r2;
        this.mDragHelper = ViewDragHelper.create(this, (ViewDragHelper.Callback) r2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.dw.launcher.ui.view.SwipeRemoveLayout$mDragCallback$1] */
    public SwipeRemoveLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ?? r2 = new ViewDragHelper.Callback() { // from class: com.dw.launcher.ui.view.SwipeRemoveLayout$mDragCallback$1
            private int mInitX;
            private int mLeft;

            public boolean tryCaptureView(View child, int pointerId) {
                Intrinsics.checkNotNullParameter(child, "child");
                return Intrinsics.areEqual(child.getParent(), this.this$0);
            }

            public int getViewHorizontalDragRange(View child) {
                Intrinsics.checkNotNullParameter(child, "child");
                return this.this$0.getWidth();
            }

            public int clampViewPositionHorizontal(View child, int left, int dx) {
                Intrinsics.checkNotNullParameter(child, "child");
                return super.clampViewPositionHorizontal(child, left, dx);
            }
        };
        this.mDragCallback = r2;
        this.mDragHelper = ViewDragHelper.create(this, (ViewDragHelper.Callback) r2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.dw.launcher.ui.view.SwipeRemoveLayout$mDragCallback$1] */
    public SwipeRemoveLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ?? r2 = new ViewDragHelper.Callback() { // from class: com.dw.launcher.ui.view.SwipeRemoveLayout$mDragCallback$1
            private int mInitX;
            private int mLeft;

            public boolean tryCaptureView(View child, int pointerId) {
                Intrinsics.checkNotNullParameter(child, "child");
                return Intrinsics.areEqual(child.getParent(), this.this$0);
            }

            public int getViewHorizontalDragRange(View child) {
                Intrinsics.checkNotNullParameter(child, "child");
                return this.this$0.getWidth();
            }

            public int clampViewPositionHorizontal(View child, int left, int dx) {
                Intrinsics.checkNotNullParameter(child, "child");
                return super.clampViewPositionHorizontal(child, left, dx);
            }
        };
        this.mDragCallback = r2;
        this.mDragHelper = ViewDragHelper.create(this, (ViewDragHelper.Callback) r2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            this.mDragHelper.cancel();
            return false;
        }
        return this.mDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        this.mDragHelper.processTouchEvent(ev);
        return true;
    }
}
