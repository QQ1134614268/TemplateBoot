package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;

@ApiModel(value = "人事管理/组织架构/用户组织关系")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user_org")
@Entity(name = "user_org")
@Table(appliesTo = "user_org", comment = "人事管理/组织架构/用户组织关系")
@javax.persistence.Table(indexes = {@Index(columnList = "userId,orgId", unique = true), @Index(columnList = "userId,isMainOrg", unique = true)})
public class UserOrgEntity extends BaseEntity {

    @ApiModelProperty(value = "员工id", example = "test_1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "int(11) COMMENT '员工id'")
    Integer userId;

    @ApiModelProperty(value = "组织Id", example = "test_1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "int(11) COMMENT '组织Id'")
    Integer orgId;

    @ApiModelProperty(value = "是否是主部门", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "bit(1) COMMENT '是否是主部门'")
    Boolean isMainOrg;
    // leader info
}