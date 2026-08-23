package com.dw.launcher.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Property;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.BreatheSharedPreferencesUtils;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BreatheActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001/\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u001eJ\b\u0010;\u001a\u000207H\u0002J\u000e\u0010<\u001a\u0002072\u0006\u00108\u001a\u000209J\b\u0010=\u001a\u00020\bH\u0016J\u0012\u0010>\u001a\u0002072\b\u0010?\u001a\u0004\u0018\u00010@H\u0014J\b\u0010A\u001a\u000207H\u0014J\u0018\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u000207H\u0014J\b\u0010G\u001a\u000207H\u0014J \u0010H\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082D¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001eX\u0082D¢\u0006\u0002\n\u0000R\u0018\u00104\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001eX\u0082D¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/dw/launcher/ui/activity/BreatheActivity;", "Lcom/dw/launcher/base/BaseActivity;", "()V", "animator", "Landroid/animation/AnimatorSet;", "countDownTimer", "Landroid/os/CountDownTimer;", "currentMode", "", "handler", "Landroid/os/Handler;", "isEnd", "", "ivBreathe", "Landroid/widget/ImageView;", "getIvBreathe", "()Landroid/widget/ImageView;", "setIvBreathe", "(Landroid/widget/ImageView;)V", "scaleValue", "", "getScaleValue", "()F", "sharedPreferences", "Lcom/dw/launcher/data/preference/BreatheSharedPreferencesUtils;", "getSharedPreferences", "()Lcom/dw/launcher/data/preference/BreatheSharedPreferencesUtils;", "setSharedPreferences", "(Lcom/dw/launcher/data/preference/BreatheSharedPreferencesUtils;)V", "strongVibrationDuration", "", "strongVibrationEffect", "Landroid/os/VibrationEffect;", "kotlin.jvm.PlatformType", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "txtState", "Landroid/widget/TextView;", "getTxtState", "()Landroid/widget/TextView;", "setTxtState", "(Landroid/widget/TextView;)V", "vibrationRunnable", "com/dw/launcher/ui/activity/BreatheActivity$vibrationRunnable$1", "Lcom/dw/launcher/ui/activity/BreatheActivity$vibrationRunnable$1;", "vibrator", "Landroid/os/Vibrator;", "weakVibrationDuration", "weakVibrationEffect", "weakVibrationInterval", "breatheAnimation", "", "view", "Landroid/view/View;", "duration", "cancel", "endLoopAnimation", "getLayoutId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onUserLeaveHint", "reverseAnimation", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class BreatheActivity extends Hilt_BreatheActivity {
    private AnimatorSet animator;
    private CountDownTimer countDownTimer;
    private int currentMode;
    private boolean isEnd;
    public ImageView ivBreathe;

    @Inject
    public BreatheSharedPreferencesUtils sharedPreferences;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private TextView txtState;
    private Vibrator vibrator;
    private final long strongVibrationDuration = 300;
    private final long weakVibrationDuration = 100;
    private final long weakVibrationInterval = 1000;
    private final VibrationEffect strongVibrationEffect = VibrationEffect.createOneShot(300, -1);
    private final VibrationEffect weakVibrationEffect = VibrationEffect.createOneShot(100, -1);
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final BreatheActivity$vibrationRunnable$1 vibrationRunnable = new Runnable() { // from class: com.dw.launcher.ui.activity.BreatheActivity$vibrationRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            int i = this.this$0.currentMode;
            Vibrator vibrator = null;
            if (i == 0) {
                Vibrator vibrator2 = this.this$0.vibrator;
                if (vibrator2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vibrator");
                } else {
                    vibrator = vibrator2;
                }
                vibrator.vibrate(this.this$0.weakVibrationEffect);
                this.this$0.handler.postDelayed(this, this.this$0.weakVibrationInterval);
                return;
            }
            if (i != 1) {
                return;
            }
            Vibrator vibrator3 = this.this$0.vibrator;
            if (vibrator3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vibrator");
            } else {
                vibrator = vibrator3;
            }
            vibrator.vibrate(this.this$0.strongVibrationEffect);
            this.this$0.handler.post(this);
        }
    };
    private final float scaleValue = 0.3f;

    public final BreatheSharedPreferencesUtils getSharedPreferences() {
        BreatheSharedPreferencesUtils breatheSharedPreferencesUtils = this.sharedPreferences;
        if (breatheSharedPreferencesUtils != null) {
            return breatheSharedPreferencesUtils;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        return null;
    }

    public final void setSharedPreferences(BreatheSharedPreferencesUtils breatheSharedPreferencesUtils) {
        Intrinsics.checkNotNullParameter(breatheSharedPreferencesUtils, "<set-?>");
        this.sharedPreferences = breatheSharedPreferencesUtils;
    }

    public final ImageView getIvBreathe() {
        ImageView imageView = this.ivBreathe;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivBreathe");
        return null;
    }

    public final void setIvBreathe(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivBreathe = imageView;
    }

    public final SysKeyEvent getSysKeyEvent() {
        SysKeyEvent sysKeyEvent = this.sysKeyEvent;
        if (sysKeyEvent != null) {
            return sysKeyEvent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sysKeyEvent");
        return null;
    }

    public final void setSysKeyEvent(SysKeyEvent sysKeyEvent) {
        Intrinsics.checkNotNullParameter(sysKeyEvent, "<set-?>");
        this.sysKeyEvent = sysKeyEvent;
    }

    public final TextView getTxtState() {
        return this.txtState;
    }

    public final void setTxtState(TextView textView) {
        this.txtState = textView;
    }

    @Override // com.dw.launcher.ui.activity.Hilt_BreatheActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.txtState = (TextView) findViewById(R.id.txtState);
        Object systemService = getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        this.vibrator = (Vibrator) systemService;
        Window window = getWindow();
        if (window != null) {
            window.addFlags(128);
        }
        View viewFindViewById = findViewById(R.id.ivBreathe);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        setIvBreathe((ImageView) viewFindViewById);
        int breatheStrength = getSharedPreferences().getBreatheStrength();
        int breatheFreq = getSharedPreferences().getBreatheFreq();
        CountDownTimer countDownTimer = new CountDownTimer(((long) (getSharedPreferences().getBreatheDuration() * 60)) * 1000) { // from class: com.dw.launcher.ui.activity.BreatheActivity.onCreate.1
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BreatheActivity.this.cancel();
                BreatheActivity.this.finish();
            }
        };
        this.countDownTimer = countDownTimer;
        this.currentMode = breatheStrength;
        countDownTimer.start();
        breatheAnimation(getIvBreathe(), this.scaleValue, (long) (((60.0f / breatheFreq) * 1000) / 2));
    }

    public final float getScaleValue() {
        return this.scaleValue;
    }

    public final void breatheAnimation(final View view, final float scaleValue, final long duration) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.handler.removeCallbacks(this.vibrationRunnable);
        this.handler.postDelayed(this.vibrationRunnable, 0L);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, scaleValue, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, scaleValue, 1.0f);
        TextView textView = this.txtState;
        if (textView != null) {
            textView.setText(getString(R.string.inhale));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        animatorSet.setDuration(duration);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.dw.launcher.ui.activity.BreatheActivity$breatheAnimation$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (this.this$0.isEnd) {
                    return;
                }
                this.this$0.reverseAnimation(view, scaleValue, duration);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reverseAnimation(final View view, final float scaleValue, final long duration) {
        this.handler.removeCallbacks(this.vibrationRunnable);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 1.0f, scaleValue);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 1.0f, scaleValue);
        TextView textView = this.txtState;
        if (textView != null) {
            textView.setText(getString(R.string.exhale));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        animatorSet.setDuration(duration);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.dw.launcher.ui.activity.BreatheActivity$reverseAnimation$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (this.this$0.isEnd) {
                    return;
                }
                this.this$0.breatheAnimation(view, scaleValue, duration);
            }
        });
    }

    public final void endLoopAnimation(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.animate().cancel();
        view.clearAnimation();
    }

    public int getLayoutId() {
        return R.layout.activity_breathe_sport;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (getSysKeyEvent().getSingleKeyCode() == keyCode) {
            cancel();
            finish();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancel() {
        this.isEnd = true;
        endLoopAnimation(getIvBreathe());
        CountDownTimer countDownTimer = this.countDownTimer;
        Vibrator vibrator = null;
        if (countDownTimer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownTimer");
            countDownTimer = null;
        }
        countDownTimer.cancel();
        this.handler.removeCallbacks(this.vibrationRunnable);
        Vibrator vibrator2 = this.vibrator;
        if (vibrator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vibrator");
        } else {
            vibrator = vibrator2;
        }
        vibrator.cancel();
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(128);
        }
    }

    @Override // com.dw.launcher.ui.activity.Hilt_BreatheActivity
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        cancel();
        finish();
    }

    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        cancel();
        finish();
    }
}
