package com.dw.launcher.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import com.dw.launcher.R;
import com.dw.launcher.data.component.BrightComponent;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class LightAdjustDialog extends Dialog {
    private static final long DISMISS_TIMEOUT = 3000;
    private Runnable dismissRunnable;
    private Handler handler;
    private BrightComponent mBrightComponent;

    public LightAdjustDialog(Context context, BrightComponent brightComponent) {
        super(context);
        this.handler = new Handler();
        this.dismissRunnable = new Runnable() { // from class: com.dw.launcher.ui.view.LightAdjustDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.dismiss();
            }
        };
        this.mBrightComponent = brightComponent;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_light_adjust);
        setupDialogAttributes();
        setupLightSeekBar();
        startDismissTimer();
    }

    private void setupDialogAttributes() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            attributes.width = -1;
            window.setAttributes(attributes);
        }
        setCanceledOnTouchOutside(true);
    }

    private void setupLightSeekBar() {
        ScrollableSeekBar scrollableSeekBar = (ScrollableSeekBar) findViewById(R.id.light_seekbar);
        scrollableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.dw.launcher.ui.view.LightAdjustDialog.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    LightAdjustDialog.this.mBrightComponent.setBrightnessLevel(progress, (Window) null);
                    LightAdjustDialog.this.resetDismissTimer();
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                LightAdjustDialog.this.resetDismissTimer();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                LightAdjustDialog.this.resetDismissTimer();
            }
        });
        Integer numValueOf = Integer.valueOf(this.mBrightComponent.getBrightness());
        if (numValueOf != null) {
            scrollableSeekBar.setProgress(numValueOf.intValue());
        }
    }

    private void startDismissTimer() {
        this.handler.postDelayed(this.dismissRunnable, DISMISS_TIMEOUT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetDismissTimer() {
        this.handler.removeCallbacks(this.dismissRunnable);
        this.handler.postDelayed(this.dismissRunnable, DISMISS_TIMEOUT);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 4) {
            dismiss();
            return true;
        }
        resetDismissTimer();
        return super.onTouchEvent(event);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.handler.removeCallbacks(this.dismissRunnable);
        super.dismiss();
    }
}
