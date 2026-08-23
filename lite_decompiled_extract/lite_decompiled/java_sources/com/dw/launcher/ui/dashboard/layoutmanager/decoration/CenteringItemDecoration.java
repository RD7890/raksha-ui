package com.dw.launcher.ui.dashboard.layoutmanager.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class CenteringItemDecoration extends RecyclerView.ItemDecoration {
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int itemCount = parent.getAdapter().getItemCount();
        if (childAdapterPosition == 0) {
            outRect.top = (parent.getHeight() - view.getHeight()) / 2;
        } else if (childAdapterPosition == itemCount - 1) {
            outRect.bottom = (parent.getHeight() - view.getHeight()) / 2;
        }
    }
}
