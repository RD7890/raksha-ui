package com.dw.launcher.ui.fragment.clock;

import android.content.Context;
import com.dw.launcher.data.entity.DialPreviewInfo;
import com.dw.launcher.util.WatchFactory;
import com.google.android.mms.pdu.CharacterSets;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.dw.launcher.ui.fragment.clock.DialFragment$receiver$1$onReceive$1", f = "DialFragment.kt", i = {}, l = {529}, m = "invokeSuspend", n = {}, s = {})
final class DialFragment$receiver$1$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DialFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DialFragment$receiver$1$onReceive$1(DialFragment dialFragment, Continuation<? super DialFragment$receiver$1$onReceive$1> continuation) {
        super(2, continuation);
        this.this$0 = dialFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DialFragment$receiver$1$onReceive$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DialFragment$receiver$1$onReceive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DialFragment dialFragment;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DialFragment dialFragment2 = this.this$0;
            WatchFactory watchFactory = WatchFactory.INSTANCE;
            Context contextRequireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            this.L$0 = dialFragment2;
            this.label = 1;
            Object objReloadDiaList = watchFactory.reloadDiaList(contextRequireContext, this);
            if (objReloadDiaList == coroutine_suspended) {
                return coroutine_suspended;
            }
            dialFragment = dialFragment2;
            obj = objReloadDiaList;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dialFragment = (DialFragment) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        dialFragment.setDialList((List) obj);
        List<DialPreviewInfo> dialList = this.this$0.getDialList();
        if (dialList != null) {
            DialFragment dialFragment3 = this.this$0;
            int i2 = 0;
            for (Object obj2 : dialList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                DialPreviewInfo dialPreviewInfo = (DialPreviewInfo) obj2;
                if (Intrinsics.areEqual(String.valueOf(dialPreviewInfo.getDialId()), dialFragment3.getMPreference().getPreferClock()) && dialPreviewInfo.getDialSource() == dialFragment3.getMPreference().getCurrentDialSource()) {
                    dialFragment3.setDialView(i2);
                }
                i2 = i3;
            }
        }
        return Unit.INSTANCE;
    }
}
