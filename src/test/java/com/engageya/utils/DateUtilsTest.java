package com.engageya.utils;

import org.joda.time.DateTimeUtils;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by DANIEL on 2/27/2017
 */

public class DateUtilsTest {
    private DateUtils dateUtils = new DateUtils();

    @Before
    public void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(30L);
    }

    @Test
    public void getDateStringFromTodayPlusZero() throws Exception {
        String actualResult = dateUtils.getDateStringFromTodayPlusDays(0);
        assertThat(actualResult, equalTo("1970-01-01"));
    }

    @Test
    public void getDateStringFromTodayMinusOne() throws Exception {
        String actualResult = dateUtils.getDateStringFromTodayPlusDays(-1);
        assertThat(actualResult, equalTo("1969-12-31"));
    }

    @Test
    public void getDateStringFromTodayPlusMonthsZero() throws Exception {
        String actualResult = dateUtils.getDateStringFromTodayPlusMonths(0);
        assertThat(actualResult, equalTo("1970-01-01"));
    }

    @Test
    public void getDateStringFromTodayPlusMonthsMinusOne() throws Exception {
        String actualResult = dateUtils.getDateStringFromTodayPlusMonths(-1);
        assertThat(actualResult, equalTo("1969-12-01"));
    }

    @Test
    public void getDateFrom() {
        String actualResult = DateUtils.getDateFrom(2017, 5, 17);
        assertThat(actualResult, equalTo("2017-05-17"));
    }

    @Test
    public void getDateFrom_nulls() {
        String actualResult = DateUtils.getDateFrom(null, null, null);
        assertThat(actualResult, equalTo(""));
    }

}