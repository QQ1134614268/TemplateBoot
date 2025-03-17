package com.it.ac.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.it.ac.entity.dto.Address;
import lombok.Data;

import java.util.List;

@Data
@Table(name = AcUserTableEntity.tableName, // actable 生成表
        isSimple = true,
        excludeFields = {"tableName", "typeName"},
        comment = "用户表",
        engine = MySqlEngineConstant.InnoDB,
        charset = MySqlCharsetConstant.UTF8MB4)
@TableName(value = AcUserTableEntity.tableName, autoResultMap = true) // mybatis
public class AcUserTableEntity extends AcBaseEntity {
    public static final String tableName = "ac_user";

    @Column(comment = "账号")
    private String userAccount;

    @Column(comment = "密码")
    private String userPassword;

    @Column(comment = "用户类型id(1: v1, 2: v2)")
    private String typeId;

    @Column(comment = "用户类型名称")
    private String typeName;

    @TableField(typeHandler = JacksonTypeHandler.class)
    @Column(type= MySqlTypeConstant.JSON, comment = "地址json" )
    private List<Address> gson;
}


