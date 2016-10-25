package com.xzk.spring.scheduling;

import org.springframework.stereotype.Component;

/**
 * Created by XiaoZK on 2016/10/20.
 */
@Component
public class AnotherBean {
    public void printAnotherMessage() {
        System.out.println("I am called by Quartz jobBean using CronTriggerFactoryBean");
    }
}
