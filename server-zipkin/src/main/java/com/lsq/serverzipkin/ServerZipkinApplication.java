package com.lsq.serverzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * @author lsq
 */
@SpringBootApplication
@EnableZipkinServer
public class ServerZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerZipkinApplication.class, args);
    }
}
