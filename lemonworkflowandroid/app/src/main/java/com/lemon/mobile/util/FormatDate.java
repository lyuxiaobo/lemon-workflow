package com.lemon.mobile.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 格式化日期和时间
 * @author Lyubo
 * @date 2021/8/14
 */
public class FormatDate {
    public static String getDateStrFromISO8601Timestamp(String ISOdate){
        DateTimeFormatter dtf1 = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        DateTime dt= dtf1.parseDateTime(ISOdate);
        DateTimeFormatter dtf2= DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

        return dt.toString(dtf2);
    }
}
