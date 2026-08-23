package com.dw.launcher.ui.dashboard.util;

import com.google.android.mms.pdu.CharacterSets;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BubbleCalculator.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0014\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 >2\u00020\u0001:\u0002>?B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u001a\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u0006H\u0002J(\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0002J*\u0010\"\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0002J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0002J*\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u0006J\u000e\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0003J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002J \u0010.\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0003H\u0002J \u00101\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0003H\u0002J\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u0012052\u0006\u00106\u001a\u00020\u0003J\u0006\u00107\u001a\u00020\u0003J\u001a\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020\u00062\b\b\u0002\u0010;\u001a\u00020\u0006J\"\u0010<\u001a\u0002092\u0006\u0010=\u001a\u00020\u00122\b\b\u0002\u0010:\u001a\u00020\u00062\b\b\u0002\u0010;\u001a\u00020\u0006R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/dw/launcher/ui/dashboard/util/BubbleCalculator;", "", "width", "", "height", "sphereR", "", "hexR", "edge", "(IIFFI)V", "SQRT_3_OVER_2", "getSQRT_3_OVER_2", "()F", "getHexR", "setHexR", "(F)V", "positions", "Ljava/util/ArrayList;", "Lcom/dw/launcher/ui/dashboard/util/BubbleCalculator$Position;", "Lkotlin/collections/ArrayList;", "checkBounds", "", "x", "y", "mHexRadius", "deEaseIn", "r", "easeIn", "t", "easeInOutCubic", "b", "easeInOutSine", "c", "d", "easeInSine", "easeOutSine", "getOffset", "", "offsetX", "offsetY", "steps", "float", "getPositionAt", "index", "getTotalWithMinLine", "minLine", "getXScale", "absX", "centerX", "getYScale", "absY", "centerY", "initPosition", "", "count", "size", "transform", "", "scrollX", "scrollY", "transformToTarget", "position", "Companion", "Position", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class BubbleCalculator {
    private static final String TAG = "BubbleCalculator";
    private static final float maxScale = 1.0f;
    private static final float minScale = 0.0f;
    private final int edge;
    private final int height;
    private float hexR;
    private final float sphereR;
    private final int width;
    private final ArrayList<Position> positions = new ArrayList<>();
    private final float SQRT_3_OVER_2 = ((float) Math.sqrt(3.0f)) / 2;

    private final int getTotalWithMinLine(int minLine) {
        int i = minLine * 3;
        return ((minLine * i) - i) + 1;
    }

    public BubbleCalculator(int i, int i2, float f, float f2, int i3) {
        this.width = i;
        this.height = i2;
        this.sphereR = f;
        this.hexR = f2;
        this.edge = i3;
    }

    public final float getHexR() {
        return this.hexR;
    }

    public final void setHexR(float f) {
        this.hexR = f;
    }

    /* JADX INFO: compiled from: BubbleCalculator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/dw/launcher/ui/dashboard/util/BubbleCalculator$Position;", "", "initX", "", "initY", "(FF)V", "getInitX", "()F", "getInitY", "scale", "getScale", "setScale", "(F)V", "x", "getX", "setX", "y", "getY", "setY", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
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

    public final List<Position> initPosition(int count) {
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

    public static /* synthetic */ void transform$default(BubbleCalculator bubbleCalculator, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        bubbleCalculator.transform(f, f2);
    }

    public final void transform(float scrollX, float scrollY) {
        int i = 0;
        for (Object obj : this.positions) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            transformToTarget((Position) obj, scrollX, scrollY);
            i = i2;
        }
    }

    public final float getSQRT_3_OVER_2() {
        return this.SQRT_3_OVER_2;
    }

    public static /* synthetic */ void transformToTarget$default(BubbleCalculator bubbleCalculator, Position position, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        bubbleCalculator.transformToTarget(position, f, f2);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:26:0x0104  */
    /* JADX WARN: Code duplicated, block: B:28:0x010d  */
    /* JADX WARN: Code duplicated, block: B:34:0x012c  */
    public final void transformToTarget(Position position, float scrollX, float scrollY) {
        float f;
        float yScale;
        Intrinsics.checkNotNullParameter(position, "position");
        position.setX(((position.getInitY() + (position.getInitX() / 2.0f)) * this.hexR) + scrollX);
        position.setY((this.SQRT_3_OVER_2 * position.getInitX() * this.hexR) + scrollY);
        double d = 2;
        float fSqrt = (float) Math.sqrt(((float) Math.pow(position.getX(), d)) + ((float) Math.pow(position.getY(), d)));
        double dAtan2 = (float) Math.atan2(position.getY(), position.getX());
        float f2 = 10;
        float fRint = (((float) Math.rint((((float) Math.cos(dAtan2)) * fSqrt) * f2)) / f2) * 1.1f;
        float fRint2 = (((float) Math.rint((fSqrt * ((float) Math.sin(dAtan2))) * f2)) / f2) * 1.2f;
        int i = this.width / 2;
        int i2 = this.height / 2;
        float fAbs = Math.abs(fRint);
        float fAbs2 = Math.abs(fRint2);
        float f3 = i;
        float f4 = this.hexR;
        float f5 = 2;
        if (fAbs >= f3 - (f4 / f5) && fAbs <= (f4 / f5) + f3) {
            float f6 = i2;
            if (fAbs2 >= f6 - (f4 / f5) && fAbs2 <= (f4 / f5) + f6) {
                float xScale = getXScale(fRint, fAbs, i);
                float yScale2 = getYScale(fRint2, fAbs2, i2);
                yScale = Math.min(xScale, yScale2);
                float f7 = this.hexR;
                fRint2 = fRint2 < f6 - (f7 / f5) ? fRint2 + ((f7 - (yScale2 * f7)) / f5) : fRint2 - ((f7 - (yScale2 * f7)) / f5);
                fRint = fRint < f3 - (f7 / f5) ? fRint + ((f7 - (xScale * f7)) / f5) : fRint - ((f7 - (xScale * f7)) / f5);
            } else if (fAbs >= f3 - (f4 / f5)) {
                f = i2;
                if (fAbs2 >= f - (f4 / f5)) {
                    yScale = 1.0f;
                } else {
                    yScale = 1.0f;
                }
            } else {
                f = i2;
                if (fAbs2 >= f - (f4 / f5)) {
                    yScale = 1.0f;
                } else {
                    yScale = 1.0f;
                }
            }
        } else if (fAbs >= f3 - (f4 / f5) || fAbs > (f4 / f5) + f3) {
            f = i2;
            if (fAbs2 >= f - (f4 / f5) || fAbs2 > (f4 / f5) + f) {
                yScale = 1.0f;
            } else {
                yScale = getYScale(fRint2, fAbs2, i2);
                float f8 = this.hexR;
                fRint2 = fRint2 < f - (f8 / f5) ? fRint2 + ((f8 - (f8 * yScale)) / f5) : fRint2 - ((f8 - (f8 * yScale)) / f5);
            }
        } else {
            yScale = getXScale(fRint, fAbs, i);
            float f9 = this.hexR;
            fRint = fRint < f3 - (f9 / f5) ? fRint + ((f9 - (f9 * yScale)) / f5) : fRint - ((f9 - (f9 * yScale)) / f5);
        }
        position.setX(fRint);
        position.setY(fRint2);
        position.setScale(yScale);
    }

    public static /* synthetic */ float[] getOffset$default(BubbleCalculator bubbleCalculator, float f, float f2, int i, float f3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 16;
        }
        if ((i2 & 8) != 0) {
            f3 = 1.0f;
        }
        return bubbleCalculator.getOffset(f, f2, i, f3);
    }

    public final float[] getOffset(float offsetX, float offsetY, int steps, float f) {
        float f2 = steps;
        float f3 = f * f2;
        float f4 = f3 - 1;
        float f5 = 0;
        return new float[]{InterpolatorUtils.INSTANCE.easeOutCubic(f3, 0.0f, offsetX, f2) - (InterpolatorUtils.INSTANCE.easeOutCubic(f4, 0.0f, offsetX, f2) * f5), InterpolatorUtils.INSTANCE.easeOutCubic(f3, 0.0f, offsetY, f2) - (InterpolatorUtils.INSTANCE.easeOutCubic(f4, 0.0f, offsetY, f2) * f5)};
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

    public final boolean checkBounds(float x, float y, float mHexRadius) {
        double d = x;
        double d2 = 2;
        double d3 = y;
        float fSqrt = (float) Math.sqrt(((float) Math.pow(d, d2)) + ((float) Math.pow(d3, d2)));
        double dAtan2 = (float) Math.atan2(d3, d);
        float f = 10;
        float fRint = (((float) Math.rint((((float) Math.cos(dAtan2)) * fSqrt) * f)) / f) * 1.1f;
        float fRint2 = (((float) Math.rint((fSqrt * ((float) Math.sin(dAtan2))) * f)) / f) * 1.2f;
        int i = this.width / 2;
        int i2 = this.height / 2;
        float fAbs = Math.abs(fRint);
        float fAbs2 = Math.abs(fRint2);
        float f2 = i;
        float f3 = mHexRadius / 2;
        if (fAbs < f2 - f3 || fAbs > f2 + f3) {
            return true;
        }
        float f4 = i2;
        return fAbs2 < f4 - f3 || fAbs2 > f4 + f3;
    }

    private final float easeIn(float t) {
        return InterpolatorUtils.INSTANCE.easeIn(t, 1.5f, -0.5f, 1.0f);
    }

    private final float deEaseIn(float r) {
        return InterpolatorUtils.INSTANCE.deEaseIn(r, 1.5f, -0.5f, 1.0f);
    }

    static /* synthetic */ float easeInOutCubic$default(BubbleCalculator bubbleCalculator, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        return bubbleCalculator.easeInOutCubic(f, f2);
    }

    private final float easeInOutCubic(float t, float b) {
        return InterpolatorUtils.INSTANCE.easeInOutCubic(t, b, -0.5f, 1.0f);
    }

    private final float easeInOutSine(float t, float b, float c, float d) {
        return InterpolatorUtils.INSTANCE.easeInOutSine(t, b, c, d);
    }

    private final float easeOutSine(float t, float d) {
        return InterpolatorUtils.INSTANCE.easeOutSine(t, 0.4f, 0.6f, d);
    }

    static /* synthetic */ float easeInSine$default(BubbleCalculator bubbleCalculator, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        return bubbleCalculator.easeInSine(f, f2, f3, f4);
    }

    private final float easeInSine(float t, float b, float c, float d) {
        return InterpolatorUtils.INSTANCE.easeInSine(t, b, c, d);
    }

    public final int size() {
        return this.positions.size();
    }
}
