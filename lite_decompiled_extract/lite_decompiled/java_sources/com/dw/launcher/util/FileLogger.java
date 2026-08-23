package com.dw.launcher.util;

import android.content.Context;
import android.util.Log;
import com.google.android.mms.pdu.CharacterSets;
import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: FileLogger.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/dw/launcher/util/FileLogger;", "Ltimber/log/Timber$DebugTree;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "dateFormat", "Ljava/text/DateFormat;", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "writer", "Ljava/io/PrintWriter;", "log", "", "priority", "", "tag", "message", "t", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class FileLogger extends Timber.DebugTree {
    private final String TAG;
    private final DateFormat dateFormat;
    private final ExecutorService executor;
    private PrintWriter writer;

    public FileLogger(Context context) {
        File[] fileArrListFiles;
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "FileLogger";
        this.executor = Executors.newSingleThreadExecutor();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.getDefault());
        this.dateFormat = simpleDateFormat;
        File file = new File(context.getExternalCacheDir(), simpleDateFormat.format(new Date()) + ".log");
        File parentFile = file.getParentFile();
        if (parentFile != null && (fileArrListFiles = parentFile.listFiles()) != null) {
            for (final File file2 : fileArrListFiles) {
                if (file2.lastModified() > System.currentTimeMillis() || file2.lastModified() < System.currentTimeMillis() - 604800000) {
                    this.executor.submit(new Runnable() { // from class: com.dw.launcher.util.FileLogger$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            FileLogger.lambda$1$lambda$0(file2, this);
                        }
                    });
                }
            }
        }
        if (file.exists() || file.createNewFile()) {
            this.writer = new PrintWriter(file);
        }
    }

    static final void lambda$1$lambda$0(File file, FileLogger this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (file.delete()) {
            Log.i(this$0.TAG, "delete expire log: " + file);
        }
    }

    @Override // timber.log.Timber.DebugTree, timber.log.Timber.Tree
    protected void log(int priority, final String tag, final String message, final Throwable t) {
        final PrintWriter printWriter;
        Intrinsics.checkNotNullParameter(message, "message");
        super.log(priority, tag, message, t);
        if (priority < 2 || (printWriter = this.writer) == null) {
            return;
        }
        this.executor.submit(new Runnable() { // from class: com.dw.launcher.util.FileLogger$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FileLogger.log$lambda$3$lambda$2(this.f$0, tag, message, printWriter, t);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log$lambda$3$lambda$2(FileLogger this$0, String str, String message, PrintWriter it, Throwable th) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "$message");
        Intrinsics.checkNotNullParameter(it, "$it");
        it.println(this$0.dateFormat.format(new Date()) + '\t' + str + '\t' + message + '\t');
        if (th != null) {
            th.printStackTrace(it);
        }
        it.flush();
    }
}
