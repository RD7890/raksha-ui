package com.dw.launcher.ui.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.dw.launcher.R;
import com.dw.launcher.data.component.WifiComponent;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkView.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001d\u001a\u00020\u001bH\u0014J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\u001bH\u0014J\u0006\u0010\"\u001a\u00020\u001bJ\u0006\u0010#\u001a\u00020\u001bR\u0018\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/dw/launcher/ui/view/NetworkView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawables", "", "Landroid/graphics/drawable/Drawable;", "[Landroid/graphics/drawable/Drawable;", "mTextPaint", "Landroid/graphics/Paint;", "receiver", "com/dw/launcher/ui/view/NetworkView$receiver$1", "Lcom/dw/launcher/ui/view/NetworkView$receiver$1;", "wifiComponent", "Lcom/dw/launcher/data/component/WifiComponent;", "getWifiComponent", "()Lcom/dw/launcher/data/component/WifiComponent;", "setWifiComponent", "(Lcom/dw/launcher/data/component/WifiComponent;)V", "initReceiver", "", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onFinishInflate", "onWifiStateChanged", "unregister", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class NetworkView extends Hilt_NetworkView {
    private Drawable[] drawables;
    private final Paint mTextPaint;
    private final NetworkView$receiver$1 receiver;

    @Inject
    public WifiComponent wifiComponent;

    public final WifiComponent getWifiComponent() {
        WifiComponent wifiComponent = this.wifiComponent;
        if (wifiComponent != null) {
            return wifiComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("wifiComponent");
        return null;
    }

    public final void setWifiComponent(WifiComponent wifiComponent) {
        Intrinsics.checkNotNullParameter(wifiComponent, "<set-?>");
        this.wifiComponent = wifiComponent;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.dw.launcher.ui.view.NetworkView$receiver$1] */
    public NetworkView(Context context) {
        super(context);
        this.mTextPaint = new Paint();
        this.drawables = new Drawable[]{ContextCompat.getDrawable(getContext(), R.drawable.icon_wifi_0), ContextCompat.getDrawable(getContext(), R.drawable.icon_wifi_1), ContextCompat.getDrawable(getContext(), R.drawable.icon_wifi_2), ContextCompat.getDrawable(getContext(), R.drawable.icon_wifi_3), ContextCompat.getDrawable(getContext(), R.drawable.icon_wifi_4)};
        this.receiver = new BroadcastReceiver() { // from class: com.dw.launcher.ui.view.NetworkView$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context mContext, Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Log.i("lkang", "wifi onReceive onWifiStateChanged");
                this.this$0.onWifiStateChanged();
            }
        };
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.dw.launcher.ui.view.NetworkView$receiver$1] */
    public NetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextPaint = new Paint();
        this.drawables = new Drawable[]{ContextCompat.getDrawable(getContext(), R.drawable.icon_wifi_0), ContextCompat.getDrawable(getContext(), R.drawable.icon_wifi_1), ContextCompat.getDrawable(getContext(), R.drawable.icon_wifi_2), ContextCompat.getDrawable(getContext(), R.drawable.icon_wifi_3), ContextCompat.getDrawable(getContext(), R.drawable.icon_wifi_4)};
        this.receiver = new BroadcastReceiver() { // from class: com.dw.launcher.ui.view.NetworkView$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context mContext, Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Log.i("lkang", "wifi onReceive onWifiStateChanged");
                this.this$0.onWifiStateChanged();
            }
        };
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.dw.launcher.ui.view.NetworkView$receiver$1] */
    public NetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextPaint = new Paint();
        this.drawables = new Drawable[]{ContextCompat.getDrawable(getContext(), R.drawable.icon_wifi_0), ContextCompat.getDrawable(getContext(), R.drawable.icon_wifi_1), ContextCompat.getDrawable(getContext(), R.drawable.icon_wifi_2), ContextCompat.getDrawable(getContext(), R.drawable.icon_wifi_3), ContextCompat.getDrawable(getContext(), R.drawable.icon_wifi_4)};
        this.receiver = new BroadcastReceiver() { // from class: com.dw.launcher.ui.view.NetworkView$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context mContext, Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Log.i("lkang", "wifi onReceive onWifiStateChanged");
                this.this$0.onWifiStateChanged();
            }
        };
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        initReceiver();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unregister();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize(getResources().getDimension(R.dimen.top_status_bar_text_size));
    }

    public final void initReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.dw.wifi.change");
        Context context = getContext();
        if (context != null) {
            context.registerReceiver(this.receiver, intentFilter);
        }
    }

    public final void unregister() {
        Context context = getContext();
        if (context != null) {
            context.unregisterReceiver(this.receiver);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int iLevel = getWifiComponent().level();
        Log.i("lkang", "wifi:{" + getWifiComponent().isConnected() + '}');
        if (getWifiComponent().isConnected()) {
            Drawable[] drawableArr = this.drawables;
            Drawable drawable = drawableArr[0];
            if (iLevel >= 4) {
                drawable = drawableArr[4];
            } else if (iLevel == 3) {
                drawable = drawableArr[3];
            } else if (iLevel == 2) {
                drawable = drawableArr[2];
            } else if (iLevel == 1) {
                drawable = drawableArr[1];
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }
    }

    public final void onWifiStateChanged() {
        invalidate();
    }
}
