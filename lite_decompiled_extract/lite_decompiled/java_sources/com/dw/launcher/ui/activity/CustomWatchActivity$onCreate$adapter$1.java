package com.dw.launcher.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.Image;
import com.google.android.mms.pdu.CharacterSets;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomWatchActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/dw/launcher/ui/activity/CustomWatchActivity$onCreate$adapter$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Image;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class CustomWatchActivity$onCreate$adapter$1 extends BaseQuickAdapter<Image, BaseViewHolder> {
    final /* synthetic */ CustomWatchActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomWatchActivity$onCreate$adapter$1(CustomWatchActivity customWatchActivity, int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        this.this$0 = customWatchActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(final BaseViewHolder holder, final Image item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Glide.with(this.this$0).load(item.getPath()).centerCrop().into((ImageView) holder.getView(R.id.photo_preview));
        ImageView imageView = (ImageView) holder.getView(R.id.photo_preview);
        final CustomWatchActivity customWatchActivity = this.this$0;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.CustomWatchActivity$onCreate$adapter$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomWatchActivity$onCreate$adapter$1.convert$lambda$0(customWatchActivity, holder, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(CustomWatchActivity this$0, BaseViewHolder holder, Image item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.selectIndex = holder.getAdapterPosition();
        RelativeLayout relativeLayout = this$0.relativeLayout;
        ImageView imageView = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("relativeLayout");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(0);
        RequestBuilder requestBuilderLoad = Glide.with((FragmentActivity) this$0).load(item.getPath());
        ImageView imageView2 = this$0.backGround;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backGround");
        } else {
            imageView = imageView2;
        }
        requestBuilderLoad.into(imageView);
    }
}
