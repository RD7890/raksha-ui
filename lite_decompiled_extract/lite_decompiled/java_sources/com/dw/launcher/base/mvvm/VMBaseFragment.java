package com.dw.launcher.base.mvvm;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.app.ActivityOptionsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.dw.launcher.base.IKeyEventDispatcher;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import timber.log.Timber;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public abstract class VMBaseFragment<VM extends AndroidViewModel, VDB extends ViewDataBinding> extends Fragment implements IKeyEventDispatcher {
    private static final long IGNORE_INTERVAL_TIME = 500;
    private Boolean DEBUG_LIFECYCLE = false;
    private final String TAG = "VMBaseFragment";
    private VDB mBinding;
    private String mJumpTag;
    private long mJumpTime;
    private View mRootView;
    private VM mViewModel;

    protected long getIgnoreIntervalTime() {
        return IGNORE_INTERVAL_TIME;
    }

    public abstract int getLayoutId();

    public abstract void initData(Bundle savedInstanceState);

    public boolean isBinding() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = createRootView(layoutInflater, viewGroup, bundle);
        if (isBinding()) {
            this.mBinding = (VDB) DataBindingUtil.bind(this.mRootView);
        }
        initViewModel();
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData(savedInstanceState);
    }

    protected View createRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    protected View getRootView() {
        return this.mRootView;
    }

    public <T extends View> T findViewById(int i) {
        return (T) getRootView().findViewById(i);
    }

    private void initViewModel() {
        this.mViewModel = (VM) createViewModel();
    }

    private Class<VM> getVMClass() {
        Class<VM> vMClass = null;
        for (Class<?> superclass = getClass(); vMClass == null && superclass != null; superclass = superclass.getSuperclass()) {
            vMClass = getVMClass(superclass);
        }
        return vMClass;
    }

    private Class getVMClass(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return null;
        }
        for (Type type : ((ParameterizedType) genericSuperclass).getActualTypeArguments()) {
            if (type instanceof Class) {
                Class cls2 = (Class) type;
                if (AndroidViewModel.class.isAssignableFrom(cls2)) {
                    return cls2;
                }
            } else if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                if (rawType instanceof Class) {
                    Class cls3 = (Class) rawType;
                    if (AndroidViewModel.class.isAssignableFrom(cls3)) {
                        return cls3;
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mViewModel != null) {
            this.mViewModel = null;
        }
        VDB vdb = this.mBinding;
        if (vdb != null) {
            vdb.unbind();
        }
    }

    public VM createViewModel() {
        return (VM) obtainViewModel(getVMClass());
    }

    public VM getViewModel() {
        return this.mViewModel;
    }

    public VDB getViewDataBinding() {
        return this.mBinding;
    }

    public VDB getBinding() {
        return this.mBinding;
    }

    public <T extends ViewModel> T obtainViewModel(Class<T> cls) {
        return (T) createViewModelProvider(this).get(cls);
    }

    private ViewModelProvider createViewModelProvider(ViewModelStoreOwner owner) {
        return new ViewModelProvider(owner);
    }

    protected void finish() {
        requireActivity().finish();
    }

    protected Intent newIntent(Class<?> cls) {
        return new Intent(getContext(), cls);
    }

    protected Intent newIntent(Class<?> cls, int flags) {
        Intent intentNewIntent = newIntent(cls);
        intentNewIntent.addFlags(flags);
        return intentNewIntent;
    }

    protected void startActivity(Class<?> cls) {
        startActivity(newIntent(cls));
    }

    protected void startActivity(Class<?> cls, int flags) {
        startActivity(newIntent(cls, flags));
    }

    protected void startActivity(Class<?> cls, ActivityOptionsCompat optionsCompat) {
        startActivity(newIntent(cls), optionsCompat);
    }

    protected void startActivity(Class<?> cls, int flags, ActivityOptionsCompat optionsCompat) {
        startActivity(newIntent(cls, flags), optionsCompat);
    }

    protected void startActivity(Intent intent, ActivityOptionsCompat optionsCompat) {
        if (optionsCompat != null) {
            startActivity(intent, optionsCompat.toBundle());
        } else {
            startActivity(intent);
        }
    }

    protected void startActivityFinish(Class<?> cls) {
        startActivity(cls);
        finish();
    }

    protected void startActivityFinish(Class<?> cls, int flags) {
        startActivity(cls, flags);
        finish();
    }

    protected void startActivityFinish(Class<?> cls, ActivityOptionsCompat optionsCompat) {
        startActivity(cls, optionsCompat);
        finish();
    }

    protected void startActivityFinish(Class<?> cls, int flags, ActivityOptionsCompat optionsCompat) {
        startActivity(newIntent(cls, flags), optionsCompat);
    }

    protected void startActivityFinish(Intent intent, ActivityOptionsCompat optionsCompat) {
        startActivity(intent, optionsCompat);
    }

    protected void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(newIntent(cls), requestCode);
    }

    protected void startActivityForResult(Class<?> cls, int requestCode, ActivityOptionsCompat optionsCompat) {
        Intent intentNewIntent = newIntent(cls);
        if (optionsCompat != null) {
            startActivityForResult(intentNewIntent, requestCode, optionsCompat.toBundle());
        } else {
            startActivityForResult(intentNewIntent, requestCode);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        if (isIgnoreJump(intent)) {
            return;
        }
        super.startActivityForResult(intent, requestCode, options);
    }

    protected boolean isIgnoreJump(Intent intent) {
        String action;
        if (intent.getComponent() != null) {
            action = intent.getComponent().getClassName();
        } else {
            if (intent.getAction() != null) {
                action = intent.getAction();
            }
            return false;
        }
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        if (action.equals(this.mJumpTag) && this.mJumpTime > SystemClock.elapsedRealtime() - getIgnoreIntervalTime()) {
            Timber.d("Ignore:" + action, new Object[0]);
            return true;
        }
        this.mJumpTag = action;
        this.mJumpTime = SystemClock.elapsedRealtime();
        return false;
    }

    protected View inflate(int id) {
        return inflate(id, null);
    }

    protected View inflate(int id, ViewGroup root) {
        return LayoutInflater.from(getContext()).inflate(id, root);
    }

    protected View inflate(int id, ViewGroup root, boolean attachToRoot) {
        return LayoutInflater.from(getContext()).inflate(id, root, attachToRoot);
    }

    protected void showDialogFragment(DialogFragment dialogFragment) {
        showDialogFragment(dialogFragment, dialogFragment.getTag() != null ? dialogFragment.getTag() : dialogFragment.getClass().getSimpleName());
    }

    protected void showDialogFragment(DialogFragment dialogFragment, String tag) {
        dialogFragment.show(getParentFragmentManager(), tag);
    }

    protected void showDialogFragment(DialogFragment dialogFragment, FragmentManager fragmentManager, String tag) {
        dialogFragment.show(fragmentManager, tag);
    }

    protected void dismissDialog(Dialog dialog) {
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        dialog.dismiss();
    }

    protected void dismissPopupWindow(PopupWindow popupWindow) {
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        popupWindow.dismiss();
    }

    protected void setWindow(Window window, int gravity, float widthRatio, int x, int y, float horizontalMargin, float verticalMargin, float horizontalWeight, float verticalWeight) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (getWidthPixels() * widthRatio);
        attributes.gravity = gravity;
        attributes.x = x;
        attributes.y = y;
        attributes.horizontalMargin = horizontalMargin;
        attributes.verticalMargin = verticalMargin;
        attributes.horizontalWeight = horizontalWeight;
        attributes.verticalWeight = verticalWeight;
        window.setAttributes(attributes);
    }

    protected DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    protected int getWidthPixels() {
        return getDisplayMetrics().widthPixels;
    }

    protected int getHeightPixels() {
        return getDisplayMetrics().heightPixels;
    }

    @Override // com.dw.launcher.base.IKeyEventDispatcher
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        if (this.DEBUG_LIFECYCLE.booleanValue()) {
            Timber.tag(this.TAG).v("----onKeyShortcut, keycode: " + keyCode, new Object[0]);
        }
        return dispatchOnKeyShortcut(keyCode, event);
    }

    @Override // com.dw.launcher.base.IKeyEventDispatcher
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (this.DEBUG_LIFECYCLE.booleanValue()) {
            Timber.tag(this.TAG).v("----onKeyLongPress, keycode: " + keyCode, new Object[0]);
        }
        return dispatchOnKeyLongPress(keyCode, event);
    }

    @Override // com.dw.launcher.base.IKeyEventDispatcher
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        this.DEBUG_LIFECYCLE.booleanValue();
        return dispatchOnKeyDownEvent(keyCode, event);
    }

    @Override // com.dw.launcher.base.IKeyEventDispatcher
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        this.DEBUG_LIFECYCLE.booleanValue();
        return dispatchOnKeyUp(keyCode, event);
    }

    private boolean dispatchOnKeyDownEvent(int keyCode, KeyEvent event) {
        for (ActivityResultCaller activityResultCaller : getChildFragmentManager().getFragments()) {
            if ((activityResultCaller instanceof IKeyEventDispatcher) && ((IKeyEventDispatcher) activityResultCaller).onKeyDown(keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    private boolean dispatchOnKeyUp(int keyCode, KeyEvent event) {
        for (ActivityResultCaller activityResultCaller : getChildFragmentManager().getFragments()) {
            if ((activityResultCaller instanceof IKeyEventDispatcher) && ((IKeyEventDispatcher) activityResultCaller).onKeyUp(keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    private boolean dispatchOnKeyLongPress(int keyCode, KeyEvent event) {
        for (ActivityResultCaller activityResultCaller : getChildFragmentManager().getFragments()) {
            if (activityResultCaller instanceof IKeyEventDispatcher) {
                return ((IKeyEventDispatcher) activityResultCaller).onKeyLongPress(keyCode, event);
            }
        }
        return false;
    }

    private boolean dispatchOnKeyShortcut(int keyCode, KeyEvent event) {
        for (ActivityResultCaller activityResultCaller : getChildFragmentManager().getFragments()) {
            if (activityResultCaller instanceof IKeyEventDispatcher) {
                return ((IKeyEventDispatcher) activityResultCaller).onKeyShortcut(keyCode, event);
            }
        }
        return false;
    }
}
