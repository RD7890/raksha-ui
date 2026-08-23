package com.dw.launcher.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Toast;
import com.dw.launcher.core.skin.DialContext;
import com.google.android.mms.pdu.CharacterSets;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import timber.log.Timber;

/* JADX INFO: compiled from: DexLoaderUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\r\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ(\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000bJ(\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J(\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0015"}, d2 = {"Lcom/dw/launcher/util/DexLoaderUtils;", "", "()V", "createDwThumbBitmap", "Landroid/graphics/Bitmap;", "path", "", "context", "Landroid/content/Context;", "createThumbBitmap", "getAssetManager", "Landroid/content/res/AssetManager;", "getDialName", "getDwDialName", "getDwOnlineWatchFaceView", "Landroid/view/View;", "asset", "watchDilaId", "", "getOnlineWatchFaceView", "prepareWatchDial", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class DexLoaderUtils {
    public static final DexLoaderUtils INSTANCE = new DexLoaderUtils();

    private DexLoaderUtils() {
    }

    public final View getOnlineWatchFaceView(Context context, String path, AssetManager asset) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(asset, "asset");
        String absolutePath = context.getDir("dex", 0).getAbsolutePath();
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            if (!new File(path).exists()) {
                return null;
            }
            Class clsLoadClass = new DexClassLoader(path, absolutePath, null, classLoader).loadClass("com.tmoon.moon.tmoon_dial_plugin.ui.WatchFaceFactory");
            Object objNewInstance = clsLoadClass.newInstance();
            Method declaredMethod = clsLoadClass.getDeclaredMethod("createWatchDial", Context.class, AssetManager.class);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(objNewInstance, context, asset);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.view.View");
            return (View) objInvoke;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final Bitmap createThumbBitmap(String path) {
        String str = path;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return BitmapFactory.decodeStream(getAssetManager(path).open("thumb.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final Bitmap createDwThumbBitmap(String path, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = path;
        if (str == null || str.length() == 0) {
            return null;
        }
        AssetManager assetManager = getAssetManager(path);
        try {
            if (StringsKt.contains$default((CharSequence) SystemUtils.INSTANCE.getLanguage(context), (CharSequence) "zh", false, 2, (Object) null)) {
                return BitmapFactory.decodeStream(assetManager.open("clock/thumb.png"));
            }
            String[] list = assetManager.list("clock/en");
            if (!(list != null ? ArraysKt.contains(list, "thumb.png") : false)) {
                return BitmapFactory.decodeStream(assetManager.open("clock/thumb.png"));
            }
            return BitmapFactory.decodeStream(assetManager.open("clock/en/thumb.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final AssetManager getAssetManager(String path) throws IllegalAccessException, InstantiationException {
        Intrinsics.checkNotNullParameter(path, "path");
        Log.w("DexLoaderUtils", "AssetManager path = " + path);
        Object objNewInstance = AssetManager.class.newInstance();
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type android.content.res.AssetManager");
        AssetManager assetManager = (AssetManager) objNewInstance;
        if (path.length() == 0) {
            return assetManager;
        }
        try {
            Method declaredMethod = assetManager.getClass().getDeclaredMethod("addAssetPath", String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(assetManager, path);
            return assetManager;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Log.w("DexLoaderUtils", "AssetManager e = " + e.getMessage());
            return assetManager;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            Log.w("DexLoaderUtils", "AssetManager e = " + e2.getMessage());
            return assetManager;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            Log.w("DexLoaderUtils", "AssetManager e = " + e3.getMessage());
            return assetManager;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            Log.w("DexLoaderUtils", "AssetManager e = " + e4.getMessage());
            return assetManager;
        }
    }

    public final String getDialName(String path) {
        String str = path;
        if (str != null && str.length() != 0) {
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            try {
                xmlPullParserNewPullParser.setInput(getAssetManager(path).open("watch_config.xml"), "utf-8");
                while (xmlPullParserNewPullParser.getEventType() != 1) {
                    if (xmlPullParserNewPullParser.getEventType() == 2) {
                        Log.d("wlf", "FaceInfoParse: " + xmlPullParserNewPullParser.getName());
                        if (Intrinsics.areEqual(xmlPullParserNewPullParser.getName(), "name")) {
                            String strNextText = xmlPullParserNewPullParser.nextText();
                            Intrinsics.checkNotNullExpressionValue(strNextText, "nextText(...)");
                            return strNextText;
                        }
                    }
                    xmlPullParserNewPullParser.next();
                }
            } catch (Exception e) {
                Log.d("wlf", "FaceInfoParse: ex " + e.getMessage());
            }
        }
        return "";
    }

    public final String getDwDialName(String path, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = path;
        if (str != null && str.length() != 0) {
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            try {
                xmlPullParserNewPullParser.setInput(getAssetManager(path).open("clock/DialConf.xml"), "utf-8");
                String language = SystemUtils.INSTANCE.getLanguage(context);
                String strNextText = "";
                while (xmlPullParserNewPullParser.getEventType() != 1) {
                    if (xmlPullParserNewPullParser.getEventType() == 2) {
                        Log.d("wlf", "FaceInfoParse: " + xmlPullParserNewPullParser.getName());
                        String name = xmlPullParserNewPullParser.getName();
                        if (Intrinsics.areEqual(name, "name")) {
                            strNextText = xmlPullParserNewPullParser.nextText();
                            Intrinsics.checkNotNullExpressionValue(strNextText, "nextText(...)");
                            if (StringsKt.contains$default((CharSequence) language, (CharSequence) "zh", false, 2, (Object) null)) {
                                return strNextText;
                            }
                        } else if (Intrinsics.areEqual(name, "name_en")) {
                            String strNextText2 = xmlPullParserNewPullParser.nextText();
                            Intrinsics.checkNotNull(strNextText2);
                            return (strNextText2.length() <= 0 || !StringsKt.contains$default((CharSequence) language, (CharSequence) "zh", false, 2, (Object) null)) ? strNextText2 : strNextText;
                        }
                    }
                    xmlPullParserNewPullParser.next();
                }
            } catch (Exception e) {
                Log.d("wlf", "FaceInfoParse: ex " + e.getMessage());
            }
        }
        return "";
    }

    public final View getOnlineWatchFaceView(Context context, String path, AssetManager asset, int watchDilaId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(asset, "asset");
        String absolutePath = context.getDir("dex", 0).getAbsolutePath();
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            try {
                if (!new File(path).exists()) {
                    Toast.makeText(context, "文件不存在", 0).show();
                    return null;
                }
                Class clsLoadClass = new DexClassLoader(path, absolutePath, null, classLoader).loadClass("com.tmoon.moon.tmoon_dial_plugin.ui.WatchFaceFactory");
                Object objNewInstance = clsLoadClass.newInstance();
                Method declaredMethod = clsLoadClass.getDeclaredMethod("createWatchDial", Context.class, AssetManager.class, Integer.TYPE);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(objNewInstance, context, asset, Integer.valueOf(watchDilaId));
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.view.View");
                return (View) objInvoke;
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception unused2) {
            return getOnlineWatchFaceView(context, path, asset);
        }
    }

    public final View prepareWatchDial(Context context, String path, AssetManager asset, int watchDilaId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(asset, "asset");
        String absolutePath = context.getDir("dex", 0).getAbsolutePath();
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            if (!new File(path).exists()) {
                return null;
            }
            Class clsLoadClass = new DexClassLoader(path, absolutePath, null, classLoader).loadClass("com.tmoon.moon.tmoon_dial_plugin.ui.WatchFaceFactory");
            Object objNewInstance = clsLoadClass.newInstance();
            Method declaredMethod = clsLoadClass.getDeclaredMethod("prepareWatchDial", Context.class, Integer.TYPE, AssetManager.class);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(objNewInstance, context, Integer.valueOf(watchDilaId), asset);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.view.View");
            return (View) objInvoke;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public final View getDwOnlineWatchFaceView(Context context, String path, AssetManager asset, int watchDilaId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(asset, "asset");
        String absolutePath = context.getDir("dex", 0).getAbsolutePath();
        ClassLoader classLoader = getClass().getClassLoader();
        Timber.INSTANCE.d("开始加载: " + path, new Object[0]);
        try {
            if (!new File(path).exists()) {
                Toast.makeText(context, "文件不存在", 0).show();
                return null;
            }
            Class clsLoadClass = new DexClassLoader(path, absolutePath, null, classLoader).loadClass("com.dwiot.watchface.view.WatchFactory");
            Object objNewInstance = clsLoadClass.newInstance();
            Method declaredMethod = clsLoadClass.getDeclaredMethod("createWatchDial", Context.class, Integer.TYPE);
            declaredMethod.setAccessible(true);
            DialContext dialContext = new DialContext(context);
            dialContext.setAssetManager(asset);
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            dialContext.setResources(resources);
            Object objInvoke = declaredMethod.invoke(objNewInstance, dialContext, Integer.valueOf(watchDilaId));
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.view.View");
            return (View) objInvoke;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
