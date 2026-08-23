package com.dw.launcher.data.repository;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.Clock;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ClockRepository.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0007\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0003H&J\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/dw/launcher/data/repository/ClockRepository;", BuildConfig.FLAVOR, "findPreferClockList", "Lcom/dw/launcher/data/entity/Clock;", "getClockList", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "level", BuildConfig.FLAVOR, "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNeedChangeToDynamicClock", BuildConfig.FLAVOR, "clock", "loadClockFromAssets", "saveOrUpdateClock", BuildConfig.FLAVOR, "switchToNextClickedClock", "(Lcom/dw/launcher/data/entity/Clock;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchToTargetDynamicClock", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ClockRepository {
    Clock findPreferClockList();

    Object getClockList(int i, Continuation<? super List<Clock>> continuation);

    Object getClockList(Continuation<? super List<Clock>> continuation);

    boolean isNeedChangeToDynamicClock(Clock clock);

    List<Clock> loadClockFromAssets();

    void saveOrUpdateClock(Clock clock);

    Object switchToNextClickedClock(Clock clock, Continuation<? super Clock> continuation);

    Object switchToTargetDynamicClock(Clock clock, Continuation<? super Clock> continuation);
}
