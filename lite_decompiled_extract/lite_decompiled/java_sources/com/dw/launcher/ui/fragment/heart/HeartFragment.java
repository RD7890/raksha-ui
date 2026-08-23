package com.dw.launcher.ui.fragment.heart;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.TodayDataList;
import com.dw.launcher.data.listener.HealthMeausureListener;
import com.dw.launcher.manager.HeartRateManager;
import com.dw.launcher.ui.view.HeartBarChart;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HeartFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\u001a\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J2\u0010&\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060(2\u0010\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010(H\u0002J\b\u0010*\u001a\u00020\u001bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/dw/launcher/ui/fragment/heart/HeartFragment;", "Lcom/dw/launcher/base/BaseFragment;", "()V", "anim", "Landroid/graphics/drawable/AnimationDrawable;", "currStatus", "", "deepList", "", "default_duration", "heartDayChart", "Lcom/dw/launcher/ui/view/HeartBarChart;", "index", "isTouchFall", "", "ivAnim", "Landroid/widget/ImageView;", "mSensorManager", "Landroid/hardware/SensorManager;", "txtAvgHeart", "Landroid/widget/TextView;", "txtHeart", "txtStatus", "wrist_status", "Landroid/widget/RelativeLayout;", "getLayoutId", "onAttach", "", "context", "Landroid/content/Context;", "onDetach", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showChart", "posIndexList", "", "sysList", "start", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class HeartFragment extends Hilt_HeartFragment {
    private AnimationDrawable anim;
    private int currStatus;
    private List<Integer> deepList;
    private final int default_duration = 60000;
    private HeartBarChart heartDayChart;
    private int index;
    private boolean isTouchFall;
    private ImageView ivAnim;
    private SensorManager mSensorManager;
    private TextView txtAvgHeart;
    private TextView txtHeart;
    private TextView txtStatus;
    private RelativeLayout wrist_status;

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.currStatus = 0;
        this.heartDayChart = (HeartBarChart) view.findViewById(R.id.heartChart);
        this.ivAnim = (ImageView) view.findViewById(R.id.ivAnim);
        View viewFindViewById = view.findViewById(R.id.wrist_status);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RelativeLayout relativeLayout = (RelativeLayout) viewFindViewById;
        this.wrist_status = relativeLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wrist_status");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
        Drawable drawable = requireActivity().getDrawable(com.dw.heart.R.drawable.heart_measure);
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        this.anim = (AnimationDrawable) drawable;
        ImageView imageView = this.ivAnim;
        Intrinsics.checkNotNull(imageView);
        imageView.setBackground(this.anim);
        this.txtStatus = (TextView) view.findViewById(R.id.txtStatus);
        this.txtHeart = (TextView) view.findViewById(R.id.txtHeart);
        View viewFindViewById2 = view.findViewById(R.id.txtAvgHeart);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.txtAvgHeart = (TextView) viewFindViewById2;
        this.deepList = new ArrayList();
        this.index = 0;
    }

    public int getLayoutId() {
        return R.layout.fragment_heart;
    }

    @Override // com.dw.launcher.ui.fragment.heart.Hilt_HeartFragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onResume() {
        super.onResume();
        TodayDataList fromCache = HeartRateManager.getInstance().readFromCache(requireContext());
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
        final Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Settings.Global.putInt(contextRequireContext.getContentResolver(), "health_measure_status", 0);
        HeartRateManager.getInstance().start(contextRequireContext, new HealthMeausureListener() { // from class: com.dw.launcher.ui.fragment.heart.HeartFragment.start.1
            public void onHealthMeausure(int sysBloodPress, int diaBloodPress) {
                TextView textView = HeartFragment.this.txtHeart;
                Intrinsics.checkNotNull(textView);
                textView.setText(sysBloodPress + "");
            }

            public void onstart() {
                TextView textView = HeartFragment.this.txtHeart;
                Intrinsics.checkNotNull(textView);
                textView.setText("--");
                AnimationDrawable animationDrawable = HeartFragment.this.anim;
                if (animationDrawable != null) {
                    animationDrawable.start();
                }
                TextView textView2 = HeartFragment.this.txtStatus;
                Intrinsics.checkNotNull(textView2);
                textView2.setText(contextRequireContext.getString(R.string.measuring));
            }

            public void onstop() {
                AnimationDrawable animationDrawable = HeartFragment.this.anim;
                if (animationDrawable != null) {
                    animationDrawable.stop();
                }
                TextView textView = HeartFragment.this.txtStatus;
                Intrinsics.checkNotNull(textView);
                textView.setText(contextRequireContext.getString(R.string.not_measure));
            }

            public void onFinish(TodayDataList todayDataList) {
                Intrinsics.checkNotNullParameter(todayDataList, "todayDataList");
                AnimationDrawable animationDrawable = HeartFragment.this.anim;
                if (animationDrawable != null) {
                    animationDrawable.stop();
                }
                HeartFragment heartFragment = HeartFragment.this;
                Context context = contextRequireContext;
                List indexList = todayDataList.getIndexList();
                Intrinsics.checkNotNullExpressionValue(indexList, "getIndexList(...)");
                heartFragment.showChart(context, indexList, todayDataList.getValueList());
                String str = new SimpleDateFormat("MM/dd HH:mm").format(new Date(System.currentTimeMillis()));
                TextView textView = HeartFragment.this.txtStatus;
                Intrinsics.checkNotNull(textView);
                textView.setText(str);
            }

            public void onError(int status) {
                RelativeLayout relativeLayout = null;
                if (status == 0) {
                    RelativeLayout relativeLayout2 = HeartFragment.this.wrist_status;
                    if (relativeLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("wrist_status");
                    } else {
                        relativeLayout = relativeLayout2;
                    }
                    relativeLayout.setVisibility(8);
                    return;
                }
                TextView textView = HeartFragment.this.txtStatus;
                Intrinsics.checkNotNull(textView);
                textView.setText(contextRequireContext.getString(R.string.not_touch));
                AnimationDrawable animationDrawable = HeartFragment.this.anim;
                if (animationDrawable != null) {
                    animationDrawable.stop();
                }
                RelativeLayout relativeLayout3 = HeartFragment.this.wrist_status;
                if (relativeLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("wrist_status");
                } else {
                    relativeLayout = relativeLayout3;
                }
                relativeLayout.setVisibility(0);
            }
        });
        RelativeLayout relativeLayout = this.wrist_status;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wrist_status");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
    }

    public void onPause() {
        super.onPause();
        HeartRateManager.getInstance().stop();
        TextView textView = this.txtStatus;
        Intrinsics.checkNotNull(textView);
        textView.setText(getString(R.string.not_measure));
        AnimationDrawable animationDrawable = this.anim;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        RelativeLayout relativeLayout = this.wrist_status;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wrist_status");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showChart(Context context, List<Integer> posIndexList, List<Integer> sysList) {
        HeartBarChart heartBarChart = this.heartDayChart;
        if (heartBarChart != null) {
            heartBarChart.setDailyList(sysList, posIndexList);
        }
        if (sysList == null || !(!sysList.isEmpty())) {
            return;
        }
        Stream<Integer> stream = sysList.stream();
        final HeartFragment$showChart$avgSysBlood$1 heartFragment$showChart$avgSysBlood$1 = new Function1<Integer, Integer>() { // from class: com.dw.launcher.ui.fragment.heart.HeartFragment$showChart$avgSysBlood$1
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(Integer num) {
                Intrinsics.checkNotNull(num);
                return Integer.valueOf(num.intValue());
            }
        };
        int iSum = stream.mapToInt(new ToIntFunction() { // from class: com.dw.launcher.ui.fragment.heart.HeartFragment$$ExternalSyntheticLambda0
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return HeartFragment.showChart$lambda$0(heartFragment$showChart$avgSysBlood$1, obj);
            }
        }).sum() / sysList.size();
        TextView textView = this.txtAvgHeart;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("txtAvgHeart");
            textView = null;
        }
        textView.setText(String.valueOf(iSum));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int showChart$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj)).intValue();
    }
}
