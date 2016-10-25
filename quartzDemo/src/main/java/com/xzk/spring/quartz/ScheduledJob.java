package com.xzk.spring.quartz;

import com.xzk.spring.scheduling.AnotherBean;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by XiaoZK on 2016/10/20.
 */
public class ScheduledJob extends QuartzJobBean {
    private AnotherBean anotherBean;

    public void setAnotherBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 任务执行的时间
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String jobRunTime = dateFormat.format(Calendar.getInstance().getTime());

        System.err.println("---" + jobExecutionContext.getJobDetail().getKey().getName() + " 在  : ["
                + jobRunTime + "] 执行了!!");

        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println("job名称:" + jobKey + " JobData = " + jobExecutionContext.getJobDetail().getJobDataMap().get("a"));
        System.out.println(jobExecutionContext.getTrigger().getKey());
        anotherBean.printAnotherMessage();

        long delay = 20000l;
        try {
            Thread.sleep(delay);
        } catch (Exception ignore) {
        }
    }

}
