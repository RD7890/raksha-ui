package com.dw.launcher.ui.shortcut;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.dw.launcher.R;
import com.dw.launcher.core.component.VoiceComponent;
import com.dw.launcher.ui.view.VolumeAdjustDialog;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VolumnSwitchShortcut.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/dw/launcher/ui/shortcut/VolumnSwitchShortcut;", "Lcom/dw/launcher/ui/shortcut/SwitchShortcut;", "context", "Landroid/app/Activity;", "voiceComponent", "Lcom/dw/launcher/core/component/VoiceComponent;", "(Landroid/app/Activity;Lcom/dw/launcher/core/component/VoiceComponent;)V", "getContext", "()Landroid/app/Activity;", "mItemView", "Landroid/view/View;", "getMItemView", "()Landroid/view/View;", "setMItemView", "(Landroid/view/View;)V", "bind", "", "view", "onClicked", "context2", "Landroid/content/Context;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class VolumnSwitchShortcut extends SwitchShortcut {
    private final Activity context;
    private View mItemView;
    private final VoiceComponent voiceComponent;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0(View view) {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VolumnSwitchShortcut(Activity context, VoiceComponent voiceComponent) {
        super(R.drawable.top_voice);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(voiceComponent, "voiceComponent");
        this.context = context;
        this.voiceComponent = voiceComponent;
    }

    public final Activity getContext() {
        return this.context;
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
        view.setSelected(false);
        this.mItemView = view;
        if (view != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.shortcut.VolumnSwitchShortcut$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    return VolumnSwitchShortcut.bind$lambda$0(view2);
                }
            });
        }
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void onClicked(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context2");
        try {
            new VolumeAdjustDialog(this.context, this.voiceComponent).show();
        } catch (Exception unused) {
        }
    }
}
