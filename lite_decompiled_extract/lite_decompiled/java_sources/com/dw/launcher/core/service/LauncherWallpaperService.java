package com.dw.launcher.core.service;

import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.R;
import com.dw.launcher.data.preference.LauncherPreference;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import pl.droidsonroids.gif.GifDrawable;
import timber.log.Timber;

/* JADX INFO: compiled from: LauncherWallpaperService.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\f\u0010\u000b\u001a\u00060\fR\u00020\u0001H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/dw/launcher/core/service/LauncherWallpaperService;", "Landroid/service/wallpaper/WallpaperService;", "()V", "preference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "getPreference", "()Lcom/dw/launcher/data/preference/LauncherPreference;", "setPreference", "(Lcom/dw/launcher/data/preference/LauncherPreference;)V", "onCreate", BuildConfig.FLAVOR, "onCreateEngine", "Landroid/service/wallpaper/WallpaperService$Engine;", "GifEngine", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class LauncherWallpaperService extends Hilt_LauncherWallpaperService {

    @Inject
    public LauncherPreference preference;

    public final LauncherPreference getPreference() {
        LauncherPreference launcherPreference = this.preference;
        if (launcherPreference != null) {
            return launcherPreference;
        }
        Intrinsics.throwUninitializedPropertyAccessException("preference");
        return null;
    }

    public final void setPreference(LauncherPreference launcherPreference) {
        Intrinsics.checkNotNullParameter(launcherPreference, "<set-?>");
        this.preference = launcherPreference;
    }

    @Override // com.dw.launcher.core.service.Hilt_LauncherWallpaperService, android.service.wallpaper.WallpaperService, android.app.Service
    public void onCreate() {
        super.onCreate();
        Timber.Forest.i("----onCreate preference : " + getPreference(), new Object[0]);
    }

    @Override // android.service.wallpaper.WallpaperService
    public WallpaperService.Engine onCreateEngine() {
        return new GifEngine();
    }

    /* JADX INFO: compiled from: LauncherWallpaperService.kt */
    @Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\r\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/dw/launcher/core/service/LauncherWallpaperService$GifEngine;", "Landroid/service/wallpaper/WallpaperService$Engine;", "Landroid/service/wallpaper/WallpaperService;", "(Lcom/dw/launcher/core/service/LauncherWallpaperService;)V", "drawable", "Landroid/graphics/drawable/Drawable;", "mHandler", "Landroid/os/Handler;", "mHolder", BuildConfig.FLAVOR, "mLastWallpaper", BuildConfig.FLAVOR, "scheduleDrawNextFrame", "com/dw/launcher/core/service/LauncherWallpaperService$GifEngine$scheduleDrawNextFrame$1", "Lcom/dw/launcher/core/service/LauncherWallpaperService$GifEngine$scheduleDrawNextFrame$1;", "drawFrame", BuildConfig.FLAVOR, "loadDrawable", "path", "onCreate", "surfaceHolder", "Landroid/view/SurfaceHolder;", "onSurfaceCreated", "holder", "onSurfaceDestroyed", "onVisibilityChanged", "visible", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class GifEngine extends WallpaperService.Engine {
        private Drawable drawable;
        private Handler mHandler;
        private boolean mHolder;
        private String mLastWallpaper;
        private final LauncherWallpaperService$GifEngine$scheduleDrawNextFrame$1 scheduleDrawNextFrame;

        /* JADX WARN: Type inference failed for: r2v3, types: [com.dw.launcher.core.service.LauncherWallpaperService$GifEngine$scheduleDrawNextFrame$1] */
        public GifEngine() {
            super(LauncherWallpaperService.this);
            this.mHandler = new Handler(Looper.getMainLooper());
            this.scheduleDrawNextFrame = new Runnable() { // from class: com.dw.launcher.core.service.LauncherWallpaperService$GifEngine$scheduleDrawNextFrame$1
                @Override // java.lang.Runnable
                public void run() {
                    GifDrawable gifDrawable = this.this$0.drawable;
                    if (gifDrawable != null) {
                        LauncherWallpaperService.GifEngine gifEngine = this.this$0;
                        if (gifDrawable instanceof GifDrawable) {
                            GifDrawable gifDrawable2 = gifDrawable;
                            int frameDuration = gifDrawable2.getFrameDuration(gifDrawable2.getCurrentFrameIndex());
                            LauncherWallpaperService$GifEngine$scheduleDrawNextFrame$1 launcherWallpaperService$GifEngine$scheduleDrawNextFrame$1 = this;
                            gifEngine.mHandler.removeCallbacks(launcherWallpaperService$GifEngine$scheduleDrawNextFrame$1);
                            gifEngine.mHandler.postDelayed(launcherWallpaperService$GifEngine$scheduleDrawNextFrame$1, frameDuration);
                        }
                        gifEngine.drawFrame(gifDrawable);
                    }
                }
            };
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onCreate(SurfaceHolder surfaceHolder) {
            Intrinsics.checkNotNullParameter(surfaceHolder, "surfaceHolder");
            super.onCreate(surfaceHolder);
            Timber.Forest.i("----onCreate", new Object[0]);
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onVisibilityChanged(boolean visible) {
            super.onVisibilityChanged(visible);
            Timber.Forest.i("----onVisibleChanged: " + visible, new Object[0]);
            if (visible) {
                if (this.drawable == null || !Intrinsics.areEqual(this.mLastWallpaper, LauncherWallpaperService.this.getPreference().getWallpaper())) {
                    this.drawable = loadDrawable(LauncherWallpaperService.this.getPreference().getWallpaper());
                }
                Timber.Forest.i("----drawable: " + this.drawable + ", mLastWallpaper: " + this.mLastWallpaper, new Object[0]);
                Drawable drawable = this.drawable;
                if (drawable != null) {
                    if (drawable instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
                        if (!animationDrawable.isRunning()) {
                            animationDrawable.start();
                        }
                    }
                    drawFrame(drawable);
                }
            }
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceCreated(SurfaceHolder holder) {
            super.onSurfaceCreated(holder);
            this.mHolder = true;
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
            this.mHolder = false;
            this.mHandler.removeCallbacks(this.scheduleDrawNextFrame);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void drawFrame(Drawable drawable) {
            Canvas canvasLockCanvas;
            SurfaceHolder surfaceHolder = getSurfaceHolder();
            if (this.mHolder && (canvasLockCanvas = surfaceHolder.lockCanvas()) != null) {
                LauncherWallpaperService launcherWallpaperService = LauncherWallpaperService.this;
                try {
                    canvasLockCanvas.save();
                    drawable.setBounds(0, 0, launcherWallpaperService.getResources().getDisplayMetrics().widthPixels, launcherWallpaperService.getResources().getDisplayMetrics().heightPixels);
                    drawable.draw(canvasLockCanvas);
                    if (drawable instanceof GifDrawable) {
                        int frameDuration = ((GifDrawable) drawable).getFrameDuration(((GifDrawable) drawable).getCurrentFrameIndex());
                        this.mHandler.removeCallbacks(this.scheduleDrawNextFrame);
                        this.mHandler.postDelayed(this.scheduleDrawNextFrame, frameDuration);
                    }
                    canvasLockCanvas.restore();
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvasLockCanvas);
                }
            }
        }

        private final Drawable loadDrawable(String path) {
            try {
                this.mLastWallpaper = path;
                if (StringsKt.endsWith$default(path, ".gif", false, 2, (Object) null)) {
                    return new GifDrawable(LauncherWallpaperService.this.getAssets().open(path));
                }
                return Drawable.createFromStream(LauncherWallpaperService.this.getAssets().open(path), null);
            } catch (Exception unused) {
                String string = LauncherWallpaperService.this.getString(R.string.default_wallpaper);
                this.mLastWallpaper = string;
                Intrinsics.checkNotNull(string);
                if (StringsKt.endsWith$default(string, ".gif", false, 2, (Object) null)) {
                    return new GifDrawable(LauncherWallpaperService.this.getAssets().open(path));
                }
                return Drawable.createFromStream(LauncherWallpaperService.this.getAssets().open(path), null);
            }
        }
    }
}
