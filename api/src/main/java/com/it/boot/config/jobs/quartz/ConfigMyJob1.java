package com.it.boot.config.jobs.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.util.Date;

@Slf4j
@Configuration
public class ConfigMyJob1 {
    // MyJob1任务配置
    @Bean
    MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean() {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        // bean.setTargetClass(MyJob1.class);
        bean.setTargetBeanName("myJob1"); // 首字母小写
        bean.setTargetMethod("myTask1");
        return bean;
    }

    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setStartTime(new Date());
        // bean.setRepeatCount(10);
        bean.setRepeatInterval(600000);
        bean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        return bean;
    }
}