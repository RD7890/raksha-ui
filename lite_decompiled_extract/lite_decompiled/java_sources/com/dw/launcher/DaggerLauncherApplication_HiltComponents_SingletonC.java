package com.dw.launcher;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.dw.launcher.activity.ChargeActivity;
import com.dw.launcher.activity.ChargeActivity_MembersInjector;
import com.dw.launcher.activity.NoDisturbActivity;
import com.dw.launcher.activity.NoDisturbActivity_MembersInjector;
import com.dw.launcher.core.component.CompassSensorComponent;
import com.dw.launcher.core.component.DeviceStateComponent;
import com.dw.launcher.core.component.NotificationComponent;
import com.dw.launcher.core.component.PlayCallbackComponent;
import com.dw.launcher.core.component.RingtoneComponent;
import com.dw.launcher.core.component.SensorComponent;
import com.dw.launcher.core.component.SensorComponent_Factory;
import com.dw.launcher.core.component.SensorComponent_MembersInjector;
import com.dw.launcher.core.component.SoundEffect;
import com.dw.launcher.core.component.SoundPoolComponent;
import com.dw.launcher.core.component.VoiceComponent;
import com.dw.launcher.core.notification.NotificationService;
import com.dw.launcher.core.notification.NotificationService_MembersInjector;
import com.dw.launcher.core.receiver.SimCardBroadcastReceiver;
import com.dw.launcher.core.receiver.SimCardBroadcastReceiver_MembersInjector;
import com.dw.launcher.core.service.LauncherWallpaperService;
import com.dw.launcher.core.service.LauncherWallpaperService_MembersInjector;
import com.dw.launcher.core.service.ShortcutService;
import com.dw.launcher.core.service.ShortcutService_MembersInjector;
import com.dw.launcher.core.service.StepBySoProviderService;
import com.dw.launcher.core.service.StepBySoProviderService_MembersInjector;
import com.dw.launcher.core.service.StepSensorService;
import com.dw.launcher.core.service.StepSensorService_MembersInjector;
import com.dw.launcher.data.component.BatteryComponent;
import com.dw.launcher.data.component.BluetoothComponent;
import com.dw.launcher.data.component.BrightComponent;
import com.dw.launcher.data.component.LocaleComponent;
import com.dw.launcher.data.component.NoDisturbComponent;
import com.dw.launcher.data.component.PackageManagerComponent;
import com.dw.launcher.data.component.PhoneStatusComponent;
import com.dw.launcher.data.component.WallpaperComponent;
import com.dw.launcher.data.component.WifiComponent;
import com.dw.launcher.data.database.LauncherDB;
import com.dw.launcher.data.database.dao.ClockConfigDao;
import com.dw.launcher.data.database.dao.StepDataDao;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.BreatheSharedPreferencesUtils;
import com.dw.launcher.data.preference.LauncherPreference;
import com.dw.launcher.data.preference.LauncherPreferenceImpl;
import com.dw.launcher.data.preference.SharedPreferencesUtils;
import com.dw.launcher.data.repository.AssetsClockRepository;
import com.dw.launcher.data.repository.AssetsLaunchRepository;
import com.dw.launcher.data.repository.ClockRepository;
import com.dw.launcher.data.repository.DashboardRepository;
import com.dw.launcher.data.repository.IDashboardRepository;
import com.dw.launcher.data.repository.IRecentTaskRepository;
import com.dw.launcher.data.repository.IShortcutRepository;
import com.dw.launcher.data.repository.LauncherRepository;
import com.dw.launcher.data.repository.RecentTaskRepository;
import com.dw.launcher.data.repository.ShortcutRepository;
import com.dw.launcher.data.repository.WatchConfigRepository;
import com.dw.launcher.data.repository.WatchLaunchRepositoryImpl;
import com.dw.launcher.hilt.provider.ContextProvider;
import com.dw.launcher.hilt.provider.ContextProvider_GetSystemKeyFactory;
import com.dw.launcher.hilt.provider.ContextProvider_ProvideBatteryComponentFactory;
import com.dw.launcher.hilt.provider.ContextProvider_ProvideClockConfigDaoFactory;
import com.dw.launcher.hilt.provider.ContextProvider_ProvideClockRegisterFactory;
import com.dw.launcher.hilt.provider.ContextProvider_ProvideContextFactory;
import com.dw.launcher.hilt.provider.ContextProvider_ProvideDeviceStateComponentFactory;
import com.dw.launcher.hilt.provider.ContextProvider_ProvideLauncherDBFactory;
import com.dw.launcher.hilt.provider.ContextProvider_ProvideLocaleComponentFactory;
import com.dw.launcher.hilt.provider.ContextProvider_ProvideNoDisturbComponentFactory;
import com.dw.launcher.hilt.provider.ContextProvider_ProvideNotificationComponentFactory;
import com.dw.launcher.hilt.provider.ContextProvider_ProvidePhoneStatusComponentFactory;
import com.dw.launcher.hilt.provider.ContextProvider_ProvideSharedPreferencesUtilsFactory;
import com.dw.launcher.hilt.provider.ContextProvider_ProvideShortcutInflaterFactory;
import com.dw.launcher.hilt.provider.ContextProvider_ProvideStepDaoFactory;
import com.dw.launcher.hilt.provider.ContextProvider_ProvideVoiceComponentFactory;
import com.dw.launcher.hilt.provider.ContextProvider_ProvideWallpaperComponentFactory;
import com.dw.launcher.hilt.provider.UtilProvider;
import com.dw.launcher.tts.BootCompleteReceiver;
import com.dw.launcher.tts.BootCompleteReceiver_MembersInjector;
import com.dw.launcher.tts.PhoneReceiver;
import com.dw.launcher.tts.PhoneReceiver_MembersInjector;
import com.dw.launcher.tts.SmsReceiver;
import com.dw.launcher.tts.SmsReceiver_MembersInjector;
import com.dw.launcher.tts.UsbReceiver;
import com.dw.launcher.tts.UsbReceiver_MembersInjector;
import com.dw.launcher.ui.activity.AddMenuShortcutActivity;
import com.dw.launcher.ui.activity.AddMenuShortcutActivity_MembersInjector;
import com.dw.launcher.ui.activity.BreatheActivity;
import com.dw.launcher.ui.activity.BreatheActivity_MembersInjector;
import com.dw.launcher.ui.activity.BreatheSettingActivity;
import com.dw.launcher.ui.activity.BreatheSettingActivity_MembersInjector;
import com.dw.launcher.ui.activity.BreatheValueSettingActivity;
import com.dw.launcher.ui.activity.BreatheValueSettingActivity_MembersInjector;
import com.dw.launcher.ui.activity.ComponentManagerActivity;
import com.dw.launcher.ui.activity.ComponentManagerActivity_MembersInjector;
import com.dw.launcher.ui.activity.CustomWallPaperActivity;
import com.dw.launcher.ui.activity.CustomWallPaperActivity_MembersInjector;
import com.dw.launcher.ui.activity.CustomWatchActivity;
import com.dw.launcher.ui.activity.CustomWatchActivity_MembersInjector;
import com.dw.launcher.ui.activity.LowBatteryActivity;
import com.dw.launcher.ui.activity.LowBatteryActivity_MembersInjector;
import com.dw.launcher.ui.activity.PickClockActivity;
import com.dw.launcher.ui.activity.PickClockActivity_MembersInjector;
import com.dw.launcher.ui.activity.PickDashboardActivity;
import com.dw.launcher.ui.activity.PickDashboardActivity_MembersInjector;
import com.dw.launcher.ui.activity.SetThemeActivity;
import com.dw.launcher.ui.activity.SetThemeActivity_MembersInjector;
import com.dw.launcher.ui.activity.SetWallpaperActivity;
import com.dw.launcher.ui.activity.SetWallpaperActivity_MembersInjector;
import com.dw.launcher.ui.activity.ShutdownActivity;
import com.dw.launcher.ui.activity.ShutdownActivity_MembersInjector;
import com.dw.launcher.ui.activity.SleepClockActivity;
import com.dw.launcher.ui.activity.SleepClockActivity_MembersInjector;
import com.dw.launcher.ui.clock.ClockRegister;
import com.dw.launcher.ui.dashboard.BaseDashboard;
import com.dw.launcher.ui.dashboard.BaseDashboard_MembersInjector;
import com.dw.launcher.ui.dashboard.BubbleDashboard;
import com.dw.launcher.ui.dashboard.BubbleDashboard_MembersInjector;
import com.dw.launcher.ui.dashboard.CyclicDashboard;
import com.dw.launcher.ui.dashboard.CyclicDashboard_MembersInjector;
import com.dw.launcher.ui.dashboard.DashboardViewModel;
import com.dw.launcher.ui.dashboard.DashboardViewModel_HiltModules;
import com.dw.launcher.ui.dashboard.FiveCyclicDashboard;
import com.dw.launcher.ui.dashboard.FiveCyclicDashboard_MembersInjector;
import com.dw.launcher.ui.dashboard.GridDashboard;
import com.dw.launcher.ui.dashboard.GridDashboard_MembersInjector;
import com.dw.launcher.ui.dashboard.HalfCyclicDashboard;
import com.dw.launcher.ui.dashboard.HalfCyclicDashboard_MembersInjector;
import com.dw.launcher.ui.dashboard.HoneycombDashboard;
import com.dw.launcher.ui.dashboard.HoneycombDashboard_MembersInjector;
import com.dw.launcher.ui.dashboard.LinearDashboard;
import com.dw.launcher.ui.dashboard.LinearDashboard_MembersInjector;
import com.dw.launcher.ui.dashboard.VerticalGridDashboard;
import com.dw.launcher.ui.dashboard.VerticalGridDashboardNoTitle;
import com.dw.launcher.ui.dashboard.VerticalGridDashboardNoTitle_MembersInjector;
import com.dw.launcher.ui.dashboard.VerticalGridDashboard_MembersInjector;
import com.dw.launcher.ui.fragment.bottom.BottomFragment;
import com.dw.launcher.ui.fragment.bottom.BottomFragment_MembersInjector;
import com.dw.launcher.ui.fragment.breathe.BreatheFragment;
import com.dw.launcher.ui.fragment.clock.ClockContainerFragment;
import com.dw.launcher.ui.fragment.clock.ClockContainerFragment_MembersInjector;
import com.dw.launcher.ui.fragment.clock.ClockViewModel;
import com.dw.launcher.ui.fragment.clock.ClockViewModel_HiltModules;
import com.dw.launcher.ui.fragment.clock.DialFragment;
import com.dw.launcher.ui.fragment.clock.DialFragment_MembersInjector;
import com.dw.launcher.ui.fragment.dashboard.CardContainerFragment;
import com.dw.launcher.ui.fragment.dashboard.CardContainerFragment_MembersInjector;
import com.dw.launcher.ui.fragment.dashboard.DashboardContainerActivity;
import com.dw.launcher.ui.fragment.dashboard.DashboardContainerActivity_MembersInjector;
import com.dw.launcher.ui.fragment.dashboard.DashboardContainerFragment;
import com.dw.launcher.ui.fragment.dashboard.DashboardContainerFragment_MembersInjector;
import com.dw.launcher.ui.fragment.heart.HeartFragment;
import com.dw.launcher.ui.fragment.launcher.LauncherCardFragment;
import com.dw.launcher.ui.fragment.launcher.LauncherCardFragment_MembersInjector;
import com.dw.launcher.ui.fragment.launcher.LauncherFragment;
import com.dw.launcher.ui.fragment.launcher.LauncherFragment_MembersInjector;
import com.dw.launcher.ui.fragment.menu.MenuFragment;
import com.dw.launcher.ui.fragment.menu.MenuFragment_MembersInjector;
import com.dw.launcher.ui.fragment.menu.MenuViewModel;
import com.dw.launcher.ui.fragment.menu.MenuViewModel_HiltModules;
import com.dw.launcher.ui.fragment.music.MusicControlFragment;
import com.dw.launcher.ui.fragment.music.MusicControlFragment_MembersInjector;
import com.dw.launcher.ui.fragment.sleep.SleepFragment;
import com.dw.launcher.ui.fragment.sleep.SleepFragment_MembersInjector;
import com.dw.launcher.ui.fragment.sport.SportFragment;
import com.dw.launcher.ui.fragment.step.StepFragment;
import com.dw.launcher.ui.fragment.step.StepFragment_MembersInjector;
import com.dw.launcher.ui.fragment.top.TopRoundFragment;
import com.dw.launcher.ui.fragment.top.TopRoundFragment_MembersInjector;
import com.dw.launcher.ui.fragment.top.TopSwitchFragment;
import com.dw.launcher.ui.fragment.top.TopSwitchFragment_MembersInjector;
import com.dw.launcher.ui.shortcut.LockSwitchShortcut;
import com.dw.launcher.ui.shortcut.LockSwitchShortcut_Factory;
import com.dw.launcher.ui.shortcut.LockSwitchShortcut_MembersInjector;
import com.dw.launcher.ui.shortcut.ShortcutInflater;
import com.dw.launcher.ui.view.BatteryView;
import com.dw.launcher.ui.view.BatteryView_MembersInjector;
import com.dw.launcher.ui.view.BluetoothView;
import com.dw.launcher.ui.view.BluetoothView_MembersInjector;
import com.dw.launcher.ui.view.BrightView;
import com.dw.launcher.ui.view.BrightView_MembersInjector;
import com.dw.launcher.ui.view.DialNotificationView;
import com.dw.launcher.ui.view.DialNotificationView_MembersInjector;
import com.dw.launcher.ui.view.NetworkView;
import com.dw.launcher.ui.view.NetworkView_MembersInjector;
import com.dw.launcher.ui.view.SignalClusterLayout;
import com.dw.launcher.ui.view.SignalClusterLayout_MembersInjector;
import com.dw.launcher.ui.view.SignalStrengthView;
import com.dw.launcher.ui.view.SignalStrengthView_MembersInjector;
import com.dw.launcher.ui.viewmodel.BPressureViewModel;
import com.dw.launcher.ui.viewmodel.BPressureViewModel_HiltModules;
import com.dw.launcher.ui.viewmodel.StepViewModel;
import com.dw.launcher.ui.viewmodel.StepViewModel_HiltModules;
import com.dw.launcher.ui.viewmodel.ThemeViewModel;
import com.dw.launcher.ui.viewmodel.ThemeViewModel_Factory;
import com.dw.launcher.ui.viewmodel.ThemeViewModel_HiltModules;
import com.dw.launcher.ui.viewmodel.ThemeViewModel_MembersInjector;
import com.dw.launcher.ui.viewmodel.WallpaperViewModel;
import com.dw.launcher.ui.viewmodel.WallpaperViewModel_Factory;
import com.dw.launcher.ui.viewmodel.WallpaperViewModel_HiltModules;
import com.dw.launcher.ui.viewmodel.WallpaperViewModel_MembersInjector;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class DaggerLauncherApplication_HiltComponents_SingletonC {
    private DaggerLauncherApplication_HiltComponents_SingletonC() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private ApplicationContextModule applicationContextModule;
        private ContextProvider contextProvider;

        private Builder() {
        }

        public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
            this.applicationContextModule = (ApplicationContextModule) Preconditions.checkNotNull(applicationContextModule);
            return this;
        }

        public Builder contextProvider(ContextProvider contextProvider) {
            this.contextProvider = (ContextProvider) Preconditions.checkNotNull(contextProvider);
            return this;
        }

        @Deprecated
        public Builder utilProvider(UtilProvider utilProvider) {
            Preconditions.checkNotNull(utilProvider);
            return this;
        }

        public LauncherApplication_HiltComponents.SingletonC build() {
            Preconditions.checkBuilderRequirement(this.applicationContextModule, ApplicationContextModule.class);
            if (this.contextProvider == null) {
                this.contextProvider = new ContextProvider();
            }
            return new SingletonCImpl(this.applicationContextModule, this.contextProvider);
        }
    }

    private static final class ActivityRetainedCBuilder implements LauncherApplication_HiltComponents.ActivityRetainedC.Builder {
        private SavedStateHandleHolder savedStateHandleHolder;
        private final SingletonCImpl singletonCImpl;

        private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
            this.singletonCImpl = singletonCImpl;
        }

        /* JADX INFO: renamed from: savedStateHandleHolder, reason: merged with bridge method [inline-methods] */
        public ActivityRetainedCBuilder m169savedStateHandleHolder(SavedStateHandleHolder savedStateHandleHolder) {
            this.savedStateHandleHolder = (SavedStateHandleHolder) Preconditions.checkNotNull(savedStateHandleHolder);
            return this;
        }

        /* JADX INFO: renamed from: build, reason: merged with bridge method [inline-methods] */
        public LauncherApplication_HiltComponents.ActivityRetainedC m168build() {
            Preconditions.checkBuilderRequirement(this.savedStateHandleHolder, SavedStateHandleHolder.class);
            return new ActivityRetainedCImpl(this.singletonCImpl, this.savedStateHandleHolder);
        }
    }

    private static final class ActivityCBuilder implements LauncherApplication_HiltComponents.ActivityC.Builder {
        private Activity activity;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;

        private ActivityCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
        }

        /* JADX INFO: renamed from: activity, reason: merged with bridge method [inline-methods] */
        public ActivityCBuilder m166activity(Activity activity) {
            this.activity = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        /* JADX INFO: renamed from: build, reason: merged with bridge method [inline-methods] */
        public LauncherApplication_HiltComponents.ActivityC m167build() {
            Preconditions.checkBuilderRequirement(this.activity, Activity.class);
            return new ActivityCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activity);
        }
    }

    private static final class FragmentCBuilder implements LauncherApplication_HiltComponents.FragmentC.Builder {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Fragment fragment;
        private final SingletonCImpl singletonCImpl;

        private FragmentCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
        }

        /* JADX INFO: renamed from: fragment, reason: merged with bridge method [inline-methods] */
        public FragmentCBuilder m171fragment(Fragment fragment) {
            this.fragment = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        /* JADX INFO: renamed from: build, reason: merged with bridge method [inline-methods] */
        public LauncherApplication_HiltComponents.FragmentC m170build() {
            Preconditions.checkBuilderRequirement(this.fragment, Fragment.class);
            return new FragmentCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.fragment);
        }
    }

    private static final class ViewWithFragmentCBuilder implements LauncherApplication_HiltComponents.ViewWithFragmentC.Builder {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl;
        private final SingletonCImpl singletonCImpl;
        private View view;

        private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, FragmentCImpl fragmentCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
            this.fragmentCImpl = fragmentCImpl;
        }

        /* JADX INFO: renamed from: view, reason: merged with bridge method [inline-methods] */
        public ViewWithFragmentCBuilder m180view(View view) {
            this.view = (View) Preconditions.checkNotNull(view);
            return this;
        }

        /* JADX INFO: renamed from: build, reason: merged with bridge method [inline-methods] */
        public LauncherApplication_HiltComponents.ViewWithFragmentC m179build() {
            Preconditions.checkBuilderRequirement(this.view, View.class);
            return new ViewWithFragmentCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.fragmentCImpl, this.view);
        }
    }

    private static final class ViewCBuilder implements LauncherApplication_HiltComponents.ViewC.Builder {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;
        private View view;

        private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
        }

        /* JADX INFO: renamed from: view, reason: merged with bridge method [inline-methods] */
        public ViewCBuilder m175view(View view) {
            this.view = (View) Preconditions.checkNotNull(view);
            return this;
        }

        /* JADX INFO: renamed from: build, reason: merged with bridge method [inline-methods] */
        public LauncherApplication_HiltComponents.ViewC m174build() {
            Preconditions.checkBuilderRequirement(this.view, View.class);
            return new ViewCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.view);
        }
    }

    private static final class ViewModelCBuilder implements LauncherApplication_HiltComponents.ViewModelC.Builder {
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private SavedStateHandle savedStateHandle;
        private final SingletonCImpl singletonCImpl;
        private ViewModelLifecycle viewModelLifecycle;

        private ViewModelCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
        }

        /* JADX INFO: renamed from: savedStateHandle, reason: merged with bridge method [inline-methods] */
        public ViewModelCBuilder m177savedStateHandle(SavedStateHandle handle) {
            this.savedStateHandle = (SavedStateHandle) Preconditions.checkNotNull(handle);
            return this;
        }

        /* JADX INFO: renamed from: viewModelLifecycle, reason: merged with bridge method [inline-methods] */
        public ViewModelCBuilder m178viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
            this.viewModelLifecycle = (ViewModelLifecycle) Preconditions.checkNotNull(viewModelLifecycle);
            return this;
        }

        /* JADX INFO: renamed from: build, reason: merged with bridge method [inline-methods] */
        public LauncherApplication_HiltComponents.ViewModelC m176build() {
            Preconditions.checkBuilderRequirement(this.savedStateHandle, SavedStateHandle.class);
            Preconditions.checkBuilderRequirement(this.viewModelLifecycle, ViewModelLifecycle.class);
            return new ViewModelCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.savedStateHandle, this.viewModelLifecycle);
        }
    }

    private static final class ServiceCBuilder implements LauncherApplication_HiltComponents.ServiceC.Builder {
        private Service service;
        private final SingletonCImpl singletonCImpl;

        private ServiceCBuilder(SingletonCImpl singletonCImpl) {
            this.singletonCImpl = singletonCImpl;
        }

        /* JADX INFO: renamed from: service, reason: merged with bridge method [inline-methods] */
        public ServiceCBuilder m173service(Service service) {
            this.service = (Service) Preconditions.checkNotNull(service);
            return this;
        }

        /* JADX INFO: renamed from: build, reason: merged with bridge method [inline-methods] */
        public LauncherApplication_HiltComponents.ServiceC m172build() {
            Preconditions.checkBuilderRequirement(this.service, Service.class);
            return new ServiceCImpl(this.singletonCImpl, this.service);
        }
    }

    private static final class ViewWithFragmentCImpl extends LauncherApplication_HiltComponents.ViewWithFragmentC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl;
        private final SingletonCImpl singletonCImpl;
        private final ViewWithFragmentCImpl viewWithFragmentCImpl;

        private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, FragmentCImpl fragmentCImpl, View viewParam) {
            this.viewWithFragmentCImpl = this;
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
            this.fragmentCImpl = fragmentCImpl;
        }
    }

    private static final class FragmentCImpl extends LauncherApplication_HiltComponents.FragmentC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl;
        private final SingletonCImpl singletonCImpl;

        public void injectBreatheFragment(BreatheFragment breatheFragment) {
        }

        public void injectHeartFragment(HeartFragment heartFragment) {
        }

        public void injectSportFragment(SportFragment sportFragment) {
        }

        private FragmentCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, Fragment fragmentParam) {
            this.fragmentCImpl = this;
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
        }

        private CompassSensorComponent compassSensorComponent() {
            return new CompassSensorComponent((Context) this.singletonCImpl.provideContextProvider.get(), (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
        }

        private AssetsClockRepository assetsClockRepository() {
            return new AssetsClockRepository((Context) this.singletonCImpl.provideContextProvider.get(), (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get(), (WatchConfigRepository) this.singletonCImpl.bindWatchRepositoryProvider.get(), (ClockConfigDao) this.singletonCImpl.provideClockConfigDaoProvider.get());
        }

        private PlayCallbackComponent playCallbackComponent() {
            return new PlayCallbackComponent((Context) this.singletonCImpl.provideContextProvider.get());
        }

        private BluetoothComponent bluetoothComponent() {
            return new BluetoothComponent((Context) this.singletonCImpl.provideContextProvider.get());
        }

        private BrightComponent brightComponent() {
            return new BrightComponent((Context) this.singletonCImpl.provideContextProvider.get());
        }

        private LockSwitchShortcut lockSwitchShortcut() {
            return injectLockSwitchShortcut(LockSwitchShortcut_Factory.newInstance());
        }

        public void injectBaseDashboard(BaseDashboard baseDashboard) {
            injectBaseDashboard2(baseDashboard);
        }

        public void injectBubbleDashboard(BubbleDashboard bubbleDashboard) {
            injectBubbleDashboard2(bubbleDashboard);
        }

        public void injectCyclicDashboard(CyclicDashboard cyclicDashboard) {
            injectCyclicDashboard2(cyclicDashboard);
        }

        public void injectFiveCyclicDashboard(FiveCyclicDashboard fiveCyclicDashboard) {
            injectFiveCyclicDashboard2(fiveCyclicDashboard);
        }

        public void injectGridDashboard(GridDashboard gridDashboard) {
            injectGridDashboard2(gridDashboard);
        }

        public void injectHalfCyclicDashboard(HalfCyclicDashboard halfCyclicDashboard) {
            injectHalfCyclicDashboard2(halfCyclicDashboard);
        }

        public void injectHoneycombDashboard(HoneycombDashboard honeycombDashboard) {
            injectHoneycombDashboard2(honeycombDashboard);
        }

        public void injectLinearDashboard(LinearDashboard linearDashboard) {
            injectLinearDashboard2(linearDashboard);
        }

        public void injectVerticalGridDashboardNoTitle(VerticalGridDashboardNoTitle verticalGridDashboardNoTitle) {
            injectVerticalGridDashboardNoTitle2(verticalGridDashboardNoTitle);
        }

        public void injectVerticalGridDashboard(VerticalGridDashboard verticalGridDashboard) {
            injectVerticalGridDashboard2(verticalGridDashboard);
        }

        public void injectBottomFragment(BottomFragment bottomFragment) {
            injectBottomFragment2(bottomFragment);
        }

        public void injectClockContainerFragment(ClockContainerFragment clockContainerFragment) {
            injectClockContainerFragment2(clockContainerFragment);
        }

        public void injectDialFragment(DialFragment dialFragment) {
            injectDialFragment2(dialFragment);
        }

        public void injectCardContainerFragment(CardContainerFragment cardContainerFragment) {
            injectCardContainerFragment2(cardContainerFragment);
        }

        public void injectDashboardContainerFragment(DashboardContainerFragment dashboardContainerFragment) {
            injectDashboardContainerFragment2(dashboardContainerFragment);
        }

        public void injectLauncherCardFragment(LauncherCardFragment launcherCardFragment) {
            injectLauncherCardFragment2(launcherCardFragment);
        }

        public void injectLauncherFragment(LauncherFragment launcherFragment) {
            injectLauncherFragment2(launcherFragment);
        }

        public void injectMenuFragment(MenuFragment menuFragment) {
            injectMenuFragment2(menuFragment);
        }

        public void injectMusicControlFragment(MusicControlFragment musicControlFragment) {
            injectMusicControlFragment2(musicControlFragment);
        }

        public void injectSleepFragment(SleepFragment sleepFragment) {
            injectSleepFragment2(sleepFragment);
        }

        public void injectStepFragment(StepFragment stepFragment) {
            injectStepFragment2(stepFragment);
        }

        public void injectTopRoundFragment(TopRoundFragment topRoundFragment) {
            injectTopRoundFragment2(topRoundFragment);
        }

        public void injectTopSwitchFragment(TopSwitchFragment topSwitchFragment) {
            injectTopSwitchFragment2(topSwitchFragment);
        }

        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
            return this.activityCImpl.getHiltInternalFactoryFactory();
        }

        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
            return new ViewWithFragmentCBuilder(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.fragmentCImpl);
        }

        private BaseDashboard injectBaseDashboard2(BaseDashboard instance) {
            BaseDashboard_MembersInjector.injectMSensorComponent(instance, this.activityCImpl.sensorComponent());
            BaseDashboard_MembersInjector.injectSoundEffect(instance, (SoundEffect) this.singletonCImpl.provideSoundEffectProvider.get());
            BaseDashboard_MembersInjector.injectWallpaperComponent(instance, (WallpaperComponent) this.singletonCImpl.provideWallpaperComponentProvider.get());
            BaseDashboard_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            BaseDashboard_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            return instance;
        }

        private BubbleDashboard injectBubbleDashboard2(BubbleDashboard instance) {
            BaseDashboard_MembersInjector.injectMSensorComponent(instance, this.activityCImpl.sensorComponent());
            BaseDashboard_MembersInjector.injectSoundEffect(instance, (SoundEffect) this.singletonCImpl.provideSoundEffectProvider.get());
            BaseDashboard_MembersInjector.injectWallpaperComponent(instance, (WallpaperComponent) this.singletonCImpl.provideWallpaperComponentProvider.get());
            BaseDashboard_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            BaseDashboard_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            BubbleDashboard_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            BubbleDashboard_MembersInjector.injectAssetsLaunchRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            BubbleDashboard_MembersInjector.injectLauncherRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            return instance;
        }

        private CyclicDashboard injectCyclicDashboard2(CyclicDashboard instance) {
            BaseDashboard_MembersInjector.injectMSensorComponent(instance, this.activityCImpl.sensorComponent());
            BaseDashboard_MembersInjector.injectSoundEffect(instance, (SoundEffect) this.singletonCImpl.provideSoundEffectProvider.get());
            BaseDashboard_MembersInjector.injectWallpaperComponent(instance, (WallpaperComponent) this.singletonCImpl.provideWallpaperComponentProvider.get());
            BaseDashboard_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            BaseDashboard_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            CyclicDashboard_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            return instance;
        }

        private FiveCyclicDashboard injectFiveCyclicDashboard2(FiveCyclicDashboard instance) {
            BaseDashboard_MembersInjector.injectMSensorComponent(instance, this.activityCImpl.sensorComponent());
            BaseDashboard_MembersInjector.injectSoundEffect(instance, (SoundEffect) this.singletonCImpl.provideSoundEffectProvider.get());
            BaseDashboard_MembersInjector.injectWallpaperComponent(instance, (WallpaperComponent) this.singletonCImpl.provideWallpaperComponentProvider.get());
            BaseDashboard_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            BaseDashboard_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            FiveCyclicDashboard_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            return instance;
        }

        private GridDashboard injectGridDashboard2(GridDashboard instance) {
            BaseDashboard_MembersInjector.injectMSensorComponent(instance, this.activityCImpl.sensorComponent());
            BaseDashboard_MembersInjector.injectSoundEffect(instance, (SoundEffect) this.singletonCImpl.provideSoundEffectProvider.get());
            BaseDashboard_MembersInjector.injectWallpaperComponent(instance, (WallpaperComponent) this.singletonCImpl.provideWallpaperComponentProvider.get());
            BaseDashboard_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            BaseDashboard_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            GridDashboard_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            return instance;
        }

        private HalfCyclicDashboard injectHalfCyclicDashboard2(HalfCyclicDashboard instance) {
            BaseDashboard_MembersInjector.injectMSensorComponent(instance, this.activityCImpl.sensorComponent());
            BaseDashboard_MembersInjector.injectSoundEffect(instance, (SoundEffect) this.singletonCImpl.provideSoundEffectProvider.get());
            BaseDashboard_MembersInjector.injectWallpaperComponent(instance, (WallpaperComponent) this.singletonCImpl.provideWallpaperComponentProvider.get());
            BaseDashboard_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            BaseDashboard_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            HalfCyclicDashboard_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            HalfCyclicDashboard_MembersInjector.injectLauncherRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            return instance;
        }

        private HoneycombDashboard injectHoneycombDashboard2(HoneycombDashboard instance) {
            BaseDashboard_MembersInjector.injectMSensorComponent(instance, this.activityCImpl.sensorComponent());
            BaseDashboard_MembersInjector.injectSoundEffect(instance, (SoundEffect) this.singletonCImpl.provideSoundEffectProvider.get());
            BaseDashboard_MembersInjector.injectWallpaperComponent(instance, (WallpaperComponent) this.singletonCImpl.provideWallpaperComponentProvider.get());
            BaseDashboard_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            BaseDashboard_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            HoneycombDashboard_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            HoneycombDashboard_MembersInjector.injectLauncherRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            return instance;
        }

        private LinearDashboard injectLinearDashboard2(LinearDashboard instance) {
            BaseDashboard_MembersInjector.injectMSensorComponent(instance, this.activityCImpl.sensorComponent());
            BaseDashboard_MembersInjector.injectSoundEffect(instance, (SoundEffect) this.singletonCImpl.provideSoundEffectProvider.get());
            BaseDashboard_MembersInjector.injectWallpaperComponent(instance, (WallpaperComponent) this.singletonCImpl.provideWallpaperComponentProvider.get());
            BaseDashboard_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            BaseDashboard_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            LinearDashboard_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            LinearDashboard_MembersInjector.injectLauncherRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            return instance;
        }

        private VerticalGridDashboardNoTitle injectVerticalGridDashboardNoTitle2(VerticalGridDashboardNoTitle instance) {
            BaseDashboard_MembersInjector.injectMSensorComponent(instance, this.activityCImpl.sensorComponent());
            BaseDashboard_MembersInjector.injectSoundEffect(instance, (SoundEffect) this.singletonCImpl.provideSoundEffectProvider.get());
            BaseDashboard_MembersInjector.injectWallpaperComponent(instance, (WallpaperComponent) this.singletonCImpl.provideWallpaperComponentProvider.get());
            BaseDashboard_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            BaseDashboard_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            VerticalGridDashboardNoTitle_MembersInjector.injectLauncherRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            VerticalGridDashboardNoTitle_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            return instance;
        }

        private VerticalGridDashboard injectVerticalGridDashboard2(VerticalGridDashboard instance) {
            BaseDashboard_MembersInjector.injectMSensorComponent(instance, this.activityCImpl.sensorComponent());
            BaseDashboard_MembersInjector.injectSoundEffect(instance, (SoundEffect) this.singletonCImpl.provideSoundEffectProvider.get());
            BaseDashboard_MembersInjector.injectWallpaperComponent(instance, (WallpaperComponent) this.singletonCImpl.provideWallpaperComponentProvider.get());
            BaseDashboard_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            BaseDashboard_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            VerticalGridDashboard_MembersInjector.injectLauncherRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            VerticalGridDashboard_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            return instance;
        }

        private BottomFragment injectBottomFragment2(BottomFragment instance) {
            BottomFragment_MembersInjector.injectMNotificationComponent(instance, (NotificationComponent) this.singletonCImpl.provideNotificationComponentProvider.get());
            return instance;
        }

        private ClockContainerFragment injectClockContainerFragment2(ClockContainerFragment instance) {
            ClockContainerFragment_MembersInjector.injectMClockRegister(instance, (ClockRegister) this.singletonCImpl.provideClockRegisterProvider.get());
            ClockContainerFragment_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            ClockContainerFragment_MembersInjector.injectMSensorComponent(instance, this.activityCImpl.sensorComponent());
            ClockContainerFragment_MembersInjector.injectMCompassSensorComponent(instance, compassSensorComponent());
            ClockContainerFragment_MembersInjector.injectMRingtoneComponent(instance, (SoundEffect) this.singletonCImpl.provideRingtoneComponentProvider.get());
            ClockContainerFragment_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            ClockContainerFragment_MembersInjector.injectAssetsClockRepository(instance, assetsClockRepository());
            ClockContainerFragment_MembersInjector.injectAssertLauncherRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            return instance;
        }

        private DialFragment injectDialFragment2(DialFragment instance) {
            DialFragment_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            DialFragment_MembersInjector.injectMSensorComponent(instance, this.activityCImpl.sensorComponent());
            DialFragment_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            DialFragment_MembersInjector.injectLaunchRepository(instance, (WatchConfigRepository) this.singletonCImpl.bindWatchRepositoryProvider.get());
            DialFragment_MembersInjector.injectAssertLauncherRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            DialFragment_MembersInjector.injectMCompassSensorComponent(instance, compassSensorComponent());
            DialFragment_MembersInjector.injectClockConfigDao(instance, (ClockConfigDao) this.singletonCImpl.provideClockConfigDaoProvider.get());
            DialFragment_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            return instance;
        }

        private CardContainerFragment injectCardContainerFragment2(CardContainerFragment instance) {
            CardContainerFragment_MembersInjector.injectSharedPreferencesUtils(instance, (SharedPreferencesUtils) this.singletonCImpl.provideSharedPreferencesUtilsProvider.get());
            return instance;
        }

        private DashboardContainerFragment injectDashboardContainerFragment2(DashboardContainerFragment instance) {
            DashboardContainerFragment_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            DashboardContainerFragment_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            DashboardContainerFragment_MembersInjector.injectMAssetsLaunchRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            return instance;
        }

        private LauncherCardFragment injectLauncherCardFragment2(LauncherCardFragment instance) {
            LauncherCardFragment_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            LauncherCardFragment_MembersInjector.injectLauncherRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            LauncherCardFragment_MembersInjector.injectRecentTaskRepository(instance, (IRecentTaskRepository) this.singletonCImpl.bindRecentTaskRepositoryProvider.get());
            LauncherCardFragment_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            LauncherCardFragment_MembersInjector.injectPhoneStatusComponent(instance, (PhoneStatusComponent) this.singletonCImpl.providePhoneStatusComponentProvider.get());
            LauncherCardFragment_MembersInjector.injectSharedPreferencesUtils(instance, (SharedPreferencesUtils) this.singletonCImpl.provideSharedPreferencesUtilsProvider.get());
            return instance;
        }

        private LauncherFragment injectLauncherFragment2(LauncherFragment instance) {
            LauncherFragment_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            LauncherFragment_MembersInjector.injectLauncherRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            LauncherFragment_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            LauncherFragment_MembersInjector.injectPhoneStatusComponent(instance, (PhoneStatusComponent) this.singletonCImpl.providePhoneStatusComponentProvider.get());
            LauncherFragment_MembersInjector.injectRecentTaskRepository(instance, (IRecentTaskRepository) this.singletonCImpl.bindRecentTaskRepositoryProvider.get());
            return instance;
        }

        private MenuFragment injectMenuFragment2(MenuFragment instance) {
            MenuFragment_MembersInjector.injectLauncherRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            return instance;
        }

        private MusicControlFragment injectMusicControlFragment2(MusicControlFragment instance) {
            MusicControlFragment_MembersInjector.injectMPlayCallbackComponent(instance, playCallbackComponent());
            return instance;
        }

        private SleepFragment injectSleepFragment2(SleepFragment instance) {
            SleepFragment_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            SleepFragment_MembersInjector.injectSharedPreferences(instance, (SharedPreferencesUtils) this.singletonCImpl.provideSharedPreferencesUtilsProvider.get());
            return instance;
        }

        private StepFragment injectStepFragment2(StepFragment instance) {
            StepFragment_MembersInjector.injectStepDataDao(instance, (StepDataDao) this.singletonCImpl.provideStepDaoProvider.get());
            return instance;
        }

        private TopRoundFragment injectTopRoundFragment2(TopRoundFragment instance) {
            TopRoundFragment_MembersInjector.injectWifiComponent(instance, this.singletonCImpl.wifiComponent());
            TopRoundFragment_MembersInjector.injectBluetoothComponent(instance, bluetoothComponent());
            TopRoundFragment_MembersInjector.injectMBrightComponent(instance, brightComponent());
            TopRoundFragment_MembersInjector.injectMWifiComponent(instance, this.singletonCImpl.wifiComponent());
            TopRoundFragment_MembersInjector.injectLauncherRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            TopRoundFragment_MembersInjector.injectMVoiceComponent(instance, (VoiceComponent) this.singletonCImpl.provideVoiceComponentProvider.get());
            return instance;
        }

        private LockSwitchShortcut injectLockSwitchShortcut(LockSwitchShortcut instance) {
            LockSwitchShortcut_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            return instance;
        }

        private TopSwitchFragment injectTopSwitchFragment2(TopSwitchFragment instance) {
            TopSwitchFragment_MembersInjector.injectMLockSwitchShortcut(instance, lockSwitchShortcut());
            return instance;
        }
    }

    private static final class ViewCImpl extends LauncherApplication_HiltComponents.ViewC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;
        private final ViewCImpl viewCImpl;

        private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, View viewParam) {
            this.viewCImpl = this;
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
        }

        private BluetoothComponent bluetoothComponent() {
            return new BluetoothComponent((Context) this.singletonCImpl.provideContextProvider.get());
        }

        private BrightComponent brightComponent() {
            return new BrightComponent((Context) this.singletonCImpl.provideContextProvider.get());
        }

        public void injectBatteryView(BatteryView batteryView) {
            injectBatteryView2(batteryView);
        }

        public void injectBluetoothView(BluetoothView bluetoothView) {
            injectBluetoothView2(bluetoothView);
        }

        public void injectBrightView(BrightView brightView) {
            injectBrightView2(brightView);
        }

        public void injectDialNotificationView(DialNotificationView dialNotificationView) {
            injectDialNotificationView2(dialNotificationView);
        }

        public void injectNetworkView(NetworkView networkView) {
            injectNetworkView2(networkView);
        }

        public void injectSignalClusterLayout(SignalClusterLayout signalClusterLayout) {
            injectSignalClusterLayout2(signalClusterLayout);
        }

        public void injectSignalStrengthView(SignalStrengthView signalStrengthView) {
            injectSignalStrengthView2(signalStrengthView);
        }

        private BatteryView injectBatteryView2(BatteryView instance) {
            BatteryView_MembersInjector.injectMBatteryComponent(instance, (BatteryComponent) this.singletonCImpl.provideBatteryComponentProvider.get());
            BatteryView_MembersInjector.injectMDeviceStateComponent(instance, (DeviceStateComponent) this.singletonCImpl.provideDeviceStateComponentProvider.get());
            return instance;
        }

        private BluetoothView injectBluetoothView2(BluetoothView instance) {
            BluetoothView_MembersInjector.injectBluetoothComponent(instance, bluetoothComponent());
            return instance;
        }

        private BrightView injectBrightView2(BrightView instance) {
            BrightView_MembersInjector.injectMBrightComponent(instance, brightComponent());
            return instance;
        }

        private DialNotificationView injectDialNotificationView2(DialNotificationView instance) {
            DialNotificationView_MembersInjector.injectNotificationComponent(instance, (NotificationComponent) this.singletonCImpl.provideNotificationComponentProvider.get());
            return instance;
        }

        private NetworkView injectNetworkView2(NetworkView instance) {
            NetworkView_MembersInjector.injectWifiComponent(instance, this.singletonCImpl.wifiComponent());
            return instance;
        }

        private SignalClusterLayout injectSignalClusterLayout2(SignalClusterLayout instance) {
            SignalClusterLayout_MembersInjector.injectPhoneStatusComponent(instance, (PhoneStatusComponent) this.singletonCImpl.providePhoneStatusComponentProvider.get());
            return instance;
        }

        private SignalStrengthView injectSignalStrengthView2(SignalStrengthView instance) {
            SignalStrengthView_MembersInjector.injectPhoneStatusComponent(instance, (PhoneStatusComponent) this.singletonCImpl.providePhoneStatusComponentProvider.get());
            return instance;
        }
    }

    private static final class ActivityCImpl extends LauncherApplication_HiltComponents.ActivityC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;

        @Override // com.dw.launcher.Dashboard_GeneratedInjector
        public void injectDashboard(Dashboard dashboard) {
        }

        private ActivityCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
            this.activityCImpl = this;
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
        }

        private BreatheSharedPreferencesUtils breatheSharedPreferencesUtils() {
            return new BreatheSharedPreferencesUtils((Context) this.singletonCImpl.provideContextProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SensorComponent sensorComponent() {
            return injectSensorComponent(SensorComponent_Factory.newInstance((Context) this.singletonCImpl.provideContextProvider.get(), (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get()));
        }

        @Override // com.dw.launcher.Launcher_GeneratedInjector
        public void injectLauncher(Launcher launcher) {
            injectLauncher2(launcher);
        }

        @Override // com.dw.launcher.activity.ChargeActivity_GeneratedInjector
        public void injectChargeActivity(ChargeActivity chargeActivity) {
            injectChargeActivity2(chargeActivity);
        }

        @Override // com.dw.launcher.activity.NoDisturbActivity_GeneratedInjector
        public void injectNoDisturbActivity(NoDisturbActivity noDisturbActivity) {
            injectNoDisturbActivity2(noDisturbActivity);
        }

        public void injectAddMenuShortcutActivity(AddMenuShortcutActivity addMenuShortcutActivity) {
            injectAddMenuShortcutActivity2(addMenuShortcutActivity);
        }

        public void injectBreatheActivity(BreatheActivity breatheActivity) {
            injectBreatheActivity2(breatheActivity);
        }

        public void injectBreatheSettingActivity(BreatheSettingActivity breatheSettingActivity) {
            injectBreatheSettingActivity2(breatheSettingActivity);
        }

        public void injectBreatheValueSettingActivity(BreatheValueSettingActivity breatheValueSettingActivity) {
            injectBreatheValueSettingActivity2(breatheValueSettingActivity);
        }

        public void injectComponentManagerActivity(ComponentManagerActivity componentManagerActivity) {
            injectComponentManagerActivity2(componentManagerActivity);
        }

        public void injectCustomWallPaperActivity(CustomWallPaperActivity customWallPaperActivity) {
            injectCustomWallPaperActivity2(customWallPaperActivity);
        }

        public void injectCustomWatchActivity(CustomWatchActivity customWatchActivity) {
            injectCustomWatchActivity2(customWatchActivity);
        }

        public void injectLowBatteryActivity(LowBatteryActivity lowBatteryActivity) {
            injectLowBatteryActivity2(lowBatteryActivity);
        }

        public void injectPickClockActivity(PickClockActivity pickClockActivity) {
            injectPickClockActivity2(pickClockActivity);
        }

        public void injectPickDashboardActivity(PickDashboardActivity pickDashboardActivity) {
            injectPickDashboardActivity2(pickDashboardActivity);
        }

        public void injectSetThemeActivity(SetThemeActivity setThemeActivity) {
            injectSetThemeActivity2(setThemeActivity);
        }

        public void injectSetWallpaperActivity(SetWallpaperActivity setWallpaperActivity) {
            injectSetWallpaperActivity2(setWallpaperActivity);
        }

        public void injectShutdownActivity(ShutdownActivity shutdownActivity) {
            injectShutdownActivity2(shutdownActivity);
        }

        public void injectSleepClockActivity(SleepClockActivity sleepClockActivity) {
            injectSleepClockActivity2(sleepClockActivity);
        }

        public void injectDashboardContainerActivity(DashboardContainerActivity dashboardContainerActivity) {
            injectDashboardContainerActivity2(dashboardContainerActivity);
        }

        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
            return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(this.singletonCImpl, this.activityRetainedCImpl));
        }

        public Map<Class<?>, Boolean> getViewModelKeys() {
            return LazyClassKeyMap.of(MapBuilder.newMapBuilder(7).put(LazyClassKeyProvider.com_dw_launcher_ui_viewmodel_BPressureViewModel, Boolean.valueOf(BPressureViewModel_HiltModules.KeyModule.provide())).put(LazyClassKeyProvider.com_dw_launcher_ui_fragment_clock_ClockViewModel, Boolean.valueOf(ClockViewModel_HiltModules.KeyModule.provide())).put(LazyClassKeyProvider.com_dw_launcher_ui_dashboard_DashboardViewModel, Boolean.valueOf(DashboardViewModel_HiltModules.KeyModule.provide())).put(LazyClassKeyProvider.com_dw_launcher_ui_fragment_menu_MenuViewModel, Boolean.valueOf(MenuViewModel_HiltModules.KeyModule.provide())).put(LazyClassKeyProvider.com_dw_launcher_ui_viewmodel_StepViewModel, Boolean.valueOf(StepViewModel_HiltModules.KeyModule.provide())).put(LazyClassKeyProvider.com_dw_launcher_ui_viewmodel_ThemeViewModel, Boolean.valueOf(ThemeViewModel_HiltModules.KeyModule.provide())).put(LazyClassKeyProvider.com_dw_launcher_ui_viewmodel_WallpaperViewModel, Boolean.valueOf(WallpaperViewModel_HiltModules.KeyModule.provide())).build());
        }

        public ViewModelComponentBuilder getViewModelComponentBuilder() {
            return new ViewModelCBuilder(this.singletonCImpl, this.activityRetainedCImpl);
        }

        public FragmentComponentBuilder fragmentComponentBuilder() {
            return new FragmentCBuilder(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl);
        }

        public ViewComponentBuilder viewComponentBuilder() {
            return new ViewCBuilder(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl);
        }

        private Launcher injectLauncher2(Launcher instance) {
            Launcher_MembersInjector.injectLauncherRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            Launcher_MembersInjector.injectPhoneStatusComponent(instance, (PhoneStatusComponent) this.singletonCImpl.providePhoneStatusComponentProvider.get());
            Launcher_MembersInjector.injectPreferences(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            return instance;
        }

        private ChargeActivity injectChargeActivity2(ChargeActivity instance) {
            ChargeActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            ChargeActivity_MembersInjector.injectMAssetsLaunchRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            ChargeActivity_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            return instance;
        }

        private NoDisturbActivity injectNoDisturbActivity2(NoDisturbActivity instance) {
            NoDisturbActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            NoDisturbActivity_MembersInjector.injectBatteryComponent(instance, (BatteryComponent) this.singletonCImpl.provideBatteryComponentProvider.get());
            return instance;
        }

        private AddMenuShortcutActivity injectAddMenuShortcutActivity2(AddMenuShortcutActivity instance) {
            AddMenuShortcutActivity_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            AddMenuShortcutActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            return instance;
        }

        private BreatheActivity injectBreatheActivity2(BreatheActivity instance) {
            BreatheActivity_MembersInjector.injectSharedPreferences(instance, breatheSharedPreferencesUtils());
            BreatheActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            return instance;
        }

        private BreatheSettingActivity injectBreatheSettingActivity2(BreatheSettingActivity instance) {
            BreatheSettingActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            return instance;
        }

        private BreatheValueSettingActivity injectBreatheValueSettingActivity2(BreatheValueSettingActivity instance) {
            BreatheValueSettingActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            BreatheValueSettingActivity_MembersInjector.injectSharedPreferences(instance, breatheSharedPreferencesUtils());
            return instance;
        }

        private ComponentManagerActivity injectComponentManagerActivity2(ComponentManagerActivity instance) {
            ComponentManagerActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            ComponentManagerActivity_MembersInjector.injectSharedPreferencesUtils(instance, (SharedPreferencesUtils) this.singletonCImpl.provideSharedPreferencesUtilsProvider.get());
            return instance;
        }

        private CustomWallPaperActivity injectCustomWallPaperActivity2(CustomWallPaperActivity instance) {
            CustomWallPaperActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            CustomWallPaperActivity_MembersInjector.injectPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            return instance;
        }

        private CustomWatchActivity injectCustomWatchActivity2(CustomWatchActivity instance) {
            CustomWatchActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            CustomWatchActivity_MembersInjector.injectPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            return instance;
        }

        private LowBatteryActivity injectLowBatteryActivity2(LowBatteryActivity instance) {
            LowBatteryActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            return instance;
        }

        private SensorComponent injectSensorComponent(SensorComponent instance) {
            SensorComponent_MembersInjector.injectMRingtoneComponent(instance, (SoundEffect) this.singletonCImpl.provideRingtoneComponentProvider.get());
            return instance;
        }

        private PickClockActivity injectPickClockActivity2(PickClockActivity instance) {
            PickClockActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            PickClockActivity_MembersInjector.injectMSensorComponent(instance, sensorComponent());
            PickClockActivity_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            PickClockActivity_MembersInjector.injectAssertLauncherRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            PickClockActivity_MembersInjector.injectClockConfigDao(instance, (ClockConfigDao) this.singletonCImpl.provideClockConfigDaoProvider.get());
            return instance;
        }

        private PickDashboardActivity injectPickDashboardActivity2(PickDashboardActivity instance) {
            PickDashboardActivity_MembersInjector.injectMDashboardRepository(instance, (IDashboardRepository) this.singletonCImpl.bindDashboardRepositoryProvider.get());
            PickDashboardActivity_MembersInjector.injectMLauncherRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            PickDashboardActivity_MembersInjector.injectMLauncherPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            PickDashboardActivity_MembersInjector.injectMSensorComponent(instance, sensorComponent());
            PickDashboardActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            PickDashboardActivity_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            return instance;
        }

        private SetThemeActivity injectSetThemeActivity2(SetThemeActivity instance) {
            SetThemeActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            SetThemeActivity_MembersInjector.injectShortcutRepository(instance, (IShortcutRepository) this.singletonCImpl.bindShortcutRepositoryProvider.get());
            SetThemeActivity_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            return instance;
        }

        private SetWallpaperActivity injectSetWallpaperActivity2(SetWallpaperActivity instance) {
            SetWallpaperActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            SetWallpaperActivity_MembersInjector.injectWallpaperComponent(instance, (WallpaperComponent) this.singletonCImpl.provideWallpaperComponentProvider.get());
            SetWallpaperActivity_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            return instance;
        }

        private ShutdownActivity injectShutdownActivity2(ShutdownActivity instance) {
            ShutdownActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            return instance;
        }

        private SleepClockActivity injectSleepClockActivity2(SleepClockActivity instance) {
            SleepClockActivity_MembersInjector.injectKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            SleepClockActivity_MembersInjector.injectSharedPreferences(instance, (SharedPreferencesUtils) this.singletonCImpl.provideSharedPreferencesUtilsProvider.get());
            return instance;
        }

        private DashboardContainerActivity injectDashboardContainerActivity2(DashboardContainerActivity instance) {
            DashboardContainerActivity_MembersInjector.injectMPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            DashboardContainerActivity_MembersInjector.injectSysKeyEvent(instance, (SysKeyEvent) this.singletonCImpl.getSystemKeyProvider.get());
            DashboardContainerActivity_MembersInjector.injectMAssetsLaunchRepository(instance, (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
            DashboardContainerActivity_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.singletonCImpl.provideNoDisturbComponentProvider.get());
            return instance;
        }

        private static final class LazyClassKeyProvider {
            static String com_dw_launcher_ui_dashboard_DashboardViewModel = "com.dw.launcher.ui.dashboard.DashboardViewModel";
            static String com_dw_launcher_ui_fragment_clock_ClockViewModel = "com.dw.launcher.ui.fragment.clock.ClockViewModel";
            static String com_dw_launcher_ui_fragment_menu_MenuViewModel = "com.dw.launcher.ui.fragment.menu.MenuViewModel";
            static String com_dw_launcher_ui_viewmodel_BPressureViewModel = "com.dw.launcher.ui.viewmodel.BPressureViewModel";
            static String com_dw_launcher_ui_viewmodel_StepViewModel = "com.dw.launcher.ui.viewmodel.StepViewModel";
            static String com_dw_launcher_ui_viewmodel_ThemeViewModel = "com.dw.launcher.ui.viewmodel.ThemeViewModel";
            static String com_dw_launcher_ui_viewmodel_WallpaperViewModel = "com.dw.launcher.ui.viewmodel.WallpaperViewModel";
            DashboardViewModel com_dw_launcher_ui_dashboard_DashboardViewModel2;
            ClockViewModel com_dw_launcher_ui_fragment_clock_ClockViewModel2;
            MenuViewModel com_dw_launcher_ui_fragment_menu_MenuViewModel2;
            BPressureViewModel com_dw_launcher_ui_viewmodel_BPressureViewModel2;
            StepViewModel com_dw_launcher_ui_viewmodel_StepViewModel2;
            ThemeViewModel com_dw_launcher_ui_viewmodel_ThemeViewModel2;
            WallpaperViewModel com_dw_launcher_ui_viewmodel_WallpaperViewModel2;

            private LazyClassKeyProvider() {
            }
        }
    }

    private static final class ViewModelCImpl extends LauncherApplication_HiltComponents.ViewModelC {
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Provider<BPressureViewModel> bPressureViewModelProvider;
        private Provider<ClockViewModel> clockViewModelProvider;
        private Provider<DashboardViewModel> dashboardViewModelProvider;
        private Provider<MenuViewModel> menuViewModelProvider;
        private final SingletonCImpl singletonCImpl;
        private Provider<StepViewModel> stepViewModelProvider;
        private Provider<ThemeViewModel> themeViewModelProvider;
        private final ViewModelCImpl viewModelCImpl;
        private Provider<WallpaperViewModel> wallpaperViewModelProvider;

        private ViewModelCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam, ViewModelLifecycle viewModelLifecycleParam) {
            this.viewModelCImpl = this;
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            initialize(savedStateHandleParam, viewModelLifecycleParam);
        }

        private void initialize(final SavedStateHandle savedStateHandleParam, final ViewModelLifecycle viewModelLifecycleParam) {
            this.bPressureViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 0);
            this.clockViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 1);
            this.dashboardViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 2);
            this.menuViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 3);
            this.stepViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 4);
            this.themeViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 5);
            this.wallpaperViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 6);
        }

        public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
            return LazyClassKeyMap.of(MapBuilder.newMapBuilder(7).put(LazyClassKeyProvider.com_dw_launcher_ui_viewmodel_BPressureViewModel, this.bPressureViewModelProvider).put(LazyClassKeyProvider.com_dw_launcher_ui_fragment_clock_ClockViewModel, this.clockViewModelProvider).put(LazyClassKeyProvider.com_dw_launcher_ui_dashboard_DashboardViewModel, this.dashboardViewModelProvider).put(LazyClassKeyProvider.com_dw_launcher_ui_fragment_menu_MenuViewModel, this.menuViewModelProvider).put(LazyClassKeyProvider.com_dw_launcher_ui_viewmodel_StepViewModel, this.stepViewModelProvider).put(LazyClassKeyProvider.com_dw_launcher_ui_viewmodel_ThemeViewModel, this.themeViewModelProvider).put(LazyClassKeyProvider.com_dw_launcher_ui_viewmodel_WallpaperViewModel, this.wallpaperViewModelProvider).build());
        }

        public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
            return Collections.emptyMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ThemeViewModel injectThemeViewModel(ThemeViewModel instance) {
            ThemeViewModel_MembersInjector.injectShortcutRepository(instance, (IShortcutRepository) this.singletonCImpl.bindShortcutRepositoryProvider.get());
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public WallpaperViewModel injectWallpaperViewModel(WallpaperViewModel instance) {
            WallpaperViewModel_MembersInjector.injectWallpaperComponent(instance, (WallpaperComponent) this.singletonCImpl.provideWallpaperComponentProvider.get());
            return instance;
        }

        private static final class LazyClassKeyProvider {
            static String com_dw_launcher_ui_dashboard_DashboardViewModel = "com.dw.launcher.ui.dashboard.DashboardViewModel";
            static String com_dw_launcher_ui_fragment_clock_ClockViewModel = "com.dw.launcher.ui.fragment.clock.ClockViewModel";
            static String com_dw_launcher_ui_fragment_menu_MenuViewModel = "com.dw.launcher.ui.fragment.menu.MenuViewModel";
            static String com_dw_launcher_ui_viewmodel_BPressureViewModel = "com.dw.launcher.ui.viewmodel.BPressureViewModel";
            static String com_dw_launcher_ui_viewmodel_StepViewModel = "com.dw.launcher.ui.viewmodel.StepViewModel";
            static String com_dw_launcher_ui_viewmodel_ThemeViewModel = "com.dw.launcher.ui.viewmodel.ThemeViewModel";
            static String com_dw_launcher_ui_viewmodel_WallpaperViewModel = "com.dw.launcher.ui.viewmodel.WallpaperViewModel";
            DashboardViewModel com_dw_launcher_ui_dashboard_DashboardViewModel2;
            ClockViewModel com_dw_launcher_ui_fragment_clock_ClockViewModel2;
            MenuViewModel com_dw_launcher_ui_fragment_menu_MenuViewModel2;
            BPressureViewModel com_dw_launcher_ui_viewmodel_BPressureViewModel2;
            StepViewModel com_dw_launcher_ui_viewmodel_StepViewModel2;
            ThemeViewModel com_dw_launcher_ui_viewmodel_ThemeViewModel2;
            WallpaperViewModel com_dw_launcher_ui_viewmodel_WallpaperViewModel2;

            private LazyClassKeyProvider() {
            }
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final ActivityRetainedCImpl activityRetainedCImpl;
            private final int id;
            private final SingletonCImpl singletonCImpl;
            private final ViewModelCImpl viewModelCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ViewModelCImpl viewModelCImpl, int id) {
                this.singletonCImpl = singletonCImpl;
                this.activityRetainedCImpl = activityRetainedCImpl;
                this.viewModelCImpl = viewModelCImpl;
                this.id = id;
            }

            public T get() {
                switch (this.id) {
                    case 0:
                        return (T) new BPressureViewModel(ApplicationContextModule_ProvideApplicationFactory.provideApplication(this.singletonCImpl.applicationContextModule));
                    case 1:
                        return (T) new ClockViewModel((ClockRepository) this.singletonCImpl.bindClockRepositoryProvider.get(), (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get(), (Context) this.singletonCImpl.provideContextProvider.get(), (LocaleComponent) this.singletonCImpl.provideLocaleComponentProvider.get());
                    case 2:
                        return (T) new DashboardViewModel((IShortcutRepository) this.singletonCImpl.bindShortcutRepositoryProvider.get());
                    case 3:
                        return (T) new MenuViewModel((IRecentTaskRepository) this.singletonCImpl.bindRecentTaskRepositoryProvider.get(), (SharedPreferencesUtils) this.singletonCImpl.provideSharedPreferencesUtilsProvider.get());
                    case 4:
                        return (T) new StepViewModel(ApplicationContextModule_ProvideApplicationFactory.provideApplication(this.singletonCImpl.applicationContextModule));
                    case 5:
                        return (T) this.viewModelCImpl.injectThemeViewModel(ThemeViewModel_Factory.newInstance());
                    case 6:
                        return (T) this.viewModelCImpl.injectWallpaperViewModel(WallpaperViewModel_Factory.newInstance());
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }

    private static final class ActivityRetainedCImpl extends LauncherApplication_HiltComponents.ActivityRetainedC {
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;
        private final SingletonCImpl singletonCImpl;

        private ActivityRetainedCImpl(SingletonCImpl singletonCImpl, SavedStateHandleHolder savedStateHandleHolderParam) {
            this.activityRetainedCImpl = this;
            this.singletonCImpl = singletonCImpl;
            initialize(savedStateHandleHolderParam);
        }

        private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
            this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, 0));
        }

        public ActivityComponentBuilder activityComponentBuilder() {
            return new ActivityCBuilder(this.singletonCImpl, this.activityRetainedCImpl);
        }

        public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
            return (ActivityRetainedLifecycle) this.provideActivityRetainedLifecycleProvider.get();
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final ActivityRetainedCImpl activityRetainedCImpl;
            private final int id;
            private final SingletonCImpl singletonCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, int id) {
                this.singletonCImpl = singletonCImpl;
                this.activityRetainedCImpl = activityRetainedCImpl;
                this.id = id;
            }

            public T get() {
                if (this.id == 0) {
                    return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();
                }
                throw new AssertionError(this.id);
            }
        }
    }

    private static final class ServiceCImpl extends LauncherApplication_HiltComponents.ServiceC {
        private final ServiceCImpl serviceCImpl;
        private final SingletonCImpl singletonCImpl;

        private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
            this.serviceCImpl = this;
            this.singletonCImpl = singletonCImpl;
        }

        @Override // com.dw.launcher.core.notification.NotificationService_GeneratedInjector
        public void injectNotificationService(NotificationService notificationService) {
            injectNotificationService2(notificationService);
        }

        @Override // com.dw.launcher.core.service.LauncherWallpaperService_GeneratedInjector
        public void injectLauncherWallpaperService(LauncherWallpaperService launcherWallpaperService) {
            injectLauncherWallpaperService2(launcherWallpaperService);
        }

        @Override // com.dw.launcher.core.service.ShortcutService_GeneratedInjector
        public void injectShortcutService(ShortcutService shortcutService) {
            injectShortcutService2(shortcutService);
        }

        @Override // com.dw.launcher.core.service.StepBySoProviderService_GeneratedInjector
        public void injectStepBySoProviderService(StepBySoProviderService stepBySoProviderService) {
            injectStepBySoProviderService2(stepBySoProviderService);
        }

        @Override // com.dw.launcher.core.service.StepSensorService_GeneratedInjector
        public void injectStepSensorService(StepSensorService stepSensorService) {
            injectStepSensorService2(stepSensorService);
        }

        private NotificationService injectNotificationService2(NotificationService instance) {
            NotificationService_MembersInjector.injectNotificationComponent(instance, (NotificationComponent) this.singletonCImpl.provideNotificationComponentProvider.get());
            return instance;
        }

        private LauncherWallpaperService injectLauncherWallpaperService2(LauncherWallpaperService instance) {
            LauncherWallpaperService_MembersInjector.injectPreference(instance, (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
            return instance;
        }

        private ShortcutService injectShortcutService2(ShortcutService instance) {
            ShortcutService_MembersInjector.injectShortcutInflater(instance, (ShortcutInflater) this.singletonCImpl.provideShortcutInflaterProvider.get());
            return instance;
        }

        private StepBySoProviderService injectStepBySoProviderService2(StepBySoProviderService instance) {
            StepBySoProviderService_MembersInjector.injectStepDataDao(instance, (StepDataDao) this.singletonCImpl.provideStepDaoProvider.get());
            return instance;
        }

        private StepSensorService injectStepSensorService2(StepSensorService instance) {
            StepSensorService_MembersInjector.injectStepDataDao(instance, (StepDataDao) this.singletonCImpl.provideStepDaoProvider.get());
            return instance;
        }
    }

    private static final class SingletonCImpl extends LauncherApplication_HiltComponents.SingletonC {
        private final ApplicationContextModule applicationContextModule;
        private Provider<AssetsClockRepository> assetsClockRepositoryProvider;
        private Provider<AssetsLaunchRepository> assetsLaunchRepositoryProvider;
        private Provider<ClockRepository> bindClockRepositoryProvider;
        private Provider<IDashboardRepository> bindDashboardRepositoryProvider;
        private Provider<LauncherPreference> bindLauncherPreferenceProvider;
        private Provider<LauncherRepository> bindLauncherRepositoryProvider;
        private Provider<IRecentTaskRepository> bindRecentTaskRepositoryProvider;
        private Provider<IShortcutRepository> bindShortcutRepositoryProvider;
        private Provider<WatchConfigRepository> bindWatchRepositoryProvider;
        private final ContextProvider contextProvider;
        private Provider<DashboardRepository> dashboardRepositoryProvider;
        private Provider<SysKeyEvent> getSystemKeyProvider;
        private Provider<LauncherPreferenceImpl> launcherPreferenceImplProvider;
        private Provider<BatteryComponent> provideBatteryComponentProvider;
        private Provider<ClockConfigDao> provideClockConfigDaoProvider;
        private Provider<ClockRegister> provideClockRegisterProvider;
        private Provider<Context> provideContextProvider;
        private Provider<DeviceStateComponent> provideDeviceStateComponentProvider;
        private Provider<LauncherDB> provideLauncherDBProvider;
        private Provider<LocaleComponent> provideLocaleComponentProvider;
        private Provider<NoDisturbComponent> provideNoDisturbComponentProvider;
        private Provider<NotificationComponent> provideNotificationComponentProvider;
        private Provider<PhoneStatusComponent> providePhoneStatusComponentProvider;
        private Provider<SoundEffect> provideRingtoneComponentProvider;
        private Provider<SharedPreferencesUtils> provideSharedPreferencesUtilsProvider;
        private Provider<ShortcutInflater> provideShortcutInflaterProvider;
        private Provider<SoundEffect> provideSoundEffectProvider;
        private Provider<StepDataDao> provideStepDaoProvider;
        private Provider<VoiceComponent> provideVoiceComponentProvider;
        private Provider<WallpaperComponent> provideWallpaperComponentProvider;
        private Provider<RecentTaskRepository> recentTaskRepositoryProvider;
        private Provider<RingtoneComponent> ringtoneComponentProvider;
        private Provider<ShortcutRepository> shortcutRepositoryProvider;
        private final SingletonCImpl singletonCImpl;
        private Provider<SoundPoolComponent> soundPoolComponentProvider;
        private Provider<WatchLaunchRepositoryImpl> watchLaunchRepositoryImplProvider;

        private SingletonCImpl(ApplicationContextModule applicationContextModuleParam, ContextProvider contextProviderParam) {
            this.singletonCImpl = this;
            this.contextProvider = contextProviderParam;
            this.applicationContextModule = applicationContextModuleParam;
            initialize(applicationContextModuleParam, contextProviderParam);
        }

        private PackageManagerComponent packageManagerComponent() {
            return new PackageManagerComponent((Context) this.provideContextProvider.get(), (IShortcutRepository) this.bindShortcutRepositoryProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public WifiComponent wifiComponent() {
            return new WifiComponent((Context) this.provideContextProvider.get());
        }

        private void initialize(final ApplicationContextModule applicationContextModuleParam, final ContextProvider contextProviderParam) {
            this.provideContextProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 1));
            this.provideBatteryComponentProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 0));
            SwitchingProvider switchingProvider = new SwitchingProvider(this.singletonCImpl, 5);
            this.launcherPreferenceImplProvider = switchingProvider;
            this.bindLauncherPreferenceProvider = DoubleCheck.provider(switchingProvider);
            this.provideSharedPreferencesUtilsProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 6));
            SwitchingProvider switchingProvider2 = new SwitchingProvider(this.singletonCImpl, 4);
            this.assetsLaunchRepositoryProvider = switchingProvider2;
            this.bindLauncherRepositoryProvider = DoubleCheck.provider(switchingProvider2);
            this.provideShortcutInflaterProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 3));
            SwitchingProvider switchingProvider3 = new SwitchingProvider(this.singletonCImpl, 2);
            this.shortcutRepositoryProvider = switchingProvider3;
            this.bindShortcutRepositoryProvider = DoubleCheck.provider(switchingProvider3);
            this.providePhoneStatusComponentProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 7));
            this.provideNotificationComponentProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 8));
            this.provideWallpaperComponentProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 9));
            this.provideVoiceComponentProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 10));
            this.provideLocaleComponentProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 11));
            this.provideNoDisturbComponentProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 12));
            SwitchingProvider switchingProvider4 = new SwitchingProvider(this.singletonCImpl, 13);
            this.watchLaunchRepositoryImplProvider = switchingProvider4;
            this.bindWatchRepositoryProvider = DoubleCheck.provider(switchingProvider4);
            this.getSystemKeyProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 14));
            SwitchingProvider switchingProvider5 = new SwitchingProvider(this.singletonCImpl, 15);
            this.ringtoneComponentProvider = switchingProvider5;
            this.provideRingtoneComponentProvider = DoubleCheck.provider(switchingProvider5);
            this.provideLauncherDBProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 17));
            this.provideClockConfigDaoProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 16));
            SwitchingProvider switchingProvider6 = new SwitchingProvider(this.singletonCImpl, 18);
            this.dashboardRepositoryProvider = switchingProvider6;
            this.bindDashboardRepositoryProvider = DoubleCheck.provider(switchingProvider6);
            SwitchingProvider switchingProvider7 = new SwitchingProvider(this.singletonCImpl, 19);
            this.soundPoolComponentProvider = switchingProvider7;
            this.provideSoundEffectProvider = DoubleCheck.provider(switchingProvider7);
            this.provideClockRegisterProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 20));
            SwitchingProvider switchingProvider8 = new SwitchingProvider(this.singletonCImpl, 21);
            this.recentTaskRepositoryProvider = switchingProvider8;
            this.bindRecentTaskRepositoryProvider = DoubleCheck.provider(switchingProvider8);
            this.provideStepDaoProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 22));
            this.provideDeviceStateComponentProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 23));
            SwitchingProvider switchingProvider9 = new SwitchingProvider(this.singletonCImpl, 24);
            this.assetsClockRepositoryProvider = switchingProvider9;
            this.bindClockRepositoryProvider = DoubleCheck.provider(switchingProvider9);
        }

        @Override // com.dw.launcher.LauncherApplication_GeneratedInjector
        public void injectLauncherApplication(LauncherApplication launcherApplication) {
            injectLauncherApplication2(launcherApplication);
        }

        @Override // com.dw.launcher.core.receiver.SimCardBroadcastReceiver_GeneratedInjector
        public void injectSimCardBroadcastReceiver(SimCardBroadcastReceiver simCardBroadcastReceiver) {
            injectSimCardBroadcastReceiver2(simCardBroadcastReceiver);
        }

        @Override // com.dw.launcher.tts.BootCompleteReceiver_GeneratedInjector
        public void injectBootCompleteReceiver(BootCompleteReceiver bootCompleteReceiver) {
            injectBootCompleteReceiver2(bootCompleteReceiver);
        }

        @Override // com.dw.launcher.tts.PhoneReceiver_GeneratedInjector
        public void injectPhoneReceiver(PhoneReceiver phoneReceiver) {
            injectPhoneReceiver2(phoneReceiver);
        }

        @Override // com.dw.launcher.tts.SmsReceiver_GeneratedInjector
        public void injectSmsReceiver(SmsReceiver smsReceiver) {
            injectSmsReceiver2(smsReceiver);
        }

        @Override // com.dw.launcher.tts.UsbReceiver_GeneratedInjector
        public void injectUsbReceiver(UsbReceiver usbReceiver) {
            injectUsbReceiver2(usbReceiver);
        }

        public Set<Boolean> getDisableFragmentGetContextFix() {
            return Collections.emptySet();
        }

        public ActivityRetainedComponentBuilder retainedComponentBuilder() {
            return new ActivityRetainedCBuilder(this.singletonCImpl);
        }

        public ServiceComponentBuilder serviceComponentBuilder() {
            return new ServiceCBuilder(this.singletonCImpl);
        }

        private LauncherApplication injectLauncherApplication2(LauncherApplication instance) {
            LauncherApplication_MembersInjector.injectMBatteryComponent(instance, (BatteryComponent) this.provideBatteryComponentProvider.get());
            LauncherApplication_MembersInjector.injectMPackageManagerComponent(instance, packageManagerComponent());
            LauncherApplication_MembersInjector.injectPhoneStatusComponent(instance, (PhoneStatusComponent) this.providePhoneStatusComponentProvider.get());
            LauncherApplication_MembersInjector.injectNotificationComponent(instance, (NotificationComponent) this.provideNotificationComponentProvider.get());
            LauncherApplication_MembersInjector.injectWallpaperComponent(instance, (WallpaperComponent) this.provideWallpaperComponentProvider.get());
            LauncherApplication_MembersInjector.injectWifiComponent(instance, wifiComponent());
            LauncherApplication_MembersInjector.injectMAssetsLaunchRepository(instance, (LauncherRepository) this.bindLauncherRepositoryProvider.get());
            LauncherApplication_MembersInjector.injectVoiceComponent(instance, (VoiceComponent) this.provideVoiceComponentProvider.get());
            LauncherApplication_MembersInjector.injectLocaleComponent(instance, (LocaleComponent) this.provideLocaleComponentProvider.get());
            LauncherApplication_MembersInjector.injectNoDisturbComponent(instance, (NoDisturbComponent) this.provideNoDisturbComponentProvider.get());
            LauncherApplication_MembersInjector.injectWatchLaunchRepository(instance, (WatchConfigRepository) this.bindWatchRepositoryProvider.get());
            return instance;
        }

        private SimCardBroadcastReceiver injectSimCardBroadcastReceiver2(SimCardBroadcastReceiver instance) {
            SimCardBroadcastReceiver_MembersInjector.injectPhoneStatusComponent(instance, (PhoneStatusComponent) this.providePhoneStatusComponentProvider.get());
            return instance;
        }

        private BootCompleteReceiver injectBootCompleteReceiver2(BootCompleteReceiver instance) {
            BootCompleteReceiver_MembersInjector.injectLauncherRepository(instance, (LauncherRepository) this.bindLauncherRepositoryProvider.get());
            return instance;
        }

        private PhoneReceiver injectPhoneReceiver2(PhoneReceiver instance) {
            PhoneReceiver_MembersInjector.injectLauncherRepository(instance, (LauncherRepository) this.bindLauncherRepositoryProvider.get());
            return instance;
        }

        private SmsReceiver injectSmsReceiver2(SmsReceiver instance) {
            SmsReceiver_MembersInjector.injectLauncherRepository(instance, (LauncherRepository) this.bindLauncherRepositoryProvider.get());
            return instance;
        }

        private UsbReceiver injectUsbReceiver2(UsbReceiver instance) {
            UsbReceiver_MembersInjector.injectLauncherRepository(instance, (LauncherRepository) this.bindLauncherRepositoryProvider.get());
            return instance;
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final int id;
            private final SingletonCImpl singletonCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
                this.singletonCImpl = singletonCImpl;
                this.id = id;
            }

            public T get() {
                switch (this.id) {
                    case 0:
                        return (T) ContextProvider_ProvideBatteryComponentFactory.provideBatteryComponent(this.singletonCImpl.contextProvider, (Context) this.singletonCImpl.provideContextProvider.get());
                    case 1:
                        return (T) ContextProvider_ProvideContextFactory.provideContext(this.singletonCImpl.contextProvider);
                    case 2:
                        return (T) new ShortcutRepository((Context) this.singletonCImpl.provideContextProvider.get(), (ShortcutInflater) this.singletonCImpl.provideShortcutInflaterProvider.get(), (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
                    case 3:
                        return (T) ContextProvider_ProvideShortcutInflaterFactory.provideShortcutInflater(this.singletonCImpl.contextProvider, (Context) this.singletonCImpl.provideContextProvider.get(), (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
                    case 4:
                        return (T) new AssetsLaunchRepository((Context) this.singletonCImpl.provideContextProvider.get(), (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get(), (SharedPreferencesUtils) this.singletonCImpl.provideSharedPreferencesUtilsProvider.get());
                    case 5:
                        return (T) new LauncherPreferenceImpl((Context) this.singletonCImpl.provideContextProvider.get());
                    case 6:
                        return (T) ContextProvider_ProvideSharedPreferencesUtilsFactory.provideSharedPreferencesUtils(this.singletonCImpl.contextProvider, (Context) this.singletonCImpl.provideContextProvider.get());
                    case 7:
                        return (T) ContextProvider_ProvidePhoneStatusComponentFactory.providePhoneStatusComponent(this.singletonCImpl.contextProvider, (Context) this.singletonCImpl.provideContextProvider.get());
                    case 8:
                        return (T) ContextProvider_ProvideNotificationComponentFactory.provideNotificationComponent(this.singletonCImpl.contextProvider, (Context) this.singletonCImpl.provideContextProvider.get());
                    case 9:
                        return (T) ContextProvider_ProvideWallpaperComponentFactory.provideWallpaperComponent(this.singletonCImpl.contextProvider, (Context) this.singletonCImpl.provideContextProvider.get(), (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get());
                    case 10:
                        return (T) ContextProvider_ProvideVoiceComponentFactory.provideVoiceComponent(this.singletonCImpl.contextProvider, (Context) this.singletonCImpl.provideContextProvider.get());
                    case 11:
                        return (T) ContextProvider_ProvideLocaleComponentFactory.provideLocaleComponent(this.singletonCImpl.contextProvider, (Context) this.singletonCImpl.provideContextProvider.get());
                    case 12:
                        return (T) ContextProvider_ProvideNoDisturbComponentFactory.provideNoDisturbComponent(this.singletonCImpl.contextProvider, (Context) this.singletonCImpl.provideContextProvider.get());
                    case 13:
                        return (T) new WatchLaunchRepositoryImpl((Context) this.singletonCImpl.provideContextProvider.get());
                    case 14:
                        return (T) ContextProvider_GetSystemKeyFactory.getSystemKey(this.singletonCImpl.contextProvider, (Context) this.singletonCImpl.provideContextProvider.get());
                    case 15:
                        return (T) new RingtoneComponent((Context) this.singletonCImpl.provideContextProvider.get());
                    case 16:
                        return (T) ContextProvider_ProvideClockConfigDaoFactory.provideClockConfigDao(this.singletonCImpl.contextProvider, (LauncherDB) this.singletonCImpl.provideLauncherDBProvider.get());
                    case 17:
                        return (T) ContextProvider_ProvideLauncherDBFactory.provideLauncherDB(this.singletonCImpl.contextProvider, (Context) this.singletonCImpl.provideContextProvider.get());
                    case 18:
                        return (T) new DashboardRepository((Context) this.singletonCImpl.provideContextProvider.get(), (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
                    case 19:
                        return (T) new SoundPoolComponent((Context) this.singletonCImpl.provideContextProvider.get());
                    case 20:
                        return (T) ContextProvider_ProvideClockRegisterFactory.provideClockRegister(this.singletonCImpl.contextProvider, (Context) this.singletonCImpl.provideContextProvider.get());
                    case 21:
                        return (T) new RecentTaskRepository((Context) this.singletonCImpl.provideContextProvider.get(), (ShortcutInflater) this.singletonCImpl.provideShortcutInflaterProvider.get(), (LauncherRepository) this.singletonCImpl.bindLauncherRepositoryProvider.get());
                    case 22:
                        return (T) ContextProvider_ProvideStepDaoFactory.provideStepDao(this.singletonCImpl.contextProvider, (LauncherDB) this.singletonCImpl.provideLauncherDBProvider.get());
                    case 23:
                        return (T) ContextProvider_ProvideDeviceStateComponentFactory.provideDeviceStateComponent(this.singletonCImpl.contextProvider, (Context) this.singletonCImpl.provideContextProvider.get());
                    case 24:
                        return (T) new AssetsClockRepository((Context) this.singletonCImpl.provideContextProvider.get(), (LauncherPreference) this.singletonCImpl.bindLauncherPreferenceProvider.get(), (WatchConfigRepository) this.singletonCImpl.bindWatchRepositoryProvider.get(), (ClockConfigDao) this.singletonCImpl.provideClockConfigDaoProvider.get());
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }
}
