package com.dw.launcher.data.repository;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.config.PackageNameConstant;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.entity.RecentTask;
import com.dw.launcher.ui.shortcut.ShortcutInflater;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: RecentTaskRepository.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001eB\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0016J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000fJ \u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/dw/launcher/data/repository/RecentTaskRepository;", "Lcom/dw/launcher/data/repository/IRecentTaskRepository;", "context", "Landroid/content/Context;", "inflater", "Lcom/dw/launcher/ui/shortcut/ShortcutInflater;", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "(Landroid/content/Context;Lcom/dw/launcher/ui/shortcut/ShortcutInflater;Lcom/dw/launcher/data/repository/LauncherRepository;)V", "getInflater", "()Lcom/dw/launcher/ui/shortcut/ShortcutInflater;", "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "recentTaskList", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "checkRecentTaskValide", BuildConfig.FLAVOR, "packageName", "clearForbiddenTask", BuildConfig.FLAVOR, "createRecentTaskByPackageName", "Lcom/dw/launcher/data/entity/RecentTask;", "className", "excludeFromRecents", "getRecentAppPackageNames", "Lcom/dw/launcher/data/repository/RecentTaskRepository$AppInfo;", "maxCount", BuildConfig.FLAVOR, "getRecentTask", "AppInfo", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecentTaskRepository implements IRecentTaskRepository {
    private final Context context;
    private final ShortcutInflater inflater;
    private final LauncherRepository launcherRepository;
    private final List<String> recentTaskList;

    @Override // com.dw.launcher.data.repository.IRecentTaskRepository
    public void clearForbiddenTask() {
    }

    @Inject
    public RecentTaskRepository(Context context, ShortcutInflater shortcutInflater, LauncherRepository launcherRepository) {
        ArrayList arrayList;
        List<LaunchConfig.SlideMenuApp> menuSlideAppList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(shortcutInflater, "inflater");
        Intrinsics.checkNotNullParameter(launcherRepository, "launcherRepository");
        this.context = context;
        this.inflater = shortcutInflater;
        this.launcherRepository = launcherRepository;
        LaunchConfig launchConfigLoadConfig = launcherRepository.loadConfig();
        if (launchConfigLoadConfig == null || (menuSlideAppList = launchConfigLoadConfig.getMenuSlideAppList()) == null) {
            arrayList = null;
        } else {
            List<LaunchConfig.SlideMenuApp> list = menuSlideAppList;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(((LaunchConfig.SlideMenuApp) it.next()).getPkg());
            }
            arrayList = arrayList2;
        }
        this.recentTaskList = arrayList;
    }

    public final ShortcutInflater getInflater() {
        return this.inflater;
    }

    public final LauncherRepository getLauncherRepository() {
        return this.launcherRepository;
    }

    @Override // com.dw.launcher.data.repository.IRecentTaskRepository
    public List<RecentTask> getRecentTask() {
        ArrayList arrayList = new ArrayList();
        LaunchConfig launchConfigLoadConfig = this.launcherRepository.loadConfig();
        Intrinsics.checkNotNull(launchConfigLoadConfig);
        if (launchConfigLoadConfig.getMenuSlideAppDynastic() == 1) {
            LaunchConfig launchConfigLoadConfig2 = this.launcherRepository.loadConfig();
            Intrinsics.checkNotNull(launchConfigLoadConfig2);
            int menuSlideAppCount = launchConfigLoadConfig2.getMenuSlideAppCount();
            List<AppInfo> recentAppPackageNames = getRecentAppPackageNames(this.context, menuSlideAppCount);
            ArrayList arrayList2 = new ArrayList();
            List<String> list = this.recentTaskList;
            Intrinsics.checkNotNull(list);
            arrayList2.addAll(list.subList(0, menuSlideAppCount));
            ArrayList<AppInfo> arrayList3 = new ArrayList();
            Intrinsics.checkNotNull(recentAppPackageNames);
            if (true ^ recentAppPackageNames.isEmpty()) {
                for (AppInfo appInfo : recentAppPackageNames) {
                    int iIndexOf = arrayList2.indexOf(appInfo.getPackageName());
                    arrayList3.add(new AppInfo(appInfo.getPackageName(), appInfo.getClassName()));
                    if (iIndexOf != -1) {
                        arrayList2.remove(iIndexOf);
                    }
                    arrayList3.size();
                }
            }
            int size = menuSlideAppCount - arrayList3.size();
            if (size > 0) {
                for (String str : arrayList2.subList(0, size)) {
                    List<AppInfo> list2 = recentAppPackageNames;
                    if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                        Iterator<T> it = list2.iterator();
                        do {
                            if (it.hasNext()) {
                            }
                        } while (!Intrinsics.areEqual(((AppInfo) it.next()).getPackageName(), str));
                    }
                    arrayList3.add(new AppInfo(str, null));
                }
            }
            for (AppInfo appInfo2 : arrayList3) {
                RecentTask recentTaskCreateRecentTaskByPackageName = createRecentTaskByPackageName(appInfo2.getPackageName(), appInfo2.getClassName());
                if (recentTaskCreateRecentTaskByPackageName != null) {
                    arrayList.add(recentTaskCreateRecentTaskByPackageName);
                }
            }
        } else {
            LaunchConfig launchConfigLoadConfig3 = this.launcherRepository.loadConfig();
            Intrinsics.checkNotNull(launchConfigLoadConfig3);
            int iCoerceAtMost = RangesKt.coerceAtMost(launchConfigLoadConfig3.getMenuSlideAppCount(), 4);
            List<String> list3 = this.recentTaskList;
            Intrinsics.checkNotNull(list3);
            int size2 = list3.size();
            for (int i = 0; i < size2; i++) {
                List<String> list4 = this.recentTaskList;
                Intrinsics.checkNotNull(list4);
                RecentTask recentTaskCreateRecentTaskByPackageName$default = IRecentTaskRepository.DefaultImpls.createRecentTaskByPackageName$default(this, list4.get(i), null, 2, null);
                if (recentTaskCreateRecentTaskByPackageName$default != null) {
                    arrayList.add(recentTaskCreateRecentTaskByPackageName$default);
                }
                if (arrayList.size() >= iCoerceAtMost) {
                    break;
                }
            }
            if (arrayList.size() == 0) {
                RecentTaskRepository recentTaskRepository = this;
                RecentTask recentTaskCreateRecentTaskByPackageName$default2 = IRecentTaskRepository.DefaultImpls.createRecentTaskByPackageName$default(recentTaskRepository, PackageNameConstant.PACKAGE_NAME_GOOGLEPLAY, null, 2, null);
                if (recentTaskCreateRecentTaskByPackageName$default2 != null) {
                    arrayList.add(recentTaskCreateRecentTaskByPackageName$default2);
                }
                RecentTask recentTaskCreateRecentTaskByPackageName$default3 = IRecentTaskRepository.DefaultImpls.createRecentTaskByPackageName$default(recentTaskRepository, PackageNameConstant.PACKAGE_NAME_DIALER, null, 2, null);
                if (recentTaskCreateRecentTaskByPackageName$default3 != null) {
                    arrayList.add(recentTaskCreateRecentTaskByPackageName$default3);
                }
            }
        }
        return arrayList;
    }

    @Override // com.dw.launcher.data.repository.IRecentTaskRepository
    public RecentTask createRecentTaskByPackageName(String packageName, String className) {
        Object next;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(packageName);
        List<ResolveInfo> listQueryIntentActivities = this.context.getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.checkNotNull(listQueryIntentActivities);
        if (!(!listQueryIntentActivities.isEmpty())) {
            return null;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (className != null) {
            Iterator<T> it = listQueryIntentActivities.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((ResolveInfo) next).activityInfo.name, className));
            objectRef.element = next;
        }
        if (objectRef.element == null) {
            objectRef.element = listQueryIntentActivities.get(0);
        }
        if (((ResolveInfo) objectRef.element) == null) {
            return null;
        }
        intent.setComponent(new ComponentName(packageName, ((ResolveInfo) objectRef.element).activityInfo.name));
        String str = ((ResolveInfo) objectRef.element).activityInfo.name;
        Intrinsics.checkNotNullExpressionValue(str, "name");
        return new RecentTask(packageName, str, intent, this.inflater.getDrawable((ResolveInfo) objectRef.element));
    }

    private final boolean checkRecentTaskValide(String packageName) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(packageName);
        List<ResolveInfo> listQueryIntentActivities = this.context.getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.checkNotNull(listQueryIntentActivities);
        return !listQueryIntentActivities.isEmpty();
    }

    private final List<AppInfo> getRecentAppPackageNames(Context context, int maxCount) {
        Object systemService = context.getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RecentTaskInfo> recentTasks = ((ActivityManager) systemService).getRecentTasks(maxCount + 5, 2);
        Intrinsics.checkNotNullExpressionValue(recentTasks, "getRecentTasks(...)");
        ArrayList arrayList = new ArrayList();
        for (ActivityManager.RecentTaskInfo recentTaskInfo : recentTasks) {
            ComponentName component = recentTaskInfo.baseIntent.getComponent();
            Intrinsics.checkNotNull(component);
            String packageName = component.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            ComponentName component2 = recentTaskInfo.baseIntent.getComponent();
            Intrinsics.checkNotNull(component2);
            String className = component2.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
            if (checkRecentTaskValide(packageName)) {
                ArrayList arrayList2 = arrayList;
                if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
                    if (!Intrinsics.areEqual(packageName, com.dw.launcher.BuildConfig.APPLICATION_ID)) {
                        arrayList.add(new AppInfo(packageName, className));
                    }
                } else {
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            AppInfo appInfo = (AppInfo) it.next();
                            if (!Intrinsics.areEqual(appInfo.getPackageName(), packageName) || !Intrinsics.areEqual(appInfo.getClassName(), className)) {
                            }
                        } else if (!Intrinsics.areEqual(packageName, com.dw.launcher.BuildConfig.APPLICATION_ID) && !Intrinsics.areEqual(packageName, "com.android.systemui")) {
                            arrayList.add(new AppInfo(packageName, className));
                        }
                    }
                }
                if (arrayList.size() >= maxCount) {
                    break;
                }
            }
        }
        return arrayList;
    }

    public final void excludeFromRecents(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Object systemService = this.context.getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        for (ActivityManager.AppTask appTask : ((ActivityManager) systemService).getAppTasks()) {
            ComponentName componentName = appTask.getTaskInfo().baseActivity;
            Intrinsics.checkNotNull(componentName);
            if (Intrinsics.areEqual(componentName.getPackageName(), packageName)) {
                appTask.setExcludeFromRecents(true);
            }
        }
    }

    /* JADX INFO: compiled from: RecentTaskRepository.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/dw/launcher/data/repository/RecentTaskRepository$AppInfo;", BuildConfig.FLAVOR, "packageName", BuildConfig.FLAVOR, "className", "(Ljava/lang/String;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "getPackageName", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AppInfo {
        private final String className;
        private final String packageName;

        public static /* synthetic */ AppInfo copy$default(AppInfo appInfo, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = appInfo.packageName;
            }
            if ((i & 2) != 0) {
                str2 = appInfo.className;
            }
            return appInfo.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPackageName() {
            return this.packageName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getClassName() {
            return this.className;
        }

        public final AppInfo copy(String packageName, String className) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            return new AppInfo(packageName, className);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AppInfo)) {
                return false;
            }
            AppInfo appInfo = (AppInfo) other;
            return Intrinsics.areEqual(this.packageName, appInfo.packageName) && Intrinsics.areEqual(this.className, appInfo.className);
        }

        public int hashCode() {
            int iHashCode = this.packageName.hashCode() * 31;
            String str = this.className;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "AppInfo(packageName=" + this.packageName + ", className=" + this.className + ')';
        }

        public AppInfo(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "packageName");
            this.packageName = str;
            this.className = str2;
        }

        public /* synthetic */ AppInfo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        public final String getClassName() {
            return this.className;
        }

        public final String getPackageName() {
            return this.packageName;
        }
    }
}
