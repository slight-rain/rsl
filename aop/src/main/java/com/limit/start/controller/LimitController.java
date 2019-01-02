package com.limit.start.controller;

import com.limit.start.annotation.Limit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class LimitController {
    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();
    @RequestMapping(value="/test",method= RequestMethod.GET)
    @Limit(key="test",name="resource",period=100,count=20,prefix = "limit")
    public int hello(){
        return ATOMIC_INTEGER.incrementAndGet();
    }
}
