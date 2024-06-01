package com.it.boot.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // 主键生成策略,自增
    @TableId(type = IdType.AUTO)
    @Column(columnDefinition = "int(11) COMMENT '主键'")
    @Schema(name = "对象id", example = "1")
    private Long id;

    @Column(columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    @Schema(name = "创建时间", example = "2022-02-02 10:10:10", hidden = true)
    private Date createTime;

    @Column(columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'")
    @Schema(name = "修改时间", example = "1", hidden = true)
    private Date updateTime;

    @Column(columnDefinition = "int(11) COMMENT '创建者id'")
    @Schema(name = "创建者id", example = "1", hidden = true)
    private Long createBy;

    @Column(columnDefinition = "int(11) COMMENT '修改者id'")
    @Schema(name = "修改者id", example = "1", hidden = true)
    private Long updateBy;

}

