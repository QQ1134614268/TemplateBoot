package com.it.boot.config.log;

import com.baomidou.mybatisplus.annotation.TableName;
import com.it.boot.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Schema(name = "系统管理/系统设置/操作日志")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "operation_log")
@Entity(name = "operation_log")
@Table(appliesTo = "operation_log", comment = "系统管理/系统设置/操作日志")
public class OperationLogEntity extends BaseEntity {
    @Schema(name = "ID", example = "740991592")
    @Column(columnDefinition = "int(11) COMMENT 'ID'")
    private Long userId;
    @Schema(name = "操作用户", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '操作用户'")
    private String userName;
    @Schema(name = "行为", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '行为'")
    private String action;
    @Schema(name = "链接", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '链接'")
    private String urlLink;
    @Schema(name = "登陆终端", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '登陆终端'")
    private String loginTerminal;
    @Schema(name = "操作IP", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '操作IP'")
    private String ip;
    @Schema(name = "操作时间", example = "test_1")
    @Column(columnDefinition = "datetime COMMENT '操作时间'")
    private Date operationTime;
}