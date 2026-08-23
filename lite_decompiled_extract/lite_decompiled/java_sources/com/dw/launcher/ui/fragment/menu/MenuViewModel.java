package com.dw.launcher.ui.fragment.menu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.dw.launcher.data.entity.RecentTask;
import com.dw.launcher.data.preference.SharedPreferencesUtils;
import com.dw.launcher.data.repository.IRecentTaskRepository;
import com.dw.launcher.ui.activity.AddMenuShortcutActivity;
import com.google.android.mms.pdu.CharacterSets;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MenuViewModel.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0006\u0010\u0018\u001a\u00020\u0012R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/dw/launcher/ui/fragment/menu/MenuViewModel;", "Landroidx/lifecycle/ViewModel;", "recentTaskRepository", "Lcom/dw/launcher/data/repository/IRecentTaskRepository;", "sharedPreferencesUtils", "Lcom/dw/launcher/data/preference/SharedPreferencesUtils;", "(Lcom/dw/launcher/data/repository/IRecentTaskRepository;Lcom/dw/launcher/data/preference/SharedPreferencesUtils;)V", "_shortcuts", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/dw/launcher/data/entity/RecentTask;", "getSharedPreferencesUtils", "()Lcom/dw/launcher/data/preference/SharedPreferencesUtils;", "shortcuts", "Landroidx/lifecycle/LiveData;", "getShortcuts", "()Landroidx/lifecycle/LiveData;", "addShortcut", "", "packageName", "", "className", "autoSaveShortcuts", "loadRecentTasks", "reload", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class MenuViewModel extends ViewModel {
    private final MutableLiveData<List<RecentTask>> _shortcuts;
    private final IRecentTaskRepository recentTaskRepository;
    private final SharedPreferencesUtils sharedPreferencesUtils;
    private final LiveData<List<RecentTask>> shortcuts;

    @Inject
    public MenuViewModel(IRecentTaskRepository recentTaskRepository, SharedPreferencesUtils sharedPreferencesUtils) {
        Intrinsics.checkNotNullParameter(recentTaskRepository, "recentTaskRepository");
        Intrinsics.checkNotNullParameter(sharedPreferencesUtils, "sharedPreferencesUtils");
        this.recentTaskRepository = recentTaskRepository;
        this.sharedPreferencesUtils = sharedPreferencesUtils;
        LiveData<List<RecentTask>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(loadRecentTasks());
        this._shortcuts = mutableLiveData;
        this.shortcuts = mutableLiveData;
    }

    public final SharedPreferencesUtils getSharedPreferencesUtils() {
        return this.sharedPreferencesUtils;
    }

    public final void reload() {
        this._shortcuts.setValue(loadRecentTasks());
    }

    public final LiveData<List<RecentTask>> getShortcuts() {
        return this.shortcuts;
    }

    public final void addShortcut(String packageName, String className) {
        List list;
        IRecentTaskRepository iRecentTaskRepository = this.recentTaskRepository;
        Intrinsics.checkNotNull(packageName);
        RecentTask recentTaskCreateRecentTaskByPackageName = iRecentTaskRepository.createRecentTaskByPackageName(packageName, className);
        if (recentTaskCreateRecentTaskByPackageName != null && (list = (List) this.shortcuts.getValue()) != null) {
            list.add(recentTaskCreateRecentTaskByPackageName);
        }
        String json = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(this.shortcuts.getValue());
        SharedPreferencesUtils sharedPreferencesUtils = this.sharedPreferencesUtils;
        Intrinsics.checkNotNull(json);
        sharedPreferencesUtils.saveMenuSlideList(json);
    }

    public final void autoSaveShortcuts() {
        List list = (List) this.shortcuts.getValue();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (!Intrinsics.areEqual(((RecentTask) obj).getClassName(), AddMenuShortcutActivity.class.getName())) {
                    arrayList.add(obj);
                }
            }
            String json = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(arrayList);
            SharedPreferencesUtils sharedPreferencesUtils = this.sharedPreferencesUtils;
            Intrinsics.checkNotNull(json);
            sharedPreferencesUtils.saveMenuSlideList(json);
        }
    }

    private final List<RecentTask> loadRecentTasks() {
        ArrayList arrayList = new ArrayList();
        String menuSlideList = this.sharedPreferencesUtils.getMenuSlideList();
        if (menuSlideList != null) {
            List<RecentTask> list = (List) new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(menuSlideList, new TypeToken<List<RecentTask>>() { // from class: com.dw.launcher.ui.fragment.menu.MenuViewModel$loadRecentTasks$1$listType$1
            }.getType());
            Intrinsics.checkNotNull(list);
            for (RecentTask recentTask : list) {
                RecentTask recentTaskCreateRecentTaskByPackageName = this.recentTaskRepository.createRecentTaskByPackageName(recentTask.getPackageName(), recentTask.getClassName());
                if (recentTaskCreateRecentTaskByPackageName != null) {
                    arrayList.add(recentTaskCreateRecentTaskByPackageName);
                }
            }
        } else {
            arrayList.addAll(this.recentTaskRepository.getRecentTask());
        }
        return arrayList;
    }
}
