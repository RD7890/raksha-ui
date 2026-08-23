package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.format.DateFormat;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.google.android.mms.pdu.CharacterSets;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

/* JADX INFO: compiled from: SpecialTimeDrawer.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J.\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010>\u001a\u00020\r2\u0006\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020\rJ\u0012\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\rH\u0002J!\u0010E\u001a\u0002092\u0012\u0010F\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0G\"\u00020HH\u0016¢\u0006\u0002\u0010IR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u001a\u0010*\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001a\u0010-\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R\"\u00100\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R\"\u00103\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000f\"\u0004\b5\u0010\u0011R\u0014\u00106\u001a\u00020\u001cX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001e¨\u0006J"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/SpecialTimeDrawer;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "getContext", "()Landroid/content/Context;", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "hourDrawable", "", "Landroid/graphics/drawable/Drawable;", "getHourDrawable", "()Ljava/util/List;", "setHourDrawable", "(Ljava/util/List;)V", "hourPosition", "Landroid/graphics/Point;", "getHourPosition", "()Landroid/graphics/Point;", "setHourPosition", "(Landroid/graphics/Point;)V", "hourTenPosition", "getHourTenPosition", "setHourTenPosition", "index", "", "getIndex", "()I", "setIndex", "(I)V", "lastDrawTime", "", "getLastDrawTime", "()J", "setLastDrawTime", "(J)V", "minDrawable", "getMinDrawable", "setMinDrawable", "minPosition", "getMinPosition", "setMinPosition", "minTenPosition", "getMinTenPosition", "setMinTenPosition", "tenHourDrawable", "getTenHourDrawable", "setTenHourDrawable", "tenMinDrawable", "getTenMinDrawable", "setTenMinDrawable", "totalNumbers", "getTotalNumbers", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "hourTenDigitalDrawable", "hourDigitalDrawable", "minTenDigitalDrawable", "minDigitalDrawable", "drawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "updateParams", "params", "", "", "([Ljava/lang/Object;)V", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class SpecialTimeDrawer extends ABasePainter {
    private final Context context;
    private final ClockConfigFlatter flatter;
    private List<? extends Drawable> hourDrawable;
    private Point hourPosition;
    private Point hourTenPosition;
    private int index;
    private long lastDrawTime;
    private List<? extends Drawable> minDrawable;
    private Point minPosition;
    private Point minTenPosition;
    private List<? extends Drawable> tenHourDrawable;
    private List<? extends Drawable> tenMinDrawable;
    private final int totalNumbers;

    public SpecialTimeDrawer(Context context, ClockConfigFlatter flatter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.hourTenPosition = new Point(0, 0);
        this.hourPosition = new Point(0, 0);
        this.minTenPosition = new Point(0, 0);
        this.minPosition = new Point(0, 0);
        this.totalNumbers = 10;
        setSupportScale(flatter.getConfig().supportScale());
        flatter.setPosition(this.hourTenPosition, 0, 0);
        flatter.setPosition(this.hourPosition, flatter.getMScreenWidth() / 2, 0);
        flatter.setPosition(this.minTenPosition, 0, flatter.getMScreenHeight() / 2);
        flatter.setPosition(this.minPosition, flatter.getMScreenWidth() / 2, flatter.getMScreenHeight() / 2);
        this.tenHourDrawable = flatter.splitDrawable(flatter.getConfig().getTime_special_hour_ten_src(), 10);
        this.hourDrawable = flatter.splitDrawable(flatter.getConfig().getTime_special_hour_src(), 10);
        this.tenMinDrawable = flatter.splitDrawable(flatter.getConfig().getTime_special_min_ten_src(), 10);
        this.minDrawable = flatter.splitDrawable(flatter.getConfig().getTime_special_min_src(), 10);
    }

    public final Context getContext() {
        return this.context;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public final long getLastDrawTime() {
        return this.lastDrawTime;
    }

    public final void setLastDrawTime(long j) {
        this.lastDrawTime = j;
    }

    public final Point getHourTenPosition() {
        return this.hourTenPosition;
    }

    public final void setHourTenPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.hourTenPosition = point;
    }

    public final Point getHourPosition() {
        return this.hourPosition;
    }

    public final void setHourPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.hourPosition = point;
    }

    public final Point getMinTenPosition() {
        return this.minTenPosition;
    }

    public final void setMinTenPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.minTenPosition = point;
    }

    public final Point getMinPosition() {
        return this.minPosition;
    }

    public final void setMinPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.minPosition = point;
    }

    public final int getTotalNumbers() {
        return this.totalNumbers;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final List<Drawable> getTenHourDrawable() {
        return this.tenHourDrawable;
    }

    public final void setTenHourDrawable(List<? extends Drawable> list) {
        this.tenHourDrawable = list;
    }

    public final List<Drawable> getHourDrawable() {
        return this.hourDrawable;
    }

    public final void setHourDrawable(List<? extends Drawable> list) {
        this.hourDrawable = list;
    }

    public final List<Drawable> getTenMinDrawable() {
        return this.tenMinDrawable;
    }

    public final void setTenMinDrawable(List<? extends Drawable> list) {
        this.tenMinDrawable = list;
    }

    public final List<Drawable> getMinDrawable() {
        return this.minDrawable;
    }

    public final void setMinDrawable(List<? extends Drawable> list) {
        this.minDrawable = list;
    }

    public final void draw(Canvas canvas, Drawable hourTenDigitalDrawable, Drawable hourDigitalDrawable, Drawable minTenDigitalDrawable, Drawable minDigitalDrawable) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(hourTenDigitalDrawable, "hourTenDigitalDrawable");
        Intrinsics.checkNotNullParameter(hourDigitalDrawable, "hourDigitalDrawable");
        Intrinsics.checkNotNullParameter(minTenDigitalDrawable, "minTenDigitalDrawable");
        Intrinsics.checkNotNullParameter(minDigitalDrawable, "minDigitalDrawable");
        if (this.lastDrawTime == 0) {
            this.lastDrawTime = SystemClock.uptimeMillis();
        }
        int i = this.index;
        int i2 = this.totalNumbers;
        if (i < i2) {
            float f = (i2 - i) / i2;
            Bitmap bitmapDrawableToBitmap = drawableToBitmap(hourTenDigitalDrawable);
            if (bitmapDrawableToBitmap != null) {
                drawDrawable(canvas, new BitmapDrawable(Bitmap.createBitmap(bitmapDrawableToBitmap, (int) (bitmapDrawableToBitmap.getWidth() - (bitmapDrawableToBitmap.getWidth() * f)), 0, (int) (bitmapDrawableToBitmap.getWidth() * f), bitmapDrawableToBitmap.getHeight())), this.hourTenPosition.x, this.hourTenPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.flatter.getScaleY());
            }
            Bitmap bitmapDrawableToBitmap2 = drawableToBitmap(hourDigitalDrawable);
            if (bitmapDrawableToBitmap2 != null) {
                drawDrawable(canvas, new BitmapDrawable(Bitmap.createBitmap(bitmapDrawableToBitmap2, 0, (int) (bitmapDrawableToBitmap2.getHeight() - (bitmapDrawableToBitmap2.getHeight() * f)), bitmapDrawableToBitmap2.getWidth(), (int) (bitmapDrawableToBitmap2.getHeight() * f))), this.hourPosition.x, this.hourPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.flatter.getScaleY());
            }
            Bitmap bitmapDrawableToBitmap3 = drawableToBitmap(minTenDigitalDrawable);
            if (bitmapDrawableToBitmap3 != null) {
                drawDrawable(canvas, new BitmapDrawable(Bitmap.createBitmap(bitmapDrawableToBitmap3, 0, 0, bitmapDrawableToBitmap3.getWidth(), (int) (bitmapDrawableToBitmap3.getHeight() * f))), this.minTenPosition.x, this.minTenPosition.y + ((int) (bitmapDrawableToBitmap3.getHeight() - (bitmapDrawableToBitmap3.getHeight() * f))), getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.flatter.getScaleY());
            }
            Bitmap bitmapDrawableToBitmap4 = drawableToBitmap(minDigitalDrawable);
            if (bitmapDrawableToBitmap4 != null) {
                drawDrawable(canvas, new BitmapDrawable(Bitmap.createBitmap(bitmapDrawableToBitmap4, 0, 0, (int) (bitmapDrawableToBitmap4.getWidth() * f), bitmapDrawableToBitmap4.getHeight())), this.minPosition.x + ((int) (bitmapDrawableToBitmap4.getWidth() - (f * bitmapDrawableToBitmap4.getWidth()))), this.minPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.flatter.getScaleY());
            }
            this.index++;
        } else if (i >= i2 && i <= i2 * 2) {
            float fCoerceIn = RangesKt.coerceIn(((i2 * 2) - i) / i2, 0.0f, 1.0f);
            this.index++;
            Bitmap bitmapDrawableToBitmap5 = drawableToBitmap(hourTenDigitalDrawable);
            if (bitmapDrawableToBitmap5 != null) {
                drawDrawable(canvas, new BitmapDrawable(Bitmap.createBitmap(bitmapDrawableToBitmap5, 0, 0, bitmapDrawableToBitmap5.getWidth() - ((int) (bitmapDrawableToBitmap5.getWidth() * fCoerceIn)), bitmapDrawableToBitmap5.getHeight())), this.hourTenPosition.x + ((int) (bitmapDrawableToBitmap5.getWidth() * fCoerceIn)), this.hourTenPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.flatter.getScaleY());
            }
            Bitmap bitmapDrawableToBitmap6 = drawableToBitmap(hourDigitalDrawable);
            if (bitmapDrawableToBitmap6 != null) {
                drawDrawable(canvas, new BitmapDrawable(Bitmap.createBitmap(bitmapDrawableToBitmap6, 0, 0, bitmapDrawableToBitmap6.getWidth(), (int) (bitmapDrawableToBitmap6.getHeight() - (bitmapDrawableToBitmap6.getHeight() * fCoerceIn)))), this.hourPosition.x, this.hourPosition.y + ((int) (bitmapDrawableToBitmap6.getHeight() * fCoerceIn)), getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.flatter.getScaleY());
            }
            Bitmap bitmapDrawableToBitmap7 = drawableToBitmap(minTenDigitalDrawable);
            if (bitmapDrawableToBitmap7 != null) {
                drawDrawable(canvas, new BitmapDrawable(Bitmap.createBitmap(bitmapDrawableToBitmap7, 0, (int) (bitmapDrawableToBitmap7.getHeight() * fCoerceIn), bitmapDrawableToBitmap7.getWidth(), (int) (bitmapDrawableToBitmap7.getHeight() - (bitmapDrawableToBitmap7.getHeight() * fCoerceIn)))), this.minTenPosition.x, this.minTenPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.flatter.getScaleY());
            }
            Bitmap bitmapDrawableToBitmap8 = drawableToBitmap(minDigitalDrawable);
            if (bitmapDrawableToBitmap8 != null) {
                drawDrawable(canvas, new BitmapDrawable(Bitmap.createBitmap(bitmapDrawableToBitmap8, (int) (bitmapDrawableToBitmap8.getWidth() * fCoerceIn), 0, (int) (bitmapDrawableToBitmap8.getWidth() - (fCoerceIn * bitmapDrawableToBitmap8.getWidth())), bitmapDrawableToBitmap8.getHeight())), this.minPosition.x, this.minPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.flatter.getScaleY());
            }
        }
        int i3 = this.index;
        int i4 = this.totalNumbers;
        if (i3 >= i4 * 2) {
            this.index = i4 * 2;
        }
        Timber.INSTANCE.d("index:" + this.index, new Object[0]);
    }

    private final Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(11);
        int i2 = calendar.get(12);
        if (!DateFormat.is24HourFormat(this.context)) {
            if (i == 0) {
                i = 12;
            }
            if (i > 12) {
                i -= 12;
            }
        }
        List<? extends Drawable> list = this.tenHourDrawable;
        if (list != null) {
            Drawable drawable = list.get(i / 10);
            List<? extends Drawable> list2 = this.hourDrawable;
            Intrinsics.checkNotNull(list2);
            Drawable drawable2 = list2.get(i % 10);
            List<? extends Drawable> list3 = this.tenMinDrawable;
            Intrinsics.checkNotNull(list3);
            Drawable drawable3 = list3.get(i2 / 10);
            List<? extends Drawable> list4 = this.minDrawable;
            Intrinsics.checkNotNull(list4);
            draw(canvas, drawable, drawable2, drawable3, list4.get(i2 % 10));
        }
    }

    @Override // com.dw.launcher.ui.clock.painter.ABasePainter, com.dw.launcher.ui.clock.painter.IBasePainter
    public void updateParams(Object... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        Object obj = params[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        if (((Integer) obj).intValue() == 1) {
            this.index = 0;
        }
    }
}
