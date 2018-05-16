package com.lsq.sericefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author lsq
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //加上@EnableFeignClients注解开启Feign的功能
/*//加上一下两个注解 才能使用 Hystrix Dashboard
@EnableHystrixDashboard
@EnableCircuitBreaker*/
public class SericeFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SericeFeignApplication.class, args);
    }
}
