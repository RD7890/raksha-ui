package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduPart;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifDrawable;
import timber.log.Timber;

/* JADX INFO: compiled from: ConnectPainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0002J8\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002J\u0016\u0010&\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\fJ!\u0010'\u001a\u00020\u00182\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020*0)\"\u00020*H\u0016¢\u0006\u0002\u0010+R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/ConnectPainter;", "Lcom/dw/launcher/ui/clock/painter/IBasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "bitmapList", "", "", "Landroid/graphics/drawable/Drawable;", "childDrawbleIndex", "", "connectCountSum", "", "connectInterval", "getContext", "()Landroid/content/Context;", "currentIndex", "isInitState", "", "lastDrawTime", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawConnect", "mPaint", "drawDrawable", "drawable", "x", "y", "scaleX", "", "scaleY", "onclick", "updateParams", "params", "", "", "([Ljava/lang/Object;)V", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ConnectPainter implements IBasePainter {
    private List<List<Drawable>> bitmapList;
    private int childDrawbleIndex;
    private final int[] connectCountSum;
    private int[] connectInterval;
    private final Context context;
    private int currentIndex;
    private final ClockConfigFlatter flatter;
    private boolean isInitState;
    private long lastDrawTime;

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void updateParams(Object... params) {
        Intrinsics.checkNotNullParameter(params, "params");
    }

    public ConnectPainter(Context context, ClockConfigFlatter flatter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.connectInterval = new int[]{PduPart.P_CONTENT_TRANSFER_ENCODING, PduPart.P_CONTENT_TRANSFER_ENCODING, PduPart.P_CONTENT_TRANSFER_ENCODING, PduPart.P_CONTENT_TRANSFER_ENCODING, PduPart.P_CONTENT_TRANSFER_ENCODING, PduPart.P_CONTENT_TRANSFER_ENCODING};
        this.connectCountSum = new int[]{0, 0, 0, 0, 0, 0};
        this.isInitState = true;
        this.bitmapList = new ArrayList();
        List<Drawable> conectDrawables = flatter.getConectDrawables();
        if (conectDrawables != null) {
            int i = 0;
            for (Object obj : conectDrawables) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Drawable drawable = (Drawable) obj;
                ArrayList arrayList = new ArrayList();
                int[] iArr = this.connectInterval;
                Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type pl.droidsonroids.gif.GifDrawable");
                GifDrawable gifDrawable = (GifDrawable) drawable;
                iArr[i] = gifDrawable.getFrameDuration(0);
                int numberOfFrames = gifDrawable.getNumberOfFrames();
                for (int i3 = 0; i3 < numberOfFrames; i3++) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(gifDrawable.seekToFrameAndGet(i3));
                    arrayList.add(bitmapDrawable);
                    Timber.INSTANCE.d("frameBitmap: " + bitmapDrawable + "  --- " + drawable, new Object[0]);
                }
                this.connectCountSum[i] = arrayList.size();
                this.bitmapList.add(arrayList);
                i = i2;
            }
        }
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        drawConnect(canvas, paint);
    }

    private final void drawConnect(Canvas canvas, Paint mPaint) {
        Drawable drawable;
        if (this.isInitState) {
            if (!(!this.bitmapList.isEmpty()) || this.bitmapList.get(0) == null) {
                return;
            }
            drawDrawable(canvas, this.bitmapList.get(0).get(0), this.flatter.getConnectPostion().x, this.flatter.getConnectPostion().y, this.flatter.getScaleX(), this.flatter.getScaleY());
            return;
        }
        int[] iArr = this.connectCountSum;
        int i = this.currentIndex;
        if (iArr[i] == 0) {
            return;
        }
        List list = (List) CollectionsKt.getOrNull(this.bitmapList, i);
        if (list != null && (drawable = (Drawable) CollectionsKt.getOrNull(list, this.childDrawbleIndex)) != null) {
            drawDrawable(canvas, drawable, this.flatter.getConnectPostion().x, this.flatter.getConnectPostion().y, this.flatter.getScaleX(), this.flatter.getScaleY());
        }
        Timber.INSTANCE.d("childDrawbleIndex:" + this.childDrawbleIndex + " currentIndex:" + this.currentIndex + " connectCountSum:" + this.connectCountSum[this.currentIndex] + " connectInterval:" + this.connectInterval[this.currentIndex], new Object[0]);
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = this.lastDrawTime;
        if (j == 0) {
            this.lastDrawTime = jUptimeMillis;
        } else if (jUptimeMillis - j >= this.connectInterval[this.currentIndex] || jUptimeMillis - j < 0) {
            this.childDrawbleIndex++;
            this.lastDrawTime = jUptimeMillis;
        }
        int i2 = this.childDrawbleIndex;
        int i3 = this.connectCountSum[this.currentIndex];
        if (i2 >= i3) {
            this.childDrawbleIndex = i3 - 1;
        }
    }

    private final void drawDrawable(Canvas canvas, Drawable drawable, int x, int y, float scaleX, float scaleY) {
        drawable.setBounds(x, y, ((int) (drawable.getIntrinsicWidth() * scaleX)) + x, ((int) (drawable.getIntrinsicHeight() * scaleY)) + y);
        drawable.draw(canvas);
    }

    public final boolean onclick(int x, int y) {
        int i = this.flatter.getConnectPostion().x;
        int i2 = this.flatter.getConnectPostion().y;
        if ((!this.bitmapList.isEmpty()) && (!this.bitmapList.get(0).isEmpty()) && this.bitmapList.get(0).get(0) != null) {
            int intrinsicWidth = this.bitmapList.get(0).get(0).getIntrinsicWidth();
            int intrinsicHeight = this.bitmapList.get(0).get(0).getIntrinsicHeight();
            if (x > i && x < i + intrinsicWidth && y > i2 && y < i2 + intrinsicHeight) {
                if (this.isInitState) {
                    this.currentIndex = 0;
                    this.childDrawbleIndex = 0;
                    this.isInitState = false;
                    return true;
                }
                int i3 = this.childDrawbleIndex;
                int[] iArr = this.connectCountSum;
                int i4 = this.currentIndex;
                if (i3 == iArr[i4] - 1) {
                    if (i4 == this.flatter.getConfig().getConnect_animation_count() - 1) {
                        this.currentIndex = 0;
                    } else {
                        this.currentIndex++;
                    }
                    this.childDrawbleIndex = 0;
                }
                return true;
            }
        }
        return false;
    }
}
