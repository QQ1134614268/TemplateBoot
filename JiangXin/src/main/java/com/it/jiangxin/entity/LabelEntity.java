package com.it.jiangxin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Schema(name = "分组设置")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "label")
@Entity(name = "label")
@Table(appliesTo = "label", comment = "label")
public class LabelEntity extends BaseEntity {

    @Schema(name = "值", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '标签'")
    private String label;

}
