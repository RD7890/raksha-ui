package com.dw.launcher.util;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import com.dw.launcher.data.entity.ClockConfig;
import com.google.android.mms.pdu.CharacterSets;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.io.ConstantsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J0\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018H\u0002J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ,\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\"\u001a\u00020#J*\u0010$\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020#J*\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020#R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007¨\u0006'"}, d2 = {"Lcom/dw/launcher/util/FileUtils;", "", "()V", "BloodPress_Save_Path", "", "getBloodPress_Save_Path$annotations", "getBloodPress_Save_Path", "()Ljava/lang/String;", "Breathe_Save_Path", "getBreathe_Save_Path$annotations", "getBreathe_Save_Path", "Heart_Save_Path", "getHeart_Save_Path$annotations", "getHeart_Save_Path", "Oxygen_Save_Path", "getOxygen_Save_Path$annotations", "getOxygen_Save_Path", "getAssertRealPath", "context", "Landroid/content/Context;", "config", "Lcom/dw/launcher/data/entity/ClockConfig;", "path", "files", "", "getExternalStorageDirectory", "directoryName", "getFileRealPath", "inputStreamToByteArray", "", "inputStream", "Ljava/io/InputStream;", "loadDrawable", "Landroid/graphics/drawable/Drawable;", "relativeDir", "", "loadInputStreamSource", "loadUriSource", "Landroid/net/Uri;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    @JvmStatic
    public static /* synthetic */ void getBloodPress_Save_Path$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBreathe_Save_Path$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getHeart_Save_Path$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOxygen_Save_Path$annotations() {
    }

    private FileUtils() {
    }

    public static final String getHeart_Save_Path() {
        return INSTANCE.getExternalStorageDirectory("heart");
    }

    public static final String getBloodPress_Save_Path() {
        return INSTANCE.getExternalStorageDirectory("bloodpressure");
    }

    public static final String getOxygen_Save_Path() {
        return INSTANCE.getExternalStorageDirectory("oxygen");
    }

    public static final String getBreathe_Save_Path() {
        return INSTANCE.getExternalStorageDirectory("breathe");
    }

    private final String getExternalStorageDirectory(String directoryName) {
        File file = new File(Environment.getExternalStorageDirectory(), ".Health/" + directoryName);
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    public final byte[] inputStreamToByteArray(InputStream inputStream) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                byte[] bArr = new byte[ConstantsKt.DEFAULT_BLOCK_SIZE];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        byteArrayOutputStream.write(bArr, 0, i);
                    } else {
                        byteArrayOutputStream.close();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                        return byteArray;
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e) {
                e.printStackTrace();
                byte[] bArr2 = new byte[0];
                byteArrayOutputStream.close();
                return bArr2;
            }
        } catch (Throwable th) {
            byteArrayOutputStream.close();
            throw th;
        }
    }

    public static /* synthetic */ Uri loadUriSource$default(FileUtils fileUtils, Context context, ClockConfig clockConfig, String str, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return fileUtils.loadUriSource(context, clockConfig, str, z);
    }

    public final Uri loadUriSource(Context context, ClockConfig config, String path, boolean relativeDir) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(path, "path");
        if (config.isFromAssets()) {
            String[] list = context.getAssets().list(String.valueOf(config.getPath()));
            if (relativeDir) {
                return Uri.parse("asset:///" + getAssertRealPath(context, config, path, list != null ? ArraysKt.toList(list) : null));
            }
            return Uri.parse("asset:///" + path);
        }
        if (relativeDir) {
            String[] list2 = new File(String.valueOf(config.getPath())).list();
            return Uri.fromFile(new File(getFileRealPath(context, config, path, list2 != null ? ArraysKt.toList(list2) : null)));
        }
        return Uri.fromFile(new File(path));
    }

    private final String getAssertRealPath(Context context, ClockConfig config, String path, List<String> files) throws IOException {
        boolean zContains$default = StringsKt.contains$default((CharSequence) SystemUtils.INSTANCE.getLanguage(context), (CharSequence) "zh", false, 2, (Object) null);
        String str = config.getPath() + '/' + path;
        if (zContains$default || files == null || !files.contains("en")) {
            return str;
        }
        String str2 = config.getPath() + "/en/" + path;
        String strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(str2, "/", (String) null, 2, (Object) null);
        String strSubstringAfterLast$default = StringsKt.substringAfterLast$default(str2, "/", (String) null, 2, (Object) null);
        String[] list = context.getAssets().list(strSubstringBeforeLast$default);
        if (list == null) {
            return str;
        }
        Intrinsics.checkNotNull(list);
        if (!(!(list.length == 0))) {
            return str;
        }
        Intrinsics.checkNotNull(list);
        return ArraysKt.contains(list, strSubstringAfterLast$default) ? str2 : str;
    }

    private final String getFileRealPath(Context context, ClockConfig config, String path, List<String> files) {
        boolean zContains$default = StringsKt.contains$default((CharSequence) SystemUtils.INSTANCE.getLanguage(context), (CharSequence) "zh", false, 2, (Object) null);
        String str = config.getPath() + '/' + path;
        if (zContains$default || files == null || !files.contains("en")) {
            return str;
        }
        String str2 = config.getPath() + "/en/" + path;
        String strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(str2, "/", (String) null, 2, (Object) null);
        String strSubstringAfterLast$default = StringsKt.substringAfterLast$default(str2, "/", (String) null, 2, (Object) null);
        File file = new File(strSubstringBeforeLast$default);
        File file2 = new File(file, strSubstringAfterLast$default);
        return (file.exists() && file.isDirectory() && file2.exists() && file2.isFile()) ? str2 : str;
    }

    public static /* synthetic */ InputStream loadInputStreamSource$default(FileUtils fileUtils, Context context, ClockConfig clockConfig, String str, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return fileUtils.loadInputStreamSource(context, clockConfig, str, z);
    }

    public final InputStream loadInputStreamSource(Context context, ClockConfig config, String path, boolean relativeDir) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(path, "path");
        List<String> list = null;
        if (config.isFromAssets()) {
            String[] list2 = context.getAssets().list(String.valueOf(config.getPath()));
            if (relativeDir) {
                FileUtils fileUtils = INSTANCE;
                if (list2 != null) {
                    Intrinsics.checkNotNull(list2);
                    list = ArraysKt.toList(list2);
                }
                return context.getAssets().open(fileUtils.getAssertRealPath(context, config, path, list));
            }
            return context.getAssets().open(path);
        }
        if (relativeDir) {
            File file = new File(String.valueOf(config.getPath()));
            FileUtils fileUtils2 = INSTANCE;
            String[] list3 = file.list();
            if (list3 != null) {
                Intrinsics.checkNotNull(list3);
                list = ArraysKt.toList(list3);
            }
            return new FileInputStream(fileUtils2.getFileRealPath(context, config, path, list));
        }
        return new FileInputStream(path);
    }

    public static /* synthetic */ Drawable loadDrawable$default(FileUtils fileUtils, Context context, ClockConfig clockConfig, String str, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return fileUtils.loadDrawable(context, clockConfig, str, z);
    }

    public final Drawable loadDrawable(Context context, ClockConfig config, String path, boolean relativeDir) {
        FileInputStream fileInputStream;
        List<String> list;
        InputStream inputStreamOpen;
        List<String> list2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        if (path != null) {
            try {
                if (config.isFromAssets()) {
                    String[] list3 = context.getAssets().list(String.valueOf(config.getPath()));
                    if (relativeDir) {
                        FileUtils fileUtils = INSTANCE;
                        if (list3 != null) {
                            Intrinsics.checkNotNull(list3);
                            list2 = ArraysKt.toList(list3);
                        } else {
                            list2 = null;
                        }
                        inputStreamOpen = context.getAssets().open(fileUtils.getAssertRealPath(context, config, path, list2));
                    } else {
                        inputStreamOpen = context.getAssets().open(path);
                    }
                    return BitmapDrawable.createFromStream(inputStreamOpen, null);
                }
                if (relativeDir) {
                    File file = new File(String.valueOf(config.getPath()));
                    FileUtils fileUtils2 = INSTANCE;
                    String[] list4 = file.list();
                    if (list4 != null) {
                        Intrinsics.checkNotNull(list4);
                        list = ArraysKt.toList(list4);
                    } else {
                        list = null;
                    }
                    fileInputStream = new FileInputStream(fileUtils2.getFileRealPath(context, config, path, list));
                } else {
                    fileInputStream = new FileInputStream(path);
                }
                return BitmapDrawable.createFromStream(fileInputStream, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
