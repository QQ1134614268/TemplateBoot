package com.it.jiangxin.entity.vo;

import com.it.jiangxin.entity.SysEnumEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysEnumQo extends SysEnumEntity {
    private LocalDateTime startTime;
    private Date endTime;
}
