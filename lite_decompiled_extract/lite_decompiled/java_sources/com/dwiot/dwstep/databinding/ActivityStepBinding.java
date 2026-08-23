package com.dwiot.dwstep.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dwiot.dwstep.R;
import com.dwiot.dwstep.view.ActiveProgressCircle;
import com.dwiot.dwstep.view.ItemStepDataView;
import com.dwiot.dwstep.view.StepWeekChart;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public abstract class ActivityStepBinding extends ViewDataBinding {
    public final ActiveProgressCircle activeProgressCircle;
    public final ItemStepDataView itemCaloDataView;
    public final ItemStepDataView itemDistanceDataView;
    public final ItemStepDataView itemStepDataView;
    public final StepWeekChart stepBar;
    public final TextClock topClock;
    public final TextView txtCalories;
    public final TextView txtDistance;
    public final TextView txtStep;
    public final TextView txtStepTarget;
    public final TextView txtTotalStep;
    public final View view;

    protected ActivityStepBinding(Object obj, View view, int i, ActiveProgressCircle activeProgressCircle, ItemStepDataView itemStepDataView, ItemStepDataView itemStepDataView2, ItemStepDataView itemStepDataView3, StepWeekChart stepWeekChart, TextClock textClock, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2) {
        super(obj, view, i);
        this.activeProgressCircle = activeProgressCircle;
        this.itemCaloDataView = itemStepDataView;
        this.itemDistanceDataView = itemStepDataView2;
        this.itemStepDataView = itemStepDataView3;
        this.stepBar = stepWeekChart;
        this.topClock = textClock;
        this.txtCalories = textView;
        this.txtDistance = textView2;
        this.txtStep = textView3;
        this.txtStepTarget = textView4;
        this.txtTotalStep = textView5;
        this.view = view2;
    }

    public static ActivityStepBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityStepBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityStepBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_step, viewGroup, z, obj);
    }

    public static ActivityStepBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityStepBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityStepBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_step, (ViewGroup) null, false, obj);
    }

    public static ActivityStepBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityStepBinding bind(View view, Object obj) {
        return (ActivityStepBinding) bind(obj, view, R.layout.activity_step);
    }
}
