package com.lsq.serverhi;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HiController
 *
 * @author lsq
 * @date 2018/03/27
 **/
@RestController
public class HiController {
    private static final Logger LOG = Logger.getLogger(ServerHiApplication.class.getName());

    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    public String home(@RequestParam String name) {
        LOG.log(Level.INFO, "hi is being called");
        return "hi " + name + ",i am from port:" + port;
    }
}