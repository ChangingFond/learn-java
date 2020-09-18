package com.changingfond.thrift.service;

import org.apache.thrift.TException;

import java.util.HashMap;
import java.util.Map;

public class HelloServiceImpl implements HelloService.Iface {

    @Override
    public Response SayHello(User user) throws TException {
        if (user != null) {
            Map<String, String> userMap = new HashMap<String, String>();
            userMap.put(user.name, user.toString());
            return new Response(0, "success", userMap);
        }
        return new Response(1, "no user", null);
    }

    @Override
    public Response GetUser(int id) throws TException {
        User user = new User();
        user.id = id;
        user.name = "test";
        user.age = 25;
        user.address = "address";
        user.mobile = "654321";
        Map<String, String> userMap = new HashMap<String, String>();
        userMap.put(user.name, user.toString());
        return new Response(0, "success", userMap);
    }
}
