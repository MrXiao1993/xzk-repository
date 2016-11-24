package com.xzk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Guo on 2016/4/14.
 */
public class DateUtil {

    /**
     * 得到指定日期的下个月的开始时间
     *
     */
    public static Date getNextMonthStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 得到下个月的开始时间
     *
     */
    public static Date getNextNowMonthStart() {
        return getNextMonthStart(null);
    }

    /**
     * 得到本月的开始时间
     *
     */
    public static Date getNowMonthStart() {
        Date now = new Date();
        return getMonthStart(now);
    }

    /**
     * 得到本日的开始时间
     *
     */
    public static Date getNowDayStart() {
        Date now = new Date();
        return getDayStart(now);
    }

    /**
     * 得到本年的开始时间
     *
     */
    public static Date getNowYearStart() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return getYearStart(year);
    }

    /**
     * 得到某年的开始时间
     */
    public static Date getYearStart(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 0);// mouth 基于0
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 得到某天的开始时间
     */
    public static Date getDayStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 得到某月的开始时间
     */
    public static Date getMonthStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 得到某小时开始时间
     */
    public static Date getHourStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 设置日历的当天的开始时间即 00:00:00
     */
    public static Calendar setStartTime(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal;
    }

    /**
     * 得到今天的开始时间
     */
    public static Date getStartTime() {
        Calendar cal = Calendar.getInstance();
        return setStartTime(cal).getTime();
    }

    /**
     * 格式化日期
     */
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 格式化成标准格式 yyyy-MM-dd HH:mm:ss
     */
    public static String formatDateStandard(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }
    public static String getFormatDate(Date date) {
        return formatDate(date, "yyyyMMddHHmmss");
    }

    /**
     * 格式化成china格式 yyyy年MM月dd日 hh分mm秒ss
     */
    public static String formatDateCn(Date date) {
        return formatDate(date, "yyyy年MM月 hh时mm分ss秒");
    }

    public static Date parseDate(String date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            throw new IllegalArgumentException("日期参数错误 "+pattern);
        }
    }

    /**
     * 得到在START后OFFSET天后的开始时间
     */
    public static Date after(Date start, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + offset);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 得到在end前OFFSET天的开始时间
     */
    public static Date before(Date end, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(end);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - offset);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 周开始时间,星期一为第一天
     * @param date
     * @return
     */
    public static Date getWeekStart(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, 2);
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND,0);
        return c.getTime();
    }


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long timeStart=sdf.parse("2016-04-25 18:29:08").getTime();
        System.out.println(timeStart);
        Date date = new Date(timeStart);
        System.out.println(sdf.format(date));
    }
    public static String formatDateCns(Date date) {
        return formatDate(date, "yyyyMMddHHmmss");
    }
}
