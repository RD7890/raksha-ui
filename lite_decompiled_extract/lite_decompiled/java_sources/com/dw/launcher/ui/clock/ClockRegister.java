package com.dw.launcher.ui.clock;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.google.android.mms.pdu.CharacterSets;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClockRegister.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/dw/launcher/ui/clock/ClockRegister;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getClock", "Landroidx/fragment/app/Fragment;", "style", "", "getDefaultClockStyle", "Companion", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ClockRegister {
    public static final int STYLE_SHAKE = 0;
    private final Context context;

    public final int getDefaultClockStyle() {
        return 0;
    }

    @Inject
    public ClockRegister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Fragment getClock(int style) {
        if (style == 0) {
            return new ShakeClock();
        }
        return new ShakeClock();
    }
}
