package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.dw.launcher.ui.clock.util.ImageUtils;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduPart;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifDrawable;

/* JADX INFO: compiled from: ActionPainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0018\u0010.\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u00010-J\u0018\u00100\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u00010-J\u0018\u00101\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u00010-J\u0016\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/ActionPainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "mContext", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "actionCountOne", "", "actionCountThree", "actionCountTwo", "actionCutPositionOne", "actionCutPositionThree", "actionCutPositionTwo", "actionFirstPlayOne", "", "actionFirstPlayThree", "actionFirstPlayTwo", "actionIntervalOne", "actionIntervalThree", "actionIntervalTwo", "actionOrderOne", "actionOrderThree", "actionOrderTwo", "bitmaps1", "", "Landroid/graphics/drawable/Drawable;", "bitmaps2", "bitmaps3", "drawX", "drawY", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "lastDrawTimeOne", "", "lastDrawTimeThree", "lastDrawTimeTwo", "startPlayActionOne", "startPlayActionThree", "startPlayActionTwo", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawActionOne", "mPaint", "drawActionThree", "drawActionTwo", "onclick", "x", "y", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ActionPainter extends ABasePainter {
    private int actionCountOne;
    private int actionCountThree;
    private int actionCountTwo;
    private int actionCutPositionOne;
    private int actionCutPositionThree;
    private int actionCutPositionTwo;
    private boolean actionFirstPlayOne;
    private boolean actionFirstPlayThree;
    private boolean actionFirstPlayTwo;
    private int actionIntervalOne;
    private int actionIntervalThree;
    private int actionIntervalTwo;
    private int actionOrderOne;
    private int actionOrderThree;
    private int actionOrderTwo;
    private List<Drawable> bitmaps1;
    private List<Drawable> bitmaps2;
    private List<Drawable> bitmaps3;
    private int drawX;
    private int drawY;
    private final ClockConfigFlatter flatter;
    private long lastDrawTimeOne;
    private long lastDrawTimeThree;
    private long lastDrawTimeTwo;
    private final Context mContext;
    private boolean startPlayActionOne;
    private boolean startPlayActionThree;
    private boolean startPlayActionTwo;

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public ActionPainter(Context mContext, ClockConfigFlatter flatter) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.mContext = mContext;
        this.flatter = flatter;
        this.actionIntervalOne = PduPart.P_CONTENT_TRANSFER_ENCODING;
        this.actionIntervalTwo = PduPart.P_CONTENT_TRANSFER_ENCODING;
        this.actionIntervalThree = PduPart.P_CONTENT_TRANSFER_ENCODING;
        this.actionOrderOne = 1;
        this.actionFirstPlayOne = true;
        this.actionOrderTwo = 1;
        this.actionFirstPlayTwo = true;
        this.actionOrderThree = 1;
        this.actionFirstPlayThree = true;
        this.bitmaps1 = new ArrayList();
        this.bitmaps2 = new ArrayList();
        this.bitmaps3 = new ArrayList();
        setSupportScale(flatter.getConfig().getSupport_scale() == 1);
        int open_action_1 = flatter.getConfig().getOpen_action_1();
        if (open_action_1 == 1 || open_action_1 == 6) {
            this.actionIntervalOne = flatter.getConfig().getAction_interval();
            this.actionCountOne = flatter.getConfig().getAction_1_count();
            AnimationDrawable animationDrawableLoadAnimationDrawables = flatter.loadAnimationDrawables("res/action1");
            Intrinsics.checkNotNull(animationDrawableLoadAnimationDrawables, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            int numberOfFrames = animationDrawableLoadAnimationDrawables.getNumberOfFrames();
            for (int i = 0; i < numberOfFrames; i++) {
                Drawable frame = animationDrawableLoadAnimationDrawables.getFrame(i);
                Intrinsics.checkNotNullExpressionValue(frame, "getFrame(...)");
                this.bitmaps1.add(frame);
            }
        } else if (2 <= open_action_1 && open_action_1 < 6) {
            Drawable drawableLoadGifDrawable = flatter.loadGifDrawable("res/action1/action.gif");
            ImageUtils imageUtils = ImageUtils.INSTANCE;
            Intrinsics.checkNotNull(drawableLoadGifDrawable, "null cannot be cast to non-null type pl.droidsonroids.gif.GifDrawable");
            GifDrawable gifDrawable = (GifDrawable) drawableLoadGifDrawable;
            List<Drawable> listGifToDrawableList = imageUtils.gifToDrawableList(gifDrawable);
            this.bitmaps1 = listGifToDrawableList;
            this.actionCountOne = listGifToDrawableList.size();
            this.actionIntervalOne = gifDrawable.getFrameDuration(0);
        }
        this.actionCutPositionOne = this.flatter.getConfig().getAction_1_cut_position();
        int open_action_2 = this.flatter.getConfig().getOpen_action_2();
        if (open_action_2 == 1) {
            this.actionIntervalTwo = this.flatter.getConfig().getAction_interval();
            this.actionCountTwo = this.flatter.getConfig().getAction_2_count();
            AnimationDrawable animationDrawableLoadAnimationDrawables2 = this.flatter.loadAnimationDrawables("res/action2");
            Intrinsics.checkNotNull(animationDrawableLoadAnimationDrawables2, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            int numberOfFrames2 = animationDrawableLoadAnimationDrawables2.getNumberOfFrames();
            for (int i2 = 0; i2 < numberOfFrames2; i2++) {
                Drawable frame2 = animationDrawableLoadAnimationDrawables2.getFrame(i2);
                Intrinsics.checkNotNullExpressionValue(frame2, "getFrame(...)");
                this.bitmaps2.add(frame2);
            }
        } else if (2 <= open_action_2 && open_action_2 < 6) {
            Drawable drawableLoadGifDrawable2 = this.flatter.loadGifDrawable("res/action2/action.gif");
            ImageUtils imageUtils2 = ImageUtils.INSTANCE;
            Intrinsics.checkNotNull(drawableLoadGifDrawable2, "null cannot be cast to non-null type pl.droidsonroids.gif.GifDrawable");
            GifDrawable gifDrawable2 = (GifDrawable) drawableLoadGifDrawable2;
            List<Drawable> listGifToDrawableList2 = imageUtils2.gifToDrawableList(gifDrawable2);
            this.bitmaps2 = listGifToDrawableList2;
            this.actionCountTwo = listGifToDrawableList2.size();
            this.actionIntervalTwo = gifDrawable2.getFrameDuration(0);
        }
        this.actionCutPositionTwo = this.flatter.getConfig().getAction_2_cut_position();
        int open_action_3 = this.flatter.getConfig().getOpen_action_3();
        if (open_action_3 == 1) {
            this.actionIntervalThree = this.flatter.getConfig().getAction_interval();
            this.actionCountThree = this.flatter.getConfig().getAction_3_count();
            AnimationDrawable animationDrawableLoadAnimationDrawables3 = this.flatter.loadAnimationDrawables("res/action3");
            Intrinsics.checkNotNull(animationDrawableLoadAnimationDrawables3, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            int numberOfFrames3 = animationDrawableLoadAnimationDrawables3.getNumberOfFrames();
            for (int i3 = 0; i3 < numberOfFrames3; i3++) {
                Drawable frame3 = animationDrawableLoadAnimationDrawables3.getFrame(i3);
                Intrinsics.checkNotNullExpressionValue(frame3, "getFrame(...)");
                this.bitmaps3.add(frame3);
            }
        } else if (2 <= open_action_3 && open_action_3 < 6) {
            Drawable drawableLoadGifDrawable3 = this.flatter.loadGifDrawable("res/action3/action.gif");
            ImageUtils imageUtils3 = ImageUtils.INSTANCE;
            Intrinsics.checkNotNull(drawableLoadGifDrawable3, "null cannot be cast to non-null type pl.droidsonroids.gif.GifDrawable");
            GifDrawable gifDrawable3 = (GifDrawable) drawableLoadGifDrawable3;
            List<Drawable> listGifToDrawableList3 = imageUtils3.gifToDrawableList(gifDrawable3);
            this.bitmaps3 = listGifToDrawableList3;
            this.actionCountThree = listGifToDrawableList3.size();
            this.actionIntervalThree = gifDrawable3.getFrameDuration(0);
        }
        this.actionCutPositionThree = this.flatter.getConfig().getAction_3_cut_position();
    }

    public final void drawActionOne(Canvas canvas, Paint mPaint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.actionCountOne == 0) {
        }
        int i = 1;
        switch (this.flatter.getConfig().getOpen_action_1()) {
            case 1:
            case 2:
                if (this.actionOrderOne - 1 < this.bitmaps1.size() && this.bitmaps1.get(this.actionOrderOne - 1) != null) {
                    int action_1_x = this.flatter.getConfig().getAction_1_x();
                    int action_1_y = this.flatter.getConfig().getAction_1_y();
                    float scaleX = this.flatter.getScaleX();
                    float scaleY = this.flatter.getScaleY();
                    if (getSupportScale()) {
                        action_1_x = (int) (action_1_x * this.flatter.getAbsoluteScaleX());
                        action_1_y = (int) (action_1_y * this.flatter.getAbsoluteScaleX());
                        scaleX = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                        scaleY = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                    }
                    drawDrawable(canvas, this.bitmaps1.get(this.actionOrderOne - 1), action_1_x, action_1_y, scaleX, scaleY);
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = this.lastDrawTimeOne;
                if (j != 0) {
                    long j2 = jCurrentTimeMillis - j;
                    if (j2 >= this.actionIntervalOne || j2 < 0) {
                        this.actionOrderOne++;
                        this.lastDrawTimeOne = jCurrentTimeMillis;
                    }
                } else {
                    this.lastDrawTimeOne = jCurrentTimeMillis;
                }
                int i2 = this.actionOrderOne;
                int i3 = this.actionCountOne;
                if (i2 > i3) {
                    int i4 = this.actionCutPositionOne;
                    if (1 <= i4 && i4 <= i3) {
                        i = i4;
                    }
                    this.actionOrderOne = i;
                }
                break;
            case 3:
                if (this.startPlayActionOne) {
                    if (this.actionOrderOne - 1 < this.bitmaps1.size() && this.bitmaps1.get(this.actionOrderOne - 1) != null) {
                        int action_1_x2 = this.flatter.getConfig().getAction_1_x();
                        int action_1_y2 = this.flatter.getConfig().getAction_1_y();
                        float scaleX2 = this.flatter.getScaleX();
                        float scaleY2 = this.flatter.getScaleY();
                        if (getSupportScale()) {
                            action_1_x2 = (int) (action_1_x2 * this.flatter.getAbsoluteScaleX());
                            action_1_y2 = (int) (action_1_y2 * this.flatter.getAbsoluteScaleX());
                            scaleX2 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                            scaleY2 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                        }
                        drawDrawable(canvas, this.bitmaps1.get(this.actionOrderOne - 1), action_1_x2, action_1_y2, scaleX2, scaleY2);
                    }
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    long j3 = this.lastDrawTimeOne;
                    if (j3 != 0) {
                        long j4 = jCurrentTimeMillis2 - j3;
                        if (j4 >= this.actionIntervalOne || j4 < 0) {
                            this.actionOrderOne++;
                            this.lastDrawTimeOne = jCurrentTimeMillis2;
                        }
                    } else {
                        this.lastDrawTimeOne = jCurrentTimeMillis2;
                    }
                    if (this.actionOrderOne > this.actionCountOne) {
                        this.startPlayActionOne = false;
                    }
                }
                break;
            case 4:
            case 6:
                if (this.startPlayActionOne) {
                    if (this.actionOrderOne - 1 < this.bitmaps1.size() && this.bitmaps1.get(this.actionOrderOne - 1) != null) {
                        drawDrawable(canvas, this.bitmaps1.get(this.actionOrderOne - 1), this.drawX, this.drawY, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                    }
                    long jCurrentTimeMillis3 = System.currentTimeMillis();
                    long j5 = this.lastDrawTimeOne;
                    if (j5 != 0) {
                        long j6 = jCurrentTimeMillis3 - j5;
                        if (j6 >= this.actionIntervalOne || j6 < 0) {
                            this.actionOrderOne++;
                            this.lastDrawTimeOne = jCurrentTimeMillis3;
                        }
                    } else {
                        this.lastDrawTimeOne = jCurrentTimeMillis3;
                    }
                    if (this.actionOrderOne > this.actionCountOne) {
                        this.startPlayActionOne = false;
                    }
                }
                break;
            case 5:
                if (this.startPlayActionOne) {
                    if (this.actionOrderOne - 1 < this.bitmaps1.size() && this.bitmaps1.get(this.actionOrderOne - 1) != null) {
                        int action_1_x3 = this.flatter.getConfig().getAction_1_x();
                        int action_1_y3 = this.flatter.getConfig().getAction_1_y();
                        float scaleX3 = this.flatter.getScaleX();
                        float scaleY3 = this.flatter.getScaleY();
                        if (getSupportScale()) {
                            action_1_x3 = (int) (action_1_x3 * this.flatter.getAbsoluteScaleX());
                            action_1_y3 = (int) (action_1_y3 * this.flatter.getAbsoluteScaleX());
                            scaleX3 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                            scaleY3 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                        }
                        drawDrawable(canvas, this.bitmaps1.get(this.actionOrderOne - 1), action_1_x3, action_1_y3, scaleX3, scaleY3);
                    }
                    long jCurrentTimeMillis4 = System.currentTimeMillis();
                    long j7 = this.lastDrawTimeOne;
                    if (j7 != 0) {
                        long j8 = jCurrentTimeMillis4 - j7;
                        if (j8 >= this.actionIntervalOne || j8 < 0) {
                            this.actionOrderOne++;
                            this.lastDrawTimeOne = jCurrentTimeMillis4;
                        }
                    } else {
                        this.lastDrawTimeOne = jCurrentTimeMillis4;
                    }
                    if (this.actionOrderOne > this.actionCountOne) {
                        this.startPlayActionOne = false;
                    }
                    break;
                } else if (this.bitmaps1.size() != 0 && this.bitmaps1.get(0) != null) {
                    int action_1_x4 = this.flatter.getConfig().getAction_1_x();
                    int action_1_y4 = this.flatter.getConfig().getAction_1_y();
                    float scaleX4 = this.flatter.getScaleX();
                    float scaleY4 = this.flatter.getScaleY();
                    if (getSupportScale()) {
                        action_1_x4 = (int) (action_1_x4 * this.flatter.getAbsoluteScaleX());
                        action_1_y4 = (int) (action_1_y4 * this.flatter.getAbsoluteScaleX());
                        scaleX4 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                        scaleY4 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                    }
                    drawDrawable(canvas, this.bitmaps1.get(0), action_1_x4, action_1_y4, scaleX4, scaleY4);
                    break;
                }
                break;
        }
    }

    public final void drawActionTwo(Canvas canvas, Paint mPaint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.actionCountTwo == 0) {
            return;
        }
        int open_action_2 = this.flatter.getConfig().getOpen_action_2();
        int i = 1;
        if (open_action_2 == 1 || open_action_2 == 2) {
            if (this.actionOrderTwo - 1 < this.bitmaps2.size() && this.bitmaps2.get(this.actionOrderTwo - 1) != null) {
                int action_2_x = this.flatter.getConfig().getAction_2_x();
                int action_2_y = this.flatter.getConfig().getAction_2_y();
                float scaleX = this.flatter.getScaleX();
                float scaleY = this.flatter.getScaleY();
                if (getSupportScale()) {
                    action_2_x = (int) (action_2_x * this.flatter.getAbsoluteScaleX());
                    action_2_y = (int) (action_2_y * this.flatter.getAbsoluteScaleX());
                    scaleX = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                    scaleY = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                }
                drawDrawable(canvas, this.bitmaps2.get(this.actionOrderTwo - 1), action_2_x, action_2_y, scaleX, scaleY);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.lastDrawTimeTwo;
            if (j != 0) {
                long j2 = jCurrentTimeMillis - j;
                if (j2 >= this.actionIntervalTwo || j2 < 0) {
                    this.actionOrderTwo++;
                    this.lastDrawTimeTwo = jCurrentTimeMillis;
                }
            } else {
                this.lastDrawTimeTwo = jCurrentTimeMillis;
            }
            int i2 = this.actionOrderTwo;
            int i3 = this.actionCountTwo;
            if (i2 > i3) {
                int i4 = this.actionCutPositionTwo;
                if (1 <= i4 && i4 <= i3) {
                    i = i4;
                }
                this.actionOrderTwo = i;
                return;
            }
            return;
        }
        if (open_action_2 == 3) {
            if (this.startPlayActionTwo) {
                if (this.actionOrderTwo - 1 < this.bitmaps2.size() && this.bitmaps2.get(this.actionOrderTwo - 1) != null) {
                    int action_2_x2 = this.flatter.getConfig().getAction_2_x();
                    int action_2_y2 = this.flatter.getConfig().getAction_2_y();
                    float scaleX2 = this.flatter.getScaleX();
                    float scaleY2 = this.flatter.getScaleY();
                    if (getSupportScale()) {
                        action_2_x2 = (int) (action_2_x2 * this.flatter.getAbsoluteScaleX());
                        action_2_y2 = (int) (action_2_y2 * this.flatter.getAbsoluteScaleX());
                        scaleX2 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                        scaleY2 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                    }
                    drawDrawable(canvas, this.bitmaps2.get(this.actionOrderTwo - 1), action_2_x2, action_2_y2, scaleX2, scaleY2);
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                long j3 = this.lastDrawTimeTwo;
                if (j3 != 0) {
                    long j4 = jCurrentTimeMillis2 - j3;
                    if (j4 >= this.actionIntervalTwo || j4 < 0) {
                        this.actionOrderTwo++;
                        this.lastDrawTimeTwo = jCurrentTimeMillis2;
                    }
                } else {
                    this.lastDrawTimeTwo = jCurrentTimeMillis2;
                }
                if (this.actionOrderTwo > this.actionCountTwo) {
                    this.startPlayActionTwo = false;
                    return;
                }
                return;
            }
            return;
        }
        if (open_action_2 == 4) {
            if (this.startPlayActionTwo) {
                if (this.actionOrderTwo - 1 < this.bitmaps2.size() && this.bitmaps2.get(this.actionOrderTwo - 1) != null) {
                    drawDrawable(canvas, this.bitmaps2.get(this.actionOrderTwo - 1), this.drawX, this.drawY, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                }
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                long j5 = this.lastDrawTimeTwo;
                if (j5 != 0) {
                    long j6 = jCurrentTimeMillis3 - j5;
                    if (j6 >= this.actionIntervalTwo || j6 < 0) {
                        this.actionOrderTwo++;
                        this.lastDrawTimeTwo = jCurrentTimeMillis3;
                    }
                } else {
                    this.lastDrawTimeTwo = jCurrentTimeMillis3;
                }
                if (this.actionOrderTwo > this.actionCountTwo) {
                    this.startPlayActionTwo = false;
                    return;
                }
                return;
            }
            return;
        }
        if (open_action_2 != 5) {
            return;
        }
        if (this.startPlayActionTwo) {
            if (this.actionOrderTwo - 1 < this.bitmaps2.size() && this.bitmaps2.get(this.actionOrderTwo - 1) != null) {
                int action_2_x3 = this.flatter.getConfig().getAction_2_x();
                int action_2_y3 = this.flatter.getConfig().getAction_2_y();
                float scaleX3 = this.flatter.getScaleX();
                float scaleY3 = this.flatter.getScaleY();
                if (getSupportScale()) {
                    action_2_x3 = (int) (action_2_x3 * this.flatter.getAbsoluteScaleX());
                    action_2_y3 = (int) (action_2_y3 * this.flatter.getAbsoluteScaleX());
                    scaleX3 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                    scaleY3 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                }
                drawDrawable(canvas, this.bitmaps2.get(this.actionOrderTwo - 1), action_2_x3, action_2_y3, scaleX3, scaleY3);
            }
            long jCurrentTimeMillis4 = System.currentTimeMillis();
            long j7 = this.lastDrawTimeTwo;
            if (j7 != 0) {
                long j8 = jCurrentTimeMillis4 - j7;
                if (j8 >= this.actionIntervalTwo || j8 < 0) {
                    this.actionOrderTwo++;
                    this.lastDrawTimeTwo = jCurrentTimeMillis4;
                }
            } else {
                this.lastDrawTimeTwo = jCurrentTimeMillis4;
            }
            if (this.actionOrderTwo > this.actionCountTwo) {
                this.startPlayActionTwo = false;
                return;
            }
            return;
        }
        if (this.bitmaps2.size() == 0 || this.bitmaps2.get(0) == null) {
            return;
        }
        int action_2_x4 = this.flatter.getConfig().getAction_2_x();
        int action_2_y4 = this.flatter.getConfig().getAction_2_y();
        float scaleX4 = this.flatter.getScaleX();
        float scaleY4 = this.flatter.getScaleY();
        if (getSupportScale()) {
            action_2_x4 = (int) (action_2_x4 * this.flatter.getAbsoluteScaleX());
            action_2_y4 = (int) (action_2_y4 * this.flatter.getAbsoluteScaleX());
            scaleX4 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
            scaleY4 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
        }
        drawDrawable(canvas, this.bitmaps2.get(0), action_2_x4, action_2_y4, scaleX4, scaleY4);
    }

    public final void drawActionThree(Canvas canvas, Paint mPaint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.actionCountThree == 0) {
            return;
        }
        int open_action_3 = this.flatter.getConfig().getOpen_action_3();
        int i = 1;
        if (open_action_3 == 1 || open_action_3 == 2) {
            if (this.actionOrderThree - 1 < this.bitmaps3.size() && this.bitmaps3.get(this.actionOrderThree - 1) != null) {
                int action_3_x = this.flatter.getConfig().getAction_3_x();
                int action_3_y = this.flatter.getConfig().getAction_3_y();
                float scaleX = this.flatter.getScaleX();
                float scaleY = this.flatter.getScaleY();
                if (getSupportScale()) {
                    action_3_x = (int) (action_3_x * this.flatter.getAbsoluteScaleX());
                    action_3_y = (int) (action_3_y * this.flatter.getAbsoluteScaleX());
                    scaleX = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                    scaleY = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                }
                drawDrawable(canvas, this.bitmaps3.get(this.actionOrderThree - 1), action_3_x, action_3_y, scaleX, scaleY);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.lastDrawTimeThree;
            if (j != 0) {
                long j2 = jCurrentTimeMillis - j;
                if (j2 >= this.actionIntervalThree || j2 < 0) {
                    this.actionOrderThree++;
                    this.lastDrawTimeThree = jCurrentTimeMillis;
                }
            } else {
                this.lastDrawTimeThree = jCurrentTimeMillis;
            }
            int i2 = this.actionOrderThree;
            int i3 = this.actionCountThree;
            if (i2 > i3) {
                int i4 = this.actionCutPositionThree;
                if (1 <= i4 && i4 <= i3) {
                    i = i4;
                }
                this.actionOrderThree = i;
                return;
            }
            return;
        }
        if (open_action_3 == 3) {
            if (this.startPlayActionThree) {
                if (this.actionOrderThree - 1 < this.bitmaps3.size() && this.bitmaps3.get(this.actionOrderThree - 1) != null) {
                    int action_3_x2 = this.flatter.getConfig().getAction_3_x();
                    int action_3_y2 = this.flatter.getConfig().getAction_3_y();
                    float scaleX2 = this.flatter.getScaleX();
                    float scaleY2 = this.flatter.getScaleY();
                    if (getSupportScale()) {
                        action_3_x2 = (int) (action_3_x2 * this.flatter.getAbsoluteScaleX());
                        action_3_y2 = (int) (action_3_y2 * this.flatter.getAbsoluteScaleX());
                        scaleX2 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                        scaleY2 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                    }
                    drawDrawable(canvas, this.bitmaps3.get(this.actionOrderThree - 1), action_3_x2, action_3_y2, scaleX2, scaleY2);
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                long j3 = this.lastDrawTimeThree;
                if (j3 != 0) {
                    long j4 = jCurrentTimeMillis2 - j3;
                    if (j4 >= this.actionIntervalThree || j4 < 0) {
                        this.actionOrderThree++;
                        this.lastDrawTimeThree = jCurrentTimeMillis2;
                    }
                } else {
                    this.lastDrawTimeThree = jCurrentTimeMillis2;
                }
                if (this.actionOrderThree > this.actionCountThree) {
                    this.startPlayActionThree = false;
                    return;
                }
                return;
            }
            return;
        }
        if (open_action_3 == 4) {
            if (this.startPlayActionThree) {
                if (this.actionOrderThree - 1 < this.bitmaps3.size() && this.bitmaps3.get(this.actionOrderThree - 1) != null) {
                    drawDrawable(canvas, this.bitmaps3.get(this.actionOrderThree - 1), this.drawX, this.drawY, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
                }
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                long j5 = this.lastDrawTimeThree;
                if (j5 != 0) {
                    long j6 = jCurrentTimeMillis3 - j5;
                    if (j6 >= this.actionIntervalThree || j6 < 0) {
                        this.actionOrderThree++;
                        this.lastDrawTimeThree = jCurrentTimeMillis3;
                    }
                } else {
                    this.lastDrawTimeThree = jCurrentTimeMillis3;
                }
                if (this.actionOrderThree > this.actionCountThree) {
                    this.startPlayActionThree = false;
                    return;
                }
                return;
            }
            return;
        }
        if (open_action_3 != 5) {
            return;
        }
        if (this.startPlayActionThree) {
            if (this.actionOrderThree - 1 < this.bitmaps3.size() && this.bitmaps3.get(this.actionOrderThree - 1) != null) {
                int action_3_x3 = this.flatter.getConfig().getAction_3_x();
                int action_3_y3 = this.flatter.getConfig().getAction_3_y();
                float scaleX3 = this.flatter.getScaleX();
                float scaleY3 = this.flatter.getScaleY();
                if (getSupportScale()) {
                    action_3_x3 = (int) (action_3_x3 * this.flatter.getAbsoluteScaleX());
                    action_3_y3 = (int) (action_3_y3 * this.flatter.getAbsoluteScaleX());
                    scaleX3 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                    scaleY3 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                }
                drawDrawable(canvas, this.bitmaps3.get(this.actionOrderThree - 1), action_3_x3, action_3_y3, scaleX3, scaleY3);
            }
            long jCurrentTimeMillis4 = System.currentTimeMillis();
            long j7 = this.lastDrawTimeThree;
            if (j7 != 0) {
                long j8 = jCurrentTimeMillis4 - j7;
                if (j8 >= this.actionIntervalThree || j8 < 0) {
                    this.actionOrderThree++;
                    this.lastDrawTimeThree = jCurrentTimeMillis4;
                }
            } else {
                this.lastDrawTimeThree = jCurrentTimeMillis4;
            }
            if (this.actionOrderThree > this.actionCountThree) {
                this.startPlayActionThree = false;
                return;
            }
            return;
        }
        if (this.bitmaps3.size() == 0 || this.bitmaps3.get(0) == null) {
            return;
        }
        int action_3_x4 = this.flatter.getConfig().getAction_3_x();
        int action_3_y4 = this.flatter.getConfig().getAction_3_y();
        float scaleX4 = this.flatter.getScaleX();
        float scaleY4 = this.flatter.getScaleY();
        if (getSupportScale()) {
            action_3_x4 = (int) (action_3_x4 * this.flatter.getAbsoluteScaleX());
            action_3_y4 = (int) (action_3_y4 * this.flatter.getAbsoluteScaleX());
            scaleX4 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
            scaleY4 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
        }
        drawDrawable(canvas, this.bitmaps3.get(0), action_3_x4, action_3_y4, scaleX4, scaleY4);
    }

    public final boolean onclick(int x, int y) {
        ClockConfig config = this.flatter.getConfig();
        if (config.getOpen_action_1() == 3 || config.getOpen_action_1() == 4 || config.getOpen_action_1() == 6) {
            this.startPlayActionOne = true;
            this.actionOrderOne = 1;
            this.lastDrawTimeOne = 0L;
            if (this.bitmaps1.get(0) != null) {
                float f = 2;
                this.drawX = x - ((int) ((this.bitmaps1.get(0).getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : 1.0f)) / f));
                this.drawY = y - ((int) ((this.bitmaps1.get(0).getIntrinsicHeight() * (getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : 1.0f)) / f));
            }
        } else if (config.getOpen_action_1() == 5 && !this.startPlayActionOne) {
            int action_1_x = getSupportScale() ? config.getAction_1_x() * ((int) this.flatter.getAbsoluteScaleX()) : config.getAction_1_x();
            int action_1_y = getSupportScale() ? config.getAction_1_y() * ((int) this.flatter.getAbsoluteScaleY()) : config.getAction_1_y();
            int iIntValue = (getSupportScale() ? Float.valueOf(this.bitmaps1.get(0).getIntrinsicWidth() * this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX()) : Integer.valueOf(this.bitmaps1.get(0).getIntrinsicWidth())).intValue();
            int iIntValue2 = (getSupportScale() ? Float.valueOf(this.bitmaps1.get(0).getIntrinsicHeight() * this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY()) : Integer.valueOf(this.bitmaps1.get(0).getIntrinsicHeight())).intValue();
            if (this.bitmaps1.get(0) != null && x >= action_1_x && x <= iIntValue + action_1_x && y >= action_1_y && y <= iIntValue2 + action_1_y) {
                this.startPlayActionOne = true;
                this.actionOrderOne = 1;
                this.lastDrawTimeOne = 0L;
                return true;
            }
        }
        if (config.getOpen_action_2() == 3 || config.getOpen_action_2() == 4) {
            this.startPlayActionTwo = true;
            this.actionOrderTwo = 1;
            this.lastDrawTimeTwo = 0L;
            if (this.bitmaps2.get(0) != null) {
                float f2 = 2;
                this.drawX = x - ((int) ((this.bitmaps2.get(0).getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : 1.0f)) / f2));
                this.drawY = y - ((int) ((this.bitmaps2.get(0).getIntrinsicHeight() * (getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : 1.0f)) / f2));
            }
        } else if (config.getOpen_action_2() == 5 && !this.startPlayActionTwo) {
            int action_2_x = config.getAction_2_x();
            int action_2_y = config.getAction_2_y();
            int iIntValue3 = (getSupportScale() ? Float.valueOf(this.bitmaps2.get(0).getIntrinsicWidth() * this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX()) : Integer.valueOf(this.bitmaps2.get(0).getIntrinsicWidth())).intValue();
            int iIntValue4 = (getSupportScale() ? Float.valueOf(this.bitmaps2.get(0).getIntrinsicHeight() * this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY()) : Integer.valueOf(this.bitmaps2.get(0).getIntrinsicHeight())).intValue();
            if (this.bitmaps2.get(0) != null && x >= action_2_x && x <= iIntValue3 + action_2_x && y >= action_2_y && y <= iIntValue4 + action_2_y) {
                this.startPlayActionTwo = true;
                this.actionOrderTwo = 1;
                this.lastDrawTimeTwo = 0L;
                return true;
            }
        }
        if (config.getOpen_action_3() == 3 || config.getOpen_action_3() == 4) {
            this.startPlayActionThree = true;
            this.actionOrderThree = 1;
            this.lastDrawTimeThree = 0L;
            if (this.bitmaps3.get(0) != null) {
                float f3 = 2;
                this.drawX = x - ((int) ((this.bitmaps3.get(0).getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : 1.0f)) / f3));
                this.drawY = y - ((int) ((this.bitmaps3.get(0).getIntrinsicHeight() * (getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : 1.0f)) / f3));
            }
        } else if (config.getOpen_action_3() == 5 && !this.startPlayActionThree) {
            int action_3_x = config.getAction_3_x();
            int action_3_y = config.getAction_3_y();
            int iIntValue5 = (getSupportScale() ? Float.valueOf(this.bitmaps3.get(0).getIntrinsicWidth() * this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX()) : Integer.valueOf(this.bitmaps3.get(0).getIntrinsicWidth())).intValue();
            int iIntValue6 = (getSupportScale() ? Float.valueOf(this.bitmaps3.get(0).getIntrinsicHeight() * this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY()) : Integer.valueOf(this.bitmaps3.get(0).getIntrinsicHeight())).intValue();
            if (this.bitmaps3.get(0) != null && x >= action_3_x && x <= iIntValue5 + action_3_x && y >= action_3_y && y <= iIntValue6 + action_3_y) {
                this.startPlayActionThree = true;
                this.actionOrderThree = 1;
                this.lastDrawTimeThree = 0L;
                return true;
            }
        }
        return false;
    }
}
