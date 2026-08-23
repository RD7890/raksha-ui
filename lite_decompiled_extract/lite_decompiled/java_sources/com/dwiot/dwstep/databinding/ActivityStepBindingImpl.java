package com.dwiot.dwstep.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextClock;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.dwiot.dwstep.R;
import com.dwiot.dwstep.view.ActiveProgressCircle;
import com.dwiot.dwstep.view.ItemStepDataView;
import com.dwiot.dwstep.view.StepWeekChart;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class ActivityStepBindingImpl extends ActivityStepBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.top_clock, 1);
        sparseIntArray.put(R.id.active_progress_circle, 2);
        sparseIntArray.put(R.id.view, 3);
        sparseIntArray.put(R.id.txtStep, 4);
        sparseIntArray.put(R.id.txtDistance, 5);
        sparseIntArray.put(R.id.txtCalories, 6);
        sparseIntArray.put(R.id.itemStepDataView, 7);
        sparseIntArray.put(R.id.itemDistanceDataView, 8);
        sparseIntArray.put(R.id.itemCaloDataView, 9);
        sparseIntArray.put(R.id.txtStepTarget, 10);
        sparseIntArray.put(R.id.stepBar, 11);
        sparseIntArray.put(R.id.txtTotalStep, 12);
    }

    public ActivityStepBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private ActivityStepBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ActiveProgressCircle) objArr[2], (ItemStepDataView) objArr[9], (ItemStepDataView) objArr[8], (ItemStepDataView) objArr[7], (StepWeekChart) objArr[11], (TextClock) objArr[1], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[10], (TextView) objArr[12], (View) objArr[3]);
        this.mDirtyFlags = -1L;
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
