package com.dw.launcher.ui.dashboard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.dw.launcher.R;
import com.dw.launcher.core.component.SensorComponent;
import com.dw.launcher.core.component.SoundEffect;
import com.dw.launcher.core.skin.config.SkinConfig;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.component.WallpaperComponent;
import com.dw.launcher.data.config.AppFilterConfig;
import com.dw.launcher.data.entity.Shortcut;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.hilt.annotion.SoundPoolAnnotion;
import com.dw.launcher.ui.view.TaskShowLayout;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import pl.droidsonroids.gif.GifDrawable;
import timber.log.Timber;

/* JADX INFO: compiled from: BaseDashboard.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b'\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=J\u0010\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020BJ\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020BH\u0004J\u0010\u0010F\u001a\u00020D2\u0006\u0010G\u001a\u00020\u000eH\u0016J\b\u0010H\u001a\u00020DH\u0016J\u0010\u0010I\u001a\u00020D2\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020DH\u0016J\b\u0010M\u001a\u00020DH\u0016J\u0018\u0010N\u001a\u00020\u000e2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u00020DH\u0016J\b\u0010T\u001a\u00020DH\u0016J\u0010\u0010U\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020\u000eH\u0016J\b\u0010V\u001a\u00020DH\u0016J\u0010\u0010W\u001a\u00020D2\u0006\u0010X\u001a\u00020>H\u0016J\u0010\u0010Y\u001a\u00020D2\u0006\u0010X\u001a\u00020>H\u0016J\u0016\u0010Z\u001a\u00020D2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020>0=H&J\u001a\u0010\\\u001a\u00020D2\u0006\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010a\u001a\u00020D2\u0006\u0010b\u001a\u00020PH\u0016J\u0010\u0010c\u001a\u00020D2\b\u0010d\u001a\u0004\u0018\u00010eJ\u0006\u0010f\u001a\u00020DJ\u0006\u0010g\u001a\u00020DJ\u001c\u0010h\u001a\u00020D2\b\u0010i\u001a\u0004\u0018\u00010j2\b\u0010k\u001a\u0004\u0018\u00010lH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b/\u0010\u0006\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0082.¢\u0006\u0002\n\u0000R\u001e\u00106\u001a\u0002078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006m"}, d2 = {"Lcom/dw/launcher/ui/dashboard/BaseDashboard;", "Lcom/dw/launcher/base/BaseFragment;", "Lcom/dw/launcher/core/component/SensorComponent$OnSensorChangedListener;", "Ljava/util/Observer;", "Lcom/dw/launcher/data/component/NoDisturbComponent$OnWatchModeChangedListener;", "Lcom/dw/launcher/data/component/NoDisturbComponent$OnAppLockChangedListener;", "()V", "LockRunable", "Ljava/lang/Runnable;", "defaultSoundEffectListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getDefaultSoundEffectListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "isVisble", "", "()Z", "setVisble", "(Z)V", "mHandler", "Landroid/os/Handler;", "mPreference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "getMPreference", "()Lcom/dw/launcher/data/preference/LauncherPreference;", "setMPreference", "(Lcom/dw/launcher/data/preference/LauncherPreference;)V", "mScheduleToStopRingtoneTask", "mSensorComponent", "Lcom/dw/launcher/core/component/SensorComponent;", "getMSensorComponent", "()Lcom/dw/launcher/core/component/SensorComponent;", "setMSensorComponent", "(Lcom/dw/launcher/core/component/SensorComponent;)V", "noDisturbComponent", "Lcom/dw/launcher/data/component/NoDisturbComponent;", "getNoDisturbComponent", "()Lcom/dw/launcher/data/component/NoDisturbComponent;", "setNoDisturbComponent", "(Lcom/dw/launcher/data/component/NoDisturbComponent;)V", "rlTaskShow", "Lcom/dw/launcher/ui/view/TaskShowLayout;", "getRlTaskShow", "()Lcom/dw/launcher/ui/view/TaskShowLayout;", "setRlTaskShow", "(Lcom/dw/launcher/ui/view/TaskShowLayout;)V", "soundEffect", "Lcom/dw/launcher/core/component/SoundEffect;", "getSoundEffect$annotations", "getSoundEffect", "()Lcom/dw/launcher/core/component/SoundEffect;", "setSoundEffect", "(Lcom/dw/launcher/core/component/SoundEffect;)V", "viewModel", "Lcom/dw/launcher/ui/dashboard/DashboardViewModel;", "wallpaperComponent", "Lcom/dw/launcher/data/component/WallpaperComponent;", "getWallpaperComponent", "()Lcom/dw/launcher/data/component/WallpaperComponent;", "setWallpaperComponent", "(Lcom/dw/launcher/data/component/WallpaperComponent;)V", "getShortcuts", "", "Lcom/dw/launcher/data/entity/Shortcut;", "loadDrawable", "Landroid/graphics/drawable/Drawable;", "path", "", "log", "", "msg", "move", "up", "onAppLockChanged", "onAttach", "context", "Landroid/content/Context;", "onDestroyView", "onDetach", "onKeyDown", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onSensorChanged", "onSensorStopped", "onShortcutClicked", "shortcut", "onShortcutLongClicked", "onShortcutsChanged", "shortcuts", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onWatchModeChanged", "mode", "showSlideUpTask", "parent", "Landroid/view/ViewGroup;", "startRingtone", "stopRingtone", "update", "o", "Ljava/util/Observable;", "arg", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public abstract class BaseDashboard extends Hilt_BaseDashboard implements SensorComponent.OnSensorChangedListener, Observer, NoDisturbComponent.OnWatchModeChangedListener, NoDisturbComponent.OnAppLockChangedListener {
    private boolean isVisble;

    @Inject
    public LauncherPreference mPreference;

    @Inject
    public SensorComponent mSensorComponent;

    @Inject
    public NoDisturbComponent noDisturbComponent;
    private TaskShowLayout rlTaskShow;

    @Inject
    public SoundEffect soundEffect;
    private DashboardViewModel viewModel;

    @Inject
    public WallpaperComponent wallpaperComponent;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mScheduleToStopRingtoneTask = new Runnable() { // from class: com.dw.launcher.ui.dashboard.BaseDashboard$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            BaseDashboard.mScheduleToStopRingtoneTask$lambda$0(this.f$0);
        }
    };
    private final RecyclerView.OnScrollListener defaultSoundEffectListener = new RecyclerView.OnScrollListener() { // from class: com.dw.launcher.ui.dashboard.BaseDashboard$defaultSoundEffectListener$1
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
        }
    };
    private final Runnable LockRunable = new Runnable() { // from class: com.dw.launcher.ui.dashboard.BaseDashboard$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            BaseDashboard.LockRunable$lambda$7(this.f$0);
        }
    };

    @SoundPoolAnnotion
    public static /* synthetic */ void getSoundEffect$annotations() {
    }

    public void move(boolean up) {
    }

    public abstract void onShortcutsChanged(List<Shortcut> shortcuts);

    public final SensorComponent getMSensorComponent() {
        SensorComponent sensorComponent = this.mSensorComponent;
        if (sensorComponent != null) {
            return sensorComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSensorComponent");
        return null;
    }

    public final void setMSensorComponent(SensorComponent sensorComponent) {
        Intrinsics.checkNotNullParameter(sensorComponent, "<set-?>");
        this.mSensorComponent = sensorComponent;
    }

    public final SoundEffect getSoundEffect() {
        SoundEffect soundEffect = this.soundEffect;
        if (soundEffect != null) {
            return soundEffect;
        }
        Intrinsics.throwUninitializedPropertyAccessException("soundEffect");
        return null;
    }

    public final void setSoundEffect(SoundEffect soundEffect) {
        Intrinsics.checkNotNullParameter(soundEffect, "<set-?>");
        this.soundEffect = soundEffect;
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

    public final LauncherPreference getMPreference() {
        LauncherPreference launcherPreference = this.mPreference;
        if (launcherPreference != null) {
            return launcherPreference;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPreference");
        return null;
    }

    public final void setMPreference(LauncherPreference launcherPreference) {
        Intrinsics.checkNotNullParameter(launcherPreference, "<set-?>");
        this.mPreference = launcherPreference;
    }

    public final NoDisturbComponent getNoDisturbComponent() {
        NoDisturbComponent noDisturbComponent = this.noDisturbComponent;
        if (noDisturbComponent != null) {
            return noDisturbComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("noDisturbComponent");
        return null;
    }

    public final void setNoDisturbComponent(NoDisturbComponent noDisturbComponent) {
        Intrinsics.checkNotNullParameter(noDisturbComponent, "<set-?>");
        this.noDisturbComponent = noDisturbComponent;
    }

    public final TaskShowLayout getRlTaskShow() {
        return this.rlTaskShow;
    }

    public final void setRlTaskShow(TaskShowLayout taskShowLayout) {
        this.rlTaskShow = taskShowLayout;
    }

    /* JADX INFO: renamed from: isVisble, reason: from getter */
    public final boolean getIsVisble() {
        return this.isVisble;
    }

    public final void setVisble(boolean z) {
        this.isVisble = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mScheduleToStopRingtoneTask$lambda$0(BaseDashboard this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSoundEffect().stop();
    }

    protected final RecyclerView.OnScrollListener getDefaultSoundEffectListener() {
        return this.defaultSoundEffectListener;
    }

    @Override // com.dw.launcher.ui.dashboard.Hilt_BaseDashboard
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        ViewModelStoreOwner viewModelStoreOwnerRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(viewModelStoreOwnerRequireActivity, "requireActivity(...)");
        this.viewModel = (DashboardViewModel) new ViewModelProvider(viewModelStoreOwnerRequireActivity).get(DashboardViewModel.class);
        getWallpaperComponent().addObserver(this);
        Timber.INSTANCE.d("----onAttach  observerNum: " + getWallpaperComponent().countObservers(), new Object[0]);
    }

    public void onDetach() {
        super.onDetach();
        getWallpaperComponent().deleteObserver(this);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        log("----onViewCreated");
        DashboardViewModel dashboardViewModel = this.viewModel;
        if (dashboardViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dashboardViewModel = null;
        }
        dashboardViewModel.getShortcuts().observe(getViewLifecycleOwner(), new BaseDashboard$sam$androidx_lifecycle_Observer$0(new Function1<List<Shortcut>, Unit>() { // from class: com.dw.launcher.ui.dashboard.BaseDashboard.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<Shortcut> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Shortcut> list) {
                BaseDashboard baseDashboard = BaseDashboard.this;
                Intrinsics.checkNotNull(list);
                baseDashboard.onShortcutsChanged(list);
            }
        }));
        getNoDisturbComponent().addWatchModeChangedListener(this);
        getNoDisturbComponent().addAppLockListener(this);
    }

    public final List<Shortcut> getShortcuts() {
        DashboardViewModel dashboardViewModel = this.viewModel;
        if (dashboardViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dashboardViewModel = null;
        }
        List<Shortcut> list = (List) dashboardViewModel.getShortcuts().getValue();
        return list != null ? list : new ArrayList();
    }

    public void onShortcutClicked(Shortcut shortcut) {
        Intrinsics.checkNotNullParameter(shortcut, "shortcut");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        shortcut.onClicked(contextRequireContext);
    }

    public void onShortcutLongClicked(Shortcut shortcut) {
        Intrinsics.checkNotNullParameter(shortcut, "shortcut");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        shortcut.onLongClicked(contextRequireContext);
    }

    public void onResume() {
        super.onResume();
        this.isVisble = true;
        getMSensorComponent().register(this);
    }

    public void onPause() {
        super.onPause();
        this.isVisble = false;
        getMSensorComponent().unregister();
    }

    public boolean onSensorChanged(boolean up) {
        Window window;
        cancelScreenFlagTask();
        move(up);
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return true;
        }
        window.addFlags(128);
        return true;
    }

    public void onSensorStopped() {
        closeScreenFlagTask();
    }

    protected final void log(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Timber.INSTANCE.i(getClass().getName() + '\t' + msg, new Object[0]);
    }

    public final void startRingtone() {
        if (!getSoundEffect().isPlaying()) {
            getSoundEffect().start();
        }
        this.mHandler.removeCallbacks(this.mScheduleToStopRingtoneTask);
        this.mHandler.postDelayed(this.mScheduleToStopRingtoneTask, 200L);
    }

    public final void stopRingtone() {
        this.mHandler.removeCallbacks(this.mScheduleToStopRingtoneTask);
        this.mHandler.postDelayed(this.mScheduleToStopRingtoneTask, 200L);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return super.onKeyDown(keyCode, event);
    }

    public final Drawable loadDrawable(String path) {
        String absolutePath;
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            File externalFilesDir = requireContext().getExternalFilesDir("customWallPaper");
            if (Intrinsics.areEqual((Object) ((externalFilesDir == null || (absolutePath = externalFilesDir.getAbsolutePath()) == null) ? null : Boolean.valueOf(StringsKt.startsWith$default(path, absolutePath, false, 2, (Object) null))), (Object) true) | StringsKt.startsWith$default(path, SkinConfig.WALLPAPER_DIR, false, 2, (Object) null)) {
                if (StringsKt.endsWith$default(path, ".gif", false, 2, (Object) null)) {
                    return new GifDrawable(new File(path));
                }
                return new BitmapDrawable(requireContext().getResources(), BitmapFactory.decodeFile(path));
            }
            if (StringsKt.endsWith$default(path, ".gif", false, 2, (Object) null)) {
                return new GifDrawable(requireContext().getAssets().open(path));
            }
            return Drawable.createFromStream(requireContext().getAssets().open(path), null);
        } catch (Exception unused) {
            String string = getString(R.string.default_wallpaper);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Timber.INSTANCE.d("defaultWallpaper: " + string, new Object[0]);
            if (StringsKt.endsWith$default(string, ".gif", false, 2, (Object) null)) {
                return new GifDrawable(requireContext().getAssets().open(path));
            }
            return Drawable.createFromStream(requireContext().getAssets().open(string), null);
        }
    }

    @Override // java.util.Observer
    public void update(Observable o, Object arg) {
        Timber.INSTANCE.d("----update", new Object[0]);
    }

    public final void showSlideUpTask(final ViewGroup parent) {
        if (parent != null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.dw.recents", "com.dw.recents.presentation.view.activity.TaskListActivity"));
            AppFilterConfig appFilterConfig = AppFilterConfig.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            if (appFilterConfig.isIntentAvailable(contextRequireContext, intent) && getMPreference().showSlideTask()) {
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                TaskShowLayout taskShowLayout = new TaskShowLayout(contextRequireContext2, null, 0, 6, null);
                this.rlTaskShow = taskShowLayout;
                parent.addView(taskShowLayout);
                TaskShowLayout taskShowLayout2 = this.rlTaskShow;
                if (taskShowLayout2 != null) {
                    taskShowLayout2.show();
                }
                TaskShowLayout taskShowLayout3 = this.rlTaskShow;
                if (taskShowLayout3 != null) {
                    taskShowLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.dashboard.BaseDashboard$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BaseDashboard.showSlideUpTask$lambda$6$lambda$5(this.f$0, parent, view);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSlideUpTask$lambda$6$lambda$5(final BaseDashboard this$0, final ViewGroup viewGroup, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMPreference().setShowSlideTask(false);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this$0.rlTaskShow, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.dw.launcher.ui.dashboard.BaseDashboard$showSlideUpTask$1$1$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                TaskShowLayout rlTaskShow = this.this$0.getRlTaskShow();
                if (rlTaskShow != null) {
                    rlTaskShow.hide();
                }
                ViewGroup viewGroup2 = viewGroup;
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.this$0.getRlTaskShow());
                }
            }
        });
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.start();
    }

    public void onDestroyView() {
        super.onDestroyView();
        getNoDisturbComponent().removeWatchModeChangedListener(this);
        getNoDisturbComponent().removeAppLockListener(this);
    }

    public void onWatchModeChanged(int mode) {
        Timber.INSTANCE.d("----onWatchModeChanged: " + mode, new Object[0]);
        DashboardViewModel dashboardViewModel = this.viewModel;
        if (dashboardViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dashboardViewModel = null;
        }
        dashboardViewModel.reload();
    }

    public void onAppLockChanged() {
        this.mHandler.removeCallbacks(this.LockRunable);
        this.mHandler.postDelayed(this.LockRunable, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LockRunable$lambda$7(BaseDashboard this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DashboardViewModel dashboardViewModel = this$0.viewModel;
        if (dashboardViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dashboardViewModel = null;
        }
        dashboardViewModel.reload();
    }
}
