package com.lsq.serverhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lsq
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class ServerHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerHiApplication.class, args);
    }


}
