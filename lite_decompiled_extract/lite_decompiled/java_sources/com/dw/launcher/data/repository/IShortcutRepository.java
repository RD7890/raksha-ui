package com.dw.launcher.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.entity.Shortcut;
import com.dw.launcher.data.entity.ThemeItem;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: IShortcutRepository.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u0007H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/dw/launcher/data/repository/IShortcutRepository;", BuildConfig.FLAVOR, "getShortcuts", "Landroidx/lifecycle/MutableLiveData;", BuildConfig.FLAVOR, "Lcom/dw/launcher/data/entity/Shortcut;", "loadThemes", "Landroidx/lifecycle/LiveData;", "Lcom/dw/launcher/data/entity/ThemeItem;", "reload", BuildConfig.FLAVOR, "reloadTheme", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IShortcutRepository {
    MutableLiveData<List<Shortcut>> getShortcuts();

    LiveData<List<ThemeItem>> loadThemes();

    void reload();

    void reloadTheme();
}
