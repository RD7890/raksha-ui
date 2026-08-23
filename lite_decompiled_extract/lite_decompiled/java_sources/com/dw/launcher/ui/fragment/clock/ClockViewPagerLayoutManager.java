package com.dw.launcher.ui.fragment.clock;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClockViewPagerLayoutManager.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001%B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J0\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0016R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006&"}, d2 = {"Lcom/dw/launcher/ui/fragment/clock/ClockViewPagerLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "pageLimit", "", "listener", "Lcom/dw/launcher/ui/fragment/clock/ClockViewPagerLayoutManager$OnPageChangedListener;", "(Landroid/content/Context;ILcom/dw/launcher/ui/fragment/clock/ClockViewPagerLayoutManager$OnPageChangedListener;)V", "offscreenPageLimit", "onPageChangedListener", "scrollable", "", "getScrollable", "()Z", "setScrollable", "(Z)V", "calculateExtraLayoutSpace", "", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "extraLayoutSpace", "", "canScrollHorizontally", "canScrollVertically", "findSelectedPage", "getPageSize", "onScrollStateChanged", "requestChildRectangleOnScreen", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "child", "Landroid/view/View;", "rect", "Landroid/graphics/Rect;", "immediate", "focusedChildVisible", "OnPageChangedListener", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ClockViewPagerLayoutManager extends LinearLayoutManager {
    private int offscreenPageLimit;
    private final OnPageChangedListener onPageChangedListener;
    private boolean scrollable;

    /* JADX INFO: compiled from: ClockViewPagerLayoutManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/ui/fragment/clock/ClockViewPagerLayoutManager$OnPageChangedListener;", "", "onPageChanged", "", "page", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public interface OnPageChangedListener {
        void onPageChanged(int page);
    }

    public boolean requestChildRectangleOnScreen(RecyclerView parent, View child, Rect rect, boolean immediate, boolean focusedChildVisible) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(rect, "rect");
        return false;
    }

    public final boolean getScrollable() {
        return this.scrollable;
    }

    public final void setScrollable(boolean z) {
        this.scrollable = z;
    }

    public /* synthetic */ ClockViewPagerLayoutManager(Context context, int i, OnPageChangedListener onPageChangedListener, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 3 : i, (i2 & 4) != 0 ? null : onPageChangedListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClockViewPagerLayoutManager(Context context, int i, OnPageChangedListener onPageChangedListener) {
        super(context, 0, false);
        Intrinsics.checkNotNullParameter(context, "context");
        this.offscreenPageLimit = i;
        this.onPageChangedListener = onPageChangedListener;
    }

    public boolean canScrollHorizontally() {
        return this.scrollable && super.canScrollHorizontally();
    }

    public boolean canScrollVertically() {
        return this.scrollable && super.canScrollVertically();
    }

    protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] extraLayoutSpace) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(extraLayoutSpace, "extraLayoutSpace");
        int i = this.offscreenPageLimit;
        if (i <= 1) {
            super.calculateExtraLayoutSpace(state, extraLayoutSpace);
            return;
        }
        int pageSize = getPageSize() * i;
        extraLayoutSpace[0] = pageSize;
        extraLayoutSpace[1] = pageSize;
    }

    private final int getPageSize() {
        return getOrientation() == 0 ? getWidth() : getHeight();
    }

    public void onScrollStateChanged(int state) {
        int iFindSelectedPage;
        OnPageChangedListener onPageChangedListener;
        super.onScrollStateChanged(state);
        if (state != 0 || (iFindSelectedPage = findSelectedPage()) < 0 || iFindSelectedPage >= getItemCount() || (onPageChangedListener = this.onPageChangedListener) == null) {
            return;
        }
        onPageChangedListener.onPageChanged(iFindSelectedPage);
    }

    private final int findSelectedPage() {
        Unit unit;
        if (getChildCount() <= 0) {
            return -1;
        }
        int width = getWidth() / 2;
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            if (view != null) {
                if (Math.abs((getDecoratedLeft(view) + (view.getWidth() / 2)) - width) > Math.abs(getDecoratedLeft(childAt) + (view.getWidth() / 2))) {
                    view = childAt;
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                view = childAt;
            }
        }
        if (view != null) {
            return getPosition(view);
        }
        return -1;
    }
}
