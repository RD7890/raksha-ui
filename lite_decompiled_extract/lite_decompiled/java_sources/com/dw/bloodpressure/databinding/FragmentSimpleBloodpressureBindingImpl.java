package com.dw.bloodpressure.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.dw.bloodpressure.BloodPressChart;
import com.dw.bloodpressure.R;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public class FragmentSimpleBloodpressureBindingImpl extends FragmentSimpleBloodpressureBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 1);
        sparseIntArray.put(R.id.top_clock, 2);
        sparseIntArray.put(R.id.ivAnim, 3);
        sparseIntArray.put(R.id.txtHeart_high, 4);
        sparseIntArray.put(R.id.txtHeart_low, 5);
        sparseIntArray.put(R.id.txtStatus, 6);
        sparseIntArray.put(R.id.bloodPressChart, 7);
        sparseIntArray.put(R.id.txtMaxOxygen, 8);
        sparseIntArray.put(R.id.txtMinOxygen, 9);
        sparseIntArray.put(R.id.txtAvgOxygen_high, 10);
        sparseIntArray.put(R.id.txtAvgOxygen_low, 11);
        sparseIntArray.put(R.id.txtUnit, 12);
        sparseIntArray.put(R.id.wrist_status, 13);
    }

    public FragmentSimpleBloodpressureBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private FragmentSimpleBloodpressureBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BloodPressChart) objArr[7], (ImageView) objArr[3], (RelativeLayout) objArr[1], (TextClock) objArr[2], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[6], (TextView) objArr[12], (RelativeLayout) objArr[13]);
        this.mDirtyFlags = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
