package com.dw.launcher.ui.shortcut;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.dw.launcher.R;
import com.dw.launcher.data.component.BluetoothComponent;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BluetoothSwitchShortcut.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/dw/launcher/ui/shortcut/BluetoothSwitchShortcut;", "Lcom/dw/launcher/ui/shortcut/SwitchShortcut;", "context", "Landroid/content/Context;", "mBluetoothComponent", "Lcom/dw/launcher/data/component/BluetoothComponent;", "(Landroid/content/Context;Lcom/dw/launcher/data/component/BluetoothComponent;)V", "getContext", "()Landroid/content/Context;", "mItemView", "Landroid/view/View;", "getMItemView", "()Landroid/view/View;", "setMItemView", "(Landroid/view/View;)V", "bind", "", "view", "notifyDataChanged", "select", "", "onClicked", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class BluetoothSwitchShortcut extends SwitchShortcut {
    private final Context context;
    private final BluetoothComponent mBluetoothComponent;
    private View mItemView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BluetoothSwitchShortcut(Context context, BluetoothComponent mBluetoothComponent) {
        super(R.drawable.top_shortcut_bluetooth_2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mBluetoothComponent, "mBluetoothComponent");
        this.context = context;
        this.mBluetoothComponent = mBluetoothComponent;
    }

    public final Context getContext() {
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
        super.bind(view);
        this.mItemView = view;
        setSelected(this.mBluetoothComponent.isEnable());
        View view2 = this.mItemView;
        if (view2 != null) {
            view2.setSelected(getSelected());
        }
        View view3 = this.mItemView;
        if (view3 != null) {
            view3.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.shortcut.BluetoothSwitchShortcut$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view4) {
                    return BluetoothSwitchShortcut.bind$lambda$0(this.f$0, view4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0(BluetoothSwitchShortcut this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.bluetooth.BluetoothSettings"));
            intent.setFlags(268435456);
            this$0.context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void onClicked(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.mBluetoothComponent.isEnable()) {
            View view = this.mItemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.ImageView");
            ((ImageView) view).setImageResource(R.drawable.top_shortcut_bluetooth_2);
        } else {
            View view2 = this.mItemView;
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.widget.ImageView");
            ((ImageView) view2).setImageResource(R.drawable.bluetooth_connect);
            View view3 = this.mItemView;
            Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) view3;
            Drawable drawable = imageView != null ? imageView.getDrawable() : null;
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            ((AnimationDrawable) drawable).start();
        }
        this.mBluetoothComponent.toggle();
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void notifyDataChanged(boolean select) {
        setSelected(this.mBluetoothComponent.isEnable());
        View view = this.mItemView;
        if (view != null) {
            view.setSelected(getSelected());
        }
        View view2 = this.mItemView;
        if (view2 != null) {
            ((ImageView) view2).clearAnimation();
            View view3 = this.mItemView;
            Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) view3;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.top_shortcut_bluetooth_2);
            }
        }
    }
}
