package com.dw.launcher.ui.transform;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: ScaleInTransformer.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/dw/launcher/ui/transform/ScaleInTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "()V", "DEFAULT_CENTER", "", "DEFAULT_MIN_SCALE", "transformPage", "", "view", "Landroid/view/View;", "position", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ScaleInTransformer implements ViewPager2.PageTransformer {
    private final float DEFAULT_MIN_SCALE = 0.8f;
    private final float DEFAULT_CENTER = 0.5f;

    public void transformPage(View view, float position) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setElevation(-Math.abs(position));
        int width = view.getWidth();
        view.setPivotY(view.getHeight() / 2.0f);
        float f = width;
        view.setPivotX(f / 2.0f);
        if (position < -1.0f) {
            view.setScaleX(this.DEFAULT_MIN_SCALE);
            view.setScaleY(this.DEFAULT_MIN_SCALE);
            view.setPivotX(f);
        } else if (position > 1.0f) {
            view.setPivotX(0.0f);
            view.setScaleX(this.DEFAULT_MIN_SCALE);
            view.setScaleY(this.DEFAULT_MIN_SCALE);
        } else if (position < 0.0f) {
            float f2 = 1;
            float f3 = this.DEFAULT_MIN_SCALE;
            float f4 = ((f2 + position) * (f2 - f3)) + f3;
            view.setScaleX(f4);
            view.setScaleY(f4);
            float f5 = this.DEFAULT_CENTER;
            view.setPivotX(f * (f5 + ((-position) * f5)));
        } else {
            float f6 = 1;
            float f7 = f6 - position;
            float f8 = this.DEFAULT_MIN_SCALE;
            float f9 = ((f6 - f8) * f7) + f8;
            view.setScaleX(f9);
            view.setScaleY(f9);
            view.setPivotX(f * f7 * this.DEFAULT_CENTER);
        }
        Timber.INSTANCE.d("scaleX " + view.getScaleX() + " scaleY =" + view.getScaleY(), new Object[0]);
    }
}
