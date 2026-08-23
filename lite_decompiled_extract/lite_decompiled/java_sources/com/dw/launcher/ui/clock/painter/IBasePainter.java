package com.dw.launcher.ui.clock.painter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;

/* JADX INFO: compiled from: IBasePainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J!\u0010\b\u001a\u00020\u00032\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n\"\u00020\u0001H&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/IBasePainter;", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "updateParams", "params", "", "([Ljava/lang/Object;)V", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public interface IBasePainter {
    void draw(Canvas canvas, Paint paint);

    void updateParams(Object... params);
}
