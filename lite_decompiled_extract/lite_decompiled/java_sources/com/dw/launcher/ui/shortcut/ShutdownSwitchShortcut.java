package com.dw.launcher.ui.shortcut;

import android.content.Context;
import android.content.Intent;
import com.dw.launcher.R;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShutdownSwitchShortcut.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/dw/launcher/ui/shortcut/ShutdownSwitchShortcut;", "Lcom/dw/launcher/ui/shortcut/SwitchShortcut;", "()V", "onClicked", "", "context", "Landroid/content/Context;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ShutdownSwitchShortcut extends SwitchShortcut {
    public ShutdownSwitchShortcut() {
        super(R.drawable.top_shortcut_svg_shutdown);
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void onClicked(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.setClassName("com.android.systemui", "com.android.systemui.SosAndShutdownActivity");
        intent.setFlags(268435456);
        context.startActivity(intent);
    }
}
