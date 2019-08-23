package com.changingfond.thread;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * @auther: fangchengjin_sx
 * @date: 2019/8/23 16:10
 * @description:
 */
public class ThreadLocalDemo {
    HashMap<String, Integer> map = new HashMap<String, Integer>(16);

    static ThreadLocal<DateFormat> safeSdf = new ThreadLocal<DateFormat>() {
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.println(safeSdf.get().parse("2017-12-13 10:23:12"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.println(sdf.parse("2017-12-13 10:23:12"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
