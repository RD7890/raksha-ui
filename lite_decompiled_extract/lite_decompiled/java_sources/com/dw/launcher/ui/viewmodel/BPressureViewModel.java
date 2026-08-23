package com.dw.launcher.ui.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.google.android.mms.pdu.CharacterSets;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: BPressureViewModel.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/dw/launcher/ui/viewmodel/BPressureViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "context", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getContext", "()Landroid/app/Application;", "print", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class BPressureViewModel extends AndroidViewModel {
    private final Application context;

    public final void print() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public BPressureViewModel(Application context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Timber.INSTANCE.d("StepViewModel init... ", new Object[0]);
    }

    public final Application getContext() {
        return this.context;
    }
}
