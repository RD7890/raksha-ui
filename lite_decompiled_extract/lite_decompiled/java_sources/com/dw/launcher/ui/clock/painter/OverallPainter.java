package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.dw.launcher.ui.clock.util.ImageUtils;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduPart;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifDrawable;

/* JADX INFO: compiled from: OverallPainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u001fH\u0002J\u0016\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/OverallPainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "bitmaps0", "", "Landroid/graphics/drawable/Drawable;", "bitmaps1", "bitmaps2", "bitmaps3", "bitmaps4", "childDrawableIndex", "", "getContext", "()Landroid/content/Context;", "currentDrawableIndex", "lastDrawTime", "", "overallCountSum", "", "overallInterval", "startPlayAction", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawOverall", "mPaint", "onClick", "x", "y", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class OverallPainter extends ABasePainter {
    private List<Drawable> bitmaps0;
    private List<Drawable> bitmaps1;
    private List<Drawable> bitmaps2;
    private List<Drawable> bitmaps3;
    private List<Drawable> bitmaps4;
    private int childDrawableIndex;
    private final Context context;
    private int currentDrawableIndex;
    private final ClockConfigFlatter flatter;
    private long lastDrawTime;
    private final int[] overallCountSum;
    private final int[] overallInterval;
    private boolean startPlayAction;

    public final Context getContext() {
        return this.context;
    }

    public OverallPainter(Context context, ClockConfigFlatter flatter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.bitmaps0 = new ArrayList();
        this.bitmaps1 = new ArrayList();
        this.bitmaps2 = new ArrayList();
        this.bitmaps3 = new ArrayList();
        this.bitmaps4 = new ArrayList();
        int[] iArr = {PduPart.P_CONTENT_TRANSFER_ENCODING, PduPart.P_CONTENT_TRANSFER_ENCODING, PduPart.P_CONTENT_TRANSFER_ENCODING, PduPart.P_CONTENT_TRANSFER_ENCODING, PduPart.P_CONTENT_TRANSFER_ENCODING};
        this.overallInterval = iArr;
        int[] iArr2 = {0, 0, 0, 0, 0};
        this.overallCountSum = iArr2;
        this.childDrawableIndex = 1;
        Drawable drawableLoadGifDrawable = flatter.loadGifDrawable("res/animation/animation.gif");
        ImageUtils imageUtils = ImageUtils.INSTANCE;
        Intrinsics.checkNotNull(drawableLoadGifDrawable, "null cannot be cast to non-null type pl.droidsonroids.gif.GifDrawable");
        GifDrawable gifDrawable = (GifDrawable) drawableLoadGifDrawable;
        this.bitmaps0 = imageUtils.gifToDrawableList(gifDrawable);
        iArr[0] = gifDrawable.getFrameDuration(0);
        iArr2[0] = this.bitmaps0.size();
        String open_click_1 = flatter.getConfig().getOpen_click_1();
        Intrinsics.checkNotNull(open_click_1);
        if (Integer.parseInt(open_click_1) == 1) {
            Drawable drawableLoadGifDrawable2 = flatter.loadGifDrawable("res/animation/animation1.gif");
            ImageUtils imageUtils2 = ImageUtils.INSTANCE;
            Intrinsics.checkNotNull(drawableLoadGifDrawable2, "null cannot be cast to non-null type pl.droidsonroids.gif.GifDrawable");
            GifDrawable gifDrawable2 = (GifDrawable) drawableLoadGifDrawable2;
            this.bitmaps1 = imageUtils2.gifToDrawableList(gifDrawable2);
            iArr[1] = gifDrawable2.getFrameDuration(0);
            iArr2[1] = this.bitmaps1.size();
        }
        String open_click_2 = flatter.getConfig().getOpen_click_2();
        Intrinsics.checkNotNull(open_click_2);
        if (Integer.parseInt(open_click_2) == 1) {
            Drawable drawableLoadGifDrawable3 = flatter.loadGifDrawable("res/animation/animation2.gif");
            ImageUtils imageUtils3 = ImageUtils.INSTANCE;
            Intrinsics.checkNotNull(drawableLoadGifDrawable3, "null cannot be cast to non-null type pl.droidsonroids.gif.GifDrawable");
            GifDrawable gifDrawable3 = (GifDrawable) drawableLoadGifDrawable3;
            this.bitmaps2 = imageUtils3.gifToDrawableList(gifDrawable3);
            iArr[2] = gifDrawable3.getFrameDuration(0);
            iArr2[2] = this.bitmaps2.size();
        }
        String open_click_3 = flatter.getConfig().getOpen_click_3();
        Intrinsics.checkNotNull(open_click_3);
        if (Integer.parseInt(open_click_3) == 1) {
            Drawable drawableLoadGifDrawable4 = flatter.loadGifDrawable("res/animation/animation3.gif");
            ImageUtils imageUtils4 = ImageUtils.INSTANCE;
            Intrinsics.checkNotNull(drawableLoadGifDrawable4, "null cannot be cast to non-null type pl.droidsonroids.gif.GifDrawable");
            GifDrawable gifDrawable4 = (GifDrawable) drawableLoadGifDrawable4;
            this.bitmaps3 = imageUtils4.gifToDrawableList(gifDrawable4);
            iArr[3] = gifDrawable4.getFrameDuration(0);
            iArr2[3] = this.bitmaps3.size();
        }
        String open_click_4 = flatter.getConfig().getOpen_click_4();
        Intrinsics.checkNotNull(open_click_4);
        if (Integer.parseInt(open_click_4) == 1) {
            Drawable drawableLoadGifDrawable5 = flatter.loadGifDrawable("res/animation/animation4.gif");
            ImageUtils imageUtils5 = ImageUtils.INSTANCE;
            Intrinsics.checkNotNull(drawableLoadGifDrawable5, "null cannot be cast to non-null type pl.droidsonroids.gif.GifDrawable");
            GifDrawable gifDrawable5 = (GifDrawable) drawableLoadGifDrawable5;
            this.bitmaps4 = imageUtils5.gifToDrawableList(gifDrawable5);
            iArr[4] = gifDrawable5.getFrameDuration(0);
        }
    }

    private final void drawOverall(Canvas canvas, Paint mPaint) {
        if (!this.startPlayAction) {
            if (this.overallCountSum[0] == 0) {
                return;
            }
            if (this.childDrawableIndex - 1 < this.bitmaps0.size() && this.bitmaps0.get(this.childDrawableIndex - 1) != null) {
                drawDrawable(canvas, this.bitmaps0.get(this.childDrawableIndex - 1), this.flatter.getConfig().getOverall_animation_x(), this.flatter.getConfig().getOverall_animation_y(), this.flatter.getScaleX(), this.flatter.getScaleY());
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            long j = this.lastDrawTime;
            if (j == 0) {
                this.lastDrawTime = jUptimeMillis;
            } else {
                long j2 = jUptimeMillis - j;
                if (j2 >= this.overallInterval[0] || j2 < 0) {
                    this.childDrawableIndex++;
                    this.lastDrawTime = jUptimeMillis;
                }
            }
            if (this.childDrawableIndex > this.overallCountSum[0]) {
                this.childDrawableIndex = 1;
                return;
            }
            return;
        }
        int[] iArr = this.overallCountSum;
        int i = this.currentDrawableIndex;
        if (iArr[i] == 0) {
            return;
        }
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    if (this.childDrawableIndex - 1 < this.bitmaps3.size() && this.bitmaps3.get(this.childDrawableIndex - 1) != null) {
                        drawDrawable(canvas, this.bitmaps3.get(this.childDrawableIndex - 1), this.flatter.getConfig().getOverall_animation_x(), this.flatter.getConfig().getOverall_animation_y(), this.flatter.getScaleX(), this.flatter.getScaleY());
                    }
                } else if (i == 4 && this.childDrawableIndex - 1 < this.bitmaps4.size() && this.bitmaps4.get(this.childDrawableIndex - 1) != null) {
                    drawDrawable(canvas, this.bitmaps4.get(this.childDrawableIndex - 1), this.flatter.getConfig().getOverall_animation_x(), this.flatter.getConfig().getOverall_animation_y(), this.flatter.getScaleX(), this.flatter.getScaleY());
                }
            } else if (this.childDrawableIndex - 1 < this.bitmaps2.size() && this.bitmaps2.get(this.childDrawableIndex - 1) != null) {
                drawDrawable(canvas, this.bitmaps2.get(this.childDrawableIndex - 1), this.flatter.getConfig().getOverall_animation_x(), this.flatter.getConfig().getOverall_animation_y(), this.flatter.getScaleX(), this.flatter.getScaleY());
            }
        } else if (this.childDrawableIndex - 1 < this.bitmaps1.size() && this.bitmaps1.get(this.childDrawableIndex - 1) != null) {
            drawDrawable(canvas, this.bitmaps1.get(this.childDrawableIndex - 1), this.flatter.getConfig().getOverall_animation_x(), this.flatter.getConfig().getOverall_animation_y(), this.flatter.getScaleX(), this.flatter.getScaleY());
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis();
        long j3 = this.lastDrawTime;
        if (j3 == 0) {
            this.lastDrawTime = jUptimeMillis2;
        } else {
            long j4 = jUptimeMillis2 - j3;
            if (j4 >= this.overallInterval[this.currentDrawableIndex] || j4 < 0) {
                this.childDrawableIndex++;
                this.lastDrawTime = jUptimeMillis2;
            }
        }
        if (this.childDrawableIndex > this.overallCountSum[this.currentDrawableIndex]) {
            this.startPlayAction = false;
            this.childDrawableIndex = 1;
        }
    }

    public final void onClick(int x, int y) {
        if (this.startPlayAction) {
            return;
        }
        String open_click_1 = this.flatter.getConfig().getOpen_click_1();
        Intrinsics.checkNotNull(open_click_1);
        if (Integer.parseInt(open_click_1) == 1 && x >= this.flatter.getConfig().getClick_1_x()) {
            int click_1_x = this.flatter.getConfig().getClick_1_x();
            String click_1_width = this.flatter.getConfig().getClick_1_width();
            Intrinsics.checkNotNull(click_1_width);
            if (x <= click_1_x + Integer.parseInt(click_1_width) && y >= this.flatter.getConfig().getClick_1_y()) {
                int click_1_y = this.flatter.getConfig().getClick_1_y();
                String click_1_height = this.flatter.getConfig().getClick_1_height();
                Intrinsics.checkNotNull(click_1_height);
                if (y <= click_1_y + Integer.parseInt(click_1_height)) {
                    this.currentDrawableIndex = 1;
                    this.lastDrawTime = 0L;
                    this.childDrawableIndex = 1;
                    this.startPlayAction = true;
                }
            }
        }
        String open_click_2 = this.flatter.getConfig().getOpen_click_2();
        Intrinsics.checkNotNull(open_click_2);
        if (Integer.parseInt(open_click_2) == 1 && x >= this.flatter.getConfig().getClick_2_x()) {
            int click_2_x = this.flatter.getConfig().getClick_2_x();
            String click_2_width = this.flatter.getConfig().getClick_2_width();
            Intrinsics.checkNotNull(click_2_width);
            if (x <= click_2_x + Integer.parseInt(click_2_width) && y >= this.flatter.getConfig().getClick_2_y()) {
                int click_2_y = this.flatter.getConfig().getClick_2_y();
                String click_2_height = this.flatter.getConfig().getClick_2_height();
                Intrinsics.checkNotNull(click_2_height);
                if (y <= click_2_y + Integer.parseInt(click_2_height)) {
                    this.currentDrawableIndex = 2;
                    this.lastDrawTime = 0L;
                    this.childDrawableIndex = 1;
                    this.startPlayAction = true;
                }
            }
        }
        String open_click_3 = this.flatter.getConfig().getOpen_click_3();
        Intrinsics.checkNotNull(open_click_3);
        if (Integer.parseInt(open_click_3) == 1 && x >= this.flatter.getConfig().getClick_3_x()) {
            int click_3_x = this.flatter.getConfig().getClick_3_x();
            String click_3_width = this.flatter.getConfig().getClick_3_width();
            Intrinsics.checkNotNull(click_3_width);
            if (x <= click_3_x + Integer.parseInt(click_3_width) && y >= this.flatter.getConfig().getClick_3_y()) {
                int click_3_y = this.flatter.getConfig().getClick_3_y();
                String click_3_height = this.flatter.getConfig().getClick_3_height();
                Intrinsics.checkNotNull(click_3_height);
                if (y <= click_3_y + Integer.parseInt(click_3_height)) {
                    this.currentDrawableIndex = 3;
                    this.lastDrawTime = 0L;
                    this.childDrawableIndex = 1;
                    this.startPlayAction = true;
                }
            }
        }
        String open_click_4 = this.flatter.getConfig().getOpen_click_4();
        Intrinsics.checkNotNull(open_click_4);
        if (Integer.parseInt(open_click_4) != 1 || x < this.flatter.getConfig().getClick_4_x()) {
            return;
        }
        int click_4_x = this.flatter.getConfig().getClick_4_x();
        String click_4_width = this.flatter.getConfig().getClick_4_width();
        Intrinsics.checkNotNull(click_4_width);
        if (x > click_4_x + Integer.parseInt(click_4_width) || y < this.flatter.getConfig().getClick_4_y()) {
            return;
        }
        int click_4_y = this.flatter.getConfig().getClick_4_y();
        String click_4_height = this.flatter.getConfig().getClick_4_height();
        Intrinsics.checkNotNull(click_4_height);
        if (y <= click_4_y + Integer.parseInt(click_4_height)) {
            this.currentDrawableIndex = 4;
            this.lastDrawTime = 0L;
            this.childDrawableIndex = 1;
            this.startPlayAction = true;
        }
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        drawOverall(canvas, null);
    }
}
