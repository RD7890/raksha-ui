package com.dw.launcher.ui.viewmodel;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.dw.launcher.data.component.WallpaperComponent;
import com.dw.launcher.data.entity.Wallpaper;
import com.google.android.mms.pdu.CharacterSets;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: WallpaperViewModel.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0007¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/dw/launcher/ui/viewmodel/WallpaperViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "()V", "_papers", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/dw/launcher/data/entity/Wallpaper;", "papers", "Landroidx/lifecycle/LiveData;", "getPapers", "()Landroidx/lifecycle/LiveData;", "setPapers", "(Landroidx/lifecycle/LiveData;)V", "wallpaperComponent", "Lcom/dw/launcher/data/component/WallpaperComponent;", "getWallpaperComponent", "()Lcom/dw/launcher/data/component/WallpaperComponent;", "setWallpaperComponent", "(Lcom/dw/launcher/data/component/WallpaperComponent;)V", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStart", "setPaper", "", "wallpaper", "setPaperBoth", "setPaperForKeyguard", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class WallpaperViewModel extends ViewModel implements DefaultLifecycleObserver {
    private final MutableLiveData<List<Wallpaper>> _papers;
    private LiveData<List<Wallpaper>> papers;

    @Inject
    public WallpaperComponent wallpaperComponent;

    @Inject
    public WallpaperViewModel() {
        LiveData<List<Wallpaper>> mutableLiveData = new MutableLiveData<>();
        this._papers = mutableLiveData;
        this.papers = mutableLiveData;
    }

    public final WallpaperComponent getWallpaperComponent() {
        WallpaperComponent wallpaperComponent = this.wallpaperComponent;
        if (wallpaperComponent != null) {
            return wallpaperComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("wallpaperComponent");
        return null;
    }

    public final void setWallpaperComponent(WallpaperComponent wallpaperComponent) {
        Intrinsics.checkNotNullParameter(wallpaperComponent, "<set-?>");
        this.wallpaperComponent = wallpaperComponent;
    }

    public final LiveData<List<Wallpaper>> getPapers() {
        return this.papers;
    }

    public final void setPapers(LiveData<List<Wallpaper>> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.papers = liveData;
    }

    public void onCreate(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onCreate(owner);
        Timber.INSTANCE.i("----onCreate----", new Object[0]);
        this._papers.setValue(getWallpaperComponent().loadWallpapers());
        Timber.INSTANCE.i("----papers: " + this._papers.getValue(), new Object[0]);
    }

    public void onStart(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStart(owner);
        Timber.INSTANCE.i("----onStart----", new Object[0]);
    }

    public final boolean setPaper(Wallpaper wallpaper) {
        Intrinsics.checkNotNullParameter(wallpaper, "wallpaper");
        return getWallpaperComponent().setWallpaper(wallpaper);
    }

    public final boolean setPaperForKeyguard(Wallpaper wallpaper) {
        Intrinsics.checkNotNullParameter(wallpaper, "wallpaper");
        return getWallpaperComponent().setWallpaperAsKeyguard(wallpaper);
    }

    public final boolean setPaperBoth(Wallpaper wallpaper) {
        Intrinsics.checkNotNullParameter(wallpaper, "wallpaper");
        return getWallpaperComponent().setWallpaperBoth(wallpaper);
    }
}
