package com.dw.launcher.data.component;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BrightComponent.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\f\u0018\u00002\u00020\u0001:\u0001\u001cB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tJ\u001a\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00122\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010\u001b\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/dw/launcher/data/component/BrightComponent;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mHandler", "Landroid/os/Handler;", "mListeners", "Ljava/util/ArrayList;", "Lcom/dw/launcher/data/component/BrightComponent$OnBrightnessChangedListener;", "Lkotlin/collections/ArrayList;", "mObserver", "com/dw/launcher/data/component/BrightComponent$mObserver$1", "Lcom/dw/launcher/data/component/BrightComponent$mObserver$1;", "addListener", BuildConfig.FLAVOR, "listener", "getBrightness", BuildConfig.FLAVOR, "getBrightnessLevel", BuildConfig.FLAVOR, "register", "removeListener", "setBrightnessLevel", "brightness", "window", "Landroid/view/Window;", "unregister", "OnBrightnessChangedListener", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BrightComponent {
    private final Context context;
    private final Handler mHandler;
    private final ArrayList<OnBrightnessChangedListener> mListeners;
    private final BrightComponent$mObserver$1 mObserver;

    /* JADX INFO: compiled from: BrightComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/dw/launcher/data/component/BrightComponent$OnBrightnessChangedListener;", BuildConfig.FLAVOR, "onBrightnessChanged", BuildConfig.FLAVOR, "brightness", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnBrightnessChangedListener {
        void onBrightnessChanged(int brightness);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.dw.launcher.data.component.BrightComponent$mObserver$1] */
    @Inject
    public BrightComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mListeners = new ArrayList<>();
        final Handler handler = new Handler(Looper.getMainLooper());
        this.mHandler = handler;
        this.mObserver = new ContentObserver(handler) { // from class: com.dw.launcher.data.component.BrightComponent$mObserver$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                ArrayList arrayList = this.this$0.mListeners;
                BrightComponent brightComponent = this.this$0;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((BrightComponent.OnBrightnessChangedListener) it.next()).onBrightnessChanged(brightComponent.getBrightness());
                }
            }
        };
    }

    public final void register() {
        this.context.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness"), false, this.mObserver);
    }

    public final void unregister() {
        this.context.getContentResolver().unregisterContentObserver(this.mObserver);
    }

    public final void addListener(OnBrightnessChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListeners.add(listener);
    }

    public final void removeListener(OnBrightnessChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListeners.remove(listener);
    }

    public final int getBrightness() {
        return Settings.System.getInt(this.context.getContentResolver(), "screen_brightness", 100);
    }

    public final float getBrightnessLevel() {
        return getBrightness() / 255.0f;
    }

    public static /* synthetic */ void setBrightnessLevel$default(BrightComponent brightComponent, int i, Window window, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            window = null;
        }
        brightComponent.setBrightnessLevel(i, window);
    }

    public final void setBrightnessLevel(int brightness, Window window) {
        Unit unit;
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = brightness / 255.0f;
            window.setAttributes(attributes);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null && this.context.checkSelfPermission("android.permission.WRITE_SETTINGS") == 0) {
            Settings.System.putInt(this.context.getContentResolver(), "screen_brightness", RangesKt.coerceAtLeast(RangesKt.coerceAtMost(brightness, 255), 0));
        }
    }
}
