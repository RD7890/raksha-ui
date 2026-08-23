package com.dw.launcher.ui.dashboard.util;

import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: compiled from: InterpolatorUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J&\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J&\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J&\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J&\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J&\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J&\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"Lcom/dw/launcher/ui/dashboard/util/InterpolatorUtils;", "", "()V", "deEaseIn", "", "t", "b", "c", "d", "easeIn", "easeInOutCubic", "easeInOutSine", "easeInSine", "easeOutCubic", "easeOutSine", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class InterpolatorUtils {
    public static final InterpolatorUtils INSTANCE = new InterpolatorUtils();

    public final float easeIn(float t, float b, float c, float d) {
        float f = t / d;
        return ((-c) * f * (f - 2)) + b;
    }

    public final float easeInOutCubic(float t, float b, float c, float d) {
        float f;
        float f2 = t / d;
        float f3 = 2;
        float f4 = f2 * f3;
        if (f4 < 1.0f) {
            f = (c / f3) * f4 * f4 * f4;
        } else {
            float f5 = f4 - f3;
            f = (c / f3) * ((f5 * f5 * f5) + f3);
        }
        return f + b;
    }

    private InterpolatorUtils() {
    }

    public final float deEaseIn(float t, float b, float c, float d) {
        return (float) ((Math.sqrt(((t - b) / (-c)) + 1) + ((double) 1)) * ((double) d));
    }

    public final float easeOutCubic(float t, float b, float c, float d) {
        float f = t / d;
        float f2 = 1;
        Unit unit = Unit.INSTANCE;
        return (c * (((f - f2) * f2 * f2) + f2)) + b;
    }

    public final float easeInOutSine(float t, float b, float c, float d) {
        return (float) ((((double) ((-c) / 2)) * (Math.cos((((double) t) * 3.141592653589793d) / ((double) d)) - ((double) 1))) + ((double) b));
    }

    public final float easeOutSine(float t, float b, float c, float d) {
        return (float) ((((double) c) * Math.sin(((double) (t / d)) * 1.5707963267948966d)) + ((double) b));
    }

    public final float easeInSine(float t, float b, float c, float d) {
        return (float) ((((double) (-c)) * Math.cos(((double) (t / d)) * 1.5707963267948966d)) + ((double) c) + ((double) b));
    }
}
