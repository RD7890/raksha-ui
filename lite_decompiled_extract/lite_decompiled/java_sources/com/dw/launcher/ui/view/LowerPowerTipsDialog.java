package com.dw.launcher.ui.view;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.dw.launcher.R;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.center.blurview.ShapeBlurView;

/* JADX INFO: compiled from: LowerPowerTipsDialog.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/dw/launcher/ui/view/LowerPowerTipsDialog;", "Lcom/dw/launcher/ui/view/BaseDialog;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getContext", "()Landroid/app/Activity;", "getLayoutId", "", "initialize", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class LowerPowerTipsDialog extends BaseDialog {
    private final Activity context;

    @Override // android.app.Dialog
    public final Activity getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LowerPowerTipsDialog(Activity context) {
        super(context, 1.0f, true);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.dw.launcher.ui.view.BaseDialog
    protected void initialize() {
        View viewFindViewById = findViewById(R.id.shapeBlurView);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type net.center.blurview.ShapeBlurView");
        ((ShapeBlurView) viewFindViewById).setBlurNormal();
        ((TextView) findViewById(R.id.tv_ok)).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.view.LowerPowerTipsDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LowerPowerTipsDialog.initialize$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$0(LowerPowerTipsDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hide();
    }

    @Override // com.dw.launcher.ui.view.BaseDialog
    protected int getLayoutId() {
        return R.layout.dialog_low_power_tip;
    }
}
