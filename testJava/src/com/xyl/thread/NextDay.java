package com.xyl.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by meridian on 2018/11/14.
 */
public class NextDay {
    public static void main(String[] args) {
        System.out.println("--------------------->"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(getNextDay()));
        System.out.println("--------------------->");
    }
    public static Date getNextDay(){
        try {
            Thread.sleep(60*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Date();
    }
}
