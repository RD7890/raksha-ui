package com.dw.launcher.ui.shortcut;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.dw.launcher.R;
import com.dw.launcher.core.skin.config.SkinConfig;
import com.dw.launcher.data.entity.Shortcut;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.ui.view.CircleDrawable;
import com.google.android.mms.pdu.CharacterSets;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

/* JADX INFO: compiled from: ShortcutInflater.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0006\u0010\u001e\u001a\u00020\u0019R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/dw/launcher/ui/shortcut/ShortcutInflater;", "", "context", "Landroid/content/Context;", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "(Landroid/content/Context;Lcom/dw/launcher/data/repository/LauncherRepository;)V", "ICON_MAP", "", "", "Landroid/graphics/drawable/Drawable;", "isRoundStyle", "", "()Z", "setRoundStyle", "(Z)V", "loadFromBySystem", "mLoaded", "drawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "getDrawable", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "inflate", "", "shortcut", "Lcom/dw/launcher/data/entity/Shortcut;", "inflateByIconMap", "load", "reset", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ShortcutInflater {
    private final Map<String, Drawable> ICON_MAP;
    private final Context context;
    private boolean isRoundStyle;
    private final LauncherRepository launcherRepository;
    private boolean loadFromBySystem;
    private boolean mLoaded;

    @Inject
    public ShortcutInflater(Context context, LauncherRepository launcherRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(launcherRepository, "launcherRepository");
        this.context = context;
        this.launcherRepository = launcherRepository;
        this.ICON_MAP = new LinkedHashMap();
        this.isRoundStyle = true;
    }

    /* JADX INFO: renamed from: isRoundStyle, reason: from getter */
    public final boolean getIsRoundStyle() {
        return this.isRoundStyle;
    }

    public final void setRoundStyle(boolean z) {
        this.isRoundStyle = z;
    }

    private final void load() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        int identifier;
        String customSkinPath = SkinConfig.getCustomSkinPath(this.context);
        String packageName = this.context.getPackageName();
        Resources resources = this.context.getResources();
        if (new File(customSkinPath).exists()) {
            PackageInfo packageArchiveInfo = this.context.getPackageManager().getPackageArchiveInfo(customSkinPath, 1);
            Intrinsics.checkNotNull(packageArchiveInfo);
            packageName = packageArchiveInfo.packageName;
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            Method method = assetManager.getClass().getMethod("addAssetPath", String.class);
            Intrinsics.checkNotNullExpressionValue(method, "getMethod(...)");
            method.invoke(assetManager, customSkinPath);
            Resources resources2 = this.context.getResources();
            resources = new Resources(assetManager, resources2.getDisplayMetrics(), resources2.getConfiguration());
        }
        String[] stringArray = this.context.getResources().getStringArray(R.array.app_package_or_classname_and_icon_name3);
        Intrinsics.checkNotNull(stringArray);
        for (String str : stringArray) {
            try {
                Intrinsics.checkNotNull(str);
                List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"/"}, false, 0, 6, (Object) null);
                if (listSplit$default.size() == 2 && (identifier = resources.getIdentifier(String.valueOf(listSplit$default.get(1)), "drawable", packageName)) > 0) {
                    Drawable drawable = resources.getDrawable(identifier, null);
                    Timber.INSTANCE.d("----" + str + ", " + drawable + "  identifier: " + identifier, new Object[0]);
                    if (drawable != null) {
                        this.ICON_MAP.put((String) listSplit$default.get(0), drawable);
                    }
                }
            } catch (Exception e) {
                Timber.INSTANCE.e(e, "----load icon map failure, " + str, new Object[0]);
            }
        }
    }

    public final void reset() {
        this.mLoaded = false;
    }

    public final void inflate(Shortcut shortcut) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ActivityInfo activityInfo;
        Intrinsics.checkNotNullParameter(shortcut, "shortcut");
        if (!this.mLoaded) {
            load();
            this.mLoaded = true;
        }
        ResolveInfo resolveInfo = shortcut.getResolveInfo();
        String str = (resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null) ? null : activityInfo.name;
        Timber.INSTANCE.v("----className: " + str + "  packageName: " + shortcut.getPackageName() + " label: " + ((Object) shortcut.getLabel()), new Object[0]);
        Drawable drawable = this.ICON_MAP.get(str);
        if (drawable != null) {
            shortcut.setCustomIcon(drawable);
            return;
        }
        Drawable icon = shortcut.getIcon();
        if (icon != null) {
            CircleDrawable circleDrawable = this.ICON_MAP.get(shortcut.getPackageName());
            if (circleDrawable == null) {
                circleDrawable = new CircleDrawable(drawableToBitmap(icon));
            }
            shortcut.setCustomIcon(circleDrawable);
        }
    }

    public final void inflateByIconMap(Shortcut shortcut) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ActivityInfo activityInfo;
        Intrinsics.checkNotNullParameter(shortcut, "shortcut");
        if (!this.mLoaded) {
            load();
            this.mLoaded = true;
        }
        ResolveInfo resolveInfo = shortcut.getResolveInfo();
        String str = (resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null) ? null : activityInfo.name;
        Timber.INSTANCE.v("----className: " + str + "  packageName: " + shortcut.getPackageName() + " label: " + ((Object) shortcut.getLabel()), new Object[0]);
        Drawable drawable = this.ICON_MAP.get(str);
        if (drawable != null) {
            shortcut.setCustomIcon(drawable);
        } else {
            if (this.ICON_MAP.get(shortcut.getPackageName()) == null || shortcut.getIcon() != null) {
                return;
            }
            shortcut.setCustomIcon(this.ICON_MAP.get(shortcut.getPackageName()));
        }
    }

    public final Drawable getDrawable(ResolveInfo resolveInfo) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(resolveInfo, "resolveInfo");
        if (!this.mLoaded) {
            load();
            this.mLoaded = true;
        }
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        Drawable drawable = this.ICON_MAP.get(activityInfo != null ? activityInfo.name : null);
        if (drawable != null) {
            return drawable;
        }
        Map<String, Drawable> map = this.ICON_MAP;
        ActivityInfo activityInfo2 = resolveInfo.activityInfo;
        Drawable drawable2 = map.get(activityInfo2 != null ? activityInfo2.packageName : null);
        if (drawable2 != null) {
            return drawable2;
        }
        Drawable drawableLoadIcon = resolveInfo.loadIcon(this.context.getPackageManager());
        Intrinsics.checkNotNullExpressionValue(drawableLoadIcon, "loadIcon(...)");
        return new CircleDrawable(drawableToBitmap(drawableLoadIcon));
    }

    public final Bitmap drawableToBitmap(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Drawable drawable2 = this.context.getDrawable(R.drawable.icon_menu_desktop);
        Bitmap.Config config = drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        if (drawable2 != null) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight(), config);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            drawable.draw(canvas);
            Intrinsics.checkNotNull(bitmapCreateBitmap);
            return bitmapCreateBitmap;
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas2);
        Intrinsics.checkNotNull(bitmapCreateBitmap2);
        return bitmapCreateBitmap2;
    }
}
