package com.dw.launcher.base;

import android.os.Bundle;
import android.view.KeyEvent;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: BaseActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0006H'J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0014J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0014J\b\u0010\u0018\u001a\u00020\u000eH\u0014¨\u0006\u001a"}, d2 = {"Lcom/dw/launcher/base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "dispatchOnKeyDownEvent", BuildConfig.FLAVOR, "keyCode", BuildConfig.FLAVOR, NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "dispatchOnKeyLongPress", "dispatchOnKeyShortcut", "dispatchOnKeyUp", "getLayoutId", "onBackPressed", BuildConfig.FLAVOR, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "onKeyLongPress", "onKeyShortcut", "onKeyUp", "onPause", "onResume", "Companion", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    public abstract int getLayoutId();

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.Forest.v("----" + getClass().getName() + ".onCreate", new Object[0]);
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        Timber.Forest.v("----" + getClass().getName() + ".onResume", new Object[0]);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Timber.Forest.v("----" + getClass().getName() + ".onPause", new Object[0]);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Timber.Forest.v("----" + getClass().getName() + ".onDestroy", new Object[0]);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (dispatchOnKeyShortcut(keyCode, event)) {
            return true;
        }
        return super.onKeyShortcut(keyCode, event);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        Timber.Forest.v("onKeyLongPress: keycode: " + keyCode + ", event: " + event, new Object[0]);
        if (dispatchOnKeyLongPress(keyCode, event)) {
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (dispatchOnKeyDownEvent(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (dispatchOnKeyUp(keyCode, event)) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean dispatchOnKeyDownEvent(int keyCode, KeyEvent event) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (Fragment fragment : fragments) {
            if (fragment instanceof IKeyEventDispatcher) {
                return ((IKeyEventDispatcher) fragment).onKeyDown(keyCode, event);
            }
            List<Fragment> fragments2 = fragment.getChildFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments2, "getFragments(...)");
            for (ActivityResultCaller activityResultCaller : fragments2) {
                if (activityResultCaller instanceof IKeyEventDispatcher) {
                    return ((IKeyEventDispatcher) activityResultCaller).onKeyDown(keyCode, event);
                }
                List<Fragment> fragments3 = fragment.getChildFragmentManager().getFragments();
                Intrinsics.checkNotNullExpressionValue(fragments3, "getFragments(...)");
                for (ActivityResultCaller activityResultCaller2 : fragments3) {
                    if (activityResultCaller2 instanceof IKeyEventDispatcher) {
                        return ((IKeyEventDispatcher) activityResultCaller2).onKeyDown(keyCode, event);
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean dispatchOnKeyUp(int keyCode, KeyEvent event) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (Fragment fragment : fragments) {
            if (fragment instanceof IKeyEventDispatcher) {
                return ((IKeyEventDispatcher) fragment).onKeyUp(keyCode, event);
            }
            List<Fragment> fragments2 = fragment.getChildFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments2, "getFragments(...)");
            for (ActivityResultCaller activityResultCaller : fragments2) {
                if (activityResultCaller instanceof IKeyEventDispatcher) {
                    return ((IKeyEventDispatcher) activityResultCaller).onKeyUp(keyCode, event);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean dispatchOnKeyLongPress(int keyCode, KeyEvent event) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (Fragment fragment : fragments) {
            if (fragment instanceof IKeyEventDispatcher) {
                return ((IKeyEventDispatcher) fragment).onKeyLongPress(keyCode, event);
            }
            List<Fragment> fragments2 = fragment.getChildFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments2, "getFragments(...)");
            for (ActivityResultCaller activityResultCaller : fragments2) {
                if (activityResultCaller instanceof IKeyEventDispatcher) {
                    return ((IKeyEventDispatcher) activityResultCaller).onKeyLongPress(keyCode, event);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean dispatchOnKeyShortcut(int keyCode, KeyEvent event) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (Fragment fragment : fragments) {
            if (fragment instanceof IKeyEventDispatcher) {
                return ((IKeyEventDispatcher) fragment).onKeyShortcut(keyCode, event);
            }
            List<Fragment> fragments2 = fragment.getChildFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments2, "getFragments(...)");
            for (ActivityResultCaller activityResultCaller : fragments2) {
                if (activityResultCaller instanceof IKeyEventDispatcher) {
                    return ((IKeyEventDispatcher) activityResultCaller).onKeyShortcut(keyCode, event);
                }
            }
        }
        return false;
    }
}
