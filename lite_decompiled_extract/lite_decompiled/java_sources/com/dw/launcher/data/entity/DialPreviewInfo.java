package com.dw.launcher.data.entity;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialPreviewInfo.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u00011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010-\u001a\u00020\u0019H\u0016J\u0018\u0010.\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0019H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010$\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00062"}, d2 = {"Lcom/dw/launcher/data/entity/DialPreviewInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "clock", "Lcom/dw/launcher/data/entity/Clock;", "getClock", "()Lcom/dw/launcher/data/entity/Clock;", "setClock", "(Lcom/dw/launcher/data/entity/Clock;)V", "dialId", BuildConfig.FLAVOR, "getDialId", "()J", "setDialId", "(J)V", "dialName", BuildConfig.FLAVOR, "getDialName", "()Ljava/lang/String;", "setDialName", "(Ljava/lang/String;)V", "dialSource", BuildConfig.FLAVOR, "getDialSource", "()I", "setDialSource", "(I)V", "dialType", "getDialType", "setDialType", "filePath", "getFilePath", "setFilePath", "pkg", "getPkg", "setPkg", "preview", "Landroid/graphics/Bitmap;", "getPreview", "()Landroid/graphics/Bitmap;", "setPreview", "(Landroid/graphics/Bitmap;)V", "describeContents", "writeToParcel", BuildConfig.FLAVOR, "flags", "CREATOR", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DialPreviewInfo implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Clock clock;
    private long dialId;
    private String dialName;
    private int dialSource;
    private int dialType;
    private String filePath;
    private String pkg;
    private Bitmap preview;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DialPreviewInfo() {
        this.pkg = BuildConfig.FLAVOR;
    }

    public final long getDialId() {
        return this.dialId;
    }

    public final void setDialId(long j) {
        this.dialId = j;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final void setFilePath(String str) {
        this.filePath = str;
    }

    public final String getDialName() {
        return this.dialName;
    }

    public final void setDialName(String str) {
        this.dialName = str;
    }

    public final int getDialType() {
        return this.dialType;
    }

    public final void setDialType(int i) {
        this.dialType = i;
    }

    public final int getDialSource() {
        return this.dialSource;
    }

    public final void setDialSource(int i) {
        this.dialSource = i;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final void setPkg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pkg = str;
    }

    public final Bitmap getPreview() {
        return this.preview;
    }

    public final void setPreview(Bitmap bitmap) {
        this.preview = bitmap;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final void setClock(Clock clock) {
        this.clock = clock;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DialPreviewInfo(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.dialId = parcel.readLong();
        this.filePath = parcel.readString();
        this.dialName = parcel.readString();
        this.dialType = parcel.readInt();
        this.dialSource = parcel.readInt();
        this.pkg = parcel.readString().toString();
        this.preview = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.dialId);
        parcel.writeString(this.filePath);
        parcel.writeString(this.dialName);
        parcel.writeInt(this.dialType);
        parcel.writeInt(this.dialSource);
        parcel.writeString(this.pkg);
        parcel.writeParcelable(this.preview, flags);
    }

    /* JADX INFO: renamed from: com.dw.launcher.data.entity.DialPreviewInfo$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: DialPreviewInfo.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/dw/launcher/data/entity/DialPreviewInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/dw/launcher/data/entity/DialPreviewInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", BuildConfig.FLAVOR, "size", BuildConfig.FLAVOR, "(I)[Lcom/dw/launcher/data/entity/DialPreviewInfo;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<DialPreviewInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DialPreviewInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DialPreviewInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DialPreviewInfo[] newArray(int size) {
            return new DialPreviewInfo[size];
        }
    }
}
