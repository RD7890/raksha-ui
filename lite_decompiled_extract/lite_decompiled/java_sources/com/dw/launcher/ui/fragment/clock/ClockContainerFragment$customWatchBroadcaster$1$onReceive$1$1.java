package com.dw.launcher.ui.fragment.clock;

import com.dw.launcher.data.entity.Clock;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.ui.clock.widget.CommonClock;
import com.google.android.mms.pdu.CharacterSets;
import java.util.Collection;
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
@DebugMetadata(c = "com.dw.launcher.ui.fragment.clock.ClockContainerFragment$customWatchBroadcaster$1$onReceive$1$1", f = "ClockContainerFragment.kt", i = {}, l = {659}, m = "invokeSuspend", n = {}, s = {})
final class ClockContainerFragment$customWatchBroadcaster$1$onReceive$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ Clock $item;
    int label;
    final /* synthetic */ ClockContainerFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClockContainerFragment$customWatchBroadcaster$1$onReceive$1$1(Clock clock, ClockContainerFragment clockContainerFragment, String str, Continuation<? super ClockContainerFragment$customWatchBroadcaster$1$onReceive$1$1> continuation) {
        super(2, continuation);
        this.$item = clock;
        this.this$0 = clockContainerFragment;
        this.$id = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClockContainerFragment$customWatchBroadcaster$1$onReceive$1$1(this.$item, this.this$0, this.$id, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClockContainerFragment$customWatchBroadcaster$1$onReceive$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ClockConfig config;
        Clock mClock;
        ClockConfig config2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$item.forceLoadFlatter(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CommonClock commonClock = this.this$0.comcomClock;
        Object obj2 = null;
        if (Intrinsics.areEqual((commonClock == null || (mClock = commonClock.getMClock()) == null || (config2 = mClock.getConfig()) == null) ? null : config2.getId(), this.$id)) {
            CommonClock commonClock2 = this.this$0.comcomClock;
            if (commonClock2 != null) {
                commonClock2.setForceConfig(this.$item);
            }
        } else {
            Collection<CommonClock> collectionValues = this.this$0.getViewClockMap().values();
            String str = this.$id;
            for (Object obj3 : collectionValues) {
                Clock mClock2 = ((CommonClock) obj3).getMClock();
                if (Intrinsics.areEqual((mClock2 == null || (config = mClock2.getConfig()) == null) ? null : config.getId(), str)) {
                    obj2 = obj3;
                    break;
                }
            }
            CommonClock commonClock3 = (CommonClock) obj2;
            if (commonClock3 != null) {
                commonClock3.setForceConfig(this.$item);
            }
        }
        return Unit.INSTANCE;
    }
}
