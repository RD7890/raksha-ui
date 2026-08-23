package com.dw.launcher.ui.transform;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_ALPHA = 0.5f;
    private static final float MIN_SCALE = 0.8f;

    public void transformPage(View view, float position) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (position >= -1.0f && position <= 1.0f) {
            float fMax = Math.max(MIN_SCALE, 1.0f - Math.abs(position));
            float f = 1.0f - fMax;
            float f2 = (height * f) / 2.0f;
            float f3 = (width * f) / 2.0f;
            if (position < 0.0f) {
                view.setTranslationX(f3 - (f2 / 2.0f));
            } else {
                view.setTranslationX((-f3) + (f2 / 2.0f));
            }
            view.setScaleX(fMax);
            view.setScaleY(fMax);
        }
    }
}
