package com.dw.launcher.core.skin;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dw.launcher.core.skin.config.SkinConfig;
import com.dw.launcher.core.skin.listener.ILoaderListener;
import com.dw.launcher.core.skin.listener.ISkinLoader;
import com.dw.launcher.core.skin.listener.ISkinUpdate;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import timber.log.Timber;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public class SkinThemeManager implements ISkinLoader {
    private static final String NOT_INIT_ERROR = "SkinManager MUST init with Context first";
    private static SkinThemeManager instance;
    private static Object synchronizedLock = new Object();
    private AssetManager assetManager;
    private Context context;
    private boolean isDefaultSkin = false;
    private Resources mResources;
    private List<ISkinUpdate> skinObservers;
    private String skinPackageName;
    private String skinPath;

    public boolean isExternalSkin() {
        return (this.isDefaultSkin || this.mResources == null) ? false : true;
    }

    public String getSkinPath() {
        return this.skinPath;
    }

    public static SkinThemeManager getInstance() {
        if (instance == null) {
            synchronized (synchronizedLock) {
                if (instance == null) {
                    instance = new SkinThemeManager();
                }
            }
        }
        return instance;
    }

    public String getSkinPackageName() {
        return this.skinPackageName;
    }

    public Resources getResources() {
        return this.mResources;
    }

    private SkinThemeManager() {
    }

    public void init(Context ctx) {
        this.context = ctx.getApplicationContext();
    }

    public void restoreDefaultTheme() {
        SkinConfig.saveSkinPath(this.context, SkinConfig.DEFAULT_SKIN);
        this.isDefaultSkin = true;
        this.mResources = this.context.getResources();
        notifySkinUpdate();
    }

    public void load() {
        load(SkinConfig.getCustomSkinPath(this.context), null);
    }

    public void load(ILoaderListener callback) {
        String customSkinPath = SkinConfig.getCustomSkinPath(this.context);
        if (SkinConfig.isDefaultSkin(this.context)) {
            return;
        }
        load(customSkinPath, callback);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.dw.launcher.core.skin.SkinThemeManager$1] */
    public void load(String skinPackagePath, final ILoaderListener callback) {
        new AsyncTask<String, Void, Resources>() { // from class: com.dw.launcher.core.skin.SkinThemeManager.1
            @Override // android.os.AsyncTask
            protected void onPreExecute() {
                ILoaderListener iLoaderListener = callback;
                if (iLoaderListener != null) {
                    iLoaderListener.onStart();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Resources doInBackground(String... params) {
                try {
                    if (params.length != 1) {
                        return null;
                    }
                    String str = params[0];
                    if (!new File(str).exists()) {
                        return null;
                    }
                    SkinThemeManager.this.skinPackageName = SkinThemeManager.this.context.getPackageManager().getPackageArchiveInfo(str, 1).packageName;
                    SkinThemeManager.this.assetManager = (AssetManager) AssetManager.class.newInstance();
                    SkinThemeManager.this.assetManager.getClass().getMethod("addAssetPath", String.class).invoke(SkinThemeManager.this.assetManager, str);
                    Resources resources = SkinThemeManager.this.context.getResources();
                    Resources resources2 = new Resources(SkinThemeManager.this.assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    SkinConfig.saveSkinPath(SkinThemeManager.this.context, str);
                    SkinThemeManager.this.skinPath = str;
                    SkinThemeManager.this.isDefaultSkin = false;
                    return resources2;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(Resources result) {
                SkinThemeManager.this.mResources = result;
                if (SkinThemeManager.this.mResources == null) {
                    SkinThemeManager.this.isDefaultSkin = true;
                    ILoaderListener iLoaderListener = callback;
                    if (iLoaderListener != null) {
                        iLoaderListener.onFailed();
                        return;
                    }
                    return;
                }
                ILoaderListener iLoaderListener2 = callback;
                if (iLoaderListener2 != null) {
                    iLoaderListener2.onSuccess();
                }
                SkinThemeManager.this.notifySkinUpdate();
            }
        }.execute(skinPackagePath);
    }

    @Override // com.dw.launcher.core.skin.listener.ISkinLoader
    public void attach(ISkinUpdate observer) {
        if (this.skinObservers == null) {
            this.skinObservers = new ArrayList();
        }
        List<ISkinUpdate> list = this.skinObservers;
        if (list.contains(list)) {
            return;
        }
        this.skinObservers.add(observer);
    }

    @Override // com.dw.launcher.core.skin.listener.ISkinLoader
    public void detach(ISkinUpdate observer) {
        List<ISkinUpdate> list = this.skinObservers;
        if (list != null && list.contains(observer)) {
            this.skinObservers.remove(observer);
        }
    }

    @Override // com.dw.launcher.core.skin.listener.ISkinLoader
    public void notifySkinUpdate() {
        List<ISkinUpdate> list = this.skinObservers;
        if (list == null) {
            return;
        }
        Iterator<ISkinUpdate> it = list.iterator();
        while (it.hasNext()) {
            it.next().onThemeUpdate();
        }
    }

    public int getColor(int resId) {
        int color = this.context.getResources().getColor(resId);
        if (this.mResources == null || this.isDefaultSkin) {
            return color;
        }
        try {
            return this.mResources.getColor(this.mResources.getIdentifier(this.context.getResources().getResourceEntryName(resId), TypedValues.Custom.S_COLOR, this.skinPackageName));
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return color;
        }
    }

    public Drawable getAssertDrawable(String fileName) {
        AssetManager assetManager = this.assetManager;
        if (assetManager == null) {
            return null;
        }
        try {
            return BitmapDrawable.createFromStream(assetManager.open(fileName), null);
        } catch (IOException unused) {
            return null;
        }
    }

    public String getString(int resId) {
        String string = this.context.getResources().getString(resId);
        if (this.mResources == null || this.isDefaultSkin) {
            return string;
        }
        try {
            return this.mResources.getString(this.mResources.getIdentifier(this.context.getResources().getResourceEntryName(resId), TypedValues.Custom.S_STRING, this.skinPackageName));
        } catch (Resources.NotFoundException unused) {
            return string;
        }
    }

    public Drawable getDrawable(int resId) {
        Drawable drawable = this.context.getResources().getDrawable(resId);
        if (this.mResources == null || this.isDefaultSkin) {
            return drawable;
        }
        try {
            return this.mResources.getDrawable(this.mResources.getIdentifier(this.context.getResources().getResourceEntryName(resId), "drawable", this.skinPackageName), null);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return drawable;
        }
    }

    public ColorStateList convertToColorStateList(int resId) {
        Timber.d("attr1   convertToColorStateList", new Object[0]);
        boolean z = (this.mResources == null || this.isDefaultSkin) ? false : true;
        String resourceEntryName = this.context.getResources().getResourceEntryName(resId);
        Timber.d("attr1   resName = " + resourceEntryName, new Object[0]);
        if (z) {
            Timber.d("attr1   isExtendSkin", new Object[0]);
            int identifier = this.mResources.getIdentifier(resourceEntryName, TypedValues.Custom.S_COLOR, this.skinPackageName);
            Timber.d("attr1   trueResId = " + identifier, new Object[0]);
            if (identifier == 0) {
                try {
                    return this.context.getResources().getColorStateList(resId);
                } catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                    Timber.d("resName = " + resourceEntryName + " NotFoundException : " + e.getMessage(), new Object[0]);
                }
            } else {
                try {
                    ColorStateList colorStateList = this.mResources.getColorStateList(identifier);
                    Timber.d("attr1   trueColorList = " + colorStateList, new Object[0]);
                    return colorStateList;
                } catch (Resources.NotFoundException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            try {
                return this.context.getResources().getColorStateList(resId);
            } catch (Resources.NotFoundException e3) {
                e3.printStackTrace();
            }
        }
        return new ColorStateList((int[][]) Array.newInstance((Class<?>) Integer.TYPE, 1, 1), new int[]{this.context.getResources().getColor(resId)});
    }

    public AssetManager getAssetManager(String skinPath) {
        if (!new File(skinPath).exists()) {
            return null;
        }
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            AssetManager.class.getMethod("addAssetPath", String.class).invoke(assetManager, skinPath);
            return assetManager;
        } catch (Exception unused) {
            return null;
        }
    }

    public Resources getResourceByAssetManager(AssetManager assetManager) {
        return new Resources(assetManager, this.context.getResources().getDisplayMetrics(), this.context.getResources().getConfiguration());
    }
}
