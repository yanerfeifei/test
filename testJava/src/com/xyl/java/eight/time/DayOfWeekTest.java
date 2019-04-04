package com.xyl.java.eight.time;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月08日  17:41:22
 * @Description:
 */
public class DayOfWeekTest {
    public static void main(String[] args) {
        LocalDate l = LocalDate.now();
        System.out.println(DayOfWeek.SUNDAY.getValue());

        DayOfWeek sw = DayOfWeek.SUNDAY;
        System.out.println(sw.minus(1).getValue());
        System.out.println(DayOfWeek.valueOf("THURSDAY").minus(1).getValue());
    }
}
