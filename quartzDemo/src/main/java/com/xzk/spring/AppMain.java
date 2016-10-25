package com.xzk.spring;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by XiaoZK on 2016/10/20.
 */
public class AppMain {
    @Autowired
    private static SchedulerFactoryBean schedulerFactoryBean;
    @Autowired
    private static JobDetail complexJobDetail;

    public static void setSchedulerFactoryBean(SchedulerFactoryBean schedulerFactoryBean) {
        AppMain.schedulerFactoryBean = schedulerFactoryBean;
    }

    public static void main(String args[]) throws SchedulerException, ParseException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("quartz-context.xml");
//        complexJobDetail = JobBuilder.newJob(ScheduledJob.class).withIdentity("jobName2", "group233").storeDurably(true).build();

//        Trigger trigger = newTrigger()
//                .withIdentity("triggerName", "group12")
//                .withSchedule(simpleSchedule()
//                        .withIntervalInSeconds(2)
//                        .withRepeatCount(2)
//                        .repeatForever()
//                )
//                .startNow()
//                .build();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");

        complexJobDetail = (JobDetail) context.getBean("complexJobDetail");

//        complexJobDetail.getJobBuilder().usingJobData(StatefulDumbJob);
//        complexJobDetail.getJobDataMap().put("a", "12");

        CronTriggerImpl cronTrigger = new CronTriggerImpl();
        TriggerKey key = new TriggerKey("triggerName", "group222933");
        cronTrigger.setCronExpression("0/10 * * ? * MON-FRI");
        cronTrigger.setKey(key);
        cronTrigger.setJobName(complexJobDetail.getKey().getName());

        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        try {
            scheduler.addJob(complexJobDetail, true);
            Date ft = scheduler.scheduleJob(cronTrigger);
//            scheduler.scheduleJob(complexJobDetail, cronTrigger);
            scheduler.start();

            System.out.println(complexJobDetail.getKey().getName() + " 将在: " + dateFormat.format(ft)
                    + "  时运行");
//            Thread.sleep(20L*1000);
//
//            scheduler.shutdown(false);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
