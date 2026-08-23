package com.dw.launcher.ui.clock.painter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.airbnb.lottie.LottieDrawable;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LottiePainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/LottiePainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "drawable", "Lcom/airbnb/lottie/LottieDrawable;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "view", "Landroid/view/View;", "(Lcom/airbnb/lottie/LottieDrawable;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;Landroid/view/View;)V", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "start", "stop", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class LottiePainter extends ABasePainter {
    private final LottieDrawable drawable;
    private final ClockConfigFlatter flatter;
    private final View view;

    public LottiePainter(LottieDrawable drawable, ClockConfigFlatter flatter, View view) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        Intrinsics.checkNotNullParameter(view, "view");
        this.drawable = drawable;
        this.flatter = flatter;
        this.view = view;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public final void start() {
        this.drawable.setRepeatCount(-1);
        this.drawable.start();
    }

    public final void stop() {
        this.drawable.stop();
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.drawable.getBounds().width() <= 0 || this.drawable.getBounds().height() <= 0) {
            this.drawable.setBounds(0, 0, this.view.getWidth(), this.view.getHeight());
        }
        this.drawable.draw(canvas);
    }
}
