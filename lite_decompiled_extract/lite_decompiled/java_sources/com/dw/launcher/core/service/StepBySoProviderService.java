package com.dw.launcher.core.service;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.android.internal.telephony.RadioNVItems;
import com.dw.launcher.data.database.dao.StepDataDao;
import com.dw.launcher.data.entity.StepCountData;
import com.smart.cc.stepcounter.PEDOMETERALG;
import dagger.hilt.android.AndroidEntryPoint;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

/* JADX INFO: compiled from: StepBySoProviderService.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0002\f\u000f\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u001fH\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u001dH\u0016J\b\u0010+\u001a\u00020\u001dH\u0016J\u0019\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020\u001dJ\u0010\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lcom/dw/launcher/core/service/StepBySoProviderService;", "Landroid/app/Service;", "()V", "mContext", "Landroid/content/Context;", "mFd", BuildConfig.FLAVOR, "mHandler", "Landroid/os/Handler;", "mInited", BuildConfig.FLAVOR, "mScreenOnOrOffReceiver", "com/dw/launcher/core/service/StepBySoProviderService$mScreenOnOrOffReceiver$1", "Lcom/dw/launcher/core/service/StepBySoProviderService$mScreenOnOrOffReceiver$1;", "mStepTask", "com/dw/launcher/core/service/StepBySoProviderService$mStepTask$1", "Lcom/dw/launcher/core/service/StepBySoProviderService$mStepTask$1;", "powerManager", "Landroid/os/PowerManager;", "prevStep", "stepCountData", "Lcom/dw/launcher/data/entity/StepCountData;", "stepDataDao", "Lcom/dw/launcher/data/database/dao/StepDataDao;", "getStepDataDao", "()Lcom/dw/launcher/data/database/dao/StepDataDao;", "setStepDataDao", "(Lcom/dw/launcher/data/database/dao/StepDataDao;)V", "fresh", BuildConfig.FLAVOR, "delay", BuildConfig.FLAVOR, "freshSteps", "getStrDate", BuildConfig.FLAVOR, "initScreenOnOffReceiver", "isMidnight", "timestamp", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "start", "context", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "updateSteps", "add", "Companion", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class StepBySoProviderService extends Hilt_StepBySoProviderService {
    private static final long DELAY_SCREEN_OFF = 5000;
    private static final long DELAY_SCREEN_ON = 200;
    private static final String KEY_STEPCOUNT = "key_walk_count-";
    public static final String TAG = "StepUtil";
    private Context mContext;
    private int mFd;
    private boolean mInited;
    private PowerManager powerManager;
    private int prevStep;
    private StepCountData stepCountData;

    @Inject
    public StepDataDao stepDataDao;
    private final Handler mHandler = new Handler();
    private final StepBySoProviderService$mStepTask$1 mStepTask = new Runnable() { // from class: com.dw.launcher.core.service.StepBySoProviderService$mStepTask$1
        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.mFd > 0) {
                this.this$0.freshSteps();
                this.this$0.fresh(2000L);
            } else {
                Log.w(StepBySoProviderService.TAG, "step task interrupt: " + this.this$0.mFd);
            }
        }
    };
    private final StepBySoProviderService$mScreenOnOrOffReceiver$1 mScreenOnOrOffReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.core.service.StepBySoProviderService$mScreenOnOrOffReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            String action = intent.getAction();
            if (action != null) {
                int iHashCode = action.hashCode();
                if (iHashCode == -2128145023) {
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        this.this$0.fresh(5000L);
                        return;
                    }
                    return;
                }
                if (iHashCode != -1513032534) {
                    if (iHashCode == -1454123155 && action.equals("android.intent.action.SCREEN_ON")) {
                        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new StepBySoProviderService$mScreenOnOrOffReceiver$1$onReceive$1(this.this$0, null), 3, (Object) null);
                        return;
                    }
                    return;
                }
                if (action.equals("android.intent.action.TIME_TICK")) {
                    if (this.this$0.isMidnight(System.currentTimeMillis())) {
                        PEDOMETERALG.clearGsensorSteps();
                        this.this$0.stepCountData = null;
                        this.this$0.prevStep = 0;
                        this.this$0.updateSteps(0);
                    }
                }
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initScreenOnOffReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        context.registerReceiver(this.mScreenOnOrOffReceiver, intentFilter);
    }

    public final StepDataDao getStepDataDao() {
        StepDataDao stepDataDao = this.stepDataDao;
        if (stepDataDao != null) {
            return stepDataDao;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stepDataDao");
        return null;
    }

    public final void setStepDataDao(StepDataDao stepDataDao) {
        Intrinsics.checkNotNullParameter(stepDataDao, "<set-?>");
        this.stepDataDao = stepDataDao;
    }

    @Override // com.dw.launcher.core.service.Hilt_StepBySoProviderService, android.app.Service
    public void onCreate() {
        super.onCreate();
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.dw.launcher.core.service.StepBySoProviderService$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: StepBySoProviderService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.core.service.StepBySoProviderService$onCreate$1", f = "StepBySoProviderService.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StepBySoProviderService.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StepBySoProviderService stepBySoProviderService = StepBySoProviderService.this;
                Context applicationContext = stepBySoProviderService.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                this.label = 1;
                if (stepBySoProviderService.start(applicationContext, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.dw.launcher.core.service.StepBySoProviderService$start$2, reason: invalid class name */
    /* JADX INFO: compiled from: StepBySoProviderService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.core.service.StepBySoProviderService$start$2", f = "StepBySoProviderService.kt", i = {}, l = {RadioNVItems.RIL_NV_LTE_NEXT_SCAN}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StepBySoProviderService.this.new AnonymousClass2(this.$context, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!StepBySoProviderService.this.mInited) {
                    StepBySoProviderService stepBySoProviderService = StepBySoProviderService.this;
                    stepBySoProviderService.stepCountData = stepBySoProviderService.getStepDataDao().queryStepByDate(StepBySoProviderService.this.getStrDate());
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(StepBySoProviderService.this, this.$context, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.dw.launcher.core.service.StepBySoProviderService$start$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StepBySoProviderService.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dw.launcher.core.service.StepBySoProviderService$start$2$1", f = "StepBySoProviderService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            int label;
            final /* synthetic */ StepBySoProviderService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(StepBySoProviderService stepBySoProviderService, Context context, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = stepBySoProviderService;
                this.$context = context;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$context, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Timber.Forest.d(" 初始化 完成 " + Thread.currentThread().getName(), new Object[0]);
                this.this$0.mContext = this.$context;
                StepBySoProviderService stepBySoProviderService = this.this$0;
                Object systemService = this.$context.getSystemService("power");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                stepBySoProviderService.powerManager = (PowerManager) systemService;
                this.this$0.mFd = PEDOMETERALG.gsensorOpen();
                if (this.this$0.mFd <= 0) {
                    Log.w(StepBySoProviderService.TAG, "Step init fail: " + this.this$0.mFd);
                } else {
                    this.this$0.prevStep = PEDOMETERALG.getGsensorSteps();
                    if (this.this$0.prevStep >= 65535) {
                        PEDOMETERALG.clearGsensorSteps();
                        this.this$0.prevStep = PEDOMETERALG.getGsensorSteps();
                    }
                }
                this.this$0.fresh(StepBySoProviderService.DELAY_SCREEN_ON);
                this.this$0.initScreenOnOffReceiver();
                this.this$0.mInited = true;
                return Unit.INSTANCE;
            }
        }
    }

    public final Object start(Context context, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(context, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void stop() {
        if (this.mInited) {
            PEDOMETERALG.gsensorClose();
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            context.unregisterReceiver(this.mScreenOnOrOffReceiver);
            this.mInited = false;
            this.mHandler.removeCallbacks(this.mStepTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fresh(long delay) {
        PowerManager powerManager = this.powerManager;
        if (powerManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("powerManager");
            powerManager = null;
        }
        if (powerManager.isScreenOn()) {
            this.mHandler.removeCallbacks(this.mStepTask);
            this.mHandler.postDelayed(this.mStepTask, delay);
        } else {
            this.mHandler.removeCallbacks(this.mStepTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void freshSteps() {
        if (this.mFd <= 0) {
            return;
        }
        int gsensorSteps = PEDOMETERALG.getGsensorSteps();
        int i = this.prevStep;
        int i2 = gsensorSteps - i;
        if (gsensorSteps >= 0 && gsensorSteps < 100 && gsensorSteps < i) {
            i2 = gsensorSteps + i;
        }
        if (i2 < 0) {
            i2 += 65535;
        }
        if (1 <= i2 && i2 < 3000) {
            updateSteps(i2);
        }
        this.prevStep = gsensorSteps;
        if (gsensorSteps >= 65535) {
            PEDOMETERALG.clearGsensorSteps();
            this.prevStep = PEDOMETERALG.getGsensorSteps();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSteps(int add) {
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new C00301(getStrDate(), add, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.dw.launcher.core.service.StepBySoProviderService$updateSteps$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StepBySoProviderService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.core.service.StepBySoProviderService$updateSteps$1", f = "StepBySoProviderService.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
    static final class C00301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $add;
        final /* synthetic */ String $currDate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00301(String str, int i, Continuation<? super C00301> continuation) {
            super(2, continuation);
            this.$currDate = str;
            this.$add = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StepBySoProviderService.this.new C00301(this.$currDate, this.$add, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.dw.launcher.core.service.StepBySoProviderService$updateSteps$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StepBySoProviderService.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dw.launcher.core.service.StepBySoProviderService$updateSteps$1$1", f = "StepBySoProviderService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
            final /* synthetic */ int $add;
            final /* synthetic */ String $currDate;
            int label;
            final /* synthetic */ StepBySoProviderService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00121(StepBySoProviderService stepBySoProviderService, String str, int i, Continuation<? super C00121> continuation) {
                super(2, continuation);
                this.this$0 = stepBySoProviderService;
                this.$currDate = str;
                this.$add = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00121(this.this$0, this.$currDate, this.$add, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                long jInsert;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    StepCountData stepCountData = this.this$0.stepCountData;
                    if (stepCountData != null) {
                        String str = this.$currDate;
                        int i = this.$add;
                        StepBySoProviderService stepBySoProviderService = this.this$0;
                        if (!Intrinsics.areEqual(stepCountData.getDate(), str)) {
                            stepCountData.setInitStep(0);
                            stepCountData.setStep(0);
                            stepCountData.setDate(str);
                        }
                        stepCountData.setStep(stepCountData.getStep() + i);
                        stepCountData.setDate(str);
                        stepCountData.setInitStep(0);
                        jInsert = stepBySoProviderService.getStepDataDao().insert(stepCountData);
                    } else {
                        StepBySoProviderService stepBySoProviderService2 = this.this$0;
                        String str2 = this.$currDate;
                        stepBySoProviderService2.stepCountData = new StepCountData();
                        StepCountData stepCountData2 = stepBySoProviderService2.stepCountData;
                        if (stepCountData2 != null) {
                            stepCountData2.setDate(str2);
                        }
                        StepCountData stepCountData3 = stepBySoProviderService2.stepCountData;
                        if (stepCountData3 != null) {
                            stepCountData3.setInitStep(0);
                        }
                        StepCountData stepCountData4 = stepBySoProviderService2.stepCountData;
                        if (stepCountData4 != null) {
                            stepCountData4.setStep(0);
                        }
                        StepDataDao stepDataDao = stepBySoProviderService2.getStepDataDao();
                        StepCountData stepCountData5 = stepBySoProviderService2.stepCountData;
                        Intrinsics.checkNotNull(stepCountData5);
                        jInsert = stepDataDao.insert(stepCountData5);
                    }
                    return Boxing.boxLong(jInsert);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            Context context = null;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new C00121(StepBySoProviderService.this, this.$currDate, this.$add, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Context context2 = StepBySoProviderService.this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context2;
            }
            ContentResolver contentResolver = context.getContentResolver();
            StepCountData stepCountData = StepBySoProviderService.this.stepCountData;
            Intrinsics.checkNotNull(stepCountData);
            Settings.Global.putInt(contentResolver, "last_step_value", stepCountData.getStep());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getStrDate() {
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMidnight(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        return calendar.get(11) == 0 && calendar.get(12) == 0;
    }
}
