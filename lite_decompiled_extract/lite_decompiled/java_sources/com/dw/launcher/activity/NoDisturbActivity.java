package com.dw.launcher.activity;

import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.KeyEvent;
import androidx.databinding.DataBindingUtil;
import com.dw.launcher.R;
import com.dw.launcher.data.component.BatteryComponent;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.databinding.ActivityNoDisturbBinding;
import com.dw.launcher.util.SystemUtils;
import java.util.Calendar;
import javax.inject.Inject;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public class NoDisturbActivity extends Hilt_NoDisturbActivity {
    public static final String SETTING_KEY_APP_LOCK = "applock";
    public static final String SETTING_KEY_SILENT_MODE = "no_disturb";
    public static boolean isNoDisturb = false;

    @Inject
    BatteryComponent batteryComponent;
    ActivityNoDisturbBinding binding;
    boolean is24TimeClock;
    boolean isZh;

    @Inject
    SysKeyEvent sysKeyEvent;
    private Handler mHandler = new Handler();
    private Runnable mExitRunnable = new AnonymousClass1();

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: renamed from: com.dw.launcher.activity.NoDisturbActivity$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = Settings.Global.getInt(NoDisturbActivity.this.getContentResolver(), NoDisturbActivity.SETTING_KEY_SILENT_MODE, 0);
            NoDisturbActivity.this.runOnUiThread(new Runnable() { // from class: com.dw.launcher.activity.NoDisturbActivity$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m187lambda$run$0$comdwlauncheractivityNoDisturbActivity$1();
                }
            });
            if (i > 0) {
                NoDisturbActivity.this.mHandler.postDelayed(this, 1000L);
            } else {
                NoDisturbActivity.this.finish();
            }
        }

        /* JADX INFO: renamed from: lambda$run$0$com-dw-launcher-activity-NoDisturbActivity$1, reason: not valid java name */
        /* synthetic */ void m187lambda$run$0$comdwlauncheractivityNoDisturbActivity$1() {
            NoDisturbActivity.this.update();
        }
    }

    @Override // com.dw.launcher.activity.Hilt_NoDisturbActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(524288);
        this.binding = (ActivityNoDisturbBinding) DataBindingUtil.setContentView(this, R.layout.activity_no_disturb);
        isNoDisturb = true;
        this.isZh = SystemUtils.INSTANCE.getLanguage(getApplicationContext()).contains("zh");
        this.is24TimeClock = DateFormat.is24HourFormat(getApplicationContext());
        update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(11);
        int i2 = calendar.get(12);
        this.binding.txtTime.setText(String.format("%02d:%02d", Integer.valueOf(i), Integer.valueOf(i2)));
        if (i >= 12) {
            this.binding.txtTimeMode.setText("PM");
        } else {
            this.binding.txtTimeMode.setText("AM");
        }
        if (!this.is24TimeClock) {
            int i3 = calendar.get(10);
            this.binding.txtTime.setText(String.format("%02d:%02d", Integer.valueOf(i3 != 0 ? i3 : 12), Integer.valueOf(i2)));
        }
        String.format("%02d/%02d", Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
        this.binding.txtDate.setText(DateUtils.formatDateTime(getApplicationContext(), calendar.getTimeInMillis(), 65552));
        calendar.get(7);
        this.binding.txtWeek.setText(DateUtils.formatDateTime(getApplicationContext(), calendar.getTimeInMillis(), 32770));
        this.binding.txtBattery.setText(this.batteryComponent.getMBatteryLevel() + "%");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mHandler.postDelayed(this.mExitRunnable, 1000L);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == this.sysKeyEvent.getSingleKeyCode()) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override // com.dw.launcher.activity.Hilt_NoDisturbActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        isNoDisturb = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        finish();
    }
}
