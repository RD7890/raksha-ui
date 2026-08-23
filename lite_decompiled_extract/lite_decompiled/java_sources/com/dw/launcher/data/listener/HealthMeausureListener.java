package com.dw.launcher.data.listener;

import androidx.core.app.NotificationCompat;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.TodayDataList;
import kotlin.Metadata;

/* JADX INFO: compiled from: HealthMeausureListener.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/dw/launcher/data/listener/HealthMeausureListener;", BuildConfig.FLAVOR, "onError", BuildConfig.FLAVOR, NotificationCompat.CATEGORY_STATUS, BuildConfig.FLAVOR, "onFinish", "todayDataList", "Lcom/dw/launcher/data/entity/TodayDataList;", "onHealthMeausure", "value", "value2", "onstart", "onstop", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface HealthMeausureListener {
    void onError(int status);

    void onFinish(TodayDataList todayDataList);

    void onHealthMeausure(int value, int value2);

    void onstart();

    void onstop();

    /* JADX INFO: compiled from: HealthMeausureListener.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onHealthMeausure$default(HealthMeausureListener healthMeausureListener, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onHealthMeausure");
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            healthMeausureListener.onHealthMeausure(i, i2);
        }
    }
}
