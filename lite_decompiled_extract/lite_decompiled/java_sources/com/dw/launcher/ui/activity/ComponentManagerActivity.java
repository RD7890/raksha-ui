package com.dw.launcher.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.module.BaseDraggableModule;
import com.chad.library.adapter.base.module.DraggableModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.AppItem;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.SharedPreferencesUtils;
import com.dw.launcher.ui.dashboard.layoutmanager.decoration.SpaceItemDecoration;
import com.dw.launcher.util.AppCardConfig;
import com.dw.launcher.util.ResourceUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import javax.inject.Inject;
import timber.log.Timber;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class ComponentManagerActivity extends Hilt_ComponentManagerActivity {
    List<AppItem> appItemList;
    boolean isUpdate = false;
    RecyclerView recyclerView;

    @Inject
    SharedPreferencesUtils sharedPreferencesUtils;

    @Inject
    SysKeyEvent sysKeyEvent;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.dw.launcher.ui.activity.Hilt_ComponentManagerActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.recyclerView = findViewById(R.id.recycler_view);
        List<AppItem> list = (List) new Gson().fromJson(this.sharedPreferencesUtils.getAppItemListConfig(), new TypeToken<List<AppItem>>() { // from class: com.dw.launcher.ui.activity.ComponentManagerActivity.1
        }.getType());
        this.appItemList = list;
        for (final AppItem appItem : list) {
            if (!this.appItemList.stream().anyMatch(new Predicate() { // from class: com.dw.launcher.ui.activity.ComponentManagerActivity$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ComponentManagerActivity.lambda$onCreate$0(appItem, (AppItem) obj);
                }
            })) {
                this.appItemList.add(appItem);
            }
        }
        EditFunctionAdpater editFunctionAdpater = new EditFunctionAdpater(this.appItemList);
        this.recyclerView.setLayoutManager(new GridLayoutManager(this, 2, 1, false));
        this.recyclerView.addItemDecoration(new SpaceItemDecoration(this, (int) ResourceUtils.dpToPx(this, 30.0f), (int) ResourceUtils.dpToPx(this, 30.0f), 2));
        this.recyclerView.setAdapter(editFunctionAdpater);
        editFunctionAdpater.getDraggableModule().setDragEnabled(true);
        editFunctionAdpater.getDraggableModule().setOnItemDragListener(new AnonymousClass2());
    }

    static /* synthetic */ boolean lambda$onCreate$0(AppItem appItem, AppItem appItem2) {
        return appItem2.getId() == appItem.getId();
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.activity.ComponentManagerActivity$2, reason: invalid class name */
    class AnonymousClass2 implements OnItemDragListener {
        public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
        }

        public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
        }

        AnonymousClass2() {
        }

        public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
            ComponentManagerActivity.this.appItemList.stream().forEach(new Consumer() { // from class: com.dw.launcher.ui.activity.ComponentManagerActivity$2$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    AppItem appItem = (AppItem) obj;
                    Timber.d("拖拽结束后 itemId = %d name = %s selected = %b", Integer.valueOf(appItem.getId()), appItem.getName(), Boolean.valueOf(appItem.getSelected()));
                }
            });
            ComponentManagerActivity.this.sharedPreferencesUtils.setAppSelectedItem(true);
            ComponentManagerActivity.this.sharedPreferencesUtils.setAppItemListConfig(new Gson().toJson(ComponentManagerActivity.this.appItemList));
            ComponentManagerActivity.this.isUpdate = true;
        }
    }

    public int getLayoutId() {
        return R.layout.activity_edit_componet;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.sysKeyEvent.getSingleKeyCode() == keyCode) {
            if (this.isUpdate) {
                sendBroadcast(new Intent(AppCardConfig.ACTION_ITEM_CHANGED_BROADCAST));
                this.isUpdate = false;
            }
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.isUpdate) {
            sendBroadcast(new Intent(AppCardConfig.ACTION_ITEM_CHANGED_BROADCAST));
            this.isUpdate = false;
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.isUpdate) {
            sendBroadcast(new Intent(AppCardConfig.ACTION_ITEM_CHANGED_BROADCAST));
            this.isUpdate = false;
        }
    }

    public class EditFunctionAdpater extends BaseQuickAdapter<AppItem, BaseViewHolder> implements DraggableModule {
        public EditFunctionAdpater(List<AppItem> data) {
            super(R.layout.item_unselectfunction, data);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void convert(BaseViewHolder helper, final AppItem item) {
            if (item.getSelected()) {
                helper.setImageResource(R.id.iv_select, R.mipmap.icon__delete);
            } else {
                helper.setImageResource(R.id.iv_select, R.mipmap.icon_functionadd);
            }
            helper.setImageResource(R.id.bg, AppCardConfig.getMap().get(Integer.valueOf(item.getId())).intValue());
            helper.getView(R.id.iv_select).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.ComponentManagerActivity$EditFunctionAdpater$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m4x3628b78c(item, view);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$convert$0$com-dw-launcher-ui-activity-ComponentManagerActivity$EditFunctionAdpater, reason: not valid java name */
        /* synthetic */ void m4x3628b78c(AppItem appItem, View view) {
            if (appItem.getSelected()) {
                appItem.setSelected(false);
            } else {
                appItem.setSelected(true);
            }
            notifyDataSetChanged();
            ComponentManagerActivity.this.sharedPreferencesUtils.setAppSelectedItem(true);
            ComponentManagerActivity.this.sharedPreferencesUtils.setAppItemListConfig(new Gson().toJson(ComponentManagerActivity.this.appItemList));
            ComponentManagerActivity.this.isUpdate = true;
        }

        public BaseDraggableModule addDraggableModule(BaseQuickAdapter<?, ?> baseQuickAdapter) {
            return new BaseDraggableModule(baseQuickAdapter);
        }
    }

    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (this.isUpdate) {
            sendBroadcast(new Intent(AppCardConfig.ACTION_ITEM_CHANGED_BROADCAST));
            this.isUpdate = false;
        }
        finish();
    }
}
