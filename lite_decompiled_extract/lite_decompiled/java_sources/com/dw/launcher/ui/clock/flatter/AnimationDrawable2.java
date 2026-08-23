package com.dw.launcher.ui.clock.flatter;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.AttributeSet;
import com.google.android.mms.pdu.CharacterSets;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import timber.log.Timber;

/* JADX INFO: compiled from: AnimationDrawable2.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J.\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0018\u00010\u0016R\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J \u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0014J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0018H\u0016J\u0018\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0018H\u0016J\b\u0010,\u001a\u00020\u0004H\u0016J\b\u0010-\u001a\u00020\u0004H\u0016J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0016¨\u0006/"}, d2 = {"Lcom/dw/launcher/ui/clock/flatter/AnimationDrawable2;", "Landroid/graphics/drawable/AnimationDrawable;", "()V", "addFrame", "", "frame", "Landroid/graphics/drawable/Drawable;", "duration", "", "getDuration", "i", "getFrame", "index", "getNumberOfFrames", "inflate", "r", "Landroid/content/res/Resources;", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "attrs", "Landroid/util/AttributeSet;", "theme", "Landroid/content/res/Resources$Theme;", "isOneShot", "", "isRunning", "mutate", "run", "scheduleDrawable", "who", "what", "Ljava/lang/Runnable;", "when", "", "scheduleSelf", "selectDrawable", "setConstantState", "state", "Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;", "setOneShot", "oneShot", "setVisible", "visible", "restart", "start", "stop", "unscheduleSelf", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class AnimationDrawable2 extends AnimationDrawable {
    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable what) {
        Intrinsics.checkNotNullParameter(what, "what");
        super.unscheduleSelf(what);
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        return super.setVisible(visible, restart);
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawableMutate = super.mutate();
        Intrinsics.checkNotNullExpressionValue(drawableMutate, "mutate(...)");
        return drawableMutate;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Drawable
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(r, "r");
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        super.inflate(r, parser, attrs, theme);
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.DrawableContainer
    protected void setConstantState(DrawableContainer.DrawableContainerState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.setConstantState(state);
    }

    @Override // android.graphics.drawable.DrawableContainer
    public boolean selectDrawable(int index) {
        Timber.INSTANCE.v("----selectDrawable: " + index + " duration: " + getDuration(index), new Object[0]);
        return super.selectDrawable(index);
    }

    @Override // android.graphics.drawable.AnimationDrawable, java.lang.Runnable
    public void run() {
        Timber.INSTANCE.v("----run", new Object[0]);
        super.run();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        Timber.INSTANCE.v("----scheduleDrawable,who: " + who + " what: " + what + ", when: " + when, new Object[0]);
        super.scheduleDrawable(who, what, when);
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable what, long when) {
        Intrinsics.checkNotNullParameter(what, "what");
        Timber.INSTANCE.v("----scheduleSelf, what: " + what + ", when: " + when, new Object[0]);
        super.scheduleSelf(what, when);
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public void start() {
        Timber.INSTANCE.v("----start", new Object[0]);
        super.start();
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public void stop() {
        Timber.INSTANCE.v("----stop", new Object[0]);
        super.stop();
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public boolean isRunning() {
        return super.isRunning();
    }

    @Override // android.graphics.drawable.AnimationDrawable
    public int getNumberOfFrames() {
        return super.getNumberOfFrames();
    }

    @Override // android.graphics.drawable.AnimationDrawable
    public Drawable getFrame(int index) {
        Drawable frame = super.getFrame(index);
        Intrinsics.checkNotNullExpressionValue(frame, "getFrame(...)");
        return frame;
    }

    @Override // android.graphics.drawable.AnimationDrawable
    public int getDuration(int i) {
        return super.getDuration(i);
    }

    @Override // android.graphics.drawable.AnimationDrawable
    public boolean isOneShot() {
        return super.isOneShot();
    }

    @Override // android.graphics.drawable.AnimationDrawable
    public void setOneShot(boolean oneShot) {
        super.setOneShot(oneShot);
    }

    @Override // android.graphics.drawable.AnimationDrawable
    public void addFrame(Drawable frame, int duration) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        super.addFrame(frame, duration);
    }
}
