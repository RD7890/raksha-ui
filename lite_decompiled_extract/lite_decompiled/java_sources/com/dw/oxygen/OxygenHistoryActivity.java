package com.dw.oxygen;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class OxygenHistoryActivity extends Activity {
    private AnimationDrawable anim;
    private OxygenChart heartDayChart;
    private SensorManager mSensorManager;
    private TextView txtAvgOxygen;
    private TextView txtHeart;
    private RelativeLayout wrist_status;
    private int default_duration = 60000;
    List<Integer> deepList = new ArrayList();
    List<Integer> posList = new ArrayList();
    private SensorEventListener mDataListener = new SensorEventListener() { // from class: com.dw.oxygen.OxygenHistoryActivity.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent == null || sensorEvent.values == null || sensorEvent.values.length <= 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sensorEvent.values.length; i++) {
                sb.append("values[" + i + "] = " + sensorEvent.values[i] + "    ");
            }
            Log.i("lkang", sb.toString());
            if (((int) sensorEvent.values[0]) == 0) {
                OxygenHistoryActivity.this.wrist_status.setVisibility(0);
                if (OxygenHistoryActivity.this.anim.isRunning()) {
                    OxygenHistoryActivity.this.anim.stop();
                    return;
                }
                return;
            }
            OxygenHistoryActivity.this.wrist_status.setVisibility(8);
            float f = sensorEvent.values[1];
            if (!OxygenHistoryActivity.this.anim.isRunning()) {
                OxygenHistoryActivity.this.anim.start();
            }
            if (f <= 0.0f) {
                return;
            }
            OxygenHistoryActivity.this.setHeartValue((int) f);
            OxygenHistoryActivity.this.calculatAvg();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_oxygen_history);
        this.heartDayChart = (OxygenChart) findViewById(R.id.heartChart);
        this.wrist_status = (RelativeLayout) findViewById(R.id.wrist_status);
        ImageView imageView = (ImageView) findViewById(R.id.ivAnim);
        TextClock textClock = (TextClock) findViewById(R.id.top_clock);
        this.txtHeart = (TextView) findViewById(R.id.txtHeart);
        this.txtAvgOxygen = (TextView) findViewById(R.id.txtAvgOxygen);
        if (textClock.is24HourModeEnabled()) {
            textClock.setFormat12Hour("HH:mm");
        } else {
            textClock.setFormat12Hour("hh:mm");
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) getDrawable(R.drawable.oxygen_measureing);
        this.anim = animationDrawable;
        imageView.setBackground(animationDrawable);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        start();
    }

    private void start() {
        this.anim.start();
        try {
            SensorManager sensorManager = (SensorManager) getSystemService("sensor");
            this.mSensorManager = sensorManager;
            Sensor defaultSensor = sensorManager.getDefaultSensor(65596);
            getWindow().addFlags(128);
            this.mSensorManager.registerListener(this.mDataListener, defaultSensor, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeartValue(int i) {
        if (i > 0) {
            this.txtHeart.setText(i + "");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            this.posList.add(Integer.valueOf(calendar.get(11)));
            this.deepList.add(Integer.valueOf(i));
            this.heartDayChart.setDailyList(this.deepList, this.posList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculatAvg() {
        int iIntValue = 0;
        for (int i = 0; i < this.deepList.size(); i++) {
            iIntValue += this.deepList.get(i).intValue();
        }
        this.txtAvgOxygen.setText((iIntValue / this.deepList.size()) + "");
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mSensorManager.unregisterListener(this.mDataListener);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
