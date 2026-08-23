package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.format.DateFormat;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduHeaders;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifDrawable;

/* JADX INFO: compiled from: TimerPainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\bR\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010¹\u0001\u001a\u00020Y2\u0007\u0010º\u0001\u001a\u00020Y2\u0007\u0010»\u0001\u001a\u00020Y2\u0007\u0010¼\u0001\u001a\u00020\u0017H\u0002J-\u0010½\u0001\u001a\u00020\u00172\u0007\u0010¼\u0001\u001a\u00020\u00172\u0007\u0010¾\u0001\u001a\u00020\u00172\u0007\u0010¿\u0001\u001a\u00020\u00172\u0007\u0010À\u0001\u001a\u00020?H\u0002J-\u0010Á\u0001\u001a\u00020G2\u0007\u0010Â\u0001\u001a\u00020\u00172\u0007\u0010Ã\u0001\u001a\u00020G2\u0007\u0010Ä\u0001\u001a\u00020\u00172\u0007\u0010Å\u0001\u001a\u00020GH\u0002J$\u0010Æ\u0001\u001a\u00020G2\u0007\u0010Ç\u0001\u001a\u00020\u00172\u0007\u0010Ã\u0001\u001a\u00020G2\u0007\u0010Ä\u0001\u001a\u00020\u0017H\u0002J$\u0010È\u0001\u001a\u00020G2\u0007\u0010Ç\u0001\u001a\u00020\u00172\u0007\u0010Ã\u0001\u001a\u00020G2\u0007\u0010Ä\u0001\u001a\u00020\u0017H\u0002J\"\u0010É\u0001\u001a\u00020Y2\u0007\u0010Ê\u0001\u001a\u00020\u00172\u0007\u0010Ë\u0001\u001a\u00020Y2\u0007\u0010Ì\u0001\u001a\u00020YJ\b\u0010Í\u0001\u001a\u00030Î\u0001J \u0010Ï\u0001\u001a\u00030Î\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u00012\n\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u0001H\u0016J?\u0010Ô\u0001\u001a\u00030Î\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u00012\u0007\u0010Õ\u0001\u001a\u00020\u000f2\u0007\u0010Ç\u0001\u001a\u00020\u00172\u0007\u0010Ö\u0001\u001a\u00020G2\u0007\u0010¡\u0001\u001a\u00020Y2\u0007\u0010£\u0001\u001a\u00020YJ\u0014\u0010×\u0001\u001a\u00030Î\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u0001H\u0002J/\u0010Ø\u0001\u001a\u00030Î\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u00012\u0007\u0010Õ\u0001\u001a\u00020\u000f2\u0007\u0010Ù\u0001\u001a\u00020\b2\u0007\u0010Ú\u0001\u001a\u00020YH\u0002J\u0014\u0010Û\u0001\u001a\u00030Î\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u0001H\u0002J\u0014\u0010Ü\u0001\u001a\u00030Î\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u0001H\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001a\u0010\"\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013R\u001a\u0010(\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\fR\"\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u0013R\u0014\u0010.\u001a\u00020\u0017X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0019R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010@\"\u0004\bD\u0010BR\u000e\u0010E\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u00020GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0019\"\u0004\bN\u0010\u001bR\u001a\u0010O\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0019\"\u0004\bQ\u0010\u001bR\u001a\u0010R\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0019\"\u0004\bT\u0010\u001bR\u001a\u0010U\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0019\"\u0004\bW\u0010\u001bR\u000e\u0010X\u001a\u00020YX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0019\"\u0004\b]\u0010\u001bR\u001a\u0010^\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0019\"\u0004\b`\u0010\u001bR\u001a\u0010a\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0019\"\u0004\bc\u0010\u001bR\u001a\u0010d\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0019\"\u0004\bf\u0010\u001bR\u001a\u0010g\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0019\"\u0004\bi\u0010\u001bR\u001a\u0010j\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0019\"\u0004\bl\u0010\u001bR\u000e\u0010m\u001a\u00020YX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010o\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0019\"\u0004\bq\u0010\u001bR\u001a\u0010r\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0019\"\u0004\bt\u0010\u001bR\u000e\u0010u\u001a\u00020YX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010w\u001a\u00020GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010I\"\u0004\by\u0010KR\u000e\u0010z\u001a\u00020YX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020YX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020YX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010}\u001a\u00020GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010I\"\u0004\b\u007f\u0010KR\u001d\u0010\u0080\u0001\u001a\u00020GX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010I\"\u0005\b\u0082\u0001\u0010KR\u001d\u0010\u0083\u0001\u001a\u00020GX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010I\"\u0005\b\u0085\u0001\u0010KR\u001d\u0010\u0086\u0001\u001a\u00020GX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010I\"\u0005\b\u0088\u0001\u0010KR\u001d\u0010\u0089\u0001\u001a\u00020GX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010I\"\u0005\b\u008b\u0001\u0010KR\u001d\u0010\u008c\u0001\u001a\u00020GX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010I\"\u0005\b\u008e\u0001\u0010KR\u001d\u0010\u008f\u0001\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0019\"\u0005\b\u0091\u0001\u0010\u001bR\u001d\u0010\u0092\u0001\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\u0019\"\u0005\b\u0094\u0001\u0010\u001bR\u001d\u0010\u0095\u0001\u001a\u000201X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u00103\"\u0005\b\u0097\u0001\u00105R!\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R\u000f\u0010\u009d\u0001\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u0017\u0010\u009e\u0001\u001a\u00020YX\u0086D¢\u0006\n\n\u0000\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0017\u0010¡\u0001\u001a\u00020YX\u0086D¢\u0006\n\n\u0000\u001a\u0006\b¢\u0001\u0010 \u0001R\u0017\u0010£\u0001\u001a\u00020YX\u0086D¢\u0006\n\n\u0000\u001a\u0006\b¤\u0001\u0010 \u0001R\u001d\u0010¥\u0001\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010\u0019\"\u0005\b§\u0001\u0010\u001bR\u001d\u0010¨\u0001\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010\u0019\"\u0005\bª\u0001\u0010\u001bR\u0016\u0010«\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0¬\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u00ad\u0001\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010\u0019\"\u0005\b¯\u0001\u0010\u001bR\"\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b²\u0001\u0010³\u0001\"\u0006\b´\u0001\u0010µ\u0001R\u001d\u0010¶\u0001\u001a\u00020\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010\n\"\u0005\b¸\u0001\u0010\f¨\u0006Ý\u0001"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/TimerPainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "chineseTimePosition", "Landroid/graphics/Point;", "getChineseTimePosition", "()Landroid/graphics/Point;", "setChineseTimePosition", "(Landroid/graphics/Point;)V", "chineseTimePositionDrawable", "", "Landroid/graphics/drawable/Drawable;", "getChineseTimePositionDrawable", "()Ljava/util/List;", "setChineseTimePositionDrawable", "(Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "currentStyle", "", "getCurrentStyle", "()I", "setCurrentStyle", "(I)V", "digitHour2Position", "getDigitHour2Position", "setDigitHour2Position", "digitHour2SplitDrawable", "getDigitHour2SplitDrawable", "setDigitHour2SplitDrawable", "digitMin2Position", "getDigitMin2Position", "setDigitMin2Position", "digitMin2SplitDrawable", "getDigitMin2SplitDrawable", "setDigitMin2SplitDrawable", "digitSec2Position", "getDigitSec2Position", "setDigitSec2Position", "digitSec2SplitDrawable", "getDigitSec2SplitDrawable", "setDigitSec2SplitDrawable", "digitStartAnimationMaxTime", "getDigitStartAnimationMaxTime", "digitalAnimationStartTime", "", "getDigitalAnimationStartTime", "()J", "setDigitalAnimationStartTime", "(J)V", "dragonBollTimePainter", "Lcom/dw/launcher/ui/clock/painter/DragonBollTimePainter;", "getDragonBollTimePainter", "()Lcom/dw/launcher/ui/clock/painter/DragonBollTimePainter;", "setDragonBollTimePainter", "(Lcom/dw/launcher/ui/clock/painter/DragonBollTimePainter;)V", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "isDigitalStartAnimation", "", "()Z", "setDigitalStartAnimation", "(Z)V", "isPointerStartAnimation", "setPointerStartAnimation", "lastDrawSecTime", "mCircleR", "", "getMCircleR", "()D", "setMCircleR", "(D)V", "mCircleX", "getMCircleX", "setMCircleX", "mCircleY", "getMCircleY", "setMCircleY", "mExtraAngle", "getMExtraAngle", "setMExtraAngle", "mExtraAngleTime", "getMExtraAngleTime", "setMExtraAngleTime", "mHourChangeAngle", "", "mHourChangeNum", "mHourSpltHeight", "getMHourSpltHeight", "setMHourSpltHeight", "mHourSpltWidth", "getMHourSpltWidth", "setMHourSpltWidth", "mMinCellHeight", "getMMinCellHeight", "setMMinCellHeight", "mMinCellWidth", "getMMinCellWidth", "setMMinCellWidth", "mMinSpltHeight", "getMMinSpltHeight", "setMMinSpltHeight", "mMinSpltWidth", "getMMinSpltWidth", "setMMinSpltWidth", "mMinuteChangeAngle", "mMinuteChangeNum", "mSecNumCellHeight", "getMSecNumCellHeight", "setMSecNumCellHeight", "mSecNumCellWidth", "getMSecNumCellWidth", "setMSecNumCellWidth", "mSecondChangeAngle", "mSecondChangeNum", "mStartArc", "getMStartArc", "setMStartArc", "mStartHourAngle", "mStartMinuteAngle", "mStartSecondAngle", "mStartTimeArc", "getMStartTimeArc", "setMStartTimeArc", "mSubArcHourNum", "getMSubArcHourNum", "setMSubArcHourNum", "mSubArcMinNum", "getMSubArcMinNum", "setMSubArcMinNum", "mSubArcSecNum", "getMSubArcSecNum", "setMSubArcSecNum", "mSubArcSpltHour", "getMSubArcSpltHour", "setMSubArcSpltHour", "mSubArcSpltMin", "getMSubArcSpltMin", "setMSubArcSpltMin", "mTimeCellHeight", "getMTimeCellHeight", "setMTimeCellHeight", "mTimeCellWidth", "getMTimeCellWidth", "setMTimeCellWidth", "pointerAnimationStartTime", "getPointerAnimationStartTime", "setPointerAnimationStartTime", "pointerSecondDrawable", "getPointerSecondDrawable", "()Landroid/graphics/drawable/Drawable;", "setPointerSecondDrawable", "(Landroid/graphics/drawable/Drawable;)V", "pointerStartAnimationMaxTime", "scale", "getScale", "()F", "scaleX", "getScaleX", "scaleY", "getScaleY", "secBitmapInterval", "getSecBitmapInterval", "setSecBitmapInterval", "secCurrentSecDrawableIndex", "getSecCurrentSecDrawableIndex", "setSecCurrentSecDrawableIndex", "secDrawables", "", "secbitmapCountSum", "getSecbitmapCountSum", "setSecbitmapCountSum", "specialDrawPainter", "Lcom/dw/launcher/ui/clock/painter/SpecialTimeDrawer;", "getSpecialDrawPainter", "()Lcom/dw/launcher/ui/clock/painter/SpecialTimeDrawer;", "setSpecialDrawPainter", "(Lcom/dw/launcher/ui/clock/painter/SpecialTimeDrawer;)V", "timeArcCenterPosition", "getTimeArcCenterPosition", "setTimeArcCenterPosition", "calculateChangeAngle", "startAngle", "endAngle", "type", "calculateChangeNum", "startNum", "endNum", "is24TimeClock", "calculateSubArc", "wdith", "radius", "height", "tempLen", "calculateTempLen", "width", "calculateTempLen_180", "changeAngle", "timeX", "oldAngle", "changeAngleSum", "changeTimeStyle", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawByAngle", "drawable", "drawArc2", "drawChinseTime", "drawPointer", "position", "degree", "drawTimeWithArc", "drawTimeWithoutArc", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class TimerPainter extends ABasePainter {
    private Point chineseTimePosition;
    private List<? extends Drawable> chineseTimePositionDrawable;
    private final Context context;
    private int currentStyle;
    private Point digitHour2Position;
    private List<? extends Drawable> digitHour2SplitDrawable;
    private Point digitMin2Position;
    private List<? extends Drawable> digitMin2SplitDrawable;
    private Point digitSec2Position;
    private List<? extends Drawable> digitSec2SplitDrawable;
    private final int digitStartAnimationMaxTime;
    private long digitalAnimationStartTime;
    private DragonBollTimePainter dragonBollTimePainter;
    private final ClockConfigFlatter flatter;
    private boolean isDigitalStartAnimation;
    private boolean isPointerStartAnimation;
    private long lastDrawSecTime;
    private double mCircleR;
    private int mCircleX;
    private int mCircleY;
    private int mExtraAngle;
    private int mExtraAngleTime;
    private float mHourChangeAngle;
    private int mHourChangeNum;
    private int mHourSpltHeight;
    private int mHourSpltWidth;
    private int mMinCellHeight;
    private int mMinCellWidth;
    private int mMinSpltHeight;
    private int mMinSpltWidth;
    private float mMinuteChangeAngle;
    private int mMinuteChangeNum;
    private int mSecNumCellHeight;
    private int mSecNumCellWidth;
    private float mSecondChangeAngle;
    private int mSecondChangeNum;
    private double mStartArc;
    private float mStartHourAngle;
    private float mStartMinuteAngle;
    private float mStartSecondAngle;
    private double mStartTimeArc;
    private double mSubArcHourNum;
    private double mSubArcMinNum;
    private double mSubArcSecNum;
    private double mSubArcSpltHour;
    private double mSubArcSpltMin;
    private int mTimeCellHeight;
    private int mTimeCellWidth;
    private long pointerAnimationStartTime;
    private Drawable pointerSecondDrawable;
    private final int pointerStartAnimationMaxTime;
    private final float scale;
    private final float scaleX;
    private final float scaleY;
    private int secBitmapInterval;
    private int secCurrentSecDrawableIndex;
    private List<Drawable> secDrawables;
    private int secbitmapCountSum;
    private SpecialTimeDrawer specialDrawPainter;
    private Point timeArcCenterPosition;

    private final float calculateChangeAngle(float startAngle, float endAngle, int type) {
        float f;
        float f2;
        if (startAngle > endAngle) {
            f = startAngle - endAngle;
            if (f >= 60.0f) {
                if (type == 1 || type == 3) {
                    if (f > 300.0f) {
                        f2 = ((360.0f - f) + 360.0f) * 1.0f;
                    }
                }
                return f2;
            }
            if (type != 1 && type != 3) {
                return (f + 360.0f) * (-1.0f);
            }
            return (360.0f - f) * 1.0f;
        }
        if (startAngle >= endAngle) {
            return (type == 1 || type == 3) ? 360.0f : -360.0f;
        }
        float f3 = endAngle - startAngle;
        if (f3 >= 60.0f) {
            if (type == 1 || type == 3) {
                return f3 * 1.0f;
            }
            if (f3 > 300.0f) {
                f = (360.0f - f3) + 360.0f;
            }
        } else if (type == 1 || type == 3) {
            return (f3 + 360.0f) * 1.0f;
        }
        return (360.0f - f3) * (-1.0f);
        f2 = f * (-1.0f);
        return f2;
    }

    public TimerPainter(Context context, ClockConfigFlatter flatter) {
        float intrinsicWidth;
        float scaleX;
        float scaleY;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.scale = 1.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.timeArcCenterPosition = new Point();
        this.secDrawables = new ArrayList();
        this.secCurrentSecDrawableIndex = 1;
        this.pointerStartAnimationMaxTime = 500;
        this.digitStartAnimationMaxTime = 500;
        this.isPointerStartAnimation = flatter.getConfig().getShow_pointer_start_animation() == 1;
        this.isDigitalStartAnimation = flatter.getConfig().getShow_digital_start_animation() == 1;
        this.digitHour2Position = new Point();
        this.digitMin2Position = new Point();
        this.chineseTimePosition = new Point();
        this.digitSec2Position = new Point();
        setSupportScale(flatter.getConfig().supportScale());
        if (flatter.getConfig().getNeed_split_hour() == 1) {
            flatter.setPosition(this.digitHour2Position, flatter.getConfig().getSplit_hour_x(), flatter.getConfig().getSplit_hour_y());
            List<Drawable> listSplitDrawable = flatter.splitDrawable(flatter.getConfig().getSplit_hour_src(), 10);
            this.digitHour2SplitDrawable = listSplitDrawable;
            if (listSplitDrawable == null) {
                this.digitHour2SplitDrawable = flatter.getDigitalHourDrawable();
            }
        }
        if (flatter.getConfig().getNeed_split_min() == 1) {
            flatter.setPosition(this.digitMin2Position, flatter.getConfig().getSplit_min_x(), flatter.getConfig().getSplit_min_y());
            List<Drawable> listSplitDrawable2 = flatter.splitDrawable(flatter.getConfig().getSplit_min_src(), 10);
            this.digitMin2SplitDrawable = listSplitDrawable2;
            if (listSplitDrawable2 == null) {
                this.digitMin2SplitDrawable = flatter.getDigitalMinuteDrawable();
            }
        }
        if (flatter.getConfig().getNeed_split_sec() == 1) {
            flatter.setPosition(this.digitSec2Position, flatter.getConfig().getSplit_sec_x(), flatter.getConfig().getSplit_sec_y());
            List<Drawable> listSplitDrawable3 = flatter.splitDrawable(flatter.getConfig().getSplit_sec_src(), 10);
            this.digitSec2SplitDrawable = listSplitDrawable3;
            if (listSplitDrawable3 == null) {
                this.digitSec2SplitDrawable = flatter.getDigitalSecondDrawable();
            }
        }
        if (flatter.getConfig().getTime_special_new() == 1) {
            this.specialDrawPainter = new SpecialTimeDrawer(context, flatter);
        }
        if (flatter.getConfig().getTime_special_drag_3d() == 1) {
            this.dragonBollTimePainter = new DragonBollTimePainter(context, flatter);
        }
        if (flatter.getConfig().getShow_chinse_time() == 1) {
            this.chineseTimePositionDrawable = flatter.splitDrawable(flatter.getConfig().getChinse_time_src(), 12);
            flatter.setPosition(this.chineseTimePosition, flatter.getConfig().getChinse_time_x(), flatter.getConfig().getChinse_time_y());
        }
        Drawable pointerSecondDrawable = flatter.getPointerSecondDrawable();
        this.pointerSecondDrawable = pointerSecondDrawable;
        if (pointerSecondDrawable != null) {
            int second_pointer_animal_type = flatter.getConfig().getSecond_pointer_animal_type();
            if (second_pointer_animal_type == 1) {
                AnimationDrawable animationDrawable = (AnimationDrawable) pointerSecondDrawable;
                this.secBitmapInterval = animationDrawable.getDuration(0);
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                for (int i = 0; i < numberOfFrames; i++) {
                    Drawable frame = animationDrawable.getFrame(i);
                    Intrinsics.checkNotNullExpressionValue(frame, "getFrame(...)");
                    this.secDrawables.add(frame);
                }
                this.secbitmapCountSum = this.secDrawables.size();
            } else if (second_pointer_animal_type == 2) {
                GifDrawable gifDrawable = (GifDrawable) pointerSecondDrawable;
                this.secBitmapInterval = gifDrawable.getFrameDuration(0);
                int numberOfFrames2 = gifDrawable.getNumberOfFrames();
                for (int i2 = 0; i2 < numberOfFrames2; i2++) {
                    this.secDrawables.add(new BitmapDrawable(gifDrawable.seekToFrameAndGet(i2)));
                }
                this.secbitmapCountSum = this.secDrawables.size();
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        List<Drawable> digitalHourDrawable = this.flatter.getDigitalHourDrawable();
        if (digitalHourDrawable != null) {
            this.mTimeCellWidth = getSupportScale() ? (int) (digitalHourDrawable.get(0).getIntrinsicWidth() * this.flatter.getAbsoluteScaleX()) : digitalHourDrawable.get(0).getIntrinsicWidth();
            boolean supportScale = getSupportScale();
            int intrinsicHeight = digitalHourDrawable.get(0).getIntrinsicHeight();
            this.mTimeCellHeight = supportScale ? (int) (intrinsicHeight * this.flatter.getAbsoluteScaleY()) : intrinsicHeight;
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        List<Drawable> digitalMinuteDrawable = this.flatter.getDigitalMinuteDrawable();
        if (digitalMinuteDrawable != null) {
            this.mMinCellWidth = getSupportScale() ? (int) (digitalMinuteDrawable.get(0).getIntrinsicWidth() * this.flatter.getAbsoluteScaleX()) : digitalMinuteDrawable.get(0).getIntrinsicWidth();
            boolean supportScale2 = getSupportScale();
            int intrinsicHeight2 = digitalMinuteDrawable.get(0).getIntrinsicHeight();
            this.mMinCellHeight = supportScale2 ? (int) (intrinsicHeight2 * this.flatter.getAbsoluteScaleY()) : intrinsicHeight2;
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        List<Drawable> digitalSecondDrawable = this.flatter.getDigitalSecondDrawable();
        if (digitalSecondDrawable != null) {
            this.mSecNumCellWidth = getSupportScale() ? (int) (digitalSecondDrawable.get(0).getIntrinsicWidth() * this.flatter.getAbsoluteScaleX()) : digitalSecondDrawable.get(0).getIntrinsicWidth();
            boolean supportScale3 = getSupportScale();
            int intrinsicHeight3 = digitalSecondDrawable.get(0).getIntrinsicHeight();
            this.mSecNumCellHeight = supportScale3 ? (int) (intrinsicHeight3 * this.flatter.getAbsoluteScaleY()) : intrinsicHeight3;
            Unit unit7 = Unit.INSTANCE;
            Unit unit8 = Unit.INSTANCE;
        }
        Drawable digitalSplitDrawable = this.flatter.getDigitalSplitDrawable();
        if (digitalSplitDrawable != null) {
            if (getSupportScale()) {
                intrinsicWidth = digitalSplitDrawable.getIntrinsicWidth() * this.flatter.getScaleX();
                scaleX = this.flatter.getAbsoluteScaleX();
            } else {
                intrinsicWidth = digitalSplitDrawable.getIntrinsicWidth();
                scaleX = this.flatter.getScaleX();
            }
            this.mHourSpltWidth = (int) (intrinsicWidth * scaleX);
            boolean supportScale4 = getSupportScale();
            float intrinsicHeight4 = digitalSplitDrawable.getIntrinsicHeight();
            if (supportScale4) {
                intrinsicHeight4 *= this.flatter.getScaleY();
                scaleY = this.flatter.getAbsoluteScaleY();
            } else {
                scaleY = this.flatter.getScaleY();
            }
            this.mHourSpltHeight = (int) (intrinsicHeight4 * scaleY);
            Unit unit9 = Unit.INSTANCE;
            Unit unit10 = Unit.INSTANCE;
        }
        Drawable digitalSplit2Drawable = this.flatter.getDigitalSplit2Drawable();
        if (digitalSplit2Drawable != null) {
            this.mMinSpltWidth = getSupportScale() ? (int) (digitalSplit2Drawable.getIntrinsicWidth() * this.flatter.getScaleX() * this.flatter.getAbsoluteScaleX()) : digitalSplit2Drawable.getIntrinsicWidth() * ((int) this.flatter.getScaleX());
            boolean supportScale5 = getSupportScale();
            int intrinsicHeight5 = digitalSplit2Drawable.getIntrinsicHeight();
            this.mMinSpltHeight = supportScale5 ? (int) (intrinsicHeight5 * this.flatter.getScaleY() * this.flatter.getAbsoluteScaleY()) : intrinsicHeight5 * ((int) this.flatter.getScaleY());
            Unit unit11 = Unit.INSTANCE;
            Unit unit12 = Unit.INSTANCE;
        }
        if (this.flatter.getConfig().getOpen_time_arc_show() != 0) {
            ClockConfigFlatter clockConfigFlatter = this.flatter;
            clockConfigFlatter.setPosition(this.timeArcCenterPosition, clockConfigFlatter.getConfig().getTime_arc_center_x(), this.flatter.getConfig().getTime_arc_center_y());
            this.mCircleX = this.timeArcCenterPosition.x;
            this.mCircleY = this.timeArcCenterPosition.y;
            int i3 = this.flatter.getDigitalHourPosition().x;
            int i4 = this.flatter.getDigitalHourPosition().y;
            double d = ((double) i3) - ((double) this.mCircleX);
            double d2 = ((double) i4) - ((double) this.mCircleY);
            double dSqrt = Math.sqrt((d * d) + (d2 * d2));
            this.mCircleR = dSqrt;
            double dAcos = Math.acos(d / dSqrt);
            this.mStartArc = dAcos;
            if (i4 > this.mCircleY) {
                this.mStartArc = 6.283185307179586d - dAcos;
            }
            double d3 = 1.5707963267948966d - this.mStartArc;
            this.mStartArc = d3;
            if (d3 < 0.0d) {
                this.mStartArc = d3 + 6.283185307179586d;
            }
            this.mStartTimeArc = this.mStartArc;
            if (this.flatter.getConfig().getTime_arc_type() != 0) {
                this.mExtraAngle = PduHeaders.RECOMMENDED_RETRIEVAL_MODE;
                this.mExtraAngleTime = PduHeaders.RECOMMENDED_RETRIEVAL_MODE;
                double d4 = this.mCircleR;
                double dCalculateTempLen_180 = calculateTempLen_180(this.mTimeCellWidth, d4, this.mTimeCellHeight);
                int i5 = this.mMinCellWidth;
                double dCalculateTempLen_181 = calculateTempLen_180(i5, d4, i5);
                double dCalculateTempLen_182 = calculateTempLen_180(this.mSecNumCellWidth, d4, this.mSecNumCellHeight);
                double dCalculateTempLen_183 = calculateTempLen_180(this.mHourSpltWidth, d4, this.mHourSpltHeight);
                double dCalculateTempLen_184 = calculateTempLen_180(this.mMinSpltWidth, d4, this.mMinSpltHeight);
                this.mSubArcHourNum = Math.acos(((Math.pow((((double) this.mTimeCellHeight) / 2.0d) + this.mCircleR, 2.0d) + Math.pow(dCalculateTempLen_180, 2.0d)) - Math.pow(((double) this.mTimeCellWidth) / 2.0d, 2.0d)) / (((this.mCircleR + (((double) this.mTimeCellHeight) / 2.0d)) * 2.0d) * dCalculateTempLen_180));
                this.mSubArcMinNum = Math.acos(((Math.pow((((double) this.mMinCellWidth) / 2.0d) + this.mCircleR, 2.0d) + Math.pow(dCalculateTempLen_181, 2.0d)) - Math.pow(((double) this.mMinCellWidth) / 2.0d, 2.0d)) / (((this.mCircleR + (((double) this.mMinCellHeight) / 2.0d)) * 2.0d) * dCalculateTempLen_181));
                this.mSubArcSecNum = Math.acos(((Math.pow((((double) this.mSecNumCellHeight) / 2.0d) + this.mCircleR, 2.0d) + Math.pow(dCalculateTempLen_182, 2.0d)) - Math.pow(((double) this.mSecNumCellWidth) / 2.0d, 2.0d)) / (((this.mCircleR + (((double) this.mSecNumCellHeight) / 2.0d)) * 2.0d) * dCalculateTempLen_182));
                this.mSubArcSpltHour = Math.acos(((Math.pow((((double) this.mHourSpltHeight) / 2.0d) + this.mCircleR, 2.0d) + Math.pow(dCalculateTempLen_183, 2.0d)) - Math.pow(((double) this.mHourSpltWidth) / 2.0d, 2.0d)) / (((this.mCircleR + (((double) this.mHourSpltHeight) / 2.0d)) * 2.0d) * dCalculateTempLen_183));
                double dAcos2 = Math.acos(((Math.pow((((double) this.mMinSpltHeight) / 2.0d) + this.mCircleR, 2.0d) + Math.pow(dCalculateTempLen_184, 2.0d)) - Math.pow(((double) this.mMinSpltWidth) / 2.0d, 2.0d)) / (((this.mCircleR + (((double) this.mMinSpltHeight) / 2.0d)) * 2.0d) * dCalculateTempLen_184));
                this.mSubArcHourNum = -this.mSubArcHourNum;
                this.mSubArcMinNum = -this.mSubArcMinNum;
                this.mSubArcSecNum = -this.mSubArcSecNum;
                this.mSubArcSpltHour = -this.mSubArcSpltHour;
                this.mSubArcSpltMin = -dAcos2;
                return;
            }
            this.mExtraAngle = 0;
            this.mExtraAngleTime = 0;
            double d5 = this.mCircleR;
            double dCalculateTempLen = calculateTempLen(this.mTimeCellWidth, d5, this.mTimeCellHeight);
            int i6 = this.mMinCellWidth;
            double dCalculateTempLen2 = calculateTempLen(i6, d5, i6);
            double dCalculateTempLen3 = calculateTempLen(this.mSecNumCellWidth, d5, this.mSecNumCellHeight);
            double dCalculateTempLen4 = calculateTempLen(this.mHourSpltWidth, d5, this.mHourSpltHeight);
            double dCalculateTempLen5 = calculateTempLen(this.mMinSpltWidth, d5, this.mMinSpltHeight);
            this.mSubArcHourNum = calculateSubArc(this.mTimeCellWidth, d5, this.mTimeCellHeight, dCalculateTempLen);
            int i7 = this.mMinCellWidth;
            this.mSubArcMinNum = calculateSubArc(i7, d5, i7, dCalculateTempLen2);
            this.mSubArcSecNum = calculateSubArc(this.mSecNumCellWidth, d5, this.mSecNumCellHeight, dCalculateTempLen3);
            this.mSubArcSpltHour = calculateSubArc(this.mHourSpltWidth, d5, this.mHourSpltHeight, dCalculateTempLen4);
            this.mSubArcSpltMin = calculateSubArc(this.mMinSpltWidth, d5, this.mMinSpltHeight, dCalculateTempLen5);
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
    }

    public final float getScale() {
        return this.scale;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final int getMCircleX() {
        return this.mCircleX;
    }

    public final void setMCircleX(int i) {
        this.mCircleX = i;
    }

    public final int getMCircleY() {
        return this.mCircleY;
    }

    public final void setMCircleY(int i) {
        this.mCircleY = i;
    }

    public final double getMCircleR() {
        return this.mCircleR;
    }

    public final void setMCircleR(double d) {
        this.mCircleR = d;
    }

    public final double getMStartArc() {
        return this.mStartArc;
    }

    public final void setMStartArc(double d) {
        this.mStartArc = d;
    }

    public final int getMExtraAngle() {
        return this.mExtraAngle;
    }

    public final void setMExtraAngle(int i) {
        this.mExtraAngle = i;
    }

    public final int getMTimeCellHeight() {
        return this.mTimeCellHeight;
    }

    public final void setMTimeCellHeight(int i) {
        this.mTimeCellHeight = i;
    }

    public final int getMTimeCellWidth() {
        return this.mTimeCellWidth;
    }

    public final void setMTimeCellWidth(int i) {
        this.mTimeCellWidth = i;
    }

    public final int getMSecNumCellHeight() {
        return this.mSecNumCellHeight;
    }

    public final void setMSecNumCellHeight(int i) {
        this.mSecNumCellHeight = i;
    }

    public final int getMSecNumCellWidth() {
        return this.mSecNumCellWidth;
    }

    public final void setMSecNumCellWidth(int i) {
        this.mSecNumCellWidth = i;
    }

    public final int getMMinCellHeight() {
        return this.mMinCellHeight;
    }

    public final void setMMinCellHeight(int i) {
        this.mMinCellHeight = i;
    }

    public final int getMMinCellWidth() {
        return this.mMinCellWidth;
    }

    public final void setMMinCellWidth(int i) {
        this.mMinCellWidth = i;
    }

    public final int getMExtraAngleTime() {
        return this.mExtraAngleTime;
    }

    public final void setMExtraAngleTime(int i) {
        this.mExtraAngleTime = i;
    }

    public final int getMHourSpltHeight() {
        return this.mHourSpltHeight;
    }

    public final void setMHourSpltHeight(int i) {
        this.mHourSpltHeight = i;
    }

    public final int getMHourSpltWidth() {
        return this.mHourSpltWidth;
    }

    public final void setMHourSpltWidth(int i) {
        this.mHourSpltWidth = i;
    }

    public final int getMMinSpltHeight() {
        return this.mMinSpltHeight;
    }

    public final void setMMinSpltHeight(int i) {
        this.mMinSpltHeight = i;
    }

    public final int getMMinSpltWidth() {
        return this.mMinSpltWidth;
    }

    public final void setMMinSpltWidth(int i) {
        this.mMinSpltWidth = i;
    }

    public final double getMStartTimeArc() {
        return this.mStartTimeArc;
    }

    public final void setMStartTimeArc(double d) {
        this.mStartTimeArc = d;
    }

    public final double getMSubArcSecNum() {
        return this.mSubArcSecNum;
    }

    public final void setMSubArcSecNum(double d) {
        this.mSubArcSecNum = d;
    }

    public final double getMSubArcMinNum() {
        return this.mSubArcMinNum;
    }

    public final void setMSubArcMinNum(double d) {
        this.mSubArcMinNum = d;
    }

    public final double getMSubArcSpltMin() {
        return this.mSubArcSpltMin;
    }

    public final void setMSubArcSpltMin(double d) {
        this.mSubArcSpltMin = d;
    }

    public final double getMSubArcSpltHour() {
        return this.mSubArcSpltHour;
    }

    public final void setMSubArcSpltHour(double d) {
        this.mSubArcSpltHour = d;
    }

    public final double getMSubArcHourNum() {
        return this.mSubArcHourNum;
    }

    public final void setMSubArcHourNum(double d) {
        this.mSubArcHourNum = d;
    }

    public final Drawable getPointerSecondDrawable() {
        return this.pointerSecondDrawable;
    }

    public final void setPointerSecondDrawable(Drawable drawable) {
        this.pointerSecondDrawable = drawable;
    }

    public final Point getTimeArcCenterPosition() {
        return this.timeArcCenterPosition;
    }

    public final void setTimeArcCenterPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.timeArcCenterPosition = point;
    }

    public final int getSecbitmapCountSum() {
        return this.secbitmapCountSum;
    }

    public final void setSecbitmapCountSum(int i) {
        this.secbitmapCountSum = i;
    }

    public final int getSecBitmapInterval() {
        return this.secBitmapInterval;
    }

    public final void setSecBitmapInterval(int i) {
        this.secBitmapInterval = i;
    }

    public final int getSecCurrentSecDrawableIndex() {
        return this.secCurrentSecDrawableIndex;
    }

    public final void setSecCurrentSecDrawableIndex(int i) {
        this.secCurrentSecDrawableIndex = i;
    }

    public final int getDigitStartAnimationMaxTime() {
        return this.digitStartAnimationMaxTime;
    }

    /* JADX INFO: renamed from: isPointerStartAnimation, reason: from getter */
    public final boolean getIsPointerStartAnimation() {
        return this.isPointerStartAnimation;
    }

    public final void setPointerStartAnimation(boolean z) {
        this.isPointerStartAnimation = z;
    }

    /* JADX INFO: renamed from: isDigitalStartAnimation, reason: from getter */
    public final boolean getIsDigitalStartAnimation() {
        return this.isDigitalStartAnimation;
    }

    public final void setDigitalStartAnimation(boolean z) {
        this.isDigitalStartAnimation = z;
    }

    public final long getDigitalAnimationStartTime() {
        return this.digitalAnimationStartTime;
    }

    public final void setDigitalAnimationStartTime(long j) {
        this.digitalAnimationStartTime = j;
    }

    public final long getPointerAnimationStartTime() {
        return this.pointerAnimationStartTime;
    }

    public final void setPointerAnimationStartTime(long j) {
        this.pointerAnimationStartTime = j;
    }

    public final SpecialTimeDrawer getSpecialDrawPainter() {
        return this.specialDrawPainter;
    }

    public final void setSpecialDrawPainter(SpecialTimeDrawer specialTimeDrawer) {
        this.specialDrawPainter = specialTimeDrawer;
    }

    public final int getCurrentStyle() {
        return this.currentStyle;
    }

    public final void setCurrentStyle(int i) {
        this.currentStyle = i;
    }

    public final DragonBollTimePainter getDragonBollTimePainter() {
        return this.dragonBollTimePainter;
    }

    public final void setDragonBollTimePainter(DragonBollTimePainter dragonBollTimePainter) {
        this.dragonBollTimePainter = dragonBollTimePainter;
    }

    public final Point getDigitHour2Position() {
        return this.digitHour2Position;
    }

    public final void setDigitHour2Position(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.digitHour2Position = point;
    }

    public final List<Drawable> getDigitHour2SplitDrawable() {
        return this.digitHour2SplitDrawable;
    }

    public final void setDigitHour2SplitDrawable(List<? extends Drawable> list) {
        this.digitHour2SplitDrawable = list;
    }

    public final Point getDigitMin2Position() {
        return this.digitMin2Position;
    }

    public final void setDigitMin2Position(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.digitMin2Position = point;
    }

    public final List<Drawable> getDigitMin2SplitDrawable() {
        return this.digitMin2SplitDrawable;
    }

    public final void setDigitMin2SplitDrawable(List<? extends Drawable> list) {
        this.digitMin2SplitDrawable = list;
    }

    public final Point getChineseTimePosition() {
        return this.chineseTimePosition;
    }

    public final void setChineseTimePosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.chineseTimePosition = point;
    }

    public final List<Drawable> getChineseTimePositionDrawable() {
        return this.chineseTimePositionDrawable;
    }

    public final void setChineseTimePositionDrawable(List<? extends Drawable> list) {
        this.chineseTimePositionDrawable = list;
    }

    public final Point getDigitSec2Position() {
        return this.digitSec2Position;
    }

    public final void setDigitSec2Position(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.digitSec2Position = point;
    }

    public final List<Drawable> getDigitSec2SplitDrawable() {
        return this.digitSec2SplitDrawable;
    }

    public final void setDigitSec2SplitDrawable(List<? extends Drawable> list) {
        this.digitSec2SplitDrawable = list;
    }

    private final double calculateTempLen_180(int width, double radius, int height) {
        double d = ((double) width) / 2.0d;
        double d2 = (((double) height) / 2.0d) + radius;
        return Math.sqrt((d * d) + (d2 * d2));
    }

    private final double calculateTempLen(int width, double radius, int height) {
        double d = ((double) width) / 2.0d;
        double d2 = radius - (((double) height) / 2.0d);
        return Math.sqrt((d * d) + (d2 * d2));
    }

    private final double calculateSubArc(int wdith, double radius, int height, double tempLen) {
        double d = radius - (((double) height) / 2.0d);
        double d2 = ((double) wdith) / 2.0d;
        return Math.acos((((d * d) + (tempLen * tempLen)) - (d2 * d2)) / ((d * 2.0d) * tempLen));
    }

    /* JADX WARN: Code duplicated, block: B:58:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:60:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:62:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:69:0x0202  */
    /* JADX WARN: Code duplicated, block: B:71:0x020c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0215  */
    /* JADX WARN: Code duplicated, block: B:76:0x021e  */
    /* JADX WARN: Code duplicated, block: B:79:0x0228  */
    /* JADX WARN: Code duplicated, block: B:80:0x022b  */
    /* JADX WARN: Code duplicated, block: B:83:0x0234  */
    /* JADX WARN: Code duplicated, block: B:86:0x0245  */
    /* JADX WARN: Code duplicated, block: B:89:0x0256  */
    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        int i;
        float fChangeAngle;
        List<Drawable> list;
        Drawable pointerHourDrawable;
        Drawable pointerMinuteDrawable;
        Point pointerSecondPosition;
        long jUptimeMillis;
        long j;
        int i2;
        Drawable pointerDotDrawable;
        DragonBollTimePainter dragonBollTimePainter;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.flatter.getConfig().getTime_special_new() == 1) {
            SpecialTimeDrawer specialTimeDrawer = this.specialDrawPainter;
            if (specialTimeDrawer != null) {
                specialTimeDrawer.draw(canvas, paint);
                return;
            }
            return;
        }
        if (this.flatter.getConfig().getTime_special_drag_3d() == 1 && (dragonBollTimePainter = this.dragonBollTimePainter) != null) {
            dragonBollTimePainter.draw(canvas, paint);
        }
        if (this.flatter.getConfig().getShow_chinse_time() == 1) {
            drawChinseTime(canvas);
        }
        if (this.flatter.getConfig().getOpen_time_arc_show() == 0) {
            drawTimeWithoutArc(canvas);
        } else {
            drawTimeWithArc(canvas);
        }
        Calendar calendar = Calendar.getInstance();
        ClockConfig config = this.flatter.getConfig();
        int i3 = calendar.get(10);
        int i4 = calendar.get(11);
        int i5 = calendar.get(12);
        int i6 = calendar.get(13);
        int i7 = calendar.get(14);
        boolean zIs24HourFormat = DateFormat.is24HourFormat(this.context);
        if (config.isPointerSupport()) {
            float fChangeAngle2 = config.isPointerSecondSmoothScroll() ? ((i6 * 360.0f) / 60) + ((i7 / 1000.0f) * 6) : (i6 * 360.0f) / 60;
            float f = i5;
            float f2 = 60;
            float f3 = i6;
            float fChangeAngle3 = ((f * 360.0f) / f2) + ((f3 * 6.0f) / f2);
            float f4 = 12;
            float f5 = ((i3 * 360.0f) / f4) + ((f * 30.0f) / f2) + (f3 / 120.0f);
            if (!this.isPointerStartAnimation) {
                this.pointerAnimationStartTime = 0L;
            } else {
                if (this.pointerAnimationStartTime != 0) {
                    int iCurrentTimeMillis = (int) (System.currentTimeMillis() - this.pointerAnimationStartTime);
                    if (iCurrentTimeMillis >= 0 && iCurrentTimeMillis <= this.pointerStartAnimationMaxTime) {
                        fChangeAngle2 = changeAngle(iCurrentTimeMillis, this.mStartSecondAngle, this.mSecondChangeAngle);
                        fChangeAngle3 = changeAngle(iCurrentTimeMillis, this.mStartMinuteAngle, this.mMinuteChangeAngle);
                        fChangeAngle = changeAngle(iCurrentTimeMillis, this.mStartHourAngle, this.mHourChangeAngle);
                    } else {
                        this.isPointerStartAnimation = false;
                        this.pointerAnimationStartTime = 0L;
                    }
                } else {
                    this.pointerAnimationStartTime = System.currentTimeMillis();
                    int pointer_start_hour = this.flatter.getConfig().getPointer_start_hour();
                    int pointer_start_minute = this.flatter.getConfig().getPointer_start_minute();
                    int pointer_start_second = this.flatter.getConfig().getPointer_start_second();
                    float f6 = config.isPointerSecondSmoothScroll() ? ((pointer_start_second * 360.0f) / f2) + (((i7 + this.pointerStartAnimationMaxTime) / 1000.0f) * 6) : (pointer_start_second * 360.0f) / f2;
                    float f7 = pointer_start_minute;
                    float f8 = pointer_start_second;
                    float f9 = ((f7 * 360.0f) / f2) + ((6.0f * f8) / f2);
                    float f10 = ((pointer_start_hour * 360.0f) / f4) + ((f7 * 30.0f) / f2) + (f8 / 120.0f);
                    this.mSecondChangeAngle = calculateChangeAngle(f6, fChangeAngle2, 1);
                    this.mMinuteChangeAngle = calculateChangeAngle(f9, fChangeAngle3, 2);
                    this.mHourChangeAngle = calculateChangeAngle(f10, f5, 3);
                    this.mStartHourAngle = f10;
                    this.mStartMinuteAngle = f9;
                    this.mStartSecondAngle = f6;
                    fChangeAngle3 = f9;
                    fChangeAngle2 = f6;
                    fChangeAngle = f10;
                }
                if (this.flatter.getConfig().getSecond_pointer_animal_type() != 2 || this.flatter.getConfig().getSecond_pointer_animal_type() == 1) {
                    list = this.secDrawables;
                    if (list != null) {
                        pointerSecondPosition = this.flatter.getPointerSecondPosition();
                        if (this.secbitmapCountSum != 0 && this.secCurrentSecDrawableIndex - 1 < list.size() && list.get(this.secCurrentSecDrawableIndex - 1) != null) {
                            drawPointer(canvas, list.get(this.secCurrentSecDrawableIndex - 1), pointerSecondPosition, fChangeAngle2);
                        }
                        jUptimeMillis = SystemClock.uptimeMillis();
                        j = this.lastDrawSecTime;
                        if (j != 0) {
                            i = i4;
                            if (jUptimeMillis - j < this.secBitmapInterval || jUptimeMillis - j < 0) {
                                i2 = 1;
                                this.secCurrentSecDrawableIndex++;
                                this.lastDrawSecTime = jUptimeMillis;
                            } else {
                                i2 = 1;
                            }
                        } else {
                            i = i4;
                            i2 = 1;
                            this.lastDrawSecTime = jUptimeMillis;
                        }
                        if (this.secCurrentSecDrawableIndex > this.secbitmapCountSum) {
                            this.secCurrentSecDrawableIndex = i2;
                        }
                    } else {
                        i = i4;
                    }
                    pointerHourDrawable = this.flatter.getPointerHourDrawable();
                    if (pointerHourDrawable != null) {
                        drawPointer(canvas, pointerHourDrawable, this.flatter.getPointerHourPosition(), fChangeAngle);
                    }
                    pointerMinuteDrawable = this.flatter.getPointerMinuteDrawable();
                    if (pointerMinuteDrawable != null) {
                        drawPointer(canvas, pointerMinuteDrawable, this.flatter.getPointerMinutePosition(), fChangeAngle3);
                    }
                } else {
                    Drawable pointerHourDrawable2 = this.flatter.getPointerHourDrawable();
                    if (pointerHourDrawable2 != null) {
                        drawPointer(canvas, pointerHourDrawable2, this.flatter.getPointerHourPosition(), fChangeAngle);
                    }
                    Drawable pointerMinuteDrawable2 = this.flatter.getPointerMinuteDrawable();
                    if (pointerMinuteDrawable2 != null) {
                        drawPointer(canvas, pointerMinuteDrawable2, this.flatter.getPointerMinutePosition(), fChangeAngle3);
                    }
                    Drawable drawable = this.pointerSecondDrawable;
                    if (drawable != null) {
                        drawPointer(canvas, drawable, this.flatter.getPointerSecondPosition(), fChangeAngle2);
                    }
                    i = i4;
                }
                pointerDotDrawable = this.flatter.getPointerDotDrawable();
                if (pointerDotDrawable != null) {
                    drawPointer(canvas, pointerDotDrawable, this.flatter.getPointerDotPosition(), 0.0f);
                }
            }
            fChangeAngle = f5;
            if (this.flatter.getConfig().getSecond_pointer_animal_type() != 2) {
                list = this.secDrawables;
                if (list != null) {
                    pointerSecondPosition = this.flatter.getPointerSecondPosition();
                    if (this.secbitmapCountSum != 0) {
                        drawPointer(canvas, list.get(this.secCurrentSecDrawableIndex - 1), pointerSecondPosition, fChangeAngle2);
                    }
                    jUptimeMillis = SystemClock.uptimeMillis();
                    j = this.lastDrawSecTime;
                    if (j != 0) {
                        i = i4;
                        if (jUptimeMillis - j < this.secBitmapInterval) {
                            i2 = 1;
                            this.secCurrentSecDrawableIndex++;
                            this.lastDrawSecTime = jUptimeMillis;
                        } else {
                            i2 = 1;
                            this.secCurrentSecDrawableIndex++;
                            this.lastDrawSecTime = jUptimeMillis;
                        }
                    } else {
                        i = i4;
                        i2 = 1;
                        this.lastDrawSecTime = jUptimeMillis;
                    }
                    if (this.secCurrentSecDrawableIndex > this.secbitmapCountSum) {
                        this.secCurrentSecDrawableIndex = i2;
                    }
                } else {
                    i = i4;
                }
                pointerHourDrawable = this.flatter.getPointerHourDrawable();
                if (pointerHourDrawable != null) {
                    drawPointer(canvas, pointerHourDrawable, this.flatter.getPointerHourPosition(), fChangeAngle);
                }
                pointerMinuteDrawable = this.flatter.getPointerMinuteDrawable();
                if (pointerMinuteDrawable != null) {
                    drawPointer(canvas, pointerMinuteDrawable, this.flatter.getPointerMinutePosition(), fChangeAngle3);
                }
            } else {
                list = this.secDrawables;
                if (list != null) {
                    pointerSecondPosition = this.flatter.getPointerSecondPosition();
                    if (this.secbitmapCountSum != 0) {
                        drawPointer(canvas, list.get(this.secCurrentSecDrawableIndex - 1), pointerSecondPosition, fChangeAngle2);
                    }
                    jUptimeMillis = SystemClock.uptimeMillis();
                    j = this.lastDrawSecTime;
                    if (j != 0) {
                        i = i4;
                        if (jUptimeMillis - j < this.secBitmapInterval) {
                            i2 = 1;
                            this.secCurrentSecDrawableIndex++;
                            this.lastDrawSecTime = jUptimeMillis;
                        } else {
                            i2 = 1;
                            this.secCurrentSecDrawableIndex++;
                            this.lastDrawSecTime = jUptimeMillis;
                        }
                    } else {
                        i = i4;
                        i2 = 1;
                        this.lastDrawSecTime = jUptimeMillis;
                    }
                    if (this.secCurrentSecDrawableIndex > this.secbitmapCountSum) {
                        this.secCurrentSecDrawableIndex = i2;
                    }
                } else {
                    i = i4;
                }
                pointerHourDrawable = this.flatter.getPointerHourDrawable();
                if (pointerHourDrawable != null) {
                    drawPointer(canvas, pointerHourDrawable, this.flatter.getPointerHourPosition(), fChangeAngle);
                }
                pointerMinuteDrawable = this.flatter.getPointerMinuteDrawable();
                if (pointerMinuteDrawable != null) {
                    drawPointer(canvas, pointerMinuteDrawable, this.flatter.getPointerMinutePosition(), fChangeAngle3);
                }
            }
            pointerDotDrawable = this.flatter.getPointerDotDrawable();
            if (pointerDotDrawable != null) {
                drawPointer(canvas, pointerDotDrawable, this.flatter.getPointerDotPosition(), 0.0f);
            }
        } else {
            i = i4;
        }
        if (!zIs24HourFormat) {
            List<Drawable> amPmDrawable = this.flatter.getAmPmDrawable();
            if (amPmDrawable == null || !config.showAmPm()) {
                return;
            }
            if (config.getShow_ampm_placeholer() == 1) {
                amPmDrawable = CollectionsKt.take(amPmDrawable, 2);
            }
            Drawable drawable2 = (Drawable) CollectionsKt.getOrNull(amPmDrawable, i / 12);
            if (drawable2 != null) {
                drawDrawable(canvas, drawable2, this.flatter.getAmPmPosition().x, this.flatter.getAmPmPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX, getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scaleY);
                return;
            }
            return;
        }
        List<Drawable> amPmDrawable2 = this.flatter.getAmPmDrawable();
        if (amPmDrawable2 == null || config.getShow_ampm_placeholer() != 1 || amPmDrawable2.size() <= 2) {
            return;
        }
        drawDrawable(canvas, amPmDrawable2.get(2), this.flatter.getAmPmPosition().x, this.flatter.getAmPmPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX, getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scaleY);
    }

    private final void drawChinseTime(Canvas canvas) {
        Drawable drawable;
        List<? extends Drawable> list = this.chineseTimePositionDrawable;
        if (list != null) {
            int i = Calendar.getInstance().get(11);
            if ((23 <= i && i < 25) || (i >= 0 && i < 1)) {
                drawable = list.get(0);
            } else if (1 <= i && i < 3) {
                drawable = list.get(1);
            } else if (3 <= i && i < 5) {
                drawable = list.get(2);
            } else if (5 <= i && i < 7) {
                drawable = list.get(3);
            } else if (7 <= i && i < 9) {
                drawable = list.get(4);
            } else if (9 <= i && i < 11) {
                drawable = list.get(5);
            } else if (11 <= i && i < 13) {
                drawable = list.get(6);
            } else if (13 <= i && i < 15) {
                drawable = list.get(7);
            } else if (15 <= i && i < 17) {
                drawable = list.get(8);
            } else if (17 <= i && i < 19) {
                drawable = list.get(9);
            } else if (19 <= i && i < 21) {
                drawable = list.get(10);
            } else if (21 <= i && i < 23) {
                drawable = list.get(11);
            } else {
                drawable = list.get(0);
            }
            drawDrawable(canvas, drawable, this.chineseTimePosition.x, this.chineseTimePosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX, getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scaleY);
        }
    }

    public final float changeAngle(int timeX, float oldAngle, float changeAngleSum) {
        float f;
        int i;
        int i2 = this.pointerStartAnimationMaxTime;
        if (timeX <= i2 / 2) {
            f = timeX * timeX * changeAngleSum;
            i = (i2 * i2) / 2;
        } else {
            f = (((-(timeX - i2)) * (timeX - i2)) + ((i2 * i2) / 2)) * changeAngleSum;
            i = (i2 * i2) / 2;
        }
        return (f / i) + oldAngle;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0356  */
    /* JADX WARN: Code duplicated, block: B:101:0x0364  */
    /* JADX WARN: Code duplicated, block: B:105:0x0380  */
    /* JADX WARN: Code duplicated, block: B:106:0x038e  */
    /* JADX WARN: Code duplicated, block: B:110:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:112:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:113:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:116:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:118:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:121:0x03f1 A[LOOP:1: B:120:0x03ef->B:121:0x03f1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:123:0x0421  */
    /* JADX WARN: Code duplicated, block: B:125:0x042b  */
    /* JADX WARN: Code duplicated, block: B:128:0x043d  */
    /* JADX WARN: Code duplicated, block: B:131:0x0471 A[LOOP:4: B:129:0x046b->B:131:0x0471, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:133:0x049d  */
    /* JADX WARN: Code duplicated, block: B:135:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:138:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:142:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:144:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:145:0x04c9  */
    /* JADX WARN: Code duplicated, block: B:148:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:149:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:153:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:154:0x050d  */
    /* JADX WARN: Code duplicated, block: B:158:0x0522  */
    /* JADX WARN: Code duplicated, block: B:160:0x0528  */
    /* JADX WARN: Code duplicated, block: B:161:0x053b  */
    /* JADX WARN: Code duplicated, block: B:164:0x0551  */
    /* JADX WARN: Code duplicated, block: B:166:0x055b  */
    /* JADX WARN: Code duplicated, block: B:169:0x0572 A[LOOP:2: B:168:0x0570->B:169:0x0572, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:171:0x05a0  */
    /* JADX WARN: Code duplicated, block: B:173:0x05aa  */
    /* JADX WARN: Code duplicated, block: B:176:0x05bc  */
    /* JADX WARN: Code duplicated, block: B:179:0x05f2 A[LOOP:3: B:177:0x05ec->B:179:0x05f2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:183:0x0628  */
    /* JADX WARN: Code duplicated, block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0117  */
    /* JADX WARN: Code duplicated, block: B:54:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:56:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:61:0x021e  */
    /* JADX WARN: Code duplicated, block: B:64:0x022d  */
    /* JADX WARN: Code duplicated, block: B:65:0x0234  */
    /* JADX WARN: Code duplicated, block: B:67:0x0242  */
    /* JADX WARN: Code duplicated, block: B:70:0x0250  */
    /* JADX WARN: Code duplicated, block: B:72:0x025a  */
    /* JADX WARN: Code duplicated, block: B:75:0x0270 A[LOOP:0: B:74:0x026e->B:75:0x0270, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:79:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:81:0x02af  */
    /* JADX WARN: Code duplicated, block: B:85:0x02f1 A[LOOP:5: B:83:0x02eb->B:85:0x02f1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x0320  */
    /* JADX WARN: Code duplicated, block: B:90:0x032b  */
    /* JADX WARN: Code duplicated, block: B:94:0x0335  */
    /* JADX WARN: Code duplicated, block: B:96:0x033b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0349  */
    private final void drawTimeWithoutArc(Canvas canvas) {
        Integer[] numArr;
        Integer[] numArr2;
        List<Drawable> digitalHourDrawable;
        int i;
        Drawable digitalSplitDrawable;
        List<Drawable> digitalMinuteDrawable;
        int i2;
        Drawable digitalSplit2Drawable;
        List<Drawable> digitalSecondDrawable;
        int i3;
        int i4;
        float absoluteScaleX;
        float absoluteScaleY;
        float f;
        float f2;
        List<? extends Drawable> list;
        int i5;
        Iterator it;
        int i6;
        float absoluteScaleX2;
        float absoluteScaleY2;
        float f3;
        float f4;
        int i7;
        int i8;
        float scaleX;
        float scaleY;
        float scaleX2;
        int i9;
        int i10;
        float absoluteScaleX3;
        float absoluteScaleY3;
        float f5;
        float f6;
        List<? extends Drawable> list2;
        int i11;
        int i12;
        Iterator it2;
        int i13;
        float absoluteScaleX4;
        float absoluteScaleY4;
        float f7;
        float f8;
        int i14;
        int i15;
        float scaleX3;
        float scaleY2;
        float scaleX4;
        List<? extends Drawable> list3;
        float absoluteScaleX5;
        float absoluteScaleY5;
        float f9;
        float f10;
        int i16;
        Iterator it3;
        int i17;
        float absoluteScaleX6;
        float absoluteScaleY6;
        float f11;
        float f12;
        int i18;
        int i19;
        List<Drawable> digitalHourDrawable2;
        Integer numValueOf;
        float absoluteScaleX7;
        Drawable drawable;
        Integer[] numArr3;
        Integer[] numArr4;
        Calendar calendar = Calendar.getInstance();
        ClockConfig config = this.flatter.getConfig();
        int i20 = calendar.get(13);
        boolean zIs24HourFormat = DateFormat.is24HourFormat(this.context);
        calendar.get(9);
        if (config.isDigitalSupport()) {
            int i21 = this.flatter.getDigitalHourPosition().x;
            int i22 = this.flatter.getDigitalHourPosition().y;
            if (!zIs24HourFormat) {
                int i23 = calendar.get(10);
                if (i23 == 0) {
                    i23 = 12;
                }
                numArr = new Integer[]{Integer.valueOf(i23 / 10), Integer.valueOf(i23 % 10)};
            } else {
                int i24 = calendar.get(11);
                numArr = new Integer[]{Integer.valueOf(i24 / 10), Integer.valueOf(i24 % 10)};
            }
            int i25 = calendar.get(12);
            Integer[] numArr5 = {Integer.valueOf(i25 / 10), Integer.valueOf(i25 % 10)};
            int i26 = calendar.get(13);
            Integer[] numArr6 = {Integer.valueOf(i26 / 10), Integer.valueOf(i26 % 10)};
            if (this.isDigitalStartAnimation) {
                int digital_start_hour = this.flatter.getConfig().getDigital_start_hour();
                int digital_start_minute = this.flatter.getConfig().getDigital_start_minute();
                int digital_start_second = this.flatter.getConfig().getDigital_start_second();
                if (this.digitalAnimationStartTime != 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.digitalAnimationStartTime;
                    if (0 <= jCurrentTimeMillis) {
                        int i27 = this.digitStartAnimationMaxTime;
                        if (jCurrentTimeMillis <= i27) {
                            int i28 = (int) (((((long) this.mSecondChangeNum) * jCurrentTimeMillis) / ((long) i27)) + ((long) digital_start_second));
                            int i29 = (int) (((((long) this.mMinuteChangeNum) * jCurrentTimeMillis) / ((long) i27)) + ((long) digital_start_minute));
                            int i30 = (int) (((((long) this.mHourChangeNum) * jCurrentTimeMillis) / ((long) i27)) + ((long) digital_start_hour));
                            if (i28 < 0) {
                                i28 = -i28;
                            } else if (i28 > 59) {
                                i28 -= 60;
                            }
                            if (i29 < 0) {
                                i29 = -i29;
                            } else if (i29 > 59) {
                                i29 -= 60;
                            }
                            if (zIs24HourFormat) {
                                if (i30 < 0) {
                                    i30 = -i30;
                                } else if (i30 > 23) {
                                    i30 -= 24;
                                }
                            } else if (i30 < 0) {
                                i30 = -i30;
                            } else if (i30 > 11) {
                                i30 -= 12;
                            }
                            numArr2 = new Integer[]{Integer.valueOf(i30 / 10), Integer.valueOf(i30 % 10)};
                            numArr3 = new Integer[]{Integer.valueOf(i29 / 10), Integer.valueOf(i29 % 10)};
                            numArr4 = new Integer[]{Integer.valueOf(i28 / 10), Integer.valueOf(i28 % 10)};
                        }
                    }
                    this.isDigitalStartAnimation = false;
                    this.digitalAnimationStartTime = 0L;
                } else {
                    if (digital_start_hour > 12 && !zIs24HourFormat) {
                        digital_start_hour -= 12;
                    }
                    this.mSecondChangeNum = calculateChangeNum(1, digital_start_second, i26, zIs24HourFormat);
                    this.mMinuteChangeNum = calculateChangeNum(2, digital_start_minute, i25, zIs24HourFormat);
                    this.mHourChangeNum = calculateChangeNum(3, digital_start_hour, calendar.get(10), zIs24HourFormat);
                    numArr2 = new Integer[]{Integer.valueOf(digital_start_hour / 10), Integer.valueOf(digital_start_hour % 10)};
                    numArr3 = new Integer[]{Integer.valueOf(digital_start_minute / 10), Integer.valueOf(digital_start_minute % 10)};
                    numArr4 = new Integer[]{Integer.valueOf(digital_start_second / 10), Integer.valueOf(digital_start_second % 10)};
                    this.digitalAnimationStartTime = System.currentTimeMillis();
                }
                numArr5 = numArr3;
                numArr6 = numArr4;
                digitalHourDrawable = this.flatter.getDigitalHourDrawable();
                if (digitalHourDrawable == null) {
                    if (this.flatter.getConfig().getTime_rotate() == 1) {
                        canvas.save();
                        float time_rotate_degree = this.flatter.getConfig().getTime_rotate_degree();
                        float f13 = i21;
                        digitalHourDrawable2 = this.flatter.getDigitalHourDrawable();
                        if (digitalHourDrawable2 != null || (drawable = digitalHourDrawable2.get(0)) == null) {
                            numValueOf = null;
                        } else {
                            numValueOf = Integer.valueOf(drawable.getIntrinsicWidth());
                        }
                        Intrinsics.checkNotNull(numValueOf);
                        float fIntValue = numValueOf.intValue();
                        if (getSupportScale()) {
                            absoluteScaleX7 = this.flatter.getAbsoluteScaleX();
                        } else {
                            absoluteScaleX7 = 1.0f;
                        }
                        canvas.rotate(time_rotate_degree, f13 + ((fIntValue * absoluteScaleX7) / 2), i22);
                    }
                    if (this.flatter.getConfig().getNeed_split_hour() == 0) {
                        absoluteScaleX6 = this.scaleX;
                        absoluteScaleY6 = this.scaleY;
                        if (getSupportScale()) {
                            absoluteScaleX6 = this.flatter.getAbsoluteScaleX();
                            absoluteScaleY6 = this.flatter.getAbsoluteScaleY();
                        }
                        f11 = absoluteScaleX6;
                        f12 = absoluteScaleY6;
                        i18 = i21;
                        for (Integer num : numArr2) {
                            Drawable drawable2 = digitalHourDrawable.get(num.intValue());
                            int intrinsicWidth = (int) (drawable2.getIntrinsicWidth() * f11);
                            drawDrawable(canvas, drawable2, i18, i22, f11, f12);
                            i18 += intrinsicWidth;
                        }
                        Unit unit = Unit.INSTANCE;
                        i21 = i18;
                    } else {
                        list3 = this.digitHour2SplitDrawable;
                        if (list3 != null) {
                            absoluteScaleX5 = this.scaleX;
                            absoluteScaleY5 = this.scaleY;
                            if (getSupportScale()) {
                                absoluteScaleX5 = this.flatter.getAbsoluteScaleX();
                                absoluteScaleY5 = this.flatter.getAbsoluteScaleY();
                            }
                            f9 = absoluteScaleX5;
                            f10 = absoluteScaleY5;
                            drawDrawable(canvas, digitalHourDrawable.get(numArr2[0].intValue()), i21, i22, f9, f10);
                            int i31 = this.digitHour2Position.x;
                            i16 = this.digitHour2Position.y;
                            it3 = ArraysKt.drop(numArr2, 1).iterator();
                            i17 = i31;
                            while (it3.hasNext()) {
                                Drawable drawable3 = list3.get(((Number) it3.next()).intValue());
                                int intrinsicWidth2 = (int) (drawable3.getIntrinsicWidth() * f9);
                                drawDrawable(canvas, drawable3, i17, i16, f9, f10);
                                i17 += intrinsicWidth2;
                            }
                            Unit unit2 = Unit.INSTANCE;
                            Unit unit3 = Unit.INSTANCE;
                            i22 = i16;
                            i21 = i17;
                        }
                    }
                }
                i = i21;
                digitalSplitDrawable = this.flatter.getDigitalSplitDrawable();
                if (digitalSplitDrawable != null) {
                    if (config.timeSplitNeedJump() || i20 % 2 == 0) {
                        if (getSupportScale()) {
                            scaleX3 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                        } else {
                            scaleX3 = this.flatter.getScaleX();
                        }
                        float f14 = scaleX3;
                        if (getSupportScale()) {
                            scaleY2 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                        } else {
                            scaleY2 = this.flatter.getScaleY();
                        }
                        drawDrawable(canvas, digitalSplitDrawable, i, i22, f14, scaleY2);
                    }
                    float intrinsicWidth3 = digitalSplitDrawable.getIntrinsicWidth();
                    if (getSupportScale()) {
                        scaleX4 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                    } else {
                        scaleX4 = this.flatter.getScaleX();
                    }
                    i += (int) (intrinsicWidth3 * scaleX4);
                    Unit unit4 = Unit.INSTANCE;
                    Unit unit5 = Unit.INSTANCE;
                }
                digitalMinuteDrawable = this.flatter.getDigitalMinuteDrawable();
                if (digitalMinuteDrawable != null) {
                    if (!config.isDigitalMinuteAutomatic()) {
                        i9 = this.flatter.getDigitalMinutePosition().x;
                        i10 = this.flatter.getDigitalMinutePosition().y;
                    } else {
                        i9 = i;
                        i10 = this.flatter.getDigitalHourPosition().y;
                    }
                    if (this.flatter.getConfig().getNeed_split_min() == 0) {
                        absoluteScaleX4 = this.scaleX;
                        absoluteScaleY4 = this.scaleY;
                        if (getSupportScale()) {
                            absoluteScaleX4 = this.flatter.getAbsoluteScaleX();
                            absoluteScaleY4 = this.flatter.getAbsoluteScaleY();
                        }
                        f7 = absoluteScaleX4;
                        f8 = absoluteScaleY4;
                        i14 = i9;
                        for (Integer num2 : numArr5) {
                            Drawable drawable4 = digitalMinuteDrawable.get(num2.intValue());
                            int intrinsicWidth4 = (int) (drawable4.getIntrinsicWidth() * f7);
                            drawDrawable(canvas, drawable4, i14, i10, f7, f8);
                            i14 += intrinsicWidth4;
                        }
                        Unit unit6 = Unit.INSTANCE;
                        i11 = i10;
                        i = i14;
                    } else {
                        absoluteScaleX3 = this.scaleX;
                        absoluteScaleY3 = this.scaleY;
                        if (getSupportScale()) {
                            absoluteScaleX3 = this.flatter.getAbsoluteScaleX();
                            absoluteScaleY3 = this.flatter.getAbsoluteScaleY();
                        }
                        f5 = absoluteScaleX3;
                        f6 = absoluteScaleY3;
                        list2 = this.digitMin2SplitDrawable;
                        if (list2 != null) {
                            drawDrawable(canvas, digitalMinuteDrawable.get(numArr5[0].intValue()), i9, i10, f5, f6);
                            int i32 = this.digitMin2Position.x;
                            i12 = this.digitMin2Position.y;
                            it2 = ArraysKt.drop(numArr5, 1).iterator();
                            i13 = i32;
                            while (it2.hasNext()) {
                                Drawable drawable5 = list2.get(((Number) it2.next()).intValue());
                                int intrinsicWidth5 = (int) (drawable5.getIntrinsicWidth() * f5);
                                drawDrawable(canvas, drawable5, i13, i12, f5, f6);
                                i13 += intrinsicWidth5;
                            }
                            Unit unit7 = Unit.INSTANCE;
                            Unit unit8 = Unit.INSTANCE;
                            i11 = i12;
                            i = i13;
                        } else {
                            i11 = i10;
                            i = i9;
                        }
                    }
                    i2 = i11;
                } else {
                    i2 = i22;
                }
                digitalSplit2Drawable = this.flatter.getDigitalSplit2Drawable();
                if (digitalSplit2Drawable != null) {
                    if (config.timeSplitNeedJump() || i20 % 2 == 0) {
                        if (getSupportScale()) {
                            scaleX = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                        } else {
                            scaleX = this.flatter.getScaleX();
                        }
                        float f15 = scaleX;
                        if (getSupportScale()) {
                            scaleY = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                        } else {
                            scaleY = this.flatter.getScaleY();
                        }
                        drawDrawable(canvas, digitalSplit2Drawable, i, i2, f15, scaleY);
                    }
                    float intrinsicWidth6 = digitalSplit2Drawable.getIntrinsicWidth();
                    if (getSupportScale()) {
                        scaleX2 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                    } else {
                        scaleX2 = this.flatter.getScaleX();
                    }
                    i += (int) (intrinsicWidth6 * scaleX2);
                    Unit unit9 = Unit.INSTANCE;
                    Unit unit10 = Unit.INSTANCE;
                }
                digitalSecondDrawable = this.flatter.getDigitalSecondDrawable();
                if (digitalSecondDrawable != null) {
                    if (!config.isDigitalSecondAutomatic()) {
                        i3 = this.flatter.getDigitalSecondPosition().x;
                        i4 = this.flatter.getDigitalSecondPosition().y;
                    } else {
                        i3 = i;
                        i4 = this.flatter.getDigitalHourPosition().y;
                    }
                    if (this.flatter.getConfig().getNeed_split_sec() == 0) {
                        absoluteScaleX2 = this.scaleX;
                        absoluteScaleY2 = this.scaleY;
                        if (getSupportScale()) {
                            absoluteScaleX2 = this.flatter.getAbsoluteScaleX();
                            absoluteScaleY2 = this.flatter.getAbsoluteScaleY();
                        }
                        f3 = absoluteScaleX2;
                        f4 = absoluteScaleY2;
                        i7 = i3;
                        for (Integer num3 : numArr6) {
                            Drawable drawable6 = digitalSecondDrawable.get(num3.intValue());
                            int intrinsicWidth7 = (int) (drawable6.getIntrinsicWidth() * f3);
                            drawDrawable(canvas, drawable6, i7, i4, f3, f4);
                            i7 += intrinsicWidth7;
                        }
                        Unit unit11 = Unit.INSTANCE;
                    } else {
                        absoluteScaleX = this.scaleX;
                        absoluteScaleY = this.scaleY;
                        if (getSupportScale()) {
                            absoluteScaleX = this.flatter.getAbsoluteScaleX();
                            absoluteScaleY = this.flatter.getAbsoluteScaleY();
                        }
                        f = absoluteScaleX;
                        f2 = absoluteScaleY;
                        list = this.digitSec2SplitDrawable;
                        if (list != null) {
                            drawDrawable(canvas, digitalSecondDrawable.get(numArr6[0].intValue()), i3, i4, f, f2);
                            int i33 = this.digitSec2Position.x;
                            i5 = this.digitSec2Position.y;
                            it = ArraysKt.drop(numArr6, 1).iterator();
                            i6 = i33;
                            while (it.hasNext()) {
                                Drawable drawable7 = list.get(((Number) it.next()).intValue());
                                int intrinsicWidth8 = (int) (drawable7.getIntrinsicWidth() * f);
                                drawDrawable(canvas, drawable7, i6, i5, f, f2);
                                i6 += intrinsicWidth8;
                            }
                            Unit unit12 = Unit.INSTANCE;
                            Unit unit13 = Unit.INSTANCE;
                        }
                    }
                }
                if (this.flatter.getConfig().getTime_rotate() == 1) {
                    canvas.restore();
                }
            }
            config = config;
            i20 = i20;
            numArr = numArr;
            this.digitalAnimationStartTime = 0L;
            numArr2 = numArr;
            digitalHourDrawable = this.flatter.getDigitalHourDrawable();
            if (digitalHourDrawable == null) {
                if (this.flatter.getConfig().getTime_rotate() == 1) {
                    canvas.save();
                    float time_rotate_degree2 = this.flatter.getConfig().getTime_rotate_degree();
                    float f16 = i21;
                    digitalHourDrawable2 = this.flatter.getDigitalHourDrawable();
                    if (digitalHourDrawable2 != null) {
                        numValueOf = null;
                    } else {
                        numValueOf = null;
                    }
                    Intrinsics.checkNotNull(numValueOf);
                    float fIntValue2 = numValueOf.intValue();
                    if (getSupportScale()) {
                        absoluteScaleX7 = this.flatter.getAbsoluteScaleX();
                    } else {
                        absoluteScaleX7 = 1.0f;
                    }
                    canvas.rotate(time_rotate_degree2, f16 + ((fIntValue2 * absoluteScaleX7) / 2), i22);
                }
                if (this.flatter.getConfig().getNeed_split_hour() == 0) {
                    absoluteScaleX6 = this.scaleX;
                    absoluteScaleY6 = this.scaleY;
                    if (getSupportScale()) {
                        absoluteScaleX6 = this.flatter.getAbsoluteScaleX();
                        absoluteScaleY6 = this.flatter.getAbsoluteScaleY();
                    }
                    f11 = absoluteScaleX6;
                    f12 = absoluteScaleY6;
                    i18 = i21;
                    while (i19 < r14) {
                        Drawable drawable8 = digitalHourDrawable.get(num.intValue());
                        int intrinsicWidth9 = (int) (drawable8.getIntrinsicWidth() * f11);
                        drawDrawable(canvas, drawable8, i18, i22, f11, f12);
                        i18 += intrinsicWidth9;
                    }
                    Unit unit14 = Unit.INSTANCE;
                    i21 = i18;
                } else {
                    list3 = this.digitHour2SplitDrawable;
                    if (list3 != null) {
                        absoluteScaleX5 = this.scaleX;
                        absoluteScaleY5 = this.scaleY;
                        if (getSupportScale()) {
                            absoluteScaleX5 = this.flatter.getAbsoluteScaleX();
                            absoluteScaleY5 = this.flatter.getAbsoluteScaleY();
                        }
                        f9 = absoluteScaleX5;
                        f10 = absoluteScaleY5;
                        drawDrawable(canvas, digitalHourDrawable.get(numArr2[0].intValue()), i21, i22, f9, f10);
                        int i34 = this.digitHour2Position.x;
                        i16 = this.digitHour2Position.y;
                        it3 = ArraysKt.drop(numArr2, 1).iterator();
                        i17 = i34;
                        while (it3.hasNext()) {
                            Drawable drawable9 = list3.get(((Number) it3.next()).intValue());
                            int intrinsicWidth10 = (int) (drawable9.getIntrinsicWidth() * f9);
                            drawDrawable(canvas, drawable9, i17, i16, f9, f10);
                            i17 += intrinsicWidth10;
                        }
                        Unit unit15 = Unit.INSTANCE;
                        Unit unit16 = Unit.INSTANCE;
                        i22 = i16;
                        i21 = i17;
                    }
                }
            }
            i = i21;
            digitalSplitDrawable = this.flatter.getDigitalSplitDrawable();
            if (digitalSplitDrawable != null) {
                if (config.timeSplitNeedJump()) {
                    if (getSupportScale()) {
                        scaleX3 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                    } else {
                        scaleX3 = this.flatter.getScaleX();
                    }
                    float f17 = scaleX3;
                    if (getSupportScale()) {
                        scaleY2 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                    } else {
                        scaleY2 = this.flatter.getScaleY();
                    }
                    drawDrawable(canvas, digitalSplitDrawable, i, i22, f17, scaleY2);
                } else {
                    if (getSupportScale()) {
                        scaleX3 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                    } else {
                        scaleX3 = this.flatter.getScaleX();
                    }
                    float f18 = scaleX3;
                    if (getSupportScale()) {
                        scaleY2 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                    } else {
                        scaleY2 = this.flatter.getScaleY();
                    }
                    drawDrawable(canvas, digitalSplitDrawable, i, i22, f18, scaleY2);
                }
                float intrinsicWidth11 = digitalSplitDrawable.getIntrinsicWidth();
                if (getSupportScale()) {
                    scaleX4 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                } else {
                    scaleX4 = this.flatter.getScaleX();
                }
                i += (int) (intrinsicWidth11 * scaleX4);
                Unit unit17 = Unit.INSTANCE;
                Unit unit18 = Unit.INSTANCE;
            }
            digitalMinuteDrawable = this.flatter.getDigitalMinuteDrawable();
            if (digitalMinuteDrawable != null) {
                if (!config.isDigitalMinuteAutomatic()) {
                    i9 = this.flatter.getDigitalMinutePosition().x;
                    i10 = this.flatter.getDigitalMinutePosition().y;
                } else {
                    i9 = i;
                    i10 = this.flatter.getDigitalHourPosition().y;
                }
                if (this.flatter.getConfig().getNeed_split_min() == 0) {
                    absoluteScaleX4 = this.scaleX;
                    absoluteScaleY4 = this.scaleY;
                    if (getSupportScale()) {
                        absoluteScaleX4 = this.flatter.getAbsoluteScaleX();
                        absoluteScaleY4 = this.flatter.getAbsoluteScaleY();
                    }
                    f7 = absoluteScaleX4;
                    f8 = absoluteScaleY4;
                    i14 = i9;
                    while (i15 < r14) {
                        Drawable drawable10 = digitalMinuteDrawable.get(num2.intValue());
                        int intrinsicWidth12 = (int) (drawable10.getIntrinsicWidth() * f7);
                        drawDrawable(canvas, drawable10, i14, i10, f7, f8);
                        i14 += intrinsicWidth12;
                    }
                    Unit unit19 = Unit.INSTANCE;
                    i11 = i10;
                    i = i14;
                } else {
                    absoluteScaleX3 = this.scaleX;
                    absoluteScaleY3 = this.scaleY;
                    if (getSupportScale()) {
                        absoluteScaleX3 = this.flatter.getAbsoluteScaleX();
                        absoluteScaleY3 = this.flatter.getAbsoluteScaleY();
                    }
                    f5 = absoluteScaleX3;
                    f6 = absoluteScaleY3;
                    list2 = this.digitMin2SplitDrawable;
                    if (list2 != null) {
                        drawDrawable(canvas, digitalMinuteDrawable.get(numArr5[0].intValue()), i9, i10, f5, f6);
                        int i35 = this.digitMin2Position.x;
                        i12 = this.digitMin2Position.y;
                        it2 = ArraysKt.drop(numArr5, 1).iterator();
                        i13 = i35;
                        while (it2.hasNext()) {
                            Drawable drawable11 = list2.get(((Number) it2.next()).intValue());
                            int intrinsicWidth13 = (int) (drawable11.getIntrinsicWidth() * f5);
                            drawDrawable(canvas, drawable11, i13, i12, f5, f6);
                            i13 += intrinsicWidth13;
                        }
                        Unit unit20 = Unit.INSTANCE;
                        Unit unit21 = Unit.INSTANCE;
                        i11 = i12;
                        i = i13;
                    } else {
                        i11 = i10;
                        i = i9;
                    }
                }
                i2 = i11;
            } else {
                i2 = i22;
            }
            digitalSplit2Drawable = this.flatter.getDigitalSplit2Drawable();
            if (digitalSplit2Drawable != null) {
                if (config.timeSplitNeedJump()) {
                    if (getSupportScale()) {
                        scaleX = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                    } else {
                        scaleX = this.flatter.getScaleX();
                    }
                    float f19 = scaleX;
                    if (getSupportScale()) {
                        scaleY = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                    } else {
                        scaleY = this.flatter.getScaleY();
                    }
                    drawDrawable(canvas, digitalSplit2Drawable, i, i2, f19, scaleY);
                } else {
                    if (getSupportScale()) {
                        scaleX = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                    } else {
                        scaleX = this.flatter.getScaleX();
                    }
                    float f110 = scaleX;
                    if (getSupportScale()) {
                        scaleY = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                    } else {
                        scaleY = this.flatter.getScaleY();
                    }
                    drawDrawable(canvas, digitalSplit2Drawable, i, i2, f110, scaleY);
                }
                float intrinsicWidth14 = digitalSplit2Drawable.getIntrinsicWidth();
                if (getSupportScale()) {
                    scaleX2 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                } else {
                    scaleX2 = this.flatter.getScaleX();
                }
                i += (int) (intrinsicWidth14 * scaleX2);
                Unit unit22 = Unit.INSTANCE;
                Unit unit110 = Unit.INSTANCE;
            }
            digitalSecondDrawable = this.flatter.getDigitalSecondDrawable();
            if (digitalSecondDrawable != null) {
                if (!config.isDigitalSecondAutomatic()) {
                    i3 = this.flatter.getDigitalSecondPosition().x;
                    i4 = this.flatter.getDigitalSecondPosition().y;
                } else {
                    i3 = i;
                    i4 = this.flatter.getDigitalHourPosition().y;
                }
                if (this.flatter.getConfig().getNeed_split_sec() == 0) {
                    absoluteScaleX2 = this.scaleX;
                    absoluteScaleY2 = this.scaleY;
                    if (getSupportScale()) {
                        absoluteScaleX2 = this.flatter.getAbsoluteScaleX();
                        absoluteScaleY2 = this.flatter.getAbsoluteScaleY();
                    }
                    f3 = absoluteScaleX2;
                    f4 = absoluteScaleY2;
                    i7 = i3;
                    while (i8 < r14) {
                        Drawable drawable12 = digitalSecondDrawable.get(num3.intValue());
                        int intrinsicWidth15 = (int) (drawable12.getIntrinsicWidth() * f3);
                        drawDrawable(canvas, drawable12, i7, i4, f3, f4);
                        i7 += intrinsicWidth15;
                    }
                    Unit unit111 = Unit.INSTANCE;
                } else {
                    absoluteScaleX = this.scaleX;
                    absoluteScaleY = this.scaleY;
                    if (getSupportScale()) {
                        absoluteScaleX = this.flatter.getAbsoluteScaleX();
                        absoluteScaleY = this.flatter.getAbsoluteScaleY();
                    }
                    f = absoluteScaleX;
                    f2 = absoluteScaleY;
                    list = this.digitSec2SplitDrawable;
                    if (list != null) {
                        drawDrawable(canvas, digitalSecondDrawable.get(numArr6[0].intValue()), i3, i4, f, f2);
                        int i36 = this.digitSec2Position.x;
                        i5 = this.digitSec2Position.y;
                        it = ArraysKt.drop(numArr6, 1).iterator();
                        i6 = i36;
                        while (it.hasNext()) {
                            Drawable drawable13 = list.get(((Number) it.next()).intValue());
                            int intrinsicWidth16 = (int) (drawable13.getIntrinsicWidth() * f);
                            drawDrawable(canvas, drawable13, i6, i5, f, f2);
                            i6 += intrinsicWidth16;
                        }
                        Unit unit112 = Unit.INSTANCE;
                        Unit unit113 = Unit.INSTANCE;
                    }
                }
            }
            if (this.flatter.getConfig().getTime_rotate() == 1) {
                canvas.restore();
            }
        }
    }

    public final void drawByAngle(Canvas canvas, Drawable drawable, int width, double drawArc2, float scaleX, float scaleY) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        double d = 1.5707963267948966d - drawArc2;
        double dCos = ((double) this.mCircleX) + (this.mCircleR * Math.cos(d));
        double dSin = ((double) this.mCircleY) - (this.mCircleR * Math.sin(d));
        double d2 = (180.0d * drawArc2) / 3.141592653589793d;
        float f = (float) dCos;
        float f2 = (float) dSin;
        canvas.rotate((float) (((double) this.mExtraAngle) + d2), f, f2);
        drawDrawable(canvas, drawable, (int) (dCos - (((double) width) / 2.0d)), (int) dSin, scaleX, scaleY);
        canvas.rotate(-((float) (d2 + ((double) this.mExtraAngle))), f, f2);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:105:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:106:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:109:0x030a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0318  */
    /* JADX WARN: Code duplicated, block: B:115:0x0334  */
    /* JADX WARN: Code duplicated, block: B:117:0x033a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0340  */
    /* JADX WARN: Code duplicated, block: B:121:0x034b  */
    /* JADX WARN: Code duplicated, block: B:123:0x0362  */
    /* JADX WARN: Code duplicated, block: B:124:0x0369  */
    /* JADX WARN: Code duplicated, block: B:127:0x0372  */
    /* JADX WARN: Code duplicated, block: B:128:0x0379  */
    /* JADX WARN: Code duplicated, block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:53:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:55:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:57:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:58:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:61:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:62:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:66:0x021d  */
    /* JADX WARN: Code duplicated, block: B:70:0x0227  */
    /* JADX WARN: Code duplicated, block: B:72:0x022f  */
    /* JADX WARN: Code duplicated, block: B:73:0x023d  */
    /* JADX WARN: Code duplicated, block: B:76:0x024a  */
    /* JADX WARN: Code duplicated, block: B:77:0x0258  */
    /* JADX WARN: Code duplicated, block: B:82:0x0274  */
    /* JADX WARN: Code duplicated, block: B:84:0x027a  */
    /* JADX WARN: Code duplicated, block: B:85:0x0280  */
    /* JADX WARN: Code duplicated, block: B:88:0x028c  */
    /* JADX WARN: Code duplicated, block: B:90:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:91:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:94:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:95:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:99:0x02dd  */
    private final void drawTimeWithArc(Canvas canvas) {
        Integer[] numArr;
        double d;
        int i;
        Integer[] numArr2;
        Integer[] numArr3;
        List<Drawable> digitalHourDrawable;
        Drawable digitalSplitDrawable;
        List<Drawable> digitalMinuteDrawable;
        Drawable digitalSplit2Drawable;
        List<Drawable> digitalSecondDrawable;
        double d2;
        Integer[] numArr4;
        int length;
        int i2;
        double d3;
        float absoluteScaleX;
        float absoluteScaleY;
        float scaleX;
        float scaleY;
        double d4;
        Integer[] numArr5;
        int length2;
        int i3;
        float absoluteScaleX2;
        float absoluteScaleY2;
        float scaleX2;
        float scaleY2;
        Integer[] numArr6;
        int length3;
        int i4;
        float absoluteScaleX3;
        float absoluteScaleY3;
        Calendar calendar = Calendar.getInstance();
        ClockConfig config = this.flatter.getConfig();
        int i5 = calendar.get(13);
        boolean zIs24HourFormat = DateFormat.is24HourFormat(this.context);
        double d5 = this.mStartArc;
        if (config.isDigitalSupport()) {
            if (!zIs24HourFormat) {
                int i6 = calendar.get(10);
                if (i6 == 0) {
                    i6 = 12;
                }
                numArr = new Integer[]{Integer.valueOf(i6 / 10), Integer.valueOf(i6 % 10)};
            } else {
                int i7 = calendar.get(11);
                numArr = new Integer[]{Integer.valueOf(i7 / 10), Integer.valueOf(i7 % 10)};
            }
            int i8 = calendar.get(12);
            Integer[] numArr7 = {Integer.valueOf(i8 / 10), Integer.valueOf(i8 % 10)};
            int i9 = calendar.get(13);
            Integer[] numArr8 = {Integer.valueOf(i9 / 10), Integer.valueOf(i9 % 10)};
            if (this.isDigitalStartAnimation) {
                int digital_start_hour = this.flatter.getConfig().getDigital_start_hour();
                int digital_start_minute = this.flatter.getConfig().getDigital_start_minute();
                int digital_start_second = this.flatter.getConfig().getDigital_start_second();
                d = d5;
                if (this.digitalAnimationStartTime != 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.digitalAnimationStartTime;
                    if (0 <= jCurrentTimeMillis) {
                        int i10 = this.digitStartAnimationMaxTime;
                        if (jCurrentTimeMillis <= i10) {
                            int i11 = (int) (((((long) this.mSecondChangeNum) * jCurrentTimeMillis) / ((long) i10)) + ((long) digital_start_second));
                            int i12 = (int) (((((long) this.mMinuteChangeNum) * jCurrentTimeMillis) / ((long) i10)) + ((long) digital_start_minute));
                            int i13 = (int) (((((long) this.mHourChangeNum) * jCurrentTimeMillis) / ((long) i10)) + ((long) digital_start_hour));
                            if (i11 < 0) {
                                i11 = -i11;
                            } else if (i11 > 59) {
                                i11 -= 60;
                            }
                            if (i12 < 0) {
                                i12 = -i12;
                            } else if (i12 > 59) {
                                i12 -= 60;
                            }
                            if (zIs24HourFormat) {
                                if (i13 < 0) {
                                    i13 = -i13;
                                } else if (i13 > 23) {
                                    i13 -= 24;
                                }
                            } else if (i13 < 0) {
                                i13 = -i13;
                            } else if (i13 > 11) {
                                i13 -= 12;
                            }
                            numArr = new Integer[]{Integer.valueOf(i13 / 10), Integer.valueOf(i13 % 10)};
                            Integer[] numArr9 = {Integer.valueOf(i12 / 10), Integer.valueOf(i12 % 10)};
                            numArr2 = new Integer[]{Integer.valueOf(i11 / 10), Integer.valueOf(i11 % 10)};
                            numArr3 = numArr9;
                            i = 0;
                        }
                    }
                    this.isDigitalStartAnimation = false;
                    this.digitalAnimationStartTime = 0L;
                    i = 0;
                } else {
                    if (digital_start_hour > 12 && !zIs24HourFormat) {
                        digital_start_hour -= 12;
                    }
                    this.mSecondChangeNum = calculateChangeNum(1, digital_start_second, i9, zIs24HourFormat);
                    this.mMinuteChangeNum = calculateChangeNum(2, digital_start_minute, i8, zIs24HourFormat);
                    this.mHourChangeNum = calculateChangeNum(3, digital_start_hour, calendar.get(10), zIs24HourFormat);
                    i = 0;
                    numArr = new Integer[]{Integer.valueOf(digital_start_hour / 10), Integer.valueOf(digital_start_hour % 10)};
                    numArr7 = new Integer[]{Integer.valueOf(digital_start_minute / 10), Integer.valueOf(digital_start_minute % 10)};
                    numArr2 = new Integer[]{Integer.valueOf(digital_start_second / 10), Integer.valueOf(digital_start_second % 10)};
                    this.digitalAnimationStartTime = System.currentTimeMillis();
                    numArr3 = numArr7;
                }
                digitalHourDrawable = this.flatter.getDigitalHourDrawable();
                if (digitalHourDrawable != null) {
                    numArr6 = numArr;
                    i4 = i;
                    for (length3 = numArr6.length; i4 < length3; length3 = length3) {
                        Drawable drawable = digitalHourDrawable.get(numArr6[i4].intValue());
                        int i14 = this.mTimeCellWidth;
                        if (getSupportScale()) {
                            absoluteScaleX3 = this.flatter.getAbsoluteScaleX();
                        } else {
                            absoluteScaleX3 = this.scaleX;
                        }
                        float f = absoluteScaleX3;
                        if (getSupportScale()) {
                            absoluteScaleY3 = this.flatter.getAbsoluteScaleY();
                        } else {
                            absoluteScaleY3 = this.scaleY;
                        }
                        drawByAngle(canvas, drawable, i14, d, f, absoluteScaleY3);
                        d += ((double) 2) * this.mSubArcHourNum;
                        i4++;
                    }
                }
                digitalSplitDrawable = this.flatter.getDigitalSplitDrawable();
                if (digitalSplitDrawable != null) {
                    if (config.timeSplitNeedJump() || i5 % 2 == 0) {
                        int i15 = this.mHourSpltWidth;
                        if (getSupportScale()) {
                            scaleX2 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                        } else {
                            scaleX2 = this.flatter.getScaleX();
                        }
                        float f2 = scaleX2;
                        if (getSupportScale()) {
                            scaleY2 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                        } else {
                            scaleY2 = this.flatter.getScaleY();
                        }
                        drawByAngle(canvas, digitalSplitDrawable, i15, d, f2, scaleY2);
                    }
                    d += this.mSubArcSpltHour;
                }
                digitalMinuteDrawable = this.flatter.getDigitalMinuteDrawable();
                if (digitalMinuteDrawable != null) {
                    if (!config.isDigitalMinuteAutomatic()) {
                        d4 = this.mStartTimeArc + this.mSubArcMinNum;
                    } else {
                        d4 = d + this.mSubArcMinNum;
                    }
                    numArr5 = numArr3;
                    length2 = numArr5.length;
                    d = d4;
                    for (i3 = i; i3 < length2; i3++) {
                        Drawable drawable2 = digitalMinuteDrawable.get(numArr5[i3].intValue());
                        int i16 = this.mMinCellWidth;
                        if (getSupportScale()) {
                            absoluteScaleX2 = this.flatter.getAbsoluteScaleX();
                        } else {
                            absoluteScaleX2 = this.scaleX;
                        }
                        float f3 = absoluteScaleX2;
                        if (getSupportScale()) {
                            absoluteScaleY2 = this.flatter.getAbsoluteScaleY();
                        } else {
                            absoluteScaleY2 = this.scaleY;
                        }
                        drawByAngle(canvas, drawable2, i16, d, f3, absoluteScaleY2);
                        d += ((double) 2) * this.mSubArcMinNum;
                    }
                }
                digitalSplit2Drawable = this.flatter.getDigitalSplit2Drawable();
                if (digitalSplit2Drawable != null) {
                    if (config.timeSplitNeedJump() || i5 % 2 == 0) {
                        int i17 = this.mMinSpltWidth;
                        if (getSupportScale()) {
                            scaleX = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                        } else {
                            scaleX = this.flatter.getScaleX();
                        }
                        float f4 = scaleX;
                        if (getSupportScale()) {
                            scaleY = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                        } else {
                            scaleY = this.flatter.getScaleY();
                        }
                        drawByAngle(canvas, digitalSplit2Drawable, i17, d, f4, scaleY);
                    }
                    d += this.mSubArcSpltMin;
                }
                digitalSecondDrawable = this.flatter.getDigitalSecondDrawable();
                if (digitalSecondDrawable != null) {
                    if (!config.isDigitalSecondAutomatic()) {
                        d2 = this.mStartTimeArc + this.mSubArcSecNum;
                    } else {
                        d2 = d + this.mSubArcSecNum;
                    }
                    numArr4 = numArr2;
                    length = numArr4.length;
                    d3 = d2;
                    for (i2 = i; i2 < length; i2++) {
                        Drawable drawable3 = digitalSecondDrawable.get(numArr4[i2].intValue());
                        int i18 = this.mSecNumCellWidth;
                        if (getSupportScale()) {
                            absoluteScaleX = this.flatter.getAbsoluteScaleX();
                        } else {
                            absoluteScaleX = this.scaleX;
                        }
                        float f5 = absoluteScaleX;
                        if (getSupportScale()) {
                            absoluteScaleY = this.flatter.getAbsoluteScaleY();
                        } else {
                            absoluteScaleY = this.scaleY;
                        }
                        drawByAngle(canvas, drawable3, i18, d3, f5, absoluteScaleY);
                        d3 += ((double) 2) * this.mSubArcSecNum;
                    }
                }
            }
            d = d5;
            numArr8 = numArr8;
            i = 0;
            this.digitalAnimationStartTime = 0L;
            numArr2 = numArr8;
            numArr3 = numArr7;
            digitalHourDrawable = this.flatter.getDigitalHourDrawable();
            if (digitalHourDrawable != null) {
                numArr6 = numArr;
                i4 = i;
                while (i4 < length3) {
                    Drawable drawable4 = digitalHourDrawable.get(numArr6[i4].intValue());
                    int i19 = this.mTimeCellWidth;
                    if (getSupportScale()) {
                        absoluteScaleX3 = this.flatter.getAbsoluteScaleX();
                    } else {
                        absoluteScaleX3 = this.scaleX;
                    }
                    float f6 = absoluteScaleX3;
                    if (getSupportScale()) {
                        absoluteScaleY3 = this.flatter.getAbsoluteScaleY();
                    } else {
                        absoluteScaleY3 = this.scaleY;
                    }
                    drawByAngle(canvas, drawable4, i19, d, f6, absoluteScaleY3);
                    d += ((double) 2) * this.mSubArcHourNum;
                    i4++;
                }
            }
            digitalSplitDrawable = this.flatter.getDigitalSplitDrawable();
            if (digitalSplitDrawable != null) {
                if (config.timeSplitNeedJump()) {
                    int i110 = this.mHourSpltWidth;
                    if (getSupportScale()) {
                        scaleX2 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                    } else {
                        scaleX2 = this.flatter.getScaleX();
                    }
                    float f7 = scaleX2;
                    if (getSupportScale()) {
                        scaleY2 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                    } else {
                        scaleY2 = this.flatter.getScaleY();
                    }
                    drawByAngle(canvas, digitalSplitDrawable, i110, d, f7, scaleY2);
                } else {
                    int i111 = this.mHourSpltWidth;
                    if (getSupportScale()) {
                        scaleX2 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                    } else {
                        scaleX2 = this.flatter.getScaleX();
                    }
                    float f8 = scaleX2;
                    if (getSupportScale()) {
                        scaleY2 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                    } else {
                        scaleY2 = this.flatter.getScaleY();
                    }
                    drawByAngle(canvas, digitalSplitDrawable, i111, d, f8, scaleY2);
                }
                d += this.mSubArcSpltHour;
            }
            digitalMinuteDrawable = this.flatter.getDigitalMinuteDrawable();
            if (digitalMinuteDrawable != null) {
                if (!config.isDigitalMinuteAutomatic()) {
                    d4 = this.mStartTimeArc + this.mSubArcMinNum;
                } else {
                    d4 = d + this.mSubArcMinNum;
                }
                numArr5 = numArr3;
                length2 = numArr5.length;
                d = d4;
                while (i3 < length2) {
                    Drawable drawable5 = digitalMinuteDrawable.get(numArr5[i3].intValue());
                    int i112 = this.mMinCellWidth;
                    if (getSupportScale()) {
                        absoluteScaleX2 = this.flatter.getAbsoluteScaleX();
                    } else {
                        absoluteScaleX2 = this.scaleX;
                    }
                    float f9 = absoluteScaleX2;
                    if (getSupportScale()) {
                        absoluteScaleY2 = this.flatter.getAbsoluteScaleY();
                    } else {
                        absoluteScaleY2 = this.scaleY;
                    }
                    drawByAngle(canvas, drawable5, i112, d, f9, absoluteScaleY2);
                    d += ((double) 2) * this.mSubArcMinNum;
                }
            }
            digitalSplit2Drawable = this.flatter.getDigitalSplit2Drawable();
            if (digitalSplit2Drawable != null) {
                if (config.timeSplitNeedJump()) {
                    int i113 = this.mMinSpltWidth;
                    if (getSupportScale()) {
                        scaleX = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                    } else {
                        scaleX = this.flatter.getScaleX();
                    }
                    float f10 = scaleX;
                    if (getSupportScale()) {
                        scaleY = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                    } else {
                        scaleY = this.flatter.getScaleY();
                    }
                    drawByAngle(canvas, digitalSplit2Drawable, i113, d, f10, scaleY);
                } else {
                    int i114 = this.mMinSpltWidth;
                    if (getSupportScale()) {
                        scaleX = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                    } else {
                        scaleX = this.flatter.getScaleX();
                    }
                    float f11 = scaleX;
                    if (getSupportScale()) {
                        scaleY = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                    } else {
                        scaleY = this.flatter.getScaleY();
                    }
                    drawByAngle(canvas, digitalSplit2Drawable, i114, d, f11, scaleY);
                }
                d += this.mSubArcSpltMin;
            }
            digitalSecondDrawable = this.flatter.getDigitalSecondDrawable();
            if (digitalSecondDrawable != null) {
                if (!config.isDigitalSecondAutomatic()) {
                    d2 = this.mStartTimeArc + this.mSubArcSecNum;
                } else {
                    d2 = d + this.mSubArcSecNum;
                }
                numArr4 = numArr2;
                length = numArr4.length;
                d3 = d2;
                while (i2 < length) {
                    Drawable drawable6 = digitalSecondDrawable.get(numArr4[i2].intValue());
                    int i115 = this.mSecNumCellWidth;
                    if (getSupportScale()) {
                        absoluteScaleX = this.flatter.getAbsoluteScaleX();
                    } else {
                        absoluteScaleX = this.scaleX;
                    }
                    float f12 = absoluteScaleX;
                    if (getSupportScale()) {
                        absoluteScaleY = this.flatter.getAbsoluteScaleY();
                    } else {
                        absoluteScaleY = this.scaleY;
                    }
                    drawByAngle(canvas, drawable6, i115, d3, f12, absoluteScaleY);
                    d3 += ((double) 2) * this.mSubArcSecNum;
                }
            }
        }
    }

    private final void drawPointer(Canvas canvas, Drawable drawable, Point position, float degree) {
        float intrinsicWidth;
        float absoluteScaleX;
        float intrinsicHeight;
        float absoluteScaleY;
        int i = position.x;
        int i2 = position.y;
        canvas.save();
        canvas.rotate(degree - 90, i, i2);
        boolean supportScale = this.flatter.getConfig().getPointer_disable_scale() == 1 ? false : getSupportScale();
        if (supportScale) {
            intrinsicWidth = drawable.getIntrinsicWidth() * this.flatter.getScaleX();
            absoluteScaleX = this.flatter.getAbsoluteScaleX();
        } else {
            intrinsicWidth = drawable.getIntrinsicWidth();
            absoluteScaleX = this.flatter.getScaleX();
        }
        int i3 = (int) (intrinsicWidth * absoluteScaleX);
        if (supportScale) {
            intrinsicHeight = drawable.getIntrinsicHeight() * this.flatter.getScaleY();
            absoluteScaleY = this.flatter.getAbsoluteScaleY();
        } else {
            intrinsicHeight = drawable.getIntrinsicHeight();
            absoluteScaleY = this.flatter.getScaleY();
        }
        int i4 = (int) (intrinsicHeight * absoluteScaleY);
        int i5 = position.x;
        int i6 = position.y;
        int i7 = i3 / 2;
        int i8 = i4 / 2;
        drawable.setBounds(i5 - i7, i6 - i8, i5 + i7, i6 + i8);
        drawable.draw(canvas);
        canvas.restore();
    }

    private final int calculateChangeNum(int type, int startNum, int endNum, boolean is24TimeClock) {
        int i;
        if (type == 1 || type == 2) {
            if (startNum > endNum) {
                int i2 = startNum - endNum;
                return i2 >= 30 ? -i2 : 60 - i2;
            }
            if (startNum >= endNum) {
                return (Math.random() <= 0.5d ? 1 : -1) * 60;
            }
            int i3 = endNum - startNum;
            if (i3 >= 30) {
                return i3;
            }
            i = 60 - i3;
        } else if (is24TimeClock) {
            if (startNum > endNum) {
                int i4 = startNum - endNum;
                return i4 >= 12 ? -i4 : 24 - i4;
            }
            if (startNum >= endNum) {
                return (Math.random() <= 0.5d ? 1 : -1) * 24;
            }
            int i5 = endNum - startNum;
            if (i5 >= 12) {
                return i5;
            }
            i = 24 - i5;
        } else {
            if (startNum > endNum) {
                int i6 = startNum - endNum;
                return i6 >= 6 ? -i6 : 12 - i6;
            }
            if (startNum >= endNum) {
                return 12 * (Math.random() <= 0.5d ? 1 : -1);
            }
            int i7 = endNum - startNum;
            if (i7 >= 6) {
                return i7;
            }
            i = 12 - i7;
        }
        return -i;
    }

    public final void changeTimeStyle() {
        if (this.flatter.getConfig().getTime_change_counter() > 0) {
            int time_change_counter = (this.currentStyle + 1) % (this.flatter.getConfig().getTime_change_counter() + 1);
            this.currentStyle = time_change_counter;
            if (time_change_counter == 0) {
                ClockConfigFlatter clockConfigFlatter = this.flatter;
                clockConfigFlatter.setDigitalHourDrawable(clockConfigFlatter.splitDrawable(clockConfigFlatter.getConfig().getTime_hour_src(), 10));
                ClockConfigFlatter clockConfigFlatter2 = this.flatter;
                clockConfigFlatter2.setDigitalMinuteDrawable(clockConfigFlatter2.splitDrawable(clockConfigFlatter2.getConfig().getTime_min_src(), 10));
                if (this.flatter.getDigitalMinuteDrawable() == null) {
                    ClockConfigFlatter clockConfigFlatter3 = this.flatter;
                    clockConfigFlatter3.setDigitalMinuteDrawable(clockConfigFlatter3.getDigitalHourDrawable());
                }
                if (this.flatter.getConfig().getShow_sec() != 0) {
                    ClockConfigFlatter clockConfigFlatter4 = this.flatter;
                    clockConfigFlatter4.setDigitalSecondDrawable(clockConfigFlatter4.splitDrawable(clockConfigFlatter4.getConfig().getTime_sec_src(), 10));
                    if (this.flatter.getDigitalSecondDrawable() == null) {
                        ClockConfigFlatter clockConfigFlatter5 = this.flatter;
                        clockConfigFlatter5.setDigitalSecondDrawable(clockConfigFlatter5.getDigitalHourDrawable());
                    }
                }
                ClockConfigFlatter clockConfigFlatter6 = this.flatter;
                clockConfigFlatter6.setDigitalSplitDrawable(ClockConfigFlatter.loadDrawable$default(clockConfigFlatter6, clockConfigFlatter6.getConfig().getTime_splt_src(), false, 2, null));
                ClockConfigFlatter clockConfigFlatter7 = this.flatter;
                clockConfigFlatter7.setDigitalSplit2Drawable(ClockConfigFlatter.loadDrawable$default(clockConfigFlatter7, clockConfigFlatter7.getConfig().getTime_splt_2_src(), false, 2, null));
            } else if (time_change_counter == 1) {
                ClockConfigFlatter clockConfigFlatter8 = this.flatter;
                clockConfigFlatter8.setDigitalHourDrawable(clockConfigFlatter8.splitDrawable(clockConfigFlatter8.getConfig().getTime_hour_src_2(), 10));
                ClockConfigFlatter clockConfigFlatter9 = this.flatter;
                clockConfigFlatter9.setDigitalMinuteDrawable(clockConfigFlatter9.splitDrawable(clockConfigFlatter9.getConfig().getTime_min_src_2(), 10));
                if (this.flatter.getDigitalMinuteDrawable() == null) {
                    ClockConfigFlatter clockConfigFlatter10 = this.flatter;
                    clockConfigFlatter10.setDigitalMinuteDrawable(clockConfigFlatter10.getDigitalHourDrawable());
                }
                if (this.flatter.getConfig().getShow_sec() != 0) {
                    ClockConfigFlatter clockConfigFlatter11 = this.flatter;
                    clockConfigFlatter11.setDigitalSecondDrawable(clockConfigFlatter11.splitDrawable(clockConfigFlatter11.getConfig().getTime_sec_src_2(), 10));
                    if (this.flatter.getDigitalSecondDrawable() == null) {
                        ClockConfigFlatter clockConfigFlatter12 = this.flatter;
                        clockConfigFlatter12.setDigitalSecondDrawable(clockConfigFlatter12.getDigitalHourDrawable());
                    }
                }
                ClockConfigFlatter clockConfigFlatter13 = this.flatter;
                clockConfigFlatter13.setDigitalSplitDrawable(ClockConfigFlatter.loadDrawable$default(clockConfigFlatter13, clockConfigFlatter13.getConfig().getTime_splt_src_2(), false, 2, null));
                ClockConfigFlatter clockConfigFlatter14 = this.flatter;
                clockConfigFlatter14.setDigitalSplit2Drawable(ClockConfigFlatter.loadDrawable$default(clockConfigFlatter14, clockConfigFlatter14.getConfig().getTime_splt_2_src_2(), false, 2, null));
            } else if (time_change_counter == 2) {
                ClockConfigFlatter clockConfigFlatter15 = this.flatter;
                clockConfigFlatter15.setDigitalHourDrawable(clockConfigFlatter15.splitDrawable(clockConfigFlatter15.getConfig().getTime_hour_src_3(), 10));
                ClockConfigFlatter clockConfigFlatter16 = this.flatter;
                clockConfigFlatter16.setDigitalMinuteDrawable(clockConfigFlatter16.splitDrawable(clockConfigFlatter16.getConfig().getTime_min_src_3(), 10));
                if (this.flatter.getDigitalMinuteDrawable() == null) {
                    ClockConfigFlatter clockConfigFlatter17 = this.flatter;
                    clockConfigFlatter17.setDigitalMinuteDrawable(clockConfigFlatter17.getDigitalHourDrawable());
                }
                if (this.flatter.getConfig().getShow_sec() != 0) {
                    ClockConfigFlatter clockConfigFlatter18 = this.flatter;
                    clockConfigFlatter18.setDigitalSecondDrawable(clockConfigFlatter18.splitDrawable(clockConfigFlatter18.getConfig().getTime_sec_src_3(), 10));
                    if (this.flatter.getDigitalSecondDrawable() == null) {
                        ClockConfigFlatter clockConfigFlatter19 = this.flatter;
                        clockConfigFlatter19.setDigitalSecondDrawable(clockConfigFlatter19.getDigitalHourDrawable());
                    }
                }
                ClockConfigFlatter clockConfigFlatter20 = this.flatter;
                clockConfigFlatter20.setDigitalSplitDrawable(ClockConfigFlatter.loadDrawable$default(clockConfigFlatter20, clockConfigFlatter20.getConfig().getTime_splt_src_3(), false, 2, null));
                ClockConfigFlatter clockConfigFlatter21 = this.flatter;
                clockConfigFlatter21.setDigitalSplit2Drawable(ClockConfigFlatter.loadDrawable$default(clockConfigFlatter21, clockConfigFlatter21.getConfig().getTime_splt_2_src_3(), false, 2, null));
            } else if (time_change_counter == 3) {
                ClockConfigFlatter clockConfigFlatter22 = this.flatter;
                clockConfigFlatter22.setDigitalHourDrawable(clockConfigFlatter22.splitDrawable(clockConfigFlatter22.getConfig().getTime_hour_src_4(), 10));
                ClockConfigFlatter clockConfigFlatter23 = this.flatter;
                clockConfigFlatter23.setDigitalMinuteDrawable(clockConfigFlatter23.splitDrawable(clockConfigFlatter23.getConfig().getTime_min_src_4(), 10));
                if (this.flatter.getDigitalMinuteDrawable() == null) {
                    ClockConfigFlatter clockConfigFlatter24 = this.flatter;
                    clockConfigFlatter24.setDigitalMinuteDrawable(clockConfigFlatter24.getDigitalHourDrawable());
                }
                if (this.flatter.getConfig().getShow_sec() != 0) {
                    ClockConfigFlatter clockConfigFlatter25 = this.flatter;
                    clockConfigFlatter25.setDigitalSecondDrawable(clockConfigFlatter25.splitDrawable(clockConfigFlatter25.getConfig().getTime_sec_src_4(), 10));
                    if (this.flatter.getDigitalSecondDrawable() == null) {
                        ClockConfigFlatter clockConfigFlatter26 = this.flatter;
                        clockConfigFlatter26.setDigitalSecondDrawable(clockConfigFlatter26.getDigitalHourDrawable());
                    }
                }
                ClockConfigFlatter clockConfigFlatter27 = this.flatter;
                clockConfigFlatter27.setDigitalSplitDrawable(ClockConfigFlatter.loadDrawable$default(clockConfigFlatter27, clockConfigFlatter27.getConfig().getTime_splt_src_4(), false, 2, null));
                ClockConfigFlatter clockConfigFlatter28 = this.flatter;
                clockConfigFlatter28.setDigitalSplit2Drawable(ClockConfigFlatter.loadDrawable$default(clockConfigFlatter28, clockConfigFlatter28.getConfig().getTime_splt_2_src_4(), false, 2, null));
            }
            this.digitHour2SplitDrawable = this.flatter.getDigitalHourDrawable();
            this.digitMin2SplitDrawable = this.flatter.getDigitalMinuteDrawable();
        }
    }
}
