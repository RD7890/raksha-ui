package com.dw.launcher.ui.activity;

import com.dw.launcher.data.entity.DialPreviewInfo;
import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PickClockActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@DebugMetadata(c = "com.dw.launcher.ui.activity.PickClockActivity$onCreate$1$convert$2$4$1$1$1$result$1", f = "PickClockActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PickClockActivity$onCreate$1$convert$2$4$1$1$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ DialPreviewInfo $item;
    int label;
    final /* synthetic */ PickClockActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PickClockActivity$onCreate$1$convert$2$4$1$1$1$result$1(PickClockActivity pickClockActivity, DialPreviewInfo dialPreviewInfo, Continuation<? super PickClockActivity$onCreate$1$convert$2$4$1$1$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = pickClockActivity;
        this.$item = dialPreviewInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PickClockActivity$onCreate$1$convert$2$4$1$1$1$result$1(this.this$0, this.$item, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((PickClockActivity$onCreate$1$convert$2$4$1$1$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Boxing.boxInt(this.this$0.getClockConfigDao().deleteClockConfigById(String.valueOf(this.$item.getDialId())));
    }
}
