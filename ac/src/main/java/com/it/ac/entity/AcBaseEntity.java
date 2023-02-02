package com.it.ac.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class AcBaseEntity {
    @Column(isKey = true, isAutoIncrement = true, comment = "主键id")
    private Integer id;
}


