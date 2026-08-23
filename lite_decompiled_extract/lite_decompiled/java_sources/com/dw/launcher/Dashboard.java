package com.dw.launcher;

import android.content.Intent;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;

/* JADX INFO: compiled from: Dashboard.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/dw/launcher/Dashboard;", "Lcom/dw/launcher/base/BaseActivity;", "()V", "getLayoutId", cn.carbswang.android.numberpickerview.library.BuildConfig.FLAVOR, "onBackPressed", cn.carbswang.android.numberpickerview.library.BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class Dashboard extends Hilt_Dashboard {
    @Override // com.dw.launcher.base.BaseActivity
    public int getLayoutId() {
        return R.layout.activity_dashboard;
    }

    @Override // com.dw.launcher.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        startActivity(new Intent(this, (Class<?>) Launcher.class));
    }
}
