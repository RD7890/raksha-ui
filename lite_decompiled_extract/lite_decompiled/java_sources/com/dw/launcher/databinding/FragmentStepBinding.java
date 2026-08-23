package com.dw.launcher.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dw.launcher.R;
import com.dwiot.dwstep.databinding.FragmentStepNewBinding;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public abstract class FragmentStepBinding extends ViewDataBinding {
    public final FragmentStepNewBinding parent;

    protected FragmentStepBinding(Object _bindingComponent, View _root, int _localFieldCount, FragmentStepNewBinding parent) {
        super(_bindingComponent, _root, _localFieldCount);
        this.parent = parent;
    }

    public static FragmentStepBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStepBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentStepBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_step, root, attachToRoot, component);
    }

    public static FragmentStepBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStepBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentStepBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_step, null, false, component);
    }

    public static FragmentStepBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStepBinding bind(View view, Object component) {
        return (FragmentStepBinding) bind(component, view, R.layout.fragment_step);
    }
}
