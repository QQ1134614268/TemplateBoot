package com.it.boot.config.jobs.quartz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.Resource;

@Configuration
public class QuartzConfig {
    @Resource
    ConfigMyJob1 configMyJob1;
    @Resource
    ConfigMyJob2 configMyJob2;


    // 添加 MyJob1和MyJob2的触发器
    @Bean
    SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(
                configMyJob2.cronTriggerFactoryBean().getObject(),
                configMyJob1.simpleTriggerFactoryBean().getObject()
        );
        return bean;
    }

}