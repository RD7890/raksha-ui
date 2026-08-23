package com.dw.launcher.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import com.dw.launcher.R;
import com.dw.launcher.data.component.BluetoothComponent;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BluetoothView.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/dw/launcher/ui/view/BluetoothView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bluetoothComponent", "Lcom/dw/launcher/data/component/BluetoothComponent;", "getBluetoothComponent", "()Lcom/dw/launcher/data/component/BluetoothComponent;", "setBluetoothComponent", "(Lcom/dw/launcher/data/component/BluetoothComponent;)V", "bluetoothConnected", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "bluetoothNormal", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class BluetoothView extends Hilt_BluetoothView {

    @Inject
    public BluetoothComponent bluetoothComponent;
    private Drawable bluetoothConnected;
    private Drawable bluetoothNormal;

    public final BluetoothComponent getBluetoothComponent() {
        BluetoothComponent bluetoothComponent = this.bluetoothComponent;
        if (bluetoothComponent != null) {
            return bluetoothComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bluetoothComponent");
        return null;
    }

    public final void setBluetoothComponent(BluetoothComponent bluetoothComponent) {
        Intrinsics.checkNotNullParameter(bluetoothComponent, "<set-?>");
        this.bluetoothComponent = bluetoothComponent;
    }

    public BluetoothView(Context context) {
        super(context);
        this.bluetoothNormal = getContext().getDrawable(R.drawable.icon_bluetooth);
        this.bluetoothConnected = getContext().getDrawable(R.drawable.icon_bluetooth_contected);
    }

    public BluetoothView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bluetoothNormal = getContext().getDrawable(R.drawable.icon_bluetooth);
        this.bluetoothConnected = getContext().getDrawable(R.drawable.icon_bluetooth_contected);
    }

    public BluetoothView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bluetoothNormal = getContext().getDrawable(R.drawable.icon_bluetooth);
        this.bluetoothConnected = getContext().getDrawable(R.drawable.icon_bluetooth_contected);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Log.i("lkang", "bluetooth bluetoothComponent.isConnected() = " + getBluetoothComponent().isConnected());
        if (getBluetoothComponent().isConnected()) {
            drawable = this.bluetoothConnected;
        } else {
            drawable = this.bluetoothNormal;
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
        }
    }
}
