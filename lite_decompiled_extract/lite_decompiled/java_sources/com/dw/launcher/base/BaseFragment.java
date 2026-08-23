package com.dw.launcher.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: BaseFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\fH\u0016J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010(\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010*\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010+\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\fH\u0016J\b\u0010-\u001a\u00020\fH\u0016J\b\u0010.\u001a\u00020\fH\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/dw/launcher/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/dw/launcher/base/IKeyEventDispatcher;", "()V", "TAG", BuildConfig.FLAVOR, "kotlin.jvm.PlatformType", "mClearScreenFlagTask", "Ljava/lang/Runnable;", "mHandler", "Landroid/os/Handler;", "cancelScreenFlagTask", BuildConfig.FLAVOR, "closeScreenFlagTask", "dispatchOnKeyDownEvent", BuildConfig.FLAVOR, "keyCode", BuildConfig.FLAVOR, NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "dispatchOnKeyLongPress", "dispatchOnKeyShortcut", "dispatchOnKeyUp", "getLayoutId", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onDetach", "onKeyDown", "onKeyLongPress", "onKeyShortcut", "onKeyUp", "onPause", "onResume", "onStart", "onStop", "Companion", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseFragment extends Fragment implements IKeyEventDispatcher {
    private static final boolean DEBUG_LIFECYCLE = false;
    private final String TAG = getClass().getSimpleName();
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mClearScreenFlagTask = new Runnable() { // from class: com.dw.launcher.base.BaseFragment$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            BaseFragment.mClearScreenFlagTask$lambda$0(this.f$0);
        }
    };

    public int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mClearScreenFlagTask$lambda$0(BaseFragment baseFragment) {
        Window window;
        Intrinsics.checkNotNullParameter(baseFragment, "this$0");
        FragmentActivity activity = baseFragment.getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.clearFlags(128);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (DEBUG_LIFECYCLE) {
            Timber.Forest forest = Timber.Forest;
            String str = this.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            forest.tag(str).v("----onCreateView", new Object[0]);
        }
        if (getLayoutId() > 0) {
            return inflater.inflate(getLayoutId(), container, false);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DEBUG_LIFECYCLE) {
            Timber.Forest forest = Timber.Forest;
            String str = this.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            forest.tag(str).v("----onCreate", new Object[0]);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (DEBUG_LIFECYCLE) {
            Timber.Forest forest = Timber.Forest;
            String str = this.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            forest.tag(str).v("----onDestroy", new Object[0]);
        }
    }

    @Override // com.dw.launcher.base.IKeyEventDispatcher
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (DEBUG_LIFECYCLE) {
            Timber.Forest forest = Timber.Forest;
            String str = this.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            forest.tag(str).v("----onKeyShortcut, keycode: " + keyCode, new Object[0]);
        }
        if (dispatchOnKeyShortcut(keyCode, event)) {
            return true;
        }
        return IKeyEventDispatcher.DefaultImpls.onKeyShortcut(this, keyCode, event);
    }

    @Override // com.dw.launcher.base.IKeyEventDispatcher
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (DEBUG_LIFECYCLE) {
            Timber.Forest forest = Timber.Forest;
            String str = this.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            forest.tag(str).v("----onKeyLongPress, keycode: " + keyCode, new Object[0]);
        }
        if (dispatchOnKeyLongPress(keyCode, event)) {
            return true;
        }
        return IKeyEventDispatcher.DefaultImpls.onKeyLongPress(this, keyCode, event);
    }

    @Override // com.dw.launcher.base.IKeyEventDispatcher
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (dispatchOnKeyDownEvent(keyCode, event)) {
            return true;
        }
        return IKeyEventDispatcher.DefaultImpls.onKeyDown(this, keyCode, event);
    }

    @Override // com.dw.launcher.base.IKeyEventDispatcher
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (dispatchOnKeyUp(keyCode, event)) {
            return true;
        }
        return IKeyEventDispatcher.DefaultImpls.onKeyUp(this, keyCode, event);
    }

    private final boolean dispatchOnKeyDownEvent(int keyCode, KeyEvent event) {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (ActivityResultCaller activityResultCaller : fragments) {
            if ((activityResultCaller instanceof IKeyEventDispatcher) && ((IKeyEventDispatcher) activityResultCaller).onKeyDown(keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    private final boolean dispatchOnKeyUp(int keyCode, KeyEvent event) {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (ActivityResultCaller activityResultCaller : fragments) {
            if ((activityResultCaller instanceof IKeyEventDispatcher) && ((IKeyEventDispatcher) activityResultCaller).onKeyUp(keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    private final boolean dispatchOnKeyLongPress(int keyCode, KeyEvent event) {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (ActivityResultCaller activityResultCaller : fragments) {
            if (activityResultCaller instanceof IKeyEventDispatcher) {
                return ((IKeyEventDispatcher) activityResultCaller).onKeyLongPress(keyCode, event);
            }
        }
        return false;
    }

    private final boolean dispatchOnKeyShortcut(int keyCode, KeyEvent event) {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (ActivityResultCaller activityResultCaller : fragments) {
            if (activityResultCaller instanceof IKeyEventDispatcher) {
                return ((IKeyEventDispatcher) activityResultCaller).onKeyShortcut(keyCode, event);
            }
        }
        return false;
    }

    public void cancelScreenFlagTask() {
        this.mHandler.removeCallbacks(this.mClearScreenFlagTask);
    }

    public void closeScreenFlagTask() {
        this.mHandler.removeCallbacks(this.mClearScreenFlagTask);
        this.mHandler.postDelayed(this.mClearScreenFlagTask, 1000L);
    }
}
