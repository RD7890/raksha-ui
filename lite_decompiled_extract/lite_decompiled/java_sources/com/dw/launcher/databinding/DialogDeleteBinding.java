package com.dw.launcher.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dw.launcher.R;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public abstract class DialogDeleteBinding extends ViewDataBinding {
    public final TextView tvDelete;
    public final TextView tvName;

    protected DialogDeleteBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView tvDelete, TextView tvName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.tvDelete = tvDelete;
        this.tvName = tvName;
    }

    public static DialogDeleteBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogDeleteBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogDeleteBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_delete, root, attachToRoot, component);
    }

    public static DialogDeleteBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogDeleteBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogDeleteBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_delete, null, false, component);
    }

    public static DialogDeleteBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogDeleteBinding bind(View view, Object component) {
        return (DialogDeleteBinding) bind(component, view, R.layout.dialog_delete);
    }
}
