package com.changingfond.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @auther: fangchengjin_sx
 * @date: 2019/8/21 12:25
 * @description: IO 也称为 BIO，Block IO 阻塞同步的通讯方式
 * 比较传统的技术，实际开发中基本上用Netty或者是AIO。熟悉BIO，NIO，体会其中变化的过程。作为一个web开发人员，socket通讯面试经常问题。
 * BIO最大的问题是：阻塞，同步。
 * BIO通讯方式很依赖于网络，若网速不好，阻塞时间会很长。每次请求都由程序执行并返回，这是同步的缺陷。
 * BIO工作流程：
 * 第一步：server端服务器启动
 * 第二步：server端服务器阻塞监听client请求
 * 第三步：server端服务器接收请求，创建线程实现任务
 */
public class BIOServer {

    private static final Integer port = 8888;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        ThreadPoolExecutor executor = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("BIO Server 服务器启动……");
//            while (true) {
//                socket = serverSocket.accept();
//                System.out.println("server 确认请求" + socket);
//                // 服务器连接确认：确认Client请求后，创建线程执行任务。很明显的问题，若每接收一次请求就要创建一个线程，显然是不合理的。
//                new Thread(new Runnable() {
//                    public void run() {
//
//                    }
//                }).start();
//            }

            // 改用线程池
            executor = new ThreadPoolExecutor(10, 100, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(50));
            while (true) {
                socket = serverSocket.accept(); // 阻塞方法
                executor.execute(new BIOServerHandler(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != socket) {
                    socket.close();
                    socket = null;
                }
                if (null != serverSocket) {
                    serverSocket.close();
                    serverSocket = null;
                    System.out.println("BIO Server 服务器关闭了！！！！");
                }
                executor.shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
