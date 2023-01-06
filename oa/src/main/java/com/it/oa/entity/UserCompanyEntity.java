package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "用户公司关系")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user_company")
@Entity(name = "user_company")
@Table(appliesTo = "user_company", comment = "用户公司关系")
public class UserCompanyEntity extends BaseEntity {
    @ApiModelProperty(value = "系统用户Id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '系统用户Id'")
    private Integer systemUserId;
    @ApiModelProperty(value = "公司id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '公司id'")
    private Integer companyId;
}