package com.dw.launcher.data.entity;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WatchFiltterConfig.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/dw/launcher/data/entity/WatchFiltterConfig;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "resolutions", BuildConfig.FLAVOR, "Lcom/dw/launcher/data/entity/WatchFiltterConfig$WatchfaceResolution;", "(Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getResolutions", "()Ljava/util/List;", "setResolutions", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "WatchInfo", "WatchfaceResolution", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class WatchFiltterConfig {
    private String name;
    private List<WatchfaceResolution> resolutions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WatchFiltterConfig copy$default(WatchFiltterConfig watchFiltterConfig, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = watchFiltterConfig.name;
        }
        if ((i & 2) != 0) {
            list = watchFiltterConfig.resolutions;
        }
        return watchFiltterConfig.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<WatchfaceResolution> component2() {
        return this.resolutions;
    }

    public final WatchFiltterConfig copy(String name, List<WatchfaceResolution> resolutions) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(resolutions, "resolutions");
        return new WatchFiltterConfig(name, resolutions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WatchFiltterConfig)) {
            return false;
        }
        WatchFiltterConfig watchFiltterConfig = (WatchFiltterConfig) other;
        return Intrinsics.areEqual(this.name, watchFiltterConfig.name) && Intrinsics.areEqual(this.resolutions, watchFiltterConfig.resolutions);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.resolutions.hashCode();
    }

    public String toString() {
        return "WatchFiltterConfig(name=" + this.name + ", resolutions=" + this.resolutions + ')';
    }

    public WatchFiltterConfig(String str, List<WatchfaceResolution> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "resolutions");
        this.name = str;
        this.resolutions = list;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final List<WatchfaceResolution> getResolutions() {
        return this.resolutions;
    }

    public final void setResolutions(List<WatchfaceResolution> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.resolutions = list;
    }

    /* JADX INFO: compiled from: WatchFiltterConfig.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003JG\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/dw/launcher/data/entity/WatchFiltterConfig$WatchfaceResolution;", BuildConfig.FLAVOR, "width", BuildConfig.FLAVOR, "height", "watchfaceList", BuildConfig.FLAVOR, "Lcom/dw/launcher/data/entity/WatchFiltterConfig$WatchInfo;", "watchfaces_sm", BuildConfig.FLAVOR, "watchfaces_mb", "(IILjava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getHeight", "()I", "getWatchfaceList", "()Ljava/util/List;", "getWatchfaces_mb", "getWatchfaces_sm", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class WatchfaceResolution {
        private final int height;
        private final List<WatchInfo> watchfaceList;
        private final List<WatchInfo> watchfaces_mb;
        private final String watchfaces_sm;
        private final int width;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WatchfaceResolution copy$default(WatchfaceResolution watchfaceResolution, int i, int i2, List list, String str, List list2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = watchfaceResolution.width;
            }
            if ((i3 & 2) != 0) {
                i2 = watchfaceResolution.height;
            }
            int i4 = i2;
            if ((i3 & 4) != 0) {
                list = watchfaceResolution.watchfaceList;
            }
            List list3 = list;
            if ((i3 & 8) != 0) {
                str = watchfaceResolution.watchfaces_sm;
            }
            String str2 = str;
            if ((i3 & 16) != 0) {
                list2 = watchfaceResolution.watchfaces_mb;
            }
            return watchfaceResolution.copy(i, i4, list3, str2, list2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        public final List<WatchInfo> component3() {
            return this.watchfaceList;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getWatchfaces_sm() {
            return this.watchfaces_sm;
        }

        public final List<WatchInfo> component5() {
            return this.watchfaces_mb;
        }

        public final WatchfaceResolution copy(int width, int height, List<WatchInfo> watchfaceList, String watchfaces_sm, List<WatchInfo> watchfaces_mb) {
            Intrinsics.checkNotNullParameter(watchfaceList, "watchfaceList");
            Intrinsics.checkNotNullParameter(watchfaces_sm, "watchfaces_sm");
            Intrinsics.checkNotNullParameter(watchfaces_mb, "watchfaces_mb");
            return new WatchfaceResolution(width, height, watchfaceList, watchfaces_sm, watchfaces_mb);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WatchfaceResolution)) {
                return false;
            }
            WatchfaceResolution watchfaceResolution = (WatchfaceResolution) other;
            return this.width == watchfaceResolution.width && this.height == watchfaceResolution.height && Intrinsics.areEqual(this.watchfaceList, watchfaceResolution.watchfaceList) && Intrinsics.areEqual(this.watchfaces_sm, watchfaceResolution.watchfaces_sm) && Intrinsics.areEqual(this.watchfaces_mb, watchfaceResolution.watchfaces_mb);
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height)) * 31) + this.watchfaceList.hashCode()) * 31) + this.watchfaces_sm.hashCode()) * 31) + this.watchfaces_mb.hashCode();
        }

        public String toString() {
            return "WatchfaceResolution(width=" + this.width + ", height=" + this.height + ", watchfaceList=" + this.watchfaceList + ", watchfaces_sm=" + this.watchfaces_sm + ", watchfaces_mb=" + this.watchfaces_mb + ')';
        }

        public WatchfaceResolution(int i, int i2, List<WatchInfo> list, String str, List<WatchInfo> list2) {
            Intrinsics.checkNotNullParameter(list, "watchfaceList");
            Intrinsics.checkNotNullParameter(str, "watchfaces_sm");
            Intrinsics.checkNotNullParameter(list2, "watchfaces_mb");
            this.width = i;
            this.height = i2;
            this.watchfaceList = list;
            this.watchfaces_sm = str;
            this.watchfaces_mb = list2;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
        }

        public final List<WatchInfo> getWatchfaceList() {
            return this.watchfaceList;
        }

        public final String getWatchfaces_sm() {
            return this.watchfaces_sm;
        }

        public final List<WatchInfo> getWatchfaces_mb() {
            return this.watchfaces_mb;
        }
    }

    /* JADX INFO: compiled from: WatchFiltterConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/dw/launcher/data/entity/WatchFiltterConfig$WatchInfo;", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "(ILjava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class WatchInfo {
        private int id;
        private String name;

        public static /* synthetic */ WatchInfo copy$default(WatchInfo watchInfo, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = watchInfo.id;
            }
            if ((i2 & 2) != 0) {
                str = watchInfo.name;
            }
            return watchInfo.copy(i, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final WatchInfo copy(int id, String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new WatchInfo(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WatchInfo)) {
                return false;
            }
            WatchInfo watchInfo = (WatchInfo) other;
            return this.id == watchInfo.id && Intrinsics.areEqual(this.name, watchInfo.name);
        }

        public int hashCode() {
            return (Integer.hashCode(this.id) * 31) + this.name.hashCode();
        }

        public String toString() {
            return "WatchInfo(id=" + this.id + ", name=" + this.name + ')';
        }

        public WatchInfo(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.id = i;
            this.name = str;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }
    }
}
