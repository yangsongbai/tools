package com.dingding.alarm.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class DateUtil {
    static HashMap<String,String> datePatternToReg = new HashMap<>();
    static {
        /*datePatternToReg.put("yyyy.MM.dd","[0-9]{4}[.][0-9]{1,2}[.][0-9]{1,2}");*/
        datePatternToReg.put("yyyy-MM-dd","(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)");
        datePatternToReg.put("yyyy.MM.dd","(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3}).(((0[13578]|1[02]).(0[1-9]|[12][0-9]|3[01]))|((0[469]|11).(0[1-9]|[12][0-9]|30))|(02.(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00)).02.29)");
        datePatternToReg.put("yyyy-MM-dd-HH","[0-9]{4}[-][0-9]{1,2}[-][0-9]{1,2}[-][0-9]{1,2}");
        datePatternToReg.put("yyyy.MM.dd.HH","[0-9]{4}[.][0-9]{1,2}[.][0-9]{1,2}[.][0-9]{1,2}");
    }

    public static HashMap<String, String> getDatePatternToReg() {
        return datePatternToReg;
    }



    /**
     * 日期转星期
     *
     * @param datetime
     * @return
     */
    public static String dateToWeek(String datetime,String pattern) {
        SimpleDateFormat f = new SimpleDateFormat(pattern);
       /* String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };*/
        String[] weekDays = { "0", "1", "2", "3", "4", "5", "6" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date date = null;
        try {
            date = f.parse(datetime);
            cal.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 获取今天对应的上周日期
     * @param patten 模式
     * @return
     */
    public static String getTodayOfLastWeekdayDate(String patten){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        return new SimpleDateFormat(patten).format(calendar.getTime());
    }


    /**
     * 获取明天的日期
     * @param patten 模式
     * @return
     */
    public static String getTomorrowDate(String patten){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, +1);
        return new SimpleDateFormat(patten).format(calendar.getTime());
    }
    /**
     * 获取今天日期
     * @param patten 模式
     * @return
     */
    public static String getTodayDate(String patten){
        Calendar calendar = Calendar.getInstance();
        return new SimpleDateFormat(patten).format(calendar.getTime());
    }
    /**
     * 获取当年年份
     * @return
     */
    public static String getCurrentYear(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
    }

    /**
     * 获取昨天的日期
     * @return
     */
    public static Calendar getYesterdayDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return calendar;
    }

    /**
     * 获取昨天的日期
     * @return
     */
    public static String getYesterdayDate(String patten){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return new SimpleDateFormat(patten).format(calendar.getTime());
    }

    /**
     * 获取现在时刻的，两小时之后的时间
     * @param patten
     * @return
     */
    public static String getTimeOfAfterTwoHour(String patten) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, +2);
        return new SimpleDateFormat(patten).format(calendar.getTime());
    }

    /***
     * 获取现在时刻的，指定的多少个小时之后的时间
     * @param patten
     * @param after
     * @return
     */
    public static String getTimeOfAfterSpecialHour(String patten,int after) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, +after);
        return new SimpleDateFormat(patten).format(calendar.getTime());
    }


    /**
     * 获取现在时刻的，指定多少个小时，之前的时间
     * @param patten
     * @param before
     * @return
     */
    public static String getTimeOfBeforeSpecialHour(String patten,int before) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -before);
        return new SimpleDateFormat(patten).format(calendar.getTime());
    }

    /**
     * 获取今天之前，指定天数的日期
     * @param patten
     * @param past
     * @return
     */
    public static String getTimeOfBeforeSpecialDay(String patten,int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        return new SimpleDateFormat(patten).format(calendar.getTime());
    }
    /**
     * 获取,多少小时之后的，小时时刻
     * @param patten
     * @param afterHour
     * @return
     */
    public static String getHourAfterSpecialHour(String patten,int afterHour) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, +afterHour);
        return new SimpleDateFormat(patten).format(calendar.getTime());
    }

    /**
     * 获取,多少小时之前的，小时时刻
     * @param patten
     * @param beforeHour
     * @return
     */
    public static String getHourBeforeSpecialHour(String patten,int beforeHour) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -beforeHour);
        return new SimpleDateFormat(patten).format(calendar.getTime());
    }

    /**
     * betweenTwoDays的主要职责:
     * 两个日期之间的，时间差多少天
     * @MethodName betweenTwoDays
     * @Description: TODO
     * @Author songbai yang
     * @Date 2019/7/18 16:49
     * @Version V1.0
     * @Param  beforDate
     * @Param afterDate
     * @Param pattern
     * @Exception
     * @Return  long
    **/
    public static long betweenTwoDays(String beforDate,String afterDate,String pattern) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        Date d1=sdf.parse(beforDate);
        Date d2=sdf.parse(afterDate);
        long daysBetween=(d2.getTime()-d1.getTime()+1000000)/(60*60*24*1000);
        return daysBetween;
    }
}
