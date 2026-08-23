package com.dw.launcher.data.database.dao;

import android.database.Cursor;
import android.hardware.radio.V1_0.LastCallFailCause;
import android.hardware.radio.V1_0.RadioCdmaSmsConst;
import android.hardware.radio.V1_0.RadioError;
import android.hardware.radio.V1_2.ScanIntervalRange;
import android.telephony.gsm.SmsMessage;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.android.internal.telephony.CallFailCause;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.cat.BerTlv;
import com.android.internal.telephony.gsm.UsimPhoneBookManagerEx;
import com.android.internal.telephony.imsphone.ImsPhoneCallTrackerEx;
import com.android.internal.telephony.uicc.UiccCardApplication;
import com.dw.launcher.data.entity.ClockConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public final class ClockConfigDao_Impl implements ClockConfigDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ClockConfig> __insertionAdapterOfClockConfig;
    private final SharedSQLiteStatement __preparedStmtOfDeleteClockConfigById;
    private final EntityDeletionOrUpdateAdapter<ClockConfig> __updateAdapterOfClockConfig;

    public ClockConfigDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfClockConfig = new EntityInsertionAdapter<ClockConfig>(__db) { // from class: com.dw.launcher.data.database.dao.ClockConfigDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `t_clock_config` (`path`,`fromAssets`,`id`,`name`,`name_en`,`screentype`,`dialtype`,`coordinate_screen_width`,`coordinate_screen_height`,`bg_type`,`video`,`lottie`,`bg_animal_keep_for_last_frame`,`bg_count`,`bg_interval`,`bg_is_customize`,`hour_pointer_src`,`hour_pointer_x`,`hour_pointer_y`,`minute_pointer_src`,`minute_pointer_x`,`minute_pointer_y`,`second_pointer_src`,`second_pointer_type`,`second_pointer_x`,`second_pointer_y`,`second_pointer_animal_type`,`dot_src`,`dot_x`,`dot_y`,`show_pointer_start_animation`,`pointer_start_hour`,`pointer_start_minute`,`pointer_start_second`,`time_hour_src`,`time_min_src`,`time_sec_src`,`time_splt_src`,`time_splt_2_src`,`time_splt_need_jump`,`time_x`,`time_y`,`need_reset_min`,`reset_min_x`,`reset_min_y`,`show_sec`,`need_reset_sec`,`reset_sec_x`,`reset_sec_y`,`open_time_arc_show`,`time_arc_type`,`time_arc_center_x`,`time_arc_center_y`,`show_am_or_pm`,`am_and_pm_src`,`am_or_pm_x`,`am_or_pm_y`,`show_ampm_placeholer`,`show_digital_start_animation`,`digital_start_hour`,`digital_start_minute`,`digital_start_second`,`date_src`,`date_x`,`date_y`,`open_date_arc_show`,`date_arc_type`,`date_arc_center_x`,`date_arc_center_y`,`date_year_splt_src`,`date_month_splt_src`,`date_day_splt_src`,`show_year`,`year_digits_type`,`show_month`,`month_type`,`month_src`,`need_reset_month`,`data_month_num`,`month_x`,`month_y`,`show_day`,`need_reset_day`,`data_day_num`,`day_x`,`day_y`,`day_src`,`day_type`,`week_src`,`week_num_src`,`week_x`,`week_y`,`show_power`,`normal_0_src`,`normal_1_src`,`normal_2_src`,`normal_3_src`,`normal_4_src`,`normal_5_src`,`normal_6_src`,`normal_7_src`,`normal_8_src`,`normal_9_src`,`normal_10_src`,`power_x`,`power_y`,`show_charge`,`charge_0_src`,`charge_1_src`,`charge_2_src`,`charge_3_src`,`charge_4_src`,`charge_5_src`,`charge_6_src`,`charge_7_src`,`charge_8_src`,`charge_9_src`,`charge_10_src`,`show_power_num`,`power_num_src`,`power_sign_src`,`power_show_type`,`power_num_x`,`power_num_y`,`show_action`,`open_action_1`,`action_1_count`,`action_1_x`,`action_1_y`,`open_action_2`,`action_2_count`,`action_2_x`,`action_2_y`,`open_action_3`,`action_3_count`,`action_3_x`,`action_3_y`,`action_interval`,`show_overall_animation`,`overall_animation_x`,`overall_animation_y`,`open_click_1`,`click_1_x`,`click_1_y`,`click_1_width`,`click_1_height`,`open_click_2`,`click_2_x`,`click_2_y`,`click_2_width`,`click_2_height`,`open_click_3`,`click_3_x`,`click_3_y`,`click_3_width`,`click_3_height`,`open_click_4`,`click_4_x`,`click_4_y`,`click_4_width`,`click_4_height`,`show_lunar`,`lunar_src`,`lunar_x`,`lunar_y`,`show_heart`,`heart_src`,`heart_x`,`heart_y`,`heart_num_src`,`heart_num_type`,`heart_end_src`,`heart_show_type`,`heart_num_x`,`heart_num_y`,`open_heart_arc_show`,`heart_arc_type`,`heart_arc_center_x`,`heart_arc_center_y`,`show_pressure`,`pressure_src`,`pressure_x`,`pressure_y`,`pressure_num_src`,`pressure_num_x`,`pressure_num_y`,`pressure_show_type`,`pressure_splt_src`,`show_step`,`step_src`,`step_follow_num`,`step_x`,`step_y`,`step_num_src`,`step_num_type`,`step_show_type`,`step_num_x`,`step_num_y`,`step_end_src`,`show_step_progress`,`step_progress_x`,`step_progress_y`,`step_progress_src`,`open_step_arc_show`,`step_arc_type`,`step_arc_center_x`,`step_arc_center_y`,`show_kcal`,`kcal_src`,`kcal_x`,`kcal_y`,`kcal_num_src`,`kcal_num_type`,`kcal_show_type`,`kcal_num_x`,`kcal_num_y`,`kcal_end_src`,`show_km`,`km_src`,`km_x`,`km_y`,`km_num_src`,`km_comma_src`,`km_num_type`,`km_show_type`,`km_num_x`,`km_num_y`,`km_end_src`,`show_weather`,`show_temperature`,`temperature_show_type`,`temperature_num_type`,`temperature_x`,`temperature_y`,`temperature_x_2`,`temperature_y_2`,`show_now_tem`,`now_tem_show_type`,`now_tem_x`,`now_tem_y`,`temperature_num_src`,`temperature_sub_src`,`temperature_sign_src`,`temperature_splt_src`,`show_diagram`,`diagram_x`,`diagram_y`,`showsignal`,`show_signal`,`signal_src`,`signal_x`,`signal_y`,`show_user_name`,`name_show_type`,`name_x`,`name_y`,`show_operator`,`operator_show_type`,`operator_x`,`operator_y`,`show_btn_call`,`btn_call_src`,`btn_call_x`,`btn_call_y`,`show_btn_sms`,`btn_sms_src`,`btn_sms_x`,`btn_sms_y`,`show_btn_heart`,`is_our_heart`,`btn_heart_src`,`btn_heart_x`,`btn_heart_y`,`show_btn_step`,`btn_step_src`,`btn_step_x`,`btn_step_y`,`show_btn_wechat`,`btn_wechat_src`,`btn_wechat_x`,`btn_wechat_y`,`show_btn_alipay`,`btn_alipay_src`,`btn_alipay_x`,`btn_alipay_y`,`show_btn_stopwatch`,`btn_stopwatch_src`,`btn_stopwatch_x`,`btn_stopwatch_y`,`show_btn_weather`,`show_btn_calo`,`btn_calo_src`,`btn_calo_x`,`btn_calo_y`,`temprature_src`,`show_btn_camera`,`btn_camera_src`,`btn_camera_x`,`btn_camera_y`,`show_btn_sos`,`btn_sos_src`,`btn_sos_x`,`btn_sos_y`,`show_special_1`,`special_1_src`,`special_1_position`,`special_x`,`special_y`,`support_multiple_change`,`show_lunar_year`,`lunar_day_splt_src`,`lunar_month_splt_src`,`lunar_year_splt_src`,`am_src`,`pm_src`,`show_btn_alarm`,`btn_alarm_src`,`btn_alarm_x`,`btn_alarm_y`,`bg_btn_change`,`bg_btn_index`,`show_btn_music`,`btn_music_src`,`btn_music_x`,`btn_music_y`,`support_dynamic_change`,`level`,`parent_id`,`next_id`,`change_starttime`,`change_endtime`,`btn_weather_src`,`btn_weather_x`,`btn_weather_y`,`show_btn_calories`,`btn_calories_src`,`btn_calories_x`,`btn_calories_y`,`support_compass`,`compass_src`,`compass_2_src`,`compass_x`,`compass_y`,`show_btn_setting`,`btn_setting_src`,`btn_setting_x`,`btn_setting_y`,`support_click_change`,`click_id_is_current`,`compass_show_detail_degree`,`compass_direction_src`,`compass_direction_x`,`compass_direction_y`,`compass_direction_2_src`,`compass_direction_2_x`,`compass_direction_2_y`,`compass_direction_3_src`,`compass_direction_3_x`,`compass_direction_3_y`,`compass_direction_degree_src`,`compass_direction_degree_x`,`compass_direction_degree_y`,`compass_direction_degree_unit`,`compass_degree_1_src`,`compass_degree_1_x`,`compass_degree_1_y`,`compass_degree_2_src`,`compass_degree_2_x`,`compass_degree_2_y`,`compass_degree_3_src`,`compass_degree_3_x`,`compass_degree_3_y`,`show_connect_animation`,`connect_animation_x`,`connect_animation_y`,`connect_animation_count`,`show_state`,`state_x`,`state_y`,`action_1_cut_position`,`action_2_cut_position`,`action_3_cut_position`,`show_btn_googleplay`,`btn_googleplay_src`,`btn_googleplay_x`,`btn_googleplay_y`,`show_month_2`,`month_type_2`,`month_src_2`,`month_x_2`,`month_y_2`,`time_special_new`,`time_special_hour_ten_src`,`time_special_hour_src`,`time_special_min_ten_src`,`time_special_min_src`,`show_kcal_progress`,`kcal_progress_x`,`kcal_progress_y`,`kcal_progress_src`,`open_kcal_arc_show`,`kcal_arc_type`,`kcal_arc_center_x`,`kcal_arc_center_y`,`open_power_arc_show`,`power_arc_type`,`power_arc_center_x`,`power_arc_center_y`,`show_btn_timer`,`btn_timer_src`,`btn_timer_x`,`btn_timer_y`,`show_btn_sleep`,`btn_sleep_src`,`btn_sleep_x`,`btn_sleep_y`,`show_btn_bloodpressure`,`btn_bloodpressure_src`,`btn_bloodpressure_x`,`btn_bloodpressure_y`,`show_btn_sport_record`,`btn_sport_record_src`,`btn_sport_record_x`,`btn_sport_record_y`,`lottie_hierarchy`,`show_heart_progress`,`heart_progress_x`,`heart_progress_y`,`heart_progress_src`,`show_btn_calculator`,`btn_calculator_src`,`btn_calculator_x`,`btn_calculator_y`,`time_special_drag_3d`,`prev_HourTen_Position`,`prev_HourGe_Position`,`current_HourTen_Position`,`current_HourGe_Position`,`next_HourTen_Position`,`next_HourGe_Position`,`prev_MinTen_Position`,`prev_MinGe_Position`,`current_MinTen_Position`,`current_MinGe_Position`,`next_MinTen_Position`,`next_MinGe_Position`,`need_split_day`,`split_day_x`,`split_day_y`,`open_now_tem_arc_show`,`now_tem_arc_type`,`now_tem_arc_center_x`,`now_tem_arc_center_y`,`show_km_progress`,`km_progress_x`,`km_progress_y`,`km_progress_src`,`open_km_arc_show`,`km_arc_type`,`km_arc_center_x`,`km_arc_center_y`,`time_rotate`,`time_rotate_degree`,`heart_num_rotate`,`heart_num_rotate_degree`,`show_oxygen`,`oxygen_src`,`oxygen_x`,`oxygen_y`,`oxygen_num_src`,`oxygen_sign_src`,`oxygen_show_type`,`oxygen_num_x`,`oxygen_num_y`,`time_change_counter`,`time_hour_src_2`,`time_min_src_2`,`time_sec_src_2`,`time_splt_src_2`,`time_splt_2_src_2`,`time_hour_src_3`,`time_min_src_3`,`time_sec_src_3`,`time_splt_src_3`,`time_splt_2_src_3`,`time_hour_src_4`,`time_min_src_4`,`time_sec_src_4`,`time_splt_src_4`,`time_splt_2_src_4`,`date_rotate`,`date_rotate_degree`,`need_split_hour`,`split_hour_src`,`split_hour_x`,`split_hour_y`,`need_split_min`,`split_min_src`,`split_min_x`,`split_min_y`,`support_scale`,`show_compass_num`,`compass_num_src`,`compass_show_type`,`compass_num_x`,`compass_num_y`,`compass_num_src_prefix`,`compass_num_src_sign`,`show_btn_oxygen`,`btn_oxygen_src`,`btn_oxygen_x`,`btn_oxygen_y`,`show_btn_calendar`,`btn_calendar_src`,`btn_calendar_x`,`btn_calendar_y`,`show_btn_compass`,`btn_compass_src`,`btn_compass_x`,`btn_compass_y`,`pointer_disable_scale`,`show_chinse_time`,`chinse_time_src`,`chinse_time_x`,`chinse_time_y`,`show_btn_photo`,`btn_photo_src`,`btn_photo_x`,`btn_photo_y`,`show_btn_contact`,`btn_contact_src`,`btn_contact_x`,`btn_contact_y`,`kcal_num_rotate`,`kcal_num_rotate_degree`,`show_power_progress`,`power_progress_src`,`power_progress_x`,`power_progress_y`,`power_src`,`power_src_x`,`power_src_y`,`video_type`,`step_keep_number_length`,`kcal_keep_number_length`,`km_keep_number_length`,`step_num_rotate`,`step_num_rotate_degree`,`show_btn_style`,`btn_style_src`,`btn_style_x`,`btn_style_y`,`need_split_sec`,`split_sec_src`,`split_sec_x`,`split_sec_y`,`open_oxygen_arc_show`,`oxygen_arc_type`,`oxygen_arc_center_x`,`oxygen_arc_center_y`,`show_oxygen_progress`,`oxygen_progress_src`,`oxygen_progress_x`,`oxygen_progress_y`,`show_week_donts`,`week_donts_src`,`week_donts_x`,`week_donts_y`,`show_btn_flashlight`,`flashlight_src`,`flashlight_x`,`flashlight_y`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ClockConfig clockConfig) {
                if (clockConfig.getPath() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, clockConfig.getPath());
                }
                supportSQLiteStatement.bindLong(2, clockConfig.getFromAssets() ? 1L : 0L);
                if (clockConfig.getId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, clockConfig.getId());
                }
                if (clockConfig.getName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, clockConfig.getName());
                }
                if (clockConfig.getName_en() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, clockConfig.getName_en());
                }
                if (clockConfig.getScreentype() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, clockConfig.getScreentype());
                }
                supportSQLiteStatement.bindLong(7, clockConfig.getDialtype());
                supportSQLiteStatement.bindLong(8, clockConfig.getCoordinate_screen_width());
                supportSQLiteStatement.bindLong(9, clockConfig.getCoordinate_screen_height());
                supportSQLiteStatement.bindLong(10, clockConfig.getBg_type());
                if (clockConfig.getVideo() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, clockConfig.getVideo());
                }
                if (clockConfig.getLottie() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, clockConfig.getLottie());
                }
                supportSQLiteStatement.bindLong(13, clockConfig.getBg_animal_keep_for_last_frame());
                supportSQLiteStatement.bindLong(14, clockConfig.getBg_count());
                if (clockConfig.getBg_interval() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, clockConfig.getBg_interval());
                }
                if (clockConfig.getBg_is_customize() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, clockConfig.getBg_is_customize());
                }
                if (clockConfig.getHour_pointer_src() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, clockConfig.getHour_pointer_src());
                }
                supportSQLiteStatement.bindLong(18, clockConfig.getHour_pointer_x());
                supportSQLiteStatement.bindLong(19, clockConfig.getHour_pointer_y());
                if (clockConfig.getMinute_pointer_src() == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, clockConfig.getMinute_pointer_src());
                }
                supportSQLiteStatement.bindLong(21, clockConfig.getMinute_pointer_x());
                supportSQLiteStatement.bindLong(22, clockConfig.getMinute_pointer_y());
                if (clockConfig.getSecond_pointer_src() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindString(23, clockConfig.getSecond_pointer_src());
                }
                supportSQLiteStatement.bindLong(24, clockConfig.getSecond_pointer_type());
                supportSQLiteStatement.bindLong(25, clockConfig.getSecond_pointer_x());
                supportSQLiteStatement.bindLong(26, clockConfig.getSecond_pointer_y());
                supportSQLiteStatement.bindLong(27, clockConfig.getSecond_pointer_animal_type());
                if (clockConfig.getDot_src() == null) {
                    supportSQLiteStatement.bindNull(28);
                } else {
                    supportSQLiteStatement.bindString(28, clockConfig.getDot_src());
                }
                supportSQLiteStatement.bindLong(29, clockConfig.getDot_x());
                supportSQLiteStatement.bindLong(30, clockConfig.getDot_y());
                supportSQLiteStatement.bindLong(31, clockConfig.getShow_pointer_start_animation());
                supportSQLiteStatement.bindLong(32, clockConfig.getPointer_start_hour());
                supportSQLiteStatement.bindLong(33, clockConfig.getPointer_start_minute());
                supportSQLiteStatement.bindLong(34, clockConfig.getPointer_start_second());
                if (clockConfig.getTime_hour_src() == null) {
                    supportSQLiteStatement.bindNull(35);
                } else {
                    supportSQLiteStatement.bindString(35, clockConfig.getTime_hour_src());
                }
                if (clockConfig.getTime_min_src() == null) {
                    supportSQLiteStatement.bindNull(36);
                } else {
                    supportSQLiteStatement.bindString(36, clockConfig.getTime_min_src());
                }
                if (clockConfig.getTime_sec_src() == null) {
                    supportSQLiteStatement.bindNull(37);
                } else {
                    supportSQLiteStatement.bindString(37, clockConfig.getTime_sec_src());
                }
                if (clockConfig.getTime_splt_src() == null) {
                    supportSQLiteStatement.bindNull(38);
                } else {
                    supportSQLiteStatement.bindString(38, clockConfig.getTime_splt_src());
                }
                if (clockConfig.getTime_splt_2_src() == null) {
                    supportSQLiteStatement.bindNull(39);
                } else {
                    supportSQLiteStatement.bindString(39, clockConfig.getTime_splt_2_src());
                }
                supportSQLiteStatement.bindLong(40, clockConfig.getTime_splt_need_jump());
                supportSQLiteStatement.bindLong(41, clockConfig.getTime_x());
                supportSQLiteStatement.bindLong(42, clockConfig.getTime_y());
                supportSQLiteStatement.bindLong(43, clockConfig.getNeed_reset_min());
                supportSQLiteStatement.bindLong(44, clockConfig.getReset_min_x());
                supportSQLiteStatement.bindLong(45, clockConfig.getReset_min_y());
                supportSQLiteStatement.bindLong(46, clockConfig.getShow_sec());
                supportSQLiteStatement.bindLong(47, clockConfig.getNeed_reset_sec());
                supportSQLiteStatement.bindLong(48, clockConfig.getReset_sec_x());
                supportSQLiteStatement.bindLong(49, clockConfig.getReset_sec_y());
                supportSQLiteStatement.bindLong(50, clockConfig.getOpen_time_arc_show());
                supportSQLiteStatement.bindLong(51, clockConfig.getTime_arc_type());
                supportSQLiteStatement.bindLong(52, clockConfig.getTime_arc_center_x());
                supportSQLiteStatement.bindLong(53, clockConfig.getTime_arc_center_y());
                supportSQLiteStatement.bindLong(54, clockConfig.getShow_am_or_pm());
                if (clockConfig.getAm_and_pm_src() == null) {
                    supportSQLiteStatement.bindNull(55);
                } else {
                    supportSQLiteStatement.bindString(55, clockConfig.getAm_and_pm_src());
                }
                supportSQLiteStatement.bindLong(56, clockConfig.getAm_or_pm_x());
                supportSQLiteStatement.bindLong(57, clockConfig.getAm_or_pm_y());
                supportSQLiteStatement.bindLong(58, clockConfig.getShow_ampm_placeholer());
                supportSQLiteStatement.bindLong(59, clockConfig.getShow_digital_start_animation());
                supportSQLiteStatement.bindLong(60, clockConfig.getDigital_start_hour());
                supportSQLiteStatement.bindLong(61, clockConfig.getDigital_start_minute());
                supportSQLiteStatement.bindLong(62, clockConfig.getDigital_start_second());
                if (clockConfig.getDate_src() == null) {
                    supportSQLiteStatement.bindNull(63);
                } else {
                    supportSQLiteStatement.bindString(63, clockConfig.getDate_src());
                }
                supportSQLiteStatement.bindLong(64, clockConfig.getDate_x());
                supportSQLiteStatement.bindLong(65, clockConfig.getDate_y());
                supportSQLiteStatement.bindLong(66, clockConfig.getOpen_date_arc_show());
                supportSQLiteStatement.bindLong(67, clockConfig.getDate_arc_type());
                supportSQLiteStatement.bindLong(68, clockConfig.getDate_arc_center_x());
                supportSQLiteStatement.bindLong(69, clockConfig.getDate_arc_center_y());
                if (clockConfig.getDate_year_splt_src() == null) {
                    supportSQLiteStatement.bindNull(70);
                } else {
                    supportSQLiteStatement.bindString(70, clockConfig.getDate_year_splt_src());
                }
                if (clockConfig.getDate_month_splt_src() == null) {
                    supportSQLiteStatement.bindNull(71);
                } else {
                    supportSQLiteStatement.bindString(71, clockConfig.getDate_month_splt_src());
                }
                if (clockConfig.getDate_day_splt_src() == null) {
                    supportSQLiteStatement.bindNull(72);
                } else {
                    supportSQLiteStatement.bindString(72, clockConfig.getDate_day_splt_src());
                }
                supportSQLiteStatement.bindLong(73, clockConfig.getShow_year());
                supportSQLiteStatement.bindLong(74, clockConfig.getYear_digits_type());
                supportSQLiteStatement.bindLong(75, clockConfig.getShow_month());
                supportSQLiteStatement.bindLong(76, clockConfig.getMonth_type());
                if (clockConfig.getMonth_src() == null) {
                    supportSQLiteStatement.bindNull(77);
                } else {
                    supportSQLiteStatement.bindString(77, clockConfig.getMonth_src());
                }
                supportSQLiteStatement.bindLong(78, clockConfig.getNeed_reset_month());
                if (clockConfig.getData_month_num() == null) {
                    supportSQLiteStatement.bindNull(79);
                } else {
                    supportSQLiteStatement.bindString(79, clockConfig.getData_month_num());
                }
                supportSQLiteStatement.bindLong(80, clockConfig.getMonth_x());
                supportSQLiteStatement.bindLong(81, clockConfig.getMonth_y());
                supportSQLiteStatement.bindLong(82, clockConfig.getShow_day());
                supportSQLiteStatement.bindLong(83, clockConfig.getNeed_reset_day());
                if (clockConfig.getData_day_num() == null) {
                    supportSQLiteStatement.bindNull(84);
                } else {
                    supportSQLiteStatement.bindString(84, clockConfig.getData_day_num());
                }
                supportSQLiteStatement.bindLong(85, clockConfig.getDay_x());
                supportSQLiteStatement.bindLong(86, clockConfig.getDay_y());
                if (clockConfig.getDay_src() == null) {
                    supportSQLiteStatement.bindNull(87);
                } else {
                    supportSQLiteStatement.bindString(87, clockConfig.getDay_src());
                }
                supportSQLiteStatement.bindLong(88, clockConfig.getDay_type());
                if (clockConfig.getWeek_src() == null) {
                    supportSQLiteStatement.bindNull(89);
                } else {
                    supportSQLiteStatement.bindString(89, clockConfig.getWeek_src());
                }
                if (clockConfig.getWeek_num_src() == null) {
                    supportSQLiteStatement.bindNull(90);
                } else {
                    supportSQLiteStatement.bindString(90, clockConfig.getWeek_num_src());
                }
                supportSQLiteStatement.bindLong(91, clockConfig.getWeek_x());
                supportSQLiteStatement.bindLong(92, clockConfig.getWeek_y());
                supportSQLiteStatement.bindLong(93, clockConfig.getShow_power());
                if (clockConfig.getNormal_0_src() == null) {
                    supportSQLiteStatement.bindNull(94);
                } else {
                    supportSQLiteStatement.bindString(94, clockConfig.getNormal_0_src());
                }
                if (clockConfig.getNormal_1_src() == null) {
                    supportSQLiteStatement.bindNull(95);
                } else {
                    supportSQLiteStatement.bindString(95, clockConfig.getNormal_1_src());
                }
                if (clockConfig.getNormal_2_src() == null) {
                    supportSQLiteStatement.bindNull(96);
                } else {
                    supportSQLiteStatement.bindString(96, clockConfig.getNormal_2_src());
                }
                if (clockConfig.getNormal_3_src() == null) {
                    supportSQLiteStatement.bindNull(97);
                } else {
                    supportSQLiteStatement.bindString(97, clockConfig.getNormal_3_src());
                }
                if (clockConfig.getNormal_4_src() == null) {
                    supportSQLiteStatement.bindNull(98);
                } else {
                    supportSQLiteStatement.bindString(98, clockConfig.getNormal_4_src());
                }
                if (clockConfig.getNormal_5_src() == null) {
                    supportSQLiteStatement.bindNull(99);
                } else {
                    supportSQLiteStatement.bindString(99, clockConfig.getNormal_5_src());
                }
                if (clockConfig.getNormal_6_src() == null) {
                    supportSQLiteStatement.bindNull(100);
                } else {
                    supportSQLiteStatement.bindString(100, clockConfig.getNormal_6_src());
                }
                if (clockConfig.getNormal_7_src() == null) {
                    supportSQLiteStatement.bindNull(101);
                } else {
                    supportSQLiteStatement.bindString(101, clockConfig.getNormal_7_src());
                }
                if (clockConfig.getNormal_8_src() == null) {
                    supportSQLiteStatement.bindNull(102);
                } else {
                    supportSQLiteStatement.bindString(102, clockConfig.getNormal_8_src());
                }
                if (clockConfig.getNormal_9_src() == null) {
                    supportSQLiteStatement.bindNull(103);
                } else {
                    supportSQLiteStatement.bindString(103, clockConfig.getNormal_9_src());
                }
                if (clockConfig.getNormal_10_src() == null) {
                    supportSQLiteStatement.bindNull(LocationRequestCompat.QUALITY_LOW_POWER);
                } else {
                    supportSQLiteStatement.bindString(LocationRequestCompat.QUALITY_LOW_POWER, clockConfig.getNormal_10_src());
                }
                supportSQLiteStatement.bindLong(105, clockConfig.getPower_x());
                supportSQLiteStatement.bindLong(106, clockConfig.getPower_y());
                supportSQLiteStatement.bindLong(107, clockConfig.getShow_charge());
                if (clockConfig.getCharge_0_src() == null) {
                    supportSQLiteStatement.bindNull(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
                } else {
                    supportSQLiteStatement.bindString(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, clockConfig.getCharge_0_src());
                }
                if (clockConfig.getCharge_1_src() == null) {
                    supportSQLiteStatement.bindNull(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                } else {
                    supportSQLiteStatement.bindString(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, clockConfig.getCharge_1_src());
                }
                if (clockConfig.getCharge_2_src() == null) {
                    supportSQLiteStatement.bindNull(110);
                } else {
                    supportSQLiteStatement.bindString(110, clockConfig.getCharge_2_src());
                }
                if (clockConfig.getCharge_3_src() == null) {
                    supportSQLiteStatement.bindNull(111);
                } else {
                    supportSQLiteStatement.bindString(111, clockConfig.getCharge_3_src());
                }
                if (clockConfig.getCharge_4_src() == null) {
                    supportSQLiteStatement.bindNull(112);
                } else {
                    supportSQLiteStatement.bindString(112, clockConfig.getCharge_4_src());
                }
                if (clockConfig.getCharge_5_src() == null) {
                    supportSQLiteStatement.bindNull(113);
                } else {
                    supportSQLiteStatement.bindString(113, clockConfig.getCharge_5_src());
                }
                if (clockConfig.getCharge_6_src() == null) {
                    supportSQLiteStatement.bindNull(114);
                } else {
                    supportSQLiteStatement.bindString(114, clockConfig.getCharge_6_src());
                }
                if (clockConfig.getCharge_7_src() == null) {
                    supportSQLiteStatement.bindNull(115);
                } else {
                    supportSQLiteStatement.bindString(115, clockConfig.getCharge_7_src());
                }
                if (clockConfig.getCharge_8_src() == null) {
                    supportSQLiteStatement.bindNull(116);
                } else {
                    supportSQLiteStatement.bindString(116, clockConfig.getCharge_8_src());
                }
                if (clockConfig.getCharge_9_src() == null) {
                    supportSQLiteStatement.bindNull(117);
                } else {
                    supportSQLiteStatement.bindString(117, clockConfig.getCharge_9_src());
                }
                if (clockConfig.getCharge_10_src() == null) {
                    supportSQLiteStatement.bindNull(118);
                } else {
                    supportSQLiteStatement.bindString(118, clockConfig.getCharge_10_src());
                }
                supportSQLiteStatement.bindLong(119, clockConfig.getShow_power_num());
                if (clockConfig.getPower_num_src() == null) {
                    supportSQLiteStatement.bindNull(120);
                } else {
                    supportSQLiteStatement.bindString(120, clockConfig.getPower_num_src());
                }
                if (clockConfig.getPower_sign_src() == null) {
                    supportSQLiteStatement.bindNull(121);
                } else {
                    supportSQLiteStatement.bindString(121, clockConfig.getPower_sign_src());
                }
                supportSQLiteStatement.bindLong(122, clockConfig.getPower_show_type());
                supportSQLiteStatement.bindLong(123, clockConfig.getPower_num_x());
                supportSQLiteStatement.bindLong(124, clockConfig.getPower_num_y());
                supportSQLiteStatement.bindLong(125, clockConfig.getShow_action());
                supportSQLiteStatement.bindLong(126, clockConfig.getOpen_action_1());
                supportSQLiteStatement.bindLong(127, clockConfig.getAction_1_count());
                supportSQLiteStatement.bindLong(128, clockConfig.getAction_1_x());
                supportSQLiteStatement.bindLong(UiccCardApplication.AUTH_CONTEXT_EAP_AKA, clockConfig.getAction_1_y());
                supportSQLiteStatement.bindLong(130, clockConfig.getOpen_action_2());
                supportSQLiteStatement.bindLong(RadioCdmaSmsConst.UDH_EO_DATA_SEGMENT_MAX, clockConfig.getAction_2_count());
                supportSQLiteStatement.bindLong(132, clockConfig.getAction_2_x());
                supportSQLiteStatement.bindLong(133, clockConfig.getAction_2_y());
                supportSQLiteStatement.bindLong(134, clockConfig.getOpen_action_3());
                supportSQLiteStatement.bindLong(135, clockConfig.getAction_3_count());
                supportSQLiteStatement.bindLong(136, clockConfig.getAction_3_x());
                supportSQLiteStatement.bindLong(137, clockConfig.getAction_3_y());
                supportSQLiteStatement.bindLong(138, clockConfig.getAction_interval());
                if (clockConfig.getShow_overall_animation() == null) {
                    supportSQLiteStatement.bindNull(139);
                } else {
                    supportSQLiteStatement.bindString(139, clockConfig.getShow_overall_animation());
                }
                supportSQLiteStatement.bindLong(SmsMessage.MAX_USER_DATA_BYTES, clockConfig.getOverall_animation_x());
                supportSQLiteStatement.bindLong(141, clockConfig.getOverall_animation_y());
                if (clockConfig.getOpen_click_1() == null) {
                    supportSQLiteStatement.bindNull(142);
                } else {
                    supportSQLiteStatement.bindString(142, clockConfig.getOpen_click_1());
                }
                supportSQLiteStatement.bindLong(143, clockConfig.getClick_1_x());
                supportSQLiteStatement.bindLong(144, clockConfig.getClick_1_y());
                if (clockConfig.getClick_1_width() == null) {
                    supportSQLiteStatement.bindNull(145);
                } else {
                    supportSQLiteStatement.bindString(145, clockConfig.getClick_1_width());
                }
                if (clockConfig.getClick_1_height() == null) {
                    supportSQLiteStatement.bindNull(146);
                } else {
                    supportSQLiteStatement.bindString(146, clockConfig.getClick_1_height());
                }
                if (clockConfig.getOpen_click_2() == null) {
                    supportSQLiteStatement.bindNull(147);
                } else {
                    supportSQLiteStatement.bindString(147, clockConfig.getOpen_click_2());
                }
                supportSQLiteStatement.bindLong(148, clockConfig.getClick_2_x());
                supportSQLiteStatement.bindLong(149, clockConfig.getClick_2_y());
                if (clockConfig.getClick_2_width() == null) {
                    supportSQLiteStatement.bindNull(ImsPhoneCallTrackerEx.CODE_LOCAL_CALL_CS_EMERGENCY_RETRY_REQUIRED);
                } else {
                    supportSQLiteStatement.bindString(ImsPhoneCallTrackerEx.CODE_LOCAL_CALL_CS_EMERGENCY_RETRY_REQUIRED, clockConfig.getClick_2_width());
                }
                if (clockConfig.getClick_2_height() == null) {
                    supportSQLiteStatement.bindNull(ImsPhoneCallTrackerEx.CODE_LOCAL_CALL_IMS_HANDOVER_RETRY);
                } else {
                    supportSQLiteStatement.bindString(ImsPhoneCallTrackerEx.CODE_LOCAL_CALL_IMS_HANDOVER_RETRY, clockConfig.getClick_2_height());
                }
                if (clockConfig.getOpen_click_3() == null) {
                    supportSQLiteStatement.bindNull(152);
                } else {
                    supportSQLiteStatement.bindString(152, clockConfig.getOpen_click_3());
                }
                supportSQLiteStatement.bindLong(SmsMessage.MAX_USER_DATA_SEPTETS_WITH_HEADER, clockConfig.getClick_3_x());
                supportSQLiteStatement.bindLong(154, clockConfig.getClick_3_y());
                if (clockConfig.getClick_3_width() == null) {
                    supportSQLiteStatement.bindNull(155);
                } else {
                    supportSQLiteStatement.bindString(155, clockConfig.getClick_3_width());
                }
                if (clockConfig.getClick_3_height() == null) {
                    supportSQLiteStatement.bindNull(156);
                } else {
                    supportSQLiteStatement.bindString(156, clockConfig.getClick_3_height());
                }
                if (clockConfig.getOpen_click_4() == null) {
                    supportSQLiteStatement.bindNull(157);
                } else {
                    supportSQLiteStatement.bindString(157, clockConfig.getOpen_click_4());
                }
                supportSQLiteStatement.bindLong(158, clockConfig.getClick_4_x());
                supportSQLiteStatement.bindLong(159, clockConfig.getClick_4_y());
                if (clockConfig.getClick_4_width() == null) {
                    supportSQLiteStatement.bindNull(SmsMessage.MAX_USER_DATA_SEPTETS);
                } else {
                    supportSQLiteStatement.bindString(SmsMessage.MAX_USER_DATA_SEPTETS, clockConfig.getClick_4_width());
                }
                if (clockConfig.getClick_4_height() == null) {
                    supportSQLiteStatement.bindNull(161);
                } else {
                    supportSQLiteStatement.bindString(161, clockConfig.getClick_4_height());
                }
                supportSQLiteStatement.bindLong(162, clockConfig.getShow_lunar());
                if (clockConfig.getLunar_src() == null) {
                    supportSQLiteStatement.bindNull(163);
                } else {
                    supportSQLiteStatement.bindString(163, clockConfig.getLunar_src());
                }
                supportSQLiteStatement.bindLong(164, clockConfig.getLunar_x());
                supportSQLiteStatement.bindLong(165, clockConfig.getLunar_y());
                supportSQLiteStatement.bindLong(166, clockConfig.getShow_heart());
                if (clockConfig.getHeart_src() == null) {
                    supportSQLiteStatement.bindNull(167);
                } else {
                    supportSQLiteStatement.bindString(167, clockConfig.getHeart_src());
                }
                supportSQLiteStatement.bindLong(UsimPhoneBookManagerEx.USIM_TYPE1_TAG, clockConfig.getHeart_x());
                supportSQLiteStatement.bindLong(UsimPhoneBookManagerEx.USIM_TYPE2_TAG, clockConfig.getHeart_y());
                if (clockConfig.getHeart_num_src() == null) {
                    supportSQLiteStatement.bindNull(170);
                } else {
                    supportSQLiteStatement.bindString(170, clockConfig.getHeart_num_src());
                }
                if (clockConfig.getHeart_num_type() == null) {
                    supportSQLiteStatement.bindNull(171);
                } else {
                    supportSQLiteStatement.bindString(171, clockConfig.getHeart_num_type());
                }
                if (clockConfig.getHeart_end_src() == null) {
                    supportSQLiteStatement.bindNull(172);
                } else {
                    supportSQLiteStatement.bindString(172, clockConfig.getHeart_end_src());
                }
                supportSQLiteStatement.bindLong(173, clockConfig.getHeart_show_type());
                supportSQLiteStatement.bindLong(174, clockConfig.getHeart_num_x());
                supportSQLiteStatement.bindLong(175, clockConfig.getHeart_num_y());
                supportSQLiteStatement.bindLong(176, clockConfig.getOpen_heart_arc_show());
                supportSQLiteStatement.bindLong(177, clockConfig.getHeart_arc_type());
                supportSQLiteStatement.bindLong(178, clockConfig.getHeart_arc_center_x());
                supportSQLiteStatement.bindLong(179, clockConfig.getHeart_arc_center_y());
                if (clockConfig.getShow_pressure() == null) {
                    supportSQLiteStatement.bindNull(180);
                } else {
                    supportSQLiteStatement.bindString(180, clockConfig.getShow_pressure());
                }
                if (clockConfig.getPressure_src() == null) {
                    supportSQLiteStatement.bindNull(181);
                } else {
                    supportSQLiteStatement.bindString(181, clockConfig.getPressure_src());
                }
                supportSQLiteStatement.bindLong(182, clockConfig.getPressure_x());
                supportSQLiteStatement.bindLong(183, clockConfig.getPressure_y());
                if (clockConfig.getPressure_num_src() == null) {
                    supportSQLiteStatement.bindNull(184);
                } else {
                    supportSQLiteStatement.bindString(184, clockConfig.getPressure_num_src());
                }
                supportSQLiteStatement.bindLong(185, clockConfig.getPressure_num_x());
                supportSQLiteStatement.bindLong(186, clockConfig.getPressure_num_y());
                if (clockConfig.getPressure_show_type() == null) {
                    supportSQLiteStatement.bindNull(187);
                } else {
                    supportSQLiteStatement.bindString(187, clockConfig.getPressure_show_type());
                }
                if (clockConfig.getPressure_splt_src() == null) {
                    supportSQLiteStatement.bindNull(188);
                } else {
                    supportSQLiteStatement.bindString(188, clockConfig.getPressure_splt_src());
                }
                supportSQLiteStatement.bindLong(189, clockConfig.getShow_step());
                if (clockConfig.getStep_src() == null) {
                    supportSQLiteStatement.bindNull(190);
                } else {
                    supportSQLiteStatement.bindString(190, clockConfig.getStep_src());
                }
                supportSQLiteStatement.bindLong(191, clockConfig.getStep_follow_num());
                supportSQLiteStatement.bindLong(192, clockConfig.getStep_x());
                supportSQLiteStatement.bindLong(193, clockConfig.getStep_y());
                if (clockConfig.getStep_num_src() == null) {
                    supportSQLiteStatement.bindNull(194);
                } else {
                    supportSQLiteStatement.bindString(194, clockConfig.getStep_num_src());
                }
                supportSQLiteStatement.bindLong(UsimPhoneBookManagerEx.USIM_EFSNE_TAG, clockConfig.getStep_num_type());
                supportSQLiteStatement.bindLong(UsimPhoneBookManagerEx.USIM_EFANR_TAG, clockConfig.getStep_show_type());
                supportSQLiteStatement.bindLong(197, clockConfig.getStep_num_x());
                supportSQLiteStatement.bindLong(UsimPhoneBookManagerEx.USIM_EFGRP_TAG, clockConfig.getStep_num_y());
                if (clockConfig.getStep_end_src() == null) {
                    supportSQLiteStatement.bindNull(UsimPhoneBookManagerEx.USIM_EFAAS_TAG);
                } else {
                    supportSQLiteStatement.bindString(UsimPhoneBookManagerEx.USIM_EFAAS_TAG, clockConfig.getStep_end_src());
                }
                supportSQLiteStatement.bindLong(200, clockConfig.getShow_step_progress());
                supportSQLiteStatement.bindLong(201, clockConfig.getStep_progress_x());
                supportSQLiteStatement.bindLong(UsimPhoneBookManagerEx.USIM_EFEMAIL_TAG, clockConfig.getStep_progress_y());
                if (clockConfig.getStep_progress_src() == null) {
                    supportSQLiteStatement.bindNull(203);
                } else {
                    supportSQLiteStatement.bindString(203, clockConfig.getStep_progress_src());
                }
                supportSQLiteStatement.bindLong(204, clockConfig.getOpen_step_arc_show());
                supportSQLiteStatement.bindLong(205, clockConfig.getStep_arc_type());
                supportSQLiteStatement.bindLong(206, clockConfig.getStep_arc_center_x());
                supportSQLiteStatement.bindLong(207, clockConfig.getStep_arc_center_y());
                supportSQLiteStatement.bindLong(BerTlv.BER_PROACTIVE_COMMAND_TAG, clockConfig.getShow_kcal());
                if (clockConfig.getKcal_src() == null) {
                    supportSQLiteStatement.bindNull(209);
                } else {
                    supportSQLiteStatement.bindString(209, clockConfig.getKcal_src());
                }
                supportSQLiteStatement.bindLong(210, clockConfig.getKcal_x());
                supportSQLiteStatement.bindLong(211, clockConfig.getKcal_y());
                if (clockConfig.getKcal_num_src() == null) {
                    supportSQLiteStatement.bindNull(CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_APP_TOOLKIT_BUSY);
                } else {
                    supportSQLiteStatement.bindString(CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_APP_TOOLKIT_BUSY, clockConfig.getKcal_num_src());
                }
                supportSQLiteStatement.bindLong(CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR, clockConfig.getKcal_num_type());
                supportSQLiteStatement.bindLong(BerTlv.BER_EVENT_DOWNLOAD_TAG, clockConfig.getKcal_show_type());
                supportSQLiteStatement.bindLong(215, clockConfig.getKcal_num_x());
                supportSQLiteStatement.bindLong(216, clockConfig.getKcal_num_y());
                if (clockConfig.getKcal_end_src() == null) {
                    supportSQLiteStatement.bindNull(217);
                } else {
                    supportSQLiteStatement.bindString(217, clockConfig.getKcal_end_src());
                }
                if (clockConfig.getShow_km() == null) {
                    supportSQLiteStatement.bindNull(218);
                } else {
                    supportSQLiteStatement.bindString(218, clockConfig.getShow_km());
                }
                if (clockConfig.getKm_src() == null) {
                    supportSQLiteStatement.bindNull(219);
                } else {
                    supportSQLiteStatement.bindString(219, clockConfig.getKm_src());
                }
                supportSQLiteStatement.bindLong(220, clockConfig.getKm_x());
                supportSQLiteStatement.bindLong(221, clockConfig.getKm_y());
                if (clockConfig.getKm_num_src() == null) {
                    supportSQLiteStatement.bindNull(222);
                } else {
                    supportSQLiteStatement.bindString(222, clockConfig.getKm_num_src());
                }
                if (clockConfig.getKm_comma_src() == null) {
                    supportSQLiteStatement.bindNull(223);
                } else {
                    supportSQLiteStatement.bindString(223, clockConfig.getKm_comma_src());
                }
                if (clockConfig.getKm_num_type() == null) {
                    supportSQLiteStatement.bindNull(224);
                } else {
                    supportSQLiteStatement.bindString(224, clockConfig.getKm_num_type());
                }
                supportSQLiteStatement.bindLong(225, clockConfig.getKm_show_type());
                supportSQLiteStatement.bindLong(RadioCdmaSmsConst.UDH_OTHER_SIZE, clockConfig.getKm_num_x());
                supportSQLiteStatement.bindLong(227, clockConfig.getKm_num_y());
                if (clockConfig.getKm_end_src() == null) {
                    supportSQLiteStatement.bindNull(228);
                } else {
                    supportSQLiteStatement.bindString(228, clockConfig.getKm_end_src());
                }
                if (clockConfig.getShow_weather() == null) {
                    supportSQLiteStatement.bindNull(RadioCdmaSmsConst.USER_DATA_MAX);
                } else {
                    supportSQLiteStatement.bindString(RadioCdmaSmsConst.USER_DATA_MAX, clockConfig.getShow_weather());
                }
                if (clockConfig.getShow_temperature() == null) {
                    supportSQLiteStatement.bindNull(230);
                } else {
                    supportSQLiteStatement.bindString(230, clockConfig.getShow_temperature());
                }
                supportSQLiteStatement.bindLong(231, clockConfig.getTemperature_show_type());
                supportSQLiteStatement.bindLong(232, clockConfig.getTemperature_num_type());
                supportSQLiteStatement.bindLong(233, clockConfig.getTemperature_x());
                supportSQLiteStatement.bindLong(234, clockConfig.getTemperature_y());
                supportSQLiteStatement.bindLong(235, clockConfig.getTemperature_x_2());
                supportSQLiteStatement.bindLong(236, clockConfig.getTemperature_y_2());
                if (clockConfig.getShow_now_tem() == null) {
                    supportSQLiteStatement.bindNull(237);
                } else {
                    supportSQLiteStatement.bindString(237, clockConfig.getShow_now_tem());
                }
                if (clockConfig.getNow_tem_show_type() == null) {
                    supportSQLiteStatement.bindNull(238);
                } else {
                    supportSQLiteStatement.bindString(238, clockConfig.getNow_tem_show_type());
                }
                supportSQLiteStatement.bindLong(239, clockConfig.getNow_tem_x());
                supportSQLiteStatement.bindLong(240, clockConfig.getNow_tem_y());
                if (clockConfig.getTemperature_num_src() == null) {
                    supportSQLiteStatement.bindNull(241);
                } else {
                    supportSQLiteStatement.bindString(241, clockConfig.getTemperature_num_src());
                }
                if (clockConfig.getTemperature_sub_src() == null) {
                    supportSQLiteStatement.bindNull(LastCallFailCause.IMSI_UNKNOWN_IN_VLR);
                } else {
                    supportSQLiteStatement.bindString(LastCallFailCause.IMSI_UNKNOWN_IN_VLR, clockConfig.getTemperature_sub_src());
                }
                if (clockConfig.getTemperature_sign_src() == null) {
                    supportSQLiteStatement.bindNull(243);
                } else {
                    supportSQLiteStatement.bindString(243, clockConfig.getTemperature_sign_src());
                }
                if (clockConfig.getTemperature_splt_src() == null) {
                    supportSQLiteStatement.bindNull(244);
                } else {
                    supportSQLiteStatement.bindString(244, clockConfig.getTemperature_splt_src());
                }
                if (clockConfig.getShow_diagram() == null) {
                    supportSQLiteStatement.bindNull(245);
                } else {
                    supportSQLiteStatement.bindString(245, clockConfig.getShow_diagram());
                }
                supportSQLiteStatement.bindLong(246, clockConfig.getDiagram_x());
                supportSQLiteStatement.bindLong(LastCallFailCause.RADIO_OFF, clockConfig.getDiagram_y());
                supportSQLiteStatement.bindLong(LastCallFailCause.OUT_OF_SERVICE, clockConfig.getShowsignal());
                supportSQLiteStatement.bindLong(LastCallFailCause.NO_VALID_SIM, clockConfig.getShow_signal());
                if (clockConfig.getSignal_src() == null) {
                    supportSQLiteStatement.bindNull(250);
                } else {
                    supportSQLiteStatement.bindString(250, clockConfig.getSignal_src());
                }
                supportSQLiteStatement.bindLong(LastCallFailCause.NETWORK_RESP_TIMEOUT, clockConfig.getSignal_x());
                supportSQLiteStatement.bindLong(LastCallFailCause.NETWORK_REJECT, clockConfig.getSignal_y());
                if (clockConfig.getShow_user_name() == null) {
                    supportSQLiteStatement.bindNull(LastCallFailCause.RADIO_ACCESS_FAILURE);
                } else {
                    supportSQLiteStatement.bindString(LastCallFailCause.RADIO_ACCESS_FAILURE, clockConfig.getShow_user_name());
                }
                if (clockConfig.getName_show_type() == null) {
                    supportSQLiteStatement.bindNull(LastCallFailCause.RADIO_LINK_FAILURE);
                } else {
                    supportSQLiteStatement.bindString(LastCallFailCause.RADIO_LINK_FAILURE, clockConfig.getName_show_type());
                }
                supportSQLiteStatement.bindLong(255, clockConfig.getName_x());
                supportSQLiteStatement.bindLong(256, clockConfig.getName_y());
                if (clockConfig.getShow_operator() == null) {
                    supportSQLiteStatement.bindNull(257);
                } else {
                    supportSQLiteStatement.bindString(257, clockConfig.getShow_operator());
                }
                if (clockConfig.getOperator_show_type() == null) {
                    supportSQLiteStatement.bindNull(LastCallFailCause.RADIO_RELEASE_NORMAL);
                } else {
                    supportSQLiteStatement.bindString(LastCallFailCause.RADIO_RELEASE_NORMAL, clockConfig.getOperator_show_type());
                }
                supportSQLiteStatement.bindLong(LastCallFailCause.RADIO_RELEASE_ABNORMAL, clockConfig.getOperator_x());
                supportSQLiteStatement.bindLong(LastCallFailCause.ACCESS_CLASS_BLOCKED, clockConfig.getOperator_y());
                if (clockConfig.getShow_btn_call() == null) {
                    supportSQLiteStatement.bindNull(LastCallFailCause.NETWORK_DETACH);
                } else {
                    supportSQLiteStatement.bindString(LastCallFailCause.NETWORK_DETACH, clockConfig.getShow_btn_call());
                }
                if (clockConfig.getBtn_call_src() == null) {
                    supportSQLiteStatement.bindNull(262);
                } else {
                    supportSQLiteStatement.bindString(262, clockConfig.getBtn_call_src());
                }
                supportSQLiteStatement.bindLong(263, clockConfig.getBtn_call_x());
                supportSQLiteStatement.bindLong(264, clockConfig.getBtn_call_y());
                if (clockConfig.getShow_btn_sms() == null) {
                    supportSQLiteStatement.bindNull(265);
                } else {
                    supportSQLiteStatement.bindString(265, clockConfig.getShow_btn_sms());
                }
                if (clockConfig.getBtn_sms_src() == null) {
                    supportSQLiteStatement.bindNull(266);
                } else {
                    supportSQLiteStatement.bindString(266, clockConfig.getBtn_sms_src());
                }
                supportSQLiteStatement.bindLong(267, clockConfig.getBtn_sms_x());
                supportSQLiteStatement.bindLong(268, clockConfig.getBtn_sms_y());
                if (clockConfig.getShow_btn_heart() == null) {
                    supportSQLiteStatement.bindNull(269);
                } else {
                    supportSQLiteStatement.bindString(269, clockConfig.getShow_btn_heart());
                }
                supportSQLiteStatement.bindLong(270, clockConfig.getIs_our_heart());
                if (clockConfig.getBtn_heart_src() == null) {
                    supportSQLiteStatement.bindNull(271);
                } else {
                    supportSQLiteStatement.bindString(271, clockConfig.getBtn_heart_src());
                }
                supportSQLiteStatement.bindLong(272, clockConfig.getBtn_heart_x());
                supportSQLiteStatement.bindLong(273, clockConfig.getBtn_heart_y());
                if (clockConfig.getShow_btn_step() == null) {
                    supportSQLiteStatement.bindNull(274);
                } else {
                    supportSQLiteStatement.bindString(274, clockConfig.getShow_btn_step());
                }
                if (clockConfig.getBtn_step_src() == null) {
                    supportSQLiteStatement.bindNull(275);
                } else {
                    supportSQLiteStatement.bindString(275, clockConfig.getBtn_step_src());
                }
                supportSQLiteStatement.bindLong(276, clockConfig.getBtn_step_x());
                supportSQLiteStatement.bindLong(277, clockConfig.getBtn_step_y());
                if (clockConfig.getShow_btn_wechat() == null) {
                    supportSQLiteStatement.bindNull(278);
                } else {
                    supportSQLiteStatement.bindString(278, clockConfig.getShow_btn_wechat());
                }
                if (clockConfig.getBtn_wechat_src() == null) {
                    supportSQLiteStatement.bindNull(279);
                } else {
                    supportSQLiteStatement.bindString(279, clockConfig.getBtn_wechat_src());
                }
                supportSQLiteStatement.bindLong(280, clockConfig.getBtn_wechat_x());
                supportSQLiteStatement.bindLong(281, clockConfig.getBtn_wechat_y());
                supportSQLiteStatement.bindLong(282, clockConfig.getShow_btn_alipay());
                if (clockConfig.getBtn_alipay_src() == null) {
                    supportSQLiteStatement.bindNull(283);
                } else {
                    supportSQLiteStatement.bindString(283, clockConfig.getBtn_alipay_src());
                }
                supportSQLiteStatement.bindLong(284, clockConfig.getBtn_alipay_x());
                supportSQLiteStatement.bindLong(285, clockConfig.getBtn_alipay_y());
                supportSQLiteStatement.bindLong(286, clockConfig.getShow_btn_stopwatch());
                if (clockConfig.getBtn_stopwatch_src() == null) {
                    supportSQLiteStatement.bindNull(287);
                } else {
                    supportSQLiteStatement.bindString(287, clockConfig.getBtn_stopwatch_src());
                }
                supportSQLiteStatement.bindLong(288, clockConfig.getBtn_stopwatch_x());
                supportSQLiteStatement.bindLong(289, clockConfig.getBtn_stopwatch_y());
                supportSQLiteStatement.bindLong(290, clockConfig.getShow_btn_weather());
                supportSQLiteStatement.bindLong(291, clockConfig.getShow_btn_calo());
                if (clockConfig.getBtn_calo_src() == null) {
                    supportSQLiteStatement.bindNull(292);
                } else {
                    supportSQLiteStatement.bindString(292, clockConfig.getBtn_calo_src());
                }
                supportSQLiteStatement.bindLong(293, clockConfig.getBtn_calo_x());
                supportSQLiteStatement.bindLong(294, clockConfig.getBtn_calo_y());
                if (clockConfig.getTemprature_src() == null) {
                    supportSQLiteStatement.bindNull(295);
                } else {
                    supportSQLiteStatement.bindString(295, clockConfig.getTemprature_src());
                }
                if (clockConfig.getShow_btn_camera() == null) {
                    supportSQLiteStatement.bindNull(296);
                } else {
                    supportSQLiteStatement.bindString(296, clockConfig.getShow_btn_camera());
                }
                if (clockConfig.getBtn_camera_src() == null) {
                    supportSQLiteStatement.bindNull(297);
                } else {
                    supportSQLiteStatement.bindString(297, clockConfig.getBtn_camera_src());
                }
                supportSQLiteStatement.bindLong(298, clockConfig.getBtn_camera_x());
                supportSQLiteStatement.bindLong(299, clockConfig.getBtn_camera_y());
                if (clockConfig.getShow_btn_sos() == null) {
                    supportSQLiteStatement.bindNull(ScanIntervalRange.MAX);
                } else {
                    supportSQLiteStatement.bindString(ScanIntervalRange.MAX, clockConfig.getShow_btn_sos());
                }
                if (clockConfig.getBtn_sos_src() == null) {
                    supportSQLiteStatement.bindNull(301);
                } else {
                    supportSQLiteStatement.bindString(301, clockConfig.getBtn_sos_src());
                }
                supportSQLiteStatement.bindLong(302, clockConfig.getBtn_sos_x());
                supportSQLiteStatement.bindLong(303, clockConfig.getBtn_sos_y());
                if (clockConfig.getShow_special_1() == null) {
                    supportSQLiteStatement.bindNull(304);
                } else {
                    supportSQLiteStatement.bindString(304, clockConfig.getShow_special_1());
                }
                if (clockConfig.getSpecial_1_src() == null) {
                    supportSQLiteStatement.bindNull(305);
                } else {
                    supportSQLiteStatement.bindString(305, clockConfig.getSpecial_1_src());
                }
                if (clockConfig.getSpecial_1_position() == null) {
                    supportSQLiteStatement.bindNull(306);
                } else {
                    supportSQLiteStatement.bindString(306, clockConfig.getSpecial_1_position());
                }
                supportSQLiteStatement.bindLong(307, clockConfig.getSpecial_x());
                supportSQLiteStatement.bindLong(308, clockConfig.getSpecial_y());
                supportSQLiteStatement.bindLong(309, clockConfig.getSupport_multiple_change());
                supportSQLiteStatement.bindLong(310, clockConfig.getShow_lunar_year());
                if (clockConfig.getLunar_day_splt_src() == null) {
                    supportSQLiteStatement.bindNull(311);
                } else {
                    supportSQLiteStatement.bindString(311, clockConfig.getLunar_day_splt_src());
                }
                if (clockConfig.getLunar_month_splt_src() == null) {
                    supportSQLiteStatement.bindNull(312);
                } else {
                    supportSQLiteStatement.bindString(312, clockConfig.getLunar_month_splt_src());
                }
                if (clockConfig.getLunar_year_splt_src() == null) {
                    supportSQLiteStatement.bindNull(313);
                } else {
                    supportSQLiteStatement.bindString(313, clockConfig.getLunar_year_splt_src());
                }
                if (clockConfig.getAm_src() == null) {
                    supportSQLiteStatement.bindNull(314);
                } else {
                    supportSQLiteStatement.bindString(314, clockConfig.getAm_src());
                }
                if (clockConfig.getPm_src() == null) {
                    supportSQLiteStatement.bindNull(315);
                } else {
                    supportSQLiteStatement.bindString(315, clockConfig.getPm_src());
                }
                supportSQLiteStatement.bindLong(TypedValues.AttributesType.TYPE_PATH_ROTATE, clockConfig.getShow_btn_alarm());
                if (clockConfig.getBtn_alarm_src() == null) {
                    supportSQLiteStatement.bindNull(TypedValues.AttributesType.TYPE_EASING);
                } else {
                    supportSQLiteStatement.bindString(TypedValues.AttributesType.TYPE_EASING, clockConfig.getBtn_alarm_src());
                }
                supportSQLiteStatement.bindLong(TypedValues.AttributesType.TYPE_PIVOT_TARGET, clockConfig.getBtn_alarm_x());
                supportSQLiteStatement.bindLong(319, clockConfig.getBtn_alarm_y());
                supportSQLiteStatement.bindLong(320, clockConfig.getBg_btn_change());
                supportSQLiteStatement.bindLong(321, clockConfig.getBg_btn_index());
                supportSQLiteStatement.bindLong(322, clockConfig.getShow_btn_music());
                if (clockConfig.getBtn_music_src() == null) {
                    supportSQLiteStatement.bindNull(323);
                } else {
                    supportSQLiteStatement.bindString(323, clockConfig.getBtn_music_src());
                }
                supportSQLiteStatement.bindLong(324, clockConfig.getBtn_music_x());
                supportSQLiteStatement.bindLong(CallFailCause.EMERGENCY_TEMP_FAILURE, clockConfig.getBtn_music_y());
                supportSQLiteStatement.bindLong(CallFailCause.EMERGENCY_PERM_FAILURE, clockConfig.getSupport_dynamic_change());
                supportSQLiteStatement.bindLong(327, clockConfig.getLevel());
                if (clockConfig.getParent_id() == null) {
                    supportSQLiteStatement.bindNull(328);
                } else {
                    supportSQLiteStatement.bindString(328, clockConfig.getParent_id());
                }
                supportSQLiteStatement.bindLong(329, clockConfig.getNext_id());
                supportSQLiteStatement.bindLong(330, clockConfig.getChange_starttime());
                supportSQLiteStatement.bindLong(331, clockConfig.getChange_endtime());
                if (clockConfig.getBtn_weather_src() == null) {
                    supportSQLiteStatement.bindNull(332);
                } else {
                    supportSQLiteStatement.bindString(332, clockConfig.getBtn_weather_src());
                }
                supportSQLiteStatement.bindLong(333, clockConfig.getBtn_weather_x());
                supportSQLiteStatement.bindLong(334, clockConfig.getBtn_weather_y());
                supportSQLiteStatement.bindLong(335, clockConfig.getShow_btn_calories());
                if (clockConfig.getBtn_calories_src() == null) {
                    supportSQLiteStatement.bindNull(336);
                } else {
                    supportSQLiteStatement.bindString(336, clockConfig.getBtn_calories_src());
                }
                supportSQLiteStatement.bindLong(337, clockConfig.getBtn_calories_x());
                supportSQLiteStatement.bindLong(338, clockConfig.getBtn_calories_y());
                supportSQLiteStatement.bindLong(339, clockConfig.getSupport_compass());
                if (clockConfig.getCompass_src() == null) {
                    supportSQLiteStatement.bindNull(340);
                } else {
                    supportSQLiteStatement.bindString(340, clockConfig.getCompass_src());
                }
                if (clockConfig.getCompass_2_src() == null) {
                    supportSQLiteStatement.bindNull(341);
                } else {
                    supportSQLiteStatement.bindString(341, clockConfig.getCompass_2_src());
                }
                supportSQLiteStatement.bindLong(342, clockConfig.getCompass_x());
                supportSQLiteStatement.bindLong(343, clockConfig.getCompass_y());
                supportSQLiteStatement.bindLong(344, clockConfig.getShow_btn_setting());
                if (clockConfig.getBtn_setting_src() == null) {
                    supportSQLiteStatement.bindNull(345);
                } else {
                    supportSQLiteStatement.bindString(345, clockConfig.getBtn_setting_src());
                }
                supportSQLiteStatement.bindLong(346, clockConfig.getBtn_setting_x());
                supportSQLiteStatement.bindLong(347, clockConfig.getBtn_setting_y());
                supportSQLiteStatement.bindLong(348, clockConfig.getSupport_click_change());
                supportSQLiteStatement.bindLong(349, clockConfig.getClick_id_is_current());
                supportSQLiteStatement.bindLong(350, clockConfig.getCompass_show_detail_degree());
                if (clockConfig.getCompass_direction_src() == null) {
                    supportSQLiteStatement.bindNull(351);
                } else {
                    supportSQLiteStatement.bindString(351, clockConfig.getCompass_direction_src());
                }
                supportSQLiteStatement.bindLong(352, clockConfig.getCompass_direction_x());
                supportSQLiteStatement.bindLong(353, clockConfig.getCompass_direction_y());
                if (clockConfig.getCompass_direction_2_src() == null) {
                    supportSQLiteStatement.bindNull(354);
                } else {
                    supportSQLiteStatement.bindString(354, clockConfig.getCompass_direction_2_src());
                }
                supportSQLiteStatement.bindLong(355, clockConfig.getCompass_direction_2_x());
                supportSQLiteStatement.bindLong(356, clockConfig.getCompass_direction_2_y());
                if (clockConfig.getCompass_direction_3_src() == null) {
                    supportSQLiteStatement.bindNull(357);
                } else {
                    supportSQLiteStatement.bindString(357, clockConfig.getCompass_direction_3_src());
                }
                supportSQLiteStatement.bindLong(358, clockConfig.getCompass_direction_3_x());
                supportSQLiteStatement.bindLong(359, clockConfig.getCompass_direction_3_y());
                if (clockConfig.getCompass_direction_degree_src() == null) {
                    supportSQLiteStatement.bindNull(360);
                } else {
                    supportSQLiteStatement.bindString(360, clockConfig.getCompass_direction_degree_src());
                }
                supportSQLiteStatement.bindLong(361, clockConfig.getCompass_direction_degree_x());
                supportSQLiteStatement.bindLong(362, clockConfig.getCompass_direction_degree_y());
                if (clockConfig.getCompass_direction_degree_unit() == null) {
                    supportSQLiteStatement.bindNull(363);
                } else {
                    supportSQLiteStatement.bindString(363, clockConfig.getCompass_direction_degree_unit());
                }
                if (clockConfig.getCompass_degree_1_src() == null) {
                    supportSQLiteStatement.bindNull(364);
                } else {
                    supportSQLiteStatement.bindString(364, clockConfig.getCompass_degree_1_src());
                }
                supportSQLiteStatement.bindLong(365, clockConfig.getCompass_degree_1_x());
                supportSQLiteStatement.bindLong(366, clockConfig.getCompass_degree_1_y());
                if (clockConfig.getCompass_degree_2_src() == null) {
                    supportSQLiteStatement.bindNull(367);
                } else {
                    supportSQLiteStatement.bindString(367, clockConfig.getCompass_degree_2_src());
                }
                supportSQLiteStatement.bindLong(368, clockConfig.getCompass_degree_2_x());
                supportSQLiteStatement.bindLong(369, clockConfig.getCompass_degree_2_y());
                if (clockConfig.getCompass_degree_3_src() == null) {
                    supportSQLiteStatement.bindNull(370);
                } else {
                    supportSQLiteStatement.bindString(370, clockConfig.getCompass_degree_3_src());
                }
                supportSQLiteStatement.bindLong(371, clockConfig.getCompass_degree_3_x());
                supportSQLiteStatement.bindLong(372, clockConfig.getCompass_degree_3_y());
                supportSQLiteStatement.bindLong(373, clockConfig.getShow_connect_animation());
                supportSQLiteStatement.bindLong(374, clockConfig.getConnect_animation_x());
                supportSQLiteStatement.bindLong(375, clockConfig.getConnect_animation_y());
                supportSQLiteStatement.bindLong(376, clockConfig.getConnect_animation_count());
                supportSQLiteStatement.bindLong(377, clockConfig.getShow_state());
                supportSQLiteStatement.bindLong(378, clockConfig.getState_x());
                supportSQLiteStatement.bindLong(379, clockConfig.getState_y());
                supportSQLiteStatement.bindLong(380, clockConfig.getAction_1_cut_position());
                supportSQLiteStatement.bindLong(381, clockConfig.getAction_2_cut_position());
                supportSQLiteStatement.bindLong(382, clockConfig.getAction_3_cut_position());
                supportSQLiteStatement.bindLong(383, clockConfig.getShow_btn_googleplay());
                if (clockConfig.getBtn_googleplay_src() == null) {
                    supportSQLiteStatement.bindNull(384);
                } else {
                    supportSQLiteStatement.bindString(384, clockConfig.getBtn_googleplay_src());
                }
                supportSQLiteStatement.bindLong(385, clockConfig.getBtn_googleplay_x());
                supportSQLiteStatement.bindLong(386, clockConfig.getBtn_googleplay_y());
                supportSQLiteStatement.bindLong(387, clockConfig.getShow_month_2());
                supportSQLiteStatement.bindLong(388, clockConfig.getMonth_type_2());
                if (clockConfig.getMonth_src_2() == null) {
                    supportSQLiteStatement.bindNull(389);
                } else {
                    supportSQLiteStatement.bindString(389, clockConfig.getMonth_src_2());
                }
                supportSQLiteStatement.bindLong(390, clockConfig.getMonth_x_2());
                supportSQLiteStatement.bindLong(391, clockConfig.getMonth_y_2());
                supportSQLiteStatement.bindLong(392, clockConfig.getTime_special_new());
                if (clockConfig.getTime_special_hour_ten_src() == null) {
                    supportSQLiteStatement.bindNull(393);
                } else {
                    supportSQLiteStatement.bindString(393, clockConfig.getTime_special_hour_ten_src());
                }
                if (clockConfig.getTime_special_hour_src() == null) {
                    supportSQLiteStatement.bindNull(394);
                } else {
                    supportSQLiteStatement.bindString(394, clockConfig.getTime_special_hour_src());
                }
                if (clockConfig.getTime_special_min_ten_src() == null) {
                    supportSQLiteStatement.bindNull(395);
                } else {
                    supportSQLiteStatement.bindString(395, clockConfig.getTime_special_min_ten_src());
                }
                if (clockConfig.getTime_special_min_src() == null) {
                    supportSQLiteStatement.bindNull(396);
                } else {
                    supportSQLiteStatement.bindString(396, clockConfig.getTime_special_min_src());
                }
                supportSQLiteStatement.bindLong(397, clockConfig.getShow_kcal_progress());
                supportSQLiteStatement.bindLong(398, clockConfig.getKcal_progress_x());
                supportSQLiteStatement.bindLong(399, clockConfig.getKcal_progress_y());
                if (clockConfig.getKcal_progress_src() == null) {
                    supportSQLiteStatement.bindNull(400);
                } else {
                    supportSQLiteStatement.bindString(400, clockConfig.getKcal_progress_src());
                }
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_CURVE_FIT, clockConfig.getOpen_kcal_arc_show());
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_VISIBILITY, clockConfig.getKcal_arc_type());
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_ALPHA, clockConfig.getKcal_arc_center_x());
                supportSQLiteStatement.bindLong(404, clockConfig.getKcal_arc_center_y());
                supportSQLiteStatement.bindLong(405, clockConfig.getOpen_power_arc_show());
                supportSQLiteStatement.bindLong(406, clockConfig.getPower_arc_type());
                supportSQLiteStatement.bindLong(407, clockConfig.getPower_arc_center_x());
                supportSQLiteStatement.bindLong(408, clockConfig.getPower_arc_center_y());
                supportSQLiteStatement.bindLong(409, clockConfig.getShow_btn_timer());
                if (clockConfig.getBtn_timer_src() == null) {
                    supportSQLiteStatement.bindNull(410);
                } else {
                    supportSQLiteStatement.bindString(410, clockConfig.getBtn_timer_src());
                }
                supportSQLiteStatement.bindLong(411, clockConfig.getBtn_timer_x());
                supportSQLiteStatement.bindLong(412, clockConfig.getBtn_timer_y());
                supportSQLiteStatement.bindLong(413, clockConfig.getShow_btn_sleep());
                if (clockConfig.getBtn_sleep_src() == null) {
                    supportSQLiteStatement.bindNull(414);
                } else {
                    supportSQLiteStatement.bindString(414, clockConfig.getBtn_sleep_src());
                }
                supportSQLiteStatement.bindLong(415, clockConfig.getBtn_sleep_x());
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_PATH_ROTATE, clockConfig.getBtn_sleep_y());
                supportSQLiteStatement.bindLong(417, clockConfig.getShow_btn_bloodpressure());
                if (clockConfig.getBtn_bloodpressure_src() == null) {
                    supportSQLiteStatement.bindNull(418);
                } else {
                    supportSQLiteStatement.bindString(418, clockConfig.getBtn_bloodpressure_src());
                }
                supportSQLiteStatement.bindLong(419, clockConfig.getBtn_bloodpressure_x());
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_EASING, clockConfig.getBtn_bloodpressure_y());
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_WAVE_SHAPE, clockConfig.getShow_btn_sport_record());
                if (clockConfig.getBtn_sport_record_src() == null) {
                    supportSQLiteStatement.bindNull(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE);
                } else {
                    supportSQLiteStatement.bindString(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, clockConfig.getBtn_sport_record_src());
                }
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_WAVE_PERIOD, clockConfig.getBtn_sport_record_x());
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_WAVE_OFFSET, clockConfig.getBtn_sport_record_y());
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_WAVE_PHASE, clockConfig.getLottie_hierarchy());
                supportSQLiteStatement.bindLong(426, clockConfig.getShow_heart_progress());
                supportSQLiteStatement.bindLong(427, clockConfig.getHeart_progress_x());
                supportSQLiteStatement.bindLong(428, clockConfig.getHeart_progress_y());
                if (clockConfig.getHeart_progress_src() == null) {
                    supportSQLiteStatement.bindNull(429);
                } else {
                    supportSQLiteStatement.bindString(429, clockConfig.getHeart_progress_src());
                }
                supportSQLiteStatement.bindLong(430, clockConfig.getShow_btn_calculator());
                if (clockConfig.getBtn_calculator_src() == null) {
                    supportSQLiteStatement.bindNull(431);
                } else {
                    supportSQLiteStatement.bindString(431, clockConfig.getBtn_calculator_src());
                }
                supportSQLiteStatement.bindLong(432, clockConfig.getBtn_calculator_x());
                supportSQLiteStatement.bindLong(433, clockConfig.getBtn_calculator_y());
                supportSQLiteStatement.bindLong(434, clockConfig.getTime_special_drag_3d());
                if (clockConfig.getPrev_HourTen_Position() == null) {
                    supportSQLiteStatement.bindNull(435);
                } else {
                    supportSQLiteStatement.bindString(435, clockConfig.getPrev_HourTen_Position());
                }
                if (clockConfig.getPrev_HourGe_Position() == null) {
                    supportSQLiteStatement.bindNull(436);
                } else {
                    supportSQLiteStatement.bindString(436, clockConfig.getPrev_HourGe_Position());
                }
                if (clockConfig.getCurrent_HourTen_Position() == null) {
                    supportSQLiteStatement.bindNull(437);
                } else {
                    supportSQLiteStatement.bindString(437, clockConfig.getCurrent_HourTen_Position());
                }
                if (clockConfig.getCurrent_HourGe_Position() == null) {
                    supportSQLiteStatement.bindNull(438);
                } else {
                    supportSQLiteStatement.bindString(438, clockConfig.getCurrent_HourGe_Position());
                }
                if (clockConfig.getNext_HourTen_Position() == null) {
                    supportSQLiteStatement.bindNull(439);
                } else {
                    supportSQLiteStatement.bindString(439, clockConfig.getNext_HourTen_Position());
                }
                if (clockConfig.getNext_HourGe_Position() == null) {
                    supportSQLiteStatement.bindNull(440);
                } else {
                    supportSQLiteStatement.bindString(440, clockConfig.getNext_HourGe_Position());
                }
                if (clockConfig.getPrev_MinTen_Position() == null) {
                    supportSQLiteStatement.bindNull(441);
                } else {
                    supportSQLiteStatement.bindString(441, clockConfig.getPrev_MinTen_Position());
                }
                if (clockConfig.getPrev_MinGe_Position() == null) {
                    supportSQLiteStatement.bindNull(442);
                } else {
                    supportSQLiteStatement.bindString(442, clockConfig.getPrev_MinGe_Position());
                }
                if (clockConfig.getCurrent_MinTen_Position() == null) {
                    supportSQLiteStatement.bindNull(443);
                } else {
                    supportSQLiteStatement.bindString(443, clockConfig.getCurrent_MinTen_Position());
                }
                if (clockConfig.getCurrent_MinGe_Position() == null) {
                    supportSQLiteStatement.bindNull(444);
                } else {
                    supportSQLiteStatement.bindString(444, clockConfig.getCurrent_MinGe_Position());
                }
                if (clockConfig.getNext_MinTen_Position() == null) {
                    supportSQLiteStatement.bindNull(445);
                } else {
                    supportSQLiteStatement.bindString(445, clockConfig.getNext_MinTen_Position());
                }
                if (clockConfig.getNext_MinGe_Position() == null) {
                    supportSQLiteStatement.bindNull(446);
                } else {
                    supportSQLiteStatement.bindString(446, clockConfig.getNext_MinGe_Position());
                }
                supportSQLiteStatement.bindLong(447, clockConfig.getNeed_split_day());
                supportSQLiteStatement.bindLong(448, clockConfig.getSplit_day_x());
                supportSQLiteStatement.bindLong(449, clockConfig.getSplit_day_y());
                supportSQLiteStatement.bindLong(450, clockConfig.getOpen_now_tem_arc_show());
                supportSQLiteStatement.bindLong(451, clockConfig.getNow_tem_arc_type());
                supportSQLiteStatement.bindLong(452, clockConfig.getNow_tem_arc_center_x());
                supportSQLiteStatement.bindLong(453, clockConfig.getNow_tem_arc_center_y());
                supportSQLiteStatement.bindLong(454, clockConfig.getShow_km_progress());
                supportSQLiteStatement.bindLong(455, clockConfig.getKm_progress_x());
                supportSQLiteStatement.bindLong(456, clockConfig.getKm_progress_y());
                if (clockConfig.getKm_progress_src() == null) {
                    supportSQLiteStatement.bindNull(457);
                } else {
                    supportSQLiteStatement.bindString(457, clockConfig.getKm_progress_src());
                }
                supportSQLiteStatement.bindLong(458, clockConfig.getOpen_km_arc_show());
                supportSQLiteStatement.bindLong(459, clockConfig.getKm_arc_type());
                supportSQLiteStatement.bindLong(460, clockConfig.getKm_arc_center_x());
                supportSQLiteStatement.bindLong(461, clockConfig.getKm_arc_center_y());
                supportSQLiteStatement.bindLong(462, clockConfig.getTime_rotate());
                supportSQLiteStatement.bindLong(463, clockConfig.getTime_rotate_degree());
                supportSQLiteStatement.bindLong(464, clockConfig.getHeart_num_rotate());
                supportSQLiteStatement.bindLong(465, clockConfig.getHeart_num_rotate_degree());
                supportSQLiteStatement.bindLong(466, clockConfig.getShow_oxygen());
                if (clockConfig.getOxygen_src() == null) {
                    supportSQLiteStatement.bindNull(467);
                } else {
                    supportSQLiteStatement.bindString(467, clockConfig.getOxygen_src());
                }
                supportSQLiteStatement.bindLong(468, clockConfig.getOxygen_x());
                supportSQLiteStatement.bindLong(469, clockConfig.getOxygen_y());
                if (clockConfig.getOxygen_num_src() == null) {
                    supportSQLiteStatement.bindNull(470);
                } else {
                    supportSQLiteStatement.bindString(470, clockConfig.getOxygen_num_src());
                }
                if (clockConfig.getOxygen_sign_src() == null) {
                    supportSQLiteStatement.bindNull(471);
                } else {
                    supportSQLiteStatement.bindString(471, clockConfig.getOxygen_sign_src());
                }
                supportSQLiteStatement.bindLong(472, clockConfig.getOxygen_show_type());
                supportSQLiteStatement.bindLong(473, clockConfig.getOxygen_num_x());
                supportSQLiteStatement.bindLong(474, clockConfig.getOxygen_num_y());
                supportSQLiteStatement.bindLong(475, clockConfig.getTime_change_counter());
                if (clockConfig.getTime_hour_src_2() == null) {
                    supportSQLiteStatement.bindNull(476);
                } else {
                    supportSQLiteStatement.bindString(476, clockConfig.getTime_hour_src_2());
                }
                if (clockConfig.getTime_min_src_2() == null) {
                    supportSQLiteStatement.bindNull(477);
                } else {
                    supportSQLiteStatement.bindString(477, clockConfig.getTime_min_src_2());
                }
                if (clockConfig.getTime_sec_src_2() == null) {
                    supportSQLiteStatement.bindNull(478);
                } else {
                    supportSQLiteStatement.bindString(478, clockConfig.getTime_sec_src_2());
                }
                if (clockConfig.getTime_splt_src_2() == null) {
                    supportSQLiteStatement.bindNull(479);
                } else {
                    supportSQLiteStatement.bindString(479, clockConfig.getTime_splt_src_2());
                }
                if (clockConfig.getTime_splt_2_src_2() == null) {
                    supportSQLiteStatement.bindNull(480);
                } else {
                    supportSQLiteStatement.bindString(480, clockConfig.getTime_splt_2_src_2());
                }
                if (clockConfig.getTime_hour_src_3() == null) {
                    supportSQLiteStatement.bindNull(481);
                } else {
                    supportSQLiteStatement.bindString(481, clockConfig.getTime_hour_src_3());
                }
                if (clockConfig.getTime_min_src_3() == null) {
                    supportSQLiteStatement.bindNull(482);
                } else {
                    supportSQLiteStatement.bindString(482, clockConfig.getTime_min_src_3());
                }
                if (clockConfig.getTime_sec_src_3() == null) {
                    supportSQLiteStatement.bindNull(483);
                } else {
                    supportSQLiteStatement.bindString(483, clockConfig.getTime_sec_src_3());
                }
                if (clockConfig.getTime_splt_src_3() == null) {
                    supportSQLiteStatement.bindNull(484);
                } else {
                    supportSQLiteStatement.bindString(484, clockConfig.getTime_splt_src_3());
                }
                if (clockConfig.getTime_splt_2_src_3() == null) {
                    supportSQLiteStatement.bindNull(485);
                } else {
                    supportSQLiteStatement.bindString(485, clockConfig.getTime_splt_2_src_3());
                }
                if (clockConfig.getTime_hour_src_4() == null) {
                    supportSQLiteStatement.bindNull(486);
                } else {
                    supportSQLiteStatement.bindString(486, clockConfig.getTime_hour_src_4());
                }
                if (clockConfig.getTime_min_src_4() == null) {
                    supportSQLiteStatement.bindNull(487);
                } else {
                    supportSQLiteStatement.bindString(487, clockConfig.getTime_min_src_4());
                }
                if (clockConfig.getTime_sec_src_4() == null) {
                    supportSQLiteStatement.bindNull(488);
                } else {
                    supportSQLiteStatement.bindString(488, clockConfig.getTime_sec_src_4());
                }
                if (clockConfig.getTime_splt_src_4() == null) {
                    supportSQLiteStatement.bindNull(489);
                } else {
                    supportSQLiteStatement.bindString(489, clockConfig.getTime_splt_src_4());
                }
                if (clockConfig.getTime_splt_2_src_4() == null) {
                    supportSQLiteStatement.bindNull(490);
                } else {
                    supportSQLiteStatement.bindString(490, clockConfig.getTime_splt_2_src_4());
                }
                supportSQLiteStatement.bindLong(491, clockConfig.getDate_rotate());
                supportSQLiteStatement.bindLong(492, clockConfig.getDate_rotate_degree());
                supportSQLiteStatement.bindLong(493, clockConfig.getNeed_split_hour());
                if (clockConfig.getSplit_hour_src() == null) {
                    supportSQLiteStatement.bindNull(494);
                } else {
                    supportSQLiteStatement.bindString(494, clockConfig.getSplit_hour_src());
                }
                supportSQLiteStatement.bindLong(495, clockConfig.getSplit_hour_x());
                supportSQLiteStatement.bindLong(496, clockConfig.getSplit_hour_y());
                supportSQLiteStatement.bindLong(497, clockConfig.getNeed_split_min());
                if (clockConfig.getSplit_min_src() == null) {
                    supportSQLiteStatement.bindNull(498);
                } else {
                    supportSQLiteStatement.bindString(498, clockConfig.getSplit_min_src());
                }
                supportSQLiteStatement.bindLong(499, clockConfig.getSplit_min_x());
                supportSQLiteStatement.bindLong(500, clockConfig.getSplit_min_y());
                supportSQLiteStatement.bindLong(501, clockConfig.getSupport_scale());
                supportSQLiteStatement.bindLong(502, clockConfig.getShow_compass_num());
                if (clockConfig.getCompass_num_src() == null) {
                    supportSQLiteStatement.bindNull(503);
                } else {
                    supportSQLiteStatement.bindString(503, clockConfig.getCompass_num_src());
                }
                supportSQLiteStatement.bindLong(504, clockConfig.getCompass_show_type());
                supportSQLiteStatement.bindLong(505, clockConfig.getCompass_num_x());
                supportSQLiteStatement.bindLong(506, clockConfig.getCompass_num_y());
                if (clockConfig.getCompass_num_src_prefix() == null) {
                    supportSQLiteStatement.bindNull(507);
                } else {
                    supportSQLiteStatement.bindString(507, clockConfig.getCompass_num_src_prefix());
                }
                if (clockConfig.getCompass_num_src_sign() == null) {
                    supportSQLiteStatement.bindNull(508);
                } else {
                    supportSQLiteStatement.bindString(508, clockConfig.getCompass_num_src_sign());
                }
                supportSQLiteStatement.bindLong(509, clockConfig.getShow_btn_oxygen());
                if (clockConfig.getBtn_oxygen_src() == null) {
                    supportSQLiteStatement.bindNull(510);
                } else {
                    supportSQLiteStatement.bindString(510, clockConfig.getBtn_oxygen_src());
                }
                supportSQLiteStatement.bindLong(511, clockConfig.getBtn_oxygen_x());
                supportSQLiteStatement.bindLong(512, clockConfig.getBtn_oxygen_y());
                supportSQLiteStatement.bindLong(513, clockConfig.getShow_btn_calendar());
                if (clockConfig.getBtn_calendar_src() == null) {
                    supportSQLiteStatement.bindNull(RadioError.OEM_ERROR_14);
                } else {
                    supportSQLiteStatement.bindString(RadioError.OEM_ERROR_14, clockConfig.getBtn_calendar_src());
                }
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_15, clockConfig.getBtn_calendar_x());
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_16, clockConfig.getBtn_calendar_y());
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_17, clockConfig.getShow_btn_compass());
                if (clockConfig.getBtn_compass_src() == null) {
                    supportSQLiteStatement.bindNull(RadioError.OEM_ERROR_18);
                } else {
                    supportSQLiteStatement.bindString(RadioError.OEM_ERROR_18, clockConfig.getBtn_compass_src());
                }
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_19, clockConfig.getBtn_compass_x());
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_20, clockConfig.getBtn_compass_y());
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_21, clockConfig.getPointer_disable_scale());
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_22, clockConfig.getShow_chinse_time());
                if (clockConfig.getChinse_time_src() == null) {
                    supportSQLiteStatement.bindNull(RadioError.OEM_ERROR_23);
                } else {
                    supportSQLiteStatement.bindString(RadioError.OEM_ERROR_23, clockConfig.getChinse_time_src());
                }
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_24, clockConfig.getChinse_time_x());
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_25, clockConfig.getChinse_time_y());
                supportSQLiteStatement.bindLong(526, clockConfig.getShow_btn_photo());
                if (clockConfig.getBtn_photo_src() == null) {
                    supportSQLiteStatement.bindNull(527);
                } else {
                    supportSQLiteStatement.bindString(527, clockConfig.getBtn_photo_src());
                }
                supportSQLiteStatement.bindLong(528, clockConfig.getBtn_photo_x());
                supportSQLiteStatement.bindLong(529, clockConfig.getBtn_photo_y());
                supportSQLiteStatement.bindLong(530, clockConfig.getShow_btn_contact());
                if (clockConfig.getBtn_contact_src() == null) {
                    supportSQLiteStatement.bindNull(531);
                } else {
                    supportSQLiteStatement.bindString(531, clockConfig.getBtn_contact_src());
                }
                supportSQLiteStatement.bindLong(532, clockConfig.getBtn_contact_x());
                supportSQLiteStatement.bindLong(533, clockConfig.getBtn_contact_y());
                supportSQLiteStatement.bindLong(534, clockConfig.getKcal_num_rotate());
                supportSQLiteStatement.bindLong(535, clockConfig.getKcal_num_rotate_degree());
                supportSQLiteStatement.bindLong(536, clockConfig.getShow_power_progress());
                if (clockConfig.getPower_progress_src() == null) {
                    supportSQLiteStatement.bindNull(537);
                } else {
                    supportSQLiteStatement.bindString(537, clockConfig.getPower_progress_src());
                }
                supportSQLiteStatement.bindLong(538, clockConfig.getPower_progress_x());
                supportSQLiteStatement.bindLong(539, clockConfig.getPower_progress_y());
                if (clockConfig.getPower_src() == null) {
                    supportSQLiteStatement.bindNull(540);
                } else {
                    supportSQLiteStatement.bindString(540, clockConfig.getPower_src());
                }
                supportSQLiteStatement.bindLong(541, clockConfig.getPower_src_x());
                supportSQLiteStatement.bindLong(542, clockConfig.getPower_src_y());
                supportSQLiteStatement.bindLong(543, clockConfig.getVideo_type());
                supportSQLiteStatement.bindLong(544, clockConfig.getStep_keep_number_length());
                supportSQLiteStatement.bindLong(545, clockConfig.getKcal_keep_number_length());
                supportSQLiteStatement.bindLong(546, clockConfig.getKm_keep_number_length());
                supportSQLiteStatement.bindLong(547, clockConfig.getStep_num_rotate());
                supportSQLiteStatement.bindLong(548, clockConfig.getStep_num_rotate_degree());
                supportSQLiteStatement.bindLong(549, clockConfig.getShow_btn_style());
                if (clockConfig.getBtn_style_src() == null) {
                    supportSQLiteStatement.bindNull(550);
                } else {
                    supportSQLiteStatement.bindString(550, clockConfig.getBtn_style_src());
                }
                supportSQLiteStatement.bindLong(551, clockConfig.getBtn_style_x());
                supportSQLiteStatement.bindLong(552, clockConfig.getBtn_style_y());
                supportSQLiteStatement.bindLong(553, clockConfig.getNeed_split_sec());
                if (clockConfig.getSplit_sec_src() == null) {
                    supportSQLiteStatement.bindNull(554);
                } else {
                    supportSQLiteStatement.bindString(554, clockConfig.getSplit_sec_src());
                }
                supportSQLiteStatement.bindLong(555, clockConfig.getSplit_sec_x());
                supportSQLiteStatement.bindLong(556, clockConfig.getSplit_sec_y());
                supportSQLiteStatement.bindLong(557, clockConfig.getOpen_oxygen_arc_show());
                supportSQLiteStatement.bindLong(558, clockConfig.getOxygen_arc_type());
                supportSQLiteStatement.bindLong(559, clockConfig.getOxygen_arc_center_x());
                supportSQLiteStatement.bindLong(560, clockConfig.getOxygen_arc_center_y());
                supportSQLiteStatement.bindLong(561, clockConfig.getShow_oxygen_progress());
                if (clockConfig.getOxygen_progress_src() == null) {
                    supportSQLiteStatement.bindNull(562);
                } else {
                    supportSQLiteStatement.bindString(562, clockConfig.getOxygen_progress_src());
                }
                supportSQLiteStatement.bindLong(563, clockConfig.getOxygen_progress_x());
                supportSQLiteStatement.bindLong(564, clockConfig.getOxygen_progress_y());
                supportSQLiteStatement.bindLong(565, clockConfig.getShow_week_donts());
                if (clockConfig.getWeek_donts_src() == null) {
                    supportSQLiteStatement.bindNull(566);
                } else {
                    supportSQLiteStatement.bindString(566, clockConfig.getWeek_donts_src());
                }
                supportSQLiteStatement.bindLong(567, clockConfig.getWeek_donts_x());
                supportSQLiteStatement.bindLong(568, clockConfig.getWeek_donts_y());
                supportSQLiteStatement.bindLong(569, clockConfig.getShow_btn_flashlight());
                if (clockConfig.getFlashlight_src() == null) {
                    supportSQLiteStatement.bindNull(570);
                } else {
                    supportSQLiteStatement.bindString(570, clockConfig.getFlashlight_src());
                }
                supportSQLiteStatement.bindLong(571, clockConfig.getFlashlight_x());
                supportSQLiteStatement.bindLong(572, clockConfig.getFlashlight_y());
            }
        };
        this.__updateAdapterOfClockConfig = new EntityDeletionOrUpdateAdapter<ClockConfig>(__db) { // from class: com.dw.launcher.data.database.dao.ClockConfigDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `t_clock_config` SET `path` = ?,`fromAssets` = ?,`id` = ?,`name` = ?,`name_en` = ?,`screentype` = ?,`dialtype` = ?,`coordinate_screen_width` = ?,`coordinate_screen_height` = ?,`bg_type` = ?,`video` = ?,`lottie` = ?,`bg_animal_keep_for_last_frame` = ?,`bg_count` = ?,`bg_interval` = ?,`bg_is_customize` = ?,`hour_pointer_src` = ?,`hour_pointer_x` = ?,`hour_pointer_y` = ?,`minute_pointer_src` = ?,`minute_pointer_x` = ?,`minute_pointer_y` = ?,`second_pointer_src` = ?,`second_pointer_type` = ?,`second_pointer_x` = ?,`second_pointer_y` = ?,`second_pointer_animal_type` = ?,`dot_src` = ?,`dot_x` = ?,`dot_y` = ?,`show_pointer_start_animation` = ?,`pointer_start_hour` = ?,`pointer_start_minute` = ?,`pointer_start_second` = ?,`time_hour_src` = ?,`time_min_src` = ?,`time_sec_src` = ?,`time_splt_src` = ?,`time_splt_2_src` = ?,`time_splt_need_jump` = ?,`time_x` = ?,`time_y` = ?,`need_reset_min` = ?,`reset_min_x` = ?,`reset_min_y` = ?,`show_sec` = ?,`need_reset_sec` = ?,`reset_sec_x` = ?,`reset_sec_y` = ?,`open_time_arc_show` = ?,`time_arc_type` = ?,`time_arc_center_x` = ?,`time_arc_center_y` = ?,`show_am_or_pm` = ?,`am_and_pm_src` = ?,`am_or_pm_x` = ?,`am_or_pm_y` = ?,`show_ampm_placeholer` = ?,`show_digital_start_animation` = ?,`digital_start_hour` = ?,`digital_start_minute` = ?,`digital_start_second` = ?,`date_src` = ?,`date_x` = ?,`date_y` = ?,`open_date_arc_show` = ?,`date_arc_type` = ?,`date_arc_center_x` = ?,`date_arc_center_y` = ?,`date_year_splt_src` = ?,`date_month_splt_src` = ?,`date_day_splt_src` = ?,`show_year` = ?,`year_digits_type` = ?,`show_month` = ?,`month_type` = ?,`month_src` = ?,`need_reset_month` = ?,`data_month_num` = ?,`month_x` = ?,`month_y` = ?,`show_day` = ?,`need_reset_day` = ?,`data_day_num` = ?,`day_x` = ?,`day_y` = ?,`day_src` = ?,`day_type` = ?,`week_src` = ?,`week_num_src` = ?,`week_x` = ?,`week_y` = ?,`show_power` = ?,`normal_0_src` = ?,`normal_1_src` = ?,`normal_2_src` = ?,`normal_3_src` = ?,`normal_4_src` = ?,`normal_5_src` = ?,`normal_6_src` = ?,`normal_7_src` = ?,`normal_8_src` = ?,`normal_9_src` = ?,`normal_10_src` = ?,`power_x` = ?,`power_y` = ?,`show_charge` = ?,`charge_0_src` = ?,`charge_1_src` = ?,`charge_2_src` = ?,`charge_3_src` = ?,`charge_4_src` = ?,`charge_5_src` = ?,`charge_6_src` = ?,`charge_7_src` = ?,`charge_8_src` = ?,`charge_9_src` = ?,`charge_10_src` = ?,`show_power_num` = ?,`power_num_src` = ?,`power_sign_src` = ?,`power_show_type` = ?,`power_num_x` = ?,`power_num_y` = ?,`show_action` = ?,`open_action_1` = ?,`action_1_count` = ?,`action_1_x` = ?,`action_1_y` = ?,`open_action_2` = ?,`action_2_count` = ?,`action_2_x` = ?,`action_2_y` = ?,`open_action_3` = ?,`action_3_count` = ?,`action_3_x` = ?,`action_3_y` = ?,`action_interval` = ?,`show_overall_animation` = ?,`overall_animation_x` = ?,`overall_animation_y` = ?,`open_click_1` = ?,`click_1_x` = ?,`click_1_y` = ?,`click_1_width` = ?,`click_1_height` = ?,`open_click_2` = ?,`click_2_x` = ?,`click_2_y` = ?,`click_2_width` = ?,`click_2_height` = ?,`open_click_3` = ?,`click_3_x` = ?,`click_3_y` = ?,`click_3_width` = ?,`click_3_height` = ?,`open_click_4` = ?,`click_4_x` = ?,`click_4_y` = ?,`click_4_width` = ?,`click_4_height` = ?,`show_lunar` = ?,`lunar_src` = ?,`lunar_x` = ?,`lunar_y` = ?,`show_heart` = ?,`heart_src` = ?,`heart_x` = ?,`heart_y` = ?,`heart_num_src` = ?,`heart_num_type` = ?,`heart_end_src` = ?,`heart_show_type` = ?,`heart_num_x` = ?,`heart_num_y` = ?,`open_heart_arc_show` = ?,`heart_arc_type` = ?,`heart_arc_center_x` = ?,`heart_arc_center_y` = ?,`show_pressure` = ?,`pressure_src` = ?,`pressure_x` = ?,`pressure_y` = ?,`pressure_num_src` = ?,`pressure_num_x` = ?,`pressure_num_y` = ?,`pressure_show_type` = ?,`pressure_splt_src` = ?,`show_step` = ?,`step_src` = ?,`step_follow_num` = ?,`step_x` = ?,`step_y` = ?,`step_num_src` = ?,`step_num_type` = ?,`step_show_type` = ?,`step_num_x` = ?,`step_num_y` = ?,`step_end_src` = ?,`show_step_progress` = ?,`step_progress_x` = ?,`step_progress_y` = ?,`step_progress_src` = ?,`open_step_arc_show` = ?,`step_arc_type` = ?,`step_arc_center_x` = ?,`step_arc_center_y` = ?,`show_kcal` = ?,`kcal_src` = ?,`kcal_x` = ?,`kcal_y` = ?,`kcal_num_src` = ?,`kcal_num_type` = ?,`kcal_show_type` = ?,`kcal_num_x` = ?,`kcal_num_y` = ?,`kcal_end_src` = ?,`show_km` = ?,`km_src` = ?,`km_x` = ?,`km_y` = ?,`km_num_src` = ?,`km_comma_src` = ?,`km_num_type` = ?,`km_show_type` = ?,`km_num_x` = ?,`km_num_y` = ?,`km_end_src` = ?,`show_weather` = ?,`show_temperature` = ?,`temperature_show_type` = ?,`temperature_num_type` = ?,`temperature_x` = ?,`temperature_y` = ?,`temperature_x_2` = ?,`temperature_y_2` = ?,`show_now_tem` = ?,`now_tem_show_type` = ?,`now_tem_x` = ?,`now_tem_y` = ?,`temperature_num_src` = ?,`temperature_sub_src` = ?,`temperature_sign_src` = ?,`temperature_splt_src` = ?,`show_diagram` = ?,`diagram_x` = ?,`diagram_y` = ?,`showsignal` = ?,`show_signal` = ?,`signal_src` = ?,`signal_x` = ?,`signal_y` = ?,`show_user_name` = ?,`name_show_type` = ?,`name_x` = ?,`name_y` = ?,`show_operator` = ?,`operator_show_type` = ?,`operator_x` = ?,`operator_y` = ?,`show_btn_call` = ?,`btn_call_src` = ?,`btn_call_x` = ?,`btn_call_y` = ?,`show_btn_sms` = ?,`btn_sms_src` = ?,`btn_sms_x` = ?,`btn_sms_y` = ?,`show_btn_heart` = ?,`is_our_heart` = ?,`btn_heart_src` = ?,`btn_heart_x` = ?,`btn_heart_y` = ?,`show_btn_step` = ?,`btn_step_src` = ?,`btn_step_x` = ?,`btn_step_y` = ?,`show_btn_wechat` = ?,`btn_wechat_src` = ?,`btn_wechat_x` = ?,`btn_wechat_y` = ?,`show_btn_alipay` = ?,`btn_alipay_src` = ?,`btn_alipay_x` = ?,`btn_alipay_y` = ?,`show_btn_stopwatch` = ?,`btn_stopwatch_src` = ?,`btn_stopwatch_x` = ?,`btn_stopwatch_y` = ?,`show_btn_weather` = ?,`show_btn_calo` = ?,`btn_calo_src` = ?,`btn_calo_x` = ?,`btn_calo_y` = ?,`temprature_src` = ?,`show_btn_camera` = ?,`btn_camera_src` = ?,`btn_camera_x` = ?,`btn_camera_y` = ?,`show_btn_sos` = ?,`btn_sos_src` = ?,`btn_sos_x` = ?,`btn_sos_y` = ?,`show_special_1` = ?,`special_1_src` = ?,`special_1_position` = ?,`special_x` = ?,`special_y` = ?,`support_multiple_change` = ?,`show_lunar_year` = ?,`lunar_day_splt_src` = ?,`lunar_month_splt_src` = ?,`lunar_year_splt_src` = ?,`am_src` = ?,`pm_src` = ?,`show_btn_alarm` = ?,`btn_alarm_src` = ?,`btn_alarm_x` = ?,`btn_alarm_y` = ?,`bg_btn_change` = ?,`bg_btn_index` = ?,`show_btn_music` = ?,`btn_music_src` = ?,`btn_music_x` = ?,`btn_music_y` = ?,`support_dynamic_change` = ?,`level` = ?,`parent_id` = ?,`next_id` = ?,`change_starttime` = ?,`change_endtime` = ?,`btn_weather_src` = ?,`btn_weather_x` = ?,`btn_weather_y` = ?,`show_btn_calories` = ?,`btn_calories_src` = ?,`btn_calories_x` = ?,`btn_calories_y` = ?,`support_compass` = ?,`compass_src` = ?,`compass_2_src` = ?,`compass_x` = ?,`compass_y` = ?,`show_btn_setting` = ?,`btn_setting_src` = ?,`btn_setting_x` = ?,`btn_setting_y` = ?,`support_click_change` = ?,`click_id_is_current` = ?,`compass_show_detail_degree` = ?,`compass_direction_src` = ?,`compass_direction_x` = ?,`compass_direction_y` = ?,`compass_direction_2_src` = ?,`compass_direction_2_x` = ?,`compass_direction_2_y` = ?,`compass_direction_3_src` = ?,`compass_direction_3_x` = ?,`compass_direction_3_y` = ?,`compass_direction_degree_src` = ?,`compass_direction_degree_x` = ?,`compass_direction_degree_y` = ?,`compass_direction_degree_unit` = ?,`compass_degree_1_src` = ?,`compass_degree_1_x` = ?,`compass_degree_1_y` = ?,`compass_degree_2_src` = ?,`compass_degree_2_x` = ?,`compass_degree_2_y` = ?,`compass_degree_3_src` = ?,`compass_degree_3_x` = ?,`compass_degree_3_y` = ?,`show_connect_animation` = ?,`connect_animation_x` = ?,`connect_animation_y` = ?,`connect_animation_count` = ?,`show_state` = ?,`state_x` = ?,`state_y` = ?,`action_1_cut_position` = ?,`action_2_cut_position` = ?,`action_3_cut_position` = ?,`show_btn_googleplay` = ?,`btn_googleplay_src` = ?,`btn_googleplay_x` = ?,`btn_googleplay_y` = ?,`show_month_2` = ?,`month_type_2` = ?,`month_src_2` = ?,`month_x_2` = ?,`month_y_2` = ?,`time_special_new` = ?,`time_special_hour_ten_src` = ?,`time_special_hour_src` = ?,`time_special_min_ten_src` = ?,`time_special_min_src` = ?,`show_kcal_progress` = ?,`kcal_progress_x` = ?,`kcal_progress_y` = ?,`kcal_progress_src` = ?,`open_kcal_arc_show` = ?,`kcal_arc_type` = ?,`kcal_arc_center_x` = ?,`kcal_arc_center_y` = ?,`open_power_arc_show` = ?,`power_arc_type` = ?,`power_arc_center_x` = ?,`power_arc_center_y` = ?,`show_btn_timer` = ?,`btn_timer_src` = ?,`btn_timer_x` = ?,`btn_timer_y` = ?,`show_btn_sleep` = ?,`btn_sleep_src` = ?,`btn_sleep_x` = ?,`btn_sleep_y` = ?,`show_btn_bloodpressure` = ?,`btn_bloodpressure_src` = ?,`btn_bloodpressure_x` = ?,`btn_bloodpressure_y` = ?,`show_btn_sport_record` = ?,`btn_sport_record_src` = ?,`btn_sport_record_x` = ?,`btn_sport_record_y` = ?,`lottie_hierarchy` = ?,`show_heart_progress` = ?,`heart_progress_x` = ?,`heart_progress_y` = ?,`heart_progress_src` = ?,`show_btn_calculator` = ?,`btn_calculator_src` = ?,`btn_calculator_x` = ?,`btn_calculator_y` = ?,`time_special_drag_3d` = ?,`prev_HourTen_Position` = ?,`prev_HourGe_Position` = ?,`current_HourTen_Position` = ?,`current_HourGe_Position` = ?,`next_HourTen_Position` = ?,`next_HourGe_Position` = ?,`prev_MinTen_Position` = ?,`prev_MinGe_Position` = ?,`current_MinTen_Position` = ?,`current_MinGe_Position` = ?,`next_MinTen_Position` = ?,`next_MinGe_Position` = ?,`need_split_day` = ?,`split_day_x` = ?,`split_day_y` = ?,`open_now_tem_arc_show` = ?,`now_tem_arc_type` = ?,`now_tem_arc_center_x` = ?,`now_tem_arc_center_y` = ?,`show_km_progress` = ?,`km_progress_x` = ?,`km_progress_y` = ?,`km_progress_src` = ?,`open_km_arc_show` = ?,`km_arc_type` = ?,`km_arc_center_x` = ?,`km_arc_center_y` = ?,`time_rotate` = ?,`time_rotate_degree` = ?,`heart_num_rotate` = ?,`heart_num_rotate_degree` = ?,`show_oxygen` = ?,`oxygen_src` = ?,`oxygen_x` = ?,`oxygen_y` = ?,`oxygen_num_src` = ?,`oxygen_sign_src` = ?,`oxygen_show_type` = ?,`oxygen_num_x` = ?,`oxygen_num_y` = ?,`time_change_counter` = ?,`time_hour_src_2` = ?,`time_min_src_2` = ?,`time_sec_src_2` = ?,`time_splt_src_2` = ?,`time_splt_2_src_2` = ?,`time_hour_src_3` = ?,`time_min_src_3` = ?,`time_sec_src_3` = ?,`time_splt_src_3` = ?,`time_splt_2_src_3` = ?,`time_hour_src_4` = ?,`time_min_src_4` = ?,`time_sec_src_4` = ?,`time_splt_src_4` = ?,`time_splt_2_src_4` = ?,`date_rotate` = ?,`date_rotate_degree` = ?,`need_split_hour` = ?,`split_hour_src` = ?,`split_hour_x` = ?,`split_hour_y` = ?,`need_split_min` = ?,`split_min_src` = ?,`split_min_x` = ?,`split_min_y` = ?,`support_scale` = ?,`show_compass_num` = ?,`compass_num_src` = ?,`compass_show_type` = ?,`compass_num_x` = ?,`compass_num_y` = ?,`compass_num_src_prefix` = ?,`compass_num_src_sign` = ?,`show_btn_oxygen` = ?,`btn_oxygen_src` = ?,`btn_oxygen_x` = ?,`btn_oxygen_y` = ?,`show_btn_calendar` = ?,`btn_calendar_src` = ?,`btn_calendar_x` = ?,`btn_calendar_y` = ?,`show_btn_compass` = ?,`btn_compass_src` = ?,`btn_compass_x` = ?,`btn_compass_y` = ?,`pointer_disable_scale` = ?,`show_chinse_time` = ?,`chinse_time_src` = ?,`chinse_time_x` = ?,`chinse_time_y` = ?,`show_btn_photo` = ?,`btn_photo_src` = ?,`btn_photo_x` = ?,`btn_photo_y` = ?,`show_btn_contact` = ?,`btn_contact_src` = ?,`btn_contact_x` = ?,`btn_contact_y` = ?,`kcal_num_rotate` = ?,`kcal_num_rotate_degree` = ?,`show_power_progress` = ?,`power_progress_src` = ?,`power_progress_x` = ?,`power_progress_y` = ?,`power_src` = ?,`power_src_x` = ?,`power_src_y` = ?,`video_type` = ?,`step_keep_number_length` = ?,`kcal_keep_number_length` = ?,`km_keep_number_length` = ?,`step_num_rotate` = ?,`step_num_rotate_degree` = ?,`show_btn_style` = ?,`btn_style_src` = ?,`btn_style_x` = ?,`btn_style_y` = ?,`need_split_sec` = ?,`split_sec_src` = ?,`split_sec_x` = ?,`split_sec_y` = ?,`open_oxygen_arc_show` = ?,`oxygen_arc_type` = ?,`oxygen_arc_center_x` = ?,`oxygen_arc_center_y` = ?,`show_oxygen_progress` = ?,`oxygen_progress_src` = ?,`oxygen_progress_x` = ?,`oxygen_progress_y` = ?,`show_week_donts` = ?,`week_donts_src` = ?,`week_donts_x` = ?,`week_donts_y` = ?,`show_btn_flashlight` = ?,`flashlight_src` = ?,`flashlight_x` = ?,`flashlight_y` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ClockConfig clockConfig) {
                if (clockConfig.getPath() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, clockConfig.getPath());
                }
                supportSQLiteStatement.bindLong(2, clockConfig.getFromAssets() ? 1L : 0L);
                if (clockConfig.getId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, clockConfig.getId());
                }
                if (clockConfig.getName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, clockConfig.getName());
                }
                if (clockConfig.getName_en() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, clockConfig.getName_en());
                }
                if (clockConfig.getScreentype() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, clockConfig.getScreentype());
                }
                supportSQLiteStatement.bindLong(7, clockConfig.getDialtype());
                supportSQLiteStatement.bindLong(8, clockConfig.getCoordinate_screen_width());
                supportSQLiteStatement.bindLong(9, clockConfig.getCoordinate_screen_height());
                supportSQLiteStatement.bindLong(10, clockConfig.getBg_type());
                if (clockConfig.getVideo() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, clockConfig.getVideo());
                }
                if (clockConfig.getLottie() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, clockConfig.getLottie());
                }
                supportSQLiteStatement.bindLong(13, clockConfig.getBg_animal_keep_for_last_frame());
                supportSQLiteStatement.bindLong(14, clockConfig.getBg_count());
                if (clockConfig.getBg_interval() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, clockConfig.getBg_interval());
                }
                if (clockConfig.getBg_is_customize() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, clockConfig.getBg_is_customize());
                }
                if (clockConfig.getHour_pointer_src() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, clockConfig.getHour_pointer_src());
                }
                supportSQLiteStatement.bindLong(18, clockConfig.getHour_pointer_x());
                supportSQLiteStatement.bindLong(19, clockConfig.getHour_pointer_y());
                if (clockConfig.getMinute_pointer_src() == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, clockConfig.getMinute_pointer_src());
                }
                supportSQLiteStatement.bindLong(21, clockConfig.getMinute_pointer_x());
                supportSQLiteStatement.bindLong(22, clockConfig.getMinute_pointer_y());
                if (clockConfig.getSecond_pointer_src() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindString(23, clockConfig.getSecond_pointer_src());
                }
                supportSQLiteStatement.bindLong(24, clockConfig.getSecond_pointer_type());
                supportSQLiteStatement.bindLong(25, clockConfig.getSecond_pointer_x());
                supportSQLiteStatement.bindLong(26, clockConfig.getSecond_pointer_y());
                supportSQLiteStatement.bindLong(27, clockConfig.getSecond_pointer_animal_type());
                if (clockConfig.getDot_src() == null) {
                    supportSQLiteStatement.bindNull(28);
                } else {
                    supportSQLiteStatement.bindString(28, clockConfig.getDot_src());
                }
                supportSQLiteStatement.bindLong(29, clockConfig.getDot_x());
                supportSQLiteStatement.bindLong(30, clockConfig.getDot_y());
                supportSQLiteStatement.bindLong(31, clockConfig.getShow_pointer_start_animation());
                supportSQLiteStatement.bindLong(32, clockConfig.getPointer_start_hour());
                supportSQLiteStatement.bindLong(33, clockConfig.getPointer_start_minute());
                supportSQLiteStatement.bindLong(34, clockConfig.getPointer_start_second());
                if (clockConfig.getTime_hour_src() == null) {
                    supportSQLiteStatement.bindNull(35);
                } else {
                    supportSQLiteStatement.bindString(35, clockConfig.getTime_hour_src());
                }
                if (clockConfig.getTime_min_src() == null) {
                    supportSQLiteStatement.bindNull(36);
                } else {
                    supportSQLiteStatement.bindString(36, clockConfig.getTime_min_src());
                }
                if (clockConfig.getTime_sec_src() == null) {
                    supportSQLiteStatement.bindNull(37);
                } else {
                    supportSQLiteStatement.bindString(37, clockConfig.getTime_sec_src());
                }
                if (clockConfig.getTime_splt_src() == null) {
                    supportSQLiteStatement.bindNull(38);
                } else {
                    supportSQLiteStatement.bindString(38, clockConfig.getTime_splt_src());
                }
                if (clockConfig.getTime_splt_2_src() == null) {
                    supportSQLiteStatement.bindNull(39);
                } else {
                    supportSQLiteStatement.bindString(39, clockConfig.getTime_splt_2_src());
                }
                supportSQLiteStatement.bindLong(40, clockConfig.getTime_splt_need_jump());
                supportSQLiteStatement.bindLong(41, clockConfig.getTime_x());
                supportSQLiteStatement.bindLong(42, clockConfig.getTime_y());
                supportSQLiteStatement.bindLong(43, clockConfig.getNeed_reset_min());
                supportSQLiteStatement.bindLong(44, clockConfig.getReset_min_x());
                supportSQLiteStatement.bindLong(45, clockConfig.getReset_min_y());
                supportSQLiteStatement.bindLong(46, clockConfig.getShow_sec());
                supportSQLiteStatement.bindLong(47, clockConfig.getNeed_reset_sec());
                supportSQLiteStatement.bindLong(48, clockConfig.getReset_sec_x());
                supportSQLiteStatement.bindLong(49, clockConfig.getReset_sec_y());
                supportSQLiteStatement.bindLong(50, clockConfig.getOpen_time_arc_show());
                supportSQLiteStatement.bindLong(51, clockConfig.getTime_arc_type());
                supportSQLiteStatement.bindLong(52, clockConfig.getTime_arc_center_x());
                supportSQLiteStatement.bindLong(53, clockConfig.getTime_arc_center_y());
                supportSQLiteStatement.bindLong(54, clockConfig.getShow_am_or_pm());
                if (clockConfig.getAm_and_pm_src() == null) {
                    supportSQLiteStatement.bindNull(55);
                } else {
                    supportSQLiteStatement.bindString(55, clockConfig.getAm_and_pm_src());
                }
                supportSQLiteStatement.bindLong(56, clockConfig.getAm_or_pm_x());
                supportSQLiteStatement.bindLong(57, clockConfig.getAm_or_pm_y());
                supportSQLiteStatement.bindLong(58, clockConfig.getShow_ampm_placeholer());
                supportSQLiteStatement.bindLong(59, clockConfig.getShow_digital_start_animation());
                supportSQLiteStatement.bindLong(60, clockConfig.getDigital_start_hour());
                supportSQLiteStatement.bindLong(61, clockConfig.getDigital_start_minute());
                supportSQLiteStatement.bindLong(62, clockConfig.getDigital_start_second());
                if (clockConfig.getDate_src() == null) {
                    supportSQLiteStatement.bindNull(63);
                } else {
                    supportSQLiteStatement.bindString(63, clockConfig.getDate_src());
                }
                supportSQLiteStatement.bindLong(64, clockConfig.getDate_x());
                supportSQLiteStatement.bindLong(65, clockConfig.getDate_y());
                supportSQLiteStatement.bindLong(66, clockConfig.getOpen_date_arc_show());
                supportSQLiteStatement.bindLong(67, clockConfig.getDate_arc_type());
                supportSQLiteStatement.bindLong(68, clockConfig.getDate_arc_center_x());
                supportSQLiteStatement.bindLong(69, clockConfig.getDate_arc_center_y());
                if (clockConfig.getDate_year_splt_src() == null) {
                    supportSQLiteStatement.bindNull(70);
                } else {
                    supportSQLiteStatement.bindString(70, clockConfig.getDate_year_splt_src());
                }
                if (clockConfig.getDate_month_splt_src() == null) {
                    supportSQLiteStatement.bindNull(71);
                } else {
                    supportSQLiteStatement.bindString(71, clockConfig.getDate_month_splt_src());
                }
                if (clockConfig.getDate_day_splt_src() == null) {
                    supportSQLiteStatement.bindNull(72);
                } else {
                    supportSQLiteStatement.bindString(72, clockConfig.getDate_day_splt_src());
                }
                supportSQLiteStatement.bindLong(73, clockConfig.getShow_year());
                supportSQLiteStatement.bindLong(74, clockConfig.getYear_digits_type());
                supportSQLiteStatement.bindLong(75, clockConfig.getShow_month());
                supportSQLiteStatement.bindLong(76, clockConfig.getMonth_type());
                if (clockConfig.getMonth_src() == null) {
                    supportSQLiteStatement.bindNull(77);
                } else {
                    supportSQLiteStatement.bindString(77, clockConfig.getMonth_src());
                }
                supportSQLiteStatement.bindLong(78, clockConfig.getNeed_reset_month());
                if (clockConfig.getData_month_num() == null) {
                    supportSQLiteStatement.bindNull(79);
                } else {
                    supportSQLiteStatement.bindString(79, clockConfig.getData_month_num());
                }
                supportSQLiteStatement.bindLong(80, clockConfig.getMonth_x());
                supportSQLiteStatement.bindLong(81, clockConfig.getMonth_y());
                supportSQLiteStatement.bindLong(82, clockConfig.getShow_day());
                supportSQLiteStatement.bindLong(83, clockConfig.getNeed_reset_day());
                if (clockConfig.getData_day_num() == null) {
                    supportSQLiteStatement.bindNull(84);
                } else {
                    supportSQLiteStatement.bindString(84, clockConfig.getData_day_num());
                }
                supportSQLiteStatement.bindLong(85, clockConfig.getDay_x());
                supportSQLiteStatement.bindLong(86, clockConfig.getDay_y());
                if (clockConfig.getDay_src() == null) {
                    supportSQLiteStatement.bindNull(87);
                } else {
                    supportSQLiteStatement.bindString(87, clockConfig.getDay_src());
                }
                supportSQLiteStatement.bindLong(88, clockConfig.getDay_type());
                if (clockConfig.getWeek_src() == null) {
                    supportSQLiteStatement.bindNull(89);
                } else {
                    supportSQLiteStatement.bindString(89, clockConfig.getWeek_src());
                }
                if (clockConfig.getWeek_num_src() == null) {
                    supportSQLiteStatement.bindNull(90);
                } else {
                    supportSQLiteStatement.bindString(90, clockConfig.getWeek_num_src());
                }
                supportSQLiteStatement.bindLong(91, clockConfig.getWeek_x());
                supportSQLiteStatement.bindLong(92, clockConfig.getWeek_y());
                supportSQLiteStatement.bindLong(93, clockConfig.getShow_power());
                if (clockConfig.getNormal_0_src() == null) {
                    supportSQLiteStatement.bindNull(94);
                } else {
                    supportSQLiteStatement.bindString(94, clockConfig.getNormal_0_src());
                }
                if (clockConfig.getNormal_1_src() == null) {
                    supportSQLiteStatement.bindNull(95);
                } else {
                    supportSQLiteStatement.bindString(95, clockConfig.getNormal_1_src());
                }
                if (clockConfig.getNormal_2_src() == null) {
                    supportSQLiteStatement.bindNull(96);
                } else {
                    supportSQLiteStatement.bindString(96, clockConfig.getNormal_2_src());
                }
                if (clockConfig.getNormal_3_src() == null) {
                    supportSQLiteStatement.bindNull(97);
                } else {
                    supportSQLiteStatement.bindString(97, clockConfig.getNormal_3_src());
                }
                if (clockConfig.getNormal_4_src() == null) {
                    supportSQLiteStatement.bindNull(98);
                } else {
                    supportSQLiteStatement.bindString(98, clockConfig.getNormal_4_src());
                }
                if (clockConfig.getNormal_5_src() == null) {
                    supportSQLiteStatement.bindNull(99);
                } else {
                    supportSQLiteStatement.bindString(99, clockConfig.getNormal_5_src());
                }
                if (clockConfig.getNormal_6_src() == null) {
                    supportSQLiteStatement.bindNull(100);
                } else {
                    supportSQLiteStatement.bindString(100, clockConfig.getNormal_6_src());
                }
                if (clockConfig.getNormal_7_src() == null) {
                    supportSQLiteStatement.bindNull(101);
                } else {
                    supportSQLiteStatement.bindString(101, clockConfig.getNormal_7_src());
                }
                if (clockConfig.getNormal_8_src() == null) {
                    supportSQLiteStatement.bindNull(102);
                } else {
                    supportSQLiteStatement.bindString(102, clockConfig.getNormal_8_src());
                }
                if (clockConfig.getNormal_9_src() == null) {
                    supportSQLiteStatement.bindNull(103);
                } else {
                    supportSQLiteStatement.bindString(103, clockConfig.getNormal_9_src());
                }
                if (clockConfig.getNormal_10_src() == null) {
                    supportSQLiteStatement.bindNull(LocationRequestCompat.QUALITY_LOW_POWER);
                } else {
                    supportSQLiteStatement.bindString(LocationRequestCompat.QUALITY_LOW_POWER, clockConfig.getNormal_10_src());
                }
                supportSQLiteStatement.bindLong(105, clockConfig.getPower_x());
                supportSQLiteStatement.bindLong(106, clockConfig.getPower_y());
                supportSQLiteStatement.bindLong(107, clockConfig.getShow_charge());
                if (clockConfig.getCharge_0_src() == null) {
                    supportSQLiteStatement.bindNull(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
                } else {
                    supportSQLiteStatement.bindString(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, clockConfig.getCharge_0_src());
                }
                if (clockConfig.getCharge_1_src() == null) {
                    supportSQLiteStatement.bindNull(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                } else {
                    supportSQLiteStatement.bindString(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, clockConfig.getCharge_1_src());
                }
                if (clockConfig.getCharge_2_src() == null) {
                    supportSQLiteStatement.bindNull(110);
                } else {
                    supportSQLiteStatement.bindString(110, clockConfig.getCharge_2_src());
                }
                if (clockConfig.getCharge_3_src() == null) {
                    supportSQLiteStatement.bindNull(111);
                } else {
                    supportSQLiteStatement.bindString(111, clockConfig.getCharge_3_src());
                }
                if (clockConfig.getCharge_4_src() == null) {
                    supportSQLiteStatement.bindNull(112);
                } else {
                    supportSQLiteStatement.bindString(112, clockConfig.getCharge_4_src());
                }
                if (clockConfig.getCharge_5_src() == null) {
                    supportSQLiteStatement.bindNull(113);
                } else {
                    supportSQLiteStatement.bindString(113, clockConfig.getCharge_5_src());
                }
                if (clockConfig.getCharge_6_src() == null) {
                    supportSQLiteStatement.bindNull(114);
                } else {
                    supportSQLiteStatement.bindString(114, clockConfig.getCharge_6_src());
                }
                if (clockConfig.getCharge_7_src() == null) {
                    supportSQLiteStatement.bindNull(115);
                } else {
                    supportSQLiteStatement.bindString(115, clockConfig.getCharge_7_src());
                }
                if (clockConfig.getCharge_8_src() == null) {
                    supportSQLiteStatement.bindNull(116);
                } else {
                    supportSQLiteStatement.bindString(116, clockConfig.getCharge_8_src());
                }
                if (clockConfig.getCharge_9_src() == null) {
                    supportSQLiteStatement.bindNull(117);
                } else {
                    supportSQLiteStatement.bindString(117, clockConfig.getCharge_9_src());
                }
                if (clockConfig.getCharge_10_src() == null) {
                    supportSQLiteStatement.bindNull(118);
                } else {
                    supportSQLiteStatement.bindString(118, clockConfig.getCharge_10_src());
                }
                supportSQLiteStatement.bindLong(119, clockConfig.getShow_power_num());
                if (clockConfig.getPower_num_src() == null) {
                    supportSQLiteStatement.bindNull(120);
                } else {
                    supportSQLiteStatement.bindString(120, clockConfig.getPower_num_src());
                }
                if (clockConfig.getPower_sign_src() == null) {
                    supportSQLiteStatement.bindNull(121);
                } else {
                    supportSQLiteStatement.bindString(121, clockConfig.getPower_sign_src());
                }
                supportSQLiteStatement.bindLong(122, clockConfig.getPower_show_type());
                supportSQLiteStatement.bindLong(123, clockConfig.getPower_num_x());
                supportSQLiteStatement.bindLong(124, clockConfig.getPower_num_y());
                supportSQLiteStatement.bindLong(125, clockConfig.getShow_action());
                supportSQLiteStatement.bindLong(126, clockConfig.getOpen_action_1());
                supportSQLiteStatement.bindLong(127, clockConfig.getAction_1_count());
                supportSQLiteStatement.bindLong(128, clockConfig.getAction_1_x());
                supportSQLiteStatement.bindLong(UiccCardApplication.AUTH_CONTEXT_EAP_AKA, clockConfig.getAction_1_y());
                supportSQLiteStatement.bindLong(130, clockConfig.getOpen_action_2());
                supportSQLiteStatement.bindLong(RadioCdmaSmsConst.UDH_EO_DATA_SEGMENT_MAX, clockConfig.getAction_2_count());
                supportSQLiteStatement.bindLong(132, clockConfig.getAction_2_x());
                supportSQLiteStatement.bindLong(133, clockConfig.getAction_2_y());
                supportSQLiteStatement.bindLong(134, clockConfig.getOpen_action_3());
                supportSQLiteStatement.bindLong(135, clockConfig.getAction_3_count());
                supportSQLiteStatement.bindLong(136, clockConfig.getAction_3_x());
                supportSQLiteStatement.bindLong(137, clockConfig.getAction_3_y());
                supportSQLiteStatement.bindLong(138, clockConfig.getAction_interval());
                if (clockConfig.getShow_overall_animation() == null) {
                    supportSQLiteStatement.bindNull(139);
                } else {
                    supportSQLiteStatement.bindString(139, clockConfig.getShow_overall_animation());
                }
                supportSQLiteStatement.bindLong(SmsMessage.MAX_USER_DATA_BYTES, clockConfig.getOverall_animation_x());
                supportSQLiteStatement.bindLong(141, clockConfig.getOverall_animation_y());
                if (clockConfig.getOpen_click_1() == null) {
                    supportSQLiteStatement.bindNull(142);
                } else {
                    supportSQLiteStatement.bindString(142, clockConfig.getOpen_click_1());
                }
                supportSQLiteStatement.bindLong(143, clockConfig.getClick_1_x());
                supportSQLiteStatement.bindLong(144, clockConfig.getClick_1_y());
                if (clockConfig.getClick_1_width() == null) {
                    supportSQLiteStatement.bindNull(145);
                } else {
                    supportSQLiteStatement.bindString(145, clockConfig.getClick_1_width());
                }
                if (clockConfig.getClick_1_height() == null) {
                    supportSQLiteStatement.bindNull(146);
                } else {
                    supportSQLiteStatement.bindString(146, clockConfig.getClick_1_height());
                }
                if (clockConfig.getOpen_click_2() == null) {
                    supportSQLiteStatement.bindNull(147);
                } else {
                    supportSQLiteStatement.bindString(147, clockConfig.getOpen_click_2());
                }
                supportSQLiteStatement.bindLong(148, clockConfig.getClick_2_x());
                supportSQLiteStatement.bindLong(149, clockConfig.getClick_2_y());
                if (clockConfig.getClick_2_width() == null) {
                    supportSQLiteStatement.bindNull(ImsPhoneCallTrackerEx.CODE_LOCAL_CALL_CS_EMERGENCY_RETRY_REQUIRED);
                } else {
                    supportSQLiteStatement.bindString(ImsPhoneCallTrackerEx.CODE_LOCAL_CALL_CS_EMERGENCY_RETRY_REQUIRED, clockConfig.getClick_2_width());
                }
                if (clockConfig.getClick_2_height() == null) {
                    supportSQLiteStatement.bindNull(ImsPhoneCallTrackerEx.CODE_LOCAL_CALL_IMS_HANDOVER_RETRY);
                } else {
                    supportSQLiteStatement.bindString(ImsPhoneCallTrackerEx.CODE_LOCAL_CALL_IMS_HANDOVER_RETRY, clockConfig.getClick_2_height());
                }
                if (clockConfig.getOpen_click_3() == null) {
                    supportSQLiteStatement.bindNull(152);
                } else {
                    supportSQLiteStatement.bindString(152, clockConfig.getOpen_click_3());
                }
                supportSQLiteStatement.bindLong(SmsMessage.MAX_USER_DATA_SEPTETS_WITH_HEADER, clockConfig.getClick_3_x());
                supportSQLiteStatement.bindLong(154, clockConfig.getClick_3_y());
                if (clockConfig.getClick_3_width() == null) {
                    supportSQLiteStatement.bindNull(155);
                } else {
                    supportSQLiteStatement.bindString(155, clockConfig.getClick_3_width());
                }
                if (clockConfig.getClick_3_height() == null) {
                    supportSQLiteStatement.bindNull(156);
                } else {
                    supportSQLiteStatement.bindString(156, clockConfig.getClick_3_height());
                }
                if (clockConfig.getOpen_click_4() == null) {
                    supportSQLiteStatement.bindNull(157);
                } else {
                    supportSQLiteStatement.bindString(157, clockConfig.getOpen_click_4());
                }
                supportSQLiteStatement.bindLong(158, clockConfig.getClick_4_x());
                supportSQLiteStatement.bindLong(159, clockConfig.getClick_4_y());
                if (clockConfig.getClick_4_width() == null) {
                    supportSQLiteStatement.bindNull(SmsMessage.MAX_USER_DATA_SEPTETS);
                } else {
                    supportSQLiteStatement.bindString(SmsMessage.MAX_USER_DATA_SEPTETS, clockConfig.getClick_4_width());
                }
                if (clockConfig.getClick_4_height() == null) {
                    supportSQLiteStatement.bindNull(161);
                } else {
                    supportSQLiteStatement.bindString(161, clockConfig.getClick_4_height());
                }
                supportSQLiteStatement.bindLong(162, clockConfig.getShow_lunar());
                if (clockConfig.getLunar_src() == null) {
                    supportSQLiteStatement.bindNull(163);
                } else {
                    supportSQLiteStatement.bindString(163, clockConfig.getLunar_src());
                }
                supportSQLiteStatement.bindLong(164, clockConfig.getLunar_x());
                supportSQLiteStatement.bindLong(165, clockConfig.getLunar_y());
                supportSQLiteStatement.bindLong(166, clockConfig.getShow_heart());
                if (clockConfig.getHeart_src() == null) {
                    supportSQLiteStatement.bindNull(167);
                } else {
                    supportSQLiteStatement.bindString(167, clockConfig.getHeart_src());
                }
                supportSQLiteStatement.bindLong(UsimPhoneBookManagerEx.USIM_TYPE1_TAG, clockConfig.getHeart_x());
                supportSQLiteStatement.bindLong(UsimPhoneBookManagerEx.USIM_TYPE2_TAG, clockConfig.getHeart_y());
                if (clockConfig.getHeart_num_src() == null) {
                    supportSQLiteStatement.bindNull(170);
                } else {
                    supportSQLiteStatement.bindString(170, clockConfig.getHeart_num_src());
                }
                if (clockConfig.getHeart_num_type() == null) {
                    supportSQLiteStatement.bindNull(171);
                } else {
                    supportSQLiteStatement.bindString(171, clockConfig.getHeart_num_type());
                }
                if (clockConfig.getHeart_end_src() == null) {
                    supportSQLiteStatement.bindNull(172);
                } else {
                    supportSQLiteStatement.bindString(172, clockConfig.getHeart_end_src());
                }
                supportSQLiteStatement.bindLong(173, clockConfig.getHeart_show_type());
                supportSQLiteStatement.bindLong(174, clockConfig.getHeart_num_x());
                supportSQLiteStatement.bindLong(175, clockConfig.getHeart_num_y());
                supportSQLiteStatement.bindLong(176, clockConfig.getOpen_heart_arc_show());
                supportSQLiteStatement.bindLong(177, clockConfig.getHeart_arc_type());
                supportSQLiteStatement.bindLong(178, clockConfig.getHeart_arc_center_x());
                supportSQLiteStatement.bindLong(179, clockConfig.getHeart_arc_center_y());
                if (clockConfig.getShow_pressure() == null) {
                    supportSQLiteStatement.bindNull(180);
                } else {
                    supportSQLiteStatement.bindString(180, clockConfig.getShow_pressure());
                }
                if (clockConfig.getPressure_src() == null) {
                    supportSQLiteStatement.bindNull(181);
                } else {
                    supportSQLiteStatement.bindString(181, clockConfig.getPressure_src());
                }
                supportSQLiteStatement.bindLong(182, clockConfig.getPressure_x());
                supportSQLiteStatement.bindLong(183, clockConfig.getPressure_y());
                if (clockConfig.getPressure_num_src() == null) {
                    supportSQLiteStatement.bindNull(184);
                } else {
                    supportSQLiteStatement.bindString(184, clockConfig.getPressure_num_src());
                }
                supportSQLiteStatement.bindLong(185, clockConfig.getPressure_num_x());
                supportSQLiteStatement.bindLong(186, clockConfig.getPressure_num_y());
                if (clockConfig.getPressure_show_type() == null) {
                    supportSQLiteStatement.bindNull(187);
                } else {
                    supportSQLiteStatement.bindString(187, clockConfig.getPressure_show_type());
                }
                if (clockConfig.getPressure_splt_src() == null) {
                    supportSQLiteStatement.bindNull(188);
                } else {
                    supportSQLiteStatement.bindString(188, clockConfig.getPressure_splt_src());
                }
                supportSQLiteStatement.bindLong(189, clockConfig.getShow_step());
                if (clockConfig.getStep_src() == null) {
                    supportSQLiteStatement.bindNull(190);
                } else {
                    supportSQLiteStatement.bindString(190, clockConfig.getStep_src());
                }
                supportSQLiteStatement.bindLong(191, clockConfig.getStep_follow_num());
                supportSQLiteStatement.bindLong(192, clockConfig.getStep_x());
                supportSQLiteStatement.bindLong(193, clockConfig.getStep_y());
                if (clockConfig.getStep_num_src() == null) {
                    supportSQLiteStatement.bindNull(194);
                } else {
                    supportSQLiteStatement.bindString(194, clockConfig.getStep_num_src());
                }
                supportSQLiteStatement.bindLong(UsimPhoneBookManagerEx.USIM_EFSNE_TAG, clockConfig.getStep_num_type());
                supportSQLiteStatement.bindLong(UsimPhoneBookManagerEx.USIM_EFANR_TAG, clockConfig.getStep_show_type());
                supportSQLiteStatement.bindLong(197, clockConfig.getStep_num_x());
                supportSQLiteStatement.bindLong(UsimPhoneBookManagerEx.USIM_EFGRP_TAG, clockConfig.getStep_num_y());
                if (clockConfig.getStep_end_src() == null) {
                    supportSQLiteStatement.bindNull(UsimPhoneBookManagerEx.USIM_EFAAS_TAG);
                } else {
                    supportSQLiteStatement.bindString(UsimPhoneBookManagerEx.USIM_EFAAS_TAG, clockConfig.getStep_end_src());
                }
                supportSQLiteStatement.bindLong(200, clockConfig.getShow_step_progress());
                supportSQLiteStatement.bindLong(201, clockConfig.getStep_progress_x());
                supportSQLiteStatement.bindLong(UsimPhoneBookManagerEx.USIM_EFEMAIL_TAG, clockConfig.getStep_progress_y());
                if (clockConfig.getStep_progress_src() == null) {
                    supportSQLiteStatement.bindNull(203);
                } else {
                    supportSQLiteStatement.bindString(203, clockConfig.getStep_progress_src());
                }
                supportSQLiteStatement.bindLong(204, clockConfig.getOpen_step_arc_show());
                supportSQLiteStatement.bindLong(205, clockConfig.getStep_arc_type());
                supportSQLiteStatement.bindLong(206, clockConfig.getStep_arc_center_x());
                supportSQLiteStatement.bindLong(207, clockConfig.getStep_arc_center_y());
                supportSQLiteStatement.bindLong(BerTlv.BER_PROACTIVE_COMMAND_TAG, clockConfig.getShow_kcal());
                if (clockConfig.getKcal_src() == null) {
                    supportSQLiteStatement.bindNull(209);
                } else {
                    supportSQLiteStatement.bindString(209, clockConfig.getKcal_src());
                }
                supportSQLiteStatement.bindLong(210, clockConfig.getKcal_x());
                supportSQLiteStatement.bindLong(211, clockConfig.getKcal_y());
                if (clockConfig.getKcal_num_src() == null) {
                    supportSQLiteStatement.bindNull(CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_APP_TOOLKIT_BUSY);
                } else {
                    supportSQLiteStatement.bindString(CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_APP_TOOLKIT_BUSY, clockConfig.getKcal_num_src());
                }
                supportSQLiteStatement.bindLong(CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR, clockConfig.getKcal_num_type());
                supportSQLiteStatement.bindLong(BerTlv.BER_EVENT_DOWNLOAD_TAG, clockConfig.getKcal_show_type());
                supportSQLiteStatement.bindLong(215, clockConfig.getKcal_num_x());
                supportSQLiteStatement.bindLong(216, clockConfig.getKcal_num_y());
                if (clockConfig.getKcal_end_src() == null) {
                    supportSQLiteStatement.bindNull(217);
                } else {
                    supportSQLiteStatement.bindString(217, clockConfig.getKcal_end_src());
                }
                if (clockConfig.getShow_km() == null) {
                    supportSQLiteStatement.bindNull(218);
                } else {
                    supportSQLiteStatement.bindString(218, clockConfig.getShow_km());
                }
                if (clockConfig.getKm_src() == null) {
                    supportSQLiteStatement.bindNull(219);
                } else {
                    supportSQLiteStatement.bindString(219, clockConfig.getKm_src());
                }
                supportSQLiteStatement.bindLong(220, clockConfig.getKm_x());
                supportSQLiteStatement.bindLong(221, clockConfig.getKm_y());
                if (clockConfig.getKm_num_src() == null) {
                    supportSQLiteStatement.bindNull(222);
                } else {
                    supportSQLiteStatement.bindString(222, clockConfig.getKm_num_src());
                }
                if (clockConfig.getKm_comma_src() == null) {
                    supportSQLiteStatement.bindNull(223);
                } else {
                    supportSQLiteStatement.bindString(223, clockConfig.getKm_comma_src());
                }
                if (clockConfig.getKm_num_type() == null) {
                    supportSQLiteStatement.bindNull(224);
                } else {
                    supportSQLiteStatement.bindString(224, clockConfig.getKm_num_type());
                }
                supportSQLiteStatement.bindLong(225, clockConfig.getKm_show_type());
                supportSQLiteStatement.bindLong(RadioCdmaSmsConst.UDH_OTHER_SIZE, clockConfig.getKm_num_x());
                supportSQLiteStatement.bindLong(227, clockConfig.getKm_num_y());
                if (clockConfig.getKm_end_src() == null) {
                    supportSQLiteStatement.bindNull(228);
                } else {
                    supportSQLiteStatement.bindString(228, clockConfig.getKm_end_src());
                }
                if (clockConfig.getShow_weather() == null) {
                    supportSQLiteStatement.bindNull(RadioCdmaSmsConst.USER_DATA_MAX);
                } else {
                    supportSQLiteStatement.bindString(RadioCdmaSmsConst.USER_DATA_MAX, clockConfig.getShow_weather());
                }
                if (clockConfig.getShow_temperature() == null) {
                    supportSQLiteStatement.bindNull(230);
                } else {
                    supportSQLiteStatement.bindString(230, clockConfig.getShow_temperature());
                }
                supportSQLiteStatement.bindLong(231, clockConfig.getTemperature_show_type());
                supportSQLiteStatement.bindLong(232, clockConfig.getTemperature_num_type());
                supportSQLiteStatement.bindLong(233, clockConfig.getTemperature_x());
                supportSQLiteStatement.bindLong(234, clockConfig.getTemperature_y());
                supportSQLiteStatement.bindLong(235, clockConfig.getTemperature_x_2());
                supportSQLiteStatement.bindLong(236, clockConfig.getTemperature_y_2());
                if (clockConfig.getShow_now_tem() == null) {
                    supportSQLiteStatement.bindNull(237);
                } else {
                    supportSQLiteStatement.bindString(237, clockConfig.getShow_now_tem());
                }
                if (clockConfig.getNow_tem_show_type() == null) {
                    supportSQLiteStatement.bindNull(238);
                } else {
                    supportSQLiteStatement.bindString(238, clockConfig.getNow_tem_show_type());
                }
                supportSQLiteStatement.bindLong(239, clockConfig.getNow_tem_x());
                supportSQLiteStatement.bindLong(240, clockConfig.getNow_tem_y());
                if (clockConfig.getTemperature_num_src() == null) {
                    supportSQLiteStatement.bindNull(241);
                } else {
                    supportSQLiteStatement.bindString(241, clockConfig.getTemperature_num_src());
                }
                if (clockConfig.getTemperature_sub_src() == null) {
                    supportSQLiteStatement.bindNull(LastCallFailCause.IMSI_UNKNOWN_IN_VLR);
                } else {
                    supportSQLiteStatement.bindString(LastCallFailCause.IMSI_UNKNOWN_IN_VLR, clockConfig.getTemperature_sub_src());
                }
                if (clockConfig.getTemperature_sign_src() == null) {
                    supportSQLiteStatement.bindNull(243);
                } else {
                    supportSQLiteStatement.bindString(243, clockConfig.getTemperature_sign_src());
                }
                if (clockConfig.getTemperature_splt_src() == null) {
                    supportSQLiteStatement.bindNull(244);
                } else {
                    supportSQLiteStatement.bindString(244, clockConfig.getTemperature_splt_src());
                }
                if (clockConfig.getShow_diagram() == null) {
                    supportSQLiteStatement.bindNull(245);
                } else {
                    supportSQLiteStatement.bindString(245, clockConfig.getShow_diagram());
                }
                supportSQLiteStatement.bindLong(246, clockConfig.getDiagram_x());
                supportSQLiteStatement.bindLong(LastCallFailCause.RADIO_OFF, clockConfig.getDiagram_y());
                supportSQLiteStatement.bindLong(LastCallFailCause.OUT_OF_SERVICE, clockConfig.getShowsignal());
                supportSQLiteStatement.bindLong(LastCallFailCause.NO_VALID_SIM, clockConfig.getShow_signal());
                if (clockConfig.getSignal_src() == null) {
                    supportSQLiteStatement.bindNull(250);
                } else {
                    supportSQLiteStatement.bindString(250, clockConfig.getSignal_src());
                }
                supportSQLiteStatement.bindLong(LastCallFailCause.NETWORK_RESP_TIMEOUT, clockConfig.getSignal_x());
                supportSQLiteStatement.bindLong(LastCallFailCause.NETWORK_REJECT, clockConfig.getSignal_y());
                if (clockConfig.getShow_user_name() == null) {
                    supportSQLiteStatement.bindNull(LastCallFailCause.RADIO_ACCESS_FAILURE);
                } else {
                    supportSQLiteStatement.bindString(LastCallFailCause.RADIO_ACCESS_FAILURE, clockConfig.getShow_user_name());
                }
                if (clockConfig.getName_show_type() == null) {
                    supportSQLiteStatement.bindNull(LastCallFailCause.RADIO_LINK_FAILURE);
                } else {
                    supportSQLiteStatement.bindString(LastCallFailCause.RADIO_LINK_FAILURE, clockConfig.getName_show_type());
                }
                supportSQLiteStatement.bindLong(255, clockConfig.getName_x());
                supportSQLiteStatement.bindLong(256, clockConfig.getName_y());
                if (clockConfig.getShow_operator() == null) {
                    supportSQLiteStatement.bindNull(257);
                } else {
                    supportSQLiteStatement.bindString(257, clockConfig.getShow_operator());
                }
                if (clockConfig.getOperator_show_type() == null) {
                    supportSQLiteStatement.bindNull(LastCallFailCause.RADIO_RELEASE_NORMAL);
                } else {
                    supportSQLiteStatement.bindString(LastCallFailCause.RADIO_RELEASE_NORMAL, clockConfig.getOperator_show_type());
                }
                supportSQLiteStatement.bindLong(LastCallFailCause.RADIO_RELEASE_ABNORMAL, clockConfig.getOperator_x());
                supportSQLiteStatement.bindLong(LastCallFailCause.ACCESS_CLASS_BLOCKED, clockConfig.getOperator_y());
                if (clockConfig.getShow_btn_call() == null) {
                    supportSQLiteStatement.bindNull(LastCallFailCause.NETWORK_DETACH);
                } else {
                    supportSQLiteStatement.bindString(LastCallFailCause.NETWORK_DETACH, clockConfig.getShow_btn_call());
                }
                if (clockConfig.getBtn_call_src() == null) {
                    supportSQLiteStatement.bindNull(262);
                } else {
                    supportSQLiteStatement.bindString(262, clockConfig.getBtn_call_src());
                }
                supportSQLiteStatement.bindLong(263, clockConfig.getBtn_call_x());
                supportSQLiteStatement.bindLong(264, clockConfig.getBtn_call_y());
                if (clockConfig.getShow_btn_sms() == null) {
                    supportSQLiteStatement.bindNull(265);
                } else {
                    supportSQLiteStatement.bindString(265, clockConfig.getShow_btn_sms());
                }
                if (clockConfig.getBtn_sms_src() == null) {
                    supportSQLiteStatement.bindNull(266);
                } else {
                    supportSQLiteStatement.bindString(266, clockConfig.getBtn_sms_src());
                }
                supportSQLiteStatement.bindLong(267, clockConfig.getBtn_sms_x());
                supportSQLiteStatement.bindLong(268, clockConfig.getBtn_sms_y());
                if (clockConfig.getShow_btn_heart() == null) {
                    supportSQLiteStatement.bindNull(269);
                } else {
                    supportSQLiteStatement.bindString(269, clockConfig.getShow_btn_heart());
                }
                supportSQLiteStatement.bindLong(270, clockConfig.getIs_our_heart());
                if (clockConfig.getBtn_heart_src() == null) {
                    supportSQLiteStatement.bindNull(271);
                } else {
                    supportSQLiteStatement.bindString(271, clockConfig.getBtn_heart_src());
                }
                supportSQLiteStatement.bindLong(272, clockConfig.getBtn_heart_x());
                supportSQLiteStatement.bindLong(273, clockConfig.getBtn_heart_y());
                if (clockConfig.getShow_btn_step() == null) {
                    supportSQLiteStatement.bindNull(274);
                } else {
                    supportSQLiteStatement.bindString(274, clockConfig.getShow_btn_step());
                }
                if (clockConfig.getBtn_step_src() == null) {
                    supportSQLiteStatement.bindNull(275);
                } else {
                    supportSQLiteStatement.bindString(275, clockConfig.getBtn_step_src());
                }
                supportSQLiteStatement.bindLong(276, clockConfig.getBtn_step_x());
                supportSQLiteStatement.bindLong(277, clockConfig.getBtn_step_y());
                if (clockConfig.getShow_btn_wechat() == null) {
                    supportSQLiteStatement.bindNull(278);
                } else {
                    supportSQLiteStatement.bindString(278, clockConfig.getShow_btn_wechat());
                }
                if (clockConfig.getBtn_wechat_src() == null) {
                    supportSQLiteStatement.bindNull(279);
                } else {
                    supportSQLiteStatement.bindString(279, clockConfig.getBtn_wechat_src());
                }
                supportSQLiteStatement.bindLong(280, clockConfig.getBtn_wechat_x());
                supportSQLiteStatement.bindLong(281, clockConfig.getBtn_wechat_y());
                supportSQLiteStatement.bindLong(282, clockConfig.getShow_btn_alipay());
                if (clockConfig.getBtn_alipay_src() == null) {
                    supportSQLiteStatement.bindNull(283);
                } else {
                    supportSQLiteStatement.bindString(283, clockConfig.getBtn_alipay_src());
                }
                supportSQLiteStatement.bindLong(284, clockConfig.getBtn_alipay_x());
                supportSQLiteStatement.bindLong(285, clockConfig.getBtn_alipay_y());
                supportSQLiteStatement.bindLong(286, clockConfig.getShow_btn_stopwatch());
                if (clockConfig.getBtn_stopwatch_src() == null) {
                    supportSQLiteStatement.bindNull(287);
                } else {
                    supportSQLiteStatement.bindString(287, clockConfig.getBtn_stopwatch_src());
                }
                supportSQLiteStatement.bindLong(288, clockConfig.getBtn_stopwatch_x());
                supportSQLiteStatement.bindLong(289, clockConfig.getBtn_stopwatch_y());
                supportSQLiteStatement.bindLong(290, clockConfig.getShow_btn_weather());
                supportSQLiteStatement.bindLong(291, clockConfig.getShow_btn_calo());
                if (clockConfig.getBtn_calo_src() == null) {
                    supportSQLiteStatement.bindNull(292);
                } else {
                    supportSQLiteStatement.bindString(292, clockConfig.getBtn_calo_src());
                }
                supportSQLiteStatement.bindLong(293, clockConfig.getBtn_calo_x());
                supportSQLiteStatement.bindLong(294, clockConfig.getBtn_calo_y());
                if (clockConfig.getTemprature_src() == null) {
                    supportSQLiteStatement.bindNull(295);
                } else {
                    supportSQLiteStatement.bindString(295, clockConfig.getTemprature_src());
                }
                if (clockConfig.getShow_btn_camera() == null) {
                    supportSQLiteStatement.bindNull(296);
                } else {
                    supportSQLiteStatement.bindString(296, clockConfig.getShow_btn_camera());
                }
                if (clockConfig.getBtn_camera_src() == null) {
                    supportSQLiteStatement.bindNull(297);
                } else {
                    supportSQLiteStatement.bindString(297, clockConfig.getBtn_camera_src());
                }
                supportSQLiteStatement.bindLong(298, clockConfig.getBtn_camera_x());
                supportSQLiteStatement.bindLong(299, clockConfig.getBtn_camera_y());
                if (clockConfig.getShow_btn_sos() == null) {
                    supportSQLiteStatement.bindNull(ScanIntervalRange.MAX);
                } else {
                    supportSQLiteStatement.bindString(ScanIntervalRange.MAX, clockConfig.getShow_btn_sos());
                }
                if (clockConfig.getBtn_sos_src() == null) {
                    supportSQLiteStatement.bindNull(301);
                } else {
                    supportSQLiteStatement.bindString(301, clockConfig.getBtn_sos_src());
                }
                supportSQLiteStatement.bindLong(302, clockConfig.getBtn_sos_x());
                supportSQLiteStatement.bindLong(303, clockConfig.getBtn_sos_y());
                if (clockConfig.getShow_special_1() == null) {
                    supportSQLiteStatement.bindNull(304);
                } else {
                    supportSQLiteStatement.bindString(304, clockConfig.getShow_special_1());
                }
                if (clockConfig.getSpecial_1_src() == null) {
                    supportSQLiteStatement.bindNull(305);
                } else {
                    supportSQLiteStatement.bindString(305, clockConfig.getSpecial_1_src());
                }
                if (clockConfig.getSpecial_1_position() == null) {
                    supportSQLiteStatement.bindNull(306);
                } else {
                    supportSQLiteStatement.bindString(306, clockConfig.getSpecial_1_position());
                }
                supportSQLiteStatement.bindLong(307, clockConfig.getSpecial_x());
                supportSQLiteStatement.bindLong(308, clockConfig.getSpecial_y());
                supportSQLiteStatement.bindLong(309, clockConfig.getSupport_multiple_change());
                supportSQLiteStatement.bindLong(310, clockConfig.getShow_lunar_year());
                if (clockConfig.getLunar_day_splt_src() == null) {
                    supportSQLiteStatement.bindNull(311);
                } else {
                    supportSQLiteStatement.bindString(311, clockConfig.getLunar_day_splt_src());
                }
                if (clockConfig.getLunar_month_splt_src() == null) {
                    supportSQLiteStatement.bindNull(312);
                } else {
                    supportSQLiteStatement.bindString(312, clockConfig.getLunar_month_splt_src());
                }
                if (clockConfig.getLunar_year_splt_src() == null) {
                    supportSQLiteStatement.bindNull(313);
                } else {
                    supportSQLiteStatement.bindString(313, clockConfig.getLunar_year_splt_src());
                }
                if (clockConfig.getAm_src() == null) {
                    supportSQLiteStatement.bindNull(314);
                } else {
                    supportSQLiteStatement.bindString(314, clockConfig.getAm_src());
                }
                if (clockConfig.getPm_src() == null) {
                    supportSQLiteStatement.bindNull(315);
                } else {
                    supportSQLiteStatement.bindString(315, clockConfig.getPm_src());
                }
                supportSQLiteStatement.bindLong(TypedValues.AttributesType.TYPE_PATH_ROTATE, clockConfig.getShow_btn_alarm());
                if (clockConfig.getBtn_alarm_src() == null) {
                    supportSQLiteStatement.bindNull(TypedValues.AttributesType.TYPE_EASING);
                } else {
                    supportSQLiteStatement.bindString(TypedValues.AttributesType.TYPE_EASING, clockConfig.getBtn_alarm_src());
                }
                supportSQLiteStatement.bindLong(TypedValues.AttributesType.TYPE_PIVOT_TARGET, clockConfig.getBtn_alarm_x());
                supportSQLiteStatement.bindLong(319, clockConfig.getBtn_alarm_y());
                supportSQLiteStatement.bindLong(320, clockConfig.getBg_btn_change());
                supportSQLiteStatement.bindLong(321, clockConfig.getBg_btn_index());
                supportSQLiteStatement.bindLong(322, clockConfig.getShow_btn_music());
                if (clockConfig.getBtn_music_src() == null) {
                    supportSQLiteStatement.bindNull(323);
                } else {
                    supportSQLiteStatement.bindString(323, clockConfig.getBtn_music_src());
                }
                supportSQLiteStatement.bindLong(324, clockConfig.getBtn_music_x());
                supportSQLiteStatement.bindLong(CallFailCause.EMERGENCY_TEMP_FAILURE, clockConfig.getBtn_music_y());
                supportSQLiteStatement.bindLong(CallFailCause.EMERGENCY_PERM_FAILURE, clockConfig.getSupport_dynamic_change());
                supportSQLiteStatement.bindLong(327, clockConfig.getLevel());
                if (clockConfig.getParent_id() == null) {
                    supportSQLiteStatement.bindNull(328);
                } else {
                    supportSQLiteStatement.bindString(328, clockConfig.getParent_id());
                }
                supportSQLiteStatement.bindLong(329, clockConfig.getNext_id());
                supportSQLiteStatement.bindLong(330, clockConfig.getChange_starttime());
                supportSQLiteStatement.bindLong(331, clockConfig.getChange_endtime());
                if (clockConfig.getBtn_weather_src() == null) {
                    supportSQLiteStatement.bindNull(332);
                } else {
                    supportSQLiteStatement.bindString(332, clockConfig.getBtn_weather_src());
                }
                supportSQLiteStatement.bindLong(333, clockConfig.getBtn_weather_x());
                supportSQLiteStatement.bindLong(334, clockConfig.getBtn_weather_y());
                supportSQLiteStatement.bindLong(335, clockConfig.getShow_btn_calories());
                if (clockConfig.getBtn_calories_src() == null) {
                    supportSQLiteStatement.bindNull(336);
                } else {
                    supportSQLiteStatement.bindString(336, clockConfig.getBtn_calories_src());
                }
                supportSQLiteStatement.bindLong(337, clockConfig.getBtn_calories_x());
                supportSQLiteStatement.bindLong(338, clockConfig.getBtn_calories_y());
                supportSQLiteStatement.bindLong(339, clockConfig.getSupport_compass());
                if (clockConfig.getCompass_src() == null) {
                    supportSQLiteStatement.bindNull(340);
                } else {
                    supportSQLiteStatement.bindString(340, clockConfig.getCompass_src());
                }
                if (clockConfig.getCompass_2_src() == null) {
                    supportSQLiteStatement.bindNull(341);
                } else {
                    supportSQLiteStatement.bindString(341, clockConfig.getCompass_2_src());
                }
                supportSQLiteStatement.bindLong(342, clockConfig.getCompass_x());
                supportSQLiteStatement.bindLong(343, clockConfig.getCompass_y());
                supportSQLiteStatement.bindLong(344, clockConfig.getShow_btn_setting());
                if (clockConfig.getBtn_setting_src() == null) {
                    supportSQLiteStatement.bindNull(345);
                } else {
                    supportSQLiteStatement.bindString(345, clockConfig.getBtn_setting_src());
                }
                supportSQLiteStatement.bindLong(346, clockConfig.getBtn_setting_x());
                supportSQLiteStatement.bindLong(347, clockConfig.getBtn_setting_y());
                supportSQLiteStatement.bindLong(348, clockConfig.getSupport_click_change());
                supportSQLiteStatement.bindLong(349, clockConfig.getClick_id_is_current());
                supportSQLiteStatement.bindLong(350, clockConfig.getCompass_show_detail_degree());
                if (clockConfig.getCompass_direction_src() == null) {
                    supportSQLiteStatement.bindNull(351);
                } else {
                    supportSQLiteStatement.bindString(351, clockConfig.getCompass_direction_src());
                }
                supportSQLiteStatement.bindLong(352, clockConfig.getCompass_direction_x());
                supportSQLiteStatement.bindLong(353, clockConfig.getCompass_direction_y());
                if (clockConfig.getCompass_direction_2_src() == null) {
                    supportSQLiteStatement.bindNull(354);
                } else {
                    supportSQLiteStatement.bindString(354, clockConfig.getCompass_direction_2_src());
                }
                supportSQLiteStatement.bindLong(355, clockConfig.getCompass_direction_2_x());
                supportSQLiteStatement.bindLong(356, clockConfig.getCompass_direction_2_y());
                if (clockConfig.getCompass_direction_3_src() == null) {
                    supportSQLiteStatement.bindNull(357);
                } else {
                    supportSQLiteStatement.bindString(357, clockConfig.getCompass_direction_3_src());
                }
                supportSQLiteStatement.bindLong(358, clockConfig.getCompass_direction_3_x());
                supportSQLiteStatement.bindLong(359, clockConfig.getCompass_direction_3_y());
                if (clockConfig.getCompass_direction_degree_src() == null) {
                    supportSQLiteStatement.bindNull(360);
                } else {
                    supportSQLiteStatement.bindString(360, clockConfig.getCompass_direction_degree_src());
                }
                supportSQLiteStatement.bindLong(361, clockConfig.getCompass_direction_degree_x());
                supportSQLiteStatement.bindLong(362, clockConfig.getCompass_direction_degree_y());
                if (clockConfig.getCompass_direction_degree_unit() == null) {
                    supportSQLiteStatement.bindNull(363);
                } else {
                    supportSQLiteStatement.bindString(363, clockConfig.getCompass_direction_degree_unit());
                }
                if (clockConfig.getCompass_degree_1_src() == null) {
                    supportSQLiteStatement.bindNull(364);
                } else {
                    supportSQLiteStatement.bindString(364, clockConfig.getCompass_degree_1_src());
                }
                supportSQLiteStatement.bindLong(365, clockConfig.getCompass_degree_1_x());
                supportSQLiteStatement.bindLong(366, clockConfig.getCompass_degree_1_y());
                if (clockConfig.getCompass_degree_2_src() == null) {
                    supportSQLiteStatement.bindNull(367);
                } else {
                    supportSQLiteStatement.bindString(367, clockConfig.getCompass_degree_2_src());
                }
                supportSQLiteStatement.bindLong(368, clockConfig.getCompass_degree_2_x());
                supportSQLiteStatement.bindLong(369, clockConfig.getCompass_degree_2_y());
                if (clockConfig.getCompass_degree_3_src() == null) {
                    supportSQLiteStatement.bindNull(370);
                } else {
                    supportSQLiteStatement.bindString(370, clockConfig.getCompass_degree_3_src());
                }
                supportSQLiteStatement.bindLong(371, clockConfig.getCompass_degree_3_x());
                supportSQLiteStatement.bindLong(372, clockConfig.getCompass_degree_3_y());
                supportSQLiteStatement.bindLong(373, clockConfig.getShow_connect_animation());
                supportSQLiteStatement.bindLong(374, clockConfig.getConnect_animation_x());
                supportSQLiteStatement.bindLong(375, clockConfig.getConnect_animation_y());
                supportSQLiteStatement.bindLong(376, clockConfig.getConnect_animation_count());
                supportSQLiteStatement.bindLong(377, clockConfig.getShow_state());
                supportSQLiteStatement.bindLong(378, clockConfig.getState_x());
                supportSQLiteStatement.bindLong(379, clockConfig.getState_y());
                supportSQLiteStatement.bindLong(380, clockConfig.getAction_1_cut_position());
                supportSQLiteStatement.bindLong(381, clockConfig.getAction_2_cut_position());
                supportSQLiteStatement.bindLong(382, clockConfig.getAction_3_cut_position());
                supportSQLiteStatement.bindLong(383, clockConfig.getShow_btn_googleplay());
                if (clockConfig.getBtn_googleplay_src() == null) {
                    supportSQLiteStatement.bindNull(384);
                } else {
                    supportSQLiteStatement.bindString(384, clockConfig.getBtn_googleplay_src());
                }
                supportSQLiteStatement.bindLong(385, clockConfig.getBtn_googleplay_x());
                supportSQLiteStatement.bindLong(386, clockConfig.getBtn_googleplay_y());
                supportSQLiteStatement.bindLong(387, clockConfig.getShow_month_2());
                supportSQLiteStatement.bindLong(388, clockConfig.getMonth_type_2());
                if (clockConfig.getMonth_src_2() == null) {
                    supportSQLiteStatement.bindNull(389);
                } else {
                    supportSQLiteStatement.bindString(389, clockConfig.getMonth_src_2());
                }
                supportSQLiteStatement.bindLong(390, clockConfig.getMonth_x_2());
                supportSQLiteStatement.bindLong(391, clockConfig.getMonth_y_2());
                supportSQLiteStatement.bindLong(392, clockConfig.getTime_special_new());
                if (clockConfig.getTime_special_hour_ten_src() == null) {
                    supportSQLiteStatement.bindNull(393);
                } else {
                    supportSQLiteStatement.bindString(393, clockConfig.getTime_special_hour_ten_src());
                }
                if (clockConfig.getTime_special_hour_src() == null) {
                    supportSQLiteStatement.bindNull(394);
                } else {
                    supportSQLiteStatement.bindString(394, clockConfig.getTime_special_hour_src());
                }
                if (clockConfig.getTime_special_min_ten_src() == null) {
                    supportSQLiteStatement.bindNull(395);
                } else {
                    supportSQLiteStatement.bindString(395, clockConfig.getTime_special_min_ten_src());
                }
                if (clockConfig.getTime_special_min_src() == null) {
                    supportSQLiteStatement.bindNull(396);
                } else {
                    supportSQLiteStatement.bindString(396, clockConfig.getTime_special_min_src());
                }
                supportSQLiteStatement.bindLong(397, clockConfig.getShow_kcal_progress());
                supportSQLiteStatement.bindLong(398, clockConfig.getKcal_progress_x());
                supportSQLiteStatement.bindLong(399, clockConfig.getKcal_progress_y());
                if (clockConfig.getKcal_progress_src() == null) {
                    supportSQLiteStatement.bindNull(400);
                } else {
                    supportSQLiteStatement.bindString(400, clockConfig.getKcal_progress_src());
                }
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_CURVE_FIT, clockConfig.getOpen_kcal_arc_show());
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_VISIBILITY, clockConfig.getKcal_arc_type());
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_ALPHA, clockConfig.getKcal_arc_center_x());
                supportSQLiteStatement.bindLong(404, clockConfig.getKcal_arc_center_y());
                supportSQLiteStatement.bindLong(405, clockConfig.getOpen_power_arc_show());
                supportSQLiteStatement.bindLong(406, clockConfig.getPower_arc_type());
                supportSQLiteStatement.bindLong(407, clockConfig.getPower_arc_center_x());
                supportSQLiteStatement.bindLong(408, clockConfig.getPower_arc_center_y());
                supportSQLiteStatement.bindLong(409, clockConfig.getShow_btn_timer());
                if (clockConfig.getBtn_timer_src() == null) {
                    supportSQLiteStatement.bindNull(410);
                } else {
                    supportSQLiteStatement.bindString(410, clockConfig.getBtn_timer_src());
                }
                supportSQLiteStatement.bindLong(411, clockConfig.getBtn_timer_x());
                supportSQLiteStatement.bindLong(412, clockConfig.getBtn_timer_y());
                supportSQLiteStatement.bindLong(413, clockConfig.getShow_btn_sleep());
                if (clockConfig.getBtn_sleep_src() == null) {
                    supportSQLiteStatement.bindNull(414);
                } else {
                    supportSQLiteStatement.bindString(414, clockConfig.getBtn_sleep_src());
                }
                supportSQLiteStatement.bindLong(415, clockConfig.getBtn_sleep_x());
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_PATH_ROTATE, clockConfig.getBtn_sleep_y());
                supportSQLiteStatement.bindLong(417, clockConfig.getShow_btn_bloodpressure());
                if (clockConfig.getBtn_bloodpressure_src() == null) {
                    supportSQLiteStatement.bindNull(418);
                } else {
                    supportSQLiteStatement.bindString(418, clockConfig.getBtn_bloodpressure_src());
                }
                supportSQLiteStatement.bindLong(419, clockConfig.getBtn_bloodpressure_x());
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_EASING, clockConfig.getBtn_bloodpressure_y());
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_WAVE_SHAPE, clockConfig.getShow_btn_sport_record());
                if (clockConfig.getBtn_sport_record_src() == null) {
                    supportSQLiteStatement.bindNull(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE);
                } else {
                    supportSQLiteStatement.bindString(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, clockConfig.getBtn_sport_record_src());
                }
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_WAVE_PERIOD, clockConfig.getBtn_sport_record_x());
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_WAVE_OFFSET, clockConfig.getBtn_sport_record_y());
                supportSQLiteStatement.bindLong(TypedValues.CycleType.TYPE_WAVE_PHASE, clockConfig.getLottie_hierarchy());
                supportSQLiteStatement.bindLong(426, clockConfig.getShow_heart_progress());
                supportSQLiteStatement.bindLong(427, clockConfig.getHeart_progress_x());
                supportSQLiteStatement.bindLong(428, clockConfig.getHeart_progress_y());
                if (clockConfig.getHeart_progress_src() == null) {
                    supportSQLiteStatement.bindNull(429);
                } else {
                    supportSQLiteStatement.bindString(429, clockConfig.getHeart_progress_src());
                }
                supportSQLiteStatement.bindLong(430, clockConfig.getShow_btn_calculator());
                if (clockConfig.getBtn_calculator_src() == null) {
                    supportSQLiteStatement.bindNull(431);
                } else {
                    supportSQLiteStatement.bindString(431, clockConfig.getBtn_calculator_src());
                }
                supportSQLiteStatement.bindLong(432, clockConfig.getBtn_calculator_x());
                supportSQLiteStatement.bindLong(433, clockConfig.getBtn_calculator_y());
                supportSQLiteStatement.bindLong(434, clockConfig.getTime_special_drag_3d());
                if (clockConfig.getPrev_HourTen_Position() == null) {
                    supportSQLiteStatement.bindNull(435);
                } else {
                    supportSQLiteStatement.bindString(435, clockConfig.getPrev_HourTen_Position());
                }
                if (clockConfig.getPrev_HourGe_Position() == null) {
                    supportSQLiteStatement.bindNull(436);
                } else {
                    supportSQLiteStatement.bindString(436, clockConfig.getPrev_HourGe_Position());
                }
                if (clockConfig.getCurrent_HourTen_Position() == null) {
                    supportSQLiteStatement.bindNull(437);
                } else {
                    supportSQLiteStatement.bindString(437, clockConfig.getCurrent_HourTen_Position());
                }
                if (clockConfig.getCurrent_HourGe_Position() == null) {
                    supportSQLiteStatement.bindNull(438);
                } else {
                    supportSQLiteStatement.bindString(438, clockConfig.getCurrent_HourGe_Position());
                }
                if (clockConfig.getNext_HourTen_Position() == null) {
                    supportSQLiteStatement.bindNull(439);
                } else {
                    supportSQLiteStatement.bindString(439, clockConfig.getNext_HourTen_Position());
                }
                if (clockConfig.getNext_HourGe_Position() == null) {
                    supportSQLiteStatement.bindNull(440);
                } else {
                    supportSQLiteStatement.bindString(440, clockConfig.getNext_HourGe_Position());
                }
                if (clockConfig.getPrev_MinTen_Position() == null) {
                    supportSQLiteStatement.bindNull(441);
                } else {
                    supportSQLiteStatement.bindString(441, clockConfig.getPrev_MinTen_Position());
                }
                if (clockConfig.getPrev_MinGe_Position() == null) {
                    supportSQLiteStatement.bindNull(442);
                } else {
                    supportSQLiteStatement.bindString(442, clockConfig.getPrev_MinGe_Position());
                }
                if (clockConfig.getCurrent_MinTen_Position() == null) {
                    supportSQLiteStatement.bindNull(443);
                } else {
                    supportSQLiteStatement.bindString(443, clockConfig.getCurrent_MinTen_Position());
                }
                if (clockConfig.getCurrent_MinGe_Position() == null) {
                    supportSQLiteStatement.bindNull(444);
                } else {
                    supportSQLiteStatement.bindString(444, clockConfig.getCurrent_MinGe_Position());
                }
                if (clockConfig.getNext_MinTen_Position() == null) {
                    supportSQLiteStatement.bindNull(445);
                } else {
                    supportSQLiteStatement.bindString(445, clockConfig.getNext_MinTen_Position());
                }
                if (clockConfig.getNext_MinGe_Position() == null) {
                    supportSQLiteStatement.bindNull(446);
                } else {
                    supportSQLiteStatement.bindString(446, clockConfig.getNext_MinGe_Position());
                }
                supportSQLiteStatement.bindLong(447, clockConfig.getNeed_split_day());
                supportSQLiteStatement.bindLong(448, clockConfig.getSplit_day_x());
                supportSQLiteStatement.bindLong(449, clockConfig.getSplit_day_y());
                supportSQLiteStatement.bindLong(450, clockConfig.getOpen_now_tem_arc_show());
                supportSQLiteStatement.bindLong(451, clockConfig.getNow_tem_arc_type());
                supportSQLiteStatement.bindLong(452, clockConfig.getNow_tem_arc_center_x());
                supportSQLiteStatement.bindLong(453, clockConfig.getNow_tem_arc_center_y());
                supportSQLiteStatement.bindLong(454, clockConfig.getShow_km_progress());
                supportSQLiteStatement.bindLong(455, clockConfig.getKm_progress_x());
                supportSQLiteStatement.bindLong(456, clockConfig.getKm_progress_y());
                if (clockConfig.getKm_progress_src() == null) {
                    supportSQLiteStatement.bindNull(457);
                } else {
                    supportSQLiteStatement.bindString(457, clockConfig.getKm_progress_src());
                }
                supportSQLiteStatement.bindLong(458, clockConfig.getOpen_km_arc_show());
                supportSQLiteStatement.bindLong(459, clockConfig.getKm_arc_type());
                supportSQLiteStatement.bindLong(460, clockConfig.getKm_arc_center_x());
                supportSQLiteStatement.bindLong(461, clockConfig.getKm_arc_center_y());
                supportSQLiteStatement.bindLong(462, clockConfig.getTime_rotate());
                supportSQLiteStatement.bindLong(463, clockConfig.getTime_rotate_degree());
                supportSQLiteStatement.bindLong(464, clockConfig.getHeart_num_rotate());
                supportSQLiteStatement.bindLong(465, clockConfig.getHeart_num_rotate_degree());
                supportSQLiteStatement.bindLong(466, clockConfig.getShow_oxygen());
                if (clockConfig.getOxygen_src() == null) {
                    supportSQLiteStatement.bindNull(467);
                } else {
                    supportSQLiteStatement.bindString(467, clockConfig.getOxygen_src());
                }
                supportSQLiteStatement.bindLong(468, clockConfig.getOxygen_x());
                supportSQLiteStatement.bindLong(469, clockConfig.getOxygen_y());
                if (clockConfig.getOxygen_num_src() == null) {
                    supportSQLiteStatement.bindNull(470);
                } else {
                    supportSQLiteStatement.bindString(470, clockConfig.getOxygen_num_src());
                }
                if (clockConfig.getOxygen_sign_src() == null) {
                    supportSQLiteStatement.bindNull(471);
                } else {
                    supportSQLiteStatement.bindString(471, clockConfig.getOxygen_sign_src());
                }
                supportSQLiteStatement.bindLong(472, clockConfig.getOxygen_show_type());
                supportSQLiteStatement.bindLong(473, clockConfig.getOxygen_num_x());
                supportSQLiteStatement.bindLong(474, clockConfig.getOxygen_num_y());
                supportSQLiteStatement.bindLong(475, clockConfig.getTime_change_counter());
                if (clockConfig.getTime_hour_src_2() == null) {
                    supportSQLiteStatement.bindNull(476);
                } else {
                    supportSQLiteStatement.bindString(476, clockConfig.getTime_hour_src_2());
                }
                if (clockConfig.getTime_min_src_2() == null) {
                    supportSQLiteStatement.bindNull(477);
                } else {
                    supportSQLiteStatement.bindString(477, clockConfig.getTime_min_src_2());
                }
                if (clockConfig.getTime_sec_src_2() == null) {
                    supportSQLiteStatement.bindNull(478);
                } else {
                    supportSQLiteStatement.bindString(478, clockConfig.getTime_sec_src_2());
                }
                if (clockConfig.getTime_splt_src_2() == null) {
                    supportSQLiteStatement.bindNull(479);
                } else {
                    supportSQLiteStatement.bindString(479, clockConfig.getTime_splt_src_2());
                }
                if (clockConfig.getTime_splt_2_src_2() == null) {
                    supportSQLiteStatement.bindNull(480);
                } else {
                    supportSQLiteStatement.bindString(480, clockConfig.getTime_splt_2_src_2());
                }
                if (clockConfig.getTime_hour_src_3() == null) {
                    supportSQLiteStatement.bindNull(481);
                } else {
                    supportSQLiteStatement.bindString(481, clockConfig.getTime_hour_src_3());
                }
                if (clockConfig.getTime_min_src_3() == null) {
                    supportSQLiteStatement.bindNull(482);
                } else {
                    supportSQLiteStatement.bindString(482, clockConfig.getTime_min_src_3());
                }
                if (clockConfig.getTime_sec_src_3() == null) {
                    supportSQLiteStatement.bindNull(483);
                } else {
                    supportSQLiteStatement.bindString(483, clockConfig.getTime_sec_src_3());
                }
                if (clockConfig.getTime_splt_src_3() == null) {
                    supportSQLiteStatement.bindNull(484);
                } else {
                    supportSQLiteStatement.bindString(484, clockConfig.getTime_splt_src_3());
                }
                if (clockConfig.getTime_splt_2_src_3() == null) {
                    supportSQLiteStatement.bindNull(485);
                } else {
                    supportSQLiteStatement.bindString(485, clockConfig.getTime_splt_2_src_3());
                }
                if (clockConfig.getTime_hour_src_4() == null) {
                    supportSQLiteStatement.bindNull(486);
                } else {
                    supportSQLiteStatement.bindString(486, clockConfig.getTime_hour_src_4());
                }
                if (clockConfig.getTime_min_src_4() == null) {
                    supportSQLiteStatement.bindNull(487);
                } else {
                    supportSQLiteStatement.bindString(487, clockConfig.getTime_min_src_4());
                }
                if (clockConfig.getTime_sec_src_4() == null) {
                    supportSQLiteStatement.bindNull(488);
                } else {
                    supportSQLiteStatement.bindString(488, clockConfig.getTime_sec_src_4());
                }
                if (clockConfig.getTime_splt_src_4() == null) {
                    supportSQLiteStatement.bindNull(489);
                } else {
                    supportSQLiteStatement.bindString(489, clockConfig.getTime_splt_src_4());
                }
                if (clockConfig.getTime_splt_2_src_4() == null) {
                    supportSQLiteStatement.bindNull(490);
                } else {
                    supportSQLiteStatement.bindString(490, clockConfig.getTime_splt_2_src_4());
                }
                supportSQLiteStatement.bindLong(491, clockConfig.getDate_rotate());
                supportSQLiteStatement.bindLong(492, clockConfig.getDate_rotate_degree());
                supportSQLiteStatement.bindLong(493, clockConfig.getNeed_split_hour());
                if (clockConfig.getSplit_hour_src() == null) {
                    supportSQLiteStatement.bindNull(494);
                } else {
                    supportSQLiteStatement.bindString(494, clockConfig.getSplit_hour_src());
                }
                supportSQLiteStatement.bindLong(495, clockConfig.getSplit_hour_x());
                supportSQLiteStatement.bindLong(496, clockConfig.getSplit_hour_y());
                supportSQLiteStatement.bindLong(497, clockConfig.getNeed_split_min());
                if (clockConfig.getSplit_min_src() == null) {
                    supportSQLiteStatement.bindNull(498);
                } else {
                    supportSQLiteStatement.bindString(498, clockConfig.getSplit_min_src());
                }
                supportSQLiteStatement.bindLong(499, clockConfig.getSplit_min_x());
                supportSQLiteStatement.bindLong(500, clockConfig.getSplit_min_y());
                supportSQLiteStatement.bindLong(501, clockConfig.getSupport_scale());
                supportSQLiteStatement.bindLong(502, clockConfig.getShow_compass_num());
                if (clockConfig.getCompass_num_src() == null) {
                    supportSQLiteStatement.bindNull(503);
                } else {
                    supportSQLiteStatement.bindString(503, clockConfig.getCompass_num_src());
                }
                supportSQLiteStatement.bindLong(504, clockConfig.getCompass_show_type());
                supportSQLiteStatement.bindLong(505, clockConfig.getCompass_num_x());
                supportSQLiteStatement.bindLong(506, clockConfig.getCompass_num_y());
                if (clockConfig.getCompass_num_src_prefix() == null) {
                    supportSQLiteStatement.bindNull(507);
                } else {
                    supportSQLiteStatement.bindString(507, clockConfig.getCompass_num_src_prefix());
                }
                if (clockConfig.getCompass_num_src_sign() == null) {
                    supportSQLiteStatement.bindNull(508);
                } else {
                    supportSQLiteStatement.bindString(508, clockConfig.getCompass_num_src_sign());
                }
                supportSQLiteStatement.bindLong(509, clockConfig.getShow_btn_oxygen());
                if (clockConfig.getBtn_oxygen_src() == null) {
                    supportSQLiteStatement.bindNull(510);
                } else {
                    supportSQLiteStatement.bindString(510, clockConfig.getBtn_oxygen_src());
                }
                supportSQLiteStatement.bindLong(511, clockConfig.getBtn_oxygen_x());
                supportSQLiteStatement.bindLong(512, clockConfig.getBtn_oxygen_y());
                supportSQLiteStatement.bindLong(513, clockConfig.getShow_btn_calendar());
                if (clockConfig.getBtn_calendar_src() == null) {
                    supportSQLiteStatement.bindNull(RadioError.OEM_ERROR_14);
                } else {
                    supportSQLiteStatement.bindString(RadioError.OEM_ERROR_14, clockConfig.getBtn_calendar_src());
                }
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_15, clockConfig.getBtn_calendar_x());
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_16, clockConfig.getBtn_calendar_y());
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_17, clockConfig.getShow_btn_compass());
                if (clockConfig.getBtn_compass_src() == null) {
                    supportSQLiteStatement.bindNull(RadioError.OEM_ERROR_18);
                } else {
                    supportSQLiteStatement.bindString(RadioError.OEM_ERROR_18, clockConfig.getBtn_compass_src());
                }
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_19, clockConfig.getBtn_compass_x());
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_20, clockConfig.getBtn_compass_y());
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_21, clockConfig.getPointer_disable_scale());
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_22, clockConfig.getShow_chinse_time());
                if (clockConfig.getChinse_time_src() == null) {
                    supportSQLiteStatement.bindNull(RadioError.OEM_ERROR_23);
                } else {
                    supportSQLiteStatement.bindString(RadioError.OEM_ERROR_23, clockConfig.getChinse_time_src());
                }
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_24, clockConfig.getChinse_time_x());
                supportSQLiteStatement.bindLong(RadioError.OEM_ERROR_25, clockConfig.getChinse_time_y());
                supportSQLiteStatement.bindLong(526, clockConfig.getShow_btn_photo());
                if (clockConfig.getBtn_photo_src() == null) {
                    supportSQLiteStatement.bindNull(527);
                } else {
                    supportSQLiteStatement.bindString(527, clockConfig.getBtn_photo_src());
                }
                supportSQLiteStatement.bindLong(528, clockConfig.getBtn_photo_x());
                supportSQLiteStatement.bindLong(529, clockConfig.getBtn_photo_y());
                supportSQLiteStatement.bindLong(530, clockConfig.getShow_btn_contact());
                if (clockConfig.getBtn_contact_src() == null) {
                    supportSQLiteStatement.bindNull(531);
                } else {
                    supportSQLiteStatement.bindString(531, clockConfig.getBtn_contact_src());
                }
                supportSQLiteStatement.bindLong(532, clockConfig.getBtn_contact_x());
                supportSQLiteStatement.bindLong(533, clockConfig.getBtn_contact_y());
                supportSQLiteStatement.bindLong(534, clockConfig.getKcal_num_rotate());
                supportSQLiteStatement.bindLong(535, clockConfig.getKcal_num_rotate_degree());
                supportSQLiteStatement.bindLong(536, clockConfig.getShow_power_progress());
                if (clockConfig.getPower_progress_src() == null) {
                    supportSQLiteStatement.bindNull(537);
                } else {
                    supportSQLiteStatement.bindString(537, clockConfig.getPower_progress_src());
                }
                supportSQLiteStatement.bindLong(538, clockConfig.getPower_progress_x());
                supportSQLiteStatement.bindLong(539, clockConfig.getPower_progress_y());
                if (clockConfig.getPower_src() == null) {
                    supportSQLiteStatement.bindNull(540);
                } else {
                    supportSQLiteStatement.bindString(540, clockConfig.getPower_src());
                }
                supportSQLiteStatement.bindLong(541, clockConfig.getPower_src_x());
                supportSQLiteStatement.bindLong(542, clockConfig.getPower_src_y());
                supportSQLiteStatement.bindLong(543, clockConfig.getVideo_type());
                supportSQLiteStatement.bindLong(544, clockConfig.getStep_keep_number_length());
                supportSQLiteStatement.bindLong(545, clockConfig.getKcal_keep_number_length());
                supportSQLiteStatement.bindLong(546, clockConfig.getKm_keep_number_length());
                supportSQLiteStatement.bindLong(547, clockConfig.getStep_num_rotate());
                supportSQLiteStatement.bindLong(548, clockConfig.getStep_num_rotate_degree());
                supportSQLiteStatement.bindLong(549, clockConfig.getShow_btn_style());
                if (clockConfig.getBtn_style_src() == null) {
                    supportSQLiteStatement.bindNull(550);
                } else {
                    supportSQLiteStatement.bindString(550, clockConfig.getBtn_style_src());
                }
                supportSQLiteStatement.bindLong(551, clockConfig.getBtn_style_x());
                supportSQLiteStatement.bindLong(552, clockConfig.getBtn_style_y());
                supportSQLiteStatement.bindLong(553, clockConfig.getNeed_split_sec());
                if (clockConfig.getSplit_sec_src() == null) {
                    supportSQLiteStatement.bindNull(554);
                } else {
                    supportSQLiteStatement.bindString(554, clockConfig.getSplit_sec_src());
                }
                supportSQLiteStatement.bindLong(555, clockConfig.getSplit_sec_x());
                supportSQLiteStatement.bindLong(556, clockConfig.getSplit_sec_y());
                supportSQLiteStatement.bindLong(557, clockConfig.getOpen_oxygen_arc_show());
                supportSQLiteStatement.bindLong(558, clockConfig.getOxygen_arc_type());
                supportSQLiteStatement.bindLong(559, clockConfig.getOxygen_arc_center_x());
                supportSQLiteStatement.bindLong(560, clockConfig.getOxygen_arc_center_y());
                supportSQLiteStatement.bindLong(561, clockConfig.getShow_oxygen_progress());
                if (clockConfig.getOxygen_progress_src() == null) {
                    supportSQLiteStatement.bindNull(562);
                } else {
                    supportSQLiteStatement.bindString(562, clockConfig.getOxygen_progress_src());
                }
                supportSQLiteStatement.bindLong(563, clockConfig.getOxygen_progress_x());
                supportSQLiteStatement.bindLong(564, clockConfig.getOxygen_progress_y());
                supportSQLiteStatement.bindLong(565, clockConfig.getShow_week_donts());
                if (clockConfig.getWeek_donts_src() == null) {
                    supportSQLiteStatement.bindNull(566);
                } else {
                    supportSQLiteStatement.bindString(566, clockConfig.getWeek_donts_src());
                }
                supportSQLiteStatement.bindLong(567, clockConfig.getWeek_donts_x());
                supportSQLiteStatement.bindLong(568, clockConfig.getWeek_donts_y());
                supportSQLiteStatement.bindLong(569, clockConfig.getShow_btn_flashlight());
                if (clockConfig.getFlashlight_src() == null) {
                    supportSQLiteStatement.bindNull(570);
                } else {
                    supportSQLiteStatement.bindString(570, clockConfig.getFlashlight_src());
                }
                supportSQLiteStatement.bindLong(571, clockConfig.getFlashlight_x());
                supportSQLiteStatement.bindLong(572, clockConfig.getFlashlight_y());
                if (clockConfig.getId() == null) {
                    supportSQLiteStatement.bindNull(573);
                } else {
                    supportSQLiteStatement.bindString(573, clockConfig.getId());
                }
            }
        };
        this.__preparedStmtOfDeleteClockConfigById = new SharedSQLiteStatement(__db) { // from class: com.dw.launcher.data.database.dao.ClockConfigDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "delete from t_clock_config where id = ?";
            }
        };
    }

    @Override // com.dw.launcher.data.database.dao.ClockConfigDao
    public long insert(final ClockConfig clockConfig) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfClockConfig.insertAndReturnId(clockConfig);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.dw.launcher.data.database.dao.ClockConfigDao
    public void updateClickedIdIndexByParentId(final ClockConfig clockConfig) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfClockConfig.handle(clockConfig);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.dw.launcher.data.database.dao.ClockConfigDao
    public int deleteClockConfigById(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteClockConfigById.acquire();
        if (id == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, id);
        }
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteClockConfigById.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.dw.launcher.data.database.dao.ClockConfigDao
    public List<ClockConfig> queryAllFromAssets() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `t_clock_config`.`path` AS `path`, `t_clock_config`.`fromAssets` AS `fromAssets`, `t_clock_config`.`id` AS `id`, `t_clock_config`.`name` AS `name`, `t_clock_config`.`name_en` AS `name_en`, `t_clock_config`.`screentype` AS `screentype`, `t_clock_config`.`dialtype` AS `dialtype`, `t_clock_config`.`coordinate_screen_width` AS `coordinate_screen_width`, `t_clock_config`.`coordinate_screen_height` AS `coordinate_screen_height`, `t_clock_config`.`bg_type` AS `bg_type`, `t_clock_config`.`video` AS `video`, `t_clock_config`.`lottie` AS `lottie`, `t_clock_config`.`bg_animal_keep_for_last_frame` AS `bg_animal_keep_for_last_frame`, `t_clock_config`.`bg_count` AS `bg_count`, `t_clock_config`.`bg_interval` AS `bg_interval`, `t_clock_config`.`bg_is_customize` AS `bg_is_customize`, `t_clock_config`.`hour_pointer_src` AS `hour_pointer_src`, `t_clock_config`.`hour_pointer_x` AS `hour_pointer_x`, `t_clock_config`.`hour_pointer_y` AS `hour_pointer_y`, `t_clock_config`.`minute_pointer_src` AS `minute_pointer_src`, `t_clock_config`.`minute_pointer_x` AS `minute_pointer_x`, `t_clock_config`.`minute_pointer_y` AS `minute_pointer_y`, `t_clock_config`.`second_pointer_src` AS `second_pointer_src`, `t_clock_config`.`second_pointer_type` AS `second_pointer_type`, `t_clock_config`.`second_pointer_x` AS `second_pointer_x`, `t_clock_config`.`second_pointer_y` AS `second_pointer_y`, `t_clock_config`.`second_pointer_animal_type` AS `second_pointer_animal_type`, `t_clock_config`.`dot_src` AS `dot_src`, `t_clock_config`.`dot_x` AS `dot_x`, `t_clock_config`.`dot_y` AS `dot_y`, `t_clock_config`.`show_pointer_start_animation` AS `show_pointer_start_animation`, `t_clock_config`.`pointer_start_hour` AS `pointer_start_hour`, `t_clock_config`.`pointer_start_minute` AS `pointer_start_minute`, `t_clock_config`.`pointer_start_second` AS `pointer_start_second`, `t_clock_config`.`time_hour_src` AS `time_hour_src`, `t_clock_config`.`time_min_src` AS `time_min_src`, `t_clock_config`.`time_sec_src` AS `time_sec_src`, `t_clock_config`.`time_splt_src` AS `time_splt_src`, `t_clock_config`.`time_splt_2_src` AS `time_splt_2_src`, `t_clock_config`.`time_splt_need_jump` AS `time_splt_need_jump`, `t_clock_config`.`time_x` AS `time_x`, `t_clock_config`.`time_y` AS `time_y`, `t_clock_config`.`need_reset_min` AS `need_reset_min`, `t_clock_config`.`reset_min_x` AS `reset_min_x`, `t_clock_config`.`reset_min_y` AS `reset_min_y`, `t_clock_config`.`show_sec` AS `show_sec`, `t_clock_config`.`need_reset_sec` AS `need_reset_sec`, `t_clock_config`.`reset_sec_x` AS `reset_sec_x`, `t_clock_config`.`reset_sec_y` AS `reset_sec_y`, `t_clock_config`.`open_time_arc_show` AS `open_time_arc_show`, `t_clock_config`.`time_arc_type` AS `time_arc_type`, `t_clock_config`.`time_arc_center_x` AS `time_arc_center_x`, `t_clock_config`.`time_arc_center_y` AS `time_arc_center_y`, `t_clock_config`.`show_am_or_pm` AS `show_am_or_pm`, `t_clock_config`.`am_and_pm_src` AS `am_and_pm_src`, `t_clock_config`.`am_or_pm_x` AS `am_or_pm_x`, `t_clock_config`.`am_or_pm_y` AS `am_or_pm_y`, `t_clock_config`.`show_ampm_placeholer` AS `show_ampm_placeholer`, `t_clock_config`.`show_digital_start_animation` AS `show_digital_start_animation`, `t_clock_config`.`digital_start_hour` AS `digital_start_hour`, `t_clock_config`.`digital_start_minute` AS `digital_start_minute`, `t_clock_config`.`digital_start_second` AS `digital_start_second`, `t_clock_config`.`date_src` AS `date_src`, `t_clock_config`.`date_x` AS `date_x`, `t_clock_config`.`date_y` AS `date_y`, `t_clock_config`.`open_date_arc_show` AS `open_date_arc_show`, `t_clock_config`.`date_arc_type` AS `date_arc_type`, `t_clock_config`.`date_arc_center_x` AS `date_arc_center_x`, `t_clock_config`.`date_arc_center_y` AS `date_arc_center_y`, `t_clock_config`.`date_year_splt_src` AS `date_year_splt_src`, `t_clock_config`.`date_month_splt_src` AS `date_month_splt_src`, `t_clock_config`.`date_day_splt_src` AS `date_day_splt_src`, `t_clock_config`.`show_year` AS `show_year`, `t_clock_config`.`year_digits_type` AS `year_digits_type`, `t_clock_config`.`show_month` AS `show_month`, `t_clock_config`.`month_type` AS `month_type`, `t_clock_config`.`month_src` AS `month_src`, `t_clock_config`.`need_reset_month` AS `need_reset_month`, `t_clock_config`.`data_month_num` AS `data_month_num`, `t_clock_config`.`month_x` AS `month_x`, `t_clock_config`.`month_y` AS `month_y`, `t_clock_config`.`show_day` AS `show_day`, `t_clock_config`.`need_reset_day` AS `need_reset_day`, `t_clock_config`.`data_day_num` AS `data_day_num`, `t_clock_config`.`day_x` AS `day_x`, `t_clock_config`.`day_y` AS `day_y`, `t_clock_config`.`day_src` AS `day_src`, `t_clock_config`.`day_type` AS `day_type`, `t_clock_config`.`week_src` AS `week_src`, `t_clock_config`.`week_num_src` AS `week_num_src`, `t_clock_config`.`week_x` AS `week_x`, `t_clock_config`.`week_y` AS `week_y`, `t_clock_config`.`show_power` AS `show_power`, `t_clock_config`.`normal_0_src` AS `normal_0_src`, `t_clock_config`.`normal_1_src` AS `normal_1_src`, `t_clock_config`.`normal_2_src` AS `normal_2_src`, `t_clock_config`.`normal_3_src` AS `normal_3_src`, `t_clock_config`.`normal_4_src` AS `normal_4_src`, `t_clock_config`.`normal_5_src` AS `normal_5_src`, `t_clock_config`.`normal_6_src` AS `normal_6_src`, `t_clock_config`.`normal_7_src` AS `normal_7_src`, `t_clock_config`.`normal_8_src` AS `normal_8_src`, `t_clock_config`.`normal_9_src` AS `normal_9_src`, `t_clock_config`.`normal_10_src` AS `normal_10_src`, `t_clock_config`.`power_x` AS `power_x`, `t_clock_config`.`power_y` AS `power_y`, `t_clock_config`.`show_charge` AS `show_charge`, `t_clock_config`.`charge_0_src` AS `charge_0_src`, `t_clock_config`.`charge_1_src` AS `charge_1_src`, `t_clock_config`.`charge_2_src` AS `charge_2_src`, `t_clock_config`.`charge_3_src` AS `charge_3_src`, `t_clock_config`.`charge_4_src` AS `charge_4_src`, `t_clock_config`.`charge_5_src` AS `charge_5_src`, `t_clock_config`.`charge_6_src` AS `charge_6_src`, `t_clock_config`.`charge_7_src` AS `charge_7_src`, `t_clock_config`.`charge_8_src` AS `charge_8_src`, `t_clock_config`.`charge_9_src` AS `charge_9_src`, `t_clock_config`.`charge_10_src` AS `charge_10_src`, `t_clock_config`.`show_power_num` AS `show_power_num`, `t_clock_config`.`power_num_src` AS `power_num_src`, `t_clock_config`.`power_sign_src` AS `power_sign_src`, `t_clock_config`.`power_show_type` AS `power_show_type`, `t_clock_config`.`power_num_x` AS `power_num_x`, `t_clock_config`.`power_num_y` AS `power_num_y`, `t_clock_config`.`show_action` AS `show_action`, `t_clock_config`.`open_action_1` AS `open_action_1`, `t_clock_config`.`action_1_count` AS `action_1_count`, `t_clock_config`.`action_1_x` AS `action_1_x`, `t_clock_config`.`action_1_y` AS `action_1_y`, `t_clock_config`.`open_action_2` AS `open_action_2`, `t_clock_config`.`action_2_count` AS `action_2_count`, `t_clock_config`.`action_2_x` AS `action_2_x`, `t_clock_config`.`action_2_y` AS `action_2_y`, `t_clock_config`.`open_action_3` AS `open_action_3`, `t_clock_config`.`action_3_count` AS `action_3_count`, `t_clock_config`.`action_3_x` AS `action_3_x`, `t_clock_config`.`action_3_y` AS `action_3_y`, `t_clock_config`.`action_interval` AS `action_interval`, `t_clock_config`.`show_overall_animation` AS `show_overall_animation`, `t_clock_config`.`overall_animation_x` AS `overall_animation_x`, `t_clock_config`.`overall_animation_y` AS `overall_animation_y`, `t_clock_config`.`open_click_1` AS `open_click_1`, `t_clock_config`.`click_1_x` AS `click_1_x`, `t_clock_config`.`click_1_y` AS `click_1_y`, `t_clock_config`.`click_1_width` AS `click_1_width`, `t_clock_config`.`click_1_height` AS `click_1_height`, `t_clock_config`.`open_click_2` AS `open_click_2`, `t_clock_config`.`click_2_x` AS `click_2_x`, `t_clock_config`.`click_2_y` AS `click_2_y`, `t_clock_config`.`click_2_width` AS `click_2_width`, `t_clock_config`.`click_2_height` AS `click_2_height`, `t_clock_config`.`open_click_3` AS `open_click_3`, `t_clock_config`.`click_3_x` AS `click_3_x`, `t_clock_config`.`click_3_y` AS `click_3_y`, `t_clock_config`.`click_3_width` AS `click_3_width`, `t_clock_config`.`click_3_height` AS `click_3_height`, `t_clock_config`.`open_click_4` AS `open_click_4`, `t_clock_config`.`click_4_x` AS `click_4_x`, `t_clock_config`.`click_4_y` AS `click_4_y`, `t_clock_config`.`click_4_width` AS `click_4_width`, `t_clock_config`.`click_4_height` AS `click_4_height`, `t_clock_config`.`show_lunar` AS `show_lunar`, `t_clock_config`.`lunar_src` AS `lunar_src`, `t_clock_config`.`lunar_x` AS `lunar_x`, `t_clock_config`.`lunar_y` AS `lunar_y`, `t_clock_config`.`show_heart` AS `show_heart`, `t_clock_config`.`heart_src` AS `heart_src`, `t_clock_config`.`heart_x` AS `heart_x`, `t_clock_config`.`heart_y` AS `heart_y`, `t_clock_config`.`heart_num_src` AS `heart_num_src`, `t_clock_config`.`heart_num_type` AS `heart_num_type`, `t_clock_config`.`heart_end_src` AS `heart_end_src`, `t_clock_config`.`heart_show_type` AS `heart_show_type`, `t_clock_config`.`heart_num_x` AS `heart_num_x`, `t_clock_config`.`heart_num_y` AS `heart_num_y`, `t_clock_config`.`open_heart_arc_show` AS `open_heart_arc_show`, `t_clock_config`.`heart_arc_type` AS `heart_arc_type`, `t_clock_config`.`heart_arc_center_x` AS `heart_arc_center_x`, `t_clock_config`.`heart_arc_center_y` AS `heart_arc_center_y`, `t_clock_config`.`show_pressure` AS `show_pressure`, `t_clock_config`.`pressure_src` AS `pressure_src`, `t_clock_config`.`pressure_x` AS `pressure_x`, `t_clock_config`.`pressure_y` AS `pressure_y`, `t_clock_config`.`pressure_num_src` AS `pressure_num_src`, `t_clock_config`.`pressure_num_x` AS `pressure_num_x`, `t_clock_config`.`pressure_num_y` AS `pressure_num_y`, `t_clock_config`.`pressure_show_type` AS `pressure_show_type`, `t_clock_config`.`pressure_splt_src` AS `pressure_splt_src`, `t_clock_config`.`show_step` AS `show_step`, `t_clock_config`.`step_src` AS `step_src`, `t_clock_config`.`step_follow_num` AS `step_follow_num`, `t_clock_config`.`step_x` AS `step_x`, `t_clock_config`.`step_y` AS `step_y`, `t_clock_config`.`step_num_src` AS `step_num_src`, `t_clock_config`.`step_num_type` AS `step_num_type`, `t_clock_config`.`step_show_type` AS `step_show_type`, `t_clock_config`.`step_num_x` AS `step_num_x`, `t_clock_config`.`step_num_y` AS `step_num_y`, `t_clock_config`.`step_end_src` AS `step_end_src`, `t_clock_config`.`show_step_progress` AS `show_step_progress`, `t_clock_config`.`step_progress_x` AS `step_progress_x`, `t_clock_config`.`step_progress_y` AS `step_progress_y`, `t_clock_config`.`step_progress_src` AS `step_progress_src`, `t_clock_config`.`open_step_arc_show` AS `open_step_arc_show`, `t_clock_config`.`step_arc_type` AS `step_arc_type`, `t_clock_config`.`step_arc_center_x` AS `step_arc_center_x`, `t_clock_config`.`step_arc_center_y` AS `step_arc_center_y`, `t_clock_config`.`show_kcal` AS `show_kcal`, `t_clock_config`.`kcal_src` AS `kcal_src`, `t_clock_config`.`kcal_x` AS `kcal_x`, `t_clock_config`.`kcal_y` AS `kcal_y`, `t_clock_config`.`kcal_num_src` AS `kcal_num_src`, `t_clock_config`.`kcal_num_type` AS `kcal_num_type`, `t_clock_config`.`kcal_show_type` AS `kcal_show_type`, `t_clock_config`.`kcal_num_x` AS `kcal_num_x`, `t_clock_config`.`kcal_num_y` AS `kcal_num_y`, `t_clock_config`.`kcal_end_src` AS `kcal_end_src`, `t_clock_config`.`show_km` AS `show_km`, `t_clock_config`.`km_src` AS `km_src`, `t_clock_config`.`km_x` AS `km_x`, `t_clock_config`.`km_y` AS `km_y`, `t_clock_config`.`km_num_src` AS `km_num_src`, `t_clock_config`.`km_comma_src` AS `km_comma_src`, `t_clock_config`.`km_num_type` AS `km_num_type`, `t_clock_config`.`km_show_type` AS `km_show_type`, `t_clock_config`.`km_num_x` AS `km_num_x`, `t_clock_config`.`km_num_y` AS `km_num_y`, `t_clock_config`.`km_end_src` AS `km_end_src`, `t_clock_config`.`show_weather` AS `show_weather`, `t_clock_config`.`show_temperature` AS `show_temperature`, `t_clock_config`.`temperature_show_type` AS `temperature_show_type`, `t_clock_config`.`temperature_num_type` AS `temperature_num_type`, `t_clock_config`.`temperature_x` AS `temperature_x`, `t_clock_config`.`temperature_y` AS `temperature_y`, `t_clock_config`.`temperature_x_2` AS `temperature_x_2`, `t_clock_config`.`temperature_y_2` AS `temperature_y_2`, `t_clock_config`.`show_now_tem` AS `show_now_tem`, `t_clock_config`.`now_tem_show_type` AS `now_tem_show_type`, `t_clock_config`.`now_tem_x` AS `now_tem_x`, `t_clock_config`.`now_tem_y` AS `now_tem_y`, `t_clock_config`.`temperature_num_src` AS `temperature_num_src`, `t_clock_config`.`temperature_sub_src` AS `temperature_sub_src`, `t_clock_config`.`temperature_sign_src` AS `temperature_sign_src`, `t_clock_config`.`temperature_splt_src` AS `temperature_splt_src`, `t_clock_config`.`show_diagram` AS `show_diagram`, `t_clock_config`.`diagram_x` AS `diagram_x`, `t_clock_config`.`diagram_y` AS `diagram_y`, `t_clock_config`.`showsignal` AS `showsignal`, `t_clock_config`.`show_signal` AS `show_signal`, `t_clock_config`.`signal_src` AS `signal_src`, `t_clock_config`.`signal_x` AS `signal_x`, `t_clock_config`.`signal_y` AS `signal_y`, `t_clock_config`.`show_user_name` AS `show_user_name`, `t_clock_config`.`name_show_type` AS `name_show_type`, `t_clock_config`.`name_x` AS `name_x`, `t_clock_config`.`name_y` AS `name_y`, `t_clock_config`.`show_operator` AS `show_operator`, `t_clock_config`.`operator_show_type` AS `operator_show_type`, `t_clock_config`.`operator_x` AS `operator_x`, `t_clock_config`.`operator_y` AS `operator_y`, `t_clock_config`.`show_btn_call` AS `show_btn_call`, `t_clock_config`.`btn_call_src` AS `btn_call_src`, `t_clock_config`.`btn_call_x` AS `btn_call_x`, `t_clock_config`.`btn_call_y` AS `btn_call_y`, `t_clock_config`.`show_btn_sms` AS `show_btn_sms`, `t_clock_config`.`btn_sms_src` AS `btn_sms_src`, `t_clock_config`.`btn_sms_x` AS `btn_sms_x`, `t_clock_config`.`btn_sms_y` AS `btn_sms_y`, `t_clock_config`.`show_btn_heart` AS `show_btn_heart`, `t_clock_config`.`is_our_heart` AS `is_our_heart`, `t_clock_config`.`btn_heart_src` AS `btn_heart_src`, `t_clock_config`.`btn_heart_x` AS `btn_heart_x`, `t_clock_config`.`btn_heart_y` AS `btn_heart_y`, `t_clock_config`.`show_btn_step` AS `show_btn_step`, `t_clock_config`.`btn_step_src` AS `btn_step_src`, `t_clock_config`.`btn_step_x` AS `btn_step_x`, `t_clock_config`.`btn_step_y` AS `btn_step_y`, `t_clock_config`.`show_btn_wechat` AS `show_btn_wechat`, `t_clock_config`.`btn_wechat_src` AS `btn_wechat_src`, `t_clock_config`.`btn_wechat_x` AS `btn_wechat_x`, `t_clock_config`.`btn_wechat_y` AS `btn_wechat_y`, `t_clock_config`.`show_btn_alipay` AS `show_btn_alipay`, `t_clock_config`.`btn_alipay_src` AS `btn_alipay_src`, `t_clock_config`.`btn_alipay_x` AS `btn_alipay_x`, `t_clock_config`.`btn_alipay_y` AS `btn_alipay_y`, `t_clock_config`.`show_btn_stopwatch` AS `show_btn_stopwatch`, `t_clock_config`.`btn_stopwatch_src` AS `btn_stopwatch_src`, `t_clock_config`.`btn_stopwatch_x` AS `btn_stopwatch_x`, `t_clock_config`.`btn_stopwatch_y` AS `btn_stopwatch_y`, `t_clock_config`.`show_btn_weather` AS `show_btn_weather`, `t_clock_config`.`show_btn_calo` AS `show_btn_calo`, `t_clock_config`.`btn_calo_src` AS `btn_calo_src`, `t_clock_config`.`btn_calo_x` AS `btn_calo_x`, `t_clock_config`.`btn_calo_y` AS `btn_calo_y`, `t_clock_config`.`temprature_src` AS `temprature_src`, `t_clock_config`.`show_btn_camera` AS `show_btn_camera`, `t_clock_config`.`btn_camera_src` AS `btn_camera_src`, `t_clock_config`.`btn_camera_x` AS `btn_camera_x`, `t_clock_config`.`btn_camera_y` AS `btn_camera_y`, `t_clock_config`.`show_btn_sos` AS `show_btn_sos`, `t_clock_config`.`btn_sos_src` AS `btn_sos_src`, `t_clock_config`.`btn_sos_x` AS `btn_sos_x`, `t_clock_config`.`btn_sos_y` AS `btn_sos_y`, `t_clock_config`.`show_special_1` AS `show_special_1`, `t_clock_config`.`special_1_src` AS `special_1_src`, `t_clock_config`.`special_1_position` AS `special_1_position`, `t_clock_config`.`special_x` AS `special_x`, `t_clock_config`.`special_y` AS `special_y`, `t_clock_config`.`support_multiple_change` AS `support_multiple_change`, `t_clock_config`.`show_lunar_year` AS `show_lunar_year`, `t_clock_config`.`lunar_day_splt_src` AS `lunar_day_splt_src`, `t_clock_config`.`lunar_month_splt_src` AS `lunar_month_splt_src`, `t_clock_config`.`lunar_year_splt_src` AS `lunar_year_splt_src`, `t_clock_config`.`am_src` AS `am_src`, `t_clock_config`.`pm_src` AS `pm_src`, `t_clock_config`.`show_btn_alarm` AS `show_btn_alarm`, `t_clock_config`.`btn_alarm_src` AS `btn_alarm_src`, `t_clock_config`.`btn_alarm_x` AS `btn_alarm_x`, `t_clock_config`.`btn_alarm_y` AS `btn_alarm_y`, `t_clock_config`.`bg_btn_change` AS `bg_btn_change`, `t_clock_config`.`bg_btn_index` AS `bg_btn_index`, `t_clock_config`.`show_btn_music` AS `show_btn_music`, `t_clock_config`.`btn_music_src` AS `btn_music_src`, `t_clock_config`.`btn_music_x` AS `btn_music_x`, `t_clock_config`.`btn_music_y` AS `btn_music_y`, `t_clock_config`.`support_dynamic_change` AS `support_dynamic_change`, `t_clock_config`.`level` AS `level`, `t_clock_config`.`parent_id` AS `parent_id`, `t_clock_config`.`next_id` AS `next_id`, `t_clock_config`.`change_starttime` AS `change_starttime`, `t_clock_config`.`change_endtime` AS `change_endtime`, `t_clock_config`.`btn_weather_src` AS `btn_weather_src`, `t_clock_config`.`btn_weather_x` AS `btn_weather_x`, `t_clock_config`.`btn_weather_y` AS `btn_weather_y`, `t_clock_config`.`show_btn_calories` AS `show_btn_calories`, `t_clock_config`.`btn_calories_src` AS `btn_calories_src`, `t_clock_config`.`btn_calories_x` AS `btn_calories_x`, `t_clock_config`.`btn_calories_y` AS `btn_calories_y`, `t_clock_config`.`support_compass` AS `support_compass`, `t_clock_config`.`compass_src` AS `compass_src`, `t_clock_config`.`compass_2_src` AS `compass_2_src`, `t_clock_config`.`compass_x` AS `compass_x`, `t_clock_config`.`compass_y` AS `compass_y`, `t_clock_config`.`show_btn_setting` AS `show_btn_setting`, `t_clock_config`.`btn_setting_src` AS `btn_setting_src`, `t_clock_config`.`btn_setting_x` AS `btn_setting_x`, `t_clock_config`.`btn_setting_y` AS `btn_setting_y`, `t_clock_config`.`support_click_change` AS `support_click_change`, `t_clock_config`.`click_id_is_current` AS `click_id_is_current`, `t_clock_config`.`compass_show_detail_degree` AS `compass_show_detail_degree`, `t_clock_config`.`compass_direction_src` AS `compass_direction_src`, `t_clock_config`.`compass_direction_x` AS `compass_direction_x`, `t_clock_config`.`compass_direction_y` AS `compass_direction_y`, `t_clock_config`.`compass_direction_2_src` AS `compass_direction_2_src`, `t_clock_config`.`compass_direction_2_x` AS `compass_direction_2_x`, `t_clock_config`.`compass_direction_2_y` AS `compass_direction_2_y`, `t_clock_config`.`compass_direction_3_src` AS `compass_direction_3_src`, `t_clock_config`.`compass_direction_3_x` AS `compass_direction_3_x`, `t_clock_config`.`compass_direction_3_y` AS `compass_direction_3_y`, `t_clock_config`.`compass_direction_degree_src` AS `compass_direction_degree_src`, `t_clock_config`.`compass_direction_degree_x` AS `compass_direction_degree_x`, `t_clock_config`.`compass_direction_degree_y` AS `compass_direction_degree_y`, `t_clock_config`.`compass_direction_degree_unit` AS `compass_direction_degree_unit`, `t_clock_config`.`compass_degree_1_src` AS `compass_degree_1_src`, `t_clock_config`.`compass_degree_1_x` AS `compass_degree_1_x`, `t_clock_config`.`compass_degree_1_y` AS `compass_degree_1_y`, `t_clock_config`.`compass_degree_2_src` AS `compass_degree_2_src`, `t_clock_config`.`compass_degree_2_x` AS `compass_degree_2_x`, `t_clock_config`.`compass_degree_2_y` AS `compass_degree_2_y`, `t_clock_config`.`compass_degree_3_src` AS `compass_degree_3_src`, `t_clock_config`.`compass_degree_3_x` AS `compass_degree_3_x`, `t_clock_config`.`compass_degree_3_y` AS `compass_degree_3_y`, `t_clock_config`.`show_connect_animation` AS `show_connect_animation`, `t_clock_config`.`connect_animation_x` AS `connect_animation_x`, `t_clock_config`.`connect_animation_y` AS `connect_animation_y`, `t_clock_config`.`connect_animation_count` AS `connect_animation_count`, `t_clock_config`.`show_state` AS `show_state`, `t_clock_config`.`state_x` AS `state_x`, `t_clock_config`.`state_y` AS `state_y`, `t_clock_config`.`action_1_cut_position` AS `action_1_cut_position`, `t_clock_config`.`action_2_cut_position` AS `action_2_cut_position`, `t_clock_config`.`action_3_cut_position` AS `action_3_cut_position`, `t_clock_config`.`show_btn_googleplay` AS `show_btn_googleplay`, `t_clock_config`.`btn_googleplay_src` AS `btn_googleplay_src`, `t_clock_config`.`btn_googleplay_x` AS `btn_googleplay_x`, `t_clock_config`.`btn_googleplay_y` AS `btn_googleplay_y`, `t_clock_config`.`show_month_2` AS `show_month_2`, `t_clock_config`.`month_type_2` AS `month_type_2`, `t_clock_config`.`month_src_2` AS `month_src_2`, `t_clock_config`.`month_x_2` AS `month_x_2`, `t_clock_config`.`month_y_2` AS `month_y_2`, `t_clock_config`.`time_special_new` AS `time_special_new`, `t_clock_config`.`time_special_hour_ten_src` AS `time_special_hour_ten_src`, `t_clock_config`.`time_special_hour_src` AS `time_special_hour_src`, `t_clock_config`.`time_special_min_ten_src` AS `time_special_min_ten_src`, `t_clock_config`.`time_special_min_src` AS `time_special_min_src`, `t_clock_config`.`show_kcal_progress` AS `show_kcal_progress`, `t_clock_config`.`kcal_progress_x` AS `kcal_progress_x`, `t_clock_config`.`kcal_progress_y` AS `kcal_progress_y`, `t_clock_config`.`kcal_progress_src` AS `kcal_progress_src`, `t_clock_config`.`open_kcal_arc_show` AS `open_kcal_arc_show`, `t_clock_config`.`kcal_arc_type` AS `kcal_arc_type`, `t_clock_config`.`kcal_arc_center_x` AS `kcal_arc_center_x`, `t_clock_config`.`kcal_arc_center_y` AS `kcal_arc_center_y`, `t_clock_config`.`open_power_arc_show` AS `open_power_arc_show`, `t_clock_config`.`power_arc_type` AS `power_arc_type`, `t_clock_config`.`power_arc_center_x` AS `power_arc_center_x`, `t_clock_config`.`power_arc_center_y` AS `power_arc_center_y`, `t_clock_config`.`show_btn_timer` AS `show_btn_timer`, `t_clock_config`.`btn_timer_src` AS `btn_timer_src`, `t_clock_config`.`btn_timer_x` AS `btn_timer_x`, `t_clock_config`.`btn_timer_y` AS `btn_timer_y`, `t_clock_config`.`show_btn_sleep` AS `show_btn_sleep`, `t_clock_config`.`btn_sleep_src` AS `btn_sleep_src`, `t_clock_config`.`btn_sleep_x` AS `btn_sleep_x`, `t_clock_config`.`btn_sleep_y` AS `btn_sleep_y`, `t_clock_config`.`show_btn_bloodpressure` AS `show_btn_bloodpressure`, `t_clock_config`.`btn_bloodpressure_src` AS `btn_bloodpressure_src`, `t_clock_config`.`btn_bloodpressure_x` AS `btn_bloodpressure_x`, `t_clock_config`.`btn_bloodpressure_y` AS `btn_bloodpressure_y`, `t_clock_config`.`show_btn_sport_record` AS `show_btn_sport_record`, `t_clock_config`.`btn_sport_record_src` AS `btn_sport_record_src`, `t_clock_config`.`btn_sport_record_x` AS `btn_sport_record_x`, `t_clock_config`.`btn_sport_record_y` AS `btn_sport_record_y`, `t_clock_config`.`lottie_hierarchy` AS `lottie_hierarchy`, `t_clock_config`.`show_heart_progress` AS `show_heart_progress`, `t_clock_config`.`heart_progress_x` AS `heart_progress_x`, `t_clock_config`.`heart_progress_y` AS `heart_progress_y`, `t_clock_config`.`heart_progress_src` AS `heart_progress_src`, `t_clock_config`.`show_btn_calculator` AS `show_btn_calculator`, `t_clock_config`.`btn_calculator_src` AS `btn_calculator_src`, `t_clock_config`.`btn_calculator_x` AS `btn_calculator_x`, `t_clock_config`.`btn_calculator_y` AS `btn_calculator_y`, `t_clock_config`.`time_special_drag_3d` AS `time_special_drag_3d`, `t_clock_config`.`prev_HourTen_Position` AS `prev_HourTen_Position`, `t_clock_config`.`prev_HourGe_Position` AS `prev_HourGe_Position`, `t_clock_config`.`current_HourTen_Position` AS `current_HourTen_Position`, `t_clock_config`.`current_HourGe_Position` AS `current_HourGe_Position`, `t_clock_config`.`next_HourTen_Position` AS `next_HourTen_Position`, `t_clock_config`.`next_HourGe_Position` AS `next_HourGe_Position`, `t_clock_config`.`prev_MinTen_Position` AS `prev_MinTen_Position`, `t_clock_config`.`prev_MinGe_Position` AS `prev_MinGe_Position`, `t_clock_config`.`current_MinTen_Position` AS `current_MinTen_Position`, `t_clock_config`.`current_MinGe_Position` AS `current_MinGe_Position`, `t_clock_config`.`next_MinTen_Position` AS `next_MinTen_Position`, `t_clock_config`.`next_MinGe_Position` AS `next_MinGe_Position`, `t_clock_config`.`need_split_day` AS `need_split_day`, `t_clock_config`.`split_day_x` AS `split_day_x`, `t_clock_config`.`split_day_y` AS `split_day_y`, `t_clock_config`.`open_now_tem_arc_show` AS `open_now_tem_arc_show`, `t_clock_config`.`now_tem_arc_type` AS `now_tem_arc_type`, `t_clock_config`.`now_tem_arc_center_x` AS `now_tem_arc_center_x`, `t_clock_config`.`now_tem_arc_center_y` AS `now_tem_arc_center_y`, `t_clock_config`.`show_km_progress` AS `show_km_progress`, `t_clock_config`.`km_progress_x` AS `km_progress_x`, `t_clock_config`.`km_progress_y` AS `km_progress_y`, `t_clock_config`.`km_progress_src` AS `km_progress_src`, `t_clock_config`.`open_km_arc_show` AS `open_km_arc_show`, `t_clock_config`.`km_arc_type` AS `km_arc_type`, `t_clock_config`.`km_arc_center_x` AS `km_arc_center_x`, `t_clock_config`.`km_arc_center_y` AS `km_arc_center_y`, `t_clock_config`.`time_rotate` AS `time_rotate`, `t_clock_config`.`time_rotate_degree` AS `time_rotate_degree`, `t_clock_config`.`heart_num_rotate` AS `heart_num_rotate`, `t_clock_config`.`heart_num_rotate_degree` AS `heart_num_rotate_degree`, `t_clock_config`.`show_oxygen` AS `show_oxygen`, `t_clock_config`.`oxygen_src` AS `oxygen_src`, `t_clock_config`.`oxygen_x` AS `oxygen_x`, `t_clock_config`.`oxygen_y` AS `oxygen_y`, `t_clock_config`.`oxygen_num_src` AS `oxygen_num_src`, `t_clock_config`.`oxygen_sign_src` AS `oxygen_sign_src`, `t_clock_config`.`oxygen_show_type` AS `oxygen_show_type`, `t_clock_config`.`oxygen_num_x` AS `oxygen_num_x`, `t_clock_config`.`oxygen_num_y` AS `oxygen_num_y`, `t_clock_config`.`time_change_counter` AS `time_change_counter`, `t_clock_config`.`time_hour_src_2` AS `time_hour_src_2`, `t_clock_config`.`time_min_src_2` AS `time_min_src_2`, `t_clock_config`.`time_sec_src_2` AS `time_sec_src_2`, `t_clock_config`.`time_splt_src_2` AS `time_splt_src_2`, `t_clock_config`.`time_splt_2_src_2` AS `time_splt_2_src_2`, `t_clock_config`.`time_hour_src_3` AS `time_hour_src_3`, `t_clock_config`.`time_min_src_3` AS `time_min_src_3`, `t_clock_config`.`time_sec_src_3` AS `time_sec_src_3`, `t_clock_config`.`time_splt_src_3` AS `time_splt_src_3`, `t_clock_config`.`time_splt_2_src_3` AS `time_splt_2_src_3`, `t_clock_config`.`time_hour_src_4` AS `time_hour_src_4`, `t_clock_config`.`time_min_src_4` AS `time_min_src_4`, `t_clock_config`.`time_sec_src_4` AS `time_sec_src_4`, `t_clock_config`.`time_splt_src_4` AS `time_splt_src_4`, `t_clock_config`.`time_splt_2_src_4` AS `time_splt_2_src_4`, `t_clock_config`.`date_rotate` AS `date_rotate`, `t_clock_config`.`date_rotate_degree` AS `date_rotate_degree`, `t_clock_config`.`need_split_hour` AS `need_split_hour`, `t_clock_config`.`split_hour_src` AS `split_hour_src`, `t_clock_config`.`split_hour_x` AS `split_hour_x`, `t_clock_config`.`split_hour_y` AS `split_hour_y`, `t_clock_config`.`need_split_min` AS `need_split_min`, `t_clock_config`.`split_min_src` AS `split_min_src`, `t_clock_config`.`split_min_x` AS `split_min_x`, `t_clock_config`.`split_min_y` AS `split_min_y`, `t_clock_config`.`support_scale` AS `support_scale`, `t_clock_config`.`show_compass_num` AS `show_compass_num`, `t_clock_config`.`compass_num_src` AS `compass_num_src`, `t_clock_config`.`compass_show_type` AS `compass_show_type`, `t_clock_config`.`compass_num_x` AS `compass_num_x`, `t_clock_config`.`compass_num_y` AS `compass_num_y`, `t_clock_config`.`compass_num_src_prefix` AS `compass_num_src_prefix`, `t_clock_config`.`compass_num_src_sign` AS `compass_num_src_sign`, `t_clock_config`.`show_btn_oxygen` AS `show_btn_oxygen`, `t_clock_config`.`btn_oxygen_src` AS `btn_oxygen_src`, `t_clock_config`.`btn_oxygen_x` AS `btn_oxygen_x`, `t_clock_config`.`btn_oxygen_y` AS `btn_oxygen_y`, `t_clock_config`.`show_btn_calendar` AS `show_btn_calendar`, `t_clock_config`.`btn_calendar_src` AS `btn_calendar_src`, `t_clock_config`.`btn_calendar_x` AS `btn_calendar_x`, `t_clock_config`.`btn_calendar_y` AS `btn_calendar_y`, `t_clock_config`.`show_btn_compass` AS `show_btn_compass`, `t_clock_config`.`btn_compass_src` AS `btn_compass_src`, `t_clock_config`.`btn_compass_x` AS `btn_compass_x`, `t_clock_config`.`btn_compass_y` AS `btn_compass_y`, `t_clock_config`.`pointer_disable_scale` AS `pointer_disable_scale`, `t_clock_config`.`show_chinse_time` AS `show_chinse_time`, `t_clock_config`.`chinse_time_src` AS `chinse_time_src`, `t_clock_config`.`chinse_time_x` AS `chinse_time_x`, `t_clock_config`.`chinse_time_y` AS `chinse_time_y`, `t_clock_config`.`show_btn_photo` AS `show_btn_photo`, `t_clock_config`.`btn_photo_src` AS `btn_photo_src`, `t_clock_config`.`btn_photo_x` AS `btn_photo_x`, `t_clock_config`.`btn_photo_y` AS `btn_photo_y`, `t_clock_config`.`show_btn_contact` AS `show_btn_contact`, `t_clock_config`.`btn_contact_src` AS `btn_contact_src`, `t_clock_config`.`btn_contact_x` AS `btn_contact_x`, `t_clock_config`.`btn_contact_y` AS `btn_contact_y`, `t_clock_config`.`kcal_num_rotate` AS `kcal_num_rotate`, `t_clock_config`.`kcal_num_rotate_degree` AS `kcal_num_rotate_degree`, `t_clock_config`.`show_power_progress` AS `show_power_progress`, `t_clock_config`.`power_progress_src` AS `power_progress_src`, `t_clock_config`.`power_progress_x` AS `power_progress_x`, `t_clock_config`.`power_progress_y` AS `power_progress_y`, `t_clock_config`.`power_src` AS `power_src`, `t_clock_config`.`power_src_x` AS `power_src_x`, `t_clock_config`.`power_src_y` AS `power_src_y`, `t_clock_config`.`video_type` AS `video_type`, `t_clock_config`.`step_keep_number_length` AS `step_keep_number_length`, `t_clock_config`.`kcal_keep_number_length` AS `kcal_keep_number_length`, `t_clock_config`.`km_keep_number_length` AS `km_keep_number_length`, `t_clock_config`.`step_num_rotate` AS `step_num_rotate`, `t_clock_config`.`step_num_rotate_degree` AS `step_num_rotate_degree`, `t_clock_config`.`show_btn_style` AS `show_btn_style`, `t_clock_config`.`btn_style_src` AS `btn_style_src`, `t_clock_config`.`btn_style_x` AS `btn_style_x`, `t_clock_config`.`btn_style_y` AS `btn_style_y`, `t_clock_config`.`need_split_sec` AS `need_split_sec`, `t_clock_config`.`split_sec_src` AS `split_sec_src`, `t_clock_config`.`split_sec_x` AS `split_sec_x`, `t_clock_config`.`split_sec_y` AS `split_sec_y`, `t_clock_config`.`open_oxygen_arc_show` AS `open_oxygen_arc_show`, `t_clock_config`.`oxygen_arc_type` AS `oxygen_arc_type`, `t_clock_config`.`oxygen_arc_center_x` AS `oxygen_arc_center_x`, `t_clock_config`.`oxygen_arc_center_y` AS `oxygen_arc_center_y`, `t_clock_config`.`show_oxygen_progress` AS `show_oxygen_progress`, `t_clock_config`.`oxygen_progress_src` AS `oxygen_progress_src`, `t_clock_config`.`oxygen_progress_x` AS `oxygen_progress_x`, `t_clock_config`.`oxygen_progress_y` AS `oxygen_progress_y`, `t_clock_config`.`show_week_donts` AS `show_week_donts`, `t_clock_config`.`week_donts_src` AS `week_donts_src`, `t_clock_config`.`week_donts_x` AS `week_donts_x`, `t_clock_config`.`week_donts_y` AS `week_donts_y`, `t_clock_config`.`show_btn_flashlight` AS `show_btn_flashlight`, `t_clock_config`.`flashlight_src` AS `flashlight_src`, `t_clock_config`.`flashlight_x` AS `flashlight_x`, `t_clock_config`.`flashlight_y` AS `flashlight_y` from t_clock_config where fromAssets = 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                ClockConfig clockConfig = new ClockConfig();
                clockConfig.setPath(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                boolean z = true;
                if (cursorQuery.getInt(1) == 0) {
                    z = false;
                }
                clockConfig.setFromAssets(z);
                clockConfig.setId(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                clockConfig.setName(cursorQuery.isNull(3) ? null : cursorQuery.getString(3));
                clockConfig.setName_en(cursorQuery.isNull(4) ? null : cursorQuery.getString(4));
                clockConfig.setScreentype(cursorQuery.isNull(5) ? null : cursorQuery.getString(5));
                clockConfig.setDialtype(cursorQuery.getInt(6));
                clockConfig.setCoordinate_screen_width(cursorQuery.getInt(7));
                clockConfig.setCoordinate_screen_height(cursorQuery.getInt(8));
                clockConfig.setBg_type(cursorQuery.getInt(9));
                clockConfig.setVideo(cursorQuery.isNull(10) ? null : cursorQuery.getString(10));
                clockConfig.setLottie(cursorQuery.isNull(11) ? null : cursorQuery.getString(11));
                clockConfig.setBg_animal_keep_for_last_frame(cursorQuery.getInt(12));
                clockConfig.setBg_count(cursorQuery.getInt(13));
                clockConfig.setBg_interval(cursorQuery.isNull(14) ? null : cursorQuery.getString(14));
                clockConfig.setBg_is_customize(cursorQuery.isNull(15) ? null : cursorQuery.getString(15));
                clockConfig.setHour_pointer_src(cursorQuery.isNull(16) ? null : cursorQuery.getString(16));
                clockConfig.setHour_pointer_x(cursorQuery.getInt(17));
                clockConfig.setHour_pointer_y(cursorQuery.getInt(18));
                clockConfig.setMinute_pointer_src(cursorQuery.isNull(19) ? null : cursorQuery.getString(19));
                clockConfig.setMinute_pointer_x(cursorQuery.getInt(20));
                clockConfig.setMinute_pointer_y(cursorQuery.getInt(21));
                clockConfig.setSecond_pointer_src(cursorQuery.isNull(22) ? null : cursorQuery.getString(22));
                clockConfig.setSecond_pointer_type(cursorQuery.getInt(23));
                clockConfig.setSecond_pointer_x(cursorQuery.getInt(24));
                clockConfig.setSecond_pointer_y(cursorQuery.getInt(25));
                clockConfig.setSecond_pointer_animal_type(cursorQuery.getInt(26));
                clockConfig.setDot_src(cursorQuery.isNull(27) ? null : cursorQuery.getString(27));
                clockConfig.setDot_x(cursorQuery.getInt(28));
                clockConfig.setDot_y(cursorQuery.getInt(29));
                clockConfig.setShow_pointer_start_animation(cursorQuery.getInt(30));
                clockConfig.setPointer_start_hour(cursorQuery.getInt(31));
                clockConfig.setPointer_start_minute(cursorQuery.getInt(32));
                clockConfig.setPointer_start_second(cursorQuery.getInt(33));
                clockConfig.setTime_hour_src(cursorQuery.isNull(34) ? null : cursorQuery.getString(34));
                clockConfig.setTime_min_src(cursorQuery.isNull(35) ? null : cursorQuery.getString(35));
                clockConfig.setTime_sec_src(cursorQuery.isNull(36) ? null : cursorQuery.getString(36));
                clockConfig.setTime_splt_src(cursorQuery.isNull(37) ? null : cursorQuery.getString(37));
                clockConfig.setTime_splt_2_src(cursorQuery.isNull(38) ? null : cursorQuery.getString(38));
                clockConfig.setTime_splt_need_jump(cursorQuery.getInt(39));
                clockConfig.setTime_x(cursorQuery.getInt(40));
                clockConfig.setTime_y(cursorQuery.getInt(41));
                clockConfig.setNeed_reset_min(cursorQuery.getInt(42));
                clockConfig.setReset_min_x(cursorQuery.getInt(43));
                clockConfig.setReset_min_y(cursorQuery.getInt(44));
                clockConfig.setShow_sec(cursorQuery.getInt(45));
                clockConfig.setNeed_reset_sec(cursorQuery.getInt(46));
                clockConfig.setReset_sec_x(cursorQuery.getInt(47));
                clockConfig.setReset_sec_y(cursorQuery.getInt(48));
                clockConfig.setOpen_time_arc_show(cursorQuery.getInt(49));
                clockConfig.setTime_arc_type(cursorQuery.getInt(50));
                clockConfig.setTime_arc_center_x(cursorQuery.getInt(51));
                clockConfig.setTime_arc_center_y(cursorQuery.getInt(52));
                clockConfig.setShow_am_or_pm(cursorQuery.getInt(53));
                clockConfig.setAm_and_pm_src(cursorQuery.isNull(54) ? null : cursorQuery.getString(54));
                clockConfig.setAm_or_pm_x(cursorQuery.getInt(55));
                clockConfig.setAm_or_pm_y(cursorQuery.getInt(56));
                clockConfig.setShow_ampm_placeholer(cursorQuery.getInt(57));
                clockConfig.setShow_digital_start_animation(cursorQuery.getInt(58));
                clockConfig.setDigital_start_hour(cursorQuery.getInt(59));
                clockConfig.setDigital_start_minute(cursorQuery.getInt(60));
                clockConfig.setDigital_start_second(cursorQuery.getInt(61));
                clockConfig.setDate_src(cursorQuery.isNull(62) ? null : cursorQuery.getString(62));
                clockConfig.setDate_x(cursorQuery.getInt(63));
                clockConfig.setDate_y(cursorQuery.getInt(64));
                clockConfig.setOpen_date_arc_show(cursorQuery.getInt(65));
                clockConfig.setDate_arc_type(cursorQuery.getInt(66));
                clockConfig.setDate_arc_center_x(cursorQuery.getInt(67));
                clockConfig.setDate_arc_center_y(cursorQuery.getInt(68));
                clockConfig.setDate_year_splt_src(cursorQuery.isNull(69) ? null : cursorQuery.getString(69));
                clockConfig.setDate_month_splt_src(cursorQuery.isNull(70) ? null : cursorQuery.getString(70));
                clockConfig.setDate_day_splt_src(cursorQuery.isNull(71) ? null : cursorQuery.getString(71));
                clockConfig.setShow_year(cursorQuery.getInt(72));
                clockConfig.setYear_digits_type(cursorQuery.getInt(73));
                clockConfig.setShow_month(cursorQuery.getInt(74));
                clockConfig.setMonth_type(cursorQuery.getInt(75));
                clockConfig.setMonth_src(cursorQuery.isNull(76) ? null : cursorQuery.getString(76));
                clockConfig.setNeed_reset_month(cursorQuery.getInt(77));
                clockConfig.setData_month_num(cursorQuery.isNull(78) ? null : cursorQuery.getString(78));
                clockConfig.setMonth_x(cursorQuery.getInt(79));
                clockConfig.setMonth_y(cursorQuery.getInt(80));
                clockConfig.setShow_day(cursorQuery.getInt(81));
                clockConfig.setNeed_reset_day(cursorQuery.getInt(82));
                clockConfig.setData_day_num(cursorQuery.isNull(83) ? null : cursorQuery.getString(83));
                clockConfig.setDay_x(cursorQuery.getInt(84));
                clockConfig.setDay_y(cursorQuery.getInt(85));
                clockConfig.setDay_src(cursorQuery.isNull(86) ? null : cursorQuery.getString(86));
                clockConfig.setDay_type(cursorQuery.getInt(87));
                clockConfig.setWeek_src(cursorQuery.isNull(88) ? null : cursorQuery.getString(88));
                clockConfig.setWeek_num_src(cursorQuery.isNull(89) ? null : cursorQuery.getString(89));
                clockConfig.setWeek_x(cursorQuery.getInt(90));
                clockConfig.setWeek_y(cursorQuery.getInt(91));
                clockConfig.setShow_power(cursorQuery.getInt(92));
                clockConfig.setNormal_0_src(cursorQuery.isNull(93) ? null : cursorQuery.getString(93));
                clockConfig.setNormal_1_src(cursorQuery.isNull(94) ? null : cursorQuery.getString(94));
                clockConfig.setNormal_2_src(cursorQuery.isNull(95) ? null : cursorQuery.getString(95));
                clockConfig.setNormal_3_src(cursorQuery.isNull(96) ? null : cursorQuery.getString(96));
                clockConfig.setNormal_4_src(cursorQuery.isNull(97) ? null : cursorQuery.getString(97));
                clockConfig.setNormal_5_src(cursorQuery.isNull(98) ? null : cursorQuery.getString(98));
                clockConfig.setNormal_6_src(cursorQuery.isNull(99) ? null : cursorQuery.getString(99));
                clockConfig.setNormal_7_src(cursorQuery.isNull(100) ? null : cursorQuery.getString(100));
                clockConfig.setNormal_8_src(cursorQuery.isNull(101) ? null : cursorQuery.getString(101));
                clockConfig.setNormal_9_src(cursorQuery.isNull(102) ? null : cursorQuery.getString(102));
                clockConfig.setNormal_10_src(cursorQuery.isNull(103) ? null : cursorQuery.getString(103));
                clockConfig.setPower_x(cursorQuery.getInt(LocationRequestCompat.QUALITY_LOW_POWER));
                clockConfig.setPower_y(cursorQuery.getInt(105));
                clockConfig.setShow_charge(cursorQuery.getInt(106));
                clockConfig.setCharge_0_src(cursorQuery.isNull(107) ? null : cursorQuery.getString(107));
                clockConfig.setCharge_1_src(cursorQuery.isNull(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR) ? null : cursorQuery.getString(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR));
                clockConfig.setCharge_2_src(cursorQuery.isNull(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) ? null : cursorQuery.getString(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY));
                clockConfig.setCharge_3_src(cursorQuery.isNull(110) ? null : cursorQuery.getString(110));
                clockConfig.setCharge_4_src(cursorQuery.isNull(111) ? null : cursorQuery.getString(111));
                clockConfig.setCharge_5_src(cursorQuery.isNull(112) ? null : cursorQuery.getString(112));
                clockConfig.setCharge_6_src(cursorQuery.isNull(113) ? null : cursorQuery.getString(113));
                clockConfig.setCharge_7_src(cursorQuery.isNull(114) ? null : cursorQuery.getString(114));
                clockConfig.setCharge_8_src(cursorQuery.isNull(115) ? null : cursorQuery.getString(115));
                clockConfig.setCharge_9_src(cursorQuery.isNull(116) ? null : cursorQuery.getString(116));
                clockConfig.setCharge_10_src(cursorQuery.isNull(117) ? null : cursorQuery.getString(117));
                clockConfig.setShow_power_num(cursorQuery.getInt(118));
                clockConfig.setPower_num_src(cursorQuery.isNull(119) ? null : cursorQuery.getString(119));
                clockConfig.setPower_sign_src(cursorQuery.isNull(120) ? null : cursorQuery.getString(120));
                clockConfig.setPower_show_type(cursorQuery.getInt(121));
                clockConfig.setPower_num_x(cursorQuery.getInt(122));
                clockConfig.setPower_num_y(cursorQuery.getInt(123));
                clockConfig.setShow_action(cursorQuery.getInt(124));
                clockConfig.setOpen_action_1(cursorQuery.getInt(125));
                clockConfig.setAction_1_count(cursorQuery.getInt(126));
                clockConfig.setAction_1_x(cursorQuery.getInt(127));
                clockConfig.setAction_1_y(cursorQuery.getInt(128));
                clockConfig.setOpen_action_2(cursorQuery.getInt(UiccCardApplication.AUTH_CONTEXT_EAP_AKA));
                clockConfig.setAction_2_count(cursorQuery.getInt(130));
                clockConfig.setAction_2_x(cursorQuery.getInt(RadioCdmaSmsConst.UDH_EO_DATA_SEGMENT_MAX));
                clockConfig.setAction_2_y(cursorQuery.getInt(132));
                clockConfig.setOpen_action_3(cursorQuery.getInt(133));
                clockConfig.setAction_3_count(cursorQuery.getInt(134));
                clockConfig.setAction_3_x(cursorQuery.getInt(135));
                clockConfig.setAction_3_y(cursorQuery.getInt(136));
                clockConfig.setAction_interval(cursorQuery.getInt(137));
                clockConfig.setShow_overall_animation(cursorQuery.isNull(138) ? null : cursorQuery.getString(138));
                clockConfig.setOverall_animation_x(cursorQuery.getInt(139));
                clockConfig.setOverall_animation_y(cursorQuery.getInt(SmsMessage.MAX_USER_DATA_BYTES));
                clockConfig.setOpen_click_1(cursorQuery.isNull(141) ? null : cursorQuery.getString(141));
                clockConfig.setClick_1_x(cursorQuery.getInt(142));
                clockConfig.setClick_1_y(cursorQuery.getInt(143));
                clockConfig.setClick_1_width(cursorQuery.isNull(144) ? null : cursorQuery.getString(144));
                clockConfig.setClick_1_height(cursorQuery.isNull(145) ? null : cursorQuery.getString(145));
                clockConfig.setOpen_click_2(cursorQuery.isNull(146) ? null : cursorQuery.getString(146));
                clockConfig.setClick_2_x(cursorQuery.getInt(147));
                clockConfig.setClick_2_y(cursorQuery.getInt(148));
                clockConfig.setClick_2_width(cursorQuery.isNull(149) ? null : cursorQuery.getString(149));
                clockConfig.setClick_2_height(cursorQuery.isNull(ImsPhoneCallTrackerEx.CODE_LOCAL_CALL_CS_EMERGENCY_RETRY_REQUIRED) ? null : cursorQuery.getString(ImsPhoneCallTrackerEx.CODE_LOCAL_CALL_CS_EMERGENCY_RETRY_REQUIRED));
                clockConfig.setOpen_click_3(cursorQuery.isNull(ImsPhoneCallTrackerEx.CODE_LOCAL_CALL_IMS_HANDOVER_RETRY) ? null : cursorQuery.getString(ImsPhoneCallTrackerEx.CODE_LOCAL_CALL_IMS_HANDOVER_RETRY));
                clockConfig.setClick_3_x(cursorQuery.getInt(152));
                clockConfig.setClick_3_y(cursorQuery.getInt(SmsMessage.MAX_USER_DATA_SEPTETS_WITH_HEADER));
                clockConfig.setClick_3_width(cursorQuery.isNull(154) ? null : cursorQuery.getString(154));
                clockConfig.setClick_3_height(cursorQuery.isNull(155) ? null : cursorQuery.getString(155));
                clockConfig.setOpen_click_4(cursorQuery.isNull(156) ? null : cursorQuery.getString(156));
                clockConfig.setClick_4_x(cursorQuery.getInt(157));
                clockConfig.setClick_4_y(cursorQuery.getInt(158));
                clockConfig.setClick_4_width(cursorQuery.isNull(159) ? null : cursorQuery.getString(159));
                clockConfig.setClick_4_height(cursorQuery.isNull(SmsMessage.MAX_USER_DATA_SEPTETS) ? null : cursorQuery.getString(SmsMessage.MAX_USER_DATA_SEPTETS));
                clockConfig.setShow_lunar(cursorQuery.getInt(161));
                clockConfig.setLunar_src(cursorQuery.isNull(162) ? null : cursorQuery.getString(162));
                clockConfig.setLunar_x(cursorQuery.getInt(163));
                clockConfig.setLunar_y(cursorQuery.getInt(164));
                clockConfig.setShow_heart(cursorQuery.getInt(165));
                clockConfig.setHeart_src(cursorQuery.isNull(166) ? null : cursorQuery.getString(166));
                clockConfig.setHeart_x(cursorQuery.getInt(167));
                clockConfig.setHeart_y(cursorQuery.getInt(UsimPhoneBookManagerEx.USIM_TYPE1_TAG));
                clockConfig.setHeart_num_src(cursorQuery.isNull(UsimPhoneBookManagerEx.USIM_TYPE2_TAG) ? null : cursorQuery.getString(UsimPhoneBookManagerEx.USIM_TYPE2_TAG));
                clockConfig.setHeart_num_type(cursorQuery.isNull(170) ? null : cursorQuery.getString(170));
                clockConfig.setHeart_end_src(cursorQuery.isNull(171) ? null : cursorQuery.getString(171));
                clockConfig.setHeart_show_type(cursorQuery.getInt(172));
                clockConfig.setHeart_num_x(cursorQuery.getInt(173));
                clockConfig.setHeart_num_y(cursorQuery.getInt(174));
                clockConfig.setOpen_heart_arc_show(cursorQuery.getInt(175));
                clockConfig.setHeart_arc_type(cursorQuery.getInt(176));
                clockConfig.setHeart_arc_center_x(cursorQuery.getInt(177));
                clockConfig.setHeart_arc_center_y(cursorQuery.getInt(178));
                clockConfig.setShow_pressure(cursorQuery.isNull(179) ? null : cursorQuery.getString(179));
                clockConfig.setPressure_src(cursorQuery.isNull(180) ? null : cursorQuery.getString(180));
                clockConfig.setPressure_x(cursorQuery.getInt(181));
                clockConfig.setPressure_y(cursorQuery.getInt(182));
                clockConfig.setPressure_num_src(cursorQuery.isNull(183) ? null : cursorQuery.getString(183));
                clockConfig.setPressure_num_x(cursorQuery.getInt(184));
                clockConfig.setPressure_num_y(cursorQuery.getInt(185));
                clockConfig.setPressure_show_type(cursorQuery.isNull(186) ? null : cursorQuery.getString(186));
                clockConfig.setPressure_splt_src(cursorQuery.isNull(187) ? null : cursorQuery.getString(187));
                clockConfig.setShow_step(cursorQuery.getInt(188));
                clockConfig.setStep_src(cursorQuery.isNull(189) ? null : cursorQuery.getString(189));
                clockConfig.setStep_follow_num(cursorQuery.getInt(190));
                clockConfig.setStep_x(cursorQuery.getInt(191));
                clockConfig.setStep_y(cursorQuery.getInt(192));
                clockConfig.setStep_num_src(cursorQuery.isNull(193) ? null : cursorQuery.getString(193));
                clockConfig.setStep_num_type(cursorQuery.getInt(194));
                clockConfig.setStep_show_type(cursorQuery.getInt(UsimPhoneBookManagerEx.USIM_EFSNE_TAG));
                clockConfig.setStep_num_x(cursorQuery.getInt(UsimPhoneBookManagerEx.USIM_EFANR_TAG));
                clockConfig.setStep_num_y(cursorQuery.getInt(197));
                clockConfig.setStep_end_src(cursorQuery.isNull(UsimPhoneBookManagerEx.USIM_EFGRP_TAG) ? null : cursorQuery.getString(UsimPhoneBookManagerEx.USIM_EFGRP_TAG));
                clockConfig.setShow_step_progress(cursorQuery.getInt(UsimPhoneBookManagerEx.USIM_EFAAS_TAG));
                clockConfig.setStep_progress_x(cursorQuery.getInt(200));
                clockConfig.setStep_progress_y(cursorQuery.getInt(201));
                clockConfig.setStep_progress_src(cursorQuery.isNull(UsimPhoneBookManagerEx.USIM_EFEMAIL_TAG) ? null : cursorQuery.getString(UsimPhoneBookManagerEx.USIM_EFEMAIL_TAG));
                clockConfig.setOpen_step_arc_show(cursorQuery.getInt(203));
                clockConfig.setStep_arc_type(cursorQuery.getInt(204));
                clockConfig.setStep_arc_center_x(cursorQuery.getInt(205));
                clockConfig.setStep_arc_center_y(cursorQuery.getInt(206));
                clockConfig.setShow_kcal(cursorQuery.getInt(207));
                clockConfig.setKcal_src(cursorQuery.isNull(BerTlv.BER_PROACTIVE_COMMAND_TAG) ? null : cursorQuery.getString(BerTlv.BER_PROACTIVE_COMMAND_TAG));
                clockConfig.setKcal_x(cursorQuery.getInt(209));
                clockConfig.setKcal_y(cursorQuery.getInt(210));
                clockConfig.setKcal_num_src(cursorQuery.isNull(211) ? null : cursorQuery.getString(211));
                clockConfig.setKcal_num_type(cursorQuery.getInt(CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_APP_TOOLKIT_BUSY));
                clockConfig.setKcal_show_type(cursorQuery.getInt(CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR));
                clockConfig.setKcal_num_x(cursorQuery.getInt(BerTlv.BER_EVENT_DOWNLOAD_TAG));
                clockConfig.setKcal_num_y(cursorQuery.getInt(215));
                clockConfig.setKcal_end_src(cursorQuery.isNull(216) ? null : cursorQuery.getString(216));
                clockConfig.setShow_km(cursorQuery.isNull(217) ? null : cursorQuery.getString(217));
                clockConfig.setKm_src(cursorQuery.isNull(218) ? null : cursorQuery.getString(218));
                clockConfig.setKm_x(cursorQuery.getInt(219));
                clockConfig.setKm_y(cursorQuery.getInt(220));
                clockConfig.setKm_num_src(cursorQuery.isNull(221) ? null : cursorQuery.getString(221));
                clockConfig.setKm_comma_src(cursorQuery.isNull(222) ? null : cursorQuery.getString(222));
                clockConfig.setKm_num_type(cursorQuery.isNull(223) ? null : cursorQuery.getString(223));
                clockConfig.setKm_show_type(cursorQuery.getInt(224));
                clockConfig.setKm_num_x(cursorQuery.getInt(225));
                clockConfig.setKm_num_y(cursorQuery.getInt(RadioCdmaSmsConst.UDH_OTHER_SIZE));
                clockConfig.setKm_end_src(cursorQuery.isNull(227) ? null : cursorQuery.getString(227));
                clockConfig.setShow_weather(cursorQuery.isNull(228) ? null : cursorQuery.getString(228));
                clockConfig.setShow_temperature(cursorQuery.isNull(RadioCdmaSmsConst.USER_DATA_MAX) ? null : cursorQuery.getString(RadioCdmaSmsConst.USER_DATA_MAX));
                clockConfig.setTemperature_show_type(cursorQuery.getInt(230));
                clockConfig.setTemperature_num_type(cursorQuery.getInt(231));
                clockConfig.setTemperature_x(cursorQuery.getInt(232));
                clockConfig.setTemperature_y(cursorQuery.getInt(233));
                clockConfig.setTemperature_x_2(cursorQuery.getInt(234));
                clockConfig.setTemperature_y_2(cursorQuery.getInt(235));
                clockConfig.setShow_now_tem(cursorQuery.isNull(236) ? null : cursorQuery.getString(236));
                clockConfig.setNow_tem_show_type(cursorQuery.isNull(237) ? null : cursorQuery.getString(237));
                clockConfig.setNow_tem_x(cursorQuery.getInt(238));
                clockConfig.setNow_tem_y(cursorQuery.getInt(239));
                clockConfig.setTemperature_num_src(cursorQuery.isNull(240) ? null : cursorQuery.getString(240));
                clockConfig.setTemperature_sub_src(cursorQuery.isNull(241) ? null : cursorQuery.getString(241));
                clockConfig.setTemperature_sign_src(cursorQuery.isNull(LastCallFailCause.IMSI_UNKNOWN_IN_VLR) ? null : cursorQuery.getString(LastCallFailCause.IMSI_UNKNOWN_IN_VLR));
                clockConfig.setTemperature_splt_src(cursorQuery.isNull(243) ? null : cursorQuery.getString(243));
                clockConfig.setShow_diagram(cursorQuery.isNull(244) ? null : cursorQuery.getString(244));
                clockConfig.setDiagram_x(cursorQuery.getInt(245));
                clockConfig.setDiagram_y(cursorQuery.getInt(246));
                clockConfig.setShowsignal(cursorQuery.getInt(LastCallFailCause.RADIO_OFF));
                clockConfig.setShow_signal(cursorQuery.getInt(LastCallFailCause.OUT_OF_SERVICE));
                clockConfig.setSignal_src(cursorQuery.isNull(LastCallFailCause.NO_VALID_SIM) ? null : cursorQuery.getString(LastCallFailCause.NO_VALID_SIM));
                clockConfig.setSignal_x(cursorQuery.getInt(250));
                clockConfig.setSignal_y(cursorQuery.getInt(LastCallFailCause.NETWORK_RESP_TIMEOUT));
                clockConfig.setShow_user_name(cursorQuery.isNull(LastCallFailCause.NETWORK_REJECT) ? null : cursorQuery.getString(LastCallFailCause.NETWORK_REJECT));
                clockConfig.setName_show_type(cursorQuery.isNull(LastCallFailCause.RADIO_ACCESS_FAILURE) ? null : cursorQuery.getString(LastCallFailCause.RADIO_ACCESS_FAILURE));
                clockConfig.setName_x(cursorQuery.getInt(LastCallFailCause.RADIO_LINK_FAILURE));
                clockConfig.setName_y(cursorQuery.getInt(255));
                clockConfig.setShow_operator(cursorQuery.isNull(256) ? null : cursorQuery.getString(256));
                clockConfig.setOperator_show_type(cursorQuery.isNull(257) ? null : cursorQuery.getString(257));
                clockConfig.setOperator_x(cursorQuery.getInt(LastCallFailCause.RADIO_RELEASE_NORMAL));
                clockConfig.setOperator_y(cursorQuery.getInt(LastCallFailCause.RADIO_RELEASE_ABNORMAL));
                clockConfig.setShow_btn_call(cursorQuery.isNull(LastCallFailCause.ACCESS_CLASS_BLOCKED) ? null : cursorQuery.getString(LastCallFailCause.ACCESS_CLASS_BLOCKED));
                clockConfig.setBtn_call_src(cursorQuery.isNull(LastCallFailCause.NETWORK_DETACH) ? null : cursorQuery.getString(LastCallFailCause.NETWORK_DETACH));
                clockConfig.setBtn_call_x(cursorQuery.getInt(262));
                clockConfig.setBtn_call_y(cursorQuery.getInt(263));
                clockConfig.setShow_btn_sms(cursorQuery.isNull(264) ? null : cursorQuery.getString(264));
                clockConfig.setBtn_sms_src(cursorQuery.isNull(265) ? null : cursorQuery.getString(265));
                clockConfig.setBtn_sms_x(cursorQuery.getInt(266));
                clockConfig.setBtn_sms_y(cursorQuery.getInt(267));
                clockConfig.setShow_btn_heart(cursorQuery.isNull(268) ? null : cursorQuery.getString(268));
                clockConfig.setIs_our_heart(cursorQuery.getInt(269));
                clockConfig.setBtn_heart_src(cursorQuery.isNull(270) ? null : cursorQuery.getString(270));
                clockConfig.setBtn_heart_x(cursorQuery.getInt(271));
                clockConfig.setBtn_heart_y(cursorQuery.getInt(272));
                clockConfig.setShow_btn_step(cursorQuery.isNull(273) ? null : cursorQuery.getString(273));
                clockConfig.setBtn_step_src(cursorQuery.isNull(274) ? null : cursorQuery.getString(274));
                clockConfig.setBtn_step_x(cursorQuery.getInt(275));
                clockConfig.setBtn_step_y(cursorQuery.getInt(276));
                clockConfig.setShow_btn_wechat(cursorQuery.isNull(277) ? null : cursorQuery.getString(277));
                clockConfig.setBtn_wechat_src(cursorQuery.isNull(278) ? null : cursorQuery.getString(278));
                clockConfig.setBtn_wechat_x(cursorQuery.getInt(279));
                clockConfig.setBtn_wechat_y(cursorQuery.getInt(280));
                clockConfig.setShow_btn_alipay(cursorQuery.getInt(281));
                clockConfig.setBtn_alipay_src(cursorQuery.isNull(282) ? null : cursorQuery.getString(282));
                clockConfig.setBtn_alipay_x(cursorQuery.getInt(283));
                clockConfig.setBtn_alipay_y(cursorQuery.getInt(284));
                clockConfig.setShow_btn_stopwatch(cursorQuery.getInt(285));
                clockConfig.setBtn_stopwatch_src(cursorQuery.isNull(286) ? null : cursorQuery.getString(286));
                clockConfig.setBtn_stopwatch_x(cursorQuery.getInt(287));
                clockConfig.setBtn_stopwatch_y(cursorQuery.getInt(288));
                clockConfig.setShow_btn_weather(cursorQuery.getInt(289));
                clockConfig.setShow_btn_calo(cursorQuery.getInt(290));
                clockConfig.setBtn_calo_src(cursorQuery.isNull(291) ? null : cursorQuery.getString(291));
                clockConfig.setBtn_calo_x(cursorQuery.getInt(292));
                clockConfig.setBtn_calo_y(cursorQuery.getInt(293));
                clockConfig.setTemprature_src(cursorQuery.isNull(294) ? null : cursorQuery.getString(294));
                clockConfig.setShow_btn_camera(cursorQuery.isNull(295) ? null : cursorQuery.getString(295));
                clockConfig.setBtn_camera_src(cursorQuery.isNull(296) ? null : cursorQuery.getString(296));
                clockConfig.setBtn_camera_x(cursorQuery.getInt(297));
                clockConfig.setBtn_camera_y(cursorQuery.getInt(298));
                clockConfig.setShow_btn_sos(cursorQuery.isNull(299) ? null : cursorQuery.getString(299));
                clockConfig.setBtn_sos_src(cursorQuery.isNull(ScanIntervalRange.MAX) ? null : cursorQuery.getString(ScanIntervalRange.MAX));
                clockConfig.setBtn_sos_x(cursorQuery.getInt(301));
                clockConfig.setBtn_sos_y(cursorQuery.getInt(302));
                clockConfig.setShow_special_1(cursorQuery.isNull(303) ? null : cursorQuery.getString(303));
                clockConfig.setSpecial_1_src(cursorQuery.isNull(304) ? null : cursorQuery.getString(304));
                clockConfig.setSpecial_1_position(cursorQuery.isNull(305) ? null : cursorQuery.getString(305));
                clockConfig.setSpecial_x(cursorQuery.getInt(306));
                clockConfig.setSpecial_y(cursorQuery.getInt(307));
                clockConfig.setSupport_multiple_change(cursorQuery.getInt(308));
                clockConfig.setShow_lunar_year(cursorQuery.getInt(309));
                clockConfig.setLunar_day_splt_src(cursorQuery.isNull(310) ? null : cursorQuery.getString(310));
                clockConfig.setLunar_month_splt_src(cursorQuery.isNull(311) ? null : cursorQuery.getString(311));
                clockConfig.setLunar_year_splt_src(cursorQuery.isNull(312) ? null : cursorQuery.getString(312));
                clockConfig.setAm_src(cursorQuery.isNull(313) ? null : cursorQuery.getString(313));
                clockConfig.setPm_src(cursorQuery.isNull(314) ? null : cursorQuery.getString(314));
                clockConfig.setShow_btn_alarm(cursorQuery.getInt(315));
                clockConfig.setBtn_alarm_src(cursorQuery.isNull(TypedValues.AttributesType.TYPE_PATH_ROTATE) ? null : cursorQuery.getString(TypedValues.AttributesType.TYPE_PATH_ROTATE));
                clockConfig.setBtn_alarm_x(cursorQuery.getInt(TypedValues.AttributesType.TYPE_EASING));
                clockConfig.setBtn_alarm_y(cursorQuery.getInt(TypedValues.AttributesType.TYPE_PIVOT_TARGET));
                clockConfig.setBg_btn_change(cursorQuery.getInt(319));
                clockConfig.setBg_btn_index(cursorQuery.getInt(320));
                clockConfig.setShow_btn_music(cursorQuery.getInt(321));
                clockConfig.setBtn_music_src(cursorQuery.isNull(322) ? null : cursorQuery.getString(322));
                clockConfig.setBtn_music_x(cursorQuery.getInt(323));
                clockConfig.setBtn_music_y(cursorQuery.getInt(324));
                clockConfig.setSupport_dynamic_change(cursorQuery.getInt(CallFailCause.EMERGENCY_TEMP_FAILURE));
                clockConfig.setLevel(cursorQuery.getInt(CallFailCause.EMERGENCY_PERM_FAILURE));
                clockConfig.setParent_id(cursorQuery.isNull(327) ? null : cursorQuery.getString(327));
                clockConfig.setNext_id(cursorQuery.getInt(328));
                clockConfig.setChange_starttime(cursorQuery.getInt(329));
                clockConfig.setChange_endtime(cursorQuery.getInt(330));
                clockConfig.setBtn_weather_src(cursorQuery.isNull(331) ? null : cursorQuery.getString(331));
                clockConfig.setBtn_weather_x(cursorQuery.getInt(332));
                clockConfig.setBtn_weather_y(cursorQuery.getInt(333));
                clockConfig.setShow_btn_calories(cursorQuery.getInt(334));
                clockConfig.setBtn_calories_src(cursorQuery.isNull(335) ? null : cursorQuery.getString(335));
                clockConfig.setBtn_calories_x(cursorQuery.getInt(336));
                clockConfig.setBtn_calories_y(cursorQuery.getInt(337));
                clockConfig.setSupport_compass(cursorQuery.getInt(338));
                clockConfig.setCompass_src(cursorQuery.isNull(339) ? null : cursorQuery.getString(339));
                clockConfig.setCompass_2_src(cursorQuery.isNull(340) ? null : cursorQuery.getString(340));
                clockConfig.setCompass_x(cursorQuery.getInt(341));
                clockConfig.setCompass_y(cursorQuery.getInt(342));
                clockConfig.setShow_btn_setting(cursorQuery.getInt(343));
                clockConfig.setBtn_setting_src(cursorQuery.isNull(344) ? null : cursorQuery.getString(344));
                clockConfig.setBtn_setting_x(cursorQuery.getInt(345));
                clockConfig.setBtn_setting_y(cursorQuery.getInt(346));
                clockConfig.setSupport_click_change(cursorQuery.getInt(347));
                clockConfig.setClick_id_is_current(cursorQuery.getInt(348));
                clockConfig.setCompass_show_detail_degree(cursorQuery.getInt(349));
                clockConfig.setCompass_direction_src(cursorQuery.isNull(350) ? null : cursorQuery.getString(350));
                clockConfig.setCompass_direction_x(cursorQuery.getInt(351));
                clockConfig.setCompass_direction_y(cursorQuery.getInt(352));
                clockConfig.setCompass_direction_2_src(cursorQuery.isNull(353) ? null : cursorQuery.getString(353));
                clockConfig.setCompass_direction_2_x(cursorQuery.getInt(354));
                clockConfig.setCompass_direction_2_y(cursorQuery.getInt(355));
                clockConfig.setCompass_direction_3_src(cursorQuery.isNull(356) ? null : cursorQuery.getString(356));
                clockConfig.setCompass_direction_3_x(cursorQuery.getInt(357));
                clockConfig.setCompass_direction_3_y(cursorQuery.getInt(358));
                clockConfig.setCompass_direction_degree_src(cursorQuery.isNull(359) ? null : cursorQuery.getString(359));
                clockConfig.setCompass_direction_degree_x(cursorQuery.getInt(360));
                clockConfig.setCompass_direction_degree_y(cursorQuery.getInt(361));
                clockConfig.setCompass_direction_degree_unit(cursorQuery.isNull(362) ? null : cursorQuery.getString(362));
                clockConfig.setCompass_degree_1_src(cursorQuery.isNull(363) ? null : cursorQuery.getString(363));
                clockConfig.setCompass_degree_1_x(cursorQuery.getInt(364));
                clockConfig.setCompass_degree_1_y(cursorQuery.getInt(365));
                clockConfig.setCompass_degree_2_src(cursorQuery.isNull(366) ? null : cursorQuery.getString(366));
                clockConfig.setCompass_degree_2_x(cursorQuery.getInt(367));
                clockConfig.setCompass_degree_2_y(cursorQuery.getInt(368));
                clockConfig.setCompass_degree_3_src(cursorQuery.isNull(369) ? null : cursorQuery.getString(369));
                clockConfig.setCompass_degree_3_x(cursorQuery.getInt(370));
                clockConfig.setCompass_degree_3_y(cursorQuery.getInt(371));
                clockConfig.setShow_connect_animation(cursorQuery.getInt(372));
                clockConfig.setConnect_animation_x(cursorQuery.getInt(373));
                clockConfig.setConnect_animation_y(cursorQuery.getInt(374));
                clockConfig.setConnect_animation_count(cursorQuery.getInt(375));
                clockConfig.setShow_state(cursorQuery.getInt(376));
                clockConfig.setState_x(cursorQuery.getInt(377));
                clockConfig.setState_y(cursorQuery.getInt(378));
                clockConfig.setAction_1_cut_position(cursorQuery.getInt(379));
                clockConfig.setAction_2_cut_position(cursorQuery.getInt(380));
                clockConfig.setAction_3_cut_position(cursorQuery.getInt(381));
                clockConfig.setShow_btn_googleplay(cursorQuery.getInt(382));
                clockConfig.setBtn_googleplay_src(cursorQuery.isNull(383) ? null : cursorQuery.getString(383));
                clockConfig.setBtn_googleplay_x(cursorQuery.getInt(384));
                clockConfig.setBtn_googleplay_y(cursorQuery.getInt(385));
                clockConfig.setShow_month_2(cursorQuery.getInt(386));
                clockConfig.setMonth_type_2(cursorQuery.getInt(387));
                clockConfig.setMonth_src_2(cursorQuery.isNull(388) ? null : cursorQuery.getString(388));
                clockConfig.setMonth_x_2(cursorQuery.getInt(389));
                clockConfig.setMonth_y_2(cursorQuery.getInt(390));
                clockConfig.setTime_special_new(cursorQuery.getInt(391));
                clockConfig.setTime_special_hour_ten_src(cursorQuery.isNull(392) ? null : cursorQuery.getString(392));
                clockConfig.setTime_special_hour_src(cursorQuery.isNull(393) ? null : cursorQuery.getString(393));
                clockConfig.setTime_special_min_ten_src(cursorQuery.isNull(394) ? null : cursorQuery.getString(394));
                clockConfig.setTime_special_min_src(cursorQuery.isNull(395) ? null : cursorQuery.getString(395));
                clockConfig.setShow_kcal_progress(cursorQuery.getInt(396));
                clockConfig.setKcal_progress_x(cursorQuery.getInt(397));
                clockConfig.setKcal_progress_y(cursorQuery.getInt(398));
                clockConfig.setKcal_progress_src(cursorQuery.isNull(399) ? null : cursorQuery.getString(399));
                clockConfig.setOpen_kcal_arc_show(cursorQuery.getInt(400));
                clockConfig.setKcal_arc_type(cursorQuery.getInt(TypedValues.CycleType.TYPE_CURVE_FIT));
                clockConfig.setKcal_arc_center_x(cursorQuery.getInt(TypedValues.CycleType.TYPE_VISIBILITY));
                clockConfig.setKcal_arc_center_y(cursorQuery.getInt(TypedValues.CycleType.TYPE_ALPHA));
                clockConfig.setOpen_power_arc_show(cursorQuery.getInt(404));
                clockConfig.setPower_arc_type(cursorQuery.getInt(405));
                clockConfig.setPower_arc_center_x(cursorQuery.getInt(406));
                clockConfig.setPower_arc_center_y(cursorQuery.getInt(407));
                clockConfig.setShow_btn_timer(cursorQuery.getInt(408));
                clockConfig.setBtn_timer_src(cursorQuery.isNull(409) ? null : cursorQuery.getString(409));
                clockConfig.setBtn_timer_x(cursorQuery.getInt(410));
                clockConfig.setBtn_timer_y(cursorQuery.getInt(411));
                clockConfig.setShow_btn_sleep(cursorQuery.getInt(412));
                clockConfig.setBtn_sleep_src(cursorQuery.isNull(413) ? null : cursorQuery.getString(413));
                clockConfig.setBtn_sleep_x(cursorQuery.getInt(414));
                clockConfig.setBtn_sleep_y(cursorQuery.getInt(415));
                clockConfig.setShow_btn_bloodpressure(cursorQuery.getInt(TypedValues.CycleType.TYPE_PATH_ROTATE));
                clockConfig.setBtn_bloodpressure_src(cursorQuery.isNull(417) ? null : cursorQuery.getString(417));
                clockConfig.setBtn_bloodpressure_x(cursorQuery.getInt(418));
                clockConfig.setBtn_bloodpressure_y(cursorQuery.getInt(419));
                clockConfig.setShow_btn_sport_record(cursorQuery.getInt(TypedValues.CycleType.TYPE_EASING));
                clockConfig.setBtn_sport_record_src(cursorQuery.isNull(TypedValues.CycleType.TYPE_WAVE_SHAPE) ? null : cursorQuery.getString(TypedValues.CycleType.TYPE_WAVE_SHAPE));
                clockConfig.setBtn_sport_record_x(cursorQuery.getInt(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE));
                clockConfig.setBtn_sport_record_y(cursorQuery.getInt(TypedValues.CycleType.TYPE_WAVE_PERIOD));
                clockConfig.setLottie_hierarchy(cursorQuery.getInt(TypedValues.CycleType.TYPE_WAVE_OFFSET));
                clockConfig.setShow_heart_progress(cursorQuery.getInt(TypedValues.CycleType.TYPE_WAVE_PHASE));
                clockConfig.setHeart_progress_x(cursorQuery.getInt(426));
                clockConfig.setHeart_progress_y(cursorQuery.getInt(427));
                clockConfig.setHeart_progress_src(cursorQuery.isNull(428) ? null : cursorQuery.getString(428));
                clockConfig.setShow_btn_calculator(cursorQuery.getInt(429));
                clockConfig.setBtn_calculator_src(cursorQuery.isNull(430) ? null : cursorQuery.getString(430));
                clockConfig.setBtn_calculator_x(cursorQuery.getInt(431));
                clockConfig.setBtn_calculator_y(cursorQuery.getInt(432));
                clockConfig.setTime_special_drag_3d(cursorQuery.getInt(433));
                clockConfig.setPrev_HourTen_Position(cursorQuery.isNull(434) ? null : cursorQuery.getString(434));
                clockConfig.setPrev_HourGe_Position(cursorQuery.isNull(435) ? null : cursorQuery.getString(435));
                clockConfig.setCurrent_HourTen_Position(cursorQuery.isNull(436) ? null : cursorQuery.getString(436));
                clockConfig.setCurrent_HourGe_Position(cursorQuery.isNull(437) ? null : cursorQuery.getString(437));
                clockConfig.setNext_HourTen_Position(cursorQuery.isNull(438) ? null : cursorQuery.getString(438));
                clockConfig.setNext_HourGe_Position(cursorQuery.isNull(439) ? null : cursorQuery.getString(439));
                clockConfig.setPrev_MinTen_Position(cursorQuery.isNull(440) ? null : cursorQuery.getString(440));
                clockConfig.setPrev_MinGe_Position(cursorQuery.isNull(441) ? null : cursorQuery.getString(441));
                clockConfig.setCurrent_MinTen_Position(cursorQuery.isNull(442) ? null : cursorQuery.getString(442));
                clockConfig.setCurrent_MinGe_Position(cursorQuery.isNull(443) ? null : cursorQuery.getString(443));
                clockConfig.setNext_MinTen_Position(cursorQuery.isNull(444) ? null : cursorQuery.getString(444));
                clockConfig.setNext_MinGe_Position(cursorQuery.isNull(445) ? null : cursorQuery.getString(445));
                clockConfig.setNeed_split_day(cursorQuery.getInt(446));
                clockConfig.setSplit_day_x(cursorQuery.getInt(447));
                clockConfig.setSplit_day_y(cursorQuery.getInt(448));
                clockConfig.setOpen_now_tem_arc_show(cursorQuery.getInt(449));
                clockConfig.setNow_tem_arc_type(cursorQuery.getInt(450));
                clockConfig.setNow_tem_arc_center_x(cursorQuery.getInt(451));
                clockConfig.setNow_tem_arc_center_y(cursorQuery.getInt(452));
                clockConfig.setShow_km_progress(cursorQuery.getInt(453));
                clockConfig.setKm_progress_x(cursorQuery.getInt(454));
                clockConfig.setKm_progress_y(cursorQuery.getInt(455));
                clockConfig.setKm_progress_src(cursorQuery.isNull(456) ? null : cursorQuery.getString(456));
                clockConfig.setOpen_km_arc_show(cursorQuery.getInt(457));
                clockConfig.setKm_arc_type(cursorQuery.getInt(458));
                clockConfig.setKm_arc_center_x(cursorQuery.getInt(459));
                clockConfig.setKm_arc_center_y(cursorQuery.getInt(460));
                clockConfig.setTime_rotate(cursorQuery.getInt(461));
                clockConfig.setTime_rotate_degree(cursorQuery.getInt(462));
                clockConfig.setHeart_num_rotate(cursorQuery.getInt(463));
                clockConfig.setHeart_num_rotate_degree(cursorQuery.getInt(464));
                clockConfig.setShow_oxygen(cursorQuery.getInt(465));
                clockConfig.setOxygen_src(cursorQuery.isNull(466) ? null : cursorQuery.getString(466));
                clockConfig.setOxygen_x(cursorQuery.getInt(467));
                clockConfig.setOxygen_y(cursorQuery.getInt(468));
                clockConfig.setOxygen_num_src(cursorQuery.isNull(469) ? null : cursorQuery.getString(469));
                clockConfig.setOxygen_sign_src(cursorQuery.isNull(470) ? null : cursorQuery.getString(470));
                clockConfig.setOxygen_show_type(cursorQuery.getInt(471));
                clockConfig.setOxygen_num_x(cursorQuery.getInt(472));
                clockConfig.setOxygen_num_y(cursorQuery.getInt(473));
                clockConfig.setTime_change_counter(cursorQuery.getInt(474));
                clockConfig.setTime_hour_src_2(cursorQuery.isNull(475) ? null : cursorQuery.getString(475));
                clockConfig.setTime_min_src_2(cursorQuery.isNull(476) ? null : cursorQuery.getString(476));
                clockConfig.setTime_sec_src_2(cursorQuery.isNull(477) ? null : cursorQuery.getString(477));
                clockConfig.setTime_splt_src_2(cursorQuery.isNull(478) ? null : cursorQuery.getString(478));
                clockConfig.setTime_splt_2_src_2(cursorQuery.isNull(479) ? null : cursorQuery.getString(479));
                clockConfig.setTime_hour_src_3(cursorQuery.isNull(480) ? null : cursorQuery.getString(480));
                clockConfig.setTime_min_src_3(cursorQuery.isNull(481) ? null : cursorQuery.getString(481));
                clockConfig.setTime_sec_src_3(cursorQuery.isNull(482) ? null : cursorQuery.getString(482));
                clockConfig.setTime_splt_src_3(cursorQuery.isNull(483) ? null : cursorQuery.getString(483));
                clockConfig.setTime_splt_2_src_3(cursorQuery.isNull(484) ? null : cursorQuery.getString(484));
                clockConfig.setTime_hour_src_4(cursorQuery.isNull(485) ? null : cursorQuery.getString(485));
                clockConfig.setTime_min_src_4(cursorQuery.isNull(486) ? null : cursorQuery.getString(486));
                clockConfig.setTime_sec_src_4(cursorQuery.isNull(487) ? null : cursorQuery.getString(487));
                clockConfig.setTime_splt_src_4(cursorQuery.isNull(488) ? null : cursorQuery.getString(488));
                clockConfig.setTime_splt_2_src_4(cursorQuery.isNull(489) ? null : cursorQuery.getString(489));
                clockConfig.setDate_rotate(cursorQuery.getInt(490));
                clockConfig.setDate_rotate_degree(cursorQuery.getInt(491));
                clockConfig.setNeed_split_hour(cursorQuery.getInt(492));
                clockConfig.setSplit_hour_src(cursorQuery.isNull(493) ? null : cursorQuery.getString(493));
                clockConfig.setSplit_hour_x(cursorQuery.getInt(494));
                clockConfig.setSplit_hour_y(cursorQuery.getInt(495));
                clockConfig.setNeed_split_min(cursorQuery.getInt(496));
                clockConfig.setSplit_min_src(cursorQuery.isNull(497) ? null : cursorQuery.getString(497));
                clockConfig.setSplit_min_x(cursorQuery.getInt(498));
                clockConfig.setSplit_min_y(cursorQuery.getInt(499));
                clockConfig.setSupport_scale(cursorQuery.getInt(500));
                clockConfig.setShow_compass_num(cursorQuery.getInt(501));
                clockConfig.setCompass_num_src(cursorQuery.isNull(502) ? null : cursorQuery.getString(502));
                clockConfig.setCompass_show_type(cursorQuery.getInt(503));
                clockConfig.setCompass_num_x(cursorQuery.getInt(504));
                clockConfig.setCompass_num_y(cursorQuery.getInt(505));
                clockConfig.setCompass_num_src_prefix(cursorQuery.isNull(506) ? null : cursorQuery.getString(506));
                clockConfig.setCompass_num_src_sign(cursorQuery.isNull(507) ? null : cursorQuery.getString(507));
                clockConfig.setShow_btn_oxygen(cursorQuery.getInt(508));
                clockConfig.setBtn_oxygen_src(cursorQuery.isNull(509) ? null : cursorQuery.getString(509));
                clockConfig.setBtn_oxygen_x(cursorQuery.getInt(510));
                clockConfig.setBtn_oxygen_y(cursorQuery.getInt(511));
                clockConfig.setShow_btn_calendar(cursorQuery.getInt(512));
                clockConfig.setBtn_calendar_src(cursorQuery.isNull(513) ? null : cursorQuery.getString(513));
                clockConfig.setBtn_calendar_x(cursorQuery.getInt(RadioError.OEM_ERROR_14));
                clockConfig.setBtn_calendar_y(cursorQuery.getInt(RadioError.OEM_ERROR_15));
                clockConfig.setShow_btn_compass(cursorQuery.getInt(RadioError.OEM_ERROR_16));
                clockConfig.setBtn_compass_src(cursorQuery.isNull(RadioError.OEM_ERROR_17) ? null : cursorQuery.getString(RadioError.OEM_ERROR_17));
                clockConfig.setBtn_compass_x(cursorQuery.getInt(RadioError.OEM_ERROR_18));
                clockConfig.setBtn_compass_y(cursorQuery.getInt(RadioError.OEM_ERROR_19));
                clockConfig.setPointer_disable_scale(cursorQuery.getInt(RadioError.OEM_ERROR_20));
                clockConfig.setShow_chinse_time(cursorQuery.getInt(RadioError.OEM_ERROR_21));
                clockConfig.setChinse_time_src(cursorQuery.isNull(RadioError.OEM_ERROR_22) ? null : cursorQuery.getString(RadioError.OEM_ERROR_22));
                clockConfig.setChinse_time_x(cursorQuery.getInt(RadioError.OEM_ERROR_23));
                clockConfig.setChinse_time_y(cursorQuery.getInt(RadioError.OEM_ERROR_24));
                clockConfig.setShow_btn_photo(cursorQuery.getInt(RadioError.OEM_ERROR_25));
                clockConfig.setBtn_photo_src(cursorQuery.isNull(526) ? null : cursorQuery.getString(526));
                clockConfig.setBtn_photo_x(cursorQuery.getInt(527));
                clockConfig.setBtn_photo_y(cursorQuery.getInt(528));
                clockConfig.setShow_btn_contact(cursorQuery.getInt(529));
                clockConfig.setBtn_contact_src(cursorQuery.isNull(530) ? null : cursorQuery.getString(530));
                clockConfig.setBtn_contact_x(cursorQuery.getInt(531));
                clockConfig.setBtn_contact_y(cursorQuery.getInt(532));
                clockConfig.setKcal_num_rotate(cursorQuery.getInt(533));
                clockConfig.setKcal_num_rotate_degree(cursorQuery.getInt(534));
                clockConfig.setShow_power_progress(cursorQuery.getInt(535));
                clockConfig.setPower_progress_src(cursorQuery.isNull(536) ? null : cursorQuery.getString(536));
                clockConfig.setPower_progress_x(cursorQuery.getInt(537));
                clockConfig.setPower_progress_y(cursorQuery.getInt(538));
                clockConfig.setPower_src(cursorQuery.isNull(539) ? null : cursorQuery.getString(539));
                clockConfig.setPower_src_x(cursorQuery.getInt(540));
                clockConfig.setPower_src_y(cursorQuery.getInt(541));
                clockConfig.setVideo_type(cursorQuery.getInt(542));
                clockConfig.setStep_keep_number_length(cursorQuery.getInt(543));
                clockConfig.setKcal_keep_number_length(cursorQuery.getInt(544));
                clockConfig.setKm_keep_number_length(cursorQuery.getInt(545));
                clockConfig.setStep_num_rotate(cursorQuery.getInt(546));
                clockConfig.setStep_num_rotate_degree(cursorQuery.getInt(547));
                clockConfig.setShow_btn_style(cursorQuery.getInt(548));
                clockConfig.setBtn_style_src(cursorQuery.isNull(549) ? null : cursorQuery.getString(549));
                clockConfig.setBtn_style_x(cursorQuery.getInt(550));
                clockConfig.setBtn_style_y(cursorQuery.getInt(551));
                clockConfig.setNeed_split_sec(cursorQuery.getInt(552));
                clockConfig.setSplit_sec_src(cursorQuery.isNull(553) ? null : cursorQuery.getString(553));
                clockConfig.setSplit_sec_x(cursorQuery.getInt(554));
                clockConfig.setSplit_sec_y(cursorQuery.getInt(555));
                clockConfig.setOpen_oxygen_arc_show(cursorQuery.getInt(556));
                clockConfig.setOxygen_arc_type(cursorQuery.getInt(557));
                clockConfig.setOxygen_arc_center_x(cursorQuery.getInt(558));
                clockConfig.setOxygen_arc_center_y(cursorQuery.getInt(559));
                clockConfig.setShow_oxygen_progress(cursorQuery.getInt(560));
                clockConfig.setOxygen_progress_src(cursorQuery.isNull(561) ? null : cursorQuery.getString(561));
                clockConfig.setOxygen_progress_x(cursorQuery.getInt(562));
                clockConfig.setOxygen_progress_y(cursorQuery.getInt(563));
                clockConfig.setShow_week_donts(cursorQuery.getInt(564));
                clockConfig.setWeek_donts_src(cursorQuery.isNull(565) ? null : cursorQuery.getString(565));
                clockConfig.setWeek_donts_x(cursorQuery.getInt(566));
                clockConfig.setWeek_donts_y(cursorQuery.getInt(567));
                clockConfig.setShow_btn_flashlight(cursorQuery.getInt(568));
                clockConfig.setFlashlight_src(cursorQuery.isNull(569) ? null : cursorQuery.getString(569));
                clockConfig.setFlashlight_x(cursorQuery.getInt(570));
                clockConfig.setFlashlight_y(cursorQuery.getInt(571));
                arrayList.add(clockConfig);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.dw.launcher.data.database.dao.ClockConfigDao
    public List<ClockConfig> queryAllFromAssets(final int level, final int fromAsserts) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from t_clock_config where fromAssets = ? and level = ?", 2);
        roomSQLiteQueryAcquire.bindLong(1, fromAsserts);
        roomSQLiteQueryAcquire.bindLong(2, level);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "path");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fromAssets");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_en");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screentype");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dialtype");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coordinate_screen_width");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coordinate_screen_height");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_type");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lottie");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_animal_keep_for_last_frame");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_count");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_interval");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_is_customize");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hour_pointer_src");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hour_pointer_x");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hour_pointer_y");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minute_pointer_src");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minute_pointer_x");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minute_pointer_y");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_src");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_x");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_y");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_animal_type");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dot_src");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dot_x");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dot_y");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_pointer_start_animation");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_start_hour");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_start_minute");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_start_second");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_need_jump");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_x");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_y");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_min");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_min_x");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_min_y");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_sec");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_sec");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_sec_x");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_sec_y");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_time_arc_show");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_arc_type");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_arc_center_x");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_arc_center_y");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_am_or_pm");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_and_pm_src");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_or_pm_x");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_or_pm_y");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_ampm_placeholer");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_digital_start_animation");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "digital_start_hour");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "digital_start_minute");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "digital_start_second");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_src");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_x");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_y");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_date_arc_show");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_arc_type");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_arc_center_x");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_arc_center_y");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_year_splt_src");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_month_splt_src");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_day_splt_src");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_year");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "year_digits_type");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_month");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_type");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_src");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_month");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data_month_num");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_x");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_y");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_day");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_day");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data_day_num");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_x");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_y");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_src");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_type");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_src");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_num_src");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_x");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_y");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_power");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_0_src");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_1_src");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_2_src");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_3_src");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_4_src");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_5_src");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_6_src");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_7_src");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_8_src");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_9_src");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_10_src");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_x");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_y");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_charge");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_0_src");
                int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_1_src");
                int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_2_src");
                int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_3_src");
                int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_4_src");
                int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_5_src");
                int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_6_src");
                int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_7_src");
                int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_8_src");
                int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_9_src");
                int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_10_src");
                int columnIndexOrThrow119 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_power_num");
                int columnIndexOrThrow120 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_num_src");
                int columnIndexOrThrow121 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_sign_src");
                int columnIndexOrThrow122 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_show_type");
                int columnIndexOrThrow123 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_num_x");
                int columnIndexOrThrow124 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_num_y");
                int columnIndexOrThrow125 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_action");
                int columnIndexOrThrow126 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_action_1");
                int columnIndexOrThrow127 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_count");
                int columnIndexOrThrow128 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_x");
                int columnIndexOrThrow129 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_y");
                int columnIndexOrThrow130 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_action_2");
                int columnIndexOrThrow131 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_count");
                int columnIndexOrThrow132 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_x");
                int columnIndexOrThrow133 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_y");
                int columnIndexOrThrow134 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_action_3");
                int columnIndexOrThrow135 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_count");
                int columnIndexOrThrow136 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_x");
                int columnIndexOrThrow137 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_y");
                int columnIndexOrThrow138 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_interval");
                int columnIndexOrThrow139 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_overall_animation");
                int columnIndexOrThrow140 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "overall_animation_x");
                int columnIndexOrThrow141 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "overall_animation_y");
                int columnIndexOrThrow142 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_1");
                int columnIndexOrThrow143 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_x");
                int columnIndexOrThrow144 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_y");
                int columnIndexOrThrow145 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_width");
                int columnIndexOrThrow146 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_height");
                int columnIndexOrThrow147 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_2");
                int columnIndexOrThrow148 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_x");
                int columnIndexOrThrow149 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_y");
                int columnIndexOrThrow150 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_width");
                int columnIndexOrThrow151 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_height");
                int columnIndexOrThrow152 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_3");
                int columnIndexOrThrow153 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_x");
                int columnIndexOrThrow154 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_y");
                int columnIndexOrThrow155 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_width");
                int columnIndexOrThrow156 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_height");
                int columnIndexOrThrow157 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_4");
                int columnIndexOrThrow158 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_x");
                int columnIndexOrThrow159 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_y");
                int columnIndexOrThrow160 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_width");
                int columnIndexOrThrow161 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_height");
                int columnIndexOrThrow162 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_lunar");
                int columnIndexOrThrow163 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_src");
                int columnIndexOrThrow164 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_x");
                int columnIndexOrThrow165 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_y");
                int columnIndexOrThrow166 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_heart");
                int columnIndexOrThrow167 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_src");
                int columnIndexOrThrow168 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_x");
                int columnIndexOrThrow169 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_y");
                int columnIndexOrThrow170 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_src");
                int columnIndexOrThrow171 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_type");
                int columnIndexOrThrow172 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_end_src");
                int columnIndexOrThrow173 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_show_type");
                int columnIndexOrThrow174 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_x");
                int columnIndexOrThrow175 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_y");
                int columnIndexOrThrow176 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_heart_arc_show");
                int columnIndexOrThrow177 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_arc_type");
                int columnIndexOrThrow178 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_arc_center_x");
                int columnIndexOrThrow179 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_arc_center_y");
                int columnIndexOrThrow180 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_pressure");
                int columnIndexOrThrow181 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_src");
                int columnIndexOrThrow182 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_x");
                int columnIndexOrThrow183 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_y");
                int columnIndexOrThrow184 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_num_src");
                int columnIndexOrThrow185 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_num_x");
                int columnIndexOrThrow186 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_num_y");
                int columnIndexOrThrow187 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_show_type");
                int columnIndexOrThrow188 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_splt_src");
                int columnIndexOrThrow189 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_step");
                int columnIndexOrThrow190 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_src");
                int columnIndexOrThrow191 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_follow_num");
                int columnIndexOrThrow192 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_x");
                int columnIndexOrThrow193 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_y");
                int columnIndexOrThrow194 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_src");
                int columnIndexOrThrow195 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_type");
                int columnIndexOrThrow196 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_show_type");
                int columnIndexOrThrow197 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_x");
                int columnIndexOrThrow198 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_y");
                int columnIndexOrThrow199 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_end_src");
                int columnIndexOrThrow200 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_step_progress");
                int columnIndexOrThrow201 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_progress_x");
                int columnIndexOrThrow202 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_progress_y");
                int columnIndexOrThrow203 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_progress_src");
                int columnIndexOrThrow204 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_step_arc_show");
                int columnIndexOrThrow205 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_arc_type");
                int columnIndexOrThrow206 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_arc_center_x");
                int columnIndexOrThrow207 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_arc_center_y");
                int columnIndexOrThrow208 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_kcal");
                int columnIndexOrThrow209 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_src");
                int columnIndexOrThrow210 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_x");
                int columnIndexOrThrow211 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_y");
                int columnIndexOrThrow212 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_src");
                int columnIndexOrThrow213 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_type");
                int columnIndexOrThrow214 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_show_type");
                int columnIndexOrThrow215 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_x");
                int columnIndexOrThrow216 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_y");
                int columnIndexOrThrow217 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_end_src");
                int columnIndexOrThrow218 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_km");
                int columnIndexOrThrow219 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_src");
                int columnIndexOrThrow220 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_x");
                int columnIndexOrThrow221 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_y");
                int columnIndexOrThrow222 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_src");
                int columnIndexOrThrow223 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_comma_src");
                int columnIndexOrThrow224 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_type");
                int columnIndexOrThrow225 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_show_type");
                int columnIndexOrThrow226 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_x");
                int columnIndexOrThrow227 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_y");
                int columnIndexOrThrow228 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_end_src");
                int columnIndexOrThrow229 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_weather");
                int columnIndexOrThrow230 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_temperature");
                int columnIndexOrThrow231 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_show_type");
                int columnIndexOrThrow232 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_num_type");
                int columnIndexOrThrow233 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_x");
                int columnIndexOrThrow234 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_y");
                int columnIndexOrThrow235 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_x_2");
                int columnIndexOrThrow236 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_y_2");
                int columnIndexOrThrow237 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_now_tem");
                int columnIndexOrThrow238 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_show_type");
                int columnIndexOrThrow239 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_x");
                int columnIndexOrThrow240 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_y");
                int columnIndexOrThrow241 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_num_src");
                int columnIndexOrThrow242 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_sub_src");
                int columnIndexOrThrow243 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_sign_src");
                int columnIndexOrThrow244 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_splt_src");
                int columnIndexOrThrow245 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_diagram");
                int columnIndexOrThrow246 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "diagram_x");
                int columnIndexOrThrow247 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "diagram_y");
                int columnIndexOrThrow248 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "showsignal");
                int columnIndexOrThrow249 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_signal");
                int columnIndexOrThrow250 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "signal_src");
                int columnIndexOrThrow251 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "signal_x");
                int columnIndexOrThrow252 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "signal_y");
                int columnIndexOrThrow253 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_user_name");
                int columnIndexOrThrow254 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_show_type");
                int columnIndexOrThrow255 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_x");
                int columnIndexOrThrow256 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_y");
                int columnIndexOrThrow257 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_operator");
                int columnIndexOrThrow258 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "operator_show_type");
                int columnIndexOrThrow259 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "operator_x");
                int columnIndexOrThrow260 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "operator_y");
                int columnIndexOrThrow261 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_call");
                int columnIndexOrThrow262 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_call_src");
                int columnIndexOrThrow263 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_call_x");
                int columnIndexOrThrow264 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_call_y");
                int columnIndexOrThrow265 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sms");
                int columnIndexOrThrow266 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sms_src");
                int columnIndexOrThrow267 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sms_x");
                int columnIndexOrThrow268 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sms_y");
                int columnIndexOrThrow269 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_heart");
                int columnIndexOrThrow270 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_our_heart");
                int columnIndexOrThrow271 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_heart_src");
                int columnIndexOrThrow272 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_heart_x");
                int columnIndexOrThrow273 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_heart_y");
                int columnIndexOrThrow274 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_step");
                int columnIndexOrThrow275 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_step_src");
                int columnIndexOrThrow276 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_step_x");
                int columnIndexOrThrow277 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_step_y");
                int columnIndexOrThrow278 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_wechat");
                int columnIndexOrThrow279 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_wechat_src");
                int columnIndexOrThrow280 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_wechat_x");
                int columnIndexOrThrow281 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_wechat_y");
                int columnIndexOrThrow282 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_alipay");
                int columnIndexOrThrow283 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alipay_src");
                int columnIndexOrThrow284 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alipay_x");
                int columnIndexOrThrow285 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alipay_y");
                int columnIndexOrThrow286 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_stopwatch");
                int columnIndexOrThrow287 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_stopwatch_src");
                int columnIndexOrThrow288 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_stopwatch_x");
                int columnIndexOrThrow289 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_stopwatch_y");
                int columnIndexOrThrow290 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_weather");
                int columnIndexOrThrow291 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calo");
                int columnIndexOrThrow292 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calo_src");
                int columnIndexOrThrow293 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calo_x");
                int columnIndexOrThrow294 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calo_y");
                int columnIndexOrThrow295 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temprature_src");
                int columnIndexOrThrow296 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_camera");
                int columnIndexOrThrow297 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_camera_src");
                int columnIndexOrThrow298 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_camera_x");
                int columnIndexOrThrow299 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_camera_y");
                int columnIndexOrThrow300 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sos");
                int columnIndexOrThrow301 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sos_src");
                int columnIndexOrThrow302 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sos_x");
                int columnIndexOrThrow303 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sos_y");
                int columnIndexOrThrow304 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_special_1");
                int columnIndexOrThrow305 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_1_src");
                int columnIndexOrThrow306 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_1_position");
                int columnIndexOrThrow307 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_x");
                int columnIndexOrThrow308 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_y");
                int columnIndexOrThrow309 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_multiple_change");
                int columnIndexOrThrow310 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_lunar_year");
                int columnIndexOrThrow311 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_day_splt_src");
                int columnIndexOrThrow312 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_month_splt_src");
                int columnIndexOrThrow313 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_year_splt_src");
                int columnIndexOrThrow314 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_src");
                int columnIndexOrThrow315 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pm_src");
                int columnIndexOrThrow316 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_alarm");
                int columnIndexOrThrow317 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alarm_src");
                int columnIndexOrThrow318 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alarm_x");
                int columnIndexOrThrow319 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alarm_y");
                int columnIndexOrThrow320 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_btn_change");
                int columnIndexOrThrow321 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_btn_index");
                int columnIndexOrThrow322 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_music");
                int columnIndexOrThrow323 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_music_src");
                int columnIndexOrThrow324 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_music_x");
                int columnIndexOrThrow325 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_music_y");
                int columnIndexOrThrow326 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_dynamic_change");
                int columnIndexOrThrow327 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "level");
                int columnIndexOrThrow328 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parent_id");
                int columnIndexOrThrow329 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_id");
                int columnIndexOrThrow330 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "change_starttime");
                int columnIndexOrThrow331 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "change_endtime");
                int columnIndexOrThrow332 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_weather_src");
                int columnIndexOrThrow333 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_weather_x");
                int columnIndexOrThrow334 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_weather_y");
                int columnIndexOrThrow335 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calories");
                int columnIndexOrThrow336 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calories_src");
                int columnIndexOrThrow337 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calories_x");
                int columnIndexOrThrow338 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calories_y");
                int columnIndexOrThrow339 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_compass");
                int columnIndexOrThrow340 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_src");
                int columnIndexOrThrow341 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_2_src");
                int columnIndexOrThrow342 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_x");
                int columnIndexOrThrow343 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_y");
                int columnIndexOrThrow344 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_setting");
                int columnIndexOrThrow345 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_setting_src");
                int columnIndexOrThrow346 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_setting_x");
                int columnIndexOrThrow347 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_setting_y");
                int columnIndexOrThrow348 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_click_change");
                int columnIndexOrThrow349 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_id_is_current");
                int columnIndexOrThrow350 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_show_detail_degree");
                int columnIndexOrThrow351 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_src");
                int columnIndexOrThrow352 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_x");
                int columnIndexOrThrow353 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_y");
                int columnIndexOrThrow354 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_2_src");
                int columnIndexOrThrow355 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_2_x");
                int columnIndexOrThrow356 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_2_y");
                int columnIndexOrThrow357 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_3_src");
                int columnIndexOrThrow358 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_3_x");
                int columnIndexOrThrow359 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_3_y");
                int columnIndexOrThrow360 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_src");
                int columnIndexOrThrow361 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_x");
                int columnIndexOrThrow362 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_y");
                int columnIndexOrThrow363 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_unit");
                int columnIndexOrThrow364 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_1_src");
                int columnIndexOrThrow365 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_1_x");
                int columnIndexOrThrow366 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_1_y");
                int columnIndexOrThrow367 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_2_src");
                int columnIndexOrThrow368 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_2_x");
                int columnIndexOrThrow369 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_2_y");
                int columnIndexOrThrow370 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_3_src");
                int columnIndexOrThrow371 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_3_x");
                int columnIndexOrThrow372 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_3_y");
                int columnIndexOrThrow373 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_connect_animation");
                int columnIndexOrThrow374 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connect_animation_x");
                int columnIndexOrThrow375 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connect_animation_y");
                int columnIndexOrThrow376 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connect_animation_count");
                int columnIndexOrThrow377 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_state");
                int columnIndexOrThrow378 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state_x");
                int columnIndexOrThrow379 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state_y");
                int columnIndexOrThrow380 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_cut_position");
                int columnIndexOrThrow381 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_cut_position");
                int columnIndexOrThrow382 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_cut_position");
                int columnIndexOrThrow383 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_googleplay");
                int columnIndexOrThrow384 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_googleplay_src");
                int columnIndexOrThrow385 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_googleplay_x");
                int columnIndexOrThrow386 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_googleplay_y");
                int columnIndexOrThrow387 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_month_2");
                int columnIndexOrThrow388 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_type_2");
                int columnIndexOrThrow389 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_src_2");
                int columnIndexOrThrow390 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_x_2");
                int columnIndexOrThrow391 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_y_2");
                int columnIndexOrThrow392 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_new");
                int columnIndexOrThrow393 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_hour_ten_src");
                int columnIndexOrThrow394 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_hour_src");
                int columnIndexOrThrow395 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_min_ten_src");
                int columnIndexOrThrow396 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_min_src");
                int columnIndexOrThrow397 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_kcal_progress");
                int columnIndexOrThrow398 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_progress_x");
                int columnIndexOrThrow399 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_progress_y");
                int columnIndexOrThrow400 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_progress_src");
                int columnIndexOrThrow401 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_kcal_arc_show");
                int columnIndexOrThrow402 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_arc_type");
                int columnIndexOrThrow403 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_arc_center_x");
                int columnIndexOrThrow404 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_arc_center_y");
                int columnIndexOrThrow405 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_power_arc_show");
                int columnIndexOrThrow406 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_arc_type");
                int columnIndexOrThrow407 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_arc_center_x");
                int columnIndexOrThrow408 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_arc_center_y");
                int columnIndexOrThrow409 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_timer");
                int columnIndexOrThrow410 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_timer_src");
                int columnIndexOrThrow411 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_timer_x");
                int columnIndexOrThrow412 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_timer_y");
                int columnIndexOrThrow413 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sleep");
                int columnIndexOrThrow414 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sleep_src");
                int columnIndexOrThrow415 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sleep_x");
                int columnIndexOrThrow416 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sleep_y");
                int columnIndexOrThrow417 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_bloodpressure");
                int columnIndexOrThrow418 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_bloodpressure_src");
                int columnIndexOrThrow419 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_bloodpressure_x");
                int columnIndexOrThrow420 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_bloodpressure_y");
                int columnIndexOrThrow421 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sport_record");
                int columnIndexOrThrow422 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sport_record_src");
                int columnIndexOrThrow423 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sport_record_x");
                int columnIndexOrThrow424 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sport_record_y");
                int columnIndexOrThrow425 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lottie_hierarchy");
                int columnIndexOrThrow426 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_heart_progress");
                int columnIndexOrThrow427 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_progress_x");
                int columnIndexOrThrow428 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_progress_y");
                int columnIndexOrThrow429 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_progress_src");
                int columnIndexOrThrow430 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calculator");
                int columnIndexOrThrow431 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calculator_src");
                int columnIndexOrThrow432 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calculator_x");
                int columnIndexOrThrow433 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calculator_y");
                int columnIndexOrThrow434 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_drag_3d");
                int columnIndexOrThrow435 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_HourTen_Position");
                int columnIndexOrThrow436 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_HourGe_Position");
                int columnIndexOrThrow437 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_HourTen_Position");
                int columnIndexOrThrow438 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_HourGe_Position");
                int columnIndexOrThrow439 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_HourTen_Position");
                int columnIndexOrThrow440 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_HourGe_Position");
                int columnIndexOrThrow441 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_MinTen_Position");
                int columnIndexOrThrow442 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_MinGe_Position");
                int columnIndexOrThrow443 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_MinTen_Position");
                int columnIndexOrThrow444 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_MinGe_Position");
                int columnIndexOrThrow445 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_MinTen_Position");
                int columnIndexOrThrow446 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_MinGe_Position");
                int columnIndexOrThrow447 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_day");
                int columnIndexOrThrow448 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_day_x");
                int columnIndexOrThrow449 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_day_y");
                int columnIndexOrThrow450 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_now_tem_arc_show");
                int columnIndexOrThrow451 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_arc_type");
                int columnIndexOrThrow452 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_arc_center_x");
                int columnIndexOrThrow453 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_arc_center_y");
                int columnIndexOrThrow454 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_km_progress");
                int columnIndexOrThrow455 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_progress_x");
                int columnIndexOrThrow456 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_progress_y");
                int columnIndexOrThrow457 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_progress_src");
                int columnIndexOrThrow458 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_km_arc_show");
                int columnIndexOrThrow459 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_arc_type");
                int columnIndexOrThrow460 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_arc_center_x");
                int columnIndexOrThrow461 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_arc_center_y");
                int columnIndexOrThrow462 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_rotate");
                int columnIndexOrThrow463 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_rotate_degree");
                int columnIndexOrThrow464 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_rotate");
                int columnIndexOrThrow465 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_rotate_degree");
                int columnIndexOrThrow466 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_oxygen");
                int columnIndexOrThrow467 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_src");
                int columnIndexOrThrow468 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_x");
                int columnIndexOrThrow469 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_y");
                int columnIndexOrThrow470 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_num_src");
                int columnIndexOrThrow471 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_sign_src");
                int columnIndexOrThrow472 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_show_type");
                int columnIndexOrThrow473 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_num_x");
                int columnIndexOrThrow474 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_num_y");
                int columnIndexOrThrow475 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_change_counter");
                int columnIndexOrThrow476 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src_2");
                int columnIndexOrThrow477 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src_2");
                int columnIndexOrThrow478 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src_2");
                int columnIndexOrThrow479 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src_2");
                int columnIndexOrThrow480 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src_2");
                int columnIndexOrThrow481 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src_3");
                int columnIndexOrThrow482 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src_3");
                int columnIndexOrThrow483 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src_3");
                int columnIndexOrThrow484 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src_3");
                int columnIndexOrThrow485 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src_3");
                int columnIndexOrThrow486 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src_4");
                int columnIndexOrThrow487 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src_4");
                int columnIndexOrThrow488 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src_4");
                int columnIndexOrThrow489 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src_4");
                int columnIndexOrThrow490 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src_4");
                int columnIndexOrThrow491 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_rotate");
                int columnIndexOrThrow492 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_rotate_degree");
                int columnIndexOrThrow493 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_hour");
                int columnIndexOrThrow494 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_hour_src");
                int columnIndexOrThrow495 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_hour_x");
                int columnIndexOrThrow496 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_hour_y");
                int columnIndexOrThrow497 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_min");
                int columnIndexOrThrow498 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_min_src");
                int columnIndexOrThrow499 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_min_x");
                int columnIndexOrThrow500 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_min_y");
                int columnIndexOrThrow501 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_scale");
                int columnIndexOrThrow502 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_compass_num");
                int columnIndexOrThrow503 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_src");
                int columnIndexOrThrow504 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_show_type");
                int columnIndexOrThrow505 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_x");
                int columnIndexOrThrow506 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_y");
                int columnIndexOrThrow507 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_src_prefix");
                int columnIndexOrThrow508 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_src_sign");
                int columnIndexOrThrow509 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_oxygen");
                int columnIndexOrThrow510 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_oxygen_src");
                int columnIndexOrThrow511 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_oxygen_x");
                int columnIndexOrThrow512 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_oxygen_y");
                int columnIndexOrThrow513 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calendar");
                int columnIndexOrThrow514 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calendar_src");
                int columnIndexOrThrow515 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calendar_x");
                int columnIndexOrThrow516 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calendar_y");
                int columnIndexOrThrow517 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_compass");
                int columnIndexOrThrow518 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_compass_src");
                int columnIndexOrThrow519 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_compass_x");
                int columnIndexOrThrow520 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_compass_y");
                int columnIndexOrThrow521 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_disable_scale");
                int columnIndexOrThrow522 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_chinse_time");
                int columnIndexOrThrow523 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chinse_time_src");
                int columnIndexOrThrow524 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chinse_time_x");
                int columnIndexOrThrow525 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chinse_time_y");
                int columnIndexOrThrow526 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_photo");
                int columnIndexOrThrow527 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_photo_src");
                int columnIndexOrThrow528 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_photo_x");
                int columnIndexOrThrow529 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_photo_y");
                int columnIndexOrThrow530 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_contact");
                int columnIndexOrThrow531 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_contact_src");
                int columnIndexOrThrow532 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_contact_x");
                int columnIndexOrThrow533 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_contact_y");
                int columnIndexOrThrow534 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_rotate");
                int columnIndexOrThrow535 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_rotate_degree");
                int columnIndexOrThrow536 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_power_progress");
                int columnIndexOrThrow537 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_progress_src");
                int columnIndexOrThrow538 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_progress_x");
                int columnIndexOrThrow539 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_progress_y");
                int columnIndexOrThrow540 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_src");
                int columnIndexOrThrow541 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_src_x");
                int columnIndexOrThrow542 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_src_y");
                int columnIndexOrThrow543 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_type");
                int columnIndexOrThrow544 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_keep_number_length");
                int columnIndexOrThrow545 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_keep_number_length");
                int columnIndexOrThrow546 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_keep_number_length");
                int columnIndexOrThrow547 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_rotate");
                int columnIndexOrThrow548 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_rotate_degree");
                int columnIndexOrThrow549 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_style");
                int columnIndexOrThrow550 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_style_src");
                int columnIndexOrThrow551 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_style_x");
                int columnIndexOrThrow552 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_style_y");
                int columnIndexOrThrow553 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_sec");
                int columnIndexOrThrow554 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_sec_src");
                int columnIndexOrThrow555 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_sec_x");
                int columnIndexOrThrow556 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_sec_y");
                int columnIndexOrThrow557 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_oxygen_arc_show");
                int columnIndexOrThrow558 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_arc_type");
                int columnIndexOrThrow559 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_arc_center_x");
                int columnIndexOrThrow560 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_arc_center_y");
                int columnIndexOrThrow561 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_oxygen_progress");
                int columnIndexOrThrow562 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_progress_src");
                int columnIndexOrThrow563 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_progress_x");
                int columnIndexOrThrow564 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_progress_y");
                int columnIndexOrThrow565 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_week_donts");
                int columnIndexOrThrow566 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_donts_src");
                int columnIndexOrThrow567 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_donts_x");
                int columnIndexOrThrow568 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_donts_y");
                int columnIndexOrThrow569 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_flashlight");
                int columnIndexOrThrow570 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flashlight_src");
                int columnIndexOrThrow571 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flashlight_x");
                int columnIndexOrThrow572 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flashlight_y");
                int i = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    ClockConfig clockConfig = new ClockConfig();
                    clockConfig.setPath(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                    clockConfig.setFromAssets(cursorQuery.getInt(columnIndexOrThrow2) != 0);
                    clockConfig.setId(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    clockConfig.setName(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    clockConfig.setName_en(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    clockConfig.setScreentype(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    clockConfig.setDialtype(cursorQuery.getInt(columnIndexOrThrow7));
                    clockConfig.setCoordinate_screen_width(cursorQuery.getInt(columnIndexOrThrow8));
                    clockConfig.setCoordinate_screen_height(cursorQuery.getInt(columnIndexOrThrow9));
                    clockConfig.setBg_type(cursorQuery.getInt(columnIndexOrThrow10));
                    clockConfig.setVideo(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    clockConfig.setLottie(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    int i2 = columnIndexOrThrow10;
                    int i3 = i;
                    clockConfig.setBg_animal_keep_for_last_frame(cursorQuery.getInt(i3));
                    int i4 = columnIndexOrThrow14;
                    int i5 = columnIndexOrThrow11;
                    clockConfig.setBg_count(cursorQuery.getInt(i4));
                    int i6 = columnIndexOrThrow15;
                    clockConfig.setBg_interval(cursorQuery.isNull(i6) ? null : cursorQuery.getString(i6));
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    clockConfig.setBg_is_customize(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    clockConfig.setHour_pointer_src(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                    columnIndexOrThrow15 = i6;
                    int i7 = columnIndexOrThrow18;
                    clockConfig.setHour_pointer_x(cursorQuery.getInt(i7));
                    columnIndexOrThrow18 = i7;
                    int i8 = columnIndexOrThrow19;
                    clockConfig.setHour_pointer_y(cursorQuery.getInt(i8));
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    clockConfig.setMinute_pointer_src(cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20));
                    columnIndexOrThrow19 = i8;
                    int i9 = columnIndexOrThrow21;
                    clockConfig.setMinute_pointer_x(cursorQuery.getInt(i9));
                    columnIndexOrThrow21 = i9;
                    int i10 = columnIndexOrThrow22;
                    clockConfig.setMinute_pointer_y(cursorQuery.getInt(i10));
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    clockConfig.setSecond_pointer_src(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    columnIndexOrThrow22 = i10;
                    int i11 = columnIndexOrThrow24;
                    clockConfig.setSecond_pointer_type(cursorQuery.getInt(i11));
                    columnIndexOrThrow24 = i11;
                    int i12 = columnIndexOrThrow25;
                    clockConfig.setSecond_pointer_x(cursorQuery.getInt(i12));
                    columnIndexOrThrow25 = i12;
                    int i13 = columnIndexOrThrow26;
                    clockConfig.setSecond_pointer_y(cursorQuery.getInt(i13));
                    columnIndexOrThrow26 = i13;
                    int i14 = columnIndexOrThrow27;
                    clockConfig.setSecond_pointer_animal_type(cursorQuery.getInt(i14));
                    columnIndexOrThrow28 = columnIndexOrThrow28;
                    clockConfig.setDot_src(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    columnIndexOrThrow27 = i14;
                    int i15 = columnIndexOrThrow29;
                    clockConfig.setDot_x(cursorQuery.getInt(i15));
                    columnIndexOrThrow29 = i15;
                    int i16 = columnIndexOrThrow30;
                    clockConfig.setDot_y(cursorQuery.getInt(i16));
                    columnIndexOrThrow30 = i16;
                    int i17 = columnIndexOrThrow31;
                    clockConfig.setShow_pointer_start_animation(cursorQuery.getInt(i17));
                    columnIndexOrThrow31 = i17;
                    int i18 = columnIndexOrThrow32;
                    clockConfig.setPointer_start_hour(cursorQuery.getInt(i18));
                    columnIndexOrThrow32 = i18;
                    int i19 = columnIndexOrThrow33;
                    clockConfig.setPointer_start_minute(cursorQuery.getInt(i19));
                    columnIndexOrThrow33 = i19;
                    int i20 = columnIndexOrThrow34;
                    clockConfig.setPointer_start_second(cursorQuery.getInt(i20));
                    columnIndexOrThrow35 = columnIndexOrThrow35;
                    clockConfig.setTime_hour_src(cursorQuery.isNull(columnIndexOrThrow35) ? null : cursorQuery.getString(columnIndexOrThrow35));
                    columnIndexOrThrow36 = columnIndexOrThrow36;
                    clockConfig.setTime_min_src(cursorQuery.isNull(columnIndexOrThrow36) ? null : cursorQuery.getString(columnIndexOrThrow36));
                    columnIndexOrThrow37 = columnIndexOrThrow37;
                    clockConfig.setTime_sec_src(cursorQuery.isNull(columnIndexOrThrow37) ? null : cursorQuery.getString(columnIndexOrThrow37));
                    columnIndexOrThrow38 = columnIndexOrThrow38;
                    clockConfig.setTime_splt_src(cursorQuery.isNull(columnIndexOrThrow38) ? null : cursorQuery.getString(columnIndexOrThrow38));
                    columnIndexOrThrow39 = columnIndexOrThrow39;
                    clockConfig.setTime_splt_2_src(cursorQuery.isNull(columnIndexOrThrow39) ? null : cursorQuery.getString(columnIndexOrThrow39));
                    columnIndexOrThrow34 = i20;
                    int i21 = columnIndexOrThrow40;
                    clockConfig.setTime_splt_need_jump(cursorQuery.getInt(i21));
                    columnIndexOrThrow40 = i21;
                    int i22 = columnIndexOrThrow41;
                    clockConfig.setTime_x(cursorQuery.getInt(i22));
                    columnIndexOrThrow41 = i22;
                    int i23 = columnIndexOrThrow42;
                    clockConfig.setTime_y(cursorQuery.getInt(i23));
                    columnIndexOrThrow42 = i23;
                    int i24 = columnIndexOrThrow43;
                    clockConfig.setNeed_reset_min(cursorQuery.getInt(i24));
                    columnIndexOrThrow43 = i24;
                    int i25 = columnIndexOrThrow44;
                    clockConfig.setReset_min_x(cursorQuery.getInt(i25));
                    columnIndexOrThrow44 = i25;
                    int i26 = columnIndexOrThrow45;
                    clockConfig.setReset_min_y(cursorQuery.getInt(i26));
                    columnIndexOrThrow45 = i26;
                    int i27 = columnIndexOrThrow46;
                    clockConfig.setShow_sec(cursorQuery.getInt(i27));
                    columnIndexOrThrow46 = i27;
                    int i28 = columnIndexOrThrow47;
                    clockConfig.setNeed_reset_sec(cursorQuery.getInt(i28));
                    columnIndexOrThrow47 = i28;
                    int i29 = columnIndexOrThrow48;
                    clockConfig.setReset_sec_x(cursorQuery.getInt(i29));
                    columnIndexOrThrow48 = i29;
                    int i30 = columnIndexOrThrow49;
                    clockConfig.setReset_sec_y(cursorQuery.getInt(i30));
                    columnIndexOrThrow49 = i30;
                    int i31 = columnIndexOrThrow50;
                    clockConfig.setOpen_time_arc_show(cursorQuery.getInt(i31));
                    columnIndexOrThrow50 = i31;
                    int i32 = columnIndexOrThrow51;
                    clockConfig.setTime_arc_type(cursorQuery.getInt(i32));
                    columnIndexOrThrow51 = i32;
                    int i33 = columnIndexOrThrow52;
                    clockConfig.setTime_arc_center_x(cursorQuery.getInt(i33));
                    columnIndexOrThrow52 = i33;
                    int i34 = columnIndexOrThrow53;
                    clockConfig.setTime_arc_center_y(cursorQuery.getInt(i34));
                    columnIndexOrThrow53 = i34;
                    int i35 = columnIndexOrThrow54;
                    clockConfig.setShow_am_or_pm(cursorQuery.getInt(i35));
                    int i36 = columnIndexOrThrow55;
                    clockConfig.setAm_and_pm_src(cursorQuery.isNull(i36) ? null : cursorQuery.getString(i36));
                    int i37 = columnIndexOrThrow56;
                    clockConfig.setAm_or_pm_x(cursorQuery.getInt(i37));
                    columnIndexOrThrow56 = i37;
                    int i38 = columnIndexOrThrow57;
                    clockConfig.setAm_or_pm_y(cursorQuery.getInt(i38));
                    columnIndexOrThrow57 = i38;
                    int i39 = columnIndexOrThrow58;
                    clockConfig.setShow_ampm_placeholer(cursorQuery.getInt(i39));
                    columnIndexOrThrow58 = i39;
                    int i40 = columnIndexOrThrow59;
                    clockConfig.setShow_digital_start_animation(cursorQuery.getInt(i40));
                    columnIndexOrThrow59 = i40;
                    int i41 = columnIndexOrThrow60;
                    clockConfig.setDigital_start_hour(cursorQuery.getInt(i41));
                    columnIndexOrThrow60 = i41;
                    int i42 = columnIndexOrThrow61;
                    clockConfig.setDigital_start_minute(cursorQuery.getInt(i42));
                    columnIndexOrThrow61 = i42;
                    int i43 = columnIndexOrThrow62;
                    clockConfig.setDigital_start_second(cursorQuery.getInt(i43));
                    int i44 = columnIndexOrThrow63;
                    clockConfig.setDate_src(cursorQuery.isNull(i44) ? null : cursorQuery.getString(i44));
                    int i45 = columnIndexOrThrow64;
                    clockConfig.setDate_x(cursorQuery.getInt(i45));
                    columnIndexOrThrow64 = i45;
                    int i46 = columnIndexOrThrow65;
                    clockConfig.setDate_y(cursorQuery.getInt(i46));
                    columnIndexOrThrow65 = i46;
                    int i47 = columnIndexOrThrow66;
                    clockConfig.setOpen_date_arc_show(cursorQuery.getInt(i47));
                    columnIndexOrThrow66 = i47;
                    int i48 = columnIndexOrThrow67;
                    clockConfig.setDate_arc_type(cursorQuery.getInt(i48));
                    columnIndexOrThrow67 = i48;
                    int i49 = columnIndexOrThrow68;
                    clockConfig.setDate_arc_center_x(cursorQuery.getInt(i49));
                    columnIndexOrThrow68 = i49;
                    int i50 = columnIndexOrThrow69;
                    clockConfig.setDate_arc_center_y(cursorQuery.getInt(i50));
                    columnIndexOrThrow70 = columnIndexOrThrow70;
                    clockConfig.setDate_year_splt_src(cursorQuery.isNull(columnIndexOrThrow70) ? null : cursorQuery.getString(columnIndexOrThrow70));
                    columnIndexOrThrow71 = columnIndexOrThrow71;
                    clockConfig.setDate_month_splt_src(cursorQuery.isNull(columnIndexOrThrow71) ? null : cursorQuery.getString(columnIndexOrThrow71));
                    columnIndexOrThrow72 = columnIndexOrThrow72;
                    clockConfig.setDate_day_splt_src(cursorQuery.isNull(columnIndexOrThrow72) ? null : cursorQuery.getString(columnIndexOrThrow72));
                    columnIndexOrThrow69 = i50;
                    int i51 = columnIndexOrThrow73;
                    clockConfig.setShow_year(cursorQuery.getInt(i51));
                    columnIndexOrThrow73 = i51;
                    int i52 = columnIndexOrThrow74;
                    clockConfig.setYear_digits_type(cursorQuery.getInt(i52));
                    columnIndexOrThrow74 = i52;
                    int i53 = columnIndexOrThrow75;
                    clockConfig.setShow_month(cursorQuery.getInt(i53));
                    columnIndexOrThrow75 = i53;
                    int i54 = columnIndexOrThrow76;
                    clockConfig.setMonth_type(cursorQuery.getInt(i54));
                    columnIndexOrThrow77 = columnIndexOrThrow77;
                    clockConfig.setMonth_src(cursorQuery.isNull(columnIndexOrThrow77) ? null : cursorQuery.getString(columnIndexOrThrow77));
                    columnIndexOrThrow76 = i54;
                    int i55 = columnIndexOrThrow78;
                    clockConfig.setNeed_reset_month(cursorQuery.getInt(i55));
                    int i56 = columnIndexOrThrow79;
                    clockConfig.setData_month_num(cursorQuery.isNull(i56) ? null : cursorQuery.getString(i56));
                    int i57 = columnIndexOrThrow80;
                    clockConfig.setMonth_x(cursorQuery.getInt(i57));
                    columnIndexOrThrow80 = i57;
                    int i58 = columnIndexOrThrow81;
                    clockConfig.setMonth_y(cursorQuery.getInt(i58));
                    columnIndexOrThrow81 = i58;
                    int i59 = columnIndexOrThrow82;
                    clockConfig.setShow_day(cursorQuery.getInt(i59));
                    columnIndexOrThrow82 = i59;
                    int i60 = columnIndexOrThrow83;
                    clockConfig.setNeed_reset_day(cursorQuery.getInt(i60));
                    columnIndexOrThrow84 = columnIndexOrThrow84;
                    clockConfig.setData_day_num(cursorQuery.isNull(columnIndexOrThrow84) ? null : cursorQuery.getString(columnIndexOrThrow84));
                    columnIndexOrThrow83 = i60;
                    int i61 = columnIndexOrThrow85;
                    clockConfig.setDay_x(cursorQuery.getInt(i61));
                    columnIndexOrThrow85 = i61;
                    int i62 = columnIndexOrThrow86;
                    clockConfig.setDay_y(cursorQuery.getInt(i62));
                    columnIndexOrThrow87 = columnIndexOrThrow87;
                    clockConfig.setDay_src(cursorQuery.isNull(columnIndexOrThrow87) ? null : cursorQuery.getString(columnIndexOrThrow87));
                    columnIndexOrThrow86 = i62;
                    int i63 = columnIndexOrThrow88;
                    clockConfig.setDay_type(cursorQuery.getInt(i63));
                    int i64 = columnIndexOrThrow89;
                    clockConfig.setWeek_src(cursorQuery.isNull(i64) ? null : cursorQuery.getString(i64));
                    columnIndexOrThrow90 = columnIndexOrThrow90;
                    clockConfig.setWeek_num_src(cursorQuery.isNull(columnIndexOrThrow90) ? null : cursorQuery.getString(columnIndexOrThrow90));
                    int i65 = columnIndexOrThrow91;
                    clockConfig.setWeek_x(cursorQuery.getInt(i65));
                    columnIndexOrThrow91 = i65;
                    int i66 = columnIndexOrThrow92;
                    clockConfig.setWeek_y(cursorQuery.getInt(i66));
                    columnIndexOrThrow92 = i66;
                    int i67 = columnIndexOrThrow93;
                    clockConfig.setShow_power(cursorQuery.getInt(i67));
                    int i68 = columnIndexOrThrow94;
                    clockConfig.setNormal_0_src(cursorQuery.isNull(i68) ? null : cursorQuery.getString(i68));
                    columnIndexOrThrow95 = columnIndexOrThrow95;
                    clockConfig.setNormal_1_src(cursorQuery.isNull(columnIndexOrThrow95) ? null : cursorQuery.getString(columnIndexOrThrow95));
                    columnIndexOrThrow96 = columnIndexOrThrow96;
                    clockConfig.setNormal_2_src(cursorQuery.isNull(columnIndexOrThrow96) ? null : cursorQuery.getString(columnIndexOrThrow96));
                    columnIndexOrThrow97 = columnIndexOrThrow97;
                    clockConfig.setNormal_3_src(cursorQuery.isNull(columnIndexOrThrow97) ? null : cursorQuery.getString(columnIndexOrThrow97));
                    columnIndexOrThrow98 = columnIndexOrThrow98;
                    clockConfig.setNormal_4_src(cursorQuery.isNull(columnIndexOrThrow98) ? null : cursorQuery.getString(columnIndexOrThrow98));
                    columnIndexOrThrow99 = columnIndexOrThrow99;
                    clockConfig.setNormal_5_src(cursorQuery.isNull(columnIndexOrThrow99) ? null : cursorQuery.getString(columnIndexOrThrow99));
                    columnIndexOrThrow100 = columnIndexOrThrow100;
                    clockConfig.setNormal_6_src(cursorQuery.isNull(columnIndexOrThrow100) ? null : cursorQuery.getString(columnIndexOrThrow100));
                    columnIndexOrThrow101 = columnIndexOrThrow101;
                    clockConfig.setNormal_7_src(cursorQuery.isNull(columnIndexOrThrow101) ? null : cursorQuery.getString(columnIndexOrThrow101));
                    columnIndexOrThrow102 = columnIndexOrThrow102;
                    clockConfig.setNormal_8_src(cursorQuery.isNull(columnIndexOrThrow102) ? null : cursorQuery.getString(columnIndexOrThrow102));
                    columnIndexOrThrow103 = columnIndexOrThrow103;
                    clockConfig.setNormal_9_src(cursorQuery.isNull(columnIndexOrThrow103) ? null : cursorQuery.getString(columnIndexOrThrow103));
                    columnIndexOrThrow104 = columnIndexOrThrow104;
                    clockConfig.setNormal_10_src(cursorQuery.isNull(columnIndexOrThrow104) ? null : cursorQuery.getString(columnIndexOrThrow104));
                    int i69 = columnIndexOrThrow105;
                    clockConfig.setPower_x(cursorQuery.getInt(i69));
                    columnIndexOrThrow105 = i69;
                    int i70 = columnIndexOrThrow106;
                    clockConfig.setPower_y(cursorQuery.getInt(i70));
                    columnIndexOrThrow106 = i70;
                    int i71 = columnIndexOrThrow107;
                    clockConfig.setShow_charge(cursorQuery.getInt(i71));
                    int i72 = columnIndexOrThrow108;
                    clockConfig.setCharge_0_src(cursorQuery.isNull(i72) ? null : cursorQuery.getString(i72));
                    columnIndexOrThrow109 = columnIndexOrThrow109;
                    clockConfig.setCharge_1_src(cursorQuery.isNull(columnIndexOrThrow109) ? null : cursorQuery.getString(columnIndexOrThrow109));
                    columnIndexOrThrow110 = columnIndexOrThrow110;
                    clockConfig.setCharge_2_src(cursorQuery.isNull(columnIndexOrThrow110) ? null : cursorQuery.getString(columnIndexOrThrow110));
                    columnIndexOrThrow111 = columnIndexOrThrow111;
                    clockConfig.setCharge_3_src(cursorQuery.isNull(columnIndexOrThrow111) ? null : cursorQuery.getString(columnIndexOrThrow111));
                    columnIndexOrThrow112 = columnIndexOrThrow112;
                    clockConfig.setCharge_4_src(cursorQuery.isNull(columnIndexOrThrow112) ? null : cursorQuery.getString(columnIndexOrThrow112));
                    columnIndexOrThrow113 = columnIndexOrThrow113;
                    clockConfig.setCharge_5_src(cursorQuery.isNull(columnIndexOrThrow113) ? null : cursorQuery.getString(columnIndexOrThrow113));
                    columnIndexOrThrow114 = columnIndexOrThrow114;
                    clockConfig.setCharge_6_src(cursorQuery.isNull(columnIndexOrThrow114) ? null : cursorQuery.getString(columnIndexOrThrow114));
                    columnIndexOrThrow115 = columnIndexOrThrow115;
                    clockConfig.setCharge_7_src(cursorQuery.isNull(columnIndexOrThrow115) ? null : cursorQuery.getString(columnIndexOrThrow115));
                    columnIndexOrThrow116 = columnIndexOrThrow116;
                    clockConfig.setCharge_8_src(cursorQuery.isNull(columnIndexOrThrow116) ? null : cursorQuery.getString(columnIndexOrThrow116));
                    columnIndexOrThrow117 = columnIndexOrThrow117;
                    clockConfig.setCharge_9_src(cursorQuery.isNull(columnIndexOrThrow117) ? null : cursorQuery.getString(columnIndexOrThrow117));
                    columnIndexOrThrow118 = columnIndexOrThrow118;
                    clockConfig.setCharge_10_src(cursorQuery.isNull(columnIndexOrThrow118) ? null : cursorQuery.getString(columnIndexOrThrow118));
                    int i73 = columnIndexOrThrow119;
                    clockConfig.setShow_power_num(cursorQuery.getInt(i73));
                    int i74 = columnIndexOrThrow120;
                    clockConfig.setPower_num_src(cursorQuery.isNull(i74) ? null : cursorQuery.getString(i74));
                    columnIndexOrThrow121 = columnIndexOrThrow121;
                    clockConfig.setPower_sign_src(cursorQuery.isNull(columnIndexOrThrow121) ? null : cursorQuery.getString(columnIndexOrThrow121));
                    int i75 = columnIndexOrThrow122;
                    clockConfig.setPower_show_type(cursorQuery.getInt(i75));
                    columnIndexOrThrow122 = i75;
                    int i76 = columnIndexOrThrow123;
                    clockConfig.setPower_num_x(cursorQuery.getInt(i76));
                    columnIndexOrThrow123 = i76;
                    int i77 = columnIndexOrThrow124;
                    clockConfig.setPower_num_y(cursorQuery.getInt(i77));
                    columnIndexOrThrow124 = i77;
                    int i78 = columnIndexOrThrow125;
                    clockConfig.setShow_action(cursorQuery.getInt(i78));
                    columnIndexOrThrow125 = i78;
                    int i79 = columnIndexOrThrow126;
                    clockConfig.setOpen_action_1(cursorQuery.getInt(i79));
                    columnIndexOrThrow126 = i79;
                    int i80 = columnIndexOrThrow127;
                    clockConfig.setAction_1_count(cursorQuery.getInt(i80));
                    columnIndexOrThrow127 = i80;
                    int i81 = columnIndexOrThrow128;
                    clockConfig.setAction_1_x(cursorQuery.getInt(i81));
                    columnIndexOrThrow128 = i81;
                    int i82 = columnIndexOrThrow129;
                    clockConfig.setAction_1_y(cursorQuery.getInt(i82));
                    columnIndexOrThrow129 = i82;
                    int i83 = columnIndexOrThrow130;
                    clockConfig.setOpen_action_2(cursorQuery.getInt(i83));
                    columnIndexOrThrow130 = i83;
                    int i84 = columnIndexOrThrow131;
                    clockConfig.setAction_2_count(cursorQuery.getInt(i84));
                    columnIndexOrThrow131 = i84;
                    int i85 = columnIndexOrThrow132;
                    clockConfig.setAction_2_x(cursorQuery.getInt(i85));
                    columnIndexOrThrow132 = i85;
                    int i86 = columnIndexOrThrow133;
                    clockConfig.setAction_2_y(cursorQuery.getInt(i86));
                    columnIndexOrThrow133 = i86;
                    int i87 = columnIndexOrThrow134;
                    clockConfig.setOpen_action_3(cursorQuery.getInt(i87));
                    columnIndexOrThrow134 = i87;
                    int i88 = columnIndexOrThrow135;
                    clockConfig.setAction_3_count(cursorQuery.getInt(i88));
                    columnIndexOrThrow135 = i88;
                    int i89 = columnIndexOrThrow136;
                    clockConfig.setAction_3_x(cursorQuery.getInt(i89));
                    columnIndexOrThrow136 = i89;
                    int i90 = columnIndexOrThrow137;
                    clockConfig.setAction_3_y(cursorQuery.getInt(i90));
                    columnIndexOrThrow137 = i90;
                    int i91 = columnIndexOrThrow138;
                    clockConfig.setAction_interval(cursorQuery.getInt(i91));
                    int i92 = columnIndexOrThrow139;
                    clockConfig.setShow_overall_animation(cursorQuery.isNull(i92) ? null : cursorQuery.getString(i92));
                    int i93 = columnIndexOrThrow140;
                    clockConfig.setOverall_animation_x(cursorQuery.getInt(i93));
                    columnIndexOrThrow140 = i93;
                    int i94 = columnIndexOrThrow141;
                    clockConfig.setOverall_animation_y(cursorQuery.getInt(i94));
                    columnIndexOrThrow142 = columnIndexOrThrow142;
                    clockConfig.setOpen_click_1(cursorQuery.isNull(columnIndexOrThrow142) ? null : cursorQuery.getString(columnIndexOrThrow142));
                    columnIndexOrThrow141 = i94;
                    int i95 = columnIndexOrThrow143;
                    clockConfig.setClick_1_x(cursorQuery.getInt(i95));
                    columnIndexOrThrow143 = i95;
                    int i96 = columnIndexOrThrow144;
                    clockConfig.setClick_1_y(cursorQuery.getInt(i96));
                    columnIndexOrThrow145 = columnIndexOrThrow145;
                    clockConfig.setClick_1_width(cursorQuery.isNull(columnIndexOrThrow145) ? null : cursorQuery.getString(columnIndexOrThrow145));
                    columnIndexOrThrow146 = columnIndexOrThrow146;
                    clockConfig.setClick_1_height(cursorQuery.isNull(columnIndexOrThrow146) ? null : cursorQuery.getString(columnIndexOrThrow146));
                    columnIndexOrThrow147 = columnIndexOrThrow147;
                    clockConfig.setOpen_click_2(cursorQuery.isNull(columnIndexOrThrow147) ? null : cursorQuery.getString(columnIndexOrThrow147));
                    columnIndexOrThrow144 = i96;
                    int i97 = columnIndexOrThrow148;
                    clockConfig.setClick_2_x(cursorQuery.getInt(i97));
                    columnIndexOrThrow148 = i97;
                    int i98 = columnIndexOrThrow149;
                    clockConfig.setClick_2_y(cursorQuery.getInt(i98));
                    columnIndexOrThrow150 = columnIndexOrThrow150;
                    clockConfig.setClick_2_width(cursorQuery.isNull(columnIndexOrThrow150) ? null : cursorQuery.getString(columnIndexOrThrow150));
                    columnIndexOrThrow151 = columnIndexOrThrow151;
                    clockConfig.setClick_2_height(cursorQuery.isNull(columnIndexOrThrow151) ? null : cursorQuery.getString(columnIndexOrThrow151));
                    columnIndexOrThrow152 = columnIndexOrThrow152;
                    clockConfig.setOpen_click_3(cursorQuery.isNull(columnIndexOrThrow152) ? null : cursorQuery.getString(columnIndexOrThrow152));
                    columnIndexOrThrow149 = i98;
                    int i99 = columnIndexOrThrow153;
                    clockConfig.setClick_3_x(cursorQuery.getInt(i99));
                    columnIndexOrThrow153 = i99;
                    int i100 = columnIndexOrThrow154;
                    clockConfig.setClick_3_y(cursorQuery.getInt(i100));
                    columnIndexOrThrow155 = columnIndexOrThrow155;
                    clockConfig.setClick_3_width(cursorQuery.isNull(columnIndexOrThrow155) ? null : cursorQuery.getString(columnIndexOrThrow155));
                    columnIndexOrThrow156 = columnIndexOrThrow156;
                    clockConfig.setClick_3_height(cursorQuery.isNull(columnIndexOrThrow156) ? null : cursorQuery.getString(columnIndexOrThrow156));
                    columnIndexOrThrow157 = columnIndexOrThrow157;
                    clockConfig.setOpen_click_4(cursorQuery.isNull(columnIndexOrThrow157) ? null : cursorQuery.getString(columnIndexOrThrow157));
                    columnIndexOrThrow154 = i100;
                    int i101 = columnIndexOrThrow158;
                    clockConfig.setClick_4_x(cursorQuery.getInt(i101));
                    columnIndexOrThrow158 = i101;
                    int i102 = columnIndexOrThrow159;
                    clockConfig.setClick_4_y(cursorQuery.getInt(i102));
                    columnIndexOrThrow160 = columnIndexOrThrow160;
                    clockConfig.setClick_4_width(cursorQuery.isNull(columnIndexOrThrow160) ? null : cursorQuery.getString(columnIndexOrThrow160));
                    columnIndexOrThrow161 = columnIndexOrThrow161;
                    clockConfig.setClick_4_height(cursorQuery.isNull(columnIndexOrThrow161) ? null : cursorQuery.getString(columnIndexOrThrow161));
                    columnIndexOrThrow159 = i102;
                    int i103 = columnIndexOrThrow162;
                    clockConfig.setShow_lunar(cursorQuery.getInt(i103));
                    int i104 = columnIndexOrThrow163;
                    clockConfig.setLunar_src(cursorQuery.isNull(i104) ? null : cursorQuery.getString(i104));
                    int i105 = columnIndexOrThrow164;
                    clockConfig.setLunar_x(cursorQuery.getInt(i105));
                    columnIndexOrThrow164 = i105;
                    int i106 = columnIndexOrThrow165;
                    clockConfig.setLunar_y(cursorQuery.getInt(i106));
                    columnIndexOrThrow165 = i106;
                    int i107 = columnIndexOrThrow166;
                    clockConfig.setShow_heart(cursorQuery.getInt(i107));
                    int i108 = columnIndexOrThrow167;
                    clockConfig.setHeart_src(cursorQuery.isNull(i108) ? null : cursorQuery.getString(i108));
                    int i109 = columnIndexOrThrow168;
                    clockConfig.setHeart_x(cursorQuery.getInt(i109));
                    columnIndexOrThrow168 = i109;
                    int i110 = columnIndexOrThrow169;
                    clockConfig.setHeart_y(cursorQuery.getInt(i110));
                    columnIndexOrThrow170 = columnIndexOrThrow170;
                    clockConfig.setHeart_num_src(cursorQuery.isNull(columnIndexOrThrow170) ? null : cursorQuery.getString(columnIndexOrThrow170));
                    columnIndexOrThrow171 = columnIndexOrThrow171;
                    clockConfig.setHeart_num_type(cursorQuery.isNull(columnIndexOrThrow171) ? null : cursorQuery.getString(columnIndexOrThrow171));
                    columnIndexOrThrow172 = columnIndexOrThrow172;
                    clockConfig.setHeart_end_src(cursorQuery.isNull(columnIndexOrThrow172) ? null : cursorQuery.getString(columnIndexOrThrow172));
                    columnIndexOrThrow169 = i110;
                    int i111 = columnIndexOrThrow173;
                    clockConfig.setHeart_show_type(cursorQuery.getInt(i111));
                    columnIndexOrThrow173 = i111;
                    int i112 = columnIndexOrThrow174;
                    clockConfig.setHeart_num_x(cursorQuery.getInt(i112));
                    columnIndexOrThrow174 = i112;
                    int i113 = columnIndexOrThrow175;
                    clockConfig.setHeart_num_y(cursorQuery.getInt(i113));
                    columnIndexOrThrow175 = i113;
                    int i114 = columnIndexOrThrow176;
                    clockConfig.setOpen_heart_arc_show(cursorQuery.getInt(i114));
                    columnIndexOrThrow176 = i114;
                    int i115 = columnIndexOrThrow177;
                    clockConfig.setHeart_arc_type(cursorQuery.getInt(i115));
                    columnIndexOrThrow177 = i115;
                    int i116 = columnIndexOrThrow178;
                    clockConfig.setHeart_arc_center_x(cursorQuery.getInt(i116));
                    columnIndexOrThrow178 = i116;
                    int i117 = columnIndexOrThrow179;
                    clockConfig.setHeart_arc_center_y(cursorQuery.getInt(i117));
                    int i118 = columnIndexOrThrow180;
                    clockConfig.setShow_pressure(cursorQuery.isNull(i118) ? null : cursorQuery.getString(i118));
                    columnIndexOrThrow181 = columnIndexOrThrow181;
                    clockConfig.setPressure_src(cursorQuery.isNull(columnIndexOrThrow181) ? null : cursorQuery.getString(columnIndexOrThrow181));
                    int i119 = columnIndexOrThrow182;
                    clockConfig.setPressure_x(cursorQuery.getInt(i119));
                    columnIndexOrThrow182 = i119;
                    int i120 = columnIndexOrThrow183;
                    clockConfig.setPressure_y(cursorQuery.getInt(i120));
                    columnIndexOrThrow184 = columnIndexOrThrow184;
                    clockConfig.setPressure_num_src(cursorQuery.isNull(columnIndexOrThrow184) ? null : cursorQuery.getString(columnIndexOrThrow184));
                    columnIndexOrThrow183 = i120;
                    int i121 = columnIndexOrThrow185;
                    clockConfig.setPressure_num_x(cursorQuery.getInt(i121));
                    columnIndexOrThrow185 = i121;
                    int i122 = columnIndexOrThrow186;
                    clockConfig.setPressure_num_y(cursorQuery.getInt(i122));
                    columnIndexOrThrow187 = columnIndexOrThrow187;
                    clockConfig.setPressure_show_type(cursorQuery.isNull(columnIndexOrThrow187) ? null : cursorQuery.getString(columnIndexOrThrow187));
                    columnIndexOrThrow188 = columnIndexOrThrow188;
                    clockConfig.setPressure_splt_src(cursorQuery.isNull(columnIndexOrThrow188) ? null : cursorQuery.getString(columnIndexOrThrow188));
                    columnIndexOrThrow186 = i122;
                    int i123 = columnIndexOrThrow189;
                    clockConfig.setShow_step(cursorQuery.getInt(i123));
                    int i124 = columnIndexOrThrow190;
                    clockConfig.setStep_src(cursorQuery.isNull(i124) ? null : cursorQuery.getString(i124));
                    int i125 = columnIndexOrThrow191;
                    clockConfig.setStep_follow_num(cursorQuery.getInt(i125));
                    columnIndexOrThrow191 = i125;
                    int i126 = columnIndexOrThrow192;
                    clockConfig.setStep_x(cursorQuery.getInt(i126));
                    columnIndexOrThrow192 = i126;
                    int i127 = columnIndexOrThrow193;
                    clockConfig.setStep_y(cursorQuery.getInt(i127));
                    int i128 = columnIndexOrThrow194;
                    clockConfig.setStep_num_src(cursorQuery.isNull(i128) ? null : cursorQuery.getString(i128));
                    int i129 = columnIndexOrThrow195;
                    clockConfig.setStep_num_type(cursorQuery.getInt(i129));
                    columnIndexOrThrow195 = i129;
                    int i130 = columnIndexOrThrow196;
                    clockConfig.setStep_show_type(cursorQuery.getInt(i130));
                    columnIndexOrThrow196 = i130;
                    int i131 = columnIndexOrThrow197;
                    clockConfig.setStep_num_x(cursorQuery.getInt(i131));
                    columnIndexOrThrow197 = i131;
                    int i132 = columnIndexOrThrow198;
                    clockConfig.setStep_num_y(cursorQuery.getInt(i132));
                    columnIndexOrThrow199 = columnIndexOrThrow199;
                    clockConfig.setStep_end_src(cursorQuery.isNull(columnIndexOrThrow199) ? null : cursorQuery.getString(columnIndexOrThrow199));
                    columnIndexOrThrow198 = i132;
                    int i133 = columnIndexOrThrow200;
                    clockConfig.setShow_step_progress(cursorQuery.getInt(i133));
                    columnIndexOrThrow200 = i133;
                    int i134 = columnIndexOrThrow201;
                    clockConfig.setStep_progress_x(cursorQuery.getInt(i134));
                    columnIndexOrThrow201 = i134;
                    int i135 = columnIndexOrThrow202;
                    clockConfig.setStep_progress_y(cursorQuery.getInt(i135));
                    int i136 = columnIndexOrThrow203;
                    clockConfig.setStep_progress_src(cursorQuery.isNull(i136) ? null : cursorQuery.getString(i136));
                    int i137 = columnIndexOrThrow204;
                    clockConfig.setOpen_step_arc_show(cursorQuery.getInt(i137));
                    columnIndexOrThrow204 = i137;
                    int i138 = columnIndexOrThrow205;
                    clockConfig.setStep_arc_type(cursorQuery.getInt(i138));
                    columnIndexOrThrow205 = i138;
                    int i139 = columnIndexOrThrow206;
                    clockConfig.setStep_arc_center_x(cursorQuery.getInt(i139));
                    columnIndexOrThrow206 = i139;
                    int i140 = columnIndexOrThrow207;
                    clockConfig.setStep_arc_center_y(cursorQuery.getInt(i140));
                    columnIndexOrThrow207 = i140;
                    int i141 = columnIndexOrThrow208;
                    clockConfig.setShow_kcal(cursorQuery.getInt(i141));
                    int i142 = columnIndexOrThrow209;
                    clockConfig.setKcal_src(cursorQuery.isNull(i142) ? null : cursorQuery.getString(i142));
                    int i143 = columnIndexOrThrow210;
                    clockConfig.setKcal_x(cursorQuery.getInt(i143));
                    columnIndexOrThrow210 = i143;
                    int i144 = columnIndexOrThrow211;
                    clockConfig.setKcal_y(cursorQuery.getInt(i144));
                    columnIndexOrThrow212 = columnIndexOrThrow212;
                    clockConfig.setKcal_num_src(cursorQuery.isNull(columnIndexOrThrow212) ? null : cursorQuery.getString(columnIndexOrThrow212));
                    columnIndexOrThrow211 = i144;
                    int i145 = columnIndexOrThrow213;
                    clockConfig.setKcal_num_type(cursorQuery.getInt(i145));
                    columnIndexOrThrow213 = i145;
                    int i146 = columnIndexOrThrow214;
                    clockConfig.setKcal_show_type(cursorQuery.getInt(i146));
                    columnIndexOrThrow214 = i146;
                    int i147 = columnIndexOrThrow215;
                    clockConfig.setKcal_num_x(cursorQuery.getInt(i147));
                    columnIndexOrThrow215 = i147;
                    int i148 = columnIndexOrThrow216;
                    clockConfig.setKcal_num_y(cursorQuery.getInt(i148));
                    columnIndexOrThrow217 = columnIndexOrThrow217;
                    clockConfig.setKcal_end_src(cursorQuery.isNull(columnIndexOrThrow217) ? null : cursorQuery.getString(columnIndexOrThrow217));
                    columnIndexOrThrow218 = columnIndexOrThrow218;
                    clockConfig.setShow_km(cursorQuery.isNull(columnIndexOrThrow218) ? null : cursorQuery.getString(columnIndexOrThrow218));
                    columnIndexOrThrow219 = columnIndexOrThrow219;
                    clockConfig.setKm_src(cursorQuery.isNull(columnIndexOrThrow219) ? null : cursorQuery.getString(columnIndexOrThrow219));
                    columnIndexOrThrow216 = i148;
                    int i149 = columnIndexOrThrow220;
                    clockConfig.setKm_x(cursorQuery.getInt(i149));
                    columnIndexOrThrow220 = i149;
                    int i150 = columnIndexOrThrow221;
                    clockConfig.setKm_y(cursorQuery.getInt(i150));
                    columnIndexOrThrow222 = columnIndexOrThrow222;
                    clockConfig.setKm_num_src(cursorQuery.isNull(columnIndexOrThrow222) ? null : cursorQuery.getString(columnIndexOrThrow222));
                    columnIndexOrThrow223 = columnIndexOrThrow223;
                    clockConfig.setKm_comma_src(cursorQuery.isNull(columnIndexOrThrow223) ? null : cursorQuery.getString(columnIndexOrThrow223));
                    columnIndexOrThrow224 = columnIndexOrThrow224;
                    clockConfig.setKm_num_type(cursorQuery.isNull(columnIndexOrThrow224) ? null : cursorQuery.getString(columnIndexOrThrow224));
                    columnIndexOrThrow221 = i150;
                    int i151 = columnIndexOrThrow225;
                    clockConfig.setKm_show_type(cursorQuery.getInt(i151));
                    columnIndexOrThrow225 = i151;
                    int i152 = columnIndexOrThrow226;
                    clockConfig.setKm_num_x(cursorQuery.getInt(i152));
                    columnIndexOrThrow226 = i152;
                    int i153 = columnIndexOrThrow227;
                    clockConfig.setKm_num_y(cursorQuery.getInt(i153));
                    int i154 = columnIndexOrThrow228;
                    clockConfig.setKm_end_src(cursorQuery.isNull(i154) ? null : cursorQuery.getString(i154));
                    columnIndexOrThrow229 = columnIndexOrThrow229;
                    clockConfig.setShow_weather(cursorQuery.isNull(columnIndexOrThrow229) ? null : cursorQuery.getString(columnIndexOrThrow229));
                    columnIndexOrThrow230 = columnIndexOrThrow230;
                    clockConfig.setShow_temperature(cursorQuery.isNull(columnIndexOrThrow230) ? null : cursorQuery.getString(columnIndexOrThrow230));
                    int i155 = columnIndexOrThrow231;
                    clockConfig.setTemperature_show_type(cursorQuery.getInt(i155));
                    columnIndexOrThrow231 = i155;
                    int i156 = columnIndexOrThrow232;
                    clockConfig.setTemperature_num_type(cursorQuery.getInt(i156));
                    columnIndexOrThrow232 = i156;
                    int i157 = columnIndexOrThrow233;
                    clockConfig.setTemperature_x(cursorQuery.getInt(i157));
                    columnIndexOrThrow233 = i157;
                    int i158 = columnIndexOrThrow234;
                    clockConfig.setTemperature_y(cursorQuery.getInt(i158));
                    columnIndexOrThrow234 = i158;
                    int i159 = columnIndexOrThrow235;
                    clockConfig.setTemperature_x_2(cursorQuery.getInt(i159));
                    columnIndexOrThrow235 = i159;
                    int i160 = columnIndexOrThrow236;
                    clockConfig.setTemperature_y_2(cursorQuery.getInt(i160));
                    columnIndexOrThrow237 = columnIndexOrThrow237;
                    clockConfig.setShow_now_tem(cursorQuery.isNull(columnIndexOrThrow237) ? null : cursorQuery.getString(columnIndexOrThrow237));
                    columnIndexOrThrow238 = columnIndexOrThrow238;
                    clockConfig.setNow_tem_show_type(cursorQuery.isNull(columnIndexOrThrow238) ? null : cursorQuery.getString(columnIndexOrThrow238));
                    columnIndexOrThrow236 = i160;
                    int i161 = columnIndexOrThrow239;
                    clockConfig.setNow_tem_x(cursorQuery.getInt(i161));
                    columnIndexOrThrow239 = i161;
                    int i162 = columnIndexOrThrow240;
                    clockConfig.setNow_tem_y(cursorQuery.getInt(i162));
                    columnIndexOrThrow241 = columnIndexOrThrow241;
                    clockConfig.setTemperature_num_src(cursorQuery.isNull(columnIndexOrThrow241) ? null : cursorQuery.getString(columnIndexOrThrow241));
                    columnIndexOrThrow242 = columnIndexOrThrow242;
                    clockConfig.setTemperature_sub_src(cursorQuery.isNull(columnIndexOrThrow242) ? null : cursorQuery.getString(columnIndexOrThrow242));
                    columnIndexOrThrow243 = columnIndexOrThrow243;
                    clockConfig.setTemperature_sign_src(cursorQuery.isNull(columnIndexOrThrow243) ? null : cursorQuery.getString(columnIndexOrThrow243));
                    columnIndexOrThrow244 = columnIndexOrThrow244;
                    clockConfig.setTemperature_splt_src(cursorQuery.isNull(columnIndexOrThrow244) ? null : cursorQuery.getString(columnIndexOrThrow244));
                    columnIndexOrThrow245 = columnIndexOrThrow245;
                    clockConfig.setShow_diagram(cursorQuery.isNull(columnIndexOrThrow245) ? null : cursorQuery.getString(columnIndexOrThrow245));
                    columnIndexOrThrow240 = i162;
                    int i163 = columnIndexOrThrow246;
                    clockConfig.setDiagram_x(cursorQuery.getInt(i163));
                    columnIndexOrThrow246 = i163;
                    int i164 = columnIndexOrThrow247;
                    clockConfig.setDiagram_y(cursorQuery.getInt(i164));
                    columnIndexOrThrow247 = i164;
                    int i165 = columnIndexOrThrow248;
                    clockConfig.setShowsignal(cursorQuery.getInt(i165));
                    columnIndexOrThrow248 = i165;
                    int i166 = columnIndexOrThrow249;
                    clockConfig.setShow_signal(cursorQuery.getInt(i166));
                    columnIndexOrThrow250 = columnIndexOrThrow250;
                    clockConfig.setSignal_src(cursorQuery.isNull(columnIndexOrThrow250) ? null : cursorQuery.getString(columnIndexOrThrow250));
                    columnIndexOrThrow249 = i166;
                    int i167 = columnIndexOrThrow251;
                    clockConfig.setSignal_x(cursorQuery.getInt(i167));
                    columnIndexOrThrow251 = i167;
                    int i168 = columnIndexOrThrow252;
                    clockConfig.setSignal_y(cursorQuery.getInt(i168));
                    columnIndexOrThrow252 = i168;
                    int i169 = columnIndexOrThrow253;
                    clockConfig.setShow_user_name(cursorQuery.isNull(i169) ? null : cursorQuery.getString(i169));
                    columnIndexOrThrow253 = i169;
                    int i170 = columnIndexOrThrow254;
                    clockConfig.setName_show_type(cursorQuery.isNull(i170) ? null : cursorQuery.getString(i170));
                    columnIndexOrThrow254 = i170;
                    int i171 = columnIndexOrThrow255;
                    clockConfig.setName_x(cursorQuery.getInt(i171));
                    columnIndexOrThrow255 = i171;
                    int i172 = columnIndexOrThrow256;
                    clockConfig.setName_y(cursorQuery.getInt(i172));
                    columnIndexOrThrow256 = i172;
                    int i173 = columnIndexOrThrow257;
                    clockConfig.setShow_operator(cursorQuery.isNull(i173) ? null : cursorQuery.getString(i173));
                    columnIndexOrThrow257 = i173;
                    int i174 = columnIndexOrThrow258;
                    clockConfig.setOperator_show_type(cursorQuery.isNull(i174) ? null : cursorQuery.getString(i174));
                    columnIndexOrThrow258 = i174;
                    int i175 = columnIndexOrThrow259;
                    clockConfig.setOperator_x(cursorQuery.getInt(i175));
                    columnIndexOrThrow259 = i175;
                    int i176 = columnIndexOrThrow260;
                    clockConfig.setOperator_y(cursorQuery.getInt(i176));
                    columnIndexOrThrow260 = i176;
                    int i177 = columnIndexOrThrow261;
                    clockConfig.setShow_btn_call(cursorQuery.isNull(i177) ? null : cursorQuery.getString(i177));
                    columnIndexOrThrow261 = i177;
                    int i178 = columnIndexOrThrow262;
                    clockConfig.setBtn_call_src(cursorQuery.isNull(i178) ? null : cursorQuery.getString(i178));
                    columnIndexOrThrow262 = i178;
                    int i179 = columnIndexOrThrow263;
                    clockConfig.setBtn_call_x(cursorQuery.getInt(i179));
                    columnIndexOrThrow263 = i179;
                    int i180 = columnIndexOrThrow264;
                    clockConfig.setBtn_call_y(cursorQuery.getInt(i180));
                    columnIndexOrThrow264 = i180;
                    int i181 = columnIndexOrThrow265;
                    clockConfig.setShow_btn_sms(cursorQuery.isNull(i181) ? null : cursorQuery.getString(i181));
                    columnIndexOrThrow265 = i181;
                    int i182 = columnIndexOrThrow266;
                    clockConfig.setBtn_sms_src(cursorQuery.isNull(i182) ? null : cursorQuery.getString(i182));
                    columnIndexOrThrow266 = i182;
                    int i183 = columnIndexOrThrow267;
                    clockConfig.setBtn_sms_x(cursorQuery.getInt(i183));
                    columnIndexOrThrow267 = i183;
                    int i184 = columnIndexOrThrow268;
                    clockConfig.setBtn_sms_y(cursorQuery.getInt(i184));
                    columnIndexOrThrow268 = i184;
                    int i185 = columnIndexOrThrow269;
                    clockConfig.setShow_btn_heart(cursorQuery.isNull(i185) ? null : cursorQuery.getString(i185));
                    columnIndexOrThrow269 = i185;
                    int i186 = columnIndexOrThrow270;
                    clockConfig.setIs_our_heart(cursorQuery.getInt(i186));
                    columnIndexOrThrow270 = i186;
                    int i187 = columnIndexOrThrow271;
                    clockConfig.setBtn_heart_src(cursorQuery.isNull(i187) ? null : cursorQuery.getString(i187));
                    columnIndexOrThrow271 = i187;
                    int i188 = columnIndexOrThrow272;
                    clockConfig.setBtn_heart_x(cursorQuery.getInt(i188));
                    columnIndexOrThrow272 = i188;
                    int i189 = columnIndexOrThrow273;
                    clockConfig.setBtn_heart_y(cursorQuery.getInt(i189));
                    columnIndexOrThrow273 = i189;
                    int i190 = columnIndexOrThrow274;
                    clockConfig.setShow_btn_step(cursorQuery.isNull(i190) ? null : cursorQuery.getString(i190));
                    columnIndexOrThrow274 = i190;
                    int i191 = columnIndexOrThrow275;
                    clockConfig.setBtn_step_src(cursorQuery.isNull(i191) ? null : cursorQuery.getString(i191));
                    columnIndexOrThrow275 = i191;
                    int i192 = columnIndexOrThrow276;
                    clockConfig.setBtn_step_x(cursorQuery.getInt(i192));
                    columnIndexOrThrow276 = i192;
                    int i193 = columnIndexOrThrow277;
                    clockConfig.setBtn_step_y(cursorQuery.getInt(i193));
                    columnIndexOrThrow277 = i193;
                    int i194 = columnIndexOrThrow278;
                    clockConfig.setShow_btn_wechat(cursorQuery.isNull(i194) ? null : cursorQuery.getString(i194));
                    columnIndexOrThrow278 = i194;
                    int i195 = columnIndexOrThrow279;
                    clockConfig.setBtn_wechat_src(cursorQuery.isNull(i195) ? null : cursorQuery.getString(i195));
                    columnIndexOrThrow279 = i195;
                    int i196 = columnIndexOrThrow280;
                    clockConfig.setBtn_wechat_x(cursorQuery.getInt(i196));
                    columnIndexOrThrow280 = i196;
                    int i197 = columnIndexOrThrow281;
                    clockConfig.setBtn_wechat_y(cursorQuery.getInt(i197));
                    columnIndexOrThrow281 = i197;
                    int i198 = columnIndexOrThrow282;
                    clockConfig.setShow_btn_alipay(cursorQuery.getInt(i198));
                    columnIndexOrThrow282 = i198;
                    int i199 = columnIndexOrThrow283;
                    clockConfig.setBtn_alipay_src(cursorQuery.isNull(i199) ? null : cursorQuery.getString(i199));
                    columnIndexOrThrow283 = i199;
                    int i200 = columnIndexOrThrow284;
                    clockConfig.setBtn_alipay_x(cursorQuery.getInt(i200));
                    columnIndexOrThrow284 = i200;
                    int i201 = columnIndexOrThrow285;
                    clockConfig.setBtn_alipay_y(cursorQuery.getInt(i201));
                    columnIndexOrThrow285 = i201;
                    int i202 = columnIndexOrThrow286;
                    clockConfig.setShow_btn_stopwatch(cursorQuery.getInt(i202));
                    columnIndexOrThrow286 = i202;
                    int i203 = columnIndexOrThrow287;
                    clockConfig.setBtn_stopwatch_src(cursorQuery.isNull(i203) ? null : cursorQuery.getString(i203));
                    columnIndexOrThrow287 = i203;
                    int i204 = columnIndexOrThrow288;
                    clockConfig.setBtn_stopwatch_x(cursorQuery.getInt(i204));
                    columnIndexOrThrow288 = i204;
                    int i205 = columnIndexOrThrow289;
                    clockConfig.setBtn_stopwatch_y(cursorQuery.getInt(i205));
                    columnIndexOrThrow289 = i205;
                    int i206 = columnIndexOrThrow290;
                    clockConfig.setShow_btn_weather(cursorQuery.getInt(i206));
                    columnIndexOrThrow290 = i206;
                    int i207 = columnIndexOrThrow291;
                    clockConfig.setShow_btn_calo(cursorQuery.getInt(i207));
                    columnIndexOrThrow291 = i207;
                    int i208 = columnIndexOrThrow292;
                    clockConfig.setBtn_calo_src(cursorQuery.isNull(i208) ? null : cursorQuery.getString(i208));
                    columnIndexOrThrow292 = i208;
                    int i209 = columnIndexOrThrow293;
                    clockConfig.setBtn_calo_x(cursorQuery.getInt(i209));
                    columnIndexOrThrow293 = i209;
                    int i210 = columnIndexOrThrow294;
                    clockConfig.setBtn_calo_y(cursorQuery.getInt(i210));
                    columnIndexOrThrow294 = i210;
                    int i211 = columnIndexOrThrow295;
                    clockConfig.setTemprature_src(cursorQuery.isNull(i211) ? null : cursorQuery.getString(i211));
                    columnIndexOrThrow295 = i211;
                    int i212 = columnIndexOrThrow296;
                    clockConfig.setShow_btn_camera(cursorQuery.isNull(i212) ? null : cursorQuery.getString(i212));
                    columnIndexOrThrow296 = i212;
                    int i213 = columnIndexOrThrow297;
                    clockConfig.setBtn_camera_src(cursorQuery.isNull(i213) ? null : cursorQuery.getString(i213));
                    columnIndexOrThrow297 = i213;
                    int i214 = columnIndexOrThrow298;
                    clockConfig.setBtn_camera_x(cursorQuery.getInt(i214));
                    columnIndexOrThrow298 = i214;
                    int i215 = columnIndexOrThrow299;
                    clockConfig.setBtn_camera_y(cursorQuery.getInt(i215));
                    columnIndexOrThrow299 = i215;
                    int i216 = columnIndexOrThrow300;
                    clockConfig.setShow_btn_sos(cursorQuery.isNull(i216) ? null : cursorQuery.getString(i216));
                    columnIndexOrThrow300 = i216;
                    int i217 = columnIndexOrThrow301;
                    clockConfig.setBtn_sos_src(cursorQuery.isNull(i217) ? null : cursorQuery.getString(i217));
                    columnIndexOrThrow301 = i217;
                    int i218 = columnIndexOrThrow302;
                    clockConfig.setBtn_sos_x(cursorQuery.getInt(i218));
                    columnIndexOrThrow302 = i218;
                    int i219 = columnIndexOrThrow303;
                    clockConfig.setBtn_sos_y(cursorQuery.getInt(i219));
                    columnIndexOrThrow303 = i219;
                    int i220 = columnIndexOrThrow304;
                    clockConfig.setShow_special_1(cursorQuery.isNull(i220) ? null : cursorQuery.getString(i220));
                    columnIndexOrThrow304 = i220;
                    int i221 = columnIndexOrThrow305;
                    clockConfig.setSpecial_1_src(cursorQuery.isNull(i221) ? null : cursorQuery.getString(i221));
                    columnIndexOrThrow305 = i221;
                    int i222 = columnIndexOrThrow306;
                    clockConfig.setSpecial_1_position(cursorQuery.isNull(i222) ? null : cursorQuery.getString(i222));
                    columnIndexOrThrow306 = i222;
                    int i223 = columnIndexOrThrow307;
                    clockConfig.setSpecial_x(cursorQuery.getInt(i223));
                    columnIndexOrThrow307 = i223;
                    int i224 = columnIndexOrThrow308;
                    clockConfig.setSpecial_y(cursorQuery.getInt(i224));
                    columnIndexOrThrow308 = i224;
                    int i225 = columnIndexOrThrow309;
                    clockConfig.setSupport_multiple_change(cursorQuery.getInt(i225));
                    columnIndexOrThrow309 = i225;
                    int i226 = columnIndexOrThrow310;
                    clockConfig.setShow_lunar_year(cursorQuery.getInt(i226));
                    columnIndexOrThrow310 = i226;
                    int i227 = columnIndexOrThrow311;
                    clockConfig.setLunar_day_splt_src(cursorQuery.isNull(i227) ? null : cursorQuery.getString(i227));
                    columnIndexOrThrow311 = i227;
                    int i228 = columnIndexOrThrow312;
                    clockConfig.setLunar_month_splt_src(cursorQuery.isNull(i228) ? null : cursorQuery.getString(i228));
                    columnIndexOrThrow312 = i228;
                    int i229 = columnIndexOrThrow313;
                    clockConfig.setLunar_year_splt_src(cursorQuery.isNull(i229) ? null : cursorQuery.getString(i229));
                    columnIndexOrThrow313 = i229;
                    int i230 = columnIndexOrThrow314;
                    clockConfig.setAm_src(cursorQuery.isNull(i230) ? null : cursorQuery.getString(i230));
                    columnIndexOrThrow314 = i230;
                    int i231 = columnIndexOrThrow315;
                    clockConfig.setPm_src(cursorQuery.isNull(i231) ? null : cursorQuery.getString(i231));
                    columnIndexOrThrow315 = i231;
                    int i232 = columnIndexOrThrow316;
                    clockConfig.setShow_btn_alarm(cursorQuery.getInt(i232));
                    columnIndexOrThrow316 = i232;
                    int i233 = columnIndexOrThrow317;
                    clockConfig.setBtn_alarm_src(cursorQuery.isNull(i233) ? null : cursorQuery.getString(i233));
                    columnIndexOrThrow317 = i233;
                    int i234 = columnIndexOrThrow318;
                    clockConfig.setBtn_alarm_x(cursorQuery.getInt(i234));
                    columnIndexOrThrow318 = i234;
                    int i235 = columnIndexOrThrow319;
                    clockConfig.setBtn_alarm_y(cursorQuery.getInt(i235));
                    columnIndexOrThrow319 = i235;
                    int i236 = columnIndexOrThrow320;
                    clockConfig.setBg_btn_change(cursorQuery.getInt(i236));
                    columnIndexOrThrow320 = i236;
                    int i237 = columnIndexOrThrow321;
                    clockConfig.setBg_btn_index(cursorQuery.getInt(i237));
                    columnIndexOrThrow321 = i237;
                    int i238 = columnIndexOrThrow322;
                    clockConfig.setShow_btn_music(cursorQuery.getInt(i238));
                    columnIndexOrThrow322 = i238;
                    int i239 = columnIndexOrThrow323;
                    clockConfig.setBtn_music_src(cursorQuery.isNull(i239) ? null : cursorQuery.getString(i239));
                    columnIndexOrThrow323 = i239;
                    int i240 = columnIndexOrThrow324;
                    clockConfig.setBtn_music_x(cursorQuery.getInt(i240));
                    columnIndexOrThrow324 = i240;
                    int i241 = columnIndexOrThrow325;
                    clockConfig.setBtn_music_y(cursorQuery.getInt(i241));
                    columnIndexOrThrow325 = i241;
                    int i242 = columnIndexOrThrow326;
                    clockConfig.setSupport_dynamic_change(cursorQuery.getInt(i242));
                    columnIndexOrThrow326 = i242;
                    int i243 = columnIndexOrThrow327;
                    clockConfig.setLevel(cursorQuery.getInt(i243));
                    columnIndexOrThrow327 = i243;
                    int i244 = columnIndexOrThrow328;
                    clockConfig.setParent_id(cursorQuery.isNull(i244) ? null : cursorQuery.getString(i244));
                    columnIndexOrThrow328 = i244;
                    int i245 = columnIndexOrThrow329;
                    clockConfig.setNext_id(cursorQuery.getInt(i245));
                    columnIndexOrThrow329 = i245;
                    int i246 = columnIndexOrThrow330;
                    clockConfig.setChange_starttime(cursorQuery.getInt(i246));
                    columnIndexOrThrow330 = i246;
                    int i247 = columnIndexOrThrow331;
                    clockConfig.setChange_endtime(cursorQuery.getInt(i247));
                    columnIndexOrThrow331 = i247;
                    int i248 = columnIndexOrThrow332;
                    clockConfig.setBtn_weather_src(cursorQuery.isNull(i248) ? null : cursorQuery.getString(i248));
                    columnIndexOrThrow332 = i248;
                    int i249 = columnIndexOrThrow333;
                    clockConfig.setBtn_weather_x(cursorQuery.getInt(i249));
                    columnIndexOrThrow333 = i249;
                    int i250 = columnIndexOrThrow334;
                    clockConfig.setBtn_weather_y(cursorQuery.getInt(i250));
                    columnIndexOrThrow334 = i250;
                    int i251 = columnIndexOrThrow335;
                    clockConfig.setShow_btn_calories(cursorQuery.getInt(i251));
                    columnIndexOrThrow335 = i251;
                    int i252 = columnIndexOrThrow336;
                    clockConfig.setBtn_calories_src(cursorQuery.isNull(i252) ? null : cursorQuery.getString(i252));
                    columnIndexOrThrow336 = i252;
                    int i253 = columnIndexOrThrow337;
                    clockConfig.setBtn_calories_x(cursorQuery.getInt(i253));
                    columnIndexOrThrow337 = i253;
                    int i254 = columnIndexOrThrow338;
                    clockConfig.setBtn_calories_y(cursorQuery.getInt(i254));
                    columnIndexOrThrow338 = i254;
                    int i255 = columnIndexOrThrow339;
                    clockConfig.setSupport_compass(cursorQuery.getInt(i255));
                    columnIndexOrThrow339 = i255;
                    int i256 = columnIndexOrThrow340;
                    clockConfig.setCompass_src(cursorQuery.isNull(i256) ? null : cursorQuery.getString(i256));
                    columnIndexOrThrow340 = i256;
                    int i257 = columnIndexOrThrow341;
                    clockConfig.setCompass_2_src(cursorQuery.isNull(i257) ? null : cursorQuery.getString(i257));
                    columnIndexOrThrow341 = i257;
                    int i258 = columnIndexOrThrow342;
                    clockConfig.setCompass_x(cursorQuery.getInt(i258));
                    columnIndexOrThrow342 = i258;
                    int i259 = columnIndexOrThrow343;
                    clockConfig.setCompass_y(cursorQuery.getInt(i259));
                    columnIndexOrThrow343 = i259;
                    int i260 = columnIndexOrThrow344;
                    clockConfig.setShow_btn_setting(cursorQuery.getInt(i260));
                    columnIndexOrThrow344 = i260;
                    int i261 = columnIndexOrThrow345;
                    clockConfig.setBtn_setting_src(cursorQuery.isNull(i261) ? null : cursorQuery.getString(i261));
                    columnIndexOrThrow345 = i261;
                    int i262 = columnIndexOrThrow346;
                    clockConfig.setBtn_setting_x(cursorQuery.getInt(i262));
                    columnIndexOrThrow346 = i262;
                    int i263 = columnIndexOrThrow347;
                    clockConfig.setBtn_setting_y(cursorQuery.getInt(i263));
                    columnIndexOrThrow347 = i263;
                    int i264 = columnIndexOrThrow348;
                    clockConfig.setSupport_click_change(cursorQuery.getInt(i264));
                    columnIndexOrThrow348 = i264;
                    int i265 = columnIndexOrThrow349;
                    clockConfig.setClick_id_is_current(cursorQuery.getInt(i265));
                    columnIndexOrThrow349 = i265;
                    int i266 = columnIndexOrThrow350;
                    clockConfig.setCompass_show_detail_degree(cursorQuery.getInt(i266));
                    columnIndexOrThrow350 = i266;
                    int i267 = columnIndexOrThrow351;
                    clockConfig.setCompass_direction_src(cursorQuery.isNull(i267) ? null : cursorQuery.getString(i267));
                    columnIndexOrThrow351 = i267;
                    int i268 = columnIndexOrThrow352;
                    clockConfig.setCompass_direction_x(cursorQuery.getInt(i268));
                    columnIndexOrThrow352 = i268;
                    int i269 = columnIndexOrThrow353;
                    clockConfig.setCompass_direction_y(cursorQuery.getInt(i269));
                    columnIndexOrThrow353 = i269;
                    int i270 = columnIndexOrThrow354;
                    clockConfig.setCompass_direction_2_src(cursorQuery.isNull(i270) ? null : cursorQuery.getString(i270));
                    columnIndexOrThrow354 = i270;
                    int i271 = columnIndexOrThrow355;
                    clockConfig.setCompass_direction_2_x(cursorQuery.getInt(i271));
                    columnIndexOrThrow355 = i271;
                    int i272 = columnIndexOrThrow356;
                    clockConfig.setCompass_direction_2_y(cursorQuery.getInt(i272));
                    columnIndexOrThrow356 = i272;
                    int i273 = columnIndexOrThrow357;
                    clockConfig.setCompass_direction_3_src(cursorQuery.isNull(i273) ? null : cursorQuery.getString(i273));
                    columnIndexOrThrow357 = i273;
                    int i274 = columnIndexOrThrow358;
                    clockConfig.setCompass_direction_3_x(cursorQuery.getInt(i274));
                    columnIndexOrThrow358 = i274;
                    int i275 = columnIndexOrThrow359;
                    clockConfig.setCompass_direction_3_y(cursorQuery.getInt(i275));
                    columnIndexOrThrow359 = i275;
                    int i276 = columnIndexOrThrow360;
                    clockConfig.setCompass_direction_degree_src(cursorQuery.isNull(i276) ? null : cursorQuery.getString(i276));
                    columnIndexOrThrow360 = i276;
                    int i277 = columnIndexOrThrow361;
                    clockConfig.setCompass_direction_degree_x(cursorQuery.getInt(i277));
                    columnIndexOrThrow361 = i277;
                    int i278 = columnIndexOrThrow362;
                    clockConfig.setCompass_direction_degree_y(cursorQuery.getInt(i278));
                    columnIndexOrThrow362 = i278;
                    int i279 = columnIndexOrThrow363;
                    clockConfig.setCompass_direction_degree_unit(cursorQuery.isNull(i279) ? null : cursorQuery.getString(i279));
                    columnIndexOrThrow363 = i279;
                    int i280 = columnIndexOrThrow364;
                    clockConfig.setCompass_degree_1_src(cursorQuery.isNull(i280) ? null : cursorQuery.getString(i280));
                    columnIndexOrThrow364 = i280;
                    int i281 = columnIndexOrThrow365;
                    clockConfig.setCompass_degree_1_x(cursorQuery.getInt(i281));
                    columnIndexOrThrow365 = i281;
                    int i282 = columnIndexOrThrow366;
                    clockConfig.setCompass_degree_1_y(cursorQuery.getInt(i282));
                    columnIndexOrThrow366 = i282;
                    int i283 = columnIndexOrThrow367;
                    clockConfig.setCompass_degree_2_src(cursorQuery.isNull(i283) ? null : cursorQuery.getString(i283));
                    columnIndexOrThrow367 = i283;
                    int i284 = columnIndexOrThrow368;
                    clockConfig.setCompass_degree_2_x(cursorQuery.getInt(i284));
                    columnIndexOrThrow368 = i284;
                    int i285 = columnIndexOrThrow369;
                    clockConfig.setCompass_degree_2_y(cursorQuery.getInt(i285));
                    columnIndexOrThrow369 = i285;
                    int i286 = columnIndexOrThrow370;
                    clockConfig.setCompass_degree_3_src(cursorQuery.isNull(i286) ? null : cursorQuery.getString(i286));
                    columnIndexOrThrow370 = i286;
                    int i287 = columnIndexOrThrow371;
                    clockConfig.setCompass_degree_3_x(cursorQuery.getInt(i287));
                    columnIndexOrThrow371 = i287;
                    int i288 = columnIndexOrThrow372;
                    clockConfig.setCompass_degree_3_y(cursorQuery.getInt(i288));
                    columnIndexOrThrow372 = i288;
                    int i289 = columnIndexOrThrow373;
                    clockConfig.setShow_connect_animation(cursorQuery.getInt(i289));
                    columnIndexOrThrow373 = i289;
                    int i290 = columnIndexOrThrow374;
                    clockConfig.setConnect_animation_x(cursorQuery.getInt(i290));
                    columnIndexOrThrow374 = i290;
                    int i291 = columnIndexOrThrow375;
                    clockConfig.setConnect_animation_y(cursorQuery.getInt(i291));
                    columnIndexOrThrow375 = i291;
                    int i292 = columnIndexOrThrow376;
                    clockConfig.setConnect_animation_count(cursorQuery.getInt(i292));
                    columnIndexOrThrow376 = i292;
                    int i293 = columnIndexOrThrow377;
                    clockConfig.setShow_state(cursorQuery.getInt(i293));
                    columnIndexOrThrow377 = i293;
                    int i294 = columnIndexOrThrow378;
                    clockConfig.setState_x(cursorQuery.getInt(i294));
                    columnIndexOrThrow378 = i294;
                    int i295 = columnIndexOrThrow379;
                    clockConfig.setState_y(cursorQuery.getInt(i295));
                    columnIndexOrThrow379 = i295;
                    int i296 = columnIndexOrThrow380;
                    clockConfig.setAction_1_cut_position(cursorQuery.getInt(i296));
                    columnIndexOrThrow380 = i296;
                    int i297 = columnIndexOrThrow381;
                    clockConfig.setAction_2_cut_position(cursorQuery.getInt(i297));
                    columnIndexOrThrow381 = i297;
                    int i298 = columnIndexOrThrow382;
                    clockConfig.setAction_3_cut_position(cursorQuery.getInt(i298));
                    columnIndexOrThrow382 = i298;
                    int i299 = columnIndexOrThrow383;
                    clockConfig.setShow_btn_googleplay(cursorQuery.getInt(i299));
                    columnIndexOrThrow383 = i299;
                    int i300 = columnIndexOrThrow384;
                    clockConfig.setBtn_googleplay_src(cursorQuery.isNull(i300) ? null : cursorQuery.getString(i300));
                    columnIndexOrThrow384 = i300;
                    int i301 = columnIndexOrThrow385;
                    clockConfig.setBtn_googleplay_x(cursorQuery.getInt(i301));
                    columnIndexOrThrow385 = i301;
                    int i302 = columnIndexOrThrow386;
                    clockConfig.setBtn_googleplay_y(cursorQuery.getInt(i302));
                    columnIndexOrThrow386 = i302;
                    int i303 = columnIndexOrThrow387;
                    clockConfig.setShow_month_2(cursorQuery.getInt(i303));
                    columnIndexOrThrow387 = i303;
                    int i304 = columnIndexOrThrow388;
                    clockConfig.setMonth_type_2(cursorQuery.getInt(i304));
                    columnIndexOrThrow388 = i304;
                    int i305 = columnIndexOrThrow389;
                    clockConfig.setMonth_src_2(cursorQuery.isNull(i305) ? null : cursorQuery.getString(i305));
                    columnIndexOrThrow389 = i305;
                    int i306 = columnIndexOrThrow390;
                    clockConfig.setMonth_x_2(cursorQuery.getInt(i306));
                    columnIndexOrThrow390 = i306;
                    int i307 = columnIndexOrThrow391;
                    clockConfig.setMonth_y_2(cursorQuery.getInt(i307));
                    columnIndexOrThrow391 = i307;
                    int i308 = columnIndexOrThrow392;
                    clockConfig.setTime_special_new(cursorQuery.getInt(i308));
                    columnIndexOrThrow392 = i308;
                    int i309 = columnIndexOrThrow393;
                    clockConfig.setTime_special_hour_ten_src(cursorQuery.isNull(i309) ? null : cursorQuery.getString(i309));
                    columnIndexOrThrow393 = i309;
                    int i310 = columnIndexOrThrow394;
                    clockConfig.setTime_special_hour_src(cursorQuery.isNull(i310) ? null : cursorQuery.getString(i310));
                    columnIndexOrThrow394 = i310;
                    int i311 = columnIndexOrThrow395;
                    clockConfig.setTime_special_min_ten_src(cursorQuery.isNull(i311) ? null : cursorQuery.getString(i311));
                    columnIndexOrThrow395 = i311;
                    int i312 = columnIndexOrThrow396;
                    clockConfig.setTime_special_min_src(cursorQuery.isNull(i312) ? null : cursorQuery.getString(i312));
                    columnIndexOrThrow396 = i312;
                    int i313 = columnIndexOrThrow397;
                    clockConfig.setShow_kcal_progress(cursorQuery.getInt(i313));
                    columnIndexOrThrow397 = i313;
                    int i314 = columnIndexOrThrow398;
                    clockConfig.setKcal_progress_x(cursorQuery.getInt(i314));
                    columnIndexOrThrow398 = i314;
                    int i315 = columnIndexOrThrow399;
                    clockConfig.setKcal_progress_y(cursorQuery.getInt(i315));
                    columnIndexOrThrow399 = i315;
                    int i316 = columnIndexOrThrow400;
                    clockConfig.setKcal_progress_src(cursorQuery.isNull(i316) ? null : cursorQuery.getString(i316));
                    columnIndexOrThrow400 = i316;
                    int i317 = columnIndexOrThrow401;
                    clockConfig.setOpen_kcal_arc_show(cursorQuery.getInt(i317));
                    columnIndexOrThrow401 = i317;
                    int i318 = columnIndexOrThrow402;
                    clockConfig.setKcal_arc_type(cursorQuery.getInt(i318));
                    columnIndexOrThrow402 = i318;
                    int i319 = columnIndexOrThrow403;
                    clockConfig.setKcal_arc_center_x(cursorQuery.getInt(i319));
                    columnIndexOrThrow403 = i319;
                    int i320 = columnIndexOrThrow404;
                    clockConfig.setKcal_arc_center_y(cursorQuery.getInt(i320));
                    columnIndexOrThrow404 = i320;
                    int i321 = columnIndexOrThrow405;
                    clockConfig.setOpen_power_arc_show(cursorQuery.getInt(i321));
                    columnIndexOrThrow405 = i321;
                    int i322 = columnIndexOrThrow406;
                    clockConfig.setPower_arc_type(cursorQuery.getInt(i322));
                    columnIndexOrThrow406 = i322;
                    int i323 = columnIndexOrThrow407;
                    clockConfig.setPower_arc_center_x(cursorQuery.getInt(i323));
                    columnIndexOrThrow407 = i323;
                    int i324 = columnIndexOrThrow408;
                    clockConfig.setPower_arc_center_y(cursorQuery.getInt(i324));
                    columnIndexOrThrow408 = i324;
                    int i325 = columnIndexOrThrow409;
                    clockConfig.setShow_btn_timer(cursorQuery.getInt(i325));
                    columnIndexOrThrow409 = i325;
                    int i326 = columnIndexOrThrow410;
                    clockConfig.setBtn_timer_src(cursorQuery.isNull(i326) ? null : cursorQuery.getString(i326));
                    columnIndexOrThrow410 = i326;
                    int i327 = columnIndexOrThrow411;
                    clockConfig.setBtn_timer_x(cursorQuery.getInt(i327));
                    columnIndexOrThrow411 = i327;
                    int i328 = columnIndexOrThrow412;
                    clockConfig.setBtn_timer_y(cursorQuery.getInt(i328));
                    columnIndexOrThrow412 = i328;
                    int i329 = columnIndexOrThrow413;
                    clockConfig.setShow_btn_sleep(cursorQuery.getInt(i329));
                    columnIndexOrThrow413 = i329;
                    int i330 = columnIndexOrThrow414;
                    clockConfig.setBtn_sleep_src(cursorQuery.isNull(i330) ? null : cursorQuery.getString(i330));
                    columnIndexOrThrow414 = i330;
                    int i331 = columnIndexOrThrow415;
                    clockConfig.setBtn_sleep_x(cursorQuery.getInt(i331));
                    columnIndexOrThrow415 = i331;
                    int i332 = columnIndexOrThrow416;
                    clockConfig.setBtn_sleep_y(cursorQuery.getInt(i332));
                    columnIndexOrThrow416 = i332;
                    int i333 = columnIndexOrThrow417;
                    clockConfig.setShow_btn_bloodpressure(cursorQuery.getInt(i333));
                    columnIndexOrThrow417 = i333;
                    int i334 = columnIndexOrThrow418;
                    clockConfig.setBtn_bloodpressure_src(cursorQuery.isNull(i334) ? null : cursorQuery.getString(i334));
                    columnIndexOrThrow418 = i334;
                    int i335 = columnIndexOrThrow419;
                    clockConfig.setBtn_bloodpressure_x(cursorQuery.getInt(i335));
                    columnIndexOrThrow419 = i335;
                    int i336 = columnIndexOrThrow420;
                    clockConfig.setBtn_bloodpressure_y(cursorQuery.getInt(i336));
                    columnIndexOrThrow420 = i336;
                    int i337 = columnIndexOrThrow421;
                    clockConfig.setShow_btn_sport_record(cursorQuery.getInt(i337));
                    columnIndexOrThrow421 = i337;
                    int i338 = columnIndexOrThrow422;
                    clockConfig.setBtn_sport_record_src(cursorQuery.isNull(i338) ? null : cursorQuery.getString(i338));
                    columnIndexOrThrow422 = i338;
                    int i339 = columnIndexOrThrow423;
                    clockConfig.setBtn_sport_record_x(cursorQuery.getInt(i339));
                    columnIndexOrThrow423 = i339;
                    int i340 = columnIndexOrThrow424;
                    clockConfig.setBtn_sport_record_y(cursorQuery.getInt(i340));
                    columnIndexOrThrow424 = i340;
                    int i341 = columnIndexOrThrow425;
                    clockConfig.setLottie_hierarchy(cursorQuery.getInt(i341));
                    columnIndexOrThrow425 = i341;
                    int i342 = columnIndexOrThrow426;
                    clockConfig.setShow_heart_progress(cursorQuery.getInt(i342));
                    columnIndexOrThrow426 = i342;
                    int i343 = columnIndexOrThrow427;
                    clockConfig.setHeart_progress_x(cursorQuery.getInt(i343));
                    columnIndexOrThrow427 = i343;
                    int i344 = columnIndexOrThrow428;
                    clockConfig.setHeart_progress_y(cursorQuery.getInt(i344));
                    columnIndexOrThrow428 = i344;
                    int i345 = columnIndexOrThrow429;
                    clockConfig.setHeart_progress_src(cursorQuery.isNull(i345) ? null : cursorQuery.getString(i345));
                    columnIndexOrThrow429 = i345;
                    int i346 = columnIndexOrThrow430;
                    clockConfig.setShow_btn_calculator(cursorQuery.getInt(i346));
                    columnIndexOrThrow430 = i346;
                    int i347 = columnIndexOrThrow431;
                    clockConfig.setBtn_calculator_src(cursorQuery.isNull(i347) ? null : cursorQuery.getString(i347));
                    columnIndexOrThrow431 = i347;
                    int i348 = columnIndexOrThrow432;
                    clockConfig.setBtn_calculator_x(cursorQuery.getInt(i348));
                    columnIndexOrThrow432 = i348;
                    int i349 = columnIndexOrThrow433;
                    clockConfig.setBtn_calculator_y(cursorQuery.getInt(i349));
                    columnIndexOrThrow433 = i349;
                    int i350 = columnIndexOrThrow434;
                    clockConfig.setTime_special_drag_3d(cursorQuery.getInt(i350));
                    columnIndexOrThrow434 = i350;
                    int i351 = columnIndexOrThrow435;
                    clockConfig.setPrev_HourTen_Position(cursorQuery.isNull(i351) ? null : cursorQuery.getString(i351));
                    columnIndexOrThrow435 = i351;
                    int i352 = columnIndexOrThrow436;
                    clockConfig.setPrev_HourGe_Position(cursorQuery.isNull(i352) ? null : cursorQuery.getString(i352));
                    columnIndexOrThrow436 = i352;
                    int i353 = columnIndexOrThrow437;
                    clockConfig.setCurrent_HourTen_Position(cursorQuery.isNull(i353) ? null : cursorQuery.getString(i353));
                    columnIndexOrThrow437 = i353;
                    int i354 = columnIndexOrThrow438;
                    clockConfig.setCurrent_HourGe_Position(cursorQuery.isNull(i354) ? null : cursorQuery.getString(i354));
                    columnIndexOrThrow438 = i354;
                    int i355 = columnIndexOrThrow439;
                    clockConfig.setNext_HourTen_Position(cursorQuery.isNull(i355) ? null : cursorQuery.getString(i355));
                    columnIndexOrThrow439 = i355;
                    int i356 = columnIndexOrThrow440;
                    clockConfig.setNext_HourGe_Position(cursorQuery.isNull(i356) ? null : cursorQuery.getString(i356));
                    columnIndexOrThrow440 = i356;
                    int i357 = columnIndexOrThrow441;
                    clockConfig.setPrev_MinTen_Position(cursorQuery.isNull(i357) ? null : cursorQuery.getString(i357));
                    columnIndexOrThrow441 = i357;
                    int i358 = columnIndexOrThrow442;
                    clockConfig.setPrev_MinGe_Position(cursorQuery.isNull(i358) ? null : cursorQuery.getString(i358));
                    columnIndexOrThrow442 = i358;
                    int i359 = columnIndexOrThrow443;
                    clockConfig.setCurrent_MinTen_Position(cursorQuery.isNull(i359) ? null : cursorQuery.getString(i359));
                    columnIndexOrThrow443 = i359;
                    int i360 = columnIndexOrThrow444;
                    clockConfig.setCurrent_MinGe_Position(cursorQuery.isNull(i360) ? null : cursorQuery.getString(i360));
                    columnIndexOrThrow444 = i360;
                    int i361 = columnIndexOrThrow445;
                    clockConfig.setNext_MinTen_Position(cursorQuery.isNull(i361) ? null : cursorQuery.getString(i361));
                    columnIndexOrThrow445 = i361;
                    int i362 = columnIndexOrThrow446;
                    clockConfig.setNext_MinGe_Position(cursorQuery.isNull(i362) ? null : cursorQuery.getString(i362));
                    columnIndexOrThrow446 = i362;
                    int i363 = columnIndexOrThrow447;
                    clockConfig.setNeed_split_day(cursorQuery.getInt(i363));
                    columnIndexOrThrow447 = i363;
                    int i364 = columnIndexOrThrow448;
                    clockConfig.setSplit_day_x(cursorQuery.getInt(i364));
                    columnIndexOrThrow448 = i364;
                    int i365 = columnIndexOrThrow449;
                    clockConfig.setSplit_day_y(cursorQuery.getInt(i365));
                    columnIndexOrThrow449 = i365;
                    int i366 = columnIndexOrThrow450;
                    clockConfig.setOpen_now_tem_arc_show(cursorQuery.getInt(i366));
                    columnIndexOrThrow450 = i366;
                    int i367 = columnIndexOrThrow451;
                    clockConfig.setNow_tem_arc_type(cursorQuery.getInt(i367));
                    columnIndexOrThrow451 = i367;
                    int i368 = columnIndexOrThrow452;
                    clockConfig.setNow_tem_arc_center_x(cursorQuery.getInt(i368));
                    columnIndexOrThrow452 = i368;
                    int i369 = columnIndexOrThrow453;
                    clockConfig.setNow_tem_arc_center_y(cursorQuery.getInt(i369));
                    columnIndexOrThrow453 = i369;
                    int i370 = columnIndexOrThrow454;
                    clockConfig.setShow_km_progress(cursorQuery.getInt(i370));
                    columnIndexOrThrow454 = i370;
                    int i371 = columnIndexOrThrow455;
                    clockConfig.setKm_progress_x(cursorQuery.getInt(i371));
                    columnIndexOrThrow455 = i371;
                    int i372 = columnIndexOrThrow456;
                    clockConfig.setKm_progress_y(cursorQuery.getInt(i372));
                    columnIndexOrThrow456 = i372;
                    int i373 = columnIndexOrThrow457;
                    clockConfig.setKm_progress_src(cursorQuery.isNull(i373) ? null : cursorQuery.getString(i373));
                    columnIndexOrThrow457 = i373;
                    int i374 = columnIndexOrThrow458;
                    clockConfig.setOpen_km_arc_show(cursorQuery.getInt(i374));
                    columnIndexOrThrow458 = i374;
                    int i375 = columnIndexOrThrow459;
                    clockConfig.setKm_arc_type(cursorQuery.getInt(i375));
                    columnIndexOrThrow459 = i375;
                    int i376 = columnIndexOrThrow460;
                    clockConfig.setKm_arc_center_x(cursorQuery.getInt(i376));
                    columnIndexOrThrow460 = i376;
                    int i377 = columnIndexOrThrow461;
                    clockConfig.setKm_arc_center_y(cursorQuery.getInt(i377));
                    columnIndexOrThrow461 = i377;
                    int i378 = columnIndexOrThrow462;
                    clockConfig.setTime_rotate(cursorQuery.getInt(i378));
                    columnIndexOrThrow462 = i378;
                    int i379 = columnIndexOrThrow463;
                    clockConfig.setTime_rotate_degree(cursorQuery.getInt(i379));
                    columnIndexOrThrow463 = i379;
                    int i380 = columnIndexOrThrow464;
                    clockConfig.setHeart_num_rotate(cursorQuery.getInt(i380));
                    columnIndexOrThrow464 = i380;
                    int i381 = columnIndexOrThrow465;
                    clockConfig.setHeart_num_rotate_degree(cursorQuery.getInt(i381));
                    columnIndexOrThrow465 = i381;
                    int i382 = columnIndexOrThrow466;
                    clockConfig.setShow_oxygen(cursorQuery.getInt(i382));
                    columnIndexOrThrow466 = i382;
                    int i383 = columnIndexOrThrow467;
                    clockConfig.setOxygen_src(cursorQuery.isNull(i383) ? null : cursorQuery.getString(i383));
                    columnIndexOrThrow467 = i383;
                    int i384 = columnIndexOrThrow468;
                    clockConfig.setOxygen_x(cursorQuery.getInt(i384));
                    columnIndexOrThrow468 = i384;
                    int i385 = columnIndexOrThrow469;
                    clockConfig.setOxygen_y(cursorQuery.getInt(i385));
                    columnIndexOrThrow469 = i385;
                    int i386 = columnIndexOrThrow470;
                    clockConfig.setOxygen_num_src(cursorQuery.isNull(i386) ? null : cursorQuery.getString(i386));
                    columnIndexOrThrow470 = i386;
                    int i387 = columnIndexOrThrow471;
                    clockConfig.setOxygen_sign_src(cursorQuery.isNull(i387) ? null : cursorQuery.getString(i387));
                    columnIndexOrThrow471 = i387;
                    int i388 = columnIndexOrThrow472;
                    clockConfig.setOxygen_show_type(cursorQuery.getInt(i388));
                    columnIndexOrThrow472 = i388;
                    int i389 = columnIndexOrThrow473;
                    clockConfig.setOxygen_num_x(cursorQuery.getInt(i389));
                    columnIndexOrThrow473 = i389;
                    int i390 = columnIndexOrThrow474;
                    clockConfig.setOxygen_num_y(cursorQuery.getInt(i390));
                    columnIndexOrThrow474 = i390;
                    int i391 = columnIndexOrThrow475;
                    clockConfig.setTime_change_counter(cursorQuery.getInt(i391));
                    columnIndexOrThrow475 = i391;
                    int i392 = columnIndexOrThrow476;
                    clockConfig.setTime_hour_src_2(cursorQuery.isNull(i392) ? null : cursorQuery.getString(i392));
                    columnIndexOrThrow476 = i392;
                    int i393 = columnIndexOrThrow477;
                    clockConfig.setTime_min_src_2(cursorQuery.isNull(i393) ? null : cursorQuery.getString(i393));
                    columnIndexOrThrow477 = i393;
                    int i394 = columnIndexOrThrow478;
                    clockConfig.setTime_sec_src_2(cursorQuery.isNull(i394) ? null : cursorQuery.getString(i394));
                    columnIndexOrThrow478 = i394;
                    int i395 = columnIndexOrThrow479;
                    clockConfig.setTime_splt_src_2(cursorQuery.isNull(i395) ? null : cursorQuery.getString(i395));
                    columnIndexOrThrow479 = i395;
                    int i396 = columnIndexOrThrow480;
                    clockConfig.setTime_splt_2_src_2(cursorQuery.isNull(i396) ? null : cursorQuery.getString(i396));
                    columnIndexOrThrow480 = i396;
                    int i397 = columnIndexOrThrow481;
                    clockConfig.setTime_hour_src_3(cursorQuery.isNull(i397) ? null : cursorQuery.getString(i397));
                    columnIndexOrThrow481 = i397;
                    int i398 = columnIndexOrThrow482;
                    clockConfig.setTime_min_src_3(cursorQuery.isNull(i398) ? null : cursorQuery.getString(i398));
                    columnIndexOrThrow482 = i398;
                    int i399 = columnIndexOrThrow483;
                    clockConfig.setTime_sec_src_3(cursorQuery.isNull(i399) ? null : cursorQuery.getString(i399));
                    columnIndexOrThrow483 = i399;
                    int i400 = columnIndexOrThrow484;
                    clockConfig.setTime_splt_src_3(cursorQuery.isNull(i400) ? null : cursorQuery.getString(i400));
                    columnIndexOrThrow484 = i400;
                    int i401 = columnIndexOrThrow485;
                    clockConfig.setTime_splt_2_src_3(cursorQuery.isNull(i401) ? null : cursorQuery.getString(i401));
                    columnIndexOrThrow485 = i401;
                    int i402 = columnIndexOrThrow486;
                    clockConfig.setTime_hour_src_4(cursorQuery.isNull(i402) ? null : cursorQuery.getString(i402));
                    columnIndexOrThrow486 = i402;
                    int i403 = columnIndexOrThrow487;
                    clockConfig.setTime_min_src_4(cursorQuery.isNull(i403) ? null : cursorQuery.getString(i403));
                    columnIndexOrThrow487 = i403;
                    int i404 = columnIndexOrThrow488;
                    clockConfig.setTime_sec_src_4(cursorQuery.isNull(i404) ? null : cursorQuery.getString(i404));
                    columnIndexOrThrow488 = i404;
                    int i405 = columnIndexOrThrow489;
                    clockConfig.setTime_splt_src_4(cursorQuery.isNull(i405) ? null : cursorQuery.getString(i405));
                    columnIndexOrThrow489 = i405;
                    int i406 = columnIndexOrThrow490;
                    clockConfig.setTime_splt_2_src_4(cursorQuery.isNull(i406) ? null : cursorQuery.getString(i406));
                    columnIndexOrThrow490 = i406;
                    int i407 = columnIndexOrThrow491;
                    clockConfig.setDate_rotate(cursorQuery.getInt(i407));
                    columnIndexOrThrow491 = i407;
                    int i408 = columnIndexOrThrow492;
                    clockConfig.setDate_rotate_degree(cursorQuery.getInt(i408));
                    columnIndexOrThrow492 = i408;
                    int i409 = columnIndexOrThrow493;
                    clockConfig.setNeed_split_hour(cursorQuery.getInt(i409));
                    columnIndexOrThrow493 = i409;
                    int i410 = columnIndexOrThrow494;
                    clockConfig.setSplit_hour_src(cursorQuery.isNull(i410) ? null : cursorQuery.getString(i410));
                    columnIndexOrThrow494 = i410;
                    int i411 = columnIndexOrThrow495;
                    clockConfig.setSplit_hour_x(cursorQuery.getInt(i411));
                    columnIndexOrThrow495 = i411;
                    int i412 = columnIndexOrThrow496;
                    clockConfig.setSplit_hour_y(cursorQuery.getInt(i412));
                    columnIndexOrThrow496 = i412;
                    int i413 = columnIndexOrThrow497;
                    clockConfig.setNeed_split_min(cursorQuery.getInt(i413));
                    columnIndexOrThrow497 = i413;
                    int i414 = columnIndexOrThrow498;
                    clockConfig.setSplit_min_src(cursorQuery.isNull(i414) ? null : cursorQuery.getString(i414));
                    columnIndexOrThrow498 = i414;
                    int i415 = columnIndexOrThrow499;
                    clockConfig.setSplit_min_x(cursorQuery.getInt(i415));
                    columnIndexOrThrow499 = i415;
                    int i416 = columnIndexOrThrow500;
                    clockConfig.setSplit_min_y(cursorQuery.getInt(i416));
                    columnIndexOrThrow500 = i416;
                    int i417 = columnIndexOrThrow501;
                    clockConfig.setSupport_scale(cursorQuery.getInt(i417));
                    columnIndexOrThrow501 = i417;
                    int i418 = columnIndexOrThrow502;
                    clockConfig.setShow_compass_num(cursorQuery.getInt(i418));
                    columnIndexOrThrow502 = i418;
                    int i419 = columnIndexOrThrow503;
                    clockConfig.setCompass_num_src(cursorQuery.isNull(i419) ? null : cursorQuery.getString(i419));
                    columnIndexOrThrow503 = i419;
                    int i420 = columnIndexOrThrow504;
                    clockConfig.setCompass_show_type(cursorQuery.getInt(i420));
                    columnIndexOrThrow504 = i420;
                    int i421 = columnIndexOrThrow505;
                    clockConfig.setCompass_num_x(cursorQuery.getInt(i421));
                    columnIndexOrThrow505 = i421;
                    int i422 = columnIndexOrThrow506;
                    clockConfig.setCompass_num_y(cursorQuery.getInt(i422));
                    columnIndexOrThrow506 = i422;
                    int i423 = columnIndexOrThrow507;
                    clockConfig.setCompass_num_src_prefix(cursorQuery.isNull(i423) ? null : cursorQuery.getString(i423));
                    columnIndexOrThrow507 = i423;
                    int i424 = columnIndexOrThrow508;
                    clockConfig.setCompass_num_src_sign(cursorQuery.isNull(i424) ? null : cursorQuery.getString(i424));
                    columnIndexOrThrow508 = i424;
                    int i425 = columnIndexOrThrow509;
                    clockConfig.setShow_btn_oxygen(cursorQuery.getInt(i425));
                    columnIndexOrThrow509 = i425;
                    int i426 = columnIndexOrThrow510;
                    clockConfig.setBtn_oxygen_src(cursorQuery.isNull(i426) ? null : cursorQuery.getString(i426));
                    columnIndexOrThrow510 = i426;
                    int i427 = columnIndexOrThrow511;
                    clockConfig.setBtn_oxygen_x(cursorQuery.getInt(i427));
                    columnIndexOrThrow511 = i427;
                    int i428 = columnIndexOrThrow512;
                    clockConfig.setBtn_oxygen_y(cursorQuery.getInt(i428));
                    columnIndexOrThrow512 = i428;
                    int i429 = columnIndexOrThrow513;
                    clockConfig.setShow_btn_calendar(cursorQuery.getInt(i429));
                    columnIndexOrThrow513 = i429;
                    int i430 = columnIndexOrThrow514;
                    clockConfig.setBtn_calendar_src(cursorQuery.isNull(i430) ? null : cursorQuery.getString(i430));
                    columnIndexOrThrow514 = i430;
                    int i431 = columnIndexOrThrow515;
                    clockConfig.setBtn_calendar_x(cursorQuery.getInt(i431));
                    columnIndexOrThrow515 = i431;
                    int i432 = columnIndexOrThrow516;
                    clockConfig.setBtn_calendar_y(cursorQuery.getInt(i432));
                    columnIndexOrThrow516 = i432;
                    int i433 = columnIndexOrThrow517;
                    clockConfig.setShow_btn_compass(cursorQuery.getInt(i433));
                    columnIndexOrThrow517 = i433;
                    int i434 = columnIndexOrThrow518;
                    clockConfig.setBtn_compass_src(cursorQuery.isNull(i434) ? null : cursorQuery.getString(i434));
                    columnIndexOrThrow518 = i434;
                    int i435 = columnIndexOrThrow519;
                    clockConfig.setBtn_compass_x(cursorQuery.getInt(i435));
                    columnIndexOrThrow519 = i435;
                    int i436 = columnIndexOrThrow520;
                    clockConfig.setBtn_compass_y(cursorQuery.getInt(i436));
                    columnIndexOrThrow520 = i436;
                    int i437 = columnIndexOrThrow521;
                    clockConfig.setPointer_disable_scale(cursorQuery.getInt(i437));
                    columnIndexOrThrow521 = i437;
                    int i438 = columnIndexOrThrow522;
                    clockConfig.setShow_chinse_time(cursorQuery.getInt(i438));
                    columnIndexOrThrow522 = i438;
                    int i439 = columnIndexOrThrow523;
                    clockConfig.setChinse_time_src(cursorQuery.isNull(i439) ? null : cursorQuery.getString(i439));
                    columnIndexOrThrow523 = i439;
                    int i440 = columnIndexOrThrow524;
                    clockConfig.setChinse_time_x(cursorQuery.getInt(i440));
                    columnIndexOrThrow524 = i440;
                    int i441 = columnIndexOrThrow525;
                    clockConfig.setChinse_time_y(cursorQuery.getInt(i441));
                    columnIndexOrThrow525 = i441;
                    int i442 = columnIndexOrThrow526;
                    clockConfig.setShow_btn_photo(cursorQuery.getInt(i442));
                    columnIndexOrThrow526 = i442;
                    int i443 = columnIndexOrThrow527;
                    clockConfig.setBtn_photo_src(cursorQuery.isNull(i443) ? null : cursorQuery.getString(i443));
                    columnIndexOrThrow527 = i443;
                    int i444 = columnIndexOrThrow528;
                    clockConfig.setBtn_photo_x(cursorQuery.getInt(i444));
                    columnIndexOrThrow528 = i444;
                    int i445 = columnIndexOrThrow529;
                    clockConfig.setBtn_photo_y(cursorQuery.getInt(i445));
                    columnIndexOrThrow529 = i445;
                    int i446 = columnIndexOrThrow530;
                    clockConfig.setShow_btn_contact(cursorQuery.getInt(i446));
                    columnIndexOrThrow530 = i446;
                    int i447 = columnIndexOrThrow531;
                    clockConfig.setBtn_contact_src(cursorQuery.isNull(i447) ? null : cursorQuery.getString(i447));
                    columnIndexOrThrow531 = i447;
                    int i448 = columnIndexOrThrow532;
                    clockConfig.setBtn_contact_x(cursorQuery.getInt(i448));
                    columnIndexOrThrow532 = i448;
                    int i449 = columnIndexOrThrow533;
                    clockConfig.setBtn_contact_y(cursorQuery.getInt(i449));
                    columnIndexOrThrow533 = i449;
                    int i450 = columnIndexOrThrow534;
                    clockConfig.setKcal_num_rotate(cursorQuery.getInt(i450));
                    columnIndexOrThrow534 = i450;
                    int i451 = columnIndexOrThrow535;
                    clockConfig.setKcal_num_rotate_degree(cursorQuery.getInt(i451));
                    columnIndexOrThrow535 = i451;
                    int i452 = columnIndexOrThrow536;
                    clockConfig.setShow_power_progress(cursorQuery.getInt(i452));
                    columnIndexOrThrow536 = i452;
                    int i453 = columnIndexOrThrow537;
                    clockConfig.setPower_progress_src(cursorQuery.isNull(i453) ? null : cursorQuery.getString(i453));
                    columnIndexOrThrow537 = i453;
                    int i454 = columnIndexOrThrow538;
                    clockConfig.setPower_progress_x(cursorQuery.getInt(i454));
                    columnIndexOrThrow538 = i454;
                    int i455 = columnIndexOrThrow539;
                    clockConfig.setPower_progress_y(cursorQuery.getInt(i455));
                    columnIndexOrThrow539 = i455;
                    int i456 = columnIndexOrThrow540;
                    clockConfig.setPower_src(cursorQuery.isNull(i456) ? null : cursorQuery.getString(i456));
                    columnIndexOrThrow540 = i456;
                    int i457 = columnIndexOrThrow541;
                    clockConfig.setPower_src_x(cursorQuery.getInt(i457));
                    columnIndexOrThrow541 = i457;
                    int i458 = columnIndexOrThrow542;
                    clockConfig.setPower_src_y(cursorQuery.getInt(i458));
                    columnIndexOrThrow542 = i458;
                    int i459 = columnIndexOrThrow543;
                    clockConfig.setVideo_type(cursorQuery.getInt(i459));
                    columnIndexOrThrow543 = i459;
                    int i460 = columnIndexOrThrow544;
                    clockConfig.setStep_keep_number_length(cursorQuery.getInt(i460));
                    columnIndexOrThrow544 = i460;
                    int i461 = columnIndexOrThrow545;
                    clockConfig.setKcal_keep_number_length(cursorQuery.getInt(i461));
                    columnIndexOrThrow545 = i461;
                    int i462 = columnIndexOrThrow546;
                    clockConfig.setKm_keep_number_length(cursorQuery.getInt(i462));
                    columnIndexOrThrow546 = i462;
                    int i463 = columnIndexOrThrow547;
                    clockConfig.setStep_num_rotate(cursorQuery.getInt(i463));
                    columnIndexOrThrow547 = i463;
                    int i464 = columnIndexOrThrow548;
                    clockConfig.setStep_num_rotate_degree(cursorQuery.getInt(i464));
                    columnIndexOrThrow548 = i464;
                    int i465 = columnIndexOrThrow549;
                    clockConfig.setShow_btn_style(cursorQuery.getInt(i465));
                    columnIndexOrThrow549 = i465;
                    int i466 = columnIndexOrThrow550;
                    clockConfig.setBtn_style_src(cursorQuery.isNull(i466) ? null : cursorQuery.getString(i466));
                    columnIndexOrThrow550 = i466;
                    int i467 = columnIndexOrThrow551;
                    clockConfig.setBtn_style_x(cursorQuery.getInt(i467));
                    columnIndexOrThrow551 = i467;
                    int i468 = columnIndexOrThrow552;
                    clockConfig.setBtn_style_y(cursorQuery.getInt(i468));
                    columnIndexOrThrow552 = i468;
                    int i469 = columnIndexOrThrow553;
                    clockConfig.setNeed_split_sec(cursorQuery.getInt(i469));
                    columnIndexOrThrow553 = i469;
                    int i470 = columnIndexOrThrow554;
                    clockConfig.setSplit_sec_src(cursorQuery.isNull(i470) ? null : cursorQuery.getString(i470));
                    columnIndexOrThrow554 = i470;
                    int i471 = columnIndexOrThrow555;
                    clockConfig.setSplit_sec_x(cursorQuery.getInt(i471));
                    columnIndexOrThrow555 = i471;
                    int i472 = columnIndexOrThrow556;
                    clockConfig.setSplit_sec_y(cursorQuery.getInt(i472));
                    columnIndexOrThrow556 = i472;
                    int i473 = columnIndexOrThrow557;
                    clockConfig.setOpen_oxygen_arc_show(cursorQuery.getInt(i473));
                    columnIndexOrThrow557 = i473;
                    int i474 = columnIndexOrThrow558;
                    clockConfig.setOxygen_arc_type(cursorQuery.getInt(i474));
                    columnIndexOrThrow558 = i474;
                    int i475 = columnIndexOrThrow559;
                    clockConfig.setOxygen_arc_center_x(cursorQuery.getInt(i475));
                    columnIndexOrThrow559 = i475;
                    int i476 = columnIndexOrThrow560;
                    clockConfig.setOxygen_arc_center_y(cursorQuery.getInt(i476));
                    columnIndexOrThrow560 = i476;
                    int i477 = columnIndexOrThrow561;
                    clockConfig.setShow_oxygen_progress(cursorQuery.getInt(i477));
                    columnIndexOrThrow561 = i477;
                    int i478 = columnIndexOrThrow562;
                    clockConfig.setOxygen_progress_src(cursorQuery.isNull(i478) ? null : cursorQuery.getString(i478));
                    columnIndexOrThrow562 = i478;
                    int i479 = columnIndexOrThrow563;
                    clockConfig.setOxygen_progress_x(cursorQuery.getInt(i479));
                    columnIndexOrThrow563 = i479;
                    int i480 = columnIndexOrThrow564;
                    clockConfig.setOxygen_progress_y(cursorQuery.getInt(i480));
                    columnIndexOrThrow564 = i480;
                    int i481 = columnIndexOrThrow565;
                    clockConfig.setShow_week_donts(cursorQuery.getInt(i481));
                    columnIndexOrThrow565 = i481;
                    int i482 = columnIndexOrThrow566;
                    clockConfig.setWeek_donts_src(cursorQuery.isNull(i482) ? null : cursorQuery.getString(i482));
                    columnIndexOrThrow566 = i482;
                    int i483 = columnIndexOrThrow567;
                    clockConfig.setWeek_donts_x(cursorQuery.getInt(i483));
                    columnIndexOrThrow567 = i483;
                    int i484 = columnIndexOrThrow568;
                    clockConfig.setWeek_donts_y(cursorQuery.getInt(i484));
                    columnIndexOrThrow568 = i484;
                    int i485 = columnIndexOrThrow569;
                    clockConfig.setShow_btn_flashlight(cursorQuery.getInt(i485));
                    columnIndexOrThrow569 = i485;
                    int i486 = columnIndexOrThrow570;
                    clockConfig.setFlashlight_src(cursorQuery.isNull(i486) ? null : cursorQuery.getString(i486));
                    columnIndexOrThrow570 = i486;
                    int i487 = columnIndexOrThrow571;
                    clockConfig.setFlashlight_x(cursorQuery.getInt(i487));
                    columnIndexOrThrow571 = i487;
                    int i488 = columnIndexOrThrow572;
                    clockConfig.setFlashlight_y(cursorQuery.getInt(i488));
                    arrayList.add(clockConfig);
                    columnIndexOrThrow572 = i488;
                    columnIndexOrThrow10 = i2;
                    columnIndexOrThrow11 = i5;
                    columnIndexOrThrow14 = i4;
                    i = i3;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow55 = i36;
                    columnIndexOrThrow54 = i35;
                    columnIndexOrThrow63 = i44;
                    columnIndexOrThrow62 = i43;
                    columnIndexOrThrow79 = i56;
                    columnIndexOrThrow78 = i55;
                    columnIndexOrThrow89 = i64;
                    columnIndexOrThrow88 = i63;
                    columnIndexOrThrow94 = i68;
                    columnIndexOrThrow93 = i67;
                    columnIndexOrThrow108 = i72;
                    columnIndexOrThrow107 = i71;
                    columnIndexOrThrow120 = i74;
                    columnIndexOrThrow119 = i73;
                    columnIndexOrThrow139 = i92;
                    columnIndexOrThrow138 = i91;
                    columnIndexOrThrow163 = i104;
                    columnIndexOrThrow162 = i103;
                    columnIndexOrThrow167 = i108;
                    columnIndexOrThrow166 = i107;
                    columnIndexOrThrow180 = i118;
                    columnIndexOrThrow179 = i117;
                    columnIndexOrThrow190 = i124;
                    columnIndexOrThrow189 = i123;
                    columnIndexOrThrow194 = i128;
                    columnIndexOrThrow193 = i127;
                    columnIndexOrThrow203 = i136;
                    columnIndexOrThrow202 = i135;
                    columnIndexOrThrow209 = i142;
                    columnIndexOrThrow208 = i141;
                    columnIndexOrThrow228 = i154;
                    columnIndexOrThrow227 = i153;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.dw.launcher.data.database.dao.ClockConfigDao
    public List<ClockConfig> queryAssetsByParentId(final String parentId) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from t_clock_config where parent_id = ?", 1);
        if (parentId == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, parentId);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "path");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fromAssets");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_en");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screentype");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dialtype");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coordinate_screen_width");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coordinate_screen_height");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_type");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lottie");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_animal_keep_for_last_frame");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_count");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_interval");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_is_customize");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hour_pointer_src");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hour_pointer_x");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hour_pointer_y");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minute_pointer_src");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minute_pointer_x");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minute_pointer_y");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_src");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_x");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_y");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_animal_type");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dot_src");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dot_x");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dot_y");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_pointer_start_animation");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_start_hour");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_start_minute");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_start_second");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_need_jump");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_x");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_y");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_min");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_min_x");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_min_y");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_sec");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_sec");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_sec_x");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_sec_y");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_time_arc_show");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_arc_type");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_arc_center_x");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_arc_center_y");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_am_or_pm");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_and_pm_src");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_or_pm_x");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_or_pm_y");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_ampm_placeholer");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_digital_start_animation");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "digital_start_hour");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "digital_start_minute");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "digital_start_second");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_src");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_x");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_y");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_date_arc_show");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_arc_type");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_arc_center_x");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_arc_center_y");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_year_splt_src");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_month_splt_src");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_day_splt_src");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_year");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "year_digits_type");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_month");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_type");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_src");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_month");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data_month_num");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_x");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_y");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_day");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_day");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data_day_num");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_x");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_y");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_src");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_type");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_src");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_num_src");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_x");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_y");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_power");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_0_src");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_1_src");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_2_src");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_3_src");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_4_src");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_5_src");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_6_src");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_7_src");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_8_src");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_9_src");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_10_src");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_x");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_y");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_charge");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_0_src");
                int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_1_src");
                int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_2_src");
                int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_3_src");
                int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_4_src");
                int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_5_src");
                int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_6_src");
                int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_7_src");
                int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_8_src");
                int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_9_src");
                int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_10_src");
                int columnIndexOrThrow119 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_power_num");
                int columnIndexOrThrow120 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_num_src");
                int columnIndexOrThrow121 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_sign_src");
                int columnIndexOrThrow122 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_show_type");
                int columnIndexOrThrow123 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_num_x");
                int columnIndexOrThrow124 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_num_y");
                int columnIndexOrThrow125 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_action");
                int columnIndexOrThrow126 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_action_1");
                int columnIndexOrThrow127 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_count");
                int columnIndexOrThrow128 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_x");
                int columnIndexOrThrow129 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_y");
                int columnIndexOrThrow130 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_action_2");
                int columnIndexOrThrow131 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_count");
                int columnIndexOrThrow132 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_x");
                int columnIndexOrThrow133 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_y");
                int columnIndexOrThrow134 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_action_3");
                int columnIndexOrThrow135 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_count");
                int columnIndexOrThrow136 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_x");
                int columnIndexOrThrow137 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_y");
                int columnIndexOrThrow138 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_interval");
                int columnIndexOrThrow139 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_overall_animation");
                int columnIndexOrThrow140 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "overall_animation_x");
                int columnIndexOrThrow141 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "overall_animation_y");
                int columnIndexOrThrow142 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_1");
                int columnIndexOrThrow143 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_x");
                int columnIndexOrThrow144 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_y");
                int columnIndexOrThrow145 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_width");
                int columnIndexOrThrow146 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_height");
                int columnIndexOrThrow147 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_2");
                int columnIndexOrThrow148 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_x");
                int columnIndexOrThrow149 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_y");
                int columnIndexOrThrow150 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_width");
                int columnIndexOrThrow151 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_height");
                int columnIndexOrThrow152 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_3");
                int columnIndexOrThrow153 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_x");
                int columnIndexOrThrow154 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_y");
                int columnIndexOrThrow155 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_width");
                int columnIndexOrThrow156 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_height");
                int columnIndexOrThrow157 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_4");
                int columnIndexOrThrow158 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_x");
                int columnIndexOrThrow159 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_y");
                int columnIndexOrThrow160 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_width");
                int columnIndexOrThrow161 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_height");
                int columnIndexOrThrow162 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_lunar");
                int columnIndexOrThrow163 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_src");
                int columnIndexOrThrow164 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_x");
                int columnIndexOrThrow165 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_y");
                int columnIndexOrThrow166 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_heart");
                int columnIndexOrThrow167 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_src");
                int columnIndexOrThrow168 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_x");
                int columnIndexOrThrow169 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_y");
                int columnIndexOrThrow170 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_src");
                int columnIndexOrThrow171 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_type");
                int columnIndexOrThrow172 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_end_src");
                int columnIndexOrThrow173 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_show_type");
                int columnIndexOrThrow174 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_x");
                int columnIndexOrThrow175 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_y");
                int columnIndexOrThrow176 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_heart_arc_show");
                int columnIndexOrThrow177 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_arc_type");
                int columnIndexOrThrow178 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_arc_center_x");
                int columnIndexOrThrow179 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_arc_center_y");
                int columnIndexOrThrow180 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_pressure");
                int columnIndexOrThrow181 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_src");
                int columnIndexOrThrow182 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_x");
                int columnIndexOrThrow183 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_y");
                int columnIndexOrThrow184 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_num_src");
                int columnIndexOrThrow185 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_num_x");
                int columnIndexOrThrow186 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_num_y");
                int columnIndexOrThrow187 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_show_type");
                int columnIndexOrThrow188 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_splt_src");
                int columnIndexOrThrow189 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_step");
                int columnIndexOrThrow190 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_src");
                int columnIndexOrThrow191 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_follow_num");
                int columnIndexOrThrow192 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_x");
                int columnIndexOrThrow193 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_y");
                int columnIndexOrThrow194 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_src");
                int columnIndexOrThrow195 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_type");
                int columnIndexOrThrow196 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_show_type");
                int columnIndexOrThrow197 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_x");
                int columnIndexOrThrow198 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_y");
                int columnIndexOrThrow199 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_end_src");
                int columnIndexOrThrow200 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_step_progress");
                int columnIndexOrThrow201 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_progress_x");
                int columnIndexOrThrow202 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_progress_y");
                int columnIndexOrThrow203 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_progress_src");
                int columnIndexOrThrow204 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_step_arc_show");
                int columnIndexOrThrow205 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_arc_type");
                int columnIndexOrThrow206 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_arc_center_x");
                int columnIndexOrThrow207 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_arc_center_y");
                int columnIndexOrThrow208 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_kcal");
                int columnIndexOrThrow209 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_src");
                int columnIndexOrThrow210 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_x");
                int columnIndexOrThrow211 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_y");
                int columnIndexOrThrow212 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_src");
                int columnIndexOrThrow213 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_type");
                int columnIndexOrThrow214 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_show_type");
                int columnIndexOrThrow215 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_x");
                int columnIndexOrThrow216 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_y");
                int columnIndexOrThrow217 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_end_src");
                int columnIndexOrThrow218 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_km");
                int columnIndexOrThrow219 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_src");
                int columnIndexOrThrow220 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_x");
                int columnIndexOrThrow221 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_y");
                int columnIndexOrThrow222 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_src");
                int columnIndexOrThrow223 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_comma_src");
                int columnIndexOrThrow224 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_type");
                int columnIndexOrThrow225 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_show_type");
                int columnIndexOrThrow226 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_x");
                int columnIndexOrThrow227 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_y");
                int columnIndexOrThrow228 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_end_src");
                int columnIndexOrThrow229 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_weather");
                int columnIndexOrThrow230 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_temperature");
                int columnIndexOrThrow231 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_show_type");
                int columnIndexOrThrow232 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_num_type");
                int columnIndexOrThrow233 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_x");
                int columnIndexOrThrow234 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_y");
                int columnIndexOrThrow235 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_x_2");
                int columnIndexOrThrow236 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_y_2");
                int columnIndexOrThrow237 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_now_tem");
                int columnIndexOrThrow238 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_show_type");
                int columnIndexOrThrow239 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_x");
                int columnIndexOrThrow240 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_y");
                int columnIndexOrThrow241 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_num_src");
                int columnIndexOrThrow242 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_sub_src");
                int columnIndexOrThrow243 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_sign_src");
                int columnIndexOrThrow244 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_splt_src");
                int columnIndexOrThrow245 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_diagram");
                int columnIndexOrThrow246 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "diagram_x");
                int columnIndexOrThrow247 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "diagram_y");
                int columnIndexOrThrow248 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "showsignal");
                int columnIndexOrThrow249 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_signal");
                int columnIndexOrThrow250 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "signal_src");
                int columnIndexOrThrow251 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "signal_x");
                int columnIndexOrThrow252 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "signal_y");
                int columnIndexOrThrow253 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_user_name");
                int columnIndexOrThrow254 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_show_type");
                int columnIndexOrThrow255 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_x");
                int columnIndexOrThrow256 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_y");
                int columnIndexOrThrow257 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_operator");
                int columnIndexOrThrow258 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "operator_show_type");
                int columnIndexOrThrow259 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "operator_x");
                int columnIndexOrThrow260 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "operator_y");
                int columnIndexOrThrow261 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_call");
                int columnIndexOrThrow262 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_call_src");
                int columnIndexOrThrow263 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_call_x");
                int columnIndexOrThrow264 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_call_y");
                int columnIndexOrThrow265 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sms");
                int columnIndexOrThrow266 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sms_src");
                int columnIndexOrThrow267 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sms_x");
                int columnIndexOrThrow268 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sms_y");
                int columnIndexOrThrow269 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_heart");
                int columnIndexOrThrow270 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_our_heart");
                int columnIndexOrThrow271 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_heart_src");
                int columnIndexOrThrow272 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_heart_x");
                int columnIndexOrThrow273 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_heart_y");
                int columnIndexOrThrow274 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_step");
                int columnIndexOrThrow275 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_step_src");
                int columnIndexOrThrow276 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_step_x");
                int columnIndexOrThrow277 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_step_y");
                int columnIndexOrThrow278 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_wechat");
                int columnIndexOrThrow279 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_wechat_src");
                int columnIndexOrThrow280 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_wechat_x");
                int columnIndexOrThrow281 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_wechat_y");
                int columnIndexOrThrow282 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_alipay");
                int columnIndexOrThrow283 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alipay_src");
                int columnIndexOrThrow284 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alipay_x");
                int columnIndexOrThrow285 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alipay_y");
                int columnIndexOrThrow286 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_stopwatch");
                int columnIndexOrThrow287 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_stopwatch_src");
                int columnIndexOrThrow288 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_stopwatch_x");
                int columnIndexOrThrow289 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_stopwatch_y");
                int columnIndexOrThrow290 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_weather");
                int columnIndexOrThrow291 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calo");
                int columnIndexOrThrow292 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calo_src");
                int columnIndexOrThrow293 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calo_x");
                int columnIndexOrThrow294 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calo_y");
                int columnIndexOrThrow295 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temprature_src");
                int columnIndexOrThrow296 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_camera");
                int columnIndexOrThrow297 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_camera_src");
                int columnIndexOrThrow298 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_camera_x");
                int columnIndexOrThrow299 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_camera_y");
                int columnIndexOrThrow300 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sos");
                int columnIndexOrThrow301 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sos_src");
                int columnIndexOrThrow302 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sos_x");
                int columnIndexOrThrow303 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sos_y");
                int columnIndexOrThrow304 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_special_1");
                int columnIndexOrThrow305 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_1_src");
                int columnIndexOrThrow306 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_1_position");
                int columnIndexOrThrow307 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_x");
                int columnIndexOrThrow308 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_y");
                int columnIndexOrThrow309 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_multiple_change");
                int columnIndexOrThrow310 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_lunar_year");
                int columnIndexOrThrow311 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_day_splt_src");
                int columnIndexOrThrow312 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_month_splt_src");
                int columnIndexOrThrow313 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_year_splt_src");
                int columnIndexOrThrow314 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_src");
                int columnIndexOrThrow315 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pm_src");
                int columnIndexOrThrow316 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_alarm");
                int columnIndexOrThrow317 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alarm_src");
                int columnIndexOrThrow318 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alarm_x");
                int columnIndexOrThrow319 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alarm_y");
                int columnIndexOrThrow320 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_btn_change");
                int columnIndexOrThrow321 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_btn_index");
                int columnIndexOrThrow322 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_music");
                int columnIndexOrThrow323 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_music_src");
                int columnIndexOrThrow324 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_music_x");
                int columnIndexOrThrow325 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_music_y");
                int columnIndexOrThrow326 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_dynamic_change");
                int columnIndexOrThrow327 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "level");
                int columnIndexOrThrow328 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parent_id");
                int columnIndexOrThrow329 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_id");
                int columnIndexOrThrow330 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "change_starttime");
                int columnIndexOrThrow331 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "change_endtime");
                int columnIndexOrThrow332 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_weather_src");
                int columnIndexOrThrow333 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_weather_x");
                int columnIndexOrThrow334 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_weather_y");
                int columnIndexOrThrow335 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calories");
                int columnIndexOrThrow336 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calories_src");
                int columnIndexOrThrow337 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calories_x");
                int columnIndexOrThrow338 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calories_y");
                int columnIndexOrThrow339 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_compass");
                int columnIndexOrThrow340 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_src");
                int columnIndexOrThrow341 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_2_src");
                int columnIndexOrThrow342 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_x");
                int columnIndexOrThrow343 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_y");
                int columnIndexOrThrow344 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_setting");
                int columnIndexOrThrow345 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_setting_src");
                int columnIndexOrThrow346 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_setting_x");
                int columnIndexOrThrow347 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_setting_y");
                int columnIndexOrThrow348 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_click_change");
                int columnIndexOrThrow349 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_id_is_current");
                int columnIndexOrThrow350 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_show_detail_degree");
                int columnIndexOrThrow351 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_src");
                int columnIndexOrThrow352 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_x");
                int columnIndexOrThrow353 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_y");
                int columnIndexOrThrow354 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_2_src");
                int columnIndexOrThrow355 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_2_x");
                int columnIndexOrThrow356 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_2_y");
                int columnIndexOrThrow357 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_3_src");
                int columnIndexOrThrow358 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_3_x");
                int columnIndexOrThrow359 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_3_y");
                int columnIndexOrThrow360 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_src");
                int columnIndexOrThrow361 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_x");
                int columnIndexOrThrow362 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_y");
                int columnIndexOrThrow363 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_unit");
                int columnIndexOrThrow364 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_1_src");
                int columnIndexOrThrow365 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_1_x");
                int columnIndexOrThrow366 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_1_y");
                int columnIndexOrThrow367 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_2_src");
                int columnIndexOrThrow368 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_2_x");
                int columnIndexOrThrow369 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_2_y");
                int columnIndexOrThrow370 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_3_src");
                int columnIndexOrThrow371 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_3_x");
                int columnIndexOrThrow372 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_3_y");
                int columnIndexOrThrow373 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_connect_animation");
                int columnIndexOrThrow374 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connect_animation_x");
                int columnIndexOrThrow375 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connect_animation_y");
                int columnIndexOrThrow376 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connect_animation_count");
                int columnIndexOrThrow377 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_state");
                int columnIndexOrThrow378 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state_x");
                int columnIndexOrThrow379 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state_y");
                int columnIndexOrThrow380 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_cut_position");
                int columnIndexOrThrow381 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_cut_position");
                int columnIndexOrThrow382 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_cut_position");
                int columnIndexOrThrow383 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_googleplay");
                int columnIndexOrThrow384 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_googleplay_src");
                int columnIndexOrThrow385 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_googleplay_x");
                int columnIndexOrThrow386 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_googleplay_y");
                int columnIndexOrThrow387 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_month_2");
                int columnIndexOrThrow388 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_type_2");
                int columnIndexOrThrow389 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_src_2");
                int columnIndexOrThrow390 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_x_2");
                int columnIndexOrThrow391 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_y_2");
                int columnIndexOrThrow392 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_new");
                int columnIndexOrThrow393 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_hour_ten_src");
                int columnIndexOrThrow394 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_hour_src");
                int columnIndexOrThrow395 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_min_ten_src");
                int columnIndexOrThrow396 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_min_src");
                int columnIndexOrThrow397 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_kcal_progress");
                int columnIndexOrThrow398 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_progress_x");
                int columnIndexOrThrow399 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_progress_y");
                int columnIndexOrThrow400 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_progress_src");
                int columnIndexOrThrow401 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_kcal_arc_show");
                int columnIndexOrThrow402 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_arc_type");
                int columnIndexOrThrow403 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_arc_center_x");
                int columnIndexOrThrow404 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_arc_center_y");
                int columnIndexOrThrow405 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_power_arc_show");
                int columnIndexOrThrow406 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_arc_type");
                int columnIndexOrThrow407 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_arc_center_x");
                int columnIndexOrThrow408 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_arc_center_y");
                int columnIndexOrThrow409 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_timer");
                int columnIndexOrThrow410 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_timer_src");
                int columnIndexOrThrow411 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_timer_x");
                int columnIndexOrThrow412 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_timer_y");
                int columnIndexOrThrow413 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sleep");
                int columnIndexOrThrow414 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sleep_src");
                int columnIndexOrThrow415 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sleep_x");
                int columnIndexOrThrow416 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sleep_y");
                int columnIndexOrThrow417 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_bloodpressure");
                int columnIndexOrThrow418 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_bloodpressure_src");
                int columnIndexOrThrow419 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_bloodpressure_x");
                int columnIndexOrThrow420 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_bloodpressure_y");
                int columnIndexOrThrow421 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sport_record");
                int columnIndexOrThrow422 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sport_record_src");
                int columnIndexOrThrow423 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sport_record_x");
                int columnIndexOrThrow424 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sport_record_y");
                int columnIndexOrThrow425 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lottie_hierarchy");
                int columnIndexOrThrow426 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_heart_progress");
                int columnIndexOrThrow427 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_progress_x");
                int columnIndexOrThrow428 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_progress_y");
                int columnIndexOrThrow429 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_progress_src");
                int columnIndexOrThrow430 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calculator");
                int columnIndexOrThrow431 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calculator_src");
                int columnIndexOrThrow432 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calculator_x");
                int columnIndexOrThrow433 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calculator_y");
                int columnIndexOrThrow434 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_drag_3d");
                int columnIndexOrThrow435 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_HourTen_Position");
                int columnIndexOrThrow436 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_HourGe_Position");
                int columnIndexOrThrow437 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_HourTen_Position");
                int columnIndexOrThrow438 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_HourGe_Position");
                int columnIndexOrThrow439 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_HourTen_Position");
                int columnIndexOrThrow440 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_HourGe_Position");
                int columnIndexOrThrow441 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_MinTen_Position");
                int columnIndexOrThrow442 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_MinGe_Position");
                int columnIndexOrThrow443 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_MinTen_Position");
                int columnIndexOrThrow444 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_MinGe_Position");
                int columnIndexOrThrow445 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_MinTen_Position");
                int columnIndexOrThrow446 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_MinGe_Position");
                int columnIndexOrThrow447 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_day");
                int columnIndexOrThrow448 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_day_x");
                int columnIndexOrThrow449 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_day_y");
                int columnIndexOrThrow450 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_now_tem_arc_show");
                int columnIndexOrThrow451 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_arc_type");
                int columnIndexOrThrow452 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_arc_center_x");
                int columnIndexOrThrow453 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_arc_center_y");
                int columnIndexOrThrow454 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_km_progress");
                int columnIndexOrThrow455 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_progress_x");
                int columnIndexOrThrow456 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_progress_y");
                int columnIndexOrThrow457 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_progress_src");
                int columnIndexOrThrow458 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_km_arc_show");
                int columnIndexOrThrow459 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_arc_type");
                int columnIndexOrThrow460 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_arc_center_x");
                int columnIndexOrThrow461 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_arc_center_y");
                int columnIndexOrThrow462 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_rotate");
                int columnIndexOrThrow463 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_rotate_degree");
                int columnIndexOrThrow464 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_rotate");
                int columnIndexOrThrow465 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_rotate_degree");
                int columnIndexOrThrow466 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_oxygen");
                int columnIndexOrThrow467 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_src");
                int columnIndexOrThrow468 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_x");
                int columnIndexOrThrow469 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_y");
                int columnIndexOrThrow470 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_num_src");
                int columnIndexOrThrow471 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_sign_src");
                int columnIndexOrThrow472 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_show_type");
                int columnIndexOrThrow473 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_num_x");
                int columnIndexOrThrow474 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_num_y");
                int columnIndexOrThrow475 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_change_counter");
                int columnIndexOrThrow476 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src_2");
                int columnIndexOrThrow477 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src_2");
                int columnIndexOrThrow478 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src_2");
                int columnIndexOrThrow479 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src_2");
                int columnIndexOrThrow480 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src_2");
                int columnIndexOrThrow481 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src_3");
                int columnIndexOrThrow482 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src_3");
                int columnIndexOrThrow483 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src_3");
                int columnIndexOrThrow484 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src_3");
                int columnIndexOrThrow485 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src_3");
                int columnIndexOrThrow486 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src_4");
                int columnIndexOrThrow487 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src_4");
                int columnIndexOrThrow488 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src_4");
                int columnIndexOrThrow489 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src_4");
                int columnIndexOrThrow490 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src_4");
                int columnIndexOrThrow491 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_rotate");
                int columnIndexOrThrow492 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_rotate_degree");
                int columnIndexOrThrow493 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_hour");
                int columnIndexOrThrow494 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_hour_src");
                int columnIndexOrThrow495 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_hour_x");
                int columnIndexOrThrow496 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_hour_y");
                int columnIndexOrThrow497 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_min");
                int columnIndexOrThrow498 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_min_src");
                int columnIndexOrThrow499 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_min_x");
                int columnIndexOrThrow500 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_min_y");
                int columnIndexOrThrow501 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_scale");
                int columnIndexOrThrow502 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_compass_num");
                int columnIndexOrThrow503 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_src");
                int columnIndexOrThrow504 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_show_type");
                int columnIndexOrThrow505 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_x");
                int columnIndexOrThrow506 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_y");
                int columnIndexOrThrow507 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_src_prefix");
                int columnIndexOrThrow508 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_src_sign");
                int columnIndexOrThrow509 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_oxygen");
                int columnIndexOrThrow510 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_oxygen_src");
                int columnIndexOrThrow511 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_oxygen_x");
                int columnIndexOrThrow512 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_oxygen_y");
                int columnIndexOrThrow513 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calendar");
                int columnIndexOrThrow514 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calendar_src");
                int columnIndexOrThrow515 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calendar_x");
                int columnIndexOrThrow516 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calendar_y");
                int columnIndexOrThrow517 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_compass");
                int columnIndexOrThrow518 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_compass_src");
                int columnIndexOrThrow519 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_compass_x");
                int columnIndexOrThrow520 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_compass_y");
                int columnIndexOrThrow521 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_disable_scale");
                int columnIndexOrThrow522 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_chinse_time");
                int columnIndexOrThrow523 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chinse_time_src");
                int columnIndexOrThrow524 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chinse_time_x");
                int columnIndexOrThrow525 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chinse_time_y");
                int columnIndexOrThrow526 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_photo");
                int columnIndexOrThrow527 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_photo_src");
                int columnIndexOrThrow528 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_photo_x");
                int columnIndexOrThrow529 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_photo_y");
                int columnIndexOrThrow530 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_contact");
                int columnIndexOrThrow531 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_contact_src");
                int columnIndexOrThrow532 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_contact_x");
                int columnIndexOrThrow533 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_contact_y");
                int columnIndexOrThrow534 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_rotate");
                int columnIndexOrThrow535 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_rotate_degree");
                int columnIndexOrThrow536 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_power_progress");
                int columnIndexOrThrow537 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_progress_src");
                int columnIndexOrThrow538 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_progress_x");
                int columnIndexOrThrow539 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_progress_y");
                int columnIndexOrThrow540 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_src");
                int columnIndexOrThrow541 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_src_x");
                int columnIndexOrThrow542 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_src_y");
                int columnIndexOrThrow543 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_type");
                int columnIndexOrThrow544 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_keep_number_length");
                int columnIndexOrThrow545 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_keep_number_length");
                int columnIndexOrThrow546 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_keep_number_length");
                int columnIndexOrThrow547 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_rotate");
                int columnIndexOrThrow548 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_rotate_degree");
                int columnIndexOrThrow549 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_style");
                int columnIndexOrThrow550 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_style_src");
                int columnIndexOrThrow551 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_style_x");
                int columnIndexOrThrow552 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_style_y");
                int columnIndexOrThrow553 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_sec");
                int columnIndexOrThrow554 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_sec_src");
                int columnIndexOrThrow555 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_sec_x");
                int columnIndexOrThrow556 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_sec_y");
                int columnIndexOrThrow557 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_oxygen_arc_show");
                int columnIndexOrThrow558 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_arc_type");
                int columnIndexOrThrow559 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_arc_center_x");
                int columnIndexOrThrow560 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_arc_center_y");
                int columnIndexOrThrow561 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_oxygen_progress");
                int columnIndexOrThrow562 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_progress_src");
                int columnIndexOrThrow563 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_progress_x");
                int columnIndexOrThrow564 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_progress_y");
                int columnIndexOrThrow565 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_week_donts");
                int columnIndexOrThrow566 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_donts_src");
                int columnIndexOrThrow567 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_donts_x");
                int columnIndexOrThrow568 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_donts_y");
                int columnIndexOrThrow569 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_flashlight");
                int columnIndexOrThrow570 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flashlight_src");
                int columnIndexOrThrow571 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flashlight_x");
                int columnIndexOrThrow572 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flashlight_y");
                int i = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    ClockConfig clockConfig = new ClockConfig();
                    clockConfig.setPath(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                    clockConfig.setFromAssets(cursorQuery.getInt(columnIndexOrThrow2) != 0);
                    clockConfig.setId(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    clockConfig.setName(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    clockConfig.setName_en(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    clockConfig.setScreentype(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    clockConfig.setDialtype(cursorQuery.getInt(columnIndexOrThrow7));
                    clockConfig.setCoordinate_screen_width(cursorQuery.getInt(columnIndexOrThrow8));
                    clockConfig.setCoordinate_screen_height(cursorQuery.getInt(columnIndexOrThrow9));
                    clockConfig.setBg_type(cursorQuery.getInt(columnIndexOrThrow10));
                    clockConfig.setVideo(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    clockConfig.setLottie(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    int i2 = columnIndexOrThrow10;
                    int i3 = i;
                    clockConfig.setBg_animal_keep_for_last_frame(cursorQuery.getInt(i3));
                    int i4 = columnIndexOrThrow14;
                    int i5 = columnIndexOrThrow11;
                    clockConfig.setBg_count(cursorQuery.getInt(i4));
                    int i6 = columnIndexOrThrow15;
                    clockConfig.setBg_interval(cursorQuery.isNull(i6) ? null : cursorQuery.getString(i6));
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    clockConfig.setBg_is_customize(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    clockConfig.setHour_pointer_src(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                    columnIndexOrThrow15 = i6;
                    int i7 = columnIndexOrThrow18;
                    clockConfig.setHour_pointer_x(cursorQuery.getInt(i7));
                    columnIndexOrThrow18 = i7;
                    int i8 = columnIndexOrThrow19;
                    clockConfig.setHour_pointer_y(cursorQuery.getInt(i8));
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    clockConfig.setMinute_pointer_src(cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20));
                    columnIndexOrThrow19 = i8;
                    int i9 = columnIndexOrThrow21;
                    clockConfig.setMinute_pointer_x(cursorQuery.getInt(i9));
                    columnIndexOrThrow21 = i9;
                    int i10 = columnIndexOrThrow22;
                    clockConfig.setMinute_pointer_y(cursorQuery.getInt(i10));
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    clockConfig.setSecond_pointer_src(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    columnIndexOrThrow22 = i10;
                    int i11 = columnIndexOrThrow24;
                    clockConfig.setSecond_pointer_type(cursorQuery.getInt(i11));
                    columnIndexOrThrow24 = i11;
                    int i12 = columnIndexOrThrow25;
                    clockConfig.setSecond_pointer_x(cursorQuery.getInt(i12));
                    columnIndexOrThrow25 = i12;
                    int i13 = columnIndexOrThrow26;
                    clockConfig.setSecond_pointer_y(cursorQuery.getInt(i13));
                    columnIndexOrThrow26 = i13;
                    int i14 = columnIndexOrThrow27;
                    clockConfig.setSecond_pointer_animal_type(cursorQuery.getInt(i14));
                    columnIndexOrThrow28 = columnIndexOrThrow28;
                    clockConfig.setDot_src(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    columnIndexOrThrow27 = i14;
                    int i15 = columnIndexOrThrow29;
                    clockConfig.setDot_x(cursorQuery.getInt(i15));
                    columnIndexOrThrow29 = i15;
                    int i16 = columnIndexOrThrow30;
                    clockConfig.setDot_y(cursorQuery.getInt(i16));
                    columnIndexOrThrow30 = i16;
                    int i17 = columnIndexOrThrow31;
                    clockConfig.setShow_pointer_start_animation(cursorQuery.getInt(i17));
                    columnIndexOrThrow31 = i17;
                    int i18 = columnIndexOrThrow32;
                    clockConfig.setPointer_start_hour(cursorQuery.getInt(i18));
                    columnIndexOrThrow32 = i18;
                    int i19 = columnIndexOrThrow33;
                    clockConfig.setPointer_start_minute(cursorQuery.getInt(i19));
                    columnIndexOrThrow33 = i19;
                    int i20 = columnIndexOrThrow34;
                    clockConfig.setPointer_start_second(cursorQuery.getInt(i20));
                    columnIndexOrThrow35 = columnIndexOrThrow35;
                    clockConfig.setTime_hour_src(cursorQuery.isNull(columnIndexOrThrow35) ? null : cursorQuery.getString(columnIndexOrThrow35));
                    columnIndexOrThrow36 = columnIndexOrThrow36;
                    clockConfig.setTime_min_src(cursorQuery.isNull(columnIndexOrThrow36) ? null : cursorQuery.getString(columnIndexOrThrow36));
                    columnIndexOrThrow37 = columnIndexOrThrow37;
                    clockConfig.setTime_sec_src(cursorQuery.isNull(columnIndexOrThrow37) ? null : cursorQuery.getString(columnIndexOrThrow37));
                    columnIndexOrThrow38 = columnIndexOrThrow38;
                    clockConfig.setTime_splt_src(cursorQuery.isNull(columnIndexOrThrow38) ? null : cursorQuery.getString(columnIndexOrThrow38));
                    columnIndexOrThrow39 = columnIndexOrThrow39;
                    clockConfig.setTime_splt_2_src(cursorQuery.isNull(columnIndexOrThrow39) ? null : cursorQuery.getString(columnIndexOrThrow39));
                    columnIndexOrThrow34 = i20;
                    int i21 = columnIndexOrThrow40;
                    clockConfig.setTime_splt_need_jump(cursorQuery.getInt(i21));
                    columnIndexOrThrow40 = i21;
                    int i22 = columnIndexOrThrow41;
                    clockConfig.setTime_x(cursorQuery.getInt(i22));
                    columnIndexOrThrow41 = i22;
                    int i23 = columnIndexOrThrow42;
                    clockConfig.setTime_y(cursorQuery.getInt(i23));
                    columnIndexOrThrow42 = i23;
                    int i24 = columnIndexOrThrow43;
                    clockConfig.setNeed_reset_min(cursorQuery.getInt(i24));
                    columnIndexOrThrow43 = i24;
                    int i25 = columnIndexOrThrow44;
                    clockConfig.setReset_min_x(cursorQuery.getInt(i25));
                    columnIndexOrThrow44 = i25;
                    int i26 = columnIndexOrThrow45;
                    clockConfig.setReset_min_y(cursorQuery.getInt(i26));
                    columnIndexOrThrow45 = i26;
                    int i27 = columnIndexOrThrow46;
                    clockConfig.setShow_sec(cursorQuery.getInt(i27));
                    columnIndexOrThrow46 = i27;
                    int i28 = columnIndexOrThrow47;
                    clockConfig.setNeed_reset_sec(cursorQuery.getInt(i28));
                    columnIndexOrThrow47 = i28;
                    int i29 = columnIndexOrThrow48;
                    clockConfig.setReset_sec_x(cursorQuery.getInt(i29));
                    columnIndexOrThrow48 = i29;
                    int i30 = columnIndexOrThrow49;
                    clockConfig.setReset_sec_y(cursorQuery.getInt(i30));
                    columnIndexOrThrow49 = i30;
                    int i31 = columnIndexOrThrow50;
                    clockConfig.setOpen_time_arc_show(cursorQuery.getInt(i31));
                    columnIndexOrThrow50 = i31;
                    int i32 = columnIndexOrThrow51;
                    clockConfig.setTime_arc_type(cursorQuery.getInt(i32));
                    columnIndexOrThrow51 = i32;
                    int i33 = columnIndexOrThrow52;
                    clockConfig.setTime_arc_center_x(cursorQuery.getInt(i33));
                    columnIndexOrThrow52 = i33;
                    int i34 = columnIndexOrThrow53;
                    clockConfig.setTime_arc_center_y(cursorQuery.getInt(i34));
                    columnIndexOrThrow53 = i34;
                    int i35 = columnIndexOrThrow54;
                    clockConfig.setShow_am_or_pm(cursorQuery.getInt(i35));
                    int i36 = columnIndexOrThrow55;
                    clockConfig.setAm_and_pm_src(cursorQuery.isNull(i36) ? null : cursorQuery.getString(i36));
                    int i37 = columnIndexOrThrow56;
                    clockConfig.setAm_or_pm_x(cursorQuery.getInt(i37));
                    columnIndexOrThrow56 = i37;
                    int i38 = columnIndexOrThrow57;
                    clockConfig.setAm_or_pm_y(cursorQuery.getInt(i38));
                    columnIndexOrThrow57 = i38;
                    int i39 = columnIndexOrThrow58;
                    clockConfig.setShow_ampm_placeholer(cursorQuery.getInt(i39));
                    columnIndexOrThrow58 = i39;
                    int i40 = columnIndexOrThrow59;
                    clockConfig.setShow_digital_start_animation(cursorQuery.getInt(i40));
                    columnIndexOrThrow59 = i40;
                    int i41 = columnIndexOrThrow60;
                    clockConfig.setDigital_start_hour(cursorQuery.getInt(i41));
                    columnIndexOrThrow60 = i41;
                    int i42 = columnIndexOrThrow61;
                    clockConfig.setDigital_start_minute(cursorQuery.getInt(i42));
                    columnIndexOrThrow61 = i42;
                    int i43 = columnIndexOrThrow62;
                    clockConfig.setDigital_start_second(cursorQuery.getInt(i43));
                    int i44 = columnIndexOrThrow63;
                    clockConfig.setDate_src(cursorQuery.isNull(i44) ? null : cursorQuery.getString(i44));
                    int i45 = columnIndexOrThrow64;
                    clockConfig.setDate_x(cursorQuery.getInt(i45));
                    columnIndexOrThrow64 = i45;
                    int i46 = columnIndexOrThrow65;
                    clockConfig.setDate_y(cursorQuery.getInt(i46));
                    columnIndexOrThrow65 = i46;
                    int i47 = columnIndexOrThrow66;
                    clockConfig.setOpen_date_arc_show(cursorQuery.getInt(i47));
                    columnIndexOrThrow66 = i47;
                    int i48 = columnIndexOrThrow67;
                    clockConfig.setDate_arc_type(cursorQuery.getInt(i48));
                    columnIndexOrThrow67 = i48;
                    int i49 = columnIndexOrThrow68;
                    clockConfig.setDate_arc_center_x(cursorQuery.getInt(i49));
                    columnIndexOrThrow68 = i49;
                    int i50 = columnIndexOrThrow69;
                    clockConfig.setDate_arc_center_y(cursorQuery.getInt(i50));
                    columnIndexOrThrow70 = columnIndexOrThrow70;
                    clockConfig.setDate_year_splt_src(cursorQuery.isNull(columnIndexOrThrow70) ? null : cursorQuery.getString(columnIndexOrThrow70));
                    columnIndexOrThrow71 = columnIndexOrThrow71;
                    clockConfig.setDate_month_splt_src(cursorQuery.isNull(columnIndexOrThrow71) ? null : cursorQuery.getString(columnIndexOrThrow71));
                    columnIndexOrThrow72 = columnIndexOrThrow72;
                    clockConfig.setDate_day_splt_src(cursorQuery.isNull(columnIndexOrThrow72) ? null : cursorQuery.getString(columnIndexOrThrow72));
                    columnIndexOrThrow69 = i50;
                    int i51 = columnIndexOrThrow73;
                    clockConfig.setShow_year(cursorQuery.getInt(i51));
                    columnIndexOrThrow73 = i51;
                    int i52 = columnIndexOrThrow74;
                    clockConfig.setYear_digits_type(cursorQuery.getInt(i52));
                    columnIndexOrThrow74 = i52;
                    int i53 = columnIndexOrThrow75;
                    clockConfig.setShow_month(cursorQuery.getInt(i53));
                    columnIndexOrThrow75 = i53;
                    int i54 = columnIndexOrThrow76;
                    clockConfig.setMonth_type(cursorQuery.getInt(i54));
                    columnIndexOrThrow77 = columnIndexOrThrow77;
                    clockConfig.setMonth_src(cursorQuery.isNull(columnIndexOrThrow77) ? null : cursorQuery.getString(columnIndexOrThrow77));
                    columnIndexOrThrow76 = i54;
                    int i55 = columnIndexOrThrow78;
                    clockConfig.setNeed_reset_month(cursorQuery.getInt(i55));
                    int i56 = columnIndexOrThrow79;
                    clockConfig.setData_month_num(cursorQuery.isNull(i56) ? null : cursorQuery.getString(i56));
                    int i57 = columnIndexOrThrow80;
                    clockConfig.setMonth_x(cursorQuery.getInt(i57));
                    columnIndexOrThrow80 = i57;
                    int i58 = columnIndexOrThrow81;
                    clockConfig.setMonth_y(cursorQuery.getInt(i58));
                    columnIndexOrThrow81 = i58;
                    int i59 = columnIndexOrThrow82;
                    clockConfig.setShow_day(cursorQuery.getInt(i59));
                    columnIndexOrThrow82 = i59;
                    int i60 = columnIndexOrThrow83;
                    clockConfig.setNeed_reset_day(cursorQuery.getInt(i60));
                    columnIndexOrThrow84 = columnIndexOrThrow84;
                    clockConfig.setData_day_num(cursorQuery.isNull(columnIndexOrThrow84) ? null : cursorQuery.getString(columnIndexOrThrow84));
                    columnIndexOrThrow83 = i60;
                    int i61 = columnIndexOrThrow85;
                    clockConfig.setDay_x(cursorQuery.getInt(i61));
                    columnIndexOrThrow85 = i61;
                    int i62 = columnIndexOrThrow86;
                    clockConfig.setDay_y(cursorQuery.getInt(i62));
                    columnIndexOrThrow87 = columnIndexOrThrow87;
                    clockConfig.setDay_src(cursorQuery.isNull(columnIndexOrThrow87) ? null : cursorQuery.getString(columnIndexOrThrow87));
                    columnIndexOrThrow86 = i62;
                    int i63 = columnIndexOrThrow88;
                    clockConfig.setDay_type(cursorQuery.getInt(i63));
                    int i64 = columnIndexOrThrow89;
                    clockConfig.setWeek_src(cursorQuery.isNull(i64) ? null : cursorQuery.getString(i64));
                    columnIndexOrThrow90 = columnIndexOrThrow90;
                    clockConfig.setWeek_num_src(cursorQuery.isNull(columnIndexOrThrow90) ? null : cursorQuery.getString(columnIndexOrThrow90));
                    int i65 = columnIndexOrThrow91;
                    clockConfig.setWeek_x(cursorQuery.getInt(i65));
                    columnIndexOrThrow91 = i65;
                    int i66 = columnIndexOrThrow92;
                    clockConfig.setWeek_y(cursorQuery.getInt(i66));
                    columnIndexOrThrow92 = i66;
                    int i67 = columnIndexOrThrow93;
                    clockConfig.setShow_power(cursorQuery.getInt(i67));
                    int i68 = columnIndexOrThrow94;
                    clockConfig.setNormal_0_src(cursorQuery.isNull(i68) ? null : cursorQuery.getString(i68));
                    columnIndexOrThrow95 = columnIndexOrThrow95;
                    clockConfig.setNormal_1_src(cursorQuery.isNull(columnIndexOrThrow95) ? null : cursorQuery.getString(columnIndexOrThrow95));
                    columnIndexOrThrow96 = columnIndexOrThrow96;
                    clockConfig.setNormal_2_src(cursorQuery.isNull(columnIndexOrThrow96) ? null : cursorQuery.getString(columnIndexOrThrow96));
                    columnIndexOrThrow97 = columnIndexOrThrow97;
                    clockConfig.setNormal_3_src(cursorQuery.isNull(columnIndexOrThrow97) ? null : cursorQuery.getString(columnIndexOrThrow97));
                    columnIndexOrThrow98 = columnIndexOrThrow98;
                    clockConfig.setNormal_4_src(cursorQuery.isNull(columnIndexOrThrow98) ? null : cursorQuery.getString(columnIndexOrThrow98));
                    columnIndexOrThrow99 = columnIndexOrThrow99;
                    clockConfig.setNormal_5_src(cursorQuery.isNull(columnIndexOrThrow99) ? null : cursorQuery.getString(columnIndexOrThrow99));
                    columnIndexOrThrow100 = columnIndexOrThrow100;
                    clockConfig.setNormal_6_src(cursorQuery.isNull(columnIndexOrThrow100) ? null : cursorQuery.getString(columnIndexOrThrow100));
                    columnIndexOrThrow101 = columnIndexOrThrow101;
                    clockConfig.setNormal_7_src(cursorQuery.isNull(columnIndexOrThrow101) ? null : cursorQuery.getString(columnIndexOrThrow101));
                    columnIndexOrThrow102 = columnIndexOrThrow102;
                    clockConfig.setNormal_8_src(cursorQuery.isNull(columnIndexOrThrow102) ? null : cursorQuery.getString(columnIndexOrThrow102));
                    columnIndexOrThrow103 = columnIndexOrThrow103;
                    clockConfig.setNormal_9_src(cursorQuery.isNull(columnIndexOrThrow103) ? null : cursorQuery.getString(columnIndexOrThrow103));
                    columnIndexOrThrow104 = columnIndexOrThrow104;
                    clockConfig.setNormal_10_src(cursorQuery.isNull(columnIndexOrThrow104) ? null : cursorQuery.getString(columnIndexOrThrow104));
                    int i69 = columnIndexOrThrow105;
                    clockConfig.setPower_x(cursorQuery.getInt(i69));
                    columnIndexOrThrow105 = i69;
                    int i70 = columnIndexOrThrow106;
                    clockConfig.setPower_y(cursorQuery.getInt(i70));
                    columnIndexOrThrow106 = i70;
                    int i71 = columnIndexOrThrow107;
                    clockConfig.setShow_charge(cursorQuery.getInt(i71));
                    int i72 = columnIndexOrThrow108;
                    clockConfig.setCharge_0_src(cursorQuery.isNull(i72) ? null : cursorQuery.getString(i72));
                    columnIndexOrThrow109 = columnIndexOrThrow109;
                    clockConfig.setCharge_1_src(cursorQuery.isNull(columnIndexOrThrow109) ? null : cursorQuery.getString(columnIndexOrThrow109));
                    columnIndexOrThrow110 = columnIndexOrThrow110;
                    clockConfig.setCharge_2_src(cursorQuery.isNull(columnIndexOrThrow110) ? null : cursorQuery.getString(columnIndexOrThrow110));
                    columnIndexOrThrow111 = columnIndexOrThrow111;
                    clockConfig.setCharge_3_src(cursorQuery.isNull(columnIndexOrThrow111) ? null : cursorQuery.getString(columnIndexOrThrow111));
                    columnIndexOrThrow112 = columnIndexOrThrow112;
                    clockConfig.setCharge_4_src(cursorQuery.isNull(columnIndexOrThrow112) ? null : cursorQuery.getString(columnIndexOrThrow112));
                    columnIndexOrThrow113 = columnIndexOrThrow113;
                    clockConfig.setCharge_5_src(cursorQuery.isNull(columnIndexOrThrow113) ? null : cursorQuery.getString(columnIndexOrThrow113));
                    columnIndexOrThrow114 = columnIndexOrThrow114;
                    clockConfig.setCharge_6_src(cursorQuery.isNull(columnIndexOrThrow114) ? null : cursorQuery.getString(columnIndexOrThrow114));
                    columnIndexOrThrow115 = columnIndexOrThrow115;
                    clockConfig.setCharge_7_src(cursorQuery.isNull(columnIndexOrThrow115) ? null : cursorQuery.getString(columnIndexOrThrow115));
                    columnIndexOrThrow116 = columnIndexOrThrow116;
                    clockConfig.setCharge_8_src(cursorQuery.isNull(columnIndexOrThrow116) ? null : cursorQuery.getString(columnIndexOrThrow116));
                    columnIndexOrThrow117 = columnIndexOrThrow117;
                    clockConfig.setCharge_9_src(cursorQuery.isNull(columnIndexOrThrow117) ? null : cursorQuery.getString(columnIndexOrThrow117));
                    columnIndexOrThrow118 = columnIndexOrThrow118;
                    clockConfig.setCharge_10_src(cursorQuery.isNull(columnIndexOrThrow118) ? null : cursorQuery.getString(columnIndexOrThrow118));
                    int i73 = columnIndexOrThrow119;
                    clockConfig.setShow_power_num(cursorQuery.getInt(i73));
                    int i74 = columnIndexOrThrow120;
                    clockConfig.setPower_num_src(cursorQuery.isNull(i74) ? null : cursorQuery.getString(i74));
                    columnIndexOrThrow121 = columnIndexOrThrow121;
                    clockConfig.setPower_sign_src(cursorQuery.isNull(columnIndexOrThrow121) ? null : cursorQuery.getString(columnIndexOrThrow121));
                    int i75 = columnIndexOrThrow122;
                    clockConfig.setPower_show_type(cursorQuery.getInt(i75));
                    columnIndexOrThrow122 = i75;
                    int i76 = columnIndexOrThrow123;
                    clockConfig.setPower_num_x(cursorQuery.getInt(i76));
                    columnIndexOrThrow123 = i76;
                    int i77 = columnIndexOrThrow124;
                    clockConfig.setPower_num_y(cursorQuery.getInt(i77));
                    columnIndexOrThrow124 = i77;
                    int i78 = columnIndexOrThrow125;
                    clockConfig.setShow_action(cursorQuery.getInt(i78));
                    columnIndexOrThrow125 = i78;
                    int i79 = columnIndexOrThrow126;
                    clockConfig.setOpen_action_1(cursorQuery.getInt(i79));
                    columnIndexOrThrow126 = i79;
                    int i80 = columnIndexOrThrow127;
                    clockConfig.setAction_1_count(cursorQuery.getInt(i80));
                    columnIndexOrThrow127 = i80;
                    int i81 = columnIndexOrThrow128;
                    clockConfig.setAction_1_x(cursorQuery.getInt(i81));
                    columnIndexOrThrow128 = i81;
                    int i82 = columnIndexOrThrow129;
                    clockConfig.setAction_1_y(cursorQuery.getInt(i82));
                    columnIndexOrThrow129 = i82;
                    int i83 = columnIndexOrThrow130;
                    clockConfig.setOpen_action_2(cursorQuery.getInt(i83));
                    columnIndexOrThrow130 = i83;
                    int i84 = columnIndexOrThrow131;
                    clockConfig.setAction_2_count(cursorQuery.getInt(i84));
                    columnIndexOrThrow131 = i84;
                    int i85 = columnIndexOrThrow132;
                    clockConfig.setAction_2_x(cursorQuery.getInt(i85));
                    columnIndexOrThrow132 = i85;
                    int i86 = columnIndexOrThrow133;
                    clockConfig.setAction_2_y(cursorQuery.getInt(i86));
                    columnIndexOrThrow133 = i86;
                    int i87 = columnIndexOrThrow134;
                    clockConfig.setOpen_action_3(cursorQuery.getInt(i87));
                    columnIndexOrThrow134 = i87;
                    int i88 = columnIndexOrThrow135;
                    clockConfig.setAction_3_count(cursorQuery.getInt(i88));
                    columnIndexOrThrow135 = i88;
                    int i89 = columnIndexOrThrow136;
                    clockConfig.setAction_3_x(cursorQuery.getInt(i89));
                    columnIndexOrThrow136 = i89;
                    int i90 = columnIndexOrThrow137;
                    clockConfig.setAction_3_y(cursorQuery.getInt(i90));
                    columnIndexOrThrow137 = i90;
                    int i91 = columnIndexOrThrow138;
                    clockConfig.setAction_interval(cursorQuery.getInt(i91));
                    int i92 = columnIndexOrThrow139;
                    clockConfig.setShow_overall_animation(cursorQuery.isNull(i92) ? null : cursorQuery.getString(i92));
                    int i93 = columnIndexOrThrow140;
                    clockConfig.setOverall_animation_x(cursorQuery.getInt(i93));
                    columnIndexOrThrow140 = i93;
                    int i94 = columnIndexOrThrow141;
                    clockConfig.setOverall_animation_y(cursorQuery.getInt(i94));
                    columnIndexOrThrow142 = columnIndexOrThrow142;
                    clockConfig.setOpen_click_1(cursorQuery.isNull(columnIndexOrThrow142) ? null : cursorQuery.getString(columnIndexOrThrow142));
                    columnIndexOrThrow141 = i94;
                    int i95 = columnIndexOrThrow143;
                    clockConfig.setClick_1_x(cursorQuery.getInt(i95));
                    columnIndexOrThrow143 = i95;
                    int i96 = columnIndexOrThrow144;
                    clockConfig.setClick_1_y(cursorQuery.getInt(i96));
                    columnIndexOrThrow145 = columnIndexOrThrow145;
                    clockConfig.setClick_1_width(cursorQuery.isNull(columnIndexOrThrow145) ? null : cursorQuery.getString(columnIndexOrThrow145));
                    columnIndexOrThrow146 = columnIndexOrThrow146;
                    clockConfig.setClick_1_height(cursorQuery.isNull(columnIndexOrThrow146) ? null : cursorQuery.getString(columnIndexOrThrow146));
                    columnIndexOrThrow147 = columnIndexOrThrow147;
                    clockConfig.setOpen_click_2(cursorQuery.isNull(columnIndexOrThrow147) ? null : cursorQuery.getString(columnIndexOrThrow147));
                    columnIndexOrThrow144 = i96;
                    int i97 = columnIndexOrThrow148;
                    clockConfig.setClick_2_x(cursorQuery.getInt(i97));
                    columnIndexOrThrow148 = i97;
                    int i98 = columnIndexOrThrow149;
                    clockConfig.setClick_2_y(cursorQuery.getInt(i98));
                    columnIndexOrThrow150 = columnIndexOrThrow150;
                    clockConfig.setClick_2_width(cursorQuery.isNull(columnIndexOrThrow150) ? null : cursorQuery.getString(columnIndexOrThrow150));
                    columnIndexOrThrow151 = columnIndexOrThrow151;
                    clockConfig.setClick_2_height(cursorQuery.isNull(columnIndexOrThrow151) ? null : cursorQuery.getString(columnIndexOrThrow151));
                    columnIndexOrThrow152 = columnIndexOrThrow152;
                    clockConfig.setOpen_click_3(cursorQuery.isNull(columnIndexOrThrow152) ? null : cursorQuery.getString(columnIndexOrThrow152));
                    columnIndexOrThrow149 = i98;
                    int i99 = columnIndexOrThrow153;
                    clockConfig.setClick_3_x(cursorQuery.getInt(i99));
                    columnIndexOrThrow153 = i99;
                    int i100 = columnIndexOrThrow154;
                    clockConfig.setClick_3_y(cursorQuery.getInt(i100));
                    columnIndexOrThrow155 = columnIndexOrThrow155;
                    clockConfig.setClick_3_width(cursorQuery.isNull(columnIndexOrThrow155) ? null : cursorQuery.getString(columnIndexOrThrow155));
                    columnIndexOrThrow156 = columnIndexOrThrow156;
                    clockConfig.setClick_3_height(cursorQuery.isNull(columnIndexOrThrow156) ? null : cursorQuery.getString(columnIndexOrThrow156));
                    columnIndexOrThrow157 = columnIndexOrThrow157;
                    clockConfig.setOpen_click_4(cursorQuery.isNull(columnIndexOrThrow157) ? null : cursorQuery.getString(columnIndexOrThrow157));
                    columnIndexOrThrow154 = i100;
                    int i101 = columnIndexOrThrow158;
                    clockConfig.setClick_4_x(cursorQuery.getInt(i101));
                    columnIndexOrThrow158 = i101;
                    int i102 = columnIndexOrThrow159;
                    clockConfig.setClick_4_y(cursorQuery.getInt(i102));
                    columnIndexOrThrow160 = columnIndexOrThrow160;
                    clockConfig.setClick_4_width(cursorQuery.isNull(columnIndexOrThrow160) ? null : cursorQuery.getString(columnIndexOrThrow160));
                    columnIndexOrThrow161 = columnIndexOrThrow161;
                    clockConfig.setClick_4_height(cursorQuery.isNull(columnIndexOrThrow161) ? null : cursorQuery.getString(columnIndexOrThrow161));
                    columnIndexOrThrow159 = i102;
                    int i103 = columnIndexOrThrow162;
                    clockConfig.setShow_lunar(cursorQuery.getInt(i103));
                    int i104 = columnIndexOrThrow163;
                    clockConfig.setLunar_src(cursorQuery.isNull(i104) ? null : cursorQuery.getString(i104));
                    int i105 = columnIndexOrThrow164;
                    clockConfig.setLunar_x(cursorQuery.getInt(i105));
                    columnIndexOrThrow164 = i105;
                    int i106 = columnIndexOrThrow165;
                    clockConfig.setLunar_y(cursorQuery.getInt(i106));
                    columnIndexOrThrow165 = i106;
                    int i107 = columnIndexOrThrow166;
                    clockConfig.setShow_heart(cursorQuery.getInt(i107));
                    int i108 = columnIndexOrThrow167;
                    clockConfig.setHeart_src(cursorQuery.isNull(i108) ? null : cursorQuery.getString(i108));
                    int i109 = columnIndexOrThrow168;
                    clockConfig.setHeart_x(cursorQuery.getInt(i109));
                    columnIndexOrThrow168 = i109;
                    int i110 = columnIndexOrThrow169;
                    clockConfig.setHeart_y(cursorQuery.getInt(i110));
                    columnIndexOrThrow170 = columnIndexOrThrow170;
                    clockConfig.setHeart_num_src(cursorQuery.isNull(columnIndexOrThrow170) ? null : cursorQuery.getString(columnIndexOrThrow170));
                    columnIndexOrThrow171 = columnIndexOrThrow171;
                    clockConfig.setHeart_num_type(cursorQuery.isNull(columnIndexOrThrow171) ? null : cursorQuery.getString(columnIndexOrThrow171));
                    columnIndexOrThrow172 = columnIndexOrThrow172;
                    clockConfig.setHeart_end_src(cursorQuery.isNull(columnIndexOrThrow172) ? null : cursorQuery.getString(columnIndexOrThrow172));
                    columnIndexOrThrow169 = i110;
                    int i111 = columnIndexOrThrow173;
                    clockConfig.setHeart_show_type(cursorQuery.getInt(i111));
                    columnIndexOrThrow173 = i111;
                    int i112 = columnIndexOrThrow174;
                    clockConfig.setHeart_num_x(cursorQuery.getInt(i112));
                    columnIndexOrThrow174 = i112;
                    int i113 = columnIndexOrThrow175;
                    clockConfig.setHeart_num_y(cursorQuery.getInt(i113));
                    columnIndexOrThrow175 = i113;
                    int i114 = columnIndexOrThrow176;
                    clockConfig.setOpen_heart_arc_show(cursorQuery.getInt(i114));
                    columnIndexOrThrow176 = i114;
                    int i115 = columnIndexOrThrow177;
                    clockConfig.setHeart_arc_type(cursorQuery.getInt(i115));
                    columnIndexOrThrow177 = i115;
                    int i116 = columnIndexOrThrow178;
                    clockConfig.setHeart_arc_center_x(cursorQuery.getInt(i116));
                    columnIndexOrThrow178 = i116;
                    int i117 = columnIndexOrThrow179;
                    clockConfig.setHeart_arc_center_y(cursorQuery.getInt(i117));
                    int i118 = columnIndexOrThrow180;
                    clockConfig.setShow_pressure(cursorQuery.isNull(i118) ? null : cursorQuery.getString(i118));
                    columnIndexOrThrow181 = columnIndexOrThrow181;
                    clockConfig.setPressure_src(cursorQuery.isNull(columnIndexOrThrow181) ? null : cursorQuery.getString(columnIndexOrThrow181));
                    int i119 = columnIndexOrThrow182;
                    clockConfig.setPressure_x(cursorQuery.getInt(i119));
                    columnIndexOrThrow182 = i119;
                    int i120 = columnIndexOrThrow183;
                    clockConfig.setPressure_y(cursorQuery.getInt(i120));
                    columnIndexOrThrow184 = columnIndexOrThrow184;
                    clockConfig.setPressure_num_src(cursorQuery.isNull(columnIndexOrThrow184) ? null : cursorQuery.getString(columnIndexOrThrow184));
                    columnIndexOrThrow183 = i120;
                    int i121 = columnIndexOrThrow185;
                    clockConfig.setPressure_num_x(cursorQuery.getInt(i121));
                    columnIndexOrThrow185 = i121;
                    int i122 = columnIndexOrThrow186;
                    clockConfig.setPressure_num_y(cursorQuery.getInt(i122));
                    columnIndexOrThrow187 = columnIndexOrThrow187;
                    clockConfig.setPressure_show_type(cursorQuery.isNull(columnIndexOrThrow187) ? null : cursorQuery.getString(columnIndexOrThrow187));
                    columnIndexOrThrow188 = columnIndexOrThrow188;
                    clockConfig.setPressure_splt_src(cursorQuery.isNull(columnIndexOrThrow188) ? null : cursorQuery.getString(columnIndexOrThrow188));
                    columnIndexOrThrow186 = i122;
                    int i123 = columnIndexOrThrow189;
                    clockConfig.setShow_step(cursorQuery.getInt(i123));
                    int i124 = columnIndexOrThrow190;
                    clockConfig.setStep_src(cursorQuery.isNull(i124) ? null : cursorQuery.getString(i124));
                    int i125 = columnIndexOrThrow191;
                    clockConfig.setStep_follow_num(cursorQuery.getInt(i125));
                    columnIndexOrThrow191 = i125;
                    int i126 = columnIndexOrThrow192;
                    clockConfig.setStep_x(cursorQuery.getInt(i126));
                    columnIndexOrThrow192 = i126;
                    int i127 = columnIndexOrThrow193;
                    clockConfig.setStep_y(cursorQuery.getInt(i127));
                    int i128 = columnIndexOrThrow194;
                    clockConfig.setStep_num_src(cursorQuery.isNull(i128) ? null : cursorQuery.getString(i128));
                    int i129 = columnIndexOrThrow195;
                    clockConfig.setStep_num_type(cursorQuery.getInt(i129));
                    columnIndexOrThrow195 = i129;
                    int i130 = columnIndexOrThrow196;
                    clockConfig.setStep_show_type(cursorQuery.getInt(i130));
                    columnIndexOrThrow196 = i130;
                    int i131 = columnIndexOrThrow197;
                    clockConfig.setStep_num_x(cursorQuery.getInt(i131));
                    columnIndexOrThrow197 = i131;
                    int i132 = columnIndexOrThrow198;
                    clockConfig.setStep_num_y(cursorQuery.getInt(i132));
                    columnIndexOrThrow199 = columnIndexOrThrow199;
                    clockConfig.setStep_end_src(cursorQuery.isNull(columnIndexOrThrow199) ? null : cursorQuery.getString(columnIndexOrThrow199));
                    columnIndexOrThrow198 = i132;
                    int i133 = columnIndexOrThrow200;
                    clockConfig.setShow_step_progress(cursorQuery.getInt(i133));
                    columnIndexOrThrow200 = i133;
                    int i134 = columnIndexOrThrow201;
                    clockConfig.setStep_progress_x(cursorQuery.getInt(i134));
                    columnIndexOrThrow201 = i134;
                    int i135 = columnIndexOrThrow202;
                    clockConfig.setStep_progress_y(cursorQuery.getInt(i135));
                    int i136 = columnIndexOrThrow203;
                    clockConfig.setStep_progress_src(cursorQuery.isNull(i136) ? null : cursorQuery.getString(i136));
                    int i137 = columnIndexOrThrow204;
                    clockConfig.setOpen_step_arc_show(cursorQuery.getInt(i137));
                    columnIndexOrThrow204 = i137;
                    int i138 = columnIndexOrThrow205;
                    clockConfig.setStep_arc_type(cursorQuery.getInt(i138));
                    columnIndexOrThrow205 = i138;
                    int i139 = columnIndexOrThrow206;
                    clockConfig.setStep_arc_center_x(cursorQuery.getInt(i139));
                    columnIndexOrThrow206 = i139;
                    int i140 = columnIndexOrThrow207;
                    clockConfig.setStep_arc_center_y(cursorQuery.getInt(i140));
                    columnIndexOrThrow207 = i140;
                    int i141 = columnIndexOrThrow208;
                    clockConfig.setShow_kcal(cursorQuery.getInt(i141));
                    int i142 = columnIndexOrThrow209;
                    clockConfig.setKcal_src(cursorQuery.isNull(i142) ? null : cursorQuery.getString(i142));
                    int i143 = columnIndexOrThrow210;
                    clockConfig.setKcal_x(cursorQuery.getInt(i143));
                    columnIndexOrThrow210 = i143;
                    int i144 = columnIndexOrThrow211;
                    clockConfig.setKcal_y(cursorQuery.getInt(i144));
                    columnIndexOrThrow212 = columnIndexOrThrow212;
                    clockConfig.setKcal_num_src(cursorQuery.isNull(columnIndexOrThrow212) ? null : cursorQuery.getString(columnIndexOrThrow212));
                    columnIndexOrThrow211 = i144;
                    int i145 = columnIndexOrThrow213;
                    clockConfig.setKcal_num_type(cursorQuery.getInt(i145));
                    columnIndexOrThrow213 = i145;
                    int i146 = columnIndexOrThrow214;
                    clockConfig.setKcal_show_type(cursorQuery.getInt(i146));
                    columnIndexOrThrow214 = i146;
                    int i147 = columnIndexOrThrow215;
                    clockConfig.setKcal_num_x(cursorQuery.getInt(i147));
                    columnIndexOrThrow215 = i147;
                    int i148 = columnIndexOrThrow216;
                    clockConfig.setKcal_num_y(cursorQuery.getInt(i148));
                    columnIndexOrThrow217 = columnIndexOrThrow217;
                    clockConfig.setKcal_end_src(cursorQuery.isNull(columnIndexOrThrow217) ? null : cursorQuery.getString(columnIndexOrThrow217));
                    columnIndexOrThrow218 = columnIndexOrThrow218;
                    clockConfig.setShow_km(cursorQuery.isNull(columnIndexOrThrow218) ? null : cursorQuery.getString(columnIndexOrThrow218));
                    columnIndexOrThrow219 = columnIndexOrThrow219;
                    clockConfig.setKm_src(cursorQuery.isNull(columnIndexOrThrow219) ? null : cursorQuery.getString(columnIndexOrThrow219));
                    columnIndexOrThrow216 = i148;
                    int i149 = columnIndexOrThrow220;
                    clockConfig.setKm_x(cursorQuery.getInt(i149));
                    columnIndexOrThrow220 = i149;
                    int i150 = columnIndexOrThrow221;
                    clockConfig.setKm_y(cursorQuery.getInt(i150));
                    columnIndexOrThrow222 = columnIndexOrThrow222;
                    clockConfig.setKm_num_src(cursorQuery.isNull(columnIndexOrThrow222) ? null : cursorQuery.getString(columnIndexOrThrow222));
                    columnIndexOrThrow223 = columnIndexOrThrow223;
                    clockConfig.setKm_comma_src(cursorQuery.isNull(columnIndexOrThrow223) ? null : cursorQuery.getString(columnIndexOrThrow223));
                    columnIndexOrThrow224 = columnIndexOrThrow224;
                    clockConfig.setKm_num_type(cursorQuery.isNull(columnIndexOrThrow224) ? null : cursorQuery.getString(columnIndexOrThrow224));
                    columnIndexOrThrow221 = i150;
                    int i151 = columnIndexOrThrow225;
                    clockConfig.setKm_show_type(cursorQuery.getInt(i151));
                    columnIndexOrThrow225 = i151;
                    int i152 = columnIndexOrThrow226;
                    clockConfig.setKm_num_x(cursorQuery.getInt(i152));
                    columnIndexOrThrow226 = i152;
                    int i153 = columnIndexOrThrow227;
                    clockConfig.setKm_num_y(cursorQuery.getInt(i153));
                    int i154 = columnIndexOrThrow228;
                    clockConfig.setKm_end_src(cursorQuery.isNull(i154) ? null : cursorQuery.getString(i154));
                    columnIndexOrThrow229 = columnIndexOrThrow229;
                    clockConfig.setShow_weather(cursorQuery.isNull(columnIndexOrThrow229) ? null : cursorQuery.getString(columnIndexOrThrow229));
                    columnIndexOrThrow230 = columnIndexOrThrow230;
                    clockConfig.setShow_temperature(cursorQuery.isNull(columnIndexOrThrow230) ? null : cursorQuery.getString(columnIndexOrThrow230));
                    int i155 = columnIndexOrThrow231;
                    clockConfig.setTemperature_show_type(cursorQuery.getInt(i155));
                    columnIndexOrThrow231 = i155;
                    int i156 = columnIndexOrThrow232;
                    clockConfig.setTemperature_num_type(cursorQuery.getInt(i156));
                    columnIndexOrThrow232 = i156;
                    int i157 = columnIndexOrThrow233;
                    clockConfig.setTemperature_x(cursorQuery.getInt(i157));
                    columnIndexOrThrow233 = i157;
                    int i158 = columnIndexOrThrow234;
                    clockConfig.setTemperature_y(cursorQuery.getInt(i158));
                    columnIndexOrThrow234 = i158;
                    int i159 = columnIndexOrThrow235;
                    clockConfig.setTemperature_x_2(cursorQuery.getInt(i159));
                    columnIndexOrThrow235 = i159;
                    int i160 = columnIndexOrThrow236;
                    clockConfig.setTemperature_y_2(cursorQuery.getInt(i160));
                    columnIndexOrThrow237 = columnIndexOrThrow237;
                    clockConfig.setShow_now_tem(cursorQuery.isNull(columnIndexOrThrow237) ? null : cursorQuery.getString(columnIndexOrThrow237));
                    columnIndexOrThrow238 = columnIndexOrThrow238;
                    clockConfig.setNow_tem_show_type(cursorQuery.isNull(columnIndexOrThrow238) ? null : cursorQuery.getString(columnIndexOrThrow238));
                    columnIndexOrThrow236 = i160;
                    int i161 = columnIndexOrThrow239;
                    clockConfig.setNow_tem_x(cursorQuery.getInt(i161));
                    columnIndexOrThrow239 = i161;
                    int i162 = columnIndexOrThrow240;
                    clockConfig.setNow_tem_y(cursorQuery.getInt(i162));
                    columnIndexOrThrow241 = columnIndexOrThrow241;
                    clockConfig.setTemperature_num_src(cursorQuery.isNull(columnIndexOrThrow241) ? null : cursorQuery.getString(columnIndexOrThrow241));
                    columnIndexOrThrow242 = columnIndexOrThrow242;
                    clockConfig.setTemperature_sub_src(cursorQuery.isNull(columnIndexOrThrow242) ? null : cursorQuery.getString(columnIndexOrThrow242));
                    columnIndexOrThrow243 = columnIndexOrThrow243;
                    clockConfig.setTemperature_sign_src(cursorQuery.isNull(columnIndexOrThrow243) ? null : cursorQuery.getString(columnIndexOrThrow243));
                    columnIndexOrThrow244 = columnIndexOrThrow244;
                    clockConfig.setTemperature_splt_src(cursorQuery.isNull(columnIndexOrThrow244) ? null : cursorQuery.getString(columnIndexOrThrow244));
                    columnIndexOrThrow245 = columnIndexOrThrow245;
                    clockConfig.setShow_diagram(cursorQuery.isNull(columnIndexOrThrow245) ? null : cursorQuery.getString(columnIndexOrThrow245));
                    columnIndexOrThrow240 = i162;
                    int i163 = columnIndexOrThrow246;
                    clockConfig.setDiagram_x(cursorQuery.getInt(i163));
                    columnIndexOrThrow246 = i163;
                    int i164 = columnIndexOrThrow247;
                    clockConfig.setDiagram_y(cursorQuery.getInt(i164));
                    columnIndexOrThrow247 = i164;
                    int i165 = columnIndexOrThrow248;
                    clockConfig.setShowsignal(cursorQuery.getInt(i165));
                    columnIndexOrThrow248 = i165;
                    int i166 = columnIndexOrThrow249;
                    clockConfig.setShow_signal(cursorQuery.getInt(i166));
                    columnIndexOrThrow250 = columnIndexOrThrow250;
                    clockConfig.setSignal_src(cursorQuery.isNull(columnIndexOrThrow250) ? null : cursorQuery.getString(columnIndexOrThrow250));
                    columnIndexOrThrow249 = i166;
                    int i167 = columnIndexOrThrow251;
                    clockConfig.setSignal_x(cursorQuery.getInt(i167));
                    columnIndexOrThrow251 = i167;
                    int i168 = columnIndexOrThrow252;
                    clockConfig.setSignal_y(cursorQuery.getInt(i168));
                    columnIndexOrThrow253 = columnIndexOrThrow253;
                    clockConfig.setShow_user_name(cursorQuery.isNull(columnIndexOrThrow253) ? null : cursorQuery.getString(columnIndexOrThrow253));
                    columnIndexOrThrow254 = columnIndexOrThrow254;
                    clockConfig.setName_show_type(cursorQuery.isNull(columnIndexOrThrow254) ? null : cursorQuery.getString(columnIndexOrThrow254));
                    int i169 = columnIndexOrThrow255;
                    clockConfig.setName_x(cursorQuery.getInt(i169));
                    columnIndexOrThrow255 = i169;
                    int i170 = columnIndexOrThrow256;
                    clockConfig.setName_y(cursorQuery.getInt(i170));
                    columnIndexOrThrow256 = i170;
                    int i171 = columnIndexOrThrow257;
                    clockConfig.setShow_operator(cursorQuery.isNull(i171) ? null : cursorQuery.getString(i171));
                    columnIndexOrThrow257 = i171;
                    int i172 = columnIndexOrThrow258;
                    clockConfig.setOperator_show_type(cursorQuery.isNull(i172) ? null : cursorQuery.getString(i172));
                    columnIndexOrThrow258 = i172;
                    int i173 = columnIndexOrThrow259;
                    clockConfig.setOperator_x(cursorQuery.getInt(i173));
                    columnIndexOrThrow259 = i173;
                    int i174 = columnIndexOrThrow260;
                    clockConfig.setOperator_y(cursorQuery.getInt(i174));
                    columnIndexOrThrow260 = i174;
                    int i175 = columnIndexOrThrow261;
                    clockConfig.setShow_btn_call(cursorQuery.isNull(i175) ? null : cursorQuery.getString(i175));
                    columnIndexOrThrow261 = i175;
                    int i176 = columnIndexOrThrow262;
                    clockConfig.setBtn_call_src(cursorQuery.isNull(i176) ? null : cursorQuery.getString(i176));
                    columnIndexOrThrow262 = i176;
                    int i177 = columnIndexOrThrow263;
                    clockConfig.setBtn_call_x(cursorQuery.getInt(i177));
                    columnIndexOrThrow263 = i177;
                    int i178 = columnIndexOrThrow264;
                    clockConfig.setBtn_call_y(cursorQuery.getInt(i178));
                    columnIndexOrThrow264 = i178;
                    int i179 = columnIndexOrThrow265;
                    clockConfig.setShow_btn_sms(cursorQuery.isNull(i179) ? null : cursorQuery.getString(i179));
                    columnIndexOrThrow265 = i179;
                    int i180 = columnIndexOrThrow266;
                    clockConfig.setBtn_sms_src(cursorQuery.isNull(i180) ? null : cursorQuery.getString(i180));
                    columnIndexOrThrow266 = i180;
                    int i181 = columnIndexOrThrow267;
                    clockConfig.setBtn_sms_x(cursorQuery.getInt(i181));
                    columnIndexOrThrow267 = i181;
                    int i182 = columnIndexOrThrow268;
                    clockConfig.setBtn_sms_y(cursorQuery.getInt(i182));
                    columnIndexOrThrow268 = i182;
                    int i183 = columnIndexOrThrow269;
                    clockConfig.setShow_btn_heart(cursorQuery.isNull(i183) ? null : cursorQuery.getString(i183));
                    columnIndexOrThrow269 = i183;
                    int i184 = columnIndexOrThrow270;
                    clockConfig.setIs_our_heart(cursorQuery.getInt(i184));
                    columnIndexOrThrow270 = i184;
                    int i185 = columnIndexOrThrow271;
                    clockConfig.setBtn_heart_src(cursorQuery.isNull(i185) ? null : cursorQuery.getString(i185));
                    columnIndexOrThrow271 = i185;
                    int i186 = columnIndexOrThrow272;
                    clockConfig.setBtn_heart_x(cursorQuery.getInt(i186));
                    columnIndexOrThrow272 = i186;
                    int i187 = columnIndexOrThrow273;
                    clockConfig.setBtn_heart_y(cursorQuery.getInt(i187));
                    columnIndexOrThrow273 = i187;
                    int i188 = columnIndexOrThrow274;
                    clockConfig.setShow_btn_step(cursorQuery.isNull(i188) ? null : cursorQuery.getString(i188));
                    columnIndexOrThrow274 = i188;
                    int i189 = columnIndexOrThrow275;
                    clockConfig.setBtn_step_src(cursorQuery.isNull(i189) ? null : cursorQuery.getString(i189));
                    columnIndexOrThrow275 = i189;
                    int i190 = columnIndexOrThrow276;
                    clockConfig.setBtn_step_x(cursorQuery.getInt(i190));
                    columnIndexOrThrow276 = i190;
                    int i191 = columnIndexOrThrow277;
                    clockConfig.setBtn_step_y(cursorQuery.getInt(i191));
                    columnIndexOrThrow277 = i191;
                    int i192 = columnIndexOrThrow278;
                    clockConfig.setShow_btn_wechat(cursorQuery.isNull(i192) ? null : cursorQuery.getString(i192));
                    columnIndexOrThrow278 = i192;
                    int i193 = columnIndexOrThrow279;
                    clockConfig.setBtn_wechat_src(cursorQuery.isNull(i193) ? null : cursorQuery.getString(i193));
                    columnIndexOrThrow279 = i193;
                    int i194 = columnIndexOrThrow280;
                    clockConfig.setBtn_wechat_x(cursorQuery.getInt(i194));
                    columnIndexOrThrow280 = i194;
                    int i195 = columnIndexOrThrow281;
                    clockConfig.setBtn_wechat_y(cursorQuery.getInt(i195));
                    columnIndexOrThrow281 = i195;
                    int i196 = columnIndexOrThrow282;
                    clockConfig.setShow_btn_alipay(cursorQuery.getInt(i196));
                    columnIndexOrThrow282 = i196;
                    int i197 = columnIndexOrThrow283;
                    clockConfig.setBtn_alipay_src(cursorQuery.isNull(i197) ? null : cursorQuery.getString(i197));
                    columnIndexOrThrow283 = i197;
                    int i198 = columnIndexOrThrow284;
                    clockConfig.setBtn_alipay_x(cursorQuery.getInt(i198));
                    columnIndexOrThrow284 = i198;
                    int i199 = columnIndexOrThrow285;
                    clockConfig.setBtn_alipay_y(cursorQuery.getInt(i199));
                    columnIndexOrThrow285 = i199;
                    int i200 = columnIndexOrThrow286;
                    clockConfig.setShow_btn_stopwatch(cursorQuery.getInt(i200));
                    columnIndexOrThrow286 = i200;
                    int i201 = columnIndexOrThrow287;
                    clockConfig.setBtn_stopwatch_src(cursorQuery.isNull(i201) ? null : cursorQuery.getString(i201));
                    columnIndexOrThrow287 = i201;
                    int i202 = columnIndexOrThrow288;
                    clockConfig.setBtn_stopwatch_x(cursorQuery.getInt(i202));
                    columnIndexOrThrow288 = i202;
                    int i203 = columnIndexOrThrow289;
                    clockConfig.setBtn_stopwatch_y(cursorQuery.getInt(i203));
                    columnIndexOrThrow289 = i203;
                    int i204 = columnIndexOrThrow290;
                    clockConfig.setShow_btn_weather(cursorQuery.getInt(i204));
                    columnIndexOrThrow290 = i204;
                    int i205 = columnIndexOrThrow291;
                    clockConfig.setShow_btn_calo(cursorQuery.getInt(i205));
                    columnIndexOrThrow291 = i205;
                    int i206 = columnIndexOrThrow292;
                    clockConfig.setBtn_calo_src(cursorQuery.isNull(i206) ? null : cursorQuery.getString(i206));
                    columnIndexOrThrow292 = i206;
                    int i207 = columnIndexOrThrow293;
                    clockConfig.setBtn_calo_x(cursorQuery.getInt(i207));
                    columnIndexOrThrow293 = i207;
                    int i208 = columnIndexOrThrow294;
                    clockConfig.setBtn_calo_y(cursorQuery.getInt(i208));
                    columnIndexOrThrow294 = i208;
                    int i209 = columnIndexOrThrow295;
                    clockConfig.setTemprature_src(cursorQuery.isNull(i209) ? null : cursorQuery.getString(i209));
                    columnIndexOrThrow295 = i209;
                    int i210 = columnIndexOrThrow296;
                    clockConfig.setShow_btn_camera(cursorQuery.isNull(i210) ? null : cursorQuery.getString(i210));
                    columnIndexOrThrow296 = i210;
                    int i211 = columnIndexOrThrow297;
                    clockConfig.setBtn_camera_src(cursorQuery.isNull(i211) ? null : cursorQuery.getString(i211));
                    columnIndexOrThrow297 = i211;
                    int i212 = columnIndexOrThrow298;
                    clockConfig.setBtn_camera_x(cursorQuery.getInt(i212));
                    columnIndexOrThrow298 = i212;
                    int i213 = columnIndexOrThrow299;
                    clockConfig.setBtn_camera_y(cursorQuery.getInt(i213));
                    columnIndexOrThrow299 = i213;
                    int i214 = columnIndexOrThrow300;
                    clockConfig.setShow_btn_sos(cursorQuery.isNull(i214) ? null : cursorQuery.getString(i214));
                    columnIndexOrThrow300 = i214;
                    int i215 = columnIndexOrThrow301;
                    clockConfig.setBtn_sos_src(cursorQuery.isNull(i215) ? null : cursorQuery.getString(i215));
                    columnIndexOrThrow301 = i215;
                    int i216 = columnIndexOrThrow302;
                    clockConfig.setBtn_sos_x(cursorQuery.getInt(i216));
                    columnIndexOrThrow302 = i216;
                    int i217 = columnIndexOrThrow303;
                    clockConfig.setBtn_sos_y(cursorQuery.getInt(i217));
                    columnIndexOrThrow303 = i217;
                    int i218 = columnIndexOrThrow304;
                    clockConfig.setShow_special_1(cursorQuery.isNull(i218) ? null : cursorQuery.getString(i218));
                    columnIndexOrThrow304 = i218;
                    int i219 = columnIndexOrThrow305;
                    clockConfig.setSpecial_1_src(cursorQuery.isNull(i219) ? null : cursorQuery.getString(i219));
                    columnIndexOrThrow305 = i219;
                    int i220 = columnIndexOrThrow306;
                    clockConfig.setSpecial_1_position(cursorQuery.isNull(i220) ? null : cursorQuery.getString(i220));
                    columnIndexOrThrow306 = i220;
                    int i221 = columnIndexOrThrow307;
                    clockConfig.setSpecial_x(cursorQuery.getInt(i221));
                    columnIndexOrThrow307 = i221;
                    int i222 = columnIndexOrThrow308;
                    clockConfig.setSpecial_y(cursorQuery.getInt(i222));
                    columnIndexOrThrow308 = i222;
                    int i223 = columnIndexOrThrow309;
                    clockConfig.setSupport_multiple_change(cursorQuery.getInt(i223));
                    columnIndexOrThrow309 = i223;
                    int i224 = columnIndexOrThrow310;
                    clockConfig.setShow_lunar_year(cursorQuery.getInt(i224));
                    columnIndexOrThrow310 = i224;
                    int i225 = columnIndexOrThrow311;
                    clockConfig.setLunar_day_splt_src(cursorQuery.isNull(i225) ? null : cursorQuery.getString(i225));
                    columnIndexOrThrow311 = i225;
                    int i226 = columnIndexOrThrow312;
                    clockConfig.setLunar_month_splt_src(cursorQuery.isNull(i226) ? null : cursorQuery.getString(i226));
                    columnIndexOrThrow312 = i226;
                    int i227 = columnIndexOrThrow313;
                    clockConfig.setLunar_year_splt_src(cursorQuery.isNull(i227) ? null : cursorQuery.getString(i227));
                    columnIndexOrThrow313 = i227;
                    int i228 = columnIndexOrThrow314;
                    clockConfig.setAm_src(cursorQuery.isNull(i228) ? null : cursorQuery.getString(i228));
                    columnIndexOrThrow314 = i228;
                    int i229 = columnIndexOrThrow315;
                    clockConfig.setPm_src(cursorQuery.isNull(i229) ? null : cursorQuery.getString(i229));
                    columnIndexOrThrow315 = i229;
                    int i230 = columnIndexOrThrow316;
                    clockConfig.setShow_btn_alarm(cursorQuery.getInt(i230));
                    columnIndexOrThrow316 = i230;
                    int i231 = columnIndexOrThrow317;
                    clockConfig.setBtn_alarm_src(cursorQuery.isNull(i231) ? null : cursorQuery.getString(i231));
                    columnIndexOrThrow317 = i231;
                    int i232 = columnIndexOrThrow318;
                    clockConfig.setBtn_alarm_x(cursorQuery.getInt(i232));
                    columnIndexOrThrow318 = i232;
                    int i233 = columnIndexOrThrow319;
                    clockConfig.setBtn_alarm_y(cursorQuery.getInt(i233));
                    columnIndexOrThrow319 = i233;
                    int i234 = columnIndexOrThrow320;
                    clockConfig.setBg_btn_change(cursorQuery.getInt(i234));
                    columnIndexOrThrow320 = i234;
                    int i235 = columnIndexOrThrow321;
                    clockConfig.setBg_btn_index(cursorQuery.getInt(i235));
                    columnIndexOrThrow321 = i235;
                    int i236 = columnIndexOrThrow322;
                    clockConfig.setShow_btn_music(cursorQuery.getInt(i236));
                    columnIndexOrThrow322 = i236;
                    int i237 = columnIndexOrThrow323;
                    clockConfig.setBtn_music_src(cursorQuery.isNull(i237) ? null : cursorQuery.getString(i237));
                    columnIndexOrThrow323 = i237;
                    int i238 = columnIndexOrThrow324;
                    clockConfig.setBtn_music_x(cursorQuery.getInt(i238));
                    columnIndexOrThrow324 = i238;
                    int i239 = columnIndexOrThrow325;
                    clockConfig.setBtn_music_y(cursorQuery.getInt(i239));
                    columnIndexOrThrow325 = i239;
                    int i240 = columnIndexOrThrow326;
                    clockConfig.setSupport_dynamic_change(cursorQuery.getInt(i240));
                    columnIndexOrThrow326 = i240;
                    int i241 = columnIndexOrThrow327;
                    clockConfig.setLevel(cursorQuery.getInt(i241));
                    columnIndexOrThrow327 = i241;
                    int i242 = columnIndexOrThrow328;
                    clockConfig.setParent_id(cursorQuery.isNull(i242) ? null : cursorQuery.getString(i242));
                    columnIndexOrThrow328 = i242;
                    int i243 = columnIndexOrThrow329;
                    clockConfig.setNext_id(cursorQuery.getInt(i243));
                    columnIndexOrThrow329 = i243;
                    int i244 = columnIndexOrThrow330;
                    clockConfig.setChange_starttime(cursorQuery.getInt(i244));
                    columnIndexOrThrow330 = i244;
                    int i245 = columnIndexOrThrow331;
                    clockConfig.setChange_endtime(cursorQuery.getInt(i245));
                    columnIndexOrThrow331 = i245;
                    int i246 = columnIndexOrThrow332;
                    clockConfig.setBtn_weather_src(cursorQuery.isNull(i246) ? null : cursorQuery.getString(i246));
                    columnIndexOrThrow332 = i246;
                    int i247 = columnIndexOrThrow333;
                    clockConfig.setBtn_weather_x(cursorQuery.getInt(i247));
                    columnIndexOrThrow333 = i247;
                    int i248 = columnIndexOrThrow334;
                    clockConfig.setBtn_weather_y(cursorQuery.getInt(i248));
                    columnIndexOrThrow334 = i248;
                    int i249 = columnIndexOrThrow335;
                    clockConfig.setShow_btn_calories(cursorQuery.getInt(i249));
                    columnIndexOrThrow335 = i249;
                    int i250 = columnIndexOrThrow336;
                    clockConfig.setBtn_calories_src(cursorQuery.isNull(i250) ? null : cursorQuery.getString(i250));
                    columnIndexOrThrow336 = i250;
                    int i251 = columnIndexOrThrow337;
                    clockConfig.setBtn_calories_x(cursorQuery.getInt(i251));
                    columnIndexOrThrow337 = i251;
                    int i252 = columnIndexOrThrow338;
                    clockConfig.setBtn_calories_y(cursorQuery.getInt(i252));
                    columnIndexOrThrow338 = i252;
                    int i253 = columnIndexOrThrow339;
                    clockConfig.setSupport_compass(cursorQuery.getInt(i253));
                    columnIndexOrThrow339 = i253;
                    int i254 = columnIndexOrThrow340;
                    clockConfig.setCompass_src(cursorQuery.isNull(i254) ? null : cursorQuery.getString(i254));
                    columnIndexOrThrow340 = i254;
                    int i255 = columnIndexOrThrow341;
                    clockConfig.setCompass_2_src(cursorQuery.isNull(i255) ? null : cursorQuery.getString(i255));
                    columnIndexOrThrow341 = i255;
                    int i256 = columnIndexOrThrow342;
                    clockConfig.setCompass_x(cursorQuery.getInt(i256));
                    columnIndexOrThrow342 = i256;
                    int i257 = columnIndexOrThrow343;
                    clockConfig.setCompass_y(cursorQuery.getInt(i257));
                    columnIndexOrThrow343 = i257;
                    int i258 = columnIndexOrThrow344;
                    clockConfig.setShow_btn_setting(cursorQuery.getInt(i258));
                    columnIndexOrThrow344 = i258;
                    int i259 = columnIndexOrThrow345;
                    clockConfig.setBtn_setting_src(cursorQuery.isNull(i259) ? null : cursorQuery.getString(i259));
                    columnIndexOrThrow345 = i259;
                    int i260 = columnIndexOrThrow346;
                    clockConfig.setBtn_setting_x(cursorQuery.getInt(i260));
                    columnIndexOrThrow346 = i260;
                    int i261 = columnIndexOrThrow347;
                    clockConfig.setBtn_setting_y(cursorQuery.getInt(i261));
                    columnIndexOrThrow347 = i261;
                    int i262 = columnIndexOrThrow348;
                    clockConfig.setSupport_click_change(cursorQuery.getInt(i262));
                    columnIndexOrThrow348 = i262;
                    int i263 = columnIndexOrThrow349;
                    clockConfig.setClick_id_is_current(cursorQuery.getInt(i263));
                    columnIndexOrThrow349 = i263;
                    int i264 = columnIndexOrThrow350;
                    clockConfig.setCompass_show_detail_degree(cursorQuery.getInt(i264));
                    columnIndexOrThrow350 = i264;
                    int i265 = columnIndexOrThrow351;
                    clockConfig.setCompass_direction_src(cursorQuery.isNull(i265) ? null : cursorQuery.getString(i265));
                    columnIndexOrThrow351 = i265;
                    int i266 = columnIndexOrThrow352;
                    clockConfig.setCompass_direction_x(cursorQuery.getInt(i266));
                    columnIndexOrThrow352 = i266;
                    int i267 = columnIndexOrThrow353;
                    clockConfig.setCompass_direction_y(cursorQuery.getInt(i267));
                    columnIndexOrThrow353 = i267;
                    int i268 = columnIndexOrThrow354;
                    clockConfig.setCompass_direction_2_src(cursorQuery.isNull(i268) ? null : cursorQuery.getString(i268));
                    columnIndexOrThrow354 = i268;
                    int i269 = columnIndexOrThrow355;
                    clockConfig.setCompass_direction_2_x(cursorQuery.getInt(i269));
                    columnIndexOrThrow355 = i269;
                    int i270 = columnIndexOrThrow356;
                    clockConfig.setCompass_direction_2_y(cursorQuery.getInt(i270));
                    columnIndexOrThrow356 = i270;
                    int i271 = columnIndexOrThrow357;
                    clockConfig.setCompass_direction_3_src(cursorQuery.isNull(i271) ? null : cursorQuery.getString(i271));
                    columnIndexOrThrow357 = i271;
                    int i272 = columnIndexOrThrow358;
                    clockConfig.setCompass_direction_3_x(cursorQuery.getInt(i272));
                    columnIndexOrThrow358 = i272;
                    int i273 = columnIndexOrThrow359;
                    clockConfig.setCompass_direction_3_y(cursorQuery.getInt(i273));
                    columnIndexOrThrow359 = i273;
                    int i274 = columnIndexOrThrow360;
                    clockConfig.setCompass_direction_degree_src(cursorQuery.isNull(i274) ? null : cursorQuery.getString(i274));
                    columnIndexOrThrow360 = i274;
                    int i275 = columnIndexOrThrow361;
                    clockConfig.setCompass_direction_degree_x(cursorQuery.getInt(i275));
                    columnIndexOrThrow361 = i275;
                    int i276 = columnIndexOrThrow362;
                    clockConfig.setCompass_direction_degree_y(cursorQuery.getInt(i276));
                    columnIndexOrThrow362 = i276;
                    int i277 = columnIndexOrThrow363;
                    clockConfig.setCompass_direction_degree_unit(cursorQuery.isNull(i277) ? null : cursorQuery.getString(i277));
                    columnIndexOrThrow363 = i277;
                    int i278 = columnIndexOrThrow364;
                    clockConfig.setCompass_degree_1_src(cursorQuery.isNull(i278) ? null : cursorQuery.getString(i278));
                    columnIndexOrThrow364 = i278;
                    int i279 = columnIndexOrThrow365;
                    clockConfig.setCompass_degree_1_x(cursorQuery.getInt(i279));
                    columnIndexOrThrow365 = i279;
                    int i280 = columnIndexOrThrow366;
                    clockConfig.setCompass_degree_1_y(cursorQuery.getInt(i280));
                    columnIndexOrThrow366 = i280;
                    int i281 = columnIndexOrThrow367;
                    clockConfig.setCompass_degree_2_src(cursorQuery.isNull(i281) ? null : cursorQuery.getString(i281));
                    columnIndexOrThrow367 = i281;
                    int i282 = columnIndexOrThrow368;
                    clockConfig.setCompass_degree_2_x(cursorQuery.getInt(i282));
                    columnIndexOrThrow368 = i282;
                    int i283 = columnIndexOrThrow369;
                    clockConfig.setCompass_degree_2_y(cursorQuery.getInt(i283));
                    columnIndexOrThrow369 = i283;
                    int i284 = columnIndexOrThrow370;
                    clockConfig.setCompass_degree_3_src(cursorQuery.isNull(i284) ? null : cursorQuery.getString(i284));
                    columnIndexOrThrow370 = i284;
                    int i285 = columnIndexOrThrow371;
                    clockConfig.setCompass_degree_3_x(cursorQuery.getInt(i285));
                    columnIndexOrThrow371 = i285;
                    int i286 = columnIndexOrThrow372;
                    clockConfig.setCompass_degree_3_y(cursorQuery.getInt(i286));
                    columnIndexOrThrow372 = i286;
                    int i287 = columnIndexOrThrow373;
                    clockConfig.setShow_connect_animation(cursorQuery.getInt(i287));
                    columnIndexOrThrow373 = i287;
                    int i288 = columnIndexOrThrow374;
                    clockConfig.setConnect_animation_x(cursorQuery.getInt(i288));
                    columnIndexOrThrow374 = i288;
                    int i289 = columnIndexOrThrow375;
                    clockConfig.setConnect_animation_y(cursorQuery.getInt(i289));
                    columnIndexOrThrow375 = i289;
                    int i290 = columnIndexOrThrow376;
                    clockConfig.setConnect_animation_count(cursorQuery.getInt(i290));
                    columnIndexOrThrow376 = i290;
                    int i291 = columnIndexOrThrow377;
                    clockConfig.setShow_state(cursorQuery.getInt(i291));
                    columnIndexOrThrow377 = i291;
                    int i292 = columnIndexOrThrow378;
                    clockConfig.setState_x(cursorQuery.getInt(i292));
                    columnIndexOrThrow378 = i292;
                    int i293 = columnIndexOrThrow379;
                    clockConfig.setState_y(cursorQuery.getInt(i293));
                    columnIndexOrThrow379 = i293;
                    int i294 = columnIndexOrThrow380;
                    clockConfig.setAction_1_cut_position(cursorQuery.getInt(i294));
                    columnIndexOrThrow380 = i294;
                    int i295 = columnIndexOrThrow381;
                    clockConfig.setAction_2_cut_position(cursorQuery.getInt(i295));
                    columnIndexOrThrow381 = i295;
                    int i296 = columnIndexOrThrow382;
                    clockConfig.setAction_3_cut_position(cursorQuery.getInt(i296));
                    columnIndexOrThrow382 = i296;
                    int i297 = columnIndexOrThrow383;
                    clockConfig.setShow_btn_googleplay(cursorQuery.getInt(i297));
                    columnIndexOrThrow383 = i297;
                    int i298 = columnIndexOrThrow384;
                    clockConfig.setBtn_googleplay_src(cursorQuery.isNull(i298) ? null : cursorQuery.getString(i298));
                    columnIndexOrThrow384 = i298;
                    int i299 = columnIndexOrThrow385;
                    clockConfig.setBtn_googleplay_x(cursorQuery.getInt(i299));
                    columnIndexOrThrow385 = i299;
                    int i300 = columnIndexOrThrow386;
                    clockConfig.setBtn_googleplay_y(cursorQuery.getInt(i300));
                    columnIndexOrThrow386 = i300;
                    int i301 = columnIndexOrThrow387;
                    clockConfig.setShow_month_2(cursorQuery.getInt(i301));
                    columnIndexOrThrow387 = i301;
                    int i302 = columnIndexOrThrow388;
                    clockConfig.setMonth_type_2(cursorQuery.getInt(i302));
                    columnIndexOrThrow388 = i302;
                    int i303 = columnIndexOrThrow389;
                    clockConfig.setMonth_src_2(cursorQuery.isNull(i303) ? null : cursorQuery.getString(i303));
                    columnIndexOrThrow389 = i303;
                    int i304 = columnIndexOrThrow390;
                    clockConfig.setMonth_x_2(cursorQuery.getInt(i304));
                    columnIndexOrThrow390 = i304;
                    int i305 = columnIndexOrThrow391;
                    clockConfig.setMonth_y_2(cursorQuery.getInt(i305));
                    columnIndexOrThrow391 = i305;
                    int i306 = columnIndexOrThrow392;
                    clockConfig.setTime_special_new(cursorQuery.getInt(i306));
                    columnIndexOrThrow392 = i306;
                    int i307 = columnIndexOrThrow393;
                    clockConfig.setTime_special_hour_ten_src(cursorQuery.isNull(i307) ? null : cursorQuery.getString(i307));
                    columnIndexOrThrow393 = i307;
                    int i308 = columnIndexOrThrow394;
                    clockConfig.setTime_special_hour_src(cursorQuery.isNull(i308) ? null : cursorQuery.getString(i308));
                    columnIndexOrThrow394 = i308;
                    int i309 = columnIndexOrThrow395;
                    clockConfig.setTime_special_min_ten_src(cursorQuery.isNull(i309) ? null : cursorQuery.getString(i309));
                    columnIndexOrThrow395 = i309;
                    int i310 = columnIndexOrThrow396;
                    clockConfig.setTime_special_min_src(cursorQuery.isNull(i310) ? null : cursorQuery.getString(i310));
                    columnIndexOrThrow396 = i310;
                    int i311 = columnIndexOrThrow397;
                    clockConfig.setShow_kcal_progress(cursorQuery.getInt(i311));
                    columnIndexOrThrow397 = i311;
                    int i312 = columnIndexOrThrow398;
                    clockConfig.setKcal_progress_x(cursorQuery.getInt(i312));
                    columnIndexOrThrow398 = i312;
                    int i313 = columnIndexOrThrow399;
                    clockConfig.setKcal_progress_y(cursorQuery.getInt(i313));
                    columnIndexOrThrow399 = i313;
                    int i314 = columnIndexOrThrow400;
                    clockConfig.setKcal_progress_src(cursorQuery.isNull(i314) ? null : cursorQuery.getString(i314));
                    columnIndexOrThrow400 = i314;
                    int i315 = columnIndexOrThrow401;
                    clockConfig.setOpen_kcal_arc_show(cursorQuery.getInt(i315));
                    columnIndexOrThrow401 = i315;
                    int i316 = columnIndexOrThrow402;
                    clockConfig.setKcal_arc_type(cursorQuery.getInt(i316));
                    columnIndexOrThrow402 = i316;
                    int i317 = columnIndexOrThrow403;
                    clockConfig.setKcal_arc_center_x(cursorQuery.getInt(i317));
                    columnIndexOrThrow403 = i317;
                    int i318 = columnIndexOrThrow404;
                    clockConfig.setKcal_arc_center_y(cursorQuery.getInt(i318));
                    columnIndexOrThrow404 = i318;
                    int i319 = columnIndexOrThrow405;
                    clockConfig.setOpen_power_arc_show(cursorQuery.getInt(i319));
                    columnIndexOrThrow405 = i319;
                    int i320 = columnIndexOrThrow406;
                    clockConfig.setPower_arc_type(cursorQuery.getInt(i320));
                    columnIndexOrThrow406 = i320;
                    int i321 = columnIndexOrThrow407;
                    clockConfig.setPower_arc_center_x(cursorQuery.getInt(i321));
                    columnIndexOrThrow407 = i321;
                    int i322 = columnIndexOrThrow408;
                    clockConfig.setPower_arc_center_y(cursorQuery.getInt(i322));
                    columnIndexOrThrow408 = i322;
                    int i323 = columnIndexOrThrow409;
                    clockConfig.setShow_btn_timer(cursorQuery.getInt(i323));
                    columnIndexOrThrow409 = i323;
                    int i324 = columnIndexOrThrow410;
                    clockConfig.setBtn_timer_src(cursorQuery.isNull(i324) ? null : cursorQuery.getString(i324));
                    columnIndexOrThrow410 = i324;
                    int i325 = columnIndexOrThrow411;
                    clockConfig.setBtn_timer_x(cursorQuery.getInt(i325));
                    columnIndexOrThrow411 = i325;
                    int i326 = columnIndexOrThrow412;
                    clockConfig.setBtn_timer_y(cursorQuery.getInt(i326));
                    columnIndexOrThrow412 = i326;
                    int i327 = columnIndexOrThrow413;
                    clockConfig.setShow_btn_sleep(cursorQuery.getInt(i327));
                    columnIndexOrThrow413 = i327;
                    int i328 = columnIndexOrThrow414;
                    clockConfig.setBtn_sleep_src(cursorQuery.isNull(i328) ? null : cursorQuery.getString(i328));
                    columnIndexOrThrow414 = i328;
                    int i329 = columnIndexOrThrow415;
                    clockConfig.setBtn_sleep_x(cursorQuery.getInt(i329));
                    columnIndexOrThrow415 = i329;
                    int i330 = columnIndexOrThrow416;
                    clockConfig.setBtn_sleep_y(cursorQuery.getInt(i330));
                    columnIndexOrThrow416 = i330;
                    int i331 = columnIndexOrThrow417;
                    clockConfig.setShow_btn_bloodpressure(cursorQuery.getInt(i331));
                    columnIndexOrThrow417 = i331;
                    int i332 = columnIndexOrThrow418;
                    clockConfig.setBtn_bloodpressure_src(cursorQuery.isNull(i332) ? null : cursorQuery.getString(i332));
                    columnIndexOrThrow418 = i332;
                    int i333 = columnIndexOrThrow419;
                    clockConfig.setBtn_bloodpressure_x(cursorQuery.getInt(i333));
                    columnIndexOrThrow419 = i333;
                    int i334 = columnIndexOrThrow420;
                    clockConfig.setBtn_bloodpressure_y(cursorQuery.getInt(i334));
                    columnIndexOrThrow420 = i334;
                    int i335 = columnIndexOrThrow421;
                    clockConfig.setShow_btn_sport_record(cursorQuery.getInt(i335));
                    columnIndexOrThrow421 = i335;
                    int i336 = columnIndexOrThrow422;
                    clockConfig.setBtn_sport_record_src(cursorQuery.isNull(i336) ? null : cursorQuery.getString(i336));
                    columnIndexOrThrow422 = i336;
                    int i337 = columnIndexOrThrow423;
                    clockConfig.setBtn_sport_record_x(cursorQuery.getInt(i337));
                    columnIndexOrThrow423 = i337;
                    int i338 = columnIndexOrThrow424;
                    clockConfig.setBtn_sport_record_y(cursorQuery.getInt(i338));
                    columnIndexOrThrow424 = i338;
                    int i339 = columnIndexOrThrow425;
                    clockConfig.setLottie_hierarchy(cursorQuery.getInt(i339));
                    columnIndexOrThrow425 = i339;
                    int i340 = columnIndexOrThrow426;
                    clockConfig.setShow_heart_progress(cursorQuery.getInt(i340));
                    columnIndexOrThrow426 = i340;
                    int i341 = columnIndexOrThrow427;
                    clockConfig.setHeart_progress_x(cursorQuery.getInt(i341));
                    columnIndexOrThrow427 = i341;
                    int i342 = columnIndexOrThrow428;
                    clockConfig.setHeart_progress_y(cursorQuery.getInt(i342));
                    columnIndexOrThrow428 = i342;
                    int i343 = columnIndexOrThrow429;
                    clockConfig.setHeart_progress_src(cursorQuery.isNull(i343) ? null : cursorQuery.getString(i343));
                    columnIndexOrThrow429 = i343;
                    int i344 = columnIndexOrThrow430;
                    clockConfig.setShow_btn_calculator(cursorQuery.getInt(i344));
                    columnIndexOrThrow430 = i344;
                    int i345 = columnIndexOrThrow431;
                    clockConfig.setBtn_calculator_src(cursorQuery.isNull(i345) ? null : cursorQuery.getString(i345));
                    columnIndexOrThrow431 = i345;
                    int i346 = columnIndexOrThrow432;
                    clockConfig.setBtn_calculator_x(cursorQuery.getInt(i346));
                    columnIndexOrThrow432 = i346;
                    int i347 = columnIndexOrThrow433;
                    clockConfig.setBtn_calculator_y(cursorQuery.getInt(i347));
                    columnIndexOrThrow433 = i347;
                    int i348 = columnIndexOrThrow434;
                    clockConfig.setTime_special_drag_3d(cursorQuery.getInt(i348));
                    columnIndexOrThrow434 = i348;
                    int i349 = columnIndexOrThrow435;
                    clockConfig.setPrev_HourTen_Position(cursorQuery.isNull(i349) ? null : cursorQuery.getString(i349));
                    columnIndexOrThrow435 = i349;
                    int i350 = columnIndexOrThrow436;
                    clockConfig.setPrev_HourGe_Position(cursorQuery.isNull(i350) ? null : cursorQuery.getString(i350));
                    columnIndexOrThrow436 = i350;
                    int i351 = columnIndexOrThrow437;
                    clockConfig.setCurrent_HourTen_Position(cursorQuery.isNull(i351) ? null : cursorQuery.getString(i351));
                    columnIndexOrThrow437 = i351;
                    int i352 = columnIndexOrThrow438;
                    clockConfig.setCurrent_HourGe_Position(cursorQuery.isNull(i352) ? null : cursorQuery.getString(i352));
                    columnIndexOrThrow438 = i352;
                    int i353 = columnIndexOrThrow439;
                    clockConfig.setNext_HourTen_Position(cursorQuery.isNull(i353) ? null : cursorQuery.getString(i353));
                    columnIndexOrThrow439 = i353;
                    int i354 = columnIndexOrThrow440;
                    clockConfig.setNext_HourGe_Position(cursorQuery.isNull(i354) ? null : cursorQuery.getString(i354));
                    columnIndexOrThrow440 = i354;
                    int i355 = columnIndexOrThrow441;
                    clockConfig.setPrev_MinTen_Position(cursorQuery.isNull(i355) ? null : cursorQuery.getString(i355));
                    columnIndexOrThrow441 = i355;
                    int i356 = columnIndexOrThrow442;
                    clockConfig.setPrev_MinGe_Position(cursorQuery.isNull(i356) ? null : cursorQuery.getString(i356));
                    columnIndexOrThrow442 = i356;
                    int i357 = columnIndexOrThrow443;
                    clockConfig.setCurrent_MinTen_Position(cursorQuery.isNull(i357) ? null : cursorQuery.getString(i357));
                    columnIndexOrThrow443 = i357;
                    int i358 = columnIndexOrThrow444;
                    clockConfig.setCurrent_MinGe_Position(cursorQuery.isNull(i358) ? null : cursorQuery.getString(i358));
                    columnIndexOrThrow444 = i358;
                    int i359 = columnIndexOrThrow445;
                    clockConfig.setNext_MinTen_Position(cursorQuery.isNull(i359) ? null : cursorQuery.getString(i359));
                    columnIndexOrThrow445 = i359;
                    int i360 = columnIndexOrThrow446;
                    clockConfig.setNext_MinGe_Position(cursorQuery.isNull(i360) ? null : cursorQuery.getString(i360));
                    columnIndexOrThrow446 = i360;
                    int i361 = columnIndexOrThrow447;
                    clockConfig.setNeed_split_day(cursorQuery.getInt(i361));
                    columnIndexOrThrow447 = i361;
                    int i362 = columnIndexOrThrow448;
                    clockConfig.setSplit_day_x(cursorQuery.getInt(i362));
                    columnIndexOrThrow448 = i362;
                    int i363 = columnIndexOrThrow449;
                    clockConfig.setSplit_day_y(cursorQuery.getInt(i363));
                    columnIndexOrThrow449 = i363;
                    int i364 = columnIndexOrThrow450;
                    clockConfig.setOpen_now_tem_arc_show(cursorQuery.getInt(i364));
                    columnIndexOrThrow450 = i364;
                    int i365 = columnIndexOrThrow451;
                    clockConfig.setNow_tem_arc_type(cursorQuery.getInt(i365));
                    columnIndexOrThrow451 = i365;
                    int i366 = columnIndexOrThrow452;
                    clockConfig.setNow_tem_arc_center_x(cursorQuery.getInt(i366));
                    columnIndexOrThrow452 = i366;
                    int i367 = columnIndexOrThrow453;
                    clockConfig.setNow_tem_arc_center_y(cursorQuery.getInt(i367));
                    columnIndexOrThrow453 = i367;
                    int i368 = columnIndexOrThrow454;
                    clockConfig.setShow_km_progress(cursorQuery.getInt(i368));
                    columnIndexOrThrow454 = i368;
                    int i369 = columnIndexOrThrow455;
                    clockConfig.setKm_progress_x(cursorQuery.getInt(i369));
                    columnIndexOrThrow455 = i369;
                    int i370 = columnIndexOrThrow456;
                    clockConfig.setKm_progress_y(cursorQuery.getInt(i370));
                    columnIndexOrThrow456 = i370;
                    int i371 = columnIndexOrThrow457;
                    clockConfig.setKm_progress_src(cursorQuery.isNull(i371) ? null : cursorQuery.getString(i371));
                    columnIndexOrThrow457 = i371;
                    int i372 = columnIndexOrThrow458;
                    clockConfig.setOpen_km_arc_show(cursorQuery.getInt(i372));
                    columnIndexOrThrow458 = i372;
                    int i373 = columnIndexOrThrow459;
                    clockConfig.setKm_arc_type(cursorQuery.getInt(i373));
                    columnIndexOrThrow459 = i373;
                    int i374 = columnIndexOrThrow460;
                    clockConfig.setKm_arc_center_x(cursorQuery.getInt(i374));
                    columnIndexOrThrow460 = i374;
                    int i375 = columnIndexOrThrow461;
                    clockConfig.setKm_arc_center_y(cursorQuery.getInt(i375));
                    columnIndexOrThrow461 = i375;
                    int i376 = columnIndexOrThrow462;
                    clockConfig.setTime_rotate(cursorQuery.getInt(i376));
                    columnIndexOrThrow462 = i376;
                    int i377 = columnIndexOrThrow463;
                    clockConfig.setTime_rotate_degree(cursorQuery.getInt(i377));
                    columnIndexOrThrow463 = i377;
                    int i378 = columnIndexOrThrow464;
                    clockConfig.setHeart_num_rotate(cursorQuery.getInt(i378));
                    columnIndexOrThrow464 = i378;
                    int i379 = columnIndexOrThrow465;
                    clockConfig.setHeart_num_rotate_degree(cursorQuery.getInt(i379));
                    columnIndexOrThrow465 = i379;
                    int i380 = columnIndexOrThrow466;
                    clockConfig.setShow_oxygen(cursorQuery.getInt(i380));
                    columnIndexOrThrow466 = i380;
                    int i381 = columnIndexOrThrow467;
                    clockConfig.setOxygen_src(cursorQuery.isNull(i381) ? null : cursorQuery.getString(i381));
                    columnIndexOrThrow467 = i381;
                    int i382 = columnIndexOrThrow468;
                    clockConfig.setOxygen_x(cursorQuery.getInt(i382));
                    columnIndexOrThrow468 = i382;
                    int i383 = columnIndexOrThrow469;
                    clockConfig.setOxygen_y(cursorQuery.getInt(i383));
                    columnIndexOrThrow469 = i383;
                    int i384 = columnIndexOrThrow470;
                    clockConfig.setOxygen_num_src(cursorQuery.isNull(i384) ? null : cursorQuery.getString(i384));
                    columnIndexOrThrow470 = i384;
                    int i385 = columnIndexOrThrow471;
                    clockConfig.setOxygen_sign_src(cursorQuery.isNull(i385) ? null : cursorQuery.getString(i385));
                    columnIndexOrThrow471 = i385;
                    int i386 = columnIndexOrThrow472;
                    clockConfig.setOxygen_show_type(cursorQuery.getInt(i386));
                    columnIndexOrThrow472 = i386;
                    int i387 = columnIndexOrThrow473;
                    clockConfig.setOxygen_num_x(cursorQuery.getInt(i387));
                    columnIndexOrThrow473 = i387;
                    int i388 = columnIndexOrThrow474;
                    clockConfig.setOxygen_num_y(cursorQuery.getInt(i388));
                    columnIndexOrThrow474 = i388;
                    int i389 = columnIndexOrThrow475;
                    clockConfig.setTime_change_counter(cursorQuery.getInt(i389));
                    columnIndexOrThrow475 = i389;
                    int i390 = columnIndexOrThrow476;
                    clockConfig.setTime_hour_src_2(cursorQuery.isNull(i390) ? null : cursorQuery.getString(i390));
                    columnIndexOrThrow476 = i390;
                    int i391 = columnIndexOrThrow477;
                    clockConfig.setTime_min_src_2(cursorQuery.isNull(i391) ? null : cursorQuery.getString(i391));
                    columnIndexOrThrow477 = i391;
                    int i392 = columnIndexOrThrow478;
                    clockConfig.setTime_sec_src_2(cursorQuery.isNull(i392) ? null : cursorQuery.getString(i392));
                    columnIndexOrThrow478 = i392;
                    int i393 = columnIndexOrThrow479;
                    clockConfig.setTime_splt_src_2(cursorQuery.isNull(i393) ? null : cursorQuery.getString(i393));
                    columnIndexOrThrow479 = i393;
                    int i394 = columnIndexOrThrow480;
                    clockConfig.setTime_splt_2_src_2(cursorQuery.isNull(i394) ? null : cursorQuery.getString(i394));
                    columnIndexOrThrow480 = i394;
                    int i395 = columnIndexOrThrow481;
                    clockConfig.setTime_hour_src_3(cursorQuery.isNull(i395) ? null : cursorQuery.getString(i395));
                    columnIndexOrThrow481 = i395;
                    int i396 = columnIndexOrThrow482;
                    clockConfig.setTime_min_src_3(cursorQuery.isNull(i396) ? null : cursorQuery.getString(i396));
                    columnIndexOrThrow482 = i396;
                    int i397 = columnIndexOrThrow483;
                    clockConfig.setTime_sec_src_3(cursorQuery.isNull(i397) ? null : cursorQuery.getString(i397));
                    columnIndexOrThrow483 = i397;
                    int i398 = columnIndexOrThrow484;
                    clockConfig.setTime_splt_src_3(cursorQuery.isNull(i398) ? null : cursorQuery.getString(i398));
                    columnIndexOrThrow484 = i398;
                    int i399 = columnIndexOrThrow485;
                    clockConfig.setTime_splt_2_src_3(cursorQuery.isNull(i399) ? null : cursorQuery.getString(i399));
                    columnIndexOrThrow485 = i399;
                    int i400 = columnIndexOrThrow486;
                    clockConfig.setTime_hour_src_4(cursorQuery.isNull(i400) ? null : cursorQuery.getString(i400));
                    columnIndexOrThrow486 = i400;
                    int i401 = columnIndexOrThrow487;
                    clockConfig.setTime_min_src_4(cursorQuery.isNull(i401) ? null : cursorQuery.getString(i401));
                    columnIndexOrThrow487 = i401;
                    int i402 = columnIndexOrThrow488;
                    clockConfig.setTime_sec_src_4(cursorQuery.isNull(i402) ? null : cursorQuery.getString(i402));
                    columnIndexOrThrow488 = i402;
                    int i403 = columnIndexOrThrow489;
                    clockConfig.setTime_splt_src_4(cursorQuery.isNull(i403) ? null : cursorQuery.getString(i403));
                    columnIndexOrThrow489 = i403;
                    int i404 = columnIndexOrThrow490;
                    clockConfig.setTime_splt_2_src_4(cursorQuery.isNull(i404) ? null : cursorQuery.getString(i404));
                    columnIndexOrThrow490 = i404;
                    int i405 = columnIndexOrThrow491;
                    clockConfig.setDate_rotate(cursorQuery.getInt(i405));
                    columnIndexOrThrow491 = i405;
                    int i406 = columnIndexOrThrow492;
                    clockConfig.setDate_rotate_degree(cursorQuery.getInt(i406));
                    columnIndexOrThrow492 = i406;
                    int i407 = columnIndexOrThrow493;
                    clockConfig.setNeed_split_hour(cursorQuery.getInt(i407));
                    columnIndexOrThrow493 = i407;
                    int i408 = columnIndexOrThrow494;
                    clockConfig.setSplit_hour_src(cursorQuery.isNull(i408) ? null : cursorQuery.getString(i408));
                    columnIndexOrThrow494 = i408;
                    int i409 = columnIndexOrThrow495;
                    clockConfig.setSplit_hour_x(cursorQuery.getInt(i409));
                    columnIndexOrThrow495 = i409;
                    int i410 = columnIndexOrThrow496;
                    clockConfig.setSplit_hour_y(cursorQuery.getInt(i410));
                    columnIndexOrThrow496 = i410;
                    int i411 = columnIndexOrThrow497;
                    clockConfig.setNeed_split_min(cursorQuery.getInt(i411));
                    columnIndexOrThrow497 = i411;
                    int i412 = columnIndexOrThrow498;
                    clockConfig.setSplit_min_src(cursorQuery.isNull(i412) ? null : cursorQuery.getString(i412));
                    columnIndexOrThrow498 = i412;
                    int i413 = columnIndexOrThrow499;
                    clockConfig.setSplit_min_x(cursorQuery.getInt(i413));
                    columnIndexOrThrow499 = i413;
                    int i414 = columnIndexOrThrow500;
                    clockConfig.setSplit_min_y(cursorQuery.getInt(i414));
                    columnIndexOrThrow500 = i414;
                    int i415 = columnIndexOrThrow501;
                    clockConfig.setSupport_scale(cursorQuery.getInt(i415));
                    columnIndexOrThrow501 = i415;
                    int i416 = columnIndexOrThrow502;
                    clockConfig.setShow_compass_num(cursorQuery.getInt(i416));
                    columnIndexOrThrow502 = i416;
                    int i417 = columnIndexOrThrow503;
                    clockConfig.setCompass_num_src(cursorQuery.isNull(i417) ? null : cursorQuery.getString(i417));
                    columnIndexOrThrow503 = i417;
                    int i418 = columnIndexOrThrow504;
                    clockConfig.setCompass_show_type(cursorQuery.getInt(i418));
                    columnIndexOrThrow504 = i418;
                    int i419 = columnIndexOrThrow505;
                    clockConfig.setCompass_num_x(cursorQuery.getInt(i419));
                    columnIndexOrThrow505 = i419;
                    int i420 = columnIndexOrThrow506;
                    clockConfig.setCompass_num_y(cursorQuery.getInt(i420));
                    columnIndexOrThrow506 = i420;
                    int i421 = columnIndexOrThrow507;
                    clockConfig.setCompass_num_src_prefix(cursorQuery.isNull(i421) ? null : cursorQuery.getString(i421));
                    columnIndexOrThrow507 = i421;
                    int i422 = columnIndexOrThrow508;
                    clockConfig.setCompass_num_src_sign(cursorQuery.isNull(i422) ? null : cursorQuery.getString(i422));
                    columnIndexOrThrow508 = i422;
                    int i423 = columnIndexOrThrow509;
                    clockConfig.setShow_btn_oxygen(cursorQuery.getInt(i423));
                    columnIndexOrThrow509 = i423;
                    int i424 = columnIndexOrThrow510;
                    clockConfig.setBtn_oxygen_src(cursorQuery.isNull(i424) ? null : cursorQuery.getString(i424));
                    columnIndexOrThrow510 = i424;
                    int i425 = columnIndexOrThrow511;
                    clockConfig.setBtn_oxygen_x(cursorQuery.getInt(i425));
                    columnIndexOrThrow511 = i425;
                    int i426 = columnIndexOrThrow512;
                    clockConfig.setBtn_oxygen_y(cursorQuery.getInt(i426));
                    columnIndexOrThrow512 = i426;
                    int i427 = columnIndexOrThrow513;
                    clockConfig.setShow_btn_calendar(cursorQuery.getInt(i427));
                    columnIndexOrThrow513 = i427;
                    int i428 = columnIndexOrThrow514;
                    clockConfig.setBtn_calendar_src(cursorQuery.isNull(i428) ? null : cursorQuery.getString(i428));
                    columnIndexOrThrow514 = i428;
                    int i429 = columnIndexOrThrow515;
                    clockConfig.setBtn_calendar_x(cursorQuery.getInt(i429));
                    columnIndexOrThrow515 = i429;
                    int i430 = columnIndexOrThrow516;
                    clockConfig.setBtn_calendar_y(cursorQuery.getInt(i430));
                    columnIndexOrThrow516 = i430;
                    int i431 = columnIndexOrThrow517;
                    clockConfig.setShow_btn_compass(cursorQuery.getInt(i431));
                    columnIndexOrThrow517 = i431;
                    int i432 = columnIndexOrThrow518;
                    clockConfig.setBtn_compass_src(cursorQuery.isNull(i432) ? null : cursorQuery.getString(i432));
                    columnIndexOrThrow518 = i432;
                    int i433 = columnIndexOrThrow519;
                    clockConfig.setBtn_compass_x(cursorQuery.getInt(i433));
                    columnIndexOrThrow519 = i433;
                    int i434 = columnIndexOrThrow520;
                    clockConfig.setBtn_compass_y(cursorQuery.getInt(i434));
                    columnIndexOrThrow520 = i434;
                    int i435 = columnIndexOrThrow521;
                    clockConfig.setPointer_disable_scale(cursorQuery.getInt(i435));
                    columnIndexOrThrow521 = i435;
                    int i436 = columnIndexOrThrow522;
                    clockConfig.setShow_chinse_time(cursorQuery.getInt(i436));
                    columnIndexOrThrow522 = i436;
                    int i437 = columnIndexOrThrow523;
                    clockConfig.setChinse_time_src(cursorQuery.isNull(i437) ? null : cursorQuery.getString(i437));
                    columnIndexOrThrow523 = i437;
                    int i438 = columnIndexOrThrow524;
                    clockConfig.setChinse_time_x(cursorQuery.getInt(i438));
                    columnIndexOrThrow524 = i438;
                    int i439 = columnIndexOrThrow525;
                    clockConfig.setChinse_time_y(cursorQuery.getInt(i439));
                    columnIndexOrThrow525 = i439;
                    int i440 = columnIndexOrThrow526;
                    clockConfig.setShow_btn_photo(cursorQuery.getInt(i440));
                    columnIndexOrThrow526 = i440;
                    int i441 = columnIndexOrThrow527;
                    clockConfig.setBtn_photo_src(cursorQuery.isNull(i441) ? null : cursorQuery.getString(i441));
                    columnIndexOrThrow527 = i441;
                    int i442 = columnIndexOrThrow528;
                    clockConfig.setBtn_photo_x(cursorQuery.getInt(i442));
                    columnIndexOrThrow528 = i442;
                    int i443 = columnIndexOrThrow529;
                    clockConfig.setBtn_photo_y(cursorQuery.getInt(i443));
                    columnIndexOrThrow529 = i443;
                    int i444 = columnIndexOrThrow530;
                    clockConfig.setShow_btn_contact(cursorQuery.getInt(i444));
                    columnIndexOrThrow530 = i444;
                    int i445 = columnIndexOrThrow531;
                    clockConfig.setBtn_contact_src(cursorQuery.isNull(i445) ? null : cursorQuery.getString(i445));
                    columnIndexOrThrow531 = i445;
                    int i446 = columnIndexOrThrow532;
                    clockConfig.setBtn_contact_x(cursorQuery.getInt(i446));
                    columnIndexOrThrow532 = i446;
                    int i447 = columnIndexOrThrow533;
                    clockConfig.setBtn_contact_y(cursorQuery.getInt(i447));
                    columnIndexOrThrow533 = i447;
                    int i448 = columnIndexOrThrow534;
                    clockConfig.setKcal_num_rotate(cursorQuery.getInt(i448));
                    columnIndexOrThrow534 = i448;
                    int i449 = columnIndexOrThrow535;
                    clockConfig.setKcal_num_rotate_degree(cursorQuery.getInt(i449));
                    columnIndexOrThrow535 = i449;
                    int i450 = columnIndexOrThrow536;
                    clockConfig.setShow_power_progress(cursorQuery.getInt(i450));
                    columnIndexOrThrow536 = i450;
                    int i451 = columnIndexOrThrow537;
                    clockConfig.setPower_progress_src(cursorQuery.isNull(i451) ? null : cursorQuery.getString(i451));
                    columnIndexOrThrow537 = i451;
                    int i452 = columnIndexOrThrow538;
                    clockConfig.setPower_progress_x(cursorQuery.getInt(i452));
                    columnIndexOrThrow538 = i452;
                    int i453 = columnIndexOrThrow539;
                    clockConfig.setPower_progress_y(cursorQuery.getInt(i453));
                    columnIndexOrThrow539 = i453;
                    int i454 = columnIndexOrThrow540;
                    clockConfig.setPower_src(cursorQuery.isNull(i454) ? null : cursorQuery.getString(i454));
                    columnIndexOrThrow540 = i454;
                    int i455 = columnIndexOrThrow541;
                    clockConfig.setPower_src_x(cursorQuery.getInt(i455));
                    columnIndexOrThrow541 = i455;
                    int i456 = columnIndexOrThrow542;
                    clockConfig.setPower_src_y(cursorQuery.getInt(i456));
                    columnIndexOrThrow542 = i456;
                    int i457 = columnIndexOrThrow543;
                    clockConfig.setVideo_type(cursorQuery.getInt(i457));
                    columnIndexOrThrow543 = i457;
                    int i458 = columnIndexOrThrow544;
                    clockConfig.setStep_keep_number_length(cursorQuery.getInt(i458));
                    columnIndexOrThrow544 = i458;
                    int i459 = columnIndexOrThrow545;
                    clockConfig.setKcal_keep_number_length(cursorQuery.getInt(i459));
                    columnIndexOrThrow545 = i459;
                    int i460 = columnIndexOrThrow546;
                    clockConfig.setKm_keep_number_length(cursorQuery.getInt(i460));
                    columnIndexOrThrow546 = i460;
                    int i461 = columnIndexOrThrow547;
                    clockConfig.setStep_num_rotate(cursorQuery.getInt(i461));
                    columnIndexOrThrow547 = i461;
                    int i462 = columnIndexOrThrow548;
                    clockConfig.setStep_num_rotate_degree(cursorQuery.getInt(i462));
                    columnIndexOrThrow548 = i462;
                    int i463 = columnIndexOrThrow549;
                    clockConfig.setShow_btn_style(cursorQuery.getInt(i463));
                    columnIndexOrThrow549 = i463;
                    int i464 = columnIndexOrThrow550;
                    clockConfig.setBtn_style_src(cursorQuery.isNull(i464) ? null : cursorQuery.getString(i464));
                    columnIndexOrThrow550 = i464;
                    int i465 = columnIndexOrThrow551;
                    clockConfig.setBtn_style_x(cursorQuery.getInt(i465));
                    columnIndexOrThrow551 = i465;
                    int i466 = columnIndexOrThrow552;
                    clockConfig.setBtn_style_y(cursorQuery.getInt(i466));
                    columnIndexOrThrow552 = i466;
                    int i467 = columnIndexOrThrow553;
                    clockConfig.setNeed_split_sec(cursorQuery.getInt(i467));
                    columnIndexOrThrow553 = i467;
                    int i468 = columnIndexOrThrow554;
                    clockConfig.setSplit_sec_src(cursorQuery.isNull(i468) ? null : cursorQuery.getString(i468));
                    columnIndexOrThrow554 = i468;
                    int i469 = columnIndexOrThrow555;
                    clockConfig.setSplit_sec_x(cursorQuery.getInt(i469));
                    columnIndexOrThrow555 = i469;
                    int i470 = columnIndexOrThrow556;
                    clockConfig.setSplit_sec_y(cursorQuery.getInt(i470));
                    columnIndexOrThrow556 = i470;
                    int i471 = columnIndexOrThrow557;
                    clockConfig.setOpen_oxygen_arc_show(cursorQuery.getInt(i471));
                    columnIndexOrThrow557 = i471;
                    int i472 = columnIndexOrThrow558;
                    clockConfig.setOxygen_arc_type(cursorQuery.getInt(i472));
                    columnIndexOrThrow558 = i472;
                    int i473 = columnIndexOrThrow559;
                    clockConfig.setOxygen_arc_center_x(cursorQuery.getInt(i473));
                    columnIndexOrThrow559 = i473;
                    int i474 = columnIndexOrThrow560;
                    clockConfig.setOxygen_arc_center_y(cursorQuery.getInt(i474));
                    columnIndexOrThrow560 = i474;
                    int i475 = columnIndexOrThrow561;
                    clockConfig.setShow_oxygen_progress(cursorQuery.getInt(i475));
                    columnIndexOrThrow561 = i475;
                    int i476 = columnIndexOrThrow562;
                    clockConfig.setOxygen_progress_src(cursorQuery.isNull(i476) ? null : cursorQuery.getString(i476));
                    columnIndexOrThrow562 = i476;
                    int i477 = columnIndexOrThrow563;
                    clockConfig.setOxygen_progress_x(cursorQuery.getInt(i477));
                    columnIndexOrThrow563 = i477;
                    int i478 = columnIndexOrThrow564;
                    clockConfig.setOxygen_progress_y(cursorQuery.getInt(i478));
                    columnIndexOrThrow564 = i478;
                    int i479 = columnIndexOrThrow565;
                    clockConfig.setShow_week_donts(cursorQuery.getInt(i479));
                    columnIndexOrThrow565 = i479;
                    int i480 = columnIndexOrThrow566;
                    clockConfig.setWeek_donts_src(cursorQuery.isNull(i480) ? null : cursorQuery.getString(i480));
                    columnIndexOrThrow566 = i480;
                    int i481 = columnIndexOrThrow567;
                    clockConfig.setWeek_donts_x(cursorQuery.getInt(i481));
                    columnIndexOrThrow567 = i481;
                    int i482 = columnIndexOrThrow568;
                    clockConfig.setWeek_donts_y(cursorQuery.getInt(i482));
                    columnIndexOrThrow568 = i482;
                    int i483 = columnIndexOrThrow569;
                    clockConfig.setShow_btn_flashlight(cursorQuery.getInt(i483));
                    columnIndexOrThrow569 = i483;
                    int i484 = columnIndexOrThrow570;
                    clockConfig.setFlashlight_src(cursorQuery.isNull(i484) ? null : cursorQuery.getString(i484));
                    columnIndexOrThrow570 = i484;
                    int i485 = columnIndexOrThrow571;
                    clockConfig.setFlashlight_x(cursorQuery.getInt(i485));
                    columnIndexOrThrow571 = i485;
                    int i486 = columnIndexOrThrow572;
                    clockConfig.setFlashlight_y(cursorQuery.getInt(i486));
                    arrayList.add(clockConfig);
                    columnIndexOrThrow572 = i486;
                    columnIndexOrThrow10 = i2;
                    columnIndexOrThrow252 = i168;
                    columnIndexOrThrow11 = i5;
                    columnIndexOrThrow14 = i4;
                    i = i3;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow55 = i36;
                    columnIndexOrThrow54 = i35;
                    columnIndexOrThrow63 = i44;
                    columnIndexOrThrow62 = i43;
                    columnIndexOrThrow79 = i56;
                    columnIndexOrThrow78 = i55;
                    columnIndexOrThrow89 = i64;
                    columnIndexOrThrow88 = i63;
                    columnIndexOrThrow94 = i68;
                    columnIndexOrThrow93 = i67;
                    columnIndexOrThrow108 = i72;
                    columnIndexOrThrow107 = i71;
                    columnIndexOrThrow120 = i74;
                    columnIndexOrThrow119 = i73;
                    columnIndexOrThrow139 = i92;
                    columnIndexOrThrow138 = i91;
                    columnIndexOrThrow163 = i104;
                    columnIndexOrThrow162 = i103;
                    columnIndexOrThrow167 = i108;
                    columnIndexOrThrow166 = i107;
                    columnIndexOrThrow180 = i118;
                    columnIndexOrThrow179 = i117;
                    columnIndexOrThrow190 = i124;
                    columnIndexOrThrow189 = i123;
                    columnIndexOrThrow194 = i128;
                    columnIndexOrThrow193 = i127;
                    columnIndexOrThrow203 = i136;
                    columnIndexOrThrow202 = i135;
                    columnIndexOrThrow209 = i142;
                    columnIndexOrThrow208 = i141;
                    columnIndexOrThrow228 = i154;
                    columnIndexOrThrow227 = i153;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.dw.launcher.data.database.dao.ClockConfigDao
    public ClockConfig queryAssetsById(final int id) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        ClockConfig clockConfig;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from t_clock_config where id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "path");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fromAssets");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_en");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screentype");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dialtype");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coordinate_screen_width");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coordinate_screen_height");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_type");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lottie");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_animal_keep_for_last_frame");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_count");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_interval");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_is_customize");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hour_pointer_src");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hour_pointer_x");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hour_pointer_y");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minute_pointer_src");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minute_pointer_x");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minute_pointer_y");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_src");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_x");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_y");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_animal_type");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dot_src");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dot_x");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dot_y");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_pointer_start_animation");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_start_hour");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_start_minute");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_start_second");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_need_jump");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_x");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_y");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_min");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_min_x");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_min_y");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_sec");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_sec");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_sec_x");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_sec_y");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_time_arc_show");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_arc_type");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_arc_center_x");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_arc_center_y");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_am_or_pm");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_and_pm_src");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_or_pm_x");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_or_pm_y");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_ampm_placeholer");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_digital_start_animation");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "digital_start_hour");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "digital_start_minute");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "digital_start_second");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_src");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_x");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_y");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_date_arc_show");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_arc_type");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_arc_center_x");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_arc_center_y");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_year_splt_src");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_month_splt_src");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_day_splt_src");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_year");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "year_digits_type");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_month");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_type");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_src");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_month");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data_month_num");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_x");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_y");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_day");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_day");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data_day_num");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_x");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_y");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_src");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_type");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_src");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_num_src");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_x");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_y");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_power");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_0_src");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_1_src");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_2_src");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_3_src");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_4_src");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_5_src");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_6_src");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_7_src");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_8_src");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_9_src");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_10_src");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_x");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_y");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_charge");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_0_src");
                int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_1_src");
                int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_2_src");
                int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_3_src");
                int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_4_src");
                int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_5_src");
                int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_6_src");
                int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_7_src");
                int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_8_src");
                int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_9_src");
                int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_10_src");
                int columnIndexOrThrow119 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_power_num");
                int columnIndexOrThrow120 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_num_src");
                int columnIndexOrThrow121 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_sign_src");
                int columnIndexOrThrow122 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_show_type");
                int columnIndexOrThrow123 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_num_x");
                int columnIndexOrThrow124 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_num_y");
                int columnIndexOrThrow125 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_action");
                int columnIndexOrThrow126 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_action_1");
                int columnIndexOrThrow127 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_count");
                int columnIndexOrThrow128 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_x");
                int columnIndexOrThrow129 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_y");
                int columnIndexOrThrow130 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_action_2");
                int columnIndexOrThrow131 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_count");
                int columnIndexOrThrow132 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_x");
                int columnIndexOrThrow133 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_y");
                int columnIndexOrThrow134 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_action_3");
                int columnIndexOrThrow135 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_count");
                int columnIndexOrThrow136 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_x");
                int columnIndexOrThrow137 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_y");
                int columnIndexOrThrow138 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_interval");
                int columnIndexOrThrow139 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_overall_animation");
                int columnIndexOrThrow140 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "overall_animation_x");
                int columnIndexOrThrow141 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "overall_animation_y");
                int columnIndexOrThrow142 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_1");
                int columnIndexOrThrow143 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_x");
                int columnIndexOrThrow144 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_y");
                int columnIndexOrThrow145 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_width");
                int columnIndexOrThrow146 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_height");
                int columnIndexOrThrow147 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_2");
                int columnIndexOrThrow148 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_x");
                int columnIndexOrThrow149 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_y");
                int columnIndexOrThrow150 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_width");
                int columnIndexOrThrow151 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_height");
                int columnIndexOrThrow152 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_3");
                int columnIndexOrThrow153 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_x");
                int columnIndexOrThrow154 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_y");
                int columnIndexOrThrow155 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_width");
                int columnIndexOrThrow156 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_height");
                int columnIndexOrThrow157 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_4");
                int columnIndexOrThrow158 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_x");
                int columnIndexOrThrow159 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_y");
                int columnIndexOrThrow160 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_width");
                int columnIndexOrThrow161 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_height");
                int columnIndexOrThrow162 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_lunar");
                int columnIndexOrThrow163 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_src");
                int columnIndexOrThrow164 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_x");
                int columnIndexOrThrow165 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_y");
                int columnIndexOrThrow166 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_heart");
                int columnIndexOrThrow167 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_src");
                int columnIndexOrThrow168 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_x");
                int columnIndexOrThrow169 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_y");
                int columnIndexOrThrow170 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_src");
                int columnIndexOrThrow171 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_type");
                int columnIndexOrThrow172 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_end_src");
                int columnIndexOrThrow173 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_show_type");
                int columnIndexOrThrow174 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_x");
                int columnIndexOrThrow175 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_y");
                int columnIndexOrThrow176 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_heart_arc_show");
                int columnIndexOrThrow177 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_arc_type");
                int columnIndexOrThrow178 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_arc_center_x");
                int columnIndexOrThrow179 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_arc_center_y");
                int columnIndexOrThrow180 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_pressure");
                int columnIndexOrThrow181 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_src");
                int columnIndexOrThrow182 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_x");
                int columnIndexOrThrow183 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_y");
                int columnIndexOrThrow184 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_num_src");
                int columnIndexOrThrow185 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_num_x");
                int columnIndexOrThrow186 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_num_y");
                int columnIndexOrThrow187 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_show_type");
                int columnIndexOrThrow188 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_splt_src");
                int columnIndexOrThrow189 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_step");
                int columnIndexOrThrow190 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_src");
                int columnIndexOrThrow191 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_follow_num");
                int columnIndexOrThrow192 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_x");
                int columnIndexOrThrow193 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_y");
                int columnIndexOrThrow194 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_src");
                int columnIndexOrThrow195 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_type");
                int columnIndexOrThrow196 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_show_type");
                int columnIndexOrThrow197 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_x");
                int columnIndexOrThrow198 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_y");
                int columnIndexOrThrow199 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_end_src");
                int columnIndexOrThrow200 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_step_progress");
                int columnIndexOrThrow201 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_progress_x");
                int columnIndexOrThrow202 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_progress_y");
                int columnIndexOrThrow203 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_progress_src");
                int columnIndexOrThrow204 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_step_arc_show");
                int columnIndexOrThrow205 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_arc_type");
                int columnIndexOrThrow206 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_arc_center_x");
                int columnIndexOrThrow207 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_arc_center_y");
                int columnIndexOrThrow208 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_kcal");
                int columnIndexOrThrow209 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_src");
                int columnIndexOrThrow210 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_x");
                int columnIndexOrThrow211 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_y");
                int columnIndexOrThrow212 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_src");
                int columnIndexOrThrow213 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_type");
                int columnIndexOrThrow214 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_show_type");
                int columnIndexOrThrow215 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_x");
                int columnIndexOrThrow216 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_y");
                int columnIndexOrThrow217 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_end_src");
                int columnIndexOrThrow218 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_km");
                int columnIndexOrThrow219 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_src");
                int columnIndexOrThrow220 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_x");
                int columnIndexOrThrow221 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_y");
                int columnIndexOrThrow222 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_src");
                int columnIndexOrThrow223 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_comma_src");
                int columnIndexOrThrow224 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_type");
                int columnIndexOrThrow225 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_show_type");
                int columnIndexOrThrow226 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_x");
                int columnIndexOrThrow227 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_y");
                int columnIndexOrThrow228 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_end_src");
                int columnIndexOrThrow229 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_weather");
                int columnIndexOrThrow230 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_temperature");
                int columnIndexOrThrow231 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_show_type");
                int columnIndexOrThrow232 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_num_type");
                int columnIndexOrThrow233 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_x");
                int columnIndexOrThrow234 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_y");
                int columnIndexOrThrow235 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_x_2");
                int columnIndexOrThrow236 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_y_2");
                int columnIndexOrThrow237 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_now_tem");
                int columnIndexOrThrow238 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_show_type");
                int columnIndexOrThrow239 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_x");
                int columnIndexOrThrow240 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_y");
                int columnIndexOrThrow241 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_num_src");
                int columnIndexOrThrow242 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_sub_src");
                int columnIndexOrThrow243 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_sign_src");
                int columnIndexOrThrow244 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_splt_src");
                int columnIndexOrThrow245 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_diagram");
                int columnIndexOrThrow246 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "diagram_x");
                int columnIndexOrThrow247 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "diagram_y");
                int columnIndexOrThrow248 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "showsignal");
                int columnIndexOrThrow249 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_signal");
                int columnIndexOrThrow250 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "signal_src");
                int columnIndexOrThrow251 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "signal_x");
                int columnIndexOrThrow252 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "signal_y");
                int columnIndexOrThrow253 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_user_name");
                int columnIndexOrThrow254 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_show_type");
                int columnIndexOrThrow255 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_x");
                int columnIndexOrThrow256 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_y");
                int columnIndexOrThrow257 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_operator");
                int columnIndexOrThrow258 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "operator_show_type");
                int columnIndexOrThrow259 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "operator_x");
                int columnIndexOrThrow260 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "operator_y");
                int columnIndexOrThrow261 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_call");
                int columnIndexOrThrow262 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_call_src");
                int columnIndexOrThrow263 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_call_x");
                int columnIndexOrThrow264 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_call_y");
                int columnIndexOrThrow265 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sms");
                int columnIndexOrThrow266 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sms_src");
                int columnIndexOrThrow267 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sms_x");
                int columnIndexOrThrow268 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sms_y");
                int columnIndexOrThrow269 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_heart");
                int columnIndexOrThrow270 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_our_heart");
                int columnIndexOrThrow271 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_heart_src");
                int columnIndexOrThrow272 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_heart_x");
                int columnIndexOrThrow273 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_heart_y");
                int columnIndexOrThrow274 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_step");
                int columnIndexOrThrow275 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_step_src");
                int columnIndexOrThrow276 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_step_x");
                int columnIndexOrThrow277 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_step_y");
                int columnIndexOrThrow278 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_wechat");
                int columnIndexOrThrow279 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_wechat_src");
                int columnIndexOrThrow280 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_wechat_x");
                int columnIndexOrThrow281 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_wechat_y");
                int columnIndexOrThrow282 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_alipay");
                int columnIndexOrThrow283 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alipay_src");
                int columnIndexOrThrow284 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alipay_x");
                int columnIndexOrThrow285 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alipay_y");
                int columnIndexOrThrow286 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_stopwatch");
                int columnIndexOrThrow287 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_stopwatch_src");
                int columnIndexOrThrow288 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_stopwatch_x");
                int columnIndexOrThrow289 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_stopwatch_y");
                int columnIndexOrThrow290 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_weather");
                int columnIndexOrThrow291 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calo");
                int columnIndexOrThrow292 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calo_src");
                int columnIndexOrThrow293 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calo_x");
                int columnIndexOrThrow294 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calo_y");
                int columnIndexOrThrow295 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temprature_src");
                int columnIndexOrThrow296 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_camera");
                int columnIndexOrThrow297 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_camera_src");
                int columnIndexOrThrow298 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_camera_x");
                int columnIndexOrThrow299 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_camera_y");
                int columnIndexOrThrow300 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sos");
                int columnIndexOrThrow301 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sos_src");
                int columnIndexOrThrow302 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sos_x");
                int columnIndexOrThrow303 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sos_y");
                int columnIndexOrThrow304 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_special_1");
                int columnIndexOrThrow305 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_1_src");
                int columnIndexOrThrow306 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_1_position");
                int columnIndexOrThrow307 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_x");
                int columnIndexOrThrow308 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_y");
                int columnIndexOrThrow309 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_multiple_change");
                int columnIndexOrThrow310 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_lunar_year");
                int columnIndexOrThrow311 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_day_splt_src");
                int columnIndexOrThrow312 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_month_splt_src");
                int columnIndexOrThrow313 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_year_splt_src");
                int columnIndexOrThrow314 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_src");
                int columnIndexOrThrow315 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pm_src");
                int columnIndexOrThrow316 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_alarm");
                int columnIndexOrThrow317 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alarm_src");
                int columnIndexOrThrow318 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alarm_x");
                int columnIndexOrThrow319 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alarm_y");
                int columnIndexOrThrow320 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_btn_change");
                int columnIndexOrThrow321 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_btn_index");
                int columnIndexOrThrow322 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_music");
                int columnIndexOrThrow323 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_music_src");
                int columnIndexOrThrow324 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_music_x");
                int columnIndexOrThrow325 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_music_y");
                int columnIndexOrThrow326 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_dynamic_change");
                int columnIndexOrThrow327 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "level");
                int columnIndexOrThrow328 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parent_id");
                int columnIndexOrThrow329 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_id");
                int columnIndexOrThrow330 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "change_starttime");
                int columnIndexOrThrow331 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "change_endtime");
                int columnIndexOrThrow332 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_weather_src");
                int columnIndexOrThrow333 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_weather_x");
                int columnIndexOrThrow334 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_weather_y");
                int columnIndexOrThrow335 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calories");
                int columnIndexOrThrow336 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calories_src");
                int columnIndexOrThrow337 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calories_x");
                int columnIndexOrThrow338 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calories_y");
                int columnIndexOrThrow339 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_compass");
                int columnIndexOrThrow340 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_src");
                int columnIndexOrThrow341 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_2_src");
                int columnIndexOrThrow342 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_x");
                int columnIndexOrThrow343 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_y");
                int columnIndexOrThrow344 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_setting");
                int columnIndexOrThrow345 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_setting_src");
                int columnIndexOrThrow346 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_setting_x");
                int columnIndexOrThrow347 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_setting_y");
                int columnIndexOrThrow348 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_click_change");
                int columnIndexOrThrow349 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_id_is_current");
                int columnIndexOrThrow350 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_show_detail_degree");
                int columnIndexOrThrow351 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_src");
                int columnIndexOrThrow352 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_x");
                int columnIndexOrThrow353 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_y");
                int columnIndexOrThrow354 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_2_src");
                int columnIndexOrThrow355 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_2_x");
                int columnIndexOrThrow356 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_2_y");
                int columnIndexOrThrow357 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_3_src");
                int columnIndexOrThrow358 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_3_x");
                int columnIndexOrThrow359 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_3_y");
                int columnIndexOrThrow360 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_src");
                int columnIndexOrThrow361 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_x");
                int columnIndexOrThrow362 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_y");
                int columnIndexOrThrow363 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_unit");
                int columnIndexOrThrow364 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_1_src");
                int columnIndexOrThrow365 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_1_x");
                int columnIndexOrThrow366 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_1_y");
                int columnIndexOrThrow367 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_2_src");
                int columnIndexOrThrow368 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_2_x");
                int columnIndexOrThrow369 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_2_y");
                int columnIndexOrThrow370 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_3_src");
                int columnIndexOrThrow371 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_3_x");
                int columnIndexOrThrow372 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_3_y");
                int columnIndexOrThrow373 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_connect_animation");
                int columnIndexOrThrow374 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connect_animation_x");
                int columnIndexOrThrow375 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connect_animation_y");
                int columnIndexOrThrow376 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connect_animation_count");
                int columnIndexOrThrow377 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_state");
                int columnIndexOrThrow378 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state_x");
                int columnIndexOrThrow379 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state_y");
                int columnIndexOrThrow380 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_cut_position");
                int columnIndexOrThrow381 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_cut_position");
                int columnIndexOrThrow382 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_cut_position");
                int columnIndexOrThrow383 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_googleplay");
                int columnIndexOrThrow384 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_googleplay_src");
                int columnIndexOrThrow385 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_googleplay_x");
                int columnIndexOrThrow386 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_googleplay_y");
                int columnIndexOrThrow387 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_month_2");
                int columnIndexOrThrow388 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_type_2");
                int columnIndexOrThrow389 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_src_2");
                int columnIndexOrThrow390 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_x_2");
                int columnIndexOrThrow391 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_y_2");
                int columnIndexOrThrow392 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_new");
                int columnIndexOrThrow393 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_hour_ten_src");
                int columnIndexOrThrow394 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_hour_src");
                int columnIndexOrThrow395 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_min_ten_src");
                int columnIndexOrThrow396 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_min_src");
                int columnIndexOrThrow397 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_kcal_progress");
                int columnIndexOrThrow398 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_progress_x");
                int columnIndexOrThrow399 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_progress_y");
                int columnIndexOrThrow400 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_progress_src");
                int columnIndexOrThrow401 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_kcal_arc_show");
                int columnIndexOrThrow402 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_arc_type");
                int columnIndexOrThrow403 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_arc_center_x");
                int columnIndexOrThrow404 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_arc_center_y");
                int columnIndexOrThrow405 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_power_arc_show");
                int columnIndexOrThrow406 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_arc_type");
                int columnIndexOrThrow407 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_arc_center_x");
                int columnIndexOrThrow408 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_arc_center_y");
                int columnIndexOrThrow409 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_timer");
                int columnIndexOrThrow410 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_timer_src");
                int columnIndexOrThrow411 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_timer_x");
                int columnIndexOrThrow412 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_timer_y");
                int columnIndexOrThrow413 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sleep");
                int columnIndexOrThrow414 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sleep_src");
                int columnIndexOrThrow415 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sleep_x");
                int columnIndexOrThrow416 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sleep_y");
                int columnIndexOrThrow417 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_bloodpressure");
                int columnIndexOrThrow418 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_bloodpressure_src");
                int columnIndexOrThrow419 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_bloodpressure_x");
                int columnIndexOrThrow420 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_bloodpressure_y");
                int columnIndexOrThrow421 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sport_record");
                int columnIndexOrThrow422 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sport_record_src");
                int columnIndexOrThrow423 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sport_record_x");
                int columnIndexOrThrow424 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sport_record_y");
                int columnIndexOrThrow425 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lottie_hierarchy");
                int columnIndexOrThrow426 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_heart_progress");
                int columnIndexOrThrow427 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_progress_x");
                int columnIndexOrThrow428 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_progress_y");
                int columnIndexOrThrow429 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_progress_src");
                int columnIndexOrThrow430 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calculator");
                int columnIndexOrThrow431 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calculator_src");
                int columnIndexOrThrow432 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calculator_x");
                int columnIndexOrThrow433 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calculator_y");
                int columnIndexOrThrow434 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_drag_3d");
                int columnIndexOrThrow435 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_HourTen_Position");
                int columnIndexOrThrow436 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_HourGe_Position");
                int columnIndexOrThrow437 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_HourTen_Position");
                int columnIndexOrThrow438 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_HourGe_Position");
                int columnIndexOrThrow439 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_HourTen_Position");
                int columnIndexOrThrow440 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_HourGe_Position");
                int columnIndexOrThrow441 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_MinTen_Position");
                int columnIndexOrThrow442 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_MinGe_Position");
                int columnIndexOrThrow443 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_MinTen_Position");
                int columnIndexOrThrow444 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_MinGe_Position");
                int columnIndexOrThrow445 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_MinTen_Position");
                int columnIndexOrThrow446 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_MinGe_Position");
                int columnIndexOrThrow447 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_day");
                int columnIndexOrThrow448 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_day_x");
                int columnIndexOrThrow449 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_day_y");
                int columnIndexOrThrow450 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_now_tem_arc_show");
                int columnIndexOrThrow451 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_arc_type");
                int columnIndexOrThrow452 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_arc_center_x");
                int columnIndexOrThrow453 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_arc_center_y");
                int columnIndexOrThrow454 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_km_progress");
                int columnIndexOrThrow455 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_progress_x");
                int columnIndexOrThrow456 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_progress_y");
                int columnIndexOrThrow457 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_progress_src");
                int columnIndexOrThrow458 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_km_arc_show");
                int columnIndexOrThrow459 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_arc_type");
                int columnIndexOrThrow460 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_arc_center_x");
                int columnIndexOrThrow461 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_arc_center_y");
                int columnIndexOrThrow462 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_rotate");
                int columnIndexOrThrow463 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_rotate_degree");
                int columnIndexOrThrow464 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_rotate");
                int columnIndexOrThrow465 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_rotate_degree");
                int columnIndexOrThrow466 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_oxygen");
                int columnIndexOrThrow467 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_src");
                int columnIndexOrThrow468 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_x");
                int columnIndexOrThrow469 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_y");
                int columnIndexOrThrow470 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_num_src");
                int columnIndexOrThrow471 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_sign_src");
                int columnIndexOrThrow472 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_show_type");
                int columnIndexOrThrow473 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_num_x");
                int columnIndexOrThrow474 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_num_y");
                int columnIndexOrThrow475 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_change_counter");
                int columnIndexOrThrow476 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src_2");
                int columnIndexOrThrow477 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src_2");
                int columnIndexOrThrow478 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src_2");
                int columnIndexOrThrow479 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src_2");
                int columnIndexOrThrow480 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src_2");
                int columnIndexOrThrow481 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src_3");
                int columnIndexOrThrow482 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src_3");
                int columnIndexOrThrow483 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src_3");
                int columnIndexOrThrow484 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src_3");
                int columnIndexOrThrow485 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src_3");
                int columnIndexOrThrow486 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src_4");
                int columnIndexOrThrow487 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src_4");
                int columnIndexOrThrow488 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src_4");
                int columnIndexOrThrow489 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src_4");
                int columnIndexOrThrow490 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src_4");
                int columnIndexOrThrow491 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_rotate");
                int columnIndexOrThrow492 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_rotate_degree");
                int columnIndexOrThrow493 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_hour");
                int columnIndexOrThrow494 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_hour_src");
                int columnIndexOrThrow495 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_hour_x");
                int columnIndexOrThrow496 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_hour_y");
                int columnIndexOrThrow497 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_min");
                int columnIndexOrThrow498 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_min_src");
                int columnIndexOrThrow499 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_min_x");
                int columnIndexOrThrow500 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_min_y");
                int columnIndexOrThrow501 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_scale");
                int columnIndexOrThrow502 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_compass_num");
                int columnIndexOrThrow503 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_src");
                int columnIndexOrThrow504 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_show_type");
                int columnIndexOrThrow505 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_x");
                int columnIndexOrThrow506 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_y");
                int columnIndexOrThrow507 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_src_prefix");
                int columnIndexOrThrow508 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_src_sign");
                int columnIndexOrThrow509 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_oxygen");
                int columnIndexOrThrow510 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_oxygen_src");
                int columnIndexOrThrow511 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_oxygen_x");
                int columnIndexOrThrow512 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_oxygen_y");
                int columnIndexOrThrow513 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calendar");
                int columnIndexOrThrow514 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calendar_src");
                int columnIndexOrThrow515 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calendar_x");
                int columnIndexOrThrow516 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calendar_y");
                int columnIndexOrThrow517 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_compass");
                int columnIndexOrThrow518 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_compass_src");
                int columnIndexOrThrow519 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_compass_x");
                int columnIndexOrThrow520 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_compass_y");
                int columnIndexOrThrow521 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_disable_scale");
                int columnIndexOrThrow522 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_chinse_time");
                int columnIndexOrThrow523 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chinse_time_src");
                int columnIndexOrThrow524 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chinse_time_x");
                int columnIndexOrThrow525 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chinse_time_y");
                int columnIndexOrThrow526 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_photo");
                int columnIndexOrThrow527 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_photo_src");
                int columnIndexOrThrow528 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_photo_x");
                int columnIndexOrThrow529 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_photo_y");
                int columnIndexOrThrow530 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_contact");
                int columnIndexOrThrow531 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_contact_src");
                int columnIndexOrThrow532 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_contact_x");
                int columnIndexOrThrow533 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_contact_y");
                int columnIndexOrThrow534 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_rotate");
                int columnIndexOrThrow535 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_rotate_degree");
                int columnIndexOrThrow536 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_power_progress");
                int columnIndexOrThrow537 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_progress_src");
                int columnIndexOrThrow538 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_progress_x");
                int columnIndexOrThrow539 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_progress_y");
                int columnIndexOrThrow540 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_src");
                int columnIndexOrThrow541 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_src_x");
                int columnIndexOrThrow542 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_src_y");
                int columnIndexOrThrow543 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_type");
                int columnIndexOrThrow544 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_keep_number_length");
                int columnIndexOrThrow545 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_keep_number_length");
                int columnIndexOrThrow546 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_keep_number_length");
                int columnIndexOrThrow547 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_rotate");
                int columnIndexOrThrow548 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_rotate_degree");
                int columnIndexOrThrow549 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_style");
                int columnIndexOrThrow550 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_style_src");
                int columnIndexOrThrow551 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_style_x");
                int columnIndexOrThrow552 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_style_y");
                int columnIndexOrThrow553 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_sec");
                int columnIndexOrThrow554 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_sec_src");
                int columnIndexOrThrow555 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_sec_x");
                int columnIndexOrThrow556 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_sec_y");
                int columnIndexOrThrow557 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_oxygen_arc_show");
                int columnIndexOrThrow558 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_arc_type");
                int columnIndexOrThrow559 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_arc_center_x");
                int columnIndexOrThrow560 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_arc_center_y");
                int columnIndexOrThrow561 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_oxygen_progress");
                int columnIndexOrThrow562 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_progress_src");
                int columnIndexOrThrow563 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_progress_x");
                int columnIndexOrThrow564 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_progress_y");
                int columnIndexOrThrow565 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_week_donts");
                int columnIndexOrThrow566 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_donts_src");
                int columnIndexOrThrow567 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_donts_x");
                int columnIndexOrThrow568 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_donts_y");
                int columnIndexOrThrow569 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_flashlight");
                int columnIndexOrThrow570 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flashlight_src");
                int columnIndexOrThrow571 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flashlight_x");
                int columnIndexOrThrow572 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flashlight_y");
                if (cursorQuery.moveToFirst()) {
                    ClockConfig clockConfig2 = new ClockConfig();
                    clockConfig2.setPath(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                    clockConfig2.setFromAssets(cursorQuery.getInt(columnIndexOrThrow2) != 0);
                    clockConfig2.setId(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    clockConfig2.setName(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    clockConfig2.setName_en(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    clockConfig2.setScreentype(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    clockConfig2.setDialtype(cursorQuery.getInt(columnIndexOrThrow7));
                    clockConfig2.setCoordinate_screen_width(cursorQuery.getInt(columnIndexOrThrow8));
                    clockConfig2.setCoordinate_screen_height(cursorQuery.getInt(columnIndexOrThrow9));
                    clockConfig2.setBg_type(cursorQuery.getInt(columnIndexOrThrow10));
                    clockConfig2.setVideo(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    clockConfig2.setLottie(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    clockConfig2.setBg_animal_keep_for_last_frame(cursorQuery.getInt(columnIndexOrThrow13));
                    clockConfig2.setBg_count(cursorQuery.getInt(columnIndexOrThrow14));
                    clockConfig2.setBg_interval(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    clockConfig2.setBg_is_customize(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    clockConfig2.setHour_pointer_src(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                    clockConfig2.setHour_pointer_x(cursorQuery.getInt(columnIndexOrThrow18));
                    clockConfig2.setHour_pointer_y(cursorQuery.getInt(columnIndexOrThrow19));
                    clockConfig2.setMinute_pointer_src(cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20));
                    clockConfig2.setMinute_pointer_x(cursorQuery.getInt(columnIndexOrThrow21));
                    clockConfig2.setMinute_pointer_y(cursorQuery.getInt(columnIndexOrThrow22));
                    clockConfig2.setSecond_pointer_src(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    clockConfig2.setSecond_pointer_type(cursorQuery.getInt(columnIndexOrThrow24));
                    clockConfig2.setSecond_pointer_x(cursorQuery.getInt(columnIndexOrThrow25));
                    clockConfig2.setSecond_pointer_y(cursorQuery.getInt(columnIndexOrThrow26));
                    clockConfig2.setSecond_pointer_animal_type(cursorQuery.getInt(columnIndexOrThrow27));
                    clockConfig2.setDot_src(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    clockConfig2.setDot_x(cursorQuery.getInt(columnIndexOrThrow29));
                    clockConfig2.setDot_y(cursorQuery.getInt(columnIndexOrThrow30));
                    clockConfig2.setShow_pointer_start_animation(cursorQuery.getInt(columnIndexOrThrow31));
                    clockConfig2.setPointer_start_hour(cursorQuery.getInt(columnIndexOrThrow32));
                    clockConfig2.setPointer_start_minute(cursorQuery.getInt(columnIndexOrThrow33));
                    clockConfig2.setPointer_start_second(cursorQuery.getInt(columnIndexOrThrow34));
                    clockConfig2.setTime_hour_src(cursorQuery.isNull(columnIndexOrThrow35) ? null : cursorQuery.getString(columnIndexOrThrow35));
                    clockConfig2.setTime_min_src(cursorQuery.isNull(columnIndexOrThrow36) ? null : cursorQuery.getString(columnIndexOrThrow36));
                    clockConfig2.setTime_sec_src(cursorQuery.isNull(columnIndexOrThrow37) ? null : cursorQuery.getString(columnIndexOrThrow37));
                    clockConfig2.setTime_splt_src(cursorQuery.isNull(columnIndexOrThrow38) ? null : cursorQuery.getString(columnIndexOrThrow38));
                    clockConfig2.setTime_splt_2_src(cursorQuery.isNull(columnIndexOrThrow39) ? null : cursorQuery.getString(columnIndexOrThrow39));
                    clockConfig2.setTime_splt_need_jump(cursorQuery.getInt(columnIndexOrThrow40));
                    clockConfig2.setTime_x(cursorQuery.getInt(columnIndexOrThrow41));
                    clockConfig2.setTime_y(cursorQuery.getInt(columnIndexOrThrow42));
                    clockConfig2.setNeed_reset_min(cursorQuery.getInt(columnIndexOrThrow43));
                    clockConfig2.setReset_min_x(cursorQuery.getInt(columnIndexOrThrow44));
                    clockConfig2.setReset_min_y(cursorQuery.getInt(columnIndexOrThrow45));
                    clockConfig2.setShow_sec(cursorQuery.getInt(columnIndexOrThrow46));
                    clockConfig2.setNeed_reset_sec(cursorQuery.getInt(columnIndexOrThrow47));
                    clockConfig2.setReset_sec_x(cursorQuery.getInt(columnIndexOrThrow48));
                    clockConfig2.setReset_sec_y(cursorQuery.getInt(columnIndexOrThrow49));
                    clockConfig2.setOpen_time_arc_show(cursorQuery.getInt(columnIndexOrThrow50));
                    clockConfig2.setTime_arc_type(cursorQuery.getInt(columnIndexOrThrow51));
                    clockConfig2.setTime_arc_center_x(cursorQuery.getInt(columnIndexOrThrow52));
                    clockConfig2.setTime_arc_center_y(cursorQuery.getInt(columnIndexOrThrow53));
                    clockConfig2.setShow_am_or_pm(cursorQuery.getInt(columnIndexOrThrow54));
                    clockConfig2.setAm_and_pm_src(cursorQuery.isNull(columnIndexOrThrow55) ? null : cursorQuery.getString(columnIndexOrThrow55));
                    clockConfig2.setAm_or_pm_x(cursorQuery.getInt(columnIndexOrThrow56));
                    clockConfig2.setAm_or_pm_y(cursorQuery.getInt(columnIndexOrThrow57));
                    clockConfig2.setShow_ampm_placeholer(cursorQuery.getInt(columnIndexOrThrow58));
                    clockConfig2.setShow_digital_start_animation(cursorQuery.getInt(columnIndexOrThrow59));
                    clockConfig2.setDigital_start_hour(cursorQuery.getInt(columnIndexOrThrow60));
                    clockConfig2.setDigital_start_minute(cursorQuery.getInt(columnIndexOrThrow61));
                    clockConfig2.setDigital_start_second(cursorQuery.getInt(columnIndexOrThrow62));
                    clockConfig2.setDate_src(cursorQuery.isNull(columnIndexOrThrow63) ? null : cursorQuery.getString(columnIndexOrThrow63));
                    clockConfig2.setDate_x(cursorQuery.getInt(columnIndexOrThrow64));
                    clockConfig2.setDate_y(cursorQuery.getInt(columnIndexOrThrow65));
                    clockConfig2.setOpen_date_arc_show(cursorQuery.getInt(columnIndexOrThrow66));
                    clockConfig2.setDate_arc_type(cursorQuery.getInt(columnIndexOrThrow67));
                    clockConfig2.setDate_arc_center_x(cursorQuery.getInt(columnIndexOrThrow68));
                    clockConfig2.setDate_arc_center_y(cursorQuery.getInt(columnIndexOrThrow69));
                    clockConfig2.setDate_year_splt_src(cursorQuery.isNull(columnIndexOrThrow70) ? null : cursorQuery.getString(columnIndexOrThrow70));
                    clockConfig2.setDate_month_splt_src(cursorQuery.isNull(columnIndexOrThrow71) ? null : cursorQuery.getString(columnIndexOrThrow71));
                    clockConfig2.setDate_day_splt_src(cursorQuery.isNull(columnIndexOrThrow72) ? null : cursorQuery.getString(columnIndexOrThrow72));
                    clockConfig2.setShow_year(cursorQuery.getInt(columnIndexOrThrow73));
                    clockConfig2.setYear_digits_type(cursorQuery.getInt(columnIndexOrThrow74));
                    clockConfig2.setShow_month(cursorQuery.getInt(columnIndexOrThrow75));
                    clockConfig2.setMonth_type(cursorQuery.getInt(columnIndexOrThrow76));
                    clockConfig2.setMonth_src(cursorQuery.isNull(columnIndexOrThrow77) ? null : cursorQuery.getString(columnIndexOrThrow77));
                    clockConfig2.setNeed_reset_month(cursorQuery.getInt(columnIndexOrThrow78));
                    clockConfig2.setData_month_num(cursorQuery.isNull(columnIndexOrThrow79) ? null : cursorQuery.getString(columnIndexOrThrow79));
                    clockConfig2.setMonth_x(cursorQuery.getInt(columnIndexOrThrow80));
                    clockConfig2.setMonth_y(cursorQuery.getInt(columnIndexOrThrow81));
                    clockConfig2.setShow_day(cursorQuery.getInt(columnIndexOrThrow82));
                    clockConfig2.setNeed_reset_day(cursorQuery.getInt(columnIndexOrThrow83));
                    clockConfig2.setData_day_num(cursorQuery.isNull(columnIndexOrThrow84) ? null : cursorQuery.getString(columnIndexOrThrow84));
                    clockConfig2.setDay_x(cursorQuery.getInt(columnIndexOrThrow85));
                    clockConfig2.setDay_y(cursorQuery.getInt(columnIndexOrThrow86));
                    clockConfig2.setDay_src(cursorQuery.isNull(columnIndexOrThrow87) ? null : cursorQuery.getString(columnIndexOrThrow87));
                    clockConfig2.setDay_type(cursorQuery.getInt(columnIndexOrThrow88));
                    clockConfig2.setWeek_src(cursorQuery.isNull(columnIndexOrThrow89) ? null : cursorQuery.getString(columnIndexOrThrow89));
                    clockConfig2.setWeek_num_src(cursorQuery.isNull(columnIndexOrThrow90) ? null : cursorQuery.getString(columnIndexOrThrow90));
                    clockConfig2.setWeek_x(cursorQuery.getInt(columnIndexOrThrow91));
                    clockConfig2.setWeek_y(cursorQuery.getInt(columnIndexOrThrow92));
                    clockConfig2.setShow_power(cursorQuery.getInt(columnIndexOrThrow93));
                    clockConfig2.setNormal_0_src(cursorQuery.isNull(columnIndexOrThrow94) ? null : cursorQuery.getString(columnIndexOrThrow94));
                    clockConfig2.setNormal_1_src(cursorQuery.isNull(columnIndexOrThrow95) ? null : cursorQuery.getString(columnIndexOrThrow95));
                    clockConfig2.setNormal_2_src(cursorQuery.isNull(columnIndexOrThrow96) ? null : cursorQuery.getString(columnIndexOrThrow96));
                    clockConfig2.setNormal_3_src(cursorQuery.isNull(columnIndexOrThrow97) ? null : cursorQuery.getString(columnIndexOrThrow97));
                    clockConfig2.setNormal_4_src(cursorQuery.isNull(columnIndexOrThrow98) ? null : cursorQuery.getString(columnIndexOrThrow98));
                    clockConfig2.setNormal_5_src(cursorQuery.isNull(columnIndexOrThrow99) ? null : cursorQuery.getString(columnIndexOrThrow99));
                    clockConfig2.setNormal_6_src(cursorQuery.isNull(columnIndexOrThrow100) ? null : cursorQuery.getString(columnIndexOrThrow100));
                    clockConfig2.setNormal_7_src(cursorQuery.isNull(columnIndexOrThrow101) ? null : cursorQuery.getString(columnIndexOrThrow101));
                    clockConfig2.setNormal_8_src(cursorQuery.isNull(columnIndexOrThrow102) ? null : cursorQuery.getString(columnIndexOrThrow102));
                    clockConfig2.setNormal_9_src(cursorQuery.isNull(columnIndexOrThrow103) ? null : cursorQuery.getString(columnIndexOrThrow103));
                    clockConfig2.setNormal_10_src(cursorQuery.isNull(columnIndexOrThrow104) ? null : cursorQuery.getString(columnIndexOrThrow104));
                    clockConfig2.setPower_x(cursorQuery.getInt(columnIndexOrThrow105));
                    clockConfig2.setPower_y(cursorQuery.getInt(columnIndexOrThrow106));
                    clockConfig2.setShow_charge(cursorQuery.getInt(columnIndexOrThrow107));
                    clockConfig2.setCharge_0_src(cursorQuery.isNull(columnIndexOrThrow108) ? null : cursorQuery.getString(columnIndexOrThrow108));
                    clockConfig2.setCharge_1_src(cursorQuery.isNull(columnIndexOrThrow109) ? null : cursorQuery.getString(columnIndexOrThrow109));
                    clockConfig2.setCharge_2_src(cursorQuery.isNull(columnIndexOrThrow110) ? null : cursorQuery.getString(columnIndexOrThrow110));
                    clockConfig2.setCharge_3_src(cursorQuery.isNull(columnIndexOrThrow111) ? null : cursorQuery.getString(columnIndexOrThrow111));
                    clockConfig2.setCharge_4_src(cursorQuery.isNull(columnIndexOrThrow112) ? null : cursorQuery.getString(columnIndexOrThrow112));
                    clockConfig2.setCharge_5_src(cursorQuery.isNull(columnIndexOrThrow113) ? null : cursorQuery.getString(columnIndexOrThrow113));
                    clockConfig2.setCharge_6_src(cursorQuery.isNull(columnIndexOrThrow114) ? null : cursorQuery.getString(columnIndexOrThrow114));
                    clockConfig2.setCharge_7_src(cursorQuery.isNull(columnIndexOrThrow115) ? null : cursorQuery.getString(columnIndexOrThrow115));
                    clockConfig2.setCharge_8_src(cursorQuery.isNull(columnIndexOrThrow116) ? null : cursorQuery.getString(columnIndexOrThrow116));
                    clockConfig2.setCharge_9_src(cursorQuery.isNull(columnIndexOrThrow117) ? null : cursorQuery.getString(columnIndexOrThrow117));
                    clockConfig2.setCharge_10_src(cursorQuery.isNull(columnIndexOrThrow118) ? null : cursorQuery.getString(columnIndexOrThrow118));
                    clockConfig2.setShow_power_num(cursorQuery.getInt(columnIndexOrThrow119));
                    clockConfig2.setPower_num_src(cursorQuery.isNull(columnIndexOrThrow120) ? null : cursorQuery.getString(columnIndexOrThrow120));
                    clockConfig2.setPower_sign_src(cursorQuery.isNull(columnIndexOrThrow121) ? null : cursorQuery.getString(columnIndexOrThrow121));
                    clockConfig2.setPower_show_type(cursorQuery.getInt(columnIndexOrThrow122));
                    clockConfig2.setPower_num_x(cursorQuery.getInt(columnIndexOrThrow123));
                    clockConfig2.setPower_num_y(cursorQuery.getInt(columnIndexOrThrow124));
                    clockConfig2.setShow_action(cursorQuery.getInt(columnIndexOrThrow125));
                    clockConfig2.setOpen_action_1(cursorQuery.getInt(columnIndexOrThrow126));
                    clockConfig2.setAction_1_count(cursorQuery.getInt(columnIndexOrThrow127));
                    clockConfig2.setAction_1_x(cursorQuery.getInt(columnIndexOrThrow128));
                    clockConfig2.setAction_1_y(cursorQuery.getInt(columnIndexOrThrow129));
                    clockConfig2.setOpen_action_2(cursorQuery.getInt(columnIndexOrThrow130));
                    clockConfig2.setAction_2_count(cursorQuery.getInt(columnIndexOrThrow131));
                    clockConfig2.setAction_2_x(cursorQuery.getInt(columnIndexOrThrow132));
                    clockConfig2.setAction_2_y(cursorQuery.getInt(columnIndexOrThrow133));
                    clockConfig2.setOpen_action_3(cursorQuery.getInt(columnIndexOrThrow134));
                    clockConfig2.setAction_3_count(cursorQuery.getInt(columnIndexOrThrow135));
                    clockConfig2.setAction_3_x(cursorQuery.getInt(columnIndexOrThrow136));
                    clockConfig2.setAction_3_y(cursorQuery.getInt(columnIndexOrThrow137));
                    clockConfig2.setAction_interval(cursorQuery.getInt(columnIndexOrThrow138));
                    clockConfig2.setShow_overall_animation(cursorQuery.isNull(columnIndexOrThrow139) ? null : cursorQuery.getString(columnIndexOrThrow139));
                    clockConfig2.setOverall_animation_x(cursorQuery.getInt(columnIndexOrThrow140));
                    clockConfig2.setOverall_animation_y(cursorQuery.getInt(columnIndexOrThrow141));
                    clockConfig2.setOpen_click_1(cursorQuery.isNull(columnIndexOrThrow142) ? null : cursorQuery.getString(columnIndexOrThrow142));
                    clockConfig2.setClick_1_x(cursorQuery.getInt(columnIndexOrThrow143));
                    clockConfig2.setClick_1_y(cursorQuery.getInt(columnIndexOrThrow144));
                    clockConfig2.setClick_1_width(cursorQuery.isNull(columnIndexOrThrow145) ? null : cursorQuery.getString(columnIndexOrThrow145));
                    clockConfig2.setClick_1_height(cursorQuery.isNull(columnIndexOrThrow146) ? null : cursorQuery.getString(columnIndexOrThrow146));
                    clockConfig2.setOpen_click_2(cursorQuery.isNull(columnIndexOrThrow147) ? null : cursorQuery.getString(columnIndexOrThrow147));
                    clockConfig2.setClick_2_x(cursorQuery.getInt(columnIndexOrThrow148));
                    clockConfig2.setClick_2_y(cursorQuery.getInt(columnIndexOrThrow149));
                    clockConfig2.setClick_2_width(cursorQuery.isNull(columnIndexOrThrow150) ? null : cursorQuery.getString(columnIndexOrThrow150));
                    clockConfig2.setClick_2_height(cursorQuery.isNull(columnIndexOrThrow151) ? null : cursorQuery.getString(columnIndexOrThrow151));
                    clockConfig2.setOpen_click_3(cursorQuery.isNull(columnIndexOrThrow152) ? null : cursorQuery.getString(columnIndexOrThrow152));
                    clockConfig2.setClick_3_x(cursorQuery.getInt(columnIndexOrThrow153));
                    clockConfig2.setClick_3_y(cursorQuery.getInt(columnIndexOrThrow154));
                    clockConfig2.setClick_3_width(cursorQuery.isNull(columnIndexOrThrow155) ? null : cursorQuery.getString(columnIndexOrThrow155));
                    clockConfig2.setClick_3_height(cursorQuery.isNull(columnIndexOrThrow156) ? null : cursorQuery.getString(columnIndexOrThrow156));
                    clockConfig2.setOpen_click_4(cursorQuery.isNull(columnIndexOrThrow157) ? null : cursorQuery.getString(columnIndexOrThrow157));
                    clockConfig2.setClick_4_x(cursorQuery.getInt(columnIndexOrThrow158));
                    clockConfig2.setClick_4_y(cursorQuery.getInt(columnIndexOrThrow159));
                    clockConfig2.setClick_4_width(cursorQuery.isNull(columnIndexOrThrow160) ? null : cursorQuery.getString(columnIndexOrThrow160));
                    clockConfig2.setClick_4_height(cursorQuery.isNull(columnIndexOrThrow161) ? null : cursorQuery.getString(columnIndexOrThrow161));
                    clockConfig2.setShow_lunar(cursorQuery.getInt(columnIndexOrThrow162));
                    clockConfig2.setLunar_src(cursorQuery.isNull(columnIndexOrThrow163) ? null : cursorQuery.getString(columnIndexOrThrow163));
                    clockConfig2.setLunar_x(cursorQuery.getInt(columnIndexOrThrow164));
                    clockConfig2.setLunar_y(cursorQuery.getInt(columnIndexOrThrow165));
                    clockConfig2.setShow_heart(cursorQuery.getInt(columnIndexOrThrow166));
                    clockConfig2.setHeart_src(cursorQuery.isNull(columnIndexOrThrow167) ? null : cursorQuery.getString(columnIndexOrThrow167));
                    clockConfig2.setHeart_x(cursorQuery.getInt(columnIndexOrThrow168));
                    clockConfig2.setHeart_y(cursorQuery.getInt(columnIndexOrThrow169));
                    clockConfig2.setHeart_num_src(cursorQuery.isNull(columnIndexOrThrow170) ? null : cursorQuery.getString(columnIndexOrThrow170));
                    clockConfig2.setHeart_num_type(cursorQuery.isNull(columnIndexOrThrow171) ? null : cursorQuery.getString(columnIndexOrThrow171));
                    clockConfig2.setHeart_end_src(cursorQuery.isNull(columnIndexOrThrow172) ? null : cursorQuery.getString(columnIndexOrThrow172));
                    clockConfig2.setHeart_show_type(cursorQuery.getInt(columnIndexOrThrow173));
                    clockConfig2.setHeart_num_x(cursorQuery.getInt(columnIndexOrThrow174));
                    clockConfig2.setHeart_num_y(cursorQuery.getInt(columnIndexOrThrow175));
                    clockConfig2.setOpen_heart_arc_show(cursorQuery.getInt(columnIndexOrThrow176));
                    clockConfig2.setHeart_arc_type(cursorQuery.getInt(columnIndexOrThrow177));
                    clockConfig2.setHeart_arc_center_x(cursorQuery.getInt(columnIndexOrThrow178));
                    clockConfig2.setHeart_arc_center_y(cursorQuery.getInt(columnIndexOrThrow179));
                    clockConfig2.setShow_pressure(cursorQuery.isNull(columnIndexOrThrow180) ? null : cursorQuery.getString(columnIndexOrThrow180));
                    clockConfig2.setPressure_src(cursorQuery.isNull(columnIndexOrThrow181) ? null : cursorQuery.getString(columnIndexOrThrow181));
                    clockConfig2.setPressure_x(cursorQuery.getInt(columnIndexOrThrow182));
                    clockConfig2.setPressure_y(cursorQuery.getInt(columnIndexOrThrow183));
                    clockConfig2.setPressure_num_src(cursorQuery.isNull(columnIndexOrThrow184) ? null : cursorQuery.getString(columnIndexOrThrow184));
                    clockConfig2.setPressure_num_x(cursorQuery.getInt(columnIndexOrThrow185));
                    clockConfig2.setPressure_num_y(cursorQuery.getInt(columnIndexOrThrow186));
                    clockConfig2.setPressure_show_type(cursorQuery.isNull(columnIndexOrThrow187) ? null : cursorQuery.getString(columnIndexOrThrow187));
                    clockConfig2.setPressure_splt_src(cursorQuery.isNull(columnIndexOrThrow188) ? null : cursorQuery.getString(columnIndexOrThrow188));
                    clockConfig2.setShow_step(cursorQuery.getInt(columnIndexOrThrow189));
                    clockConfig2.setStep_src(cursorQuery.isNull(columnIndexOrThrow190) ? null : cursorQuery.getString(columnIndexOrThrow190));
                    clockConfig2.setStep_follow_num(cursorQuery.getInt(columnIndexOrThrow191));
                    clockConfig2.setStep_x(cursorQuery.getInt(columnIndexOrThrow192));
                    clockConfig2.setStep_y(cursorQuery.getInt(columnIndexOrThrow193));
                    clockConfig2.setStep_num_src(cursorQuery.isNull(columnIndexOrThrow194) ? null : cursorQuery.getString(columnIndexOrThrow194));
                    clockConfig2.setStep_num_type(cursorQuery.getInt(columnIndexOrThrow195));
                    clockConfig2.setStep_show_type(cursorQuery.getInt(columnIndexOrThrow196));
                    clockConfig2.setStep_num_x(cursorQuery.getInt(columnIndexOrThrow197));
                    clockConfig2.setStep_num_y(cursorQuery.getInt(columnIndexOrThrow198));
                    clockConfig2.setStep_end_src(cursorQuery.isNull(columnIndexOrThrow199) ? null : cursorQuery.getString(columnIndexOrThrow199));
                    clockConfig2.setShow_step_progress(cursorQuery.getInt(columnIndexOrThrow200));
                    clockConfig2.setStep_progress_x(cursorQuery.getInt(columnIndexOrThrow201));
                    clockConfig2.setStep_progress_y(cursorQuery.getInt(columnIndexOrThrow202));
                    clockConfig2.setStep_progress_src(cursorQuery.isNull(columnIndexOrThrow203) ? null : cursorQuery.getString(columnIndexOrThrow203));
                    clockConfig2.setOpen_step_arc_show(cursorQuery.getInt(columnIndexOrThrow204));
                    clockConfig2.setStep_arc_type(cursorQuery.getInt(columnIndexOrThrow205));
                    clockConfig2.setStep_arc_center_x(cursorQuery.getInt(columnIndexOrThrow206));
                    clockConfig2.setStep_arc_center_y(cursorQuery.getInt(columnIndexOrThrow207));
                    clockConfig2.setShow_kcal(cursorQuery.getInt(columnIndexOrThrow208));
                    clockConfig2.setKcal_src(cursorQuery.isNull(columnIndexOrThrow209) ? null : cursorQuery.getString(columnIndexOrThrow209));
                    clockConfig2.setKcal_x(cursorQuery.getInt(columnIndexOrThrow210));
                    clockConfig2.setKcal_y(cursorQuery.getInt(columnIndexOrThrow211));
                    clockConfig2.setKcal_num_src(cursorQuery.isNull(columnIndexOrThrow212) ? null : cursorQuery.getString(columnIndexOrThrow212));
                    clockConfig2.setKcal_num_type(cursorQuery.getInt(columnIndexOrThrow213));
                    clockConfig2.setKcal_show_type(cursorQuery.getInt(columnIndexOrThrow214));
                    clockConfig2.setKcal_num_x(cursorQuery.getInt(columnIndexOrThrow215));
                    clockConfig2.setKcal_num_y(cursorQuery.getInt(columnIndexOrThrow216));
                    clockConfig2.setKcal_end_src(cursorQuery.isNull(columnIndexOrThrow217) ? null : cursorQuery.getString(columnIndexOrThrow217));
                    clockConfig2.setShow_km(cursorQuery.isNull(columnIndexOrThrow218) ? null : cursorQuery.getString(columnIndexOrThrow218));
                    clockConfig2.setKm_src(cursorQuery.isNull(columnIndexOrThrow219) ? null : cursorQuery.getString(columnIndexOrThrow219));
                    clockConfig2.setKm_x(cursorQuery.getInt(columnIndexOrThrow220));
                    clockConfig2.setKm_y(cursorQuery.getInt(columnIndexOrThrow221));
                    clockConfig2.setKm_num_src(cursorQuery.isNull(columnIndexOrThrow222) ? null : cursorQuery.getString(columnIndexOrThrow222));
                    clockConfig2.setKm_comma_src(cursorQuery.isNull(columnIndexOrThrow223) ? null : cursorQuery.getString(columnIndexOrThrow223));
                    clockConfig2.setKm_num_type(cursorQuery.isNull(columnIndexOrThrow224) ? null : cursorQuery.getString(columnIndexOrThrow224));
                    clockConfig2.setKm_show_type(cursorQuery.getInt(columnIndexOrThrow225));
                    clockConfig2.setKm_num_x(cursorQuery.getInt(columnIndexOrThrow226));
                    clockConfig2.setKm_num_y(cursorQuery.getInt(columnIndexOrThrow227));
                    clockConfig2.setKm_end_src(cursorQuery.isNull(columnIndexOrThrow228) ? null : cursorQuery.getString(columnIndexOrThrow228));
                    clockConfig2.setShow_weather(cursorQuery.isNull(columnIndexOrThrow229) ? null : cursorQuery.getString(columnIndexOrThrow229));
                    clockConfig2.setShow_temperature(cursorQuery.isNull(columnIndexOrThrow230) ? null : cursorQuery.getString(columnIndexOrThrow230));
                    clockConfig2.setTemperature_show_type(cursorQuery.getInt(columnIndexOrThrow231));
                    clockConfig2.setTemperature_num_type(cursorQuery.getInt(columnIndexOrThrow232));
                    clockConfig2.setTemperature_x(cursorQuery.getInt(columnIndexOrThrow233));
                    clockConfig2.setTemperature_y(cursorQuery.getInt(columnIndexOrThrow234));
                    clockConfig2.setTemperature_x_2(cursorQuery.getInt(columnIndexOrThrow235));
                    clockConfig2.setTemperature_y_2(cursorQuery.getInt(columnIndexOrThrow236));
                    clockConfig2.setShow_now_tem(cursorQuery.isNull(columnIndexOrThrow237) ? null : cursorQuery.getString(columnIndexOrThrow237));
                    clockConfig2.setNow_tem_show_type(cursorQuery.isNull(columnIndexOrThrow238) ? null : cursorQuery.getString(columnIndexOrThrow238));
                    clockConfig2.setNow_tem_x(cursorQuery.getInt(columnIndexOrThrow239));
                    clockConfig2.setNow_tem_y(cursorQuery.getInt(columnIndexOrThrow240));
                    clockConfig2.setTemperature_num_src(cursorQuery.isNull(columnIndexOrThrow241) ? null : cursorQuery.getString(columnIndexOrThrow241));
                    clockConfig2.setTemperature_sub_src(cursorQuery.isNull(columnIndexOrThrow242) ? null : cursorQuery.getString(columnIndexOrThrow242));
                    clockConfig2.setTemperature_sign_src(cursorQuery.isNull(columnIndexOrThrow243) ? null : cursorQuery.getString(columnIndexOrThrow243));
                    clockConfig2.setTemperature_splt_src(cursorQuery.isNull(columnIndexOrThrow244) ? null : cursorQuery.getString(columnIndexOrThrow244));
                    clockConfig2.setShow_diagram(cursorQuery.isNull(columnIndexOrThrow245) ? null : cursorQuery.getString(columnIndexOrThrow245));
                    clockConfig2.setDiagram_x(cursorQuery.getInt(columnIndexOrThrow246));
                    clockConfig2.setDiagram_y(cursorQuery.getInt(columnIndexOrThrow247));
                    clockConfig2.setShowsignal(cursorQuery.getInt(columnIndexOrThrow248));
                    clockConfig2.setShow_signal(cursorQuery.getInt(columnIndexOrThrow249));
                    clockConfig2.setSignal_src(cursorQuery.isNull(columnIndexOrThrow250) ? null : cursorQuery.getString(columnIndexOrThrow250));
                    clockConfig2.setSignal_x(cursorQuery.getInt(columnIndexOrThrow251));
                    clockConfig2.setSignal_y(cursorQuery.getInt(columnIndexOrThrow252));
                    clockConfig2.setShow_user_name(cursorQuery.isNull(columnIndexOrThrow253) ? null : cursorQuery.getString(columnIndexOrThrow253));
                    clockConfig2.setName_show_type(cursorQuery.isNull(columnIndexOrThrow254) ? null : cursorQuery.getString(columnIndexOrThrow254));
                    clockConfig2.setName_x(cursorQuery.getInt(columnIndexOrThrow255));
                    clockConfig2.setName_y(cursorQuery.getInt(columnIndexOrThrow256));
                    clockConfig2.setShow_operator(cursorQuery.isNull(columnIndexOrThrow257) ? null : cursorQuery.getString(columnIndexOrThrow257));
                    clockConfig2.setOperator_show_type(cursorQuery.isNull(columnIndexOrThrow258) ? null : cursorQuery.getString(columnIndexOrThrow258));
                    clockConfig2.setOperator_x(cursorQuery.getInt(columnIndexOrThrow259));
                    clockConfig2.setOperator_y(cursorQuery.getInt(columnIndexOrThrow260));
                    clockConfig2.setShow_btn_call(cursorQuery.isNull(columnIndexOrThrow261) ? null : cursorQuery.getString(columnIndexOrThrow261));
                    clockConfig2.setBtn_call_src(cursorQuery.isNull(columnIndexOrThrow262) ? null : cursorQuery.getString(columnIndexOrThrow262));
                    clockConfig2.setBtn_call_x(cursorQuery.getInt(columnIndexOrThrow263));
                    clockConfig2.setBtn_call_y(cursorQuery.getInt(columnIndexOrThrow264));
                    clockConfig2.setShow_btn_sms(cursorQuery.isNull(columnIndexOrThrow265) ? null : cursorQuery.getString(columnIndexOrThrow265));
                    clockConfig2.setBtn_sms_src(cursorQuery.isNull(columnIndexOrThrow266) ? null : cursorQuery.getString(columnIndexOrThrow266));
                    clockConfig2.setBtn_sms_x(cursorQuery.getInt(columnIndexOrThrow267));
                    clockConfig2.setBtn_sms_y(cursorQuery.getInt(columnIndexOrThrow268));
                    clockConfig2.setShow_btn_heart(cursorQuery.isNull(columnIndexOrThrow269) ? null : cursorQuery.getString(columnIndexOrThrow269));
                    clockConfig2.setIs_our_heart(cursorQuery.getInt(columnIndexOrThrow270));
                    clockConfig2.setBtn_heart_src(cursorQuery.isNull(columnIndexOrThrow271) ? null : cursorQuery.getString(columnIndexOrThrow271));
                    clockConfig2.setBtn_heart_x(cursorQuery.getInt(columnIndexOrThrow272));
                    clockConfig2.setBtn_heart_y(cursorQuery.getInt(columnIndexOrThrow273));
                    clockConfig2.setShow_btn_step(cursorQuery.isNull(columnIndexOrThrow274) ? null : cursorQuery.getString(columnIndexOrThrow274));
                    clockConfig2.setBtn_step_src(cursorQuery.isNull(columnIndexOrThrow275) ? null : cursorQuery.getString(columnIndexOrThrow275));
                    clockConfig2.setBtn_step_x(cursorQuery.getInt(columnIndexOrThrow276));
                    clockConfig2.setBtn_step_y(cursorQuery.getInt(columnIndexOrThrow277));
                    clockConfig2.setShow_btn_wechat(cursorQuery.isNull(columnIndexOrThrow278) ? null : cursorQuery.getString(columnIndexOrThrow278));
                    clockConfig2.setBtn_wechat_src(cursorQuery.isNull(columnIndexOrThrow279) ? null : cursorQuery.getString(columnIndexOrThrow279));
                    clockConfig2.setBtn_wechat_x(cursorQuery.getInt(columnIndexOrThrow280));
                    clockConfig2.setBtn_wechat_y(cursorQuery.getInt(columnIndexOrThrow281));
                    clockConfig2.setShow_btn_alipay(cursorQuery.getInt(columnIndexOrThrow282));
                    clockConfig2.setBtn_alipay_src(cursorQuery.isNull(columnIndexOrThrow283) ? null : cursorQuery.getString(columnIndexOrThrow283));
                    clockConfig2.setBtn_alipay_x(cursorQuery.getInt(columnIndexOrThrow284));
                    clockConfig2.setBtn_alipay_y(cursorQuery.getInt(columnIndexOrThrow285));
                    clockConfig2.setShow_btn_stopwatch(cursorQuery.getInt(columnIndexOrThrow286));
                    clockConfig2.setBtn_stopwatch_src(cursorQuery.isNull(columnIndexOrThrow287) ? null : cursorQuery.getString(columnIndexOrThrow287));
                    clockConfig2.setBtn_stopwatch_x(cursorQuery.getInt(columnIndexOrThrow288));
                    clockConfig2.setBtn_stopwatch_y(cursorQuery.getInt(columnIndexOrThrow289));
                    clockConfig2.setShow_btn_weather(cursorQuery.getInt(columnIndexOrThrow290));
                    clockConfig2.setShow_btn_calo(cursorQuery.getInt(columnIndexOrThrow291));
                    clockConfig2.setBtn_calo_src(cursorQuery.isNull(columnIndexOrThrow292) ? null : cursorQuery.getString(columnIndexOrThrow292));
                    clockConfig2.setBtn_calo_x(cursorQuery.getInt(columnIndexOrThrow293));
                    clockConfig2.setBtn_calo_y(cursorQuery.getInt(columnIndexOrThrow294));
                    clockConfig2.setTemprature_src(cursorQuery.isNull(columnIndexOrThrow295) ? null : cursorQuery.getString(columnIndexOrThrow295));
                    clockConfig2.setShow_btn_camera(cursorQuery.isNull(columnIndexOrThrow296) ? null : cursorQuery.getString(columnIndexOrThrow296));
                    clockConfig2.setBtn_camera_src(cursorQuery.isNull(columnIndexOrThrow297) ? null : cursorQuery.getString(columnIndexOrThrow297));
                    clockConfig2.setBtn_camera_x(cursorQuery.getInt(columnIndexOrThrow298));
                    clockConfig2.setBtn_camera_y(cursorQuery.getInt(columnIndexOrThrow299));
                    clockConfig2.setShow_btn_sos(cursorQuery.isNull(columnIndexOrThrow300) ? null : cursorQuery.getString(columnIndexOrThrow300));
                    clockConfig2.setBtn_sos_src(cursorQuery.isNull(columnIndexOrThrow301) ? null : cursorQuery.getString(columnIndexOrThrow301));
                    clockConfig2.setBtn_sos_x(cursorQuery.getInt(columnIndexOrThrow302));
                    clockConfig2.setBtn_sos_y(cursorQuery.getInt(columnIndexOrThrow303));
                    clockConfig2.setShow_special_1(cursorQuery.isNull(columnIndexOrThrow304) ? null : cursorQuery.getString(columnIndexOrThrow304));
                    clockConfig2.setSpecial_1_src(cursorQuery.isNull(columnIndexOrThrow305) ? null : cursorQuery.getString(columnIndexOrThrow305));
                    clockConfig2.setSpecial_1_position(cursorQuery.isNull(columnIndexOrThrow306) ? null : cursorQuery.getString(columnIndexOrThrow306));
                    clockConfig2.setSpecial_x(cursorQuery.getInt(columnIndexOrThrow307));
                    clockConfig2.setSpecial_y(cursorQuery.getInt(columnIndexOrThrow308));
                    clockConfig2.setSupport_multiple_change(cursorQuery.getInt(columnIndexOrThrow309));
                    clockConfig2.setShow_lunar_year(cursorQuery.getInt(columnIndexOrThrow310));
                    clockConfig2.setLunar_day_splt_src(cursorQuery.isNull(columnIndexOrThrow311) ? null : cursorQuery.getString(columnIndexOrThrow311));
                    clockConfig2.setLunar_month_splt_src(cursorQuery.isNull(columnIndexOrThrow312) ? null : cursorQuery.getString(columnIndexOrThrow312));
                    clockConfig2.setLunar_year_splt_src(cursorQuery.isNull(columnIndexOrThrow313) ? null : cursorQuery.getString(columnIndexOrThrow313));
                    clockConfig2.setAm_src(cursorQuery.isNull(columnIndexOrThrow314) ? null : cursorQuery.getString(columnIndexOrThrow314));
                    clockConfig2.setPm_src(cursorQuery.isNull(columnIndexOrThrow315) ? null : cursorQuery.getString(columnIndexOrThrow315));
                    clockConfig2.setShow_btn_alarm(cursorQuery.getInt(columnIndexOrThrow316));
                    clockConfig2.setBtn_alarm_src(cursorQuery.isNull(columnIndexOrThrow317) ? null : cursorQuery.getString(columnIndexOrThrow317));
                    clockConfig2.setBtn_alarm_x(cursorQuery.getInt(columnIndexOrThrow318));
                    clockConfig2.setBtn_alarm_y(cursorQuery.getInt(columnIndexOrThrow319));
                    clockConfig2.setBg_btn_change(cursorQuery.getInt(columnIndexOrThrow320));
                    clockConfig2.setBg_btn_index(cursorQuery.getInt(columnIndexOrThrow321));
                    clockConfig2.setShow_btn_music(cursorQuery.getInt(columnIndexOrThrow322));
                    clockConfig2.setBtn_music_src(cursorQuery.isNull(columnIndexOrThrow323) ? null : cursorQuery.getString(columnIndexOrThrow323));
                    clockConfig2.setBtn_music_x(cursorQuery.getInt(columnIndexOrThrow324));
                    clockConfig2.setBtn_music_y(cursorQuery.getInt(columnIndexOrThrow325));
                    clockConfig2.setSupport_dynamic_change(cursorQuery.getInt(columnIndexOrThrow326));
                    clockConfig2.setLevel(cursorQuery.getInt(columnIndexOrThrow327));
                    clockConfig2.setParent_id(cursorQuery.isNull(columnIndexOrThrow328) ? null : cursorQuery.getString(columnIndexOrThrow328));
                    clockConfig2.setNext_id(cursorQuery.getInt(columnIndexOrThrow329));
                    clockConfig2.setChange_starttime(cursorQuery.getInt(columnIndexOrThrow330));
                    clockConfig2.setChange_endtime(cursorQuery.getInt(columnIndexOrThrow331));
                    clockConfig2.setBtn_weather_src(cursorQuery.isNull(columnIndexOrThrow332) ? null : cursorQuery.getString(columnIndexOrThrow332));
                    clockConfig2.setBtn_weather_x(cursorQuery.getInt(columnIndexOrThrow333));
                    clockConfig2.setBtn_weather_y(cursorQuery.getInt(columnIndexOrThrow334));
                    clockConfig2.setShow_btn_calories(cursorQuery.getInt(columnIndexOrThrow335));
                    clockConfig2.setBtn_calories_src(cursorQuery.isNull(columnIndexOrThrow336) ? null : cursorQuery.getString(columnIndexOrThrow336));
                    clockConfig2.setBtn_calories_x(cursorQuery.getInt(columnIndexOrThrow337));
                    clockConfig2.setBtn_calories_y(cursorQuery.getInt(columnIndexOrThrow338));
                    clockConfig2.setSupport_compass(cursorQuery.getInt(columnIndexOrThrow339));
                    clockConfig2.setCompass_src(cursorQuery.isNull(columnIndexOrThrow340) ? null : cursorQuery.getString(columnIndexOrThrow340));
                    clockConfig2.setCompass_2_src(cursorQuery.isNull(columnIndexOrThrow341) ? null : cursorQuery.getString(columnIndexOrThrow341));
                    clockConfig2.setCompass_x(cursorQuery.getInt(columnIndexOrThrow342));
                    clockConfig2.setCompass_y(cursorQuery.getInt(columnIndexOrThrow343));
                    clockConfig2.setShow_btn_setting(cursorQuery.getInt(columnIndexOrThrow344));
                    clockConfig2.setBtn_setting_src(cursorQuery.isNull(columnIndexOrThrow345) ? null : cursorQuery.getString(columnIndexOrThrow345));
                    clockConfig2.setBtn_setting_x(cursorQuery.getInt(columnIndexOrThrow346));
                    clockConfig2.setBtn_setting_y(cursorQuery.getInt(columnIndexOrThrow347));
                    clockConfig2.setSupport_click_change(cursorQuery.getInt(columnIndexOrThrow348));
                    clockConfig2.setClick_id_is_current(cursorQuery.getInt(columnIndexOrThrow349));
                    clockConfig2.setCompass_show_detail_degree(cursorQuery.getInt(columnIndexOrThrow350));
                    clockConfig2.setCompass_direction_src(cursorQuery.isNull(columnIndexOrThrow351) ? null : cursorQuery.getString(columnIndexOrThrow351));
                    clockConfig2.setCompass_direction_x(cursorQuery.getInt(columnIndexOrThrow352));
                    clockConfig2.setCompass_direction_y(cursorQuery.getInt(columnIndexOrThrow353));
                    clockConfig2.setCompass_direction_2_src(cursorQuery.isNull(columnIndexOrThrow354) ? null : cursorQuery.getString(columnIndexOrThrow354));
                    clockConfig2.setCompass_direction_2_x(cursorQuery.getInt(columnIndexOrThrow355));
                    clockConfig2.setCompass_direction_2_y(cursorQuery.getInt(columnIndexOrThrow356));
                    clockConfig2.setCompass_direction_3_src(cursorQuery.isNull(columnIndexOrThrow357) ? null : cursorQuery.getString(columnIndexOrThrow357));
                    clockConfig2.setCompass_direction_3_x(cursorQuery.getInt(columnIndexOrThrow358));
                    clockConfig2.setCompass_direction_3_y(cursorQuery.getInt(columnIndexOrThrow359));
                    clockConfig2.setCompass_direction_degree_src(cursorQuery.isNull(columnIndexOrThrow360) ? null : cursorQuery.getString(columnIndexOrThrow360));
                    clockConfig2.setCompass_direction_degree_x(cursorQuery.getInt(columnIndexOrThrow361));
                    clockConfig2.setCompass_direction_degree_y(cursorQuery.getInt(columnIndexOrThrow362));
                    clockConfig2.setCompass_direction_degree_unit(cursorQuery.isNull(columnIndexOrThrow363) ? null : cursorQuery.getString(columnIndexOrThrow363));
                    clockConfig2.setCompass_degree_1_src(cursorQuery.isNull(columnIndexOrThrow364) ? null : cursorQuery.getString(columnIndexOrThrow364));
                    clockConfig2.setCompass_degree_1_x(cursorQuery.getInt(columnIndexOrThrow365));
                    clockConfig2.setCompass_degree_1_y(cursorQuery.getInt(columnIndexOrThrow366));
                    clockConfig2.setCompass_degree_2_src(cursorQuery.isNull(columnIndexOrThrow367) ? null : cursorQuery.getString(columnIndexOrThrow367));
                    clockConfig2.setCompass_degree_2_x(cursorQuery.getInt(columnIndexOrThrow368));
                    clockConfig2.setCompass_degree_2_y(cursorQuery.getInt(columnIndexOrThrow369));
                    clockConfig2.setCompass_degree_3_src(cursorQuery.isNull(columnIndexOrThrow370) ? null : cursorQuery.getString(columnIndexOrThrow370));
                    clockConfig2.setCompass_degree_3_x(cursorQuery.getInt(columnIndexOrThrow371));
                    clockConfig2.setCompass_degree_3_y(cursorQuery.getInt(columnIndexOrThrow372));
                    clockConfig2.setShow_connect_animation(cursorQuery.getInt(columnIndexOrThrow373));
                    clockConfig2.setConnect_animation_x(cursorQuery.getInt(columnIndexOrThrow374));
                    clockConfig2.setConnect_animation_y(cursorQuery.getInt(columnIndexOrThrow375));
                    clockConfig2.setConnect_animation_count(cursorQuery.getInt(columnIndexOrThrow376));
                    clockConfig2.setShow_state(cursorQuery.getInt(columnIndexOrThrow377));
                    clockConfig2.setState_x(cursorQuery.getInt(columnIndexOrThrow378));
                    clockConfig2.setState_y(cursorQuery.getInt(columnIndexOrThrow379));
                    clockConfig2.setAction_1_cut_position(cursorQuery.getInt(columnIndexOrThrow380));
                    clockConfig2.setAction_2_cut_position(cursorQuery.getInt(columnIndexOrThrow381));
                    clockConfig2.setAction_3_cut_position(cursorQuery.getInt(columnIndexOrThrow382));
                    clockConfig2.setShow_btn_googleplay(cursorQuery.getInt(columnIndexOrThrow383));
                    clockConfig2.setBtn_googleplay_src(cursorQuery.isNull(columnIndexOrThrow384) ? null : cursorQuery.getString(columnIndexOrThrow384));
                    clockConfig2.setBtn_googleplay_x(cursorQuery.getInt(columnIndexOrThrow385));
                    clockConfig2.setBtn_googleplay_y(cursorQuery.getInt(columnIndexOrThrow386));
                    clockConfig2.setShow_month_2(cursorQuery.getInt(columnIndexOrThrow387));
                    clockConfig2.setMonth_type_2(cursorQuery.getInt(columnIndexOrThrow388));
                    clockConfig2.setMonth_src_2(cursorQuery.isNull(columnIndexOrThrow389) ? null : cursorQuery.getString(columnIndexOrThrow389));
                    clockConfig2.setMonth_x_2(cursorQuery.getInt(columnIndexOrThrow390));
                    clockConfig2.setMonth_y_2(cursorQuery.getInt(columnIndexOrThrow391));
                    clockConfig2.setTime_special_new(cursorQuery.getInt(columnIndexOrThrow392));
                    clockConfig2.setTime_special_hour_ten_src(cursorQuery.isNull(columnIndexOrThrow393) ? null : cursorQuery.getString(columnIndexOrThrow393));
                    clockConfig2.setTime_special_hour_src(cursorQuery.isNull(columnIndexOrThrow394) ? null : cursorQuery.getString(columnIndexOrThrow394));
                    clockConfig2.setTime_special_min_ten_src(cursorQuery.isNull(columnIndexOrThrow395) ? null : cursorQuery.getString(columnIndexOrThrow395));
                    clockConfig2.setTime_special_min_src(cursorQuery.isNull(columnIndexOrThrow396) ? null : cursorQuery.getString(columnIndexOrThrow396));
                    clockConfig2.setShow_kcal_progress(cursorQuery.getInt(columnIndexOrThrow397));
                    clockConfig2.setKcal_progress_x(cursorQuery.getInt(columnIndexOrThrow398));
                    clockConfig2.setKcal_progress_y(cursorQuery.getInt(columnIndexOrThrow399));
                    clockConfig2.setKcal_progress_src(cursorQuery.isNull(columnIndexOrThrow400) ? null : cursorQuery.getString(columnIndexOrThrow400));
                    clockConfig2.setOpen_kcal_arc_show(cursorQuery.getInt(columnIndexOrThrow401));
                    clockConfig2.setKcal_arc_type(cursorQuery.getInt(columnIndexOrThrow402));
                    clockConfig2.setKcal_arc_center_x(cursorQuery.getInt(columnIndexOrThrow403));
                    clockConfig2.setKcal_arc_center_y(cursorQuery.getInt(columnIndexOrThrow404));
                    clockConfig2.setOpen_power_arc_show(cursorQuery.getInt(columnIndexOrThrow405));
                    clockConfig2.setPower_arc_type(cursorQuery.getInt(columnIndexOrThrow406));
                    clockConfig2.setPower_arc_center_x(cursorQuery.getInt(columnIndexOrThrow407));
                    clockConfig2.setPower_arc_center_y(cursorQuery.getInt(columnIndexOrThrow408));
                    clockConfig2.setShow_btn_timer(cursorQuery.getInt(columnIndexOrThrow409));
                    clockConfig2.setBtn_timer_src(cursorQuery.isNull(columnIndexOrThrow410) ? null : cursorQuery.getString(columnIndexOrThrow410));
                    clockConfig2.setBtn_timer_x(cursorQuery.getInt(columnIndexOrThrow411));
                    clockConfig2.setBtn_timer_y(cursorQuery.getInt(columnIndexOrThrow412));
                    clockConfig2.setShow_btn_sleep(cursorQuery.getInt(columnIndexOrThrow413));
                    clockConfig2.setBtn_sleep_src(cursorQuery.isNull(columnIndexOrThrow414) ? null : cursorQuery.getString(columnIndexOrThrow414));
                    clockConfig2.setBtn_sleep_x(cursorQuery.getInt(columnIndexOrThrow415));
                    clockConfig2.setBtn_sleep_y(cursorQuery.getInt(columnIndexOrThrow416));
                    clockConfig2.setShow_btn_bloodpressure(cursorQuery.getInt(columnIndexOrThrow417));
                    clockConfig2.setBtn_bloodpressure_src(cursorQuery.isNull(columnIndexOrThrow418) ? null : cursorQuery.getString(columnIndexOrThrow418));
                    clockConfig2.setBtn_bloodpressure_x(cursorQuery.getInt(columnIndexOrThrow419));
                    clockConfig2.setBtn_bloodpressure_y(cursorQuery.getInt(columnIndexOrThrow420));
                    clockConfig2.setShow_btn_sport_record(cursorQuery.getInt(columnIndexOrThrow421));
                    clockConfig2.setBtn_sport_record_src(cursorQuery.isNull(columnIndexOrThrow422) ? null : cursorQuery.getString(columnIndexOrThrow422));
                    clockConfig2.setBtn_sport_record_x(cursorQuery.getInt(columnIndexOrThrow423));
                    clockConfig2.setBtn_sport_record_y(cursorQuery.getInt(columnIndexOrThrow424));
                    clockConfig2.setLottie_hierarchy(cursorQuery.getInt(columnIndexOrThrow425));
                    clockConfig2.setShow_heart_progress(cursorQuery.getInt(columnIndexOrThrow426));
                    clockConfig2.setHeart_progress_x(cursorQuery.getInt(columnIndexOrThrow427));
                    clockConfig2.setHeart_progress_y(cursorQuery.getInt(columnIndexOrThrow428));
                    clockConfig2.setHeart_progress_src(cursorQuery.isNull(columnIndexOrThrow429) ? null : cursorQuery.getString(columnIndexOrThrow429));
                    clockConfig2.setShow_btn_calculator(cursorQuery.getInt(columnIndexOrThrow430));
                    clockConfig2.setBtn_calculator_src(cursorQuery.isNull(columnIndexOrThrow431) ? null : cursorQuery.getString(columnIndexOrThrow431));
                    clockConfig2.setBtn_calculator_x(cursorQuery.getInt(columnIndexOrThrow432));
                    clockConfig2.setBtn_calculator_y(cursorQuery.getInt(columnIndexOrThrow433));
                    clockConfig2.setTime_special_drag_3d(cursorQuery.getInt(columnIndexOrThrow434));
                    clockConfig2.setPrev_HourTen_Position(cursorQuery.isNull(columnIndexOrThrow435) ? null : cursorQuery.getString(columnIndexOrThrow435));
                    clockConfig2.setPrev_HourGe_Position(cursorQuery.isNull(columnIndexOrThrow436) ? null : cursorQuery.getString(columnIndexOrThrow436));
                    clockConfig2.setCurrent_HourTen_Position(cursorQuery.isNull(columnIndexOrThrow437) ? null : cursorQuery.getString(columnIndexOrThrow437));
                    clockConfig2.setCurrent_HourGe_Position(cursorQuery.isNull(columnIndexOrThrow438) ? null : cursorQuery.getString(columnIndexOrThrow438));
                    clockConfig2.setNext_HourTen_Position(cursorQuery.isNull(columnIndexOrThrow439) ? null : cursorQuery.getString(columnIndexOrThrow439));
                    clockConfig2.setNext_HourGe_Position(cursorQuery.isNull(columnIndexOrThrow440) ? null : cursorQuery.getString(columnIndexOrThrow440));
                    clockConfig2.setPrev_MinTen_Position(cursorQuery.isNull(columnIndexOrThrow441) ? null : cursorQuery.getString(columnIndexOrThrow441));
                    clockConfig2.setPrev_MinGe_Position(cursorQuery.isNull(columnIndexOrThrow442) ? null : cursorQuery.getString(columnIndexOrThrow442));
                    clockConfig2.setCurrent_MinTen_Position(cursorQuery.isNull(columnIndexOrThrow443) ? null : cursorQuery.getString(columnIndexOrThrow443));
                    clockConfig2.setCurrent_MinGe_Position(cursorQuery.isNull(columnIndexOrThrow444) ? null : cursorQuery.getString(columnIndexOrThrow444));
                    clockConfig2.setNext_MinTen_Position(cursorQuery.isNull(columnIndexOrThrow445) ? null : cursorQuery.getString(columnIndexOrThrow445));
                    clockConfig2.setNext_MinGe_Position(cursorQuery.isNull(columnIndexOrThrow446) ? null : cursorQuery.getString(columnIndexOrThrow446));
                    clockConfig2.setNeed_split_day(cursorQuery.getInt(columnIndexOrThrow447));
                    clockConfig2.setSplit_day_x(cursorQuery.getInt(columnIndexOrThrow448));
                    clockConfig2.setSplit_day_y(cursorQuery.getInt(columnIndexOrThrow449));
                    clockConfig2.setOpen_now_tem_arc_show(cursorQuery.getInt(columnIndexOrThrow450));
                    clockConfig2.setNow_tem_arc_type(cursorQuery.getInt(columnIndexOrThrow451));
                    clockConfig2.setNow_tem_arc_center_x(cursorQuery.getInt(columnIndexOrThrow452));
                    clockConfig2.setNow_tem_arc_center_y(cursorQuery.getInt(columnIndexOrThrow453));
                    clockConfig2.setShow_km_progress(cursorQuery.getInt(columnIndexOrThrow454));
                    clockConfig2.setKm_progress_x(cursorQuery.getInt(columnIndexOrThrow455));
                    clockConfig2.setKm_progress_y(cursorQuery.getInt(columnIndexOrThrow456));
                    clockConfig2.setKm_progress_src(cursorQuery.isNull(columnIndexOrThrow457) ? null : cursorQuery.getString(columnIndexOrThrow457));
                    clockConfig2.setOpen_km_arc_show(cursorQuery.getInt(columnIndexOrThrow458));
                    clockConfig2.setKm_arc_type(cursorQuery.getInt(columnIndexOrThrow459));
                    clockConfig2.setKm_arc_center_x(cursorQuery.getInt(columnIndexOrThrow460));
                    clockConfig2.setKm_arc_center_y(cursorQuery.getInt(columnIndexOrThrow461));
                    clockConfig2.setTime_rotate(cursorQuery.getInt(columnIndexOrThrow462));
                    clockConfig2.setTime_rotate_degree(cursorQuery.getInt(columnIndexOrThrow463));
                    clockConfig2.setHeart_num_rotate(cursorQuery.getInt(columnIndexOrThrow464));
                    clockConfig2.setHeart_num_rotate_degree(cursorQuery.getInt(columnIndexOrThrow465));
                    clockConfig2.setShow_oxygen(cursorQuery.getInt(columnIndexOrThrow466));
                    clockConfig2.setOxygen_src(cursorQuery.isNull(columnIndexOrThrow467) ? null : cursorQuery.getString(columnIndexOrThrow467));
                    clockConfig2.setOxygen_x(cursorQuery.getInt(columnIndexOrThrow468));
                    clockConfig2.setOxygen_y(cursorQuery.getInt(columnIndexOrThrow469));
                    clockConfig2.setOxygen_num_src(cursorQuery.isNull(columnIndexOrThrow470) ? null : cursorQuery.getString(columnIndexOrThrow470));
                    clockConfig2.setOxygen_sign_src(cursorQuery.isNull(columnIndexOrThrow471) ? null : cursorQuery.getString(columnIndexOrThrow471));
                    clockConfig2.setOxygen_show_type(cursorQuery.getInt(columnIndexOrThrow472));
                    clockConfig2.setOxygen_num_x(cursorQuery.getInt(columnIndexOrThrow473));
                    clockConfig2.setOxygen_num_y(cursorQuery.getInt(columnIndexOrThrow474));
                    clockConfig2.setTime_change_counter(cursorQuery.getInt(columnIndexOrThrow475));
                    clockConfig2.setTime_hour_src_2(cursorQuery.isNull(columnIndexOrThrow476) ? null : cursorQuery.getString(columnIndexOrThrow476));
                    clockConfig2.setTime_min_src_2(cursorQuery.isNull(columnIndexOrThrow477) ? null : cursorQuery.getString(columnIndexOrThrow477));
                    clockConfig2.setTime_sec_src_2(cursorQuery.isNull(columnIndexOrThrow478) ? null : cursorQuery.getString(columnIndexOrThrow478));
                    clockConfig2.setTime_splt_src_2(cursorQuery.isNull(columnIndexOrThrow479) ? null : cursorQuery.getString(columnIndexOrThrow479));
                    clockConfig2.setTime_splt_2_src_2(cursorQuery.isNull(columnIndexOrThrow480) ? null : cursorQuery.getString(columnIndexOrThrow480));
                    clockConfig2.setTime_hour_src_3(cursorQuery.isNull(columnIndexOrThrow481) ? null : cursorQuery.getString(columnIndexOrThrow481));
                    clockConfig2.setTime_min_src_3(cursorQuery.isNull(columnIndexOrThrow482) ? null : cursorQuery.getString(columnIndexOrThrow482));
                    clockConfig2.setTime_sec_src_3(cursorQuery.isNull(columnIndexOrThrow483) ? null : cursorQuery.getString(columnIndexOrThrow483));
                    clockConfig2.setTime_splt_src_3(cursorQuery.isNull(columnIndexOrThrow484) ? null : cursorQuery.getString(columnIndexOrThrow484));
                    clockConfig2.setTime_splt_2_src_3(cursorQuery.isNull(columnIndexOrThrow485) ? null : cursorQuery.getString(columnIndexOrThrow485));
                    clockConfig2.setTime_hour_src_4(cursorQuery.isNull(columnIndexOrThrow486) ? null : cursorQuery.getString(columnIndexOrThrow486));
                    clockConfig2.setTime_min_src_4(cursorQuery.isNull(columnIndexOrThrow487) ? null : cursorQuery.getString(columnIndexOrThrow487));
                    clockConfig2.setTime_sec_src_4(cursorQuery.isNull(columnIndexOrThrow488) ? null : cursorQuery.getString(columnIndexOrThrow488));
                    clockConfig2.setTime_splt_src_4(cursorQuery.isNull(columnIndexOrThrow489) ? null : cursorQuery.getString(columnIndexOrThrow489));
                    clockConfig2.setTime_splt_2_src_4(cursorQuery.isNull(columnIndexOrThrow490) ? null : cursorQuery.getString(columnIndexOrThrow490));
                    clockConfig2.setDate_rotate(cursorQuery.getInt(columnIndexOrThrow491));
                    clockConfig2.setDate_rotate_degree(cursorQuery.getInt(columnIndexOrThrow492));
                    clockConfig2.setNeed_split_hour(cursorQuery.getInt(columnIndexOrThrow493));
                    clockConfig2.setSplit_hour_src(cursorQuery.isNull(columnIndexOrThrow494) ? null : cursorQuery.getString(columnIndexOrThrow494));
                    clockConfig2.setSplit_hour_x(cursorQuery.getInt(columnIndexOrThrow495));
                    clockConfig2.setSplit_hour_y(cursorQuery.getInt(columnIndexOrThrow496));
                    clockConfig2.setNeed_split_min(cursorQuery.getInt(columnIndexOrThrow497));
                    clockConfig2.setSplit_min_src(cursorQuery.isNull(columnIndexOrThrow498) ? null : cursorQuery.getString(columnIndexOrThrow498));
                    clockConfig2.setSplit_min_x(cursorQuery.getInt(columnIndexOrThrow499));
                    clockConfig2.setSplit_min_y(cursorQuery.getInt(columnIndexOrThrow500));
                    clockConfig2.setSupport_scale(cursorQuery.getInt(columnIndexOrThrow501));
                    clockConfig2.setShow_compass_num(cursorQuery.getInt(columnIndexOrThrow502));
                    clockConfig2.setCompass_num_src(cursorQuery.isNull(columnIndexOrThrow503) ? null : cursorQuery.getString(columnIndexOrThrow503));
                    clockConfig2.setCompass_show_type(cursorQuery.getInt(columnIndexOrThrow504));
                    clockConfig2.setCompass_num_x(cursorQuery.getInt(columnIndexOrThrow505));
                    clockConfig2.setCompass_num_y(cursorQuery.getInt(columnIndexOrThrow506));
                    clockConfig2.setCompass_num_src_prefix(cursorQuery.isNull(columnIndexOrThrow507) ? null : cursorQuery.getString(columnIndexOrThrow507));
                    clockConfig2.setCompass_num_src_sign(cursorQuery.isNull(columnIndexOrThrow508) ? null : cursorQuery.getString(columnIndexOrThrow508));
                    clockConfig2.setShow_btn_oxygen(cursorQuery.getInt(columnIndexOrThrow509));
                    clockConfig2.setBtn_oxygen_src(cursorQuery.isNull(columnIndexOrThrow510) ? null : cursorQuery.getString(columnIndexOrThrow510));
                    clockConfig2.setBtn_oxygen_x(cursorQuery.getInt(columnIndexOrThrow511));
                    clockConfig2.setBtn_oxygen_y(cursorQuery.getInt(columnIndexOrThrow512));
                    clockConfig2.setShow_btn_calendar(cursorQuery.getInt(columnIndexOrThrow513));
                    clockConfig2.setBtn_calendar_src(cursorQuery.isNull(columnIndexOrThrow514) ? null : cursorQuery.getString(columnIndexOrThrow514));
                    clockConfig2.setBtn_calendar_x(cursorQuery.getInt(columnIndexOrThrow515));
                    clockConfig2.setBtn_calendar_y(cursorQuery.getInt(columnIndexOrThrow516));
                    clockConfig2.setShow_btn_compass(cursorQuery.getInt(columnIndexOrThrow517));
                    clockConfig2.setBtn_compass_src(cursorQuery.isNull(columnIndexOrThrow518) ? null : cursorQuery.getString(columnIndexOrThrow518));
                    clockConfig2.setBtn_compass_x(cursorQuery.getInt(columnIndexOrThrow519));
                    clockConfig2.setBtn_compass_y(cursorQuery.getInt(columnIndexOrThrow520));
                    clockConfig2.setPointer_disable_scale(cursorQuery.getInt(columnIndexOrThrow521));
                    clockConfig2.setShow_chinse_time(cursorQuery.getInt(columnIndexOrThrow522));
                    clockConfig2.setChinse_time_src(cursorQuery.isNull(columnIndexOrThrow523) ? null : cursorQuery.getString(columnIndexOrThrow523));
                    clockConfig2.setChinse_time_x(cursorQuery.getInt(columnIndexOrThrow524));
                    clockConfig2.setChinse_time_y(cursorQuery.getInt(columnIndexOrThrow525));
                    clockConfig2.setShow_btn_photo(cursorQuery.getInt(columnIndexOrThrow526));
                    clockConfig2.setBtn_photo_src(cursorQuery.isNull(columnIndexOrThrow527) ? null : cursorQuery.getString(columnIndexOrThrow527));
                    clockConfig2.setBtn_photo_x(cursorQuery.getInt(columnIndexOrThrow528));
                    clockConfig2.setBtn_photo_y(cursorQuery.getInt(columnIndexOrThrow529));
                    clockConfig2.setShow_btn_contact(cursorQuery.getInt(columnIndexOrThrow530));
                    clockConfig2.setBtn_contact_src(cursorQuery.isNull(columnIndexOrThrow531) ? null : cursorQuery.getString(columnIndexOrThrow531));
                    clockConfig2.setBtn_contact_x(cursorQuery.getInt(columnIndexOrThrow532));
                    clockConfig2.setBtn_contact_y(cursorQuery.getInt(columnIndexOrThrow533));
                    clockConfig2.setKcal_num_rotate(cursorQuery.getInt(columnIndexOrThrow534));
                    clockConfig2.setKcal_num_rotate_degree(cursorQuery.getInt(columnIndexOrThrow535));
                    clockConfig2.setShow_power_progress(cursorQuery.getInt(columnIndexOrThrow536));
                    clockConfig2.setPower_progress_src(cursorQuery.isNull(columnIndexOrThrow537) ? null : cursorQuery.getString(columnIndexOrThrow537));
                    clockConfig2.setPower_progress_x(cursorQuery.getInt(columnIndexOrThrow538));
                    clockConfig2.setPower_progress_y(cursorQuery.getInt(columnIndexOrThrow539));
                    clockConfig2.setPower_src(cursorQuery.isNull(columnIndexOrThrow540) ? null : cursorQuery.getString(columnIndexOrThrow540));
                    clockConfig2.setPower_src_x(cursorQuery.getInt(columnIndexOrThrow541));
                    clockConfig2.setPower_src_y(cursorQuery.getInt(columnIndexOrThrow542));
                    clockConfig2.setVideo_type(cursorQuery.getInt(columnIndexOrThrow543));
                    clockConfig2.setStep_keep_number_length(cursorQuery.getInt(columnIndexOrThrow544));
                    clockConfig2.setKcal_keep_number_length(cursorQuery.getInt(columnIndexOrThrow545));
                    clockConfig2.setKm_keep_number_length(cursorQuery.getInt(columnIndexOrThrow546));
                    clockConfig2.setStep_num_rotate(cursorQuery.getInt(columnIndexOrThrow547));
                    clockConfig2.setStep_num_rotate_degree(cursorQuery.getInt(columnIndexOrThrow548));
                    clockConfig2.setShow_btn_style(cursorQuery.getInt(columnIndexOrThrow549));
                    clockConfig2.setBtn_style_src(cursorQuery.isNull(columnIndexOrThrow550) ? null : cursorQuery.getString(columnIndexOrThrow550));
                    clockConfig2.setBtn_style_x(cursorQuery.getInt(columnIndexOrThrow551));
                    clockConfig2.setBtn_style_y(cursorQuery.getInt(columnIndexOrThrow552));
                    clockConfig2.setNeed_split_sec(cursorQuery.getInt(columnIndexOrThrow553));
                    clockConfig2.setSplit_sec_src(cursorQuery.isNull(columnIndexOrThrow554) ? null : cursorQuery.getString(columnIndexOrThrow554));
                    clockConfig2.setSplit_sec_x(cursorQuery.getInt(columnIndexOrThrow555));
                    clockConfig2.setSplit_sec_y(cursorQuery.getInt(columnIndexOrThrow556));
                    clockConfig2.setOpen_oxygen_arc_show(cursorQuery.getInt(columnIndexOrThrow557));
                    clockConfig2.setOxygen_arc_type(cursorQuery.getInt(columnIndexOrThrow558));
                    clockConfig2.setOxygen_arc_center_x(cursorQuery.getInt(columnIndexOrThrow559));
                    clockConfig2.setOxygen_arc_center_y(cursorQuery.getInt(columnIndexOrThrow560));
                    clockConfig2.setShow_oxygen_progress(cursorQuery.getInt(columnIndexOrThrow561));
                    clockConfig2.setOxygen_progress_src(cursorQuery.isNull(columnIndexOrThrow562) ? null : cursorQuery.getString(columnIndexOrThrow562));
                    clockConfig2.setOxygen_progress_x(cursorQuery.getInt(columnIndexOrThrow563));
                    clockConfig2.setOxygen_progress_y(cursorQuery.getInt(columnIndexOrThrow564));
                    clockConfig2.setShow_week_donts(cursorQuery.getInt(columnIndexOrThrow565));
                    clockConfig2.setWeek_donts_src(cursorQuery.isNull(columnIndexOrThrow566) ? null : cursorQuery.getString(columnIndexOrThrow566));
                    clockConfig2.setWeek_donts_x(cursorQuery.getInt(columnIndexOrThrow567));
                    clockConfig2.setWeek_donts_y(cursorQuery.getInt(columnIndexOrThrow568));
                    clockConfig2.setShow_btn_flashlight(cursorQuery.getInt(columnIndexOrThrow569));
                    clockConfig2.setFlashlight_src(cursorQuery.isNull(columnIndexOrThrow570) ? null : cursorQuery.getString(columnIndexOrThrow570));
                    clockConfig2.setFlashlight_x(cursorQuery.getInt(columnIndexOrThrow571));
                    clockConfig2.setFlashlight_y(cursorQuery.getInt(columnIndexOrThrow572));
                    clockConfig = clockConfig2;
                } else {
                    clockConfig = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return clockConfig;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.dw.launcher.data.database.dao.ClockConfigDao
    public ClockConfig findClickedNextClock(final String parentId, final int next_id) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        ClockConfig clockConfig;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from t_clock_config where id = ? and parent_id =? order by id asc", 2);
        roomSQLiteQueryAcquire.bindLong(1, next_id);
        if (parentId == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, parentId);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "path");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fromAssets");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_en");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screentype");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dialtype");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coordinate_screen_width");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coordinate_screen_height");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_type");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lottie");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_animal_keep_for_last_frame");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_count");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_interval");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_is_customize");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hour_pointer_src");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hour_pointer_x");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hour_pointer_y");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minute_pointer_src");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minute_pointer_x");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minute_pointer_y");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_src");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_x");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_y");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "second_pointer_animal_type");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dot_src");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dot_x");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dot_y");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_pointer_start_animation");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_start_hour");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_start_minute");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_start_second");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_need_jump");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_x");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_y");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_min");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_min_x");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_min_y");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_sec");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_sec");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_sec_x");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reset_sec_y");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_time_arc_show");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_arc_type");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_arc_center_x");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_arc_center_y");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_am_or_pm");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_and_pm_src");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_or_pm_x");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_or_pm_y");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_ampm_placeholer");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_digital_start_animation");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "digital_start_hour");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "digital_start_minute");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "digital_start_second");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_src");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_x");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_y");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_date_arc_show");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_arc_type");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_arc_center_x");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_arc_center_y");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_year_splt_src");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_month_splt_src");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_day_splt_src");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_year");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "year_digits_type");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_month");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_type");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_src");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_month");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data_month_num");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_x");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_y");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_day");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_reset_day");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data_day_num");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_x");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_y");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_src");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "day_type");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_src");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_num_src");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_x");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_y");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_power");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_0_src");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_1_src");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_2_src");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_3_src");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_4_src");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_5_src");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_6_src");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_7_src");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_8_src");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_9_src");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "normal_10_src");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_x");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_y");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_charge");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_0_src");
                int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_1_src");
                int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_2_src");
                int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_3_src");
                int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_4_src");
                int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_5_src");
                int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_6_src");
                int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_7_src");
                int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_8_src");
                int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_9_src");
                int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge_10_src");
                int columnIndexOrThrow119 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_power_num");
                int columnIndexOrThrow120 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_num_src");
                int columnIndexOrThrow121 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_sign_src");
                int columnIndexOrThrow122 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_show_type");
                int columnIndexOrThrow123 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_num_x");
                int columnIndexOrThrow124 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_num_y");
                int columnIndexOrThrow125 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_action");
                int columnIndexOrThrow126 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_action_1");
                int columnIndexOrThrow127 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_count");
                int columnIndexOrThrow128 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_x");
                int columnIndexOrThrow129 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_y");
                int columnIndexOrThrow130 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_action_2");
                int columnIndexOrThrow131 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_count");
                int columnIndexOrThrow132 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_x");
                int columnIndexOrThrow133 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_y");
                int columnIndexOrThrow134 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_action_3");
                int columnIndexOrThrow135 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_count");
                int columnIndexOrThrow136 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_x");
                int columnIndexOrThrow137 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_y");
                int columnIndexOrThrow138 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_interval");
                int columnIndexOrThrow139 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_overall_animation");
                int columnIndexOrThrow140 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "overall_animation_x");
                int columnIndexOrThrow141 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "overall_animation_y");
                int columnIndexOrThrow142 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_1");
                int columnIndexOrThrow143 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_x");
                int columnIndexOrThrow144 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_y");
                int columnIndexOrThrow145 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_width");
                int columnIndexOrThrow146 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_1_height");
                int columnIndexOrThrow147 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_2");
                int columnIndexOrThrow148 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_x");
                int columnIndexOrThrow149 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_y");
                int columnIndexOrThrow150 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_width");
                int columnIndexOrThrow151 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_2_height");
                int columnIndexOrThrow152 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_3");
                int columnIndexOrThrow153 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_x");
                int columnIndexOrThrow154 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_y");
                int columnIndexOrThrow155 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_width");
                int columnIndexOrThrow156 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_3_height");
                int columnIndexOrThrow157 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_click_4");
                int columnIndexOrThrow158 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_x");
                int columnIndexOrThrow159 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_y");
                int columnIndexOrThrow160 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_width");
                int columnIndexOrThrow161 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_4_height");
                int columnIndexOrThrow162 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_lunar");
                int columnIndexOrThrow163 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_src");
                int columnIndexOrThrow164 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_x");
                int columnIndexOrThrow165 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_y");
                int columnIndexOrThrow166 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_heart");
                int columnIndexOrThrow167 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_src");
                int columnIndexOrThrow168 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_x");
                int columnIndexOrThrow169 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_y");
                int columnIndexOrThrow170 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_src");
                int columnIndexOrThrow171 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_type");
                int columnIndexOrThrow172 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_end_src");
                int columnIndexOrThrow173 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_show_type");
                int columnIndexOrThrow174 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_x");
                int columnIndexOrThrow175 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_y");
                int columnIndexOrThrow176 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_heart_arc_show");
                int columnIndexOrThrow177 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_arc_type");
                int columnIndexOrThrow178 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_arc_center_x");
                int columnIndexOrThrow179 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_arc_center_y");
                int columnIndexOrThrow180 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_pressure");
                int columnIndexOrThrow181 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_src");
                int columnIndexOrThrow182 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_x");
                int columnIndexOrThrow183 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_y");
                int columnIndexOrThrow184 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_num_src");
                int columnIndexOrThrow185 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_num_x");
                int columnIndexOrThrow186 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_num_y");
                int columnIndexOrThrow187 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_show_type");
                int columnIndexOrThrow188 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pressure_splt_src");
                int columnIndexOrThrow189 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_step");
                int columnIndexOrThrow190 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_src");
                int columnIndexOrThrow191 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_follow_num");
                int columnIndexOrThrow192 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_x");
                int columnIndexOrThrow193 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_y");
                int columnIndexOrThrow194 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_src");
                int columnIndexOrThrow195 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_type");
                int columnIndexOrThrow196 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_show_type");
                int columnIndexOrThrow197 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_x");
                int columnIndexOrThrow198 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_y");
                int columnIndexOrThrow199 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_end_src");
                int columnIndexOrThrow200 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_step_progress");
                int columnIndexOrThrow201 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_progress_x");
                int columnIndexOrThrow202 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_progress_y");
                int columnIndexOrThrow203 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_progress_src");
                int columnIndexOrThrow204 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_step_arc_show");
                int columnIndexOrThrow205 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_arc_type");
                int columnIndexOrThrow206 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_arc_center_x");
                int columnIndexOrThrow207 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_arc_center_y");
                int columnIndexOrThrow208 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_kcal");
                int columnIndexOrThrow209 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_src");
                int columnIndexOrThrow210 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_x");
                int columnIndexOrThrow211 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_y");
                int columnIndexOrThrow212 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_src");
                int columnIndexOrThrow213 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_type");
                int columnIndexOrThrow214 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_show_type");
                int columnIndexOrThrow215 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_x");
                int columnIndexOrThrow216 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_y");
                int columnIndexOrThrow217 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_end_src");
                int columnIndexOrThrow218 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_km");
                int columnIndexOrThrow219 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_src");
                int columnIndexOrThrow220 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_x");
                int columnIndexOrThrow221 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_y");
                int columnIndexOrThrow222 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_src");
                int columnIndexOrThrow223 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_comma_src");
                int columnIndexOrThrow224 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_type");
                int columnIndexOrThrow225 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_show_type");
                int columnIndexOrThrow226 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_x");
                int columnIndexOrThrow227 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_num_y");
                int columnIndexOrThrow228 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_end_src");
                int columnIndexOrThrow229 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_weather");
                int columnIndexOrThrow230 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_temperature");
                int columnIndexOrThrow231 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_show_type");
                int columnIndexOrThrow232 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_num_type");
                int columnIndexOrThrow233 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_x");
                int columnIndexOrThrow234 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_y");
                int columnIndexOrThrow235 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_x_2");
                int columnIndexOrThrow236 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_y_2");
                int columnIndexOrThrow237 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_now_tem");
                int columnIndexOrThrow238 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_show_type");
                int columnIndexOrThrow239 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_x");
                int columnIndexOrThrow240 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_y");
                int columnIndexOrThrow241 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_num_src");
                int columnIndexOrThrow242 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_sub_src");
                int columnIndexOrThrow243 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_sign_src");
                int columnIndexOrThrow244 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temperature_splt_src");
                int columnIndexOrThrow245 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_diagram");
                int columnIndexOrThrow246 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "diagram_x");
                int columnIndexOrThrow247 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "diagram_y");
                int columnIndexOrThrow248 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "showsignal");
                int columnIndexOrThrow249 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_signal");
                int columnIndexOrThrow250 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "signal_src");
                int columnIndexOrThrow251 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "signal_x");
                int columnIndexOrThrow252 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "signal_y");
                int columnIndexOrThrow253 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_user_name");
                int columnIndexOrThrow254 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_show_type");
                int columnIndexOrThrow255 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_x");
                int columnIndexOrThrow256 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name_y");
                int columnIndexOrThrow257 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_operator");
                int columnIndexOrThrow258 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "operator_show_type");
                int columnIndexOrThrow259 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "operator_x");
                int columnIndexOrThrow260 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "operator_y");
                int columnIndexOrThrow261 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_call");
                int columnIndexOrThrow262 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_call_src");
                int columnIndexOrThrow263 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_call_x");
                int columnIndexOrThrow264 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_call_y");
                int columnIndexOrThrow265 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sms");
                int columnIndexOrThrow266 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sms_src");
                int columnIndexOrThrow267 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sms_x");
                int columnIndexOrThrow268 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sms_y");
                int columnIndexOrThrow269 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_heart");
                int columnIndexOrThrow270 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_our_heart");
                int columnIndexOrThrow271 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_heart_src");
                int columnIndexOrThrow272 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_heart_x");
                int columnIndexOrThrow273 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_heart_y");
                int columnIndexOrThrow274 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_step");
                int columnIndexOrThrow275 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_step_src");
                int columnIndexOrThrow276 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_step_x");
                int columnIndexOrThrow277 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_step_y");
                int columnIndexOrThrow278 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_wechat");
                int columnIndexOrThrow279 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_wechat_src");
                int columnIndexOrThrow280 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_wechat_x");
                int columnIndexOrThrow281 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_wechat_y");
                int columnIndexOrThrow282 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_alipay");
                int columnIndexOrThrow283 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alipay_src");
                int columnIndexOrThrow284 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alipay_x");
                int columnIndexOrThrow285 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alipay_y");
                int columnIndexOrThrow286 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_stopwatch");
                int columnIndexOrThrow287 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_stopwatch_src");
                int columnIndexOrThrow288 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_stopwatch_x");
                int columnIndexOrThrow289 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_stopwatch_y");
                int columnIndexOrThrow290 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_weather");
                int columnIndexOrThrow291 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calo");
                int columnIndexOrThrow292 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calo_src");
                int columnIndexOrThrow293 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calo_x");
                int columnIndexOrThrow294 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calo_y");
                int columnIndexOrThrow295 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "temprature_src");
                int columnIndexOrThrow296 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_camera");
                int columnIndexOrThrow297 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_camera_src");
                int columnIndexOrThrow298 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_camera_x");
                int columnIndexOrThrow299 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_camera_y");
                int columnIndexOrThrow300 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sos");
                int columnIndexOrThrow301 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sos_src");
                int columnIndexOrThrow302 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sos_x");
                int columnIndexOrThrow303 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sos_y");
                int columnIndexOrThrow304 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_special_1");
                int columnIndexOrThrow305 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_1_src");
                int columnIndexOrThrow306 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_1_position");
                int columnIndexOrThrow307 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_x");
                int columnIndexOrThrow308 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "special_y");
                int columnIndexOrThrow309 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_multiple_change");
                int columnIndexOrThrow310 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_lunar_year");
                int columnIndexOrThrow311 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_day_splt_src");
                int columnIndexOrThrow312 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_month_splt_src");
                int columnIndexOrThrow313 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lunar_year_splt_src");
                int columnIndexOrThrow314 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_src");
                int columnIndexOrThrow315 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pm_src");
                int columnIndexOrThrow316 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_alarm");
                int columnIndexOrThrow317 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alarm_src");
                int columnIndexOrThrow318 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alarm_x");
                int columnIndexOrThrow319 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_alarm_y");
                int columnIndexOrThrow320 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_btn_change");
                int columnIndexOrThrow321 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_btn_index");
                int columnIndexOrThrow322 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_music");
                int columnIndexOrThrow323 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_music_src");
                int columnIndexOrThrow324 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_music_x");
                int columnIndexOrThrow325 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_music_y");
                int columnIndexOrThrow326 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_dynamic_change");
                int columnIndexOrThrow327 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "level");
                int columnIndexOrThrow328 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parent_id");
                int columnIndexOrThrow329 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_id");
                int columnIndexOrThrow330 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "change_starttime");
                int columnIndexOrThrow331 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "change_endtime");
                int columnIndexOrThrow332 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_weather_src");
                int columnIndexOrThrow333 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_weather_x");
                int columnIndexOrThrow334 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_weather_y");
                int columnIndexOrThrow335 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calories");
                int columnIndexOrThrow336 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calories_src");
                int columnIndexOrThrow337 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calories_x");
                int columnIndexOrThrow338 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calories_y");
                int columnIndexOrThrow339 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_compass");
                int columnIndexOrThrow340 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_src");
                int columnIndexOrThrow341 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_2_src");
                int columnIndexOrThrow342 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_x");
                int columnIndexOrThrow343 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_y");
                int columnIndexOrThrow344 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_setting");
                int columnIndexOrThrow345 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_setting_src");
                int columnIndexOrThrow346 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_setting_x");
                int columnIndexOrThrow347 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_setting_y");
                int columnIndexOrThrow348 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_click_change");
                int columnIndexOrThrow349 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "click_id_is_current");
                int columnIndexOrThrow350 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_show_detail_degree");
                int columnIndexOrThrow351 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_src");
                int columnIndexOrThrow352 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_x");
                int columnIndexOrThrow353 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_y");
                int columnIndexOrThrow354 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_2_src");
                int columnIndexOrThrow355 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_2_x");
                int columnIndexOrThrow356 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_2_y");
                int columnIndexOrThrow357 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_3_src");
                int columnIndexOrThrow358 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_3_x");
                int columnIndexOrThrow359 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_3_y");
                int columnIndexOrThrow360 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_src");
                int columnIndexOrThrow361 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_x");
                int columnIndexOrThrow362 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_y");
                int columnIndexOrThrow363 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_direction_degree_unit");
                int columnIndexOrThrow364 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_1_src");
                int columnIndexOrThrow365 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_1_x");
                int columnIndexOrThrow366 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_1_y");
                int columnIndexOrThrow367 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_2_src");
                int columnIndexOrThrow368 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_2_x");
                int columnIndexOrThrow369 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_2_y");
                int columnIndexOrThrow370 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_3_src");
                int columnIndexOrThrow371 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_3_x");
                int columnIndexOrThrow372 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_degree_3_y");
                int columnIndexOrThrow373 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_connect_animation");
                int columnIndexOrThrow374 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connect_animation_x");
                int columnIndexOrThrow375 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connect_animation_y");
                int columnIndexOrThrow376 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connect_animation_count");
                int columnIndexOrThrow377 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_state");
                int columnIndexOrThrow378 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state_x");
                int columnIndexOrThrow379 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state_y");
                int columnIndexOrThrow380 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_1_cut_position");
                int columnIndexOrThrow381 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_2_cut_position");
                int columnIndexOrThrow382 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action_3_cut_position");
                int columnIndexOrThrow383 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_googleplay");
                int columnIndexOrThrow384 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_googleplay_src");
                int columnIndexOrThrow385 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_googleplay_x");
                int columnIndexOrThrow386 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_googleplay_y");
                int columnIndexOrThrow387 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_month_2");
                int columnIndexOrThrow388 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_type_2");
                int columnIndexOrThrow389 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_src_2");
                int columnIndexOrThrow390 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_x_2");
                int columnIndexOrThrow391 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "month_y_2");
                int columnIndexOrThrow392 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_new");
                int columnIndexOrThrow393 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_hour_ten_src");
                int columnIndexOrThrow394 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_hour_src");
                int columnIndexOrThrow395 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_min_ten_src");
                int columnIndexOrThrow396 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_min_src");
                int columnIndexOrThrow397 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_kcal_progress");
                int columnIndexOrThrow398 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_progress_x");
                int columnIndexOrThrow399 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_progress_y");
                int columnIndexOrThrow400 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_progress_src");
                int columnIndexOrThrow401 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_kcal_arc_show");
                int columnIndexOrThrow402 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_arc_type");
                int columnIndexOrThrow403 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_arc_center_x");
                int columnIndexOrThrow404 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_arc_center_y");
                int columnIndexOrThrow405 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_power_arc_show");
                int columnIndexOrThrow406 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_arc_type");
                int columnIndexOrThrow407 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_arc_center_x");
                int columnIndexOrThrow408 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_arc_center_y");
                int columnIndexOrThrow409 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_timer");
                int columnIndexOrThrow410 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_timer_src");
                int columnIndexOrThrow411 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_timer_x");
                int columnIndexOrThrow412 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_timer_y");
                int columnIndexOrThrow413 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sleep");
                int columnIndexOrThrow414 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sleep_src");
                int columnIndexOrThrow415 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sleep_x");
                int columnIndexOrThrow416 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sleep_y");
                int columnIndexOrThrow417 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_bloodpressure");
                int columnIndexOrThrow418 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_bloodpressure_src");
                int columnIndexOrThrow419 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_bloodpressure_x");
                int columnIndexOrThrow420 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_bloodpressure_y");
                int columnIndexOrThrow421 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_sport_record");
                int columnIndexOrThrow422 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sport_record_src");
                int columnIndexOrThrow423 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sport_record_x");
                int columnIndexOrThrow424 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_sport_record_y");
                int columnIndexOrThrow425 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lottie_hierarchy");
                int columnIndexOrThrow426 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_heart_progress");
                int columnIndexOrThrow427 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_progress_x");
                int columnIndexOrThrow428 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_progress_y");
                int columnIndexOrThrow429 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_progress_src");
                int columnIndexOrThrow430 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calculator");
                int columnIndexOrThrow431 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calculator_src");
                int columnIndexOrThrow432 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calculator_x");
                int columnIndexOrThrow433 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calculator_y");
                int columnIndexOrThrow434 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_special_drag_3d");
                int columnIndexOrThrow435 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_HourTen_Position");
                int columnIndexOrThrow436 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_HourGe_Position");
                int columnIndexOrThrow437 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_HourTen_Position");
                int columnIndexOrThrow438 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_HourGe_Position");
                int columnIndexOrThrow439 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_HourTen_Position");
                int columnIndexOrThrow440 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_HourGe_Position");
                int columnIndexOrThrow441 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_MinTen_Position");
                int columnIndexOrThrow442 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prev_MinGe_Position");
                int columnIndexOrThrow443 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_MinTen_Position");
                int columnIndexOrThrow444 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_MinGe_Position");
                int columnIndexOrThrow445 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_MinTen_Position");
                int columnIndexOrThrow446 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_MinGe_Position");
                int columnIndexOrThrow447 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_day");
                int columnIndexOrThrow448 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_day_x");
                int columnIndexOrThrow449 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_day_y");
                int columnIndexOrThrow450 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_now_tem_arc_show");
                int columnIndexOrThrow451 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_arc_type");
                int columnIndexOrThrow452 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_arc_center_x");
                int columnIndexOrThrow453 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "now_tem_arc_center_y");
                int columnIndexOrThrow454 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_km_progress");
                int columnIndexOrThrow455 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_progress_x");
                int columnIndexOrThrow456 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_progress_y");
                int columnIndexOrThrow457 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_progress_src");
                int columnIndexOrThrow458 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_km_arc_show");
                int columnIndexOrThrow459 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_arc_type");
                int columnIndexOrThrow460 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_arc_center_x");
                int columnIndexOrThrow461 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_arc_center_y");
                int columnIndexOrThrow462 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_rotate");
                int columnIndexOrThrow463 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_rotate_degree");
                int columnIndexOrThrow464 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_rotate");
                int columnIndexOrThrow465 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heart_num_rotate_degree");
                int columnIndexOrThrow466 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_oxygen");
                int columnIndexOrThrow467 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_src");
                int columnIndexOrThrow468 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_x");
                int columnIndexOrThrow469 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_y");
                int columnIndexOrThrow470 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_num_src");
                int columnIndexOrThrow471 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_sign_src");
                int columnIndexOrThrow472 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_show_type");
                int columnIndexOrThrow473 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_num_x");
                int columnIndexOrThrow474 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_num_y");
                int columnIndexOrThrow475 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_change_counter");
                int columnIndexOrThrow476 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src_2");
                int columnIndexOrThrow477 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src_2");
                int columnIndexOrThrow478 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src_2");
                int columnIndexOrThrow479 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src_2");
                int columnIndexOrThrow480 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src_2");
                int columnIndexOrThrow481 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src_3");
                int columnIndexOrThrow482 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src_3");
                int columnIndexOrThrow483 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src_3");
                int columnIndexOrThrow484 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src_3");
                int columnIndexOrThrow485 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src_3");
                int columnIndexOrThrow486 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_hour_src_4");
                int columnIndexOrThrow487 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_min_src_4");
                int columnIndexOrThrow488 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_sec_src_4");
                int columnIndexOrThrow489 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_src_4");
                int columnIndexOrThrow490 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time_splt_2_src_4");
                int columnIndexOrThrow491 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_rotate");
                int columnIndexOrThrow492 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_rotate_degree");
                int columnIndexOrThrow493 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_hour");
                int columnIndexOrThrow494 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_hour_src");
                int columnIndexOrThrow495 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_hour_x");
                int columnIndexOrThrow496 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_hour_y");
                int columnIndexOrThrow497 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_min");
                int columnIndexOrThrow498 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_min_src");
                int columnIndexOrThrow499 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_min_x");
                int columnIndexOrThrow500 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_min_y");
                int columnIndexOrThrow501 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "support_scale");
                int columnIndexOrThrow502 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_compass_num");
                int columnIndexOrThrow503 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_src");
                int columnIndexOrThrow504 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_show_type");
                int columnIndexOrThrow505 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_x");
                int columnIndexOrThrow506 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_y");
                int columnIndexOrThrow507 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_src_prefix");
                int columnIndexOrThrow508 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "compass_num_src_sign");
                int columnIndexOrThrow509 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_oxygen");
                int columnIndexOrThrow510 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_oxygen_src");
                int columnIndexOrThrow511 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_oxygen_x");
                int columnIndexOrThrow512 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_oxygen_y");
                int columnIndexOrThrow513 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_calendar");
                int columnIndexOrThrow514 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calendar_src");
                int columnIndexOrThrow515 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calendar_x");
                int columnIndexOrThrow516 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_calendar_y");
                int columnIndexOrThrow517 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_compass");
                int columnIndexOrThrow518 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_compass_src");
                int columnIndexOrThrow519 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_compass_x");
                int columnIndexOrThrow520 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_compass_y");
                int columnIndexOrThrow521 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pointer_disable_scale");
                int columnIndexOrThrow522 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_chinse_time");
                int columnIndexOrThrow523 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chinse_time_src");
                int columnIndexOrThrow524 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chinse_time_x");
                int columnIndexOrThrow525 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chinse_time_y");
                int columnIndexOrThrow526 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_photo");
                int columnIndexOrThrow527 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_photo_src");
                int columnIndexOrThrow528 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_photo_x");
                int columnIndexOrThrow529 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_photo_y");
                int columnIndexOrThrow530 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_contact");
                int columnIndexOrThrow531 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_contact_src");
                int columnIndexOrThrow532 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_contact_x");
                int columnIndexOrThrow533 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_contact_y");
                int columnIndexOrThrow534 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_rotate");
                int columnIndexOrThrow535 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_num_rotate_degree");
                int columnIndexOrThrow536 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_power_progress");
                int columnIndexOrThrow537 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_progress_src");
                int columnIndexOrThrow538 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_progress_x");
                int columnIndexOrThrow539 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_progress_y");
                int columnIndexOrThrow540 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_src");
                int columnIndexOrThrow541 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_src_x");
                int columnIndexOrThrow542 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power_src_y");
                int columnIndexOrThrow543 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_type");
                int columnIndexOrThrow544 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_keep_number_length");
                int columnIndexOrThrow545 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kcal_keep_number_length");
                int columnIndexOrThrow546 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "km_keep_number_length");
                int columnIndexOrThrow547 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_rotate");
                int columnIndexOrThrow548 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step_num_rotate_degree");
                int columnIndexOrThrow549 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_style");
                int columnIndexOrThrow550 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_style_src");
                int columnIndexOrThrow551 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_style_x");
                int columnIndexOrThrow552 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "btn_style_y");
                int columnIndexOrThrow553 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "need_split_sec");
                int columnIndexOrThrow554 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_sec_src");
                int columnIndexOrThrow555 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_sec_x");
                int columnIndexOrThrow556 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "split_sec_y");
                int columnIndexOrThrow557 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "open_oxygen_arc_show");
                int columnIndexOrThrow558 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_arc_type");
                int columnIndexOrThrow559 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_arc_center_x");
                int columnIndexOrThrow560 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_arc_center_y");
                int columnIndexOrThrow561 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_oxygen_progress");
                int columnIndexOrThrow562 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_progress_src");
                int columnIndexOrThrow563 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_progress_x");
                int columnIndexOrThrow564 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oxygen_progress_y");
                int columnIndexOrThrow565 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_week_donts");
                int columnIndexOrThrow566 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_donts_src");
                int columnIndexOrThrow567 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_donts_x");
                int columnIndexOrThrow568 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "week_donts_y");
                int columnIndexOrThrow569 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show_btn_flashlight");
                int columnIndexOrThrow570 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flashlight_src");
                int columnIndexOrThrow571 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flashlight_x");
                int columnIndexOrThrow572 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flashlight_y");
                if (cursorQuery.moveToFirst()) {
                    ClockConfig clockConfig2 = new ClockConfig();
                    clockConfig2.setPath(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                    clockConfig2.setFromAssets(cursorQuery.getInt(columnIndexOrThrow2) != 0);
                    clockConfig2.setId(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    clockConfig2.setName(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    clockConfig2.setName_en(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    clockConfig2.setScreentype(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    clockConfig2.setDialtype(cursorQuery.getInt(columnIndexOrThrow7));
                    clockConfig2.setCoordinate_screen_width(cursorQuery.getInt(columnIndexOrThrow8));
                    clockConfig2.setCoordinate_screen_height(cursorQuery.getInt(columnIndexOrThrow9));
                    clockConfig2.setBg_type(cursorQuery.getInt(columnIndexOrThrow10));
                    clockConfig2.setVideo(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    clockConfig2.setLottie(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    clockConfig2.setBg_animal_keep_for_last_frame(cursorQuery.getInt(columnIndexOrThrow13));
                    clockConfig2.setBg_count(cursorQuery.getInt(columnIndexOrThrow14));
                    clockConfig2.setBg_interval(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    clockConfig2.setBg_is_customize(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    clockConfig2.setHour_pointer_src(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                    clockConfig2.setHour_pointer_x(cursorQuery.getInt(columnIndexOrThrow18));
                    clockConfig2.setHour_pointer_y(cursorQuery.getInt(columnIndexOrThrow19));
                    clockConfig2.setMinute_pointer_src(cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20));
                    clockConfig2.setMinute_pointer_x(cursorQuery.getInt(columnIndexOrThrow21));
                    clockConfig2.setMinute_pointer_y(cursorQuery.getInt(columnIndexOrThrow22));
                    clockConfig2.setSecond_pointer_src(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    clockConfig2.setSecond_pointer_type(cursorQuery.getInt(columnIndexOrThrow24));
                    clockConfig2.setSecond_pointer_x(cursorQuery.getInt(columnIndexOrThrow25));
                    clockConfig2.setSecond_pointer_y(cursorQuery.getInt(columnIndexOrThrow26));
                    clockConfig2.setSecond_pointer_animal_type(cursorQuery.getInt(columnIndexOrThrow27));
                    clockConfig2.setDot_src(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    clockConfig2.setDot_x(cursorQuery.getInt(columnIndexOrThrow29));
                    clockConfig2.setDot_y(cursorQuery.getInt(columnIndexOrThrow30));
                    clockConfig2.setShow_pointer_start_animation(cursorQuery.getInt(columnIndexOrThrow31));
                    clockConfig2.setPointer_start_hour(cursorQuery.getInt(columnIndexOrThrow32));
                    clockConfig2.setPointer_start_minute(cursorQuery.getInt(columnIndexOrThrow33));
                    clockConfig2.setPointer_start_second(cursorQuery.getInt(columnIndexOrThrow34));
                    clockConfig2.setTime_hour_src(cursorQuery.isNull(columnIndexOrThrow35) ? null : cursorQuery.getString(columnIndexOrThrow35));
                    clockConfig2.setTime_min_src(cursorQuery.isNull(columnIndexOrThrow36) ? null : cursorQuery.getString(columnIndexOrThrow36));
                    clockConfig2.setTime_sec_src(cursorQuery.isNull(columnIndexOrThrow37) ? null : cursorQuery.getString(columnIndexOrThrow37));
                    clockConfig2.setTime_splt_src(cursorQuery.isNull(columnIndexOrThrow38) ? null : cursorQuery.getString(columnIndexOrThrow38));
                    clockConfig2.setTime_splt_2_src(cursorQuery.isNull(columnIndexOrThrow39) ? null : cursorQuery.getString(columnIndexOrThrow39));
                    clockConfig2.setTime_splt_need_jump(cursorQuery.getInt(columnIndexOrThrow40));
                    clockConfig2.setTime_x(cursorQuery.getInt(columnIndexOrThrow41));
                    clockConfig2.setTime_y(cursorQuery.getInt(columnIndexOrThrow42));
                    clockConfig2.setNeed_reset_min(cursorQuery.getInt(columnIndexOrThrow43));
                    clockConfig2.setReset_min_x(cursorQuery.getInt(columnIndexOrThrow44));
                    clockConfig2.setReset_min_y(cursorQuery.getInt(columnIndexOrThrow45));
                    clockConfig2.setShow_sec(cursorQuery.getInt(columnIndexOrThrow46));
                    clockConfig2.setNeed_reset_sec(cursorQuery.getInt(columnIndexOrThrow47));
                    clockConfig2.setReset_sec_x(cursorQuery.getInt(columnIndexOrThrow48));
                    clockConfig2.setReset_sec_y(cursorQuery.getInt(columnIndexOrThrow49));
                    clockConfig2.setOpen_time_arc_show(cursorQuery.getInt(columnIndexOrThrow50));
                    clockConfig2.setTime_arc_type(cursorQuery.getInt(columnIndexOrThrow51));
                    clockConfig2.setTime_arc_center_x(cursorQuery.getInt(columnIndexOrThrow52));
                    clockConfig2.setTime_arc_center_y(cursorQuery.getInt(columnIndexOrThrow53));
                    clockConfig2.setShow_am_or_pm(cursorQuery.getInt(columnIndexOrThrow54));
                    clockConfig2.setAm_and_pm_src(cursorQuery.isNull(columnIndexOrThrow55) ? null : cursorQuery.getString(columnIndexOrThrow55));
                    clockConfig2.setAm_or_pm_x(cursorQuery.getInt(columnIndexOrThrow56));
                    clockConfig2.setAm_or_pm_y(cursorQuery.getInt(columnIndexOrThrow57));
                    clockConfig2.setShow_ampm_placeholer(cursorQuery.getInt(columnIndexOrThrow58));
                    clockConfig2.setShow_digital_start_animation(cursorQuery.getInt(columnIndexOrThrow59));
                    clockConfig2.setDigital_start_hour(cursorQuery.getInt(columnIndexOrThrow60));
                    clockConfig2.setDigital_start_minute(cursorQuery.getInt(columnIndexOrThrow61));
                    clockConfig2.setDigital_start_second(cursorQuery.getInt(columnIndexOrThrow62));
                    clockConfig2.setDate_src(cursorQuery.isNull(columnIndexOrThrow63) ? null : cursorQuery.getString(columnIndexOrThrow63));
                    clockConfig2.setDate_x(cursorQuery.getInt(columnIndexOrThrow64));
                    clockConfig2.setDate_y(cursorQuery.getInt(columnIndexOrThrow65));
                    clockConfig2.setOpen_date_arc_show(cursorQuery.getInt(columnIndexOrThrow66));
                    clockConfig2.setDate_arc_type(cursorQuery.getInt(columnIndexOrThrow67));
                    clockConfig2.setDate_arc_center_x(cursorQuery.getInt(columnIndexOrThrow68));
                    clockConfig2.setDate_arc_center_y(cursorQuery.getInt(columnIndexOrThrow69));
                    clockConfig2.setDate_year_splt_src(cursorQuery.isNull(columnIndexOrThrow70) ? null : cursorQuery.getString(columnIndexOrThrow70));
                    clockConfig2.setDate_month_splt_src(cursorQuery.isNull(columnIndexOrThrow71) ? null : cursorQuery.getString(columnIndexOrThrow71));
                    clockConfig2.setDate_day_splt_src(cursorQuery.isNull(columnIndexOrThrow72) ? null : cursorQuery.getString(columnIndexOrThrow72));
                    clockConfig2.setShow_year(cursorQuery.getInt(columnIndexOrThrow73));
                    clockConfig2.setYear_digits_type(cursorQuery.getInt(columnIndexOrThrow74));
                    clockConfig2.setShow_month(cursorQuery.getInt(columnIndexOrThrow75));
                    clockConfig2.setMonth_type(cursorQuery.getInt(columnIndexOrThrow76));
                    clockConfig2.setMonth_src(cursorQuery.isNull(columnIndexOrThrow77) ? null : cursorQuery.getString(columnIndexOrThrow77));
                    clockConfig2.setNeed_reset_month(cursorQuery.getInt(columnIndexOrThrow78));
                    clockConfig2.setData_month_num(cursorQuery.isNull(columnIndexOrThrow79) ? null : cursorQuery.getString(columnIndexOrThrow79));
                    clockConfig2.setMonth_x(cursorQuery.getInt(columnIndexOrThrow80));
                    clockConfig2.setMonth_y(cursorQuery.getInt(columnIndexOrThrow81));
                    clockConfig2.setShow_day(cursorQuery.getInt(columnIndexOrThrow82));
                    clockConfig2.setNeed_reset_day(cursorQuery.getInt(columnIndexOrThrow83));
                    clockConfig2.setData_day_num(cursorQuery.isNull(columnIndexOrThrow84) ? null : cursorQuery.getString(columnIndexOrThrow84));
                    clockConfig2.setDay_x(cursorQuery.getInt(columnIndexOrThrow85));
                    clockConfig2.setDay_y(cursorQuery.getInt(columnIndexOrThrow86));
                    clockConfig2.setDay_src(cursorQuery.isNull(columnIndexOrThrow87) ? null : cursorQuery.getString(columnIndexOrThrow87));
                    clockConfig2.setDay_type(cursorQuery.getInt(columnIndexOrThrow88));
                    clockConfig2.setWeek_src(cursorQuery.isNull(columnIndexOrThrow89) ? null : cursorQuery.getString(columnIndexOrThrow89));
                    clockConfig2.setWeek_num_src(cursorQuery.isNull(columnIndexOrThrow90) ? null : cursorQuery.getString(columnIndexOrThrow90));
                    clockConfig2.setWeek_x(cursorQuery.getInt(columnIndexOrThrow91));
                    clockConfig2.setWeek_y(cursorQuery.getInt(columnIndexOrThrow92));
                    clockConfig2.setShow_power(cursorQuery.getInt(columnIndexOrThrow93));
                    clockConfig2.setNormal_0_src(cursorQuery.isNull(columnIndexOrThrow94) ? null : cursorQuery.getString(columnIndexOrThrow94));
                    clockConfig2.setNormal_1_src(cursorQuery.isNull(columnIndexOrThrow95) ? null : cursorQuery.getString(columnIndexOrThrow95));
                    clockConfig2.setNormal_2_src(cursorQuery.isNull(columnIndexOrThrow96) ? null : cursorQuery.getString(columnIndexOrThrow96));
                    clockConfig2.setNormal_3_src(cursorQuery.isNull(columnIndexOrThrow97) ? null : cursorQuery.getString(columnIndexOrThrow97));
                    clockConfig2.setNormal_4_src(cursorQuery.isNull(columnIndexOrThrow98) ? null : cursorQuery.getString(columnIndexOrThrow98));
                    clockConfig2.setNormal_5_src(cursorQuery.isNull(columnIndexOrThrow99) ? null : cursorQuery.getString(columnIndexOrThrow99));
                    clockConfig2.setNormal_6_src(cursorQuery.isNull(columnIndexOrThrow100) ? null : cursorQuery.getString(columnIndexOrThrow100));
                    clockConfig2.setNormal_7_src(cursorQuery.isNull(columnIndexOrThrow101) ? null : cursorQuery.getString(columnIndexOrThrow101));
                    clockConfig2.setNormal_8_src(cursorQuery.isNull(columnIndexOrThrow102) ? null : cursorQuery.getString(columnIndexOrThrow102));
                    clockConfig2.setNormal_9_src(cursorQuery.isNull(columnIndexOrThrow103) ? null : cursorQuery.getString(columnIndexOrThrow103));
                    clockConfig2.setNormal_10_src(cursorQuery.isNull(columnIndexOrThrow104) ? null : cursorQuery.getString(columnIndexOrThrow104));
                    clockConfig2.setPower_x(cursorQuery.getInt(columnIndexOrThrow105));
                    clockConfig2.setPower_y(cursorQuery.getInt(columnIndexOrThrow106));
                    clockConfig2.setShow_charge(cursorQuery.getInt(columnIndexOrThrow107));
                    clockConfig2.setCharge_0_src(cursorQuery.isNull(columnIndexOrThrow108) ? null : cursorQuery.getString(columnIndexOrThrow108));
                    clockConfig2.setCharge_1_src(cursorQuery.isNull(columnIndexOrThrow109) ? null : cursorQuery.getString(columnIndexOrThrow109));
                    clockConfig2.setCharge_2_src(cursorQuery.isNull(columnIndexOrThrow110) ? null : cursorQuery.getString(columnIndexOrThrow110));
                    clockConfig2.setCharge_3_src(cursorQuery.isNull(columnIndexOrThrow111) ? null : cursorQuery.getString(columnIndexOrThrow111));
                    clockConfig2.setCharge_4_src(cursorQuery.isNull(columnIndexOrThrow112) ? null : cursorQuery.getString(columnIndexOrThrow112));
                    clockConfig2.setCharge_5_src(cursorQuery.isNull(columnIndexOrThrow113) ? null : cursorQuery.getString(columnIndexOrThrow113));
                    clockConfig2.setCharge_6_src(cursorQuery.isNull(columnIndexOrThrow114) ? null : cursorQuery.getString(columnIndexOrThrow114));
                    clockConfig2.setCharge_7_src(cursorQuery.isNull(columnIndexOrThrow115) ? null : cursorQuery.getString(columnIndexOrThrow115));
                    clockConfig2.setCharge_8_src(cursorQuery.isNull(columnIndexOrThrow116) ? null : cursorQuery.getString(columnIndexOrThrow116));
                    clockConfig2.setCharge_9_src(cursorQuery.isNull(columnIndexOrThrow117) ? null : cursorQuery.getString(columnIndexOrThrow117));
                    clockConfig2.setCharge_10_src(cursorQuery.isNull(columnIndexOrThrow118) ? null : cursorQuery.getString(columnIndexOrThrow118));
                    clockConfig2.setShow_power_num(cursorQuery.getInt(columnIndexOrThrow119));
                    clockConfig2.setPower_num_src(cursorQuery.isNull(columnIndexOrThrow120) ? null : cursorQuery.getString(columnIndexOrThrow120));
                    clockConfig2.setPower_sign_src(cursorQuery.isNull(columnIndexOrThrow121) ? null : cursorQuery.getString(columnIndexOrThrow121));
                    clockConfig2.setPower_show_type(cursorQuery.getInt(columnIndexOrThrow122));
                    clockConfig2.setPower_num_x(cursorQuery.getInt(columnIndexOrThrow123));
                    clockConfig2.setPower_num_y(cursorQuery.getInt(columnIndexOrThrow124));
                    clockConfig2.setShow_action(cursorQuery.getInt(columnIndexOrThrow125));
                    clockConfig2.setOpen_action_1(cursorQuery.getInt(columnIndexOrThrow126));
                    clockConfig2.setAction_1_count(cursorQuery.getInt(columnIndexOrThrow127));
                    clockConfig2.setAction_1_x(cursorQuery.getInt(columnIndexOrThrow128));
                    clockConfig2.setAction_1_y(cursorQuery.getInt(columnIndexOrThrow129));
                    clockConfig2.setOpen_action_2(cursorQuery.getInt(columnIndexOrThrow130));
                    clockConfig2.setAction_2_count(cursorQuery.getInt(columnIndexOrThrow131));
                    clockConfig2.setAction_2_x(cursorQuery.getInt(columnIndexOrThrow132));
                    clockConfig2.setAction_2_y(cursorQuery.getInt(columnIndexOrThrow133));
                    clockConfig2.setOpen_action_3(cursorQuery.getInt(columnIndexOrThrow134));
                    clockConfig2.setAction_3_count(cursorQuery.getInt(columnIndexOrThrow135));
                    clockConfig2.setAction_3_x(cursorQuery.getInt(columnIndexOrThrow136));
                    clockConfig2.setAction_3_y(cursorQuery.getInt(columnIndexOrThrow137));
                    clockConfig2.setAction_interval(cursorQuery.getInt(columnIndexOrThrow138));
                    clockConfig2.setShow_overall_animation(cursorQuery.isNull(columnIndexOrThrow139) ? null : cursorQuery.getString(columnIndexOrThrow139));
                    clockConfig2.setOverall_animation_x(cursorQuery.getInt(columnIndexOrThrow140));
                    clockConfig2.setOverall_animation_y(cursorQuery.getInt(columnIndexOrThrow141));
                    clockConfig2.setOpen_click_1(cursorQuery.isNull(columnIndexOrThrow142) ? null : cursorQuery.getString(columnIndexOrThrow142));
                    clockConfig2.setClick_1_x(cursorQuery.getInt(columnIndexOrThrow143));
                    clockConfig2.setClick_1_y(cursorQuery.getInt(columnIndexOrThrow144));
                    clockConfig2.setClick_1_width(cursorQuery.isNull(columnIndexOrThrow145) ? null : cursorQuery.getString(columnIndexOrThrow145));
                    clockConfig2.setClick_1_height(cursorQuery.isNull(columnIndexOrThrow146) ? null : cursorQuery.getString(columnIndexOrThrow146));
                    clockConfig2.setOpen_click_2(cursorQuery.isNull(columnIndexOrThrow147) ? null : cursorQuery.getString(columnIndexOrThrow147));
                    clockConfig2.setClick_2_x(cursorQuery.getInt(columnIndexOrThrow148));
                    clockConfig2.setClick_2_y(cursorQuery.getInt(columnIndexOrThrow149));
                    clockConfig2.setClick_2_width(cursorQuery.isNull(columnIndexOrThrow150) ? null : cursorQuery.getString(columnIndexOrThrow150));
                    clockConfig2.setClick_2_height(cursorQuery.isNull(columnIndexOrThrow151) ? null : cursorQuery.getString(columnIndexOrThrow151));
                    clockConfig2.setOpen_click_3(cursorQuery.isNull(columnIndexOrThrow152) ? null : cursorQuery.getString(columnIndexOrThrow152));
                    clockConfig2.setClick_3_x(cursorQuery.getInt(columnIndexOrThrow153));
                    clockConfig2.setClick_3_y(cursorQuery.getInt(columnIndexOrThrow154));
                    clockConfig2.setClick_3_width(cursorQuery.isNull(columnIndexOrThrow155) ? null : cursorQuery.getString(columnIndexOrThrow155));
                    clockConfig2.setClick_3_height(cursorQuery.isNull(columnIndexOrThrow156) ? null : cursorQuery.getString(columnIndexOrThrow156));
                    clockConfig2.setOpen_click_4(cursorQuery.isNull(columnIndexOrThrow157) ? null : cursorQuery.getString(columnIndexOrThrow157));
                    clockConfig2.setClick_4_x(cursorQuery.getInt(columnIndexOrThrow158));
                    clockConfig2.setClick_4_y(cursorQuery.getInt(columnIndexOrThrow159));
                    clockConfig2.setClick_4_width(cursorQuery.isNull(columnIndexOrThrow160) ? null : cursorQuery.getString(columnIndexOrThrow160));
                    clockConfig2.setClick_4_height(cursorQuery.isNull(columnIndexOrThrow161) ? null : cursorQuery.getString(columnIndexOrThrow161));
                    clockConfig2.setShow_lunar(cursorQuery.getInt(columnIndexOrThrow162));
                    clockConfig2.setLunar_src(cursorQuery.isNull(columnIndexOrThrow163) ? null : cursorQuery.getString(columnIndexOrThrow163));
                    clockConfig2.setLunar_x(cursorQuery.getInt(columnIndexOrThrow164));
                    clockConfig2.setLunar_y(cursorQuery.getInt(columnIndexOrThrow165));
                    clockConfig2.setShow_heart(cursorQuery.getInt(columnIndexOrThrow166));
                    clockConfig2.setHeart_src(cursorQuery.isNull(columnIndexOrThrow167) ? null : cursorQuery.getString(columnIndexOrThrow167));
                    clockConfig2.setHeart_x(cursorQuery.getInt(columnIndexOrThrow168));
                    clockConfig2.setHeart_y(cursorQuery.getInt(columnIndexOrThrow169));
                    clockConfig2.setHeart_num_src(cursorQuery.isNull(columnIndexOrThrow170) ? null : cursorQuery.getString(columnIndexOrThrow170));
                    clockConfig2.setHeart_num_type(cursorQuery.isNull(columnIndexOrThrow171) ? null : cursorQuery.getString(columnIndexOrThrow171));
                    clockConfig2.setHeart_end_src(cursorQuery.isNull(columnIndexOrThrow172) ? null : cursorQuery.getString(columnIndexOrThrow172));
                    clockConfig2.setHeart_show_type(cursorQuery.getInt(columnIndexOrThrow173));
                    clockConfig2.setHeart_num_x(cursorQuery.getInt(columnIndexOrThrow174));
                    clockConfig2.setHeart_num_y(cursorQuery.getInt(columnIndexOrThrow175));
                    clockConfig2.setOpen_heart_arc_show(cursorQuery.getInt(columnIndexOrThrow176));
                    clockConfig2.setHeart_arc_type(cursorQuery.getInt(columnIndexOrThrow177));
                    clockConfig2.setHeart_arc_center_x(cursorQuery.getInt(columnIndexOrThrow178));
                    clockConfig2.setHeart_arc_center_y(cursorQuery.getInt(columnIndexOrThrow179));
                    clockConfig2.setShow_pressure(cursorQuery.isNull(columnIndexOrThrow180) ? null : cursorQuery.getString(columnIndexOrThrow180));
                    clockConfig2.setPressure_src(cursorQuery.isNull(columnIndexOrThrow181) ? null : cursorQuery.getString(columnIndexOrThrow181));
                    clockConfig2.setPressure_x(cursorQuery.getInt(columnIndexOrThrow182));
                    clockConfig2.setPressure_y(cursorQuery.getInt(columnIndexOrThrow183));
                    clockConfig2.setPressure_num_src(cursorQuery.isNull(columnIndexOrThrow184) ? null : cursorQuery.getString(columnIndexOrThrow184));
                    clockConfig2.setPressure_num_x(cursorQuery.getInt(columnIndexOrThrow185));
                    clockConfig2.setPressure_num_y(cursorQuery.getInt(columnIndexOrThrow186));
                    clockConfig2.setPressure_show_type(cursorQuery.isNull(columnIndexOrThrow187) ? null : cursorQuery.getString(columnIndexOrThrow187));
                    clockConfig2.setPressure_splt_src(cursorQuery.isNull(columnIndexOrThrow188) ? null : cursorQuery.getString(columnIndexOrThrow188));
                    clockConfig2.setShow_step(cursorQuery.getInt(columnIndexOrThrow189));
                    clockConfig2.setStep_src(cursorQuery.isNull(columnIndexOrThrow190) ? null : cursorQuery.getString(columnIndexOrThrow190));
                    clockConfig2.setStep_follow_num(cursorQuery.getInt(columnIndexOrThrow191));
                    clockConfig2.setStep_x(cursorQuery.getInt(columnIndexOrThrow192));
                    clockConfig2.setStep_y(cursorQuery.getInt(columnIndexOrThrow193));
                    clockConfig2.setStep_num_src(cursorQuery.isNull(columnIndexOrThrow194) ? null : cursorQuery.getString(columnIndexOrThrow194));
                    clockConfig2.setStep_num_type(cursorQuery.getInt(columnIndexOrThrow195));
                    clockConfig2.setStep_show_type(cursorQuery.getInt(columnIndexOrThrow196));
                    clockConfig2.setStep_num_x(cursorQuery.getInt(columnIndexOrThrow197));
                    clockConfig2.setStep_num_y(cursorQuery.getInt(columnIndexOrThrow198));
                    clockConfig2.setStep_end_src(cursorQuery.isNull(columnIndexOrThrow199) ? null : cursorQuery.getString(columnIndexOrThrow199));
                    clockConfig2.setShow_step_progress(cursorQuery.getInt(columnIndexOrThrow200));
                    clockConfig2.setStep_progress_x(cursorQuery.getInt(columnIndexOrThrow201));
                    clockConfig2.setStep_progress_y(cursorQuery.getInt(columnIndexOrThrow202));
                    clockConfig2.setStep_progress_src(cursorQuery.isNull(columnIndexOrThrow203) ? null : cursorQuery.getString(columnIndexOrThrow203));
                    clockConfig2.setOpen_step_arc_show(cursorQuery.getInt(columnIndexOrThrow204));
                    clockConfig2.setStep_arc_type(cursorQuery.getInt(columnIndexOrThrow205));
                    clockConfig2.setStep_arc_center_x(cursorQuery.getInt(columnIndexOrThrow206));
                    clockConfig2.setStep_arc_center_y(cursorQuery.getInt(columnIndexOrThrow207));
                    clockConfig2.setShow_kcal(cursorQuery.getInt(columnIndexOrThrow208));
                    clockConfig2.setKcal_src(cursorQuery.isNull(columnIndexOrThrow209) ? null : cursorQuery.getString(columnIndexOrThrow209));
                    clockConfig2.setKcal_x(cursorQuery.getInt(columnIndexOrThrow210));
                    clockConfig2.setKcal_y(cursorQuery.getInt(columnIndexOrThrow211));
                    clockConfig2.setKcal_num_src(cursorQuery.isNull(columnIndexOrThrow212) ? null : cursorQuery.getString(columnIndexOrThrow212));
                    clockConfig2.setKcal_num_type(cursorQuery.getInt(columnIndexOrThrow213));
                    clockConfig2.setKcal_show_type(cursorQuery.getInt(columnIndexOrThrow214));
                    clockConfig2.setKcal_num_x(cursorQuery.getInt(columnIndexOrThrow215));
                    clockConfig2.setKcal_num_y(cursorQuery.getInt(columnIndexOrThrow216));
                    clockConfig2.setKcal_end_src(cursorQuery.isNull(columnIndexOrThrow217) ? null : cursorQuery.getString(columnIndexOrThrow217));
                    clockConfig2.setShow_km(cursorQuery.isNull(columnIndexOrThrow218) ? null : cursorQuery.getString(columnIndexOrThrow218));
                    clockConfig2.setKm_src(cursorQuery.isNull(columnIndexOrThrow219) ? null : cursorQuery.getString(columnIndexOrThrow219));
                    clockConfig2.setKm_x(cursorQuery.getInt(columnIndexOrThrow220));
                    clockConfig2.setKm_y(cursorQuery.getInt(columnIndexOrThrow221));
                    clockConfig2.setKm_num_src(cursorQuery.isNull(columnIndexOrThrow222) ? null : cursorQuery.getString(columnIndexOrThrow222));
                    clockConfig2.setKm_comma_src(cursorQuery.isNull(columnIndexOrThrow223) ? null : cursorQuery.getString(columnIndexOrThrow223));
                    clockConfig2.setKm_num_type(cursorQuery.isNull(columnIndexOrThrow224) ? null : cursorQuery.getString(columnIndexOrThrow224));
                    clockConfig2.setKm_show_type(cursorQuery.getInt(columnIndexOrThrow225));
                    clockConfig2.setKm_num_x(cursorQuery.getInt(columnIndexOrThrow226));
                    clockConfig2.setKm_num_y(cursorQuery.getInt(columnIndexOrThrow227));
                    clockConfig2.setKm_end_src(cursorQuery.isNull(columnIndexOrThrow228) ? null : cursorQuery.getString(columnIndexOrThrow228));
                    clockConfig2.setShow_weather(cursorQuery.isNull(columnIndexOrThrow229) ? null : cursorQuery.getString(columnIndexOrThrow229));
                    clockConfig2.setShow_temperature(cursorQuery.isNull(columnIndexOrThrow230) ? null : cursorQuery.getString(columnIndexOrThrow230));
                    clockConfig2.setTemperature_show_type(cursorQuery.getInt(columnIndexOrThrow231));
                    clockConfig2.setTemperature_num_type(cursorQuery.getInt(columnIndexOrThrow232));
                    clockConfig2.setTemperature_x(cursorQuery.getInt(columnIndexOrThrow233));
                    clockConfig2.setTemperature_y(cursorQuery.getInt(columnIndexOrThrow234));
                    clockConfig2.setTemperature_x_2(cursorQuery.getInt(columnIndexOrThrow235));
                    clockConfig2.setTemperature_y_2(cursorQuery.getInt(columnIndexOrThrow236));
                    clockConfig2.setShow_now_tem(cursorQuery.isNull(columnIndexOrThrow237) ? null : cursorQuery.getString(columnIndexOrThrow237));
                    clockConfig2.setNow_tem_show_type(cursorQuery.isNull(columnIndexOrThrow238) ? null : cursorQuery.getString(columnIndexOrThrow238));
                    clockConfig2.setNow_tem_x(cursorQuery.getInt(columnIndexOrThrow239));
                    clockConfig2.setNow_tem_y(cursorQuery.getInt(columnIndexOrThrow240));
                    clockConfig2.setTemperature_num_src(cursorQuery.isNull(columnIndexOrThrow241) ? null : cursorQuery.getString(columnIndexOrThrow241));
                    clockConfig2.setTemperature_sub_src(cursorQuery.isNull(columnIndexOrThrow242) ? null : cursorQuery.getString(columnIndexOrThrow242));
                    clockConfig2.setTemperature_sign_src(cursorQuery.isNull(columnIndexOrThrow243) ? null : cursorQuery.getString(columnIndexOrThrow243));
                    clockConfig2.setTemperature_splt_src(cursorQuery.isNull(columnIndexOrThrow244) ? null : cursorQuery.getString(columnIndexOrThrow244));
                    clockConfig2.setShow_diagram(cursorQuery.isNull(columnIndexOrThrow245) ? null : cursorQuery.getString(columnIndexOrThrow245));
                    clockConfig2.setDiagram_x(cursorQuery.getInt(columnIndexOrThrow246));
                    clockConfig2.setDiagram_y(cursorQuery.getInt(columnIndexOrThrow247));
                    clockConfig2.setShowsignal(cursorQuery.getInt(columnIndexOrThrow248));
                    clockConfig2.setShow_signal(cursorQuery.getInt(columnIndexOrThrow249));
                    clockConfig2.setSignal_src(cursorQuery.isNull(columnIndexOrThrow250) ? null : cursorQuery.getString(columnIndexOrThrow250));
                    clockConfig2.setSignal_x(cursorQuery.getInt(columnIndexOrThrow251));
                    clockConfig2.setSignal_y(cursorQuery.getInt(columnIndexOrThrow252));
                    clockConfig2.setShow_user_name(cursorQuery.isNull(columnIndexOrThrow253) ? null : cursorQuery.getString(columnIndexOrThrow253));
                    clockConfig2.setName_show_type(cursorQuery.isNull(columnIndexOrThrow254) ? null : cursorQuery.getString(columnIndexOrThrow254));
                    clockConfig2.setName_x(cursorQuery.getInt(columnIndexOrThrow255));
                    clockConfig2.setName_y(cursorQuery.getInt(columnIndexOrThrow256));
                    clockConfig2.setShow_operator(cursorQuery.isNull(columnIndexOrThrow257) ? null : cursorQuery.getString(columnIndexOrThrow257));
                    clockConfig2.setOperator_show_type(cursorQuery.isNull(columnIndexOrThrow258) ? null : cursorQuery.getString(columnIndexOrThrow258));
                    clockConfig2.setOperator_x(cursorQuery.getInt(columnIndexOrThrow259));
                    clockConfig2.setOperator_y(cursorQuery.getInt(columnIndexOrThrow260));
                    clockConfig2.setShow_btn_call(cursorQuery.isNull(columnIndexOrThrow261) ? null : cursorQuery.getString(columnIndexOrThrow261));
                    clockConfig2.setBtn_call_src(cursorQuery.isNull(columnIndexOrThrow262) ? null : cursorQuery.getString(columnIndexOrThrow262));
                    clockConfig2.setBtn_call_x(cursorQuery.getInt(columnIndexOrThrow263));
                    clockConfig2.setBtn_call_y(cursorQuery.getInt(columnIndexOrThrow264));
                    clockConfig2.setShow_btn_sms(cursorQuery.isNull(columnIndexOrThrow265) ? null : cursorQuery.getString(columnIndexOrThrow265));
                    clockConfig2.setBtn_sms_src(cursorQuery.isNull(columnIndexOrThrow266) ? null : cursorQuery.getString(columnIndexOrThrow266));
                    clockConfig2.setBtn_sms_x(cursorQuery.getInt(columnIndexOrThrow267));
                    clockConfig2.setBtn_sms_y(cursorQuery.getInt(columnIndexOrThrow268));
                    clockConfig2.setShow_btn_heart(cursorQuery.isNull(columnIndexOrThrow269) ? null : cursorQuery.getString(columnIndexOrThrow269));
                    clockConfig2.setIs_our_heart(cursorQuery.getInt(columnIndexOrThrow270));
                    clockConfig2.setBtn_heart_src(cursorQuery.isNull(columnIndexOrThrow271) ? null : cursorQuery.getString(columnIndexOrThrow271));
                    clockConfig2.setBtn_heart_x(cursorQuery.getInt(columnIndexOrThrow272));
                    clockConfig2.setBtn_heart_y(cursorQuery.getInt(columnIndexOrThrow273));
                    clockConfig2.setShow_btn_step(cursorQuery.isNull(columnIndexOrThrow274) ? null : cursorQuery.getString(columnIndexOrThrow274));
                    clockConfig2.setBtn_step_src(cursorQuery.isNull(columnIndexOrThrow275) ? null : cursorQuery.getString(columnIndexOrThrow275));
                    clockConfig2.setBtn_step_x(cursorQuery.getInt(columnIndexOrThrow276));
                    clockConfig2.setBtn_step_y(cursorQuery.getInt(columnIndexOrThrow277));
                    clockConfig2.setShow_btn_wechat(cursorQuery.isNull(columnIndexOrThrow278) ? null : cursorQuery.getString(columnIndexOrThrow278));
                    clockConfig2.setBtn_wechat_src(cursorQuery.isNull(columnIndexOrThrow279) ? null : cursorQuery.getString(columnIndexOrThrow279));
                    clockConfig2.setBtn_wechat_x(cursorQuery.getInt(columnIndexOrThrow280));
                    clockConfig2.setBtn_wechat_y(cursorQuery.getInt(columnIndexOrThrow281));
                    clockConfig2.setShow_btn_alipay(cursorQuery.getInt(columnIndexOrThrow282));
                    clockConfig2.setBtn_alipay_src(cursorQuery.isNull(columnIndexOrThrow283) ? null : cursorQuery.getString(columnIndexOrThrow283));
                    clockConfig2.setBtn_alipay_x(cursorQuery.getInt(columnIndexOrThrow284));
                    clockConfig2.setBtn_alipay_y(cursorQuery.getInt(columnIndexOrThrow285));
                    clockConfig2.setShow_btn_stopwatch(cursorQuery.getInt(columnIndexOrThrow286));
                    clockConfig2.setBtn_stopwatch_src(cursorQuery.isNull(columnIndexOrThrow287) ? null : cursorQuery.getString(columnIndexOrThrow287));
                    clockConfig2.setBtn_stopwatch_x(cursorQuery.getInt(columnIndexOrThrow288));
                    clockConfig2.setBtn_stopwatch_y(cursorQuery.getInt(columnIndexOrThrow289));
                    clockConfig2.setShow_btn_weather(cursorQuery.getInt(columnIndexOrThrow290));
                    clockConfig2.setShow_btn_calo(cursorQuery.getInt(columnIndexOrThrow291));
                    clockConfig2.setBtn_calo_src(cursorQuery.isNull(columnIndexOrThrow292) ? null : cursorQuery.getString(columnIndexOrThrow292));
                    clockConfig2.setBtn_calo_x(cursorQuery.getInt(columnIndexOrThrow293));
                    clockConfig2.setBtn_calo_y(cursorQuery.getInt(columnIndexOrThrow294));
                    clockConfig2.setTemprature_src(cursorQuery.isNull(columnIndexOrThrow295) ? null : cursorQuery.getString(columnIndexOrThrow295));
                    clockConfig2.setShow_btn_camera(cursorQuery.isNull(columnIndexOrThrow296) ? null : cursorQuery.getString(columnIndexOrThrow296));
                    clockConfig2.setBtn_camera_src(cursorQuery.isNull(columnIndexOrThrow297) ? null : cursorQuery.getString(columnIndexOrThrow297));
                    clockConfig2.setBtn_camera_x(cursorQuery.getInt(columnIndexOrThrow298));
                    clockConfig2.setBtn_camera_y(cursorQuery.getInt(columnIndexOrThrow299));
                    clockConfig2.setShow_btn_sos(cursorQuery.isNull(columnIndexOrThrow300) ? null : cursorQuery.getString(columnIndexOrThrow300));
                    clockConfig2.setBtn_sos_src(cursorQuery.isNull(columnIndexOrThrow301) ? null : cursorQuery.getString(columnIndexOrThrow301));
                    clockConfig2.setBtn_sos_x(cursorQuery.getInt(columnIndexOrThrow302));
                    clockConfig2.setBtn_sos_y(cursorQuery.getInt(columnIndexOrThrow303));
                    clockConfig2.setShow_special_1(cursorQuery.isNull(columnIndexOrThrow304) ? null : cursorQuery.getString(columnIndexOrThrow304));
                    clockConfig2.setSpecial_1_src(cursorQuery.isNull(columnIndexOrThrow305) ? null : cursorQuery.getString(columnIndexOrThrow305));
                    clockConfig2.setSpecial_1_position(cursorQuery.isNull(columnIndexOrThrow306) ? null : cursorQuery.getString(columnIndexOrThrow306));
                    clockConfig2.setSpecial_x(cursorQuery.getInt(columnIndexOrThrow307));
                    clockConfig2.setSpecial_y(cursorQuery.getInt(columnIndexOrThrow308));
                    clockConfig2.setSupport_multiple_change(cursorQuery.getInt(columnIndexOrThrow309));
                    clockConfig2.setShow_lunar_year(cursorQuery.getInt(columnIndexOrThrow310));
                    clockConfig2.setLunar_day_splt_src(cursorQuery.isNull(columnIndexOrThrow311) ? null : cursorQuery.getString(columnIndexOrThrow311));
                    clockConfig2.setLunar_month_splt_src(cursorQuery.isNull(columnIndexOrThrow312) ? null : cursorQuery.getString(columnIndexOrThrow312));
                    clockConfig2.setLunar_year_splt_src(cursorQuery.isNull(columnIndexOrThrow313) ? null : cursorQuery.getString(columnIndexOrThrow313));
                    clockConfig2.setAm_src(cursorQuery.isNull(columnIndexOrThrow314) ? null : cursorQuery.getString(columnIndexOrThrow314));
                    clockConfig2.setPm_src(cursorQuery.isNull(columnIndexOrThrow315) ? null : cursorQuery.getString(columnIndexOrThrow315));
                    clockConfig2.setShow_btn_alarm(cursorQuery.getInt(columnIndexOrThrow316));
                    clockConfig2.setBtn_alarm_src(cursorQuery.isNull(columnIndexOrThrow317) ? null : cursorQuery.getString(columnIndexOrThrow317));
                    clockConfig2.setBtn_alarm_x(cursorQuery.getInt(columnIndexOrThrow318));
                    clockConfig2.setBtn_alarm_y(cursorQuery.getInt(columnIndexOrThrow319));
                    clockConfig2.setBg_btn_change(cursorQuery.getInt(columnIndexOrThrow320));
                    clockConfig2.setBg_btn_index(cursorQuery.getInt(columnIndexOrThrow321));
                    clockConfig2.setShow_btn_music(cursorQuery.getInt(columnIndexOrThrow322));
                    clockConfig2.setBtn_music_src(cursorQuery.isNull(columnIndexOrThrow323) ? null : cursorQuery.getString(columnIndexOrThrow323));
                    clockConfig2.setBtn_music_x(cursorQuery.getInt(columnIndexOrThrow324));
                    clockConfig2.setBtn_music_y(cursorQuery.getInt(columnIndexOrThrow325));
                    clockConfig2.setSupport_dynamic_change(cursorQuery.getInt(columnIndexOrThrow326));
                    clockConfig2.setLevel(cursorQuery.getInt(columnIndexOrThrow327));
                    clockConfig2.setParent_id(cursorQuery.isNull(columnIndexOrThrow328) ? null : cursorQuery.getString(columnIndexOrThrow328));
                    clockConfig2.setNext_id(cursorQuery.getInt(columnIndexOrThrow329));
                    clockConfig2.setChange_starttime(cursorQuery.getInt(columnIndexOrThrow330));
                    clockConfig2.setChange_endtime(cursorQuery.getInt(columnIndexOrThrow331));
                    clockConfig2.setBtn_weather_src(cursorQuery.isNull(columnIndexOrThrow332) ? null : cursorQuery.getString(columnIndexOrThrow332));
                    clockConfig2.setBtn_weather_x(cursorQuery.getInt(columnIndexOrThrow333));
                    clockConfig2.setBtn_weather_y(cursorQuery.getInt(columnIndexOrThrow334));
                    clockConfig2.setShow_btn_calories(cursorQuery.getInt(columnIndexOrThrow335));
                    clockConfig2.setBtn_calories_src(cursorQuery.isNull(columnIndexOrThrow336) ? null : cursorQuery.getString(columnIndexOrThrow336));
                    clockConfig2.setBtn_calories_x(cursorQuery.getInt(columnIndexOrThrow337));
                    clockConfig2.setBtn_calories_y(cursorQuery.getInt(columnIndexOrThrow338));
                    clockConfig2.setSupport_compass(cursorQuery.getInt(columnIndexOrThrow339));
                    clockConfig2.setCompass_src(cursorQuery.isNull(columnIndexOrThrow340) ? null : cursorQuery.getString(columnIndexOrThrow340));
                    clockConfig2.setCompass_2_src(cursorQuery.isNull(columnIndexOrThrow341) ? null : cursorQuery.getString(columnIndexOrThrow341));
                    clockConfig2.setCompass_x(cursorQuery.getInt(columnIndexOrThrow342));
                    clockConfig2.setCompass_y(cursorQuery.getInt(columnIndexOrThrow343));
                    clockConfig2.setShow_btn_setting(cursorQuery.getInt(columnIndexOrThrow344));
                    clockConfig2.setBtn_setting_src(cursorQuery.isNull(columnIndexOrThrow345) ? null : cursorQuery.getString(columnIndexOrThrow345));
                    clockConfig2.setBtn_setting_x(cursorQuery.getInt(columnIndexOrThrow346));
                    clockConfig2.setBtn_setting_y(cursorQuery.getInt(columnIndexOrThrow347));
                    clockConfig2.setSupport_click_change(cursorQuery.getInt(columnIndexOrThrow348));
                    clockConfig2.setClick_id_is_current(cursorQuery.getInt(columnIndexOrThrow349));
                    clockConfig2.setCompass_show_detail_degree(cursorQuery.getInt(columnIndexOrThrow350));
                    clockConfig2.setCompass_direction_src(cursorQuery.isNull(columnIndexOrThrow351) ? null : cursorQuery.getString(columnIndexOrThrow351));
                    clockConfig2.setCompass_direction_x(cursorQuery.getInt(columnIndexOrThrow352));
                    clockConfig2.setCompass_direction_y(cursorQuery.getInt(columnIndexOrThrow353));
                    clockConfig2.setCompass_direction_2_src(cursorQuery.isNull(columnIndexOrThrow354) ? null : cursorQuery.getString(columnIndexOrThrow354));
                    clockConfig2.setCompass_direction_2_x(cursorQuery.getInt(columnIndexOrThrow355));
                    clockConfig2.setCompass_direction_2_y(cursorQuery.getInt(columnIndexOrThrow356));
                    clockConfig2.setCompass_direction_3_src(cursorQuery.isNull(columnIndexOrThrow357) ? null : cursorQuery.getString(columnIndexOrThrow357));
                    clockConfig2.setCompass_direction_3_x(cursorQuery.getInt(columnIndexOrThrow358));
                    clockConfig2.setCompass_direction_3_y(cursorQuery.getInt(columnIndexOrThrow359));
                    clockConfig2.setCompass_direction_degree_src(cursorQuery.isNull(columnIndexOrThrow360) ? null : cursorQuery.getString(columnIndexOrThrow360));
                    clockConfig2.setCompass_direction_degree_x(cursorQuery.getInt(columnIndexOrThrow361));
                    clockConfig2.setCompass_direction_degree_y(cursorQuery.getInt(columnIndexOrThrow362));
                    clockConfig2.setCompass_direction_degree_unit(cursorQuery.isNull(columnIndexOrThrow363) ? null : cursorQuery.getString(columnIndexOrThrow363));
                    clockConfig2.setCompass_degree_1_src(cursorQuery.isNull(columnIndexOrThrow364) ? null : cursorQuery.getString(columnIndexOrThrow364));
                    clockConfig2.setCompass_degree_1_x(cursorQuery.getInt(columnIndexOrThrow365));
                    clockConfig2.setCompass_degree_1_y(cursorQuery.getInt(columnIndexOrThrow366));
                    clockConfig2.setCompass_degree_2_src(cursorQuery.isNull(columnIndexOrThrow367) ? null : cursorQuery.getString(columnIndexOrThrow367));
                    clockConfig2.setCompass_degree_2_x(cursorQuery.getInt(columnIndexOrThrow368));
                    clockConfig2.setCompass_degree_2_y(cursorQuery.getInt(columnIndexOrThrow369));
                    clockConfig2.setCompass_degree_3_src(cursorQuery.isNull(columnIndexOrThrow370) ? null : cursorQuery.getString(columnIndexOrThrow370));
                    clockConfig2.setCompass_degree_3_x(cursorQuery.getInt(columnIndexOrThrow371));
                    clockConfig2.setCompass_degree_3_y(cursorQuery.getInt(columnIndexOrThrow372));
                    clockConfig2.setShow_connect_animation(cursorQuery.getInt(columnIndexOrThrow373));
                    clockConfig2.setConnect_animation_x(cursorQuery.getInt(columnIndexOrThrow374));
                    clockConfig2.setConnect_animation_y(cursorQuery.getInt(columnIndexOrThrow375));
                    clockConfig2.setConnect_animation_count(cursorQuery.getInt(columnIndexOrThrow376));
                    clockConfig2.setShow_state(cursorQuery.getInt(columnIndexOrThrow377));
                    clockConfig2.setState_x(cursorQuery.getInt(columnIndexOrThrow378));
                    clockConfig2.setState_y(cursorQuery.getInt(columnIndexOrThrow379));
                    clockConfig2.setAction_1_cut_position(cursorQuery.getInt(columnIndexOrThrow380));
                    clockConfig2.setAction_2_cut_position(cursorQuery.getInt(columnIndexOrThrow381));
                    clockConfig2.setAction_3_cut_position(cursorQuery.getInt(columnIndexOrThrow382));
                    clockConfig2.setShow_btn_googleplay(cursorQuery.getInt(columnIndexOrThrow383));
                    clockConfig2.setBtn_googleplay_src(cursorQuery.isNull(columnIndexOrThrow384) ? null : cursorQuery.getString(columnIndexOrThrow384));
                    clockConfig2.setBtn_googleplay_x(cursorQuery.getInt(columnIndexOrThrow385));
                    clockConfig2.setBtn_googleplay_y(cursorQuery.getInt(columnIndexOrThrow386));
                    clockConfig2.setShow_month_2(cursorQuery.getInt(columnIndexOrThrow387));
                    clockConfig2.setMonth_type_2(cursorQuery.getInt(columnIndexOrThrow388));
                    clockConfig2.setMonth_src_2(cursorQuery.isNull(columnIndexOrThrow389) ? null : cursorQuery.getString(columnIndexOrThrow389));
                    clockConfig2.setMonth_x_2(cursorQuery.getInt(columnIndexOrThrow390));
                    clockConfig2.setMonth_y_2(cursorQuery.getInt(columnIndexOrThrow391));
                    clockConfig2.setTime_special_new(cursorQuery.getInt(columnIndexOrThrow392));
                    clockConfig2.setTime_special_hour_ten_src(cursorQuery.isNull(columnIndexOrThrow393) ? null : cursorQuery.getString(columnIndexOrThrow393));
                    clockConfig2.setTime_special_hour_src(cursorQuery.isNull(columnIndexOrThrow394) ? null : cursorQuery.getString(columnIndexOrThrow394));
                    clockConfig2.setTime_special_min_ten_src(cursorQuery.isNull(columnIndexOrThrow395) ? null : cursorQuery.getString(columnIndexOrThrow395));
                    clockConfig2.setTime_special_min_src(cursorQuery.isNull(columnIndexOrThrow396) ? null : cursorQuery.getString(columnIndexOrThrow396));
                    clockConfig2.setShow_kcal_progress(cursorQuery.getInt(columnIndexOrThrow397));
                    clockConfig2.setKcal_progress_x(cursorQuery.getInt(columnIndexOrThrow398));
                    clockConfig2.setKcal_progress_y(cursorQuery.getInt(columnIndexOrThrow399));
                    clockConfig2.setKcal_progress_src(cursorQuery.isNull(columnIndexOrThrow400) ? null : cursorQuery.getString(columnIndexOrThrow400));
                    clockConfig2.setOpen_kcal_arc_show(cursorQuery.getInt(columnIndexOrThrow401));
                    clockConfig2.setKcal_arc_type(cursorQuery.getInt(columnIndexOrThrow402));
                    clockConfig2.setKcal_arc_center_x(cursorQuery.getInt(columnIndexOrThrow403));
                    clockConfig2.setKcal_arc_center_y(cursorQuery.getInt(columnIndexOrThrow404));
                    clockConfig2.setOpen_power_arc_show(cursorQuery.getInt(columnIndexOrThrow405));
                    clockConfig2.setPower_arc_type(cursorQuery.getInt(columnIndexOrThrow406));
                    clockConfig2.setPower_arc_center_x(cursorQuery.getInt(columnIndexOrThrow407));
                    clockConfig2.setPower_arc_center_y(cursorQuery.getInt(columnIndexOrThrow408));
                    clockConfig2.setShow_btn_timer(cursorQuery.getInt(columnIndexOrThrow409));
                    clockConfig2.setBtn_timer_src(cursorQuery.isNull(columnIndexOrThrow410) ? null : cursorQuery.getString(columnIndexOrThrow410));
                    clockConfig2.setBtn_timer_x(cursorQuery.getInt(columnIndexOrThrow411));
                    clockConfig2.setBtn_timer_y(cursorQuery.getInt(columnIndexOrThrow412));
                    clockConfig2.setShow_btn_sleep(cursorQuery.getInt(columnIndexOrThrow413));
                    clockConfig2.setBtn_sleep_src(cursorQuery.isNull(columnIndexOrThrow414) ? null : cursorQuery.getString(columnIndexOrThrow414));
                    clockConfig2.setBtn_sleep_x(cursorQuery.getInt(columnIndexOrThrow415));
                    clockConfig2.setBtn_sleep_y(cursorQuery.getInt(columnIndexOrThrow416));
                    clockConfig2.setShow_btn_bloodpressure(cursorQuery.getInt(columnIndexOrThrow417));
                    clockConfig2.setBtn_bloodpressure_src(cursorQuery.isNull(columnIndexOrThrow418) ? null : cursorQuery.getString(columnIndexOrThrow418));
                    clockConfig2.setBtn_bloodpressure_x(cursorQuery.getInt(columnIndexOrThrow419));
                    clockConfig2.setBtn_bloodpressure_y(cursorQuery.getInt(columnIndexOrThrow420));
                    clockConfig2.setShow_btn_sport_record(cursorQuery.getInt(columnIndexOrThrow421));
                    clockConfig2.setBtn_sport_record_src(cursorQuery.isNull(columnIndexOrThrow422) ? null : cursorQuery.getString(columnIndexOrThrow422));
                    clockConfig2.setBtn_sport_record_x(cursorQuery.getInt(columnIndexOrThrow423));
                    clockConfig2.setBtn_sport_record_y(cursorQuery.getInt(columnIndexOrThrow424));
                    clockConfig2.setLottie_hierarchy(cursorQuery.getInt(columnIndexOrThrow425));
                    clockConfig2.setShow_heart_progress(cursorQuery.getInt(columnIndexOrThrow426));
                    clockConfig2.setHeart_progress_x(cursorQuery.getInt(columnIndexOrThrow427));
                    clockConfig2.setHeart_progress_y(cursorQuery.getInt(columnIndexOrThrow428));
                    clockConfig2.setHeart_progress_src(cursorQuery.isNull(columnIndexOrThrow429) ? null : cursorQuery.getString(columnIndexOrThrow429));
                    clockConfig2.setShow_btn_calculator(cursorQuery.getInt(columnIndexOrThrow430));
                    clockConfig2.setBtn_calculator_src(cursorQuery.isNull(columnIndexOrThrow431) ? null : cursorQuery.getString(columnIndexOrThrow431));
                    clockConfig2.setBtn_calculator_x(cursorQuery.getInt(columnIndexOrThrow432));
                    clockConfig2.setBtn_calculator_y(cursorQuery.getInt(columnIndexOrThrow433));
                    clockConfig2.setTime_special_drag_3d(cursorQuery.getInt(columnIndexOrThrow434));
                    clockConfig2.setPrev_HourTen_Position(cursorQuery.isNull(columnIndexOrThrow435) ? null : cursorQuery.getString(columnIndexOrThrow435));
                    clockConfig2.setPrev_HourGe_Position(cursorQuery.isNull(columnIndexOrThrow436) ? null : cursorQuery.getString(columnIndexOrThrow436));
                    clockConfig2.setCurrent_HourTen_Position(cursorQuery.isNull(columnIndexOrThrow437) ? null : cursorQuery.getString(columnIndexOrThrow437));
                    clockConfig2.setCurrent_HourGe_Position(cursorQuery.isNull(columnIndexOrThrow438) ? null : cursorQuery.getString(columnIndexOrThrow438));
                    clockConfig2.setNext_HourTen_Position(cursorQuery.isNull(columnIndexOrThrow439) ? null : cursorQuery.getString(columnIndexOrThrow439));
                    clockConfig2.setNext_HourGe_Position(cursorQuery.isNull(columnIndexOrThrow440) ? null : cursorQuery.getString(columnIndexOrThrow440));
                    clockConfig2.setPrev_MinTen_Position(cursorQuery.isNull(columnIndexOrThrow441) ? null : cursorQuery.getString(columnIndexOrThrow441));
                    clockConfig2.setPrev_MinGe_Position(cursorQuery.isNull(columnIndexOrThrow442) ? null : cursorQuery.getString(columnIndexOrThrow442));
                    clockConfig2.setCurrent_MinTen_Position(cursorQuery.isNull(columnIndexOrThrow443) ? null : cursorQuery.getString(columnIndexOrThrow443));
                    clockConfig2.setCurrent_MinGe_Position(cursorQuery.isNull(columnIndexOrThrow444) ? null : cursorQuery.getString(columnIndexOrThrow444));
                    clockConfig2.setNext_MinTen_Position(cursorQuery.isNull(columnIndexOrThrow445) ? null : cursorQuery.getString(columnIndexOrThrow445));
                    clockConfig2.setNext_MinGe_Position(cursorQuery.isNull(columnIndexOrThrow446) ? null : cursorQuery.getString(columnIndexOrThrow446));
                    clockConfig2.setNeed_split_day(cursorQuery.getInt(columnIndexOrThrow447));
                    clockConfig2.setSplit_day_x(cursorQuery.getInt(columnIndexOrThrow448));
                    clockConfig2.setSplit_day_y(cursorQuery.getInt(columnIndexOrThrow449));
                    clockConfig2.setOpen_now_tem_arc_show(cursorQuery.getInt(columnIndexOrThrow450));
                    clockConfig2.setNow_tem_arc_type(cursorQuery.getInt(columnIndexOrThrow451));
                    clockConfig2.setNow_tem_arc_center_x(cursorQuery.getInt(columnIndexOrThrow452));
                    clockConfig2.setNow_tem_arc_center_y(cursorQuery.getInt(columnIndexOrThrow453));
                    clockConfig2.setShow_km_progress(cursorQuery.getInt(columnIndexOrThrow454));
                    clockConfig2.setKm_progress_x(cursorQuery.getInt(columnIndexOrThrow455));
                    clockConfig2.setKm_progress_y(cursorQuery.getInt(columnIndexOrThrow456));
                    clockConfig2.setKm_progress_src(cursorQuery.isNull(columnIndexOrThrow457) ? null : cursorQuery.getString(columnIndexOrThrow457));
                    clockConfig2.setOpen_km_arc_show(cursorQuery.getInt(columnIndexOrThrow458));
                    clockConfig2.setKm_arc_type(cursorQuery.getInt(columnIndexOrThrow459));
                    clockConfig2.setKm_arc_center_x(cursorQuery.getInt(columnIndexOrThrow460));
                    clockConfig2.setKm_arc_center_y(cursorQuery.getInt(columnIndexOrThrow461));
                    clockConfig2.setTime_rotate(cursorQuery.getInt(columnIndexOrThrow462));
                    clockConfig2.setTime_rotate_degree(cursorQuery.getInt(columnIndexOrThrow463));
                    clockConfig2.setHeart_num_rotate(cursorQuery.getInt(columnIndexOrThrow464));
                    clockConfig2.setHeart_num_rotate_degree(cursorQuery.getInt(columnIndexOrThrow465));
                    clockConfig2.setShow_oxygen(cursorQuery.getInt(columnIndexOrThrow466));
                    clockConfig2.setOxygen_src(cursorQuery.isNull(columnIndexOrThrow467) ? null : cursorQuery.getString(columnIndexOrThrow467));
                    clockConfig2.setOxygen_x(cursorQuery.getInt(columnIndexOrThrow468));
                    clockConfig2.setOxygen_y(cursorQuery.getInt(columnIndexOrThrow469));
                    clockConfig2.setOxygen_num_src(cursorQuery.isNull(columnIndexOrThrow470) ? null : cursorQuery.getString(columnIndexOrThrow470));
                    clockConfig2.setOxygen_sign_src(cursorQuery.isNull(columnIndexOrThrow471) ? null : cursorQuery.getString(columnIndexOrThrow471));
                    clockConfig2.setOxygen_show_type(cursorQuery.getInt(columnIndexOrThrow472));
                    clockConfig2.setOxygen_num_x(cursorQuery.getInt(columnIndexOrThrow473));
                    clockConfig2.setOxygen_num_y(cursorQuery.getInt(columnIndexOrThrow474));
                    clockConfig2.setTime_change_counter(cursorQuery.getInt(columnIndexOrThrow475));
                    clockConfig2.setTime_hour_src_2(cursorQuery.isNull(columnIndexOrThrow476) ? null : cursorQuery.getString(columnIndexOrThrow476));
                    clockConfig2.setTime_min_src_2(cursorQuery.isNull(columnIndexOrThrow477) ? null : cursorQuery.getString(columnIndexOrThrow477));
                    clockConfig2.setTime_sec_src_2(cursorQuery.isNull(columnIndexOrThrow478) ? null : cursorQuery.getString(columnIndexOrThrow478));
                    clockConfig2.setTime_splt_src_2(cursorQuery.isNull(columnIndexOrThrow479) ? null : cursorQuery.getString(columnIndexOrThrow479));
                    clockConfig2.setTime_splt_2_src_2(cursorQuery.isNull(columnIndexOrThrow480) ? null : cursorQuery.getString(columnIndexOrThrow480));
                    clockConfig2.setTime_hour_src_3(cursorQuery.isNull(columnIndexOrThrow481) ? null : cursorQuery.getString(columnIndexOrThrow481));
                    clockConfig2.setTime_min_src_3(cursorQuery.isNull(columnIndexOrThrow482) ? null : cursorQuery.getString(columnIndexOrThrow482));
                    clockConfig2.setTime_sec_src_3(cursorQuery.isNull(columnIndexOrThrow483) ? null : cursorQuery.getString(columnIndexOrThrow483));
                    clockConfig2.setTime_splt_src_3(cursorQuery.isNull(columnIndexOrThrow484) ? null : cursorQuery.getString(columnIndexOrThrow484));
                    clockConfig2.setTime_splt_2_src_3(cursorQuery.isNull(columnIndexOrThrow485) ? null : cursorQuery.getString(columnIndexOrThrow485));
                    clockConfig2.setTime_hour_src_4(cursorQuery.isNull(columnIndexOrThrow486) ? null : cursorQuery.getString(columnIndexOrThrow486));
                    clockConfig2.setTime_min_src_4(cursorQuery.isNull(columnIndexOrThrow487) ? null : cursorQuery.getString(columnIndexOrThrow487));
                    clockConfig2.setTime_sec_src_4(cursorQuery.isNull(columnIndexOrThrow488) ? null : cursorQuery.getString(columnIndexOrThrow488));
                    clockConfig2.setTime_splt_src_4(cursorQuery.isNull(columnIndexOrThrow489) ? null : cursorQuery.getString(columnIndexOrThrow489));
                    clockConfig2.setTime_splt_2_src_4(cursorQuery.isNull(columnIndexOrThrow490) ? null : cursorQuery.getString(columnIndexOrThrow490));
                    clockConfig2.setDate_rotate(cursorQuery.getInt(columnIndexOrThrow491));
                    clockConfig2.setDate_rotate_degree(cursorQuery.getInt(columnIndexOrThrow492));
                    clockConfig2.setNeed_split_hour(cursorQuery.getInt(columnIndexOrThrow493));
                    clockConfig2.setSplit_hour_src(cursorQuery.isNull(columnIndexOrThrow494) ? null : cursorQuery.getString(columnIndexOrThrow494));
                    clockConfig2.setSplit_hour_x(cursorQuery.getInt(columnIndexOrThrow495));
                    clockConfig2.setSplit_hour_y(cursorQuery.getInt(columnIndexOrThrow496));
                    clockConfig2.setNeed_split_min(cursorQuery.getInt(columnIndexOrThrow497));
                    clockConfig2.setSplit_min_src(cursorQuery.isNull(columnIndexOrThrow498) ? null : cursorQuery.getString(columnIndexOrThrow498));
                    clockConfig2.setSplit_min_x(cursorQuery.getInt(columnIndexOrThrow499));
                    clockConfig2.setSplit_min_y(cursorQuery.getInt(columnIndexOrThrow500));
                    clockConfig2.setSupport_scale(cursorQuery.getInt(columnIndexOrThrow501));
                    clockConfig2.setShow_compass_num(cursorQuery.getInt(columnIndexOrThrow502));
                    clockConfig2.setCompass_num_src(cursorQuery.isNull(columnIndexOrThrow503) ? null : cursorQuery.getString(columnIndexOrThrow503));
                    clockConfig2.setCompass_show_type(cursorQuery.getInt(columnIndexOrThrow504));
                    clockConfig2.setCompass_num_x(cursorQuery.getInt(columnIndexOrThrow505));
                    clockConfig2.setCompass_num_y(cursorQuery.getInt(columnIndexOrThrow506));
                    clockConfig2.setCompass_num_src_prefix(cursorQuery.isNull(columnIndexOrThrow507) ? null : cursorQuery.getString(columnIndexOrThrow507));
                    clockConfig2.setCompass_num_src_sign(cursorQuery.isNull(columnIndexOrThrow508) ? null : cursorQuery.getString(columnIndexOrThrow508));
                    clockConfig2.setShow_btn_oxygen(cursorQuery.getInt(columnIndexOrThrow509));
                    clockConfig2.setBtn_oxygen_src(cursorQuery.isNull(columnIndexOrThrow510) ? null : cursorQuery.getString(columnIndexOrThrow510));
                    clockConfig2.setBtn_oxygen_x(cursorQuery.getInt(columnIndexOrThrow511));
                    clockConfig2.setBtn_oxygen_y(cursorQuery.getInt(columnIndexOrThrow512));
                    clockConfig2.setShow_btn_calendar(cursorQuery.getInt(columnIndexOrThrow513));
                    clockConfig2.setBtn_calendar_src(cursorQuery.isNull(columnIndexOrThrow514) ? null : cursorQuery.getString(columnIndexOrThrow514));
                    clockConfig2.setBtn_calendar_x(cursorQuery.getInt(columnIndexOrThrow515));
                    clockConfig2.setBtn_calendar_y(cursorQuery.getInt(columnIndexOrThrow516));
                    clockConfig2.setShow_btn_compass(cursorQuery.getInt(columnIndexOrThrow517));
                    clockConfig2.setBtn_compass_src(cursorQuery.isNull(columnIndexOrThrow518) ? null : cursorQuery.getString(columnIndexOrThrow518));
                    clockConfig2.setBtn_compass_x(cursorQuery.getInt(columnIndexOrThrow519));
                    clockConfig2.setBtn_compass_y(cursorQuery.getInt(columnIndexOrThrow520));
                    clockConfig2.setPointer_disable_scale(cursorQuery.getInt(columnIndexOrThrow521));
                    clockConfig2.setShow_chinse_time(cursorQuery.getInt(columnIndexOrThrow522));
                    clockConfig2.setChinse_time_src(cursorQuery.isNull(columnIndexOrThrow523) ? null : cursorQuery.getString(columnIndexOrThrow523));
                    clockConfig2.setChinse_time_x(cursorQuery.getInt(columnIndexOrThrow524));
                    clockConfig2.setChinse_time_y(cursorQuery.getInt(columnIndexOrThrow525));
                    clockConfig2.setShow_btn_photo(cursorQuery.getInt(columnIndexOrThrow526));
                    clockConfig2.setBtn_photo_src(cursorQuery.isNull(columnIndexOrThrow527) ? null : cursorQuery.getString(columnIndexOrThrow527));
                    clockConfig2.setBtn_photo_x(cursorQuery.getInt(columnIndexOrThrow528));
                    clockConfig2.setBtn_photo_y(cursorQuery.getInt(columnIndexOrThrow529));
                    clockConfig2.setShow_btn_contact(cursorQuery.getInt(columnIndexOrThrow530));
                    clockConfig2.setBtn_contact_src(cursorQuery.isNull(columnIndexOrThrow531) ? null : cursorQuery.getString(columnIndexOrThrow531));
                    clockConfig2.setBtn_contact_x(cursorQuery.getInt(columnIndexOrThrow532));
                    clockConfig2.setBtn_contact_y(cursorQuery.getInt(columnIndexOrThrow533));
                    clockConfig2.setKcal_num_rotate(cursorQuery.getInt(columnIndexOrThrow534));
                    clockConfig2.setKcal_num_rotate_degree(cursorQuery.getInt(columnIndexOrThrow535));
                    clockConfig2.setShow_power_progress(cursorQuery.getInt(columnIndexOrThrow536));
                    clockConfig2.setPower_progress_src(cursorQuery.isNull(columnIndexOrThrow537) ? null : cursorQuery.getString(columnIndexOrThrow537));
                    clockConfig2.setPower_progress_x(cursorQuery.getInt(columnIndexOrThrow538));
                    clockConfig2.setPower_progress_y(cursorQuery.getInt(columnIndexOrThrow539));
                    clockConfig2.setPower_src(cursorQuery.isNull(columnIndexOrThrow540) ? null : cursorQuery.getString(columnIndexOrThrow540));
                    clockConfig2.setPower_src_x(cursorQuery.getInt(columnIndexOrThrow541));
                    clockConfig2.setPower_src_y(cursorQuery.getInt(columnIndexOrThrow542));
                    clockConfig2.setVideo_type(cursorQuery.getInt(columnIndexOrThrow543));
                    clockConfig2.setStep_keep_number_length(cursorQuery.getInt(columnIndexOrThrow544));
                    clockConfig2.setKcal_keep_number_length(cursorQuery.getInt(columnIndexOrThrow545));
                    clockConfig2.setKm_keep_number_length(cursorQuery.getInt(columnIndexOrThrow546));
                    clockConfig2.setStep_num_rotate(cursorQuery.getInt(columnIndexOrThrow547));
                    clockConfig2.setStep_num_rotate_degree(cursorQuery.getInt(columnIndexOrThrow548));
                    clockConfig2.setShow_btn_style(cursorQuery.getInt(columnIndexOrThrow549));
                    clockConfig2.setBtn_style_src(cursorQuery.isNull(columnIndexOrThrow550) ? null : cursorQuery.getString(columnIndexOrThrow550));
                    clockConfig2.setBtn_style_x(cursorQuery.getInt(columnIndexOrThrow551));
                    clockConfig2.setBtn_style_y(cursorQuery.getInt(columnIndexOrThrow552));
                    clockConfig2.setNeed_split_sec(cursorQuery.getInt(columnIndexOrThrow553));
                    clockConfig2.setSplit_sec_src(cursorQuery.isNull(columnIndexOrThrow554) ? null : cursorQuery.getString(columnIndexOrThrow554));
                    clockConfig2.setSplit_sec_x(cursorQuery.getInt(columnIndexOrThrow555));
                    clockConfig2.setSplit_sec_y(cursorQuery.getInt(columnIndexOrThrow556));
                    clockConfig2.setOpen_oxygen_arc_show(cursorQuery.getInt(columnIndexOrThrow557));
                    clockConfig2.setOxygen_arc_type(cursorQuery.getInt(columnIndexOrThrow558));
                    clockConfig2.setOxygen_arc_center_x(cursorQuery.getInt(columnIndexOrThrow559));
                    clockConfig2.setOxygen_arc_center_y(cursorQuery.getInt(columnIndexOrThrow560));
                    clockConfig2.setShow_oxygen_progress(cursorQuery.getInt(columnIndexOrThrow561));
                    clockConfig2.setOxygen_progress_src(cursorQuery.isNull(columnIndexOrThrow562) ? null : cursorQuery.getString(columnIndexOrThrow562));
                    clockConfig2.setOxygen_progress_x(cursorQuery.getInt(columnIndexOrThrow563));
                    clockConfig2.setOxygen_progress_y(cursorQuery.getInt(columnIndexOrThrow564));
                    clockConfig2.setShow_week_donts(cursorQuery.getInt(columnIndexOrThrow565));
                    clockConfig2.setWeek_donts_src(cursorQuery.isNull(columnIndexOrThrow566) ? null : cursorQuery.getString(columnIndexOrThrow566));
                    clockConfig2.setWeek_donts_x(cursorQuery.getInt(columnIndexOrThrow567));
                    clockConfig2.setWeek_donts_y(cursorQuery.getInt(columnIndexOrThrow568));
                    clockConfig2.setShow_btn_flashlight(cursorQuery.getInt(columnIndexOrThrow569));
                    clockConfig2.setFlashlight_src(cursorQuery.isNull(columnIndexOrThrow570) ? null : cursorQuery.getString(columnIndexOrThrow570));
                    clockConfig2.setFlashlight_x(cursorQuery.getInt(columnIndexOrThrow571));
                    clockConfig2.setFlashlight_y(cursorQuery.getInt(columnIndexOrThrow572));
                    clockConfig = clockConfig2;
                } else {
                    clockConfig = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return clockConfig;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
