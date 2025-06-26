package com.it.boot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

@Schema(title = "测试缓存")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "cache")
@Entity(name = "cache")
@Table(appliesTo = "cache", comment = "测试缓存")
public class CacheEntity extends BaseEntity {

    @Pattern(regexp = "^.{1,20}$", message = "字符长度为1-20个")
    @Column(columnDefinition = "varchar(255) COMMENT 'value'")
    @Schema(title = "value", example = "123")
    private String value;
}