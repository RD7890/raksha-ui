package com.dw.launcher.util;

import android.os.Environment;
import com.google.android.mms.pdu.CharacterSets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: BreatheFileStorageUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/dw/launcher/util/BreatheFileStorageUtils;", "", "()V", "DIRECTORY_NAME", "", "getFile", "Ljava/io/File;", "key", "readFromFile", "writeToFile", "", "value", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class BreatheFileStorageUtils {
    private static final String DIRECTORY_NAME;
    public static final BreatheFileStorageUtils INSTANCE = new BreatheFileStorageUtils();

    private BreatheFileStorageUtils() {
    }

    static {
        String absolutePath = new File(Environment.getExternalStorageDirectory(), ".Health/breathe").getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        DIRECTORY_NAME = absolutePath;
    }

    private final File getFile(String key) {
        File file = new File(DIRECTORY_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, key);
    }

    public final void writeToFile(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(getFile(key));
            try {
                byte[] bytes = value.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                fileOutputStream.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final String readFromFile(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        File file = getFile(key);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[(int) file.length()];
                fileInputStream.read(bArr);
                String str = new String(bArr, Charsets.UTF_8);
                CloseableKt.closeFinally(fileInputStream, null);
                return str;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileInputStream, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
