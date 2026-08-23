package com.dw.launcher.ui.fragment.sleep;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.SharedPreferencesUtils;
import com.dw.launcher.ui.activity.SleepClockActivity;
import com.dw.launcher.ui.view.SleepBarView;
import com.dw.launcher.util.Utils;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SleepFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\b\u0010%\u001a\u00020\u001bH\u0016J\u001a\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006+"}, d2 = {"Lcom/dw/launcher/ui/fragment/sleep/SleepFragment;", "Lcom/dw/launcher/base/BaseFragment;", "()V", "sharedPreferences", "Lcom/dw/launcher/data/preference/SharedPreferencesUtils;", "getSharedPreferences", "()Lcom/dw/launcher/data/preference/SharedPreferencesUtils;", "setSharedPreferences", "(Lcom/dw/launcher/data/preference/SharedPreferencesUtils;)V", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "txtSleepWakeTime", "Landroid/widget/TextView;", "getTxtSleepWakeTime", "()Landroid/widget/TextView;", "setTxtSleepWakeTime", "(Landroid/widget/TextView;)V", "txtStartSleepTime", "getTxtStartSleepTime", "setTxtStartSleepTime", "getLayoutId", "", "onAttach", "", "context", "Landroid/content/Context;", "onDetach", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class SleepFragment extends Hilt_SleepFragment {

    @Inject
    public SharedPreferencesUtils sharedPreferences;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private TextView txtSleepWakeTime;
    private TextView txtStartSleepTime;

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

    public final TextView getTxtStartSleepTime() {
        return this.txtStartSleepTime;
    }

    public final void setTxtStartSleepTime(TextView textView) {
        this.txtStartSleepTime = textView;
    }

    public final TextView getTxtSleepWakeTime() {
        return this.txtSleepWakeTime;
    }

    public final void setTxtSleepWakeTime(TextView textView) {
        this.txtSleepWakeTime = textView;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SleepBarView sleepBarView = (SleepBarView) view.findViewById(R.id.sleepBar);
        this.txtStartSleepTime = (TextView) view.findViewById(R.id.txtStartTime);
        this.txtSleepWakeTime = (TextView) view.findViewById(R.id.txtSleepWakeTime);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < 7; i++) {
            arrayList.add(Integer.valueOf(i));
            if (i % 2 == 0) {
                arrayList2.add(10);
            } else {
                arrayList2.add(20);
            }
        }
        sleepBarView.setDailyList(arrayList, arrayList2);
        ((LinearLayout) view.findViewById(R.id.llStartSleep)).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.fragment.sleep.SleepFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SleepFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        ((LinearLayout) view.findViewById(R.id.llEndSleep)).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.fragment.sleep.SleepFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SleepFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(SleepFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) SleepClockActivity.class);
        TextView textView = this$0.txtStartSleepTime;
        intent.putExtra("startTime", String.valueOf(textView != null ? textView.getText() : null));
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(SleepFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getContext(), (Class<?>) SleepClockActivity.class));
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return keyCode == getSysKeyEvent().getUPKey() || keyCode == getSysKeyEvent().getDownKey();
    }

    public int getLayoutId() {
        return R.layout.fragment_sleep;
    }

    @Override // com.dw.launcher.ui.fragment.sleep.Hilt_SleepFragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onResume() {
        super.onResume();
        TextView textView = this.txtStartSleepTime;
        if (textView != null) {
            textView.setText(Utils.INSTANCE.formatNumberToTwoDigits(getSharedPreferences().getSleepStartTime() / 60) + ':' + Utils.INSTANCE.formatNumberToTwoDigits(getSharedPreferences().getSleepStartTime() % 60));
        }
        TextView textView2 = this.txtSleepWakeTime;
        if (textView2 != null) {
            textView2.setText(Utils.INSTANCE.formatNumberToTwoDigits(getSharedPreferences().getSleepEndTime() / 60) + ':' + Utils.INSTANCE.formatNumberToTwoDigits(getSharedPreferences().getSleepEndTime() % 60));
        }
    }

    public void onPause() {
        super.onPause();
    }
}
