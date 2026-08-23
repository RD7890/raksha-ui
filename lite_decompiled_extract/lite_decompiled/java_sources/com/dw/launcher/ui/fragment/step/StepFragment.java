package com.dw.launcher.ui.fragment.step;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.databinding.ViewDataBinding;
import com.android.launcher3.util.StepManager;
import com.dw.launcher.R;
import com.dw.launcher.data.database.dao.StepDataDao;
import com.dw.launcher.data.entity.StepCountData;
import com.dw.launcher.databinding.FragmentStepBinding;
import com.dw.launcher.ui.viewmodel.StepViewModel;
import com.dwiot.dwstep.util.Utils;
import com.dwiot.dwstep.view.ArcProgressView;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

/* JADX INFO: compiled from: StepFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\u001bH\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\u001a\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020(H\u0002R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lcom/dw/launcher/ui/fragment/step/StepFragment;", "Lcom/dw/launcher/base/mvvm/VMBaseFragment;", "Lcom/dw/launcher/ui/viewmodel/StepViewModel;", "Lcom/dw/launcher/databinding/FragmentStepBinding;", "()V", "binding", "getBinding", "()Lcom/dw/launcher/databinding/FragmentStepBinding;", "setBinding", "(Lcom/dw/launcher/databinding/FragmentStepBinding;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "runnable", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "stepDataDao", "Lcom/dw/launcher/data/database/dao/StepDataDao;", "getStepDataDao", "()Lcom/dw/launcher/data/database/dao/StepDataDao;", "setStepDataDao", "(Lcom/dw/launcher/data/database/dao/StepDataDao;)V", "getLayoutId", "", "initData", "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onDestroy", "onDetach", "onPause", "onResume", "updateStep", "step", "isFirstLoad", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class StepFragment extends Hilt_StepFragment<StepViewModel, FragmentStepBinding> {
    public FragmentStepBinding binding;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable runnable = new Runnable() { // from class: com.dw.launcher.ui.fragment.step.StepFragment$runnable$1
        @Override // java.lang.Runnable
        public void run() {
            StepFragment stepFragment = this.this$0;
            StepManager stepManager = StepManager.INSTANCE;
            Context contextRequireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            StepFragment.updateStep$default(stepFragment, stepManager.getStep(contextRequireContext), false, 2, null);
            this.this$0.getHandler().postDelayed(this, 2000L);
        }
    };

    @Inject
    public StepDataDao stepDataDao;

    public final FragmentStepBinding getBinding() {
        FragmentStepBinding fragmentStepBinding = this.binding;
        if (fragmentStepBinding != null) {
            return fragmentStepBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentStepBinding fragmentStepBinding) {
        Intrinsics.checkNotNullParameter(fragmentStepBinding, "<set-?>");
        this.binding = fragmentStepBinding;
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

    public final Handler getHandler() {
        return this.handler;
    }

    public int getLayoutId() {
        return R.layout.fragment_step;
    }

    public final Runnable getRunnable() {
        return this.runnable;
    }

    public void initData(Bundle savedInstanceState) {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "getBinding(...)");
        setBinding((FragmentStepBinding) binding);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()), null), 3, null);
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.fragment.step.StepFragment$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: StepFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.ui.fragment.step.StepFragment$initData$1", f = "StepFragment.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $date;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$date = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StepFragment.this.new AnonymousClass1(this.$date, continuation);
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
                obj = BuildersKt.withContext(Dispatchers.getIO(), new StepFragment$initData$1$stepdata$1(StepFragment.this, this.$date, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            StepCountData stepCountData = (StepCountData) obj;
            if (stepCountData != null) {
                StepFragment.this.updateStep(stepCountData.getStep(), true);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.dw.launcher.ui.fragment.step.Hilt_StepFragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onResume() {
        super.onResume();
        this.handler.post(this.runnable);
        Timber.INSTANCE.d("onResume", new Object[0]);
        getBinding().parent.activeProgressCircle.startAnimateProgress();
    }

    public void onPause() {
        super.onPause();
        this.handler.removeCallbacks(this.runnable);
        Timber.INSTANCE.d("onPause", new Object[0]);
    }

    static /* synthetic */ void updateStep$default(StepFragment stepFragment, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        stepFragment.updateStep(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStep(int step, boolean isFirstLoad) {
        float fCoerceIn = RangesKt.coerceIn((step * ArcProgressView.INSTANCE.getStep_max_angle()) / 10000.0f, 0.0f, ArcProgressView.INSTANCE.getStep_max_angle());
        float fMakeKm = Utils.INSTANCE.makeKm(step, 140, 63.0f);
        float fCoerceIn2 = RangesKt.coerceIn(((CharacterSets.UCS2 * fMakeKm) * ArcProgressView.INSTANCE.getStep_max_angle()) / 5000, 0.0f, ArcProgressView.INSTANCE.getDistance_max_angle());
        float fMakeKcal = Utils.INSTANCE.makeKcal(fMakeKm, 33.0f);
        float fCoerceIn3 = RangesKt.coerceIn((ArcProgressView.INSTANCE.getStep_max_angle() * fMakeKcal) / 300, 0.0f, ArcProgressView.INSTANCE.getCalories_max_angle());
        getBinding().parent.activeProgressCircle.setStep_value(String.valueOf(step));
        getBinding().parent.activeProgressCircle.setCalories_value(String.valueOf((int) fMakeKcal));
        ArcProgressView arcProgressView = getBinding().parent.activeProgressCircle;
        String strKeepTwoDecimalStringNoRound = Utils.INSTANCE.keepTwoDecimalStringNoRound(fMakeKm);
        Intrinsics.checkNotNull(strKeepTwoDecimalStringNoRound);
        arcProgressView.setDistance_value(strKeepTwoDecimalStringNoRound);
        getBinding().parent.activeProgressCircle.setCalories_current_angle(fCoerceIn3);
        getBinding().parent.activeProgressCircle.setDistance_current_angle(fCoerceIn2);
        getBinding().parent.activeProgressCircle.setStep_current_angle(fCoerceIn);
        if (isFirstLoad) {
            return;
        }
        getBinding().parent.activeProgressCircle.invalidate();
    }

    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacks(this.runnable);
    }
}
