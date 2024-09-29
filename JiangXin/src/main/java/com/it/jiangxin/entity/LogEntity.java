package com.it.jiangxin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Schema(name = "部门")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "log")
@Entity(name = "log")
@Table(appliesTo = "log", comment = "日志")
public class LogEntity extends BaseEntity {
    @Schema(name = "备注", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '备注'")
    private String title;
    @Schema(name = "类型", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '类型'")
    private String type;
    @Schema(name = "请求地址", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '请求地址'")
    private String urlLink;
    @Schema(name = "ip", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT 'ip'")
    private String ip;
    @Schema(name = "用户名称", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '用户名称'")
    private String userName;
}
