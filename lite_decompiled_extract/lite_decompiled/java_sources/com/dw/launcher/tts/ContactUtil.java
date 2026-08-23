package com.dw.launcher.tts;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public class ContactUtil {
    public static String findContactNameByNumber(Context context, String number) {
        int columnIndex;
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Number must not be null or empty");
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, number), new String[]{"display_name"}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst() && (columnIndex = cursorQuery.getColumnIndex("display_name")) != -1) {
                    String string = cursorQuery.getString(columnIndex);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return string;
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (cursorQuery == null) {
            return null;
        }
        cursorQuery.close();
        return null;
    }
}
