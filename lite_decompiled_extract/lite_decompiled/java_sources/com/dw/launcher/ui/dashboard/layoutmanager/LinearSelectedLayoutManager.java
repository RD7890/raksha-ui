package com.dw.launcher.ui.dashboard.layoutmanager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.dw.launcher.ui.dashboard.transformation.LinearSelectedTransformation;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LinearSelectedLayoutManager.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 32\u00020\u0001:\u000234B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J,\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0015R\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u001c\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\n\u0010\u0014\u001a\u00060\u0015R\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\nH\u0002J\u001c\u0010\"\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0015R\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010$\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020%H\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u001c\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\n2\n\u0010\u0014\u001a\u00060\u0015R\u00020\u0016H\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\u0006\u0010+\u001a\u00020\u0013J\u0010\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\nH\u0016J$\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\n\u0010\u0014\u001a\u00060\u0015R\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J$\u00100\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010-\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/LinearSelectedLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "minScale", "", "transformation", "Lcom/dw/launcher/ui/dashboard/transformation/LinearSelectedTransformation;", "(Landroid/content/Context;FLcom/dw/launcher/ui/dashboard/transformation/LinearSelectedTransformation;)V", "mLastPosition", "", "mOffset", "mPendingFillPosition", "mPendingSavedState", "Lcom/dw/launcher/ui/dashboard/layoutmanager/LinearSelectedLayoutManager$SavedState;", "mPendingScrollToPosition", "canScrollVertically", "", "fillLayout", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "fillPosition", "offset", "fillScroll", "delta", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "getChildClosestToStart", "Landroid/view/View;", "getSelectedPosition", "onLayoutChildren", "onLayoutCompleted", "onRestoreInstanceState", "Landroid/os/Parcelable;", "onSaveInstanceState", "onScrollStateChanged", "recycle", "dx", "savedLastPosition", "scheduleToFinishScroll", "scrollToPosition", "position", "scrollVerticallyBy", "dy", "smoothScrollToPosition", "recyclerView", "transformChildren", "Companion", "SavedState", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class LinearSelectedLayoutManager extends RecyclerView.LayoutManager {
    public static final boolean DEBUG = true;
    public static final String TAG = "LinearSelectedLayout";
    private final Context context;
    private int mLastPosition;
    private int mOffset;
    private int mPendingFillPosition;
    private SavedState mPendingSavedState;
    private int mPendingScrollToPosition;
    private final float minScale;
    private final LinearSelectedTransformation transformation;

    public boolean canScrollVertically() {
        return true;
    }

    public /* synthetic */ LinearSelectedLayoutManager(Context context, float f, LinearSelectedTransformation linearSelectedTransformation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? 0.6f : f, (i & 4) != 0 ? null : linearSelectedTransformation);
    }

    public LinearSelectedLayoutManager(Context context, float f, LinearSelectedTransformation linearSelectedTransformation) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.minScale = f;
        this.transformation = linearSelectedTransformation;
        this.mPendingScrollToPosition = -1;
        this.mLastPosition = -1;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        Log.i("LinearSelectedLayout", "onLayoutChildren: lastPosition: " + this.mLastPosition + ", offset: " + this.mOffset);
        this.mPendingFillPosition = 0;
        int i = this.mPendingScrollToPosition;
        if (i != -1) {
            this.mPendingFillPosition = i;
            this.mOffset = 0;
        } else {
            int i2 = this.mLastPosition;
            if (i2 != -1) {
                this.mPendingFillPosition = i2;
            } else {
                this.mOffset = 0;
                this.mPendingFillPosition = getSelectedPosition();
            }
        }
        this.mPendingFillPosition = RangesKt.coerceAtMost(this.mPendingFillPosition, getItemCount() - 1);
        this.mPendingFillPosition = RangesKt.coerceAtLeast(this.mPendingScrollToPosition, 0);
        detachAndScrapAttachedViews(recycler);
        fillLayout(recycler, state, this.mPendingFillPosition, this.mOffset);
        transformChildren();
        savedLastPosition();
    }

    private final void savedLastPosition() {
        if (getChildCount() > 0) {
            View childClosestToStart = getChildClosestToStart();
            this.mLastPosition = getPosition(childClosestToStart);
            this.mOffset = getDecoratedTop(childClosestToStart);
        } else {
            this.mLastPosition = 0;
            this.mOffset = 0;
        }
        Log.i("LinearSelectedLayout", "savedLastPosition: lastPosition: " + this.mLastPosition + ", offset: " + this.mOffset);
    }

    private final void transformChildren() {
        int selectedPosition = getSelectedPosition();
        float f = 1;
        float f2 = (f - this.minScale) / selectedPosition;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            float fAbs = f - (Math.abs(i - selectedPosition) * f2);
            if (i != selectedPosition) {
                childAt.setSelected(false);
                if (childAt.hasFocus()) {
                    childAt.clearFocus();
                }
            } else {
                childAt.setSelected(true);
                childAt.requestFocus();
            }
            LinearSelectedTransformation linearSelectedTransformation = this.transformation;
            if (linearSelectedTransformation != null) {
                linearSelectedTransformation.onChildScale(childAt, fAbs);
            }
        }
    }

    private final void fillLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int fillPosition, int offset) {
        detachAndScrapAttachedViews(recycler);
        int i = offset;
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        while (height > 0 && fillPosition < state.getItemCount()) {
            View viewForPosition = recycler.getViewForPosition(fillPosition);
            Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
            addView(viewForPosition);
            measureChild(viewForPosition, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
            int i2 = i + decoratedMeasuredHeight;
            layoutDecorated(viewForPosition, 0, i, decoratedMeasuredWidth, i2);
            fillPosition++;
            height -= decoratedMeasuredHeight;
            i = i2;
        }
    }

    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (getChildCount() == 0 || dy == 0) {
            return 0;
        }
        int iFillScroll = fillScroll(dy, recycler);
        offsetChildrenVertical(-iFillScroll);
        recycle(dy, recycler);
        transformChildren();
        return iFillScroll;
    }

    private final void recycle(int dx, RecyclerView.Recycler recycler) {
        if (dx > 0) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                Intrinsics.checkNotNull(childAt);
                if (getDecoratedBottom(childAt) > 0) {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            }
            return;
        }
        int childCount2 = getChildCount();
        while (true) {
            childCount2--;
            if (-1 >= childCount2) {
                return;
            }
            View childAt2 = getChildAt(childCount2);
            Intrinsics.checkNotNull(childAt2);
            if (getDecoratedTop(childAt2) < getHeight()) {
                return;
            } else {
                removeAndRecycleView(childAt2, recycler);
            }
        }
    }

    private final View getChildClosestToStart() {
        View childAt = getChildAt(0);
        Intrinsics.checkNotNull(childAt);
        return childAt;
    }

    public Parcelable onSaveInstanceState() {
        Log.i("LinearSelectedLayout", "onSaveInstanceState: ");
        if (this.mPendingSavedState != null) {
            SavedState savedState = this.mPendingSavedState;
            Intrinsics.checkNotNull(savedState);
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            View childClosestToStart = getChildClosestToStart();
            savedState2.setMAnchorPosition(getPosition(childClosestToStart));
            savedState2.setMAnchorOffset(getDecoratedTop(childClosestToStart));
        } else {
            savedState2.invalidateAnchor();
        }
        return savedState2;
    }

    public void onRestoreInstanceState(Parcelable state) {
        Log.i("LinearSelectedLayout", "onRestoreInstanceState: ");
        if (state instanceof SavedState) {
            requestLayout();
            Log.d("LinearSelectedLayout", "loaded saved state");
        } else {
            Log.d("LinearSelectedLayout", "invalid saved state class");
        }
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.onLayoutCompleted(state);
        this.mPendingScrollToPosition = -1;
    }

    public void scrollToPosition(int position) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            Intrinsics.checkNotNull(childAt);
            View childAt2 = getChildAt(getChildCount() - 1);
            Intrinsics.checkNotNull(childAt2);
            int position2 = getPosition(childAt);
            if (childAt2.getTop() < getHeight() && position2 <= position) {
                return;
            }
        }
        this.mPendingScrollToPosition = position;
        requestLayout();
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        super.smoothScrollToPosition(recyclerView, state, position);
    }

    private final int fillScroll(int delta, RecyclerView.Recycler recycler) {
        int i;
        int decoratedMeasuredHeight;
        int decoratedMeasuredHeight2;
        int iAbs = Math.abs(delta);
        int iAbs2 = Math.abs(delta);
        if (delta > 0) {
            View childAt = getChildAt(getChildCount() - 1);
            Intrinsics.checkNotNull(childAt);
            int position = getPosition(childAt);
            int decoratedBottom = getDecoratedBottom(childAt);
            i = position + 1;
            if (i >= getItemCount() && decoratedBottom - iAbs < getHeight()) {
                return decoratedBottom - getHeight();
            }
            if (decoratedBottom - iAbs > getHeight()) {
                return delta;
            }
            decoratedMeasuredHeight2 = 0;
            decoratedMeasuredHeight = decoratedBottom;
        } else {
            View childAt2 = getChildAt(0);
            Intrinsics.checkNotNull(childAt2);
            int position2 = getPosition(childAt2);
            int decoratedTop = getDecoratedTop(childAt2);
            i = position2 - 1;
            if (i < 0 && decoratedTop + iAbs > 0) {
                return decoratedTop;
            }
            if (iAbs + decoratedTop < 0) {
                return delta;
            }
            decoratedMeasuredHeight = 0;
            decoratedMeasuredHeight2 = decoratedTop;
        }
        int i2 = i;
        while (iAbs2 > 0 && i2 >= 0 && i2 < getItemCount()) {
            View viewForPosition = recycler.getViewForPosition(i2);
            Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
            if (delta < 0) {
                addView(viewForPosition, 0);
            } else {
                addView(viewForPosition);
            }
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            int decoratedMeasuredHeight3 = getDecoratedMeasuredHeight(viewForPosition);
            if (delta < 0) {
                decoratedMeasuredHeight = decoratedMeasuredHeight2 - decoratedMeasuredHeight3;
                layoutDecorated(viewForPosition, 0, decoratedMeasuredHeight, decoratedMeasuredWidth, decoratedMeasuredHeight2);
                decoratedMeasuredHeight2 -= getDecoratedMeasuredHeight(viewForPosition);
                i2--;
            } else {
                decoratedMeasuredHeight2 = decoratedMeasuredHeight + decoratedMeasuredHeight3;
                layoutDecorated(viewForPosition, 0, decoratedMeasuredHeight, decoratedMeasuredWidth, decoratedMeasuredHeight2);
                decoratedMeasuredHeight += getDecoratedMeasuredHeight(viewForPosition);
                i2++;
            }
            iAbs2 -= getDecoratedMeasuredHeight(viewForPosition);
        }
        return delta;
    }

    private final int getSelectedPosition() {
        int height = getHeight() / 2;
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Intrinsics.checkNotNull(childAt);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(childAt);
            if ((decoratedMeasuredHeight / 2) + paddingTop >= height) {
                return i2;
            }
            paddingTop += decoratedMeasuredHeight;
            i = i2;
        }
        return i;
    }

    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
        if (state == 0) {
            transformChildren();
            savedLastPosition();
        }
    }

    public final void scheduleToFinishScroll() {
        transformChildren();
        savedLastPosition();
    }

    /* JADX INFO: compiled from: LinearSelectedLayoutManager.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/LinearSelectedLayoutManager$SavedState;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "other", "(Lcom/dw/launcher/ui/dashboard/layoutmanager/LinearSelectedLayoutManager$SavedState;)V", "mAnchorOffset", "", "getMAnchorOffset", "()I", "setMAnchorOffset", "(I)V", "mAnchorPosition", "getMAnchorPosition", "setMAnchorPosition", "describeContents", "hasValidAnchor", "", "invalidateAnchor", "", "writeToParcel", "flags", "CREATOR", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    private static final class SavedState implements Parcelable {

        /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private int mAnchorOffset;
        private int mAnchorPosition;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final int getMAnchorPosition() {
            return this.mAnchorPosition;
        }

        public final void setMAnchorPosition(int i) {
            this.mAnchorPosition = i;
        }

        public final int getMAnchorOffset() {
            return this.mAnchorOffset;
        }

        public final void setMAnchorOffset(int i) {
            this.mAnchorOffset = i;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            this();
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
        }

        public SavedState() {
        }

        public SavedState(SavedState other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.mAnchorPosition = other.mAnchorPosition;
            this.mAnchorOffset = other.mAnchorOffset;
        }

        public final boolean hasValidAnchor() {
            return this.mAnchorPosition >= 0;
        }

        public final void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
        }

        /* JADX INFO: renamed from: com.dw.launcher.ui.dashboard.layoutmanager.LinearSelectedLayoutManager$SavedState$CREATOR, reason: from kotlin metadata */
        /* JADX INFO: compiled from: LinearSelectedLayoutManager.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/LinearSelectedLayoutManager$SavedState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/dw/launcher/ui/dashboard/layoutmanager/LinearSelectedLayoutManager$SavedState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/dw/launcher/ui/dashboard/layoutmanager/LinearSelectedLayoutManager$SavedState;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
        public static final class Companion implements Parcelable.Creator<SavedState> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        }
    }
}
