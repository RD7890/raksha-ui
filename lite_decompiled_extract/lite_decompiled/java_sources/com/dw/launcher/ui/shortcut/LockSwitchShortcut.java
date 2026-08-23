package com.dw.launcher.ui.shortcut;

import android.content.Context;
import android.view.View;
import com.dw.launcher.R;
import com.dw.launcher.data.preference.LauncherPreference;
import com.google.android.mms.pdu.CharacterSets;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LockSwitchShortcut.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/dw/launcher/ui/shortcut/LockSwitchShortcut;", "Lcom/dw/launcher/ui/shortcut/SwitchShortcut;", "()V", "mItemView", "Landroid/view/View;", "mPreference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "getMPreference", "()Lcom/dw/launcher/data/preference/LauncherPreference;", "setMPreference", "(Lcom/dw/launcher/data/preference/LauncherPreference;)V", "bind", "", "view", "onClicked", "context", "Landroid/content/Context;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class LockSwitchShortcut extends SwitchShortcut {
    private View mItemView;

    @Inject
    public LauncherPreference mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onClicked$lambda$1(View view) {
        return true;
    }

    @Inject
    public LockSwitchShortcut() {
        super(R.drawable.top_shortcut_svg_lock);
    }

    public final LauncherPreference getMPreference() {
        LauncherPreference launcherPreference = this.mPreference;
        if (launcherPreference != null) {
            return launcherPreference;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPreference");
        return null;
    }

    public final void setMPreference(LauncherPreference launcherPreference) {
        Intrinsics.checkNotNullParameter(launcherPreference, "<set-?>");
        this.mPreference = launcherPreference;
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void onClicked(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View view = this.mItemView;
        if (view != null) {
            view.setSelected(!view.isSelected());
            getMPreference().setClockLocked(view.isSelected());
        }
        View view2 = this.mItemView;
        if (view2 != null) {
            view2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.shortcut.LockSwitchShortcut$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view3) {
                    return LockSwitchShortcut.onClicked$lambda$1(view3);
                }
            });
        }
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void bind(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.bind(view);
        this.mItemView = view;
        setSelected(getMPreference().isClockLocked());
        view.setSelected(getSelected());
    }
}
