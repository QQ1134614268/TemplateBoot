package com.it.boot.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.it.boot.config.enumeration.ResCodeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static com.it.boot.config.Conf.DATE_FORMAT;

// 前后台测试实体,包含复杂数据结构
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO extends BaseVO implements Serializable {

  @ApiModelProperty(value = "名称", example = "名称1")
  private String name;

  @JsonFormat(pattern = DATE_FORMAT)
  @ApiModelProperty(value = "生日", example = "2000-01-01")
  private Date birthday;

  @ApiModelProperty(value = "test数组", example = "[1,2]")
  private int[] score;

  @ApiModelProperty(value = "list", example = "[\"a1\",\"a2\"]")
  private List<String> nameList;

  @ApiModelProperty(value = "枚举", example = "RES_SUCCESS")
  private ResCodeEnum resCodeEnum;

  @ApiModelProperty(value = "地址", example = "")
  private Address address;
}
