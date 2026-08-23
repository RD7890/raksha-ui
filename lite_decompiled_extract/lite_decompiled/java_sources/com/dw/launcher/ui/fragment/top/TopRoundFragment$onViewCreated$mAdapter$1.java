package com.dw.launcher.ui.fragment.top;

import android.content.Context;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.ui.shortcut.SwitchShortcut;
import com.google.android.mms.pdu.CharacterSets;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TopRoundFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/dw/launcher/ui/fragment/top/TopRoundFragment$onViewCreated$mAdapter$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/ui/shortcut/SwitchShortcut;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class TopRoundFragment$onViewCreated$mAdapter$1 extends BaseQuickAdapter<SwitchShortcut, BaseViewHolder> {
    final /* synthetic */ TopRoundFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TopRoundFragment$onViewCreated$mAdapter$1(TopRoundFragment topRoundFragment, int i, ArrayList<SwitchShortcut> arrayList) {
        super(i, arrayList);
        this.this$0 = topRoundFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(BaseViewHolder holder, final SwitchShortcut item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        holder.setImageResource(R.id.switch_shortcut_switch, item.getDrawableResource());
        holder.getView(R.id.switch_shortcut_switch).setSelected(item.getSelected());
        item.bind(holder.getView(R.id.switch_shortcut_switch));
        View view = holder.getView(R.id.switch_shortcut_switch);
        final TopRoundFragment topRoundFragment = this.this$0;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.fragment.top.TopRoundFragment$onViewCreated$mAdapter$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TopRoundFragment$onViewCreated$mAdapter$1.convert$lambda$0(item, topRoundFragment, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(SwitchShortcut item, TopRoundFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        item.onClicked(contextRequireContext);
    }
}
