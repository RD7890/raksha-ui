package com.dw.launcher.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public class TodayDataList implements Serializable {
    protected List<Integer> indexList = new ArrayList();
    protected List<Integer> valueList = new ArrayList();

    public List<Integer> getIndexList() {
        return this.indexList;
    }

    public void setIndexList(List<Integer> indexList) {
        this.indexList = indexList;
    }

    public List<Integer> getValueList() {
        return this.valueList;
    }

    public void setValueList(List<Integer> valueList) {
        this.valueList = valueList;
    }
}
