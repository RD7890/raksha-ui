package com.dw.launcher.core.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.database.dao.StepDataDao;
import com.dw.launcher.data.entity.StepCountData;
import dagger.hilt.android.AndroidEntryPoint;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

/* JADX INFO: compiled from: StepSensorService.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\r\b\u0007\u0018\u00002\u00020\u0001:\u0002/0B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0019\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u001cH\u0016J\b\u0010)\u001a\u00020\u001cH\u0016J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u0004H\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\b\u0010-\u001a\u00020\u001cH\u0002J\b\u0010.\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0018\u00010\u001aR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/dw/launcher/core/service/StepSensorService;", "Landroid/app/Service;", "()V", "currentStep", BuildConfig.FLAVOR, "handler", "Landroid/os/Handler;", "mListener", "Lcom/dw/launcher/core/service/StepSensorService$MySensorEventListener;", "mSensorManager", "Landroid/hardware/SensorManager;", "mStepCounter", "midnightReceiver", "com/dw/launcher/core/service/StepSensorService$midnightReceiver$1", "Lcom/dw/launcher/core/service/StepSensorService$midnightReceiver$1;", "stepCountDatas", "Lcom/dw/launcher/data/entity/StepCountData;", "stepDataDao", "Lcom/dw/launcher/data/database/dao/StepDataDao;", "getStepDataDao", "()Lcom/dw/launcher/data/database/dao/StepDataDao;", "setStepDataDao", "(Lcom/dw/launcher/data/database/dao/StepDataDao;)V", "stepRunnable", "Ljava/lang/Runnable;", "wakeAndLockReceiver", "Lcom/dw/launcher/core/service/StepSensorService$WakeAndLockReceiver;", "initStep", BuildConfig.FLAVOR, "insertStepCountData", "stepCountData", "(Lcom/dw/launcher/data/entity/StepCountData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isMidnight", BuildConfig.FLAVOR, "timestamp", BuildConfig.FLAVOR, "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStepUpdate", "dts", "register", "startSensor", "stopSensor", "MySensorEventListener", "WakeAndLockReceiver", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class StepSensorService extends Hilt_StepSensorService {
    private int currentStep;
    private MySensorEventListener mListener;
    private SensorManager mSensorManager;
    private int mStepCounter;
    private StepCountData stepCountDatas;

    @Inject
    public StepDataDao stepDataDao;
    private WakeAndLockReceiver wakeAndLockReceiver;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable stepRunnable = new Runnable() { // from class: com.dw.launcher.core.service.StepSensorService$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            StepSensorService.stepRunnable$lambda$0(this.f$0);
        }
    };
    private final StepSensorService$midnightReceiver$1 midnightReceiver = new BroadcastReceiver() { // from class: com.dw.launcher.core.service.StepSensorService$midnightReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual("android.intent.action.TIME_TICK", intent.getAction())) {
                if (this.this$0.isMidnight(System.currentTimeMillis())) {
                    this.this$0.stepCountDatas = null;
                    this.this$0.onStepUpdate(0);
                    Settings.Global.putInt(this.this$0.getContentResolver(), "last_step_value", 0);
                }
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
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

    @Override // com.dw.launcher.core.service.Hilt_StepSensorService, android.app.Service
    public void onCreate() {
        super.onCreate();
        register();
        startSensor();
        registerReceiver(this.midnightReceiver, new IntentFilter("android.intent.action.TIME_TICK"));
    }

    private final void register() {
        this.wakeAndLockReceiver = new WakeAndLockReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.wakeAndLockReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startSensor() {
        if (this.mSensorManager == null) {
            Object systemService = getSystemService("sensor");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
            this.mSensorManager = (SensorManager) systemService;
            this.mListener = new MySensorEventListener();
        }
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH), new Date(), null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.dw.launcher.core.service.StepSensorService$startSensor$1, reason: invalid class name */
    /* JADX INFO: compiled from: StepSensorService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.core.service.StepSensorService$startSensor$1", f = "StepSensorService.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SimpleDateFormat $dateFormat;
        final /* synthetic */ Date $now;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SimpleDateFormat simpleDateFormat, Date date, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$dateFormat = simpleDateFormat;
            this.$now = date;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StepSensorService.this.new AnonymousClass1(this.$dateFormat, this.$now, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Unit unit;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getIO(), new C00131(StepSensorService.this, this.$dateFormat, this.$now, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                StepCountData stepCountData = StepSensorService.this.stepCountDatas;
                if (stepCountData != null) {
                    StepSensorService.this.currentStep = stepCountData.getStep();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    StepSensorService.this.onStepUpdate(0);
                }
            } catch (Exception unused) {
            }
            SensorManager sensorManager = StepSensorService.this.mSensorManager;
            if (sensorManager != null) {
                MySensorEventListener mySensorEventListener = StepSensorService.this.mListener;
                SensorManager sensorManager2 = StepSensorService.this.mSensorManager;
                Boxing.boxBoolean(sensorManager.registerListener(mySensorEventListener, sensorManager2 != null ? sensorManager2.getDefaultSensor(19) : null, 3));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.dw.launcher.core.service.StepSensorService$startSensor$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StepSensorService.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dw.launcher.core.service.StepSensorService$startSensor$1$1", f = "StepSensorService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ SimpleDateFormat $dateFormat;
            final /* synthetic */ Date $now;
            int label;
            final /* synthetic */ StepSensorService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00131(StepSensorService stepSensorService, SimpleDateFormat simpleDateFormat, Date date, Continuation<? super C00131> continuation) {
                super(2, continuation);
                this.this$0 = stepSensorService;
                this.$dateFormat = simpleDateFormat;
                this.$now = date;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00131(this.this$0, this.$dateFormat, this.$now, continuation);
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
                StepSensorService stepSensorService = this.this$0;
                StepDataDao stepDataDao = stepSensorService.getStepDataDao();
                String str = this.$dateFormat.format(this.$now);
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                stepSensorService.stepCountDatas = stepDataDao.queryStepByDate(str);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopSensor() {
        try {
            SensorManager sensorManager = this.mSensorManager;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.mListener);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: StepSensorService.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/dw/launcher/core/service/StepSensorService$WakeAndLockReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/dw/launcher/core/service/StepSensorService;)V", "onReceive", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class WakeAndLockReceiver extends BroadcastReceiver {
        public WakeAndLockReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            String action = intent.getAction();
            if (Intrinsics.areEqual("android.intent.action.SCREEN_ON", action)) {
                StepSensorService.this.startSensor();
            } else if (Intrinsics.areEqual("android.intent.action.SCREEN_OFF", action)) {
                StepSensorService.this.stopSensor();
            }
        }
    }

    /* JADX INFO: compiled from: StepSensorService.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/dw/launcher/core/service/StepSensorService$MySensorEventListener;", "Landroid/hardware/SensorEventListener;", "(Lcom/dw/launcher/core/service/StepSensorService;)V", "onAccuracyChanged", BuildConfig.FLAVOR, "sensor", "Landroid/hardware/Sensor;", "accuracy", BuildConfig.FLAVOR, "onSensorChanged", NotificationCompat.CATEGORY_EVENT, "Landroid/hardware/SensorEvent;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class MySensorEventListener implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            Intrinsics.checkNotNullParameter(sensor, "sensor");
        }

        public MySensorEventListener() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent event) {
            Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
            if (event.sensor.getType() == 19) {
                StepSensorService.this.mStepCounter = (int) event.values[0];
                Timber.Forest.d("Sensor.TYPE_STEP_COUNTER mStepCounter: " + StepSensorService.this.mStepCounter + " stepCountDatas ", new Object[0]);
                StepCountData stepCountData = StepSensorService.this.stepCountDatas;
                if (stepCountData != null) {
                    StepSensorService stepSensorService = StepSensorService.this;
                    int step = stepCountData.getStep();
                    if (stepCountData.getInitStep() > stepSensorService.mStepCounter) {
                        stepCountData.setInitStep(stepSensorService.mStepCounter);
                    }
                    stepCountData.setStep((step + stepSensorService.mStepCounter) - stepCountData.getInitStep());
                    stepCountData.setInitStep(stepSensorService.mStepCounter);
                    BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new StepSensorService$MySensorEventListener$onSensorChanged$1$1(stepSensorService, stepCountData, null), 3, (Object) null);
                    stepSensorService.onStepUpdate(stepCountData.getStep());
                    Integer.valueOf(Log.d("lkang", "onSensorChanged: " + stepCountData.getStep()));
                } else {
                    StepSensorService stepSensorService2 = StepSensorService.this;
                    StepCountData stepCountData2 = new StepCountData();
                    stepCountData2.setDate(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));
                    stepCountData2.setInitStep(stepSensorService2.mStepCounter);
                    stepCountData2.setStep(0);
                    stepSensorService2.onStepUpdate(0);
                    stepSensorService2.stepCountDatas = stepCountData2;
                    BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new StepSensorService$MySensorEventListener$onSensorChanged$2$1(stepSensorService2, stepCountData2, null), 3, (Object) null);
                }
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("Device detected a total of " + StepSensorService.this.mStepCounter + " steps since boot", Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            Log.i("lkang", str);
        }
    }

    /* JADX INFO: renamed from: com.dw.launcher.core.service.StepSensorService$insertStepCountData$2, reason: invalid class name */
    /* JADX INFO: compiled from: StepSensorService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.core.service.StepSensorService$insertStepCountData$2", f = "StepSensorService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
        final /* synthetic */ StepCountData $stepCountData;
        int label;
        final /* synthetic */ StepSensorService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(StepCountData stepCountData, StepSensorService stepSensorService, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$stepCountData = stepCountData;
            this.this$0 = stepSensorService;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$stepCountData, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Timber.Forest.d("insertStepCountData: " + this.$stepCountData, new Object[0]);
            return Boxing.boxLong(this.this$0.getStepDataDao().insert(this.$stepCountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object insertStepCountData(StepCountData stepCountData, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(stepCountData, this, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStepUpdate(int dts) {
        this.currentStep = dts;
        this.handler.removeCallbacks(this.stepRunnable);
        this.handler.postDelayed(this.stepRunnable, 1000L);
        Log.d("lkang", "onStepUpdate: " + dts);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stepRunnable$lambda$0(StepSensorService stepSensorService) {
        Intrinsics.checkNotNullParameter(stepSensorService, "this$0");
        Settings.Global.putInt(stepSensorService.getContentResolver(), "last_step_value", stepSensorService.currentStep);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            stopSensor();
            unregisterReceiver(this.wakeAndLockReceiver);
            unregisterReceiver(this.midnightReceiver);
            this.handler.removeCallbacks(this.stepRunnable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMidnight(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        return calendar.get(11) == 0 && calendar.get(12) == 0;
    }

    private final void initStep() {
        StepCountData stepCountData = new StepCountData();
        stepCountData.setDate(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));
        stepCountData.setInitStep(this.mStepCounter);
        stepCountData.setStep(0);
        onStepUpdate(0);
        this.stepCountDatas = stepCountData;
    }
}
