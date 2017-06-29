package com.engageya.utils;

import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by DANIEL on 2/27/2017
 */
@Component
public class DateUtils {

    public String getDateStringFromTodayPlusDays(int daysToAdd) {
        return getDateString(daysToAdd, Calendar.DATE);
    }

    public String getDateStringFromTodayPlusMonths(int monthsToAdd) {
        return getDateString(monthsToAdd, Calendar.MONTH);
    }

    static public String getDateFrom(Integer year, Integer month, Integer day) {
        if (year == null || month == null || day == null) {
            return "";
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day, 0, 0);
        return dateFormat.format(cal.getTime());
    }

    private String getDateString(int monthsToAdd, int calendarField) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date now = LocalDate.now().toDate();
        cal.setTime(now);
        cal.add(calendarField, monthsToAdd);
        return dateFormat.format(cal.getTime());
    }

    private String getYesterdayDateString() {
        int daysToAdd = -1;
        return getDateStringFromTodayPlusDays(daysToAdd);
    }

    private String getTodayDateString() {
        return getDateStringFromTodayPlusDays(0);
    }
}
