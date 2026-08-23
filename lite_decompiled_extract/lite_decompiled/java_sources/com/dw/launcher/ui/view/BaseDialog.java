package com.dw.launcher.ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import com.dw.launcher.R;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public abstract class BaseDialog extends Dialog {
    public Activity activity;
    private DialogListener dialogListener;
    private int gravity;
    protected boolean isAnimating;
    private boolean isMatchHeight;
    private float screenHeight;
    private float screenWidth;
    private float widthFactor;

    public interface DialogListener {
        void onDismiss(boolean isShown);

        void show(boolean isShown);
    }

    private float calculateScale(float start, float end, float progress) {
        return (progress - start) / (end - start);
    }

    private float calculateTranslation(float start, float end, float progress) {
        return ((end - start) * progress) + start;
    }

    public void adjustAlpha(float alpha) {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
    }

    protected abstract int getLayoutId();

    public void handleEvent(int i, long l, float[] floats) {
    }

    protected abstract void initialize();

    public BaseDialog(Activity context) {
        super(context, R.style.myDialogFullNo);
        this.widthFactor = 1.0f;
        this.gravity = 17;
        this.activity = context;
    }

    public BaseDialog(Activity context, float widthF, boolean isMatchHeight) {
        super(context, R.style.myDialogFullNo);
        this.gravity = 17;
        this.activity = context;
        this.widthFactor = widthF;
        this.isMatchHeight = isMatchHeight;
    }

    public BaseDialog(Context context, float widthF, boolean isMatchHeight) {
        super(context, R.style.myDialogFullNo);
        this.gravity = 17;
        this.widthFactor = widthF;
        this.isMatchHeight = isMatchHeight;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.screenHeight = displayMetrics.heightPixels;
        this.screenWidth = displayMetrics.widthPixels;
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        setCancelable(false);
        initialize();
        if (getWindow() != null) {
            Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = (int) (defaultDisplay.getWidth() * this.widthFactor);
            if (this.isMatchHeight) {
                attributes.height = defaultDisplay.getHeight();
            }
            attributes.alpha = 1.0f;
            getWindow().setAttributes(attributes);
            getWindow().setGravity(this.gravity);
        }
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setDimAmount(0.0f);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            dismiss();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void setDialogListener(DialogListener dialogListener) {
        this.dialogListener = dialogListener;
    }
}
