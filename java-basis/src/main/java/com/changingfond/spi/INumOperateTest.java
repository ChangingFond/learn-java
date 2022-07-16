package com.changingfond.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

import sun.misc.Service;

public class INumOperateTest {

    public static void main(String[] args) {
        // SPI机制，寻找所有的实现类，顺序执行
        ServiceLoader<INumOperate> loader = ServiceLoader.load(INumOperate.class);
        Iterator<INumOperate> iterator = loader.iterator();
        // Iterator<INumOperate> iterator = Service.providers(INumOperate.class);
        while (iterator.hasNext()) {
            INumOperate numOperate = iterator.next();
            System.out.println(numOperate.exec(1, 2));
        }
    }
}
