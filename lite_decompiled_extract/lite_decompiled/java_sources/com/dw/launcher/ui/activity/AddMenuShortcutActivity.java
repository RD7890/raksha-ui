package com.dw.launcher.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.Shortcut;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.ui.dashboard.DashboardViewModel;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddMenuShortcutActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u001cH\u0014R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/dw/launcher/ui/activity/AddMenuShortcutActivity;", "Lcom/dw/launcher/base/BaseActivity;", "()V", "mAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/Shortcut;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "mPreference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "getMPreference", "()Lcom/dw/launcher/data/preference/LauncherPreference;", "setMPreference", "(Lcom/dw/launcher/data/preference/LauncherPreference;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "viewModel", "Lcom/dw/launcher/ui/dashboard/DashboardViewModel;", "getLayoutId", "", "getShortcuts", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyUp", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onUserLeaveHint", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class AddMenuShortcutActivity extends Hilt_AddMenuShortcutActivity {
    private BaseQuickAdapter<Shortcut, BaseViewHolder> mAdapter;

    @Inject
    public LauncherPreference mPreference;
    private RecyclerView recyclerView;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private DashboardViewModel viewModel;

    public final LauncherPreference getMPreference() {
        LauncherPreference launcherPreference = this.mPreference;
        if (launcherPreference != null) {
            return launcherPreference;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPreference");
        return null;
    }

    public final void setMPreference(LauncherPreference launcherPreference) {
        Intrinsics.checkNotNullParameter(launcherPreference, "<set-?>");
        this.mPreference = launcherPreference;
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
        return R.layout.activity_addshortcut;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.dw.launcher.ui.activity.Hilt_AddMenuShortcutActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerViewFindViewById = findViewById(R.id.linear_recycler_view);
        Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(...)");
        this.recyclerView = recyclerViewFindViewById;
        this.viewModel = (DashboardViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DashboardViewModel.class);
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager((Context) this, 1, false));
        this.mAdapter = new BaseQuickAdapter<Shortcut, BaseViewHolder>(R.layout.dashboard_linear_item_shortcut, getShortcuts()) { // from class: com.dw.launcher.ui.activity.AddMenuShortcutActivity.onCreate.1
            /* JADX INFO: Access modifiers changed from: protected */
            public void convert(BaseViewHolder holder, Shortcut item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ((TextView) holder.getView(R.id.linear_item_shortcut_label)).setSelected(true);
                ((TextView) holder.getView(R.id.linear_item_shortcut_label)).setFocusable(true);
                ((TextView) holder.getView(R.id.linear_item_shortcut_label)).setFocusableInTouchMode(true);
                ((TextView) holder.getView(R.id.linear_item_shortcut_label)).requestFocusFromTouch();
                holder.setImageDrawable(R.id.linear_item_shortcut_icon, item.getCustomIcon()).setText(R.id.linear_item_shortcut_label, item.getLabel());
                holder.itemView.setTag(item);
            }
        };
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setAdapter(this.mAdapter);
        final BaseQuickAdapter<Shortcut, BaseViewHolder> baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.dw.launcher.ui.activity.AddMenuShortcutActivity$$ExternalSyntheticLambda0
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter2, View view, int i) {
                    AddMenuShortcutActivity.onCreate$lambda$1$lambda$0(baseQuickAdapter, this, baseQuickAdapter2, view, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1$lambda$0(BaseQuickAdapter adapter, AddMenuShortcutActivity this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        ActivityInfo activityInfo;
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        if (i < 0 || i >= adapter.getItemCount()) {
            return;
        }
        Shortcut shortcut = (Shortcut) adapter.getItem(i);
        Intent intent = new Intent();
        intent.putExtra("packageName", shortcut.getPackageName());
        ResolveInfo resolveInfo = shortcut.getResolveInfo();
        intent.putExtra("className", (resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null) ? null : activityInfo.name);
        this$0.setResult(-1, intent);
        this$0.finish();
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == getSysKeyEvent().getSingleKeyCode()) {
            finish();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    public final List<Shortcut> getShortcuts() {
        DashboardViewModel dashboardViewModel = this.viewModel;
        if (dashboardViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dashboardViewModel = null;
        }
        List<Shortcut> list = (List) dashboardViewModel.getShortcuts().getValue();
        return list != null ? list : new ArrayList();
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        finish();
    }
}
