package com.xzk.spring.scheduling;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by XiaoZK on 2016/10/20.
 */
@Component
public class MyBean {
    public void printMessage() {
        System.out.println("I am called by MethodInvokingJobDetailFactoryBean using SimpleTriggerFactoryBean"+ new Date());
    }
}
