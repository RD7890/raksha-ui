package com.dw.launcher.data.repository;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.database.dao.ClockConfigDao;
import com.dw.launcher.data.entity.Clock;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.data.preference.LauncherPreference;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

/* JADX INFO: compiled from: AssetsClockRepository.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0083@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0003J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0016J\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eH\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001e2\u0006\u0010 \u001a\u00020\u0010H\u0097@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0010H\u0002J\u0018\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0002J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0017H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eH\u0017J\u0019\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020\u0017H\u0083@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020+2\u0006\u0010(\u001a\u00020\u0017H\u0016J\u001b\u0010.\u001a\u0004\u0018\u00010\u00172\u0006\u0010/\u001a\u00020\u0017H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010,J\u001b\u00100\u001a\u0004\u0018\u00010\u00172\u0006\u0010(\u001a\u00020\u0017H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010,R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/dw/launcher/data/repository/AssetsClockRepository;", "Lcom/dw/launcher/data/repository/ClockRepository;", "context", "Landroid/content/Context;", "preference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "launchRepository", "Lcom/dw/launcher/data/repository/WatchConfigRepository;", "clockConfigDao", "Lcom/dw/launcher/data/database/dao/ClockConfigDao;", "(Landroid/content/Context;Lcom/dw/launcher/data/preference/LauncherPreference;Lcom/dw/launcher/data/repository/WatchConfigRepository;Lcom/dw/launcher/data/database/dao/ClockConfigDao;)V", "CONFIG_XML_FILE_NAME", BuildConfig.FLAVOR, "ROOT", "kotlin.jvm.PlatformType", "desiredHeight", BuildConfig.FLAVOR, "fileROOT", "Ljava/io/File;", "isLoadFromFileSystem", BuildConfig.FLAVOR, "resolution", "findCurrentClickedClock", "Lcom/dw/launcher/data/entity/Clock;", "clock2", "Lcom/dw/launcher/data/entity/ClockConfig;", "(Lcom/dw/launcher/data/entity/ClockConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findDynamicChangeClock", "findPreferClockList", "getClockList", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "level", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClosestResolution", "desiredWidth", "hasExactResolution", "width", "height", "isNeedChangeToDynamicClock", "clock", "loadClockFromAssets", "saveClock", BuildConfig.FLAVOR, "(Lcom/dw/launcher/data/entity/Clock;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOrUpdateClock", "switchToNextClickedClock", "current", "switchToTargetDynamicClock", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AssetsClockRepository implements ClockRepository {
    private final String CONFIG_XML_FILE_NAME;
    private final String ROOT;
    private final ClockConfigDao clockConfigDao;
    private final Context context;
    private final int desiredHeight;
    private final File fileROOT;
    private boolean isLoadFromFileSystem;
    private final WatchConfigRepository launchRepository;
    private final LauncherPreference preference;
    private final int resolution;

    /* JADX INFO: renamed from: com.dw.launcher.data.repository.AssetsClockRepository$getClockList$1, reason: invalid class name */
    /* JADX INFO: compiled from: AssetsClockRepository.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.data.repository.AssetsClockRepository", f = "AssetsClockRepository.kt", i = {0, 0}, l = {118}, m = "getClockList", n = {"this", "result"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetsClockRepository.this.getClockList((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.dw.launcher.data.repository.AssetsClockRepository$getClockList$3, reason: invalid class name */
    /* JADX INFO: compiled from: AssetsClockRepository.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.data.repository.AssetsClockRepository", f = "AssetsClockRepository.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {154, 162, 164}, m = "getClockList", n = {"this", "filtWatchList", "result", "clock", "this", "filtWatchList", "result", "clock", "this", "filtWatchList", "result", "clock"}, s = {"L$0", "L$1", "L$2", "L$4", "L$0", "L$1", "L$2", "L$4", "L$0", "L$1", "L$2", "L$4"})
    static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetsClockRepository.this.getClockList(0, (Continuation) this);
        }
    }

    private final boolean hasExactResolution(int width, int height) {
        return false;
    }

    @Override // com.dw.launcher.data.repository.ClockRepository
    public Clock findPreferClockList() {
        return null;
    }

    @Inject
    public AssetsClockRepository(Context context, LauncherPreference launcherPreference, WatchConfigRepository watchConfigRepository, ClockConfigDao clockConfigDao) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(launcherPreference, "preference");
        Intrinsics.checkNotNullParameter(watchConfigRepository, "launchRepository");
        Intrinsics.checkNotNullParameter(clockConfigDao, "clockConfigDao");
        this.context = context;
        this.preference = launcherPreference;
        this.launchRepository = watchConfigRepository;
        this.clockConfigDao = clockConfigDao;
        this.resolution = context.getResources().getDisplayMetrics().widthPixels;
        this.desiredHeight = context.getResources().getDisplayMetrics().heightPixels;
        File file = new File(Environment.getRootDirectory().getPath() + "/dw_config/dial");
        this.fileROOT = file;
        this.isLoadFromFileSystem = true;
        if (!file.exists()) {
            file.mkdirs();
        }
        this.isLoadFromFileSystem = true;
        this.ROOT = file.getAbsolutePath();
        this.CONFIG_XML_FILE_NAME = "DialConf.xml";
    }

    private final String getClosestResolution(int desiredWidth) {
        List listListOf = CollectionsKt.listOf(new Integer[]{240, 320, 368});
        int iIntValue = ((Number) CollectionsKt.first(listListOf)).intValue();
        int iAbs = Math.abs(desiredWidth - iIntValue);
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            int iIntValue2 = ((Number) it.next()).intValue();
            int iAbs2 = Math.abs(desiredWidth - iIntValue2);
            if (iAbs2 < iAbs) {
                iIntValue = iIntValue2;
                iAbs = iAbs2;
            }
        }
        Timber.Forest.d("----closestWidth = " + iIntValue, new Object[0]);
        if (iIntValue == 240) {
            return "clock_368";
        }
        return "clock_" + iIntValue;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.dw.launcher.data.repository.ClockRepository
    public Object getClockList(Continuation<? super List<Clock>> continuation) {
        AnonymousClass1 anonymousClass1;
        ArrayList arrayList;
        AssetsClockRepository assetsClockRepository;
        Iterator it;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Timber.Forest.i("----getClockList ROOT = " + this.ROOT, new Object[0]);
                List<ClockConfig> listQueryAllFromAssets = this.clockConfigDao.queryAllFromAssets();
                if (listQueryAllFromAssets.isEmpty()) {
                    loadClockFromAssets();
                    listQueryAllFromAssets = this.clockConfigDao.queryAllFromAssets();
                }
                arrayList = new ArrayList();
                assetsClockRepository = this;
                it = listQueryAllFromAssets.iterator();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) anonymousClass1.L$2;
                arrayList = (List) anonymousClass1.L$1;
                assetsClockRepository = (AssetsClockRepository) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                ClockConfig clockConfig = (ClockConfig) it.next();
                Clock clock = new Clock(assetsClockRepository.context, clockConfig, !assetsClockRepository.isLoadFromFileSystem);
                arrayList.add(clock);
                if (Intrinsics.areEqual(clockConfig.getId(), assetsClockRepository.preference.getPreferClock())) {
                    anonymousClass1.L$0 = assetsClockRepository;
                    anonymousClass1.L$1 = arrayList;
                    anonymousClass1.L$2 = it;
                    anonymousClass1.label = 1;
                    if (clock.loadFlatter(anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } catch (Exception e) {
            Timber.Forest.e(e, "----load assets clock failure", new Object[0]);
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0149 A[Catch: Exception -> 0x0283, TryCatch #1 {Exception -> 0x0283, blocks: (B:44:0x0143, B:46:0x0149, B:48:0x0151, B:50:0x015b, B:53:0x0171, B:56:0x0194, B:58:0x019a, B:60:0x01a8, B:61:0x01ac, B:63:0x01b2, B:71:0x0201, B:73:0x0207, B:84:0x0278), top: B:92:0x0143 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0151 A[Catch: Exception -> 0x0283, TryCatch #1 {Exception -> 0x0283, blocks: (B:44:0x0143, B:46:0x0149, B:48:0x0151, B:50:0x015b, B:53:0x0171, B:56:0x0194, B:58:0x019a, B:60:0x01a8, B:61:0x01ac, B:63:0x01b2, B:71:0x0201, B:73:0x0207, B:84:0x0278), top: B:92:0x0143 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0201 A[Catch: Exception -> 0x0283, TRY_ENTER, TryCatch #1 {Exception -> 0x0283, blocks: (B:44:0x0143, B:46:0x0149, B:48:0x0151, B:50:0x015b, B:53:0x0171, B:56:0x0194, B:58:0x019a, B:60:0x01a8, B:61:0x01ac, B:63:0x01b2, B:71:0x0201, B:73:0x0207, B:84:0x0278), top: B:92:0x0143 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0207 A[Catch: Exception -> 0x0283, TRY_LEAVE, TryCatch #1 {Exception -> 0x0283, blocks: (B:44:0x0143, B:46:0x0149, B:48:0x0151, B:50:0x015b, B:53:0x0171, B:56:0x0194, B:58:0x019a, B:60:0x01a8, B:61:0x01ac, B:63:0x01b2, B:71:0x0201, B:73:0x0207, B:84:0x0278), top: B:92:0x0143 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x023f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:76:0x0240  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x026c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:98:0x0278 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x0171 A[ADDED_TO_REGION, EDGE_INSN: B:99:0x0171->B:53:0x0171 BREAK  A[LOOP:0: B:92:0x0143->B:52:0x0170], REMOVE, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x026a -> B:82:0x026d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.dw.launcher.data.repository.ClockRepository
    public java.lang.Object getClockList(int r18, kotlin.coroutines.Continuation<? super java.util.List<com.dw.launcher.data.entity.Clock>> r19) {
        /*
            Method dump skipped, instruction units count: 658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dw.launcher.data.repository.AssetsClockRepository.getClockList(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.dw.launcher.data.repository.ClockRepository
    public List<Clock> loadClockFromAssets() {
        Timber.Forest.i("----loadClockFromAssets", new Object[0]);
        ArrayList arrayList = new ArrayList();
        try {
            if (!this.isLoadFromFileSystem) {
                String[] list = this.context.getAssets().list(this.ROOT);
                if (list != null) {
                    for (String str : list) {
                        String str2 = this.ROOT + '/' + str;
                        String str3 = str2 + '/' + this.CONFIG_XML_FILE_NAME;
                        ClockConfig clockConfig = new ClockConfig(str2, !this.isLoadFromFileSystem);
                        Log.i("lkang", "configXmlFilePath = " + str3);
                        InputStream inputStreamOpen = this.context.getAssets().open(str3, 2);
                        Intrinsics.checkNotNull(inputStreamOpen);
                        clockConfig.loadConfig(inputStreamOpen);
                        this.clockConfigDao.insert(clockConfig);
                        arrayList.add(new Clock(this.context, clockConfig, !this.isLoadFromFileSystem));
                    }
                }
            } else {
                String[] list2 = new File(this.ROOT).list();
                if (list2 != null) {
                    for (String str4 : list2) {
                        String str5 = this.ROOT + '/' + str4;
                        String str6 = str5 + '/' + this.CONFIG_XML_FILE_NAME;
                        ClockConfig clockConfig2 = new ClockConfig(str5, !this.isLoadFromFileSystem);
                        Timber.Forest.d(" configXmlFilePath = " + str6 + " clockPath: " + str5, new Object[0]);
                        clockConfig2.loadConfig(new FileInputStream(new File(str6)));
                        this.clockConfigDao.insert(clockConfig2);
                        arrayList.add(new Clock(this.context, clockConfig2, !this.isLoadFromFileSystem));
                    }
                }
            }
        } catch (Exception e) {
            Timber.Forest.e(e, "----load assets clock failure", new Object[0]);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: com.dw.launcher.data.repository.AssetsClockRepository$saveOrUpdateClock$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetsClockRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.data.repository.AssetsClockRepository$saveOrUpdateClock$1", f = "AssetsClockRepository.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
    static final class C00331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Clock $clock;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00331(Clock clock, Continuation<? super C00331> continuation) {
            super(2, continuation);
            this.$clock = clock;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AssetsClockRepository.this.new C00331(this.$clock, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AssetsClockRepository.this.saveClock(this.$clock, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.dw.launcher.data.repository.ClockRepository
    public void saveOrUpdateClock(Clock clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new C00331(clock, null), 3, (Object) null);
    }

    @Override // com.dw.launcher.data.repository.ClockRepository
    public Object switchToTargetDynamicClock(Clock clock, Continuation<? super Clock> continuation) {
        return findDynamicChangeClock(clock.getConfig());
    }

    /* JADX INFO: renamed from: com.dw.launcher.data.repository.AssetsClockRepository$switchToNextClickedClock$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetsClockRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/dw/launcher/data/entity/Clock;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.data.repository.AssetsClockRepository$switchToNextClickedClock$2", f = "AssetsClockRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00342 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Clock>, Object> {
        final /* synthetic */ Clock $current;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00342(Clock clock, Continuation<? super C00342> continuation) {
            super(2, continuation);
            this.$current = clock;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AssetsClockRepository.this.new C00342(this.$current, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Clock> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ClockConfigDao clockConfigDao = AssetsClockRepository.this.clockConfigDao;
                String parent_id = this.$current.getConfig().getParent_id();
                Intrinsics.checkNotNull(parent_id);
                List<ClockConfig> listQueryAssetsByParentId = clockConfigDao.queryAssetsByParentId(parent_id);
                AssetsClockRepository assetsClockRepository = AssetsClockRepository.this;
                for (ClockConfig clockConfig : listQueryAssetsByParentId) {
                    clockConfig.setClick_id_is_current(0);
                    assetsClockRepository.clockConfigDao.updateClickedIdIndexByParentId(clockConfig);
                }
                ClockConfigDao clockConfigDao2 = AssetsClockRepository.this.clockConfigDao;
                String parent_id2 = this.$current.getConfig().getParent_id();
                Intrinsics.checkNotNull(parent_id2);
                ClockConfig clockConfigFindClickedNextClock = clockConfigDao2.findClickedNextClock(parent_id2, this.$current.getConfig().getNext_id());
                AssetsClockRepository assetsClockRepository2 = AssetsClockRepository.this;
                Clock clock = this.$current;
                if (clockConfigFindClickedNextClock == null) {
                    return null;
                }
                clockConfigFindClickedNextClock.setClick_id_is_current(1);
                assetsClockRepository2.clockConfigDao.updateClickedIdIndexByParentId(clockConfigFindClickedNextClock);
                String parent_id3 = clock.getConfig().getParent_id();
                Intrinsics.checkNotNull(parent_id3);
                clockConfigFindClickedNextClock.setId(parent_id3);
                return new Clock(assetsClockRepository2.context, clockConfigFindClickedNextClock, !assetsClockRepository2.isLoadFromFileSystem);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.dw.launcher.data.repository.ClockRepository
    public Object switchToNextClickedClock(Clock clock, Continuation<? super Clock> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00342(clock, null), continuation);
    }

    @Override // com.dw.launcher.data.repository.ClockRepository
    public boolean isNeedChangeToDynamicClock(Clock clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        if (clock.getConfig().supportDynamicChange()) {
            ClockConfig config = clock.getConfig();
            int change_starttime = config.getChange_starttime();
            int change_endtime = config.getChange_endtime();
            if (change_starttime > change_endtime) {
                change_endtime += 1440;
            }
            Calendar calendar = Calendar.getInstance();
            int i = (calendar.get(11) * 60) + calendar.get(12);
            Timber.Forest.d("是否要变更表盘  id: " + config.getId() + " parentId: " + config.getParent_id() + " startTime: " + change_starttime + " endTime: " + change_endtime + "  ----currentMin " + i, new Object[0]);
            if (change_starttime > i || i > change_endtime) {
                return true;
            }
        }
        return false;
    }

    private final Clock findDynamicChangeClock(ClockConfig clock2) {
        try {
            ClockConfigDao clockConfigDao = this.clockConfigDao;
            String parent_id = clock2.getParent_id();
            Intrinsics.checkNotNull(parent_id);
            for (ClockConfig clockConfig : clockConfigDao.queryAssetsByParentId(parent_id)) {
                int change_starttime = clockConfig.getChange_starttime();
                int change_endtime = clockConfig.getChange_endtime();
                if (change_starttime > change_endtime) {
                    change_endtime += 1440;
                }
                Calendar calendar = Calendar.getInstance();
                int i = (calendar.get(11) * 60) + calendar.get(12);
                if (change_starttime <= i && i <= change_endtime) {
                    Timber.Forest.d("配置：  id: " + clockConfig.getId() + " parentId: " + clockConfig.getParent_id() + " startTime: " + change_starttime + " endTime: " + change_endtime + "  ----currentMin " + i, new Object[0]);
                    String parent_id2 = clock2.getParent_id();
                    Intrinsics.checkNotNull(parent_id2);
                    clockConfig.setId(parent_id2);
                    return new Clock(this.context, clockConfig, !this.isLoadFromFileSystem);
                }
            }
            return null;
        } catch (Exception e) {
            Timber.Forest.e(e, "----load assets clock findPreferClockList failure", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: renamed from: com.dw.launcher.data.repository.AssetsClockRepository$findCurrentClickedClock$2, reason: invalid class name */
    /* JADX INFO: compiled from: AssetsClockRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/dw/launcher/data/entity/Clock;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.data.repository.AssetsClockRepository$findCurrentClickedClock$2", f = "AssetsClockRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Clock>, Object> {
        final /* synthetic */ ClockConfig $clock2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ClockConfig clockConfig, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$clock2 = clockConfig;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AssetsClockRepository.this.new AnonymousClass2(this.$clock2, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Clock> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    ClockConfigDao clockConfigDao = AssetsClockRepository.this.clockConfigDao;
                    String parent_id = this.$clock2.getParent_id();
                    Intrinsics.checkNotNull(parent_id);
                    List<ClockConfig> listQueryAssetsByParentId = clockConfigDao.queryAssetsByParentId(parent_id);
                    ClockConfig clockConfig = this.$clock2;
                    AssetsClockRepository assetsClockRepository = AssetsClockRepository.this;
                    for (ClockConfig clockConfig2 : listQueryAssetsByParentId) {
                        Timber.Forest.d("配置：  id: " + clockConfig2.getId() + " parentId: " + clockConfig2.getParent_id() + " click_id_is_current: " + clockConfig2.getClick_id_is_current(), new Object[0]);
                        if (clockConfig2.getClick_id_is_current() == 1) {
                            String parent_id2 = clockConfig.getParent_id();
                            Intrinsics.checkNotNull(parent_id2);
                            clockConfig2.setId(parent_id2);
                            return new Clock(assetsClockRepository.context, clockConfig2, !assetsClockRepository.isLoadFromFileSystem);
                        }
                    }
                    return null;
                } catch (Exception e) {
                    Timber.Forest.e(e, "----load assets clock findPreferClockList failure", new Object[0]);
                    return null;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object findCurrentClickedClock(ClockConfig clockConfig, Continuation<? super Clock> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(clockConfig, null), continuation);
    }

    /* JADX INFO: renamed from: com.dw.launcher.data.repository.AssetsClockRepository$saveClock$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetsClockRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.data.repository.AssetsClockRepository$saveClock$2", f = "AssetsClockRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00322 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
        final /* synthetic */ Clock $clock;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00322(Clock clock, Continuation<? super C00322> continuation) {
            super(2, continuation);
            this.$clock = clock;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AssetsClockRepository.this.new C00322(this.$clock, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxLong(AssetsClockRepository.this.clockConfigDao.insert(this.$clock.getConfig()));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveClock(Clock clock, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C00322(clock, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
