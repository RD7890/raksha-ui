package com.dw.launcher.ui.shortcut;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.repository.LauncherRepository;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: SettingsSwitchShortcut.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/dw/launcher/ui/shortcut/SettingsSwitchShortcut;", "Lcom/dw/launcher/ui/shortcut/SwitchShortcut;", "context", "Landroid/content/Context;", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "(Landroid/content/Context;Lcom/dw/launcher/data/repository/LauncherRepository;)V", "getContext", "()Landroid/content/Context;", "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "mItemView", "Landroid/view/View;", "getMItemView", "()Landroid/view/View;", "setMItemView", "(Landroid/view/View;)V", "bind", "", "view", "onClicked", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class SettingsSwitchShortcut extends SwitchShortcut {
    private final Context context;
    private final LauncherRepository launcherRepository;
    private View mItemView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsSwitchShortcut(Context context, LauncherRepository launcherRepository) {
        super(R.drawable.top_shortcut_settings);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(launcherRepository, "launcherRepository");
        this.context = context;
        this.launcherRepository = launcherRepository;
    }

    public final Context getContext() {
        return this.context;
    }

    public final LauncherRepository getLauncherRepository() {
        return this.launcherRepository;
    }

    public final View getMItemView() {
        return this.mItemView;
    }

    public final void setMItemView(View view) {
        this.mItemView = view;
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void bind(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.bind(view);
        this.mItemView = view;
        if (view != null) {
            view.setSelected(false);
        }
        View view2 = this.mItemView;
        if (view2 != null) {
            view2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.shortcut.SettingsSwitchShortcut$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view3) {
                    return SettingsSwitchShortcut.bind$lambda$1(this.f$0, view3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$1(SettingsSwitchShortcut this$0, View view) {
        Boolean boolValueOf;
        boolean z;
        String statusBarSet_packageName;
        String statusBarSet_className;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        LaunchConfig launchConfigLoadConfig = this$0.launcherRepository.loadConfig();
        if (launchConfigLoadConfig != null) {
            if (launchConfigLoadConfig.getUserHandleStatusBarSet() != 1 || (statusBarSet_packageName = launchConfigLoadConfig.getStatusBarSet_packageName()) == null || statusBarSet_packageName.length() <= 0 || (statusBarSet_className = launchConfigLoadConfig.getStatusBarSet_className()) == null || statusBarSet_className.length() <= 0) {
                z = false;
            } else {
                intent.setClassName(launchConfigLoadConfig.getStatusBarSet_packageName(), launchConfigLoadConfig.getStatusBarSet_className());
                intent.setFlags(268435456);
                this$0.context.startActivity(intent);
                Timber.INSTANCE.d("跳转1.。。。。。。", new Object[0]);
                z = true;
            }
            boolValueOf = Boolean.valueOf(z);
        } else {
            boolValueOf = null;
        }
        if (Intrinsics.areEqual((Object) boolValueOf, (Object) false)) {
            intent.setClassName("com.android.settings", "com.android.settings.Settings");
            intent.setFlags(268435456);
            this$0.context.startActivity(intent);
            Timber.INSTANCE.d("跳转2.。。。。。。", new Object[0]);
        }
        return true;
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void onClicked(Context context) {
        Boolean boolValueOf;
        String statusBarSet_packageName;
        String statusBarSet_className;
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        LaunchConfig launchConfigLoadConfig = this.launcherRepository.loadConfig();
        if (launchConfigLoadConfig != null) {
            boolean z = true;
            if (launchConfigLoadConfig.getUserHandleStatusBarSet() != 1 || (statusBarSet_packageName = launchConfigLoadConfig.getStatusBarSet_packageName()) == null || statusBarSet_packageName.length() <= 0 || (statusBarSet_className = launchConfigLoadConfig.getStatusBarSet_className()) == null || statusBarSet_className.length() <= 0) {
                z = false;
            } else {
                intent.setClassName(launchConfigLoadConfig.getStatusBarSet_packageName(), launchConfigLoadConfig.getStatusBarSet_className());
                intent.setFlags(268435456);
                context.startActivity(intent);
            }
            boolValueOf = Boolean.valueOf(z);
        } else {
            boolValueOf = null;
        }
        if (Intrinsics.areEqual((Object) boolValueOf, (Object) false)) {
            intent.setClassName("com.android.settings", "com.android.settings.Settings");
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }
}
