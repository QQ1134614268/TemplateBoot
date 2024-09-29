package com.it.jiangxin.entity.vo;

import com.it.jiangxin.entity.LogEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class LogQo extends LogEntity {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}