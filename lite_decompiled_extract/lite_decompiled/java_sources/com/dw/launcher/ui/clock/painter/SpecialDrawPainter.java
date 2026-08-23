package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.google.android.mms.pdu.CharacterSets;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpecialDrawPainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010$\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010\u001f2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0082\bJ\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002J\u0016\u00101\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00062"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/SpecialDrawPainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "bitmapCountSum", "", "changeUseTime", "getContext", "()Landroid/content/Context;", "currentDrawableIndex", "getCurrentDrawableIndex", "()I", "setCurrentDrawableIndex", "(I)V", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "isChangeBg", "", "lastDrawTime", "", "scaleX", "", "getScaleX", "()F", "scaleY", "getScaleY", "specialDrawableList", "", "Landroid/graphics/drawable/Drawable;", "getSpecialDrawableList", "()Ljava/util/List;", "setSpecialDrawableList", "(Ljava/util/List;)V", "checkAndPerformClick", "drawable", "x", "y", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "expandBound", "Landroid/graphics/Rect;", "bounds", "todoClick", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class SpecialDrawPainter extends ABasePainter {
    private int bitmapCountSum;
    private int changeUseTime;
    private final Context context;
    private int currentDrawableIndex;
    private final ClockConfigFlatter flatter;
    private boolean isChangeBg;
    private long lastDrawTime;
    private final float scaleX;
    private final float scaleY;
    private List<Drawable> specialDrawableList;

    public SpecialDrawPainter(Context context, ClockConfigFlatter flatter) throws IOException {
        String[] list;
        List<Drawable> list2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.scaleX = flatter.getScaleX() * flatter.getAbsoluteScaleX();
        this.scaleY = flatter.getScaleY() * flatter.getAbsoluteScaleY();
        this.specialDrawableList = new ArrayList();
        this.currentDrawableIndex = 1;
        setSupportScale(flatter.getConfig().supportScale());
        if (flatter.getConfig().getSupport_multiple_change() == 1) {
            if (flatter.getConfig().isFromAssets()) {
                list = context.getAssets().list(flatter.getConfig().getPath() + "/res/special");
            } else {
                list = new File(flatter.getConfig().getPath() + "/res/special").list();
            }
            this.specialDrawableList = new ArrayList();
            if (list != null) {
                for (String str : list) {
                    Drawable drawableLoadDrawable$default = ClockConfigFlatter.loadDrawable$default(this.flatter, "res/special/" + str, false, 2, null);
                    if (drawableLoadDrawable$default != null && (list2 = this.specialDrawableList) != null) {
                        list2.add(drawableLoadDrawable$default);
                    }
                }
            }
            List<Drawable> list3 = this.specialDrawableList;
            Integer numValueOf = list3 != null ? Integer.valueOf(list3.size()) : null;
            Intrinsics.checkNotNull(numValueOf);
            this.bitmapCountSum = numValueOf.intValue();
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final List<Drawable> getSpecialDrawableList() {
        return this.specialDrawableList;
    }

    public final void setSpecialDrawableList(List<Drawable> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.specialDrawableList = list;
    }

    public final int getCurrentDrawableIndex() {
        return this.currentDrawableIndex;
    }

    public final void setCurrentDrawableIndex(int i) {
        this.currentDrawableIndex = i;
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        List<Drawable> list;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable specialDrawable = this.flatter.getSpecialDrawable();
        if (specialDrawable != null) {
            drawDrawable(canvas, specialDrawable, this.flatter.getSpecialPosition().x, this.flatter.getSpecialPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        if (this.flatter.getConfig().getSupport_multiple_change() != 1 || this.bitmapCountSum == 0 || (list = this.specialDrawableList) == null) {
            return;
        }
        if (!this.isChangeBg) {
            if (this.currentDrawableIndex - 1 >= list.size() || this.specialDrawableList.get(this.currentDrawableIndex - 1) == null) {
                return;
            }
            this.specialDrawableList.get(this.currentDrawableIndex - 1).setAlpha(255);
            drawDrawable(canvas, this.specialDrawableList.get(this.currentDrawableIndex - 1), this.flatter.getSpecialPosition().x, this.flatter.getSpecialPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i = this.changeUseTime;
        long j = this.lastDrawTime;
        long j2 = jUptimeMillis - j;
        if (0 <= j2 && j2 < i) {
            int i2 = (int) (((jUptimeMillis - j) * ((long) 255)) / ((long) i));
            int i3 = this.currentDrawableIndex;
            if (i3 == this.bitmapCountSum) {
                if ((!this.specialDrawableList.isEmpty()) && this.specialDrawableList.get(0) != null) {
                    drawDrawable(canvas, this.specialDrawableList.get(0), this.flatter.getSpecialPosition().x, this.flatter.getSpecialPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                }
            } else if (i3 < this.specialDrawableList.size() && this.specialDrawableList.get(this.currentDrawableIndex) != null) {
                drawDrawable(canvas, this.specialDrawableList.get(this.currentDrawableIndex), this.flatter.getSpecialPosition().x, this.flatter.getSpecialPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
            }
            int i4 = 255 - i2;
            if (this.currentDrawableIndex - 1 >= this.specialDrawableList.size() || this.specialDrawableList.get(this.currentDrawableIndex - 1) == null) {
                return;
            }
            this.specialDrawableList.get(this.currentDrawableIndex - 1).setAlpha(i4);
            drawDrawable(canvas, this.specialDrawableList.get(this.currentDrawableIndex - 1), this.flatter.getSpecialPosition().x, this.flatter.getSpecialPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
            return;
        }
        int i5 = this.currentDrawableIndex + 1;
        this.currentDrawableIndex = i5;
        if (i5 > this.bitmapCountSum) {
            this.currentDrawableIndex = 1;
        }
        this.isChangeBg = false;
        if (this.currentDrawableIndex - 1 >= this.specialDrawableList.size() || this.specialDrawableList.get(this.currentDrawableIndex - 1) == null) {
            return;
        }
        this.specialDrawableList.get(this.currentDrawableIndex - 1).setAlpha(255);
        drawDrawable(canvas, this.specialDrawableList.get(this.currentDrawableIndex - 1), this.flatter.getSpecialPosition().x, this.flatter.getSpecialPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
    }

    public final boolean todoClick(int x, int y) {
        if (this.flatter.getConfig().getSupport_multiple_change() == 1 && this.bitmapCountSum > 0) {
            int special_x = this.flatter.getConfig().getSpecial_x();
            int special_y = this.flatter.getConfig().getSpecial_y();
            int iIntValue = (getSupportScale() ? Float.valueOf(this.specialDrawableList.get(0).getIntrinsicWidth() * this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX()) : Integer.valueOf(this.specialDrawableList.get(0).getIntrinsicWidth())).intValue();
            int iIntValue2 = (getSupportScale() ? Float.valueOf(this.specialDrawableList.get(0).getIntrinsicHeight() * this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY()) : Integer.valueOf(this.specialDrawableList.get(0).getIntrinsicHeight())).intValue();
            if (this.specialDrawableList.get(0) != null && x >= special_x && x <= iIntValue + special_x && y >= special_y && y <= iIntValue2 + special_y) {
                this.isChangeBg = true;
                this.lastDrawTime = SystemClock.uptimeMillis();
                return true;
            }
        }
        return false;
    }

    private final boolean checkAndPerformClick(Drawable drawable, int x, int y) {
        if (drawable == null) {
            return false;
        }
        Rect bounds = drawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        return expandBound(bounds).contains(x, y);
    }

    private final Rect expandBound(Rect bounds) {
        return new Rect(bounds.left - 5, bounds.top - 5, bounds.right + 5, bounds.bottom + 5);
    }
}
