package com.dw.launcher.ui.fragment.clock;

import android.content.Context;
import android.view.View;
import com.dw.launcher.data.entity.DialPreviewInfo;
import com.dw.launcher.util.WatchFactory;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DialFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroid/view/View;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@DebugMetadata(c = "com.dw.launcher.ui.fragment.clock.DialFragment$setDialView$1$1$watchfaceView$1", f = "DialFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DialFragment$setDialView$1$1$watchfaceView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super View>, Object> {
    final /* synthetic */ DialPreviewInfo $dial;
    int label;
    final /* synthetic */ DialFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DialFragment$setDialView$1$1$watchfaceView$1(DialPreviewInfo dialPreviewInfo, DialFragment dialFragment, Continuation<? super DialFragment$setDialView$1$1$watchfaceView$1> continuation) {
        super(2, continuation);
        this.$dial = dialPreviewInfo;
        this.this$0 = dialFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DialFragment$setDialView$1$1$watchfaceView$1(this.$dial, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super View> continuation) {
        return ((DialFragment$setDialView$1$1$watchfaceView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String filePath = this.$dial.getFilePath();
        Intrinsics.checkNotNull(filePath);
        if (!StringsKt.startsWith$default(filePath, WatchFactory.INSTANCE.getDwExtenerDialPath(), false, 2, (Object) null)) {
            String filePath2 = this.$dial.getFilePath();
            Intrinsics.checkNotNull(filePath2);
            if (!StringsKt.startsWith$default(filePath2, WatchFactory.INSTANCE.getFileJarSystemPath(), false, 2, (Object) null)) {
                WatchFactory watchFactory = WatchFactory.INSTANCE;
                Context contextRequireContext = this.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                String filePath3 = this.$dial.getFilePath();
                Intrinsics.checkNotNull(filePath3);
                return watchFactory.getOnlineWatchFaceView(contextRequireContext, filePath3, (int) this.$dial.getDialId());
            }
        }
        WatchFactory watchFactory2 = WatchFactory.INSTANCE;
        Context contextRequireContext2 = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        String filePath4 = this.$dial.getFilePath();
        Intrinsics.checkNotNull(filePath4);
        return watchFactory2.getDwOnlineWatchFaceView(contextRequireContext2, filePath4, (int) this.$dial.getDialId());
    }
}
