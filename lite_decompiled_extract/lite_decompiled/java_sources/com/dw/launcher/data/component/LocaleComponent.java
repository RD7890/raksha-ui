package com.dw.launcher.data.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocaleComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\n\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/dw/launcher/data/component/LocaleComponent;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mListeners", "Ljava/util/ArrayList;", "Lcom/dw/launcher/data/component/LocaleComponent$OnLocaleChangedListener;", "Lkotlin/collections/ArrayList;", "receiver", "com/dw/launcher/data/component/LocaleComponent$receiver$1", "Lcom/dw/launcher/data/component/LocaleComponent$receiver$1;", "addListener", BuildConfig.FLAVOR, "listener", "register", "removeListener", "unregister", "OnLocaleChangedListener", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LocaleComponent {
    private final Context context;
    private final ArrayList<OnLocaleChangedListener> mListeners;
    private final LocaleComponent$receiver$1 receiver;

    /* JADX INFO: compiled from: LocaleComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/data/component/LocaleComponent$OnLocaleChangedListener;", BuildConfig.FLAVOR, "onLocaleChanged", BuildConfig.FLAVOR, "changed", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnLocaleChangedListener {
        void onLocaleChanged(boolean changed);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.dw.launcher.data.component.LocaleComponent$receiver$1] */
    @Inject
    public LocaleComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mListeners = new ArrayList<>();
        this.receiver = new BroadcastReceiver() { // from class: com.dw.launcher.data.component.LocaleComponent$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                Iterator it = this.this$0.mListeners.iterator();
                while (it.hasNext()) {
                    ((LocaleComponent.OnLocaleChangedListener) it.next()).onLocaleChanged(true);
                }
            }
        };
    }

    public final void register() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        this.context.registerReceiver(this.receiver, intentFilter);
    }

    public final void unregister() {
        this.context.unregisterReceiver(this.receiver);
    }

    public final void addListener(OnLocaleChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListeners.add(listener);
    }

    public final void removeListener(OnLocaleChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListeners.remove(listener);
    }
}
