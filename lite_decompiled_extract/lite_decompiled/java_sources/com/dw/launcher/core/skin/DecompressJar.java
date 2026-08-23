package com.dw.launcher.core.skin;

import android.util.Log;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DecompressJar.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/dw/launcher/core/skin/DecompressJar;", BuildConfig.FLAVOR, "()V", "mThemePath", BuildConfig.FLAVOR, "getMThemePath", "()Ljava/lang/String;", "setMThemePath", "(Ljava/lang/String;)V", "mWallpaperPath", "getMWallpaperPath", "setMWallpaperPath", "decompress", BuildConfig.FLAVOR, "fileName", "outputPath", "delAllFile", BuildConfig.FLAVOR, "path", "delFolder", "makeSupDir", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DecompressJar {
    public static final DecompressJar INSTANCE = new DecompressJar();
    private static String mThemePath;
    private static String mWallpaperPath;

    private DecompressJar() {
    }

    public final String getMThemePath() {
        return mThemePath;
    }

    public final void setMThemePath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mThemePath = str;
    }

    public final String getMWallpaperPath() {
        return mWallpaperPath;
    }

    public final void setMWallpaperPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mWallpaperPath = str;
    }

    static {
        String str = File.separator;
        mThemePath = str + "data" + str + "data" + str + com.dw.launcher.BuildConfig.APPLICATION_ID + str + "divo" + str + "Theme" + str + "Current";
        mWallpaperPath = str + "data" + str + "data" + str + com.dw.launcher.BuildConfig.APPLICATION_ID + str + "divo" + str + "Wallpaper" + str + "Current";
    }

    public final void decompress(String fileName, String outputPath) throws IOException {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(outputPath, "outputPath");
        String str = File.separator;
        Intrinsics.checkNotNull(str);
        if (!StringsKt.endsWith$default(outputPath, str, false, 2, (Object) null)) {
            outputPath = outputPath + str;
            Intrinsics.checkNotNullExpressionValue(outputPath, "toString(...)");
        }
        Log.i("hxcs", "entry DecompressJar::decompress, fileName = " + fileName + ", outputPath = " + outputPath);
        JarFile jarFile = new JarFile(fileName);
        Enumeration<JarEntry> enumerationEntries = jarFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            JarEntry jarEntryNextElement = enumerationEntries.nextElement();
            Intrinsics.checkNotNull(jarEntryNextElement, "null cannot be cast to non-null type java.util.jar.JarEntry");
            JarEntry jarEntry = jarEntryNextElement;
            String str2 = outputPath + jarEntry.getName();
            File file = new File(str2);
            System.out.println((Object) file.getAbsolutePath());
            makeSupDir(str2);
            if (!file.isDirectory()) {
                InputStream inputStream = jarFile.getInputStream(jarEntry);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                byte[] bArr = new byte[2048];
                while (true) {
                    try {
                        int i = inputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        } else {
                            bufferedOutputStream.write(bArr, 0, i);
                        }
                    } catch (Throwable th) {
                        bufferedOutputStream.close();
                        inputStream.close();
                        throw th;
                    }
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                inputStream.close();
            }
        }
    }

    public final boolean delAllFile(String path) {
        String[] list;
        File file;
        Intrinsics.checkNotNullParameter(path, "path");
        Log.i("hxcs", "entry DecompressJar::delAllFile, path = " + path);
        File file2 = new File(path);
        if (!file2.exists() || !file2.isDirectory() || (list = file2.list()) == null) {
            return false;
        }
        int length = list.length;
        boolean z = false;
        for (int i = 0; i < length; i++) {
            String str = File.separator;
            Intrinsics.checkNotNull(str);
            if (StringsKt.endsWith$default(path, str, false, 2, (Object) null)) {
                file = new File(path + list[i]);
            } else {
                file = new File(path + str + list[i]);
            }
            if (file.isFile()) {
                file.delete();
            }
            if (file.isDirectory()) {
                DecompressJar decompressJar = INSTANCE;
                decompressJar.delAllFile(path + '/' + list + "[i]");
                decompressJar.delFolder(path + '/' + list + "[i]");
                z = true;
            }
        }
        return z;
    }

    public final void delFolder(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            delAllFile(path);
            new File(path).delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void makeSupDir(String path) {
        Matcher matcher = Pattern.compile("[/\\\\]").matcher(path);
        while (matcher.find()) {
            String strSubstring = path.substring(0, matcher.start());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            File file = new File(strSubstring);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }
}
