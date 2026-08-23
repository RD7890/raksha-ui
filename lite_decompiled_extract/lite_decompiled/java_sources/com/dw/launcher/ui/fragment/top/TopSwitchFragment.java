package com.dw.launcher.ui.fragment.top;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.ui.shortcut.LockSwitchShortcut;
import com.dw.launcher.ui.shortcut.SwitchShortcut;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TopSwitchFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00020\u0005`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/dw/launcher/ui/fragment/top/TopSwitchFragment;", "Lcom/dw/launcher/base/BaseFragment;", "()V", "mAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/ui/shortcut/SwitchShortcut;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "mLockSwitchShortcut", "Lcom/dw/launcher/ui/shortcut/LockSwitchShortcut;", "getMLockSwitchShortcut", "()Lcom/dw/launcher/ui/shortcut/LockSwitchShortcut;", "setMLockSwitchShortcut", "(Lcom/dw/launcher/ui/shortcut/LockSwitchShortcut;)V", "mSwitches", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class TopSwitchFragment extends Hilt_TopSwitchFragment {
    private BaseQuickAdapter<SwitchShortcut, BaseViewHolder> mAdapter;

    @Inject
    public LockSwitchShortcut mLockSwitchShortcut;
    private final ArrayList<SwitchShortcut> mSwitches = new ArrayList<>();

    public final LockSwitchShortcut getMLockSwitchShortcut() {
        LockSwitchShortcut lockSwitchShortcut = this.mLockSwitchShortcut;
        if (lockSwitchShortcut != null) {
            return lockSwitchShortcut;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLockSwitchShortcut");
        return null;
    }

    public final void setMLockSwitchShortcut(LockSwitchShortcut lockSwitchShortcut) {
        Intrinsics.checkNotNullParameter(lockSwitchShortcut, "<set-?>");
        this.mLockSwitchShortcut = lockSwitchShortcut;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_top_switch, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.mSwitches.clear();
        RecyclerView recyclerViewFindViewById = view.findViewById(R.id.top_switch_list);
        recyclerViewFindViewById.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        RecyclerView.Adapter adapter = (BaseQuickAdapter) new BaseQuickAdapter<SwitchShortcut, BaseViewHolder>(R.layout.switch_item_shortcut, this.mSwitches) { // from class: com.dw.launcher.ui.fragment.top.TopSwitchFragment.onViewCreated.1
            {
                ArrayList<SwitchShortcut> arrayList = arrayList;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void convert(BaseViewHolder holder, SwitchShortcut item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                holder.setImageResource(R.id.switch_shortcut_switch, item.getDrawableResource());
                holder.getView(R.id.switch_shortcut_switch).setSelected(item.getSelected());
                View itemView = holder.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                item.bind(itemView);
            }
        };
        this.mAdapter = adapter;
        recyclerViewFindViewById.setAdapter(adapter);
        BaseQuickAdapter<SwitchShortcut, BaseViewHolder> baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            baseQuickAdapter = null;
        }
        baseQuickAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.dw.launcher.ui.fragment.top.TopSwitchFragment$$ExternalSyntheticLambda0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter2, View view2, int i) {
                TopSwitchFragment.onViewCreated$lambda$0(this.f$0, baseQuickAdapter2, view2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(TopSwitchFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        SwitchShortcut switchShortcut = this$0.mSwitches.get(i);
        Intrinsics.checkNotNullExpressionValue(switchShortcut, "get(...)");
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        switchShortcut.onClicked(contextRequireContext);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
