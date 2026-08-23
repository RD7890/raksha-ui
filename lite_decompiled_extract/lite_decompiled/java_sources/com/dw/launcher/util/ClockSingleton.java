package com.dw.launcher.util;

import com.dw.launcher.data.entity.Clock;
import com.google.android.mms.pdu.CharacterSets;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ClockSingleton.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/dw/launcher/util/ClockSingleton;", "", "()V", "mClockList", "", "Lcom/dw/launcher/data/entity/Clock;", "getMClockList", "()Ljava/util/List;", "setMClockList", "(Ljava/util/List;)V", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ClockSingleton {
    public static final ClockSingleton INSTANCE = new ClockSingleton();
    private static List<Clock> mClockList;

    private ClockSingleton() {
    }

    public final List<Clock> getMClockList() {
        return mClockList;
    }

    public final void setMClockList(List<Clock> list) {
        mClockList = list;
    }
}
