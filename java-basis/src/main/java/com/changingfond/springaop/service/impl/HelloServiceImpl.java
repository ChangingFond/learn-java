package com.changingfond.springaop.service.impl;

import com.changingfond.springaop.service.HelloService;

public class HelloServiceImpl implements HelloService {

    public void sayHello(String name) {
        if (name == null || name.trim() == "") {
            throw new RuntimeException ("parameter is null!");
        }
        System.out.println("hello " + name);
    }
}
