package com.kuang.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    // 日期转字符串
    public static String date2String(Date date, String patt) {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }


    // 字符串转日期
    public static Date string2Date(String str, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date date = sdf.parse(str);
        return date;
    }

    // 英文格式时间转中文格式时间
    public static Date EngDateToCh(Date date, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String  format = sdf.format(date);
        return sdf.parse(format);
    }
}
