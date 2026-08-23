package com.dw.launcher.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.dw.launcher.R;
import com.dw.launcher.data.component.PhoneStatusComponent;
import com.dw.launcher.util.NetworkUtil;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

/* JADX INFO: compiled from: SignalStrengthView.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001a\u001a\u00020\u001bH\u0014J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0014J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0014J\u0018\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0014J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\nH\u0016R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/dw/launcher/ui/view/SignalStrengthView;", "Landroid/view/View;", "Lcom/dw/launcher/data/component/PhoneStatusComponent$OnPhoneStatusChangedListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawables", "", "Landroid/graphics/drawable/Drawable;", "[Landroid/graphics/drawable/Drawable;", "inOutDrawables", "Landroid/util/SparseArray;", "mDataActivity", "phoneStatusComponent", "Lcom/dw/launcher/data/component/PhoneStatusComponent;", "getPhoneStatusComponent", "()Lcom/dw/launcher/data/component/PhoneStatusComponent;", "setPhoneStatusComponent", "(Lcom/dw/launcher/data/component/PhoneStatusComponent;)V", "volteDrawable", "onAttachedToWindow", "", "onDataActivity", "direction", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSignalStrengthChanged", "batteryLevel", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class SignalStrengthView extends Hilt_SignalStrengthView implements PhoneStatusComponent.OnPhoneStatusChangedListener {
    private Drawable[] drawables;
    private SparseArray<Drawable> inOutDrawables;
    private int mDataActivity;

    @Inject
    public PhoneStatusComponent phoneStatusComponent;
    private Drawable volteDrawable;

    public void onSimStateChanged() {
        PhoneStatusComponent.OnPhoneStatusChangedListener.DefaultImpls.onSimStateChanged(this);
    }

    public void onVolteRegisterStateChanged(boolean z) {
        PhoneStatusComponent.OnPhoneStatusChangedListener.DefaultImpls.onVolteRegisterStateChanged(this, z);
    }

    public final PhoneStatusComponent getPhoneStatusComponent() {
        PhoneStatusComponent phoneStatusComponent = this.phoneStatusComponent;
        if (phoneStatusComponent != null) {
            return phoneStatusComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("phoneStatusComponent");
        return null;
    }

    public final void setPhoneStatusComponent(PhoneStatusComponent phoneStatusComponent) {
        Intrinsics.checkNotNullParameter(phoneStatusComponent, "<set-?>");
        this.phoneStatusComponent = phoneStatusComponent;
    }

    public SignalStrengthView(Context context) {
        super(context);
        this.drawables = new Drawable[]{ContextCompat.getDrawable(getContext(), R.drawable.icon_singal_0), ContextCompat.getDrawable(getContext(), R.drawable.icon_singal_1), ContextCompat.getDrawable(getContext(), R.drawable.icon_singal_2), ContextCompat.getDrawable(getContext(), R.drawable.icon_singal_3), ContextCompat.getDrawable(getContext(), R.drawable.icon_singal_4)};
        this.inOutDrawables = new SparseArray<>();
        this.volteDrawable = ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_volte);
        this.inOutDrawables.put(0, ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_signal_null));
        this.inOutDrawables.put(1, ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_signal_in));
        this.inOutDrawables.put(2, ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_signal_out));
        this.inOutDrawables.put(3, ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_signal_inout));
    }

    public SignalStrengthView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drawables = new Drawable[]{ContextCompat.getDrawable(getContext(), R.drawable.icon_singal_0), ContextCompat.getDrawable(getContext(), R.drawable.icon_singal_1), ContextCompat.getDrawable(getContext(), R.drawable.icon_singal_2), ContextCompat.getDrawable(getContext(), R.drawable.icon_singal_3), ContextCompat.getDrawable(getContext(), R.drawable.icon_singal_4)};
        this.inOutDrawables = new SparseArray<>();
        this.volteDrawable = ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_volte);
        this.inOutDrawables.put(0, ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_signal_null));
        this.inOutDrawables.put(1, ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_signal_in));
        this.inOutDrawables.put(2, ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_signal_out));
        this.inOutDrawables.put(3, ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_signal_inout));
    }

    public SignalStrengthView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drawables = new Drawable[]{ContextCompat.getDrawable(getContext(), R.drawable.icon_singal_0), ContextCompat.getDrawable(getContext(), R.drawable.icon_singal_1), ContextCompat.getDrawable(getContext(), R.drawable.icon_singal_2), ContextCompat.getDrawable(getContext(), R.drawable.icon_singal_3), ContextCompat.getDrawable(getContext(), R.drawable.icon_singal_4)};
        this.inOutDrawables = new SparseArray<>();
        this.volteDrawable = ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_volte);
        this.inOutDrawables.put(0, ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_signal_null));
        this.inOutDrawables.put(1, ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_signal_in));
        this.inOutDrawables.put(2, ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_signal_out));
        this.inOutDrawables.put(3, ContextCompat.getDrawable(getContext(), R.drawable.stat_sys_signal_inout));
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getPhoneStatusComponent().addListener(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getPhoneStatusComponent().removeListener(this);
    }

    public void onSignalStrengthChanged(int batteryLevel) {
        invalidate();
    }

    public void onDataActivity(int direction) {
        PhoneStatusComponent.OnPhoneStatusChangedListener.DefaultImpls.onDataActivity(this, direction);
        this.mDataActivity = direction;
        invalidate();
        Timber.INSTANCE.v("----onDataActivity: " + direction, new Object[0]);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable drawable;
        int iCoerceAtLeast;
        int intrinsicWidth;
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int i = 0;
            if (getPhoneStatusComponent().isSimCardReady() && !NetworkUtil.getAirplaneModeEnabled(getContext())) {
                if (getPhoneStatusComponent().getLevel() >= 4) {
                    drawable = this.drawables[4];
                } else if (getPhoneStatusComponent().getLevel() == 3) {
                    drawable = this.drawables[3];
                } else if (getPhoneStatusComponent().getLevel() == 2) {
                    drawable = this.drawables[2];
                } else if (getPhoneStatusComponent().getLevel() == 1) {
                    drawable = this.drawables[1];
                } else {
                    drawable = this.drawables[0];
                }
            } else {
                drawable = this.drawables[0];
            }
            if (!getPhoneStatusComponent().isSimCardReady() || NetworkUtil.getAirplaneModeEnabled(getContext())) {
                iCoerceAtLeast = 0;
            } else {
                if (drawable != null) {
                    intrinsicWidth = drawable.getIntrinsicWidth();
                    iCoerceAtLeast = RangesKt.coerceAtLeast(0, drawable.getIntrinsicHeight());
                } else {
                    iCoerceAtLeast = 0;
                    intrinsicWidth = 0;
                }
                Drawable drawable2 = this.inOutDrawables.get(this.mDataActivity);
                if (drawable2 == null) {
                    drawable2 = this.inOutDrawables.get(0);
                }
                if (drawable2 != null) {
                    iCoerceAtLeast = RangesKt.coerceAtLeast(iCoerceAtLeast, drawable2.getIntrinsicHeight());
                }
                if (getPhoneStatusComponent().isShowVolte()) {
                    Timber.INSTANCE.v("----showVolte: " + getPhoneStatusComponent().isShowVolte(), new Object[0]);
                    Drawable drawable3 = this.volteDrawable;
                    if (drawable3 != null) {
                        intrinsicWidth += drawable3.getIntrinsicWidth();
                        iCoerceAtLeast = RangesKt.coerceAtLeast(iCoerceAtLeast, drawable3.getIntrinsicHeight());
                    }
                }
                i = intrinsicWidth;
            }
            if (mode == Integer.MIN_VALUE) {
                widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, mode);
            }
            if (mode2 == Integer.MIN_VALUE) {
                heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(iCoerceAtLeast, mode2);
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (getPhoneStatusComponent().isSimCardReady() && !NetworkUtil.getAirplaneModeEnabled(getContext())) {
            if (getPhoneStatusComponent().getLevel() >= 4) {
                drawable = this.drawables[4];
            } else if (getPhoneStatusComponent().getLevel() == 3) {
                drawable = this.drawables[3];
            } else if (getPhoneStatusComponent().getLevel() == 2) {
                drawable = this.drawables[2];
            } else if (getPhoneStatusComponent().getLevel() == 1) {
                drawable = this.drawables[1];
            } else {
                drawable = this.drawables[0];
            }
        } else {
            drawable = this.drawables[0];
        }
        if (!getPhoneStatusComponent().isSimCardReady() || NetworkUtil.getAirplaneModeEnabled(getContext())) {
            return;
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable != null) {
            drawable.draw(canvas);
        }
        int intrinsicWidth = drawable != null ? drawable.getIntrinsicWidth() : 0;
        if (getPhoneStatusComponent().isShowVolte()) {
            Timber.INSTANCE.v("----showVolte: " + getPhoneStatusComponent().isShowVolte(), new Object[0]);
            Drawable drawable2 = this.volteDrawable;
            if (drawable2 != null) {
                int intrinsicHeight = drawable2.getIntrinsicHeight() / 2;
                drawable2.setBounds(intrinsicWidth, (getHeight() / 2) - intrinsicHeight, drawable2.getIntrinsicWidth() + intrinsicWidth, (getHeight() / 2) + intrinsicHeight);
                drawable2.draw(canvas);
            }
        }
    }
}
