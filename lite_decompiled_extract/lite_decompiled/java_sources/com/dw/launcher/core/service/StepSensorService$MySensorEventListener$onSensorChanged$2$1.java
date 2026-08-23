package com.dw.launcher.core.service;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.StepCountData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: StepSensorService.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.dw.launcher.core.service.StepSensorService$MySensorEventListener$onSensorChanged$2$1", f = "StepSensorService.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
final class StepSensorService$MySensorEventListener$onSensorChanged$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StepCountData $stepCountData;
    int label;
    final /* synthetic */ StepSensorService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StepSensorService$MySensorEventListener$onSensorChanged$2$1(StepSensorService stepSensorService, StepCountData stepCountData, Continuation<? super StepSensorService$MySensorEventListener$onSensorChanged$2$1> continuation) {
        super(2, continuation);
        this.this$0 = stepSensorService;
        this.$stepCountData = stepCountData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StepSensorService$MySensorEventListener$onSensorChanged$2$1(this.this$0, this.$stepCountData, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.insertStepCountData(this.$stepCountData, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
