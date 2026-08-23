package com.dw.launcher.ui.clock.flatter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieResult;
import com.dw.launcher.data.entity.ClockConfig;
import com.dw.launcher.data.entity.CompassConfig;
import com.dw.launcher.util.ResourceUtils;
import com.dw.launcher.util.SystemUtils;
import com.google.android.mms.pdu.CharacterSets;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import pl.droidsonroids.gif.GifDrawable;
import timber.log.Timber;

/* JADX INFO: compiled from: ClockConfigFlatter.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b[\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u009f\u0002\u001a\u00030\u009b\u0001J\b\u0010 \u0002\u001a\u00030\u009b\u0001J&\u0010¡\u0002\u001a\u00030¢\u00022\b\u0010£\u0002\u001a\u00030¢\u00022\u0010\u0010¤\u0002\u001a\u000b\u0012\u0005\u0012\u00030¢\u0002\u0018\u00010&H\u0002J&\u0010¥\u0002\u001a\u00030¢\u00022\b\u0010£\u0002\u001a\u00030¢\u00022\u0010\u0010¤\u0002\u001a\u000b\u0012\u0005\u0012\u00030¢\u0002\u0018\u00010&H\u0002J\b\u0010¦\u0002\u001a\u00030\u009b\u0001J\b\u0010§\u0002\u001a\u00030\u009b\u0001J\b\u0010¨\u0002\u001a\u00030©\u0002J\u0016\u0010ª\u0002\u001a\u0005\u0018\u00010«\u00022\n\u0010£\u0002\u001a\u0005\u0018\u00010¢\u0002J!\u0010¬\u0002\u001a\u0004\u0018\u00010\b2\n\u0010£\u0002\u001a\u0005\u0018\u00010¢\u00022\n\b\u0002\u0010\u00ad\u0002\u001a\u00030µ\u0001J\u0015\u0010®\u0002\u001a\u0004\u0018\u00010\b2\n\u0010£\u0002\u001a\u0005\u0018\u00010¢\u0002J\t\u0010¯\u0002\u001a\u0004\u0018\u00010\bJ$\u0010°\u0002\u001a\u0005\u0018\u00010º\u00012\n\u0010£\u0002\u001a\u0005\u0018\u00010¢\u00022\n\b\u0002\u0010\u00ad\u0002\u001a\u00030µ\u0001H\u0002J\b\u0010±\u0002\u001a\u00030©\u0002J%\u0010²\u0002\u001a\u00030©\u00022\u0007\u0010³\u0002\u001a\u00020\u000e2\b\u0010´\u0002\u001a\u00030Æ\u00012\b\u0010µ\u0002\u001a\u00030Æ\u0001J%\u0010¶\u0002\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&2\n\u0010£\u0002\u001a\u0005\u0018\u00010¢\u00022\b\u0010·\u0002\u001a\u00030Æ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001a\u0010\"\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R\u001c\u0010.\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\n\"\u0004\b0\u0010\fR \u00101\u001a\b\u0012\u0004\u0012\u00020\b02X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010(\"\u0004\b4\u0010*R\"\u00105\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010(\"\u0004\b7\u0010*R\"\u00108\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010(\"\u0004\b:\u0010*R\u001c\u0010;\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\n\"\u0004\b=\u0010\fR\"\u0010>\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010(\"\u0004\b@\u0010*R\u001a\u0010A\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0010\"\u0004\bC\u0010\u0012R\u001a\u0010D\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0010\"\u0004\bF\u0010\u0012R\u001c\u0010G\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\n\"\u0004\bI\u0010\fR\u001c\u0010J\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\n\"\u0004\bL\u0010\fR\"\u0010M\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010(\"\u0004\bO\u0010*R\u001a\u0010P\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0010\"\u0004\bR\u0010\u0012R\u001a\u0010S\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0010\"\u0004\bU\u0010\u0012R\u001c\u0010V\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\n\"\u0004\bX\u0010\fR\u001c\u0010Y\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\n\"\u0004\b[\u0010\fR\"\u0010\\\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010(\"\u0004\b^\u0010*R\u001a\u0010_\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0010\"\u0004\ba\u0010\u0012R\u001a\u0010b\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0010\"\u0004\bd\u0010\u0012R\u001c\u0010e\u001a\u0004\u0018\u00010fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001c\u0010k\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\n\"\u0004\bm\u0010\fR\u001c\u0010n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\n\"\u0004\bp\u0010\fR\u001a\u0010q\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u0010\"\u0004\bs\u0010\u0012R\"\u0010t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010(\"\u0004\bv\u0010*R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u001a\u0010y\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u0010\"\u0004\b{\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010|\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\u0010\"\u0004\b~\u0010\u0012R$\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010(\"\u0005\b\u0081\u0001\u0010*R\u001d\u0010\u0082\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0010\"\u0005\b\u0084\u0001\u0010\u0012R\u001f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\n\"\u0005\b\u0087\u0001\u0010\fR%\u0010\u0088\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010(\"\u0005\b\u008a\u0001\u0010*R%\u0010\u008b\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010(\"\u0005\b\u008d\u0001\u0010*R\u001d\u0010\u008e\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010\u0010\"\u0005\b\u0090\u0001\u0010\u0012R\u001f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\n\"\u0005\b\u0093\u0001\u0010\fR\u001d\u0010\u0094\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u0010\"\u0005\b\u0096\u0001\u0010\u0012R\u001f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\n\"\u0005\b\u0099\u0001\u0010\fR\u0010\u0010\u009a\u0001\u001a\u00030\u009b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010\u009c\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010(\"\u0005\b\u009e\u0001\u0010*R\u001d\u0010\u009f\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010\u0010\"\u0005\b¡\u0001\u0010\u0012R%\u0010¢\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010(\"\u0005\b¤\u0001\u0010*R\u001d\u0010¥\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010\u0010\"\u0005\b§\u0001\u0010\u0012R%\u0010¨\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010(\"\u0005\bª\u0001\u0010*R\u001d\u0010«\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010\u0010\"\u0005\b\u00ad\u0001\u0010\u0012R\u001f\u0010®\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010\n\"\u0005\b°\u0001\u0010\fR\u001f\u0010±\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u0010\n\"\u0005\b³\u0001\u0010\fR \u0010´\u0001\u001a\u00030µ\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R\"\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001R%\u0010¿\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÀ\u0001\u0010(\"\u0005\bÁ\u0001\u0010*R\u001d\u0010Â\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010\u0010\"\u0005\bÄ\u0001\u0010\u0012R \u0010Å\u0001\u001a\u00030Æ\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001R \u0010Ë\u0001\u001a\u00030Æ\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÌ\u0001\u0010È\u0001\"\u0006\bÍ\u0001\u0010Ê\u0001R\u001f\u0010Î\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÏ\u0001\u0010\n\"\u0005\bÐ\u0001\u0010\fR\u001d\u0010Ñ\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÒ\u0001\u0010\u0010\"\u0005\bÓ\u0001\u0010\u0012R\u001f\u0010Ô\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÕ\u0001\u0010\n\"\u0005\bÖ\u0001\u0010\fR\u001d\u0010×\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bØ\u0001\u0010\u0010\"\u0005\bÙ\u0001\u0010\u0012R\u001f\u0010Ú\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÛ\u0001\u0010\n\"\u0005\bÜ\u0001\u0010\fR\u001d\u0010Ý\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÞ\u0001\u0010\u0010\"\u0005\bß\u0001\u0010\u0012R\u001f\u0010à\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bá\u0001\u0010\n\"\u0005\bâ\u0001\u0010\fR\u001d\u0010ã\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bä\u0001\u0010\u0010\"\u0005\bå\u0001\u0010\u0012R\u001f\u0010æ\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bç\u0001\u0010\n\"\u0005\bè\u0001\u0010\fR\u001d\u0010é\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bê\u0001\u0010\u0010\"\u0005\bë\u0001\u0010\u0012R\u001f\u0010ì\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bí\u0001\u0010\n\"\u0005\bî\u0001\u0010\fR\u001d\u0010ï\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bð\u0001\u0010\u0010\"\u0005\bñ\u0001\u0010\u0012R\u001f\u0010ò\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bó\u0001\u0010\n\"\u0005\bô\u0001\u0010\fR%\u0010õ\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bö\u0001\u0010(\"\u0005\b÷\u0001\u0010*R\u001d\u0010ø\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bù\u0001\u0010\u0010\"\u0005\bú\u0001\u0010\u0012R\u001f\u0010û\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bü\u0001\u0010\n\"\u0005\bý\u0001\u0010\fR\u001d\u0010þ\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÿ\u0001\u0010\u0010\"\u0005\b\u0080\u0002\u0010\u0012R\u001f\u0010\u0081\u0002\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0002\u0010\n\"\u0005\b\u0083\u0002\u0010\fR\u001f\u0010\u0084\u0002\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0002\u0010\n\"\u0005\b\u0086\u0002\u0010\fR\u001f\u0010\u0087\u0002\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0002\u0010\n\"\u0005\b\u0089\u0002\u0010\fR%\u0010\u008a\u0002\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0002\u0010(\"\u0005\b\u008c\u0002\u0010*R\u001d\u0010\u008d\u0002\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0002\u0010\u0010\"\u0005\b\u008f\u0002\u0010\u0012R\u001d\u0010\u0090\u0002\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0002\u0010\u0010\"\u0005\b\u0092\u0002\u0010\u0012R\u001f\u0010\u0093\u0002\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0002\u0010\n\"\u0005\b\u0095\u0002\u0010\fR\u001d\u0010\u0096\u0002\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0002\u0010\u0010\"\u0005\b\u0098\u0002\u0010\u0012R%\u0010\u0099\u0002\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0002\u0010(\"\u0005\b\u009b\u0002\u0010*R\u001d\u0010\u009c\u0002\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0002\u0010\u0010\"\u0005\b\u009e\u0002\u0010\u0012¨\u0006¸\u0002"}, d2 = {"Lcom/dw/launcher/ui/clock/flatter/ClockConfigFlatter;", "", "context", "Landroid/content/Context;", "config", "Lcom/dw/launcher/data/entity/ClockConfig;", "(Landroid/content/Context;Lcom/dw/launcher/data/entity/ClockConfig;)V", "action1", "Landroid/graphics/drawable/Drawable;", "getAction1", "()Landroid/graphics/drawable/Drawable;", "setAction1", "(Landroid/graphics/drawable/Drawable;)V", "action1Position", "Landroid/graphics/Point;", "getAction1Position", "()Landroid/graphics/Point;", "setAction1Position", "(Landroid/graphics/Point;)V", "action2", "getAction2", "setAction2", "action2Position", "getAction2Position", "setAction2Position", "action3", "getAction3", "setAction3", "action3Position", "getAction3Position", "setAction3Position", "alarmDrawable", "getAlarmDrawable", "setAlarmDrawable", "alarmPosition", "getAlarmPosition", "setAlarmPosition", "amPmDrawable", "", "getAmPmDrawable", "()Ljava/util/List;", "setAmPmDrawable", "(Ljava/util/List;)V", "amPmPosition", "getAmPmPosition", "setAmPmPosition", "background", "getBackground", "setBackground", "backgrounds", "", "getBackgrounds", "setBackgrounds", "batteryChargeDrawable", "getBatteryChargeDrawable", "setBatteryChargeDrawable", "batteryDrawable", "getBatteryDrawable", "setBatteryDrawable", "batteryIconDrawable", "getBatteryIconDrawable", "setBatteryIconDrawable", "batteryNumDrawable", "getBatteryNumDrawable", "setBatteryNumDrawable", "batteryNumPosition", "getBatteryNumPosition", "setBatteryNumPosition", "batteryPosition", "getBatteryPosition", "setBatteryPosition", "bpmDrawable", "getBpmDrawable", "setBpmDrawable", "bpmEndDrawable", "getBpmEndDrawable", "setBpmEndDrawable", "bpmNumDrawable", "getBpmNumDrawable", "setBpmNumDrawable", "bpmNumPosition", "getBpmNumPosition", "setBpmNumPosition", "bpmPosition", "getBpmPosition", "setBpmPosition", "caloriesDrawable", "getCaloriesDrawable", "setCaloriesDrawable", "caloriesEndDrawable", "getCaloriesEndDrawable", "setCaloriesEndDrawable", "caloriesNumDrawable", "getCaloriesNumDrawable", "setCaloriesNumDrawable", "caloriesNumPosition", "getCaloriesNumPosition", "setCaloriesNumPosition", "caloriesPosition", "getCaloriesPosition", "setCaloriesPosition", "compassConfig", "Lcom/dw/launcher/data/entity/CompassConfig;", "getCompassConfig", "()Lcom/dw/launcher/data/entity/CompassConfig;", "setCompassConfig", "(Lcom/dw/launcher/data/entity/CompassConfig;)V", "compassDrawable", "getCompassDrawable", "setCompassDrawable", "compassDrawable2", "getCompassDrawable2", "setCompassDrawable2", "compassPosition", "getCompassPosition", "setCompassPosition", "conectDrawables", "getConectDrawables", "setConectDrawables", "getConfig", "()Lcom/dw/launcher/data/entity/ClockConfig;", "connectPostion", "getConnectPostion", "setConnectPostion", "dateDay2Position", "getDateDay2Position", "setDateDay2Position", "dateDayNumDrawable", "getDateDayNumDrawable", "setDateDayNumDrawable", "dateDayPosition", "getDateDayPosition", "setDateDayPosition", "dateDaySplitDrawable", "getDateDaySplitDrawable", "setDateDaySplitDrawable", "dateDrawable", "getDateDrawable", "setDateDrawable", "dateMonthNumDrawable", "getDateMonthNumDrawable", "setDateMonthNumDrawable", "dateMonthPosition", "getDateMonthPosition", "setDateMonthPosition", "dateMonthSplitDrawable", "getDateMonthSplitDrawable", "setDateMonthSplitDrawable", "datePosition", "getDatePosition", "setDatePosition", "dateYearSplitDrawable", "getDateYearSplitDrawable", "setDateYearSplitDrawable", "density", "", "digitalHourDrawable", "getDigitalHourDrawable", "setDigitalHourDrawable", "digitalHourPosition", "getDigitalHourPosition", "setDigitalHourPosition", "digitalMinuteDrawable", "getDigitalMinuteDrawable", "setDigitalMinuteDrawable", "digitalMinutePosition", "getDigitalMinutePosition", "setDigitalMinutePosition", "digitalSecondDrawable", "getDigitalSecondDrawable", "setDigitalSecondDrawable", "digitalSecondPosition", "getDigitalSecondPosition", "setDigitalSecondPosition", "digitalSplit2Drawable", "getDigitalSplit2Drawable", "setDigitalSplit2Drawable", "digitalSplitDrawable", "getDigitalSplitDrawable", "setDigitalSplitDrawable", "isLoadResFinish", "", "()Z", "setLoadResFinish", "(Z)V", "lottieBackground", "Lcom/airbnb/lottie/LottieDrawable;", "getLottieBackground", "()Lcom/airbnb/lottie/LottieDrawable;", "setLottieBackground", "(Lcom/airbnb/lottie/LottieDrawable;)V", "lunarDrawable", "getLunarDrawable", "setLunarDrawable", "lunarPosition", "getLunarPosition", "setLunarPosition", "mScreenHeight", "", "getMScreenHeight", "()I", "setMScreenHeight", "(I)V", "mScreenWidth", "getMScreenWidth", "setMScreenWidth", "musicDrawable", "getMusicDrawable", "setMusicDrawable", "musicPosition", "getMusicPosition", "setMusicPosition", "pointerDotDrawable", "getPointerDotDrawable", "setPointerDotDrawable", "pointerDotPosition", "getPointerDotPosition", "setPointerDotPosition", "pointerHourDrawable", "getPointerHourDrawable", "setPointerHourDrawable", "pointerHourPosition", "getPointerHourPosition", "setPointerHourPosition", "pointerMinuteDrawable", "getPointerMinuteDrawable", "setPointerMinuteDrawable", "pointerMinutePosition", "getPointerMinutePosition", "setPointerMinutePosition", "pointerSecondDrawable", "getPointerSecondDrawable", "setPointerSecondDrawable", "pointerSecondPosition", "getPointerSecondPosition", "setPointerSecondPosition", "preview", "getPreview", "setPreview", "settingPosition", "getSettingPosition", "setSettingPosition", "settingrawable", "getSettingrawable", "setSettingrawable", "signalStrengthDrawables", "getSignalStrengthDrawables", "setSignalStrengthDrawables", "signalStrengthPosition", "getSignalStrengthPosition", "setSignalStrengthPosition", "specialDrawable", "getSpecialDrawable", "setSpecialDrawable", "specialPosition", "getSpecialPosition", "setSpecialPosition", "specialPreview", "getSpecialPreview", "setSpecialPreview", "stepDrawable", "getStepDrawable", "setStepDrawable", "stepEndDrawable", "getStepEndDrawable", "setStepEndDrawable", "stepNumDrawable", "getStepNumDrawable", "setStepNumDrawable", "stepNumPosition", "getStepNumPosition", "setStepNumPosition", "stepPosition", "getStepPosition", "setStepPosition", "weatheaDrawable", "getWeatheaDrawable", "setWeatheaDrawable", "weatherPosition", "getWeatherPosition", "setWeatherPosition", "weekNumDrawable", "getWeekNumDrawable", "setWeekNumDrawable", "weekPosition", "getWeekPosition", "setWeekPosition", "getAbsoluteScaleX", "getAbsoluteScaleY", "getAssertRealPath", "", "path", "files", "getFileRealPath", "getScaleX", "getScaleY", "load", "", "loadAnimationDrawables", "Landroid/graphics/drawable/AnimationDrawable;", "loadDrawable", "relativeDir", "loadGifDrawable", "loadInitPreview", "loadlottieDrawable", "release", "setPosition", "position", "x", "y", "splitDrawable", "size", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class ClockConfigFlatter {
    private Drawable action1;
    private Point action1Position;
    private Drawable action2;
    private Point action2Position;
    private Drawable action3;
    private Point action3Position;
    private Drawable alarmDrawable;
    private Point alarmPosition;
    private List<? extends Drawable> amPmDrawable;
    private Point amPmPosition;
    private Drawable background;
    private List<Drawable> backgrounds;
    private List<? extends Drawable> batteryChargeDrawable;
    private List<? extends Drawable> batteryDrawable;
    private Drawable batteryIconDrawable;
    private List<? extends Drawable> batteryNumDrawable;
    private Point batteryNumPosition;
    private Point batteryPosition;
    private Drawable bpmDrawable;
    private Drawable bpmEndDrawable;
    private List<? extends Drawable> bpmNumDrawable;
    private Point bpmNumPosition;
    private Point bpmPosition;
    private Drawable caloriesDrawable;
    private Drawable caloriesEndDrawable;
    private List<? extends Drawable> caloriesNumDrawable;
    private Point caloriesNumPosition;
    private Point caloriesPosition;
    private CompassConfig compassConfig;
    private Drawable compassDrawable;
    private Drawable compassDrawable2;
    private Point compassPosition;
    private List<Drawable> conectDrawables;
    private final ClockConfig config;
    private Point connectPostion;
    private final Context context;
    private Point dateDay2Position;
    private List<? extends Drawable> dateDayNumDrawable;
    private Point dateDayPosition;
    private Drawable dateDaySplitDrawable;
    private List<? extends Drawable> dateDrawable;
    private List<? extends Drawable> dateMonthNumDrawable;
    private Point dateMonthPosition;
    private Drawable dateMonthSplitDrawable;
    private Point datePosition;
    private Drawable dateYearSplitDrawable;
    private float density;
    private List<? extends Drawable> digitalHourDrawable;
    private Point digitalHourPosition;
    private List<? extends Drawable> digitalMinuteDrawable;
    private Point digitalMinutePosition;
    private List<? extends Drawable> digitalSecondDrawable;
    private Point digitalSecondPosition;
    private Drawable digitalSplit2Drawable;
    private Drawable digitalSplitDrawable;
    private boolean isLoadResFinish;
    private LottieDrawable lottieBackground;
    private List<? extends Drawable> lunarDrawable;
    private Point lunarPosition;
    private int mScreenHeight;
    private int mScreenWidth;
    private Drawable musicDrawable;
    private Point musicPosition;
    private Drawable pointerDotDrawable;
    private Point pointerDotPosition;
    private Drawable pointerHourDrawable;
    private Point pointerHourPosition;
    private Drawable pointerMinuteDrawable;
    private Point pointerMinutePosition;
    private Drawable pointerSecondDrawable;
    private Point pointerSecondPosition;
    private Drawable preview;
    private Point settingPosition;
    private Drawable settingrawable;
    private List<? extends Drawable> signalStrengthDrawables;
    private Point signalStrengthPosition;
    private Drawable specialDrawable;
    private Point specialPosition;
    private Drawable specialPreview;
    private Drawable stepDrawable;
    private Drawable stepEndDrawable;
    private List<? extends Drawable> stepNumDrawable;
    private Point stepNumPosition;
    private Point stepPosition;
    private Drawable weatheaDrawable;
    private Point weatherPosition;
    private List<? extends Drawable> weekNumDrawable;
    private Point weekPosition;

    public final void release() {
    }

    public ClockConfigFlatter(Context context, ClockConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
        this.backgrounds = new ArrayList();
        this.pointerHourPosition = new Point();
        this.pointerMinutePosition = new Point();
        this.pointerSecondPosition = new Point();
        this.pointerDotPosition = new Point();
        this.digitalHourPosition = new Point();
        this.digitalMinutePosition = new Point();
        this.digitalSecondPosition = new Point();
        this.amPmPosition = new Point();
        this.weekPosition = new Point();
        this.datePosition = new Point();
        this.dateMonthPosition = new Point();
        this.dateDayPosition = new Point();
        this.dateDay2Position = new Point();
        this.bpmPosition = new Point();
        this.bpmNumPosition = new Point();
        this.stepPosition = new Point();
        this.stepNumPosition = new Point();
        this.caloriesPosition = new Point();
        this.caloriesNumPosition = new Point();
        this.batteryPosition = new Point();
        this.batteryNumPosition = new Point();
        this.action1Position = new Point();
        this.action2Position = new Point();
        this.action3Position = new Point();
        this.signalStrengthPosition = new Point();
        this.lunarPosition = new Point();
        this.mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
        this.mScreenHeight = context.getResources().getDisplayMetrics().heightPixels;
        this.density = context.getResources().getDisplayMetrics().density;
        this.alarmPosition = new Point();
        this.musicPosition = new Point();
        this.weatherPosition = new Point();
        this.compassPosition = new Point();
        this.settingPosition = new Point();
        this.specialPosition = new Point();
        this.connectPostion = new Point();
        Drawable drawableLoadDrawable$default = loadDrawable$default(this, "thumb.png", false, 2, null);
        this.preview = drawableLoadDrawable$default;
        if (drawableLoadDrawable$default == null) {
            this.preview = loadDrawable$default(this, "thumb.jpg", false, 2, null);
        }
        if (config.supportBgCustomize()) {
            this.specialPreview = loadDrawable$default(this, "special_preview.png", false, 2, null);
            String string = context.getSharedPreferences("launcher_preference", 0).getString("custom_watch_id_" + config.getId(), null);
            if (string != null) {
                this.preview = ResourceUtils.INSTANCE.getDrawableFromAbsolutePath(context, string);
                this.background = ResourceUtils.INSTANCE.getDrawableFromAbsolutePath(context, string);
            }
        }
        if (config.showSpecial()) {
            this.specialDrawable = loadDrawable$default(this, config.getSpecial_1_src(), false, 2, null);
            setPosition(this.specialPosition, config.getSpecial_x(), config.getSpecial_y());
        }
    }

    public final ClockConfig getConfig() {
        return this.config;
    }

    public final Drawable getPreview() {
        return this.preview;
    }

    public final void setPreview(Drawable drawable) {
        this.preview = drawable;
    }

    public final Drawable getSpecialPreview() {
        return this.specialPreview;
    }

    public final void setSpecialPreview(Drawable drawable) {
        this.specialPreview = drawable;
    }

    public final Drawable getBackground() {
        return this.background;
    }

    public final void setBackground(Drawable drawable) {
        this.background = drawable;
    }

    public final List<Drawable> getBackgrounds() {
        return this.backgrounds;
    }

    public final void setBackgrounds(List<Drawable> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.backgrounds = list;
    }

    public final LottieDrawable getLottieBackground() {
        return this.lottieBackground;
    }

    public final void setLottieBackground(LottieDrawable lottieDrawable) {
        this.lottieBackground = lottieDrawable;
    }

    public final Drawable getPointerHourDrawable() {
        return this.pointerHourDrawable;
    }

    public final void setPointerHourDrawable(Drawable drawable) {
        this.pointerHourDrawable = drawable;
    }

    public final Drawable getPointerMinuteDrawable() {
        return this.pointerMinuteDrawable;
    }

    public final void setPointerMinuteDrawable(Drawable drawable) {
        this.pointerMinuteDrawable = drawable;
    }

    public final Drawable getPointerSecondDrawable() {
        return this.pointerSecondDrawable;
    }

    public final void setPointerSecondDrawable(Drawable drawable) {
        this.pointerSecondDrawable = drawable;
    }

    public final Drawable getPointerDotDrawable() {
        return this.pointerDotDrawable;
    }

    public final void setPointerDotDrawable(Drawable drawable) {
        this.pointerDotDrawable = drawable;
    }

    public final Point getPointerHourPosition() {
        return this.pointerHourPosition;
    }

    public final void setPointerHourPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.pointerHourPosition = point;
    }

    public final Point getPointerMinutePosition() {
        return this.pointerMinutePosition;
    }

    public final void setPointerMinutePosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.pointerMinutePosition = point;
    }

    public final Point getPointerSecondPosition() {
        return this.pointerSecondPosition;
    }

    public final void setPointerSecondPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.pointerSecondPosition = point;
    }

    public final Point getPointerDotPosition() {
        return this.pointerDotPosition;
    }

    public final void setPointerDotPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.pointerDotPosition = point;
    }

    public final List<Drawable> getDigitalHourDrawable() {
        return this.digitalHourDrawable;
    }

    public final void setDigitalHourDrawable(List<? extends Drawable> list) {
        this.digitalHourDrawable = list;
    }

    public final List<Drawable> getDigitalMinuteDrawable() {
        return this.digitalMinuteDrawable;
    }

    public final void setDigitalMinuteDrawable(List<? extends Drawable> list) {
        this.digitalMinuteDrawable = list;
    }

    public final List<Drawable> getDigitalSecondDrawable() {
        return this.digitalSecondDrawable;
    }

    public final void setDigitalSecondDrawable(List<? extends Drawable> list) {
        this.digitalSecondDrawable = list;
    }

    public final Drawable getDigitalSplitDrawable() {
        return this.digitalSplitDrawable;
    }

    public final void setDigitalSplitDrawable(Drawable drawable) {
        this.digitalSplitDrawable = drawable;
    }

    public final Drawable getDigitalSplit2Drawable() {
        return this.digitalSplit2Drawable;
    }

    public final void setDigitalSplit2Drawable(Drawable drawable) {
        this.digitalSplit2Drawable = drawable;
    }

    public final Point getDigitalHourPosition() {
        return this.digitalHourPosition;
    }

    public final void setDigitalHourPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.digitalHourPosition = point;
    }

    public final Point getDigitalMinutePosition() {
        return this.digitalMinutePosition;
    }

    public final void setDigitalMinutePosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.digitalMinutePosition = point;
    }

    public final Point getDigitalSecondPosition() {
        return this.digitalSecondPosition;
    }

    public final void setDigitalSecondPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.digitalSecondPosition = point;
    }

    public final List<Drawable> getAmPmDrawable() {
        return this.amPmDrawable;
    }

    public final void setAmPmDrawable(List<? extends Drawable> list) {
        this.amPmDrawable = list;
    }

    public final Point getAmPmPosition() {
        return this.amPmPosition;
    }

    public final void setAmPmPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.amPmPosition = point;
    }

    public final List<Drawable> getWeekNumDrawable() {
        return this.weekNumDrawable;
    }

    public final void setWeekNumDrawable(List<? extends Drawable> list) {
        this.weekNumDrawable = list;
    }

    public final Point getWeekPosition() {
        return this.weekPosition;
    }

    public final void setWeekPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.weekPosition = point;
    }

    public final List<Drawable> getDateDrawable() {
        return this.dateDrawable;
    }

    public final void setDateDrawable(List<? extends Drawable> list) {
        this.dateDrawable = list;
    }

    public final Point getDatePosition() {
        return this.datePosition;
    }

    public final void setDatePosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.datePosition = point;
    }

    public final Drawable getDateYearSplitDrawable() {
        return this.dateYearSplitDrawable;
    }

    public final void setDateYearSplitDrawable(Drawable drawable) {
        this.dateYearSplitDrawable = drawable;
    }

    public final List<Drawable> getDateMonthNumDrawable() {
        return this.dateMonthNumDrawable;
    }

    public final void setDateMonthNumDrawable(List<? extends Drawable> list) {
        this.dateMonthNumDrawable = list;
    }

    public final Point getDateMonthPosition() {
        return this.dateMonthPosition;
    }

    public final void setDateMonthPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.dateMonthPosition = point;
    }

    public final Drawable getDateMonthSplitDrawable() {
        return this.dateMonthSplitDrawable;
    }

    public final void setDateMonthSplitDrawable(Drawable drawable) {
        this.dateMonthSplitDrawable = drawable;
    }

    public final List<Drawable> getDateDayNumDrawable() {
        return this.dateDayNumDrawable;
    }

    public final void setDateDayNumDrawable(List<? extends Drawable> list) {
        this.dateDayNumDrawable = list;
    }

    public final Point getDateDayPosition() {
        return this.dateDayPosition;
    }

    public final void setDateDayPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.dateDayPosition = point;
    }

    public final Point getDateDay2Position() {
        return this.dateDay2Position;
    }

    public final void setDateDay2Position(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.dateDay2Position = point;
    }

    public final Drawable getDateDaySplitDrawable() {
        return this.dateDaySplitDrawable;
    }

    public final void setDateDaySplitDrawable(Drawable drawable) {
        this.dateDaySplitDrawable = drawable;
    }

    public final Drawable getBpmDrawable() {
        return this.bpmDrawable;
    }

    public final void setBpmDrawable(Drawable drawable) {
        this.bpmDrawable = drawable;
    }

    public final Point getBpmPosition() {
        return this.bpmPosition;
    }

    public final void setBpmPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.bpmPosition = point;
    }

    public final List<Drawable> getBpmNumDrawable() {
        return this.bpmNumDrawable;
    }

    public final void setBpmNumDrawable(List<? extends Drawable> list) {
        this.bpmNumDrawable = list;
    }

    public final Point getBpmNumPosition() {
        return this.bpmNumPosition;
    }

    public final void setBpmNumPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.bpmNumPosition = point;
    }

    public final Drawable getBpmEndDrawable() {
        return this.bpmEndDrawable;
    }

    public final void setBpmEndDrawable(Drawable drawable) {
        this.bpmEndDrawable = drawable;
    }

    public final Drawable getStepDrawable() {
        return this.stepDrawable;
    }

    public final void setStepDrawable(Drawable drawable) {
        this.stepDrawable = drawable;
    }

    public final Point getStepPosition() {
        return this.stepPosition;
    }

    public final void setStepPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.stepPosition = point;
    }

    public final List<Drawable> getStepNumDrawable() {
        return this.stepNumDrawable;
    }

    public final void setStepNumDrawable(List<? extends Drawable> list) {
        this.stepNumDrawable = list;
    }

    public final Point getStepNumPosition() {
        return this.stepNumPosition;
    }

    public final void setStepNumPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.stepNumPosition = point;
    }

    public final Drawable getStepEndDrawable() {
        return this.stepEndDrawable;
    }

    public final void setStepEndDrawable(Drawable drawable) {
        this.stepEndDrawable = drawable;
    }

    public final Drawable getCaloriesDrawable() {
        return this.caloriesDrawable;
    }

    public final void setCaloriesDrawable(Drawable drawable) {
        this.caloriesDrawable = drawable;
    }

    public final Point getCaloriesPosition() {
        return this.caloriesPosition;
    }

    public final void setCaloriesPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.caloriesPosition = point;
    }

    public final List<Drawable> getCaloriesNumDrawable() {
        return this.caloriesNumDrawable;
    }

    public final void setCaloriesNumDrawable(List<? extends Drawable> list) {
        this.caloriesNumDrawable = list;
    }

    public final Point getCaloriesNumPosition() {
        return this.caloriesNumPosition;
    }

    public final void setCaloriesNumPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.caloriesNumPosition = point;
    }

    public final Drawable getCaloriesEndDrawable() {
        return this.caloriesEndDrawable;
    }

    public final void setCaloriesEndDrawable(Drawable drawable) {
        this.caloriesEndDrawable = drawable;
    }

    public final List<Drawable> getBatteryDrawable() {
        return this.batteryDrawable;
    }

    public final void setBatteryDrawable(List<? extends Drawable> list) {
        this.batteryDrawable = list;
    }

    public final List<Drawable> getBatteryChargeDrawable() {
        return this.batteryChargeDrawable;
    }

    public final void setBatteryChargeDrawable(List<? extends Drawable> list) {
        this.batteryChargeDrawable = list;
    }

    public final Point getBatteryPosition() {
        return this.batteryPosition;
    }

    public final void setBatteryPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.batteryPosition = point;
    }

    public final List<Drawable> getBatteryNumDrawable() {
        return this.batteryNumDrawable;
    }

    public final void setBatteryNumDrawable(List<? extends Drawable> list) {
        this.batteryNumDrawable = list;
    }

    public final Point getBatteryNumPosition() {
        return this.batteryNumPosition;
    }

    public final void setBatteryNumPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.batteryNumPosition = point;
    }

    public final Drawable getBatteryIconDrawable() {
        return this.batteryIconDrawable;
    }

    public final void setBatteryIconDrawable(Drawable drawable) {
        this.batteryIconDrawable = drawable;
    }

    public final Drawable getAction1() {
        return this.action1;
    }

    public final void setAction1(Drawable drawable) {
        this.action1 = drawable;
    }

    public final Drawable getAction2() {
        return this.action2;
    }

    public final void setAction2(Drawable drawable) {
        this.action2 = drawable;
    }

    public final Drawable getAction3() {
        return this.action3;
    }

    public final void setAction3(Drawable drawable) {
        this.action3 = drawable;
    }

    public final Point getAction1Position() {
        return this.action1Position;
    }

    public final void setAction1Position(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.action1Position = point;
    }

    public final Point getAction2Position() {
        return this.action2Position;
    }

    public final void setAction2Position(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.action2Position = point;
    }

    public final Point getAction3Position() {
        return this.action3Position;
    }

    public final void setAction3Position(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.action3Position = point;
    }

    public final List<Drawable> getSignalStrengthDrawables() {
        return this.signalStrengthDrawables;
    }

    public final void setSignalStrengthDrawables(List<? extends Drawable> list) {
        this.signalStrengthDrawables = list;
    }

    public final Point getSignalStrengthPosition() {
        return this.signalStrengthPosition;
    }

    public final void setSignalStrengthPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.signalStrengthPosition = point;
    }

    public final List<Drawable> getLunarDrawable() {
        return this.lunarDrawable;
    }

    public final void setLunarDrawable(List<? extends Drawable> list) {
        this.lunarDrawable = list;
    }

    public final Point getLunarPosition() {
        return this.lunarPosition;
    }

    public final void setLunarPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.lunarPosition = point;
    }

    public final int getMScreenWidth() {
        return this.mScreenWidth;
    }

    public final void setMScreenWidth(int i) {
        this.mScreenWidth = i;
    }

    public final int getMScreenHeight() {
        return this.mScreenHeight;
    }

    public final void setMScreenHeight(int i) {
        this.mScreenHeight = i;
    }

    public final Drawable getAlarmDrawable() {
        return this.alarmDrawable;
    }

    public final void setAlarmDrawable(Drawable drawable) {
        this.alarmDrawable = drawable;
    }

    public final Point getAlarmPosition() {
        return this.alarmPosition;
    }

    public final void setAlarmPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.alarmPosition = point;
    }

    public final Drawable getMusicDrawable() {
        return this.musicDrawable;
    }

    public final void setMusicDrawable(Drawable drawable) {
        this.musicDrawable = drawable;
    }

    public final Point getMusicPosition() {
        return this.musicPosition;
    }

    public final void setMusicPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.musicPosition = point;
    }

    public final Drawable getWeatheaDrawable() {
        return this.weatheaDrawable;
    }

    public final void setWeatheaDrawable(Drawable drawable) {
        this.weatheaDrawable = drawable;
    }

    public final Point getWeatherPosition() {
        return this.weatherPosition;
    }

    public final void setWeatherPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.weatherPosition = point;
    }

    public final Drawable getCompassDrawable() {
        return this.compassDrawable;
    }

    public final void setCompassDrawable(Drawable drawable) {
        this.compassDrawable = drawable;
    }

    public final Drawable getCompassDrawable2() {
        return this.compassDrawable2;
    }

    public final void setCompassDrawable2(Drawable drawable) {
        this.compassDrawable2 = drawable;
    }

    public final Point getCompassPosition() {
        return this.compassPosition;
    }

    public final void setCompassPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.compassPosition = point;
    }

    public final Drawable getSettingrawable() {
        return this.settingrawable;
    }

    public final void setSettingrawable(Drawable drawable) {
        this.settingrawable = drawable;
    }

    public final Point getSettingPosition() {
        return this.settingPosition;
    }

    public final void setSettingPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.settingPosition = point;
    }

    public final Drawable getSpecialDrawable() {
        return this.specialDrawable;
    }

    public final void setSpecialDrawable(Drawable drawable) {
        this.specialDrawable = drawable;
    }

    public final Point getSpecialPosition() {
        return this.specialPosition;
    }

    public final void setSpecialPosition(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.specialPosition = point;
    }

    public final CompassConfig getCompassConfig() {
        return this.compassConfig;
    }

    public final void setCompassConfig(CompassConfig compassConfig) {
        this.compassConfig = compassConfig;
    }

    public final List<Drawable> getConectDrawables() {
        return this.conectDrawables;
    }

    public final void setConectDrawables(List<Drawable> list) {
        this.conectDrawables = list;
    }

    public final Point getConnectPostion() {
        return this.connectPostion;
    }

    public final void setConnectPostion(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.connectPostion = point;
    }

    /* JADX INFO: renamed from: isLoadResFinish, reason: from getter */
    public final boolean getIsLoadResFinish() {
        return this.isLoadResFinish;
    }

    public final void setLoadResFinish(boolean z) {
        this.isLoadResFinish = z;
    }

    public final Drawable loadInitPreview() {
        Drawable drawableLoadDrawable$default = loadDrawable$default(this, "thumb.png", false, 2, null);
        return drawableLoadDrawable$default == null ? loadDrawable$default(this, "thumb.jpg", false, 2, null) : drawableLoadDrawable$default;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0114  */
    public final void load() throws IOException {
        String[] list;
        String[] strArr;
        String[] list2;
        List<Drawable> listSplitDrawable;
        this.isLoadResFinish = false;
        Timber.INSTANCE.d("加载配置： " + this.config, new Object[0]);
        Drawable drawableLoadDrawable$default = loadDrawable$default(this, "thumb.png", false, 2, null);
        this.preview = drawableLoadDrawable$default;
        if (drawableLoadDrawable$default == null) {
            this.preview = loadDrawable$default(this, "thumb.jpg", false, 2, null);
        }
        if (this.config.isFromAssets()) {
            list = this.context.getAssets().list(this.config.getPath() + "/res/bg");
        } else {
            list = new File(this.config.getPath() + "/res/bg").list();
        }
        if (this.config.getBg_type() == 0 || this.config.getBg_type() == 3 || this.config.getBg_type() == 6 || this.config.getBg_type() == 7) {
            if (list != null) {
                final AnonymousClass1 anonymousClass1 = new Function2<String, String, Integer>() { // from class: com.dw.launcher.ui.clock.flatter.ClockConfigFlatter.load.1
                    @Override // kotlin.jvm.functions.Function2
                    public final Integer invoke(String str, String str2) {
                        String value;
                        Integer intOrNull;
                        String value2;
                        Integer intOrNull2;
                        Regex regex = new Regex("\\d+");
                        Intrinsics.checkNotNull(str);
                        MatchResult matchResultFind$default = Regex.find$default(regex, str, 0, 2, null);
                        int iIntValue = Integer.MAX_VALUE;
                        int iIntValue2 = (matchResultFind$default == null || (value2 = matchResultFind$default.getValue()) == null || (intOrNull2 = StringsKt.toIntOrNull(value2)) == null) ? Integer.MAX_VALUE : intOrNull2.intValue();
                        Intrinsics.checkNotNull(str2);
                        MatchResult matchResultFind$default2 = Regex.find$default(regex, str2, 0, 2, null);
                        if (matchResultFind$default2 != null && (value = matchResultFind$default2.getValue()) != null && (intOrNull = StringsKt.toIntOrNull(value)) != null) {
                            iIntValue = intOrNull.intValue();
                        }
                        return Integer.valueOf(Intrinsics.compare(iIntValue2, iIntValue));
                    }
                };
                List listSortedWith = ArraysKt.sortedWith(list, new Comparator() { // from class: com.dw.launcher.ui.clock.flatter.ClockConfigFlatter$$ExternalSyntheticLambda0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ClockConfigFlatter.load$lambda$1(anonymousClass1, obj, obj2);
                    }
                });
                if (listSortedWith != null) {
                    strArr = (String[]) listSortedWith.toArray(new String[0]);
                } else {
                    strArr = null;
                }
            } else {
                strArr = null;
            }
            if (strArr != null) {
                for (String str : strArr) {
                    Drawable drawableLoadDrawable$default2 = loadDrawable$default(this, "res/bg/" + str, false, 2, null);
                    if (drawableLoadDrawable$default2 != null) {
                        this.backgrounds.add(drawableLoadDrawable$default2);
                        Unit unit = Unit.INSTANCE;
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
                Unit unit3 = Unit.INSTANCE;
            }
            this.background = this.backgrounds.get(this.config.getBg_btn_index());
        } else if (this.config.getBg_type() == 1) {
            this.background = loadAnimationDrawables("res/bg");
        } else if (this.config.getBg_type() == 2) {
            if (list != null) {
                for (String str2 : list) {
                    Drawable drawableLoadGifDrawable = loadGifDrawable("res/bg/" + str2);
                    if (drawableLoadGifDrawable != null) {
                        this.backgrounds.add(drawableLoadGifDrawable);
                        Unit unit4 = Unit.INSTANCE;
                        Unit unit5 = Unit.INSTANCE;
                    }
                }
                Unit unit6 = Unit.INSTANCE;
            }
            this.background = this.backgrounds.get(this.config.getBg_btn_index());
        }
        String lottie = this.config.getLottie();
        if (lottie != null) {
            if (lottie.length() > 0) {
                try {
                    this.lottieBackground = loadlottieDrawable$default(this, lottie, false, 2, null);
                } catch (Exception e) {
                    Timber.INSTANCE.w(e, "parse lottie background failure", new Object[0]);
                }
            }
            Unit unit7 = Unit.INSTANCE;
            Unit unit8 = Unit.INSTANCE;
        }
        if (this.config.supportBgCustomize()) {
            this.specialPreview = loadDrawable$default(this, "special_preview.png", false, 2, null);
            String string = this.context.getSharedPreferences("launcher_preference", 0).getString("custom_watch_id_" + this.config.getId(), null);
            if (string != null) {
                this.preview = ResourceUtils.INSTANCE.getDrawableFromAbsolutePath(this.context, string);
                this.background = ResourceUtils.INSTANCE.getDrawableFromAbsolutePath(this.context, string);
                Unit unit9 = Unit.INSTANCE;
                Unit unit10 = Unit.INSTANCE;
            }
        }
        if (this.config.isPointerSupport()) {
            setPosition(this.pointerHourPosition, this.config.getHour_pointer_x(), this.config.getHour_pointer_y());
            setPosition(this.pointerMinutePosition, this.config.getMinute_pointer_x(), this.config.getMinute_pointer_y());
            setPosition(this.pointerSecondPosition, this.config.getSecond_pointer_x(), this.config.getSecond_pointer_y());
            setPosition(this.pointerDotPosition, this.config.getHour_pointer_x(), this.config.getHour_pointer_y());
            this.pointerHourDrawable = loadDrawable$default(this, this.config.getHour_pointer_src(), false, 2, null);
            this.pointerMinuteDrawable = loadDrawable$default(this, this.config.getMinute_pointer_src(), false, 2, null);
            if (this.config.getSecond_pointer_animal_type() == 2) {
                this.pointerSecondDrawable = loadGifDrawable(this.config.getSecond_pointer_src());
            } else if (this.config.getSecond_pointer_animal_type() == 1) {
                this.pointerSecondDrawable = loadAnimationDrawables(this.config.getSecond_pointer_src());
            } else {
                this.pointerSecondDrawable = loadDrawable$default(this, this.config.getSecond_pointer_src(), false, 2, null);
            }
            this.pointerDotDrawable = loadDrawable$default(this, this.config.getDot_src(), false, 2, null);
        }
        if (this.config.isDigitalSupport()) {
            setPosition(this.digitalHourPosition, this.config.getTime_x(), this.config.getTime_y());
            if (!this.config.isDigitalMinuteAutomatic()) {
                setPosition(this.digitalMinutePosition, this.config.getReset_min_x(), this.config.getReset_min_y());
            }
            if (!this.config.isDigitalSecondAutomatic()) {
                setPosition(this.digitalSecondPosition, this.config.getReset_sec_x(), this.config.getReset_sec_y());
            }
            this.digitalHourDrawable = splitDrawable(this.config.getTime_hour_src(), 10);
            List<Drawable> listSplitDrawable2 = splitDrawable(this.config.getTime_min_src(), 10);
            this.digitalMinuteDrawable = listSplitDrawable2;
            if (listSplitDrawable2 == null) {
                this.digitalMinuteDrawable = this.digitalHourDrawable;
            }
            if (this.config.getShow_sec() != 0) {
                List<Drawable> listSplitDrawable3 = splitDrawable(this.config.getTime_sec_src(), 10);
                this.digitalSecondDrawable = listSplitDrawable3;
                if (listSplitDrawable3 == null) {
                    this.digitalSecondDrawable = this.digitalHourDrawable;
                }
            }
            this.digitalSplitDrawable = loadDrawable$default(this, this.config.getTime_splt_src(), false, 2, null);
            this.digitalSplit2Drawable = loadDrawable$default(this, this.config.getTime_splt_2_src(), false, 2, null);
        }
        if (this.config.showAmPm()) {
            if (this.config.getShow_ampm_placeholer() == 1) {
                listSplitDrawable = splitDrawable(this.config.getAm_and_pm_src(), 3);
            } else {
                listSplitDrawable = splitDrawable(this.config.getAm_and_pm_src(), 2);
            }
            this.amPmDrawable = listSplitDrawable;
            setPosition(this.amPmPosition, this.config.getAm_or_pm_x(), this.config.getAm_or_pm_y());
        }
        String week_num_src = this.config.getWeek_num_src();
        if (week_num_src != null) {
            this.weekNumDrawable = splitDrawable(week_num_src, 7);
            Unit unit11 = Unit.INSTANCE;
            Unit unit12 = Unit.INSTANCE;
        }
        setPosition(this.weekPosition, this.config.getWeek_x(), this.config.getWeek_y());
        this.dateDrawable = splitDrawable(this.config.getDate_src(), 10);
        setPosition(this.datePosition, this.config.getDate_x(), this.config.getDate_y());
        this.dateYearSplitDrawable = loadDrawable$default(this, this.config.getDate_year_splt_src(), false, 2, null);
        if (this.config.getMonth_type() == 0) {
            List<? extends Drawable> listSplitDrawable4 = splitDrawable(this.config.getMonth_src(), 10);
            if (listSplitDrawable4 == null) {
                listSplitDrawable4 = this.dateDrawable;
            }
            this.dateMonthNumDrawable = listSplitDrawable4;
        } else {
            this.dateMonthNumDrawable = splitDrawable(this.config.getMonth_src(), 12);
        }
        setPosition(this.dateMonthPosition, this.config.getMonth_x(), this.config.getMonth_y());
        this.dateMonthSplitDrawable = loadDrawable$default(this, this.config.getDate_month_splt_src(), false, 2, null);
        if (this.config.getDay_type() == 0) {
            List<? extends Drawable> listSplitDrawable5 = splitDrawable(this.config.getData_day_num(), 10);
            if (listSplitDrawable5 == null) {
                listSplitDrawable5 = this.dateDrawable;
            }
            this.dateDayNumDrawable = listSplitDrawable5;
        } else {
            List<? extends Drawable> listSplitDrawable6 = splitDrawable(this.config.getDay_src(), 31);
            if (listSplitDrawable6 == null) {
                listSplitDrawable6 = this.dateDrawable;
            }
            this.dateDayNumDrawable = listSplitDrawable6;
        }
        setPosition(this.dateDayPosition, this.config.getDay_x(), this.config.getDay_y());
        if (this.config.getNeed_split_day() == 1) {
            setPosition(this.dateDay2Position, this.config.getSplit_day_x(), this.config.getSplit_day_y());
        }
        this.dateDaySplitDrawable = loadDrawable$default(this, this.config.getDate_day_splt_src(), false, 2, null);
        if (this.config.showHeart()) {
            this.bpmDrawable = loadDrawable$default(this, this.config.getHeart_src(), false, 2, null);
            setPosition(this.bpmPosition, this.config.getHeart_x(), this.config.getHeart_y());
            this.bpmNumDrawable = splitDrawable(this.config.getHeart_num_src(), 10);
            setPosition(this.bpmNumPosition, this.config.getHeart_num_x(), this.config.getHeart_num_y());
            this.bpmEndDrawable = loadDrawable$default(this, this.config.getHeart_end_src(), false, 2, null);
        }
        if (this.config.showStep()) {
            this.stepDrawable = loadDrawable$default(this, this.config.getStep_src(), false, 2, null);
            setPosition(this.stepPosition, this.config.getStep_x(), this.config.getStep_y());
            this.stepNumDrawable = splitDrawable(this.config.getStep_num_src(), 10);
            setPosition(this.stepNumPosition, this.config.getStep_num_x(), this.config.getStep_num_y());
            this.stepEndDrawable = loadDrawable$default(this, this.config.getStep_end_src(), false, 2, null);
        }
        if (this.config.showCalories()) {
            this.caloriesDrawable = loadDrawable$default(this, this.config.getKcal_src(), false, 2, null);
            setPosition(this.caloriesPosition, this.config.getKcal_x(), this.config.getKcal_y());
            this.caloriesNumDrawable = splitDrawable(this.config.getKcal_num_src(), 10);
            setPosition(this.caloriesNumPosition, this.config.getKcal_num_x(), this.config.getKcal_num_y());
            this.caloriesEndDrawable = loadDrawable$default(this, this.config.getKcal_end_src(), false, 2, null);
        }
        if (this.config.showBattery()) {
            ArrayList arrayList = new ArrayList();
            Drawable drawableLoadDrawable$default3 = loadDrawable$default(this, this.config.getNormal_0_src(), false, 2, null);
            Intrinsics.checkNotNull(drawableLoadDrawable$default3);
            arrayList.add(drawableLoadDrawable$default3);
            Drawable drawableLoadDrawable$default4 = loadDrawable$default(this, this.config.getNormal_1_src(), false, 2, null);
            Intrinsics.checkNotNull(drawableLoadDrawable$default4);
            arrayList.add(drawableLoadDrawable$default4);
            Drawable drawableLoadDrawable$default5 = loadDrawable$default(this, this.config.getNormal_2_src(), false, 2, null);
            Intrinsics.checkNotNull(drawableLoadDrawable$default5);
            arrayList.add(drawableLoadDrawable$default5);
            Drawable drawableLoadDrawable$default6 = loadDrawable$default(this, this.config.getNormal_3_src(), false, 2, null);
            Intrinsics.checkNotNull(drawableLoadDrawable$default6);
            arrayList.add(drawableLoadDrawable$default6);
            Drawable drawableLoadDrawable$default7 = loadDrawable$default(this, this.config.getNormal_4_src(), false, 2, null);
            Intrinsics.checkNotNull(drawableLoadDrawable$default7);
            arrayList.add(drawableLoadDrawable$default7);
            Drawable drawableLoadDrawable$default8 = loadDrawable$default(this, this.config.getNormal_5_src(), false, 2, null);
            Intrinsics.checkNotNull(drawableLoadDrawable$default8);
            arrayList.add(drawableLoadDrawable$default8);
            Drawable drawableLoadDrawable$default9 = loadDrawable$default(this, this.config.getNormal_6_src(), false, 2, null);
            Intrinsics.checkNotNull(drawableLoadDrawable$default9);
            arrayList.add(drawableLoadDrawable$default9);
            Drawable drawableLoadDrawable$default10 = loadDrawable$default(this, this.config.getNormal_7_src(), false, 2, null);
            Intrinsics.checkNotNull(drawableLoadDrawable$default10);
            arrayList.add(drawableLoadDrawable$default10);
            Drawable drawableLoadDrawable$default11 = loadDrawable$default(this, this.config.getNormal_8_src(), false, 2, null);
            Intrinsics.checkNotNull(drawableLoadDrawable$default11);
            arrayList.add(drawableLoadDrawable$default11);
            Drawable drawableLoadDrawable$default12 = loadDrawable$default(this, this.config.getNormal_9_src(), false, 2, null);
            Intrinsics.checkNotNull(drawableLoadDrawable$default12);
            arrayList.add(drawableLoadDrawable$default12);
            Drawable drawableLoadDrawable$default13 = loadDrawable$default(this, this.config.getNormal_10_src(), false, 2, null);
            Intrinsics.checkNotNull(drawableLoadDrawable$default13);
            arrayList.add(drawableLoadDrawable$default13);
            this.batteryDrawable = arrayList;
            if (this.config.showCharge()) {
                ArrayList arrayList2 = new ArrayList();
                Drawable drawableLoadDrawable$default14 = loadDrawable$default(this, this.config.getCharge_0_src(), false, 2, null);
                Intrinsics.checkNotNull(drawableLoadDrawable$default14);
                arrayList2.add(drawableLoadDrawable$default14);
                Drawable drawableLoadDrawable$default15 = loadDrawable$default(this, this.config.getCharge_1_src(), false, 2, null);
                Intrinsics.checkNotNull(drawableLoadDrawable$default15);
                arrayList2.add(drawableLoadDrawable$default15);
                Drawable drawableLoadDrawable$default16 = loadDrawable$default(this, this.config.getCharge_2_src(), false, 2, null);
                Intrinsics.checkNotNull(drawableLoadDrawable$default16);
                arrayList2.add(drawableLoadDrawable$default16);
                Drawable drawableLoadDrawable$default17 = loadDrawable$default(this, this.config.getCharge_3_src(), false, 2, null);
                Intrinsics.checkNotNull(drawableLoadDrawable$default17);
                arrayList2.add(drawableLoadDrawable$default17);
                Drawable drawableLoadDrawable$default18 = loadDrawable$default(this, this.config.getCharge_4_src(), false, 2, null);
                Intrinsics.checkNotNull(drawableLoadDrawable$default18);
                arrayList2.add(drawableLoadDrawable$default18);
                Drawable drawableLoadDrawable$default19 = loadDrawable$default(this, this.config.getCharge_5_src(), false, 2, null);
                Intrinsics.checkNotNull(drawableLoadDrawable$default19);
                arrayList2.add(drawableLoadDrawable$default19);
                Drawable drawableLoadDrawable$default20 = loadDrawable$default(this, this.config.getCharge_6_src(), false, 2, null);
                Intrinsics.checkNotNull(drawableLoadDrawable$default20);
                arrayList2.add(drawableLoadDrawable$default20);
                Drawable drawableLoadDrawable$default21 = loadDrawable$default(this, this.config.getCharge_7_src(), false, 2, null);
                Intrinsics.checkNotNull(drawableLoadDrawable$default21);
                arrayList2.add(drawableLoadDrawable$default21);
                Drawable drawableLoadDrawable$default22 = loadDrawable$default(this, this.config.getCharge_8_src(), false, 2, null);
                Intrinsics.checkNotNull(drawableLoadDrawable$default22);
                arrayList2.add(drawableLoadDrawable$default22);
                Drawable drawableLoadDrawable$default23 = loadDrawable$default(this, this.config.getCharge_9_src(), false, 2, null);
                Intrinsics.checkNotNull(drawableLoadDrawable$default23);
                arrayList2.add(drawableLoadDrawable$default23);
                Drawable drawableLoadDrawable$default24 = loadDrawable$default(this, this.config.getCharge_10_src(), false, 2, null);
                Intrinsics.checkNotNull(drawableLoadDrawable$default24);
                arrayList2.add(drawableLoadDrawable$default24);
                this.batteryChargeDrawable = arrayList2;
            }
            setPosition(this.batteryPosition, this.config.getPower_x(), this.config.getPower_y());
        }
        if (this.config.showBatteryNum()) {
            this.batteryNumDrawable = splitDrawable(this.config.getPower_num_src(), 10);
            this.batteryIconDrawable = loadDrawable$default(this, this.config.getPower_sign_src(), false, 2, null);
            setPosition(this.batteryNumPosition, this.config.getPower_num_x(), this.config.getPower_num_y());
        }
        if (this.config.getShow_action() == 1) {
            if (this.config.getOpen_action_1() == 1 || this.config.getOpen_action_1() == 6) {
                this.action1 = loadAnimationDrawables("res/action1");
            } else if (this.config.getOpen_action_1() == 2) {
                this.action1 = loadGifDrawable("res/action1/action.gif");
            }
            setPosition(this.action1Position, this.config.getAction_1_x(), this.config.getAction_1_y());
            if (this.config.getOpen_action_2() == 1) {
                this.action2 = loadAnimationDrawables("res/action2");
            } else if (this.config.getOpen_action_2() == 2) {
                this.action2 = loadGifDrawable("res/action2/action.gif");
            }
            setPosition(this.action2Position, this.config.getAction_2_x(), this.config.getAction_2_y());
            if (this.config.getOpen_action_3() == 1) {
                this.action3 = loadAnimationDrawables("res/action3");
            } else if (this.config.getOpen_action_3() == 2) {
                this.action3 = loadGifDrawable("res/action3/action.gif");
            }
            setPosition(this.action3Position, this.config.getAction_3_x(), this.config.getAction_3_y());
        }
        if (this.config.showSignal()) {
            this.signalStrengthDrawables = splitDrawable(this.config.getSignal_src(), 6);
            setPosition(this.signalStrengthPosition, this.config.getSignal_x(), this.config.getSignal_y());
        }
        if (this.config.showLunar()) {
            this.lunarDrawable = splitDrawable(this.config.getLunar_src(), 16);
            setPosition(this.lunarPosition, this.config.getLunar_x(), this.config.getLunar_y());
        }
        if (this.config.showAlarm()) {
            this.alarmDrawable = loadDrawable$default(this, this.config.getBtn_alarm_src(), false, 2, null);
            setPosition(this.alarmPosition, this.config.getBtn_alarm_x(), this.config.getBtn_alarm_y());
        }
        if (this.config.showMusic()) {
            this.musicDrawable = loadDrawable$default(this, this.config.getBtn_music_src(), false, 2, null);
            setPosition(this.musicPosition, this.config.getBtn_music_x(), this.config.getBtn_music_y());
        }
        if (this.config.showBtnWeather()) {
            this.weatheaDrawable = loadDrawable$default(this, this.config.getBtn_weather_src(), false, 2, null);
            setPosition(this.weatherPosition, this.config.getBtn_weather_x(), this.config.getBtn_weather_y());
        }
        if (this.config.supportCompass()) {
            this.compassDrawable = loadDrawable$default(this, this.config.getCompass_src(), false, 2, null);
            this.compassDrawable2 = loadDrawable$default(this, this.config.getCompass_2_src(), false, 2, null);
            setPosition(this.compassPosition, this.config.getCompass_x(), this.config.getCompass_y());
        }
        if (this.config.showBtnSetting()) {
            this.settingrawable = loadDrawable$default(this, this.config.getBtn_setting_src(), false, 2, null);
            setPosition(this.settingPosition, this.config.getBtn_setting_x(), this.config.getBtn_setting_y());
        }
        if (this.config.showSpecial()) {
            this.specialDrawable = loadDrawable$default(this, this.config.getSpecial_1_src(), false, 2, null);
            setPosition(this.specialPosition, this.config.getSpecial_x(), this.config.getSpecial_y());
        }
        if (this.config.compassShowDetailDegree()) {
            this.compassConfig = new CompassConfig(this);
        }
        if (this.config.showConnectAnimation()) {
            this.conectDrawables = new ArrayList();
            if (this.config.isFromAssets()) {
                list2 = this.context.getAssets().list(this.config.getPath() + "/res/connect");
            } else {
                list2 = new File(this.config.getPath() + "/res/connect").list();
            }
            if (list2 != null) {
                for (String str3 : list2) {
                    Drawable drawableLoadGifDrawable2 = loadGifDrawable("res/connect/" + str3);
                    if (drawableLoadGifDrawable2 != null) {
                        List<Drawable> list3 = this.conectDrawables;
                        Intrinsics.checkNotNull(list3);
                        list3.add(drawableLoadGifDrawable2);
                        Unit unit13 = Unit.INSTANCE;
                        Unit unit14 = Unit.INSTANCE;
                    }
                }
                Unit unit15 = Unit.INSTANCE;
            }
            setPosition(this.connectPostion, this.config.getConnect_animation_x(), this.config.getConnect_animation_y());
        }
        this.isLoadResFinish = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int load$lambda$1(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    public final float getScaleX() {
        if (this.config.getCoordinate_screen_width() != 0) {
            return this.density;
        }
        return 1.0f;
    }

    public final float getScaleY() {
        if (this.config.getCoordinate_screen_height() != 0) {
            return this.density;
        }
        return 1.0f;
    }

    public final float getAbsoluteScaleX() {
        if (this.config.getCoordinate_screen_width() != 0) {
            return this.mScreenWidth / this.config.getCoordinate_screen_width();
        }
        return 1.0f;
    }

    public final float getAbsoluteScaleY() {
        if (this.config.getCoordinate_screen_width() != 0) {
            return this.mScreenHeight / this.config.getCoordinate_screen_height();
        }
        return 1.0f;
    }

    public final void setPosition(Point position, int x, int y) {
        Intrinsics.checkNotNullParameter(position, "position");
        position.set((int) (x * getAbsoluteScaleX()), (int) (y * getAbsoluteScaleY()));
    }

    public final Drawable loadGifDrawable(String path) {
        if (path != null) {
            try {
                if (this.config.isFromAssets()) {
                    return new GifDrawable(this.context.getAssets(), this.config.getPath() + '/' + path);
                }
                return new GifDrawable(new File(this.config.getPath() + '/' + path));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final AnimationDrawable loadAnimationDrawables(String path) {
        if (path != null) {
            try {
                if (this.config.isFromAssets()) {
                    String[] list = this.context.getAssets().list(this.config.getPath() + '/' + path);
                    if (list != null) {
                        Intrinsics.checkNotNull(list);
                        final ClockConfigFlatter$loadAnimationDrawables$1$1$list$1 clockConfigFlatter$loadAnimationDrawables$1$1$list$1 = new Function2<String, String, Integer>() { // from class: com.dw.launcher.ui.clock.flatter.ClockConfigFlatter$loadAnimationDrawables$1$1$list$1
                            @Override // kotlin.jvm.functions.Function2
                            public final Integer invoke(String str, String str2) {
                                String value;
                                Integer intOrNull;
                                String value2;
                                Integer intOrNull2;
                                Regex regex = new Regex("\\d+");
                                Intrinsics.checkNotNull(str);
                                MatchResult matchResultFind$default = Regex.find$default(regex, str, 0, 2, null);
                                int iIntValue = Integer.MAX_VALUE;
                                int iIntValue2 = (matchResultFind$default == null || (value2 = matchResultFind$default.getValue()) == null || (intOrNull2 = StringsKt.toIntOrNull(value2)) == null) ? Integer.MAX_VALUE : intOrNull2.intValue();
                                Intrinsics.checkNotNull(str2);
                                MatchResult matchResultFind$default2 = Regex.find$default(regex, str2, 0, 2, null);
                                if (matchResultFind$default2 != null && (value = matchResultFind$default2.getValue()) != null && (intOrNull = StringsKt.toIntOrNull(value)) != null) {
                                    iIntValue = intOrNull.intValue();
                                }
                                return Integer.valueOf(Intrinsics.compare(iIntValue2, iIntValue));
                            }
                        };
                        List<String> listSortedWith = ArraysKt.sortedWith(list, new Comparator() { // from class: com.dw.launcher.ui.clock.flatter.ClockConfigFlatter$$ExternalSyntheticLambda1
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                return ClockConfigFlatter.loadAnimationDrawables$lambda$23$lambda$18$lambda$15(clockConfigFlatter$loadAnimationDrawables$1$1$list$1, obj, obj2);
                            }
                        });
                        if (!(!listSortedWith.isEmpty())) {
                            Unit unit = Unit.INSTANCE;
                        } else {
                            AnimationDrawable animationDrawable = new AnimationDrawable();
                            animationDrawable.setOneShot(false);
                            for (String str : listSortedWith) {
                                Timber.INSTANCE.d("loadAnimationDrawables item=" + str + "  path=" + path + ' ', new Object[0]);
                                Drawable drawableLoadDrawable = loadDrawable(this.config.getPath() + '/' + path + '/' + str, false);
                                if (drawableLoadDrawable != null) {
                                    animationDrawable.addFrame(drawableLoadDrawable, this.config.getAction_interval());
                                    drawableLoadDrawable.setCallback(animationDrawable);
                                }
                            }
                            return animationDrawable;
                        }
                    }
                } else {
                    File file = new File(this.config.getPath() + '/' + path);
                    Timber.INSTANCE.d("---loadAnimationDrawables from " + file, new Object[0]);
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles != null) {
                        Intrinsics.checkNotNull(fileArrListFiles);
                        final ClockConfigFlatter$loadAnimationDrawables$1$2$list$1 clockConfigFlatter$loadAnimationDrawables$1$2$list$1 = new Function2<File, File, Integer>() { // from class: com.dw.launcher.ui.clock.flatter.ClockConfigFlatter$loadAnimationDrawables$1$2$list$1
                            @Override // kotlin.jvm.functions.Function2
                            public final Integer invoke(File file2, File file3) {
                                String value;
                                Integer intOrNull;
                                String value2;
                                Integer intOrNull2;
                                Regex regex = new Regex("\\d+");
                                String name = file2.getName();
                                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                                MatchResult matchResultFind$default = Regex.find$default(regex, name, 0, 2, null);
                                int iIntValue = Integer.MAX_VALUE;
                                int iIntValue2 = (matchResultFind$default == null || (value2 = matchResultFind$default.getValue()) == null || (intOrNull2 = StringsKt.toIntOrNull(value2)) == null) ? Integer.MAX_VALUE : intOrNull2.intValue();
                                String name2 = file3.getName();
                                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                                MatchResult matchResultFind$default2 = Regex.find$default(regex, name2, 0, 2, null);
                                if (matchResultFind$default2 != null && (value = matchResultFind$default2.getValue()) != null && (intOrNull = StringsKt.toIntOrNull(value)) != null) {
                                    iIntValue = intOrNull.intValue();
                                }
                                return Integer.valueOf(Intrinsics.compare(iIntValue2, iIntValue));
                            }
                        };
                        List<File> listSortedWith2 = ArraysKt.sortedWith(fileArrListFiles, new Comparator() { // from class: com.dw.launcher.ui.clock.flatter.ClockConfigFlatter$$ExternalSyntheticLambda2
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                return ClockConfigFlatter.loadAnimationDrawables$lambda$23$lambda$22$lambda$19(clockConfigFlatter$loadAnimationDrawables$1$2$list$1, obj, obj2);
                            }
                        });
                        if (!(!listSortedWith2.isEmpty())) {
                            Unit unit2 = Unit.INSTANCE;
                        } else {
                            AnimationDrawable animationDrawable2 = new AnimationDrawable();
                            animationDrawable2.setOneShot(false);
                            for (File file2 : listSortedWith2) {
                                Timber.INSTANCE.d("loadAnimationDrawables item=" + file2 + "  path=" + path + ' ', new Object[0]);
                                Drawable drawableLoadDrawable2 = loadDrawable(String.valueOf(file2), false);
                                if (drawableLoadDrawable2 != null) {
                                    animationDrawable2.addFrame(drawableLoadDrawable2, this.config.getAction_interval());
                                    drawableLoadDrawable2.setCallback(animationDrawable2);
                                }
                            }
                            return animationDrawable2;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int loadAnimationDrawables$lambda$23$lambda$18$lambda$15(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int loadAnimationDrawables$lambda$23$lambda$22$lambda$19(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    public static /* synthetic */ Drawable loadDrawable$default(ClockConfigFlatter clockConfigFlatter, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return clockConfigFlatter.loadDrawable(str, z);
    }

    public final Drawable loadDrawable(String path, boolean relativeDir) {
        FileInputStream fileInputStream;
        List<String> list;
        InputStream inputStreamOpen;
        List<String> list2;
        if (path != null) {
            try {
                if (this.config.isFromAssets()) {
                    String[] list3 = this.context.getAssets().list(String.valueOf(this.config.getPath()));
                    if (relativeDir) {
                        if (list3 != null) {
                            Intrinsics.checkNotNull(list3);
                            list2 = ArraysKt.toList(list3);
                        } else {
                            list2 = null;
                        }
                        inputStreamOpen = this.context.getAssets().open(getAssertRealPath(path, list2));
                    } else {
                        inputStreamOpen = this.context.getAssets().open(path);
                    }
                    return BitmapDrawable.createFromStream(inputStreamOpen, null);
                }
                if (relativeDir) {
                    String[] list4 = new File(String.valueOf(this.config.getPath())).list();
                    if (list4 != null) {
                        Intrinsics.checkNotNull(list4);
                        list = ArraysKt.toList(list4);
                    } else {
                        list = null;
                    }
                    fileInputStream = new FileInputStream(getFileRealPath(path, list));
                } else {
                    fileInputStream = new FileInputStream(path);
                }
                return BitmapDrawable.createFromStream(fileInputStream, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final List<Drawable> splitDrawable(String path, int size) {
        List<String> list;
        Bitmap bitmapDecodeStream;
        List<String> list2;
        if (path != null) {
            try {
                if (this.config.isFromAssets()) {
                    String[] list3 = this.context.getAssets().list(String.valueOf(this.config.getPath()));
                    if (list3 != null) {
                        Intrinsics.checkNotNull(list3);
                        list2 = ArraysKt.toList(list3);
                    } else {
                        list2 = null;
                    }
                    bitmapDecodeStream = BitmapFactory.decodeStream(this.context.getAssets().open(getAssertRealPath(path, list2)));
                } else {
                    String[] list4 = new File(String.valueOf(this.config.getPath())).list();
                    if (list4 != null) {
                        Intrinsics.checkNotNull(list4);
                        list = ArraysKt.toList(list4);
                    } else {
                        list = null;
                    }
                    bitmapDecodeStream = BitmapFactory.decodeStream(new FileInputStream(String.valueOf(getFileRealPath(path, list))));
                }
                if (bitmapDecodeStream != null) {
                    Intrinsics.checkNotNull(bitmapDecodeStream);
                    int width = bitmapDecodeStream.getWidth() / size;
                    int height = bitmapDecodeStream.getHeight();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < size; i++) {
                        arrayList.add(new BitmapDrawable(this.context.getResources(), Bitmap.createBitmap(bitmapDecodeStream, i * width, 0, width, height)));
                    }
                    return arrayList;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private final String getAssertRealPath(String path, List<String> files) throws IOException {
        boolean zContains$default = StringsKt.contains$default((CharSequence) SystemUtils.INSTANCE.getLanguage(this.context), (CharSequence) "zh", false, 2, (Object) null);
        String str = this.config.getPath() + '/' + path;
        if (zContains$default || files == null || !files.contains("en")) {
            return str;
        }
        String str2 = this.config.getPath() + "/en/" + path;
        String strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(str2, "/", (String) null, 2, (Object) null);
        String strSubstringAfterLast$default = StringsKt.substringAfterLast$default(str2, "/", (String) null, 2, (Object) null);
        String[] list = this.context.getAssets().list(strSubstringBeforeLast$default);
        if (list == null) {
            return str;
        }
        Intrinsics.checkNotNull(list);
        if (!(!(list.length == 0))) {
            return str;
        }
        Intrinsics.checkNotNull(list);
        return ArraysKt.contains(list, strSubstringAfterLast$default) ? str2 : str;
    }

    private final String getFileRealPath(String path, List<String> files) {
        boolean zContains$default = StringsKt.contains$default((CharSequence) SystemUtils.INSTANCE.getLanguage(this.context), (CharSequence) "zh", false, 2, (Object) null);
        String str = this.config.getPath() + '/' + path;
        if (zContains$default || files == null || !files.contains("en")) {
            return str;
        }
        String str2 = this.config.getPath() + "/en/" + path;
        String strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(str2, "/", (String) null, 2, (Object) null);
        String strSubstringAfterLast$default = StringsKt.substringAfterLast$default(str2, "/", (String) null, 2, (Object) null);
        File file = new File(strSubstringBeforeLast$default);
        File file2 = new File(file, strSubstringAfterLast$default);
        return (file.exists() && file.isDirectory() && file2.exists() && file2.isFile()) ? str2 : str;
    }

    static /* synthetic */ LottieDrawable loadlottieDrawable$default(ClockConfigFlatter clockConfigFlatter, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return clockConfigFlatter.loadlottieDrawable(str, z);
    }

    private final LottieDrawable loadlottieDrawable(String path, boolean relativeDir) throws IOException {
        FileInputStream fileInputStream;
        FileInputStream fileInputStreamOpen;
        List<String> list;
        List<String> list2;
        if (path != null) {
            if (this.config.isFromAssets()) {
                String[] list3 = this.context.getAssets().list(String.valueOf(this.config.getPath()));
                if (relativeDir) {
                    if (list3 != null) {
                        Intrinsics.checkNotNull(list3);
                        list2 = ArraysKt.toList(list3);
                    } else {
                        list2 = null;
                    }
                    fileInputStreamOpen = this.context.getAssets().open(getAssertRealPath(path, list2));
                } else {
                    fileInputStreamOpen = this.context.getAssets().open(path);
                }
            } else {
                if (relativeDir) {
                    String[] list4 = new File(String.valueOf(this.config.getPath())).list();
                    if (list4 != null) {
                        Intrinsics.checkNotNull(list4);
                        list = ArraysKt.toList(list4);
                    } else {
                        list = null;
                    }
                    fileInputStream = new FileInputStream(getFileRealPath(path, list));
                } else {
                    fileInputStream = new FileInputStream(path);
                }
                fileInputStreamOpen = fileInputStream;
            }
            LottieResult lottieResultFromJsonInputStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(fileInputStreamOpen, this.config.getPath() + '/' + path);
            if (lottieResultFromJsonInputStreamSync != null) {
                LottieDrawable lottieDrawable = new LottieDrawable();
                lottieDrawable.setComposition((LottieComposition) lottieResultFromJsonInputStreamSync.getValue());
                return lottieDrawable;
            }
        }
        return null;
    }
}
