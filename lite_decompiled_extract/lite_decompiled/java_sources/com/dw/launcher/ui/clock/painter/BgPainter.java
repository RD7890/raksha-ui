package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduPart;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifDrawable;

/* JADX INFO: compiled from: BgPainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00162\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\tJ\u001a\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J&\u0010(\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bJ\u0010\u0010)\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u001b\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/BgPainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "backgounds", "", "Landroid/graphics/drawable/Drawable;", "bitmapCountSum", "", "bitmapInterval", "changeUseTime", "getContext", "()Landroid/content/Context;", "currentDrawableIndex", "getCurrentDrawableIndex", "()I", "setCurrentDrawableIndex", "(I)V", "isChangeBg", "", "lastDrawTime", "", "screenHeight", "getScreenHeight", "screenWidth", "getScreenWidth", "start_x", "start_y", "changeBg", "", "isDynamic", "backgroundDrawable", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawBackground", "drawBg", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class BgPainter extends ABasePainter {
    private List<Drawable> backgounds;
    private int bitmapCountSum;
    private int bitmapInterval;
    private int changeUseTime;
    private final Context context;
    private int currentDrawableIndex;
    private final ClockConfigFlatter flatter;
    private boolean isChangeBg;
    private long lastDrawTime;
    private final int screenHeight;
    private final int screenWidth;
    private final int start_x;
    private final int start_y;

    public BgPainter(Context context, ClockConfigFlatter flatter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.bitmapInterval = PduPart.P_CONTENT_TRANSFER_ENCODING;
        this.changeUseTime = 500;
        this.backgounds = new ArrayList();
        this.screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        this.screenHeight = context.getResources().getDisplayMetrics().heightPixels;
        this.currentDrawableIndex = 1;
        this.bitmapCountSum = flatter.getBackgrounds().size();
        String bg_interval = flatter.getConfig().getBg_interval();
        Intrinsics.checkNotNull(bg_interval);
        this.bitmapInterval = Integer.parseInt(bg_interval);
        int bg_type = flatter.getConfig().getBg_type();
        if (bg_type != 0) {
            int i = 0;
            if (bg_type == 1) {
                Drawable background = flatter.getBackground();
                Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                AnimationDrawable animationDrawable = (AnimationDrawable) background;
                this.bitmapInterval = animationDrawable.getDuration(0);
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                while (i < numberOfFrames) {
                    Drawable frame = animationDrawable.getFrame(i);
                    Intrinsics.checkNotNullExpressionValue(frame, "getFrame(...)");
                    this.backgounds.add(frame);
                    i++;
                }
                this.bitmapCountSum = this.backgounds.size();
                return;
            }
            if (bg_type == 2) {
                if (flatter.getBackground() != null) {
                    Drawable background2 = flatter.getBackground();
                    Intrinsics.checkNotNull(background2, "null cannot be cast to non-null type pl.droidsonroids.gif.GifDrawable");
                    GifDrawable gifDrawable = (GifDrawable) background2;
                    this.bitmapInterval = gifDrawable.getFrameDuration(0);
                    int numberOfFrames2 = gifDrawable.getNumberOfFrames();
                    while (i < numberOfFrames2) {
                        this.backgounds.add(new BitmapDrawable(gifDrawable.seekToFrameAndGet(i)));
                        i++;
                    }
                    this.bitmapCountSum = this.backgounds.size();
                    return;
                }
                return;
            }
            if (bg_type == 3) {
                this.currentDrawableIndex = flatter.getConfig().getBg_btn_index() + 1;
                this.backgounds = flatter.getBackgrounds();
                this.bitmapCountSum = flatter.getBackgrounds().size();
                return;
            } else if (bg_type != 6 && bg_type != 7) {
                return;
            }
        }
        this.backgounds = flatter.getBackgrounds();
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final int getCurrentDrawableIndex() {
        return this.currentDrawableIndex;
    }

    public final void setCurrentDrawableIndex(int i) {
        this.currentDrawableIndex = i;
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        drawBg(canvas);
    }

    private final void drawBg(Canvas canvas) {
        List<Drawable> list;
        int bg_type = this.flatter.getConfig().getBg_type();
        if (bg_type == 0) {
            Drawable background = this.flatter.getBackground();
            if (background != null) {
                drawBackground(canvas, background, this.screenWidth, this.screenHeight);
                return;
            }
            return;
        }
        if (bg_type == 1 || bg_type == 2) {
            if (this.bitmapCountSum != 0 && this.currentDrawableIndex - 1 < this.backgounds.size() && this.backgounds.get(this.currentDrawableIndex - 1) != null) {
                drawBackground(canvas, this.backgounds.get(this.currentDrawableIndex - 1), this.screenWidth, this.screenHeight);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            long j = this.lastDrawTime;
            if (j == 0) {
                this.lastDrawTime = jUptimeMillis;
            } else if (jUptimeMillis - j >= this.bitmapInterval || jUptimeMillis - j < 0) {
                this.currentDrawableIndex++;
                this.lastDrawTime = jUptimeMillis;
            }
            if (this.currentDrawableIndex > this.bitmapCountSum) {
                if (this.flatter.getConfig().getBg_animal_keep_for_last_frame() == 1) {
                    this.currentDrawableIndex = this.bitmapCountSum;
                    return;
                } else {
                    this.currentDrawableIndex = 1;
                    return;
                }
            }
            return;
        }
        if (bg_type != 3) {
            if (bg_type != 6) {
                if (bg_type == 7 && (list = this.backgounds) != null) {
                    drawBackground(canvas, list.get(Calendar.getInstance().get(11) % 24), this.screenWidth, this.screenHeight);
                    return;
                }
                return;
            }
            List<Drawable> list2 = this.backgounds;
            if (list2 != null) {
                int i = Calendar.getInstance().get(11) % 12;
                drawBackground(canvas, list2.get((i != 0 ? i : 12) - 1), this.screenWidth, this.screenHeight);
                return;
            }
            return;
        }
        if (this.bitmapCountSum == 0) {
            return;
        }
        if (!this.isChangeBg) {
            if (this.currentDrawableIndex - 1 >= this.backgounds.size() || this.backgounds.get(this.currentDrawableIndex - 1) == null) {
                return;
            }
            this.backgounds.get(this.currentDrawableIndex - 1).setAlpha(255);
            drawBackground(canvas, this.backgounds.get(this.currentDrawableIndex - 1), this.screenWidth, this.screenHeight);
            return;
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis();
        int i2 = this.changeUseTime;
        long j2 = this.lastDrawTime;
        long j3 = jUptimeMillis2 - j2;
        if (0 <= j3 && j3 < i2) {
            int i3 = (int) (((jUptimeMillis2 - j2) * ((long) 255)) / ((long) i2));
            int i4 = this.currentDrawableIndex;
            if (i4 == this.bitmapCountSum) {
                if ((!this.backgounds.isEmpty()) && this.backgounds.get(0) != null) {
                    this.backgounds.get(0).setAlpha(i3);
                    drawBackground(canvas, this.backgounds.get(0), this.screenWidth, this.screenHeight);
                }
            } else if (i4 < this.backgounds.size() && this.backgounds.get(this.currentDrawableIndex) != null) {
                this.backgounds.get(this.currentDrawableIndex).setAlpha(i3);
                drawBackground(canvas, this.backgounds.get(this.currentDrawableIndex), this.screenWidth, this.screenHeight);
            }
            int i5 = 255 - i3;
            if (this.currentDrawableIndex - 1 >= this.backgounds.size() || this.backgounds.get(this.currentDrawableIndex - 1) == null) {
                return;
            }
            this.backgounds.get(this.currentDrawableIndex - 1).setAlpha(i5);
            drawBackground(canvas, this.backgounds.get(this.currentDrawableIndex - 1), this.screenWidth, this.screenHeight);
            return;
        }
        int i6 = this.currentDrawableIndex + 1;
        this.currentDrawableIndex = i6;
        if (i6 > this.bitmapCountSum) {
            this.currentDrawableIndex = 1;
        }
        this.isChangeBg = false;
        if (this.currentDrawableIndex - 1 >= this.backgounds.size() || this.backgounds.get(this.currentDrawableIndex - 1) == null) {
            return;
        }
        this.backgounds.get(this.currentDrawableIndex - 1).setAlpha(255);
        drawBackground(canvas, this.backgounds.get(this.currentDrawableIndex - 1), this.screenWidth, this.screenHeight);
    }

    public final void drawBackground(Canvas canvas, Drawable backgroundDrawable, int screenWidth, int screenHeight) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(backgroundDrawable, "backgroundDrawable");
        backgroundDrawable.setBounds(0, 0, screenWidth, screenHeight);
        backgroundDrawable.draw(canvas);
    }

    public static /* synthetic */ void changeBg$default(BgPainter bgPainter, boolean z, Drawable drawable, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            drawable = null;
        }
        bgPainter.changeBg(z, drawable);
    }

    public final void changeBg(boolean isDynamic, Drawable backgroundDrawable) {
        if (!isDynamic) {
            if (this.isChangeBg) {
                return;
            }
            this.isChangeBg = true;
            this.lastDrawTime = SystemClock.uptimeMillis();
            return;
        }
        if (backgroundDrawable != null) {
            GifDrawable gifDrawable = (GifDrawable) backgroundDrawable;
            this.backgounds = new ArrayList();
            this.bitmapInterval = gifDrawable.getFrameDuration(0);
            int numberOfFrames = gifDrawable.getNumberOfFrames();
            for (int i = 0; i < numberOfFrames; i++) {
                this.backgounds.add(new BitmapDrawable(gifDrawable.seekToFrameAndGet(i)));
            }
            this.bitmapCountSum = this.backgounds.size();
            this.currentDrawableIndex = 1;
        }
    }
}
