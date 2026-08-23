package com.dw.launcher.ui.shortcut;

import android.content.Context;
import android.view.View;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SwitchShortcut.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH&R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/dw/launcher/ui/shortcut/SwitchShortcut;", "", "drawableResource", "", "(I)V", "checkable", "", "getCheckable", "()Z", "setCheckable", "(Z)V", "clickable", "getClickable", "setClickable", "getDrawableResource", "()I", "selected", "getSelected", "setSelected", "bind", "", "view", "Landroid/view/View;", "notifyDataChanged", "onClicked", "context", "Landroid/content/Context;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public abstract class SwitchShortcut {
    private boolean checkable;
    private boolean clickable = true;
    private final int drawableResource;
    private boolean selected;

    public void bind(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public void notifyDataChanged(boolean selected) {
    }

    public abstract void onClicked(Context context);

    public SwitchShortcut(int i) {
        this.drawableResource = i;
    }

    public final int getDrawableResource() {
        return this.drawableResource;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    public final boolean getCheckable() {
        return this.checkable;
    }

    public final void setCheckable(boolean z) {
        this.checkable = z;
    }

    public final boolean getClickable() {
        return this.clickable;
    }

    public final void setClickable(boolean z) {
        this.clickable = z;
    }
}
