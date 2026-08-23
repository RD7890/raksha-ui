package com.dw.launcher.ui.fragment.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.data.component.TimeComponent;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.entity.RecentTask;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.ui.activity.AddMenuShortcutActivity;
import com.dw.launcher.util.AppLock;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

/* JADX INFO: compiled from: MenuFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010!\u001a\u00020\"H\u0002J\u0006\u0010#\u001a\u00020\"J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u0005H\u0016J\"\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0017J\b\u0010.\u001a\u00020\"H\u0016J\b\u0010/\u001a\u00020\"H\u0016J\u0006\u00100\u001a\u00020\"J\b\u00101\u001a\u00020\"H\u0016J \u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0005H\u0016J\u001a\u00106\u001a\u00020\"2\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/dw/launcher/ui/fragment/menu/MenuFragment;", "Lcom/dw/launcher/base/BaseFragment;", "Lcom/dw/launcher/data/component/TimeComponent$OnTimeChangedListener;", "()V", "REQUEST_CODE", "", "isEditMode", "", "()Z", "setEditMode", "(Z)V", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setLauncherRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "mAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/RecentTask;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "mDateComponent", "Lcom/dw/launcher/data/component/TimeComponent;", "mRvShortcuts", "Landroidx/recyclerview/widget/RecyclerView;", "mTvDate", "Landroid/widget/TextView;", "mTvTime", "mTvWeek", "mVisibleRect", "Landroid/graphics/Rect;", "viewModel", "Lcom/dw/launcher/ui/fragment/menu/MenuViewModel;", "checkIfAddIconIsAdded", "", "closeEditMode", "createAddIconShortcut", "context", "Landroid/content/Context;", "getLayoutId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onPause", "onResume", "onSlideup", "onStart", "onTimeChanged", "hour", "minute", "seconds", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "updateDate", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class MenuFragment extends Hilt_MenuFragment implements TimeComponent.OnTimeChangedListener {
    private boolean isEditMode;

    @Inject
    public LauncherRepository launcherRepository;
    private BaseQuickAdapter<RecentTask, BaseViewHolder> mAdapter;
    private TimeComponent mDateComponent;
    private RecyclerView mRvShortcuts;
    private TextView mTvDate;
    private TextView mTvTime;
    private TextView mTvWeek;
    private MenuViewModel viewModel;
    private final int REQUEST_CODE = CharacterSets.UCS2;
    private final Rect mVisibleRect = new Rect();

    /* JADX INFO: renamed from: isEditMode, reason: from getter */
    public final boolean getIsEditMode() {
        return this.isEditMode;
    }

    public final void setEditMode(boolean z) {
        this.isEditMode = z;
    }

    public final LauncherRepository getLauncherRepository() {
        LauncherRepository launcherRepository = this.launcherRepository;
        if (launcherRepository != null) {
            return launcherRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("launcherRepository");
        return null;
    }

    public final void setLauncherRepository(LauncherRepository launcherRepository) {
        Intrinsics.checkNotNullParameter(launcherRepository, "<set-?>");
        this.launcherRepository = launcherRepository;
    }

    @Override // com.dw.launcher.ui.fragment.menu.Hilt_MenuFragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        ViewModelStoreOwner viewModelStoreOwnerRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(viewModelStoreOwnerRequireActivity, "requireActivity(...)");
        MenuViewModel menuViewModel = (MenuViewModel) new ViewModelProvider(viewModelStoreOwnerRequireActivity).get(MenuViewModel.class);
        this.viewModel = menuViewModel;
        if (menuViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            menuViewModel = null;
        }
        menuViewModel.getShortcuts().observe((LifecycleOwner) this, new MenuFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<RecentTask>, Unit>() { // from class: com.dw.launcher.ui.fragment.menu.MenuFragment.onAttach.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<RecentTask> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<RecentTask> list) {
                BaseQuickAdapter baseQuickAdapter = MenuFragment.this.mAdapter;
                if (baseQuickAdapter != null) {
                    baseQuickAdapter.setNewInstance(list);
                    baseQuickAdapter.notifyDataSetChanged();
                }
            }
        }));
        this.mDateComponent = new TimeComponent(context, this);
    }

    public int getLayoutId() {
        return R.layout.fragment_menu;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.menu_tv_date);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mTvDate = (TextView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.menu_tv_week);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mTvWeek = (TextView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.menu_tv_time);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.mTvTime = (TextView) viewFindViewById3;
        ConstraintLayout constraintLayoutFindViewById = view.findViewById(R.id.parent);
        LaunchConfig launchConfigLoadConfig = getLauncherRepository().loadConfig();
        if (launchConfigLoadConfig != null && launchConfigLoadConfig.getMenuSlide_bg_custom() == 1) {
            constraintLayoutFindViewById.setBackgroundColor(Color.parseColor("#" + launchConfigLoadConfig.getMenuSlide_bg_color()));
        }
        TextView textView = this.mTvDate;
        MenuViewModel menuViewModel = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvDate");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.fragment.menu.MenuFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MenuFragment.onViewCreated$lambda$1(view2);
            }
        });
        RecyclerView recyclerViewFindViewById = view.findViewById(R.id.menu_rv_shortcuts);
        Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = recyclerViewFindViewById;
        this.mRvShortcuts = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRvShortcuts");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, 1, false));
        int i = R.layout.menu_item_shortcut;
        MenuViewModel menuViewModel2 = this.viewModel;
        if (menuViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            menuViewModel2 = null;
        }
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(i, (List) menuViewModel2.getShortcuts().getValue());
        this.mAdapter = anonymousClass3;
        anonymousClass3.addChildClickViewIds(new int[]{R.id.menu_item_shortcut_icon});
        BaseQuickAdapter<RecentTask, BaseViewHolder> baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.dw.launcher.ui.fragment.menu.MenuFragment$$ExternalSyntheticLambda1
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter2, View view2, int i2) {
                    MenuFragment.onViewCreated$lambda$4(this.f$0, baseQuickAdapter2, view2, i2);
                }
            });
        }
        RecyclerView recyclerView2 = this.mRvShortcuts;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRvShortcuts");
            recyclerView2 = null;
        }
        recyclerView2.setAdapter(this.mAdapter);
        updateDate();
        MenuViewModel menuViewModel3 = this.viewModel;
        if (menuViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            menuViewModel = menuViewModel3;
        }
        menuViewModel.reload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(View view) {
        System.out.println((Object) "------on date clicked----");
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.fragment.menu.MenuFragment$onViewCreated$3, reason: invalid class name */
    /* JADX INFO: compiled from: MenuFragment.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/dw/launcher/ui/fragment/menu/MenuFragment$onViewCreated$3", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/RecentTask;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "getItemCount", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class AnonymousClass3 extends BaseQuickAdapter<RecentTask, BaseViewHolder> {
        AnonymousClass3(int i, List<RecentTask> list) {
            super(i, list);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void convert(BaseViewHolder holder, RecentTask item) {
            LaunchConfig launchConfigLoadConfig;
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            int i = R.id.menu_item_shortcut_icon;
            Context contextRequireContext = MenuFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            holder.setImageDrawable(i, item.loadIcon(contextRequireContext));
            LauncherRepository launcherRepository = MenuFragment.this.getLauncherRepository();
            if (launcherRepository != null && (launchConfigLoadConfig = launcherRepository.loadConfig()) != null && launchConfigLoadConfig.getMenuSlideAppDynastic() == 0) {
                ImageView imageView = (ImageView) holder.getView(R.id.menu_item_shortcut_icon);
                final MenuFragment menuFragment = MenuFragment.this;
                imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.fragment.menu.MenuFragment$onViewCreated$3$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return MenuFragment.AnonymousClass3.convert$lambda$0(menuFragment, view);
                    }
                });
            }
            holder.setGone(R.id.iv_delete, !MenuFragment.this.getIsEditMode());
            if (MenuFragment.this.getIsEditMode()) {
                MenuViewModel menuViewModel = MenuFragment.this.viewModel;
                if (menuViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    menuViewModel = null;
                }
                List list = (List) menuViewModel.getShortcuts().getValue();
                if (list != null) {
                    if (holder.getAdapterPosition() == list.size() - 1 && Intrinsics.areEqual(AddMenuShortcutActivity.class.getName(), item.getClassName())) {
                        holder.setGone(R.id.iv_delete, true);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convert$lambda$0(MenuFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setEditMode(true);
            this$0.checkIfAddIconIsAdded();
            BaseQuickAdapter baseQuickAdapter = this$0.mAdapter;
            if (baseQuickAdapter != null) {
                baseQuickAdapter.notifyDataSetChanged();
            }
            return true;
        }

        public int getItemCount() {
            return RangesKt.coerceAtMost(getData().size(), 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(MenuFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        MenuViewModel menuViewModel = this$0.viewModel;
        MenuViewModel menuViewModel2 = null;
        if (menuViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            menuViewModel = null;
        }
        List list = (List) menuViewModel.getShortcuts().getValue();
        if (list != null) {
            if (this$0.isEditMode && Intrinsics.areEqual(((RecentTask) list.get(i)).getClassName(), AddMenuShortcutActivity.class.getName())) {
                this$0.startActivityForResult(new Intent(this$0.requireContext(), (Class<?>) AddMenuShortcutActivity.class), this$0.REQUEST_CODE);
                return;
            }
            if (!this$0.isEditMode) {
                if (i < 0 || i >= list.size()) {
                    return;
                }
                RecentTask recentTask = (RecentTask) list.get(i);
                if (AppLock.isInterceptApplicationStartup(this$0.requireContext(), new ComponentName(recentTask.getPackageName(), recentTask.getClassName()))) {
                    Timber.INSTANCE.d("当前线程" + Thread.currentThread().getName(), new Object[0]);
                    Toast.makeText(this$0.getContext(), this$0.requireContext().getString(R.string.app_manager_disabled), 0).show();
                    return;
                } else {
                    Context contextRequireActivity = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(contextRequireActivity, "requireActivity(...)");
                    recentTask.onClicked(contextRequireActivity);
                    return;
                }
            }
            if (list.size() > 2 && i < list.size()) {
                list.remove(i);
                this$0.checkIfAddIconIsAdded();
                BaseQuickAdapter<RecentTask, BaseViewHolder> baseQuickAdapter2 = this$0.mAdapter;
                if (baseQuickAdapter2 != null) {
                    baseQuickAdapter2.notifyDataSetChanged();
                }
                MenuViewModel menuViewModel3 = this$0.viewModel;
                if (menuViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    menuViewModel2 = menuViewModel3;
                }
                menuViewModel2.autoSaveShortcuts();
                return;
            }
            Toast.makeText(this$0.getContext(), this$0.getString(R.string.keepOne), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkIfAddIconIsAdded() {
        if (this.isEditMode) {
            MenuViewModel menuViewModel = this.viewModel;
            MenuViewModel menuViewModel2 = null;
            if (menuViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                menuViewModel = null;
            }
            List list = (List) menuViewModel.getShortcuts().getValue();
            boolean z = false;
            if ((list != null ? list.size() : 0) < 4) {
                MenuViewModel menuViewModel3 = this.viewModel;
                if (menuViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    menuViewModel2 = menuViewModel3;
                }
                ArrayList arrayList = (List) menuViewModel2.getShortcuts().getValue();
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                List list2 = arrayList;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(((RecentTask) it.next()).getClassName(), AddMenuShortcutActivity.class.getName())) {
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    return;
                }
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                arrayList.add(createAddIconShortcut(contextRequireContext));
                BaseQuickAdapter<RecentTask, BaseViewHolder> baseQuickAdapter = this.mAdapter;
                if (baseQuickAdapter != null) {
                    baseQuickAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    private final RecentTask createAddIconShortcut(Context context) {
        String packageName = context.getPackageName();
        String name = AddMenuShortcutActivity.class.getName();
        Intent intent = new Intent(context, Class.forName(name));
        intent.addFlags(268468224);
        Drawable drawable = ContextCompat.getDrawable(context, R.mipmap.icon_slide_add);
        Intrinsics.checkNotNull(packageName);
        Intrinsics.checkNotNull(name);
        return new RecentTask(packageName, name, intent, drawable);
    }

    public void onStart() {
        super.onStart();
        updateDate();
    }

    public void onResume() {
        super.onResume();
        TimeComponent timeComponent = this.mDateComponent;
        if (timeComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDateComponent");
            timeComponent = null;
        }
        timeComponent.register();
        updateDate();
    }

    public void onPause() {
        super.onPause();
        TimeComponent timeComponent = this.mDateComponent;
        if (timeComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDateComponent");
            timeComponent = null;
        }
        timeComponent.unregister();
    }

    private final void updateDate() {
        if (isAdded() && isResumed() && isVisible()) {
            boolean zIs24HourFormat = DateFormat.is24HourFormat(getContext());
            Calendar calendar = Calendar.getInstance();
            TextView textView = null;
            if (zIs24HourFormat) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.US);
                TextView textView2 = this.mTvTime;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvTime");
                    textView2 = null;
                }
                textView2.setText(simpleDateFormat.format(calendar.getTime()));
            } else {
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm", Locale.US);
                TextView textView3 = this.mTvTime;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvTime");
                    textView3 = null;
                }
                textView3.setText(simpleDateFormat2.format(calendar.getTime()));
            }
            calendar.get(7);
            TextView textView4 = this.mTvWeek;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvWeek");
            } else {
                textView = textView4;
            }
            textView.setText(DateUtils.formatDateTime(getContext(), calendar.getTimeInMillis(), 98322));
            Timber.INSTANCE.d("updateDate ", new Object[0]);
        }
    }

    public void onTimeChanged(int hour, int minute, int seconds) {
        updateDate();
    }

    public final void onSlideup() {
        this.isEditMode = false;
        MenuViewModel menuViewModel = this.viewModel;
        if (menuViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            menuViewModel = null;
        }
        menuViewModel.reload();
    }

    public final void closeEditMode() {
        Object next;
        if (this.isEditMode) {
            this.isEditMode = false;
            MenuViewModel menuViewModel = this.viewModel;
            MenuViewModel menuViewModel2 = null;
            if (menuViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                menuViewModel = null;
            }
            List list = (List) menuViewModel.getShortcuts().getValue();
            if (list != null) {
                Iterator it = list.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((RecentTask) next).getClassName(), AddMenuShortcutActivity.class.getName()));
                RecentTask recentTask = (RecentTask) next;
                if (recentTask != null) {
                    MenuViewModel menuViewModel3 = this.viewModel;
                    if (menuViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        menuViewModel2 = menuViewModel3;
                    }
                    List list2 = (List) menuViewModel2.getShortcuts().getValue();
                    if (list2 != null) {
                        list2.remove(recentTask);
                    }
                }
            }
            BaseQuickAdapter<RecentTask, BaseViewHolder> baseQuickAdapter = this.mAdapter;
            if (baseQuickAdapter != null) {
                baseQuickAdapter.notifyDataSetChanged();
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Object next;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.REQUEST_CODE && resultCode == -1) {
            MenuViewModel menuViewModel = null;
            String stringExtra = data != null ? data.getStringExtra("packageName") : null;
            String stringExtra2 = data != null ? data.getStringExtra("className") : null;
            Timber.INSTANCE.d("packageName: " + stringExtra + " className: " + stringExtra2, new Object[0]);
            this.isEditMode = false;
            MenuViewModel menuViewModel2 = this.viewModel;
            if (menuViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                menuViewModel2 = null;
            }
            List list = (List) menuViewModel2.getShortcuts().getValue();
            if (list != null) {
                Iterator it = list.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((RecentTask) next).getClassName(), AddMenuShortcutActivity.class.getName()));
                RecentTask recentTask = (RecentTask) next;
                if (recentTask != null) {
                    MenuViewModel menuViewModel3 = this.viewModel;
                    if (menuViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        menuViewModel3 = null;
                    }
                    List list2 = (List) menuViewModel3.getShortcuts().getValue();
                    if (list2 != null) {
                        list2.remove(recentTask);
                    }
                    MenuViewModel menuViewModel4 = this.viewModel;
                    if (menuViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        menuViewModel = menuViewModel4;
                    }
                    menuViewModel.addShortcut(stringExtra, stringExtra2);
                }
            }
            BaseQuickAdapter<RecentTask, BaseViewHolder> baseQuickAdapter = this.mAdapter;
            if (baseQuickAdapter != null) {
                baseQuickAdapter.notifyDataSetChanged();
            }
        }
    }
}
