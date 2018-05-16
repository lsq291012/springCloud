package com.lsq.sericefeign.service;

import org.springframework.stereotype.Service;

/**
 * SchedualServiceHiHystric
 *
 * @author lsq
 * @date 2018/02/26
 **/
@Service
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}