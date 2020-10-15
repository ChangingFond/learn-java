package com.changingfond.jetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.NetworkTrafficServerConnector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.BlockingArrayQueue;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Jetty {
    public static void main(String[] args) throws Exception {
        Server server = initJettyServer();

        ServletContextHandler contextHandler = new ServletContextHandler(
                ServletContextHandler.SESSIONS
        );
        contextHandler.setContextPath("/");
        server.setHandler(contextHandler);

        // http://localhost:31100/hello
        contextHandler.addServlet(new ServletHolder(new HelloServlet()), "/hello");

        server.start();
        server.join();
    }

    private static Server initJettyServer() {
        QueuedThreadPool queuedThreadPool = new QueuedThreadPool(
            10, 10, 60000, new BlockingArrayQueue(10000));
        HttpConfiguration httpConfiguration = new HttpConfiguration();
        httpConfiguration.setRequestHeaderSize(20480);

        Server server = new Server(queuedThreadPool);
        Executor executors = Executors.newFixedThreadPool(3);
        ServerConnector serverConnector = new NetworkTrafficServerConnector(server, executors, null, null, 1, 2,
            new HttpConnectionFactory(httpConfiguration));
        // 如果不提供 executors 参数，acceptors 和 selectors 需要的线程会和 workers 线程共享线程池，
        // 最终实际运行的 workers 线程数将会偏小。
        // ServerConnector serverConnector = new ServerConnector(
        // server, new HttpConnectionFactory(httpConfiguration));
        serverConnector.setHost("0.0.0.0");
        serverConnector.setPort(31100);
        serverConnector.setAcceptQueueSize(10000);
        server.setConnectors(new Connector[] { serverConnector });

        return server;
    }

}
