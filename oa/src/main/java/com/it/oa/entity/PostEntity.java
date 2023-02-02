package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "人事管理/职位管理/职位管理")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "post")
@Entity(name = "post")
@Table(appliesTo = "post", comment = "人事管理/职位管理/职位管理")
public class PostEntity extends BaseEntity {
    @ApiModelProperty(value = "职位名称", example = "test_1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '职位名称'")
    private String postName;
    @ApiModelProperty(value = "职级类别id", example = "1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '职级类别id'")
    private Integer postLevelTypeId;
    @ApiModelProperty(value = "职级id", example = "1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '职级id'")
    private Integer postLevelId;
    @ApiModelProperty(value = "工作描述", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '工作描述'")
    private String description;
    @ApiModelProperty(value = "工作职责", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '工作职责'")
    private String postDuty;

    @ApiModelProperty(value = "在职人数", example = "0", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) default 0 COMMENT '在职人数'")
    private Integer postNum;
}