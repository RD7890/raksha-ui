package com.dw.launcher.data.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public class Image implements Serializable {
    private long data_modified;
    private int img_id;
    private String path;
    private int type;

    public long getData_modified() {
        return this.data_modified;
    }

    public int getImg_id() {
        return this.img_id;
    }

    public String getPath() {
        return this.path;
    }

    public int getType() {
        return this.type;
    }

    public void setData_modified(long j) {
        this.data_modified = j;
    }

    public void setImg_id(int i) {
        this.img_id = i;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
