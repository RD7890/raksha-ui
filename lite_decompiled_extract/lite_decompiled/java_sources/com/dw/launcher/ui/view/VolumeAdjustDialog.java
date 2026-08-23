package com.dw.launcher.ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import com.dw.launcher.R;
import com.dw.launcher.core.component.VoiceComponent;
import timber.log.Timber;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class VolumeAdjustDialog extends Dialog {
    private static final long DISMISS_TIMEOUT = 3000;
    Context context;
    private Runnable dismissRunnable;
    private Handler handler;
    VoiceComponent mVoiceComponent;

    public VolumeAdjustDialog(Activity context, VoiceComponent voiceComponent) {
        super(context);
        this.handler = new Handler();
        this.dismissRunnable = new Runnable() { // from class: com.dw.launcher.ui.view.VolumeAdjustDialog$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.dismiss();
            }
        };
        this.context = context;
        this.mVoiceComponent = voiceComponent;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_volumn);
        setupDialogAttributes();
        setupVolumeSeekBar();
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

    private void setupVolumeSeekBar() {
        final ScrollableSeekBar scrollableSeekBar = (ScrollableSeekBar) findViewById(R.id.voice_seekbar);
        Integer maxVolume = this.mVoiceComponent.getMaxVolume();
        if (maxVolume != null) {
            scrollableSeekBar.setMax(maxVolume.intValue());
        }
        scrollableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.dw.launcher.ui.view.VolumeAdjustDialog.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Timber.d("fromUser: " + fromUser + " progress: " + progress, new Object[0]);
                if (fromUser) {
                    VolumeAdjustDialog.this.mVoiceComponent.setVolume(progress);
                    VolumeAdjustDialog.this.resetDismissTimer();
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VolumeAdjustDialog.this.resetDismissTimer();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VolumeAdjustDialog.this.resetDismissTimer();
            }
        });
        Integer currVolume = this.mVoiceComponent.getCurrVolume();
        if (currVolume != null) {
            scrollableSeekBar.setProgress(currVolume.intValue());
        }
        this.mVoiceComponent.setOnVolumnListener(new VoiceComponent.OnVolumnListener() { // from class: com.dw.launcher.ui.view.VolumeAdjustDialog$$ExternalSyntheticLambda0
            public final void onVolumnChanged(int i) {
                scrollableSeekBar.setProgress(i);
            }
        });
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
