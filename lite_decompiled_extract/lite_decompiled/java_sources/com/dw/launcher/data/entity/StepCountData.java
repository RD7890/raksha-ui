package com.dw.launcher.data.entity;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public class StepCountData {
    private String date;
    private int initStep;
    private int step;

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStep() {
        return this.step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getInitStep() {
        return this.initStep;
    }

    public void setInitStep(int initStep) {
        this.initStep = initStep;
    }

    public String toString() {
        return "StepCountData{date='" + this.date + "', step=" + this.step + '}';
    }
}
