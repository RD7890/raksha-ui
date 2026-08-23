package com.dw.launcher.data.entity;

import cn.carbswang.android.numberpickerview.library.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LaunchConfig.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0003\b¼\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001:\u001c¨\u0003©\u0003ª\u0003«\u0003¬\u0003\u00ad\u0003®\u0003¯\u0003°\u0003±\u0003²\u0003³\u0003´\u0003µ\u0003BÏ\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001c\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001c\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001c\u0012\u0006\u0010'\u001a\u00020\u0005\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0005\u0012\u0006\u0010*\u001a\u00020\u0005\u0012\u0006\u0010+\u001a\u00020\u0005\u0012\u0006\u0010,\u001a\u00020\u0005\u0012\u0006\u0010-\u001a\u00020\u0005\u0012\u0006\u0010.\u001a\u00020\u0005\u0012\u0006\u0010/\u001a\u00020\u0005\u0012\u0006\u00100\u001a\u00020\u0005\u0012\u0006\u00101\u001a\u00020\u0005\u0012\u0006\u00102\u001a\u00020\u0005\u0012\u0006\u00103\u001a\u00020\u0005\u0012\u0006\u00104\u001a\u00020\u0005\u0012\u0006\u00105\u001a\u00020\u0005\u0012\u0006\u00106\u001a\u00020\u0005\u0012\u0006\u00107\u001a\u00020\u0003\u0012\u0006\u00108\u001a\u00020\u0005\u0012\u0006\u00109\u001a\u00020\u0005\u0012\u0006\u0010:\u001a\u00020\u0003\u0012\u0006\u0010;\u001a\u00020\u0005\u0012\u0006\u0010<\u001a\u00020\u0005\u0012\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u001c\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u001c\u0012\u0006\u0010A\u001a\u00020\u0005\u0012\u0006\u0010B\u001a\u00020\u0005\u0012\u0006\u0010C\u001a\u00020\u0005\u0012\u0006\u0010D\u001a\u00020\u0003\u0012\u0006\u0010E\u001a\u00020\u0005\u0012\u0006\u0010F\u001a\u00020\u0005\u0012\u0006\u0010G\u001a\u00020\u0003\u0012\u0006\u0010H\u001a\u00020\u0005\u0012\u0006\u0010I\u001a\u00020\u0005\u0012\u0006\u0010J\u001a\u00020\u0003\u0012\u0006\u0010K\u001a\u00020\u0005\u0012\u0006\u0010L\u001a\u00020\u0005\u0012\u0006\u0010M\u001a\u00020\u0005\u0012\u0006\u0010N\u001a\u00020\u0005\u0012\u0006\u0010O\u001a\u00020\u0003\u0012\u0006\u0010P\u001a\u00020\u0003\u0012\u0006\u0010Q\u001a\u00020\u0003\u0012\u0006\u0010R\u001a\u00020\u0003\u0012\u0006\u0010S\u001a\u00020\u0003\u0012\u0006\u0010T\u001a\u00020\u0003\u0012\f\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u001c\u0012\f\u0010W\u001a\b\u0012\u0004\u0012\u00020X0\u001c\u0012\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0\u001c\u0012\u0006\u0010[\u001a\u00020\u0003\u0012\u0006\u0010\\\u001a\u00020\u0003\u0012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020^0\u001c\u0012\u0006\u0010_\u001a\u00020\u0003\u0012\u0006\u0010`\u001a\u00020\u0003\u0012\u0006\u0010a\u001a\u00020\u0003\u0012\u0006\u0010b\u001a\u00020\u0005\u0012\f\u0010c\u001a\b\u0012\u0004\u0012\u00020d0\u001c\u0012\b\u0010e\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u001c\u0012\u0006\u0010h\u001a\u00020\u0003\u0012\u0006\u0010i\u001a\u00020\u0003\u0012\u0006\u0010j\u001a\u00020\u0003\u0012\u0006\u0010k\u001a\u00020\u0003\u0012\u0006\u0010l\u001a\u00020\u0003\u0012\u0006\u0010m\u001a\u00020\u0003\u0012\u0006\u0010n\u001a\u00020\u0003\u0012\u0006\u0010o\u001a\u00020\u0003\u0012\u0006\u0010p\u001a\u00020\u0003\u0012\u0006\u0010q\u001a\u00020\u0005\u0012\u0006\u0010r\u001a\u00020\u0003¢\u0006\u0002\u0010sJ\n\u0010Á\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010Â\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010Ã\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Ä\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Å\u0002\u001a\u00020\u0011HÆ\u0003J\n\u0010Æ\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Ç\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010È\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010É\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Ê\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Ë\u0002\u001a\u00020\u0018HÆ\u0003J\n\u0010Ì\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Í\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Î\u0002\u001a\u00020\u0005HÆ\u0003J\u0010\u0010Ï\u0002\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cHÆ\u0003J\u0010\u0010Ð\u0002\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001cHÆ\u0003J\n\u0010Ñ\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Ò\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Ó\u0002\u001a\u00020\u0005HÆ\u0003J\u0010\u0010Ô\u0002\u001a\b\u0012\u0004\u0012\u00020$0\u001cHÆ\u0003J\u0010\u0010Õ\u0002\u001a\b\u0012\u0004\u0012\u00020&0\u001cHÆ\u0003J\n\u0010Ö\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010×\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Ø\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010Ù\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Ú\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Û\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Ü\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Ý\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Þ\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ß\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010à\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010á\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010â\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ã\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ä\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010å\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010æ\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ç\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010è\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010é\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ê\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ë\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010ì\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010í\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010î\u0002\u001a\u00020\u0005HÆ\u0003J\u0010\u0010ï\u0002\u001a\b\u0012\u0004\u0012\u00020>0\u001cHÆ\u0003J\u0010\u0010ð\u0002\u001a\b\u0012\u0004\u0012\u00020@0\u001cHÆ\u0003J\n\u0010ñ\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ò\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ó\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ô\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010õ\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ö\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010÷\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010ø\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ù\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ú\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010û\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010ü\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ý\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010þ\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ÿ\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0080\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0081\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0082\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0083\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0084\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0085\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0086\u0003\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0087\u0003\u001a\b\u0012\u0004\u0012\u00020V0\u001cHÆ\u0003J\u0010\u0010\u0088\u0003\u001a\b\u0012\u0004\u0012\u00020X0\u001cHÆ\u0003J\u0010\u0010\u0089\u0003\u001a\b\u0012\u0004\u0012\u00020Z0\u001cHÆ\u0003J\n\u0010\u008a\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008b\u0003\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u008c\u0003\u001a\b\u0012\u0004\u0012\u00020^0\u001cHÆ\u0003J\n\u0010\u008d\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008e\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008f\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0090\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0091\u0003\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0092\u0003\u001a\b\u0012\u0004\u0012\u00020d0\u001cHÆ\u0003J\u0012\u0010\u0093\u0003\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0003\u0010\u0085\u0001J\u0010\u0010\u0094\u0003\u001a\b\u0012\u0004\u0012\u00020g0\u001cHÆ\u0003J\n\u0010\u0095\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0096\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0097\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0098\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0099\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u009a\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009b\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009c\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009d\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009e\u0003\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009f\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010 \u0003\u001a\u00020\u0003HÆ\u0003J\u009a\b\u0010¡\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001c2\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001c2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001c2\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u00052\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u00052\b\b\u0002\u00105\u001a\u00020\u00052\b\b\u0002\u00106\u001a\u00020\u00052\b\b\u0002\u00107\u001a\u00020\u00032\b\b\u0002\u00108\u001a\u00020\u00052\b\b\u0002\u00109\u001a\u00020\u00052\b\b\u0002\u0010:\u001a\u00020\u00032\b\b\u0002\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\u00052\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u001c2\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u001c2\b\b\u0002\u0010A\u001a\u00020\u00052\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010C\u001a\u00020\u00052\b\b\u0002\u0010D\u001a\u00020\u00032\b\b\u0002\u0010E\u001a\u00020\u00052\b\b\u0002\u0010F\u001a\u00020\u00052\b\b\u0002\u0010G\u001a\u00020\u00032\b\b\u0002\u0010H\u001a\u00020\u00052\b\b\u0002\u0010I\u001a\u00020\u00052\b\b\u0002\u0010J\u001a\u00020\u00032\b\b\u0002\u0010K\u001a\u00020\u00052\b\b\u0002\u0010L\u001a\u00020\u00052\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010O\u001a\u00020\u00032\b\b\u0002\u0010P\u001a\u00020\u00032\b\b\u0002\u0010Q\u001a\u00020\u00032\b\b\u0002\u0010R\u001a\u00020\u00032\b\b\u0002\u0010S\u001a\u00020\u00032\b\b\u0002\u0010T\u001a\u00020\u00032\u000e\b\u0002\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u001c2\u000e\b\u0002\u0010W\u001a\b\u0012\u0004\u0012\u00020X0\u001c2\u000e\b\u0002\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0\u001c2\b\b\u0002\u0010[\u001a\u00020\u00032\b\b\u0002\u0010\\\u001a\u00020\u00032\u000e\b\u0002\u0010]\u001a\b\u0012\u0004\u0012\u00020^0\u001c2\b\b\u0002\u0010_\u001a\u00020\u00032\b\b\u0002\u0010`\u001a\u00020\u00032\b\b\u0002\u0010a\u001a\u00020\u00032\b\b\u0002\u0010b\u001a\u00020\u00052\u000e\b\u0002\u0010c\u001a\b\u0012\u0004\u0012\u00020d0\u001c2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u001c2\b\b\u0002\u0010h\u001a\u00020\u00032\b\b\u0002\u0010i\u001a\u00020\u00032\b\b\u0002\u0010j\u001a\u00020\u00032\b\b\u0002\u0010k\u001a\u00020\u00032\b\b\u0002\u0010l\u001a\u00020\u00032\b\b\u0002\u0010m\u001a\u00020\u00032\b\b\u0002\u0010n\u001a\u00020\u00032\b\b\u0002\u0010o\u001a\u00020\u00032\b\b\u0002\u0010p\u001a\u00020\u00032\b\b\u0002\u0010q\u001a\u00020\u00052\b\b\u0002\u0010r\u001a\u00020\u0003HÆ\u0001¢\u0006\u0003\u0010¢\u0003J\u0016\u0010£\u0003\u001a\u00030¤\u00032\t\u0010¥\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010¦\u0003\u001a\u00020\u0003HÖ\u0001J\n\u0010§\u0003\u001a\u00020\u0005HÖ\u0001R\u001a\u0010h\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001a\u0010p\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010u\"\u0004\by\u0010wR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010u\"\u0004\b{\u0010wR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u001c\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010}\"\u0005\b\u0081\u0001\u0010\u007fR\u001c\u0010N\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010}\"\u0005\b\u0083\u0001\u0010\u007fR#\u0010e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010}\"\u0005\b\u008a\u0001\u0010\u007fR\u001c\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010}\"\u0005\b\u008c\u0001\u0010\u007fR\u001c\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010u\"\u0005\b\u008e\u0001\u0010wR\u001c\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010}\"\u0005\b\u0090\u0001\u0010\u007fR\u001c\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010}\"\u0005\b\u0092\u0001\u0010\u007fR\u001c\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010u\"\u0005\b\u0094\u0001\u0010wR\u001c\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010}\"\u0005\b\u0096\u0001\u0010\u007fR\u001c\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010}\"\u0005\b\u0098\u0001\u0010\u007fR\u001c\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010}\"\u0005\b\u009a\u0001\u0010\u007fR\u001c\u0010o\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010u\"\u0005\b\u009c\u0001\u0010wR\u001c\u0010l\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010u\"\u0005\b\u009e\u0001\u0010wR$\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u001cX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R$\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0\u001cX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0001\u0010 \u0001\"\u0006\b¤\u0001\u0010¢\u0001R\u001e\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R\u001c\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010}\"\u0005\bª\u0001\u0010\u007fR\u001c\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010}\"\u0005\b¬\u0001\u0010\u007fR\u001c\u0010j\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0001\u0010u\"\u0005\b®\u0001\u0010wR\u001c\u0010k\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010u\"\u0005\b°\u0001\u0010wR\u001c\u0010i\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010u\"\u0005\b²\u0001\u0010wR\u001c\u0010Q\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b³\u0001\u0010u\"\u0005\b´\u0001\u0010wR\u001c\u0010n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010u\"\u0005\b¶\u0001\u0010wR\u001c\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010u\"\u0005\b¸\u0001\u0010wR\u001c\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0001\u0010}\"\u0005\bº\u0001\u0010\u007fR\u001c\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b»\u0001\u0010}\"\u0005\b¼\u0001\u0010\u007fR\u001e\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R\u001c\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÁ\u0001\u0010}\"\u0005\bÂ\u0001\u0010\u007fR\u001c\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010}\"\u0005\bÄ\u0001\u0010\u007fR\u001c\u0010[\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÅ\u0001\u0010u\"\u0005\bÆ\u0001\u0010wR\u001c\u0010\\\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÇ\u0001\u0010u\"\u0005\bÈ\u0001\u0010wR$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÉ\u0001\u0010 \u0001\"\u0006\bÊ\u0001\u0010¢\u0001R$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001cX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bË\u0001\u0010 \u0001\"\u0006\bÌ\u0001\u0010¢\u0001R\u001c\u0010 \u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÍ\u0001\u0010}\"\u0005\bÎ\u0001\u0010\u007fR\u001c\u0010!\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÏ\u0001\u0010}\"\u0005\bÐ\u0001\u0010\u007fR\u001c\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0001\u0010}\"\u0005\bÒ\u0001\u0010\u007fR\u001c\u0010_\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÓ\u0001\u0010u\"\u0005\bÔ\u0001\u0010wR\u001c\u0010`\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÕ\u0001\u0010u\"\u0005\bÖ\u0001\u0010wR$\u0010c\u001a\b\u0012\u0004\u0012\u00020d0\u001cX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b×\u0001\u0010 \u0001\"\u0006\bØ\u0001\u0010¢\u0001R\u001c\u0010b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÙ\u0001\u0010}\"\u0005\bÚ\u0001\u0010\u007fR\u001c\u0010a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÛ\u0001\u0010u\"\u0005\bÜ\u0001\u0010wR$\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001cX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÝ\u0001\u0010 \u0001\"\u0006\bÞ\u0001\u0010¢\u0001R$\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001cX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bß\u0001\u0010 \u0001\"\u0006\bà\u0001\u0010¢\u0001R\u001c\u0010'\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bá\u0001\u0010}\"\u0005\bâ\u0001\u0010\u007fR\u001c\u0010(\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bã\u0001\u0010u\"\u0005\bä\u0001\u0010wR\u001c\u0010)\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bå\u0001\u0010}\"\u0005\bæ\u0001\u0010\u007fR\u001c\u0010*\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bç\u0001\u0010}\"\u0005\bè\u0001\u0010\u007fR\u001c\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bé\u0001\u0010}\"\u0005\bê\u0001\u0010\u007fR\u001c\u0010,\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bë\u0001\u0010}\"\u0005\bì\u0001\u0010\u007fR\u001c\u0010-\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bí\u0001\u0010}\"\u0005\bî\u0001\u0010\u007fR\u001c\u0010.\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bï\u0001\u0010}\"\u0005\bð\u0001\u0010\u007fR\u001c\u0010/\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bñ\u0001\u0010}\"\u0005\bò\u0001\u0010\u007fR\u001c\u00100\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bó\u0001\u0010}\"\u0005\bô\u0001\u0010\u007fR\u001c\u00101\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bõ\u0001\u0010}\"\u0005\bö\u0001\u0010\u007fR\u001c\u00102\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b÷\u0001\u0010}\"\u0005\bø\u0001\u0010\u007fR\u001c\u00103\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bù\u0001\u0010}\"\u0005\bú\u0001\u0010\u007fR\u001c\u00104\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bû\u0001\u0010}\"\u0005\bü\u0001\u0010\u007fR\u001c\u00105\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bý\u0001\u0010}\"\u0005\bþ\u0001\u0010\u007fR\u001c\u00106\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÿ\u0001\u0010}\"\u0005\b\u0080\u0002\u0010\u007fR$\u0010W\u001a\b\u0012\u0004\u0012\u00020X0\u001cX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0081\u0002\u0010 \u0001\"\u0006\b\u0082\u0002\u0010¢\u0001R$\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u001cX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0083\u0002\u0010 \u0001\"\u0006\b\u0084\u0002\u0010¢\u0001R\u001c\u0010L\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0002\u0010}\"\u0005\b\u0086\u0002\u0010\u007fR\u001c\u0010K\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0002\u0010}\"\u0005\b\u0088\u0002\u0010\u007fR\u001c\u0010T\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0002\u0010u\"\u0005\b\u008a\u0002\u0010wR\u001c\u0010S\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0002\u0010u\"\u0005\b\u008c\u0002\u0010wR\u001c\u0010O\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0002\u0010u\"\u0005\b\u008e\u0002\u0010wR\u001c\u0010m\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0002\u0010u\"\u0005\b\u0090\u0002\u0010wR\u001c\u0010P\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0002\u0010u\"\u0005\b\u0092\u0002\u0010wR\u001c\u0010q\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0002\u0010}\"\u0005\b\u0094\u0002\u0010\u007fR\u001c\u0010G\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0002\u0010u\"\u0005\b\u0096\u0002\u0010wR\u001c\u0010I\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0002\u0010}\"\u0005\b\u0098\u0002\u0010\u007fR\u001c\u0010H\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0002\u0010}\"\u0005\b\u009a\u0002\u0010\u007fR$\u0010]\u001a\b\u0012\u0004\u0012\u00020^0\u001cX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009b\u0002\u0010 \u0001\"\u0006\b\u009c\u0002\u0010¢\u0001R\u001c\u00107\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0002\u0010u\"\u0005\b\u009e\u0002\u0010wR\u001c\u00108\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0002\u0010}\"\u0005\b \u0002\u0010\u007fR\u001c\u00109\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0002\u0010}\"\u0005\b¢\u0002\u0010\u007fR\u001c\u0010:\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0002\u0010u\"\u0005\b¤\u0002\u0010wR\u001c\u0010;\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0002\u0010}\"\u0005\b¦\u0002\u0010\u007fR\u001c\u0010<\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0002\u0010}\"\u0005\b¨\u0002\u0010\u007fR$\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u001cX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0002\u0010 \u0001\"\u0006\bª\u0002\u0010¢\u0001R$\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u001cX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b«\u0002\u0010 \u0001\"\u0006\b¬\u0002\u0010¢\u0001R\u001c\u0010A\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0002\u0010}\"\u0005\b®\u0002\u0010\u007fR\u001c\u0010B\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0002\u0010}\"\u0005\b°\u0002\u0010\u007fR\u001c\u0010C\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0002\u0010}\"\u0005\b²\u0002\u0010\u007fR\u001c\u0010r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b³\u0002\u0010u\"\u0005\b´\u0002\u0010wR\u001c\u0010R\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0002\u0010u\"\u0005\b¶\u0002\u0010wR\u001c\u0010J\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0002\u0010u\"\u0005\b¸\u0002\u0010wR\u001c\u0010M\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0002\u0010}\"\u0005\bº\u0002\u0010\u007fR\u001c\u0010D\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b»\u0002\u0010u\"\u0005\b¼\u0002\u0010wR\u001c\u0010E\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b½\u0002\u0010}\"\u0005\b¾\u0002\u0010\u007fR\u001c\u0010F\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¿\u0002\u0010}\"\u0005\bÀ\u0002\u0010\u007f¨\u0006¶\u0003"}, d2 = {"Lcom/dw/launcher/data/entity/LaunchConfig;", BuildConfig.FLAVOR, "appSupervisionType", BuildConfig.FLAVOR, "appSupervisionType_mb", BuildConfig.FLAVOR, "appSupervisionType_sm", "default_clock_id", "defaultDial_mb", "defaultDial_sm", "defaultStyle", "defaultStyle_mb", "defaultStyle_sm", "defaultTheme", "defaultTheme_mb", "defaultTheme_sm", "fontSizeInfo", "Lcom/dw/launcher/data/entity/LaunchConfig$FontSizeInfo;", "fontSizeInfo_mb", "fontSizeInfo_sm", "intervalOfEncoderEvent", "intervalOfEncoderEvent_mb", "intervalOfEncoderEvent_sm", "keyChangeStyleInfo", "Lcom/dw/launcher/data/entity/LaunchConfig$KeyChangeStyleInfo;", "keyChangeStyleInfo_mb", "keyChangeStyleInfo_sm", "menuAppInfo", BuildConfig.FLAVOR, "Lcom/dw/launcher/data/entity/LaunchConfig$MenuAppInfo;", "menuAppInfo_mb", "Lcom/dw/launcher/data/entity/LaunchConfig$MenuAppInfoMb;", "menuAppInfo_sm1", "menuAppInfo_sm2", "menuAppInfo_sm3", "menuStyleInfo", "Lcom/dw/launcher/data/entity/LaunchConfig$MenuStyleInfo;", "menuStyleInfo_mb", "Lcom/dw/launcher/data/entity/LaunchConfig$MenuStyleInfoMb;", "menuStyleInfo_sm", "notInstallAppDeal", "notInstallAppDeal_mb", "notInstallAppDeal_sm", "openEncoderSound", "openEncoderSound_mb", "openEncoderSound_sm", "openEncoderVibrator", "openEncoderVibrator_mb", "openEncoderVibrator_sm", "openFixedChangeActionValue", "openFixedChangeActionValue_mb", "openFixedChangeActionValue_sm", "openProgressBar", "openProgressBar_mb", "openProgressBar_sm", "timeToHideProgressBar", "timeToHideProgressBar_mb", "timeToHideProgressBar_sm", "timeToToggleDialByEncoder", "timeToToggleDialByEncoder_mb", "timeToToggleDialByEncoder_sm", "toolAppInfo", "Lcom/dw/launcher/data/entity/LaunchConfig$ToolAppInfo;", "toolAppInfo_mb", "Lcom/dw/launcher/data/entity/LaunchConfig$ToolAppInfoMb;", "toolAppInfo_sm1", "toolAppInfo_sm2", "toolAppInfo_sm3", "valueOfEncoderEvent", "valueOfEncoderEvent_mb", "valueOfEncoderEvent_sm", "systemBar", "systemBar_sm", "systemBar_mb", "userHandleStatusBarSet", "statusBarSet_packageName", "statusBarSet_className", "userHandleStatusBarSet_sm", "chargeRingPath", "support_compass", "support_heart", "honeycomb_Dial_Reset", "use_handle_statusbar_margin", "statusbar_margin_start", "statusbar_margin_end", "filterAppList", "Lcom/dw/launcher/data/entity/LaunchConfig$FilterAppInfo;", "orderAppList", "Lcom/dw/launcher/data/entity/LaunchConfig$OrderAppInfo;", "filterWatchInfoList", "Lcom/dw/launcher/data/entity/LaunchConfig$WatchInfo;", "keyEncoderType", "launcherthemeType", "themeCardInfoList", "Lcom/dw/launcher/data/entity/LaunchConfig$ThemeCardInfo;", "menuSlideAppCount", "menuSlideAppDynastic", "menuSlide_bg_custom", "menuSlide_bg_color", "menuSlideAppList", "Lcom/dw/launcher/data/entity/LaunchConfig$SlideMenuApp;", "charge_animal_show", "statusBarFunctionList", "Lcom/dw/launcher/data/entity/LaunchConfig$StatusBarFunctionList;", "allowMoveUpTask", "hidedDialLock", "halfboard_style_alpha_fixed", "halfboard_style_scroll_alignment", "encoder_specialscroll", "support_delete_internal_dial", "honeycomb_has_foot_view", "disable_slide_menu", "allowSwipeRight", "swipe_right_app_package_className", "use_auto_tts_service", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/dw/launcher/data/entity/LaunchConfig$FontSizeInfo;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/dw/launcher/data/entity/LaunchConfig$KeyChangeStyleInfo;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIILjava/util/List;Ljava/util/List;Ljava/util/List;IILjava/util/List;IIILjava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;IIIIIIIIILjava/lang/String;I)V", "getAllowMoveUpTask", "()I", "setAllowMoveUpTask", "(I)V", "getAllowSwipeRight", "setAllowSwipeRight", "getAppSupervisionType", "setAppSupervisionType", "getAppSupervisionType_mb", "()Ljava/lang/String;", "setAppSupervisionType_mb", "(Ljava/lang/String;)V", "getAppSupervisionType_sm", "setAppSupervisionType_sm", "getChargeRingPath", "setChargeRingPath", "getCharge_animal_show", "()Ljava/lang/Integer;", "setCharge_animal_show", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDefaultDial_mb", "setDefaultDial_mb", "getDefaultDial_sm", "setDefaultDial_sm", "getDefaultStyle", "setDefaultStyle", "getDefaultStyle_mb", "setDefaultStyle_mb", "getDefaultStyle_sm", "setDefaultStyle_sm", "getDefaultTheme", "setDefaultTheme", "getDefaultTheme_mb", "setDefaultTheme_mb", "getDefaultTheme_sm", "setDefaultTheme_sm", "getDefault_clock_id", "setDefault_clock_id", "getDisable_slide_menu", "setDisable_slide_menu", "getEncoder_specialscroll", "setEncoder_specialscroll", "getFilterAppList", "()Ljava/util/List;", "setFilterAppList", "(Ljava/util/List;)V", "getFilterWatchInfoList", "setFilterWatchInfoList", "getFontSizeInfo", "()Lcom/dw/launcher/data/entity/LaunchConfig$FontSizeInfo;", "setFontSizeInfo", "(Lcom/dw/launcher/data/entity/LaunchConfig$FontSizeInfo;)V", "getFontSizeInfo_mb", "setFontSizeInfo_mb", "getFontSizeInfo_sm", "setFontSizeInfo_sm", "getHalfboard_style_alpha_fixed", "setHalfboard_style_alpha_fixed", "getHalfboard_style_scroll_alignment", "setHalfboard_style_scroll_alignment", "getHidedDialLock", "setHidedDialLock", "getHoneycomb_Dial_Reset", "setHoneycomb_Dial_Reset", "getHoneycomb_has_foot_view", "setHoneycomb_has_foot_view", "getIntervalOfEncoderEvent", "setIntervalOfEncoderEvent", "getIntervalOfEncoderEvent_mb", "setIntervalOfEncoderEvent_mb", "getIntervalOfEncoderEvent_sm", "setIntervalOfEncoderEvent_sm", "getKeyChangeStyleInfo", "()Lcom/dw/launcher/data/entity/LaunchConfig$KeyChangeStyleInfo;", "setKeyChangeStyleInfo", "(Lcom/dw/launcher/data/entity/LaunchConfig$KeyChangeStyleInfo;)V", "getKeyChangeStyleInfo_mb", "setKeyChangeStyleInfo_mb", "getKeyChangeStyleInfo_sm", "setKeyChangeStyleInfo_sm", "getKeyEncoderType", "setKeyEncoderType", "getLauncherthemeType", "setLauncherthemeType", "getMenuAppInfo", "setMenuAppInfo", "getMenuAppInfo_mb", "setMenuAppInfo_mb", "getMenuAppInfo_sm1", "setMenuAppInfo_sm1", "getMenuAppInfo_sm2", "setMenuAppInfo_sm2", "getMenuAppInfo_sm3", "setMenuAppInfo_sm3", "getMenuSlideAppCount", "setMenuSlideAppCount", "getMenuSlideAppDynastic", "setMenuSlideAppDynastic", "getMenuSlideAppList", "setMenuSlideAppList", "getMenuSlide_bg_color", "setMenuSlide_bg_color", "getMenuSlide_bg_custom", "setMenuSlide_bg_custom", "getMenuStyleInfo", "setMenuStyleInfo", "getMenuStyleInfo_mb", "setMenuStyleInfo_mb", "getMenuStyleInfo_sm", "setMenuStyleInfo_sm", "getNotInstallAppDeal", "setNotInstallAppDeal", "getNotInstallAppDeal_mb", "setNotInstallAppDeal_mb", "getNotInstallAppDeal_sm", "setNotInstallAppDeal_sm", "getOpenEncoderSound", "setOpenEncoderSound", "getOpenEncoderSound_mb", "setOpenEncoderSound_mb", "getOpenEncoderSound_sm", "setOpenEncoderSound_sm", "getOpenEncoderVibrator", "setOpenEncoderVibrator", "getOpenEncoderVibrator_mb", "setOpenEncoderVibrator_mb", "getOpenEncoderVibrator_sm", "setOpenEncoderVibrator_sm", "getOpenFixedChangeActionValue", "setOpenFixedChangeActionValue", "getOpenFixedChangeActionValue_mb", "setOpenFixedChangeActionValue_mb", "getOpenFixedChangeActionValue_sm", "setOpenFixedChangeActionValue_sm", "getOpenProgressBar", "setOpenProgressBar", "getOpenProgressBar_mb", "setOpenProgressBar_mb", "getOpenProgressBar_sm", "setOpenProgressBar_sm", "getOrderAppList", "setOrderAppList", "getStatusBarFunctionList", "setStatusBarFunctionList", "getStatusBarSet_className", "setStatusBarSet_className", "getStatusBarSet_packageName", "setStatusBarSet_packageName", "getStatusbar_margin_end", "setStatusbar_margin_end", "getStatusbar_margin_start", "setStatusbar_margin_start", "getSupport_compass", "setSupport_compass", "getSupport_delete_internal_dial", "setSupport_delete_internal_dial", "getSupport_heart", "setSupport_heart", "getSwipe_right_app_package_className", "setSwipe_right_app_package_className", "getSystemBar", "setSystemBar", "getSystemBar_mb", "setSystemBar_mb", "getSystemBar_sm", "setSystemBar_sm", "getThemeCardInfoList", "setThemeCardInfoList", "getTimeToHideProgressBar", "setTimeToHideProgressBar", "getTimeToHideProgressBar_mb", "setTimeToHideProgressBar_mb", "getTimeToHideProgressBar_sm", "setTimeToHideProgressBar_sm", "getTimeToToggleDialByEncoder", "setTimeToToggleDialByEncoder", "getTimeToToggleDialByEncoder_mb", "setTimeToToggleDialByEncoder_mb", "getTimeToToggleDialByEncoder_sm", "setTimeToToggleDialByEncoder_sm", "getToolAppInfo", "setToolAppInfo", "getToolAppInfo_mb", "setToolAppInfo_mb", "getToolAppInfo_sm1", "setToolAppInfo_sm1", "getToolAppInfo_sm2", "setToolAppInfo_sm2", "getToolAppInfo_sm3", "setToolAppInfo_sm3", "getUse_auto_tts_service", "setUse_auto_tts_service", "getUse_handle_statusbar_margin", "setUse_handle_statusbar_margin", "getUserHandleStatusBarSet", "setUserHandleStatusBarSet", "getUserHandleStatusBarSet_sm", "setUserHandleStatusBarSet_sm", "getValueOfEncoderEvent", "setValueOfEncoderEvent", "getValueOfEncoderEvent_mb", "setValueOfEncoderEvent_mb", "getValueOfEncoderEvent_sm", "setValueOfEncoderEvent_sm", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component7", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component79", "component8", "component80", "component81", "component82", "component83", "component84", "component85", "component86", "component87", "component88", "component89", "component9", "component90", "component91", "component92", "component93", "component94", "component95", "component96", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/dw/launcher/data/entity/LaunchConfig$FontSizeInfo;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/dw/launcher/data/entity/LaunchConfig$KeyChangeStyleInfo;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIILjava/util/List;Ljava/util/List;Ljava/util/List;IILjava/util/List;IIILjava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;IIIIIIIIILjava/lang/String;I)Lcom/dw/launcher/data/entity/LaunchConfig;", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "FilterAppInfo", "FontSizeInfo", "KeyChangeStyleInfo", "MenuAppInfo", "MenuAppInfoMb", "MenuStyleInfo", "MenuStyleInfoMb", "OrderAppInfo", "SlideMenuApp", "StatusBarFunctionList", "ThemeCardInfo", "ToolAppInfo", "ToolAppInfoMb", "WatchInfo", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class LaunchConfig {
    private int allowMoveUpTask;
    private int allowSwipeRight;
    private int appSupervisionType;
    private String appSupervisionType_mb;
    private String appSupervisionType_sm;
    private String chargeRingPath;
    private Integer charge_animal_show;
    private String defaultDial_mb;
    private String defaultDial_sm;
    private int defaultStyle;
    private String defaultStyle_mb;
    private String defaultStyle_sm;
    private int defaultTheme;
    private String defaultTheme_mb;
    private String defaultTheme_sm;
    private String default_clock_id;
    private int disable_slide_menu;
    private int encoder_specialscroll;
    private List<FilterAppInfo> filterAppList;
    private List<WatchInfo> filterWatchInfoList;
    private FontSizeInfo fontSizeInfo;
    private String fontSizeInfo_mb;
    private String fontSizeInfo_sm;
    private int halfboard_style_alpha_fixed;
    private int halfboard_style_scroll_alignment;
    private int hidedDialLock;
    private int honeycomb_Dial_Reset;
    private int honeycomb_has_foot_view;
    private int intervalOfEncoderEvent;
    private String intervalOfEncoderEvent_mb;
    private String intervalOfEncoderEvent_sm;
    private KeyChangeStyleInfo keyChangeStyleInfo;
    private String keyChangeStyleInfo_mb;
    private String keyChangeStyleInfo_sm;
    private int keyEncoderType;
    private int launcherthemeType;
    private List<MenuAppInfo> menuAppInfo;
    private List<MenuAppInfoMb> menuAppInfo_mb;
    private String menuAppInfo_sm1;
    private String menuAppInfo_sm2;
    private String menuAppInfo_sm3;
    private int menuSlideAppCount;
    private int menuSlideAppDynastic;
    private List<SlideMenuApp> menuSlideAppList;
    private String menuSlide_bg_color;
    private int menuSlide_bg_custom;
    private List<MenuStyleInfo> menuStyleInfo;
    private List<MenuStyleInfoMb> menuStyleInfo_mb;
    private String menuStyleInfo_sm;
    private int notInstallAppDeal;
    private String notInstallAppDeal_mb;
    private String notInstallAppDeal_sm;
    private String openEncoderSound;
    private String openEncoderSound_mb;
    private String openEncoderSound_sm;
    private String openEncoderVibrator;
    private String openEncoderVibrator_mb;
    private String openEncoderVibrator_sm;
    private String openFixedChangeActionValue;
    private String openFixedChangeActionValue_mb;
    private String openFixedChangeActionValue_sm;
    private String openProgressBar;
    private String openProgressBar_mb;
    private String openProgressBar_sm;
    private List<OrderAppInfo> orderAppList;
    private List<StatusBarFunctionList> statusBarFunctionList;
    private String statusBarSet_className;
    private String statusBarSet_packageName;
    private int statusbar_margin_end;
    private int statusbar_margin_start;
    private int support_compass;
    private int support_delete_internal_dial;
    private int support_heart;
    private String swipe_right_app_package_className;
    private int systemBar;
    private String systemBar_mb;
    private String systemBar_sm;
    private List<ThemeCardInfo> themeCardInfoList;
    private int timeToHideProgressBar;
    private String timeToHideProgressBar_mb;
    private String timeToHideProgressBar_sm;
    private int timeToToggleDialByEncoder;
    private String timeToToggleDialByEncoder_mb;
    private String timeToToggleDialByEncoder_sm;
    private List<ToolAppInfo> toolAppInfo;
    private List<ToolAppInfoMb> toolAppInfo_mb;
    private String toolAppInfo_sm1;
    private String toolAppInfo_sm2;
    private String toolAppInfo_sm3;
    private int use_auto_tts_service;
    private int use_handle_statusbar_margin;
    private int userHandleStatusBarSet;
    private String userHandleStatusBarSet_sm;
    private int valueOfEncoderEvent;
    private String valueOfEncoderEvent_mb;
    private String valueOfEncoderEvent_sm;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAppSupervisionType() {
        return this.appSupervisionType;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getDefaultTheme() {
        return this.defaultTheme;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getDefaultTheme_mb() {
        return this.defaultTheme_mb;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getDefaultTheme_sm() {
        return this.defaultTheme_sm;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final FontSizeInfo getFontSizeInfo() {
        return this.fontSizeInfo;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getFontSizeInfo_mb() {
        return this.fontSizeInfo_mb;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getFontSizeInfo_sm() {
        return this.fontSizeInfo_sm;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getIntervalOfEncoderEvent() {
        return this.intervalOfEncoderEvent;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getIntervalOfEncoderEvent_mb() {
        return this.intervalOfEncoderEvent_mb;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getIntervalOfEncoderEvent_sm() {
        return this.intervalOfEncoderEvent_sm;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final KeyChangeStyleInfo getKeyChangeStyleInfo() {
        return this.keyChangeStyleInfo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAppSupervisionType_mb() {
        return this.appSupervisionType_mb;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getKeyChangeStyleInfo_mb() {
        return this.keyChangeStyleInfo_mb;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getKeyChangeStyleInfo_sm() {
        return this.keyChangeStyleInfo_sm;
    }

    public final List<MenuAppInfo> component22() {
        return this.menuAppInfo;
    }

    public final List<MenuAppInfoMb> component23() {
        return this.menuAppInfo_mb;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getMenuAppInfo_sm1() {
        return this.menuAppInfo_sm1;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getMenuAppInfo_sm2() {
        return this.menuAppInfo_sm2;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getMenuAppInfo_sm3() {
        return this.menuAppInfo_sm3;
    }

    public final List<MenuStyleInfo> component27() {
        return this.menuStyleInfo;
    }

    public final List<MenuStyleInfoMb> component28() {
        return this.menuStyleInfo_mb;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final String getMenuStyleInfo_sm() {
        return this.menuStyleInfo_sm;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAppSupervisionType_sm() {
        return this.appSupervisionType_sm;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final int getNotInstallAppDeal() {
        return this.notInstallAppDeal;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getNotInstallAppDeal_mb() {
        return this.notInstallAppDeal_mb;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final String getNotInstallAppDeal_sm() {
        return this.notInstallAppDeal_sm;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final String getOpenEncoderSound() {
        return this.openEncoderSound;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final String getOpenEncoderSound_mb() {
        return this.openEncoderSound_mb;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final String getOpenEncoderSound_sm() {
        return this.openEncoderSound_sm;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final String getOpenEncoderVibrator() {
        return this.openEncoderVibrator;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final String getOpenEncoderVibrator_mb() {
        return this.openEncoderVibrator_mb;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final String getOpenEncoderVibrator_sm() {
        return this.openEncoderVibrator_sm;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final String getOpenFixedChangeActionValue() {
        return this.openFixedChangeActionValue;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDefault_clock_id() {
        return this.default_clock_id;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final String getOpenFixedChangeActionValue_mb() {
        return this.openFixedChangeActionValue_mb;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final String getOpenFixedChangeActionValue_sm() {
        return this.openFixedChangeActionValue_sm;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final String getOpenProgressBar() {
        return this.openProgressBar;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final String getOpenProgressBar_mb() {
        return this.openProgressBar_mb;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final String getOpenProgressBar_sm() {
        return this.openProgressBar_sm;
    }

    /* JADX INFO: renamed from: component45, reason: from getter */
    public final int getTimeToHideProgressBar() {
        return this.timeToHideProgressBar;
    }

    /* JADX INFO: renamed from: component46, reason: from getter */
    public final String getTimeToHideProgressBar_mb() {
        return this.timeToHideProgressBar_mb;
    }

    /* JADX INFO: renamed from: component47, reason: from getter */
    public final String getTimeToHideProgressBar_sm() {
        return this.timeToHideProgressBar_sm;
    }

    /* JADX INFO: renamed from: component48, reason: from getter */
    public final int getTimeToToggleDialByEncoder() {
        return this.timeToToggleDialByEncoder;
    }

    /* JADX INFO: renamed from: component49, reason: from getter */
    public final String getTimeToToggleDialByEncoder_mb() {
        return this.timeToToggleDialByEncoder_mb;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDefaultDial_mb() {
        return this.defaultDial_mb;
    }

    /* JADX INFO: renamed from: component50, reason: from getter */
    public final String getTimeToToggleDialByEncoder_sm() {
        return this.timeToToggleDialByEncoder_sm;
    }

    public final List<ToolAppInfo> component51() {
        return this.toolAppInfo;
    }

    public final List<ToolAppInfoMb> component52() {
        return this.toolAppInfo_mb;
    }

    /* JADX INFO: renamed from: component53, reason: from getter */
    public final String getToolAppInfo_sm1() {
        return this.toolAppInfo_sm1;
    }

    /* JADX INFO: renamed from: component54, reason: from getter */
    public final String getToolAppInfo_sm2() {
        return this.toolAppInfo_sm2;
    }

    /* JADX INFO: renamed from: component55, reason: from getter */
    public final String getToolAppInfo_sm3() {
        return this.toolAppInfo_sm3;
    }

    /* JADX INFO: renamed from: component56, reason: from getter */
    public final int getValueOfEncoderEvent() {
        return this.valueOfEncoderEvent;
    }

    /* JADX INFO: renamed from: component57, reason: from getter */
    public final String getValueOfEncoderEvent_mb() {
        return this.valueOfEncoderEvent_mb;
    }

    /* JADX INFO: renamed from: component58, reason: from getter */
    public final String getValueOfEncoderEvent_sm() {
        return this.valueOfEncoderEvent_sm;
    }

    /* JADX INFO: renamed from: component59, reason: from getter */
    public final int getSystemBar() {
        return this.systemBar;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDefaultDial_sm() {
        return this.defaultDial_sm;
    }

    /* JADX INFO: renamed from: component60, reason: from getter */
    public final String getSystemBar_sm() {
        return this.systemBar_sm;
    }

    /* JADX INFO: renamed from: component61, reason: from getter */
    public final String getSystemBar_mb() {
        return this.systemBar_mb;
    }

    /* JADX INFO: renamed from: component62, reason: from getter */
    public final int getUserHandleStatusBarSet() {
        return this.userHandleStatusBarSet;
    }

    /* JADX INFO: renamed from: component63, reason: from getter */
    public final String getStatusBarSet_packageName() {
        return this.statusBarSet_packageName;
    }

    /* JADX INFO: renamed from: component64, reason: from getter */
    public final String getStatusBarSet_className() {
        return this.statusBarSet_className;
    }

    /* JADX INFO: renamed from: component65, reason: from getter */
    public final String getUserHandleStatusBarSet_sm() {
        return this.userHandleStatusBarSet_sm;
    }

    /* JADX INFO: renamed from: component66, reason: from getter */
    public final String getChargeRingPath() {
        return this.chargeRingPath;
    }

    /* JADX INFO: renamed from: component67, reason: from getter */
    public final int getSupport_compass() {
        return this.support_compass;
    }

    /* JADX INFO: renamed from: component68, reason: from getter */
    public final int getSupport_heart() {
        return this.support_heart;
    }

    /* JADX INFO: renamed from: component69, reason: from getter */
    public final int getHoneycomb_Dial_Reset() {
        return this.honeycomb_Dial_Reset;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getDefaultStyle() {
        return this.defaultStyle;
    }

    /* JADX INFO: renamed from: component70, reason: from getter */
    public final int getUse_handle_statusbar_margin() {
        return this.use_handle_statusbar_margin;
    }

    /* JADX INFO: renamed from: component71, reason: from getter */
    public final int getStatusbar_margin_start() {
        return this.statusbar_margin_start;
    }

    /* JADX INFO: renamed from: component72, reason: from getter */
    public final int getStatusbar_margin_end() {
        return this.statusbar_margin_end;
    }

    public final List<FilterAppInfo> component73() {
        return this.filterAppList;
    }

    public final List<OrderAppInfo> component74() {
        return this.orderAppList;
    }

    public final List<WatchInfo> component75() {
        return this.filterWatchInfoList;
    }

    /* JADX INFO: renamed from: component76, reason: from getter */
    public final int getKeyEncoderType() {
        return this.keyEncoderType;
    }

    /* JADX INFO: renamed from: component77, reason: from getter */
    public final int getLauncherthemeType() {
        return this.launcherthemeType;
    }

    public final List<ThemeCardInfo> component78() {
        return this.themeCardInfoList;
    }

    /* JADX INFO: renamed from: component79, reason: from getter */
    public final int getMenuSlideAppCount() {
        return this.menuSlideAppCount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDefaultStyle_mb() {
        return this.defaultStyle_mb;
    }

    /* JADX INFO: renamed from: component80, reason: from getter */
    public final int getMenuSlideAppDynastic() {
        return this.menuSlideAppDynastic;
    }

    /* JADX INFO: renamed from: component81, reason: from getter */
    public final int getMenuSlide_bg_custom() {
        return this.menuSlide_bg_custom;
    }

    /* JADX INFO: renamed from: component82, reason: from getter */
    public final String getMenuSlide_bg_color() {
        return this.menuSlide_bg_color;
    }

    public final List<SlideMenuApp> component83() {
        return this.menuSlideAppList;
    }

    /* JADX INFO: renamed from: component84, reason: from getter */
    public final Integer getCharge_animal_show() {
        return this.charge_animal_show;
    }

    public final List<StatusBarFunctionList> component85() {
        return this.statusBarFunctionList;
    }

    /* JADX INFO: renamed from: component86, reason: from getter */
    public final int getAllowMoveUpTask() {
        return this.allowMoveUpTask;
    }

    /* JADX INFO: renamed from: component87, reason: from getter */
    public final int getHidedDialLock() {
        return this.hidedDialLock;
    }

    /* JADX INFO: renamed from: component88, reason: from getter */
    public final int getHalfboard_style_alpha_fixed() {
        return this.halfboard_style_alpha_fixed;
    }

    /* JADX INFO: renamed from: component89, reason: from getter */
    public final int getHalfboard_style_scroll_alignment() {
        return this.halfboard_style_scroll_alignment;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDefaultStyle_sm() {
        return this.defaultStyle_sm;
    }

    /* JADX INFO: renamed from: component90, reason: from getter */
    public final int getEncoder_specialscroll() {
        return this.encoder_specialscroll;
    }

    /* JADX INFO: renamed from: component91, reason: from getter */
    public final int getSupport_delete_internal_dial() {
        return this.support_delete_internal_dial;
    }

    /* JADX INFO: renamed from: component92, reason: from getter */
    public final int getHoneycomb_has_foot_view() {
        return this.honeycomb_has_foot_view;
    }

    /* JADX INFO: renamed from: component93, reason: from getter */
    public final int getDisable_slide_menu() {
        return this.disable_slide_menu;
    }

    /* JADX INFO: renamed from: component94, reason: from getter */
    public final int getAllowSwipeRight() {
        return this.allowSwipeRight;
    }

    /* JADX INFO: renamed from: component95, reason: from getter */
    public final String getSwipe_right_app_package_className() {
        return this.swipe_right_app_package_className;
    }

    /* JADX INFO: renamed from: component96, reason: from getter */
    public final int getUse_auto_tts_service() {
        return this.use_auto_tts_service;
    }

    public final LaunchConfig copy(int appSupervisionType, String appSupervisionType_mb, String appSupervisionType_sm, String default_clock_id, String defaultDial_mb, String defaultDial_sm, int defaultStyle, String defaultStyle_mb, String defaultStyle_sm, int defaultTheme, String defaultTheme_mb, String defaultTheme_sm, FontSizeInfo fontSizeInfo, String fontSizeInfo_mb, String fontSizeInfo_sm, int intervalOfEncoderEvent, String intervalOfEncoderEvent_mb, String intervalOfEncoderEvent_sm, KeyChangeStyleInfo keyChangeStyleInfo, String keyChangeStyleInfo_mb, String keyChangeStyleInfo_sm, List<MenuAppInfo> menuAppInfo, List<MenuAppInfoMb> menuAppInfo_mb, String menuAppInfo_sm1, String menuAppInfo_sm2, String menuAppInfo_sm3, List<MenuStyleInfo> menuStyleInfo, List<MenuStyleInfoMb> menuStyleInfo_mb, String menuStyleInfo_sm, int notInstallAppDeal, String notInstallAppDeal_mb, String notInstallAppDeal_sm, String openEncoderSound, String openEncoderSound_mb, String openEncoderSound_sm, String openEncoderVibrator, String openEncoderVibrator_mb, String openEncoderVibrator_sm, String openFixedChangeActionValue, String openFixedChangeActionValue_mb, String openFixedChangeActionValue_sm, String openProgressBar, String openProgressBar_mb, String openProgressBar_sm, int timeToHideProgressBar, String timeToHideProgressBar_mb, String timeToHideProgressBar_sm, int timeToToggleDialByEncoder, String timeToToggleDialByEncoder_mb, String timeToToggleDialByEncoder_sm, List<ToolAppInfo> toolAppInfo, List<ToolAppInfoMb> toolAppInfo_mb, String toolAppInfo_sm1, String toolAppInfo_sm2, String toolAppInfo_sm3, int valueOfEncoderEvent, String valueOfEncoderEvent_mb, String valueOfEncoderEvent_sm, int systemBar, String systemBar_sm, String systemBar_mb, int userHandleStatusBarSet, String statusBarSet_packageName, String statusBarSet_className, String userHandleStatusBarSet_sm, String chargeRingPath, int support_compass, int support_heart, int honeycomb_Dial_Reset, int use_handle_statusbar_margin, int statusbar_margin_start, int statusbar_margin_end, List<FilterAppInfo> filterAppList, List<OrderAppInfo> orderAppList, List<WatchInfo> filterWatchInfoList, int keyEncoderType, int launcherthemeType, List<ThemeCardInfo> themeCardInfoList, int menuSlideAppCount, int menuSlideAppDynastic, int menuSlide_bg_custom, String menuSlide_bg_color, List<SlideMenuApp> menuSlideAppList, Integer charge_animal_show, List<StatusBarFunctionList> statusBarFunctionList, int allowMoveUpTask, int hidedDialLock, int halfboard_style_alpha_fixed, int halfboard_style_scroll_alignment, int encoder_specialscroll, int support_delete_internal_dial, int honeycomb_has_foot_view, int disable_slide_menu, int allowSwipeRight, String swipe_right_app_package_className, int use_auto_tts_service) {
        Intrinsics.checkNotNullParameter(appSupervisionType_mb, "appSupervisionType_mb");
        Intrinsics.checkNotNullParameter(appSupervisionType_sm, "appSupervisionType_sm");
        Intrinsics.checkNotNullParameter(default_clock_id, "default_clock_id");
        Intrinsics.checkNotNullParameter(defaultDial_mb, "defaultDial_mb");
        Intrinsics.checkNotNullParameter(defaultDial_sm, "defaultDial_sm");
        Intrinsics.checkNotNullParameter(defaultStyle_mb, "defaultStyle_mb");
        Intrinsics.checkNotNullParameter(defaultStyle_sm, "defaultStyle_sm");
        Intrinsics.checkNotNullParameter(defaultTheme_mb, "defaultTheme_mb");
        Intrinsics.checkNotNullParameter(defaultTheme_sm, "defaultTheme_sm");
        Intrinsics.checkNotNullParameter(fontSizeInfo, "fontSizeInfo");
        Intrinsics.checkNotNullParameter(fontSizeInfo_mb, "fontSizeInfo_mb");
        Intrinsics.checkNotNullParameter(fontSizeInfo_sm, "fontSizeInfo_sm");
        Intrinsics.checkNotNullParameter(intervalOfEncoderEvent_mb, "intervalOfEncoderEvent_mb");
        Intrinsics.checkNotNullParameter(intervalOfEncoderEvent_sm, "intervalOfEncoderEvent_sm");
        Intrinsics.checkNotNullParameter(keyChangeStyleInfo, "keyChangeStyleInfo");
        Intrinsics.checkNotNullParameter(keyChangeStyleInfo_mb, "keyChangeStyleInfo_mb");
        Intrinsics.checkNotNullParameter(keyChangeStyleInfo_sm, "keyChangeStyleInfo_sm");
        Intrinsics.checkNotNullParameter(menuAppInfo, "menuAppInfo");
        Intrinsics.checkNotNullParameter(menuAppInfo_mb, "menuAppInfo_mb");
        Intrinsics.checkNotNullParameter(menuAppInfo_sm1, "menuAppInfo_sm1");
        Intrinsics.checkNotNullParameter(menuAppInfo_sm2, "menuAppInfo_sm2");
        Intrinsics.checkNotNullParameter(menuAppInfo_sm3, "menuAppInfo_sm3");
        Intrinsics.checkNotNullParameter(menuStyleInfo, "menuStyleInfo");
        Intrinsics.checkNotNullParameter(menuStyleInfo_mb, "menuStyleInfo_mb");
        Intrinsics.checkNotNullParameter(menuStyleInfo_sm, "menuStyleInfo_sm");
        Intrinsics.checkNotNullParameter(notInstallAppDeal_mb, "notInstallAppDeal_mb");
        Intrinsics.checkNotNullParameter(notInstallAppDeal_sm, "notInstallAppDeal_sm");
        Intrinsics.checkNotNullParameter(openEncoderSound, "openEncoderSound");
        Intrinsics.checkNotNullParameter(openEncoderSound_mb, "openEncoderSound_mb");
        Intrinsics.checkNotNullParameter(openEncoderSound_sm, "openEncoderSound_sm");
        Intrinsics.checkNotNullParameter(openEncoderVibrator, "openEncoderVibrator");
        Intrinsics.checkNotNullParameter(openEncoderVibrator_mb, "openEncoderVibrator_mb");
        Intrinsics.checkNotNullParameter(openEncoderVibrator_sm, "openEncoderVibrator_sm");
        Intrinsics.checkNotNullParameter(openFixedChangeActionValue, "openFixedChangeActionValue");
        Intrinsics.checkNotNullParameter(openFixedChangeActionValue_mb, "openFixedChangeActionValue_mb");
        Intrinsics.checkNotNullParameter(openFixedChangeActionValue_sm, "openFixedChangeActionValue_sm");
        Intrinsics.checkNotNullParameter(openProgressBar, "openProgressBar");
        Intrinsics.checkNotNullParameter(openProgressBar_mb, "openProgressBar_mb");
        Intrinsics.checkNotNullParameter(openProgressBar_sm, "openProgressBar_sm");
        Intrinsics.checkNotNullParameter(timeToHideProgressBar_mb, "timeToHideProgressBar_mb");
        Intrinsics.checkNotNullParameter(timeToHideProgressBar_sm, "timeToHideProgressBar_sm");
        Intrinsics.checkNotNullParameter(timeToToggleDialByEncoder_mb, "timeToToggleDialByEncoder_mb");
        Intrinsics.checkNotNullParameter(timeToToggleDialByEncoder_sm, "timeToToggleDialByEncoder_sm");
        Intrinsics.checkNotNullParameter(toolAppInfo, "toolAppInfo");
        Intrinsics.checkNotNullParameter(toolAppInfo_mb, "toolAppInfo_mb");
        Intrinsics.checkNotNullParameter(toolAppInfo_sm1, "toolAppInfo_sm1");
        Intrinsics.checkNotNullParameter(toolAppInfo_sm2, "toolAppInfo_sm2");
        Intrinsics.checkNotNullParameter(toolAppInfo_sm3, "toolAppInfo_sm3");
        Intrinsics.checkNotNullParameter(valueOfEncoderEvent_mb, "valueOfEncoderEvent_mb");
        Intrinsics.checkNotNullParameter(valueOfEncoderEvent_sm, "valueOfEncoderEvent_sm");
        Intrinsics.checkNotNullParameter(systemBar_sm, "systemBar_sm");
        Intrinsics.checkNotNullParameter(systemBar_mb, "systemBar_mb");
        Intrinsics.checkNotNullParameter(statusBarSet_packageName, "statusBarSet_packageName");
        Intrinsics.checkNotNullParameter(statusBarSet_className, "statusBarSet_className");
        Intrinsics.checkNotNullParameter(userHandleStatusBarSet_sm, "userHandleStatusBarSet_sm");
        Intrinsics.checkNotNullParameter(chargeRingPath, "chargeRingPath");
        Intrinsics.checkNotNullParameter(filterAppList, "filterAppList");
        Intrinsics.checkNotNullParameter(orderAppList, "orderAppList");
        Intrinsics.checkNotNullParameter(filterWatchInfoList, "filterWatchInfoList");
        Intrinsics.checkNotNullParameter(themeCardInfoList, "themeCardInfoList");
        Intrinsics.checkNotNullParameter(menuSlide_bg_color, "menuSlide_bg_color");
        Intrinsics.checkNotNullParameter(menuSlideAppList, "menuSlideAppList");
        Intrinsics.checkNotNullParameter(statusBarFunctionList, "statusBarFunctionList");
        Intrinsics.checkNotNullParameter(swipe_right_app_package_className, "swipe_right_app_package_className");
        return new LaunchConfig(appSupervisionType, appSupervisionType_mb, appSupervisionType_sm, default_clock_id, defaultDial_mb, defaultDial_sm, defaultStyle, defaultStyle_mb, defaultStyle_sm, defaultTheme, defaultTheme_mb, defaultTheme_sm, fontSizeInfo, fontSizeInfo_mb, fontSizeInfo_sm, intervalOfEncoderEvent, intervalOfEncoderEvent_mb, intervalOfEncoderEvent_sm, keyChangeStyleInfo, keyChangeStyleInfo_mb, keyChangeStyleInfo_sm, menuAppInfo, menuAppInfo_mb, menuAppInfo_sm1, menuAppInfo_sm2, menuAppInfo_sm3, menuStyleInfo, menuStyleInfo_mb, menuStyleInfo_sm, notInstallAppDeal, notInstallAppDeal_mb, notInstallAppDeal_sm, openEncoderSound, openEncoderSound_mb, openEncoderSound_sm, openEncoderVibrator, openEncoderVibrator_mb, openEncoderVibrator_sm, openFixedChangeActionValue, openFixedChangeActionValue_mb, openFixedChangeActionValue_sm, openProgressBar, openProgressBar_mb, openProgressBar_sm, timeToHideProgressBar, timeToHideProgressBar_mb, timeToHideProgressBar_sm, timeToToggleDialByEncoder, timeToToggleDialByEncoder_mb, timeToToggleDialByEncoder_sm, toolAppInfo, toolAppInfo_mb, toolAppInfo_sm1, toolAppInfo_sm2, toolAppInfo_sm3, valueOfEncoderEvent, valueOfEncoderEvent_mb, valueOfEncoderEvent_sm, systemBar, systemBar_sm, systemBar_mb, userHandleStatusBarSet, statusBarSet_packageName, statusBarSet_className, userHandleStatusBarSet_sm, chargeRingPath, support_compass, support_heart, honeycomb_Dial_Reset, use_handle_statusbar_margin, statusbar_margin_start, statusbar_margin_end, filterAppList, orderAppList, filterWatchInfoList, keyEncoderType, launcherthemeType, themeCardInfoList, menuSlideAppCount, menuSlideAppDynastic, menuSlide_bg_custom, menuSlide_bg_color, menuSlideAppList, charge_animal_show, statusBarFunctionList, allowMoveUpTask, hidedDialLock, halfboard_style_alpha_fixed, halfboard_style_scroll_alignment, encoder_specialscroll, support_delete_internal_dial, honeycomb_has_foot_view, disable_slide_menu, allowSwipeRight, swipe_right_app_package_className, use_auto_tts_service);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LaunchConfig)) {
            return false;
        }
        LaunchConfig launchConfig = (LaunchConfig) other;
        return this.appSupervisionType == launchConfig.appSupervisionType && Intrinsics.areEqual(this.appSupervisionType_mb, launchConfig.appSupervisionType_mb) && Intrinsics.areEqual(this.appSupervisionType_sm, launchConfig.appSupervisionType_sm) && Intrinsics.areEqual(this.default_clock_id, launchConfig.default_clock_id) && Intrinsics.areEqual(this.defaultDial_mb, launchConfig.defaultDial_mb) && Intrinsics.areEqual(this.defaultDial_sm, launchConfig.defaultDial_sm) && this.defaultStyle == launchConfig.defaultStyle && Intrinsics.areEqual(this.defaultStyle_mb, launchConfig.defaultStyle_mb) && Intrinsics.areEqual(this.defaultStyle_sm, launchConfig.defaultStyle_sm) && this.defaultTheme == launchConfig.defaultTheme && Intrinsics.areEqual(this.defaultTheme_mb, launchConfig.defaultTheme_mb) && Intrinsics.areEqual(this.defaultTheme_sm, launchConfig.defaultTheme_sm) && Intrinsics.areEqual(this.fontSizeInfo, launchConfig.fontSizeInfo) && Intrinsics.areEqual(this.fontSizeInfo_mb, launchConfig.fontSizeInfo_mb) && Intrinsics.areEqual(this.fontSizeInfo_sm, launchConfig.fontSizeInfo_sm) && this.intervalOfEncoderEvent == launchConfig.intervalOfEncoderEvent && Intrinsics.areEqual(this.intervalOfEncoderEvent_mb, launchConfig.intervalOfEncoderEvent_mb) && Intrinsics.areEqual(this.intervalOfEncoderEvent_sm, launchConfig.intervalOfEncoderEvent_sm) && Intrinsics.areEqual(this.keyChangeStyleInfo, launchConfig.keyChangeStyleInfo) && Intrinsics.areEqual(this.keyChangeStyleInfo_mb, launchConfig.keyChangeStyleInfo_mb) && Intrinsics.areEqual(this.keyChangeStyleInfo_sm, launchConfig.keyChangeStyleInfo_sm) && Intrinsics.areEqual(this.menuAppInfo, launchConfig.menuAppInfo) && Intrinsics.areEqual(this.menuAppInfo_mb, launchConfig.menuAppInfo_mb) && Intrinsics.areEqual(this.menuAppInfo_sm1, launchConfig.menuAppInfo_sm1) && Intrinsics.areEqual(this.menuAppInfo_sm2, launchConfig.menuAppInfo_sm2) && Intrinsics.areEqual(this.menuAppInfo_sm3, launchConfig.menuAppInfo_sm3) && Intrinsics.areEqual(this.menuStyleInfo, launchConfig.menuStyleInfo) && Intrinsics.areEqual(this.menuStyleInfo_mb, launchConfig.menuStyleInfo_mb) && Intrinsics.areEqual(this.menuStyleInfo_sm, launchConfig.menuStyleInfo_sm) && this.notInstallAppDeal == launchConfig.notInstallAppDeal && Intrinsics.areEqual(this.notInstallAppDeal_mb, launchConfig.notInstallAppDeal_mb) && Intrinsics.areEqual(this.notInstallAppDeal_sm, launchConfig.notInstallAppDeal_sm) && Intrinsics.areEqual(this.openEncoderSound, launchConfig.openEncoderSound) && Intrinsics.areEqual(this.openEncoderSound_mb, launchConfig.openEncoderSound_mb) && Intrinsics.areEqual(this.openEncoderSound_sm, launchConfig.openEncoderSound_sm) && Intrinsics.areEqual(this.openEncoderVibrator, launchConfig.openEncoderVibrator) && Intrinsics.areEqual(this.openEncoderVibrator_mb, launchConfig.openEncoderVibrator_mb) && Intrinsics.areEqual(this.openEncoderVibrator_sm, launchConfig.openEncoderVibrator_sm) && Intrinsics.areEqual(this.openFixedChangeActionValue, launchConfig.openFixedChangeActionValue) && Intrinsics.areEqual(this.openFixedChangeActionValue_mb, launchConfig.openFixedChangeActionValue_mb) && Intrinsics.areEqual(this.openFixedChangeActionValue_sm, launchConfig.openFixedChangeActionValue_sm) && Intrinsics.areEqual(this.openProgressBar, launchConfig.openProgressBar) && Intrinsics.areEqual(this.openProgressBar_mb, launchConfig.openProgressBar_mb) && Intrinsics.areEqual(this.openProgressBar_sm, launchConfig.openProgressBar_sm) && this.timeToHideProgressBar == launchConfig.timeToHideProgressBar && Intrinsics.areEqual(this.timeToHideProgressBar_mb, launchConfig.timeToHideProgressBar_mb) && Intrinsics.areEqual(this.timeToHideProgressBar_sm, launchConfig.timeToHideProgressBar_sm) && this.timeToToggleDialByEncoder == launchConfig.timeToToggleDialByEncoder && Intrinsics.areEqual(this.timeToToggleDialByEncoder_mb, launchConfig.timeToToggleDialByEncoder_mb) && Intrinsics.areEqual(this.timeToToggleDialByEncoder_sm, launchConfig.timeToToggleDialByEncoder_sm) && Intrinsics.areEqual(this.toolAppInfo, launchConfig.toolAppInfo) && Intrinsics.areEqual(this.toolAppInfo_mb, launchConfig.toolAppInfo_mb) && Intrinsics.areEqual(this.toolAppInfo_sm1, launchConfig.toolAppInfo_sm1) && Intrinsics.areEqual(this.toolAppInfo_sm2, launchConfig.toolAppInfo_sm2) && Intrinsics.areEqual(this.toolAppInfo_sm3, launchConfig.toolAppInfo_sm3) && this.valueOfEncoderEvent == launchConfig.valueOfEncoderEvent && Intrinsics.areEqual(this.valueOfEncoderEvent_mb, launchConfig.valueOfEncoderEvent_mb) && Intrinsics.areEqual(this.valueOfEncoderEvent_sm, launchConfig.valueOfEncoderEvent_sm) && this.systemBar == launchConfig.systemBar && Intrinsics.areEqual(this.systemBar_sm, launchConfig.systemBar_sm) && Intrinsics.areEqual(this.systemBar_mb, launchConfig.systemBar_mb) && this.userHandleStatusBarSet == launchConfig.userHandleStatusBarSet && Intrinsics.areEqual(this.statusBarSet_packageName, launchConfig.statusBarSet_packageName) && Intrinsics.areEqual(this.statusBarSet_className, launchConfig.statusBarSet_className) && Intrinsics.areEqual(this.userHandleStatusBarSet_sm, launchConfig.userHandleStatusBarSet_sm) && Intrinsics.areEqual(this.chargeRingPath, launchConfig.chargeRingPath) && this.support_compass == launchConfig.support_compass && this.support_heart == launchConfig.support_heart && this.honeycomb_Dial_Reset == launchConfig.honeycomb_Dial_Reset && this.use_handle_statusbar_margin == launchConfig.use_handle_statusbar_margin && this.statusbar_margin_start == launchConfig.statusbar_margin_start && this.statusbar_margin_end == launchConfig.statusbar_margin_end && Intrinsics.areEqual(this.filterAppList, launchConfig.filterAppList) && Intrinsics.areEqual(this.orderAppList, launchConfig.orderAppList) && Intrinsics.areEqual(this.filterWatchInfoList, launchConfig.filterWatchInfoList) && this.keyEncoderType == launchConfig.keyEncoderType && this.launcherthemeType == launchConfig.launcherthemeType && Intrinsics.areEqual(this.themeCardInfoList, launchConfig.themeCardInfoList) && this.menuSlideAppCount == launchConfig.menuSlideAppCount && this.menuSlideAppDynastic == launchConfig.menuSlideAppDynastic && this.menuSlide_bg_custom == launchConfig.menuSlide_bg_custom && Intrinsics.areEqual(this.menuSlide_bg_color, launchConfig.menuSlide_bg_color) && Intrinsics.areEqual(this.menuSlideAppList, launchConfig.menuSlideAppList) && Intrinsics.areEqual(this.charge_animal_show, launchConfig.charge_animal_show) && Intrinsics.areEqual(this.statusBarFunctionList, launchConfig.statusBarFunctionList) && this.allowMoveUpTask == launchConfig.allowMoveUpTask && this.hidedDialLock == launchConfig.hidedDialLock && this.halfboard_style_alpha_fixed == launchConfig.halfboard_style_alpha_fixed && this.halfboard_style_scroll_alignment == launchConfig.halfboard_style_scroll_alignment && this.encoder_specialscroll == launchConfig.encoder_specialscroll && this.support_delete_internal_dial == launchConfig.support_delete_internal_dial && this.honeycomb_has_foot_view == launchConfig.honeycomb_has_foot_view && this.disable_slide_menu == launchConfig.disable_slide_menu && this.allowSwipeRight == launchConfig.allowSwipeRight && Intrinsics.areEqual(this.swipe_right_app_package_className, launchConfig.swipe_right_app_package_className) && this.use_auto_tts_service == launchConfig.use_auto_tts_service;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((Integer.hashCode(this.appSupervisionType) * 31) + this.appSupervisionType_mb.hashCode()) * 31) + this.appSupervisionType_sm.hashCode()) * 31) + this.default_clock_id.hashCode()) * 31) + this.defaultDial_mb.hashCode()) * 31) + this.defaultDial_sm.hashCode()) * 31) + Integer.hashCode(this.defaultStyle)) * 31) + this.defaultStyle_mb.hashCode()) * 31) + this.defaultStyle_sm.hashCode()) * 31) + Integer.hashCode(this.defaultTheme)) * 31) + this.defaultTheme_mb.hashCode()) * 31) + this.defaultTheme_sm.hashCode()) * 31) + this.fontSizeInfo.hashCode()) * 31) + this.fontSizeInfo_mb.hashCode()) * 31) + this.fontSizeInfo_sm.hashCode()) * 31) + Integer.hashCode(this.intervalOfEncoderEvent)) * 31) + this.intervalOfEncoderEvent_mb.hashCode()) * 31) + this.intervalOfEncoderEvent_sm.hashCode()) * 31) + this.keyChangeStyleInfo.hashCode()) * 31) + this.keyChangeStyleInfo_mb.hashCode()) * 31) + this.keyChangeStyleInfo_sm.hashCode()) * 31) + this.menuAppInfo.hashCode()) * 31) + this.menuAppInfo_mb.hashCode()) * 31) + this.menuAppInfo_sm1.hashCode()) * 31) + this.menuAppInfo_sm2.hashCode()) * 31) + this.menuAppInfo_sm3.hashCode()) * 31) + this.menuStyleInfo.hashCode()) * 31) + this.menuStyleInfo_mb.hashCode()) * 31) + this.menuStyleInfo_sm.hashCode()) * 31) + Integer.hashCode(this.notInstallAppDeal)) * 31) + this.notInstallAppDeal_mb.hashCode()) * 31) + this.notInstallAppDeal_sm.hashCode()) * 31) + this.openEncoderSound.hashCode()) * 31) + this.openEncoderSound_mb.hashCode()) * 31) + this.openEncoderSound_sm.hashCode()) * 31) + this.openEncoderVibrator.hashCode()) * 31) + this.openEncoderVibrator_mb.hashCode()) * 31) + this.openEncoderVibrator_sm.hashCode()) * 31) + this.openFixedChangeActionValue.hashCode()) * 31) + this.openFixedChangeActionValue_mb.hashCode()) * 31) + this.openFixedChangeActionValue_sm.hashCode()) * 31) + this.openProgressBar.hashCode()) * 31) + this.openProgressBar_mb.hashCode()) * 31) + this.openProgressBar_sm.hashCode()) * 31) + Integer.hashCode(this.timeToHideProgressBar)) * 31) + this.timeToHideProgressBar_mb.hashCode()) * 31) + this.timeToHideProgressBar_sm.hashCode()) * 31) + Integer.hashCode(this.timeToToggleDialByEncoder)) * 31) + this.timeToToggleDialByEncoder_mb.hashCode()) * 31) + this.timeToToggleDialByEncoder_sm.hashCode()) * 31) + this.toolAppInfo.hashCode()) * 31) + this.toolAppInfo_mb.hashCode()) * 31) + this.toolAppInfo_sm1.hashCode()) * 31) + this.toolAppInfo_sm2.hashCode()) * 31) + this.toolAppInfo_sm3.hashCode()) * 31) + Integer.hashCode(this.valueOfEncoderEvent)) * 31) + this.valueOfEncoderEvent_mb.hashCode()) * 31) + this.valueOfEncoderEvent_sm.hashCode()) * 31) + Integer.hashCode(this.systemBar)) * 31) + this.systemBar_sm.hashCode()) * 31) + this.systemBar_mb.hashCode()) * 31) + Integer.hashCode(this.userHandleStatusBarSet)) * 31) + this.statusBarSet_packageName.hashCode()) * 31) + this.statusBarSet_className.hashCode()) * 31) + this.userHandleStatusBarSet_sm.hashCode()) * 31) + this.chargeRingPath.hashCode()) * 31) + Integer.hashCode(this.support_compass)) * 31) + Integer.hashCode(this.support_heart)) * 31) + Integer.hashCode(this.honeycomb_Dial_Reset)) * 31) + Integer.hashCode(this.use_handle_statusbar_margin)) * 31) + Integer.hashCode(this.statusbar_margin_start)) * 31) + Integer.hashCode(this.statusbar_margin_end)) * 31) + this.filterAppList.hashCode()) * 31) + this.orderAppList.hashCode()) * 31) + this.filterWatchInfoList.hashCode()) * 31) + Integer.hashCode(this.keyEncoderType)) * 31) + Integer.hashCode(this.launcherthemeType)) * 31) + this.themeCardInfoList.hashCode()) * 31) + Integer.hashCode(this.menuSlideAppCount)) * 31) + Integer.hashCode(this.menuSlideAppDynastic)) * 31) + Integer.hashCode(this.menuSlide_bg_custom)) * 31) + this.menuSlide_bg_color.hashCode()) * 31) + this.menuSlideAppList.hashCode()) * 31;
        Integer num = this.charge_animal_show;
        return ((((((((((((((((((((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.statusBarFunctionList.hashCode()) * 31) + Integer.hashCode(this.allowMoveUpTask)) * 31) + Integer.hashCode(this.hidedDialLock)) * 31) + Integer.hashCode(this.halfboard_style_alpha_fixed)) * 31) + Integer.hashCode(this.halfboard_style_scroll_alignment)) * 31) + Integer.hashCode(this.encoder_specialscroll)) * 31) + Integer.hashCode(this.support_delete_internal_dial)) * 31) + Integer.hashCode(this.honeycomb_has_foot_view)) * 31) + Integer.hashCode(this.disable_slide_menu)) * 31) + Integer.hashCode(this.allowSwipeRight)) * 31) + this.swipe_right_app_package_className.hashCode()) * 31) + Integer.hashCode(this.use_auto_tts_service);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LaunchConfig(appSupervisionType=");
        sb.append(this.appSupervisionType).append(", appSupervisionType_mb=").append(this.appSupervisionType_mb).append(", appSupervisionType_sm=").append(this.appSupervisionType_sm).append(", default_clock_id=").append(this.default_clock_id).append(", defaultDial_mb=").append(this.defaultDial_mb).append(", defaultDial_sm=").append(this.defaultDial_sm).append(", defaultStyle=").append(this.defaultStyle).append(", defaultStyle_mb=").append(this.defaultStyle_mb).append(", defaultStyle_sm=").append(this.defaultStyle_sm).append(", defaultTheme=").append(this.defaultTheme).append(", defaultTheme_mb=").append(this.defaultTheme_mb).append(", defaultTheme_sm=");
        sb.append(this.defaultTheme_sm).append(", fontSizeInfo=").append(this.fontSizeInfo).append(", fontSizeInfo_mb=").append(this.fontSizeInfo_mb).append(", fontSizeInfo_sm=").append(this.fontSizeInfo_sm).append(", intervalOfEncoderEvent=").append(this.intervalOfEncoderEvent).append(", intervalOfEncoderEvent_mb=").append(this.intervalOfEncoderEvent_mb).append(", intervalOfEncoderEvent_sm=").append(this.intervalOfEncoderEvent_sm).append(", keyChangeStyleInfo=").append(this.keyChangeStyleInfo).append(", keyChangeStyleInfo_mb=").append(this.keyChangeStyleInfo_mb).append(", keyChangeStyleInfo_sm=").append(this.keyChangeStyleInfo_sm).append(", menuAppInfo=").append(this.menuAppInfo).append(", menuAppInfo_mb=").append(this.menuAppInfo_mb);
        sb.append(", menuAppInfo_sm1=").append(this.menuAppInfo_sm1).append(", menuAppInfo_sm2=").append(this.menuAppInfo_sm2).append(", menuAppInfo_sm3=").append(this.menuAppInfo_sm3).append(", menuStyleInfo=").append(this.menuStyleInfo).append(", menuStyleInfo_mb=").append(this.menuStyleInfo_mb).append(", menuStyleInfo_sm=").append(this.menuStyleInfo_sm).append(", notInstallAppDeal=").append(this.notInstallAppDeal).append(", notInstallAppDeal_mb=").append(this.notInstallAppDeal_mb).append(", notInstallAppDeal_sm=").append(this.notInstallAppDeal_sm).append(", openEncoderSound=").append(this.openEncoderSound).append(", openEncoderSound_mb=").append(this.openEncoderSound_mb).append(", openEncoderSound_sm=");
        sb.append(this.openEncoderSound_sm).append(", openEncoderVibrator=").append(this.openEncoderVibrator).append(", openEncoderVibrator_mb=").append(this.openEncoderVibrator_mb).append(", openEncoderVibrator_sm=").append(this.openEncoderVibrator_sm).append(", openFixedChangeActionValue=").append(this.openFixedChangeActionValue).append(", openFixedChangeActionValue_mb=").append(this.openFixedChangeActionValue_mb).append(", openFixedChangeActionValue_sm=").append(this.openFixedChangeActionValue_sm).append(", openProgressBar=").append(this.openProgressBar).append(", openProgressBar_mb=").append(this.openProgressBar_mb).append(", openProgressBar_sm=").append(this.openProgressBar_sm).append(", timeToHideProgressBar=").append(this.timeToHideProgressBar).append(", timeToHideProgressBar_mb=").append(this.timeToHideProgressBar_mb);
        sb.append(", timeToHideProgressBar_sm=").append(this.timeToHideProgressBar_sm).append(", timeToToggleDialByEncoder=").append(this.timeToToggleDialByEncoder).append(", timeToToggleDialByEncoder_mb=").append(this.timeToToggleDialByEncoder_mb).append(", timeToToggleDialByEncoder_sm=").append(this.timeToToggleDialByEncoder_sm).append(", toolAppInfo=").append(this.toolAppInfo).append(", toolAppInfo_mb=").append(this.toolAppInfo_mb).append(", toolAppInfo_sm1=").append(this.toolAppInfo_sm1).append(", toolAppInfo_sm2=").append(this.toolAppInfo_sm2).append(", toolAppInfo_sm3=").append(this.toolAppInfo_sm3).append(", valueOfEncoderEvent=").append(this.valueOfEncoderEvent).append(", valueOfEncoderEvent_mb=").append(this.valueOfEncoderEvent_mb).append(", valueOfEncoderEvent_sm=");
        sb.append(this.valueOfEncoderEvent_sm).append(", systemBar=").append(this.systemBar).append(", systemBar_sm=").append(this.systemBar_sm).append(", systemBar_mb=").append(this.systemBar_mb).append(", userHandleStatusBarSet=").append(this.userHandleStatusBarSet).append(", statusBarSet_packageName=").append(this.statusBarSet_packageName).append(", statusBarSet_className=").append(this.statusBarSet_className).append(", userHandleStatusBarSet_sm=").append(this.userHandleStatusBarSet_sm).append(", chargeRingPath=").append(this.chargeRingPath).append(", support_compass=").append(this.support_compass).append(", support_heart=").append(this.support_heart).append(", honeycomb_Dial_Reset=").append(this.honeycomb_Dial_Reset);
        sb.append(", use_handle_statusbar_margin=").append(this.use_handle_statusbar_margin).append(", statusbar_margin_start=").append(this.statusbar_margin_start).append(", statusbar_margin_end=").append(this.statusbar_margin_end).append(", filterAppList=").append(this.filterAppList).append(", orderAppList=").append(this.orderAppList).append(", filterWatchInfoList=").append(this.filterWatchInfoList).append(", keyEncoderType=").append(this.keyEncoderType).append(", launcherthemeType=").append(this.launcherthemeType).append(", themeCardInfoList=").append(this.themeCardInfoList).append(", menuSlideAppCount=").append(this.menuSlideAppCount).append(", menuSlideAppDynastic=").append(this.menuSlideAppDynastic).append(", menuSlide_bg_custom=");
        sb.append(this.menuSlide_bg_custom).append(", menuSlide_bg_color=").append(this.menuSlide_bg_color).append(", menuSlideAppList=").append(this.menuSlideAppList).append(", charge_animal_show=").append(this.charge_animal_show).append(", statusBarFunctionList=").append(this.statusBarFunctionList).append(", allowMoveUpTask=").append(this.allowMoveUpTask).append(", hidedDialLock=").append(this.hidedDialLock).append(", halfboard_style_alpha_fixed=").append(this.halfboard_style_alpha_fixed).append(", halfboard_style_scroll_alignment=").append(this.halfboard_style_scroll_alignment).append(", encoder_specialscroll=").append(this.encoder_specialscroll).append(", support_delete_internal_dial=").append(this.support_delete_internal_dial).append(", honeycomb_has_foot_view=").append(this.honeycomb_has_foot_view);
        sb.append(", disable_slide_menu=").append(this.disable_slide_menu).append(", allowSwipeRight=").append(this.allowSwipeRight).append(", swipe_right_app_package_className=").append(this.swipe_right_app_package_className).append(", use_auto_tts_service=").append(this.use_auto_tts_service).append(')');
        return sb.toString();
    }

    public LaunchConfig(int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, int i3, String str8, String str9, FontSizeInfo fontSizeInfo, String str10, String str11, int i4, String str12, String str13, KeyChangeStyleInfo keyChangeStyleInfo, String str14, String str15, List<MenuAppInfo> list, List<MenuAppInfoMb> list2, String str16, String str17, String str18, List<MenuStyleInfo> list3, List<MenuStyleInfoMb> list4, String str19, int i5, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, int i6, String str34, String str35, int i7, String str36, String str37, List<ToolAppInfo> list5, List<ToolAppInfoMb> list6, String str38, String str39, String str40, int i8, String str41, String str42, int i9, String str43, String str44, int i10, String str45, String str46, String str47, String str48, int i11, int i12, int i13, int i14, int i15, int i16, List<FilterAppInfo> list7, List<OrderAppInfo> list8, List<WatchInfo> list9, int i17, int i18, List<ThemeCardInfo> list10, int i19, int i20, int i21, String str49, List<SlideMenuApp> list11, Integer num, List<StatusBarFunctionList> list12, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, String str50, int i31) {
        Intrinsics.checkNotNullParameter(str, "appSupervisionType_mb");
        Intrinsics.checkNotNullParameter(str2, "appSupervisionType_sm");
        Intrinsics.checkNotNullParameter(str3, "default_clock_id");
        Intrinsics.checkNotNullParameter(str4, "defaultDial_mb");
        Intrinsics.checkNotNullParameter(str5, "defaultDial_sm");
        Intrinsics.checkNotNullParameter(str6, "defaultStyle_mb");
        Intrinsics.checkNotNullParameter(str7, "defaultStyle_sm");
        Intrinsics.checkNotNullParameter(str8, "defaultTheme_mb");
        Intrinsics.checkNotNullParameter(str9, "defaultTheme_sm");
        Intrinsics.checkNotNullParameter(fontSizeInfo, "fontSizeInfo");
        Intrinsics.checkNotNullParameter(str10, "fontSizeInfo_mb");
        Intrinsics.checkNotNullParameter(str11, "fontSizeInfo_sm");
        Intrinsics.checkNotNullParameter(str12, "intervalOfEncoderEvent_mb");
        Intrinsics.checkNotNullParameter(str13, "intervalOfEncoderEvent_sm");
        Intrinsics.checkNotNullParameter(keyChangeStyleInfo, "keyChangeStyleInfo");
        Intrinsics.checkNotNullParameter(str14, "keyChangeStyleInfo_mb");
        Intrinsics.checkNotNullParameter(str15, "keyChangeStyleInfo_sm");
        Intrinsics.checkNotNullParameter(list, "menuAppInfo");
        Intrinsics.checkNotNullParameter(list2, "menuAppInfo_mb");
        Intrinsics.checkNotNullParameter(str16, "menuAppInfo_sm1");
        Intrinsics.checkNotNullParameter(str17, "menuAppInfo_sm2");
        Intrinsics.checkNotNullParameter(str18, "menuAppInfo_sm3");
        Intrinsics.checkNotNullParameter(list3, "menuStyleInfo");
        Intrinsics.checkNotNullParameter(list4, "menuStyleInfo_mb");
        Intrinsics.checkNotNullParameter(str19, "menuStyleInfo_sm");
        Intrinsics.checkNotNullParameter(str20, "notInstallAppDeal_mb");
        Intrinsics.checkNotNullParameter(str21, "notInstallAppDeal_sm");
        Intrinsics.checkNotNullParameter(str22, "openEncoderSound");
        Intrinsics.checkNotNullParameter(str23, "openEncoderSound_mb");
        Intrinsics.checkNotNullParameter(str24, "openEncoderSound_sm");
        Intrinsics.checkNotNullParameter(str25, "openEncoderVibrator");
        Intrinsics.checkNotNullParameter(str26, "openEncoderVibrator_mb");
        Intrinsics.checkNotNullParameter(str27, "openEncoderVibrator_sm");
        Intrinsics.checkNotNullParameter(str28, "openFixedChangeActionValue");
        Intrinsics.checkNotNullParameter(str29, "openFixedChangeActionValue_mb");
        Intrinsics.checkNotNullParameter(str30, "openFixedChangeActionValue_sm");
        Intrinsics.checkNotNullParameter(str31, "openProgressBar");
        Intrinsics.checkNotNullParameter(str32, "openProgressBar_mb");
        Intrinsics.checkNotNullParameter(str33, "openProgressBar_sm");
        Intrinsics.checkNotNullParameter(str34, "timeToHideProgressBar_mb");
        Intrinsics.checkNotNullParameter(str35, "timeToHideProgressBar_sm");
        Intrinsics.checkNotNullParameter(str36, "timeToToggleDialByEncoder_mb");
        Intrinsics.checkNotNullParameter(str37, "timeToToggleDialByEncoder_sm");
        Intrinsics.checkNotNullParameter(list5, "toolAppInfo");
        Intrinsics.checkNotNullParameter(list6, "toolAppInfo_mb");
        Intrinsics.checkNotNullParameter(str38, "toolAppInfo_sm1");
        Intrinsics.checkNotNullParameter(str39, "toolAppInfo_sm2");
        Intrinsics.checkNotNullParameter(str40, "toolAppInfo_sm3");
        Intrinsics.checkNotNullParameter(str41, "valueOfEncoderEvent_mb");
        Intrinsics.checkNotNullParameter(str42, "valueOfEncoderEvent_sm");
        Intrinsics.checkNotNullParameter(str43, "systemBar_sm");
        Intrinsics.checkNotNullParameter(str44, "systemBar_mb");
        Intrinsics.checkNotNullParameter(str45, "statusBarSet_packageName");
        Intrinsics.checkNotNullParameter(str46, "statusBarSet_className");
        Intrinsics.checkNotNullParameter(str47, "userHandleStatusBarSet_sm");
        Intrinsics.checkNotNullParameter(str48, "chargeRingPath");
        Intrinsics.checkNotNullParameter(list7, "filterAppList");
        Intrinsics.checkNotNullParameter(list8, "orderAppList");
        Intrinsics.checkNotNullParameter(list9, "filterWatchInfoList");
        Intrinsics.checkNotNullParameter(list10, "themeCardInfoList");
        Intrinsics.checkNotNullParameter(str49, "menuSlide_bg_color");
        Intrinsics.checkNotNullParameter(list11, "menuSlideAppList");
        Intrinsics.checkNotNullParameter(list12, "statusBarFunctionList");
        Intrinsics.checkNotNullParameter(str50, "swipe_right_app_package_className");
        this.appSupervisionType = i;
        this.appSupervisionType_mb = str;
        this.appSupervisionType_sm = str2;
        this.default_clock_id = str3;
        this.defaultDial_mb = str4;
        this.defaultDial_sm = str5;
        this.defaultStyle = i2;
        this.defaultStyle_mb = str6;
        this.defaultStyle_sm = str7;
        this.defaultTheme = i3;
        this.defaultTheme_mb = str8;
        this.defaultTheme_sm = str9;
        this.fontSizeInfo = fontSizeInfo;
        this.fontSizeInfo_mb = str10;
        this.fontSizeInfo_sm = str11;
        this.intervalOfEncoderEvent = i4;
        this.intervalOfEncoderEvent_mb = str12;
        this.intervalOfEncoderEvent_sm = str13;
        this.keyChangeStyleInfo = keyChangeStyleInfo;
        this.keyChangeStyleInfo_mb = str14;
        this.keyChangeStyleInfo_sm = str15;
        this.menuAppInfo = list;
        this.menuAppInfo_mb = list2;
        this.menuAppInfo_sm1 = str16;
        this.menuAppInfo_sm2 = str17;
        this.menuAppInfo_sm3 = str18;
        this.menuStyleInfo = list3;
        this.menuStyleInfo_mb = list4;
        this.menuStyleInfo_sm = str19;
        this.notInstallAppDeal = i5;
        this.notInstallAppDeal_mb = str20;
        this.notInstallAppDeal_sm = str21;
        this.openEncoderSound = str22;
        this.openEncoderSound_mb = str23;
        this.openEncoderSound_sm = str24;
        this.openEncoderVibrator = str25;
        this.openEncoderVibrator_mb = str26;
        this.openEncoderVibrator_sm = str27;
        this.openFixedChangeActionValue = str28;
        this.openFixedChangeActionValue_mb = str29;
        this.openFixedChangeActionValue_sm = str30;
        this.openProgressBar = str31;
        this.openProgressBar_mb = str32;
        this.openProgressBar_sm = str33;
        this.timeToHideProgressBar = i6;
        this.timeToHideProgressBar_mb = str34;
        this.timeToHideProgressBar_sm = str35;
        this.timeToToggleDialByEncoder = i7;
        this.timeToToggleDialByEncoder_mb = str36;
        this.timeToToggleDialByEncoder_sm = str37;
        this.toolAppInfo = list5;
        this.toolAppInfo_mb = list6;
        this.toolAppInfo_sm1 = str38;
        this.toolAppInfo_sm2 = str39;
        this.toolAppInfo_sm3 = str40;
        this.valueOfEncoderEvent = i8;
        this.valueOfEncoderEvent_mb = str41;
        this.valueOfEncoderEvent_sm = str42;
        this.systemBar = i9;
        this.systemBar_sm = str43;
        this.systemBar_mb = str44;
        this.userHandleStatusBarSet = i10;
        this.statusBarSet_packageName = str45;
        this.statusBarSet_className = str46;
        this.userHandleStatusBarSet_sm = str47;
        this.chargeRingPath = str48;
        this.support_compass = i11;
        this.support_heart = i12;
        this.honeycomb_Dial_Reset = i13;
        this.use_handle_statusbar_margin = i14;
        this.statusbar_margin_start = i15;
        this.statusbar_margin_end = i16;
        this.filterAppList = list7;
        this.orderAppList = list8;
        this.filterWatchInfoList = list9;
        this.keyEncoderType = i17;
        this.launcherthemeType = i18;
        this.themeCardInfoList = list10;
        this.menuSlideAppCount = i19;
        this.menuSlideAppDynastic = i20;
        this.menuSlide_bg_custom = i21;
        this.menuSlide_bg_color = str49;
        this.menuSlideAppList = list11;
        this.charge_animal_show = num;
        this.statusBarFunctionList = list12;
        this.allowMoveUpTask = i22;
        this.hidedDialLock = i23;
        this.halfboard_style_alpha_fixed = i24;
        this.halfboard_style_scroll_alignment = i25;
        this.encoder_specialscroll = i26;
        this.support_delete_internal_dial = i27;
        this.honeycomb_has_foot_view = i28;
        this.disable_slide_menu = i29;
        this.allowSwipeRight = i30;
        this.swipe_right_app_package_className = str50;
        this.use_auto_tts_service = i31;
    }

    public final int getAppSupervisionType() {
        return this.appSupervisionType;
    }

    public final void setAppSupervisionType(int i) {
        this.appSupervisionType = i;
    }

    public final String getAppSupervisionType_mb() {
        return this.appSupervisionType_mb;
    }

    public final void setAppSupervisionType_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appSupervisionType_mb = str;
    }

    public final String getAppSupervisionType_sm() {
        return this.appSupervisionType_sm;
    }

    public final void setAppSupervisionType_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appSupervisionType_sm = str;
    }

    public final String getDefault_clock_id() {
        return this.default_clock_id;
    }

    public final void setDefault_clock_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.default_clock_id = str;
    }

    public final String getDefaultDial_mb() {
        return this.defaultDial_mb;
    }

    public final void setDefaultDial_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultDial_mb = str;
    }

    public final String getDefaultDial_sm() {
        return this.defaultDial_sm;
    }

    public final void setDefaultDial_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultDial_sm = str;
    }

    public final int getDefaultStyle() {
        return this.defaultStyle;
    }

    public final void setDefaultStyle(int i) {
        this.defaultStyle = i;
    }

    public final String getDefaultStyle_mb() {
        return this.defaultStyle_mb;
    }

    public final void setDefaultStyle_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultStyle_mb = str;
    }

    public final String getDefaultStyle_sm() {
        return this.defaultStyle_sm;
    }

    public final void setDefaultStyle_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultStyle_sm = str;
    }

    public final int getDefaultTheme() {
        return this.defaultTheme;
    }

    public final void setDefaultTheme(int i) {
        this.defaultTheme = i;
    }

    public final String getDefaultTheme_mb() {
        return this.defaultTheme_mb;
    }

    public final void setDefaultTheme_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultTheme_mb = str;
    }

    public final String getDefaultTheme_sm() {
        return this.defaultTheme_sm;
    }

    public final void setDefaultTheme_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultTheme_sm = str;
    }

    public final FontSizeInfo getFontSizeInfo() {
        return this.fontSizeInfo;
    }

    public final void setFontSizeInfo(FontSizeInfo fontSizeInfo) {
        Intrinsics.checkNotNullParameter(fontSizeInfo, "<set-?>");
        this.fontSizeInfo = fontSizeInfo;
    }

    public final String getFontSizeInfo_mb() {
        return this.fontSizeInfo_mb;
    }

    public final void setFontSizeInfo_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fontSizeInfo_mb = str;
    }

    public final String getFontSizeInfo_sm() {
        return this.fontSizeInfo_sm;
    }

    public final void setFontSizeInfo_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fontSizeInfo_sm = str;
    }

    public final int getIntervalOfEncoderEvent() {
        return this.intervalOfEncoderEvent;
    }

    public final void setIntervalOfEncoderEvent(int i) {
        this.intervalOfEncoderEvent = i;
    }

    public final String getIntervalOfEncoderEvent_mb() {
        return this.intervalOfEncoderEvent_mb;
    }

    public final void setIntervalOfEncoderEvent_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.intervalOfEncoderEvent_mb = str;
    }

    public final String getIntervalOfEncoderEvent_sm() {
        return this.intervalOfEncoderEvent_sm;
    }

    public final void setIntervalOfEncoderEvent_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.intervalOfEncoderEvent_sm = str;
    }

    public final KeyChangeStyleInfo getKeyChangeStyleInfo() {
        return this.keyChangeStyleInfo;
    }

    public final void setKeyChangeStyleInfo(KeyChangeStyleInfo keyChangeStyleInfo) {
        Intrinsics.checkNotNullParameter(keyChangeStyleInfo, "<set-?>");
        this.keyChangeStyleInfo = keyChangeStyleInfo;
    }

    public final String getKeyChangeStyleInfo_mb() {
        return this.keyChangeStyleInfo_mb;
    }

    public final void setKeyChangeStyleInfo_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keyChangeStyleInfo_mb = str;
    }

    public final String getKeyChangeStyleInfo_sm() {
        return this.keyChangeStyleInfo_sm;
    }

    public final void setKeyChangeStyleInfo_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keyChangeStyleInfo_sm = str;
    }

    public final List<MenuAppInfo> getMenuAppInfo() {
        return this.menuAppInfo;
    }

    public final void setMenuAppInfo(List<MenuAppInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.menuAppInfo = list;
    }

    public final List<MenuAppInfoMb> getMenuAppInfo_mb() {
        return this.menuAppInfo_mb;
    }

    public final void setMenuAppInfo_mb(List<MenuAppInfoMb> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.menuAppInfo_mb = list;
    }

    public final String getMenuAppInfo_sm1() {
        return this.menuAppInfo_sm1;
    }

    public final void setMenuAppInfo_sm1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.menuAppInfo_sm1 = str;
    }

    public final String getMenuAppInfo_sm2() {
        return this.menuAppInfo_sm2;
    }

    public final void setMenuAppInfo_sm2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.menuAppInfo_sm2 = str;
    }

    public final String getMenuAppInfo_sm3() {
        return this.menuAppInfo_sm3;
    }

    public final void setMenuAppInfo_sm3(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.menuAppInfo_sm3 = str;
    }

    public final List<MenuStyleInfo> getMenuStyleInfo() {
        return this.menuStyleInfo;
    }

    public final void setMenuStyleInfo(List<MenuStyleInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.menuStyleInfo = list;
    }

    public final List<MenuStyleInfoMb> getMenuStyleInfo_mb() {
        return this.menuStyleInfo_mb;
    }

    public final void setMenuStyleInfo_mb(List<MenuStyleInfoMb> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.menuStyleInfo_mb = list;
    }

    public final String getMenuStyleInfo_sm() {
        return this.menuStyleInfo_sm;
    }

    public final void setMenuStyleInfo_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.menuStyleInfo_sm = str;
    }

    public final int getNotInstallAppDeal() {
        return this.notInstallAppDeal;
    }

    public final void setNotInstallAppDeal(int i) {
        this.notInstallAppDeal = i;
    }

    public final String getNotInstallAppDeal_mb() {
        return this.notInstallAppDeal_mb;
    }

    public final void setNotInstallAppDeal_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.notInstallAppDeal_mb = str;
    }

    public final String getNotInstallAppDeal_sm() {
        return this.notInstallAppDeal_sm;
    }

    public final void setNotInstallAppDeal_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.notInstallAppDeal_sm = str;
    }

    public final String getOpenEncoderSound() {
        return this.openEncoderSound;
    }

    public final void setOpenEncoderSound(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openEncoderSound = str;
    }

    public final String getOpenEncoderSound_mb() {
        return this.openEncoderSound_mb;
    }

    public final void setOpenEncoderSound_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openEncoderSound_mb = str;
    }

    public final String getOpenEncoderSound_sm() {
        return this.openEncoderSound_sm;
    }

    public final void setOpenEncoderSound_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openEncoderSound_sm = str;
    }

    public final String getOpenEncoderVibrator() {
        return this.openEncoderVibrator;
    }

    public final void setOpenEncoderVibrator(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openEncoderVibrator = str;
    }

    public final String getOpenEncoderVibrator_mb() {
        return this.openEncoderVibrator_mb;
    }

    public final void setOpenEncoderVibrator_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openEncoderVibrator_mb = str;
    }

    public final String getOpenEncoderVibrator_sm() {
        return this.openEncoderVibrator_sm;
    }

    public final void setOpenEncoderVibrator_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openEncoderVibrator_sm = str;
    }

    public final String getOpenFixedChangeActionValue() {
        return this.openFixedChangeActionValue;
    }

    public final void setOpenFixedChangeActionValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openFixedChangeActionValue = str;
    }

    public final String getOpenFixedChangeActionValue_mb() {
        return this.openFixedChangeActionValue_mb;
    }

    public final void setOpenFixedChangeActionValue_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openFixedChangeActionValue_mb = str;
    }

    public final String getOpenFixedChangeActionValue_sm() {
        return this.openFixedChangeActionValue_sm;
    }

    public final void setOpenFixedChangeActionValue_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openFixedChangeActionValue_sm = str;
    }

    public final String getOpenProgressBar() {
        return this.openProgressBar;
    }

    public final void setOpenProgressBar(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openProgressBar = str;
    }

    public final String getOpenProgressBar_mb() {
        return this.openProgressBar_mb;
    }

    public final void setOpenProgressBar_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openProgressBar_mb = str;
    }

    public final String getOpenProgressBar_sm() {
        return this.openProgressBar_sm;
    }

    public final void setOpenProgressBar_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openProgressBar_sm = str;
    }

    public final int getTimeToHideProgressBar() {
        return this.timeToHideProgressBar;
    }

    public final void setTimeToHideProgressBar(int i) {
        this.timeToHideProgressBar = i;
    }

    public final String getTimeToHideProgressBar_mb() {
        return this.timeToHideProgressBar_mb;
    }

    public final void setTimeToHideProgressBar_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeToHideProgressBar_mb = str;
    }

    public final String getTimeToHideProgressBar_sm() {
        return this.timeToHideProgressBar_sm;
    }

    public final void setTimeToHideProgressBar_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeToHideProgressBar_sm = str;
    }

    public final int getTimeToToggleDialByEncoder() {
        return this.timeToToggleDialByEncoder;
    }

    public final void setTimeToToggleDialByEncoder(int i) {
        this.timeToToggleDialByEncoder = i;
    }

    public final String getTimeToToggleDialByEncoder_mb() {
        return this.timeToToggleDialByEncoder_mb;
    }

    public final void setTimeToToggleDialByEncoder_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeToToggleDialByEncoder_mb = str;
    }

    public final String getTimeToToggleDialByEncoder_sm() {
        return this.timeToToggleDialByEncoder_sm;
    }

    public final void setTimeToToggleDialByEncoder_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeToToggleDialByEncoder_sm = str;
    }

    public final List<ToolAppInfo> getToolAppInfo() {
        return this.toolAppInfo;
    }

    public final void setToolAppInfo(List<ToolAppInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.toolAppInfo = list;
    }

    public final List<ToolAppInfoMb> getToolAppInfo_mb() {
        return this.toolAppInfo_mb;
    }

    public final void setToolAppInfo_mb(List<ToolAppInfoMb> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.toolAppInfo_mb = list;
    }

    public final String getToolAppInfo_sm1() {
        return this.toolAppInfo_sm1;
    }

    public final void setToolAppInfo_sm1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.toolAppInfo_sm1 = str;
    }

    public final String getToolAppInfo_sm2() {
        return this.toolAppInfo_sm2;
    }

    public final void setToolAppInfo_sm2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.toolAppInfo_sm2 = str;
    }

    public final String getToolAppInfo_sm3() {
        return this.toolAppInfo_sm3;
    }

    public final void setToolAppInfo_sm3(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.toolAppInfo_sm3 = str;
    }

    public final int getValueOfEncoderEvent() {
        return this.valueOfEncoderEvent;
    }

    public final void setValueOfEncoderEvent(int i) {
        this.valueOfEncoderEvent = i;
    }

    public final String getValueOfEncoderEvent_mb() {
        return this.valueOfEncoderEvent_mb;
    }

    public final void setValueOfEncoderEvent_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.valueOfEncoderEvent_mb = str;
    }

    public final String getValueOfEncoderEvent_sm() {
        return this.valueOfEncoderEvent_sm;
    }

    public final void setValueOfEncoderEvent_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.valueOfEncoderEvent_sm = str;
    }

    public final int getSystemBar() {
        return this.systemBar;
    }

    public final void setSystemBar(int i) {
        this.systemBar = i;
    }

    public final String getSystemBar_sm() {
        return this.systemBar_sm;
    }

    public final void setSystemBar_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.systemBar_sm = str;
    }

    public final String getSystemBar_mb() {
        return this.systemBar_mb;
    }

    public final void setSystemBar_mb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.systemBar_mb = str;
    }

    public final int getUserHandleStatusBarSet() {
        return this.userHandleStatusBarSet;
    }

    public final void setUserHandleStatusBarSet(int i) {
        this.userHandleStatusBarSet = i;
    }

    public final String getStatusBarSet_packageName() {
        return this.statusBarSet_packageName;
    }

    public final void setStatusBarSet_packageName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.statusBarSet_packageName = str;
    }

    public final String getStatusBarSet_className() {
        return this.statusBarSet_className;
    }

    public final void setStatusBarSet_className(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.statusBarSet_className = str;
    }

    public final String getUserHandleStatusBarSet_sm() {
        return this.userHandleStatusBarSet_sm;
    }

    public final void setUserHandleStatusBarSet_sm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userHandleStatusBarSet_sm = str;
    }

    public final String getChargeRingPath() {
        return this.chargeRingPath;
    }

    public final void setChargeRingPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.chargeRingPath = str;
    }

    public final int getSupport_compass() {
        return this.support_compass;
    }

    public final void setSupport_compass(int i) {
        this.support_compass = i;
    }

    public final int getSupport_heart() {
        return this.support_heart;
    }

    public final void setSupport_heart(int i) {
        this.support_heart = i;
    }

    public final int getHoneycomb_Dial_Reset() {
        return this.honeycomb_Dial_Reset;
    }

    public final void setHoneycomb_Dial_Reset(int i) {
        this.honeycomb_Dial_Reset = i;
    }

    public final int getUse_handle_statusbar_margin() {
        return this.use_handle_statusbar_margin;
    }

    public final void setUse_handle_statusbar_margin(int i) {
        this.use_handle_statusbar_margin = i;
    }

    public final int getStatusbar_margin_start() {
        return this.statusbar_margin_start;
    }

    public final void setStatusbar_margin_start(int i) {
        this.statusbar_margin_start = i;
    }

    public final int getStatusbar_margin_end() {
        return this.statusbar_margin_end;
    }

    public final void setStatusbar_margin_end(int i) {
        this.statusbar_margin_end = i;
    }

    public final List<FilterAppInfo> getFilterAppList() {
        return this.filterAppList;
    }

    public final void setFilterAppList(List<FilterAppInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.filterAppList = list;
    }

    public final List<OrderAppInfo> getOrderAppList() {
        return this.orderAppList;
    }

    public final void setOrderAppList(List<OrderAppInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.orderAppList = list;
    }

    public final List<WatchInfo> getFilterWatchInfoList() {
        return this.filterWatchInfoList;
    }

    public final void setFilterWatchInfoList(List<WatchInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.filterWatchInfoList = list;
    }

    public final int getKeyEncoderType() {
        return this.keyEncoderType;
    }

    public final void setKeyEncoderType(int i) {
        this.keyEncoderType = i;
    }

    public final int getLauncherthemeType() {
        return this.launcherthemeType;
    }

    public final void setLauncherthemeType(int i) {
        this.launcherthemeType = i;
    }

    public final List<ThemeCardInfo> getThemeCardInfoList() {
        return this.themeCardInfoList;
    }

    public final void setThemeCardInfoList(List<ThemeCardInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.themeCardInfoList = list;
    }

    public final int getMenuSlideAppCount() {
        return this.menuSlideAppCount;
    }

    public final void setMenuSlideAppCount(int i) {
        this.menuSlideAppCount = i;
    }

    public final int getMenuSlideAppDynastic() {
        return this.menuSlideAppDynastic;
    }

    public final void setMenuSlideAppDynastic(int i) {
        this.menuSlideAppDynastic = i;
    }

    public final int getMenuSlide_bg_custom() {
        return this.menuSlide_bg_custom;
    }

    public final void setMenuSlide_bg_custom(int i) {
        this.menuSlide_bg_custom = i;
    }

    public final String getMenuSlide_bg_color() {
        return this.menuSlide_bg_color;
    }

    public final void setMenuSlide_bg_color(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.menuSlide_bg_color = str;
    }

    public final List<SlideMenuApp> getMenuSlideAppList() {
        return this.menuSlideAppList;
    }

    public final void setMenuSlideAppList(List<SlideMenuApp> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.menuSlideAppList = list;
    }

    public final Integer getCharge_animal_show() {
        return this.charge_animal_show;
    }

    public final void setCharge_animal_show(Integer num) {
        this.charge_animal_show = num;
    }

    public final List<StatusBarFunctionList> getStatusBarFunctionList() {
        return this.statusBarFunctionList;
    }

    public final void setStatusBarFunctionList(List<StatusBarFunctionList> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.statusBarFunctionList = list;
    }

    public final int getAllowMoveUpTask() {
        return this.allowMoveUpTask;
    }

    public final void setAllowMoveUpTask(int i) {
        this.allowMoveUpTask = i;
    }

    public final int getHidedDialLock() {
        return this.hidedDialLock;
    }

    public final void setHidedDialLock(int i) {
        this.hidedDialLock = i;
    }

    public final int getHalfboard_style_alpha_fixed() {
        return this.halfboard_style_alpha_fixed;
    }

    public final void setHalfboard_style_alpha_fixed(int i) {
        this.halfboard_style_alpha_fixed = i;
    }

    public final int getHalfboard_style_scroll_alignment() {
        return this.halfboard_style_scroll_alignment;
    }

    public final void setHalfboard_style_scroll_alignment(int i) {
        this.halfboard_style_scroll_alignment = i;
    }

    public final int getEncoder_specialscroll() {
        return this.encoder_specialscroll;
    }

    public final void setEncoder_specialscroll(int i) {
        this.encoder_specialscroll = i;
    }

    public final int getSupport_delete_internal_dial() {
        return this.support_delete_internal_dial;
    }

    public final void setSupport_delete_internal_dial(int i) {
        this.support_delete_internal_dial = i;
    }

    public final int getHoneycomb_has_foot_view() {
        return this.honeycomb_has_foot_view;
    }

    public final void setHoneycomb_has_foot_view(int i) {
        this.honeycomb_has_foot_view = i;
    }

    public final int getDisable_slide_menu() {
        return this.disable_slide_menu;
    }

    public final void setDisable_slide_menu(int i) {
        this.disable_slide_menu = i;
    }

    public final int getAllowSwipeRight() {
        return this.allowSwipeRight;
    }

    public final void setAllowSwipeRight(int i) {
        this.allowSwipeRight = i;
    }

    public final String getSwipe_right_app_package_className() {
        return this.swipe_right_app_package_className;
    }

    public final void setSwipe_right_app_package_className(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.swipe_right_app_package_className = str;
    }

    public final int getUse_auto_tts_service() {
        return this.use_auto_tts_service;
    }

    public final void setUse_auto_tts_service(int i) {
        this.use_auto_tts_service = i;
    }

    /* JADX INFO: compiled from: LaunchConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/dw/launcher/data/entity/LaunchConfig$FontSizeInfo;", BuildConfig.FLAVOR, "fontLarge", BuildConfig.FLAVOR, "fontNormal", "fontSmall", "(III)V", "getFontLarge", "()I", "setFontLarge", "(I)V", "getFontNormal", "setFontNormal", "getFontSmall", "setFontSmall", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class FontSizeInfo {
        private int fontLarge;
        private int fontNormal;
        private int fontSmall;

        public static /* synthetic */ FontSizeInfo copy$default(FontSizeInfo fontSizeInfo, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = fontSizeInfo.fontLarge;
            }
            if ((i4 & 2) != 0) {
                i2 = fontSizeInfo.fontNormal;
            }
            if ((i4 & 4) != 0) {
                i3 = fontSizeInfo.fontSmall;
            }
            return fontSizeInfo.copy(i, i2, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getFontLarge() {
            return this.fontLarge;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getFontNormal() {
            return this.fontNormal;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getFontSmall() {
            return this.fontSmall;
        }

        public final FontSizeInfo copy(int fontLarge, int fontNormal, int fontSmall) {
            return new FontSizeInfo(fontLarge, fontNormal, fontSmall);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FontSizeInfo)) {
                return false;
            }
            FontSizeInfo fontSizeInfo = (FontSizeInfo) other;
            return this.fontLarge == fontSizeInfo.fontLarge && this.fontNormal == fontSizeInfo.fontNormal && this.fontSmall == fontSizeInfo.fontSmall;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.fontLarge) * 31) + Integer.hashCode(this.fontNormal)) * 31) + Integer.hashCode(this.fontSmall);
        }

        public String toString() {
            return "FontSizeInfo(fontLarge=" + this.fontLarge + ", fontNormal=" + this.fontNormal + ", fontSmall=" + this.fontSmall + ')';
        }

        public FontSizeInfo(int i, int i2, int i3) {
            this.fontLarge = i;
            this.fontNormal = i2;
            this.fontSmall = i3;
        }

        public final int getFontLarge() {
            return this.fontLarge;
        }

        public final void setFontLarge(int i) {
            this.fontLarge = i;
        }

        public final int getFontNormal() {
            return this.fontNormal;
        }

        public final void setFontNormal(int i) {
            this.fontNormal = i;
        }

        public final int getFontSmall() {
            return this.fontSmall;
        }

        public final void setFontSmall(int i) {
            this.fontSmall = i;
        }
    }

    /* JADX INFO: compiled from: LaunchConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/dw/launcher/data/entity/LaunchConfig$KeyChangeStyleInfo;", BuildConfig.FLAVOR, "doubleInterval", BuildConfig.FLAVOR, "isOpen", BuildConfig.FLAVOR, "keyValue", "(ILjava/lang/String;I)V", "getDoubleInterval", "()I", "setDoubleInterval", "(I)V", "()Ljava/lang/String;", "setOpen", "(Ljava/lang/String;)V", "getKeyValue", "setKeyValue", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class KeyChangeStyleInfo {
        private int doubleInterval;
        private String isOpen;
        private int keyValue;

        public static /* synthetic */ KeyChangeStyleInfo copy$default(KeyChangeStyleInfo keyChangeStyleInfo, int i, String str, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = keyChangeStyleInfo.doubleInterval;
            }
            if ((i3 & 2) != 0) {
                str = keyChangeStyleInfo.isOpen;
            }
            if ((i3 & 4) != 0) {
                i2 = keyChangeStyleInfo.keyValue;
            }
            return keyChangeStyleInfo.copy(i, str, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getDoubleInterval() {
            return this.doubleInterval;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIsOpen() {
            return this.isOpen;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getKeyValue() {
            return this.keyValue;
        }

        public final KeyChangeStyleInfo copy(int doubleInterval, String isOpen, int keyValue) {
            Intrinsics.checkNotNullParameter(isOpen, "isOpen");
            return new KeyChangeStyleInfo(doubleInterval, isOpen, keyValue);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof KeyChangeStyleInfo)) {
                return false;
            }
            KeyChangeStyleInfo keyChangeStyleInfo = (KeyChangeStyleInfo) other;
            return this.doubleInterval == keyChangeStyleInfo.doubleInterval && Intrinsics.areEqual(this.isOpen, keyChangeStyleInfo.isOpen) && this.keyValue == keyChangeStyleInfo.keyValue;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.doubleInterval) * 31) + this.isOpen.hashCode()) * 31) + Integer.hashCode(this.keyValue);
        }

        public String toString() {
            return "KeyChangeStyleInfo(doubleInterval=" + this.doubleInterval + ", isOpen=" + this.isOpen + ", keyValue=" + this.keyValue + ')';
        }

        public KeyChangeStyleInfo(int i, String str, int i2) {
            Intrinsics.checkNotNullParameter(str, "isOpen");
            this.doubleInterval = i;
            this.isOpen = str;
            this.keyValue = i2;
        }

        public final int getDoubleInterval() {
            return this.doubleInterval;
        }

        public final void setDoubleInterval(int i) {
            this.doubleInterval = i;
        }

        public final String isOpen() {
            return this.isOpen;
        }

        public final void setOpen(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.isOpen = str;
        }

        public final int getKeyValue() {
            return this.keyValue;
        }

        public final void setKeyValue(int i) {
            this.keyValue = i;
        }
    }

    /* JADX INFO: compiled from: LaunchConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006#"}, d2 = {"Lcom/dw/launcher/data/entity/LaunchConfig$MenuAppInfo;", BuildConfig.FLAVOR, "activityName", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "name", "pkg", "startUpType", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getName", "setName", "getPkg", "setPkg", "getStartUpType", "setStartUpType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class MenuAppInfo {
        private String activityName;
        private int id;
        private String name;
        private String pkg;
        private int startUpType;

        public static /* synthetic */ MenuAppInfo copy$default(MenuAppInfo menuAppInfo, String str, int i, String str2, String str3, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = menuAppInfo.activityName;
            }
            if ((i3 & 2) != 0) {
                i = menuAppInfo.id;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                str2 = menuAppInfo.name;
            }
            String str4 = str2;
            if ((i3 & 8) != 0) {
                str3 = menuAppInfo.pkg;
            }
            String str5 = str3;
            if ((i3 & 16) != 0) {
                i2 = menuAppInfo.startUpType;
            }
            return menuAppInfo.copy(str, i4, str4, str5, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getActivityName() {
            return this.activityName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getPkg() {
            return this.pkg;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getStartUpType() {
            return this.startUpType;
        }

        public final MenuAppInfo copy(String activityName, int id, String name, String pkg, int startUpType) {
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(pkg, "pkg");
            return new MenuAppInfo(activityName, id, name, pkg, startUpType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MenuAppInfo)) {
                return false;
            }
            MenuAppInfo menuAppInfo = (MenuAppInfo) other;
            return Intrinsics.areEqual(this.activityName, menuAppInfo.activityName) && this.id == menuAppInfo.id && Intrinsics.areEqual(this.name, menuAppInfo.name) && Intrinsics.areEqual(this.pkg, menuAppInfo.pkg) && this.startUpType == menuAppInfo.startUpType;
        }

        public int hashCode() {
            return (((((((this.activityName.hashCode() * 31) + Integer.hashCode(this.id)) * 31) + this.name.hashCode()) * 31) + this.pkg.hashCode()) * 31) + Integer.hashCode(this.startUpType);
        }

        public String toString() {
            return "MenuAppInfo(activityName=" + this.activityName + ", id=" + this.id + ", name=" + this.name + ", pkg=" + this.pkg + ", startUpType=" + this.startUpType + ')';
        }

        public MenuAppInfo(String str, int i, String str2, String str3, int i2) {
            Intrinsics.checkNotNullParameter(str, "activityName");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "pkg");
            this.activityName = str;
            this.id = i;
            this.name = str2;
            this.pkg = str3;
            this.startUpType = i2;
        }

        public final String getActivityName() {
            return this.activityName;
        }

        public final void setActivityName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.activityName = str;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getPkg() {
            return this.pkg;
        }

        public final void setPkg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pkg = str;
        }

        public final int getStartUpType() {
            return this.startUpType;
        }

        public final void setStartUpType(int i) {
            this.startUpType = i;
        }
    }

    /* JADX INFO: compiled from: LaunchConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006#"}, d2 = {"Lcom/dw/launcher/data/entity/LaunchConfig$MenuAppInfoMb;", BuildConfig.FLAVOR, "activityName", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "name", "pkg", "startUpType", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getName", "setName", "getPkg", "setPkg", "getStartUpType", "setStartUpType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class MenuAppInfoMb {
        private String activityName;
        private int id;
        private String name;
        private String pkg;
        private int startUpType;

        public static /* synthetic */ MenuAppInfoMb copy$default(MenuAppInfoMb menuAppInfoMb, String str, int i, String str2, String str3, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = menuAppInfoMb.activityName;
            }
            if ((i3 & 2) != 0) {
                i = menuAppInfoMb.id;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                str2 = menuAppInfoMb.name;
            }
            String str4 = str2;
            if ((i3 & 8) != 0) {
                str3 = menuAppInfoMb.pkg;
            }
            String str5 = str3;
            if ((i3 & 16) != 0) {
                i2 = menuAppInfoMb.startUpType;
            }
            return menuAppInfoMb.copy(str, i4, str4, str5, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getActivityName() {
            return this.activityName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getPkg() {
            return this.pkg;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getStartUpType() {
            return this.startUpType;
        }

        public final MenuAppInfoMb copy(String activityName, int id, String name, String pkg, int startUpType) {
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(pkg, "pkg");
            return new MenuAppInfoMb(activityName, id, name, pkg, startUpType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MenuAppInfoMb)) {
                return false;
            }
            MenuAppInfoMb menuAppInfoMb = (MenuAppInfoMb) other;
            return Intrinsics.areEqual(this.activityName, menuAppInfoMb.activityName) && this.id == menuAppInfoMb.id && Intrinsics.areEqual(this.name, menuAppInfoMb.name) && Intrinsics.areEqual(this.pkg, menuAppInfoMb.pkg) && this.startUpType == menuAppInfoMb.startUpType;
        }

        public int hashCode() {
            return (((((((this.activityName.hashCode() * 31) + Integer.hashCode(this.id)) * 31) + this.name.hashCode()) * 31) + this.pkg.hashCode()) * 31) + Integer.hashCode(this.startUpType);
        }

        public String toString() {
            return "MenuAppInfoMb(activityName=" + this.activityName + ", id=" + this.id + ", name=" + this.name + ", pkg=" + this.pkg + ", startUpType=" + this.startUpType + ')';
        }

        public MenuAppInfoMb(String str, int i, String str2, String str3, int i2) {
            Intrinsics.checkNotNullParameter(str, "activityName");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "pkg");
            this.activityName = str;
            this.id = i;
            this.name = str2;
            this.pkg = str3;
            this.startUpType = i2;
        }

        public final String getActivityName() {
            return this.activityName;
        }

        public final void setActivityName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.activityName = str;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getPkg() {
            return this.pkg;
        }

        public final void setPkg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pkg = str;
        }

        public final int getStartUpType() {
            return this.startUpType;
        }

        public final void setStartUpType(int i) {
            this.startUpType = i;
        }
    }

    /* JADX INFO: compiled from: LaunchConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/dw/launcher/data/entity/LaunchConfig$MenuStyleInfo;", BuildConfig.FLAVOR, "describe", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "getDescribe", "()Ljava/lang/String;", "setDescribe", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class MenuStyleInfo {
        private String describe;
        private int id;

        public static /* synthetic */ MenuStyleInfo copy$default(MenuStyleInfo menuStyleInfo, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = menuStyleInfo.describe;
            }
            if ((i2 & 2) != 0) {
                i = menuStyleInfo.id;
            }
            return menuStyleInfo.copy(str, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDescribe() {
            return this.describe;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getId() {
            return this.id;
        }

        public final MenuStyleInfo copy(String describe, int id) {
            Intrinsics.checkNotNullParameter(describe, "describe");
            return new MenuStyleInfo(describe, id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MenuStyleInfo)) {
                return false;
            }
            MenuStyleInfo menuStyleInfo = (MenuStyleInfo) other;
            return Intrinsics.areEqual(this.describe, menuStyleInfo.describe) && this.id == menuStyleInfo.id;
        }

        public int hashCode() {
            return (this.describe.hashCode() * 31) + Integer.hashCode(this.id);
        }

        public String toString() {
            return "MenuStyleInfo(describe=" + this.describe + ", id=" + this.id + ')';
        }

        public MenuStyleInfo(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "describe");
            this.describe = str;
            this.id = i;
        }

        public final String getDescribe() {
            return this.describe;
        }

        public final void setDescribe(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.describe = str;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }
    }

    /* JADX INFO: compiled from: LaunchConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/dw/launcher/data/entity/LaunchConfig$MenuStyleInfoMb;", BuildConfig.FLAVOR, "describe", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "getDescribe", "()Ljava/lang/String;", "setDescribe", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class MenuStyleInfoMb {
        private String describe;
        private int id;

        public static /* synthetic */ MenuStyleInfoMb copy$default(MenuStyleInfoMb menuStyleInfoMb, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = menuStyleInfoMb.describe;
            }
            if ((i2 & 2) != 0) {
                i = menuStyleInfoMb.id;
            }
            return menuStyleInfoMb.copy(str, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDescribe() {
            return this.describe;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getId() {
            return this.id;
        }

        public final MenuStyleInfoMb copy(String describe, int id) {
            Intrinsics.checkNotNullParameter(describe, "describe");
            return new MenuStyleInfoMb(describe, id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MenuStyleInfoMb)) {
                return false;
            }
            MenuStyleInfoMb menuStyleInfoMb = (MenuStyleInfoMb) other;
            return Intrinsics.areEqual(this.describe, menuStyleInfoMb.describe) && this.id == menuStyleInfoMb.id;
        }

        public int hashCode() {
            return (this.describe.hashCode() * 31) + Integer.hashCode(this.id);
        }

        public String toString() {
            return "MenuStyleInfoMb(describe=" + this.describe + ", id=" + this.id + ')';
        }

        public MenuStyleInfoMb(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "describe");
            this.describe = str;
            this.id = i;
        }

        public final String getDescribe() {
            return this.describe;
        }

        public final void setDescribe(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.describe = str;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }
    }

    /* JADX INFO: compiled from: LaunchConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006#"}, d2 = {"Lcom/dw/launcher/data/entity/LaunchConfig$ToolAppInfo;", BuildConfig.FLAVOR, "activityName", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "name", "pkg", "startUpType", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getName", "setName", "getPkg", "setPkg", "getStartUpType", "setStartUpType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ToolAppInfo {
        private String activityName;
        private int id;
        private String name;
        private String pkg;
        private int startUpType;

        public static /* synthetic */ ToolAppInfo copy$default(ToolAppInfo toolAppInfo, String str, int i, String str2, String str3, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = toolAppInfo.activityName;
            }
            if ((i3 & 2) != 0) {
                i = toolAppInfo.id;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                str2 = toolAppInfo.name;
            }
            String str4 = str2;
            if ((i3 & 8) != 0) {
                str3 = toolAppInfo.pkg;
            }
            String str5 = str3;
            if ((i3 & 16) != 0) {
                i2 = toolAppInfo.startUpType;
            }
            return toolAppInfo.copy(str, i4, str4, str5, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getActivityName() {
            return this.activityName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getPkg() {
            return this.pkg;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getStartUpType() {
            return this.startUpType;
        }

        public final ToolAppInfo copy(String activityName, int id, String name, String pkg, int startUpType) {
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(pkg, "pkg");
            return new ToolAppInfo(activityName, id, name, pkg, startUpType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ToolAppInfo)) {
                return false;
            }
            ToolAppInfo toolAppInfo = (ToolAppInfo) other;
            return Intrinsics.areEqual(this.activityName, toolAppInfo.activityName) && this.id == toolAppInfo.id && Intrinsics.areEqual(this.name, toolAppInfo.name) && Intrinsics.areEqual(this.pkg, toolAppInfo.pkg) && this.startUpType == toolAppInfo.startUpType;
        }

        public int hashCode() {
            return (((((((this.activityName.hashCode() * 31) + Integer.hashCode(this.id)) * 31) + this.name.hashCode()) * 31) + this.pkg.hashCode()) * 31) + Integer.hashCode(this.startUpType);
        }

        public String toString() {
            return "ToolAppInfo(activityName=" + this.activityName + ", id=" + this.id + ", name=" + this.name + ", pkg=" + this.pkg + ", startUpType=" + this.startUpType + ')';
        }

        public ToolAppInfo(String str, int i, String str2, String str3, int i2) {
            Intrinsics.checkNotNullParameter(str, "activityName");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "pkg");
            this.activityName = str;
            this.id = i;
            this.name = str2;
            this.pkg = str3;
            this.startUpType = i2;
        }

        public final String getActivityName() {
            return this.activityName;
        }

        public final void setActivityName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.activityName = str;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getPkg() {
            return this.pkg;
        }

        public final void setPkg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pkg = str;
        }

        public final int getStartUpType() {
            return this.startUpType;
        }

        public final void setStartUpType(int i) {
            this.startUpType = i;
        }
    }

    /* JADX INFO: compiled from: LaunchConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006#"}, d2 = {"Lcom/dw/launcher/data/entity/LaunchConfig$ToolAppInfoMb;", BuildConfig.FLAVOR, "activityName", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "name", "pkg", "startUpType", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getName", "setName", "getPkg", "setPkg", "getStartUpType", "setStartUpType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ToolAppInfoMb {
        private String activityName;
        private int id;
        private String name;
        private String pkg;
        private int startUpType;

        public static /* synthetic */ ToolAppInfoMb copy$default(ToolAppInfoMb toolAppInfoMb, String str, int i, String str2, String str3, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = toolAppInfoMb.activityName;
            }
            if ((i3 & 2) != 0) {
                i = toolAppInfoMb.id;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                str2 = toolAppInfoMb.name;
            }
            String str4 = str2;
            if ((i3 & 8) != 0) {
                str3 = toolAppInfoMb.pkg;
            }
            String str5 = str3;
            if ((i3 & 16) != 0) {
                i2 = toolAppInfoMb.startUpType;
            }
            return toolAppInfoMb.copy(str, i4, str4, str5, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getActivityName() {
            return this.activityName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getPkg() {
            return this.pkg;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getStartUpType() {
            return this.startUpType;
        }

        public final ToolAppInfoMb copy(String activityName, int id, String name, String pkg, int startUpType) {
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(pkg, "pkg");
            return new ToolAppInfoMb(activityName, id, name, pkg, startUpType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ToolAppInfoMb)) {
                return false;
            }
            ToolAppInfoMb toolAppInfoMb = (ToolAppInfoMb) other;
            return Intrinsics.areEqual(this.activityName, toolAppInfoMb.activityName) && this.id == toolAppInfoMb.id && Intrinsics.areEqual(this.name, toolAppInfoMb.name) && Intrinsics.areEqual(this.pkg, toolAppInfoMb.pkg) && this.startUpType == toolAppInfoMb.startUpType;
        }

        public int hashCode() {
            return (((((((this.activityName.hashCode() * 31) + Integer.hashCode(this.id)) * 31) + this.name.hashCode()) * 31) + this.pkg.hashCode()) * 31) + Integer.hashCode(this.startUpType);
        }

        public String toString() {
            return "ToolAppInfoMb(activityName=" + this.activityName + ", id=" + this.id + ", name=" + this.name + ", pkg=" + this.pkg + ", startUpType=" + this.startUpType + ')';
        }

        public ToolAppInfoMb(String str, int i, String str2, String str3, int i2) {
            Intrinsics.checkNotNullParameter(str, "activityName");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "pkg");
            this.activityName = str;
            this.id = i;
            this.name = str2;
            this.pkg = str3;
            this.startUpType = i2;
        }

        public final String getActivityName() {
            return this.activityName;
        }

        public final void setActivityName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.activityName = str;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getPkg() {
            return this.pkg;
        }

        public final void setPkg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pkg = str;
        }

        public final int getStartUpType() {
            return this.startUpType;
        }

        public final void setStartUpType(int i) {
            this.startUpType = i;
        }
    }

    /* JADX INFO: compiled from: LaunchConfig.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/dw/launcher/data/entity/LaunchConfig$FilterAppInfo;", BuildConfig.FLAVOR, "activityName", BuildConfig.FLAVOR, "name", "pkg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "getName", "setName", "getPkg", "setPkg", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class FilterAppInfo {
        private String activityName;
        private String name;
        private String pkg;

        public static /* synthetic */ FilterAppInfo copy$default(FilterAppInfo filterAppInfo, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = filterAppInfo.activityName;
            }
            if ((i & 2) != 0) {
                str2 = filterAppInfo.name;
            }
            if ((i & 4) != 0) {
                str3 = filterAppInfo.pkg;
            }
            return filterAppInfo.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getActivityName() {
            return this.activityName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPkg() {
            return this.pkg;
        }

        public final FilterAppInfo copy(String activityName, String name, String pkg) {
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(pkg, "pkg");
            return new FilterAppInfo(activityName, name, pkg);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FilterAppInfo)) {
                return false;
            }
            FilterAppInfo filterAppInfo = (FilterAppInfo) other;
            return Intrinsics.areEqual(this.activityName, filterAppInfo.activityName) && Intrinsics.areEqual(this.name, filterAppInfo.name) && Intrinsics.areEqual(this.pkg, filterAppInfo.pkg);
        }

        public int hashCode() {
            return (((this.activityName.hashCode() * 31) + this.name.hashCode()) * 31) + this.pkg.hashCode();
        }

        public String toString() {
            return "FilterAppInfo(activityName=" + this.activityName + ", name=" + this.name + ", pkg=" + this.pkg + ')';
        }

        public FilterAppInfo(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "activityName");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "pkg");
            this.activityName = str;
            this.name = str2;
            this.pkg = str3;
        }

        public final String getActivityName() {
            return this.activityName;
        }

        public final void setActivityName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.activityName = str;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getPkg() {
            return this.pkg;
        }

        public final void setPkg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pkg = str;
        }
    }

    /* JADX INFO: compiled from: LaunchConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/dw/launcher/data/entity/LaunchConfig$OrderAppInfo;", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "actName", "(ILjava/lang/String;Ljava/lang/String;)V", "getActName", "()Ljava/lang/String;", "setActName", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getName", "setName", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class OrderAppInfo {
        private String actName;
        private int id;
        private String name;

        public static /* synthetic */ OrderAppInfo copy$default(OrderAppInfo orderAppInfo, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = orderAppInfo.id;
            }
            if ((i2 & 2) != 0) {
                str = orderAppInfo.name;
            }
            if ((i2 & 4) != 0) {
                str2 = orderAppInfo.actName;
            }
            return orderAppInfo.copy(i, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getActName() {
            return this.actName;
        }

        public final OrderAppInfo copy(int id, String name, String actName) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(actName, "actName");
            return new OrderAppInfo(id, name, actName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OrderAppInfo)) {
                return false;
            }
            OrderAppInfo orderAppInfo = (OrderAppInfo) other;
            return this.id == orderAppInfo.id && Intrinsics.areEqual(this.name, orderAppInfo.name) && Intrinsics.areEqual(this.actName, orderAppInfo.actName);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.actName.hashCode();
        }

        public String toString() {
            return "OrderAppInfo(id=" + this.id + ", name=" + this.name + ", actName=" + this.actName + ')';
        }

        public OrderAppInfo(int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "actName");
            this.id = i;
            this.name = str;
            this.actName = str2;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getActName() {
            return this.actName;
        }

        public final void setActName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.actName = str;
        }
    }

    /* JADX INFO: compiled from: LaunchConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/dw/launcher/data/entity/LaunchConfig$WatchInfo;", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "(ILjava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class WatchInfo {
        private int id;
        private String name;

        public static /* synthetic */ WatchInfo copy$default(WatchInfo watchInfo, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = watchInfo.id;
            }
            if ((i2 & 2) != 0) {
                str = watchInfo.name;
            }
            return watchInfo.copy(i, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final WatchInfo copy(int id, String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new WatchInfo(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WatchInfo)) {
                return false;
            }
            WatchInfo watchInfo = (WatchInfo) other;
            return this.id == watchInfo.id && Intrinsics.areEqual(this.name, watchInfo.name);
        }

        public int hashCode() {
            return (Integer.hashCode(this.id) * 31) + this.name.hashCode();
        }

        public String toString() {
            return "WatchInfo(id=" + this.id + ", name=" + this.name + ')';
        }

        public WatchInfo(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.id = i;
            this.name = str;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }
    }

    /* JADX INFO: compiled from: LaunchConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/dw/launcher/data/entity/LaunchConfig$ThemeCardInfo;", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "(ILjava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ThemeCardInfo {
        private int id;
        private String name;

        public static /* synthetic */ ThemeCardInfo copy$default(ThemeCardInfo themeCardInfo, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = themeCardInfo.id;
            }
            if ((i2 & 2) != 0) {
                str = themeCardInfo.name;
            }
            return themeCardInfo.copy(i, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final ThemeCardInfo copy(int id, String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new ThemeCardInfo(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThemeCardInfo)) {
                return false;
            }
            ThemeCardInfo themeCardInfo = (ThemeCardInfo) other;
            return this.id == themeCardInfo.id && Intrinsics.areEqual(this.name, themeCardInfo.name);
        }

        public int hashCode() {
            return (Integer.hashCode(this.id) * 31) + this.name.hashCode();
        }

        public String toString() {
            return "ThemeCardInfo(id=" + this.id + ", name=" + this.name + ')';
        }

        public ThemeCardInfo(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.id = i;
            this.name = str;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }
    }

    /* JADX INFO: compiled from: LaunchConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/dw/launcher/data/entity/LaunchConfig$SlideMenuApp;", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "pkg", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPkg", "setPkg", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SlideMenuApp {
        private int id;
        private String name;
        private String pkg;

        public static /* synthetic */ SlideMenuApp copy$default(SlideMenuApp slideMenuApp, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = slideMenuApp.id;
            }
            if ((i2 & 2) != 0) {
                str = slideMenuApp.name;
            }
            if ((i2 & 4) != 0) {
                str2 = slideMenuApp.pkg;
            }
            return slideMenuApp.copy(i, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPkg() {
            return this.pkg;
        }

        public final SlideMenuApp copy(int id, String name, String pkg) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(pkg, "pkg");
            return new SlideMenuApp(id, name, pkg);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SlideMenuApp)) {
                return false;
            }
            SlideMenuApp slideMenuApp = (SlideMenuApp) other;
            return this.id == slideMenuApp.id && Intrinsics.areEqual(this.name, slideMenuApp.name) && Intrinsics.areEqual(this.pkg, slideMenuApp.pkg);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.pkg.hashCode();
        }

        public String toString() {
            return "SlideMenuApp(id=" + this.id + ", name=" + this.name + ", pkg=" + this.pkg + ')';
        }

        public SlideMenuApp(int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "pkg");
            this.id = i;
            this.name = str;
            this.pkg = str2;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getPkg() {
            return this.pkg;
        }

        public final void setPkg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pkg = str;
        }
    }

    /* JADX INFO: compiled from: LaunchConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/dw/launcher/data/entity/LaunchConfig$StatusBarFunctionList;", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "enable", "(ILjava/lang/String;I)V", "getEnable", "()I", "setEnable", "(I)V", "getId", "setId", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class StatusBarFunctionList {
        private int enable;
        private int id;
        private String name;

        public static /* synthetic */ StatusBarFunctionList copy$default(StatusBarFunctionList statusBarFunctionList, int i, String str, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = statusBarFunctionList.id;
            }
            if ((i3 & 2) != 0) {
                str = statusBarFunctionList.name;
            }
            if ((i3 & 4) != 0) {
                i2 = statusBarFunctionList.enable;
            }
            return statusBarFunctionList.copy(i, str, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getEnable() {
            return this.enable;
        }

        public final StatusBarFunctionList copy(int id, String name, int enable) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new StatusBarFunctionList(id, name, enable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StatusBarFunctionList)) {
                return false;
            }
            StatusBarFunctionList statusBarFunctionList = (StatusBarFunctionList) other;
            return this.id == statusBarFunctionList.id && Intrinsics.areEqual(this.name, statusBarFunctionList.name) && this.enable == statusBarFunctionList.enable;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.enable);
        }

        public String toString() {
            return "StatusBarFunctionList(id=" + this.id + ", name=" + this.name + ", enable=" + this.enable + ')';
        }

        public StatusBarFunctionList(int i, String str, int i2) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.id = i;
            this.name = str;
            this.enable = i2;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final int getEnable() {
            return this.enable;
        }

        public final void setEnable(int i) {
            this.enable = i;
        }
    }
}
