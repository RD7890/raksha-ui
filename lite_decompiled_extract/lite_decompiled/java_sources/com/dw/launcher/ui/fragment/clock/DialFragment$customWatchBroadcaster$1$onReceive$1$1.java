package com.dw.launcher.ui.fragment.clock;

import android.view.View;
import com.dw.launcher.data.entity.Clock;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.data.entity.DialPreviewInfo;
import com.dw.launcher.ui.clock.widget.CommonClock;
import com.dw.launcher.ui.view.LongPressLayout;
import com.google.android.mms.pdu.CharacterSets;
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

/* JADX INFO: compiled from: DialFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@DebugMetadata(c = "com.dw.launcher.ui.fragment.clock.DialFragment$customWatchBroadcaster$1$onReceive$1$1", f = "DialFragment.kt", i = {}, l = {622}, m = "invokeSuspend", n = {}, s = {})
final class DialFragment$customWatchBroadcaster$1$onReceive$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ DialPreviewInfo $item;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DialFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DialFragment$customWatchBroadcaster$1$onReceive$1$1(DialPreviewInfo dialPreviewInfo, DialFragment dialFragment, String str, Continuation<? super DialFragment$customWatchBroadcaster$1$onReceive$1$1> continuation) {
        super(2, continuation);
        this.$item = dialPreviewInfo;
        this.this$0 = dialFragment;
        this.$id = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DialFragment$customWatchBroadcaster$1$onReceive$1$1(this.$item, this.this$0, this.$id, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DialFragment$customWatchBroadcaster$1$onReceive$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DialFragment dialFragment;
        String str;
        DialPreviewInfo dialPreviewInfo;
        View childAt;
        ClockConfig config;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Clock clock = this.$item.getClock();
            if (clock != null) {
                DialFragment dialFragment2 = this.this$0;
                String str2 = this.$id;
                DialPreviewInfo dialPreviewInfo2 = this.$item;
                this.L$0 = dialFragment2;
                this.L$1 = str2;
                this.L$2 = dialPreviewInfo2;
                this.label = 1;
                if (clock.forceLoadFlatter(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dialFragment = dialFragment2;
                str = str2;
                dialPreviewInfo = dialPreviewInfo2;
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        dialPreviewInfo = (DialPreviewInfo) this.L$2;
        str = (String) this.L$1;
        dialFragment = (DialFragment) this.L$0;
        ResultKt.throwOnFailure(obj);
        LongPressLayout longPressLayout = dialFragment.dialView;
        if (longPressLayout != null && (childAt = longPressLayout.getChildAt(0)) != null && (childAt instanceof CommonClock)) {
            CommonClock commonClock = (CommonClock) childAt;
            Clock mClock = commonClock.getMClock();
            if (Intrinsics.areEqual((mClock == null || (config = mClock.getConfig()) == null) ? null : config.getId(), str)) {
                Clock clock2 = dialPreviewInfo.getClock();
                Intrinsics.checkNotNull(clock2);
                commonClock.setForceConfig(clock2);
            }
        }
        return Unit.INSTANCE;
    }
}
