package com.dw.launcher.data.entity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: Clock.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/dw/launcher/data/entity/Clock;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "config", "Lcom/dw/launcher/data/entity/ClockConfig;", "fromAsset", BuildConfig.FLAVOR, "(Landroid/content/Context;Lcom/dw/launcher/data/entity/ClockConfig;Z)V", "getConfig", "()Lcom/dw/launcher/data/entity/ClockConfig;", "getContext", "()Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "setFlatter", "(Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "getFromAsset", "()Z", "forceLoadFlatter", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInitPreview", "Landroid/graphics/drawable/Drawable;", "getPreview", "getSpecialPreview", "loadFlatter", "refreshBackgroundIndex", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Clock {
    private final ClockConfig config;
    private final Context context;
    private ClockConfigFlatter flatter;
    private final boolean fromAsset;

    public Clock(Context context, ClockConfig clockConfig, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clockConfig, "config");
        this.context = context;
        this.config = clockConfig;
        this.fromAsset = z;
    }

    public /* synthetic */ Clock(Context context, ClockConfig clockConfig, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, clockConfig, (i & 4) != 0 ? true : z);
    }

    public final Context getContext() {
        return this.context;
    }

    public final ClockConfig getConfig() {
        return this.config;
    }

    public final boolean getFromAsset() {
        return this.fromAsset;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public final void setFlatter(ClockConfigFlatter clockConfigFlatter) {
        this.flatter = clockConfigFlatter;
    }

    /* JADX INFO: renamed from: com.dw.launcher.data.entity.Clock$loadFlatter$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Clock.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.data.entity.Clock$loadFlatter$2", f = "Clock.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00312 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ClockConfigFlatter>, Object> {
        int label;

        C00312(Continuation<? super C00312> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Clock.this.new C00312(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ClockConfigFlatter> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (Clock.this.getFlatter() == null) {
                Clock.this.setFlatter(new ClockConfigFlatter(Clock.this.getContext(), Clock.this.getConfig()));
                ClockConfigFlatter flatter = Clock.this.getFlatter();
                Intrinsics.checkNotNull(flatter);
                flatter.load();
            } else {
                ClockConfigFlatter flatter2 = Clock.this.getFlatter();
                Intrinsics.checkNotNull(flatter2);
                if (!flatter2.isLoadResFinish()) {
                    ClockConfigFlatter flatter3 = Clock.this.getFlatter();
                    Intrinsics.checkNotNull(flatter3);
                    flatter3.load();
                }
            }
            return Clock.this.getFlatter();
        }
    }

    public final Object loadFlatter(Continuation<? super ClockConfigFlatter> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00312(null), continuation);
    }

    /* JADX INFO: renamed from: com.dw.launcher.data.entity.Clock$forceLoadFlatter$2, reason: invalid class name */
    /* JADX INFO: compiled from: Clock.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.data.entity.Clock$forceLoadFlatter$2", f = "Clock.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ClockConfigFlatter>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Clock.this.new AnonymousClass2(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ClockConfigFlatter> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Clock.this.setFlatter(new ClockConfigFlatter(Clock.this.getContext(), Clock.this.getConfig()));
            ClockConfigFlatter flatter = Clock.this.getFlatter();
            Intrinsics.checkNotNull(flatter);
            flatter.load();
            return Clock.this.getFlatter();
        }
    }

    public final Object forceLoadFlatter(Continuation<? super ClockConfigFlatter> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }

    public final void refreshBackgroundIndex(int index) {
        List backgrounds;
        ClockConfigFlatter clockConfigFlatter = this.flatter;
        if (clockConfigFlatter == null || clockConfigFlatter == null) {
            return;
        }
        clockConfigFlatter.setBackground((clockConfigFlatter == null || (backgrounds = clockConfigFlatter.getBackgrounds()) == null) ? null : (Drawable) backgrounds.get(index));
    }

    public final Object getPreview(Continuation<? super Drawable> continuation) {
        if (this.flatter == null) {
            this.flatter = new ClockConfigFlatter(this.context, this.config);
        }
        ClockConfigFlatter clockConfigFlatter = this.flatter;
        Intrinsics.checkNotNull(clockConfigFlatter);
        return clockConfigFlatter.getPreview();
    }

    public final Object getInitPreview(Continuation<? super Drawable> continuation) {
        if (this.flatter == null) {
            this.flatter = new ClockConfigFlatter(this.context, this.config);
        }
        ClockConfigFlatter clockConfigFlatter = this.flatter;
        Intrinsics.checkNotNull(clockConfigFlatter);
        return clockConfigFlatter.loadInitPreview();
    }

    public final Object getSpecialPreview(Continuation<? super Drawable> continuation) {
        if (this.flatter == null) {
            this.flatter = new ClockConfigFlatter(this.context, this.config);
        }
        ClockConfigFlatter clockConfigFlatter = this.flatter;
        Intrinsics.checkNotNull(clockConfigFlatter);
        return clockConfigFlatter.getSpecialPreview();
    }
}
