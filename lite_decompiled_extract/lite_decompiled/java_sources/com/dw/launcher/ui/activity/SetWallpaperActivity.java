package com.dw.launcher.ui.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.signature.ObjectKey;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.component.WallpaperComponent;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.entity.Wallpaper;
import com.dw.launcher.ui.view.DeleteDialog;
import com.dw.launcher.ui.viewmodel.WallpaperViewModel;
import com.dw.launcher.util.AppLock;
import com.dw.launcher.util.ResourceUtils;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

/* JADX INFO: compiled from: SetWallpaperActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001DB\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020/H\u0002J\b\u00101\u001a\u00020\nH\u0016J\"\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u000106H\u0014J\b\u00107\u001a\u00020/H\u0016J\u0012\u00108\u001a\u00020/2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010;\u001a\u00020/2\b\u0010<\u001a\u0004\u0018\u00010=H\u0014J\b\u0010>\u001a\u00020/H\u0014J\u0018\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020/H\u0014R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/dw/launcher/ui/activity/SetWallpaperActivity;", "Lcom/dw/launcher/base/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lcom/dw/launcher/data/component/NoDisturbComponent$OnAppLockChangedListener;", "()V", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Wallpaper;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "currentIndex", "", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "isToSetWatch", "", "()Z", "setToSetWatch", "(Z)V", "mConfirmDialog", "Lcom/dw/launcher/ui/activity/SetWallpaperActivity$ConfirmDialog;", "mViewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "noDisturbComponent", "Lcom/dw/launcher/data/component/NoDisturbComponent;", "getNoDisturbComponent", "()Lcom/dw/launcher/data/component/NoDisturbComponent;", "setNoDisturbComponent", "(Lcom/dw/launcher/data/component/NoDisturbComponent;)V", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "viewModel", "Lcom/dw/launcher/ui/viewmodel/WallpaperViewModel;", "wallpaperComponent", "Lcom/dw/launcher/data/component/WallpaperComponent;", "getWallpaperComponent", "()Lcom/dw/launcher/data/component/WallpaperComponent;", "setWallpaperComponent", "(Lcom/dw/launcher/data/component/WallpaperComponent;)V", "wallpaperList", "", "checkAfterDelete", "", "findSelect", "getLayoutId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAppLockChanged", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onUserLeaveHint", "ConfirmDialog", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class SetWallpaperActivity extends Hilt_SetWallpaperActivity implements View.OnClickListener, NoDisturbComponent.OnAppLockChangedListener {
    private BaseQuickAdapter<Wallpaper, BaseViewHolder> adapter;
    private int currentIndex;
    private boolean isToSetWatch;
    private ConfirmDialog mConfirmDialog;
    private ViewPager2 mViewPager2;

    @Inject
    public NoDisturbComponent noDisturbComponent;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private WallpaperViewModel viewModel;

    @Inject
    public WallpaperComponent wallpaperComponent;
    private final List<Wallpaper> wallpaperList = new ArrayList();

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public final void setCurrentIndex(int i) {
        this.currentIndex = i;
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

    public final WallpaperComponent getWallpaperComponent() {
        WallpaperComponent wallpaperComponent = this.wallpaperComponent;
        if (wallpaperComponent != null) {
            return wallpaperComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("wallpaperComponent");
        return null;
    }

    public final void setWallpaperComponent(WallpaperComponent wallpaperComponent) {
        Intrinsics.checkNotNullParameter(wallpaperComponent, "<set-?>");
        this.wallpaperComponent = wallpaperComponent;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.dw.launcher.ui.activity.Hilt_SetWallpaperActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.viewModel = (WallpaperViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(WallpaperViewModel.class);
        Lifecycle lifecycle = getLifecycle();
        WallpaperViewModel wallpaperViewModel = this.viewModel;
        ViewPager2 viewPager2 = null;
        if (wallpaperViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            wallpaperViewModel = null;
        }
        lifecycle.addObserver((LifecycleObserver) wallpaperViewModel);
        ViewPager2 viewPager2FindViewById = findViewById(R.id.set_wallpaper_list);
        Intrinsics.checkNotNullExpressionValue(viewPager2FindViewById, "findViewById(...)");
        this.mViewPager2 = viewPager2FindViewById;
        this.adapter = new AnonymousClass1(R.layout.item_wallpaper);
        this.wallpaperList.clear();
        WallpaperViewModel wallpaperViewModel2 = this.viewModel;
        if (wallpaperViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            wallpaperViewModel2 = null;
        }
        List list = (List) wallpaperViewModel2.getPapers().getValue();
        if (list != null) {
            this.wallpaperList.addAll(list);
        }
        ViewPager2 viewPager3 = this.mViewPager2;
        if (viewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager3 = null;
        }
        BaseQuickAdapter<Wallpaper, BaseViewHolder> baseQuickAdapter = this.adapter;
        if (baseQuickAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            baseQuickAdapter = null;
        }
        viewPager3.setAdapter((RecyclerView.Adapter) baseQuickAdapter);
        BaseQuickAdapter<Wallpaper, BaseViewHolder> baseQuickAdapter2 = this.adapter;
        if (baseQuickAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            baseQuickAdapter2 = null;
        }
        baseQuickAdapter2.setNewInstance(this.wallpaperList);
        findSelect();
        WallpaperViewModel wallpaperViewModel3 = this.viewModel;
        if (wallpaperViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            wallpaperViewModel3 = null;
        }
        wallpaperViewModel3.getPapers().observe((LifecycleOwner) this, new SetWallpaperActivity$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends Wallpaper>, Unit>() { // from class: com.dw.launcher.ui.activity.SetWallpaperActivity.onCreate.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Wallpaper> list2) {
                invoke2((List<Wallpaper>) list2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Wallpaper> list2) {
                SetWallpaperActivity setWallpaperActivity = SetWallpaperActivity.this;
                setWallpaperActivity.wallpaperList.clear();
                List list3 = setWallpaperActivity.wallpaperList;
                Intrinsics.checkNotNull(list2);
                list3.addAll(list2);
                BaseQuickAdapter baseQuickAdapter3 = SetWallpaperActivity.this.adapter;
                if (baseQuickAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    baseQuickAdapter3 = null;
                }
                baseQuickAdapter3.setNewInstance(SetWallpaperActivity.this.wallpaperList);
                SetWallpaperActivity.this.findSelect();
            }
        }));
        ViewPager2 viewPager4 = this.mViewPager2;
        if (viewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager4 = null;
        }
        RecyclerView childAt = viewPager4.getChildAt(0);
        Intrinsics.checkNotNull(childAt);
        RecyclerView recyclerView = childAt;
        int iDpToPx = (int) ResourceUtils.dpToPx((Context) this, 50.0f);
        recyclerView.setPadding(iDpToPx, 0, iDpToPx, 0);
        recyclerView.setClipToPadding(false);
        ViewPager2 viewPager5 = this.mViewPager2;
        if (viewPager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager5 = null;
        }
        viewPager5.setOffscreenPageLimit(-1);
        ViewPager2.PageTransformer pageTransformer = new ViewPager2.PageTransformer() { // from class: com.dw.launcher.ui.activity.SetWallpaperActivity$$ExternalSyntheticLambda1
            public final void transformPage(View view, float f) {
                SetWallpaperActivity.onCreate$lambda$1(view, f);
            }
        };
        ViewPager2 viewPager6 = this.mViewPager2;
        if (viewPager6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
        } else {
            viewPager2 = viewPager6;
        }
        viewPager2.setPageTransformer(pageTransformer);
        getNoDisturbComponent().addAppLockListener(this);
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.activity.SetWallpaperActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: SetWallpaperActivity.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/dw/launcher/ui/activity/SetWallpaperActivity$onCreate$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Wallpaper;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class AnonymousClass1 extends BaseQuickAdapter<Wallpaper, BaseViewHolder> {
        AnonymousClass1(int i) {
            super(i, (List) null, 2, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void convert(BaseViewHolder holder, final Wallpaper item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            holder.setVisible(R.id.llBottom, false);
            if (item.getType() == 2) {
                Glide.with(SetWallpaperActivity.this).load(SetWallpaperActivity.this.getDrawable(R.mipmap.icon_custom_wallpaper_icon)).centerCrop().into((ImageView) holder.getView(R.id.wallpaper_preview));
                ImageView imageView = (ImageView) holder.getView(R.id.wallpaper_preview);
                final SetWallpaperActivity setWallpaperActivity = SetWallpaperActivity.this;
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.SetWallpaperActivity$onCreate$1$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SetWallpaperActivity.AnonymousClass1.convert$lambda$0(setWallpaperActivity, view);
                    }
                });
                return;
            }
            holder.setVisible(R.id.llBottom, true);
            holder.setGone(R.id.image_setting, true);
            holder.setGone(R.id.image_del, true);
            holder.setGone(R.id.set_wallpaper_button, true);
            Timber.INSTANCE.i("----uri: " + item.getUri(), new Object[0]);
            if (item.getType() == 1) {
                Glide.with(SetWallpaperActivity.this).load(item.getUri()).centerCrop().signature(new ObjectKey(Short.valueOf((short) System.currentTimeMillis()))).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into((ImageView) holder.getView(R.id.wallpaper_preview));
            } else {
                RequestBuilder requestBuilderLoad = Glide.with(SetWallpaperActivity.this).load(item.getUri());
                if (!StringsKt.endsWith$default(item.getUri(), ".gif", false, 2, (Object) null)) {
                    requestBuilderLoad.centerCrop();
                }
                requestBuilderLoad.into((ImageView) holder.getView(R.id.wallpaper_preview));
            }
            ((ImageView) holder.getView(R.id.wallpaper_preview)).setOnClickListener(SetWallpaperActivity.this);
            if (item.getType() == 1) {
                holder.setGone(R.id.image_setting, false);
                holder.setGone(R.id.image_del, false);
                ImageView imageView2 = (ImageView) holder.getView(R.id.image_del);
                final SetWallpaperActivity setWallpaperActivity2 = SetWallpaperActivity.this;
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.SetWallpaperActivity$onCreate$1$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SetWallpaperActivity.AnonymousClass1.convert$lambda$3(setWallpaperActivity2, item, view);
                    }
                });
                ImageView imageView3 = (ImageView) holder.getView(R.id.image_setting);
                final SetWallpaperActivity setWallpaperActivity3 = SetWallpaperActivity.this;
                imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.SetWallpaperActivity$onCreate$1$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SetWallpaperActivity.AnonymousClass1.convert$lambda$4(setWallpaperActivity3, view);
                    }
                });
            }
            ImageView imageView4 = (ImageView) holder.getView(R.id.set_wallpaper_button);
            if (holder.getPosition() == SetWallpaperActivity.this.getCurrentIndex()) {
                imageView4.setVisibility(0);
                holder.setGone(R.id.image_del, true);
            } else {
                imageView4.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void convert$lambda$0(SetWallpaperActivity this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setToSetWatch(true);
            this$0.startActivityForResult(new Intent((Context) this$0, (Class<?>) CustomWallPaperActivity.class), 999);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void convert$lambda$3(final SetWallpaperActivity this$0, final Wallpaper item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            final DeleteDialog deleteDialog = new DeleteDialog((Context) this$0);
            deleteDialog.show();
            deleteDialog.setDeleteListener(new Function0<Unit>() { // from class: com.dw.launcher.ui.activity.SetWallpaperActivity$onCreate$1$convert$3$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    File file = new File(item.getPath());
                    if (file.exists()) {
                        if (file.delete()) {
                            this$0.wallpaperList.remove(item);
                            this$0.checkAfterDelete();
                        }
                        deleteDialog.dismiss();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void convert$lambda$4(SetWallpaperActivity this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setToSetWatch(true);
            this$0.startActivityForResult(new Intent((Context) this$0, (Class<?>) CustomWallPaperActivity.class), 999);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(View page, float f) {
        Intrinsics.checkNotNullParameter(page, "page");
        float f2 = 1;
        float fAbs = ((f2 - Math.abs(f)) * 0.15f) + 0.85f;
        page.setScaleY(fAbs);
        page.setScaleX(fAbs);
        page.setAlpha(((f2 - Math.abs(f)) * 0.5f) + 0.5f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        ViewPager2 viewPager2 = this.mViewPager2;
        WallpaperViewModel wallpaperViewModel = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager2 = null;
        }
        if (viewPager2.getChildCount() > 0) {
            ViewPager2 viewPager3 = this.mViewPager2;
            if (viewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                viewPager3 = null;
            }
            int currentItem = viewPager3.getCurrentItem();
            List<Wallpaper> list = this.wallpaperList;
            if (list.size() > currentItem) {
                WallpaperViewModel wallpaperViewModel2 = this.viewModel;
                if (wallpaperViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    wallpaperViewModel = wallpaperViewModel2;
                }
                if (wallpaperViewModel.setPaper(list.get(currentItem))) {
                    Toast.makeText((Context) this, R.string.set_wallpaper_success, 0).show();
                    finish();
                } else {
                    Toast.makeText((Context) this, R.string.set_wallpaper_failure, 0).show();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SetWallpaperActivity.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B(\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tJ&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R)\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/dw/launcher/ui/activity/SetWallpaperActivity$ConfirmDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "onclick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "", "(Lkotlin/jvm/functions/Function1;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class ConfirmDialog extends BottomSheetDialogFragment {
        private final Function1<Integer, Unit> onclick;

        /* JADX WARN: Multi-variable type inference failed */
        public ConfirmDialog(Function1<? super Integer, Unit> onclick) {
            Intrinsics.checkNotNullParameter(onclick, "onclick");
            this.onclick = onclick;
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            return inflater.inflate(R.layout.dialog_confirm_set_wallpaper, container, false);
        }

        public void onViewCreated(View view, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onViewCreated(view, savedInstanceState);
            view.findViewById(R.id.confirm_set_wallpaper_keyguard).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.SetWallpaperActivity$ConfirmDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SetWallpaperActivity.ConfirmDialog.onViewCreated$lambda$0(this.f$0, view2);
                }
            });
            view.findViewById(R.id.confirm_set_wallpaper_desktop).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.SetWallpaperActivity$ConfirmDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SetWallpaperActivity.ConfirmDialog.onViewCreated$lambda$1(this.f$0, view2);
                }
            });
            view.findViewById(R.id.confirm_set_wallpaper_both).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.SetWallpaperActivity$ConfirmDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SetWallpaperActivity.ConfirmDialog.onViewCreated$lambda$2(this.f$0, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onViewCreated$lambda$0(ConfirmDialog this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onclick.invoke(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onViewCreated$lambda$1(ConfirmDialog this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onclick.invoke(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onViewCreated$lambda$2(ConfirmDialog this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onclick.invoke(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void findSelect() {
        String wallpaper = getWallpaperComponent().getWallpaper();
        BaseQuickAdapter<Wallpaper, BaseViewHolder> baseQuickAdapter = this.adapter;
        ViewPager2 viewPager2 = null;
        if (baseQuickAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            baseQuickAdapter = null;
        }
        int i = 0;
        for (Object obj : baseQuickAdapter.getData()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((Wallpaper) obj).getPath(), wallpaper)) {
                this.currentIndex = i;
            }
            i = i2;
        }
        ViewPager2 viewPager3 = this.mViewPager2;
        if (viewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
        } else {
            viewPager2 = viewPager3;
        }
        viewPager2.setCurrentItem(this.currentIndex, false);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == getSysKeyEvent().getSingleKeyCode()) {
            finish();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    /* JADX INFO: renamed from: isToSetWatch, reason: from getter */
    public final boolean getIsToSetWatch() {
        return this.isToSetWatch;
    }

    public final void setToSetWatch(boolean z) {
        this.isToSetWatch = z;
    }

    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (!this.isToSetWatch) {
            finish();
        }
        Timber.INSTANCE.d("onUserLeaveHint....isToSetWatch:" + this.isToSetWatch, new Object[0]);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Object next;
        Object next2;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == -1) {
            WallpaperViewModel wallpaperViewModel = null;
            String stringExtra = data != null ? data.getStringExtra("customWallPaperPath") : null;
            if (stringExtra != null) {
                Iterator<T> it = this.wallpaperList.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (((Wallpaper) next).getType() != 1);
                Wallpaper wallpaper = (Wallpaper) next;
                if (wallpaper != null) {
                    wallpaper.setPath(stringExtra);
                    Iterator<T> it2 = this.wallpaperList.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                    } while (((Wallpaper) next2).getType() != 2);
                    Wallpaper wallpaper2 = (Wallpaper) next2;
                    if (wallpaper2 != null) {
                        this.wallpaperList.remove(wallpaper2);
                    }
                } else {
                    this.wallpaperList.add(new Wallpaper("", stringExtra, 1, true));
                }
                checkAfterDelete();
            }
            int i = 0;
            for (Object obj : this.wallpaperList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Wallpaper wallpaper3 = (Wallpaper) obj;
                if (i == this.currentIndex && wallpaper3.getType() == 1) {
                    WallpaperViewModel wallpaperViewModel2 = this.viewModel;
                    if (wallpaperViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        wallpaperViewModel = wallpaperViewModel2;
                    }
                    wallpaperViewModel.setPaper(wallpaper3);
                    return;
                }
                i = i2;
            }
        }
    }

    public final void checkAfterDelete() {
        ViewPager2 viewPager2;
        Object next;
        Unit unit;
        Object next2;
        Iterator<T> it = this.wallpaperList.iterator();
        do {
            viewPager2 = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Wallpaper) next).getType() != 1);
        if (((Wallpaper) next) != null) {
            Iterator<T> it2 = this.wallpaperList.iterator();
            do {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
            } while (((Wallpaper) next2).getType() != 2);
            Wallpaper wallpaper = (Wallpaper) next2;
            if (wallpaper != null) {
                this.wallpaperList.remove(wallpaper);
            }
            BaseQuickAdapter<Wallpaper, BaseViewHolder> baseQuickAdapter = this.adapter;
            if (baseQuickAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                baseQuickAdapter = null;
            }
            baseQuickAdapter.notifyDataSetChanged();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.wallpaperList.add(new Wallpaper("", "", 2, false));
            BaseQuickAdapter<Wallpaper, BaseViewHolder> baseQuickAdapter2 = this.adapter;
            if (baseQuickAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                baseQuickAdapter2 = null;
            }
            baseQuickAdapter2.notifyDataSetChanged();
        }
        ViewPager2 viewPager3 = this.mViewPager2;
        if (viewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
        } else {
            viewPager2 = viewPager3;
        }
        viewPager2.post(new Runnable() { // from class: com.dw.launcher.ui.activity.SetWallpaperActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SetWallpaperActivity.checkAfterDelete$lambda$15(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAfterDelete$lambda$15(SetWallpaperActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager2 viewPager2 = this$0.mViewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager2 = null;
        }
        viewPager2.requestTransform();
    }

    @Override // com.dw.launcher.ui.activity.Hilt_SetWallpaperActivity
    protected void onDestroy() {
        super.onDestroy();
        getNoDisturbComponent().removeAppLockListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAppLockChanged() {
        if (AppLock.isForbidPackage((Context) this, new ComponentName("com.dw.launcher", "com.dw.launcher.ui.activity.SetWallpaperActivity"))) {
            finish();
        }
    }
}
