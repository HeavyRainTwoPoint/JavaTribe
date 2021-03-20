package com.javatribe.apicompetition.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.checkerframework.checker.units.qual.C;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class StudentIdUtil {

    public static String getStudentId(){
        String regex = "(?:";
        Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        String year = DateFormatUtils.format(date, "yyyy");
        //放宽到六届
        for (int i=0 ; i<6 ; i++){
            String yearLastNum = year.substring(2, year.length());
            regex += (yearLastNum+"|");
            calendar.add(Calendar.YEAR,-1);
            date = calendar.getTime();
            year = DateFormatUtils.format(date,"yyyy");
        }
        regex = regex.substring(0, regex.length() - 1);
        return regex+")";
    }
}
