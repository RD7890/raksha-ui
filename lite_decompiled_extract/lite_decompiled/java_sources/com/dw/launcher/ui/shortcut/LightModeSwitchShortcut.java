package com.dw.launcher.ui.shortcut;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.dw.launcher.R;
import com.dw.launcher.data.component.BrightComponent;
import com.dw.launcher.ui.view.LightAdjustDialog;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: LightModeSwitchShortcut.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/dw/launcher/ui/shortcut/LightModeSwitchShortcut;", "Lcom/dw/launcher/ui/shortcut/SwitchShortcut;", "context", "Landroid/app/Activity;", "mBrightComponent", "Lcom/dw/launcher/data/component/BrightComponent;", "(Landroid/app/Activity;Lcom/dw/launcher/data/component/BrightComponent;)V", "getContext", "()Landroid/app/Activity;", "getMBrightComponent", "()Lcom/dw/launcher/data/component/BrightComponent;", "mItemView", "Landroid/view/View;", "getMItemView", "()Landroid/view/View;", "setMItemView", "(Landroid/view/View;)V", "bind", "", "view", "onClicked", "context2", "Landroid/content/Context;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class LightModeSwitchShortcut extends SwitchShortcut {
    private final Activity context;
    private final BrightComponent mBrightComponent;
    private View mItemView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0(View view) {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightModeSwitchShortcut(Activity context, BrightComponent mBrightComponent) {
        super(R.mipmap.icon_light);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mBrightComponent, "mBrightComponent");
        this.context = context;
        this.mBrightComponent = mBrightComponent;
    }

    public final Activity getContext() {
        return this.context;
    }

    public final BrightComponent getMBrightComponent() {
        return this.mBrightComponent;
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
        view.setSelected(false);
        this.mItemView = view;
        if (view != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.shortcut.LightModeSwitchShortcut$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    return LightModeSwitchShortcut.bind$lambda$0(view2);
                }
            });
        }
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void onClicked(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context2");
        try {
            Activity activity = this.context;
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.app.Activity");
            new LightAdjustDialog(activity, this.mBrightComponent).show();
        } catch (Exception e) {
            Timber.INSTANCE.e(e, "no wallpaper setter application found", new Object[0]);
        }
    }
}
