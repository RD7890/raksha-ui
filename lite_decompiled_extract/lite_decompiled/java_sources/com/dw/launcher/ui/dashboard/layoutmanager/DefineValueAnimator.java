package com.dw.launcher.ui.dashboard.layoutmanager;

import android.util.MathUtils;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefineValueAnimator.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bJ\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/dw/launcher/ui/dashboard/layoutmanager/DefineValueAnimator;", "", "startValue", "", "endValue", "duration", "", "interpolator", "Lkotlin/Function1;", "updateListener", "", "(FFJLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "isAnimating", "", "startTime", "animate", "requestAnimationFrame", "start", "stop", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class DefineValueAnimator {
    private final long duration;
    private final float endValue;
    private final Function1<Float, Float> interpolator;
    private boolean isAnimating;
    private long startTime;
    private final float startValue;
    private final Function1<Float, Unit> updateListener;

    /* JADX WARN: Multi-variable type inference failed */
    public DefineValueAnimator(float f, float f2, long j, Function1<? super Float, Float> interpolator, Function1<? super Float, Unit> updateListener) {
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(updateListener, "updateListener");
        this.startValue = f;
        this.endValue = f2;
        this.duration = j;
        this.interpolator = interpolator;
        this.updateListener = updateListener;
    }

    public /* synthetic */ DefineValueAnimator(float f, float f2, long j, AnonymousClass1 anonymousClass1, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, j, (i & 8) != 0 ? new Function1<Float, Float>() { // from class: com.dw.launcher.ui.dashboard.layoutmanager.DefineValueAnimator.1
            public final Float invoke(float f3) {
                return Float.valueOf(f3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f3) {
                return invoke(f3.floatValue());
            }
        } : anonymousClass1, function1);
    }

    public final void start() throws InterruptedException {
        this.startTime = System.currentTimeMillis();
        this.isAnimating = true;
        animate();
    }

    public final void stop() {
        this.isAnimating = false;
    }

    private final void animate() throws InterruptedException {
        if (this.isAnimating) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.startTime;
            long j = this.duration;
            if (jCurrentTimeMillis >= j) {
                this.updateListener.invoke(Float.valueOf(this.endValue));
                this.isAnimating = false;
                return;
            }
            this.updateListener.invoke(Float.valueOf(MathUtils.lerp(this.startValue, this.endValue, this.interpolator.invoke(Float.valueOf(jCurrentTimeMillis / j)).floatValue())));
            requestAnimationFrame();
        }
    }

    private final void requestAnimationFrame() throws InterruptedException {
        Thread.sleep(50L);
        animate();
    }
}
