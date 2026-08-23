package com.dw.launcher.ui.fragment.clock;

import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import com.dw.launcher.data.entity.DialPreviewInfo;
import com.dw.launcher.ui.view.LongPressLayout;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

/* JADX INFO: compiled from: DialFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@DebugMetadata(c = "com.dw.launcher.ui.fragment.clock.DialFragment$setDialView$1$1", f = "DialFragment.kt", i = {0, 1}, l = {353, 393}, m = "invokeSuspend", n = {"preview", "preview"}, s = {"L$0", "L$0"})
final class DialFragment$setDialView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DialPreviewInfo $dial;
    final /* synthetic */ int $position;
    Object L$0;
    int label;
    final /* synthetic */ DialFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DialFragment$setDialView$1$1(DialFragment dialFragment, DialPreviewInfo dialPreviewInfo, int i, Continuation<? super DialFragment$setDialView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = dialFragment;
        this.$dial = dialPreviewInfo;
        this.$position = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DialFragment$setDialView$1$1(this.this$0, this.$dial, this.$position, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DialFragment$setDialView$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0149  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ImageView imageView;
        ImageView imageView2;
        DialFragment dialFragment;
        LongPressLayout longPressLayout;
        LongPressLayout longPressLayout2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ImageView imageViewShowPreviewImage = this.this$0.showPreviewImage(this.$dial);
            this.L$0 = imageViewShowPreviewImage;
            this.label = 1;
            Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new DialFragment$setDialView$1$1$watchfaceView$1(this.$dial, this.this$0, null), this);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            imageView = imageViewShowPreviewImage;
            obj = objWithContext;
        } else {
            if (i == 1) {
                imageView = (ImageView) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                imageView2 = (ImageView) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            if (imageView2 != null && (longPressLayout = (dialFragment = this.this$0).dialView) != null && longPressLayout.indexOfChild(imageView2) != -1) {
                longPressLayout2 = dialFragment.dialView;
                if (longPressLayout2 != null) {
                    longPressLayout2.removeView(imageView2);
                }
                Timber.INSTANCE.d("setDialView: 预览图移除了", new Object[0]);
            }
            return Unit.INSTANCE;
        }
        View view = (View) obj;
        Timber.INSTANCE.d("setDialView: 加载好了view " + this.$dial + "  ", new Object[0]);
        if (view != null) {
            LongPressLayout longPressLayout3 = this.this$0.dialView;
            if (longPressLayout3 != null) {
                longPressLayout3.addView(view, -1, -1);
            }
            Settings.System.putLong(this.this$0.requireContext().getContentResolver(), WatchFactory.WATCHFACEINDEX, this.$dial.getDialId());
            this.this$0.mPosition = this.$position;
            this.this$0.getMPreference().setPreferClock(String.valueOf(this.$dial.getDialId()));
            this.this$0.getMPreference().setCurrentDialSource(WatchFactory.INSTANCE.getDIAL_SOURCE_ONLINE());
            this.this$0.mLastDialSource = WatchFactory.INSTANCE.getDIAL_SOURCE_ONLINE();
            String filePath = this.$dial.getFilePath();
            Intrinsics.checkNotNull(filePath);
            if (StringsKt.startsWith$default(filePath, WatchFactory.INSTANCE.getFileJarSystemPath(), false, 2, (Object) null)) {
                this.this$0.getMPreference().setCurrentDialSource(WatchFactory.INSTANCE.getDIAL_SOURCE_LOCAL());
                this.this$0.mLastDialSource = WatchFactory.INSTANCE.getDIAL_SOURCE_LOCAL();
            }
            DialFragment dialFragment2 = this.this$0;
            dialFragment2.mLastClockStyle = dialFragment2.getMPreference().getPreferClock();
            Timber.INSTANCE.d("setDialView: 结束", new Object[0]);
            this.L$0 = imageView;
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            imageView2 = imageView;
            if (imageView2 != null) {
                longPressLayout2 = dialFragment.dialView;
                if (longPressLayout2 != null) {
                    longPressLayout2.removeView(imageView2);
                }
                Timber.INSTANCE.d("setDialView: 预览图移除了", new Object[0]);
            }
        } else {
            this.this$0.mPosition = 0;
            DialFragment dialFragment3 = this.this$0;
            dialFragment3.setDialView(dialFragment3.mPosition);
            this.this$0.mLastDialSource = WatchFactory.INSTANCE.getDIAL_SOURCE_LOCAL();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.fragment.clock.DialFragment$setDialView$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: DialFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.ui.fragment.clock.DialFragment$setDialView$1$1$2", f = "DialFragment.kt", i = {}, l = {394}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
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
}
