// package com.jiangxin.web.entity;
//
// import com.baomidou.mybatisplus.annotation.TableName;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
// import lombok.Data;
// import lombok.EqualsAndHashCode;
// import org.hibernate.annotations.Table;
//
// import javax.persistence.Column;
// import javax.persistence.Entity;
//
// @ApiModel(value = "分组设置")
// @Data
// @EqualsAndHashCode(callSuper = true)
// @TableName(value = "img")
// @Entity(name = "img")
// @Table(appliesTo = "img", comment = "分组设置")
// public class ImgTypeEntity extends BaseEntity {
//     @ApiModelProperty(value = "唯一编码", example = "test_1", required = true)
//     @Column(unique = true, nullable = false, columnDefinition = "varchar(64) COMMENT '唯一编码'")
//     private String uniqueCode;
// }