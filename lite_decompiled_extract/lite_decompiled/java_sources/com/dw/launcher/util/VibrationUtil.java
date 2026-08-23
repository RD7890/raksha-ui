package com.dw.launcher.util;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VibrationUtil.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ,\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\r¨\u0006\u0014"}, d2 = {"Lcom/dw/launcher/util/VibrationUtil;", "", "()V", "cancel", "", "context", "Landroid/content/Context;", "isVibrationAvailable", "", "vibrate", "milliseconds", "", "amplitude", "", "vibratePattern", "pattern", "", "amplitudes", "", "repeat", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class VibrationUtil {
    public static final VibrationUtil INSTANCE = new VibrationUtil();

    private VibrationUtil() {
    }

    private final boolean isVibrationAvailable(Context context) {
        Object systemService = context.getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        return ((Vibrator) systemService).hasVibrator();
    }

    public static /* synthetic */ void vibrate$default(VibrationUtil vibrationUtil, Context context, long j, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        vibrationUtil.vibrate(context, j, i);
    }

    public final void vibrate(Context context, long milliseconds, int amplitude) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isVibrationAvailable(context)) {
            Object systemService = context.getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            Vibrator vibrator = (Vibrator) systemService;
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot(milliseconds, amplitude));
            } else {
                vibrator.vibrate(milliseconds);
            }
        }
    }

    public static /* synthetic */ void vibratePattern$default(VibrationUtil vibrationUtil, Context context, long[] jArr, int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            iArr = null;
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        vibrationUtil.vibratePattern(context, jArr, iArr, i);
    }

    public final void vibratePattern(Context context, long[] pattern, int[] amplitudes, int repeat) {
        VibrationEffect vibrationEffectCreateWaveform;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (isVibrationAvailable(context)) {
            Object systemService = context.getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            Vibrator vibrator = (Vibrator) systemService;
            if (Build.VERSION.SDK_INT >= 26) {
                if (amplitudes != null) {
                    vibrationEffectCreateWaveform = VibrationEffect.createWaveform(pattern, amplitudes, repeat);
                } else {
                    vibrationEffectCreateWaveform = VibrationEffect.createWaveform(pattern, repeat);
                }
                vibrator.vibrate(vibrationEffectCreateWaveform);
                return;
            }
            vibrator.vibrate(pattern, repeat);
        }
    }

    public final void cancel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isVibrationAvailable(context)) {
            Object systemService = context.getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            ((Vibrator) systemService).cancel();
        }
    }
}
