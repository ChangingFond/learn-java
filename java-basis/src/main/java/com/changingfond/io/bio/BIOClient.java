package com.changingfond.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 * @auther: fangchengjin_sx
 * @date: 2019/8/21 12:57
 * @description:
 */
public class BIOClient {

    private static final Integer port = 8888;

    private static String url = "127.0.0.1";

    public static void main(String[] args) {
        for (int i = 0; i < 10; i ++) {
            request(i);
        }
    }

    private static void request(int i) {
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            socket = new Socket(url, port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(new Random(System.currentTimeMillis()).nextInt());
            System.out.println(i + "客户端打印返回数据" + reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }
                if (null != socket) {
                    socket.close();
                    socket = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
