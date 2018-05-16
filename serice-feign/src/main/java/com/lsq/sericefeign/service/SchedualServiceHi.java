package com.lsq.sericefeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * SchedualServiceHi
 *
 * @author lsq
 * @date 2018/02/26
 **/
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystric.class)
//@FeignClient(value = "service-hi")  //通过@ FeignClient（“服务名”），来指定调用哪个服务
public interface SchedualServiceHi {

   // @RequestMapping(value = "/hi", method = RequestMethod.GET)
    @GetMapping(value = "/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}