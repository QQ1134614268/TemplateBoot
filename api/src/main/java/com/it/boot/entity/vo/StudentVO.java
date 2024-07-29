package com.it.boot.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.it.boot.config.enum1.ResCodeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
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

  @Schema(name = "名称", example = "名称1")
  private String name;

  @JsonFormat(pattern = DATE_FORMAT)
  @Schema(name = "生日", example = "2000-01-01")
  private Date birthday;

  @Schema(name = "test数组", example = "[1,2]")
  private int[] score;

  @Schema(name = "list", example = "[\"a1\",\"a2\"]")
  private List<String> nameList;

  @Schema(name = "枚举", example = "RES_SUCCESS")
  private ResCodeEnum resCodeEnum;

  @Schema(name = "地址")
  private Address address;
}
