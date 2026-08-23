package com.dw.launcher.data.repository;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.core.skin.SkinThemeManager;
import com.dw.launcher.core.skin.config.SkinConfig;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.config.AppFilterConfig;
import com.dw.launcher.data.config.PackageNameConstant;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.entity.Shortcut;
import com.dw.launcher.data.entity.ThemeDescribe;
import com.dw.launcher.data.entity.ThemeItem;
import com.dw.launcher.ui.shortcut.ShortcutInflater;
import com.dw.launcher.util.AppLock;
import com.dw.launcher.util.SystemUtils;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

/* JADX INFO: compiled from: ShortcutRepository.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\"\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\u001dH\u0016J!\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001fj\b\u0012\u0004\u0012\u00020\f` H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\b\u0010!\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u00020\u0019H\u0016R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/dw/launcher/data/repository/ShortcutRepository;", "Lcom/dw/launcher/data/repository/IShortcutRepository;", "context", "Landroid/content/Context;", "inflater", "Lcom/dw/launcher/ui/shortcut/ShortcutInflater;", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "(Landroid/content/Context;Lcom/dw/launcher/ui/shortcut/ShortcutInflater;Lcom/dw/launcher/data/repository/LauncherRepository;)V", "_shortcuts", "Landroidx/lifecycle/MutableLiveData;", BuildConfig.FLAVOR, "Lcom/dw/launcher/data/entity/Shortcut;", "_themes", "Lcom/dw/launcher/data/entity/ThemeItem;", "getAppInstallTime", BuildConfig.FLAVOR, "packageName", BuildConfig.FLAVOR, "getResolveInfoByClassName", "Landroid/content/pm/ResolveInfo;", "className", "getResolveInfoByPackageName", "getShortcuts", "loadShortcuts", BuildConfig.FLAVOR, "loadThemePreview", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadThemes", "Landroidx/lifecycle/LiveData;", "queryShortcuts", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reload", "reloadTheme", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ShortcutRepository implements IShortcutRepository {
    private final MutableLiveData<List<Shortcut>> _shortcuts;
    private final MutableLiveData<List<ThemeItem>> _themes;
    private final Context context;
    private final ShortcutInflater inflater;
    private final LauncherRepository launcherRepository;

    @Inject
    public ShortcutRepository(Context context, ShortcutInflater shortcutInflater, LauncherRepository launcherRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(shortcutInflater, "inflater");
        Intrinsics.checkNotNullParameter(launcherRepository, "launcherRepository");
        this.context = context;
        this.inflater = shortcutInflater;
        this.launcherRepository = launcherRepository;
        this._shortcuts = new MutableLiveData<>();
        this._themes = new MutableLiveData<>();
    }

    @Override // com.dw.launcher.data.repository.IShortcutRepository
    public MutableLiveData<List<Shortcut>> getShortcuts() {
        Timber.Forest.v("----" + this + ".getShortcuts, _shortcuts.value: " + this._shortcuts.getValue(), new Object[0]);
        return this._shortcuts;
    }

    /* JADX INFO: renamed from: com.dw.launcher.data.repository.ShortcutRepository$loadThemes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ShortcutRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.data.repository.ShortcutRepository$loadThemes$1", f = "ShortcutRepository.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
    static final class C00351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C00351(Continuation<? super C00351> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ShortcutRepository.this.new C00351(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = ShortcutRepository.this._themes;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objLoadThemePreview = ShortcutRepository.this.loadThemePreview((Continuation) this);
                if (objLoadThemePreview == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                obj = objLoadThemePreview;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            mutableLiveData.setValue(obj);
            return Unit.INSTANCE;
        }
    }

    @Override // com.dw.launcher.data.repository.IShortcutRepository
    public LiveData<List<ThemeItem>> loadThemes() {
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new C00351(null), 3, (Object) null);
        return this._themes;
    }

    /* JADX INFO: renamed from: com.dw.launcher.data.repository.ShortcutRepository$loadThemePreview$2, reason: invalid class name */
    /* JADX INFO: compiled from: ShortcutRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/dw/launcher/data/entity/ThemeItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.data.repository.ShortcutRepository$loadThemePreview$2", f = "ShortcutRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<ThemeItem>>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ShortcutRepository.this.new AnonymousClass2(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<ThemeItem>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) throws IOException {
            String[] list;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            String language = SystemUtils.INSTANCE.getLanguage(ShortcutRepository.this.context);
            SkinThemeManager.getInstance().init(ShortcutRepository.this.context);
            String[] list2 = new File(String.valueOf(SkinConfig.THEME_DIR)).list();
            Intrinsics.checkNotNullExpressionValue(list2, "list(...)");
            for (String str : list2) {
                AssetManager assetManager = SkinThemeManager.getInstance().getAssetManager(new File(SkinConfig.THEME_DIR, str).getAbsolutePath());
                if (assetManager != null) {
                    InputStream inputStreamOpen = assetManager.open("thumb.png");
                    Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
                    if (StringsKt.contains$default(language, "zh", false, 2, (Object) null) && (list = assetManager.list(BuildConfig.FLAVOR)) != null) {
                        Intrinsics.checkNotNull(list);
                        if (ArraysKt.contains(list, "thumb_zh.png")) {
                            inputStreamOpen = assetManager.open("thumb_zh.png");
                            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
                        }
                    }
                    Drawable drawableCreateFromStream = BitmapDrawable.createFromStream(inputStreamOpen, null);
                    ThemeDescribe themeDescribe = (ThemeDescribe) new GsonBuilder().create().fromJson(new InputStreamReader(assetManager.open("describe.json")), ThemeDescribe.class);
                    Timber.Forest.d("---  fileName: " + str + ' ', new Object[0]);
                    int type = themeDescribe.getType();
                    String name = themeDescribe.getName();
                    Intrinsics.checkNotNull(drawableCreateFromStream);
                    arrayList.add(new ThemeItem(type, name, drawableCreateFromStream, SkinConfig.THEME_DIR + File.separator + str));
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadThemePreview(Continuation<? super List<ThemeItem>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }

    @Override // com.dw.launcher.data.repository.IShortcutRepository
    public void reload() {
        Timber.Forest.v("----" + this + ".reload", new Object[0]);
        loadShortcuts();
    }

    @Override // com.dw.launcher.data.repository.IShortcutRepository
    public void reloadTheme() {
        this.inflater.reset();
        loadShortcuts();
    }

    /* JADX INFO: renamed from: com.dw.launcher.data.repository.ShortcutRepository$loadShortcuts$1, reason: invalid class name */
    /* JADX INFO: compiled from: ShortcutRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.data.repository.ShortcutRepository$loadShortcuts$1", f = "ShortcutRepository.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ShortcutRepository.this.new AnonymousClass1(continuation);
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
                obj = ShortcutRepository.this.queryShortcuts((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ShortcutRepository.this._shortcuts.setValue((ArrayList) obj);
            Timber.Forest.v("----loadShortcuts, _shortcuts.value: " + ShortcutRepository.this._shortcuts.getValue(), new Object[0]);
            return Unit.INSTANCE;
        }
    }

    private final void loadShortcuts() {
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.dw.launcher.data.repository.ShortcutRepository$queryShortcuts$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ShortcutRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/dw/launcher/data/entity/Shortcut;", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.data.repository.ShortcutRepository$queryShortcuts$2", f = "ShortcutRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00362 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<Shortcut>>, Object> {
        int label;

        C00362(Continuation<? super C00362> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ShortcutRepository.this.new C00362(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArrayList<Shortcut>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:130:0x019a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:132:0x019a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:60:0x0128  */
        /* JADX WARN: Code duplicated, block: B:62:0x012e  */
        /* JADX WARN: Code duplicated, block: B:65:0x0135  */
        /* JADX WARN: Code duplicated, block: B:69:0x013d A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:78:0x015e  */
        /* JADX WARN: Code duplicated, block: B:81:0x0165  */
        /* JADX WARN: Code duplicated, block: B:83:0x0168  */
        /* JADX WARN: Code duplicated, block: B:84:0x016b  */
        /* JADX WARN: Code duplicated, block: B:87:0x0174  */
        /* JADX WARN: Code duplicated, block: B:89:0x018f  */
        /* JADX WARN: Code duplicated, block: B:92:0x0196  */
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            ArrayList arrayListEmptyList;
            List<LaunchConfig.OrderAppInfo> orderAppList;
            LaunchConfig.FilterAppInfo filterAppInfo;
            ResolveInfo resolveInfo;
            String str;
            AppFilterConfig appFilterConfig;
            ResolveInfo resolveInfo2;
            String str2;
            ResolveInfo resolveInfo3;
            String str3;
            ActivityInfo activityInfo;
            ActivityInfo activityInfo2;
            ActivityInfo activityInfo3;
            ActivityInfo activityInfo4;
            List<LaunchConfig.FilterAppInfo> filterAppList;
            Object next;
            ActivityInfo activityInfo5;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList2 = new ArrayList();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> listQueryIntentActivities = ShortcutRepository.this.context.getPackageManager().queryIntentActivities(intent, 0);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            boolean z = ShortcutRepository.this.context.getPackageManager().getLaunchIntentForPackage("com.dw.sms") != null;
            if (Settings.Global.getInt(ShortcutRepository.this.context.getContentResolver(), "hide_forbidden_app", 0) == 1) {
                arrayList = AppLock.getForbidPackageListForUrl(ShortcutRepository.this.context);
            } else {
                arrayList = new ArrayList();
            }
            Intrinsics.checkNotNull(listQueryIntentActivities);
            ShortcutRepository shortcutRepository = ShortcutRepository.this;
            for (ResolveInfo resolveInfo4 : listQueryIntentActivities) {
                String str4 = resolveInfo4.activityInfo.packageName;
                Intrinsics.checkNotNullExpressionValue(str4, "packageName");
                Shortcut shortcut = new Shortcut(str4, resolveInfo4);
                LaunchConfig launchConfigLoadConfig = shortcutRepository.launcherRepository.loadConfig();
                if (launchConfigLoadConfig == null || (filterAppList = launchConfigLoadConfig.getFilterAppList()) == null) {
                    filterAppInfo = null;
                } else {
                    Iterator<T> it = filterAppList.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.areEqual(((LaunchConfig.FilterAppInfo) next).getActivityName(), (resolveInfo4 == null || (activityInfo5 = resolveInfo4.activityInfo) == null) ? null : activityInfo5.name));
                    filterAppInfo = (LaunchConfig.FilterAppInfo) next;
                }
                if (Settings.Global.getInt(shortcutRepository.context.getContentResolver(), NoDisturbComponent.WATCH_MODE, 0) == 1) {
                    ResolveInfo resolveInfo5 = shortcut.getResolveInfo();
                    String str5 = (resolveInfo5 == null || (activityInfo4 = resolveInfo5.activityInfo) == null) ? null : activityInfo4.name;
                    if (str5 == null) {
                        resolveInfo = shortcut.getResolveInfo();
                        if (resolveInfo != null) {
                            str = null;
                        } else {
                            str = null;
                        }
                        if (arrayList.contains(str)) {
                            appFilterConfig = AppFilterConfig.INSTANCE;
                            resolveInfo2 = shortcut.getResolveInfo();
                            if (resolveInfo2 != null) {
                                str2 = null;
                            } else {
                                str2 = null;
                            }
                            if (str2 == null) {
                                str2 = BuildConfig.FLAVOR;
                            } else {
                                Intrinsics.checkNotNull(str2);
                            }
                            if (!appFilterConfig.isFiltered(str2)) {
                                shortcut.load(shortcutRepository.context);
                                shortcutRepository.inflater.inflate(shortcut);
                                arrayList2.add(shortcut);
                                String packageName = shortcut.getPackageName();
                                resolveInfo3 = shortcut.getResolveInfo();
                                if (resolveInfo3 != null) {
                                    str3 = null;
                                } else {
                                    str3 = null;
                                }
                                linkedHashMap.put(packageName, str3);
                            }
                        }
                    } else {
                        int iHashCode = str5.hashCode();
                        if (iHashCode != -1911521685) {
                            if (iHashCode != -1013870190) {
                                if (iHashCode != -218555853 || !str5.equals("com.watch.iotchat.activity.MainActivity")) {
                                    resolveInfo = shortcut.getResolveInfo();
                                    if (resolveInfo != null) {
                                        str = null;
                                    } else {
                                        str = null;
                                    }
                                    if (arrayList.contains(str)) {
                                        appFilterConfig = AppFilterConfig.INSTANCE;
                                        resolveInfo2 = shortcut.getResolveInfo();
                                        if (resolveInfo2 != null) {
                                            str2 = null;
                                        } else {
                                            str2 = null;
                                        }
                                        if (str2 == null) {
                                            str2 = BuildConfig.FLAVOR;
                                        } else {
                                            Intrinsics.checkNotNull(str2);
                                        }
                                        if (!appFilterConfig.isFiltered(str2)) {
                                            shortcut.load(shortcutRepository.context);
                                            shortcutRepository.inflater.inflate(shortcut);
                                            arrayList2.add(shortcut);
                                            String packageName2 = shortcut.getPackageName();
                                            resolveInfo3 = shortcut.getResolveInfo();
                                            if (resolveInfo3 != null) {
                                                str3 = null;
                                            } else {
                                                str3 = null;
                                            }
                                            linkedHashMap.put(packageName2, str3);
                                        }
                                    }
                                }
                            } else if (!str5.equals("com.juphoon.cloud.vchat.ui.activities.ContactsActivity")) {
                                resolveInfo = shortcut.getResolveInfo();
                                if (resolveInfo != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                if (arrayList.contains(str)) {
                                    appFilterConfig = AppFilterConfig.INSTANCE;
                                    resolveInfo2 = shortcut.getResolveInfo();
                                    if (resolveInfo2 != null) {
                                        str2 = null;
                                    } else {
                                        str2 = null;
                                    }
                                    if (str2 == null) {
                                        str2 = BuildConfig.FLAVOR;
                                    } else {
                                        Intrinsics.checkNotNull(str2);
                                    }
                                    if (!appFilterConfig.isFiltered(str2)) {
                                        shortcut.load(shortcutRepository.context);
                                        shortcutRepository.inflater.inflate(shortcut);
                                        arrayList2.add(shortcut);
                                        String packageName3 = shortcut.getPackageName();
                                        resolveInfo3 = shortcut.getResolveInfo();
                                        if (resolveInfo3 != null) {
                                            str3 = null;
                                        } else {
                                            str3 = null;
                                        }
                                        linkedHashMap.put(packageName3, str3);
                                    }
                                }
                            }
                        } else if (!str5.equals("com.hyj.vchat.ui.activities.ContactsActivity")) {
                            resolveInfo = shortcut.getResolveInfo();
                            if (resolveInfo != null) {
                                str = null;
                            } else {
                                str = null;
                            }
                            if (arrayList.contains(str)) {
                                appFilterConfig = AppFilterConfig.INSTANCE;
                                resolveInfo2 = shortcut.getResolveInfo();
                                if (resolveInfo2 != null) {
                                    str2 = null;
                                } else {
                                    str2 = null;
                                }
                                if (str2 == null) {
                                    str2 = BuildConfig.FLAVOR;
                                } else {
                                    Intrinsics.checkNotNull(str2);
                                }
                                if (!appFilterConfig.isFiltered(str2)) {
                                    shortcut.load(shortcutRepository.context);
                                    shortcutRepository.inflater.inflate(shortcut);
                                    arrayList2.add(shortcut);
                                    String packageName4 = shortcut.getPackageName();
                                    resolveInfo3 = shortcut.getResolveInfo();
                                    if (resolveInfo3 != null) {
                                        str3 = null;
                                    } else {
                                        str3 = null;
                                    }
                                    linkedHashMap.put(packageName4, str3);
                                }
                            }
                        }
                    }
                } else {
                    resolveInfo = shortcut.getResolveInfo();
                    if (resolveInfo != null || (activityInfo3 = resolveInfo.activityInfo) == null) {
                        str = null;
                    } else {
                        str = activityInfo3.name;
                    }
                    if (arrayList.contains(str) && ((!z || (!Intrinsics.areEqual(shortcut.getPackageName(), "com.android.messaging") && !Intrinsics.areEqual(shortcut.getPackageName(), "com.android.contacts"))) && filterAppInfo == null)) {
                        appFilterConfig = AppFilterConfig.INSTANCE;
                        resolveInfo2 = shortcut.getResolveInfo();
                        if (resolveInfo2 != null || (activityInfo2 = resolveInfo2.activityInfo) == null) {
                            str2 = null;
                        } else {
                            str2 = activityInfo2.name;
                        }
                        if (str2 == null) {
                            str2 = BuildConfig.FLAVOR;
                        } else {
                            Intrinsics.checkNotNull(str2);
                        }
                        if (!appFilterConfig.isFiltered(str2)) {
                            shortcut.load(shortcutRepository.context);
                            shortcutRepository.inflater.inflate(shortcut);
                            arrayList2.add(shortcut);
                            String packageName5 = shortcut.getPackageName();
                            resolveInfo3 = shortcut.getResolveInfo();
                            if (resolveInfo3 != null || (activityInfo = resolveInfo3.activityInfo) == null) {
                                str3 = null;
                            } else {
                                str3 = activityInfo.name;
                            }
                            linkedHashMap.put(packageName5, str3);
                        }
                    }
                }
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            LaunchConfig launchConfigLoadConfig2 = ShortcutRepository.this.launcherRepository.loadConfig();
            List<LaunchConfig.OrderAppInfo> orderAppList2 = launchConfigLoadConfig2 != null ? launchConfigLoadConfig2.getOrderAppList() : null;
            if (orderAppList2 != null && !orderAppList2.isEmpty()) {
                LaunchConfig launchConfigLoadConfig3 = ShortcutRepository.this.launcherRepository.loadConfig();
                if (launchConfigLoadConfig3 == null || (orderAppList = launchConfigLoadConfig3.getOrderAppList()) == null) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                } else {
                    List<LaunchConfig.OrderAppInfo> list = orderAppList;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(((LaunchConfig.OrderAppInfo) it2.next()).getActName());
                    }
                    arrayListEmptyList = arrayList3;
                }
                objectRef.element = arrayListEmptyList;
                Timber.Forest.d("desiredOrder 非空 " + CollectionsKt.toList((Iterable) objectRef.element), new Object[0]);
            }
            Collection collection = (Collection) objectRef.element;
            if (collection == null || collection.isEmpty()) {
                objectRef.element = CollectionsKt.listOf(new String[]{PackageNameConstant.PACKAGE_NAME_DIALER, "com.android.contacts", "com.android.messaging", "com.android.gallery3d", PackageNameConstant.PACKAGE_NAME_BROWSER, "com.android.dialer", "com.android.deskclock", "com.divoiot.iotchronometer", "com.android.music", "com.android.soundrecorder", "com.android.documentsui", "com.dwiot.iotstepcounter", "com.divo.heartrate", "com.android.settings", com.dw.launcher.BuildConfig.APPLICATION_ID, com.dw.launcher.BuildConfig.APPLICATION_ID, PackageNameConstant.PACKAGE_NAME_GOOGLEPLAY, "com.google.android.apps.assistant", "com.google.android.calendar", "com.google.android.apps.searchlite", "com.google.android.calculator"});
            }
            final ShortcutRepository shortcutRepository2 = ShortcutRepository.this;
            CollectionsKt.sortWith(arrayList2, new Comparator() { // from class: com.dw.launcher.data.repository.ShortcutRepository$queryShortcuts$2$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    return ShortcutRepository.C00362.invokeSuspend$lambda$3(objectRef, shortcutRepository2, (Shortcut) obj2, (Shortcut) obj3);
                }
            });
            return arrayList2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$3(Ref.ObjectRef objectRef, ShortcutRepository shortcutRepository, Shortcut shortcut, Shortcut shortcut2) {
            ActivityInfo activityInfo;
            ActivityInfo activityInfo2;
            List list = (List) objectRef.element;
            ResolveInfo resolveInfo = shortcut.getResolveInfo();
            String str = null;
            int iIndexOf = CollectionsKt.indexOf(list, (resolveInfo == null || (activityInfo2 = resolveInfo.activityInfo) == null) ? null : activityInfo2.name);
            List list2 = (List) objectRef.element;
            ResolveInfo resolveInfo2 = shortcut2.getResolveInfo();
            if (resolveInfo2 != null && (activityInfo = resolveInfo2.activityInfo) != null) {
                str = activityInfo.name;
            }
            int iIndexOf2 = CollectionsKt.indexOf(list2, str);
            if (iIndexOf != -1 && iIndexOf2 != -1) {
                return iIndexOf - iIndexOf2;
            }
            if (iIndexOf != -1) {
                return -1;
            }
            if (iIndexOf2 != -1) {
                return 1;
            }
            return Intrinsics.compare(shortcutRepository.getAppInstallTime(shortcut.getPackageName(), shortcutRepository.context), shortcutRepository.getAppInstallTime(shortcut2.getPackageName(), shortcutRepository.context));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object queryShortcuts(Continuation<? super ArrayList<Shortcut>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00362(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getAppInstallTime(String packageName, Context context) {
        try {
            return context.getPackageManager().getPackageInfo(packageName, 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    private final ResolveInfo getResolveInfoByPackageName(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
        if (launchIntentForPackage != null) {
            return packageManager.resolveActivity(launchIntentForPackage, 0);
        }
        return null;
    }

    private final ResolveInfo getResolveInfoByClassName(Context context, String packageName, String className) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.setClassName(packageName, className);
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        if (!listQueryIntentActivities.isEmpty()) {
            return listQueryIntentActivities.get(0);
        }
        return null;
    }
}
