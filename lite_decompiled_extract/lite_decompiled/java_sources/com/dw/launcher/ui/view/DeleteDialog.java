package com.dw.launcher.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.dw.launcher.databinding.DialogDeleteBinding;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeleteDialog.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0007J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0007H\u0016R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/dw/launcher/ui/view/DeleteDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "backListener", "Lkotlin/Function0;", "", "getBackListener", "()Lkotlin/jvm/functions/Function0;", "setBackListener", "(Lkotlin/jvm/functions/Function0;)V", "binding", "Lcom/dw/launcher/databinding/DialogDeleteBinding;", "getBinding", "()Lcom/dw/launcher/databinding/DialogDeleteBinding;", "setBinding", "(Lcom/dw/launcher/databinding/DialogDeleteBinding;)V", "deleteListener", "getDeleteListener", "setDeleteListener", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setName", "name", "", "show", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class DeleteDialog extends Dialog {
    private Function0<Unit> backListener;
    public DialogDeleteBinding binding;
    private Function0<Unit> deleteListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final Function0<Unit> getBackListener() {
        return this.backListener;
    }

    public final void setBackListener(Function0<Unit> function0) {
        this.backListener = function0;
    }

    public final Function0<Unit> getDeleteListener() {
        return this.deleteListener;
    }

    public final void setDeleteListener(Function0<Unit> function0) {
        this.deleteListener = function0;
    }

    public final DialogDeleteBinding getBinding() {
        DialogDeleteBinding dialogDeleteBinding = this.binding;
        if (dialogDeleteBinding != null) {
            return dialogDeleteBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogDeleteBinding dialogDeleteBinding) {
        Intrinsics.checkNotNullParameter(dialogDeleteBinding, "<set-?>");
        this.binding = dialogDeleteBinding;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DialogDeleteBinding dialogDeleteBindingInflate = DialogDeleteBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(dialogDeleteBindingInflate, "inflate(...)");
        setBinding(dialogDeleteBindingInflate);
        Window window = getWindow();
        if (window != null) {
            window.setLayout((int) (((double) getContext().getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        setContentView(getBinding().getRoot());
        initView();
    }

    public final void initView() {
        getBinding().tvDelete.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.view.DeleteDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeleteDialog.initView$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(DeleteDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.deleteListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        getBinding().tvName.setText("【" + name + "】？");
    }
}
