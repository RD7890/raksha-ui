package com.dw.launcher.ui.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.carbswang.android.numberpickerview.library.NumberPickerView;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.BreatheSharedPreferencesUtils;
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
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: BreatheValueSettingActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020!H\u0014R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Lcom/dw/launcher/ui/activity/BreatheValueSettingActivity;", "Lcom/dw/launcher/base/BaseActivity;", "()V", "durationList", "", "", "getDurationList", "()Ljava/util/List;", "setDurationList", "(Ljava/util/List;)V", "frequencyList", "getFrequencyList", "setFrequencyList", "sharedPreferences", "Lcom/dw/launcher/data/preference/BreatheSharedPreferencesUtils;", "getSharedPreferences", "()Lcom/dw/launcher/data/preference/BreatheSharedPreferencesUtils;", "setSharedPreferences", "(Lcom/dw/launcher/data/preference/BreatheSharedPreferencesUtils;)V", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "type", "", "getType", "()I", "setType", "(I)V", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onKeyUp", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onUserLeaveHint", "Companion", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class BreatheValueSettingActivity extends Hilt_BreatheValueSettingActivity {
    public static final int DurationType = 1;
    public static final int FreqType = 0;
    public static final int StrengthType = 2;
    private List<String> durationList;
    private List<String> frequencyList;

    @Inject
    public BreatheSharedPreferencesUtils sharedPreferences;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private int type;

    public BreatheValueSettingActivity() {
        IntRange intRange = new IntRange(4, 10);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((IntIterator) it).nextInt()));
        }
        this.frequencyList = arrayList;
        IntRange intRange2 = new IntRange(1, 5);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
        Iterator<Integer> it2 = intRange2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(String.valueOf(((IntIterator) it2).nextInt()));
        }
        this.durationList = arrayList2;
    }

    public final SysKeyEvent getSysKeyEvent() {
        SysKeyEvent sysKeyEvent = this.sysKeyEvent;
        if (sysKeyEvent != null) {
            return sysKeyEvent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sysKeyEvent");
        return null;
    }

    public final void setSysKeyEvent(SysKeyEvent sysKeyEvent) {
        Intrinsics.checkNotNullParameter(sysKeyEvent, "<set-?>");
        this.sysKeyEvent = sysKeyEvent;
    }

    public final BreatheSharedPreferencesUtils getSharedPreferences() {
        BreatheSharedPreferencesUtils breatheSharedPreferencesUtils = this.sharedPreferences;
        if (breatheSharedPreferencesUtils != null) {
            return breatheSharedPreferencesUtils;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        return null;
    }

    public final void setSharedPreferences(BreatheSharedPreferencesUtils breatheSharedPreferencesUtils) {
        Intrinsics.checkNotNullParameter(breatheSharedPreferencesUtils, "<set-?>");
        this.sharedPreferences = breatheSharedPreferencesUtils;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final List<String> getFrequencyList() {
        return this.frequencyList;
    }

    public final void setFrequencyList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.frequencyList = list;
    }

    public final List<String> getDurationList() {
        return this.durationList;
    }

    public final void setDurationList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.durationList = list;
    }

    @Override // com.dw.launcher.ui.activity.Hilt_BreatheValueSettingActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NumberPickerView numberPickerViewFindViewById = findViewById(R.id.numberPickerView);
        TextView textView = (TextView) findViewById(R.id.txtUnit);
        ImageView imageView = (ImageView) findViewById(R.id.ivSure);
        this.type = getIntent().getIntExtra("type", 0);
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{getString(R.string.leak), getString(R.string.strong), getString(R.string.none)});
        final Ref.IntRef intRef = new Ref.IntRef();
        int i = this.type;
        if (i == 0) {
            textView.setText(getString(R.string.permin));
            intRef.element = getSharedPreferences().getBreatheFreq();
            numberPickerViewFindViewById.setDisplayedValuesAndPickedIndex((String[]) CollectionsKt.toList(this.frequencyList).toArray(new String[0]), intRef.element - Integer.parseInt(this.frequencyList.get(0)), false);
            numberPickerViewFindViewById.setOnValueChangedListener(new NumberPickerView.OnValueChangeListener() { // from class: com.dw.launcher.ui.activity.BreatheValueSettingActivity$$ExternalSyntheticLambda0
                public final void onValueChange(NumberPickerView numberPickerView, int i2, int i3) {
                    BreatheValueSettingActivity.onCreate$lambda$2(intRef, this, numberPickerView, i2, i3);
                }
            });
        } else if (i == 1) {
            textView.setText(getString(R.string.minitue));
            intRef.element = getSharedPreferences().getBreatheDuration();
            numberPickerViewFindViewById.setDisplayedValuesAndPickedIndex((String[]) CollectionsKt.toList(this.durationList).toArray(new String[0]), intRef.element - Integer.parseInt(this.durationList.get(0)), false);
            numberPickerViewFindViewById.setOnValueChangedListener(new NumberPickerView.OnValueChangeListener() { // from class: com.dw.launcher.ui.activity.BreatheValueSettingActivity$$ExternalSyntheticLambda1
                public final void onValueChange(NumberPickerView numberPickerView, int i2, int i3) {
                    BreatheValueSettingActivity.onCreate$lambda$3(intRef, this, numberPickerView, i2, i3);
                }
            });
        } else if (i == 2) {
            textView.setVisibility(8);
            intRef.element = getSharedPreferences().getBreatheStrength();
            numberPickerViewFindViewById.setDisplayedValuesAndPickedIndex((String[]) listListOf.toArray(new String[0]), intRef.element, false);
            numberPickerViewFindViewById.setOnValueChangedListener(new NumberPickerView.OnValueChangeListener() { // from class: com.dw.launcher.ui.activity.BreatheValueSettingActivity$$ExternalSyntheticLambda2
                public final void onValueChange(NumberPickerView numberPickerView, int i2, int i3) {
                    BreatheValueSettingActivity.onCreate$lambda$4(intRef, numberPickerView, i2, i3);
                }
            });
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.BreatheValueSettingActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BreatheValueSettingActivity.onCreate$lambda$5(this.f$0, intRef, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(Ref.IntRef value, BreatheValueSettingActivity this$0, NumberPickerView numberPickerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(value, "$value");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        value.element = Integer.parseInt(this$0.frequencyList.get(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(Ref.IntRef value, BreatheValueSettingActivity this$0, NumberPickerView numberPickerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(value, "$value");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        value.element = Integer.parseInt(this$0.durationList.get(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(Ref.IntRef value, NumberPickerView numberPickerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(value, "$value");
        value.element = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5(BreatheValueSettingActivity this$0, Ref.IntRef value, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(value, "$value");
        int i = this$0.type;
        if (i == 0) {
            this$0.getSharedPreferences().setBreatheFreq(value.element);
        } else if (i == 1) {
            this$0.getSharedPreferences().setBreatheDuration(value.element);
        } else if (i == 2) {
            this$0.getSharedPreferences().setBreatheStrength(value.element);
        }
        this$0.finish();
    }

    public int getLayoutId() {
        return R.layout.activity_breathe_value_setting;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == getSysKeyEvent().getSingleKeyCode()) {
            finish();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        finish();
    }
}
