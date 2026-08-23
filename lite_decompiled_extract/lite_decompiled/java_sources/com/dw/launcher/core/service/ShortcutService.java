package com.dw.launcher.core.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.IShortcutService;
import com.dw.launcher.ui.shortcut.ShortcutInflater;
import com.dw.launcher.util.SystemUtils;
import com.makeramen.roundedimageview.RoundedDrawable;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.ByteArrayOutputStream;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShortcutService.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/dw/launcher/core/service/ShortcutService;", "Landroid/app/Service;", "()V", "mBinder", "Lcom/dw/launcher/IShortcutService$Stub;", "getMBinder", "()Lcom/dw/launcher/IShortcutService$Stub;", "shortcutInflater", "Lcom/dw/launcher/ui/shortcut/ShortcutInflater;", "getShortcutInflater", "()Lcom/dw/launcher/ui/shortcut/ShortcutInflater;", "setShortcutInflater", "(Lcom/dw/launcher/ui/shortcut/ShortcutInflater;)V", "bitmapToByteArray", BuildConfig.FLAVOR, "bitmap", "Landroid/graphics/Bitmap;", "drawableToByteArray", "drawable", "Landroid/graphics/drawable/Drawable;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class ShortcutService extends Hilt_ShortcutService {
    private final IShortcutService.Stub mBinder = new IShortcutService.Stub() { // from class: com.dw.launcher.core.service.ShortcutService$mBinder$1
        @Override // com.dw.launcher.IShortcutService
        public byte[] getBitmap(String packageName, String className) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(className, "className");
            SystemUtils systemUtils = SystemUtils.INSTANCE;
            Context applicationContext = this.this$0.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            ResolveInfo resolveInfoQueryResolveInfoByActivity = systemUtils.queryResolveInfoByActivity(applicationContext, packageName, className);
            if (resolveInfoQueryResolveInfoByActivity == null) {
                return null;
            }
            ShortcutService shortcutService = this.this$0;
            Drawable drawable = shortcutService.getShortcutInflater().getDrawable(resolveInfoQueryResolveInfoByActivity);
            if (drawable != null) {
                return shortcutService.drawableToByteArray(drawable);
            }
            return null;
        }
    };

    @Inject
    public ShortcutInflater shortcutInflater;

    public final ShortcutInflater getShortcutInflater() {
        ShortcutInflater shortcutInflater = this.shortcutInflater;
        if (shortcutInflater != null) {
            return shortcutInflater;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shortcutInflater");
        return null;
    }

    public final void setShortcutInflater(ShortcutInflater shortcutInflater) {
        Intrinsics.checkNotNullParameter(shortcutInflater, "<set-?>");
        this.shortcutInflater = shortcutInflater;
    }

    public final IShortcutService.Stub getMBinder() {
        return this.mBinder;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public final byte[] drawableToByteArray(Drawable drawable) {
        return bitmapToByteArray(RoundedDrawable.drawableToBitmap(drawable));
    }

    public final byte[] bitmapToByteArray(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
