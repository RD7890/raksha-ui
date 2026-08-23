package com.dw.launcher.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScrollableSeekBar.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bR\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/dw/launcher/ui/view/ScrollableSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "touchingProgressBar", "", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "setTouchingProgressBar", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ScrollableSeekBar extends AppCompatSeekBar {
    public boolean touchingProgressBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.touchingProgressBar = true;
    }

    public final void setTouchingProgressBar(boolean touchingProgressBar) {
        this.touchingProgressBar = touchingProgressBar;
    }

    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.touchingProgressBar) {
            super.onTouchEvent(event);
            int action = event.getAction();
            if (action == 0) {
                System.out.println((Object) "MotionEvent.ACTION_DOWN");
                getParent().requestDisallowInterceptTouchEvent(true);
                this.touchingProgressBar = true;
            } else if (action == 1) {
                System.out.println((Object) "MotionEvent.ACTION_UP");
                getParent().requestDisallowInterceptTouchEvent(false);
                this.touchingProgressBar = true;
            } else if (action == 3) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        System.out.println((Object) "dispatchTouchEvent");
        super.dispatchTouchEvent(event);
        return true;
    }
}
