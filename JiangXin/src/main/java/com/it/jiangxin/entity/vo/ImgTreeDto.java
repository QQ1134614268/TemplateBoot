package com.it.jiangxin.entity.vo;

import com.it.jiangxin.entity.SysEnumEntity;
import com.it.jiangxin.entity.ImgEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ImgTreeDto extends SysEnumEntity {
    List<ImgEntity> imgEntityList;
}
