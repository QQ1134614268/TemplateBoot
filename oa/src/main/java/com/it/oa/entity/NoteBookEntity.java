package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "个人办公/记事本")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "note_book")
@Entity(name = "note_book")
@Table(appliesTo = "note_book", comment = "个人办公/记事本")
public class NoteBookEntity extends BaseEntity {
    @ApiModelProperty(value = "标题", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '标题'")
    private String title;
    @ApiModelProperty(value = "内容", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '内容'")
    private String content;
    @ApiModelProperty(value = "父级文件夹id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '父级文件夹id'")
    private Integer parentId;
}