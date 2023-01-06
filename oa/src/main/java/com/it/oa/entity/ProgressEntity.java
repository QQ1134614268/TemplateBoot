package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

@ApiModel("客户管理/客户列表/跟进记录")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "progress")
@Entity(name = "progress")
@Table(appliesTo = "progress", comment = "客户管理/客户列表/跟进记录")
public class ProgressEntity extends BaseEntity {
    @ApiModelProperty(value = "跟进客户id", example = "858540281", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '跟进客户id'")
    private Integer customerId;
    @ApiModelProperty(value = "跟进员工Id", example = "497768827", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '跟进员工Id'")
    private Integer userId;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "员工姓名", example = "test_1", required = true)
    private String staffName;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "员工头像", example = "test_1", required = true)
    private String avatar;

    @ApiModelProperty(value = "进度", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '进度'")
    private String progress;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "附件list", example = "[]", required = false)
    private List<ProgressFileEntity> list;
}