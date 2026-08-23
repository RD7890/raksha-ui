package com.dw.launcher.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import com.dw.launcher.data.database.dao.ClockConfigDao;
import com.dw.launcher.data.entity.Clock;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.data.entity.DialPreviewInfo;
import com.dw.launcher.ui.clock.util.ImageUtils;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduHeaders;
import com.tencent.bugly.CrashModule;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

/* JADX INFO: compiled from: WatchFactory.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020+H\u0002J!\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010=\u001a\u00020>H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010BJ \u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010=\u001a\u00020>2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0006J \u0010G\u001a\u0004\u0018\u00010D2\u0006\u0010=\u001a\u00020>2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0006J\u000e\u0010H\u001a\u0002012\u0006\u0010I\u001a\u00020\u0004J\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020@0\"2\u0006\u0010=\u001a\u00020>J\u001e\u0010K\u001a\u00020:2\u0006\u0010=\u001a\u00020>2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010=\u001a\u00020>H\u0002J \u0010N\u001a\u00020:2\u0006\u0010=\u001a\u00020>2\b\u0010E\u001a\u0004\u0018\u00010\u00042\u0006\u0010F\u001a\u00020\u0006J\u001f\u0010O\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010=\u001a\u00020>H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010BJ\u000e\u0010P\u001a\u00020:2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0014\u0010Q\u001a\u00020:2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00060-R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0017\u001a\n \u0018*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0014R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R!\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u000405j\b\u0012\u0004\u0012\u00020\u0004`6¢\u0006\b\n\u0000\u001a\u0004\b7\u00108\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006S"}, d2 = {"Lcom/dw/launcher/util/WatchFactory;", "", "()V", "CONFIG_XML_FILE_NAME", "", "CUSTOM_TYPE", "", "DIAL_SOURCE_LOCAL", "getDIAL_SOURCE_LOCAL", "()I", "DIAL_SOURCE_More", "getDIAL_SOURCE_More", "DIAL_SOURCE_ONLINE", "getDIAL_SOURCE_ONLINE", "DIAL_SOURCE_ONLINE_WITH_MIME", "getDIAL_SOURCE_ONLINE_WITH_MIME", "DeFAULT_TYPE", "DefaultPath", "DwExtenerDialPath", "getDwExtenerDialPath", "()Ljava/lang/String;", "ExtenerPath", "getExtenerPath", "ROOT", "kotlin.jvm.PlatformType", "SD_TYPE", "WATCHFACEINDEX", "clockConfigDao", "Lcom/dw/launcher/data/database/dao/ClockConfigDao;", "getClockConfigDao", "()Lcom/dw/launcher/data/database/dao/ClockConfigDao;", "setClockConfigDao", "(Lcom/dw/launcher/data/database/dao/ClockConfigDao;)V", "dialList", "", "Lcom/dw/launcher/data/entity/DialPreviewInfo;", "getDialList", "()Ljava/util/List;", "setDialList", "(Ljava/util/List;)V", "fileJarSystemPath", "getFileJarSystemPath", "fileROOT", "Ljava/io/File;", "filtWatchList", "", "getFiltWatchList", "setFiltWatchList", "isLoadFromFileSystem", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "sdWatchFacePathList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSdWatchFacePathList", "()Ljava/util/ArrayList;", "addWatchFacePath", "", "file", "createDialPreviewInfo", "context", "Landroid/content/Context;", "it", "Lcom/dw/launcher/data/entity/ClockConfig;", "(Landroid/content/Context;Lcom/dw/launcher/data/entity/ClockConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDwOnlineWatchFaceView", "Landroid/view/View;", "filePath", "id", "getOnlineWatchFaceView", "isNumeric", "input", "loadClockFromAssets", "loadExternalDials", "externalDialList", "loadSystemExternalDials", "prePareOnlineWatchFace", "reloadDiaList", "setClockConfigDaos", "setFilterDiaList", "filterDiaList", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class WatchFactory {
    private static final String CONFIG_XML_FILE_NAME;
    public static final int CUSTOM_TYPE = 2;
    public static final int DeFAULT_TYPE = 1;
    public static final String DefaultPath = "/system/dw_config/dial/";
    private static final String ROOT;
    public static final int SD_TYPE = 3;
    public static final String WATCHFACEINDEX = "wf_index";
    private static ClockConfigDao clockConfigDao;
    private static List<DialPreviewInfo> dialList;
    private static final String fileJarSystemPath;
    private static final File fileROOT;
    private static List<Integer> filtWatchList;
    private static boolean isLoadFromFileSystem;
    private static final ReentrantLock lock;
    private static final ArrayList<String> sdWatchFacePathList;
    public static final WatchFactory INSTANCE = new WatchFactory();
    private static final int DIAL_SOURCE_LOCAL = 1001;
    private static final int DIAL_SOURCE_ONLINE = 1002;
    private static final int DIAL_SOURCE_ONLINE_WITH_MIME = CrashModule.MODULE_ID;
    private static final int DIAL_SOURCE_More = 1003;
    private static final String ExtenerPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "watchface";
    private static final String DwExtenerDialPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "DwDials";

    /* JADX INFO: renamed from: com.dw.launcher.util.WatchFactory$createDialPreviewInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: WatchFactory.kt */
    @Metadata(k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.util.WatchFactory", f = "WatchFactory.kt", i = {0}, l = {214}, m = "createDialPreviewInfo", n = {"dialPreviewInfo"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= IntCompanionObject.MIN_VALUE;
            return WatchFactory.this.createDialPreviewInfo(null, null, this);
        }
    }

    private WatchFactory() {
    }

    static {
        String absolutePath;
        File file = new File(Environment.getRootDirectory().getPath() + "/dw_config/dial");
        fileROOT = file;
        fileJarSystemPath = Environment.getRootDirectory().getPath() + "/dw_config/DwJarDials";
        isLoadFromFileSystem = true;
        dialList = new CopyOnWriteArrayList();
        sdWatchFacePathList = new ArrayList<>();
        CONFIG_XML_FILE_NAME = "DialConf.xml";
        filtWatchList = new ArrayList();
        lock = new ReentrantLock();
        if (isLoadFromFileSystem) {
            absolutePath = file.getAbsolutePath();
        } else {
            absolutePath = "clock";
        }
        ROOT = absolutePath;
    }

    public final int getDIAL_SOURCE_LOCAL() {
        return DIAL_SOURCE_LOCAL;
    }

    public final int getDIAL_SOURCE_ONLINE() {
        return DIAL_SOURCE_ONLINE;
    }

    public final int getDIAL_SOURCE_ONLINE_WITH_MIME() {
        return DIAL_SOURCE_ONLINE_WITH_MIME;
    }

    public final int getDIAL_SOURCE_More() {
        return DIAL_SOURCE_More;
    }

    public final String getExtenerPath() {
        return ExtenerPath;
    }

    public final String getDwExtenerDialPath() {
        return DwExtenerDialPath;
    }

    public final String getFileJarSystemPath() {
        return fileJarSystemPath;
    }

    public final List<DialPreviewInfo> getDialList() {
        return dialList;
    }

    public final void setDialList(List<DialPreviewInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        dialList = list;
    }

    public final ArrayList<String> getSdWatchFacePathList() {
        return sdWatchFacePathList;
    }

    public final List<Integer> getFiltWatchList() {
        return filtWatchList;
    }

    public final void setFiltWatchList(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        filtWatchList = list;
    }

    public final ClockConfigDao getClockConfigDao() {
        return clockConfigDao;
    }

    public final void setClockConfigDao(ClockConfigDao clockConfigDao2) {
        clockConfigDao = clockConfigDao2;
    }

    public final void setFilterDiaList(List<Integer> filterDiaList) {
        Intrinsics.checkNotNullParameter(filterDiaList, "filterDiaList");
        filtWatchList = filterDiaList;
    }

    public final void setClockConfigDaos(ClockConfigDao clockConfigDao2) {
        Intrinsics.checkNotNullParameter(clockConfigDao2, "clockConfigDao");
        clockConfigDao = clockConfigDao2;
    }

    /* JADX INFO: renamed from: com.dw.launcher.util.WatchFactory$reloadDiaList$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WatchFactory.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/dw/launcher/data/entity/DialPreviewInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.util.WatchFactory$reloadDiaList$2", f = "WatchFactory.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00252 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<DialPreviewInfo>>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00252(Context context, Continuation<? super C00252> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00252(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<DialPreviewInfo>> continuation) {
            return ((C00252) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String dialName;
            Bitmap bitmapCreateThumbBitmap;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(WatchFactory.INSTANCE.getSdWatchFacePathList());
            WatchFactory.INSTANCE.getSdWatchFacePathList().clear();
            File file = new File(WatchFactory.INSTANCE.getExtenerPath());
            if (!file.exists()) {
                file.mkdir();
            }
            if (file.exists()) {
                WatchFactory.INSTANCE.addWatchFacePath(file);
            }
            File file2 = new File(WatchFactory.INSTANCE.getDwExtenerDialPath());
            if (!file2.exists()) {
                file2.mkdir();
            }
            if (file2.exists()) {
                WatchFactory.INSTANCE.addWatchFacePath(file2);
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (true) {
                Object obj2 = null;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                if (!WatchFactory.INSTANCE.getSdWatchFacePathList().contains(str)) {
                    for (Object obj3 : WatchFactory.INSTANCE.getDialList()) {
                        DialPreviewInfo dialPreviewInfo = (DialPreviewInfo) obj3;
                        if (Intrinsics.areEqual(dialPreviewInfo.getFilePath(), str) && dialPreviewInfo.getDialSource() == WatchFactory.INSTANCE.getDIAL_SOURCE_ONLINE()) {
                            obj2 = obj3;
                            break;
                        }
                    }
                    DialPreviewInfo dialPreviewInfo2 = (DialPreviewInfo) obj2;
                    if (dialPreviewInfo2 != null) {
                        Boxing.boxBoolean(arrayList3.add(dialPreviewInfo2));
                    }
                    arrayList2.add(str);
                }
            }
            arrayList.removeAll(CollectionsKt.toSet(arrayList2));
            WatchFactory.INSTANCE.getDialList().removeAll(CollectionsKt.toSet(arrayList3));
            ArrayList arrayList4 = new ArrayList();
            for (String str2 : WatchFactory.INSTANCE.getSdWatchFacePathList()) {
                if (!arrayList.contains(str2)) {
                    String packageName = this.$context.getPackageName();
                    DialPreviewInfo dialPreviewInfo3 = new DialPreviewInfo();
                    Intrinsics.checkNotNull(str2);
                    String str3 = str2;
                    String strSubstring = str2.substring(StringsKt.lastIndexOf$default((CharSequence) str3, "/", 0, false, 6, (Object) null) + 1, StringsKt.lastIndexOf$default((CharSequence) str3, ".", 0, false, 6, (Object) null));
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    dialPreviewInfo3.setDialId(Long.parseLong(strSubstring));
                    dialPreviewInfo3.setDialType(3);
                    dialPreviewInfo3.setDialSource(WatchFactory.INSTANCE.getDIAL_SOURCE_ONLINE());
                    Intrinsics.checkNotNull(packageName);
                    dialPreviewInfo3.setPkg(packageName);
                    dialPreviewInfo3.setFilePath(str2);
                    if (StringsKt.contains$default((CharSequence) str3, (CharSequence) WatchFactory.INSTANCE.getDwExtenerDialPath(), false, 2, (Object) null)) {
                        dialName = DexLoaderUtils.INSTANCE.getDwDialName(str2, this.$context);
                    } else {
                        dialName = DexLoaderUtils.INSTANCE.getDialName(str2);
                    }
                    dialPreviewInfo3.setDialName(dialName);
                    if (StringsKt.contains$default((CharSequence) str3, (CharSequence) WatchFactory.INSTANCE.getDwExtenerDialPath(), false, 2, (Object) null)) {
                        bitmapCreateThumbBitmap = DexLoaderUtils.INSTANCE.createDwThumbBitmap(str2, this.$context);
                    } else {
                        bitmapCreateThumbBitmap = DexLoaderUtils.INSTANCE.createThumbBitmap(str2);
                    }
                    dialPreviewInfo3.setPreview(bitmapCreateThumbBitmap);
                    arrayList4.add(dialPreviewInfo3);
                }
            }
            CollectionsKt.sortWith(arrayList4, new Comparator() { // from class: com.dw.launcher.util.WatchFactory$reloadDiaList$2$invokeSuspend$$inlined$compareBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    String filePath = ((DialPreviewInfo) t).getFilePath();
                    Long lValueOf = filePath != null ? Long.valueOf(new File(filePath).lastModified()) : (Comparable) 0L;
                    String filePath2 = ((DialPreviewInfo) t2).getFilePath();
                    return ComparisonsKt.compareValues(lValueOf, filePath2 != null ? Long.valueOf(new File(filePath2).lastModified()) : (Comparable) 0L);
                }
            });
            ArrayList arrayList5 = arrayList4;
            if (!arrayList5.isEmpty()) {
                WatchFactory.INSTANCE.getDialList().addAll(arrayList5);
            }
            Timber.INSTANCE.d(" 本地表盘总数量数量:" + WatchFactory.INSTANCE.getDialList().size() + "  ", new Object[0]);
            return WatchFactory.INSTANCE.getDialList();
        }
    }

    public final Object reloadDiaList(Context context, Continuation<? super List<DialPreviewInfo>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00252(context, null), continuation);
    }

    /* JADX INFO: renamed from: com.dw.launcher.util.WatchFactory$getDialList$2, reason: invalid class name */
    /* JADX INFO: compiled from: WatchFactory.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/dw/launcher/data/entity/DialPreviewInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.util.WatchFactory$getDialList$2", f = "WatchFactory.kt", i = {}, l = {PduHeaders.QUOTAS}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<DialPreviewInfo>>, Object> {
        final /* synthetic */ Context $context;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<DialPreviewInfo>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0099  */
        /* JADX WARN: Code duplicated, block: B:27:0x00a7  */
        /* JADX WARN: Code duplicated, block: B:34:0x00da A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:48:0x00cc A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00d8 -> B:35:0x00db). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instruction units count: 361
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dw.launcher.util.WatchFactory.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object getDialList(Context context, Continuation<? super List<DialPreviewInfo>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(context, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createDialPreviewInfo(Context context, ClockConfig clockConfig, Continuation<? super DialPreviewInfo> continuation) {
        AnonymousClass1 anonymousClass1;
        DialPreviewInfo dialPreviewInfo;
        ImageUtils imageUtils;
        DialPreviewInfo dialPreviewInfo2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & IntCompanionObject.MIN_VALUE) != 0) {
                anonymousClass1.label -= IntCompanionObject.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DialPreviewInfo dialPreviewInfo3 = new DialPreviewInfo();
            dialPreviewInfo3.setDialId(Long.parseLong(clockConfig.getId()));
            dialPreviewInfo3.setDialType(1);
            dialPreviewInfo3.setDialSource(DIAL_SOURCE_LOCAL);
            boolean zContains$default = StringsKt.contains$default((CharSequence) SystemUtils.INSTANCE.getLanguage(context), (CharSequence) "zh", false, 2, (Object) null);
            dialPreviewInfo3.setDialName(zContains$default ? clockConfig.getName() : clockConfig.getName_en());
            Timber.INSTANCE.d(" 表盘名称：" + clockConfig.getName() + "  英文名称：" + clockConfig.getName_en() + " isZh :" + zContains$default + ' ', new Object[0]);
            dialPreviewInfo3.setClock(new Clock(context, clockConfig, !isLoadFromFileSystem));
            try {
                imageUtils = ImageUtils.INSTANCE;
                Clock clock = dialPreviewInfo3.getClock();
                Intrinsics.checkNotNull(clock);
                anonymousClass1.L$0 = dialPreviewInfo3;
                anonymousClass1.L$1 = dialPreviewInfo3;
                anonymousClass1.L$2 = imageUtils;
                anonymousClass1.label = 1;
                Object preview = clock.getPreview(anonymousClass1);
                if (preview == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dialPreviewInfo = dialPreviewInfo3;
                obj = preview;
                dialPreviewInfo2 = dialPreviewInfo;
            } catch (Exception e) {
                e = e;
                dialPreviewInfo = dialPreviewInfo3;
                Timber.INSTANCE.e(e, "生成表盘预览图失败", new Object[0]);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            imageUtils = (ImageUtils) anonymousClass1.L$2;
            dialPreviewInfo2 = (DialPreviewInfo) anonymousClass1.L$1;
            dialPreviewInfo = (DialPreviewInfo) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e2) {
                e = e2;
                Timber.INSTANCE.e(e, "生成表盘预览图失败", new Object[0]);
            }
        }
        dialPreviewInfo2.setPreview(imageUtils.drawableToBitmap((Drawable) obj));
        return dialPreviewInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DialPreviewInfo> loadSystemExternalDials(Context context) {
        ArrayList<String> arrayList = sdWatchFacePathList;
        arrayList.clear();
        File file = new File(fileJarSystemPath);
        if (!file.exists()) {
            file.mkdir();
        }
        if (file.exists()) {
            addWatchFacePath(file);
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            String packageName = context.getPackageName();
            DialPreviewInfo dialPreviewInfo = new DialPreviewInfo();
            Intrinsics.checkNotNull(str);
            String str2 = str;
            String strSubstring = str.substring(StringsKt.lastIndexOf$default((CharSequence) str2, "/", 0, false, 6, (Object) null) + 1, StringsKt.lastIndexOf$default((CharSequence) str2, ".", 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            dialPreviewInfo.setDialId(Long.parseLong(strSubstring));
            List<Integer> list = filtWatchList;
            if (list != null && (!list.isEmpty())) {
                List<Integer> list2 = filtWatchList;
                Intrinsics.checkNotNull(list2);
                if (!list2.contains(Integer.valueOf((int) dialPreviewInfo.getDialId()))) {
                    Log.d("WatchFactory", "filtWatchList " + dialPreviewInfo.getDialId());
                }
            }
            dialPreviewInfo.setDialType(3);
            Intrinsics.checkNotNull(packageName);
            dialPreviewInfo.setPkg(packageName);
            dialPreviewInfo.setFilePath(str);
            dialPreviewInfo.setDialSource(DIAL_SOURCE_LOCAL);
            dialPreviewInfo.setDialName(DexLoaderUtils.INSTANCE.getDwDialName(str, context));
            dialPreviewInfo.setPreview(DexLoaderUtils.INSTANCE.createDwThumbBitmap(str, context));
            arrayList2.add(dialPreviewInfo);
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadExternalDials(Context context, List<DialPreviewInfo> externalDialList) {
        String dialName;
        Bitmap bitmapCreateThumbBitmap;
        ArrayList<String> arrayList = sdWatchFacePathList;
        arrayList.clear();
        File file = new File(ExtenerPath);
        if (!file.exists()) {
            file.mkdir();
        }
        if (file.exists()) {
            addWatchFacePath(file);
        }
        File file2 = new File(DwExtenerDialPath);
        if (!file2.exists()) {
            file2.mkdir();
        }
        if (file2.exists()) {
            addWatchFacePath(file2);
        }
        for (String str : arrayList) {
            String packageName = context.getPackageName();
            DialPreviewInfo dialPreviewInfo = new DialPreviewInfo();
            Intrinsics.checkNotNull(str);
            String str2 = str;
            String strSubstring = str.substring(StringsKt.lastIndexOf$default((CharSequence) str2, "/", 0, false, 6, (Object) null) + 1, StringsKt.lastIndexOf$default((CharSequence) str2, ".", 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            dialPreviewInfo.setDialId(Long.parseLong(strSubstring));
            dialPreviewInfo.setDialType(3);
            dialPreviewInfo.setDialSource(DIAL_SOURCE_ONLINE);
            Intrinsics.checkNotNull(packageName);
            dialPreviewInfo.setPkg(packageName);
            dialPreviewInfo.setFilePath(str);
            String str3 = DwExtenerDialPath;
            if (StringsKt.contains$default((CharSequence) str2, (CharSequence) str3, false, 2, (Object) null)) {
                dialName = DexLoaderUtils.INSTANCE.getDwDialName(str, context);
            } else {
                dialName = DexLoaderUtils.INSTANCE.getDialName(str);
            }
            dialPreviewInfo.setDialName(dialName);
            if (StringsKt.contains$default((CharSequence) str2, (CharSequence) str3, false, 2, (Object) null)) {
                bitmapCreateThumbBitmap = DexLoaderUtils.INSTANCE.createDwThumbBitmap(str, context);
            } else {
                bitmapCreateThumbBitmap = DexLoaderUtils.INSTANCE.createThumbBitmap(str);
            }
            dialPreviewInfo.setPreview(bitmapCreateThumbBitmap);
            externalDialList.add(dialPreviewInfo);
        }
    }

    public final View getOnlineWatchFaceView(Context context, String filePath, int id) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return DexLoaderUtils.INSTANCE.getOnlineWatchFaceView(context, filePath, DexLoaderUtils.INSTANCE.getAssetManager(filePath), id);
    }

    public final View getDwOnlineWatchFaceView(Context context, String filePath, int id) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return DexLoaderUtils.INSTANCE.getDwOnlineWatchFaceView(context, filePath, DexLoaderUtils.INSTANCE.getAssetManager(filePath), id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addWatchFacePath(File file) {
        try {
            File[] fileArrListFiles = file.listFiles();
            Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "listFiles(...)");
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                if (StringsKt.endsWith$default(name, "jar", false, 2, (Object) null)) {
                    sdWatchFacePathList.add(file2.getPath());
                    Log.d("WatchFaceUtils", file2.getPath());
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005d A[Catch: all -> 0x018a, Exception -> 0x018c, TryCatch #0 {Exception -> 0x018c, blocks: (B:3:0x0018, B:5:0x001f, B:7:0x002b, B:9:0x002f, B:11:0x003c, B:13:0x0040, B:15:0x0049, B:22:0x00bd, B:18:0x005d, B:20:0x00b7, B:21:0x00ba, B:23:0x00c1, B:25:0x00ce, B:27:0x00d2, B:29:0x00df, B:31:0x00e3, B:33:0x00ec, B:36:0x0101, B:38:0x0178, B:39:0x017b), top: B:50:0x0018, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x00b7 A[Catch: all -> 0x018a, Exception -> 0x018c, TryCatch #0 {Exception -> 0x018c, blocks: (B:3:0x0018, B:5:0x001f, B:7:0x002b, B:9:0x002f, B:11:0x003c, B:13:0x0040, B:15:0x0049, B:22:0x00bd, B:18:0x005d, B:20:0x00b7, B:21:0x00ba, B:23:0x00c1, B:25:0x00ce, B:27:0x00d2, B:29:0x00df, B:31:0x00e3, B:33:0x00ec, B:36:0x0101, B:38:0x0178, B:39:0x017b), top: B:50:0x0018, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0101 A[Catch: all -> 0x018a, Exception -> 0x018c, TryCatch #0 {Exception -> 0x018c, blocks: (B:3:0x0018, B:5:0x001f, B:7:0x002b, B:9:0x002f, B:11:0x003c, B:13:0x0040, B:15:0x0049, B:22:0x00bd, B:18:0x005d, B:20:0x00b7, B:21:0x00ba, B:23:0x00c1, B:25:0x00ce, B:27:0x00d2, B:29:0x00df, B:31:0x00e3, B:33:0x00ec, B:36:0x0101, B:38:0x0178, B:39:0x017b), top: B:50:0x0018, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0178 A[Catch: all -> 0x018a, Exception -> 0x018c, TryCatch #0 {Exception -> 0x018c, blocks: (B:3:0x0018, B:5:0x001f, B:7:0x002b, B:9:0x002f, B:11:0x003c, B:13:0x0040, B:15:0x0049, B:22:0x00bd, B:18:0x005d, B:20:0x00b7, B:21:0x00ba, B:23:0x00c1, B:25:0x00ce, B:27:0x00d2, B:29:0x00df, B:31:0x00e3, B:33:0x00ec, B:36:0x0101, B:38:0x0178, B:39:0x017b), top: B:50:0x0018, outer: #1 }] */
    public final List<ClockConfig> loadClockFromAssets(Context context) {
        ClockConfig clockConfig;
        ClockConfigDao clockConfigDao2;
        List<Integer> list;
        ClockConfig clockConfig2;
        ClockConfigDao clockConfigDao3;
        List<Integer> list2;
        Intrinsics.checkNotNullParameter(context, "context");
        Timber.INSTANCE.i("----loadClockFromAssets", new Object[0]);
        ArrayList arrayList = new ArrayList();
        try {
            try {
                if (!isLoadFromFileSystem) {
                    String[] list3 = context.getAssets().list(ROOT);
                    if (list3 != null) {
                        for (String str : list3) {
                            WatchFactory watchFactory = INSTANCE;
                            Intrinsics.checkNotNull(str);
                            if (watchFactory.isNumeric(str) && (list2 = filtWatchList) != null && (!list2.isEmpty())) {
                                List<Integer> list4 = filtWatchList;
                                Intrinsics.checkNotNull(list4);
                                if (list4.contains(Integer.valueOf(Integer.parseInt(str)))) {
                                    String str2 = ROOT + '/' + str;
                                    String str3 = str2 + '/' + CONFIG_XML_FILE_NAME;
                                    clockConfig2 = new ClockConfig(str2, !isLoadFromFileSystem);
                                    Timber.INSTANCE.tag("lkang").i("configXmlFilePath = %s path: =%s ", str3, str);
                                    InputStream inputStreamOpen = context.getAssets().open(str3, 2);
                                    Intrinsics.checkNotNull(inputStreamOpen);
                                    clockConfig2.loadConfig(inputStreamOpen);
                                    clockConfigDao3 = clockConfigDao;
                                    if (clockConfigDao3 != null) {
                                        clockConfigDao3.insert(clockConfig2);
                                    }
                                    arrayList.add(clockConfig2);
                                }
                            } else {
                                String str4 = ROOT + '/' + str;
                                String str5 = str4 + '/' + CONFIG_XML_FILE_NAME;
                                clockConfig2 = new ClockConfig(str4, !isLoadFromFileSystem);
                                Timber.INSTANCE.tag("lkang").i("configXmlFilePath = %s path: =%s ", str5, str);
                                InputStream inputStreamOpen2 = context.getAssets().open(str5, 2);
                                Intrinsics.checkNotNull(inputStreamOpen2);
                                clockConfig2.loadConfig(inputStreamOpen2);
                                clockConfigDao3 = clockConfigDao;
                                if (clockConfigDao3 != null) {
                                    clockConfigDao3.insert(clockConfig2);
                                }
                                arrayList.add(clockConfig2);
                            }
                        }
                    }
                } else {
                    String[] list5 = new File(ROOT).list();
                    if (list5 != null) {
                        for (String str6 : list5) {
                            WatchFactory watchFactory2 = INSTANCE;
                            Intrinsics.checkNotNull(str6);
                            if (watchFactory2.isNumeric(str6) && (list = filtWatchList) != null && (!list.isEmpty())) {
                                List<Integer> list6 = filtWatchList;
                                Intrinsics.checkNotNull(list6);
                                if (list6.contains(Integer.valueOf(Integer.parseInt(str6)))) {
                                    String str7 = ROOT + '/' + str6;
                                    String str8 = str7 + '/' + CONFIG_XML_FILE_NAME;
                                    clockConfig = new ClockConfig(str7, !isLoadFromFileSystem);
                                    Timber.INSTANCE.d(" configXmlFilePath = " + str8 + " clockPath: " + str7 + "  path: =" + str6, new Object[0]);
                                    clockConfig.loadConfig(new FileInputStream(new File(str8)));
                                    clockConfigDao2 = clockConfigDao;
                                    if (clockConfigDao2 != null) {
                                        clockConfigDao2.insert(clockConfig);
                                    }
                                    arrayList.add(clockConfig);
                                }
                            } else {
                                String str9 = ROOT + '/' + str6;
                                String str10 = str9 + '/' + CONFIG_XML_FILE_NAME;
                                clockConfig = new ClockConfig(str9, !isLoadFromFileSystem);
                                Timber.INSTANCE.d(" configXmlFilePath = " + str10 + " clockPath: " + str9 + "  path: =" + str6, new Object[0]);
                                clockConfig.loadConfig(new FileInputStream(new File(str10)));
                                clockConfigDao2 = clockConfigDao;
                                if (clockConfigDao2 != null) {
                                    clockConfigDao2.insert(clockConfig);
                                }
                                arrayList.add(clockConfig);
                            }
                        }
                    }
                }
                Timber.INSTANCE.i("----loadClockFromAssets end", new Object[0]);
            } catch (Exception e) {
                Timber.INSTANCE.e(e, "----load assets clock failure", new Object[0]);
                Timber.INSTANCE.i("----loadClockFromAssets end", new Object[0]);
            }
            return arrayList;
        } catch (Throwable th) {
            Timber.INSTANCE.i("----loadClockFromAssets end", new Object[0]);
            throw th;
        }
    }

    public final boolean isNumeric(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String str = input;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public final void prePareOnlineWatchFace(Context context, String filePath, int id) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (filePath != null) {
            DexLoaderUtils.INSTANCE.prepareWatchDial(context, filePath, DexLoaderUtils.INSTANCE.getAssetManager(filePath), id);
        }
    }
}
