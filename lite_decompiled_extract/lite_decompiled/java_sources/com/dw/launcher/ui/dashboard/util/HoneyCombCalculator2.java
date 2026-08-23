package com.dw.launcher.ui.dashboard.util;

import com.google.android.mms.pdu.CharacterSets;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

/* JADX INFO: compiled from: HoneyCombCalculator2.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002()B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0003J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001e2\u0006\u0010\u001f\u001a\u00020\u0003J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\u0003J\u001a\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020\u0006J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u0003H\u0002J,\u0010&\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00172\b\b\u0002\u0010$\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020\u0006H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/dw/launcher/ui/dashboard/util/HoneyCombCalculator2;", "", "width", "", "height", "sphereR", "", "hexR", "edge", "(IIFFI)V", "SIN_60", "", "SQRT_3_OVER_2", "TAN_60", "cachedIndex", "", "cachedParentIndex", "getHexR", "()F", "setHexR", "(F)V", "positions", "Ljava/util/ArrayList;", "Lcom/dw/launcher/ui/dashboard/util/HoneyCombCalculator2$Position;", "Lkotlin/collections/ArrayList;", "getPositionAt", "index", "getTotalWithMinLine", "minLine", "initPosition", "", "count", "lineCounter", "size", "transform", "", "scrollX", "scrollY", "transformToTarget", "position", "Companion", "Position", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class HoneyCombCalculator2 {
    private static final int INVALID_OFFSET = -100;
    private static final String TAG = "BubbleCalculator";
    private static final float maxScale = 1.0f;
    private static final float minScale = 0.0f;
    private static final Integer[][] neighbors;
    private final int edge;
    private final int height;
    private float hexR;
    private final float sphereR;
    private final int width;
    private final ArrayList<Position> positions = new ArrayList<>();
    private final Set<Integer> cachedIndex = new LinkedHashSet();
    private final Set<Integer> cachedParentIndex = new LinkedHashSet();
    private final double TAN_60 = Math.tan(1.0471975511965976d);
    private final float SQRT_3_OVER_2 = ((float) Math.sqrt(3.0f)) / 2;
    private final double SIN_60 = Math.sin(1.0471975511965976d);

    private final int getTotalWithMinLine(int minLine) {
        int i = minLine * 3;
        return ((minLine * i) - i) + 1;
    }

    public HoneyCombCalculator2(int i, int i2, float f, float f2, int i3) {
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

    static {
        Integer numValueOf = Integer.valueOf(INVALID_OFFSET);
        neighbors = new Integer[][]{new Integer[]{1, 4, 3, numValueOf, -4, -3}, new Integer[]{1, 4, 3, -1, -4, -3}, new Integer[]{numValueOf, 4, 3, -1, -4, -3}, new Integer[]{1, 4, numValueOf, numValueOf, numValueOf, -3}, new Integer[]{1, 4, 3, -1, -4, -3}, new Integer[]{1, 4, 3, -1, -4, -3}, new Integer[]{numValueOf, numValueOf, 3, -1, -4, numValueOf}};
    }

    /* JADX INFO: compiled from: HoneyCombCalculator2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/dw/launcher/ui/dashboard/util/HoneyCombCalculator2$Position;", "", "initX", "", "initY", "(FF)V", "getInitX", "()F", "getInitY", "originalX", "getOriginalX", "setOriginalX", "(F)V", "originalY", "getOriginalY", "setOriginalY", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "scale", "getScale", "setScale", "x", "getX", "setX", "y", "getY", "setY", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class Position {
        private final float initX;
        private final float initY;
        private float originalX;
        private float originalY;
        private float x;
        private float y;
        private float scale = 1.0f;
        private float pivotX = 0.5f;
        private float pivotY = 0.5f;

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

        public final float getOriginalX() {
            return this.originalX;
        }

        public final void setOriginalX(float f) {
            this.originalX = f;
        }

        public final float getOriginalY() {
            return this.originalY;
        }

        public final void setOriginalY(float f) {
            this.originalY = f;
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

        public final float getPivotX() {
            return this.pivotX;
        }

        public final void setPivotX(float f) {
            this.pivotX = f;
        }

        public final float getPivotY() {
            return this.pivotY;
        }

        public final void setPivotY(float f) {
            this.pivotY = f;
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
                                        Timber.INSTANCE.d("(" + i4 + ',' + i5 + ")  line: " + i + " count: " + count, new Object[0]);
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

    public static /* synthetic */ List initPosition$default(HoneyCombCalculator2 honeyCombCalculator2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 3;
        }
        return honeyCombCalculator2.initPosition(i, i2);
    }

    public final List<Position> initPosition(int count, int lineCounter) {
        boolean z = true;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 3;
            if (i >= count) {
                break;
            }
            if (!z) {
                i3 = 4;
            }
            i += i3;
            z = !z;
            i2++;
        }
        this.positions.clear();
        if (i2 >= 0) {
            int i4 = 0;
            while (true) {
                int i5 = -1;
                if (i4 % 2 == 0) {
                    while (i5 < 2) {
                        this.positions.add(new Position(i5, i4 - 2));
                        i5++;
                    }
                } else {
                    while (i5 < 3) {
                        this.positions.add(new Position(i5, i4 - 2));
                        i5++;
                    }
                }
                if (i4 == i2) {
                    break;
                }
                i4++;
            }
        }
        Timber.INSTANCE.d("positions: " + this.positions.size() + " line: " + i2, new Object[0]);
        return this.positions;
    }

    public static /* synthetic */ void transform$default(HoneyCombCalculator2 honeyCombCalculator2, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        honeyCombCalculator2.transform(f, f2);
    }

    public final void transform(float scrollX, float scrollY) {
        float f = Float.MAX_VALUE;
        int i = 0;
        for (Object obj : this.positions) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Position position = (Position) obj;
            transformToTarget(i, position, scrollX, scrollY);
            double d = 2;
            float fPow = ((float) Math.pow(position.getX(), d)) + ((float) Math.pow(position.getY(), d));
            if (fPow < f) {
                f = fPow;
            }
            i = i2;
        }
    }

    private final void transform(int index) {
        if (this.cachedParentIndex.contains(Integer.valueOf(index))) {
            return;
        }
        float f = this.hexR;
        Position position = this.positions.get(index);
        String str = "get(...)";
        Intrinsics.checkNotNullExpressionValue(position, "get(...)");
        Position position2 = position;
        Integer[][] numArr = neighbors;
        int length = index % numArr.length;
        Integer[] numArr2 = numArr[length];
        this.cachedParentIndex.add(Integer.valueOf(index));
        int length2 = numArr2.length;
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            int i3 = i2 + 1;
            int iIntValue = numArr2[i].intValue();
            int i4 = iIntValue + index;
            if (iIntValue == INVALID_OFFSET || i4 < 0 || i4 >= size()) {
                numArr2 = numArr2;
                i3 = i3;
            } else {
                if (this.cachedIndex.contains(Integer.valueOf(i4)) || this.cachedParentIndex.contains(Integer.valueOf(i4))) {
                    str = str;
                    numArr2 = numArr2;
                    i3 = i3;
                    Timber.INSTANCE.d("skip transform, index: " + index + ", mod: " + length + ", n: " + i4, new Object[0]);
                } else {
                    Position position3 = this.positions.get(i4);
                    Intrinsics.checkNotNullExpressionValue(position3, str);
                    Position position4 = position3;
                    this.cachedIndex.add(Integer.valueOf(i4));
                    if (i2 == 0) {
                        float f2 = 2;
                        position4.setX(position2.getX() + ((position2.getScale() * f) / f2) + ((position4.getScale() * f) / f2));
                        position4.setY(position2.getY());
                    } else if (i2 == 1) {
                        float fPow = (float) Math.pow((f / 2) * (position4.getScale() + position2.getScale()), 2);
                        float f3 = 7;
                        position4.setY(((float) Math.sqrt((4 * fPow) / f3)) + position2.getY());
                        position4.setX(((float) Math.sqrt((3 * fPow) / f3)) + position2.getX());
                    } else if (i2 == 2) {
                        float fPow2 = (float) Math.pow((f / 2) * (position4.getScale() + position2.getScale()), 2);
                        float f4 = 4;
                        position4.setY(((float) Math.sqrt((3 * fPow2) / f4)) + position2.getY());
                        position4.setX((-((float) Math.sqrt(fPow2 / f4))) + position2.getX());
                    } else if (i2 == 3) {
                        float f5 = 2;
                        position4.setX((position2.getX() - ((position2.getScale() * f) / f5)) - ((position4.getScale() * f) / f5));
                        position4.setY(position2.getY());
                    } else if (i2 == 4) {
                        float fPow3 = (float) Math.pow((f / 2) * (position4.getScale() + position2.getScale()), 2);
                        float f6 = 4;
                        position4.setY((-((float) Math.sqrt((3 * fPow3) / f6))) + position2.getY());
                        position4.setX((-((float) Math.sqrt(fPow3 / f6))) + position2.getX());
                    } else if (i2 == 5) {
                        float fPow4 = (float) Math.pow((f / 2) * (position4.getScale() + position2.getScale()), 2);
                        float f7 = 4;
                        position4.setY((-((float) Math.sqrt((3 * fPow4) / f7))) + position2.getY());
                        position4.setX(((float) Math.sqrt(fPow4 / f7)) + position2.getX());
                    }
                    Timber.INSTANCE.i("transform, index: " + index + ", mod: " + length + ", i: " + i2 + ", n: " + i4 + ", (" + position4.getX() + ", " + position4.getY() + ')', new Object[0]);
                }
                i++;
                str = str;
                numArr2 = numArr2;
                i2 = i3;
            }
            i++;
            str = str;
            numArr2 = numArr2;
            i2 = i3;
        }
        for (Integer num : numArr2) {
            int iIntValue2 = num.intValue();
            int i5 = iIntValue2 + index;
            if (iIntValue2 != INVALID_OFFSET && i5 >= 0 && i5 < size()) {
                transform(i5);
            }
        }
    }

    static /* synthetic */ void transformToTarget$default(HoneyCombCalculator2 honeyCombCalculator2, int i, Position position, float f, float f2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f2 = 0.0f;
        }
        honeyCombCalculator2.transformToTarget(i, position, f, f2);
    }

    private final void transformToTarget(int index, Position position, float scrollX, float scrollY) {
        float initX;
        float f;
        int i;
        if (((int) position.getInitY()) % 2 == 0) {
            initX = position.getInitX();
            f = this.hexR;
        } else {
            initX = position.getInitX() - 0.5f;
            f = this.hexR;
        }
        float f2 = (initX * f) + scrollX;
        float initY = (this.SQRT_3_OVER_2 * position.getInitY() * this.hexR) + scrollY;
        position.setOriginalX(f2);
        position.setOriginalY(initY);
        position.setScale(1.0f);
        float fCoerceAtLeast = RangesKt.coerceAtLeast(this.width, this.height) / 2.0f;
        position.setX(f2);
        position.setY(initY);
        double d = 2;
        float fSqrt = (float) Math.sqrt(((float) Math.pow(f2, d)) + ((float) Math.pow(initY, d)));
        double d2 = fSqrt / fCoerceAtLeast;
        float fSin = (((float) Math.sin(d2)) * fCoerceAtLeast) / fSqrt;
        int i2 = (fSqrt > 0.0f ? 1 : (fSqrt == 0.0f ? 0 : -1));
        if (i2 == 0) {
            position.setX(f2);
            position.setY(initY);
            i = i2;
        } else {
            i = i2;
            if (0.0f <= fSqrt && fSqrt <= ((float) ((((double) fCoerceAtLeast) * 3.141592653589793d) / d))) {
                position.setX(f2 * fSin);
                position.setY(fSin * initY);
            } else {
                position.setX(f2);
                position.setY(initY);
            }
        }
        float fSqrt2 = (float) Math.sqrt(((float) Math.pow(fCoerceAtLeast, d)) - ((float) Math.pow(((float) Math.sin(d2)) * fCoerceAtLeast, d)));
        if (i == 0) {
            position.setScale(1.0f);
        } else if (0.0f <= fSqrt && fSqrt <= ((float) Math.sqrt(((float) Math.pow(this.width / 2.0f, d)) * ((float) Math.pow(this.height / 2.0f, d))))) {
            float f3 = fSqrt2 / fCoerceAtLeast;
            position.setScale(EasingFunctionKt.easeOutQuint$default(f3, 0.0f, 2, null) * f3);
        } else {
            position.setScale(0.0f);
        }
    }

    public final int size() {
        return this.positions.size();
    }
}
