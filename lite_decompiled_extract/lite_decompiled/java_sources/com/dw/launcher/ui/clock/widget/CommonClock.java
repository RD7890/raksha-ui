package com.dw.launcher.ui.clock.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.airbnb.lottie.LottieDrawable;
import com.dw.launcher.data.component.BatteryComponent;
import com.dw.launcher.data.component.DateComponent;
import com.dw.launcher.data.entity.Clock;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.data.entity.WeatherData;
import com.dw.launcher.data.listener.OnWatchItemClickListener;
import com.dw.launcher.manager.WeatherManager;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.dw.launcher.ui.clock.painter.ActionPainter;
import com.dw.launcher.ui.clock.painter.BatteryPainter;
import com.dw.launcher.ui.clock.painter.BgPainter;
import com.dw.launcher.ui.clock.painter.BtnClickPaint;
import com.dw.launcher.ui.clock.painter.CaloriesPainter;
import com.dw.launcher.ui.clock.painter.CommonCompassPainter;
import com.dw.launcher.ui.clock.painter.ConnectPainter;
import com.dw.launcher.ui.clock.painter.DatePainter;
import com.dw.launcher.ui.clock.painter.HeartPainter;
import com.dw.launcher.ui.clock.painter.IBasePainter;
import com.dw.launcher.ui.clock.painter.KmPainter;
import com.dw.launcher.ui.clock.painter.LottiePainter;
import com.dw.launcher.ui.clock.painter.OxygenPainter;
import com.dw.launcher.ui.clock.painter.SignalPainter;
import com.dw.launcher.ui.clock.painter.SpecialCompassPainter;
import com.dw.launcher.ui.clock.painter.SpecialDrawPainter;
import com.dw.launcher.ui.clock.painter.StepPainter;
import com.dw.launcher.ui.clock.painter.TimerPainter;
import com.dw.launcher.ui.clock.painter.WeatherPainter;
import com.google.android.mms.pdu.CharacterSets;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import timber.log.Timber;

