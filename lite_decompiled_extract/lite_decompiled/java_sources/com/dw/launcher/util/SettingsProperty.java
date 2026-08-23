package com.dw.launcher.util;

import com.google.android.mms.pdu.CharacterSets;
import kotlin.Metadata;

/* JADX INFO: compiled from: SettingsProperty.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/dw/launcher/util/SettingsProperty;", "", "()V", "HIDE_FORBIDDEN_APP", "", "LINEAR_SYLTE_KEY", "SIGNAL_TYPE", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class SettingsProperty {
    public static final String HIDE_FORBIDDEN_APP = "hide_forbidden_app";
    public static final SettingsProperty INSTANCE = new SettingsProperty();
    public static final String LINEAR_SYLTE_KEY = "launcher_linear_style";
    public static final String SIGNAL_TYPE = "persist.sys.dw.hide.signaltype";

    private SettingsProperty() {
    }
}
