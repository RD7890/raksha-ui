package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.google.android.mms.pdu.CharacterSets;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommonCompassPainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0016\u0010:\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010;\u001a\u00020\bJ\u0006\u0010%\u001a\u000205J!\u0010<\u001a\u0002052\u0012\u0010=\u001a\n\u0012\u0006\b\u0001\u0012\u00020?0>\"\u00020?H\u0016¢\u0006\u0002\u0010@R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006A"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/CommonCompassPainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "changeUseTime", "", "compassNumDrawable", "", "Landroid/graphics/drawable/Drawable;", "getCompassNumDrawable", "()Ljava/util/List;", "setCompassNumDrawable", "(Ljava/util/List;)V", "compassNumPosition", "Landroid/graphics/Point;", "getCompassNumPosition", "()Landroid/graphics/Point;", "setCompassNumPosition", "(Landroid/graphics/Point;)V", "compassPrefixDrawable", "getCompassPrefixDrawable", "()Landroid/graphics/drawable/Drawable;", "setCompassPrefixDrawable", "(Landroid/graphics/drawable/Drawable;)V", "compassSignIconDrawable", "getCompassSignIconDrawable", "setCompassSignIconDrawable", "getContext", "()Landroid/content/Context;", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "index", "getIndex", "()I", "setIndex", "(I)V", "is_support_compass_function", "", "()Z", "set_support_compass_function", "(Z)V", "lastDrawTime", "", "rotation", "", "getRotation", "()F", "setRotation", "(F)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawNums", "rotate", "updateParams", "params", "", "", "([Ljava/lang/Object;)V", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class CommonCompassPainter extends ABasePainter {
    private int changeUseTime;
    private List<? extends Drawable> compassNumDrawable;
    private Point compassNumPosition;
    private Drawable compassPrefixDrawable;
    private Drawable compassSignIconDrawable;
    private final Context context;
    private final ClockConfigFlatter flatter;
    private int index;
    private boolean is_support_compass_function;
    private long lastDrawTime;
    private float rotation;

    public CommonCompassPainter(Context context, ClockConfigFlatter flatter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.changeUseTime = 500;
        this.compassNumPosition = new Point();
        ClockConfig config = flatter.getConfig();
        this.index = config != null ? config.getBg_btn_index() : 0;
        setSupportScale(flatter.getConfig().supportScale());
        if (flatter.getConfig().getShow_compass_num() == 1) {
            this.compassNumDrawable = flatter.splitDrawable(flatter.getConfig().getCompass_num_src(), 10);
            this.compassSignIconDrawable = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getCompass_num_src_sign(), false, 2, null);
            this.compassPrefixDrawable = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getCompass_num_src_prefix(), false, 2, null);
            flatter.setPosition(this.compassNumPosition, flatter.getConfig().getCompass_num_x(), flatter.getConfig().getCompass_num_y());
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    /* JADX INFO: renamed from: is_support_compass_function, reason: from getter */
    public final boolean getIs_support_compass_function() {
        return this.is_support_compass_function;
    }

    public final void set_support_compass_function(boolean z) {
        this.is_support_compass_function = z;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final void setRotation(float f) {
        this.rotation = f;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final List<Drawable> getCompassNumDrawable() {
        return this.compassNumDrawable;
    }

    public final void setCompassNumDrawable(List<? extends Drawable> list) {
        this.compassNumDrawable = list;
    }

    public final Point getCompassNumPosition() {
        return this.compassNumPosition;
    }

    public final void setCompassNumPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.compassNumPosition = point;
    }

    public final Drawable getCompassSignIconDrawable() {
        return this.compassSignIconDrawable;
    }

    public final void setCompassSignIconDrawable(Drawable drawable) {
        this.compassSignIconDrawable = drawable;
    }

    public final Drawable getCompassPrefixDrawable() {
        return this.compassPrefixDrawable;
    }

    public final void setCompassPrefixDrawable(Drawable drawable) {
        this.compassPrefixDrawable = drawable;
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Drawable compassDrawable;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        ClockConfig config = this.flatter.getConfig();
        if (config == null || config.getSupport_compass() != 1) {
            return;
        }
        if (this.index % 2 == 1 && this.flatter.getCompassDrawable2() != null) {
            compassDrawable = this.flatter.getCompassDrawable2();
        } else {
            compassDrawable = this.flatter.getCompassDrawable();
        }
        if (compassDrawable != null) {
            Point compassPosition = this.flatter.getCompassPosition();
            int i = compassPosition.x;
            int i2 = compassPosition.y;
            canvas.save();
            if (this.is_support_compass_function) {
                canvas.rotate(-this.rotation, i, i2);
            }
            int intrinsicWidth = (int) (compassDrawable.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX()));
            int intrinsicHeight = (int) (compassDrawable.getIntrinsicHeight() * (getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY()));
            int i3 = compassPosition.x;
            int i4 = compassPosition.y;
            int i5 = intrinsicWidth / 2;
            int i6 = intrinsicHeight / 2;
            compassDrawable.setBounds(i3 - i5, i4 - i6, i3 + i5, i4 + i6);
            compassDrawable.draw(canvas);
            canvas.restore();
        }
        if (this.flatter.getConfig().getShow_compass_num() == 1) {
            drawNums(canvas, (int) this.rotation);
        }
    }

    @Override // com.dw.launcher.ui.clock.painter.ABasePainter, com.dw.launcher.ui.clock.painter.IBasePainter
    public void updateParams(Object... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        Object obj = params[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        this.is_support_compass_function = ((Boolean) obj).booleanValue();
        Object obj2 = params[1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
        this.rotation = ((Float) obj2).floatValue();
    }

    public final void setIndex() {
        if (SystemClock.uptimeMillis() - this.lastDrawTime >= this.changeUseTime) {
            int i = this.index + 1;
            this.index = i;
            this.index = i % 2;
            this.lastDrawTime = SystemClock.uptimeMillis();
        }
    }

    public final void drawNums(Canvas canvas, int rotate) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float absoluteScaleX = getSupportScale() ? this.flatter.getAbsoluteScaleX() : 1.0f;
        List<? extends Drawable> list = this.compassNumDrawable;
        if (list != null) {
            ArrayList<Drawable> arrayList = new ArrayList();
            int scaleX = 0;
            while (rotate >= 0) {
                int i = rotate % 10;
                arrayList.add(0, list.get(i));
                scaleX += (int) (list.get(i).getIntrinsicWidth() * absoluteScaleX);
                if (rotate < 10) {
                    break;
                } else {
                    rotate /= 10;
                }
            }
            Drawable drawable = this.compassPrefixDrawable;
            if (drawable != null) {
                boolean supportScale = getSupportScale();
                float intrinsicWidth = drawable.getIntrinsicWidth();
                if (supportScale) {
                    intrinsicWidth *= this.flatter.getAbsoluteScaleX();
                }
                scaleX += (int) (intrinsicWidth * this.flatter.getScaleX());
            }
            Drawable drawable2 = this.compassSignIconDrawable;
            if (drawable2 != null) {
                boolean supportScale2 = getSupportScale();
                float intrinsicWidth2 = drawable2.getIntrinsicWidth();
                if (supportScale2) {
                    intrinsicWidth2 *= this.flatter.getAbsoluteScaleX();
                }
                scaleX += (int) (intrinsicWidth2 * this.flatter.getScaleX());
            }
            int intrinsicWidth3 = this.compassNumPosition.x;
            int i2 = this.compassNumPosition.y;
            if (this.flatter.getConfig().getCompass_show_type() == 1) {
                intrinsicWidth3 -= scaleX;
            } else if (this.flatter.getConfig().getCompass_show_type() == 2) {
                scaleX /= 2;
                intrinsicWidth3 -= scaleX;
            }
            Drawable drawable3 = this.compassPrefixDrawable;
            if (drawable3 != null) {
                drawDrawable(canvas, drawable3, intrinsicWidth3, i2, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                intrinsicWidth3 += (int) (drawable3.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX()));
            }
            for (Drawable drawable4 : arrayList) {
                drawDrawable(canvas, drawable4, intrinsicWidth3, i2, absoluteScaleX, absoluteScaleX);
                intrinsicWidth3 += (int) (drawable4.getIntrinsicWidth() * absoluteScaleX);
            }
            Drawable drawable5 = this.compassSignIconDrawable;
            if (drawable5 != null) {
                drawDrawable(canvas, drawable5, intrinsicWidth3, i2, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
            }
        }
    }
}
