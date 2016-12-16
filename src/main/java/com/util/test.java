package com.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class test {

    @Scheduled(fixedRate = 1000 * 20)
    public void taskCycle() {
        System.out.println("===============顶顶顶顶顶大大顶顶==========================a");
        System.out.println("===============顶顶顶顶顶顶顶顶的大顶顶顶顶顶顶顶顶==========================a");
        System.out.println("===============顶顶顶顶顶顶顶大大大大的顶顶顶顶顶顶顶顶顶==========================a");

    }
}