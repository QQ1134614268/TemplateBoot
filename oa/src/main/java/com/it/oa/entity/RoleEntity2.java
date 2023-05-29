package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = RoleEntity2.tableName, autoResultMap = true)
// @com.gitee.sunchenbin.mybatis.actable.annotation.Table(name = RoleEntity2.tableName, isSimple = true,
// excludeFields = {"tableName", "typeName"})
public class RoleEntity2 extends BaseEntity {
    public static final String tableName = "role2";

    @ApiModelProperty(value = "身份名称", example = "-127623817", required = false)
    private String roleName;

    @ApiModelProperty(value = "启用状态", example = "-413844420", required = false)
    private Boolean isUse;

    @TableField(typeHandler = JacksonTypeHandler.class)
    @ApiModelProperty(value = "菜单", example = "test_1", required = false)
    // @com.gitee.sunchenbin.mybatis.actable.annotation.Column(type = MySqlTypeConstant.JSON, comment = "地址json")
    private List<String> menus;

    // @org.hibernate.annotations.Type(type = "json")
    // private List<String> menusList;
}
