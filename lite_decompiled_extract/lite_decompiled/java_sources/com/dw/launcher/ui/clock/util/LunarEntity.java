package com.dw.launcher.ui.clock.util;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class LunarEntity {
    private String constellation;
    private int day;
    private int leap;
    private String lunarDay;
    private String lunarMonth;
    private String lunarSkyAndEarth;
    private int month;
    private int solarDay;
    private int solarMonth;
    private int solarYear;
    private int year;
    private String zodiac;

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getLunarMonth() {
        return this.lunarMonth;
    }

    public void setLunarMonth(String lunarMonth) {
        this.lunarMonth = lunarMonth;
    }

    public String getLunarDay() {
        return this.lunarDay;
    }

    public void setLunarDay(String lunarDay) {
        this.lunarDay = lunarDay;
    }

    public String getLunarSkyAndEarth() {
        return this.lunarSkyAndEarth;
    }

    public void setLunarSkyAndEarth(String lunarSkyAndEarth) {
        this.lunarSkyAndEarth = lunarSkyAndEarth;
    }

    public int getLeap() {
        return this.leap;
    }

    public void setLeap(int leap) {
        this.leap = leap;
    }

    public LunarEntity(int year, int month, int day, String lunarMonth, String lunarDay, String lunarSkyAndEarth, String zodiac, String constellation, int leap) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.lunarMonth = lunarMonth;
        this.lunarDay = lunarDay;
        this.lunarSkyAndEarth = lunarSkyAndEarth;
        this.zodiac = zodiac;
        this.constellation = constellation;
        this.leap = leap;
    }

    public int getSolarYear() {
        return this.solarYear;
    }

    public void setSolarYear(int solarYear) {
        this.solarYear = solarYear;
    }

    public int getSolarMonth() {
        return this.solarMonth;
    }

    public void setSolarMonth(int solarMonth) {
        this.solarMonth = solarMonth;
    }

    public int getSolarDay() {
        return this.solarDay;
    }

    public void setSolarDay(int solarDay) {
        this.solarDay = solarDay;
    }

    public String getZodiac() {
        return this.zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    public String getConstellation() {
        return this.constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public LunarEntity() {
    }
}
