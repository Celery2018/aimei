package com.bizconf.utils;

import common.SystemConfig;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by cdxy_ on 2017/6/11.
 */
public class DateUtil {
    public static final String FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_NO_SPACE = "yyyy-MM-ddHH:mm:ss";

    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_TIME = "HH:mm:ss";
    public static final String FORMAT_TIME_MINUTE = "HH:mm";

    public static Date str2Date(String str, String format) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = FORMAT_DEFAULT;
        }
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;

    }

    public static Calendar str2Calendar(String str, String format) {
        Calendar cal=Calendar.getInstance();
        cal.setTime(str2Date(str,format));
        return cal;
    }
    public static String dateFormat(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String demo = sdf.format(date);
        return demo;
    }

    public static String date2Str(Date d, String format) {// yyyy-MM-dd HH:mm:ss
        if (d == null) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = FORMAT_DEFAULT;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String s = sdf.format(d);
        return s;
    }

    public static String getMeetingCreateTime(String startTime){
        long date1=str2Date(startTime,DateUtil.FORMAT_DEFAULT).getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        long now = str2Date(format.format(new Date()),FORMAT_DEFAULT).getTime();
        if(date1<now)
            return startTime;
        if((date1-now)> SystemConfig.FIVETTENMINUTE){
            date1=date1-SystemConfig.FIVETTENMINUTE;
            Calendar calendar=Calendar.getInstance();
            calendar.setTimeInMillis(date1);
            return dateFormat(calendar.getTime(),FORMAT_DEFAULT);
        }else {
            return format.format(new Date());
        }

    }

    public static Date getMeetingFinishTime(Date startTime,int duration){
          long start=startTime.getTime();
          long end=start+duration*60*1000;
          Calendar calendar=Calendar.getInstance();
          calendar.setTimeInMillis(end);
          return calendar.getTime();

    }
}
