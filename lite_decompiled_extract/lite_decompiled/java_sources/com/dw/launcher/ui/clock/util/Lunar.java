package com.dw.launcher.ui.clock.util;

import com.dw.launcher.util.ACache;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class Lunar {
    private static final int MAX_YEAR = 2100;
    private static final int MIN_YEAR = 1891;
    private static final int[][] LUNAR_INFO = {new int[]{0, 2, 9, 21936}, new int[]{6, 1, 30, 9656}, new int[]{0, 2, 17, 9584}, new int[]{0, 2, 6, 21168}, new int[]{5, 1, 26, 43344}, new int[]{0, 2, 13, 59728}, new int[]{0, 2, 2, 27296}, new int[]{3, 1, 22, 44368}, new int[]{0, 2, 10, 43856}, new int[]{8, 1, 30, 19304}, new int[]{0, 2, 19, 19168}, new int[]{0, 2, 8, 42352}, new int[]{5, 1, 29, 21096}, new int[]{0, 2, 16, 53856}, new int[]{0, 2, 4, 55632}, new int[]{4, 1, 25, 27304}, new int[]{0, 2, 13, 22176}, new int[]{0, 2, 2, 39632}, new int[]{2, 1, 22, 19176}, new int[]{0, 2, 10, 19168}, new int[]{6, 1, 30, 42200}, new int[]{0, 2, 18, 42192}, new int[]{0, 2, 6, 53840}, new int[]{5, 1, 26, 54568}, new int[]{0, 2, 14, 46400}, new int[]{0, 2, 3, 54944}, new int[]{2, 1, 23, 38608}, new int[]{0, 2, 11, 38320}, new int[]{7, 2, 1, 18872}, new int[]{0, 2, 20, 18800}, new int[]{0, 2, 8, 42160}, new int[]{5, 1, 28, 45656}, new int[]{0, 2, 16, 27216}, new int[]{0, 2, 5, 27968}, new int[]{4, 1, 24, 44456}, new int[]{0, 2, 13, 11104}, new int[]{0, 2, 2, 38256}, new int[]{2, 1, 23, 18808}, new int[]{0, 2, 10, 18800}, new int[]{6, 1, 30, 25776}, new int[]{0, 2, 17, 54432}, new int[]{0, 2, 6, 59984}, new int[]{5, 1, 26, 27976}, new int[]{0, 2, 14, 23248}, new int[]{0, 2, 4, 11104}, new int[]{3, 1, 24, 37744}, new int[]{0, 2, 11, 37600}, new int[]{7, 1, 31, 51560}, new int[]{0, 2, 19, 51536}, new int[]{0, 2, 8, 54432}, new int[]{6, 1, 27, 55888}, new int[]{0, 2, 15, 46416}, new int[]{0, 2, 5, 22176}, new int[]{4, 1, 25, 43736}, new int[]{0, 2, 13, 9680}, new int[]{0, 2, 2, 37584}, new int[]{2, 1, 22, 51544}, new int[]{0, 2, 10, 43344}, new int[]{7, 1, 29, 46248}, new int[]{0, 2, 17, 27808}, new int[]{0, 2, 6, 46416}, new int[]{5, 1, 27, 21928}, new int[]{0, 2, 14, 19872}, new int[]{0, 2, 3, 42416}, new int[]{3, 1, 24, 21176}, new int[]{0, 2, 12, 21168}, new int[]{8, 1, 31, 43344}, new int[]{0, 2, 18, 59728}, new int[]{0, 2, 8, 27296}, new int[]{6, 1, 28, 44368}, new int[]{0, 2, 15, 43856}, new int[]{0, 2, 5, 19296}, new int[]{4, 1, 25, 42352}, new int[]{0, 2, 13, 42352}, new int[]{0, 2, 2, 21088}, new int[]{3, 1, 21, 59696}, new int[]{0, 2, 9, 55632}, new int[]{7, 1, 30, 23208}, new int[]{0, 2, 17, 22176}, new int[]{0, 2, 6, 38608}, new int[]{5, 1, 27, 19176}, new int[]{0, 2, 15, 19152}, new int[]{0, 2, 3, 42192}, new int[]{4, 1, 23, 53864}, new int[]{0, 2, 11, 53840}, new int[]{8, 1, 31, 54568}, new int[]{0, 2, 18, 46400}, new int[]{0, 2, 7, 46752}, new int[]{6, 1, 28, 38608}, new int[]{0, 2, 16, 38320}, new int[]{0, 2, 5, 18864}, new int[]{4, 1, 25, 42168}, new int[]{0, 2, 13, 42160}, new int[]{10, 2, 2, 45656}, new int[]{0, 2, 20, 27216}, new int[]{0, 2, 9, 27968}, new int[]{6, 1, 29, 44448}, new int[]{0, 2, 17, 43872}, new int[]{0, 2, 6, 38256}, new int[]{5, 1, 27, 18808}, new int[]{0, 2, 15, 18800}, new int[]{0, 2, 4, 25776}, new int[]{3, 1, 23, 27216}, new int[]{0, 2, 10, 59984}, new int[]{8, 1, 31, 27432}, new int[]{0, 2, 19, 23232}, new int[]{0, 2, 7, 43872}, new int[]{5, 1, 28, 37736}, new int[]{0, 2, 16, 37600}, new int[]{0, 2, 5, 51552}, new int[]{4, 1, 24, 54440}, new int[]{0, 2, 12, 54432}, new int[]{0, 2, 1, 55888}, new int[]{2, 1, 22, 23208}, new int[]{0, 2, 9, 22176}, new int[]{7, 1, 29, 43736}, new int[]{0, 2, 18, 9680}, new int[]{0, 2, 7, 37584}, new int[]{5, 1, 26, 51544}, new int[]{0, 2, 14, 43344}, new int[]{0, 2, 3, 46240}, new int[]{4, 1, 23, 46416}, new int[]{0, 2, 10, 44368}, new int[]{9, 1, 31, 21928}, new int[]{0, 2, 19, 19360}, new int[]{0, 2, 8, 42416}, new int[]{6, 1, 28, 21176}, new int[]{0, 2, 16, 21168}, new int[]{0, 2, 5, 43312}, new int[]{4, 1, 25, 29864}, new int[]{0, 2, 12, 27296}, new int[]{0, 2, 1, 44368}, new int[]{2, 1, 22, 19880}, new int[]{0, 2, 10, 19296}, new int[]{6, 1, 29, 42352}, new int[]{0, 2, 17, 42208}, new int[]{0, 2, 6, 53856}, new int[]{5, 1, 26, 59696}, new int[]{0, 2, 13, 54576}, new int[]{0, 2, 3, 23200}, new int[]{3, 1, 23, 27472}, new int[]{0, 2, 11, 38608}, new int[]{11, 1, 31, 19176}, new int[]{0, 2, 19, 19152}, new int[]{0, 2, 8, 42192}, new int[]{6, 1, 28, 53848}, new int[]{0, 2, 15, 53840}, new int[]{0, 2, 4, 54560}, new int[]{5, 1, 24, 55968}, new int[]{0, 2, 12, 46496}, new int[]{0, 2, 1, 22224}, new int[]{2, 1, 22, 19160}, new int[]{0, 2, 10, 18864}, new int[]{7, 1, 30, 42168}, new int[]{0, 2, 17, 42160}, new int[]{0, 2, 6, 43600}, new int[]{5, 1, 26, 46376}, new int[]{0, 2, 14, 27936}, new int[]{0, 2, 2, 44448}, new int[]{3, 1, 23, 21936}, new int[]{0, 2, 11, 37744}, new int[]{8, 2, 1, 18808}, new int[]{0, 2, 19, 18800}, new int[]{0, 2, 8, 25776}, new int[]{6, 1, 28, 27216}, new int[]{0, 2, 15, 59984}, new int[]{0, 2, 4, 27424}, new int[]{4, 1, 24, 43872}, new int[]{0, 2, 12, 43744}, new int[]{0, 2, 2, 37600}, new int[]{3, 1, 21, 51568}, new int[]{0, 2, 9, 51552}, new int[]{7, 1, 29, 54440}, new int[]{0, 2, 17, 54432}, new int[]{0, 2, 5, 55888}, new int[]{5, 1, 26, 23208}, new int[]{0, 2, 14, 22176}, new int[]{0, 2, 3, 42704}, new int[]{4, 1, 23, 21224}, new int[]{0, 2, 11, 21200}, new int[]{8, 1, 31, 43352}, new int[]{0, 2, 19, 43344}, new int[]{0, 2, 7, 46240}, new int[]{6, 1, 27, 46416}, new int[]{0, 2, 15, 44368}, new int[]{0, 2, 5, 21920}, new int[]{4, 1, 24, 42448}, new int[]{0, 2, 12, 42416}, new int[]{0, 2, 2, 21168}, new int[]{3, 1, 22, 43320}, new int[]{0, 2, 9, 26928}, new int[]{7, 1, 29, 29336}, new int[]{0, 2, 17, 27296}, new int[]{0, 2, 6, 44368}, new int[]{5, 1, 26, 19880}, new int[]{0, 2, 14, 19296}, new int[]{0, 2, 3, 42352}, new int[]{4, 1, 24, 21104}, new int[]{0, 2, 10, 53856}, new int[]{8, 1, 30, 59696}, new int[]{0, 2, 18, 54560}, new int[]{0, 2, 7, 55968}, new int[]{6, 1, 27, 27472}, new int[]{0, 2, 15, 22224}, new int[]{0, 2, 5, 19168}, new int[]{4, 1, 25, 42216}, new int[]{0, 2, 12, 42192}, new int[]{0, 2, 1, 53584}, new int[]{2, 1, 21, 55592}, new int[]{0, 2, 9, 54560}};
    private static final int[] LUNAR_INFO2 = {8697535, 306771, 677704, 5580477, 861776, 890180, 4631225, 354893, 634178, 2404022, 306762, 6966718, 675154, 861510, 6116026, 742478, 879171, 2714935, 613195, 7642049, 300884, 674632, 5973436, 435536, 447557, 4905656, 177741, 612162, 2398135, 300874, 6703934, 870993, 959814, 5690554, 372046, 177732, 3749688, 601675, 8165055, 824659, 870984, 7185723, 742735, 354885, 4894137, 154957, 601410, 2921910, 693578, 8080061, 445009, 742726, 5593787, 318030, 678723, 3484600, 338764, 9082175, 955730, 436808, 7001404, 701775, 308805, 4871993, 677709, 337474, 4100917, 890185, 7711422, 354897, 617798, 5549755, 306511, 675139, 5056183, 861515, 9261759, 742482, 748103, 6909244, 613200, 301893, 4869049, 674637, 11216322, 435540, 447561, 7002685, 702033, 612166, 5543867, 300879, 412484, 3581239, 959818, 8827583, 371795, 702023, 5846716, 601680, 824901, 5065400, 870988, 894273, 2468534, 354889, 8039869, 154962, 601415, 6067642, 693582, 739907, 4937015, 709962, 9788095, 309843, 678728, 6630332, 338768, 693061, 4672185, 436812, 709953, 2415286, 308810, 6969149, 675409, 861766, 6198074, 873293, 371267, 3585335, 617803, 11841215, 306515, 675144, 7153084, 861519, 873028, 6138424, 744012, 355649, 2403766, 301898, 8014782, 674641, 697670, 5984954, 447054, 711234, 3496759, 603979, 8689601, 300883, 412488, 6726972, 959823, 436804, 4896312, 699980, 601666, 3970869, 824905, 8211133, 870993, 894277, 5614266, 354894, 683331, 4533943, 339275, 9082303, 693587, 739911, 7034171, 709967, 350789, 4873528, 678732, 338754, 3838902, 430921, 7809469, 436817, 709958, 5561018, 308814, 677699, 4532024, 861770, 9343806, 873042, 895559, 6731067, 355663, 306757, 4869817, 675148, 857409, 2986677};
    private static final String[] DATE = {"", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
    private static final String[] MONTH = {"", "正月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "冬月", "腊月"};
    private static final String[] SKY = {"庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁", "戊", "己"};
    private static final String[] EARTH = {"申", "酉", "戌", "亥", "子", "丑", "寅", "卯", "辰", "巳", "午", "未"};
    private static final String[] ZODIAC = {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊"};
    private static final String[][] CONSTELLATION = {new String[]{"01-20", "02-18", "1", "水瓶座"}, new String[]{"02-19", "03-20", "2", "双鱼座"}, new String[]{"03-21", "04-19", "3", "白羊座"}, new String[]{"04-20", "05-20", "4", "金牛座"}, new String[]{"05-21", "06-21", "5", "双子座"}, new String[]{"06-22", "07-22", "6", "巨蟹座"}, new String[]{"07-23", "08-22", "7", "狮子座"}, new String[]{"08-23", "09-22", "8", "处女座"}, new String[]{"09-23", "10-23", "9", "天秤座"}, new String[]{"10-24", "11-22", "10", "天蝎座"}, new String[]{"11-23", "12-21", "11", "射手座"}, new String[]{"12-22", "01-19", "12", "摩羯座"}};

    private static Date getDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getConstellation(String birthday, boolean flag) {
        String strSubstring = birthday.substring(0, 4);
        String str = null;
        for (String[] strArr : CONSTELLATION) {
            if (!strArr[2].equals("12")) {
                if (!getDate(birthday).before(getDate(strSubstring + "-" + strArr[0])) && !getDate(birthday).after(getDate(strSubstring + "-" + strArr[1]))) {
                    str = flag ? strArr[2] : strArr[3];
                }
            } else if (!getDate(birthday).before(getDate(strSubstring + "-" + strArr[0])) || !getDate(birthday).after(getDate(strSubstring + "-" + strArr[1]))) {
                str = flag ? strArr[2] : strArr[3];
            }
        }
        return str;
    }

    public static LunarEntity convertLunarToSolar(int year, int month, int day) throws ParseException {
        if (year > MAX_YEAR || year < MIN_YEAR) {
            return null;
        }
        int[] iArr = LUNAR_INFO[year - 1891];
        String[] strArrSplit = dateToStr(new Date(((getDate(year + "-" + iArr[1] + "-" + iArr[2]).getTime() / 1000) + ((long) (getDaysBetweenLunar(year, month, day) * ACache.TIME_DAY))) * 1000), 1).split("-");
        return convertSolarToLunar(Integer.valueOf(strArrSplit[0]).intValue(), Integer.valueOf(strArrSplit[1]).intValue(), Integer.valueOf(strArrSplit[2]).intValue());
    }

    public static String dateToStr(Date d, int type) {
        SimpleDateFormat simpleDateFormat;
        if (type == 1) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        } else if (type == 2) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else if (type == 3) {
            simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        } else if (type == 4) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        } else {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }
        return simpleDateFormat.format(d);
    }

    public static int getLunarMonthDays(int year, int month) {
        ArrayList lunarMonths = getLunarMonths(year);
        if (lunarMonths.size() == 12) {
            return ((Integer) lunarMonths.get(month - 1)).intValue();
        }
        if (month > getLeapMonth(year)) {
            return ((Integer) lunarMonths.get(month)).intValue();
        }
        return ((Integer) lunarMonths.get(month - 1)).intValue();
    }

    public static LunarEntity convertSolarToLunar(int year, int month, int day) throws ParseException {
        if (year > MAX_YEAR || year < MIN_YEAR) {
            return null;
        }
        int[] iArr = LUNAR_INFO[year - 1891];
        if (year == MIN_YEAR && month <= 2 && day <= 9) {
            return new LunarEntity(MIN_YEAR, 1, 1, "正月", "初一", "辛卯", "兔", "摩羯座", 0);
        }
        LunarEntity lunarByBetween = getLunarByBetween(year, getDaysBetweenSolar(year, month, day, iArr[1], iArr[2]));
        lunarByBetween.setConstellation(getConstellation(year + "-" + month + "-" + day, false));
        lunarByBetween.setSolarYear(year);
        lunarByBetween.setSolarMonth(month);
        lunarByBetween.setSolarDay(day);
        return lunarByBetween;
    }

    public static final int[] solarToLunar(int year, int month, int monthDay) {
        int i = 0;
        int time = (int) ((new GregorianCalendar(year, month, monthDay).getTime().getTime() - new GregorianCalendar(1900, 0, 31).getTime().getTime()) / 86400000);
        int i2 = MIN_YEAR;
        int iDaysInLunarYear = 0;
        while (i2 <= MAX_YEAR && time > 0) {
            iDaysInLunarYear = daysInLunarYear(i2);
            time -= iDaysInLunarYear;
            i2++;
        }
        if (time < 0) {
            time += iDaysInLunarYear;
            i2--;
        }
        int iLeapMonth = leapMonth(i2);
        int i3 = 1;
        int iDaysInLunarMonth = 0;
        while (i3 <= 13 && time > 0) {
            iDaysInLunarMonth = daysInLunarMonth(i2, i3);
            time -= iDaysInLunarMonth;
            i3++;
        }
        if (iLeapMonth != 0 && i3 > iLeapMonth && (i3 = i3 - 1) == iLeapMonth) {
            i = 1;
        }
        if (time < 0) {
            time += iDaysInLunarMonth;
            i3--;
        }
        return new int[]{i2, i3, time + 1, i};
    }

    private static int daysInLunarMonth(int year, int month) {
        return (LUNAR_INFO2[year + (-1891)] & (1048576 >> month)) == 0 ? 29 : 30;
    }

    private static int daysInLunarYear(int year) {
        int i = leapMonth(year) != 0 ? 377 : 348;
        int i2 = LUNAR_INFO2[year - 1891] & 1048448;
        for (int i3 = 524288; i3 > 7; i3 >>= 1) {
            if ((i2 & i3) != 0) {
                i++;
            }
        }
        return i;
    }

    private static int leapMonth(int year) {
        return (LUNAR_INFO2[year - 1891] & 15728640) >> 20;
    }

    private static int getDaysBetweenSolar(int year, int cMonth, int cDay, int dMonth, int dDay) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return (int) ((simpleDateFormat.parse(year + "-" + cMonth + "-" + cDay).getTime() - simpleDateFormat.parse(year + "-" + dMonth + "-" + dDay).getTime()) / 86400000);
    }

    private static LunarEntity getLunarByBetween(int year, int between) {
        int iIntValue;
        int i;
        String capitalNum;
        LunarEntity lunarEntity = new LunarEntity();
        int i2 = 1;
        int i3 = 0;
        if (between == 0) {
            lunarEntity.setYear(year);
            lunarEntity.setLunarMonth("正月");
            lunarEntity.setLunarDay("初一");
            iIntValue = 1;
        } else {
            if (between <= 0) {
                year--;
            }
            ArrayList lunarYearMonths = getLunarYearMonths(year);
            int leapMonth = getLeapMonth(year);
            if (between <= 0) {
                between += getLunarYearDays(year);
            }
            int i4 = 0;
            while (true) {
                if (i4 >= lunarYearMonths.size()) {
                    iIntValue = 0;
                    i = 0;
                    break;
                }
                if (between == ((Integer) lunarYearMonths.get(i4)).intValue()) {
                    i = i4 + 2;
                    iIntValue = 1;
                    break;
                }
                if (between < ((Integer) lunarYearMonths.get(i4)).intValue()) {
                    int i5 = i4 + 1;
                    int i6 = i4 - 1;
                    iIntValue = (between - (i6 < 0 ? 0 : ((Integer) lunarYearMonths.get(i6)).intValue())) + 1;
                    i = i5;
                    break;
                }
                i4++;
            }
            if (leapMonth == 0 || i != leapMonth + 1) {
                capitalNum = getCapitalNum((leapMonth == 0 || leapMonth + 1 >= i) ? i : i - 1, true);
            } else {
                capitalNum = "闰" + getCapitalNum(i - 1, true);
            }
            lunarEntity.setYear(year);
            lunarEntity.setLunarMonth(capitalNum);
            lunarEntity.setLunarDay(getCapitalNum(iIntValue, false));
            i3 = leapMonth;
            i2 = i;
        }
        lunarEntity.setMonth(i2);
        lunarEntity.setDay(iIntValue);
        lunarEntity.setLunarSkyAndEarth(getLunarYearName(year));
        lunarEntity.setZodiac(getYearZodiac(year));
        lunarEntity.setLeap(i3);
        return lunarEntity;
    }

    private static ArrayList getLunarYearMonths(int year) {
        ArrayList lunarMonths = getLunarMonths(year);
        ArrayList arrayList = new ArrayList();
        int iIntValue = 0;
        for (int i = 0; i < lunarMonths.size(); i++) {
            iIntValue += ((Integer) lunarMonths.get(i)).intValue();
            arrayList.add(Integer.valueOf(iIntValue));
        }
        return arrayList;
    }

    private static int getDaysBetweenLunar(int year, int month, int day) {
        ArrayList lunarMonths = getLunarMonths(year);
        int iIntValue = 0;
        for (int i = 0; i < month - 1; i++) {
            iIntValue += ((Integer) lunarMonths.get(i)).intValue();
        }
        return iIntValue + (day - 1);
    }

    private static ArrayList getLunarMonths(int year) {
        int[] iArr = LUNAR_INFO[year - 1891];
        int i = 0;
        int i2 = iArr[0] == 0 ? 12 : 13;
        String binaryString = Integer.toBinaryString(iArr[3]);
        for (int i3 = 0; i3 < 16 - Integer.toBinaryString(iArr[3]).length(); i3++) {
            binaryString = "0" + binaryString;
        }
        ArrayList arrayList = new ArrayList();
        while (i < i2) {
            int i4 = i + 1;
            arrayList.add(Integer.valueOf(Integer.valueOf(binaryString.substring(i, i4)).intValue() + 29));
            i = i4;
        }
        return arrayList;
    }

    private static int getLeapMonth(int year) {
        return LUNAR_INFO[year - 1891][0];
    }

    private static int getLunarYearDays(int year) {
        ArrayList lunarYearMonths = getLunarYearMonths(year);
        int size = lunarYearMonths.size();
        int i = size - 1;
        return ((Integer) (((Integer) lunarYearMonths.get(i)).intValue() == 0 ? lunarYearMonths.get(size - 2) : lunarYearMonths.get(i))).intValue();
    }

    private static String getCapitalNum(int num, boolean isMonth) {
        if (isMonth) {
            return MONTH[num];
        }
        if (num <= 10) {
            return "初" + DATE[num];
        }
        if (num > 10 && num < 20) {
            return "十" + DATE[num - 10];
        }
        if (num == 20) {
            return "二十";
        }
        if (num > 20 && num < 30) {
            return "廿" + DATE[num - 20];
        }
        if (num != 30) {
            return "";
        }
        return "三十";
    }

    private static String getLunarYearName(int year) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = SKY;
        StringBuilder sbAppend = sb.append(strArr[year % strArr.length]);
        String[] strArr2 = EARTH;
        return sbAppend.append(strArr2[year % strArr2.length]).toString();
    }

    private static String getYearZodiac(int year) {
        String[] strArr = ZODIAC;
        return strArr[year % strArr.length];
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static int getIntervalDaysOfBirthday(int year, int month, int day, boolean flag) throws ParseException {
        String str;
        String strDateToStr = dateToStr(new Date(), 1);
        int iIntValue = Integer.valueOf(strDateToStr.substring(0, strDateToStr.indexOf("-"))).intValue();
        if (!flag) {
            if (month == 2 && day == 29) {
                for (int i = 0; i < 5 && (!isLeapYear(iIntValue) || (!getDate(strDateToStr).before(getDate(iIntValue + "-02-29")) && !strDateToStr.equals(iIntValue + "-02-29"))); i++) {
                    iIntValue++;
                }
            }
            str = iIntValue + "-" + month + "-" + day;
            if (getDate(strDateToStr).after(getDate(str))) {
                str = (iIntValue + 1) + "-" + month + "-" + day;
            }
        } else {
            LunarEntity nowbirthdayByBirthdayViaLunar = getNowbirthdayByBirthdayViaLunar(convertSolarToLunar(year, month, day));
            str = nowbirthdayByBirthdayViaLunar.getSolarYear() + "-" + nowbirthdayByBirthdayViaLunar.getSolarMonth() + "-" + nowbirthdayByBirthdayViaLunar.getSolarDay();
        }
        return (int) ((getDate(str).getTime() - getDate(strDateToStr).getTime()) / 86400000);
    }

    private static LunarEntity getNowbirthdayByBirthdayViaLunar(LunarEntity le) throws NumberFormatException, ParseException {
        LunarEntity lunarEntityConvertLunarToSolar;
        String strDateToStr = dateToStr(new Date(), 1);
        int i = Integer.parseInt(strDateToStr.substring(0, strDateToStr.indexOf("-")));
        LunarEntity lunarEntityConvertSolarToLunar = convertSolarToLunar(i, 8, 8);
        if (lunarEntityConvertSolarToLunar == null) {
            return null;
        }
        if (le.getLeap() > 0 && le.getMonth() == le.getLeap() + 1) {
            if (lunarEntityConvertSolarToLunar.getLeap() > 0 && lunarEntityConvertSolarToLunar.getLeap() <= le.getMonth()) {
                lunarEntityConvertLunarToSolar = convertLunarToSolar(i, le.getMonth(), le.getDay());
            } else {
                lunarEntityConvertLunarToSolar = convertLunarToSolar(i, le.getMonth() - 1, le.getDay());
            }
        } else if (lunarEntityConvertSolarToLunar.getLeap() > 0 && le.getLeap() == 0 && lunarEntityConvertSolarToLunar.getLeap() < le.getMonth()) {
            lunarEntityConvertLunarToSolar = convertLunarToSolar(i, le.getMonth() + 1, le.getDay());
        } else if ((lunarEntityConvertSolarToLunar.getLeap() > 0 && le.getLeap() > 0 && lunarEntityConvertSolarToLunar.getLeap() >= le.getMonth()) || (lunarEntityConvertSolarToLunar.getLeap() == 0 && le.getLeap() > 0 && le.getLeap() < le.getMonth())) {
            lunarEntityConvertLunarToSolar = convertLunarToSolar(i, le.getMonth() - 1, le.getDay());
        } else {
            lunarEntityConvertLunarToSolar = convertLunarToSolar(i, le.getMonth(), le.getDay());
        }
        if (lunarEntityConvertLunarToSolar == null) {
            return null;
        }
        if (lunarEntityConvertLunarToSolar.getDay() == le.getDay()) {
            return lunarEntityConvertLunarToSolar;
        }
        le.setDay(le.getDay() - 1);
        return getNowbirthdayByBirthdayViaLunar(le);
    }
}
