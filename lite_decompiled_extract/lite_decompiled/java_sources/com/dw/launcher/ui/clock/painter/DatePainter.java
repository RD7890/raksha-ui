package com.dw.launcher.ui.clock.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.ui.clock.flatter.ClockConfigFlatter;
import com.dw.launcher.ui.clock.util.LunarUtils;
import com.dw.launcher.util.SystemUtils;
import com.google.android.mms.pdu.CharacterSets;
import com.google.android.mms.pdu.PduHeaders;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DatePainter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\bV\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J-\u0010\u0081\u0001\u001a\u00020\u00192\u0007\u0010\u0082\u0001\u001a\u00020\u001f2\u0007\u0010\u0083\u0001\u001a\u00020\u00192\u0007\u0010\u0084\u0001\u001a\u00020\u001f2\u0007\u0010\u0085\u0001\u001a\u00020\u0019H\u0002J$\u0010\u0086\u0001\u001a\u00020\u00192\u0007\u0010\u0087\u0001\u001a\u00020\u001f2\u0007\u0010\u0083\u0001\u001a\u00020\u00192\u0007\u0010\u0084\u0001\u001a\u00020\u001fH\u0002J$\u0010\u0088\u0001\u001a\u00020\u00192\u0007\u0010\u0087\u0001\u001a\u00020\u001f2\u0007\u0010\u0083\u0001\u001a\u00020\u00192\u0007\u0010\u0084\u0001\u001a\u00020\u001fH\u0002J\u0012\u0010\u0089\u0001\u001a\u00030\u008a\u00012\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001J \u0010\u008d\u0001\u001a\u00030\u008a\u00012\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0016J=\u0010\u0090\u0001\u001a\u00030\u008a\u00012\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u00112\u0007\u0010\u0087\u0001\u001a\u00020\u001f2\u0007\u0010\u0092\u0001\u001a\u00020\u00192\u0006\u0010u\u001a\u00020v2\u0006\u0010y\u001a\u00020vJ\u0012\u0010\u0093\u0001\u001a\u00030\u008a\u00012\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001a\u0010'\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u001a\u0010*\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u001a\u0010-\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R\u001a\u00100\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R\u001a\u00103\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010!\"\u0004\b5\u0010#R\u001a\u00106\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010!\"\u0004\b8\u0010#R\u001a\u00109\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010!\"\u0004\b;\u0010#R\u001a\u0010<\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010!\"\u0004\b>\u0010#R\u001a\u0010?\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010!\"\u0004\bA\u0010#R\u001a\u0010B\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010!\"\u0004\bD\u0010#R\u001a\u0010E\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010!\"\u0004\bG\u0010#R\u001a\u0010H\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010!\"\u0004\bJ\u0010#R\u001a\u0010K\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010!\"\u0004\bM\u0010#R\u001a\u0010N\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010!\"\u0004\bP\u0010#R\u001a\u0010Q\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u001b\"\u0004\bS\u0010\u001dR\u001a\u0010T\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u001b\"\u0004\bV\u0010\u001dR\u001a\u0010W\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u001b\"\u0004\bY\u0010\u001dR\u001a\u0010Z\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u001b\"\u0004\b\\\u0010\u001dR\u001a\u0010]\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u001b\"\u0004\b_\u0010\u001dR\u001a\u0010`\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u001b\"\u0004\bb\u0010\u001dR\u001a\u0010c\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u001b\"\u0004\be\u0010\u001dR\u001a\u0010f\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u001b\"\u0004\bh\u0010\u001dR\u001a\u0010i\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u001b\"\u0004\bk\u0010\u001dR\u001a\u0010l\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010!\"\u0004\bn\u0010#R\u001a\u0010o\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010!\"\u0004\bq\u0010#R\u001a\u0010r\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\f\"\u0004\bt\u0010\u000eR\u0014\u0010u\u001a\u00020vX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u0014\u0010y\u001a\u00020vX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bz\u0010xR\"\u0010{\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\u0013\"\u0004\b}\u0010\u0015R\u001b\u0010~\u001a\u00020\nX\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\f\"\u0005\b\u0080\u0001\u0010\u000e¨\u0006\u0094\u0001"}, d2 = {"Lcom/dw/launcher/ui/clock/painter/DatePainter;", "Lcom/dw/launcher/ui/clock/painter/ABasePainter;", "context", "Landroid/content/Context;", "flatter", "Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "(Landroid/content/Context;Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;)V", "getContext", "()Landroid/content/Context;", "dateArcCenterPosition", "Landroid/graphics/Point;", "getDateArcCenterPosition", "()Landroid/graphics/Point;", "setDateArcCenterPosition", "(Landroid/graphics/Point;)V", "dateMonth2NumDrawable", "", "Landroid/graphics/drawable/Drawable;", "getDateMonth2NumDrawable", "()Ljava/util/List;", "setDateMonth2NumDrawable", "(Ljava/util/List;)V", "getFlatter", "()Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "mCircleR", "", "getMCircleR", "()D", "setMCircleR", "(D)V", "mCircleX", "", "getMCircleX", "()I", "setMCircleX", "(I)V", "mCircleY", "getMCircleY", "setMCircleY", "mDateCellHeight", "getMDateCellHeight", "setMDateCellHeight", "mDateCellWidth", "getMDateCellWidth", "setMDateCellWidth", "mDayNumCellHeight", "getMDayNumCellHeight", "setMDayNumCellHeight", "mDayNumCellWidth", "getMDayNumCellWidth", "setMDayNumCellWidth", "mDaySpltHeight", "getMDaySpltHeight", "setMDaySpltHeight", "mDaySpltWidth", "getMDaySpltWidth", "setMDaySpltWidth", "mExtraAngle", "getMExtraAngle", "setMExtraAngle", "mExtraAngleDate", "getMExtraAngleDate", "setMExtraAngleDate", "mMonthCellHeight", "getMMonthCellHeight", "setMMonthCellHeight", "mMonthCellWidth", "getMMonthCellWidth", "setMMonthCellWidth", "mMonthNumCellHeight", "getMMonthNumCellHeight", "setMMonthNumCellHeight", "mMonthNumCellWidth", "getMMonthNumCellWidth", "setMMonthNumCellWidth", "mMonthSpltHeight", "getMMonthSpltHeight", "setMMonthSpltHeight", "mMonthSpltWidth", "getMMonthSpltWidth", "setMMonthSpltWidth", "mStartArc", "getMStartArc", "setMStartArc", "mStartDateArc", "getMStartDateArc", "setMStartDateArc", "mSubArcDayNum", "getMSubArcDayNum", "setMSubArcDayNum", "mSubArcMonth", "getMSubArcMonth", "setMSubArcMonth", "mSubArcMonthNum", "getMSubArcMonthNum", "setMSubArcMonthNum", "mSubArcSpltD", "getMSubArcSpltD", "setMSubArcSpltD", "mSubArcSpltM", "getMSubArcSpltM", "setMSubArcSpltM", "mSubArcSpltY", "getMSubArcSpltY", "setMSubArcSpltY", "mSubArcYearNum", "getMSubArcYearNum", "setMSubArcYearNum", "mYearSpltHeight", "getMYearSpltHeight", "setMYearSpltHeight", "mYearSpltWidth", "getMYearSpltWidth", "setMYearSpltWidth", "monthPostion2", "getMonthPostion2", "setMonthPostion2", "scaleX", "", "getScaleX", "()F", "scaleY", "getScaleY", "weekDontsDrawable", "getWeekDontsDrawable", "setWeekDontsDrawable", "weekDontsPosition", "getWeekDontsPosition", "setWeekDontsPosition", "calculateSubArc", "wdith", "radius", "height", "tempLen", "calculateTempLen", "width", "calculateTempLen_180", "draDateWithoutArc", "", "canvas", "Landroid/graphics/Canvas;", "draw", "paint", "Landroid/graphics/Paint;", "drawByAngle", "drawable", "drawArc2", "drawDateWithArc", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class DatePainter extends ABasePainter {
    private final Context context;
    private Point dateArcCenterPosition;
    private List<? extends Drawable> dateMonth2NumDrawable;
    private final ClockConfigFlatter flatter;
    private double mCircleR;
    private int mCircleX;
    private int mCircleY;
    private int mDateCellHeight;
    private int mDateCellWidth;
    private int mDayNumCellHeight;
    private int mDayNumCellWidth;
    private int mDaySpltHeight;
    private int mDaySpltWidth;
    private int mExtraAngle;
    private int mExtraAngleDate;
    private int mMonthCellHeight;
    private int mMonthCellWidth;
    private int mMonthNumCellHeight;
    private int mMonthNumCellWidth;
    private int mMonthSpltHeight;
    private int mMonthSpltWidth;
    private double mStartArc;
    private double mStartDateArc;
    private double mSubArcDayNum;
    private double mSubArcMonth;
    private double mSubArcMonthNum;
    private double mSubArcSpltD;
    private double mSubArcSpltM;
    private double mSubArcSpltY;
    private double mSubArcYearNum;
    private int mYearSpltHeight;
    private int mYearSpltWidth;
    private Point monthPostion2;
    private final float scaleX;
    private final float scaleY;
    private List<? extends Drawable> weekDontsDrawable;
    private Point weekDontsPosition;

    public DatePainter(Context context, ClockConfigFlatter flatter) {
        List<Drawable> listSplitDrawable;
        float intrinsicWidth;
        float scaleX;
        float scaleY;
        float intrinsicWidth2;
        float scaleX2;
        float scaleY2;
        float intrinsicWidth3;
        float scaleX3;
        float scaleY3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flatter, "flatter");
        this.context = context;
        this.flatter = flatter;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dateArcCenterPosition = new Point();
        this.monthPostion2 = new Point();
        this.weekDontsPosition = new Point();
        setSupportScale(flatter.getConfig().supportScale());
        List<Drawable> dateDrawable = flatter.getDateDrawable();
        if (dateDrawable != null) {
            this.mDateCellWidth = getSupportScale() ? (int) (dateDrawable.get(0).getIntrinsicWidth() * flatter.getAbsoluteScaleX()) : dateDrawable.get(0).getIntrinsicWidth();
            boolean supportScale = getSupportScale();
            int intrinsicHeight = dateDrawable.get(0).getIntrinsicHeight();
            this.mDateCellHeight = supportScale ? (int) (intrinsicHeight * flatter.getAbsoluteScaleY()) : intrinsicHeight;
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        if (flatter.getConfig().getShow_week_donts() == 1) {
            this.weekDontsDrawable = flatter.splitDrawable(flatter.getConfig().getWeek_donts_src(), 7);
            flatter.setPosition(this.weekDontsPosition, flatter.getConfig().getWeek_donts_x(), flatter.getConfig().getWeek_donts_y());
        }
        Drawable dateYearSplitDrawable = flatter.getDateYearSplitDrawable();
        if (dateYearSplitDrawable != null) {
            if (getSupportScale()) {
                intrinsicWidth3 = dateYearSplitDrawable.getIntrinsicWidth() * flatter.getScaleX();
                scaleX3 = flatter.getAbsoluteScaleX();
            } else {
                intrinsicWidth3 = dateYearSplitDrawable.getIntrinsicWidth();
                scaleX3 = flatter.getScaleX();
            }
            this.mYearSpltWidth = (int) (intrinsicWidth3 * scaleX3);
            boolean supportScale2 = getSupportScale();
            float intrinsicHeight2 = dateYearSplitDrawable.getIntrinsicHeight();
            if (supportScale2) {
                intrinsicHeight2 *= flatter.getScaleY();
                scaleY3 = flatter.getAbsoluteScaleY();
            } else {
                scaleY3 = flatter.getScaleY();
            }
            this.mYearSpltHeight = (int) (intrinsicHeight2 * scaleY3);
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        Drawable dateMonthSplitDrawable = flatter.getDateMonthSplitDrawable();
        if (dateMonthSplitDrawable != null) {
            if (getSupportScale()) {
                intrinsicWidth2 = dateMonthSplitDrawable.getIntrinsicWidth() * flatter.getScaleX();
                scaleX2 = flatter.getAbsoluteScaleX();
            } else {
                intrinsicWidth2 = dateMonthSplitDrawable.getIntrinsicWidth();
                scaleX2 = flatter.getScaleX();
            }
            this.mMonthSpltWidth = (int) (intrinsicWidth2 * scaleX2);
            boolean supportScale3 = getSupportScale();
            float intrinsicHeight3 = dateMonthSplitDrawable.getIntrinsicHeight();
            if (supportScale3) {
                intrinsicHeight3 *= flatter.getScaleY();
                scaleY2 = flatter.getAbsoluteScaleY();
            } else {
                scaleY2 = flatter.getScaleY();
            }
            this.mMonthSpltHeight = (int) (intrinsicHeight3 * scaleY2);
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        Drawable dateDaySplitDrawable = flatter.getDateDaySplitDrawable();
        if (dateDaySplitDrawable != null) {
            if (getSupportScale()) {
                intrinsicWidth = dateDaySplitDrawable.getIntrinsicWidth() * flatter.getScaleX();
                scaleX = flatter.getAbsoluteScaleX();
            } else {
                intrinsicWidth = dateDaySplitDrawable.getIntrinsicWidth();
                scaleX = flatter.getScaleX();
            }
            this.mDaySpltWidth = (int) (intrinsicWidth * scaleX);
            boolean supportScale4 = getSupportScale();
            float intrinsicHeight4 = dateDaySplitDrawable.getIntrinsicHeight();
            if (supportScale4) {
                intrinsicHeight4 *= flatter.getScaleY();
                scaleY = flatter.getAbsoluteScaleY();
            } else {
                scaleY = flatter.getScaleY();
            }
            this.mDaySpltHeight = (int) (intrinsicHeight4 * scaleY);
            Unit unit7 = Unit.INSTANCE;
            Unit unit8 = Unit.INSTANCE;
        }
        List<Drawable> dateMonthNumDrawable = flatter.getDateMonthNumDrawable();
        if (dateMonthNumDrawable != null) {
            this.mMonthNumCellWidth = getSupportScale() ? (int) (dateMonthNumDrawable.get(0).getIntrinsicWidth() * flatter.getAbsoluteScaleX()) : dateMonthNumDrawable.get(0).getIntrinsicWidth();
            boolean supportScale5 = getSupportScale();
            int intrinsicHeight5 = dateMonthNumDrawable.get(0).getIntrinsicHeight();
            this.mMonthNumCellHeight = supportScale5 ? (int) (intrinsicHeight5 * flatter.getAbsoluteScaleY()) : intrinsicHeight5;
            Unit unit9 = Unit.INSTANCE;
            Unit unit10 = Unit.INSTANCE;
        }
        List<Drawable> dateDayNumDrawable = flatter.getDateDayNumDrawable();
        if (dateDayNumDrawable != null) {
            this.mDayNumCellWidth = getSupportScale() ? (int) (dateDayNumDrawable.get(0).getIntrinsicWidth() * flatter.getAbsoluteScaleX()) : dateDayNumDrawable.get(0).getIntrinsicWidth();
            boolean supportScale6 = getSupportScale();
            int intrinsicHeight6 = dateDayNumDrawable.get(0).getIntrinsicHeight();
            this.mDayNumCellHeight = supportScale6 ? (int) (intrinsicHeight6 * flatter.getAbsoluteScaleY()) : intrinsicHeight6;
            Unit unit11 = Unit.INSTANCE;
            Unit unit12 = Unit.INSTANCE;
        }
        if (flatter.getConfig().getShow_month_2() == 1) {
            flatter.setPosition(this.monthPostion2, flatter.getConfig().getMonth_x_2(), flatter.getConfig().getMonth_y_2());
            if (flatter.getConfig().getMonth_type_2() == 0) {
                listSplitDrawable = flatter.splitDrawable(flatter.getConfig().getMonth_src_2(), 10);
            } else {
                listSplitDrawable = flatter.splitDrawable(flatter.getConfig().getMonth_src_2(), 12);
            }
            this.dateMonth2NumDrawable = listSplitDrawable;
        }
        if (flatter.getConfig().getOpen_date_arc_show() != 0) {
            flatter.setPosition(this.dateArcCenterPosition, flatter.getConfig().getDate_arc_center_x(), flatter.getConfig().getDate_arc_center_y());
            this.mCircleX = this.dateArcCenterPosition.x;
            this.mCircleY = this.dateArcCenterPosition.y;
            int i = flatter.getDatePosition().x;
            int i2 = flatter.getDatePosition().y;
            double d = ((double) i) - ((double) this.mCircleX);
            double d2 = ((double) i2) - ((double) this.mCircleY);
            double dSqrt = Math.sqrt((d * d) + (d2 * d2));
            this.mCircleR = dSqrt;
            double dAcos = Math.acos(d / dSqrt);
            this.mStartArc = dAcos;
            if (i2 > this.mCircleY) {
                this.mStartArc = 6.283185307179586d - dAcos;
            }
            double d3 = 1.5707963267948966d - this.mStartArc;
            this.mStartArc = d3;
            if (d3 < 0.0d) {
                this.mStartArc = d3 + 6.283185307179586d;
            }
            this.mStartDateArc = this.mStartArc;
            if (flatter.getConfig().getDate_arc_type() != 0) {
                this.mExtraAngle = PduHeaders.RECOMMENDED_RETRIEVAL_MODE;
                this.mExtraAngleDate = PduHeaders.RECOMMENDED_RETRIEVAL_MODE;
                double d4 = this.mCircleR;
                double dCalculateTempLen_180 = calculateTempLen_180(this.mDateCellWidth, d4, this.mDateCellHeight);
                double dCalculateTempLen_181 = calculateTempLen_180(this.mMonthNumCellWidth, d4, this.mMonthNumCellHeight);
                double dCalculateTempLen_182 = calculateTempLen_180(this.mDayNumCellWidth, d4, this.mDayNumCellHeight);
                double dCalculateTempLen_183 = calculateTempLen_180(this.mMonthCellWidth, d4, this.mMonthCellHeight);
                double dCalculateTempLen_184 = calculateTempLen_180(this.mYearSpltWidth, d4, this.mYearSpltHeight);
                double dCalculateTempLen_185 = calculateTempLen_180(this.mMonthSpltWidth, d4, this.mMonthSpltHeight);
                double dCalculateTempLen_186 = calculateTempLen_180(this.mDaySpltWidth, d4, this.mDaySpltHeight);
                this.mSubArcYearNum = Math.acos(((Math.pow((((double) this.mDateCellHeight) / 2.0d) + this.mCircleR, 2.0d) + Math.pow(dCalculateTempLen_180, 2.0d)) - Math.pow(((double) this.mDateCellWidth) / 2.0d, 2.0d)) / (((this.mCircleR + (((double) this.mDateCellHeight) / 2.0d)) * 2.0d) * dCalculateTempLen_180));
                this.mSubArcMonth = Math.acos(((Math.pow((((double) this.mMonthCellHeight) / 2.0d) + this.mCircleR, 2.0d) + Math.pow(dCalculateTempLen_183, 2.0d)) - Math.pow(((double) this.mMonthCellWidth) / 2.0d, 2.0d)) / (((this.mCircleR + (((double) this.mMonthCellHeight) / 2.0d)) * 2.0d) * dCalculateTempLen_183));
                this.mSubArcMonthNum = Math.acos(((Math.pow((((double) this.mMonthNumCellHeight) / 2.0d) + this.mCircleR, 2.0d) + Math.pow(dCalculateTempLen_181, 2.0d)) - Math.pow(((double) this.mMonthNumCellWidth) / 2.0d, 2.0d)) / (((this.mCircleR + (((double) this.mMonthNumCellHeight) / 2.0d)) * 2.0d) * dCalculateTempLen_181));
                this.mSubArcDayNum = Math.acos(((Math.pow((((double) this.mDayNumCellHeight) / 2.0d) + this.mCircleR, 2.0d) + Math.pow(dCalculateTempLen_182, 2.0d)) - Math.pow(((double) this.mDayNumCellWidth) / 2.0d, 2.0d)) / (((this.mCircleR + (((double) this.mDayNumCellHeight) / 2.0d)) * 2.0d) * dCalculateTempLen_182));
                this.mSubArcSpltD = Math.acos(((Math.pow((((double) this.mDaySpltHeight) / 2.0d) + this.mCircleR, 2.0d) + Math.pow(dCalculateTempLen_186, 2.0d)) - Math.pow(((double) this.mDaySpltWidth) / 2.0d, 2.0d)) / (((this.mCircleR + (((double) this.mDaySpltHeight) / 2.0d)) * 2.0d) * dCalculateTempLen_186));
                this.mSubArcSpltM = Math.acos(((Math.pow((((double) this.mMonthSpltHeight) / 2.0d) + this.mCircleR, 2.0d) + Math.pow(dCalculateTempLen_185, 2.0d)) - Math.pow(((double) this.mMonthSpltWidth) / 2.0d, 2.0d)) / (((this.mCircleR + (((double) this.mMonthSpltHeight) / 2.0d)) * 2.0d) * dCalculateTempLen_185));
                double dAcos2 = Math.acos(((Math.pow((((double) this.mYearSpltHeight) / 2.0d) + this.mCircleR, 2.0d) + Math.pow(dCalculateTempLen_184, 2.0d)) - Math.pow(((double) this.mYearSpltWidth) / 2.0d, 2.0d)) / (((this.mCircleR + (((double) this.mYearSpltHeight) / 2.0d)) * 2.0d) * dCalculateTempLen_184));
                this.mSubArcYearNum = -this.mSubArcYearNum;
                this.mSubArcDayNum = -this.mSubArcDayNum;
                this.mSubArcMonth = -this.mSubArcMonth;
                this.mSubArcMonthNum = -this.mSubArcMonthNum;
                this.mSubArcSpltD = -this.mSubArcSpltD;
                this.mSubArcSpltM = -this.mSubArcSpltM;
                this.mSubArcSpltY = -dAcos2;
                return;
            }
            this.mExtraAngle = 0;
            this.mExtraAngleDate = 0;
            double d5 = this.mCircleR;
            double dCalculateTempLen = calculateTempLen(this.mDateCellWidth, d5, this.mDateCellHeight);
            double dCalculateTempLen2 = calculateTempLen(this.mMonthNumCellWidth, d5, this.mMonthNumCellHeight);
            double dCalculateTempLen3 = calculateTempLen(this.mDayNumCellWidth, d5, this.mDayNumCellHeight);
            double dCalculateTempLen4 = calculateTempLen(this.mMonthCellWidth, d5, this.mMonthCellHeight);
            double dCalculateTempLen5 = calculateTempLen(this.mYearSpltWidth, d5, this.mYearSpltHeight);
            double dCalculateTempLen6 = calculateTempLen(this.mMonthSpltWidth, d5, this.mMonthSpltHeight);
            double dCalculateTempLen7 = calculateTempLen(this.mDaySpltWidth, d5, this.mDaySpltHeight);
            this.mSubArcYearNum = calculateSubArc(this.mDateCellWidth, d5, this.mDateCellHeight, dCalculateTempLen);
            this.mSubArcMonthNum = calculateSubArc(this.mMonthNumCellWidth, d5, this.mMonthNumCellHeight, dCalculateTempLen2);
            this.mSubArcDayNum = calculateSubArc(this.mDayNumCellWidth, d5, this.mDayNumCellHeight, dCalculateTempLen3);
            this.mSubArcMonth = calculateSubArc(this.mMonthCellWidth, d5, this.mMonthCellHeight, dCalculateTempLen4);
            this.mSubArcSpltY = calculateSubArc(this.mYearSpltWidth, d5, this.mYearSpltHeight, dCalculateTempLen5);
            this.mSubArcSpltM = calculateSubArc(this.mMonthSpltWidth, d5, this.mMonthSpltHeight, dCalculateTempLen6);
            this.mSubArcSpltD = calculateSubArc(this.mDaySpltWidth, d5, this.mDaySpltHeight, dCalculateTempLen7);
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final ClockConfigFlatter getFlatter() {
        return this.flatter;
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

    public final int getMDateCellHeight() {
        return this.mDateCellHeight;
    }

    public final void setMDateCellHeight(int i) {
        this.mDateCellHeight = i;
    }

    public final int getMDateCellWidth() {
        return this.mDateCellWidth;
    }

    public final void setMDateCellWidth(int i) {
        this.mDateCellWidth = i;
    }

    public final int getMDayNumCellHeight() {
        return this.mDayNumCellHeight;
    }

    public final void setMDayNumCellHeight(int i) {
        this.mDayNumCellHeight = i;
    }

    public final int getMDayNumCellWidth() {
        return this.mDayNumCellWidth;
    }

    public final void setMDayNumCellWidth(int i) {
        this.mDayNumCellWidth = i;
    }

    public final int getMDaySpltHeight() {
        return this.mDaySpltHeight;
    }

    public final void setMDaySpltHeight(int i) {
        this.mDaySpltHeight = i;
    }

    public final int getMDaySpltWidth() {
        return this.mDaySpltWidth;
    }

    public final void setMDaySpltWidth(int i) {
        this.mDaySpltWidth = i;
    }

    public final int getMExtraAngleDate() {
        return this.mExtraAngleDate;
    }

    public final void setMExtraAngleDate(int i) {
        this.mExtraAngleDate = i;
    }

    public final int getMMonthCellHeight() {
        return this.mMonthCellHeight;
    }

    public final void setMMonthCellHeight(int i) {
        this.mMonthCellHeight = i;
    }

    public final int getMMonthCellWidth() {
        return this.mMonthCellWidth;
    }

    public final void setMMonthCellWidth(int i) {
        this.mMonthCellWidth = i;
    }

    public final int getMMonthNumCellHeight() {
        return this.mMonthNumCellHeight;
    }

    public final void setMMonthNumCellHeight(int i) {
        this.mMonthNumCellHeight = i;
    }

    public final int getMMonthNumCellWidth() {
        return this.mMonthNumCellWidth;
    }

    public final void setMMonthNumCellWidth(int i) {
        this.mMonthNumCellWidth = i;
    }

    public final int getMMonthSpltHeight() {
        return this.mMonthSpltHeight;
    }

    public final void setMMonthSpltHeight(int i) {
        this.mMonthSpltHeight = i;
    }

    public final int getMMonthSpltWidth() {
        return this.mMonthSpltWidth;
    }

    public final void setMMonthSpltWidth(int i) {
        this.mMonthSpltWidth = i;
    }

    public final double getMStartDateArc() {
        return this.mStartDateArc;
    }

    public final void setMStartDateArc(double d) {
        this.mStartDateArc = d;
    }

    public final double getMSubArcDayNum() {
        return this.mSubArcDayNum;
    }

    public final void setMSubArcDayNum(double d) {
        this.mSubArcDayNum = d;
    }

    public final double getMSubArcMonth() {
        return this.mSubArcMonth;
    }

    public final void setMSubArcMonth(double d) {
        this.mSubArcMonth = d;
    }

    public final double getMSubArcMonthNum() {
        return this.mSubArcMonthNum;
    }

    public final void setMSubArcMonthNum(double d) {
        this.mSubArcMonthNum = d;
    }

    public final double getMSubArcSpltD() {
        return this.mSubArcSpltD;
    }

    public final void setMSubArcSpltD(double d) {
        this.mSubArcSpltD = d;
    }

    public final double getMSubArcSpltM() {
        return this.mSubArcSpltM;
    }

    public final void setMSubArcSpltM(double d) {
        this.mSubArcSpltM = d;
    }

    public final double getMSubArcSpltY() {
        return this.mSubArcSpltY;
    }

    public final void setMSubArcSpltY(double d) {
        this.mSubArcSpltY = d;
    }

    public final double getMSubArcYearNum() {
        return this.mSubArcYearNum;
    }

    public final void setMSubArcYearNum(double d) {
        this.mSubArcYearNum = d;
    }

    public final int getMYearSpltHeight() {
        return this.mYearSpltHeight;
    }

    public final void setMYearSpltHeight(int i) {
        this.mYearSpltHeight = i;
    }

    public final int getMYearSpltWidth() {
        return this.mYearSpltWidth;
    }

    public final void setMYearSpltWidth(int i) {
        this.mYearSpltWidth = i;
    }

    public final Point getDateArcCenterPosition() {
        return this.dateArcCenterPosition;
    }

    public final void setDateArcCenterPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.dateArcCenterPosition = point;
    }

    public final Point getMonthPostion2() {
        return this.monthPostion2;
    }

    public final void setMonthPostion2(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.monthPostion2 = point;
    }

    public final List<Drawable> getDateMonth2NumDrawable() {
        return this.dateMonth2NumDrawable;
    }

    public final void setDateMonth2NumDrawable(List<? extends Drawable> list) {
        this.dateMonth2NumDrawable = list;
    }

    public final List<Drawable> getWeekDontsDrawable() {
        return this.weekDontsDrawable;
    }

    public final void setWeekDontsDrawable(List<? extends Drawable> list) {
        this.weekDontsDrawable = list;
    }

    public final Point getWeekDontsPosition() {
        return this.weekDontsPosition;
    }

    public final void setWeekDontsPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.weekDontsPosition = point;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v67 */
    /* JADX WARN: Type inference failed for: r4v68 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public final void draDateWithoutArc(Canvas canvas) {
        ?? r12;
        int[] iArrSolarToLunar2;
        float fIntValue;
        Drawable drawable;
        Drawable drawable2;
        float fIntValue2;
        Drawable drawable3;
        Drawable drawable4;
        Integer[] numArr;
        Drawable drawable5;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        ClockConfig config = this.flatter.getConfig();
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        int i4 = this.flatter.getDatePosition().x;
        int i5 = this.flatter.getDatePosition().y;
        boolean z = false;
        if (this.flatter.getConfig().getDate_rotate() == 1) {
            canvas.save();
            float date_rotate_degree = this.flatter.getConfig().getDate_rotate_degree();
            float f = i4;
            List<Drawable> dateDrawable = this.flatter.getDateDrawable();
            Integer numValueOf = (dateDrawable == null || (drawable5 = dateDrawable.get(0)) == null) ? null : Integer.valueOf(drawable5.getIntrinsicWidth());
            Intrinsics.checkNotNull(numValueOf);
            canvas.rotate(date_rotate_degree, f + ((numValueOf.intValue() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() : 1.0f)) / 2), i5);
        }
        if (!config.showYear() || (dateDrawable = this.flatter.getDateDrawable()) == null) {
            r12 = 0;
        } else {
            if (config.showYearType() == 0) {
                numArr = new Integer[]{Integer.valueOf(i / CharacterSets.UCS2), Integer.valueOf((i / 100) % 10), Integer.valueOf((i / 10) % 10), Integer.valueOf(i % 10)};
            } else {
                numArr = new Integer[]{Integer.valueOf((i / 10) % 10), Integer.valueOf(i % 10)};
            }
            Integer[] numArr2 = numArr;
            float absoluteScaleX = this.scaleX;
            float absoluteScaleY = this.scaleY;
            if (getSupportScale()) {
                absoluteScaleX = this.flatter.getAbsoluteScaleX();
                absoluteScaleY = this.flatter.getAbsoluteScaleY();
            }
            float f2 = absoluteScaleX;
            float f3 = absoluteScaleY;
            int length = numArr2.length;
            int i6 = i4;
            int i7 = 0;
            while (i7 < length) {
                Drawable drawable6 = dateDrawable.get(numArr2[i7].intValue());
                int intrinsicWidth = (int) (drawable6.getIntrinsicWidth() * f2);
                drawDrawable(canvas, drawable6, i6, i5, f2, f3);
                i6 += intrinsicWidth;
                i7++;
                z = z;
                length = length;
                List<Drawable> dateDrawable2 = dateDrawable2;
                numArr2 = numArr2;
            }
            r12 = z;
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
            i4 = i6;
        }
        int intrinsicWidth2 = i4;
        Drawable dateYearSplitDrawable = this.flatter.getDateYearSplitDrawable();
        if (dateYearSplitDrawable != null) {
            float scaleX = this.flatter.getScaleX();
            float scaleY = this.flatter.getScaleY();
            if (getSupportScale()) {
                scaleX = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                scaleY = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
            }
            float f4 = scaleX;
            drawDrawable(canvas, dateYearSplitDrawable, intrinsicWidth2, i5, f4, scaleY);
            intrinsicWidth2 += (int) (dateYearSplitDrawable.getIntrinsicWidth() * f4);
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        if (config.showMonth()) {
            if (config.getMonth_type() == 1) {
                List<Drawable> dateMonthNumDrawable = this.flatter.getDateMonthNumDrawable();
                if (dateMonthNumDrawable != null) {
                    Integer[] numArr3 = new Integer[1];
                    numArr3[r12] = Integer.valueOf(i2 % 12);
                    if (config.getNeed_reset_month() == 1) {
                        int i8 = this.flatter.getDateMonthPosition().x;
                        i5 = this.flatter.getDateMonthPosition().y;
                        if (this.flatter.getConfig().getDate_rotate() == 1) {
                            canvas.restore();
                        }
                        intrinsicWidth2 = i8;
                    }
                    float absoluteScaleX2 = this.scaleX;
                    float absoluteScaleX3 = this.scaleY;
                    if (getSupportScale()) {
                        absoluteScaleX2 = this.flatter.getAbsoluteScaleX();
                        absoluteScaleX3 = this.flatter.getAbsoluteScaleX();
                    }
                    float f5 = absoluteScaleX2;
                    float f6 = absoluteScaleX3;
                    ?? r4 = r12;
                    while (r4 < 1) {
                        Drawable drawable7 = dateMonthNumDrawable.get(numArr3[r4].intValue());
                        int intrinsicWidth3 = (int) (drawable7.getIntrinsicWidth() * f5);
                        drawDrawable(canvas, drawable7, intrinsicWidth2, i5, f5, f6);
                        intrinsicWidth2 += intrinsicWidth3;
                        numArr3 = numArr3;
                        dateMonthNumDrawable = dateMonthNumDrawable;
                        r4 = (r4 == true ? 1 : 0) + 1;
                    }
                    Unit unit5 = Unit.INSTANCE;
                    Unit unit6 = Unit.INSTANCE;
                }
            } else {
                List<Drawable> dateMonthNumDrawable2 = this.flatter.getDateMonthNumDrawable();
                if (dateMonthNumDrawable2 != null) {
                    int i9 = i2 + 1;
                    Integer[] numArr4 = new Integer[2];
                    numArr4[r12] = Integer.valueOf(i9 / 10);
                    numArr4[1] = Integer.valueOf(i9 % 10);
                    if (config.getNeed_reset_month() == 1) {
                        int i10 = this.flatter.getDateMonthPosition().x;
                        i5 = this.flatter.getDateMonthPosition().y;
                        if (this.flatter.getConfig().getDate_rotate() == 1) {
                            canvas.save();
                            float date_rotate_degree2 = this.flatter.getConfig().getDate_rotate_degree();
                            float f7 = i10;
                            if (getSupportScale()) {
                                float absoluteScaleX4 = this.flatter.getAbsoluteScaleX();
                                List<Drawable> dateMonthNumDrawable3 = this.flatter.getDateMonthNumDrawable();
                                Integer numValueOf2 = (dateMonthNumDrawable3 == null || (drawable4 = dateMonthNumDrawable3.get(r12)) == null) ? null : Integer.valueOf(drawable4.getIntrinsicWidth());
                                Intrinsics.checkNotNull(numValueOf2);
                                fIntValue2 = absoluteScaleX4 * numValueOf2.intValue();
                            } else {
                                List<Drawable> dateMonthNumDrawable4 = this.flatter.getDateMonthNumDrawable();
                                Integer numValueOf3 = (dateMonthNumDrawable4 == null || (drawable3 = dateMonthNumDrawable4.get(r12)) == null) ? null : Integer.valueOf(drawable3.getIntrinsicWidth());
                                Intrinsics.checkNotNull(numValueOf3);
                                fIntValue2 = numValueOf3.intValue();
                            }
                            canvas.rotate(date_rotate_degree2, f7 + (fIntValue2 / 2), i5);
                        }
                        intrinsicWidth2 = i10;
                    }
                    float absoluteScaleX5 = this.scaleX;
                    float absoluteScaleY2 = this.scaleY;
                    if (getSupportScale()) {
                        absoluteScaleX5 = this.flatter.getAbsoluteScaleX();
                        absoluteScaleY2 = this.flatter.getAbsoluteScaleY();
                    }
                    float f8 = absoluteScaleX5;
                    float f9 = absoluteScaleY2;
                    ?? r5 = r12;
                    while (r5 < 2) {
                        Drawable drawable8 = dateMonthNumDrawable2.get(numArr4[r5].intValue());
                        int intrinsicWidth4 = (int) (drawable8.getIntrinsicWidth() * f8);
                        drawDrawable(canvas, drawable8, intrinsicWidth2, i5, f8, f9);
                        intrinsicWidth2 += intrinsicWidth4;
                        numArr4 = numArr4;
                        dateMonthNumDrawable2 = dateMonthNumDrawable2;
                        r5 = (r5 == true ? 1 : 0) + 1;
                    }
                    if (config.getNeed_reset_month() == 1 && this.flatter.getConfig().getDate_rotate() == 1) {
                        canvas.restore();
                    }
                    Unit unit7 = Unit.INSTANCE;
                    Unit unit8 = Unit.INSTANCE;
                }
            }
        }
        Drawable dateMonthSplitDrawable = this.flatter.getDateMonthSplitDrawable();
        if (dateMonthSplitDrawable != null) {
            int intrinsicWidth5 = (int) (dateMonthSplitDrawable.getIntrinsicWidth() * (getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX()));
            drawDrawable(canvas, dateMonthSplitDrawable, intrinsicWidth2, i5, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
            intrinsicWidth2 += intrinsicWidth5;
            Unit unit9 = Unit.INSTANCE;
            Unit unit10 = Unit.INSTANCE;
        }
        if (config.showDay()) {
            if (this.flatter.getConfig().getDay_type() == 1) {
                List<Drawable> dateDayNumDrawable = this.flatter.getDateDayNumDrawable();
                if (dateDayNumDrawable != null) {
                    Integer[] numArr5 = new Integer[1];
                    numArr5[r12] = Integer.valueOf((i3 - 1) % 31);
                    if (config.getNeed_reset_day() == 1) {
                        intrinsicWidth2 = this.flatter.getDateDayPosition().x;
                        i5 = this.flatter.getDateDayPosition().y;
                    }
                    float absoluteScaleX6 = this.scaleX;
                    float absoluteScaleY3 = this.scaleY;
                    if (getSupportScale()) {
                        absoluteScaleX6 = this.flatter.getAbsoluteScaleX();
                        absoluteScaleY3 = this.flatter.getAbsoluteScaleY();
                    }
                    float f10 = absoluteScaleX6;
                    float f11 = absoluteScaleY3;
                    ?? r6 = r12;
                    while (r6 < 1) {
                        Drawable drawable9 = dateDayNumDrawable.get(numArr5[r6].intValue());
                        int intrinsicWidth6 = (int) (drawable9.getIntrinsicWidth() * f10);
                        drawDrawable(canvas, drawable9, intrinsicWidth2, i5, f10, f11);
                        intrinsicWidth2 += intrinsicWidth6;
                        numArr5 = numArr5;
                        r6 = (r6 == true ? 1 : 0) + 1;
                    }
                    Unit unit11 = Unit.INSTANCE;
                    Unit unit12 = Unit.INSTANCE;
                }
            } else {
                List<Drawable> dateDayNumDrawable2 = this.flatter.getDateDayNumDrawable();
                if (dateDayNumDrawable2 != null) {
                    Integer[] numArr6 = new Integer[2];
                    numArr6[r12] = Integer.valueOf(i3 / 10);
                    numArr6[1] = Integer.valueOf(i3 % 10);
                    if (config.getNeed_reset_day() == 1) {
                        int i11 = this.flatter.getDateDayPosition().x;
                        int i12 = this.flatter.getDateDayPosition().y;
                        if (this.flatter.getConfig().getDate_rotate() == 1) {
                            canvas.save();
                            float date_rotate_degree3 = this.flatter.getConfig().getDate_rotate_degree();
                            float f12 = i11;
                            if (getSupportScale()) {
                                float absoluteScaleX7 = this.flatter.getAbsoluteScaleX();
                                List<Drawable> dateDayNumDrawable3 = this.flatter.getDateDayNumDrawable();
                                Integer numValueOf4 = (dateDayNumDrawable3 == null || (drawable2 = dateDayNumDrawable3.get(r12)) == null) ? null : Integer.valueOf(drawable2.getIntrinsicWidth());
                                Intrinsics.checkNotNull(numValueOf4);
                                fIntValue = absoluteScaleX7 * numValueOf4.intValue();
                            } else {
                                List<Drawable> dateDayNumDrawable4 = this.flatter.getDateDayNumDrawable();
                                Integer numValueOf5 = (dateDayNumDrawable4 == null || (drawable = dateDayNumDrawable4.get(r12)) == null) ? null : Integer.valueOf(drawable.getIntrinsicWidth());
                                Intrinsics.checkNotNull(numValueOf5);
                                fIntValue = numValueOf5.intValue();
                            }
                            canvas.rotate(date_rotate_degree3, f12 + (fIntValue / 2), i12);
                        }
                        intrinsicWidth2 = i11;
                        i5 = i12;
                    }
                    if (config.getNeed_split_day() == 0) {
                        float absoluteScaleX8 = this.scaleX;
                        float absoluteScaleY4 = this.scaleY;
                        if (getSupportScale()) {
                            absoluteScaleX8 = this.flatter.getAbsoluteScaleX();
                            absoluteScaleY4 = this.flatter.getAbsoluteScaleY();
                        }
                        float f13 = absoluteScaleX8;
                        float f14 = absoluteScaleY4;
                        ?? r7 = r12;
                        char c = 2;
                        while (r7 < c) {
                            Drawable drawable10 = dateDayNumDrawable2.get(numArr6[r7].intValue());
                            int intrinsicWidth7 = (int) (drawable10.getIntrinsicWidth() * f13);
                            drawDrawable(canvas, drawable10, intrinsicWidth2, i5, f13, f14);
                            intrinsicWidth2 += intrinsicWidth7;
                            numArr6 = numArr6;
                            c = 2;
                            r7 = (r7 == true ? 1 : 0) + 1;
                        }
                    } else {
                        float absoluteScaleX9 = this.scaleX;
                        float absoluteScaleY5 = this.scaleY;
                        if (getSupportScale()) {
                            absoluteScaleX9 = this.flatter.getAbsoluteScaleX();
                            absoluteScaleY5 = this.flatter.getAbsoluteScaleY();
                        }
                        float f15 = absoluteScaleX9;
                        float f16 = absoluteScaleY5;
                        drawDrawable(canvas, dateDayNumDrawable2.get(numArr6[r12].intValue()), this.flatter.getDateDayPosition().x, this.flatter.getDateDayPosition().y, f15, f16);
                        int i13 = this.flatter.getDateDay2Position().x;
                        int i14 = this.flatter.getDateDay2Position().y;
                        Iterator it = ArraysKt.drop(numArr6, 1).iterator();
                        int i15 = i13;
                        while (it.hasNext()) {
                            Drawable drawable11 = dateDayNumDrawable2.get(((Number) it.next()).intValue());
                            int intrinsicWidth8 = (int) (drawable11.getIntrinsicWidth() * f15);
                            drawDrawable(canvas, drawable11, i15, i14, f15, f16);
                            i15 += intrinsicWidth8;
                            i14 = i14;
                        }
                    }
                    Unit unit13 = Unit.INSTANCE;
                    Unit unit14 = Unit.INSTANCE;
                }
            }
            int i16 = i5;
            int i17 = intrinsicWidth2;
            Drawable dateDaySplitDrawable = this.flatter.getDateDaySplitDrawable();
            if (dateDaySplitDrawable != null) {
                float scaleX2 = this.flatter.getScaleX();
                float scaleY2 = this.flatter.getScaleY();
                if (getSupportScale()) {
                    scaleX2 = this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX();
                    scaleY2 = this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY();
                }
                dateDaySplitDrawable.getIntrinsicWidth();
                drawDrawable(canvas, dateDaySplitDrawable, i17, i16, scaleX2, scaleY2);
                Unit unit15 = Unit.INSTANCE;
                Unit unit16 = Unit.INSTANCE;
            }
            if (this.flatter.getConfig().getDate_rotate() == 1) {
                canvas.restore();
            }
        }
        if (config.showLunar()) {
            if (!StringsKt.contains$default(SystemUtils.INSTANCE.getLanguage(this.context), "zh", (boolean) r12, 2, (Object) null)) {
                return;
            }
            List<Drawable> lunarDrawable = this.flatter.getLunarDrawable();
            if (lunarDrawable != null && (iArrSolarToLunar2 = LunarUtils.INSTANCE.solarToLunar2(i, i2 + 1, i3)) != null) {
                if (lunarDrawable.size() >= 16) {
                    ArrayList<Drawable> arrayList = new ArrayList();
                    int i18 = iArrSolarToLunar2[1];
                    int i19 = iArrSolarToLunar2[2];
                    if (i18 == 1) {
                        arrayList.add(lunarDrawable.get(12));
                        Unit unit17 = Unit.INSTANCE;
                    } else if (i18 == 11) {
                        arrayList.add(lunarDrawable.get(13));
                        Unit unit18 = Unit.INSTANCE;
                    } else if (i18 == 12) {
                        arrayList.add(lunarDrawable.get(14));
                        Unit unit19 = Unit.INSTANCE;
                    } else {
                        arrayList.add(lunarDrawable.get(i18 - 1));
                        Unit unit20 = Unit.INSTANCE;
                    }
                    arrayList.add(lunarDrawable.get(15));
                    if (i19 <= 10) {
                        arrayList.add(lunarDrawable.get(10));
                        arrayList.add(lunarDrawable.get(i19 - 1));
                    } else if (i19 < 20) {
                        arrayList.add(lunarDrawable.get(9));
                        arrayList.add(lunarDrawable.get(i19 - 11));
                    } else if (i19 >= 30) {
                        arrayList.add(lunarDrawable.get(2));
                        arrayList.add(lunarDrawable.get(9));
                        if (i19 > 30) {
                            arrayList.add(lunarDrawable.get(i19 - 31));
                        }
                    } else if (i19 > 20) {
                        arrayList.add(lunarDrawable.get(11));
                        arrayList.add(lunarDrawable.get(i19 - 21));
                    } else {
                        arrayList.add(lunarDrawable.get(1));
                        arrayList.add(lunarDrawable.get(9));
                    }
                    int i20 = this.flatter.getLunarPosition().y;
                    int i21 = this.flatter.getLunarPosition().x;
                    float absoluteScaleX10 = this.scaleX;
                    float absoluteScaleY6 = this.scaleY;
                    if (getSupportScale()) {
                        absoluteScaleX10 = this.flatter.getAbsoluteScaleX();
                        absoluteScaleY6 = this.flatter.getAbsoluteScaleY();
                    }
                    float f17 = absoluteScaleX10;
                    float f18 = absoluteScaleY6;
                    int intrinsicWidth9 = i21;
                    for (Drawable drawable12 : arrayList) {
                        drawDrawable(canvas, drawable12, intrinsicWidth9, i20, f17, f18);
                        intrinsicWidth9 += (int) (drawable12.getIntrinsicWidth() * f17);
                    }
                }
                Unit unit21 = Unit.INSTANCE;
                Unit unit22 = Unit.INSTANCE;
            }
        }
        Unit unit23 = Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00f3 A[PHI: r0
      0x00f3: PHI (r0v4 double) = (r0v3 double), (r0v156 double) binds: [B:6:0x0046, B:8:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    public final void drawDateWithArc(Canvas canvas) {
        double d;
        boolean z;
        boolean z2;
        List<Drawable> lunarDrawable;
        int[] iArrSolarToLunar2;
        Integer[] numArr;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        ClockConfig config = this.flatter.getConfig();
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        double d2 = this.mStartArc;
        int i4 = this.flatter.getDatePosition().x;
        int i5 = this.flatter.getDatePosition().y;
        if (getSupportScale()) {
            this.flatter.getAbsoluteScaleX();
        }
        if (config.showYear()) {
            d2 += this.mSubArcYearNum;
            List<Drawable> dateDrawable = this.flatter.getDateDrawable();
            if (dateDrawable != null) {
                if (config.showYearType() == 0) {
                    numArr = new Integer[]{Integer.valueOf(i / CharacterSets.UCS2), Integer.valueOf((i / 100) % 10), Integer.valueOf((i / 10) % 10), Integer.valueOf(i % 10)};
                } else {
                    numArr = new Integer[]{Integer.valueOf((i / 10) % 10), Integer.valueOf(i % 10)};
                }
                Integer[] numArr2 = numArr;
                float absoluteScaleX = this.scaleX;
                float absoluteScaleY = this.scaleY;
                if (getSupportScale()) {
                    absoluteScaleX = this.flatter.getAbsoluteScaleX();
                    absoluteScaleY = this.flatter.getAbsoluteScaleY();
                }
                float f = absoluteScaleX;
                float f2 = absoluteScaleY;
                int length = numArr2.length;
                d = d2;
                int i6 = 0;
                while (i6 < length) {
                    drawByAngle(canvas, dateDrawable.get(numArr2[i6].intValue()), this.mDateCellWidth, d, f, f2);
                    d += ((double) 2) * this.mSubArcYearNum;
                    i6++;
                    length = length;
                    dateDrawable = dateDrawable;
                    numArr2 = numArr2;
                }
            } else {
                d = d2;
            }
        } else {
            d = d2;
        }
        Drawable dateYearSplitDrawable = this.flatter.getDateYearSplitDrawable();
        if (dateYearSplitDrawable != null) {
            drawByAngle(canvas, dateYearSplitDrawable, this.mYearSpltWidth, d, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
            d += ((double) 2) * this.mSubArcSpltY;
            z = true;
        } else {
            z = false;
        }
        if (config.showMonth()) {
            if (config.getMonth_type() == 1) {
                List<Drawable> dateMonthNumDrawable = this.flatter.getDateMonthNumDrawable();
                if (dateMonthNumDrawable != null) {
                    boolean z3 = false;
                    Integer[] numArr3 = {Integer.valueOf(i2 % 12)};
                    if (!z) {
                        d += ((double) 1) * this.mSubArcYearNum;
                    }
                    if (config.getNeed_reset_month() == 1) {
                        d = this.mStartDateArc + this.mSubArcYearNum;
                    }
                    int i7 = 0;
                    for (int i8 = 1; i7 < i8; i8 = 1) {
                        drawByAngle(canvas, dateMonthNumDrawable.get(numArr3[i7].intValue()), this.mDateCellWidth, d, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX, getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scaleY);
                        d += ((double) 2) * this.mSubArcYearNum;
                        i7++;
                        z3 = z3;
                        numArr3 = numArr3;
                        dateMonthNumDrawable = dateMonthNumDrawable;
                    }
                }
            } else {
                List<Drawable> dateMonthNumDrawable2 = this.flatter.getDateMonthNumDrawable();
                if (dateMonthNumDrawable2 != null) {
                    int i9 = i2 + 1;
                    Integer[] numArr4 = {Integer.valueOf(i9 / 10), Integer.valueOf(i9 % 10)};
                    if (!z) {
                        d += ((double) 1) * this.mSubArcYearNum;
                    }
                    if (config.getNeed_reset_month() == 1) {
                        d = this.mStartDateArc + this.mSubArcYearNum;
                    }
                    int i10 = 0;
                    while (i10 < 2) {
                        drawByAngle(canvas, dateMonthNumDrawable2.get(numArr4[i10].intValue()), this.mDateCellWidth, d, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX, getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scaleY);
                        d += ((double) 2) * this.mSubArcYearNum;
                        i10++;
                        numArr4 = numArr4;
                        dateMonthNumDrawable2 = dateMonthNumDrawable2;
                    }
                }
            }
            i = i;
        } else {
            i = i;
        }
        Drawable dateMonthSplitDrawable = this.flatter.getDateMonthSplitDrawable();
        if (dateMonthSplitDrawable != null) {
            drawByAngle(canvas, dateMonthSplitDrawable, this.mMonthSpltWidth, d, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
            d += ((double) 2) * this.mSubArcSpltM;
            z2 = true;
        } else {
            z2 = false;
        }
        if (config.showDay()) {
            List<Drawable> dateDayNumDrawable = this.flatter.getDateDayNumDrawable();
            if (dateDayNumDrawable != null) {
                Integer[] numArr5 = {Integer.valueOf(i3 / 10), Integer.valueOf(i3 % 10)};
                if (!z2) {
                    d += this.mSubArcYearNum;
                }
                if (config.getNeed_reset_day() == 1) {
                    d = this.mStartDateArc + this.mSubArcYearNum;
                }
                for (int i11 = 0; i11 < 2; i11++) {
                    drawByAngle(canvas, dateDayNumDrawable.get(numArr5[i11].intValue()), this.mDateCellWidth, d, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX, getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scaleY);
                    d += ((double) 2) * this.mSubArcYearNum;
                }
            }
            Drawable dateDaySplitDrawable = this.flatter.getDateDaySplitDrawable();
            if (dateDaySplitDrawable != null) {
                drawByAngle(canvas, dateDaySplitDrawable, this.mDaySpltWidth, d + this.mSubArcSpltD, getSupportScale() ? this.flatter.getAbsoluteScaleX() * this.flatter.getScaleX() : this.flatter.getScaleX(), getSupportScale() ? this.flatter.getAbsoluteScaleY() * this.flatter.getScaleY() : this.flatter.getScaleY());
            }
        }
        if (!config.showLunar() || !StringsKt.contains$default((CharSequence) SystemUtils.INSTANCE.getLanguage(this.context), (CharSequence) "zh", false, 2, (Object) null) || (lunarDrawable = this.flatter.getLunarDrawable()) == null || (iArrSolarToLunar2 = LunarUtils.INSTANCE.solarToLunar2(i, i2 + 1, i3)) == null || lunarDrawable.size() < 16) {
            return;
        }
        ArrayList<Drawable> arrayList = new ArrayList();
        int i12 = iArrSolarToLunar2[1];
        int i13 = iArrSolarToLunar2[2];
        if (i12 == 1) {
            arrayList.add(lunarDrawable.get(12));
        } else if (i12 == 11) {
            arrayList.add(lunarDrawable.get(13));
        } else if (i12 == 12) {
            arrayList.add(lunarDrawable.get(14));
        } else {
            arrayList.add(lunarDrawable.get(i12 - 1));
        }
        arrayList.add(lunarDrawable.get(15));
        if (i13 <= 10) {
            arrayList.add(lunarDrawable.get(10));
            arrayList.add(lunarDrawable.get(i13 - 1));
        } else if (i13 < 20) {
            arrayList.add(lunarDrawable.get(9));
            arrayList.add(lunarDrawable.get(i13 - 11));
        } else if (i13 >= 30) {
            arrayList.add(lunarDrawable.get(2));
            arrayList.add(lunarDrawable.get(9));
            if (i13 > 30) {
                arrayList.add(lunarDrawable.get(i13 - 31));
            }
        } else if (i13 > 20) {
            arrayList.add(lunarDrawable.get(11));
            arrayList.add(lunarDrawable.get(i13 - 21));
        } else {
            arrayList.add(lunarDrawable.get(1));
            arrayList.add(lunarDrawable.get(9));
        }
        int i14 = this.flatter.getLunarPosition().y;
        int i15 = this.flatter.getLunarPosition().x;
        float absoluteScaleX2 = this.scaleX;
        float absoluteScaleY2 = this.scaleY;
        if (getSupportScale()) {
            absoluteScaleX2 = this.flatter.getAbsoluteScaleX();
            absoluteScaleY2 = this.flatter.getAbsoluteScaleY();
        }
        float f3 = absoluteScaleX2;
        float f4 = absoluteScaleY2;
        int intrinsicWidth = i15;
        for (Drawable drawable : arrayList) {
            drawDrawable(canvas, drawable, intrinsicWidth, i14, f3, f4);
            intrinsicWidth += (int) (drawable.getIntrinsicWidth() * f3);
        }
    }

    @Override // com.dw.launcher.ui.clock.painter.IBasePainter
    public void draw(Canvas canvas, Paint paint) {
        List<? extends Drawable> list;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(7);
        List<Drawable> weekNumDrawable = this.flatter.getWeekNumDrawable();
        if (weekNumDrawable != null) {
            drawDrawable(canvas, weekNumDrawable.get(i - 1), this.flatter.getWeekPosition().x, this.flatter.getWeekPosition().y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX, getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scaleY);
        }
        List<? extends Drawable> list2 = this.weekDontsDrawable;
        if (list2 != null) {
            drawDrawable(canvas, list2.get(i - 1), this.weekDontsPosition.x, this.weekDontsPosition.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX, getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scaleY);
        }
        if (this.flatter.getConfig().getOpen_date_arc_show() == 0) {
            draDateWithoutArc(canvas);
        } else {
            drawDateWithArc(canvas);
        }
        int i2 = calendar.get(2);
        if (this.flatter.getConfig().getShow_month_2() == 1 && this.flatter.getConfig().getMonth_type_2() == 1 && (list = this.dateMonth2NumDrawable) != null) {
            drawDrawable(canvas, list.get(new Integer[]{Integer.valueOf(i2 % 12)}[0].intValue()), this.monthPostion2.x, this.monthPostion2.y, getSupportScale() ? this.flatter.getAbsoluteScaleX() : this.scaleX, getSupportScale() ? this.flatter.getAbsoluteScaleY() : this.scaleY);
        }
    }
}
