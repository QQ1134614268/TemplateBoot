package com.it.boot.entity.qo;

import com.it.boot.entity.LogEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class LogQo extends LogEntity {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}