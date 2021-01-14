package com.vcgdev.common.utils;

import java.util.Date;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DateUtilsTest {
    
    @Test
    public void fromDate_formatCorrectDate_shouldUseDefaultFormat() {
        String date = DateUtils.fromDate(new Date());
        assertNotNull(date);
    }

    @Test
    public void fromDate_formatProvided_shouldReturnValidDate() {
        String date = DateUtils.fromDate(new Date(), "YYYY-MM-dd");
        assertNotNull(date);
    }

    @Test
    public void fromDate_formatNullDate_shouldReturnEmptyString() {
        String date = DateUtils.fromDate(null);
        assertNotNull(date);
        assertEquals("", date);
    }

    @Test
    public void fromString_invalidDate_shouldReturnNull() {
        Date date = DateUtils.fromString("invalid");
        assertNull(date);
    }

    @Test
    public void fromString_validDateNoFormatProvided_shouldUseDefaultFormat() {
        Date date = DateUtils.fromString("01/01/2020");
        assertNotNull(date);
    }


    @Test
    public void fromString_validDateFormatProvided_shouldReturnValidDate() {
        Date date = DateUtils.fromString("2020-01-01", "YYYY-MM-dd");
        assertNotNull(date);
    }
}
