package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.dw.launcher.data.entity.CompassConfig;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.google.android.mms.pdu.CharacterSets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SpecialCompassPainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J6\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0002J6\u0010#\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0002J8\u0010$\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0002J\u0010\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0002J!\u0010-\u001a\u00020\u00182\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0.\"\u00020/H\u0016¢\u0006\u0002\u00100R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u00061"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/SpecialCompassPainter;", "Lcom/dw/launcher/ui/clock/painter/IBasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "compassAngle", "", "compassConfig", "Lcom/dw/launcher/data/entity/CompassConfig;", "getCompassConfig", "()Lcom/dw/launcher/data/entity/CompassConfig;", "setCompassConfig", "(Lcom/dw/launcher/data/entity/CompassConfig;)V", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "supportScale", "", "getSupportScale", "()Z", "setSupportScale", "(Z)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawDegreeDrawable", "drawables", "", "Landroid/graphics/drawable/Drawable;", "left", "top", "drawDirection", "drawDrawable", "drawable", "x", "y", "scaleX", "", "scaleY", "findPreviousMultipleOf5", "value", "updateParams", "", "", "([Ljava/lang/Object;)V", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class SpecialCompassPainter implements IBasePainter {
    private int compassAngle;
    private CompassConfig compassConfig;
    private final Context context;
    private final ClockConfigFlatter flatter;
    private boolean supportScale;

    public SpecialCompassPainter(Context context, ClockConfigFlatter flatter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        CompassConfig compassConfig = flatter.getCompassConfig();
        Intrinsics.checkNotNull(compassConfig);
        this.compassConfig = compassConfig;
        this.supportScale = flatter.getConfig().supportScale();
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public final CompassConfig getCompassConfig() {
        return this.compassConfig;
    }

    public final void setCompassConfig(CompassConfig compassConfig) {
        Intrinsics.checkNotNullParameter(compassConfig, "<set-?>");
        this.compassConfig = compassConfig;
    }

    public final boolean getSupportScale() {
        return this.supportScale;
    }

    public final void setSupportScale(boolean z) {
        this.supportScale = z;
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        CompassConfig compassConfig = this.flatter.getCompassConfig();
        if (compassConfig != null) {
            int i = this.compassConfig.getCompass_direction_degree_Position().x;
            int i2 = this.compassConfig.getCompass_direction_degree_Position().y;
            List<? extends Drawable> compass_direction_degree_Drawable = compassConfig.getCompass_direction_degree_Drawable();
            if (compass_direction_degree_Drawable != null) {
                int iDrawDegreeDrawable = drawDegreeDrawable(canvas, compass_direction_degree_Drawable, this.compassAngle, i, i2);
                Drawable compass_direction_degree_unit_Drawable = compassConfig.getCompass_direction_degree_unit_Drawable();
                if (compass_direction_degree_unit_Drawable != null) {
                    compass_direction_degree_unit_Drawable.getIntrinsicWidth();
                    this.flatter.getScaleX();
                    drawDrawable(canvas, compass_direction_degree_unit_Drawable, iDrawDegreeDrawable, i2, this.flatter.getScaleX(), this.flatter.getScaleY());
                }
            }
            int iFindPreviousMultipleOf5 = findPreviousMultipleOf5(this.compassAngle);
            List<? extends Drawable> compass_degree_1_Drawable = compassConfig.getCompass_degree_1_Drawable();
            if (compass_degree_1_Drawable != null) {
                drawDegreeDrawable(canvas, compass_degree_1_Drawable, (iFindPreviousMultipleOf5 + 330) % 360, this.compassConfig.getCompass_degree_1_Position().x, this.compassConfig.getCompass_degree_1_Position().y);
            }
            List<? extends Drawable> compass_degree_2_Drawable = compassConfig.getCompass_degree_2_Drawable();
            if (compass_degree_2_Drawable != null) {
                drawDegreeDrawable(canvas, compass_degree_2_Drawable, iFindPreviousMultipleOf5, this.compassConfig.getCompass_degree_2_Position().x, this.compassConfig.getCompass_degree_2_Position().y);
            }
            List<? extends Drawable> compass_degree_3_Drawable = compassConfig.getCompass_degree_3_Drawable();
            if (compass_degree_3_Drawable != null) {
                drawDegreeDrawable(canvas, compass_degree_3_Drawable, (iFindPreviousMultipleOf5 + 390) % 360, this.compassConfig.getCompass_degree_3_Position().x, this.compassConfig.getCompass_degree_3_Position().y);
            }
            List<? extends Drawable> compass_directionDrawable = compassConfig.getCompass_directionDrawable();
            if (compass_directionDrawable != null) {
                drawDirection(canvas, compass_directionDrawable, this.compassAngle, this.compassConfig.getCompass_directionPosition().x, this.compassConfig.getCompass_directionPosition().y);
            }
            List<? extends Drawable> compass_direction_2_Drawable = compassConfig.getCompass_direction_2_Drawable();
            if (compass_direction_2_Drawable != null) {
                drawDirection(canvas, compass_direction_2_Drawable, (iFindPreviousMultipleOf5 + 330) % 360, this.compassConfig.getCompass_direction_2_Position().x, this.compassConfig.getCompass_direction_2_Position().y);
            }
            List<? extends Drawable> compass_direction_3_Drawable = compassConfig.getCompass_direction_3_Drawable();
            if (compass_direction_3_Drawable != null) {
                drawDirection(canvas, compass_direction_3_Drawable, (iFindPreviousMultipleOf5 + 390) % 360, this.compassConfig.getCompass_direction_3_Position().x, this.compassConfig.getCompass_direction_3_Position().y);
            }
        }
    }

    private final int findPreviousMultipleOf5(int value) {
        Integer next;
        if (value == 0) {
            return 0;
        }
        Iterator<Integer> it = RangesKt.downTo(value - 1, 0).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (next.intValue() % 5 != 0);
        Integer num = next;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void updateParams(Object... compassAngle) {
        Intrinsics.checkNotNullParameter(compassAngle, "compassAngle");
        Object obj = compassAngle[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        this.compassAngle = ((Integer) obj).intValue();
    }

    private final void drawDirection(Canvas canvas, List<? extends Drawable> drawables, int compassAngle, int left, int top2) {
        float f = compassAngle;
        int i = 0;
        if (f < 337.5f && f > 22.5f) {
            if (22.5f < f && f < 67.5f) {
                i = 1;
            } else if (67.5f <= f && f <= 112.5f) {
                i = 2;
            } else if (112.5f < f && f < 157.5f) {
                i = 3;
            } else if (157.5f <= f && f <= 202.5f) {
                i = 4;
            } else if (202.5f < f && f < 247.5f) {
                i = 5;
            } else if (247.5f <= f && f <= 292.5f) {
                i = 6;
            } else if (292.5f < f && f < 337.5f) {
                i = 7;
            }
        }
        drawDrawable(canvas, drawables.get(i), left - (drawables.get(i).getIntrinsicWidth() / 2), top2, this.supportScale ? this.flatter.getAbsoluteScaleX() : 1.0f, this.supportScale ? this.flatter.getAbsoluteScaleY() : 1.0f);
    }

    private final int drawDegreeDrawable(Canvas canvas, List<? extends Drawable> drawables, int compassAngle, int left, int top2) {
        int intrinsicWidth;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.ENGLISH, "%03d", Arrays.copyOf(new Object[]{Integer.valueOf(compassAngle)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        String str2 = str;
        ArrayList arrayList = new ArrayList(str2.length());
        for (int i = 0; i < str2.length(); i++) {
            arrayList.add(Integer.valueOf(Integer.parseInt(String.valueOf(str2.charAt(i)))));
        }
        Integer[] numArr = (Integer[]) arrayList.toArray(new Integer[0]);
        if (drawables.size() > 3) {
            Iterator<T> it = drawables.subList(0, 3).iterator();
            intrinsicWidth = 0;
            while (it.hasNext()) {
                intrinsicWidth += ((Drawable) it.next()).getIntrinsicWidth();
            }
        } else {
            Iterator<T> it2 = drawables.iterator();
            intrinsicWidth = 0;
            while (it2.hasNext()) {
                intrinsicWidth += ((Drawable) it2.next()).getIntrinsicWidth();
            }
        }
        int i2 = left - (intrinsicWidth / 2);
        for (Integer num : numArr) {
            Drawable drawable = drawables.get(num.intValue());
            int intrinsicWidth2 = (int) (drawable.getIntrinsicWidth() * this.flatter.getScaleX());
            drawDrawable(canvas, drawable, i2, top2, this.flatter.getScaleX(), this.flatter.getScaleY());
            i2 += intrinsicWidth2;
        }
        return i2;
    }

    private final void drawDrawable(Canvas canvas, Drawable drawable, int x, int y, float scaleX, float scaleY) {
        drawable.setBounds(x, y, ((int) (drawable.getIntrinsicWidth() * scaleX)) + x, ((int) (drawable.getIntrinsicHeight() * scaleY)) + y);
        drawable.draw(canvas);
    }
}
