package com.dw.launcher.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.dw.launcher.R;
import com.dw.launcher.core.component.DeviceStateComponent;
import com.dw.launcher.data.component.BatteryComponent;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BatteryView.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020+H\u0014J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\nH\u0016J\u0010\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0012H\u0016J\b\u00100\u001a\u00020+H\u0014J\u0010\u00101\u001a\u00020+2\u0006\u00102\u001a\u000203H\u0014J\b\u00104\u001a\u00020+H\u0014R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/dw/launcher/ui/view/BatteryView;", "Landroid/view/View;", "Lcom/dw/launcher/data/component/BatteryComponent$OnBatteryChangedListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "batteryLevelDrawables", "", "Landroid/graphics/drawable/Drawable;", "[Landroid/graphics/drawable/Drawable;", "chargingBatteryLevelDrawables", "isShowBatteryPercent", "", "mBatteryComponent", "Lcom/dw/launcher/data/component/BatteryComponent;", "getMBatteryComponent", "()Lcom/dw/launcher/data/component/BatteryComponent;", "setMBatteryComponent", "(Lcom/dw/launcher/data/component/BatteryComponent;)V", "mDeviceStateComponent", "Lcom/dw/launcher/core/component/DeviceStateComponent;", "getMDeviceStateComponent", "()Lcom/dw/launcher/core/component/DeviceStateComponent;", "setMDeviceStateComponent", "(Lcom/dw/launcher/core/component/DeviceStateComponent;)V", "mHandler", "Landroid/os/Handler;", "mLastIndex", "mRect", "Landroid/graphics/Rect;", "mRunnable", "Ljava/lang/Runnable;", "mTextPaint", "Landroid/graphics/Paint;", "getMinBattery", "level", "onAttachedToWindow", "", "onBatteryChanged", "batteryLevel", "onBatteryChargingStateChanged", "charging", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onFinishInflate", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class BatteryView extends Hilt_BatteryView implements BatteryComponent.OnBatteryChangedListener {
    private Drawable[] batteryLevelDrawables;
    private Drawable[] chargingBatteryLevelDrawables;
    private boolean isShowBatteryPercent;

    @Inject
    public BatteryComponent mBatteryComponent;

    @Inject
    public DeviceStateComponent mDeviceStateComponent;
    private Handler mHandler;
    private int mLastIndex;
    private final Rect mRect;
    private Runnable mRunnable;
    private final Paint mTextPaint;

    private final int getMinBattery(int level) {
        if (level < 5) {
            return 0;
        }
        if (level < 20) {
            return 1;
        }
        if (level < 40) {
            return 2;
        }
        if (level < 60) {
            return 3;
        }
        return level < 90 ? 4 : 5;
    }

    public final BatteryComponent getMBatteryComponent() {
        BatteryComponent batteryComponent = this.mBatteryComponent;
        if (batteryComponent != null) {
            return batteryComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBatteryComponent");
        return null;
    }

    public final void setMBatteryComponent(BatteryComponent batteryComponent) {
        Intrinsics.checkNotNullParameter(batteryComponent, "<set-?>");
        this.mBatteryComponent = batteryComponent;
    }

    public final DeviceStateComponent getMDeviceStateComponent() {
        DeviceStateComponent deviceStateComponent = this.mDeviceStateComponent;
        if (deviceStateComponent != null) {
            return deviceStateComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDeviceStateComponent");
        return null;
    }

    public final void setMDeviceStateComponent(DeviceStateComponent deviceStateComponent) {
        Intrinsics.checkNotNullParameter(deviceStateComponent, "<set-?>");
        this.mDeviceStateComponent = deviceStateComponent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRunnable$lambda$0(BatteryView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.invalidate();
    }

    public BatteryView(Context context) {
        super(context);
        this.mLastIndex = -1;
        this.isShowBatteryPercent = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mTextPaint = new Paint();
        this.mRect = new Rect();
        this.mRunnable = new Runnable() { // from class: com.dw.launcher.ui.view.BatteryView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BatteryView.mRunnable$lambda$0(this.f$0);
            }
        };
        this.batteryLevelDrawables = new Drawable[]{ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_low_0), ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_low), ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_20), ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_50), ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_80), ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_100)};
        this.chargingBatteryLevelDrawables = new Drawable[]{ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_0), ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_5), ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_20), ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_50), ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_80), ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_100)};
    }

    public BatteryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastIndex = -1;
        this.isShowBatteryPercent = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mTextPaint = new Paint();
        this.mRect = new Rect();
        this.mRunnable = new Runnable() { // from class: com.dw.launcher.ui.view.BatteryView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BatteryView.mRunnable$lambda$0(this.f$0);
            }
        };
        this.batteryLevelDrawables = new Drawable[]{ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_low_0), ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_low), ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_20), ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_50), ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_80), ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_100)};
        this.chargingBatteryLevelDrawables = new Drawable[]{ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_0), ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_5), ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_20), ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_50), ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_80), ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_100)};
    }

    public BatteryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastIndex = -1;
        this.isShowBatteryPercent = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mTextPaint = new Paint();
        this.mRect = new Rect();
        this.mRunnable = new Runnable() { // from class: com.dw.launcher.ui.view.BatteryView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BatteryView.mRunnable$lambda$0(this.f$0);
            }
        };
        this.batteryLevelDrawables = new Drawable[]{ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_low_0), ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_low), ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_20), ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_50), ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_80), ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_battery_100)};
        this.chargingBatteryLevelDrawables = new Drawable[]{ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_0), ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_5), ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_20), ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_50), ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_80), ContextCompat.getDrawable(getContext(), R.drawable.battery_charging_100)};
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getMBatteryComponent().addListener(this);
        this.mLastIndex = -1;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMBatteryComponent().removeListener(this);
        this.mLastIndex = -1;
    }

    public void onBatteryChanged(int batteryLevel) {
        if (this.mLastIndex < 0) {
            invalidate();
        }
    }

    public void onBatteryChargingStateChanged(boolean charging) {
        BatteryComponent.OnBatteryChangedListener.DefaultImpls.onBatteryChargingStateChanged(this, charging);
        Log.i("BatteryView", "----onBatteryChargingStateChanged, charging: " + charging);
        if (charging) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize(getResources().getDimension(R.dimen.top_status_bar_text_size));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int level = getMBatteryComponent().getLevel();
        boolean zIsCharging = getMBatteryComponent().isCharging();
        boolean z = level >= 100;
        if (zIsCharging && !z) {
            if (this.mLastIndex < 0) {
                this.mLastIndex = 0;
            }
            this.mLastIndex %= this.chargingBatteryLevelDrawables.length;
            int minBattery = getMinBattery(level);
            if (minBattery == this.chargingBatteryLevelDrawables.length - 1 && !z) {
                minBattery--;
            }
            int iCoerceAtLeast = RangesKt.coerceAtLeast(this.mLastIndex, minBattery);
            this.mLastIndex = iCoerceAtLeast;
            drawable = this.chargingBatteryLevelDrawables[iCoerceAtLeast];
            this.mLastIndex = iCoerceAtLeast + 1;
            this.mHandler.removeCallbacks(this.mRunnable);
            this.mHandler.postDelayed(this.mRunnable, 500L);
        } else {
            this.mHandler.removeCallbacks(this.mRunnable);
            this.mLastIndex = -1;
            drawable = this.batteryLevelDrawables[getMinBattery(level)];
        }
        int intrinsicWidth = drawable != null ? drawable.getIntrinsicWidth() : 0;
        this.isShowBatteryPercent = Settings.System.getInt(getContext().getContentResolver(), "status_bar_show_battery_percent", 1) == 1;
        String string = new StringBuilder().append(getMBatteryComponent().getLevel()).append('%').toString();
        this.mTextPaint.getTextBounds(string, 0, string.length(), this.mRect);
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        float f = fontMetrics.descent - fontMetrics.ascent;
        float width = (getWidth() - (this.isShowBatteryPercent ? (this.mRect.width() + intrinsicWidth) + 4 : intrinsicWidth)) / 2.0f;
        float height = (getHeight() / 2.0f) + ((f / 2.0f) - fontMetrics.descent);
        if (drawable != null) {
            drawable.setBounds((int) width, (int) ((getHeight() / 2.0f) - (drawable.getIntrinsicHeight() / 2.0f)), (int) (drawable.getIntrinsicWidth() + width), (int) ((getHeight() / 2.0f) + (drawable.getIntrinsicHeight() / 2.0f)));
            drawable.draw(canvas);
        }
        if (this.isShowBatteryPercent) {
            canvas.drawText(string, width + intrinsicWidth + 4, height, this.mTextPaint);
        }
    }
}
