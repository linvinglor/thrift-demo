package com.demo;

import com.demo.HelloServiceImpl;
import com.demo.HelloService;

//import org.apache.thrift.TProcessorFactory;
//import org.apache.thrift.protocol.TCompactProtocol;
//import org.apache.thrift.server.THsHaServer;
//import org.apache.thrift.server.TServer;
//import org.apache.thrift.transport.TNonblockingServerSocket;
//import org.apache.thrift.transport.TTransportException;
//import org.apache.thrift.transport.layered.TFramedTransport;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloServiceServer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final int SERVER_PORT = 5001;//Thrift server listening port
    private void startServer() {
        HelloService.Processor processor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
        try {
            TServerTransport transport = new TServerSocket(SERVER_PORT);
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
            tArgs.processor(processor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            tArgs.transportFactory(new TTransportFactory());
            tArgs.minWorkerThreads(10);
            tArgs.maxWorkerThreads(20);
            TServer server = new TThreadPoolServer(tArgs);
            System.out.printf("server start success with port %s!", SERVER_PORT);
            server.serve();
        } catch (Exception e) {
            logger.error("thrift fail", e);
        }
    }

    public static void main(String[] args) {
        HelloServiceServer server = new HelloServiceServer();
        server.startServer();
    }

}
