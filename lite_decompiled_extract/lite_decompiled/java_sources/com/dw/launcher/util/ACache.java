package com.dw.launcher.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class ACache {
    private static final int MAX_COUNT = Integer.MAX_VALUE;
    private static final int MAX_SIZE = 50000000;
    public static final int TIME_DAY = 86400;
    public static final int TIME_HOUR = 3600;
    private static Map<String, ACache> mInstanceMap = new HashMap();
    private ACacheManager mCache;

    public static ACache get(Context ctx) {
        return get(ctx, "ACache");
    }

    public static ACache get(Context ctx, String cacheName) {
        return get(new File(ctx.getFilesDir(), cacheName), 50000000L, Integer.MAX_VALUE);
    }

    public static ACache get(File cacheDir) {
        return get(cacheDir, 50000000L, Integer.MAX_VALUE);
    }

    public static ACache get(Context ctx, long max_zise, int max_count) {
        return get(new File(ctx.getFilesDir(), "ACache"), max_zise, max_count);
    }

    public static ACache get(File cacheDir, long max_zise, int max_count) {
        ACache aCache = mInstanceMap.get(cacheDir.getAbsoluteFile() + myPid());
        if (aCache != null) {
            return aCache;
        }
        ACache aCache2 = new ACache(cacheDir, max_zise, max_count);
        mInstanceMap.put(cacheDir.getAbsolutePath() + myPid(), aCache2);
        return aCache2;
    }

    private static String myPid() {
        return "_" + Process.myPid();
    }

    private ACache(File cacheDir, long max_size, int max_count) {
        if (!cacheDir.exists() && !cacheDir.mkdirs()) {
            throw new RuntimeException("can't make dirs in " + cacheDir.getAbsolutePath());
        }
        this.mCache = new ACacheManager(cacheDir, max_size, max_count);
    }

    public void put(String key, String value) throws Throwable {
        File fileNewFile = this.mCache.newFile(key);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(fileNewFile), LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY);
                try {
                    bufferedWriter2.write(value);
                    try {
                        bufferedWriter2.flush();
                        bufferedWriter2.close();
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    this.mCache.put(fileNewFile);
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
            }
            this.mCache.put(fileNewFile);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void put(String key, String value, int saveTime) throws Throwable {
        put(key, Utils.newStringWithDateInfo(saveTime, value));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    public String getAsString(String key) throws Throwable {
        BufferedReader bufferedReader;
        File file = this.mCache.get(key);
        ?? Exists = file.exists();
        ?? r2 = 0;
        try {
            if (Exists == 0) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String str = "";
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        str = str + line;
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return null;
                    }
                }
                if (Utils.isDue(str)) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    remove(key);
                    return null;
                }
                String strClearDateInfo = Utils.clearDateInfo(str);
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return strClearDateInfo;
            } catch (IOException e5) {
                e = e5;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                if (r2 != 0) {
                    try {
                        r2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r2 = Exists;
        }
    }

    public void put(String key, JSONObject value) throws Throwable {
        put(key, value.toString());
    }

    public void put(String key, JSONObject value, int saveTime) throws Throwable {
        put(key, value.toString(), saveTime);
    }

    public JSONObject getAsJSONObject(String key) {
        try {
            return new JSONObject(getAsString(key));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void put(String key, JSONArray value) throws Throwable {
        put(key, value.toString());
    }

    public void put(String key, JSONArray value, int saveTime) throws Throwable {
        put(key, value.toString(), saveTime);
    }

    public JSONArray getAsJSONArray(String key) {
        try {
            return new JSONArray(getAsString(key));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void put(String key, byte[] value) throws Throwable {
        File fileNewFile = this.mCache.newFile(key);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(fileNewFile);
                try {
                    fileOutputStream2.write(value);
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    this.mCache.put(fileNewFile);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
            this.mCache.put(fileNewFile);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void put(String key, byte[] value, int saveTime) throws Throwable {
        put(key, Utils.newByteArrayWithDateInfo(saveTime, value));
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0053: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:35:0x0053 */
    public byte[] getAsBinary(String key) throws Throwable {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3 = null;
        try {
            try {
                File file = this.mCache.get(key);
                if (!file.exists()) {
                    return null;
                }
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    byte[] bArr = new byte[(int) randomAccessFile.length()];
                    randomAccessFile.read(bArr);
                    if (Utils.isDue(bArr)) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        remove(key);
                        return null;
                    }
                    byte[] bArrClearDateInfo = Utils.clearDateInfo(bArr);
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return bArrClearDateInfo;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
                randomAccessFile3 = randomAccessFile2;
                if (randomAccessFile3 != null) {
                    try {
                        randomAccessFile3.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile3 != null) {
                randomAccessFile3.close();
            }
            throw th;
        }
        e.printStackTrace();
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }

    public void put(String key, Serializable value) throws Throwable {
        put(key, value, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public void put(String str, Serializable serializable, int i) throws Throwable {
        ?? r0 = 0;
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(serializable);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    r0 = -1;
                    if (i != -1) {
                        put(str, byteArray, i);
                    } else {
                        put(str, byteArray);
                    }
                    objectOutputStream2.close();
                } catch (Exception e) {
                    e = e;
                    objectOutputStream = objectOutputStream2;
                    e.printStackTrace();
                    objectOutputStream.close();
                    r0 = objectOutputStream;
                } catch (Throwable th) {
                    th = th;
                    r0 = objectOutputStream2;
                    try {
                        r0.close();
                    } catch (IOException unused) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (IOException unused2) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v5 */
    public Object getAsObject(String key) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        ObjectInputStream asBinary = getAsBinary(key);
        try {
            if (asBinary == 0) {
                return null;
            }
            try {
                byteArrayInputStream = new ByteArrayInputStream(asBinary);
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        Object object = objectInputStream.readObject();
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            objectInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return object;
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (Exception e6) {
                    e = e6;
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    asBinary = 0;
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (asBinary != 0) {
                        try {
                            asBinary.close();
                            throw th;
                        } catch (IOException e8) {
                            e8.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
                objectInputStream = null;
                byteArrayInputStream = null;
            } catch (Throwable th2) {
                byteArrayInputStream = null;
                th = th2;
                asBinary = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public Boolean getAsBoolean(String str, Boolean bool) throws Throwable {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        Exception e;
        ObjectInputStream objectInputStream2;
        byte[] asBinary = getAsBinary(str);
        if (asBinary == null) {
            return bool;
        }
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(asBinary);
                try {
                    objectInputStream2 = new ObjectInputStream(byteArrayInputStream);
                    try {
                        Boolean bool2 = (Boolean) objectInputStream2.readObject();
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            objectInputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return bool2;
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        return bool;
                    }
                } catch (Exception e7) {
                    e = e7;
                    objectInputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    asBinary = null;
                    byteArrayInputStream2 = byteArrayInputStream;
                    objectInputStream = asBinary;
                    if (byteArrayInputStream2 != null) {
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (objectInputStream != 0) {
                        try {
                            objectInputStream.close();
                            throw th;
                        } catch (IOException e9) {
                            e9.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            byteArrayInputStream = null;
            e = e10;
            objectInputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = 0;
            if (byteArrayInputStream2 != null) {
                byteArrayInputStream2.close();
            }
            if (objectInputStream != 0) {
                objectInputStream.close();
                throw th;
            }
            throw th;
        }
    }

    public void put(String key, Bitmap value) throws Throwable {
        put(key, Utils.Bitmap2Bytes(value));
    }

    public void put(String key, Bitmap value, int saveTime) throws Throwable {
        put(key, Utils.Bitmap2Bytes(value), saveTime);
    }

    public Bitmap getAsBitmap(String key) {
        if (getAsBinary(key) == null) {
            return null;
        }
        return Utils.Bytes2Bimap(getAsBinary(key));
    }

    public void put(String key, Drawable value) throws Throwable {
        put(key, Utils.drawable2Bitmap(value));
    }

    public void put(String key, Drawable value, int saveTime) throws Throwable {
        put(key, Utils.drawable2Bitmap(value), saveTime);
    }

    public Drawable getAsDrawable(String key) {
        if (getAsBinary(key) == null) {
            return null;
        }
        return Utils.bitmap2Drawable(Utils.Bytes2Bimap(getAsBinary(key)));
    }

    public File file(String key) {
        File fileNewFile = this.mCache.newFile(key);
        if (fileNewFile.exists()) {
            return fileNewFile;
        }
        return null;
    }

    public boolean remove(String key) {
        return this.mCache.remove(key);
    }

    public void clear() {
        this.mCache.clear();
    }

    public class ACacheManager {
        private final AtomicInteger cacheCount;
        protected File cacheDir;
        private final AtomicLong cacheSize;
        private final int countLimit;
        private final Map<File, Long> lastUsageDates;
        private final long sizeLimit;

        private ACacheManager(File cacheDir, long sizeLimit, int countLimit) {
            this.lastUsageDates = Collections.synchronizedMap(new HashMap());
            this.cacheDir = cacheDir;
            this.sizeLimit = sizeLimit;
            this.countLimit = countLimit;
            this.cacheSize = new AtomicLong();
            this.cacheCount = new AtomicInteger();
            calculateCacheSizeAndCacheCount();
        }

        private void calculateCacheSizeAndCacheCount() {
            new Thread(new Runnable() { // from class: com.dw.launcher.util.ACache.ACacheManager.1
                @Override // java.lang.Runnable
                public void run() {
                    File[] fileArrListFiles = ACacheManager.this.cacheDir.listFiles();
                    if (fileArrListFiles != null) {
                        int iCalculateSize = 0;
                        int i = 0;
                        for (File file : fileArrListFiles) {
                            iCalculateSize = (int) (((long) iCalculateSize) + ACacheManager.this.calculateSize(file));
                            i++;
                            ACacheManager.this.lastUsageDates.put(file, Long.valueOf(file.lastModified()));
                        }
                        ACacheManager.this.cacheSize.set(iCalculateSize);
                        ACacheManager.this.cacheCount.set(i);
                    }
                }
            }).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void put(File file) {
            int iAddAndGet = this.cacheCount.get();
            while (iAddAndGet + 1 > this.countLimit) {
                this.cacheSize.addAndGet(-removeNext());
                iAddAndGet = this.cacheCount.addAndGet(-1);
            }
            this.cacheCount.addAndGet(1);
            long jCalculateSize = calculateSize(file);
            long jAddAndGet = this.cacheSize.get();
            while (jAddAndGet + jCalculateSize > this.sizeLimit) {
                jAddAndGet = this.cacheSize.addAndGet(-removeNext());
            }
            this.cacheSize.addAndGet(jCalculateSize);
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(lValueOf.longValue());
            this.lastUsageDates.put(file, lValueOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File get(String key) {
            File fileNewFile = newFile(key);
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            fileNewFile.setLastModified(lValueOf.longValue());
            this.lastUsageDates.put(fileNewFile, lValueOf);
            return fileNewFile;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File newFile(String key) {
            return new File(this.cacheDir, key.hashCode() + "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean remove(String key) {
            return get(key).delete();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.lastUsageDates.clear();
            this.cacheSize.set(0L);
            File[] fileArrListFiles = this.cacheDir.listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    file.delete();
                }
            }
        }

        private long removeNext() {
            File key;
            if (this.lastUsageDates.isEmpty()) {
                return 0L;
            }
            Set<Map.Entry<File, Long>> setEntrySet = this.lastUsageDates.entrySet();
            synchronized (this.lastUsageDates) {
                key = null;
                Long value = null;
                for (Map.Entry<File, Long> entry : setEntrySet) {
                    if (key == null) {
                        key = entry.getKey();
                        value = entry.getValue();
                    } else {
                        Long value2 = entry.getValue();
                        if (value2.longValue() < value.longValue()) {
                            key = entry.getKey();
                            value = value2;
                        }
                    }
                }
            }
            long jCalculateSize = calculateSize(key);
            if (key.delete()) {
                this.lastUsageDates.remove(key);
            }
            return jCalculateSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long calculateSize(File file) {
            return file.length();
        }
    }

    private static class Utils {
        private static final char mSeparator = ' ';

        private Utils() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isDue(String str) {
            return isDue(str.getBytes());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isDue(byte[] data) {
            String[] dateInfoFromDate = getDateInfoFromDate(data);
            if (dateInfoFromDate != null && dateInfoFromDate.length == 2) {
                String strSubstring = dateInfoFromDate[0];
                while (strSubstring.startsWith("0")) {
                    strSubstring = strSubstring.substring(1, strSubstring.length());
                }
                if (System.currentTimeMillis() > Long.valueOf(strSubstring).longValue() + (Long.valueOf(dateInfoFromDate[1]).longValue() * 1000)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String newStringWithDateInfo(int second, String strInfo) {
            return createDateInfo(second) + strInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] newByteArrayWithDateInfo(int second, byte[] data2) {
            byte[] bytes = createDateInfo(second).getBytes();
            byte[] bArr = new byte[bytes.length + data2.length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            System.arraycopy(data2, 0, bArr, bytes.length, data2.length);
            return bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String clearDateInfo(String strInfo) {
            return (strInfo == null || !hasDateInfo(strInfo.getBytes())) ? strInfo : strInfo.substring(strInfo.indexOf(32) + 1, strInfo.length());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] clearDateInfo(byte[] data) {
            return hasDateInfo(data) ? copyOfRange(data, indexOf(data, mSeparator) + 1, data.length) : data;
        }

        private static boolean hasDateInfo(byte[] data) {
            return data != null && data.length > 15 && data[13] == 45 && indexOf(data, mSeparator) > 14;
        }

        private static String[] getDateInfoFromDate(byte[] data) {
            if (hasDateInfo(data)) {
                return new String[]{new String(copyOfRange(data, 0, 13)), new String(copyOfRange(data, 14, indexOf(data, mSeparator)))};
            }
            return null;
        }

        private static int indexOf(byte[] data, char c) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] == c) {
                    return i;
                }
            }
            return -1;
        }

        private static byte[] copyOfRange(byte[] original, int from, int to) {
            int i = to - from;
            if (i < 0) {
                throw new IllegalArgumentException(from + " > " + to);
            }
            byte[] bArr = new byte[i];
            System.arraycopy(original, from, bArr, 0, Math.min(original.length - from, i));
            return bArr;
        }

        private static String createDateInfo(int second) {
            String str = System.currentTimeMillis() + "";
            while (str.length() < 13) {
                str = "0" + str;
            }
            return str + "-" + second + mSeparator;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] Bitmap2Bytes(Bitmap bm) {
            if (bm == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Bitmap Bytes2Bimap(byte[] b) {
            if (b.length == 0) {
                return null;
            }
            return BitmapFactory.decodeByteArray(b, 0, b.length);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Bitmap drawable2Bitmap(Drawable drawable) {
            if (drawable == null) {
                return null;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Drawable bitmap2Drawable(Bitmap bm) {
            if (bm == null) {
                return null;
            }
            return new BitmapDrawable(bm);
        }
    }
}
