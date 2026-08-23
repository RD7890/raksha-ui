package com.dw.launcher.ui.dashboard.util;

import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;

/* JADX INFO: compiled from: EasingFunction.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001¨\u0006\u0007"}, d2 = {"ease", "", "x", "easeInCirc", "easeInExpo", "easeOutQuint", "n", "app_version8Release"}, k = 2, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class EasingFunctionKt {
    public static final float easeInCirc(float f) {
        float f2 = 1;
        return f2 - ((float) Math.sqrt(f2 - ((float) Math.pow(f, 2))));
    }

    public static final float easeInExpo(float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        float f2 = 10;
        return (float) Math.pow(2.0f, (f * f2) - f2);
    }

    public static /* synthetic */ float easeOutQuint$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 3.0f;
        }
        return easeOutQuint(f, f2);
    }

    public static final float easeOutQuint(float f, float f2) {
        float f3 = 1;
        return f3 - ((float) Math.pow(f3 - f, f2));
    }

    public static final float ease(float f) {
        float f2 = 1;
        return f2 - (((float) Math.pow(f2 - f, 3)) / 2);
    }
}
