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
import java.util.Date;
import java.util.List;

@ApiModel(value = "客户管理/客户列表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "customer")
@Entity(name = "customer")
@Table(appliesTo = "customer", comment = "客户管理/客户列表")
public class CustomerEntity extends BaseEntity {
    @ApiModelProperty(value = "客户名称", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '客户名称'")
    private String customerName;
    @ApiModelProperty(value = "客户来源Id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '客户来源'")
    private Integer customerFromId;
    @ApiModelProperty(value = "联系电话", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '联系电话'")
    private String phone;
    @ApiModelProperty(value = "邮箱", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '邮箱'")
    private String email;

    @ApiModelProperty(value = "客户分类id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '客户分类id'")
    private Integer typeId;
    @ApiModelProperty(value = "省份")
    private String province;
    @ApiModelProperty(value = "城市")
    private String city;
    @ApiModelProperty(value = "县")
    private String area;
    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "备注", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;
    @ApiModelProperty(value = "负责人id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '负责人id'")
    private Integer chargePersonId;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "负责人", example = "test_1", required = false)
    private String chargePerson;
    @ApiModelProperty(value = "成交状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '成交状态'")
    private String status;
    @ApiModelProperty(value = "是否关注", example = "-797690037", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "bit(1) COMMENT '是否关注'")
    private Boolean isFollow;

    // @ApiModelProperty(value = "客户标签", example = "test_1", required = false)
    // @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '客户标签'")
    // private String tagIds;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "客户标签", example = "1", required = false)
    private List<EnumEntity> tags; // 客户 标签(label)  客户标签
    //
    // @Transient
    // @TableField(exist = false)
    // @ApiModelProperty(value = "客户标签", example = "1", required = false)
    // private List<EnumEntity> delTags;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "客户分类", example = "1", required = false)
    private String typeName;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "客户来源", example = "1", required = false)
    private String customerFrom;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "最后跟进时间", example = "1", required = false)
    private Date lastProcessTime;
}