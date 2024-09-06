package com.it.jiangxin.entity.vo;

import com.it.jiangxin.entity.ImgEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ImgDto extends ImgEntity {
    private String userAvtar;
    private String userName;
    private String nickName;
}
