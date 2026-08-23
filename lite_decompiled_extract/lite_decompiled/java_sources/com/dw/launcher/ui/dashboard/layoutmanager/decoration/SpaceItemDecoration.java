package com.dw.launcher.ui.dashboard.layoutmanager.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int bottomSpace;
    private int itemsPerRow;
    private int topSpace;

    public SpaceItemDecoration(Context context, int startSpace, int endSpace, int itemsPerRow) {
        this.topSpace = startSpace;
        this.bottomSpace = endSpace;
        this.itemsPerRow = itemsPerRow;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int itemCount = parent.getAdapter().getItemCount();
        int i = childAdapterPosition / this.itemsPerRow;
        if (i == 0) {
            outRect.top = this.topSpace;
        }
        if (i == (itemCount - 1) / this.itemsPerRow) {
            outRect.bottom = this.bottomSpace;
        }
    }
}
