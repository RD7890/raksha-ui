package com.dw.launcher;

import com.dw.launcher.activity.ChargeActivity_GeneratedInjector;
import com.dw.launcher.activity.NoDisturbActivity_GeneratedInjector;
import com.dw.launcher.core.notification.NotificationService_GeneratedInjector;
import com.dw.launcher.core.receiver.SimCardBroadcastReceiver_GeneratedInjector;
import com.dw.launcher.core.service.LauncherWallpaperService_GeneratedInjector;
import com.dw.launcher.core.service.ShortcutService_GeneratedInjector;
import com.dw.launcher.core.service.StepBySoProviderService_GeneratedInjector;
import com.dw.launcher.core.service.StepSensorService_GeneratedInjector;
import com.dw.launcher.hilt.provider.ComponentProvider;
import com.dw.launcher.hilt.provider.ContextProvider;
import com.dw.launcher.hilt.provider.RepositoryModule;
import com.dw.launcher.hilt.provider.SoundEffectProvider;
import com.dw.launcher.hilt.provider.UtilProvider;
import com.dw.launcher.tts.BootCompleteReceiver_GeneratedInjector;
import com.dw.launcher.tts.PhoneReceiver_GeneratedInjector;
import com.dw.launcher.tts.SmsReceiver_GeneratedInjector;
import com.dw.launcher.tts.UsbReceiver_GeneratedInjector;
import com.dw.launcher.ui.activity.AddMenuShortcutActivity_GeneratedInjector;
import com.dw.launcher.ui.activity.BreatheActivity_GeneratedInjector;
import com.dw.launcher.ui.activity.BreatheSettingActivity_GeneratedInjector;
import com.dw.launcher.ui.activity.BreatheValueSettingActivity_GeneratedInjector;
import com.dw.launcher.ui.activity.ComponentManagerActivity_GeneratedInjector;
import com.dw.launcher.ui.activity.CustomWallPaperActivity_GeneratedInjector;
import com.dw.launcher.ui.activity.CustomWatchActivity_GeneratedInjector;
import com.dw.launcher.ui.activity.LowBatteryActivity_GeneratedInjector;
import com.dw.launcher.ui.activity.PickClockActivity_GeneratedInjector;
import com.dw.launcher.ui.activity.PickDashboardActivity_GeneratedInjector;
import com.dw.launcher.ui.activity.SetThemeActivity_GeneratedInjector;
import com.dw.launcher.ui.activity.SetWallpaperActivity_GeneratedInjector;
import com.dw.launcher.ui.activity.ShutdownActivity_GeneratedInjector;
import com.dw.launcher.ui.activity.SleepClockActivity_GeneratedInjector;
import com.dw.launcher.ui.dashboard.BaseDashboard_GeneratedInjector;
import com.dw.launcher.ui.dashboard.BubbleDashboard_GeneratedInjector;
import com.dw.launcher.ui.dashboard.CyclicDashboard_GeneratedInjector;
import com.dw.launcher.ui.dashboard.DashboardViewModel_HiltModules;
import com.dw.launcher.ui.dashboard.FiveCyclicDashboard_GeneratedInjector;
import com.dw.launcher.ui.dashboard.GridDashboard_GeneratedInjector;
import com.dw.launcher.ui.dashboard.HalfCyclicDashboard_GeneratedInjector;
import com.dw.launcher.ui.dashboard.HoneycombDashboard_GeneratedInjector;
import com.dw.launcher.ui.dashboard.LinearDashboard_GeneratedInjector;
import com.dw.launcher.ui.dashboard.VerticalGridDashboardNoTitle_GeneratedInjector;
import com.dw.launcher.ui.dashboard.VerticalGridDashboard_GeneratedInjector;
import com.dw.launcher.ui.fragment.bottom.BottomFragment_GeneratedInjector;
import com.dw.launcher.ui.fragment.breathe.BreatheFragment_GeneratedInjector;
import com.dw.launcher.ui.fragment.clock.ClockContainerFragment_GeneratedInjector;
import com.dw.launcher.ui.fragment.clock.ClockViewModel_HiltModules;
import com.dw.launcher.ui.fragment.clock.DialFragment_GeneratedInjector;
import com.dw.launcher.ui.fragment.dashboard.CardContainerFragment_GeneratedInjector;
import com.dw.launcher.ui.fragment.dashboard.DashboardContainerActivity_GeneratedInjector;
import com.dw.launcher.ui.fragment.dashboard.DashboardContainerFragment_GeneratedInjector;
import com.dw.launcher.ui.fragment.heart.HeartFragment_GeneratedInjector;
import com.dw.launcher.ui.fragment.launcher.LauncherCardFragment_GeneratedInjector;
import com.dw.launcher.ui.fragment.launcher.LauncherFragment_GeneratedInjector;
import com.dw.launcher.ui.fragment.menu.MenuFragment_GeneratedInjector;
import com.dw.launcher.ui.fragment.menu.MenuViewModel_HiltModules;
import com.dw.launcher.ui.fragment.music.MusicControlFragment_GeneratedInjector;
import com.dw.launcher.ui.fragment.sleep.SleepFragment_GeneratedInjector;
import com.dw.launcher.ui.fragment.sport.SportFragment_GeneratedInjector;
import com.dw.launcher.ui.fragment.step.StepFragment_GeneratedInjector;
import com.dw.launcher.ui.fragment.top.TopRoundFragment_GeneratedInjector;
import com.dw.launcher.ui.fragment.top.TopSwitchFragment_GeneratedInjector;
import com.dw.launcher.ui.view.BatteryView_GeneratedInjector;
import com.dw.launcher.ui.view.BluetoothView_GeneratedInjector;
import com.dw.launcher.ui.view.BrightView_GeneratedInjector;
import com.dw.launcher.ui.view.DialNotificationView_GeneratedInjector;
import com.dw.launcher.ui.view.NetworkView_GeneratedInjector;
import com.dw.launcher.ui.view.SignalClusterLayout_GeneratedInjector;
import com.dw.launcher.ui.view.SignalStrengthView_GeneratedInjector;
import com.dw.launcher.ui.viewmodel.BPressureViewModel_HiltModules;
import com.dw.launcher.ui.viewmodel.StepViewModel_HiltModules;
import com.dw.launcher.ui.viewmodel.ThemeViewModel_HiltModules;
import com.dw.launcher.ui.viewmodel.WallpaperViewModel_HiltModules;
import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_DefaultViewModelFactories_ActivityModule;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ViewModelModule;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;
import dagger.hilt.android.internal.managers.HiltWrapper_SavedStateHandleModule;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.HiltWrapper_ActivityModule;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import javax.inject.Singleton;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class LauncherApplication_HiltComponents {

    @Subcomponent(modules = {ComponentProvider.class, HiltWrapper_ActivityModule.class, HiltWrapper_DefaultViewModelFactories_ActivityModule.class, FragmentCBuilderModule.class, ViewCBuilderModule.class})
    public static abstract class ActivityC implements Dashboard_GeneratedInjector, Launcher_GeneratedInjector, ChargeActivity_GeneratedInjector, NoDisturbActivity_GeneratedInjector, AddMenuShortcutActivity_GeneratedInjector, BreatheActivity_GeneratedInjector, BreatheSettingActivity_GeneratedInjector, BreatheValueSettingActivity_GeneratedInjector, ComponentManagerActivity_GeneratedInjector, CustomWallPaperActivity_GeneratedInjector, CustomWatchActivity_GeneratedInjector, LowBatteryActivity_GeneratedInjector, PickClockActivity_GeneratedInjector, PickDashboardActivity_GeneratedInjector, SetThemeActivity_GeneratedInjector, SetWallpaperActivity_GeneratedInjector, ShutdownActivity_GeneratedInjector, SleepClockActivity_GeneratedInjector, DashboardContainerActivity_GeneratedInjector, ActivityComponent, DefaultViewModelFactories.ActivityEntryPoint, HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint, FragmentComponentManager.FragmentComponentBuilderEntryPoint, ViewComponentManager.ViewComponentBuilderEntryPoint, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ActivityComponentBuilder {
        }
    }

    @Module(subcomponents = {ActivityC.class})
    interface ActivityCBuilderModule {
        @Binds
        ActivityComponentBuilder bind(ActivityC.Builder builder);
    }

    @Subcomponent(modules = {BPressureViewModel_HiltModules.KeyModule.class, ClockViewModel_HiltModules.KeyModule.class, DashboardViewModel_HiltModules.KeyModule.class, HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class, HiltWrapper_SavedStateHandleModule.class, ActivityCBuilderModule.class, ViewModelCBuilderModule.class, MenuViewModel_HiltModules.KeyModule.class, StepViewModel_HiltModules.KeyModule.class, ThemeViewModel_HiltModules.KeyModule.class, WallpaperViewModel_HiltModules.KeyModule.class})
    public static abstract class ActivityRetainedC implements ActivityRetainedComponent, ActivityComponentManager.ActivityComponentBuilderEntryPoint, HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ActivityRetainedComponentBuilder {
        }
    }

    @Module(subcomponents = {ActivityRetainedC.class})
    interface ActivityRetainedCBuilderModule {
        @Binds
        ActivityRetainedComponentBuilder bind(ActivityRetainedC.Builder builder);
    }

    @Subcomponent(modules = {ViewWithFragmentCBuilderModule.class})
    public static abstract class FragmentC implements BaseDashboard_GeneratedInjector, BubbleDashboard_GeneratedInjector, CyclicDashboard_GeneratedInjector, FiveCyclicDashboard_GeneratedInjector, GridDashboard_GeneratedInjector, HalfCyclicDashboard_GeneratedInjector, HoneycombDashboard_GeneratedInjector, LinearDashboard_GeneratedInjector, VerticalGridDashboardNoTitle_GeneratedInjector, VerticalGridDashboard_GeneratedInjector, BottomFragment_GeneratedInjector, BreatheFragment_GeneratedInjector, ClockContainerFragment_GeneratedInjector, DialFragment_GeneratedInjector, CardContainerFragment_GeneratedInjector, DashboardContainerFragment_GeneratedInjector, HeartFragment_GeneratedInjector, LauncherCardFragment_GeneratedInjector, LauncherFragment_GeneratedInjector, MenuFragment_GeneratedInjector, MusicControlFragment_GeneratedInjector, SleepFragment_GeneratedInjector, SportFragment_GeneratedInjector, StepFragment_GeneratedInjector, TopRoundFragment_GeneratedInjector, TopSwitchFragment_GeneratedInjector, FragmentComponent, DefaultViewModelFactories.FragmentEntryPoint, ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends FragmentComponentBuilder {
        }
    }

    @Module(subcomponents = {FragmentC.class})
    interface FragmentCBuilderModule {
        @Binds
        FragmentComponentBuilder bind(FragmentC.Builder builder);
    }

    @Subcomponent
    public static abstract class ServiceC implements NotificationService_GeneratedInjector, LauncherWallpaperService_GeneratedInjector, ShortcutService_GeneratedInjector, StepBySoProviderService_GeneratedInjector, StepSensorService_GeneratedInjector, ServiceComponent, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ServiceComponentBuilder {
        }
    }

    @Module(subcomponents = {ServiceC.class})
    interface ServiceCBuilderModule {
        @Binds
        ServiceComponentBuilder bind(ServiceC.Builder builder);
    }

    @Component(modules = {ApplicationContextModule.class, ContextProvider.class, HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule.class, ActivityRetainedCBuilderModule.class, ServiceCBuilderModule.class, RepositoryModule.class, SoundEffectProvider.class, UtilProvider.class})
    @Singleton
    public static abstract class SingletonC implements LauncherApplication_GeneratedInjector, SimCardBroadcastReceiver_GeneratedInjector, BootCompleteReceiver_GeneratedInjector, PhoneReceiver_GeneratedInjector, SmsReceiver_GeneratedInjector, UsbReceiver_GeneratedInjector, FragmentGetContextFix.FragmentGetContextFixEntryPoint, HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint, ServiceComponentManager.ServiceComponentBuilderEntryPoint, SingletonComponent, GeneratedComponent {
    }

    @Subcomponent
    public static abstract class ViewC implements BatteryView_GeneratedInjector, BluetoothView_GeneratedInjector, BrightView_GeneratedInjector, DialNotificationView_GeneratedInjector, NetworkView_GeneratedInjector, SignalClusterLayout_GeneratedInjector, SignalStrengthView_GeneratedInjector, ViewComponent, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ViewComponentBuilder {
        }
    }

    @Module(subcomponents = {ViewC.class})
    interface ViewCBuilderModule {
        @Binds
        ViewComponentBuilder bind(ViewC.Builder builder);
    }

    @Subcomponent(modules = {BPressureViewModel_HiltModules.BindsModule.class, ClockViewModel_HiltModules.BindsModule.class, DashboardViewModel_HiltModules.BindsModule.class, HiltWrapper_HiltViewModelFactory_ViewModelModule.class, MenuViewModel_HiltModules.BindsModule.class, StepViewModel_HiltModules.BindsModule.class, ThemeViewModel_HiltModules.BindsModule.class, WallpaperViewModel_HiltModules.BindsModule.class})
    public static abstract class ViewModelC implements ViewModelComponent, HiltViewModelFactory.ViewModelFactoriesEntryPoint, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ViewModelComponentBuilder {
        }
    }

    @Module(subcomponents = {ViewModelC.class})
    interface ViewModelCBuilderModule {
        @Binds
        ViewModelComponentBuilder bind(ViewModelC.Builder builder);
    }

    @Subcomponent
    public static abstract class ViewWithFragmentC implements ViewWithFragmentComponent, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ViewWithFragmentComponentBuilder {
        }
    }

    @Module(subcomponents = {ViewWithFragmentC.class})
    interface ViewWithFragmentCBuilderModule {
        @Binds
        ViewWithFragmentComponentBuilder bind(ViewWithFragmentC.Builder builder);
    }

    private LauncherApplication_HiltComponents() {
    }
}
