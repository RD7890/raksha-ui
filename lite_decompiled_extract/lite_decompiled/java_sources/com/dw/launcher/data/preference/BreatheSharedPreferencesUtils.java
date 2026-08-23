package com.dw.launcher.data.preference;

import android.content.Context;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.util.BreatheFileStorageUtils;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BreatheSharedPreferencesUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/dw/launcher/data/preference/BreatheSharedPreferencesUtils;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getBreatheDuration", BuildConfig.FLAVOR, "getBreatheFreq", "getBreatheStrength", "setBreatheDuration", BuildConfig.FLAVOR, "time", "setBreatheFreq", "setBreatheStrength", "Companion", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BreatheSharedPreferencesUtils {
    private static final String BREATHE_DURATION = "BREATHE_DURATION";
    private static final String BREATHE_FREQ = "BREATHE_FREQ";
    private static final String BREATHE_STRENGTH = "BREATHE_STRENGTH";
    private final Context context;

    @Inject
    public BreatheSharedPreferencesUtils(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final void setBreatheDuration(int time) {
        BreatheFileStorageUtils.INSTANCE.writeToFile(BREATHE_DURATION, String.valueOf(time));
    }

    public final int getBreatheDuration() {
        String fromFile = BreatheFileStorageUtils.INSTANCE.readFromFile(BREATHE_DURATION);
        if (fromFile != null) {
            return Integer.parseInt(fromFile);
        }
        return 1;
    }

    public final void setBreatheStrength(int time) {
        BreatheFileStorageUtils.INSTANCE.writeToFile(BREATHE_STRENGTH, String.valueOf(time));
    }

    public final int getBreatheStrength() {
        String fromFile = BreatheFileStorageUtils.INSTANCE.readFromFile(BREATHE_STRENGTH);
        if (fromFile != null) {
            return Integer.parseInt(fromFile);
        }
        return 0;
    }

    public final void setBreatheFreq(int time) {
        BreatheFileStorageUtils.INSTANCE.writeToFile(BREATHE_FREQ, String.valueOf(time));
    }

    public final int getBreatheFreq() {
        String fromFile = BreatheFileStorageUtils.INSTANCE.readFromFile(BREATHE_FREQ);
        if (fromFile != null) {
            return Integer.parseInt(fromFile);
        }
        return 6;
    }
}
