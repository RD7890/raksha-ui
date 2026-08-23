package com.dw.launcher.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.data.entity.Clock;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.data.entity.DialPreviewInfo;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.dw.launcher.ui.view.DeleteDialog;
import com.dw.launcher.util.ResourceUtils;
import com.dw.launcher.util.WatchFactory;
import com.google.android.mms.pdu.CharacterSets;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

/* JADX INFO: compiled from: PickClockActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@DebugMetadata(c = "com.dw.launcher.ui.activity.PickClockActivity$onCreate$1$convert$2", f = "PickClockActivity.kt", i = {}, l = {206, 210, 213}, m = "invokeSuspend", n = {}, s = {})
final class PickClockActivity$onCreate$1$convert$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageView $clockView;
    final /* synthetic */ ImageView $delView;
    final /* synthetic */ BaseViewHolder $holder;
    final /* synthetic */ DialPreviewInfo $item;
    final /* synthetic */ ImageView $specialView;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PickClockActivity this$0;
    final /* synthetic */ PickClockActivity.AnonymousClass1 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PickClockActivity$onCreate$1$convert$2(DialPreviewInfo dialPreviewInfo, ImageView imageView, PickClockActivity pickClockActivity, ImageView imageView2, ImageView imageView3, PickClockActivity.AnonymousClass1 anonymousClass1, BaseViewHolder baseViewHolder, Continuation<? super PickClockActivity$onCreate$1$convert$2> continuation) {
        super(2, continuation);
        this.$item = dialPreviewInfo;
        this.$specialView = imageView;
        this.this$0 = pickClockActivity;
        this.$clockView = imageView2;
        this.$delView = imageView3;
        this.this$1 = anonymousClass1;
        this.$holder = baseViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PickClockActivity$onCreate$1$convert$2 pickClockActivity$onCreate$1$convert$2 = new PickClockActivity$onCreate$1$convert$2(this.$item, this.$specialView, this.this$0, this.$clockView, this.$delView, this.this$1, this.$holder, continuation);
        pickClockActivity$onCreate$1$convert$2.L$0 = obj;
        return pickClockActivity$onCreate$1$convert$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PickClockActivity$onCreate$1$convert$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:56:0x0108 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x010d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String filePath;
        Unit unit;
        ImageView imageView;
        PickClockActivity pickClockActivity;
        Drawable drawable;
        Drawable drawable2;
        Clock clock;
        ClockConfigFlatter flatter;
        ClockConfig config;
        Clock clock2;
        LaunchConfig launchConfigLoadConfig;
        String filePath2;
        String default_clock_id;
        Drawable drawable3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i != 0) {
            if (i == 1) {
                imageView = (ImageView) this.L$0;
                ResultKt.throwOnFailure(obj);
                drawable2 = (Drawable) obj;
                imageView.setImageDrawable(drawable2);
                clock2 = this.$item.getClock();
                if (clock2 != null) {
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                    obj = clock2.getSpecialPreview(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i == 2) {
                imageView = (ImageView) this.L$1;
                pickClockActivity = (PickClockActivity) this.L$0;
                ResultKt.throwOnFailure(obj);
                drawable = (Drawable) obj;
                pickClockActivity.showDialPreview(imageView, drawable);
                clock2 = this.$item.getClock();
                if (clock2 != null) {
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                    obj = clock2.getSpecialPreview(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            drawable3 = (Drawable) obj;
            if (drawable3 != null) {
                this.$specialView.setImageDrawable(drawable3);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            if (this.$item.getDialSource() == WatchFactory.INSTANCE.getDIAL_SOURCE_ONLINE() || ((filePath = this.$item.getFilePath()) != null && StringsKt.contains$default((CharSequence) filePath, (CharSequence) WatchFactory.INSTANCE.getFileJarSystemPath(), false, 2, (Object) null))) {
                this.$specialView.setVisibility(8);
                this.this$0.showDialPreview(this.$clockView, new BitmapDrawable(this.$item.getPreview()));
            } else {
                String customWatchPath = this.this$0.getMPreference().getCustomWatchPath(String.valueOf(this.$item.getDialId()));
                if (customWatchPath != null) {
                    this.this$0.showDialPreview(this.$clockView, ResourceUtils.INSTANCE.getDrawableFromAbsolutePath(this.this$1.getContext(), customWatchPath));
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    DialPreviewInfo dialPreviewInfo = this.$item;
                    imageView = this.$clockView;
                    pickClockActivity = this.this$0;
                    if (Intrinsics.areEqual((dialPreviewInfo == null || (clock = dialPreviewInfo.getClock()) == null || (flatter = clock.getFlatter()) == null || (config = flatter.getConfig()) == null) ? null : config.getBg_is_customize(), "1")) {
                        Clock clock3 = dialPreviewInfo.getClock();
                        if (clock3 != null) {
                            this.L$0 = imageView;
                            this.label = 1;
                            obj = clock3.getInitPreview(this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            drawable2 = (Drawable) obj;
                        } else {
                            drawable2 = null;
                        }
                        imageView.setImageDrawable(drawable2);
                        clock2 = this.$item.getClock();
                        if (clock2 != null) {
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 3;
                            obj = clock2.getSpecialPreview(this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            drawable3 = (Drawable) obj;
                            if (drawable3 != null) {
                                this.$specialView.setImageDrawable(drawable3);
                            }
                        }
                    } else {
                        Clock clock4 = dialPreviewInfo.getClock();
                        if (clock4 != null) {
                            this.L$0 = pickClockActivity;
                            this.L$1 = imageView;
                            this.label = 2;
                            obj = clock4.getPreview(this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            drawable = (Drawable) obj;
                        } else {
                            drawable = null;
                        }
                        pickClockActivity.showDialPreview(imageView, drawable);
                        clock2 = this.$item.getClock();
                        if (clock2 != null) {
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 3;
                            obj = clock2.getSpecialPreview(this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            drawable3 = (Drawable) obj;
                            if (drawable3 != null) {
                                this.$specialView.setImageDrawable(drawable3);
                            }
                        }
                    }
                } else {
                    clock2 = this.$item.getClock();
                    if (clock2 != null) {
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 3;
                        obj = clock2.getSpecialPreview(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        drawable3 = (Drawable) obj;
                        if (drawable3 != null) {
                            this.$specialView.setImageDrawable(drawable3);
                        }
                    }
                }
            }
        }
        if (!this.this$0.getSupport_delete_internal_dial() ? !(this.$item.getDialSource() == WatchFactory.INSTANCE.getDIAL_SOURCE_LOCAL() || (Intrinsics.areEqual(String.valueOf(this.$item.getDialId()), this.this$0.getMPreference().getPreferClock()) && this.$item.getDialSource() == this.this$0.getMPreference().getCurrentDialSource())) : !((Intrinsics.areEqual(String.valueOf(this.$item.getDialId()), this.this$0.getMPreference().getPreferClock()) && this.$item.getDialSource() == this.this$0.getMPreference().getCurrentDialSource()) || (((launchConfigLoadConfig = this.this$0.getAssertLauncherRepository().loadConfig()) != null && (default_clock_id = launchConfigLoadConfig.getDefault_clock_id()) != null && Long.parseLong(default_clock_id) == this.$item.getDialId() && this.$item.getDialSource() == WatchFactory.INSTANCE.getDIAL_SOURCE_LOCAL()) || ((filePath2 = this.$item.getFilePath()) != null && StringsKt.contains$default((CharSequence) filePath2, (CharSequence) WatchFactory.INSTANCE.getFileJarSystemPath(), false, 2, (Object) null))))) {
            z = false;
        }
        this.$delView.setVisibility(z ? 8 : 0);
        if (!z) {
            ImageView imageView2 = this.$delView;
            final PickClockActivity pickClockActivity2 = this.this$0;
            final DialPreviewInfo dialPreviewInfo2 = this.$item;
            final BaseViewHolder baseViewHolder = this.$holder;
            final PickClockActivity.AnonymousClass1 anonymousClass1 = this.this$1;
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.PickClockActivity$onCreate$1$convert$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PickClockActivity$onCreate$1$convert$2.invokeSuspend$lambda$4(pickClockActivity2, dialPreviewInfo2, baseViewHolder, anonymousClass1, view);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void invokeSuspend$lambda$4(final PickClockActivity pickClockActivity, final DialPreviewInfo dialPreviewInfo, final BaseViewHolder baseViewHolder, final PickClockActivity.AnonymousClass1 anonymousClass1, View view) {
        final DeleteDialog deleteDialog = new DeleteDialog((Context) pickClockActivity);
        deleteDialog.show();
        String dialName = dialPreviewInfo.getDialName();
        if (dialName == null) {
            dialName = "";
        }
        deleteDialog.setName(dialName);
        deleteDialog.setDeleteListener(new Function0<Unit>() { // from class: com.dw.launcher.ui.activity.PickClockActivity$onCreate$1$convert$2$4$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                try {
                    if (dialPreviewInfo.getDialSource() != WatchFactory.INSTANCE.getDIAL_SOURCE_ONLINE()) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(baseViewHolder, pickClockActivity, dialPreviewInfo, anonymousClass1, deleteDialog, null), 3, null);
                    } else if (pickClockActivity.deleteDir(new File(dialPreviewInfo.getFilePath()))) {
                        int adapterPosition = baseViewHolder.getAdapterPosition();
                        pickClockActivity.mClockList.remove(dialPreviewInfo);
                        anonymousClass1.notifyItemRemoved(adapterPosition);
                        pickClockActivity.sendBroadcast(new Intent("com.timuen.action.refresh_watchface"));
                        deleteDialog.dismiss();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            /* JADX INFO: renamed from: com.dw.launcher.ui.activity.PickClockActivity$onCreate$1$convert$2$4$1$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: PickClockActivity.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
            @DebugMetadata(c = "com.dw.launcher.ui.activity.PickClockActivity$onCreate$1$convert$2$4$1$1$1", f = "PickClockActivity.kt", i = {}, l = {246, 253}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ BaseViewHolder $holder;
                final /* synthetic */ DialPreviewInfo $item;
                final /* synthetic */ DeleteDialog $this_apply;
                int label;
                final /* synthetic */ PickClockActivity this$0;
                final /* synthetic */ PickClockActivity.AnonymousClass1 this$1;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(BaseViewHolder baseViewHolder, PickClockActivity pickClockActivity, DialPreviewInfo dialPreviewInfo, PickClockActivity.AnonymousClass1 anonymousClass1, DeleteDialog deleteDialog, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$holder = baseViewHolder;
                    this.this$0 = pickClockActivity;
                    this.$item = dialPreviewInfo;
                    this.this$1 = anonymousClass1;
                    this.$this_apply = deleteDialog;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$holder, this.this$0, this.$item, this.this$1, this.$this_apply, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        obj = BuildersKt.withContext(Dispatchers.getIO(), new PickClockActivity$onCreate$1$convert$2$4$1$1$1$result$1(this.this$0, this.$item, null), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                    int iIntValue = ((Number) obj).intValue();
                    Timber.INSTANCE.d("delete position: " + this.$holder.getAdapterPosition() + "  ", new Object[0]);
                    int adapterPosition = this.$holder.getAdapterPosition();
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C00001(iIntValue, this.this$0, this.$item, this.$holder, adapterPosition, this.this$1, this.$this_apply, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.dw.launcher.ui.activity.PickClockActivity$onCreate$1$convert$2$4$1$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: PickClockActivity.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
                @DebugMetadata(c = "com.dw.launcher.ui.activity.PickClockActivity$onCreate$1$convert$2$4$1$1$1$1", f = "PickClockActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class C00001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ BaseViewHolder $holder;
                    final /* synthetic */ DialPreviewInfo $item;
                    final /* synthetic */ int $postion;
                    final /* synthetic */ int $result;
                    final /* synthetic */ DeleteDialog $this_apply;
                    int label;
                    final /* synthetic */ PickClockActivity this$0;
                    final /* synthetic */ PickClockActivity.AnonymousClass1 this$1;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00001(int i, PickClockActivity pickClockActivity, DialPreviewInfo dialPreviewInfo, BaseViewHolder baseViewHolder, int i2, PickClockActivity.AnonymousClass1 anonymousClass1, DeleteDialog deleteDialog, Continuation<? super C00001> continuation) {
                        super(2, continuation);
                        this.$result = i;
                        this.this$0 = pickClockActivity;
                        this.$item = dialPreviewInfo;
                        this.$holder = baseViewHolder;
                        this.$postion = i2;
                        this.this$1 = anonymousClass1;
                        this.$this_apply = deleteDialog;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C00001(this.$result, this.this$0, this.$item, this.$holder, this.$postion, this.this$1, this.$this_apply, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C00001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        if (this.$result > 0) {
                            this.this$0.mClockList.remove(this.$item);
                            WatchFactory.INSTANCE.getDialList().remove(this.$item);
                        }
                        Timber.INSTANCE.d("delete position222: " + this.$holder.getAdapterPosition() + "  postion " + this.$postion, new Object[0]);
                        this.this$1.notifyItemRemoved(this.$postion);
                        this.this$0.sendBroadcast(new Intent("com.internal.watchface.uninstall"));
                        this.$this_apply.dismiss();
                        return Unit.INSTANCE;
                    }
                }
            }
        });
    }
}
