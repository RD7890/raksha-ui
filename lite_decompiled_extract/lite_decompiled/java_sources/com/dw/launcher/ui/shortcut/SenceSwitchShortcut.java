package com.dw.launcher.ui.shortcut;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.dw.launcher.R;
import com.dw.launcher.core.component.VoiceComponent;
import com.dw.launcher.data.config.AppFilterConfig;
import com.dw.launcher.data.entity.SenceEvent;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

/* JADX INFO: compiled from: SenceSwitchShortcut.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\u0006\u0010\u001c\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/dw/launcher/ui/shortcut/SenceSwitchShortcut;", "Lcom/dw/launcher/ui/shortcut/SwitchShortcut;", "context", "Landroid/content/Context;", "mVoiceComponent", "Lcom/dw/launcher/core/component/VoiceComponent;", "(Landroid/content/Context;Lcom/dw/launcher/core/component/VoiceComponent;)V", "getContext", "()Landroid/content/Context;", "mItemView", "Landroid/view/View;", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "ringerModeIndex", "", "bind", "", "view", "notifyDataChanged", "selected", "", "onClicked", "setZenMode", "ringerMode", "senceEvent", "toggleRingerMode", "topsence", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class SenceSwitchShortcut extends SwitchShortcut {
    private final Context context;
    private View mItemView;
    private final VoiceComponent mVoiceComponent;
    private final NotificationManager notificationManager;
    private int ringerModeIndex;

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SenceSwitchShortcut(Context context, VoiceComponent mVoiceComponent) {
        super(R.drawable.top_shortcut_svg_vibrate);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mVoiceComponent, "mVoiceComponent");
        this.context = context;
        this.mVoiceComponent = mVoiceComponent;
        this.ringerModeIndex = mVoiceComponent.getAudioManager().getRingerMode();
        Object systemService = context != null ? context.getSystemService("notification") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        this.notificationManager = (NotificationManager) systemService;
    }

    public final NotificationManager getNotificationManager() {
        return this.notificationManager;
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void bind(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.bind(view);
        this.mItemView = view;
        setSelected(true);
        View view2 = this.mItemView;
        if (view2 != null) {
            view2.setSelected(getSelected());
        }
        notifyDataChanged(true);
        View view3 = this.mItemView;
        if (view3 != null) {
            view3.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.shortcut.SenceSwitchShortcut$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view4) {
                    return SenceSwitchShortcut.bind$lambda$1(this.f$0, view4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$1(SenceSwitchShortcut this$0, View view) {
        Context context;
        Context context2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Build.VERSION.SDK_INT >= 33) {
            Intent intent = new Intent("android.settings.SOUND_SETTINGS");
            intent.setFlags(268435456);
            if (!AppFilterConfig.INSTANCE.isIntentAvailable(this$0.context, intent) || (context2 = this$0.context) == null) {
                return true;
            }
            context2.startActivity(intent);
            return true;
        }
        Intent intent2 = new Intent();
        intent2.setComponent(new ComponentName("com.android.settings", "com.sprd.audioprofile.AudioProfileSettings"));
        intent2.setFlags(268435456);
        if (!AppFilterConfig.INSTANCE.isIntentAvailable(this$0.context, intent2) || (context = this$0.context) == null) {
            return true;
        }
        context.startActivity(intent2);
        return true;
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void notifyDataChanged(boolean selected) {
        topsence();
    }

    @Override // com.dw.launcher.ui.shortcut.SwitchShortcut
    public void onClicked(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 33) {
            int zenMode = this.notificationManager.getZenMode();
            if (zenMode == SenceEvent.ZENMODE_TOTAL || zenMode == SenceEvent.ZENMODE_PRIORITY) {
                setZenMode(2, SenceEvent.ZENMODE_NOT);
                return;
            } else {
                setZenMode(2, SenceEvent.ZENMODE_PRIORITY);
                return;
            }
        }
        toggleRingerMode();
    }

    private final void toggleRingerMode() {
        int i;
        this.ringerModeIndex++;
        Vibrator vibrator = (Vibrator) this.context.getSystemService("vibrator");
        Intrinsics.checkNotNull(vibrator);
        if (!vibrator.hasVibrator() && (i = this.ringerModeIndex) == 1) {
            this.ringerModeIndex = i + 1;
        }
        if (this.ringerModeIndex > 3) {
            this.ringerModeIndex = 0;
        }
        int i2 = this.ringerModeIndex;
        if (i2 == 0) {
            setZenMode(0, SenceEvent.ZENMODE_ALAEM);
            return;
        }
        if (i2 == 1) {
            setZenMode(1, SenceEvent.ZENMODE_NOT);
        } else if (i2 == 2) {
            setZenMode(2, SenceEvent.ZENMODE_NOT);
        } else {
            setZenMode(2, SenceEvent.ZENMODE_TOTAL);
        }
    }

    private final void setZenMode(int ringerMode, int senceEvent) {
        this.mVoiceComponent.getAudioManager().setRingerMode(ringerMode);
        this.notificationManager.setZenMode(senceEvent, null, "ZenMode");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.shortcut.SenceSwitchShortcut$setZenMode$1, reason: invalid class name */
    /* JADX INFO: compiled from: SenceSwitchShortcut.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.ui.shortcut.SenceSwitchShortcut$setZenMode$1", f = "SenceSwitchShortcut.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SenceSwitchShortcut.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Timber.INSTANCE.d("setZenMode", new Object[0]);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new C00011(SenceSwitchShortcut.this, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.dw.launcher.ui.shortcut.SenceSwitchShortcut$setZenMode$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SenceSwitchShortcut.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
        @DebugMetadata(c = "com.dw.launcher.ui.shortcut.SenceSwitchShortcut$setZenMode$1$1", f = "SenceSwitchShortcut.kt", i = {}, l = {122, 123}, m = "invokeSuspend", n = {}, s = {})
        static final class C00011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SenceSwitchShortcut this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00011(SenceSwitchShortcut senceSwitchShortcut, Continuation<? super C00011> continuation) {
                super(2, continuation);
                this.this$0 = senceSwitchShortcut;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00011(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (DelayKt.delay(200L, this) == coroutine_suspended) {
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
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C00021(this.this$0, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.dw.launcher.ui.shortcut.SenceSwitchShortcut$setZenMode$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: SenceSwitchShortcut.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
            @DebugMetadata(c = "com.dw.launcher.ui.shortcut.SenceSwitchShortcut$setZenMode$1$1$1", f = "SenceSwitchShortcut.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            static final class C00021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ SenceSwitchShortcut this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00021(SenceSwitchShortcut senceSwitchShortcut, Continuation<? super C00021> continuation) {
                    super(2, continuation);
                    this.this$0 = senceSwitchShortcut;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00021(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.this$0.topsence();
                    return Unit.INSTANCE;
                }
            }
        }
    }

    public final void topsence() {
        Timber.INSTANCE.d("setZenMode topsence", new Object[0]);
        int ringerMode = this.mVoiceComponent.getAudioManager().getRingerMode();
        int zenMode = this.notificationManager.getZenMode();
        Log.i("lkang", "   zenMode = " + zenMode + "  ringerMode = " + ringerMode);
        View view = this.mItemView;
        if (view != null) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) view;
            if (Build.VERSION.SDK_INT >= 33) {
                if (zenMode == SenceEvent.ZENMODE_TOTAL || zenMode == SenceEvent.ZENMODE_PRIORITY) {
                    imageView.setImageResource(R.drawable.top_shortcut_not_disturb);
                    return;
                } else {
                    imageView.setImageResource(R.drawable.top_shortcut_ring);
                    return;
                }
            }
            if (zenMode == SenceEvent.ZENMODE_TOTAL) {
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.top_shortcut_not_disturb);
                    return;
                }
                return;
            }
            if (zenMode == SenceEvent.ZENMODE_NOT || zenMode == SenceEvent.ZENMODE_ALAEM) {
                if (ringerMode == 0) {
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.top_shortcut_mute);
                    }
                } else if (ringerMode == 1) {
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.top_shortcut_vibrate);
                    }
                } else if (ringerMode == 2 && imageView != null) {
                    imageView.setImageResource(R.drawable.top_shortcut_ring);
                }
            }
        }
    }
}
