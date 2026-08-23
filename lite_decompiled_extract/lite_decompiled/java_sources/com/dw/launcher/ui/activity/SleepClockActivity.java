package com.dw.launcher.ui.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import cn.carbswang.android.numberpickerview.library.NumberPickerView;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.SharedPreferencesUtils;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import timber.log.Timber;

/* JADX INFO: compiled from: SleepClockActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\u0004H\u0016J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020#H\u0014J\u0018\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006+"}, d2 = {"Lcom/dw/launcher/ui/activity/SleepClockActivity;", "Lcom/dw/launcher/base/BaseActivity;", "()V", "hour", "", "getHour", "()I", "setHour", "(I)V", "hourList", "", "", "isStart", "", "()Z", "setStart", "(Z)V", "keyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "minitue", "getMinitue", "setMinitue", "minitueList", "sharedPreferences", "Lcom/dw/launcher/data/preference/SharedPreferencesUtils;", "getSharedPreferences", "()Lcom/dw/launcher/data/preference/SharedPreferencesUtils;", "setSharedPreferences", "(Lcom/dw/launcher/data/preference/SharedPreferencesUtils;)V", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class SleepClockActivity extends Hilt_SleepClockActivity {
    private int hour;
    private final List<String> hourList;
    private boolean isStart;

    @Inject
    public SysKeyEvent keyEvent;
    private int minitue;
    private final List<String> minitueList;

    @Inject
    public SharedPreferencesUtils sharedPreferences;

    public SleepClockActivity() {
        IntRange intRange = new IntRange(0, 23);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.padStart(String.valueOf(((IntIterator) it).nextInt()), 2, '0'));
        }
        this.hourList = arrayList;
        IntRange intRange2 = new IntRange(0, 59);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
        Iterator<Integer> it2 = intRange2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(StringsKt.padStart(String.valueOf(((IntIterator) it2).nextInt()), 2, '0'));
        }
        this.minitueList = arrayList2;
    }

    public final SysKeyEvent getKeyEvent() {
        SysKeyEvent sysKeyEvent = this.keyEvent;
        if (sysKeyEvent != null) {
            return sysKeyEvent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyEvent");
        return null;
    }

    public final void setKeyEvent(SysKeyEvent sysKeyEvent) {
        Intrinsics.checkNotNullParameter(sysKeyEvent, "<set-?>");
        this.keyEvent = sysKeyEvent;
    }

    public final SharedPreferencesUtils getSharedPreferences() {
        SharedPreferencesUtils sharedPreferencesUtils = this.sharedPreferences;
        if (sharedPreferencesUtils != null) {
            return sharedPreferencesUtils;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        return null;
    }

    public final void setSharedPreferences(SharedPreferencesUtils sharedPreferencesUtils) {
        Intrinsics.checkNotNullParameter(sharedPreferencesUtils, "<set-?>");
        this.sharedPreferences = sharedPreferencesUtils;
    }

    public final int getHour() {
        return this.hour;
    }

    public final void setHour(int i) {
        this.hour = i;
    }

    public final int getMinitue() {
        return this.minitue;
    }

    public final void setMinitue(int i) {
        this.minitue = i;
    }

    /* JADX INFO: renamed from: isStart, reason: from getter */
    public final boolean getIsStart() {
        return this.isStart;
    }

    public final void setStart(boolean z) {
        this.isStart = z;
    }

    @Override // com.dw.launcher.ui.activity.Hilt_SleepClockActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NumberPickerView numberPickerViewFindViewById = findViewById(R.id.txtSleepHour);
        NumberPickerView numberPickerViewFindViewById2 = findViewById(R.id.txtSleepMinitue);
        int sleepStartTime = getSharedPreferences().getSleepStartTime();
        int sleepEndTime = getSharedPreferences().getSleepEndTime();
        boolean z = getIntent().getStringExtra("startTime") != null;
        this.isStart = z;
        if (!z) {
            sleepStartTime = sleepEndTime;
        }
        this.hour = sleepStartTime / 60;
        this.minitue = sleepStartTime % 60;
        numberPickerViewFindViewById.setDisplayedValuesAndPickedIndex((String[]) this.hourList.toArray(new String[0]), this.hour, false);
        numberPickerViewFindViewById2.setDisplayedValuesAndPickedIndex((String[]) this.minitueList.toArray(new String[0]), this.minitue, false);
        numberPickerViewFindViewById.setOnValueChangedListener(new NumberPickerView.OnValueChangeListener() { // from class: com.dw.launcher.ui.activity.SleepClockActivity$$ExternalSyntheticLambda0
            public final void onValueChange(NumberPickerView numberPickerView, int i, int i2) {
                SleepClockActivity.onCreate$lambda$2(this.f$0, numberPickerView, i, i2);
            }
        });
        numberPickerViewFindViewById2.setOnValueChangedListener(new NumberPickerView.OnValueChangeListener() { // from class: com.dw.launcher.ui.activity.SleepClockActivity$$ExternalSyntheticLambda1
            public final void onValueChange(NumberPickerView numberPickerView, int i, int i2) {
                SleepClockActivity.onCreate$lambda$3(this.f$0, numberPickerView, i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(SleepClockActivity this$0, NumberPickerView numberPickerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hour = i2;
        Timber.INSTANCE.i("小时 old: " + i + ", new: " + i2, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(SleepClockActivity this$0, NumberPickerView numberPickerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.i("分钟 old: " + i + ", new: " + i2, new Object[0]);
        this$0.minitue = i2;
    }

    public int getLayoutId() {
        return R.layout.activity_sleep_timeset;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (getKeyEvent().getSingleKeyCode() == keyCode) {
            if (this.isStart) {
                getSharedPreferences().setSleepStartTime((this.hour * 60) + this.minitue);
            } else {
                getSharedPreferences().setSleepEndTime((this.hour * 60) + this.minitue);
            }
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // com.dw.launcher.ui.activity.Hilt_SleepClockActivity
    protected void onDestroy() {
        super.onDestroy();
    }
}
