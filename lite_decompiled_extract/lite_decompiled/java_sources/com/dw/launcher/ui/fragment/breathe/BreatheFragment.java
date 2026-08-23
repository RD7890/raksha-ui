package com.dw.launcher.ui.fragment.breathe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.dw.launcher.R;
import com.dw.launcher.ui.activity.BreatheActivity;
import com.dw.launcher.ui.activity.BreatheSettingActivity;
import com.dw.launcher.ui.view.LowerPowerTipsDialog;
import com.dw.launcher.util.SystemUtils;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BreatheFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/dw/launcher/ui/fragment/breathe/BreatheFragment;", "Lcom/dw/launcher/base/BaseFragment;", "()V", "getLayoutId", "", "onAttach", "", "context", "Landroid/content/Context;", "onDetach", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class BreatheFragment extends Hilt_BreatheFragment {
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = (ImageView) view.findViewById(R.id.ivStart);
        ((ImageView) view.findViewById(R.id.ivSetting)).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.fragment.breathe.BreatheFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BreatheFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.fragment.breathe.BreatheFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BreatheFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(BreatheFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.requireContext(), (Class<?>) BreatheSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(BreatheFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SystemUtils systemUtils = SystemUtils.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (systemUtils.isLowPowerMode(contextRequireContext)) {
            Activity activityRequireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(activityRequireActivity, "requireActivity(...)");
            new LowerPowerTipsDialog(activityRequireActivity).show();
            return;
        }
        this$0.startActivity(new Intent(this$0.requireContext(), (Class<?>) BreatheActivity.class));
    }

    public int getLayoutId() {
        return R.layout.fragment_breathe;
    }

    @Override // com.dw.launcher.ui.fragment.breathe.Hilt_BreatheFragment
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
