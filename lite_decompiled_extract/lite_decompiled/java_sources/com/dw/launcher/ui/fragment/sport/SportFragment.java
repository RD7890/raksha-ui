package com.dw.launcher.ui.fragment.sport;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.ActivityType;
import com.dw.launcher.data.entity.SportData;
import com.dw.launcher.ui.fragment.heart.ZoomCenterItemDecoration;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: SportFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/dw/launcher/ui/fragment/sport/SportFragment;", "Lcom/dw/launcher/base/BaseFragment;", "()V", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getLayoutId", "", "onAttach", "", "context", "Landroid/content/Context;", "onDetach", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class SportFragment extends Hilt_SportFragment {
    private RecyclerView mRecyclerView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(SportFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [T, java.util.List] */
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.mRecyclerView = view.findViewById(R.id.recycler_view);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        ((List) objectRef.element).add(new SportData(ActivityType.RUNNING.getValue()));
        ((List) objectRef.element).add(new SportData(ActivityType.JUMP_ROPE.getValue()));
        ((List) objectRef.element).add(new SportData(ActivityType.SIT_UP.getValue()));
        ((List) objectRef.element).add(new SportData(ActivityType.JIANZI.getValue()));
        ((List) objectRef.element).add(new SportData(ActivityType.SQUAT_JUMP.getValue()));
        ((List) objectRef.element).add(new SportData(ActivityType.HIGH_KNEES.getValue()));
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.to(Integer.valueOf(ActivityType.RUNNING.getValue()), getString(R.string.running)), TuplesKt.to(Integer.valueOf(ActivityType.JUMP_ROPE.getValue()), getString(R.string.jump_rope)), TuplesKt.to(Integer.valueOf(ActivityType.SIT_UP.getValue()), getString(R.string.sit_up)), TuplesKt.to(Integer.valueOf(ActivityType.JIANZI.getValue()), getString(R.string.jianzi)), TuplesKt.to(Integer.valueOf(ActivityType.SQUAT_JUMP.getValue()), getString(R.string.squat_jump)), TuplesKt.to(Integer.valueOf(ActivityType.HIGH_KNEES.getValue()), getString(R.string.high_knees)));
        final Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to(Integer.valueOf(ActivityType.RUNNING.getValue()), Integer.valueOf(R.mipmap.item_sport)), TuplesKt.to(Integer.valueOf(ActivityType.JUMP_ROPE.getValue()), Integer.valueOf(R.mipmap.item_rope)), TuplesKt.to(Integer.valueOf(ActivityType.SIT_UP.getValue()), Integer.valueOf(R.mipmap.item_situp)), TuplesKt.to(Integer.valueOf(ActivityType.JIANZI.getValue()), Integer.valueOf(R.mipmap.item_shuttlecock)), TuplesKt.to(Integer.valueOf(ActivityType.SQUAT_JUMP.getValue()), Integer.valueOf(R.mipmap.item_squatjump)), TuplesKt.to(Integer.valueOf(ActivityType.HIGH_KNEES.getValue()), Integer.valueOf(R.mipmap.item_highleg)));
        final int i = R.layout.item_sport;
        RecyclerView.Adapter adapter = new BaseQuickAdapter<SportData, BaseViewHolder>(objectRef, mapMapOf, mapMapOf2, i) { // from class: com.dw.launcher.ui.fragment.sport.SportFragment$onViewCreated$adapter$1
            final /* synthetic */ Map<Integer, Integer> $activityImageMap;
            final /* synthetic */ Map<Integer, String> $activityMap;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(i, objectRef.element);
                this.$activityMap = mapMapOf;
                this.$activityImageMap = mapMapOf2;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void convert(BaseViewHolder holder, SportData item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                holder.setText(R.id.label, this.$activityMap.get(Integer.valueOf(item.getType())));
                Integer num = this.$activityImageMap.get(Integer.valueOf(item.getType()));
                if (num != null) {
                    holder.setBackgroundResource(R.id.ivType, num.intValue());
                }
            }
        };
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setAdapter(adapter);
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.addItemDecoration(new ZoomCenterItemDecoration(getContext()));
        }
        adapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.dw.launcher.ui.fragment.sport.SportFragment$$ExternalSyntheticLambda0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i2) {
                SportFragment.onViewCreated$lambda$1(this.f$0, baseQuickAdapter, view2, i2);
            }
        });
    }

    public int getLayoutId() {
        return R.layout.fragment_sport;
    }

    @Override // com.dw.launcher.ui.fragment.sport.Hilt_SportFragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }
}
