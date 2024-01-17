package com.it.boot.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

@ApiModel(value = "测试逻辑删除")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "del_t")
@Entity(name = "del_t")
@Table(appliesTo = "del_t", comment = "测试逻辑删除")
public class DelFlagEntity extends BaseEntity {

    @Pattern(regexp = "^.{1,20}$", message = "字符长度为1-20个")
    @Column(columnDefinition = "varchar(255) COMMENT 'value'")
    @ApiModelProperty(value = "value", example = "123")
    private String value;

    @TableLogic(value = "0", delval = "1")
    @ApiModelProperty(value = "逻辑删除标记(0:未删除; 1:已删除)")
    private Integer delFlag;
}