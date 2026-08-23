package com.dw.bloodpressure.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dw.bloodpressure.BloodPressureBarChart;
import com.dw.bloodpressure.R;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public abstract class FragmentBloodpressureNewBinding extends ViewDataBinding {
    public final BloodPressureBarChart bloodPressChart;
    public final ImageView ivAnim;
    public final LinearLayout llvalue;
    public final RelativeLayout titleLayout;
    public final TextClock topClock;
    public final TextView txtAvgOxygenHigh;
    public final TextView txtAvgOxygenLow;
    public final TextView txtHeartHigh;
    public final TextView txtHeartLow;
    public final TextView txtStatus;
    public final RelativeLayout wristStatus;

    protected FragmentBloodpressureNewBinding(Object obj, View view, int i, BloodPressureBarChart bloodPressureBarChart, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout, TextClock textClock, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, RelativeLayout relativeLayout2) {
        super(obj, view, i);
        this.bloodPressChart = bloodPressureBarChart;
        this.ivAnim = imageView;
        this.llvalue = linearLayout;
        this.titleLayout = relativeLayout;
        this.topClock = textClock;
        this.txtAvgOxygenHigh = textView;
        this.txtAvgOxygenLow = textView2;
        this.txtHeartHigh = textView3;
        this.txtHeartLow = textView4;
        this.txtStatus = textView5;
        this.wristStatus = relativeLayout2;
    }

    public static FragmentBloodpressureNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBloodpressureNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentBloodpressureNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_bloodpressure_new, viewGroup, z, obj);
    }

    public static FragmentBloodpressureNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBloodpressureNewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentBloodpressureNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_bloodpressure_new, null, false, obj);
    }

    public static FragmentBloodpressureNewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBloodpressureNewBinding bind(View view, Object obj) {
        return (FragmentBloodpressureNewBinding) bind(obj, view, R.layout.fragment_bloodpressure_new);
    }
}
