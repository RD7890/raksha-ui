package com.dw.launcher.ui.fragment.bloodpress;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.dw.bloodpressure.R;
import com.dw.bloodpressure.databinding.FragmentBloodpressureNewBinding;
import com.dw.launcher.base.mvvm.VMBaseFragment;
import com.dw.launcher.data.entity.TodayBloodPressureList;
import com.dw.launcher.data.entity.TodayDataList;
import com.dw.launcher.data.listener.HealthMeausureListener;
import com.dw.launcher.manager.BloodPressureManager;
import com.dw.launcher.ui.viewmodel.BPressureViewModel;
import com.google.android.mms.pdu.CharacterSets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BloodPressureFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J6\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060#2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010#2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010#H\u0002J\b\u0010&\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/dw/launcher/ui/fragment/bloodpress/BloodPressureFragment;", "Lcom/dw/launcher/base/mvvm/VMBaseFragment;", "Lcom/dw/launcher/ui/viewmodel/BPressureViewModel;", "Lcom/dw/bloodpressure/databinding/FragmentBloodpressureNewBinding;", "()V", "DeFault_Port", "", "Device_bd1688_Port", "anim", "Landroid/graphics/drawable/AnimationDrawable;", "binding", "getBinding", "()Lcom/dw/bloodpressure/databinding/FragmentBloodpressureNewBinding;", "setBinding", "(Lcom/dw/bloodpressure/databinding/FragmentBloodpressureNewBinding;)V", "mSensor", "Landroid/hardware/Sensor;", "getMSensor", "()Landroid/hardware/Sensor;", "setMSensor", "(Landroid/hardware/Sensor;)V", "mSensorManager", "Landroid/hardware/SensorManager;", "wrist_status", "Landroid/widget/RelativeLayout;", "getLayoutId", "initData", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "showChart", "posIndexList", "", "sysList", "diaList", "start", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class BloodPressureFragment extends VMBaseFragment<BPressureViewModel, FragmentBloodpressureNewBinding> {
    private final int DeFault_Port = 65598;
    private final int Device_bd1688_Port = 65599;
    private AnimationDrawable anim;
    public FragmentBloodpressureNewBinding binding;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private RelativeLayout wrist_status;

    public final FragmentBloodpressureNewBinding getBinding() {
        FragmentBloodpressureNewBinding fragmentBloodpressureNewBinding = this.binding;
        if (fragmentBloodpressureNewBinding != null) {
            return fragmentBloodpressureNewBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentBloodpressureNewBinding fragmentBloodpressureNewBinding) {
        Intrinsics.checkNotNullParameter(fragmentBloodpressureNewBinding, "<set-?>");
        this.binding = fragmentBloodpressureNewBinding;
    }

    public final Sensor getMSensor() {
        return this.mSensor;
    }

    public final void setMSensor(Sensor sensor) {
        this.mSensor = sensor;
    }

    public void initData(Bundle savedInstanceState) {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "getBinding(...)");
        setBinding((FragmentBloodpressureNewBinding) binding);
        this.wrist_status = getBinding().wristStatus;
        this.anim = (AnimationDrawable) ContextCompat.getDrawable(requireContext(), R.drawable.bloodpressure_measureing);
        getBinding().ivAnim.setBackground(this.anim);
        Object systemService = requireContext().getSystemService("sensor");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        SensorManager sensorManager = (SensorManager) systemService;
        this.mSensorManager = sensorManager;
        this.mSensor = sensorManager != null ? sensorManager.getDefaultSensor(this.DeFault_Port) : null;
    }

    public int getLayoutId() {
        return R.layout.fragment_bloodpressure_new;
    }

    public void onResume() {
        TodayBloodPressureList fromCache;
        super.onResume();
        BloodPressureManager companion = BloodPressureManager.Companion.getInstance();
        if (companion != null) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            fromCache = companion.readFromCache(contextRequireContext);
        } else {
            fromCache = null;
        }
        Intrinsics.checkNotNull(fromCache);
        List<Integer> indexList = fromCache.getIndexList();
        Intrinsics.checkNotNullExpressionValue(indexList, "getIndexList(...)");
        showChart(indexList, fromCache.getValueList(), fromCache.diaList);
        getBinding().bloodPressChart.startAnimate2();
        start();
    }

    private final void start() {
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        Settings.Global.putInt(context.getContentResolver(), "health_measure_status", 0);
        BloodPressureManager companion = BloodPressureManager.Companion.getInstance();
        if (companion != null) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            companion.start(contextRequireContext, true, new HealthMeausureListener() { // from class: com.dw.launcher.ui.fragment.bloodpress.BloodPressureFragment.start.1
                public void onHealthMeausure(int sysBloodPress, int diaBloodPress) {
                    BloodPressureFragment.this.getBinding().txtHeartLow.setText(diaBloodPress + "");
                    BloodPressureFragment.this.getBinding().txtHeartHigh.setText(sysBloodPress + "");
                }

                public void onstart() {
                    BloodPressureFragment.this.getBinding().txtHeartLow.setText("--");
                    BloodPressureFragment.this.getBinding().txtHeartHigh.setText("--");
                    AnimationDrawable animationDrawable = BloodPressureFragment.this.anim;
                    if (animationDrawable != null) {
                        animationDrawable.start();
                    }
                    BloodPressureFragment.this.getBinding().txtStatus.setText(BloodPressureFragment.this.getString(com.dw.launcher.R.string.measuring));
                }

                public void onstop() {
                    AnimationDrawable animationDrawable = BloodPressureFragment.this.anim;
                    if (animationDrawable != null) {
                        animationDrawable.stop();
                    }
                    BloodPressureFragment.this.getBinding().txtStatus.setText(BloodPressureFragment.this.getString(com.dw.launcher.R.string.not_measure));
                }

                public void onFinish(TodayDataList todayDataList) {
                    Intrinsics.checkNotNullParameter(todayDataList, "todayDataList");
                    AnimationDrawable animationDrawable = BloodPressureFragment.this.anim;
                    if (animationDrawable != null) {
                        animationDrawable.stop();
                    }
                    if (todayDataList instanceof TodayBloodPressureList) {
                        BloodPressureFragment bloodPressureFragment = BloodPressureFragment.this;
                        TodayBloodPressureList todayBloodPressureList = (TodayBloodPressureList) todayDataList;
                        List indexList = todayBloodPressureList.getIndexList();
                        Intrinsics.checkNotNullExpressionValue(indexList, "getIndexList(...)");
                        bloodPressureFragment.showChart(indexList, todayBloodPressureList.getValueList(), todayBloodPressureList.diaList);
                        BloodPressureFragment.this.getBinding().txtStatus.setText(new SimpleDateFormat("MM/dd HH:mm").format(new Date(System.currentTimeMillis())));
                    }
                }

                public void onError(int status) {
                    if (status != 1) {
                        RelativeLayout relativeLayout = BloodPressureFragment.this.wrist_status;
                        Intrinsics.checkNotNull(relativeLayout);
                        relativeLayout.setVisibility(8);
                        return;
                    }
                    BloodPressureFragment.this.getBinding().txtStatus.setText(BloodPressureFragment.this.getString(com.dw.launcher.R.string.not_touch));
                    AnimationDrawable animationDrawable = BloodPressureFragment.this.anim;
                    if (animationDrawable != null) {
                        animationDrawable.stop();
                    }
                    RelativeLayout relativeLayout2 = BloodPressureFragment.this.wrist_status;
                    Intrinsics.checkNotNull(relativeLayout2);
                    relativeLayout2.setVisibility(0);
                }
            });
        }
        RelativeLayout relativeLayout = this.wrist_status;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setVisibility(8);
    }

    public void onPause() {
        Window window;
        super.onPause();
        BloodPressureManager companion = BloodPressureManager.Companion.getInstance();
        if (companion != null) {
            companion.stop();
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.clearFlags(128);
        }
        getBinding().txtStatus.setText(getString(com.dw.launcher.R.string.not_measure));
        AnimationDrawable animationDrawable = this.anim;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        RelativeLayout relativeLayout = this.wrist_status;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setVisibility(8);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showChart(List<Integer> posIndexList, List<Integer> sysList, List<Integer> diaList) {
        getBinding().bloodPressChart.setDailyList(sysList, diaList, posIndexList);
        int iIntValue = 0;
        if (sysList != null && (!sysList.isEmpty())) {
            Iterator<Integer> it = sysList.iterator();
            int iIntValue2 = 0;
            while (it.hasNext()) {
                iIntValue2 += it.next().intValue();
            }
            getBinding().txtAvgOxygenHigh.setText(Integer.toString(iIntValue2 / sysList.size()));
        }
        if (diaList == null || !(!diaList.isEmpty())) {
            return;
        }
        Iterator<Integer> it2 = diaList.iterator();
        while (it2.hasNext()) {
            iIntValue += it2.next().intValue();
        }
        getBinding().txtAvgOxygenLow.setText(Integer.toString(iIntValue / diaList.size()));
    }
}
