package com.dw.launcher.ui.clock.util;

import com.google.android.mms.pdu.CharacterSets;
import java.text.ParseException;
import kotlin.Metadata;

/* JADX INFO: compiled from: LunarUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J \u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/dw/launcher/ui/clock/util/LunarUtils;", "", "()V", "solarToLunar", "", "year", "", "month", "day", "solarToLunar2", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class LunarUtils {
    public static final LunarUtils INSTANCE = new LunarUtils();

    private LunarUtils() {
    }

    public final int[] solarToLunar(int year, int month, int day) throws ParseException {
        LunarEntity lunarEntityConvertSolarToLunar = Lunar.convertSolarToLunar(year, month, day);
        if (lunarEntityConvertSolarToLunar != null) {
            return new int[]{lunarEntityConvertSolarToLunar.getYear(), lunarEntityConvertSolarToLunar.getMonth(), lunarEntityConvertSolarToLunar.getDay(), lunarEntityConvertSolarToLunar.getLeap()};
        }
        return null;
    }

    public final int[] solarToLunar2(int year, int month, int day) {
        int[] iArrSolarToLunar = Lunar.solarToLunar(year, month, day);
        if (iArrSolarToLunar != null) {
            return iArrSolarToLunar;
        }
        return null;
    }
}
