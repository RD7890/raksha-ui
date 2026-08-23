package com.dw.launcher.ui.dashboard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.LaunchConfig;
import com.dw.launcher.data.entity.Shortcut;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.ui.view.PageGridView;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import timber.log.Timber;

/* JADX INFO: compiled from: VerticalGridDashboard.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002FGB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010.\u001a\u00020\u0003H\u0016J\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u000203H\u0016J\u0018\u00104\u001a\u0002002\u0006\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u000203H\u0016J\u0010\u00105\u001a\u0002002\u0006\u00106\u001a\u000200H\u0016J\u0016\u00107\u001a\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0016J\u001a\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u001c\u0010A\u001a\u0002082\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0018\u00010\u0014R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\b\"\u0004\b*\u0010\nR\u001a\u0010+\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\b\"\u0004\b-\u0010\n¨\u0006H"}, d2 = {"Lcom/dw/launcher/ui/dashboard/VerticalGridDashboard;", "Lcom/dw/launcher/ui/dashboard/BaseDashboard;", "mItemCount", "", "mOrientation", "(II)V", "height", "getHeight", "()I", "setHeight", "(I)V", "ivbackground", "Landroid/widget/ImageView;", "launcherRepository", "Lcom/dw/launcher/data/repository/LauncherRepository;", "getLauncherRepository", "()Lcom/dw/launcher/data/repository/LauncherRepository;", "setLauncherRepository", "(Lcom/dw/launcher/data/repository/LauncherRepository;)V", "mAdapter", "Lcom/dw/launcher/ui/dashboard/VerticalGridDashboard$MyAdapter;", "mHandler", "Landroid/os/Handler;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mRightLayout", "Landroid/widget/FrameLayout;", "mStopPostionTask", "Ljava/lang/Runnable;", "multiple", "getMultiple", "setMultiple", "parent", "Landroid/widget/RelativeLayout;", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "totalScollerDistance", "getTotalScollerDistance", "setTotalScollerDistance", "width", "getWidth", "setWidth", "getLayoutId", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onSensorChanged", "up", "onShortcutsChanged", "", "shortcuts", "", "Lcom/dw/launcher/data/entity/Shortcut;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "update", "o", "Ljava/util/Observable;", "arg", "", "MyAdapter", "MyVH", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class VerticalGridDashboard extends Hilt_VerticalGridDashboard {
    private int height;
    private ImageView ivbackground;

    @Inject
    public LauncherRepository launcherRepository;
    private MyAdapter mAdapter;
    private Handler mHandler;
    private final int mItemCount;
    private final int mOrientation;
    private RecyclerView mRecyclerView;
    private FrameLayout mRightLayout;
    private final Runnable mStopPostionTask;
    private int multiple;
    private RelativeLayout parent;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private int totalScollerDistance;
    private int width;

    /* JADX WARN: Illegal instructions before constructor call */
    public VerticalGridDashboard() {
        int i = 0;
        this(i, i, 3, null);
    }

    public /* synthetic */ VerticalGridDashboard(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 2 : i, (i3 & 2) != 0 ? 1 : i2);
    }

    public VerticalGridDashboard(int i, int i2) {
        this.mItemCount = i;
        this.mOrientation = i2;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.multiple = 1;
        this.mStopPostionTask = new Runnable() { // from class: com.dw.launcher.ui.dashboard.VerticalGridDashboard$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VerticalGridDashboard.mStopPostionTask$lambda$4(this.f$0);
            }
        };
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final int getTotalScollerDistance() {
        return this.totalScollerDistance;
    }

    public final void setTotalScollerDistance(int i) {
        this.totalScollerDistance = i;
    }

    public final int getMultiple() {
        return this.multiple;
    }

    public final void setMultiple(int i) {
        this.multiple = i;
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
        if (this.mItemCount == 3) {
            return R.layout.fragment_dashboard_page_9;
        }
        return R.layout.fragment_dashboard_page_4;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, android.view.View] */
    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LaunchConfig launchConfigLoadConfig;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        PageGridView pageGridView = (PageGridView) view.findViewById(R.id.recycler_view);
        this.mRightLayout = (FrameLayout) view.findViewById(R.id.lay_slip);
        this.parent = (RelativeLayout) view.findViewById(R.id.parent);
        this.ivbackground = (ImageView) view.findViewById(R.id.iv_background);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = view.findViewById(R.id.view_slip_front);
        this.mRecyclerView = pageGridView;
        this.height = getResources().getDisplayMetrics().heightPixels / this.mItemCount;
        this.width = getResources().getDisplayMetrics().widthPixels / this.mItemCount;
        MyAdapter myAdapter = new MyAdapter(getShortcuts());
        this.mAdapter = myAdapter;
        pageGridView.setAdapter(myAdapter);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.dw.launcher.ui.dashboard.VerticalGridDashboard.onViewCreated.1
                public void onScrollStateChanged(RecyclerView recyclerView2, int newState) {
                    Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                    if (newState != 0) {
                        FrameLayout frameLayout = VerticalGridDashboard.this.mRightLayout;
                        if (frameLayout != null) {
                            frameLayout.setVisibility(0);
                        }
                        VerticalGridDashboard.this.mHandler.removeCallbacks(VerticalGridDashboard.this.mStopPostionTask);
                        return;
                    }
                    Timber.INSTANCE.d("滚动停止...", new Object[0]);
                    VerticalGridDashboard.this.setTotalScollerDistance(0);
                    VerticalGridDashboard.this.mHandler.removeCallbacks(VerticalGridDashboard.this.mStopPostionTask);
                    VerticalGridDashboard.this.mHandler.postDelayed(VerticalGridDashboard.this.mStopPostionTask, 1000L);
                }

                public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                    Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                    super.onScrolled(recyclerView2, dx, dy);
                    StaggeredGridLayoutManager layoutManager = recyclerView2.getLayoutManager();
                    StaggeredGridLayoutManager staggeredGridLayoutManager = layoutManager instanceof StaggeredGridLayoutManager ? layoutManager : null;
                    int i = 0;
                    int childCount = staggeredGridLayoutManager != null ? staggeredGridLayoutManager.getChildCount() : 0;
                    int itemCount = staggeredGridLayoutManager != null ? staggeredGridLayoutManager.getItemCount() : 0;
                    int[] iArrFindFirstVisibleItemPositions = staggeredGridLayoutManager != null ? staggeredGridLayoutManager.findFirstVisibleItemPositions((int[]) null) : null;
                    if (iArrFindFirstVisibleItemPositions != null) {
                        if (!(iArrFindFirstVisibleItemPositions.length == 0)) {
                            i = iArrFindFirstVisibleItemPositions[0];
                        }
                    }
                    float f = itemCount > childCount ? i / (itemCount - childCount) : 1.0f;
                    FrameLayout frameLayout = VerticalGridDashboard.this.mRightLayout;
                    Intrinsics.checkNotNull(frameLayout);
                    objectRef.element.setTranslationY(f * (frameLayout.getHeight() - objectRef.element.getHeight()));
                    VerticalGridDashboard verticalGridDashboard = VerticalGridDashboard.this;
                    verticalGridDashboard.setTotalScollerDistance(verticalGridDashboard.getTotalScollerDistance() - dy);
                }
            });
        }
        Drawable drawableLoadDrawable = loadDrawable(getWallpaperComponent().getWallpaper());
        if (drawableLoadDrawable != null && (imageView = this.ivbackground) != null) {
            imageView.setImageDrawable(drawableLoadDrawable);
        }
        showSlideUpTask(this.parent);
        LauncherRepository launcherRepository = getLauncherRepository();
        if (launcherRepository == null || (launchConfigLoadConfig = launcherRepository.loadConfig()) == null) {
            return;
        }
        this.multiple = launchConfigLoadConfig.getEncoder_specialscroll() == 1 ? this.mItemCount : 1;
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public void onShortcutsChanged(List<Shortcut> shortcuts) {
        Intrinsics.checkNotNullParameter(shortcuts, "shortcuts");
        MyAdapter myAdapter = this.mAdapter;
        if (myAdapter != null) {
            myAdapter.setMData(shortcuts);
            myAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public boolean onSensorChanged(boolean up) {
        Window window;
        Window window2;
        try {
            cancelScreenFlagTask();
            if (!up) {
                FragmentActivity activity = getActivity();
                if (activity != null && (window2 = activity.getWindow()) != null) {
                    window2.addFlags(128);
                }
                int i = this.totalScollerDistance;
                RecyclerView recyclerView = this.mRecyclerView;
                Intrinsics.checkNotNull(recyclerView);
                this.totalScollerDistance = i - (recyclerView.getChildAt(0).getHeight() * this.multiple);
                RecyclerView recyclerView2 = this.mRecyclerView;
                Intrinsics.checkNotNull(recyclerView2);
                recyclerView2.smoothScrollBy(0, this.totalScollerDistance);
                return true;
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (window = activity2.getWindow()) != null) {
                window.addFlags(128);
            }
            int i2 = this.totalScollerDistance;
            RecyclerView recyclerView3 = this.mRecyclerView;
            Intrinsics.checkNotNull(recyclerView3);
            this.totalScollerDistance = i2 + (recyclerView3.getChildAt(0).getHeight() * this.multiple);
            RecyclerView recyclerView4 = this.mRecyclerView;
            Intrinsics.checkNotNull(recyclerView4);
            recyclerView4.smoothScrollBy(0, this.totalScollerDistance);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Window window;
        Window window2;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!getIsVisble()) {
            return false;
        }
        if (keyCode == getSysKeyEvent().getDownKey()) {
            FragmentActivity activity = getActivity();
            if (activity != null && (window2 = activity.getWindow()) != null) {
                window2.addFlags(128);
            }
            onSensorStopped();
            int i = this.totalScollerDistance;
            RecyclerView recyclerView = this.mRecyclerView;
            Intrinsics.checkNotNull(recyclerView);
            this.totalScollerDistance = i - (recyclerView.getChildAt(0).getHeight() * this.multiple);
            RecyclerView recyclerView2 = this.mRecyclerView;
            Intrinsics.checkNotNull(recyclerView2);
            recyclerView2.smoothScrollBy(0, this.totalScollerDistance);
            return true;
        }
        if (keyCode == getSysKeyEvent().getUPKey()) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (window = activity2.getWindow()) != null) {
                window.addFlags(128);
            }
            onSensorStopped();
            int i2 = this.totalScollerDistance;
            RecyclerView recyclerView3 = this.mRecyclerView;
            Intrinsics.checkNotNull(recyclerView3);
            this.totalScollerDistance = i2 + (recyclerView3.getChildAt(0).getHeight() * this.multiple);
            RecyclerView recyclerView4 = this.mRecyclerView;
            Intrinsics.checkNotNull(recyclerView4);
            recyclerView4.smoothScrollBy(0, this.totalScollerDistance);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!getIsVisble()) {
            return false;
        }
        if (keyCode == getSysKeyEvent().getDownKey()) {
            closeScreenFlagTask();
            return true;
        }
        if (keyCode == getSysKeyEvent().getUPKey()) {
            Timber.INSTANCE.v(" onKeyUp KEYCODE_DPAD_UP...", new Object[0]);
            closeScreenFlagTask();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override // com.dw.launcher.ui.dashboard.BaseDashboard, java.util.Observer
    public void update(Observable o, Object arg) {
        ImageView imageView;
        Drawable drawableLoadDrawable = loadDrawable(getWallpaperComponent().getWallpaper());
        if (drawableLoadDrawable == null || (imageView = this.ivbackground) == null) {
            return;
        }
        imageView.setImageDrawable(drawableLoadDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mStopPostionTask$lambda$4(VerticalGridDashboard this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout frameLayout = this$0.mRightLayout;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    /* JADX INFO: compiled from: VerticalGridDashboard.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\f\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0012H\u0016R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/dw/launcher/ui/dashboard/VerticalGridDashboard$MyAdapter;", "Lcom/dw/launcher/ui/view/PageGridView$PagingAdapter;", "Lcom/dw/launcher/ui/dashboard/VerticalGridDashboard$MyVH;", "Lcom/dw/launcher/ui/view/PageGridView$OnItemClickListener;", "data", "", "Lcom/dw/launcher/data/entity/Shortcut;", "(Lcom/dw/launcher/ui/dashboard/VerticalGridDashboard;Ljava/util/List;)V", "mData", "", "getMData", "()Ljava/util/List;", "setMData", "(Ljava/util/List;)V", "getData", "getEmpty", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onItemClick", "pageGridView", "Lcom/dw/launcher/ui/view/PageGridView;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public final class MyAdapter extends PageGridView.PagingAdapter<MyVH> implements PageGridView.OnItemClickListener {
        private List<Shortcut> mData;

        @Override // com.dw.launcher.ui.view.PageGridView.OnItemClickListener
        public void onItemClick(PageGridView pageGridView, int position) {
            Intrinsics.checkNotNullParameter(pageGridView, "pageGridView");
        }

        public MyAdapter(List<Shortcut> list) {
            ArrayList arrayList = new ArrayList();
            this.mData = arrayList;
            Intrinsics.checkNotNull(list);
            arrayList.addAll(list);
        }

        public final List<Shortcut> getMData() {
            return this.mData;
        }

        public final void setMData(List<Shortcut> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.mData = list;
        }

        public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
            View viewInflate;
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (VerticalGridDashboard.this.mItemCount == 2) {
                viewInflate = LayoutInflater.from(VerticalGridDashboard.this.requireContext()).inflate(R.layout.layout_item, parent, false);
                Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            } else {
                viewInflate = LayoutInflater.from(VerticalGridDashboard.this.requireContext()).inflate(R.layout.layout_item_9, parent, false);
                Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            }
            ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
            layoutParams.height = VerticalGridDashboard.this.getHeight();
            layoutParams.width = VerticalGridDashboard.this.getWidth();
            viewInflate.setLayoutParams(layoutParams);
            return new MyVH(viewInflate);
        }

        public int getItemCount() {
            return this.mData.size();
        }

        @Override // com.dw.launcher.ui.view.PageGridView.PagingAdapter
        public List<?> getData() {
            return this.mData;
        }

        @Override // com.dw.launcher.ui.view.PageGridView.PagingAdapter
        public Object getEmpty() {
            return "";
        }

        public void onBindViewHolder(MyVH holder, final int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (position >= this.mData.size()) {
                holder.itemView.setVisibility(8);
                return;
            }
            holder.itemView.setVisibility(0);
            if (TextUtils.isEmpty(this.mData.get(position).getLabel())) {
                holder.getIcon().setVisibility(8);
            } else {
                holder.getIcon().setVisibility(0);
            }
            if (VerticalGridDashboard.this.mItemCount == 2) {
                ViewGroup.LayoutParams layoutParams = holder.getIcon().getLayoutParams();
                Intrinsics.checkNotNullExpressionValue(layoutParams, "getLayoutParams(...)");
                layoutParams.width = VerticalGridDashboard.this.getResources().getDimensionPixelOffset(R.dimen.menu_icon_size_four);
                layoutParams.height = VerticalGridDashboard.this.getResources().getDimensionPixelOffset(R.dimen.menu_icon_size_four);
                holder.getIcon().setLayoutParams(layoutParams);
            }
            holder.getIcon().setImageDrawable(this.mData.get(position).getCustomIcon());
            holder.getTv_title().setText(this.mData.get(position).getLabel());
            TextView tv_title = holder.getTv_title();
            final VerticalGridDashboard verticalGridDashboard = VerticalGridDashboard.this;
            tv_title.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.dashboard.VerticalGridDashboard$MyAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerticalGridDashboard.MyAdapter.onBindViewHolder$lambda$0(this.f$0, position, verticalGridDashboard, view);
                }
            });
            ImageView icon = holder.getIcon();
            final VerticalGridDashboard verticalGridDashboard2 = VerticalGridDashboard.this;
            icon.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.dashboard.VerticalGridDashboard$MyAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerticalGridDashboard.MyAdapter.onBindViewHolder$lambda$1(this.f$0, position, verticalGridDashboard2, view);
                }
            });
            TextView tv_title2 = holder.getTv_title();
            final VerticalGridDashboard verticalGridDashboard3 = VerticalGridDashboard.this;
            tv_title2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.dashboard.VerticalGridDashboard$MyAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return VerticalGridDashboard.MyAdapter.onBindViewHolder$lambda$2(this.f$0, position, verticalGridDashboard3, view);
                }
            });
            ImageView icon2 = holder.getIcon();
            final VerticalGridDashboard verticalGridDashboard4 = VerticalGridDashboard.this;
            icon2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dw.launcher.ui.dashboard.VerticalGridDashboard$MyAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return VerticalGridDashboard.MyAdapter.onBindViewHolder$lambda$3(this.f$0, position, verticalGridDashboard4, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$0(MyAdapter this$0, int i, VerticalGridDashboard this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Shortcut shortcut = this$0.mData.get(i);
            Context contextRequireActivity = this$1.requireActivity();
            Intrinsics.checkNotNullExpressionValue(contextRequireActivity, "requireActivity(...)");
            shortcut.onClicked(contextRequireActivity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$1(MyAdapter this$0, int i, VerticalGridDashboard this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Shortcut shortcut = this$0.mData.get(i);
            Context contextRequireActivity = this$1.requireActivity();
            Intrinsics.checkNotNullExpressionValue(contextRequireActivity, "requireActivity(...)");
            shortcut.onClicked(contextRequireActivity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onBindViewHolder$lambda$2(MyAdapter this$0, int i, VerticalGridDashboard this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Shortcut shortcut = this$0.mData.get(i);
            Context contextRequireActivity = this$1.requireActivity();
            Intrinsics.checkNotNullExpressionValue(contextRequireActivity, "requireActivity(...)");
            shortcut.onLongClicked(contextRequireActivity);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onBindViewHolder$lambda$3(MyAdapter this$0, int i, VerticalGridDashboard this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Shortcut shortcut = this$0.mData.get(i);
            Context contextRequireActivity = this$1.requireActivity();
            Intrinsics.checkNotNullExpressionValue(contextRequireActivity, "requireActivity(...)");
            shortcut.onLongClicked(contextRequireActivity);
            return true;
        }
    }

    /* JADX INFO: compiled from: VerticalGridDashboard.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/dw/launcher/ui/dashboard/VerticalGridDashboard$MyVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "tv_title", "Landroid/widget/TextView;", "getTv_title", "()Landroid/widget/TextView;", "setTv_title", "(Landroid/widget/TextView;)V", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class MyVH extends RecyclerView.ViewHolder {
        private ImageView icon;
        private TextView tv_title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyVH(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R.id.tv_title);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.tv_title = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.icon);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ImageView");
            this.icon = (ImageView) viewFindViewById2;
        }

        public final TextView getTv_title() {
            return this.tv_title;
        }

        public final void setTv_title(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tv_title = textView;
        }

        public final ImageView getIcon() {
            return this.icon;
        }

        public final void setIcon(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.icon = imageView;
        }
    }
}
