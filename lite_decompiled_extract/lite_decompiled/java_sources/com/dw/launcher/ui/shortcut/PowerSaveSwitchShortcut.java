package com.dw.launcher.ui.shortcut;

import android.content.Context;
import android.view.View;
import com.dw.framework.PowerManagerHelper;
import com.dw.launcher.R;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PowerSaveSwitchShortcut.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/dw/launcher/ui/shortcut/PowerSaveSwitchShortcut;", "Lcom/dw/launcher/ui/shortcut/SwitchShortcut;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mItemView", "Landroid/view/View;", "getMItemView", "()Landroid/view/View;", "setMItemView", "(Landroid/view/View;)V", "bind", "", "view", "onClicked", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class PowerSaveSwitchShortcut extends SwitchShortcut {
    private final Context context;
    private View mItemView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PowerSaveSwitchShortcut(Context context) {
        super(R.drawable.top_shortcut_super_power);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final View getMItemView() {
        return this.mItemView;
    }

    public final void setMItemView(View view) {
        this.mItemView = view;
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void bind(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.bind(view);
        this.mItemView = view;
        if (view != null) {
            view.setSelected(false);
        }
        View view2 = this.mItemView;
        if (view2 != null) {
            view2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.shortcut.PowerSaveSwitchShortcut$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view3) {
                    return PowerSaveSwitchShortcut.bind$lambda$0(view3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0(View view) {
        PowerManagerHelper.setPowerSavingMode();
        return true;
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void onClicked(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PowerManagerHelper.setPowerSavingMode();
    }
}
