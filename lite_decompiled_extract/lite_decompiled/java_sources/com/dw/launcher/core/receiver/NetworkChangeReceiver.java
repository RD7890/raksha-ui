package com.dw.launcher.core.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.util.Log;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import com.dw.launcher.data.config.PackageNameConstant;
import com.dw.launcher.util.AuthRequest;
import com.dw.launcher.util.SystemUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

/* JADX INFO: compiled from: NetworkChangeReceiver.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/dw/launcher/core/receiver/NetworkChangeReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_version8Release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NetworkChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            Log.d("NetworkChangeReceiver", "Network is disconnected");
            return;
        }
        if (SystemUtils.INSTANCE.isActivityAvailable(context, PackageNameConstant.PACKAGE_NAME_WECHAT, "com.tencent.wechatkids.ui.start.SplashActivity")) {
            Timber.Forest.d("已安装学生微信", new Object[0]);
            String string = Settings.Global.getString(context.getContentResolver(), "ilink_device_id");
            String string2 = Settings.Global.getString(context.getContentResolver(), "ilink_device_signature");
            String str2 = string;
            if (str2 == null || str2.length() == 0 || (str = string2) == null || str.length() == 0) {
                Log.d("NetworkChangeReceiver", "Network is connected");
                String deviceId = AuthRequest.Companion.getDeviceId(context);
                Timber.Forest.d("authRequest=" + deviceId, new Object[0]);
                if (Intrinsics.areEqual(deviceId, "888888888888888")) {
                    return;
                }
                BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(deviceId, context, null), 3, (Object) null);
            }
        }
    }

    /* JADX INFO: renamed from: com.dw.launcher.core.receiver.NetworkChangeReceiver$onReceive$1, reason: invalid class name */
    /* JADX INFO: compiled from: NetworkChangeReceiver.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.core.receiver.NetworkChangeReceiver$onReceive$1", f = "NetworkChangeReceiver.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $authRequest;
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Context context, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$authRequest = str;
            this.$context = context;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$authRequest, this.$context, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                AuthRequest authRequest = new AuthRequest();
                String str = this.$authRequest;
                final Context context = this.$context;
                this.label = 1;
                if (AuthRequest.tencentLicenseRequest$default(authRequest, str, 0, false, new Function2<String, Integer, Unit>() { // from class: com.dw.launcher.core.receiver.NetworkChangeReceiver.onReceive.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((String) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String str2, int i2) {
                        Intrinsics.checkNotNullParameter(str2, "response");
                        Context context2 = context;
                        Timber.Forest.d("response=" + str2 + ",code=" + i2, new Object[0]);
                        if (i2 == 200) {
                            try {
                                JSONObject jSONObject = new JSONObject(str2);
                                if (jSONObject.optInt("ErrCode", 0) == 0) {
                                    String string = jSONObject.getString("Uniqueid");
                                    String string2 = jSONObject.getString("Lisense");
                                    Settings.Global.putString(context2.getContentResolver(), "ilink_device_id", string);
                                    Settings.Global.putString(context2.getContentResolver(), "ilink_device_signature", string2);
                                    Timber.Forest.d("公钥=" + string + ",签名=" + string2, new Object[0]);
                                    Settings.Global.putInt(context2.getContentResolver(), "ilink_product_id", 4747);
                                    Settings.Global.putInt(context2.getContentResolver(), "ilink_key_version", 1);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, (Continuation) this, 4, (Object) null) == coroutine_suspended) {
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
