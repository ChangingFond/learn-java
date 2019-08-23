package com.changingfond.designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther: fangchengjin_sx
 * @date: 2019/8/22 21:31
 * @description:
 */

public class Proxy {
    public static void main(String[] args) {
        System.out.println("***** 静态代理 *****");
        ISay person = new Person();
        ISay proxy = new PersonProxy(person);
        proxy.sayHello();

        System.out.println("***** 动态代理 Person *****");
        InvocationHandler handler = new DynamicProxyHandler(person);
        ISay dynamicProxy = (ISay) java.lang.reflect.Proxy.newProxyInstance(Person.class.getClassLoader(),
                Person.class.getInterfaces(), handler);
        dynamicProxy.sayHello();

        System.out.println("***** 动态代理 PersonB *****");
        ISay personB = new PersonB();
        handler = new DynamicProxyHandler(personB);
        dynamicProxy = (ISay) java.lang.reflect.Proxy.newProxyInstance(PersonB.class.getClassLoader(),
                PersonB.class.getInterfaces(), handler);
        dynamicProxy.sayHello();

    }
}


interface ISay {
    void sayHello();
}

class Person implements ISay {

    public void sayHello() {
        System.out.println("A say hello!");
    }
}

class PersonB implements ISay {

    public void sayHello() {
        System.out.println("B say hello!");
    }
}

// 静态代理
class PersonProxy implements ISay {

    private ISay person;

    public PersonProxy(ISay person) {
        this.person = person;
    }

    public void sayHello() {
        System.out.println("before A say hello");
        person.sayHello();
        System.out.println("after A say hello");
    }
}

// 动态代理
class DynamicProxyHandler implements InvocationHandler {

    private Object object;

    public DynamicProxyHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(object, args);
        return result;
    }
}

