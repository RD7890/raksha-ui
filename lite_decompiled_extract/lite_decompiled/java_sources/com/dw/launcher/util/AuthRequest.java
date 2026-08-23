package com.dw.launcher.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.dw.launcher.R;
import com.google.android.mms.pdu.CharacterSets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.ConstantsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

/* JADX INFO: compiled from: AuthRequest.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018Jc\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00160 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/dw/launcher/util/AuthRequest;", "", "()V", "SERVERURL", "", "TAG", "getTAG", "()Ljava/lang/String;", "TENCENT_SERVER_URL", "dialog", "Landroid/app/AlertDialog;", "getDialog", "()Landroid/app/AlertDialog;", "setDialog", "(Landroid/app/AlertDialog;)V", "generateMD5Signature", "appId", "appSecret", "imei", "timestamp", "", "showAuthorDialog", "", "context", "Landroid/content/Context;", "tencentLicenseRequest", "sn", "type", "", "needDelay", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "body", "code", "(Ljava/lang/String;IZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class AuthRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String INVALIDE_IMEI = "888888888888888";
    public static final String appId = "1001224780";
    public static final String appSerect = "EF14FD9E-3EEB-4289-8D0D-310B52868207";
    private AlertDialog dialog;
    private final String TAG = "PedoLicenseUtils";
    private final String SERVERURL = "https://license-center.mobvoi.com/v2/license";
    private final String TENCENT_SERVER_URL = "http://wxapi.divoiotcloud.com/api/Wechat/RegDevice";

    /* JADX INFO: renamed from: com.dw.launcher.util.AuthRequest$tencentLicenseRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthRequest.kt */
    @Metadata(k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.util.AuthRequest", f = "AuthRequest.kt", i = {}, l = {65}, m = "tencentLicenseRequest", n = {}, s = {})
    static final class C00241 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00241(Continuation<? super C00241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= IntCompanionObject.MIN_VALUE;
            return AuthRequest.this.tencentLicenseRequest(null, 0, false, null, this);
        }
    }

    public final String getTAG() {
        return this.TAG;
    }

    /* JADX INFO: compiled from: AuthRequest.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/dw/launcher/util/AuthRequest$Companion;", "", "()V", "INVALIDE_IMEI", "", "appId", "appSerect", "getDeviceId", "context", "Landroid/content/Context;", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getDeviceId(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            String deviceId = ((TelephonyManager) systemService).getDeviceId();
            if (TextUtils.isEmpty(deviceId)) {
                return AuthRequest.INVALIDE_IMEI;
            }
            Intrinsics.checkNotNull(deviceId);
            return deviceId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String generateMD5Signature(String appId2, String appSecret, String imei, long timestamp) throws NoSuchAlgorithmException {
        String str = appId2 + appSecret + imei + timestamp;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics.checkNotNull(bArrDigest);
        String upperCase = ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.dw.launcher.util.AuthRequest.generateMD5Signature.1
            public final CharSequence invoke(byte b) {
                String str2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return str2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                return invoke(b.byteValue());
            }
        }, 30, (Object) null).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public static /* synthetic */ Object tencentLicenseRequest$default(AuthRequest authRequest, String str, int i, boolean z, Function2 function2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return authRequest.tencentLicenseRequest(str, i, z, function2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object tencentLicenseRequest(String str, int i, boolean z, Function2<? super String, ? super Integer, Unit> function2, Continuation<? super Unit> continuation) {
        C00241 c00241;
        if (continuation instanceof C00241) {
            c00241 = (C00241) continuation;
            if ((c00241.label & IntCompanionObject.MIN_VALUE) != 0) {
                c00241.label -= IntCompanionObject.MIN_VALUE;
            } else {
                c00241 = new C00241(continuation);
            }
        } else {
            c00241 = new C00241(continuation);
        }
        Object obj = c00241.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c00241.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io = Dispatchers.getIO();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(str, z, i, function2, null);
                c00241.label = 1;
                if (BuildersKt.withContext(io, anonymousClass2, c00241) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.dw.launcher.util.AuthRequest$tencentLicenseRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: AuthRequest.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.util.AuthRequest$tencentLicenseRequest$2", f = "AuthRequest.kt", i = {0, 0, 0, 1}, l = {94, 97}, m = "invokeSuspend", n = {"connection", "response", "responseCode", "connection"}, s = {"L$0", "L$1", "I$0", "L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<String, Integer, Unit> $callback;
        final /* synthetic */ boolean $needDelay;
        final /* synthetic */ String $sn;
        final /* synthetic */ int $type;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(String str, boolean z, int i, Function2<? super String, ? super Integer, Unit> function2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$sn = str;
            this.$needDelay = z;
            this.$type = i;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AuthRequest.this.new AnonymousClass2(this.$sn, this.$needDelay, this.$type, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0177 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:30:0x0178  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws JSONException, NoSuchAlgorithmException, IOException {
            HttpURLConnection httpURLConnection;
            int responseCode;
            String text;
            HttpURLConnection httpURLConnection2;
            int i;
            String str;
            HttpURLConnection httpURLConnection3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                long jUptimeMillis = SystemClock.uptimeMillis();
                URLConnection uRLConnectionOpenConnection = new URL(AuthRequest.this.TENCENT_SERVER_URL).openConnection();
                Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setDoOutput(true);
                long jCurrentTimeMillis = System.currentTimeMillis() / ((long) CharacterSets.UCS2);
                String strGenerateMD5Signature = AuthRequest.this.generateMD5Signature(AuthRequest.appId, AuthRequest.appSerect, this.$sn, jCurrentTimeMillis);
                JSONObject jSONObject = new JSONObject();
                String str2 = this.$sn;
                int i3 = this.$type;
                jSONObject.put("Imei", str2);
                jSONObject.put("Type", i3);
                jSONObject.put("Timestamp", jCurrentTimeMillis);
                jSONObject.put("AppId", AuthRequest.appId);
                jSONObject.put("Sign", strGenerateMD5Signature);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    String string = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    byte[] bytes = string.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    outputStream.write(bytes);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(outputStream, null);
                    responseCode = httpURLConnection.getResponseCode();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                    Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, ConstantsKt.DEFAULT_BUFFER_SIZE);
                    try {
                        text = TextStreamsKt.readText(bufferedReader);
                        CloseableKt.closeFinally(bufferedReader, null);
                        System.out.println((Object) (AuthRequest.this.getTAG() + ": tencentLicenseRequest: response.body() " + text + "\n response.code() " + responseCode + "\n response.message() " + httpURLConnection.getResponseMessage()));
                        if (this.$needDelay && SystemClock.uptimeMillis() - jUptimeMillis < 2000) {
                            this.L$0 = httpURLConnection;
                            this.L$1 = text;
                            this.I$0 = responseCode;
                            this.label = 1;
                            if (DelayKt.delay(((long) 2000) - (SystemClock.uptimeMillis() - jUptimeMillis), this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            httpURLConnection2 = httpURLConnection;
                            i = responseCode;
                            str = text;
                        }
                        this.L$0 = httpURLConnection;
                        this.L$1 = null;
                        this.label = 2;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new C00042(this.$callback, text, responseCode, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        httpURLConnection3 = httpURLConnection;
                        httpURLConnection3.disconnect();
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(bufferedReader, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(outputStream, th3);
                        throw th4;
                    }
                }
            }
            if (i2 == 1) {
                i = this.I$0;
                str = (String) this.L$1;
                httpURLConnection2 = (HttpURLConnection) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                httpURLConnection3 = (HttpURLConnection) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            httpURLConnection3.disconnect();
            return Unit.INSTANCE;
            responseCode = i;
            text = str;
            httpURLConnection = httpURLConnection2;
            this.L$0 = httpURLConnection;
            this.L$1 = null;
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C00042(this.$callback, text, responseCode, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            httpURLConnection3 = httpURLConnection;
            httpURLConnection3.disconnect();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.dw.launcher.util.AuthRequest$tencentLicenseRequest$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AuthRequest.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
        @DebugMetadata(c = "com.dw.launcher.util.AuthRequest$tencentLicenseRequest$2$2", f = "AuthRequest.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00042 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<String, Integer, Unit> $callback;
            final /* synthetic */ String $response;
            final /* synthetic */ int $responseCode;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00042(Function2<? super String, ? super Integer, Unit> function2, String str, int i, Continuation<? super C00042> continuation) {
                super(2, continuation);
                this.$callback = function2;
                this.$response = str;
                this.$responseCode = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00042(this.$callback, this.$response, this.$responseCode, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00042) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$callback.invoke(this.$response, Boxing.boxInt(this.$responseCode));
                return Unit.INSTANCE;
            }
        }
    }

    public final AlertDialog getDialog() {
        return this.dialog;
    }

    public final void setDialog(AlertDialog alertDialog) {
        this.dialog = alertDialog;
    }

    public final void showAuthorDialog(Context context) {
        Window window;
        Intrinsics.checkNotNullParameter(context, "context");
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            this.dialog = null;
        }
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setTitle("").setMessage(context.getString(R.string.authoring)).setView(progressBar).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null).create();
        this.dialog = alertDialogCreate;
        if (alertDialogCreate != null && (window = alertDialogCreate.getWindow()) != null) {
            window.setType(2038);
        }
        AlertDialog alertDialog2 = this.dialog;
        if (alertDialog2 != null) {
            alertDialog2.show();
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new C00231(context, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.dw.launcher.util.AuthRequest$showAuthorDialog$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthRequest.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.util.AuthRequest$showAuthorDialog$1", f = "AuthRequest.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
    static final class C00231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AuthRequest this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00231(Context context, AuthRequest authRequest, Continuation<? super C00231> continuation) {
            super(2, continuation);
            this.$context = context;
            this.this$0 = authRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00231 c00231 = new C00231(this.$context, this.this$0, continuation);
            c00231.L$0 = obj;
            return c00231;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                AuthRequest authRequest = new AuthRequest();
                String deviceId = AuthRequest.INSTANCE.getDeviceId(this.$context);
                final Context context = this.$context;
                final AuthRequest authRequest2 = this.this$0;
                this.label = 1;
                if (authRequest.tencentLicenseRequest(deviceId, 0, true, new Function2<String, Integer, Unit>() { // from class: com.dw.launcher.util.AuthRequest.showAuthorDialog.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
                        invoke(str, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String response, int i2) {
                        Intrinsics.checkNotNullParameter(response, "response");
                        Context context2 = context;
                        AuthRequest authRequest3 = authRequest2;
                        Timber.INSTANCE.d("response=" + response + ",code=" + i2, new Object[0]);
                        if (i2 == 200) {
                            try {
                                JSONObject jSONObject = new JSONObject(response);
                                if (jSONObject.optInt("ErrCode", 0) == 0) {
                                    String string = jSONObject.getString("Uniqueid");
                                    String string2 = jSONObject.getString("Lisense");
                                    Settings.Global.putString(context2.getContentResolver(), "ilink_device_id", string);
                                    Settings.Global.putString(context2.getContentResolver(), "ilink_device_signature", string2);
                                    Settings.Global.putInt(context2.getContentResolver(), "ilink_product_id", 4747);
                                    Settings.Global.putInt(context2.getContentResolver(), "ilink_key_version", 1);
                                    Timber.INSTANCE.d("公钥=" + string + ",签名=" + string2, new Object[0]);
                                    AlertDialog dialog = authRequest3.getDialog();
                                    if (dialog != null) {
                                        dialog.dismiss();
                                    }
                                    Toast.makeText(context2, context2.getString(R.string.authoring_success), 0).show();
                                    return;
                                }
                                return;
                            } catch (JSONException e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        AlertDialog dialog2 = authRequest3.getDialog();
                        if (dialog2 != null) {
                            dialog2.dismiss();
                        }
                        Toast.makeText(context2, context2.getString(R.string.authoring_fail), 0).show();
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
