package com.dw.launcher.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dw.launcher.R;
import com.dw.launcher.data.entity.Image;
import com.dw.launcher.data.entity.SysKeyEvent;
import com.dw.launcher.data.preference.LauncherPreference;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;
import top.zibin.luban.OnRenameListener;

/* JADX INFO: compiled from: CustomWallPaperActivity.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0016J!\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u0016H\u0016J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020,H\u0014J\u0016\u00105\u001a\u00020,2\u0006\u0010\"\u001a\u00020!2\u0006\u00106\u001a\u000207J\u0010\u00108\u001a\u00020,2\b\u00109\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lcom/dw/launcher/ui/activity/CustomWallPaperActivity;", "Lcom/dw/launcher/base/BaseActivity;", "()V", "backGround", "Landroid/widget/ImageView;", "fileName", "", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "preference", "Lcom/dw/launcher/data/preference/LauncherPreference;", "getPreference", "()Lcom/dw/launcher/data/preference/LauncherPreference;", "setPreference", "(Lcom/dw/launcher/data/preference/LauncherPreference;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "relativeLayout", "Landroid/widget/RelativeLayout;", "selectIndex", "", "sysKeyEvent", "Lcom/dw/launcher/data/entity/SysKeyEvent;", "getSysKeyEvent", "()Lcom/dw/launcher/data/entity/SysKeyEvent;", "setSysKeyEvent", "(Lcom/dw/launcher/data/entity/SysKeyEvent;)V", "txtCancel", "Landroid/widget/TextView;", "txtConfirm", "cropBitmap", "Landroid/graphics/Bitmap;", "bitmap", "aspectRatioX", "aspectRatioY", "fetchImages", "Ljava/util/ArrayList;", "Lcom/dw/launcher/data/entity/Image;", "Lkotlin/collections/ArrayList;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onKeyUp", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onStop", "saveBitmap", "file", "Ljava/io/File;", "toJustIntent", "filePath", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class CustomWallPaperActivity extends Hilt_CustomWallPaperActivity {
    private ImageView backGround;

    @Inject
    public LauncherPreference preference;
    private RecyclerView recyclerView;
    private RelativeLayout relativeLayout;

    @Inject
    public SysKeyEvent sysKeyEvent;
    private TextView txtCancel;
    private TextView txtConfirm;
    private String fileName = "customWallpaper";
    private int selectIndex = -1;

    public final SysKeyEvent getSysKeyEvent() {
        SysKeyEvent sysKeyEvent = this.sysKeyEvent;
        if (sysKeyEvent != null) {
            return sysKeyEvent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sysKeyEvent");
        return null;
    }

    public final void setSysKeyEvent(SysKeyEvent sysKeyEvent) {
        Intrinsics.checkNotNullParameter(sysKeyEvent, "<set-?>");
        this.sysKeyEvent = sysKeyEvent;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final void setFileName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fileName = str;
    }

    public final LauncherPreference getPreference() {
        LauncherPreference launcherPreference = this.preference;
        if (launcherPreference != null) {
            return launcherPreference;
        }
        Intrinsics.throwUninitializedPropertyAccessException("preference");
        return null;
    }

    public final void setPreference(LauncherPreference launcherPreference) {
        Intrinsics.checkNotNullParameter(launcherPreference, "<set-?>");
        this.preference = launcherPreference;
    }

    public int getLayoutId() {
        return R.layout.activity_selectwatch;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.dw.launcher.ui.activity.Hilt_CustomWallPaperActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerViewFindViewById = findViewById(R.id.recyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(...)");
        this.recyclerView = recyclerViewFindViewById;
        View viewFindViewById = findViewById(R.id.rlPhoto);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.relativeLayout = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.backGround);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.backGround = (ImageView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.txtCancel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.txtCancel = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.txtConfirm);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.txtConfirm = (TextView) viewFindViewById4;
        final ArrayList arrayList = new ArrayList();
        RecyclerView.Adapter customWallPaperActivity$onCreate$adapter$1 = new CustomWallPaperActivity$onCreate$adapter$1(this, R.layout.item_photo);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new GridLayoutManager((Context) this, 2, 1, false));
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setAdapter(customWallPaperActivity$onCreate$adapter$1);
        customWallPaperActivity$onCreate$adapter$1.setNewInstance(arrayList);
        TextView textView = this.txtCancel;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("txtCancel");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.CustomWallPaperActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomWallPaperActivity.onCreate$lambda$0(this.f$0, view);
            }
        });
        TextView textView2 = this.txtConfirm;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("txtConfirm");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.activity.CustomWallPaperActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IOException {
                CustomWallPaperActivity.onCreate$lambda$2(this.f$0, arrayList, view);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass3(arrayList, this, customWallPaperActivity$onCreate$adapter$1, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(CustomWallPaperActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RelativeLayout relativeLayout = this$0.relativeLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("relativeLayout");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onCreate$lambda$2(final CustomWallPaperActivity this$0, final ArrayList imageList, View view) throws IOException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(imageList, "$imageList");
        int i = this$0.selectIndex;
        if (i != -1) {
            final String path = ((Image) imageList.get(i)).getPath();
            File externalFilesDir = this$0.getExternalFilesDir("customWallPaper");
            if (externalFilesDir != null && !externalFilesDir.exists() && externalFilesDir != null) {
                externalFilesDir.mkdirs();
            }
            String absolutePath = externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(path);
            Intrinsics.checkNotNull(bitmapDecodeFile);
            Resources resources = this$0.getResources();
            Intrinsics.checkNotNull(resources);
            int i2 = resources.getDisplayMetrics().widthPixels;
            Resources resources2 = this$0.getResources();
            Intrinsics.checkNotNull(resources2);
            Bitmap bitmapCropBitmap = this$0.cropBitmap(bitmapDecodeFile, i2, resources2.getDisplayMetrics().heightPixels);
            final File file = new File(absolutePath, "cropped_" + System.currentTimeMillis() + ".jpg");
            this$0.saveBitmap(bitmapCropBitmap, file);
            Luban.with((Context) this$0).load(file.getAbsolutePath()).ignoreBy(0).setTargetDir(absolutePath).setRenameListener(new OnRenameListener() { // from class: com.dw.launcher.ui.activity.CustomWallPaperActivity$$ExternalSyntheticLambda2
                @Override // top.zibin.luban.OnRenameListener
                public final String rename(String str) {
                    return CustomWallPaperActivity.onCreate$lambda$2$lambda$1(this.f$0, str);
                }
            }).setCompressListener(new OnCompressListener() { // from class: com.dw.launcher.ui.activity.CustomWallPaperActivity$onCreate$2$2
                @Override // top.zibin.luban.OnCompressListener
                public void onStart() {
                }

                @Override // top.zibin.luban.OnCompressListener
                public void onSuccess(File file2) {
                    Timber.INSTANCE.d("path = " + path + "  处理前：" + imageList.get(this$0.selectIndex).getPath() + "    fileName:" + (file2 != null ? file2.getAbsolutePath() : null), new Object[0]);
                    if (file.exists()) {
                        file.delete();
                    }
                    this$0.toJustIntent(file2 != null ? file2.getAbsolutePath() : null);
                }

                @Override // top.zibin.luban.OnCompressListener
                public void onError(Throwable e) {
                    if (e != null) {
                        e.printStackTrace();
                    }
                }
            }).launch();
            return;
        }
        this$0.toJustIntent(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onCreate$lambda$2$lambda$1(CustomWallPaperActivity this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return "ID_" + this$0.fileName + ".jpg";
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.activity.CustomWallPaperActivity$onCreate$3, reason: invalid class name */
    /* JADX INFO: compiled from: CustomWallPaperActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.ui.activity.CustomWallPaperActivity$onCreate$3", f = "CustomWallPaperActivity.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CustomWallPaperActivity$onCreate$adapter$1 $adapter;
        final /* synthetic */ ArrayList<Image> $imageList;
        Object L$0;
        int label;
        final /* synthetic */ CustomWallPaperActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ArrayList<Image> arrayList, CustomWallPaperActivity customWallPaperActivity, CustomWallPaperActivity$onCreate$adapter$1 customWallPaperActivity$onCreate$adapter$1, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$imageList = arrayList;
            this.this$0 = customWallPaperActivity;
            this.$adapter = customWallPaperActivity$onCreate$adapter$1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$imageList, this.this$0, this.$adapter, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ArrayList<Image> arrayList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ArrayList<Image> arrayList2 = this.$imageList;
                this.L$0 = arrayList2;
                this.label = 1;
                Object objFetchImages = this.this$0.fetchImages(this);
                if (objFetchImages == coroutine_suspended) {
                    return coroutine_suspended;
                }
                arrayList = arrayList2;
                obj = objFetchImages;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                arrayList = (ArrayList) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            arrayList.addAll((Collection) obj);
            this.$adapter.notifyDataSetChanged();
            return Unit.INSTANCE;
        }
    }

    public final Bitmap cropBitmap(Bitmap bitmap, int aspectRatioX, int aspectRatioY) {
        int i;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = aspectRatioX / aspectRatioY;
        float f2 = width;
        float f3 = height;
        int i2 = 0;
        if (f2 / f3 > f) {
            int i3 = (int) (f3 * f);
            int i4 = (width - i3) / 2;
            width = i3;
            i = 0;
            i2 = i4;
        } else {
            int i5 = (int) (f2 / f);
            int i6 = (height - i5) / 2;
            height = i5;
            i = i6;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i2, i, width, height);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    public final void saveBitmap(Bitmap bitmap, File file) throws IOException {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(file, "file");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public final void toJustIntent(String filePath) {
        Intent intent = new Intent();
        intent.putExtra("customWallPaperPath", filePath);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: renamed from: com.dw.launcher.ui.activity.CustomWallPaperActivity$fetchImages$2, reason: invalid class name */
    /* JADX INFO: compiled from: CustomWallPaperActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/dw/launcher/data/entity/Image;", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    @DebugMetadata(c = "com.dw.launcher.ui.activity.CustomWallPaperActivity$fetchImages$2", f = "CustomWallPaperActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<Image>>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CustomWallPaperActivity.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArrayList<Image>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            Cursor cursorQuery = CustomWallPaperActivity.this.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, "_id desc");
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                while (cursorQuery.moveToNext()) {
                    int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
                    int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("_id");
                    int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("date_modified");
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    int i = cursorQuery.getInt(columnIndexOrThrow2);
                    long j = cursorQuery.getLong(columnIndexOrThrow3);
                    if (new File(string).exists()) {
                        Image image = new Image();
                        image.setType(0);
                        image.setPath(string);
                        image.setImg_id(i);
                        image.setData_modified(j);
                        arrayList.add(image);
                        Timber.INSTANCE.d("imagePath = " + string, new Object[0]);
                    }
                }
                cursorQuery.close();
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchImages(Continuation<? super ArrayList<Image>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }

    protected void onStop() {
        super.onStop();
        finish();
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == getSysKeyEvent().getSingleKeyCode()) {
            finish();
        }
        return super.onKeyUp(keyCode, event);
    }
}
