package com.dw.launcher.ui.fragment.music;

import com.dw.launcher.core.component.PlayCallbackComponent;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public final class MusicControlFragment_MembersInjector implements MembersInjector<MusicControlFragment> {
    private final Provider<PlayCallbackComponent> mPlayCallbackComponentProvider;

    public MusicControlFragment_MembersInjector(Provider<PlayCallbackComponent> mPlayCallbackComponentProvider) {
        this.mPlayCallbackComponentProvider = mPlayCallbackComponentProvider;
    }

    public static MembersInjector<MusicControlFragment> create(Provider<PlayCallbackComponent> mPlayCallbackComponentProvider) {
        return new MusicControlFragment_MembersInjector(mPlayCallbackComponentProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MusicControlFragment instance) {
        injectMPlayCallbackComponent(instance, this.mPlayCallbackComponentProvider.get());
    }

    public static void injectMPlayCallbackComponent(MusicControlFragment instance, PlayCallbackComponent mPlayCallbackComponent) {
        instance.mPlayCallbackComponent = mPlayCallbackComponent;
    }
}
