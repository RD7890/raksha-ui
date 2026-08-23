package com.dw.launcher.manager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.CustomShortcutInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShortcutCustomManager.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/dw/launcher/manager/ShortcutCustomManager;", BuildConfig.FLAVOR, "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "shortcutDialog", "Landroid/app/AlertDialog;", "hideShortCutDialog", BuildConfig.FLAVOR, "isShowShortCutDialog", BuildConfig.FLAVOR, "showShortCut", "packageName", BuildConfig.FLAVOR, "showShortCutDialog", "Landroid/content/Context;", "shortcutList", BuildConfig.FLAVOR, "Lcom/dw/launcher/data/entity/CustomShortcutInfo;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ShortcutCustomManager {
    private final Activity context;
    private AlertDialog shortcutDialog;

    public ShortcutCustomManager(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "context");
        this.context = activity;
    }

    public final boolean showShortCut(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        try {
            Context contextCreatePackageContext = this.context.createPackageContext(packageName, 0);
            Object systemService = this.context.getSystemService("launcherapps");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.pm.LauncherApps");
            LauncherApps launcherApps = (LauncherApps) systemService;
            if (Build.VERSION.SDK_INT >= 25 && launcherApps.hasShortcutHostPermission()) {
                ArrayList<ShortcutInfo> arrayList = new ArrayList();
                ShortcutManager shortcutManager = (ShortcutManager) contextCreatePackageContext.getSystemService(ShortcutManager.class);
                List<ShortcutInfo> dynamicShortcuts = shortcutManager != null ? shortcutManager.getDynamicShortcuts() : null;
                if (dynamicShortcuts != null) {
                    arrayList.addAll(dynamicShortcuts);
                }
                List<ShortcutInfo> manifestShortcuts = shortcutManager != null ? shortcutManager.getManifestShortcuts() : null;
                if (manifestShortcuts != null) {
                    arrayList.addAll(manifestShortcuts);
                }
                List<ShortcutInfo> pinnedShortcuts = shortcutManager != null ? shortcutManager.getPinnedShortcuts() : null;
                if (pinnedShortcuts != null) {
                    arrayList.addAll(pinnedShortcuts);
                }
                if (!arrayList.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    for (ShortcutInfo shortcutInfo : arrayList) {
                        CustomShortcutInfo customShortcutInfo = new CustomShortcutInfo(null, null, null, null, 15, null);
                        customShortcutInfo.setId(shortcutInfo.getId());
                        CharSequence longLabel = shortcutInfo.getLongLabel();
                        customShortcutInfo.setLabel((longLabel == null || longLabel.length() == 0) ? shortcutInfo.getShortLabel().toString() : shortcutInfo.getLongLabel().toString());
                        customShortcutInfo.setIntent(shortcutInfo.getIntent());
                        customShortcutInfo.setDrawable(launcherApps.getShortcutIconDrawable(shortcutInfo, 0));
                        arrayList2.add(customShortcutInfo);
                    }
                    showShortCutDialog(this.context, arrayList2);
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private final void showShortCutDialog(Context context, List<CustomShortcutInfo> shortcutList) {
        try {
            if (this.shortcutDialog != null) {
                hideShortCutDialog();
            }
            View viewInflate = View.inflate(context, R.layout.dialog_shortcut, null);
            AlertDialog alertDialogCreate = new AlertDialog.Builder(context).create();
            alertDialogCreate.show();
            Window window = alertDialogCreate.getWindow();
            if (window != null) {
                Intrinsics.checkNotNull(window);
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setLayout((context.getResources().getDisplayMetrics().widthPixels * 2) / 3, -2);
            }
            alertDialogCreate.setContentView(viewInflate);
            View viewFindViewById = viewInflate.findViewById(R.id.recycle_dialog);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            RecyclerView recyclerView = (RecyclerView) viewFindViewById;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, 1);
            Drawable drawable = ContextCompat.getDrawable(context, R.color.textcolor33);
            Intrinsics.checkNotNull(drawable);
            dividerItemDecoration.setDrawable(drawable);
            recyclerView.addItemDecoration(dividerItemDecoration);
            recyclerView.setAdapter(new AnonymousClass2(shortcutList, context, this, R.layout.item_dialog_shortcut));
            this.shortcutDialog = alertDialogCreate;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.dw.launcher.manager.ShortcutCustomManager$showShortCutDialog$2, reason: invalid class name */
    /* JADX INFO: compiled from: ShortcutCustomManager.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/dw/launcher/manager/ShortcutCustomManager$showShortCutDialog$2", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/dw/launcher/data/entity/CustomShortcutInfo;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", BuildConfig.FLAVOR, "holder", "item", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass2 extends BaseQuickAdapter<CustomShortcutInfo, BaseViewHolder> {
        final /* synthetic */ Context $context;
        final /* synthetic */ ShortcutCustomManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<CustomShortcutInfo> list, Context context, ShortcutCustomManager shortcutCustomManager, int i) {
            super(i, list);
            this.$context = context;
            this.this$0 = shortcutCustomManager;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(BaseViewHolder holder, final CustomShortcutInfo item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            holder.setText(R.id.tv_text, item.getLabel()).setImageDrawable(R.id.head_icon, item.getDrawable());
            View view = holder.itemView;
            final Context context = this.$context;
            final ShortcutCustomManager shortcutCustomManager = this.this$0;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.manager.ShortcutCustomManager$showShortCutDialog$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ShortcutCustomManager.AnonymousClass2.convert$lambda$0(context, item, shortcutCustomManager, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$0(Context context, CustomShortcutInfo customShortcutInfo, ShortcutCustomManager shortcutCustomManager, View view) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(customShortcutInfo, "$item");
            Intrinsics.checkNotNullParameter(shortcutCustomManager, "this$0");
            context.startActivity(customShortcutInfo.getIntent());
            shortcutCustomManager.hideShortCutDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideShortCutDialog() {
        AlertDialog alertDialog = this.shortcutDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final boolean isShowShortCutDialog() {
        AlertDialog alertDialog = this.shortcutDialog;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }
}
