package com.dw.launcher.ui.activity;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.core.skin.SkinThemeManager;
import com.dw.launcher.core.skin.config.SkinConfig;
import com.dw.launcher.core.skin.listener.ILoaderListener;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.entity.ThemeItem;
import com.dw.launcher.data.repository.IShortcutRepository;
import com.dw.launcher.ui.viewmodel.ThemeViewModel;
import com.dw.launcher.util.AppLock;
import com.dw.launcher.util.ResourceUtils;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: SetThemeActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060#H\u0002J\b\u0010$\u001a\u00020\tH\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\tH\u0002J\b\u0010'\u001a\u00020!H\u0002J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020!H\u0016J\u0012\u0010*\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020!H\u0014J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020!H\u0014J\u0016\u00104\u001a\u00020!2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060#H\u0002J\b\u00106\u001a\u00020!H\u0002J\b\u00107\u001a\u00020!H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/dw/launcher/ui/activity/SetThemeActivity;", "Lcom/dw/launcher/base/BaseActivity;", "Lcom/dw/launcher/data/component/NoDisturbComponent$OnAppLockChangedListener;", "()V", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/ThemeItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "currentIndex", "", "noDisturbComponent", "Lcom/dw/launcher/data/component/NoDisturbComponent;", "getNoDisturbComponent", "()Lcom/dw/launcher/data/component/NoDisturbComponent;", "setNoDisturbComponent", "(Lcom/dw/launcher/data/component/NoDisturbComponent;)V", "shortcutRepository", "Lcom/dw/launcher/data/repository/IShortcutRepository;", "getShortcutRepository", "()Lcom/dw/launcher/data/repository/IShortcutRepository;", "setShortcutRepository", "(Lcom/dw/launcher/data/repository/IShortcutRepository;)V", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "viewModel", "Lcom/dw/launcher/ui/viewmodel/ThemeViewModel;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "findSelect", "", "list", "", "getLayoutId", "handleThemeSelection", "position", "initViewModel", "initViews", "onAppLockChanged", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyUp", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onUserLeaveHint", "setupAdapter", "themeList", "setupRecyclerViewPadding", "setupViewPagerTransformations", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class SetThemeActivity extends Hilt_SetThemeActivity implements NoDisturbComponent.OnAppLockChangedListener {
    private BaseQuickAdapter<ThemeItem, BaseViewHolder> adapter;
    private int currentIndex;

    @Inject
    public NoDisturbComponent noDisturbComponent;

    @Inject
    public IShortcutRepository shortcutRepository;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private ThemeViewModel viewModel;
    private ViewPager2 viewPager;

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

    public final IShortcutRepository getShortcutRepository() {
        IShortcutRepository iShortcutRepository = this.shortcutRepository;
        if (iShortcutRepository != null) {
            return iShortcutRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shortcutRepository");
        return null;
    }

    public final void setShortcutRepository(IShortcutRepository iShortcutRepository) {
        Intrinsics.checkNotNullParameter(iShortcutRepository, "<set-?>");
        this.shortcutRepository = iShortcutRepository;
    }

    public final NoDisturbComponent getNoDisturbComponent() {
        NoDisturbComponent noDisturbComponent = this.noDisturbComponent;
        if (noDisturbComponent != null) {
            return noDisturbComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("noDisturbComponent");
        return null;
    }

    public final void setNoDisturbComponent(NoDisturbComponent noDisturbComponent) {
        Intrinsics.checkNotNullParameter(noDisturbComponent, "<set-?>");
        this.noDisturbComponent = noDisturbComponent;
    }

    public int getLayoutId() {
        return R.layout.activity_set_wallpaper;
    }

    @Override // com.dw.launcher.ui.activity.Hilt_SetThemeActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initViews();
        initViewModel();
        setupViewPagerTransformations();
        getNoDisturbComponent().addAppLockListener(this);
    }

    private final void initViews() {
        ViewPager2 viewPager2FindViewById = findViewById(R.id.set_wallpaper_list);
        Intrinsics.checkNotNullExpressionValue(viewPager2FindViewById, "findViewById(...)");
        this.viewPager = viewPager2FindViewById;
    }

    private final void initViewModel() {
        this.viewModel = (ThemeViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(ThemeViewModel.class);
        Lifecycle lifecycle = getLifecycle();
        ThemeViewModel themeViewModel = this.viewModel;
        ThemeViewModel themeViewModel2 = null;
        if (themeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            themeViewModel = null;
        }
        lifecycle.addObserver((LifecycleObserver) themeViewModel);
        ThemeViewModel themeViewModel3 = this.viewModel;
        if (themeViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            themeViewModel2 = themeViewModel3;
        }
        themeViewModel2.loadThemes().observe((LifecycleOwner) this, new SetThemeActivity$sam$androidx_lifecycle_Observer$0(new Function1<List<ThemeItem>, Unit>() { // from class: com.dw.launcher.ui.activity.SetThemeActivity.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<ThemeItem> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ThemeItem> list) {
                Unit unit;
                Timber.INSTANCE.e("----loadThemes:  finish...", new Object[0]);
                if (list != null) {
                    SetThemeActivity setThemeActivity = SetThemeActivity.this;
                    List<ThemeItem> list2 = list;
                    setThemeActivity.findSelect(CollectionsKt.toMutableList((Collection) list2));
                    setThemeActivity.setupAdapter(CollectionsKt.toMutableList((Collection) list2));
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Timber.INSTANCE.e("----loadThemes: 数据为空", new Object[0]);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupAdapter(List<ThemeItem> themeList) {
        this.adapter = new BaseQuickAdapter<ThemeItem, BaseViewHolder>(themeList, R.layout.item_theme) { // from class: com.dw.launcher.ui.activity.SetThemeActivity.setupAdapter.1
            {
                setHasStableIds(true);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void convert(BaseViewHolder holder, ThemeItem item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                Timber.INSTANCE.i("----uri: " + item.getPath(), new Object[0]);
                if (Build.VERSION.SDK_INT >= 28) {
                    Glide.with(this).load(item.getPreview()).centerInside().into((ImageView) holder.getView(R.id.wallpaper_preview));
                } else {
                    holder.setImageDrawable(R.id.wallpaper_preview, item.getPreview());
                }
                ((ImageView) holder.getView(R.id.set_theme_button)).setVisibility(holder.getBindingAdapterPosition() != this.currentIndex ? 4 : 0);
            }
        };
        ViewPager2 viewPager2 = this.viewPager;
        ViewPager2 viewPager3 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        BaseQuickAdapter<ThemeItem, BaseViewHolder> baseQuickAdapter = this.adapter;
        if (baseQuickAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            baseQuickAdapter = null;
        }
        viewPager2.setAdapter((RecyclerView.Adapter) baseQuickAdapter);
        BaseQuickAdapter<ThemeItem, BaseViewHolder> baseQuickAdapter2 = this.adapter;
        if (baseQuickAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            baseQuickAdapter2 = null;
        }
        baseQuickAdapter2.setOnItemClickListener(new OnItemClickListener() { // from class: com.dw.launcher.ui.activity.SetThemeActivity$$ExternalSyntheticLambda0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter3, View view, int i) {
                SetThemeActivity.setupAdapter$lambda$0(this.f$0, baseQuickAdapter3, view, i);
            }
        });
        ViewPager2 viewPager4 = this.viewPager;
        if (viewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager3 = viewPager4;
        }
        viewPager3.setCurrentItem(this.currentIndex, false);
        setupRecyclerViewPadding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAdapter$lambda$0(SetThemeActivity this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        this$0.handleThemeSelection(i);
    }

    private final void handleThemeSelection(int position) {
        BaseQuickAdapter<ThemeItem, BaseViewHolder> baseQuickAdapter = this.adapter;
        if (baseQuickAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            baseQuickAdapter = null;
        }
        ThemeItem themeItem = (ThemeItem) baseQuickAdapter.getData().get(position);
        String path = themeItem.getPath();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        if (Intrinsics.areEqual(path, SkinConfig.getCustomSkinPath(applicationContext))) {
            Timber.INSTANCE.d("选择自定义主题，关闭活动", new Object[0]);
            finish();
        } else {
            Timber.INSTANCE.d("加载主题: " + themeItem.getPath(), new Object[0]);
            SkinThemeManager.getInstance().load(themeItem.getPath(), new ILoaderListener() { // from class: com.dw.launcher.ui.activity.SetThemeActivity.handleThemeSelection.1
                public void onStart() {
                    Timber.INSTANCE.d("加载主题开始...", new Object[0]);
                }

                public void onSuccess() {
                    Timber.INSTANCE.d("加载主题成功", new Object[0]);
                    SetThemeActivity.this.getShortcutRepository().reloadTheme();
                    SetThemeActivity.this.finish();
                }

                public void onFailed() {
                    Timber.INSTANCE.e("加载主题失败", new Object[0]);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void findSelect(List<ThemeItem> list) {
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String path = ((ThemeItem) obj).getPath();
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            if (Intrinsics.areEqual(path, SkinConfig.getCustomSkinPath(applicationContext))) {
                this.currentIndex = i;
            }
            i = i2;
        }
        Timber.INSTANCE.i("----findSelect, index: " + this.currentIndex, new Object[0]);
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setCurrentItem(this.currentIndex, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setupViewPagerTransformations() {
        ViewPager2 viewPager2 = this.viewPager;
        ViewPager2 viewPager3 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        RecyclerView childAt = viewPager2.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? childAt : null;
        if (recyclerView != null) {
            int iDpToPx = (int) ResourceUtils.dpToPx((Context) this, 50.0f);
            recyclerView.setPadding(iDpToPx, 0, iDpToPx, 0);
            recyclerView.setClipToPadding(false);
        }
        ViewPager2 viewPager4 = this.viewPager;
        if (viewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager4 = null;
        }
        viewPager4.setOffscreenPageLimit(-1);
        ViewPager2.PageTransformer pageTransformer = new ViewPager2.PageTransformer() { // from class: com.dw.launcher.ui.activity.SetThemeActivity$$ExternalSyntheticLambda1
            public final void transformPage(View view, float f) {
                SetThemeActivity.setupViewPagerTransformations$lambda$3(view, f);
            }
        };
        ViewPager2 viewPager5 = this.viewPager;
        if (viewPager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager3 = viewPager5;
        }
        viewPager3.setPageTransformer(pageTransformer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViewPagerTransformations$lambda$3(View page, float f) {
        Intrinsics.checkNotNullParameter(page, "page");
        float f2 = 1;
        float fAbs = ((f2 - Math.abs(f)) * 0.15f) + 0.85f;
        page.setScaleY(fAbs);
        page.setScaleX(fAbs);
        page.setAlpha(((f2 - Math.abs(f)) * 0.5f) + 0.5f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setupRecyclerViewPadding() {
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        View childAt = viewPager2.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView != null) {
            int iDpToPx = (int) ResourceUtils.dpToPx((Context) this, 50.0f);
            recyclerView.setPadding(iDpToPx, 0, iDpToPx, 0);
            recyclerView.setClipToPadding(false);
        }
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == getSysKeyEvent().getSingleKeyCode()) {
            Timber.INSTANCE.d("捕获到单键事件，关闭活动", new Object[0]);
            finish();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Timber.INSTANCE.d("用户按下 Home 键，关闭活动", new Object[0]);
        finish();
    }

    @Override // com.dw.launcher.ui.activity.Hilt_SetThemeActivity
    protected void onDestroy() {
        super.onDestroy();
        getNoDisturbComponent().removeAppLockListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAppLockChanged() {
        if (AppLock.isForbidPackage((Context) this, new ComponentName("com.dw.launcher", "com.dw.launcher.ui.activity.SetThemeActivity"))) {
            Timber.INSTANCE.d("应用锁禁止访问，关闭活动", new Object[0]);
            finish();
        }
    }
}
