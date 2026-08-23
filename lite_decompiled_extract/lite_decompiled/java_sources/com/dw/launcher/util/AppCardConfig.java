package com.dw.launcher.util;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.AppItem;
import com.dw.launcher.ui.fragment.bloodoxygen.OxygenFragment;
import com.dw.launcher.ui.fragment.bloodpress.BloodPressureFragment;
import com.dw.launcher.ui.fragment.breathe.BreatheFragment;
import com.dw.launcher.ui.fragment.heart.HeartFragment;
import com.dw.launcher.ui.fragment.music.MusicControlFragment;
import com.dw.launcher.ui.fragment.sleep.SleepFragment;
import com.dw.launcher.ui.fragment.sport.SportFragment;
import com.dw.launcher.ui.fragment.step.StepFragment;
import com.google.android.mms.pdu.CharacterSets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: AppCardConfig.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0016H\u0007J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/dw/launcher/util/AppCardConfig;", "", "()V", "ACTION_ITEM_CHANGED_BROADCAST", "", "ACTION_ITEM_CURRENT", "BLOODPRESSURE_ITEM", "", "BREATHE_ITEM", "HEART_ITEM", "MUSIC_ITEM", "OXYGEN_ITEM", "SLEEP_ITEM", "SPORT_ITEM", "STEP_ITEM", "Video_ITEM", "map", "", "getMap$annotations", "getMap", "()Ljava/util/Map;", "getAppFragments", "", "Landroidx/fragment/app/Fragment;", "appItemList", "Lcom/dw/launcher/data/entity/AppItem;", "haveLocalApp", "", "context", "Landroid/content/Context;", "type", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class AppCardConfig {
    public static final String ACTION_ITEM_CHANGED_BROADCAST = "ACTION_APP_ITEM_CHANGED";
    public static final String ACTION_ITEM_CURRENT = "ACTION_APP_ITEM_CURRENT";
    public static final int BLOODPRESSURE_ITEM = 8;
    public static final int BREATHE_ITEM = 3;
    public static final int HEART_ITEM = 0;
    public static final int MUSIC_ITEM = 4;
    public static final int OXYGEN_ITEM = 7;
    public static final int SLEEP_ITEM = 2;
    public static final int SPORT_ITEM = 5;
    public static final int STEP_ITEM = 1;
    public static final int Video_ITEM = 6;
    public static final AppCardConfig INSTANCE = new AppCardConfig();
    private static final Map<Integer, Integer> map = MapsKt.mapOf(TuplesKt.to(0, Integer.valueOf(R.mipmap.icon_item_heart)), TuplesKt.to(2, Integer.valueOf(R.mipmap.icon_item_sleep)), TuplesKt.to(1, Integer.valueOf(R.mipmap.icon_item_step)), TuplesKt.to(3, Integer.valueOf(R.mipmap.icon_item_breathe)), TuplesKt.to(4, Integer.valueOf(R.mipmap.icon_item_music)), TuplesKt.to(5, Integer.valueOf(R.mipmap.icon_item_sport)), TuplesKt.to(7, Integer.valueOf(R.mipmap.icon_item_oxygen)), TuplesKt.to(8, Integer.valueOf(R.mipmap.icon_item_bloodpressure)));

    @JvmStatic
    public static /* synthetic */ void getMap$annotations() {
    }

    private AppCardConfig() {
    }

    public static final Map<Integer, Integer> getMap() {
        return map;
    }

    @JvmStatic
    public static final List<Fragment> getAppFragments(List<AppItem> appItemList) {
        Intrinsics.checkNotNullParameter(appItemList, "appItemList");
        ArrayList arrayList = new ArrayList();
        for (AppItem appItem : appItemList) {
            if (appItem.getSelected()) {
                switch (appItem.getId()) {
                    case 0:
                        arrayList.add(new HeartFragment());
                        break;
                    case 1:
                        arrayList.add(new StepFragment());
                        break;
                    case 2:
                        arrayList.add(new SleepFragment());
                        break;
                    case 3:
                        arrayList.add(new BreatheFragment());
                        break;
                    case 4:
                        arrayList.add(new MusicControlFragment());
                        break;
                    case 5:
                        arrayList.add(new SportFragment());
                        break;
                    case 7:
                        arrayList.add(new OxygenFragment());
                        break;
                    case 8:
                        arrayList.add(new BloodPressureFragment());
                        break;
                }
                Timber.INSTANCE.d(" item 名称: " + appItem.getName() + " id: " + appItem.getId() + ' ', new Object[0]);
            }
        }
        return arrayList;
    }

    public final boolean haveLocalApp(Context context, int type) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (type == 0) {
            return SystemUtils.INSTANCE.isAppInstalled("com.dw.heartrate", context);
        }
        if (type == 1) {
            return SystemUtils.INSTANCE.isAppInstalled("com.dwiot.dwstep", context);
        }
        if (type == 3) {
            return SystemUtils.INSTANCE.isAppInstalled("com.divoiot.breathe", context);
        }
        if (type == 7) {
            return SystemUtils.INSTANCE.isAppInstalled("com.dw.oxygen", context);
        }
        if (type != 8) {
            return true;
        }
        return SystemUtils.INSTANCE.isAppInstalled("com.dwiot.bloodpressure", context);
    }
}
