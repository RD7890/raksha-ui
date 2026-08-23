package com.dw.launcher.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.ui.view.SlideView;
import com.dw.launcher.util.SystemUtils;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: ShutdownActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/dw/launcher/ui/activity/ShutdownActivity;", "Lcom/dw/launcher/base/BaseActivity;", "Lcom/dw/launcher/ui/view/SlideView$OnSlideChangeListener;", "()V", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onSlideChanged", "offset", "", "onSlideSelected", "onStop", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class ShutdownActivity extends Hilt_ShutdownActivity implements SlideView.OnSlideChangeListener {

    @Inject
    public SysKeyEvent sysKeyEvent;

    @Override // com.dw.launcher.ui.view.SlideView.OnSlideChangeListener
    public void onSlideChanged(float offset) {
    }

    public final SysKeyEvent getSysKeyEvent() {
        SysKeyEvent sysKeyEvent = this.sysKeyEvent;
        if (sysKeyEvent != null) {
            return sysKeyEvent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sysKeyEvent");
        return null;
    }

    public final void setSysKeyEvent(SysKeyEvent sysKeyEvent) {
        Intrinsics.checkNotNullParameter(sysKeyEvent, "<set-?>");
        this.sysKeyEvent = sysKeyEvent;
    }

    public int getLayoutId() {
        return R.layout.activity_shutdown;
    }

    @Override // com.dw.launcher.ui.activity.Hilt_ShutdownActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((SlideView) findViewById(R.id.shutdown_slide_view)).setListener(this);
    }

    protected void onStop() {
        super.onStop();
        finish();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == getSysKeyEvent().getSingleKeyCode()) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.dw.launcher.ui.view.SlideView.OnSlideChangeListener
    public boolean onSlideSelected(float offset) {
        Timber.INSTANCE.i("---onSlideSelected: " + offset, new Object[0]);
        if (offset <= 0.85f) {
            return false;
        }
        SystemUtils.INSTANCE.shutdown((Context) this);
        return true;
    }
}
