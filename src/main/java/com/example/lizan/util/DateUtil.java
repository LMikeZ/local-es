package com.example.lizan.util;

import cn.hutool.core.date.DateTime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author lizan
 * @version $Id: DateUtil.java, v 0.1 2024年10月09日 14:59 lizan Exp $$
 */
public class DateUtil {

    public static Date getFrontDay(Date date, int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(5, cal.get(5) - i);
        return cal.getTime();
    }

    public static void main(String[] args) {
        Date dateTime = cn.hutool.core.date.DateUtil.beginOfMonth(new Date());
        Date dateTime2 = cn.hutool.core.date.DateUtil.endOfMonth(new Date());
        System.out.println(dateTime);
        System.out.println(dateTime2);
    }
}
