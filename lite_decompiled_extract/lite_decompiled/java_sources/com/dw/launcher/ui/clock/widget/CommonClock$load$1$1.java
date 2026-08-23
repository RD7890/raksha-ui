package com.dw.launcher.ui.clock.widget;

import android.graphics.drawable.Drawable;
import com.dw.launcher.data.entity.Clock;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

/* JADX INFO: compiled from: CommonClock.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@DebugMetadata(c = "com.dw.launcher.ui.clock.widget.CommonClock$load$1$1", f = "CommonClock.kt", i = {}, l = {211, 215}, m = "invokeSuspend", n = {}, s = {})
final class CommonClock$load$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Clock $clock;
    int label;
    final /* synthetic */ CommonClock this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonClock$load$1$1(CommonClock commonClock, Clock clock, Continuation<? super CommonClock$load$1$1> continuation) {
        super(2, continuation);
        this.this$0 = commonClock;
        this.$clock = clock;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommonClock$load$1$1(this.this$0, this.$clock, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommonClock$load$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0051 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Drawable drawable;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.mLoaded = true;
            Clock clock = this.$clock;
            if (clock != null) {
                this.label = 1;
                obj = clock.getPreview(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                drawable = null;
            }
            this.this$0.setBackground(drawable);
            this.this$0.invalidate();
            this.label = 2;
            if (this.$clock.loadFlatter(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            Timber.INSTANCE.i("----done----", new Object[0]);
            this.this$0.initPainter();
            return Unit.INSTANCE;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Timber.INSTANCE.i("----done----", new Object[0]);
        this.this$0.initPainter();
        return Unit.INSTANCE;
        drawable = (Drawable) obj;
        this.this$0.setBackground(drawable);
        this.this$0.invalidate();
        this.label = 2;
        if (this.$clock.loadFlatter(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        Timber.INSTANCE.i("----done----", new Object[0]);
        this.this$0.initPainter();
        return Unit.INSTANCE;
    }
}
