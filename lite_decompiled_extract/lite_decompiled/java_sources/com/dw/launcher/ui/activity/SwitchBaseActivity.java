package com.dw.launcher.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.dw.launcher.R;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class SwitchBaseActivity extends Activity implements View.OnClickListener {
    public LinearLayout mStateLayout;
    public TextView mStateText;
    public Switch mSwitchImg;
    public TextView mSwtichText;
    public TextView mTipText;
    public TextView mTitleText;
    public boolean isCheck = false;
    public String titleStr = "";
    public String switchStr = "";
    public String stateOnStr = "";
    public String stateOffStr = "";
    public String tipStr = "";
    private boolean isRoundWatch = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.isRoundWatch = getResources().getConfiguration().isScreenRound();
        setContentView(R.layout.activity_switch);
        init();
    }

    private void init() {
        this.mTitleText = (TextView) findViewById(R.id.switch_title);
        this.mSwtichText = (TextView) findViewById(R.id.switch_state_label);
        this.mStateLayout = (LinearLayout) findViewById(R.id.switch_state_layout);
        this.mStateText = (TextView) findViewById(R.id.switch_state_text);
        this.mSwitchImg = (Switch) findViewById(R.id.switchFloat);
        this.mTipText = (TextView) findViewById(R.id.switch_tip);
        this.mSwitchImg.setOnClickListener(this);
        switchState(this.isCheck);
        this.mTitleText.setText(this.titleStr);
        this.mSwtichText.setText(this.switchStr);
        if (TextUtils.isEmpty(this.switchStr)) {
            this.mSwtichText.setVisibility(8);
        }
        this.mTipText.setText(this.tipStr);
    }

    public void switchState(boolean state) {
        this.mSwitchImg.setChecked(state);
        this.isCheck = state;
        this.mStateText.setText(state ? this.stateOnStr : this.stateOffStr);
        if (TextUtils.isEmpty(this.stateOnStr) || TextUtils.isEmpty(this.stateOffStr)) {
            this.mStateText.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switchState(!this.isCheck);
    }
}
