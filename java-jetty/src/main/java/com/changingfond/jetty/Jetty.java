package com.changingfond.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Jetty {
    public static void main(String[] args) throws Exception {
        Server server = new Server(31100);

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

}
