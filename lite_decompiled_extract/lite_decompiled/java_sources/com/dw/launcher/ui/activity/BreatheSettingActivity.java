package com.dw.launcher.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BreatheSettingActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/dw/launcher/ui/activity/BreatheSettingActivity;", "Lcom/dw/launcher/base/BaseActivity;", "()V", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "getLayoutId", "", "hasVibrator", "", "context", "Landroid/content/Context;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onUserLeaveHint", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class BreatheSettingActivity extends Hilt_BreatheSettingActivity {

    @Inject
    public SysKeyEvent sysKeyEvent;

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

    @Override // com.dw.launcher.ui.activity.Hilt_BreatheSettingActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.llPinlvSetting);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.llDuraionSetting);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.llChuganSetting);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.BreatheSettingActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BreatheSettingActivity.onCreate$lambda$0(this.f$0, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.BreatheSettingActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BreatheSettingActivity.onCreate$lambda$1(this.f$0, view);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.BreatheSettingActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BreatheSettingActivity.onCreate$lambda$2(this.f$0, view);
            }
        });
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        if (hasVibrator(applicationContext)) {
            return;
        }
        linearLayout3.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(BreatheSettingActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getApplicationContext(), (Class<?>) BreatheValueSettingActivity.class);
        intent.putExtra("type", 0);
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(BreatheSettingActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getApplicationContext(), (Class<?>) BreatheValueSettingActivity.class);
        intent.putExtra("type", 1);
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(BreatheSettingActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getApplicationContext(), (Class<?>) BreatheValueSettingActivity.class);
        intent.putExtra("type", 2);
        this$0.startActivity(intent);
    }

    public final boolean hasVibrator(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        return ((Vibrator) systemService).hasVibrator();
    }

    public int getLayoutId() {
        return R.layout.activity_breathe_setting;
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
