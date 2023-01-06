package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "个人办公/记事本/文件夹")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "note_book_dic")
@Entity(name = "note_book_dic")
@Table(appliesTo = "note_book_dic", comment = "个人办公/记事本/文件夹")
public class NoteBookDicEntity extends BaseEntity {
    @ApiModelProperty(value = "父级文件夹id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '父级文件夹id'")
    private Integer parentId;
    @ApiModelProperty(value = "文件夹名", example = "72260227", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '文件夹名'")
    private String fileName;
    @ApiModelProperty(value = "文件夹层级", example = "72260227", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '文件夹层级'")
    private Integer level;
}