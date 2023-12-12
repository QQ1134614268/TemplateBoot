package com.it.boot.jobs.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
@Slf4j
public class MyJob2 extends QuartzJobBean {
    //    @Autowired  这里注入方式是不行的，报NPE
    private JobUserService jobUserService;

    @Autowired
    public void setUserService(JobUserService jobUserService) {
        this.jobUserService = jobUserService;
    }

    @Override
    protected void executeInternal(@NonNull JobExecutionContext jobExecutionContext) {
        log.info("MyJob2 任务开始 : " + LocalDateTime.now().toLocalTime() + "，线程：" + Thread.currentThread().getName());
        // 处理相应的注入service业务
        Long id = new Random().nextLong();
        String data = jobUserService.getUserById(id);
        log.info("result"+data);
    }
}