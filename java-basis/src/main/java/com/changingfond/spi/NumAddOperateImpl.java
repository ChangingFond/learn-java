package com.changingfond.spi;

public class NumAddOperateImpl implements INumOperate {

    @Override
    public int exec(int num1, int num2) {
        return num1 + num2;
    }
}
