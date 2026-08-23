package com.dw.launcher.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: ScaleRecyclerView.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rJ\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0017\u001a\u00020\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/dw/launcher/ui/view/ScaleRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isScale", "", "()Z", "setScale", "(Z)V", "onScaleListener", "Lcom/dw/launcher/ui/view/ScaleRecyclerView$OnScaleListener;", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "addScaleListener", "", "listener", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "onTouchEvent", "restore", "OnScaleListener", "ScaleListener", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ScaleRecyclerView extends RecyclerView {
    private boolean isScale;
    private OnScaleListener onScaleListener;
    private ScaleGestureDetector scaleGestureDetector;

    /* JADX INFO: compiled from: ScaleRecyclerView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/dw/launcher/ui/view/ScaleRecyclerView$OnScaleListener;", "", "onBeginScale", "", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "onEndScale", "onScale", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public interface OnScaleListener {
        void onBeginScale(ScaleGestureDetector scaleGestureDetector);

        void onEndScale(ScaleGestureDetector scaleGestureDetector);

        void onScale(ScaleGestureDetector scaleGestureDetector);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.scaleGestureDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    /* JADX INFO: renamed from: isScale, reason: from getter */
    public final boolean getIsScale() {
        return this.isScale;
    }

    public final void setScale(boolean z) {
        this.isScale = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        ScaleGestureDetector scaleGestureDetector = this.scaleGestureDetector;
        if (scaleGestureDetector != null) {
            scaleGestureDetector.onTouchEvent(e);
        }
        if (e.getActionMasked() == 5) {
            this.isScale = true;
            Timber.INSTANCE.e("onInterceptTouchEvent 双指按下去...", new Object[0]);
        }
        if (this.isScale) {
            return true;
        }
        return super.onInterceptTouchEvent(e);
    }

    public boolean onTouchEvent(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (e.getActionMasked() == 6) {
            this.isScale = false;
            Timber.INSTANCE.e("双指释放...", new Object[0]);
            OnScaleListener onScaleListener = this.onScaleListener;
            if (onScaleListener != null) {
                onScaleListener.onEndScale(null);
            }
        } else if (e.getActionMasked() == 5) {
            Timber.INSTANCE.e("onTouchEvent双指按下...", new Object[0]);
            this.isScale = true;
        }
        ScaleGestureDetector scaleGestureDetector = this.scaleGestureDetector;
        Intrinsics.checkNotNull(scaleGestureDetector != null ? Boolean.valueOf(scaleGestureDetector.onTouchEvent(e)) : null);
        if (this.isScale) {
            return true;
        }
        return super.onTouchEvent(e);
    }

    /* JADX INFO: compiled from: ScaleRecyclerView.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/dw/launcher/ui/view/ScaleRecyclerView$ScaleListener;", "Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;", "(Lcom/dw/launcher/ui/view/ScaleRecyclerView;)V", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    private final class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            OnScaleListener onScaleListener = ScaleRecyclerView.this.onScaleListener;
            if (onScaleListener == null) {
                return true;
            }
            onScaleListener.onScale(detector);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            if (!ScaleRecyclerView.this.getIsScale()) {
                return false;
            }
            OnScaleListener onScaleListener = ScaleRecyclerView.this.onScaleListener;
            if (onScaleListener == null) {
                return true;
            }
            onScaleListener.onBeginScale(detector);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector detector) {
            OnScaleListener onScaleListener;
            if (ScaleRecyclerView.this.getIsScale() || (onScaleListener = ScaleRecyclerView.this.onScaleListener) == null) {
                return;
            }
            onScaleListener.onEndScale(detector);
        }
    }

    public final void addScaleListener(OnScaleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onScaleListener = listener;
    }

    public final void restore() {
        this.isScale = false;
    }
}
