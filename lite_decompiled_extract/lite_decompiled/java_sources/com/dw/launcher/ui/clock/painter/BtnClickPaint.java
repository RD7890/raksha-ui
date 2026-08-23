package com.dw.launcher.ui.clock.painter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.google.android.mms.pdu.CharacterSets;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BtnClickPaint.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bu\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J;\u0010\u0083\u0001\u001a\u00030\u0084\u00012\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\b2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010\u0088\u0001\u001a\u00030\u0087\u00012\u000f\u0010\u0089\u0001\u001a\n\u0012\u0005\u0012\u00030\u008b\u00010\u008a\u0001H\u0082\bJ \u0010\u008c\u0001\u001a\u00030\u008b\u00012\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001H\u0016J\u0014\u0010\u0091\u0001\u001a\u00030\u008b\u00012\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0002J\u0014\u0010\u0092\u0001\u001a\u00030\u008b\u00012\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0002J\u0014\u0010\u0093\u0001\u001a\u00030\u008b\u00012\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0002J\u0014\u0010\u0094\u0001\u001a\u00030\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001H\u0002J\u001a\u0010\u0097\u0001\u001a\u00030\u0084\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001J!\u0010\u009a\u0001\u001a\u00030\u008b\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000f\u0010\u009b\u0001\u001a\n\u0012\u0005\u0012\u00030\u009d\u00010\u009c\u0001J#\u0010\u009e\u0001\u001a\u00030\u008b\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000f\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u00030 \u00010\u009c\u0001H\u0002J\u001c\u0010¡\u0001\u001a\u00030\u0084\u00012\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010\u0088\u0001\u001a\u00030\u0087\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001a\u0010\"\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001c\u0010%\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\fR\u001a\u0010(\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R\u001c\u0010+\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\n\"\u0004\b-\u0010\fR\u001a\u0010.\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R\u001c\u00101\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\n\"\u0004\b3\u0010\fR\u001a\u00104\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\u001c\u00107\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\n\"\u0004\b9\u0010\fR\u001a\u0010:\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\n\"\u0004\bA\u0010\fR\u001a\u0010B\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0010\"\u0004\bD\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\n\"\u0004\bI\u0010\fR\u001a\u0010J\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0010\"\u0004\bL\u0010\u0012R\u001c\u0010M\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\n\"\u0004\bO\u0010\fR\u001a\u0010P\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0010\"\u0004\bR\u0010\u0012R\u001c\u0010S\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\n\"\u0004\bU\u0010\fR\u001a\u0010V\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0010\"\u0004\bX\u0010\u0012R\u001c\u0010Y\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\n\"\u0004\b[\u0010\fR\u001a\u0010\\\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0010\"\u0004\b^\u0010\u0012R\u001c\u0010_\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\n\"\u0004\ba\u0010\fR\u001a\u0010b\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0010\"\u0004\bd\u0010\u0012R\u001c\u0010e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\n\"\u0004\bg\u0010\fR\u001a\u0010h\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0010\"\u0004\bj\u0010\u0012R\u001c\u0010k\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\n\"\u0004\bm\u0010\fR\u001a\u0010n\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0010\"\u0004\bp\u0010\u0012R\u001c\u0010q\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\n\"\u0004\bs\u0010\fR\u001a\u0010t\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u0010\"\u0004\bv\u0010\u0012R\u001c\u0010w\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\n\"\u0004\by\u0010\fR\u001a\u0010z\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0010\"\u0004\b|\u0010\u0012R\u001c\u0010}\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\n\"\u0004\b\u007f\u0010\fR\u001d\u0010\u0080\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0010\"\u0005\b\u0082\u0001\u0010\u0012¨\u0006¢\u0001"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/BtnClickPaint;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "alipayDrawables", "Landroid/graphics/drawable/Drawable;", "getAlipayDrawables", "()Landroid/graphics/drawable/Drawable;", "setAlipayDrawables", "(Landroid/graphics/drawable/Drawable;)V", "alipayPosition", "Landroid/graphics/Point;", "getAlipayPosition", "()Landroid/graphics/Point;", "setAlipayPosition", "(Landroid/graphics/Point;)V", "bloodPressureDrawables", "getBloodPressureDrawables", "setBloodPressureDrawables", "bloodPressurePosition", "getBloodPressurePosition", "setBloodPressurePosition", "calculatorDrawables", "getCalculatorDrawables", "setCalculatorDrawables", "calculatorPosition", "getCalculatorPosition", "setCalculatorPosition", "calendarDrawables", "getCalendarDrawables", "setCalendarDrawables", "calendarPosition", "getCalendarPosition", "setCalendarPosition", "callDrawables", "getCallDrawables", "setCallDrawables", "callPosition", "getCallPosition", "setCallPosition", "cameraDrawables", "getCameraDrawables", "setCameraDrawables", "cameraPosition", "getCameraPosition", "setCameraPosition", "compassDrawables", "getCompassDrawables", "setCompassDrawables", "compassPosition", "getCompassPosition", "setCompassPosition", "contactDrawables", "getContactDrawables", "setContactDrawables", "contactPosition", "getContactPosition", "setContactPosition", "getContext", "()Landroid/content/Context;", "flashLightDrawables", "getFlashLightDrawables", "setFlashLightDrawables", "flashLightPosition", "getFlashLightPosition", "setFlashLightPosition", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "googlePlayDrawables", "getGooglePlayDrawables", "setGooglePlayDrawables", "googlePlayPosition", "getGooglePlayPosition", "setGooglePlayPosition", "oxygenDrawables", "getOxygenDrawables", "setOxygenDrawables", "oxygenPosition", "getOxygenPosition", "setOxygenPosition", "photoDrawables", "getPhotoDrawables", "setPhotoDrawables", "photoPosition", "getPhotoPosition", "setPhotoPosition", "sleepDrawables", "getSleepDrawables", "setSleepDrawables", "sleepPosition", "getSleepPosition", "setSleepPosition", "smsDrawables", "getSmsDrawables", "setSmsDrawables", "smsPosition", "getSmsPosition", "setSmsPosition", "sportRecordDrawables", "getSportRecordDrawables", "setSportRecordDrawables", "sportRecordPosition", "getSportRecordPosition", "setSportRecordPosition", "stopWatchDrawables", "getStopWatchDrawables", "setStopWatchDrawables", "stopWatchPosition", "getStopWatchPosition", "setStopWatchPosition", "styleDrawables", "getStyleDrawables", "setStyleDrawables", "stylePosition", "getStylePosition", "setStylePosition", "timerDrawables", "getTimerDrawables", "setTimerDrawables", "timerPosition", "getTimerPosition", "setTimerPosition", "wechatDrawables", "getWechatDrawables", "setWechatDrawables", "wechatPosition", "getWechatPosition", "setWechatPosition", "checkAndPerformClick", "", "drawable", "x", "", "y", "onItemClick", "Lkotlin/Function0;", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawAlarm", "drawMusic", "drawSetting", "expandBound", "Landroid/graphics/Rect;", "bounds", "isIntentAvailable", "intent", "Landroid/content/Intent;", "launchActivityIfAvailable", "activities", "", "Landroid/content/ComponentName;", "launchAppIfAvailable", "packageNames", "", "todoClick", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class BtnClickPaint extends ABasePainter {
    private Drawable alipayDrawables;
    private Point alipayPosition;
    private Drawable bloodPressureDrawables;
    private Point bloodPressurePosition;
    private Drawable calculatorDrawables;
    private Point calculatorPosition;
    private Drawable calendarDrawables;
    private Point calendarPosition;
    private Drawable callDrawables;
    private Point callPosition;
    private Drawable cameraDrawables;
    private Point cameraPosition;
    private Drawable compassDrawables;
    private Point compassPosition;
    private Drawable contactDrawables;
    private Point contactPosition;
    private final Context context;
    private Drawable flashLightDrawables;
    private Point flashLightPosition;
    private final ClockConfigFlatter flatter;
    private Drawable googlePlayDrawables;
    private Point googlePlayPosition;
    private Drawable oxygenDrawables;
    private Point oxygenPosition;
    private Drawable photoDrawables;
    private Point photoPosition;
    private Drawable sleepDrawables;
    private Point sleepPosition;
    private Drawable smsDrawables;
    private Point smsPosition;
    private Drawable sportRecordDrawables;
    private Point sportRecordPosition;
    private Drawable stopWatchDrawables;
    private Point stopWatchPosition;
    private Drawable styleDrawables;
    private Point stylePosition;
    private Drawable timerDrawables;
    private Point timerPosition;
    private Drawable wechatDrawables;
    private Point wechatPosition;

    public BtnClickPaint(Context context, ClockConfigFlatter flatter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.googlePlayPosition = new Point();
        this.smsPosition = new Point();
        this.wechatPosition = new Point();
        this.callPosition = new Point();
        this.cameraPosition = new Point();
        this.stopWatchPosition = new Point();
        this.sleepPosition = new Point();
        this.timerPosition = new Point();
        this.sportRecordPosition = new Point();
        this.bloodPressurePosition = new Point();
        this.calculatorPosition = new Point();
        this.alipayPosition = new Point();
        this.oxygenPosition = new Point();
        this.calendarPosition = new Point();
        this.compassPosition = new Point();
        this.photoPosition = new Point();
        this.contactPosition = new Point();
        this.stylePosition = new Point();
        this.flashLightPosition = new Point();
        setSupportScale(flatter.getConfig().supportScale());
        if (flatter.getConfig().getShow_btn_googleplay() == 1) {
            this.googlePlayDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_googleplay_src(), false, 2, null);
            flatter.setPosition(this.googlePlayPosition, flatter.getConfig().getBtn_googleplay_x(), flatter.getConfig().getBtn_googleplay_y());
        }
        if (Intrinsics.areEqual(flatter.getConfig().getShow_btn_sms(), "1")) {
            this.smsDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_sms_src(), false, 2, null);
            flatter.setPosition(this.smsPosition, flatter.getConfig().getBtn_sms_x(), flatter.getConfig().getBtn_sms_y());
        }
        if (Intrinsics.areEqual(flatter.getConfig().getShow_btn_wechat(), "1")) {
            this.wechatDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_wechat_src(), false, 2, null);
            flatter.setPosition(this.wechatPosition, flatter.getConfig().getBtn_wechat_x(), flatter.getConfig().getBtn_wechat_y());
        }
        if (Intrinsics.areEqual(flatter.getConfig().getShow_btn_call(), "1")) {
            this.callDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_call_src(), false, 2, null);
            flatter.setPosition(this.callPosition, flatter.getConfig().getBtn_call_x(), flatter.getConfig().getBtn_call_y());
        }
        if (Intrinsics.areEqual(flatter.getConfig().getShow_btn_camera(), "1")) {
            this.cameraDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_camera_src(), false, 2, null);
            flatter.setPosition(this.cameraPosition, flatter.getConfig().getBtn_camera_x(), flatter.getConfig().getBtn_camera_y());
        }
        if (flatter.getConfig().getShow_btn_stopwatch() == 1) {
            this.stopWatchDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_stopwatch_src(), false, 2, null);
            flatter.setPosition(this.stopWatchPosition, flatter.getConfig().getBtn_stopwatch_x(), flatter.getConfig().getBtn_stopwatch_y());
        }
        if (flatter.getConfig().getShow_btn_sleep() == 1) {
            this.sleepDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_sleep_src(), false, 2, null);
            flatter.setPosition(this.sleepPosition, flatter.getConfig().getBtn_sleep_x(), flatter.getConfig().getBtn_sleep_y());
        }
        if (flatter.getConfig().getShow_btn_timer() == 1) {
            this.timerDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_timer_src(), false, 2, null);
            flatter.setPosition(this.timerPosition, flatter.getConfig().getBtn_timer_x(), flatter.getConfig().getBtn_timer_y());
        }
        if (flatter.getConfig().getShow_btn_sport_record() == 1) {
            this.sportRecordDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_sport_record_src(), false, 2, null);
            flatter.setPosition(this.sportRecordPosition, flatter.getConfig().getBtn_sport_record_x(), flatter.getConfig().getBtn_sport_record_y());
        }
        if (flatter.getConfig().getShow_btn_bloodpressure() == 1) {
            this.bloodPressureDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_bloodpressure_src(), false, 2, null);
            flatter.setPosition(this.bloodPressurePosition, flatter.getConfig().getBtn_bloodpressure_x(), flatter.getConfig().getBtn_bloodpressure_y());
        }
        if (flatter.getConfig().getShow_btn_calculator() == 1) {
            this.calculatorDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_calculator_src(), false, 2, null);
            flatter.setPosition(this.calculatorPosition, flatter.getConfig().getBtn_calculator_x(), flatter.getConfig().getBtn_calculator_y());
        }
        if (flatter.getConfig().getShow_btn_alipay() == 1) {
            this.alipayDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_alipay_src(), false, 2, null);
            flatter.setPosition(this.alipayPosition, flatter.getConfig().getBtn_alipay_x(), flatter.getConfig().getBtn_alipay_y());
        }
        if (flatter.getConfig().getShow_btn_oxygen() == 1) {
            this.oxygenDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_oxygen_src(), false, 2, null);
            flatter.setPosition(this.oxygenPosition, flatter.getConfig().getBtn_oxygen_x(), flatter.getConfig().getBtn_oxygen_y());
        }
        if (flatter.getConfig().getShow_btn_calendar() == 1) {
            this.calendarDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_calendar_src(), false, 2, null);
            flatter.setPosition(this.calendarPosition, flatter.getConfig().getBtn_calendar_x(), flatter.getConfig().getBtn_calendar_y());
        }
        if (flatter.getConfig().getShow_btn_compass() == 1) {
            this.compassDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_compass_src(), false, 2, null);
            flatter.setPosition(this.compassPosition, flatter.getConfig().getBtn_compass_x(), flatter.getConfig().getBtn_compass_y());
        }
        if (flatter.getConfig().getShow_btn_contact() == 1) {
            this.contactDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_contact_src(), false, 2, null);
            flatter.setPosition(this.contactPosition, flatter.getConfig().getBtn_contact_x(), flatter.getConfig().getBtn_contact_y());
        }
        if (flatter.getConfig().getShow_btn_photo() == 1) {
            this.photoDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_photo_src(), false, 2, null);
            flatter.setPosition(this.photoPosition, flatter.getConfig().getBtn_photo_x(), flatter.getConfig().getBtn_photo_y());
        }
        if (flatter.getConfig().getShow_btn_style() == 1) {
            this.styleDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getBtn_style_src(), false, 2, null);
            flatter.setPosition(this.stylePosition, flatter.getConfig().getBtn_style_x(), flatter.getConfig().getBtn_style_y());
        }
        if (flatter.getConfig().getShow_btn_flashlight() == 1) {
            this.flashLightDrawables = ClockConfigFlatter.loadDrawable$default(flatter, flatter.getConfig().getFlashlight_src(), false, 2, null);
            flatter.setPosition(this.flashLightPosition, flatter.getConfig().getFlashlight_x(), flatter.getConfig().getFlashlight_y());
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public final Drawable getGooglePlayDrawables() {
        return this.googlePlayDrawables;
    }

    public final void setGooglePlayDrawables(Drawable drawable) {
        this.googlePlayDrawables = drawable;
    }

    public final Point getGooglePlayPosition() {
        return this.googlePlayPosition;
    }

    public final void setGooglePlayPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.googlePlayPosition = point;
    }

    public final Drawable getSmsDrawables() {
        return this.smsDrawables;
    }

    public final void setSmsDrawables(Drawable drawable) {
        this.smsDrawables = drawable;
    }

    public final Point getSmsPosition() {
        return this.smsPosition;
    }

    public final void setSmsPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.smsPosition = point;
    }

    public final Drawable getWechatDrawables() {
        return this.wechatDrawables;
    }

    public final void setWechatDrawables(Drawable drawable) {
        this.wechatDrawables = drawable;
    }

    public final Point getWechatPosition() {
        return this.wechatPosition;
    }

    public final void setWechatPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.wechatPosition = point;
    }

    public final Drawable getCallDrawables() {
        return this.callDrawables;
    }

    public final void setCallDrawables(Drawable drawable) {
        this.callDrawables = drawable;
    }

    public final Point getCallPosition() {
        return this.callPosition;
    }

    public final void setCallPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.callPosition = point;
    }

    public final Drawable getCameraDrawables() {
        return this.cameraDrawables;
    }

    public final void setCameraDrawables(Drawable drawable) {
        this.cameraDrawables = drawable;
    }

    public final Point getCameraPosition() {
        return this.cameraPosition;
    }

    public final void setCameraPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.cameraPosition = point;
    }

    public final Drawable getStopWatchDrawables() {
        return this.stopWatchDrawables;
    }

    public final void setStopWatchDrawables(Drawable drawable) {
        this.stopWatchDrawables = drawable;
    }

    public final Point getStopWatchPosition() {
        return this.stopWatchPosition;
    }

    public final void setStopWatchPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.stopWatchPosition = point;
    }

    public final Drawable getSleepDrawables() {
        return this.sleepDrawables;
    }

    public final void setSleepDrawables(Drawable drawable) {
        this.sleepDrawables = drawable;
    }

    public final Point getSleepPosition() {
        return this.sleepPosition;
    }

    public final void setSleepPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.sleepPosition = point;
    }

    public final Drawable getTimerDrawables() {
        return this.timerDrawables;
    }

    public final void setTimerDrawables(Drawable drawable) {
        this.timerDrawables = drawable;
    }

    public final Point getTimerPosition() {
        return this.timerPosition;
    }

    public final void setTimerPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.timerPosition = point;
    }

    public final Drawable getSportRecordDrawables() {
        return this.sportRecordDrawables;
    }

    public final void setSportRecordDrawables(Drawable drawable) {
        this.sportRecordDrawables = drawable;
    }

    public final Point getSportRecordPosition() {
        return this.sportRecordPosition;
    }

    public final void setSportRecordPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.sportRecordPosition = point;
    }

    public final Drawable getBloodPressureDrawables() {
        return this.bloodPressureDrawables;
    }

    public final void setBloodPressureDrawables(Drawable drawable) {
        this.bloodPressureDrawables = drawable;
    }

    public final Point getBloodPressurePosition() {
        return this.bloodPressurePosition;
    }

    public final void setBloodPressurePosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.bloodPressurePosition = point;
    }

    public final Drawable getCalculatorDrawables() {
        return this.calculatorDrawables;
    }

    public final void setCalculatorDrawables(Drawable drawable) {
        this.calculatorDrawables = drawable;
    }

    public final Point getCalculatorPosition() {
        return this.calculatorPosition;
    }

    public final void setCalculatorPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.calculatorPosition = point;
    }

    public final Drawable getAlipayDrawables() {
        return this.alipayDrawables;
    }

    public final void setAlipayDrawables(Drawable drawable) {
        this.alipayDrawables = drawable;
    }

    public final Point getAlipayPosition() {
        return this.alipayPosition;
    }

    public final void setAlipayPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.alipayPosition = point;
    }

    public final Drawable getOxygenDrawables() {
        return this.oxygenDrawables;
    }

    public final void setOxygenDrawables(Drawable drawable) {
        this.oxygenDrawables = drawable;
    }

    public final Point getOxygenPosition() {
        return this.oxygenPosition;
    }

    public final void setOxygenPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.oxygenPosition = point;
    }

    public final Drawable getCalendarDrawables() {
        return this.calendarDrawables;
    }

    public final void setCalendarDrawables(Drawable drawable) {
        this.calendarDrawables = drawable;
    }

    public final Point getCalendarPosition() {
        return this.calendarPosition;
    }

    public final void setCalendarPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.calendarPosition = point;
    }

    public final Drawable getCompassDrawables() {
        return this.compassDrawables;
    }

    public final void setCompassDrawables(Drawable drawable) {
        this.compassDrawables = drawable;
    }

    public final Point getCompassPosition() {
        return this.compassPosition;
    }

    public final void setCompassPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.compassPosition = point;
    }

    public final Drawable getPhotoDrawables() {
        return this.photoDrawables;
    }

    public final void setPhotoDrawables(Drawable drawable) {
        this.photoDrawables = drawable;
    }

    public final Point getPhotoPosition() {
        return this.photoPosition;
    }

    public final void setPhotoPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.photoPosition = point;
    }

    public final Drawable getContactDrawables() {
        return this.contactDrawables;
    }

    public final void setContactDrawables(Drawable drawable) {
        this.contactDrawables = drawable;
    }

    public final Point getContactPosition() {
        return this.contactPosition;
    }

    public final void setContactPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.contactPosition = point;
    }

    public final Drawable getStyleDrawables() {
        return this.styleDrawables;
    }

    public final void setStyleDrawables(Drawable drawable) {
        this.styleDrawables = drawable;
    }

    public final Point getStylePosition() {
        return this.stylePosition;
    }

    public final void setStylePosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.stylePosition = point;
    }

    public final Drawable getFlashLightDrawables() {
        return this.flashLightDrawables;
    }

    public final void setFlashLightDrawables(Drawable drawable) {
        this.flashLightDrawables = drawable;
    }

    public final Point getFlashLightPosition() {
        return this.flashLightPosition;
    }

    public final void setFlashLightPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.flashLightPosition = point;
    }

    private final void drawSetting(Canvas canvas) {
        Drawable settingrawable;
        if (!this.flatter.getConfig().showBtnSetting() || (settingrawable = this.flatter.getSettingrawable()) == null) {
            return;
        }
        drawDrawable(canvas, settingrawable, this.flatter.getSettingPosition().x, this.flatter.getSettingPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
    }

    private final void drawAlarm(Canvas canvas) {
        Drawable alarmDrawable;
        if (!this.flatter.getConfig().showAlarm() || (alarmDrawable = this.flatter.getAlarmDrawable()) == null) {
            return;
        }
        drawDrawable(canvas, alarmDrawable, this.flatter.getAlarmPosition().x, this.flatter.getAlarmPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
    }

    private final void drawMusic(Canvas canvas) {
        Drawable musicDrawable;
        if (!this.flatter.getConfig().showMusic() || (musicDrawable = this.flatter.getMusicDrawable()) == null) {
            return;
        }
        drawDrawable(canvas, musicDrawable, this.flatter.getMusicPosition().x, this.flatter.getMusicPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        drawMusic(canvas);
        drawAlarm(canvas);
        drawSetting(canvas);
        Drawable drawable = this.googlePlayDrawables;
        if (drawable != null) {
            drawDrawable(canvas, drawable, this.googlePlayPosition.x, this.googlePlayPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable2 = this.smsDrawables;
        if (drawable2 != null) {
            drawDrawable(canvas, drawable2, this.smsPosition.x, this.smsPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable3 = this.callDrawables;
        if (drawable3 != null) {
            drawDrawable(canvas, drawable3, this.callPosition.x, this.callPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable4 = this.wechatDrawables;
        if (drawable4 != null) {
            drawDrawable(canvas, drawable4, this.wechatPosition.x, this.wechatPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable5 = this.cameraDrawables;
        if (drawable5 != null) {
            drawDrawable(canvas, drawable5, this.cameraPosition.x, this.cameraPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable6 = this.sleepDrawables;
        if (drawable6 != null) {
            drawDrawable(canvas, drawable6, this.sleepPosition.x, this.sleepPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable7 = this.timerDrawables;
        if (drawable7 != null) {
            drawDrawable(canvas, drawable7, this.timerPosition.x, this.timerPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable8 = this.stopWatchDrawables;
        if (drawable8 != null) {
            drawDrawable(canvas, drawable8, this.stopWatchPosition.x, this.stopWatchPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable9 = this.sportRecordDrawables;
        if (drawable9 != null) {
            drawDrawable(canvas, drawable9, this.sportRecordPosition.x, this.sportRecordPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable10 = this.bloodPressureDrawables;
        if (drawable10 != null) {
            drawDrawable(canvas, drawable10, this.bloodPressurePosition.x, this.bloodPressurePosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable11 = this.calculatorDrawables;
        if (drawable11 != null) {
            drawDrawable(canvas, drawable11, this.calculatorPosition.x, this.calculatorPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable12 = this.alipayDrawables;
        if (drawable12 != null) {
            drawDrawable(canvas, drawable12, this.alipayPosition.x, this.alipayPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable weatheaDrawable = this.flatter.getWeatheaDrawable();
        if (weatheaDrawable != null) {
            drawDrawable(canvas, weatheaDrawable, this.flatter.getWeatherPosition().x, this.flatter.getWeatherPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable13 = this.oxygenDrawables;
        if (drawable13 != null) {
            drawDrawable(canvas, drawable13, this.oxygenPosition.x, this.oxygenPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable14 = this.calendarDrawables;
        if (drawable14 != null) {
            drawDrawable(canvas, drawable14, this.calendarPosition.x, this.calendarPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable15 = this.compassDrawables;
        if (drawable15 != null) {
            drawDrawable(canvas, drawable15, this.compassPosition.x, this.compassPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable16 = this.photoDrawables;
        if (drawable16 != null) {
            drawDrawable(canvas, drawable16, this.photoPosition.x, this.photoPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable17 = this.contactDrawables;
        if (drawable17 != null) {
            drawDrawable(canvas, drawable17, this.contactPosition.x, this.contactPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable18 = this.styleDrawables;
        if (drawable18 != null) {
            drawDrawable(canvas, drawable18, this.stylePosition.x, this.stylePosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
        Drawable drawable19 = this.flashLightDrawables;
        if (drawable19 != null) {
            drawDrawable(canvas, drawable19, this.flashLightPosition.x, this.flashLightPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
        }
    }

    public final boolean todoClick(int x, int y) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        Drawable drawable7;
        Drawable weatheaDrawable;
        Drawable drawable8;
        Drawable drawable9;
        Drawable drawable10;
        Drawable drawable11;
        Drawable drawable12;
        Drawable drawable13;
        Drawable drawable14;
        Drawable drawable15;
        Drawable drawable16;
        Drawable drawable17;
        Drawable drawable18;
        Drawable drawable19;
        Drawable settingrawable;
        Drawable musicDrawable;
        Drawable bpmDrawable;
        Drawable stepDrawable;
        Drawable alarmDrawable;
        if (this.flatter.getConfig().showAlarm() && this.flatter.getAlarmDrawable() != null && (alarmDrawable = this.flatter.getAlarmDrawable()) != null) {
            Rect bounds = alarmDrawable.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            if (expandBound(bounds).contains(x, y)) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.android.deskclock", "com.android.deskclock.DeskClock"));
                intent.setFlags(268435456);
                if (isIntentAvailable(this.context, intent)) {
                    this.context.startActivity(intent);
                } else {
                    intent.setComponent(new ComponentName("com.dw.deskclock", "com.dw.deskclock.activity.AlarmClockExActivity"));
                    if (isIntentAvailable(this.context, intent)) {
                        this.context.startActivity(intent);
                    }
                }
                return true;
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().stepEnableClick()) {
            ClockConfigFlatter clockConfigFlatter = this.flatter;
            if ((clockConfigFlatter != null ? clockConfigFlatter.getStepDrawable() : null) != null && (stepDrawable = this.flatter.getStepDrawable()) != null) {
                Rect bounds2 = stepDrawable.getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds2, "getBounds(...)");
                if (expandBound(bounds2).contains(x, y)) {
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName("com.dwiot.iotstepcounter", "com.dwiot.iotstepcounter.activity.StepActivity"));
                    intent2.setFlags(268435456);
                    if (isIntentAvailable(this.context, intent2)) {
                        this.context.startActivity(intent2);
                    } else {
                        Intent intent3 = new Intent();
                        intent3.setComponent(new ComponentName("com.dwiot.dwstep", "com.dwiot.dwstep.activity.StepActivity"));
                        intent3.setFlags(268435456);
                        if (isIntentAvailable(this.context, intent3)) {
                            this.context.startActivity(intent3);
                        }
                    }
                    return true;
                }
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
        }
        if (this.flatter.getConfig().enableHeartClick()) {
            ClockConfigFlatter clockConfigFlatter2 = this.flatter;
            if ((clockConfigFlatter2 != null ? clockConfigFlatter2.getBpmDrawable() : null) != null && (bpmDrawable = this.flatter.getBpmDrawable()) != null) {
                Rect bounds3 = bpmDrawable.getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds3, "getBounds(...)");
                if (expandBound(bounds3).contains(x, y)) {
                    Intent intent4 = new Intent();
                    intent4.setComponent(new ComponentName("com.divo.heartrate", "com.divo.heartrate.MainActivity"));
                    intent4.setFlags(268435456);
                    if (isIntentAvailable(this.context, intent4)) {
                        this.context.startActivity(intent4);
                    } else {
                        Intent intent5 = new Intent();
                        intent5.setComponent(new ComponentName("com.dw.heartrate", "com.dw.heartrate.MainActivity"));
                        intent5.setFlags(268435456);
                        if (isIntentAvailable(this.context, intent5)) {
                            this.context.startActivity(intent5);
                        }
                    }
                    return true;
                }
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
            }
        }
        if (this.flatter.getConfig().showMusic() && this.flatter.getMusicDrawable() != null && (musicDrawable = this.flatter.getMusicDrawable()) != null) {
            Rect bounds4 = musicDrawable.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds4, "getBounds(...)");
            if (expandBound(bounds4).contains(x, y)) {
                Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage("com.dw.music");
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage);
                } else {
                    Intent intent6 = new Intent("android.intent.action.MUSIC_PLAYER");
                    intent6.setFlags(268435456);
                    if (isIntentAvailable(this.context, intent6)) {
                        this.context.startActivity(intent6);
                    }
                }
                return true;
            }
            Unit unit7 = Unit.INSTANCE;
            Unit unit8 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().showBtnSetting() && this.flatter.getSettingrawable() != null && (settingrawable = this.flatter.getSettingrawable()) != null) {
            Rect bounds5 = settingrawable.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds5, "getBounds(...)");
            if (expandBound(bounds5).contains(x, y)) {
                launchActivityIfAvailable(this.context, CollectionsKt.listOf((Object[]) new ComponentName[]{new ComponentName("com.dw.setting", "com.dw.setting.activities.Settings"), new ComponentName("com.divo.settings", "com.divo.settings.MainActivity"), new ComponentName("com.android.settings", "com.android.settings.Settings")}));
                return true;
            }
            Unit unit9 = Unit.INSTANCE;
            Unit unit10 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getShow_btn_googleplay() == 1 && (drawable19 = this.googlePlayDrawables) != null && drawable19 != null) {
            Rect bounds6 = drawable19.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds6, "getBounds(...)");
            if (expandBound(bounds6).contains(x, y)) {
                Intent launchIntentForPackage2 = this.context.getPackageManager().getLaunchIntentForPackage("com.android.vending");
                if (launchIntentForPackage2 != null) {
                    launchIntentForPackage2.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage2);
                }
                return true;
            }
            Unit unit11 = Unit.INSTANCE;
            Unit unit12 = Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(this.flatter.getConfig().getShow_btn_sms(), "1") && (drawable18 = this.smsDrawables) != null && drawable18 != null) {
            Rect bounds7 = drawable18.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds7, "getBounds(...)");
            if (expandBound(bounds7).contains(x, y)) {
                launchActivityIfAvailable(this.context, CollectionsKt.listOf((Object[]) new ComponentName[]{new ComponentName("com.dw.contacts", "com.dw.contacts.MainActivity"), new ComponentName("com.watch.iotnet", "com.watch.contact.activity.MainActivity"), new ComponentName("com.android.contacts", "com.android.contacts.activities.PeopleActivity")}));
                return true;
            }
            Unit unit13 = Unit.INSTANCE;
            Unit unit14 = Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(this.flatter.getConfig().getShow_btn_call(), "1") && (drawable17 = this.callDrawables) != null && drawable17 != null) {
            Rect bounds8 = drawable17.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds8, "getBounds(...)");
            if (expandBound(bounds8).contains(x, y)) {
                launchAppIfAvailable(this.context, CollectionsKt.listOf((Object[]) new String[]{"com.divo.phone", "com.dw.dial"}));
                return true;
            }
            Unit unit15 = Unit.INSTANCE;
            Unit unit16 = Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(this.flatter.getConfig().getShow_btn_wechat(), "1") && (drawable16 = this.wechatDrawables) != null && drawable16 != null) {
            Rect bounds9 = drawable16.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds9, "getBounds(...)");
            if (expandBound(bounds9).contains(x, y)) {
                Intent launchIntentForPackage3 = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.wechatkids");
                if (launchIntentForPackage3 != null) {
                    launchIntentForPackage3.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage3);
                } else {
                    Intent launchIntentForPackage4 = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
                    if (launchIntentForPackage4 != null) {
                        launchIntentForPackage4.setFlags(268435456);
                        this.context.startActivity(launchIntentForPackage4);
                    }
                }
                return true;
            }
            Unit unit17 = Unit.INSTANCE;
            Unit unit18 = Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(this.flatter.getConfig().getShow_btn_camera(), "1") && (drawable15 = this.cameraDrawables) != null && drawable15 != null) {
            Rect bounds10 = drawable15.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds10, "getBounds(...)");
            if (expandBound(bounds10).contains(x, y)) {
                Intent launchIntentForPackage5 = this.context.getPackageManager().getLaunchIntentForPackage("com.android.camera2");
                if (launchIntentForPackage5 != null) {
                    launchIntentForPackage5.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage5);
                }
                return true;
            }
            Unit unit19 = Unit.INSTANCE;
            Unit unit20 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getShow_btn_sport_record() == 1 && (drawable14 = this.sportRecordDrawables) != null && drawable14 != null) {
            Rect bounds11 = drawable14.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds11, "getBounds(...)");
            if (expandBound(bounds11).contains(x, y)) {
                Intent launchIntentForPackage6 = this.context.getPackageManager().getLaunchIntentForPackage("com.divoiot.sport");
                if (launchIntentForPackage6 != null) {
                    launchIntentForPackage6.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage6);
                }
                return true;
            }
            Unit unit21 = Unit.INSTANCE;
            Unit unit22 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getShow_btn_sleep() == 1 && (drawable13 = this.sleepDrawables) != null && drawable13 != null) {
            Rect bounds12 = drawable13.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds12, "getBounds(...)");
            if (expandBound(bounds12).contains(x, y)) {
                Intent launchIntentForPackage7 = this.context.getPackageManager().getLaunchIntentForPackage("com.dw.sleep");
                if (launchIntentForPackage7 != null) {
                    launchIntentForPackage7.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage7);
                }
                return true;
            }
            Unit unit23 = Unit.INSTANCE;
            Unit unit24 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getShow_btn_stopwatch() == 1 && (drawable12 = this.stopWatchDrawables) != null && drawable12 != null) {
            Rect bounds13 = drawable12.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds13, "getBounds(...)");
            if (expandBound(bounds13).contains(x, y)) {
                Intent launchIntentForPackage8 = this.context.getPackageManager().getLaunchIntentForPackage("com.dw.stopwatch");
                if (launchIntentForPackage8 != null) {
                    launchIntentForPackage8.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage8);
                }
                return true;
            }
            Unit unit25 = Unit.INSTANCE;
            Unit unit26 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getShow_btn_timer() == 1 && (drawable11 = this.timerDrawables) != null && drawable11 != null) {
            Rect bounds14 = drawable11.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds14, "getBounds(...)");
            if (expandBound(bounds14).contains(x, y)) {
                Intent launchIntentForPackage9 = this.context.getPackageManager().getLaunchIntentForPackage("com.dw.timer");
                if (launchIntentForPackage9 != null) {
                    launchIntentForPackage9.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage9);
                }
                return true;
            }
            Unit unit27 = Unit.INSTANCE;
            Unit unit28 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getShow_btn_bloodpressure() == 1 && (drawable10 = this.bloodPressureDrawables) != null && drawable10 != null) {
            Rect bounds15 = drawable10.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds15, "getBounds(...)");
            if (expandBound(bounds15).contains(x, y)) {
                Intent launchIntentForPackage10 = this.context.getPackageManager().getLaunchIntentForPackage("com.dwiot.bloodpressure");
                if (launchIntentForPackage10 != null) {
                    launchIntentForPackage10.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage10);
                }
                return true;
            }
            Unit unit29 = Unit.INSTANCE;
            Unit unit30 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getShow_btn_calculator() == 1 && (drawable9 = this.calculatorDrawables) != null && drawable9 != null) {
            Rect bounds16 = drawable9.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds16, "getBounds(...)");
            if (expandBound(bounds16).contains(x, y)) {
                Intent launchIntentForPackage11 = this.context.getPackageManager().getLaunchIntentForPackage("com.dw.calculator");
                if (launchIntentForPackage11 != null) {
                    launchIntentForPackage11.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage11);
                }
                return true;
            }
            Unit unit31 = Unit.INSTANCE;
            Unit unit32 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getShow_btn_alipay() == 1 && (drawable8 = this.alipayDrawables) != null && drawable8 != null) {
            Rect bounds17 = drawable8.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds17, "getBounds(...)");
            if (expandBound(bounds17).contains(x, y)) {
                Intent launchIntentForPackage12 = this.context.getPackageManager().getLaunchIntentForPackage("com.eg.android.AlipayGphone");
                if (launchIntentForPackage12 != null) {
                    launchIntentForPackage12.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage12);
                }
                return true;
            }
            Unit unit33 = Unit.INSTANCE;
            Unit unit34 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().showBtnWeather() && this.flatter.getWeatheaDrawable() != null && (weatheaDrawable = this.flatter.getWeatheaDrawable()) != null) {
            Rect bounds18 = weatheaDrawable.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds18, "getBounds(...)");
            if (expandBound(bounds18).contains(x, y)) {
                Intent launchIntentForPackage13 = this.context.getPackageManager().getLaunchIntentForPackage("com.diwo.weather");
                if (launchIntentForPackage13 != null) {
                    launchIntentForPackage13.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage13);
                }
                return true;
            }
            Unit unit35 = Unit.INSTANCE;
            Unit unit36 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getShow_btn_oxygen() == 1 && (drawable7 = this.oxygenDrawables) != null && drawable7 != null) {
            Rect bounds19 = drawable7.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds19, "getBounds(...)");
            if (expandBound(bounds19).contains(x, y)) {
                Intent launchIntentForPackage14 = this.context.getPackageManager().getLaunchIntentForPackage("com.dw.oxygen");
                if (launchIntentForPackage14 != null) {
                    launchIntentForPackage14.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage14);
                }
                return true;
            }
            Unit unit37 = Unit.INSTANCE;
            Unit unit38 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getShow_btn_calendar() == 1 && (drawable6 = this.calendarDrawables) != null && drawable6 != null) {
            Rect bounds20 = drawable6.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds20, "getBounds(...)");
            if (expandBound(bounds20).contains(x, y)) {
                Intent launchIntentForPackage15 = this.context.getPackageManager().getLaunchIntentForPackage("com.dw.calendar");
                if (launchIntentForPackage15 != null) {
                    launchIntentForPackage15.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage15);
                }
                return true;
            }
            Unit unit39 = Unit.INSTANCE;
            Unit unit40 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getShow_btn_compass() == 1 && (drawable5 = this.compassDrawables) != null && drawable5 != null) {
            Rect bounds21 = drawable5.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds21, "getBounds(...)");
            if (expandBound(bounds21).contains(x, y)) {
                Intent launchIntentForPackage16 = this.context.getPackageManager().getLaunchIntentForPackage("com.dwiot.compass");
                if (launchIntentForPackage16 != null) {
                    launchIntentForPackage16.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage16);
                }
                return true;
            }
            Unit unit41 = Unit.INSTANCE;
            Unit unit42 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getShow_btn_contact() == 1 && (drawable4 = this.contactDrawables) != null && drawable4 != null) {
            Rect bounds22 = drawable4.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds22, "getBounds(...)");
            if (expandBound(bounds22).contains(x, y)) {
                List listListOf = CollectionsKt.listOf((Object[]) new ComponentName[]{new ComponentName("com.dw.contacts", "com.dw.contacts.MainActivity"), new ComponentName("com.watch.iotnet", "com.watch.contact.activity.MainActivity"), new ComponentName("com.android.contacts", "com.android.contacts.activities.PeopleActivity")});
                Intent intent7 = new Intent();
                intent7.setFlags(268435456);
                Iterator it = listListOf.iterator();
                while (it.hasNext()) {
                    intent7.setComponent((ComponentName) it.next());
                    if (isIntentAvailable(this.context, intent7)) {
                        this.context.startActivity(intent7);
                        break;
                    }
                }
                return true;
            }
            Unit unit43 = Unit.INSTANCE;
            Unit unit44 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getShow_btn_photo() == 1 && (drawable3 = this.photoDrawables) != null && drawable3 != null) {
            Rect bounds23 = drawable3.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds23, "getBounds(...)");
            if (expandBound(bounds23).contains(x, y)) {
                Intent intent8 = new Intent();
                intent8.setComponent(new ComponentName("com.android.gallery3d", "com.android.gallery3d.app.GalleryActivity"));
                intent8.setFlags(268435456);
                if (isIntentAvailable(this.context, intent8)) {
                    this.context.startActivity(intent8);
                }
                return true;
            }
            Unit unit45 = Unit.INSTANCE;
            Unit unit46 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getShow_btn_style() == 1 && (drawable2 = this.styleDrawables) != null && drawable2 != null) {
            Rect bounds24 = drawable2.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds24, "getBounds(...)");
            if (expandBound(bounds24).contains(x, y)) {
                Intent intent9 = new Intent();
                intent9.setComponent(new ComponentName("com.dw.launcher", "com.dw.launcher.ui.activity.PickDashboardActivity"));
                intent9.setFlags(268435456);
                if (isIntentAvailable(this.context, intent9)) {
                    this.context.startActivity(intent9);
                }
                return true;
            }
            Unit unit47 = Unit.INSTANCE;
            Unit unit48 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getShow_btn_flashlight() == 1 && (drawable = this.flashLightDrawables) != null && drawable != null) {
            Rect bounds25 = drawable.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds25, "getBounds(...)");
            if (expandBound(bounds25).contains(x, y)) {
                Intent launchIntentForPackage17 = this.context.getPackageManager().getLaunchIntentForPackage("com.divoiot.appletorch");
                if (launchIntentForPackage17 != null) {
                    launchIntentForPackage17.setFlags(268435456);
                    this.context.startActivity(launchIntentForPackage17);
                }
                return true;
            }
            Unit unit49 = Unit.INSTANCE;
            Unit unit50 = Unit.INSTANCE;
        }
        return false;
    }

    private final boolean checkAndPerformClick(Drawable drawable, int x, int y, Function0<Unit> onItemClick) {
        if (drawable == null) {
            return false;
        }
        Rect bounds = drawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        if (!expandBound(bounds).contains(x, y)) {
            return false;
        }
        onItemClick.invoke();
        return true;
    }

    private final Rect expandBound(Rect bounds) {
        return new Rect(bounds.left - 5, bounds.top - 5, bounds.right + 5, bounds.bottom + 5);
    }

    public final boolean isIntentAvailable(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        return !listQueryIntentActivities.isEmpty();
    }

    private final void launchAppIfAvailable(Context context, List<String> packageNames) {
        PackageManager packageManager = context.getPackageManager();
        Iterator<T> it = packageNames.iterator();
        while (it.hasNext()) {
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage((String) it.next());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
                return;
            }
        }
    }

    public final void launchActivityIfAvailable(Context context, List<ComponentName> activities) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activities, "activities");
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        intent.setFlags(268435456);
        for (ComponentName componentName : activities) {
            String className = componentName.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
            if (className.length() > 0) {
                intent.setComponent(componentName);
                if (isIntentAvailable(context, intent)) {
                    context.startActivity(intent);
                    return;
                }
            } else {
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(componentName.getPackageName());
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.setFlags(268435456);
                    context.startActivity(launchIntentForPackage);
                    return;
                }
            }
        }
    }
}
