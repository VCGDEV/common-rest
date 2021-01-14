package com.vcgdev.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    
    public static final String SHORT_DT_FORMAT = "dd/MM/yyyy";

    private DateUtils() {}

    public static Date fromString(String date) {
        return fromString(date, SHORT_DT_FORMAT);
    }

    public static Date fromString(String date, String dtFormat) {
        try {
            if(date == null)
                return null;
            SimpleDateFormat format = new SimpleDateFormat(dtFormat);
            return format.parse(date);
        } catch (ParseException pe) {
            return null;
        }
    }

    public static String fromDate(Date date) {
        return fromDate(date, SHORT_DT_FORMAT);
    }

    public static String fromDate(Date date, String dtFormat) {
        if(date==null) {
            return "";
        } else {
            SimpleDateFormat format = new SimpleDateFormat(dtFormat);
            return format.format(date);
        }
    }
}
