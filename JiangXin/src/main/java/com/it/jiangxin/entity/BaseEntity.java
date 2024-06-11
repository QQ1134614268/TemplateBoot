package com.it.jiangxin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.it.jiangxin.util.JwtUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // 主键生成策略,自增
    @TableId(type = IdType.AUTO)
    @Column(columnDefinition = "int(11) COMMENT '主键'")
    @Schema(name = "对象id", example = "1")
    private Integer id;
    @Column( columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    @Schema(name = "创建时间", example = "2022-02-02 10:10:10",  hidden = true)
    private LocalDateTime createTime;
    @Column( columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'")
    @Schema(name = "修改时间", example = "1",  hidden = true)
    private LocalDateTime updateTime;
    @Column( columnDefinition = "int(11) COMMENT '创建者id'")
    @Schema(name = "创建者id", example = "1",  hidden = true)
    private Integer createBy;
    @Column( columnDefinition = "int(11) COMMENT '修改者id'")
    @Schema(name = "修改者id", example = "1",  hidden = true)
    private Integer updateBy;

    public void setCreate() {
        this.setCreateBy(JwtUtil.getUserId());
        this.setUpdateBy(JwtUtil.getUserId());
    }

    public void setUpdate() {
        this.setUpdateBy(JwtUtil.getUserId());
    }

    // private BaseEntity() {
    //     setCreate(); //  undo
    // }
}

