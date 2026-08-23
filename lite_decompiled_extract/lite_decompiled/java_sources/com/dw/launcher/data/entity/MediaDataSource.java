package com.dw.launcher.data.entity;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaDataSource.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/dw/launcher/data/entity/MediaDataSource;", "Landroid/media/MediaDataSource;", "videoBuffer", BuildConfig.FLAVOR, "([B)V", "close", BuildConfig.FLAVOR, "getSize", BuildConfig.FLAVOR, "readAt", BuildConfig.FLAVOR, "position", "buffer", TypedValues.CycleType.S_WAVE_OFFSET, "size", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MediaDataSource extends android.media.MediaDataSource {
    private final byte[] videoBuffer;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public MediaDataSource(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "videoBuffer");
        this.videoBuffer = bArr;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long position, byte[] buffer, int offset, int size) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        synchronized (this.videoBuffer) {
            byte[] bArr = this.videoBuffer;
            long length = bArr.length;
            if (position >= length) {
                return -1;
            }
            long j = size;
            long j2 = j + position;
            if (j2 > length) {
                size = (int) (j - (j2 - length));
            }
            System.arraycopy(bArr, (int) position, buffer, offset, size);
            return size;
        }
    }

    @Override // android.media.MediaDataSource
    public long getSize() {
        long length;
        synchronized (this.videoBuffer) {
            length = this.videoBuffer.length;
        }
        return length;
    }
}
