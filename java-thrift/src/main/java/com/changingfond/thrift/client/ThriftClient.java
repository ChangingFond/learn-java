package com.changingfond.thrift.client;

import com.changingfond.thrift.service.HelloService;
import com.changingfond.thrift.service.User;
import com.changingfond.thrift.service.Response;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * 客户端编码基本步骤：
 * 1. 创建 Transport
 * 2. 创建 Protocol
 * 3. 基于 Protocol 创建 Client
 * 4. 打开 Transport
 * 5. 远程服务调用
 * 6. 关闭 Transport
 */
public class ThriftClient {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 31001;
    private static final int TIMEOUT = 30000;

    public static void main(String[] args) {

        try {
            // 传输层
            TTransport transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);

            // 协议层
            TProtocol protocol = new TBinaryProtocol(transport);

            // 创建 RPC 客户端
            HelloService.Client client = new HelloService.Client(protocol);

            // 打开 socket
            transport.open();

            // 调用服务
            User user = new User();
            user.id = 1;
            user.name = "test";
            user.age = 24;
            user.address = "address";
            user.mobile = "123456";
            System.out.println(client.SayHello(user).toString());

            Response response = client.GetUser(0);
            System.out.println(response.toString());

            // 关闭 socket
            transport.close();

        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
