package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "人事管理/组织架构/企业邀请")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "invite")
@Entity(name = "invite")
@Table(appliesTo = "invite", comment = "人事管理/组织架构/企业邀请")
public class InviteEntity extends BaseEntity {
    @ApiModelProperty(value = "公司Id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '附件'")
    private Integer companyId;
    @ApiModelProperty(value = "邀请类型(链接|用户名手机号|精确id)", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '邀请类型'")
    private Integer type;

    @ApiModelProperty(value = "被邀请的用户", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '被邀请的用户'")
    private Integer userId;

    @ApiModelProperty(value = "是否需要审核", example = "-603519708", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "bit(1) COMMENT '是否同意'")
    private Boolean isCheck;

    @ApiModelProperty(value = "用户是否同意", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '是否同意'")
    private String status;

    @ApiModelProperty(value = "加入部门的id", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '是否同意'")
    private String orgId;

}