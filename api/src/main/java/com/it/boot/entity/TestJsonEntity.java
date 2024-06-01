package com.it.boot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.it.boot.config.mybatis.TestDtoJsonListTypeHandler;
import com.it.boot.entity.dto.AddressDtoJson;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Schema(name = "测试-json")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = TestJsonEntity.tableName, autoResultMap = true)
public class TestJsonEntity extends BaseEntity {
    public final static String tableName = "test_json";

    @TableField(typeHandler = JacksonTypeHandler.class)
    @Schema(name = "地址")
    private AddressDtoJson addressDtoJson;

    @TableField(typeHandler = JacksonTypeHandler.class)
    @Schema(name = "审批信息json")
    private List<String> names;

    @TableField(typeHandler = TestDtoJsonListTypeHandler.class)
    @Schema(name = "地址集合")
    private List<AddressDtoJson> addressDtoJsons;

}
