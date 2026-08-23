package com.dw.launcher.ui.fragment.heart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class ZoomCenterItemDecoration extends RecyclerView.ItemDecoration {
    private static final float SCALE_FACTOR = 0.5f;
    Context context;
    private Paint paint;

    public ZoomCenterItemDecoration(Context context) {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.context = context;
    }

    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        for (int i = 0; i < parent.getChildCount(); i++) {
            View childAt = parent.getChildAt(i);
            if (childAt.getTop() < 0 || childAt.getBottom() > parent.getHeight()) {
                if (childAt.getTop() < 0) {
                    float fAbs = 1.0f - ((Math.abs(0 - childAt.getTop()) * 0.5f) / childAt.getHeight());
                    float height = childAt.getHeight();
                    childAt.setScaleX(fAbs);
                    childAt.setScaleY(fAbs);
                    childAt.setTranslationY(((height - (height * fAbs)) / 2.0f) - 1.0f);
                } else {
                    float fAbs2 = 1.0f - ((Math.abs(childAt.getBottom() - parent.getHeight()) * 0.5f) / childAt.getHeight());
                    float height2 = childAt.getHeight();
                    childAt.setScaleX(fAbs2);
                    childAt.setScaleY(fAbs2);
                    childAt.setTranslationY(((-(height2 - (height2 * fAbs2))) / 2.0f) + 1.0f);
                }
            } else {
                childAt.setScaleX(1.0f);
                childAt.setScaleY(1.0f);
                childAt.setTranslationY(0.0f);
            }
        }
    }
}
