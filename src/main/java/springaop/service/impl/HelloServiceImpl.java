package springaop.service.impl;

import springaop.service.HelloService;

public class HelloServiceImpl implements HelloService {

    public void sayHello(String name) {
        if (name == null || name.trim() == "") {
            throw new RuntimeException ("parameter is null!");
        }
        System.out.println("hello " + name);
    }
}
