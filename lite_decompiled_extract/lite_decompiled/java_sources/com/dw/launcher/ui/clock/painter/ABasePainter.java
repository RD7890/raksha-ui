package com.dw.launcher.ui.clock.painter;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ABasePainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J!\u0010\u0015\u001a\u00020\n2\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "Lcom/dw/launcher/ui/clock/painter/IBasePainter;", "()V", "supportScale", "", "getSupportScale", "()Z", "setSupportScale", "(Z)V", "drawDrawable", "", "canvas", "Landroid/graphics/Canvas;", "drawable", "Landroid/graphics/drawable/Drawable;", "x", "", "y", "scaleX", "", "scaleY", "updateParams", "params", "", "", "([Ljava/lang/Object;)V", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public abstract class ABasePainter implements IBasePainter {
    private boolean supportScale;

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void updateParams(Object... params) {
        Intrinsics.checkNotNullParameter(params, "params");
    }

    public final boolean getSupportScale() {
        return this.supportScale;
    }

    public final void setSupportScale(boolean z) {
        this.supportScale = z;
    }

    public final void drawDrawable(Canvas canvas, Drawable drawable, int x, int y, float scaleX, float scaleY) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        drawable.setBounds(x, y, ((int) (drawable.getIntrinsicWidth() * scaleX)) + x, ((int) (drawable.getIntrinsicHeight() * scaleY)) + y);
        drawable.draw(canvas);
    }
}
