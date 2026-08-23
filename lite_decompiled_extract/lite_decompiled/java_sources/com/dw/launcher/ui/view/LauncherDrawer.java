package com.dw.launcher.ui.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.dw.launcher.R;
import com.dw.launcher.base.OnDrawerListener;
import com.google.android.mms.pdu.CharacterSets;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

/* JADX INFO: compiled from: LauncherDrawer.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u009a\u00012\u00020\u0001:\u000e\u009a\u0001\u009b\u0001\u009c\u0001\u009d\u0001\u009e\u0001\u009f\u0001 \u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010D\u001a\u00020EJ\u0006\u0010F\u001a\u00020\u0018J\u0006\u0010G\u001a\u00020\u0018J\u000e\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020\u0012J\u0018\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u0018H\u0002J\u0006\u0010K\u001a\u00020EJ\u000e\u0010K\u001a\u00020E2\u0006\u0010L\u001a\u00020\u0018J\u0010\u0010M\u001a\u00020E2\b\u0010N\u001a\u0004\u0018\u00010\u0012J\b\u0010O\u001a\u00020EH\u0016J\u0006\u0010P\u001a\u00020EJ\u0006\u0010Q\u001a\u00020EJ\u0012\u0010R\u001a\u00020\u00182\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0018\u0010U\u001a\u00020\u00182\u0006\u0010S\u001a\u00020T2\u0006\u0010V\u001a\u00020\u0012H\u0002J\u0006\u0010W\u001a\u00020EJ\u000e\u0010X\u001a\u00020E2\u0006\u0010W\u001a\u00020\u0018J\u000e\u0010Y\u001a\u00020E2\u0006\u0010W\u001a\u00020\u0018J\u000e\u0010Z\u001a\u00020E2\u0006\u0010W\u001a\u00020\u0018J\u0006\u0010[\u001a\u00020EJ\b\u0010\\\u001a\u00020EH\u0002J\n\u0010]\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010^\u001a\u00020_H\u0014J\u0010\u0010`\u001a\u00020_2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020_H\u0014J\u000e\u0010b\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u0012J\u000e\u0010b\u001a\u00020\t2\u0006\u0010c\u001a\u00020\tJ\u0010\u0010d\u001a\u00020&2\u0006\u0010I\u001a\u00020\u0012H\u0002J\u0018\u0010e\u001a\u00020T2\u0006\u0010S\u001a\u00020T2\u0006\u0010V\u001a\u00020\u0012H\u0002J\u0010\u0010f\u001a\u00020E2\b\u0010N\u001a\u0004\u0018\u00010\u0012J\b\u0010g\u001a\u00020\u0018H\u0002J\u0010\u0010h\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u0012H\u0002J\u0010\u0010i\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u0012H\u0002J\u0018\u0010j\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u00122\u0006\u0010k\u001a\u00020\tH\u0002J\u0010\u0010l\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u0012H\u0002J\u0010\u0010m\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u0012H\u0002J \u0010n\u001a\u00020\u00182\u0006\u0010o\u001a\u00020&2\u0006\u0010p\u001a\u00020&2\u0006\u0010V\u001a\u00020\u0012H\u0002J\b\u0010q\u001a\u00020\u0018H\u0002J\u0010\u0010r\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u0012H\u0002J\u0006\u0010s\u001a\u00020\u0018J\u0010\u0010t\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u0012H\u0002J\u0010\u0010u\u001a\u00020E2\u0006\u0010v\u001a\u00020\tH\u0002J\u0010\u0010w\u001a\u00020E2\u0006\u0010x\u001a\u00020yH\u0002J\u0018\u0010z\u001a\u00020E2\u0006\u0010I\u001a\u00020\u00122\u0006\u0010{\u001a\u00020&H\u0002J\b\u0010|\u001a\u00020EH\u0014J\b\u0010}\u001a\u00020EH\u0014J\b\u0010~\u001a\u00020EH\u0014J\u0011\u0010\u007f\u001a\u00020\u00182\u0007\u0010\u0080\u0001\u001a\u00020TH\u0016J6\u0010\u0081\u0001\u001a\u00020E2\u0007\u0010\u0082\u0001\u001a\u00020\u00182\u0007\u0010\u0083\u0001\u001a\u00020\t2\u0007\u0010\u0084\u0001\u001a\u00020\t2\u0007\u0010\u0085\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020\tH\u0014J\u001b\u0010\u0087\u0001\u001a\u00020E2\u0007\u0010\u0088\u0001\u001a\u00020\t2\u0007\u0010\u0089\u0001\u001a\u00020\tH\u0014J\u0011\u0010\u008a\u0001\u001a\u00020\u00182\u0006\u0010S\u001a\u00020TH\u0016J\u001b\u0010\u008b\u0001\u001a\u00020E2\u0006\u0010I\u001a\u00020\u00122\b\b\u0002\u0010J\u001a\u00020\u0018H\u0002J\u0011\u0010\u008c\u0001\u001a\u00020E2\b\b\u0002\u0010J\u001a\u00020\u0018J\u0011\u0010\u008d\u0001\u001a\u00020E2\b\b\u0002\u0010J\u001a\u00020\u0018J\t\u0010\u008e\u0001\u001a\u00020EH\u0016J\u0007\u0010\u008f\u0001\u001a\u00020EJ\u0010\u0010\u0090\u0001\u001a\u00020E2\u0007\u0010\u0091\u0001\u001a\u00020\u0018J\u000f\u0010\u0092\u0001\u001a\u00020E2\u0006\u0010\u000b\u001a\u00020\fJ\u0019\u0010\u0093\u0001\u001a\u00020E2\u0006\u0010I\u001a\u00020\u00122\u0006\u0010{\u001a\u00020&H\u0002J\u0011\u0010\u0094\u0001\u001a\u00020E2\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001J\u001d\u0010\u0097\u0001\u001a\u00020E2\u0007\u0010\u0098\u0001\u001a\u00020\t2\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0012H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020\tX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\tX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b/\u0010-R\u0014\u00100\u001a\u00020\tX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b1\u0010-R\u0014\u00102\u001a\u00020\tX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b3\u0010-R\u000e\u00104\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0014\"\u0004\b=\u0010\u0016R\u000e\u0010>\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010?\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010@\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0014\"\u0004\bB\u0010\u0016R\u000e\u0010C\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¡\u0001"}, d2 = {"Lcom/dw/launcher/ui/view/LauncherDrawer;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listener", "Lcom/dw/launcher/ui/view/LauncherDrawer$DrawerListener;", "mBottomDragger", "Landroidx/customview/widget/ViewDragHelper;", "mBottomDraggerCallback", "Lcom/dw/launcher/ui/view/LauncherDrawer$ViewDragCallback;", "mBottomDrawer", "Landroid/view/View;", "getMBottomDrawer", "()Landroid/view/View;", "setMBottomDrawer", "(Landroid/view/View;)V", "mBottomDrawerDisabled", "", "mCapturedView", "mChildHitRect", "Landroid/graphics/Rect;", "mChildInvertedMatrix", "Landroid/graphics/Matrix;", "mChildrenCanceledTouch", "mContentView", "mDisabled", "mDrawerState", "mEndDrawer", "mFirstLayout", "mInLayout", "mInitialMotionX", "", "mInitialMotionY", "mLeftDragger", "mLeftDraggerCallback", "mLeftDrawerDisabled", "mLockModeBottom", "getMLockModeBottom$annotations", "()V", "mLockModeLeft", "getMLockModeLeft$annotations", "mLockModeRight", "getMLockModeRight$annotations", "mLockModeTop", "getMLockModeTop$annotations", "mMinDrawerMargin", "mRightDragger", "mRightDraggerCallback", "mScrimColor", "mScrimOpacity", "mScrimPaint", "Landroid/graphics/Paint;", "mStartDrawer", "getMStartDrawer", "setMStartDrawer", "mTopDragger", "mTopDraggerCallback", "mTopDrawer", "getMTopDrawer", "setMTopDrawer", "mTopDrawerDisabled", "cancelChildViewTouch", "", "childVisible", "childVisibleWithNoRight", "closeDrawer", "drawerView", "animate", "closeDrawers", "peekingOnly", "closeOthersWithoutCurrent", "view", "computeScroll", "disable", "disableWithKeepDrawer", "dispatchGenericMotionEvent", "event", "Landroid/view/MotionEvent;", "dispatchTransformedGenericPointerEvent", "child", "enable", "enableBottomDrawer", "enableLeftDrawer", "enableTopDrawer", "enableWithKeepDrawer", "findDrawers", "findOpenDrawer", "generateDefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "generateLayoutParams", "p", "getDrawerLockMode", "edgeGravity", "getDrawerViewOffset", "getTransformedMotionEvent", "hasOpenDrawer", "hasPeekingDrawer", "isBottomDrawer", "isContentView", "isDrawerGravityMatched", "gravity", "isDrawerView", "isEndDrawer", "isInBoundsOfChild", "x", "y", "isLayoutDirectionRTL", "isStartDrawer", "isStartDrawerShow", "isTopDrawer", "lockOtherDrawers", "openGravity", "log", "message", "", "moveDrawerToOffset", "slideOffset", "onAttachedToWindow", "onDetachedFromWindow", "onFinishInflate", "onInterceptTouchEvent", "ev", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "openDrawer", "openStartDrawer", "openTopDrawer", "requestLayout", "resetDraggers", "restoreDrawerState", "useSelfStatusBar", "setDrawerListener", "setDrawerViewOffset", "setOnDrawerListener", "mOnDrawerListener", "Lcom/dw/launcher/base/OnDrawerListener;", "updateDrawerState", "activeState", "activeDrawer", "Companion", "DrawerListener", "EdgeGravity", "LayoutParams", "LockMode", "State", "ViewDragCallback", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class LauncherDrawer extends ViewGroup {
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    public static final int EDGE_SIZE = 60;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 0;
    private static final long PEEK_DELAY = 160;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private DrawerListener listener;
    private final ViewDragHelper mBottomDragger;
    private final ViewDragCallback mBottomDraggerCallback;
    private View mBottomDrawer;
    private boolean mBottomDrawerDisabled;
    private View mCapturedView;
    private Rect mChildHitRect;
    private Matrix mChildInvertedMatrix;
    private boolean mChildrenCanceledTouch;
    private View mContentView;
    private boolean mDisabled;
    private int mDrawerState;
    private View mEndDrawer;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private final ViewDragHelper mLeftDragger;
    private final ViewDragCallback mLeftDraggerCallback;
    private boolean mLeftDrawerDisabled;
    private int mLockModeBottom;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeTop;
    private int mMinDrawerMargin;
    private final ViewDragHelper mRightDragger;
    private final ViewDragCallback mRightDraggerCallback;
    private final int mScrimColor;
    private float mScrimOpacity;
    private final Paint mScrimPaint;
    private View mStartDrawer;
    private final ViewDragHelper mTopDragger;
    private final ViewDragCallback mTopDraggerCallback;
    private View mTopDrawer;
    private boolean mTopDrawerDisabled;
    private static final String TAG = "LauncherDrawer";
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    private static final int MIN_FLING_VELOCITY = 400;

    /* JADX INFO: compiled from: LauncherDrawer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/dw/launcher/ui/view/LauncherDrawer$DrawerListener;", "", "onDrawerClosed", "", "drawerView", "Landroid/view/View;", "onDrawerOpened", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public interface DrawerListener {
        void onDrawerClosed(View drawerView);

        void onDrawerOpened(View drawerView);
    }

    /* JADX INFO: compiled from: LauncherDrawer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/dw/launcher/ui/view/LauncherDrawer$EdgeGravity;", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    private @interface EdgeGravity {
    }

    /* JADX INFO: compiled from: LauncherDrawer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/dw/launcher/ui/view/LauncherDrawer$LockMode;", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    private @interface LockMode {
    }

    /* JADX INFO: compiled from: LauncherDrawer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/dw/launcher/ui/view/LauncherDrawer$State;", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    private @interface State {
    }

    private static /* synthetic */ void getMLockModeBottom$annotations() {
    }

    private static /* synthetic */ void getMLockModeLeft$annotations() {
    }

    private static /* synthetic */ void getMLockModeRight$annotations() {
    }

    private static /* synthetic */ void getMLockModeTop$annotations() {
    }

    public final void setOnDrawerListener(OnDrawerListener mOnDrawerListener) {
        Intrinsics.checkNotNullParameter(mOnDrawerListener, "mOnDrawerListener");
    }

    public final View getMStartDrawer() {
        return this.mStartDrawer;
    }

    public final void setMStartDrawer(View view) {
        this.mStartDrawer = view;
    }

    public final View getMTopDrawer() {
        return this.mTopDrawer;
    }

    public final void setMTopDrawer(View view) {
        this.mTopDrawer = view;
    }

    public final View getMBottomDrawer() {
        return this.mBottomDrawer;
    }

    public final void setMBottomDrawer(View view) {
        this.mBottomDrawer = view;
    }

    public LauncherDrawer(Context context) throws IllegalAccessException, NoSuchFieldException {
        super(context);
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeTop = 3;
        this.mLockModeBottom = 3;
        this.mFirstLayout = true;
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        this.mScrimPaint = new Paint();
        float f = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((MIN_DRAWER_MARGIN * f) + 0.5f);
        ViewDragCallback viewDragCallback = new ViewDragCallback(8388611);
        this.mLeftDraggerCallback = viewDragCallback;
        LauncherDrawer launcherDrawer = this;
        float f2 = TOUCH_SLOP_SENSITIVITY;
        ViewDragHelper viewDragHelperCreate = ViewDragHelper.create(launcherDrawer, f2, viewDragCallback);
        Intrinsics.checkNotNullExpressionValue(viewDragHelperCreate, "create(...)");
        this.mLeftDragger = viewDragHelperCreate;
        viewDragHelperCreate.setEdgeTrackingEnabled(1);
        int i = MIN_FLING_VELOCITY;
        viewDragHelperCreate.setMinVelocity(i * f);
        viewDragCallback.setDragger(viewDragHelperCreate);
        ViewDragCallback viewDragCallback2 = new ViewDragCallback(8388613);
        this.mRightDraggerCallback = viewDragCallback2;
        ViewDragHelper viewDragHelperCreate2 = ViewDragHelper.create(launcherDrawer, f2, viewDragCallback2);
        Intrinsics.checkNotNullExpressionValue(viewDragHelperCreate2, "create(...)");
        this.mRightDragger = viewDragHelperCreate2;
        viewDragHelperCreate2.setEdgeTrackingEnabled(2);
        viewDragHelperCreate2.setMinVelocity(i * f);
        viewDragCallback2.setDragger(viewDragHelperCreate2);
        ViewDragCallback viewDragCallback3 = new ViewDragCallback(48);
        this.mTopDraggerCallback = viewDragCallback3;
        ViewDragHelper viewDragHelperCreate3 = ViewDragHelper.create(launcherDrawer, f2, viewDragCallback3);
        Intrinsics.checkNotNullExpressionValue(viewDragHelperCreate3, "create(...)");
        this.mTopDragger = viewDragHelperCreate3;
        viewDragHelperCreate3.setEdgeTrackingEnabled(4);
        viewDragHelperCreate3.setMinVelocity(i * f);
        viewDragCallback3.setDragger(viewDragHelperCreate3);
        Field declaredField = viewDragHelperCreate3.getClass().getDeclaredField("mEdgeSize");
        declaredField.setAccessible(true);
        int i2 = (int) ((60 * f) + 0.5f);
        declaredField.setInt(viewDragHelperCreate3, i2);
        ViewDragCallback viewDragCallback4 = new ViewDragCallback(80);
        this.mBottomDraggerCallback = viewDragCallback4;
        ViewDragHelper viewDragHelperCreate4 = ViewDragHelper.create(launcherDrawer, f2, viewDragCallback4);
        Intrinsics.checkNotNullExpressionValue(viewDragHelperCreate4, "create(...)");
        this.mBottomDragger = viewDragHelperCreate4;
        viewDragHelperCreate4.setEdgeTrackingEnabled(8);
        viewDragHelperCreate4.setMinVelocity(i * f);
        viewDragCallback4.setDragger(viewDragHelperCreate4);
        Field declaredField2 = viewDragHelperCreate4.getClass().getDeclaredField("mEdgeSize");
        declaredField2.setAccessible(true);
        declaredField2.setInt(viewDragHelperCreate4, i2);
    }

    public LauncherDrawer(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException {
        super(context, attributeSet);
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeTop = 3;
        this.mLockModeBottom = 3;
        this.mFirstLayout = true;
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        this.mScrimPaint = new Paint();
        float f = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((MIN_DRAWER_MARGIN * f) + 0.5f);
        ViewDragCallback viewDragCallback = new ViewDragCallback(8388611);
        this.mLeftDraggerCallback = viewDragCallback;
        LauncherDrawer launcherDrawer = this;
        float f2 = TOUCH_SLOP_SENSITIVITY;
        ViewDragHelper viewDragHelperCreate = ViewDragHelper.create(launcherDrawer, f2, viewDragCallback);
        Intrinsics.checkNotNullExpressionValue(viewDragHelperCreate, "create(...)");
        this.mLeftDragger = viewDragHelperCreate;
        viewDragHelperCreate.setEdgeTrackingEnabled(1);
        int i = MIN_FLING_VELOCITY;
        viewDragHelperCreate.setMinVelocity(i * f);
        viewDragCallback.setDragger(viewDragHelperCreate);
        ViewDragCallback viewDragCallback2 = new ViewDragCallback(8388613);
        this.mRightDraggerCallback = viewDragCallback2;
        ViewDragHelper viewDragHelperCreate2 = ViewDragHelper.create(launcherDrawer, f2, viewDragCallback2);
        Intrinsics.checkNotNullExpressionValue(viewDragHelperCreate2, "create(...)");
        this.mRightDragger = viewDragHelperCreate2;
        viewDragHelperCreate2.setEdgeTrackingEnabled(2);
        viewDragHelperCreate2.setMinVelocity(i * f);
        viewDragCallback2.setDragger(viewDragHelperCreate2);
        ViewDragCallback viewDragCallback3 = new ViewDragCallback(48);
        this.mTopDraggerCallback = viewDragCallback3;
        ViewDragHelper viewDragHelperCreate3 = ViewDragHelper.create(launcherDrawer, f2, viewDragCallback3);
        Intrinsics.checkNotNullExpressionValue(viewDragHelperCreate3, "create(...)");
        this.mTopDragger = viewDragHelperCreate3;
        viewDragHelperCreate3.setEdgeTrackingEnabled(4);
        viewDragHelperCreate3.setMinVelocity(i * f);
        viewDragCallback3.setDragger(viewDragHelperCreate3);
        Field declaredField = viewDragHelperCreate3.getClass().getDeclaredField("mEdgeSize");
        declaredField.setAccessible(true);
        int i2 = (int) ((60 * f) + 0.5f);
        declaredField.setInt(viewDragHelperCreate3, i2);
        ViewDragCallback viewDragCallback4 = new ViewDragCallback(80);
        this.mBottomDraggerCallback = viewDragCallback4;
        ViewDragHelper viewDragHelperCreate4 = ViewDragHelper.create(launcherDrawer, f2, viewDragCallback4);
        Intrinsics.checkNotNullExpressionValue(viewDragHelperCreate4, "create(...)");
        this.mBottomDragger = viewDragHelperCreate4;
        viewDragHelperCreate4.setEdgeTrackingEnabled(8);
        viewDragHelperCreate4.setMinVelocity(i * f);
        viewDragCallback4.setDragger(viewDragHelperCreate4);
        Field declaredField2 = viewDragHelperCreate4.getClass().getDeclaredField("mEdgeSize");
        declaredField2.setAccessible(true);
        declaredField2.setInt(viewDragHelperCreate4, i2);
    }

    public LauncherDrawer(Context context, AttributeSet attributeSet, int i) throws IllegalAccessException, NoSuchFieldException {
        super(context, attributeSet, i);
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeTop = 3;
        this.mLockModeBottom = 3;
        this.mFirstLayout = true;
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        this.mScrimPaint = new Paint();
        float f = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((MIN_DRAWER_MARGIN * f) + 0.5f);
        ViewDragCallback viewDragCallback = new ViewDragCallback(8388611);
        this.mLeftDraggerCallback = viewDragCallback;
        LauncherDrawer launcherDrawer = this;
        float f2 = TOUCH_SLOP_SENSITIVITY;
        ViewDragHelper viewDragHelperCreate = ViewDragHelper.create(launcherDrawer, f2, viewDragCallback);
        Intrinsics.checkNotNullExpressionValue(viewDragHelperCreate, "create(...)");
        this.mLeftDragger = viewDragHelperCreate;
        viewDragHelperCreate.setEdgeTrackingEnabled(1);
        int i2 = MIN_FLING_VELOCITY;
        viewDragHelperCreate.setMinVelocity(i2 * f);
        viewDragCallback.setDragger(viewDragHelperCreate);
        ViewDragCallback viewDragCallback2 = new ViewDragCallback(8388613);
        this.mRightDraggerCallback = viewDragCallback2;
        ViewDragHelper viewDragHelperCreate2 = ViewDragHelper.create(launcherDrawer, f2, viewDragCallback2);
        Intrinsics.checkNotNullExpressionValue(viewDragHelperCreate2, "create(...)");
        this.mRightDragger = viewDragHelperCreate2;
        viewDragHelperCreate2.setEdgeTrackingEnabled(2);
        viewDragHelperCreate2.setMinVelocity(i2 * f);
        viewDragCallback2.setDragger(viewDragHelperCreate2);
        ViewDragCallback viewDragCallback3 = new ViewDragCallback(48);
        this.mTopDraggerCallback = viewDragCallback3;
        ViewDragHelper viewDragHelperCreate3 = ViewDragHelper.create(launcherDrawer, f2, viewDragCallback3);
        Intrinsics.checkNotNullExpressionValue(viewDragHelperCreate3, "create(...)");
        this.mTopDragger = viewDragHelperCreate3;
        viewDragHelperCreate3.setEdgeTrackingEnabled(4);
        viewDragHelperCreate3.setMinVelocity(i2 * f);
        viewDragCallback3.setDragger(viewDragHelperCreate3);
        Field declaredField = viewDragHelperCreate3.getClass().getDeclaredField("mEdgeSize");
        declaredField.setAccessible(true);
        int i3 = (int) ((60 * f) + 0.5f);
        declaredField.setInt(viewDragHelperCreate3, i3);
        ViewDragCallback viewDragCallback4 = new ViewDragCallback(80);
        this.mBottomDraggerCallback = viewDragCallback4;
        ViewDragHelper viewDragHelperCreate4 = ViewDragHelper.create(launcherDrawer, f2, viewDragCallback4);
        Intrinsics.checkNotNullExpressionValue(viewDragHelperCreate4, "create(...)");
        this.mBottomDragger = viewDragHelperCreate4;
        viewDragHelperCreate4.setEdgeTrackingEnabled(8);
        viewDragHelperCreate4.setMinVelocity(i2 * f);
        viewDragCallback4.setDragger(viewDragHelperCreate4);
        Field declaredField2 = viewDragHelperCreate4.getClass().getDeclaredField("mEdgeSize");
        declaredField2.setAccessible(true);
        declaredField2.setInt(viewDragHelperCreate4, i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        findDrawers();
    }

    public final void setDrawerListener(DrawerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void disable() {
        this.mDisabled = true;
        closeDrawers();
    }

    public final void enable() {
        this.mDisabled = false;
        invalidate();
    }

    private final void findDrawers() {
        this.mStartDrawer = findViewById(R.id.drawer_start);
        this.mEndDrawer = findViewById(R.id.drawer_end);
        this.mTopDrawer = findViewById(R.id.drawer_top);
        this.mBottomDrawer = findViewById(R.id.drawer_bottom);
        this.mContentView = findViewById(R.id.drawer_content);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayoutEX must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.dw.launcher.ui.view.LauncherDrawer.LayoutParams");
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                Intrinsics.checkNotNull(childAt);
                if (isContentView(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - layoutParams2.leftMargin) - layoutParams2.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - layoutParams2.topMargin) - layoutParams2.bottomMargin, 1073741824));
                } else if (isStartDrawer(childAt)) {
                    childAt.measure(ViewGroup.getChildMeasureSpec(widthMeasureSpec, this.mMinDrawerMargin + layoutParams2.leftMargin + layoutParams2.rightMargin, layoutParams2.width), ViewGroup.getChildMeasureSpec(heightMeasureSpec, layoutParams2.topMargin + layoutParams2.bottomMargin, layoutParams2.height));
                } else if (isEndDrawer(childAt)) {
                    childAt.measure(ViewGroup.getChildMeasureSpec(widthMeasureSpec, this.mMinDrawerMargin + layoutParams2.leftMargin + layoutParams2.rightMargin, layoutParams2.width), ViewGroup.getChildMeasureSpec(heightMeasureSpec, layoutParams2.topMargin + layoutParams2.bottomMargin, layoutParams2.height));
                } else if (isTopDrawer(childAt)) {
                    childAt.measure(ViewGroup.getChildMeasureSpec(widthMeasureSpec, layoutParams2.leftMargin + layoutParams2.rightMargin, layoutParams2.width), ViewGroup.getChildMeasureSpec(heightMeasureSpec, layoutParams2.topMargin + layoutParams2.bottomMargin + this.mMinDrawerMargin, layoutParams2.height));
                } else if (isBottomDrawer(childAt)) {
                    childAt.measure(ViewGroup.getChildMeasureSpec(widthMeasureSpec, layoutParams2.leftMargin + layoutParams2.rightMargin, layoutParams2.width), ViewGroup.getChildMeasureSpec(heightMeasureSpec, layoutParams2.topMargin + layoutParams2.bottomMargin + this.mMinDrawerMargin, layoutParams2.height));
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        float f;
        int onScreen;
        int onScreen2;
        this.mInLayout = true;
        int i = r - l;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.dw.launcher.ui.view.LauncherDrawer.LayoutParams");
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                Intrinsics.checkNotNull(childAt);
                if (isContentView(childAt)) {
                    childAt.layout(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.leftMargin + childAt.getMeasuredWidth(), layoutParams2.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (isStartDrawer(childAt)) {
                        if (!isLayoutDirectionRTL()) {
                            float f2 = measuredWidth;
                            onScreen2 = (-measuredWidth) + ((int) (layoutParams2.getOnScreen() * f2));
                            f = (measuredWidth + onScreen2) / f2;
                            layoutParams2.setGravity(3);
                        } else {
                            float f3 = measuredWidth;
                            int onScreen3 = i - ((int) (layoutParams2.getOnScreen() * f3));
                            f = (i - onScreen3) / f3;
                            layoutParams2.setGravity(5);
                            onScreen2 = onScreen3;
                        }
                        childAt.layout(onScreen2, layoutParams2.topMargin, measuredWidth + onScreen2, layoutParams2.topMargin + measuredHeight);
                    } else if (isEndDrawer(childAt)) {
                        if (!isLayoutDirectionRTL()) {
                            float f4 = measuredWidth;
                            onScreen = i - ((int) (layoutParams2.getOnScreen() * f4));
                            f = (i - onScreen) / f4;
                            layoutParams2.setGravity(5);
                        } else {
                            float f5 = measuredWidth;
                            int onScreen4 = (-measuredWidth) + ((int) (layoutParams2.getOnScreen() * f5));
                            f = (measuredWidth + onScreen4) / f5;
                            layoutParams2.setGravity(3);
                            onScreen = onScreen4;
                        }
                        childAt.layout(onScreen, layoutParams2.topMargin, measuredWidth + onScreen, layoutParams2.topMargin + measuredHeight);
                    } else if (isTopDrawer(childAt)) {
                        float f6 = measuredHeight;
                        int onScreen5 = (-measuredHeight) + ((int) (layoutParams2.getOnScreen() * f6));
                        int i3 = measuredHeight + onScreen5;
                        f = i3 / f6;
                        layoutParams2.setGravity(48);
                        childAt.layout(layoutParams2.leftMargin, onScreen5, layoutParams2.leftMargin + measuredWidth, i3);
                    } else if (isBottomDrawer(childAt)) {
                        float f7 = measuredHeight;
                        int height = getHeight() - ((int) (layoutParams2.getOnScreen() * f7));
                        layoutParams2.setGravity(80);
                        f = (measuredHeight - height) / f7;
                        childAt.layout(layoutParams2.leftMargin, height, layoutParams2.leftMargin + measuredWidth, measuredHeight + height);
                    } else {
                        f = 0.0f;
                    }
                    if (!(f == layoutParams2.getOnScreen())) {
                        setDrawerViewOffset(childAt, f);
                    }
                    int i4 = layoutParams2.getOnScreen() > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i4) {
                        childAt.setVisibility(i4);
                    }
                }
            }
        }
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean zIsContentView;
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.mDisabled) {
            return false;
        }
        int actionMasked = ev.getActionMasked();
        boolean zShouldInterceptTouchEvent = this.mLeftDragger.shouldInterceptTouchEvent(ev) | this.mRightDragger.shouldInterceptTouchEvent(ev) | this.mTopDragger.shouldInterceptTouchEvent(ev) | this.mBottomDragger.shouldInterceptTouchEvent(ev);
        if (actionMasked == 0) {
            float x = ev.getX();
            float y = ev.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
            if (this.mScrimOpacity > 0.0f) {
                int i = (int) x;
                int i2 = (int) y;
                View viewFindTopChildUnder = this.mLeftDragger.findTopChildUnder(i, i2);
                zIsContentView = viewFindTopChildUnder != null ? isContentView(viewFindTopChildUnder) : false;
                View viewFindTopChildUnder2 = this.mRightDragger.findTopChildUnder(i, i2);
                if (viewFindTopChildUnder2 != null && isContentView(viewFindTopChildUnder2)) {
                    zIsContentView = true;
                }
                View viewFindTopChildUnder3 = this.mTopDragger.findTopChildUnder(i, i2);
                if (viewFindTopChildUnder3 != null && isContentView(viewFindTopChildUnder3)) {
                    zIsContentView = true;
                }
                View viewFindTopChildUnder4 = this.mBottomDragger.findTopChildUnder(i, i2);
                if (viewFindTopChildUnder4 != null && isContentView(viewFindTopChildUnder4)) {
                    zIsContentView = true;
                }
            } else {
                zIsContentView = false;
            }
            this.mChildrenCanceledTouch = false;
        } else {
            if (ArraysKt.contains(new Integer[]{1, 3}, Integer.valueOf(actionMasked))) {
                closeDrawers(true);
                this.mChildrenCanceledTouch = false;
            } else if (actionMasked == 2) {
                try {
                    if (this.mLeftDragger.checkTouchSlop(1)) {
                        this.mLeftDraggerCallback.removeCallbacks();
                    }
                    if (this.mRightDragger.checkTouchSlop(1)) {
                        this.mRightDraggerCallback.removeCallbacks();
                    }
                    if (this.mTopDragger.checkTouchSlop(2)) {
                        this.mTopDraggerCallback.removeCallbacks();
                    }
                    if (this.mBottomDragger.checkTouchSlop(2)) {
                        this.mBottomDraggerCallback.removeCallbacks();
                    }
                } catch (Exception unused) {
                }
            }
            zIsContentView = false;
        }
        return zShouldInterceptTouchEvent || zIsContentView || hasPeekingDrawer() || this.mChildrenCanceledTouch;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00df  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Unit unit;
        boolean z;
        View viewFindOpenDrawer;
        Intrinsics.checkNotNullParameter(event, "event");
        View view = this.mCapturedView;
        if (view != null) {
            if (isTopDrawer(view)) {
                this.mTopDragger.processTouchEvent(event);
            } else if (isBottomDrawer(view)) {
                this.mBottomDragger.processTouchEvent(event);
            } else if ((isStartDrawer(view) && !isLayoutDirectionRTL()) || (isEndDrawer(view) && isLayoutDirectionRTL())) {
                this.mLeftDragger.processTouchEvent(event);
            } else if ((isStartDrawer(view) && isLayoutDirectionRTL()) || (isEndDrawer(view) && !isLayoutDirectionRTL())) {
                this.mRightDragger.processTouchEvent(event);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.mLeftDragger.processTouchEvent(event);
            this.mRightDragger.processTouchEvent(event);
            this.mTopDragger.processTouchEvent(event);
            this.mBottomDragger.processTouchEvent(event);
        }
        int action = event.getAction() & 255;
        if (action == 0) {
            this.mInitialMotionX = event.getX();
            this.mInitialMotionY = event.getY();
            this.mChildrenCanceledTouch = false;
            Timber.INSTANCE.d("onTouchEvent0 ：mChildrenCanceledTouch： " + this.mChildrenCanceledTouch, new Object[0]);
        } else if (action == 1) {
            float x = event.getX();
            float y = event.getY();
            View viewFindTopChildUnder = this.mLeftDragger.findTopChildUnder((int) x, (int) y);
            if (viewFindTopChildUnder != null && isContentView(viewFindTopChildUnder)) {
                float f = x - this.mInitialMotionX;
                float f2 = y - this.mInitialMotionY;
                int touchSlop = this.mLeftDragger.getTouchSlop();
                z = (f * f) + (f2 * f2) >= ((float) (touchSlop * touchSlop)) || (viewFindOpenDrawer = findOpenDrawer()) == null || getDrawerLockMode(viewFindOpenDrawer) == 2;
            }
            closeDrawers(z);
        } else if (action == 3) {
            closeDrawers(true);
            this.mChildrenCanceledTouch = true;
            Timber.INSTANCE.d("onTouchEvent1 ：mChildrenCanceledTouch： " + this.mChildrenCanceledTouch, new Object[0]);
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        Log.i("lkang", "dispatchGenericMotionEvent");
        Intrinsics.checkNotNull(event);
        if ((event.getSource() & 2) == 0 || event.getAction() == 10 || this.mScrimOpacity <= 0.0f) {
            return super.dispatchGenericMotionEvent(event);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = event.getX();
        float y = event.getY();
        for (int i = childCount - 1; -1 < i; i--) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            if (!isInBoundsOfChild(x, y, childAt) || isContentView(childAt)) {
                Log.i("lkang", "dispatchGenericMotionEvent continue");
            } else if (dispatchTransformedGenericPointerEvent(event, childAt)) {
                Log.i("lkang", "dispatchGenericMotionEvent true");
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fCoerceAtLeast = 0.0f;
        for (int i = 0; i < childCount; i++) {
            ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.dw.launcher.ui.view.LauncherDrawer.LayoutParams");
            fCoerceAtLeast = RangesKt.coerceAtLeast(fCoerceAtLeast, ((LayoutParams) layoutParams).getOnScreen());
        }
        this.mScrimOpacity = fCoerceAtLeast;
        boolean zContinueSettling = this.mLeftDragger.continueSettling(true);
        boolean zContinueSettling2 = this.mRightDragger.continueSettling(true);
        if (((zContinueSettling | zContinueSettling2) | this.mTopDragger.continueSettling(true)) || this.mBottomDragger.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        return new LayoutParams(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        Intrinsics.checkNotNullParameter(p, "p");
        if (p instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) p);
        }
        if (p instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) p);
        }
        return new LayoutParams(p);
    }

    private final View findOpenDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            if (!isContentView(childAt)) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.dw.launcher.ui.view.LauncherDrawer.LayoutParams");
                if ((((LayoutParams) layoutParams).getOpenState() & 1) == 1) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public static /* synthetic */ void openStartDrawer$default(LauncherDrawer launcherDrawer, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        launcherDrawer.openStartDrawer(z);
    }

    public final void openStartDrawer(boolean animate) {
        View view = this.mStartDrawer;
        if (view != null) {
            openDrawer(view, animate);
        }
    }

    public static /* synthetic */ void openTopDrawer$default(LauncherDrawer launcherDrawer, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        launcherDrawer.openTopDrawer(z);
    }

    public final void openTopDrawer(boolean animate) {
        View view = this.mTopDrawer;
        if (view != null) {
            openDrawer(view, animate);
        }
    }

    static /* synthetic */ void openDrawer$default(LauncherDrawer launcherDrawer, View view, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        launcherDrawer.openDrawer(view, z);
    }

    private final void openDrawer(View drawerView, boolean animate) {
        if (!isDrawerView(drawerView)) {
            throw new IllegalArgumentException(("View " + drawerView + " is not a sliding drawer").toString());
        }
        ViewGroup.LayoutParams layoutParams = drawerView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.dw.launcher.ui.view.LauncherDrawer.LayoutParams");
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.mFirstLayout) {
            layoutParams2.setOnScreen(1.0f);
            layoutParams2.setOpenState(1);
        } else if (animate) {
            layoutParams2.setOpenState(layoutParams2.getOpenState() | 2);
            if (isStartDrawer(drawerView)) {
                if (isLayoutDirectionRTL()) {
                    this.mRightDragger.smoothSlideViewTo(drawerView, getWidth() - drawerView.getWidth(), drawerView.getTop());
                } else {
                    this.mLeftDragger.smoothSlideViewTo(drawerView, 0, drawerView.getTop());
                }
            } else if (isEndDrawer(drawerView)) {
                if (isLayoutDirectionRTL()) {
                    this.mLeftDragger.smoothSlideViewTo(drawerView, 0, drawerView.getTop());
                } else {
                    this.mRightDragger.smoothSlideViewTo(drawerView, getWidth() - drawerView.getWidth(), drawerView.getTop());
                }
            } else if (isTopDrawer(drawerView)) {
                this.mTopDragger.smoothSlideViewTo(drawerView, drawerView.getLeft(), drawerView.getHeight());
            } else {
                this.mBottomDragger.smoothSlideViewTo(drawerView, drawerView.getLeft(), getHeight() - drawerView.getHeight());
            }
        } else {
            moveDrawerToOffset(drawerView, 1.0f);
            updateDrawerState(0, drawerView);
            drawerView.setVisibility(0);
        }
        invalidate();
    }

    public final void closeDrawer(View drawerView) {
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
        closeDrawer(drawerView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeDrawer(View drawerView, boolean animate) {
        if (!isDrawerView(drawerView)) {
            throw new IllegalArgumentException(("View " + drawerView + " is not a sliding drawer").toString());
        }
        ViewGroup.LayoutParams layoutParams = drawerView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.dw.launcher.ui.view.LauncherDrawer.LayoutParams");
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.mFirstLayout) {
            layoutParams2.setOnScreen(0.0f);
            layoutParams2.setOpenState(0);
        } else if (animate) {
            layoutParams2.setOpenState(layoutParams2.getOpenState() | 4);
            if (isStartDrawer(drawerView)) {
                if (isLayoutDirectionRTL()) {
                    this.mRightDragger.smoothSlideViewTo(drawerView, getWidth(), drawerView.getTop());
                } else {
                    this.mLeftDragger.smoothSlideViewTo(drawerView, -drawerView.getWidth(), drawerView.getTop());
                }
            } else if (isEndDrawer(drawerView)) {
                if (isLayoutDirectionRTL()) {
                    this.mLeftDragger.smoothSlideViewTo(drawerView, -drawerView.getWidth(), drawerView.getTop());
                } else {
                    this.mRightDragger.smoothSlideViewTo(drawerView, getWidth(), drawerView.getTop());
                }
            } else if (isTopDrawer(drawerView)) {
                this.mTopDragger.smoothSlideViewTo(drawerView, drawerView.getLeft(), -drawerView.getHeight());
            } else if (isBottomDrawer(drawerView)) {
                this.mBottomDragger.smoothSlideViewTo(drawerView, drawerView.getLeft(), getHeight());
            }
        } else {
            moveDrawerToOffset(drawerView, 0.0f);
            updateDrawerState(0, drawerView);
            drawerView.setVisibility(4);
        }
        invalidate();
    }

    public final void closeDrawers() {
        closeDrawers(false);
    }

    public final void closeDrawers(boolean peekingOnly) {
        boolean zSmoothSlideViewTo;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.dw.launcher.ui.view.LauncherDrawer.LayoutParams");
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            Intrinsics.checkNotNull(childAt);
            if (isDrawerView(childAt) && (!peekingOnly || layoutParams2.getIsPeeking())) {
                int width = childAt.getWidth();
                if (isStartDrawer(childAt)) {
                    if (isLayoutDirectionRTL()) {
                        zSmoothSlideViewTo = this.mRightDragger.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                    } else {
                        zSmoothSlideViewTo = this.mLeftDragger.smoothSlideViewTo(childAt, -width, childAt.getTop());
                    }
                } else if (isEndDrawer(childAt)) {
                    if (isLayoutDirectionRTL()) {
                        zSmoothSlideViewTo = this.mLeftDragger.smoothSlideViewTo(childAt, -width, childAt.getTop());
                    } else {
                        zSmoothSlideViewTo = this.mRightDragger.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                    }
                } else if (isTopDrawer(childAt)) {
                    zSmoothSlideViewTo = this.mTopDragger.smoothSlideViewTo(childAt, childAt.getLeft(), -childAt.getHeight());
                } else {
                    if (isBottomDrawer(childAt)) {
                        zSmoothSlideViewTo = this.mBottomDragger.smoothSlideViewTo(childAt, childAt.getLeft(), getHeight());
                    }
                    layoutParams2.setPeeking(false);
                }
                z |= zSmoothSlideViewTo;
                layoutParams2.setPeeking(false);
            }
        }
        this.mLeftDraggerCallback.removeCallbacks();
        this.mRightDraggerCallback.removeCallbacks();
        this.mTopDraggerCallback.removeCallbacks();
        this.mBottomDraggerCallback.removeCallbacks();
        if (z) {
            invalidate();
        }
    }

    private final void moveDrawerToOffset(View drawerView, float slideOffset) {
        log("----moveDrawerToOffset, view: " + drawerView + ", offset: " + slideOffset);
        float drawerViewOffset = getDrawerViewOffset(drawerView);
        if (isStartDrawer(drawerView) || isEndDrawer(drawerView)) {
            float width = drawerView.getWidth();
            int i = ((int) (width * slideOffset)) - ((int) (drawerViewOffset * width));
            if ((isStartDrawer(drawerView) && !isLayoutDirectionRTL()) || (isEndDrawer(drawerView) && isLayoutDirectionRTL())) {
                drawerView.offsetLeftAndRight(i);
            } else {
                drawerView.offsetLeftAndRight(-i);
            }
        } else {
            float height = drawerView.getHeight();
            int i2 = ((int) (height * slideOffset)) - ((int) (drawerViewOffset * height));
            if (!isTopDrawer(drawerView)) {
                i2 = -i2;
            }
            drawerView.offsetTopAndBottom(i2);
        }
        setDrawerViewOffset(drawerView, slideOffset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDrawerState(int activeState, View activeDrawer) {
        int viewDragState;
        if (activeDrawer == null) {
            viewDragState = 0;
        } else if ((isStartDrawer(activeDrawer) && isLayoutDirectionRTL()) || (isEndDrawer(activeDrawer) && !isLayoutDirectionRTL())) {
            viewDragState = this.mRightDragger.getViewDragState();
        } else if ((isStartDrawer(activeDrawer) && !isLayoutDirectionRTL()) || (isEndDrawer(activeDrawer) && isLayoutDirectionRTL())) {
            viewDragState = this.mLeftDragger.getViewDragState();
        } else if (isTopDrawer(activeDrawer)) {
            viewDragState = this.mTopDragger.getViewDragState();
        } else {
            viewDragState = this.mBottomDragger.getViewDragState();
        }
        if (activeDrawer != null && activeState == 0) {
            ViewGroup.LayoutParams layoutParams = activeDrawer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.dw.launcher.ui.view.LauncherDrawer.LayoutParams");
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (layoutParams2.getOnScreen() == 0.0f) {
                if ((layoutParams2.getOpenState() & 1) == 1) {
                    layoutParams2.setOpenState(0);
                    DrawerListener drawerListener = this.listener;
                    if (drawerListener != null) {
                        drawerListener.onDrawerClosed(activeDrawer);
                    }
                }
            } else if (layoutParams2.getOnScreen() == 1.0f && (layoutParams2.getOpenState() & 1) == 0) {
                layoutParams2.setOpenState(1);
                DrawerListener drawerListener2 = this.listener;
                if (drawerListener2 != null) {
                    drawerListener2.onDrawerOpened(activeDrawer);
                }
            }
            log("----updateDrawerState, lp.onScreen: " + layoutParams2.getOnScreen() + ", lp.openState: " + layoutParams2.getOpenState());
        }
        log("----updateDrawerState, state: " + viewDragState + ", activeDrawer: " + activeDrawer);
        if (viewDragState != this.mDrawerState) {
            this.mDrawerState = viewDragState;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getDrawerViewOffset(View drawerView) {
        ViewGroup.LayoutParams layoutParams = drawerView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.dw.launcher.ui.view.LauncherDrawer.LayoutParams");
        return ((LayoutParams) layoutParams).getOnScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDrawerView(View child) {
        return isStartDrawer(child) || isEndDrawer(child) || isTopDrawer(child) || isBottomDrawer(child);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDrawerGravityMatched(View child, int gravity) {
        return (isStartDrawer(child) && gravity == 8388611) || (isEndDrawer(child) && gravity == 8388613) || ((isTopDrawer(child) && gravity == 48) || (isBottomDrawer(child) && gravity == 80));
    }

    private final boolean isContentView(View child) {
        return Intrinsics.areEqual(child, this.mContentView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isStartDrawer(View child) {
        return Intrinsics.areEqual(child, this.mStartDrawer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isEndDrawer(View child) {
        return Intrinsics.areEqual(child, this.mEndDrawer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isTopDrawer(View child) {
        return Intrinsics.areEqual(child, this.mTopDrawer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isBottomDrawer(View child) {
        return Intrinsics.areEqual(child, this.mBottomDrawer);
    }

    private final boolean hasPeekingDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.dw.launcher.ui.view.LauncherDrawer.LayoutParams");
            if (((LayoutParams) layoutParams).getIsPeeking()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDrawerViewOffset(View drawerView, float slideOffset) {
        ViewGroup.LayoutParams layoutParams = drawerView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.dw.launcher.ui.view.LauncherDrawer.LayoutParams");
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (slideOffset == layoutParams2.getOnScreen()) {
            return;
        }
        layoutParams2.setOnScreen(slideOffset);
    }

    public final int getDrawerLockMode(int edgeGravity) {
        int i;
        if (edgeGravity == 3) {
            int i2 = this.mLockModeLeft;
            if (i2 != 3) {
                return i2;
            }
            return 0;
        }
        if (edgeGravity == 5) {
            int i3 = this.mLockModeRight;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (edgeGravity != 48) {
            if (edgeGravity == 80 && (i = this.mLockModeBottom) != 3) {
                return i;
            }
            return 0;
        }
        int i4 = this.mLockModeTop;
        if (i4 != 3) {
            return i4;
        }
        return 0;
    }

    public final int getDrawerLockMode(View drawerView) {
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
        if (!isDrawerView(drawerView)) {
            throw new IllegalArgumentException(("View " + drawerView + " is not a drawer").toString());
        }
        ViewGroup.LayoutParams layoutParams = drawerView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.dw.launcher.ui.view.LauncherDrawer.LayoutParams");
        return getDrawerLockMode(((LayoutParams) layoutParams).getGravity());
    }

    private final boolean dispatchTransformedGenericPointerEvent(MotionEvent event, View child) {
        if (!child.getMatrix().isIdentity()) {
            MotionEvent transformedMotionEvent = getTransformedMotionEvent(event, child);
            boolean zDispatchGenericMotionEvent = child.dispatchGenericMotionEvent(transformedMotionEvent);
            transformedMotionEvent.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - child.getLeft();
        float scrollY = getScrollY() - child.getTop();
        event.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = child.dispatchGenericMotionEvent(event);
        event.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    private final MotionEvent getTransformedMotionEvent(MotionEvent event, View child) {
        float scrollX = getScrollX() - child.getLeft();
        float scrollY = getScrollY() - child.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(event);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = child.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.mChildInvertedMatrix == null) {
                this.mChildInvertedMatrix = new Matrix();
            }
            matrix.invert(this.mChildInvertedMatrix);
            motionEventObtain.transform(this.mChildInvertedMatrix);
        }
        Intrinsics.checkNotNull(motionEventObtain);
        return motionEventObtain;
    }

    private final boolean isInBoundsOfChild(float x, float y, View child) {
        if (this.mChildHitRect == null) {
            this.mChildHitRect = new Rect();
        }
        child.getHitRect(this.mChildHitRect);
        Rect rect = this.mChildHitRect;
        Intrinsics.checkNotNull(rect);
        return rect.contains((int) x, (int) y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: LauncherDrawer.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0003H\u0016J0\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J \u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J\u0006\u0010'\u001a\u00020\u0013J\u0006\u0010(\u001a\u00020\u0013J\u000e\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0006J\u0018\u0010+\u001a\u00020,2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/dw/launcher/ui/view/LauncherDrawer$ViewDragCallback;", "Landroidx/customview/widget/ViewDragHelper$Callback;", "gravity", "", "(Lcom/dw/launcher/ui/view/LauncherDrawer;I)V", "mDragger", "Landroidx/customview/widget/ViewDragHelper;", "mEdgeFlags", "mPeekRunnable", "Ljava/lang/Runnable;", "clampViewPositionHorizontal", "child", "Landroid/view/View;", "left", "dx", "clampViewPositionVertical", "top", "dy", "closeOtherDrawer", "", "capturedView", "getViewHorizontalDragRange", "getViewVerticalDragRange", "onEdgeDragStarted", "edgeFlags", "pointerId", "onEdgeTouched", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "onViewReleased", "releasedChild", "xvel", "", "yvel", "peekDrawer", "removeCallbacks", "setDragger", "dragger", "tryCaptureView", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    final class ViewDragCallback extends ViewDragHelper.Callback {
        private final int gravity;
        private ViewDragHelper mDragger;
        private int mEdgeFlags;
        private final Runnable mPeekRunnable = new Runnable() { // from class: com.dw.launcher.ui.view.LauncherDrawer$ViewDragCallback$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LauncherDrawer.ViewDragCallback.mPeekRunnable$lambda$0(this.f$0);
            }
        };

        public ViewDragCallback(int i) {
            this.gravity = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void mPeekRunnable$lambda$0(ViewDragCallback this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.peekDrawer();
        }

        public final void setDragger(ViewDragHelper dragger) {
            Intrinsics.checkNotNullParameter(dragger, "dragger");
            this.mDragger = dragger;
        }

        public boolean tryCaptureView(View child, int pointerId) {
            Intrinsics.checkNotNullParameter(child, "child");
            LauncherDrawer.this.log("----tryCaptureView, " + child);
            return LauncherDrawer.this.isDrawerGravityMatched(child, this.gravity);
        }

        public void onViewDragStateChanged(int state) {
            LauncherDrawer launcherDrawer = LauncherDrawer.this;
            ViewDragHelper viewDragHelper = this.mDragger;
            if (viewDragHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDragger");
                viewDragHelper = null;
            }
            launcherDrawer.updateDrawerState(state, viewDragHelper.getCapturedView());
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0026  */
        public void onViewPositionChanged(View changedView, int left, int top2, int dx, int dy) {
            float height;
            float f;
            int width;
            Intrinsics.checkNotNullParameter(changedView, "changedView");
            int width2 = changedView.getWidth();
            int height2 = changedView.getHeight();
            if (LauncherDrawer.this.isStartDrawer(changedView)) {
                if (LauncherDrawer.this.isLayoutDirectionRTL()) {
                    width = LauncherDrawer.this.getWidth();
                    height = width - left;
                } else {
                    height = left + width2;
                }
                f = width2;
            } else if (LauncherDrawer.this.isEndDrawer(changedView)) {
                if (LauncherDrawer.this.isLayoutDirectionRTL()) {
                    height = left + width2;
                } else {
                    width = LauncherDrawer.this.getWidth();
                    height = width - left;
                }
                f = width2;
            } else {
                height = LauncherDrawer.this.isTopDrawer(changedView) ? top2 + height2 : LauncherDrawer.this.getHeight() - top2;
                f = height2;
            }
            float f2 = height / f;
            LauncherDrawer.this.setDrawerViewOffset(changedView, f2);
            changedView.setVisibility(f2 == 0.0f ? 4 : 0);
            LauncherDrawer.this.invalidate();
        }

        public void onViewCaptured(View capturedChild, int activePointerId) {
            Intrinsics.checkNotNullParameter(capturedChild, "capturedChild");
            LauncherDrawer.this.log("----onViewCaptured, capturedChild: " + capturedChild);
            if (LauncherDrawer.this.mCapturedView == null) {
                LauncherDrawer.this.mCapturedView = capturedChild;
                ViewGroup.LayoutParams layoutParams = capturedChild.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.dw.launcher.ui.view.LauncherDrawer.LayoutParams");
                ((LayoutParams) layoutParams).setPeeking(false);
                closeOtherDrawer(capturedChild);
            }
        }

        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            Intrinsics.checkNotNullParameter(releasedChild, "releasedChild");
            ViewDragHelper viewDragHelper = null;
            if (Intrinsics.areEqual(releasedChild, LauncherDrawer.this.mCapturedView)) {
                LauncherDrawer.this.mCapturedView = null;
            }
            float drawerViewOffset = LauncherDrawer.this.getDrawerViewOffset(releasedChild);
            int width = releasedChild.getWidth();
            int height = releasedChild.getHeight();
            int width2 = LauncherDrawer.this.getWidth();
            int height2 = LauncherDrawer.this.getHeight();
            LauncherDrawer.this.log("----onViewReleased, releasedChild: " + releasedChild + ", xvel: " + xvel + ", yvel: " + yvel + ", offset: " + drawerViewOffset);
            int i = 0;
            if (LauncherDrawer.this.isStartDrawer(releasedChild)) {
                if (!LauncherDrawer.this.isLayoutDirectionRTL()) {
                    width2 = (xvel > 0.0f || (xvel == 0.0f && drawerViewOffset > 0.5f)) ? 0 : -width;
                } else if (xvel < 0.0f || (xvel == 0.0f && drawerViewOffset > 0.5f)) {
                    width2 -= width;
                }
                ViewDragHelper viewDragHelper2 = this.mDragger;
                if (viewDragHelper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDragger");
                } else {
                    viewDragHelper = viewDragHelper2;
                }
                viewDragHelper.settleCapturedViewAt(width2, releasedChild.getTop());
            } else if (LauncherDrawer.this.isEndDrawer(releasedChild)) {
                if (LauncherDrawer.this.isLayoutDirectionRTL()) {
                    width2 = (xvel > 0.0f || (xvel == 0.0f && drawerViewOffset > 0.5f)) ? 0 : -width;
                } else if (xvel < 0.0f || (xvel == 0.0f && drawerViewOffset > 0.5f)) {
                    width2 -= width;
                }
                ViewDragHelper viewDragHelper3 = this.mDragger;
                if (viewDragHelper3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDragger");
                } else {
                    viewDragHelper = viewDragHelper3;
                }
                viewDragHelper.settleCapturedViewAt(width2, releasedChild.getTop());
            } else if (!LauncherDrawer.this.isTopDrawer(releasedChild)) {
                if (LauncherDrawer.this.isBottomDrawer(releasedChild)) {
                    if (yvel < 0.0f || (yvel == 0.0f && drawerViewOffset > 0.5f)) {
                        height2 -= height;
                    }
                    ViewDragHelper viewDragHelper4 = this.mDragger;
                    if (viewDragHelper4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDragger");
                    } else {
                        viewDragHelper = viewDragHelper4;
                    }
                    viewDragHelper.settleCapturedViewAt(releasedChild.getLeft(), height2);
                }
            } else {
                if (yvel <= 0.0f && (yvel != 0.0f || drawerViewOffset <= 0.5f)) {
                    i = -height;
                }
                ViewDragHelper viewDragHelper5 = this.mDragger;
                if (viewDragHelper5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDragger");
                } else {
                    viewDragHelper = viewDragHelper5;
                }
                viewDragHelper.settleCapturedViewAt(releasedChild.getLeft(), i);
            }
            LauncherDrawer.this.invalidate();
        }

        public void onEdgeTouched(int edgeFlags, int pointerId) {
            LauncherDrawer.this.log("---onEdgeTouched: " + edgeFlags + ", mCapturedView: " + LauncherDrawer.this.mCapturedView);
            if (LauncherDrawer.this.mCapturedView == null) {
                this.mEdgeFlags = edgeFlags;
                LauncherDrawer.this.postDelayed(this.mPeekRunnable, LauncherDrawer.PEEK_DELAY);
            }
        }

        private final void closeOtherDrawer(View capturedView) {
            int childCount = LauncherDrawer.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = LauncherDrawer.this.getChildAt(i);
                LauncherDrawer launcherDrawer = LauncherDrawer.this;
                Intrinsics.checkNotNull(childAt);
                if (launcherDrawer.isDrawerView(childAt) && !Intrinsics.areEqual(childAt, capturedView)) {
                    LauncherDrawer.this.closeDrawer(childAt, false);
                }
            }
        }

        public final void removeCallbacks() {
            this.mEdgeFlags = 0;
            LauncherDrawer.this.removeCallbacks(this.mPeekRunnable);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0053 A[PHI: r0
          0x0053: PHI (r0v25 android.view.View) = (r0v24 android.view.View), (r0v27 android.view.View) binds: [B:22:0x005b, B:18:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:38:0x00ac A[PHI: r0
          0x00ac: PHI (r0v8 android.view.View) = (r0v7 android.view.View), (r0v21 android.view.View) binds: [B:35:0x00a4, B:28:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
        public final void peekDrawer() {
            View mStartDrawer;
            int width;
            View mStartDrawer2;
            int width2;
            int i;
            int height;
            LauncherDrawer.this.log("----peekDrawer");
            if (LauncherDrawer.this.mCapturedView != null) {
                LauncherDrawer launcherDrawer = LauncherDrawer.this;
                View view = launcherDrawer.mCapturedView;
                Intrinsics.checkNotNull(view);
                if (launcherDrawer.isDrawerView(view)) {
                    LauncherDrawer.this.log("----skip peekDrawer");
                    return;
                }
            }
            ViewDragHelper viewDragHelper = this.mDragger;
            ViewDragHelper viewDragHelper2 = null;
            if (viewDragHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDragger");
                viewDragHelper = null;
            }
            int edgeSize = viewDragHelper.getEdgeSize();
            int i2 = this.mEdgeFlags & 15;
            int i3 = 0;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 4) {
                        mStartDrawer = LauncherDrawer.this.getMTopDrawer();
                        if (mStartDrawer != null) {
                            height = -mStartDrawer.getHeight();
                        } else {
                            height = 0;
                        }
                    } else {
                        mStartDrawer = LauncherDrawer.this.getMBottomDrawer();
                        if (mStartDrawer != null) {
                            height = LauncherDrawer.this.getHeight();
                        } else {
                            height = 0;
                        }
                    }
                } else if (!LauncherDrawer.this.isLayoutDirectionRTL()) {
                    mStartDrawer = LauncherDrawer.this.mEndDrawer;
                    if (mStartDrawer != null) {
                        width = mStartDrawer.getWidth();
                        i = -width;
                    } else {
                        i = 0;
                    }
                    i3 = i;
                    height = 0;
                } else {
                    mStartDrawer2 = LauncherDrawer.this.getMStartDrawer();
                    width2 = LauncherDrawer.this.getWidth();
                    int i4 = width2 - edgeSize;
                    mStartDrawer = mStartDrawer2;
                    height = 0;
                    i3 = i4;
                }
            } else if (LauncherDrawer.this.isLayoutDirectionRTL()) {
                mStartDrawer2 = LauncherDrawer.this.mEndDrawer;
                width2 = LauncherDrawer.this.getWidth();
                int i5 = width2 - edgeSize;
                mStartDrawer = mStartDrawer2;
                height = 0;
                i3 = i5;
            } else {
                mStartDrawer = LauncherDrawer.this.getMStartDrawer();
                if (mStartDrawer != null) {
                    width = mStartDrawer.getWidth();
                    i = -width;
                } else {
                    i = 0;
                }
                i3 = i;
                height = 0;
            }
            if (mStartDrawer == null || LauncherDrawer.this.getDrawerLockMode(mStartDrawer) != 0) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = mStartDrawer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.dw.launcher.ui.view.LauncherDrawer.LayoutParams");
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            LauncherDrawer.this.log("----toCapture: " + mStartDrawer + ", lockMode: " + LauncherDrawer.this.getDrawerLockMode(mStartDrawer) + ", openState: " + layoutParams2.getOpenState());
            if (layoutParams2.getOpenState() == 1) {
                LauncherDrawer.this.log("----opened, skip peek from edge");
                return;
            }
            if (LauncherDrawer.this.isStartDrawer(mStartDrawer) || LauncherDrawer.this.isEndDrawer(mStartDrawer)) {
                if (LauncherDrawer.this.isStartDrawer(mStartDrawer)) {
                    if (!LauncherDrawer.this.isLayoutDirectionRTL() || mStartDrawer.getLeft() <= i3) {
                        if (LauncherDrawer.this.isLayoutDirectionRTL() || mStartDrawer.getLeft() >= i3) {
                            return;
                        }
                        ViewDragHelper viewDragHelper3 = this.mDragger;
                        if (viewDragHelper3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mDragger");
                        } else {
                            viewDragHelper2 = viewDragHelper3;
                        }
                        viewDragHelper2.smoothSlideViewTo(mStartDrawer, i3, mStartDrawer.getTop());
                        layoutParams2.setPeeking(true);
                        LauncherDrawer.this.invalidate();
                        closeOtherDrawer(mStartDrawer);
                        LauncherDrawer.this.cancelChildViewTouch();
                        return;
                    }
                    ViewDragHelper viewDragHelper4 = this.mDragger;
                    if (viewDragHelper4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDragger");
                    } else {
                        viewDragHelper2 = viewDragHelper4;
                    }
                    viewDragHelper2.smoothSlideViewTo(mStartDrawer, i3, mStartDrawer.getTop());
                    layoutParams2.setPeeking(true);
                    LauncherDrawer.this.invalidate();
                    closeOtherDrawer(mStartDrawer);
                    LauncherDrawer.this.cancelChildViewTouch();
                    return;
                }
                if (!LauncherDrawer.this.isLayoutDirectionRTL() || mStartDrawer.getLeft() <= i3) {
                    if (LauncherDrawer.this.isLayoutDirectionRTL() || mStartDrawer.getLeft() >= i3) {
                        return;
                    }
                    ViewDragHelper viewDragHelper5 = this.mDragger;
                    if (viewDragHelper5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDragger");
                    } else {
                        viewDragHelper2 = viewDragHelper5;
                    }
                    viewDragHelper2.smoothSlideViewTo(mStartDrawer, i3, mStartDrawer.getTop());
                    layoutParams2.setPeeking(true);
                    LauncherDrawer.this.invalidate();
                    closeOtherDrawer(mStartDrawer);
                    LauncherDrawer.this.cancelChildViewTouch();
                    return;
                }
                ViewDragHelper viewDragHelper6 = this.mDragger;
                if (viewDragHelper6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDragger");
                } else {
                    viewDragHelper2 = viewDragHelper6;
                }
                viewDragHelper2.smoothSlideViewTo(mStartDrawer, i3, mStartDrawer.getTop());
                layoutParams2.setPeeking(true);
                LauncherDrawer.this.invalidate();
                closeOtherDrawer(mStartDrawer);
                LauncherDrawer.this.cancelChildViewTouch();
                return;
            }
            if (LauncherDrawer.this.isTopDrawer(mStartDrawer)) {
                if (mStartDrawer.getTop() < height) {
                    ViewDragHelper viewDragHelper7 = this.mDragger;
                    if (viewDragHelper7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDragger");
                    } else {
                        viewDragHelper2 = viewDragHelper7;
                    }
                    viewDragHelper2.smoothSlideViewTo(mStartDrawer, mStartDrawer.getLeft(), height);
                    layoutParams2.setPeeking(true);
                    LauncherDrawer.this.invalidate();
                    closeOtherDrawer(mStartDrawer);
                    LauncherDrawer.this.cancelChildViewTouch();
                    return;
                }
                return;
            }
            if (mStartDrawer.getTop() > height) {
                ViewDragHelper viewDragHelper8 = this.mDragger;
                if (viewDragHelper8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDragger");
                } else {
                    viewDragHelper2 = viewDragHelper8;
                }
                viewDragHelper2.smoothSlideViewTo(mStartDrawer, mStartDrawer.getLeft(), height);
                layoutParams2.setPeeking(true);
                LauncherDrawer.this.invalidate();
                closeOtherDrawer(mStartDrawer);
                LauncherDrawer.this.cancelChildViewTouch();
            }
        }

        public void onEdgeDragStarted(int edgeFlags, int pointerId) {
            View mBottomDrawer;
            LauncherDrawer.this.log("----onEdgeDragStarted, edgeFlags: " + edgeFlags + ", " + this.mEdgeFlags);
            ViewDragHelper viewDragHelper = null;
            if ((edgeFlags & 1) == 1) {
                mBottomDrawer = LauncherDrawer.this.isLayoutDirectionRTL() ? LauncherDrawer.this.mEndDrawer : LauncherDrawer.this.getMStartDrawer();
            } else if ((edgeFlags & 2) == 2) {
                if (!LauncherDrawer.this.isLayoutDirectionRTL()) {
                    mBottomDrawer = LauncherDrawer.this.mEndDrawer;
                } else {
                    mBottomDrawer = LauncherDrawer.this.getMStartDrawer();
                }
            } else if ((edgeFlags & 4) == 4) {
                mBottomDrawer = LauncherDrawer.this.getMTopDrawer();
            } else {
                mBottomDrawer = (edgeFlags & 8) == 8 ? LauncherDrawer.this.getMBottomDrawer() : null;
            }
            if (mBottomDrawer == null || LauncherDrawer.this.getDrawerLockMode(mBottomDrawer) != 0) {
                return;
            }
            ViewDragHelper viewDragHelper2 = this.mDragger;
            if (viewDragHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDragger");
            } else {
                viewDragHelper = viewDragHelper2;
            }
            viewDragHelper.captureChildView(mBottomDrawer, pointerId);
        }

        public int getViewHorizontalDragRange(View child) {
            Intrinsics.checkNotNullParameter(child, "child");
            if (LauncherDrawer.this.isStartDrawer(child) || LauncherDrawer.this.isEndDrawer(child)) {
                return child.getWidth();
            }
            return 0;
        }

        public int clampViewPositionHorizontal(View child, int left, int dx) {
            Intrinsics.checkNotNullParameter(child, "child");
            if (LauncherDrawer.this.isStartDrawer(child) || LauncherDrawer.this.isEndDrawer(child)) {
                if ((LauncherDrawer.this.isStartDrawer(child) && !LauncherDrawer.this.isLayoutDirectionRTL()) || (LauncherDrawer.this.isEndDrawer(child) && LauncherDrawer.this.isLayoutDirectionRTL())) {
                    return RangesKt.coerceAtLeast(-child.getWidth(), RangesKt.coerceAtMost(left, 0));
                }
                int width = LauncherDrawer.this.getWidth();
                return RangesKt.coerceAtLeast(width - child.getWidth(), RangesKt.coerceAtMost(left, width));
            }
            return child.getLeft();
        }

        public int getViewVerticalDragRange(View child) {
            Intrinsics.checkNotNullParameter(child, "child");
            if (LauncherDrawer.this.isTopDrawer(child) || LauncherDrawer.this.isBottomDrawer(child)) {
                return child.getHeight();
            }
            return 0;
        }

        public int clampViewPositionVertical(View child, int top2, int dy) {
            Intrinsics.checkNotNullParameter(child, "child");
            if (LauncherDrawer.this.isTopDrawer(child) || LauncherDrawer.this.isBottomDrawer(child)) {
                if (LauncherDrawer.this.isTopDrawer(child)) {
                    return RangesKt.coerceAtLeast(-child.getHeight(), RangesKt.coerceAtMost(top2, 0));
                }
                return RangesKt.coerceAtLeast(LauncherDrawer.this.getHeight() - child.getHeight(), RangesKt.coerceAtMost(top2, LauncherDrawer.this.getHeight()));
            }
            return child.getTop();
        }
    }

    public final void cancelChildViewTouch() {
        Timber.INSTANCE.d("cancelChildViewTouch ：mChildrenCanceledTouch： " + this.mChildrenCanceledTouch, new Object[0]);
        if (this.mChildrenCanceledTouch) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.mChildrenCanceledTouch = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isLayoutDirectionRTL() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    /* JADX INFO: compiled from: LauncherDrawer.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0001$B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nB\u0011\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\fB\u0011\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB\u001f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0002\u0010\u0010B\u000f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0000¢\u0006\u0002\u0010\u0011R\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015¨\u0006%"}, d2 = {"Lcom/dw/launcher/ui/view/LauncherDrawer$LayoutParams;", "Landroid/view/ViewGroup$MarginLayoutParams;", "c", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "width", "", "height", "(II)V", "source", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "gravity", "(III)V", "(Lcom/dw/launcher/ui/view/LauncherDrawer$LayoutParams;)V", "getGravity", "()I", "setGravity", "(I)V", "isPeeking", "", "()Z", "setPeeking", "(Z)V", "onScreen", "", "getOnScreen", "()F", "setOnScreen", "(F)V", "openState", "getOpenState", "setOpenState", "Companion", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int FLAG_IS_CLOSING = 4;
        public static final int FLAG_IS_OPENED = 1;
        public static final int FLAG_IS_OPENING = 2;
        private int gravity;
        private boolean isPeeking;
        private float onScreen;
        private int openState;

        public final int getGravity() {
            return this.gravity;
        }

        public final void setGravity(int i) {
            this.gravity = i;
        }

        public final float getOnScreen() {
            return this.onScreen;
        }

        public final void setOnScreen(float f) {
            this.onScreen = f;
        }

        /* JADX INFO: renamed from: isPeeking, reason: from getter */
        public final boolean getIsPeeking() {
            return this.isPeeking;
        }

        public final void setPeeking(boolean z) {
            this.isPeeking = z;
        }

        public final int getOpenState() {
            return this.openState;
        }

        public final void setOpenState(int i) {
            this.openState = i;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i, int i2, int i3) {
            this(i, i2);
            this.gravity = i3;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(LayoutParams source) {
            super((ViewGroup.MarginLayoutParams) source);
            Intrinsics.checkNotNullParameter(source, "source");
            this.gravity = this.gravity;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void log(String message) {
        Log.i(TAG, message);
    }

    public final boolean childVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            if (isDrawerView(childAt) && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean childVisibleWithNoRight() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            if (isDrawerView(childAt) && !Intrinsics.areEqual(childAt, this.mEndDrawer) && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public final void enableBottomDrawer(boolean enable) {
        boolean z = !enable;
        this.mBottomDrawerDisabled = z;
        this.mLockModeBottom = z ? 1 : 3;
        Timber.INSTANCE.e("----禁止上划: " + this.mBottomDrawerDisabled + "  mTopDrawerDisabled: " + this.mTopDrawerDisabled, new Object[0]);
    }

    public final void enableTopDrawer(boolean enable) {
        boolean z = !enable;
        this.mTopDrawerDisabled = z;
        this.mLockModeTop = z ? 1 : 3;
    }

    public final void enableLeftDrawer(boolean enable) {
        boolean z = !enable;
        this.mLeftDrawerDisabled = z;
        this.mLockModeLeft = z ? 1 : 3;
    }

    public final void disableWithKeepDrawer() {
        this.mDisabled = true;
    }

    public final void enableWithKeepDrawer() {
        this.mDisabled = false;
    }

    public final void closeOthersWithoutCurrent(View view) {
        boolean zSmoothSlideViewTo;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.dw.launcher.ui.view.LauncherDrawer.LayoutParams");
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!Intrinsics.areEqual(childAt, view)) {
                Intrinsics.checkNotNull(childAt);
                if (isDrawerView(childAt) && !layoutParams2.getIsPeeking()) {
                    int width = childAt.getWidth();
                    if (isStartDrawer(childAt)) {
                        if (isLayoutDirectionRTL()) {
                            zSmoothSlideViewTo = this.mRightDragger.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                        } else {
                            zSmoothSlideViewTo = this.mLeftDragger.smoothSlideViewTo(childAt, -width, childAt.getTop());
                        }
                    } else if (isEndDrawer(childAt)) {
                        if (isLayoutDirectionRTL()) {
                            zSmoothSlideViewTo = this.mLeftDragger.smoothSlideViewTo(childAt, -width, childAt.getTop());
                        } else {
                            zSmoothSlideViewTo = this.mRightDragger.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                        }
                    } else if (isTopDrawer(childAt)) {
                        zSmoothSlideViewTo = this.mTopDragger.smoothSlideViewTo(childAt, childAt.getLeft(), -childAt.getHeight());
                    } else {
                        if (isBottomDrawer(childAt)) {
                            zSmoothSlideViewTo = this.mBottomDragger.smoothSlideViewTo(childAt, childAt.getLeft(), getHeight());
                        }
                        layoutParams2.setPeeking(false);
                    }
                    z |= zSmoothSlideViewTo;
                    layoutParams2.setPeeking(false);
                }
            }
        }
        this.mLeftDraggerCallback.removeCallbacks();
        this.mRightDraggerCallback.removeCallbacks();
        this.mTopDraggerCallback.removeCallbacks();
        this.mBottomDraggerCallback.removeCallbacks();
        if (z) {
            invalidate();
        }
    }

    public final boolean isStartDrawerShow() {
        ViewGroup.LayoutParams layoutParams;
        View view = this.mStartDrawer;
        return view != null && (layoutParams = view.getLayoutParams()) != null && (layoutParams instanceof LayoutParams) && ((LayoutParams) layoutParams).getOnScreen() == 1.0f;
    }

    public final void restoreDrawerState(boolean useSelfStatusBar) {
        this.mLockModeRight = 3;
        this.mLockModeLeft = 3;
        if (useSelfStatusBar) {
            this.mLockModeTop = 3;
            this.mLockModeBottom = 3;
        } else {
            this.mLockModeTop = 1;
            this.mLockModeBottom = 1;
        }
    }

    public final void hasOpenDrawer(View view) {
        if (Intrinsics.areEqual(view, this.mBottomDrawer)) {
            lockOtherDrawers(80);
            return;
        }
        if (Intrinsics.areEqual(view, this.mTopDrawer)) {
            lockOtherDrawers(48);
        } else if (Intrinsics.areEqual(view, this.mStartDrawer)) {
            lockOtherDrawers(8388611);
        } else if (Intrinsics.areEqual(view, this.mRightDragger)) {
            lockOtherDrawers(8388613);
        }
    }

    private final void lockOtherDrawers(int openGravity) {
        if (openGravity == 48) {
            this.mLockModeLeft = 1;
            this.mLockModeRight = 1;
            this.mLockModeBottom = 1;
            return;
        }
        if (openGravity == 80) {
            this.mLockModeLeft = 1;
            this.mLockModeRight = 1;
            this.mLockModeTop = 1;
        } else if (openGravity == 8388611) {
            this.mLockModeRight = 1;
            this.mLockModeTop = 1;
            this.mLockModeBottom = 1;
        } else {
            if (openGravity != 8388613) {
                return;
            }
            this.mLockModeLeft = 1;
            this.mLockModeTop = 1;
            this.mLockModeBottom = 1;
        }
    }

    public final void resetDraggers() {
        this.mLeftDragger.cancel();
        this.mRightDragger.cancel();
        this.mTopDragger.cancel();
        this.mBottomDragger.cancel();
        this.mCapturedView = null;
        this.mFirstLayout = true;
        requestLayout();
        invalidate();
    }
}
