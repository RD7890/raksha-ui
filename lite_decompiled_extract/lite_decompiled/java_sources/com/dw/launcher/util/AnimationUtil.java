package com.dw.launcher.util;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.google.android.mms.pdu.CharacterSets;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnimationUtil.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u000b\u001a\u00020\f\"\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0002¨\u0006\u000e"}, d2 = {"Lcom/dw/launcher/util/AnimationUtil;", "", "()V", "startShrinkAndRestoreAnimation", "", "view", "Landroid/view/View;", "shrinkFactor", "", "duration", "", "values", "", "durations", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class AnimationUtil {
    public static final AnimationUtil INSTANCE = new AnimationUtil();

    private AnimationUtil() {
    }

    private final void startShrinkAndRestoreAnimation(View view, float shrinkFactor, long duration) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, shrinkFactor);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, shrinkFactor);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "scaleX", shrinkFactor, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "scaleY", shrinkFactor, 1.0f);
        objectAnimatorOfFloat.setDuration(duration);
        objectAnimatorOfFloat2.setDuration(duration);
        objectAnimatorOfFloat3.setDuration(duration);
        objectAnimatorOfFloat4.setDuration(duration);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).before(objectAnimatorOfFloat3).before(objectAnimatorOfFloat4);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.start();
    }

    private final void startShrinkAndRestoreAnimation(View view, float[] values, long durations) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", Arrays.copyOf(values, values.length));
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", Arrays.copyOf(values, values.length));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setDuration(durations);
        animatorSet.start();
    }
}
