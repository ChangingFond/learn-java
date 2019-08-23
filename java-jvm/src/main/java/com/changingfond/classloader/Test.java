package com.changingfond.classloader;

import java.lang.reflect.Method;

/**
 * @auther: fangchengjin_sx
 * @date: 2019/8/22 20:03
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        ClassLoader classLoader = Test.class.getClassLoader();
        ClassLoader classLoader1 = classLoader.getParent();
        ClassLoader classLoader2 = classLoader1.getParent();

        System.out.println(classLoader);
        System.out.println(classLoader1);
        System.out.println(classLoader2);

        // 自定义类加载器的加载路径
        HelloClassLoader helloClassLoader = new HelloClassLoader("E:\\learn-java\\java-jvm\\src\\main\\java");
        try {
            // 包名+类名
            Class c = helloClassLoader.loadClass("com.changingfond.classloader.Hello");
            System.out.println(c.getClassLoader().toString());
            if (c != null) {
                try {
                    Object obj = c.newInstance();
                    Method method = c.getDeclaredMethod("sayHello", null);
                    //通过反射调用Hello类的sayHello方法
                    method.invoke(obj, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}