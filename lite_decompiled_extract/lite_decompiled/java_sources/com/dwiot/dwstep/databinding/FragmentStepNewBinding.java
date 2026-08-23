package com.dwiot.dwstep.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dwiot.dwstep.R;
import com.dwiot.dwstep.view.ArcProgressView;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public abstract class FragmentStepNewBinding extends ViewDataBinding {
    public final ArcProgressView activeProgressCircle;
    public final TextClock topClock;

    protected FragmentStepNewBinding(Object obj, View view, int i, ArcProgressView arcProgressView, TextClock textClock) {
        super(obj, view, i);
        this.activeProgressCircle = arcProgressView;
        this.topClock = textClock;
    }

    public static FragmentStepNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStepNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentStepNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_step_new, viewGroup, z, obj);
    }

    public static FragmentStepNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStepNewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentStepNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_step_new, (ViewGroup) null, false, obj);
    }

    public static FragmentStepNewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStepNewBinding bind(View view, Object obj) {
        return (FragmentStepNewBinding) bind(obj, view, R.layout.fragment_step_new);
    }
}
