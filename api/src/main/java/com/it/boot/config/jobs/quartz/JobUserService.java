package com.it.boot.config.jobs.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JobUserService {

    public String getUserById(Long id) {
        return "UserService get data:" + id;
    }
}