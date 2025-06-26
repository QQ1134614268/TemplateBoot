package com.it.ac.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseTableEntity implements Serializable {
    @Id
    @Column(isKey = true, isAutoIncrement = true, comment = "主键id")
    private Long id;

    /**
     * 创建者
     */
    @Schema(title = "创建者")
    @Column(comment = "创建者")
    private Long createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(title = "创建时间")
    @Column(type = MySqlTypeConstant.DATETIME, comment = "创建时间", defaultValue = "CURRENT_TIMESTAMP")
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    @Schema(title = "更新者")
    @Column(comment = "更新者")
    private Long updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(title = "更新时间")
    @Column(type = MySqlTypeConstant.DATETIME, comment = "更新时间", defaultValue = "CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updateTime;

}
