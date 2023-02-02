package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@ApiModel(value = "系统管理/系统设置/操作日志")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "operation_log")
@Entity(name = "operation_log")
@Table(appliesTo = "operation_log", comment = "系统管理/系统设置/操作日志")
public class OperationLogEntity extends BaseEntity {
    @ApiModelProperty(value = "ID", example = "740991592", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT 'ID'")
    private Integer userId;
    @ApiModelProperty(value = "操作用户", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '操作用户'")
    private String userName;
    @ApiModelProperty(value = "行为", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '行为'")
    private String action;
    @ApiModelProperty(value = "链接", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '链接'")
    private String urlLink;
    @ApiModelProperty(value = "登陆终端", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '登陆终端'")
    private String loginTerminal;
    @ApiModelProperty(value = "操作IP", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '操作IP'")
    private String ip;
    @ApiModelProperty(value = "操作时间", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '操作时间'")
    private Date operationTime;
}