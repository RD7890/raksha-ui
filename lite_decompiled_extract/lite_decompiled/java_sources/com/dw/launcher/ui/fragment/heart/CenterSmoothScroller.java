package com.dw.launcher.ui.fragment.heart;

import android.content.Context;
import android.graphics.PointF;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class CenterSmoothScroller extends LinearSmoothScroller {
    private final RecyclerView recyclerView;

    protected int getVerticalSnapPreference() {
        return 1;
    }

    public CenterSmoothScroller(Context context, RecyclerView recyclerView) {
        super(context);
        this.recyclerView = recyclerView;
    }

    public PointF computeScrollVectorForPosition(int targetPosition) {
        return this.recyclerView.getLayoutManager().computeScrollVectorForPosition(targetPosition);
    }
}
