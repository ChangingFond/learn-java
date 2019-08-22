package com.changingfond.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @auther: fangchengjin_sx
 * @date: 2019/8/22 20:47
 * @description:
 */
public class HelloClassLoader extends ClassLoader {

    private String classpath;

    public HelloClassLoader(String classpath) {
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = classpath + File.separatorChar +
                name.replace('.', File.separatorChar) + ".class";
        // name = 包名+类名
        try {
            FileInputStream inputStream = new FileInputStream(path);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            int len = 0;
            try {
                while ((len = inputStream.read()) != -1) {
                    byteArrayOutputStream.write(len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            byte[] data = byteArrayOutputStream.toByteArray();
            inputStream.close();
            byteArrayOutputStream.close();

            //defineClass方法将字节码转化为类
            return this.defineClass(name, data, 0, data.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

}
