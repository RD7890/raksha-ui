package com.dw.launcher.ui.dashboard.util;

import android.content.Context;
import com.dw.launcher.util.SystemProperties;
import com.dw.launcher.util.UtilsKt;
import com.google.android.mms.pdu.CharacterSets;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BubbleCalculator2.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u000234B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0002J \u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0005H\u0002J \u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0005H\u0002J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00160+2\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\u0005J\u001a\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\b2\b\b\u0002\u00100\u001a\u00020\bJ*\u00101\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00162\b\b\u0002\u0010/\u001a\u00020\b2\b\b\u0002\u00100\u001a\u00020\bR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/dw/launcher/ui/dashboard/util/BubbleCalculator2;", "", "context", "Landroid/content/Context;", "width", "", "height", "sphereR", "", "hexR", "edge", "scale", "(Landroid/content/Context;IIFFIF)V", "SQRT_3_OVER_2", "getSQRT_3_OVER_2", "()F", "getHexR", "setHexR", "(F)V", "mItemCount", "positions", "Ljava/util/ArrayList;", "Lcom/dw/launcher/ui/dashboard/util/BubbleCalculator2$Position;", "Lkotlin/collections/ArrayList;", "getScale", "setScale", "getSphereR", "setSphereR", "getPositionAt", "index", "getTotalLine", "count", "getTotalWithMinLine", "minLine", "getXScale", "x", "absX", "centerX", "getYScale", "y", "absY", "centerY", "initPosition", "", "size", "transform", "", "scrollX", "scrollY", "transformToTarget", "position", "Companion", "Position", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class BubbleCalculator2 {
    public static final boolean DEBUG = false;
    private static final String TAG = "BubbleCalculator";
    private static final float maxScale = 1.0f;
    private static final float minScale = 0.0f;
    private final float SQRT_3_OVER_2;
    private final Context context;
    private final int edge;
    private final int height;
    private float hexR;
    private int mItemCount;
    private final ArrayList<Position> positions;
    private float scale;
    private float sphereR;
    private final int width;

    private final int getTotalWithMinLine(int minLine) {
        int i = minLine * 3;
        return ((minLine * i) - i) + 1;
    }

    public BubbleCalculator2(Context context, int i, int i2, float f, float f2, int i3, float f3) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.width = i;
        this.height = i2;
        this.sphereR = f;
        this.hexR = f2;
        this.edge = i3;
        this.scale = f3;
        this.positions = new ArrayList<>();
        this.SQRT_3_OVER_2 = ((float) Math.sqrt(3.0f)) / 2;
    }

    public /* synthetic */ BubbleCalculator2(Context context, int i, int i2, float f, float f2, int i3, float f3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, i2, f, f2, i3, (i4 & 64) != 0 ? 1.0f : f3);
    }

    public final float getSphereR() {
        return this.sphereR;
    }

    public final void setSphereR(float f) {
        this.sphereR = f;
    }

    public final float getHexR() {
        return this.hexR;
    }

    public final void setHexR(float f) {
        this.hexR = f;
    }

    public final float getScale() {
        return this.scale;
    }

    public final void setScale(float f) {
        this.scale = f;
    }

    /* JADX INFO: compiled from: BubbleCalculator2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/dw/launcher/ui/dashboard/util/BubbleCalculator2$Position;", "", "initX", "", "initY", "(FF)V", "getInitX", "()F", "getInitY", "scale", "getScale", "setScale", "(F)V", "x", "getX", "setX", "y", "getY", "setY", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class Position {
        private final float initX;
        private final float initY;
        private float scale = 1.0f;
        private float x;
        private float y;

        public Position(float f, float f2) {
            this.initX = f;
            this.initY = f2;
        }

        public final float getInitX() {
            return this.initX;
        }

        public final float getInitY() {
            return this.initY;
        }

        public final float getScale() {
            return this.scale;
        }

        public final void setScale(float f) {
            this.scale = f;
        }

        public final float getX() {
            return this.x;
        }

        public final void setX(float f) {
            this.x = f;
        }

        public final float getY() {
            return this.y;
        }

        public final void setY(float f) {
            this.y = f;
        }
    }

    public final Position getPositionAt(int index) {
        Position position = this.positions.get(index);
        Intrinsics.checkNotNullExpressionValue(position, "get(...)");
        return position;
    }

    public final int getTotalLine(int count) {
        int i = 3;
        while (getTotalWithMinLine(i) < count) {
            i++;
        }
        return i;
    }

    public final List<Position> initPosition(int count) {
        this.mItemCount = count;
        int i = 3;
        while (getTotalWithMinLine(i) < count) {
            i++;
        }
        this.positions.clear();
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = -i2;
            if (i3 <= i2) {
                int i4 = i3;
                while (true) {
                    if (i3 <= i2) {
                        int i5 = i3;
                        while (true) {
                            if (i3 <= i2) {
                                int i6 = i3;
                                while (true) {
                                    if (Math.abs(i4) + Math.abs(i5) + Math.abs(i6) == i2 * 2 && i4 + i5 + i6 == 0) {
                                        this.positions.add(new Position(i4, i5));
                                    }
                                    if (i6 == i2) {
                                        break;
                                    }
                                    i6++;
                                }
                            }
                            if (i5 == i2) {
                                break;
                            }
                            i5++;
                        }
                    }
                    if (i4 != i2) {
                        i4++;
                    }
                }
            }
        }
        return this.positions;
    }

    public static /* synthetic */ void transform$default(BubbleCalculator2 bubbleCalculator2, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        bubbleCalculator2.transform(f, f2);
    }

    public final void transform(float scrollX, float scrollY) {
        int i = 0;
        for (Object obj : this.positions) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Position position = (Position) obj;
            if (i < this.mItemCount) {
                transformToTarget(i, position, scrollX, scrollY);
            }
            i = i2;
        }
    }

    public final float getSQRT_3_OVER_2() {
        return this.SQRT_3_OVER_2;
    }

    public static /* synthetic */ void transformToTarget$default(BubbleCalculator2 bubbleCalculator2, int i, Position position, float f, float f2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f2 = 0.0f;
        }
        bubbleCalculator2.transformToTarget(i, position, f, f2);
    }

    public final void transformToTarget(int index, Position position, float scrollX, float scrollY) {
        Intrinsics.checkNotNullParameter(position, "position");
        position.setX(((position.getInitY() + (position.getInitX() / 2.0f)) * this.hexR) + scrollX);
        position.setY((this.SQRT_3_OVER_2 * position.getInitX() * this.hexR) + scrollY);
        double d = 2;
        float fSqrt = (float) Math.sqrt(((float) Math.pow(position.getX(), d)) + ((float) Math.pow(position.getY(), d)));
        double dAtan2 = (float) Math.atan2(position.getY(), position.getX());
        float f = 10;
        float fRint = ((float) Math.rint((((float) Math.cos(dAtan2)) * fSqrt) * f)) / f;
        float fRint2 = ((float) Math.rint((fSqrt * ((float) Math.sin(dAtan2))) * f)) / f;
        float fSqrt2 = UtilsKt.isRound(this.context) ? this.width / 2.0f : ((float) Math.sqrt(((float) Math.pow(this.width / 2.0f, d)) + ((float) Math.pow(this.height / 2.0f, d)))) - ((SystemProperties.INSTANCE.getInt("ro.dw.screen_corner", 40) * ((float) Math.sqrt(2.0f))) / 2);
        float fCoerceAtMost = (UtilsKt.isRound(this.context) ? fSqrt2 * 1.2f : 1.3f * fSqrt2) / RangesKt.coerceAtMost(this.scale, 1.0f);
        float fSqrt3 = (float) Math.sqrt(((float) Math.pow(position.getX(), d)) + ((float) Math.pow(position.getY(), d)));
        float fSqrt4 = UtilsKt.isRound(this.context) ? (float) Math.sqrt(((float) Math.pow(this.width / 2.0f, d)) + ((float) Math.pow(this.height / 2.0f, d))) : ((float) Math.sqrt(((float) Math.pow(this.width / 2.0f, d)) + ((float) Math.pow(this.height / 2.0f, d)))) * 1.2f;
        float fSin = (fCoerceAtMost * ((float) Math.sin(fSqrt3 / fCoerceAtMost))) / fSqrt3;
        float fEaseOutQuint = EasingFunctionKt.easeOutQuint(fSin, UtilsKt.isRound(this.context) ? 1.2f : 1.0f) * fSin;
        if (fSqrt3 != 0.0f && 0.0f <= fSqrt3 && fSqrt3 <= fSqrt4) {
            position.setX(fRint * fEaseOutQuint);
            position.setY(fEaseOutQuint * fRint2);
        } else {
            position.setX(fRint);
            position.setY(fRint2);
        }
        float fSqrt5 = (float) Math.sqrt(RangesKt.coerceAtLeast(((float) Math.pow(fSqrt2, d)) - ((float) Math.pow(((float) Math.sin(fSqrt3 / fSqrt2)) * fSqrt2, d)), 0.0f));
        if (fSqrt3 == 0.0f) {
            position.setScale(1.0f);
        } else if (0.0f <= fSqrt3 && fSqrt3 <= fSqrt4) {
            float f2 = fSqrt5 / fSqrt2;
            position.setScale(EasingFunctionKt.easeOutQuint(f2, UtilsKt.isRound(this.context) ? 2.0f : 1.5f) * f2);
        } else {
            position.setScale(0.0f);
        }
    }

    private final float getYScale(float y, float absY, int centerY) {
        float f = this.hexR;
        float f2 = centerY;
        int i = (y > f2 ? 1 : (y == f2 ? 0 : -1));
        return 1.0f - ((((absY - f2) + (f / 2)) / f) * 1.0f);
    }

    private final float getXScale(float x, float absX, int centerX) {
        float f = this.hexR;
        float f2 = centerX;
        int i = (x > f2 ? 1 : (x == f2 ? 0 : -1));
        return 1.0f - ((((absX - f2) + (f / 2)) / f) * 1.0f);
    }

    public final int size() {
        return this.positions.size();
    }
}
