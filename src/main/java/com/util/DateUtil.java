package com.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ma on 2016/10/20.
 */
public class DateUtil {

    public static String getCurrentTimeMillis() {
        return String.valueOf(System.currentTimeMillis());
    }
    public static String getCurrentTimeDate() {

        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);
        return time;
    }
    public static String getCurrentDate() {
    	Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String time=format.format(date);
        return time;
    }
    

}