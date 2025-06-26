package com.it.boot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Schema(title = "日志")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "log")
@Entity(name = "log")
@Table(appliesTo = "log", comment = "日志")
public class LogEntity extends BaseEntity {
    @Schema(title = "备注", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '备注'")
    private String title;
    @Schema(title = "类型", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '类型'")
    private String type;
    @Schema(title = "请求地址", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '请求地址'")
    private String urlLink;
    @Schema(title = "ip", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT 'ip'")
    private String ip;
    @Schema(title = "用户名称", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '用户名称'")
    private String userName;
}
