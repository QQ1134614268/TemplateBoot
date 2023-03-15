package com.it.jiangxin.controller.vo;

import com.it.jiangxin.entity.EnumEntity;
import com.it.jiangxin.entity.ImgEntity;
import lombok.Data;

import java.util.List;

@Data
public class ImgTreeDto extends EnumEntity {
    List<ImgEntity> imgEntityList;
}
