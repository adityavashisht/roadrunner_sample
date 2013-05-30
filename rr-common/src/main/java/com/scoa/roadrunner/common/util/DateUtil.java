package com.scoa.roadrunner.common.util;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.Date;


/**
 *
 *
 *
 *
 */
public class DateUtil {

    /**
     *
     * @param dateOfEntry
     * @return
     */
    public static Date getDateFromString(String dateOfEntry) {
        DateTimeFormatter fmt = ISODateTimeFormat.date();
        LocalDateTime dt = LocalDateTime.parse(dateOfEntry, fmt);
        return dt.toDate();
    }

    /**
     *
     * @param localDateTime
     * @return
     */
    public static String getISODateFormat(LocalDateTime localDateTime) {
        DateTimeFormatter fmt = ISODateTimeFormat.date();
        return localDateTime.toString(fmt);
    }

    /**
     *
     * @param localDateTime
     * @return
     */
    public static String getISODateFormat(LocalDate localDateTime) {
        DateTimeFormatter fmt = ISODateTimeFormat.date();
        return localDateTime.toString(fmt);
    }

    /**
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @return
     */
    public static DateTime getDateTime(int year, int month, int day, String hour, String minute) {
        Integer hourValue = Integer.valueOf(hour);
        Integer minuteValue = Integer.valueOf(minute);
        return new DateTime(year, month, day, hourValue, minuteValue);
    }
}
