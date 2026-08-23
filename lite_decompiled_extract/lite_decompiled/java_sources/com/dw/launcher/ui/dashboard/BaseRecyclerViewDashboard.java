package com.dw.launcher.ui.dashboard;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.Shortcut;
import com.google.android.mms.pdu.CharacterSets;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseRecyclerViewDashboard.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0005H&J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\fH\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/dw/launcher/ui/dashboard/BaseRecyclerViewDashboard;", "Lcom/dw/launcher/ui/dashboard/BaseDashboard;", "()V", "mAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Shortcut;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "createLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getItemLayoutId", "", "getLayoutId", "onBindView", "", "holder", "item", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onShortcutsChanged", "shortcuts", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "scrollToPosition", "delta", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public abstract class BaseRecyclerViewDashboard extends BaseDashboard {
    private BaseQuickAdapter<Shortcut, BaseViewHolder> mAdapter;
    private RecyclerView recyclerView;

    public abstract RecyclerView.LayoutManager createLayoutManager();

    public abstract int getItemLayoutId();

    public abstract void onBindView(BaseViewHolder holder, Shortcut item);

    public int getLayoutId() {
        return R.layout.dashboard_linear;
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerViewFindViewById = view.findViewById(R.id.linear_recycler_view);
        Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = recyclerViewFindViewById;
        this.recyclerView = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(createLayoutManager());
        this.mAdapter = new BaseQuickAdapter<Shortcut, BaseViewHolder>(getItemLayoutId(), getShortcuts()) { // from class: com.dw.launcher.ui.dashboard.BaseRecyclerViewDashboard.onViewCreated.1
            /* JADX INFO: Access modifiers changed from: protected */
            public void convert(BaseViewHolder holder, Shortcut item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                holder.itemView.setTag(item);
                BaseRecyclerViewDashboard.this.onBindView(holder, item);
            }
        };
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setAdapter(this.mAdapter);
        final BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.dw.launcher.ui.dashboard.BaseRecyclerViewDashboard$$ExternalSyntheticLambda0
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter2, View view2, int i) {
                    BaseRecyclerViewDashboard.onViewCreated$lambda$1$lambda$0(baseQuickAdapter, this, baseQuickAdapter2, view2, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$lambda$0(BaseQuickAdapter adapter, BaseRecyclerViewDashboard this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        if (i < 0 || i >= adapter.getItemCount()) {
            return;
        }
        this$0.onShortcutClicked(this$0.getShortcuts().get(i));
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onShortcutsChanged(List<Shortcut> shortcuts) {
        Intrinsics.checkNotNullParameter(shortcuts, "shortcuts");
        BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.setNewInstance(getShortcuts());
            baseQuickAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == 24) {
            scrollToPosition(-1);
            return true;
        }
        if (keyCode == 25) {
            scrollToPosition(1);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private final void scrollToPosition(int delta) {
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        if (recyclerView.getChildCount() > 0) {
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView3 = null;
            }
            RecyclerView recyclerView4 = this.recyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView4 = null;
            }
            int iMax = Math.max(0, recyclerView3.getChildAdapterPosition(recyclerView4.getChildAt(0)) + delta);
            BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter = this.mAdapter;
            Intrinsics.checkNotNull(baseQuickAdapter);
            int iMin = Math.min(iMax, baseQuickAdapter.getItemCount() - 1);
            RecyclerView recyclerView5 = this.recyclerView;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView2 = recyclerView5;
            }
            recyclerView2.scrollToPosition(iMin);
        }
    }
}
