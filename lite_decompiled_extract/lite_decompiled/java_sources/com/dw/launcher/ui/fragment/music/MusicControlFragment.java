package com.dw.launcher.ui.fragment.music;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.dw.launcher.R;
import com.dw.launcher.core.component.PlayCallbackComponent;
import com.dw.launcher.ui.view.ScrollableSeekBar;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: MusicControlFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020\u001fH\u0016J\b\u0010%\u001a\u00020\u001fH\u0016J\u001a\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006."}, d2 = {"Lcom/dw/launcher/ui/fragment/music/MusicControlFragment;", "Lcom/dw/launcher/base/BaseFragment;", "Lcom/dw/launcher/core/component/PlayCallbackComponent$OnPlayCallbackListener;", "()V", "ivPlayOrPause", "Landroid/widget/ImageView;", "getIvPlayOrPause", "()Landroid/widget/ImageView;", "setIvPlayOrPause", "(Landroid/widget/ImageView;)V", "ivVolumAdd", "getIvVolumAdd", "setIvVolumAdd", "ivVolumDec", "getIvVolumDec", "setIvVolumDec", "mPlayCallbackComponent", "Lcom/dw/launcher/core/component/PlayCallbackComponent;", "getMPlayCallbackComponent", "()Lcom/dw/launcher/core/component/PlayCallbackComponent;", "setMPlayCallbackComponent", "(Lcom/dw/launcher/core/component/PlayCallbackComponent;)V", "seekBar", "Lcom/dw/launcher/ui/view/ScrollableSeekBar;", "getSeekBar", "()Lcom/dw/launcher/ui/view/ScrollableSeekBar;", "setSeekBar", "(Lcom/dw/launcher/ui/view/ScrollableSeekBar;)V", "getLayoutId", "", "onAttach", "", "context", "Landroid/content/Context;", "onDetach", "onPause", "onPlayStatusChanged", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onVolumeChanged", "volume", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class MusicControlFragment extends Hilt_MusicControlFragment implements PlayCallbackComponent.OnPlayCallbackListener {
    public ImageView ivPlayOrPause;
    public ImageView ivVolumAdd;
    public ImageView ivVolumDec;

    @Inject
    public PlayCallbackComponent mPlayCallbackComponent;
    public ScrollableSeekBar seekBar;

    public final PlayCallbackComponent getMPlayCallbackComponent() {
        PlayCallbackComponent playCallbackComponent = this.mPlayCallbackComponent;
        if (playCallbackComponent != null) {
            return playCallbackComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPlayCallbackComponent");
        return null;
    }

    public final void setMPlayCallbackComponent(PlayCallbackComponent playCallbackComponent) {
        Intrinsics.checkNotNullParameter(playCallbackComponent, "<set-?>");
        this.mPlayCallbackComponent = playCallbackComponent;
    }

    public final ImageView getIvVolumDec() {
        ImageView imageView = this.ivVolumDec;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivVolumDec");
        return null;
    }

    public final void setIvVolumDec(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivVolumDec = imageView;
    }

    public final ImageView getIvVolumAdd() {
        ImageView imageView = this.ivVolumAdd;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivVolumAdd");
        return null;
    }

    public final void setIvVolumAdd(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivVolumAdd = imageView;
    }

    public final ScrollableSeekBar getSeekBar() {
        ScrollableSeekBar scrollableSeekBar = this.seekBar;
        if (scrollableSeekBar != null) {
            return scrollableSeekBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("seekBar");
        return null;
    }

    public final void setSeekBar(ScrollableSeekBar scrollableSeekBar) {
        Intrinsics.checkNotNullParameter(scrollableSeekBar, "<set-?>");
        this.seekBar = scrollableSeekBar;
    }

    public final ImageView getIvPlayOrPause() {
        ImageView imageView = this.ivPlayOrPause;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivPlayOrPause");
        return null;
    }

    public final void setIvPlayOrPause(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivPlayOrPause = imageView;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.ivVolumnDec);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        setIvVolumDec((ImageView) viewFindViewById);
        View viewFindViewById2 = view.findViewById(R.id.ivVolumnAdd);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        setIvVolumAdd((ImageView) viewFindViewById2);
        Object objFindViewById = view.findViewById(R.id.seekBar);
        Intrinsics.checkNotNullExpressionValue(objFindViewById, "findViewById(...)");
        setSeekBar((ScrollableSeekBar) objFindViewById);
        View viewFindViewById3 = view.findViewById(R.id.ivPlayOrPause);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        setIvPlayOrPause((ImageView) viewFindViewById3);
        getSeekBar().setMax(getMPlayCallbackComponent().getVolumeMax());
        getSeekBar().setProgress(getMPlayCallbackComponent().getVolume());
        getIvVolumDec().setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.fragment.music.MusicControlFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MusicControlFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        getIvVolumAdd().setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.fragment.music.MusicControlFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MusicControlFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
        getIvPlayOrPause().setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.fragment.music.MusicControlFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MusicControlFragment.onViewCreated$lambda$2(this.f$0, view2);
            }
        });
        getSeekBar().setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.dw.launcher.ui.fragment.music.MusicControlFragment.onViewCreated.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Timber.INSTANCE.d("onProgressChanged progress = " + progress, new Object[0]);
            }
        });
        ((ImageView) view.findViewById(R.id.ivPreview)).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.fragment.music.MusicControlFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MusicControlFragment.onViewCreated$lambda$3(this.f$0, view2);
            }
        });
        ((ImageView) view.findViewById(R.id.ivNext)).setOnClickListener(new View.OnClickListener() { // from class: com.dw.launcher.ui.fragment.music.MusicControlFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MusicControlFragment.onViewCreated$lambda$4(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(MusicControlFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSeekBar().setProgress(this$0.getMPlayCallbackComponent().getVolume());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(MusicControlFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSeekBar().setProgress(this$0.getMPlayCallbackComponent().getVolume());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(MusicControlFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.MUSIC_PLAYER");
        intent.setFlags(268435456);
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(MusicControlFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMPlayCallbackComponent().prev();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(MusicControlFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMPlayCallbackComponent().next();
    }

    public int getLayoutId() {
        return R.layout.fragment_music_control;
    }

    @Override // com.dw.launcher.ui.fragment.music.Hilt_MusicControlFragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        getMPlayCallbackComponent().setCallback(this);
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onPlayStatusChanged() {
        Drawable drawable;
        ImageView ivPlayOrPause = getIvPlayOrPause();
        if (!getMPlayCallbackComponent().isPlaying()) {
            drawable = getResources().getDrawable(R.mipmap.music_play);
        } else {
            drawable = getResources().getDrawable(R.mipmap.music_pause);
        }
        ivPlayOrPause.setBackground(drawable);
    }

    public void onVolumeChanged(float volume) {
        getSeekBar().setProgress((int) volume);
    }
}
