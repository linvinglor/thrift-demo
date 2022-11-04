package com.demo;

import com.demo.HelloService;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.*;

public class HelloServiceClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 5001;//Thrift server listening port
    private static final int TIMEOUT = 3000;

    private void startClient(String userName) {
        TTransport transport = null;
        try {
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
            // The agreement should be consistent with the server.
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloService.Client client = new HelloService.Client(protocol);
            transport.open();
            System.out.println(client.getName(1));
            System.out.println(client.isExist(userName));
            System.out.println(userName);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    public static void main(String[] args) {
        HelloServiceClient client = new HelloServiceClient();
        client.startClient("YINGLIN");
    }

}