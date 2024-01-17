package com.it.ac.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class BaseTableEntity implements Serializable {
    @Id
    @Column(isKey = true, isAutoIncrement = true, comment = "主键id")
    private Long id;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    @Column(comment = "创建者")
    private Long createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    @Column(type = MySqlTypeConstant.DATETIME, comment = "创建时间", defaultValue = "CURRENT_TIMESTAMP")
    private Date createTime;

    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者")
    @Column(comment = "更新者")
    private Long updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    @Column(type = MySqlTypeConstant.DATETIME, comment = "更新时间", defaultValue = "CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateTime;

}
