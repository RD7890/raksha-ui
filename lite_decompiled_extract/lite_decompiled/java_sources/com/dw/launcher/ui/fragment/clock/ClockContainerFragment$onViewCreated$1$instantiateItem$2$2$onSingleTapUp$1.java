package com.dw.launcher.ui.fragment.clock;

import com.dw.launcher.data.entity.Clock;
import com.dw.launcher.ui.clock.widget.CommonClock;
import com.google.android.mms.pdu.CharacterSets;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ClockContainerFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@DebugMetadata(c = "com.dw.launcher.ui.fragment.clock.ClockContainerFragment$onViewCreated$1$instantiateItem$2$2$onSingleTapUp$1", f = "ClockContainerFragment.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
final class ClockContainerFragment$onViewCreated$1$instantiateItem$2$2$onSingleTapUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ ClockContainerFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClockContainerFragment$onViewCreated$1$instantiateItem$2$2$onSingleTapUp$1(ClockContainerFragment clockContainerFragment, int i, Continuation<? super ClockContainerFragment$onViewCreated$1$instantiateItem$2$2$onSingleTapUp$1> continuation) {
        super(2, continuation);
        this.this$0 = clockContainerFragment;
        this.$position = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClockContainerFragment$onViewCreated$1$instantiateItem$2$2$onSingleTapUp$1(this.this$0, this.$position, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClockContainerFragment$onViewCreated$1$instantiateItem$2$2$onSingleTapUp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getAssetsClockRepository().switchToNextClickedClock((Clock) this.this$0.mClockList.get(this.$position), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Clock clock = (Clock) obj;
        List list = this.this$0.mClockList;
        int i2 = this.$position;
        Intrinsics.checkNotNull(clock);
        list.set(i2, clock);
        CommonClock commonClock = this.this$0.comcomClock;
        if (commonClock != null) {
            commonClock.setForceConfig(clock);
        }
        return Unit.INSTANCE;
    }
}
