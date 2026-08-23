package com.dw.launcher.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.dw.launcher.R;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.util.DwUtils;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.inject.Inject;
import timber.log.Timber;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public class ChargeActivity extends Hilt_ChargeActivity implements NoDisturbComponent.OnNoDisturbComponentListener {
    private static final int HANDLER_ACTION_FINISH = 1003;
    private static final int HANDLER_ACTION_HIDE_FORBIDDEN = 1002;
    private static final int HANDLER_ACTION_SHOW_FORBIDDEN = 1001;
    private static final String SETTING_KEY_CHARGE_ENABLE_PLAY_SOUND = "charging_sounds_enabled";
    public static final String SETTING_KEY_CHARGE_MODE = "charge_disabled";

    @Inject
    LauncherRepository mAssetsLaunchRepository;
    private TextView mBatteryPercent;
    private ImageView mForbidden;
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.dw.launcher.activity.ChargeActivity$$ExternalSyntheticLambda0
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f$0.m184lambda$new$0$comdwlauncheractivityChargeActivity(message);
        }
    });
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.activity.ChargeActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                ChargeActivity.this.updateTime();
                return;
            }
            int intExtra = intent.getIntExtra("level", 0);
            int intExtra2 = intent.getIntExtra("scale", 100);
            ChargeActivity.this.updateBattery((intExtra * 100) / intExtra2, intent.getIntExtra("plugged", -1) != 0);
        }
    };
    private TextView mTime;
    private TextView mTips;
    private MediaPlayer mediaPlayer;

    @Inject
    NoDisturbComponent noDisturbComponent;

    @Inject
    SysKeyEvent sysKeyEvent;

    /* JADX INFO: renamed from: lambda$new$0$com-dw-launcher-activity-ChargeActivity, reason: not valid java name */
    /* synthetic */ boolean m184lambda$new$0$comdwlauncheractivityChargeActivity(Message message) {
        switch (message.what) {
            case 1001:
                showForbidden();
                break;
            case 1002:
                hideForbidden();
                break;
            case 1003:
                finish();
                break;
        }
        return false;
    }

    @Override // com.dw.launcher.activity.Hilt_ChargeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(4718592);
        setContentView(R.layout.activity_charge);
        Timber.d("进入充电...", new Object[0]);
        initView();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        registerReceiver(this.mReceiver, intentFilter);
        updateTime();
        DwUtils.updateStatusBar(this, 65536);
        this.mTips.setText(R.string.charge_mode);
        playChargeSound();
        this.noDisturbComponent.addListener(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (isChargeForbidden()) {
            setEnterChargeForbidden();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        exitChargeForbidden();
    }

    private void playChargeSound() {
        Log.i("lkang", "playChargeSound");
        if (Settings.Global.getInt(getContentResolver(), SETTING_KEY_CHARGE_ENABLE_PLAY_SOUND, 1) == 0 || Settings.Global.getInt(getContentResolver(), NoDisturbActivity.SETTING_KEY_SILENT_MODE, 0) == 1 || ((AudioManager) getSystemService("audio")).getRingerMode() == 0) {
            return;
        }
        if (!TextUtils.isEmpty(this.mAssetsLaunchRepository.loadConfig().getChargeRingPath())) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            try {
                mediaPlayer.setDataSource(this.mAssetsLaunchRepository.loadConfig().getChargeRingPath());
                this.mediaPlayer.prepare();
                this.mediaPlayer.start();
                return;
            } catch (IOException unused) {
                Timber.d("播放错误...", new Object[0]);
                MediaPlayer mediaPlayerCreate = MediaPlayer.create(this, R.raw.charge_tips);
                this.mediaPlayer = mediaPlayerCreate;
                mediaPlayerCreate.start();
                return;
            }
        }
        MediaPlayer mediaPlayerCreate2 = MediaPlayer.create(this, R.raw.charge_tips);
        this.mediaPlayer = mediaPlayerCreate2;
        mediaPlayerCreate2.start();
    }

    private void setEnterChargeForbidden() {
        Settings.Global.putInt(getContentResolver(), "charge_disabled_mode", 1);
    }

    private void exitChargeForbidden() {
        Settings.Global.putInt(getContentResolver(), "charge_disabled_mode", 0);
    }

    private boolean isChargeForbidden() {
        return Settings.Global.getInt(getContentResolver(), SETTING_KEY_CHARGE_MODE, 0) == 1;
    }

    private void initView() {
        this.mForbidden = (ImageView) findViewById(R.id.charge_forbidden);
        this.mBatteryPercent = (TextView) findViewById(R.id.battery_percent);
        this.mTime = (TextView) findViewById(R.id.time);
        this.mTips = (TextView) findViewById(R.id.charge_tips);
        Glide.with((FragmentActivity) this).asGif().load(Integer.valueOf(R.drawable.icon_charge_hight)).into((ImageView) findViewById(R.id.charge_bg));
    }

    private void showForbidden() {
        this.mForbidden.setVisibility(0);
        this.mHandler.sendEmptyMessageDelayed(1002, 3000L);
    }

    private void hideForbidden() {
        this.mForbidden.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTime() {
        SimpleDateFormat simpleDateFormat;
        Calendar calendar = Calendar.getInstance();
        if (is24Hour()) {
            simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        } else {
            simpleDateFormat = new SimpleDateFormat("hh:mm", Locale.getDefault());
        }
        this.mTime.setText(simpleDateFormat.format(Long.valueOf(calendar.getTimeInMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBattery(int batteryLevel, boolean isCharge) {
        if (isCharge) {
            if (this.mBatteryPercent != null) {
                this.mBatteryPercent.setText(batteryLevel + "%");
                if (batteryLevel == 100) {
                    this.mTips.setText(getString(R.string.charge_finish));
                    return;
                }
                return;
            }
            return;
        }
        finish();
    }

    private boolean is24Hour() {
        return DateFormat.is24HourFormat(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (isChargeForbidden()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (this.sysKeyEvent.getSingleKeyCode() == keyCode && isChargeForbidden()) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override // com.dw.launcher.activity.Hilt_ChargeActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mediaPlayer.release();
        }
        DwUtils.updateStatusBar(this, 0);
        this.noDisturbComponent.removeListener(this);
        Timber.d("执行onDestroy...", new Object[0]);
    }

    @Override // com.dw.launcher.data.component.NoDisturbComponent.OnNoDisturbComponentListener
    public void onNoDisturbChanged(int status) {
        if (status == 1) {
            Timber.d("监听到上课禁用...", new Object[0]);
            sendBroadcast(new Intent("com.dwiot.exit.nodisturb"));
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        finish();
    }
}
