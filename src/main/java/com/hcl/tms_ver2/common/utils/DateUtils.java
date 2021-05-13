package com.hcl.tms_ver2.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String convertDateToString(Date date) {
        return new SimpleDateFormat(Constants.DATE_FORMAT).format(date);
    }

    public static Date convertStringToDate(String stringDate) {
        Date date = null;

        try {
            date = new SimpleDateFormat(Constants.DATE_FORMAT).parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
