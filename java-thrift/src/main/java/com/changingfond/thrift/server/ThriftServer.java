package com.changingfond.thrift.server;

import com.changingfond.thrift.service.HelloService;
import com.changingfond.thrift.service.HelloServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * 服务端编码基本步骤：
 * 1. 实现服务处理接口 ServiceImpl
 * 2. 创建 Transport
 * 3. 创建 Protocol
 * 4. 创建 Processor
 * 5. 创建 Server
 * 6. 启动 Server
 */
public class ThriftServer {

    private static final int SERVER_PORT = 31001;

    public static void main(String[] args) {

        try {
            // 传输层
            TServerSocket serverSocket = new TServerSocket(SERVER_PORT);

            // 协议层
            TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();

            // 处理层
            TProcessor processor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());

            // 服务层
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(serverSocket);
            tArgs.protocolFactory(protocolFactory);
            tArgs.processor(processor);
            TServer server = new TThreadPoolServer(tArgs);

            // 启动 Server
            server.serve();

        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

}
