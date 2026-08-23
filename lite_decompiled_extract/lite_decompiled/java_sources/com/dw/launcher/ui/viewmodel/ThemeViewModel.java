package com.dw.launcher.ui.viewmodel;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.dw.launcher.data.entity.ThemeItem;
import com.dw.launcher.data.repository.IShortcutRepository;
import com.google.android.mms.pdu.CharacterSets;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: ThemeViewModel.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0007¢\u0006\u0002\u0010\u0003J\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/dw/launcher/ui/viewmodel/ThemeViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "()V", "shortcutRepository", "Lcom/dw/launcher/data/repository/IShortcutRepository;", "getShortcutRepository", "()Lcom/dw/launcher/data/repository/IShortcutRepository;", "setShortcutRepository", "(Lcom/dw/launcher/data/repository/IShortcutRepository;)V", "loadThemes", "Landroidx/lifecycle/LiveData;", "", "Lcom/dw/launcher/data/entity/ThemeItem;", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStart", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ThemeViewModel extends ViewModel implements DefaultLifecycleObserver {

    @Inject
    public IShortcutRepository shortcutRepository;

    @Inject
    public ThemeViewModel() {
    }

    public final IShortcutRepository getShortcutRepository() {
        IShortcutRepository iShortcutRepository = this.shortcutRepository;
        if (iShortcutRepository != null) {
            return iShortcutRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shortcutRepository");
        return null;
    }

    public final void setShortcutRepository(IShortcutRepository iShortcutRepository) {
        Intrinsics.checkNotNullParameter(iShortcutRepository, "<set-?>");
        this.shortcutRepository = iShortcutRepository;
    }

    public final LiveData<List<ThemeItem>> loadThemes() {
        return getShortcutRepository().loadThemes();
    }

    public void onCreate(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onCreate(owner);
        Timber.INSTANCE.i("----onCreate----", new Object[0]);
    }

    public void onStart(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStart(owner);
        Timber.INSTANCE.i("----onStart----", new Object[0]);
    }
}
