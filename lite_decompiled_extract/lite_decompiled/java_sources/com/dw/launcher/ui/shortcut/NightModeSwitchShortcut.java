package com.dw.launcher.ui.shortcut;

import android.content.Context;
import android.content.Intent;
import com.dw.launcher.R;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: NightModeSwitchShortcut.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/dw/launcher/ui/shortcut/NightModeSwitchShortcut;", "Lcom/dw/launcher/ui/shortcut/SwitchShortcut;", "()V", "onClicked", "", "context", "Landroid/content/Context;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class NightModeSwitchShortcut extends SwitchShortcut {
    public NightModeSwitchShortcut() {
        super(R.drawable.top_shortcut_svg_bedtime);
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void onClicked(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent("android.intent.action.SET_WALLPAPER");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(context.getPackageName());
            context.startActivity(intent);
        } catch (Exception e) {
            Timber.INSTANCE.e(e, "no wallpaper setter application found", new Object[0]);
        }
    }
}
