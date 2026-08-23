package com.dw.launcher.data.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.repository.IShortcutRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: PackageManagerComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/dw/launcher/data/component/PackageManagerComponent;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "repository", "Lcom/dw/launcher/data/repository/IShortcutRepository;", "(Landroid/content/Context;Lcom/dw/launcher/data/repository/IShortcutRepository;)V", "mLocaleChangedReceiver", "com/dw/launcher/data/component/PackageManagerComponent$mLocaleChangedReceiver$1", "Lcom/dw/launcher/data/component/PackageManagerComponent$mLocaleChangedReceiver$1;", "mPackageChangedReceiver", "com/dw/launcher/data/component/PackageManagerComponent$mPackageChangedReceiver$1", "Lcom/dw/launcher/data/component/PackageManagerComponent$mPackageChangedReceiver$1;", "init", BuildConfig.FLAVOR, "install", "uninstall", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PackageManagerComponent {
    private final Context context;
    private final PackageManagerComponent$mLocaleChangedReceiver$1 mLocaleChangedReceiver;
    private final PackageManagerComponent$mPackageChangedReceiver$1 mPackageChangedReceiver;
    private final IShortcutRepository repository;

    /* JADX WARN: Type inference failed for: r2v1, types: [com.dw.launcher.data.component.PackageManagerComponent$mPackageChangedReceiver$1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.dw.launcher.data.component.PackageManagerComponent$mLocaleChangedReceiver$1] */
    @Inject
    public PackageManagerComponent(Context context, IShortcutRepository iShortcutRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iShortcutRepository, "repository");
        this.context = context;
        this.repository = iShortcutRepository;
        this.mPackageChangedReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.data.component.PackageManagerComponent$mPackageChangedReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String action = intent.getAction();
                if (action != null) {
                    PackageManagerComponent packageManagerComponent = this.this$0;
                    Timber.Forest.d("----action: " + action + ", extra: " + intent.getExtras(), new Object[0]);
                    packageManagerComponent.init();
                }
            }
        };
        this.mLocaleChangedReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.data.component.PackageManagerComponent$mLocaleChangedReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String action = intent.getAction();
                if (action != null) {
                    PackageManagerComponent packageManagerComponent = this.this$0;
                    Timber.Forest.d("----action: " + action + ", extra: " + intent.getExtras(), new Object[0]);
                    packageManagerComponent.init();
                }
            }
        };
    }

    public final void install() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        this.context.registerReceiver(this.mPackageChangedReceiver, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.LOCALE_CHANGED");
        this.context.registerReceiver(this.mLocaleChangedReceiver, intentFilter2);
    }

    public final void uninstall() {
        this.context.unregisterReceiver(this.mPackageChangedReceiver);
        this.context.unregisterReceiver(this.mLocaleChangedReceiver);
    }

    public final void init() {
        Log.i("lkang", "---init, reload shortcuts");
        this.repository.reload();
    }
}
