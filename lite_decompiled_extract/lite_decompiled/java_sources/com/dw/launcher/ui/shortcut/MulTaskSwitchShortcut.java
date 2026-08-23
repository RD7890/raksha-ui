package com.dw.launcher.ui.shortcut;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.dw.launcher.R;
import com.dw.launcher.data.config.AppFilterConfig;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: MulTaskSwitchShortcut.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/dw/launcher/ui/shortcut/MulTaskSwitchShortcut;", "Lcom/dw/launcher/ui/shortcut/SwitchShortcut;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mItemView", "Landroid/view/View;", "bind", "", "view", "onClicked", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class MulTaskSwitchShortcut extends SwitchShortcut {
    private final Context context;
    private View mItemView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0(View view) {
        return true;
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MulTaskSwitchShortcut(Context context) {
        super(R.drawable.top_shortcut_multask);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void bind(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mItemView = view;
        if (view != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.shortcut.MulTaskSwitchShortcut$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    return MulTaskSwitchShortcut.bind$lambda$0(view2);
                }
            });
        }
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void onClicked(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.dw.recents", "com.dw.recents.presentation.view.activity.TaskListActivity"));
            if (AppFilterConfig.INSTANCE.isIntentAvailable(context, intent)) {
                intent.setFlags(268435456);
                context.startActivity(intent);
            } else {
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName("com.android.systemui", "com.android.systemui.recents.RecentsActivity"));
                intent2.setFlags(268435456);
                context.startActivity(intent2);
            }
        } catch (Exception e) {
            Timber.INSTANCE.e(e, "no wallpaper setter application found", new Object[0]);
        }
    }
}
