package com.dw.launcher.util;

import com.google.android.material.timepicker.TimeModel;
import com.google.android.mms.pdu.CharacterSets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\tJ\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0007J \u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/dw/launcher/util/Utils;", "", "()V", "Calo_TARGET", "", "Distance_TARGET", "Height", "STEP_TARGET", "StepLenght", "", "Weight", "formatNumberToTwoDigits", "", "number", "getWeekDate", "", "date", "Ljava/util/Date;", "keepTwoDecimalNoRound", "value", "keepTwoDecimalStringNoRound", "makeKcal", "km", "weight", "makeKm", "stepDs", "height", "stepLenght", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class Utils {
    public static final int Calo_TARGET = 300;
    public static final int Distance_TARGET = 5000;
    public static final int Height = 140;
    public static final Utils INSTANCE = new Utils();
    public static final int STEP_TARGET = 10000;
    public static final float StepLenght = 63.0f;
    public static final float Weight = 33.0f;

    @JvmStatic
    public static final float makeKcal(float km, float weight) {
        return weight * km * 0.4f;
    }

    private Utils() {
    }

    @JvmStatic
    public static final float makeKm(int stepDs, int height, float stepLenght) {
        Number numberValueOf;
        if (stepLenght == 0.0f) {
            if (height == 0) {
                height = 140;
            }
            numberValueOf = Integer.valueOf((int) (((double) height) * 0.45d));
        } else {
            numberValueOf = Float.valueOf(stepLenght);
        }
        return ((stepDs * numberValueOf.floatValue()) / 100.0f) / CharacterSets.UCS2;
    }

    public final List<String> getWeekDate(Date date) {
        ArrayList arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(7);
        calendar.add(5, i == 1 ? -6 : 2 - i);
        for (int i2 = 0; i2 < 7; i2++) {
            String str = simpleDateFormat.format(calendar.getTime());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            arrayList.add(str);
            calendar.add(5, 1);
        }
        return arrayList;
    }

    public final float keepTwoDecimalNoRound(float value) {
        String strKeepTwoDecimalStringNoRound = keepTwoDecimalStringNoRound(value);
        Intrinsics.checkNotNull(strKeepTwoDecimalStringNoRound);
        return Float.parseFloat(strKeepTwoDecimalStringNoRound);
    }

    public final String keepTwoDecimalStringNoRound(float value) {
        String str = value + "00";
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, ".", 0, false, 6, (Object) null);
        if (-1 == iLastIndexOf$default) {
            return str;
        }
        String strSubstring = str.substring(0, iLastIndexOf$default + 3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String formatNumberToTwoDigits(int number) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(number)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
