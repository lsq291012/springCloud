package com.lsq.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * HelloService
 *
 * @author lsq
 * @date 2018/02/26
 **/
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

     @Autowired
      private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("service-ribbon");
        System.out.println("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":"
                + serviceInstance.getPort());// 打印当前调用服务的信息
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
        System.out.println(url);
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }
}