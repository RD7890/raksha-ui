package com.dw.launcher.ui.dashboard;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.dw.launcher.data.entity.Shortcut;
import com.dw.launcher.data.repository.IShortcutRepository;
import com.google.android.mms.pdu.CharacterSets;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DashboardViewModel.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/dw/launcher/ui/dashboard/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/dw/launcher/data/repository/IShortcutRepository;", "(Lcom/dw/launcher/data/repository/IShortcutRepository;)V", "getRepository", "()Lcom/dw/launcher/data/repository/IShortcutRepository;", "shortcuts", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/dw/launcher/data/entity/Shortcut;", "getShortcuts", "()Landroidx/lifecycle/MutableLiveData;", "reload", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class DashboardViewModel extends ViewModel {
    private final IShortcutRepository repository;
    private final MutableLiveData<List<Shortcut>> shortcuts;

    @Inject
    public DashboardViewModel(IShortcutRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
        this.shortcuts = repository.getShortcuts();
    }

    public final IShortcutRepository getRepository() {
        return this.repository;
    }

    public final MutableLiveData<List<Shortcut>> getShortcuts() {
        return this.shortcuts;
    }

    public final void reload() {
        this.repository.reload();
    }
}
