package com.dw.launcher.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dw.launcher.R;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public abstract class ActivityNoDisturbBinding extends ViewDataBinding {
    public final TextView txtBattery;
    public final TextView txtDate;
    public final TextView txtTime;
    public final TextView txtTimeMode;
    public final TextView txtWeek;

    protected ActivityNoDisturbBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView txtBattery, TextView txtDate, TextView txtTime, TextView txtTimeMode, TextView txtWeek) {
        super(_bindingComponent, _root, _localFieldCount);
        this.txtBattery = txtBattery;
        this.txtDate = txtDate;
        this.txtTime = txtTime;
        this.txtTimeMode = txtTimeMode;
        this.txtWeek = txtWeek;
    }

    public static ActivityNoDisturbBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNoDisturbBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityNoDisturbBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_no_disturb, root, attachToRoot, component);
    }

    public static ActivityNoDisturbBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNoDisturbBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityNoDisturbBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_no_disturb, null, false, component);
    }

    public static ActivityNoDisturbBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNoDisturbBinding bind(View view, Object component) {
        return (ActivityNoDisturbBinding) bind(component, view, R.layout.activity_no_disturb);
    }
}
