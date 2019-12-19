package com.changingfond.exception;

import java.io.IOException;

public class ExceptionTryCatch {
    public void doSomething() throws IOException {
        System.out.println("do something");
    }
    public static void main(String[] args){
        ExceptionTryCatch etc = new ExceptionTryCatch();
        // 在写异常处理的时候，一定要把异常范围小的放在前面，范围大的放在后面
        try {
            etc.doSomething();
        } catch (IOException e) {

        } catch (Exception e) {

        }
    }

}