/* JADX INFO: compiled from: CommonClock.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u00012\u00020\u0002:\u0006\u0089\u0001\u008a\u0001\u008b\u0001B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB+\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ1\u0010J\u001a\u00020!2\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PH\u0082\bJ\u001c\u0010R\u001a\u00020Q2\b\b\u0002\u0010S\u001a\u00020!2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010LJ\u000e\u0010U\u001a\u00020Q2\u0006\u0010V\u001a\u00020AJ \u0010W\u001a\u00020Q2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0002J\u0010\u0010^\u001a\u00020Q2\u0006\u0010X\u001a\u00020YH\u0002J\u0018\u0010_\u001a\u00020Q2\u0006\u0010X\u001a\u00020Y2\u0006\u0010V\u001a\u00020AH\u0002J8\u0010`\u001a\u00020Q2\u0006\u0010X\u001a\u00020Y2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\u0006\u0010a\u001a\u00020A2\u0006\u0010b\u001a\u00020AH\u0002J \u0010c\u001a\u00020Q2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0002J \u0010d\u001a\u00020Q2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0002J \u0010e\u001a\u00020Q2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0002J\u0010\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020gH\u0002J\b\u0010i\u001a\u0004\u0018\u000102J\b\u0010j\u001a\u00020QH\u0002J\u0010\u0010k\u001a\u00020Q2\u0006\u0010K\u001a\u00020LH\u0016J\b\u0010l\u001a\u00020QH\u0002J\u0006\u0010m\u001a\u00020!J\b\u0010n\u001a\u00020QH\u0014J\b\u0010o\u001a\u00020QH\u0014J\u0010\u0010p\u001a\u00020Q2\u0006\u0010X\u001a\u00020YH\u0014J \u0010q\u001a\u00020Q2\u0006\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\nH\u0016J\u0010\u0010u\u001a\u00020!2\u0006\u0010v\u001a\u00020wH\u0016J\u0010\u0010x\u001a\u00020Q2\u0006\u0010X\u001a\u00020YH\u0002J\u000e\u0010y\u001a\u00020Q2\u0006\u0010z\u001a\u00020>J\u000e\u0010{\u001a\u00020Q2\u0006\u00109\u001a\u00020:J\u000e\u0010|\u001a\u00020Q2\u0006\u0010Z\u001a\u000202J\u000e\u0010}\u001a\u00020Q2\u0006\u0010Z\u001a\u000202J\u000e\u0010~\u001a\u00020Q2\u0006\u0010\u007f\u001a\u00020<J\t\u0010\u0080\u0001\u001a\u00020QH\u0002J\t\u0010\u0081\u0001\u001a\u00020QH\u0002J\t\u0010\u0082\u0001\u001a\u00020QH\u0002J\u0010\u0010\u0083\u0001\u001a\u00020Q2\u0007\u0010\u0084\u0001\u001a\u00020!J\u0010\u0010\u0085\u0001\u001a\u00020Q2\u0007\u0010\u0084\u0001\u001a\u00020!J\u0007\u0010\u0086\u0001\u001a\u00020QJ\u0012\u0010\u0087\u0001\u001a\u00020Q2\u0007\u0010\u0088\u0001\u001a\u00020!H\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u000e\u0010(\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020AX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008c\u0001"}, d2 = {"Lcom/dw/launcher/ui/clock/widget/CommonClock;", "Landroid/view/View;", "Lcom/dw/launcher/data/component/DateComponent$OnTimeChangedListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "actionPainter", "Lcom/dw/launcher/ui/clock/painter/IBasePainter;", "batteryPainter", "bgPainter", "btnClickPaint", "caloriesPainter", "commonCompassPainter", "connectPainter", "datePainter", "downX", "getDownX", "()I", "setDownX", "(I)V", "downY", "getDownY", "setDownY", "heartPainter", "is24TimeClock", "", "isClick", "()Z", "setClick", "(Z)V", "isCurrentForent", "setCurrentForent", "isLoadResFinish", "is_support_compass_function", "is_support_heart_function", "kmPainter", "loadResTimeStamp", "", "mBatteryComponent", "Lcom/dw/launcher/data/component/BatteryComponent;", "mChargeIndex", "mClock", "Lcom/dw/launcher/data/entity/Clock;", "mDateComponent", "Lcom/dw/launcher/data/component/DateComponent;", "mLoaded", "mLottiePaint", "Lcom/dw/launcher/ui/clock/painter/LottiePainter;", "mNeedLoadConfig", "onGestureListener", "Lcom/dw/launcher/ui/clock/widget/CommonClock$OnGestureListener;", "onVideoClickListener", "Lcom/dw/launcher/ui/clock/widget/CommonClock$OnVideoClickListener;", "onWatchItemClickListener", "Lcom/dw/launcher/data/listener/OnWatchItemClickListener;", "oxygenPainter", "rotationAngle", "", "scale", "signalPainter", "specialCompassPainter", "specialDrawPainter", "stepPainter", "timerPainter", "Lcom/dw/launcher/ui/clock/painter/TimerPainter;", "weatherPainter", "checkAndPerformClick", "drawable", "Landroid/graphics/drawable/Drawable;", "x", "y", "onItemClick", "Lkotlin/Function0;", "", "clickChangeBg", "isDynamic", "backgroundDrawable", "compassRotation", "rotation", "drawAlarm", "canvas", "Landroid/graphics/Canvas;", "config", "Lcom/dw/launcher/data/entity/ClockConfig;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "drawBackground", "drawCompass", "drawDrawable", "scaleX", "scaleY", "drawMusic", "drawSetting", "drawWeather", "expandBound", "Landroid/graphics/Rect;", "bounds", "getConfig", "initPainter", "invalidateDrawable", "load", "needListenCompassPort", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "onTimeChanged", "hour", "minute", "seconds", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "realDraw", "registerClockItemClickListener", "onClockItemClickListener", "registerOnGestureListener", "setConfig", "setForceConfig", "setOnVideoClickListener", "listener", "setupGestureDetector", "startAnimation", "stopAnimation", "supportCompassFunction", "support", "supportHeartFunction", "updateTimeFormat", "visibleToFront", "isVisible", "GestureListener", "OnGestureListener", "OnVideoClickListener", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class CommonClock extends View implements DateComponent.OnTimeChangedListener {
    private IBasePainter actionPainter;
    private IBasePainter batteryPainter;
    private IBasePainter bgPainter;
    private IBasePainter btnClickPaint;
    private IBasePainter caloriesPainter;
    private IBasePainter commonCompassPainter;
    private IBasePainter connectPainter;
    private IBasePainter datePainter;
    private int downX;
    private int downY;
    private IBasePainter heartPainter;
    private boolean is24TimeClock;
    private boolean isClick;
    private boolean isCurrentForent;
    private boolean isLoadResFinish;
    private boolean is_support_compass_function;
    private boolean is_support_heart_function;
    private IBasePainter kmPainter;
    private long loadResTimeStamp;
    private BatteryComponent mBatteryComponent;
    private int mChargeIndex;
    private Clock mClock;
    private DateComponent mDateComponent;
    private boolean mLoaded;
    private LottiePainter mLottiePaint;
    private boolean mNeedLoadConfig;
    private OnGestureListener onGestureListener;
    private OnVideoClickListener onVideoClickListener;
    private OnWatchItemClickListener onWatchItemClickListener;
    private IBasePainter oxygenPainter;
    private float rotationAngle;
    private final float scale;
    private IBasePainter signalPainter;
    private IBasePainter specialCompassPainter;
    private IBasePainter specialDrawPainter;
    private IBasePainter stepPainter;
    private TimerPainter timerPainter;
    private IBasePainter weatherPainter;

    /* JADX INFO: compiled from: CommonClock.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J,\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/dw/launcher/ui/clock/widget/CommonClock$OnGestureListener;", "", "onDown", "", "event", "Landroid/view/MotionEvent;", "onLongPress", "", "onScroll", "var1", "var2", "distanceX", "", "distanceY", "onSingleTapUp", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public interface OnGestureListener {
        boolean onDown(MotionEvent event);

        void onLongPress(MotionEvent event);

        boolean onScroll(MotionEvent var1, MotionEvent var2, float distanceX, float distanceY);

        boolean onSingleTapUp(MotionEvent event);
    }

    /* JADX INFO: compiled from: CommonClock.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/dw/launcher/ui/clock/widget/CommonClock$OnVideoClickListener;", "", "onVideoClick", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public interface OnVideoClickListener {
        void onVideoClick();
    }

    private final void setupGestureDetector() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startAnimation() {
    }

    private final void stopAnimation() {
    }

    /* JADX INFO: renamed from: isCurrentForent, reason: from getter */
    public final boolean getIsCurrentForent() {
        return this.isCurrentForent;
    }

    public final void setCurrentForent(boolean z) {
        this.isCurrentForent = z;
    }

    public CommonClock(Context context) {
        super(context);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mDateComponent = new DateComponent(context2, this);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        this.mBatteryComponent = new BatteryComponent(context3);
        this.mNeedLoadConfig = true;
        this.scale = 1.0f;
        this.isCurrentForent = true;
        this.is_support_heart_function = true;
    }

    public CommonClock(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mDateComponent = new DateComponent(context2, this);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        this.mBatteryComponent = new BatteryComponent(context3);
        this.mNeedLoadConfig = true;
        this.scale = 1.0f;
        this.isCurrentForent = true;
        this.is_support_heart_function = true;
    }

    public CommonClock(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mDateComponent = new DateComponent(context2, this);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        this.mBatteryComponent = new BatteryComponent(context3);
        this.mNeedLoadConfig = true;
        this.scale = 1.0f;
        this.isCurrentForent = true;
        this.is_support_heart_function = true;
    }

    public CommonClock(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mDateComponent = new DateComponent(context2, this);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        this.mBatteryComponent = new BatteryComponent(context3);
        this.mNeedLoadConfig = true;
        this.scale = 1.0f;
        this.isCurrentForent = true;
        this.is_support_heart_function = true;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        Timber.INSTANCE.i("---onAttachedToWindow", new Object[0]);
        super.onAttachedToWindow();
        this.mDateComponent.register();
        this.mBatteryComponent.register();
        load();
        startAnimation();
        setupGestureDetector();
        this.is24TimeClock = DateFormat.is24HourFormat(getContext());
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        Timber.INSTANCE.i("---onDetachedFromWindow", new Object[0]);
        super.onDetachedFromWindow();
        this.mDateComponent.unregister();
        this.mBatteryComponent.unregister();
        this.mLoaded = false;
        this.onGestureListener = null;
    }

    public final void setConfig(Clock config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Timber.INSTANCE.i("---setConfig: " + config.getConfig().getId() + " isAttachedToWindow = " + isAttachedToWindow(), new Object[0]);
        this.mClock = config;
        if (isAttachedToWindow()) {
            load();
        }
    }

    /* JADX INFO: renamed from: getConfig, reason: from getter */
    public final Clock getMClock() {
        return this.mClock;
    }

    public final void setForceConfig(Clock config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Timber.INSTANCE.i("---setConfig: " + config.getConfig().getId() + "   next: " + config.getConfig().getNext_id(), new Object[0]);
        this.mClock = config;
        if (config != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new CommonClock$setForceConfig$1$1(this, config, null), 3, null);
        }
    }

    public void onTimeChanged(int hour, int minute, int seconds) {
        invalidate();
    }

    private final void drawBackground(Canvas canvas) {
        IBasePainter iBasePainter = this.bgPainter;
        if (iBasePainter != null) {
            iBasePainter.draw(canvas, null);
        }
    }

    private final void load() {
        if (this.mLoaded) {
            return;
        }
        Timber.INSTANCE.i("---load, this: " + this + ", config: " + this.mClock, new Object[0]);
        Clock clock = this.mClock;
        if (clock != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new CommonClock$load$1$1(this, clock, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:191:0x0320  */
    /* JADX WARN: Code duplicated, block: B:193:0x0327  */
    public final void initPainter() {
        SpecialCompassPainter specialCompassPainter;
        ClockConfigFlatter flatter;
        ClockConfig config;
        LottiePainter lottiePainter;
        ClockConfigFlatter flatter2;
        LottieDrawable lottieBackground;
        SpecialCompassPainter specialCompassPainter2;
        ClockConfigFlatter flatter3;
        DatePainter datePainter;
        ClockConfigFlatter flatter4;
        this.isLoadResFinish = false;
        Clock clock = this.mClock;
        if (clock == null || (flatter4 = clock.getFlatter()) == null || flatter4.getCompassConfig() == null) {
            specialCompassPainter = null;
        } else {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Clock clock2 = this.mClock;
            ClockConfigFlatter flatter5 = clock2 != null ? clock2.getFlatter() : null;
            Intrinsics.checkNotNull(flatter5);
            specialCompassPainter = new SpecialCompassPainter(context, flatter5);
        }
        this.specialCompassPainter = specialCompassPainter;
        Clock clock3 = this.mClock;
        if (clock3 == null || (flatter = clock3.getFlatter()) == null || (config = flatter.getConfig()) == null) {
            return;
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        Clock clock4 = this.mClock;
        ClockConfigFlatter flatter6 = clock4 != null ? clock4.getFlatter() : null;
        Intrinsics.checkNotNull(flatter6);
        this.bgPainter = new BgPainter(context2, flatter6);
        TimerPainter timerPainter = this.timerPainter;
        if (timerPainter == null) {
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            Clock clock5 = this.mClock;
            ClockConfigFlatter flatter7 = clock5 != null ? clock5.getFlatter() : null;
            Intrinsics.checkNotNull(flatter7);
            timerPainter = new TimerPainter(context3, flatter7);
        }
        this.timerPainter = timerPainter;
        DatePainter datePainter2 = this.datePainter;
        if (datePainter2 == null) {
            Clock clock6 = this.mClock;
            if (clock6 == null || clock6.getFlatter() == null) {
                datePainter = null;
            } else {
                Context context4 = getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                Clock clock7 = this.mClock;
                Intrinsics.checkNotNull(clock7);
                ClockConfigFlatter flatter8 = clock7.getFlatter();
                Intrinsics.checkNotNull(flatter8);
                datePainter = new DatePainter(context4, flatter8);
            }
            datePainter2 = datePainter;
        }
        this.datePainter = datePainter2;
        if (config.showBattery() || config.showBatteryNum()) {
            BatteryPainter batteryPainter = this.batteryPainter;
            if (batteryPainter == null) {
                Context context5 = getContext();
                Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
                BatteryComponent batteryComponent = this.mBatteryComponent;
                Clock clock8 = this.mClock;
                ClockConfigFlatter flatter9 = clock8 != null ? clock8.getFlatter() : null;
                Intrinsics.checkNotNull(flatter9);
                batteryPainter = new BatteryPainter(context5, batteryComponent, flatter9);
            }
            this.batteryPainter = batteryPainter;
        }
        if (config.showHeart()) {
            HeartPainter heartPainter = this.heartPainter;
            if (heartPainter == null) {
                Context context6 = getContext();
                Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
                Clock clock9 = this.mClock;
                ClockConfigFlatter flatter10 = clock9 != null ? clock9.getFlatter() : null;
                Intrinsics.checkNotNull(flatter10);
                heartPainter = new HeartPainter(context6, flatter10);
            }
            this.heartPainter = heartPainter;
        }
        if (config.showCalories()) {
            CaloriesPainter caloriesPainter = this.caloriesPainter;
            if (caloriesPainter == null) {
                Context context7 = getContext();
                Intrinsics.checkNotNullExpressionValue(context7, "getContext(...)");
                Clock clock10 = this.mClock;
                ClockConfigFlatter flatter11 = clock10 != null ? clock10.getFlatter() : null;
                Intrinsics.checkNotNull(flatter11);
                caloriesPainter = new CaloriesPainter(context7, flatter11);
            }
            this.caloriesPainter = caloriesPainter;
        }
        if (config.showStep()) {
            StepPainter stepPainter = this.stepPainter;
            if (stepPainter == null) {
                Context context8 = getContext();
                Intrinsics.checkNotNullExpressionValue(context8, "getContext(...)");
                Clock clock11 = this.mClock;
                ClockConfigFlatter flatter12 = clock11 != null ? clock11.getFlatter() : null;
                Intrinsics.checkNotNull(flatter12);
                stepPainter = new StepPainter(context8, flatter12);
            }
            this.stepPainter = stepPainter;
        }
        if (Intrinsics.areEqual(config.getShow_km(), "1")) {
            KmPainter kmPainter = this.kmPainter;
            if (kmPainter == null) {
                Context context9 = getContext();
                Intrinsics.checkNotNullExpressionValue(context9, "getContext(...)");
                Clock clock12 = this.mClock;
                ClockConfigFlatter flatter13 = clock12 != null ? clock12.getFlatter() : null;
                Intrinsics.checkNotNull(flatter13);
                kmPainter = new KmPainter(context9, flatter13);
            }
            this.kmPainter = kmPainter;
        }
        if (config.showSignal()) {
            SignalPainter signalPainter = this.signalPainter;
            if (signalPainter == null) {
                Context context10 = getContext();
                Intrinsics.checkNotNullExpressionValue(context10, "getContext(...)");
                Clock clock13 = this.mClock;
                ClockConfigFlatter flatter14 = clock13 != null ? clock13.getFlatter() : null;
                Intrinsics.checkNotNull(flatter14);
                signalPainter = new SignalPainter(context10, flatter14);
            }
            this.signalPainter = signalPainter;
        }
        if (config.showSpecial()) {
            SpecialDrawPainter specialDrawPainter = this.specialDrawPainter;
            if (specialDrawPainter == null) {
                Context context11 = getContext();
                Intrinsics.checkNotNullExpressionValue(context11, "getContext(...)");
                Clock clock14 = this.mClock;
                ClockConfigFlatter flatter15 = clock14 != null ? clock14.getFlatter() : null;
                Intrinsics.checkNotNull(flatter15);
                specialDrawPainter = new SpecialDrawPainter(context11, flatter15);
            }
            this.specialDrawPainter = specialDrawPainter;
        }
        if (config.showConnectAnimation()) {
            ConnectPainter connectPainter = this.connectPainter;
            if (connectPainter == null) {
                Context context12 = getContext();
                Intrinsics.checkNotNullExpressionValue(context12, "getContext(...)");
                Clock clock15 = this.mClock;
                ClockConfigFlatter flatter16 = clock15 != null ? clock15.getFlatter() : null;
                Intrinsics.checkNotNull(flatter16);
                connectPainter = new ConnectPainter(context12, flatter16);
            }
            this.connectPainter = connectPainter;
        }
        if (config.getShow_action() == 1) {
            ActionPainter actionPainter = this.actionPainter;
            if (actionPainter == null) {
                Context context13 = getContext();
                Intrinsics.checkNotNullExpressionValue(context13, "getContext(...)");
                Clock clock16 = this.mClock;
                ClockConfigFlatter flatter17 = clock16 != null ? clock16.getFlatter() : null;
                Intrinsics.checkNotNull(flatter17);
                actionPainter = new ActionPainter(context13, flatter17);
            }
            this.actionPainter = actionPainter;
        }
        if (config.showWeather()) {
            WeatherPainter weatherPainter = this.weatherPainter;
            if (weatherPainter == null) {
                Context context14 = getContext();
                Intrinsics.checkNotNullExpressionValue(context14, "getContext(...)");
                Clock clock17 = this.mClock;
                ClockConfigFlatter flatter18 = clock17 != null ? clock17.getFlatter() : null;
                Intrinsics.checkNotNull(flatter18);
                weatherPainter = new WeatherPainter(context14, flatter18);
            }
            this.weatherPainter = weatherPainter;
        }
        if (config.supportCompass()) {
            CommonCompassPainter commonCompassPainter = this.commonCompassPainter;
            if (commonCompassPainter == null) {
                Context context15 = getContext();
                Intrinsics.checkNotNullExpressionValue(context15, "getContext(...)");
                Clock clock18 = this.mClock;
                ClockConfigFlatter flatter19 = clock18 != null ? clock18.getFlatter() : null;
                Intrinsics.checkNotNull(flatter19);
                commonCompassPainter = new CommonCompassPainter(context15, flatter19);
            }
            this.commonCompassPainter = commonCompassPainter;
        }
        SpecialCompassPainter specialCompassPainter3 = this.specialCompassPainter;
        if (specialCompassPainter3 == null) {
            Clock clock19 = this.mClock;
            if (clock19 == null || (flatter3 = clock19.getFlatter()) == null || flatter3.getCompassConfig() == null) {
                specialCompassPainter2 = null;
            } else {
                Context context16 = getContext();
                Intrinsics.checkNotNullExpressionValue(context16, "getContext(...)");
                Clock clock20 = this.mClock;
                ClockConfigFlatter flatter20 = clock20 != null ? clock20.getFlatter() : null;
                Intrinsics.checkNotNull(flatter20);
                specialCompassPainter2 = new SpecialCompassPainter(context16, flatter20);
            }
            specialCompassPainter3 = specialCompassPainter2;
        }
        this.specialCompassPainter = specialCompassPainter3;
        BtnClickPaint btnClickPaint = this.btnClickPaint;
        if (btnClickPaint == null) {
            Context context17 = getContext();
            Intrinsics.checkNotNullExpressionValue(context17, "getContext(...)");
            Clock clock21 = this.mClock;
            ClockConfigFlatter flatter21 = clock21 != null ? clock21.getFlatter() : null;
            Intrinsics.checkNotNull(flatter21);
            btnClickPaint = new BtnClickPaint(context17, flatter21);
        }
        this.btnClickPaint = btnClickPaint;
        if (config.getShow_oxygen() == 1) {
            OxygenPainter oxygenPainter = this.oxygenPainter;
            if (oxygenPainter == null) {
                Context context18 = getContext();
                Intrinsics.checkNotNullExpressionValue(context18, "getContext(...)");
                Clock clock22 = this.mClock;
                ClockConfigFlatter flatter22 = clock22 != null ? clock22.getFlatter() : null;
                Intrinsics.checkNotNull(flatter22);
                oxygenPainter = new OxygenPainter(context18, flatter22);
            }
            this.oxygenPainter = oxygenPainter;
        }
        Clock clock23 = this.mClock;
        if (clock23 != null && (flatter2 = clock23.getFlatter()) != null && (lottieBackground = flatter2.getLottieBackground()) != null) {
            lottieBackground.setCallback(this);
            lottieBackground.setBounds(0, 0, getWidth(), getHeight());
            Clock clock24 = this.mClock;
            Intrinsics.checkNotNull(clock24);
            ClockConfigFlatter flatter23 = clock24.getFlatter();
            Intrinsics.checkNotNull(flatter23);
            LottiePainter lottiePainter2 = new LottiePainter(lottieBackground, flatter23, this);
            this.mLottiePaint = lottiePainter2;
            lottiePainter2.start();
            if (Unit.INSTANCE == null) {
                lottiePainter = this.mLottiePaint;
                if (lottiePainter != null) {
                    lottiePainter.stop();
                    Unit unit = Unit.INSTANCE;
                }
            }
        } else {
            lottiePainter = this.mLottiePaint;
            if (lottiePainter != null) {
                lottiePainter.stop();
                Unit unit2 = Unit.INSTANCE;
            }
        }
        this.isLoadResFinish = true;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        ClockConfigFlatter flatter;
        LottieDrawable lottieBackground;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Clock clock = this.mClock;
        if (clock != null && (flatter = clock.getFlatter()) != null && (lottieBackground = flatter.getLottieBackground()) != null && Intrinsics.areEqual(lottieBackground, drawable)) {
            invalidate();
        }
        super.invalidateDrawable(drawable);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        try {
            realDraw(canvas);
        } catch (Exception unused) {
        }
    }

    private final void realDraw(Canvas canvas) {
        Clock clock;
        ClockConfigFlatter flatter;
        IBasePainter iBasePainter;
        IBasePainter iBasePainter2;
        LottiePainter lottiePainter;
        IBasePainter iBasePainter3;
        IBasePainter iBasePainter4;
        IBasePainter iBasePainter5;
        IBasePainter iBasePainter6;
        IBasePainter iBasePainter7;
        IBasePainter iBasePainter8;
        IBasePainter iBasePainter9;
        IBasePainter iBasePainter10;
        IBasePainter iBasePainter11;
        IBasePainter iBasePainter12;
        IBasePainter iBasePainter13;
        IBasePainter iBasePainter14;
        LottiePainter lottiePainter2;
        if (!this.isCurrentForent || (clock = this.mClock) == null || (flatter = clock.getFlatter()) == null) {
            return;
        }
        if (!this.isLoadResFinish) {
            Drawable preview = flatter.getPreview();
            if (preview != null) {
                Clock clock2 = this.mClock;
                ClockConfigFlatter flatter2 = clock2 != null ? clock2.getFlatter() : null;
                Intrinsics.checkNotNull(flatter2);
                int mScreenWidth = flatter2.getMScreenWidth();
                Clock clock3 = this.mClock;
                ClockConfigFlatter flatter3 = clock3 != null ? clock3.getFlatter() : null;
                Intrinsics.checkNotNull(flatter3);
                preview.setBounds(0, 0, mScreenWidth, flatter3.getMScreenHeight());
                preview.draw(canvas);
                return;
            }
            return;
        }
        Clock clock4 = this.mClock;
        Intrinsics.checkNotNull(clock4);
        ClockConfig config = clock4.getConfig();
        setBackground(null);
        drawBackground(canvas);
        if (config.getLottie_hierarchy() == 1 && (lottiePainter2 = this.mLottiePaint) != null) {
            lottiePainter2.draw(canvas, null);
        }
        if (config.showSpecial() && Intrinsics.areEqual(config.getSpecial_1_position(), "1") && (iBasePainter14 = this.specialDrawPainter) != null) {
            iBasePainter14.draw(canvas, null);
        }
        if (flatter.getConfig().showConnectAnimation() && (iBasePainter13 = this.connectPainter) != null) {
            iBasePainter13.draw(canvas, null);
        }
        if (flatter.getAction1() != null && (iBasePainter12 = this.actionPainter) != null) {
            Intrinsics.checkNotNull(iBasePainter12, "null cannot be cast to non-null type com.dw.launcher.ui.clock.painter.ActionPainter");
            ((ActionPainter) iBasePainter12).drawActionOne(canvas, null);
        }
        if (flatter.getAction2() != null && (iBasePainter11 = this.actionPainter) != null) {
            Intrinsics.checkNotNull(iBasePainter11, "null cannot be cast to non-null type com.dw.launcher.ui.clock.painter.ActionPainter");
            ((ActionPainter) iBasePainter11).drawActionTwo(canvas, null);
        }
        if (flatter.getAction3() != null && (iBasePainter10 = this.actionPainter) != null) {
            Intrinsics.checkNotNull(iBasePainter10, "null cannot be cast to non-null type com.dw.launcher.ui.clock.painter.ActionPainter");
            ((ActionPainter) iBasePainter10).drawActionThree(canvas, null);
        }
        if ((config.showBattery() || config.showBatteryNum()) && (iBasePainter = this.batteryPainter) != null) {
            iBasePainter.draw(canvas, null);
        }
        IBasePainter iBasePainter15 = this.datePainter;
        if (iBasePainter15 != null) {
            iBasePainter15.draw(canvas, null);
        }
        if (this.is_support_heart_function && config.showHeart() && (iBasePainter9 = this.heartPainter) != null) {
            iBasePainter9.draw(canvas, null);
        }
        if (config.showStep() && (iBasePainter8 = this.stepPainter) != null) {
            iBasePainter8.draw(canvas, null);
        }
        if (config.showCalories() && (iBasePainter7 = this.caloriesPainter) != null) {
            iBasePainter7.draw(canvas, null);
        }
        if (Intrinsics.areEqual(config.getShow_km(), "1") && (iBasePainter6 = this.kmPainter) != null) {
            iBasePainter6.draw(canvas, null);
        }
        if (config.getShow_oxygen() == 1 && (iBasePainter5 = this.oxygenPainter) != null) {
            iBasePainter5.draw(canvas, null);
        }
        if (config.showSignal() && (iBasePainter4 = this.signalPainter) != null) {
            iBasePainter4.draw(canvas, null);
        }
        drawCompass(canvas, this.rotationAngle);
        if (config.showWeather() && (iBasePainter3 = this.weatherPainter) != null) {
            WeatherManager weatherManager = WeatherManager.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            weatherManager.notifyWeatherUpdate(context);
            WeatherData weatherData = WeatherManager.INSTANCE.getWeatherData();
            if (weatherData != null) {
                IBasePainter iBasePainter16 = this.weatherPainter;
                Intrinsics.checkNotNull(iBasePainter16, "null cannot be cast to non-null type com.dw.launcher.ui.clock.painter.WeatherPainter");
                String code = weatherData.getCode();
                Intrinsics.checkNotNull(code, "null cannot be cast to non-null type kotlin.String");
                String current = weatherData.getCurrent();
                Intrinsics.checkNotNull(current, "null cannot be cast to non-null type kotlin.String");
                String min = weatherData.getMin();
                Intrinsics.checkNotNull(min, "null cannot be cast to non-null type kotlin.String");
                String max = weatherData.getMax();
                Intrinsics.checkNotNull(max, "null cannot be cast to non-null type kotlin.String");
                ((WeatherPainter) iBasePainter16).updateParams(code, current, min, max);
            }
            iBasePainter3.draw(canvas, null);
        }
        IBasePainter iBasePainter17 = this.btnClickPaint;
        if (iBasePainter17 != null) {
            iBasePainter17.draw(canvas, null);
        }
        if (config.getLottie_hierarchy() == 0 && (lottiePainter = this.mLottiePaint) != null) {
            lottiePainter.draw(canvas, null);
        }
        TimerPainter timerPainter = this.timerPainter;
        if (timerPainter != null) {
            timerPainter.draw(canvas, null);
        }
        if (config.showSpecial() && Intrinsics.areEqual(config.getSpecial_1_position(), "0") && (iBasePainter2 = this.specialDrawPainter) != null) {
            iBasePainter2.draw(canvas, null);
        }
    }

    private final void drawSetting(Canvas canvas, ClockConfig config, ClockConfigFlatter flatter) {
        Drawable settingrawable;
        if (!config.showBtnSetting() || (settingrawable = flatter.getSettingrawable()) == null) {
            return;
        }
        drawDrawable(canvas, settingrawable, flatter.getSettingPosition().x, flatter.getSettingPosition().y, flatter.getScaleX(), flatter.getScaleY());
    }

    private final void drawAlarm(Canvas canvas, ClockConfig config, ClockConfigFlatter flatter) {
        Drawable alarmDrawable;
        if (!config.showAlarm() || (alarmDrawable = flatter.getAlarmDrawable()) == null) {
            return;
        }
        drawDrawable(canvas, alarmDrawable, flatter.getAlarmPosition().x, flatter.getAlarmPosition().y, flatter.getScaleX(), flatter.getScaleY());
    }

    private final void drawMusic(Canvas canvas, ClockConfig config, ClockConfigFlatter flatter) {
        Drawable musicDrawable;
        if (!config.showMusic() || (musicDrawable = flatter.getMusicDrawable()) == null) {
            return;
        }
        drawDrawable(canvas, musicDrawable, flatter.getMusicPosition().x, flatter.getMusicPosition().y, flatter.getScaleX(), flatter.getScaleY());
    }

    private final void drawWeather(Canvas canvas, ClockConfig config, ClockConfigFlatter flatter) {
        Drawable weatheaDrawable;
        if (!config.showWeather() || (weatheaDrawable = flatter.getWeatheaDrawable()) == null) {
            return;
        }
        drawDrawable(canvas, weatheaDrawable, flatter.getWeatherPosition().x, flatter.getWeatherPosition().y, flatter.getScaleX(), flatter.getScaleY());
    }

    private final void drawCompass(Canvas canvas, float rotation) {
        ClockConfig config;
        ClockConfig config2;
        IBasePainter iBasePainter;
        Clock clock = this.mClock;
        if (clock == null || (config = clock.getConfig()) == null || config.getSupport_compass() != 1) {
            return;
        }
        IBasePainter iBasePainter2 = this.commonCompassPainter;
        if (iBasePainter2 != null) {
            iBasePainter2.updateParams(Boolean.valueOf(this.is_support_compass_function), Float.valueOf(rotation));
            iBasePainter2.draw(canvas, null);
        }
        Clock clock2 = this.mClock;
        if (clock2 == null || (config2 = clock2.getConfig()) == null || !config2.compassShowDetailDegree() || (iBasePainter = this.specialCompassPainter) == null) {
            return;
        }
        iBasePainter.updateParams(Integer.valueOf((int) rotation));
        iBasePainter.draw(canvas, null);
    }

    private final void drawDrawable(Canvas canvas, Drawable drawable, int x, int y, float scaleX, float scaleY) {
        drawable.setBounds(x, y, ((int) (drawable.getIntrinsicWidth() * scaleX)) + x, ((int) (drawable.getIntrinsicHeight() * scaleY)) + y);
        drawable.draw(canvas);
    }

    public final void registerOnGestureListener(OnGestureListener onGestureListener) {
        Intrinsics.checkNotNullParameter(onGestureListener, "onGestureListener");
        this.onGestureListener = onGestureListener;
    }

    public final void registerClockItemClickListener(OnWatchItemClickListener onClockItemClickListener) {
        Intrinsics.checkNotNullParameter(onClockItemClickListener, "onClockItemClickListener");
        this.onWatchItemClickListener = onClockItemClickListener;
    }

    public final int getDownX() {
        return this.downX;
    }

    public final void setDownX(int i) {
        this.downX = i;
    }

    public final int getDownY() {
        return this.downY;
    }

    public final void setDownY(int i) {
        this.downY = i;
    }

    /* JADX INFO: renamed from: isClick, reason: from getter */
    public final boolean getIsClick() {
        return this.isClick;
    }

    public final void setClick(boolean z) {
        this.isClick = z;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Clock clock;
        Clock clock2;
        ClockConfigFlatter flatter;
        ClockConfig config;
        ClockConfigFlatter flatter2;
        ClockConfig config2;
        ClockConfigFlatter flatter3;
        List<Drawable> backgrounds;
        ClockConfigFlatter flatter4;
        ClockConfigFlatter flatter5;
        ClockConfigFlatter flatter6;
        List<Drawable> backgrounds2;
        ClockConfigFlatter flatter7;
        ClockConfig config3;
        ClockConfig config4;
        OnVideoClickListener onVideoClickListener;
        Clock clock3;
        ClockConfig config5;
        Clock clock4;
        Clock clock5;
        ClockConfig config6;
        ClockConfig config7;
        ClockConfig config8;
        ClockConfig config9;
        Clock clock6;
        ClockConfigFlatter flatter8;
        Intrinsics.checkNotNullParameter(event, "event");
        int x = (int) event.getX();
        int y = (int) event.getY();
        int action = event.getAction();
        if (action == 0) {
            this.downX = x;
            this.downY = y;
            this.isClick = true;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x - this.downX) > 20 || Math.abs(y - this.downY) > 20)) {
                this.isClick = false;
            }
        } else if (event.getEventTime() - event.getDownTime() < 500 && this.isClick) {
            Clock clock7 = this.mClock;
            if (clock7 != null && (config9 = clock7.getConfig()) != null && config9.showConnectAnimation() && this.connectPainter != null && (clock6 = this.mClock) != null && (flatter8 = clock6.getFlatter()) != null && flatter8.getConectDrawables() != null) {
                IBasePainter iBasePainter = this.connectPainter;
                Intrinsics.checkNotNull(iBasePainter, "null cannot be cast to non-null type com.dw.launcher.ui.clock.painter.ConnectPainter");
                if (((ConnectPainter) iBasePainter).onclick(x, y)) {
                    return true;
                }
            }
            IBasePainter iBasePainter2 = this.btnClickPaint;
            if (iBasePainter2 != null) {
                Intrinsics.checkNotNull(iBasePainter2, "null cannot be cast to non-null type com.dw.launcher.ui.clock.painter.BtnClickPaint");
                if (((BtnClickPaint) iBasePainter2).todoClick(x, y)) {
                    return true;
                }
            }
            Drawable drawable = null;
            if (this.timerPainter != null) {
                Clock clock8 = this.mClock;
                Integer numValueOf = (clock8 == null || (config8 = clock8.getConfig()) == null) ? null : Integer.valueOf(config8.getTime_change_counter());
                Intrinsics.checkNotNull(numValueOf);
                if (numValueOf.intValue() > 0 && (((clock4 = this.mClock) != null && (config7 = clock4.getConfig()) != null && config7.getDialtype() == 0) || ((clock5 = this.mClock) != null && (config6 = clock5.getConfig()) != null && config6.getDialtype() == 2))) {
                    TimerPainter timerPainter = this.timerPainter;
                    Intrinsics.checkNotNull(timerPainter, "null cannot be cast to non-null type com.dw.launcher.ui.clock.painter.TimerPainter");
                    timerPainter.changeTimeStyle();
                }
            }
            IBasePainter iBasePainter3 = this.actionPainter;
            if (iBasePainter3 != null && ((ActionPainter) iBasePainter3).onclick(x, y)) {
                return true;
            }
            IBasePainter iBasePainter4 = this.specialDrawPainter;
            if (iBasePainter4 != null && (clock3 = this.mClock) != null && (config5 = clock3.getConfig()) != null && config5.getSupport_multiple_change() == 1 && ((SpecialDrawPainter) iBasePainter4).todoClick(x, y)) {
                return true;
            }
            Clock clock9 = this.mClock;
            if (clock9 != null && (config4 = clock9.getConfig()) != null && config4.getVideo_type() == 1 && (onVideoClickListener = this.onVideoClickListener) != null) {
                onVideoClickListener.onVideoClick();
            }
            if (this.bgPainter != null && (((clock = this.mClock) != null && (flatter7 = clock.getFlatter()) != null && (config3 = flatter7.getConfig()) != null && config3.getBg_type() == 3) || ((clock2 = this.mClock) != null && (flatter = clock2.getFlatter()) != null && (config = flatter.getConfig()) != null && config.supportBtnChange()))) {
                Clock clock10 = this.mClock;
                if (clock10 != null && (flatter2 = clock10.getFlatter()) != null && (config2 = flatter2.getConfig()) != null && config2.getBg_type() == 2) {
                    Clock clock11 = this.mClock;
                    Integer numValueOf2 = (clock11 == null || (flatter6 = clock11.getFlatter()) == null || (backgrounds2 = flatter6.getBackgrounds()) == null) ? null : Integer.valueOf(backgrounds2.size());
                    Intrinsics.checkNotNull(numValueOf2);
                    int iIntValue = numValueOf2.intValue();
                    Clock clock12 = this.mClock;
                    ClockConfig config10 = (clock12 == null || (flatter5 = clock12.getFlatter()) == null) ? null : flatter5.getConfig();
                    Intrinsics.checkNotNull(config10);
                    int bgBtnIndex = (config10.getBgBtnIndex() + 1) % iIntValue;
                    Clock clock13 = this.mClock;
                    ClockConfig config11 = (clock13 == null || (flatter4 = clock13.getFlatter()) == null) ? null : flatter4.getConfig();
                    if (config11 != null) {
                        config11.setBg_btn_index(bgBtnIndex);
                    }
                    Clock clock14 = this.mClock;
                    if (clock14 != null && (flatter3 = clock14.getFlatter()) != null && (backgrounds = flatter3.getBackgrounds()) != null) {
                        drawable = backgrounds.get(bgBtnIndex);
                    }
                    clickChangeBg(true, drawable);
                    return true;
                }
                IBasePainter iBasePainter5 = this.bgPainter;
                Intrinsics.checkNotNull(iBasePainter5, "null cannot be cast to non-null type com.dw.launcher.ui.clock.painter.BgPainter");
                ((BgPainter) iBasePainter5).changeBg(false, null);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: compiled from: CommonClock.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J(\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/dw/launcher/ui/clock/widget/CommonClock$GestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "(Lcom/dw/launcher/ui/clock/widget/CommonClock;)V", "onDown", "", "event", "Landroid/view/MotionEvent;", "onLongPress", "", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onSingleTapUp", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }

        public GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            OnGestureListener onGestureListener = CommonClock.this.onGestureListener;
            if (onGestureListener == null) {
                return true;
            }
            onGestureListener.onDown(event);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Intrinsics.checkNotNullParameter(e1, "e1");
            Intrinsics.checkNotNullParameter(e2, "e2");
            OnGestureListener onGestureListener = CommonClock.this.onGestureListener;
            if (onGestureListener != null) {
                return onGestureListener.onScroll(e1, e2, distanceX, distanceY);
            }
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent event) {
            Clock clock;
            ClockConfigFlatter flatter;
            ClockConfig config;
            ClockConfig config2;
            Clock clock2;
            ClockConfigFlatter flatter2;
            Intrinsics.checkNotNullParameter(event, "event");
            int x = (int) event.getX();
            int y = (int) event.getY();
            Clock clock3 = CommonClock.this.mClock;
            if (clock3 != null && (config2 = clock3.getConfig()) != null && config2.showConnectAnimation() && (clock2 = CommonClock.this.mClock) != null && (flatter2 = clock2.getFlatter()) != null && flatter2.getConectDrawables() != null) {
                IBasePainter iBasePainter = CommonClock.this.connectPainter;
                Intrinsics.checkNotNull(iBasePainter, "null cannot be cast to non-null type com.dw.launcher.ui.clock.painter.ConnectPainter");
                if (((ConnectPainter) iBasePainter).onclick(x, y)) {
                    return true;
                }
            }
            if (CommonClock.this.btnClickPaint != null) {
                IBasePainter iBasePainter2 = CommonClock.this.btnClickPaint;
                Intrinsics.checkNotNull(iBasePainter2, "null cannot be cast to non-null type com.dw.launcher.ui.clock.painter.BtnClickPaint");
                if (((BtnClickPaint) iBasePainter2).todoClick(x, y)) {
                    return true;
                }
            }
            if (CommonClock.this.bgPainter == null || (clock = CommonClock.this.mClock) == null || (flatter = clock.getFlatter()) == null || (config = flatter.getConfig()) == null || config.getBg_type() != 3) {
                OnGestureListener onGestureListener = CommonClock.this.onGestureListener;
                if (onGestureListener != null) {
                    onGestureListener.onSingleTapUp(event);
                }
                return false;
            }
            IBasePainter iBasePainter3 = CommonClock.this.bgPainter;
            Intrinsics.checkNotNull(iBasePainter3, "null cannot be cast to non-null type com.dw.launcher.ui.clock.painter.BgPainter");
            ((BgPainter) iBasePainter3).changeBg(false, null);
            return true;
        }
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

    public final void updateTimeFormat() {
        this.is24TimeClock = DateFormat.is24HourFormat(getContext());
    }

    public void visibleToFront(boolean isVisible) {
        if (isAttachedToWindow()) {
            this.mDateComponent.currentFront(this.isCurrentForent, isVisible);
            if (isVisible) {
                startAnimation();
                TimerPainter timerPainter = this.timerPainter;
                if (timerPainter != null) {
                    timerPainter.updateParams(1);
                    return;
                }
                return;
            }
            stopAnimation();
        }
    }

    public final void supportHeartFunction(boolean support) {
        this.is_support_heart_function = support;
    }

    public final void supportCompassFunction(boolean support) {
        this.is_support_compass_function = support;
    }

    public final void compassRotation(float rotation) {
        this.rotationAngle = rotation;
    }

    public static /* synthetic */ void clickChangeBg$default(CommonClock commonClock, boolean z, Drawable drawable, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            drawable = null;
        }
        commonClock.clickChangeBg(z, drawable);
    }

    public final void clickChangeBg(boolean isDynamic, Drawable backgroundDrawable) {
        ClockConfig config;
        if (this.bgPainter != null) {
            Clock clock = this.mClock;
            if ((clock == null || (config = clock.getConfig()) == null || config.getBg_type() != 3) && !isDynamic) {
                return;
            }
            IBasePainter iBasePainter = this.bgPainter;
            Intrinsics.checkNotNull(iBasePainter, "null cannot be cast to non-null type com.dw.launcher.ui.clock.painter.BgPainter");
            ((BgPainter) iBasePainter).changeBg(isDynamic, backgroundDrawable);
            IBasePainter iBasePainter2 = this.commonCompassPainter;
            if (iBasePainter2 != null) {
                Intrinsics.checkNotNull(iBasePainter2, "null cannot be cast to non-null type com.dw.launcher.ui.clock.painter.CommonCompassPainter");
                ((CommonCompassPainter) iBasePainter2).setIndex();
            }
        }
    }

    public final boolean needListenCompassPort() {
        ClockConfig config;
        Clock clock = this.mClock;
        return (clock == null || (config = clock.getConfig()) == null || config.getSupport_compass() != 1) ? false : true;
    }

    public final void setOnVideoClickListener(OnVideoClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onVideoClickListener = listener;
    }
}
