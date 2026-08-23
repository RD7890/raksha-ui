package com.dw.launcher.ui.view;

import android.content.Context;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.dw.launcher.util.ResourceUtils;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ForbidTopRecyclerView.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/dw/launcher/ui/view/ForbidTopRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TOP_LIMIT", "isInTopRegion", "", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "onTouchEvent", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public class ForbidTopRecyclerView extends RecyclerView {
    private int TOP_LIMIT;
    private boolean isInTopRegion;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForbidTopRecyclerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TOP_LIMIT = 48;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.TOP_LIMIT = (int) ResourceUtils.dpToPx(context2, 40.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForbidTopRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.TOP_LIMIT = 48;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.TOP_LIMIT = (int) ResourceUtils.dpToPx(context2, 40.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForbidTopRecyclerView(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.TOP_LIMIT = 48;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.TOP_LIMIT = (int) ResourceUtils.dpToPx(context2, 40.0f);
    }

    public boolean onInterceptTouchEvent(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (Settings.System.getInt(getContext().getContentResolver(), "down_menu_mode", 0) == 0) {
            this.isInTopRegion = false;
            return super.onInterceptTouchEvent(e);
        }
        float y = e.getY();
        if (e.getAction() == 0) {
            this.isInTopRegion = y <= ((float) this.TOP_LIMIT);
        }
        if (this.isInTopRegion) {
            return false;
        }
        return super.onInterceptTouchEvent(e);
    }

    public boolean onTouchEvent(MotionEvent e) {
        if (this.isInTopRegion) {
            return true;
        }
        return super.onTouchEvent(e);
    }
}
