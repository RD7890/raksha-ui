package com.dw.launcher.ui.dashboard;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public abstract class Hilt_HoneycombDashboard extends BaseDashboard {
    private ContextWrapper componentContext;
    private boolean disableGetContextFix;
    private boolean injected = false;

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard, com.dw.launcher.ui.dashboard.Hilt_BaseDashboard
    public void onAttach(Context context) {
        super.onAttach(context);
        initializeComponentContext();
        inject();
    }

    @Override // com.dw.launcher.ui.dashboard.Hilt_BaseDashboard
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ContextWrapper contextWrapper = this.componentContext;
        Preconditions.checkState(contextWrapper == null || FragmentComponentManager.findActivity(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        initializeComponentContext();
        inject();
    }

    private void initializeComponentContext() {
        if (this.componentContext == null) {
            this.componentContext = FragmentComponentManager.createContextWrapper(super.getContext(), (Fragment) this);
            this.disableGetContextFix = FragmentGetContextFix.isFragmentGetContextFixDisabled(super.getContext());
        }
    }

    @Override // com.dw.launcher.ui.dashboard.Hilt_BaseDashboard
    public Context getContext() {
        if (super.getContext() == null && !this.disableGetContextFix) {
            return null;
        }
        initializeComponentContext();
        return this.componentContext;
    }

    @Override // com.dw.launcher.ui.dashboard.Hilt_BaseDashboard
    public LayoutInflater onGetLayoutInflater(Bundle savedInstanceState) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = super.onGetLayoutInflater(savedInstanceState);
        return layoutInflaterOnGetLayoutInflater.cloneInContext(FragmentComponentManager.createContextWrapper(layoutInflaterOnGetLayoutInflater, (Fragment) this));
    }

    @Override // com.dw.launcher.ui.dashboard.Hilt_BaseDashboard
    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((HoneycombDashboard_GeneratedInjector) ((GeneratedComponentManagerHolder) UnsafeCasts.unsafeCast(this)).generatedComponent()).injectHoneycombDashboard((HoneycombDashboard) UnsafeCasts.unsafeCast(this));
    }
}
