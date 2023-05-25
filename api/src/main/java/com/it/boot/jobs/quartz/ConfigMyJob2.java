package com.it.boot.jobs.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

import javax.annotation.Resource;

@Slf4j
@Configuration
public class ConfigMyJob2 {
    @Resource
    private JobUserService jobUserService;
    // MyJob2任务配置
    // 传参
    @Bean
    JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(MyJob2.class);
        JobDataMap map = new JobDataMap();
        map.put("userService", jobUserService);
        map.put("id", 101);
        bean.setJobDataMap(map);
        return bean;
    }
    //
    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean() {
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setCronExpression("0 */5 * * * ?");
        bean.setJobDetail(jobDetailFactoryBean().getObject());
        return bean;
    }
}