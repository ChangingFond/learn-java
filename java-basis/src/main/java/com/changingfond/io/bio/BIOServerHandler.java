package com.changingfond.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @auther: fangchengjin_sx
 * @date: 2019/8/21 12:50
 * @description:
 */
public class BIOServerHandler implements Runnable {

    private Socket socket;

    public BIOServerHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));  // 阻塞
            writer = new PrintWriter(this.socket.getOutputStream(), true);  // 阻塞
            String body = null;
            while (true) {
                body = reader.readLine();
                if (null == body) {
                    break;
                }
                System.out.println("server 端接受参数" + body);
                writer.println(body + "=" + body);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                writer.close();
            }
            try {
                if (null != reader) {
                    reader.close();
                }
                if (null != this.socket) {
                    this.socket.close();
                    this.socket = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
