package com.dw.launcher.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.mms.pdu.CharacterSets;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class GifView extends View {
    private Movie movie;
    private long movieStart;

    public GifView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public GifView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GifView(Context context) {
        super(context);
    }

    public GifView(Context context, int gifId) {
        super(context);
        init(context, gifId);
    }

    private void init(Context context, int gifId) {
        try {
            this.movie = Movie.decodeStream(getResources().openRawResource(gifId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.movieStart == 0) {
            this.movieStart = jUptimeMillis;
        }
        Movie movie = this.movie;
        if (movie != null) {
            int iDuration = movie.duration();
            if (iDuration == 0) {
                iDuration = CharacterSets.UCS2;
            }
            this.movie.setTime((int) ((jUptimeMillis - this.movieStart) % ((long) iDuration)));
            this.movie.draw(canvas, 0.0f, 0.0f);
            invalidate();
        }
    }
}
