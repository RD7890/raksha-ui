package com.dw.launcher.data.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.dw.launcher.data.database.dao.ClockConfigDao;
import com.dw.launcher.data.database.dao.ClockConfigDao_Impl;
import com.dw.launcher.data.database.dao.StepDataDao;
import com.dw.launcher.data.database.dao.StepDataDao_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class LauncherDB_Impl extends LauncherDB {
    private volatile ClockConfigDao _clockConfigDao;
    private volatile StepDataDao _stepDataDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
        return configuration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(51) { // from class: com.dw.launcher.data.database.LauncherDB_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase _db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("CREATE TABLE IF NOT EXISTS `t_clock_config` (`path` TEXT NOT NULL, `fromAssets` INTEGER NOT NULL, `id` TEXT NOT NULL, `name` TEXT, `name_en` TEXT, `screentype` TEXT, `dialtype` INTEGER NOT NULL, `coordinate_screen_width` INTEGER NOT NULL, `coordinate_screen_height` INTEGER NOT NULL, `bg_type` INTEGER NOT NULL, `video` TEXT, `lottie` TEXT, `bg_animal_keep_for_last_frame` INTEGER NOT NULL, `bg_count` INTEGER NOT NULL, `bg_interval` TEXT, `bg_is_customize` TEXT, `hour_pointer_src` TEXT, `hour_pointer_x` INTEGER NOT NULL, `hour_pointer_y` INTEGER NOT NULL, `minute_pointer_src` TEXT, `minute_pointer_x` INTEGER NOT NULL, `minute_pointer_y` INTEGER NOT NULL, `second_pointer_src` TEXT, `second_pointer_type` INTEGER NOT NULL, `second_pointer_x` INTEGER NOT NULL, `second_pointer_y` INTEGER NOT NULL, `second_pointer_animal_type` INTEGER NOT NULL, `dot_src` TEXT, `dot_x` INTEGER NOT NULL, `dot_y` INTEGER NOT NULL, `show_pointer_start_animation` INTEGER NOT NULL, `pointer_start_hour` INTEGER NOT NULL, `pointer_start_minute` INTEGER NOT NULL, `pointer_start_second` INTEGER NOT NULL, `time_hour_src` TEXT, `time_min_src` TEXT, `time_sec_src` TEXT, `time_splt_src` TEXT, `time_splt_2_src` TEXT, `time_splt_need_jump` INTEGER NOT NULL, `time_x` INTEGER NOT NULL, `time_y` INTEGER NOT NULL, `need_reset_min` INTEGER NOT NULL, `reset_min_x` INTEGER NOT NULL, `reset_min_y` INTEGER NOT NULL, `show_sec` INTEGER NOT NULL, `need_reset_sec` INTEGER NOT NULL, `reset_sec_x` INTEGER NOT NULL, `reset_sec_y` INTEGER NOT NULL, `open_time_arc_show` INTEGER NOT NULL, `time_arc_type` INTEGER NOT NULL, `time_arc_center_x` INTEGER NOT NULL, `time_arc_center_y` INTEGER NOT NULL, `show_am_or_pm` INTEGER NOT NULL, `am_and_pm_src` TEXT, `am_or_pm_x` INTEGER NOT NULL, `am_or_pm_y` INTEGER NOT NULL, `show_ampm_placeholer` INTEGER NOT NULL, `show_digital_start_animation` INTEGER NOT NULL, `digital_start_hour` INTEGER NOT NULL, `digital_start_minute` INTEGER NOT NULL, `digital_start_second` INTEGER NOT NULL, `date_src` TEXT, `date_x` INTEGER NOT NULL, `date_y` INTEGER NOT NULL, `open_date_arc_show` INTEGER NOT NULL, `date_arc_type` INTEGER NOT NULL, `date_arc_center_x` INTEGER NOT NULL, `date_arc_center_y` INTEGER NOT NULL, `date_year_splt_src` TEXT, `date_month_splt_src` TEXT, `date_day_splt_src` TEXT, `show_year` INTEGER NOT NULL, `year_digits_type` INTEGER NOT NULL, `show_month` INTEGER NOT NULL, `month_type` INTEGER NOT NULL, `month_src` TEXT, `need_reset_month` INTEGER NOT NULL, `data_month_num` TEXT, `month_x` INTEGER NOT NULL, `month_y` INTEGER NOT NULL, `show_day` INTEGER NOT NULL, `need_reset_day` INTEGER NOT NULL, `data_day_num` TEXT, `day_x` INTEGER NOT NULL, `day_y` INTEGER NOT NULL, `day_src` TEXT, `day_type` INTEGER NOT NULL, `week_src` TEXT, `week_num_src` TEXT, `week_x` INTEGER NOT NULL, `week_y` INTEGER NOT NULL, `show_power` INTEGER NOT NULL, `normal_0_src` TEXT, `normal_1_src` TEXT, `normal_2_src` TEXT, `normal_3_src` TEXT, `normal_4_src` TEXT, `normal_5_src` TEXT, `normal_6_src` TEXT, `normal_7_src` TEXT, `normal_8_src` TEXT, `normal_9_src` TEXT, `normal_10_src` TEXT, `power_x` INTEGER NOT NULL, `power_y` INTEGER NOT NULL, `show_charge` INTEGER NOT NULL, `charge_0_src` TEXT, `charge_1_src` TEXT, `charge_2_src` TEXT, `charge_3_src` TEXT, `charge_4_src` TEXT, `charge_5_src` TEXT, `charge_6_src` TEXT, `charge_7_src` TEXT, `charge_8_src` TEXT, `charge_9_src` TEXT, `charge_10_src` TEXT, `show_power_num` INTEGER NOT NULL, `power_num_src` TEXT, `power_sign_src` TEXT, `power_show_type` INTEGER NOT NULL, `power_num_x` INTEGER NOT NULL, `power_num_y` INTEGER NOT NULL, `show_action` INTEGER NOT NULL, `open_action_1` INTEGER NOT NULL, `action_1_count` INTEGER NOT NULL, `action_1_x` INTEGER NOT NULL, `action_1_y` INTEGER NOT NULL, `open_action_2` INTEGER NOT NULL, `action_2_count` INTEGER NOT NULL, `action_2_x` INTEGER NOT NULL, `action_2_y` INTEGER NOT NULL, `open_action_3` INTEGER NOT NULL, `action_3_count` INTEGER NOT NULL, `action_3_x` INTEGER NOT NULL, `action_3_y` INTEGER NOT NULL, `action_interval` INTEGER NOT NULL, `show_overall_animation` TEXT, `overall_animation_x` INTEGER NOT NULL, `overall_animation_y` INTEGER NOT NULL, `open_click_1` TEXT, `click_1_x` INTEGER NOT NULL, `click_1_y` INTEGER NOT NULL, `click_1_width` TEXT, `click_1_height` TEXT, `open_click_2` TEXT, `click_2_x` INTEGER NOT NULL, `click_2_y` INTEGER NOT NULL, `click_2_width` TEXT, `click_2_height` TEXT, `open_click_3` TEXT, `click_3_x` INTEGER NOT NULL, `click_3_y` INTEGER NOT NULL, `click_3_width` TEXT, `click_3_height` TEXT, `open_click_4` TEXT, `click_4_x` INTEGER NOT NULL, `click_4_y` INTEGER NOT NULL, `click_4_width` TEXT, `click_4_height` TEXT, `show_lunar` INTEGER NOT NULL, `lunar_src` TEXT, `lunar_x` INTEGER NOT NULL, `lunar_y` INTEGER NOT NULL, `show_heart` INTEGER NOT NULL, `heart_src` TEXT, `heart_x` INTEGER NOT NULL, `heart_y` INTEGER NOT NULL, `heart_num_src` TEXT, `heart_num_type` TEXT, `heart_end_src` TEXT, `heart_show_type` INTEGER NOT NULL, `heart_num_x` INTEGER NOT NULL, `heart_num_y` INTEGER NOT NULL, `open_heart_arc_show` INTEGER NOT NULL, `heart_arc_type` INTEGER NOT NULL, `heart_arc_center_x` INTEGER NOT NULL, `heart_arc_center_y` INTEGER NOT NULL, `show_pressure` TEXT, `pressure_src` TEXT, `pressure_x` INTEGER NOT NULL, `pressure_y` INTEGER NOT NULL, `pressure_num_src` TEXT, `pressure_num_x` INTEGER NOT NULL, `pressure_num_y` INTEGER NOT NULL, `pressure_show_type` TEXT, `pressure_splt_src` TEXT, `show_step` INTEGER NOT NULL, `step_src` TEXT, `step_follow_num` INTEGER NOT NULL, `step_x` INTEGER NOT NULL, `step_y` INTEGER NOT NULL, `step_num_src` TEXT, `step_num_type` INTEGER NOT NULL, `step_show_type` INTEGER NOT NULL, `step_num_x` INTEGER NOT NULL, `step_num_y` INTEGER NOT NULL, `step_end_src` TEXT, `show_step_progress` INTEGER NOT NULL, `step_progress_x` INTEGER NOT NULL, `step_progress_y` INTEGER NOT NULL, `step_progress_src` TEXT, `open_step_arc_show` INTEGER NOT NULL, `step_arc_type` INTEGER NOT NULL, `step_arc_center_x` INTEGER NOT NULL, `step_arc_center_y` INTEGER NOT NULL, `show_kcal` INTEGER NOT NULL, `kcal_src` TEXT, `kcal_x` INTEGER NOT NULL, `kcal_y` INTEGER NOT NULL, `kcal_num_src` TEXT, `kcal_num_type` INTEGER NOT NULL, `kcal_show_type` INTEGER NOT NULL, `kcal_num_x` INTEGER NOT NULL, `kcal_num_y` INTEGER NOT NULL, `kcal_end_src` TEXT, `show_km` TEXT, `km_src` TEXT, `km_x` INTEGER NOT NULL, `km_y` INTEGER NOT NULL, `km_num_src` TEXT, `km_comma_src` TEXT, `km_num_type` TEXT, `km_show_type` INTEGER NOT NULL, `km_num_x` INTEGER NOT NULL, `km_num_y` INTEGER NOT NULL, `km_end_src` TEXT, `show_weather` TEXT, `show_temperature` TEXT, `temperature_show_type` INTEGER NOT NULL, `temperature_num_type` INTEGER NOT NULL, `temperature_x` INTEGER NOT NULL, `temperature_y` INTEGER NOT NULL, `temperature_x_2` INTEGER NOT NULL, `temperature_y_2` INTEGER NOT NULL, `show_now_tem` TEXT, `now_tem_show_type` TEXT, `now_tem_x` INTEGER NOT NULL, `now_tem_y` INTEGER NOT NULL, `temperature_num_src` TEXT, `temperature_sub_src` TEXT, `temperature_sign_src` TEXT, `temperature_splt_src` TEXT, `show_diagram` TEXT, `diagram_x` INTEGER NOT NULL, `diagram_y` INTEGER NOT NULL, `showsignal` INTEGER NOT NULL, `show_signal` INTEGER NOT NULL, `signal_src` TEXT, `signal_x` INTEGER NOT NULL, `signal_y` INTEGER NOT NULL, `show_user_name` TEXT, `name_show_type` TEXT, `name_x` INTEGER NOT NULL, `name_y` INTEGER NOT NULL, `show_operator` TEXT, `operator_show_type` TEXT, `operator_x` INTEGER NOT NULL, `operator_y` INTEGER NOT NULL, `show_btn_call` TEXT, `btn_call_src` TEXT, `btn_call_x` INTEGER NOT NULL, `btn_call_y` INTEGER NOT NULL, `show_btn_sms` TEXT, `btn_sms_src` TEXT, `btn_sms_x` INTEGER NOT NULL, `btn_sms_y` INTEGER NOT NULL, `show_btn_heart` TEXT, `is_our_heart` INTEGER NOT NULL, `btn_heart_src` TEXT, `btn_heart_x` INTEGER NOT NULL, `btn_heart_y` INTEGER NOT NULL, `show_btn_step` TEXT, `btn_step_src` TEXT, `btn_step_x` INTEGER NOT NULL, `btn_step_y` INTEGER NOT NULL, `show_btn_wechat` TEXT, `btn_wechat_src` TEXT, `btn_wechat_x` INTEGER NOT NULL, `btn_wechat_y` INTEGER NOT NULL, `show_btn_alipay` INTEGER NOT NULL, `btn_alipay_src` TEXT, `btn_alipay_x` INTEGER NOT NULL, `btn_alipay_y` INTEGER NOT NULL, `show_btn_stopwatch` INTEGER NOT NULL, `btn_stopwatch_src` TEXT, `btn_stopwatch_x` INTEGER NOT NULL, `btn_stopwatch_y` INTEGER NOT NULL, `show_btn_weather` INTEGER NOT NULL, `show_btn_calo` INTEGER NOT NULL, `btn_calo_src` TEXT, `btn_calo_x` INTEGER NOT NULL, `btn_calo_y` INTEGER NOT NULL, `temprature_src` TEXT, `show_btn_camera` TEXT, `btn_camera_src` TEXT, `btn_camera_x` INTEGER NOT NULL, `btn_camera_y` INTEGER NOT NULL, `show_btn_sos` TEXT, `btn_sos_src` TEXT, `btn_sos_x` INTEGER NOT NULL, `btn_sos_y` INTEGER NOT NULL, `show_special_1` TEXT, `special_1_src` TEXT, `special_1_position` TEXT, `special_x` INTEGER NOT NULL, `special_y` INTEGER NOT NULL, `support_multiple_change` INTEGER NOT NULL, `show_lunar_year` INTEGER NOT NULL, `lunar_day_splt_src` TEXT, `lunar_month_splt_src` TEXT, `lunar_year_splt_src` TEXT, `am_src` TEXT, `pm_src` TEXT, `show_btn_alarm` INTEGER NOT NULL, `btn_alarm_src` TEXT, `btn_alarm_x` INTEGER NOT NULL, `btn_alarm_y` INTEGER NOT NULL, `bg_btn_change` INTEGER NOT NULL, `bg_btn_index` INTEGER NOT NULL, `show_btn_music` INTEGER NOT NULL, `btn_music_src` TEXT, `btn_music_x` INTEGER NOT NULL, `btn_music_y` INTEGER NOT NULL, `support_dynamic_change` INTEGER NOT NULL, `level` INTEGER NOT NULL, `parent_id` TEXT, `next_id` INTEGER NOT NULL, `change_starttime` INTEGER NOT NULL, `change_endtime` INTEGER NOT NULL, `btn_weather_src` TEXT, `btn_weather_x` INTEGER NOT NULL, `btn_weather_y` INTEGER NOT NULL, `show_btn_calories` INTEGER NOT NULL, `btn_calories_src` TEXT, `btn_calories_x` INTEGER NOT NULL, `btn_calories_y` INTEGER NOT NULL, `support_compass` INTEGER NOT NULL, `compass_src` TEXT, `compass_2_src` TEXT, `compass_x` INTEGER NOT NULL, `compass_y` INTEGER NOT NULL, `show_btn_setting` INTEGER NOT NULL, `btn_setting_src` TEXT, `btn_setting_x` INTEGER NOT NULL, `btn_setting_y` INTEGER NOT NULL, `support_click_change` INTEGER NOT NULL, `click_id_is_current` INTEGER NOT NULL, `compass_show_detail_degree` INTEGER NOT NULL, `compass_direction_src` TEXT, `compass_direction_x` INTEGER NOT NULL, `compass_direction_y` INTEGER NOT NULL, `compass_direction_2_src` TEXT, `compass_direction_2_x` INTEGER NOT NULL, `compass_direction_2_y` INTEGER NOT NULL, `compass_direction_3_src` TEXT, `compass_direction_3_x` INTEGER NOT NULL, `compass_direction_3_y` INTEGER NOT NULL, `compass_direction_degree_src` TEXT, `compass_direction_degree_x` INTEGER NOT NULL, `compass_direction_degree_y` INTEGER NOT NULL, `compass_direction_degree_unit` TEXT, `compass_degree_1_src` TEXT, `compass_degree_1_x` INTEGER NOT NULL, `compass_degree_1_y` INTEGER NOT NULL, `compass_degree_2_src` TEXT, `compass_degree_2_x` INTEGER NOT NULL, `compass_degree_2_y` INTEGER NOT NULL, `compass_degree_3_src` TEXT, `compass_degree_3_x` INTEGER NOT NULL, `compass_degree_3_y` INTEGER NOT NULL, `show_connect_animation` INTEGER NOT NULL, `connect_animation_x` INTEGER NOT NULL, `connect_animation_y` INTEGER NOT NULL, `connect_animation_count` INTEGER NOT NULL, `show_state` INTEGER NOT NULL, `state_x` INTEGER NOT NULL, `state_y` INTEGER NOT NULL, `action_1_cut_position` INTEGER NOT NULL, `action_2_cut_position` INTEGER NOT NULL, `action_3_cut_position` INTEGER NOT NULL, `show_btn_googleplay` INTEGER NOT NULL, `btn_googleplay_src` TEXT, `btn_googleplay_x` INTEGER NOT NULL, `btn_googleplay_y` INTEGER NOT NULL, `show_month_2` INTEGER NOT NULL, `month_type_2` INTEGER NOT NULL, `month_src_2` TEXT, `month_x_2` INTEGER NOT NULL, `month_y_2` INTEGER NOT NULL, `time_special_new` INTEGER NOT NULL, `time_special_hour_ten_src` TEXT, `time_special_hour_src` TEXT, `time_special_min_ten_src` TEXT, `time_special_min_src` TEXT, `show_kcal_progress` INTEGER NOT NULL, `kcal_progress_x` INTEGER NOT NULL, `kcal_progress_y` INTEGER NOT NULL, `kcal_progress_src` TEXT, `open_kcal_arc_show` INTEGER NOT NULL, `kcal_arc_type` INTEGER NOT NULL, `kcal_arc_center_x` INTEGER NOT NULL, `kcal_arc_center_y` INTEGER NOT NULL, `open_power_arc_show` INTEGER NOT NULL, `power_arc_type` INTEGER NOT NULL, `power_arc_center_x` INTEGER NOT NULL, `power_arc_center_y` INTEGER NOT NULL, `show_btn_timer` INTEGER NOT NULL, `btn_timer_src` TEXT, `btn_timer_x` INTEGER NOT NULL, `btn_timer_y` INTEGER NOT NULL, `show_btn_sleep` INTEGER NOT NULL, `btn_sleep_src` TEXT, `btn_sleep_x` INTEGER NOT NULL, `btn_sleep_y` INTEGER NOT NULL, `show_btn_bloodpressure` INTEGER NOT NULL, `btn_bloodpressure_src` TEXT, `btn_bloodpressure_x` INTEGER NOT NULL, `btn_bloodpressure_y` INTEGER NOT NULL, `show_btn_sport_record` INTEGER NOT NULL, `btn_sport_record_src` TEXT, `btn_sport_record_x` INTEGER NOT NULL, `btn_sport_record_y` INTEGER NOT NULL, `lottie_hierarchy` INTEGER NOT NULL, `show_heart_progress` INTEGER NOT NULL, `heart_progress_x` INTEGER NOT NULL, `heart_progress_y` INTEGER NOT NULL, `heart_progress_src` TEXT, `show_btn_calculator` INTEGER NOT NULL, `btn_calculator_src` TEXT, `btn_calculator_x` INTEGER NOT NULL, `btn_calculator_y` INTEGER NOT NULL, `time_special_drag_3d` INTEGER NOT NULL, `prev_HourTen_Position` TEXT, `prev_HourGe_Position` TEXT, `current_HourTen_Position` TEXT, `current_HourGe_Position` TEXT, `next_HourTen_Position` TEXT, `next_HourGe_Position` TEXT, `prev_MinTen_Position` TEXT, `prev_MinGe_Position` TEXT, `current_MinTen_Position` TEXT, `current_MinGe_Position` TEXT, `next_MinTen_Position` TEXT, `next_MinGe_Position` TEXT, `need_split_day` INTEGER NOT NULL, `split_day_x` INTEGER NOT NULL, `split_day_y` INTEGER NOT NULL, `open_now_tem_arc_show` INTEGER NOT NULL, `now_tem_arc_type` INTEGER NOT NULL, `now_tem_arc_center_x` INTEGER NOT NULL, `now_tem_arc_center_y` INTEGER NOT NULL, `show_km_progress` INTEGER NOT NULL, `km_progress_x` INTEGER NOT NULL, `km_progress_y` INTEGER NOT NULL, `km_progress_src` TEXT, `open_km_arc_show` INTEGER NOT NULL, `km_arc_type` INTEGER NOT NULL, `km_arc_center_x` INTEGER NOT NULL, `km_arc_center_y` INTEGER NOT NULL, `time_rotate` INTEGER NOT NULL, `time_rotate_degree` INTEGER NOT NULL, `heart_num_rotate` INTEGER NOT NULL, `heart_num_rotate_degree` INTEGER NOT NULL, `show_oxygen` INTEGER NOT NULL, `oxygen_src` TEXT, `oxygen_x` INTEGER NOT NULL, `oxygen_y` INTEGER NOT NULL, `oxygen_num_src` TEXT, `oxygen_sign_src` TEXT, `oxygen_show_type` INTEGER NOT NULL, `oxygen_num_x` INTEGER NOT NULL, `oxygen_num_y` INTEGER NOT NULL, `time_change_counter` INTEGER NOT NULL, `time_hour_src_2` TEXT, `time_min_src_2` TEXT, `time_sec_src_2` TEXT, `time_splt_src_2` TEXT, `time_splt_2_src_2` TEXT, `time_hour_src_3` TEXT, `time_min_src_3` TEXT, `time_sec_src_3` TEXT, `time_splt_src_3` TEXT, `time_splt_2_src_3` TEXT, `time_hour_src_4` TEXT, `time_min_src_4` TEXT, `time_sec_src_4` TEXT, `time_splt_src_4` TEXT, `time_splt_2_src_4` TEXT, `date_rotate` INTEGER NOT NULL, `date_rotate_degree` INTEGER NOT NULL, `need_split_hour` INTEGER NOT NULL, `split_hour_src` TEXT, `split_hour_x` INTEGER NOT NULL, `split_hour_y` INTEGER NOT NULL, `need_split_min` INTEGER NOT NULL, `split_min_src` TEXT, `split_min_x` INTEGER NOT NULL, `split_min_y` INTEGER NOT NULL, `support_scale` INTEGER NOT NULL, `show_compass_num` INTEGER NOT NULL, `compass_num_src` TEXT, `compass_show_type` INTEGER NOT NULL, `compass_num_x` INTEGER NOT NULL, `compass_num_y` INTEGER NOT NULL, `compass_num_src_prefix` TEXT, `compass_num_src_sign` TEXT, `show_btn_oxygen` INTEGER NOT NULL, `btn_oxygen_src` TEXT, `btn_oxygen_x` INTEGER NOT NULL, `btn_oxygen_y` INTEGER NOT NULL, `show_btn_calendar` INTEGER NOT NULL, `btn_calendar_src` TEXT, `btn_calendar_x` INTEGER NOT NULL, `btn_calendar_y` INTEGER NOT NULL, `show_btn_compass` INTEGER NOT NULL, `btn_compass_src` TEXT, `btn_compass_x` INTEGER NOT NULL, `btn_compass_y` INTEGER NOT NULL, `pointer_disable_scale` INTEGER NOT NULL, `show_chinse_time` INTEGER NOT NULL, `chinse_time_src` TEXT, `chinse_time_x` INTEGER NOT NULL, `chinse_time_y` INTEGER NOT NULL, `show_btn_photo` INTEGER NOT NULL, `btn_photo_src` TEXT, `btn_photo_x` INTEGER NOT NULL, `btn_photo_y` INTEGER NOT NULL, `show_btn_contact` INTEGER NOT NULL, `btn_contact_src` TEXT, `btn_contact_x` INTEGER NOT NULL, `btn_contact_y` INTEGER NOT NULL, `kcal_num_rotate` INTEGER NOT NULL, `kcal_num_rotate_degree` INTEGER NOT NULL, `show_power_progress` INTEGER NOT NULL, `power_progress_src` TEXT, `power_progress_x` INTEGER NOT NULL, `power_progress_y` INTEGER NOT NULL, `power_src` TEXT, `power_src_x` INTEGER NOT NULL, `power_src_y` INTEGER NOT NULL, `video_type` INTEGER NOT NULL, `step_keep_number_length` INTEGER NOT NULL, `kcal_keep_number_length` INTEGER NOT NULL, `km_keep_number_length` INTEGER NOT NULL, `step_num_rotate` INTEGER NOT NULL, `step_num_rotate_degree` INTEGER NOT NULL, `show_btn_style` INTEGER NOT NULL, `btn_style_src` TEXT, `btn_style_x` INTEGER NOT NULL, `btn_style_y` INTEGER NOT NULL, `need_split_sec` INTEGER NOT NULL, `split_sec_src` TEXT, `split_sec_x` INTEGER NOT NULL, `split_sec_y` INTEGER NOT NULL, `open_oxygen_arc_show` INTEGER NOT NULL, `oxygen_arc_type` INTEGER NOT NULL, `oxygen_arc_center_x` INTEGER NOT NULL, `oxygen_arc_center_y` INTEGER NOT NULL, `show_oxygen_progress` INTEGER NOT NULL, `oxygen_progress_src` TEXT, `oxygen_progress_x` INTEGER NOT NULL, `oxygen_progress_y` INTEGER NOT NULL, `show_week_donts` INTEGER NOT NULL, `week_donts_src` TEXT, `week_donts_x` INTEGER NOT NULL, `week_donts_y` INTEGER NOT NULL, `show_btn_flashlight` INTEGER NOT NULL, `flashlight_src` TEXT, `flashlight_x` INTEGER NOT NULL, `flashlight_y` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `t_step` (`date` TEXT NOT NULL, `step` INTEGER NOT NULL, `initStep` INTEGER NOT NULL, PRIMARY KEY(`date`))");
                _db.execSQL(RoomMasterTable.CREATE_QUERY);
                _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '07965d5d2607a2257c7156c8eacd63b3')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("DROP TABLE IF EXISTS `t_clock_config`");
                _db.execSQL("DROP TABLE IF EXISTS `t_step`");
                if (LauncherDB_Impl.this.mCallbacks != null) {
                    int size = LauncherDB_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) LauncherDB_Impl.this.mCallbacks.get(i)).onDestructiveMigration(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void onCreate(SupportSQLiteDatabase _db) {
                if (LauncherDB_Impl.this.mCallbacks != null) {
                    int size = LauncherDB_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) LauncherDB_Impl.this.mCallbacks.get(i)).onCreate(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase _db) {
                LauncherDB_Impl.this.mDatabase = _db;
                LauncherDB_Impl.this.internalInitInvalidationTracker(_db);
                if (LauncherDB_Impl.this.mCallbacks != null) {
                    int size = LauncherDB_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) LauncherDB_Impl.this.mCallbacks.get(i)).onOpen(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase _db) {
                DBUtil.dropFtsSyncTriggers(_db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
                HashMap map = new HashMap(572);
                map.put("path", new TableInfo.Column("path", "TEXT", true, 0, null, 1));
                map.put("fromAssets", new TableInfo.Column("fromAssets", "INTEGER", true, 0, null, 1));
                map.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                map.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
                map.put("name_en", new TableInfo.Column("name_en", "TEXT", false, 0, null, 1));
                map.put("screentype", new TableInfo.Column("screentype", "TEXT", false, 0, null, 1));
                map.put("dialtype", new TableInfo.Column("dialtype", "INTEGER", true, 0, null, 1));
                map.put("coordinate_screen_width", new TableInfo.Column("coordinate_screen_width", "INTEGER", true, 0, null, 1));
                map.put("coordinate_screen_height", new TableInfo.Column("coordinate_screen_height", "INTEGER", true, 0, null, 1));
                map.put("bg_type", new TableInfo.Column("bg_type", "INTEGER", true, 0, null, 1));
                map.put("video", new TableInfo.Column("video", "TEXT", false, 0, null, 1));
                map.put("lottie", new TableInfo.Column("lottie", "TEXT", false, 0, null, 1));
                map.put("bg_animal_keep_for_last_frame", new TableInfo.Column("bg_animal_keep_for_last_frame", "INTEGER", true, 0, null, 1));
                map.put("bg_count", new TableInfo.Column("bg_count", "INTEGER", true, 0, null, 1));
                map.put("bg_interval", new TableInfo.Column("bg_interval", "TEXT", false, 0, null, 1));
                map.put("bg_is_customize", new TableInfo.Column("bg_is_customize", "TEXT", false, 0, null, 1));
                map.put("hour_pointer_src", new TableInfo.Column("hour_pointer_src", "TEXT", false, 0, null, 1));
                map.put("hour_pointer_x", new TableInfo.Column("hour_pointer_x", "INTEGER", true, 0, null, 1));
                map.put("hour_pointer_y", new TableInfo.Column("hour_pointer_y", "INTEGER", true, 0, null, 1));
                map.put("minute_pointer_src", new TableInfo.Column("minute_pointer_src", "TEXT", false, 0, null, 1));
                map.put("minute_pointer_x", new TableInfo.Column("minute_pointer_x", "INTEGER", true, 0, null, 1));
                map.put("minute_pointer_y", new TableInfo.Column("minute_pointer_y", "INTEGER", true, 0, null, 1));
                map.put("second_pointer_src", new TableInfo.Column("second_pointer_src", "TEXT", false, 0, null, 1));
                map.put("second_pointer_type", new TableInfo.Column("second_pointer_type", "INTEGER", true, 0, null, 1));
                map.put("second_pointer_x", new TableInfo.Column("second_pointer_x", "INTEGER", true, 0, null, 1));
                map.put("second_pointer_y", new TableInfo.Column("second_pointer_y", "INTEGER", true, 0, null, 1));
                map.put("second_pointer_animal_type", new TableInfo.Column("second_pointer_animal_type", "INTEGER", true, 0, null, 1));
                map.put("dot_src", new TableInfo.Column("dot_src", "TEXT", false, 0, null, 1));
                map.put("dot_x", new TableInfo.Column("dot_x", "INTEGER", true, 0, null, 1));
                map.put("dot_y", new TableInfo.Column("dot_y", "INTEGER", true, 0, null, 1));
                map.put("show_pointer_start_animation", new TableInfo.Column("show_pointer_start_animation", "INTEGER", true, 0, null, 1));
                map.put("pointer_start_hour", new TableInfo.Column("pointer_start_hour", "INTEGER", true, 0, null, 1));
                map.put("pointer_start_minute", new TableInfo.Column("pointer_start_minute", "INTEGER", true, 0, null, 1));
                map.put("pointer_start_second", new TableInfo.Column("pointer_start_second", "INTEGER", true, 0, null, 1));
                map.put("time_hour_src", new TableInfo.Column("time_hour_src", "TEXT", false, 0, null, 1));
                map.put("time_min_src", new TableInfo.Column("time_min_src", "TEXT", false, 0, null, 1));
                map.put("time_sec_src", new TableInfo.Column("time_sec_src", "TEXT", false, 0, null, 1));
                map.put("time_splt_src", new TableInfo.Column("time_splt_src", "TEXT", false, 0, null, 1));
                map.put("time_splt_2_src", new TableInfo.Column("time_splt_2_src", "TEXT", false, 0, null, 1));
                map.put("time_splt_need_jump", new TableInfo.Column("time_splt_need_jump", "INTEGER", true, 0, null, 1));
                map.put("time_x", new TableInfo.Column("time_x", "INTEGER", true, 0, null, 1));
                map.put("time_y", new TableInfo.Column("time_y", "INTEGER", true, 0, null, 1));
                map.put("need_reset_min", new TableInfo.Column("need_reset_min", "INTEGER", true, 0, null, 1));
                map.put("reset_min_x", new TableInfo.Column("reset_min_x", "INTEGER", true, 0, null, 1));
                map.put("reset_min_y", new TableInfo.Column("reset_min_y", "INTEGER", true, 0, null, 1));
                map.put("show_sec", new TableInfo.Column("show_sec", "INTEGER", true, 0, null, 1));
                map.put("need_reset_sec", new TableInfo.Column("need_reset_sec", "INTEGER", true, 0, null, 1));
                map.put("reset_sec_x", new TableInfo.Column("reset_sec_x", "INTEGER", true, 0, null, 1));
                map.put("reset_sec_y", new TableInfo.Column("reset_sec_y", "INTEGER", true, 0, null, 1));
                map.put("open_time_arc_show", new TableInfo.Column("open_time_arc_show", "INTEGER", true, 0, null, 1));
                map.put("time_arc_type", new TableInfo.Column("time_arc_type", "INTEGER", true, 0, null, 1));
                map.put("time_arc_center_x", new TableInfo.Column("time_arc_center_x", "INTEGER", true, 0, null, 1));
                map.put("time_arc_center_y", new TableInfo.Column("time_arc_center_y", "INTEGER", true, 0, null, 1));
                map.put("show_am_or_pm", new TableInfo.Column("show_am_or_pm", "INTEGER", true, 0, null, 1));
                map.put("am_and_pm_src", new TableInfo.Column("am_and_pm_src", "TEXT", false, 0, null, 1));
                map.put("am_or_pm_x", new TableInfo.Column("am_or_pm_x", "INTEGER", true, 0, null, 1));
                map.put("am_or_pm_y", new TableInfo.Column("am_or_pm_y", "INTEGER", true, 0, null, 1));
                map.put("show_ampm_placeholer", new TableInfo.Column("show_ampm_placeholer", "INTEGER", true, 0, null, 1));
                map.put("show_digital_start_animation", new TableInfo.Column("show_digital_start_animation", "INTEGER", true, 0, null, 1));
                map.put("digital_start_hour", new TableInfo.Column("digital_start_hour", "INTEGER", true, 0, null, 1));
                map.put("digital_start_minute", new TableInfo.Column("digital_start_minute", "INTEGER", true, 0, null, 1));
                map.put("digital_start_second", new TableInfo.Column("digital_start_second", "INTEGER", true, 0, null, 1));
                map.put("date_src", new TableInfo.Column("date_src", "TEXT", false, 0, null, 1));
                map.put("date_x", new TableInfo.Column("date_x", "INTEGER", true, 0, null, 1));
                map.put("date_y", new TableInfo.Column("date_y", "INTEGER", true, 0, null, 1));
                map.put("open_date_arc_show", new TableInfo.Column("open_date_arc_show", "INTEGER", true, 0, null, 1));
                map.put("date_arc_type", new TableInfo.Column("date_arc_type", "INTEGER", true, 0, null, 1));
                map.put("date_arc_center_x", new TableInfo.Column("date_arc_center_x", "INTEGER", true, 0, null, 1));
                map.put("date_arc_center_y", new TableInfo.Column("date_arc_center_y", "INTEGER", true, 0, null, 1));
                map.put("date_year_splt_src", new TableInfo.Column("date_year_splt_src", "TEXT", false, 0, null, 1));
                map.put("date_month_splt_src", new TableInfo.Column("date_month_splt_src", "TEXT", false, 0, null, 1));
                map.put("date_day_splt_src", new TableInfo.Column("date_day_splt_src", "TEXT", false, 0, null, 1));
                map.put("show_year", new TableInfo.Column("show_year", "INTEGER", true, 0, null, 1));
                map.put("year_digits_type", new TableInfo.Column("year_digits_type", "INTEGER", true, 0, null, 1));
                map.put("show_month", new TableInfo.Column("show_month", "INTEGER", true, 0, null, 1));
                map.put("month_type", new TableInfo.Column("month_type", "INTEGER", true, 0, null, 1));
                map.put("month_src", new TableInfo.Column("month_src", "TEXT", false, 0, null, 1));
                map.put("need_reset_month", new TableInfo.Column("need_reset_month", "INTEGER", true, 0, null, 1));
                map.put("data_month_num", new TableInfo.Column("data_month_num", "TEXT", false, 0, null, 1));
                map.put("month_x", new TableInfo.Column("month_x", "INTEGER", true, 0, null, 1));
                map.put("month_y", new TableInfo.Column("month_y", "INTEGER", true, 0, null, 1));
                map.put("show_day", new TableInfo.Column("show_day", "INTEGER", true, 0, null, 1));
                map.put("need_reset_day", new TableInfo.Column("need_reset_day", "INTEGER", true, 0, null, 1));
                map.put("data_day_num", new TableInfo.Column("data_day_num", "TEXT", false, 0, null, 1));
                map.put("day_x", new TableInfo.Column("day_x", "INTEGER", true, 0, null, 1));
                map.put("day_y", new TableInfo.Column("day_y", "INTEGER", true, 0, null, 1));
                map.put("day_src", new TableInfo.Column("day_src", "TEXT", false, 0, null, 1));
                map.put("day_type", new TableInfo.Column("day_type", "INTEGER", true, 0, null, 1));
                map.put("week_src", new TableInfo.Column("week_src", "TEXT", false, 0, null, 1));
                map.put("week_num_src", new TableInfo.Column("week_num_src", "TEXT", false, 0, null, 1));
                map.put("week_x", new TableInfo.Column("week_x", "INTEGER", true, 0, null, 1));
                map.put("week_y", new TableInfo.Column("week_y", "INTEGER", true, 0, null, 1));
                map.put("show_power", new TableInfo.Column("show_power", "INTEGER", true, 0, null, 1));
                map.put("normal_0_src", new TableInfo.Column("normal_0_src", "TEXT", false, 0, null, 1));
                map.put("normal_1_src", new TableInfo.Column("normal_1_src", "TEXT", false, 0, null, 1));
                map.put("normal_2_src", new TableInfo.Column("normal_2_src", "TEXT", false, 0, null, 1));
                map.put("normal_3_src", new TableInfo.Column("normal_3_src", "TEXT", false, 0, null, 1));
                map.put("normal_4_src", new TableInfo.Column("normal_4_src", "TEXT", false, 0, null, 1));
                map.put("normal_5_src", new TableInfo.Column("normal_5_src", "TEXT", false, 0, null, 1));
                map.put("normal_6_src", new TableInfo.Column("normal_6_src", "TEXT", false, 0, null, 1));
                map.put("normal_7_src", new TableInfo.Column("normal_7_src", "TEXT", false, 0, null, 1));
                map.put("normal_8_src", new TableInfo.Column("normal_8_src", "TEXT", false, 0, null, 1));
                map.put("normal_9_src", new TableInfo.Column("normal_9_src", "TEXT", false, 0, null, 1));
                map.put("normal_10_src", new TableInfo.Column("normal_10_src", "TEXT", false, 0, null, 1));
                map.put("power_x", new TableInfo.Column("power_x", "INTEGER", true, 0, null, 1));
                map.put("power_y", new TableInfo.Column("power_y", "INTEGER", true, 0, null, 1));
                map.put("show_charge", new TableInfo.Column("show_charge", "INTEGER", true, 0, null, 1));
                map.put("charge_0_src", new TableInfo.Column("charge_0_src", "TEXT", false, 0, null, 1));
                map.put("charge_1_src", new TableInfo.Column("charge_1_src", "TEXT", false, 0, null, 1));
                map.put("charge_2_src", new TableInfo.Column("charge_2_src", "TEXT", false, 0, null, 1));
                map.put("charge_3_src", new TableInfo.Column("charge_3_src", "TEXT", false, 0, null, 1));
                map.put("charge_4_src", new TableInfo.Column("charge_4_src", "TEXT", false, 0, null, 1));
                map.put("charge_5_src", new TableInfo.Column("charge_5_src", "TEXT", false, 0, null, 1));
                map.put("charge_6_src", new TableInfo.Column("charge_6_src", "TEXT", false, 0, null, 1));
                map.put("charge_7_src", new TableInfo.Column("charge_7_src", "TEXT", false, 0, null, 1));
                map.put("charge_8_src", new TableInfo.Column("charge_8_src", "TEXT", false, 0, null, 1));
                map.put("charge_9_src", new TableInfo.Column("charge_9_src", "TEXT", false, 0, null, 1));
                map.put("charge_10_src", new TableInfo.Column("charge_10_src", "TEXT", false, 0, null, 1));
                map.put("show_power_num", new TableInfo.Column("show_power_num", "INTEGER", true, 0, null, 1));
                map.put("power_num_src", new TableInfo.Column("power_num_src", "TEXT", false, 0, null, 1));
                map.put("power_sign_src", new TableInfo.Column("power_sign_src", "TEXT", false, 0, null, 1));
                map.put("power_show_type", new TableInfo.Column("power_show_type", "INTEGER", true, 0, null, 1));
                map.put("power_num_x", new TableInfo.Column("power_num_x", "INTEGER", true, 0, null, 1));
                map.put("power_num_y", new TableInfo.Column("power_num_y", "INTEGER", true, 0, null, 1));
                map.put("show_action", new TableInfo.Column("show_action", "INTEGER", true, 0, null, 1));
                map.put("open_action_1", new TableInfo.Column("open_action_1", "INTEGER", true, 0, null, 1));
                map.put("action_1_count", new TableInfo.Column("action_1_count", "INTEGER", true, 0, null, 1));
                map.put("action_1_x", new TableInfo.Column("action_1_x", "INTEGER", true, 0, null, 1));
                map.put("action_1_y", new TableInfo.Column("action_1_y", "INTEGER", true, 0, null, 1));
                map.put("open_action_2", new TableInfo.Column("open_action_2", "INTEGER", true, 0, null, 1));
                map.put("action_2_count", new TableInfo.Column("action_2_count", "INTEGER", true, 0, null, 1));
                map.put("action_2_x", new TableInfo.Column("action_2_x", "INTEGER", true, 0, null, 1));
                map.put("action_2_y", new TableInfo.Column("action_2_y", "INTEGER", true, 0, null, 1));
                map.put("open_action_3", new TableInfo.Column("open_action_3", "INTEGER", true, 0, null, 1));
                map.put("action_3_count", new TableInfo.Column("action_3_count", "INTEGER", true, 0, null, 1));
                map.put("action_3_x", new TableInfo.Column("action_3_x", "INTEGER", true, 0, null, 1));
                map.put("action_3_y", new TableInfo.Column("action_3_y", "INTEGER", true, 0, null, 1));
                map.put("action_interval", new TableInfo.Column("action_interval", "INTEGER", true, 0, null, 1));
                map.put("show_overall_animation", new TableInfo.Column("show_overall_animation", "TEXT", false, 0, null, 1));
                map.put("overall_animation_x", new TableInfo.Column("overall_animation_x", "INTEGER", true, 0, null, 1));
                map.put("overall_animation_y", new TableInfo.Column("overall_animation_y", "INTEGER", true, 0, null, 1));
                map.put("open_click_1", new TableInfo.Column("open_click_1", "TEXT", false, 0, null, 1));
                map.put("click_1_x", new TableInfo.Column("click_1_x", "INTEGER", true, 0, null, 1));
                map.put("click_1_y", new TableInfo.Column("click_1_y", "INTEGER", true, 0, null, 1));
                map.put("click_1_width", new TableInfo.Column("click_1_width", "TEXT", false, 0, null, 1));
                map.put("click_1_height", new TableInfo.Column("click_1_height", "TEXT", false, 0, null, 1));
                map.put("open_click_2", new TableInfo.Column("open_click_2", "TEXT", false, 0, null, 1));
                map.put("click_2_x", new TableInfo.Column("click_2_x", "INTEGER", true, 0, null, 1));
                map.put("click_2_y", new TableInfo.Column("click_2_y", "INTEGER", true, 0, null, 1));
                map.put("click_2_width", new TableInfo.Column("click_2_width", "TEXT", false, 0, null, 1));
                map.put("click_2_height", new TableInfo.Column("click_2_height", "TEXT", false, 0, null, 1));
                map.put("open_click_3", new TableInfo.Column("open_click_3", "TEXT", false, 0, null, 1));
                map.put("click_3_x", new TableInfo.Column("click_3_x", "INTEGER", true, 0, null, 1));
                map.put("click_3_y", new TableInfo.Column("click_3_y", "INTEGER", true, 0, null, 1));
                map.put("click_3_width", new TableInfo.Column("click_3_width", "TEXT", false, 0, null, 1));
                map.put("click_3_height", new TableInfo.Column("click_3_height", "TEXT", false, 0, null, 1));
                map.put("open_click_4", new TableInfo.Column("open_click_4", "TEXT", false, 0, null, 1));
                map.put("click_4_x", new TableInfo.Column("click_4_x", "INTEGER", true, 0, null, 1));
                map.put("click_4_y", new TableInfo.Column("click_4_y", "INTEGER", true, 0, null, 1));
                map.put("click_4_width", new TableInfo.Column("click_4_width", "TEXT", false, 0, null, 1));
                map.put("click_4_height", new TableInfo.Column("click_4_height", "TEXT", false, 0, null, 1));
                map.put("show_lunar", new TableInfo.Column("show_lunar", "INTEGER", true, 0, null, 1));
                map.put("lunar_src", new TableInfo.Column("lunar_src", "TEXT", false, 0, null, 1));
                map.put("lunar_x", new TableInfo.Column("lunar_x", "INTEGER", true, 0, null, 1));
                map.put("lunar_y", new TableInfo.Column("lunar_y", "INTEGER", true, 0, null, 1));
                map.put("show_heart", new TableInfo.Column("show_heart", "INTEGER", true, 0, null, 1));
                map.put("heart_src", new TableInfo.Column("heart_src", "TEXT", false, 0, null, 1));
                map.put("heart_x", new TableInfo.Column("heart_x", "INTEGER", true, 0, null, 1));
                map.put("heart_y", new TableInfo.Column("heart_y", "INTEGER", true, 0, null, 1));
                map.put("heart_num_src", new TableInfo.Column("heart_num_src", "TEXT", false, 0, null, 1));
                map.put("heart_num_type", new TableInfo.Column("heart_num_type", "TEXT", false, 0, null, 1));
                map.put("heart_end_src", new TableInfo.Column("heart_end_src", "TEXT", false, 0, null, 1));
                map.put("heart_show_type", new TableInfo.Column("heart_show_type", "INTEGER", true, 0, null, 1));
                map.put("heart_num_x", new TableInfo.Column("heart_num_x", "INTEGER", true, 0, null, 1));
                map.put("heart_num_y", new TableInfo.Column("heart_num_y", "INTEGER", true, 0, null, 1));
                map.put("open_heart_arc_show", new TableInfo.Column("open_heart_arc_show", "INTEGER", true, 0, null, 1));
                map.put("heart_arc_type", new TableInfo.Column("heart_arc_type", "INTEGER", true, 0, null, 1));
                map.put("heart_arc_center_x", new TableInfo.Column("heart_arc_center_x", "INTEGER", true, 0, null, 1));
                map.put("heart_arc_center_y", new TableInfo.Column("heart_arc_center_y", "INTEGER", true, 0, null, 1));
                map.put("show_pressure", new TableInfo.Column("show_pressure", "TEXT", false, 0, null, 1));
                map.put("pressure_src", new TableInfo.Column("pressure_src", "TEXT", false, 0, null, 1));
                map.put("pressure_x", new TableInfo.Column("pressure_x", "INTEGER", true, 0, null, 1));
                map.put("pressure_y", new TableInfo.Column("pressure_y", "INTEGER", true, 0, null, 1));
                map.put("pressure_num_src", new TableInfo.Column("pressure_num_src", "TEXT", false, 0, null, 1));
                map.put("pressure_num_x", new TableInfo.Column("pressure_num_x", "INTEGER", true, 0, null, 1));
                map.put("pressure_num_y", new TableInfo.Column("pressure_num_y", "INTEGER", true, 0, null, 1));
                map.put("pressure_show_type", new TableInfo.Column("pressure_show_type", "TEXT", false, 0, null, 1));
                map.put("pressure_splt_src", new TableInfo.Column("pressure_splt_src", "TEXT", false, 0, null, 1));
                map.put("show_step", new TableInfo.Column("show_step", "INTEGER", true, 0, null, 1));
                map.put("step_src", new TableInfo.Column("step_src", "TEXT", false, 0, null, 1));
                map.put("step_follow_num", new TableInfo.Column("step_follow_num", "INTEGER", true, 0, null, 1));
                map.put("step_x", new TableInfo.Column("step_x", "INTEGER", true, 0, null, 1));
                map.put("step_y", new TableInfo.Column("step_y", "INTEGER", true, 0, null, 1));
                map.put("step_num_src", new TableInfo.Column("step_num_src", "TEXT", false, 0, null, 1));
                map.put("step_num_type", new TableInfo.Column("step_num_type", "INTEGER", true, 0, null, 1));
                map.put("step_show_type", new TableInfo.Column("step_show_type", "INTEGER", true, 0, null, 1));
                map.put("step_num_x", new TableInfo.Column("step_num_x", "INTEGER", true, 0, null, 1));
                map.put("step_num_y", new TableInfo.Column("step_num_y", "INTEGER", true, 0, null, 1));
                map.put("step_end_src", new TableInfo.Column("step_end_src", "TEXT", false, 0, null, 1));
                map.put("show_step_progress", new TableInfo.Column("show_step_progress", "INTEGER", true, 0, null, 1));
                map.put("step_progress_x", new TableInfo.Column("step_progress_x", "INTEGER", true, 0, null, 1));
                map.put("step_progress_y", new TableInfo.Column("step_progress_y", "INTEGER", true, 0, null, 1));
                map.put("step_progress_src", new TableInfo.Column("step_progress_src", "TEXT", false, 0, null, 1));
                map.put("open_step_arc_show", new TableInfo.Column("open_step_arc_show", "INTEGER", true, 0, null, 1));
                map.put("step_arc_type", new TableInfo.Column("step_arc_type", "INTEGER", true, 0, null, 1));
                map.put("step_arc_center_x", new TableInfo.Column("step_arc_center_x", "INTEGER", true, 0, null, 1));
                map.put("step_arc_center_y", new TableInfo.Column("step_arc_center_y", "INTEGER", true, 0, null, 1));
                map.put("show_kcal", new TableInfo.Column("show_kcal", "INTEGER", true, 0, null, 1));
                map.put("kcal_src", new TableInfo.Column("kcal_src", "TEXT", false, 0, null, 1));
                map.put("kcal_x", new TableInfo.Column("kcal_x", "INTEGER", true, 0, null, 1));
                map.put("kcal_y", new TableInfo.Column("kcal_y", "INTEGER", true, 0, null, 1));
                map.put("kcal_num_src", new TableInfo.Column("kcal_num_src", "TEXT", false, 0, null, 1));
                map.put("kcal_num_type", new TableInfo.Column("kcal_num_type", "INTEGER", true, 0, null, 1));
                map.put("kcal_show_type", new TableInfo.Column("kcal_show_type", "INTEGER", true, 0, null, 1));
                map.put("kcal_num_x", new TableInfo.Column("kcal_num_x", "INTEGER", true, 0, null, 1));
                map.put("kcal_num_y", new TableInfo.Column("kcal_num_y", "INTEGER", true, 0, null, 1));
                map.put("kcal_end_src", new TableInfo.Column("kcal_end_src", "TEXT", false, 0, null, 1));
                map.put("show_km", new TableInfo.Column("show_km", "TEXT", false, 0, null, 1));
                map.put("km_src", new TableInfo.Column("km_src", "TEXT", false, 0, null, 1));
                map.put("km_x", new TableInfo.Column("km_x", "INTEGER", true, 0, null, 1));
                map.put("km_y", new TableInfo.Column("km_y", "INTEGER", true, 0, null, 1));
                map.put("km_num_src", new TableInfo.Column("km_num_src", "TEXT", false, 0, null, 1));
                map.put("km_comma_src", new TableInfo.Column("km_comma_src", "TEXT", false, 0, null, 1));
                map.put("km_num_type", new TableInfo.Column("km_num_type", "TEXT", false, 0, null, 1));
                map.put("km_show_type", new TableInfo.Column("km_show_type", "INTEGER", true, 0, null, 1));
                map.put("km_num_x", new TableInfo.Column("km_num_x", "INTEGER", true, 0, null, 1));
                map.put("km_num_y", new TableInfo.Column("km_num_y", "INTEGER", true, 0, null, 1));
                map.put("km_end_src", new TableInfo.Column("km_end_src", "TEXT", false, 0, null, 1));
                map.put("show_weather", new TableInfo.Column("show_weather", "TEXT", false, 0, null, 1));
                map.put("show_temperature", new TableInfo.Column("show_temperature", "TEXT", false, 0, null, 1));
                map.put("temperature_show_type", new TableInfo.Column("temperature_show_type", "INTEGER", true, 0, null, 1));
                map.put("temperature_num_type", new TableInfo.Column("temperature_num_type", "INTEGER", true, 0, null, 1));
                map.put("temperature_x", new TableInfo.Column("temperature_x", "INTEGER", true, 0, null, 1));
                map.put("temperature_y", new TableInfo.Column("temperature_y", "INTEGER", true, 0, null, 1));
                map.put("temperature_x_2", new TableInfo.Column("temperature_x_2", "INTEGER", true, 0, null, 1));
                map.put("temperature_y_2", new TableInfo.Column("temperature_y_2", "INTEGER", true, 0, null, 1));
                map.put("show_now_tem", new TableInfo.Column("show_now_tem", "TEXT", false, 0, null, 1));
                map.put("now_tem_show_type", new TableInfo.Column("now_tem_show_type", "TEXT", false, 0, null, 1));
                map.put("now_tem_x", new TableInfo.Column("now_tem_x", "INTEGER", true, 0, null, 1));
                map.put("now_tem_y", new TableInfo.Column("now_tem_y", "INTEGER", true, 0, null, 1));
                map.put("temperature_num_src", new TableInfo.Column("temperature_num_src", "TEXT", false, 0, null, 1));
                map.put("temperature_sub_src", new TableInfo.Column("temperature_sub_src", "TEXT", false, 0, null, 1));
                map.put("temperature_sign_src", new TableInfo.Column("temperature_sign_src", "TEXT", false, 0, null, 1));
                map.put("temperature_splt_src", new TableInfo.Column("temperature_splt_src", "TEXT", false, 0, null, 1));
                map.put("show_diagram", new TableInfo.Column("show_diagram", "TEXT", false, 0, null, 1));
                map.put("diagram_x", new TableInfo.Column("diagram_x", "INTEGER", true, 0, null, 1));
                map.put("diagram_y", new TableInfo.Column("diagram_y", "INTEGER", true, 0, null, 1));
                map.put("showsignal", new TableInfo.Column("showsignal", "INTEGER", true, 0, null, 1));
                map.put("show_signal", new TableInfo.Column("show_signal", "INTEGER", true, 0, null, 1));
                map.put("signal_src", new TableInfo.Column("signal_src", "TEXT", false, 0, null, 1));
                map.put("signal_x", new TableInfo.Column("signal_x", "INTEGER", true, 0, null, 1));
                map.put("signal_y", new TableInfo.Column("signal_y", "INTEGER", true, 0, null, 1));
                map.put("show_user_name", new TableInfo.Column("show_user_name", "TEXT", false, 0, null, 1));
                map.put("name_show_type", new TableInfo.Column("name_show_type", "TEXT", false, 0, null, 1));
                map.put("name_x", new TableInfo.Column("name_x", "INTEGER", true, 0, null, 1));
                map.put("name_y", new TableInfo.Column("name_y", "INTEGER", true, 0, null, 1));
                map.put("show_operator", new TableInfo.Column("show_operator", "TEXT", false, 0, null, 1));
                map.put("operator_show_type", new TableInfo.Column("operator_show_type", "TEXT", false, 0, null, 1));
                map.put("operator_x", new TableInfo.Column("operator_x", "INTEGER", true, 0, null, 1));
                map.put("operator_y", new TableInfo.Column("operator_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_call", new TableInfo.Column("show_btn_call", "TEXT", false, 0, null, 1));
                map.put("btn_call_src", new TableInfo.Column("btn_call_src", "TEXT", false, 0, null, 1));
                map.put("btn_call_x", new TableInfo.Column("btn_call_x", "INTEGER", true, 0, null, 1));
                map.put("btn_call_y", new TableInfo.Column("btn_call_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_sms", new TableInfo.Column("show_btn_sms", "TEXT", false, 0, null, 1));
                map.put("btn_sms_src", new TableInfo.Column("btn_sms_src", "TEXT", false, 0, null, 1));
                map.put("btn_sms_x", new TableInfo.Column("btn_sms_x", "INTEGER", true, 0, null, 1));
                map.put("btn_sms_y", new TableInfo.Column("btn_sms_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_heart", new TableInfo.Column("show_btn_heart", "TEXT", false, 0, null, 1));
                map.put("is_our_heart", new TableInfo.Column("is_our_heart", "INTEGER", true, 0, null, 1));
                map.put("btn_heart_src", new TableInfo.Column("btn_heart_src", "TEXT", false, 0, null, 1));
                map.put("btn_heart_x", new TableInfo.Column("btn_heart_x", "INTEGER", true, 0, null, 1));
                map.put("btn_heart_y", new TableInfo.Column("btn_heart_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_step", new TableInfo.Column("show_btn_step", "TEXT", false, 0, null, 1));
                map.put("btn_step_src", new TableInfo.Column("btn_step_src", "TEXT", false, 0, null, 1));
                map.put("btn_step_x", new TableInfo.Column("btn_step_x", "INTEGER", true, 0, null, 1));
                map.put("btn_step_y", new TableInfo.Column("btn_step_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_wechat", new TableInfo.Column("show_btn_wechat", "TEXT", false, 0, null, 1));
                map.put("btn_wechat_src", new TableInfo.Column("btn_wechat_src", "TEXT", false, 0, null, 1));
                map.put("btn_wechat_x", new TableInfo.Column("btn_wechat_x", "INTEGER", true, 0, null, 1));
                map.put("btn_wechat_y", new TableInfo.Column("btn_wechat_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_alipay", new TableInfo.Column("show_btn_alipay", "INTEGER", true, 0, null, 1));
                map.put("btn_alipay_src", new TableInfo.Column("btn_alipay_src", "TEXT", false, 0, null, 1));
                map.put("btn_alipay_x", new TableInfo.Column("btn_alipay_x", "INTEGER", true, 0, null, 1));
                map.put("btn_alipay_y", new TableInfo.Column("btn_alipay_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_stopwatch", new TableInfo.Column("show_btn_stopwatch", "INTEGER", true, 0, null, 1));
                map.put("btn_stopwatch_src", new TableInfo.Column("btn_stopwatch_src", "TEXT", false, 0, null, 1));
                map.put("btn_stopwatch_x", new TableInfo.Column("btn_stopwatch_x", "INTEGER", true, 0, null, 1));
                map.put("btn_stopwatch_y", new TableInfo.Column("btn_stopwatch_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_weather", new TableInfo.Column("show_btn_weather", "INTEGER", true, 0, null, 1));
                map.put("show_btn_calo", new TableInfo.Column("show_btn_calo", "INTEGER", true, 0, null, 1));
                map.put("btn_calo_src", new TableInfo.Column("btn_calo_src", "TEXT", false, 0, null, 1));
                map.put("btn_calo_x", new TableInfo.Column("btn_calo_x", "INTEGER", true, 0, null, 1));
                map.put("btn_calo_y", new TableInfo.Column("btn_calo_y", "INTEGER", true, 0, null, 1));
                map.put("temprature_src", new TableInfo.Column("temprature_src", "TEXT", false, 0, null, 1));
                map.put("show_btn_camera", new TableInfo.Column("show_btn_camera", "TEXT", false, 0, null, 1));
                map.put("btn_camera_src", new TableInfo.Column("btn_camera_src", "TEXT", false, 0, null, 1));
                map.put("btn_camera_x", new TableInfo.Column("btn_camera_x", "INTEGER", true, 0, null, 1));
                map.put("btn_camera_y", new TableInfo.Column("btn_camera_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_sos", new TableInfo.Column("show_btn_sos", "TEXT", false, 0, null, 1));
                map.put("btn_sos_src", new TableInfo.Column("btn_sos_src", "TEXT", false, 0, null, 1));
                map.put("btn_sos_x", new TableInfo.Column("btn_sos_x", "INTEGER", true, 0, null, 1));
                map.put("btn_sos_y", new TableInfo.Column("btn_sos_y", "INTEGER", true, 0, null, 1));
                map.put("show_special_1", new TableInfo.Column("show_special_1", "TEXT", false, 0, null, 1));
                map.put("special_1_src", new TableInfo.Column("special_1_src", "TEXT", false, 0, null, 1));
                map.put("special_1_position", new TableInfo.Column("special_1_position", "TEXT", false, 0, null, 1));
                map.put("special_x", new TableInfo.Column("special_x", "INTEGER", true, 0, null, 1));
                map.put("special_y", new TableInfo.Column("special_y", "INTEGER", true, 0, null, 1));
                map.put("support_multiple_change", new TableInfo.Column("support_multiple_change", "INTEGER", true, 0, null, 1));
                map.put("show_lunar_year", new TableInfo.Column("show_lunar_year", "INTEGER", true, 0, null, 1));
                map.put("lunar_day_splt_src", new TableInfo.Column("lunar_day_splt_src", "TEXT", false, 0, null, 1));
                map.put("lunar_month_splt_src", new TableInfo.Column("lunar_month_splt_src", "TEXT", false, 0, null, 1));
                map.put("lunar_year_splt_src", new TableInfo.Column("lunar_year_splt_src", "TEXT", false, 0, null, 1));
                map.put("am_src", new TableInfo.Column("am_src", "TEXT", false, 0, null, 1));
                map.put("pm_src", new TableInfo.Column("pm_src", "TEXT", false, 0, null, 1));
                map.put("show_btn_alarm", new TableInfo.Column("show_btn_alarm", "INTEGER", true, 0, null, 1));
                map.put("btn_alarm_src", new TableInfo.Column("btn_alarm_src", "TEXT", false, 0, null, 1));
                map.put("btn_alarm_x", new TableInfo.Column("btn_alarm_x", "INTEGER", true, 0, null, 1));
                map.put("btn_alarm_y", new TableInfo.Column("btn_alarm_y", "INTEGER", true, 0, null, 1));
                map.put("bg_btn_change", new TableInfo.Column("bg_btn_change", "INTEGER", true, 0, null, 1));
                map.put("bg_btn_index", new TableInfo.Column("bg_btn_index", "INTEGER", true, 0, null, 1));
                map.put("show_btn_music", new TableInfo.Column("show_btn_music", "INTEGER", true, 0, null, 1));
                map.put("btn_music_src", new TableInfo.Column("btn_music_src", "TEXT", false, 0, null, 1));
                map.put("btn_music_x", new TableInfo.Column("btn_music_x", "INTEGER", true, 0, null, 1));
                map.put("btn_music_y", new TableInfo.Column("btn_music_y", "INTEGER", true, 0, null, 1));
                map.put("support_dynamic_change", new TableInfo.Column("support_dynamic_change", "INTEGER", true, 0, null, 1));
                map.put("level", new TableInfo.Column("level", "INTEGER", true, 0, null, 1));
                map.put("parent_id", new TableInfo.Column("parent_id", "TEXT", false, 0, null, 1));
                map.put("next_id", new TableInfo.Column("next_id", "INTEGER", true, 0, null, 1));
                map.put("change_starttime", new TableInfo.Column("change_starttime", "INTEGER", true, 0, null, 1));
                map.put("change_endtime", new TableInfo.Column("change_endtime", "INTEGER", true, 0, null, 1));
                map.put("btn_weather_src", new TableInfo.Column("btn_weather_src", "TEXT", false, 0, null, 1));
                map.put("btn_weather_x", new TableInfo.Column("btn_weather_x", "INTEGER", true, 0, null, 1));
                map.put("btn_weather_y", new TableInfo.Column("btn_weather_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_calories", new TableInfo.Column("show_btn_calories", "INTEGER", true, 0, null, 1));
                map.put("btn_calories_src", new TableInfo.Column("btn_calories_src", "TEXT", false, 0, null, 1));
                map.put("btn_calories_x", new TableInfo.Column("btn_calories_x", "INTEGER", true, 0, null, 1));
                map.put("btn_calories_y", new TableInfo.Column("btn_calories_y", "INTEGER", true, 0, null, 1));
                map.put("support_compass", new TableInfo.Column("support_compass", "INTEGER", true, 0, null, 1));
                map.put("compass_src", new TableInfo.Column("compass_src", "TEXT", false, 0, null, 1));
                map.put("compass_2_src", new TableInfo.Column("compass_2_src", "TEXT", false, 0, null, 1));
                map.put("compass_x", new TableInfo.Column("compass_x", "INTEGER", true, 0, null, 1));
                map.put("compass_y", new TableInfo.Column("compass_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_setting", new TableInfo.Column("show_btn_setting", "INTEGER", true, 0, null, 1));
                map.put("btn_setting_src", new TableInfo.Column("btn_setting_src", "TEXT", false, 0, null, 1));
                map.put("btn_setting_x", new TableInfo.Column("btn_setting_x", "INTEGER", true, 0, null, 1));
                map.put("btn_setting_y", new TableInfo.Column("btn_setting_y", "INTEGER", true, 0, null, 1));
                map.put("support_click_change", new TableInfo.Column("support_click_change", "INTEGER", true, 0, null, 1));
                map.put("click_id_is_current", new TableInfo.Column("click_id_is_current", "INTEGER", true, 0, null, 1));
                map.put("compass_show_detail_degree", new TableInfo.Column("compass_show_detail_degree", "INTEGER", true, 0, null, 1));
                map.put("compass_direction_src", new TableInfo.Column("compass_direction_src", "TEXT", false, 0, null, 1));
                map.put("compass_direction_x", new TableInfo.Column("compass_direction_x", "INTEGER", true, 0, null, 1));
                map.put("compass_direction_y", new TableInfo.Column("compass_direction_y", "INTEGER", true, 0, null, 1));
                map.put("compass_direction_2_src", new TableInfo.Column("compass_direction_2_src", "TEXT", false, 0, null, 1));
                map.put("compass_direction_2_x", new TableInfo.Column("compass_direction_2_x", "INTEGER", true, 0, null, 1));
                map.put("compass_direction_2_y", new TableInfo.Column("compass_direction_2_y", "INTEGER", true, 0, null, 1));
                map.put("compass_direction_3_src", new TableInfo.Column("compass_direction_3_src", "TEXT", false, 0, null, 1));
                map.put("compass_direction_3_x", new TableInfo.Column("compass_direction_3_x", "INTEGER", true, 0, null, 1));
                map.put("compass_direction_3_y", new TableInfo.Column("compass_direction_3_y", "INTEGER", true, 0, null, 1));
                map.put("compass_direction_degree_src", new TableInfo.Column("compass_direction_degree_src", "TEXT", false, 0, null, 1));
                map.put("compass_direction_degree_x", new TableInfo.Column("compass_direction_degree_x", "INTEGER", true, 0, null, 1));
                map.put("compass_direction_degree_y", new TableInfo.Column("compass_direction_degree_y", "INTEGER", true, 0, null, 1));
                map.put("compass_direction_degree_unit", new TableInfo.Column("compass_direction_degree_unit", "TEXT", false, 0, null, 1));
                map.put("compass_degree_1_src", new TableInfo.Column("compass_degree_1_src", "TEXT", false, 0, null, 1));
                map.put("compass_degree_1_x", new TableInfo.Column("compass_degree_1_x", "INTEGER", true, 0, null, 1));
                map.put("compass_degree_1_y", new TableInfo.Column("compass_degree_1_y", "INTEGER", true, 0, null, 1));
                map.put("compass_degree_2_src", new TableInfo.Column("compass_degree_2_src", "TEXT", false, 0, null, 1));
                map.put("compass_degree_2_x", new TableInfo.Column("compass_degree_2_x", "INTEGER", true, 0, null, 1));
                map.put("compass_degree_2_y", new TableInfo.Column("compass_degree_2_y", "INTEGER", true, 0, null, 1));
                map.put("compass_degree_3_src", new TableInfo.Column("compass_degree_3_src", "TEXT", false, 0, null, 1));
                map.put("compass_degree_3_x", new TableInfo.Column("compass_degree_3_x", "INTEGER", true, 0, null, 1));
                map.put("compass_degree_3_y", new TableInfo.Column("compass_degree_3_y", "INTEGER", true, 0, null, 1));
                map.put("show_connect_animation", new TableInfo.Column("show_connect_animation", "INTEGER", true, 0, null, 1));
                map.put("connect_animation_x", new TableInfo.Column("connect_animation_x", "INTEGER", true, 0, null, 1));
                map.put("connect_animation_y", new TableInfo.Column("connect_animation_y", "INTEGER", true, 0, null, 1));
                map.put("connect_animation_count", new TableInfo.Column("connect_animation_count", "INTEGER", true, 0, null, 1));
                map.put("show_state", new TableInfo.Column("show_state", "INTEGER", true, 0, null, 1));
                map.put("state_x", new TableInfo.Column("state_x", "INTEGER", true, 0, null, 1));
                map.put("state_y", new TableInfo.Column("state_y", "INTEGER", true, 0, null, 1));
                map.put("action_1_cut_position", new TableInfo.Column("action_1_cut_position", "INTEGER", true, 0, null, 1));
                map.put("action_2_cut_position", new TableInfo.Column("action_2_cut_position", "INTEGER", true, 0, null, 1));
                map.put("action_3_cut_position", new TableInfo.Column("action_3_cut_position", "INTEGER", true, 0, null, 1));
                map.put("show_btn_googleplay", new TableInfo.Column("show_btn_googleplay", "INTEGER", true, 0, null, 1));
                map.put("btn_googleplay_src", new TableInfo.Column("btn_googleplay_src", "TEXT", false, 0, null, 1));
                map.put("btn_googleplay_x", new TableInfo.Column("btn_googleplay_x", "INTEGER", true, 0, null, 1));
                map.put("btn_googleplay_y", new TableInfo.Column("btn_googleplay_y", "INTEGER", true, 0, null, 1));
                map.put("show_month_2", new TableInfo.Column("show_month_2", "INTEGER", true, 0, null, 1));
                map.put("month_type_2", new TableInfo.Column("month_type_2", "INTEGER", true, 0, null, 1));
                map.put("month_src_2", new TableInfo.Column("month_src_2", "TEXT", false, 0, null, 1));
                map.put("month_x_2", new TableInfo.Column("month_x_2", "INTEGER", true, 0, null, 1));
                map.put("month_y_2", new TableInfo.Column("month_y_2", "INTEGER", true, 0, null, 1));
                map.put("time_special_new", new TableInfo.Column("time_special_new", "INTEGER", true, 0, null, 1));
                map.put("time_special_hour_ten_src", new TableInfo.Column("time_special_hour_ten_src", "TEXT", false, 0, null, 1));
                map.put("time_special_hour_src", new TableInfo.Column("time_special_hour_src", "TEXT", false, 0, null, 1));
                map.put("time_special_min_ten_src", new TableInfo.Column("time_special_min_ten_src", "TEXT", false, 0, null, 1));
                map.put("time_special_min_src", new TableInfo.Column("time_special_min_src", "TEXT", false, 0, null, 1));
                map.put("show_kcal_progress", new TableInfo.Column("show_kcal_progress", "INTEGER", true, 0, null, 1));
                map.put("kcal_progress_x", new TableInfo.Column("kcal_progress_x", "INTEGER", true, 0, null, 1));
                map.put("kcal_progress_y", new TableInfo.Column("kcal_progress_y", "INTEGER", true, 0, null, 1));
                map.put("kcal_progress_src", new TableInfo.Column("kcal_progress_src", "TEXT", false, 0, null, 1));
                map.put("open_kcal_arc_show", new TableInfo.Column("open_kcal_arc_show", "INTEGER", true, 0, null, 1));
                map.put("kcal_arc_type", new TableInfo.Column("kcal_arc_type", "INTEGER", true, 0, null, 1));
                map.put("kcal_arc_center_x", new TableInfo.Column("kcal_arc_center_x", "INTEGER", true, 0, null, 1));
                map.put("kcal_arc_center_y", new TableInfo.Column("kcal_arc_center_y", "INTEGER", true, 0, null, 1));
                map.put("open_power_arc_show", new TableInfo.Column("open_power_arc_show", "INTEGER", true, 0, null, 1));
                map.put("power_arc_type", new TableInfo.Column("power_arc_type", "INTEGER", true, 0, null, 1));
                map.put("power_arc_center_x", new TableInfo.Column("power_arc_center_x", "INTEGER", true, 0, null, 1));
                map.put("power_arc_center_y", new TableInfo.Column("power_arc_center_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_timer", new TableInfo.Column("show_btn_timer", "INTEGER", true, 0, null, 1));
                map.put("btn_timer_src", new TableInfo.Column("btn_timer_src", "TEXT", false, 0, null, 1));
                map.put("btn_timer_x", new TableInfo.Column("btn_timer_x", "INTEGER", true, 0, null, 1));
                map.put("btn_timer_y", new TableInfo.Column("btn_timer_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_sleep", new TableInfo.Column("show_btn_sleep", "INTEGER", true, 0, null, 1));
                map.put("btn_sleep_src", new TableInfo.Column("btn_sleep_src", "TEXT", false, 0, null, 1));
                map.put("btn_sleep_x", new TableInfo.Column("btn_sleep_x", "INTEGER", true, 0, null, 1));
                map.put("btn_sleep_y", new TableInfo.Column("btn_sleep_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_bloodpressure", new TableInfo.Column("show_btn_bloodpressure", "INTEGER", true, 0, null, 1));
                map.put("btn_bloodpressure_src", new TableInfo.Column("btn_bloodpressure_src", "TEXT", false, 0, null, 1));
                map.put("btn_bloodpressure_x", new TableInfo.Column("btn_bloodpressure_x", "INTEGER", true, 0, null, 1));
                map.put("btn_bloodpressure_y", new TableInfo.Column("btn_bloodpressure_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_sport_record", new TableInfo.Column("show_btn_sport_record", "INTEGER", true, 0, null, 1));
                map.put("btn_sport_record_src", new TableInfo.Column("btn_sport_record_src", "TEXT", false, 0, null, 1));
                map.put("btn_sport_record_x", new TableInfo.Column("btn_sport_record_x", "INTEGER", true, 0, null, 1));
                map.put("btn_sport_record_y", new TableInfo.Column("btn_sport_record_y", "INTEGER", true, 0, null, 1));
                map.put("lottie_hierarchy", new TableInfo.Column("lottie_hierarchy", "INTEGER", true, 0, null, 1));
                map.put("show_heart_progress", new TableInfo.Column("show_heart_progress", "INTEGER", true, 0, null, 1));
                map.put("heart_progress_x", new TableInfo.Column("heart_progress_x", "INTEGER", true, 0, null, 1));
                map.put("heart_progress_y", new TableInfo.Column("heart_progress_y", "INTEGER", true, 0, null, 1));
                map.put("heart_progress_src", new TableInfo.Column("heart_progress_src", "TEXT", false, 0, null, 1));
                map.put("show_btn_calculator", new TableInfo.Column("show_btn_calculator", "INTEGER", true, 0, null, 1));
                map.put("btn_calculator_src", new TableInfo.Column("btn_calculator_src", "TEXT", false, 0, null, 1));
                map.put("btn_calculator_x", new TableInfo.Column("btn_calculator_x", "INTEGER", true, 0, null, 1));
                map.put("btn_calculator_y", new TableInfo.Column("btn_calculator_y", "INTEGER", true, 0, null, 1));
                map.put("time_special_drag_3d", new TableInfo.Column("time_special_drag_3d", "INTEGER", true, 0, null, 1));
                map.put("prev_HourTen_Position", new TableInfo.Column("prev_HourTen_Position", "TEXT", false, 0, null, 1));
                map.put("prev_HourGe_Position", new TableInfo.Column("prev_HourGe_Position", "TEXT", false, 0, null, 1));
                map.put("current_HourTen_Position", new TableInfo.Column("current_HourTen_Position", "TEXT", false, 0, null, 1));
                map.put("current_HourGe_Position", new TableInfo.Column("current_HourGe_Position", "TEXT", false, 0, null, 1));
                map.put("next_HourTen_Position", new TableInfo.Column("next_HourTen_Position", "TEXT", false, 0, null, 1));
                map.put("next_HourGe_Position", new TableInfo.Column("next_HourGe_Position", "TEXT", false, 0, null, 1));
                map.put("prev_MinTen_Position", new TableInfo.Column("prev_MinTen_Position", "TEXT", false, 0, null, 1));
                map.put("prev_MinGe_Position", new TableInfo.Column("prev_MinGe_Position", "TEXT", false, 0, null, 1));
                map.put("current_MinTen_Position", new TableInfo.Column("current_MinTen_Position", "TEXT", false, 0, null, 1));
                map.put("current_MinGe_Position", new TableInfo.Column("current_MinGe_Position", "TEXT", false, 0, null, 1));
                map.put("next_MinTen_Position", new TableInfo.Column("next_MinTen_Position", "TEXT", false, 0, null, 1));
                map.put("next_MinGe_Position", new TableInfo.Column("next_MinGe_Position", "TEXT", false, 0, null, 1));
                map.put("need_split_day", new TableInfo.Column("need_split_day", "INTEGER", true, 0, null, 1));
                map.put("split_day_x", new TableInfo.Column("split_day_x", "INTEGER", true, 0, null, 1));
                map.put("split_day_y", new TableInfo.Column("split_day_y", "INTEGER", true, 0, null, 1));
                map.put("open_now_tem_arc_show", new TableInfo.Column("open_now_tem_arc_show", "INTEGER", true, 0, null, 1));
                map.put("now_tem_arc_type", new TableInfo.Column("now_tem_arc_type", "INTEGER", true, 0, null, 1));
                map.put("now_tem_arc_center_x", new TableInfo.Column("now_tem_arc_center_x", "INTEGER", true, 0, null, 1));
                map.put("now_tem_arc_center_y", new TableInfo.Column("now_tem_arc_center_y", "INTEGER", true, 0, null, 1));
                map.put("show_km_progress", new TableInfo.Column("show_km_progress", "INTEGER", true, 0, null, 1));
                map.put("km_progress_x", new TableInfo.Column("km_progress_x", "INTEGER", true, 0, null, 1));
                map.put("km_progress_y", new TableInfo.Column("km_progress_y", "INTEGER", true, 0, null, 1));
                map.put("km_progress_src", new TableInfo.Column("km_progress_src", "TEXT", false, 0, null, 1));
                map.put("open_km_arc_show", new TableInfo.Column("open_km_arc_show", "INTEGER", true, 0, null, 1));
                map.put("km_arc_type", new TableInfo.Column("km_arc_type", "INTEGER", true, 0, null, 1));
                map.put("km_arc_center_x", new TableInfo.Column("km_arc_center_x", "INTEGER", true, 0, null, 1));
                map.put("km_arc_center_y", new TableInfo.Column("km_arc_center_y", "INTEGER", true, 0, null, 1));
                map.put("time_rotate", new TableInfo.Column("time_rotate", "INTEGER", true, 0, null, 1));
                map.put("time_rotate_degree", new TableInfo.Column("time_rotate_degree", "INTEGER", true, 0, null, 1));
                map.put("heart_num_rotate", new TableInfo.Column("heart_num_rotate", "INTEGER", true, 0, null, 1));
                map.put("heart_num_rotate_degree", new TableInfo.Column("heart_num_rotate_degree", "INTEGER", true, 0, null, 1));
                map.put("show_oxygen", new TableInfo.Column("show_oxygen", "INTEGER", true, 0, null, 1));
                map.put("oxygen_src", new TableInfo.Column("oxygen_src", "TEXT", false, 0, null, 1));
                map.put("oxygen_x", new TableInfo.Column("oxygen_x", "INTEGER", true, 0, null, 1));
                map.put("oxygen_y", new TableInfo.Column("oxygen_y", "INTEGER", true, 0, null, 1));
                map.put("oxygen_num_src", new TableInfo.Column("oxygen_num_src", "TEXT", false, 0, null, 1));
                map.put("oxygen_sign_src", new TableInfo.Column("oxygen_sign_src", "TEXT", false, 0, null, 1));
                map.put("oxygen_show_type", new TableInfo.Column("oxygen_show_type", "INTEGER", true, 0, null, 1));
                map.put("oxygen_num_x", new TableInfo.Column("oxygen_num_x", "INTEGER", true, 0, null, 1));
                map.put("oxygen_num_y", new TableInfo.Column("oxygen_num_y", "INTEGER", true, 0, null, 1));
                map.put("time_change_counter", new TableInfo.Column("time_change_counter", "INTEGER", true, 0, null, 1));
                map.put("time_hour_src_2", new TableInfo.Column("time_hour_src_2", "TEXT", false, 0, null, 1));
                map.put("time_min_src_2", new TableInfo.Column("time_min_src_2", "TEXT", false, 0, null, 1));
                map.put("time_sec_src_2", new TableInfo.Column("time_sec_src_2", "TEXT", false, 0, null, 1));
                map.put("time_splt_src_2", new TableInfo.Column("time_splt_src_2", "TEXT", false, 0, null, 1));
                map.put("time_splt_2_src_2", new TableInfo.Column("time_splt_2_src_2", "TEXT", false, 0, null, 1));
                map.put("time_hour_src_3", new TableInfo.Column("time_hour_src_3", "TEXT", false, 0, null, 1));
                map.put("time_min_src_3", new TableInfo.Column("time_min_src_3", "TEXT", false, 0, null, 1));
                map.put("time_sec_src_3", new TableInfo.Column("time_sec_src_3", "TEXT", false, 0, null, 1));
                map.put("time_splt_src_3", new TableInfo.Column("time_splt_src_3", "TEXT", false, 0, null, 1));
                map.put("time_splt_2_src_3", new TableInfo.Column("time_splt_2_src_3", "TEXT", false, 0, null, 1));
                map.put("time_hour_src_4", new TableInfo.Column("time_hour_src_4", "TEXT", false, 0, null, 1));
                map.put("time_min_src_4", new TableInfo.Column("time_min_src_4", "TEXT", false, 0, null, 1));
                map.put("time_sec_src_4", new TableInfo.Column("time_sec_src_4", "TEXT", false, 0, null, 1));
                map.put("time_splt_src_4", new TableInfo.Column("time_splt_src_4", "TEXT", false, 0, null, 1));
                map.put("time_splt_2_src_4", new TableInfo.Column("time_splt_2_src_4", "TEXT", false, 0, null, 1));
                map.put("date_rotate", new TableInfo.Column("date_rotate", "INTEGER", true, 0, null, 1));
                map.put("date_rotate_degree", new TableInfo.Column("date_rotate_degree", "INTEGER", true, 0, null, 1));
                map.put("need_split_hour", new TableInfo.Column("need_split_hour", "INTEGER", true, 0, null, 1));
                map.put("split_hour_src", new TableInfo.Column("split_hour_src", "TEXT", false, 0, null, 1));
                map.put("split_hour_x", new TableInfo.Column("split_hour_x", "INTEGER", true, 0, null, 1));
                map.put("split_hour_y", new TableInfo.Column("split_hour_y", "INTEGER", true, 0, null, 1));
                map.put("need_split_min", new TableInfo.Column("need_split_min", "INTEGER", true, 0, null, 1));
                map.put("split_min_src", new TableInfo.Column("split_min_src", "TEXT", false, 0, null, 1));
                map.put("split_min_x", new TableInfo.Column("split_min_x", "INTEGER", true, 0, null, 1));
                map.put("split_min_y", new TableInfo.Column("split_min_y", "INTEGER", true, 0, null, 1));
                map.put("support_scale", new TableInfo.Column("support_scale", "INTEGER", true, 0, null, 1));
                map.put("show_compass_num", new TableInfo.Column("show_compass_num", "INTEGER", true, 0, null, 1));
                map.put("compass_num_src", new TableInfo.Column("compass_num_src", "TEXT", false, 0, null, 1));
                map.put("compass_show_type", new TableInfo.Column("compass_show_type", "INTEGER", true, 0, null, 1));
                map.put("compass_num_x", new TableInfo.Column("compass_num_x", "INTEGER", true, 0, null, 1));
                map.put("compass_num_y", new TableInfo.Column("compass_num_y", "INTEGER", true, 0, null, 1));
                map.put("compass_num_src_prefix", new TableInfo.Column("compass_num_src_prefix", "TEXT", false, 0, null, 1));
                map.put("compass_num_src_sign", new TableInfo.Column("compass_num_src_sign", "TEXT", false, 0, null, 1));
                map.put("show_btn_oxygen", new TableInfo.Column("show_btn_oxygen", "INTEGER", true, 0, null, 1));
                map.put("btn_oxygen_src", new TableInfo.Column("btn_oxygen_src", "TEXT", false, 0, null, 1));
                map.put("btn_oxygen_x", new TableInfo.Column("btn_oxygen_x", "INTEGER", true, 0, null, 1));
                map.put("btn_oxygen_y", new TableInfo.Column("btn_oxygen_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_calendar", new TableInfo.Column("show_btn_calendar", "INTEGER", true, 0, null, 1));
                map.put("btn_calendar_src", new TableInfo.Column("btn_calendar_src", "TEXT", false, 0, null, 1));
                map.put("btn_calendar_x", new TableInfo.Column("btn_calendar_x", "INTEGER", true, 0, null, 1));
                map.put("btn_calendar_y", new TableInfo.Column("btn_calendar_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_compass", new TableInfo.Column("show_btn_compass", "INTEGER", true, 0, null, 1));
                map.put("btn_compass_src", new TableInfo.Column("btn_compass_src", "TEXT", false, 0, null, 1));
                map.put("btn_compass_x", new TableInfo.Column("btn_compass_x", "INTEGER", true, 0, null, 1));
                map.put("btn_compass_y", new TableInfo.Column("btn_compass_y", "INTEGER", true, 0, null, 1));
                map.put("pointer_disable_scale", new TableInfo.Column("pointer_disable_scale", "INTEGER", true, 0, null, 1));
                map.put("show_chinse_time", new TableInfo.Column("show_chinse_time", "INTEGER", true, 0, null, 1));
                map.put("chinse_time_src", new TableInfo.Column("chinse_time_src", "TEXT", false, 0, null, 1));
                map.put("chinse_time_x", new TableInfo.Column("chinse_time_x", "INTEGER", true, 0, null, 1));
                map.put("chinse_time_y", new TableInfo.Column("chinse_time_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_photo", new TableInfo.Column("show_btn_photo", "INTEGER", true, 0, null, 1));
                map.put("btn_photo_src", new TableInfo.Column("btn_photo_src", "TEXT", false, 0, null, 1));
                map.put("btn_photo_x", new TableInfo.Column("btn_photo_x", "INTEGER", true, 0, null, 1));
                map.put("btn_photo_y", new TableInfo.Column("btn_photo_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_contact", new TableInfo.Column("show_btn_contact", "INTEGER", true, 0, null, 1));
                map.put("btn_contact_src", new TableInfo.Column("btn_contact_src", "TEXT", false, 0, null, 1));
                map.put("btn_contact_x", new TableInfo.Column("btn_contact_x", "INTEGER", true, 0, null, 1));
                map.put("btn_contact_y", new TableInfo.Column("btn_contact_y", "INTEGER", true, 0, null, 1));
                map.put("kcal_num_rotate", new TableInfo.Column("kcal_num_rotate", "INTEGER", true, 0, null, 1));
                map.put("kcal_num_rotate_degree", new TableInfo.Column("kcal_num_rotate_degree", "INTEGER", true, 0, null, 1));
                map.put("show_power_progress", new TableInfo.Column("show_power_progress", "INTEGER", true, 0, null, 1));
                map.put("power_progress_src", new TableInfo.Column("power_progress_src", "TEXT", false, 0, null, 1));
                map.put("power_progress_x", new TableInfo.Column("power_progress_x", "INTEGER", true, 0, null, 1));
                map.put("power_progress_y", new TableInfo.Column("power_progress_y", "INTEGER", true, 0, null, 1));
                map.put("power_src", new TableInfo.Column("power_src", "TEXT", false, 0, null, 1));
                map.put("power_src_x", new TableInfo.Column("power_src_x", "INTEGER", true, 0, null, 1));
                map.put("power_src_y", new TableInfo.Column("power_src_y", "INTEGER", true, 0, null, 1));
                map.put("video_type", new TableInfo.Column("video_type", "INTEGER", true, 0, null, 1));
                map.put("step_keep_number_length", new TableInfo.Column("step_keep_number_length", "INTEGER", true, 0, null, 1));
                map.put("kcal_keep_number_length", new TableInfo.Column("kcal_keep_number_length", "INTEGER", true, 0, null, 1));
                map.put("km_keep_number_length", new TableInfo.Column("km_keep_number_length", "INTEGER", true, 0, null, 1));
                map.put("step_num_rotate", new TableInfo.Column("step_num_rotate", "INTEGER", true, 0, null, 1));
                map.put("step_num_rotate_degree", new TableInfo.Column("step_num_rotate_degree", "INTEGER", true, 0, null, 1));
                map.put("show_btn_style", new TableInfo.Column("show_btn_style", "INTEGER", true, 0, null, 1));
                map.put("btn_style_src", new TableInfo.Column("btn_style_src", "TEXT", false, 0, null, 1));
                map.put("btn_style_x", new TableInfo.Column("btn_style_x", "INTEGER", true, 0, null, 1));
                map.put("btn_style_y", new TableInfo.Column("btn_style_y", "INTEGER", true, 0, null, 1));
                map.put("need_split_sec", new TableInfo.Column("need_split_sec", "INTEGER", true, 0, null, 1));
                map.put("split_sec_src", new TableInfo.Column("split_sec_src", "TEXT", false, 0, null, 1));
                map.put("split_sec_x", new TableInfo.Column("split_sec_x", "INTEGER", true, 0, null, 1));
                map.put("split_sec_y", new TableInfo.Column("split_sec_y", "INTEGER", true, 0, null, 1));
                map.put("open_oxygen_arc_show", new TableInfo.Column("open_oxygen_arc_show", "INTEGER", true, 0, null, 1));
                map.put("oxygen_arc_type", new TableInfo.Column("oxygen_arc_type", "INTEGER", true, 0, null, 1));
                map.put("oxygen_arc_center_x", new TableInfo.Column("oxygen_arc_center_x", "INTEGER", true, 0, null, 1));
                map.put("oxygen_arc_center_y", new TableInfo.Column("oxygen_arc_center_y", "INTEGER", true, 0, null, 1));
                map.put("show_oxygen_progress", new TableInfo.Column("show_oxygen_progress", "INTEGER", true, 0, null, 1));
                map.put("oxygen_progress_src", new TableInfo.Column("oxygen_progress_src", "TEXT", false, 0, null, 1));
                map.put("oxygen_progress_x", new TableInfo.Column("oxygen_progress_x", "INTEGER", true, 0, null, 1));
                map.put("oxygen_progress_y", new TableInfo.Column("oxygen_progress_y", "INTEGER", true, 0, null, 1));
                map.put("show_week_donts", new TableInfo.Column("show_week_donts", "INTEGER", true, 0, null, 1));
                map.put("week_donts_src", new TableInfo.Column("week_donts_src", "TEXT", false, 0, null, 1));
                map.put("week_donts_x", new TableInfo.Column("week_donts_x", "INTEGER", true, 0, null, 1));
                map.put("week_donts_y", new TableInfo.Column("week_donts_y", "INTEGER", true, 0, null, 1));
                map.put("show_btn_flashlight", new TableInfo.Column("show_btn_flashlight", "INTEGER", true, 0, null, 1));
                map.put("flashlight_src", new TableInfo.Column("flashlight_src", "TEXT", false, 0, null, 1));
                map.put("flashlight_x", new TableInfo.Column("flashlight_x", "INTEGER", true, 0, null, 1));
                map.put("flashlight_y", new TableInfo.Column("flashlight_y", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("t_clock_config", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(_db, "t_clock_config");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "t_clock_config(com.dw.launcher.data.entity.ClockConfig).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(3);
                map2.put("date", new TableInfo.Column("date", "TEXT", true, 1, null, 1));
                map2.put("step", new TableInfo.Column("step", "INTEGER", true, 0, null, 1));
                map2.put("initStep", new TableInfo.Column("initStep", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("t_step", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(_db, "t_step");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "t_step(com.dw.launcher.data.entity.StepCountData).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "07965d5d2607a2257c7156c8eacd63b3", "d15326d99acb4e8090a47052bccbf845")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "t_clock_config", "t_step");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `t_clock_config`");
            writableDatabase.execSQL("DELETE FROM `t_step`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(ClockConfigDao.class, ClockConfigDao_Impl.getRequiredConverters());
        map.put(StepDataDao.class, StepDataDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // com.dw.launcher.data.database.LauncherDB
    public ClockConfigDao clockConfigDao() {
        ClockConfigDao clockConfigDao;
        if (this._clockConfigDao != null) {
            return this._clockConfigDao;
        }
        synchronized (this) {
            if (this._clockConfigDao == null) {
                this._clockConfigDao = new ClockConfigDao_Impl(this);
            }
            clockConfigDao = this._clockConfigDao;
        }
        return clockConfigDao;
    }

    @Override // com.dw.launcher.data.database.LauncherDB
    public StepDataDao stepDataDao() {
        StepDataDao stepDataDao;
        if (this._stepDataDao != null) {
            return this._stepDataDao;
        }
        synchronized (this) {
            if (this._stepDataDao == null) {
                this._stepDataDao = new StepDataDao_Impl(this);
            }
            stepDataDao = this._stepDataDao;
        }
        return stepDataDao;
    }
}
