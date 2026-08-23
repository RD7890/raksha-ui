package com.dw.launcher.ui.fragment.step;

import com.dw.launcher.data.database.dao.StepDataDao;
import com.dw.launcher.data.entity.StepCountData;
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

/* JADX INFO: compiled from: StepFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/dw/launcher/data/entity/StepCountData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@DebugMetadata(c = "com.dw.launcher.ui.fragment.step.StepFragment$initData$1$stepdata$1", f = "StepFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class StepFragment$initData$1$stepdata$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super StepCountData>, Object> {
    final /* synthetic */ String $date;
    int label;
    final /* synthetic */ StepFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StepFragment$initData$1$stepdata$1(StepFragment stepFragment, String str, Continuation<? super StepFragment$initData$1$stepdata$1> continuation) {
        super(2, continuation);
        this.this$0 = stepFragment;
        this.$date = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StepFragment$initData$1$stepdata$1(this.this$0, this.$date, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super StepCountData> continuation) {
        return ((StepFragment$initData$1$stepdata$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        StepDataDao stepDataDao = this.this$0.getStepDataDao();
        String date = this.$date;
        Intrinsics.checkNotNullExpressionValue(date, "$date");
        return stepDataDao.queryStepByDate(date);
    }
}
