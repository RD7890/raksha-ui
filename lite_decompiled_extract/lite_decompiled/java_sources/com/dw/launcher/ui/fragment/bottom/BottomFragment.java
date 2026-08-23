package com.dw.launcher.ui.fragment.bottom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RemoteViews;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.dragswipe.DragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.module.BaseDraggableModule;
import com.chad.library.adapter.base.module.DraggableModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.core.component.NotificationComponent;
import com.dw.launcher.data.listener.OnScrollChangeListener;
import com.dw.launcher.ui.fragment.launcher.LauncherCardFragment;
import com.dw.launcher.ui.fragment.launcher.LauncherFragment;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: BottomFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u001a\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0006\u0010$\u001a\u00020\u001dJ\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0011J\u001c\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/dw/launcher/ui/fragment/bottom/BottomFragment;", "Lcom/dw/launcher/base/BaseFragment;", "Ljava/util/Observer;", "()V", "clearAll", "Landroid/widget/ImageButton;", "mAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Landroid/service/notification/StatusBarNotification;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "mNotificationComponent", "Lcom/dw/launcher/core/component/NotificationComponent;", "getMNotificationComponent", "()Lcom/dw/launcher/core/component/NotificationComponent;", "setMNotificationComponent", "(Lcom/dw/launcher/core/component/NotificationComponent;)V", "onScrollChangeListener", "Lcom/dw/launcher/data/listener/OnScrollChangeListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getContentView", "Landroid/widget/RemoteViews;", "context", "Landroid/content/Context;", "notification", "Landroid/app/Notification;", "getLayoutId", "", "onAttach", "", "onDetach", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "scrollToTop", "setOnScrollChangeListener", "update", "o", "Ljava/util/Observable;", "arg", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class BottomFragment extends Hilt_BottomFragment implements Observer {
    private ImageButton clearAll;
    private BaseQuickAdapter<StatusBarNotification, BaseViewHolder> mAdapter;

    @Inject
    public NotificationComponent mNotificationComponent;
    private OnScrollChangeListener onScrollChangeListener;
    private RecyclerView recyclerView;

    public final NotificationComponent getMNotificationComponent() {
        NotificationComponent notificationComponent = this.mNotificationComponent;
        if (notificationComponent != null) {
            return notificationComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mNotificationComponent");
        return null;
    }

    public final void setMNotificationComponent(NotificationComponent notificationComponent) {
        Intrinsics.checkNotNullParameter(notificationComponent, "<set-?>");
        this.mNotificationComponent = notificationComponent;
    }

    public int getLayoutId() {
        return R.layout.fragment_bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RemoteViews getContentView(Context context, Notification notification) {
        if (notification.contentView != null) {
            return notification.contentView;
        }
        return null;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerViewFindViewById = view.findViewById(R.id.bottom_list);
        Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(...)");
        this.recyclerView = recyclerViewFindViewById;
        View viewFindViewById = view.findViewById(R.id.notification_footer_clear);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ImageButton imageButton = (ImageButton) viewFindViewById;
        this.clearAll = imageButton;
        RecyclerView recyclerView = null;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearAll");
            imageButton = null;
        }
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.fragment.bottom.BottomFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BottomFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.dw.launcher.ui.fragment.bottom.BottomFragment.onViewCreated.2
            public void onScrollStateChanged(RecyclerView recyclerView4, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView4, "recyclerView");
                super.onScrollStateChanged(recyclerView4, newState);
                if (newState != 0) {
                    return;
                }
                if (!recyclerView4.canScrollVertically(-1)) {
                    OnScrollChangeListener onScrollChangeListener = BottomFragment.this.onScrollChangeListener;
                    if (onScrollChangeListener != null) {
                        onScrollChangeListener.onScrollChange(true);
                        return;
                    }
                    return;
                }
                OnScrollChangeListener onScrollChangeListener2 = BottomFragment.this.onScrollChangeListener;
                if (onScrollChangeListener2 != null) {
                    onScrollChangeListener2.onScrollChange(false);
                }
            }
        });
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(R.layout.bottom_item_notification);
        this.mAdapter = anonymousClass3;
        anonymousClass3.setOnItemClickListener(new OnItemClickListener() { // from class: com.dw.launcher.ui.fragment.bottom.BottomFragment$$ExternalSyntheticLambda1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) throws PendingIntent.CanceledException {
                BottomFragment.onViewCreated$lambda$2(this.f$0, baseQuickAdapter, view2, i);
            }
        });
        BaseQuickAdapter<StatusBarNotification, BaseViewHolder> baseQuickAdapter = this.mAdapter;
        BaseDraggableModule draggableModule = baseQuickAdapter != null ? baseQuickAdapter.getDraggableModule() : null;
        if (draggableModule != null) {
            draggableModule.setSwipeEnabled(true);
        }
        BaseQuickAdapter<StatusBarNotification, BaseViewHolder> baseQuickAdapter2 = this.mAdapter;
        BaseDraggableModule draggableModule2 = baseQuickAdapter2 != null ? baseQuickAdapter2.getDraggableModule() : null;
        if (draggableModule2 != null) {
            draggableModule2.setDragEnabled(false);
        }
        BaseQuickAdapter<StatusBarNotification, BaseViewHolder> baseQuickAdapter3 = this.mAdapter;
        if (baseQuickAdapter3 != null) {
            final BaseDraggableModule draggableModule3 = baseQuickAdapter3.getDraggableModule();
            ItemTouchHelper.Callback callback = new DragAndSwipeCallback(draggableModule3) { // from class: com.dw.launcher.ui.fragment.bottom.BottomFragment$onViewCreated$5$dragAndSwipeCallback$1
                public int getMovementFlags(RecyclerView recyclerView4, RecyclerView.ViewHolder viewHolder) {
                    Intrinsics.checkNotNullParameter(recyclerView4, "recyclerView");
                    Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
                    viewHolder.getBindingAdapterPosition();
                    return DragAndSwipeCallback.makeMovementFlags(0, 0);
                }
            };
            callback.setSwipeMoveFlags(48);
            baseQuickAdapter3.getDraggableModule().setItemTouchHelperCallback((DragAndSwipeCallback) callback);
            baseQuickAdapter3.getDraggableModule().setItemTouchHelper(new ItemTouchHelper(callback));
            baseQuickAdapter3.getDraggableModule().setSwipeEnabled(true);
            BaseDraggableModule draggableModule4 = baseQuickAdapter3.getDraggableModule();
            RecyclerView recyclerView4 = this.recyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView4 = null;
            }
            draggableModule4.attachToRecyclerView(recyclerView4);
        }
        BaseQuickAdapter<StatusBarNotification, BaseViewHolder> baseQuickAdapter4 = this.mAdapter;
        if (baseQuickAdapter4 != null) {
            baseQuickAdapter4.setEmptyView(R.layout.layout_notification_empty);
        }
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView5 = null;
        }
        recyclerView5.setAdapter(this.mAdapter);
        BaseQuickAdapter<StatusBarNotification, BaseViewHolder> baseQuickAdapter5 = this.mAdapter;
        if (baseQuickAdapter5 != null) {
            baseQuickAdapter5.setNewInstance(getMNotificationComponent().getNotifications());
        }
        BaseQuickAdapter<StatusBarNotification, BaseViewHolder> baseQuickAdapter6 = this.mAdapter;
        if (baseQuickAdapter6 != null) {
            if (!baseQuickAdapter6.getData().isEmpty()) {
                RecyclerView recyclerView6 = this.recyclerView;
                if (recyclerView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView6 = null;
                }
                recyclerView6.setVisibility(0);
            } else {
                RecyclerView recyclerView7 = this.recyclerView;
                if (recyclerView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView7 = null;
                }
                recyclerView7.setVisibility(8);
            }
        }
        RecyclerView recyclerView8 = this.recyclerView;
        if (recyclerView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView8;
        }
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(BottomFragment this$0, View view) {
        List<StatusBarNotification> data;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseQuickAdapter<StatusBarNotification, BaseViewHolder> baseQuickAdapter = this$0.mAdapter;
        if (baseQuickAdapter != null && (data = baseQuickAdapter.getData()) != null) {
            for (StatusBarNotification statusBarNotification : data) {
                if (statusBarNotification.isClearable()) {
                    this$0.getMNotificationComponent().clearItem(statusBarNotification);
                }
            }
        }
        BaseQuickAdapter<StatusBarNotification, BaseViewHolder> baseQuickAdapter2 = this$0.mAdapter;
        if (baseQuickAdapter2 != null) {
            baseQuickAdapter2.notifyDataSetChanged();
        }
        if (this$0.getParentFragment() instanceof LauncherFragment) {
            LauncherFragment parentFragment = this$0.getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.dw.launcher.ui.fragment.launcher.LauncherFragment");
            parentFragment.closeDrawers();
        } else if (this$0.getParentFragment() instanceof LauncherCardFragment) {
            LauncherCardFragment parentFragment2 = this$0.getParentFragment();
            Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.dw.launcher.ui.fragment.launcher.LauncherCardFragment");
            parentFragment2.closeDrawers();
        }
        BaseQuickAdapter<StatusBarNotification, BaseViewHolder> baseQuickAdapter3 = this$0.mAdapter;
        if (baseQuickAdapter3 != null) {
            baseQuickAdapter3.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.fragment.bottom.BottomFragment$onViewCreated$3, reason: invalid class name */
    /* JADX INFO: compiled from: BottomFragment.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"com/dw/launcher/ui/fragment/bottom/BottomFragment$onViewCreated$3", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Landroid/service/notification/StatusBarNotification;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/module/DraggableModule;", "convert", "", "holder", "item", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class AnonymousClass3 extends BaseQuickAdapter<StatusBarNotification, BaseViewHolder> implements DraggableModule {
        public BaseDraggableModule addDraggableModule(BaseQuickAdapter<?, ?> baseQuickAdapter) {
            return DraggableModule.DefaultImpls.addDraggableModule(this, baseQuickAdapter);
        }

        AnonymousClass3(int i) {
            super(i, (List) null, 2, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void convert(BaseViewHolder holder, StatusBarNotification item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            ViewGroup viewGroup = (ViewGroup) holder.getView(R.id.notification_item_content_container);
            ViewGroup viewGroup2 = (ViewGroup) holder.getView(R.id.notification_item_content);
            viewGroup.removeAllViews();
            BottomFragment bottomFragment = BottomFragment.this;
            Context contextRequireContext = bottomFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            Notification notification = item.getNotification();
            Intrinsics.checkNotNullExpressionValue(notification, "getNotification(...)");
            RemoteViews contentView = bottomFragment.getContentView(contextRequireContext, notification);
            if (contentView != null) {
                BottomFragment bottomFragment2 = BottomFragment.this;
                viewGroup2.setVisibility(8);
                viewGroup.setVisibility(0);
                try {
                    viewGroup.addView(contentView.apply(bottomFragment2.requireContext().getApplicationContext(), viewGroup));
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            viewGroup2.setVisibility(0);
            viewGroup.setVisibility(8);
            try {
                Object obj = item.getNotification().extras.get("android.title");
                String string = obj != null ? obj.toString() : null;
                Object obj2 = item.getNotification().extras.get("android.text");
                holder.setText(R.id.notification_item_content_title, string).setText(R.id.notification_item_content_text, obj2 != null ? obj2.toString() : null);
            } catch (Exception unused2) {
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(BottomFragment this$0, BaseQuickAdapter adapter, View view, int i) throws PendingIntent.CanceledException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Object obj = adapter.getData().get(i);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.service.notification.StatusBarNotification");
        StatusBarNotification statusBarNotification = (StatusBarNotification) obj;
        PendingIntent pendingIntent = statusBarNotification.getNotification().contentIntent;
        if (pendingIntent != null) {
            pendingIntent.send();
        }
        if (statusBarNotification.isClearable()) {
            this$0.getMNotificationComponent().clearItem(statusBarNotification);
        }
    }

    @Override // com.dw.launcher.ui.fragment.bottom.Hilt_BottomFragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        getMNotificationComponent().addObserver(this);
    }

    public void onDetach() {
        super.onDetach();
        getMNotificationComponent().deleteObserver(this);
    }

    @Override // java.util.Observer
    public void update(Observable o, Object arg) {
        Timber.INSTANCE.i("----onDataSetChanged", new Object[0]);
        BaseQuickAdapter<StatusBarNotification, BaseViewHolder> baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.setNewInstance(getMNotificationComponent().getNotifications());
            List notifications = getMNotificationComponent().getNotifications();
            RecyclerView recyclerView = null;
            if (notifications == null || notifications.isEmpty()) {
                RecyclerView recyclerView2 = this.recyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    recyclerView = recyclerView2;
                }
                recyclerView.setVisibility(8);
                return;
            }
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setVisibility(0);
        }
    }

    public final void scrollToTop() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    public final void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        Intrinsics.checkNotNullParameter(onScrollChangeListener, "onScrollChangeListener");
        this.onScrollChangeListener = onScrollChangeListener;
    }
}
