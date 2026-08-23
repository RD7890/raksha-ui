package com.dw.launcher.ui.fragment.clock;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class ViewPagerLayoutManager extends LinearLayoutManager {
    private final int offscreenPageLimit;

    public boolean requestChildRectangleOnScreen(RecyclerView parent, View child, Rect rect, boolean immediate, boolean focusedChildVisible) {
        return false;
    }

    ViewPagerLayoutManager(Context context, int offscreenPageLimit) {
        super(context, 0, false);
        this.offscreenPageLimit = offscreenPageLimit;
    }

    protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] extraLayoutSpace) {
        int i = this.offscreenPageLimit;
        if (i == -1) {
            super.calculateExtraLayoutSpace(state, extraLayoutSpace);
            return;
        }
        int pageSize = getPageSize() * i;
        extraLayoutSpace[0] = pageSize;
        extraLayoutSpace[1] = pageSize;
    }

    int getPageSize() {
        if (getOrientation() == 0) {
            return getWidth();
        }
        return getHeight();
    }
}
