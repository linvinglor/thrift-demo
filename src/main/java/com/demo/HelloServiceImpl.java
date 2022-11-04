package com.demo;

import com.demo.HelloService;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloServiceImpl implements HelloService.Iface {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static String LINYING = "LINYING";

    @Override
    public String getName(int id) throws TException {
        logger.info("received getName, id = {}:", id);
        return LINYING;
    }

    @Override
    public boolean isExist(String name) throws TException {
        logger.info("receive isExist, name = {}", name);
        return LINYING.equals(name);
    }
}
