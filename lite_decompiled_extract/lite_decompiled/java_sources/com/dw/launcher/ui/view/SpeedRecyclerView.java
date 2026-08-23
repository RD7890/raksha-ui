package com.dw.launcher.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class SpeedRecyclerView extends RecyclerView {
    private static final int FLING_MAX_VELOCITY = 8000;
    private static final float FLING_SCALE_DOWN_FACTOR = 0.5f;

    public SpeedRecyclerView(Context context) {
        super(context);
    }

    public SpeedRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SpeedRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public boolean fling(int velocityX, int velocityY) {
        return super.fling(solveVelocity(velocityX), solveVelocity(velocityY));
    }

    private int solveVelocity(int velocity) {
        if (velocity > 0) {
            return Math.min(velocity, FLING_MAX_VELOCITY);
        }
        return Math.max(velocity, -8000);
    }
}
