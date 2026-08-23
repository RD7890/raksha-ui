package com.dw.launcher.ui.fragment.dashboard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.AppItem;
import com.dw.launcher.data.preference.SharedPreferencesUtils;
import com.dw.launcher.ui.fragment.edit.AddFragment;
import com.dw.launcher.util.AppCardConfig;
import com.google.android.mms.pdu.CharacterSets;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardContainerFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001d\u001a\u00020\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001aH\u0016J\u001a\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/dw/launcher/ui/fragment/dashboard/CardContainerFragment;", "Lcom/dw/launcher/base/BaseFragment;", "()V", "fragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "mViewPager", "Landroidx/viewpager/widget/ViewPager;", "getMViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setMViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "receiver", "Landroid/content/BroadcastReceiver;", "getReceiver", "()Landroid/content/BroadcastReceiver;", "sharedPreferencesUtils", "Lcom/dw/launcher/data/preference/SharedPreferencesUtils;", "getSharedPreferencesUtils", "()Lcom/dw/launcher/data/preference/SharedPreferencesUtils;", "setSharedPreferencesUtils", "(Lcom/dw/launcher/data/preference/SharedPreferencesUtils;)V", "getLayoutId", "", "initViewpager", "", "mView", "Landroid/view/View;", "loadFragmentConfig", "isReload", "", "onDestroy", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class CardContainerFragment extends Hilt_CardContainerFragment {
    public ViewPager mViewPager;

    @Inject
    public SharedPreferencesUtils sharedPreferencesUtils;
    private final ArrayList<Fragment> fragments = CollectionsKt.arrayListOf(new AddFragment());
    private final BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.dw.launcher.ui.fragment.dashboard.CardContainerFragment$receiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(intent.getAction(), AppCardConfig.ACTION_ITEM_CHANGED_BROADCAST)) {
                this.this$0.loadFragmentConfig(true);
            }
        }
    };

    public final SharedPreferencesUtils getSharedPreferencesUtils() {
        SharedPreferencesUtils sharedPreferencesUtils = this.sharedPreferencesUtils;
        if (sharedPreferencesUtils != null) {
            return sharedPreferencesUtils;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferencesUtils");
        return null;
    }

    public final void setSharedPreferencesUtils(SharedPreferencesUtils sharedPreferencesUtils) {
        Intrinsics.checkNotNullParameter(sharedPreferencesUtils, "<set-?>");
        this.sharedPreferencesUtils = sharedPreferencesUtils;
    }

    public final ViewPager getMViewPager() {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            return viewPager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        return null;
    }

    public final void setMViewPager(ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "<set-?>");
        this.mViewPager = viewPager;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViewpager(view);
        requireContext().registerReceiver(this.receiver, new IntentFilter(AppCardConfig.ACTION_ITEM_CHANGED_BROADCAST));
    }

    public final void initViewpager(View mView) {
        Intrinsics.checkNotNullParameter(mView, "mView");
        View viewFindViewById = mView.findViewById(R.id.clock_container_viewpager);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        setMViewPager((ViewPager) viewFindViewById);
        loadFragmentConfig$default(this, false, 1, null);
        getMViewPager().setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) { // from class: com.dw.launcher.ui.fragment.dashboard.CardContainerFragment.initViewpager.1
            public int getItemPosition(Object object) {
                Intrinsics.checkNotNullParameter(object, "object");
                return -2;
            }

            public int getCount() {
                return CardContainerFragment.this.fragments.size();
            }

            public Fragment getItem(int position) {
                Object obj = CardContainerFragment.this.fragments.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }
        });
        getMViewPager().addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.dw.launcher.ui.fragment.dashboard.CardContainerFragment.initViewpager.2
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                Intent intent = new Intent(AppCardConfig.ACTION_ITEM_CURRENT);
                intent.putExtra("position", position);
                CardContainerFragment.this.requireContext().sendBroadcast(intent);
            }
        });
        getMViewPager().setOffscreenPageLimit(10);
    }

    static /* synthetic */ void loadFragmentConfig$default(CardContainerFragment cardContainerFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        cardContainerFragment.loadFragmentConfig(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadFragmentConfig(boolean isReload) {
        Boolean appSelectedItem = getSharedPreferencesUtils().getAppSelectedItem();
        Intrinsics.checkNotNull(appSelectedItem);
        if (appSelectedItem.booleanValue()) {
            this.fragments.clear();
            String appItemListConfig = getSharedPreferencesUtils().getAppItemListConfig();
            if (appItemListConfig != null) {
                List list = (List) new Gson().fromJson(appItemListConfig, new TypeToken<List<? extends AppItem>>() { // from class: com.dw.launcher.ui.fragment.dashboard.CardContainerFragment$loadFragmentConfig$1$list$1
                }.getType());
                ArrayList<Fragment> arrayList = this.fragments;
                Intrinsics.checkNotNull(list);
                arrayList.addAll(AppCardConfig.getAppFragments(list));
            }
            this.fragments.add(new AddFragment());
            PagerAdapter adapter = getMViewPager().getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        if (isReload) {
            getMViewPager().setCurrentItem(this.fragments.size() - 1);
        } else {
            getMViewPager().setCurrentItem(0);
        }
    }

    public int getLayoutId() {
        return R.layout.fragment_clock_container;
    }

    public void onDestroy() {
        super.onDestroy();
        requireContext().unregisterReceiver(this.receiver);
    }

    public final BroadcastReceiver getReceiver() {
        return this.receiver;
    }
}
