package com.dw.launcher.data.repository;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.RecentTask;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: IRecentTaskRepository.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH&¨\u0006\u000b"}, d2 = {"Lcom/dw/launcher/data/repository/IRecentTaskRepository;", BuildConfig.FLAVOR, "clearForbiddenTask", BuildConfig.FLAVOR, "createRecentTaskByPackageName", "Lcom/dw/launcher/data/entity/RecentTask;", "packageName", BuildConfig.FLAVOR, "className", "getRecentTask", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IRecentTaskRepository {
    void clearForbiddenTask();

    RecentTask createRecentTaskByPackageName(String packageName, String className);

    List<RecentTask> getRecentTask();

    /* JADX INFO: compiled from: IRecentTaskRepository.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ RecentTask createRecentTaskByPackageName$default(IRecentTaskRepository iRecentTaskRepository, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createRecentTaskByPackageName");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return iRecentTaskRepository.createRecentTaskByPackageName(str, str2);
        }
    }
}
