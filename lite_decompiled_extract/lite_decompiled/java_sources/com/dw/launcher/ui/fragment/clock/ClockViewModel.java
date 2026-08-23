package com.dw.launcher.ui.fragment.clock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.dw.launcher.data.component.LocaleComponent;
import com.dw.launcher.data.entity.Clock;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.repository.ClockRepository;
import com.google.android.mms.pdu.CharacterSets;
import java.util.List;
import javax.inject.Inject;
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
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

/* JADX INFO: compiled from: ClockViewModel.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u001cH\u0014J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020\u001cJ\u0006\u0010&\u001a\u00020\u001cR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/dw/launcher/ui/fragment/clock/ClockViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/dw/launcher/data/component/LocaleComponent$OnLocaleChangedListener;", "repository", "Lcom/dw/launcher/data/repository/ClockRepository;", "preference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "context", "Landroid/content/Context;", "localeComponent", "Lcom/dw/launcher/data/component/LocaleComponent;", "(Lcom/dw/launcher/data/repository/ClockRepository;Lcom/dw/launcher/data/preference/LauncherPreference;Landroid/content/Context;Lcom/dw/launcher/data/component/LocaleComponent;)V", "_clockList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/dw/launcher/data/entity/Clock;", "clockList", "Landroidx/lifecycle/LiveData;", "getClockList", "()Landroidx/lifecycle/LiveData;", "clockUpdate", "getClockUpdate", "()Landroidx/lifecycle/MutableLiveData;", "getContext", "()Landroid/content/Context;", "mReceiver", "Landroid/content/BroadcastReceiver;", "changeClock", "", "clock", "(Lcom/dw/launcher/data/entity/Clock;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadClock", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "onLocaleChanged", "changed", "", "register", "unregister", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ClockViewModel extends ViewModel implements LocaleComponent.OnLocaleChangedListener {
    private final MutableLiveData<List<Clock>> _clockList;
    private final LiveData<List<Clock>> clockList;
    private final MutableLiveData<Clock> clockUpdate;
    private final Context context;
    private final LocaleComponent localeComponent;
    private BroadcastReceiver mReceiver;
    private final LauncherPreference preference;
    private final ClockRepository repository;

    public final Context getContext() {
        return this.context;
    }

    @Inject
    public ClockViewModel(ClockRepository repository, LauncherPreference preference, Context context, LocaleComponent localeComponent) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(preference, "preference");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(localeComponent, "localeComponent");
        this.repository = repository;
        this.preference = preference;
        this.context = context;
        this.localeComponent = localeComponent;
        LiveData<List<Clock>> mutableLiveData = new MutableLiveData<>();
        this._clockList = mutableLiveData;
        this.clockList = mutableLiveData;
        this.clockUpdate = new MutableLiveData<>();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(null), 3, null);
        register();
        localeComponent.addListener(this);
    }

    public final LiveData<List<Clock>> getClockList() {
        return this.clockList;
    }

    public final MutableLiveData<Clock> getClockUpdate() {
        return this.clockUpdate;
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.fragment.clock.ClockViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClockViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.ui.fragment.clock.ClockViewModel$1", f = "ClockViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClockViewModel.this.new AnonymousClass1(continuation);
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
                Timber.INSTANCE.i("-----load clocks", new Object[0]);
                this.label = 1;
                obj = ClockViewModel.this.loadClock(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ClockViewModel.this._clockList.setValue((List) obj);
            Timber.INSTANCE.i("-----load clocks done", new Object[0]);
            return Unit.INSTANCE;
        }
    }

    protected void onCleared() {
        super.onCleared();
        unregister();
        this.localeComponent.removeListener(this);
        Timber.INSTANCE.d("-----销毁onCleared", new Object[0]);
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.fragment.clock.ClockViewModel$changeClock$2, reason: invalid class name */
    /* JADX INFO: compiled from: ClockViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.ui.fragment.clock.ClockViewModel$changeClock$2", f = "ClockViewModel.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Clock $clock;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Clock clock, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$clock = clock;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClockViewModel.this.new AnonymousClass2(this.$clock, continuation);
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
                if (ClockViewModel.this.repository.isNeedChangeToDynamicClock(this.$clock)) {
                    this.label = 1;
                    obj = ClockViewModel.this.repository.switchToTargetDynamicClock(this.$clock, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Clock clock = (Clock) obj;
            if (clock != null) {
                ClockViewModel clockViewModel = ClockViewModel.this;
                Timber.INSTANCE.d(" 切换配置target: " + clock.getConfig().getChange_starttime() + " endTime: " + clock.getConfig().getChange_endtime(), new Object[0]);
                clockViewModel.getClockUpdate().postValue(clock);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object changeClock(Clock clock, Continuation<? super Unit> continuation) throws Throwable {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(clock, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.fragment.clock.ClockViewModel$loadClock$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ClockViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/dw/launcher/data/entity/Clock;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.ui.fragment.clock.ClockViewModel$loadClock$2", f = "ClockViewModel.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    static final class C00162 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Clock>>, Object> {
        int label;

        C00162(Continuation<? super C00162> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClockViewModel.this.new C00162(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Clock>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<Clock>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Clock>> continuation) {
            return ((C00162) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ClockViewModel.this.repository.getClockList(0, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadClock(Continuation<? super List<Clock>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00162(null), continuation);
    }

    public final void register() {
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
        }
        this.mReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.ui.fragment.clock.ClockViewModel.register.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                List<Clock> list = (List) ClockViewModel.this._clockList.getValue();
                if (list != null) {
                    ClockViewModel clockViewModel = ClockViewModel.this;
                    for (Clock clock : list) {
                        if (Intrinsics.areEqual(clock.getConfig().getId(), clockViewModel.preference.getPreferClock()) && clock.getConfig().supportDynamicChange()) {
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ClockViewModel$register$2$onReceive$1$1(clockViewModel, clock, null), 3, null);
                        }
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        this.context.registerReceiver(this.mReceiver, intentFilter);
    }

    public final void unregister() {
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
            this.mReceiver = null;
        }
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.fragment.clock.ClockViewModel$onLocaleChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ClockViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.ui.fragment.clock.ClockViewModel$onLocaleChanged$1", f = "ClockViewModel.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
    static final class C00171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00171(Continuation<? super C00171> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClockViewModel.this.new C00171(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ClockViewModel.this.loadClock(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ClockViewModel.this._clockList.setValue((List) obj);
            return Unit.INSTANCE;
        }
    }

    public void onLocaleChanged(boolean changed) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new C00171(null), 3, null);
    }
}
