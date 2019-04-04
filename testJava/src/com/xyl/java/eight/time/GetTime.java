package com.xyl.java.eight.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月08日  13:39:28
 * @Description:
 */
public class GetTime {
    public static void main(String[] args) {
        //获取今天日期
        //LocalDate today = LocalDate.now();
        //System.out.println("Today's Local date : " + today);

        /*//获取当前的年月日
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);*/

        /*//获取某个特定的日期
        LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
        System.out.println("Your Date of birth is : " + dateOfBirth);*/

        //检查两个日期是否相等
        /*LocalDate date1 = LocalDate.of(2018, 05, 8);
        if(date1.equals(today)){
            System.out.printf("Today %s and date1 %s are same date %n", today, date1);
        }*/

        //检查重复事件，比如说生日
        /*LocalDate dateOfBirth = LocalDate.of(2018, 5, 8);
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);
        if(currentMonthDay.equals(birthday)){
            System.out.println("Many Many happy returns of the day !!");
        }else{
            System.out.println("Sorry, today is not your birthday");
        }*/

        //获取当前时间
        /*LocalTime time = LocalTime.now();
        System.out.println("local time now : " + time);*/

        //增加时间里面的小时数
       /* LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(2); // adding two hours
        System.out.println("Time after 2 hours : " + newTime);*/

       //获取1周后的日期
        /*LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Today is : " + today);
        System.out.println("Date after 1 week : " + nextWeek);*/

        //一年前后的日期
       /* LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
        System.out.println("Date before 1 year : " + previousYear);
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Date after 1 year : " + nextYear);*/

        //Java 8中使用时钟
        /*// Returns the current time based on your system clock and set to UTC.
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock);

        // Returns time based on system clock zone Clock defaultClock =
        Clock.systemDefaultZone();
        System.out.println("Clock : " + clock);*/

        //表示固定的日期，比如信用卡过期时间
        /*YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);*/

        //在Java 8中检查闰年
        /*if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println("2014 is not a Leap year");
        }*/

        //两个日期之间包含多少天，多少个月
        /*LocalDate today = LocalDate.now();
        System.out.println("today is :"+today);
        LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
        System.out.println("day is :"+java8Release);
        Period p =Period.between(today, java8Release);
        System.out.println("Months left between today and Java 8 release : " + p.getYears()+","+p.getMonths()+","+p.getDays());*/

        //获取当前时间戳
        /*Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);*/

        //使用预定义的格式器来对日期进行解析/格式化
        String dayAfterTommorrow = "20140116";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow,DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);





    }
}
