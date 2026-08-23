package com.dw.launcher.tts;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import cn.carbswang.android.numberpickerview.library.BuildConfig;
import java.util.Locale;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public class TtsSpeakManager {
    private static final String TAG = "[lkang-launcher-tts]";
    private static TtsSpeakManager mInstance;
    private Context mContext;
    private InitStatus mInitStatus = InitStatus.NOT_ENGINE;
    private TextToSpeech mTextToSpeech;

    public enum InitStatus {
        HAS_ENGINE,
        NOT_ENGINE
    }

    public static synchronized TtsSpeakManager register(Context context) {
        if (mInstance == null) {
            mInstance = new TtsSpeakManager(context);
        }
        return mInstance;
    }

    private TtsSpeakManager(Context context) {
        this.mContext = context.getApplicationContext();
        init(null);
    }

    private void init(final String tts) {
        Log.i(TAG, "TtsSpeakManager >>> init");
        this.mTextToSpeech = new TextToSpeech(this.mContext, new TextToSpeech.OnInitListener() { // from class: com.dw.launcher.tts.TtsSpeakManager.1
            @Override // android.speech.tts.TextToSpeech.OnInitListener
            public void onInit(int status) {
                Log.i(TtsSpeakManager.TAG, "TtsSpeakManager onInit status >>> " + status);
                if (status == 0) {
                    TtsSpeakManager.this.mInitStatus = InitStatus.HAS_ENGINE;
                    TtsSpeakManager.this.mTextToSpeech.setEngineByPackageName("com.dw.tts");
                    TtsSpeakManager.this.mTextToSpeech.setLanguage(Locale.getDefault());
                    if (tts != null) {
                        TtsSpeakManager.this.mTextToSpeech.speak(tts, 0, null);
                        return;
                    }
                    return;
                }
                TtsSpeakManager.this.mInitStatus = InitStatus.NOT_ENGINE;
            }
        });
    }

    public void setTts(String tts) {
        if (this.mTextToSpeech == null) {
            Log.i(TAG, "mTextToSpeech = null");
            init(tts);
        } else {
            Log.i(TAG, "mInitStatus == InitStatus.HAS_ENGINE >>> " + (this.mInitStatus == InitStatus.HAS_ENGINE));
            if (this.mInitStatus == InitStatus.HAS_ENGINE) {
                this.mTextToSpeech.speak(tts, 0, null);
            }
        }
    }

    public void stopTts() {
        if (this.mTextToSpeech != null) {
            Log.i("lkang", "mTextToSpeech stop");
            if (this.mInitStatus == InitStatus.HAS_ENGINE) {
                this.mTextToSpeech.speak(BuildConfig.FLAVOR, 0, null);
            }
        }
    }
}
