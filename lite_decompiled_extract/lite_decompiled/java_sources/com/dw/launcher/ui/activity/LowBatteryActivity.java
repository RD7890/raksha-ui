package com.dw.launcher.ui.activity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.SysKeyEvent;
import javax.inject.Inject;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class LowBatteryActivity extends Hilt_LowBatteryActivity {
    private TextView mBatteryPercent;

    @Inject
    SysKeyEvent sysKeyEvent;
    int mlowPowerLimit = 10;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.ui.activity.LowBatteryActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                int intExtra = intent.getIntExtra("level", 0);
                int intExtra2 = intent.getIntExtra("scale", 100);
                boolean z = intent.getIntExtra("plugged", -1) != 0;
                LowBatteryActivity.this.updateBattery((intExtra * 100) / intExtra2, z);
                if (intExtra >= LowBatteryActivity.this.mlowPowerLimit || z) {
                    LowBatteryActivity.this.finish();
                }
            }
        }
    };

    public void onBackPressed() {
    }

    @Override // com.dw.launcher.ui.activity.Hilt_LowBatteryActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_bat);
        this.mBatteryPercent = (TextView) findViewById(R.id.txt_bat_val);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        registerReceiver(this.mReceiver, intentFilter);
        findViewById(R.id.txt_lowbat_back).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.LowBatteryActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m8lambda$onCreate$0$comdwlauncheruiactivityLowBatteryActivity(view);
            }
        });
        findViewById(R.id.img_lowbat_phone).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.LowBatteryActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m9lambda$onCreate$1$comdwlauncheruiactivityLowBatteryActivity(view);
            }
        });
        findViewById(R.id.img_lowbat_dhb).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.LowBatteryActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m10lambda$onCreate$2$comdwlauncheruiactivityLowBatteryActivity(view);
            }
        });
        findViewById(R.id.img_lowbat_info).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.LowBatteryActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m11lambda$onCreate$3$comdwlauncheruiactivityLowBatteryActivity(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-dw-launcher-ui-activity-LowBatteryActivity, reason: not valid java name */
    /* synthetic */ void m8lambda$onCreate$0$comdwlauncheruiactivityLowBatteryActivity(View view) {
        finish();
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-dw-launcher-ui-activity-LowBatteryActivity, reason: not valid java name */
    /* synthetic */ void m9lambda$onCreate$1$comdwlauncheruiactivityLowBatteryActivity(View view) {
        jumpToActivity("com.divo.phone", "com.divo.phone.MainActivity");
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-dw-launcher-ui-activity-LowBatteryActivity, reason: not valid java name */
    /* synthetic */ void m10lambda$onCreate$2$comdwlauncheruiactivityLowBatteryActivity(View view) {
        jumpToActivity("com.android.contacts", "com.android.contacts.activities.PeopleActivity");
    }

    /* JADX INFO: renamed from: lambda$onCreate$3$com-dw-launcher-ui-activity-LowBatteryActivity, reason: not valid java name */
    /* synthetic */ void m11lambda$onCreate$3$comdwlauncheruiactivityLowBatteryActivity(View view) {
        jumpToActivity("com.android.messaging", "com.android.messaging.ui.conversationlist.ConversationListActivity");
    }

    private void jumpToActivity(String packageName, String className) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, className));
        intent.addFlags(270532608);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBattery(int batteryLevel, boolean isCharge) {
        if (this.mBatteryPercent != null) {
            this.mBatteryPercent.setText(batteryLevel + "%");
        }
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (this.sysKeyEvent.getSingleKeyCode() == keyCode) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override // com.dw.launcher.ui.activity.Hilt_LowBatteryActivity
    protected void onDestroy() {
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        finish();
    }
}
