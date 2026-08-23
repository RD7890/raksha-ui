package com.dw.launcher.ui.fragment.bloodoxygen;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dw.launcher.base.BaseFragment;
import com.dw.launcher.data.entity.TodayDataList;
import com.dw.launcher.data.listener.HealthMeausureListener;
import com.dw.launcher.manager.OxygenManager;
import com.dw.oxygen.HeartBarChart;
import com.dw.oxygen.R;
import com.google.android.mms.pdu.CharacterSets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OxygenFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\u001a\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u0007H\u0002J2\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070+2\u0010\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010+H\u0002J\b\u0010-\u001a\u00020\u001aH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/dw/launcher/ui/fragment/bloodoxygen/OxygenFragment;", "Lcom/dw/launcher/base/BaseFragment;", "()V", "anim", "Landroid/graphics/drawable/AnimationDrawable;", "deepList", "", "", "getDeepList", "()Ljava/util/List;", "setDeepList", "(Ljava/util/List;)V", "heartDayChart", "Lcom/dw/oxygen/HeartBarChart;", "mSensorManager", "Landroid/hardware/SensorManager;", "posList", "getPosList", "setPosList", "txtAvgOxygen", "Landroid/widget/TextView;", "txtHeart", "txtStatus", "wrist_status", "Landroid/widget/RelativeLayout;", "calculatAvg", "", "getLayoutId", "isSinglePortHeart", "", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setHeartValue", "mHrValue", "showChart", "context", "Landroid/content/Context;", "posIndexList", "", "sysList", "start", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class OxygenFragment extends BaseFragment {
    private AnimationDrawable anim;
    private HeartBarChart heartDayChart;
    private SensorManager mSensorManager;
    private TextView txtAvgOxygen;
    private TextView txtHeart;
    private TextView txtStatus;
    private RelativeLayout wrist_status;
    private List<Integer> deepList = new ArrayList();
    private List<Integer> posList = new ArrayList();

    public final List<Integer> getDeepList() {
        return this.deepList;
    }

    public final void setDeepList(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.deepList = list;
    }

    public final List<Integer> getPosList() {
        return this.posList;
    }

    public final void setPosList(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.posList = list;
    }

    public int getLayoutId() {
        return R.layout.fragment_oxygen_new;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.heartDayChart = (HeartBarChart) view.findViewById(R.id.heartChart);
        this.wrist_status = (RelativeLayout) view.findViewById(R.id.wrist_status);
        View viewFindViewById = view.findViewById(R.id.ivAnim);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.txtHeart = (TextView) view.findViewById(R.id.txtHeart);
        this.txtAvgOxygen = (TextView) view.findViewById(R.id.txtAvgOxygen);
        this.txtStatus = (TextView) view.findViewById(R.id.txtStatus);
        Drawable drawable = requireContext().getDrawable(R.drawable.oxygen_measureing);
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        this.anim = animationDrawable;
        ((ImageView) viewFindViewById).setBackground(animationDrawable);
    }

    public void onResume() {
        super.onResume();
        TodayDataList fromCache = OxygenManager.getInstance().readFromCache(requireContext());
        Intrinsics.checkNotNullExpressionValue(fromCache, "readFromCache(...)");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        List<Integer> indexList = fromCache.getIndexList();
        Intrinsics.checkNotNullExpressionValue(indexList, "getIndexList(...)");
        showChart(contextRequireContext, indexList, fromCache.getValueList());
        HeartBarChart heartBarChart = this.heartDayChart;
        if (heartBarChart != null) {
            heartBarChart.startAnimate2();
        }
        start();
    }

    private final void start() {
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        Settings.Global.putInt(context.getContentResolver(), "health_measure_status", 0);
        OxygenManager.getInstance().start(requireContext(), new HealthMeausureListener() { // from class: com.dw.launcher.ui.fragment.bloodoxygen.OxygenFragment.start.1
            public void onHealthMeausure(int value, int value2) {
                TextView textView = OxygenFragment.this.txtHeart;
                Intrinsics.checkNotNull(textView);
                textView.setText(value + "");
            }

            public void onstart() {
                TextView textView = OxygenFragment.this.txtHeart;
                Intrinsics.checkNotNull(textView);
                textView.setText("--");
                AnimationDrawable animationDrawable = OxygenFragment.this.anim;
                if (animationDrawable != null) {
                    animationDrawable.start();
                }
                TextView textView2 = OxygenFragment.this.txtStatus;
                Intrinsics.checkNotNull(textView2);
                textView2.setText(OxygenFragment.this.getString(R.string.measuring));
            }

            public void onstop() {
                AnimationDrawable animationDrawable = OxygenFragment.this.anim;
                if (animationDrawable != null) {
                    animationDrawable.stop();
                }
                TextView textView = OxygenFragment.this.txtStatus;
                Intrinsics.checkNotNull(textView);
                textView.setText(OxygenFragment.this.getString(R.string.not_measure));
            }

            public void onFinish(TodayDataList todayDataList) {
                Intrinsics.checkNotNullParameter(todayDataList, "todayDataList");
                AnimationDrawable animationDrawable = OxygenFragment.this.anim;
                if (animationDrawable != null) {
                    animationDrawable.stop();
                }
                OxygenFragment oxygenFragment = OxygenFragment.this;
                Context contextRequireContext = oxygenFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                List indexList = todayDataList.getIndexList();
                Intrinsics.checkNotNullExpressionValue(indexList, "getIndexList(...)");
                oxygenFragment.showChart(contextRequireContext, indexList, todayDataList.getValueList());
                String str = new SimpleDateFormat("MM/dd HH:mm").format(new Date(System.currentTimeMillis()));
                TextView textView = OxygenFragment.this.txtStatus;
                Intrinsics.checkNotNull(textView);
                textView.setText(str);
            }

            public void onError(int status) {
                if (status == 0) {
                    RelativeLayout relativeLayout = OxygenFragment.this.wrist_status;
                    Intrinsics.checkNotNull(relativeLayout);
                    relativeLayout.setVisibility(8);
                    return;
                }
                AnimationDrawable animationDrawable = OxygenFragment.this.anim;
                if (animationDrawable != null) {
                    animationDrawable.stop();
                }
                RelativeLayout relativeLayout2 = OxygenFragment.this.wrist_status;
                Intrinsics.checkNotNull(relativeLayout2);
                relativeLayout2.setVisibility(0);
                TextView textView = OxygenFragment.this.txtStatus;
                Intrinsics.checkNotNull(textView);
                textView.setText(OxygenFragment.this.getString(R.string.not_touch));
                RelativeLayout relativeLayout3 = OxygenFragment.this.wrist_status;
                Intrinsics.checkNotNull(relativeLayout3);
                relativeLayout3.setVisibility(0);
            }
        });
    }

    private final boolean isSinglePortHeart() {
        String str = SystemProperties.get("persist.sys.dw.heart", "");
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        return Intrinsics.areEqual(str, "bd1662") || Intrinsics.areEqual(str, "bd1688") || Intrinsics.areEqual(str, "fhr4") || Intrinsics.areEqual(str, "hrs3300");
    }

    private final void setHeartValue(int mHrValue) {
        if (mHrValue > 0) {
            TextView textView = this.txtHeart;
            Intrinsics.checkNotNull(textView);
            textView.setText(mHrValue + "");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            this.posList.add(Integer.valueOf(calendar.get(11)));
            this.deepList.add(Integer.valueOf(mHrValue));
            HeartBarChart heartBarChart = this.heartDayChart;
            Intrinsics.checkNotNull(heartBarChart);
            heartBarChart.setDailyList(this.deepList, this.posList);
            String str = new SimpleDateFormat("MM/dd HH:mm").format(new Date(System.currentTimeMillis()));
            TextView textView2 = this.txtStatus;
            Intrinsics.checkNotNull(textView2);
            textView2.setText(str);
        }
    }

    private final void calculatAvg() {
        int size = this.deepList.size();
        int iIntValue = 0;
        for (int i = 0; i < size; i++) {
            iIntValue += this.deepList.get(i).intValue();
        }
        TextView textView = this.txtAvgOxygen;
        Intrinsics.checkNotNull(textView);
        textView.setText((iIntValue / this.deepList.size()) + "");
    }

    public void onPause() {
        super.onPause();
        TextView textView = this.txtStatus;
        Intrinsics.checkNotNull(textView);
        textView.setText(getString(com.dw.launcher.R.string.not_measure));
        OxygenManager.getInstance().stop();
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void showChart(Context context, List<Integer> posIndexList, List<Integer> sysList) {
        HeartBarChart heartBarChart = this.heartDayChart;
        Intrinsics.checkNotNull(heartBarChart);
        heartBarChart.setDailyList(sysList, posIndexList);
        if (sysList == null || sysList.isEmpty()) {
            return;
        }
        Log.d("BloodPressureProvider", "sysList: " + Arrays.asList(sysList));
        Log.d("BloodPressureProvider", "posIndexList: " + Arrays.asList(posIndexList));
        Stream<Integer> stream = sysList.stream();
        final OxygenFragment$showChart$avgSysBlood$1 oxygenFragment$showChart$avgSysBlood$1 = new Function1<Integer, Integer>() { // from class: com.dw.launcher.ui.fragment.bloodoxygen.OxygenFragment$showChart$avgSysBlood$1
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(Integer num) {
                Intrinsics.checkNotNull(num);
                return Integer.valueOf(num.intValue());
            }
        };
        int iSum = stream.mapToInt(new ToIntFunction() { // from class: com.dw.launcher.ui.fragment.bloodoxygen.OxygenFragment$$ExternalSyntheticLambda0
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return OxygenFragment.showChart$lambda$0(oxygenFragment$showChart$avgSysBlood$1, obj);
            }
        }).sum() / sysList.size();
        TextView textView = this.txtAvgOxygen;
        Intrinsics.checkNotNull(textView);
        textView.setText(String.valueOf(iSum));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int showChart$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj)).intValue();
    }
}
