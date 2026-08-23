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

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public abstract class FragmentSimpleStepBinding extends ViewDataBinding {
    public final ActiveProgressCircle activeProgressCircle;
    public final TextClock topClock;
    public final TextView txtCalories;
    public final TextView txtDistance;
    public final TextView txtStep;
    public final View view;

    protected FragmentSimpleStepBinding(Object obj, View view, int i, ActiveProgressCircle activeProgressCircle, TextClock textClock, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(obj, view, i);
        this.activeProgressCircle = activeProgressCircle;
        this.topClock = textClock;
        this.txtCalories = textView;
        this.txtDistance = textView2;
        this.txtStep = textView3;
        this.view = view2;
    }

    public static FragmentSimpleStepBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSimpleStepBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSimpleStepBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_simple_step, viewGroup, z, obj);
    }

    public static FragmentSimpleStepBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSimpleStepBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSimpleStepBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_simple_step, (ViewGroup) null, false, obj);
    }

    public static FragmentSimpleStepBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSimpleStepBinding bind(View view, Object obj) {
        return (FragmentSimpleStepBinding) bind(obj, view, R.layout.fragment_simple_step);
    }
}
