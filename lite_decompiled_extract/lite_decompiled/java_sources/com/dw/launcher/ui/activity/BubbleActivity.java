package com.dw.launcher.ui.activity;

import android.os.Bundle;
import android.provider.Settings;
import com.dw.launcher.R;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class BubbleActivity extends SwitchBaseActivity {
    public static final String BUBBLE_KEY = "support_dial_bubble";

    @Override // com.dw.launcher.ui.activity.SwitchBaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        this.titleStr = getResources().getString(R.string.bubble_activity_title);
        this.switchStr = getResources().getString(R.string.bubble_switch_title);
        this.tipStr = getResources().getString(R.string.bubble_enable_label);
        this.isCheck = Settings.Global.getInt(getContentResolver(), BUBBLE_KEY, 0) == 1;
        super.onCreate(savedInstanceState);
    }

    @Override // com.dw.launcher.ui.activity.SwitchBaseActivity
    public void switchState(boolean z) {
        super.switchState(z);
        Settings.Global.putInt(getContentResolver(), BUBBLE_KEY, z ? 1 : 0);
    }
}
