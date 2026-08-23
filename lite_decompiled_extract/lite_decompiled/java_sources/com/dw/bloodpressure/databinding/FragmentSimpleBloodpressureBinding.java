package com.dw.bloodpressure.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dw.bloodpressure.BloodPressChart;
import com.dw.bloodpressure.R;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public abstract class FragmentSimpleBloodpressureBinding extends ViewDataBinding {
    public final BloodPressChart bloodPressChart;
    public final ImageView ivAnim;
    public final RelativeLayout titleLayout;
    public final TextClock topClock;
    public final TextView txtAvgOxygenHigh;
    public final TextView txtAvgOxygenLow;
    public final TextView txtHeartHigh;
    public final TextView txtHeartLow;
    public final TextView txtMaxOxygen;
    public final TextView txtMinOxygen;
    public final TextView txtStatus;
    public final TextView txtUnit;
    public final RelativeLayout wristStatus;

    protected FragmentSimpleBloodpressureBinding(Object obj, View view, int i, BloodPressChart bloodPressChart, ImageView imageView, RelativeLayout relativeLayout, TextClock textClock, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, RelativeLayout relativeLayout2) {
        super(obj, view, i);
        this.bloodPressChart = bloodPressChart;
        this.ivAnim = imageView;
        this.titleLayout = relativeLayout;
        this.topClock = textClock;
        this.txtAvgOxygenHigh = textView;
        this.txtAvgOxygenLow = textView2;
        this.txtHeartHigh = textView3;
        this.txtHeartLow = textView4;
        this.txtMaxOxygen = textView5;
        this.txtMinOxygen = textView6;
        this.txtStatus = textView7;
        this.txtUnit = textView8;
        this.wristStatus = relativeLayout2;
    }

    public static FragmentSimpleBloodpressureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSimpleBloodpressureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSimpleBloodpressureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_simple_bloodpressure, viewGroup, z, obj);
    }

    public static FragmentSimpleBloodpressureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSimpleBloodpressureBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSimpleBloodpressureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_simple_bloodpressure, null, false, obj);
    }

    public static FragmentSimpleBloodpressureBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSimpleBloodpressureBinding bind(View view, Object obj) {
        return (FragmentSimpleBloodpressureBinding) bind(obj, view, R.layout.fragment_simple_bloodpressure);
    }
}
